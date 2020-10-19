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
    private com.baidu.swan.games.f.a cso;
    private f dFK;
    private i dFL;

    public e(com.baidu.swan.games.f.a aVar) {
        this.cso = aVar;
        aQH();
    }

    private void aQH() {
        com.baidu.swan.apps.storage.b.c lVar;
        com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        if (aDb != null) {
            lVar = aDb.ava();
        } else {
            lVar = new l();
        }
        this.dFK = new f(AppRuntime.getAppContext(), com.baidu.swan.apps.v.f.avu().avb(), lVar);
        this.dFL = i.aQQ();
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        mkdirSync(str, false);
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        if (n.a(this.dFK, this.cso, (JsObject) null, (String) null)) {
            this.dFL.A(str);
            n.a(this.cso, this.dFK.b(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (n.a(this.dFK, this.cso, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a2 = n.a("dirPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dFK, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("dirPath", a3);
                final Boolean bool = (Boolean) n.a("recursive", a3, Boolean.FALSE);
                this.dFL.a(new Runnable() { // from class: com.baidu.swan.games.i.e.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b = e.this.dFK.b(j, bool.booleanValue(), false);
                        e.this.cso.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "dirPath");
                                if (n.a(n.a(b, "mkdir:", a3), bVar, hashMap, e.this.cso)) {
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
        if (n.a(this.dFK, this.cso, (JsObject) null, (String) null)) {
            this.dFL.A(str);
            n.a(this.cso, this.dFK.a(true, str, (Object) str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2) {
        writeFileSync(str, str2, "");
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        if (n.a(this.dFK, this.cso, (JsObject) null, (String) null)) {
            this.dFL.A(str);
            n.a(this.cso, this.dFK.a(true, str, (Object) (jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer()), (String) null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        writeFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (n.a(this.dFK, this.cso, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a2 = n.a("filePath", jsObject);
            final String lL = n.lL(n.a("data", jsObject));
            final int a3 = n.a("encoding", jsObject);
            final byte[] g = n.g(jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.dFK, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a4 != null) {
                final String j = n.j("data", a4);
                final String j2 = n.j("filePath", a4);
                this.dFL.a(new Runnable() { // from class: com.baidu.swan.games.i.e.9
                    @Override // java.lang.Runnable
                    public void run() {
                        final c a5 = e.this.dFK.a(false, j2, TextUtils.isEmpty(j) ? g : j, n.j("encoding", a4));
                        if (!TextUtils.isEmpty(lL)) {
                            a5.errMsg = lL;
                            a5.errCode = -2;
                            n.a(e.this.cso, lL);
                        } else if (a3 != 7 && a3 != 12) {
                            a5.errMsg = "fail encoding must be a string";
                            a5.errCode = -2;
                            n.a(e.this.cso, a5.errMsg);
                        }
                        e.this.cso.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(a5, "writeFile:", a4), bVar, hashMap, e.this.cso)) {
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
        if (n.a(this.dFK, this.cso, (JsObject) null, (String) null)) {
            this.dFL.A(str);
            n.a(this.cso, this.dFK.al(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (n.a(this.dFK, this.cso, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a2 = n.a("filePath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dFK, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("filePath", a3);
                this.dFL.a(new Runnable() { // from class: com.baidu.swan.games.i.e.10
                    @Override // java.lang.Runnable
                    public void run() {
                        final c al = e.this.dFK.al(j, false);
                        e.this.cso.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(al, "unlink:", a3), bVar, hashMap, e.this.cso)) {
                                    bVar.errMsg = "unlink:" + al.errMsg;
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
        if (n.a(this.dFK, this.cso, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("zipFilePath", jsObject);
            final int a3 = n.a("targetPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.dFK, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (a4 != null) {
                final String j = n.j("zipFilePath", a4);
                final String j2 = n.j("targetPath", a4);
                this.dFL.a(new Runnable() { // from class: com.baidu.swan.games.i.e.11
                    @Override // java.lang.Runnable
                    public void run() {
                        final c cQ = e.this.dFK.cQ(j, j2);
                        e.this.cso.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "zipFilePath");
                                hashMap.put(Integer.valueOf(a3), "targetPath");
                                if (n.a(n.a(cQ, "unzip:", a4), bVar, hashMap, e.this.cso)) {
                                    bVar.errMsg = "unzip:" + cQ.errMsg;
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
        if (n.a(this.dFK, this.cso, (JsObject) null, (String) null)) {
            this.dFL.A(str, str2);
            c q = this.dFK.q(str, str2, true);
            n.a(this.cso, q, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (q == null || q.errCode != 0 || q.result == null) {
                return null;
            }
            return q.result.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (n.a(this.dFK, this.cso, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("tempFilePath", jsObject);
            final int a3 = n.a("filePath", jsObject);
            if (a3 == 12) {
                a3 = 7;
            }
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.dFK, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (a4 != null) {
                final String j = n.j("tempFilePath", a4);
                final String j2 = n.j("filePath", a4);
                this.dFL.a(new Runnable() { // from class: com.baidu.swan.games.i.e.12
                    @Override // java.lang.Runnable
                    public void run() {
                        final c q = e.this.dFK.q(j, j2, false);
                        e.this.cso.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "tempFilePath");
                                hashMap.put(Integer.valueOf(a3), "filePath");
                                if (n.a(n.a(q, "saveFile:", a4), bVar, hashMap, e.this.cso)) {
                                    com.baidu.swan.games.i.a.g gVar = new com.baidu.swan.games.i.a.g();
                                    gVar.savedFilePath = q.result != null ? q.result.get(0) : null;
                                    gVar.errMsg = q.errMsg;
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
        if (n.a(this.dFK, this.cso, (JsObject) null, (String) null)) {
            this.dFL.A(str);
            c am = this.dFK.am(str, true);
            n.a(this.cso, am, JSExceptionType.Error, "unknown error", "readdirSync:");
            if (am != null && am.errCode == 0) {
                int size = am.result == null ? 0 : am.result.size();
                return size == 0 ? new String[0] : (String[]) am.result.toArray(new String[size]);
            }
            return new String[0];
        }
        return null;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        if (n.a(this.dFK, this.cso, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a2 = n.a("dirPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dFK, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("dirPath", a3);
                this.dFL.a(new Runnable() { // from class: com.baidu.swan.games.i.e.13
                    @Override // java.lang.Runnable
                    public void run() {
                        final c am = e.this.dFK.am(j, false);
                        e.this.cso.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "dirPath");
                                if (n.a(n.a(am, "readdir:", a3), bVar, hashMap, e.this.cso)) {
                                    com.baidu.swan.games.i.a.e eVar = new com.baidu.swan.games.i.a.e();
                                    int size = am.result == null ? 0 : am.result.size();
                                    eVar.files = size == 0 ? new String[0] : (String[]) am.result.toArray(new String[size]);
                                    eVar.errMsg = am.errMsg;
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
        if (n.a(this.dFK, this.cso, (JsObject) null, (String) null)) {
            this.dFL.A(str);
            n.a(this.cso, this.dFK.c(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (n.a(this.dFK, this.cso, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a2 = n.a("dirPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dFK, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("dirPath", a3);
                final Boolean bool = (Boolean) n.a("recursive", a3, Boolean.FALSE);
                this.dFL.a(new Runnable() { // from class: com.baidu.swan.games.i.e.14
                    @Override // java.lang.Runnable
                    public void run() {
                        final c c = e.this.dFK.c(j, bool.booleanValue(), false);
                        e.this.cso.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "dirPath");
                                if (n.a(n.a(c, "rmdir:", a3), bVar, hashMap, e.this.cso)) {
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
        if (n.a(this.dFK, this.cso, (JsObject) null, (String) null)) {
            this.dFL.A(str);
            c r = this.dFK.r(str, str2, true);
            n.a(this.cso, r, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (r == null || r.errCode != 0 || r.result == null) {
                return null;
            }
            return r.result.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (n.a(this.dFK, this.cso, (JsObject) null, (String) null)) {
            this.dFL.A(str);
            c r = this.dFK.r(str, null, true);
            n.a(this.cso, r, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (r.dFJ == null) {
                r.dFJ = new byte[0];
            }
            return new JsArrayBuffer(r.dFJ, r.dFJ.length);
        }
        return null;
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (n.a(this.dFK, this.cso, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a2 = n.a("filePath", jsObject);
            final int a3 = n.a("encoding", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.dFK, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a4 != null) {
                final String j = n.j("encoding", a4);
                final String j2 = n.j("filePath", a4);
                this.dFL.a(new Runnable() { // from class: com.baidu.swan.games.i.e.15
                    @Override // java.lang.Runnable
                    public void run() {
                        final c r = e.this.dFK.r(j2, j, false);
                        if (a3 != 7 && a3 != 12) {
                            r.errMsg = "fail encoding must be a string";
                            r.errCode = -2;
                            n.a(e.this.cso, r.errMsg);
                        }
                        e.this.cso.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(r, "readFile:", a4), bVar, hashMap, e.this.cso)) {
                                    if (TextUtils.isEmpty(j)) {
                                        com.baidu.swan.games.i.a.a aVar = new com.baidu.swan.games.i.a.a();
                                        if (r.dFJ == null) {
                                            r.dFJ = new byte[0];
                                        }
                                        aVar.data = new JsArrayBuffer(r.dFJ, r.dFJ.length);
                                        aVar.errMsg = r.errMsg;
                                        n.b(aVar, a4);
                                        return;
                                    }
                                    String str = r.result != null ? r.result.get(0) : null;
                                    com.baidu.swan.games.i.a.f fVar = new com.baidu.swan.games.i.a.f();
                                    fVar.data = str;
                                    fVar.errMsg = r.errMsg;
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
        if (n.a(this.dFK, this.cso, (JsObject) null, (String) null)) {
            this.dFL.A(str, str2);
            n.a(this.cso, this.dFK.s(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (n.a(this.dFK, this.cso, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("oldPath", jsObject);
            final int a3 = n.a("newPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.dFK, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (a4 != null) {
                final String j = n.j("oldPath", a4);
                final String j2 = n.j("newPath", a4);
                this.dFL.a(new Runnable() { // from class: com.baidu.swan.games.i.e.16
                    @Override // java.lang.Runnable
                    public void run() {
                        final c s = e.this.dFK.s(j, j2, false);
                        e.this.cso.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.16.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "oldPath");
                                hashMap.put(Integer.valueOf(a3), "newPath");
                                if (n.a(n.a(s, "rename:", a4), bVar, hashMap, e.this.cso)) {
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
        if (n.a(this.dFK, this.cso, (JsObject) null, (String) null)) {
            this.dFL.A(str, str2);
            n.a(this.cso, this.dFK.t(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (n.a(this.dFK, this.cso, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("srcPath", jsObject);
            final int a3 = n.a("destPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.dFK, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (a4 != null) {
                final String j = n.j("srcPath", a4);
                final String j2 = n.j("destPath", a4);
                this.dFL.a(new Runnable() { // from class: com.baidu.swan.games.i.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        final c t = e.this.dFK.t(j, j2, false);
                        e.this.cso.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "srcPath");
                                hashMap.put(Integer.valueOf(a3), "destPath");
                                if (n.a(n.a(t, "copyFile:", a4), bVar, hashMap, e.this.cso)) {
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
        if (n.a(this.dFK, this.cso, (JsObject) null, (String) null)) {
            this.dFL.A(str);
            n.a(this.cso, this.dFK.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
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
        if (n.a(this.dFK, this.cso, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a2 = n.a("encoding", jsObject);
            final int a3 = n.a("filePath", jsObject);
            int a4 = n.a("data", jsObject);
            final String lL = (a4 == 5 || a4 == 2 || a4 == 3) ? "fail data argument must not be a number" : n.lL(a4);
            final byte[] g = n.g(jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a5 = n.a(this.dFK, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a5 != null) {
                final String j = n.j("data", a5);
                final String j2 = n.j("filePath", a5);
                this.dFL.a(new Runnable() { // from class: com.baidu.swan.games.i.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b = e.this.dFK.b(j2, TextUtils.isEmpty(j) ? g : j, n.j("encoding", a5), false);
                        if (!TextUtils.isEmpty(lL)) {
                            b.errMsg = lL;
                            b.errCode = -2;
                            n.a(e.this.cso, lL);
                        } else if (a2 != 7 && a2 != 12) {
                            b.errMsg = "fail encoding must be a string";
                            b.errCode = -2;
                            n.a(e.this.cso, b.errMsg);
                        }
                        e.this.cso.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a3), "filePath");
                                if (n.a(n.a(b, "appendFile:", a5), bVar, hashMap, e.this.cso)) {
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
        if (n.a(this.dFK, this.cso, (JsObject) null, (String) null)) {
            this.dFL.A(str);
            n.a(this.cso, this.dFK.an(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (n.a(this.dFK, this.cso, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("path", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dFK, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("path", a3);
                this.dFL.a(new Runnable() { // from class: com.baidu.swan.games.i.e.4
                    @Override // java.lang.Runnable
                    public void run() {
                        final c an = e.this.dFK.an(j, false);
                        e.this.cso.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "path");
                                if (n.a(n.a(an, "access:", a3), bVar, hashMap, e.this.cso)) {
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
        if (n.a(this.dFK, this.cso, (JsObject) null, (String) null)) {
            this.dFL.A(str);
            c ao = this.dFK.ao(str, true);
            n.a(this.cso, ao, JSExceptionType.Error, "unknown error", "statSync:");
            if (ao == null || ao.errCode != 0) {
                return null;
            }
            return ao.stats;
        }
        return null;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (n.a(this.dFK, this.cso, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a2 = n.a("path", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dFK, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("path", a3);
                this.dFL.a(new Runnable() { // from class: com.baidu.swan.games.i.e.5
                    @Override // java.lang.Runnable
                    public void run() {
                        final c ao = e.this.dFK.ao(j, false);
                        e.this.cso.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "path");
                                if (n.a(n.a(ao, "stat:", a3), bVar, hashMap, e.this.cso)) {
                                    com.baidu.swan.games.i.a.h hVar = new com.baidu.swan.games.i.a.h();
                                    hVar.stats = ao.stats;
                                    hVar.errMsg = ao.errMsg;
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
        if (n.a(this.dFK, this.cso, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a2 = n.a("filePath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dFK, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("filePath", a3);
                this.dFL.a(new Runnable() { // from class: com.baidu.swan.games.i.e.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final c wk = e.this.dFK.wk(j);
                        e.this.cso.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(wk, "getFileInfo:", a3), bVar, hashMap, e.this.cso)) {
                                    com.baidu.swan.games.i.a.c cVar = new com.baidu.swan.games.i.a.c();
                                    cVar.errMsg = "getFileInfo:" + wk.errMsg;
                                    cVar.digest = wk.digest;
                                    cVar.size = (int) wk.size;
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
        if (n.a(this.dFK, this.cso, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (a2 = n.a(this.dFK, jsObject, (bVar = new com.baidu.swan.games.i.a.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.dFL.a(new Runnable() { // from class: com.baidu.swan.games.i.e.7
                @Override // java.lang.Runnable
                public void run() {
                    final c aQI = e.this.dFK.aQI();
                    e.this.cso.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (n.a(n.a(aQI, "getSavedFileList:", a2), bVar, (Map<Integer, String>) null, e.this.cso)) {
                                com.baidu.swan.games.i.a.d dVar = new com.baidu.swan.games.i.a.d();
                                int size = aQI.fileList == null ? 0 : aQI.fileList.size();
                                dVar.fileList = size == 0 ? new d[0] : (d[]) aQI.fileList.toArray(new d[size]);
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
        if (n.a(this.dFK, this.cso, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a2 = n.a("filePath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dFK, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String j = n.j("filePath", a3);
                this.dFL.a(new Runnable() { // from class: com.baidu.swan.games.i.e.8
                    @Override // java.lang.Runnable
                    public void run() {
                        final c wj = e.this.dFK.wj(j);
                        e.this.cso.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(wj, "removeSavedFile:", a3), bVar, hashMap, e.this.cso)) {
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
