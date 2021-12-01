package com.baidu.swan.games.inspector;

import android.content.res.Resources;
import c.a.p0.a.k;
import c.a.p0.h.g;
import c.a.p0.j.s.a;
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
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class SwanInspectorEndpoint {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static SwanInspectorEndpoint u;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedBlockingQueue<String> f40521b;

    /* renamed from: c  reason: collision with root package name */
    public String f40522c;

    /* renamed from: d  reason: collision with root package name */
    public String f40523d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40524e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40525f;

    /* renamed from: g  reason: collision with root package name */
    public a.C0679a f40526g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f40527h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f40528i;

    /* renamed from: j  reason: collision with root package name */
    public ConnectionState f40529j;

    /* renamed from: k  reason: collision with root package name */
    public ConnectionState f40530k;
    public Throwable l;
    public c.a.p0.a.l0.a m;
    public int n;
    public WebSocketTask o;
    public int p;
    public long q;
    public InspectorNativeClient r;
    public InspectorNativeChannel s;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f40531b;

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
            this.a = str;
        }

        public final JSONObject a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f40531b == null) {
                    this.f40531b = d(this.a);
                }
                return this.f40531b;
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
                } catch (JSONException unused) {
                    boolean unused2 = SwanInspectorEndpoint.t;
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

    /* loaded from: classes9.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                boolean unused = SwanInspectorEndpoint.t;
                try {
                    this.a.f40527h = true;
                    return (String) this.a.f40521b.take();
                } catch (InterruptedException unused2) {
                    boolean unused3 = SwanInspectorEndpoint.t;
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
                } catch (Exception unused) {
                    boolean unused2 = SwanInspectorEndpoint.t;
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
        t = k.a;
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
        this.f40521b = new LinkedBlockingQueue<>();
        this.f40524e = false;
        this.f40525f = false;
        this.f40527h = false;
        ConnectionState connectionState = ConnectionState.CLOSED;
        this.f40529j = connectionState;
        this.f40530k = connectionState;
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
            if (this.o != null && this.f40529j != ConnectionState.CLOSED) {
                if (t) {
                    String str = "WebSocket connect onClosed: " + this.f40523d;
                }
                try {
                    this.o.close(0, "Inspector close");
                } catch (Exception unused) {
                    boolean z2 = t;
                }
            }
            this.o = null;
            this.q = 0L;
            ConnectionState connectionState = ConnectionState.CLOSED;
            this.f40529j = connectionState;
            this.m = null;
            this.s = null;
            this.r = null;
            this.f40530k = connectionState;
            this.f40528i = null;
            this.f40521b.clear();
            if (z) {
                return;
            }
            this.f40527h = false;
            this.l = null;
            this.f40522c = null;
            this.f40523d = null;
            this.f40524e = false;
            this.f40525f = false;
            this.f40526g = null;
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            p(false);
        }
    }

    public void r(c.a.p0.j.s.a aVar, c.a.p0.a.l0.a aVar2, a.C0679a c0679a, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, aVar, aVar2, c0679a, runnable) == null) {
            p(false);
            w(c0679a);
            try {
                t(aVar2);
                if (aVar.d()) {
                    this.f40528i = runnable;
                    s(aVar);
                } else {
                    s(aVar);
                    runnable.run();
                }
            } catch (Exception unused) {
                boolean z = t;
                p(true);
            }
        }
    }

    public final void s(c.a.p0.j.s.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f40529j = ConnectionState.CONNECTING;
            this.f40522c = aVar.a();
            this.f40525f = aVar.b();
            this.f40524e = aVar.d();
            this.f40523d = "ws://" + this.f40522c + "/inspect/inspectorTarget/" + this.a;
            if (t) {
                String str = "Starting inspector to " + this.f40523d;
            }
            this.q = System.currentTimeMillis();
            WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
            WebSocketRequest webSocketRequest = new WebSocketRequest(this.f40523d);
            int i2 = this.p + 1;
            this.p = i2;
            this.o = webSocketManager.connect(webSocketRequest, new d(this, i2));
        }
    }

    public final void t(c.a.p0.a.l0.a aVar) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f40530k = ConnectionState.CONNECTING;
            if (this.n != aVar.hashCode()) {
                this.m = aVar;
                this.n = aVar.hashCode();
                c cVar = new c(this, null);
                this.s = cVar;
                this.r = this.m.t0(cVar);
                this.f40530k = ConnectionState.OPEN;
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
            a.C0679a c0679a = this.f40526g;
            if (c0679a == null) {
                c0679a = a.C0679a.c();
            }
            sb.append(c0679a.a());
            sb.append(StringUtils.LF);
            if (!c0679a.b()) {
                return sb.toString();
            }
            String str = null;
            ConnectionState connectionState = this.f40529j;
            if (connectionState == ConnectionState.OPEN) {
                string = resources.getString(g.aiapps_game_inspector_connection_state_open);
            } else if (this.l == null && (connectionState != ConnectionState.CONNECTING || currentTimeMillis - this.q <= 5000)) {
                if (this.f40529j == ConnectionState.CONNECTING) {
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
            sb.append(StringUtils.LF);
            if (str != null) {
                sb.append(str);
                sb.append(StringUtils.LF);
            }
            sb.append(resources.getString(g.aiapps_game_inspector_info_label_addr));
            sb.append(this.f40522c);
            sb.append(StringUtils.LF);
            if (this.f40529j == ConnectionState.OPEN) {
                sb.append(resources.getString(g.aiapps_game_inspector_info_label_program_state));
                if (this.f40528i != null) {
                    string2 = resources.getString(g.aiapps_game_inspector_program_state_pause_at_start);
                } else if (this.f40527h) {
                    string2 = resources.getString(g.aiapps_game_inspector_program_state_pause_at_breakpoint);
                } else {
                    string2 = resources.getString(g.aiapps_game_inspector_program_state_running);
                }
                sb.append(string2);
                sb.append(StringUtils.LF);
                sb.append(resources.getString(g.aiapps_game_inspector_info_label_pause_at_start_set));
                if (this.f40524e) {
                    string3 = resources.getString(g.aiapps_game_inspector_text_yes);
                } else {
                    string3 = resources.getString(g.aiapps_game_inspector_text_no);
                }
                sb.append(string3);
                sb.append(StringUtils.LF);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void w(a.C0679a c0679a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, c0679a) == null) {
            this.f40526g = c0679a;
        }
    }

    /* loaded from: classes9.dex */
    public class d implements IWebSocketListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f40532e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanInspectorEndpoint f40533f;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f40534e;

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
                this.f40534e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f40534e.f40533f.f40527h = false;
                    String str = (String) this.f40534e.f40533f.f40521b.poll();
                    while (str != null) {
                        this.f40534e.f40533f.r.dispatchProtocolMessage(str);
                        str = (String) this.f40534e.f40533f.f40521b.poll();
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Runnable f40535e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f40536f;

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
                this.f40536f = dVar;
                this.f40535e = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    boolean unused = SwanInspectorEndpoint.t;
                    this.f40536f.f40533f.r.scheduleBreak();
                    this.f40535e.run();
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
            this.f40533f = swanInspectorEndpoint;
            this.f40532e = -1;
            this.f40532e = i2;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && this.f40532e == this.f40533f.p) {
                if (SwanInspectorEndpoint.t) {
                    String str = "WebSocket connect onClose: " + this.f40533f.f40523d;
                }
                this.f40533f.f40529j = ConnectionState.CLOSED;
                this.f40533f.p(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onError(Throwable th, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, jSONObject) == null) && this.f40532e == this.f40533f.p) {
                boolean unused = SwanInspectorEndpoint.t;
                this.f40533f.l = th;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.f40532e == this.f40533f.p) {
                if (SwanInspectorEndpoint.t) {
                    r0 = "WebSocket onMessage: " + str;
                }
                if (this.f40533f.f40530k != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.t) {
                        new Exception("Illegal state: " + ConnectionState.OPEN);
                        return;
                    }
                    return;
                }
                b bVar = new b(str);
                if (this.f40533f.f40525f && bVar.b()) {
                    return;
                }
                this.f40533f.f40521b.offer(str);
                this.f40533f.m.postOnJSThread(new a(this));
                if (this.f40533f.f40528i == null || !bVar.c()) {
                    return;
                }
                Runnable runnable = this.f40533f.f40528i;
                this.f40533f.f40528i = null;
                this.f40533f.m.postOnJSThread(new b(this, runnable));
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, map) == null) && this.f40532e == this.f40533f.p) {
                if (SwanInspectorEndpoint.t) {
                    String str = "WebSocket connect onOpened: " + this.f40533f.f40523d;
                }
                this.f40533f.f40529j = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, byteBuffer) == null) {
                boolean unused = SwanInspectorEndpoint.t;
            }
        }
    }
}
