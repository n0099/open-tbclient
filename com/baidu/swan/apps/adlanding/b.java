package com.baidu.swan.apps.adlanding;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.media.b.a bTc;
    private JSONObject bTd;
    private Context mContext;

    public b(Context context, JSONObject jSONObject) {
        this.mContext = context;
        this.bTd = jSONObject;
    }

    public b(Context context, JSONObject jSONObject, com.baidu.swan.apps.media.b.a aVar) {
        this.mContext = context;
        this.bTd = jSONObject;
        this.bTc = aVar;
    }

    private String c(String str, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        if (this.bTc != null) {
            hashMap2.put("cur_time", String.valueOf(this.bTc.getDuration() / 1000));
        }
        hashMap2.put("origin_time", String.valueOf(System.currentTimeMillis()));
        hashMap.putAll(hashMap2);
        try {
            str = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        } catch (IllegalArgumentException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        for (String str2 : hashMap.keySet()) {
            str = str.replaceAll("%%" + str2 + "%%", hashMap.get(str2));
        }
        return str;
    }

    public void iK(String str) {
        d(str, new HashMap<>());
    }

    public void d(String str, HashMap<String, String> hashMap) {
        if (TextUtils.equals(str, "da_area")) {
            hashMap.put("da_page", "VIDEODETAIL_TAIL");
        } else if (TextUtils.equals(str, "lpin") || TextUtils.equals(str, "lpout")) {
            hashMap.put("da_page", "MINIAPP");
        } else {
            hashMap.put("da_page", "VIDEOADDETAI");
        }
        hashMap.put("play_mode", String.valueOf((SwanAppNetworkUtils.isWifiNetworkConnected(this.mContext) && TextUtils.equals(str, "vstart")) ? 0 : 1));
        JSONArray optJSONArray = this.bTd != null ? this.bTd.optJSONArray(str) : null;
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (SwanAppNetworkUtils.isNetworkConnected(this.mContext) && !TextUtils.isEmpty(optString)) {
                    HttpUrl parse = HttpUrl.parse(c(optString, hashMap));
                    if (parse != null) {
                        a(new Request.Builder().url(parse.newBuilder().build()).build());
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void a(@NonNull final Request request) {
        if (com.baidu.swan.apps.runtime.e.azJ() != null) {
            com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a(request.url().toString(), new ResponseCallback() { // from class: com.baidu.swan.apps.adlanding.b.1
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public Object parseResponse(Response response, int i) throws Exception {
                    if (b.DEBUG) {
                        Log.d("AlsSender", "onResponse: respCode:" + response.code() + ", url:" + request.url().toString() + ", msg:" + response.message());
                    }
                    return response;
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(Object obj, int i) {
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    if (b.DEBUG) {
                        Log.d("AlsSender", "onFailure: " + exc.getMessage());
                    }
                }
            });
            aVar.dEO = true;
            aVar.dEP = false;
            aVar.dEQ = false;
            com.baidu.swan.a.c.a.aSW().a(aVar);
        }
    }
}
