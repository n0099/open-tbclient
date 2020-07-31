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
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final List<Long> duQ = new CopyOnWriteArrayList();
    private static final Map<String, Integer> duR = new ConcurrentHashMap();
    private com.baidu.swan.mini.slave.a duT;
    private final ConcurrentHashMap<String, com.baidu.swan.mini.master.a> duS = new ConcurrentHashMap<>();
    private boolean duU = false;
    private SwanCoreVersion duV = null;
    private boolean duW = false;
    private com.baidu.swan.mini.d.b duX = new com.baidu.swan.mini.d.b();

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
            SwanCoreVersion swanCoreVersion = this.duV;
            for (int i = 0; i < length; i++) {
                com.baidu.swan.mini.b.a ck = com.baidu.swan.mini.b.a.ck(jSONArray.optJSONObject(i));
                if (swanCoreVersion == null) {
                    e(2, "Runtime has been reset while loading master", false);
                    return;
                }
                if (ck.aKm() && ck.bY(swanCoreVersion.swanCoreVersion)) {
                    a(ck);
                } else if (!TextUtils.isEmpty(ck.aKn())) {
                    a(ck.aKn(), 2, "Card info data not valid", false, ck.aKo().getAppId(), ck.aKo().getBundleId());
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

    public void aw(@NonNull List<String> list) {
        for (String str : list) {
            a(this.duS.remove(str));
        }
    }

    private void a(@Nullable com.baidu.swan.mini.master.a aVar) {
        if (aVar != null) {
            if (DEBUG) {
                Log.i("SwanMiniRuntime", "Destroying master: " + aVar.aKl());
            }
            uh(aVar.aKl());
            aVar.finish();
        }
    }

    private void a(@NonNull final com.baidu.swan.mini.b.a aVar) {
        final String aKn = aVar.aKn();
        String appId = aVar.aKo().getAppId();
        String bundleId = aVar.aKo().getBundleId();
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Start load master (async), id = " + aKn + ", appKey = " + appId + "/" + bundleId);
        }
        SwanCoreVersion swanCoreVersion = this.duV;
        if (swanCoreVersion == null || TextUtils.isEmpty(swanCoreVersion.swanCorePath)) {
            a(aKn, 2, "Can't load Master js", false, appId, bundleId);
            return;
        }
        this.duX.V(aKn, "na_load_master_start", "NA Load Master");
        com.baidu.swan.mini.master.a aVar2 = new com.baidu.swan.mini.master.a(c.um(swanCoreVersion.swanCorePath), "master.js", new SwanMiniMasterJsInterface(this, aKn));
        this.duS.put(aKn, aVar2);
        aVar2.a(new a.b() { // from class: com.baidu.swan.mini.a.1
            @Override // com.baidu.swan.mini.master.a.b
            public void c(com.baidu.swan.games.f.a aVar3) {
                if (a.DEBUG) {
                    Log.i("SwanMiniRuntime", "Master loaded, id = " + aKn);
                }
                a.this.duX.V(aKn, "na_load_master_end", "NA Master Loaded");
                a.this.a(aKn, aVar);
                a.this.b(aVar);
            }
        });
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Started load master (async), id = " + aKn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull final com.baidu.swan.mini.b.a aVar) {
        final String aKn = aVar.aKn();
        final com.baidu.swan.pms.b.a aKo = aVar.aKo();
        final String appId = aKo.getAppId();
        final String bundleId = aKo.getBundleId();
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Start load miniApp (async), id = " + aKn + ", appKey = " + appId + "/" + bundleId);
        }
        this.duX.V(aKn, "na_download_app_start", "NA Load App");
        com.baidu.swan.mini.c.a.a(aKo, new c.a() { // from class: com.baidu.swan.mini.a.2
            @Override // com.baidu.swan.mini.e.c.a
            public void onSuccess(final String str) {
                if (a.DEBUG) {
                    Log.i("SwanMiniRuntime", "Load MiniApp success, id = " + aKn + ", appKey = " + appId + "/" + bundleId);
                    Log.v("SwanMiniRuntime", "MiniApp path: " + str);
                }
                a.this.duX.V(aKn, "na_download_app_end", "NA App Downloaded");
                a.this.ug(str);
                c.a(str, new c.b() { // from class: com.baidu.swan.mini.a.2.1
                    @Override // com.baidu.swan.mini.e.c.b
                    public void ui(@NonNull String str2) {
                        if (TextUtils.isEmpty(str2)) {
                            a.this.uh(str);
                            a.this.a(aKn, 4, "Can't load code info json", true, appId, bundleId);
                            return;
                        }
                        a.this.a(aVar, str, str2);
                        com.baidu.swan.mini.c.b.c(aKo);
                    }
                });
            }

            @Override // com.baidu.swan.mini.e.c.a
            public void onFailed(int i, String str) {
                a.this.a(aKn, 3, "Download error by pms: " + str + "(" + i + ")", true, appId, bundleId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable String str, com.baidu.swan.mini.b.a aVar) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Instance id is null when notifying master ready");
            }
        } else if (this.duT == null) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Null Slave when notifying master ready, id: " + str);
            }
        } else {
            this.duT.evaluateJavascript(com.baidu.swan.mini.e.a.b(str, aVar), null);
            if (DEBUG) {
                Log.d("SwanMiniRuntime", "MasterReady notified to slave, id = " + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.baidu.swan.mini.b.a aVar, @Nullable String str, @Nullable String str2) {
        String aKn = aVar.aKn();
        if (this.duT == null) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Slave is null when notifying app ready");
            }
            uh(str);
            return;
        }
        com.baidu.swan.mini.master.a aVar2 = this.duS.get(aKn);
        com.baidu.swan.games.f.a v8Engine = aVar2 == null ? null : aVar2.getV8Engine();
        if (v8Engine == null) {
            a(aKn, 4, "Master error", false, aVar.aKo().getAppId(), aVar.aKo().getBundleId());
            uh(str);
        } else if (TextUtils.isEmpty(str)) {
            a(aKn, 4, "App file path empty", true, aVar.aKo().getAppId(), aVar.aKo().getBundleId());
        } else {
            aVar2.uj(str);
            if (TextUtils.isEmpty(str2)) {
                a(aKn, 4, "App info Json Empty", true, aVar.aKo().getAppId(), aVar.aKo().getBundleId());
                return;
            }
            try {
                new JSONObject(str2);
                this.duX.V(aKn, "na_load_app_completed", "NA App Loaded");
                aVar2.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.aZ("appjs", str));
                v8Engine.evaluateJavascript(com.baidu.swan.mini.e.a.u(str, str2, this.duU), null);
                if (DEBUG) {
                    Log.d("SwanMiniRuntime", "AppReady sent to Master, id = " + aKn);
                }
                this.duT.evaluateJavascript(com.baidu.swan.mini.e.a.a(aKn, str2, aVar), null);
                if (DEBUG) {
                    Log.d("SwanMiniRuntime", "AppReady sent to Slave, id = " + aKn);
                }
            } catch (Exception e) {
                a(aKn, 4, "App info json is illegal", true, aVar.aKo().getAppId(), aVar.aKo().getBundleId());
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
        if (this.duT != null) {
            this.duT.evaluateJavascript(com.baidu.swan.mini.e.a.a(arrayList, i, str2, z), null);
        }
        this.duX.a(i, str2, str3, str4, str);
    }

    public void cK(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.mini.master.a uf = uf(str);
        if (uf != null && uf.getV8Engine() != null) {
            if (DEBUG) {
                Log.v("SwanMiniRuntime", "Message sent to master, id = " + str + ", Message = " + str2);
            }
            d.c(uf.getV8Engine(), str2);
        }
    }

    public void cL(@Nullable String str, @Nullable String str2) {
        if (this.duT != null) {
            if (DEBUG) {
                Log.v("SwanMiniRuntime", "Message sent to slave, id = " + str + ", Message = " + str2);
            }
            d.a(this.duT, str, str2);
        }
    }

    @Nullable
    public com.baidu.swan.mini.master.a uf(@Nullable String str) {
        return this.duS.get(str);
    }

    public void b(boolean z, @Nullable String str, @NonNull String str2) {
        if (DEBUG) {
            Log.d("SwanMiniRuntime", (z ? "【MiniMasterLog】" : "【MiniSlaveLog】") + "【" + str + "】" + str2 + "(" + System.currentTimeMillis() + ")");
        }
    }

    @NonNull
    public static List<Long> aKg() {
        return duQ;
    }

    public static Set<String> aKh() {
        return duR.keySet();
    }

    public boolean aKi() {
        return this.duW;
    }

    @NonNull
    public com.baidu.swan.mini.d.b aKj() {
        return this.duX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ug(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (a.class) {
                Integer num = duR.get(str);
                if (num != null) {
                    duR.put(str, Integer.valueOf(num.intValue() + 1));
                } else {
                    duR.put(str, 1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (a.class) {
                Integer num = duR.get(str);
                if (num != null) {
                    Integer valueOf = Integer.valueOf(num.intValue() - 1);
                    if (valueOf.intValue() > 0) {
                        duR.put(str, valueOf);
                    } else {
                        duR.remove(str);
                    }
                }
            }
        }
    }
}
