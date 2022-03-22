package c.a.n0.a.k.c;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    public static final boolean f4950c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public d f4951b;

    /* loaded from: classes.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f4952b;

        public a(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4952b = cVar;
            this.a = str;
        }

        @Override // c.a.n0.a.k.c.c.b
        public void a(c.a.n0.a.k.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (c.f4950c) {
                    Log.d("SwanAutoSyncApiHandler", this.f4952b.a + " async callback: " + bVar.toString());
                }
                this.f4952b.f4951b.d(this.a, bVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c.a.n0.a.k.h.b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-995185475, "Lc/a/n0/a/k/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-995185475, "Lc/a/n0/a/k/c/c;");
                return;
            }
        }
        f4950c = c.a.n0.a.a.a;
    }

    public c(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
    }

    @NonNull
    public abstract c.a.n0.a.k.h.b d(@NonNull JSONObject jSONObject, @NonNull b bVar);

    @NonNull
    public abstract c.a.n0.a.k.h.b e(@NonNull JSONObject jSONObject);

    public c.a.n0.a.k.h.b f(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull d dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str, dVar)) == null) {
            this.f4951b = dVar;
            if (f4950c) {
                Log.d("SwanAutoSyncApiHandler", this.a + " is called, can use sync mode: " + i() + ", params" + jSONObject.toString() + ", callback: " + str);
            }
            return i() ? h(jSONObject) : g(jSONObject, str);
        }
        return (c.a.n0.a.k.h.b) invokeLLL.objValue;
    }

    public final c.a.n0.a.k.h.b g(@NonNull JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, jSONObject, str)) == null) {
            if (f4950c) {
                Log.d("SwanAutoSyncApiHandler", this.a + " start handle async");
            }
            c.a.n0.a.k.h.b d2 = d(jSONObject, new a(this, str));
            if (!d2.h("isSync", Boolean.FALSE)) {
                if (f4950c) {
                    Log.e("SwanAutoSyncApiHandler", this.a + " handleAsync encounter error, json exception");
                }
                return new c.a.n0.a.k.h.b(1001, "make result json error");
            }
            if (f4950c) {
                Log.d("SwanAutoSyncApiHandler", this.a + " end handle async, processing in other thread, sync result: " + d2.toString());
            }
            return d2;
        }
        return (c.a.n0.a.k.h.b) invokeLL.objValue;
    }

    public final c.a.n0.a.k.h.b h(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            if (f4950c) {
                Log.d("SwanAutoSyncApiHandler", this.a + " start handle sync");
            }
            c.a.n0.a.k.h.b e2 = e(jSONObject);
            if (!e2.h("isSync", Boolean.TRUE)) {
                if (f4950c) {
                    Log.e("SwanAutoSyncApiHandler", this.a + " handleSync encounter error, json exception");
                }
                return new c.a.n0.a.k.h.b(1001, "make result json error");
            }
            if (f4950c) {
                Log.d("SwanAutoSyncApiHandler", this.a + " end handle sync, result: " + e2.toString());
            }
            return e2;
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public abstract boolean i();
}
