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
    private static final List<Long> czU = new CopyOnWriteArrayList();
    private static final Map<String, Integer> czV = new ConcurrentHashMap();
    private com.baidu.swan.mini.slave.a czX;
    private final ConcurrentHashMap<String, com.baidu.swan.mini.master.a> czW = new ConcurrentHashMap<>();
    private boolean czY = false;
    private SwanCoreVersion czZ = null;
    private boolean cAa = false;
    private com.baidu.swan.mini.d.b cAb = new com.baidu.swan.mini.d.b();

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
            SwanCoreVersion swanCoreVersion = this.czZ;
            for (int i = 0; i < length; i++) {
                com.baidu.swan.mini.b.a bL = com.baidu.swan.mini.b.a.bL(jSONArray.optJSONObject(i));
                if (swanCoreVersion == null) {
                    d(2, "Runtime has been reset while loading master", false);
                    return;
                }
                if (bL.ati() && bL.bh(swanCoreVersion.swanCoreVersion)) {
                    a(bL);
                } else if (!TextUtils.isEmpty(bL.atj())) {
                    a(bL.atj(), 2, "Card info data not valid", false, bL.atk().getAppId(), bL.atk().getBundleId());
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
            a(this.czW.remove(str));
        }
    }

    private void a(@Nullable com.baidu.swan.mini.master.a aVar) {
        if (aVar != null) {
            if (DEBUG) {
                Log.i("SwanMiniRuntime", "Destroying master: " + aVar.ath());
            }
            qh(aVar.ath());
            aVar.finish();
        }
    }

    private void a(@NonNull final com.baidu.swan.mini.b.a aVar) {
        final String atj = aVar.atj();
        String appId = aVar.atk().getAppId();
        String bundleId = aVar.atk().getBundleId();
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Start load master (async), id = " + atj + ", appKey = " + appId + "/" + bundleId);
        }
        SwanCoreVersion swanCoreVersion = this.czZ;
        if (swanCoreVersion == null || TextUtils.isEmpty(swanCoreVersion.swanCorePath)) {
            a(atj, 2, "Can't load Master js", false, appId, bundleId);
            return;
        }
        this.cAb.m(atj, 101, "NA Load Master");
        com.baidu.swan.mini.master.a aVar2 = new com.baidu.swan.mini.master.a(c.qn(swanCoreVersion.swanCorePath), "master.js", new SwanMiniMasterJsInterface(this, atj));
        this.czW.put(atj, aVar2);
        aVar2.a(new a.b() { // from class: com.baidu.swan.mini.a.1
            @Override // com.baidu.swan.mini.master.a.b
            public void c(com.baidu.swan.games.e.a aVar3) {
                if (a.DEBUG) {
                    Log.i("SwanMiniRuntime", "Master loaded, id = " + atj);
                }
                a.this.cAb.m(atj, 102, "NA Master Loaded");
                a.this.qe(atj);
                a.this.b(aVar);
            }
        });
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Started load master (async), id = " + atj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull final com.baidu.swan.mini.b.a aVar) {
        final String atj = aVar.atj();
        final com.baidu.swan.pms.b.a atk = aVar.atk();
        final String appId = atk.getAppId();
        final String bundleId = atk.getBundleId();
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Start load miniApp (async), id = " + atj + ", appKey = " + appId + "/" + bundleId);
        }
        this.cAb.m(atj, 104, "NA Load App");
        com.baidu.swan.mini.c.a.a(atk, new c.a() { // from class: com.baidu.swan.mini.a.2
            @Override // com.baidu.swan.mini.e.c.a
            public void onSuccess(final String str) {
                if (a.DEBUG) {
                    Log.i("SwanMiniRuntime", "Load MiniApp success, id = " + atj + ", appKey = " + appId + "/" + bundleId);
                    Log.v("SwanMiniRuntime", "MiniApp path: " + str);
                }
                a.this.cAb.m(atj, 105, "NA App Downloaded");
                a.this.qg(str);
                c.a(str, new c.b() { // from class: com.baidu.swan.mini.a.2.1
                    @Override // com.baidu.swan.mini.e.c.b
                    public void qi(@NonNull String str2) {
                        if (TextUtils.isEmpty(str2)) {
                            a.this.qh(str);
                            a.this.a(atj, 4, "Can't load code info json", true, appId, bundleId);
                            return;
                        }
                        a.this.a(aVar, str, str2);
                        com.baidu.swan.mini.c.b.c(atk);
                    }
                });
            }

            @Override // com.baidu.swan.mini.e.c.a
            public void onFailed(int i, String str) {
                a.this.a(atj, 3, "Download error by pms: " + str + "(" + i + ")", true, appId, bundleId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qe(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Instance id is null when notifying master ready");
            }
        } else if (this.czX == null) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Null Slave when notifying master ready, id: " + str);
            }
        } else {
            this.czX.evaluateJavascript(com.baidu.swan.mini.e.a.ql(str), null);
            if (DEBUG) {
                Log.d("SwanMiniRuntime", "MasterReady notified to slave, id = " + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.baidu.swan.mini.b.a aVar, @Nullable String str, @Nullable String str2) {
        String atj = aVar.atj();
        if (this.czX == null) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Slave is null when notifying app ready");
            }
            qh(str);
            return;
        }
        com.baidu.swan.mini.master.a aVar2 = this.czW.get(atj);
        com.baidu.swan.games.e.a v8Engine = aVar2 == null ? null : aVar2.getV8Engine();
        if (v8Engine == null) {
            a(atj, 4, "Master error", false, aVar.atk().getAppId(), aVar.atk().getBundleId());
            qh(str);
        } else if (TextUtils.isEmpty(str)) {
            a(atj, 4, "App file path empty", true, aVar.atk().getAppId(), aVar.atk().getBundleId());
        } else {
            aVar2.qj(str);
            if (TextUtils.isEmpty(str2)) {
                a(atj, 4, "App info Json Empty", true, aVar.atk().getAppId(), aVar.atk().getBundleId());
                return;
            }
            try {
                new JSONObject(str2);
                this.cAb.m(atj, 106, "NA App Loaded");
                aVar2.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.ax("appjs", str));
                v8Engine.evaluateJavascript(com.baidu.swan.mini.e.a.t(str, str2, this.czY), null);
                if (DEBUG) {
                    Log.d("SwanMiniRuntime", "AppReady sent to Master, id = " + atj);
                }
                this.czX.evaluateJavascript(com.baidu.swan.mini.e.a.a(aVar, str2), null);
                if (DEBUG) {
                    Log.d("SwanMiniRuntime", "AppReady sent to Slave, id = " + atj);
                }
            } catch (Exception e) {
                a(atj, 4, "App info json is illegal", true, aVar.atk().getAppId(), aVar.atk().getBundleId());
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
        if (this.czX != null) {
            this.czX.evaluateJavascript(com.baidu.swan.mini.e.a.a(arrayList, i, str2, z), null);
        }
        this.cAb.d(i, str2, str3, str4);
    }

    public void ca(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.mini.master.a qf = qf(str);
        if (qf != null && qf.getV8Engine() != null) {
            if (DEBUG) {
                Log.v("SwanMiniRuntime", "Message sent to master, id = " + str + ", Message = " + str2);
            }
            d.c(qf.getV8Engine(), str2);
        }
    }

    public void cb(@Nullable String str, @Nullable String str2) {
        if (this.czX != null) {
            if (DEBUG) {
                Log.v("SwanMiniRuntime", "Message sent to slave, id = " + str + ", Message = " + str2);
            }
            d.a(this.czX, str, str2);
        }
    }

    @Nullable
    public com.baidu.swan.mini.master.a qf(@Nullable String str) {
        return this.czW.get(str);
    }

    public void b(boolean z, @Nullable String str, @NonNull String str2) {
        if (DEBUG) {
            Log.d("SwanMiniRuntime", (z ? "【MiniMasterLog】" : "【MiniSlaveLog】") + "【" + str + "】" + str2 + "(" + System.currentTimeMillis() + ")");
        }
    }

    @NonNull
    public static List<Long> atc() {
        return czU;
    }

    public static Set<String> atd() {
        return czV.keySet();
    }

    public boolean ate() {
        return this.cAa;
    }

    @NonNull
    public com.baidu.swan.mini.d.b atf() {
        return this.cAb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (a.class) {
                Integer num = czV.get(str);
                if (num != null) {
                    czV.put(str, Integer.valueOf(num.intValue() + 1));
                } else {
                    czV.put(str, 1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qh(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (a.class) {
                Integer num = czV.get(str);
                if (num != null) {
                    Integer valueOf = Integer.valueOf(num.intValue() - 1);
                    if (valueOf.intValue() > 0) {
                        czV.put(str, valueOf);
                    } else {
                        czV.remove(str);
                    }
                }
            }
        }
    }
}
