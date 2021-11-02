package b.a.p0.a.p0.h;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.t.d;
import com.baidu.mobads.container.util.AdIconUtil;
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
    public static final boolean f7285c;

    /* renamed from: d  reason: collision with root package name */
    public static a f7286d;

    /* renamed from: e  reason: collision with root package name */
    public static a f7287e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f7288a;

    /* renamed from: b  reason: collision with root package name */
    public long f7289b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(107527482, "Lb/a/p0/a/p0/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(107527482, "Lb/a/p0/a/p0/h/a;");
                return;
            }
        }
        f7285c = k.f6397a;
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
            if (f7286d == null) {
                f7286d = d(e(str));
            }
            return f7286d;
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public static a b(@NonNull b.a.p0.a.p0.g.c.a aVar) {
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
            if (f7287e == null) {
                f7287e = d(e(str));
            }
            return f7287e;
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public static a d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, jSONObject)) == null) {
            a aVar = new a();
            if (jSONObject != null) {
                aVar.f7288a = jSONObject.optString("extension-core-version-name");
                aVar.f7289b = jSONObject.optLong("extension-core-version-code");
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public static JSONObject e(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            boolean z = f7285c;
            String C = d.C(AppRuntime.getAppContext(), str);
            if (TextUtils.isEmpty(C)) {
                boolean z2 = f7285c;
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(C);
                if (f7285c) {
                    String str2 = "readPresetConfig end. config: " + jSONObject.toString();
                }
                return jSONObject;
            } catch (JSONException e2) {
                if (f7285c) {
                    throw new RuntimeException(e2);
                }
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}
