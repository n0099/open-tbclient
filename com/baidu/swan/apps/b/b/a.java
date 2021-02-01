package com.baidu.swan.apps.b.b;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.v;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.network.f;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.c;
import com.baidu.swan.apps.setting.oauth.h;
import java.util.HashMap;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends d {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b jN(String str) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bh = com.baidu.swan.apps.api.d.b.bh("Api-Base", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bh.first;
        JSONObject jSONObject = (JSONObject) bh.second;
        if (bVar.isSuccess() && jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return new com.baidu.swan.apps.api.c.b(201, "contentIds is invalid");
            }
            String optString = jSONObject.optString("category");
            if (TextUtils.isEmpty(optString)) {
                return new com.baidu.swan.apps.api.c.b(201, "category is invalid");
            }
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                return new com.baidu.swan.apps.api.c.b(202, "cb is invalid");
            }
            if (!SwanAppNetworkUtils.isNetworkConnected(getContext())) {
                com.baidu.swan.apps.res.widget.b.d.u(getContext(), a.h.aiapps_net_error).aIs();
                return new com.baidu.swan.apps.api.c.b(1001, "network is not connected");
            } else if (agp()) {
                agq();
                return new com.baidu.swan.apps.api.c.b(10003, c.gn(10003));
            } else {
                a(optJSONArray, optString, optString2);
                return new com.baidu.swan.apps.api.c.b(0);
            }
        }
        return bVar;
    }

    private void a(final JSONArray jSONArray, final String str, final String str2) {
        com.baidu.swan.apps.runtime.d.aIG().aIC().aIW().b(getContext(), "scope_insert_bookshelf", new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.b.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(h<b.d> hVar) {
                if (c.b(hVar)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", e.aIM());
                    hashMap.put("contentIds", jSONArray);
                    hashMap.put("category", str);
                    a.this.a("INSERT", hashMap, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.api.c.b>() { // from class: com.baidu.swan.apps.b.b.a.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.core.f.b
                        /* renamed from: a */
                        public void N(com.baidu.swan.apps.api.c.b bVar) {
                            a.this.a(str2, bVar);
                        }
                    });
                    return;
                }
                a.this.a(str2, new com.baidu.swan.apps.api.c.b(hVar.getErrorCode(), c.gn(hVar.getErrorCode())));
                com.baidu.swan.apps.res.widget.b.d.u(a.this.getContext(), a.h.swan_bookshelf_authorize_fail).aIs();
            }
        });
    }

    private boolean agp() {
        com.baidu.swan.apps.setting.oauth.e eVar = com.baidu.swan.apps.network.c.b.a.gq(true).get("scope_insert_bookshelf");
        return eVar == null || (eVar.dJg < 0 && !eVar.forbidden);
    }

    public com.baidu.swan.apps.api.c.b jO(String str) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bh = com.baidu.swan.apps.api.d.b.bh("Api-Base", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bh.first;
        JSONObject jSONObject = (JSONObject) bh.second;
        if (bVar.isSuccess() && jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return new com.baidu.swan.apps.api.c.b(201, "contentIds is invalid");
            }
            final String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new com.baidu.swan.apps.api.c.b(202, "cb is invalid");
            }
            if (!SwanAppNetworkUtils.isNetworkConnected(getContext())) {
                return new com.baidu.swan.apps.api.c.b(1001, "network is not connected");
            }
            if (!com.baidu.swan.apps.runtime.d.aIG().aIC().aIX().isLogin(getContext())) {
                return new com.baidu.swan.apps.api.c.b(1001, "user is not login");
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("appKey", e.aIM());
            hashMap.put("contentIds", optJSONArray);
            a("QUERY", hashMap, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.api.c.b>() { // from class: com.baidu.swan.apps.b.b.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.core.f.b
                /* renamed from: a */
                public void N(com.baidu.swan.apps.api.c.b bVar2) {
                    a.this.a(optString, bVar2);
                }
            });
            return new com.baidu.swan.apps.api.c.b(0);
        }
        return bVar;
    }

    public com.baidu.swan.apps.api.c.b jP(String str) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bh = com.baidu.swan.apps.api.d.b.bh("Api-Base", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bh.first;
        JSONObject jSONObject = (JSONObject) bh.second;
        if (bVar.isSuccess() && jSONObject != null) {
            String optString = jSONObject.optString("contentId");
            if (TextUtils.isEmpty(optString)) {
                return new com.baidu.swan.apps.api.c.b(201, "contentId is invalid");
            }
            String optString2 = jSONObject.optString("category");
            if (TextUtils.isEmpty(optString2)) {
                return new com.baidu.swan.apps.api.c.b(201, "category is invalid");
            }
            final String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                return new com.baidu.swan.apps.api.c.b(202, "cb is invalid");
            }
            if (!SwanAppNetworkUtils.isNetworkConnected(getContext())) {
                return new com.baidu.swan.apps.api.c.b(1001, "network is not connected");
            }
            if (!com.baidu.swan.apps.runtime.d.aIG().aIC().aIX().isLogin(getContext())) {
                return new com.baidu.swan.apps.api.c.b(1001, "user is not login");
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("appKey", e.aIM());
            hashMap.put("contentId", optString);
            hashMap.put("category", optString2);
            a("UPDATE_READ_TIME", hashMap, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.api.c.b>() { // from class: com.baidu.swan.apps.b.b.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.core.f.b
                /* renamed from: a */
                public void N(com.baidu.swan.apps.api.c.b bVar2) {
                    a.this.a(optString3, bVar2);
                }
            });
            return new com.baidu.swan.apps.api.c.b(0);
        }
        return bVar;
    }

    public com.baidu.swan.apps.api.c.b jQ(String str) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bh = com.baidu.swan.apps.api.d.b.bh("Api-Base", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bh.first;
        JSONObject jSONObject = (JSONObject) bh.second;
        if (bVar.isSuccess() && jSONObject != null) {
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new com.baidu.swan.apps.api.c.b(202, "cb is invalid");
            }
            if (!com.baidu.swan.apps.runtime.d.aIG().aIC().aIX().isLogin(getContext())) {
                jR(optString);
                return new com.baidu.swan.apps.api.c.b(0);
            }
            jS(optString);
            return new com.baidu.swan.apps.api.c.b(0);
        }
        return bVar;
    }

    private void jR(final String str) {
        e aIC = com.baidu.swan.apps.runtime.d.aIG().aIC();
        aIC.aIX().a(aIC.aIE(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.b.b.a.4
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    a.this.jS(str);
                } else {
                    a.this.a(str, new com.baidu.swan.apps.api.c.b(1001, "user is not login"));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jS(final String str) {
        ak.d(new CallbackHandler() { // from class: com.baidu.swan.apps.b.b.a.5
            @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
            public void handleSchemeDispatchCallback(String str2, String str3) {
                a.this.bc(str3, str);
            }

            @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
            public String getCurrentPageUrl() {
                return null;
            }
        });
    }

    private void agq() {
        final String string = getContext().getString(a.h.swan_bookshelf_setting_dialog_title);
        final String string2 = getContext().getString(a.h.swan_bookshelf_setting_dialog_content);
        final String string3 = getContext().getString(a.h.swan_bookshelf_setting_dialog_positive);
        final String string4 = getContext().getString(a.h.swan_bookshelf_setting_dialog_negative);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.b.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                g.a aVar = new g.a(a.this.getContext());
                aVar.f(string).rx(string2).aHT().a(new com.baidu.swan.apps.view.c.a()).gT(false).a(string3, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.b.b.a.6.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.baidu.swan.apps.runtime.d.aIG().aIC().aIW().aKs();
                    }
                }).b(string4, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.b.b.a.6.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                aVar.aHX();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, HashMap<String, Object> hashMap, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.api.c.b> bVar) {
        final boolean equals = TextUtils.equals(str, "INSERT");
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        RequestBody create = RequestBody.create(f.a.doP, jSONObject.toString());
        String jT = jT(str);
        if (TextUtils.isEmpty(jT)) {
            a(bVar, 1001, "operation fail, msg = url is null", equals);
            return;
        }
        if (equals) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.b.b.a.7
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.res.widget.b.d.u(a.this.getContext(), a.h.swan_bookshelf_insert_async).jj(10).hc(false).aIw();
                }
            });
        }
        ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) com.baidu.swan.a.c.a.bbY().postRequest().requestBody(create).url(jT)).cookieManager(com.baidu.swan.apps.t.a.axv().aiy())).build().executeAsync(new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.apps.b.b.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public JSONObject parseResponse(Response response, int i) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                return v.parseString(response.body().string());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public void onSuccess(JSONObject jSONObject2, int i) {
                if (equals) {
                    com.baidu.swan.apps.res.widget.b.d.cancelToast();
                }
                if (jSONObject2 == null) {
                    a.this.a(bVar, 1001, "server response fail", equals);
                    return;
                }
                int optInt = jSONObject2.optInt(BaseJsonData.TAG_ERRNO, -1);
                if (optInt != 0) {
                    if (equals) {
                        com.baidu.swan.apps.res.widget.b.d.u(com.baidu.swan.apps.t.a.awW(), a.h.swan_bookshelf_insert_failed).aIs();
                    }
                    a.this.a((com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.api.c.b>) bVar, optInt, jSONObject2.optString(BaseJsonData.TAG_ERRMSG), false);
                    return;
                }
                JSONObject optJSONObject = jSONObject2.optJSONObject("data");
                if (optJSONObject == null) {
                    a.this.a(bVar, 0, jSONObject2.optString(BaseJsonData.TAG_ERRMSG), equals);
                } else {
                    a.this.a(bVar, optJSONObject, equals);
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (equals) {
                    com.baidu.swan.apps.res.widget.b.d.cancelToast();
                }
                a.this.a(bVar, 1001, "operation fail, msg = " + exc.getMessage(), equals);
            }
        });
    }

    private String jT(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -2130463047:
                if (str.equals("INSERT")) {
                    c = 0;
                    break;
                }
                break;
            case 77406376:
                if (str.equals("QUERY")) {
                    c = 1;
                    break;
                }
                break;
            case 1020968928:
                if (str.equals("UPDATE_READ_TIME")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return com.baidu.swan.apps.t.a.axi().aiv();
            case 1:
                return com.baidu.swan.apps.t.a.axi().aiw();
            case 2:
                return com.baidu.swan.apps.t.a.axi().aix();
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.api.c.b> bVar, int i, String str, boolean z) {
        if (bVar != null) {
            bVar.N(new com.baidu.swan.apps.api.c.b(i, str));
        }
        if (z) {
            com.baidu.swan.apps.res.widget.b.d.a(com.baidu.swan.apps.t.a.awW(), str).aIs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.api.c.b> bVar, JSONObject jSONObject, boolean z) {
        if (bVar != null && jSONObject != null) {
            bVar.N(new com.baidu.swan.apps.api.c.b(0, jSONObject));
        }
        if (z) {
            com.baidu.swan.apps.res.widget.b.d.a(getContext(), getContext().getString(a.h.swan_bookshelf_insert_success)).jf(1).jj(3).b(new d.a() { // from class: com.baidu.swan.apps.b.b.a.9
                @Override // com.baidu.swan.apps.res.widget.b.d.a
                public void agr() {
                    ak.d(null);
                }
            }).aIx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(String str, String str2) {
        int i;
        if (TextUtils.isEmpty(str)) {
            a(str2, new com.baidu.swan.apps.api.c.b(1001, "navigateToBookshelf fail"));
        }
        try {
            i = new JSONObject(str).optInt("status", 1001);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            i = 1001;
        }
        if (i == 0) {
            a(str2, new com.baidu.swan.apps.api.c.b(i, "navigateToBookshelf success"));
        } else {
            a(str2, new com.baidu.swan.apps.api.c.b(i, "navigateToBookshelf fail"));
        }
    }
}
