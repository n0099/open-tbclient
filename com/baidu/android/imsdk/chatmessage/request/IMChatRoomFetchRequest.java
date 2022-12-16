package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.IChatRoomFetchListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.MessageParser;
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
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMChatRoomFetchRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMChatRoomFetchRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public final long mCount;
    public final IChatRoomFetchListener mListener;
    public final int mLoginType;
    public final List<Long> mRoomIds;

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

    public IMChatRoomFetchRequest(Context context, List<Long> list, long j, IChatRoomFetchListener iChatRoomFetchListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, Long.valueOf(j), iChatRoomFetchListener};
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
        this.mRoomIds = list;
        this.mCount = j;
        this.mListener = iChatRoomFetchListener;
        this.mLoginType = AccountManagerImpl.getInstance(context).getLoginType();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return BaseHttpRequest.getHostUrl(this.mContext) + "rest/3.0/im/chatroom/fetch_last_msg";
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
                jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
                jSONObject.put("device_id", Utility.getDeviceId(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
                jSONObject.put("account_type", this.mLoginType);
                if (this.mLoginType == 6) {
                    jSONObject.put("token", AccountManagerImpl.getInstance(this.mContext).getToken());
                }
                jSONObject.put("count", this.mCount);
                jSONObject.put("sign", generateSign(jSONObject));
                JSONArray jSONArray = new JSONArray();
                for (Long l : this.mRoomIds) {
                    jSONArray.put(l.longValue());
                }
                jSONObject.put("room_ids", jSONArray);
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
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                LogUtils.d(TAG, "errorCode：" + i + ", resultContent: " + jSONObject);
                str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
            } catch (Exception e) {
                LogUtils.e(TAG, "onFailure errorCode：" + i + ", exception : " + e.toString());
                str = "";
            }
            IChatRoomFetchListener iChatRoomFetchListener = this.mListener;
            if (iChatRoomFetchListener != null) {
                iChatRoomFetchListener.onResult(i, str, null);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r10v2, types: [T, java.lang.Long] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, bArr) == null) {
            String str = "";
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                LogUtils.d(TAG, "errorCode：" + i + ", resultContent: " + jSONObject);
                i2 = jSONObject.optInt("error_code");
                str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                if (i2 == 0 && (optJSONArray = jSONObject.optJSONArray("room_messages")) != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i3);
                        IChatRoomFetchListener.RoomMsgInfo roomMsgInfo = new IChatRoomFetchListener.RoomMsgInfo();
                        roomMsgInfo.errorCode = jSONObject2.optInt("error_code");
                        roomMsgInfo.roomId = jSONObject2.optLong("room_id");
                        roomMsgInfo.mcastId = jSONObject2.optLong("mcast_id");
                        JSONArray optJSONArray2 = jSONObject2.optJSONArray(NotificationCompat.CarExtender.KEY_MESSAGES);
                        Type type = new Type();
                        type.t = 0L;
                        roomMsgInfo.msgs = MessageParser.parseChatRoomMsg(this.mContext, MessageParser.parserMessage(this.mContext, optJSONArray2, type, true, false));
                        arrayList.add(roomMsgInfo);
                    }
                }
            } catch (Exception e) {
                LogUtils.e(TAG, "onSuccess errorCode：1010, exception : " + e.toString());
                i2 = 1010;
            }
            if (this.mListener != null) {
                LogUtils.d(TAG, "onSuccess errorCode：" + i2 + ", msgInfos : " + arrayList.toString());
                this.mListener.onResult(i2, str, arrayList);
            }
        }
    }
}
