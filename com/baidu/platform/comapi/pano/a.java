package com.baidu.platform.comapi.pano;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    AsyncHttpClient a = new AsyncHttpClient();

    /* renamed from: com.baidu.platform.comapi.pano.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0219a<T> {
        void a(HttpClient.HttpStateError httpStateError);

        void a(T t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c a(String str) {
        if (str == null || str.equals("")) {
            return new c(PanoStateError.PANO_NOT_FOUND);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject == null) {
                return new c(PanoStateError.PANO_NOT_FOUND);
            }
            if (optJSONObject.optInt(BdStatsConstant.StatsType.ERROR) == 0) {
                JSONArray optJSONArray = jSONObject.optJSONArray("content");
                if (optJSONArray == null) {
                    return new c(PanoStateError.PANO_NOT_FOUND);
                }
                c cVar = null;
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i).optJSONObject("poiinfo");
                    if (optJSONObject2 != null) {
                        cVar = new c(PanoStateError.PANO_NO_ERROR);
                        cVar.a(optJSONObject2.optString("PID"));
                        cVar.a(optJSONObject2.optInt("hasstreet"));
                    }
                }
                return cVar;
            }
            return new c(PanoStateError.PANO_UID_ERROR);
        } catch (JSONException e) {
            e.printStackTrace();
            return new c(PanoStateError.PANO_NOT_FOUND);
        }
    }

    private String a(Uri.Builder builder) {
        Uri.Builder buildUpon = Uri.parse(builder.build().toString() + HttpClient.getPhoneInfo()).buildUpon();
        buildUpon.appendQueryParameter("sign", AppMD5.getSignMD5String(buildUpon.build().getEncodedQuery()));
        return buildUpon.build().toString();
    }

    private void a(Uri.Builder builder, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    public void a(String str, InterfaceC0219a<c> interfaceC0219a) {
        Uri.Builder builder = new Uri.Builder();
        if (HttpClient.isHttpsEnable) {
            builder.scheme("https");
        } else {
            builder.scheme(HttpHost.DEFAULT_SCHEME_NAME);
        }
        builder.encodedAuthority("api.map.baidu.com");
        builder.path("/sdkproxy/lbs_androidsdk/pano/v1/");
        a(builder, "qt", "poi");
        a(builder, "uid", str);
        a(builder, "action", "0");
        String authToken = HttpClient.getAuthToken();
        if (authToken == null) {
            interfaceC0219a.a((InterfaceC0219a<c>) new c(PanoStateError.PANO_NO_TOKEN));
            return;
        }
        a(builder, "token", authToken);
        this.a.get(a(builder), new b(this, interfaceC0219a));
    }
}
