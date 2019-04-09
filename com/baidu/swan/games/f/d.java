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
    private com.baidu.swan.games.e.a arS;
    private e bbU;

    public d(com.baidu.swan.games.e.a aVar) {
        this.arS = aVar;
        Of();
    }

    private void Of() {
        g.aX(g.getBasePath(), g.Og());
        this.bbU = new e(AppRuntime.getAppContext(), this.arS == null ? "" : this.arS.getUrl());
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        if (g.a(this.bbU, this.arS, (JsObject) null, (String) null)) {
            g.a(this.arS, this.bbU.b(str, false, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (g.a(this.bbU, this.arS, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int b = g.b("dirPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbU, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a != null) {
                final String f = g.f("dirPath", a);
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b2 = d.this.bbU.b(f, false, false);
                        d.this.arS.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "dirPath");
                                if (g.a(g.a(b2, "mkdir:", a), bVar, hashMap, d.this.arS)) {
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
        if (g.a(this.bbU, this.arS, (JsObject) null, (String) null)) {
            g.a(this.arS, this.bbU.a(true, str, (Object) str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2) {
        writeFileSync(str, str2, "");
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        if (g.a(this.bbU, this.arS, (JsObject) null, (String) null)) {
            g.a(this.arS, this.bbU.a(true, str, (Object) (jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer()), (String) null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        writeFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (g.a(this.bbU, this.arS, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int b = g.b("filePath", jsObject);
            final String eE = g.eE(g.b("data", jsObject));
            final int b2 = g.b("encoding", jsObject);
            final byte[] e = g.e(jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbU, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a != null) {
                final String f = g.f("data", a);
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.7
                    @Override // java.lang.Runnable
                    public void run() {
                        final c a2 = d.this.bbU.a(false, g.f("filePath", a), TextUtils.isEmpty(f) ? e : f, g.f("encoding", a));
                        if (!TextUtils.isEmpty(eE)) {
                            a2.errMsg = eE;
                            a2.errCode = -2;
                            g.a(d.this.arS, eE);
                        } else if (b2 != 7 && b2 != 12) {
                            a2.errMsg = "fail encoding must be a string";
                            a2.errCode = -2;
                            g.a(d.this.arS, a2.errMsg);
                        }
                        d.this.arS.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "filePath");
                                if (g.a(g.a(a2, "writeFile:", a), bVar, hashMap, d.this.arS)) {
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
        if (g.a(this.bbU, this.arS, (JsObject) null, (String) null)) {
            g.a(this.arS, this.bbU.y(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (g.a(this.bbU, this.arS, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int b = g.b("filePath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbU, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.8
                    @Override // java.lang.Runnable
                    public void run() {
                        final c y = d.this.bbU.y(g.f("filePath", a), false);
                        d.this.arS.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "filePath");
                                if (g.a(g.a(y, "unlink:", a), bVar, hashMap, d.this.arS)) {
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
        if (g.a(this.bbU, this.arS, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("zipFilePath", jsObject);
            final int b2 = g.b("targetPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbU, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.9
                    @Override // java.lang.Runnable
                    public void run() {
                        final c aV = d.this.bbU.aV(g.f("zipFilePath", a), g.f("targetPath", a));
                        d.this.arS.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "zipFilePath");
                                hashMap.put(Integer.valueOf(b2), "targetPath");
                                if (g.a(g.a(aV, "unzip:", a), bVar, hashMap, d.this.arS)) {
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
        if (g.a(this.bbU, this.arS, (JsObject) null, (String) null)) {
            c k = this.bbU.k(str, str2, true);
            g.a(this.arS, k, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (k == null || k.errCode != 0 || k.bbS == null) {
                return null;
            }
            return k.bbS.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (g.a(this.bbU, this.arS, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("tempFilePath", jsObject);
            final int b2 = g.b("filePath", jsObject);
            if (b2 == 12) {
                b2 = 7;
            }
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbU, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.10
                    @Override // java.lang.Runnable
                    public void run() {
                        final c k = d.this.bbU.k(g.f("tempFilePath", a), g.f("filePath", a), false);
                        d.this.arS.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "tempFilePath");
                                hashMap.put(Integer.valueOf(b2), "filePath");
                                if (g.a(g.a(k, "saveFile:", a), bVar, hashMap, d.this.arS)) {
                                    com.baidu.swan.games.f.a.f fVar = new com.baidu.swan.games.f.a.f();
                                    fVar.savedFilePath = k.bbS != null ? k.bbS.get(0) : null;
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
        if (g.a(this.bbU, this.arS, (JsObject) null, (String) null)) {
            c z = this.bbU.z(str, true);
            g.a(this.arS, z, JSExceptionType.Error, "unknown error", "readdirSync:");
            if (z != null && z.errCode == 0) {
                int size = z.bbS == null ? 0 : z.bbS.size();
                return size == 0 ? new String[0] : (String[]) z.bbS.toArray(new String[size]);
            }
            return new String[0];
        }
        return null;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        if (g.a(this.bbU, this.arS, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int b = g.b("dirPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbU, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.11
                    @Override // java.lang.Runnable
                    public void run() {
                        final c z = d.this.bbU.z(g.f("dirPath", a), false);
                        d.this.arS.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "dirPath");
                                if (g.a(g.a(z, "readdir:", a), bVar, hashMap, d.this.arS)) {
                                    com.baidu.swan.games.f.a.d dVar = new com.baidu.swan.games.f.a.d();
                                    int size = z.bbS == null ? 0 : z.bbS.size();
                                    dVar.files = size == 0 ? new String[0] : (String[]) z.bbS.toArray(new String[size]);
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
        if (g.a(this.bbU, this.arS, (JsObject) null, (String) null)) {
            g.a(this.arS, this.bbU.c(str, false, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (g.a(this.bbU, this.arS, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int b = g.b("dirPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbU, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.12
                    @Override // java.lang.Runnable
                    public void run() {
                        final c c = d.this.bbU.c(g.f("dirPath", a), false, false);
                        d.this.arS.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "dirPath");
                                if (g.a(g.a(c, "rmdir:", a), bVar, hashMap, d.this.arS)) {
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
        if (g.a(this.bbU, this.arS, (JsObject) null, (String) null)) {
            c l = this.bbU.l(str, str2, true);
            g.a(this.arS, l, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (l == null || l.errCode != 0 || l.bbS == null) {
                return null;
            }
            return l.bbS.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (g.a(this.bbU, this.arS, (JsObject) null, (String) null)) {
            c l = this.bbU.l(str, null, true);
            g.a(this.arS, l, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (l.bbT == null) {
                l.bbT = new byte[0];
            }
            return new JsArrayBuffer(l.bbT, l.bbT.length);
        }
        return null;
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (g.a(this.bbU, this.arS, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int b = g.b("filePath", jsObject);
            final int b2 = g.b("encoding", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbU, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a != null) {
                final String f = g.f("encoding", a);
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.13
                    @Override // java.lang.Runnable
                    public void run() {
                        final c l = d.this.bbU.l(g.f("filePath", a), f, false);
                        if (b2 != 7 && b2 != 12) {
                            l.errMsg = "fail encoding must be a string";
                            l.errCode = -2;
                            g.a(d.this.arS, l.errMsg);
                        }
                        d.this.arS.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "filePath");
                                if (g.a(g.a(l, "readFile:", a), bVar, hashMap, d.this.arS)) {
                                    if (TextUtils.isEmpty(f)) {
                                        com.baidu.swan.games.f.a.a aVar = new com.baidu.swan.games.f.a.a();
                                        if (l.bbT == null) {
                                            l.bbT = new byte[0];
                                        }
                                        aVar.data = new JsArrayBuffer(l.bbT, l.bbT.length);
                                        g.b(aVar, a);
                                        return;
                                    }
                                    String str = l.bbS != null ? l.bbS.get(0) : null;
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
        if (g.a(this.bbU, this.arS, (JsObject) null, (String) null)) {
            g.a(this.arS, this.bbU.m(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (g.a(this.bbU, this.arS, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("oldPath", jsObject);
            final int b2 = g.b("newPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbU, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.14
                    @Override // java.lang.Runnable
                    public void run() {
                        final c m = d.this.bbU.m(g.f("oldPath", a), g.f("newPath", a), false);
                        d.this.arS.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "oldPath");
                                hashMap.put(Integer.valueOf(b2), "newPath");
                                if (g.a(g.a(m, "rename:", a), bVar, hashMap, d.this.arS)) {
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
        if (g.a(this.bbU, this.arS, (JsObject) null, (String) null)) {
            g.a(this.arS, this.bbU.n(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (g.a(this.bbU, this.arS, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("srcPath", jsObject);
            final int b2 = g.b("destPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbU, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        final c n = d.this.bbU.n(g.f("srcPath", a), g.f("destPath", a), false);
                        d.this.arS.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "srcPath");
                                hashMap.put(Integer.valueOf(b2), "destPath");
                                if (g.a(g.a(n, "copyFile:", a), bVar, hashMap, d.this.arS)) {
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
        if (g.a(this.bbU, this.arS, (JsObject) null, (String) null)) {
            g.a(this.arS, this.bbU.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
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
        if (g.a(this.bbU, this.arS, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int b = g.b("encoding", jsObject);
            final int b2 = g.b("filePath", jsObject);
            int b3 = g.b("data", jsObject);
            final String eE = (b3 == 5 || b3 == 2 || b3 == 3) ? "fail data argument must not be a number" : g.eE(b3);
            final byte[] e = g.e(jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbU, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a != null) {
                final String f = g.f("data", a);
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.3
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b4 = d.this.bbU.b(g.f("filePath", a), TextUtils.isEmpty(f) ? e : f, g.f("encoding", a), false);
                        if (!TextUtils.isEmpty(eE)) {
                            b4.errMsg = eE;
                            b4.errCode = -2;
                            g.a(d.this.arS, eE);
                        } else if (b != 7 && b != 12) {
                            b4.errMsg = "fail encoding must be a string";
                            b4.errCode = -2;
                            g.a(d.this.arS, b4.errMsg);
                        }
                        d.this.arS.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b2), "filePath");
                                if (g.a(g.a(b4, "appendFile:", a), bVar, hashMap, d.this.arS)) {
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
        if (g.a(this.bbU, this.arS, (JsObject) null, (String) null)) {
            g.a(this.arS, this.bbU.A(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (g.a(this.bbU, this.arS, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("path", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbU, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.4
                    @Override // java.lang.Runnable
                    public void run() {
                        final c A = d.this.bbU.A(g.f("path", a), false);
                        d.this.arS.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "path");
                                if (g.a(g.a(A, "access:", a), bVar, hashMap, d.this.arS)) {
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
        if (g.a(this.bbU, this.arS, (JsObject) null, (String) null)) {
            c B = this.bbU.B(str, true);
            g.a(this.arS, B, JSExceptionType.Error, "unknown error", "statSync:");
            if (B == null || B.errCode != 0) {
                return null;
            }
            return B.stats;
        }
        return null;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (g.a(this.bbU, this.arS, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("path", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbU, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.5
                    @Override // java.lang.Runnable
                    public void run() {
                        final c B = d.this.bbU.B(g.f("path", a), false);
                        d.this.arS.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "path");
                                if (g.a(g.a(B, "stat:", a), bVar, hashMap, d.this.arS)) {
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
        if (g.a(this.bbU, this.arS, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int b = g.b("filePath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bbU, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final c iu = d.this.bbU.iu(g.f("filePath", a));
                        d.this.arS.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "filePath");
                                if (g.a(g.a(iu, "getFileInfo:", a), bVar, hashMap, d.this.arS)) {
                                    com.baidu.swan.games.f.a.c cVar = new com.baidu.swan.games.f.a.c();
                                    cVar.errMsg = "getFileInfo:" + iu.errMsg;
                                    cVar.digest = iu.digest;
                                    cVar.size = (int) iu.size;
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
