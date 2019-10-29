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
    private com.baidu.swan.games.e.a aMq;
    private e bzX;

    public d(com.baidu.swan.games.e.a aVar) {
        this.aMq = aVar;
        WO();
    }

    private void WO() {
        g.bh(g.getBasePath(), g.WP());
        this.bzX = new e(AppRuntime.getAppContext(), this.aMq == null ? "" : this.aMq.getUrl());
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        if (g.a(this.bzX, this.aMq, (JsObject) null, (String) null)) {
            g.a(this.aMq, this.bzX.b(str, false, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (g.a(this.bzX, this.aMq, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int b = g.b("dirPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bzX, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a != null) {
                final String e = g.e("dirPath", a);
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b2 = d.this.bzX.b(e, false, false);
                        d.this.aMq.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "dirPath");
                                if (g.a(g.a(b2, "mkdir:", a), bVar, hashMap, d.this.aMq)) {
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
        if (g.a(this.bzX, this.aMq, (JsObject) null, (String) null)) {
            g.a(this.aMq, this.bzX.a(true, str, (Object) str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2) {
        writeFileSync(str, str2, "");
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        if (g.a(this.bzX, this.aMq, (JsObject) null, (String) null)) {
            g.a(this.aMq, this.bzX.a(true, str, (Object) (jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer()), (String) null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        writeFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (g.a(this.bzX, this.aMq, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int b = g.b("filePath", jsObject);
            final String fU = g.fU(g.b("data", jsObject));
            final int b2 = g.b("encoding", jsObject);
            final byte[] f = g.f(jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bzX, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a != null) {
                final String e = g.e("data", a);
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.7
                    @Override // java.lang.Runnable
                    public void run() {
                        final c a2 = d.this.bzX.a(false, g.e("filePath", a), TextUtils.isEmpty(e) ? f : e, g.e("encoding", a));
                        if (!TextUtils.isEmpty(fU)) {
                            a2.errMsg = fU;
                            a2.errCode = -2;
                            g.a(d.this.aMq, fU);
                        } else if (b2 != 7 && b2 != 12) {
                            a2.errMsg = "fail encoding must be a string";
                            a2.errCode = -2;
                            g.a(d.this.aMq, a2.errMsg);
                        }
                        d.this.aMq.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "filePath");
                                if (g.a(g.a(a2, "writeFile:", a), bVar, hashMap, d.this.aMq)) {
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
        if (g.a(this.bzX, this.aMq, (JsObject) null, (String) null)) {
            g.a(this.aMq, this.bzX.E(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (g.a(this.bzX, this.aMq, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int b = g.b("filePath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bzX, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.8
                    @Override // java.lang.Runnable
                    public void run() {
                        final c E = d.this.bzX.E(g.e("filePath", a), false);
                        d.this.aMq.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "filePath");
                                if (g.a(g.a(E, "unlink:", a), bVar, hashMap, d.this.aMq)) {
                                    bVar.errMsg = "unlink:" + E.errMsg;
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
        if (g.a(this.bzX, this.aMq, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("zipFilePath", jsObject);
            final int b2 = g.b("targetPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bzX, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.9
                    @Override // java.lang.Runnable
                    public void run() {
                        final c bf = d.this.bzX.bf(g.e("zipFilePath", a), g.e("targetPath", a));
                        d.this.aMq.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "zipFilePath");
                                hashMap.put(Integer.valueOf(b2), "targetPath");
                                if (g.a(g.a(bf, "unzip:", a), bVar, hashMap, d.this.aMq)) {
                                    bVar.errMsg = "unzip:" + bf.errMsg;
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
        if (g.a(this.bzX, this.aMq, (JsObject) null, (String) null)) {
            c o = this.bzX.o(str, str2, true);
            g.a(this.aMq, o, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (o == null || o.errCode != 0 || o.result == null) {
                return null;
            }
            return o.result.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (g.a(this.bzX, this.aMq, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("tempFilePath", jsObject);
            final int b2 = g.b("filePath", jsObject);
            if (b2 == 12) {
                b2 = 7;
            }
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bzX, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.10
                    @Override // java.lang.Runnable
                    public void run() {
                        final c o = d.this.bzX.o(g.e("tempFilePath", a), g.e("filePath", a), false);
                        d.this.aMq.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "tempFilePath");
                                hashMap.put(Integer.valueOf(b2), "filePath");
                                if (g.a(g.a(o, "saveFile:", a), bVar, hashMap, d.this.aMq)) {
                                    com.baidu.swan.games.f.a.f fVar = new com.baidu.swan.games.f.a.f();
                                    fVar.savedFilePath = o.result != null ? o.result.get(0) : null;
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
        if (g.a(this.bzX, this.aMq, (JsObject) null, (String) null)) {
            c F = this.bzX.F(str, true);
            g.a(this.aMq, F, JSExceptionType.Error, "unknown error", "readdirSync:");
            if (F != null && F.errCode == 0) {
                int size = F.result == null ? 0 : F.result.size();
                return size == 0 ? new String[0] : (String[]) F.result.toArray(new String[size]);
            }
            return new String[0];
        }
        return null;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        if (g.a(this.bzX, this.aMq, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int b = g.b("dirPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bzX, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.11
                    @Override // java.lang.Runnable
                    public void run() {
                        final c F = d.this.bzX.F(g.e("dirPath", a), false);
                        d.this.aMq.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "dirPath");
                                if (g.a(g.a(F, "readdir:", a), bVar, hashMap, d.this.aMq)) {
                                    com.baidu.swan.games.f.a.d dVar = new com.baidu.swan.games.f.a.d();
                                    int size = F.result == null ? 0 : F.result.size();
                                    dVar.files = size == 0 ? new String[0] : (String[]) F.result.toArray(new String[size]);
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
        if (g.a(this.bzX, this.aMq, (JsObject) null, (String) null)) {
            g.a(this.aMq, this.bzX.c(str, false, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (g.a(this.bzX, this.aMq, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int b = g.b("dirPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bzX, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.12
                    @Override // java.lang.Runnable
                    public void run() {
                        final c c = d.this.bzX.c(g.e("dirPath", a), false, false);
                        d.this.aMq.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "dirPath");
                                if (g.a(g.a(c, "rmdir:", a), bVar, hashMap, d.this.aMq)) {
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
        if (g.a(this.bzX, this.aMq, (JsObject) null, (String) null)) {
            c p = this.bzX.p(str, str2, true);
            g.a(this.aMq, p, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (p == null || p.errCode != 0 || p.result == null) {
                return null;
            }
            return p.result.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (g.a(this.bzX, this.aMq, (JsObject) null, (String) null)) {
            c p = this.bzX.p(str, null, true);
            g.a(this.aMq, p, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (p.bzW == null) {
                p.bzW = new byte[0];
            }
            return new JsArrayBuffer(p.bzW, p.bzW.length);
        }
        return null;
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (g.a(this.bzX, this.aMq, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int b = g.b("filePath", jsObject);
            final int b2 = g.b("encoding", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bzX, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a != null) {
                final String e = g.e("encoding", a);
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.13
                    @Override // java.lang.Runnable
                    public void run() {
                        final c p = d.this.bzX.p(g.e("filePath", a), e, false);
                        if (b2 != 7 && b2 != 12) {
                            p.errMsg = "fail encoding must be a string";
                            p.errCode = -2;
                            g.a(d.this.aMq, p.errMsg);
                        }
                        d.this.aMq.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "filePath");
                                if (g.a(g.a(p, "readFile:", a), bVar, hashMap, d.this.aMq)) {
                                    if (TextUtils.isEmpty(e)) {
                                        com.baidu.swan.games.f.a.a aVar = new com.baidu.swan.games.f.a.a();
                                        if (p.bzW == null) {
                                            p.bzW = new byte[0];
                                        }
                                        aVar.data = new JsArrayBuffer(p.bzW, p.bzW.length);
                                        g.b(aVar, a);
                                        return;
                                    }
                                    String str = p.result != null ? p.result.get(0) : null;
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
        if (g.a(this.bzX, this.aMq, (JsObject) null, (String) null)) {
            g.a(this.aMq, this.bzX.q(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (g.a(this.bzX, this.aMq, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("oldPath", jsObject);
            final int b2 = g.b("newPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bzX, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.14
                    @Override // java.lang.Runnable
                    public void run() {
                        final c q = d.this.bzX.q(g.e("oldPath", a), g.e("newPath", a), false);
                        d.this.aMq.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "oldPath");
                                hashMap.put(Integer.valueOf(b2), "newPath");
                                if (g.a(g.a(q, "rename:", a), bVar, hashMap, d.this.aMq)) {
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
        if (g.a(this.bzX, this.aMq, (JsObject) null, (String) null)) {
            g.a(this.aMq, this.bzX.r(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (g.a(this.bzX, this.aMq, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("srcPath", jsObject);
            final int b2 = g.b("destPath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bzX, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        final c r = d.this.bzX.r(g.e("srcPath", a), g.e("destPath", a), false);
                        d.this.aMq.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "srcPath");
                                hashMap.put(Integer.valueOf(b2), "destPath");
                                if (g.a(g.a(r, "copyFile:", a), bVar, hashMap, d.this.aMq)) {
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
        if (g.a(this.bzX, this.aMq, (JsObject) null, (String) null)) {
            g.a(this.aMq, this.bzX.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
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
        if (g.a(this.bzX, this.aMq, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int b = g.b("encoding", jsObject);
            final int b2 = g.b("filePath", jsObject);
            int b3 = g.b("data", jsObject);
            final String fU = (b3 == 5 || b3 == 2 || b3 == 3) ? "fail data argument must not be a number" : g.fU(b3);
            final byte[] f = g.f(jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bzX, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a != null) {
                final String e = g.e("data", a);
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.3
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b4 = d.this.bzX.b(g.e("filePath", a), TextUtils.isEmpty(e) ? f : e, g.e("encoding", a), false);
                        if (!TextUtils.isEmpty(fU)) {
                            b4.errMsg = fU;
                            b4.errCode = -2;
                            g.a(d.this.aMq, fU);
                        } else if (b != 7 && b != 12) {
                            b4.errMsg = "fail encoding must be a string";
                            b4.errCode = -2;
                            g.a(d.this.aMq, b4.errMsg);
                        }
                        d.this.aMq.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b2), "filePath");
                                if (g.a(g.a(b4, "appendFile:", a), bVar, hashMap, d.this.aMq)) {
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
        if (g.a(this.bzX, this.aMq, (JsObject) null, (String) null)) {
            g.a(this.aMq, this.bzX.G(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (g.a(this.bzX, this.aMq, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("path", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bzX, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.4
                    @Override // java.lang.Runnable
                    public void run() {
                        final c G = d.this.bzX.G(g.e("path", a), false);
                        d.this.aMq.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "path");
                                if (g.a(g.a(G, "access:", a), bVar, hashMap, d.this.aMq)) {
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
        if (g.a(this.bzX, this.aMq, (JsObject) null, (String) null)) {
            c H = this.bzX.H(str, true);
            g.a(this.aMq, H, JSExceptionType.Error, "unknown error", "statSync:");
            if (H == null || H.errCode != 0) {
                return null;
            }
            return H.stats;
        }
        return null;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (g.a(this.bzX, this.aMq, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int b = g.b("path", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bzX, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.5
                    @Override // java.lang.Runnable
                    public void run() {
                        final c H = d.this.bzX.H(g.e("path", a), false);
                        d.this.aMq.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "path");
                                if (g.a(g.a(H, "stat:", a), bVar, hashMap, d.this.aMq)) {
                                    com.baidu.swan.games.f.a.g gVar = new com.baidu.swan.games.f.a.g();
                                    gVar.stats = H.stats;
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
        if (g.a(this.bzX, this.aMq, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int b = g.b("filePath", jsObject);
            final com.baidu.swan.games.f.a.b bVar = new com.baidu.swan.games.f.a.b();
            final Map<String, Object> a = g.a(this.bzX, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a != null) {
                j.a(new Runnable() { // from class: com.baidu.swan.games.f.d.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final c jP = d.this.bzX.jP(g.e("filePath", a));
                        d.this.aMq.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.f.d.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(b), "filePath");
                                if (g.a(g.a(jP, "getFileInfo:", a), bVar, hashMap, d.this.aMq)) {
                                    com.baidu.swan.games.f.a.c cVar = new com.baidu.swan.games.f.a.c();
                                    cVar.errMsg = "getFileInfo:" + jP.errMsg;
                                    cVar.digest = jP.digest;
                                    cVar.size = (int) jP.size;
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
