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
/* loaded from: classes10.dex */
public class b implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private LinkedBlockingQueue<String> cGF = new LinkedBlockingQueue<>();
    private InspectorNativeClient cGG;
    private com.baidu.swan.games.f.a cGH;
    private final a.InterfaceC0413a cGI;
    private org.java_websocket.a.a cGM;
    private String mUrl;

    public b(String str, a.InterfaceC0413a interfaceC0413a) {
        this.mUrl = str;
        this.cGI = interfaceC0413a;
    }

    @Override // com.baidu.swan.apps.console.v8inspector.a.b
    public void start() {
        try {
            this.cGM = new C0416b(new URI(this.mUrl));
            this.cGM.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.swan.apps.console.v8inspector.a.b
    public void stop() {
        if (this.cGM != null) {
            this.cGM.close();
            this.cGM = null;
        }
    }

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0416b extends org.java_websocket.a.a {
        C0416b(URI uri) {
            super(uri);
        }

        @Override // org.java_websocket.a.a
        public void onOpen(h hVar) {
            com.baidu.swan.apps.console.c.i("V8InspectorClient", "V8 inspector opened");
            com.baidu.swan.apps.core.g.a arZ = com.baidu.swan.apps.core.turbo.d.arI().arZ();
            if (arZ instanceof e) {
                b.this.cGH = (com.baidu.swan.games.f.a) arZ.ajx();
            }
            if (b.this.cGH == null) {
                com.baidu.swan.apps.console.c.i("V8InspectorClient", "inner error, V8 mEngine is null");
                close();
                return;
            }
            b.this.cGG = b.this.cGH.initInspector(new a());
        }

        @Override // org.java_websocket.a.a
        public void onMessage(String str) {
            b.this.cGF.offer(str);
            b.this.cGH.postOnJSThread(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = (String) b.this.cGF.poll();
                    while (str2 != null) {
                        b.this.cGG.dispatchProtocolMessage(str2);
                        C0416b.this.mA(str2);
                        C0416b.this.mB(str2);
                        str2 = (String) b.this.cGF.poll();
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
        public void mA(String str) {
            if (!TextUtils.isEmpty(str) && b.this.cGI != null) {
                try {
                    if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                        com.baidu.swan.apps.runtime.d aHq = com.baidu.swan.apps.runtime.d.aHq();
                        SwanAppActivity aHo = aHq.aHo();
                        if (aHq.aFD() && aHo != null) {
                            aHo.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.b.b.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.cGI.onConnected();
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
        public void mB(String str) {
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
                                com.baidu.swan.apps.console.debugger.b.d.amd();
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

    /* loaded from: classes10.dex */
    public class a extends InspectorNativeChannel {
        public a() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                if (b.this.cGM != null) {
                    b.this.cGM.send(str);
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
                return (String) b.this.cGF.take();
            } catch (InterruptedException e) {
                if (b.DEBUG) {
                    Log.e("V8InspectorClient", "awaitMessage on Debugger", e);
                }
                return "";
            }
        }
    }
}
