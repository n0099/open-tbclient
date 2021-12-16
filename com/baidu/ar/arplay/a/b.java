package com.baidu.ar.arplay.a;

import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static int dj = 1;
    public static int dk = 2;
    public static int dl = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> dm;
    public Map<String, String> dn;

    /* renamed from: do  reason: not valid java name */
    public SharedPreferences f0do;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1109143775, "Lcom/baidu/ar/arplay/a/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1109143775, "Lcom/baidu/ar/arplay/a/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.dm = new HashMap();
        this.dn = new HashMap();
    }

    public void a(SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sharedPreferences) == null) {
            this.f0do = sharedPreferences;
        }
    }

    public void clearARMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.dm.clear();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getValue(int i2, String str) {
        InterceptResult invokeIL;
        String string;
        SharedPreferences sharedPreferences;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str)) != null) {
            return (String) invokeIL.objValue;
        }
        if (i2 == dj) {
            map = this.dm;
        } else if (i2 != dk) {
            string = (i2 != dl || (sharedPreferences = this.f0do) == null) ? null : sharedPreferences.getString(str, "");
            return string != null ? "" : string;
        } else {
            map = this.dn;
        }
        string = map.get(str);
        if (string != null) {
        }
    }

    public void setValue(int i2, String str, String str2) {
        SharedPreferences sharedPreferences;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, str, str2) == null) {
            if (i2 == dj) {
                map = this.dm;
            } else if (i2 != dk) {
                if (i2 != dl || (sharedPreferences = this.f0do) == null) {
                    return;
                }
                sharedPreferences.edit().putString(str, str2).commit();
                return;
            } else {
                map = this.dn;
            }
            map.put(str, str2);
        }
    }
}
