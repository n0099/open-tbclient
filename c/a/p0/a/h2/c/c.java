package c.a.p0.a.h2.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class c<ResultDataT> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f6218f;
    public transient /* synthetic */ FieldHolder $fh;
    public final i<ResultDataT> a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<c.a.p0.a.z2.g1.c<i<ResultDataT>>> f6219b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<e> f6220c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6221d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6222e;

    /* loaded from: classes.dex */
    public class a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f6223g;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6223g = cVar;
        }

        @Override // c.a.p0.a.h2.c.e
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f6223g.k()) {
                    return true;
                }
                d.k("initialPrepare failed", Boolean.TRUE);
                throw new OAuthException(10001);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class b extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f6224g;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6224g = cVar;
        }

        @Override // c.a.p0.a.h2.c.e
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f6224g.j()) {
                    return true;
                }
                d.k("finalPrepare failed", Boolean.TRUE);
                if (c.f6218f) {
                    throw new OAuthException(10001);
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: c.a.p0.a.h2.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0328c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z2.g1.c f6225e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f6226f;

        public RunnableC0328c(c cVar, c.a.p0.a.z2.g1.c cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6226f = cVar;
            this.f6225e = cVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.p0.a.z2.g1.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f6225e) == null) {
                return;
            }
            cVar.onCallback(this.f6226f.a);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1144007858, "Lc/a/p0/a/h2/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1144007858, "Lc/a/p0/a/h2/c/c;");
                return;
            }
        }
        f6218f = k.a;
    }

    public c() {
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
        this.a = new i<>();
        this.f6219b = new HashSet();
        this.f6220c = new LinkedList<>();
        this.f6221d = false;
        this.f6222e = false;
    }

    public final synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                i();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b bVar = new b(this);
            bVar.h(this);
            bVar.g();
            this.f6222e = true;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d(null);
        }
    }

    @NonNull
    public c call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TaskState.INIT == e()) {
                s(TaskState.CALLING);
                n();
            }
            return this;
        }
        return (c) invokeV.objValue;
    }

    public void d(@Nullable Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            if (exc instanceof OAuthException) {
                this.a.f6278c = (OAuthException) exc;
            } else if (exc != null) {
                d.t("OAuthTask#finish", exc.getMessage());
                this.a.f6278c = new OAuthException(exc, 10001);
            }
            if (!this.a.c() && f6218f && exc != null) {
                exc.printStackTrace();
            }
            s(TaskState.FINISHED);
            d.k(toString(), Boolean.FALSE);
            g();
            this.f6219b.clear();
        }
    }

    public TaskState e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.f6277b : (TaskState) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a aVar = new a(this);
            aVar.h(this);
            aVar.g();
            this.f6221d = true;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            for (c.a.p0.a.z2.g1.c<i<ResultDataT>> cVar : this.f6219b) {
                d.l(new RunnableC0328c(this, cVar));
            }
        }
    }

    public c h(@NonNull e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar)) == null) {
            eVar.h(this);
            this.f6220c.offer(eVar);
            return this;
        }
        return (c) invokeL.objValue;
    }

    public abstract void i();

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void l(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            if (eVar.c()) {
                n();
            } else {
                d(eVar.b());
            }
        }
    }

    public abstract ResultDataT m(JSONObject jSONObject) throws JSONException;

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!TaskState.CALLING.equals(e())) {
                if (f6218f) {
                    d.k("IllegalState on prepare", Boolean.FALSE);
                }
            } else if (!this.f6221d) {
                f();
            } else if (!this.f6220c.isEmpty()) {
                this.f6220c.poll().g();
            } else if (!this.f6222e) {
                b();
            } else {
                a();
            }
        }
    }

    public c<ResultDataT> o(c.a.p0.a.z2.g1.c<i<ResultDataT>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, cVar)) == null) {
            if (this.a.f6277b.isCallbackAvailable()) {
                this.f6219b.add(cVar);
            }
            return this;
        }
        return (c) invokeL.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a.f6277b = TaskState.INIT;
            this.f6221d = false;
            this.f6222e = false;
        }
    }

    public c<ResultDataT> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? this : (c) invokeL.objValue;
    }

    public void r(ResultDataT resultdatat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, resultdatat) == null) {
            this.a.a = resultdatat;
        }
    }

    public final void s(TaskState taskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, taskState) == null) {
            this.a.f6277b = taskState;
        }
    }
}
