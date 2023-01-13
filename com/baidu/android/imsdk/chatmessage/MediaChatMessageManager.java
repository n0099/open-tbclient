package com.baidu.android.imsdk.chatmessage;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.request.params.DelMsgParam;
import com.baidu.android.imsdk.chatmessage.request.params.FetchMsgParam;
import com.baidu.android.imsdk.chatmessage.request.params.SendMsgParam;
import com.baidu.android.imsdk.chatmessage.response.FetchMsgResponse;
import com.baidu.android.imsdk.chatmessage.response.SendMsgResponse;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.media.db.MediaMessageDBManager;
import com.baidu.android.imsdk.media.message.IChatMessageManager;
import com.baidu.android.imsdk.media.message.MediaChatMessageCloudManager;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.ubc.ScreenUbc;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.MsgUtility;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.cyberplayer.sdk.dlna.DlnaManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class MediaChatMessageManager implements IChatMessageManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MediaChatMessageManager";
    public static MediaChatMessageManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mAppContext;

    public MediaChatMessageManager(Context context) {
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
        this.mAppContext = context.getApplicationContext();
    }

    private List<ChatMsg> fetchMsgFromDb(FetchMsgParam fetchMsgParam) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, fetchMsgParam)) == null) {
            return MediaMessageDBManager.getInstance(this.mAppContext).fetchMsg(new ChatObject(this.mAppContext, fetchMsgParam.getCategory(), fetchMsgParam.getTo()), fetchMsgParam.getLastMsgId(), fetchMsgParam.getCount(), fetchMsgParam.getLastMsgRowId(), false);
        }
        return (List) invokeL.objValue;
    }

    public int saveDraftMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, chatMsg)) == null) {
            if (chatMsg == null) {
                return 0;
            }
            if (shouldSendByUser(chatMsg)) {
                return ChatMsgManager.saveAsDraftMsg(this.mAppContext, chatMsg);
            }
            chatMsg.setMsgId(IMConstants.DRAFT_MSGID);
            chatMsg.setStatus(3);
            chatMsg.setMsgReaded(1);
            return (int) MediaMessageDBManager.getInstance(this.mAppContext).insertDraftMsg(chatMsg);
        }
        return invokeL.intValue;
    }

    private int deleteChatMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, chatMsg)) == null) {
            return MediaMessageDBManager.getInstance(this.mAppContext).deleteChatMsg(chatMsg);
        }
        return invokeL.intValue;
    }

    public static MediaChatMessageManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (sInstance == null) {
                synchronized (MediaChatMessageManager.class) {
                    if (sInstance == null) {
                        sInstance = new MediaChatMessageManager(context);
                    }
                }
            }
            return sInstance;
        }
        return (MediaChatMessageManager) invokeL.objValue;
    }

    public static boolean isCategoryChatMsgStorageAble(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, chatMsg)) == null) {
            if (chatMsg.getCategory() == 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isMsgNoStorageRequired(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, chatMsg)) == null) {
            if (chatMsg.getCategory() != 7 && chatMsg.getMsgType() != 27) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isMsgSendNotSupported(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, chatMsg)) == null) {
            if ((chatMsg.getCategory() != 0 && chatMsg.getCategory() != 9) || chatMsg.getContacter() <= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private long saveMsgToDB(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, chatMsg)) == null) {
            long saveCategoryChatMsgToDb = saveCategoryChatMsgToDb(chatMsg);
            if (saveCategoryChatMsgToDb < 0) {
                return saveCategoryChatMsgToDb;
            }
            chatMsg.setRowId(saveCategoryChatMsgToDb);
            return saveCategoryChatMsgToDb;
        }
        return invokeL.longValue;
    }

    private boolean shouldSendByUser(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, chatMsg)) == null) {
            if (chatMsg.getCategory() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.android.imsdk.media.message.IChatMessageManager
    public int saveChatMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, chatMsg)) == null) {
            if (chatMsg == null || !AccountManager.isLogin(this.mAppContext)) {
                return -1;
            }
            return saveOrUpdateMsg(chatMsg, -1);
        }
        return invokeL.intValue;
    }

    private int deleteMsgs(ChatObject chatObject, long[] jArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, chatObject, jArr)) == null) {
            if (chatObject != null && jArr != null && jArr.length != 0) {
                return MediaMessageDBManager.getInstance(this.mAppContext).delMsgs(chatObject.getCategory(), chatObject.getContacter(), jArr);
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    private void updateChatMsgStatus(ChatMsg chatMsg, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, this, chatMsg, i) == null) {
            if (i == 0) {
                i2 = 0;
            } else {
                i2 = 2;
            }
            chatMsg.setStatus(i2);
            MediaMessageDBManager.getInstance(this.mAppContext).updateMsgStatus(chatMsg);
        }
    }

    private int saveOrUpdateMsg(ChatMsg chatMsg, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, this, chatMsg, i)) == null) {
            long maxMsgid = MediaMessageDBManager.getInstance(this.mAppContext).getMaxMsgid() + 1;
            LogUtils.d(TAG, "saveSingleMsg msgid = " + maxMsgid);
            chatMsg.setMsgId(maxMsgid);
            chatMsg.setIsClicked(true);
            chatMsg.setMsgReaded(1);
            chatMsg.setDeviceFlag(1);
            long rowId = chatMsg.getRowId();
            if (rowId == -1) {
                chatMsg.createMsgKey(this.mAppContext);
                LogUtils.d("FFF saveSingleMsg msgkey ", " " + chatMsg.getMsgKey());
                rowId = saveMsgToDB(chatMsg);
            } else {
                MediaMessageDBManager.getInstance(this.mAppContext).updateMsgStatus(chatMsg);
            }
            if (rowId >= 0) {
                chatMsg.setRowId(rowId);
                String str = "" + chatMsg.getRowId();
                String msgUUid = MsgUtility.getMsgUUid(chatMsg);
                String chatObject = ChatMsgManagerImpl.getInstance(this.mAppContext).getChatObject(chatMsg.getCategory(), chatMsg.getContacter()).toString();
                if (!TextUtils.isEmpty(msgUUid) && DBManager.getInstance(this.mAppContext).getCmdQueueMsg(msgUUid, Constants.METHOD_SEND_USER_MSG) == null) {
                    DBManager.getInstance(this.mAppContext).saveCmdMsg(msgUUid, Constants.METHOD_SEND_USER_MSG, str, chatObject, 15, 2);
                }
                return 1;
            }
            return i;
        }
        return invokeLI.intValue;
    }

    private boolean shouldDelSendToUser(ChatMsg chatMsg) {
        InterceptResult invokeL;
        PaInfo queryPaInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, chatMsg)) == null) {
            if (chatMsg.getCategory() == 1) {
                return true;
            }
            if (chatMsg.getCategory() == 0 && chatMsg.getPaid() > 0 && (chatMsg.getPaid() & Constants.PAFLAG) != 0 && (queryPaInfo = PaInfoDBManager.getInstance(this.mAppContext).queryPaInfo(chatMsg.getPaid())) != null && queryPaInfo.getSubtype() != 7) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.android.imsdk.media.message.IChatMessageManager
    public void fetchMsg(FetchMsgParam fetchMsgParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fetchMsgParam) == null) {
            if (!AccountManager.isLogin(this.mAppContext)) {
                LogUtils.d(TAG, "fetchMsg from db, trigger im relogin");
                LoginManager.getInstance(this.mAppContext).triggleLogoutListener(4001, Constants.ERROR_LOGIN_STATE_ERROR);
                FetchMsgResponse fetchMsgResponse = new FetchMsgResponse();
                fetchMsgResponse.msgs = fetchMsgFromDb(fetchMsgParam);
                fetchMsgParam.onRequestResult(0, "fetchMsg succeed from db", fetchMsgResponse);
                return;
            }
            MediaChatMessageCloudManager.getInstance(this.mAppContext).fetchMsgs(fetchMsgParam);
        }
    }

    public long saveCategoryChatMsgToDb(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, chatMsg)) == null) {
            if (chatMsg == null || !isCategoryChatMsgStorageAble(chatMsg)) {
                return -1L;
            }
            int status = chatMsg.getStatus();
            if (status == 1 && chatMsg.getRowId() != -1) {
                LogUtils.d(TAG, "save suspend，msg sending");
                return -1L;
            } else if (status != 1 && status != 3) {
                return -2L;
            } else {
                return MediaMessageDBManager.getInstance(this.mAppContext).saveChatMsg(chatMsg);
            }
        }
        return invokeL.longValue;
    }

    public int delDraftMsg(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (i == 1) {
                return ChatMsgManager.deleteDraftMsg(this.mAppContext, i, j);
            }
            return MediaMessageDBManager.getInstance(this.mAppContext).delDraftMsg(i, j);
        }
        return invokeCommon.intValue;
    }

    public ChatMsg getDraftMsg(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (i == 1) {
                return ChatMsgManager.getDraftMsg(this.mAppContext, i, j);
            }
            return MediaMessageDBManager.getInstance(this.mAppContext).queryDraftMessage(i, j);
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    @Override // com.baidu.android.imsdk.media.message.IChatMessageManager
    public int deleteMsg(Context context, DelMsgParam delMsgParam) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, delMsgParam)) == null) {
            if (!delMsgParam.isValid()) {
                return -1;
            }
            ChatMsg chatMsg = delMsgParam.delMsg;
            if (shouldDelSendToUser(chatMsg)) {
                return ChatMsgManager.deleteMsg(context, delMsgParam.delMsg);
            }
            if (chatMsg.getStatus() != 0) {
                if (deleteChatMsg(chatMsg) >= 0) {
                    return 0;
                }
                return DlnaManager.DLNA_ERROR_GET_POSITION_INFO_ACTION_NOT_FOUND;
            }
            int deleteMsgs = deleteMsgs(new ChatObject(this.mAppContext, chatMsg.getCategory(), chatMsg.getContacter()), new long[]{chatMsg.getMsgId()});
            if (deleteMsgs >= 0) {
                MediaChatMessageCloudManager.getInstance(this.mAppContext).deleteMsg(delMsgParam);
            }
            return deleteMsgs;
        }
        return invokeLL.intValue;
    }

    public void onFetchMsgByIdResult(FetchMsgResponse fetchMsgResponse, String str) {
        ScreenUbc.MethodInfo screenMethodInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, fetchMsgResponse, str) == null) {
            LogUtils.d(TAG, "onFetchMsgByIdResult:" + fetchMsgResponse.toString());
            IMListener removeListener = ListenerManager.getInstance().removeListener(fetchMsgResponse.listenerkey);
            if (removeListener instanceof BIMValueCallBack) {
                BIMValueCallBack bIMValueCallBack = (BIMValueCallBack) removeListener;
                if (fetchMsgResponse.fetchReason != 2) {
                    fetchMsgResponse.msgs = MediaMessageDBManager.getInstance(this.mAppContext).fetchMsg(new ChatObject(this.mAppContext, fetchMsgResponse.category, fetchMsgResponse.contacter), fetchMsgResponse.endId, fetchMsgResponse.count, -1L, false);
                }
                bIMValueCallBack.onResult(fetchMsgResponse.errorCode, fetchMsgResponse.strMsg, fetchMsgResponse);
                if (TextUtils.isEmpty(str) || (screenMethodInfo = Utility.getScreenMethodInfo(str)) == null) {
                    return;
                }
                screenMethodInfo.errCode = fetchMsgResponse.errorCode;
                screenMethodInfo.errMsg = fetchMsgResponse.strMsg;
                screenMethodInfo.endTime = System.currentTimeMillis();
                ScreenUbc.onEvent(this.mAppContext, str, screenMethodInfo);
            }
        }
    }

    public void onSendMessageResult(int i, String str, SendMsgResponse sendMsgResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, str, sendMsgResponse) == null) {
            try {
                ChatMsg chatMsg = sendMsgResponse.msg;
                String str2 = sendMsgResponse.listenerKey;
                if (chatMsg == null) {
                    LogUtils.d(TAG, "onSendMessageResult----chatMsg is null");
                    IMListener removeListener = ListenerManager.getInstance().removeListener(str2);
                    if (removeListener instanceof BIMValueCallBack) {
                        ((BIMValueCallBack) removeListener).onResult(i, str, null);
                    } else {
                        LogUtils.d(TAG, "ISendMessageListener is null");
                    }
                } else if (chatMsg.getCategory() == 4) {
                    ChatMsgManagerImpl.getInstance(this.mAppContext).onSendStudioMsgResult(i, chatMsg, chatMsg.getMsgTime(), str2);
                } else if (chatMsg.getCategory() == 9) {
                    ChatMsgManagerImpl.getInstance(this.mAppContext).onSendConsultMsgResult(i, chatMsg, chatMsg.getMsgTime(), str2);
                } else {
                    LogUtils.d(TAG, "onSendMessageResult----errorCode: " + i);
                    DBManager.getInstance(this.mAppContext).deleteCmdMsg(MsgUtility.getMsgUUid(chatMsg));
                    updateChatMsgStatus(chatMsg, i);
                    ChatMsgManagerImpl.getInstance(this.mAppContext).setMaxNotifyMsgid(chatMsg);
                    IMListener removeListener2 = ListenerManager.getInstance().removeListener(str2);
                    if (removeListener2 != null && (removeListener2 instanceof BIMValueCallBack)) {
                        SendMsgResponse sendMsgResponse2 = new SendMsgResponse();
                        sendMsgResponse2.msg = chatMsg;
                        ((BIMValueCallBack) removeListener2).onResult(i, str, sendMsgResponse2);
                    }
                }
            } catch (Exception e) {
                LogUtils.e(TAG, "onSendMessageResult exception " + e.getMessage());
            }
        }
    }

    @Override // com.baidu.android.imsdk.media.message.IChatMessageManager
    public void sendChatMsg(Context context, SendMsgParam sendMsgParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, sendMsgParam) == null) {
            if (!sendMsgParam.isValid()) {
                sendMsgParam.onRequestResult(1005, "send msg param invalid", null);
                return;
            }
            ChatMsg chatMsg = sendMsgParam.getChatMsg();
            if (shouldSendByUser(chatMsg)) {
                ChatMsgManager.sendMessage(context, chatMsg, new ISendMessageListener(this, sendMsgParam) { // from class: com.baidu.android.imsdk.chatmessage.MediaChatMessageManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaChatMessageManager this$0;
                    public final /* synthetic */ SendMsgParam val$sendMsgParam;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, sendMsgParam};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$sendMsgParam = sendMsgParam;
                    }

                    @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
                    public void onSendMessageResult(int i, ChatMsg chatMsg2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, chatMsg2) == null) {
                            SendMsgResponse sendMsgResponse = new SendMsgResponse();
                            sendMsgResponse.msg = chatMsg2;
                            this.val$sendMsgParam.onRequestResult(i, "", sendMsgResponse);
                        }
                    }
                });
            } else if (chatMsg.getCategory() == 9) {
                ChatMsgManagerImpl.getInstance(this.mAppContext).sendConsultMsg(chatMsg, ListenerManager.getInstance().addListener(new ISendMessageListener(this, sendMsgParam) { // from class: com.baidu.android.imsdk.chatmessage.MediaChatMessageManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaChatMessageManager this$0;
                    public final /* synthetic */ SendMsgParam val$sendMsgParam;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, sendMsgParam};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$sendMsgParam = sendMsgParam;
                    }

                    @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
                    public void onSendMessageResult(int i, ChatMsg chatMsg2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, chatMsg2) == null) {
                            SendMsgResponse sendMsgResponse = new SendMsgResponse();
                            sendMsgResponse.msg = chatMsg2;
                            this.val$sendMsgParam.onRequestResult(i, "", sendMsgResponse);
                        }
                    }
                }));
            } else if (isMsgNoStorageRequired(chatMsg)) {
                MediaChatMessageCloudManager.getInstance(this.mAppContext).sendChatMsg(sendMsgParam);
            } else if (isMsgSendNotSupported(chatMsg)) {
                sendMsgParam.onRequestResult(1005, "msg is not support to send", null);
            } else if (AccountManager.isLogin(this.mAppContext)) {
                if (saveChatMsg(chatMsg) == 1) {
                    MediaChatMessageCloudManager.getInstance(this.mAppContext).sendChatMsg(sendMsgParam);
                    return;
                }
                SendMsgResponse sendMsgResponse = new SendMsgResponse();
                sendMsgResponse.msg = chatMsg;
                sendMsgParam.onRequestResult(6, "save msg failed", sendMsgResponse);
            } else {
                LoginManager.getInstance(this.mAppContext).triggleLogoutListener(4001, Constants.ERROR_LOGIN_STATE_ERROR);
                SendMsgResponse sendMsgResponse2 = new SendMsgResponse();
                sendMsgResponse2.msg = chatMsg;
                sendMsgParam.onRequestResult(1000, "account is not login", sendMsgResponse2);
            }
        }
    }
}
