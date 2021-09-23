package c.a.p0.h.i0;

import android.text.TextUtils;
import c.a.p0.a.g1.f;
import c.a.p0.a.k;
import c.a.p0.h.f0.e;
import c.a.p0.h.i0.b;
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
/* loaded from: classes3.dex */
public class c extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f11274h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.a.l0.c f11275e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.h.d.c.a f11276f;

    /* renamed from: g  reason: collision with root package name */
    public String f11277g;

    /* loaded from: classes3.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f11278a;

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
            this.f11278a = cVar;
        }

        @Override // c.a.p0.h.i0.b.a
        public void a(int i2, long j2, long j3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)}) == null) && this.f11278a.hasEventListener("progressupdate")) {
                c.a.p0.h.i0.d.a aVar = new c.a.p0.h.i0.d.a();
                aVar.progress = i2;
                aVar.totalBytesWritten = j2;
                aVar.totalBytesExpectedToWrite = j3;
                JSEvent jSEvent = new JSEvent("progressupdate");
                jSEvent.data = aVar;
                if (c.f11274h) {
                    String str = "progress :" + i2 + "totalBytesWritten :" + j2 + "totalBytesExpectedToWrite :" + j3;
                }
                this.f11278a.dispatchEvent(jSEvent);
            }
        }

        @Override // c.a.p0.h.i0.b.a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f11278a.C(false);
                e.j(this.f11278a.f11277g, i2, "");
            }
        }

        @Override // c.a.p0.h.i0.b.a
        public void success() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c cVar = this.f11278a;
                this.f11278a.C(cVar.D(cVar.f11277g));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11279e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f11280f;

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
            this.f11280f = cVar;
            this.f11279e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f11279e) {
                    if (this.f11280f.f11276f != null) {
                        this.f11280f.f11276f.c();
                        boolean unused = c.f11274h;
                    }
                } else if (this.f11280f.f11276f != null) {
                    this.f11280f.f11276f.a();
                    boolean unused2 = c.f11274h;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1557478256, "Lc/a/p0/h/i0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1557478256, "Lc/a/p0/h/i0/c;");
                return;
            }
        }
        f11274h = k.f7085a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(c.a.p0.a.l0.c cVar) {
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
        this.f11275e = cVar;
    }

    public final void C(boolean z) {
        c.a.p0.a.l0.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (cVar = this.f11275e) == null) {
            return;
        }
        cVar.runOnJSThread(new b(this, z));
    }

    public final boolean D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.f11275e == null) {
                return false;
            }
            String str2 = f.V().A() + c.a.p0.h.i0.a.b().c(str, 2);
            String c2 = c.a.p0.h.i0.a.b().c(str, 3);
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(c2)) {
                return false;
            }
            this.f11275e.a0(str2, c2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void E(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            G();
            F(jsObject);
            if (TextUtils.isEmpty(this.f11277g)) {
                boolean z = f11274h;
                e.j(this.f11277g, 2111, "");
                return;
            }
            c.a.p0.h.i0.b.a(this.f11277g, new a(this));
        }
    }

    public final void F(JsObject jsObject) {
        c.a.p0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) || jsObject == null || (G = c.a.p0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        this.f11276f = c.a.p0.h.d.c.a.e(G);
        try {
            this.f11277g = G.g("name");
        } catch (JSTypeMismatchException e2) {
            if (f11274h) {
                e2.printStackTrace();
            }
            c.a.p0.h.m0.c.e(this.f11275e, e2);
            G();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f11276f = null;
            this.f11277g = null;
        }
    }
}
