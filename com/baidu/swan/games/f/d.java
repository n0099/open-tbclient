package com.baidu.swan.games.f;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.an.j;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class d {
    private com.baidu.swan.games.e.a arN;
    private e bbQ;

    public d(com.baidu.swan.games.e.a aVar) {
        this.arN = aVar;
        Oh();
    }

    private void Oh() {
        g.aX(g.getBasePath(), g.Oi());
        this.bbQ = new e(AppRuntime.getAppContext(), this.arN == null ? "" : this.arN.getUrl());
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        if (g.a(this.bbQ, this.arN, (JsObject) null, (String) null)) {
            g.a(this.arN, this.bbQ.b(str, false, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (g.a(this.bbQ, this.arN, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int b = g.b("dirPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbQ, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a != null) {
                final String f = g.f("dirPath", a);
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b2 = d.this.bbQ.b(f, false, false);
                        d.this.arN.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "dirPath");
                                if (g.a(g.a(b2, "mkdir:", a), bVar, hashMap, d.this.arN)) {
                                    bVar.errMsg = "mkdir:" + b2.errMsg;
                                    g.b(bVar, a);
                                }
                            }
                        });
                    }
                }, "aigamesmkdir:");
            }
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        if (g.a(this.bbQ, this.arN, (JsObject) null, (String) null)) {
            g.a(this.arN, this.bbQ.a(true, str, (Object) str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2) {
        writeFileSync(str, str2, "");
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        if (g.a(this.bbQ, this.arN, (JsObject) null, (String) null)) {
            g.a(this.arN, this.bbQ.a(true, str, (Object) (jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer()), (String) null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        writeFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (g.a(this.bbQ, this.arN, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int b = g.b("filePath", jsObject);
            final String eF = g.eF(g.b("data", jsObject));
            final int b2 = g.b("encoding", jsObject);
            final byte[] e = g.e(jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbQ, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a != null) {
                final String f = g.f("data", a);
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.7
                    @Override // java.lang.Runnable
                    public void run() {
                        final c a2 = d.this.bbQ.a(false, g.f("filePath", a), TextUtils.isEmpty(f) ? e : f, g.f("encoding", a));
                        if (!TextUtils.isEmpty(eF)) {
                            a2.errMsg = eF;
                            a2.errCode = -2;
                            g.a(d.this.arN, eF);
                        } else if (b2 != 7 && b2 != 12) {
                            a2.errMsg = "fail encoding must be a string";
                            a2.errCode = -2;
                            g.a(d.this.arN, a2.errMsg);
                        }
                        d.this.arN.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "filePath");
                                if (g.a(g.a(a2, "writeFile:", a), bVar, hashMap, d.this.arN)) {
                                    bVar.errMsg = "writeFile:" + a2.errMsg;
                                    g.b(bVar, a);
                                }
                            }
                        });
                    }
                }, "aigameswriteFile:");
            }
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        if (g.a(this.bbQ, this.arN, (JsObject) null, (String) null)) {
            g.a(this.arN, this.bbQ.y(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (g.a(this.bbQ, this.arN, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int b = g.b("filePath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbQ, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.8
                    @Override // java.lang.Runnable
                    public void run() {
                        final c y = d.this.bbQ.y(g.f("filePath", a), false);
                        d.this.arN.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "filePath");
                                if (g.a(g.a(y, "unlink:", a), bVar, hashMap, d.this.arN)) {
                                    bVar.errMsg = "unlink:" + y.errMsg;
                                    g.b(bVar, a);
                                }
                            }
                        });
                    }
                }, "aigamesunlink:");
            }
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        if (g.a(this.bbQ, this.arN, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("zipFilePath", jsObject);
            final int b2 = g.b("targetPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbQ, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.9
                    @Override // java.lang.Runnable
                    public void run() {
                        final c aV = d.this.bbQ.aV(g.f("zipFilePath", a), g.f("targetPath", a));
                        d.this.arN.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "zipFilePath");
                                hashMap.put(Integer.valueOf(b2), "targetPath");
                                if (g.a(g.a(aV, "unzip:", a), bVar, hashMap, d.this.arN)) {
                                    bVar.errMsg = "unzip:" + aV.errMsg;
                                    g.b(bVar, a);
                                }
                            }
                        });
                    }
                }, "aigamesunzip:");
            }
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        return saveFileSync(str, a.USER_DATA_PATH);
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        if (g.a(this.bbQ, this.arN, (JsObject) null, (String) null)) {
            c k = this.bbQ.k(str, str2, true);
            g.a(this.arN, k, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (k == null || k.errCode != 0 || k.bbO == null) {
                return null;
            }
            return k.bbO.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (g.a(this.bbQ, this.arN, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("tempFilePath", jsObject);
            final int b2 = g.b("filePath", jsObject);
            if (b2 == 12) {
                b2 = 7;
            }
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbQ, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.10
                    @Override // java.lang.Runnable
                    public void run() {
                        final c k = d.this.bbQ.k(g.f("tempFilePath", a), g.f("filePath", a), false);
                        d.this.arN.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "tempFilePath");
                                hashMap.put(Integer.valueOf(b2), "filePath");
                                if (g.a(g.a(k, "saveFile:", a), bVar, hashMap, d.this.arN)) {
                                    com.baidu.swan.games.f.a.f fVar = new com.baidu.swan.games.f.a.f();
                                    fVar.savedFilePath = k.bbO != null ? k.bbO.get(0) : null;
                                    g.b(fVar, a);
                                }
                            }
                        });
                    }
                }, "aigamessaveFile:");
            }
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        if (g.a(this.bbQ, this.arN, (JsObject) null, (String) null)) {
            c z = this.bbQ.z(str, true);
            g.a(this.arN, z, JSExceptionType.Error, "unknown error", "readdirSync:");
            if (z != null && z.errCode == 0) {
                int size = z.bbO == null ? 0 : z.bbO.size();
                return size == 0 ? new String[0] : (String[]) z.bbO.toArray(new String[size]);
            }
            return new String[0];
        }
        return null;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        if (g.a(this.bbQ, this.arN, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int b = g.b("dirPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbQ, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.11
                    @Override // java.lang.Runnable
                    public void run() {
                        final c z = d.this.bbQ.z(g.f("dirPath", a), false);
                        d.this.arN.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "dirPath");
                                if (g.a(g.a(z, "readdir:", a), bVar, hashMap, d.this.arN)) {
                                    com.baidu.swan.games.f.a.d dVar = new com.baidu.swan.games.f.a.d();
                                    int size = z.bbO == null ? 0 : z.bbO.size();
                                    dVar.files = size == 0 ? new String[0] : (String[]) z.bbO.toArray(new String[size]);
                                    g.b(dVar, a);
                                }
                            }
                        });
                    }
                }, "aigamesreaddir:");
            }
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str) {
        if (g.a(this.bbQ, this.arN, (JsObject) null, (String) null)) {
            g.a(this.arN, this.bbQ.c(str, false, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (g.a(this.bbQ, this.arN, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int b = g.b("dirPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbQ, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.12
                    @Override // java.lang.Runnable
                    public void run() {
                        final c c = d.this.bbQ.c(g.f("dirPath", a), false, false);
                        d.this.arN.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "dirPath");
                                if (g.a(g.a(c, "rmdir:", a), bVar, hashMap, d.this.arN)) {
                                    g.b(bVar, a);
                                }
                            }
                        });
                    }
                }, "aigamesrmdir:");
            }
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        if (g.a(this.bbQ, this.arN, (JsObject) null, (String) null)) {
            c l = this.bbQ.l(str, str2, true);
            g.a(this.arN, l, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (l == null || l.errCode != 0 || l.bbO == null) {
                return null;
            }
            return l.bbO.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (g.a(this.bbQ, this.arN, (JsObject) null, (String) null)) {
            c l = this.bbQ.l(str, null, true);
            g.a(this.arN, l, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (l.bbP == null) {
                l.bbP = new byte[0];
            }
            return new JsArrayBuffer(l.bbP, l.bbP.length);
        }
        return null;
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (g.a(this.bbQ, this.arN, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int b = g.b("filePath", jsObject);
            final int b2 = g.b("encoding", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbQ, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a != null) {
                final String f = g.f("encoding", a);
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.13
                    @Override // java.lang.Runnable
                    public void run() {
                        final c l = d.this.bbQ.l(g.f("filePath", a), f, false);
                        if (b2 != 7 && b2 != 12) {
                            l.errMsg = "fail encoding must be a string";
                            l.errCode = -2;
                            g.a(d.this.arN, l.errMsg);
                        }
                        d.this.arN.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "filePath");
                                if (g.a(g.a(l, "readFile:", a), bVar, hashMap, d.this.arN)) {
                                    if (TextUtils.isEmpty(f)) {
                                        com.baidu.swan.games.f.a.a aVar = new com.baidu.swan.games.f.a.a();
                                        if (l.bbP == null) {
                                            l.bbP = new byte[0];
                                        }
                                        aVar.data = new JsArrayBuffer(l.bbP, l.bbP.length);
                                        g.b(aVar, a);
                                        return;
                                    }
                                    String str = l.bbO != null ? l.bbO.get(0) : null;
                                    com.baidu.swan.games.f.a.e eVar = new com.baidu.swan.games.f.a.e();
                                    eVar.data = str;
                                    g.b(eVar, a);
                                }
                            }
                        });
                    }
                }, "aigamesreadFile:");
            }
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        if (g.a(this.bbQ, this.arN, (JsObject) null, (String) null)) {
            g.a(this.arN, this.bbQ.m(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (g.a(this.bbQ, this.arN, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("oldPath", jsObject);
            final int b2 = g.b("newPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbQ, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.14
                    @Override // java.lang.Runnable
                    public void run() {
                        final c m = d.this.bbQ.m(g.f("oldPath", a), g.f("newPath", a), false);
                        d.this.arN.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "oldPath");
                                hashMap.put(Integer.valueOf(b2), "newPath");
                                if (g.a(g.a(m, "rename:", a), bVar, hashMap, d.this.arN)) {
                                    g.b(bVar, a);
                                }
                            }
                        });
                    }
                }, "aigamesrename:");
            }
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        if (g.a(this.bbQ, this.arN, (JsObject) null, (String) null)) {
            g.a(this.arN, this.bbQ.n(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (g.a(this.bbQ, this.arN, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("srcPath", jsObject);
            final int b2 = g.b("destPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbQ, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        final c n = d.this.bbQ.n(g.f("srcPath", a), g.f("destPath", a), false);
                        d.this.arN.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "srcPath");
                                hashMap.put(Integer.valueOf(b2), "destPath");
                                if (g.a(g.a(n, "copyFile:", a), bVar, hashMap, d.this.arN)) {
                                    g.b(bVar, a);
                                }
                            }
                        });
                    }
                }, "aigamescopyFile:");
            }
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        if (g.a(this.bbQ, this.arN, (JsObject) null, (String) null)) {
            g.a(this.arN, this.bbQ.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2) {
        appendFileSync(str, str2, (String) null);
    }

    @JavascriptInterface
    public void appendFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        appendFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
    }

    @JavascriptInterface
    public void appendFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        appendFileSync(str, jsArrayBuffer, (String) null);
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        if (g.a(this.bbQ, this.arN, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int b = g.b("encoding", jsObject);
            final int b2 = g.b("filePath", jsObject);
            int b3 = g.b("data", jsObject);
            final String eF = (b3 == 5 || b3 == 2 || b3 == 3) ? "fail data argument must not be a number" : g.eF(b3);
            final byte[] e = g.e(jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbQ, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a != null) {
                final String f = g.f("data", a);
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.3
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b4 = d.this.bbQ.b(g.f("filePath", a), TextUtils.isEmpty(f) ? e : f, g.f("encoding", a), false);
                        if (!TextUtils.isEmpty(eF)) {
                            b4.errMsg = eF;
                            b4.errCode = -2;
                            g.a(d.this.arN, eF);
                        } else if (b != 7 && b != 12) {
                            b4.errMsg = "fail encoding must be a string";
                            b4.errCode = -2;
                            g.a(d.this.arN, b4.errMsg);
                        }
                        d.this.arN.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b2), "filePath");
                                if (g.a(g.a(b4, "appendFile:", a), bVar, hashMap, d.this.arN)) {
                                    g.b(bVar, a);
                                }
                            }
                        });
                    }
                }, "aigamesappendFile:");
            }
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        if (g.a(this.bbQ, this.arN, (JsObject) null, (String) null)) {
            g.a(this.arN, this.bbQ.A(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (g.a(this.bbQ, this.arN, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("path", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbQ, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.4
                    @Override // java.lang.Runnable
                    public void run() {
                        final c A = d.this.bbQ.A(g.f("path", a), false);
                        d.this.arN.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "path");
                                if (g.a(g.a(A, "access:", a), bVar, hashMap, d.this.arN)) {
                                    g.b(bVar, a);
                                }
                            }
                        });
                    }
                }, "aigamesaccess:");
            }
        }
    }

    @JavascriptInterface
    public f statSync(String str) {
        if (g.a(this.bbQ, this.arN, (JsObject) null, (String) null)) {
            c B = this.bbQ.B(str, true);
            g.a(this.arN, B, JSExceptionType.Error, "unknown error", "statSync:");
            if (B == null || B.errCode != 0) {
                return null;
            }
            return B.stats;
        }
        return null;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (g.a(this.bbQ, this.arN, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("path", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbQ, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.5
                    @Override // java.lang.Runnable
                    public void run() {
                        final c B = d.this.bbQ.B(g.f("path", a), false);
                        d.this.arN.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "path");
                                if (g.a(g.a(B, "stat:", a), bVar, hashMap, d.this.arN)) {
                                    com.baidu.swan.games.f.a.g gVar = new com.baidu.swan.games.f.a.g();
                                    gVar.stats = B.stats;
                                    g.b(gVar, a);
                                }
                            }
                        });
                    }
                }, "aigamesstat:");
            }
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        if (g.a(this.bbQ, this.arN, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int b = g.b("filePath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbQ, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final c it = d.this.bbQ.it(g.f("filePath", a));
                        d.this.arN.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "filePath");
                                if (g.a(g.a(it, "getFileInfo:", a), bVar, hashMap, d.this.arN)) {
                                    com.baidu.swan.games.f.a.c cVar = new com.baidu.swan.games.f.a.c();
                                    cVar.errMsg = "getFileInfo:" + it.errMsg;
                                    cVar.digest = it.digest;
                                    cVar.size = (int) it.size;
                                    g.b(cVar, a);
                                }
                            }
                        });
                    }
                }, "aigamesgetFileInfo:");
            }
        }
    }
}
