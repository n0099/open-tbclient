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
/* loaded from: classes8.dex */
public class e {
    private com.baidu.swan.games.f.a cPO;
    private f ehi;
    private i ehj;

    public e(com.baidu.swan.games.f.a aVar) {
        this.cPO = aVar;
        aWo();
    }

    private void aWo() {
        com.baidu.swan.apps.storage.b.c lVar;
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        if (aIO != null) {
            lVar = aIO.azU();
        } else {
            lVar = new l();
        }
        this.ehi = new f(AppRuntime.getAppContext(), com.baidu.swan.apps.v.f.aAo().azV(), lVar);
        this.ehj = i.aWx();
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        mkdirSync(str, false);
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        if (n.a(this.ehi, this.cPO, (JsObject) null, (String) null)) {
            this.ehj.I(str);
            n.a(this.cPO, this.ehi.b(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (n.a(this.ehi, this.cPO, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a2 = n.a("dirPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.ehi, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a3 != null) {
                final String h = n.h("dirPath", a3);
                final Boolean bool = (Boolean) n.a("recursive", a3, Boolean.FALSE);
                this.ehj.a(new Runnable() { // from class: com.baidu.swan.games.i.e.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b = e.this.ehi.b(h, bool.booleanValue(), false);
                        e.this.cPO.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "dirPath");
                                if (n.a(n.a(b, "mkdir:", a3), bVar, hashMap, e.this.cPO)) {
                                    bVar.errMsg = "mkdir:" + b.errMsg;
                                    n.b(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamesmkdir:", h);
            }
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        if (n.a(this.ehi, this.cPO, (JsObject) null, (String) null)) {
            this.ehj.I(str);
            n.a(this.cPO, this.ehi.a(true, str, (Object) str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2) {
        writeFileSync(str, str2, "");
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        if (n.a(this.ehi, this.cPO, (JsObject) null, (String) null)) {
            this.ehj.I(str);
            n.a(this.cPO, this.ehi.a(true, str, (Object) (jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer()), (String) null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        writeFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (n.a(this.ehi, this.cPO, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a2 = n.a("filePath", jsObject);
            final String lg = n.lg(n.a("data", jsObject));
            final int a3 = n.a("encoding", jsObject);
            final byte[] g = n.g(jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.ehi, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a4 != null) {
                final String h = n.h("data", a4);
                final String h2 = n.h("filePath", a4);
                this.ehj.a(new Runnable() { // from class: com.baidu.swan.games.i.e.9
                    @Override // java.lang.Runnable
                    public void run() {
                        final c a5 = e.this.ehi.a(false, h2, TextUtils.isEmpty(h) ? g : h, n.h("encoding", a4));
                        if (!TextUtils.isEmpty(lg)) {
                            a5.errMsg = lg;
                            a5.errCode = -2;
                            n.a(e.this.cPO, lg);
                        } else if (a3 != 7 && a3 != 12) {
                            a5.errMsg = "fail encoding must be a string";
                            a5.errCode = -2;
                            n.a(e.this.cPO, a5.errMsg);
                        }
                        e.this.cPO.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(a5, "writeFile:", a4), bVar, hashMap, e.this.cPO)) {
                                    bVar.errMsg = "writeFile:" + a5.errMsg;
                                    n.b(bVar, a4);
                                }
                            }
                        });
                    }
                }, "aigameswriteFile:", h2);
            }
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        if (n.a(this.ehi, this.cPO, (JsObject) null, (String) null)) {
            this.ehj.I(str);
            n.a(this.cPO, this.ehi.an(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (n.a(this.ehi, this.cPO, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a2 = n.a("filePath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.ehi, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String h = n.h("filePath", a3);
                this.ehj.a(new Runnable() { // from class: com.baidu.swan.games.i.e.10
                    @Override // java.lang.Runnable
                    public void run() {
                        final c an = e.this.ehi.an(h, false);
                        e.this.cPO.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(an, "unlink:", a3), bVar, hashMap, e.this.cPO)) {
                                    bVar.errMsg = "unlink:" + an.errMsg;
                                    n.b(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamesunlink:", h);
            }
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        if (n.a(this.ehi, this.cPO, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("zipFilePath", jsObject);
            final int a3 = n.a("targetPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.ehi, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (a4 != null) {
                final String h = n.h("zipFilePath", a4);
                final String h2 = n.h("targetPath", a4);
                this.ehj.a(new Runnable() { // from class: com.baidu.swan.games.i.e.11
                    @Override // java.lang.Runnable
                    public void run() {
                        final c cV = e.this.ehi.cV(h, h2);
                        e.this.cPO.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "zipFilePath");
                                hashMap.put(Integer.valueOf(a3), "targetPath");
                                if (n.a(n.a(cV, "unzip:", a4), bVar, hashMap, e.this.cPO)) {
                                    bVar.errMsg = "unzip:" + cV.errMsg;
                                    n.b(bVar, a4);
                                }
                            }
                        });
                    }
                }, "aigamesunzip:", h, h2);
            }
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        return saveFileSync(str, a.USER_DATA_PATH);
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        if (n.a(this.ehi, this.cPO, (JsObject) null, (String) null)) {
            this.ehj.I(str, str2);
            c u = this.ehi.u(str, str2, true);
            n.a(this.cPO, u, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (u == null || u.errCode != 0 || u.result == null) {
                return null;
            }
            return u.result.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (n.a(this.ehi, this.cPO, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("tempFilePath", jsObject);
            final int a3 = n.a("filePath", jsObject);
            if (a3 == 12) {
                a3 = 7;
            }
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.ehi, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (a4 != null) {
                final String h = n.h("tempFilePath", a4);
                final String h2 = n.h("filePath", a4);
                this.ehj.a(new Runnable() { // from class: com.baidu.swan.games.i.e.12
                    @Override // java.lang.Runnable
                    public void run() {
                        final c u = e.this.ehi.u(h, h2, false);
                        e.this.cPO.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "tempFilePath");
                                hashMap.put(Integer.valueOf(a3), "filePath");
                                if (n.a(n.a(u, "saveFile:", a4), bVar, hashMap, e.this.cPO)) {
                                    com.baidu.swan.games.i.a.g gVar = new com.baidu.swan.games.i.a.g();
                                    gVar.savedFilePath = u.result != null ? u.result.get(0) : null;
                                    gVar.errMsg = u.errMsg;
                                    n.b(gVar, a4);
                                }
                            }
                        });
                    }
                }, "aigamessaveFile:", h, h2);
            }
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        if (n.a(this.ehi, this.cPO, (JsObject) null, (String) null)) {
            this.ehj.I(str);
            c ao = this.ehi.ao(str, true);
            n.a(this.cPO, ao, JSExceptionType.Error, "unknown error", "readdirSync:");
            if (ao != null && ao.errCode == 0) {
                int size = ao.result == null ? 0 : ao.result.size();
                return size == 0 ? new String[0] : (String[]) ao.result.toArray(new String[size]);
            }
            return new String[0];
        }
        return null;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        if (n.a(this.ehi, this.cPO, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a2 = n.a("dirPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.ehi, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a3 != null) {
                final String h = n.h("dirPath", a3);
                this.ehj.a(new Runnable() { // from class: com.baidu.swan.games.i.e.13
                    @Override // java.lang.Runnable
                    public void run() {
                        final c ao = e.this.ehi.ao(h, false);
                        e.this.cPO.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "dirPath");
                                if (n.a(n.a(ao, "readdir:", a3), bVar, hashMap, e.this.cPO)) {
                                    com.baidu.swan.games.i.a.e eVar = new com.baidu.swan.games.i.a.e();
                                    int size = ao.result == null ? 0 : ao.result.size();
                                    eVar.files = size == 0 ? new String[0] : (String[]) ao.result.toArray(new String[size]);
                                    eVar.errMsg = ao.errMsg;
                                    n.b(eVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamesreaddir:", h);
            }
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str) {
        rmdirSync(str, false);
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        if (n.a(this.ehi, this.cPO, (JsObject) null, (String) null)) {
            this.ehj.I(str);
            n.a(this.cPO, this.ehi.c(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (n.a(this.ehi, this.cPO, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a2 = n.a("dirPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.ehi, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a3 != null) {
                final String h = n.h("dirPath", a3);
                final Boolean bool = (Boolean) n.a("recursive", a3, Boolean.FALSE);
                this.ehj.a(new Runnable() { // from class: com.baidu.swan.games.i.e.14
                    @Override // java.lang.Runnable
                    public void run() {
                        final c c = e.this.ehi.c(h, bool.booleanValue(), false);
                        e.this.cPO.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "dirPath");
                                if (n.a(n.a(c, "rmdir:", a3), bVar, hashMap, e.this.cPO)) {
                                    n.b(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamesrmdir:", h);
            }
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        if (n.a(this.ehi, this.cPO, (JsObject) null, (String) null)) {
            this.ehj.I(str);
            c v = this.ehi.v(str, str2, true);
            n.a(this.cPO, v, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (v == null || v.errCode != 0 || v.result == null) {
                return null;
            }
            return v.result.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (n.a(this.ehi, this.cPO, (JsObject) null, (String) null)) {
            this.ehj.I(str);
            c v = this.ehi.v(str, null, true);
            n.a(this.cPO, v, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (v.ehh == null) {
                v.ehh = new byte[0];
            }
            return new JsArrayBuffer(v.ehh, v.ehh.length);
        }
        return null;
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (n.a(this.ehi, this.cPO, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a2 = n.a("filePath", jsObject);
            final int a3 = n.a("encoding", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.ehi, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a4 != null) {
                final String h = n.h("encoding", a4);
                final String h2 = n.h("filePath", a4);
                this.ehj.a(new Runnable() { // from class: com.baidu.swan.games.i.e.15
                    @Override // java.lang.Runnable
                    public void run() {
                        final c v = e.this.ehi.v(h2, h, false);
                        if (a3 != 7 && a3 != 12) {
                            v.errMsg = "fail encoding must be a string";
                            v.errCode = -2;
                            n.a(e.this.cPO, v.errMsg);
                        }
                        e.this.cPO.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(v, "readFile:", a4), bVar, hashMap, e.this.cPO)) {
                                    if (TextUtils.isEmpty(h)) {
                                        com.baidu.swan.games.i.a.a aVar = new com.baidu.swan.games.i.a.a();
                                        if (v.ehh == null) {
                                            v.ehh = new byte[0];
                                        }
                                        aVar.data = new JsArrayBuffer(v.ehh, v.ehh.length);
                                        aVar.errMsg = v.errMsg;
                                        n.b(aVar, a4);
                                        return;
                                    }
                                    String str = v.result != null ? v.result.get(0) : null;
                                    com.baidu.swan.games.i.a.f fVar = new com.baidu.swan.games.i.a.f();
                                    fVar.data = str;
                                    fVar.errMsg = v.errMsg;
                                    n.b(fVar, a4);
                                }
                            }
                        });
                    }
                }, "aigamesreadFile:", h2);
            }
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        if (n.a(this.ehi, this.cPO, (JsObject) null, (String) null)) {
            this.ehj.I(str, str2);
            n.a(this.cPO, this.ehi.w(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (n.a(this.ehi, this.cPO, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("oldPath", jsObject);
            final int a3 = n.a("newPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.ehi, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (a4 != null) {
                final String h = n.h("oldPath", a4);
                final String h2 = n.h("newPath", a4);
                this.ehj.a(new Runnable() { // from class: com.baidu.swan.games.i.e.16
                    @Override // java.lang.Runnable
                    public void run() {
                        final c w = e.this.ehi.w(h, h2, false);
                        e.this.cPO.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.16.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "oldPath");
                                hashMap.put(Integer.valueOf(a3), "newPath");
                                if (n.a(n.a(w, "rename:", a4), bVar, hashMap, e.this.cPO)) {
                                    n.b(bVar, a4);
                                }
                            }
                        });
                    }
                }, "aigamesrename:", h, h2);
            }
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        if (n.a(this.ehi, this.cPO, (JsObject) null, (String) null)) {
            this.ehj.I(str, str2);
            n.a(this.cPO, this.ehi.x(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (n.a(this.ehi, this.cPO, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("srcPath", jsObject);
            final int a3 = n.a("destPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.ehi, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (a4 != null) {
                final String h = n.h("srcPath", a4);
                final String h2 = n.h("destPath", a4);
                this.ehj.a(new Runnable() { // from class: com.baidu.swan.games.i.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        final c x = e.this.ehi.x(h, h2, false);
                        e.this.cPO.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "srcPath");
                                hashMap.put(Integer.valueOf(a3), "destPath");
                                if (n.a(n.a(x, "copyFile:", a4), bVar, hashMap, e.this.cPO)) {
                                    n.b(bVar, a4);
                                }
                            }
                        });
                    }
                }, "aigamescopyFile:", h, h2);
            }
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        if (n.a(this.ehi, this.cPO, (JsObject) null, (String) null)) {
            this.ehj.I(str);
            n.a(this.cPO, this.ehi.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
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
        if (n.a(this.ehi, this.cPO, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a2 = n.a("encoding", jsObject);
            final int a3 = n.a("filePath", jsObject);
            int a4 = n.a("data", jsObject);
            final String lg = (a4 == 5 || a4 == 2 || a4 == 3) ? "fail data argument must not be a number" : n.lg(a4);
            final byte[] g = n.g(jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a5 = n.a(this.ehi, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a5 != null) {
                final String h = n.h("data", a5);
                final String h2 = n.h("filePath", a5);
                this.ehj.a(new Runnable() { // from class: com.baidu.swan.games.i.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b = e.this.ehi.b(h2, TextUtils.isEmpty(h) ? g : h, n.h("encoding", a5), false);
                        if (!TextUtils.isEmpty(lg)) {
                            b.errMsg = lg;
                            b.errCode = -2;
                            n.a(e.this.cPO, lg);
                        } else if (a2 != 7 && a2 != 12) {
                            b.errMsg = "fail encoding must be a string";
                            b.errCode = -2;
                            n.a(e.this.cPO, b.errMsg);
                        }
                        e.this.cPO.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a3), "filePath");
                                if (n.a(n.a(b, "appendFile:", a5), bVar, hashMap, e.this.cPO)) {
                                    n.b(bVar, a5);
                                }
                            }
                        });
                    }
                }, "aigamesappendFile:", h2);
            }
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        if (n.a(this.ehi, this.cPO, (JsObject) null, (String) null)) {
            this.ehj.I(str);
            n.a(this.cPO, this.ehi.ap(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (n.a(this.ehi, this.cPO, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("path", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.ehi, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a3 != null) {
                final String h = n.h("path", a3);
                this.ehj.a(new Runnable() { // from class: com.baidu.swan.games.i.e.4
                    @Override // java.lang.Runnable
                    public void run() {
                        final c ap = e.this.ehi.ap(h, false);
                        e.this.cPO.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "path");
                                if (n.a(n.a(ap, "access:", a3), bVar, hashMap, e.this.cPO)) {
                                    n.b(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamesaccess:", h);
            }
        }
    }

    @JavascriptInterface
    public j statSync(String str) {
        if (n.a(this.ehi, this.cPO, (JsObject) null, (String) null)) {
            this.ehj.I(str);
            c aq = this.ehi.aq(str, true);
            n.a(this.cPO, aq, JSExceptionType.Error, "unknown error", "statSync:");
            if (aq == null || aq.errCode != 0) {
                return null;
            }
            return aq.stats;
        }
        return null;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (n.a(this.ehi, this.cPO, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("path", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.ehi, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a3 != null) {
                final String h = n.h("path", a3);
                this.ehj.a(new Runnable() { // from class: com.baidu.swan.games.i.e.5
                    @Override // java.lang.Runnable
                    public void run() {
                        final c aq = e.this.ehi.aq(h, false);
                        e.this.cPO.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "path");
                                if (n.a(n.a(aq, "stat:", a3), bVar, hashMap, e.this.cPO)) {
                                    com.baidu.swan.games.i.a.h hVar = new com.baidu.swan.games.i.a.h();
                                    hVar.stats = aq.stats;
                                    hVar.errMsg = aq.errMsg;
                                    n.b(hVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamesstat:", h);
            }
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        if (n.a(this.ehi, this.cPO, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a2 = n.a("filePath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.ehi, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String h = n.h("filePath", a3);
                this.ehj.a(new Runnable() { // from class: com.baidu.swan.games.i.e.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final c wH = e.this.ehi.wH(h);
                        e.this.cPO.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(wH, "getFileInfo:", a3), bVar, hashMap, e.this.cPO)) {
                                    com.baidu.swan.games.i.a.c cVar = new com.baidu.swan.games.i.a.c();
                                    cVar.errMsg = "getFileInfo:" + wH.errMsg;
                                    cVar.digest = wH.digest;
                                    cVar.size = (int) wH.size;
                                    n.b(cVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamesgetFileInfo:", h);
            }
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        final com.baidu.swan.games.i.a.b bVar;
        final Map<String, Object> a2;
        if (n.a(this.ehi, this.cPO, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (a2 = n.a(this.ehi, jsObject, (bVar = new com.baidu.swan.games.i.a.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.ehj.a(new Runnable() { // from class: com.baidu.swan.games.i.e.7
                @Override // java.lang.Runnable
                public void run() {
                    final c aWp = e.this.ehi.aWp();
                    e.this.cPO.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (n.a(n.a(aWp, "getSavedFileList:", a2), bVar, (Map<Integer, String>) null, e.this.cPO)) {
                                com.baidu.swan.games.i.a.d dVar = new com.baidu.swan.games.i.a.d();
                                int size = aWp.fileList == null ? 0 : aWp.fileList.size();
                                dVar.fileList = size == 0 ? new d[0] : (d[]) aWp.fileList.toArray(new d[size]);
                                dVar.errMsg = bVar.errMsg;
                                n.b(dVar, a2);
                            }
                        }
                    });
                }
            }, "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        if (n.a(this.ehi, this.cPO, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a2 = n.a("filePath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.ehi, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String h = n.h("filePath", a3);
                this.ehj.a(new Runnable() { // from class: com.baidu.swan.games.i.e.8
                    @Override // java.lang.Runnable
                    public void run() {
                        final c wG = e.this.ehi.wG(h);
                        e.this.cPO.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(wG, "removeSavedFile:", a3), bVar, hashMap, e.this.cPO)) {
                                    n.b(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamesremoveSavedFile:", new String[0]);
            }
        }
    }
}
