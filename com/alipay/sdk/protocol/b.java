package com.alipay.sdk.protocol;

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
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f34995a;

    /* renamed from: b  reason: collision with root package name */
    public String f34996b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f34997c;

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34996b = str;
    }

    public static void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bVar) == null) {
            String[] c2 = bVar.c();
            if (c2.length == 3 && TextUtils.equals("tid", c2[0])) {
                com.alipay.sdk.tid.a a2 = com.alipay.sdk.tid.a.a(com.alipay.sdk.sys.b.d().b());
                if (TextUtils.isEmpty(c2[1]) || TextUtils.isEmpty(c2[2])) {
                    return;
                }
                a2.a(c2[1], c2[2]);
            }
        }
    }

    public static String[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int indexOf = str.indexOf(40);
            int lastIndexOf = str.lastIndexOf(41);
            if (indexOf == -1 || lastIndexOf == -1 || lastIndexOf <= indexOf) {
                return null;
            }
            for (String str2 : str.substring(indexOf + 1, lastIndexOf).split("' *, *'", -1)) {
                arrayList.add(str2.trim().replaceAll("'", "").replaceAll("\"", ""));
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) invokeL.objValue;
    }

    public String[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34997c : (String[]) invokeV.objValue;
    }

    public b(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f34996b = str;
        this.f34995a = aVar;
    }

    public static List<b> a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONObject == null) {
                return arrayList;
            }
            String[] a2 = a(jSONObject.optString("name", ""));
            for (int i2 = 0; i2 < a2.length; i2++) {
                a a3 = a.a(a2[i2]);
                if (a3 != a.f34987b) {
                    b bVar = new b(a2[i2], a3);
                    bVar.f34997c = b(a2[i2]);
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34996b : (String) invokeV.objValue;
    }

    public static String[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str.split(";");
        }
        return (String[]) invokeL.objValue;
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34995a : (a) invokeV.objValue;
    }
}
