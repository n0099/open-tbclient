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
/* loaded from: classes8.dex */
abstract class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    protected abstract boolean a(c cVar);

    protected abstract String ajm();

    protected abstract String lN(String str);

    public HashMap<String, c> ajn() {
        JSONArray optJSONArray;
        String ajm = ajm();
        if (TextUtils.isEmpty(ajm) || (optJSONArray = v.parseString(ajm).optJSONArray("list")) == null) {
            return null;
        }
        HashMap<String, c> hashMap = new HashMap<>();
        for (int i = 0; i < optJSONArray.length(); i++) {
            c aQ = aQ(optJSONArray.optJSONObject(i));
            if (aQ != null) {
                hashMap.put(aQ.dFj, aQ);
            }
        }
        return hashMap;
    }

    public void a(final c cVar, final d dVar) {
        final HybridUbcFlow oW = i.oW("startup");
        oW.f(new UbcFlowEvent("loadPresetApp-start").fb(true));
        if (dVar != null) {
            if (cVar == null) {
                dVar.onFailed(0);
                return;
            }
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.j.b.1
                @Override // java.lang.Runnable
                public void run() {
                    oW.f(new UbcFlowEvent("loadPresetApp#run-start").fb(true));
                    String lN = b.this.lN(cVar.dFj);
                    if (TextUtils.isEmpty(lN)) {
                        dVar.onFailed(0);
                        return;
                    }
                    JSONObject parseString = v.parseString(lN);
                    oW.f(new UbcFlowEvent("loadPresetApp#run-appInfoJson").fb(true));
                    PMSAppInfo a = b.this.a(cVar, parseString);
                    if (a == null) {
                        dVar.onFailed(1);
                        return;
                    }
                    oW.f(new UbcFlowEvent("loadPresetApp#run-PMSAppInfo").fb(true));
                    dVar.i(a);
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean a2 = b.this.a(cVar);
                    if (b.DEBUG) {
                        Log.d("PresetController", "签名+解压 耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    oW.f(new UbcFlowEvent("loadPresetApp#run-doUnzipBundle").fb(true));
                    if (a2) {
                        a.setOrientation(b.this.b(cVar.category, cVar.dFj, cVar.versionCode));
                        a.lO(3);
                        com.baidu.swan.pms.database.a.aTt().a(cVar, a);
                        oW.f(new UbcFlowEvent("loadPresetApp#run-bulkInsert").fb(true));
                        dVar.j(a);
                    } else {
                        dVar.onFailed(2);
                    }
                    oW.f(new UbcFlowEvent("loadPresetApp#run-return").fb(true));
                }
            }, "加载小程序预置包");
            oW.f(new UbcFlowEvent("loadPresetApp-return").fb(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i, String str, long j) {
        com.baidu.swan.games.t.a.a i2;
        if (i != 1 || (i2 = com.baidu.swan.apps.core.pms.f.a.i(str, j)) == null) {
            return 0;
        }
        return i2.dvO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PMSAppInfo a(c cVar, JSONObject jSONObject) {
        PMSAppInfo cL;
        if (jSONObject == null || cVar == null || (cL = com.baidu.swan.pms.utils.e.cL(jSONObject)) == null) {
            return null;
        }
        cL.h(cVar);
        cL.createTime = System.currentTimeMillis();
        return cL;
    }

    private c aQ(JSONObject jSONObject) {
        c cVar;
        if (jSONObject != null && (cVar = (c) com.baidu.swan.pms.utils.e.a(jSONObject, new c())) != null) {
            cVar.dFn = jSONObject.optInt("pkg_type");
            cVar.cmc = jSONObject.optString("bundle_name");
            if (cVar.ajo()) {
                return cVar;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public File c(int i, String str, long j) {
        if (i == 0) {
            return d.C0426d.bB(str, String.valueOf(j));
        }
        if (i == 1) {
            return a.c.bB(str, String.valueOf(j));
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
                        z = com.baidu.swan.c.f.f(bufferedInputStream, file.getPath());
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
