package com.baidu.android.imsdk.shield.request;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.shield.IGetSubscriptionListener;
import com.baidu.android.imsdk.shield.model.GetSubscriptionResult;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMGetSubscriptionRequest extends IMSubscriptionBaseRequest {
    public static final String TAG = "IMGetSubscriptionRequest";

    public IMGetSubscriptionRequest(Context context, long j, List<Long> list, List<String> list2, String str, String str2) {
        super(context, j, list, list2, str2, str);
    }

    private GetSubscriptionResult.SubscriptionInfo generateSubscriptionInfo(JSONObject jSONObject) {
        if (jSONObject != null) {
            GetSubscriptionResult.SubscriptionInfo subscriptionInfo = new GetSubscriptionResult.SubscriptionInfo();
            subscriptionInfo.setStatus(jSONObject.optInt("subscription_state"));
            subscriptionInfo.setDescription(jSONObject.optString("description"));
            subscriptionInfo.setTopicName(jSONObject.optString(IntentConfig.TOPIC_NAME));
            subscriptionInfo.setTopicId(jSONObject.optLong("topic_id"));
            subscriptionInfo.setMiNiTopicId(jSONObject.optString("fminapp_topic"));
            return subscriptionInfo;
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.shield.request.IMSubscriptionBaseRequest
    public String getHostUrlParam() {
        return "subscribe_state";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        LogUtils.d(TAG, "IMGetSubscriptionRequest onFailure :" + transErrorCode.first + " errmsg = " + ((String) transErrorCode.second));
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener == null || !(removeListener instanceof IGetSubscriptionListener)) {
            return;
        }
        GetSubscriptionResult getSubscriptionResult = new GetSubscriptionResult();
        getSubscriptionResult.setErrorCode(((Integer) transErrorCode.first).intValue());
        getSubscriptionResult.setErrorMsg((String) transErrorCode.second);
        ((IGetSubscriptionListener) removeListener).onResult(getSubscriptionResult);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        long j;
        Exception exc;
        String str;
        String str2;
        String str3;
        int i3;
        IMListener removeListener;
        String str4 = "";
        String str5 = new String(bArr);
        LogUtils.d(TAG, "IMGetSubscriptionRequest onSuccess :" + str5);
        ArrayList arrayList = new ArrayList();
        long j2 = 0;
        try {
            JSONObject jSONObject = new JSONObject(str5);
            i3 = jSONObject.optInt("error_code");
            if (i3 == 0) {
                String optString = jSONObject.optString("error_msg", "");
                j2 = jSONObject.optLong("pa_uid");
                str2 = jSONObject.optString("pa_avatar");
                try {
                    str4 = jSONObject.optString("pa_nickname");
                    JSONArray optJSONArray = jSONObject.optJSONArray("data");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                            GetSubscriptionResult.SubscriptionInfo generateSubscriptionInfo = generateSubscriptionInfo(optJSONArray.getJSONObject(i4));
                            if (generateSubscriptionInfo != null) {
                                arrayList.add(generateSubscriptionInfo);
                            }
                        }
                    }
                    str3 = str4;
                    str4 = optString;
                } catch (Exception e2) {
                    j = j2;
                    exc = e2;
                    str = str4;
                    str4 = str2;
                    LogUtils.e(TAG, "JSONException", exc);
                    str2 = str4;
                    str3 = str;
                    str4 = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                    j2 = j;
                    i3 = 1010;
                    removeListener = ListenerManager.getInstance().removeListener(this.mKey);
                    if (removeListener == null) {
                    }
                    return;
                }
            } else {
                str3 = "";
                str2 = str3;
            }
        } catch (Exception e3) {
            j = j2;
            exc = e3;
            str = "";
        }
        removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener == null && (removeListener instanceof IGetSubscriptionListener)) {
            GetSubscriptionResult getSubscriptionResult = new GetSubscriptionResult();
            getSubscriptionResult.setErrorCode(i3);
            getSubscriptionResult.setErrorMsg(str4);
            getSubscriptionResult.setPauid(j2);
            getSubscriptionResult.setPaAvatar(str2);
            getSubscriptionResult.setPaNickName(str3);
            getSubscriptionResult.setSubscriptionList(arrayList);
            ((IGetSubscriptionListener) removeListener).onResult(getSubscriptionResult);
        }
    }
}
