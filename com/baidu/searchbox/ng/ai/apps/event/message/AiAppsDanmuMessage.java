package com.baidu.searchbox.ng.ai.apps.event.message;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppsDanmuMessage extends AiAppsCommonMessage {
    public static final String EVENT_DATA_KEY = "data";
    public static final String EVENT_NAME = "video";
    public static final String EVENT_TYPE_KEY = "vtype";
    private static final String KEY_DATA_TEXT = "text";
    public static final String TYPE_DANMU = "danmu";
    public static final String WEBVIEW_ID_KEY = "wvID";

    public AiAppsDanmuMessage(@NonNull String str, @Nullable Map<String, String> map) {
        super(str, map);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.event.message.AiAppsCommonMessage, com.baidu.searchbox.ng.ai.apps.event.message.AiAppsBaseMessage
    public String genSetDataStatement(String str) {
        encodeMessageParams();
        return super.genSetDataStatement(str);
    }

    private void encodeMessageParams() {
        if (this.mParams.containsKey("data") && !TextUtils.isEmpty(this.mParams.get("data"))) {
            try {
                JSONObject jSONObject = new JSONObject(this.mParams.get("data"));
                if (jSONObject.has("text")) {
                    jSONObject.putOpt("text", Uri.encode(jSONObject.optString("text")));
                }
                this.mParams.put("data", jSONObject.toString());
            } catch (JSONException e) {
            }
        }
    }
}
