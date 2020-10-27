package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ae;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.ap.v;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.r.a.a;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.games.l.a;
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

    protected abstract boolean a(c cVar);

    protected abstract String aoB();

    protected abstract String nm(String str);

    public HashMap<String, c> aoC() {
        JSONArray optJSONArray;
        String aoB = aoB();
        if (TextUtils.isEmpty(aoB) || (optJSONArray = v.parseString(aoB).optJSONArray("list")) == null) {
            return null;
        }
        HashMap<String, c> hashMap = new HashMap<>();
        for (int i = 0; i < optJSONArray.length(); i++) {
            c bd = bd(optJSONArray.optJSONObject(i));
            if (bd != null) {
                hashMap.put(bd.ebO, bd);
            }
        }
        return hashMap;
    }

    public void a(final c cVar, final d dVar) {
        final HybridUbcFlow qv = i.qv("startup");
        qv.f(new UbcFlowEvent("loadPresetApp-start").fJ(true));
        if (dVar != null) {
            if (cVar == null) {
                dVar.onFailed(0);
                return;
            }
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.j.b.1
                @Override // java.lang.Runnable
                public void run() {
                    qv.f(new UbcFlowEvent("loadPresetApp#run-start").fJ(true));
                    String nm = b.this.nm(cVar.ebO);
                    if (TextUtils.isEmpty(nm)) {
                        dVar.onFailed(0);
                        return;
                    }
                    JSONObject parseString = v.parseString(nm);
                    qv.f(new UbcFlowEvent("loadPresetApp#run-appInfoJson").fJ(true));
                    PMSAppInfo a2 = b.this.a(cVar, parseString);
                    if (a2 == null) {
                        dVar.onFailed(1);
                        return;
                    }
                    qv.f(new UbcFlowEvent("loadPresetApp#run-PMSAppInfo").fJ(true));
                    dVar.i(a2);
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean a3 = b.this.a(cVar);
                    if (b.DEBUG) {
                        Log.d("PresetController", "签名+解压 耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    qv.f(new UbcFlowEvent("loadPresetApp#run-doUnzipBundle").fJ(true));
                    if (a3) {
                        a2.setOrientation(b.this.b(cVar.category, cVar.ebO, cVar.versionCode));
                        a2.mH(3);
                        com.baidu.swan.pms.database.a.aYH().a(cVar, a2);
                        qv.f(new UbcFlowEvent("loadPresetApp#run-bulkInsert").fJ(true));
                        dVar.j(a2);
                    } else {
                        dVar.onFailed(2);
                    }
                    qv.f(new UbcFlowEvent("loadPresetApp#run-return").fJ(true));
                }
            }, "加载小程序预置包");
            qv.f(new UbcFlowEvent("loadPresetApp-return").fJ(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i, String str, long j) {
        com.baidu.swan.games.t.a.a k;
        if (i != 1 || (k = com.baidu.swan.apps.core.pms.f.a.k(str, j)) == null) {
            return 0;
        }
        return k.dSr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PMSAppInfo a(c cVar, JSONObject jSONObject) {
        PMSAppInfo cY;
        if (jSONObject == null || cVar == null || (cY = com.baidu.swan.pms.utils.e.cY(jSONObject)) == null) {
            return null;
        }
        cY.h(cVar);
        cY.createTime = System.currentTimeMillis();
        return cY;
    }

    private c bd(JSONObject jSONObject) {
        c cVar;
        if (jSONObject != null && (cVar = (c) com.baidu.swan.pms.utils.e.a(jSONObject, new c())) != null) {
            cVar.ebS = jSONObject.optInt("pkg_type");
            cVar.cIV = jSONObject.optString("bundle_name");
            if (cVar.aoD()) {
                return cVar;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public File c(int i, String str, long j) {
        if (i == 0) {
            return d.C0452d.bN(str, String.valueOf(j));
        }
        if (i == 1) {
            return a.c.bN(str, String.valueOf(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(BufferedInputStream bufferedInputStream, File file) {
        boolean z = false;
        if (bufferedInputStream != null) {
            try {
                if (file != null) {
                    a.b a2 = com.baidu.swan.apps.r.a.a.a(bufferedInputStream);
                    if ((a2 == null || a2.type == -1) ? false : true) {
                        z = com.baidu.swan.apps.r.a.a.a(bufferedInputStream, file, a2.type).isSuccess;
                    } else {
                        z = com.baidu.swan.c.f.g(bufferedInputStream, file.getPath());
                    }
                }
            } catch (IOException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            } finally {
                com.baidu.swan.c.d.closeSafely(bufferedInputStream);
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
                    boolean b = ae.b(readableByteChannel, str);
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
                com.baidu.swan.c.d.closeSafely(readableByteChannel);
            }
        }
        return false;
    }
}
