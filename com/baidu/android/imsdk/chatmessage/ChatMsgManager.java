package com.baidu.android.imsdk.chatmessage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.chatmessage.sync.SyncAllMessage;
import com.baidu.android.imsdk.chatmessage.sync.SyncGroupMessageService;
import com.baidu.android.imsdk.consult.listener.IChatMsgChangedListener;
import com.baidu.android.imsdk.consult.listener.ICustomizeNotifyListener;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener;
import com.baidu.android.imsdk.notification.IFetchNotificationDataListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.shield.IShowingToastListener;
import com.baidu.android.imsdk.upload.FileUploadTask;
import com.baidu.android.imsdk.upload.IFileUploadListener;
import com.baidu.android.imsdk.upload.IUploadTransferListener;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ChatMsgManager extends BaseManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ChatMsgManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void asyncUploadImgToBos(Context context, String str, String str2, int i, int i2, int i3, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iUploadTransferListener}) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                ChatMsgManagerImpl.getInstance(context).asyncUploadImgToBos(str, str2, i, i2, i3, iUploadTransferListener);
            } else if (iUploadTransferListener != null) {
                iUploadTransferListener.onFailed(1005, 1, str);
            }
        }
    }

    public static void mediaContactorSetting(Context context, long j, int i, long j2, String str, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65594, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Integer.valueOf(i2), iMediaContactorSettingListener}) == null) {
            ChatSessionManagerImpl.getInstance(context).mediaContactorSetting(j, i, j2, str, i2, iMediaContactorSettingListener);
        }
    }

    public static void mediaGetContactorSetting(Context context, long j, int i, long j2, String str, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65606, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Integer.valueOf(i2), iMediaContactorSettingListener}) == null) {
            ChatSessionManagerImpl.getInstance(context).mediaGetContactorSetting(j, i, j2, str, i2, iMediaContactorSettingListener);
        }
    }

    public static void mediaSendChatMsg(Context context, long j, int i, long j2, String str, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65609, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, chatMsg, iMediaSendChatMsgListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).mediaSendChatMsg(j, i, j2, str, chatMsg, iMediaSendChatMsgListener);
        }
    }

    public static void mediaSetSessionRead(Context context, long j, int i, long j2, String str, long j3, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65611, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), iMediaSetSessionReadListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).mediaSetSessionRead(j, i, j2, str, j3, iMediaSetSessionReadListener);
    }

    public static void sendPaChatMsg(Context context, int i, int i2, long j, int i3, String str, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65629, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), str, iSendMessageListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).sendPaChatMsg(i, i2, j, i3, str, iSendMessageListener);
        }
    }

    public static void uploadFile(Context context, String str, String str2, String str3, String str4, String str5, IFileUploadListener iFileUploadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65646, null, new Object[]{context, str, str2, str3, str4, str5, iFileUploadListener}) == null) {
            if (context != null && !TextUtils.isEmpty(str2) && new File(str2).exists()) {
                new FileUploadTask(context, str, str2, str3, str4, str5, iFileUploadListener).execute(new Void[0]);
            } else if (iFileUploadListener != null) {
                iFileUploadListener.onFailed(1005, Constants.ERROR_MSG_PARAMETER_ERROR);
            }
        }
    }

    public static void audioTrans(Context context, String str, String str2, String str3, int i, BIMValueCallBack bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, str3, Integer.valueOf(i), bIMValueCallBack}) == null) {
            if (context != null && !TextUtils.isEmpty(str) && new File(str).exists()) {
                ChatMsgManagerImpl.getInstance(context).audioTrans(str, str2, str3, i, bIMValueCallBack);
            } else if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        }
    }

    public static void getPaMsgByChatTypeAndPaidList(Context context, List<Integer> list, List<Long> list2, long j, int i, IFetchNotificationDataListener iFetchNotificationDataListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65584, null, new Object[]{context, list, list2, Long.valueOf(j), Integer.valueOf(i), iFetchNotificationDataListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManagerImpl.getInstance(context).getPaMsgByChatTypeAndPaidList(list, list2, j, i, iFetchNotificationDataListener);
    }

    public static void handleConsultMsgNotify(Context context, int i, int i2, long j, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65590, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            ChatMsgManagerImpl.getInstance(context).handleConsultMsgNotify(i, i2, j, i3, j2, -1L, "");
        }
    }

    public static void mediaFetchChatMsgs(Context context, long j, long j2, long j3, int i, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65601, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), iMediaFetchChatMsgsListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).mediaFetchChatMsgs(context, j, j2, j3, i, iMediaFetchChatMsgsListener);
        }
    }

    public static void sendMsgToChatRoom(Context context, long j, String str, @NonNull ChatMsg chatMsg, @NonNull IChatRoomEnterListener.UserInfo userInfo, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65627, null, new Object[]{context, Long.valueOf(j), str, chatMsg, userInfo, iSendMessageListener}) == null) {
            chatMsg.setNickName(userInfo.name);
            chatMsg.setPortrait(userInfo.portrait);
            ChatMsg generateMsg = generateMsg(j, chatMsg);
            generateMsg.setMsgContent(getMsgContent(j, str, chatMsg, userInfo));
            sendMessage(context, generateMsg, iSendMessageListener);
        }
    }

    public static int setBusinessChatMsgContacterRead(Context context, int i, int i2, long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65632, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            return ChatMsgManagerImpl.getInstance(context).setBusinessChatMsgContacterRead(i, i2, j, j2, j3);
        }
        return invokeCommon.intValue;
    }

    public static void createChatSession(Context context, ChatObject chatObject, String str, int i, String str2, int i2, String str3, String str4, int i3, int i4, long j, int i5, long j2, String str5, String str6, String str7, String str8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, chatObject, str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, str4, Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j), Integer.valueOf(i5), Long.valueOf(j2), str5, str6, str7, str8}) == null) {
            ChatSessionManagerImpl.getInstance(context).createChatSession(chatObject, str, i, str2, i2, str3, str4, i3, i4, j, i5, j2, str5, str6, str7, str8);
        }
    }

    public static int deleteAdvisoryDraft(Context context, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (context == null) {
                return -1005;
            }
            return ChatMsgManagerImpl.getInstance(context).deleteAdvisoryDraft(i, j);
        }
        return invokeCommon.intValue;
    }

    public static int deleteDraftMsg(Context context, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (context == null) {
                return -1005;
            }
            return ChatMsgManagerImpl.getInstance(context).deleteDraftMsg(i, j);
        }
        return invokeCommon.intValue;
    }

    public static ArrayList<ChatSession> getChatRecords(Context context, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65570, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            LogUtils.enter();
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatSessionManagerImpl.getInstance(context).getChatRecords(j, j2);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public static ChatSession getChatSession(Context context, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65573, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return ChatSessionManagerImpl.getInstance(context).getChatRecord(i, j);
        }
        return (ChatSession) invokeCommon.objValue;
    }

    public static ChatMsg getDraftMsg(Context context, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65574, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (context == null) {
                return null;
            }
            return ChatMsgManagerImpl.getInstance(context).getDraftMsg(i, j);
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    @Deprecated
    public static long getNewMsgNum(Context context, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65579, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1L;
            }
            return ChatMsgManagerImpl.getInstance(context).getNewMsgNum(i, j);
        }
        return invokeCommon.longValue;
    }

    @Deprecated
    public static long getUnReadMsgCount(Context context, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65588, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1L;
            }
            return ChatMsgManagerImpl.getInstance(context).getNewMsgNum(i, j);
        }
        return invokeCommon.longValue;
    }

    public static boolean deleteAllMsgs(Context context, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (context == null || !Utility.isCategoryCorrect(i) || !Utility.isContacterCorrect(j) || ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(i, j, false) < 0) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean deleteChatSession(Context context, ChatSession chatSession) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, chatSession)) == null) {
            if (context != null && chatSession != null) {
                return ChatSessionManagerImpl.getInstance(context).deleteChatSession(chatSession);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static int deleteMsg(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, chatMsg)) == null) {
            if (context != null && chatMsg != null) {
                return ChatMsgManagerImpl.getInstance(context).deleteMsgs(chatMsg);
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static ArrayList<ChatSession> getChatRecords(Context context, List<Integer> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, context, list)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatSessionManagerImpl.getInstance(context).getChatRecords(0L, 0L, list);
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static ArrayList<ChatSession> getChatRecordsByClass(Context context, List<Integer> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, context, list)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatSessionManagerImpl.getInstance(context).getChatRecordsByClass(0L, list);
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static ChatMsg getMsgByMsgId(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65576, null, context, j)) == null) {
            return ChatMsgManagerImpl.getInstance(context).getMsgByMsgId(j);
        }
        return (ChatMsg) invokeLJ.objValue;
    }

    public static int getUnReadMsgCountByPaid(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65589, null, context, j)) == null) {
            if (BaseManager.isNullContext(context)) {
                return 0;
            }
            return ChatMsgManagerImpl.getInstance(context).getNewMsgCountByPaid(j);
        }
        return invokeLJ.intValue;
    }

    public static int markMsgClicked(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65593, null, context, chatMsg)) == null) {
            if (context != null && chatMsg != null) {
                return ChatMsgManagerImpl.getInstance(context).markMessageClicked(chatMsg);
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static void mediaRegisterChatMsgChangedListener(Context context, IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65608, null, context, iMediaChatMsgChangedListener) == null) {
            ChatMsgManagerImpl.getInstance(context).mediaRegisterChatMsgChangedListener(iMediaChatMsgChangedListener);
        }
    }

    public static void mediaUnRegisterChatMsgChangedListener(Context context, IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65613, null, context, iMediaChatMsgChangedListener) == null) {
            ChatMsgManagerImpl.getInstance(context).mediaUnRegisterChatMsgChangedListener(iMediaChatMsgChangedListener);
        }
    }

    public static void registerConsultMsgNotifyListener(Context context, IChatMsgChangedListener iChatMsgChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65614, null, context, iChatMsgChangedListener) == null) {
            ChatMsgManagerImpl.getInstance(context).registerConsultMsgNotifyListener(iChatMsgChangedListener);
        }
    }

    public static void registerCustomNotifyListener(Context context, ICustomizeNotifyListener iCustomizeNotifyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65615, null, context, iCustomizeNotifyListener) == null) {
            ChatMsgManagerImpl.getInstance(context).registerCustomNotifyListener(iCustomizeNotifyListener);
        }
    }

    public static void registerMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65616, null, context, iMessageReceiveListener) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManagerImpl.getInstance(context).registerMessageReceiveListener(iMessageReceiveListener);
    }

    public static void registerStudioUsePaReceivePaMsg(Context context, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65617, null, context, iLiveMsgReceiveListener) == null) {
            ChatMsgManagerImpl.getInstance(context).registerStudioUsePaReceivePaMsg(iLiveMsgReceiveListener);
        }
    }

    public static int saveAdvisoryDraftMsg(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65619, null, context, chatMsg)) == null) {
            if (context == null) {
                return -1005;
            }
            return ChatMsgManagerImpl.getInstance(context).saveAdvisoryDraftMsg(chatMsg);
        }
        return invokeLL.intValue;
    }

    public static int saveAsDraftMsg(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65620, null, context, chatMsg)) == null) {
            if (context == null) {
                return -1005;
            }
            return ChatMsgManagerImpl.getInstance(context).saveAsDraftMsg(chatMsg);
        }
        return invokeLL.intValue;
    }

    public static void saveMessage(Context context, ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65623, null, context, chatMsg) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManagerImpl.getInstance(context).saveMessage(chatMsg);
    }

    public static void setMediaAllSessionRead(Context context, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65634, null, context, iMediaSetSessionReadListener) == null) {
            mediaSetSessionRead(context, -1L, -1, -1L, "", System.currentTimeMillis(), iMediaSetSessionReadListener);
        }
    }

    public static void unRegisterConsultMsgNotifyListener(Context context, IChatMsgChangedListener iChatMsgChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65640, null, context, iChatMsgChangedListener) == null) {
            ChatMsgManagerImpl.getInstance(context).unRegisterConsultMsgNotifyListener(iChatMsgChangedListener);
        }
    }

    public static void unRegisterCustomNotifyListener(Context context, ICustomizeNotifyListener iCustomizeNotifyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65641, null, context, iCustomizeNotifyListener) == null) {
            ChatMsgManagerImpl.getInstance(context).unRegisterCustomNotifyListener(iCustomizeNotifyListener);
        }
    }

    public static void unregisterMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65642, null, context, iMessageReceiveListener) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManagerImpl.getInstance(context).unregisterMessageReceiveListener(context, iMessageReceiveListener);
    }

    public static void unregisterStudioUsePaReceivePaMsg(Context context, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65643, null, context, iLiveMsgReceiveListener) == null) {
            ChatMsgManagerImpl.getInstance(context).unregisterStudioUsePaReceivePaMsg(iLiveMsgReceiveListener);
        }
    }

    public static ArrayList<ChatMsg> fetchGroupNotifyMsgsSync(Context context, int i, long j, int i2, ChatMsg chatMsg) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), chatMsg})) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatMsgManagerImpl.getInstance(context.getApplicationContext()).fetchGroupNotifyMsgsSync(i, j, i2, false, chatMsg);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public static ArrayList<ChatMsg> fetchMessageSync(Context context, int i, long j, int i2, ChatMsg chatMsg) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), chatMsg})) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i, j, i2, chatMsg);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public static boolean setMsgRead(Context context, int i, long j, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65635, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return false;
            }
            return ChatMsgManagerImpl.getInstance(context).setMsgRead(i, j, j2, z);
        }
        return invokeCommon.booleanValue;
    }

    @Deprecated
    public static ArrayList<ChatMsg> fetchMessageSync(Context context, int i, long j, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i, j, j2, i2);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public static Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState(Context context, int i, long j, int i2, ChatMsg chatMsg) {
        InterceptResult invokeCommon;
        int i3;
        ArrayList<ChatMsg> fetchMessageSync;
        int state;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), chatMsg})) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            if (i2 > 0) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
            }
            boolean z = true;
            if (i == 1) {
                long[] jArr = {1007, 1004};
                ArrayList arrayList = new ArrayList();
                arrayList.add(String.valueOf(j));
                ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(context, arrayList);
                if ((groupInfo == null || groupInfo.size() <= 0 || groupInfo.get(0).getType() != 2) ? false : false) {
                    fetchMessageSync = ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i, j, i3, chatMsg, jArr);
                } else {
                    fetchMessageSync = ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i, j, i3, chatMsg);
                }
                state = SyncGroupMessageService.getInstance().getState(context, j);
            } else {
                fetchMessageSync = ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i, j, i2, chatMsg);
                state = SyncAllMessage.getInstance(context).getState();
            }
            if (fetchMessageSync != null) {
                String str = BaseManager.TAG;
                LogUtils.d(str, "FFF  fetchmessage size " + fetchMessageSync.size());
            }
            return new Pair<>(Integer.valueOf(state), fetchMessageSync);
        }
        return (Pair) invokeCommon.objValue;
    }

    @Deprecated
    public static Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState(Context context, int i, long j, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            ArrayList<ChatMsg> fetchMessageSync = ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i, j, j2, i2);
            ArrayList arrayList = new ArrayList();
            if (fetchMessageSync != null) {
                Iterator<ChatMsg> it = fetchMessageSync.iterator();
                while (it.hasNext()) {
                    ChatMsg next = it.next();
                    if (next.getMsgType() != 1007) {
                        arrayList.add(next);
                    }
                }
            }
            return new Pair<>(Integer.valueOf(SyncAllMessage.getInstance(context).getState()), arrayList);
        }
        return (Pair) invokeCommon.objValue;
    }

    public static void forwardMessage(Context context, String str, int i, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{context, str, Integer.valueOf(i), chatMsg, iSendMessageListener}) == null) {
            if (context == null) {
                if (iSendMessageListener != null) {
                    iSendMessageListener.onSendMessageResult(1005, chatMsg);
                }
            } else if (!TextUtils.isEmpty(str) && chatMsg != null) {
                try {
                    j = Long.parseLong(str);
                } catch (Exception e) {
                    String str2 = BaseManager.TAG;
                    LogUtils.e(str2, "uid parse error " + e.getMessage());
                    j = 0L;
                }
                if (j == 0 && iSendMessageListener != null) {
                    iSendMessageListener.onSendMessageResult(1005, chatMsg);
                }
            } else {
                LogUtils.e(BaseManager.TAG, "uid is null or msg is null");
                if (iSendMessageListener != null) {
                    iSendMessageListener.onSendMessageResult(1005, chatMsg);
                }
            }
        }
    }

    public static void fetchMsgByHostRequst(Context context, long j, int i, long j2, long j3, long j4, int i2, IFetchMsgByIdListener iFetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2), iFetchMsgByIdListener}) == null) {
            fetchMsgByHostRequst(context, j, i, j2, j3, j4, i2, iFetchMsgByIdListener, false);
        }
    }

    public static void fetchPaChatMsgs(Context context, int i, int i2, long j, long j2, long j3, int i3, IFetchMessageListener iFetchMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), iFetchMessageListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).fetchPaChatMsgs(i, i2, j, j2, j3, i3, iFetchMessageListener);
        }
    }

    public static void getBusinessSessionFromServer(Context context, int i, int i2, long j, long j2, long j3, int i3, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65565, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), iMediaGetChatSessionListener}) == null) {
            ChatSessionManagerImpl.getInstance(context).getBusiSessionFromServer(i, i2, j, j2, j3, i3, iMediaGetChatSessionListener);
        }
    }

    public static void mediaDeleteChatMsg(Context context, long j, int i, long j2, String str, long j3, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65596, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), list, iMediaDeleteChatMsgListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).mediaDeleteChatMsg(j, i, j2, str, j3, list, iMediaDeleteChatMsgListener);
        }
    }

    public static void mediaDeleteChatSession(Context context, long j, int i, long j2, String str, long j3, int i2, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65598, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), Integer.valueOf(i2), iMediaDeleteChatSessionListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).mediaDeleteChatSession(j, i, j2, str, j3, i2, iMediaDeleteChatSessionListener);
    }

    public static void sendBusinessImNotifyMsg(Context context, int i, long j, int i2, int i3, int i4, String str, IStatusNotifyListener iStatusNotifyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65624, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, iStatusNotifyListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).sendBusinessImNotifyMsg(i, j, i2, i3, i4, str, iStatusNotifyListener);
        }
    }

    public static void fetchMsgByHostRequst(Context context, long j, int i, long j2, long j3, long j4, int i2, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2), iFetchMsgByIdListener, Boolean.valueOf(z)}) == null) {
            ChatMsgManagerImpl.getInstance(context).fetchMsgByHostRequst(j, i, j2, j3, j4, i2, iFetchMsgByIdListener, z);
        }
    }

    public static void fetchMsgRequst(Context context, long j, long j2, int i, long j3, long j4, long j5, int i2, IFetchMsgByIdListener iFetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i2), iFetchMsgByIdListener}) == null) {
            fetchMsgRequst(context, j, j2, i, j3, j4, j5, i2, iFetchMsgByIdListener, false, false);
        }
    }

    public static void mediaFetchChatMsgs(Context context, long j, int i, long j2, String str, long j3, long j4, int i2, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65600, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2), iMediaFetchChatMsgsListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).mediaFetchChatMsgs(context, j, i, j2, str, j3, j4, i2, iMediaFetchChatMsgsListener);
        }
    }

    public static void mediaGetChatSessions(Context context, long j, int i, long j2, String str, long j3, int i2, int i3, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65602, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), iMediaGetChatSessionListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).mediaGetChatSessions(j, i, j2, str, j3, i2, i3, iMediaGetChatSessionListener);
    }

    public static void fetchMsgRequest(Context context, long j, long j2, int i, long j3, long j4, long j5, int i2, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z, boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i2), iFetchMsgByIdListener, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            ChatMsgManagerImpl.getInstance(context).fetchMsgRequst(j, j2, i, j3, j4, j5, i2, iFetchMsgByIdListener, z, z2, i3);
        }
    }

    public static void fetchMsgRequst(Context context, long j, long j2, int i, long j3, long j4, long j5, int i2, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i2), iFetchMsgByIdListener, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ChatMsgManagerImpl.getInstance(context).fetchMsgRequst(j, j2, i, j3, j4, j5, i2, iFetchMsgByIdListener, z, z2, 0);
        }
    }

    public static void fetchMsgidByMsgid(Context context, int i, long j, long j2, long j3, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), iFetchMsgByIdListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).fetchMsgidByMsgid(context, i, j, j2, j3, -1L, -1L, "", i2, i3, 0, iFetchMsgByIdListener);
        }
    }

    public static void genBosObjectUrl(Context context, String str, String str2, String str3, int i, int i2, int i3, IGenBosObjectUrlListener iGenBosObjectUrlListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{context, str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iGenBosObjectUrlListener}) == null) {
            if (context != null && !TextUtils.isEmpty(str) && new File(str).exists()) {
                ChatMsgManagerImpl.getInstance(context).genBosObjectUrl(str, str2, str3, i, i2, i3, iGenBosObjectUrlListener);
            } else if (iGenBosObjectUrlListener != null) {
                iGenBosObjectUrlListener.onGenBosObjectUrlListener(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null, null, null);
            }
        }
    }

    public static void forwardMessage(Context context, long j, long j2, int i, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), chatMsg, iSendMessageListener}) == null) {
            if (context != null && chatMsg != null) {
                if (AccountManager.isLogin(context) && !AccountManager.isCuidLogin(context)) {
                    if (AccountManager.getMediaRole(context)) {
                        ChatMsgManagerImpl.getInstance(context).meidaForwardMessage(j, j2, i, chatMsg, iSendMessageListener);
                    } else {
                        ChatMsgManagerImpl.getInstance(context).forwardMessage(j, j2, i, chatMsg, iSendMessageListener);
                    }
                } else if (iSendMessageListener != null) {
                    iSendMessageListener.onSendMessageResult(1000, chatMsg);
                }
            } else if (iSendMessageListener != null) {
                iSendMessageListener.onSendMessageResult(1005, chatMsg);
            }
        }
    }

    public static ChatMsg generateMsg(long j, @NonNull ChatMsg chatMsg) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65560, null, j, chatMsg)) == null) {
            TextMsg textMsg = new TextMsg();
            textMsg.setMsgType(81);
            textMsg.setMsgKey(chatMsg.getMsgKey());
            textMsg.setCategory(4);
            textMsg.setContacter(j);
            textMsg.setLocalUrl(chatMsg.getLocalUrl());
            textMsg.setMsgId(chatMsg.getMsgId());
            textMsg.setSendMsgId(chatMsg.getSendMsgId());
            textMsg.setMsgTime(chatMsg.getMsgTime());
            textMsg.setFromUser(chatMsg.getFromUser());
            textMsg.setNickName(chatMsg.getNickName());
            textMsg.setPortrait(chatMsg.getPortrait());
            textMsg.setAtUserList(chatMsg.getAtUserList());
            textMsg.setReMsgInfo(chatMsg.getReMsgInfo());
            textMsg.setChatRoomContentExt(chatMsg.getChatRoomContentExt());
            return textMsg;
        }
        return (ChatMsg) invokeJL.objValue;
    }

    public static String getAdvisoryDraftStr(Context context, int i, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            if (context == null) {
                return null;
            }
            return ChatMsgManagerImpl.getInstance(context).getAdvisoryDraftStr(i, j, i2);
        }
        return (String) invokeCommon.objValue;
    }

    public static void getChatPageBottomMenu(Context context, long j, int i, IMGetBottomMenuListener iMGetBottomMenuListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65568, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iMGetBottomMenuListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).getChatPageBottomMenuRequest(j, i, iMGetBottomMenuListener);
        }
    }

    public static void mediaContactorSetting(Context context, long j, int i, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65595, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iMediaContactorSettingListener}) == null) {
            ChatSessionManagerImpl.getInstance(context).mediaContactorSetting(j, i, iMediaContactorSettingListener);
        }
    }

    public static void mediaDeleteChatSession(Context context, long j, long j2, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65599, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), iMediaDeleteChatSessionListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).mediaDeleteChatSession(j, j2, iMediaDeleteChatSessionListener);
    }

    public static void mediaGetContactorSetting(Context context, long j, int i, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65607, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iMediaContactorSettingListener}) == null) {
            ChatSessionManagerImpl.getInstance(context).mediaGetContactorSetting(j, i, iMediaContactorSettingListener);
        }
    }

    public static void mediaSetSessionRead(Context context, long j, long j2, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65612, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), iMediaSetSessionReadListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).mediaSetSessionRead(j, j2, iMediaSetSessionReadListener);
    }

    public static boolean setAllMsgRead(Context context, int i, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65630, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return false;
            }
            return ChatMsgManagerImpl.getInstance(context).setAllMsgRead(i, j, z);
        }
        return invokeCommon.booleanValue;
    }

    public static void showSendMsgPV(Context context, long j, long j2, IShowSendMsgPVListener iShowSendMsgPVListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65639, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), iShowSendMsgPVListener}) == null) {
            if (context == null) {
                if (iShowSendMsgPVListener != null) {
                    iShowSendMsgPVListener.onResult(0);
                    return;
                }
                return;
            }
            ChatMsgManagerImpl.getInstance(context).showSendMsgPV(j, j2, iShowSendMsgPVListener);
        }
    }

    public static ArrayList<SessionClass> getAllClassType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            return ChatSessionManagerImpl.getInstance(context.getApplicationContext()).getAllClassType();
        }
        return (ArrayList) invokeL.objValue;
    }

    public static ArrayList<ChatSession> getChatRecords(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatSessionManagerImpl.getInstance(context).getChatRecords(0L, 0L);
        }
        return (ArrayList) invokeL.objValue;
    }

    public static List<ChatSession> getGroupSession(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, context)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatSessionManagerImpl.getInstance(context.getApplicationContext()).getGroupSession();
        }
        return (List) invokeL.objValue;
    }

    public static int getNewMsgCount(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            if (context == null || !AccountManager.isLogin(context)) {
                return -1;
            }
            return ChatMsgManagerImpl.getInstance(context).getNewMsgCount();
        }
        return invokeL.intValue;
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65591, null, context) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManagerImpl.getInstance(context);
        ChatSessionManagerImpl.getInstance(context);
    }

    public static void getBusiAdvCustomMsgByMsgId(Context context, long j, IAdvisoryCustomMsgGetListener iAdvisoryCustomMsgGetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{context, Long.valueOf(j), iAdvisoryCustomMsgGetListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).getBusiAdvCustomMsgByMsgId(j, iAdvisoryCustomMsgGetListener);
        }
    }

    public static void getBusinessAdvAdShowInfoByUK(Context context, String str, IAdvisoryAdBtnShowGetListener iAdvisoryAdBtnShowGetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65564, null, context, str, iAdvisoryAdBtnShowGetListener) == null) {
            ChatMsgManagerImpl.getInstance(context).getBusinessAdvAdShowInfoByUK(str, iAdvisoryAdBtnShowGetListener);
        }
    }

    public static List<ChatMsg> getPaMsgByChatType(Context context, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65582, null, context, i, i2)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatMsgManagerImpl.getInstance(context).getPaMsgByChatType(i, i2);
        }
        return (List) invokeLII.objValue;
    }

    public static void getToastShowing(Context context, String str, IShowingToastListener iShowingToastListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65586, null, context, str, iShowingToastListener) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                ChatMsgManagerImpl.getInstance(context).getToastShowing(str, iShowingToastListener);
            } else if (iShowingToastListener != null) {
                iShowingToastListener.onResult(false);
            }
        }
    }

    public static void mediaGetContactorPauid(Context context, long j, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65605, null, new Object[]{context, Long.valueOf(j), iMediaGetContactorPauidListener}) == null) {
            ChatSessionManagerImpl.getInstance(context).mediaGetContactorPauid(j, iMediaGetContactorPauidListener);
        }
    }

    public static void saveBusinessAdvAdShowInfo(Context context, AdvAdBtnShowInfo advAdBtnShowInfo, IAdvisoryAdBtnShowSaveListener iAdvisoryAdBtnShowSaveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65621, null, context, advAdBtnShowInfo, iAdvisoryAdBtnShowSaveListener) == null) {
            ChatMsgManagerImpl.getInstance(context).saveBusinessAdvAdShowInfo(advAdBtnShowInfo, iAdvisoryAdBtnShowSaveListener);
        }
    }

    public static void saveBusinessAdvCustomMsg(Context context, ChatAdvCustomMsg chatAdvCustomMsg, IAdvisoryCustomMsgSaveListener iAdvisoryCustomMsgSaveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65622, null, context, chatAdvCustomMsg, iAdvisoryCustomMsgSaveListener) == null) {
            ChatMsgManagerImpl.getInstance(context).replaceBusinessAdvCustomMsg(chatAdvCustomMsg, iAdvisoryCustomMsgSaveListener);
        }
    }

    public static void sendChatMsgByHostRequest(Context context, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65625, null, context, chatMsg, iSendMessageListener) == null) {
            ChatMsgManagerImpl.getInstance(context).sendChatMsgByHostRequest(chatMsg, iSendMessageListener);
        }
    }

    public static void sendMessage(Context context, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65626, null, context, chatMsg, iSendMessageListener) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        if (chatMsg == null) {
            if (iSendMessageListener != null) {
                iSendMessageListener.onSendMessageResult(1005, chatMsg);
                return;
            }
            return;
        }
        ChatMsgManagerImpl.getInstance(context).sendMessage(chatMsg, iSendMessageListener);
    }

    public static boolean setMsgReadByChatTpyes(Context context, List<Integer> list, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65636, null, new Object[]{context, list, Long.valueOf(j)})) == null) {
            return ChatMsgManagerImpl.getInstance(context).setMsgReadByChatTpyes(list, j);
        }
        return invokeCommon.booleanValue;
    }

    public static long updateLocalChatMsgByBusiness(Context context, int i, List<ChatMsg> list) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65644, null, context, i, list)) == null) {
            if (context == null || list == null || list.size() == 0 || AccountManager.isCuidLogin(context)) {
                return -1L;
            }
            return ChatMsgManagerImpl.getInstance(context).updateLocalChatMsgByBusiness(i, list);
        }
        return invokeLIL.longValue;
    }

    public static void getChatMsgsByBusiness(Context context, int i, int i2, int i3, long j, long j2, long j3, int i4, long j4, long j5, String str, String str2, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i4), Long.valueOf(j4), Long.valueOf(j5), str, str2, iMediaFetchChatMsgsListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).getChatMsgsByBusiness(i, i2, i3, j, j2, j3, i4, j4, j5, str, str2, iMediaFetchChatMsgsListener);
        }
    }

    public static void getChatMsgsByBusinessByHostRequest(Context context, int i, int i2, int i3, long j, long j2, long j3, int i4, String str, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65567, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i4), str, iMediaFetchChatMsgsListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).getChatMsgsByBusinessByHostRequest(i, i2, i3, j, j2, j3, i4, str, iMediaFetchChatMsgsListener);
        }
    }

    public static String getMsgContent(long j, String str, @NonNull ChatMsg chatMsg, IChatRoomEnterListener.UserInfo userInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65577, null, new Object[]{Long.valueOf(j), str, chatMsg, userInfo})) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("room_id", "" + j);
                jSONObject2.put("type", "0");
                jSONObject2.put("to_uid", "0");
                jSONObject2.put("vip", "0");
                if (userInfo != null) {
                    jSONObject2.put("character", "" + userInfo.character);
                    jSONObject2.put("character_name", userInfo.characterName);
                }
                jSONObject2.put("name", chatMsg.getNickName());
                jSONObject2.put("portrait", chatMsg.getPortrait());
                jSONObject2.put("content_type", "" + chatMsg.getMsgType());
                String str2 = BaseManager.TAG;
                LogUtils.e(str2, " content_body :" + chatMsg.getMsgContent() + ", msg :" + chatMsg.toString());
                jSONObject2.put("content_body", chatMsg.getMsgContent());
                jSONObject2.put("src", "");
                jSONObject2.put("baidu_uk", str);
                jSONObject2.put("ext", chatMsg.getChatRoomContentExt());
                if (chatMsg.getAtUserList() != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (IChatRoomEnterListener.AtUserInfo atUserInfo : chatMsg.getAtUserList()) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("at_type", atUserInfo.atType);
                        jSONObject3.put("at_baidu_uk", atUserInfo.atBdUk);
                        jSONObject3.put("at_name", atUserInfo.atName);
                        jSONObject3.put("at_portrait", atUserInfo.atPortrait);
                        jSONObject3.put("at_vip", atUserInfo.atVip);
                        jSONObject3.put("at_character", atUserInfo.atCharacter);
                        jSONObject3.put("at_character_name", atUserInfo.atCharacterName);
                        jSONObject3.put(CriusAttrConstants.POSITION, atUserInfo.atPosition);
                        jSONArray.put(jSONObject3);
                    }
                    jSONObject2.put("at_data", jSONArray);
                }
                IChatRoomEnterListener.ReMsgInfo reMsgInfo = chatMsg.getReMsgInfo();
                if (reMsgInfo != null) {
                    try {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("re_msg_id", reMsgInfo.msgId);
                        jSONObject4.put("re_nickname", reMsgInfo.nickName);
                        jSONObject4.put("re_baidu_uk", reMsgInfo.bdUk);
                        jSONObject4.put("re_ext", reMsgInfo.ext);
                        jSONObject4.put("re_content_type", reMsgInfo.msgType);
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("url", reMsgInfo.url);
                        jSONObject5.put("text", reMsgInfo.content);
                        jSONObject4.put("re_content_body", jSONObject5.toString());
                        jSONObject2.put("re_data", jSONObject4);
                    } catch (JSONException e) {
                        LogUtils.e(BaseManager.TAG, "re_data ", e);
                    }
                }
                jSONObject.put("text", jSONObject2.toString());
            } catch (Exception e2) {
                LogUtils.e(BaseManager.TAG, "getMcastContent ", e2);
            }
            String jSONObject6 = jSONObject.toString();
            String str3 = BaseManager.TAG;
            LogUtils.d(str3, "getMcastContent :" + jSONObject6);
            return jSONObject6;
        }
        return (String) invokeCommon.objValue;
    }

    public static void getNotificationMsgDataList(Context context, SparseArray<List<Integer>> sparseArray, long j, int i, IFetchNotificationDataListener iFetchNotificationDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65580, null, new Object[]{context, sparseArray, Long.valueOf(j), Integer.valueOf(i), iFetchNotificationDataListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).getNotificationMsgDataList(sparseArray, j, i, iFetchNotificationDataListener);
        }
    }

    public static void getNotificationMsgsByTopicSource(Context context, long j, boolean z, String str, IFetchNotificationDataListener iFetchNotificationDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65581, null, new Object[]{context, Long.valueOf(j), Boolean.valueOf(z), str, iFetchNotificationDataListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).getNotificationMsgsByTopicSource(j, z, str, iFetchNotificationDataListener);
        }
    }

    public static void getPaNewMsgCount(Context context, int i, int i2, long j, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65585, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), iGetNewMsgCountListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).getPaNewMsgCount(i, i2, j, iGetNewMsgCountListener);
        }
    }

    public static void loadGroupMessages(Context context, long j, ChatMsg chatMsg, int i, IFetchHistoryMsgListener iFetchHistoryMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65592, null, new Object[]{context, Long.valueOf(j), chatMsg, Integer.valueOf(i), iFetchHistoryMsgListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).fetchHistoryMessage(context, j, chatMsg, i, iFetchHistoryMsgListener);
        }
    }

    public static void mediaDeleteChatMsg(Context context, long j, long j2, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65597, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), list, iMediaDeleteChatMsgListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).mediaDeleteChatMsg(j, j2, list, iMediaDeleteChatMsgListener);
        }
    }

    public static void mediaGetChatSessions(Context context, long j, long j2, int i, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65603, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), iMediaGetChatSessionListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).mediaGetChatSessions(j, j2, i, iMediaGetChatSessionListener);
    }

    public static void resendMsg(Context context, String str, String str2, int i, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65618, null, new Object[]{context, str, str2, Integer.valueOf(i), iSendMessageListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).resendMsg(str, str2, i, iSendMessageListener);
        }
    }

    public static void sendMsgToChatRoom(Context context, long j, String str, @NonNull ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65628, null, new Object[]{context, Long.valueOf(j), str, chatMsg, iSendMessageListener}) == null) {
            ChatMsg generateMsg = generateMsg(j, chatMsg);
            generateMsg.setMsgContent(getMsgContent(j, str, chatMsg, null));
            sendMessage(context, generateMsg, iSendMessageListener);
        }
    }

    public static void setInterActiveMsgStatus(Context context, long j, long j2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65633, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            ChatMsgManagerImpl.getInstance(context).setInterActiveMsgStatus(j, j2, i, i2);
        }
    }

    public static List<ChatMsg> getPaMsgByChatType(Context context, List<Integer> list, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65583, null, context, list, i)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatMsgManagerImpl.getInstance(context).getPaMsgByChatType(list, i);
        }
        return (List) invokeLLI.objValue;
    }

    public static int getTotalUnReadMsgCountByAdvisory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65587, null, context)) == null) {
            int i = 0;
            if (BaseManager.isNullContext(context)) {
                return 0;
            }
            List<PaInfo> queryPaInfoByExt = PaInfoDBManager.getInstance(context).queryPaInfoByExt(String.valueOf(27));
            if (queryPaInfoByExt != null && !queryPaInfoByExt.isEmpty()) {
                for (PaInfo paInfo : queryPaInfoByExt) {
                    if (paInfo != null && paInfo.getPaId() > 0) {
                        i += getUnReadMsgCountByPaid(context, paInfo.getPaId());
                    }
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static void mediaGetContactorPauid(Context context, long j, int i, long j2, String str, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65604, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, iMediaGetContactorPauidListener}) == null) {
            ChatSessionManagerImpl.getInstance(context).mediaGetContactorPauid(j, i, j2, str, iMediaGetContactorPauidListener);
        }
    }

    public static void uploadBottomMenuEvent(Context context, long j, int i, String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65645, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), str, Long.valueOf(j2), str2}) == null) {
            ChatMsgManagerImpl.getInstance(context).uploadBottomMenuEventRequest(j, i, str, j2, str2);
        }
    }

    public static void mediaSendChatMsg(Context context, long j, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65610, null, new Object[]{context, Long.valueOf(j), chatMsg, iMediaSendChatMsgListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).mediaSendChatMsg(j, chatMsg, iMediaSendChatMsgListener);
        }
    }

    public static void setBusinessAdvAdShowClickedInfoByUK(Context context, String str, boolean z, IAdvisoryAdBtnShowSaveListener iAdvisoryAdBtnShowSaveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65631, null, new Object[]{context, str, Boolean.valueOf(z), iAdvisoryAdBtnShowSaveListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).setBusinessAdvAdShowClickedInfoByUK(str, z, iAdvisoryAdBtnShowSaveListener);
        }
    }

    public static boolean setMsgReadByChatTypeAndSubType(Context context, SparseArray<List<Integer>> sparseArray, long j, ISetMessageReadListener iSetMessageReadListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65637, null, new Object[]{context, sparseArray, Long.valueOf(j), iSetMessageReadListener})) == null) {
            return ChatMsgManagerImpl.getInstance(context).setMsgReadByChatTypeAndSubType(sparseArray, j, iSetMessageReadListener);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean setMsgReadByMsgId(Context context, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65638, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            if (i != 1 && i != 0) {
                String str = BaseManager.TAG;
                LogUtils.d(str, "return!!! for setMsgReadByMsgId...setType=" + i);
                return false;
            }
            ChatMsg msgByMsgId = getMsgByMsgId(context, j);
            if (msgByMsgId != null) {
                String str2 = BaseManager.TAG;
                LogUtils.d(str2, "setMsgReadByMsgId...msg=" + msgByMsgId.toString());
                int category = msgByMsgId.getCategory();
                if (category != 0) {
                    return false;
                }
                if (msgByMsgId.isMsgRead()) {
                    return true;
                }
                long contacter = msgByMsgId.getContacter();
                boolean isZhida = msgByMsgId.isZhida();
                if (i == 0) {
                    return setAllMsgRead(context, category, contacter, isZhida);
                }
                if (i == 1) {
                    return setMsgRead(context, category, contacter, j, isZhida);
                }
            }
            LogUtils.d(BaseManager.TAG, "setMsgReadByMsgId...msg=NULL !!!");
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
