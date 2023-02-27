package com.baidu.sapi2.result;

import com.baidu.sapi2.NoProguard;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IsShowRealNameGuideResult extends SapiResult implements NoProguard {
    public static final int CODE_BUSINESS_RESULT_OK = 110000;
    public static final int CODE_BUSINESS_RESULT_USER_OFFLINE = 400021;
    public static final int CODE_NET_RESULT_OK = 200;
    public static final String KEY_CODE = "code";
    public static final String KEY_DATA = "data";
    public static final String KEY_ISGUIDE = "isGuide";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_TEXT = "text";
    public static final String MESSAGE_BUSINESS_RESULT_OK = "成功";
    public static final String MESSAGE_BUSINESS_RESULT_USER_OFFLINE = "当前用户不在线";
    public static final int VALUE_NEED_SHOW_GUIDE = 1;
    public int isGuide;
    public String text;

    public IsShowRealNameGuideResult() {
        this.msgMap.put(110000, "成功");
        this.msgMap.put(400021, "当前用户不在线");
    }

    public static IsShowRealNameGuideResult parseFromJSONObject(JSONObject jSONObject) {
        IsShowRealNameGuideResult isShowRealNameGuideResult = new IsShowRealNameGuideResult();
        if (jSONObject == null) {
            isShowRealNameGuideResult.setResultCode(-205);
            isShowRealNameGuideResult.setResultMsg("服务端数据异常，请稍后再试");
            return isShowRealNameGuideResult;
        }
        isShowRealNameGuideResult.isGuide = jSONObject.optInt(KEY_ISGUIDE);
        isShowRealNameGuideResult.text = jSONObject.optString("text");
        isShowRealNameGuideResult.setResultCode(110000);
        isShowRealNameGuideResult.setResultMsg("成功");
        return isShowRealNameGuideResult;
    }
}
