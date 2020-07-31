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
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final long cxj = TimeUnit.HOURS.toMillis(5);
    private static volatile a cxk;
    private List<com.baidu.swan.apps.network.c.b.b> cxl;
    private AtomicInteger cxm;
    private CopyOnWriteArrayList<com.baidu.swan.apps.network.c.a.a> cxn;

    public static a amZ() {
        if (cxk == null) {
            synchronized (a.class) {
                if (cxk == null) {
                    cxk = new a();
                }
            }
        }
        return cxk;
    }

    private a() {
        init();
    }

    private void init() {
        ana();
        this.cxm = new AtomicInteger(0);
        this.cxn = new CopyOnWriteArrayList<>();
    }

    private void ana() {
        this.cxl = new ArrayList();
        this.cxl.add(new com.baidu.swan.apps.network.c.b.a());
        this.cxl.add(new c());
    }

    public void anb() {
        a((com.baidu.swan.apps.network.c.a.a) null);
    }

    public void a(@Nullable com.baidu.swan.apps.network.c.a.a aVar) {
        if (ane()) {
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
            aVar.and();
        }
    }

    public void update() {
        b(null);
    }

    public void b(@Nullable com.baidu.swan.apps.network.c.a.a aVar) {
        if (aVar != null) {
            this.cxn.add(aVar);
        }
        aj(this.cxl);
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
        if (cxk != null) {
            this.cxn.clear();
            cxk = null;
        }
    }

    private void aj(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        if (list.size() == 0) {
            if (DEBUG) {
                Log.w("SwanAppUpdateManager", "doUpdate: finish => nodes are empty");
            }
            and();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doUpdate: start => nodes size " + list.size());
        }
        if (this.cxm.incrementAndGet() > 1) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "doUpdate: pending => wait previous request");
                return;
            }
            return;
        }
        ArrayMap<String, String> am = am(this.cxl);
        JSONObject a = a(list, am);
        if (a == null) {
            if (DEBUG) {
                Log.w("SwanAppUpdateManager", "doUpdate: finish => build params is null");
            }
            and();
            return;
        }
        a(com.baidu.swan.apps.t.a.ahv().Tq(), new FormBody.Builder().add("data", a.toString()).build(), list, am);
    }

    private void a(String str, RequestBody requestBody, final List<com.baidu.swan.apps.network.c.b.b> list, final ArrayMap<String, String> arrayMap) {
        com.baidu.swan.b.b.a aVar = new com.baidu.swan.b.b.a(str, requestBody, new ResponseCallback() { // from class: com.baidu.swan.apps.network.c.a.1
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
        aVar.dvF = true;
        aVar.dvG = true;
        aVar.dvH = false;
        com.baidu.swan.b.c.a.aKu().b(aVar);
    }

    @Nullable
    private JSONObject a(@NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        if (list.size() == 0) {
            return null;
        }
        String arx = e.arx();
        if (TextUtils.isEmpty(arx)) {
            return null;
        }
        String ajg = e.arv().Se().ajg();
        if (TextUtils.isEmpty(ajg)) {
            ajg = "NA";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", arx);
            jSONObject.put("source", ajg);
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
            String optString = jSONObject.optString("request_id", "");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                ak(list);
            } else {
                a(optJSONObject, list, arrayMap, optString);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            ak(list);
        }
    }

    private void a(@NonNull JSONObject jSONObject, @NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap, String str) {
        boolean z;
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doRequestSuccess: start");
        }
        ang();
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
                    bVar.ani();
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
        anc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doRequestFail: ");
        }
        al(list);
        anc();
    }

    private void anc() {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "onRequestFinish: request finish");
        }
        if (this.cxm.decrementAndGet() > 0) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "onRequestFinish: do pending request");
            }
            this.cxm.set(0);
            update();
            return;
        }
        and();
    }

    private void and() {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "onUpdateFinish: real finish update");
        }
        this.cxm.set(0);
        Iterator<com.baidu.swan.apps.network.c.a.a> it = this.cxn.iterator();
        while (it.hasNext()) {
            final com.baidu.swan.apps.network.c.a.a next = it.next();
            com.baidu.swan.apps.setting.oauth.c.k(new Runnable() { // from class: com.baidu.swan.apps.network.c.a.2
                @Override // java.lang.Runnable
                public void run() {
                    next.and();
                }
            });
        }
        this.cxn.clear();
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
        e arv = e.arv();
        if (arv == null) {
            return arrayMap;
        }
        String string = arv.arH().getString("update_nodes_version", "");
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
        e arv;
        JSONObject jSONObject;
        if (list.size() != 0 && (arv = e.arv()) != null) {
            String string = arv.arH().getString("update_nodes_version", "");
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
                arv.arH().putString("update_nodes_version", jSONObject.toString());
            }
            jSONObject = jSONObject2;
            while (r4.hasNext()) {
            }
            arv.arH().putString("update_nodes_version", jSONObject.toString());
        }
    }

    private boolean ane() {
        long anh = anh();
        return anh <= 0 || System.currentTimeMillis() - anh > cxj;
    }

    public void anf() {
        if (d.arr().apU()) {
            d.arr().arn().arH().remove(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
        }
        anb();
    }

    private void ang() {
        if (d.arr().apU()) {
            d.arr().arn().arH().putLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, System.currentTimeMillis());
        }
    }

    public long anh() {
        return d.arr().apU() ? d.arr().arn().arH().getLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L) : System.currentTimeMillis();
    }
}
