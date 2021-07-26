package com.baidu.swan.games.inspector;

import android.content.res.Resources;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.searchbox.websocket.IWebSocketListener;
import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.f.g;
import d.a.o0.h.r.a;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SwanInspectorEndpoint {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static SwanInspectorEndpoint u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f11909a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedBlockingQueue<String> f11910b;

    /* renamed from: c  reason: collision with root package name */
    public String f11911c;

    /* renamed from: d  reason: collision with root package name */
    public String f11912d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11913e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11914f;

    /* renamed from: g  reason: collision with root package name */
    public a.C1126a f11915g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11916h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f11917i;
    public ConnectionState j;
    public ConnectionState k;
    public Throwable l;
    public d.a.o0.a.l0.a m;
    public int n;
    public WebSocketTask o;
    public int p;
    public long q;
    public InspectorNativeClient r;
    public InspectorNativeChannel s;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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

        public ConnectionState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f11918a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f11919b;

        public b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11918a = str;
        }

        public final JSONObject a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f11919b == null) {
                    this.f11919b = d(this.f11918a);
                }
                return this.f11919b;
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

    /* loaded from: classes3.dex */
    public class c extends InspectorNativeChannel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanInspectorEndpoint f11920a;

        public c(SwanInspectorEndpoint swanInspectorEndpoint) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanInspectorEndpoint};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11920a = swanInspectorEndpoint;
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
                    this.f11920a.f11916h = true;
                    return (String) this.f11920a.f11910b.take();
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
                    this.f11920a.o.send(str);
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
        t = k.f46335a;
        u = new SwanInspectorEndpoint();
    }

    public SwanInspectorEndpoint() {
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
        this.f11910b = new LinkedBlockingQueue<>();
        this.f11913e = false;
        this.f11914f = false;
        this.f11916h = false;
        ConnectionState connectionState = ConnectionState.CLOSED;
        this.j = connectionState;
        this.k = connectionState;
        this.p = 0;
        this.q = 0L;
        this.f11909a = UUID.randomUUID().toString();
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
                    Log.i("SwanInspector", "WebSocket connect onClosed: " + this.f11912d);
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
            this.f11917i = null;
            this.f11910b.clear();
            if (z) {
                return;
            }
            this.f11916h = false;
            this.l = null;
            this.f11911c = null;
            this.f11912d = null;
            this.f11913e = false;
            this.f11914f = false;
            this.f11915g = null;
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            p(false);
        }
    }

    public void r(d.a.o0.h.r.a aVar, d.a.o0.a.l0.a aVar2, a.C1126a c1126a, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, aVar, aVar2, c1126a, runnable) == null) {
            p(false);
            w(c1126a);
            try {
                t(aVar2);
                if (aVar.d()) {
                    this.f11917i = runnable;
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

    public final void s(d.a.o0.h.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.j = ConnectionState.CONNECTING;
            this.f11911c = aVar.a();
            this.f11914f = aVar.b();
            this.f11913e = aVar.d();
            this.f11912d = "ws://" + this.f11911c + "/inspect/inspectorTarget/" + this.f11909a;
            if (t) {
                Log.i("SwanInspector", "Starting inspector to " + this.f11912d);
            }
            this.q = System.currentTimeMillis();
            WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
            WebSocketRequest webSocketRequest = new WebSocketRequest(this.f11912d);
            int i2 = this.p + 1;
            this.p = i2;
            this.o = webSocketManager.connect(webSocketRequest, new d(this, i2));
        }
    }

    public final void t(d.a.o0.a.l0.a aVar) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.k = ConnectionState.CONNECTING;
            if (this.n != aVar.hashCode()) {
                this.m = aVar;
                this.n = aVar.hashCode();
                c cVar = new c(this, null);
                this.s = cVar;
                this.r = this.m.r0(cVar);
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
            a.C1126a c1126a = this.f11915g;
            if (c1126a == null) {
                c1126a = a.C1126a.c();
            }
            sb.append(c1126a.a());
            sb.append("\n");
            if (!c1126a.b()) {
                return sb.toString();
            }
            String str = null;
            ConnectionState connectionState = this.j;
            if (connectionState == ConnectionState.OPEN) {
                string = resources.getString(g.aiapps_game_inspector_connection_state_open);
            } else if (this.l == null && (connectionState != ConnectionState.CONNECTING || currentTimeMillis - this.q <= 5000)) {
                if (this.j == ConnectionState.CONNECTING) {
                    string = resources.getString(g.aiapps_game_inspector_connection_state_connecting);
                } else {
                    string = resources.getString(g.aiapps_game_inspector_connection_state_close);
                }
            } else {
                string = resources.getString(g.aiapps_game_inspector_connection_state_error);
                str = resources.getString(g.aiapps_game_inspector_connection_error_hint);
            }
            sb.append(resources.getString(g.aiapps_game_inspector_info_label_connection_state));
            sb.append(string);
            sb.append("\n");
            if (str != null) {
                sb.append(str);
                sb.append("\n");
            }
            sb.append(resources.getString(g.aiapps_game_inspector_info_label_addr));
            sb.append(this.f11911c);
            sb.append("\n");
            if (this.j == ConnectionState.OPEN) {
                sb.append(resources.getString(g.aiapps_game_inspector_info_label_program_state));
                if (this.f11917i != null) {
                    string2 = resources.getString(g.aiapps_game_inspector_program_state_pause_at_start);
                } else if (this.f11916h) {
                    string2 = resources.getString(g.aiapps_game_inspector_program_state_pause_at_breakpoint);
                } else {
                    string2 = resources.getString(g.aiapps_game_inspector_program_state_running);
                }
                sb.append(string2);
                sb.append("\n");
                sb.append(resources.getString(g.aiapps_game_inspector_info_label_pause_at_start_set));
                if (this.f11913e) {
                    string3 = resources.getString(g.aiapps_game_inspector_text_yes);
                } else {
                    string3 = resources.getString(g.aiapps_game_inspector_text_no);
                }
                sb.append(string3);
                sb.append("\n");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void w(a.C1126a c1126a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, c1126a) == null) {
            this.f11915g = c1126a;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements IWebSocketListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f11921e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanInspectorEndpoint f11922f;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f11923e;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11923e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f11923e.f11922f.f11916h = false;
                    String str = (String) this.f11923e.f11922f.f11910b.poll();
                    while (str != null) {
                        this.f11923e.f11922f.r.dispatchProtocolMessage(str);
                        str = (String) this.f11923e.f11922f.f11910b.poll();
                    }
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Runnable f11924e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f11925f;

            public b(d dVar, Runnable runnable) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, runnable};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11925f = dVar;
                this.f11924e = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (SwanInspectorEndpoint.t) {
                        Log.i("SwanInspector", "breakOnStart: scheduleBreak and run main JS.");
                    }
                    this.f11925f.f11922f.r.scheduleBreak();
                    this.f11924e.run();
                }
            }
        }

        public d(SwanInspectorEndpoint swanInspectorEndpoint, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanInspectorEndpoint, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11922f = swanInspectorEndpoint;
            this.f11921e = -1;
            this.f11921e = i2;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && this.f11921e == this.f11922f.p) {
                if (SwanInspectorEndpoint.t) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + this.f11922f.f11912d);
                }
                this.f11922f.j = ConnectionState.CLOSED;
                this.f11922f.p(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onError(Throwable th, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, jSONObject) == null) && this.f11921e == this.f11922f.p) {
                if (SwanInspectorEndpoint.t) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                this.f11922f.l = th;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.f11921e == this.f11922f.p) {
                if (SwanInspectorEndpoint.t) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (this.f11922f.k != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.t) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                b bVar = new b(str);
                if (this.f11922f.f11914f && bVar.b()) {
                    return;
                }
                this.f11922f.f11910b.offer(str);
                this.f11922f.m.postOnJSThread(new a(this));
                if (this.f11922f.f11917i == null || !bVar.c()) {
                    return;
                }
                Runnable runnable = this.f11922f.f11917i;
                this.f11922f.f11917i = null;
                this.f11922f.m.postOnJSThread(new b(this, runnable));
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, map) == null) && this.f11921e == this.f11922f.p) {
                if (SwanInspectorEndpoint.t) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + this.f11922f.f11912d);
                }
                this.f11922f.j = ConnectionState.OPEN;
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
