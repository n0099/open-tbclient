package com.baidu.searchbox.ng.ai.apps.statistic;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils;
import com.baidu.ubc.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppBusinessUbc {
    private static final String EXT_APP_ID_KEY = "appid";
    private static final String EXT_APP_INFO_KEY = "info";
    private static final String UBC_AI_APP_BUSINESS_ID = "777";
    private static final String UBC_SWAN_VALUE = "swan";

    private AiAppBusinessUbc() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void report(Builder builder) {
        if (builder != null) {
            final JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(builder.from)) {
                    jSONObject.put("from", builder.from);
                }
                if (!TextUtils.isEmpty(builder.type)) {
                    jSONObject.put("type", builder.type);
                }
                if (!TextUtils.isEmpty(builder.value)) {
                    jSONObject.put("value", builder.value);
                }
                if (!TextUtils.isEmpty(builder.source)) {
                    jSONObject.put("source", builder.source);
                }
                if (!TextUtils.isEmpty(builder.page)) {
                    jSONObject.put(SystemScreenshotManager.PAGE, builder.page);
                }
                boolean isEmpty = TextUtils.isEmpty(builder.appId);
                boolean isEmpty2 = TextUtils.isEmpty(builder.errorInfo);
                if (!isEmpty || !isEmpty2) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!isEmpty) {
                        jSONObject2.put("appid", builder.appId);
                    }
                    if (!isEmpty2) {
                        jSONObject2.put("info", builder.errorInfo);
                    }
                    jSONObject.put("ext", jSONObject2);
                }
                AiAppExecutorUtils.postOnIO(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.statistic.AiAppBusinessUbc.1
                    @Override // java.lang.Runnable
                    public void run() {
                        o.i(AiAppBusinessUbc.UBC_AI_APP_BUSINESS_ID, jSONObject);
                    }
                }, "AiAppsBusinessUbcRunnable");
            } catch (JSONException e) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private String appId;
        private String errorInfo;
        private String page;
        private String source;
        private String type;
        private String value;
        private AiAppBusinessUbc mAiAppBusinessUbc = new AiAppBusinessUbc();
        private String from = "swan";

        public Builder(int i) {
            this.type = String.valueOf(i);
        }

        public Builder buildSource(String str) {
            this.source = str;
            return this;
        }

        public Builder buildType(int i) {
            this.type = String.valueOf(i);
            return this;
        }

        public Builder buildValue(String str) {
            this.value = str;
            return this;
        }

        public Builder buildPage(String str) {
            this.page = str;
            return this;
        }

        public Builder buildAppId(String str) {
            this.appId = str;
            return this;
        }

        public Builder buildInfo(String str) {
            this.errorInfo = str;
            return this;
        }

        public void report() {
            this.mAiAppBusinessUbc.report(this);
        }
    }

    /* loaded from: classes2.dex */
    public class UbcType {
        public static final int UBC_TYPE_ACTIVITY_DESTROY_NPE = 10001;
        public static final int UBC_TYPE_DATABASE_ERROR = 10000;

        public UbcType() {
        }
    }
}
