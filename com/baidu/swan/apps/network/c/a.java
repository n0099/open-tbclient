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
    private static final long cvi = TimeUnit.HOURS.toMillis(5);
    private static volatile a cvj;
    private List<com.baidu.swan.apps.network.c.b.b> cvk;
    private AtomicInteger cvl;
    private CopyOnWriteArrayList<com.baidu.swan.apps.network.c.a.a> cvm;

    public static a alJ() {
        if (cvj == null) {
            synchronized (a.class) {
                if (cvj == null) {
                    cvj = new a();
                }
            }
        }
        return cvj;
    }

    private a() {
        init();
    }

    private void init() {
        alK();
        this.cvl = new AtomicInteger(0);
        this.cvm = new CopyOnWriteArrayList<>();
    }

    private void alK() {
        this.cvk = new ArrayList();
        this.cvk.add(new com.baidu.swan.apps.network.c.b.a());
        this.cvk.add(new c());
    }

    public void alL() {
        a((com.baidu.swan.apps.network.c.a.a) null);
    }

    public void a(@Nullable com.baidu.swan.apps.network.c.a.a aVar) {
        if (alO()) {
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
            aVar.alN();
        }
    }

    public void update() {
        b(null);
    }

    public void b(@Nullable com.baidu.swan.apps.network.c.a.a aVar) {
        if (aVar != null) {
            this.cvm.add(aVar);
        }
        aj(this.cvk);
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
        if (cvj != null) {
            this.cvm.clear();
            cvj = null;
        }
    }

    private void aj(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        if (list.size() == 0) {
            if (DEBUG) {
                Log.w("SwanAppUpdateManager", "doUpdate: finish => nodes are empty");
            }
            alN();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doUpdate: start => nodes size " + list.size());
        }
        if (this.cvl.incrementAndGet() > 1) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "doUpdate: pending => wait previous request");
                return;
            }
            return;
        }
        ArrayMap<String, String> am = am(this.cvk);
        JSONObject a = a(list, am);
        if (a == null) {
            if (DEBUG) {
                Log.w("SwanAppUpdateManager", "doUpdate: finish => build params is null");
            }
            alN();
            return;
        }
        a(com.baidu.swan.apps.u.a.agj().SV(), new FormBody.Builder().add("data", a.toString()).build(), list, am);
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
                a.this.ak(list);
            }
        });
        aVar.dpO = true;
        aVar.dpP = true;
        aVar.dpQ = false;
        com.baidu.swan.c.c.a.aGD().b(aVar);
    }

    @Nullable
    private JSONObject a(@NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        if (list.size() == 0) {
            return null;
        }
        String apO = e.apO();
        if (TextUtils.isEmpty(apO)) {
            return null;
        }
        String ahQ = e.apM().RP().ahQ();
        if (TextUtils.isEmpty(ahQ)) {
            ahQ = "NA";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", apO);
            jSONObject.put("source", ahQ);
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
            ak(list);
            return;
        }
        ResponseBody body = response.body();
        if (body == null) {
            ak(list);
            return;
        }
        String str = null;
        try {
            str = body.string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(str)) {
            ak(list);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!TextUtils.equals(jSONObject.optString(BaseJsonData.TAG_ERRNO), "0")) {
                ak(list);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                ak(list);
            } else {
                a(optJSONObject, list, arrayMap);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            ak(list);
        }
    }

    private void a(@NonNull JSONObject jSONObject, @NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        boolean z;
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doRequestSuccess: start");
        }
        alQ();
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
                    bVar.alS();
                } else {
                    if (DEBUG) {
                        Log.d("SwanAppUpdateManager", "doRequestSuccess: node => " + bVar.getNodeName() + " update");
                    }
                    bVar.aR(optJSONObject2);
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
        alM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doRequestFail: ");
        }
        al(list);
        alM();
    }

    private void alM() {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "onRequestFinish: request finish");
        }
        if (this.cvl.decrementAndGet() > 0) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "onRequestFinish: do pending request");
            }
            this.cvl.set(0);
            update();
            return;
        }
        alN();
    }

    private void alN() {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "onUpdateFinish: real finish update");
        }
        this.cvl.set(0);
        Iterator<com.baidu.swan.apps.network.c.a.a> it = this.cvm.iterator();
        while (it.hasNext()) {
            final com.baidu.swan.apps.network.c.a.a next = it.next();
            com.baidu.swan.apps.setting.oauth.c.k(new Runnable() { // from class: com.baidu.swan.apps.network.c.a.2
                @Override // java.lang.Runnable
                public void run() {
                    next.alN();
                }
            });
        }
        this.cvm.clear();
    }

    private void al(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            bVar.onFail();
        }
    }

    @NonNull
    private ArrayMap<String, String> am(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        if (list.size() == 0) {
            return arrayMap;
        }
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            arrayMap.put(bVar.getNodeName(), "");
        }
        e apM = e.apM();
        if (apM == null) {
            return arrayMap;
        }
        String string = apM.apY().getString("update_nodes_version", "");
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
        e apM;
        JSONObject jSONObject;
        if (list.size() != 0 && (apM = e.apM()) != null) {
            String string = apM.apY().getString("update_nodes_version", "");
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
                apM.apY().putString("update_nodes_version", jSONObject.toString());
            }
            jSONObject = jSONObject2;
            while (r4.hasNext()) {
            }
            apM.apY().putString("update_nodes_version", jSONObject.toString());
        }
    }

    private boolean alO() {
        long alR = alR();
        return alR <= 0 || System.currentTimeMillis() - alR > cvi;
    }

    public void alP() {
        if (d.apI().aok()) {
            d.apI().apE().apY().remove(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
        }
        alL();
    }

    private void alQ() {
        if (d.apI().aok()) {
            d.apI().apE().apY().putLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, System.currentTimeMillis());
        }
    }

    public long alR() {
        return d.apI().aok() ? d.apI().apE().apY().getLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L) : System.currentTimeMillis();
    }
}
