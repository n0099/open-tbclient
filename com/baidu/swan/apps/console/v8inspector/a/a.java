package com.baidu.swan.apps.console.v8inspector.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.console.v8inspector.a;
import com.baidu.swan.apps.console.v8inspector.a.c;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import com.baidu.swan.apps.console.v8inspector.websocket.a;
import com.baidu.swan.apps.core.g.e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements Runnable {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int csq;
    private com.baidu.swan.apps.console.v8inspector.websocket.a csl;
    private LinkedBlockingQueue<String> csm = new LinkedBlockingQueue<>();
    private InspectorNativeClient csn;
    private com.baidu.swan.games.f.a cso;
    private a.InterfaceC0387a csp;
    private InputStream mInputStream;
    private OutputStream mOutputStream;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(InputStream inputStream, OutputStream outputStream) {
        this.mInputStream = inputStream;
        this.mOutputStream = outputStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a.InterfaceC0387a interfaceC0387a) {
        if (csq == 0) {
            this.csp = interfaceC0387a;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [221=4, 222=4] */
    @Override // java.lang.Runnable
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.mInputStream));
            c.a aVar = new c.a();
            a(bufferedReader, aVar);
            d.a(aVar).send(this.mOutputStream);
            if (aVar.csB) {
                if (csq != 0 && csq != 3) {
                    com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.t.a.asf(), a.h.aiapps_debug_inspect_doing).showToast();
                    return;
                }
                this.csl = new com.baidu.swan.apps.console.v8inspector.websocket.a();
                this.csl.a(new a.InterfaceC0391a() { // from class: com.baidu.swan.apps.console.v8inspector.a.a.1
                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0391a
                    public void onOpen() {
                        com.baidu.swan.apps.console.c.i("ClientHandler", "V8 inspector opened");
                        com.baidu.swan.apps.core.g.a anE = com.baidu.swan.apps.core.turbo.d.ann().anE();
                        if (anE instanceof e) {
                            a.this.cso = (com.baidu.swan.games.f.a) anE.afd();
                        }
                        if (a.this.cso != null) {
                            if (a.this.csn != null) {
                                a.this.csn.destroy();
                            }
                            a.this.csn = a.this.cso.initInspector(new C0389a());
                            int unused = a.csq = 1;
                            return;
                        }
                        com.baidu.swan.apps.console.c.i("ClientHandler", "inner error, V8 mEngine is null");
                        a.this.close();
                    }

                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0391a
                    public void onClose() {
                        com.baidu.swan.apps.console.c.i("ClientHandler", "V8 inspector closed");
                        a.this.close();
                    }

                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0391a
                    public void a(WebSocketFrame webSocketFrame) {
                        a.this.csm.offer(webSocketFrame.ahZ());
                        a.this.cso.postOnJSThread(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.a.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                String str = (String) a.this.csm.poll();
                                while (str != null) {
                                    a.this.csn.dispatchProtocolMessage(str);
                                    lS(str);
                                    str = (String) a.this.csm.poll();
                                }
                            }
                        });
                    }

                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0391a
                    public void onException(IOException iOException) {
                        com.baidu.swan.apps.console.c.e("ClientHandler", "V8 inspector exception", iOException);
                        a.this.close();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void lS(String str) {
                        if (!TextUtils.isEmpty(str) && a.this.csp != null && a.csq != 2) {
                            try {
                                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                                    com.baidu.swan.apps.runtime.d aCW = com.baidu.swan.apps.runtime.d.aCW();
                                    SwanAppActivity aCU = com.baidu.swan.apps.runtime.d.aCW().aCU();
                                    if (aCW.aBj() && aCU != null) {
                                        aCU.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.a.1.2
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                a.this.csp.onConnected();
                                                a.this.csp = null;
                                                int unused = a.csq = 2;
                                            }
                                        });
                                    }
                                }
                            } catch (JSONException e) {
                                if (a.DEBUG) {
                                    Log.e("ClientHandler", "message is not a Json object", e);
                                }
                            }
                        }
                    }
                });
                this.csl.d(this.mInputStream, this.mOutputStream);
            }
        } catch (RuntimeException e) {
            if (DEBUG) {
                Log.e("ClientHandler", "Request parse fail", e);
            }
        } finally {
            com.baidu.swan.c.d.closeSafely(this.mInputStream);
            com.baidu.swan.c.d.closeSafely(this.mOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close() {
        if (this.csm != null) {
            this.csm.clear();
            this.csm = null;
        }
        if (this.csn != null) {
            this.csn.destroy();
            this.csn = null;
        }
        if (this.mInputStream != null) {
            com.baidu.swan.c.d.closeSafely(this.mInputStream);
            this.mInputStream = null;
        }
        if (this.mOutputStream != null) {
            com.baidu.swan.c.d.closeSafely(this.mOutputStream);
            this.mOutputStream = null;
        }
        this.csl = null;
        this.cso = null;
        csq = 3;
    }

    private static String lR(String str) {
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (UnsupportedEncodingException e) {
            if (!DEBUG) {
                return null;
            }
            Log.d("ClientHandler", "Encoding not supported, ignored");
            return null;
        }
    }

    private void a(BufferedReader bufferedReader, c.a aVar) {
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                if (!stringTokenizer.hasMoreTokens()) {
                    throw new RuntimeException("BAD REQUEST: Syntax error. Usage: GET /example/file.html");
                }
                aVar.method = stringTokenizer.nextToken();
                if (!stringTokenizer.hasMoreTokens()) {
                    throw new RuntimeException("BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                }
                aVar.uri = lR(stringTokenizer.nextToken());
                if (stringTokenizer.hasMoreTokens()) {
                    aVar.csA = stringTokenizer.nextToken();
                } else {
                    aVar.csA = "HTTP/1.1";
                    if (DEBUG) {
                        Log.d("ClientHandler", "no protocol version specified, Assuming HTTP/1.1.");
                    }
                }
                String readLine2 = bufferedReader.readLine();
                while (readLine2 != null && !readLine2.trim().isEmpty()) {
                    if (DEBUG) {
                        Log.d("ClientHandler", "Http header :" + readLine2);
                    }
                    int indexOf = readLine2.indexOf(58);
                    if (indexOf >= 0) {
                        aVar.headers.put(readLine2.substring(0, indexOf).trim().toLowerCase(), readLine2.substring(indexOf + 1).trim());
                    }
                    readLine2 = bufferedReader.readLine();
                }
            }
        } catch (IOException e) {
            if (DEBUG) {
                Log.e("ClientHandler", "Decode header exception", e);
            }
        }
    }

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0389a extends InspectorNativeChannel {
        public C0389a() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                a.this.csl.e(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, str));
            } catch (Exception e) {
                if (a.DEBUG) {
                    Log.d("ClientHandler", "V8 send message fail, try to check if websocket has opened");
                }
            }
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public String awaitMessage() {
            if (a.DEBUG) {
                Log.d("ClientHandler", "getInspectorMessage");
            }
            try {
                return (String) a.this.csm.take();
            } catch (InterruptedException e) {
                if (a.DEBUG) {
                    Log.e("ClientHandler", "awaitMessage on Debugger", e);
                }
                return "";
            }
        }
    }
}
