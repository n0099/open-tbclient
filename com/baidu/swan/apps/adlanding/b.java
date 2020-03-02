package com.baidu.swan.apps.adlanding;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.e;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.media.c.a bbG;
    private JSONObject bbH;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, JSONObject jSONObject, com.baidu.swan.apps.media.c.a aVar) {
        this.mContext = context;
        this.bbH = jSONObject;
        this.bbG = aVar;
    }

    private String c(String str, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        if (this.bbG != null) {
            hashMap2.put("cur_time", String.valueOf(this.bbG.getDuration() / 1000));
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

    public void fc(String str) {
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
        JSONArray optJSONArray = this.bbH != null ? this.bbH.optJSONArray(str) : null;
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (SwanAppNetworkUtils.isNetworkConnected(this.mContext) && !TextUtils.isEmpty(optString)) {
                    final String c = c(optString, hashMap);
                    HttpUrl parse = HttpUrl.parse(c);
                    if (parse != null) {
                        Request build = new Request.Builder().url(parse.newBuilder().build()).build();
                        e acG = e.acG();
                        if (acG != null) {
                            acG.acR().a(build, new Callback() { // from class: com.baidu.swan.apps.adlanding.b.1
                                @Override // okhttp3.Callback
                                public void onFailure(Call call, IOException iOException) {
                                    if (b.DEBUG) {
                                        Log.d("AlsSender", "onFailure: " + iOException.getMessage());
                                    }
                                }

                                @Override // okhttp3.Callback
                                public void onResponse(Call call, Response response) {
                                    if (b.DEBUG) {
                                        Log.d("AlsSender", "onResponse: respCode:" + response.code() + ", url:" + c + ", msg:" + response.message());
                                    }
                                }
                            });
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
