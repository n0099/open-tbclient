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
    public ArrayList f687a = new ArrayList();
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
                ArrayList d = d(str);
                if (d != null) {
                    Iterator it = d.iterator();
                    while (it.hasNext()) {
                        this.f687a.add((d) it.next());
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
            ArrayList d2 = d(str2);
            if (d2 != null) {
                Iterator it2 = d2.iterator();
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
            stringBuffer.append(dVar.f707a);
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
                c.f687a.clear();
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
                            ArrayList d = d(str);
                            if (d != null) {
                                Iterator it = d.iterator();
                                while (it.hasNext()) {
                                    c.f687a.add((d) it.next());
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
                        ArrayList d2 = d(str2);
                        if (d2 != null) {
                            Iterator it2 = d2.iterator();
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
                dVar.f707a = resolveInfo.activityInfo.packageName;
                try {
                    string = context.createPackageContext(dVar.f707a, 2).getSharedPreferences(dVar.f707a + ".push_sync", 1).getString("r", "nodata");
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                if (!"nodata".equals(string)) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("r", string);
                    edit.commit();
                    return dVar.f707a;
                }
                continue;
            }
            return null;
        }
        return null;
    }

    private static String d(Context context) {
        String string;
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + ".push_sync", 1);
        if ("nodata".equals(sharedPreferences.getString("r_v2", "nodata"))) {
            for (ResolveInfo resolveInfo : context.getPackageManager().queryBroadcastReceivers(new Intent("com.baidu.android.pushservice.action.BIND_SYNC"), 0)) {
                d dVar = new d();
                dVar.f707a = resolveInfo.activityInfo.packageName;
                try {
                    string = context.createPackageContext(dVar.f707a, 2).getSharedPreferences(dVar.f707a + ".push_sync", 1).getString("r_v2", "nodata");
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                if (!"nodata".equals(string)) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("r_v2", string);
                    edit.commit();
                    return dVar.f707a;
                }
                continue;
            }
            return null;
        }
        return null;
    }

    static ArrayList d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.trim().split(";")) {
            String[] split = str2.trim().split(",");
            if (split.length >= 3) {
                d dVar = new d();
                dVar.f707a = split[0].trim();
                dVar.b = split[1].trim();
                dVar.c = split[2].trim();
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }

    public d a(String str) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f707a.equals(str)) {
                return dVar;
            }
        }
        Iterator it2 = this.f687a.iterator();
        while (it2.hasNext()) {
            d dVar2 = (d) it2.next();
            if (dVar2.f707a.equals(str)) {
                return dVar2;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006b A[Catch: all -> 0x013b, TryCatch #0 {, blocks: (B:8:0x002d, B:9:0x0065, B:11:0x006b, B:13:0x00ad, B:15:0x00b7, B:17:0x00be, B:21:0x00c8, B:22:0x00cd, B:24:0x00f9, B:25:0x0111, B:26:0x012f, B:29:0x0132, B:30:0x0137), top: B:36:0x002d, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f9 A[Catch: all -> 0x013b, TRY_LEAVE, TryCatch #0 {, blocks: (B:8:0x002d, B:9:0x0065, B:11:0x006b, B:13:0x00ad, B:15:0x00b7, B:17:0x00be, B:21:0x00c8, B:22:0x00cd, B:24:0x00f9, B:25:0x0111, B:26:0x012f, B:29:0x0132, B:30:0x0137), top: B:36:0x002d, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(d dVar, boolean z) {
        boolean z2;
        String encode;
        if (b.a()) {
            Log.d("ClientManager", "sync addOrRemove:" + z + ", " + dVar);
        }
        synchronized (this.f687a) {
            Log.d("ClientManager", "client.packageName=" + dVar.f707a + " client.appId=" + dVar.b + " client.userId=" + dVar.c);
            Iterator it = this.f687a.iterator();
            try {
                while (it.hasNext()) {
                    d dVar2 = (d) it.next();
                    Log.d("ClientManager", "c.packageName=" + dVar2.f707a + " c.appId=" + dVar2.b + " c.userId=" + dVar2.c);
                    if (dVar2.f707a.equals(dVar.f707a) || dVar2.b.equals(dVar.b)) {
                        this.f687a.remove(dVar2);
                        if (z) {
                            this.f687a.add(dVar);
                        }
                        z2 = true;
                        if (!z2 && z) {
                            this.f687a.add(dVar);
                        }
                        SharedPreferences sharedPreferences = this.d.getSharedPreferences(this.d.getPackageName() + ".push_sync", 1);
                        String a2 = a(this.f687a);
                        if (b.a()) {
                            Log.i("ClientManager", "sync  strApps: " + a2);
                        }
                        encode = Base64.encode(AESUtil.encrypt("2011121211143000", "1234567890123456", a2.getBytes()), BdUtil.UTF8);
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString("r", encode);
                        edit.commit();
                    }
                    while (it.hasNext()) {
                    }
                }
                encode = Base64.encode(AESUtil.encrypt("2011121211143000", "1234567890123456", a2.getBytes()), BdUtil.UTF8);
                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                edit2.putString("r", encode);
                edit2.commit();
            } catch (Exception e) {
                Log.e("ClientManager", e);
                return "";
            }
            z2 = false;
            if (!z2) {
                this.f687a.add(dVar);
            }
            SharedPreferences sharedPreferences2 = this.d.getSharedPreferences(this.d.getPackageName() + ".push_sync", 1);
            String a22 = a(this.f687a);
            if (b.a()) {
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
        Iterator it2 = this.f687a.iterator();
        while (it2.hasNext()) {
            d dVar2 = (d) it2.next();
            if (dVar2.b.equals(str)) {
                return dVar2;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006b A[Catch: all -> 0x013b, TryCatch #0 {, blocks: (B:8:0x002d, B:9:0x0065, B:11:0x006b, B:13:0x00ad, B:15:0x00b7, B:17:0x00be, B:21:0x00c8, B:22:0x00cd, B:24:0x00f9, B:25:0x0111, B:26:0x012f, B:29:0x0132, B:30:0x0137), top: B:36:0x002d, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f9 A[Catch: all -> 0x013b, TRY_LEAVE, TryCatch #0 {, blocks: (B:8:0x002d, B:9:0x0065, B:11:0x006b, B:13:0x00ad, B:15:0x00b7, B:17:0x00be, B:21:0x00c8, B:22:0x00cd, B:24:0x00f9, B:25:0x0111, B:26:0x012f, B:29:0x0132, B:30:0x0137), top: B:36:0x002d, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String b(d dVar, boolean z) {
        boolean z2;
        String encode;
        if (b.a()) {
            Log.d("ClientManager", "syncV2 addOrRemove:" + z + ", " + dVar);
        }
        synchronized (this.b) {
            Log.d("ClientManager", "client.packageName=" + dVar.f707a + " client.appId=" + dVar.b + " client.userId=" + dVar.c);
            Iterator it = this.b.iterator();
            try {
                while (it.hasNext()) {
                    d dVar2 = (d) it.next();
                    Log.d("ClientManager", "c.packageName=" + dVar2.f707a + " c.appId=" + dVar2.b + " c.userId=" + dVar2.c);
                    if (dVar2.f707a.equals(dVar.f707a) || dVar2.b.equals(dVar.b)) {
                        this.b.remove(dVar2);
                        if (z) {
                            this.b.add(dVar);
                        }
                        z2 = true;
                        if (!z2 && z) {
                            this.b.add(dVar);
                        }
                        SharedPreferences sharedPreferences = this.d.getSharedPreferences(this.d.getPackageName() + ".push_sync", 1);
                        String a2 = a(this.b);
                        if (b.a()) {
                            Log.i("ClientManager", "syncV2  strApps: " + a2);
                        }
                        encode = Base64.encode(AESUtil.encrypt("2011121211143000", "1234567890123456", a2.getBytes()), BdUtil.UTF8);
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString("r_v2", encode);
                        edit.commit();
                    }
                    while (it.hasNext()) {
                    }
                }
                encode = Base64.encode(AESUtil.encrypt("2011121211143000", "1234567890123456", a2.getBytes()), BdUtil.UTF8);
                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                edit2.putString("r_v2", encode);
                edit2.commit();
            } catch (Exception e) {
                Log.e("ClientManager", e);
                return "";
            }
            z2 = false;
            if (!z2) {
                this.b.add(dVar);
            }
            SharedPreferences sharedPreferences2 = this.d.getSharedPreferences(this.d.getPackageName() + ".push_sync", 1);
            String a22 = a(this.b);
            if (b.a()) {
            }
        }
        return encode;
    }

    public boolean c(String str) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (((d) it.next()).b.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public String e(String str) {
        return this.e.get(str) != null ? ((com.baidu.android.pushservice.a.g) this.e.get(str)).b() : "";
    }

    public void f(String str) {
        if (this.e.containsKey(str)) {
            this.e.remove(str);
        }
    }
}
