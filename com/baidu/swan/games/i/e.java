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
/* loaded from: classes10.dex */
public class e {
    private com.baidu.swan.games.f.a cGH;
    private f dTZ;
    private i dUa;

    public e(com.baidu.swan.games.f.a aVar) {
        this.cGH = aVar;
        aVb();
    }

    private void aVb() {
        com.baidu.swan.apps.storage.b.c lVar;
        com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
        if (aHv != null) {
            lVar = aHv.azu();
        } else {
            lVar = new l();
        }
        this.dTZ = new f(AppRuntime.getAppContext(), com.baidu.swan.apps.v.f.azO().azv(), lVar);
        this.dUa = i.aVk();
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        mkdirSync(str, false);
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        if (n.a(this.dTZ, this.cGH, (JsObject) null, (String) null)) {
            this.dUa.B(str);
            n.a(this.cGH, this.dTZ.b(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (n.a(this.dTZ, this.cGH, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a2 = n.a("dirPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dTZ, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("dirPath", a3);
                final Boolean bool = (Boolean) n.a("recursive", a3, Boolean.FALSE);
                this.dUa.a(new Runnable() { // from class: com.baidu.swan.games.i.e.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b = e.this.dTZ.b(j, bool.booleanValue(), false);
                        e.this.cGH.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "dirPath");
                                if (n.a(n.a(b, "mkdir:", a3), bVar, hashMap, e.this.cGH)) {
                                    bVar.errMsg = "mkdir:" + b.errMsg;
                                    n.b(bVar, a3);
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
        if (n.a(this.dTZ, this.cGH, (JsObject) null, (String) null)) {
            this.dUa.B(str);
            n.a(this.cGH, this.dTZ.a(true, str, (Object) str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2) {
        writeFileSync(str, str2, "");
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        if (n.a(this.dTZ, this.cGH, (JsObject) null, (String) null)) {
            this.dUa.B(str);
            n.a(this.cGH, this.dTZ.a(true, str, (Object) (jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer()), (String) null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        writeFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (n.a(this.dTZ, this.cGH, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a2 = n.a("filePath", jsObject);
            final String mg = n.mg(n.a("data", jsObject));
            final int a3 = n.a("encoding", jsObject);
            final byte[] g = n.g(jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.dTZ, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a4 != null) {
                final String j = n.j("data", a4);
                final String j2 = n.j("filePath", a4);
                this.dUa.a(new Runnable() { // from class: com.baidu.swan.games.i.e.9
                    @Override // java.lang.Runnable
                    public void run() {
                        final c a5 = e.this.dTZ.a(false, j2, TextUtils.isEmpty(j) ? g : j, n.j("encoding", a4));
                        if (!TextUtils.isEmpty(mg)) {
                            a5.errMsg = mg;
                            a5.errCode = -2;
                            n.a(e.this.cGH, mg);
                        } else if (a3 != 7 && a3 != 12) {
                            a5.errMsg = "fail encoding must be a string";
                            a5.errCode = -2;
                            n.a(e.this.cGH, a5.errMsg);
                        }
                        e.this.cGH.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(a5, "writeFile:", a4), bVar, hashMap, e.this.cGH)) {
                                    bVar.errMsg = "writeFile:" + a5.errMsg;
                                    n.b(bVar, a4);
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
        if (n.a(this.dTZ, this.cGH, (JsObject) null, (String) null)) {
            this.dUa.B(str);
            n.a(this.cGH, this.dTZ.an(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (n.a(this.dTZ, this.cGH, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a2 = n.a("filePath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dTZ, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("filePath", a3);
                this.dUa.a(new Runnable() { // from class: com.baidu.swan.games.i.e.10
                    @Override // java.lang.Runnable
                    public void run() {
                        final c an = e.this.dTZ.an(j, false);
                        e.this.cGH.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(an, "unlink:", a3), bVar, hashMap, e.this.cGH)) {
                                    bVar.errMsg = "unlink:" + an.errMsg;
                                    n.b(bVar, a3);
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
        if (n.a(this.dTZ, this.cGH, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("zipFilePath", jsObject);
            final int a3 = n.a("targetPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.dTZ, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (a4 != null) {
                final String j = n.j("zipFilePath", a4);
                final String j2 = n.j("targetPath", a4);
                this.dUa.a(new Runnable() { // from class: com.baidu.swan.games.i.e.11
                    @Override // java.lang.Runnable
                    public void run() {
                        final c cX = e.this.dTZ.cX(j, j2);
                        e.this.cGH.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "zipFilePath");
                                hashMap.put(Integer.valueOf(a3), "targetPath");
                                if (n.a(n.a(cX, "unzip:", a4), bVar, hashMap, e.this.cGH)) {
                                    bVar.errMsg = "unzip:" + cX.errMsg;
                                    n.b(bVar, a4);
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
        if (n.a(this.dTZ, this.cGH, (JsObject) null, (String) null)) {
            this.dUa.B(str, str2);
            c r = this.dTZ.r(str, str2, true);
            n.a(this.cGH, r, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (r == null || r.errCode != 0 || r.result == null) {
                return null;
            }
            return r.result.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (n.a(this.dTZ, this.cGH, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("tempFilePath", jsObject);
            final int a3 = n.a("filePath", jsObject);
            if (a3 == 12) {
                a3 = 7;
            }
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.dTZ, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (a4 != null) {
                final String j = n.j("tempFilePath", a4);
                final String j2 = n.j("filePath", a4);
                this.dUa.a(new Runnable() { // from class: com.baidu.swan.games.i.e.12
                    @Override // java.lang.Runnable
                    public void run() {
                        final c r = e.this.dTZ.r(j, j2, false);
                        e.this.cGH.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "tempFilePath");
                                hashMap.put(Integer.valueOf(a3), "filePath");
                                if (n.a(n.a(r, "saveFile:", a4), bVar, hashMap, e.this.cGH)) {
                                    com.baidu.swan.games.i.a.g gVar = new com.baidu.swan.games.i.a.g();
                                    gVar.savedFilePath = r.result != null ? r.result.get(0) : null;
                                    gVar.errMsg = r.errMsg;
                                    n.b(gVar, a4);
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
        if (n.a(this.dTZ, this.cGH, (JsObject) null, (String) null)) {
            this.dUa.B(str);
            c ao = this.dTZ.ao(str, true);
            n.a(this.cGH, ao, JSExceptionType.Error, "unknown error", "readdirSync:");
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
        if (n.a(this.dTZ, this.cGH, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a2 = n.a("dirPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dTZ, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("dirPath", a3);
                this.dUa.a(new Runnable() { // from class: com.baidu.swan.games.i.e.13
                    @Override // java.lang.Runnable
                    public void run() {
                        final c ao = e.this.dTZ.ao(j, false);
                        e.this.cGH.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "dirPath");
                                if (n.a(n.a(ao, "readdir:", a3), bVar, hashMap, e.this.cGH)) {
                                    com.baidu.swan.games.i.a.e eVar = new com.baidu.swan.games.i.a.e();
                                    int size = ao.result == null ? 0 : ao.result.size();
                                    eVar.files = size == 0 ? new String[0] : (String[]) ao.result.toArray(new String[size]);
                                    eVar.errMsg = ao.errMsg;
                                    n.b(eVar, a3);
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
        if (n.a(this.dTZ, this.cGH, (JsObject) null, (String) null)) {
            this.dUa.B(str);
            n.a(this.cGH, this.dTZ.c(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (n.a(this.dTZ, this.cGH, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a2 = n.a("dirPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dTZ, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("dirPath", a3);
                final Boolean bool = (Boolean) n.a("recursive", a3, Boolean.FALSE);
                this.dUa.a(new Runnable() { // from class: com.baidu.swan.games.i.e.14
                    @Override // java.lang.Runnable
                    public void run() {
                        final c c = e.this.dTZ.c(j, bool.booleanValue(), false);
                        e.this.cGH.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "dirPath");
                                if (n.a(n.a(c, "rmdir:", a3), bVar, hashMap, e.this.cGH)) {
                                    n.b(bVar, a3);
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
        if (n.a(this.dTZ, this.cGH, (JsObject) null, (String) null)) {
            this.dUa.B(str);
            c s = this.dTZ.s(str, str2, true);
            n.a(this.cGH, s, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (s == null || s.errCode != 0 || s.result == null) {
                return null;
            }
            return s.result.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (n.a(this.dTZ, this.cGH, (JsObject) null, (String) null)) {
            this.dUa.B(str);
            c s = this.dTZ.s(str, null, true);
            n.a(this.cGH, s, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (s.dTY == null) {
                s.dTY = new byte[0];
            }
            return new JsArrayBuffer(s.dTY, s.dTY.length);
        }
        return null;
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (n.a(this.dTZ, this.cGH, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a2 = n.a("filePath", jsObject);
            final int a3 = n.a("encoding", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.dTZ, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a4 != null) {
                final String j = n.j("encoding", a4);
                final String j2 = n.j("filePath", a4);
                this.dUa.a(new Runnable() { // from class: com.baidu.swan.games.i.e.15
                    @Override // java.lang.Runnable
                    public void run() {
                        final c s = e.this.dTZ.s(j2, j, false);
                        if (a3 != 7 && a3 != 12) {
                            s.errMsg = "fail encoding must be a string";
                            s.errCode = -2;
                            n.a(e.this.cGH, s.errMsg);
                        }
                        e.this.cGH.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(s, "readFile:", a4), bVar, hashMap, e.this.cGH)) {
                                    if (TextUtils.isEmpty(j)) {
                                        com.baidu.swan.games.i.a.a aVar = new com.baidu.swan.games.i.a.a();
                                        if (s.dTY == null) {
                                            s.dTY = new byte[0];
                                        }
                                        aVar.data = new JsArrayBuffer(s.dTY, s.dTY.length);
                                        aVar.errMsg = s.errMsg;
                                        n.b(aVar, a4);
                                        return;
                                    }
                                    String str = s.result != null ? s.result.get(0) : null;
                                    com.baidu.swan.games.i.a.f fVar = new com.baidu.swan.games.i.a.f();
                                    fVar.data = str;
                                    fVar.errMsg = s.errMsg;
                                    n.b(fVar, a4);
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
        if (n.a(this.dTZ, this.cGH, (JsObject) null, (String) null)) {
            this.dUa.B(str, str2);
            n.a(this.cGH, this.dTZ.t(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (n.a(this.dTZ, this.cGH, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("oldPath", jsObject);
            final int a3 = n.a("newPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.dTZ, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (a4 != null) {
                final String j = n.j("oldPath", a4);
                final String j2 = n.j("newPath", a4);
                this.dUa.a(new Runnable() { // from class: com.baidu.swan.games.i.e.16
                    @Override // java.lang.Runnable
                    public void run() {
                        final c t = e.this.dTZ.t(j, j2, false);
                        e.this.cGH.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.16.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "oldPath");
                                hashMap.put(Integer.valueOf(a3), "newPath");
                                if (n.a(n.a(t, "rename:", a4), bVar, hashMap, e.this.cGH)) {
                                    n.b(bVar, a4);
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
        if (n.a(this.dTZ, this.cGH, (JsObject) null, (String) null)) {
            this.dUa.B(str, str2);
            n.a(this.cGH, this.dTZ.u(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (n.a(this.dTZ, this.cGH, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("srcPath", jsObject);
            final int a3 = n.a("destPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.dTZ, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (a4 != null) {
                final String j = n.j("srcPath", a4);
                final String j2 = n.j("destPath", a4);
                this.dUa.a(new Runnable() { // from class: com.baidu.swan.games.i.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        final c u = e.this.dTZ.u(j, j2, false);
                        e.this.cGH.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "srcPath");
                                hashMap.put(Integer.valueOf(a3), "destPath");
                                if (n.a(n.a(u, "copyFile:", a4), bVar, hashMap, e.this.cGH)) {
                                    n.b(bVar, a4);
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
        if (n.a(this.dTZ, this.cGH, (JsObject) null, (String) null)) {
            this.dUa.B(str);
            n.a(this.cGH, this.dTZ.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
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
        if (n.a(this.dTZ, this.cGH, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a2 = n.a("encoding", jsObject);
            final int a3 = n.a("filePath", jsObject);
            int a4 = n.a("data", jsObject);
            final String mg = (a4 == 5 || a4 == 2 || a4 == 3) ? "fail data argument must not be a number" : n.mg(a4);
            final byte[] g = n.g(jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a5 = n.a(this.dTZ, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a5 != null) {
                final String j = n.j("data", a5);
                final String j2 = n.j("filePath", a5);
                this.dUa.a(new Runnable() { // from class: com.baidu.swan.games.i.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b = e.this.dTZ.b(j2, TextUtils.isEmpty(j) ? g : j, n.j("encoding", a5), false);
                        if (!TextUtils.isEmpty(mg)) {
                            b.errMsg = mg;
                            b.errCode = -2;
                            n.a(e.this.cGH, mg);
                        } else if (a2 != 7 && a2 != 12) {
                            b.errMsg = "fail encoding must be a string";
                            b.errCode = -2;
                            n.a(e.this.cGH, b.errMsg);
                        }
                        e.this.cGH.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a3), "filePath");
                                if (n.a(n.a(b, "appendFile:", a5), bVar, hashMap, e.this.cGH)) {
                                    n.b(bVar, a5);
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
        if (n.a(this.dTZ, this.cGH, (JsObject) null, (String) null)) {
            this.dUa.B(str);
            n.a(this.cGH, this.dTZ.ap(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (n.a(this.dTZ, this.cGH, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("path", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dTZ, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("path", a3);
                this.dUa.a(new Runnable() { // from class: com.baidu.swan.games.i.e.4
                    @Override // java.lang.Runnable
                    public void run() {
                        final c ap = e.this.dTZ.ap(j, false);
                        e.this.cGH.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "path");
                                if (n.a(n.a(ap, "access:", a3), bVar, hashMap, e.this.cGH)) {
                                    n.b(bVar, a3);
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
        if (n.a(this.dTZ, this.cGH, (JsObject) null, (String) null)) {
            this.dUa.B(str);
            c aq = this.dTZ.aq(str, true);
            n.a(this.cGH, aq, JSExceptionType.Error, "unknown error", "statSync:");
            if (aq == null || aq.errCode != 0) {
                return null;
            }
            return aq.stats;
        }
        return null;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (n.a(this.dTZ, this.cGH, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("path", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dTZ, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("path", a3);
                this.dUa.a(new Runnable() { // from class: com.baidu.swan.games.i.e.5
                    @Override // java.lang.Runnable
                    public void run() {
                        final c aq = e.this.dTZ.aq(j, false);
                        e.this.cGH.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "path");
                                if (n.a(n.a(aq, "stat:", a3), bVar, hashMap, e.this.cGH)) {
                                    com.baidu.swan.games.i.a.h hVar = new com.baidu.swan.games.i.a.h();
                                    hVar.stats = aq.stats;
                                    hVar.errMsg = aq.errMsg;
                                    n.b(hVar, a3);
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
        if (n.a(this.dTZ, this.cGH, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a2 = n.a("filePath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dTZ, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("filePath", a3);
                this.dUa.a(new Runnable() { // from class: com.baidu.swan.games.i.e.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final c wR = e.this.dTZ.wR(j);
                        e.this.cGH.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(wR, "getFileInfo:", a3), bVar, hashMap, e.this.cGH)) {
                                    com.baidu.swan.games.i.a.c cVar = new com.baidu.swan.games.i.a.c();
                                    cVar.errMsg = "getFileInfo:" + wR.errMsg;
                                    cVar.digest = wR.digest;
                                    cVar.size = (int) wR.size;
                                    n.b(cVar, a3);
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
        final Map<String, Object> a2;
        if (n.a(this.dTZ, this.cGH, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (a2 = n.a(this.dTZ, jsObject, (bVar = new com.baidu.swan.games.i.a.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.dUa.a(new Runnable() { // from class: com.baidu.swan.games.i.e.7
                @Override // java.lang.Runnable
                public void run() {
                    final c aVc = e.this.dTZ.aVc();
                    e.this.cGH.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (n.a(n.a(aVc, "getSavedFileList:", a2), bVar, (Map<Integer, String>) null, e.this.cGH)) {
                                com.baidu.swan.games.i.a.d dVar = new com.baidu.swan.games.i.a.d();
                                int size = aVc.fileList == null ? 0 : aVc.fileList.size();
                                dVar.fileList = size == 0 ? new d[0] : (d[]) aVc.fileList.toArray(new d[size]);
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
        if (n.a(this.dTZ, this.cGH, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a2 = n.a("filePath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dTZ, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("filePath", a3);
                this.dUa.a(new Runnable() { // from class: com.baidu.swan.games.i.e.8
                    @Override // java.lang.Runnable
                    public void run() {
                        final c wQ = e.this.dTZ.wQ(j);
                        e.this.cGH.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(wQ, "removeSavedFile:", a3), bVar, hashMap, e.this.cGH)) {
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
