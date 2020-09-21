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
/* loaded from: classes3.dex */
abstract class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    protected abstract boolean a(c cVar);

    protected abstract String ajW();

    protected abstract String mh(String str);

    public HashMap<String, c> ajX() {
        JSONArray optJSONArray;
        String ajW = ajW();
        if (TextUtils.isEmpty(ajW) || (optJSONArray = v.parseString(ajW).optJSONArray("list")) == null) {
            return null;
        }
        HashMap<String, c> hashMap = new HashMap<>();
        for (int i = 0; i < optJSONArray.length(); i++) {
            c aT = aT(optJSONArray.optJSONObject(i));
            if (aT != null) {
                hashMap.put(aT.dHr, aT);
            }
        }
        return hashMap;
    }

    public void a(final c cVar, final d dVar) {
        final HybridUbcFlow pq = i.pq("startup");
        pq.f(new UbcFlowEvent("loadPresetApp-start").fa(true));
        if (dVar != null) {
            if (cVar == null) {
                dVar.onFailed(0);
                return;
            }
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.j.b.1
                @Override // java.lang.Runnable
                public void run() {
                    pq.f(new UbcFlowEvent("loadPresetApp#run-start").fa(true));
                    String mh = b.this.mh(cVar.dHr);
                    if (TextUtils.isEmpty(mh)) {
                        dVar.onFailed(0);
                        return;
                    }
                    JSONObject parseString = v.parseString(mh);
                    pq.f(new UbcFlowEvent("loadPresetApp#run-appInfoJson").fa(true));
                    PMSAppInfo a = b.this.a(cVar, parseString);
                    if (a == null) {
                        dVar.onFailed(1);
                        return;
                    }
                    pq.f(new UbcFlowEvent("loadPresetApp#run-PMSAppInfo").fa(true));
                    dVar.i(a);
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean a2 = b.this.a(cVar);
                    if (b.DEBUG) {
                        Log.d("PresetController", "签名+解压 耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    pq.f(new UbcFlowEvent("loadPresetApp#run-doUnzipBundle").fa(true));
                    if (a2) {
                        a.setOrientation(b.this.b(cVar.category, cVar.dHr, cVar.versionCode));
                        a.lZ(3);
                        com.baidu.swan.pms.database.a.aUf().a(cVar, a);
                        pq.f(new UbcFlowEvent("loadPresetApp#run-bulkInsert").fa(true));
                        dVar.j(a);
                    } else {
                        dVar.onFailed(2);
                    }
                    pq.f(new UbcFlowEvent("loadPresetApp#run-return").fa(true));
                }
            }, "加载小程序预置包");
            pq.f(new UbcFlowEvent("loadPresetApp-return").fa(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i, String str, long j) {
        com.baidu.swan.games.t.a.a i2;
        if (i != 1 || (i2 = com.baidu.swan.apps.core.pms.f.a.i(str, j)) == null) {
            return 0;
        }
        return i2.dxT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PMSAppInfo a(c cVar, JSONObject jSONObject) {
        PMSAppInfo cO;
        if (jSONObject == null || cVar == null || (cO = com.baidu.swan.pms.utils.e.cO(jSONObject)) == null) {
            return null;
        }
        cO.h(cVar);
        cO.createTime = System.currentTimeMillis();
        return cO;
    }

    private c aT(JSONObject jSONObject) {
        c cVar;
        if (jSONObject != null && (cVar = (c) com.baidu.swan.pms.utils.e.a(jSONObject, new c())) != null) {
            cVar.dHv = jSONObject.optInt("pkg_type");
            cVar.coj = jSONObject.optString("bundle_name");
            if (cVar.ajY()) {
                return cVar;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public File c(int i, String str, long j) {
        if (i == 0) {
            return d.C0421d.bB(str, String.valueOf(j));
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
