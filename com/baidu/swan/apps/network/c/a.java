package com.baidu.swan.apps.network.c;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.setting.oauth.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a aYO;
    private List<com.baidu.swan.apps.network.c.b.b> aYP;
    private long aYQ;
    private AtomicInteger aYR;
    private CopyOnWriteArrayList<com.baidu.swan.apps.network.c.a.a> aYS;

    public static a MS() {
        if (aYO == null) {
            synchronized (a.class) {
                if (aYO == null) {
                    aYO = new a();
                }
            }
        }
        return aYO;
    }

    private a() {
        init();
    }

    private void init() {
        MT();
        this.aYQ = 0L;
        this.aYR = new AtomicInteger(0);
        this.aYS = new CopyOnWriteArrayList<>();
    }

    private void MT() {
        this.aYP = new ArrayList();
        this.aYP.add(new com.baidu.swan.apps.network.c.b.a());
    }

    public void MU() {
        a((com.baidu.swan.apps.network.c.a.a) null);
    }

    public void a(@Nullable com.baidu.swan.apps.network.c.a.a aVar) {
        if (MX()) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "tryUpdate: start => cache data invalid");
            }
            b(aVar);
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "tryUpdate: finish => cache data valid");
        }
        if (aVar != null) {
            aVar.MW();
        }
    }

    public void update() {
        b(null);
    }

    public void b(@Nullable com.baidu.swan.apps.network.c.a.a aVar) {
        if (aVar != null) {
            this.aYS.add(aVar);
        }
        T(this.aYP);
    }

    public void a(com.baidu.swan.apps.network.c.b.b bVar) {
        if (bVar == null) {
            if (DEBUG) {
                Log.w("SwanAppUpdateManager", "resetNodeVersion: node is null");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "resetNodeVersion: " + bVar.MY());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        arrayMap.put(bVar.MY(), "");
        c(arrayList, arrayMap);
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "release: ");
        }
        if (aYO != null) {
            this.aYS.clear();
            aYO = null;
        }
    }

    private void T(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        if (list.size() == 0) {
            if (DEBUG) {
                Log.w("SwanAppUpdateManager", "doUpdate: finish => nodes are empty");
            }
            MW();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doUpdate: start => nodes size " + list.size());
        }
        if (this.aYR.incrementAndGet() > 1) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "doUpdate: pending => wait previous request");
                return;
            }
            return;
        }
        ArrayMap<String, String> W = W(this.aYP);
        JSONObject a = a(list, W);
        if (a == null) {
            if (DEBUG) {
                Log.w("SwanAppUpdateManager", "doUpdate: finish => build params is null");
            }
            MW();
            return;
        }
        c.MM().newCall(new Request.Builder().url(com.baidu.swan.apps.u.a.Jv().BN()).post(new FormBody.Builder().add("data", a.toString()).build()).build()).enqueue(b(list, W));
    }

    @Nullable
    private JSONObject a(@NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        if (list.size() == 0) {
            return null;
        }
        String Rm = com.baidu.swan.apps.ae.b.Rm();
        if (TextUtils.isEmpty(Rm)) {
            return null;
        }
        String KF = com.baidu.swan.apps.ae.b.Ra().AK().KF();
        if (TextUtils.isEmpty(KF)) {
            KF = "NA";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", Rm);
            jSONObject.put("source", KF);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                String str = "";
                if (arrayMap.containsKey(bVar.MY())) {
                    str = arrayMap.get(bVar.MY());
                }
                if (DEBUG) {
                    Log.d("SwanAppUpdateManager", "buildRequestParams: node => " + bVar.MY() + " , version => " + str);
                }
                jSONObject2.put("version", str);
                jSONObject.put(bVar.MY(), jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    @NonNull
    private Callback b(@NonNull final List<com.baidu.swan.apps.network.c.b.b> list, @NonNull final ArrayMap<String, String> arrayMap) {
        return new Callback() { // from class: com.baidu.swan.apps.network.c.a.1
            @Override // okhttp3.Callback
            public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
                if (a.DEBUG) {
                    Log.e("SwanAppUpdateManager", "onFailure: update request failure ", iOException);
                }
                a.this.U(list);
            }

            @Override // okhttp3.Callback
            public void onResponse(@NonNull Call call, @NonNull Response response) {
                if (a.DEBUG) {
                    Log.d("SwanAppUpdateManager", "onResponse: update request return");
                }
                if (!response.isSuccessful()) {
                    a.this.U(list);
                    return;
                }
                ResponseBody body = response.body();
                if (body == null) {
                    a.this.U(list);
                    return;
                }
                String str = null;
                try {
                    str = body.string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (TextUtils.isEmpty(str)) {
                    a.this.U(list);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                        a.this.U(list);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null) {
                        a.this.U(list);
                    } else {
                        a.this.a(optJSONObject, list, arrayMap);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    a.this.U(list);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull JSONObject jSONObject, @NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        boolean z;
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doRequestSuccess: start");
        }
        this.aYQ = SystemClock.elapsedRealtime();
        boolean z2 = false;
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            JSONObject optJSONObject = jSONObject.optJSONObject(bVar.MY());
            if (optJSONObject == null) {
                bVar.onFail();
            } else if (!TextUtils.equals(optJSONObject.optString("errno"), "0")) {
                bVar.onFail();
            } else {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                if (optJSONObject2 == null) {
                    bVar.MZ();
                } else {
                    if (DEBUG) {
                        Log.d("SwanAppUpdateManager", "doRequestSuccess: node => " + bVar.MY() + " update");
                    }
                    bVar.ak(optJSONObject2);
                    String optString = optJSONObject.optString("version", "");
                    if (TextUtils.isEmpty(optString)) {
                        z = z2;
                    } else {
                        if (DEBUG) {
                            Log.d("SwanAppUpdateManager", "doRequestSuccess: " + bVar.MY() + " update , version " + optString);
                        }
                        arrayMap.put(bVar.MY(), optString);
                        z = true;
                    }
                    z2 = z;
                }
            }
        }
        if (z2) {
            c(list, arrayMap);
        }
        MV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doRequestFail: ");
        }
        V(list);
        MV();
    }

    private void MV() {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "onRequestFinish: request finish");
        }
        if (this.aYR.decrementAndGet() > 0) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "onRequestFinish: do pending request");
            }
            this.aYR.set(0);
            update();
            return;
        }
        MW();
    }

    private void MW() {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "onUpdateFinish: real finish update");
        }
        this.aYR.set(0);
        Iterator<com.baidu.swan.apps.network.c.a.a> it = this.aYS.iterator();
        while (it.hasNext()) {
            final com.baidu.swan.apps.network.c.a.a next = it.next();
            c.e(new Runnable() { // from class: com.baidu.swan.apps.network.c.a.2
                @Override // java.lang.Runnable
                public void run() {
                    next.MW();
                }
            });
        }
        this.aYS.clear();
    }

    private void V(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            bVar.onFail();
        }
    }

    @NonNull
    private ArrayMap<String, String> W(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        if (list.size() == 0) {
            return arrayMap;
        }
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            arrayMap.put(bVar.MY(), "");
        }
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra == null) {
            return arrayMap;
        }
        String string = Ra.Rf().getString("update_nodes_version", "");
        if (TextUtils.isEmpty(string)) {
            return arrayMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            for (com.baidu.swan.apps.network.c.b.b bVar2 : list) {
                arrayMap.put(bVar2.MY(), jSONObject.optString(bVar2.MY(), ""));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(@NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        com.baidu.swan.apps.ae.b Ra;
        JSONObject jSONObject;
        if (list.size() != 0 && (Ra = com.baidu.swan.apps.ae.b.Ra()) != null) {
            String string = Ra.Rf().getString("update_nodes_version", "");
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(string)) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                for (com.baidu.swan.apps.network.c.b.b bVar : list) {
                    String str = arrayMap.get(bVar.MY());
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    try {
                        if (DEBUG) {
                            Log.d("SwanAppUpdateManager", "updateNodeVersions: update node => " + bVar.MY() + " , version => " + str);
                        }
                        jSONObject.put(bVar.MY(), str);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                Ra.Rf().putString("update_nodes_version", jSONObject.toString());
            }
            jSONObject = jSONObject2;
            while (r4.hasNext()) {
            }
            Ra.Rf().putString("update_nodes_version", jSONObject.toString());
        }
    }

    private boolean MX() {
        return this.aYQ <= 0 || SystemClock.elapsedRealtime() - this.aYQ > 18000000;
    }
}
