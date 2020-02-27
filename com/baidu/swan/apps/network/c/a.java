package com.baidu.swan.apps.network.c;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.db.TableDefine;
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
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final long bGH = TimeUnit.HOURS.toMillis(5);
    private static volatile a bGI;
    private List<com.baidu.swan.apps.network.c.b.b> bGJ;
    private AtomicInteger bGK;
    private CopyOnWriteArrayList<com.baidu.swan.apps.network.c.a.a> bGL;

    public static a YZ() {
        if (bGI == null) {
            synchronized (a.class) {
                if (bGI == null) {
                    bGI = new a();
                }
            }
        }
        return bGI;
    }

    private a() {
        init();
    }

    private void init() {
        Za();
        this.bGK = new AtomicInteger(0);
        this.bGL = new CopyOnWriteArrayList<>();
    }

    private void Za() {
        this.bGJ = new ArrayList();
        this.bGJ.add(new com.baidu.swan.apps.network.c.b.a());
        this.bGJ.add(new c());
    }

    public void Zb() {
        a((com.baidu.swan.apps.network.c.a.a) null);
    }

    public void a(@Nullable com.baidu.swan.apps.network.c.a.a aVar) {
        if (Ze()) {
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
            aVar.Zd();
        }
    }

    public void update() {
        b(null);
    }

    public void b(@Nullable com.baidu.swan.apps.network.c.a.a aVar) {
        if (aVar != null) {
            this.bGL.add(aVar);
        }
        V(this.bGJ);
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
            Log.d("SwanAppUpdateManager", "resetNodeVersion: " + bVar.Zi());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        arrayMap.put(bVar.Zi(), "");
        c(arrayList, arrayMap);
    }

    public void release() {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "release: ");
        }
        if (bGI != null) {
            this.bGL.clear();
            bGI = null;
        }
    }

    private void V(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        if (list.size() == 0) {
            if (DEBUG) {
                Log.w("SwanAppUpdateManager", "doUpdate: finish => nodes are empty");
            }
            Zd();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doUpdate: start => nodes size " + list.size());
        }
        if (this.bGK.incrementAndGet() > 1) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "doUpdate: pending => wait previous request");
                return;
            }
            return;
        }
        ArrayMap<String, String> Y = Y(this.bGJ);
        JSONObject a = a(list, Y);
        if (a == null) {
            if (DEBUG) {
                Log.w("SwanAppUpdateManager", "doUpdate: finish => build params is null");
            }
            Zd();
            return;
        }
        com.baidu.swan.apps.setting.oauth.c.YU().newCall(new Request.Builder().url(com.baidu.swan.apps.w.a.Ug().HV()).post(new FormBody.Builder().add("data", a.toString()).build()).build()).enqueue(b(list, Y));
    }

    @Nullable
    private JSONObject a(@NonNull List<com.baidu.swan.apps.network.c.b.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        if (list.size() == 0) {
            return null;
        }
        String acF = e.acF();
        if (TextUtils.isEmpty(acF)) {
            return null;
        }
        String VH = e.acD().GC().VH();
        if (TextUtils.isEmpty(VH)) {
            VH = "NA";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", acF);
            jSONObject.put("source", VH);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                String str = "";
                if (arrayMap.containsKey(bVar.Zi())) {
                    str = arrayMap.get(bVar.Zi());
                }
                if (DEBUG) {
                    Log.d("SwanAppUpdateManager", "buildRequestParams: node => " + bVar.Zi() + " , version => " + str);
                }
                jSONObject2.put("version", str);
                jSONObject.put(bVar.Zi(), jSONObject2);
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
                a.this.W(list);
            }

            @Override // okhttp3.Callback
            public void onResponse(@NonNull Call call, @NonNull Response response) {
                if (a.DEBUG) {
                    Log.d("SwanAppUpdateManager", "onResponse: update request return");
                }
                if (!response.isSuccessful()) {
                    a.this.W(list);
                    return;
                }
                ResponseBody body = response.body();
                if (body == null) {
                    a.this.W(list);
                    return;
                }
                String str = null;
                try {
                    str = body.string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (TextUtils.isEmpty(str)) {
                    a.this.W(list);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                        a.this.W(list);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null) {
                        a.this.W(list);
                    } else {
                        a.this.a(optJSONObject, list, arrayMap);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    a.this.W(list);
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
        Zg();
        boolean z2 = false;
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            JSONObject optJSONObject = jSONObject.optJSONObject(bVar.Zi());
            if (optJSONObject == null) {
                bVar.onFail();
            } else if (!TextUtils.equals(optJSONObject.optString("errno"), "0")) {
                bVar.onFail();
            } else {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                if (optJSONObject2 == null) {
                    bVar.Zj();
                } else {
                    if (DEBUG) {
                        Log.d("SwanAppUpdateManager", "doRequestSuccess: node => " + bVar.Zi() + " update");
                    }
                    bVar.av(optJSONObject2);
                    String optString = optJSONObject.optString("version", "");
                    if (TextUtils.isEmpty(optString)) {
                        z = z2;
                    } else {
                        if (DEBUG) {
                            Log.d("SwanAppUpdateManager", "doRequestSuccess: " + bVar.Zi() + " update , version " + optString);
                        }
                        arrayMap.put(bVar.Zi(), optString);
                        z = true;
                    }
                    z2 = z;
                }
            }
        }
        if (z2) {
            c(list, arrayMap);
        }
        Zc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "doRequestFail: ");
        }
        X(list);
        Zc();
    }

    private void Zc() {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "onRequestFinish: request finish");
        }
        if (this.bGK.decrementAndGet() > 0) {
            if (DEBUG) {
                Log.d("SwanAppUpdateManager", "onRequestFinish: do pending request");
            }
            this.bGK.set(0);
            update();
            return;
        }
        Zd();
    }

    private void Zd() {
        if (DEBUG) {
            Log.d("SwanAppUpdateManager", "onUpdateFinish: real finish update");
        }
        this.bGK.set(0);
        Iterator<com.baidu.swan.apps.network.c.a.a> it = this.bGL.iterator();
        while (it.hasNext()) {
            final com.baidu.swan.apps.network.c.a.a next = it.next();
            com.baidu.swan.apps.setting.oauth.c.g(new Runnable() { // from class: com.baidu.swan.apps.network.c.a.2
                @Override // java.lang.Runnable
                public void run() {
                    next.Zd();
                }
            });
        }
        this.bGL.clear();
    }

    private void X(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            bVar.onFail();
        }
    }

    @NonNull
    private ArrayMap<String, String> Y(@NonNull List<com.baidu.swan.apps.network.c.b.b> list) {
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        if (list.size() == 0) {
            return arrayMap;
        }
        for (com.baidu.swan.apps.network.c.b.b bVar : list) {
            arrayMap.put(bVar.Zi(), "");
        }
        e acD = e.acD();
        if (acD == null) {
            return arrayMap;
        }
        String string = acD.acN().getString("update_nodes_version", "");
        if (TextUtils.isEmpty(string)) {
            return arrayMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            for (com.baidu.swan.apps.network.c.b.b bVar2 : list) {
                arrayMap.put(bVar2.Zi(), jSONObject.optString(bVar2.Zi(), ""));
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
        e acD;
        JSONObject jSONObject;
        if (list.size() != 0 && (acD = e.acD()) != null) {
            String string = acD.acN().getString("update_nodes_version", "");
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(string)) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                for (com.baidu.swan.apps.network.c.b.b bVar : list) {
                    String str = arrayMap.get(bVar.Zi());
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    try {
                        if (DEBUG) {
                            Log.d("SwanAppUpdateManager", "updateNodeVersions: update node => " + bVar.Zi() + " , version => " + str);
                        }
                        jSONObject.put(bVar.Zi(), str);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                acD.acN().putString("update_nodes_version", jSONObject.toString());
            }
            jSONObject = jSONObject2;
            while (r4.hasNext()) {
            }
            acD.acN().putString("update_nodes_version", jSONObject.toString());
        }
    }

    private boolean Ze() {
        long Zh = Zh();
        return Zh <= 0 || System.currentTimeMillis() - Zh > bGH;
    }

    public void Zf() {
        if (d.acA().abh()) {
            d.acA().acx().acN().remove(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
        }
        Zb();
    }

    private void Zg() {
        if (d.acA().abh()) {
            d.acA().acx().acN().putLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, System.currentTimeMillis());
        }
    }

    private long Zh() {
        return d.acA().abh() ? d.acA().acx().acN().getLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L) : System.currentTimeMillis();
    }
}
