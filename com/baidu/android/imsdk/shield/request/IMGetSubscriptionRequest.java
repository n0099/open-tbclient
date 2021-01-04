package com.baidu.android.imsdk.shield.request;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.shield.IGetSubscriptionListener;
import com.baidu.android.imsdk.shield.model.GetSubscriptionResult;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class IMGetSubscriptionRequest extends IMSubscriptionBaseRequest {
    public static final String TAG = "IMGetSubscriptionRequest";

    public IMGetSubscriptionRequest(Context context, long j, List<Long> list, List<String> list2, String str, String str2) {
        super(context, j, list, list2, str2, str);
    }

    @Override // com.baidu.android.imsdk.shield.request.IMSubscriptionBaseRequest
    public String getHostUrlParam() {
        return "subscribe_state";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        String str2 = new String(bArr);
        LogUtils.d(TAG, "IMGetSubscriptionRequest onSuccess :" + str2);
        String str3 = "";
        long j = 0;
        String str4 = "";
        String str5 = "";
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            i2 = jSONObject.optInt("error_code");
            if (i2 == 0) {
                str3 = jSONObject.optString("error_msg", "");
                j = jSONObject.optLong("pa_uid");
                str4 = jSONObject.optString("pa_avatar");
                str5 = jSONObject.optString("pa_nickname");
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        GetSubscriptionResult.SubscriptionInfo generateSubscriptionInfo = generateSubscriptionInfo(optJSONArray.getJSONObject(i3));
                        if (generateSubscriptionInfo != null) {
                            arrayList.add(generateSubscriptionInfo);
                        }
                    }
                }
            }
            str = str5;
        } catch (Exception e) {
            LogUtils.e(TAG, "JSONException", e);
            i2 = 1010;
            str3 = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            str = str5;
        }
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener != null && (removeListener instanceof IGetSubscriptionListener)) {
            GetSubscriptionResult getSubscriptionResult = new GetSubscriptionResult();
            getSubscriptionResult.setErrorCode(i2);
            getSubscriptionResult.setErrorMsg(str3);
            getSubscriptionResult.setPauid(j);
            getSubscriptionResult.setPaAvatar(str4);
            getSubscriptionResult.setPaNickName(str);
            getSubscriptionResult.setSubscriptionList(arrayList);
            ((IGetSubscriptionListener) removeListener).onResult(getSubscriptionResult);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        LogUtils.d(TAG, "IMGetSubscriptionRequest onFailure :" + transErrorCode.first + " errmsg = " + ((String) transErrorCode.second));
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener != null && (removeListener instanceof IGetSubscriptionListener)) {
            GetSubscriptionResult getSubscriptionResult = new GetSubscriptionResult();
            getSubscriptionResult.setErrorCode(((Integer) transErrorCode.first).intValue());
            getSubscriptionResult.setErrorMsg((String) transErrorCode.second);
            ((IGetSubscriptionListener) removeListener).onResult(getSubscriptionResult);
        }
    }

    private GetSubscriptionResult.SubscriptionInfo generateSubscriptionInfo(JSONObject jSONObject) {
        if (jSONObject != null) {
            GetSubscriptionResult.SubscriptionInfo subscriptionInfo = new GetSubscriptionResult.SubscriptionInfo();
            subscriptionInfo.setStatus(jSONObject.optInt("subscription_state"));
            subscriptionInfo.setDescription(jSONObject.optString("description"));
            subscriptionInfo.setTopicName(jSONObject.optString("topic_name"));
            subscriptionInfo.setTopicId(jSONObject.optLong("topic_id"));
            subscriptionInfo.setMiNiTopicId(jSONObject.optString("fminapp_topic"));
            return subscriptionInfo;
        }
        return null;
    }
}
