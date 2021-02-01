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
/* loaded from: classes9.dex */
public class a implements Runnable {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cOq;
    private com.baidu.swan.apps.console.v8inspector.websocket.a cOl;
    private LinkedBlockingQueue<String> cOm = new LinkedBlockingQueue<>();
    private InspectorNativeClient cOn;
    private com.baidu.swan.games.f.a cOo;
    private a.InterfaceC0395a cOp;
    private InputStream mInputStream;
    private OutputStream mOutputStream;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(InputStream inputStream, OutputStream outputStream) {
        this.mInputStream = inputStream;
        this.mOutputStream = outputStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a.InterfaceC0395a interfaceC0395a) {
        if (cOq == 0) {
            this.cOp = interfaceC0395a;
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
            if (aVar.cOB) {
                if (cOq != 0 && cOq != 3) {
                    com.baidu.swan.apps.res.widget.b.d.u(com.baidu.swan.apps.t.a.awW(), a.h.aiapps_debug_inspect_doing).aIs();
                    return;
                }
                this.cOl = new com.baidu.swan.apps.console.v8inspector.websocket.a();
                this.cOl.a(new a.InterfaceC0399a() { // from class: com.baidu.swan.apps.console.v8inspector.a.a.1
                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0399a
                    public void onOpen() {
                        com.baidu.swan.apps.console.c.i("ClientHandler", "V8 inspector opened");
                        com.baidu.swan.apps.core.g.a asw = com.baidu.swan.apps.core.turbo.d.ase().asw();
                        if (asw instanceof e) {
                            a.this.cOo = (com.baidu.swan.games.f.a) asw.ajM();
                        }
                        if (a.this.cOo != null) {
                            if (a.this.cOn != null) {
                                a.this.cOn.destroy();
                            }
                            a.this.cOn = a.this.cOo.initInspector(new C0397a());
                            int unused = a.cOq = 1;
                            return;
                        }
                        com.baidu.swan.apps.console.c.i("ClientHandler", "inner error, V8 mEngine is null");
                        a.this.close();
                    }

                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0399a
                    public void onClose() {
                        com.baidu.swan.apps.console.c.i("ClientHandler", "V8 inspector closed");
                        a.this.close();
                    }

                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0399a
                    public void a(WebSocketFrame webSocketFrame) {
                        a.this.cOm.offer(webSocketFrame.amK());
                        a.this.cOo.postOnJSThread(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.a.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                String str = (String) a.this.cOm.poll();
                                while (str != null) {
                                    a.this.cOn.dispatchProtocolMessage(str);
                                    mb(str);
                                    str = (String) a.this.cOm.poll();
                                }
                            }
                        });
                    }

                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0399a
                    public void onException(IOException iOException) {
                        com.baidu.swan.apps.console.c.e("ClientHandler", "V8 inspector exception", iOException);
                        a.this.close();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void mb(String str) {
                        if (!TextUtils.isEmpty(str) && a.this.cOp != null && a.cOq != 2) {
                            try {
                                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                                    com.baidu.swan.apps.runtime.d aIG = com.baidu.swan.apps.runtime.d.aIG();
                                    SwanAppActivity aIE = com.baidu.swan.apps.runtime.d.aIG().aIE();
                                    if (aIG.aFY() && aIE != null) {
                                        aIE.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.a.1.2
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                a.this.cOp.onConnected();
                                                a.this.cOp = null;
                                                int unused = a.cOq = 2;
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
                this.cOl.d(this.mInputStream, this.mOutputStream);
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
        if (this.cOm != null) {
            this.cOm.clear();
            this.cOm = null;
        }
        if (this.cOn != null) {
            this.cOn.destroy();
            this.cOn = null;
        }
        if (this.mInputStream != null) {
            com.baidu.swan.c.d.closeSafely(this.mInputStream);
            this.mInputStream = null;
        }
        if (this.mOutputStream != null) {
            com.baidu.swan.c.d.closeSafely(this.mOutputStream);
            this.mOutputStream = null;
        }
        this.cOl = null;
        this.cOo = null;
        cOq = 3;
    }

    private static String ma(String str) {
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
                aVar.uri = ma(stringTokenizer.nextToken());
                if (stringTokenizer.hasMoreTokens()) {
                    aVar.cOA = stringTokenizer.nextToken();
                } else {
                    aVar.cOA = "HTTP/1.1";
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
    /* loaded from: classes9.dex */
    public class C0397a extends InspectorNativeChannel {
        public C0397a() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                a.this.cOl.e(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, str));
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
                return (String) a.this.cOm.take();
            } catch (InterruptedException e) {
                if (a.DEBUG) {
                    Log.e("ClientHandler", "awaitMessage on Debugger", e);
                }
                return "";
            }
        }
    }
}
