package c.a.r0.a.u.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f8900c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public d f8901b;

    /* loaded from: classes.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f8902b;

        public a(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8902b = cVar;
            this.a = str;
        }

        @Override // c.a.r0.a.u.c.c.b
        public void a(c.a.r0.a.u.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (c.f8900c) {
                    String str = this.f8902b.a + " async callback: " + bVar.toString();
                }
                this.f8902b.f8901b.d(this.a, bVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c.a.r0.a.u.h.b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(693235191, "Lc/a/r0/a/u/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(693235191, "Lc/a/r0/a/u/c/c;");
                return;
            }
        }
        f8900c = k.a;
    }

    public c(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
    }

    @NonNull
    public abstract c.a.r0.a.u.h.b d(@NonNull JSONObject jSONObject, @NonNull b bVar);

    @NonNull
    public abstract c.a.r0.a.u.h.b e(@NonNull JSONObject jSONObject);

    public c.a.r0.a.u.h.b f(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull d dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str, dVar)) == null) {
            this.f8901b = dVar;
            if (f8900c) {
                String str2 = this.a + " is called, can use sync mode: " + i() + ", params" + jSONObject.toString() + ", callback: " + str;
            }
            return i() ? h(jSONObject) : g(jSONObject, str);
        }
        return (c.a.r0.a.u.h.b) invokeLLL.objValue;
    }

    public final c.a.r0.a.u.h.b g(@NonNull JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, jSONObject, str)) == null) {
            if (f8900c) {
                String str2 = this.a + " start handle async";
            }
            c.a.r0.a.u.h.b d2 = d(jSONObject, new a(this, str));
            if (!d2.h("isSync", Boolean.FALSE)) {
                if (f8900c) {
                    String str3 = this.a + " handleAsync encounter error, json exception";
                }
                return new c.a.r0.a.u.h.b(1001, "make result json error");
            }
            if (f8900c) {
                String str4 = this.a + " end handle async, processing in other thread, sync result: " + d2.toString();
            }
            return d2;
        }
        return (c.a.r0.a.u.h.b) invokeLL.objValue;
    }

    public final c.a.r0.a.u.h.b h(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            if (f8900c) {
                String str = this.a + " start handle sync";
            }
            c.a.r0.a.u.h.b e2 = e(jSONObject);
            if (!e2.h("isSync", Boolean.TRUE)) {
                if (f8900c) {
                    String str2 = this.a + " handleSync encounter error, json exception";
                }
                return new c.a.r0.a.u.h.b(1001, "make result json error");
            }
            if (f8900c) {
                String str3 = this.a + " end handle sync, result: " + e2.toString();
            }
            return e2;
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    public abstract boolean i();
}
