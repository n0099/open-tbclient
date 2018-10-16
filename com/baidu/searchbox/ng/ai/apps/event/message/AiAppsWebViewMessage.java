package com.baidu.searchbox.ng.ai.apps.event.message;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.event.JSEventDispatcher;
/* loaded from: classes2.dex */
public class AiAppsWebViewMessage extends AiAppsBaseMessage {
    private static final String EVENT_NAME = "webview";
    public static final String EVENT_TYPE_PUSH_MESSAGE = "webviewPushMessage";
    private static final String KEY_DATA = "data";
    private static final String KEY_EVENT_TYPE = "eventType";
    private static final String KEY_SLAVE_ID = "wvID";
    private static final String KEY_WEBVIEW_ID = "webviewId";
    public String data;
    public String eventType;
    public String webViewId;
    public String wvID;

    public AiAppsWebViewMessage() {
        this.mEventName = EVENT_NAME;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.event.message.AiAppsBaseMessage
    public String genSetDataStatement(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(JSEventDispatcher.genJSVarKeyValue(str, "wvID", TextUtils.isEmpty(this.wvID) ? "" : this.wvID));
        sb.append(JSEventDispatcher.genJSVarKeyValue(str, KEY_WEBVIEW_ID, TextUtils.isEmpty(this.webViewId) ? "" : this.webViewId));
        sb.append(JSEventDispatcher.genJSVarKeyValue(str, KEY_EVENT_TYPE, TextUtils.isEmpty(this.eventType) ? "" : this.eventType));
        sb.append(JSEventDispatcher.genJSVarKeyValue(str, "data", TextUtils.isEmpty(this.data) ? "" : this.data));
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private String data;
        private String eventType;
        private String webViewId;
        private String wvID;

        public Builder wvID(String str) {
            this.wvID = str;
            return this;
        }

        public Builder webViewId(String str) {
            this.webViewId = str;
            return this;
        }

        public Builder eventType(String str) {
            this.eventType = str;
            return this;
        }

        public Builder data(String str) {
            this.data = str;
            return this;
        }

        public AiAppsWebViewMessage build() {
            AiAppsWebViewMessage aiAppsWebViewMessage = new AiAppsWebViewMessage();
            aiAppsWebViewMessage.wvID = this.wvID;
            aiAppsWebViewMessage.webViewId = this.webViewId;
            aiAppsWebViewMessage.eventType = this.eventType;
            aiAppsWebViewMessage.data = this.data;
            return aiAppsWebViewMessage;
        }
    }
}
