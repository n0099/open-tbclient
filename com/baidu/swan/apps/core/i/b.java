package com.baidu.swan.apps.core.i;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.ab;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.as.s;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.t.a.a;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.games.k.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
abstract class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    protected abstract String NC();

    protected abstract boolean a(c cVar);

    protected abstract String ha(String str);

    public HashMap<String, c> ND() {
        JSONArray optJSONArray;
        String NC = NC();
        if (TextUtils.isEmpty(NC) || (optJSONArray = s.parseString(NC).optJSONArray("list")) == null) {
            return null;
        }
        HashMap<String, c> hashMap = new HashMap<>();
        for (int i = 0; i < optJSONArray.length(); i++) {
            c ah = ah(optJSONArray.optJSONObject(i));
            if (ah != null) {
                hashMap.put(ah.cwZ, ah);
            }
        }
        return hashMap;
    }

    public void a(final c cVar, final d dVar) {
        final HybridUbcFlow jA = com.baidu.swan.apps.performance.f.jA("startup");
        jA.f(new UbcFlowEvent("loadPresetApp-start").cZ(true));
        if (dVar != null) {
            if (cVar == null) {
                dVar.onFailed(0);
                return;
            }
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.i.b.1
                @Override // java.lang.Runnable
                public void run() {
                    jA.f(new UbcFlowEvent("loadPresetApp#run-start").cZ(true));
                    String ha = b.this.ha(cVar.cwZ);
                    if (TextUtils.isEmpty(ha)) {
                        dVar.onFailed(0);
                        return;
                    }
                    JSONObject parseString = s.parseString(ha);
                    jA.f(new UbcFlowEvent("loadPresetApp#run-appInfoJson").cZ(true));
                    PMSAppInfo a = b.this.a(cVar, parseString);
                    if (a == null) {
                        dVar.onFailed(1);
                        return;
                    }
                    jA.f(new UbcFlowEvent("loadPresetApp#run-PMSAppInfo").cZ(true));
                    dVar.e(a);
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean a2 = b.this.a(cVar);
                    if (b.DEBUG) {
                        Log.d("PresetController", "签名+解压 耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    jA.f(new UbcFlowEvent("loadPresetApp#run-doUnzipBundle").cZ(true));
                    if (a2) {
                        a.setOrientation(b.this.c(cVar.category, cVar.cwZ, cVar.versionCode));
                        com.baidu.swan.pms.database.a.arf().a(cVar, a);
                        jA.f(new UbcFlowEvent("loadPresetApp#run-bulkInsert").cZ(true));
                        dVar.f(a);
                    } else {
                        dVar.onFailed(2);
                    }
                    jA.f(new UbcFlowEvent("loadPresetApp#run-return").cZ(true));
                }
            }, "加载小程序预置包");
            jA.f(new UbcFlowEvent("loadPresetApp-return").cZ(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i, String str, int i2) {
        com.baidu.swan.games.s.a.a A;
        if (i != 1 || (A = com.baidu.swan.apps.core.pms.d.a.A(str, i2)) == null) {
            return 0;
        }
        return A.cnb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PMSAppInfo a(c cVar, JSONObject jSONObject) {
        PMSAppInfo cc;
        if (jSONObject == null || cVar == null || (cc = com.baidu.swan.pms.f.d.cc(jSONObject)) == null) {
            return null;
        }
        cc.h(cVar);
        cc.createTime = System.currentTimeMillis();
        return cc;
    }

    private c ah(JSONObject jSONObject) {
        c cVar;
        if (jSONObject != null && (cVar = (c) com.baidu.swan.pms.f.d.a(jSONObject, new c())) != null) {
            cVar.cxj = jSONObject.optInt("pkg_type");
            cVar.bmR = jSONObject.optString("bundle_name");
            if (cVar.NE()) {
                return cVar;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public File d(int i, String str, int i2) {
        if (i == 0) {
            return e.d.aB(str, String.valueOf(i2));
        }
        if (i == 1) {
            return a.c.aB(str, String.valueOf(i2));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(BufferedInputStream bufferedInputStream, File file) {
        boolean z = false;
        if (bufferedInputStream != null) {
            try {
                if (file != null) {
                    a.b a = com.baidu.swan.apps.t.a.a.a(bufferedInputStream);
                    if ((a == null || a.type == -1) ? false : true) {
                        z = com.baidu.swan.apps.t.a.a.a(bufferedInputStream, file, a.type).isSuccess;
                    } else {
                        z = com.baidu.swan.d.f.f(bufferedInputStream, file.getPath());
                    }
                }
            } catch (IOException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            } finally {
                com.baidu.swan.d.c.closeSafely(bufferedInputStream);
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(ReadableByteChannel readableByteChannel, String str) {
        if (readableByteChannel != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean b = ab.b(readableByteChannel, str);
                    if (DEBUG) {
                        Log.d("PresetController", "签名校验结果：" + b + " ,耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    return b;
                }
            } catch (IOException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                return false;
            } finally {
                com.baidu.swan.d.c.closeSafely(readableByteChannel);
            }
        }
        return false;
    }
}
