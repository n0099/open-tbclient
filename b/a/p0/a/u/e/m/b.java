package b.a.p0.a.u.e.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import b.a.p0.a.a1.e;
import b.a.p0.a.k2.h.c;
import b.a.p0.a.k2.h.d;
import b.a.p0.a.v2.q;
import b.a.p0.t.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends b.a.p0.a.u.e.m.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static volatile b.a.p0.t.b f8333d;

    /* renamed from: e  reason: collision with root package name */
    public static long f8334e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long unused = b.f8334e = b.f8333d.d();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-229868235, "Lb/a/p0/a/u/e/m/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-229868235, "Lb/a/p0/a/u/e/m/b;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull b.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        synchronized (b.class) {
            if (f8333d == null) {
                K();
            }
        }
    }

    public static synchronized void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (b.class) {
                if (f8333d == null) {
                    try {
                        f8333d = new c("swan_js_global_storage", 2, e.g().getAbsolutePath());
                    } catch (NoClassDefFoundError | UnsatisfiedLinkError unused) {
                        f8333d = new j("swan_js_global_storage");
                        d.i(1, "swan_js_global_storage");
                    }
                    L();
                }
            }
        }
    }

    public static void L() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) || f8333d == null) {
            return;
        }
        q.e().execute(new a());
    }

    @Override // b.a.p0.a.u.e.m.a
    public b.a.p0.a.u.h.b C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? super.C(str) : (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // b.a.p0.a.u.e.m.a
    public b.a.p0.a.u.h.b D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? super.D(str) : (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // b.a.p0.a.u.e.m.a
    public b.a.p0.a.u.h.b E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? super.E(str) : (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // b.a.p0.a.u.e.m.a
    public b.a.p0.a.u.h.b F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? super.F(str) : (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // b.a.p0.a.u.e.m.a
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            L();
        }
    }

    public b.a.p0.a.u.h.b J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? v() : (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    @Override // b.a.p0.a.u.e.m.a
    public b.a.p0.a.u.h.b q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? super.q() : (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    @Override // b.a.p0.a.u.e.m.a
    public b.a.p0.a.u.h.b r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? super.r() : (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    @Override // b.a.p0.a.u.e.m.a
    public b.a.p0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? super.s(str) : (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // b.a.p0.a.u.e.m.a
    public b.a.p0.t.b u(@NonNull b.a.p0.a.a2.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, eVar)) == null) ? f8333d : (b.a.p0.t.b) invokeL.objValue;
    }

    @Override // b.a.p0.a.u.e.m.a
    public b.a.p0.a.u.h.b v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SavedStateHandle.KEYS, new JSONArray((Collection) f8333d.a()));
                jSONObject.put("currentSize", f8334e / 1024);
                jSONObject.put("limitSize", 10240);
                return new b.a.p0.a.u.h.b(0, jSONObject);
            } catch (JSONException e2) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    e2.printStackTrace();
                }
                return new b.a.p0.a.u.h.b(202, "JSONException");
            }
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    @Override // b.a.p0.a.u.e.m.a
    public b.a.p0.a.u.h.b w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? super.w(str) : (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // b.a.p0.a.u.e.m.a
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.u.e.m.a
    public boolean y(@Nullable b.a.p0.a.a2.e eVar, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, eVar, str, str2)) == null) ? (f8334e - ((long) f8333d.getString(str, "").length())) + ((long) str2.length()) > 10485760 : invokeLLL.booleanValue;
    }
}
