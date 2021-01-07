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
/* loaded from: classes9.dex */
abstract class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    protected abstract boolean a(c cVar);

    protected abstract String auU();

    protected abstract String nV(String str);

    public HashMap<String, c> auV() {
        JSONArray optJSONArray;
        String auU = auU();
        if (TextUtils.isEmpty(auU) || (optJSONArray = v.parseString(auU).optJSONArray("list")) == null) {
            return null;
        }
        HashMap<String, c> hashMap = new HashMap<>();
        for (int i = 0; i < optJSONArray.length(); i++) {
            c bn = bn(optJSONArray.optJSONObject(i));
            if (bn != null) {
                hashMap.put(bn.ewI, bn);
            }
        }
        return hashMap;
    }

    public void a(final c cVar, final d dVar) {
        final HybridUbcFlow rd = i.rd("startup");
        rd.f(new UbcFlowEvent("loadPresetApp-start").gt(true));
        if (dVar != null) {
            if (cVar == null) {
                dVar.onFailed(0);
                return;
            }
            p.a(new Runnable() { // from class: com.baidu.swan.apps.core.j.b.1
                @Override // java.lang.Runnable
                public void run() {
                    rd.f(new UbcFlowEvent("loadPresetApp#run-start").gt(true));
                    String nV = b.this.nV(cVar.ewI);
                    if (TextUtils.isEmpty(nV)) {
                        dVar.onFailed(0);
                        return;
                    }
                    JSONObject parseString = v.parseString(nV);
                    rd.f(new UbcFlowEvent("loadPresetApp#run-appInfoJson").gt(true));
                    PMSAppInfo a2 = b.this.a(cVar, parseString);
                    if (a2 == null) {
                        dVar.onFailed(1);
                        return;
                    }
                    rd.f(new UbcFlowEvent("loadPresetApp#run-PMSAppInfo").gt(true));
                    dVar.i(a2);
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean a3 = b.this.a(cVar);
                    if (b.DEBUG) {
                        Log.d("PresetController", "签名+解压 耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    rd.f(new UbcFlowEvent("loadPresetApp#run-doUnzipBundle").gt(true));
                    if (a3) {
                        a2.setOrientation(b.this.b(cVar.category, cVar.ewI, cVar.versionCode));
                        a2.nu(3);
                        com.baidu.swan.pms.database.a.bgc().a(cVar, a2);
                        rd.f(new UbcFlowEvent("loadPresetApp#run-bulkInsert").gt(true));
                        dVar.j(a2);
                    } else {
                        dVar.onFailed(2);
                    }
                    rd.f(new UbcFlowEvent("loadPresetApp#run-return").gt(true));
                }
            }, "加载小程序预置包");
            rd.f(new UbcFlowEvent("loadPresetApp-return").gt(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i, String str, long j) {
        com.baidu.swan.games.t.a.a k;
        if (i != 1 || (k = com.baidu.swan.apps.core.pms.f.a.k(str, j)) == null) {
            return 0;
        }
        return k.emx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PMSAppInfo a(c cVar, JSONObject jSONObject) {
        PMSAppInfo di;
        if (jSONObject == null || cVar == null || (di = com.baidu.swan.pms.utils.e.di(jSONObject)) == null) {
            return null;
        }
        di.h(cVar);
        di.createTime = System.currentTimeMillis();
        return di;
    }

    private c bn(JSONObject jSONObject) {
        c cVar;
        if (jSONObject != null && (cVar = (c) com.baidu.swan.pms.utils.e.a(jSONObject, new c())) != null) {
            cVar.ewM = jSONObject.optInt("pkg_type");
            cVar.cYT = jSONObject.optString("bundle_name");
            if (cVar.auW()) {
                return cVar;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public File c(int i, String str, long j) {
        if (i == 0) {
            return d.C0466d.bS(str, String.valueOf(j));
        }
        if (i == 1) {
            return a.c.bS(str, String.valueOf(j));
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
                    boolean b2 = ae.b(readableByteChannel, str);
                    if (DEBUG) {
                        Log.d("PresetController", "签名校验结果：" + b2 + " ,耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    return b2;
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
