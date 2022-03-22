package c.a.n0.a.x.k;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.e0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.u.f.d.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
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
/* loaded from: classes.dex */
public class d extends c.a.n0.a.b0.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends EventTargetImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @V8JavascriptField
        public c.a.n0.a.b0.b env;

        /* renamed from: c.a.n0.a.x.k.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0542a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0542a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e0.a(c.a.n0.a.w0.f.U().getActivity());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c.a.n0.a.b0.c cVar, String str) {
            super(cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((JSRuntime) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            c.a.n0.a.b0.b bVar = new c.a.n0.a.b0.b();
            this.env = bVar;
            bVar.basePath = str;
        }

        @JavascriptInterface
        public void addMask() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.u.d.k("SwanAppV8DaemonEngine", "addMask");
                c.a.n0.a.u.f.d.e.b();
            }
        }

        @JavascriptInterface
        public String closeConnect(JsObject jsObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject)) == null) {
                if (d.o) {
                    Log.d("SwanAppV8DaemonEngine", "closeConnect params = " + jsObject);
                }
                return g.d(jsObject);
            }
            return (String) invokeL.objValue;
        }

        @JavascriptInterface
        public String connectDevTool(JsObject jsObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject)) == null) {
                if (d.o) {
                    Log.d("SwanAppV8DaemonEngine", "connectDevTool params = " + jsObject);
                }
                return g.e(jsObject);
            }
            return (String) invokeL.objValue;
        }

        @JavascriptInterface
        public boolean freeMaster() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                c.a.n0.a.u.d.k("SwanAppV8DaemonEngine", "freeMaster");
                synchronized (c.a.n0.a.b0.e.p) {
                    try {
                        try {
                            c.a.n0.a.b0.e.p.notify();
                        } catch (IllegalMonitorStateException e2) {
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
        public String getDevToolsResponse() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (d.o) {
                    Log.d("SwanAppV8DaemonEngine", "getDevToolsResponse = " + c.a.n0.a.b0.e.q);
                }
                return c.a.n0.a.b0.e.q;
            }
            return (String) invokeV.objValue;
        }

        @JavascriptInterface
        public void reload() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                c.a.n0.a.u.d.k("SwanAppV8DaemonEngine", "reload");
                q0.a0(new RunnableC0542a(this));
            }
        }

        @JavascriptInterface
        public void removeMask() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                c.a.n0.a.u.d.k("SwanAppV8DaemonEngine", "removeMask");
                c.a.n0.a.u.f.d.e.c();
            }
        }

        @JavascriptInterface
        public String sendMsgToDevTool(JsObject jsObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jsObject)) == null) {
                if (d.o) {
                    Log.d("SwanAppV8DaemonEngine", "sendMsgToDevTool params = " + jsObject);
                }
                return g.m(jsObject);
            }
            return (String) invokeL.objValue;
        }

        @JavascriptInterface
        public void setDevToolsResponse(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                if (d.o) {
                    Log.d("SwanAppV8DaemonEngine", "setDevToolsResponse = " + str);
                }
                c.a.n0.a.b0.e.q = str;
            }
        }

        @JavascriptInterface
        public void shutdown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                c.a.n0.a.u.d.k("SwanAppV8DaemonEngine", "shutdown");
                c.a.n0.a.u.f.d.f.k().r();
                c.a.n0.a.w0.f.U().exit();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622768153, "Lc/a/n0/a/x/k/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622768153, "Lc/a/n0/a/x/k/d;");
                return;
            }
        }
        o = c.a.n0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull String str, @NonNull c.a.n0.a.b0.p.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        super(str, bVar, v8ThreadDelegatePolicy);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bVar, v8ThreadDelegatePolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (c.a.n0.a.b0.p.b) objArr2[1], (V8ThreadDelegatePolicy) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.b0.c, com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.n0.a.b0.a
    @NonNull
    public EventTarget w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = new a(this, this.f3878b.getInitBasePath());
            aVar.env.config = c.a.n0.a.g2.c.a.b();
            return aVar;
        }
        return (EventTarget) invokeV.objValue;
    }
}
