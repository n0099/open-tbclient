package com.baidu.swan.apps.core.i;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.ab;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.as.s;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.t.a.a;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.games.k.a;
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

    protected abstract String XJ();

    protected abstract boolean a(c cVar);

    protected abstract String iC(String str);

    public HashMap<String, c> XK() {
        JSONArray optJSONArray;
        String XJ = XJ();
        if (TextUtils.isEmpty(XJ) || (optJSONArray = s.parseString(XJ).optJSONArray("list")) == null) {
            return null;
        }
        HashMap<String, c> hashMap = new HashMap<>();
        for (int i = 0; i < optJSONArray.length(); i++) {
            c as = as(optJSONArray.optJSONObject(i));
            if (as != null) {
                hashMap.put(as.dan, as);
            }
        }
        return hashMap;
    }

    public void a(final c cVar, final d dVar) {
        final HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
        lb.f(new UbcFlowEvent("loadPresetApp-start").ed(true));
        if (dVar != null) {
            if (cVar == null) {
                dVar.onFailed(0);
                return;
            }
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.i.b.1
                @Override // java.lang.Runnable
                public void run() {
                    lb.f(new UbcFlowEvent("loadPresetApp#run-start").ed(true));
                    String iC = b.this.iC(cVar.dan);
                    if (TextUtils.isEmpty(iC)) {
                        dVar.onFailed(0);
                        return;
                    }
                    JSONObject parseString = s.parseString(iC);
                    lb.f(new UbcFlowEvent("loadPresetApp#run-appInfoJson").ed(true));
                    PMSAppInfo a = b.this.a(cVar, parseString);
                    if (a == null) {
                        dVar.onFailed(1);
                        return;
                    }
                    lb.f(new UbcFlowEvent("loadPresetApp#run-PMSAppInfo").ed(true));
                    dVar.e(a);
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean a2 = b.this.a(cVar);
                    if (b.DEBUG) {
                        Log.d("PresetController", "签名+解压 耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    lb.f(new UbcFlowEvent("loadPresetApp#run-doUnzipBundle").ed(true));
                    if (a2) {
                        a.setOrientation(b.this.c(cVar.category, cVar.dan, cVar.versionCode));
                        com.baidu.swan.pms.database.a.aBI().a(cVar, a);
                        lb.f(new UbcFlowEvent("loadPresetApp#run-bulkInsert").ed(true));
                        dVar.f(a);
                    } else {
                        dVar.onFailed(2);
                    }
                    lb.f(new UbcFlowEvent("loadPresetApp#run-return").ed(true));
                }
            }, "加载小程序预置包");
            lb.f(new UbcFlowEvent("loadPresetApp-return").ed(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i, String str, int i2) {
        com.baidu.swan.games.s.a.a G;
        if (i != 1 || (G = com.baidu.swan.apps.core.pms.d.a.G(str, i2)) == null) {
            return 0;
        }
        return G.cQr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PMSAppInfo a(c cVar, JSONObject jSONObject) {
        PMSAppInfo cn;
        if (jSONObject == null || cVar == null || (cn = com.baidu.swan.pms.f.d.cn(jSONObject)) == null) {
            return null;
        }
        cn.h(cVar);
        cn.createTime = System.currentTimeMillis();
        return cn;
    }

    private c as(JSONObject jSONObject) {
        c cVar;
        if (jSONObject != null && (cVar = (c) com.baidu.swan.pms.f.d.a(jSONObject, new c())) != null) {
            cVar.daz = jSONObject.optInt("pkg_type");
            cVar.bPA = jSONObject.optString("bundle_name");
            if (cVar.XL()) {
                return cVar;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public File d(int i, String str, int i2) {
        if (i == 0) {
            return e.d.aT(str, String.valueOf(i2));
        }
        if (i == 1) {
            return a.c.aT(str, String.valueOf(i2));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(BufferedInputStream bufferedInputStream, File file) {
        boolean z = false;
        if (bufferedInputStream != null) {
            try {
                if (file != null) {
                    a.b a = com.baidu.swan.apps.t.a.a.a(bufferedInputStream);
                    if ((a == null || a.type == -1) ? false : true) {
                        z = com.baidu.swan.apps.t.a.a.a(bufferedInputStream, file, a.type).isSuccess;
                    } else {
                        z = com.baidu.swan.d.f.e(bufferedInputStream, file.getPath());
                    }
                }
            } catch (IOException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            } finally {
                com.baidu.swan.d.c.closeSafely(bufferedInputStream);
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
                    boolean b = ab.b(readableByteChannel, str);
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
                com.baidu.swan.d.c.closeSafely(readableByteChannel);
            }
        }
        return false;
    }
}
