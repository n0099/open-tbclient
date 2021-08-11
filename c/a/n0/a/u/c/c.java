package c.a.n0.a.u.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.a.k;
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
    public static final boolean f8448c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f8449a;

    /* renamed from: b  reason: collision with root package name */
    public d f8450b;

    /* loaded from: classes.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8451a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f8452b;

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
            this.f8452b = cVar;
            this.f8451a = str;
        }

        @Override // c.a.n0.a.u.c.c.b
        public void a(c.a.n0.a.u.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (c.f8448c) {
                    String str = this.f8452b.f8449a + " async callback: " + bVar.toString();
                }
                this.f8452b.f8450b.d(this.f8451a, bVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c.a.n0.a.u.h.b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-708893965, "Lc/a/n0/a/u/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-708893965, "Lc/a/n0/a/u/c/c;");
                return;
            }
        }
        f8448c = k.f6803a;
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
        this.f8449a = str;
    }

    @NonNull
    public abstract c.a.n0.a.u.h.b d(@NonNull JSONObject jSONObject, @NonNull b bVar);

    @NonNull
    public abstract c.a.n0.a.u.h.b e(@NonNull JSONObject jSONObject);

    public c.a.n0.a.u.h.b f(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull d dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str, dVar)) == null) {
            this.f8450b = dVar;
            if (f8448c) {
                String str2 = this.f8449a + " is called, can use sync mode: " + i() + ", params" + jSONObject.toString() + ", callback: " + str;
            }
            return i() ? h(jSONObject) : g(jSONObject, str);
        }
        return (c.a.n0.a.u.h.b) invokeLLL.objValue;
    }

    public final c.a.n0.a.u.h.b g(@NonNull JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, jSONObject, str)) == null) {
            if (f8448c) {
                String str2 = this.f8449a + " start handle async";
            }
            c.a.n0.a.u.h.b d2 = d(jSONObject, new a(this, str));
            if (!d2.d("isSync", Boolean.FALSE)) {
                if (f8448c) {
                    String str3 = this.f8449a + " handleAsync encounter error, json exception";
                }
                return new c.a.n0.a.u.h.b(1001, "make result json error");
            }
            if (f8448c) {
                String str4 = this.f8449a + " end handle async, processing in other thread, sync result: " + d2.toString();
            }
            return d2;
        }
        return (c.a.n0.a.u.h.b) invokeLL.objValue;
    }

    public final c.a.n0.a.u.h.b h(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            if (f8448c) {
                String str = this.f8449a + " start handle sync";
            }
            c.a.n0.a.u.h.b e2 = e(jSONObject);
            if (!e2.d("isSync", Boolean.TRUE)) {
                if (f8448c) {
                    String str2 = this.f8449a + " handleSync encounter error, json exception";
                }
                return new c.a.n0.a.u.h.b(1001, "make result json error");
            }
            if (f8448c) {
                String str3 = this.f8449a + " end handle sync, result: " + e2.toString();
            }
            return e2;
        }
        return (c.a.n0.a.u.h.b) invokeL.objValue;
    }

    public abstract boolean i();
}
