package com.baidu.mobads.cid.cesium;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.mobads.cid.cesium.c.d.d f8124a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f8125b;

    public c() {
        a();
    }

    public static String a(byte[] bArr) {
        StringBuilder sb;
        if (bArr != null) {
            String str = "";
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    sb = new StringBuilder();
                    sb.append(str);
                    str = "0";
                } else {
                    sb = new StringBuilder();
                }
                sb.append(str);
                sb.append(hexString);
                str = sb.toString();
            }
            return str.toLowerCase();
        }
        throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
    }

    private void a() {
        this.f8124a = new com.baidu.mobads.cid.cesium.c.d.e(d.a(), d.b());
    }

    private boolean a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            hashSet.add(str);
        }
        HashSet hashSet2 = new HashSet();
        for (String str2 : strArr2) {
            hashSet2.add(str2);
        }
        return hashSet.equals(hashSet2);
    }

    public static byte[] a(byte[] bArr, com.baidu.mobads.cid.cesium.c.d.d dVar) {
        com.baidu.mobads.cid.cesium.c.d.a a2 = com.baidu.mobads.cid.cesium.c.d.a.a();
        a2.a(2, dVar);
        return a2.a(bArr);
    }

    private String[] a(Signature[] signatureArr) {
        int length = signatureArr.length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = a(com.baidu.mobads.cid.cesium.d.c.a(signatureArr[i2].toByteArray()));
        }
        return strArr;
    }

    public List<b> a(Context context, Intent intent, boolean z) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && activityInfo.applicationInfo != null) {
                    try {
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), 128).metaData;
                        if (bundle != null) {
                            String string = bundle.getString("galaxy_data");
                            if (!TextUtils.isEmpty(string)) {
                                byte[] a2 = com.baidu.mobads.cid.cesium.d.a.a(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(a2));
                                b bVar = new b();
                                bVar.f8058b = jSONObject.getInt("priority");
                                bVar.f8057a = resolveInfo.activityInfo.applicationInfo;
                                if (context.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    bVar.f8060d = true;
                                }
                                if (z) {
                                    String string2 = bundle.getString("galaxy_sf");
                                    if (!TextUtils.isEmpty(string2)) {
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        int length = jSONArray.length();
                                        String[] strArr = new String[length];
                                        for (int i2 = 0; i2 < length; i2++) {
                                            strArr[i2] = jSONArray.getString(i2);
                                        }
                                        if (a(strArr, a(packageInfo.signatures))) {
                                            byte[] a3 = a(com.baidu.mobads.cid.cesium.d.a.a(string2.getBytes()), this.f8124a);
                                            if (a3 != null && Arrays.equals(a3, com.baidu.mobads.cid.cesium.d.c.a(a2))) {
                                                bVar.f8059c = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(bVar);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        Collections.sort(arrayList, new Comparator<b>() { // from class: com.baidu.mobads.cid.cesium.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(b bVar2, b bVar3) {
                int i3 = bVar3.f8058b - bVar2.f8058b;
                if (i3 == 0) {
                    if (bVar2.f8060d && bVar3.f8060d) {
                        return 0;
                    }
                    if (bVar2.f8060d) {
                        return -1;
                    }
                    if (bVar3.f8060d) {
                        return 1;
                    }
                }
                return i3;
            }
        });
        return arrayList;
    }

    public boolean a(Context context) {
        List<b> a2 = a(context, new Intent("com.baidu.intent.action.GALAXY").setPackage(context.getPackageName()), true);
        if (a2 == null || a2.size() == 0) {
            for (int i2 = 0; i2 < 3; i2++) {
                Log.w("CuidBuddyInfoManager", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
            }
            return false;
        }
        boolean z = a2.get(0).f8059c;
        if (!z) {
            for (int i3 = 0; i3 < 3; i3++) {
                Log.w("CuidBuddyInfoManager", "galaxy config err, In the release version of the signature should be matched");
            }
        }
        return z;
    }

    public List<b> b(Context context) {
        List<b> list = this.f8125b;
        if (list != null) {
            return list;
        }
        a(context);
        List<b> a2 = a(context, new Intent("com.baidu.intent.action.GALAXY"), true);
        this.f8125b = a2;
        return a2;
    }
}
