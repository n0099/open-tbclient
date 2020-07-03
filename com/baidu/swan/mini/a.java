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
    private static final List<Long> doZ = new CopyOnWriteArrayList();
    private static final Map<String, Integer> dpa = new ConcurrentHashMap();
    private com.baidu.swan.mini.slave.a dpc;
    private final ConcurrentHashMap<String, com.baidu.swan.mini.master.a> dpb = new ConcurrentHashMap<>();
    private boolean dpd = false;
    private SwanCoreVersion dpe = null;
    private boolean dpf = false;
    private com.baidu.swan.mini.d.b dpg = new com.baidu.swan.mini.d.b();

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
            SwanCoreVersion swanCoreVersion = this.dpe;
            for (int i = 0; i < length; i++) {
                com.baidu.swan.mini.b.a ce = com.baidu.swan.mini.b.a.ce(jSONArray.optJSONObject(i));
                if (swanCoreVersion == null) {
                    e(2, "Runtime has been reset while loading master", false);
                    return;
                }
                if (ce.aGv() && ce.bK(swanCoreVersion.swanCoreVersion)) {
                    a(ce);
                } else if (!TextUtils.isEmpty(ce.aGw())) {
                    a(ce.aGw(), 2, "Card info data not valid", false, ce.aGx().getAppId(), ce.aGx().getBundleId());
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

    public void as(@NonNull List<String> list) {
        for (String str : list) {
            a(this.dpb.remove(str));
        }
    }

    private void a(@Nullable com.baidu.swan.mini.master.a aVar) {
        if (aVar != null) {
            if (DEBUG) {
                Log.i("SwanMiniRuntime", "Destroying master: " + aVar.aGu());
            }
            te(aVar.aGu());
            aVar.finish();
        }
    }

    private void a(@NonNull final com.baidu.swan.mini.b.a aVar) {
        final String aGw = aVar.aGw();
        String appId = aVar.aGx().getAppId();
        String bundleId = aVar.aGx().getBundleId();
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Start load master (async), id = " + aGw + ", appKey = " + appId + "/" + bundleId);
        }
        SwanCoreVersion swanCoreVersion = this.dpe;
        if (swanCoreVersion == null || TextUtils.isEmpty(swanCoreVersion.swanCorePath)) {
            a(aGw, 2, "Can't load Master js", false, appId, bundleId);
            return;
        }
        this.dpg.V(aGw, "na_load_master_start", "NA Load Master");
        com.baidu.swan.mini.master.a aVar2 = new com.baidu.swan.mini.master.a(c.tj(swanCoreVersion.swanCorePath), "master.js", new SwanMiniMasterJsInterface(this, aGw));
        this.dpb.put(aGw, aVar2);
        aVar2.a(new a.b() { // from class: com.baidu.swan.mini.a.1
            @Override // com.baidu.swan.mini.master.a.b
            public void c(com.baidu.swan.games.f.a aVar3) {
                if (a.DEBUG) {
                    Log.i("SwanMiniRuntime", "Master loaded, id = " + aGw);
                }
                a.this.dpg.V(aGw, "na_load_master_end", "NA Master Loaded");
                a.this.a(aGw, aVar);
                a.this.b(aVar);
            }
        });
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Started load master (async), id = " + aGw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull final com.baidu.swan.mini.b.a aVar) {
        final String aGw = aVar.aGw();
        final com.baidu.swan.pms.b.a aGx = aVar.aGx();
        final String appId = aGx.getAppId();
        final String bundleId = aGx.getBundleId();
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Start load miniApp (async), id = " + aGw + ", appKey = " + appId + "/" + bundleId);
        }
        this.dpg.V(aGw, "na_download_app_start", "NA Load App");
        com.baidu.swan.mini.c.a.a(aGx, new c.a() { // from class: com.baidu.swan.mini.a.2
            @Override // com.baidu.swan.mini.e.c.a
            public void onSuccess(final String str) {
                if (a.DEBUG) {
                    Log.i("SwanMiniRuntime", "Load MiniApp success, id = " + aGw + ", appKey = " + appId + "/" + bundleId);
                    Log.v("SwanMiniRuntime", "MiniApp path: " + str);
                }
                a.this.dpg.V(aGw, "na_download_app_end", "NA App Downloaded");
                a.this.td(str);
                c.a(str, new c.b() { // from class: com.baidu.swan.mini.a.2.1
                    @Override // com.baidu.swan.mini.e.c.b
                    public void tf(@NonNull String str2) {
                        if (TextUtils.isEmpty(str2)) {
                            a.this.te(str);
                            a.this.a(aGw, 4, "Can't load code info json", true, appId, bundleId);
                            return;
                        }
                        a.this.a(aVar, str, str2);
                        com.baidu.swan.mini.c.b.c(aGx);
                    }
                });
            }

            @Override // com.baidu.swan.mini.e.c.a
            public void onFailed(int i, String str) {
                a.this.a(aGw, 3, "Download error by pms: " + str + "(" + i + ")", true, appId, bundleId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable String str, com.baidu.swan.mini.b.a aVar) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Instance id is null when notifying master ready");
            }
        } else if (this.dpc == null) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Null Slave when notifying master ready, id: " + str);
            }
        } else {
            this.dpc.evaluateJavascript(com.baidu.swan.mini.e.a.b(str, aVar), null);
            if (DEBUG) {
                Log.d("SwanMiniRuntime", "MasterReady notified to slave, id = " + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.baidu.swan.mini.b.a aVar, @Nullable String str, @Nullable String str2) {
        String aGw = aVar.aGw();
        if (this.dpc == null) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Slave is null when notifying app ready");
            }
            te(str);
            return;
        }
        com.baidu.swan.mini.master.a aVar2 = this.dpb.get(aGw);
        com.baidu.swan.games.f.a v8Engine = aVar2 == null ? null : aVar2.getV8Engine();
        if (v8Engine == null) {
            a(aGw, 4, "Master error", false, aVar.aGx().getAppId(), aVar.aGx().getBundleId());
            te(str);
        } else if (TextUtils.isEmpty(str)) {
            a(aGw, 4, "App file path empty", true, aVar.aGx().getAppId(), aVar.aGx().getBundleId());
        } else {
            aVar2.tg(str);
            if (TextUtils.isEmpty(str2)) {
                a(aGw, 4, "App info Json Empty", true, aVar.aGx().getAppId(), aVar.aGx().getBundleId());
                return;
            }
            try {
                new JSONObject(str2);
                this.dpg.V(aGw, "na_load_app_completed", "NA App Loaded");
                aVar2.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.aX("appjs", str));
                v8Engine.evaluateJavascript(com.baidu.swan.mini.e.a.u(str, str2, this.dpd), null);
                if (DEBUG) {
                    Log.d("SwanMiniRuntime", "AppReady sent to Master, id = " + aGw);
                }
                this.dpc.evaluateJavascript(com.baidu.swan.mini.e.a.a(aGw, str2, aVar), null);
                if (DEBUG) {
                    Log.d("SwanMiniRuntime", "AppReady sent to Slave, id = " + aGw);
                }
            } catch (Exception e) {
                a(aGw, 4, "App info json is illegal", true, aVar.aGx().getAppId(), aVar.aGx().getBundleId());
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
        if (this.dpc != null) {
            this.dpc.evaluateJavascript(com.baidu.swan.mini.e.a.a(arrayList, i, str2, z), null);
        }
        this.dpg.a(i, str2, str3, str4, str);
    }

    public void cH(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.mini.master.a tc = tc(str);
        if (tc != null && tc.getV8Engine() != null) {
            if (DEBUG) {
                Log.v("SwanMiniRuntime", "Message sent to master, id = " + str + ", Message = " + str2);
            }
            d.c(tc.getV8Engine(), str2);
        }
    }

    public void cI(@Nullable String str, @Nullable String str2) {
        if (this.dpc != null) {
            if (DEBUG) {
                Log.v("SwanMiniRuntime", "Message sent to slave, id = " + str + ", Message = " + str2);
            }
            d.a(this.dpc, str, str2);
        }
    }

    @Nullable
    public com.baidu.swan.mini.master.a tc(@Nullable String str) {
        return this.dpb.get(str);
    }

    public void b(boolean z, @Nullable String str, @NonNull String str2) {
        if (DEBUG) {
            Log.d("SwanMiniRuntime", (z ? "【MiniMasterLog】" : "【MiniSlaveLog】") + "【" + str + "】" + str2 + "(" + System.currentTimeMillis() + ")");
        }
    }

    @NonNull
    public static List<Long> aGp() {
        return doZ;
    }

    public static Set<String> aGq() {
        return dpa.keySet();
    }

    public boolean aGr() {
        return this.dpf;
    }

    @NonNull
    public com.baidu.swan.mini.d.b aGs() {
        return this.dpg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void td(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (a.class) {
                Integer num = dpa.get(str);
                if (num != null) {
                    dpa.put(str, Integer.valueOf(num.intValue() + 1));
                } else {
                    dpa.put(str, 1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void te(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (a.class) {
                Integer num = dpa.get(str);
                if (num != null) {
                    Integer valueOf = Integer.valueOf(num.intValue() - 1);
                    if (valueOf.intValue() > 0) {
                        dpa.put(str, valueOf);
                    } else {
                        dpa.remove(str);
                    }
                }
            }
        }
    }
}
