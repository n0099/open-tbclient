package b.a.p0.j.j0;

import android.text.TextUtils;
import b.a.p0.a.g1.f;
import b.a.p0.a.k;
import b.a.p0.j.g0.e;
import b.a.p0.j.j0.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f11190h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.a.l0.c f11191e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.p0.j.d.c.a f11192f;

    /* renamed from: g  reason: collision with root package name */
    public String f11193g;

    /* loaded from: classes4.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f11194a;

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
            this.f11194a = cVar;
        }

        @Override // b.a.p0.j.j0.b.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f11194a.C(false);
                e.j(this.f11194a.f11193g, i2, "");
            }
        }

        @Override // b.a.p0.j.j0.b.a
        public void b(int i2, long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) && this.f11194a.hasEventListener("progressupdate")) {
                b.a.p0.j.j0.d.a aVar = new b.a.p0.j.j0.d.a();
                aVar.progress = i2;
                aVar.totalBytesWritten = j;
                aVar.totalBytesExpectedToWrite = j2;
                JSEvent jSEvent = new JSEvent("progressupdate");
                jSEvent.data = aVar;
                if (c.f11190h) {
                    String str = "progress :" + i2 + "totalBytesWritten :" + j + "totalBytesExpectedToWrite :" + j2;
                }
                this.f11194a.dispatchEvent(jSEvent);
            }
        }

        @Override // b.a.p0.j.j0.b.a
        public void success() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c cVar = this.f11194a;
                this.f11194a.C(cVar.D(cVar.f11193g));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11195e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f11196f;

        public b(c cVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11196f = cVar;
            this.f11195e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f11195e) {
                    if (this.f11196f.f11192f != null) {
                        this.f11196f.f11192f.c();
                        boolean unused = c.f11190h;
                    }
                } else if (this.f11196f.f11192f != null) {
                    this.f11196f.f11192f.a();
                    boolean unused2 = c.f11190h;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(724011252, "Lb/a/p0/j/j0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(724011252, "Lb/a/p0/j/j0/c;");
                return;
            }
        }
        f11190h = k.f6863a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b.a.p0.a.l0.c cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11191e = cVar;
    }

    public final void C(boolean z) {
        b.a.p0.a.l0.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (cVar = this.f11191e) == null) {
            return;
        }
        cVar.runOnJSThread(new b(this, z));
    }

    public final boolean D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.f11191e == null) {
                return false;
            }
            String str2 = f.U().z() + b.a.p0.j.j0.a.b().c(str, 2);
            String c2 = b.a.p0.j.j0.a.b().c(str, 3);
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(c2)) {
                return false;
            }
            this.f11191e.c0(str2, c2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void E(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            G();
            F(jsObject);
            if (TextUtils.isEmpty(this.f11193g)) {
                boolean z = f11190h;
                e.j(this.f11193g, 2111, "");
                return;
            }
            b.a.p0.j.j0.b.a(this.f11193g, new a(this));
        }
    }

    public final void F(JsObject jsObject) {
        b.a.p0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) || jsObject == null || (F = b.a.p0.a.y.b.a.F(jsObject)) == null) {
            return;
        }
        this.f11192f = b.a.p0.j.d.c.a.e(F);
        try {
            this.f11193g = F.g("name");
        } catch (JSTypeMismatchException e2) {
            if (f11190h) {
                e2.printStackTrace();
            }
            b.a.p0.j.n0.c.d(this.f11191e, e2);
            G();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f11192f = null;
            this.f11193g = null;
        }
    }
}
