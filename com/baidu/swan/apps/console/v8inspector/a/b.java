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
import com.baidu.swan.apps.core.g.e;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.LinkedBlockingQueue;
import org.java_websocket.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private LinkedBlockingQueue<String> cdQ = new LinkedBlockingQueue<>();
    private InspectorNativeClient cdR;
    private com.baidu.swan.games.f.a cdS;
    private final a.InterfaceC0375a cdT;
    private org.java_websocket.a.a cdX;
    private String mUrl;

    public b(String str, a.InterfaceC0375a interfaceC0375a) {
        this.mUrl = str;
        this.cdT = interfaceC0375a;
    }

    @Override // com.baidu.swan.apps.console.v8inspector.a.b
    public void start() {
        try {
            this.cdX = new C0378b(new URI(this.mUrl));
            this.cdX.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.swan.apps.console.v8inspector.a.b
    public void stop() {
        if (this.cdX != null) {
            this.cdX.close();
            this.cdX = null;
        }
    }

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0378b extends org.java_websocket.a.a {
        C0378b(URI uri) {
            super(uri);
        }

        @Override // org.java_websocket.a.a
        public void onOpen(h hVar) {
            com.baidu.swan.apps.console.c.i("V8InspectorClient", "V8 inspector opened");
            com.baidu.swan.apps.core.g.a akj = com.baidu.swan.apps.core.turbo.d.ajS().akj();
            if (akj instanceof e) {
                b.this.cdS = (com.baidu.swan.games.f.a) akj.abI();
            }
            if (b.this.cdS == null) {
                com.baidu.swan.apps.console.c.i("V8InspectorClient", "inner error, V8 mEngine is null");
                close();
                return;
            }
            b.this.cdR = b.this.cdS.initInspector(new a());
        }

        @Override // org.java_websocket.a.a
        public void onMessage(String str) {
            b.this.cdQ.offer(str);
            b.this.cdS.postOnJSThread(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = (String) b.this.cdQ.poll();
                    while (str2 != null) {
                        b.this.cdR.dispatchProtocolMessage(str2);
                        C0378b.this.kM(str2);
                        C0378b.this.kN(str2);
                        str2 = (String) b.this.cdQ.poll();
                    }
                }
            });
        }

        @Override // org.java_websocket.a.a
        public void onClose(int i, String str, boolean z) {
            com.baidu.swan.apps.console.c.i("V8InspectorClient", "V8 inspector closed");
        }

        @Override // org.java_websocket.a.a
        public void onError(Exception exc) {
            com.baidu.swan.apps.console.c.e("V8InspectorClient", "V8 inspector error", exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kM(String str) {
            if (!TextUtils.isEmpty(str) && b.this.cdT != null) {
                try {
                    if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                        com.baidu.swan.apps.runtime.d azE = com.baidu.swan.apps.runtime.d.azE();
                        SwanAppActivity azC = azE.azC();
                        if (azE.axR() && azC != null) {
                            azC.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.b.b.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.cdT.onConnected();
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
        public void kN(String str) {
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
                                com.baidu.swan.apps.console.debugger.b.d.aeo();
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

    /* loaded from: classes8.dex */
    public class a extends InspectorNativeChannel {
        public a() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                if (b.this.cdX != null) {
                    b.this.cdX.send(str);
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
                return (String) b.this.cdQ.take();
            } catch (InterruptedException e) {
                if (b.DEBUG) {
                    Log.e("V8InspectorClient", "awaitMessage on Debugger", e);
                }
                return "";
            }
        }
    }
}
