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
    private static volatile a aCZ;
    private List<com.baidu.swan.apps.network.c.b.b> aDa;
    private long aDb;
    private AtomicInteger aDc;
    private CopyOnWriteArrayList<com.baidu.swan.apps.network.c.a.a> aDd;

    public static a Fd() {
        if (aCZ == null) {
            synchronized (a.class) {
                if (aCZ == null) {
                    aCZ = new a();
                }
            }
        }
        return aCZ;
    }

    private a() {
        init();
    }

    private void init() {
        Fe();
        this.aDb = 0L;
        this.aDc = new AtomicInteger(0);
        this.aDd = new CopyOnWriteArrayList<>();
    }

    private void Fe() {
        this.aDa = new ArrayList();
        this.aDa.add(new com.baidu.swan.apps.network.c.b.a());
    }

    public void Ff() {
        a((com.baidu.swan.apps.network.c.a.a) null);
    }

    public void a(@Nullable com.baidu.swan.apps.network.c.a.a aVar) {
        if (Fi()) {
            b(aVar);
        } else if (aVar != null) {
            aVar.Fh();
        }
    }

    public void update() {
        b(null);
    }

    public void b(@Nullable com.baidu.swan.apps.network.c.a.a aVar) {
        if (aVar != null) {
            this.aDd.add(aVar);
        }
        t(this.aDa);
    }

    public void a(com.baidu.swan.apps.network.c.b.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "resetNodeVersion: " + (bVar == null ? "null" : bVar.getNodeName()));
        }
        if (bVar != null) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "resetNodeVersion: " + bVar.getNodeName());
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bVar);
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            arrayMap.put(bVar.getNodeName(), "");
            c(arrayList, arrayMap);
        }
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "release: ");
        }
        if (aCZ != null) {
            this.aDd.clear();
            aCZ = null;
        }
    }

    private void t(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doUpdate: ");
        }
        if (list.size() == 0) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "update finish: nodes is empty");
            }
            Fh();
        } else if (this.aDc.incrementAndGet() > 1) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "pending request");
            }
        } else {
            ArrayMap<String, String> w = w(this.aDa);
            JSONObject a = a(list, w);
            if (a == null) {
                if (DEBUG) {
                    Log.d("SwanAppUpdateManager", "build params is null ");
                }
                Fh();
                return;
            }
            c.EX().newCall(new Request.Builder().url(com.baidu.swan.apps.u.a.CI().vy()).post(new FormBody.Builder().add("data", a.toString()).build()).build()).enqueue(b(list, w));
        }
    }

    @Nullable
    private JSONObject a(@NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        if (list.size() == 0) {
            return null;
        }
        String Jg = com.baidu.swan.apps.ae.b.Jg();
        if (TextUtils.isEmpty(Jg)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", Jg);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                String str = "";
                if (arrayMap.containsKey(bVar.getNodeName())) {
                    str = arrayMap.get(bVar.getNodeName());
                }
                jSONObject2.put("version", str);
                jSONObject.put(bVar.getNodeName(), jSONObject2);
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
                    Log.d("SwanAppUpdateManager", "ResponseCallback onFailure: ");
                }
                a.this.u(list);
            }

            @Override // okhttp3.Callback
            public void onResponse(@NonNull Call call, @NonNull Response response) {
                if (a.DEBUG) {
                    Log.d("SwanAppUpdateManager", "ResponseCallback onResponse: ");
                }
                if (!response.isSuccessful()) {
                    a.this.u(list);
                    return;
                }
                ResponseBody body = response.body();
                if (body == null) {
                    a.this.u(list);
                    return;
                }
                String str = null;
                try {
                    str = body.string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (TextUtils.isEmpty(str)) {
                    a.this.u(list);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                        a.this.u(list);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null) {
                        a.this.u(list);
                    } else {
                        a.this.a(optJSONObject, list, arrayMap);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    a.this.u(list);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull JSONObject jSONObject, @NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        boolean z;
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doRequestSuccess: ");
        }
        this.aDb = SystemClock.elapsedRealtime();
        boolean z2 = false;
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            JSONObject optJSONObject = jSONObject.optJSONObject(bVar.getNodeName());
            if (optJSONObject == null) {
                bVar.onFail();
            } else if (!TextUtils.equals(optJSONObject.optString("errno"), "0")) {
                bVar.onFail();
            } else {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                if (optJSONObject2 == null) {
                    if (DEBUG) {
                        Log.d("SwanAppUpdateManager", "doRequestSuccess: " + bVar.getNodeName() + " filtered");
                    }
                    bVar.Fj();
                } else {
                    bVar.M(optJSONObject2);
                    String optString = optJSONObject.optString("version", "");
                    if (TextUtils.isEmpty(optString)) {
                        z = z2;
                    } else {
                        if (DEBUG) {
                            Log.d("SwanAppUpdateManager", "doRequestSuccess: " + bVar.getNodeName() + " update " + optString);
                        }
                        arrayMap.put(bVar.getNodeName(), optString);
                        z = true;
                    }
                    z2 = z;
                }
            }
        }
        if (z2) {
            c(list, arrayMap);
        }
        Fg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doRequestFail: ");
        }
        v(list);
        Fg();
    }

    private void Fg() {
        if (this.aDc.decrementAndGet() > 0) {
            this.aDc.set(0);
            update();
            return;
        }
        Fh();
    }

    private void Fh() {
        this.aDc.set(0);
        Iterator<com.baidu.swan.apps.network.c.a.a> it = this.aDd.iterator();
        while (it.hasNext()) {
            final com.baidu.swan.apps.network.c.a.a next = it.next();
            c.g(new Runnable() { // from class: com.baidu.swan.apps.network.c.a.2
                @Override // java.lang.Runnable
                public void run() {
                    next.Fh();
                }
            });
        }
        this.aDd.clear();
    }

    private void v(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            bVar.onFail();
        }
    }

    @NonNull
    private ArrayMap<String, String> w(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        if (list.size() == 0) {
            return arrayMap;
        }
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            arrayMap.put(bVar.getNodeName(), "");
        }
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV == null) {
            return arrayMap;
        }
        String string = IV.IZ().getString("update_nodes_version", "");
        if (TextUtils.isEmpty(string)) {
            return arrayMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            for (com.baidu.swan.apps.network.c.b.b bVar2 : list) {
                arrayMap.put(bVar2.getNodeName(), jSONObject.optString(bVar2.getNodeName(), ""));
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
        com.baidu.swan.apps.ae.b IV;
        JSONObject jSONObject;
        if (list.size() != 0 && (IV = com.baidu.swan.apps.ae.b.IV()) != null) {
            String string = IV.IZ().getString("update_nodes_version", "");
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(string)) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                for (com.baidu.swan.apps.network.c.b.b bVar : list) {
                    String str = arrayMap.get(bVar.getNodeName());
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    try {
                        jSONObject.put(bVar.getNodeName(), str);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                IV.IZ().putString("update_nodes_version", jSONObject.toString());
            }
            jSONObject = jSONObject2;
            while (r4.hasNext()) {
            }
            IV.IZ().putString("update_nodes_version", jSONObject.toString());
        }
    }

    private boolean Fi() {
        return this.aDb <= 0 || SystemClock.elapsedRealtime() - this.aDb > 18000000;
    }
}
