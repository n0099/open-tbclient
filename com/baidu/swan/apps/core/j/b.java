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

    protected abstract String arc();

    protected abstract String nB(String str);

    public HashMap<String, c> ard() {
        JSONArray optJSONArray;
        String arc = arc();
        if (TextUtils.isEmpty(arc) || (optJSONArray = v.parseString(arc).optJSONArray("list")) == null) {
            return null;
        }
        HashMap<String, c> hashMap = new HashMap<>();
        for (int i = 0; i < optJSONArray.length(); i++) {
            c bj = bj(optJSONArray.optJSONObject(i));
            if (bj != null) {
                hashMap.put(bj.ehG, bj);
            }
        }
        return hashMap;
    }

    public void a(final c cVar, final d dVar) {
        final HybridUbcFlow qJ = i.qJ("startup");
        qJ.f(new UbcFlowEvent("loadPresetApp-start").fS(true));
        if (dVar != null) {
            if (cVar == null) {
                dVar.onFailed(0);
                return;
            }
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.j.b.1
                @Override // java.lang.Runnable
                public void run() {
                    qJ.f(new UbcFlowEvent("loadPresetApp#run-start").fS(true));
                    String nB = b.this.nB(cVar.ehG);
                    if (TextUtils.isEmpty(nB)) {
                        dVar.onFailed(0);
                        return;
                    }
                    JSONObject parseString = v.parseString(nB);
                    qJ.f(new UbcFlowEvent("loadPresetApp#run-appInfoJson").fS(true));
                    PMSAppInfo a2 = b.this.a(cVar, parseString);
                    if (a2 == null) {
                        dVar.onFailed(1);
                        return;
                    }
                    qJ.f(new UbcFlowEvent("loadPresetApp#run-PMSAppInfo").fS(true));
                    dVar.i(a2);
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean a3 = b.this.a(cVar);
                    if (b.DEBUG) {
                        Log.d("PresetController", "签名+解压 耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    qJ.f(new UbcFlowEvent("loadPresetApp#run-doUnzipBundle").fS(true));
                    if (a3) {
                        a2.setOrientation(b.this.b(cVar.category, cVar.ehG, cVar.versionCode));
                        a2.mR(3);
                        com.baidu.swan.pms.database.a.bbh().a(cVar, a2);
                        qJ.f(new UbcFlowEvent("loadPresetApp#run-bulkInsert").fS(true));
                        dVar.j(a2);
                    } else {
                        dVar.onFailed(2);
                    }
                    qJ.f(new UbcFlowEvent("loadPresetApp#run-return").fS(true));
                }
            }, "加载小程序预置包");
            qJ.f(new UbcFlowEvent("loadPresetApp-return").fS(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i, String str, long j) {
        com.baidu.swan.games.t.a.a k;
        if (i != 1 || (k = com.baidu.swan.apps.core.pms.f.a.k(str, j)) == null) {
            return 0;
        }
        return k.dYj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PMSAppInfo a(c cVar, JSONObject jSONObject) {
        PMSAppInfo de2;
        if (jSONObject == null || cVar == null || (de2 = com.baidu.swan.pms.utils.e.de(jSONObject)) == null) {
            return null;
        }
        de2.h(cVar);
        de2.createTime = System.currentTimeMillis();
        return de2;
    }

    private c bj(JSONObject jSONObject) {
        c cVar;
        if (jSONObject != null && (cVar = (c) com.baidu.swan.pms.utils.e.a(jSONObject, new c())) != null) {
            cVar.ehK = jSONObject.optInt("pkg_type");
            cVar.cOO = jSONObject.optString("bundle_name");
            if (cVar.are()) {
                return cVar;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public File c(int i, String str, long j) {
        if (i == 0) {
            return d.C0464d.bN(str, String.valueOf(j));
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
