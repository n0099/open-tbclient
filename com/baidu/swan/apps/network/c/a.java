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
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final long drW = TimeUnit.HOURS.toMillis(5);
    private static volatile a drX;
    private List<com.baidu.swan.apps.network.c.b.b> drY;
    private AtomicInteger drZ;
    private CopyOnWriteArrayList<com.baidu.swan.apps.network.c.a.a> dsa;

    public static a aGG() {
        if (drX == null) {
            synchronized (a.class) {
                if (drX == null) {
                    drX = new a();
                }
            }
        }
        return drX;
    }

    private a() {
        init();
    }

    private void init() {
        aGH();
        this.drZ = new AtomicInteger(0);
        this.dsa = new CopyOnWriteArrayList<>();
    }

    private void aGH() {
        this.drY = new ArrayList();
        this.drY.add(new com.baidu.swan.apps.network.c.b.a());
        this.drY.add(new c());
    }

    public void aGI() {
        boolean aHS = com.baidu.swan.apps.performance.b.c.aHS();
        boolean z = d.aMh().aMd().aMx().getBoolean("swan_service_update_degraded", false);
        com.baidu.swan.apps.console.c.i("SwanAppUpdateManager", "tryUpdate, isUpdateAsyncAb = " + aHS + " ; isServiceDegraded = " + z);
        if (!aHS || !z) {
            a((com.baidu.swan.apps.network.c.a.a) null);
        }
    }

    public void a(@Nullable com.baidu.swan.apps.network.c.a.a aVar) {
        if (aGK()) {
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
            aVar.aGJ();
        }
    }

    public void update() {
        b(null);
    }

    public void b(@Nullable com.baidu.swan.apps.network.c.a.a aVar) {
        if (aVar != null) {
            this.dsa.add(aVar);
        }
        aO(this.drY);
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
        if (drX != null) {
            this.dsa.clear();
            drX = null;
        }
    }

    private void aO(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        if (list.size() == 0) {
            if (DEBUG) {
                Log.w("SwanAppUpdateManager", "doUpdate: finish => nodes are empty");
            }
            aGJ();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doUpdate: start => nodes size " + list.size());
        }
        if (this.drZ.incrementAndGet() > 1) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "doUpdate: pending => wait previous request");
                return;
            }
            return;
        }
        ArrayMap<String, String> aR = aR(this.drY);
        JSONObject a2 = a(list, aR);
        if (a2 == null) {
            if (DEBUG) {
                Log.w("SwanAppUpdateManager", "doUpdate: finish => build params is null");
            }
            aGJ();
            return;
        }
        if (DEBUG) {
            Log.w("SwanAppUpdateManager", "doUpdate: start to request update data");
        }
        FormBody build = new FormBody.Builder().add("data", a2.toString()).build();
        String akO = com.baidu.swan.apps.t.a.aAE().akO();
        com.baidu.swan.apps.console.c.bs("SwanAppUpdateManager", "swan update url = " + akO);
        a(akO, build, list, aR);
    }

    private void a(String str, RequestBody requestBody, final List<com.baidu.swan.apps.network.c.b.b> list, final ArrayMap<String, String> arrayMap) {
        com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a(str, requestBody, new ResponseCallback() { // from class: com.baidu.swan.apps.network.c.a.1
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public Object parseResponse(Response response, int i) throws Exception {
                com.baidu.swan.apps.console.c.bs("SwanAppUpdateManager", "response code = " + response.code());
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
                a.this.aP(list);
            }
        });
        aVar.ewn = true;
        aVar.ewo = true;
        aVar.ewp = false;
        com.baidu.swan.a.c.a.bfF().b(aVar);
    }

    @Nullable
    private JSONObject a(@NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        if (list.size() == 0) {
            return null;
        }
        String aMn = e.aMn();
        if (TextUtils.isEmpty(aMn)) {
            return null;
        }
        String aCw = e.aMl().ajv().aCw();
        if (TextUtils.isEmpty(aCw)) {
            aCw = "NA";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aMn);
            jSONObject.put("source", aCw);
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
            aP(list);
            return;
        }
        ResponseBody body = response.body();
        if (body == null) {
            aP(list);
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
        com.baidu.swan.apps.console.c.bs("SwanAppUpdateManager", "response body = " + str);
        if (TextUtils.isEmpty(str)) {
            aP(list);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!TextUtils.equals(jSONObject.optString(BaseJsonData.TAG_ERRNO), "0")) {
                aP(list);
                return;
            }
            String optString = jSONObject.optString("request_id", "");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            com.baidu.swan.apps.console.c.bs("SwanAppUpdateManager", "request_id = " + optString);
            if (optJSONObject == null) {
                aP(list);
            } else {
                a(optJSONObject, list, arrayMap, optString);
            }
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            aP(list);
        }
    }

    private void a(@NonNull JSONObject jSONObject, @NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap, String str) {
        boolean z;
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doRequestSuccess: start");
        }
        aGM();
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
                    bVar.aGO();
                } else {
                    if (DEBUG) {
                        Log.d("SwanAppUpdateManager", "doRequestSuccess: node => " + bVar.getNodeName() + " update");
                    }
                    bVar.r(optJSONObject2, str);
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
        gr(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doRequestFail: ");
        }
        aQ(list);
        gr(false);
    }

    private void gr(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "onRequestFinish: request finish");
        }
        if (this.drZ.decrementAndGet() > 0) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "onRequestFinish: do pending request");
            }
            this.drZ.set(0);
            if (com.baidu.swan.apps.performance.b.c.aHS()) {
                if (!z) {
                    update();
                    return;
                }
                return;
            }
            update();
            return;
        }
        aGJ();
    }

    private void aGJ() {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "onUpdateFinish: real finish update");
        }
        this.drZ.set(0);
        Iterator<com.baidu.swan.apps.network.c.a.a> it = this.dsa.iterator();
        while (it.hasNext()) {
            final com.baidu.swan.apps.network.c.a.a next = it.next();
            com.baidu.swan.apps.setting.oauth.c.g(new Runnable() { // from class: com.baidu.swan.apps.network.c.a.2
                @Override // java.lang.Runnable
                public void run() {
                    next.aGJ();
                }
            });
        }
        this.dsa.clear();
    }

    private void aQ(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            bVar.onFail();
        }
    }

    @NonNull
    private ArrayMap<String, String> aR(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        if (list.size() == 0) {
            return arrayMap;
        }
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            arrayMap.put(bVar.getNodeName(), "");
        }
        e aMl = e.aMl();
        if (aMl == null) {
            return arrayMap;
        }
        String string = aMl.aMx().getString("update_nodes_version", "");
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
        e aMl;
        JSONObject jSONObject;
        if (list.size() != 0 && (aMl = e.aMl()) != null) {
            String string = aMl.aMx().getString("update_nodes_version", "");
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
                aMl.aMx().putString("update_nodes_version", jSONObject.toString());
            }
            jSONObject = jSONObject2;
            while (r4.hasNext()) {
            }
            aMl.aMx().putString("update_nodes_version", jSONObject.toString());
        }
    }

    private boolean aGK() {
        long aGN = aGN();
        return aGN <= 0 || System.currentTimeMillis() - aGN > drW;
    }

    public void aGL() {
        if (d.aMh().aJx()) {
            d.aMh().aMd().aMx().remove(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
        }
        aGI();
    }

    private void aGM() {
        if (d.aMh().aJx()) {
            d.aMh().aMd().aMx().putLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, System.currentTimeMillis());
        }
    }

    public long aGN() {
        return d.aMh().aJx() ? d.aMh().aMd().aMx().getLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L) : System.currentTimeMillis();
    }

    public void a(@NonNull com.baidu.swan.apps.storage.c.b bVar, @NonNull JSONObject jSONObject) {
        JSONObject jSONObject2;
        long currentTimeMillis = System.currentTimeMillis();
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "parse increment accredit node start");
        }
        String string = bVar.getString("node_data_accredit_list", "");
        boolean aHT = com.baidu.swan.apps.performance.b.c.aHT();
        com.baidu.swan.apps.console.c.bs("SwanAppUpdateManager", "cacheData is Empty = " + TextUtils.isEmpty(string) + " ; mergeNodeSwitch = " + aHT);
        if (TextUtils.isEmpty(string)) {
            JSONObject jSONObject3 = new JSONObject();
            v.b(jSONObject3, "list", jSONObject);
            String jSONObject4 = jSONObject3.toString();
            bVar.putString("node_data_accredit_list", jSONObject4);
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "local has no cache data, write directly. pending data = " + jSONObject4);
            }
        } else if (!aHT) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "local has no cache data, mergeNodeSwitch = false");
                return;
            }
            return;
        } else {
            HashMap<String, JSONObject> bx = bx(jSONObject);
            if (bx == null || bx.size() == 0) {
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
                if (!TextUtils.isEmpty(next) && (jSONObject2 = bx.get(next)) != null) {
                    v.b(optJSONObject, next, jSONObject2);
                }
            }
            v.b(parseString, "list", optJSONObject);
            bVar.putString("node_data_accredit_list", parseString.toString());
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "local has cache data, pending size = " + bx.size());
            }
        }
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "parse increment accredit node end, cost = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private HashMap<String, JSONObject> bx(@NonNull JSONObject jSONObject) {
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
