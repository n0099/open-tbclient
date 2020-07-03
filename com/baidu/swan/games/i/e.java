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
/* loaded from: classes11.dex */
public class e {
    private com.baidu.swan.games.f.a bXp;
    private f dbJ;
    private i dbK;

    public e(com.baidu.swan.games.f.a aVar) {
        this.bXp = aVar;
        aAT();
    }

    private void aAT() {
        com.baidu.swan.apps.storage.b.c lVar;
        com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
        if (apN != null) {
            lVar = apN.aiH();
        } else {
            lVar = new l();
        }
        this.dbJ = new f(AppRuntime.getAppContext(), com.baidu.swan.apps.w.f.ajb().aiI(), lVar);
        this.dbK = i.aBd();
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        mkdirSync(str, false);
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        if (n.a(this.dbJ, this.bXp, (JsObject) null, (String) null)) {
            this.dbK.y(str);
            n.a(this.bXp, this.dbJ.b(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        if (n.a(this.dbJ, this.bXp, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = n.a("dirPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a2 = n.a(this.dbJ, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a2 != null) {
                final String i = n.i("dirPath", a2);
                final Boolean bool = (Boolean) n.a("recursive", a2, Boolean.FALSE);
                this.dbK.a(new Runnable() { // from class: com.baidu.swan.games.i.e.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b = e.this.dbJ.b(i, bool.booleanValue(), false);
                        e.this.bXp.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "dirPath");
                                if (n.a(n.a(b, "mkdir:", a2), bVar, hashMap, e.this.bXp)) {
                                    bVar.errMsg = "mkdir:" + b.errMsg;
                                    n.b(bVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesmkdir:", i);
            }
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        if (n.a(this.dbJ, this.bXp, (JsObject) null, (String) null)) {
            this.dbK.y(str);
            n.a(this.bXp, this.dbJ.a(true, str, (Object) str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2) {
        writeFileSync(str, str2, "");
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        if (n.a(this.dbJ, this.bXp, (JsObject) null, (String) null)) {
            this.dbK.y(str);
            n.a(this.bXp, this.dbJ.a(true, str, (Object) (jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer()), (String) null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        writeFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        if (n.a(this.dbJ, this.bXp, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = n.a("filePath", jsObject);
            final String iD = n.iD(n.a("data", jsObject));
            final int a2 = n.a("encoding", jsObject);
            final byte[] g = n.g(jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dbJ, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String i = n.i("data", a3);
                final String i2 = n.i("filePath", a3);
                this.dbK.a(new Runnable() { // from class: com.baidu.swan.games.i.e.9
                    @Override // java.lang.Runnable
                    public void run() {
                        final c a4 = e.this.dbJ.a(false, i2, TextUtils.isEmpty(i) ? g : i, n.i("encoding", a3));
                        if (!TextUtils.isEmpty(iD)) {
                            a4.errMsg = iD;
                            a4.errCode = -2;
                            n.a(e.this.bXp, iD);
                        } else if (a2 != 7 && a2 != 12) {
                            a4.errMsg = "fail encoding must be a string";
                            a4.errCode = -2;
                            n.a(e.this.bXp, a4.errMsg);
                        }
                        e.this.bXp.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (n.a(n.a(a4, "writeFile:", a3), bVar, hashMap, e.this.bXp)) {
                                    bVar.errMsg = "writeFile:" + a4.errMsg;
                                    n.b(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigameswriteFile:", i2);
            }
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        if (n.a(this.dbJ, this.bXp, (JsObject) null, (String) null)) {
            this.dbK.y(str);
            n.a(this.bXp, this.dbJ.ad(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        if (n.a(this.dbJ, this.bXp, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a = n.a("filePath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a2 = n.a(this.dbJ, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a2 != null) {
                final String i = n.i("filePath", a2);
                this.dbK.a(new Runnable() { // from class: com.baidu.swan.games.i.e.10
                    @Override // java.lang.Runnable
                    public void run() {
                        final c ad = e.this.dbJ.ad(i, false);
                        e.this.bXp.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (n.a(n.a(ad, "unlink:", a2), bVar, hashMap, e.this.bXp)) {
                                    bVar.errMsg = "unlink:" + ad.errMsg;
                                    n.b(bVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesunlink:", i);
            }
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        if (n.a(this.dbJ, this.bXp, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = n.a("zipFilePath", jsObject);
            final int a2 = n.a("targetPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dbJ, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (a3 != null) {
                final String i = n.i("zipFilePath", a3);
                final String i2 = n.i("targetPath", a3);
                this.dbK.a(new Runnable() { // from class: com.baidu.swan.games.i.e.11
                    @Override // java.lang.Runnable
                    public void run() {
                        final c co = e.this.dbJ.co(i, i2);
                        e.this.bXp.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "zipFilePath");
                                hashMap.put(Integer.valueOf(a2), "targetPath");
                                if (n.a(n.a(co, "unzip:", a3), bVar, hashMap, e.this.bXp)) {
                                    bVar.errMsg = "unzip:" + co.errMsg;
                                    n.b(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamesunzip:", i, i2);
            }
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        return saveFileSync(str, a.USER_DATA_PATH);
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        if (n.a(this.dbJ, this.bXp, (JsObject) null, (String) null)) {
            this.dbK.y(str, str2);
            c q = this.dbJ.q(str, str2, true);
            n.a(this.bXp, q, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (q == null || q.errCode != 0 || q.result == null) {
                return null;
            }
            return q.result.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        if (n.a(this.dbJ, this.bXp, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = n.a("tempFilePath", jsObject);
            final int a2 = n.a("filePath", jsObject);
            if (a2 == 12) {
                a2 = 7;
            }
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dbJ, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (a3 != null) {
                final String i = n.i("tempFilePath", a3);
                final String i2 = n.i("filePath", a3);
                this.dbK.a(new Runnable() { // from class: com.baidu.swan.games.i.e.12
                    @Override // java.lang.Runnable
                    public void run() {
                        final c q = e.this.dbJ.q(i, i2, false);
                        e.this.bXp.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "tempFilePath");
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(q, "saveFile:", a3), bVar, hashMap, e.this.bXp)) {
                                    com.baidu.swan.games.i.a.g gVar = new com.baidu.swan.games.i.a.g();
                                    gVar.savedFilePath = q.result != null ? q.result.get(0) : null;
                                    gVar.errMsg = q.errMsg;
                                    n.b(gVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamessaveFile:", i, i2);
            }
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        if (n.a(this.dbJ, this.bXp, (JsObject) null, (String) null)) {
            this.dbK.y(str);
            c ae = this.dbJ.ae(str, true);
            n.a(this.bXp, ae, JSExceptionType.Error, "unknown error", "readdirSync:");
            if (ae != null && ae.errCode == 0) {
                int size = ae.result == null ? 0 : ae.result.size();
                return size == 0 ? new String[0] : (String[]) ae.result.toArray(new String[size]);
            }
            return new String[0];
        }
        return null;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        if (n.a(this.dbJ, this.bXp, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = n.a("dirPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a2 = n.a(this.dbJ, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a2 != null) {
                final String i = n.i("dirPath", a2);
                this.dbK.a(new Runnable() { // from class: com.baidu.swan.games.i.e.13
                    @Override // java.lang.Runnable
                    public void run() {
                        final c ae = e.this.dbJ.ae(i, false);
                        e.this.bXp.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "dirPath");
                                if (n.a(n.a(ae, "readdir:", a2), bVar, hashMap, e.this.bXp)) {
                                    com.baidu.swan.games.i.a.e eVar = new com.baidu.swan.games.i.a.e();
                                    int size = ae.result == null ? 0 : ae.result.size();
                                    eVar.files = size == 0 ? new String[0] : (String[]) ae.result.toArray(new String[size]);
                                    eVar.errMsg = ae.errMsg;
                                    n.b(eVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesreaddir:", i);
            }
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str) {
        rmdirSync(str, false);
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        if (n.a(this.dbJ, this.bXp, (JsObject) null, (String) null)) {
            this.dbK.y(str);
            n.a(this.bXp, this.dbJ.c(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        if (n.a(this.dbJ, this.bXp, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = n.a("dirPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a2 = n.a(this.dbJ, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (a2 != null) {
                final String i = n.i("dirPath", a2);
                final Boolean bool = (Boolean) n.a("recursive", a2, Boolean.FALSE);
                this.dbK.a(new Runnable() { // from class: com.baidu.swan.games.i.e.14
                    @Override // java.lang.Runnable
                    public void run() {
                        final c c = e.this.dbJ.c(i, bool.booleanValue(), false);
                        e.this.bXp.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "dirPath");
                                if (n.a(n.a(c, "rmdir:", a2), bVar, hashMap, e.this.bXp)) {
                                    n.b(bVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesrmdir:", i);
            }
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        if (n.a(this.dbJ, this.bXp, (JsObject) null, (String) null)) {
            this.dbK.y(str);
            c r = this.dbJ.r(str, str2, true);
            n.a(this.bXp, r, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (r == null || r.errCode != 0 || r.result == null) {
                return null;
            }
            return r.result.get(0);
        }
        return null;
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        if (n.a(this.dbJ, this.bXp, (JsObject) null, (String) null)) {
            this.dbK.y(str);
            c r = this.dbJ.r(str, null, true);
            n.a(this.bXp, r, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (r.dbI == null) {
                r.dbI = new byte[0];
            }
            return new JsArrayBuffer(r.dbI, r.dbI.length);
        }
        return null;
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        if (n.a(this.dbJ, this.bXp, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            final int a = n.a("filePath", jsObject);
            final int a2 = n.a("encoding", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dbJ, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a3 != null) {
                final String i = n.i("encoding", a3);
                final String i2 = n.i("filePath", a3);
                this.dbK.a(new Runnable() { // from class: com.baidu.swan.games.i.e.15
                    @Override // java.lang.Runnable
                    public void run() {
                        final c r = e.this.dbJ.r(i2, i, false);
                        if (a2 != 7 && a2 != 12) {
                            r.errMsg = "fail encoding must be a string";
                            r.errCode = -2;
                            n.a(e.this.bXp, r.errMsg);
                        }
                        e.this.bXp.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (n.a(n.a(r, "readFile:", a3), bVar, hashMap, e.this.bXp)) {
                                    if (TextUtils.isEmpty(i)) {
                                        com.baidu.swan.games.i.a.a aVar = new com.baidu.swan.games.i.a.a();
                                        if (r.dbI == null) {
                                            r.dbI = new byte[0];
                                        }
                                        aVar.data = new JsArrayBuffer(r.dbI, r.dbI.length);
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
                }, "aigamesreadFile:", i2);
            }
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        if (n.a(this.dbJ, this.bXp, (JsObject) null, (String) null)) {
            this.dbK.y(str, str2);
            n.a(this.bXp, this.dbJ.s(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        if (n.a(this.dbJ, this.bXp, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = n.a("oldPath", jsObject);
            final int a2 = n.a("newPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dbJ, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (a3 != null) {
                final String i = n.i("oldPath", a3);
                final String i2 = n.i("newPath", a3);
                this.dbK.a(new Runnable() { // from class: com.baidu.swan.games.i.e.16
                    @Override // java.lang.Runnable
                    public void run() {
                        final c s = e.this.dbJ.s(i, i2, false);
                        e.this.bXp.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.16.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "oldPath");
                                hashMap.put(Integer.valueOf(a2), "newPath");
                                if (n.a(n.a(s, "rename:", a3), bVar, hashMap, e.this.bXp)) {
                                    n.b(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamesrename:", i, i2);
            }
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        if (n.a(this.dbJ, this.bXp, (JsObject) null, (String) null)) {
            this.dbK.y(str, str2);
            n.a(this.bXp, this.dbJ.t(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        if (n.a(this.dbJ, this.bXp, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = n.a("srcPath", jsObject);
            final int a2 = n.a("destPath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a3 = n.a(this.dbJ, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (a3 != null) {
                final String i = n.i("srcPath", a3);
                final String i2 = n.i("destPath", a3);
                this.dbK.a(new Runnable() { // from class: com.baidu.swan.games.i.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        final c t = e.this.dbJ.t(i, i2, false);
                        e.this.bXp.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "srcPath");
                                hashMap.put(Integer.valueOf(a2), "destPath");
                                if (n.a(n.a(t, "copyFile:", a3), bVar, hashMap, e.this.bXp)) {
                                    n.b(bVar, a3);
                                }
                            }
                        });
                    }
                }, "aigamescopyFile:", i, i2);
            }
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        if (n.a(this.dbJ, this.bXp, (JsObject) null, (String) null)) {
            this.dbK.y(str);
            n.a(this.bXp, this.dbJ.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
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
        if (n.a(this.dbJ, this.bXp, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a = n.a("encoding", jsObject);
            final int a2 = n.a("filePath", jsObject);
            int a3 = n.a("data", jsObject);
            final String iD = (a3 == 5 || a3 == 2 || a3 == 3) ? "fail data argument must not be a number" : n.iD(a3);
            final byte[] g = n.g(jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a4 = n.a(this.dbJ, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a4 != null) {
                final String i = n.i("data", a4);
                final String i2 = n.i("filePath", a4);
                this.dbK.a(new Runnable() { // from class: com.baidu.swan.games.i.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        final c b = e.this.dbJ.b(i2, TextUtils.isEmpty(i) ? g : i, n.i("encoding", a4), false);
                        if (!TextUtils.isEmpty(iD)) {
                            b.errMsg = iD;
                            b.errCode = -2;
                            n.a(e.this.bXp, iD);
                        } else if (a != 7 && a != 12) {
                            b.errMsg = "fail encoding must be a string";
                            b.errCode = -2;
                            n.a(e.this.bXp, b.errMsg);
                        }
                        e.this.bXp.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a2), "filePath");
                                if (n.a(n.a(b, "appendFile:", a4), bVar, hashMap, e.this.bXp)) {
                                    n.b(bVar, a4);
                                }
                            }
                        });
                    }
                }, "aigamesappendFile:", i2);
            }
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        if (n.a(this.dbJ, this.bXp, (JsObject) null, (String) null)) {
            this.dbK.y(str);
            n.a(this.bXp, this.dbJ.af(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        if (n.a(this.dbJ, this.bXp, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = n.a("path", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a2 = n.a(this.dbJ, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a2 != null) {
                final String i = n.i("path", a2);
                this.dbK.a(new Runnable() { // from class: com.baidu.swan.games.i.e.4
                    @Override // java.lang.Runnable
                    public void run() {
                        final c af = e.this.dbJ.af(i, false);
                        e.this.bXp.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "path");
                                if (n.a(n.a(af, "access:", a2), bVar, hashMap, e.this.bXp)) {
                                    n.b(bVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesaccess:", i);
            }
        }
    }

    @JavascriptInterface
    public j statSync(String str) {
        if (n.a(this.dbJ, this.bXp, (JsObject) null, (String) null)) {
            this.dbK.y(str);
            c ag = this.dbJ.ag(str, true);
            n.a(this.bXp, ag, JSExceptionType.Error, "unknown error", "statSync:");
            if (ag == null || ag.errCode != 0) {
                return null;
            }
            return ag.stats;
        }
        return null;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        if (n.a(this.dbJ, this.bXp, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            final int a = n.a("path", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a2 = n.a(this.dbJ, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (a2 != null) {
                final String i = n.i("path", a2);
                this.dbK.a(new Runnable() { // from class: com.baidu.swan.games.i.e.5
                    @Override // java.lang.Runnable
                    public void run() {
                        final c ag = e.this.dbJ.ag(i, false);
                        e.this.bXp.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "path");
                                if (n.a(n.a(ag, "stat:", a2), bVar, hashMap, e.this.bXp)) {
                                    com.baidu.swan.games.i.a.h hVar = new com.baidu.swan.games.i.a.h();
                                    hVar.stats = ag.stats;
                                    hVar.errMsg = ag.errMsg;
                                    n.b(hVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesstat:", i);
            }
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        if (n.a(this.dbJ, this.bXp, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a = n.a("filePath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a2 = n.a(this.dbJ, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a2 != null) {
                final String i = n.i("filePath", a2);
                this.dbK.a(new Runnable() { // from class: com.baidu.swan.games.i.e.6
                    @Override // java.lang.Runnable
                    public void run() {
                        final c rO = e.this.dbJ.rO(i);
                        e.this.bXp.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (n.a(n.a(rO, "getFileInfo:", a2), bVar, hashMap, e.this.bXp)) {
                                    com.baidu.swan.games.i.a.c cVar = new com.baidu.swan.games.i.a.c();
                                    cVar.errMsg = "getFileInfo:" + rO.errMsg;
                                    cVar.digest = rO.digest;
                                    cVar.size = (int) rO.size;
                                    n.b(cVar, a2);
                                }
                            }
                        });
                    }
                }, "aigamesgetFileInfo:", i);
            }
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        final com.baidu.swan.games.i.a.b bVar;
        final Map<String, Object> a;
        if (n.a(this.dbJ, this.bXp, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (a = n.a(this.dbJ, jsObject, (bVar = new com.baidu.swan.games.i.a.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.dbK.a(new Runnable() { // from class: com.baidu.swan.games.i.e.7
                @Override // java.lang.Runnable
                public void run() {
                    final c aAU = e.this.dbJ.aAU();
                    e.this.bXp.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (n.a(n.a(aAU, "getSavedFileList:", a), bVar, (Map<Integer, String>) null, e.this.bXp)) {
                                com.baidu.swan.games.i.a.d dVar = new com.baidu.swan.games.i.a.d();
                                int size = aAU.fileList == null ? 0 : aAU.fileList.size();
                                dVar.fileList = size == 0 ? new d[0] : (d[]) aAU.fileList.toArray(new d[size]);
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
        if (n.a(this.dbJ, this.bXp, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            final int a = n.a("filePath", jsObject);
            final com.baidu.swan.games.i.a.b bVar = new com.baidu.swan.games.i.a.b();
            final Map<String, Object> a2 = n.a(this.dbJ, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (a2 != null) {
                final String i = n.i("filePath", a2);
                this.dbK.a(new Runnable() { // from class: com.baidu.swan.games.i.e.8
                    @Override // java.lang.Runnable
                    public void run() {
                        final c rN = e.this.dbJ.rN(i);
                        e.this.bXp.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.e.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Integer.valueOf(a), "filePath");
                                if (n.a(n.a(rN, "removeSavedFile:", a2), bVar, hashMap, e.this.bXp)) {
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
