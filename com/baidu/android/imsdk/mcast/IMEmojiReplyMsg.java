package com.baidu.android.imsdk.mcast;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
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
public class IMEmojiReplyMsg extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMEmojiReplyMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public final ChatMsg mChatMsg;
    public Context mContext;
    public final String mEmojiContent;
    public final int mEmojiPackageId;
    public final int mOpType;

    public IMEmojiReplyMsg(Context context, @NonNull ChatMsg chatMsg, int i, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, chatMsg, Integer.valueOf(i), Integer.valueOf(i2), str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        initCommonParameter(context);
        this.mChatMsg = chatMsg;
        this.mOpType = i;
        this.mEmojiPackageId = i2;
        this.mEmojiContent = str;
        setNeedReplay(true);
        setType(Constants.METHOD_IM_EMOJI);
        setListenerKey(str2);
    }

    public static IMEmojiReplyMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, intent)) == null) {
            return new IMEmojiReplyMsg(context, (ChatMsg) intent.getParcelableExtra(Constants.EXTRA_SEND_MSG), intent.getIntExtra("op_type", -1), intent.getIntExtra(Constants.EXTRA_EMOJI_PACKAGE_ID, -1), intent.getStringExtra("emoji_content"), intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
        }
        return (IMEmojiReplyMsg) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", Constants.METHOD_IM_EMOJI);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("device_id", Utility.getDeviceId(this.mContext));
                jSONObject.put("bduid", AccountManagerImpl.getInstance(this.mContext).getBduid());
                jSONObject.put("uk", this.mUk);
                if (this.mChatMsg != null) {
                    jSONObject.put("category", this.mChatMsg.getCategory());
                    jSONObject.put("msg_to_uk", this.mChatMsg.getContacter());
                    jSONObject.put("msgid", this.mChatMsg.getMsgId());
                    jSONObject.put("msg_key", this.mChatMsg.getMsgKey());
                    jSONObject.put("msg_from_uk", this.mChatMsg.getFromUser());
                }
                jSONObject.put("op_type", this.mOpType);
                jSONObject.put(Constants.EXTRA_EMOJI_PACKAGE_ID, this.mEmojiPackageId);
                jSONObject.put("emoji_content", this.mEmojiContent);
                this.mBody = jSONObject.toString();
                LogUtils.d(TAG, "buildBody :" + this.mBody);
            } catch (JSONException e) {
                LogUtils.e(TAG, "buildBody Exception ", e);
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, i, str) == null) {
            super.handleMessageResult(context, jSONObject, i, str);
            LogUtils.d(TAG, "errorCode:" + i + "  strMsg" + str);
            IMEmojiReplyListener iMEmojiReplyListener = (IMEmojiReplyListener) ListenerManager.getInstance().removeListener(getListenerKey());
            if (iMEmojiReplyListener != null) {
                iMEmojiReplyListener.onResult(i, str);
            }
            if (i == 0) {
                ChatMessageDBManager.getInstance(this.mContext).addEmojiContent(this.mEmojiPackageId, 4, this.mEmojiContent);
            }
        }
    }
}
