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
/* loaded from: classes7.dex */
public class a implements Runnable {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int bYk;
    private com.baidu.swan.apps.console.v8inspector.websocket.a bYf;
    private LinkedBlockingQueue<String> bYg = new LinkedBlockingQueue<>();
    private InspectorNativeClient bYh;
    private com.baidu.swan.games.f.a bYi;
    private a.InterfaceC0334a bYj;
    private InputStream mInputStream;
    private OutputStream mOutputStream;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(InputStream inputStream, OutputStream outputStream) {
        this.mInputStream = inputStream;
        this.mOutputStream = outputStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a.InterfaceC0334a interfaceC0334a) {
        if (bYk == 0) {
            this.bYj = interfaceC0334a;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [211=4, 212=4] */
    @Override // java.lang.Runnable
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.mInputStream));
            c.a aVar = new c.a();
            a(bufferedReader, aVar);
            d.a(aVar).send(this.mOutputStream);
            if (aVar.bYv) {
                if (bYk != 0 && bYk != 3) {
                    com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.t.a.ahj(), a.h.aiapps_debug_inspect_doing).showToast();
                    return;
                }
                this.bYf = new com.baidu.swan.apps.console.v8inspector.websocket.a();
                this.bYf.a(new a.InterfaceC0338a() { // from class: com.baidu.swan.apps.console.v8inspector.a.a.1
                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0338a
                    public void onOpen() {
                        com.baidu.swan.apps.console.c.i("ClientHandler", "V8 inspector opened");
                        a.this.bYi = (com.baidu.swan.games.f.a) com.baidu.swan.apps.core.turbo.d.adw().adM().VC();
                        if (a.this.bYh != null) {
                            a.this.bYh.destroy();
                        }
                        a.this.bYh = a.this.bYi.initInspector(new C0336a());
                        int unused = a.bYk = 1;
                    }

                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0338a
                    public void onClose() {
                        com.baidu.swan.apps.console.c.i("ClientHandler", "V8 inspector closed");
                        a.this.close();
                    }

                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0338a
                    public void a(WebSocketFrame webSocketFrame) {
                        a.this.bYg.offer(webSocketFrame.Yy());
                        a.this.bYi.postOnJSThread(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.a.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                String str = (String) a.this.bYg.poll();
                                while (str != null) {
                                    a.this.bYh.dispatchProtocolMessage(str);
                                    jm(str);
                                    str = (String) a.this.bYg.poll();
                                }
                            }
                        });
                    }

                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0338a
                    public void onException(IOException iOException) {
                        com.baidu.swan.apps.console.c.e("ClientHandler", "V8 inspector exception", iOException);
                        a.this.close();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void jm(String str) {
                        if (!TextUtils.isEmpty(str) && a.this.bYj != null && a.bYk != 2) {
                            try {
                                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                                    com.baidu.swan.apps.runtime.d arr = com.baidu.swan.apps.runtime.d.arr();
                                    SwanAppActivity arp = com.baidu.swan.apps.runtime.d.arr().arp();
                                    if (arr.apU() && arp != null) {
                                        arp.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.a.1.2
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                a.this.bYj.onConnected();
                                                a.this.bYj = null;
                                                int unused = a.bYk = 2;
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
                this.bYf.d(this.mInputStream, this.mOutputStream);
            }
        } catch (RuntimeException e) {
            if (DEBUG) {
                Log.e("ClientHandler", "Request parse fail", e);
            }
        } finally {
            com.baidu.swan.d.d.closeSafely(this.mInputStream);
            com.baidu.swan.d.d.closeSafely(this.mOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close() {
        if (this.bYg != null) {
            this.bYg.clear();
            this.bYg = null;
        }
        if (this.bYh != null) {
            this.bYh.destroy();
            this.bYh = null;
        }
        if (this.mInputStream != null) {
            com.baidu.swan.d.d.closeSafely(this.mInputStream);
            this.mInputStream = null;
        }
        if (this.mOutputStream != null) {
            com.baidu.swan.d.d.closeSafely(this.mOutputStream);
            this.mOutputStream = null;
        }
        this.bYf = null;
        this.bYi = null;
        bYk = 3;
    }

    private static String jl(String str) {
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
                aVar.uri = jl(stringTokenizer.nextToken());
                if (stringTokenizer.hasMoreTokens()) {
                    aVar.bYu = stringTokenizer.nextToken();
                } else {
                    aVar.bYu = "HTTP/1.1";
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
    /* loaded from: classes7.dex */
    public class C0336a extends InspectorNativeChannel {
        public C0336a() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                a.this.bYf.e(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, str));
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
                return (String) a.this.bYg.take();
            } catch (InterruptedException e) {
                if (a.DEBUG) {
                    Log.e("ClientHandler", "awaitMessage on Debugger", e);
                }
                return "";
            }
        }
    }
}
