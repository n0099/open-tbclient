package com.baidu.swan.games.inspector;

import android.content.res.Resources;
import android.util.Log;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.searchbox.websocket.IWebSocketListener;
import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.tieba.R;
import com.baidu.tieba.gj2;
import com.baidu.tieba.is1;
import com.baidu.tieba.m84;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SwanInspectorEndpoint {
    public static final boolean t = is1.a;
    public static SwanInspectorEndpoint u = new SwanInspectorEndpoint();
    public String a;
    public String c;
    public String d;
    public m84.a g;
    public Runnable i;
    public ConnectionState j;
    public ConnectionState k;
    public Throwable l;
    public gj2 m;
    public int n;
    public WebSocketTask o;
    public int p;
    public long q;
    public InspectorNativeClient r;
    public InspectorNativeChannel s;
    public LinkedBlockingQueue<String> b = new LinkedBlockingQueue<>();
    public boolean e = false;
    public boolean f = false;
    public boolean h = false;

    /* loaded from: classes4.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes4.dex */
    public class d implements IWebSocketListener {
        public int a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanInspectorEndpoint.this.h = false;
                String str = (String) SwanInspectorEndpoint.this.b.poll();
                while (str != null) {
                    SwanInspectorEndpoint.this.r.dispatchProtocolMessage(str);
                    str = (String) SwanInspectorEndpoint.this.b.poll();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public final /* synthetic */ Runnable a;

            public b(Runnable runnable) {
                this.a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SwanInspectorEndpoint.t) {
                    Log.i("SwanInspector", "breakOnStart: scheduleBreak and run main JS.");
                }
                SwanInspectorEndpoint.this.r.scheduleBreak();
                this.a.run();
            }
        }

        public d(int i) {
            this.a = -1;
            this.a = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onError(Throwable th, JSONObject jSONObject) {
            if (this.a == SwanInspectorEndpoint.this.p) {
                if (SwanInspectorEndpoint.t) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.l = th;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.a == SwanInspectorEndpoint.this.p) {
                if (SwanInspectorEndpoint.t) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.d);
                }
                SwanInspectorEndpoint.this.j = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.p(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.a == SwanInspectorEndpoint.this.p) {
                if (SwanInspectorEndpoint.t) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.d);
                }
                SwanInspectorEndpoint.this.j = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.a != SwanInspectorEndpoint.this.p) {
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
            if (SwanInspectorEndpoint.this.f && bVar.b()) {
                return;
            }
            SwanInspectorEndpoint.this.b.offer(str);
            SwanInspectorEndpoint.this.m.postOnJSThread(new a());
            if (SwanInspectorEndpoint.this.i != null && bVar.c()) {
                Runnable runnable = SwanInspectorEndpoint.this.i;
                SwanInspectorEndpoint.this.i = null;
                SwanInspectorEndpoint.this.m.postOnJSThread(new b(runnable));
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(ByteBuffer byteBuffer) {
            if (SwanInspectorEndpoint.t) {
                Log.d("SwanInspector", "onMessag with array buffer is not supported.");
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public String a;
        public JSONObject b;

        public b(String str) {
            this.a = str;
        }

        public final JSONObject d(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (SwanInspectorEndpoint.t) {
                    Log.e("SwanInspector", "Illegal inspector message: ", e);
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

        public final JSONObject a() {
            if (this.b == null) {
                this.b = d(this.a);
            }
            return this.b;
        }

        public boolean b() {
            String e = e(a());
            if (e != null && e.indexOf("Debugger.") == 0) {
                return true;
            }
            return false;
        }

        public boolean c() {
            return "Debugger.enable".equals(e(a()));
        }
    }

    /* loaded from: classes4.dex */
    public class c extends InspectorNativeChannel {
        public c() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                SwanInspectorEndpoint.this.o.send(str);
            } catch (Exception e) {
                if (SwanInspectorEndpoint.t) {
                    Log.e("SwanInspector", "Inspector WS send error", e);
                }
            }
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public String awaitMessage() {
            if (SwanInspectorEndpoint.t) {
                Log.d("SwanInspector", "getInspectorMessage");
            }
            try {
                SwanInspectorEndpoint.this.h = true;
                return (String) SwanInspectorEndpoint.this.b.take();
            } catch (InterruptedException e) {
                if (SwanInspectorEndpoint.t) {
                    Log.e("SwanInspector", "awaitMessage on Debugger", e);
                    return null;
                }
                return null;
            }
        }
    }

    public SwanInspectorEndpoint() {
        ConnectionState connectionState = ConnectionState.CLOSED;
        this.j = connectionState;
        this.k = connectionState;
        this.p = 0;
        this.q = 0L;
        this.a = UUID.randomUUID().toString();
    }

    public static SwanInspectorEndpoint v() {
        return u;
    }

    public void q() {
        p(false);
    }

    public final void t(gj2 gj2Var) throws Exception {
        this.k = ConnectionState.CONNECTING;
        if (this.n != gj2Var.hashCode()) {
            this.m = gj2Var;
            this.n = gj2Var.hashCode();
            c cVar = new c();
            this.s = cVar;
            this.r = this.m.q0(cVar);
            this.k = ConnectionState.OPEN;
            return;
        }
        throw new Exception("Can not use the previous connected v8Engine.");
    }

    public void w(m84.a aVar) {
        this.g = aVar;
    }

    public final void p(boolean z) {
        if (this.o != null && this.j != ConnectionState.CLOSED) {
            if (t) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.d);
            }
            try {
                this.o.close(0, "Inspector close");
            } catch (Exception e) {
                if (t) {
                    Log.e("SwanInspector", "close error", e);
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
        this.b.clear();
        if (!z) {
            this.h = false;
            this.l = null;
            this.c = null;
            this.d = null;
            this.e = false;
            this.f = false;
            this.g = null;
        }
    }

    public void r(m84 m84Var, gj2 gj2Var, m84.a aVar, Runnable runnable) {
        p(false);
        w(aVar);
        try {
            t(gj2Var);
            if (m84Var.d()) {
                this.i = runnable;
                s(m84Var);
            } else {
                s(m84Var);
                runnable.run();
            }
        } catch (Exception e) {
            if (t) {
                Log.e("SwanInspector", "Init fail", e);
            }
            p(true);
        }
    }

    public final void s(m84 m84Var) {
        this.j = ConnectionState.CONNECTING;
        this.c = m84Var.a();
        this.f = m84Var.b();
        this.e = m84Var.d();
        this.d = "ws://" + this.c + "/inspect/inspectorTarget/" + this.a;
        if (t) {
            Log.i("SwanInspector", "Starting inspector to " + this.d);
        }
        this.q = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.d);
        int i = this.p + 1;
        this.p = i;
        this.o = webSocketManager.connect(webSocketRequest, new d(i));
    }

    public String u(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        m84.a aVar = this.g;
        if (aVar == null) {
            aVar = m84.a.c();
        }
        sb.append(aVar.a());
        sb.append("\n");
        if (!aVar.b()) {
            return sb.toString();
        }
        String str = null;
        ConnectionState connectionState = this.j;
        if (connectionState == ConnectionState.OPEN) {
            string = resources.getString(R.string.obfuscated_res_0x7f0f019e);
        } else if (this.l == null && (connectionState != ConnectionState.CONNECTING || currentTimeMillis - this.q <= 5000)) {
            if (this.j == ConnectionState.CONNECTING) {
                string = resources.getString(R.string.obfuscated_res_0x7f0f019c);
            } else {
                string = resources.getString(R.string.obfuscated_res_0x7f0f019b);
            }
        } else {
            string = resources.getString(R.string.obfuscated_res_0x7f0f019d);
            str = resources.getString(R.string.obfuscated_res_0x7f0f019a);
        }
        sb.append(resources.getString(R.string.obfuscated_res_0x7f0f01a1));
        sb.append(string);
        sb.append("\n");
        if (str != null) {
            sb.append(str);
            sb.append("\n");
        }
        sb.append(resources.getString(R.string.obfuscated_res_0x7f0f01a0));
        sb.append(this.c);
        sb.append("\n");
        if (this.j == ConnectionState.OPEN) {
            sb.append(resources.getString(R.string.obfuscated_res_0x7f0f01a3));
            if (this.i != null) {
                string2 = resources.getString(R.string.obfuscated_res_0x7f0f01a5);
            } else if (this.h) {
                string2 = resources.getString(R.string.obfuscated_res_0x7f0f01a4);
            } else {
                string2 = resources.getString(R.string.obfuscated_res_0x7f0f01a6);
            }
            sb.append(string2);
            sb.append("\n");
            sb.append(resources.getString(R.string.obfuscated_res_0x7f0f01a2));
            if (this.e) {
                string3 = resources.getString(R.string.obfuscated_res_0x7f0f01a8);
            } else {
                string3 = resources.getString(R.string.obfuscated_res_0x7f0f01a7);
            }
            sb.append(string3);
            sb.append("\n");
        }
        return sb.toString();
    }
}
