package com.baidu.swan.apps.network.c;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.ao.v;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.network.c.b.c;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final long dqU = TimeUnit.HOURS.toMillis(5);
    private static volatile a dqV;
    private List<com.baidu.swan.apps.network.c.b.b> dqW;
    private AtomicInteger dqX;
    private CopyOnWriteArrayList<com.baidu.swan.apps.network.c.a.a> dqY;

    public static a aDl() {
        if (dqV == null) {
            synchronized (a.class) {
                if (dqV == null) {
                    dqV = new a();
                }
            }
        }
        return dqV;
    }

    private a() {
        init();
    }

    private void init() {
        aDm();
        this.dqX = new AtomicInteger(0);
        this.dqY = new CopyOnWriteArrayList<>();
    }

    private void aDm() {
        this.dqW = new ArrayList();
        this.dqW.add(new com.baidu.swan.apps.network.c.b.a());
        this.dqW.add(new c());
    }

    public void aDn() {
        boolean aEw = com.baidu.swan.apps.performance.b.c.aEw();
        boolean z = d.aIJ().aIF().aIZ().getBoolean("swan_service_update_degraded", false);
        com.baidu.swan.apps.console.c.i("SwanAppUpdateManager", "tryUpdate, isUpdateAsyncAb = " + aEw + " ; isServiceDegraded = " + z);
        if (!aEw || !z) {
            a((com.baidu.swan.apps.network.c.a.a) null);
        }
    }

    public void a(@Nullable com.baidu.swan.apps.network.c.a.a aVar) {
        if (aDp()) {
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
            aVar.aDo();
        }
    }

    public void update() {
        b(null);
    }

    public void b(@Nullable com.baidu.swan.apps.network.c.a.a aVar) {
        if (aVar != null) {
            this.dqY.add(aVar);
        }
        aJ(this.dqW);
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
            Log.d("SwanAppUpdateManager", "resetNodeVersion: " + bVar.getNodeName());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        arrayMap.put(bVar.getNodeName(), "");
        b(arrayList, arrayMap);
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "release: ");
        }
        if (dqV != null) {
            this.dqY.clear();
            dqV = null;
        }
    }

    private void aJ(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        if (list.size() == 0) {
            if (DEBUG) {
                Log.w("SwanAppUpdateManager", "doUpdate: finish => nodes are empty");
            }
            aDo();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doUpdate: start => nodes size " + list.size());
        }
        if (this.dqX.incrementAndGet() > 1) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "doUpdate: pending => wait previous request");
                return;
            }
            return;
        }
        ArrayMap<String, String> aM = aM(this.dqW);
        JSONObject a2 = a(list, aM);
        if (a2 == null) {
            if (DEBUG) {
                Log.w("SwanAppUpdateManager", "doUpdate: finish => build params is null");
            }
            aDo();
            return;
        }
        if (DEBUG) {
            Log.w("SwanAppUpdateManager", "doUpdate: start to request update data");
        }
        FormBody build = new FormBody.Builder().add("data", a2.toString()).build();
        String ahv = com.baidu.swan.apps.t.a.axl().ahv();
        com.baidu.swan.apps.console.c.bl("SwanAppUpdateManager", "swan update url = " + ahv);
        a(ahv, build, list, aM);
    }

    private void a(String str, RequestBody requestBody, final List<com.baidu.swan.apps.network.c.b.b> list, final ArrayMap<String, String> arrayMap) {
        com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a(str, requestBody, new ResponseCallback() { // from class: com.baidu.swan.apps.network.c.a.1
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public Object parseResponse(Response response, int i) throws Exception {
                com.baidu.swan.apps.console.c.bl("SwanAppUpdateManager", "response code = " + response.code());
                a.this.a(response, list, arrayMap);
                return response;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(Object obj, int i) {
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (a.DEBUG) {
                    Log.e("SwanAppUpdateManager", "onFailure: update request failure ", exc);
                }
                a.this.aK(list);
            }
        });
        aVar.evi = true;
        aVar.evj = true;
        aVar.evk = false;
        com.baidu.swan.a.c.a.bca().b(aVar);
    }

    @Nullable
    private JSONObject a(@NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        if (list.size() == 0) {
            return null;
        }
        String aIP = e.aIP();
        if (TextUtils.isEmpty(aIP)) {
            return null;
        }
        String azd = e.aIN().agc().azd();
        if (TextUtils.isEmpty(azd)) {
            azd = "NA";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aIP);
            jSONObject.put("source", azd);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                String str = "";
                if (arrayMap.containsKey(bVar.getNodeName())) {
                    str = arrayMap.get(bVar.getNodeName());
                }
                if (DEBUG) {
                    Log.d("SwanAppUpdateManager", "buildRequestParams: node => " + bVar.getNodeName() + " , version => " + str);
                }
                jSONObject2.put("version", str);
                jSONObject.put(bVar.getNodeName(), jSONObject2);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Response response, @NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "onResponse: update request return");
        }
        if (!response.isSuccessful()) {
            aK(list);
            return;
        }
        ResponseBody body = response.body();
        if (body == null) {
            aK(list);
            return;
        }
        String str = null;
        try {
            str = body.string();
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.console.c.bl("SwanAppUpdateManager", "response body = " + str);
        if (TextUtils.isEmpty(str)) {
            aK(list);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!TextUtils.equals(jSONObject.optString(BaseJsonData.TAG_ERRNO), "0")) {
                aK(list);
                return;
            }
            String optString = jSONObject.optString("request_id", "");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            com.baidu.swan.apps.console.c.bl("SwanAppUpdateManager", "request_id = " + optString);
            if (optJSONObject == null) {
                aK(list);
            } else {
                a(optJSONObject, list, arrayMap, optString);
            }
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            aK(list);
        }
    }

    private void a(@NonNull JSONObject jSONObject, @NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap, String str) {
        boolean z;
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doRequestSuccess: start");
        }
        aDr();
        boolean z2 = false;
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            JSONObject optJSONObject = jSONObject.optJSONObject(bVar.getNodeName());
            if (optJSONObject == null) {
                bVar.onFail();
            } else if (!TextUtils.equals(optJSONObject.optString(BaseJsonData.TAG_ERRNO), "0")) {
                bVar.onFail();
            } else {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                if (optJSONObject2 == null) {
                    bVar.aDt();
                } else {
                    if (DEBUG) {
                        Log.d("SwanAppUpdateManager", "doRequestSuccess: node => " + bVar.getNodeName() + " update");
                    }
                    bVar.q(optJSONObject2, str);
                    String optString = optJSONObject.optString("version", "");
                    if (TextUtils.isEmpty(optString)) {
                        z = z2;
                    } else {
                        if (DEBUG) {
                            Log.d("SwanAppUpdateManager", "doRequestSuccess: " + bVar.getNodeName() + " update , version " + optString);
                        }
                        arrayMap.put(bVar.getNodeName(), optString);
                        z = true;
                    }
                    z2 = z;
                }
            }
        }
        if (z2) {
            b(list, arrayMap);
        }
        gp(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doRequestFail: ");
        }
        aL(list);
        gp(false);
    }

    private void gp(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "onRequestFinish: request finish");
        }
        if (this.dqX.decrementAndGet() > 0) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "onRequestFinish: do pending request");
            }
            this.dqX.set(0);
            if (com.baidu.swan.apps.performance.b.c.aEw()) {
                if (!z) {
                    update();
                    return;
                }
                return;
            }
            update();
            return;
        }
        aDo();
    }

    private void aDo() {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "onUpdateFinish: real finish update");
        }
        this.dqX.set(0);
        Iterator<com.baidu.swan.apps.network.c.a.a> it = this.dqY.iterator();
        while (it.hasNext()) {
            final com.baidu.swan.apps.network.c.a.a next = it.next();
            com.baidu.swan.apps.setting.oauth.c.e(new Runnable() { // from class: com.baidu.swan.apps.network.c.a.2
                @Override // java.lang.Runnable
                public void run() {
                    next.aDo();
                }
            });
        }
        this.dqY.clear();
    }

    private void aL(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            bVar.onFail();
        }
    }

    @NonNull
    private ArrayMap<String, String> aM(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        if (list.size() == 0) {
            return arrayMap;
        }
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            arrayMap.put(bVar.getNodeName(), "");
        }
        e aIN = e.aIN();
        if (aIN == null) {
            return arrayMap;
        }
        String string = aIN.aIZ().getString("update_nodes_version", "");
        if (TextUtils.isEmpty(string)) {
            return arrayMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            for (com.baidu.swan.apps.network.c.b.b bVar2 : list) {
                arrayMap.put(bVar2.getNodeName(), jSONObject.optString(bVar2.getNodeName(), ""));
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return arrayMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(@NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        e aIN;
        JSONObject jSONObject;
        if (list.size() != 0 && (aIN = e.aIN()) != null) {
            String string = aIN.aIZ().getString("update_nodes_version", "");
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(string)) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                for (com.baidu.swan.apps.network.c.b.b bVar : list) {
                    String str = arrayMap.get(bVar.getNodeName());
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    try {
                        if (DEBUG) {
                            Log.d("SwanAppUpdateManager", "updateNodeVersions: update node => " + bVar.getNodeName() + " , version => " + str);
                        }
                        jSONObject.put(bVar.getNodeName(), str);
                    } catch (JSONException e2) {
                        if (DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                }
                aIN.aIZ().putString("update_nodes_version", jSONObject.toString());
            }
            jSONObject = jSONObject2;
            while (r4.hasNext()) {
            }
            aIN.aIZ().putString("update_nodes_version", jSONObject.toString());
        }
    }

    private boolean aDp() {
        long aDs = aDs();
        return aDs <= 0 || System.currentTimeMillis() - aDs > dqU;
    }

    public void aDq() {
        if (d.aIJ().aGb()) {
            d.aIJ().aIF().aIZ().remove(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
        }
        aDn();
    }

    private void aDr() {
        if (d.aIJ().aGb()) {
            d.aIJ().aIF().aIZ().putLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, System.currentTimeMillis());
        }
    }

    public long aDs() {
        return d.aIJ().aGb() ? d.aIJ().aIF().aIZ().getLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L) : System.currentTimeMillis();
    }

    public void a(@NonNull com.baidu.swan.apps.storage.c.b bVar, @NonNull JSONObject jSONObject) {
        JSONObject jSONObject2;
        long currentTimeMillis = System.currentTimeMillis();
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "parse increment accredit node start");
        }
        String string = bVar.getString("node_data_accredit_list", "");
        boolean aEx = com.baidu.swan.apps.performance.b.c.aEx();
        com.baidu.swan.apps.console.c.bl("SwanAppUpdateManager", "cacheData is Empty = " + TextUtils.isEmpty(string) + " ; mergeNodeSwitch = " + aEx);
        if (TextUtils.isEmpty(string)) {
            JSONObject jSONObject3 = new JSONObject();
            v.b(jSONObject3, "list", jSONObject);
            String jSONObject4 = jSONObject3.toString();
            bVar.putString("node_data_accredit_list", jSONObject4);
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "local has no cache data, write directly. pending data = " + jSONObject4);
            }
        } else if (!aEx) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "local has no cache data, mergeNodeSwitch = false");
                return;
            }
            return;
        } else {
            HashMap<String, JSONObject> bw = bw(jSONObject);
            if (bw == null || bw.size() == 0) {
                if (DEBUG) {
                    Log.e("SwanAppUpdateManager", "local has cache data, but pending data is empty");
                    return;
                }
                return;
            }
            JSONObject parseString = v.parseString(string);
            JSONObject optJSONObject = parseString.optJSONObject("list");
            if (optJSONObject == null) {
                v.b(parseString, "list", jSONObject);
                bVar.putString("node_data_accredit_list", parseString.toString());
                if (DEBUG) {
                    Log.e("SwanAppUpdateManager", "local has cache data, but list node is empty");
                    return;
                }
                return;
            }
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (jSONObject2 = bw.get(next)) != null) {
                    v.b(optJSONObject, next, jSONObject2);
                }
            }
            v.b(parseString, "list", optJSONObject);
            bVar.putString("node_data_accredit_list", parseString.toString());
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "local has cache data, pending size = " + bw.size());
            }
        }
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "parse increment accredit node end, cost = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private HashMap<String, JSONObject> bw(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        HashMap<String, JSONObject> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next) && (optJSONObject = jSONObject.optJSONObject(next)) != null) {
                hashMap.put(next, optJSONObject);
            }
        }
        return hashMap;
    }
}
