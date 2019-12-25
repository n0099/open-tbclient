package com.baidu.swan.mini;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.mini.e.c;
import com.baidu.swan.mini.e.d;
import com.baidu.swan.mini.master.SwanMiniMasterJsInterface;
import com.baidu.swan.mini.master.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final List<Long> cvL = new CopyOnWriteArrayList();
    private static final Map<String, Integer> cvM = new ConcurrentHashMap();
    private com.baidu.swan.mini.slave.a cvO;
    private final ConcurrentHashMap<String, com.baidu.swan.mini.master.a> cvN = new ConcurrentHashMap<>();
    private boolean cvP = false;
    private SwanCoreVersion cvQ = null;
    private boolean cvR = false;
    private com.baidu.swan.mini.d.b cvS = new com.baidu.swan.mini.d.b();

    public void loadMasters(@NonNull String str) {
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Start load all masters (async)");
            Log.v("SwanMiniRuntime", "Card info: " + str);
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            if (length == 0) {
                d(2, "Card info array empty", false);
                return;
            }
            SwanCoreVersion swanCoreVersion = this.cvQ;
            for (int i = 0; i < length; i++) {
                com.baidu.swan.mini.b.a bL = com.baidu.swan.mini.b.a.bL(jSONArray.optJSONObject(i));
                if (swanCoreVersion == null) {
                    d(2, "Runtime has been reset while loading master", false);
                    return;
                }
                if (bL.aqB() && bL.ba(swanCoreVersion.swanCoreVersion)) {
                    a(bL);
                } else if (!TextUtils.isEmpty(bL.aqC())) {
                    a(bL.aqC(), 2, "Card info data not valid", false, bL.aqD().getAppId(), bL.aqD().getBundleId());
                } else {
                    d(2, "Card info data not valid, no instance id", false);
                    return;
                }
            }
            if (DEBUG) {
                Log.i("SwanMiniRuntime", "All master started to load (async)");
            }
        } catch (JSONException e) {
            d(2, "Card info array parse error", false);
        } catch (Exception e2) {
            d(2, "Caught exception: " + e2.getMessage(), false);
        }
    }

    public void al(@NonNull List<String> list) {
        for (String str : list) {
            a(this.cvN.remove(str));
        }
    }

    private void a(@Nullable com.baidu.swan.mini.master.a aVar) {
        if (aVar != null) {
            if (DEBUG) {
                Log.i("SwanMiniRuntime", "Destroying master: " + aVar.aqA());
            }
            pP(aVar.aqA());
            aVar.finish();
        }
    }

    private void a(@NonNull final com.baidu.swan.mini.b.a aVar) {
        final String aqC = aVar.aqC();
        String appId = aVar.aqD().getAppId();
        String bundleId = aVar.aqD().getBundleId();
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Start load master (async), id = " + aqC + ", appKey = " + appId + "/" + bundleId);
        }
        SwanCoreVersion swanCoreVersion = this.cvQ;
        if (swanCoreVersion == null || TextUtils.isEmpty(swanCoreVersion.swanCorePath)) {
            a(aqC, 2, "Can't load Master js", false, appId, bundleId);
            return;
        }
        this.cvS.l(aqC, 101, "NA Load Master");
        com.baidu.swan.mini.master.a aVar2 = new com.baidu.swan.mini.master.a(c.pV(swanCoreVersion.swanCorePath), "master.js", new SwanMiniMasterJsInterface(this, aqC));
        this.cvN.put(aqC, aVar2);
        aVar2.a(new a.b() { // from class: com.baidu.swan.mini.a.1
            @Override // com.baidu.swan.mini.master.a.b
            public void c(com.baidu.swan.games.e.a aVar3) {
                if (a.DEBUG) {
                    Log.i("SwanMiniRuntime", "Master loaded, id = " + aqC);
                }
                a.this.cvS.l(aqC, 102, "NA Master Loaded");
                a.this.pM(aqC);
                a.this.b(aVar);
            }
        });
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Started load master (async), id = " + aqC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull final com.baidu.swan.mini.b.a aVar) {
        final String aqC = aVar.aqC();
        final com.baidu.swan.pms.b.a aqD = aVar.aqD();
        final String appId = aqD.getAppId();
        final String bundleId = aqD.getBundleId();
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Start load miniApp (async), id = " + aqC + ", appKey = " + appId + "/" + bundleId);
        }
        this.cvS.l(aqC, 104, "NA Load App");
        com.baidu.swan.mini.c.a.a(aqD, new c.a() { // from class: com.baidu.swan.mini.a.2
            @Override // com.baidu.swan.mini.e.c.a
            public void onSuccess(final String str) {
                if (a.DEBUG) {
                    Log.i("SwanMiniRuntime", "Load MiniApp success, id = " + aqC + ", appKey = " + appId + "/" + bundleId);
                    Log.v("SwanMiniRuntime", "MiniApp path: " + str);
                }
                a.this.cvS.l(aqC, 105, "NA App Downloaded");
                a.this.pO(str);
                c.a(str, new c.b() { // from class: com.baidu.swan.mini.a.2.1
                    @Override // com.baidu.swan.mini.e.c.b
                    public void pQ(@NonNull String str2) {
                        if (TextUtils.isEmpty(str2)) {
                            a.this.pP(str);
                            a.this.a(aqC, 4, "Can't load code info json", true, appId, bundleId);
                            return;
                        }
                        a.this.a(aVar, str, str2);
                        com.baidu.swan.mini.c.b.c(aqD);
                    }
                });
            }

            @Override // com.baidu.swan.mini.e.c.a
            public void onFailed(int i, String str) {
                a.this.a(aqC, 3, "Download error by pms: " + str + "(" + i + ")", true, appId, bundleId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pM(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Instance id is null when notifying master ready");
            }
        } else if (this.cvO == null) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Null Slave when notifying master ready, id: " + str);
            }
        } else {
            this.cvO.evaluateJavascript(com.baidu.swan.mini.e.a.pT(str), null);
            if (DEBUG) {
                Log.d("SwanMiniRuntime", "MasterReady notified to slave, id = " + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.baidu.swan.mini.b.a aVar, @Nullable String str, @Nullable String str2) {
        String aqC = aVar.aqC();
        if (this.cvO == null) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Slave is null when notifying app ready");
            }
            pP(str);
            return;
        }
        com.baidu.swan.mini.master.a aVar2 = this.cvN.get(aqC);
        com.baidu.swan.games.e.a v8Engine = aVar2 == null ? null : aVar2.getV8Engine();
        if (v8Engine == null) {
            a(aqC, 4, "Master error", false, aVar.aqD().getAppId(), aVar.aqD().getBundleId());
            pP(str);
        } else if (TextUtils.isEmpty(str)) {
            a(aqC, 4, "App file path empty", true, aVar.aqD().getAppId(), aVar.aqD().getBundleId());
        } else {
            aVar2.pR(str);
            if (TextUtils.isEmpty(str2)) {
                a(aqC, 4, "App info Json Empty", true, aVar.aqD().getAppId(), aVar.aqD().getBundleId());
                return;
            }
            try {
                new JSONObject(str2);
                this.cvS.l(aqC, 106, "NA App Loaded");
                aVar2.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.am("appjs", str));
                v8Engine.evaluateJavascript(com.baidu.swan.mini.e.a.s(str, str2, this.cvP), null);
                if (DEBUG) {
                    Log.d("SwanMiniRuntime", "AppReady sent to Master, id = " + aqC);
                }
                this.cvO.evaluateJavascript(com.baidu.swan.mini.e.a.a(aVar, str2), null);
                if (DEBUG) {
                    Log.d("SwanMiniRuntime", "AppReady sent to Slave, id = " + aqC);
                }
            } catch (Exception e) {
                a(aqC, 4, "App info json is illegal", true, aVar.aqD().getAppId(), aVar.aqD().getBundleId());
            }
        }
    }

    public void d(int i, @Nullable String str, boolean z) {
        a(null, i, str, z, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable String str, int i, @Nullable String str2, boolean z, @Nullable String str3, @Nullable String str4) {
        if (DEBUG) {
            Log.e("SwanMiniRuntime", "Calling onError(instanceId(null if global): " + str + ", errCode: " + i + ", errMessage: " + str2 + ")");
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        if (this.cvO != null) {
            this.cvO.evaluateJavascript(com.baidu.swan.mini.e.a.a(arrayList, i, str2, z), null);
        }
        this.cvS.d(i, str2, str3, str4);
    }

    public void bQ(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.mini.master.a pN = pN(str);
        if (pN != null && pN.getV8Engine() != null) {
            if (DEBUG) {
                Log.v("SwanMiniRuntime", "Message sent to master, id = " + str + ", Message = " + str2);
            }
            d.c(pN.getV8Engine(), str2);
        }
    }

    public void bR(@Nullable String str, @Nullable String str2) {
        if (this.cvO != null) {
            if (DEBUG) {
                Log.v("SwanMiniRuntime", "Message sent to slave, id = " + str + ", Message = " + str2);
            }
            d.a(this.cvO, str, str2);
        }
    }

    @Nullable
    public com.baidu.swan.mini.master.a pN(@Nullable String str) {
        return this.cvN.get(str);
    }

    public void b(boolean z, @Nullable String str, @NonNull String str2) {
        if (DEBUG) {
            Log.d("SwanMiniRuntime", (z ? "【MiniMasterLog】" : "【MiniSlaveLog】") + "【" + str + "】" + str2 + "(" + System.currentTimeMillis() + ")");
        }
    }

    @NonNull
    public static List<Long> aqv() {
        return cvL;
    }

    public static Set<String> aqw() {
        return cvM.keySet();
    }

    public boolean aqx() {
        return this.cvR;
    }

    @NonNull
    public com.baidu.swan.mini.d.b aqy() {
        return this.cvS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pO(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (a.class) {
                Integer num = cvM.get(str);
                if (num != null) {
                    cvM.put(str, Integer.valueOf(num.intValue() + 1));
                } else {
                    cvM.put(str, 1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pP(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (a.class) {
                Integer num = cvM.get(str);
                if (num != null) {
                    Integer valueOf = Integer.valueOf(num.intValue() - 1);
                    if (valueOf.intValue() > 0) {
                        cvM.put(str, valueOf);
                    } else {
                        cvM.remove(str);
                    }
                }
            }
        }
    }
}
