package com.baidu.swan.apps.network.c;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.network.c.b.c;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import java.io.IOException;
import java.util.ArrayList;
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
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final long cqt = TimeUnit.HOURS.toMillis(5);
    private static volatile a cqu;
    private List<com.baidu.swan.apps.network.c.b.b> cqv;
    private AtomicInteger cqw;
    private CopyOnWriteArrayList<com.baidu.swan.apps.network.c.a.a> cqx;

    public static a akD() {
        if (cqu == null) {
            synchronized (a.class) {
                if (cqu == null) {
                    cqu = new a();
                }
            }
        }
        return cqu;
    }

    private a() {
        init();
    }

    private void init() {
        akE();
        this.cqw = new AtomicInteger(0);
        this.cqx = new CopyOnWriteArrayList<>();
    }

    private void akE() {
        this.cqv = new ArrayList();
        this.cqv.add(new com.baidu.swan.apps.network.c.b.a());
        this.cqv.add(new c());
    }

    public void akF() {
        a((com.baidu.swan.apps.network.c.a.a) null);
    }

    public void a(@Nullable com.baidu.swan.apps.network.c.a.a aVar) {
        if (akI()) {
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
            aVar.akH();
        }
    }

    public void update() {
        b(null);
    }

    public void b(@Nullable com.baidu.swan.apps.network.c.a.a aVar) {
        if (aVar != null) {
            this.cqx.add(aVar);
        }
        af(this.cqv);
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
        if (cqu != null) {
            this.cqx.clear();
            cqu = null;
        }
    }

    private void af(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        if (list.size() == 0) {
            if (DEBUG) {
                Log.w("SwanAppUpdateManager", "doUpdate: finish => nodes are empty");
            }
            akH();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doUpdate: start => nodes size " + list.size());
        }
        if (this.cqw.incrementAndGet() > 1) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "doUpdate: pending => wait previous request");
                return;
            }
            return;
        }
        ArrayMap<String, String> ai = ai(this.cqv);
        JSONObject a = a(list, ai);
        if (a == null) {
            if (DEBUG) {
                Log.w("SwanAppUpdateManager", "doUpdate: finish => build params is null");
            }
            akH();
            return;
        }
        a(com.baidu.swan.apps.u.a.afd().RP(), new FormBody.Builder().add("data", a.toString()).build(), list, ai);
    }

    private void a(String str, RequestBody requestBody, final List<com.baidu.swan.apps.network.c.b.b> list, final ArrayMap<String, String> arrayMap) {
        com.baidu.swan.c.b.a aVar = new com.baidu.swan.c.b.a(str, requestBody, new ResponseCallback() { // from class: com.baidu.swan.apps.network.c.a.1
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public Object parseResponse(Response response, int i) throws Exception {
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
                a.this.ag(list);
            }
        });
        aVar.dld = true;
        aVar.dle = true;
        aVar.dlf = false;
        com.baidu.swan.c.c.a.aFx().b(aVar);
    }

    @Nullable
    private JSONObject a(@NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        if (list.size() == 0) {
            return null;
        }
        String aoH = e.aoH();
        if (TextUtils.isEmpty(aoH)) {
            return null;
        }
        String agK = e.aoF().QJ().agK();
        if (TextUtils.isEmpty(agK)) {
            agK = "NA";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aoH);
            jSONObject.put("source", agK);
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
                if (DEBUG) {
                    Log.d("SwanAppUpdateManager", "buildRequestParams: node => " + bVar.getNodeName() + " , version => " + str);
                }
                jSONObject2.put("version", str);
                jSONObject.put(bVar.getNodeName(), jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
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
            ag(list);
            return;
        }
        ResponseBody body = response.body();
        if (body == null) {
            ag(list);
            return;
        }
        String str = null;
        try {
            str = body.string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(str)) {
            ag(list);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!TextUtils.equals(jSONObject.optString(BaseJsonData.TAG_ERRNO), "0")) {
                ag(list);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                ag(list);
            } else {
                a(optJSONObject, list, arrayMap);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            ag(list);
        }
    }

    private void a(@NonNull JSONObject jSONObject, @NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        boolean z;
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doRequestSuccess: start");
        }
        akK();
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
                    bVar.akM();
                } else {
                    if (DEBUG) {
                        Log.d("SwanAppUpdateManager", "doRequestSuccess: node => " + bVar.getNodeName() + " update");
                    }
                    bVar.aK(optJSONObject2);
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
        akG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doRequestFail: ");
        }
        ah(list);
        akG();
    }

    private void akG() {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "onRequestFinish: request finish");
        }
        if (this.cqw.decrementAndGet() > 0) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "onRequestFinish: do pending request");
            }
            this.cqw.set(0);
            update();
            return;
        }
        akH();
    }

    private void akH() {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "onUpdateFinish: real finish update");
        }
        this.cqw.set(0);
        Iterator<com.baidu.swan.apps.network.c.a.a> it = this.cqx.iterator();
        while (it.hasNext()) {
            final com.baidu.swan.apps.network.c.a.a next = it.next();
            com.baidu.swan.apps.setting.oauth.c.k(new Runnable() { // from class: com.baidu.swan.apps.network.c.a.2
                @Override // java.lang.Runnable
                public void run() {
                    next.akH();
                }
            });
        }
        this.cqx.clear();
    }

    private void ah(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            bVar.onFail();
        }
    }

    @NonNull
    private ArrayMap<String, String> ai(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        if (list.size() == 0) {
            return arrayMap;
        }
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            arrayMap.put(bVar.getNodeName(), "");
        }
        e aoF = e.aoF();
        if (aoF == null) {
            return arrayMap;
        }
        String string = aoF.aoR().getString("update_nodes_version", "");
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
    private void b(@NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        e aoF;
        JSONObject jSONObject;
        if (list.size() != 0 && (aoF = e.aoF()) != null) {
            String string = aoF.aoR().getString("update_nodes_version", "");
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
                        if (DEBUG) {
                            Log.d("SwanAppUpdateManager", "updateNodeVersions: update node => " + bVar.getNodeName() + " , version => " + str);
                        }
                        jSONObject.put(bVar.getNodeName(), str);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                aoF.aoR().putString("update_nodes_version", jSONObject.toString());
            }
            jSONObject = jSONObject2;
            while (r4.hasNext()) {
            }
            aoF.aoR().putString("update_nodes_version", jSONObject.toString());
        }
    }

    private boolean akI() {
        long akL = akL();
        return akL <= 0 || System.currentTimeMillis() - akL > cqt;
    }

    public void akJ() {
        if (d.aoB().ane()) {
            d.aoB().aox().aoR().remove(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
        }
        akF();
    }

    private void akK() {
        if (d.aoB().ane()) {
            d.aoB().aox().aoR().putLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, System.currentTimeMillis());
        }
    }

    public long akL() {
        return d.aoB().ane() ? d.aoB().aox().aoR().getLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L) : System.currentTimeMillis();
    }
}
