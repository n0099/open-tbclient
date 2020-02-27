package com.baidu.swan.config.core;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import java.io.IOException;
import java.util.Iterator;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class a extends ResponseCallback<JSONObject> {
    protected abstract void aR(long j);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.ResponseCallback
    /* renamed from: a */
    public JSONObject parseResponse(Response response, int i) throws IOException {
        if (response != null && response.body() != null) {
            String string = response.body().string();
            if (!TextUtils.isEmpty(string)) {
                try {
                    return new JSONObject(string);
                } catch (JSONException e) {
                    if (com.baidu.swan.config.e.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.ResponseCallback
    /* renamed from: b */
    public void onSuccess(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            if (com.baidu.swan.config.e.DEBUG) {
                Log.e("AbsGetConfigResponse", "pares response return null");
                return;
            }
            return;
        }
        int optInt = jSONObject.optInt("errno");
        if (optInt != 0) {
            if (com.baidu.swan.config.e.DEBUG) {
                Log.e("AbsGetConfigResponse", "pares response date errCode = " + optInt);
                return;
            }
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            if (com.baidu.swan.config.e.DEBUG) {
                Log.e("AbsGetConfigResponse", "pares response date == null, response = " + jSONObject.toString());
                return;
            }
            return;
        }
        if (com.baidu.swan.config.e.DEBUG) {
            Log.i("AbsGetConfigResponse", "config response: " + optJSONObject.toString());
        }
        int optInt2 = optJSONObject.optInt("max_age", 0);
        optJSONObject.remove("max_age");
        bh(optJSONObject);
        aR(optInt2);
    }

    @Override // com.baidu.searchbox.http.callback.ResponseCallback
    public void onFail(Exception exc) {
        if (com.baidu.swan.config.e.DEBUG) {
            Log.e("AbsGetConfigResponse", "onFail:" + exc.getMessage());
        }
    }

    private void bh(JSONObject jSONObject) {
        com.baidu.swan.config.core.b.c b;
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                ConfigNode nodeByConfigName = ConfigNode.getNodeByConfigName(next);
                if (nodeByConfigName != null && (b = com.baidu.swan.config.core.b.b.b(nodeByConfigName)) != null) {
                    b.bj(jSONObject.optJSONObject(next));
                }
            }
        }
    }
}
