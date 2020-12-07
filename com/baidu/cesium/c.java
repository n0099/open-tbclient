package com.baidu.cesium;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
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
/* loaded from: classes14.dex */
public class c {
    private com.baidu.cesium.c.d.d anO;
    private List<b> g;

    public c() {
        a();
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            str = hexString.length() == 1 ? str + "0" + hexString : str + hexString;
        }
        return str.toLowerCase();
    }

    private void a() {
        this.anO = new com.baidu.cesium.c.d.e(d.a(), d.b());
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

    private static byte[] a(byte[] bArr, com.baidu.cesium.c.d.d dVar) {
        com.baidu.cesium.c.d.a ux = com.baidu.cesium.c.d.a.ux();
        ux.a(2, dVar);
        return ux.a(bArr);
    }

    private String[] a(Signature[] signatureArr) {
        String[] strArr = new String[signatureArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = a(com.baidu.cesium.d.c.a(signatureArr[i].toByteArray()));
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<b> O(Context context) {
        if (this.g != null) {
            return this.g;
        }
        a(context);
        List<b> a2 = a(context, new Intent("com.baidu.intent.action.GALAXY"), true);
        this.g = a2;
        return a2;
    }

    List<b> a(Context context, Intent intent, boolean z) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.applicationInfo != null) {
                    try {
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), 128).metaData;
                        if (bundle != null) {
                            String string = bundle.getString("galaxy_data");
                            if (!TextUtils.isEmpty(string)) {
                                byte[] a2 = com.baidu.cesium.d.a.a(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(a2));
                                b bVar = new b();
                                bVar.b = jSONObject.getInt("priority");
                                bVar.adT = resolveInfo.activityInfo.applicationInfo;
                                if (context.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    bVar.d = true;
                                }
                                if (z) {
                                    String string2 = bundle.getString("galaxy_sf");
                                    if (!TextUtils.isEmpty(string2)) {
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        String[] strArr = new String[jSONArray.length()];
                                        for (int i = 0; i < strArr.length; i++) {
                                            strArr[i] = jSONArray.getString(i);
                                        }
                                        if (a(strArr, a(packageInfo.signatures))) {
                                            byte[] a3 = a(com.baidu.cesium.d.a.a(string2.getBytes()), this.anO);
                                            if (a3 != null && Arrays.equals(a3, com.baidu.cesium.d.c.a(a2))) {
                                                bVar.c = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(bVar);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        Collections.sort(arrayList, new Comparator<b>() { // from class: com.baidu.cesium.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(b bVar2, b bVar3) {
                int i2 = bVar3.b - bVar2.b;
                if (i2 == 0) {
                    if (bVar2.d && bVar3.d) {
                        return 0;
                    }
                    if (bVar2.d) {
                        return -1;
                    }
                    if (bVar3.d) {
                        return 1;
                    }
                    return i2;
                }
                return i2;
            }
        });
        return arrayList;
    }

    boolean a(Context context) {
        List<b> a2 = a(context, new Intent("com.baidu.intent.action.GALAXY").setPackage(context.getPackageName()), true);
        if (a2 == null || a2.size() == 0) {
            for (int i = 0; i < 3; i++) {
                Log.w("CuidBuddyInfoManager", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
            }
            return false;
        }
        b bVar = a2.get(0);
        boolean z = bVar.c;
        if (!bVar.c) {
            for (int i2 = 0; i2 < 3; i2++) {
                Log.w("CuidBuddyInfoManager", "galaxy config err, In the release version of the signature should be matched");
            }
        }
        return z;
    }
}
