package com.baidu.mobstat;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.bs;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ap {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public JSONArray c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public long h;
    public long i;
    public long j;
    public int k;
    public String l;
    public String m;
    public String n;
    public JSONArray o;

    public ap(String str, String str2, JSONArray jSONArray, String str3, String str4, String str5, String str6, boolean z, int i, long j, long j2, long j3, String str7, String str8, JSONArray jSONArray2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, jSONArray, str3, str4, str5, str6, Boolean.valueOf(z), Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str7, str8, jSONArray2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = str2;
        this.c = jSONArray;
        this.d = str3;
        this.e = str5;
        this.f = str6;
        this.g = z;
        this.k = i;
        this.h = j;
        this.i = j2;
        this.j = j3;
        this.l = str7;
        this.m = str8;
        this.n = str4;
        this.o = jSONArray2;
    }

    public static String a(String str, String str2, JSONArray jSONArray, String str3, String str4, String str5, boolean z) {
        InterceptResult invokeCommon;
        String str6;
        int i;
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
                if (z) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("user", i);
                str6 = jSONObject.toString();
            } catch (Exception unused) {
                str6 = "";
            }
            if (TextUtils.isEmpty(str6)) {
                return "";
            }
            return bs.a.a(str6.getBytes());
        }
        return (String) invokeCommon.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public JSONArray c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return (JSONArray) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.h;
        }
        return invokeV.longValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.i;
        }
        return invokeV.longValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.j;
        }
        return invokeV.longValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Object obj;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3)) == null) {
            String a = a(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
            if (TextUtils.isEmpty(a)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.a);
                jSONObject.put("d", this.l);
                jSONObject.put("p", str);
                jSONObject.put("path", str3);
                if (this.o != null && this.o.length() != 0) {
                    obj = this.o;
                    jSONObject.put("v5", obj);
                    jSONObject.put("title", this.d);
                    jSONObject.put("content", this.n);
                    jSONObject.put("index", this.e);
                    jSONObject.put("n", str2);
                    if (!this.g) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    jSONObject.put("user", i);
                    jSONObject.put("c", this.k);
                    jSONObject.put("t", this.h);
                    jSONObject.put("ps", this.m);
                    jSONObject.put("sign", a);
                    return jSONObject;
                }
                obj = "";
                jSONObject.put("v5", obj);
                jSONObject.put("title", this.d);
                jSONObject.put("content", this.n);
                jSONObject.put("index", this.e);
                jSONObject.put("n", str2);
                if (!this.g) {
                }
                jSONObject.put("user", i);
                jSONObject.put("c", this.k);
                jSONObject.put("t", this.h);
                jSONObject.put("ps", this.m);
                jSONObject.put("sign", a);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.k = i;
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
            this.i = j;
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
}
