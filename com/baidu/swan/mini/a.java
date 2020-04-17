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
    private static final List<Long> cZf = new CopyOnWriteArrayList();
    private static final Map<String, Integer> cZg = new ConcurrentHashMap();
    private com.baidu.swan.mini.slave.a cZi;
    private final ConcurrentHashMap<String, com.baidu.swan.mini.master.a> cZh = new ConcurrentHashMap<>();
    private boolean cZj = false;
    private SwanCoreVersion cZk = null;
    private boolean cZl = false;
    private com.baidu.swan.mini.d.b cZm = new com.baidu.swan.mini.d.b();

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
            SwanCoreVersion swanCoreVersion = this.cZk;
            for (int i = 0; i < length; i++) {
                com.baidu.swan.mini.b.a bW = com.baidu.swan.mini.b.a.bW(jSONArray.optJSONObject(i));
                if (swanCoreVersion == null) {
                    d(2, "Runtime has been reset while loading master", false);
                    return;
                }
                if (bW.aBx() && bW.bM(swanCoreVersion.swanCoreVersion)) {
                    a(bW);
                } else if (!TextUtils.isEmpty(bW.aBy())) {
                    a(bW.aBy(), 2, "Card info data not valid", false, bW.aBz().getAppId(), bW.aBz().getBundleId());
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

    public void at(@NonNull List<String> list) {
        for (String str : list) {
            a(this.cZh.remove(str));
        }
    }

    private void a(@Nullable com.baidu.swan.mini.master.a aVar) {
        if (aVar != null) {
            if (DEBUG) {
                Log.i("SwanMiniRuntime", "Destroying master: " + aVar.aBw());
            }
            rt(aVar.aBw());
            aVar.finish();
        }
    }

    private void a(@NonNull final com.baidu.swan.mini.b.a aVar) {
        final String aBy = aVar.aBy();
        String appId = aVar.aBz().getAppId();
        String bundleId = aVar.aBz().getBundleId();
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Start load master (async), id = " + aBy + ", appKey = " + appId + "/" + bundleId);
        }
        SwanCoreVersion swanCoreVersion = this.cZk;
        if (swanCoreVersion == null || TextUtils.isEmpty(swanCoreVersion.swanCorePath)) {
            a(aBy, 2, "Can't load Master js", false, appId, bundleId);
            return;
        }
        this.cZm.m(aBy, 101, "NA Load Master");
        com.baidu.swan.mini.master.a aVar2 = new com.baidu.swan.mini.master.a(c.rz(swanCoreVersion.swanCorePath), "master.js", new SwanMiniMasterJsInterface(this, aBy));
        this.cZh.put(aBy, aVar2);
        aVar2.a(new a.b() { // from class: com.baidu.swan.mini.a.1
            @Override // com.baidu.swan.mini.master.a.b
            public void c(com.baidu.swan.games.e.a aVar3) {
                if (a.DEBUG) {
                    Log.i("SwanMiniRuntime", "Master loaded, id = " + aBy);
                }
                a.this.cZm.m(aBy, 102, "NA Master Loaded");
                a.this.rq(aBy);
                a.this.b(aVar);
            }
        });
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Started load master (async), id = " + aBy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull final com.baidu.swan.mini.b.a aVar) {
        final String aBy = aVar.aBy();
        final com.baidu.swan.pms.b.a aBz = aVar.aBz();
        final String appId = aBz.getAppId();
        final String bundleId = aBz.getBundleId();
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Start load miniApp (async), id = " + aBy + ", appKey = " + appId + "/" + bundleId);
        }
        this.cZm.m(aBy, 104, "NA Load App");
        com.baidu.swan.mini.c.a.a(aBz, new c.a() { // from class: com.baidu.swan.mini.a.2
            @Override // com.baidu.swan.mini.e.c.a
            public void onSuccess(final String str) {
                if (a.DEBUG) {
                    Log.i("SwanMiniRuntime", "Load MiniApp success, id = " + aBy + ", appKey = " + appId + "/" + bundleId);
                    Log.v("SwanMiniRuntime", "MiniApp path: " + str);
                }
                a.this.cZm.m(aBy, 105, "NA App Downloaded");
                a.this.rs(str);
                c.a(str, new c.b() { // from class: com.baidu.swan.mini.a.2.1
                    @Override // com.baidu.swan.mini.e.c.b
                    public void ru(@NonNull String str2) {
                        if (TextUtils.isEmpty(str2)) {
                            a.this.rt(str);
                            a.this.a(aBy, 4, "Can't load code info json", true, appId, bundleId);
                            return;
                        }
                        a.this.a(aVar, str, str2);
                        com.baidu.swan.mini.c.b.c(aBz);
                    }
                });
            }

            @Override // com.baidu.swan.mini.e.c.a
            public void onFailed(int i, String str) {
                a.this.a(aBy, 3, "Download error by pms: " + str + "(" + i + ")", true, appId, bundleId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Instance id is null when notifying master ready");
            }
        } else if (this.cZi == null) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Null Slave when notifying master ready, id: " + str);
            }
        } else {
            this.cZi.evaluateJavascript(com.baidu.swan.mini.e.a.rx(str), null);
            if (DEBUG) {
                Log.d("SwanMiniRuntime", "MasterReady notified to slave, id = " + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.baidu.swan.mini.b.a aVar, @Nullable String str, @Nullable String str2) {
        String aBy = aVar.aBy();
        if (this.cZi == null) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Slave is null when notifying app ready");
            }
            rt(str);
            return;
        }
        com.baidu.swan.mini.master.a aVar2 = this.cZh.get(aBy);
        com.baidu.swan.games.e.a v8Engine = aVar2 == null ? null : aVar2.getV8Engine();
        if (v8Engine == null) {
            a(aBy, 4, "Master error", false, aVar.aBz().getAppId(), aVar.aBz().getBundleId());
            rt(str);
        } else if (TextUtils.isEmpty(str)) {
            a(aBy, 4, "App file path empty", true, aVar.aBz().getAppId(), aVar.aBz().getBundleId());
        } else {
            aVar2.rv(str);
            if (TextUtils.isEmpty(str2)) {
                a(aBy, 4, "App info Json Empty", true, aVar.aBz().getAppId(), aVar.aBz().getBundleId());
                return;
            }
            try {
                new JSONObject(str2);
                this.cZm.m(aBy, 106, "NA App Loaded");
                aVar2.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.aF("appjs", str));
                v8Engine.evaluateJavascript(com.baidu.swan.mini.e.a.s(str, str2, this.cZj), null);
                if (DEBUG) {
                    Log.d("SwanMiniRuntime", "AppReady sent to Master, id = " + aBy);
                }
                this.cZi.evaluateJavascript(com.baidu.swan.mini.e.a.a(aVar, str2), null);
                if (DEBUG) {
                    Log.d("SwanMiniRuntime", "AppReady sent to Slave, id = " + aBy);
                }
            } catch (Exception e) {
                a(aBy, 4, "App info json is illegal", true, aVar.aBz().getAppId(), aVar.aBz().getBundleId());
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
        if (this.cZi != null) {
            this.cZi.evaluateJavascript(com.baidu.swan.mini.e.a.a(arrayList, i, str2, z), null);
        }
        this.cZm.d(i, str2, str3, str4);
    }

    public void ck(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.mini.master.a rr = rr(str);
        if (rr != null && rr.getV8Engine() != null) {
            if (DEBUG) {
                Log.v("SwanMiniRuntime", "Message sent to master, id = " + str + ", Message = " + str2);
            }
            d.c(rr.getV8Engine(), str2);
        }
    }

    public void cl(@Nullable String str, @Nullable String str2) {
        if (this.cZi != null) {
            if (DEBUG) {
                Log.v("SwanMiniRuntime", "Message sent to slave, id = " + str + ", Message = " + str2);
            }
            d.a(this.cZi, str, str2);
        }
    }

    @Nullable
    public com.baidu.swan.mini.master.a rr(@Nullable String str) {
        return this.cZh.get(str);
    }

    public void b(boolean z, @Nullable String str, @NonNull String str2) {
        if (DEBUG) {
            Log.d("SwanMiniRuntime", (z ? "【MiniMasterLog】" : "【MiniSlaveLog】") + "【" + str + "】" + str2 + "(" + System.currentTimeMillis() + ")");
        }
    }

    @NonNull
    public static List<Long> aBr() {
        return cZf;
    }

    public static Set<String> aBs() {
        return cZg.keySet();
    }

    public boolean aBt() {
        return this.cZl;
    }

    @NonNull
    public com.baidu.swan.mini.d.b aBu() {
        return this.cZm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rs(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (a.class) {
                Integer num = cZg.get(str);
                if (num != null) {
                    cZg.put(str, Integer.valueOf(num.intValue() + 1));
                } else {
                    cZg.put(str, 1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rt(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (a.class) {
                Integer num = cZg.get(str);
                if (num != null) {
                    Integer valueOf = Integer.valueOf(num.intValue() - 1);
                    if (valueOf.intValue() > 0) {
                        cZg.put(str, valueOf);
                    } else {
                        cZg.remove(str);
                    }
                }
            }
        }
    }
}
