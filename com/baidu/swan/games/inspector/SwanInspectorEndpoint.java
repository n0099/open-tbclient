package com.baidu.swan.games.inspector;

import android.content.res.Resources;
import android.util.Log;
import c.a.n0.j.s.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.searchbox.websocket.IWebSocketListener;
import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SwanInspectorEndpoint {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static SwanInspectorEndpoint u;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedBlockingQueue<String> f29554b;

    /* renamed from: c  reason: collision with root package name */
    public String f29555c;

    /* renamed from: d  reason: collision with root package name */
    public String f29556d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f29557e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29558f;

    /* renamed from: g  reason: collision with root package name */
    public a.C0732a f29559g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29560h;
    public Runnable i;
    public ConnectionState j;
    public ConnectionState k;
    public Throwable l;
    public c.a.n0.a.b0.a m;
    public int n;
    public WebSocketTask o;
    public int p;
    public long q;
    public InspectorNativeClient r;
    public InspectorNativeChannel s;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class ConnectionState {
        public static final /* synthetic */ ConnectionState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ConnectionState CLOSED;
        public static final ConnectionState CONNECTING;
        public static final ConnectionState OPEN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1849960967, "Lcom/baidu/swan/games/inspector/SwanInspectorEndpoint$ConnectionState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1849960967, "Lcom/baidu/swan/games/inspector/SwanInspectorEndpoint$ConnectionState;");
                    return;
                }
            }
            CLOSED = new ConnectionState("CLOSED", 0);
            CONNECTING = new ConnectionState("CONNECTING", 1);
            ConnectionState connectionState = new ConnectionState("OPEN", 2);
            OPEN = connectionState;
            $VALUES = new ConnectionState[]{CLOSED, CONNECTING, connectionState};
        }

        public ConnectionState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ConnectionState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ConnectionState) Enum.valueOf(ConnectionState.class, str) : (ConnectionState) invokeL.objValue;
        }

        public static ConnectionState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ConnectionState[]) $VALUES.clone() : (ConnectionState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f29561b;

        public b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        public final JSONObject a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f29561b == null) {
                    this.f29561b = d(this.a);
                }
                return this.f29561b;
            }
            return (JSONObject) invokeV.objValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String e2 = e(a());
                return e2 != null && e2.indexOf("Debugger.") == 0;
            }
            return invokeV.booleanValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "Debugger.enable".equals(e(a())) : invokeV.booleanValue;
        }

        public final JSONObject d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                try {
                    return new JSONObject(str);
                } catch (JSONException e2) {
                    if (SwanInspectorEndpoint.t) {
                        Log.e("SwanInspector", "Illegal inspector message: ", e2);
                        return null;
                    }
                    return null;
                }
            }
            return (JSONObject) invokeL.objValue;
        }

        public final String e(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                try {
                    return jSONObject.getString("method");
                } catch (JSONException unused) {
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends InspectorNativeChannel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanInspectorEndpoint a;

        public c(SwanInspectorEndpoint swanInspectorEndpoint) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanInspectorEndpoint};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanInspectorEndpoint;
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public String awaitMessage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (SwanInspectorEndpoint.t) {
                    Log.d("SwanInspector", "getInspectorMessage");
                }
                try {
                    this.a.f29560h = true;
                    return (String) this.a.f29554b.take();
                } catch (InterruptedException e2) {
                    if (SwanInspectorEndpoint.t) {
                        Log.e("SwanInspector", "awaitMessage on Debugger", e2);
                        return null;
                    }
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                try {
                    this.a.o.send(str);
                } catch (Exception e2) {
                    if (SwanInspectorEndpoint.t) {
                        Log.e("SwanInspector", "Inspector WS send error", e2);
                    }
                }
            }
        }

        public /* synthetic */ c(SwanInspectorEndpoint swanInspectorEndpoint, a aVar) {
            this(swanInspectorEndpoint);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(136898998, "Lcom/baidu/swan/games/inspector/SwanInspectorEndpoint;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(136898998, "Lcom/baidu/swan/games/inspector/SwanInspectorEndpoint;");
                return;
            }
        }
        t = c.a.n0.a.a.a;
        u = new SwanInspectorEndpoint();
    }

    public SwanInspectorEndpoint() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29554b = new LinkedBlockingQueue<>();
        this.f29557e = false;
        this.f29558f = false;
        this.f29560h = false;
        ConnectionState connectionState = ConnectionState.CLOSED;
        this.j = connectionState;
        this.k = connectionState;
        this.p = 0;
        this.q = 0L;
        this.a = UUID.randomUUID().toString();
    }

    public static SwanInspectorEndpoint v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? u : (SwanInspectorEndpoint) invokeV.objValue;
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (this.o != null && this.j != ConnectionState.CLOSED) {
                if (t) {
                    Log.i("SwanInspector", "WebSocket connect onClosed: " + this.f29556d);
                }
                try {
                    this.o.close(0, "Inspector close");
                } catch (Exception e2) {
                    if (t) {
                        Log.e("SwanInspector", "close error", e2);
                    }
                }
            }
            this.o = null;
            this.q = 0L;
            ConnectionState connectionState = ConnectionState.CLOSED;
            this.j = connectionState;
            this.m = null;
            this.s = null;
            this.r = null;
            this.k = connectionState;
            this.i = null;
            this.f29554b.clear();
            if (z) {
                return;
            }
            this.f29560h = false;
            this.l = null;
            this.f29555c = null;
            this.f29556d = null;
            this.f29557e = false;
            this.f29558f = false;
            this.f29559g = null;
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            p(false);
        }
    }

    public void r(c.a.n0.j.s.a aVar, c.a.n0.a.b0.a aVar2, a.C0732a c0732a, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, aVar, aVar2, c0732a, runnable) == null) {
            p(false);
            w(c0732a);
            try {
                t(aVar2);
                if (aVar.d()) {
                    this.i = runnable;
                    s(aVar);
                } else {
                    s(aVar);
                    runnable.run();
                }
            } catch (Exception e2) {
                if (t) {
                    Log.e("SwanInspector", "Init fail", e2);
                }
                p(true);
            }
        }
    }

    public final void s(c.a.n0.j.s.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.j = ConnectionState.CONNECTING;
            this.f29555c = aVar.a();
            this.f29558f = aVar.b();
            this.f29557e = aVar.d();
            this.f29556d = "ws://" + this.f29555c + "/inspect/inspectorTarget/" + this.a;
            if (t) {
                Log.i("SwanInspector", "Starting inspector to " + this.f29556d);
            }
            this.q = System.currentTimeMillis();
            WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
            WebSocketRequest webSocketRequest = new WebSocketRequest(this.f29556d);
            int i = this.p + 1;
            this.p = i;
            this.o = webSocketManager.connect(webSocketRequest, new d(this, i));
        }
    }

    public final void t(c.a.n0.a.b0.a aVar) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.k = ConnectionState.CONNECTING;
            if (this.n != aVar.hashCode()) {
                this.m = aVar;
                this.n = aVar.hashCode();
                c cVar = new c(this, null);
                this.s = cVar;
                this.r = this.m.t0(cVar);
                this.k = ConnectionState.OPEN;
                return;
            }
            throw new Exception("Can not use the previous connected v8Engine.");
        }
    }

    public String u(Resources resources) {
        InterceptResult invokeL;
        String string;
        String string2;
        String string3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, resources)) == null) {
            StringBuilder sb = new StringBuilder();
            long currentTimeMillis = System.currentTimeMillis();
            a.C0732a c0732a = this.f29559g;
            if (c0732a == null) {
                c0732a = a.C0732a.c();
            }
            sb.append(c0732a.a());
            sb.append("\n");
            if (!c0732a.b()) {
                return sb.toString();
            }
            String str = null;
            ConnectionState connectionState = this.j;
            if (connectionState == ConnectionState.OPEN) {
                string = resources.getString(R.string.obfuscated_res_0x7f0f0169);
            } else if (this.l == null && (connectionState != ConnectionState.CONNECTING || currentTimeMillis - this.q <= 5000)) {
                if (this.j == ConnectionState.CONNECTING) {
                    string = resources.getString(R.string.obfuscated_res_0x7f0f0167);
                } else {
                    string = resources.getString(R.string.obfuscated_res_0x7f0f0166);
                }
            } else {
                string = resources.getString(R.string.obfuscated_res_0x7f0f0168);
                str = resources.getString(R.string.obfuscated_res_0x7f0f0165);
            }
            sb.append(resources.getString(R.string.obfuscated_res_0x7f0f016c));
            sb.append(string);
            sb.append("\n");
            if (str != null) {
                sb.append(str);
                sb.append("\n");
            }
            sb.append(resources.getString(R.string.obfuscated_res_0x7f0f016b));
            sb.append(this.f29555c);
            sb.append("\n");
            if (this.j == ConnectionState.OPEN) {
                sb.append(resources.getString(R.string.obfuscated_res_0x7f0f016e));
                if (this.i != null) {
                    string2 = resources.getString(R.string.obfuscated_res_0x7f0f0170);
                } else if (this.f29560h) {
                    string2 = resources.getString(R.string.obfuscated_res_0x7f0f016f);
                } else {
                    string2 = resources.getString(R.string.obfuscated_res_0x7f0f0171);
                }
                sb.append(string2);
                sb.append("\n");
                sb.append(resources.getString(R.string.obfuscated_res_0x7f0f016d));
                if (this.f29557e) {
                    string3 = resources.getString(R.string.obfuscated_res_0x7f0f0173);
                } else {
                    string3 = resources.getString(R.string.obfuscated_res_0x7f0f0172);
                }
                sb.append(string3);
                sb.append("\n");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void w(a.C0732a c0732a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, c0732a) == null) {
            this.f29559g = c0732a;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements IWebSocketListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanInspectorEndpoint f29562b;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.f29562b.f29560h = false;
                    String str = (String) this.a.f29562b.f29554b.poll();
                    while (str != null) {
                        this.a.f29562b.r.dispatchProtocolMessage(str);
                        str = (String) this.a.f29562b.f29554b.poll();
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Runnable a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f29563b;

            public b(d dVar, Runnable runnable) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, runnable};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f29563b = dVar;
                this.a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (SwanInspectorEndpoint.t) {
                        Log.i("SwanInspector", "breakOnStart: scheduleBreak and run main JS.");
                    }
                    this.f29563b.f29562b.r.scheduleBreak();
                    this.a.run();
                }
            }
        }

        public d(SwanInspectorEndpoint swanInspectorEndpoint, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanInspectorEndpoint, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29562b = swanInspectorEndpoint;
            this.a = -1;
            this.a = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && this.a == this.f29562b.p) {
                if (SwanInspectorEndpoint.t) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + this.f29562b.f29556d);
                }
                this.f29562b.j = ConnectionState.CLOSED;
                this.f29562b.p(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onError(Throwable th, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, jSONObject) == null) && this.a == this.f29562b.p) {
                if (SwanInspectorEndpoint.t) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                this.f29562b.l = th;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.a == this.f29562b.p) {
                if (SwanInspectorEndpoint.t) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (this.f29562b.k != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.t) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                b bVar = new b(str);
                if (this.f29562b.f29558f && bVar.b()) {
                    return;
                }
                this.f29562b.f29554b.offer(str);
                this.f29562b.m.postOnJSThread(new a(this));
                if (this.f29562b.i == null || !bVar.c()) {
                    return;
                }
                Runnable runnable = this.f29562b.i;
                this.f29562b.i = null;
                this.f29562b.m.postOnJSThread(new b(this, runnable));
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, map) == null) && this.a == this.f29562b.p) {
                if (SwanInspectorEndpoint.t) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + this.f29562b.f29556d);
                }
                this.f29562b.j = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, byteBuffer) == null) && SwanInspectorEndpoint.t) {
                Log.d("SwanInspector", "onMessag with array buffer is not supported.");
            }
        }
    }
}
