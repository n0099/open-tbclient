package com.baidu.mobstat;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.bl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    public static f a = new f();
    public String b = "";

    private boolean a(int i) {
        return i == 100 || i == 200 || i == 130;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public String a;
        public String b;
        public String c;

        public a(String str, String str2, String str3) {
            this.a = str == null ? "" : str;
            this.b = str2 == null ? "" : str2;
            this.c = str3 == null ? "" : str3;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("n", this.a);
                jSONObject.put("v", this.b);
                jSONObject.put("w", this.c);
                return jSONObject;
            } catch (JSONException e) {
                ba.c().b(e);
                return null;
            }
        }

        public String b() {
            return this.a;
        }
    }

    private String a(Context context, String str) {
        String str2;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return "";
        }
        try {
            str2 = packageManager.getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            ba.c().b(e);
            str2 = "";
        }
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    private boolean b(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(str, 0).applicationInfo;
            if (applicationInfo == null) {
                return false;
            }
            if ((applicationInfo.flags & 1) == 0) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            ba.c().b(e);
            return false;
        }
    }

    private ArrayList<a> a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return c(context, i);
        }
        return b(context, i);
    }

    private void a(Context context, ArrayList<a> arrayList, boolean z) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis() + "|");
        sb.append(z ? 1 : 0);
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject a2 = it.next().a();
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("app_trace", jSONArray);
            jSONObject.put("meta-data", sb.toString());
            str = bl.a.a(jSONObject.toString().getBytes());
        } catch (Exception e) {
            ba.c().b(e);
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            k.APP_TRACE.a(context, System.currentTimeMillis(), str);
        }
    }

    private void a(Context context, boolean z, int i) {
        ArrayList<a> a2 = a(context, i);
        if (a2 != null && a2.size() != 0) {
            if (z) {
                String b = a2.get(0).b();
                if (a(b, this.b)) {
                    this.b = b;
                }
            }
            a(context, a2, z);
        }
    }

    private boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.b)) {
            return true;
        }
        return false;
    }

    private ArrayList<a> b(Context context, int i) {
        List<ActivityManager.RunningTaskInfo> list;
        try {
            list = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(50);
        } catch (Exception e) {
            ba.c().b(e);
            list = null;
        }
        if (list == null) {
            return new ArrayList<>();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ActivityManager.RunningTaskInfo runningTaskInfo : list) {
            if (linkedHashMap.size() > i) {
                break;
            }
            ComponentName componentName = runningTaskInfo.topActivity;
            if (componentName != null) {
                String packageName = componentName.getPackageName();
                if (!TextUtils.isEmpty(packageName) && !b(context, packageName) && !linkedHashMap.containsKey(packageName)) {
                    linkedHashMap.put(packageName, new a(packageName, a(context, packageName), ""));
                }
            }
        }
        return new ArrayList<>(linkedHashMap.values());
    }

    private ArrayList<a> c(Context context, int i) {
        String[] strArr;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return new ArrayList<>();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i2 = 0; i2 < runningAppProcesses.size() && linkedHashMap.size() <= i; i2++) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i2);
            if (a(runningAppProcessInfo.importance) && (strArr = runningAppProcessInfo.pkgList) != null && strArr.length != 0) {
                String str = strArr[0];
                if (!TextUtils.isEmpty(str) && !b(context, str) && !linkedHashMap.containsKey(str)) {
                    linkedHashMap.put(str, new a(str, a(context, str), String.valueOf(runningAppProcessInfo.importance)));
                }
            }
        }
        return new ArrayList<>(linkedHashMap.values());
    }

    public synchronized void a(Context context, boolean z) {
        int i = 1;
        if (!z) {
            i = 20;
        }
        a(context, z, i);
    }
}
