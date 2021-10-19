package com.baidu.sofire.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.utility.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f45230a;

    /* renamed from: b  reason: collision with root package name */
    public String f45231b;

    /* renamed from: c  reason: collision with root package name */
    public String f45232c;

    /* renamed from: d  reason: collision with root package name */
    public String f45233d;

    /* renamed from: e  reason: collision with root package name */
    public String f45234e;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("0", aVar.f45230a);
                jSONObject.put("1", aVar.f45232c);
                jSONObject.put("2", aVar.f45233d);
                jSONObject.put("3", aVar.f45234e);
                jSONObject.put("4", aVar.f45231b);
            } catch (Throwable unused) {
                c.a();
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public final boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                String str = this.f45233d;
                if (str == null) {
                    if (aVar.f45233d != null) {
                        return false;
                    }
                } else if (!str.equals(aVar.f45233d)) {
                    return false;
                }
                String str2 = this.f45234e;
                if (str2 == null) {
                    if (aVar.f45234e != null) {
                        return false;
                    }
                } else if (!str2.equals(aVar.f45234e)) {
                    return false;
                }
                String str3 = this.f45231b;
                if (str3 == null) {
                    if (aVar.f45231b != null) {
                        return false;
                    }
                } else if (!str3.equals(aVar.f45231b)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = this.f45233d;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.f45234e;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f45231b;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public static a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            a aVar = new a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                aVar.f45230a = jSONObject.optString("0");
                aVar.f45232c = jSONObject.optString("1");
                aVar.f45233d = jSONObject.optString("2");
                aVar.f45234e = jSONObject.optString("3");
                aVar.f45231b = jSONObject.optString("4");
                return aVar;
            } catch (Exception unused) {
                c.a();
                return null;
            }
        }
        return (a) invokeL.objValue;
    }
}
