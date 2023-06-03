package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMChatRoomEnterRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMEnterChatRoomRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public final IChatRoomEnterListener mListener;
    public final int mLoginType;
    public final long mRoomId;

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

    public IMChatRoomEnterRequest(Context context, long j, IChatRoomEnterListener iChatRoomEnterListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), iChatRoomEnterListener};
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
        this.mRoomId = j;
        this.mListener = iChatRoomEnterListener;
        this.mLoginType = AccountManagerImpl.getInstance(context).getLoginType();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return BaseHttpRequest.getHostUrl(this.mContext) + "rest/3.0/im/chatroom/enter_chatroom_client";
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
                jSONObject.put("room_id", this.mRoomId);
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
                jSONObject.put("device_id", Utility.getDeviceId(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
                jSONObject.put("account_type", this.mLoginType);
                if (this.mLoginType == 6) {
                    jSONObject.put("token", AccountManagerImpl.getInstance(this.mContext).getToken());
                }
                jSONObject.put("sign", generateSign(jSONObject));
            } catch (JSONException e) {
                LogUtils.d(TAG, "getRequestParameter error：" + e.toString());
            }
            LogUtils.d(TAG, "IMEnterChatRoomRequest getRequestParameter:" + jSONObject);
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, bArr, th) == null) {
            IChatRoomEnterListener.ChatRoomInfo chatRoomInfo = new IChatRoomEnterListener.ChatRoomInfo();
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                LogUtils.d(TAG, "errorCode：" + i + ", resultContent: " + jSONObject);
                str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
            } catch (Exception e) {
                LogUtils.e(TAG, "onFailure errorCode：" + i + ", exception : " + e.toString());
                str = "";
            }
            IChatRoomEnterListener iChatRoomEnterListener = this.mListener;
            if (iChatRoomEnterListener != null) {
                iChatRoomEnterListener.onResult(i, str, chatRoomInfo);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, bArr) == null) {
            String str = "";
            IChatRoomEnterListener.ChatRoomInfo chatRoomInfo = new IChatRoomEnterListener.ChatRoomInfo();
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                LogUtils.d(TAG, "errorCode：" + i + ", resultContent: " + jSONObject);
                i = jSONObject.optInt("error_code");
                str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                if (i == 0) {
                    chatRoomInfo.roomId = jSONObject.optLong("room_id");
                    chatRoomInfo.roomInfo = new IChatRoomEnterListener.RoomInfo();
                    JSONObject jSONObject2 = (JSONObject) jSONObject.opt("room_info");
                    if (jSONObject2 != null) {
                        chatRoomInfo.roomInfo.appId = jSONObject2.optLong("app_id");
                        chatRoomInfo.roomInfo.roomType = jSONObject2.optInt("room_type");
                        chatRoomInfo.roomInfo.roomName = jSONObject2.optString(DpStatConstants.KEY_ROOM_NAME);
                        chatRoomInfo.roomInfo.roomImage = jSONObject2.optString("room_image");
                        chatRoomInfo.roomInfo.roomNotice = jSONObject2.optString("room_notice");
                        chatRoomInfo.roomInfo.userCount = jSONObject2.optInt("user_count");
                        chatRoomInfo.roomInfo.state = jSONObject.optInt("state");
                        chatRoomInfo.roomInfo.chatMcastId = jSONObject.optLong("chat_mcast_id");
                        chatRoomInfo.roomInfo.resourceId = jSONObject.optString("resource_id");
                        chatRoomInfo.roomInfo.ext = jSONObject.optString("ext");
                    }
                    JSONObject jSONObject3 = (JSONObject) jSONObject.opt(SourceConstant.SOURCE_USER_INFO);
                    if (jSONObject3 != null) {
                        IChatRoomEnterListener.UserInfo userInfo = new IChatRoomEnterListener.UserInfo();
                        chatRoomInfo.userInfo = userInfo;
                        userInfo.character = jSONObject3.optLong("character");
                        chatRoomInfo.userInfo.characterName = jSONObject3.optString("character_name");
                    }
                }
            } catch (Exception e) {
                LogUtils.e(TAG, "onSuccess errorCode：" + i + ", exception : " + e.toString());
            }
            IChatRoomEnterListener iChatRoomEnterListener = this.mListener;
            if (iChatRoomEnterListener != null) {
                iChatRoomEnterListener.onResult(i, str, chatRoomInfo);
            }
        }
    }
}
