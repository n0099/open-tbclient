package com.baidu.mobstat;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.bt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class aq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f8723a;

    /* renamed from: b  reason: collision with root package name */
    public String f8724b;

    /* renamed from: c  reason: collision with root package name */
    public JSONArray f8725c;

    /* renamed from: d  reason: collision with root package name */
    public String f8726d;

    /* renamed from: e  reason: collision with root package name */
    public String f8727e;

    /* renamed from: f  reason: collision with root package name */
    public String f8728f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8729g;

    /* renamed from: h  reason: collision with root package name */
    public long f8730h;

    /* renamed from: i  reason: collision with root package name */
    public long f8731i;
    public long j;
    public int k;
    public String l;
    public String m;

    public aq(String str, String str2, JSONArray jSONArray, String str3, String str4, String str5, boolean z, int i2, long j, long j2, long j3, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, jSONArray, str3, str4, str5, Boolean.valueOf(z), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str6, str7};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f8723a = str;
        this.f8724b = str2;
        this.f8725c = jSONArray;
        this.f8726d = str3;
        this.f8727e = str4;
        this.f8728f = str5;
        this.f8729g = z;
        this.k = i2;
        this.f8730h = j;
        this.f8731i = j2;
        this.j = j3;
        this.l = str6;
        this.m = str7;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f8723a : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f8724b : (String) invokeV.objValue;
    }

    public JSONArray c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f8725c : (JSONArray) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f8726d : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f8727e : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f8728f : (String) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f8729g : invokeV.booleanValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : invokeV.intValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f8730h : invokeV.longValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f8731i : invokeV.longValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.j : invokeV.longValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.k = i2;
        }
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.j = j;
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.f8731i = j;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.m = str;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.l = str;
        }
    }

    public JSONObject a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3)) == null) {
            String a2 = a(this.f8723a, this.f8724b, this.f8725c, this.f8726d, this.f8727e, this.f8728f, this.f8729g);
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f8723a);
                jSONObject.put("d", this.l);
                jSONObject.put("p", str);
                jSONObject.put("path", str3);
                jSONObject.put("title", this.f8726d);
                jSONObject.put("index", this.f8727e);
                jSONObject.put("n", str2);
                jSONObject.put("user", this.f8729g ? 1 : 0);
                jSONObject.put("c", this.k);
                jSONObject.put("t", this.f8730h);
                jSONObject.put("ps", this.m);
                jSONObject.put("sign", a2);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public static String a(String str, String str2, JSONArray jSONArray, String str3, String str4, String str5, boolean z) {
        InterceptResult invokeCommon;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, str2, jSONArray, str3, str4, str5, Boolean.valueOf(z)})) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("p", str2);
                jSONObject.put("path", jSONArray);
                jSONObject.put("title", str3);
                jSONObject.put("index", str4);
                jSONObject.put("n", str5);
                jSONObject.put("user", z ? 1 : 0);
                str6 = jSONObject.toString();
            } catch (Exception unused) {
                str6 = "";
            }
            return !TextUtils.isEmpty(str6) ? bt.a.a(str6.getBytes()) : "";
        }
        return (String) invokeCommon.objValue;
    }
}
