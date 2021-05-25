package com.baidu.android.imsdk.chatmessage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.IKickOutListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.sync.SyncAllMessage;
import com.baidu.android.imsdk.chatmessage.sync.SyncGroupMessageService;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.GroupManagerImpl;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.group.request.IMQueryMemberPauidRequest;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener;
import com.baidu.android.imsdk.notification.IFetchNotificationDataListener;
import com.baidu.android.imsdk.upload.FileUploadTask;
import com.baidu.android.imsdk.upload.IFileUploadListener;
import com.baidu.android.imsdk.upload.IUploadTransferListener;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ChatMsgManager extends BaseManager {
    public static void asyncUploadImgToBos(Context context, String str, String str2, int i2, int i3, int i4, IUploadTransferListener iUploadTransferListener) {
        if (context != null && !TextUtils.isEmpty(str)) {
            ChatMsgManagerImpl.getInstance(context).asyncUploadImgToBos(str, str2, i2, i3, i4, iUploadTransferListener);
        } else if (iUploadTransferListener != null) {
            iUploadTransferListener.onFailed(1005, 1, str);
        }
    }

    public static void audioTrans(Context context, String str, String str2, String str3, int i2, BIMValueCallBack bIMValueCallBack) {
        if (context != null && !TextUtils.isEmpty(str) && new File(str).exists()) {
            ChatMsgManagerImpl.getInstance(context).audioTrans(str, str2, str3, i2, bIMValueCallBack);
        } else if (bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        }
    }

    public static void clearKillOutListener(Context context) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManagerImpl.getInstance(context).clearKillOutListener();
    }

    public static void createChatSession(Context context, ChatObject chatObject, String str, int i2, String str2, int i3, String str3, String str4, int i4, int i5, long j, int i6, long j2, String str5, String str6, String str7) {
        ChatSessionManagerImpl.getInstance(context).createChatSession(chatObject, str, i2, str2, i3, str3, str4, i4, i5, j, i6, j2, str5, str6, str7);
    }

    public static boolean deleteAllMsgs(Context context, int i2, long j) {
        return context != null && Utility.isCategoryCorrect(i2) && Utility.isContacterCorrect(j) && ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(i2, j, false) >= 0;
    }

    public static boolean deleteChatSession(Context context, ChatSession chatSession) {
        if (context == null || chatSession == null) {
            return false;
        }
        return ChatSessionManagerImpl.getInstance(context).deleteChatSession(chatSession);
    }

    public static int deleteDraftMsg(Context context, int i2, long j) {
        if (context == null) {
            return -1005;
        }
        return ChatMsgManagerImpl.getInstance(context).deleteDraftMsg(i2, j);
    }

    public static int deleteMsg(Context context, ChatMsg chatMsg) {
        if (context == null || chatMsg == null) {
            return -1;
        }
        return ChatMsgManagerImpl.getInstance(context).deleteMsgs(chatMsg);
    }

    public static ArrayList<ChatMsg> fetchGroupNotifyMsgsSync(Context context, int i2, long j, int i3, ChatMsg chatMsg) {
        if (BaseManager.isNullContext(context)) {
            return null;
        }
        return ChatMsgManagerImpl.getInstance(context.getApplicationContext()).fetchGroupNotifyMsgsSync(i2, j, i3, false, chatMsg);
    }

    @Deprecated
    public static ArrayList<ChatMsg> fetchMessageSync(Context context, int i2, long j, long j2, int i3) {
        if (BaseManager.isNullContext(context)) {
            return null;
        }
        return ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i2, j, j2, i3);
    }

    @Deprecated
    public static Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState(Context context, int i2, long j, long j2, int i3) {
        if (BaseManager.isNullContext(context)) {
            return null;
        }
        ArrayList<ChatMsg> fetchMessageSync = ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i2, j, j2, i3);
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

    public static void fetchMsgByHostRequst(Context context, long j, int i2, long j2, long j3, long j4, int i3, IFetchMsgByIdListener iFetchMsgByIdListener) {
        fetchMsgByHostRequst(context, j, i2, j2, j3, j4, i3, iFetchMsgByIdListener, false);
    }

    public static void fetchMsgRequst(Context context, long j, long j2, int i2, long j3, long j4, long j5, int i3, IFetchMsgByIdListener iFetchMsgByIdListener) {
        fetchMsgRequst(context, j, j2, i2, j3, j4, j5, i3, iFetchMsgByIdListener, false);
    }

    public static void fetchMsgidByMsgid(Context context, int i2, long j, long j2, long j3, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener) {
        ChatMsgManagerImpl.getInstance(context).fetchMsgidByMsgid(context, i2, j, j2, j3, i3, i4, 0, iFetchMsgByIdListener);
    }

    public static void fetchPaChatMsgs(Context context, int i2, int i3, long j, long j2, long j3, int i4, IFetchMessageListener iFetchMessageListener) {
        ChatMsgManagerImpl.getInstance(context).fetchPaChatMsgs(i2, i3, j, j2, j3, i4, iFetchMessageListener);
    }

    public static void forwardMessage(final Context context, String str, int i2, final ChatMsg chatMsg, final ISendMessageListener iSendMessageListener) {
        long j;
        GroupInfo groupInfo;
        if (context == null) {
            if (iSendMessageListener != null) {
                iSendMessageListener.onSendMessageResult(1005, chatMsg);
            }
        } else if (!TextUtils.isEmpty(str) && chatMsg != null) {
            try {
                j = Long.parseLong(str);
            } catch (Exception e2) {
                String str2 = BaseManager.TAG;
                LogUtils.e(str2, "uid parse error " + e2.getMessage());
                new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
                j = 0L;
            }
            if (j == 0) {
                if (iSendMessageListener != null) {
                    iSendMessageListener.onSendMessageResult(1005, chatMsg);
                }
            } else if (i2 == 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(j));
                GroupManagerImpl.getInstance(context).getPaidAndUkByBduid(arrayList, new BIMValueCallBack<List<IMQueryMemberPauidRequest.UserId>>() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManager.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                    public void onResult(int i3, String str3, List<IMQueryMemberPauidRequest.UserId> list) {
                        if (i3 != 0 || list == null || list.size() <= 0) {
                            return;
                        }
                        ChatMsg.this.setRowId(-1L);
                        ChatMsg.this.setCategory(0);
                        ChatMsg.this.setFromUser(AccountManager.getUK(context));
                        ChatMsg.this.setStatus(1);
                        ChatMsg.this.setSenderUid(AccountManager.getUid(context));
                        ChatMsg.this.setIsZhida(false);
                        ChatMsg.this.parseForwardmessage(0);
                        IMQueryMemberPauidRequest.UserId userId = list.get(0);
                        ChatMsg.this.setContacterBduid(String.valueOf(userId.getBduid()));
                        if (userId.getPauid() > 0) {
                            ChatMsg.this.setContacter(userId.getPauid());
                            ChatMsg.this.setChatType(7);
                        } else {
                            ChatMsg.this.setContacter(userId.getUk());
                            ChatMsg.this.setChatType(0);
                        }
                        ChatMsg.this.setMsgTime(System.currentTimeMillis());
                        ChatMsgManager.sendMessage(context, ChatMsg.this, iSendMessageListener);
                    }
                });
            } else if (i2 == 1) {
                long longByString = Utility.getLongByString(str, -1L);
                chatMsg.setRowId(-1L);
                chatMsg.setCategory(i2);
                chatMsg.setContacter(longByString);
                chatMsg.setFromUser(AccountManager.getUK(context));
                chatMsg.setStatus(1);
                chatMsg.setSenderUid(AccountManager.getUid(context));
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str);
                ArrayList<GroupInfo> groupInfo2 = GroupInfoDAOImpl.getGroupInfo(context, arrayList2);
                int i3 = 3;
                if (groupInfo2 != null && groupInfo2.size() > 0 && (groupInfo = groupInfo2.get(0)) != null && groupInfo.getType() == 3) {
                    i3 = 57;
                }
                chatMsg.setChatType(i3);
                chatMsg.setMsgTime(System.currentTimeMillis());
                chatMsg.parseForwardmessage(i2);
                sendMessage(context, chatMsg, iSendMessageListener);
            }
        } else {
            LogUtils.e(BaseManager.TAG, "uid is null or msg is null");
            if (iSendMessageListener != null) {
                iSendMessageListener.onSendMessageResult(1005, chatMsg);
            }
        }
    }

    public static void genBosObjectUrl(Context context, String str, String str2, String str3, int i2, int i3, int i4, IGenBosObjectUrlListener iGenBosObjectUrlListener) {
        if (context != null && !TextUtils.isEmpty(str) && new File(str).exists()) {
            ChatMsgManagerImpl.getInstance(context).genBosObjectUrl(str, str2, str3, i2, i3, i4, iGenBosObjectUrlListener);
        } else if (iGenBosObjectUrlListener != null) {
            iGenBosObjectUrlListener.onGenBosObjectUrlListener(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null, null, null);
        }
    }

    public static ArrayList<SessionClass> getAllClassType(Context context) {
        return ChatSessionManagerImpl.getInstance(context.getApplicationContext()).getAllClassType();
    }

    public static ArrayList<ChatSession> getChatRecords(Context context, long j, long j2) {
        LogUtils.enter();
        if (BaseManager.isNullContext(context)) {
            return null;
        }
        return ChatSessionManagerImpl.getInstance(context).getChatRecords(j, j2);
    }

    public static ArrayList<ChatSession> getChatRecordsByClass(Context context, List<Integer> list) {
        if (BaseManager.isNullContext(context)) {
            return null;
        }
        return ChatSessionManagerImpl.getInstance(context).getChatRecordsByClass(0L, 0L, list);
    }

    public static ChatSession getChatSession(Context context, int i2, long j) {
        return ChatSessionManagerImpl.getInstance(context).getChatRecord(i2, j);
    }

    public static ChatMsg getDraftMsg(Context context, int i2, long j) {
        if (context == null) {
            return null;
        }
        return ChatMsgManagerImpl.getInstance(context).getDraftMsg(i2, j);
    }

    public static List<ChatSession> getGroupSession(Context context) {
        if (BaseManager.isNullContext(context)) {
            return null;
        }
        return ChatSessionManagerImpl.getInstance(context.getApplicationContext()).getGroupSession();
    }

    public static ChatMsg getMsgByMsgId(Context context, long j) {
        return ChatMsgManagerImpl.getInstance(context).getMsgByMsgId(j);
    }

    public static int getNewMsgCount(Context context) {
        if (context != null && AccountManager.isLogin(context)) {
            return ChatMsgManagerImpl.getInstance(context).getNewMsgCount();
        }
        return -1;
    }

    @Deprecated
    public static long getNewMsgNum(Context context, int i2, long j) {
        if (BaseManager.isNullContext(context)) {
            return -1L;
        }
        return ChatMsgManagerImpl.getInstance(context).getNewMsgNum(i2, j);
    }

    public static void getNotificationMsgDataList(Context context, SparseArray<List<Integer>> sparseArray, long j, int i2, IFetchNotificationDataListener iFetchNotificationDataListener) {
        ChatMsgManagerImpl.getInstance(context).getNotificationMsgDataList(sparseArray, j, i2, iFetchNotificationDataListener);
    }

    public static List<ChatMsg> getPaMsgByChatType(Context context, int i2, int i3) {
        if (BaseManager.isNullContext(context)) {
            return null;
        }
        return ChatMsgManagerImpl.getInstance(context).getPaMsgByChatType(i2, i3);
    }

    public static void getPaMsgByChatTypeAndPaidList(Context context, List<Integer> list, List<Long> list2, long j, int i2, IFetchNotificationDataListener iFetchNotificationDataListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManagerImpl.getInstance(context).getPaMsgByChatTypeAndPaidList(list, list2, j, i2, iFetchNotificationDataListener);
    }

    public static void getPaNewMsgCount(Context context, int i2, int i3, long j, IGetNewMsgCountListener iGetNewMsgCountListener) {
        ChatMsgManagerImpl.getInstance(context).getPaNewMsgCount(i2, i3, j, iGetNewMsgCountListener);
    }

    @Deprecated
    public static long getTotalNewMsgNum(Context context) {
        if (BaseManager.isNullContext(context)) {
            return 0L;
        }
        return ChatMsgManagerImpl.getInstance(context).getNewMsgCount();
    }

    @Deprecated
    public static long getUnReadMsgCount(Context context, int i2, long j) {
        if (BaseManager.isNullContext(context)) {
            return -1L;
        }
        return ChatMsgManagerImpl.getInstance(context).getNewMsgNum(i2, j);
    }

    public static int getUnReadMsgCountByPaid(Context context, long j) {
        if (BaseManager.isNullContext(context)) {
            return 0;
        }
        return ChatMsgManagerImpl.getInstance(context).getNewMsgCountByPaid(j);
    }

    public static int hideAllChatSession(Context context) {
        return ChatSessionManagerImpl.getInstance(context).hideAllChatSession();
    }

    public static void init(Context context) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManagerImpl.getInstance(context);
        ChatSessionManagerImpl.getInstance(context);
    }

    public static int markMsgClicked(Context context, ChatMsg chatMsg) {
        if (context == null || chatMsg == null) {
            return -1;
        }
        return ChatMsgManagerImpl.getInstance(context).markMessageClicked(chatMsg);
    }

    public static void mediaContactorSetting(Context context, long j, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        ChatSessionManagerImpl.getInstance(context).mediaContactorSetting(j, i2, iMediaContactorSettingListener);
    }

    public static void mediaDeleteChatMsg(Context context, long j, long j2, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        ChatMsgManagerImpl.getInstance(context).mediaDeleteChatMsg(j, j2, list, iMediaDeleteChatMsgListener);
    }

    public static void mediaDeleteChatSession(Context context, long j, long j2, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).mediaDeleteChatSession(j, j2, iMediaDeleteChatSessionListener);
    }

    public static void mediaFetchChatMsgs(Context context, long j, long j2, long j3, int i2, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        ChatMsgManagerImpl.getInstance(context).mediaFetchChatMsgs(context, j, j2, j3, i2, iMediaFetchChatMsgsListener);
    }

    public static void mediaGetChatSessions(Context context, long j, int i2, long j2, String str, long j3, int i3, int i4, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).mediaGetChatSessions(j, i2, j2, str, j3, i3, i4, iMediaGetChatSessionListener);
    }

    public static void mediaGetContactorPauid(Context context, long j, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        ChatSessionManagerImpl.getInstance(context).mediaGetContactorPauid(j, iMediaGetContactorPauidListener);
    }

    public static void mediaGetContactorSetting(Context context, long j, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        ChatSessionManagerImpl.getInstance(context).mediaGetContactorSetting(j, i2, iMediaContactorSettingListener);
    }

    public static void mediaRegisterChatMsgChangedListener(Context context, IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        ChatMsgManagerImpl.getInstance(context).mediaRegisterChatMsgChangedListener(iMediaChatMsgChangedListener);
    }

    public static void mediaSendChatMsg(Context context, long j, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        ChatMsgManagerImpl.getInstance(context).mediaSendChatMsg(j, chatMsg, iMediaSendChatMsgListener);
    }

    public static void mediaSetSessionRead(Context context, long j, long j2, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).mediaSetSessionRead(j, j2, iMediaSetSessionReadListener);
    }

    public static void mediaUnRegisterChatMsgChangedListener(Context context, IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        ChatMsgManagerImpl.getInstance(context).mediaUnRegisterChatMsgChangedListener(iMediaChatMsgChangedListener);
    }

    public static void registerChatSessionListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).registerRecordChangeListener(context, iChatSessionChangeListener);
    }

    public static void registerKillOutListener(Context context, IKickOutListener iKickOutListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManagerImpl.getInstance(context).registerKillOutListener(iKickOutListener);
    }

    public static void registerMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManagerImpl.getInstance(context).registerMessageReceiveListener(iMessageReceiveListener);
    }

    public static void registerStudioUsePaReceivePaMsg(Context context, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        ChatMsgManagerImpl.getInstance(context).registerStudioUsePaReceivePaMsg(iLiveMsgReceiveListener);
    }

    public static void resendMsg(Context context, String str, String str2, int i2, ISendMessageListener iSendMessageListener) {
        ChatMsgManagerImpl.getInstance(context).resendMsg(str, str2, i2, iSendMessageListener);
    }

    public static int saveAsDraftMsg(Context context, ChatMsg chatMsg) {
        if (context == null) {
            return -1005;
        }
        return ChatMsgManagerImpl.getInstance(context).saveAsDraftMsg(chatMsg);
    }

    public static void saveMessage(Context context, ChatMsg chatMsg) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManagerImpl.getInstance(context).saveMessage(chatMsg);
    }

    public static void sendMessage(Context context, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        if (chatMsg != null) {
            ChatMsgManagerImpl.getInstance(context).sendMessage(chatMsg, iSendMessageListener);
        } else if (iSendMessageListener != null) {
            iSendMessageListener.onSendMessageResult(1005, chatMsg);
        }
    }

    public static void sendPaChatMsg(Context context, int i2, int i3, long j, int i4, String str, ISendMessageListener iSendMessageListener) {
        ChatMsgManagerImpl.getInstance(context).sendPaChatMsg(i2, i3, j, i4, str, iSendMessageListener);
    }

    public static boolean setAllMsgRead(Context context, int i2, long j, boolean z) {
        if (BaseManager.isNullContext(context)) {
            return false;
        }
        return ChatMsgManagerImpl.getInstance(context).setAllMsgRead(i2, j, z);
    }

    public static void setInterActiveMsgStatus(Context context, long j, long j2, int i2, int i3) {
        ChatMsgManagerImpl.getInstance(context).setInterActiveMsgStatus(j, j2, i2, i3);
    }

    public static void setMediaAllSessionRead(Context context, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        mediaSetSessionRead(context, -1L, -1, -1L, "", System.currentTimeMillis(), iMediaSetSessionReadListener);
    }

    public static boolean setMsgRead(Context context, int i2, long j, long j2, boolean z) {
        if (BaseManager.isNullContext(context)) {
            return false;
        }
        return ChatMsgManagerImpl.getInstance(context).setMsgRead(i2, j, j2, z);
    }

    public static boolean setMsgReadByChatTpyes(Context context, List<Integer> list, long j) {
        return ChatMsgManagerImpl.getInstance(context).setMsgReadByChatTpyes(list, j);
    }

    public static boolean setMsgReadByChatTypeAndSubType(Context context, SparseArray<List<Integer>> sparseArray, long j, ISetMessageReadListener iSetMessageReadListener) {
        return ChatMsgManagerImpl.getInstance(context).setMsgReadByChatTypeAndSubType(sparseArray, j, iSetMessageReadListener);
    }

    public static boolean setMsgReadByMsgId(Context context, long j, int i2) {
        if (i2 != 1 && i2 != 0) {
            String str = BaseManager.TAG;
            LogUtils.d(str, "return!!! for setMsgReadByMsgId...setType=" + i2);
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
            long contacter = msgByMsgId.getContacter();
            boolean isZhida = msgByMsgId.isZhida();
            if (i2 == 0) {
                return setAllMsgRead(context, category, contacter, isZhida);
            }
            if (i2 == 1) {
                return setMsgRead(context, category, contacter, j, isZhida);
            }
        }
        LogUtils.d(BaseManager.TAG, "setMsgReadByMsgId...msg=NULL !!!");
        return false;
    }

    public static void setPaMsgsRead(Context context, int i2, int i3, long j, long j2, long j3) {
        ChatMsgManagerImpl.getInstance(context).setPaMsgsRead(i2, i3, j, j2, j3);
    }

    public static void unregisterChatSessionListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).unregisterMessageReceiveListener(context, iChatSessionChangeListener);
    }

    public static void unregisterMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManagerImpl.getInstance(context).unregisterMessageReceiveListener(context, iMessageReceiveListener);
    }

    public static void unregisterStudioUsePaReceivePaMsg(Context context, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        ChatMsgManagerImpl.getInstance(context).unregisterStudioUsePaReceivePaMsg(iLiveMsgReceiveListener);
    }

    public static boolean updateChatMsg(Context context, ChatMsg chatMsg) {
        return ChatMsgManagerImpl.getInstance(context).updateMsgContent(chatMsg);
    }

    public static void uploadFile(Context context, String str, String str2, String str3, String str4, String str5, IFileUploadListener iFileUploadListener) {
        if (context != null && !TextUtils.isEmpty(str2) && new File(str2).exists()) {
            new FileUploadTask(context, str, str2, str3, str4, str5, iFileUploadListener).execute(new Void[0]);
        } else if (iFileUploadListener != null) {
            iFileUploadListener.onFailed(1005, Constants.ERROR_MSG_PARAMETER_ERROR);
        }
    }

    public static void fetchMsgByHostRequst(Context context, long j, int i2, long j2, long j3, long j4, int i3, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        ChatMsgManagerImpl.getInstance(context).fetchMsgByHostRequst(j, i2, j2, j3, j4, i3, iFetchMsgByIdListener, z);
    }

    public static void fetchMsgRequst(Context context, long j, long j2, int i2, long j3, long j4, long j5, int i3, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        ChatMsgManagerImpl.getInstance(context).fetchMsgRequst(j, j2, i2, j3, j4, j5, i3, iFetchMsgByIdListener, z);
    }

    public static ChatSession getChatSession(Context context, int i2, long j, long j2) {
        return ChatSessionManagerImpl.getInstance(context).getChatRecord(i2, j, j2);
    }

    public static void mediaDeleteChatMsg(Context context, long j, int i2, long j2, String str, long j3, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        ChatMsgManagerImpl.getInstance(context).mediaDeleteChatMsg(j, i2, j2, str, j3, list, iMediaDeleteChatMsgListener);
    }

    public static void mediaFetchChatMsgs(Context context, long j, int i2, long j2, String str, long j3, long j4, int i3, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        ChatMsgManagerImpl.getInstance(context).mediaFetchChatMsgs(context, j, i2, j2, str, j3, j4, i3, iMediaFetchChatMsgsListener);
    }

    public static void mediaSendChatMsg(Context context, long j, int i2, long j2, String str, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        ChatMsgManagerImpl.getInstance(context).mediaSendChatMsg(j, i2, j2, str, chatMsg, iMediaSendChatMsgListener);
    }

    public static ArrayList<ChatMsg> fetchMessageSync(Context context, int i2, long j, int i3, ChatMsg chatMsg) {
        if (BaseManager.isNullContext(context)) {
            return null;
        }
        return ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i2, j, i3, chatMsg);
    }

    public static List<ChatMsg> getPaMsgByChatType(Context context, List<Integer> list, int i2) {
        if (BaseManager.isNullContext(context)) {
            return null;
        }
        return ChatMsgManagerImpl.getInstance(context).getPaMsgByChatType(list, i2);
    }

    public static void mediaContactorSetting(Context context, long j, int i2, long j2, String str, int i3, IMediaContactorSettingListener iMediaContactorSettingListener) {
        ChatSessionManagerImpl.getInstance(context).mediaContactorSetting(j, i2, j2, str, i3, iMediaContactorSettingListener);
    }

    public static void mediaGetChatSessions(Context context, long j, long j2, int i2, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).mediaGetChatSessions(j, j2, i2, iMediaGetChatSessionListener);
    }

    public static void mediaGetContactorPauid(Context context, long j, int i2, long j2, String str, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        ChatSessionManagerImpl.getInstance(context).mediaGetContactorPauid(j, i2, j2, str, iMediaGetContactorPauidListener);
    }

    public static void mediaGetContactorSetting(Context context, long j, int i2, long j2, String str, int i3, IMediaContactorSettingListener iMediaContactorSettingListener) {
        ChatSessionManagerImpl.getInstance(context).mediaGetContactorSetting(j, i2, j2, str, i3, iMediaContactorSettingListener);
    }

    public static void mediaSetSessionRead(Context context, long j, int i2, long j2, String str, long j3, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).mediaSetSessionRead(j, i2, j2, str, j3, iMediaSetSessionReadListener);
    }

    public static ArrayList<ChatSession> getChatRecords(Context context) {
        if (BaseManager.isNullContext(context)) {
            return null;
        }
        return ChatSessionManagerImpl.getInstance(context).getChatRecords(0L, 0L);
    }

    public static void mediaDeleteChatSession(Context context, long j, int i2, long j2, String str, long j3, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).mediaDeleteChatSession(j, i2, j2, str, j3, iMediaDeleteChatSessionListener);
    }

    public static ArrayList<ChatSession> getChatRecords(Context context, List<Integer> list) {
        if (BaseManager.isNullContext(context)) {
            return null;
        }
        return ChatSessionManagerImpl.getInstance(context).getChatRecords(0L, 0L, list);
    }

    public static Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState(Context context, int i2, long j, int i3, ChatMsg chatMsg) {
        ArrayList<ChatMsg> fetchMessageSync;
        int state;
        if (BaseManager.isNullContext(context)) {
            return null;
        }
        boolean z = true;
        if (i2 == 1) {
            long[] jArr = {1007, 1004};
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.valueOf(j));
            ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(context, arrayList);
            if ((groupInfo == null || groupInfo.size() <= 0 || groupInfo.get(0).getType() != 2) ? false : false) {
                fetchMessageSync = ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i2, j, i3, chatMsg, jArr);
            } else {
                fetchMessageSync = ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i2, j, i3, chatMsg);
            }
            state = SyncGroupMessageService.getInstance().getState(context, j);
        } else {
            fetchMessageSync = ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i2, j, i3, chatMsg);
            state = SyncAllMessage.getInstance(context).getState();
        }
        if (fetchMessageSync != null) {
            String str = BaseManager.TAG;
            LogUtils.d(str, "FFF  fetchmessage size " + fetchMessageSync.size());
        }
        return new Pair<>(Integer.valueOf(state), fetchMessageSync);
    }
}
