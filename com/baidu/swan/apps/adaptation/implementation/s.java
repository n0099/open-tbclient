package com.baidu.swan.apps.adaptation.implementation;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.swan.apps.adaptation.a.aj;
import com.baidu.swan.apps.n.a;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class s implements aj {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int ctL = 0;
    private static int ctM = 1;
    private static int ctN = 2;

    @Override // com.baidu.swan.apps.adaptation.a.aj
    public void a(@NonNull String str, @NonNull Set<String> set, @NonNull final a.InterfaceC0453a interfaceC0453a) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_key", str);
            JSONArray jSONArray = new JSONArray();
            if (set != null && set.size() > 0) {
                for (String str2 : set) {
                    jSONArray.put(str2);
                }
            }
            jSONObject.put("template_ids", jSONArray);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        SwanAppNetworkUtils.a(agZ(), jSONObject.toString(), new a(new com.baidu.swan.apps.ae.a() { // from class: com.baidu.swan.apps.adaptation.implementation.s.1
            @Override // com.baidu.swan.apps.ae.a
            public void ay(JSONObject jSONObject2) {
                String str3;
                if (jSONObject2 == null) {
                    str3 = null;
                } else if (jSONObject2.optInt(BaseJsonData.TAG_ERRNO) == 0) {
                    JSONObject optJSONObject = jSONObject2.optJSONObject("data");
                    if (optJSONObject != null) {
                        interfaceC0453a.a(optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_TIP), s.this.q(optJSONObject.optJSONArray("list")), false);
                        return;
                    }
                    str3 = null;
                } else {
                    str3 = jSONObject2.optString("tipmsg");
                }
                interfaceC0453a.a(str3, null, false);
            }

            @Override // com.baidu.swan.apps.ae.a
            public void onFail(String str3) {
                interfaceC0453a.a(str3, null, false);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.swan.apps.n.d> q(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("template_id");
                String optString2 = optJSONObject.optString("template_title");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    arrayList.add(new com.baidu.swan.apps.n.d(optString, optString2));
                }
            }
        }
        return arrayList;
    }

    @Override // com.baidu.swan.apps.adaptation.a.aj
    public void a(@NonNull String str, com.baidu.swan.apps.n.b bVar) {
        String hp = hp(ctL);
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) com.baidu.swan.a.c.a.bad().postFormRequest().url(hp)).cookieManager(com.baidu.swan.apps.t.a.awr().ahB())).addParam("appkey", str).build().executeAsyncOnUIBack(new a(bVar));
    }

    @Override // com.baidu.swan.apps.adaptation.a.aj
    public void a(@NonNull String str, @NonNull List<String> list, @Nullable String str2, boolean z, com.baidu.swan.apps.n.b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_key", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("sub_id", str2);
            if (z) {
                jSONObject2.put("template_id", list.get(0));
            } else {
                JSONArray jSONArray = new JSONArray();
                for (String str3 : list) {
                    jSONArray.put(str3);
                }
                jSONObject2.put("template_ids", jSONArray);
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            jSONObject.put("detail", jSONArray2);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        SwanAppNetworkUtils.a(hp(ctN), jSONObject.toString(), new a(bVar));
    }

    @Override // com.baidu.swan.apps.adaptation.a.aj
    public String agV() {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        Uri.Builder buildUpon = Uri.parse(aha()).buildUpon();
        buildUpon.appendQueryParameter("timestamp", String.valueOf(seconds)).appendQueryParameter("rasign", com.baidu.swan.apps.i.b.akB().bu(seconds)).appendQueryParameter("delta", "smartapp_formid");
        return buildUpon.toString();
    }

    @Override // com.baidu.swan.apps.adaptation.a.aj
    public void a(String str, com.baidu.swan.apps.aa.a.a aVar) {
        a(hp(ctM), str, aVar);
    }

    private String hp(int i) {
        long seconds;
        StringBuilder sb;
        String str;
        String str2;
        String str3 = "timestamp=" + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        if (i == ctL) {
            sb = new StringBuilder(agW());
            str = "rasign=" + com.baidu.swan.apps.i.b.akB().bu(seconds);
            str2 = "delta=smartapp_formid";
        } else if (i == ctN) {
            sb = new StringBuilder(agX());
            str = "rasign=" + com.baidu.swan.apps.i.b.akB().bu(seconds);
            str2 = "delta=smartapp_formid";
        } else {
            sb = new StringBuilder(agY());
            str = "rasign=" + com.baidu.swan.apps.i.b.akB().bv(seconds);
            str2 = "delta=payid";
        }
        sb.append(ETAG.ITEM_SEPARATOR);
        sb.append(str3).append(ETAG.ITEM_SEPARATOR);
        sb.append(str).append(ETAG.ITEM_SEPARATOR);
        sb.append(str2);
        return com.baidu.swan.apps.i.c.processCommonParams(sb.toString());
    }

    private void a(String str, String str2, com.baidu.swan.apps.ae.a aVar) {
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) com.baidu.swan.a.c.a.bad().postFormRequest().url(str)).cookieManager(com.baidu.swan.apps.t.a.awr().ahB())).addParam("appkey", str2).build().executeAsyncOnUIBack(new a(aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a extends ResponseCallback<JSONObject> {
        @Nullable
        private final com.baidu.swan.apps.ae.a ctQ;

        a(@Nullable com.baidu.swan.apps.ae.a aVar) {
            this.ctQ = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public JSONObject parseResponse(Response response, int i) throws Exception {
            if (response != null && response.body() != null) {
                String string = response.body().string();
                if (s.DEBUG) {
                    Log.d("SwanAppPushIdImpl", "statusCode:" + i + ", response=" + string);
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
            if (this.ctQ != null) {
                if (jSONObject == null) {
                    this.ctQ.onFail("request fail");
                } else {
                    this.ctQ.ay(jSONObject);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (s.DEBUG) {
                Log.e("SwanAppPushIdImpl", "SimpleResponseCallback", exc);
            }
            if (this.ctQ != null) {
                this.ctQ.onFail(exc.toString());
            }
        }
    }

    public static String agW() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/formid/new", "https://mbd.baidu.com"));
    }

    public static String agX() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/component/sub/create", "https://mbd.baidu.com"));
    }

    public static String agY() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/payid/new", "https://mbd.baidu.com"));
    }

    public static String agZ() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/component/msgtpl", "https://mbd.baidu.com"));
    }

    public static String aha() {
        return com.baidu.swan.apps.i.c.processCommonParams(String.format("%s/ma/formid/multi_action", "https://mbd.baidu.com"));
    }
}
