package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.baidu.mobstat.bm;
import com.baidu.mobstat.bt;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static d f9084a = new d();

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f9085a;

        /* renamed from: b  reason: collision with root package name */
        public String f9086b;

        /* renamed from: c  reason: collision with root package name */
        public String f9087c;

        /* renamed from: d  reason: collision with root package name */
        public String f9088d;

        public a(String str, String str2, String str3, String str4) {
            str = str == null ? "" : str;
            str2 = str2 == null ? "" : str2;
            str3 = str3 == null ? "" : str3;
            str4 = str4 == null ? "" : str4;
            this.f9085a = str;
            this.f9086b = str2;
            this.f9087c = str3;
            this.f9088d = str4;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("n", this.f9085a);
                jSONObject.put("v", this.f9086b);
                jSONObject.put("c", this.f9087c);
                jSONObject.put("a", this.f9088d);
                return jSONObject;
            } catch (JSONException e2) {
                bb.c().b(e2);
                return null;
            }
        }
    }

    private void b(Context context) {
        a(context, c(context));
    }

    private ArrayList<a> c(Context context) {
        ArrayList<a> arrayList = new ArrayList<>();
        Iterator<PackageInfo> it = d(context).iterator();
        while (it.hasNext()) {
            PackageInfo next = it.next();
            ApplicationInfo applicationInfo = next.applicationInfo;
            if (applicationInfo != null) {
                String str = next.packageName;
                String str2 = next.versionName;
                Signature[] signatureArr = next.signatures;
                String a2 = bt.b.a(((signatureArr == null || signatureArr.length == 0) ? "" : signatureArr[0].toChars().toString()).getBytes());
                String str3 = applicationInfo.sourceDir;
                arrayList.add(new a(str, str2, a2, TextUtils.isEmpty(str3) ? "" : bt.b.a(new File(str3))));
            }
        }
        return arrayList;
    }

    private ArrayList<PackageInfo> d(Context context) {
        ArrayList<PackageInfo> arrayList = new ArrayList<>();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return arrayList;
        }
        List<PackageInfo> arrayList2 = new ArrayList<>(1);
        try {
            arrayList2 = packageManager.getInstalledPackages(64);
        } catch (Exception e2) {
            bb.c().b(e2);
        }
        for (PackageInfo packageInfo : arrayList2) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null && (applicationInfo.flags & 1) == 0) {
                arrayList.add(packageInfo);
            }
        }
        return arrayList;
    }

    public synchronized void a(Context context) {
        b(context);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0005: INVOKE  (r0v0 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    private void a(Context context, ArrayList<a> arrayList) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
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
            jSONObject.put("app_apk", jSONArray);
            jSONObject.put("meta-data", sb.toString());
            str = bm.a.a(jSONObject.toString().getBytes());
        } catch (Exception e2) {
            bb.c().b(e2);
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        k.APP_APK.a(System.currentTimeMillis(), str);
    }
}
