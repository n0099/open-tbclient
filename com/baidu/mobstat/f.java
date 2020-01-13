package com.baidu.mobstat;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.bm;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class f {
    static f a = new f();
    private String b = "";

    f() {
    }

    public synchronized void a(Context context, boolean z) {
        a(context, z, z ? 1 : 20);
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

    private ArrayList<a> a(Context context, int i) {
        return Build.VERSION.SDK_INT >= 21 ? c(context, i) : b(context, i);
    }

    private ArrayList<a> b(Context context, int i) {
        List<ActivityManager.RunningTaskInfo> list;
        try {
            list = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(50);
        } catch (Exception e) {
            bb.c().b(e);
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
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return new ArrayList<>();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i2 = 0; i2 < runningAppProcesses.size() && linkedHashMap.size() <= i; i2++) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i2);
            if (a(runningAppProcessInfo.importance) && (strArr = runningAppProcessInfo.pkgList) != null && strArr.length != 0) {
                String str = runningAppProcessInfo.pkgList[0];
                if (!TextUtils.isEmpty(str) && !b(context, str) && !linkedHashMap.containsKey(str)) {
                    linkedHashMap.put(str, new a(str, a(context, str), String.valueOf(runningAppProcessInfo.importance)));
                }
            }
        }
        return new ArrayList<>(linkedHashMap.values());
    }

    private boolean a(int i) {
        if (i != 100 && i != 200 && i != 130) {
            return false;
        }
        return true;
    }

    private boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) || str.equals(this.b)) ? false : true;
    }

    private String a(Context context, String str) {
        String str2 = "";
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return "";
        }
        try {
            str2 = packageManager.getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            bb.c().b(e);
        }
        return str2 == null ? "" : str2;
    }

    private boolean b(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(str, 0).applicationInfo;
            if (applicationInfo != null) {
                return (applicationInfo.flags & 1) != 0;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            bb.c().b(e);
            return false;
        }
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
            str = bm.a.a(jSONObject.toString().getBytes());
        } catch (Exception e) {
            bb.c().b(e);
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            k.APP_TRACE.a(System.currentTimeMillis(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a {
        private String a;
        private String b;
        private String c;

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
                bb.c().b(e);
                return null;
            }
        }

        public String b() {
            return this.a;
        }
    }
}
