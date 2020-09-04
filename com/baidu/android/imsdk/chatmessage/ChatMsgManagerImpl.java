package com.baidu.android.imsdk.chatmessage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.LongSparseArray;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.account.IKickOutListener;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.account.TodoAfterLogin;
import com.baidu.android.imsdk.account.TodoBeforeLogout;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.InterActiveMsg;
import com.baidu.android.imsdk.chatmessage.messages.MessageSyncMsg;
import com.baidu.android.imsdk.chatmessage.messages.NotifyCustomerMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.chatmessage.request.IMBindPushMsg;
import com.baidu.android.imsdk.chatmessage.request.IMDelMsg;
import com.baidu.android.imsdk.chatmessage.request.IMFetchConfigMsg;
import com.baidu.android.imsdk.chatmessage.request.IMFetchMsgByHostRequest;
import com.baidu.android.imsdk.chatmessage.request.IMFetchMsgByIdMsg;
import com.baidu.android.imsdk.chatmessage.request.IMFetchMsgRequest;
import com.baidu.android.imsdk.chatmessage.request.IMGenBosObjectUrlRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMarkMsgReadedMsg;
import com.baidu.android.imsdk.chatmessage.request.IMMediaDeleteMsgHttpRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMediaFetchMsgHttpRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMediaSendMsgHttpRequest;
import com.baidu.android.imsdk.chatmessage.request.IMSendMsg;
import com.baidu.android.imsdk.chatmessage.request.IMSendMsgRequest;
import com.baidu.android.imsdk.chatmessage.request.IMSyncDialog;
import com.baidu.android.imsdk.chatmessage.request.IMSyncPushMsg;
import com.baidu.android.imsdk.chatmessage.request.IMUnBindPushMsg;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecordDBManager;
import com.baidu.android.imsdk.chatmessage.sync.Generator;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.IGetUserIdentityListener;
import com.baidu.android.imsdk.chatuser.db.ChatUserDBManager;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.GroupInfoSyncManagerImpl;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.group.db.GroupMessageDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.Dispatcher;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageFactory;
import com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener;
import com.baidu.android.imsdk.notification.IFetchNotificationDataListener;
import com.baidu.android.imsdk.notification.NotificationMsgData;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.imsdk.a;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ChatMsgManagerImpl {
    private static final String TAG = ChatMsgManagerImpl.class.getSimpleName();
    private static final int USER_IDENTITY_UPDATE_TIME = 600000;
    public static Context mContext;
    private static volatile ChatMsgManagerImpl mInstance;
    private IKickOutListener mKickOutListener;
    private ILiveMsgReceiveListener mReceiveStudioListener;
    private ArrayList<IMessageReceiveListener> mReceiveListeners = new ArrayList<>();
    private HashMap<String, ILiveMsgReceiveListener> mReceiveStudioListeners = new HashMap<>();
    private List<IMessageSyncListener> mMessageSyncListener = new LinkedList();
    private HashMap<Integer, IMediaChatMsgChangedListener> mMediaMsgChangedListeners = new HashMap<>();
    private boolean mUseRequestSendMsg = false;
    Dispatcher.MsgListener onReceiveListener = new Dispatcher.MsgListener() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.3
        @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
        public void dealMessage(int i, ChatMsg chatMsg) {
        }

        @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
        public void dealMessage(int i, ArrayList<ChatMsg> arrayList) {
            LogUtils.d(ChatMsgManagerImpl.TAG, "dealMessage triggerReason : " + i);
            ChatMsgManagerImpl.this.broadcastMessage(arrayList, true);
        }
    };
    Dispatcher.MsgListener messageSyncListener = new Dispatcher.MsgListener() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.4
        @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
        public void dealMessage(int i, ArrayList<ChatMsg> arrayList) {
        }

        @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
        public void dealMessage(int i, ChatMsg chatMsg) {
            int i2;
            if (chatMsg instanceof MessageSyncMsg) {
                MessageSyncMsg messageSyncMsg = (MessageSyncMsg) chatMsg;
                long changedMsgid = messageSyncMsg.getChangedMsgid();
                int changedStatus = messageSyncMsg.getChangedStatus();
                ChatMsg chatMsgByMsgId = ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).getChatMsgByMsgId(changedMsgid);
                if (chatMsgByMsgId != null) {
                    int category = chatMsgByMsgId.getCategory();
                    long contacter = chatMsgByMsgId.getFromUser() == AccountManager.getUK(ChatMsgManagerImpl.mContext) ? chatMsgByMsgId.getContacter() : chatMsgByMsgId.getFromUser();
                    if (changedStatus == 0) {
                        int deleteMsgBatch = ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).deleteMsgBatch(ChatMsgManagerImpl.this.getChatObject(category, contacter, chatMsgByMsgId.getPaid()), new long[]{changedMsgid});
                        if (deleteMsgBatch > 0 && ChatMsgManagerImpl.this.mMessageSyncListener != null && ChatMsgManagerImpl.this.mMessageSyncListener.size() != 0) {
                            for (IMessageSyncListener iMessageSyncListener : ChatMsgManagerImpl.this.mMessageSyncListener) {
                                if (iMessageSyncListener != null) {
                                    iMessageSyncListener.onMsgDel(changedMsgid);
                                }
                            }
                        }
                        i2 = deleteMsgBatch;
                    } else {
                        int msgRead = ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).setMsgRead(ChatMsgManagerImpl.this.getChatObject(category, contacter, chatMsgByMsgId.getPaid()), changedMsgid);
                        if (msgRead > 0 && ChatMsgManagerImpl.this.mMessageSyncListener != null && ChatMsgManagerImpl.this.mMessageSyncListener.size() != 0) {
                            for (IMessageSyncListener iMessageSyncListener2 : ChatMsgManagerImpl.this.mMessageSyncListener) {
                                if (iMessageSyncListener2 != null) {
                                    iMessageSyncListener2.onMsgReaded(changedMsgid);
                                }
                            }
                        }
                        i2 = msgRead;
                    }
                    if (i2 > 0) {
                        Intent intent = new Intent(IMConstants.SYNC_ACTION);
                        intent.setPackage(ChatMsgManagerImpl.mContext.getApplicationContext().getPackageName());
                        intent.putExtra(IMConstants.SYNC_MSGID, changedMsgid);
                        intent.putExtra(IMConstants.SYNC_STATUS, changedStatus);
                        intent.putExtra(IMConstants.SYNC_TYPE, 0);
                        ChatMsgManagerImpl.mContext.sendBroadcast(intent);
                    }
                }
            }
        }
    };
    Dispatcher.MsgListener mInitCustomerListener = new Dispatcher.MsgListener() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.5
        @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
        public void dealMessage(int i, ArrayList<ChatMsg> arrayList) {
        }

        @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
        public void dealMessage(int i, ChatMsg chatMsg) {
            if (chatMsg instanceof NotifyCustomerMsg) {
                ChatMsgManagerImpl.this.sendNoticeBroadcast(ChatMsgManagerImpl.mContext, (NotifyCustomerMsg) chatMsg);
            }
        }
    };
    Dispatcher.MsgListener mSwithcCustomerListener = new Dispatcher.MsgListener() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.6
        @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
        public void dealMessage(int i, ArrayList<ChatMsg> arrayList) {
        }

        @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
        public void dealMessage(int i, ChatMsg chatMsg) {
            if (chatMsg instanceof NotifyCustomerMsg) {
                ChatMsgManagerImpl.this.sendNoticeBroadcast(ChatMsgManagerImpl.mContext, (NotifyCustomerMsg) chatMsg);
            }
        }
    };

    public ChatMsgManagerImpl(boolean z) {
        addMessageTypes();
        registerListeners();
    }

    public ChatMsgManagerImpl() {
        LogUtils.d(TAG, "ChatMsgManagerImpl()....");
    }

    private void addMessageTypes() {
        MessageFactory.getInstance().addType(57, IMDelMsg.class);
        MessageFactory.getInstance().addType(67, IMMarkMsgReadedMsg.class);
        MessageFactory.getInstance().addType(55, IMSendMsg.class);
        MessageFactory.getInstance().addType(93, IMFetchMsgByIdMsg.class);
        MessageFactory.getInstance().addType(94, IMSyncDialog.class);
        MessageFactory.getInstance().addType(90, IMBindPushMsg.class);
        MessageFactory.getInstance().addType(190, IMSyncPushMsg.class);
        MessageFactory.getInstance().addType(92, IMUnBindPushMsg.class);
        MessageFactory.getInstance().addType(193, IMFetchConfigMsg.class);
    }

    private void registerListeners() {
        Dispatcher.Event event = new Dispatcher.Event();
        event.setCategory(-1);
        event.setType(-1);
        Dispatcher.registerListener(event, this.onReceiveListener);
        Dispatcher.Event event2 = new Dispatcher.Event();
        event2.setCategory(2);
        event2.setType(21);
        Dispatcher.registerListener(event2, this.messageSyncListener);
        Dispatcher.Event event3 = new Dispatcher.Event();
        event3.setCategory(2);
        event3.setType(60);
        Dispatcher.registerListener(event3, this.mInitCustomerListener);
        Dispatcher.Event event4 = new Dispatcher.Event();
        event4.setCategory(2);
        event4.setType(62);
        Dispatcher.registerListener(event4, this.mSwithcCustomerListener);
        AccountManagerImpl.getInstance(mContext).registerToDoAfterLoginListener(new TodoAfterLogin() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.1
            @Override // com.baidu.android.imsdk.account.TodoAfterLogin
            public void todo(boolean z) {
                LogUtils.d(ChatMsgManagerImpl.TAG, "start sync message after login sucess.");
                BindStateManager.startBindPush(ChatMsgManagerImpl.mContext, null, null, null, null);
                if (z) {
                    Generator.generate(ChatMsgManagerImpl.mContext, 5).start(1);
                } else {
                    Generator.generate(ChatMsgManagerImpl.mContext, 5).start(0);
                }
                ChatSessionManagerImpl.getInstance(ChatMsgManagerImpl.mContext).syncDialog();
                GroupInfoSyncManagerImpl.syncAllGroupList(ChatMsgManagerImpl.mContext);
                TaskManager.getInstance(ChatMsgManagerImpl.mContext).submitForNetWork(new UnEffectiveMsgTask(ChatMsgManagerImpl.mContext));
                TaskManager.getInstance(ChatMsgManagerImpl.mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).deleteExpiredDupMsgs();
                    }
                });
            }
        });
        AccountManagerImpl.getInstance(mContext).registerToDoBeforeLogoutListener(new TodoBeforeLogout() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.2
            @Override // com.baidu.android.imsdk.account.TodoBeforeLogout
            public void todo() {
                ChatMsgManagerImpl.this.unRegisterNotify(null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNoticeBroadcast(Context context, ChatMsg chatMsg) {
        Intent intent = new Intent(IMConstants.CUSTOMER_CHANGE);
        intent.setPackage(context.getApplicationContext().getPackageName());
        intent.putExtra(IMConstants.MESSAGE, chatMsg);
        context.sendBroadcast(intent);
    }

    public static ChatMsgManagerImpl getInstance(Context context) {
        if (mInstance == null) {
            synchronized (ChatMsgManagerImpl.class) {
                if (mInstance == null) {
                    mContext = context.getApplicationContext();
                    mInstance = new ChatMsgManagerImpl(true);
                }
            }
        }
        return mInstance;
    }

    @Deprecated
    public ArrayList<ChatMsg> fetchMessageSync(int i, long j, long j2, int i2) {
        if (getPaid() == -2) {
            return null;
        }
        return ChatMessageDBManager.getInstance(mContext).fetchMsg(getChatObject(i, j, getPaid()), j2, i2, -1L);
    }

    private void updateChatMsgStatus(ChatMsg chatMsg, int i) {
        int i2;
        if (i == 0) {
            i2 = 0;
        } else {
            i2 = 2;
        }
        chatMsg.setStatus(i2);
        ChatMessageDBManager.getInstance(mContext).updateMsgStatus(chatMsg);
    }

    public long deleteAllSmartMsgs(int i) {
        ArrayList<Long> queryPaIdByPaType = PaInfoDBManager.getInstance(mContext).queryPaIdByPaType(i);
        long j = -1;
        if (queryPaIdByPaType == null || queryPaIdByPaType.isEmpty()) {
            return -1L;
        }
        Iterator<Long> it = queryPaIdByPaType.iterator();
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            long deleteAllMsg = ChatMessageDBManager.getInstance(mContext).deleteAllMsg(getChatObject(0, longValue, longValue));
            if (deleteAllMsg < 0) {
                return -1009L;
            }
            Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 57);
            creatMethodIntent.putExtra("category", 0);
            creatMethodIntent.putExtra("contacter", longValue);
            creatMethodIntent.putExtra(Constants.EXTRA_CLIENT_MAX_MSGID, deleteAllMsg);
            creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, false);
            try {
                a.al(mContext).e(mContext, creatMethodIntent);
            } catch (Exception e) {
                LogUtils.e(TAG, "Exception ", e);
            }
            j = 0;
        }
        return j;
    }

    public long deleteAllMsgs(int i, long j, boolean z) {
        LogUtils.d(TAG, String.format("delete all msg category=%d, contacter=%d", Integer.valueOf(i), Long.valueOf(j)));
        if (i == 17 || i == 26) {
            return deleteAllSmartMsgs(i);
        }
        if (i < 0 || j < 0) {
            return -1005L;
        }
        if (getPaid() == -2) {
            return -1017L;
        }
        if (AccountManager.isLogin(mContext)) {
            long deleteAllMsg = ChatMessageDBManager.getInstance(mContext).deleteAllMsg(getChatObject(i, j, getPaid()));
            if (deleteAllMsg < 0) {
                return -1009L;
            }
            Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 57);
            creatMethodIntent.putExtra("category", i);
            creatMethodIntent.putExtra("contacter", j);
            creatMethodIntent.putExtra(Constants.EXTRA_CLIENT_MAX_MSGID, deleteAllMsg);
            creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, z);
            tryPutPaid(creatMethodIntent);
            try {
                a.al(mContext).e(mContext, creatMethodIntent);
            } catch (Exception e) {
                LogUtils.e(TAG, "Exception ", e);
            }
            return 0L;
        }
        return -1000L;
    }

    public int deleteMsgs(int i, long j, long[] jArr, boolean z) {
        if (i < 0 || j < 0 || jArr == null || jArr.length <= 0) {
            return -1005;
        }
        if (getPaid() == -2) {
            return -1017;
        }
        if (AccountManager.isLogin(mContext)) {
            int deleteMsgBatch = ChatMessageDBManager.getInstance(mContext).deleteMsgBatch(getChatObject(i, j, getPaid()), jArr);
            if (deleteMsgBatch >= 0) {
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 57);
                creatMethodIntent.putExtra("category", i);
                creatMethodIntent.putExtra("contacter", j);
                creatMethodIntent.putExtra(Constants.EXTRA_DEL_MSG_IDS, jArr);
                creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, z);
                tryPutPaid(creatMethodIntent);
                try {
                    a.al(mContext).e(mContext, creatMethodIntent);
                    return deleteMsgBatch;
                } catch (Exception e) {
                    LogUtils.e(TAG, "Exception ", e);
                    return deleteMsgBatch;
                }
            }
            return deleteMsgBatch;
        }
        return -1000;
    }

    public void resendMsg(String str, String str2, int i, ISendMessageListener iSendMessageListener) {
        LogUtils.d(TAG, "resendMsg " + str + " " + str2 + " ---->");
        if (i == 0) {
            ArrayList<ChatMsg> fetchMsg = ChatMessageDBManager.getInstance(mContext).fetchMsg(str2, str);
            if (fetchMsg == null || fetchMsg.size() == 0) {
                LogUtils.d(TAG, "resendMsg get msg by rowid is null");
                if (iSendMessageListener != null) {
                    iSendMessageListener.onSendMessageResult(1005, null);
                    return;
                }
                return;
            }
            ChatMsg chatMsg = fetchMsg.get(0);
            LogUtils.d(TAG, "resendMsg " + chatMsg.getRowId() + "  " + str);
            chatMsg.setStatus(1);
            chatMsg.setReSend();
            sendMessage(chatMsg, iSendMessageListener);
        }
    }

    public void sendMessage(ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        this.mUseRequestSendMsg = false;
        if (chatMsg == null) {
            if (iSendMessageListener != null) {
                iSendMessageListener.onSendMessageResult(1005, null);
            }
        } else if (noSaveDB(chatMsg.getCategory())) {
            sendHiddenMsg(chatMsg, iSendMessageListener);
        } else if ((chatMsg.getCategory() != 0 && chatMsg.getCategory() != 1) || chatMsg.getContacter() <= 0) {
            if (iSendMessageListener != null) {
                iSendMessageListener.onSendMessageResult(1005, null);
            }
        } else {
            String addListener = ListenerManager.getInstance().addListener(iSendMessageListener);
            if (getPaid() == -2) {
                onSendMessageResult(1017, chatMsg, -1L, addListener);
            }
            if (3 == IMConfigInternal.getInstance().getProductLine(mContext) && chatMsg.getCategory() == 1) {
                chatMsg.setMinSdkVersion(2300000L);
            }
            if (AccountManager.isLogin(mContext)) {
                if (saveMessage(chatMsg) == 1) {
                    Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 55);
                    creatMethodIntent.putExtra(Constants.EXTRA_SEND_MSG, chatMsg);
                    creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                    try {
                        a.al(mContext).e(mContext, creatMethodIntent);
                        return;
                    } catch (Exception e) {
                        onSendMessageResult(6, chatMsg, -1L, addListener);
                        LogUtils.e(TAG, "Exception ", e);
                        return;
                    }
                }
                onSendMessageResult(6, chatMsg, -1L, addListener);
                return;
            }
            LoginManager.getInstance(mContext).triggleLogoutListener(4001, Constants.ERROR_LOGIN_STATE_ERROR);
            onSendMessageResult(1000, chatMsg, -1L, addListener);
        }
    }

    private boolean noSaveDB(int i) {
        return i == 7 || i == 4;
    }

    private void sendHiddenMsg(@NonNull ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Intent creatMethodIntent;
        if (chatMsg.getContacter() <= 0 && chatMsg.getCategory() == 4) {
            if (iSendMessageListener != null) {
                iSendMessageListener.onSendMessageResult(1005, null);
                ListenerManager.getInstance().removeListener(chatMsg.mListenerKey);
                return;
            }
            return;
        }
        String addListener = ListenerManager.getInstance().addListener(iSendMessageListener);
        if (AccountManager.isLogin(mContext)) {
            if (a.ayp && chatMsg.getCategory() == 4) {
                creatMethodIntent = Utility.createMcastMethodIntent(mContext, 55);
            } else {
                creatMethodIntent = Utility.creatMethodIntent(mContext, 55);
            }
            creatMethodIntent.putExtra(Constants.EXTRA_SEND_MSG, chatMsg);
            creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            try {
                a.al(mContext).e(mContext, creatMethodIntent);
                return;
            } catch (Exception e) {
                onSendMessageResult(6, chatMsg, -1L, addListener);
                LogUtils.e(TAG, "Exception ", e);
                return;
            }
        }
        onSendMessageResult(1000, chatMsg, -1L, addListener);
    }

    public void onSendMessageResult(int i, ChatMsg chatMsg, long j, String str) {
        try {
            if (chatMsg == null) {
                LogUtils.d(TAG, "onSendMessageResult----chatMsg is null");
                IMListener removeListener = ListenerManager.getInstance().removeListener(str);
                if (removeListener != null && (removeListener instanceof ISendMessageListener)) {
                    ((ISendMessageListener) removeListener).onSendMessageResult(i, null);
                } else {
                    LogUtils.d(TAG, "ISendMessageListener is null");
                }
            } else if (chatMsg.getCategory() == 4) {
                onSendStudioMsgResult(i, chatMsg, j, str);
            } else {
                LogUtils.d(TAG, "onSendMessageResult----errorCode: " + i);
                try {
                    int currentTimeMillis = (int) (System.currentTimeMillis() - Long.parseLong(str.substring(1, 14)));
                } catch (Exception e) {
                    LogUtils.e(TAG, "get message receive time error", e);
                    new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
                }
                if (j != -1) {
                    chatMsg.setMsgTime(j);
                }
                DBManager.getInstance(mContext).deleteCmdMsg(getMsgUUid(chatMsg));
                updateChatMsgStatus(chatMsg, i);
                IMListener removeListener2 = ListenerManager.getInstance().removeListener(str);
                if (removeListener2 != null && (removeListener2 instanceof ISendMessageListener)) {
                    ((ISendMessageListener) removeListener2).onSendMessageResult(i, chatMsg);
                } else {
                    LogUtils.d(TAG, "ISendMessageListener is null");
                }
                if (chatMsg != null) {
                    ListenerManager.getInstance().removeListener(chatMsg.mListenerKey);
                }
            }
        } catch (Exception e2) {
            LogUtils.e(TAG, "onSendMessageResult exception " + e2.getMessage());
        }
    }

    private void onSendStudioMsgResult(int i, ChatMsg chatMsg, long j, String str) {
        if (i != 0 && !hitMcastSendMsgErrorCode(i) && useRequestSendMsg() && !this.mUseRequestSendMsg) {
            sendMessageRequest(chatMsg, str);
            return;
        }
        IMListener removeListener = ListenerManager.getInstance().removeListener(str);
        if (removeListener != null && (removeListener instanceof ISendMessageListener)) {
            ((ISendMessageListener) removeListener).onSendMessageResult(i, chatMsg);
        } else {
            LogUtils.d(TAG, "ISendMessageListener is null");
        }
        updateChatMsgStatus(chatMsg, i);
        if (i != 0) {
            LogUtils.d(TAG, "onSendStudioMsgResult----errorCode: " + i);
        }
        if (chatMsg != null) {
            ListenerManager.getInstance().removeListener(chatMsg.mListenerKey);
        }
    }

    private boolean useRequestSendMsg() {
        long appId = Utility.getAppId(mContext);
        return appId == Constants.APPID_HAOKAN || appId == Constants.APPID_HAOKAN_JISU || appId == Constants.APPID_QUANMIN || appId == Constants.APPID_TIEBA;
    }

    private boolean hitMcastSendMsgErrorCode(int i) {
        return i == 22 || i == 1 || i == 24 || i == 1000 || i == 1203 || i == 1204 || i == 1207 || i == 1306 || i == 1316 || i == 1314;
    }

    public void sendMessageRequest(ChatMsg chatMsg, String str) {
        LogUtils.d(TAG, "sendMessageRequest ---> msg :" + chatMsg.toString());
        this.mUseRequestSendMsg = true;
        IMSendMsgRequest iMSendMsgRequest = new IMSendMsgRequest(mContext, chatMsg, str);
        HttpHelper.executor(mContext, iMSendMsgRequest, iMSendMsgRequest);
    }

    private int saveGroupMessage(ChatMsg chatMsg) {
        chatMsg.setPaid(getPaid());
        chatMsg.setMsgId(GroupMessageDAOImpl.getMaxMsgid(mContext, String.valueOf(chatMsg.getContacter())) + 1);
        chatMsg.setIsClicked(true);
        chatMsg.setMsgReaded(1);
        chatMsg.setDeviceFlag(1);
        long rowId = chatMsg.getRowId();
        if (rowId == -1) {
            chatMsg.createMsgKey(mContext);
            rowId = ChatMessageDBManager.getInstance(mContext).addMsg(chatMsg, true);
        } else {
            GroupMessageDAOImpl.updateMsgStatus(mContext, chatMsg);
        }
        if (rowId < 0) {
            return -1;
        }
        chatMsg.setRowId(rowId);
        String str = "" + chatMsg.getRowId();
        String msgUUid = getMsgUUid(chatMsg);
        String chatObject = getChatObject(chatMsg.getCategory(), chatMsg.getContacter(), chatMsg.getPaid()).toString();
        if (!TextUtils.isEmpty(msgUUid) && DBManager.getInstance(mContext).getCmdQueueMsg(msgUUid, Constants.METHOD_SEND_USER_MSG) == null) {
            DBManager.getInstance(mContext).saveCmdMsg(msgUUid, Constants.METHOD_SEND_USER_MSG, str, chatObject, 15, 2);
        }
        return 1;
    }

    public int saveMessage(ChatMsg chatMsg) {
        if (chatMsg == null || !AccountManager.isLogin(mContext)) {
            return -1;
        }
        if (1 == chatMsg.getCategory()) {
            return saveGroupMessage(chatMsg);
        }
        return saveSingleMsg(chatMsg, -1);
    }

    private int saveSingleMsg(ChatMsg chatMsg, int i) {
        chatMsg.setPaid(getPaid());
        long maxMsgid = ChatMessageDBManager.getInstance(mContext).getMaxMsgid() + 1;
        LogUtils.d(TAG, "saveSingleMsg msgid = " + maxMsgid);
        chatMsg.setMsgId(maxMsgid);
        chatMsg.setIsClicked(true);
        chatMsg.setMsgReaded(1);
        chatMsg.setDeviceFlag(1);
        long rowId = chatMsg.getRowId();
        if (rowId == -1) {
            chatMsg.createMsgKey(mContext);
            LogUtils.d("FFF saveSingleMsg msgkey ", " " + chatMsg.getMsgKey());
            rowId = ChatMessageDBManager.getInstance(mContext).addMsg(chatMsg, true);
        } else {
            ChatMessageDBManager.getInstance(mContext).updateMsgStatus(chatMsg);
        }
        if (rowId >= 0) {
            chatMsg.setRowId(rowId);
            String str = "" + chatMsg.getRowId();
            String msgUUid = getMsgUUid(chatMsg);
            String chatObject = getChatObject(chatMsg.getCategory(), chatMsg.getContacter(), chatMsg.getPaid()).toString();
            if (!TextUtils.isEmpty(msgUUid) && DBManager.getInstance(mContext).getCmdQueueMsg(msgUUid, Constants.METHOD_SEND_USER_MSG) == null) {
                DBManager.getInstance(mContext).saveCmdMsg(msgUUid, Constants.METHOD_SEND_USER_MSG, str, chatObject, 15, 2);
            }
            return 1;
        }
        return i;
    }

    public boolean setBeforeMsgRead(int i, long j, long j2, boolean z) {
        ChatObject chatObject;
        if (getPaid() != -2 && AccountManager.isLogin(mContext)) {
            if ((Constants.PAFLAG & j) != 0) {
                chatObject = getChatObject(i, j, j);
            } else {
                chatObject = getChatObject(i, j, getPaid());
            }
            ChatSession chatRecord = ChatMessageDBManager.getInstance(mContext).getChatRecord(chatObject);
            if (chatRecord != null) {
                long newMsgSum = chatRecord.getNewMsgSum();
                if (newMsgSum < 0) {
                    return false;
                }
                if (newMsgSum == 0) {
                    return true;
                }
            }
            if (ChatMessageDBManager.getInstance(mContext).setAllMsgReadWithMsgid(chatObject, j2)) {
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 67);
                creatMethodIntent.putExtra("category", i);
                creatMethodIntent.putExtra("contacter", j);
                creatMethodIntent.putExtra(Constants.EXTRA_CLIENT_MAX_MSGID, j2);
                creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, z);
                tryPutPaid(creatMethodIntent);
                try {
                    a.al(mContext).e(mContext, creatMethodIntent);
                } catch (Exception e) {
                    LogUtils.e(TAG, "Exception ", e);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean setAllMsgRead(int i, long j, boolean z) {
        if (i == 17 || i == 26) {
            ArrayList<Long> queryPaIdByPaType = PaInfoDBManager.getInstance(mContext).queryPaIdByPaType(i);
            if (queryPaIdByPaType == null || queryPaIdByPaType.isEmpty()) {
                return false;
            }
            Iterator<Long> it = queryPaIdByPaType.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                z2 = setBeforeMsgRead(0, longValue, ChatMessageDBManager.getInstance(mContext).getMaxMsgid(getChatObject(0, longValue, longValue)), z);
            }
            return z2;
        }
        return setBeforeMsgRead(i, j, ChatMessageDBManager.getInstance(mContext).getMaxMsgid(getChatObject(i, j, getPaid())), z);
    }

    public boolean setMsgRead(int i, long j, long j2, boolean z) {
        if (getPaid() != -2 && AccountManager.isLogin(mContext) && ChatMessageDBManager.getInstance(mContext).setMsgRead(getChatObject(i, j, getPaid()), j2) >= 0) {
            Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 67);
            creatMethodIntent.putExtra("category", i);
            creatMethodIntent.putExtra("contacter", j);
            creatMethodIntent.putExtra("msgid", j2);
            creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, z);
            tryPutPaid(creatMethodIntent);
            try {
                a.al(mContext).e(mContext, creatMethodIntent);
            } catch (Exception e) {
                LogUtils.e(TAG, "Exception ", e);
            }
            return true;
        }
        return false;
    }

    public boolean setMsgReadByChatTpyes(List<Integer> list, long j) {
        if (AccountManager.isLogin(mContext)) {
            if (j <= 0) {
                ArrayList<ChatMsg> maxMsgidByChatTypes = ChatMessageDBManager.getInstance(mContext).getMaxMsgidByChatTypes(list, 0L, 1);
                if (maxMsgidByChatTypes == null || maxMsgidByChatTypes.size() <= 0) {
                    return false;
                }
                j = maxMsgidByChatTypes.get(0).getMsgId();
            }
            LogUtils.e(TAG, "setMsgReadByChatTpyes msgid = " + j);
            List<Long> paMsgReadByChatTypes = ChatMessageDBManager.getInstance(mContext).setPaMsgReadByChatTypes(list, j);
            if (paMsgReadByChatTypes == null) {
                return false;
            }
            LogUtils.e(TAG, "setMsgReadByChatTpyes paids size = " + paMsgReadByChatTypes.size());
            for (Long l : paMsgReadByChatTypes) {
                long longValue = l.longValue();
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 67);
                creatMethodIntent.putExtra("category", 0);
                creatMethodIntent.putExtra("contacter", longValue);
                creatMethodIntent.putExtra(Constants.EXTRA_CLIENT_MAX_MSGID, j);
                creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, false);
                tryPutPaid(creatMethodIntent);
                try {
                    a.al(mContext).e(mContext, creatMethodIntent);
                } catch (Exception e) {
                    LogUtils.e(TAG, "Exception ", e);
                }
            }
            return true;
        }
        return false;
    }

    public void registerKillOutListener(IKickOutListener iKickOutListener) {
        this.mKickOutListener = iKickOutListener;
    }

    public void clearKillOutListener() {
        this.mKickOutListener = null;
    }

    public long getNewMsgNum(int i, long j) {
        if (AccountManager.isLogin(mContext)) {
            if (getPaid() == -2) {
                return -1017L;
            }
            return ChatMessageDBManager.getInstance(mContext).getNewMsgNum(getChatObject(i, j, getPaid()));
        }
        return -1L;
    }

    public List<ChatMsg> getPaMsgByChatType(int i, int i2) {
        if (AccountManager.isLogin(mContext)) {
            return ChatMessageDBManager.getInstance(mContext).fetchPaMsgByChatType(i, i2);
        }
        return null;
    }

    public List<ChatMsg> getPaMsgByChatType(List<Integer> list, int i) {
        if (AccountManager.isLogin(mContext)) {
            return ChatMessageDBManager.getInstance(mContext).getPaMsgByChatTypeAndPaidList(list, null, 0L, i);
        }
        return null;
    }

    public void getPaMsgByChatTypeAndPaidList(final List<Integer> list, final List<Long> list2, final long j, int i, final IFetchNotificationDataListener iFetchNotificationDataListener) {
        if (AccountManager.isLogin(mContext) && iFetchNotificationDataListener != null) {
            final int i2 = Math.abs(i) <= 20 ? i : 20;
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    ChatMsgManagerImpl.this.callBackNotificationMsgData(ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).getPaMsgByChatTypeAndPaidList(list, list2, j, i2), i2, iFetchNotificationDataListener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackNotificationMsgData(ArrayList<ChatMsg> arrayList, final int i, final IFetchNotificationDataListener iFetchNotificationDataListener) {
        final ArrayList arrayList2 = new ArrayList();
        if (arrayList == null || arrayList.size() <= 0) {
            iFetchNotificationDataListener.onFetchResult(arrayList2, false);
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<ChatMsg> it = arrayList.iterator();
        while (it.hasNext()) {
            ChatMsg next = it.next();
            NotificationMsgData notificationMsgData = new NotificationMsgData(next);
            if (next.getMsgType() == 24) {
                hashSet.addAll(notificationMsgData.getInterActiveUserBduids());
            }
            PaInfo queryPaInfo = PaInfoDBManager.getInstance(mContext).queryPaInfo(next.getContacter());
            if (queryPaInfo != null) {
                notificationMsgData.setPainfo(queryPaInfo);
                notificationMsgData.setType(queryPaInfo.getSubtype());
            }
            arrayList2.add(notificationMsgData);
        }
        if (!Utility.readBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_USER, true) || hashSet.size() <= 0) {
            iFetchNotificationDataListener.onFetchResult(arrayList2, arrayList2.size() >= i);
            return;
        }
        final ArrayList arrayList3 = new ArrayList(hashSet);
        List<Long> notExpiredChatUserByBduids = ChatUserDBManager.getInstance(mContext).getNotExpiredChatUserByBduids(arrayList3, System.currentTimeMillis() - 600000);
        ArrayList arrayList4 = new ArrayList(arrayList3);
        arrayList4.removeAll(notExpiredChatUserByBduids);
        ChatUserManagerImpl.getInstance(mContext).updateUserIdentity(arrayList4, new IGetUserIdentityListener() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.8
            @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
            public void onGetUserIdentityResult(int i2, List<ChatUser> list) {
                if (i2 == 0 && list != null && list.size() > 0) {
                    ChatUserDBManager.getInstance(ChatMsgManagerImpl.mContext).updateUserIdentity(list);
                }
                LongSparseArray<ChatUser> chatUserByBduids = ChatUserDBManager.getInstance(ChatMsgManagerImpl.mContext).getChatUserByBduids(arrayList3);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    NotificationMsgData notificationMsgData2 = (NotificationMsgData) it2.next();
                    if (chatUserByBduids != null && notificationMsgData2.getMsg().getMsgType() == 24) {
                        for (Long l : notificationMsgData2.getUids()) {
                            notificationMsgData2.updateUserInfo(chatUserByBduids.get(l.longValue()));
                        }
                    }
                    if (notificationMsgData2.getMsg() != null) {
                        LogUtils.d(ChatMsgManagerImpl.TAG, "callBackNotificationMsgData msg = " + notificationMsgData2.getMsg().toString());
                    }
                    if (notificationMsgData2.getPainfo() != null) {
                        LogUtils.d(ChatMsgManagerImpl.TAG, "callBackNotificationMsgData painfo = " + notificationMsgData2.getPainfo().toString());
                    }
                }
                iFetchNotificationDataListener.onFetchResult(arrayList2, arrayList2.size() >= i);
            }
        });
    }

    public void registerMessageReceiveListener(IMessageReceiveListener iMessageReceiveListener) {
        LogUtils.e(TAG, "registerMessageReceiveListener : " + iMessageReceiveListener);
        if (iMessageReceiveListener != null && !this.mReceiveListeners.contains(iMessageReceiveListener)) {
            this.mReceiveListeners.add(iMessageReceiveListener);
        }
    }

    public void unregisterMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        LogUtils.e(TAG, "unregisterMessageReceiveListener : " + iMessageReceiveListener);
        if (iMessageReceiveListener != null && this.mReceiveListeners.contains(iMessageReceiveListener)) {
            this.mReceiveListeners.remove(iMessageReceiveListener);
        }
    }

    public void registerLiveMsgReceiveListener(ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        LogUtils.d(TAG, "registerLiveMsgReceiveListener : " + iLiveMsgReceiveListener);
        if (iLiveMsgReceiveListener != null) {
            this.mReceiveStudioListener = iLiveMsgReceiveListener;
        }
    }

    public void registerLiveMsgReceiveListener(String str, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        LogUtils.d(TAG, "registerLiveMsgReceiveListener : " + iLiveMsgReceiveListener + ", mcastid = " + str);
        if (iLiveMsgReceiveListener != null) {
            this.mReceiveStudioListeners.put(str, iLiveMsgReceiveListener);
        }
    }

    public void registerMessageSyncListener(Context context, IMessageSyncListener iMessageSyncListener) {
        if (iMessageSyncListener != null && !this.mMessageSyncListener.contains(iMessageSyncListener)) {
            this.mMessageSyncListener.add(iMessageSyncListener);
        }
    }

    public void unregisterLiveMsgReceiveListener(ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        LogUtils.d(TAG, "unregisterLiveMsgReceiveListener : " + iLiveMsgReceiveListener);
        this.mReceiveStudioListener = null;
    }

    public void unregisterLiveMsgReceiveListener(String str) {
        LogUtils.d(TAG, "do unregisterLiveMsgReceiveListener, mcastid = " + str);
        if (!TextUtils.isEmpty(str) && this.mReceiveStudioListeners.remove(str) != null) {
            LogUtils.d(TAG, " do unregisterLiveMsgReceiveListener done!!! ");
        }
    }

    public void unregisterMessageSyncListener(Context context, IMessageSyncListener iMessageSyncListener) {
        if (iMessageSyncListener != null && this.mMessageSyncListener.contains(iMessageSyncListener)) {
            this.mMessageSyncListener.remove(iMessageSyncListener);
        }
    }

    public void broadDeleteGroupMsg(Context context, ArrayList<ChatMsg> arrayList) {
        sendMessageBroadcast(context, arrayList);
    }

    private void sendMessageBroadcast(Context context, ArrayList<ChatMsg> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            try {
                Intent intent = new Intent(IMConstants.MESSAGE_ACTION);
                intent.setPackage(context.getApplicationContext().getPackageName());
                intent.putParcelableArrayListExtra(IMConstants.MESSAGE, arrayList);
                mContext.sendBroadcast(intent);
            } catch (Exception e) {
                LogUtils.e(TAG, " sendMessageBoradcast exception ");
                new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
            }
        }
    }

    private ArrayList<ChatMsg> filtMsgs(ArrayList<ChatMsg> arrayList) {
        if (arrayList == null) {
            return null;
        }
        ArrayList<ChatMsg> arrayList2 = new ArrayList<>();
        Iterator<ChatMsg> it = arrayList.iterator();
        while (it.hasNext()) {
            ChatMsg next = it.next();
            if (!IMConfigInternal.getInstance().getIMConfig(mContext).isNeedPaid() || Utility.getPaid(mContext) == next.getPaid()) {
                if (next.isSameDevice()) {
                    LogUtils.d(TAG, "msg is same device." + next.getMsgId());
                } else {
                    arrayList2.add(next);
                }
            }
        }
        return arrayList2;
    }

    public void fetchMsgidByMsgid(Context context, int i, long j, long j2, long j3, int i2, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener, int i5) {
        Intent creatMethodIntent;
        String addListener = ListenerManager.getInstance().addListener(iFetchMsgByIdListener);
        LogUtils.i(TAG, " category: " + i + " contacter: " + j + " beginMsgid: " + j2 + " endMsgid: " + j3 + " count: " + i2 + " triggerReason: " + i3 + " jumpToRecentMsg: " + i4 + " key: " + addListener);
        if (j2 < 0 || j3 < 0) {
            onFetchMsgByIdResult(context, 1005, Constants.ERROR_MSG_PARAMETER_ERROR, i, j, j2, j3, i2, -1, 0L, null, null, addListener);
        } else if (AccountManager.isLogin(context)) {
            if (a.ayp && i == 4) {
                creatMethodIntent = Utility.createMcastMethodIntent(context, 93);
            } else {
                creatMethodIntent = Utility.creatMethodIntent(context, 93);
            }
            creatMethodIntent.putExtra("category", i);
            creatMethodIntent.putExtra("contacter", j);
            creatMethodIntent.putExtra(Constants.EXTRA_BEGIN_MSGID, j2);
            creatMethodIntent.putExtra(Constants.EXTRA_END_MSGID, j3);
            creatMethodIntent.putExtra("count", i2);
            creatMethodIntent.putExtra(Constants.EXTRA_TRIGGER_REASON, i3);
            creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            creatMethodIntent.putExtra(Constants.EXTRA_JUMP_MSG, i4);
            creatMethodIntent.putExtra(Constants.EXTRA_RETRY_TIME, i5);
            try {
                a.al(mContext).e(mContext, creatMethodIntent);
            } catch (Exception e) {
                onFetchMsgByIdResult(context, 6, "start service exception", i, j, j2, j3, i2, -1, 0L, null, null, addListener);
                LogUtils.e(TAG, "Exception ", e);
            }
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            onFetchMsgByIdResult(context, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, i, j, j2, j3, i2, -1, 0L, null, null, addListener);
        }
    }

    public void fetchMsgidByMsgid(Context context, int i, long j, long j2, long j3, int i2, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener) {
        fetchMsgidByMsgid(context, i, j, j2, j3, i2, i3, i4, iFetchMsgByIdListener, 0);
    }

    public void onFetchMsgByIdResult(Context context, int i, String str, int i2, long j, long j2, long j3, int i3, int i4, long j4, String str2, ArrayList<ChatMsg> arrayList, String str3) {
        if (arrayList != null) {
            LogUtils.d(TAG, "onFetchMsgByIdResult----errorCode: " + i + " msg:" + str + ", contacter:" + j + ",fetchedMsgs size " + arrayList.size());
        } else {
            LogUtils.d(TAG, "onFetchMsgByIdResult----errorCode: " + i + " msg:" + str + ", contacter:" + j + ",fetchedMsgs is null.");
        }
        if (arrayList != null && arrayList.size() == 1) {
            try {
                int currentTimeMillis = (int) (System.currentTimeMillis() - Long.parseLong(str3.substring(1, 14)));
            } catch (Exception e) {
                LogUtils.e(TAG, "get message receive time error", e);
                new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
            }
        }
        IMListener removeListener = ListenerManager.getInstance().removeListener(str3);
        if (removeListener != null && (removeListener instanceof IFetchMsgByIdListener)) {
            ((IFetchMsgByIdListener) removeListener).onFetchMsgByIdResult(i, str, str2, i2, j, j2, j3, i3, i4, j4, arrayList);
        } else {
            LogUtils.i(TAG, "onFetchMsgByIdResult listener is null or error!!");
        }
    }

    public void fetchConfigMsg(Context context, long j, long j2) {
        LogUtils.i(TAG, " limit: " + j2 + " cursor: " + j);
        Intent creatMethodIntent = Utility.creatMethodIntent(context, 193);
        creatMethodIntent.putExtra(Constants.EXTRA_CONFIG_CURSOR, j);
        creatMethodIntent.putExtra(Constants.EXTRA_CONFIG_LIMIT, j2);
        try {
            a.al(mContext).e(mContext, creatMethodIntent);
        } catch (Exception e) {
            LogUtils.e(TAG, "Exception ", e);
        }
    }

    public int getNewMsgCount() {
        if (getPaid() == -2) {
            return -1017;
        }
        return ChatMessageDBManager.getInstance(mContext).getNewMsgCount(getPaid());
    }

    public int getNewMsgCountByPaid(long j) {
        return ChatMessageDBManager.getInstance(mContext).getUnReadMsgCount(getChatObject(0, j, j));
    }

    public int saveAsDraftMsg(ChatMsg chatMsg) {
        if (chatMsg == null) {
            return -1;
        }
        if (getPaid() == -2) {
            return -1017;
        }
        deleteDraftMsg(chatMsg.getCategory(), chatMsg.getContacter());
        if (chatMsg instanceof TextMsg) {
            TextMsg textMsg = (TextMsg) chatMsg;
            if (TextUtils.isEmpty(chatMsg.getMsgContent()) || TextUtils.isEmpty(textMsg.getText())) {
                return -1;
            }
            chatMsg.setPaid(getPaid());
            chatMsg.setMsgId(IMConstants.DRAFT_MSGID);
            chatMsg.setStatus(3);
            chatMsg.setMsgReaded(1);
            return ChatMessageDBManager.getInstance(mContext).addMsg(chatMsg, true) < 0 ? -1 : 0;
        }
        return -1;
    }

    public int deleteDraftMsg(int i, long j) {
        if (getPaid() == -2) {
            return -1017;
        }
        return ChatMessageDBManager.getInstance(mContext).deleteDraftMsg(getChatObject(i, j, getPaid()));
    }

    public ChatMsg getDraftMsg(int i, long j) {
        return ChatMessageDBManager.getInstance(mContext).getDraftMsg(i, j);
    }

    public int deleteMsgs(ChatMsg chatMsg) {
        if (chatMsg.getStatus() != 0) {
            return ((long) ChatMessageDBManager.getInstance(mContext).deleteChatMsg(chatMsg)) < 0 ? -1009 : 0;
        }
        deleteMsgs(chatMsg.getCategory(), chatMsg.getContacter(), new long[]{chatMsg.getMsgId()}, chatMsg.isZhida());
        return 0;
    }

    public void audioTrans(String str, String str2, String str3, int i, BIMValueCallBack bIMValueCallBack) {
        LogUtils.d(TAG, "audioTrans filePath=" + str);
        new IMAudioTransRequest(mContext, str, str2, str3, i, ListenerManager.getInstance().addListener(bIMValueCallBack)).execute();
    }

    public void onAudioTransCallBack(String str, int i, String str2, String str3) {
        LogUtils.d(TAG, "onAudioTransCallBack----errorCode: " + i + " msg: " + str2);
        BIMValueCallBack bIMValueCallBack = (BIMValueCallBack) ListenerManager.getInstance().removeListener(str);
        if (bIMValueCallBack != null) {
            bIMValueCallBack.onResult(i, str2, str3);
        } else {
            LogUtils.d(TAG, "onAudioTransCallBack listener is null");
        }
    }

    public void genBosObjectUrl(String str, String str2, String str3, int i, int i2, int i3, IGenBosObjectUrlListener iGenBosObjectUrlListener) {
        LogUtils.d(TAG, "filePath=" + str);
        IMGenBosObjectUrlRequest iMGenBosObjectUrlRequest = new IMGenBosObjectUrlRequest(mContext, str, str2, str3, i, i2, i3, ListenerManager.getInstance().addListener(iGenBosObjectUrlListener));
        HttpHelper.executor(mContext, iMGenBosObjectUrlRequest, iMGenBosObjectUrlRequest);
    }

    public void onGenBosObjectUrl(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
        LogUtils.d(TAG, "onGenBosObjectUrl----errorCode: " + i + " msg: " + str2);
        IGenBosObjectUrlListener iGenBosObjectUrlListener = (IGenBosObjectUrlListener) ListenerManager.getInstance().removeListener(str);
        if (iGenBosObjectUrlListener != null) {
            iGenBosObjectUrlListener.onGenBosObjectUrlListener(i, str2, str3, str4, map);
        } else {
            LogUtils.d(TAG, "onGenBosObjectUrl is null");
        }
    }

    public int markMessageClicked(ChatMsg chatMsg) {
        chatMsg.setIsClicked(true);
        return ChatMessageDBManager.getInstance(mContext).markMsgClicked(chatMsg);
    }

    public long getPaid() {
        if (IMConfigInternal.getInstance().getIMConfig(mContext).isNeedPaid()) {
            long paid = Utility.getPaid(mContext);
            if (paid == -1) {
                return -2L;
            }
            return paid;
        }
        return -1L;
    }

    public ChatObject getChatObject(int i, long j, long j2) {
        return new ChatObject(mContext, i, j, j2, -1);
    }

    public void tryPutPaid(Intent intent) {
        if (IMConfigInternal.getInstance().getIMConfig(mContext).isNeedPaid()) {
            intent.putExtra(Constants.EXTRA_PA_ID, getPaid());
        }
    }

    public ArrayList<ChatMsg> fetchMessageSync(int i, long j, int i2, ChatMsg chatMsg) {
        if (getPaid() == -2) {
            return null;
        }
        if (1 == i) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.valueOf(j));
            ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList);
            if (groupInfo != null && groupInfo.size() > 0 && groupInfo.get(0).getType() == 2) {
                return GroupMessageDAOImpl.fetchLastChatMsg(mContext, String.valueOf(j), chatMsg, i2, true);
            }
            return GroupMessageDAOImpl.fetchAllChatMsg(mContext, String.valueOf(j), chatMsg, i2, true);
        }
        return ChatMessageDBManager.getInstance(mContext).fetchMsg(getChatObject(i, j, getPaid()), chatMsg == null ? 0L : chatMsg.getMsgId(), i2, chatMsg == null ? -1L : chatMsg.getRowId());
    }

    public ArrayList<ChatMsg> fetchMessageSync(int i, long j, int i2, ChatMsg chatMsg, long[] jArr) {
        if (getPaid() == -2) {
            return null;
        }
        return GroupMessageDAOImpl.fetchAllChatMsg(mContext, String.valueOf(j), chatMsg, i2, true, jArr);
    }

    public ArrayList<ChatMsg> fetchMessageSync(int i, long j, int i2, boolean z, ChatMsg chatMsg) {
        if (getPaid() == -2) {
            return null;
        }
        if (1 == i) {
            return GroupMessageDAOImpl.fetchAllChatMsg(mContext, String.valueOf(j), chatMsg, i2, z);
        }
        return ChatMessageDBManager.getInstance(mContext).fetchMsg(getChatObject(i, j, getPaid()), chatMsg, i2, z);
    }

    public ArrayList<ChatMsg> fetchMessageSyncExceptSystemMsg(int i, long j, int i2, boolean z, ChatMsg chatMsg) {
        if (getPaid() == -2) {
            return null;
        }
        if (1 == i) {
            return GroupMessageDAOImpl.fetchChatMsgExceptGroupSystem(mContext, String.valueOf(j), chatMsg, i2, z);
        }
        return ChatMessageDBManager.getInstance(mContext).fetchMsgsExceptGroupSystemMsgSync(getChatObject(i, j, getPaid()), chatMsg == null ? 0L : chatMsg.getMsgId(), i2, chatMsg == null ? -1L : chatMsg.getRowId(), z);
    }

    public int updateChatSeesionName(ChatSession chatSession) {
        return ChatMessageDBManager.getInstance(mContext).updateChatSessionName(chatSession);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void broadcastMessage(ArrayList<ChatMsg> arrayList, boolean z) {
        synchronized (this.mReceiveListeners) {
            if (arrayList != null) {
                if (arrayList.size() != 0) {
                    LogUtils.d(TAG, " recive message before filter! " + arrayList.size());
                    ArrayList<ChatMsg> filtMsgs = z ? filtMsgs(arrayList) : arrayList;
                    if (filtMsgs != null && filtMsgs.size() != 0) {
                        LogUtils.d(TAG, "you xiaoxi" + arrayList.size());
                        Iterator<IMessageReceiveListener> it = this.mReceiveListeners.iterator();
                        while (it.hasNext()) {
                            IMessageReceiveListener next = it.next();
                            if (next != null) {
                                next.onReceiveMessage(0, 0, filtMsgs);
                            }
                        }
                        int size = filtMsgs.size();
                        int i = size / 20;
                        int i2 = size % 20;
                        for (int i3 = 0; i3 < i; i3++) {
                            sendMessageBroadcast(mContext, new ArrayList<>(filtMsgs.subList(20 * i3, (i3 + 1) * 20)));
                        }
                        if (i2 > 0) {
                            sendMessageBroadcast(mContext, new ArrayList<>(filtMsgs.subList(size - i2, size)));
                        }
                    }
                }
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    private String getMsgUUid(ChatMsg chatMsg) {
        return chatMsg == null ? "" : String.format("send.user.msg.%d.%d", Long.valueOf(chatMsg.getRowId()), Integer.valueOf(chatMsg.getCategory()));
    }

    public void onSyncDialogResult(int i, String str, String str2, long j, List<ChatMsg> list) {
        LogUtils.d(TAG, String.format("--onSyncDialogResult--errCode:%d--msg:%s--maxMsgid:%d", Integer.valueOf(i), str, Long.valueOf(j)));
        IMListener removeListener = ListenerManager.getInstance().removeListener(str2);
        if (removeListener != null && (removeListener instanceof ISyncDialogListener)) {
            ((ISyncDialogListener) removeListener).onSyncDialogResult(i, str, j, list);
        } else {
            LogUtils.d(TAG, "onSyncDialogResult listener is nul!");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getMaxMsgid() {
        return Math.max(Utility.readLongData(mContext, "sync_max_msgid_" + Utility.getUK(mContext), 0L), DialogRecordDBManager.getInstance(mContext).getMaxMsgid());
    }

    public ArrayList<ChatMsg> fetchGroupNotifyMsgsSync(int i, long j, int i2, boolean z, ChatMsg chatMsg) {
        if (1 == i) {
            return GroupMessageDAOImpl.fetchGroupSystemMsg(mContext, String.valueOf(j), chatMsg, i2, z);
        }
        return ChatMessageDBManager.getInstance(mContext).fetchSpecifyMsgsSync(getChatObject(i, j, getPaid()), 101, chatMsg == null ? 0L : chatMsg.getMsgId(), i2, chatMsg == null ? -1L : chatMsg.getRowId(), z);
    }

    public boolean registerNotify(String str, String str2, String str3, IOnRegisterNotifyListener iOnRegisterNotifyListener) {
        return BindStateManager.startBindPush(mContext, str, str2, str3, iOnRegisterNotifyListener);
    }

    public void unRegisterNotify(IOnRegisterNotifyListener iOnRegisterNotifyListener) {
        String addListener = ListenerManager.getInstance().addListener(iOnRegisterNotifyListener);
        if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
            try {
                BindStateManager.saveUnBindInfo(mContext, AccountManager.getToken(mContext), Utility.getIMDeviceId(mContext), Long.valueOf(AccountManager.getUK(mContext)));
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 92);
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                a.al(mContext).e(mContext, creatMethodIntent);
                return;
            } catch (Exception e) {
                onUnRegisterNotifyResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR);
                LogUtils.e(TAG, "Exception ", e);
                return;
            }
        }
        onUnRegisterNotifyResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
    }

    public void onUnRegisterNotifyResult(String str, int i, String str2) {
        LogUtils.d(TAG, "onUnRegisterNotifyResult----errorCode: " + i + " msg: " + str2);
        if (i == 0) {
            BindStateManager.setunBindPush(mContext);
        }
        IOnRegisterNotifyListener iOnRegisterNotifyListener = (IOnRegisterNotifyListener) ListenerManager.getInstance().removeListener(str);
        if (iOnRegisterNotifyListener != null) {
            iOnRegisterNotifyListener.onUnRegisterNotifyResult(i, str2);
        }
    }

    private void deliverMcastMessage(JSONArray jSONArray) {
        LogUtils.d(TAG, "old deliverMcastMessage deliver");
        onDeliverMcastResponse("", jSONArray, this.mReceiveStudioListener, null);
    }

    public void deliverMcastMessage(String str, JSONArray jSONArray) {
        onDeliverMcastResponse(str, jSONArray, this.mReceiveStudioListeners.get(str), null);
        deliverMcastMessage(jSONArray);
    }

    public void deliverReliableMcastMessage(String str, JSONArray jSONArray, List<Long> list) {
        onDeliverMcastResponse(str, jSONArray, this.mReceiveStudioListeners.get(str), list);
        deliverMcastMessage(jSONArray);
    }

    private void onDeliverMcastResponse(String str, JSONArray jSONArray, ILiveMsgReceiveListener iLiveMsgReceiveListener, List<Long> list) {
        if (jSONArray == null) {
            LogUtils.e(TAG, "deliverMcastMessage msgObj is null");
            return;
        }
        LogUtils.d(TAG, "deliverMcastMessage_size is " + jSONArray.length());
        JSONArray jSONArray2 = new JSONArray();
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i <= jSONArray.length(); i++) {
            try {
                jSONArray2.put(jSONArray.getJSONObject(i - 1));
                if (i % 10 == 0) {
                    onDeliverResponse(str, jSONArray2, iLiveMsgReceiveListener, arrayList);
                    JSONArray jSONArray3 = new JSONArray();
                    try {
                        arrayList.clear();
                        jSONArray2 = jSONArray3;
                    } catch (JSONException e) {
                        jSONArray2 = jSONArray3;
                        e = e;
                        LogUtils.e(TAG, "Exception ", e);
                        new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
                    }
                }
            } catch (JSONException e2) {
                e = e2;
            }
        }
        if (jSONArray2.length() > 0) {
            onDeliverResponse(str, jSONArray2, iLiveMsgReceiveListener, arrayList);
        }
    }

    private void onDeliverResponse(String str, JSONArray jSONArray, ILiveMsgReceiveListener iLiveMsgReceiveListener, List<Long> list) {
        if (iLiveMsgReceiveListener != null) {
            iLiveMsgReceiveListener.onReceiveMessage(0, jSONArray);
            LogUtils.d(TAG, "listener != null and onDeliverResponse arr size :" + jSONArray.length());
            return;
        }
        LogUtils.d(TAG, "mReceiveStudioListener is null");
    }

    public void fetchMsgRequst(long j, long j2, int i, long j3, long j4, long j5, int i2, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        LogUtils.d(TAG, "fetchMsgRequst ---> begin :" + j4 + ", end :" + j5);
        IMFetchMsgRequest iMFetchMsgRequest = new IMFetchMsgRequest(mContext, ListenerManager.getInstance().addListener(iFetchMsgByIdListener), j, j2, j3, i, i2, j4, j5, z);
        HttpHelper.executor(mContext, iMFetchMsgRequest, iMFetchMsgRequest);
    }

    public void fetchMsgByHostRequst(long j, int i, long j2, long j3, long j4, int i2, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        LogUtils.d(TAG, "fetchMsgByHostRequst ---> begin :" + j3 + ", end :" + j4);
        IMFetchMsgByHostRequest iMFetchMsgByHostRequest = new IMFetchMsgByHostRequest(mContext, ListenerManager.getInstance().addListener(iFetchMsgByIdListener), j, j2, i, i2, j3, j4, z);
        HttpHelper.executor(mContext, iMFetchMsgByHostRequest, iMFetchMsgByHostRequest);
    }

    public void deliverFetchedConfigMessage(final ArrayList<ChatMsg> arrayList) {
        TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.9
            @Override // java.lang.Runnable
            public void run() {
                LogUtils.d(ChatMsgManagerImpl.TAG, "deliverFetchedConfigMessage ..... ");
                ChatMsgManagerImpl.this.deliverConfigMessage(arrayList);
            }
        });
    }

    public void deliverConfigMessage(ArrayList<ChatMsg> arrayList) {
        synchronized (this.mReceiveListeners) {
            if (arrayList != null) {
                if (arrayList.size() != 0) {
                    Iterator<IMessageReceiveListener> it = this.mReceiveListeners.iterator();
                    while (it.hasNext()) {
                        IMessageReceiveListener next = it.next();
                        if (next != null) {
                            next.onReceiveMessage(0, 2, arrayList);
                        }
                    }
                    return;
                }
            }
            LogUtils.e(TAG, "deliverConfigMessage msgs is null");
        }
    }

    public void configMsgsFilter(ArrayList<ChatMsg> arrayList) {
        int i = 0;
        ArrayList<Long> cachedConfigMsgIds = getInstance(mContext).getCachedConfigMsgIds();
        int size = cachedConfigMsgIds.size();
        LogUtils.d(TAG, "configMsgsFilter oldCachedIdsSize=" + size);
        if (size > 0 && !arrayList.isEmpty()) {
            long j = 0;
            int i2 = 0;
            while (i2 < arrayList.size()) {
                long msgId = arrayList.get(i2).getMsgId();
                if (cachedConfigMsgIds.contains(Long.valueOf(msgId))) {
                    cachedConfigMsgIds.remove(Long.valueOf(msgId));
                    arrayList.remove(i2);
                    i2--;
                }
                if (msgId > j) {
                    j = msgId;
                }
                i2++;
            }
            while (i < cachedConfigMsgIds.size()) {
                long longValue = cachedConfigMsgIds.get(i).longValue();
                if (longValue <= j) {
                    cachedConfigMsgIds.remove(Long.valueOf(longValue));
                    i--;
                }
                i++;
            }
            if (size != cachedConfigMsgIds.size()) {
                configMsgIdsPersiser(cachedConfigMsgIds);
            }
        }
    }

    public void persisConfigMsgIds(ArrayList<ChatMsg> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<Long> cachedConfigMsgIds = getCachedConfigMsgIds();
            if (cachedConfigMsgIds.size() >= 1000) {
                cachedConfigMsgIds.clear();
            }
            Iterator<ChatMsg> it = arrayList.iterator();
            while (it.hasNext()) {
                cachedConfigMsgIds.add(Long.valueOf(it.next().getMsgId()));
            }
            configMsgIdsPersiser(cachedConfigMsgIds);
        }
    }

    private void configMsgIdsPersiser(ArrayList<Long> arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < size; i++) {
                stringBuffer.append(arrayList.get(i));
                if (i < size - 1) {
                    stringBuffer.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            LogUtils.d(TAG, "configMsgIdsPersiser ids = " + stringBuffer.toString());
            Utility.writeConfigMsgIds(mContext, stringBuffer.toString());
        }
    }

    public ArrayList<Long> getCachedConfigMsgIds() {
        String configMsgIds = Utility.getConfigMsgIds(mContext);
        LogUtils.d(TAG, "getCachedConfigMsgIds str = " + configMsgIds);
        ArrayList<Long> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(configMsgIds)) {
            try {
                String[] split = configMsgIds.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length > 0) {
                    for (String str : split) {
                        arrayList.add(Long.valueOf(Long.parseLong(str)));
                    }
                }
            } catch (Exception e) {
                LogUtils.e(TAG, e.getMessage());
                new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
            }
        }
        LogUtils.d(TAG, "getCachedConfigMsgIds back arr size = " + arrayList.size());
        return arrayList;
    }

    public long getMaxReliableMsgId(long j) {
        return ChatMessageDBManager.getInstance(mContext).getMaxReliableMsgId(j);
    }

    public void setInterActiveMsgStatus(long j, long j2, int i, int i2) {
        ChatMsg chatMsgByMsgId = ChatMessageDBManager.getInstance(mContext).getChatMsgByMsgId(j);
        if (chatMsgByMsgId instanceof InterActiveMsg) {
            String jsonContent = ((InterActiveMsg) chatMsgByMsgId).getJsonContent();
            if (i == 0 || i == 1) {
                chatMsgByMsgId.setMsgContent(replaceInterActiveBottomBarStatus(jsonContent, i, i2));
                ChatMessageDBManager.getInstance(mContext).updateMsgStatus(chatMsgByMsgId);
            } else if (i == 2) {
                ChatUser chatUserByBuid = ChatUserDBManager.getInstance(mContext).getChatUserByBuid(j2);
                if (chatUserByBuid != null) {
                    chatUserByBuid.setSubscribe(i2);
                    ChatUserDBManager.getInstance(mContext).updateUserByBduid(chatUserByBuid);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(j2));
                ChatUserManagerImpl.getInstance(mContext).updateUserIdentity(arrayList, new IGetUserIdentityListener() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.10
                    @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
                    public void onGetUserIdentityResult(int i3, List<ChatUser> list) {
                        if (i3 == 0) {
                            ChatUserDBManager.getInstance(ChatMsgManagerImpl.mContext).updateUserIdentity(list);
                        }
                    }
                });
            }
        }
    }

    private String replaceInterActiveBottomBarStatus(String str, int i, int i2) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("interact_ext");
            if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("bottom_bars")) != null) {
                if (i == 0) {
                    JSONObject optJSONObject4 = optJSONObject.optJSONObject("reply");
                    if (optJSONObject4 != null) {
                        optJSONObject4.put("click_status", i2);
                    }
                } else if (i == 1 && (optJSONObject2 = optJSONObject.optJSONObject(FeedData.TYPE_ZAN)) != null) {
                    optJSONObject2.put("click_status", i2);
                }
            }
            str = jSONObject.toString();
            return str;
        } catch (JSONException e) {
            LogUtils.e(TAG, e.getMessage());
            new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
            return str;
        }
    }

    public boolean updateMsgContent(ChatMsg chatMsg) {
        return ChatMessageDBManager.getInstance(mContext).updateChatMsgContent(chatMsg) > 0;
    }

    public ChatMsg getMsgByMsgId(long j) {
        return ChatMessageDBManager.getInstance(mContext).getMsgByMsgId(j);
    }

    public void mediaFetchChatMsgs(Context context, long j, long j2, long j3, int i, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        LogUtils.d(TAG, "BC> contactor=" + j + ", beginMsgTime=" + j2 + ", endMsgTime=" + j3 + ", count=" + i + ", listener=" + iMediaFetchChatMsgsListener);
        if (!AccountManager.getMediaRole(context)) {
            iMediaFetchChatMsgsListener.onMediaFetchChatMsgsResult(2000, null, false, null);
            return;
        }
        IMMediaFetchMsgHttpRequest iMMediaFetchMsgHttpRequest = new IMMediaFetchMsgHttpRequest(mContext, j, j2, j3, i, ListenerManager.getInstance().addListener(iMediaFetchChatMsgsListener));
        HttpHelper.executor(context, iMMediaFetchMsgHttpRequest, iMMediaFetchMsgHttpRequest);
    }

    public void mediaFetchChatMsgs(Context context, long j, int i, long j2, String str, long j3, long j4, int i2, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", beginMsgTime=" + j3 + ", endMsgTime=" + j4 + ", count=" + i2 + ", listener=" + iMediaFetchChatMsgsListener);
        if (!AccountManager.getMediaRole(context)) {
            iMediaFetchChatMsgsListener.onMediaFetchChatMsgsResult(2000, null, false, null);
            return;
        }
        IMMediaFetchMsgHttpRequest iMMediaFetchMsgHttpRequest = new IMMediaFetchMsgHttpRequest(mContext, j, i, j2, str, j3, j4, i2, ListenerManager.getInstance().addListener(iMediaFetchChatMsgsListener));
        HttpHelper.executor(context, iMMediaFetchMsgHttpRequest, iMMediaFetchMsgHttpRequest);
    }

    public void mediaSendChatMsg(long j, int i, long j2, String str, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", listener=" + iMediaSendChatMsgListener + ", sendMsg=" + chatMsg);
        if (!AccountManager.getMediaRole(mContext)) {
            iMediaSendChatMsgListener.onMediaSendChatMsgResult(2000, chatMsg);
            return;
        }
        IMMediaSendMsgHttpRequest iMMediaSendMsgHttpRequest = new IMMediaSendMsgHttpRequest(mContext, j, i, j2, str, chatMsg, ListenerManager.getInstance().addListener(iMediaSendChatMsgListener));
        HttpHelper.executor(mContext, iMMediaSendMsgHttpRequest, iMMediaSendMsgHttpRequest);
    }

    public void mediaSendChatMsg(long j, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        LogUtils.d(TAG, "BC> contactor=" + j + ", listener=" + iMediaSendChatMsgListener + ", sendMsg=" + chatMsg);
        if (!AccountManager.getMediaRole(mContext)) {
            iMediaSendChatMsgListener.onMediaSendChatMsgResult(2000, chatMsg);
            return;
        }
        IMMediaSendMsgHttpRequest iMMediaSendMsgHttpRequest = new IMMediaSendMsgHttpRequest(mContext, j, chatMsg, ListenerManager.getInstance().addListener(iMediaSendChatMsgListener));
        HttpHelper.executor(mContext, iMMediaSendMsgHttpRequest, iMMediaSendMsgHttpRequest);
    }

    public void mediaDeleteChatMsg(long j, long j2, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        LogUtils.d(TAG, "BC> contactor=" + j + ", listener=" + iMediaDeleteChatMsgListener + ", needDeleteMsgIds=" + list + ", maxDeleteMsgId=" + j2);
        if (!AccountManager.getMediaRole(mContext)) {
            iMediaDeleteChatMsgListener.onMediaDeleteChatMsgResult(2000, null);
            return;
        }
        IMMediaDeleteMsgHttpRequest iMMediaDeleteMsgHttpRequest = new IMMediaDeleteMsgHttpRequest(mContext, j, j2, list, ListenerManager.getInstance().addListener(iMediaDeleteChatMsgListener));
        HttpHelper.executor(mContext, iMMediaDeleteMsgHttpRequest, iMMediaDeleteMsgHttpRequest);
    }

    public void mediaDeleteChatMsg(long j, int i, long j2, String str, long j3, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", listener=" + iMediaDeleteChatMsgListener + ", needDeleteMsgIds=" + list + ", maxDeleteMsgId=" + j3);
        if (!AccountManager.getMediaRole(mContext)) {
            iMediaDeleteChatMsgListener.onMediaDeleteChatMsgResult(2000, null);
            return;
        }
        IMMediaDeleteMsgHttpRequest iMMediaDeleteMsgHttpRequest = new IMMediaDeleteMsgHttpRequest(mContext, j, i, j2, str, j3, list, ListenerManager.getInstance().addListener(iMediaDeleteChatMsgListener));
        HttpHelper.executor(mContext, iMMediaDeleteMsgHttpRequest, iMMediaDeleteMsgHttpRequest);
    }

    public void mediaRegisterChatMsgChangedListener(IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        if (iMediaChatMsgChangedListener != null) {
            this.mMediaMsgChangedListeners.put(Integer.valueOf(iMediaChatMsgChangedListener.hashCode()), iMediaChatMsgChangedListener);
        }
    }

    public void mediaUnRegisterChatMsgChangedListener(IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        if (iMediaChatMsgChangedListener != null) {
            this.mMediaMsgChangedListeners.remove(Integer.valueOf(iMediaChatMsgChangedListener.hashCode()));
        }
    }

    public void handleMediaNotifyMessage(final JSONObject jSONObject) {
        try {
            if (AccountManager.getMediaRole(mContext) && jSONObject != null && this.mMediaMsgChangedListeners != null && !this.mMediaMsgChangedListeners.isEmpty()) {
                LogUtils.i(TAG, "BC> handleMediaNotifyMessage msgobj=" + jSONObject.toString());
                TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.11
                    @Override // java.lang.Runnable
                    public void run() {
                        int optInt = jSONObject.optInt("type", -1);
                        JSONObject optJSONObject = jSONObject.optJSONObject("content");
                        long optLong = optJSONObject.optLong("contacter_bduid", -1L);
                        int optInt2 = optJSONObject.optInt("contacter_type", -1);
                        long optLong2 = optJSONObject.optLong("contacter_pauid", -1L);
                        String optString = optJSONObject.optString("contacter_third_id", "");
                        long optLong3 = optJSONObject.optLong("msgid", -1L);
                        for (Integer num : ChatMsgManagerImpl.this.mMediaMsgChangedListeners.keySet()) {
                            ((IMediaChatMsgChangedListener) ChatMsgManagerImpl.this.mMediaMsgChangedListeners.get(Integer.valueOf(num.intValue()))).onMediaChatMsgChangedResult(optInt, optLong, optInt2, optLong2, optString, optLong3);
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onMediaFetchChatMsgsResult(String str, int i, String str2, boolean z, List<ChatMsg> list) {
        IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener = (IMediaFetchChatMsgsListener) ListenerManager.getInstance().removeListener(str);
        if (iMediaFetchChatMsgsListener != null) {
            LogUtils.d(TAG, "BC> responseCode=" + i + ", strMsg=" + str2 + ", hasMore=" + z + ", msgs=" + (list != null ? list.toString() : ""));
            iMediaFetchChatMsgsListener.onMediaFetchChatMsgsResult(i, str2, z, list);
        }
    }

    public void onMediaSendChatMsgResult(String str, int i, ChatMsg chatMsg) {
        IMediaSendChatMsgListener iMediaSendChatMsgListener = (IMediaSendChatMsgListener) ListenerManager.getInstance().removeListener(str);
        if (iMediaSendChatMsgListener != null) {
            LogUtils.d(TAG, "BC> responseCode=" + i + ", msg=" + chatMsg);
            iMediaSendChatMsgListener.onMediaSendChatMsgResult(i, chatMsg);
        }
    }

    public void onMediaDeleteChatMsgResult(String str, int i, String str2) {
        IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener = (IMediaDeleteChatMsgListener) ListenerManager.getInstance().removeListener(str);
        if (iMediaDeleteChatMsgListener != null) {
            LogUtils.d(TAG, "BC> responseCode=" + i + ", msg=" + str2);
            iMediaDeleteChatMsgListener.onMediaDeleteChatMsgResult(i, str2);
        }
    }
}
