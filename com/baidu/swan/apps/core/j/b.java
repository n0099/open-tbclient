package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ao.ae;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.ao.v;
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

    protected abstract String arA();

    protected abstract String nj(String str);

    public HashMap<String, c> arB() {
        JSONArray optJSONArray;
        String arA = arA();
        if (TextUtils.isEmpty(arA) || (optJSONArray = v.parseString(arA).optJSONArray("list")) == null) {
            return null;
        }
        HashMap<String, c> hashMap = new HashMap<>();
        for (int i = 0; i < optJSONArray.length(); i++) {
            c bm = bm(optJSONArray.optJSONObject(i));
            if (bm != null) {
                hashMap.put(bm.evD, bm);
            }
        }
        return hashMap;
    }

    public void a(final c cVar, final d dVar) {
        final HybridUbcFlow qr = i.qr("startup");
        qr.f(new UbcFlowEvent("loadPresetApp-start").gr(true));
        if (dVar != null) {
            if (cVar == null) {
                dVar.onFailed(0);
                return;
            }
            p.a(new Runnable() { // from class: com.baidu.swan.apps.core.j.b.1
                @Override // java.lang.Runnable
                public void run() {
                    qr.f(new UbcFlowEvent("loadPresetApp#run-start").gr(true));
                    String nj = b.this.nj(cVar.evD);
                    if (TextUtils.isEmpty(nj)) {
                        dVar.onFailed(0);
                        return;
                    }
                    JSONObject parseString = v.parseString(nj);
                    qr.f(new UbcFlowEvent("loadPresetApp#run-appInfoJson").gr(true));
                    PMSAppInfo a2 = b.this.a(cVar, parseString);
                    if (a2 == null) {
                        dVar.onFailed(1);
                        return;
                    }
                    qr.f(new UbcFlowEvent("loadPresetApp#run-PMSAppInfo").gr(true));
                    dVar.i(a2);
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean a3 = b.this.a(cVar);
                    if (b.DEBUG) {
                        Log.d("PresetController", "签名+解压 耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    qr.f(new UbcFlowEvent("loadPresetApp#run-doUnzipBundle").gr(true));
                    if (a3) {
                        a2.setOrientation(b.this.b(cVar.category, cVar.evD, cVar.versionCode));
                        a2.lS(3);
                        com.baidu.swan.pms.database.a.bcx().a(cVar, a2);
                        qr.f(new UbcFlowEvent("loadPresetApp#run-bulkInsert").gr(true));
                        dVar.j(a2);
                    } else {
                        dVar.onFailed(2);
                    }
                    qr.f(new UbcFlowEvent("loadPresetApp#run-return").gr(true));
                }
            }, "加载小程序预置包");
            qr.f(new UbcFlowEvent("loadPresetApp-return").gr(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i, String str, long j) {
        com.baidu.swan.games.t.a.a j2;
        if (i != 1 || (j2 = com.baidu.swan.apps.core.pms.f.a.j(str, j)) == null) {
            return 0;
        }
        return j2.elt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PMSAppInfo a(c cVar, JSONObject jSONObject) {
        PMSAppInfo dh;
        if (jSONObject == null || cVar == null || (dh = com.baidu.swan.pms.utils.e.dh(jSONObject)) == null) {
            return null;
        }
        dh.h(cVar);
        dh.createTime = System.currentTimeMillis();
        return dh;
    }

    private c bm(JSONObject jSONObject) {
        c cVar;
        if (jSONObject != null && (cVar = (c) com.baidu.swan.pms.utils.e.a(jSONObject, new c())) != null) {
            cVar.evH = jSONObject.optInt("pkg_type");
            cVar.cXU = jSONObject.optString("bundle_name");
            if (cVar.arC()) {
                return cVar;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public File c(int i, String str, long j) {
        if (i == 0) {
            return d.C0452d.bL(str, String.valueOf(j));
        }
        if (i == 1) {
            return a.c.bL(str, String.valueOf(j));
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
                        z = com.baidu.swan.c.f.i(bufferedInputStream, file.getPath());
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
