package com.baidu.android.imsdk.mcast;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMJoinChatRoomGroupMsg extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMJoinChatRoomGroupMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public int mBatchType;
    public long mChatRoomGroupId;
    public Context mContext;
    public long mRoomType;

    public IMJoinChatRoomGroupMsg(Context context, long j, int i, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        initCommonParameter(context);
        this.mRoomType = j;
        this.mBatchType = i;
        this.mChatRoomGroupId = j2;
        setListenerKey(str);
        setNeedReplay(true);
        setType(212);
    }

    public static IMJoinChatRoomGroupMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, intent)) == null) {
            return new IMJoinChatRoomGroupMsg(context, intent.getLongExtra(Constants.EXTRA_ROOM_TYPE, 0L), intent.getIntExtra(Constants.EXTRA_BATCH_TYPE, 0), intent.getLongExtra(Constants.EXTRA_CHAT_ROOM_GROUP_ID, 0L), intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
        }
        return (IMJoinChatRoomGroupMsg) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", getType());
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("device_id", Utility.getDeviceId(this.mContext));
                jSONObject.put("uk", this.mUk);
                jSONObject.put(Constants.EXTRA_ROOM_TYPE, this.mRoomType);
                jSONObject.put(Constants.EXTRA_BATCH_TYPE, this.mBatchType);
                jSONObject.put("chatroom_group_id", this.mChatRoomGroupId);
                this.mBody = jSONObject.toString();
                LogUtils.d(TAG, "buildBody :" + this.mBody);
            } catch (JSONException e) {
                LogUtils.e(getClass().getSimpleName(), "Exception ", e);
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, i, str) == null) {
            super.handleMessageResult(context, jSONObject, i, str);
            LogUtils.d(TAG, "errorCode:" + i + "  strMsg" + str);
            ConversationStudioManImpl.getInstance(this.mContext).onChatRoomGroupResult(getListenerKey(), i, str);
        }
    }
}
