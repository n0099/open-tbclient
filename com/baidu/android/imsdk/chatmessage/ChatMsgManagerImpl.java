package com.baidu.android.imsdk.chatmessage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import androidx.annotation.NonNull;
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
import com.baidu.android.imsdk.chatmessage.messages.ImageMsg;
import com.baidu.android.imsdk.chatmessage.messages.InterActiveMsg;
import com.baidu.android.imsdk.chatmessage.messages.MessageSyncMsg;
import com.baidu.android.imsdk.chatmessage.messages.NotifyCustomerMsg;
import com.baidu.android.imsdk.chatmessage.messages.PassMsg;
import com.baidu.android.imsdk.chatmessage.messages.PassSaveMsg;
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
import com.baidu.android.imsdk.chatmessage.sync.DialogRecord;
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
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.AsyncChatTask;
import com.baidu.android.imsdk.upload.AsyncUploadTask;
import com.baidu.android.imsdk.upload.IUploadTransferListener;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.cyberplayer.sdk.dlna.DlnaManager;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.bumptech.glide.load.engine.GlideException;
import d.a.s.a;
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
/* loaded from: classes.dex */
public class ChatMsgManagerImpl {
    public static final String TAG = "ChatMsgManagerImpl";
    public static final int USER_IDENTITY_UPDATE_TIME = 600000;
    public static Context mContext;
    public static volatile ChatMsgManagerImpl mInstance;
    public IKickOutListener mKickOutListener;
    public ILiveMsgReceiveListener mReceiveStudioListener;
    public ArrayList<IMessageReceiveListener> mReceiveListeners = new ArrayList<>();
    public ArrayList<IMessageReceiveListener> mInternalReceiveListeners = new ArrayList<>();
    public HashMap<String, ILiveMsgReceiveListener> mReceiveStudioListeners = new HashMap<>();
    public final List<ILiveMsgReceiveListener> mStudioUsePaListeners = new ArrayList();
    public List<IMessageSyncListener> mMessageSyncListener = new LinkedList();
    public HashMap<Integer, IMediaChatMsgChangedListener> mMediaMsgChangedListeners = new HashMap<>();
    public boolean mUseRequestSendMsg = false;
    public Dispatcher.MsgListener onReceiveListener = new Dispatcher.MsgListener() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.3
        @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
        public void dealMessage(int i2, ChatMsg chatMsg) {
        }

        @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
        public void dealMessage(int i2, ArrayList<ChatMsg> arrayList) {
            String str = ChatMsgManagerImpl.TAG;
            LogUtils.d(str, "dealMessage triggerReason : " + i2);
            ChatMsgManagerImpl.this.broadcastMessage(arrayList, true);
        }
    };
    public Dispatcher.MsgListener messageSyncListener = new Dispatcher.MsgListener() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.4
        @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
        public void dealMessage(int i2, ChatMsg chatMsg) {
            int msgRead;
            if (chatMsg instanceof MessageSyncMsg) {
                MessageSyncMsg messageSyncMsg = (MessageSyncMsg) chatMsg;
                long changedMsgid = messageSyncMsg.getChangedMsgid();
                int changedStatus = messageSyncMsg.getChangedStatus();
                ChatMsg chatMsgByMsgId = ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).getChatMsgByMsgId(changedMsgid);
                if (chatMsgByMsgId == null) {
                    return;
                }
                int category = chatMsgByMsgId.getCategory();
                long contacter = chatMsgByMsgId.getFromUser() == AccountManager.getUK(ChatMsgManagerImpl.mContext) ? chatMsgByMsgId.getContacter() : chatMsgByMsgId.getFromUser();
                if (changedStatus == 0) {
                    msgRead = ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).deleteMsgBatch(ChatMsgManagerImpl.this.getChatObject(category, contacter, chatMsgByMsgId.getPaid()), new long[]{changedMsgid});
                    if (msgRead > 0 && ChatMsgManagerImpl.this.mMessageSyncListener != null && ChatMsgManagerImpl.this.mMessageSyncListener.size() != 0) {
                        for (IMessageSyncListener iMessageSyncListener : ChatMsgManagerImpl.this.mMessageSyncListener) {
                            if (iMessageSyncListener != null) {
                                iMessageSyncListener.onMsgDel(changedMsgid);
                            }
                        }
                    }
                } else {
                    msgRead = ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).setMsgRead(ChatMsgManagerImpl.this.getChatObject(category, contacter, chatMsgByMsgId.getPaid()), changedMsgid);
                    if (msgRead > 0 && ChatMsgManagerImpl.this.mMessageSyncListener != null && ChatMsgManagerImpl.this.mMessageSyncListener.size() != 0) {
                        for (IMessageSyncListener iMessageSyncListener2 : ChatMsgManagerImpl.this.mMessageSyncListener) {
                            if (iMessageSyncListener2 != null) {
                                iMessageSyncListener2.onMsgReaded(changedMsgid);
                            }
                        }
                    }
                }
                if (msgRead > 0) {
                    Intent intent = new Intent(IMConstants.SYNC_ACTION);
                    intent.setPackage(ChatMsgManagerImpl.mContext.getApplicationContext().getPackageName());
                    intent.putExtra(IMConstants.SYNC_MSGID, changedMsgid);
                    intent.putExtra(IMConstants.SYNC_STATUS, changedStatus);
                    intent.putExtra(IMConstants.SYNC_TYPE, 0);
                    ChatMsgManagerImpl.mContext.sendBroadcast(intent);
                }
            }
        }

        @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
        public void dealMessage(int i2, ArrayList<ChatMsg> arrayList) {
        }
    };
    public Dispatcher.MsgListener mInitCustomerListener = new Dispatcher.MsgListener() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.5
        @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
        public void dealMessage(int i2, ChatMsg chatMsg) {
            if (chatMsg instanceof NotifyCustomerMsg) {
                ChatMsgManagerImpl.this.sendNoticeBroadcast(ChatMsgManagerImpl.mContext, (NotifyCustomerMsg) chatMsg);
            }
        }

        @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
        public void dealMessage(int i2, ArrayList<ChatMsg> arrayList) {
        }
    };
    public Dispatcher.MsgListener mSwithcCustomerListener = new Dispatcher.MsgListener() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.6
        @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
        public void dealMessage(int i2, ChatMsg chatMsg) {
            if (chatMsg instanceof NotifyCustomerMsg) {
                ChatMsgManagerImpl.this.sendNoticeBroadcast(ChatMsgManagerImpl.mContext, (NotifyCustomerMsg) chatMsg);
            }
        }

        @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
        public void dealMessage(int i2, ArrayList<ChatMsg> arrayList) {
        }
    };

    public ChatMsgManagerImpl(boolean z) {
        addMessageTypes();
        registerListeners();
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

    private ChatMsg buildChatMsg(int i2, int i3, long j, int i4, String str) {
        ChatMsg textMsg;
        if (i4 == 0) {
            textMsg = new TextMsg();
        } else if (i4 == 1) {
            textMsg = new ImageMsg();
        } else if (i4 != 27) {
            textMsg = i4 != 28 ? null : new PassSaveMsg();
        } else {
            textMsg = new PassMsg();
        }
        if (textMsg != null) {
            textMsg.setMsgContent(str);
            textMsg.setContacter(j);
            textMsg.setFromUser(AccountManager.getUK(mContext));
            textMsg.setStatus(1);
            textMsg.setPaid(j);
            textMsg.setSenderUid(TextUtils.isEmpty(AccountManager.getUid(mContext)) ? "0" : AccountManager.getUid(mContext));
            textMsg.setCategory(i3);
            textMsg.setChatType(i2);
            textMsg.setMsgTime(System.currentTimeMillis() / 1000);
        }
        return textMsg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackNotificationMsgData(ArrayList<ChatMsg> arrayList, final int i2, final IFetchNotificationDataListener iFetchNotificationDataListener) {
        final ArrayList arrayList2 = new ArrayList();
        if (arrayList != null && arrayList.size() > 0) {
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
            if (Utility.readBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_USER, true) && hashSet.size() > 0) {
                final ArrayList arrayList3 = new ArrayList(hashSet);
                List<Long> notExpiredChatUserByBduids = ChatUserDBManager.getInstance(mContext).getNotExpiredChatUserByBduids(arrayList3, System.currentTimeMillis() - 600000);
                ArrayList arrayList4 = new ArrayList(arrayList3);
                arrayList4.removeAll(notExpiredChatUserByBduids);
                ChatUserManagerImpl.getInstance(mContext).updateUserIdentity(arrayList4, new IGetUserIdentityListener() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.9
                    @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
                    public void onGetUserIdentityResult(int i3, List<ChatUser> list) {
                        if (i3 == 0 && list != null && list.size() > 0) {
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
                                String str = ChatMsgManagerImpl.TAG;
                                LogUtils.d(str, "callBackNotificationMsgData msg = " + notificationMsgData2.getMsg().toString());
                            }
                            if (notificationMsgData2.getPainfo() != null) {
                                String str2 = ChatMsgManagerImpl.TAG;
                                LogUtils.d(str2, "callBackNotificationMsgData painfo = " + notificationMsgData2.getPainfo().toString());
                            }
                        }
                        IFetchNotificationDataListener iFetchNotificationDataListener2 = iFetchNotificationDataListener;
                        ArrayList arrayList5 = arrayList2;
                        iFetchNotificationDataListener2.onFetchResult(arrayList5, arrayList5.size() >= i2);
                    }
                });
                return;
            }
            iFetchNotificationDataListener.onFetchResult(arrayList2, arrayList2.size() >= i2);
            return;
        }
        iFetchNotificationDataListener.onFetchResult(arrayList2, false);
    }

    private void configMsgIdsPersiser(ArrayList<Long> arrayList) {
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < size; i2++) {
            stringBuffer.append(arrayList.get(i2));
            if (i2 < size - 1) {
                stringBuffer.append(",");
            }
        }
        String str = TAG;
        LogUtils.d(str, "configMsgIdsPersiser ids = " + stringBuffer.toString());
        Utility.writeConfigMsgIds(mContext, stringBuffer.toString());
    }

    private void deliverMcastMessage(JSONArray jSONArray) {
        LogUtils.d(TAG, "old deliverMcastMessage deliver");
        onDeliverMcastResponse("", jSONArray, this.mReceiveStudioListener, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deliverRetrieveMessage(ArrayList<ChatMsg> arrayList) {
        synchronized (this.mInternalReceiveListeners) {
            if (arrayList != null) {
                if (arrayList.size() != 0) {
                    Iterator<IMessageReceiveListener> it = this.mInternalReceiveListeners.iterator();
                    while (it.hasNext()) {
                        IMessageReceiveListener next = it.next();
                        if (next != null) {
                            next.onReceiveMessage(0, 2, arrayList);
                        }
                    }
                    return;
                }
            }
            LogUtils.e(TAG, "retrieve-->deliverRetrieveMessage msgs is null");
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
                    String str = TAG;
                    LogUtils.d(str, "msg is same device." + next.getMsgId());
                } else {
                    arrayList2.add(next);
                }
            }
        }
        return arrayList2;
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

    @SuppressLint({"DefaultLocale"})
    private String getMsgUUid(ChatMsg chatMsg) {
        return chatMsg == null ? "" : String.format("send.user.msg.%d.%d", Long.valueOf(chatMsg.getRowId()), Integer.valueOf(chatMsg.getCategory()));
    }

    private boolean hitMcastSendMsgErrorCode(int i2) {
        return i2 == 22 || i2 == 1 || i2 == 24 || i2 == 1000 || i2 == 1203 || i2 == 1204 || i2 == 1207 || i2 == 1306 || i2 == 1316 || i2 == 1314;
    }

    private void mediaGetChatSessions(int i2, int i3, final long j, final IGetNewMsgCountListener iGetNewMsgCountListener) {
        ChatSessionManagerImpl.getInstance(mContext).mediaGetChatSessions(j, Utility.getBusinessType(i2, i3), j, PaManagerImpl.getInstance(mContext).getPaThirdId(j), 0L, 1, 0, new IMediaGetChatSessionListener() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.20
            @Override // com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener
            public void onMediaGetChatSessionResult(int i4, int i5, int i6, boolean z, List<ChatSession> list) {
                int i7;
                if (i4 == 0 && list != null && list.size() > 0) {
                    for (ChatSession chatSession : list) {
                        String str = ChatMsgManagerImpl.TAG;
                        LogUtils.d(str, "b getPaNewMsgCount session = " + chatSession.toString());
                        if (chatSession.getPaid() == j) {
                            i7 = (int) chatSession.getNewMsgSum();
                            break;
                        }
                    }
                }
                i7 = 0;
                iGetNewMsgCountListener.onGetNewMsgCount(i7);
            }
        });
    }

    private boolean noSaveDB(int i2, int i3) {
        return i2 == 7 || i2 == 4 || i3 == 27;
    }

    private void onDeliverMcastResponse(String str, JSONArray jSONArray, ILiveMsgReceiveListener iLiveMsgReceiveListener, List<Long> list) {
        JSONArray jSONArray2;
        JSONException e2;
        if (jSONArray == null) {
            LogUtils.e(TAG, "deliverMcastMessage msgObj is null");
            return;
        }
        String str2 = TAG;
        LogUtils.d(str2, "deliverMcastMessage_size is " + jSONArray.length());
        JSONArray jSONArray3 = new JSONArray();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 1; i2 <= jSONArray.length(); i2++) {
            try {
                jSONArray3.put(jSONArray.getJSONObject(i2 - 1));
            } catch (JSONException e3) {
                jSONArray2 = jSONArray3;
                e2 = e3;
            }
            if (i2 % 10 == 0) {
                onDeliverResponse(str, jSONArray3, iLiveMsgReceiveListener, arrayList);
                jSONArray2 = new JSONArray();
                try {
                    arrayList.clear();
                } catch (JSONException e4) {
                    e2 = e4;
                    LogUtils.e(TAG, "Exception ", e2);
                    new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
                    jSONArray3 = jSONArray2;
                }
                jSONArray3 = jSONArray2;
            }
        }
        if (jSONArray3.length() > 0) {
            onDeliverResponse(str, jSONArray3, iLiveMsgReceiveListener, arrayList);
        }
    }

    private void onDeliverResponse(String str, JSONArray jSONArray, ILiveMsgReceiveListener iLiveMsgReceiveListener, List<Long> list) {
        if (iLiveMsgReceiveListener != null) {
            iLiveMsgReceiveListener.onReceiveMessage(0, jSONArray);
            String str2 = TAG;
            LogUtils.d(str2, "listener != null and onDeliverResponse arr size :" + jSONArray.length());
            return;
        }
        LogUtils.d(TAG, "mReceiveStudioListener is null");
    }

    private void onSendStudioMsgResult(int i2, ChatMsg chatMsg, long j, String str) {
        if (i2 != 0 && !hitMcastSendMsgErrorCode(i2) && useRequestSendMsg() && !this.mUseRequestSendMsg) {
            sendMessageRequest(chatMsg, str);
            return;
        }
        IMListener removeListener = ListenerManager.getInstance().removeListener(str);
        if (removeListener != null && (removeListener instanceof ISendMessageListener)) {
            ((ISendMessageListener) removeListener).onSendMessageResult(i2, chatMsg);
        } else {
            LogUtils.d(TAG, "ISendMessageListener is null");
        }
        updateChatMsgStatus(chatMsg, i2);
        if (i2 != 0) {
            String str2 = TAG;
            LogUtils.d(str2, "onSendStudioMsgResult----errorCode: " + i2);
        }
        if (chatMsg != null) {
            ListenerManager.getInstance().removeListener(chatMsg.mListenerKey);
        }
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

    private String replaceInterActiveBottomBarStatus(String str, int i2, int i3) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("interact_ext");
            if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("bottom_bars")) != null) {
                if (i2 == 0) {
                    JSONObject optJSONObject4 = optJSONObject.optJSONObject("reply");
                    if (optJSONObject4 != null) {
                        optJSONObject4.put("click_status", i3);
                    }
                } else if (i2 == 1 && (optJSONObject2 = optJSONObject.optJSONObject(FeedData.TYPE_ZAN)) != null) {
                    optJSONObject2.put("click_status", i3);
                }
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            LogUtils.e(TAG, e2.getMessage());
            new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
            return str;
        }
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
        if (rowId >= 0) {
            chatMsg.setRowId(rowId);
            String str = "" + chatMsg.getRowId();
            String msgUUid = getMsgUUid(chatMsg);
            String chatObject = getChatObject(chatMsg.getCategory(), chatMsg.getContacter(), chatMsg.getPaid()).toString();
            if (TextUtils.isEmpty(msgUUid) || DBManager.getInstance(mContext).getCmdQueueMsg(msgUUid, Constants.METHOD_SEND_USER_MSG) != null) {
                return 1;
            }
            DBManager.getInstance(mContext).saveCmdMsg(msgUUid, Constants.METHOD_SEND_USER_MSG, str, chatObject, 15, 2);
            return 1;
        }
        return -1;
    }

    private int saveSingleMsg(ChatMsg chatMsg, int i2) {
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
        return i2;
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
            if (a.f64463e && chatMsg.getCategory() == 4) {
                creatMethodIntent = Utility.createMcastMethodIntent(mContext, 55);
            } else {
                creatMethodIntent = Utility.creatMethodIntent(mContext, 55);
            }
            creatMethodIntent.putExtra(Constants.EXTRA_SEND_MSG, chatMsg);
            creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            try {
                a.g(mContext).f(mContext, creatMethodIntent);
                return;
            } catch (Exception e2) {
                onSendMessageResult(6, chatMsg, -1L, addListener);
                LogUtils.e(TAG, "Exception ", e2);
                return;
            }
        }
        onSendMessageResult(1000, chatMsg, -1L, addListener);
    }

    private void sendMeidaPaChatMsg(int i2, int i3, long j, ChatMsg chatMsg, final ISendMessageListener iSendMessageListener) {
        mediaSendChatMsg(j, Utility.getBusinessType(i2, i3), j, PaManagerImpl.getInstance(mContext).getPaThirdId(j), chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.15
            @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
            public void onMediaSendChatMsgResult(int i4, ChatMsg chatMsg2) {
                if (i4 == 0) {
                    chatMsg2.setStatus(0);
                } else {
                    chatMsg2.setStatus(2);
                }
                chatMsg2.setRowId(System.currentTimeMillis());
                String str = ChatMsgManagerImpl.TAG;
                LogUtils.d(str, "b sendmsg = " + chatMsg2.toJsonString());
                iSendMessageListener.onSendMessageResult(i4, chatMsg2);
            }
        });
    }

    private void sendMessageBroadcast(Context context, ArrayList<ChatMsg> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        try {
            Intent intent = new Intent(IMConstants.MESSAGE_ACTION);
            intent.setPackage(context.getApplicationContext().getPackageName());
            intent.putParcelableArrayListExtra(IMConstants.MESSAGE, arrayList);
            mContext.sendBroadcast(intent);
        } catch (Exception e2) {
            LogUtils.e(TAG, " sendMessageBoradcast exception ");
            new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNoticeBroadcast(Context context, ChatMsg chatMsg) {
        Intent intent = new Intent(IMConstants.CUSTOMER_CHANGE);
        intent.setPackage(context.getApplicationContext().getPackageName());
        intent.putExtra(IMConstants.MESSAGE, chatMsg);
        context.sendBroadcast(intent);
    }

    private void setMaxNotifyMsgid(ChatMsg chatMsg) {
        if (chatMsg == null || chatMsg.getStatus() != 0) {
            return;
        }
        int category = chatMsg.getCategory();
        long contacter = chatMsg.getContacter();
        long msgId = chatMsg.getMsgId();
        String str = TAG;
        LogUtils.d(str, "setMaxNotifyMsgid msgid = " + msgId + " category = " + category + " contacter = " + contacter);
        if (category == 1) {
            DialogRecord dialogRecord = DialogRecordDBManager.getInstance(mContext).getDialogRecord(category, contacter);
            if (dialogRecord == null || dialogRecord.getMaxMsgid() >= msgId) {
                return;
            }
            dialogRecord.setMaxMsgid(msgId);
            DialogRecordDBManager.getInstance(mContext).add(dialogRecord);
            return;
        }
        Context context = mContext;
        if (msgId > Utility.readLongData(context, IMConstants.FETCHED_MAX_NOTIFY_MSGID + AccountManager.getAppid(mContext) + AccountManager.getUid(mContext), -1L)) {
            Context context2 = mContext;
            Utility.writeLongData(context2, IMConstants.FETCHED_MAX_NOTIFY_MSGID + AccountManager.getAppid(mContext) + AccountManager.getUid(mContext), msgId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUploadTask(int i2, String str, String str2, String str3, String str4, String str5, String str6, IUploadTransferListener iUploadTransferListener) {
        new AsyncUploadTask(mContext, i2, str, str2, str3, str4, str5, str6, iUploadTransferListener).execute(new Void[0]);
    }

    private void updateChatMsgStatus(ChatMsg chatMsg, int i2) {
        chatMsg.setStatus(i2 == 0 ? 0 : 2);
        ChatMessageDBManager.getInstance(mContext).updateMsgStatus(chatMsg);
    }

    private boolean useRequestSendMsg() {
        long appId = Utility.getAppId(mContext);
        return appId == Constants.APPID_HAOKAN || appId == Constants.APPID_HAOKAN_JISU || appId == Constants.APPID_QUANMIN || appId == Constants.APPID_TIEBA;
    }

    public void asyncUploadImgToBos(final String str, String str2, int i2, int i3, int i4, final IUploadTransferListener iUploadTransferListener) {
        if (AccountManager.isLogin(mContext)) {
            genBosObjectUrl(str, "image/jpeg", str2, i2, i3, i4, new IGenBosObjectUrlListener() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.10
                @Override // com.baidu.android.imsdk.chatmessage.IGenBosObjectUrlListener
                public void onGenBosObjectUrlListener(int i5, String str3, String str4, String str5, Map<String, String> map) {
                    String str6;
                    String str7;
                    if (i5 == 0) {
                        if (map != null) {
                            str6 = map.get(AsyncChatTask.PUT_URL);
                            str7 = map.get(AsyncChatTask.GET_URL);
                        } else {
                            str6 = "";
                            str7 = str6;
                        }
                        ChatMsgManagerImpl.this.startUploadTask(1, str6, str7, str, "image/jpeg", str4, str5, iUploadTransferListener);
                        return;
                    }
                    iUploadTransferListener.onFailed(i5, 1, str);
                }
            });
        } else {
            iUploadTransferListener.onFailed(1000, 1, str);
        }
    }

    public void audioTrans(String str, String str2, String str3, int i2, BIMValueCallBack bIMValueCallBack) {
        String str4 = TAG;
        LogUtils.d(str4, "audioTrans filePath=" + str);
        new IMAudioTransRequest(mContext, str, str2, str3, i2, ListenerManager.getInstance().addListener(bIMValueCallBack)).execute();
    }

    public void broadDeleteGroupMsg(Context context, ArrayList<ChatMsg> arrayList) {
        sendMessageBroadcast(context, arrayList);
    }

    public void broadcastMessage(ArrayList<ChatMsg> arrayList, boolean z) {
        int i2;
        synchronized (this.mReceiveListeners) {
            if (arrayList != null) {
                if (arrayList.size() != 0) {
                    String str = TAG;
                    LogUtils.d(str, " recive message before filter! " + arrayList.size());
                    ArrayList<ChatMsg> filtMsgs = z ? filtMsgs(arrayList) : arrayList;
                    if (filtMsgs != null && filtMsgs.size() != 0) {
                        String str2 = TAG;
                        LogUtils.d(str2, "you xiaoxi" + arrayList.size());
                        Iterator<IMessageReceiveListener> it = this.mReceiveListeners.iterator();
                        while (true) {
                            i2 = 0;
                            if (!it.hasNext()) {
                                break;
                            }
                            IMessageReceiveListener next = it.next();
                            if (next != null) {
                                next.onReceiveMessage(0, 0, new ArrayList<>(filtMsgs));
                            }
                        }
                        int size = filtMsgs.size();
                        int i3 = size / 20;
                        int i4 = size % 20;
                        while (i2 < i3) {
                            int i5 = 20 * i2;
                            i2++;
                            sendMessageBroadcast(mContext, new ArrayList<>(filtMsgs.subList(i5, 20 * i2)));
                        }
                        if (i4 > 0) {
                            sendMessageBroadcast(mContext, new ArrayList<>(filtMsgs.subList(size - i4, size)));
                        }
                    }
                }
            }
        }
    }

    public void clearKillOutListener() {
        this.mKickOutListener = null;
    }

    public void configMsgsFilter(ArrayList<ChatMsg> arrayList) {
        ArrayList<Long> cachedConfigMsgIds = getInstance(mContext).getCachedConfigMsgIds();
        int size = cachedConfigMsgIds.size();
        LogUtils.d(TAG, "configMsgsFilter oldCachedIdsSize=" + size);
        if (size <= 0 || arrayList.isEmpty()) {
            return;
        }
        long j = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 < arrayList.size()) {
            long msgId = arrayList.get(i3).getMsgId();
            if (cachedConfigMsgIds.contains(Long.valueOf(msgId))) {
                cachedConfigMsgIds.remove(Long.valueOf(msgId));
                arrayList.remove(i3);
                i3--;
            }
            if (msgId > j) {
                j = msgId;
            }
            i3++;
        }
        while (i2 < cachedConfigMsgIds.size()) {
            long longValue = cachedConfigMsgIds.get(i2).longValue();
            if (longValue <= j) {
                cachedConfigMsgIds.remove(Long.valueOf(longValue));
                i2--;
            }
            i2++;
        }
        if (size != cachedConfigMsgIds.size()) {
            configMsgIdsPersiser(cachedConfigMsgIds);
        }
    }

    public long deleteAllMsgs(int i2, long j, boolean z) {
        ChatSession chatRecord;
        int i3 = 0;
        LogUtils.d(TAG, String.format("delete all msg category=%d, contacter=%d", Integer.valueOf(i2), Long.valueOf(j)));
        if (i2 == 17 || i2 == 26) {
            return deleteAllSmartMsgs(i2);
        }
        if (i2 < 0 || j < 0) {
            return -1005L;
        }
        if (getPaid() == -2) {
            return -1017L;
        }
        if (AccountManager.isLogin(mContext)) {
            ChatObject chatObject = getChatObject(i2, j, getPaid());
            if (i2 == 1 && (chatRecord = ChatMessageDBManager.getInstance(mContext).getChatRecord(chatObject)) != null) {
                i3 = chatRecord.getChatType();
            }
            long deleteAllMsg = ChatMessageDBManager.getInstance(mContext).deleteAllMsg(chatObject);
            if (deleteAllMsg < 0) {
                return -1009L;
            }
            Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 57);
            creatMethodIntent.putExtra("category", i2);
            creatMethodIntent.putExtra("contacter", j);
            creatMethodIntent.putExtra(Constants.EXTRA_CLIENT_MAX_MSGID, deleteAllMsg);
            creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, z);
            if (i3 > 0) {
                creatMethodIntent.putExtra("chat_type", i3);
            }
            tryPutPaid(creatMethodIntent);
            try {
                a.g(mContext).f(mContext, creatMethodIntent);
            } catch (Exception e2) {
                LogUtils.e(TAG, "Exception ", e2);
            }
            return 0L;
        }
        return -1000L;
    }

    public long deleteAllSmartMsgs(int i2) {
        ArrayList<Long> queryPaIdByPaType = PaInfoDBManager.getInstance(mContext).queryPaIdByPaType(i2);
        long j = -1;
        if (queryPaIdByPaType != null && !queryPaIdByPaType.isEmpty()) {
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
                    a.g(mContext).f(mContext, creatMethodIntent);
                } catch (Exception e2) {
                    LogUtils.e(TAG, "Exception ", e2);
                }
                j = 0;
            }
        }
        return j;
    }

    public int deleteDraftMsg(int i2, long j) {
        return getPaid() == -2 ? DlnaManager.DLNA_ERROR_CREATE_SSDP_THREAD_FIAL : ChatMessageDBManager.getInstance(mContext).deleteDraftMsg(getChatObject(i2, j, getPaid()));
    }

    public int deleteMsgs(int i2, long j, long[] jArr, boolean z) {
        ChatSession chatRecord;
        if (i2 < 0 || j < 0 || jArr == null || jArr.length <= 0) {
            return -1005;
        }
        if (getPaid() == -2) {
            return DlnaManager.DLNA_ERROR_CREATE_SSDP_THREAD_FIAL;
        }
        if (AccountManager.isLogin(mContext)) {
            ChatObject chatObject = getChatObject(i2, j, getPaid());
            int i3 = 0;
            if (i2 == 1 && (chatRecord = ChatMessageDBManager.getInstance(mContext).getChatRecord(chatObject)) != null) {
                i3 = chatRecord.getChatType();
            }
            int deleteMsgBatch = ChatMessageDBManager.getInstance(mContext).deleteMsgBatch(getChatObject(i2, j, getPaid()), jArr);
            if (deleteMsgBatch >= 0) {
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 57);
                creatMethodIntent.putExtra("category", i2);
                creatMethodIntent.putExtra("contacter", j);
                creatMethodIntent.putExtra(Constants.EXTRA_DEL_MSG_IDS, jArr);
                creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, z);
                if (i3 > 0) {
                    creatMethodIntent.putExtra("chat_type", i3);
                }
                tryPutPaid(creatMethodIntent);
                try {
                    a.g(mContext).f(mContext, creatMethodIntent);
                } catch (Exception e2) {
                    LogUtils.e(TAG, "Exception ", e2);
                }
            }
            return deleteMsgBatch;
        }
        return -1000;
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

    public void deliverFetchedConfigMessage(final ArrayList<ChatMsg> arrayList) {
        TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.11
            @Override // java.lang.Runnable
            public void run() {
                LogUtils.d(ChatMsgManagerImpl.TAG, "deliverFetchedConfigMessage ..... ");
                ChatMsgManagerImpl.this.deliverConfigMessage(arrayList);
            }
        });
    }

    public void deliverReliableMcastMessage(String str, JSONArray jSONArray, List<Long> list) {
        onDeliverMcastResponse(str, jSONArray, this.mReceiveStudioListeners.get(str), list);
        deliverMcastMessage(jSONArray);
    }

    public void deliverStudioUsePaMessage(final ArrayList<ChatMsg> arrayList) {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<ChatMsg> it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(new JSONObject(it.next().getMsgContent()));
            }
        } catch (JSONException e2) {
            LogUtils.e(TAG, "deliverStudioUsePaMessage Exception ", e2);
        }
        String str = TAG;
        LogUtils.d(str, "deliverStudioUsePaMessage arr.size :" + jSONArray.length() + ", mStudioUsePaListeners :" + this.mStudioUsePaListeners.size());
        if (jSONArray.length() <= 0) {
            return;
        }
        synchronized (this.mStudioUsePaListeners) {
            for (ILiveMsgReceiveListener iLiveMsgReceiveListener : this.mStudioUsePaListeners) {
                if (iLiveMsgReceiveListener != null) {
                    onDeliverMcastResponse("", jSONArray, iLiveMsgReceiveListener, null);
                }
            }
            if (this.mStudioUsePaListeners.size() > 0) {
                TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.21
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).setStudioMsgRead(((ChatMsg) it2.next()).getMsgId());
                        }
                    }
                });
            }
        }
    }

    public void delverFetchedRetrieveMessage(final ArrayList<ChatMsg> arrayList) {
        TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.12
            @Override // java.lang.Runnable
            public void run() {
                LogUtils.d(ChatMsgManagerImpl.TAG, "retrieve-->delverFetchedRetrieveMessage ..... ");
                ChatMsgManagerImpl.this.deliverRetrieveMessage(arrayList);
            }
        });
    }

    public void fetchConfigMsg(Context context, long j, long j2) {
        String str = TAG;
        LogUtils.i(str, " limit: " + j2 + " cursor: " + j);
        Intent creatMethodIntent = Utility.creatMethodIntent(context, 193);
        creatMethodIntent.putExtra(Constants.EXTRA_CONFIG_CURSOR, j);
        creatMethodIntent.putExtra(Constants.EXTRA_CONFIG_LIMIT, j2);
        try {
            a.g(mContext).f(mContext, creatMethodIntent);
        } catch (Exception e2) {
            LogUtils.e(TAG, "Exception ", e2);
        }
    }

    public ArrayList<ChatMsg> fetchGroupNotifyMsgsSync(int i2, long j, int i3, boolean z, ChatMsg chatMsg) {
        if (1 == i2) {
            return GroupMessageDAOImpl.fetchGroupSystemMsg(mContext, String.valueOf(j), chatMsg, i3, z);
        }
        return ChatMessageDBManager.getInstance(mContext).fetchSpecifyMsgsSync(getChatObject(i2, j, getPaid()), 101, chatMsg == null ? 0L : chatMsg.getMsgId(), i3, chatMsg == null ? -1L : chatMsg.getRowId(), z);
    }

    @Deprecated
    public ArrayList<ChatMsg> fetchMessageSync(int i2, long j, long j2, int i3) {
        if (getPaid() == -2) {
            return null;
        }
        return ChatMessageDBManager.getInstance(mContext).fetchMsg(getChatObject(i2, j, getPaid()), j2, i3, -1L);
    }

    public ArrayList<ChatMsg> fetchMessageSyncExceptSystemMsg(int i2, long j, int i3, boolean z, ChatMsg chatMsg) {
        if (getPaid() == -2) {
            return null;
        }
        if (1 == i2) {
            return GroupMessageDAOImpl.fetchChatMsgExceptGroupSystem(mContext, String.valueOf(j), chatMsg, i3, z);
        }
        return ChatMessageDBManager.getInstance(mContext).fetchMsgsExceptGroupSystemMsgSync(getChatObject(i2, j, getPaid()), chatMsg == null ? 0L : chatMsg.getMsgId(), i3, chatMsg == null ? -1L : chatMsg.getRowId(), z);
    }

    public void fetchMsgByHostRequst(long j, int i2, long j2, long j3, long j4, int i3, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        String str = TAG;
        LogUtils.d(str, "fetchMsgByHostRequst ---> begin :" + j3 + ", end :" + j4);
        IMFetchMsgByHostRequest iMFetchMsgByHostRequest = new IMFetchMsgByHostRequest(mContext, ListenerManager.getInstance().addListener(iFetchMsgByIdListener), j, j2, i2, i3, j3, j4, z);
        HttpHelper.executor(mContext, iMFetchMsgByHostRequest, iMFetchMsgByHostRequest);
    }

    public void fetchMsgRequst(long j, long j2, int i2, long j3, long j4, long j5, int i3, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        String str = TAG;
        LogUtils.d(str, "fetchMsgRequst ---> begin :" + j4 + ", end :" + j5);
        IMFetchMsgRequest iMFetchMsgRequest = new IMFetchMsgRequest(mContext, ListenerManager.getInstance().addListener(iFetchMsgByIdListener), j, j2, j3, i2, i3, j4, j5, z);
        HttpHelper.executor(mContext, iMFetchMsgRequest, iMFetchMsgRequest);
    }

    public void fetchMsgidByMsgid(Context context, int i2, long j, long j2, long j3, int i3, int i4, int i5, IFetchMsgByIdListener iFetchMsgByIdListener, int i6) {
        Intent creatMethodIntent;
        String addListener = ListenerManager.getInstance().addListener(iFetchMsgByIdListener);
        String str = TAG;
        LogUtils.i(str, " category: " + i2 + " contacter: " + j + " beginMsgid: " + j2 + " endMsgid: " + j3 + " count: " + i3 + " triggerReason: " + i4 + " jumpToRecentMsg: " + i5 + " key: " + addListener);
        if (j2 >= 0 && j3 >= 0) {
            if (AccountManager.isLogin(context)) {
                if (a.f64463e && i2 == 4) {
                    creatMethodIntent = Utility.createMcastMethodIntent(context, 93);
                } else {
                    creatMethodIntent = Utility.creatMethodIntent(context, 93);
                }
                creatMethodIntent.putExtra("category", i2);
                creatMethodIntent.putExtra("contacter", j);
                creatMethodIntent.putExtra(Constants.EXTRA_BEGIN_MSGID, j2);
                creatMethodIntent.putExtra(Constants.EXTRA_END_MSGID, j3);
                creatMethodIntent.putExtra("count", i3);
                creatMethodIntent.putExtra(Constants.EXTRA_TRIGGER_REASON, i4);
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                creatMethodIntent.putExtra(Constants.EXTRA_JUMP_MSG, i5);
                creatMethodIntent.putExtra(Constants.EXTRA_RETRY_TIME, i6);
                try {
                    a.g(mContext).f(mContext, creatMethodIntent);
                    return;
                } catch (Exception e2) {
                    onFetchMsgByIdResult(context, 6, "start service exception", i2, j, j2, j3, i3, -1, 0L, null, null, addListener);
                    LogUtils.e(TAG, "Exception ", e2);
                    return;
                }
            }
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            onFetchMsgByIdResult(context, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, i2, j, j2, j3, i3, -1, 0L, null, null, addListener);
            return;
        }
        onFetchMsgByIdResult(context, 1005, Constants.ERROR_MSG_PARAMETER_ERROR, i2, j, j2, j3, i3, -1, 0L, null, null, addListener);
    }

    public void fetchPaChatMsgs(int i2, int i3, final long j, final long j2, long j3, final int i4, final IFetchMessageListener iFetchMessageListener) {
        if (AccountManager.isLogin(mContext)) {
            if (AccountManager.getMediaRole(mContext)) {
                mediaFetchChatMsgs(mContext, j, Utility.getBusinessType(i2, i3), j, PaManagerImpl.getInstance(mContext).getPaThirdId(j), 0L, j3 - 1, i4, new IMediaFetchChatMsgsListener() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.16
                    @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                    public void onMediaFetchChatMsgsResult(int i5, String str, boolean z, List<ChatMsg> list) {
                        if (i5 == 0 && list != null && list.size() > 0) {
                            Iterator<ChatMsg> it = list.iterator();
                            while (it.hasNext()) {
                                String str2 = ChatMsgManagerImpl.TAG;
                                LogUtils.d(str2, "b fetchPaChatMsgs msg = " + it.next().toJsonString());
                            }
                        }
                        iFetchMessageListener.onFetchMessageResult(i5, new ArrayList<>(list));
                    }
                });
                return;
            } else {
                TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.17
                    @Override // java.lang.Runnable
                    public void run() {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(Long.valueOf(j));
                        ArrayList<ChatMsg> fetchPaMsgByPaids = ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).fetchPaMsgByPaids(arrayList, j2, i4);
                        if (fetchPaMsgByPaids != null && fetchPaMsgByPaids.size() > 0) {
                            Iterator<ChatMsg> it = fetchPaMsgByPaids.iterator();
                            while (it.hasNext()) {
                                String str = ChatMsgManagerImpl.TAG;
                                LogUtils.d(str, "c fetchPaChatMsgs msg = " + it.next().toJsonString());
                            }
                        }
                        iFetchMessageListener.onFetchMessageResult(0, fetchPaMsgByPaids);
                    }
                });
                return;
            }
        }
        LogUtils.d(TAG, "not login error");
        iFetchMessageListener.onFetchMessageResult(1000, null);
    }

    public void genBosObjectUrl(String str, String str2, String str3, int i2, int i3, int i4, IGenBosObjectUrlListener iGenBosObjectUrlListener) {
        String str4 = TAG;
        LogUtils.d(str4, "filePath=" + str);
        IMGenBosObjectUrlRequest iMGenBosObjectUrlRequest = new IMGenBosObjectUrlRequest(mContext, str, str2, str3, i2, i3, i4, ListenerManager.getInstance().addListener(iGenBosObjectUrlListener));
        HttpHelper.executor(mContext, iMGenBosObjectUrlRequest, iMGenBosObjectUrlRequest);
    }

    public ArrayList<Long> getCachedConfigMsgIds() {
        String configMsgIds = Utility.getConfigMsgIds(mContext);
        LogUtils.d(TAG, "getCachedConfigMsgIds str = " + configMsgIds);
        ArrayList<Long> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(configMsgIds)) {
            try {
                String[] split = configMsgIds.split(",");
                if (split != null && split.length > 0) {
                    for (String str : split) {
                        arrayList.add(Long.valueOf(Long.parseLong(str)));
                    }
                }
            } catch (Exception e2) {
                LogUtils.e(TAG, e2.getMessage());
                new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
        LogUtils.d(TAG, "getCachedConfigMsgIds back arr size = " + arrayList.size());
        return arrayList;
    }

    public ChatObject getChatObject(int i2, long j, long j2) {
        return new ChatObject(mContext, i2, j, j2, -1);
    }

    public ChatMsg getDraftMsg(int i2, long j) {
        return ChatMessageDBManager.getInstance(mContext).getDraftMsg(i2, j);
    }

    public long getMaxReliableMsgId(long j) {
        return ChatMessageDBManager.getInstance(mContext).getMaxReliableMsgId(j);
    }

    public ChatMsg getMsgByMsgId(long j) {
        return ChatMessageDBManager.getInstance(mContext).getMsgByMsgId(j);
    }

    public int getNewMsgCount() {
        return getPaid() == -2 ? DlnaManager.DLNA_ERROR_CREATE_SSDP_THREAD_FIAL : ChatMessageDBManager.getInstance(mContext).getNewMsgCount(getPaid());
    }

    public int getNewMsgCountByPaid(long j) {
        return ChatMessageDBManager.getInstance(mContext).getUnReadMsgCount(getChatObject(0, j, j));
    }

    public long getNewMsgNum(int i2, long j) {
        if (AccountManager.isLogin(mContext)) {
            if (getPaid() == -2) {
                return -1017L;
            }
            return ChatMessageDBManager.getInstance(mContext).getNewMsgNum(getChatObject(i2, j, getPaid()));
        }
        return -1L;
    }

    public void getNotificationMsgDataList(final SparseArray<List<Integer>> sparseArray, final long j, int i2, final IFetchNotificationDataListener iFetchNotificationDataListener) {
        if (AccountManager.isLogin(mContext) && iFetchNotificationDataListener != null) {
            final int i3 = Math.abs(i2) > 20 ? 20 : i2;
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.8
                @Override // java.lang.Runnable
                public void run() {
                    ChatMsgManagerImpl.this.callBackNotificationMsgData(ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).getNotificationMsgDataList(sparseArray, j, i3), i3, iFetchNotificationDataListener);
                }
            });
        } else if (iFetchNotificationDataListener != null) {
            iFetchNotificationDataListener.onFetchResult(null, false);
        }
    }

    public List<ChatMsg> getPaMsgByChatType(int i2, int i3) {
        if (AccountManager.isLogin(mContext)) {
            return ChatMessageDBManager.getInstance(mContext).fetchPaMsgByChatType(i2, i3);
        }
        return null;
    }

    public void getPaMsgByChatTypeAndPaidList(final List<Integer> list, final List<Long> list2, final long j, int i2, final IFetchNotificationDataListener iFetchNotificationDataListener) {
        if (AccountManager.isLogin(mContext) && iFetchNotificationDataListener != null) {
            final int i3 = Math.abs(i2) > 20 ? 20 : i2;
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    ChatMsgManagerImpl.this.callBackNotificationMsgData(ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).getPaMsgByChatTypeAndPaidList(list, list2, j, i3), i3, iFetchNotificationDataListener);
                }
            });
        } else if (iFetchNotificationDataListener != null) {
            iFetchNotificationDataListener.onFetchResult(null, false);
        }
    }

    public void getPaNewMsgCount(int i2, int i3, final long j, final IGetNewMsgCountListener iGetNewMsgCountListener) {
        if (AccountManager.isLogin(mContext)) {
            if (AccountManager.getMediaRole(mContext)) {
                mediaGetChatSessions(i2, i3, j, iGetNewMsgCountListener);
                return;
            }
            LogUtils.d(TAG, "c getPaNewMsgCount");
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.19
                @Override // java.lang.Runnable
                public void run() {
                    iGetNewMsgCountListener.onGetNewMsgCount(ChatMsgManagerImpl.this.getNewMsgCountByPaid(j));
                }
            });
            return;
        }
        LogUtils.d(TAG, "login error");
        iGetNewMsgCountListener.onGetNewMsgCount(0);
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

    public void handleMediaNotifyMessage(final JSONObject jSONObject) {
        try {
            if (!AccountManager.getMediaRole(mContext) || jSONObject == null || this.mMediaMsgChangedListeners == null || this.mMediaMsgChangedListeners.isEmpty()) {
                return;
            }
            String str = TAG;
            LogUtils.i(str, "BC> handleMediaNotifyMessage msgobj=" + jSONObject.toString());
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.14
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
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int markMessageClicked(ChatMsg chatMsg) {
        chatMsg.setIsClicked(true);
        return ChatMessageDBManager.getInstance(mContext).markMsgClicked(chatMsg);
    }

    public void mediaDeleteChatMsg(long j, long j2, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        String str = TAG;
        LogUtils.d(str, "BC> contactor=" + j + ", listener=" + iMediaDeleteChatMsgListener + ", needDeleteMsgIds=" + list + ", maxDeleteMsgId=" + j2);
        if (!AccountManager.getMediaRole(mContext)) {
            iMediaDeleteChatMsgListener.onMediaDeleteChatMsgResult(2000, null);
            return;
        }
        IMMediaDeleteMsgHttpRequest iMMediaDeleteMsgHttpRequest = new IMMediaDeleteMsgHttpRequest(mContext, j, j2, list, ListenerManager.getInstance().addListener(iMediaDeleteChatMsgListener));
        HttpHelper.executor(mContext, iMMediaDeleteMsgHttpRequest, iMMediaDeleteMsgHttpRequest);
    }

    public void mediaFetchChatMsgs(Context context, long j, long j2, long j3, int i2, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        String str = TAG;
        LogUtils.d(str, "BC> contactor=" + j + ", beginMsgTime=" + j2 + ", endMsgTime=" + j3 + ", count=" + i2 + ", listener=" + iMediaFetchChatMsgsListener);
        if (!AccountManager.getMediaRole(context)) {
            iMediaFetchChatMsgsListener.onMediaFetchChatMsgsResult(2000, null, false, null);
            return;
        }
        IMMediaFetchMsgHttpRequest iMMediaFetchMsgHttpRequest = new IMMediaFetchMsgHttpRequest(mContext, j, j2, j3, i2, ListenerManager.getInstance().addListener(iMediaFetchChatMsgsListener));
        HttpHelper.executor(context, iMMediaFetchMsgHttpRequest, iMMediaFetchMsgHttpRequest);
    }

    public void mediaRegisterChatMsgChangedListener(IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        if (iMediaChatMsgChangedListener != null) {
            this.mMediaMsgChangedListeners.put(Integer.valueOf(iMediaChatMsgChangedListener.hashCode()), iMediaChatMsgChangedListener);
        }
    }

    public void mediaSendChatMsg(long j, int i2, long j2, String str, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        String str2 = TAG;
        LogUtils.d(str2, "BC> contactor=" + j + ", contactorType" + i2 + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", listener=" + iMediaSendChatMsgListener + ", sendMsg=" + chatMsg);
        if (!AccountManager.getMediaRole(mContext)) {
            iMediaSendChatMsgListener.onMediaSendChatMsgResult(2000, chatMsg);
            return;
        }
        IMMediaSendMsgHttpRequest iMMediaSendMsgHttpRequest = new IMMediaSendMsgHttpRequest(mContext, j, i2, j2, str, chatMsg, ListenerManager.getInstance().addListener(iMediaSendChatMsgListener));
        HttpHelper.executor(mContext, iMMediaSendMsgHttpRequest, iMMediaSendMsgHttpRequest);
    }

    public void mediaUnRegisterChatMsgChangedListener(IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        if (iMediaChatMsgChangedListener != null) {
            this.mMediaMsgChangedListeners.remove(Integer.valueOf(iMediaChatMsgChangedListener.hashCode()));
        }
    }

    public void onAudioTransCallBack(String str, int i2, String str2, String str3) {
        String str4 = TAG;
        LogUtils.d(str4, "onAudioTransCallBack----errorCode: " + i2 + " msg: " + str2);
        BIMValueCallBack bIMValueCallBack = (BIMValueCallBack) ListenerManager.getInstance().removeListener(str);
        if (bIMValueCallBack != null) {
            bIMValueCallBack.onResult(i2, str2, str3);
        } else {
            LogUtils.d(TAG, "onAudioTransCallBack listener is null");
        }
    }

    public void onFetchMsgByIdResult(Context context, int i2, String str, int i3, long j, long j2, long j3, int i4, int i5, long j4, String str2, ArrayList<ChatMsg> arrayList, String str3) {
        if (arrayList != null) {
            String str4 = TAG;
            LogUtils.d(str4, "onFetchMsgByIdResult----errorCode: " + i2 + " msg:" + str + ", contacter:" + j + ",fetchedMsgs size " + arrayList.size());
        } else {
            String str5 = TAG;
            LogUtils.d(str5, "onFetchMsgByIdResult----errorCode: " + i2 + " msg:" + str + ", contacter:" + j + ",fetchedMsgs is null.");
        }
        if (arrayList != null && arrayList.size() == 1) {
            try {
                Long.parseLong(str3.substring(1, 14));
                System.currentTimeMillis();
            } catch (Exception e2) {
                LogUtils.e(TAG, "get message receive time error", e2);
                new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
        IMListener removeListener = ListenerManager.getInstance().removeListener(str3);
        if (removeListener != null && (removeListener instanceof IFetchMsgByIdListener)) {
            ((IFetchMsgByIdListener) removeListener).onFetchMsgByIdResult(i2, str, str2, i3, j, j2, j3, i4, i5, j4, arrayList);
        } else {
            LogUtils.i(TAG, "onFetchMsgByIdResult listener is null or error!!");
        }
    }

    public void onGenBosObjectUrl(String str, int i2, String str2, String str3, String str4, Map<String, String> map) {
        String str5 = TAG;
        LogUtils.d(str5, "onGenBosObjectUrl----errorCode: " + i2 + " msg: " + str2);
        IGenBosObjectUrlListener iGenBosObjectUrlListener = (IGenBosObjectUrlListener) ListenerManager.getInstance().removeListener(str);
        if (iGenBosObjectUrlListener != null) {
            iGenBosObjectUrlListener.onGenBosObjectUrlListener(i2, str2, str3, str4, map);
        } else {
            LogUtils.d(TAG, "onGenBosObjectUrl is null");
        }
    }

    public void onMediaDeleteChatMsgResult(String str, int i2, String str2) {
        IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener = (IMediaDeleteChatMsgListener) ListenerManager.getInstance().removeListener(str);
        if (iMediaDeleteChatMsgListener != null) {
            String str3 = TAG;
            LogUtils.d(str3, "BC> responseCode=" + i2 + ", msg=" + str2);
            iMediaDeleteChatMsgListener.onMediaDeleteChatMsgResult(i2, str2);
        }
    }

    public void onMediaFetchChatMsgsResult(String str, int i2, String str2, boolean z, List<ChatMsg> list) {
        IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener = (IMediaFetchChatMsgsListener) ListenerManager.getInstance().removeListener(str);
        if (iMediaFetchChatMsgsListener != null) {
            String str3 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("BC> responseCode=");
            sb.append(i2);
            sb.append(", strMsg=");
            sb.append(str2);
            sb.append(", hasMore=");
            sb.append(z);
            sb.append(", msgs=");
            sb.append(list != null ? list.toString() : "");
            LogUtils.d(str3, sb.toString());
            iMediaFetchChatMsgsListener.onMediaFetchChatMsgsResult(i2, str2, z, list);
        }
    }

    public void onMediaSendChatMsgResult(String str, int i2, ChatMsg chatMsg) {
        IMediaSendChatMsgListener iMediaSendChatMsgListener = (IMediaSendChatMsgListener) ListenerManager.getInstance().removeListener(str);
        if (iMediaSendChatMsgListener != null) {
            String str2 = TAG;
            LogUtils.d(str2, "BC> responseCode=" + i2 + ", msg=" + chatMsg);
            iMediaSendChatMsgListener.onMediaSendChatMsgResult(i2, chatMsg);
        }
    }

    public void onSendMessageResult(int i2, ChatMsg chatMsg, long j, String str) {
        try {
            if (chatMsg == null) {
                LogUtils.d(TAG, "onSendMessageResult----chatMsg is null");
                IMListener removeListener = ListenerManager.getInstance().removeListener(str);
                if (removeListener != null && (removeListener instanceof ISendMessageListener)) {
                    ((ISendMessageListener) removeListener).onSendMessageResult(i2, null);
                } else {
                    LogUtils.d(TAG, "ISendMessageListener is null");
                }
            } else if (chatMsg.getCategory() == 4) {
                onSendStudioMsgResult(i2, chatMsg, j, str);
            } else {
                String str2 = TAG;
                LogUtils.d(str2, "onSendMessageResult----errorCode: " + i2);
                try {
                    Long.parseLong(str.substring(1, 14));
                    System.currentTimeMillis();
                } catch (Exception e2) {
                    LogUtils.e(TAG, "get message receive time error", e2);
                    new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
                }
                if (j != -1) {
                    chatMsg.setMsgTime(j);
                }
                DBManager.getInstance(mContext).deleteCmdMsg(getMsgUUid(chatMsg));
                updateChatMsgStatus(chatMsg, i2);
                setMaxNotifyMsgid(chatMsg);
                IMListener removeListener2 = ListenerManager.getInstance().removeListener(str);
                if (removeListener2 != null && (removeListener2 instanceof ISendMessageListener)) {
                    ((ISendMessageListener) removeListener2).onSendMessageResult(i2, chatMsg);
                } else {
                    LogUtils.d(TAG, "ISendMessageListener is null");
                }
                if (chatMsg != null) {
                    ListenerManager.getInstance().removeListener(chatMsg.mListenerKey);
                }
            }
        } catch (Exception e3) {
            String str3 = TAG;
            LogUtils.e(str3, "onSendMessageResult exception " + e3.getMessage());
        }
    }

    public void onUnRegisterNotifyResult(String str, int i2, String str2) {
        String str3 = TAG;
        LogUtils.d(str3, "onUnRegisterNotifyResult----errorCode: " + i2 + " msg: " + str2);
        if (i2 == 0) {
            BindStateManager.setunBindPush(mContext);
        }
        IOnRegisterNotifyListener iOnRegisterNotifyListener = (IOnRegisterNotifyListener) ListenerManager.getInstance().removeListener(str);
        if (iOnRegisterNotifyListener != null) {
            iOnRegisterNotifyListener.onUnRegisterNotifyResult(i2, str2);
        }
    }

    public void persisConfigMsgIds(ArrayList<ChatMsg> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
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

    public void registerInternalMessageReceiveListener(IMessageReceiveListener iMessageReceiveListener) {
        String str = TAG;
        LogUtils.e(str, "retrieve-->registerInternalMessageReceiveListener : " + iMessageReceiveListener);
        if (iMessageReceiveListener == null || this.mInternalReceiveListeners.contains(iMessageReceiveListener)) {
            return;
        }
        this.mInternalReceiveListeners.add(iMessageReceiveListener);
    }

    public void registerKillOutListener(IKickOutListener iKickOutListener) {
        this.mKickOutListener = iKickOutListener;
    }

    public void registerLiveMsgReceiveListener(ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        String str = TAG;
        LogUtils.d(str, "registerLiveMsgReceiveListener : " + iLiveMsgReceiveListener);
        if (iLiveMsgReceiveListener != null) {
            this.mReceiveStudioListener = iLiveMsgReceiveListener;
        }
    }

    public void registerMessageReceiveListener(IMessageReceiveListener iMessageReceiveListener) {
        String str = TAG;
        LogUtils.e(str, "registerMessageReceiveListener : " + iMessageReceiveListener);
        if (iMessageReceiveListener == null || this.mReceiveListeners.contains(iMessageReceiveListener)) {
            return;
        }
        this.mReceiveListeners.add(iMessageReceiveListener);
    }

    public void registerMessageSyncListener(Context context, IMessageSyncListener iMessageSyncListener) {
        if (iMessageSyncListener == null || this.mMessageSyncListener.contains(iMessageSyncListener)) {
            return;
        }
        this.mMessageSyncListener.add(iMessageSyncListener);
    }

    public boolean registerNotify(String str, String str2, String str3, IOnRegisterNotifyListener iOnRegisterNotifyListener) {
        return BindStateManager.startBindPush(mContext, str, str2, str3, iOnRegisterNotifyListener);
    }

    public void registerStudioUsePaReceivePaMsg(ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        synchronized (this.mStudioUsePaListeners) {
            if (iLiveMsgReceiveListener != null) {
                if (!this.mStudioUsePaListeners.contains(iLiveMsgReceiveListener)) {
                    this.mStudioUsePaListeners.add(iLiveMsgReceiveListener);
                }
            }
        }
        TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.18
            @Override // java.lang.Runnable
            public void run() {
                LogUtils.d(ChatMsgManagerImpl.TAG, "registerStudioUsePaReceivePaMsg and deliverStudioUsePaMessage");
                ChatMsgManagerImpl.this.deliverStudioUsePaMessage(ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).getStudioUsePaUnReadMsg());
            }
        });
    }

    public void resendMsg(String str, String str2, int i2, ISendMessageListener iSendMessageListener) {
        String str3 = TAG;
        LogUtils.d(str3, "resendMsg " + str + " " + str2 + " ---->");
        if (i2 == 0) {
            ArrayList<ChatMsg> fetchMsg = ChatMessageDBManager.getInstance(mContext).fetchMsg(str2, str);
            if (fetchMsg != null && fetchMsg.size() != 0) {
                ChatMsg chatMsg = fetchMsg.get(0);
                String str4 = TAG;
                LogUtils.d(str4, "resendMsg " + chatMsg.getRowId() + GlideException.IndentedAppendable.INDENT + str);
                chatMsg.setStatus(1);
                chatMsg.setReSend();
                sendMessage(chatMsg, iSendMessageListener);
                return;
            }
            LogUtils.d(TAG, "resendMsg get msg by rowid is null");
            if (iSendMessageListener != null) {
                iSendMessageListener.onSendMessageResult(1005, null);
            }
        }
    }

    public int saveAsDraftMsg(ChatMsg chatMsg) {
        if (chatMsg == null) {
            return -1;
        }
        if (getPaid() == -2) {
            return DlnaManager.DLNA_ERROR_CREATE_SSDP_THREAD_FIAL;
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

    public int saveMessage(ChatMsg chatMsg) {
        if (chatMsg != null && AccountManager.isLogin(mContext)) {
            if (1 == chatMsg.getCategory()) {
                return saveGroupMessage(chatMsg);
            }
            return saveSingleMsg(chatMsg, -1);
        }
        return -1;
    }

    public void sendMessage(ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        this.mUseRequestSendMsg = false;
        if (chatMsg == null) {
            if (iSendMessageListener != null) {
                iSendMessageListener.onSendMessageResult(1005, null);
            }
        } else if (noSaveDB(chatMsg.getCategory(), chatMsg.getMsgType())) {
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
                if (chatMsg.getChatType() == 57) {
                    chatMsg.setMinSdkVersion(7300000L);
                } else {
                    chatMsg.setMinSdkVersion(2300000L);
                }
            }
            if (AccountManager.isLogin(mContext)) {
                if (saveMessage(chatMsg) == 1) {
                    Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 55);
                    creatMethodIntent.putExtra(Constants.EXTRA_SEND_MSG, chatMsg);
                    creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                    try {
                        a.g(mContext).f(mContext, creatMethodIntent);
                        return;
                    } catch (Exception e2) {
                        onSendMessageResult(6, chatMsg, -1L, addListener);
                        LogUtils.e(TAG, "Exception ", e2);
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

    public void sendMessageRequest(ChatMsg chatMsg, String str) {
        String str2 = TAG;
        LogUtils.d(str2, "sendMessageRequest ---> msg :" + chatMsg.toString());
        this.mUseRequestSendMsg = true;
        IMSendMsgRequest iMSendMsgRequest = new IMSendMsgRequest(mContext, chatMsg, str);
        HttpHelper.executor(mContext, iMSendMsgRequest, iMSendMsgRequest);
    }

    public void sendPaChatMsg(int i2, int i3, long j, int i4, String str, ISendMessageListener iSendMessageListener) {
        if (AccountManager.isLogin(mContext)) {
            ChatMsg buildChatMsg = buildChatMsg(i2, 0, j, i4, str);
            if (buildChatMsg == null) {
                iSendMessageListener.onSendMessageResult(1005, null);
                return;
            }
            String str2 = TAG;
            LogUtils.d(str2, "buildChatMsg = " + buildChatMsg.toString());
            if (AccountManager.getMediaRole(mContext)) {
                sendMeidaPaChatMsg(i2, i3, j, buildChatMsg, iSendMessageListener);
                return;
            }
            if (!noSaveDB(buildChatMsg.getCategory(), buildChatMsg.getMsgType())) {
                saveMessage(buildChatMsg);
            }
            String str3 = TAG;
            LogUtils.d(str3, "c sendmsg = " + buildChatMsg.toJsonString());
            sendMessage(buildChatMsg, iSendMessageListener);
            return;
        }
        LogUtils.d(TAG, "not login error");
        iSendMessageListener.onSendMessageResult(1000, null);
    }

    public boolean setAllMsgRead(int i2, long j, boolean z) {
        if (i2 != 17 && i2 != 26) {
            return setBeforeMsgRead(i2, j, ChatMessageDBManager.getInstance(mContext).getMaxMsgid(getChatObject(i2, j, getPaid())), z);
        }
        boolean z2 = false;
        ArrayList<Long> queryPaIdByPaType = PaInfoDBManager.getInstance(mContext).queryPaIdByPaType(i2);
        if (queryPaIdByPaType != null && !queryPaIdByPaType.isEmpty()) {
            Iterator<Long> it = queryPaIdByPaType.iterator();
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                z2 = setBeforeMsgRead(0, longValue, ChatMessageDBManager.getInstance(mContext).getMaxMsgid(getChatObject(0, longValue, longValue)), z);
            }
        }
        return z2;
    }

    public boolean setBeforeMsgRead(int i2, long j, long j2, boolean z) {
        ChatObject chatObject;
        if (getPaid() != -2 && AccountManager.isLogin(mContext)) {
            if ((Constants.PAFLAG & j) != 0) {
                chatObject = getChatObject(i2, j, j);
            } else {
                chatObject = getChatObject(i2, j, getPaid());
            }
            ChatSession chatRecord = ChatMessageDBManager.getInstance(mContext).getChatRecord(chatObject);
            if (chatRecord != null) {
                int i3 = (chatRecord.getNewMsgSum() > 0L ? 1 : (chatRecord.getNewMsgSum() == 0L ? 0 : -1));
                if (i3 < 0) {
                    return false;
                }
                if (i3 == 0) {
                    return true;
                }
            }
            if (ChatMessageDBManager.getInstance(mContext).setAllMsgReadWithMsgid(chatObject, j2)) {
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 67);
                creatMethodIntent.putExtra("category", i2);
                creatMethodIntent.putExtra("contacter", j);
                creatMethodIntent.putExtra(Constants.EXTRA_CLIENT_MAX_MSGID, j2);
                creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, z);
                tryPutPaid(creatMethodIntent);
                try {
                    a.g(mContext).f(mContext, creatMethodIntent);
                } catch (Exception e2) {
                    LogUtils.e(TAG, "Exception ", e2);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void setInterActiveMsgStatus(long j, long j2, int i2, int i3) {
        ChatMsg chatMsgByMsgId = ChatMessageDBManager.getInstance(mContext).getChatMsgByMsgId(j);
        if (chatMsgByMsgId instanceof InterActiveMsg) {
            String jsonContent = ((InterActiveMsg) chatMsgByMsgId).getJsonContent();
            if (i2 == 0 || i2 == 1) {
                chatMsgByMsgId.setMsgContent(replaceInterActiveBottomBarStatus(jsonContent, i2, i3));
                ChatMessageDBManager.getInstance(mContext).updateMsgStatus(chatMsgByMsgId);
            } else if (i2 == 2) {
                ChatUser chatUserByBuid = ChatUserDBManager.getInstance(mContext).getChatUserByBuid(j2);
                if (chatUserByBuid != null) {
                    chatUserByBuid.setSubscribe(i3);
                    ChatUserDBManager.getInstance(mContext).updateUserByBduid(chatUserByBuid);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(j2));
                ChatUserManagerImpl.getInstance(mContext).updateUserIdentity(arrayList, new IGetUserIdentityListener() { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.13
                    @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
                    public void onGetUserIdentityResult(int i4, List<ChatUser> list) {
                        if (i4 == 0) {
                            ChatUserDBManager.getInstance(ChatMsgManagerImpl.mContext).updateUserIdentity(list);
                        }
                    }
                });
            }
        }
    }

    public boolean setMsgRead(int i2, long j, long j2, boolean z) {
        if (getPaid() != -2 && AccountManager.isLogin(mContext) && ChatMessageDBManager.getInstance(mContext).setMsgRead(getChatObject(i2, j, getPaid()), j2) >= 0) {
            Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 67);
            creatMethodIntent.putExtra("category", i2);
            creatMethodIntent.putExtra("contacter", j);
            creatMethodIntent.putExtra("msgid", j2);
            creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, z);
            tryPutPaid(creatMethodIntent);
            try {
                a.g(mContext).f(mContext, creatMethodIntent);
                return true;
            } catch (Exception e2) {
                LogUtils.e(TAG, "Exception ", e2);
                return true;
            }
        }
        return false;
    }

    public boolean setMsgReadByChatTpyes(List<Integer> list, long j) {
        long j2;
        if (AccountManager.isLogin(mContext)) {
            LogUtils.e(TAG, "setMsgReadByChatTpyes start");
            if (list == null || list.size() == 0) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Integer num : list) {
                int intValue = num.intValue();
                if (intValue != 3 && intValue != 4 && intValue != 57) {
                    arrayList2.add(Integer.valueOf(intValue));
                } else {
                    arrayList.add(Integer.valueOf(intValue));
                }
            }
            ArrayList<ChatSession> chatRecords = ChatSessionManagerImpl.getInstance(mContext).getChatRecords(0L, 0L, arrayList);
            if (chatRecords != null) {
                Iterator<ChatSession> it = chatRecords.iterator();
                while (it.hasNext()) {
                    ChatSession next = it.next();
                    if (next.getNewMsgSum() <= 0) {
                        if (next.getChatType() == 57) {
                            next.setNewFansAtMsgSum(0);
                        }
                    } else {
                        setBeforeMsgRead(1, next.getContacter(), j <= 0 ? ChatMessageDBManager.getInstance(mContext).getMaxMsgid(getChatObject(1, next.getContacter(), getPaid())) : j, false);
                    }
                }
            }
            if (j <= 0) {
                ArrayList<ChatMsg> maxMsgidByChatTypes = ChatMessageDBManager.getInstance(mContext).getMaxMsgidByChatTypes(arrayList2, 0L, 1);
                if (maxMsgidByChatTypes == null || maxMsgidByChatTypes.size() <= 0) {
                    return false;
                }
                j2 = maxMsgidByChatTypes.get(0).getMsgId();
            } else {
                j2 = j;
            }
            String str = TAG;
            LogUtils.e(str, "setMsgReadByChatTpyes msgid = " + j2);
            List<Long> msgReadByChatTypes = ChatMessageDBManager.getInstance(mContext).setMsgReadByChatTypes(arrayList2, j2);
            if (msgReadByChatTypes == null) {
                return false;
            }
            String str2 = TAG;
            LogUtils.e(str2, "setMsgReadByChatTpyes contacterIds size = " + msgReadByChatTypes.size());
            for (Long l : msgReadByChatTypes) {
                long longValue = l.longValue();
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 67);
                creatMethodIntent.putExtra("category", 0);
                creatMethodIntent.putExtra("contacter", longValue);
                creatMethodIntent.putExtra(Constants.EXTRA_CLIENT_MAX_MSGID, j2);
                creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, false);
                tryPutPaid(creatMethodIntent);
                try {
                    a.g(mContext).f(mContext, creatMethodIntent);
                } catch (Exception e2) {
                    LogUtils.e(TAG, "Exception ", e2);
                }
            }
            return true;
        }
        return false;
    }

    public boolean setMsgReadByChatTypeAndSubType(SparseArray<List<Integer>> sparseArray, long j, ISetMessageReadListener iSetMessageReadListener) {
        if (AccountManager.isLogin(mContext)) {
            LogUtils.e(TAG, "setMsgReadByChatTypeAndSubType start");
            if (j <= 0) {
                ArrayList<ChatMsg> notificationMsgDataList = ChatMessageDBManager.getInstance(mContext).getNotificationMsgDataList(sparseArray, 0L, 1);
                if (notificationMsgDataList == null || notificationMsgDataList.size() <= 0) {
                    return false;
                }
                j = notificationMsgDataList.get(0).getMsgId();
            }
            String str = TAG;
            LogUtils.d(str, "setMsgReadByChatTypeAndSubType msgid = " + j);
            List<Long> paMsgReadByChatTypeAndSubType = ChatMessageDBManager.getInstance(mContext).setPaMsgReadByChatTypeAndSubType(sparseArray, j);
            iSetMessageReadListener.onFinish();
            if (paMsgReadByChatTypeAndSubType == null || paMsgReadByChatTypeAndSubType.size() <= 0) {
                return false;
            }
            String str2 = TAG;
            LogUtils.e(str2, "setMsgReadByChatTpyes paids size = " + paMsgReadByChatTypeAndSubType.size());
            for (Long l : paMsgReadByChatTypeAndSubType) {
                long longValue = l.longValue();
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 67);
                creatMethodIntent.putExtra("category", 0);
                creatMethodIntent.putExtra("contacter", longValue);
                creatMethodIntent.putExtra(Constants.EXTRA_CLIENT_MAX_MSGID, j);
                creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, false);
                tryPutPaid(creatMethodIntent);
                try {
                    a.g(mContext).f(mContext, creatMethodIntent);
                } catch (Exception e2) {
                    LogUtils.e(TAG, "Exception ", e2);
                }
            }
            return true;
        }
        iSetMessageReadListener.onFinish();
        return false;
    }

    public void setPaMsgsRead(int i2, int i3, long j, long j2, long j3) {
        if (AccountManager.isLogin(mContext)) {
            if (AccountManager.getMediaRole(mContext)) {
                ChatSessionManagerImpl.getInstance(mContext).mediaSetSessionRead(j, Utility.getBusinessType(i2, i3), j, PaManagerImpl.getInstance(mContext).getPaThirdId(j), j3, null);
            } else {
                setBeforeMsgRead(0, j, j2, false);
            }
        }
    }

    public void tryPutPaid(Intent intent) {
        if (IMConfigInternal.getInstance().getIMConfig(mContext).isNeedPaid()) {
            intent.putExtra(Constants.EXTRA_PA_ID, getPaid());
        }
    }

    public void unRegisterNotify(IOnRegisterNotifyListener iOnRegisterNotifyListener) {
        String addListener = ListenerManager.getInstance().addListener(iOnRegisterNotifyListener);
        if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
            try {
                BindStateManager.saveUnBindInfo(mContext, AccountManager.getToken(mContext), Utility.getIMDeviceId(mContext), Long.valueOf(AccountManager.getUK(mContext)));
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 92);
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                a.g(mContext).f(mContext, creatMethodIntent);
                return;
            } catch (Exception e2) {
                onUnRegisterNotifyResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR);
                LogUtils.e(TAG, "Exception ", e2);
                return;
            }
        }
        onUnRegisterNotifyResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
    }

    public void unregisterLiveMsgReceiveListener(ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        String str = TAG;
        LogUtils.d(str, "unregisterLiveMsgReceiveListener : " + iLiveMsgReceiveListener);
        this.mReceiveStudioListener = null;
    }

    public void unregisterMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        String str = TAG;
        LogUtils.e(str, "unregisterMessageReceiveListener : " + iMessageReceiveListener);
        if (iMessageReceiveListener == null || !this.mReceiveListeners.contains(iMessageReceiveListener)) {
            return;
        }
        this.mReceiveListeners.remove(iMessageReceiveListener);
    }

    public void unregisterMessageSyncListener(Context context, IMessageSyncListener iMessageSyncListener) {
        if (iMessageSyncListener == null || !this.mMessageSyncListener.contains(iMessageSyncListener)) {
            return;
        }
        this.mMessageSyncListener.remove(iMessageSyncListener);
    }

    public void unregisterStudioUsePaReceivePaMsg(ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        synchronized (this.mStudioUsePaListeners) {
            if (iLiveMsgReceiveListener != null) {
                this.mStudioUsePaListeners.remove(iLiveMsgReceiveListener);
            }
        }
    }

    public int updateChatSeesionName(ChatSession chatSession) {
        return ChatMessageDBManager.getInstance(mContext).updateChatSessionName(chatSession);
    }

    public boolean updateMsgContent(ChatMsg chatMsg) {
        return ChatMessageDBManager.getInstance(mContext).updateChatMsgContent(chatMsg) > 0;
    }

    public void deliverMcastMessage(String str, JSONArray jSONArray) {
        onDeliverMcastResponse(str, jSONArray, this.mReceiveStudioListeners.get(str), null);
        deliverMcastMessage(jSONArray);
    }

    public void registerLiveMsgReceiveListener(String str, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        String str2 = TAG;
        LogUtils.d(str2, "registerLiveMsgReceiveListener : " + iLiveMsgReceiveListener + ", mcastid = " + str);
        if (iLiveMsgReceiveListener != null) {
            this.mReceiveStudioListeners.put(str, iLiveMsgReceiveListener);
        }
    }

    public void unregisterLiveMsgReceiveListener(String str) {
        String str2 = TAG;
        LogUtils.d(str2, "do unregisterLiveMsgReceiveListener, mcastid = " + str);
        if (TextUtils.isEmpty(str) || this.mReceiveStudioListeners.remove(str) == null) {
            return;
        }
        LogUtils.d(TAG, " do unregisterLiveMsgReceiveListener done!!! ");
    }

    public ArrayList<ChatMsg> fetchMessageSync(int i2, long j, int i3, ChatMsg chatMsg) {
        if (getPaid() == -2) {
            return null;
        }
        boolean z = true;
        if (1 == i2) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.valueOf(j));
            ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList);
            if ((groupInfo == null || groupInfo.size() <= 0 || groupInfo.get(0).getType() != 2) ? false : false) {
                return GroupMessageDAOImpl.fetchLastChatMsg(mContext, String.valueOf(j), chatMsg, i3, true);
            }
            return GroupMessageDAOImpl.fetchAllChatMsg(mContext, String.valueOf(j), chatMsg, i3, true);
        }
        return ChatMessageDBManager.getInstance(mContext).fetchMsg(getChatObject(i2, j, getPaid()), chatMsg == null ? 0L : chatMsg.getMsgId(), i3, chatMsg == null ? -1L : chatMsg.getRowId());
    }

    public List<ChatMsg> getPaMsgByChatType(List<Integer> list, int i2) {
        if (AccountManager.isLogin(mContext)) {
            return ChatMessageDBManager.getInstance(mContext).getPaMsgByChatTypeAndPaidList(list, null, 0L, i2);
        }
        return null;
    }

    public void mediaDeleteChatMsg(long j, int i2, long j2, String str, long j3, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        String str2 = TAG;
        LogUtils.d(str2, "BC> contactor=" + j + ", contactorType" + i2 + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", listener=" + iMediaDeleteChatMsgListener + ", needDeleteMsgIds=" + list + ", maxDeleteMsgId=" + j3);
        if (!AccountManager.getMediaRole(mContext)) {
            iMediaDeleteChatMsgListener.onMediaDeleteChatMsgResult(2000, null);
            return;
        }
        IMMediaDeleteMsgHttpRequest iMMediaDeleteMsgHttpRequest = new IMMediaDeleteMsgHttpRequest(mContext, j, i2, j2, str, j3, list, ListenerManager.getInstance().addListener(iMediaDeleteChatMsgListener));
        HttpHelper.executor(mContext, iMMediaDeleteMsgHttpRequest, iMMediaDeleteMsgHttpRequest);
    }

    public void mediaFetchChatMsgs(Context context, long j, int i2, long j2, String str, long j3, long j4, int i3, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        String str2 = TAG;
        LogUtils.d(str2, "BC> contactor=" + j + ", contactorType" + i2 + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", beginMsgTime=" + j3 + ", endMsgTime=" + j4 + ", count=" + i3 + ", listener=" + iMediaFetchChatMsgsListener);
        if (!AccountManager.getMediaRole(context)) {
            iMediaFetchChatMsgsListener.onMediaFetchChatMsgsResult(2000, null, false, null);
            return;
        }
        IMMediaFetchMsgHttpRequest iMMediaFetchMsgHttpRequest = new IMMediaFetchMsgHttpRequest(mContext, j, i2, j2, str, j3, j4, i3, ListenerManager.getInstance().addListener(iMediaFetchChatMsgsListener));
        HttpHelper.executor(context, iMMediaFetchMsgHttpRequest, iMMediaFetchMsgHttpRequest);
    }

    public void mediaSendChatMsg(long j, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        String str = TAG;
        LogUtils.d(str, "BC> contactor=" + j + ", listener=" + iMediaSendChatMsgListener + ", sendMsg=" + chatMsg);
        if (!AccountManager.getMediaRole(mContext)) {
            iMediaSendChatMsgListener.onMediaSendChatMsgResult(2000, chatMsg);
            return;
        }
        IMMediaSendMsgHttpRequest iMMediaSendMsgHttpRequest = new IMMediaSendMsgHttpRequest(mContext, j, chatMsg, ListenerManager.getInstance().addListener(iMediaSendChatMsgListener));
        HttpHelper.executor(mContext, iMMediaSendMsgHttpRequest, iMMediaSendMsgHttpRequest);
    }

    public int deleteMsgs(ChatMsg chatMsg) {
        if (chatMsg.getStatus() != 0) {
            if (ChatMessageDBManager.getInstance(mContext).deleteChatMsg(chatMsg) < 0) {
                return DlnaManager.DLNA_ERROR_GET_POSITION_INFO_ACTION_NOT_FOUND;
            }
            return 0;
        }
        deleteMsgs(chatMsg.getCategory(), chatMsg.getContacter(), new long[]{chatMsg.getMsgId()}, chatMsg.isZhida());
        return 0;
    }

    public ArrayList<ChatMsg> fetchMessageSync(int i2, long j, int i3, ChatMsg chatMsg, long[] jArr) {
        if (getPaid() == -2) {
            return null;
        }
        return GroupMessageDAOImpl.fetchAllChatMsg(mContext, String.valueOf(j), chatMsg, i3, true, jArr);
    }

    public void fetchMsgidByMsgid(Context context, int i2, long j, long j2, long j3, int i3, int i4, int i5, IFetchMsgByIdListener iFetchMsgByIdListener) {
        fetchMsgidByMsgid(context, i2, j, j2, j3, i3, i4, i5, iFetchMsgByIdListener, 0);
    }

    public ArrayList<ChatMsg> fetchMessageSync(int i2, long j, int i3, boolean z, ChatMsg chatMsg) {
        if (getPaid() == -2) {
            return null;
        }
        if (1 == i2) {
            return GroupMessageDAOImpl.fetchAllChatMsg(mContext, String.valueOf(j), chatMsg, i3, z);
        }
        return ChatMessageDBManager.getInstance(mContext).fetchMsg(getChatObject(i2, j, getPaid()), chatMsg, i3, z);
    }
}
