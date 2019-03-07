package cn.jiguang.a.a.c;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import cn.jiguang.d.d.aa;
import com.baidu.android.pushservice.PushConstants;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {
    private static final String a = k.class.getSimpleName();

    public static String a(String str, int i) {
        if (str != null) {
            String replaceAll = Pattern.compile("\n|\r|\r\n|\n\r|\t").matcher(str).replaceAll("");
            try {
                byte[] bytes = replaceAll.getBytes();
                return bytes.length > 30 ? replaceAll.substring(0, new String(bytes, 0, 30, HTTP.UTF_8).length()) : replaceAll;
            } catch (UnsupportedEncodingException e) {
                return replaceAll;
            }
        }
        return str;
    }

    private static Set<String> a(ActivityManager activityManager) {
        HashSet hashSet = new HashSet();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            Collections.addAll(hashSet, runningAppProcessInfo.pkgList);
        }
        return hashSet;
    }

    private static JSONArray a(ActivityManager activityManager, PackageManager packageManager) {
        JSONArray jSONArray = new JSONArray();
        try {
            Set<String> a2 = a(activityManager);
            List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(8192);
            List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(200);
            Collections.sort(installedApplications, new ApplicationInfo.DisplayNameComparator(packageManager));
            long elapsedRealtime = SystemClock.elapsedRealtime();
            for (ApplicationInfo applicationInfo : installedApplications) {
                Object a3 = a(applicationInfo.loadLabel(packageManager).toString(), 30);
                if (a2.contains(applicationInfo.packageName)) {
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray2 = new JSONArray();
                    for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                        if (runningServiceInfo.service.getPackageName().equals(applicationInfo.packageName)) {
                            JSONObject jSONObject2 = new JSONObject();
                            long round = Math.round((float) ((elapsedRealtime - runningServiceInfo.activeSince) / 1000));
                            try {
                                jSONObject2.put("class_name", runningServiceInfo.service.getShortClassName());
                                jSONObject2.put("live_seconds", round);
                                jSONArray2.put(jSONObject2);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    try {
                        jSONObject.put("app_name", a3);
                        jSONObject.put(PushConstants.PACKAGE_NAME, applicationInfo.packageName);
                        jSONObject.put("service_list", jSONArray2);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } catch (Throwable th) {
            cn.jiguang.e.c.a(a, "getRunningApps error:" + th.getMessage());
        }
        return jSONArray;
    }

    public static void a(Context context) {
        JSONArray a2 = a((ActivityManager) context.getSystemService(com.meizu.cloud.pushsdk.constants.PushConstants.INTENT_ACTIVITY_NAME), context.getPackageManager());
        if (a2 == null || a2.length() == 0) {
            return;
        }
        aa.a(context, a2);
    }
}
