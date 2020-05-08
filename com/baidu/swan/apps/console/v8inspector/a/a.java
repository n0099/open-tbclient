package com.baidu.swan.apps.console.v8inspector.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.v8inspector.a;
import com.baidu.swan.apps.console.v8inspector.a.c;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import com.baidu.swan.apps.console.v8inspector.websocket.a;
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
/* loaded from: classes11.dex */
public class a implements Runnable {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean bJH;
    private com.baidu.swan.apps.console.v8inspector.websocket.a bJC;
    private LinkedBlockingQueue<String> bJD = new LinkedBlockingQueue<>();
    private InspectorNativeClient bJE;
    private com.baidu.swan.games.e.a bJF;
    private a.InterfaceC0289a bJG;
    private InputStream mInputStream;
    private OutputStream mOutputStream;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(InputStream inputStream, OutputStream outputStream) {
        this.mInputStream = inputStream;
        this.mOutputStream = outputStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a.InterfaceC0289a interfaceC0289a) {
        this.bJG = interfaceC0289a;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.mInputStream));
            c.a aVar = new c.a();
            a(bufferedReader, aVar);
            d.a(aVar).send(this.mOutputStream);
            if (aVar.bJR) {
                this.bJC = new com.baidu.swan.apps.console.v8inspector.websocket.a();
                this.bJC.a(new a.InterfaceC0293a() { // from class: com.baidu.swan.apps.console.v8inspector.a.a.1
                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0293a
                    public void onOpen() {
                        com.baidu.swan.apps.console.c.d("ClientHandler", "V8 inspector opened");
                        a.this.bJF = (com.baidu.swan.games.e.a) com.baidu.swan.apps.core.k.d.Yn().YC().Rr();
                        a.this.bJE = a.this.bJF.initInspector(new C0291a());
                    }

                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0293a
                    public void onClose() {
                        com.baidu.swan.apps.console.c.d("ClientHandler", "V8 inspector closed");
                        a.this.TX();
                    }

                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0293a
                    public void a(WebSocketFrame webSocketFrame) {
                        a.this.bJD.offer(webSocketFrame.Ug());
                        a.this.bJF.postOnJSThread(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.a.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                String str = (String) a.this.bJD.poll();
                                while (str != null) {
                                    a.this.bJE.dispatchProtocolMessage(str);
                                    hT(str);
                                    str = (String) a.this.bJD.poll();
                                }
                            }
                        });
                    }

                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0293a
                    public void onException(IOException iOException) {
                        com.baidu.swan.apps.console.c.e("ClientHandler", "V8 inspector exception", iOException);
                        a.this.TX();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void hT(String str) {
                        if (!TextUtils.isEmpty(str) && a.this.bJG != null && !a.bJH) {
                            try {
                                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                                    com.baidu.swan.apps.runtime.d akJ = com.baidu.swan.apps.runtime.d.akJ();
                                    SwanAppActivity akI = com.baidu.swan.apps.runtime.d.akJ().akI();
                                    if (akJ.ajq() && akI != null) {
                                        akI.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.a.1.2
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                a.this.bJG.onConnected();
                                                boolean unused = a.bJH = true;
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
                this.bJC.d(this.mInputStream, this.mOutputStream);
            }
        } catch (RuntimeException e) {
            if (DEBUG) {
                Log.e("ClientHandler", "Request parse fail", e);
            }
        } finally {
            com.baidu.swan.d.c.closeSafely(this.mInputStream);
            com.baidu.swan.d.c.closeSafely(this.mOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TX() {
        if (this.bJD != null) {
            this.bJD.clear();
            this.mInputStream = null;
        }
        if (this.mInputStream != null) {
            com.baidu.swan.d.c.closeSafely(this.mInputStream);
            this.mInputStream = null;
        }
        if (this.mOutputStream != null) {
            com.baidu.swan.d.c.closeSafely(this.mOutputStream);
            this.mOutputStream = null;
        }
        this.bJC = null;
        this.bJF = null;
        this.bJE = null;
    }

    private static String hS(String str) {
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
                aVar.uri = hS(stringTokenizer.nextToken());
                if (stringTokenizer.hasMoreTokens()) {
                    aVar.bJQ = stringTokenizer.nextToken();
                } else {
                    aVar.bJQ = "HTTP/1.1";
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
    /* loaded from: classes11.dex */
    public class C0291a extends InspectorNativeChannel {
        public C0291a() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                a.this.bJC.e(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, str));
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
                return (String) a.this.bJD.take();
            } catch (InterruptedException e) {
                if (a.DEBUG) {
                    Log.e("ClientHandler", "awaitMessage on Debugger", e);
                }
                return "";
            }
        }
    }
}
