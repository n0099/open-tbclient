package com.baidu.sofire.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.a.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("0", aVar.a);
                jSONObject.put("1", aVar.c);
                jSONObject.put("2", aVar.d);
                jSONObject.put("3", aVar.e);
                jSONObject.put("4", aVar.b);
            } catch (Throwable unused) {
                int i = b.a;
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                String str = this.d;
                if (str == null) {
                    if (aVar.d != null) {
                        return false;
                    }
                } else if (!str.equals(aVar.d)) {
                    return false;
                }
                String str2 = this.e;
                if (str2 == null) {
                    if (aVar.e != null) {
                        return false;
                    }
                } else if (!str2.equals(aVar.e)) {
                    return false;
                }
                String str3 = this.b;
                if (str3 == null) {
                    if (aVar.b != null) {
                        return false;
                    }
                } else if (!str3.equals(aVar.b)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = this.d;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.e;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.b;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }
        return invokeV.intValue;
    }
}
