package com.baidu.swan.apps.network.c;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.ap.v;
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
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final long cTl = TimeUnit.HOURS.toMillis(5);
    private static volatile a cTm;
    private List<com.baidu.swan.apps.network.c.b.b> cTn;
    private AtomicInteger cTo;
    private CopyOnWriteArrayList<com.baidu.swan.apps.network.c.a.a> cTp;

    public static a ayq() {
        if (cTm == null) {
            synchronized (a.class) {
                if (cTm == null) {
                    cTm = new a();
                }
            }
        }
        return cTm;
    }

    private a() {
        init();
    }

    private void init() {
        ayr();
        this.cTo = new AtomicInteger(0);
        this.cTp = new CopyOnWriteArrayList<>();
    }

    private void ayr() {
        this.cTn = new ArrayList();
        this.cTn.add(new com.baidu.swan.apps.network.c.b.a());
        this.cTn.add(new c());
    }

    public void ays() {
        boolean azE = com.baidu.swan.apps.performance.b.c.azE();
        boolean z = d.aCW().aCS().aDm().getBoolean("swan_service_update_degraded", false);
        com.baidu.swan.apps.console.c.i("SwanAppUpdateManager", "tryUpdate, isUpdateAsyncAb = " + azE + " ; isServiceDegraded = " + z);
        if (!azE || !z) {
            a((com.baidu.swan.apps.network.c.a.a) null);
        }
    }

    public void a(@Nullable com.baidu.swan.apps.network.c.a.a aVar) {
        if (ayu()) {
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
            aVar.ayt();
        }
    }

    public void update() {
        b(null);
    }

    public void b(@Nullable com.baidu.swan.apps.network.c.a.a aVar) {
        if (aVar != null) {
            this.cTp.add(aVar);
        }
        ar(this.cTn);
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
        if (cTm != null) {
            this.cTp.clear();
            cTm = null;
        }
    }

    private void ar(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        if (list.size() == 0) {
            if (DEBUG) {
                Log.w("SwanAppUpdateManager", "doUpdate: finish => nodes are empty");
            }
            ayt();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doUpdate: start => nodes size " + list.size());
        }
        if (this.cTo.incrementAndGet() > 1) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "doUpdate: pending => wait previous request");
                return;
            }
            return;
        }
        ArrayMap<String, String> au = au(this.cTn);
        JSONObject a2 = a(list, au);
        if (a2 == null) {
            if (DEBUG) {
                Log.w("SwanAppUpdateManager", "doUpdate: finish => build params is null");
            }
            ayt();
            return;
        }
        if (DEBUG) {
            Log.w("SwanAppUpdateManager", "doUpdate: start to request update data");
        }
        FormBody build = new FormBody.Builder().add("data", a2.toString()).build();
        String acL = com.baidu.swan.apps.t.a.ass().acL();
        com.baidu.swan.apps.console.c.bg("SwanAppUpdateManager", "swan update url = " + acL);
        a(acL, build, list, au);
    }

    private void a(String str, RequestBody requestBody, final List<com.baidu.swan.apps.network.c.b.b> list, final ArrayMap<String, String> arrayMap) {
        com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a(str, requestBody, new ResponseCallback() { // from class: com.baidu.swan.apps.network.c.a.1
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public Object parseResponse(Response response, int i) throws Exception {
                com.baidu.swan.apps.console.c.bg("SwanAppUpdateManager", "response code = " + response.code());
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
                a.this.as(list);
            }
        });
        aVar.dSX = true;
        aVar.dSY = true;
        aVar.dSZ = false;
        com.baidu.swan.a.c.a.aWr().b(aVar);
    }

    @Nullable
    private JSONObject a(@NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        if (list.size() == 0) {
            return null;
        }
        String aDc = e.aDc();
        if (TextUtils.isEmpty(aDc)) {
            return null;
        }
        String auj = e.aDa().abu().auj();
        if (TextUtils.isEmpty(auj)) {
            auj = "NA";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aDc);
            jSONObject.put("source", auj);
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
            as(list);
            return;
        }
        ResponseBody body = response.body();
        if (body == null) {
            as(list);
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
        com.baidu.swan.apps.console.c.bg("SwanAppUpdateManager", "response body = " + str);
        if (TextUtils.isEmpty(str)) {
            as(list);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!TextUtils.equals(jSONObject.optString(BaseJsonData.TAG_ERRNO), "0")) {
                as(list);
                return;
            }
            String optString = jSONObject.optString("request_id", "");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            com.baidu.swan.apps.console.c.bg("SwanAppUpdateManager", "request_id = " + optString);
            if (optJSONObject == null) {
                as(list);
            } else {
                a(optJSONObject, list, arrayMap, optString);
            }
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            as(list);
        }
    }

    private void a(@NonNull JSONObject jSONObject, @NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap, String str) {
        boolean z;
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doRequestSuccess: start");
        }
        ayw();
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
                    bVar.ayy();
                } else {
                    if (DEBUG) {
                        Log.d("SwanAppUpdateManager", "doRequestSuccess: node => " + bVar.getNodeName() + " update");
                    }
                    bVar.u(optJSONObject2, str);
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
        fu(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doRequestFail: ");
        }
        at(list);
        fu(false);
    }

    private void fu(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "onRequestFinish: request finish");
        }
        if (this.cTo.decrementAndGet() > 0) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "onRequestFinish: do pending request");
            }
            this.cTo.set(0);
            if (com.baidu.swan.apps.performance.b.c.azE()) {
                if (!z) {
                    update();
                    return;
                }
                return;
            }
            update();
            return;
        }
        ayt();
    }

    private void ayt() {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "onUpdateFinish: real finish update");
        }
        this.cTo.set(0);
        Iterator<com.baidu.swan.apps.network.c.a.a> it = this.cTp.iterator();
        while (it.hasNext()) {
            final com.baidu.swan.apps.network.c.a.a next = it.next();
            com.baidu.swan.apps.setting.oauth.c.h(new Runnable() { // from class: com.baidu.swan.apps.network.c.a.2
                @Override // java.lang.Runnable
                public void run() {
                    next.ayt();
                }
            });
        }
        this.cTp.clear();
    }

    private void at(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            bVar.onFail();
        }
    }

    @NonNull
    private ArrayMap<String, String> au(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        if (list.size() == 0) {
            return arrayMap;
        }
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            arrayMap.put(bVar.getNodeName(), "");
        }
        e aDa = e.aDa();
        if (aDa == null) {
            return arrayMap;
        }
        String string = aDa.aDm().getString("update_nodes_version", "");
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
        e aDa;
        JSONObject jSONObject;
        if (list.size() != 0 && (aDa = e.aDa()) != null) {
            String string = aDa.aDm().getString("update_nodes_version", "");
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
                aDa.aDm().putString("update_nodes_version", jSONObject.toString());
            }
            jSONObject = jSONObject2;
            while (r4.hasNext()) {
            }
            aDa.aDm().putString("update_nodes_version", jSONObject.toString());
        }
    }

    private boolean ayu() {
        long ayx = ayx();
        return ayx <= 0 || System.currentTimeMillis() - ayx > cTl;
    }

    public void ayv() {
        if (d.aCW().aBj()) {
            d.aCW().aCS().aDm().remove(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
        }
        ays();
    }

    private void ayw() {
        if (d.aCW().aBj()) {
            d.aCW().aCS().aDm().putLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, System.currentTimeMillis());
        }
    }

    public long ayx() {
        return d.aCW().aBj() ? d.aCW().aCS().aDm().getLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L) : System.currentTimeMillis();
    }

    public void a(@NonNull com.baidu.swan.apps.storage.c.b bVar, @NonNull JSONObject jSONObject) {
        JSONObject jSONObject2;
        long currentTimeMillis = System.currentTimeMillis();
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "parse increment accredit node start");
        }
        String string = bVar.getString("node_data_accredit_list", "");
        boolean azF = com.baidu.swan.apps.performance.b.c.azF();
        com.baidu.swan.apps.console.c.bg("SwanAppUpdateManager", "cacheData is Empty = " + TextUtils.isEmpty(string) + " ; mergeNodeSwitch = " + azF);
        if (TextUtils.isEmpty(string)) {
            JSONObject jSONObject3 = new JSONObject();
            v.b(jSONObject3, "list", jSONObject);
            String jSONObject4 = jSONObject3.toString();
            bVar.putString("node_data_accredit_list", jSONObject4);
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "local has no cache data, write directly. pending data = " + jSONObject4);
            }
        } else if (!azF) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "local has no cache data, mergeNodeSwitch = false");
                return;
            }
            return;
        } else {
            HashMap<String, JSONObject> bk = bk(jSONObject);
            if (bk == null || bk.size() == 0) {
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
                if (!TextUtils.isEmpty(next) && (jSONObject2 = bk.get(next)) != null) {
                    v.b(optJSONObject, next, jSONObject2);
                }
            }
            v.b(parseString, "list", optJSONObject);
            bVar.putString("node_data_accredit_list", parseString.toString());
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "local has cache data, pending size = " + bk.size());
            }
        }
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "parse increment accredit node end, cost = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private HashMap<String, JSONObject> bk(@NonNull JSONObject jSONObject) {
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
