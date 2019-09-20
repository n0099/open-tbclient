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
    private com.baidu.swan.games.e.a asZ;
    private e bhg;

    public d(com.baidu.swan.games.e.a aVar) {
        this.asZ = aVar;
        RX();
    }

    private void RX() {
        g.ba(g.getBasePath(), g.RY());
        this.bhg = new e(AppRuntime.getAppContext(), this.asZ == null ? "" : this.asZ.getUrl());
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        if (g.a(this.bhg, this.asZ, (JsObject) null, (String) null)) {
            g.a(this.asZ, this.bhg.b(str, false, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (g.a(this.bhg, this.asZ, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int b = g.b("dirPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bhg, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a != null) {
                final String e = g.e("dirPath", a);
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b2 = d.this.bhg.b(e, false, false);
                        d.this.asZ.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "dirPath");
                                if (g.a(g.a(b2, "mkdir:", a), bVar, hashMap, d.this.asZ)) {
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
        if (g.a(this.bhg, this.asZ, (JsObject) null, (String) null)) {
            g.a(this.asZ, this.bhg.a(true, str, (Object) str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2) {
        writeFileSync(str, str2, "");
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        if (g.a(this.bhg, this.asZ, (JsObject) null, (String) null)) {
            g.a(this.asZ, this.bhg.a(true, str, (Object) (jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer()), (String) null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        writeFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (g.a(this.bhg, this.asZ, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int b = g.b("filePath", jsObject);
            final String eZ = g.eZ(g.b("data", jsObject));
            final int b2 = g.b("encoding", jsObject);
            final byte[] f = g.f(jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bhg, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a != null) {
                final String e = g.e("data", a);
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.7
                    @Override // java.lang.Runnable
                    public void run() {
                        final c a2 = d.this.bhg.a(false, g.e("filePath", a), TextUtils.isEmpty(e) ? f : e, g.e("encoding", a));
                        if (!TextUtils.isEmpty(eZ)) {
                            a2.errMsg = eZ;
                            a2.errCode = -2;
                            g.a(d.this.asZ, eZ);
                        } else if (b2 != 7 && b2 != 12) {
                            a2.errMsg = "fail encoding must be a string";
                            a2.errCode = -2;
                            g.a(d.this.asZ, a2.errMsg);
                        }
                        d.this.asZ.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "filePath");
                                if (g.a(g.a(a2, "writeFile:", a), bVar, hashMap, d.this.asZ)) {
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
        if (g.a(this.bhg, this.asZ, (JsObject) null, (String) null)) {
            g.a(this.asZ, this.bhg.B(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (g.a(this.bhg, this.asZ, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int b = g.b("filePath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bhg, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.8
                    @Override // java.lang.Runnable
                    public void run() {
                        final c B = d.this.bhg.B(g.e("filePath", a), false);
                        d.this.asZ.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "filePath");
                                if (g.a(g.a(B, "unlink:", a), bVar, hashMap, d.this.asZ)) {
                                    bVar.errMsg = "unlink:" + B.errMsg;
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
        if (g.a(this.bhg, this.asZ, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("zipFilePath", jsObject);
            final int b2 = g.b("targetPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bhg, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.9
                    @Override // java.lang.Runnable
                    public void run() {
                        final c aY = d.this.bhg.aY(g.e("zipFilePath", a), g.e("targetPath", a));
                        d.this.asZ.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "zipFilePath");
                                hashMap.put(Integer.valueOf(b2), "targetPath");
                                if (g.a(g.a(aY, "unzip:", a), bVar, hashMap, d.this.asZ)) {
                                    bVar.errMsg = "unzip:" + aY.errMsg;
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
        if (g.a(this.bhg, this.asZ, (JsObject) null, (String) null)) {
            c l = this.bhg.l(str, str2, true);
            g.a(this.asZ, l, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (l == null || l.errCode != 0 || l.bhe == null) {
                return null;
            }
            return l.bhe.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (g.a(this.bhg, this.asZ, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("tempFilePath", jsObject);
            final int b2 = g.b("filePath", jsObject);
            if (b2 == 12) {
                b2 = 7;
            }
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bhg, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.10
                    @Override // java.lang.Runnable
                    public void run() {
                        final c l = d.this.bhg.l(g.e("tempFilePath", a), g.e("filePath", a), false);
                        d.this.asZ.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "tempFilePath");
                                hashMap.put(Integer.valueOf(b2), "filePath");
                                if (g.a(g.a(l, "saveFile:", a), bVar, hashMap, d.this.asZ)) {
                                    com.baidu.swan.games.f.a.f fVar = new com.baidu.swan.games.f.a.f();
                                    fVar.savedFilePath = l.bhe != null ? l.bhe.get(0) : null;
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
        if (g.a(this.bhg, this.asZ, (JsObject) null, (String) null)) {
            c C = this.bhg.C(str, true);
            g.a(this.asZ, C, JSExceptionType.Error, "unknown error", "readdirSync:");
            if (C != null && C.errCode == 0) {
                int size = C.bhe == null ? 0 : C.bhe.size();
                return size == 0 ? new String[0] : (String[]) C.bhe.toArray(new String[size]);
            }
            return new String[0];
        }
        return null;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        if (g.a(this.bhg, this.asZ, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int b = g.b("dirPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bhg, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.11
                    @Override // java.lang.Runnable
                    public void run() {
                        final c C = d.this.bhg.C(g.e("dirPath", a), false);
                        d.this.asZ.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "dirPath");
                                if (g.a(g.a(C, "readdir:", a), bVar, hashMap, d.this.asZ)) {
                                    com.baidu.swan.games.f.a.d dVar = new com.baidu.swan.games.f.a.d();
                                    int size = C.bhe == null ? 0 : C.bhe.size();
                                    dVar.files = size == 0 ? new String[0] : (String[]) C.bhe.toArray(new String[size]);
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
        if (g.a(this.bhg, this.asZ, (JsObject) null, (String) null)) {
            g.a(this.asZ, this.bhg.c(str, false, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (g.a(this.bhg, this.asZ, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int b = g.b("dirPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bhg, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.12
                    @Override // java.lang.Runnable
                    public void run() {
                        final c c = d.this.bhg.c(g.e("dirPath", a), false, false);
                        d.this.asZ.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "dirPath");
                                if (g.a(g.a(c, "rmdir:", a), bVar, hashMap, d.this.asZ)) {
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
        if (g.a(this.bhg, this.asZ, (JsObject) null, (String) null)) {
            c m = this.bhg.m(str, str2, true);
            g.a(this.asZ, m, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (m == null || m.errCode != 0 || m.bhe == null) {
                return null;
            }
            return m.bhe.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (g.a(this.bhg, this.asZ, (JsObject) null, (String) null)) {
            c m = this.bhg.m(str, null, true);
            g.a(this.asZ, m, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (m.bhf == null) {
                m.bhf = new byte[0];
            }
            return new JsArrayBuffer(m.bhf, m.bhf.length);
        }
        return null;
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (g.a(this.bhg, this.asZ, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int b = g.b("filePath", jsObject);
            final int b2 = g.b("encoding", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bhg, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a != null) {
                final String e = g.e("encoding", a);
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.13
                    @Override // java.lang.Runnable
                    public void run() {
                        final c m = d.this.bhg.m(g.e("filePath", a), e, false);
                        if (b2 != 7 && b2 != 12) {
                            m.errMsg = "fail encoding must be a string";
                            m.errCode = -2;
                            g.a(d.this.asZ, m.errMsg);
                        }
                        d.this.asZ.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "filePath");
                                if (g.a(g.a(m, "readFile:", a), bVar, hashMap, d.this.asZ)) {
                                    if (TextUtils.isEmpty(e)) {
                                        com.baidu.swan.games.f.a.a aVar = new com.baidu.swan.games.f.a.a();
                                        if (m.bhf == null) {
                                            m.bhf = new byte[0];
                                        }
                                        aVar.data = new JsArrayBuffer(m.bhf, m.bhf.length);
                                        g.b(aVar, a);
                                        return;
                                    }
                                    String str = m.bhe != null ? m.bhe.get(0) : null;
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
        if (g.a(this.bhg, this.asZ, (JsObject) null, (String) null)) {
            g.a(this.asZ, this.bhg.n(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (g.a(this.bhg, this.asZ, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("oldPath", jsObject);
            final int b2 = g.b("newPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bhg, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.14
                    @Override // java.lang.Runnable
                    public void run() {
                        final c n = d.this.bhg.n(g.e("oldPath", a), g.e("newPath", a), false);
                        d.this.asZ.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "oldPath");
                                hashMap.put(Integer.valueOf(b2), "newPath");
                                if (g.a(g.a(n, "rename:", a), bVar, hashMap, d.this.asZ)) {
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
        if (g.a(this.bhg, this.asZ, (JsObject) null, (String) null)) {
            g.a(this.asZ, this.bhg.o(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (g.a(this.bhg, this.asZ, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("srcPath", jsObject);
            final int b2 = g.b("destPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bhg, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        final c o = d.this.bhg.o(g.e("srcPath", a), g.e("destPath", a), false);
                        d.this.asZ.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "srcPath");
                                hashMap.put(Integer.valueOf(b2), "destPath");
                                if (g.a(g.a(o, "copyFile:", a), bVar, hashMap, d.this.asZ)) {
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
        if (g.a(this.bhg, this.asZ, (JsObject) null, (String) null)) {
            g.a(this.asZ, this.bhg.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
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
        if (g.a(this.bhg, this.asZ, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int b = g.b("encoding", jsObject);
            final int b2 = g.b("filePath", jsObject);
            int b3 = g.b("data", jsObject);
            final String eZ = (b3 == 5 || b3 == 2 || b3 == 3) ? "fail data argument must not be a number" : g.eZ(b3);
            final byte[] f = g.f(jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bhg, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a != null) {
                final String e = g.e("data", a);
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.3
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b4 = d.this.bhg.b(g.e("filePath", a), TextUtils.isEmpty(e) ? f : e, g.e("encoding", a), false);
                        if (!TextUtils.isEmpty(eZ)) {
                            b4.errMsg = eZ;
                            b4.errCode = -2;
                            g.a(d.this.asZ, eZ);
                        } else if (b != 7 && b != 12) {
                            b4.errMsg = "fail encoding must be a string";
                            b4.errCode = -2;
                            g.a(d.this.asZ, b4.errMsg);
                        }
                        d.this.asZ.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b2), "filePath");
                                if (g.a(g.a(b4, "appendFile:", a), bVar, hashMap, d.this.asZ)) {
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
        if (g.a(this.bhg, this.asZ, (JsObject) null, (String) null)) {
            g.a(this.asZ, this.bhg.D(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (g.a(this.bhg, this.asZ, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("path", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bhg, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.4
                    @Override // java.lang.Runnable
                    public void run() {
                        final c D = d.this.bhg.D(g.e("path", a), false);
                        d.this.asZ.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "path");
                                if (g.a(g.a(D, "access:", a), bVar, hashMap, d.this.asZ)) {
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
        if (g.a(this.bhg, this.asZ, (JsObject) null, (String) null)) {
            c E = this.bhg.E(str, true);
            g.a(this.asZ, E, JSExceptionType.Error, "unknown error", "statSync:");
            if (E == null || E.errCode != 0) {
                return null;
            }
            return E.stats;
        }
        return null;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (g.a(this.bhg, this.asZ, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("path", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bhg, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.5
                    @Override // java.lang.Runnable
                    public void run() {
                        final c E = d.this.bhg.E(g.e("path", a), false);
                        d.this.asZ.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "path");
                                if (g.a(g.a(E, "stat:", a), bVar, hashMap, d.this.asZ)) {
                                    com.baidu.swan.games.f.a.g gVar = new com.baidu.swan.games.f.a.g();
                                    gVar.stats = E.stats;
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
        if (g.a(this.bhg, this.asZ, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int b = g.b("filePath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bhg, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final c jm = d.this.bhg.jm(g.e("filePath", a));
                        d.this.asZ.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "filePath");
                                if (g.a(g.a(jm, "getFileInfo:", a), bVar, hashMap, d.this.asZ)) {
                                    com.baidu.swan.games.f.a.c cVar = new com.baidu.swan.games.f.a.c();
                                    cVar.errMsg = "getFileInfo:" + jm.errMsg;
                                    cVar.digest = jm.digest;
                                    cVar.size = (int) jm.size;
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
