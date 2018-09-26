package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.mobstat.bt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class l {
    static final l a = new l();

    l() {
    }

    public synchronized void a(Context context, boolean z) {
        b(context, z);
    }

    private void b(Context context, boolean z) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            List<PackageInfo> arrayList = new ArrayList<>(1);
            try {
                arrayList = packageManager.getInstalledPackages(0);
            } catch (Exception e) {
                bi.c().b(e);
            }
            JSONArray jSONArray = new JSONArray();
            for (PackageInfo packageInfo : arrayList) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo != null) {
                    boolean z2 = (applicationInfo.flags & 1) != 0;
                    String charSequence = applicationInfo.loadLabel(packageManager).toString();
                    String str = applicationInfo.sourceDir;
                    if (z == z2) {
                        a(z, charSequence, str, packageInfo, jSONArray);
                    }
                }
            }
            if (jSONArray.length() != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis() + "|");
                sb.append(z ? 1 : 0);
                String str2 = "";
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("app_list", jSONArray);
                    jSONObject.put("meta-data", sb.toString());
                    str2 = bt.a.a(jSONObject.toString().getBytes());
                } catch (Exception e2) {
                }
                if (!TextUtils.isEmpty(str2)) {
                    r.APP_LIST.a(System.currentTimeMillis(), str2);
                }
            }
        }
    }

    private void a(boolean z, String str, String str2, PackageInfo packageInfo, JSONArray jSONArray) {
        long j;
        long j2 = 0;
        if (!z || !packageInfo.packageName.startsWith("com.android.")) {
            try {
                j = packageInfo.firstInstallTime;
            } catch (Throwable th) {
                bi.c().b(th);
                j = 0;
            }
            try {
                j2 = packageInfo.lastUpdateTime;
            } catch (Throwable th2) {
                bi.c().b(th2);
            }
            long a2 = a(str2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("n", packageInfo.packageName);
                jSONObject.put(Config.APP_VERSION_CODE, str);
                jSONObject.put("v", String.valueOf(packageInfo.versionName));
                jSONObject.put("f", j);
                jSONObject.put("l", j2);
                jSONObject.put(Config.MODEL, a2);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                bi.c().b(e);
            }
        }
    }

    private long a(String str) {
        File file;
        if (str == null || (file = new File(str)) == null || !file.exists()) {
            return 0L;
        }
        return file.lastModified();
    }
}
