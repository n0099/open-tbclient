package com.baidu.swan.games.inspector;

import android.content.res.Resources;
import android.util.Log;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.searchbox.websocket.IWebSocketListener;
import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.searchbox.websocket.WebSocketTask;
import d.b.g0.a.h;
import d.b.g0.a.k;
import d.b.g0.g.p.a;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SwanInspectorEndpoint {
    public static final boolean t = k.f45050a;
    public static SwanInspectorEndpoint u = new SwanInspectorEndpoint();

    /* renamed from: a  reason: collision with root package name */
    public String f12840a;

    /* renamed from: c  reason: collision with root package name */
    public String f12842c;

    /* renamed from: d  reason: collision with root package name */
    public String f12843d;

    /* renamed from: g  reason: collision with root package name */
    public a.C0986a f12846g;
    public Runnable i;
    public ConnectionState j;
    public ConnectionState k;
    public Throwable l;
    public d.b.g0.g.i.a m;
    public int n;
    public WebSocketTask o;
    public int p;
    public long q;
    public InspectorNativeClient r;
    public InspectorNativeChannel s;

    /* renamed from: b  reason: collision with root package name */
    public LinkedBlockingQueue<String> f12841b = new LinkedBlockingQueue<>();

    /* renamed from: e  reason: collision with root package name */
    public boolean f12844e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12845f = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12847h = false;

    /* loaded from: classes3.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f12848a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f12849b;

        public b(String str) {
            this.f12848a = str;
        }

        public final JSONObject a() {
            if (this.f12849b == null) {
                this.f12849b = d(this.f12848a);
            }
            return this.f12849b;
        }

        public boolean b() {
            String e2 = e(a());
            return e2 != null && e2.indexOf("Debugger.") == 0;
        }

        public boolean c() {
            return "Debugger.enable".equals(e(a()));
        }

        public final JSONObject d(String str) {
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

        public final String e(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            try {
                return jSONObject.getString("method");
            } catch (JSONException unused) {
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends InspectorNativeChannel {
        public c() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public String awaitMessage() {
            if (SwanInspectorEndpoint.t) {
                Log.d("SwanInspector", "getInspectorMessage");
            }
            try {
                SwanInspectorEndpoint.this.f12847h = true;
                return (String) SwanInspectorEndpoint.this.f12841b.take();
            } catch (InterruptedException e2) {
                if (SwanInspectorEndpoint.t) {
                    Log.e("SwanInspector", "awaitMessage on Debugger", e2);
                    return null;
                }
                return null;
            }
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                SwanInspectorEndpoint.this.o.send(str);
            } catch (Exception e2) {
                if (SwanInspectorEndpoint.t) {
                    Log.e("SwanInspector", "Inspector WS send error", e2);
                }
            }
        }
    }

    public SwanInspectorEndpoint() {
        ConnectionState connectionState = ConnectionState.CLOSED;
        this.j = connectionState;
        this.k = connectionState;
        this.p = 0;
        this.q = 0L;
        this.f12840a = UUID.randomUUID().toString();
    }

    public static SwanInspectorEndpoint v() {
        return u;
    }

    public final void p(boolean z) {
        if (this.o != null && this.j != ConnectionState.CLOSED) {
            if (t) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.f12843d);
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
        this.f12841b.clear();
        if (z) {
            return;
        }
        this.f12847h = false;
        this.l = null;
        this.f12842c = null;
        this.f12843d = null;
        this.f12844e = false;
        this.f12845f = false;
        this.f12846g = null;
    }

    public void q() {
        p(false);
    }

    public void r(d.b.g0.g.p.a aVar, d.b.g0.g.i.a aVar2, a.C0986a c0986a, Runnable runnable) {
        p(false);
        w(c0986a);
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

    public final void s(d.b.g0.g.p.a aVar) {
        this.j = ConnectionState.CONNECTING;
        this.f12842c = aVar.a();
        this.f12845f = aVar.b();
        this.f12844e = aVar.d();
        this.f12843d = "ws://" + this.f12842c + "/inspect/inspectorTarget/" + this.f12840a;
        if (t) {
            Log.i("SwanInspector", "Starting inspector to " + this.f12843d);
        }
        this.q = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.f12843d);
        int i = this.p + 1;
        this.p = i;
        this.o = webSocketManager.connect(webSocketRequest, new d(i));
    }

    public final void t(d.b.g0.g.i.a aVar) throws Exception {
        this.k = ConnectionState.CONNECTING;
        if (this.n != aVar.hashCode()) {
            this.m = aVar;
            this.n = aVar.hashCode();
            c cVar = new c();
            this.s = cVar;
            this.r = this.m.m0(cVar);
            this.k = ConnectionState.OPEN;
            return;
        }
        throw new Exception("Can not use the previous connected v8Engine.");
    }

    public String u(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0986a c0986a = this.f12846g;
        if (c0986a == null) {
            c0986a = a.C0986a.c();
        }
        sb.append(c0986a.a());
        sb.append("\n");
        if (!c0986a.b()) {
            return sb.toString();
        }
        String str = null;
        ConnectionState connectionState = this.j;
        if (connectionState == ConnectionState.OPEN) {
            string = resources.getString(h.aiapps_swan_inspector_connection_state_open);
        } else if (this.l == null && (connectionState != ConnectionState.CONNECTING || currentTimeMillis - this.q <= 5000)) {
            if (this.j == ConnectionState.CONNECTING) {
                string = resources.getString(h.aiapps_swan_inspector_connection_state_connecting);
            } else {
                string = resources.getString(h.aiapps_swan_inspector_connection_state_close);
            }
        } else {
            string = resources.getString(h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(h.aiapps_swan_inspector_connection_error_hint);
        }
        sb.append(resources.getString(h.aiapps_swan_inspector_info_label_connection_state));
        sb.append(string);
        sb.append("\n");
        if (str != null) {
            sb.append(str);
            sb.append("\n");
        }
        sb.append(resources.getString(h.aiapps_swan_inspector_info_label_addr));
        sb.append(this.f12842c);
        sb.append("\n");
        if (this.j == ConnectionState.OPEN) {
            sb.append(resources.getString(h.aiapps_swan_inspector_info_label_program_state));
            if (this.i != null) {
                string2 = resources.getString(h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.f12847h) {
                string2 = resources.getString(h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(h.aiapps_swan_inspector_program_state_running);
            }
            sb.append(string2);
            sb.append("\n");
            sb.append(resources.getString(h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.f12844e) {
                string3 = resources.getString(h.aiapps_swan_inspector_text_yes);
            } else {
                string3 = resources.getString(h.aiapps_swan_inspector_text_no);
            }
            sb.append(string3);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void w(a.C0986a c0986a) {
        this.f12846g = c0986a;
    }

    /* loaded from: classes3.dex */
    public class d implements IWebSocketListener {

        /* renamed from: e  reason: collision with root package name */
        public int f12851e;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanInspectorEndpoint.this.f12847h = false;
                String str = (String) SwanInspectorEndpoint.this.f12841b.poll();
                while (str != null) {
                    SwanInspectorEndpoint.this.r.dispatchProtocolMessage(str);
                    str = (String) SwanInspectorEndpoint.this.f12841b.poll();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Runnable f12854e;

            public b(Runnable runnable) {
                this.f12854e = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SwanInspectorEndpoint.t) {
                    Log.i("SwanInspector", "breakOnStart: scheduleBreak and run main JS.");
                }
                SwanInspectorEndpoint.this.r.scheduleBreak();
                this.f12854e.run();
            }
        }

        public d(int i) {
            this.f12851e = -1;
            this.f12851e = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.f12851e == SwanInspectorEndpoint.this.p) {
                if (SwanInspectorEndpoint.t) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.f12843d);
                }
                SwanInspectorEndpoint.this.j = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.p(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onError(Throwable th, JSONObject jSONObject) {
            if (this.f12851e == SwanInspectorEndpoint.this.p) {
                if (SwanInspectorEndpoint.t) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.l = th;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.f12851e != SwanInspectorEndpoint.this.p) {
                return;
            }
            if (SwanInspectorEndpoint.t) {
                Log.d("SwanInspector", "WebSocket onMessage: " + str);
            }
            if (SwanInspectorEndpoint.this.k != ConnectionState.OPEN) {
                if (SwanInspectorEndpoint.t) {
                    Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                    return;
                }
                return;
            }
            b bVar = new b(str);
            if (SwanInspectorEndpoint.this.f12845f && bVar.b()) {
                return;
            }
            SwanInspectorEndpoint.this.f12841b.offer(str);
            SwanInspectorEndpoint.this.m.postOnJSThread(new a());
            if (SwanInspectorEndpoint.this.i == null || !bVar.c()) {
                return;
            }
            Runnable runnable = SwanInspectorEndpoint.this.i;
            SwanInspectorEndpoint.this.i = null;
            SwanInspectorEndpoint.this.m.postOnJSThread(new b(runnable));
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.f12851e == SwanInspectorEndpoint.this.p) {
                if (SwanInspectorEndpoint.t) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.f12843d);
                }
                SwanInspectorEndpoint.this.j = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(ByteBuffer byteBuffer) {
            if (SwanInspectorEndpoint.t) {
                Log.d("SwanInspector", "onMessag with array buffer is not supported.");
            }
        }
    }
}
