package com.baidu.swan.bdprivate.extensions.g.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.location.BDLocation;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.t.b.d;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import rx.d;
/* loaded from: classes8.dex */
public abstract class a extends aa {
    @NonNull
    protected abstract String getUrl();

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(j jVar, String str) {
        super(jVar, str);
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("BaseRecommendAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("recommend", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject b2 = b(unitedSchemeEntity, "params");
        if (b2 == null) {
            com.baidu.swan.apps.console.c.e("recommend", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
            return false;
        }
        String optString = b2.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("recommend", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
            return false;
        }
        JSONObject optJSONObject = b2.optJSONObject("data");
        if (optJSONObject == null || optJSONObject.length() <= 0) {
            com.baidu.swan.apps.console.c.e("recommend", "param data is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "param data is empty");
            return false;
        }
        com.baidu.swan.apps.console.c.i("recommend", "start perform request");
        b(context, callbackHandler, optString, optJSONObject);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    private void b(@NonNull final Context context, @NonNull final CallbackHandler callbackHandler, @NonNull final String str, @NonNull JSONObject jSONObject) {
        com.baidu.swan.apps.console.c.i("recommend", "get request params");
        final com.baidu.swan.bdprivate.extensions.g.b.a aVar = new com.baidu.swan.bdprivate.extensions.g.b.a(context, jSONObject);
        d<com.baidu.swan.bdprivate.extensions.g.b.b> ep = ep(context);
        if (ep != null) {
            ep.h(60L, TimeUnit.MILLISECONDS).a(new rx.functions.b<com.baidu.swan.bdprivate.extensions.g.b.b>() { // from class: com.baidu.swan.bdprivate.extensions.g.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                /* renamed from: a */
                public void call(com.baidu.swan.bdprivate.extensions.g.b.b bVar) {
                    com.baidu.swan.bdprivate.extensions.g.c.a.a(aVar, bVar);
                    a.this.a(context, callbackHandler, str, aVar);
                }
            }, new rx.functions.b<Throwable>() { // from class: com.baidu.swan.bdprivate.extensions.g.a.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(Throwable th) {
                    com.baidu.swan.apps.console.c.w("recommend", "get param(l) info fail: " + th.getMessage());
                    a.this.a(context, callbackHandler, str, aVar);
                }
            });
            return;
        }
        com.baidu.swan.apps.console.c.w("recommend", "get param(l) is null");
        a(context, callbackHandler, str, aVar);
    }

    private d<com.baidu.swan.bdprivate.extensions.g.b.b> ep(Context context) {
        if (context == null) {
            return null;
        }
        if (!com.baidu.swan.apps.ao.c.hasMarshMallow() || (context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 && context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)) {
            return d.a((d.a) new d.a<com.baidu.swan.bdprivate.extensions.g.b.b>() { // from class: com.baidu.swan.bdprivate.extensions.g.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(final rx.j<? super com.baidu.swan.bdprivate.extensions.g.b.b> jVar) {
                    com.baidu.swan.apps.t.a.awQ().a(BDLocation.BDLOCATION_GCJ02_TO_BD09, true, false, new d.a() { // from class: com.baidu.swan.bdprivate.extensions.g.a.a.3.1
                        @Override // com.baidu.swan.apps.t.b.d.a
                        public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                            com.baidu.swan.bdprivate.extensions.g.b.b bVar2 = new com.baidu.swan.bdprivate.extensions.g.b.b();
                            if (bVar != null && !TextUtils.isEmpty(bVar.coorType)) {
                                bVar2.dTe = bVar.coorType;
                                bVar2.latitude = bVar.latitude;
                                bVar2.longitude = bVar.longitude;
                            } else {
                                bVar2.dTe = "unknown";
                            }
                            jVar.onNext(bVar2);
                            jVar.onCompleted();
                        }

                        @Override // com.baidu.swan.apps.t.b.d.a
                        public void onFailed(int i) {
                            jVar.onError(new Throwable());
                        }
                    });
                }
            });
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull com.baidu.swan.bdprivate.extensions.g.b.a aVar) {
        com.baidu.swan.apps.console.c.i("recommend", "start real perform request");
        String processCommonParams = com.baidu.swan.apps.i.c.processCommonParams(getUrl());
        com.baidu.swan.apps.ao.e.b<JSONObject> d = d(callbackHandler, str);
        ResponseCallback<JSONObject> G = G(d);
        MediaType parse = MediaType.parse(HttpHelper.CONTENT_JSON);
        com.baidu.swan.apps.console.c.i("recommend", "encrypt request param");
        String up = com.baidu.swan.bdprivate.extensions.g.c.a.up(aVar.toJsonString());
        if (TextUtils.isEmpty(up)) {
            com.baidu.swan.apps.console.c.e("recommend", "encrypt request param fail");
            d.L(null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("info", "encrypt request param fail");
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.bdprivate.extensions.g.c.a.uq(jSONObject.toString());
            return;
        }
        com.baidu.swan.apps.console.c.i("recommend", "execute request");
        ((PostBodyRequest.PostBodyRequestBuilder) HttpManager.getDefault(context.getApplicationContext()).postRequest().url(processCommonParams)).requestBody(RequestBody.create(parse, up)).build().executeAsync(G);
    }

    @NonNull
    private com.baidu.swan.apps.ao.e.b<JSONObject> d(@NonNull final CallbackHandler callbackHandler, @NonNull final String str) {
        return new com.baidu.swan.apps.ao.e.b<JSONObject>() { // from class: com.baidu.swan.bdprivate.extensions.g.a.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: onCallback */
            public void L(JSONObject jSONObject) {
                if (jSONObject == null) {
                    com.baidu.swan.apps.console.c.e("recommend", "response is null");
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "response is null").toString());
                    return;
                }
                com.baidu.swan.apps.console.c.i("recommend", "recommend action execute success");
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            }
        };
    }

    @NonNull
    private ResponseCallback<JSONObject> G(@NonNull final com.baidu.swan.apps.ao.e.b<JSONObject> bVar) {
        return new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.bdprivate.extensions.g.a.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public JSONObject parseResponse(Response response, int i) throws Exception {
                com.baidu.swan.apps.console.c.i("recommend", "parse response");
                if (response != null && response.body() != null) {
                    String string = response.body().string();
                    if (TextUtils.isEmpty(string)) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("info", "parse response fail");
                            jSONObject.put("response code", response.code());
                            jSONObject.put("response body", string == null ? "null" : SchemeCollecter.CLASSIFY_EMPTY);
                        } catch (JSONException e) {
                            if (a.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                        com.baidu.swan.bdprivate.extensions.g.c.a.uq(jSONObject.toString());
                        return null;
                    }
                    return new JSONObject(string);
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("info", "parse response fail");
                    if (response == null) {
                        jSONObject2.put(IIntercepter.TYPE_RESPONSE, "null");
                    } else {
                        jSONObject2.put("response code", response.code());
                        if (response.body() == null) {
                            jSONObject2.put("response body", "null");
                        } else {
                            jSONObject2.put(IIntercepter.TYPE_RESPONSE, "unknown");
                        }
                    }
                } catch (JSONException e2) {
                    if (a.DEBUG) {
                        e2.printStackTrace();
                    }
                }
                com.baidu.swan.bdprivate.extensions.g.c.a.uq(jSONObject2.toString());
                return null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public void onSuccess(JSONObject jSONObject, int i) {
                if (jSONObject == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("info", "on success but jsonObject is null");
                        jSONObject2.put("statusCode", i);
                    } catch (JSONException e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    com.baidu.swan.bdprivate.extensions.g.c.a.uq(jSONObject2.toString());
                }
                bVar.L(jSONObject);
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                com.baidu.swan.apps.console.c.e("recommend", "http response with exception:", exc);
                bVar.L(null);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("info", "http request fail with exception : " + exc.getMessage());
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
                com.baidu.swan.bdprivate.extensions.g.c.a.uq(jSONObject.toString());
            }
        };
    }
}
