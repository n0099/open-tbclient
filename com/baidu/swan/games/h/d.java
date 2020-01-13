package com.baidu.swan.games.h;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class d {
    private com.baidu.swan.games.e.a bgR;
    private e ciR;
    private h ciS;

    public d(com.baidu.swan.games.e.a aVar) {
        this.bgR = aVar;
        alt();
    }

    private void alt() {
        l.bA(l.getBasePath(), l.alF());
        this.ciR = new e(AppRuntime.getAppContext(), com.baidu.swan.apps.y.f.UC().Uk());
        this.ciS = h.alB();
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        if (l.a(this.ciR, this.bgR, (JsObject) null, (String) null)) {
            this.ciS.u(str);
            l.a(this.bgR, this.ciR.b(str, false, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (l.a(this.ciR, this.bgR, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = l.a("dirPath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.ciR, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a2 != null) {
                final String e = l.e("dirPath", a2);
                this.ciS.a(new Runnable() { // from class: com.baidu.swan.games.h.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b = d.this.ciR.b(e, false, false);
                        d.this.bgR.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "dirPath");
                                if (l.a(l.a(b, "mkdir:", a2), bVar, hashMap, d.this.bgR)) {
                                    bVar.errMsg = "mkdir:" + b.errMsg;
                                    l.c(bVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesmkdir:", e);
            }
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        if (l.a(this.ciR, this.bgR, (JsObject) null, (String) null)) {
            this.ciS.u(str);
            l.a(this.bgR, this.ciR.a(true, str, (Object) str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2) {
        writeFileSync(str, str2, "");
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        if (l.a(this.ciR, this.bgR, (JsObject) null, (String) null)) {
            this.ciS.u(str);
            l.a(this.bgR, this.ciR.a(true, str, (Object) (jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer()), (String) null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        writeFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (l.a(this.ciR, this.bgR, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = l.a("filePath", jsObject);
            final String hB = l.hB(l.a("data", jsObject));
            final int a2 = l.a("encoding", jsObject);
            final byte[] f = l.f(jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a3 = l.a(this.ciR, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String e = l.e("data", a3);
                final String e2 = l.e("filePath", a3);
                this.ciS.a(new Runnable() { // from class: com.baidu.swan.games.h.d.7
                    @Override // java.lang.Runnable
                    public void run() {
                        final c a4 = d.this.ciR.a(false, e2, TextUtils.isEmpty(e) ? f : e, l.e("encoding", a3));
                        if (!TextUtils.isEmpty(hB)) {
                            a4.errMsg = hB;
                            a4.errCode = -2;
                            l.a(d.this.bgR, hB);
                        } else if (a2 != 7 && a2 != 12) {
                            a4.errMsg = "fail encoding must be a string";
                            a4.errCode = -2;
                            l.a(d.this.bgR, a4.errMsg);
                        }
                        d.this.bgR.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (l.a(l.a(a4, "writeFile:", a3), bVar, hashMap, d.this.bgR)) {
                                    bVar.errMsg = "writeFile:" + a4.errMsg;
                                    l.c(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigameswriteFile:", e2);
            }
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        if (l.a(this.ciR, this.bgR, (JsObject) null, (String) null)) {
            this.ciS.u(str);
            l.a(this.bgR, this.ciR.J(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (l.a(this.ciR, this.bgR, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a = l.a("filePath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.ciR, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a2 != null) {
                final String e = l.e("filePath", a2);
                this.ciS.a(new Runnable() { // from class: com.baidu.swan.games.h.d.8
                    @Override // java.lang.Runnable
                    public void run() {
                        final c J = d.this.ciR.J(e, false);
                        d.this.bgR.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (l.a(l.a(J, "unlink:", a2), bVar, hashMap, d.this.bgR)) {
                                    bVar.errMsg = "unlink:" + J.errMsg;
                                    l.c(bVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesunlink:", e);
            }
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        if (l.a(this.ciR, this.bgR, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = l.a("zipFilePath", jsObject);
            final int a2 = l.a("targetPath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a3 = l.a(this.ciR, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (a3 != null) {
                final String e = l.e("zipFilePath", a3);
                final String e2 = l.e("targetPath", a3);
                this.ciS.a(new Runnable() { // from class: com.baidu.swan.games.h.d.9
                    @Override // java.lang.Runnable
                    public void run() {
                        final c by = d.this.ciR.by(e, e2);
                        d.this.bgR.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "zipFilePath");
                                hashMap.put(Integer.valueOf(a2), "targetPath");
                                if (l.a(l.a(by, "unzip:", a3), bVar, hashMap, d.this.bgR)) {
                                    bVar.errMsg = "unzip:" + by.errMsg;
                                    l.c(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamesunzip:", e, e2);
            }
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        return saveFileSync(str, a.USER_DATA_PATH);
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        if (l.a(this.ciR, this.bgR, (JsObject) null, (String) null)) {
            this.ciS.u(str, str2);
            c o = this.ciR.o(str, str2, true);
            l.a(this.bgR, o, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (o == null || o.errCode != 0 || o.result == null) {
                return null;
            }
            return o.result.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (l.a(this.ciR, this.bgR, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = l.a("tempFilePath", jsObject);
            final int a2 = l.a("filePath", jsObject);
            if (a2 == 12) {
                a2 = 7;
            }
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a3 = l.a(this.ciR, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (a3 != null) {
                final String e = l.e("tempFilePath", a3);
                final String e2 = l.e("filePath", a3);
                this.ciS.a(new Runnable() { // from class: com.baidu.swan.games.h.d.10
                    @Override // java.lang.Runnable
                    public void run() {
                        final c o = d.this.ciR.o(e, e2, false);
                        d.this.bgR.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "tempFilePath");
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (l.a(l.a(o, "saveFile:", a3), bVar, hashMap, d.this.bgR)) {
                                    com.baidu.swan.games.h.a.f fVar = new com.baidu.swan.games.h.a.f();
                                    fVar.savedFilePath = o.result != null ? o.result.get(0) : null;
                                    l.c(fVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamessaveFile:", e, e2);
            }
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        if (l.a(this.ciR, this.bgR, (JsObject) null, (String) null)) {
            this.ciS.u(str);
            c K = this.ciR.K(str, true);
            l.a(this.bgR, K, JSExceptionType.Error, "unknown error", "readdirSync:");
            if (K != null && K.errCode == 0) {
                int size = K.result == null ? 0 : K.result.size();
                return size == 0 ? new String[0] : (String[]) K.result.toArray(new String[size]);
            }
            return new String[0];
        }
        return null;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        if (l.a(this.ciR, this.bgR, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = l.a("dirPath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.ciR, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a2 != null) {
                final String e = l.e("dirPath", a2);
                this.ciS.a(new Runnable() { // from class: com.baidu.swan.games.h.d.11
                    @Override // java.lang.Runnable
                    public void run() {
                        final c K = d.this.ciR.K(e, false);
                        d.this.bgR.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "dirPath");
                                if (l.a(l.a(K, "readdir:", a2), bVar, hashMap, d.this.bgR)) {
                                    com.baidu.swan.games.h.a.d dVar = new com.baidu.swan.games.h.a.d();
                                    int size = K.result == null ? 0 : K.result.size();
                                    dVar.files = size == 0 ? new String[0] : (String[]) K.result.toArray(new String[size]);
                                    l.c(dVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesreaddir:", e);
            }
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str) {
        if (l.a(this.ciR, this.bgR, (JsObject) null, (String) null)) {
            this.ciS.u(str);
            l.a(this.bgR, this.ciR.c(str, false, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (l.a(this.ciR, this.bgR, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = l.a("dirPath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.ciR, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a2 != null) {
                final String e = l.e("dirPath", a2);
                this.ciS.a(new Runnable() { // from class: com.baidu.swan.games.h.d.12
                    @Override // java.lang.Runnable
                    public void run() {
                        final c c = d.this.ciR.c(e, false, false);
                        d.this.bgR.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "dirPath");
                                if (l.a(l.a(c, "rmdir:", a2), bVar, hashMap, d.this.bgR)) {
                                    l.c(bVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesrmdir:", e);
            }
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        if (l.a(this.ciR, this.bgR, (JsObject) null, (String) null)) {
            this.ciS.u(str);
            c p = this.ciR.p(str, str2, true);
            l.a(this.bgR, p, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (p == null || p.errCode != 0 || p.result == null) {
                return null;
            }
            return p.result.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (l.a(this.ciR, this.bgR, (JsObject) null, (String) null)) {
            this.ciS.u(str);
            c p = this.ciR.p(str, null, true);
            l.a(this.bgR, p, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (p.ciQ == null) {
                p.ciQ = new byte[0];
            }
            return new JsArrayBuffer(p.ciQ, p.ciQ.length);
        }
        return null;
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (l.a(this.ciR, this.bgR, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = l.a("filePath", jsObject);
            final int a2 = l.a("encoding", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a3 = l.a(this.ciR, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String e = l.e("encoding", a3);
                final String e2 = l.e("filePath", a3);
                this.ciS.a(new Runnable() { // from class: com.baidu.swan.games.h.d.13
                    @Override // java.lang.Runnable
                    public void run() {
                        final c p = d.this.ciR.p(e2, e, false);
                        if (a2 != 7 && a2 != 12) {
                            p.errMsg = "fail encoding must be a string";
                            p.errCode = -2;
                            l.a(d.this.bgR, p.errMsg);
                        }
                        d.this.bgR.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (l.a(l.a(p, "readFile:", a3), bVar, hashMap, d.this.bgR)) {
                                    if (TextUtils.isEmpty(e)) {
                                        com.baidu.swan.games.h.a.a aVar = new com.baidu.swan.games.h.a.a();
                                        if (p.ciQ == null) {
                                            p.ciQ = new byte[0];
                                        }
                                        aVar.data = new JsArrayBuffer(p.ciQ, p.ciQ.length);
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
                }, "aigamesreadFile:", e2);
            }
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        if (l.a(this.ciR, this.bgR, (JsObject) null, (String) null)) {
            this.ciS.u(str, str2);
            l.a(this.bgR, this.ciR.q(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (l.a(this.ciR, this.bgR, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = l.a("oldPath", jsObject);
            final int a2 = l.a("newPath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a3 = l.a(this.ciR, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (a3 != null) {
                final String e = l.e("oldPath", a3);
                final String e2 = l.e("newPath", a3);
                this.ciS.a(new Runnable() { // from class: com.baidu.swan.games.h.d.14
                    @Override // java.lang.Runnable
                    public void run() {
                        final c q = d.this.ciR.q(e, e2, false);
                        d.this.bgR.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "oldPath");
                                hashMap.put(Integer.valueOf(a2), "newPath");
                                if (l.a(l.a(q, "rename:", a3), bVar, hashMap, d.this.bgR)) {
                                    l.c(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamesrename:", e, e2);
            }
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        if (l.a(this.ciR, this.bgR, (JsObject) null, (String) null)) {
            this.ciS.u(str, str2);
            l.a(this.bgR, this.ciR.r(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (l.a(this.ciR, this.bgR, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = l.a("srcPath", jsObject);
            final int a2 = l.a("destPath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a3 = l.a(this.ciR, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (a3 != null) {
                final String e = l.e("srcPath", a3);
                final String e2 = l.e("destPath", a3);
                this.ciS.a(new Runnable() { // from class: com.baidu.swan.games.h.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        final c r = d.this.ciR.r(e, e2, false);
                        d.this.bgR.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "srcPath");
                                hashMap.put(Integer.valueOf(a2), "destPath");
                                if (l.a(l.a(r, "copyFile:", a3), bVar, hashMap, d.this.bgR)) {
                                    l.c(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamescopyFile:", e, e2);
            }
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        if (l.a(this.ciR, this.bgR, (JsObject) null, (String) null)) {
            this.ciS.u(str);
            l.a(this.bgR, this.ciR.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
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
        if (l.a(this.ciR, this.bgR, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a = l.a("encoding", jsObject);
            final int a2 = l.a("filePath", jsObject);
            int a3 = l.a("data", jsObject);
            final String hB = (a3 == 5 || a3 == 2 || a3 == 3) ? "fail data argument must not be a number" : l.hB(a3);
            final byte[] f = l.f(jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a4 = l.a(this.ciR, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a4 != null) {
                final String e = l.e("data", a4);
                final String e2 = l.e("filePath", a4);
                this.ciS.a(new Runnable() { // from class: com.baidu.swan.games.h.d.3
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b = d.this.ciR.b(e2, TextUtils.isEmpty(e) ? f : e, l.e("encoding", a4), false);
                        if (!TextUtils.isEmpty(hB)) {
                            b.errMsg = hB;
                            b.errCode = -2;
                            l.a(d.this.bgR, hB);
                        } else if (a != 7 && a != 12) {
                            b.errMsg = "fail encoding must be a string";
                            b.errCode = -2;
                            l.a(d.this.bgR, b.errMsg);
                        }
                        d.this.bgR.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (l.a(l.a(b, "appendFile:", a4), bVar, hashMap, d.this.bgR)) {
                                    l.c(bVar, a4);
                                }
                            }
                        });
                    }
                }, "aigamesappendFile:", e2);
            }
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        if (l.a(this.ciR, this.bgR, (JsObject) null, (String) null)) {
            this.ciS.u(str);
            l.a(this.bgR, this.ciR.L(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (l.a(this.ciR, this.bgR, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = l.a("path", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.ciR, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a2 != null) {
                final String e = l.e("path", a2);
                this.ciS.a(new Runnable() { // from class: com.baidu.swan.games.h.d.4
                    @Override // java.lang.Runnable
                    public void run() {
                        final c L = d.this.ciR.L(e, false);
                        d.this.bgR.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "path");
                                if (l.a(l.a(L, "access:", a2), bVar, hashMap, d.this.bgR)) {
                                    l.c(bVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesaccess:", e);
            }
        }
    }

    @JavascriptInterface
    public i statSync(String str) {
        if (l.a(this.ciR, this.bgR, (JsObject) null, (String) null)) {
            this.ciS.u(str);
            c M = this.ciR.M(str, true);
            l.a(this.bgR, M, JSExceptionType.Error, "unknown error", "statSync:");
            if (M == null || M.errCode != 0) {
                return null;
            }
            return M.stats;
        }
        return null;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (l.a(this.ciR, this.bgR, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = l.a("path", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.ciR, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a2 != null) {
                final String e = l.e("path", a2);
                this.ciS.a(new Runnable() { // from class: com.baidu.swan.games.h.d.5
                    @Override // java.lang.Runnable
                    public void run() {
                        final c M = d.this.ciR.M(e, false);
                        d.this.bgR.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "path");
                                if (l.a(l.a(M, "stat:", a2), bVar, hashMap, d.this.bgR)) {
                                    com.baidu.swan.games.h.a.g gVar = new com.baidu.swan.games.h.a.g();
                                    gVar.stats = M.stats;
                                    l.c(gVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesstat:", e);
            }
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        if (l.a(this.ciR, this.bgR, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a = l.a("filePath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.ciR, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a2 != null) {
                final String e = l.e("filePath", a2);
                this.ciS.a(new Runnable() { // from class: com.baidu.swan.games.h.d.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final c oC = d.this.ciR.oC(e);
                        d.this.bgR.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (l.a(l.a(oC, "getFileInfo:", a2), bVar, hashMap, d.this.bgR)) {
                                    com.baidu.swan.games.h.a.c cVar = new com.baidu.swan.games.h.a.c();
                                    cVar.errMsg = "getFileInfo:" + oC.errMsg;
                                    cVar.digest = oC.digest;
                                    cVar.size = (int) oC.size;
                                    l.c(cVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesgetFileInfo:", e);
            }
        }
    }
}
