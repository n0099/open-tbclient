package com.baidu.android.imsdk.media.message;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.request.RequestContants;
import com.baidu.android.imsdk.chatmessage.request.params.DelMsgParam;
import com.baidu.android.imsdk.chatmessage.request.params.FetchMsgParam;
import com.baidu.android.imsdk.chatmessage.request.params.SendMsgParam;
import com.baidu.android.imsdk.chatmessage.response.FetchMsgResponse;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.media.MediaSessionManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.g80;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class MediaChatMessageCloudManager implements IMediaChatMessageCloudManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MediaChatMessageCloudManager";
    public static MediaChatMessageCloudManager sMediaChatMessageCloudManager;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    public MediaChatMessageCloudManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context.getApplicationContext();
    }

    public static MediaChatMessageCloudManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (sMediaChatMessageCloudManager == null) {
                synchronized (MediaChatMessageCloudManager.class) {
                    if (sMediaChatMessageCloudManager == null) {
                        sMediaChatMessageCloudManager = new MediaChatMessageCloudManager(context);
                    }
                }
            }
            return sMediaChatMessageCloudManager;
        }
        return (MediaChatMessageCloudManager) invokeL.objValue;
    }

    @Override // com.baidu.android.imsdk.media.message.IMediaChatMessageCloudManager
    public int deleteMsg(DelMsgParam delMsgParam) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, delMsgParam)) == null) {
            if (!delMsgParam.isValid()) {
                return -1005;
            }
            if (AccountManager.isLogin(this.mContext)) {
                String addListener = ListenerManager.getInstance().addListener(delMsgParam.getRequestCallBack());
                Intent creatMethodIntent = Utility.creatMethodIntent(this.mContext, 57);
                creatMethodIntent.putExtra("category", delMsgParam.category);
                creatMethodIntent.putExtra(Constants.EXTRA_PA_ID, MediaSessionManager.getInstance(this.mContext).getMeidaPaid());
                creatMethodIntent.putExtra("contacter", delMsgParam.to);
                creatMethodIntent.putExtra("contacter_uk", delMsgParam.contacterUk);
                creatMethodIntent.putExtra(RequestContants.EXTRA_CONTACTER_PA_UID, delMsgParam.contaceterPaUid);
                creatMethodIntent.putExtra("contacter_bduid", delMsgParam.contacterBduid);
                creatMethodIntent.putExtra(RequestContants.EXTRA_CONTACTER_USER_TYPE, delMsgParam.contacterUserType);
                creatMethodIntent.putExtra(Constants.EXTRA_DEL_MSG_IDS, new long[]{delMsgParam.delMsg.getMsgId()});
                creatMethodIntent.putExtra("session_type", 0);
                creatMethodIntent.putExtra(Constants.EXTRA_BUSINESS_TYPE, 0);
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                creatMethodIntent.putExtra(Constants.EXTRA_FROM_MEDIA, true);
                try {
                    g80.e(this.mContext).d(this.mContext, creatMethodIntent);
                } catch (Exception e) {
                    LogUtils.e(TAG, "Exception ", e);
                }
                return 0;
            }
            return -1000;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.android.imsdk.media.message.IMediaChatMessageCloudManager
    public void fetchMsgs(FetchMsgParam fetchMsgParam) {
        Intent creatMethodIntent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fetchMsgParam) == null) {
            if (!fetchMsgParam.isValid()) {
                fetchMsgParam.onRequestResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, new FetchMsgResponse());
            } else if (AccountManager.isLogin(this.mContext)) {
                if (fetchMsgParam.getCategory() == 4) {
                    creatMethodIntent = Utility.createMcastMethodIntent(this.mContext, 93);
                } else {
                    creatMethodIntent = Utility.creatMethodIntent(this.mContext, 93);
                }
                creatMethodIntent.putExtra(Constants.EXTRA_PA_ID, MediaSessionManager.getInstance(this.mContext).getMeidaPaid());
                creatMethodIntent.putExtra("category", fetchMsgParam.getCategory());
                creatMethodIntent.putExtra("contacter", fetchMsgParam.getTo());
                creatMethodIntent.putExtra("contacter_uk", fetchMsgParam.getContacterUk());
                creatMethodIntent.putExtra(RequestContants.EXTRA_CONTACTER_USER_TYPE, fetchMsgParam.getContacterUserType());
                creatMethodIntent.putExtra(RequestContants.EXTRA_CONTACTER_PA_UID, fetchMsgParam.getContacterPa());
                creatMethodIntent.putExtra("contacter_bduid", fetchMsgParam.getContacterBduid());
                creatMethodIntent.putExtra(Constants.EXTRA_BEGIN_MSGID, fetchMsgParam.getBeginMsgId());
                creatMethodIntent.putExtra(Constants.EXTRA_END_MSGID, fetchMsgParam.getEndMsgId());
                creatMethodIntent.putExtra("count", fetchMsgParam.getCount());
                creatMethodIntent.putExtra(Constants.EXTRA_TRIGGER_REASON, fetchMsgParam.getTriggerReason());
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, ListenerManager.getInstance().addListener(fetchMsgParam.getRequestCallBack()));
                creatMethodIntent.putExtra(Constants.EXTRA_FROM_MEDIA, true);
                creatMethodIntent.putExtra(Constants.EXTRA_SCREEN_KEY, fetchMsgParam.getScreenKey());
                creatMethodIntent.putExtra(Constants.EXTRA_BC_FETCH_TRIGGER_REASON, fetchMsgParam.getFetchTriggerReason());
                try {
                    g80.e(this.mContext).d(this.mContext, creatMethodIntent);
                } catch (Exception e) {
                    fetchMsgParam.onRequestResult(6, "start service exception", new FetchMsgResponse());
                    LogUtils.e(TAG, "Exception ", e);
                }
            } else {
                LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                fetchMsgParam.onRequestResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, new FetchMsgResponse());
            }
        }
    }

    @Override // com.baidu.android.imsdk.media.message.IMediaChatMessageCloudManager
    public void sendChatMsg(SendMsgParam sendMsgParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sendMsgParam) == null) {
            ChatMsg chatMsg = sendMsgParam.getChatMsg();
            if (chatMsg != null && chatMsg.getCategory() >= 0) {
                Intent creatMethodIntent = Utility.creatMethodIntent(this.mContext, 55);
                creatMethodIntent.putExtra(Constants.EXTRA_FROM_MEDIA, true);
                creatMethodIntent.putExtra(Constants.EXTRA_PARAM, sendMsgParam);
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, ListenerManager.getInstance().addListener(sendMsgParam.getRequestCallBack()));
                try {
                    g80.e(this.mContext).d(this.mContext, creatMethodIntent);
                    return;
                } catch (Exception e) {
                    sendMsgParam.onRequestResult(6, "send msg failed", null);
                    LogUtils.e(TAG, "Exception ", e);
                    return;
                }
            }
            sendMsgParam.onRequestResult(1005, "param invalid", null);
        }
    }
}
