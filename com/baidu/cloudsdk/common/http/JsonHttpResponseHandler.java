package com.baidu.cloudsdk.common.http;

import android.os.Message;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes.dex */
public class JsonHttpResponseHandler extends HttpResponseHandler {
    protected static final int SUCCESS_JSON_MESSAGE = 100;

    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
    protected void handleFailureMessage(Throwable th, String str) {
        try {
            if (str != null) {
                Object parseResponse = parseResponse(str);
                if (parseResponse instanceof JSONObject) {
                    onFailure(th, (JSONObject) parseResponse);
                } else if (parseResponse instanceof JSONArray) {
                    onFailure(th, (JSONArray) parseResponse);
                } else {
                    onFailure(th, str);
                }
            } else {
                onFailure(th, "");
            }
        } catch (JSONException e) {
            onFailure(th, str);
        }
    }

    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler, android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 100:
                Object[] objArr = (Object[]) message.obj;
                handleSuccessJsonMessage(((Integer) objArr[0]).intValue(), objArr[1]);
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }

    protected void handleSuccessJsonMessage(int i, Object obj) {
        if (obj instanceof JSONObject) {
            onSuccess(i, (JSONObject) obj);
        } else if (obj instanceof JSONArray) {
            onSuccess(i, (JSONArray) obj);
        } else {
            onFailure(new JSONException("Unexpected type " + obj.getClass().getName()), "");
        }
    }

    protected void onFailure(Throwable th, JSONArray jSONArray) {
    }

    protected void onFailure(Throwable th, JSONObject jSONObject) {
    }

    protected void onSuccess(int i, JSONArray jSONArray) {
        onSuccess(jSONArray);
    }

    protected void onSuccess(int i, JSONObject jSONObject) {
        onSuccess(jSONObject);
    }

    protected void onSuccess(JSONArray jSONArray) {
    }

    protected void onSuccess(JSONObject jSONObject) {
    }

    protected Object parseResponse(String str) {
        Object obj = null;
        String trim = str.trim();
        if (trim.startsWith("{") || trim.startsWith("[")) {
            obj = new JSONTokener(trim).nextValue();
        }
        return obj == null ? trim : obj;
    }

    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
    protected void sendSuccessMessage(int i, String str) {
        if (i == 204) {
            sendMessage(obtainMessage(100, new Object[]{Integer.valueOf(i), new JSONObject()}));
            return;
        }
        try {
            sendMessage(obtainMessage(100, new Object[]{Integer.valueOf(i), parseResponse(str)}));
        } catch (JSONException e) {
            sendFailureMessage(e, str);
        }
    }
}
