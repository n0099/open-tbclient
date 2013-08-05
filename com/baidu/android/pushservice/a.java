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
import com.baidu.browser.core.util.BdUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class a {
    private static volatile a c;
    private Context d;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f566a = new ArrayList();
    public ArrayList b = new ArrayList();
    private HashMap e = new HashMap();

    private a(Context context) {
        this.d = context.getApplicationContext();
        c(this.d);
        d(this.d);
        SharedPreferences sharedPreferences = this.d.getSharedPreferences(this.d.getPackageName() + ".push_sync", 1);
        String string = sharedPreferences.getString("r", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                String str = new String(AESUtil.decrypt("2011121211143000", "1234567890123456", Base64.decode(string.getBytes())));
                if (b.a()) {
                    Log.i("ClientManager", "ClientManager init strApps : " + str);
                }
                ArrayList c2 = c(str);
                if (c2 != null) {
                    Iterator it = c2.iterator();
                    while (it.hasNext()) {
                        this.f566a.add((d) it.next());
                    }
                }
            } catch (Exception e) {
                Log.e("ClientManager", e);
            }
        } else if (b.a()) {
            Log.i("ClientManager", "ClientManager init strApps empty.");
        }
        String string2 = sharedPreferences.getString("r_v2", "");
        if (TextUtils.isEmpty(string2)) {
            if (b.a()) {
                Log.i("ClientManager", "ClientManager init strAppsV2 empty.");
                return;
            }
            return;
        }
        try {
            String str2 = new String(AESUtil.decrypt("2011121211143000", "1234567890123456", Base64.decode(string2.getBytes())));
            if (b.a()) {
                Log.i("ClientManager", "ClientManager init strAppsV2 : " + str2);
            }
            ArrayList c3 = c(str2);
            if (c3 != null) {
                Iterator it2 = c3.iterator();
                while (it2.hasNext()) {
                    this.b.add((d) it2.next());
                }
            }
        } catch (Exception e2) {
            Log.e("ClientManager", e2);
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (c == null) {
                c = new a(context);
            }
            aVar = c;
        }
        return aVar;
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
            d dVar = (d) list.get(i2);
            stringBuffer.append(dVar.f579a);
            stringBuffer.append(",");
            stringBuffer.append(dVar.b);
            stringBuffer.append(",");
            stringBuffer.append(dVar.c);
            if (i2 != list.size() - 1) {
                stringBuffer.append(";");
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x010c A[Catch: all -> 0x011a, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x003f, B:9:0x0054, B:11:0x005a, B:12:0x0072, B:14:0x0078, B:15:0x007c, B:17:0x0082, B:21:0x0096, B:23:0x00a4, B:25:0x00bf, B:26:0x00d7, B:28:0x00dd, B:29:0x00e1, B:31:0x00e7, B:41:0x010c, B:43:0x0112, B:34:0x00f6, B:20:0x0091, B:37:0x00fd, B:39:0x0103), top: B:54:0x0003, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void b(Context context) {
        String str;
        String string;
        synchronized (a.class) {
            if (c != null) {
                c.f566a.clear();
                c.b.clear();
                SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + ".push_sync", 1);
                String string2 = sharedPreferences.getString("r", "");
                if (TextUtils.isEmpty(string2)) {
                    if (b.a()) {
                        Log.i("ClientManager", "ClientManager init strApps empty.");
                    }
                    str = string2;
                } else {
                    try {
                        str = new String(AESUtil.decrypt("2011121211143000", "1234567890123456", Base64.decode(string2.getBytes())));
                        try {
                            if (b.a()) {
                                Log.i("ClientManager", "ClientManager init strApps : " + str);
                            }
                            ArrayList c2 = c(str);
                            if (c2 != null) {
                                Iterator it = c2.iterator();
                                while (it.hasNext()) {
                                    c.f566a.add((d) it.next());
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            Log.e("ClientManager", e);
                            string = sharedPreferences.getString("r_v2", "");
                            if (TextUtils.isEmpty(string)) {
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = string2;
                    }
                }
                string = sharedPreferences.getString("r_v2", "");
                if (TextUtils.isEmpty(string)) {
                    try {
                        String str2 = new String(AESUtil.decrypt("2011121211143000", "1234567890123456", Base64.decode(string.getBytes())));
                        if (b.a()) {
                            Log.i("ClientManager", "ClientManager init strApps : " + str);
                        }
                        ArrayList c3 = c(str2);
                        if (c3 != null) {
                            Iterator it2 = c3.iterator();
                            while (it2.hasNext()) {
                                c.b.add((d) it2.next());
                            }
                        }
                    } catch (Exception e3) {
                        Log.e("ClientManager", e3);
                    }
                } else if (b.a()) {
                    Log.i("ClientManager", "ClientManager init strAppsV2 empty.");
                }
            }
        }
    }

    private static String c(Context context) {
        String string;
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + ".push_sync", 1);
        if ("nodata".equals(sharedPreferences.getString("r", "nodata"))) {
            for (ResolveInfo resolveInfo : context.getPackageManager().queryBroadcastReceivers(new Intent("com.baidu.android.pushservice.action.BIND_SYNC"), 0)) {
                d dVar = new d();
                dVar.f579a = resolveInfo.activityInfo.packageName;
                try {
                    string = context.createPackageContext(dVar.f579a, 2).getSharedPreferences(dVar.f579a + ".push_sync", 1).getString("r", "nodata");
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                if (!"nodata".equals(string)) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("r", string);
                    edit.commit();
                    return dVar.f579a;
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
            if (split.length >= 3) {
                d dVar = new d();
                dVar.f579a = split[0].trim();
                dVar.b = split[1].trim();
                dVar.c = split[2].trim();
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }

    private static String d(Context context) {
        String string;
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + ".push_sync", 1);
        if ("nodata".equals(sharedPreferences.getString("r_v2", "nodata"))) {
            for (ResolveInfo resolveInfo : context.getPackageManager().queryBroadcastReceivers(new Intent("com.baidu.android.pushservice.action.BIND_SYNC"), 0)) {
                d dVar = new d();
                dVar.f579a = resolveInfo.activityInfo.packageName;
                try {
                    string = context.createPackageContext(dVar.f579a, 2).getSharedPreferences(dVar.f579a + ".push_sync", 1).getString("r_v2", "nodata");
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                if (!"nodata".equals(string)) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("r_v2", string);
                    edit.commit();
                    return dVar.f579a;
                }
                continue;
            }
            return null;
        }
        return null;
    }

    public d a(String str) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f579a.equals(str)) {
                return dVar;
            }
        }
        Iterator it2 = this.f566a.iterator();
        while (it2.hasNext()) {
            d dVar2 = (d) it2.next();
            if (dVar2.f579a.equals(str)) {
                return dVar2;
            }
        }
        return null;
    }

    public String a(d dVar, boolean z) {
        boolean z2;
        String encode;
        if (b.a()) {
            Log.d("ClientManager", "sync addOrRemove:" + z + ", " + dVar);
        }
        synchronized (this.f566a) {
            Log.d("ClientManager", "client.packageName=" + dVar.f579a + " client.appId=" + dVar.b + " client.userId=" + dVar.c);
            Iterator it = this.f566a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                d dVar2 = (d) it.next();
                Log.d("ClientManager", "c.packageName=" + dVar2.f579a + " c.appId=" + dVar2.b + " c.userId=" + dVar2.c);
                if (dVar2.f579a.equals(dVar.f579a)) {
                    this.f566a.remove(dVar2);
                    if (z) {
                        this.f566a.add(dVar);
                    }
                    z2 = true;
                }
            }
            if (!z2 && z) {
                this.f566a.add(dVar);
            }
            SharedPreferences sharedPreferences = this.d.getSharedPreferences(this.d.getPackageName() + ".push_sync", 1);
            String a2 = a(this.f566a);
            if (b.a()) {
                Log.i("ClientManager", "sync  strApps: " + a2);
            }
            try {
                encode = Base64.encode(AESUtil.encrypt("2011121211143000", "1234567890123456", a2.getBytes()), BdUtil.UTF8);
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

    public void a(String str, com.baidu.android.pushservice.a.g gVar) {
        this.e.put(str, gVar);
    }

    public boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.e.containsKey(str) && str2.equals(((com.baidu.android.pushservice.a.g) this.e.get(str)).a());
    }

    public d b(String str) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.b.equals(str)) {
                return dVar;
            }
        }
        Iterator it2 = this.f566a.iterator();
        while (it2.hasNext()) {
            d dVar2 = (d) it2.next();
            if (dVar2.b.equals(str)) {
                return dVar2;
            }
        }
        return null;
    }

    public String b(d dVar, boolean z) {
        boolean z2;
        String encode;
        if (b.a()) {
            Log.d("ClientManager", "syncV2 addOrRemove:" + z + ", " + dVar);
        }
        synchronized (this.b) {
            Log.d("ClientManager", "client.packageName=" + dVar.f579a + " client.appId=" + dVar.b + " client.userId=" + dVar.c);
            Iterator it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                d dVar2 = (d) it.next();
                Log.d("ClientManager", "c.packageName=" + dVar2.f579a + " c.appId=" + dVar2.b + " c.userId=" + dVar2.c);
                if (dVar2.f579a.equals(dVar.f579a)) {
                    this.b.remove(dVar2);
                    if (z) {
                        this.b.add(dVar);
                    }
                    z2 = true;
                }
            }
            if (!z2 && z) {
                this.b.add(dVar);
            }
            SharedPreferences sharedPreferences = this.d.getSharedPreferences(this.d.getPackageName() + ".push_sync", 1);
            String a2 = a(this.b);
            if (b.a()) {
                Log.i("ClientManager", "syncV2  strApps: " + a2);
            }
            try {
                encode = Base64.encode(AESUtil.encrypt("2011121211143000", "1234567890123456", a2.getBytes()), BdUtil.UTF8);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("r_v2", encode);
                edit.commit();
            } catch (Exception e) {
                Log.e("ClientManager", e);
                return "";
            }
        }
        return encode;
    }

    public String d(String str) {
        return this.e.get(str) != null ? ((com.baidu.android.pushservice.a.g) this.e.get(str)).b() : "";
    }

    public void e(String str) {
        if (this.e.containsKey(str)) {
            this.e.remove(str);
        }
    }
}
