package b.a.k0.a.c;

import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.smallgame.sdk.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static int f3295d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static int f3296e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static int f3297f = 3;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f3298a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f3299b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f3300c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-618461417, "Lb/a/k0/a/c/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-618461417, "Lb/a/k0/a/c/a;");
        }
    }

    public a() {
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
        this.f3298a = new HashMap();
        this.f3299b = new HashMap();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f3298a.clear();
        }
    }

    public String b(int i2, String str) {
        InterceptResult invokeIL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str)) == null) {
            if (i2 == f3295d) {
                str2 = this.f3298a.get(str);
            } else if (i2 == f3296e) {
                str2 = this.f3299b.get(str);
            } else {
                if (i2 == f3297f) {
                    SharedPreferences sharedPreferences = this.f3300c;
                    if (sharedPreferences != null) {
                        str2 = sharedPreferences.getString(str, "");
                    } else {
                        Log.e("TAG", "prefs data store is null");
                    }
                }
                str2 = null;
            }
            return str2 == null ? "" : str2;
        }
        return (String) invokeIL.objValue;
    }

    public void c(SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sharedPreferences) == null) {
            this.f3300c = sharedPreferences;
        }
    }

    public void d(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, str, str2) == null) {
            if (i2 == f3295d) {
                this.f3298a.put(str, str2);
            } else if (i2 == f3296e) {
                this.f3299b.put(str, str2);
            } else if (i2 == f3297f) {
                SharedPreferences sharedPreferences = this.f3300c;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString(str, str2).commit();
                } else {
                    Log.e("TAG", "prefs data store is null");
                }
            }
        }
    }
}
