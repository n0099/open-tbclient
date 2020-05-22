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
/* loaded from: classes11.dex */
public class a implements Runnable {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int bSD;
    private InspectorNativeClient bSA;
    private com.baidu.swan.games.f.a bSB;
    private a.InterfaceC0326a bSC;
    private com.baidu.swan.apps.console.v8inspector.websocket.a bSy;
    private LinkedBlockingQueue<String> bSz = new LinkedBlockingQueue<>();
    private InputStream mInputStream;
    private OutputStream mOutputStream;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(InputStream inputStream, OutputStream outputStream) {
        this.mInputStream = inputStream;
        this.mOutputStream = outputStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a.InterfaceC0326a interfaceC0326a) {
        if (bSD == 0) {
            this.bSC = interfaceC0326a;
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
            if (aVar.bSO) {
                if (bSD != 0 && bSD != 3) {
                    com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.u.a.aeR(), a.h.aiapps_debug_inspect_doing).showToast();
                    return;
                }
                this.bSy = new com.baidu.swan.apps.console.v8inspector.websocket.a();
                this.bSy.a(new a.InterfaceC0330a() { // from class: com.baidu.swan.apps.console.v8inspector.a.a.1
                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0330a
                    public void onOpen() {
                        com.baidu.swan.apps.console.c.d("ClientHandler", "V8 inspector opened");
                        a.this.bSB = (com.baidu.swan.games.f.a) com.baidu.swan.apps.core.turbo.d.abl().abB().TR();
                        if (a.this.bSA != null) {
                            a.this.bSA.destroy();
                        }
                        a.this.bSA = a.this.bSB.initInspector(new C0328a());
                        int unused = a.bSD = 1;
                    }

                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0330a
                    public void onClose() {
                        com.baidu.swan.apps.console.c.d("ClientHandler", "V8 inspector closed");
                        a.this.close();
                    }

                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0330a
                    public void a(WebSocketFrame webSocketFrame) {
                        a.this.bSz.offer(webSocketFrame.WM());
                        a.this.bSB.postOnJSThread(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.a.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                String str = (String) a.this.bSz.poll();
                                while (str != null) {
                                    a.this.bSA.dispatchProtocolMessage(str);
                                    iU(str);
                                    str = (String) a.this.bSz.poll();
                                }
                            }
                        });
                    }

                    @Override // com.baidu.swan.apps.console.v8inspector.websocket.a.InterfaceC0330a
                    public void onException(IOException iOException) {
                        com.baidu.swan.apps.console.c.e("ClientHandler", "V8 inspector exception", iOException);
                        a.this.close();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void iU(String str) {
                        if (!TextUtils.isEmpty(str) && a.this.bSC != null && a.bSD != 2) {
                            try {
                                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                                    com.baidu.swan.apps.runtime.d aoB = com.baidu.swan.apps.runtime.d.aoB();
                                    SwanAppActivity aoz = com.baidu.swan.apps.runtime.d.aoB().aoz();
                                    if (aoB.ane() && aoz != null) {
                                        aoz.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.a.1.2
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                a.this.bSC.onConnected();
                                                a.this.bSC = null;
                                                int unused = a.bSD = 2;
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
                this.bSy.d(this.mInputStream, this.mOutputStream);
            }
        } catch (RuntimeException e) {
            if (DEBUG) {
                Log.e("ClientHandler", "Request parse fail", e);
            }
        } finally {
            com.baidu.swan.e.d.closeSafely(this.mInputStream);
            com.baidu.swan.e.d.closeSafely(this.mOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close() {
        if (this.bSz != null) {
            this.bSz.clear();
            this.bSz = null;
        }
        if (this.bSA != null) {
            this.bSA.destroy();
            this.bSA = null;
        }
        if (this.mInputStream != null) {
            com.baidu.swan.e.d.closeSafely(this.mInputStream);
            this.mInputStream = null;
        }
        if (this.mOutputStream != null) {
            com.baidu.swan.e.d.closeSafely(this.mOutputStream);
            this.mOutputStream = null;
        }
        this.bSy = null;
        this.bSB = null;
        bSD = 3;
    }

    private static String iT(String str) {
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
                aVar.uri = iT(stringTokenizer.nextToken());
                if (stringTokenizer.hasMoreTokens()) {
                    aVar.bSN = stringTokenizer.nextToken();
                } else {
                    aVar.bSN = "HTTP/1.1";
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
    public class C0328a extends InspectorNativeChannel {
        public C0328a() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                a.this.bSy.e(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, str));
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
                return (String) a.this.bSz.take();
            } catch (InterruptedException e) {
                if (a.DEBUG) {
                    Log.e("ClientHandler", "awaitMessage on Debugger", e);
                }
                return "";
            }
        }
    }
}
