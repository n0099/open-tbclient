package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.mobstat.bl;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public static final e a = new e();

    private long a(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                return file.lastModified();
            }
        }
        return 0L;
    }

    private void b(Context context, boolean z) {
        String str;
        boolean z2;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return;
        }
        List<PackageInfo> arrayList = new ArrayList<>(1);
        try {
            arrayList = packageManager.getInstalledPackages(0);
        } catch (Exception e) {
            ba.c().b(e);
        }
        JSONArray jSONArray = new JSONArray();
        for (PackageInfo packageInfo : arrayList) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null) {
                if ((applicationInfo.flags & 1) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                String str2 = applicationInfo.sourceDir;
                if (z == z2) {
                    a(z, "", str2, packageInfo, jSONArray, true);
                }
            }
        }
        if (jSONArray.length() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis() + "|");
        sb.append(z ? 1 : 0);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("app_list", jSONArray);
            jSONObject.put("meta-data", sb.toString());
            str = bl.a.a(jSONObject.toString().getBytes());
        } catch (Exception unused) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            k.APP_LIST.a(context, System.currentTimeMillis(), str);
        }
    }

    public synchronized void a(Context context, boolean z) {
        b(context, z);
    }

    public void a(boolean z, String str, String str2, PackageInfo packageInfo, JSONArray jSONArray, boolean z2) {
        long j;
        if (z && packageInfo.packageName.startsWith("com.android.")) {
            return;
        }
        long j2 = 0;
        try {
            j = packageInfo.firstInstallTime;
        } catch (Throwable th) {
            ba.c().b(th);
            j = 0;
        }
        try {
            j2 = packageInfo.lastUpdateTime;
        } catch (Throwable th2) {
            ba.c().b(th2);
        }
        long a2 = a(str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", packageInfo.packageName);
            jSONObject.put("a", str);
            jSONObject.put("v", String.valueOf(packageInfo.versionName));
            jSONObject.put("f", j);
            jSONObject.put("l", j2);
            jSONObject.put("m", a2);
            jSONArray.put(jSONObject);
        } catch (JSONException e) {
            ba.c().b(e);
        }
    }
}
