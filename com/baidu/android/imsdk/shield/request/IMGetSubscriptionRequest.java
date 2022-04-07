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
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMGetSubscriptionRequest extends IMSubscriptionBaseRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMGetSubscriptionRequest";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMGetSubscriptionRequest(Context context, long j, List<Long> list, List<String> list2, String str, String str2) {
        super(context, j, list, list2, str2, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), list, list2, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Long) objArr2[1]).longValue(), (List) objArr2[2], (List) objArr2[3], (String) objArr2[4], (String) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private GetSubscriptionResult.SubscriptionInfo generateSubscriptionInfo(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONObject)) == null) {
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
        return (GetSubscriptionResult.SubscriptionInfo) invokeL.objValue;
    }

    @Override // com.baidu.android.imsdk.shield.request.IMSubscriptionBaseRequest
    public String getHostUrlParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "subscribe_state" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
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
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        long j;
        Exception exc;
        String str;
        String str2;
        String str3;
        int i2;
        IMListener removeListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr) == null) {
            String str4 = "";
            String str5 = new String(bArr);
            LogUtils.d(TAG, "IMGetSubscriptionRequest onSuccess :" + str5);
            ArrayList arrayList = new ArrayList();
            long j2 = 0;
            try {
                JSONObject jSONObject = new JSONObject(str5);
                i2 = jSONObject.optInt("error_code");
                if (i2 == 0) {
                    String optString = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                    j2 = jSONObject.optLong("pa_uid");
                    str2 = jSONObject.optString("pa_avatar");
                    try {
                        str4 = jSONObject.optString("pa_nickname");
                        JSONArray optJSONArray = jSONObject.optJSONArray("data");
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                GetSubscriptionResult.SubscriptionInfo generateSubscriptionInfo = generateSubscriptionInfo(optJSONArray.getJSONObject(i3));
                                if (generateSubscriptionInfo != null) {
                                    arrayList.add(generateSubscriptionInfo);
                                }
                            }
                        }
                        str3 = str4;
                        str4 = optString;
                    } catch (Exception e) {
                        j = j2;
                        exc = e;
                        str = str4;
                        str4 = str2;
                        LogUtils.e(TAG, "JSONException", exc);
                        str2 = str4;
                        str3 = str;
                        str4 = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                        j2 = j;
                        i2 = 1010;
                        removeListener = ListenerManager.getInstance().removeListener(this.mKey);
                        if (removeListener == null) {
                        }
                        return;
                    }
                } else {
                    str3 = "";
                    str2 = str3;
                }
            } catch (Exception e2) {
                j = j2;
                exc = e2;
                str = "";
            }
            removeListener = ListenerManager.getInstance().removeListener(this.mKey);
            if (removeListener == null && (removeListener instanceof IGetSubscriptionListener)) {
                GetSubscriptionResult getSubscriptionResult = new GetSubscriptionResult();
                getSubscriptionResult.setErrorCode(i2);
                getSubscriptionResult.setErrorMsg(str4);
                getSubscriptionResult.setPauid(j2);
                getSubscriptionResult.setPaAvatar(str2);
                getSubscriptionResult.setPaNickName(str3);
                getSubscriptionResult.setSubscriptionList(arrayList);
                ((IGetSubscriptionListener) removeListener).onResult(getSubscriptionResult);
            }
        }
    }
}
