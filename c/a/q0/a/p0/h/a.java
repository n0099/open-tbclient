package c.a.q0.a.p0.h;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.k;
import c.a.q0.w.d;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f7697c;

    /* renamed from: d  reason: collision with root package name */
    public static a f7698d;

    /* renamed from: e  reason: collision with root package name */
    public static a f7699e;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f7700b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-273923976, "Lc/a/q0/a/p0/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-273923976, "Lc/a/q0/a/p0/h/a;");
                return;
            }
        }
        f7697c = k.a;
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
            }
        }
    }

    @NonNull
    public static a a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (f7698d == null) {
                f7698d = d(e(str));
            }
            return f7698d;
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public static a b(@NonNull c.a.q0.a.p0.g.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) {
            if (aVar.c() == 1) {
                return c(aVar.d());
            }
            return a(aVar.d());
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public static a c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (f7699e == null) {
                f7699e = d(e(str));
            }
            return f7699e;
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public static a d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, jSONObject)) == null) {
            a aVar = new a();
            if (jSONObject != null) {
                aVar.a = jSONObject.optString("extension-core-version-name");
                aVar.f7700b = jSONObject.optLong("extension-core-version-code");
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static JSONObject e(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            boolean z = f7697c;
            String D = d.D(AppRuntime.getAppContext(), str);
            if (TextUtils.isEmpty(D)) {
                boolean z2 = f7697c;
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(D);
                if (f7697c) {
                    String str2 = "readPresetConfig end. config: " + jSONObject.toString();
                }
                return jSONObject;
            } catch (JSONException e2) {
                if (f7697c) {
                    throw new RuntimeException(e2);
                }
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}
