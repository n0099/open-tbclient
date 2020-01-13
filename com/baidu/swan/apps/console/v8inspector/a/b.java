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
/* loaded from: classes10.dex */
public class b implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private LinkedBlockingQueue<String> bgP = new LinkedBlockingQueue<>();
    private InspectorNativeClient bgQ;
    private com.baidu.swan.games.e.a bgR;
    private final a.InterfaceC0228a bgS;
    private org.java_websocket.a.a bgW;
    private String mUrl;

    public b(String str, a.InterfaceC0228a interfaceC0228a) {
        this.mUrl = str;
        this.bgS = interfaceC0228a;
    }

    @Override // com.baidu.swan.apps.console.v8inspector.a.b
    public void start() {
        try {
            this.bgW = new C0231b(new URI(this.mUrl));
            this.bgW.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0231b extends org.java_websocket.a.a {
        C0231b(URI uri) {
            super(uri);
        }

        @Override // org.java_websocket.a.a
        public void onOpen(h hVar) {
            com.baidu.swan.apps.console.c.d("V8InspectorClient", "V8 inspector opened");
            b.this.bgR = (com.baidu.swan.games.e.a) com.baidu.swan.apps.core.k.d.Og().Ov().Hm();
            b.this.bgQ = b.this.bgR.initInspector(new a());
        }

        @Override // org.java_websocket.a.a
        public void onMessage(String str) {
            b.this.bgP.offer(str);
            b.this.bgR.postOnJSThread(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = (String) b.this.bgP.poll();
                    while (str2 != null) {
                        b.this.bgQ.dispatchProtocolMessage(str2);
                        C0231b.this.gq(str2);
                        C0231b.this.gr(str2);
                        str2 = (String) b.this.bgP.poll();
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
        public void gq(String str) {
            if (!TextUtils.isEmpty(str) && b.this.bgS != null) {
                try {
                    if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                        com.baidu.swan.apps.runtime.d aam = com.baidu.swan.apps.runtime.d.aam();
                        SwanAppActivity aal = aam.aal();
                        if (aam.YT() && aal != null) {
                            aal.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.b.b.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.bgS.onConnected();
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
        public void gr(String str) {
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
                                com.baidu.swan.apps.console.debugger.b.d.JI();
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
                if (b.this.bgW != null) {
                    b.this.bgW.send(str);
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
                return (String) b.this.bgP.take();
            } catch (InterruptedException e) {
                if (b.DEBUG) {
                    Log.e("V8InspectorClient", "awaitMessage on Debugger", e);
                }
                return "";
            }
        }
    }
}
