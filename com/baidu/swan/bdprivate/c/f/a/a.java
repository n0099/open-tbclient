package com.baidu.swan.bdprivate.c.f.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
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
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.w.b.f;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import rx.d;
/* loaded from: classes11.dex */
public abstract class a extends ab {
    @NonNull
    protected abstract String getUrl();

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(j jVar, String str) {
        super(jVar, str);
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("BaseRecommendAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("recommend", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            com.baidu.swan.apps.console.c.e("recommend", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
            return false;
        }
        String optString = b.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("recommend", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
            return false;
        }
        JSONObject optJSONObject = b.optJSONObject("data");
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
        final com.baidu.swan.bdprivate.c.f.b.a aVar = new com.baidu.swan.bdprivate.c.f.b.a(context, jSONObject);
        d<com.baidu.swan.bdprivate.c.f.b.b> cY = cY(context);
        if (cY != null) {
            cY.c(60L, TimeUnit.MILLISECONDS).a(new rx.functions.b<com.baidu.swan.bdprivate.c.f.b.b>() { // from class: com.baidu.swan.bdprivate.c.f.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                /* renamed from: a */
                public void call(com.baidu.swan.bdprivate.c.f.b.b bVar) {
                    com.baidu.swan.bdprivate.c.f.c.a.a(aVar, bVar);
                    a.this.a(context, callbackHandler, str, aVar);
                }
            }, new rx.functions.b<Throwable>() { // from class: com.baidu.swan.bdprivate.c.f.a.a.2
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

    private d<com.baidu.swan.bdprivate.c.f.b.b> cY(Context context) {
        if (context == null) {
            return null;
        }
        if (!com.baidu.swan.apps.as.a.hasMarshMallow() || (context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 && context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)) {
            return d.a((d.a) new d.a<com.baidu.swan.bdprivate.c.f.b.b>() { // from class: com.baidu.swan.bdprivate.c.f.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(final rx.j<? super com.baidu.swan.bdprivate.c.f.b.b> jVar) {
                    com.baidu.swan.apps.w.a.ach().a(BDLocation.BDLOCATION_GCJ02_TO_BD09, true, false, new f.a() { // from class: com.baidu.swan.bdprivate.c.f.a.a.3.1
                        @Override // com.baidu.swan.apps.w.b.f.a
                        public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                            com.baidu.swan.bdprivate.c.f.b.b bVar2 = new com.baidu.swan.bdprivate.c.f.b.b();
                            if (bVar != null && !TextUtils.isEmpty(bVar.coorType)) {
                                bVar2.cCI = bVar.coorType;
                                bVar2.latitude = bVar.latitude;
                                bVar2.longitude = bVar.longitude;
                            } else {
                                bVar2.cCI = "unknown";
                            }
                            jVar.onNext(bVar2);
                            jVar.onCompleted();
                        }

                        @Override // com.baidu.swan.apps.w.b.f.a
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
    public void a(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull com.baidu.swan.bdprivate.c.f.b.a aVar) {
        com.baidu.swan.apps.console.c.i("recommend", "start real perform request");
        String processCommonParams = com.baidu.swan.apps.h.c.processCommonParams(getUrl());
        com.baidu.swan.apps.as.d.b<JSONObject> e = e(callbackHandler, str);
        ResponseCallback<JSONObject> n = n(e);
        MediaType parse = MediaType.parse("application/json");
        com.baidu.swan.apps.console.c.i("recommend", "encrypt request param");
        String oy = com.baidu.swan.bdprivate.c.f.c.a.oy(aVar.toJsonString());
        if (TextUtils.isEmpty(oy)) {
            com.baidu.swan.apps.console.c.e("recommend", "encrypt request param fail");
            e.E(null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("info", "encrypt request param fail");
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            com.baidu.swan.bdprivate.c.f.c.a.oz(jSONObject.toString());
            return;
        }
        com.baidu.swan.apps.console.c.i("recommend", "execute request");
        ((PostBodyRequest.PostBodyRequestBuilder) HttpManager.getDefault(context.getApplicationContext()).postRequest().url(processCommonParams)).requestBody(RequestBody.create(parse, oy)).build().executeAsync(n);
    }

    @NonNull
    private com.baidu.swan.apps.as.d.b<JSONObject> e(@NonNull final CallbackHandler callbackHandler, @NonNull final String str) {
        return new com.baidu.swan.apps.as.d.b<JSONObject>() { // from class: com.baidu.swan.bdprivate.c.f.a.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: onCallback */
            public void E(JSONObject jSONObject) {
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
    private ResponseCallback<JSONObject> n(@NonNull final com.baidu.swan.apps.as.d.b<JSONObject> bVar) {
        return new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.bdprivate.c.f.a.a.5
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
                        com.baidu.swan.bdprivate.c.f.c.a.oz(jSONObject.toString());
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
                com.baidu.swan.bdprivate.c.f.c.a.oz(jSONObject2.toString());
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
                    com.baidu.swan.bdprivate.c.f.c.a.oz(jSONObject2.toString());
                }
                bVar.E(jSONObject);
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                com.baidu.swan.apps.console.c.e("recommend", "http response with exception:", exc);
                bVar.E(null);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("info", "http request fail with exception : " + exc.getMessage());
                } catch (JSONException e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
                com.baidu.swan.bdprivate.c.f.c.a.oz(jSONObject.toString());
            }
        };
    }
}
