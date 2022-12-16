package com.alipay.sdk.protocol;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public String b;
    public String[] c;

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = str;
    }

    public static String[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                return str.split(";");
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    public b(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = str;
        this.a = aVar;
    }

    public static List<b> a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONObject == null) {
                return arrayList;
            }
            String[] a = a(jSONObject.optString("name", ""));
            for (int i = 0; i < a.length; i++) {
                a a2 = a.a(a[i]);
                if (a2 != a.b) {
                    b bVar = new b(a[i], a2);
                    bVar.c = b(a[i]);
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int indexOf = str.indexOf(40);
            int lastIndexOf = str.lastIndexOf(41);
            if (indexOf != -1 && lastIndexOf != -1 && lastIndexOf > indexOf) {
                for (String str2 : str.substring(indexOf + 1, lastIndexOf).split("' *, *'", -1)) {
                    arrayList.add(str2.trim().replaceAll("'", "").replaceAll("\"", ""));
                }
                return (String[]) arrayList.toArray(new String[0]);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    public static void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bVar) == null) {
            String[] c = bVar.c();
            if (c.length == 3 && TextUtils.equals("tid", c[0])) {
                com.alipay.sdk.tid.a a = com.alipay.sdk.tid.a.a(com.alipay.sdk.sys.b.d().b());
                if (!TextUtils.isEmpty(c[1]) && !TextUtils.isEmpty(c[2])) {
                    a.a(c[1], c[2]);
                }
            }
        }
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (a) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public String[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (String[]) invokeV.objValue;
    }
}
