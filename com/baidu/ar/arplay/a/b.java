package com.baidu.ar.arplay.a;

import android.content.SharedPreferences;
import android.util.Log;
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
/* loaded from: classes3.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    /* JADX WARN: Removed duplicated region for block: B:20:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getValue(int i, String str) {
        InterceptResult invokeIL;
        String str2;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str)) != null) {
            return (String) invokeIL.objValue;
        }
        if (i == dj) {
            map = this.dm;
        } else if (i == dk) {
            map = this.dn;
        } else {
            if (i == dl) {
                SharedPreferences sharedPreferences = this.f0do;
                if (sharedPreferences != null) {
                    str2 = sharedPreferences.getString(str, "");
                    return str2 == null ? "" : str2;
                }
                Log.e("TAG", "prefs data store is null");
            }
            str2 = null;
            if (str2 == null) {
            }
        }
        str2 = map.get(str);
        if (str2 == null) {
        }
    }

    public void setValue(int i, String str, String str2) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, str, str2) == null) {
            if (i == dj) {
                map = this.dm;
            } else if (i != dk) {
                if (i == dl) {
                    SharedPreferences sharedPreferences = this.f0do;
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putString(str, str2).commit();
                        return;
                    } else {
                        Log.e("TAG", "prefs data store is null");
                        return;
                    }
                }
                return;
            } else {
                map = this.dn;
            }
            map.put(str, str2);
        }
    }
}
