package com.baidu.swan.games.i;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import java.util.HashMap;
import java.util.Map;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes7.dex */
public class e {
    private com.baidu.swan.games.f.a bYi;
    private f dhs;
    private i dht;

    public e(com.baidu.swan.games.f.a aVar) {
        this.bYi = aVar;
        aEy();
    }

    private void aEy() {
        com.baidu.swan.apps.storage.b.c lVar;
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        if (arw != null) {
            lVar = arw.ajX();
        } else {
            lVar = new l();
        }
        this.dhs = new f(AppRuntime.getAppContext(), com.baidu.swan.apps.v.f.akr().ajY(), lVar);
        this.dht = i.aEI();
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        mkdirSync(str, false);
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        if (n.a(this.dhs, this.bYi, (JsObject) null, (String) null)) {
            this.dht.y(str);
            n.a(this.bYi, this.dhs.b(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (n.a(this.dhs, this.bYi, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = n.a("dirPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a2 = n.a(this.dhs, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a2 != null) {
                final String j = n.j("dirPath", a2);
                final Boolean bool = (Boolean) n.a("recursive", a2, Boolean.FALSE);
                this.dht.a(new Runnable() { // from class: com.baidu.swan.games.i.e.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b = e.this.dhs.b(j, bool.booleanValue(), false);
                        e.this.bYi.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "dirPath");
                                if (n.a(n.a(b, "mkdir:", a2), bVar, hashMap, e.this.bYi)) {
                                    bVar.errMsg = "mkdir:" + b.errMsg;
                                    n.b(bVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesmkdir:", j);
            }
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        if (n.a(this.dhs, this.bYi, (JsObject) null, (String) null)) {
            this.dht.y(str);
            n.a(this.bYi, this.dhs.a(true, str, (Object) str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2) {
        writeFileSync(str, str2, "");
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        if (n.a(this.dhs, this.bYi, (JsObject) null, (String) null)) {
            this.dht.y(str);
            n.a(this.bYi, this.dhs.a(true, str, (Object) (jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer()), (String) null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        writeFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (n.a(this.dhs, this.bYi, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = n.a("filePath", jsObject);
            final String iU = n.iU(n.a("data", jsObject));
            final int a2 = n.a("encoding", jsObject);
            final byte[] g = n.g(jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dhs, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("data", a3);
                final String j2 = n.j("filePath", a3);
                this.dht.a(new Runnable() { // from class: com.baidu.swan.games.i.e.9
                    @Override // java.lang.Runnable
                    public void run() {
                        final c a4 = e.this.dhs.a(false, j2, TextUtils.isEmpty(j) ? g : j, n.j("encoding", a3));
                        if (!TextUtils.isEmpty(iU)) {
                            a4.errMsg = iU;
                            a4.errCode = -2;
                            n.a(e.this.bYi, iU);
                        } else if (a2 != 7 && a2 != 12) {
                            a4.errMsg = "fail encoding must be a string";
                            a4.errCode = -2;
                            n.a(e.this.bYi, a4.errMsg);
                        }
                        e.this.bYi.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (n.a(n.a(a4, "writeFile:", a3), bVar, hashMap, e.this.bYi)) {
                                    bVar.errMsg = "writeFile:" + a4.errMsg;
                                    n.b(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigameswriteFile:", j2);
            }
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        if (n.a(this.dhs, this.bYi, (JsObject) null, (String) null)) {
            this.dht.y(str);
            n.a(this.bYi, this.dhs.ac(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (n.a(this.dhs, this.bYi, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a = n.a("filePath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a2 = n.a(this.dhs, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a2 != null) {
                final String j = n.j("filePath", a2);
                this.dht.a(new Runnable() { // from class: com.baidu.swan.games.i.e.10
                    @Override // java.lang.Runnable
                    public void run() {
                        final c ac = e.this.dhs.ac(j, false);
                        e.this.bYi.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (n.a(n.a(ac, "unlink:", a2), bVar, hashMap, e.this.bYi)) {
                                    bVar.errMsg = "unlink:" + ac.errMsg;
                                    n.b(bVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesunlink:", j);
            }
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        if (n.a(this.dhs, this.bYi, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = n.a("zipFilePath", jsObject);
            final int a2 = n.a("targetPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dhs, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("zipFilePath", a3);
                final String j2 = n.j("targetPath", a3);
                this.dht.a(new Runnable() { // from class: com.baidu.swan.games.i.e.11
                    @Override // java.lang.Runnable
                    public void run() {
                        final c cr = e.this.dhs.cr(j, j2);
                        e.this.bYi.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "zipFilePath");
                                hashMap.put(Integer.valueOf(a2), "targetPath");
                                if (n.a(n.a(cr, "unzip:", a3), bVar, hashMap, e.this.bYi)) {
                                    bVar.errMsg = "unzip:" + cr.errMsg;
                                    n.b(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamesunzip:", j, j2);
            }
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        return saveFileSync(str, a.USER_DATA_PATH);
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        if (n.a(this.dhs, this.bYi, (JsObject) null, (String) null)) {
            this.dht.y(str, str2);
            c q = this.dhs.q(str, str2, true);
            n.a(this.bYi, q, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (q == null || q.errCode != 0 || q.result == null) {
                return null;
            }
            return q.result.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (n.a(this.dhs, this.bYi, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = n.a("tempFilePath", jsObject);
            final int a2 = n.a("filePath", jsObject);
            if (a2 == 12) {
                a2 = 7;
            }
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dhs, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("tempFilePath", a3);
                final String j2 = n.j("filePath", a3);
                this.dht.a(new Runnable() { // from class: com.baidu.swan.games.i.e.12
                    @Override // java.lang.Runnable
                    public void run() {
                        final c q = e.this.dhs.q(j, j2, false);
                        e.this.bYi.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "tempFilePath");
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(q, "saveFile:", a3), bVar, hashMap, e.this.bYi)) {
                                    com.baidu.swan.games.i.a.g gVar = new com.baidu.swan.games.i.a.g();
                                    gVar.savedFilePath = q.result != null ? q.result.get(0) : null;
                                    gVar.errMsg = q.errMsg;
                                    n.b(gVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamessaveFile:", j, j2);
            }
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        if (n.a(this.dhs, this.bYi, (JsObject) null, (String) null)) {
            this.dht.y(str);
            c ad = this.dhs.ad(str, true);
            n.a(this.bYi, ad, JSExceptionType.Error, "unknown error", "readdirSync:");
            if (ad != null && ad.errCode == 0) {
                int size = ad.result == null ? 0 : ad.result.size();
                return size == 0 ? new String[0] : (String[]) ad.result.toArray(new String[size]);
            }
            return new String[0];
        }
        return null;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        if (n.a(this.dhs, this.bYi, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = n.a("dirPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a2 = n.a(this.dhs, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a2 != null) {
                final String j = n.j("dirPath", a2);
                this.dht.a(new Runnable() { // from class: com.baidu.swan.games.i.e.13
                    @Override // java.lang.Runnable
                    public void run() {
                        final c ad = e.this.dhs.ad(j, false);
                        e.this.bYi.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "dirPath");
                                if (n.a(n.a(ad, "readdir:", a2), bVar, hashMap, e.this.bYi)) {
                                    com.baidu.swan.games.i.a.e eVar = new com.baidu.swan.games.i.a.e();
                                    int size = ad.result == null ? 0 : ad.result.size();
                                    eVar.files = size == 0 ? new String[0] : (String[]) ad.result.toArray(new String[size]);
                                    eVar.errMsg = ad.errMsg;
                                    n.b(eVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesreaddir:", j);
            }
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str) {
        rmdirSync(str, false);
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        if (n.a(this.dhs, this.bYi, (JsObject) null, (String) null)) {
            this.dht.y(str);
            n.a(this.bYi, this.dhs.c(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (n.a(this.dhs, this.bYi, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = n.a("dirPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a2 = n.a(this.dhs, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a2 != null) {
                final String j = n.j("dirPath", a2);
                final Boolean bool = (Boolean) n.a("recursive", a2, Boolean.FALSE);
                this.dht.a(new Runnable() { // from class: com.baidu.swan.games.i.e.14
                    @Override // java.lang.Runnable
                    public void run() {
                        final c c = e.this.dhs.c(j, bool.booleanValue(), false);
                        e.this.bYi.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "dirPath");
                                if (n.a(n.a(c, "rmdir:", a2), bVar, hashMap, e.this.bYi)) {
                                    n.b(bVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesrmdir:", j);
            }
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        if (n.a(this.dhs, this.bYi, (JsObject) null, (String) null)) {
            this.dht.y(str);
            c r = this.dhs.r(str, str2, true);
            n.a(this.bYi, r, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (r == null || r.errCode != 0 || r.result == null) {
                return null;
            }
            return r.result.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (n.a(this.dhs, this.bYi, (JsObject) null, (String) null)) {
            this.dht.y(str);
            c r = this.dhs.r(str, null, true);
            n.a(this.bYi, r, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (r.dhr == null) {
                r.dhr = new byte[0];
            }
            return new JsArrayBuffer(r.dhr, r.dhr.length);
        }
        return null;
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (n.a(this.dhs, this.bYi, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = n.a("filePath", jsObject);
            final int a2 = n.a("encoding", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dhs, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("encoding", a3);
                final String j2 = n.j("filePath", a3);
                this.dht.a(new Runnable() { // from class: com.baidu.swan.games.i.e.15
                    @Override // java.lang.Runnable
                    public void run() {
                        final c r = e.this.dhs.r(j2, j, false);
                        if (a2 != 7 && a2 != 12) {
                            r.errMsg = "fail encoding must be a string";
                            r.errCode = -2;
                            n.a(e.this.bYi, r.errMsg);
                        }
                        e.this.bYi.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (n.a(n.a(r, "readFile:", a3), bVar, hashMap, e.this.bYi)) {
                                    if (TextUtils.isEmpty(j)) {
                                        com.baidu.swan.games.i.a.a aVar = new com.baidu.swan.games.i.a.a();
                                        if (r.dhr == null) {
                                            r.dhr = new byte[0];
                                        }
                                        aVar.data = new JsArrayBuffer(r.dhr, r.dhr.length);
                                        aVar.errMsg = r.errMsg;
                                        n.b(aVar, a3);
                                        return;
                                    }
                                    String str = r.result != null ? r.result.get(0) : null;
                                    com.baidu.swan.games.i.a.f fVar = new com.baidu.swan.games.i.a.f();
                                    fVar.data = str;
                                    fVar.errMsg = r.errMsg;
                                    n.b(fVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamesreadFile:", j2);
            }
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        if (n.a(this.dhs, this.bYi, (JsObject) null, (String) null)) {
            this.dht.y(str, str2);
            n.a(this.bYi, this.dhs.s(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (n.a(this.dhs, this.bYi, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = n.a("oldPath", jsObject);
            final int a2 = n.a("newPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dhs, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("oldPath", a3);
                final String j2 = n.j("newPath", a3);
                this.dht.a(new Runnable() { // from class: com.baidu.swan.games.i.e.16
                    @Override // java.lang.Runnable
                    public void run() {
                        final c s = e.this.dhs.s(j, j2, false);
                        e.this.bYi.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.16.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "oldPath");
                                hashMap.put(Integer.valueOf(a2), "newPath");
                                if (n.a(n.a(s, "rename:", a3), bVar, hashMap, e.this.bYi)) {
                                    n.b(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamesrename:", j, j2);
            }
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        if (n.a(this.dhs, this.bYi, (JsObject) null, (String) null)) {
            this.dht.y(str, str2);
            n.a(this.bYi, this.dhs.t(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (n.a(this.dhs, this.bYi, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = n.a("srcPath", jsObject);
            final int a2 = n.a("destPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dhs, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("srcPath", a3);
                final String j2 = n.j("destPath", a3);
                this.dht.a(new Runnable() { // from class: com.baidu.swan.games.i.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        final c t = e.this.dhs.t(j, j2, false);
                        e.this.bYi.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "srcPath");
                                hashMap.put(Integer.valueOf(a2), "destPath");
                                if (n.a(n.a(t, "copyFile:", a3), bVar, hashMap, e.this.bYi)) {
                                    n.b(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamescopyFile:", j, j2);
            }
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        if (n.a(this.dhs, this.bYi, (JsObject) null, (String) null)) {
            this.dht.y(str);
            n.a(this.bYi, this.dhs.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
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
        if (n.a(this.dhs, this.bYi, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a = n.a("encoding", jsObject);
            final int a2 = n.a("filePath", jsObject);
            int a3 = n.a("data", jsObject);
            final String iU = (a3 == 5 || a3 == 2 || a3 == 3) ? "fail data argument must not be a number" : n.iU(a3);
            final byte[] g = n.g(jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.dhs, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a4 != null) {
                final String j = n.j("data", a4);
                final String j2 = n.j("filePath", a4);
                this.dht.a(new Runnable() { // from class: com.baidu.swan.games.i.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b = e.this.dhs.b(j2, TextUtils.isEmpty(j) ? g : j, n.j("encoding", a4), false);
                        if (!TextUtils.isEmpty(iU)) {
                            b.errMsg = iU;
                            b.errCode = -2;
                            n.a(e.this.bYi, iU);
                        } else if (a != 7 && a != 12) {
                            b.errMsg = "fail encoding must be a string";
                            b.errCode = -2;
                            n.a(e.this.bYi, b.errMsg);
                        }
                        e.this.bYi.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(b, "appendFile:", a4), bVar, hashMap, e.this.bYi)) {
                                    n.b(bVar, a4);
                                }
                            }
                        });
                    }
                }, "aigamesappendFile:", j2);
            }
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        if (n.a(this.dhs, this.bYi, (JsObject) null, (String) null)) {
            this.dht.y(str);
            n.a(this.bYi, this.dhs.ae(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (n.a(this.dhs, this.bYi, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = n.a("path", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a2 = n.a(this.dhs, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a2 != null) {
                final String j = n.j("path", a2);
                this.dht.a(new Runnable() { // from class: com.baidu.swan.games.i.e.4
                    @Override // java.lang.Runnable
                    public void run() {
                        final c ae = e.this.dhs.ae(j, false);
                        e.this.bYi.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "path");
                                if (n.a(n.a(ae, "access:", a2), bVar, hashMap, e.this.bYi)) {
                                    n.b(bVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesaccess:", j);
            }
        }
    }

    @JavascriptInterface
    public j statSync(String str) {
        if (n.a(this.dhs, this.bYi, (JsObject) null, (String) null)) {
            this.dht.y(str);
            c af = this.dhs.af(str, true);
            n.a(this.bYi, af, JSExceptionType.Error, "unknown error", "statSync:");
            if (af == null || af.errCode != 0) {
                return null;
            }
            return af.stats;
        }
        return null;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (n.a(this.dhs, this.bYi, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = n.a("path", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a2 = n.a(this.dhs, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a2 != null) {
                final String j = n.j("path", a2);
                this.dht.a(new Runnable() { // from class: com.baidu.swan.games.i.e.5
                    @Override // java.lang.Runnable
                    public void run() {
                        final c af = e.this.dhs.af(j, false);
                        e.this.bYi.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "path");
                                if (n.a(n.a(af, "stat:", a2), bVar, hashMap, e.this.bYi)) {
                                    com.baidu.swan.games.i.a.h hVar = new com.baidu.swan.games.i.a.h();
                                    hVar.stats = af.stats;
                                    hVar.errMsg = af.errMsg;
                                    n.b(hVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesstat:", j);
            }
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        if (n.a(this.dhs, this.bYi, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a = n.a("filePath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a2 = n.a(this.dhs, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a2 != null) {
                final String j = n.j("filePath", a2);
                this.dht.a(new Runnable() { // from class: com.baidu.swan.games.i.e.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final c sN = e.this.dhs.sN(j);
                        e.this.bYi.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (n.a(n.a(sN, "getFileInfo:", a2), bVar, hashMap, e.this.bYi)) {
                                    com.baidu.swan.games.i.a.c cVar = new com.baidu.swan.games.i.a.c();
                                    cVar.errMsg = "getFileInfo:" + sN.errMsg;
                                    cVar.digest = sN.digest;
                                    cVar.size = (int) sN.size;
                                    n.b(cVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesgetFileInfo:", j);
            }
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        final com.baidu.swan.games.i.a.b bVar;
        final Map<String, Object> a;
        if (n.a(this.dhs, this.bYi, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (a = n.a(this.dhs, jsObject, (bVar = new com.baidu.swan.games.i.a.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.dht.a(new Runnable() { // from class: com.baidu.swan.games.i.e.7
                @Override // java.lang.Runnable
                public void run() {
                    final c aEz = e.this.dhs.aEz();
                    e.this.bYi.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (n.a(n.a(aEz, "getSavedFileList:", a), bVar, (Map<Integer, String>) null, e.this.bYi)) {
                                com.baidu.swan.games.i.a.d dVar = new com.baidu.swan.games.i.a.d();
                                int size = aEz.fileList == null ? 0 : aEz.fileList.size();
                                dVar.fileList = size == 0 ? new d[0] : (d[]) aEz.fileList.toArray(new d[size]);
                                dVar.errMsg = bVar.errMsg;
                                n.b(dVar, a);
                            }
                        }
                    });
                }
            }, "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        if (n.a(this.dhs, this.bYi, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a = n.a("filePath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a2 = n.a(this.dhs, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a2 != null) {
                final String j = n.j("filePath", a2);
                this.dht.a(new Runnable() { // from class: com.baidu.swan.games.i.e.8
                    @Override // java.lang.Runnable
                    public void run() {
                        final c sM = e.this.dhs.sM(j);
                        e.this.bYi.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (n.a(n.a(sM, "removeSavedFile:", a2), bVar, hashMap, e.this.bYi)) {
                                    n.b(bVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesremoveSavedFile:", new String[0]);
            }
        }
    }
}
