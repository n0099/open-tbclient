package c.a.o0.a.l0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k;
import c.a.o0.a.p.b.a.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.searchbox.v8engine.JSExceptionType;
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
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a implements c.a.o0.a.l0.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public V8Engine f7143e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.a.l0.n.b f7144f;

    /* renamed from: g  reason: collision with root package name */
    public final String f7145g;

    /* renamed from: h  reason: collision with root package name */
    public EventTarget f7146h;

    /* renamed from: i  reason: collision with root package name */
    public EventTarget f7147i;

    /* renamed from: j  reason: collision with root package name */
    public Context f7148j;
    public c.a.o0.a.l0.l.a k;
    public c.a.o0.a.l0.l.b l;
    public c.a.o0.a.l0.k.a m;
    public List<JSEvent> n;
    public int o;
    public boolean p;
    public boolean q;

    /* renamed from: c.a.o0.a.l0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0281a implements V8Engine.V8StatusListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f7149a;

        public C0281a(a aVar) {
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
            this.f7149a = aVar;
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
                this.f7149a.z0();
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
    public class b implements V8ExecuteCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f7150a;

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
            this.f7150a = aVar;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ExecuteCallback
        public void onExecuted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = a.r;
                this.f7150a.w0();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSEvent f7151e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7152f;

        public c(a aVar, JSEvent jSEvent) {
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
            this.f7152f = aVar;
            this.f7151e = jSEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.f7152f.u0()) {
                    boolean unused = a.r;
                    this.f7152f.n.add(this.f7151e);
                    return;
                }
                this.f7152f.f7146h.dispatchEvent(this.f7151e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7153e;

        public d(a aVar) {
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
            this.f7153e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (JSEvent jSEvent : this.f7153e.n) {
                    if (a.r) {
                        String str = "doPendingDispatch event type: " + jSEvent.type;
                    }
                    this.f7153e.S(jSEvent);
                }
                this.f7153e.n.clear();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1019214575, "Lc/a/o0/a/l0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1019214575, "Lc/a/o0/a/l0/a;");
                return;
            }
        }
        r = k.f7049a;
        c.a.o0.a.h2.d.c();
    }

    public a(@NonNull String str, @NonNull c.a.o0.a.l0.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
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
        this.f7145g = str;
        this.f7144f = bVar;
        String initBasePath = getInitBasePath();
        if (TextUtils.isEmpty(initBasePath)) {
            return;
        }
        this.f7146h = B();
        this.f7147i = E();
        V8Engine v8Engine = new V8Engine(AppRuntime.getAppContext(), initBasePath, this.f7144f.a(), v8ThreadDelegatePolicy, this.f7146h, this.f7147i);
        this.f7143e = v8Engine;
        if (v8ThreadDelegatePolicy instanceof c.a.o0.a.h0.l.f) {
            ((c.a.o0.a.h0.l.f) v8ThreadDelegatePolicy).d(v8Engine);
        }
        this.f7143e.setExternalV8BinFilesPath(c.a.o0.a.h2.d.a());
        this.f7143e.setFileSystemDelegatePolicy(new c.a.o0.a.l0.m.d());
        c.a.o0.a.u.e.j.d.c(this.f7143e);
        if (bVar.b() != null) {
            this.f7143e.setCodeCacheSetting(bVar.b());
        }
        this.k = new c.a.o0.a.l0.l.a(this.f7143e);
        this.m = new c.a.o0.a.l0.k.a(this.f7143e);
        this.n = new ArrayList();
        v0();
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            v(new c.a.o0.a.l0.k.b(this));
            G0(new c.a.o0.a.l0.k.c(this));
        }
    }

    @NonNull
    public abstract EventTarget B();

    public void B0(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSCacheCallback) == null) {
            this.f7143e.setJSCacheCallback(jSCacheCallback);
        }
    }

    @Override // c.a.o0.a.l0.c
    public JsSerializeValue C(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, bArr, z)) == null) ? this.f7143e.deserialize(bArr, z) : (JsSerializeValue) invokeLZ.objValue;
    }

    public void C0(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, codeCacheSetting) == null) {
            this.f7143e.setCodeCacheSetting(codeCacheSetting);
        }
    }

    public void D0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.f7148j = context;
        }
    }

    @NonNull
    public EventTarget E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new EventTargetImpl(this) : (EventTarget) invokeV.objValue;
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f7143e == null) {
            return;
        }
        l m = c.a.o0.a.c1.b.m();
        this.f7143e.setBdFileRealPath(m != null ? m.e() : null);
    }

    public void F0(V8FileSystemDelegatePolicy v8FileSystemDelegatePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v8FileSystemDelegatePolicy) == null) {
            this.f7143e.setFileSystemDelegatePolicy(v8FileSystemDelegatePolicy);
        }
    }

    public void G0(@NonNull V8Engine.JavaScriptExceptionDelegate javaScriptExceptionDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, javaScriptExceptionDelegate) == null) {
            this.f7143e.setJavaScriptExceptionDelegate(javaScriptExceptionDelegate);
        }
    }

    public void H0() {
        V8Engine v8Engine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (v8Engine = this.f7143e) == null) {
            return;
        }
        v8Engine.setMainPackageBasePath(c.a.o0.a.g1.f.V().A());
    }

    public void I0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (r) {
            String str2 = "setUserAgent: " + str;
        }
        this.f7143e.setUserAgent(str);
    }

    @Override // c.a.o0.a.l0.c
    public byte[] M(JsSerializeValue jsSerializeValue, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, jsSerializeValue, z)) == null) ? this.f7143e.serialize(jsSerializeValue, z) : (byte[]) invokeLZ.objValue;
    }

    public boolean S(JSEvent jSEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, jSEvent)) == null) {
            if (r) {
                StringBuilder sb = new StringBuilder();
                sb.append("dispatchEvent event: ");
                sb.append(jSEvent != null ? jSEvent.type : "");
                sb.toString();
            }
            if (this.f7146h != null && JSEvent.isValid(jSEvent)) {
                runOnJSThread(new c(this, jSEvent));
                return true;
            }
            boolean z = r;
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.o0.a.l0.c
    public void a0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            this.k.c(str, str2);
        }
    }

    @Override // c.a.o0.a.h0.f.a
    public void addJavascriptInterface(@NonNull Object obj, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, obj, str) == null) {
            if (r) {
                String str2 = "addJavascriptInterface object: " + obj + " ,name: " + str;
            }
            this.k.a(obj, str);
        }
    }

    @Override // c.a.o0.a.l0.c
    public c.a.o0.a.l0.l.b d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.l == null) {
                this.l = new c.a.o0.a.l0.l.b(this.f7143e);
            }
            return this.l;
        }
        return (c.a.o0.a.l0.l.b) invokeV.objValue;
    }

    @Override // c.a.o0.a.h0.f.a
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, valueCallback) == null) {
            this.k.b(str, valueCallback);
        }
    }

    @Override // c.a.o0.a.h0.f.a
    public String getContainerId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f7145g : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.o0.a.l0.c
    public String getInitBasePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f7144f.getInitBasePath() : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) {
            if (t0()) {
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

    @Override // c.a.o0.a.h0.f.a
    public boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.p : invokeV.booleanValue;
    }

    @Override // c.a.o0.a.h0.f.a
    public boolean isWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            boolean z = r;
            runOnJSThread(new d(this));
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.p) {
            return;
        }
        boolean z = r;
        this.p = true;
        x0();
        this.f7143e.destroyEngine(new b(this));
    }

    public V8Engine l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f7143e : (V8Engine) invokeV.objValue;
    }

    public String m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return PreferencesUtil.LEFT_MOUNT + this.f7145g + "] : ";
        }
        return (String) invokeV.objValue;
    }

    public NetRequest n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f7143e.getNetRequest() : (NetRequest) invokeV.objValue;
    }

    @Override // c.a.o0.a.l0.c
    public EventTarget o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f7146h : (EventTarget) invokeV.objValue;
    }

    public JSONArray o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            V8Engine v8Engine = this.f7143e;
            if (v8Engine == null) {
                return null;
            }
            return v8Engine.getPerformanceJson();
        }
        return (JSONArray) invokeV.objValue;
    }

    @Override // c.a.o0.a.h0.f.a
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            c.a.o0.a.h0.u.g.N().m0(true);
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            V8Engine v8Engine = this.f7143e;
            if (v8Engine != null) {
                v8Engine.onPause();
            }
            p0().f(this);
            this.o = 4;
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            V8Engine v8Engine = this.f7143e;
            if (v8Engine != null) {
                v8Engine.onResume();
            }
            p0().h(this);
            this.o = 5;
        }
    }

    public final e p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? e.i() : (e) invokeV.objValue;
    }

    @Override // c.a.o0.a.l0.c, c.a.o0.a.h0.f.a
    public boolean post(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, runnable)) == null) {
            runOnJSThread(runnable);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.o0.a.l0.c, com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, runnable) == null) || runnable == null) {
            return;
        }
        this.f7143e.postOnJSThread(runnable);
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            A0();
            boolean z = r;
            this.f7144f.d(this);
            this.f7143e.startEngine();
            this.f7143e.addStatusHandler(new C0281a(this));
            boolean z2 = r;
        }
    }

    public InspectorNativeClient r0(InspectorNativeChannel inspectorNativeChannel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, inspectorNativeChannel)) == null) ? this.f7143e.initInspector(inspectorNativeChannel) : (InspectorNativeClient) invokeL.objValue;
    }

    @Override // c.a.o0.a.l0.c, com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, runnable) == null) || runnable == null) {
            return;
        }
        this.f7143e.runOnJSThread(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThreadDirectly(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, runnable) == null) || runnable == null) {
            return;
        }
        this.f7143e.runOnJSThreadDirectly(runnable);
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.o == 7 : invokeV.booleanValue;
    }

    @Override // c.a.o0.a.l0.c
    public void setPreferredFramesPerSecond(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Short.valueOf(s)}) == null) {
            this.f7143e.setPreferredFramesPerSecond(s);
        }
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.p : invokeV.booleanValue;
    }

    @Override // c.a.o0.a.l0.c
    public void throwJSException(JSExceptionType jSExceptionType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, jSExceptionType, str) == null) {
            this.k.d(jSExceptionType, str);
        }
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public void v(@NonNull V8Engine.V8EngineConsole v8EngineConsole) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, v8EngineConsole) == null) {
            this.f7143e.addV8EngineConsole(v8EngineConsole);
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            p0().b(this);
            this.o = 1;
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            p0().c(this);
            this.o = 7;
        }
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            p0().d(this);
            this.o = 6;
        }
    }

    @Override // c.a.o0.a.l0.c
    public EventTarget y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.f7147i : (EventTarget) invokeV.objValue;
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            p0().e(this);
            this.o = 3;
            this.q = true;
            j0();
        }
    }

    @Override // c.a.o0.a.l0.c
    public c.a.o0.a.l0.k.a z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.m : (c.a.o0.a.l0.k.a) invokeV.objValue;
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            p0().g(this);
            this.o = 2;
            this.f7144f.c(this);
        }
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048613, this, runnable, j2) == null) || runnable == null) {
            return;
        }
        this.f7143e.postOnJSThread(runnable, j2);
    }
}
