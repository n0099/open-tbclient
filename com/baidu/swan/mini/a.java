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
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final List<Long> cAh = new CopyOnWriteArrayList();
    private static final Map<String, Integer> cAi = new ConcurrentHashMap();
    private com.baidu.swan.mini.slave.a cAk;
    private final ConcurrentHashMap<String, com.baidu.swan.mini.master.a> cAj = new ConcurrentHashMap<>();
    private boolean cAl = false;
    private SwanCoreVersion cAm = null;
    private boolean cAn = false;
    private com.baidu.swan.mini.d.b cAo = new com.baidu.swan.mini.d.b();

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
            SwanCoreVersion swanCoreVersion = this.cAm;
            for (int i = 0; i < length; i++) {
                com.baidu.swan.mini.b.a bL = com.baidu.swan.mini.b.a.bL(jSONArray.optJSONObject(i));
                if (swanCoreVersion == null) {
                    d(2, "Runtime has been reset while loading master", false);
                    return;
                }
                if (bL.atn() && bL.bh(swanCoreVersion.swanCoreVersion)) {
                    a(bL);
                } else if (!TextUtils.isEmpty(bL.ato())) {
                    a(bL.ato(), 2, "Card info data not valid", false, bL.atp().getAppId(), bL.atp().getBundleId());
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

    public void ak(@NonNull List<String> list) {
        for (String str : list) {
            a(this.cAj.remove(str));
        }
    }

    private void a(@Nullable com.baidu.swan.mini.master.a aVar) {
        if (aVar != null) {
            if (DEBUG) {
                Log.i("SwanMiniRuntime", "Destroying master: " + aVar.atm());
            }
            qg(aVar.atm());
            aVar.finish();
        }
    }

    private void a(@NonNull final com.baidu.swan.mini.b.a aVar) {
        final String ato = aVar.ato();
        String appId = aVar.atp().getAppId();
        String bundleId = aVar.atp().getBundleId();
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Start load master (async), id = " + ato + ", appKey = " + appId + "/" + bundleId);
        }
        SwanCoreVersion swanCoreVersion = this.cAm;
        if (swanCoreVersion == null || TextUtils.isEmpty(swanCoreVersion.swanCorePath)) {
            a(ato, 2, "Can't load Master js", false, appId, bundleId);
            return;
        }
        this.cAo.m(ato, 101, "NA Load Master");
        com.baidu.swan.mini.master.a aVar2 = new com.baidu.swan.mini.master.a(c.qm(swanCoreVersion.swanCorePath), "master.js", new SwanMiniMasterJsInterface(this, ato));
        this.cAj.put(ato, aVar2);
        aVar2.a(new a.b() { // from class: com.baidu.swan.mini.a.1
            @Override // com.baidu.swan.mini.master.a.b
            public void c(com.baidu.swan.games.e.a aVar3) {
                if (a.DEBUG) {
                    Log.i("SwanMiniRuntime", "Master loaded, id = " + ato);
                }
                a.this.cAo.m(ato, 102, "NA Master Loaded");
                a.this.qd(ato);
                a.this.b(aVar);
            }
        });
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Started load master (async), id = " + ato);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull final com.baidu.swan.mini.b.a aVar) {
        final String ato = aVar.ato();
        final com.baidu.swan.pms.b.a atp = aVar.atp();
        final String appId = atp.getAppId();
        final String bundleId = atp.getBundleId();
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Start load miniApp (async), id = " + ato + ", appKey = " + appId + "/" + bundleId);
        }
        this.cAo.m(ato, 104, "NA Load App");
        com.baidu.swan.mini.c.a.a(atp, new c.a() { // from class: com.baidu.swan.mini.a.2
            @Override // com.baidu.swan.mini.e.c.a
            public void onSuccess(final String str) {
                if (a.DEBUG) {
                    Log.i("SwanMiniRuntime", "Load MiniApp success, id = " + ato + ", appKey = " + appId + "/" + bundleId);
                    Log.v("SwanMiniRuntime", "MiniApp path: " + str);
                }
                a.this.cAo.m(ato, 105, "NA App Downloaded");
                a.this.qf(str);
                c.a(str, new c.b() { // from class: com.baidu.swan.mini.a.2.1
                    @Override // com.baidu.swan.mini.e.c.b
                    public void qh(@NonNull String str2) {
                        if (TextUtils.isEmpty(str2)) {
                            a.this.qg(str);
                            a.this.a(ato, 4, "Can't load code info json", true, appId, bundleId);
                            return;
                        }
                        a.this.a(aVar, str, str2);
                        com.baidu.swan.mini.c.b.c(atp);
                    }
                });
            }

            @Override // com.baidu.swan.mini.e.c.a
            public void onFailed(int i, String str) {
                a.this.a(ato, 3, "Download error by pms: " + str + "(" + i + ")", true, appId, bundleId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qd(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Instance id is null when notifying master ready");
            }
        } else if (this.cAk == null) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Null Slave when notifying master ready, id: " + str);
            }
        } else {
            this.cAk.evaluateJavascript(com.baidu.swan.mini.e.a.qk(str), null);
            if (DEBUG) {
                Log.d("SwanMiniRuntime", "MasterReady notified to slave, id = " + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.baidu.swan.mini.b.a aVar, @Nullable String str, @Nullable String str2) {
        String ato = aVar.ato();
        if (this.cAk == null) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Slave is null when notifying app ready");
            }
            qg(str);
            return;
        }
        com.baidu.swan.mini.master.a aVar2 = this.cAj.get(ato);
        com.baidu.swan.games.e.a v8Engine = aVar2 == null ? null : aVar2.getV8Engine();
        if (v8Engine == null) {
            a(ato, 4, "Master error", false, aVar.atp().getAppId(), aVar.atp().getBundleId());
            qg(str);
        } else if (TextUtils.isEmpty(str)) {
            a(ato, 4, "App file path empty", true, aVar.atp().getAppId(), aVar.atp().getBundleId());
        } else {
            aVar2.qi(str);
            if (TextUtils.isEmpty(str2)) {
                a(ato, 4, "App info Json Empty", true, aVar.atp().getAppId(), aVar.atp().getBundleId());
                return;
            }
            try {
                new JSONObject(str2);
                this.cAo.m(ato, 106, "NA App Loaded");
                aVar2.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.aw("appjs", str));
                v8Engine.evaluateJavascript(com.baidu.swan.mini.e.a.t(str, str2, this.cAl), null);
                if (DEBUG) {
                    Log.d("SwanMiniRuntime", "AppReady sent to Master, id = " + ato);
                }
                this.cAk.evaluateJavascript(com.baidu.swan.mini.e.a.a(aVar, str2), null);
                if (DEBUG) {
                    Log.d("SwanMiniRuntime", "AppReady sent to Slave, id = " + ato);
                }
            } catch (Exception e) {
                a(ato, 4, "App info json is illegal", true, aVar.atp().getAppId(), aVar.atp().getBundleId());
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
        if (this.cAk != null) {
            this.cAk.evaluateJavascript(com.baidu.swan.mini.e.a.a(arrayList, i, str2, z), null);
        }
        this.cAo.d(i, str2, str3, str4);
    }

    public void bZ(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.mini.master.a qe = qe(str);
        if (qe != null && qe.getV8Engine() != null) {
            if (DEBUG) {
                Log.v("SwanMiniRuntime", "Message sent to master, id = " + str + ", Message = " + str2);
            }
            d.c(qe.getV8Engine(), str2);
        }
    }

    public void ca(@Nullable String str, @Nullable String str2) {
        if (this.cAk != null) {
            if (DEBUG) {
                Log.v("SwanMiniRuntime", "Message sent to slave, id = " + str + ", Message = " + str2);
            }
            d.a(this.cAk, str, str2);
        }
    }

    @Nullable
    public com.baidu.swan.mini.master.a qe(@Nullable String str) {
        return this.cAj.get(str);
    }

    public void b(boolean z, @Nullable String str, @NonNull String str2) {
        if (DEBUG) {
            Log.d("SwanMiniRuntime", (z ? "【MiniMasterLog】" : "【MiniSlaveLog】") + "【" + str + "】" + str2 + "(" + System.currentTimeMillis() + ")");
        }
    }

    @NonNull
    public static List<Long> ath() {
        return cAh;
    }

    public static Set<String> ati() {
        return cAi.keySet();
    }

    public boolean atj() {
        return this.cAn;
    }

    @NonNull
    public com.baidu.swan.mini.d.b atk() {
        return this.cAo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qf(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (a.class) {
                Integer num = cAi.get(str);
                if (num != null) {
                    cAi.put(str, Integer.valueOf(num.intValue() + 1));
                } else {
                    cAi.put(str, 1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (a.class) {
                Integer num = cAi.get(str);
                if (num != null) {
                    Integer valueOf = Integer.valueOf(num.intValue() - 1);
                    if (valueOf.intValue() > 0) {
                        cAi.put(str, valueOf);
                    } else {
                        cAi.remove(str);
                    }
                }
            }
        }
    }
}
