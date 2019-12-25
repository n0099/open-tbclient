package com.baidu.searchbox.datachannel;

import android.content.BroadcastReceiver;
import android.content.Intent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class BaseBroadcastReceiver extends BroadcastReceiver {
    public String mAction;
    public String mHost;
    public String mPage;

    public abstract void release();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" ## ");
        sb.append("host:" + this.mHost);
        sb.append(" ## ");
        sb.append("page:" + this.mPage);
        sb.append(" ## ");
        sb.append("action:" + this.mAction);
        return sb.toString();
    }

    protected String parseIntentToJson(Intent intent) {
        String action = intent.getAction();
        String stringExtra = intent.getStringExtra("data");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", action);
            if (stringExtra != null) {
                jSONObject.put("data", stringExtra);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
