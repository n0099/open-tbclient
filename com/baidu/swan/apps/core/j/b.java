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

    protected abstract String aqZ();

    protected abstract String mK(String str);

    public HashMap<String, c> ara() {
        JSONArray optJSONArray;
        String aqZ = aqZ();
        if (TextUtils.isEmpty(aqZ) || (optJSONArray = v.parseString(aqZ).optJSONArray("list")) == null) {
            return null;
        }
        HashMap<String, c> hashMap = new HashMap<>();
        for (int i = 0; i < optJSONArray.length(); i++) {
            c bn = bn(optJSONArray.optJSONObject(i));
            if (bn != null) {
                hashMap.put(bn.erV, bn);
            }
        }
        return hashMap;
    }

    public void a(final c cVar, final d dVar) {
        final HybridUbcFlow pS = i.pS("startup");
        pS.f(new UbcFlowEvent("loadPresetApp-start").gp(true));
        if (dVar != null) {
            if (cVar == null) {
                dVar.onFailed(0);
                return;
            }
            p.a(new Runnable() { // from class: com.baidu.swan.apps.core.j.b.1
                @Override // java.lang.Runnable
                public void run() {
                    pS.f(new UbcFlowEvent("loadPresetApp#run-start").gp(true));
                    String mK = b.this.mK(cVar.erV);
                    if (TextUtils.isEmpty(mK)) {
                        dVar.onFailed(0);
                        return;
                    }
                    JSONObject parseString = v.parseString(mK);
                    pS.f(new UbcFlowEvent("loadPresetApp#run-appInfoJson").gp(true));
                    PMSAppInfo a2 = b.this.a(cVar, parseString);
                    if (a2 == null) {
                        dVar.onFailed(1);
                        return;
                    }
                    pS.f(new UbcFlowEvent("loadPresetApp#run-PMSAppInfo").gp(true));
                    dVar.i(a2);
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean a3 = b.this.a(cVar);
                    if (b.DEBUG) {
                        Log.d("PresetController", "签名+解压 耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    pS.f(new UbcFlowEvent("loadPresetApp#run-doUnzipBundle").gp(true));
                    if (a3) {
                        a2.setOrientation(b.this.b(cVar.category, cVar.erV, cVar.versionCode));
                        a2.lO(3);
                        com.baidu.swan.pms.database.a.bci().a(cVar, a2);
                        pS.f(new UbcFlowEvent("loadPresetApp#run-bulkInsert").gp(true));
                        dVar.j(a2);
                    } else {
                        dVar.onFailed(2);
                    }
                    pS.f(new UbcFlowEvent("loadPresetApp#run-return").gp(true));
                }
            }, "加载小程序预置包");
            pS.f(new UbcFlowEvent("loadPresetApp-return").gp(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i, String str, long j) {
        com.baidu.swan.games.t.a.a k;
        if (i != 1 || (k = com.baidu.swan.apps.core.pms.f.a.k(str, j)) == null) {
            return 0;
        }
        return k.ehL;
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
            cVar.erZ = jSONObject.optInt("pkg_type");
            cVar.cUh = jSONObject.optString("bundle_name");
            if (cVar.arb()) {
                return cVar;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public File c(int i, String str, long j) {
        if (i == 0) {
            return d.C0449d.bR(str, String.valueOf(j));
        }
        if (i == 1) {
            return a.c.bR(str, String.valueOf(j));
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
