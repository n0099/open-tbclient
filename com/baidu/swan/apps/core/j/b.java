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

    protected abstract String amH();

    protected abstract String mT(String str);

    public HashMap<String, c> amI() {
        JSONArray optJSONArray;
        String amH = amH();
        if (TextUtils.isEmpty(amH) || (optJSONArray = v.parseString(amH).optJSONArray("list")) == null) {
            return null;
        }
        HashMap<String, c> hashMap = new HashMap<>();
        for (int i = 0; i < optJSONArray.length(); i++) {
            c ba = ba(optJSONArray.optJSONObject(i));
            if (ba != null) {
                hashMap.put(ba.dTs, ba);
            }
        }
        return hashMap;
    }

    public void a(final c cVar, final d dVar) {
        final HybridUbcFlow qc = i.qc("startup");
        qc.f(new UbcFlowEvent("loadPresetApp-start").fw(true));
        if (dVar != null) {
            if (cVar == null) {
                dVar.onFailed(0);
                return;
            }
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.j.b.1
                @Override // java.lang.Runnable
                public void run() {
                    qc.f(new UbcFlowEvent("loadPresetApp#run-start").fw(true));
                    String mT = b.this.mT(cVar.dTs);
                    if (TextUtils.isEmpty(mT)) {
                        dVar.onFailed(0);
                        return;
                    }
                    JSONObject parseString = v.parseString(mT);
                    qc.f(new UbcFlowEvent("loadPresetApp#run-appInfoJson").fw(true));
                    PMSAppInfo a2 = b.this.a(cVar, parseString);
                    if (a2 == null) {
                        dVar.onFailed(1);
                        return;
                    }
                    qc.f(new UbcFlowEvent("loadPresetApp#run-PMSAppInfo").fw(true));
                    dVar.i(a2);
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean a3 = b.this.a(cVar);
                    if (b.DEBUG) {
                        Log.d("PresetController", "签名+解压 耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    qc.f(new UbcFlowEvent("loadPresetApp#run-doUnzipBundle").fw(true));
                    if (a3) {
                        a2.setOrientation(b.this.b(cVar.category, cVar.dTs, cVar.versionCode));
                        a2.mw(3);
                        com.baidu.swan.pms.database.a.aWO().a(cVar, a2);
                        qc.f(new UbcFlowEvent("loadPresetApp#run-bulkInsert").fw(true));
                        dVar.j(a2);
                    } else {
                        dVar.onFailed(2);
                    }
                    qc.f(new UbcFlowEvent("loadPresetApp#run-return").fw(true));
                }
            }, "加载小程序预置包");
            qc.f(new UbcFlowEvent("loadPresetApp-return").fw(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i, String str, long j) {
        com.baidu.swan.games.t.a.a i2;
        if (i != 1 || (i2 = com.baidu.swan.apps.core.pms.f.a.i(str, j)) == null) {
            return 0;
        }
        return i2.dJU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PMSAppInfo a(c cVar, JSONObject jSONObject) {
        PMSAppInfo cV;
        if (jSONObject == null || cVar == null || (cV = com.baidu.swan.pms.utils.e.cV(jSONObject)) == null) {
            return null;
        }
        cV.h(cVar);
        cV.createTime = System.currentTimeMillis();
        return cV;
    }

    private c ba(JSONObject jSONObject) {
        c cVar;
        if (jSONObject != null && (cVar = (c) com.baidu.swan.pms.utils.e.a(jSONObject, new c())) != null) {
            cVar.dTw = jSONObject.optInt("pkg_type");
            cVar.cAz = jSONObject.optString("bundle_name");
            if (cVar.amJ()) {
                return cVar;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public File c(int i, String str, long j) {
        if (i == 0) {
            return d.C0438d.bG(str, String.valueOf(j));
        }
        if (i == 1) {
            return a.c.bG(str, String.valueOf(j));
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
