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
    private static boolean blf;
    private com.baidu.swan.apps.console.v8inspector.websocket.a bla;
    private LinkedBlockingQueue<String> blb = new LinkedBlockingQueue<>();
    private InspectorNativeClient blc;
    private com.baidu.swan.games.e.a bld;
    private a.InterfaceC0238a ble;
    private InputStream mInputStream;
    private OutputStream mOutputStream;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(InputStream inputStream, OutputStream outputStream) {
        this.mInputStream = inputStream;
        this.mOutputStream = outputStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a.InterfaceC0238a interfaceC0238a) {
        this.ble = interfaceC0238a;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.mInputStream));
            c.a aVar = new c.a();
            a(bufferedReader, aVar);
            d.a(aVar).send(this.mOutputStream);
            if (aVar.blp) {
                this.bla = new com.baidu.swan.apps.console.v8inspector.websocket.a();
                this.bla.a(new a.InterfaceC0242a() { // from class: com.baidu.swan.apps.console.v8inspector.a.a.1
                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0242a
                    public void Mh() {
                        com.baidu.swan.apps.console.c.d("ClientHandler", "V8 inspector opened");
                        a.this.bld = (com.baidu.swan.games.e.a) com.baidu.swan.apps.core.k.d.Qu().QJ().JB();
                        a.this.blc = a.this.bld.initInspector(new C0240a());
                    }

                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0242a
                    public void onClose() {
                        com.baidu.swan.apps.console.c.d("ClientHandler", "V8 inspector closed");
                        a.this.Mf();
                    }

                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0242a
                    public void a(WebSocketFrame webSocketFrame) {
                        a.this.blb.offer(webSocketFrame.Mp());
                        a.this.bld.postOnJSThread(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.a.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                String str = (String) a.this.blb.poll();
                                while (str != null) {
                                    a.this.blc.dispatchProtocolMessage(str);
                                    gG(str);
                                    str = (String) a.this.blb.poll();
                                }
                            }
                        });
                    }

                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0242a
                    public void onException(IOException iOException) {
                        com.baidu.swan.apps.console.c.e("ClientHandler", "V8 inspector exception", iOException);
                        a.this.Mf();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void gG(String str) {
                        if (!TextUtils.isEmpty(str) && a.this.ble != null && !a.blf) {
                            try {
                                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                                    com.baidu.swan.apps.runtime.d acA = com.baidu.swan.apps.runtime.d.acA();
                                    SwanAppActivity acz = com.baidu.swan.apps.runtime.d.acA().acz();
                                    if (acA.abh() && acz != null) {
                                        acz.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.a.1.2
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                a.this.ble.onConnected();
                                                boolean unused = a.blf = true;
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
                this.bla.d(this.mInputStream, this.mOutputStream);
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
    public void Mf() {
        if (this.blb != null) {
            this.blb.clear();
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
        this.bla = null;
        this.bld = null;
        this.blc = null;
    }

    private static String cM(String str) {
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
                aVar.uri = cM(stringTokenizer.nextToken());
                if (stringTokenizer.hasMoreTokens()) {
                    aVar.blo = stringTokenizer.nextToken();
                } else {
                    aVar.blo = "HTTP/1.1";
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
    public class C0240a extends InspectorNativeChannel {
        public C0240a() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                a.this.bla.e(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, str));
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
                return (String) a.this.blb.take();
            } catch (InterruptedException e) {
                if (a.DEBUG) {
                    Log.e("ClientHandler", "awaitMessage on Debugger", e);
                }
                return "";
            }
        }
    }
}
