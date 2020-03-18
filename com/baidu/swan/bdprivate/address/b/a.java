package com.baidu.swan.bdprivate.address.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.swan.apps.as.m;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cbD;
    private List<com.baidu.swan.bdprivate.address.c.b> cbI = new ArrayList();
    private Bundle cbL;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class c {
        private static final a ccq = new a();
    }

    public static a aii() {
        return c.ccq;
    }

    public void R(Bundle bundle) {
        this.cbL = bundle;
        if (this.cbL != null) {
            String string = this.cbL.getString("openSource");
            if (!TextUtils.isEmpty(string)) {
                this.cbD = string;
            }
        }
    }

    public void a(com.baidu.swan.bdprivate.address.b.b bVar) {
        if (this.cbL == null) {
            if (bVar != null) {
                bVar.onFailure("param is empty");
                return;
            }
            return;
        }
        new b(bVar, "list");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (TextUtils.equals(this.cbD, "aiapp")) {
            linkedHashMap.put("ma_id", this.cbL.getString("appId"));
            linkedHashMap.put("app_key", this.cbL.getString("appKey"));
            linkedHashMap.put("host_pkgname", this.cbL.getString(PushClientConstants.TAG_PKG_NAME));
            linkedHashMap.put("host_key_hash", this.cbL.getString("keyHash"));
            linkedHashMap.put("stoken", this.cbL.getString("stoken"));
            linkedHashMap.put("host_api_key", com.baidu.swan.apps.w.a.Ul().If());
        }
        a(null, bVar, linkedHashMap, "list");
    }

    public List<com.baidu.swan.bdprivate.address.c.b> aij() {
        String readCacheData = com.baidu.swan.d.c.readCacheData(AppRuntime.getAppContext(), "delivery_data.json");
        if (!TextUtils.isEmpty(readCacheData)) {
            try {
                this.cbI = com.baidu.swan.bdprivate.address.c.c.C(new JSONArray(readCacheData));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return this.cbI;
    }

    public void aik() {
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.bdprivate.address.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.d.c.cache(AppRuntime.getAppContext(), "delivery_data.json", com.baidu.swan.bdprivate.address.c.c.ae(a.this.cbI).toString(), 0);
            }
        }, "saveCacheToLocal");
    }

    public List<com.baidu.swan.bdprivate.address.c.b> ail() {
        if (this.cbI == null) {
            this.cbI = new ArrayList();
        }
        return this.cbI;
    }

    public void a(com.baidu.swan.bdprivate.address.c.b bVar, com.baidu.swan.bdprivate.address.b.b bVar2) {
        if (bVar == null || !bVar.isValid()) {
            if (DEBUG) {
                Log.d("DeliveryDataManager", "requestAddDelivery: deliveryAddr is invalid");
                return;
            }
            return;
        }
        a(bVar, bVar2, a(bVar), "add");
    }

    public void b(com.baidu.swan.bdprivate.address.c.b bVar, com.baidu.swan.bdprivate.address.b.b bVar2) {
        if (bVar == null || TextUtils.isEmpty(bVar.id)) {
            if (DEBUG) {
                Log.d("DeliveryDataManager", "requestDeleteDelivery: deliveryAddr-id is empty");
                return;
            }
            return;
        }
        a(bVar, bVar2, a(bVar), "delete");
    }

    public void c(com.baidu.swan.bdprivate.address.c.b bVar, com.baidu.swan.bdprivate.address.b.b bVar2) {
        if (bVar == null || TextUtils.isEmpty(bVar.id)) {
            if (DEBUG) {
                Log.d("DeliveryDataManager", "requestUpdateDelivery: deliveryAddr is invalid");
                return;
            }
            return;
        }
        a(bVar, bVar2, a(bVar), IMTrack.DbBuilder.ACTION_UPDATE);
    }

    public void d(com.baidu.swan.bdprivate.address.c.b bVar, com.baidu.swan.bdprivate.address.b.b bVar2) {
        if (bVar == null || TextUtils.isEmpty(bVar.id)) {
            if (DEBUG) {
                Log.d("DeliveryDataManager", "requestUpdateDefaultDelivery: deliveryAddr is invalid");
                return;
            }
            return;
        }
        a(bVar, bVar2, a(bVar), "updateDefault");
    }

    public void a(com.baidu.swan.bdprivate.address.c.b bVar, com.baidu.swan.bdprivate.address.b.b bVar2, Map<String, String> map, String str) {
        if (bVar == null && !TextUtils.equals(str, "list")) {
            if (DEBUG) {
                Log.d("DeliveryDataManager", "requestPostDelivery: deliveryAddr is null");
                return;
            }
            return;
        }
        b bVar3 = new b(bVar2, str);
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        String nc = nc(str);
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(nc)).addParam("data", jSONObject.toString()).cookieManager(com.baidu.swan.apps.w.a.Ux().Ix())).build().executeAsyncOnUIBack(bVar3);
    }

    private Map<String, String> a(com.baidu.swan.bdprivate.address.c.b bVar) {
        HashMap hashMap = new HashMap();
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.id)) {
                hashMap.put("id", bVar.id);
            }
            if (!TextUtils.isEmpty(bVar.userName)) {
                hashMap.put("name", bVar.userName);
            }
            if (!TextUtils.isEmpty(bVar.ccx)) {
                hashMap.put("phone", bVar.ccx);
            }
            if (bVar.ccz != null && !TextUtils.isEmpty(bVar.ccz.code)) {
                hashMap.put("l1", bVar.ccz.code);
            }
            if (bVar.ccA != null && !TextUtils.isEmpty(bVar.ccA.code)) {
                hashMap.put("l2", bVar.ccA.code);
            }
            if (bVar.ccB != null && !TextUtils.isEmpty(bVar.ccB.code)) {
                hashMap.put("l3", bVar.ccB.code);
            }
            if (!TextUtils.isEmpty(bVar.ccC)) {
                hashMap.put("street", bVar.ccC);
            }
            if (!TextUtils.isEmpty(bVar.ccD)) {
                hashMap.put("zipcode", bVar.ccD);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends StringResponseCallback {
        private com.baidu.swan.bdprivate.address.b.b ccp;
        private String mType;

        public b(com.baidu.swan.bdprivate.address.b.b bVar, String str) {
            this.ccp = bVar;
            this.mType = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            if (this.ccp != null) {
                this.ccp.aie();
                if (!TextUtils.isEmpty(str) && i == 200) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                            this.ccp.onFailure(jSONObject.optString("tipmsg"));
                            return;
                        }
                        String str2 = this.mType;
                        char c = 65535;
                        switch (str2.hashCode()) {
                            case -1335458389:
                                if (str2.equals("delete")) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case -838846263:
                                if (str2.equals(IMTrack.DbBuilder.ACTION_UPDATE)) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 96417:
                                if (str2.equals("add")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 3322014:
                                if (str2.equals("list")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 48853304:
                                if (str2.equals("updateDefault")) {
                                    c = 3;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                List<com.baidu.swan.bdprivate.address.c.b> ng = com.baidu.swan.bdprivate.address.c.c.ng(str);
                                a.this.cbI = ng;
                                this.ccp.b(ng, i);
                                a.this.aik();
                                return;
                            case 1:
                                this.ccp.I(str, i);
                                return;
                            case 2:
                                this.ccp.J(str, i);
                                return;
                            case 3:
                                this.ccp.J(str, i);
                                return;
                            case 4:
                                this.ccp.K(str, i);
                                return;
                            default:
                                return;
                        }
                    } catch (JSONException e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                        this.ccp.onFailure();
                        return;
                    }
                }
                this.ccp.onFailure();
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (this.ccp != null) {
                this.ccp.aie();
                this.ccp.onFailure();
            }
        }
    }

    private String nc(String str) {
        String str2 = "";
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1335458389:
                if (str.equals("delete")) {
                    c2 = 4;
                    break;
                }
                break;
            case -838846263:
                if (str.equals(IMTrack.DbBuilder.ACTION_UPDATE)) {
                    c2 = 2;
                    break;
                }
                break;
            case 96417:
                if (str.equals("add")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3322014:
                if (str.equals("list")) {
                    c2 = 0;
                    break;
                }
                break;
            case 48853304:
                if (str.equals("updateDefault")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                if (TextUtils.equals(this.cbD, "aiapp")) {
                    str2 = "/oa_list";
                    break;
                } else {
                    str2 = "/list";
                    break;
                }
            case 1:
                str2 = "/create";
                break;
            case 2:
                str2 = "/modify";
                break;
            case 3:
                str2 = "/modify_default";
                break;
            case 4:
                str2 = "/del";
                break;
        }
        if (!TextUtils.isEmpty(str2)) {
            return com.baidu.swan.apps.h.c.processCommonParams(com.baidu.swan.apps.h.c.Ll() + str2);
        }
        return str2;
    }

    /* renamed from: com.baidu.swan.bdprivate.address.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0316a implements com.baidu.swan.bdprivate.address.b.b {
        @Override // com.baidu.swan.bdprivate.address.b.b
        public void aie() {
        }

        @Override // com.baidu.swan.bdprivate.address.b.b
        public void J(String str, int i) {
        }

        @Override // com.baidu.swan.bdprivate.address.b.b
        public void K(String str, int i) {
        }

        @Override // com.baidu.swan.bdprivate.address.b.b
        public void I(String str, int i) {
        }

        @Override // com.baidu.swan.bdprivate.address.b.b
        public void b(List<com.baidu.swan.bdprivate.address.c.b> list, int i) {
        }

        @Override // com.baidu.swan.bdprivate.address.b.b
        public void onFailure() {
        }

        @Override // com.baidu.swan.bdprivate.address.b.b
        public void onFailure(String str) {
        }
    }
}
