package com.baidu.searchbox.ng.ai.apps.event.message;

import android.net.Uri;
import com.baidu.searchbox.ng.ai.apps.event.JSEventDispatcher;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppsWebMessage<T> extends AiAppsBaseMessage {
    private static final boolean DEBUG = false;
    private static final String EVENT_NAME = "message";
    private static final String MESSAGE_DATA_KEY = "message";
    private static final String TAG = "AiAppsWebMessage";
    public T mData;
    public boolean mNeedEncode = true;

    public AiAppsWebMessage() {
        this.mEventName = "message";
    }

    @Override // com.baidu.searchbox.ng.ai.apps.event.message.AiAppsBaseMessage
    public String genSetDataStatement(String str) {
        if (this.mData instanceof String) {
            return JSEventDispatcher.genJSVarKeyValue(str, "message", this.mNeedEncode ? Uri.encode((String) this.mData) : (String) this.mData);
        } else if (!(this.mData instanceof JSONObject)) {
            return "";
        } else {
            return JSEventDispatcher.genJSVarKeyValue(str, "message", (JSONObject) this.mData);
        }
    }
}
