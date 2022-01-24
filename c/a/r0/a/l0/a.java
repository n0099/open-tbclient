package c.a.r0.a.l0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h0.d.a;
import c.a.r0.a.p.b.a.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.CustomJsCodeCacheHandler;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsCodeCacheCallback;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy;
import com.baidu.searchbox.v8engine.net.NetRequest;
import com.baidu.searchbox.v8engine.thread.V8ExecuteCallback;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a implements c.a.r0.a.l0.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public V8Engine f7732e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.a.l0.p.b f7733f;

    /* renamed from: g  reason: collision with root package name */
    public final String f7734g;

    /* renamed from: h  reason: collision with root package name */
    public EventTarget f7735h;

    /* renamed from: i  reason: collision with root package name */
    public EventTarget f7736i;

    /* renamed from: j  reason: collision with root package name */
    public Context f7737j;
    public c.a.r0.a.l0.m.a k;
    public c.a.r0.a.l0.m.b l;
    public c.a.r0.a.l0.l.a m;
    public List<JSEvent> n;
    public int o;
    public boolean p;
    public boolean q;

    /* renamed from: c.a.r0.a.l0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0460a extends CustomJsCodeCacheHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0460a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.v8engine.CustomJsCodeCacheHandler
        public String getJsCodeCacheFilePath(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                float b2 = a.b.b() * 1024.0f;
                if (b2 <= 0.0f || ((float) file.length()) >= b2) {
                    return str + "_cache";
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements V8Engine.V8StatusListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.r0.a.u.e.i.e.f(this.a.f7732e);
                this.a.B0();
            }
        }

        @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements V8ExecuteCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ExecuteCallback
        public void onExecuted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = a.r;
                this.a.y0();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSEvent f7738e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7739f;

        public d(a aVar, JSEvent jSEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jSEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7739f = aVar;
            this.f7738e = jSEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.f7739f.w0()) {
                    boolean unused = a.r;
                    this.f7739f.n.add(this.f7738e);
                    return;
                }
                this.f7739f.f7735h.dispatchEvent(this.f7738e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7740e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7740e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (JSEvent jSEvent : this.f7740e.n) {
                    if (a.r) {
                        String str = "doPendingDispatch event type: " + jSEvent.type;
                    }
                    this.f7740e.dispatchEvent(jSEvent);
                }
                this.f7740e.n.clear();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(429674060, "Lc/a/r0/a/l0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(429674060, "Lc/a/r0/a/l0/a;");
                return;
            }
        }
        r = c.a.r0.a.k.a;
        c.a.r0.a.k2.d.c();
    }

    public a(@NonNull String str, @NonNull c.a.r0.a.l0.p.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bVar, v8ThreadDelegatePolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = 0;
        this.q = false;
        this.f7734g = str;
        this.f7733f = bVar;
        String initBasePath = getInitBasePath();
        if (TextUtils.isEmpty(initBasePath)) {
            return;
        }
        this.f7735h = B();
        this.f7736i = E();
        V8Engine v8Engine = new V8Engine(AppRuntime.getAppContext(), initBasePath, this.f7733f.a(), v8ThreadDelegatePolicy, this.f7735h, this.f7736i);
        this.f7732e = v8Engine;
        if (v8ThreadDelegatePolicy instanceof c.a.r0.a.h0.l.f) {
            ((c.a.r0.a.h0.l.f) v8ThreadDelegatePolicy).d(v8Engine);
        }
        this.f7732e.setExternalV8BinFilesPath(c.a.r0.a.k2.d.a());
        this.f7732e.setFileSystemDelegatePolicy(new c.a.r0.a.l0.n.d());
        if (bVar.b() != null) {
            this.f7732e.setCodeCacheSetting(bVar.b());
        }
        this.k = new c.a.r0.a.l0.m.a(this.f7732e);
        this.m = new c.a.r0.a.l0.l.a(this.f7732e);
        this.n = new ArrayList();
        x0();
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            r0().e(this);
            this.o = 3;
            this.q = true;
            U();
        }
    }

    @NonNull
    public abstract EventTarget B();

    public final void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            r0().g(this);
            this.o = 2;
            this.f7733f.c(this);
        }
    }

    @Override // c.a.r0.a.l0.c
    public JsSerializeValue C(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, bArr, z)) == null) ? this.f7732e.deserialize(bArr, z) : (JsSerializeValue) invokeLZ.objValue;
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            v(new c.a.r0.a.l0.l.b(this));
            I0(new c.a.r0.a.l0.l.c(this));
        }
    }

    public void D0(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, codeCacheSetting) == null) {
            this.f7732e.setCodeCacheSetting(codeCacheSetting);
        }
    }

    @NonNull
    public EventTarget E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new EventTargetImpl(this) : (EventTarget) invokeV.objValue;
    }

    public void E0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            this.f7737j = context;
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f7732e == null) {
            return;
        }
        l m = c.a.r0.a.c1.b.m();
        this.f7732e.setBdFileRealPath(m != null ? m.e() : null);
    }

    public void G0(V8FileSystemDelegatePolicy v8FileSystemDelegatePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, v8FileSystemDelegatePolicy) == null) {
            this.f7732e.setFileSystemDelegatePolicy(v8FileSystemDelegatePolicy);
        }
    }

    public void H0(JsCodeCacheCallback jsCodeCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jsCodeCacheCallback) == null) {
            this.f7732e.setJsCodeCacheCallback(jsCodeCacheCallback);
        }
    }

    public void I0(@NonNull V8Engine.JavaScriptExceptionDelegate javaScriptExceptionDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, javaScriptExceptionDelegate) == null) {
            this.f7732e.setJavaScriptExceptionDelegate(javaScriptExceptionDelegate);
        }
    }

    public void J0() {
        V8Engine v8Engine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (v8Engine = this.f7732e) == null) {
            return;
        }
        v8Engine.setMainPackageBasePath(c.a.r0.a.g1.f.U().z());
    }

    public void K0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (r) {
            String str2 = "setUserAgent: " + str;
        }
        this.f7732e.setUserAgent(str);
    }

    @Override // c.a.r0.a.l0.c
    public byte[] N(JsSerializeValue jsSerializeValue, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048590, this, jsSerializeValue, z)) == null) ? this.f7732e.serialize(jsSerializeValue, z) : (byte[]) invokeLZ.objValue;
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            boolean z = r;
            runOnJSThread(new e(this));
        }
    }

    @Override // c.a.r0.a.h0.f.a
    public void addJavascriptInterface(@NonNull Object obj, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, obj, str) == null) {
            if (r) {
                String str2 = "addJavascriptInterface object: " + obj + " ,name: " + str;
            }
            this.k.a(obj, str);
        }
    }

    @Override // c.a.r0.a.l0.c
    public void c0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) {
            this.k.c(str, str2);
        }
    }

    @Override // c.a.r0.a.h0.f.a
    public void continueTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            synchronized (f.class) {
                if (!isDestroyed()) {
                    c.a.r0.a.e0.d.i("SwanAppV8Engine", "continueTimer: for=" + this);
                    onResume();
                }
            }
        }
    }

    @Override // c.a.r0.a.l0.c
    public boolean dispatchEvent(JSEvent jSEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, jSEvent)) == null) {
            if (r) {
                StringBuilder sb = new StringBuilder();
                sb.append("dispatchEvent event: ");
                sb.append(jSEvent != null ? jSEvent.type : "");
                sb.toString();
            }
            if (this.f7735h != null && JSEvent.isValid(jSEvent)) {
                runOnJSThread(new d(this, jSEvent));
                return true;
            }
            boolean z = r;
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.a.h0.f.a
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, valueCallback) == null) {
            this.k.b(str, valueCallback);
        }
    }

    @Override // c.a.r0.a.l0.c
    public c.a.r0.a.l0.m.b f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.l == null) {
                this.l = new c.a.r0.a.l0.m.b(this.f7732e);
            }
            return this.l;
        }
        return (c.a.r0.a.l0.m.b) invokeV.objValue;
    }

    @Override // c.a.r0.a.h0.f.a
    public String getContainerId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f7734g : (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f7737j : (Context) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.a.l0.c
    public String getInitBasePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f7733f.getInitBasePath() : (String) invokeV.objValue;
    }

    @Override // c.a.r0.a.h0.f.a
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? c.a.r0.a.g1.f.U().z() : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, str, str2) == null) {
            if (v0()) {
                if (r) {
                    Log.getStackTraceString(new Exception("engine isFinishing."));
                    return;
                }
                return;
            }
            evaluateJavascript(str + "(" + (TextUtils.isEmpty(str2) ? "" : JSONObject.quote(str2)) + ");", null);
            if (r) {
                String str3 = "handleSchemeDispatchCallback callback " + str + " ,params: " + str2;
            }
        }
    }

    @Override // c.a.r0.a.h0.f.a
    public boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.p : invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.f.a
    public boolean isWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || this.p) {
            return;
        }
        boolean z = r;
        this.p = true;
        z0();
        this.f7732e.destroyEngine(new c(this));
    }

    public V8Engine n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f7732e : (V8Engine) invokeV.objValue;
    }

    @Override // c.a.r0.a.l0.c
    public EventTarget o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f7735h : (EventTarget) invokeV.objValue;
    }

    public String o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return PreferencesUtil.LEFT_MOUNT + this.f7734g + "] : ";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.a.h0.f.a
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            c.a.r0.a.h0.u.g.U().w0(true);
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            V8Engine v8Engine = this.f7732e;
            if (v8Engine != null) {
                v8Engine.onPause();
            }
            r0().f(this);
            this.o = 4;
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            V8Engine v8Engine = this.f7732e;
            if (v8Engine != null) {
                v8Engine.onResume();
            }
            r0().h(this);
            this.o = 5;
        }
    }

    public NetRequest p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f7732e.getNetRequest() : (NetRequest) invokeV.objValue;
    }

    @Override // c.a.r0.a.l0.c
    public boolean post(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, runnable)) == null) {
            runOnJSThread(runnable);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.a.l0.c, com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, runnable) == null) || runnable == null) {
            return;
        }
        this.f7732e.postOnJSThread(runnable);
    }

    public JSONArray q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            V8Engine v8Engine = this.f7732e;
            if (v8Engine == null) {
                return null;
            }
            return v8Engine.getPerformanceJson();
        }
        return (JSONArray) invokeV.objValue;
    }

    public final f r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? f.i() : (f) invokeV.objValue;
    }

    @Override // c.a.r0.a.l0.c, com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, runnable) == null) || runnable == null) {
            return;
        }
        this.f7732e.runOnJSThread(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThreadDirectly(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, runnable) == null) || runnable == null) {
            return;
        }
        this.f7732e.runOnJSThreadDirectly(runnable);
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.f7732e.setMemSetMemoryEnable(true);
            C0();
            boolean z = r;
            this.f7733f.d(this);
            boolean a = a.b.a();
            if (a) {
                this.f7732e.setCustomJsCodeCacheHandler(new C0460a(this));
            }
            if (r) {
                String str = "customCodeCache:" + a + ", limitSize=" + a.b.b() + ", rank=" + a.b.c();
            }
            this.f7732e.startEngine();
            this.f7732e.addStatusHandler(new b(this));
            boolean z2 = r;
        }
    }

    @Override // c.a.r0.a.l0.c
    public void setPreferredFramesPerSecond(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Short.valueOf(s)}) == null) {
            this.f7732e.setPreferredFramesPerSecond(s);
        }
    }

    @Override // c.a.r0.a.h0.f.a
    public void suspendTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            synchronized (f.class) {
                if (!isDestroyed()) {
                    c.a.r0.a.e0.d.i("SwanAppV8Engine", "suspendTimer: for=" + this);
                    onPause();
                }
            }
        }
    }

    public InspectorNativeClient t0(InspectorNativeChannel inspectorNativeChannel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, inspectorNativeChannel)) == null) ? this.f7732e.initInspector(inspectorNativeChannel) : (InspectorNativeClient) invokeL.objValue;
    }

    @Override // c.a.r0.a.l0.c
    public void throwJSException(JSExceptionType jSExceptionType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, jSExceptionType, str) == null) {
            this.k.d(jSExceptionType, str);
        }
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.o == 7 : invokeV.booleanValue;
    }

    public void v(@NonNull V8Engine.V8EngineConsole v8EngineConsole) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, v8EngineConsole) == null) {
            this.f7732e.addV8EngineConsole(v8EngineConsole);
        }
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            r0().b(this);
            this.o = 1;
        }
    }

    @Override // c.a.r0.a.l0.c
    public EventTarget y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.f7736i : (EventTarget) invokeV.objValue;
    }

    public final void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            r0().c(this);
            this.o = 7;
        }
    }

    @Override // c.a.r0.a.l0.c
    public c.a.r0.a.l0.l.a z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.m : (c.a.r0.a.l0.l.a) invokeV.objValue;
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            r0().d(this);
            this.o = 6;
        }
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048616, this, runnable, j2) == null) || runnable == null) {
            return;
        }
        this.f7732e.postOnJSThread(runnable, j2);
    }
}
