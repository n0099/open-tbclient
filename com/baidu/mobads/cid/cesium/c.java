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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.mobads.cid.cesium.c.d.d f40598a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f40599b;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a();
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
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
        return (String) invokeL.objValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f40598a = new com.baidu.mobads.cid.cesium.c.d.e(d.a(), d.b());
        }
    }

    private boolean a(String[] strArr, String[] strArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, strArr, strArr2)) == null) {
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
        return invokeLL.booleanValue;
    }

    public static byte[] a(byte[] bArr, com.baidu.mobads.cid.cesium.c.d.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, dVar)) == null) {
            com.baidu.mobads.cid.cesium.c.d.a a2 = com.baidu.mobads.cid.cesium.c.d.a.a();
            a2.a(2, dVar);
            return a2.a(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    private String[] a(Signature[] signatureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, signatureArr)) == null) {
            int length = signatureArr.length;
            String[] strArr = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = a(com.baidu.mobads.cid.cesium.d.c.a(signatureArr[i2].toByteArray()));
            }
            return strArr;
        }
        return (String[]) invokeL.objValue;
    }

    public List<b> a(Context context, Intent intent, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, context, intent, z)) == null) {
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
                                    bVar.f40532b = jSONObject.getInt("priority");
                                    bVar.f40531a = resolveInfo.activityInfo.applicationInfo;
                                    if (context.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                        bVar.f40534d = true;
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
                                                byte[] a3 = a(com.baidu.mobads.cid.cesium.d.a.a(string2.getBytes()), this.f40598a);
                                                if (a3 != null && Arrays.equals(a3, com.baidu.mobads.cid.cesium.d.c.a(a2))) {
                                                    bVar.f40533c = true;
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
            Collections.sort(arrayList, new Comparator<b>(this) { // from class: com.baidu.mobads.cid.cesium.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f40600a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f40600a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(b bVar2, b bVar3) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, bVar2, bVar3)) == null) {
                        int i3 = bVar3.f40532b - bVar2.f40532b;
                        if (i3 == 0) {
                            if (bVar2.f40534d && bVar3.f40534d) {
                                return 0;
                            }
                            if (bVar2.f40534d) {
                                return -1;
                            }
                            if (bVar3.f40534d) {
                                return 1;
                            }
                        }
                        return i3;
                    }
                    return invokeLL.intValue;
                }
            });
            return arrayList;
        }
        return (List) invokeLLZ.objValue;
    }

    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            List<b> a2 = a(context, new Intent("com.baidu.intent.action.GALAXY").setPackage(context.getPackageName()), true);
            if (a2 == null || a2.size() == 0) {
                for (int i2 = 0; i2 < 3; i2++) {
                }
                return false;
            }
            boolean z = a2.get(0).f40533c;
            if (!z) {
                for (int i3 = 0; i3 < 3; i3++) {
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public List<b> b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            List<b> list = this.f40599b;
            if (list != null) {
                return list;
            }
            a(context);
            List<b> a2 = a(context, new Intent("com.baidu.intent.action.GALAXY"), true);
            this.f40599b = a2;
            return a2;
        }
        return (List) invokeL.objValue;
    }
}
