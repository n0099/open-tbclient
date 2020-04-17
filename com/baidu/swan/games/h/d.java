package com.baidu.swan.games.h;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class d {
    private com.baidu.swan.games.e.a bJA;
    private e cMe;
    private h cMf;

    public d(com.baidu.swan.games.e.a aVar) {
        this.bJA = aVar;
        avY();
    }

    private void avY() {
        l.bT(l.getBasePath(), l.awk());
        this.cMe = new e(AppRuntime.getAppContext(), com.baidu.swan.apps.y.f.aeK().aes());
        this.cMf = h.awg();
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        if (l.a(this.cMe, this.bJA, (JsObject) null, (String) null)) {
            this.cMf.y(str);
            l.a(this.bJA, this.cMe.b(str, false, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (l.a(this.cMe, this.bJA, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = l.a("dirPath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.cMe, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a2 != null) {
                final String f = l.f("dirPath", a2);
                this.cMf.a(new Runnable() { // from class: com.baidu.swan.games.h.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b = d.this.cMe.b(f, false, false);
                        d.this.bJA.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "dirPath");
                                if (l.a(l.a(b, "mkdir:", a2), bVar, hashMap, d.this.bJA)) {
                                    bVar.errMsg = "mkdir:" + b.errMsg;
                                    l.c(bVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesmkdir:", f);
            }
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        if (l.a(this.cMe, this.bJA, (JsObject) null, (String) null)) {
            this.cMf.y(str);
            l.a(this.bJA, this.cMe.a(true, str, (Object) str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2) {
        writeFileSync(str, str2, "");
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        if (l.a(this.cMe, this.bJA, (JsObject) null, (String) null)) {
            this.cMf.y(str);
            l.a(this.bJA, this.cMe.a(true, str, (Object) (jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer()), (String) null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        writeFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (l.a(this.cMe, this.bJA, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = l.a("filePath", jsObject);
            final String hZ = l.hZ(l.a("data", jsObject));
            final int a2 = l.a("encoding", jsObject);
            final byte[] f = l.f(jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a3 = l.a(this.cMe, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String f2 = l.f("data", a3);
                final String f3 = l.f("filePath", a3);
                this.cMf.a(new Runnable() { // from class: com.baidu.swan.games.h.d.7
                    @Override // java.lang.Runnable
                    public void run() {
                        final c a4 = d.this.cMe.a(false, f3, TextUtils.isEmpty(f2) ? f : f2, l.f("encoding", a3));
                        if (!TextUtils.isEmpty(hZ)) {
                            a4.errMsg = hZ;
                            a4.errCode = -2;
                            l.a(d.this.bJA, hZ);
                        } else if (a2 != 7 && a2 != 12) {
                            a4.errMsg = "fail encoding must be a string";
                            a4.errCode = -2;
                            l.a(d.this.bJA, a4.errMsg);
                        }
                        d.this.bJA.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (l.a(l.a(a4, "writeFile:", a3), bVar, hashMap, d.this.bJA)) {
                                    bVar.errMsg = "writeFile:" + a4.errMsg;
                                    l.c(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigameswriteFile:", f3);
            }
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        if (l.a(this.cMe, this.bJA, (JsObject) null, (String) null)) {
            this.cMf.y(str);
            l.a(this.bJA, this.cMe.O(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (l.a(this.cMe, this.bJA, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a = l.a("filePath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.cMe, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a2 != null) {
                final String f = l.f("filePath", a2);
                this.cMf.a(new Runnable() { // from class: com.baidu.swan.games.h.d.8
                    @Override // java.lang.Runnable
                    public void run() {
                        final c O = d.this.cMe.O(f, false);
                        d.this.bJA.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (l.a(l.a(O, "unlink:", a2), bVar, hashMap, d.this.bJA)) {
                                    bVar.errMsg = "unlink:" + O.errMsg;
                                    l.c(bVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesunlink:", f);
            }
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        if (l.a(this.cMe, this.bJA, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = l.a("zipFilePath", jsObject);
            final int a2 = l.a("targetPath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a3 = l.a(this.cMe, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (a3 != null) {
                final String f = l.f("zipFilePath", a3);
                final String f2 = l.f("targetPath", a3);
                this.cMf.a(new Runnable() { // from class: com.baidu.swan.games.h.d.9
                    @Override // java.lang.Runnable
                    public void run() {
                        final c bR = d.this.cMe.bR(f, f2);
                        d.this.bJA.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "zipFilePath");
                                hashMap.put(Integer.valueOf(a2), "targetPath");
                                if (l.a(l.a(bR, "unzip:", a3), bVar, hashMap, d.this.bJA)) {
                                    bVar.errMsg = "unzip:" + bR.errMsg;
                                    l.c(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamesunzip:", f, f2);
            }
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        return saveFileSync(str, a.USER_DATA_PATH);
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        if (l.a(this.cMe, this.bJA, (JsObject) null, (String) null)) {
            this.cMf.y(str, str2);
            c o = this.cMe.o(str, str2, true);
            l.a(this.bJA, o, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (o == null || o.errCode != 0 || o.result == null) {
                return null;
            }
            return o.result.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (l.a(this.cMe, this.bJA, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = l.a("tempFilePath", jsObject);
            final int a2 = l.a("filePath", jsObject);
            if (a2 == 12) {
                a2 = 7;
            }
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a3 = l.a(this.cMe, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (a3 != null) {
                final String f = l.f("tempFilePath", a3);
                final String f2 = l.f("filePath", a3);
                this.cMf.a(new Runnable() { // from class: com.baidu.swan.games.h.d.10
                    @Override // java.lang.Runnable
                    public void run() {
                        final c o = d.this.cMe.o(f, f2, false);
                        d.this.bJA.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "tempFilePath");
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (l.a(l.a(o, "saveFile:", a3), bVar, hashMap, d.this.bJA)) {
                                    com.baidu.swan.games.h.a.f fVar = new com.baidu.swan.games.h.a.f();
                                    fVar.savedFilePath = o.result != null ? o.result.get(0) : null;
                                    l.c(fVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamessaveFile:", f, f2);
            }
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        if (l.a(this.cMe, this.bJA, (JsObject) null, (String) null)) {
            this.cMf.y(str);
            c P = this.cMe.P(str, true);
            l.a(this.bJA, P, JSExceptionType.Error, "unknown error", "readdirSync:");
            if (P != null && P.errCode == 0) {
                int size = P.result == null ? 0 : P.result.size();
                return size == 0 ? new String[0] : (String[]) P.result.toArray(new String[size]);
            }
            return new String[0];
        }
        return null;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        if (l.a(this.cMe, this.bJA, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = l.a("dirPath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.cMe, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a2 != null) {
                final String f = l.f("dirPath", a2);
                this.cMf.a(new Runnable() { // from class: com.baidu.swan.games.h.d.11
                    @Override // java.lang.Runnable
                    public void run() {
                        final c P = d.this.cMe.P(f, false);
                        d.this.bJA.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "dirPath");
                                if (l.a(l.a(P, "readdir:", a2), bVar, hashMap, d.this.bJA)) {
                                    com.baidu.swan.games.h.a.d dVar = new com.baidu.swan.games.h.a.d();
                                    int size = P.result == null ? 0 : P.result.size();
                                    dVar.files = size == 0 ? new String[0] : (String[]) P.result.toArray(new String[size]);
                                    l.c(dVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesreaddir:", f);
            }
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str) {
        if (l.a(this.cMe, this.bJA, (JsObject) null, (String) null)) {
            this.cMf.y(str);
            l.a(this.bJA, this.cMe.c(str, false, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (l.a(this.cMe, this.bJA, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = l.a("dirPath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.cMe, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a2 != null) {
                final String f = l.f("dirPath", a2);
                this.cMf.a(new Runnable() { // from class: com.baidu.swan.games.h.d.12
                    @Override // java.lang.Runnable
                    public void run() {
                        final c c = d.this.cMe.c(f, false, false);
                        d.this.bJA.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "dirPath");
                                if (l.a(l.a(c, "rmdir:", a2), bVar, hashMap, d.this.bJA)) {
                                    l.c(bVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesrmdir:", f);
            }
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        if (l.a(this.cMe, this.bJA, (JsObject) null, (String) null)) {
            this.cMf.y(str);
            c p = this.cMe.p(str, str2, true);
            l.a(this.bJA, p, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (p == null || p.errCode != 0 || p.result == null) {
                return null;
            }
            return p.result.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (l.a(this.cMe, this.bJA, (JsObject) null, (String) null)) {
            this.cMf.y(str);
            c p = this.cMe.p(str, null, true);
            l.a(this.bJA, p, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (p.cMd == null) {
                p.cMd = new byte[0];
            }
            return new JsArrayBuffer(p.cMd, p.cMd.length);
        }
        return null;
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (l.a(this.cMe, this.bJA, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = l.a("filePath", jsObject);
            final int a2 = l.a("encoding", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a3 = l.a(this.cMe, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String f = l.f("encoding", a3);
                final String f2 = l.f("filePath", a3);
                this.cMf.a(new Runnable() { // from class: com.baidu.swan.games.h.d.13
                    @Override // java.lang.Runnable
                    public void run() {
                        final c p = d.this.cMe.p(f2, f, false);
                        if (a2 != 7 && a2 != 12) {
                            p.errMsg = "fail encoding must be a string";
                            p.errCode = -2;
                            l.a(d.this.bJA, p.errMsg);
                        }
                        d.this.bJA.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (l.a(l.a(p, "readFile:", a3), bVar, hashMap, d.this.bJA)) {
                                    if (TextUtils.isEmpty(f)) {
                                        com.baidu.swan.games.h.a.a aVar = new com.baidu.swan.games.h.a.a();
                                        if (p.cMd == null) {
                                            p.cMd = new byte[0];
                                        }
                                        aVar.data = new JsArrayBuffer(p.cMd, p.cMd.length);
                                        l.c(aVar, a3);
                                        return;
                                    }
                                    String str = p.result != null ? p.result.get(0) : null;
                                    com.baidu.swan.games.h.a.e eVar = new com.baidu.swan.games.h.a.e();
                                    eVar.data = str;
                                    l.c(eVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamesreadFile:", f2);
            }
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        if (l.a(this.cMe, this.bJA, (JsObject) null, (String) null)) {
            this.cMf.y(str, str2);
            l.a(this.bJA, this.cMe.q(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (l.a(this.cMe, this.bJA, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = l.a("oldPath", jsObject);
            final int a2 = l.a("newPath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a3 = l.a(this.cMe, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (a3 != null) {
                final String f = l.f("oldPath", a3);
                final String f2 = l.f("newPath", a3);
                this.cMf.a(new Runnable() { // from class: com.baidu.swan.games.h.d.14
                    @Override // java.lang.Runnable
                    public void run() {
                        final c q = d.this.cMe.q(f, f2, false);
                        d.this.bJA.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "oldPath");
                                hashMap.put(Integer.valueOf(a2), "newPath");
                                if (l.a(l.a(q, "rename:", a3), bVar, hashMap, d.this.bJA)) {
                                    l.c(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamesrename:", f, f2);
            }
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        if (l.a(this.cMe, this.bJA, (JsObject) null, (String) null)) {
            this.cMf.y(str, str2);
            l.a(this.bJA, this.cMe.r(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (l.a(this.cMe, this.bJA, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = l.a("srcPath", jsObject);
            final int a2 = l.a("destPath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a3 = l.a(this.cMe, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (a3 != null) {
                final String f = l.f("srcPath", a3);
                final String f2 = l.f("destPath", a3);
                this.cMf.a(new Runnable() { // from class: com.baidu.swan.games.h.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        final c r = d.this.cMe.r(f, f2, false);
                        d.this.bJA.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "srcPath");
                                hashMap.put(Integer.valueOf(a2), "destPath");
                                if (l.a(l.a(r, "copyFile:", a3), bVar, hashMap, d.this.bJA)) {
                                    l.c(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamescopyFile:", f, f2);
            }
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        if (l.a(this.cMe, this.bJA, (JsObject) null, (String) null)) {
            this.cMf.y(str);
            l.a(this.bJA, this.cMe.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
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
        if (l.a(this.cMe, this.bJA, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a = l.a("encoding", jsObject);
            final int a2 = l.a("filePath", jsObject);
            int a3 = l.a("data", jsObject);
            final String hZ = (a3 == 5 || a3 == 2 || a3 == 3) ? "fail data argument must not be a number" : l.hZ(a3);
            final byte[] f = l.f(jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a4 = l.a(this.cMe, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a4 != null) {
                final String f2 = l.f("data", a4);
                final String f3 = l.f("filePath", a4);
                this.cMf.a(new Runnable() { // from class: com.baidu.swan.games.h.d.3
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b = d.this.cMe.b(f3, TextUtils.isEmpty(f2) ? f : f2, l.f("encoding", a4), false);
                        if (!TextUtils.isEmpty(hZ)) {
                            b.errMsg = hZ;
                            b.errCode = -2;
                            l.a(d.this.bJA, hZ);
                        } else if (a != 7 && a != 12) {
                            b.errMsg = "fail encoding must be a string";
                            b.errCode = -2;
                            l.a(d.this.bJA, b.errMsg);
                        }
                        d.this.bJA.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (l.a(l.a(b, "appendFile:", a4), bVar, hashMap, d.this.bJA)) {
                                    l.c(bVar, a4);
                                }
                            }
                        });
                    }
                }, "aigamesappendFile:", f3);
            }
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        if (l.a(this.cMe, this.bJA, (JsObject) null, (String) null)) {
            this.cMf.y(str);
            l.a(this.bJA, this.cMe.Q(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (l.a(this.cMe, this.bJA, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = l.a("path", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.cMe, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a2 != null) {
                final String f = l.f("path", a2);
                this.cMf.a(new Runnable() { // from class: com.baidu.swan.games.h.d.4
                    @Override // java.lang.Runnable
                    public void run() {
                        final c Q = d.this.cMe.Q(f, false);
                        d.this.bJA.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "path");
                                if (l.a(l.a(Q, "access:", a2), bVar, hashMap, d.this.bJA)) {
                                    l.c(bVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesaccess:", f);
            }
        }
    }

    @JavascriptInterface
    public i statSync(String str) {
        if (l.a(this.cMe, this.bJA, (JsObject) null, (String) null)) {
            this.cMf.y(str);
            c R = this.cMe.R(str, true);
            l.a(this.bJA, R, JSExceptionType.Error, "unknown error", "statSync:");
            if (R == null || R.errCode != 0) {
                return null;
            }
            return R.stats;
        }
        return null;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (l.a(this.cMe, this.bJA, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = l.a("path", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.cMe, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a2 != null) {
                final String f = l.f("path", a2);
                this.cMf.a(new Runnable() { // from class: com.baidu.swan.games.h.d.5
                    @Override // java.lang.Runnable
                    public void run() {
                        final c R = d.this.cMe.R(f, false);
                        d.this.bJA.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "path");
                                if (l.a(l.a(R, "stat:", a2), bVar, hashMap, d.this.bJA)) {
                                    com.baidu.swan.games.h.a.g gVar = new com.baidu.swan.games.h.a.g();
                                    gVar.stats = R.stats;
                                    l.c(gVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesstat:", f);
            }
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        if (l.a(this.cMe, this.bJA, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a = l.a("filePath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.cMe, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a2 != null) {
                final String f = l.f("filePath", a2);
                this.cMf.a(new Runnable() { // from class: com.baidu.swan.games.h.d.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final c qd = d.this.cMe.qd(f);
                        d.this.bJA.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (l.a(l.a(qd, "getFileInfo:", a2), bVar, hashMap, d.this.bJA)) {
                                    com.baidu.swan.games.h.a.c cVar = new com.baidu.swan.games.h.a.c();
                                    cVar.errMsg = "getFileInfo:" + qd.errMsg;
                                    cVar.digest = qd.digest;
                                    cVar.size = (int) qd.size;
                                    l.c(cVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesgetFileInfo:", f);
            }
        }
    }
}
