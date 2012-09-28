package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.security.AESUtil;
import com.baidu.android.common.security.Base64;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class a {
    private static volatile a b;
    public ArrayList a = new ArrayList();
    private Context c;

    private a(Context context) {
        this.c = context.getApplicationContext();
        b(this.c);
        String string = this.c.getSharedPreferences(this.c.getPackageName() + ".push_sync", 1).getString("r", "");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            ArrayList c = c(new String(AESUtil.decrypt("1234567890123456", Base64.decode(string.getBytes()))));
            if (c != null) {
                Iterator it = c.iterator();
                while (it.hasNext()) {
                    this.a.add((b) it.next());
                }
            }
        } catch (Exception e) {
            Log.e("ClientManager", e);
        }
    }

    public static a a(Context context) {
        if (b == null) {
            b = new a(context);
        }
        return b;
    }

    static String a(List list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return stringBuffer.toString();
            }
            b bVar = (b) list.get(i2);
            stringBuffer.append(bVar.a);
            stringBuffer.append(",");
            stringBuffer.append(bVar.b);
            stringBuffer.append(",");
            stringBuffer.append(bVar.c);
            if (i2 != list.size() - 1) {
                stringBuffer.append(";");
            }
            i = i2 + 1;
        }
    }

    private static String b(Context context) {
        String string;
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + ".push_sync", 1);
        if ("nodata".equals(sharedPreferences.getString("r", "nodata"))) {
            for (ResolveInfo resolveInfo : context.getPackageManager().queryBroadcastReceivers(new Intent("com.baidu.android.pushservice.action.BIND_SYNC"), 0)) {
                b bVar = new b();
                bVar.a = resolveInfo.activityInfo.packageName;
                try {
                    string = context.createPackageContext(bVar.a, 2).getSharedPreferences(bVar.a + ".push_sync", 1).getString("r", "nodata");
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                if (!"nodata".equals(string)) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("r", string);
                    edit.commit();
                    return bVar.a;
                }
                continue;
            }
            return null;
        }
        return null;
    }

    static ArrayList c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.trim().split(";")) {
            String[] split = str2.trim().split(",");
            b bVar = new b();
            bVar.a = split[0].trim();
            bVar.b = split[1].trim();
            bVar.c = split[2].trim();
            arrayList.add(bVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(String str) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.a.equals(str)) {
                return bVar;
            }
        }
        return null;
    }

    public String a(b bVar, boolean z) {
        boolean z2;
        String encode;
        synchronized (this.a) {
            Iterator it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                b bVar2 = (b) it.next();
                if (bVar2.a.equals(bVar.a)) {
                    this.a.remove(bVar2);
                    if (z) {
                        this.a.add(bVar);
                    }
                    z2 = true;
                }
            }
            if (!z2 && z) {
                this.a.add(bVar);
            }
            SharedPreferences sharedPreferences = this.c.getSharedPreferences(this.c.getPackageName() + ".push_sync", 1);
            try {
                encode = Base64.encode(AESUtil.encrypt("1234567890123456", a(this.a).getBytes()), "utf-8");
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("r", encode);
                edit.commit();
            } catch (Exception e) {
                Log.e("ClientManager", e);
                return "";
            }
        }
        return encode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.a.size() > 0;
    }

    public b b(String str) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.b.equals(str)) {
                return bVar;
            }
        }
        return null;
    }
}
