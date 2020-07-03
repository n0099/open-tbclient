package com.baidu.swan.apps.console.v8inspector.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.v8inspector.a;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.LinkedBlockingQueue;
import org.java_websocket.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private LinkedBlockingQueue<String> bXn = new LinkedBlockingQueue<>();
    private InspectorNativeClient bXo;
    private com.baidu.swan.games.f.a bXp;
    private final a.InterfaceC0332a bXq;
    private org.java_websocket.a.a bXu;
    private String mUrl;

    public b(String str, a.InterfaceC0332a interfaceC0332a) {
        this.mUrl = str;
        this.bXq = interfaceC0332a;
    }

    @Override // com.baidu.swan.apps.console.v8inspector.a.b
    public void start() {
        try {
            this.bXu = new C0335b(new URI(this.mUrl));
            this.bXu.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.swan.apps.console.v8inspector.a.b
    public void stop() {
        if (this.bXu != null) {
            this.bXu.close();
            this.bXu = null;
        }
    }

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0335b extends org.java_websocket.a.a {
        C0335b(URI uri) {
            super(uri);
        }

        @Override // org.java_websocket.a.a
        public void onOpen(h hVar) {
            com.baidu.swan.apps.console.c.d("V8InspectorClient", "V8 inspector opened");
            b.this.bXp = (com.baidu.swan.games.f.a) com.baidu.swan.apps.core.turbo.d.acr().acH().UX();
            b.this.bXo = b.this.bXp.initInspector(new a());
        }

        @Override // org.java_websocket.a.a
        public void onMessage(String str) {
            b.this.bXn.offer(str);
            b.this.bXp.postOnJSThread(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = (String) b.this.bXn.poll();
                    while (str2 != null) {
                        b.this.bXo.dispatchProtocolMessage(str2);
                        C0335b.this.jc(str2);
                        C0335b.this.jd(str2);
                        str2 = (String) b.this.bXn.poll();
                    }
                }
            });
        }

        @Override // org.java_websocket.a.a
        public void onClose(int i, String str, boolean z) {
            com.baidu.swan.apps.console.c.d("V8InspectorClient", "V8 inspector closed");
        }

        @Override // org.java_websocket.a.a
        public void onError(Exception exc) {
            com.baidu.swan.apps.console.c.d("V8InspectorClient", "V8 inspector error");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void jc(String str) {
            if (!TextUtils.isEmpty(str) && b.this.bXq != null) {
                try {
                    if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                        com.baidu.swan.apps.runtime.d apI = com.baidu.swan.apps.runtime.d.apI();
                        SwanAppActivity apG = apI.apG();
                        if (apI.aok() && apG != null) {
                            apG.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.b.b.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.bXq.onConnected();
                                }
                            });
                        }
                    }
                } catch (JSONException e) {
                    if (b.DEBUG) {
                        Log.e("V8InspectorClient", "message is not a Json object", e);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void jd(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("command");
                    if (!TextUtils.isEmpty(optString)) {
                        char c = 65535;
                        switch (optString.hashCode()) {
                            case -934641255:
                                if (optString.equals("reload")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 94756344:
                                if (optString.equals("close")) {
                                    c = 1;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                com.baidu.swan.apps.console.c.i("V8InspectorClient", "v8 inspector reload");
                                String optString2 = jSONObject.optString("value");
                                if (!TextUtils.isEmpty(optString2) && TextUtils.equals(Uri.parse(optString2).getHost(), "swanAPI")) {
                                    SchemeRouter.invoke(AppRuntime.getAppContext(), optString2);
                                    return;
                                }
                                return;
                            case 1:
                                com.baidu.swan.apps.console.c.i("V8InspectorClient", "v8 inspector close");
                                com.baidu.swan.apps.console.debugger.b.d.XC();
                                return;
                            default:
                                com.baidu.swan.apps.console.c.e("V8InspectorClient", "Undefined command");
                                return;
                        }
                    }
                } catch (JSONException e) {
                    if (b.DEBUG) {
                        Log.e("V8InspectorClient", "message is not a json object", e);
                    }
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class a extends InspectorNativeChannel {
        public a() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                if (b.this.bXu != null) {
                    b.this.bXu.send(str);
                }
            } catch (Exception e) {
                if (b.DEBUG) {
                    Log.d("V8InspectorClient", "V8 send message fail, try to check if websocket has opened");
                }
            }
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public String awaitMessage() {
            if (b.DEBUG) {
                Log.d("V8InspectorClient", "getInspectorMessage");
            }
            try {
                return (String) b.this.bXn.take();
            } catch (InterruptedException e) {
                if (b.DEBUG) {
                    Log.e("V8InspectorClient", "awaitMessage on Debugger", e);
                }
                return "";
            }
        }
    }
}
