package com.baidu.android.imsdk.chatmessage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.IKickOutListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.sync.SyncAllMessage;
import com.baidu.android.imsdk.chatmessage.sync.SyncGroupMessageService;
import com.baidu.android.imsdk.chatuser.ChatUserManager;
import com.baidu.android.imsdk.chatuser.IGetUkByBuidListener;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.notification.IFetchNotificationDataListener;
import com.baidu.android.imsdk.upload.FileUploadTask;
import com.baidu.android.imsdk.upload.IFileUploadListener;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ChatMsgManager extends BaseManager {
    public static void init(Context context) {
        if (!isNullContext(context)) {
            ChatMsgManagerImpl.getInstance(context);
            ChatSessionManagerImpl.getInstance(context);
        }
    }

    public static void sendMessage(Context context, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        if (!isNullContext(context)) {
            if (chatMsg == null) {
                if (iSendMessageListener != null) {
                    iSendMessageListener.onSendMessageResult(1005, chatMsg);
                    return;
                }
                return;
            }
            ChatMsgManagerImpl.getInstance(context).sendMessage(chatMsg, iSendMessageListener);
        }
    }

    public static void forwardMessage(final Context context, final String str, int i, final ChatMsg chatMsg, final ISendMessageListener iSendMessageListener) {
        long j;
        long j2;
        if (TextUtils.isEmpty(str) || chatMsg == null) {
            LogUtils.e(TAG, "uid is null or msg is null");
            if (iSendMessageListener != null) {
                iSendMessageListener.onSendMessageResult(1005, chatMsg);
                return;
            }
            return;
        }
        try {
            j = Long.parseLong(str);
        } catch (Exception e) {
            LogUtils.e(TAG, "uid parse error " + e.getMessage());
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
            j = 0;
        }
        if (j == 0) {
            if (iSendMessageListener != null) {
                iSendMessageListener.onSendMessageResult(1005, chatMsg);
            }
        } else if (i == 0) {
            ChatUserManager.getUKbyBuid(context, j, new IGetUkByBuidListener() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManager.1
                @Override // com.baidu.android.imsdk.chatuser.IGetUkByBuidListener
                public void onFetchUk(int i2, long j3, long j4) {
                    ChatMsg.this.setRowId(-1L);
                    ChatMsg.this.setCategory(0);
                    ChatMsg.this.setContacter(j4);
                    ChatMsg.this.setFromUser(AccountManager.getUK(context));
                    ChatMsg.this.setStatus(1);
                    ChatMsg.this.setSenderUid(AccountManager.getUid(context));
                    ChatMsg.this.setContacterBduid(str);
                    ChatMsg.this.setIsZhida(false);
                    ChatMsg.this.setChatType(0);
                    ChatMsg.this.setMsgTime(System.currentTimeMillis());
                    ChatMsg.this.parseForwardmessage(0);
                    ChatMsgManager.sendMessage(context, ChatMsg.this, iSendMessageListener);
                }
            });
        } else if (i == 1) {
            try {
                j2 = Long.valueOf(str).longValue();
            } catch (NumberFormatException e2) {
                LogUtils.e(TAG, "id is not long type!!");
                new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
                j2 = -1;
            }
            chatMsg.setRowId(-1L);
            chatMsg.setCategory(i);
            chatMsg.setContacter(j2);
            chatMsg.setFromUser(AccountManager.getUK(context));
            chatMsg.setStatus(1);
            chatMsg.setSenderUid(AccountManager.getUid(context));
            chatMsg.setChatType(3);
            chatMsg.setMsgTime(System.currentTimeMillis());
            chatMsg.parseForwardmessage(i);
            sendMessage(context, chatMsg, iSendMessageListener);
        }
    }

    public static void registerMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        if (!isNullContext(context)) {
            ChatMsgManagerImpl.getInstance(context).registerMessageReceiveListener(iMessageReceiveListener);
        }
    }

    public static void unregisterMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        if (!isNullContext(context)) {
            ChatMsgManagerImpl.getInstance(context).unregisterMessageReceiveListener(context, iMessageReceiveListener);
        }
    }

    @Deprecated
    public static ArrayList<ChatMsg> fetchMessageSync(Context context, int i, long j, long j2, int i2) {
        if (isNullContext(context)) {
            return null;
        }
        return ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i, j, j2, i2);
    }

    public static ArrayList<ChatMsg> fetchMessageSync(Context context, int i, long j, int i2, ChatMsg chatMsg) {
        if (isNullContext(context)) {
            return null;
        }
        return ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i, j, i2, chatMsg);
    }

    @Deprecated
    public static Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState(Context context, int i, long j, long j2, int i2) {
        if (isNullContext(context)) {
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

    public static Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState(Context context, int i, long j, int i2, ChatMsg chatMsg) {
        ArrayList<ChatMsg> fetchMessageSync;
        int state;
        ArrayList<ChatMsg> fetchMessageSync2;
        if (isNullContext(context)) {
            return null;
        }
        if (i == 1) {
            long[] jArr = {1007, 1004};
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.valueOf(j));
            ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(context, arrayList);
            if (groupInfo != null && groupInfo.size() > 0 && groupInfo.get(0).getType() == 2) {
                fetchMessageSync2 = ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i, j, i2, chatMsg, jArr);
            } else {
                fetchMessageSync2 = ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i, j, i2, chatMsg);
            }
            state = SyncGroupMessageService.getInstance().getState(context, j);
            fetchMessageSync = fetchMessageSync2;
        } else {
            fetchMessageSync = ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i, j, i2, chatMsg);
            state = SyncAllMessage.getInstance(context).getState();
        }
        if (fetchMessageSync != null) {
            LogUtils.d(TAG, "FFF  fetchmessage size " + fetchMessageSync.size());
        }
        return new Pair<>(Integer.valueOf(state), fetchMessageSync);
    }

    @Deprecated
    public static long getNewMsgNum(Context context, int i, long j) {
        if (isNullContext(context)) {
            return -1L;
        }
        return ChatMsgManagerImpl.getInstance(context).getNewMsgNum(i, j);
    }

    @Deprecated
    public static long getUnReadMsgCount(Context context, int i, long j) {
        if (isNullContext(context)) {
            return -1L;
        }
        return ChatMsgManagerImpl.getInstance(context).getNewMsgNum(i, j);
    }

    public static int getUnReadMsgCountByPaid(Context context, long j) {
        if (isNullContext(context)) {
            return 0;
        }
        return ChatMsgManagerImpl.getInstance(context).getNewMsgCountByPaid(j);
    }

    public static boolean setMsgRead(Context context, int i, long j, long j2, boolean z) {
        if (isNullContext(context)) {
            return false;
        }
        return ChatMsgManagerImpl.getInstance(context).setMsgRead(i, j, j2, z);
    }

    public static boolean setAllMsgRead(Context context, int i, long j, boolean z) {
        if (isNullContext(context)) {
            return false;
        }
        return ChatMsgManagerImpl.getInstance(context).setAllMsgRead(i, j, z);
    }

    public static boolean setMsgReadByChatTpyes(Context context, List<Integer> list, long j) {
        return ChatMsgManagerImpl.getInstance(context).setMsgReadByChatTpyes(list, j);
    }

    @Deprecated
    public static long getTotalNewMsgNum(Context context) {
        if (isNullContext(context)) {
            return 0L;
        }
        return ChatMsgManagerImpl.getInstance(context).getNewMsgCount();
    }

    public static void registerKillOutListener(Context context, IKickOutListener iKickOutListener) {
        if (!isNullContext(context)) {
            ChatMsgManagerImpl.getInstance(context).registerKillOutListener(iKickOutListener);
        }
    }

    public static void clearKillOutListener(Context context) {
        if (!isNullContext(context)) {
            ChatMsgManagerImpl.getInstance(context).clearKillOutListener();
        }
    }

    public static void registerChatSessionListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        if (!isNullContext(context)) {
            ChatSessionManagerImpl.getInstance(context).registerRecordChangeListener(context, iChatSessionChangeListener);
        }
    }

    public static ArrayList<ChatSession> getChatRecords(Context context, long j, long j2) {
        LogUtils.enter();
        if (isNullContext(context)) {
            return null;
        }
        return ChatSessionManagerImpl.getInstance(context).getChatRecords(j, j2);
    }

    public static void saveMessage(Context context, ChatMsg chatMsg) {
        if (!isNullContext(context)) {
            ChatMsgManagerImpl.getInstance(context).saveMessage(chatMsg);
        }
    }

    public static ArrayList<ChatSession> getChatRecords(Context context) {
        if (isNullContext(context)) {
            return null;
        }
        return ChatSessionManagerImpl.getInstance(context).getChatRecords(0L, 0L);
    }

    public static ArrayList<ChatSession> getChatRecords(Context context, List<Integer> list) {
        if (isNullContext(context)) {
            return null;
        }
        return ChatSessionManagerImpl.getInstance(context).getChatRecords(0L, 0L, list);
    }

    public static ArrayList<ChatSession> getChatRecordsByClass(Context context, List<Integer> list) {
        if (isNullContext(context)) {
            return null;
        }
        return ChatSessionManagerImpl.getInstance(context).getChatRecordsByClass(0L, 0L, list);
    }

    public static List<ChatMsg> getPaMsgByChatType(Context context, int i, int i2) {
        if (isNullContext(context)) {
            return null;
        }
        return ChatMsgManagerImpl.getInstance(context).getPaMsgByChatType(i, i2);
    }

    public static void getPaMsgByChatTypeAndPaidList(Context context, List<Integer> list, List<Long> list2, long j, int i, IFetchNotificationDataListener iFetchNotificationDataListener) {
        if (!isNullContext(context)) {
            ChatMsgManagerImpl.getInstance(context).getPaMsgByChatTypeAndPaidList(list, list2, j, i, iFetchNotificationDataListener);
        }
    }

    public static void unregisterChatSessionListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        if (!isNullContext(context)) {
            ChatSessionManagerImpl.getInstance(context).unregisterMessageReceiveListener(context, iChatSessionChangeListener);
        }
    }

    public static void createChatSession(Context context, ChatObject chatObject, String str, int i, String str2, int i2, String str3, String str4, int i3, int i4, long j, int i5, long j2, String str5, String str6, String str7) {
        ChatSessionManagerImpl.getInstance(context).createChatSession(chatObject, str, i, str2, i2, str3, str4, i3, i4, j, i5, j2, str5, str6, str7);
    }

    public static int saveAsDraftMsg(Context context, ChatMsg chatMsg) {
        if (context == null) {
            return -1005;
        }
        return ChatMsgManagerImpl.getInstance(context).saveAsDraftMsg(chatMsg);
    }

    public static int deleteDraftMsg(Context context, int i, long j) {
        if (context == null) {
            return -1005;
        }
        return ChatMsgManagerImpl.getInstance(context).deleteDraftMsg(i, j);
    }

    public static ChatMsg getDraftMsg(Context context, int i, long j) {
        if (context == null) {
            return null;
        }
        return ChatMsgManagerImpl.getInstance(context).getDraftMsg(i, j);
    }

    public static int deleteMsg(Context context, ChatMsg chatMsg) {
        if (context == null || chatMsg == null) {
            return -1;
        }
        return ChatMsgManagerImpl.getInstance(context).deleteMsgs(chatMsg);
    }

    public static int getNewMsgCount(Context context) {
        if (context != null && AccountManager.isLogin(context)) {
            return ChatMsgManagerImpl.getInstance(context).getNewMsgCount();
        }
        return -1;
    }

    public static void genBosObjectUrl(Context context, String str, String str2, String str3, int i, int i2, int i3, IGenBosObjectUrlListener iGenBosObjectUrlListener) {
        if (context == null || TextUtils.isEmpty(str) || !new File(str).exists()) {
            if (iGenBosObjectUrlListener != null) {
                iGenBosObjectUrlListener.onGenBosObjectUrlListener(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null, null, null);
                return;
            }
            return;
        }
        ChatMsgManagerImpl.getInstance(context).genBosObjectUrl(str, str2, str3, i, i2, i3, iGenBosObjectUrlListener);
    }

    public static void audioTrans(Context context, String str, String str2, String str3, int i, BIMValueCallBack bIMValueCallBack) {
        if (context == null || TextUtils.isEmpty(str) || !new File(str).exists()) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
                return;
            }
            return;
        }
        ChatMsgManagerImpl.getInstance(context).audioTrans(str, str2, str3, i, bIMValueCallBack);
    }

    public static void uploadFile(Context context, String str, String str2, String str3, String str4, String str5, IFileUploadListener iFileUploadListener) {
        if (context == null || TextUtils.isEmpty(str2) || !new File(str2).exists()) {
            if (iFileUploadListener != null) {
                iFileUploadListener.onFailed(1005, Constants.ERROR_MSG_PARAMETER_ERROR);
                return;
            }
            return;
        }
        new FileUploadTask(context, str, str2, str3, str4, str5, iFileUploadListener).execute(new Void[0]);
    }

    public static int markMsgClicked(Context context, ChatMsg chatMsg) {
        if (context == null || chatMsg == null) {
            return -1;
        }
        return ChatMsgManagerImpl.getInstance(context).markMessageClicked(chatMsg);
    }

    public static boolean deleteChatSession(Context context, ChatSession chatSession) {
        if (context == null || chatSession == null) {
            return false;
        }
        return ChatSessionManagerImpl.getInstance(context).deleteChatSession(chatSession);
    }

    public static boolean deleteAllMsgs(Context context, int i, long j) {
        return context != null && Utility.isCategoryCorrect(i) && Utility.isContacterCorrect(j) && ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(i, j, false) >= 0;
    }

    public static ChatSession getChatSession(Context context, int i, long j) {
        return ChatSessionManagerImpl.getInstance(context).getChatRecord(i, j);
    }

    public static ChatSession getChatSession(Context context, int i, long j, long j2) {
        return ChatSessionManagerImpl.getInstance(context).getChatRecord(i, j, j2);
    }

    public static int hideAllChatSession(Context context) {
        return ChatSessionManagerImpl.getInstance(context).hideAllChatSession();
    }

    public static List<ChatSession> getGroupSession(Context context) {
        if (isNullContext(context)) {
            return null;
        }
        return ChatSessionManagerImpl.getInstance(context.getApplicationContext()).getGroupSession();
    }

    public static ArrayList<ChatMsg> fetchGroupNotifyMsgsSync(Context context, int i, long j, int i2, ChatMsg chatMsg) {
        if (isNullContext(context)) {
            return null;
        }
        return ChatMsgManagerImpl.getInstance(context.getApplicationContext()).fetchGroupNotifyMsgsSync(i, j, i2, false, chatMsg);
    }

    public static ArrayList<SessionClass> getAllClassType(Context context) {
        return ChatSessionManagerImpl.getInstance(context.getApplicationContext()).getAllClassType();
    }

    public static void resendMsg(Context context, String str, String str2, int i, ISendMessageListener iSendMessageListener) {
        ChatMsgManagerImpl.getInstance(context).resendMsg(str, str2, i, iSendMessageListener);
    }

    public static void fetchMsgidByMsgid(Context context, int i, long j, long j2, long j3, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener) {
        ChatMsgManagerImpl.getInstance(context).fetchMsgidByMsgid(context, i, j, j2, j3, i2, i3, 0, iFetchMsgByIdListener);
    }

    public static void fetchMsgRequst(Context context, long j, long j2, int i, long j3, long j4, long j5, int i2, IFetchMsgByIdListener iFetchMsgByIdListener) {
        ChatMsgManagerImpl.getInstance(context).fetchMsgRequst(j, j2, i, j3, j4, j5, i2, iFetchMsgByIdListener);
    }

    public static void fetchMsgByHostRequst(Context context, long j, long j2, int i, long j3, long j4, long j5, int i2, IFetchMsgByIdListener iFetchMsgByIdListener) {
        ChatMsgManagerImpl.getInstance(context).fetchMsgByHostRequst(j, j2, i, j3, j4, j5, i2, iFetchMsgByIdListener);
    }

    public static void setInterActiveMsgStatus(Context context, long j, long j2, int i, int i2) {
        ChatMsgManagerImpl.getInstance(context).setInterActiveMsgStatus(j, j2, i, i2);
    }

    public static boolean updateChatMsg(Context context, ChatMsg chatMsg) {
        return ChatMsgManagerImpl.getInstance(context).updateMsgContent(chatMsg);
    }

    public static ChatMsg getMsgByMsgId(Context context, long j) {
        return ChatMsgManagerImpl.getInstance(context).getMsgByMsgId(j);
    }

    public static boolean setMsgReadByMsgId(Context context, long j, int i) {
        if (i != 1 && i != 0) {
            LogUtils.d(TAG, "return!!! for setMsgReadByMsgId...setType=" + i);
            return false;
        }
        ChatMsg msgByMsgId = getMsgByMsgId(context, j);
        if (msgByMsgId != null) {
            LogUtils.d(TAG, "setMsgReadByMsgId...msg=" + msgByMsgId.toString());
            int category = msgByMsgId.getCategory();
            if (category != 0) {
                return false;
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
        LogUtils.d(TAG, "setMsgReadByMsgId...msg=NULL !!!");
        return false;
    }

    public static void mediaFetchChatMsgs(Context context, long j, long j2, long j3, int i, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        ChatMsgManagerImpl.getInstance(context).mediaFetchChatMsgs(context, j, j2, j3, i, iMediaFetchChatMsgsListener);
    }

    public static void mediaFetchChatMsgs(Context context, long j, int i, long j2, String str, long j3, long j4, int i2, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        ChatMsgManagerImpl.getInstance(context).mediaFetchChatMsgs(context, j, i, j2, str, j3, j4, i2, iMediaFetchChatMsgsListener);
    }

    public static void mediaSendChatMsg(Context context, long j, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        ChatMsgManagerImpl.getInstance(context).mediaSendChatMsg(context, j, chatMsg, iMediaSendChatMsgListener);
    }

    public static void mediaSendChatMsg(Context context, long j, int i, long j2, String str, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        ChatMsgManagerImpl.getInstance(context).mediaSendChatMsg(context, j, i, j2, str, chatMsg, iMediaSendChatMsgListener);
    }

    public static void mediaDeleteChatMsg(Context context, long j, long j2, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        ChatMsgManagerImpl.getInstance(context).mediaDeleteChatMsg(context, j, j2, list, iMediaDeleteChatMsgListener);
    }

    public static void mediaDeleteChatMsg(Context context, long j, int i, long j2, String str, long j3, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        ChatMsgManagerImpl.getInstance(context).mediaDeleteChatMsg(context, j, i, j2, str, j3, list, iMediaDeleteChatMsgListener);
    }

    public static void mediaRegisterChatMsgChangedListener(Context context, IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        ChatMsgManagerImpl.getInstance(context).mediaRegisterChatMsgChangedListener(iMediaChatMsgChangedListener);
    }

    public static void mediaUnRegisterChatMsgChangedListener(Context context, IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        ChatMsgManagerImpl.getInstance(context).mediaUnRegisterChatMsgChangedListener(iMediaChatMsgChangedListener);
    }

    public static void mediaGetChatSessions(Context context, long j, int i, long j2, String str, long j3, int i2, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        if (!isNullContext(context)) {
            ChatSessionManagerImpl.getInstance(context).mediaGetChatSessions(j, i, j2, str, j3, i2, iMediaGetChatSessionListener);
        }
    }

    public static void mediaGetChatSessions(Context context, long j, long j2, int i, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        if (!isNullContext(context)) {
            ChatSessionManagerImpl.getInstance(context).mediaGetChatSessions(j, j2, i, iMediaGetChatSessionListener);
        }
    }

    public static void mediaSetSessionRead(Context context, long j, long j2, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        if (!isNullContext(context)) {
            ChatSessionManagerImpl.getInstance(context).mediaSetSessionRead(j, j2, iMediaSetSessionReadListener);
        }
    }

    public static void mediaSetSessionRead(Context context, long j, int i, long j2, String str, long j3, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        if (!isNullContext(context)) {
            ChatSessionManagerImpl.getInstance(context).mediaSetSessionRead(j, i, j2, str, j3, iMediaSetSessionReadListener);
        }
    }

    public static void mediaDeleteChatSession(Context context, long j, long j2, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        if (!isNullContext(context)) {
            ChatSessionManagerImpl.getInstance(context).mediaDeleteChatSession(j, j2, iMediaDeleteChatSessionListener);
        }
    }

    public static void mediaDeleteChatSession(Context context, long j, int i, long j2, String str, long j3, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        if (!isNullContext(context)) {
            ChatSessionManagerImpl.getInstance(context).mediaDeleteChatSession(j, i, j2, str, j3, iMediaDeleteChatSessionListener);
        }
    }

    public static void mediaContactorSetting(Context context, long j, int i, IMediaContactorSettingListener iMediaContactorSettingListener) {
        ChatSessionManagerImpl.getInstance(context).mediaContactorSetting(j, i, iMediaContactorSettingListener);
    }

    public static void mediaContactorSetting(Context context, long j, int i, long j2, String str, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        ChatSessionManagerImpl.getInstance(context).mediaContactorSetting(j, i, j2, str, i2, iMediaContactorSettingListener);
    }

    public static void mediaGetContactorPauid(Context context, long j, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        ChatSessionManagerImpl.getInstance(context).mediaGetContactorPauid(j, iMediaGetContactorPauidListener);
    }

    public static void mediaGetContactorPauid(Context context, long j, int i, long j2, String str, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        ChatSessionManagerImpl.getInstance(context).mediaGetContactorPauid(j, i, j2, str, iMediaGetContactorPauidListener);
    }

    public static void mediaGetContactorSetting(Context context, long j, int i, IMediaContactorSettingListener iMediaContactorSettingListener) {
        ChatSessionManagerImpl.getInstance(context).mediaGetContactorSetting(j, i, iMediaContactorSettingListener);
    }

    public static void mediaGetContactorSetting(Context context, long j, int i, long j2, String str, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        ChatSessionManagerImpl.getInstance(context).mediaGetContactorSetting(j, i, j2, str, i2, iMediaContactorSettingListener);
    }
}
