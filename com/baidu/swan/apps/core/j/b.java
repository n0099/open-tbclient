package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.ae;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.aq.v;
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
/* loaded from: classes7.dex */
abstract class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    protected abstract boolean a(c cVar);

    protected abstract String acN();

    protected abstract String kj(String str);

    public HashMap<String, c> acO() {
        JSONArray optJSONArray;
        String acN = acN();
        if (TextUtils.isEmpty(acN) || (optJSONArray = v.parseString(acN).optJSONArray("list")) == null) {
            return null;
        }
        HashMap<String, c> hashMap = new HashMap<>();
        for (int i = 0; i < optJSONArray.length(); i++) {
            c aK = aK(optJSONArray.optJSONObject(i));
            if (aK != null) {
                hashMap.put(aK.dvZ, aK);
            }
        }
        return hashMap;
    }

    public void a(final c cVar, final d dVar) {
        final HybridUbcFlow mX = i.mX("startup");
        mX.f(new UbcFlowEvent("loadPresetApp-start").eI(true));
        if (dVar != null) {
            if (cVar == null) {
                dVar.onFailed(0);
                return;
            }
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.j.b.1
                @Override // java.lang.Runnable
                public void run() {
                    mX.f(new UbcFlowEvent("loadPresetApp#run-start").eI(true));
                    String kj = b.this.kj(cVar.dvZ);
                    if (TextUtils.isEmpty(kj)) {
                        dVar.onFailed(0);
                        return;
                    }
                    JSONObject parseString = v.parseString(kj);
                    mX.f(new UbcFlowEvent("loadPresetApp#run-appInfoJson").eI(true));
                    PMSAppInfo a = b.this.a(cVar, parseString);
                    if (a == null) {
                        dVar.onFailed(1);
                        return;
                    }
                    mX.f(new UbcFlowEvent("loadPresetApp#run-PMSAppInfo").eI(true));
                    dVar.i(a);
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean a2 = b.this.a(cVar);
                    if (b.DEBUG) {
                        Log.d("PresetController", "签名+解压 耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    mX.f(new UbcFlowEvent("loadPresetApp#run-doUnzipBundle").eI(true));
                    if (a2) {
                        a.setOrientation(b.this.c(cVar.category, cVar.dvZ, cVar.versionCode));
                        a.jG(3);
                        com.baidu.swan.pms.database.a.aKS().a(cVar, a);
                        mX.f(new UbcFlowEvent("loadPresetApp#run-bulkInsert").eI(true));
                        dVar.j(a);
                    } else {
                        dVar.onFailed(2);
                    }
                    mX.f(new UbcFlowEvent("loadPresetApp#run-return").eI(true));
                }
            }, "加载小程序预置包");
            mX.f(new UbcFlowEvent("loadPresetApp-return").eI(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i, String str, int i2) {
        com.baidu.swan.games.t.a.a K;
        if (i != 1 || (K = com.baidu.swan.apps.core.pms.f.a.K(str, i2)) == null) {
            return 0;
        }
        return K.dlJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PMSAppInfo a(c cVar, JSONObject jSONObject) {
        PMSAppInfo cG;
        if (jSONObject == null || cVar == null || (cG = com.baidu.swan.pms.f.e.cG(jSONObject)) == null) {
            return null;
        }
        cG.h(cVar);
        cG.createTime = System.currentTimeMillis();
        return cG;
    }

    private c aK(JSONObject jSONObject) {
        c cVar;
        if (jSONObject != null && (cVar = (c) com.baidu.swan.pms.f.e.a(jSONObject, new c())) != null) {
            cVar.dwk = jSONObject.optInt("pkg_type");
            cVar.cfL = jSONObject.optString("bundle_name");
            if (cVar.acP()) {
                return cVar;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public File d(int i, String str, int i2) {
        if (i == 0) {
            return d.C0380d.bq(str, String.valueOf(i2));
        }
        if (i == 1) {
            return a.c.bq(str, String.valueOf(i2));
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
                        z = com.baidu.swan.d.f.f(bufferedInputStream, file.getPath());
                    }
                }
            } catch (IOException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            } finally {
                com.baidu.swan.d.d.closeSafely(bufferedInputStream);
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
                com.baidu.swan.d.d.closeSafely(readableByteChannel);
            }
        }
        return false;
    }
}
