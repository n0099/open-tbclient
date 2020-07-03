package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.ac;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.aq.t;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.r.a.a;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.games.l.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
abstract class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    protected abstract boolean a(c cVar);

    protected abstract String abJ();

    protected abstract String jQ(String str);

    public HashMap<String, c> abK() {
        JSONArray optJSONArray;
        String abJ = abJ();
        if (TextUtils.isEmpty(abJ) || (optJSONArray = t.parseString(abJ).optJSONArray("list")) == null) {
            return null;
        }
        HashMap<String, c> hashMap = new HashMap<>();
        for (int i = 0; i < optJSONArray.length(); i++) {
            c aH = aH(optJSONArray.optJSONObject(i));
            if (aH != null) {
                hashMap.put(aH.dqi, aH);
            }
        }
        return hashMap;
    }

    public void a(final c cVar, final d dVar) {
        final HybridUbcFlow mx = g.mx("startup");
        mx.f(new UbcFlowEvent("loadPresetApp-start").ez(true));
        if (dVar != null) {
            if (cVar == null) {
                dVar.onFailed(0);
                return;
            }
            n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.j.b.1
                @Override // java.lang.Runnable
                public void run() {
                    mx.f(new UbcFlowEvent("loadPresetApp#run-start").ez(true));
                    String jQ = b.this.jQ(cVar.dqi);
                    if (TextUtils.isEmpty(jQ)) {
                        dVar.onFailed(0);
                        return;
                    }
                    JSONObject parseString = t.parseString(jQ);
                    mx.f(new UbcFlowEvent("loadPresetApp#run-appInfoJson").ez(true));
                    PMSAppInfo a = b.this.a(cVar, parseString);
                    if (a == null) {
                        dVar.onFailed(1);
                        return;
                    }
                    mx.f(new UbcFlowEvent("loadPresetApp#run-PMSAppInfo").ez(true));
                    dVar.f(a);
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean a2 = b.this.a(cVar);
                    if (b.DEBUG) {
                        Log.d("PresetController", "签名+解压 耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    mx.f(new UbcFlowEvent("loadPresetApp#run-doUnzipBundle").ez(true));
                    if (a2) {
                        a.setOrientation(b.this.c(cVar.category, cVar.dqi, cVar.versionCode));
                        com.baidu.swan.pms.database.a.aHb().a(cVar, a);
                        mx.f(new UbcFlowEvent("loadPresetApp#run-bulkInsert").ez(true));
                        dVar.g(a);
                    } else {
                        dVar.onFailed(2);
                    }
                    mx.f(new UbcFlowEvent("loadPresetApp#run-return").ez(true));
                }
            }, "加载小程序预置包");
            mx.f(new UbcFlowEvent("loadPresetApp-return").ez(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i, String str, int i2) {
        com.baidu.swan.games.t.a.a K;
        if (i != 1 || (K = com.baidu.swan.apps.core.pms.f.a.K(str, i2)) == null) {
            return 0;
        }
        return K.dga;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PMSAppInfo a(c cVar, JSONObject jSONObject) {
        PMSAppInfo cA;
        if (jSONObject == null || cVar == null || (cA = com.baidu.swan.pms.f.d.cA(jSONObject)) == null) {
            return null;
        }
        cA.h(cVar);
        cA.createTime = System.currentTimeMillis();
        return cA;
    }

    private c aH(JSONObject jSONObject) {
        c cVar;
        if (jSONObject != null && (cVar = (c) com.baidu.swan.pms.f.d.a(jSONObject, new c())) != null) {
            cVar.dqs = jSONObject.optInt("pkg_type");
            cVar.cec = jSONObject.optString("bundle_name");
            if (cVar.abL()) {
                return cVar;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public File d(int i, String str, int i2) {
        if (i == 0) {
            return e.d.bm(str, String.valueOf(i2));
        }
        if (i == 1) {
            return a.c.bm(str, String.valueOf(i2));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(BufferedInputStream bufferedInputStream, File file) {
        boolean z = false;
        if (bufferedInputStream != null) {
            try {
                if (file != null) {
                    a.b a = com.baidu.swan.apps.r.a.a.a(bufferedInputStream);
                    if ((a == null || a.type == -1) ? false : true) {
                        z = com.baidu.swan.apps.r.a.a.a(bufferedInputStream, file, a.type).isSuccess;
                    } else {
                        z = com.baidu.swan.e.g.f(bufferedInputStream, file.getPath());
                    }
                }
            } catch (IOException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            } finally {
                com.baidu.swan.e.d.closeSafely(bufferedInputStream);
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
                    boolean b = ac.b(readableByteChannel, str);
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
                com.baidu.swan.e.d.closeSafely(readableByteChannel);
            }
        }
        return false;
    }
}
