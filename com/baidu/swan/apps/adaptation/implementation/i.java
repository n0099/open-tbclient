package com.baidu.swan.apps.adaptation.implementation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.swan.apps.adaptation.a.ac;
import com.baidu.swan.apps.o.a;
import com.baidu.webkit.internal.ETAG;
import java.util.concurrent.TimeUnit;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class i implements ac {
    private static final String TAG = i.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int bzU = 0;
    private static int bzV = 1;

    @Override // com.baidu.swan.apps.adaptation.a.ac
    public void a(@NonNull String str, @NonNull String str2, @NonNull final a.InterfaceC0299a interfaceC0299a) {
        HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(Py()).addUrlParam("appkey", str).addUrlParam("template_id", str2).build().executeAsyncOnUIBack(new a(new com.baidu.swan.apps.ai.a() { // from class: com.baidu.swan.apps.adaptation.implementation.i.1
            @Override // com.baidu.swan.apps.ai.a
            public void V(JSONObject jSONObject) {
                String str3;
                if (jSONObject == null) {
                    str3 = null;
                } else if (jSONObject.optInt(BaseJsonData.TAG_ERRNO) == 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        interfaceC0299a.aO(optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_TIP), optJSONObject.optString("template_title"));
                        return;
                    }
                    str3 = null;
                } else {
                    str3 = jSONObject.optString("tipmsg");
                }
                interfaceC0299a.aO(str3, null);
            }

            @Override // com.baidu.swan.apps.ai.a
            public void onFail(String str3) {
                interfaceC0299a.aO(str3, null);
            }
        }));
    }

    @Override // com.baidu.swan.apps.adaptation.a.ac
    public void a(@NonNull String str, @Nullable String str2, @Nullable String str3, com.baidu.swan.apps.o.b bVar) {
        String dZ = dZ(bzU);
        PostFormRequest.PostFormRequestBuilder addParam = ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(dZ)).cookieManager(com.baidu.swan.apps.w.a.acm().Qj())).addParam("appkey", str);
        if (str2 != null) {
            addParam.addParam("template_id", str2);
        }
        if (str3 != null) {
            addParam.addParam("uniq_id", str3);
        }
        addParam.build().executeAsyncOnUIBack(new a(bVar));
    }

    @Override // com.baidu.swan.apps.adaptation.a.ac
    public void a(String str, com.baidu.swan.apps.ae.a.a aVar) {
        a(dZ(bzV), str, aVar);
    }

    private String dZ(int i) {
        long seconds;
        StringBuilder sb;
        String str;
        String str2;
        String str3 = "timestamp=" + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        if (i == bzU) {
            sb = new StringBuilder(Pw());
            str = "rasign=" + com.baidu.swan.apps.h.b.SS().aG(seconds);
            str2 = "delta=smartapp_formid";
        } else {
            sb = new StringBuilder(Px());
            str = "rasign=" + com.baidu.swan.apps.h.b.SS().aH(seconds);
            str2 = "delta=payid";
        }
        sb.append("?");
        sb.append(str3).append(ETAG.ITEM_SEPARATOR);
        sb.append(str).append(ETAG.ITEM_SEPARATOR);
        sb.append(str2);
        return com.baidu.swan.apps.h.c.processCommonParams(sb.toString());
    }

    private void a(String str, String str2, com.baidu.swan.apps.ai.a aVar) {
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(str)).cookieManager(com.baidu.swan.apps.w.a.acm().Qj())).addParam("appkey", str2).build().executeAsyncOnUIBack(new a(aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a extends ResponseCallback<JSONObject> {
        @Nullable
        private final com.baidu.swan.apps.ai.a bzY;

        a(@Nullable com.baidu.swan.apps.ai.a aVar) {
            this.bzY = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public JSONObject parseResponse(Response response, int i) throws Exception {
            if (response != null && response.body() != null) {
                String string = response.body().string();
                if (i.DEBUG) {
                    Log.d(i.TAG, "statusCode:" + i + ", response=" + string);
                }
                if (!TextUtils.isEmpty(string)) {
                    return new JSONObject(string);
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public void onSuccess(JSONObject jSONObject, int i) {
            if (this.bzY != null) {
                if (jSONObject == null) {
                    this.bzY.onFail("request fail");
                } else {
                    this.bzY.V(jSONObject);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (i.DEBUG) {
                Log.e(i.TAG, "SimpleResponseCallback", exc);
            }
            if (this.bzY != null) {
                this.bzY.onFail(exc.toString());
            }
        }
    }

    public static String Pw() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/formid/new", com.baidu.swan.apps.h.c.bIa));
    }

    public static String Px() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/payid/new", com.baidu.swan.apps.h.c.bIa));
    }

    public static String Py() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/formid/msgtpl", com.baidu.swan.apps.h.c.bIa));
    }
}
