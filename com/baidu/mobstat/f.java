package com.baidu.mobstat;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.bm;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static f f8920a = new f();

    /* renamed from: b  reason: collision with root package name */
    public String f8921b = "";

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f8922a;

        /* renamed from: b  reason: collision with root package name */
        public String f8923b;

        /* renamed from: c  reason: collision with root package name */
        public String f8924c;

        public a(String str, String str2, String str3) {
            this.f8922a = str == null ? "" : str;
            this.f8923b = str2 == null ? "" : str2;
            this.f8924c = str3 == null ? "" : str3;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("n", this.f8922a);
                jSONObject.put("v", this.f8923b);
                jSONObject.put("w", this.f8924c);
                return jSONObject;
            } catch (JSONException e2) {
                bb.c().b(e2);
                return null;
            }
        }

        public String b() {
            return this.f8922a;
        }
    }

    private boolean a(int i2) {
        return i2 == 100 || i2 == 200 || i2 == 130;
    }

    private ArrayList<a> b(Context context, int i2) {
        List<ActivityManager.RunningTaskInfo> list;
        try {
            list = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(50);
        } catch (Exception e2) {
            bb.c().b(e2);
            list = null;
        }
        if (list == null) {
            return new ArrayList<>();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ActivityManager.RunningTaskInfo runningTaskInfo : list) {
            if (linkedHashMap.size() > i2) {
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

    private ArrayList<a> c(Context context, int i2) {
        String[] strArr;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return new ArrayList<>();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i3 = 0; i3 < runningAppProcesses.size() && linkedHashMap.size() <= i2; i3++) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i3);
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
        a(context, z, z ? 1 : 20);
    }

    private void a(Context context, boolean z, int i2) {
        ArrayList<a> a2 = a(context, i2);
        if (a2 == null || a2.size() == 0) {
            return;
        }
        if (z) {
            String b2 = a2.get(0).b();
            if (a(b2, this.f8921b)) {
                this.f8921b = b2;
            }
        }
        a(context, a2, z);
    }

    private ArrayList<a> a(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return c(context, i2);
        }
        return b(context, i2);
    }

    private boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) || str.equals(this.f8921b)) ? false : true;
    }

    private String a(Context context, String str) {
        String str2;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return "";
        }
        try {
            str2 = packageManager.getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            bb.c().b(e2);
            str2 = "";
        }
        return str2 == null ? "" : str2;
    }

    private void a(Context context, ArrayList<a> arrayList, boolean z) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis() + FieldBuilder.SE);
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
            str = bm.a.a(jSONObject.toString().getBytes());
        } catch (Exception e2) {
            bb.c().b(e2);
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        k.APP_TRACE.a(System.currentTimeMillis(), str);
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
            return (applicationInfo.flags & 1) != 0;
        } catch (PackageManager.NameNotFoundException e2) {
            bb.c().b(e2);
            return false;
        }
    }
}
