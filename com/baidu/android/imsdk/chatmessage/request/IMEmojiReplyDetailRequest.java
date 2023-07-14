package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyDetailListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMEmojiReplyDetailRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMEmojiReplyListRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public final IMEmojiReplyDetailListener emojiReplyDetailListener;
    public final IMEmojiReplyDetailListener.IMEmojiReplyDetailRequestInfo info;

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public IMEmojiReplyDetailRequest(Context context, @NonNull IMEmojiReplyDetailListener.IMEmojiReplyDetailRequestInfo iMEmojiReplyDetailRequestInfo, IMEmojiReplyDetailListener iMEmojiReplyDetailListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, iMEmojiReplyDetailRequestInfo, iMEmojiReplyDetailListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.info = iMEmojiReplyDetailRequestInfo;
        this.emojiReplyDetailListener = iMEmojiReplyDetailListener;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return BaseHttpRequest.getHostUrl(this.mContext) + "rest/3.0/im/chatroom/reaction_detail";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", Utility.readAppId(this.mContext));
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("device_id", Utility.getDeviceId(this.mContext));
                jSONObject.put("room_id", this.info.roomId);
                jSONObject.put(Constants.EXTRA_EMOJI_PACKAGE_ID, this.emojiReplyDetailListener);
                jSONObject.put("msgid", this.info.msgId);
                jSONObject.put(Constants.EXTRA_EMOJI_PACKAGE_ID, this.info.emojiPackageId);
                jSONObject.put("emoji_content", this.info.emojiContent);
                jSONObject.put("sort_time_us_begin", this.info.sortTimeBegin);
                jSONObject.put("sort_time_us_end", this.info.sortTimeEnd);
                jSONObject.put("count", this.info.fetchCount);
                jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
                jSONObject.put("sign", generateSign(jSONObject));
            } catch (JSONException e) {
                LogUtils.d("IMEmojiReplyListRequest", "getRequestParameter error：" + e);
            }
            LogUtils.d("IMEmojiReplyListRequest", "getRequestParameter:" + jSONObject);
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, bArr, th) == null) {
            IMEmojiReplyDetailListener.IMEmojiReplyDetailResponse iMEmojiReplyDetailResponse = new IMEmojiReplyDetailListener.IMEmojiReplyDetailResponse();
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                LogUtils.d("IMEmojiReplyListRequest", "errorCode：" + i + ", resultContent: " + jSONObject);
                str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
            } catch (Exception e) {
                LogUtils.e("IMEmojiReplyListRequest", "onFailure errorCode：" + i + ", exception : " + e.toString());
                str = "";
            }
            IMEmojiReplyDetailListener iMEmojiReplyDetailListener = this.emojiReplyDetailListener;
            if (iMEmojiReplyDetailListener != null) {
                iMEmojiReplyDetailListener.onResult(i, str, iMEmojiReplyDetailResponse);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, bArr) == null) {
            IMEmojiReplyDetailListener.IMEmojiReplyDetailResponse iMEmojiReplyDetailResponse = new IMEmojiReplyDetailListener.IMEmojiReplyDetailResponse();
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                LogUtils.d("IMEmojiReplyListRequest", "errorCode：" + i + ", resultContent: " + jSONObject);
                i = jSONObject.optInt("error_code");
                str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                if (i == 0) {
                    iMEmojiReplyDetailResponse.hasMore = jSONObject.optInt("has_more");
                    iMEmojiReplyDetailResponse.emojiReplyDetailList = new ArrayList<>();
                    if (jSONObject.has("result") && (optJSONArray = jSONObject.optJSONArray("result")) != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            IMEmojiReplyDetailListener.IMEmojiReplyReactionDetail iMEmojiReplyReactionDetail = new IMEmojiReplyDetailListener.IMEmojiReplyReactionDetail();
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                            if (jSONObject2 != null) {
                                iMEmojiReplyReactionDetail.bduk = jSONObject2.optString("reaction_bduk");
                                iMEmojiReplyReactionDetail.sortTimeUs = jSONObject2.optLong("sort_time_us");
                                iMEmojiReplyDetailResponse.emojiReplyDetailList.add(iMEmojiReplyReactionDetail);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                LogUtils.e("IMEmojiReplyListRequest", "onSuccess errorCode：" + i + ", exception : " + e);
                i = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            IMEmojiReplyDetailListener iMEmojiReplyDetailListener = this.emojiReplyDetailListener;
            if (iMEmojiReplyDetailListener != null) {
                iMEmojiReplyDetailListener.onResult(i, str, iMEmojiReplyDetailResponse);
            }
        }
    }
}
