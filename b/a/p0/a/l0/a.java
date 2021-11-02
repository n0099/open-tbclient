package b.a.p0.a.l0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.p.b.a.l;
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
public abstract class a implements b.a.p0.a.l0.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public V8Engine f6491e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.p0.a.l0.n.b f6492f;

    /* renamed from: g  reason: collision with root package name */
    public final String f6493g;

    /* renamed from: h  reason: collision with root package name */
    public EventTarget f6494h;

    /* renamed from: i  reason: collision with root package name */
    public EventTarget f6495i;
    public Context j;
    public b.a.p0.a.l0.l.a k;
    public b.a.p0.a.l0.l.b l;
    public b.a.p0.a.l0.k.a m;
    public List<JSEvent> n;
    public int o;
    public boolean p;
    public boolean q;

    /* renamed from: b.a.p0.a.l0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0278a implements V8Engine.V8StatusListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6496a;

        public C0278a(a aVar) {
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
            this.f6496a = aVar;
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
                this.f6496a.z0();
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
        public final /* synthetic */ a f6497a;

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
            this.f6497a = aVar;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ExecuteCallback
        public void onExecuted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = a.r;
                this.f6497a.w0();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSEvent f6498e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f6499f;

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
            this.f6499f = aVar;
            this.f6498e = jSEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.f6499f.u0()) {
                    boolean unused = a.r;
                    this.f6499f.n.add(this.f6498e);
                    return;
                }
                this.f6499f.f6494h.dispatchEvent(this.f6498e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6500e;

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
            this.f6500e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (JSEvent jSEvent : this.f6500e.n) {
                    if (a.r) {
                        String str = "doPendingDispatch event type: " + jSEvent.type;
                    }
                    this.f6500e.i0(jSEvent);
                }
                this.f6500e.n.clear();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1328259695, "Lb/a/p0/a/l0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1328259695, "Lb/a/p0/a/l0/a;");
                return;
            }
        }
        r = k.f6397a;
        b.a.p0.a.h2.d.c();
    }

    public a(@NonNull String str, @NonNull b.a.p0.a.l0.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
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
        this.f6493g = str;
        this.f6492f = bVar;
        String initBasePath = getInitBasePath();
        if (TextUtils.isEmpty(initBasePath)) {
            return;
        }
        this.f6494h = C();
        this.f6495i = R();
        V8Engine v8Engine = new V8Engine(AppRuntime.getAppContext(), initBasePath, this.f6492f.a(), v8ThreadDelegatePolicy, this.f6494h, this.f6495i);
        this.f6491e = v8Engine;
        if (v8ThreadDelegatePolicy instanceof b.a.p0.a.h0.l.f) {
            ((b.a.p0.a.h0.l.f) v8ThreadDelegatePolicy).d(v8Engine);
        }
        this.f6491e.setExternalV8BinFilesPath(b.a.p0.a.h2.d.a());
        this.f6491e.setFileSystemDelegatePolicy(new b.a.p0.a.l0.m.d());
        b.a.p0.a.u.e.j.d.c(this.f6491e);
        if (bVar.b() != null) {
            this.f6491e.setCodeCacheSetting(bVar.b());
        }
        this.k = new b.a.p0.a.l0.l.a(this.f6491e);
        this.m = new b.a.p0.a.l0.k.a(this.f6491e);
        this.n = new ArrayList();
        v0();
    }

    public void A(@NonNull V8Engine.V8EngineConsole v8EngineConsole) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v8EngineConsole) == null) {
            this.f6491e.addV8EngineConsole(v8EngineConsole);
        }
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            A(new b.a.p0.a.l0.k.b(this));
            G0(new b.a.p0.a.l0.k.c(this));
        }
    }

    @Override // b.a.p0.a.l0.c
    public JsSerializeValue B(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, bArr, z)) == null) ? this.f6491e.deserialize(bArr, z) : (JsSerializeValue) invokeLZ.objValue;
    }

    public void B0(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSCacheCallback) == null) {
            this.f6491e.setJSCacheCallback(jSCacheCallback);
        }
    }

    @NonNull
    public abstract EventTarget C();

    public void C0(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, codeCacheSetting) == null) {
            this.f6491e.setCodeCacheSetting(codeCacheSetting);
        }
    }

    public void D0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.j = context;
        }
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f6491e == null) {
            return;
        }
        l m = b.a.p0.a.c1.b.m();
        this.f6491e.setBdFileRealPath(m != null ? m.e() : null);
    }

    public void F0(V8FileSystemDelegatePolicy v8FileSystemDelegatePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v8FileSystemDelegatePolicy) == null) {
            this.f6491e.setFileSystemDelegatePolicy(v8FileSystemDelegatePolicy);
        }
    }

    public void G0(@NonNull V8Engine.JavaScriptExceptionDelegate javaScriptExceptionDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, javaScriptExceptionDelegate) == null) {
            this.f6491e.setJavaScriptExceptionDelegate(javaScriptExceptionDelegate);
        }
    }

    public void H0() {
        V8Engine v8Engine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (v8Engine = this.f6491e) == null) {
            return;
        }
        v8Engine.setMainPackageBasePath(b.a.p0.a.g1.f.T().z());
    }

    public void I0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (r) {
            String str2 = "setUserAgent: " + str;
        }
        this.f6491e.setUserAgent(str);
    }

    @Override // b.a.p0.a.l0.c
    public byte[] L(JsSerializeValue jsSerializeValue, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, jsSerializeValue, z)) == null) ? this.f6491e.serialize(jsSerializeValue, z) : (byte[]) invokeLZ.objValue;
    }

    @NonNull
    public EventTarget R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new EventTargetImpl(this) : (EventTarget) invokeV.objValue;
    }

    @Override // b.a.p0.a.l0.c
    public void Z(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            this.k.c(str, str2);
        }
    }

    @Override // b.a.p0.a.h0.f.a
    public void addJavascriptInterface(@NonNull Object obj, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, obj, str) == null) {
            if (r) {
                String str2 = "addJavascriptInterface object: " + obj + " ,name: " + str;
            }
            this.k.a(obj, str);
        }
    }

    @Override // b.a.p0.a.l0.c
    public b.a.p0.a.l0.l.b c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.l == null) {
                this.l = new b.a.p0.a.l0.l.b(this.f6491e);
            }
            return this.l;
        }
        return (b.a.p0.a.l0.l.b) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.f.a
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, valueCallback) == null) {
            this.k.b(str, valueCallback);
        }
    }

    @Override // b.a.p0.a.h0.f.a
    public String getContainerId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f6493g : (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.j : (Context) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.l0.c
    public String getInitBasePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f6492f.getInitBasePath() : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) {
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

    public boolean i0(JSEvent jSEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, jSEvent)) == null) {
            if (r) {
                StringBuilder sb = new StringBuilder();
                sb.append("dispatchEvent event: ");
                sb.append(jSEvent != null ? jSEvent.type : "");
                sb.toString();
            }
            if (this.f6494h != null && JSEvent.isValid(jSEvent)) {
                runOnJSThread(new c(this, jSEvent));
                return true;
            }
            boolean z = r;
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.a.h0.f.a
    public boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.p : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.f.a
    public boolean isWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            boolean z = r;
            runOnJSThread(new d(this));
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.p) {
            return;
        }
        boolean z = r;
        this.p = true;
        x0();
        this.f6491e.destroyEngine(new b(this));
    }

    public V8Engine l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f6491e : (V8Engine) invokeV.objValue;
    }

    public String m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return PreferencesUtil.LEFT_MOUNT + this.f6493g + "] : ";
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.l0.c
    public EventTarget n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f6494h : (EventTarget) invokeV.objValue;
    }

    public NetRequest n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f6491e.getNetRequest() : (NetRequest) invokeV.objValue;
    }

    public JSONArray o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            V8Engine v8Engine = this.f6491e;
            if (v8Engine == null) {
                return null;
            }
            return v8Engine.getPerformanceJson();
        }
        return (JSONArray) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.f.a
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            b.a.p0.a.h0.u.g.M().l0(true);
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            V8Engine v8Engine = this.f6491e;
            if (v8Engine != null) {
                v8Engine.onPause();
            }
            p0().f(this);
            this.o = 4;
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            V8Engine v8Engine = this.f6491e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? e.i() : (e) invokeV.objValue;
    }

    @Override // b.a.p0.a.l0.c, b.a.p0.a.h0.f.a
    public boolean post(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, runnable)) == null) {
            runOnJSThread(runnable);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.a.l0.c, com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, runnable) == null) || runnable == null) {
            return;
        }
        this.f6491e.postOnJSThread(runnable);
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            A0();
            boolean z = r;
            this.f6492f.d(this);
            this.f6491e.startEngine();
            this.f6491e.addStatusHandler(new C0278a(this));
            boolean z2 = r;
        }
    }

    public InspectorNativeClient r0(InspectorNativeChannel inspectorNativeChannel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, inspectorNativeChannel)) == null) ? this.f6491e.initInspector(inspectorNativeChannel) : (InspectorNativeClient) invokeL.objValue;
    }

    @Override // b.a.p0.a.l0.c, com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, runnable) == null) || runnable == null) {
            return;
        }
        this.f6491e.runOnJSThread(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThreadDirectly(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, runnable) == null) || runnable == null) {
            return;
        }
        this.f6491e.runOnJSThreadDirectly(runnable);
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.o == 7 : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.l0.c
    public void setPreferredFramesPerSecond(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Short.valueOf(s)}) == null) {
            this.f6491e.setPreferredFramesPerSecond(s);
        }
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.p : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.l0.c
    public void throwJSException(JSExceptionType jSExceptionType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048623, this, jSExceptionType, str) == null) {
            this.k.d(jSExceptionType, str);
        }
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            p0().b(this);
            this.o = 1;
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            p0().c(this);
            this.o = 7;
        }
    }

    @Override // b.a.p0.a.l0.c
    public EventTarget x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.f6495i : (EventTarget) invokeV.objValue;
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            p0().d(this);
            this.o = 6;
        }
    }

    @Override // b.a.p0.a.l0.c
    public b.a.p0.a.l0.k.a y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.m : (b.a.p0.a.l0.k.a) invokeV.objValue;
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            p0().e(this);
            this.o = 3;
            this.q = true;
            j0();
        }
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            p0().g(this);
            this.o = 2;
            this.f6492f.c(this);
        }
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048615, this, runnable, j) == null) || runnable == null) {
            return;
        }
        this.f6491e.postOnJSThread(runnable, j);
    }
}
