package c.a.s0.a.l0;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends c.a.s0.a.l0.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean s;
    public static final Object t;
    public static String u;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends EventTargetImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c f7841e;
        @V8JavascriptField
        public b env;

        /* renamed from: f  reason: collision with root package name */
        public c.a.s0.a.r0.e f7842f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, String str) {
            super(cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((JSRuntime) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7841e = cVar;
            b bVar = new b();
            this.env = bVar;
            bVar.basePath = str;
        }

        @JavascriptInterface
        @SuppressLint({"BDThrowableCheck"})
        public String getAPIs(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (e.s) {
                    String d2 = c.a.s0.a.x1.a.a.p() ? c.a.s0.a.z2.j.d(i2, SchemeCollecter.CLASSIFY_SWAN_V8) : "";
                    c.a.s0.a.e0.d.b("SwanAppV8Engine", "getAPIs res:" + d2);
                    return d2;
                }
                String d3 = c.a.s0.a.z2.j.d(i2, SchemeCollecter.CLASSIFY_SWAN_V8);
                c.a.s0.a.e0.d.b("SwanAppV8Engine", "getAPIs description:" + d3);
                if (TextUtils.isEmpty(d3)) {
                    if (!e.s) {
                        c.a.s0.a.z2.a.c(c.a.s0.a.z2.j.b(String.format("index: %d, desc: %s, isV8: %b", Integer.valueOf(i2), d3, Boolean.TRUE)));
                    } else {
                        c.a.s0.a.z2.j.i();
                        throw new RuntimeException(String.format("getAPIs cannot find index: %d, desc: %s", Integer.valueOf(i2), d3));
                    }
                } else {
                    c.a.s0.a.z2.a.d();
                }
                return d3;
            }
            return (String) invokeI.objValue;
        }

        @JavascriptInterface
        public String getDevToolsResponse() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (e.s) {
                    String str = "getDevToolsResponse = " + e.u;
                }
                return e.u;
            }
            return (String) invokeV.objValue;
        }

        @JavascriptInterface
        public String getEnvVariables() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.s0.a.d1.b.b.a(this.f7841e) : (String) invokeV.objValue;
        }

        @JavascriptInterface
        public c.a.s0.a.r0.e getFileSystemManager() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f7842f == null) {
                    this.f7842f = new c.a.s0.a.r0.e((c.a.s0.a.l0.a) this.f7841e);
                }
                return this.f7842f;
            }
            return (c.a.s0.a.r0.e) invokeV.objValue;
        }

        @JavascriptInterface
        public JSONObject getNACanIUseMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                JSONObject b2 = c.a.s0.a.o1.d.b();
                c.a.s0.a.e0.d.k("SwanAppV8Engine", "getNACanIUseMap - " + b2.toString());
                return b2;
            }
            return (JSONObject) invokeV.objValue;
        }

        @JavascriptInterface
        public boolean lockMaster() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                c.a.s0.a.e0.d.k("SwanAppV8Engine", "lockMaster");
                synchronized (e.t) {
                    try {
                        try {
                            e.t.wait();
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                            return false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @JavascriptInterface
        public void setDevToolsResponse(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                if (e.s) {
                    String str2 = "setDevToolsResponse = " + str;
                }
                e.u = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(233160679, "Lc/a/s0/a/l0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(233160679, "Lc/a/s0/a/l0/e;");
                return;
            }
        }
        s = c.a.s0.a.k.a;
        t = new Object();
        u = "";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NonNull String str, @NonNull c.a.s0.a.l0.p.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        super(str, bVar, v8ThreadDelegatePolicy);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bVar, v8ThreadDelegatePolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (c.a.s0.a.l0.p.b) objArr2[1], (V8ThreadDelegatePolicy) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.s0.a.l0.a
    @NonNull
    public EventTarget B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar = new a(this, this.f7833f.getInitBasePath());
            aVar.env.config = c.a.s0.a.q2.c.a.b();
            return aVar;
        }
        return (EventTarget) invokeV.objValue;
    }

    @Override // c.a.s0.a.l0.c, com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }
}
