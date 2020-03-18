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
    private com.baidu.swan.games.e.a bls;
    private e cni;
    private h cnj;

    public d(com.baidu.swan.games.e.a aVar) {
        this.bls = aVar;
        anL();
    }

    private void anL() {
        l.bI(l.getBasePath(), l.anX());
        this.cni = new e(AppRuntime.getAppContext(), com.baidu.swan.apps.y.f.WV().WD());
        this.cnj = h.anT();
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        if (l.a(this.cni, this.bls, (JsObject) null, (String) null)) {
            this.cnj.y(str);
            l.a(this.bls, this.cni.b(str, false, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (l.a(this.cni, this.bls, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = l.a("dirPath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.cni, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a2 != null) {
                final String e = l.e("dirPath", a2);
                this.cnj.a(new Runnable() { // from class: com.baidu.swan.games.h.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b = d.this.cni.b(e, false, false);
                        d.this.bls.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "dirPath");
                                if (l.a(l.a(b, "mkdir:", a2), bVar, hashMap, d.this.bls)) {
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
        if (l.a(this.cni, this.bls, (JsObject) null, (String) null)) {
            this.cnj.y(str);
            l.a(this.bls, this.cni.a(true, str, (Object) str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2) {
        writeFileSync(str, str2, "");
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        if (l.a(this.cni, this.bls, (JsObject) null, (String) null)) {
            this.cnj.y(str);
            l.a(this.bls, this.cni.a(true, str, (Object) (jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer()), (String) null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        writeFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (l.a(this.cni, this.bls, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = l.a("filePath", jsObject);
            final String hS = l.hS(l.a("data", jsObject));
            final int a2 = l.a("encoding", jsObject);
            final byte[] f = l.f(jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a3 = l.a(this.cni, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String e = l.e("data", a3);
                final String e2 = l.e("filePath", a3);
                this.cnj.a(new Runnable() { // from class: com.baidu.swan.games.h.d.7
                    @Override // java.lang.Runnable
                    public void run() {
                        final c a4 = d.this.cni.a(false, e2, TextUtils.isEmpty(e) ? f : e, l.e("encoding", a3));
                        if (!TextUtils.isEmpty(hS)) {
                            a4.errMsg = hS;
                            a4.errCode = -2;
                            l.a(d.this.bls, hS);
                        } else if (a2 != 7 && a2 != 12) {
                            a4.errMsg = "fail encoding must be a string";
                            a4.errCode = -2;
                            l.a(d.this.bls, a4.errMsg);
                        }
                        d.this.bls.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (l.a(l.a(a4, "writeFile:", a3), bVar, hashMap, d.this.bls)) {
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
        if (l.a(this.cni, this.bls, (JsObject) null, (String) null)) {
            this.cnj.y(str);
            l.a(this.bls, this.cni.J(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (l.a(this.cni, this.bls, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a = l.a("filePath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.cni, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a2 != null) {
                final String e = l.e("filePath", a2);
                this.cnj.a(new Runnable() { // from class: com.baidu.swan.games.h.d.8
                    @Override // java.lang.Runnable
                    public void run() {
                        final c J = d.this.cni.J(e, false);
                        d.this.bls.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (l.a(l.a(J, "unlink:", a2), bVar, hashMap, d.this.bls)) {
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
        if (l.a(this.cni, this.bls, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = l.a("zipFilePath", jsObject);
            final int a2 = l.a("targetPath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a3 = l.a(this.cni, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (a3 != null) {
                final String e = l.e("zipFilePath", a3);
                final String e2 = l.e("targetPath", a3);
                this.cnj.a(new Runnable() { // from class: com.baidu.swan.games.h.d.9
                    @Override // java.lang.Runnable
                    public void run() {
                        final c bG = d.this.cni.bG(e, e2);
                        d.this.bls.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "zipFilePath");
                                hashMap.put(Integer.valueOf(a2), "targetPath");
                                if (l.a(l.a(bG, "unzip:", a3), bVar, hashMap, d.this.bls)) {
                                    bVar.errMsg = "unzip:" + bG.errMsg;
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
        if (l.a(this.cni, this.bls, (JsObject) null, (String) null)) {
            this.cnj.y(str, str2);
            c p = this.cni.p(str, str2, true);
            l.a(this.bls, p, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (p == null || p.errCode != 0 || p.result == null) {
                return null;
            }
            return p.result.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (l.a(this.cni, this.bls, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = l.a("tempFilePath", jsObject);
            final int a2 = l.a("filePath", jsObject);
            if (a2 == 12) {
                a2 = 7;
            }
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a3 = l.a(this.cni, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (a3 != null) {
                final String e = l.e("tempFilePath", a3);
                final String e2 = l.e("filePath", a3);
                this.cnj.a(new Runnable() { // from class: com.baidu.swan.games.h.d.10
                    @Override // java.lang.Runnable
                    public void run() {
                        final c p = d.this.cni.p(e, e2, false);
                        d.this.bls.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "tempFilePath");
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (l.a(l.a(p, "saveFile:", a3), bVar, hashMap, d.this.bls)) {
                                    com.baidu.swan.games.h.a.f fVar = new com.baidu.swan.games.h.a.f();
                                    fVar.savedFilePath = p.result != null ? p.result.get(0) : null;
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
        if (l.a(this.cni, this.bls, (JsObject) null, (String) null)) {
            this.cnj.y(str);
            c K = this.cni.K(str, true);
            l.a(this.bls, K, JSExceptionType.Error, "unknown error", "readdirSync:");
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
        if (l.a(this.cni, this.bls, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = l.a("dirPath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.cni, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a2 != null) {
                final String e = l.e("dirPath", a2);
                this.cnj.a(new Runnable() { // from class: com.baidu.swan.games.h.d.11
                    @Override // java.lang.Runnable
                    public void run() {
                        final c K = d.this.cni.K(e, false);
                        d.this.bls.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "dirPath");
                                if (l.a(l.a(K, "readdir:", a2), bVar, hashMap, d.this.bls)) {
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
        if (l.a(this.cni, this.bls, (JsObject) null, (String) null)) {
            this.cnj.y(str);
            l.a(this.bls, this.cni.c(str, false, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (l.a(this.cni, this.bls, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = l.a("dirPath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.cni, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a2 != null) {
                final String e = l.e("dirPath", a2);
                this.cnj.a(new Runnable() { // from class: com.baidu.swan.games.h.d.12
                    @Override // java.lang.Runnable
                    public void run() {
                        final c c = d.this.cni.c(e, false, false);
                        d.this.bls.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "dirPath");
                                if (l.a(l.a(c, "rmdir:", a2), bVar, hashMap, d.this.bls)) {
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
        if (l.a(this.cni, this.bls, (JsObject) null, (String) null)) {
            this.cnj.y(str);
            c q = this.cni.q(str, str2, true);
            l.a(this.bls, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q == null || q.errCode != 0 || q.result == null) {
                return null;
            }
            return q.result.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (l.a(this.cni, this.bls, (JsObject) null, (String) null)) {
            this.cnj.y(str);
            c q = this.cni.q(str, null, true);
            l.a(this.bls, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q.cnh == null) {
                q.cnh = new byte[0];
            }
            return new JsArrayBuffer(q.cnh, q.cnh.length);
        }
        return null;
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (l.a(this.cni, this.bls, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = l.a("filePath", jsObject);
            final int a2 = l.a("encoding", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a3 = l.a(this.cni, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String e = l.e("encoding", a3);
                final String e2 = l.e("filePath", a3);
                this.cnj.a(new Runnable() { // from class: com.baidu.swan.games.h.d.13
                    @Override // java.lang.Runnable
                    public void run() {
                        final c q = d.this.cni.q(e2, e, false);
                        if (a2 != 7 && a2 != 12) {
                            q.errMsg = "fail encoding must be a string";
                            q.errCode = -2;
                            l.a(d.this.bls, q.errMsg);
                        }
                        d.this.bls.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (l.a(l.a(q, "readFile:", a3), bVar, hashMap, d.this.bls)) {
                                    if (TextUtils.isEmpty(e)) {
                                        com.baidu.swan.games.h.a.a aVar = new com.baidu.swan.games.h.a.a();
                                        if (q.cnh == null) {
                                            q.cnh = new byte[0];
                                        }
                                        aVar.data = new JsArrayBuffer(q.cnh, q.cnh.length);
                                        l.c(aVar, a3);
                                        return;
                                    }
                                    String str = q.result != null ? q.result.get(0) : null;
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
        if (l.a(this.cni, this.bls, (JsObject) null, (String) null)) {
            this.cnj.y(str, str2);
            l.a(this.bls, this.cni.r(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (l.a(this.cni, this.bls, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = l.a("oldPath", jsObject);
            final int a2 = l.a("newPath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a3 = l.a(this.cni, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (a3 != null) {
                final String e = l.e("oldPath", a3);
                final String e2 = l.e("newPath", a3);
                this.cnj.a(new Runnable() { // from class: com.baidu.swan.games.h.d.14
                    @Override // java.lang.Runnable
                    public void run() {
                        final c r = d.this.cni.r(e, e2, false);
                        d.this.bls.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "oldPath");
                                hashMap.put(Integer.valueOf(a2), "newPath");
                                if (l.a(l.a(r, "rename:", a3), bVar, hashMap, d.this.bls)) {
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
        if (l.a(this.cni, this.bls, (JsObject) null, (String) null)) {
            this.cnj.y(str, str2);
            l.a(this.bls, this.cni.s(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (l.a(this.cni, this.bls, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = l.a("srcPath", jsObject);
            final int a2 = l.a("destPath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a3 = l.a(this.cni, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (a3 != null) {
                final String e = l.e("srcPath", a3);
                final String e2 = l.e("destPath", a3);
                this.cnj.a(new Runnable() { // from class: com.baidu.swan.games.h.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        final c s = d.this.cni.s(e, e2, false);
                        d.this.bls.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "srcPath");
                                hashMap.put(Integer.valueOf(a2), "destPath");
                                if (l.a(l.a(s, "copyFile:", a3), bVar, hashMap, d.this.bls)) {
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
        if (l.a(this.cni, this.bls, (JsObject) null, (String) null)) {
            this.cnj.y(str);
            l.a(this.bls, this.cni.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
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
        if (l.a(this.cni, this.bls, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a = l.a("encoding", jsObject);
            final int a2 = l.a("filePath", jsObject);
            int a3 = l.a("data", jsObject);
            final String hS = (a3 == 5 || a3 == 2 || a3 == 3) ? "fail data argument must not be a number" : l.hS(a3);
            final byte[] f = l.f(jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a4 = l.a(this.cni, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a4 != null) {
                final String e = l.e("data", a4);
                final String e2 = l.e("filePath", a4);
                this.cnj.a(new Runnable() { // from class: com.baidu.swan.games.h.d.3
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b = d.this.cni.b(e2, TextUtils.isEmpty(e) ? f : e, l.e("encoding", a4), false);
                        if (!TextUtils.isEmpty(hS)) {
                            b.errMsg = hS;
                            b.errCode = -2;
                            l.a(d.this.bls, hS);
                        } else if (a != 7 && a != 12) {
                            b.errMsg = "fail encoding must be a string";
                            b.errCode = -2;
                            l.a(d.this.bls, b.errMsg);
                        }
                        d.this.bls.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (l.a(l.a(b, "appendFile:", a4), bVar, hashMap, d.this.bls)) {
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
        if (l.a(this.cni, this.bls, (JsObject) null, (String) null)) {
            this.cnj.y(str);
            l.a(this.bls, this.cni.L(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (l.a(this.cni, this.bls, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = l.a("path", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.cni, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a2 != null) {
                final String e = l.e("path", a2);
                this.cnj.a(new Runnable() { // from class: com.baidu.swan.games.h.d.4
                    @Override // java.lang.Runnable
                    public void run() {
                        final c L = d.this.cni.L(e, false);
                        d.this.bls.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "path");
                                if (l.a(l.a(L, "access:", a2), bVar, hashMap, d.this.bls)) {
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
        if (l.a(this.cni, this.bls, (JsObject) null, (String) null)) {
            this.cnj.y(str);
            c M = this.cni.M(str, true);
            l.a(this.bls, M, JSExceptionType.Error, "unknown error", "statSync:");
            if (M == null || M.errCode != 0) {
                return null;
            }
            return M.stats;
        }
        return null;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (l.a(this.cni, this.bls, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = l.a("path", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.cni, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a2 != null) {
                final String e = l.e("path", a2);
                this.cnj.a(new Runnable() { // from class: com.baidu.swan.games.h.d.5
                    @Override // java.lang.Runnable
                    public void run() {
                        final c M = d.this.cni.M(e, false);
                        d.this.bls.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "path");
                                if (l.a(l.a(M, "stat:", a2), bVar, hashMap, d.this.bls)) {
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
        if (l.a(this.cni, this.bls, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a = l.a("filePath", jsObject);
            final com.baidu.swan.games.h.a.b bVar = new com.baidu.swan.games.h.a.b();
            final Map<String, Object> a2 = l.a(this.cni, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a2 != null) {
                final String e = l.e("filePath", a2);
                this.cnj.a(new Runnable() { // from class: com.baidu.swan.games.h.d.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final c oQ = d.this.cni.oQ(e);
                        d.this.bls.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.h.d.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (l.a(l.a(oQ, "getFileInfo:", a2), bVar, hashMap, d.this.bls)) {
                                    com.baidu.swan.games.h.a.c cVar = new com.baidu.swan.games.h.a.c();
                                    cVar.errMsg = "getFileInfo:" + oQ.errMsg;
                                    cVar.digest = oQ.digest;
                                    cVar.size = (int) oQ.size;
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
