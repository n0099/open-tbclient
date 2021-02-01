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
/* loaded from: classes9.dex */
public class e {
    private com.baidu.swan.games.f.a cOo;
    private f efG;
    private i efH;

    public e(com.baidu.swan.games.f.a aVar) {
        this.cOo = aVar;
        aWl();
    }

    private void aWl() {
        com.baidu.swan.apps.storage.b.c lVar;
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        if (aIL != null) {
            lVar = aIL.azR();
        } else {
            lVar = new l();
        }
        this.efG = new f(AppRuntime.getAppContext(), com.baidu.swan.apps.v.f.aAl().azS(), lVar);
        this.efH = i.aWu();
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        mkdirSync(str, false);
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        if (n.a(this.efG, this.cOo, (JsObject) null, (String) null)) {
            this.efH.I(str);
            n.a(this.cOo, this.efG.b(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (n.a(this.efG, this.cOo, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a2 = n.a("dirPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.efG, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a3 != null) {
                final String h = n.h("dirPath", a3);
                final Boolean bool = (Boolean) n.a("recursive", a3, Boolean.FALSE);
                this.efH.a(new Runnable() { // from class: com.baidu.swan.games.i.e.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b2 = e.this.efG.b(h, bool.booleanValue(), false);
                        e.this.cOo.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "dirPath");
                                if (n.a(n.a(b2, "mkdir:", a3), bVar, hashMap, e.this.cOo)) {
                                    bVar.errMsg = "mkdir:" + b2.errMsg;
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
        if (n.a(this.efG, this.cOo, (JsObject) null, (String) null)) {
            this.efH.I(str);
            n.a(this.cOo, this.efG.a(true, str, (Object) str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2) {
        writeFileSync(str, str2, "");
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        if (n.a(this.efG, this.cOo, (JsObject) null, (String) null)) {
            this.efH.I(str);
            n.a(this.cOo, this.efG.a(true, str, (Object) (jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer()), (String) null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        writeFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (n.a(this.efG, this.cOo, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a2 = n.a("filePath", jsObject);
            final String lf = n.lf(n.a("data", jsObject));
            final int a3 = n.a("encoding", jsObject);
            final byte[] g = n.g(jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.efG, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a4 != null) {
                final String h = n.h("data", a4);
                final String h2 = n.h("filePath", a4);
                this.efH.a(new Runnable() { // from class: com.baidu.swan.games.i.e.9
                    @Override // java.lang.Runnable
                    public void run() {
                        final c a5 = e.this.efG.a(false, h2, TextUtils.isEmpty(h) ? g : h, n.h("encoding", a4));
                        if (!TextUtils.isEmpty(lf)) {
                            a5.errMsg = lf;
                            a5.errCode = -2;
                            n.a(e.this.cOo, lf);
                        } else if (a3 != 7 && a3 != 12) {
                            a5.errMsg = "fail encoding must be a string";
                            a5.errCode = -2;
                            n.a(e.this.cOo, a5.errMsg);
                        }
                        e.this.cOo.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(a5, "writeFile:", a4), bVar, hashMap, e.this.cOo)) {
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
        if (n.a(this.efG, this.cOo, (JsObject) null, (String) null)) {
            this.efH.I(str);
            n.a(this.cOo, this.efG.an(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (n.a(this.efG, this.cOo, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a2 = n.a("filePath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.efG, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String h = n.h("filePath", a3);
                this.efH.a(new Runnable() { // from class: com.baidu.swan.games.i.e.10
                    @Override // java.lang.Runnable
                    public void run() {
                        final c an = e.this.efG.an(h, false);
                        e.this.cOo.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(an, "unlink:", a3), bVar, hashMap, e.this.cOo)) {
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
        if (n.a(this.efG, this.cOo, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("zipFilePath", jsObject);
            final int a3 = n.a("targetPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.efG, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (a4 != null) {
                final String h = n.h("zipFilePath", a4);
                final String h2 = n.h("targetPath", a4);
                this.efH.a(new Runnable() { // from class: com.baidu.swan.games.i.e.11
                    @Override // java.lang.Runnable
                    public void run() {
                        final c cV = e.this.efG.cV(h, h2);
                        e.this.cOo.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "zipFilePath");
                                hashMap.put(Integer.valueOf(a3), "targetPath");
                                if (n.a(n.a(cV, "unzip:", a4), bVar, hashMap, e.this.cOo)) {
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
        if (n.a(this.efG, this.cOo, (JsObject) null, (String) null)) {
            this.efH.I(str, str2);
            c u = this.efG.u(str, str2, true);
            n.a(this.cOo, u, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (u == null || u.errCode != 0 || u.result == null) {
                return null;
            }
            return u.result.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (n.a(this.efG, this.cOo, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("tempFilePath", jsObject);
            final int a3 = n.a("filePath", jsObject);
            if (a3 == 12) {
                a3 = 7;
            }
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.efG, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (a4 != null) {
                final String h = n.h("tempFilePath", a4);
                final String h2 = n.h("filePath", a4);
                this.efH.a(new Runnable() { // from class: com.baidu.swan.games.i.e.12
                    @Override // java.lang.Runnable
                    public void run() {
                        final c u = e.this.efG.u(h, h2, false);
                        e.this.cOo.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "tempFilePath");
                                hashMap.put(Integer.valueOf(a3), "filePath");
                                if (n.a(n.a(u, "saveFile:", a4), bVar, hashMap, e.this.cOo)) {
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
        if (n.a(this.efG, this.cOo, (JsObject) null, (String) null)) {
            this.efH.I(str);
            c ao = this.efG.ao(str, true);
            n.a(this.cOo, ao, JSExceptionType.Error, "unknown error", "readdirSync:");
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
        if (n.a(this.efG, this.cOo, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a2 = n.a("dirPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.efG, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a3 != null) {
                final String h = n.h("dirPath", a3);
                this.efH.a(new Runnable() { // from class: com.baidu.swan.games.i.e.13
                    @Override // java.lang.Runnable
                    public void run() {
                        final c ao = e.this.efG.ao(h, false);
                        e.this.cOo.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "dirPath");
                                if (n.a(n.a(ao, "readdir:", a3), bVar, hashMap, e.this.cOo)) {
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
        if (n.a(this.efG, this.cOo, (JsObject) null, (String) null)) {
            this.efH.I(str);
            n.a(this.cOo, this.efG.c(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (n.a(this.efG, this.cOo, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a2 = n.a("dirPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.efG, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a3 != null) {
                final String h = n.h("dirPath", a3);
                final Boolean bool = (Boolean) n.a("recursive", a3, Boolean.FALSE);
                this.efH.a(new Runnable() { // from class: com.baidu.swan.games.i.e.14
                    @Override // java.lang.Runnable
                    public void run() {
                        final c c = e.this.efG.c(h, bool.booleanValue(), false);
                        e.this.cOo.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "dirPath");
                                if (n.a(n.a(c, "rmdir:", a3), bVar, hashMap, e.this.cOo)) {
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
        if (n.a(this.efG, this.cOo, (JsObject) null, (String) null)) {
            this.efH.I(str);
            c v = this.efG.v(str, str2, true);
            n.a(this.cOo, v, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (v == null || v.errCode != 0 || v.result == null) {
                return null;
            }
            return v.result.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (n.a(this.efG, this.cOo, (JsObject) null, (String) null)) {
            this.efH.I(str);
            c v = this.efG.v(str, null, true);
            n.a(this.cOo, v, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (v.efF == null) {
                v.efF = new byte[0];
            }
            return new JsArrayBuffer(v.efF, v.efF.length);
        }
        return null;
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (n.a(this.efG, this.cOo, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a2 = n.a("filePath", jsObject);
            final int a3 = n.a("encoding", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.efG, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a4 != null) {
                final String h = n.h("encoding", a4);
                final String h2 = n.h("filePath", a4);
                this.efH.a(new Runnable() { // from class: com.baidu.swan.games.i.e.15
                    @Override // java.lang.Runnable
                    public void run() {
                        final c v = e.this.efG.v(h2, h, false);
                        if (a3 != 7 && a3 != 12) {
                            v.errMsg = "fail encoding must be a string";
                            v.errCode = -2;
                            n.a(e.this.cOo, v.errMsg);
                        }
                        e.this.cOo.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(v, "readFile:", a4), bVar, hashMap, e.this.cOo)) {
                                    if (TextUtils.isEmpty(h)) {
                                        com.baidu.swan.games.i.a.a aVar = new com.baidu.swan.games.i.a.a();
                                        if (v.efF == null) {
                                            v.efF = new byte[0];
                                        }
                                        aVar.data = new JsArrayBuffer(v.efF, v.efF.length);
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
        if (n.a(this.efG, this.cOo, (JsObject) null, (String) null)) {
            this.efH.I(str, str2);
            n.a(this.cOo, this.efG.w(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (n.a(this.efG, this.cOo, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("oldPath", jsObject);
            final int a3 = n.a("newPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.efG, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (a4 != null) {
                final String h = n.h("oldPath", a4);
                final String h2 = n.h("newPath", a4);
                this.efH.a(new Runnable() { // from class: com.baidu.swan.games.i.e.16
                    @Override // java.lang.Runnable
                    public void run() {
                        final c w = e.this.efG.w(h, h2, false);
                        e.this.cOo.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.16.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "oldPath");
                                hashMap.put(Integer.valueOf(a3), "newPath");
                                if (n.a(n.a(w, "rename:", a4), bVar, hashMap, e.this.cOo)) {
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
        if (n.a(this.efG, this.cOo, (JsObject) null, (String) null)) {
            this.efH.I(str, str2);
            n.a(this.cOo, this.efG.x(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (n.a(this.efG, this.cOo, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("srcPath", jsObject);
            final int a3 = n.a("destPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.efG, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (a4 != null) {
                final String h = n.h("srcPath", a4);
                final String h2 = n.h("destPath", a4);
                this.efH.a(new Runnable() { // from class: com.baidu.swan.games.i.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        final c x = e.this.efG.x(h, h2, false);
                        e.this.cOo.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "srcPath");
                                hashMap.put(Integer.valueOf(a3), "destPath");
                                if (n.a(n.a(x, "copyFile:", a4), bVar, hashMap, e.this.cOo)) {
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
        if (n.a(this.efG, this.cOo, (JsObject) null, (String) null)) {
            this.efH.I(str);
            n.a(this.cOo, this.efG.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
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
        if (n.a(this.efG, this.cOo, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a2 = n.a("encoding", jsObject);
            final int a3 = n.a("filePath", jsObject);
            int a4 = n.a("data", jsObject);
            final String lf = (a4 == 5 || a4 == 2 || a4 == 3) ? "fail data argument must not be a number" : n.lf(a4);
            final byte[] g = n.g(jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a5 = n.a(this.efG, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a5 != null) {
                final String h = n.h("data", a5);
                final String h2 = n.h("filePath", a5);
                this.efH.a(new Runnable() { // from class: com.baidu.swan.games.i.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b2 = e.this.efG.b(h2, TextUtils.isEmpty(h) ? g : h, n.h("encoding", a5), false);
                        if (!TextUtils.isEmpty(lf)) {
                            b2.errMsg = lf;
                            b2.errCode = -2;
                            n.a(e.this.cOo, lf);
                        } else if (a2 != 7 && a2 != 12) {
                            b2.errMsg = "fail encoding must be a string";
                            b2.errCode = -2;
                            n.a(e.this.cOo, b2.errMsg);
                        }
                        e.this.cOo.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a3), "filePath");
                                if (n.a(n.a(b2, "appendFile:", a5), bVar, hashMap, e.this.cOo)) {
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
        if (n.a(this.efG, this.cOo, (JsObject) null, (String) null)) {
            this.efH.I(str);
            n.a(this.cOo, this.efG.ap(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (n.a(this.efG, this.cOo, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("path", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.efG, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a3 != null) {
                final String h = n.h("path", a3);
                this.efH.a(new Runnable() { // from class: com.baidu.swan.games.i.e.4
                    @Override // java.lang.Runnable
                    public void run() {
                        final c ap = e.this.efG.ap(h, false);
                        e.this.cOo.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "path");
                                if (n.a(n.a(ap, "access:", a3), bVar, hashMap, e.this.cOo)) {
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
        if (n.a(this.efG, this.cOo, (JsObject) null, (String) null)) {
            this.efH.I(str);
            c aq = this.efG.aq(str, true);
            n.a(this.cOo, aq, JSExceptionType.Error, "unknown error", "statSync:");
            if (aq == null || aq.errCode != 0) {
                return null;
            }
            return aq.stats;
        }
        return null;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (n.a(this.efG, this.cOo, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("path", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.efG, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a3 != null) {
                final String h = n.h("path", a3);
                this.efH.a(new Runnable() { // from class: com.baidu.swan.games.i.e.5
                    @Override // java.lang.Runnable
                    public void run() {
                        final c aq = e.this.efG.aq(h, false);
                        e.this.cOo.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "path");
                                if (n.a(n.a(aq, "stat:", a3), bVar, hashMap, e.this.cOo)) {
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
        if (n.a(this.efG, this.cOo, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a2 = n.a("filePath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.efG, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String h = n.h("filePath", a3);
                this.efH.a(new Runnable() { // from class: com.baidu.swan.games.i.e.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final c wA = e.this.efG.wA(h);
                        e.this.cOo.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(wA, "getFileInfo:", a3), bVar, hashMap, e.this.cOo)) {
                                    com.baidu.swan.games.i.a.c cVar = new com.baidu.swan.games.i.a.c();
                                    cVar.errMsg = "getFileInfo:" + wA.errMsg;
                                    cVar.digest = wA.digest;
                                    cVar.size = (int) wA.size;
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
        if (n.a(this.efG, this.cOo, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (a2 = n.a(this.efG, jsObject, (bVar = new com.baidu.swan.games.i.a.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.efH.a(new Runnable() { // from class: com.baidu.swan.games.i.e.7
                @Override // java.lang.Runnable
                public void run() {
                    final c aWm = e.this.efG.aWm();
                    e.this.cOo.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (n.a(n.a(aWm, "getSavedFileList:", a2), bVar, (Map<Integer, String>) null, e.this.cOo)) {
                                com.baidu.swan.games.i.a.d dVar = new com.baidu.swan.games.i.a.d();
                                int size = aWm.fileList == null ? 0 : aWm.fileList.size();
                                dVar.fileList = size == 0 ? new d[0] : (d[]) aWm.fileList.toArray(new d[size]);
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
        if (n.a(this.efG, this.cOo, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a2 = n.a("filePath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.efG, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String h = n.h("filePath", a3);
                this.efH.a(new Runnable() { // from class: com.baidu.swan.games.i.e.8
                    @Override // java.lang.Runnable
                    public void run() {
                        final c wz = e.this.efG.wz(h);
                        e.this.cOo.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(wz, "removeSavedFile:", a3), bVar, hashMap, e.this.cOo)) {
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
