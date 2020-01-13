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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final List<Long> cvW = new CopyOnWriteArrayList();
    private static final Map<String, Integer> cvX = new ConcurrentHashMap();
    private com.baidu.swan.mini.slave.a cvZ;
    private final ConcurrentHashMap<String, com.baidu.swan.mini.master.a> cvY = new ConcurrentHashMap<>();
    private boolean cwa = false;
    private SwanCoreVersion cwb = null;
    private boolean cwc = false;
    private com.baidu.swan.mini.d.b cwd = new com.baidu.swan.mini.d.b();

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
            SwanCoreVersion swanCoreVersion = this.cwb;
            for (int i = 0; i < length; i++) {
                com.baidu.swan.mini.b.a bL = com.baidu.swan.mini.b.a.bL(jSONArray.optJSONObject(i));
                if (swanCoreVersion == null) {
                    d(2, "Runtime has been reset while loading master", false);
                    return;
                }
                if (bL.aqU() && bL.bd(swanCoreVersion.swanCoreVersion)) {
                    a(bL);
                } else if (!TextUtils.isEmpty(bL.aqV())) {
                    a(bL.aqV(), 2, "Card info data not valid", false, bL.aqW().getAppId(), bL.aqW().getBundleId());
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
            a(this.cvY.remove(str));
        }
    }

    private void a(@Nullable com.baidu.swan.mini.master.a aVar) {
        if (aVar != null) {
            if (DEBUG) {
                Log.i("SwanMiniRuntime", "Destroying master: " + aVar.aqT());
            }
            pS(aVar.aqT());
            aVar.finish();
        }
    }

    private void a(@NonNull final com.baidu.swan.mini.b.a aVar) {
        final String aqV = aVar.aqV();
        String appId = aVar.aqW().getAppId();
        String bundleId = aVar.aqW().getBundleId();
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Start load master (async), id = " + aqV + ", appKey = " + appId + "/" + bundleId);
        }
        SwanCoreVersion swanCoreVersion = this.cwb;
        if (swanCoreVersion == null || TextUtils.isEmpty(swanCoreVersion.swanCorePath)) {
            a(aqV, 2, "Can't load Master js", false, appId, bundleId);
            return;
        }
        this.cwd.l(aqV, 101, "NA Load Master");
        com.baidu.swan.mini.master.a aVar2 = new com.baidu.swan.mini.master.a(c.pY(swanCoreVersion.swanCorePath), "master.js", new SwanMiniMasterJsInterface(this, aqV));
        this.cvY.put(aqV, aVar2);
        aVar2.a(new a.b() { // from class: com.baidu.swan.mini.a.1
            @Override // com.baidu.swan.mini.master.a.b
            public void c(com.baidu.swan.games.e.a aVar3) {
                if (a.DEBUG) {
                    Log.i("SwanMiniRuntime", "Master loaded, id = " + aqV);
                }
                a.this.cwd.l(aqV, 102, "NA Master Loaded");
                a.this.pP(aqV);
                a.this.b(aVar);
            }
        });
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Started load master (async), id = " + aqV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull final com.baidu.swan.mini.b.a aVar) {
        final String aqV = aVar.aqV();
        final com.baidu.swan.pms.b.a aqW = aVar.aqW();
        final String appId = aqW.getAppId();
        final String bundleId = aqW.getBundleId();
        if (DEBUG) {
            Log.i("SwanMiniRuntime", "Start load miniApp (async), id = " + aqV + ", appKey = " + appId + "/" + bundleId);
        }
        this.cwd.l(aqV, 104, "NA Load App");
        com.baidu.swan.mini.c.a.a(aqW, new c.a() { // from class: com.baidu.swan.mini.a.2
            @Override // com.baidu.swan.mini.e.c.a
            public void onSuccess(final String str) {
                if (a.DEBUG) {
                    Log.i("SwanMiniRuntime", "Load MiniApp success, id = " + aqV + ", appKey = " + appId + "/" + bundleId);
                    Log.v("SwanMiniRuntime", "MiniApp path: " + str);
                }
                a.this.cwd.l(aqV, 105, "NA App Downloaded");
                a.this.pR(str);
                c.a(str, new c.b() { // from class: com.baidu.swan.mini.a.2.1
                    @Override // com.baidu.swan.mini.e.c.b
                    public void pT(@NonNull String str2) {
                        if (TextUtils.isEmpty(str2)) {
                            a.this.pS(str);
                            a.this.a(aqV, 4, "Can't load code info json", true, appId, bundleId);
                            return;
                        }
                        a.this.a(aVar, str, str2);
                        com.baidu.swan.mini.c.b.c(aqW);
                    }
                });
            }

            @Override // com.baidu.swan.mini.e.c.a
            public void onFailed(int i, String str) {
                a.this.a(aqV, 3, "Download error by pms: " + str + "(" + i + ")", true, appId, bundleId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pP(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Instance id is null when notifying master ready");
            }
        } else if (this.cvZ == null) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Null Slave when notifying master ready, id: " + str);
            }
        } else {
            this.cvZ.evaluateJavascript(com.baidu.swan.mini.e.a.pW(str), null);
            if (DEBUG) {
                Log.d("SwanMiniRuntime", "MasterReady notified to slave, id = " + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.baidu.swan.mini.b.a aVar, @Nullable String str, @Nullable String str2) {
        String aqV = aVar.aqV();
        if (this.cvZ == null) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Slave is null when notifying app ready");
            }
            pS(str);
            return;
        }
        com.baidu.swan.mini.master.a aVar2 = this.cvY.get(aqV);
        com.baidu.swan.games.e.a v8Engine = aVar2 == null ? null : aVar2.getV8Engine();
        if (v8Engine == null) {
            a(aqV, 4, "Master error", false, aVar.aqW().getAppId(), aVar.aqW().getBundleId());
            pS(str);
        } else if (TextUtils.isEmpty(str)) {
            a(aqV, 4, "App file path empty", true, aVar.aqW().getAppId(), aVar.aqW().getBundleId());
        } else {
            aVar2.pU(str);
            if (TextUtils.isEmpty(str2)) {
                a(aqV, 4, "App info Json Empty", true, aVar.aqW().getAppId(), aVar.aqW().getBundleId());
                return;
            }
            try {
                new JSONObject(str2);
                this.cwd.l(aqV, 106, "NA App Loaded");
                aVar2.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.an("appjs", str));
                v8Engine.evaluateJavascript(com.baidu.swan.mini.e.a.s(str, str2, this.cwa), null);
                if (DEBUG) {
                    Log.d("SwanMiniRuntime", "AppReady sent to Master, id = " + aqV);
                }
                this.cvZ.evaluateJavascript(com.baidu.swan.mini.e.a.a(aVar, str2), null);
                if (DEBUG) {
                    Log.d("SwanMiniRuntime", "AppReady sent to Slave, id = " + aqV);
                }
            } catch (Exception e) {
                a(aqV, 4, "App info json is illegal", true, aVar.aqW().getAppId(), aVar.aqW().getBundleId());
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
        if (this.cvZ != null) {
            this.cvZ.evaluateJavascript(com.baidu.swan.mini.e.a.a(arrayList, i, str2, z), null);
        }
        this.cwd.d(i, str2, str3, str4);
    }

    public void bR(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.mini.master.a pQ = pQ(str);
        if (pQ != null && pQ.getV8Engine() != null) {
            if (DEBUG) {
                Log.v("SwanMiniRuntime", "Message sent to master, id = " + str + ", Message = " + str2);
            }
            d.c(pQ.getV8Engine(), str2);
        }
    }

    public void bS(@Nullable String str, @Nullable String str2) {
        if (this.cvZ != null) {
            if (DEBUG) {
                Log.v("SwanMiniRuntime", "Message sent to slave, id = " + str + ", Message = " + str2);
            }
            d.a(this.cvZ, str, str2);
        }
    }

    @Nullable
    public com.baidu.swan.mini.master.a pQ(@Nullable String str) {
        return this.cvY.get(str);
    }

    public void b(boolean z, @Nullable String str, @NonNull String str2) {
        if (DEBUG) {
            Log.d("SwanMiniRuntime", (z ? "【MiniMasterLog】" : "【MiniSlaveLog】") + "【" + str + "】" + str2 + "(" + System.currentTimeMillis() + ")");
        }
    }

    @NonNull
    public static List<Long> aqO() {
        return cvW;
    }

    public static Set<String> aqP() {
        return cvX.keySet();
    }

    public boolean aqQ() {
        return this.cwc;
    }

    @NonNull
    public com.baidu.swan.mini.d.b aqR() {
        return this.cwd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pR(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (a.class) {
                Integer num = cvX.get(str);
                if (num != null) {
                    cvX.put(str, Integer.valueOf(num.intValue() + 1));
                } else {
                    cvX.put(str, 1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pS(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (a.class) {
                Integer num = cvX.get(str);
                if (num != null) {
                    Integer valueOf = Integer.valueOf(num.intValue() - 1);
                    if (valueOf.intValue() > 0) {
                        cvX.put(str, valueOf);
                    } else {
                        cvX.remove(str);
                    }
                }
            }
        }
    }
}
