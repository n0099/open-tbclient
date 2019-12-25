package com.baidu.swan.apps.adaptation.implementation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
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
/* loaded from: classes9.dex */
public class i implements ac {
    private static final String TAG = i.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int aWo = 0;
    private static int aWp = 1;

    @Override // com.baidu.swan.apps.adaptation.a.ac
    public void a(@NonNull String str, @NonNull String str2, @NonNull final a.InterfaceC0257a interfaceC0257a) {
        HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(EV()).addUrlParam("appkey", str).addUrlParam("template_id", str2).build().executeAsyncOnUIBack(new a(new com.baidu.swan.apps.ai.a() { // from class: com.baidu.swan.apps.adaptation.implementation.i.1
            @Override // com.baidu.swan.apps.ai.a
            public void K(JSONObject jSONObject) {
                String str3;
                if (jSONObject == null) {
                    str3 = null;
                } else if (jSONObject.optInt("errno") == 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        interfaceC0257a.av(optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_TIP), optJSONObject.optString("template_title"));
                        return;
                    }
                    str3 = null;
                } else {
                    str3 = jSONObject.optString("tipmsg");
                }
                interfaceC0257a.av(str3, null);
            }

            @Override // com.baidu.swan.apps.ai.a
            public void onFail(String str3) {
                interfaceC0257a.av(str3, null);
            }
        }));
    }

    @Override // com.baidu.swan.apps.adaptation.a.ac
    public void a(@NonNull String str, @Nullable String str2, @Nullable String str3, com.baidu.swan.apps.o.b bVar) {
        String dD = dD(aWo);
        PostFormRequest.PostFormRequestBuilder addParam = ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(dD)).cookieManager(com.baidu.swan.apps.w.a.RI().FH())).addParam("appkey", str);
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
        a(dD(aWp), str, aVar);
    }

    private String dD(int i) {
        long seconds;
        StringBuilder sb;
        String str;
        String str2;
        String str3 = "timestamp=" + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        if (i == aWo) {
            sb = new StringBuilder(ET());
            str = "rasign=" + com.baidu.swan.apps.h.b.Io().V(seconds);
            str2 = "delta=smartapp_formid";
        } else {
            sb = new StringBuilder(EU());
            str = "rasign=" + com.baidu.swan.apps.h.b.Io().W(seconds);
            str2 = "delta=payid";
        }
        sb.append("?");
        sb.append(str3).append(ETAG.ITEM_SEPARATOR);
        sb.append(str).append(ETAG.ITEM_SEPARATOR);
        sb.append(str2);
        return com.baidu.swan.apps.h.c.processCommonParams(sb.toString());
    }

    private void a(String str, String str2, com.baidu.swan.apps.ai.a aVar) {
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(str)).cookieManager(com.baidu.swan.apps.w.a.RI().FH())).addParam("appkey", str2).build().executeAsyncOnUIBack(new a(aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a extends ResponseCallback<JSONObject> {
        @Nullable
        private final com.baidu.swan.apps.ai.a aWs;

        a(@Nullable com.baidu.swan.apps.ai.a aVar) {
            this.aWs = aVar;
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
            if (this.aWs != null) {
                if (jSONObject == null) {
                    this.aWs.onFail("request fail");
                } else {
                    this.aWs.K(jSONObject);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (i.DEBUG) {
                Log.e(i.TAG, "SimpleResponseCallback", exc);
            }
            if (this.aWs != null) {
                this.aWs.onFail(exc.toString());
            }
        }
    }

    public static String ET() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/formid/new", com.baidu.swan.apps.h.c.beA));
    }

    public static String EU() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/payid/new", com.baidu.swan.apps.h.c.beA));
    }

    public static String EV() {
        return com.baidu.swan.apps.h.c.processCommonParams(String.format("%s/ma/formid/msgtpl", com.baidu.swan.apps.h.c.beA));
    }
}
