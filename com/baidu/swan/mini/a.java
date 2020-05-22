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
    private static final List<Long> dko = new CopyOnWriteArrayList();
    private static final Map<String, Integer> dkp = new ConcurrentHashMap();
    private com.baidu.swan.mini.slave.a dkr;
    private final ConcurrentHashMap<String, com.baidu.swan.mini.master.a> dkq = new ConcurrentHashMap<>();
    private boolean dks = false;
    private SwanCoreVersion dkt = null;
    private boolean dku = false;
    private com.baidu.swan.mini.d.b dkv = new com.baidu.swan.mini.d.b();

    public void loadMasters(@NonNull String str) {
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Start load all masters (async)");
            Log.v("SwanMiniRuntime", "Card info: " + str);
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            if (length == 0) {
                e(2, "Card info array empty", false);
                return;
            }
            SwanCoreVersion swanCoreVersion = this.dkt;
            for (int i = 0; i < length; i++) {
                com.baidu.swan.mini.b.a bX = com.baidu.swan.mini.b.a.bX(jSONArray.optJSONObject(i));
                if (swanCoreVersion == null) {
                    e(2, "Runtime has been reset while loading master", false);
                    return;
                }
                if (bX.aFp() && bX.bK(swanCoreVersion.swanCoreVersion)) {
                    a(bX);
                } else if (!TextUtils.isEmpty(bX.aFq())) {
                    a(bX.aFq(), 2, "Card info data not valid", false, bX.aFr().getAppId(), bX.aFr().getBundleId());
                } else {
                    e(2, "Card info data not valid, no instance id", false);
                    return;
                }
            }
            if (DEBUG) {
                Log.i("SwanMiniRuntime", "All master started to load (async)");
            }
        } catch (JSONException e) {
            e(2, "Card info array parse error", false);
        } catch (Exception e2) {
            e(2, "Caught exception: " + e2.getMessage(), false);
        }
    }

    public void ao(@NonNull List<String> list) {
        for (String str : list) {
            a(this.dkq.remove(str));
        }
    }

    private void a(@Nullable com.baidu.swan.mini.master.a aVar) {
        if (aVar != null) {
            if (DEBUG) {
                Log.i("SwanMiniRuntime", "Destroying master: " + aVar.aFo());
            }
            sW(aVar.aFo());
            aVar.finish();
        }
    }

    private void a(@NonNull final com.baidu.swan.mini.b.a aVar) {
        final String aFq = aVar.aFq();
        String appId = aVar.aFr().getAppId();
        String bundleId = aVar.aFr().getBundleId();
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Start load master (async), id = " + aFq + ", appKey = " + appId + "/" + bundleId);
        }
        SwanCoreVersion swanCoreVersion = this.dkt;
        if (swanCoreVersion == null || TextUtils.isEmpty(swanCoreVersion.swanCorePath)) {
            a(aFq, 2, "Can't load Master js", false, appId, bundleId);
            return;
        }
        this.dkv.U(aFq, "na_load_master_start", "NA Load Master");
        com.baidu.swan.mini.master.a aVar2 = new com.baidu.swan.mini.master.a(c.tb(swanCoreVersion.swanCorePath), "master.js", new SwanMiniMasterJsInterface(this, aFq));
        this.dkq.put(aFq, aVar2);
        aVar2.a(new a.b() { // from class: com.baidu.swan.mini.a.1
            @Override // com.baidu.swan.mini.master.a.b
            public void c(com.baidu.swan.games.f.a aVar3) {
                if (a.DEBUG) {
                    Log.i("SwanMiniRuntime", "Master loaded, id = " + aFq);
                }
                a.this.dkv.U(aFq, "na_load_master_end", "NA Master Loaded");
                a.this.a(aFq, aVar);
                a.this.b(aVar);
            }
        });
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Started load master (async), id = " + aFq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull final com.baidu.swan.mini.b.a aVar) {
        final String aFq = aVar.aFq();
        final com.baidu.swan.pms.b.a aFr = aVar.aFr();
        final String appId = aFr.getAppId();
        final String bundleId = aFr.getBundleId();
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Start load miniApp (async), id = " + aFq + ", appKey = " + appId + "/" + bundleId);
        }
        this.dkv.U(aFq, "na_download_app_start", "NA Load App");
        com.baidu.swan.mini.c.a.a(aFr, new c.a() { // from class: com.baidu.swan.mini.a.2
            @Override // com.baidu.swan.mini.e.c.a
            public void onSuccess(final String str) {
                if (a.DEBUG) {
                    Log.i("SwanMiniRuntime", "Load MiniApp success, id = " + aFq + ", appKey = " + appId + "/" + bundleId);
                    Log.v("SwanMiniRuntime", "MiniApp path: " + str);
                }
                a.this.dkv.U(aFq, "na_download_app_end", "NA App Downloaded");
                a.this.sV(str);
                c.a(str, new c.b() { // from class: com.baidu.swan.mini.a.2.1
                    @Override // com.baidu.swan.mini.e.c.b
                    public void sX(@NonNull String str2) {
                        if (TextUtils.isEmpty(str2)) {
                            a.this.sW(str);
                            a.this.a(aFq, 4, "Can't load code info json", true, appId, bundleId);
                            return;
                        }
                        a.this.a(aVar, str, str2);
                        com.baidu.swan.mini.c.b.c(aFr);
                    }
                });
            }

            @Override // com.baidu.swan.mini.e.c.a
            public void onFailed(int i, String str) {
                a.this.a(aFq, 3, "Download error by pms: " + str + "(" + i + ")", true, appId, bundleId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable String str, com.baidu.swan.mini.b.a aVar) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Instance id is null when notifying master ready");
            }
        } else if (this.dkr == null) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Null Slave when notifying master ready, id: " + str);
            }
        } else {
            this.dkr.evaluateJavascript(com.baidu.swan.mini.e.a.b(str, aVar), null);
            if (DEBUG) {
                Log.d("SwanMiniRuntime", "MasterReady notified to slave, id = " + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.baidu.swan.mini.b.a aVar, @Nullable String str, @Nullable String str2) {
        String aFq = aVar.aFq();
        if (this.dkr == null) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Slave is null when notifying app ready");
            }
            sW(str);
            return;
        }
        com.baidu.swan.mini.master.a aVar2 = this.dkq.get(aFq);
        com.baidu.swan.games.f.a v8Engine = aVar2 == null ? null : aVar2.getV8Engine();
        if (v8Engine == null) {
            a(aFq, 4, "Master error", false, aVar.aFr().getAppId(), aVar.aFr().getBundleId());
            sW(str);
        } else if (TextUtils.isEmpty(str)) {
            a(aFq, 4, "App file path empty", true, aVar.aFr().getAppId(), aVar.aFr().getBundleId());
        } else {
            aVar2.sY(str);
            if (TextUtils.isEmpty(str2)) {
                a(aFq, 4, "App info Json Empty", true, aVar.aFr().getAppId(), aVar.aFr().getBundleId());
                return;
            }
            try {
                new JSONObject(str2);
                this.dkv.U(aFq, "na_load_app_completed", "NA App Loaded");
                aVar2.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.aV("appjs", str));
                v8Engine.evaluateJavascript(com.baidu.swan.mini.e.a.u(str, str2, this.dks), null);
                if (DEBUG) {
                    Log.d("SwanMiniRuntime", "AppReady sent to Master, id = " + aFq);
                }
                this.dkr.evaluateJavascript(com.baidu.swan.mini.e.a.a(aFq, str2, aVar), null);
                if (DEBUG) {
                    Log.d("SwanMiniRuntime", "AppReady sent to Slave, id = " + aFq);
                }
            } catch (Exception e) {
                a(aFq, 4, "App info json is illegal", true, aVar.aFr().getAppId(), aVar.aFr().getBundleId());
            }
        }
    }

    public void e(int i, @Nullable String str, boolean z) {
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
        if (this.dkr != null) {
            this.dkr.evaluateJavascript(com.baidu.swan.mini.e.a.a(arrayList, i, str2, z), null);
        }
        this.dkv.a(i, str2, str3, str4, str);
    }

    public void cF(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.mini.master.a sU = sU(str);
        if (sU != null && sU.getV8Engine() != null) {
            if (DEBUG) {
                Log.v("SwanMiniRuntime", "Message sent to master, id = " + str + ", Message = " + str2);
            }
            d.c(sU.getV8Engine(), str2);
        }
    }

    public void cG(@Nullable String str, @Nullable String str2) {
        if (this.dkr != null) {
            if (DEBUG) {
                Log.v("SwanMiniRuntime", "Message sent to slave, id = " + str + ", Message = " + str2);
            }
            d.a(this.dkr, str, str2);
        }
    }

    @Nullable
    public com.baidu.swan.mini.master.a sU(@Nullable String str) {
        return this.dkq.get(str);
    }

    public void b(boolean z, @Nullable String str, @NonNull String str2) {
        if (DEBUG) {
            Log.d("SwanMiniRuntime", (z ? "【MiniMasterLog】" : "【MiniSlaveLog】") + "【" + str + "】" + str2 + "(" + System.currentTimeMillis() + ")");
        }
    }

    @NonNull
    public static List<Long> aFj() {
        return dko;
    }

    public static Set<String> aFk() {
        return dkp.keySet();
    }

    public boolean aFl() {
        return this.dku;
    }

    @NonNull
    public com.baidu.swan.mini.d.b aFm() {
        return this.dkv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sV(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (a.class) {
                Integer num = dkp.get(str);
                if (num != null) {
                    dkp.put(str, Integer.valueOf(num.intValue() + 1));
                } else {
                    dkp.put(str, 1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sW(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (a.class) {
                Integer num = dkp.get(str);
                if (num != null) {
                    Integer valueOf = Integer.valueOf(num.intValue() - 1);
                    if (valueOf.intValue() > 0) {
                        dkp.put(str, valueOf);
                    } else {
                        dkp.remove(str);
                    }
                }
            }
        }
    }
}
