package com.baidu.android.imsdk.chatmessage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.repackage.j60;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ChatMsgManagerImpl";
    public static final int USER_IDENTITY_UPDATE_TIME = 600000;
    public static Context mContext;
    public static volatile ChatMsgManagerImpl mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Dispatcher.MsgListener mInitCustomerListener;
    public ArrayList<IMessageReceiveListener> mInternalReceiveListeners;
    public IKickOutListener mKickOutListener;
    public HashMap<Integer, IMediaChatMsgChangedListener> mMediaMsgChangedListeners;
    public List<IMessageSyncListener> mMessageSyncListener;
    public ArrayList<IMessageReceiveListener> mReceiveListeners;
    public ILiveMsgReceiveListener mReceiveStudioListener;
    public HashMap<String, ILiveMsgReceiveListener> mReceiveStudioListeners;
    public final List<ILiveMsgReceiveListener> mStudioUsePaListeners;
    public Dispatcher.MsgListener mSwithcCustomerListener;
    public boolean mUseRequestSendMsg;
    public Dispatcher.MsgListener messageSyncListener;
    public Dispatcher.MsgListener onReceiveListener;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(438990896, "Lcom/baidu/android/imsdk/chatmessage/ChatMsgManagerImpl;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(438990896, "Lcom/baidu/android/imsdk/chatmessage/ChatMsgManagerImpl;");
        }
    }

    public ChatMsgManagerImpl(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mReceiveListeners = new ArrayList<>();
        this.mInternalReceiveListeners = new ArrayList<>();
        this.mReceiveStudioListeners = new HashMap<>();
        this.mStudioUsePaListeners = new ArrayList();
        this.mMessageSyncListener = new LinkedList();
        this.mMediaMsgChangedListeners = new HashMap<>();
        this.mUseRequestSendMsg = false;
        this.onReceiveListener = new Dispatcher.MsgListener(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatMsgManagerImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
            public void dealMessage(int i3, ChatMsg chatMsg) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, chatMsg) == null) {
                }
            }

            @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
            public void dealMessage(int i3, ArrayList<ChatMsg> arrayList) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, arrayList) == null) {
                    String str = ChatMsgManagerImpl.TAG;
                    LogUtils.d(str, "dealMessage triggerReason : " + i3);
                    this.this$0.broadcastMessage(arrayList, true);
                }
            }
        };
        this.messageSyncListener = new Dispatcher.MsgListener(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatMsgManagerImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
            public void dealMessage(int i3, ChatMsg chatMsg) {
                int msgRead;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, chatMsg) == null) && (chatMsg instanceof MessageSyncMsg)) {
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
                        msgRead = ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).deleteMsgBatch(this.this$0.getChatObject(category, contacter, chatMsgByMsgId.getPaid()), new long[]{changedMsgid});
                        if (msgRead > 0 && this.this$0.mMessageSyncListener != null && this.this$0.mMessageSyncListener.size() != 0) {
                            for (IMessageSyncListener iMessageSyncListener : this.this$0.mMessageSyncListener) {
                                if (iMessageSyncListener != null) {
                                    iMessageSyncListener.onMsgDel(changedMsgid);
                                }
                            }
                        }
                    } else {
                        msgRead = ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).setMsgRead(this.this$0.getChatObject(category, contacter, chatMsgByMsgId.getPaid()), changedMsgid);
                        if (msgRead > 0 && this.this$0.mMessageSyncListener != null && this.this$0.mMessageSyncListener.size() != 0) {
                            for (IMessageSyncListener iMessageSyncListener2 : this.this$0.mMessageSyncListener) {
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
            public void dealMessage(int i3, ArrayList<ChatMsg> arrayList) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, arrayList) == null) {
                }
            }
        };
        this.mInitCustomerListener = new Dispatcher.MsgListener(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatMsgManagerImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
            public void dealMessage(int i3, ChatMsg chatMsg) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, chatMsg) == null) && (chatMsg instanceof NotifyCustomerMsg)) {
                    this.this$0.sendNoticeBroadcast(ChatMsgManagerImpl.mContext, (NotifyCustomerMsg) chatMsg);
                }
            }

            @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
            public void dealMessage(int i3, ArrayList<ChatMsg> arrayList) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, arrayList) == null) {
                }
            }
        };
        this.mSwithcCustomerListener = new Dispatcher.MsgListener(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatMsgManagerImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
            public void dealMessage(int i3, ChatMsg chatMsg) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, chatMsg) == null) && (chatMsg instanceof NotifyCustomerMsg)) {
                    this.this$0.sendNoticeBroadcast(ChatMsgManagerImpl.mContext, (NotifyCustomerMsg) chatMsg);
                }
            }

            @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
            public void dealMessage(int i3, ArrayList<ChatMsg> arrayList) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, arrayList) == null) {
                }
            }
        };
        addMessageTypes();
        registerListeners();
    }

    private void addMessageTypes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
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
    }

    private ChatMsg buildChatMsg(int i, int i2, long j, int i3, String str) {
        InterceptResult invokeCommon;
        ChatMsg textMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), str})) == null) {
            if (i3 == 0) {
                textMsg = new TextMsg();
            } else if (i3 == 1) {
                textMsg = new ImageMsg();
            } else if (i3 != 27) {
                textMsg = i3 != 28 ? null : new PassSaveMsg();
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
                textMsg.setCategory(i2);
                textMsg.setChatType(i);
                textMsg.setMsgTime(System.currentTimeMillis() / 1000);
            }
            return textMsg;
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackNotificationMsgData(ArrayList<ChatMsg> arrayList, int i, IFetchNotificationDataListener iFetchNotificationDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65548, this, arrayList, i, iFetchNotificationDataListener) == null) {
            ArrayList arrayList2 = new ArrayList();
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
                    ArrayList arrayList3 = new ArrayList(hashSet);
                    List<Long> notExpiredChatUserByBduids = ChatUserDBManager.getInstance(mContext).getNotExpiredChatUserByBduids(arrayList3, System.currentTimeMillis() - 600000);
                    ArrayList arrayList4 = new ArrayList(arrayList3);
                    arrayList4.removeAll(notExpiredChatUserByBduids);
                    ChatUserManagerImpl.getInstance(mContext).updateUserIdentity(arrayList4, new IGetUserIdentityListener(this, arrayList3, arrayList2, iFetchNotificationDataListener, i) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ChatMsgManagerImpl this$0;
                        public final /* synthetic */ List val$bduids;
                        public final /* synthetic */ int val$count;
                        public final /* synthetic */ ArrayList val$list;
                        public final /* synthetic */ IFetchNotificationDataListener val$listener;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, arrayList3, arrayList2, iFetchNotificationDataListener, Integer.valueOf(i)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$bduids = arrayList3;
                            this.val$list = arrayList2;
                            this.val$listener = iFetchNotificationDataListener;
                            this.val$count = i;
                        }

                        @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
                        public void onGetUserIdentityResult(int i2, List<ChatUser> list) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, list) == null) {
                                if (i2 == 0 && list != null && list.size() > 0) {
                                    ChatUserDBManager.getInstance(ChatMsgManagerImpl.mContext).updateUserIdentity(list);
                                }
                                LongSparseArray<ChatUser> chatUserByBduids = ChatUserDBManager.getInstance(ChatMsgManagerImpl.mContext).getChatUserByBduids(this.val$bduids);
                                Iterator it2 = this.val$list.iterator();
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
                                IFetchNotificationDataListener iFetchNotificationDataListener2 = this.val$listener;
                                ArrayList arrayList5 = this.val$list;
                                iFetchNotificationDataListener2.onFetchResult(arrayList5, arrayList5.size() >= this.val$count);
                            }
                        }
                    });
                    return;
                }
                iFetchNotificationDataListener.onFetchResult(arrayList2, arrayList2.size() >= i);
                return;
            }
            iFetchNotificationDataListener.onFetchResult(arrayList2, false);
        }
    }

    private void configMsgIdsPersiser(ArrayList<Long> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, arrayList) == null) || arrayList == null) {
            return;
        }
        int size = arrayList.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            stringBuffer.append(arrayList.get(i));
            if (i < size - 1) {
                stringBuffer.append(",");
            }
        }
        String str = TAG;
        LogUtils.d(str, "configMsgIdsPersiser ids = " + stringBuffer.toString());
        Utility.writeConfigMsgIds(mContext, stringBuffer.toString());
    }

    private void deliverMcastMessage(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, jSONArray) == null) {
            LogUtils.d(TAG, "old deliverMcastMessage deliver");
            onDeliverMcastResponse("", jSONArray, this.mReceiveStudioListener, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deliverRetrieveMessage(ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, arrayList) == null) {
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
    }

    private ArrayList<ChatMsg> filtMsgs(ArrayList<ChatMsg> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, arrayList)) == null) {
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
        return (ArrayList) invokeL.objValue;
    }

    public static ChatMsgManagerImpl getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
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
        return (ChatMsgManagerImpl) invokeL.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    private String getMsgUUid(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, this, chatMsg)) == null) ? chatMsg == null ? "" : String.format("send.user.msg.%d.%d", Long.valueOf(chatMsg.getRowId()), Integer.valueOf(chatMsg.getCategory())) : (String) invokeL.objValue;
    }

    private boolean hitMcastSendMsgErrorCode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65555, this, i)) == null) ? i == 22 || i == 1 || i == 24 || i == 1000 || i == 1203 || i == 1204 || i == 1207 || i == 1306 || i == 1316 || i == 1314 : invokeI.booleanValue;
    }

    private void mediaGetChatSessions(int i, int i2, long j, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), iGetNewMsgCountListener}) == null) {
            ChatSessionManagerImpl.getInstance(mContext).mediaGetChatSessions(j, Utility.getBusinessType(i, i2), j, PaManagerImpl.getInstance(mContext).getPaThirdId(j), 0L, 1, 0, new IMediaGetChatSessionListener(this, j, iGetNewMsgCountListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.20
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatMsgManagerImpl this$0;
                public final /* synthetic */ IGetNewMsgCountListener val$listener;
                public final /* synthetic */ long val$paid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j), iGetNewMsgCountListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$paid = j;
                    this.val$listener = iGetNewMsgCountListener;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener
                public void onMediaGetChatSessionResult(int i3, int i4, int i5, boolean z, List<ChatSession> list) {
                    int i6;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), list}) == null) {
                        if (i3 == 0 && list != null && list.size() > 0) {
                            for (ChatSession chatSession : list) {
                                String str = ChatMsgManagerImpl.TAG;
                                LogUtils.d(str, "b getPaNewMsgCount session = " + chatSession.toString());
                                if (chatSession.getPaid() == this.val$paid) {
                                    i6 = (int) chatSession.getNewMsgSum();
                                    break;
                                }
                            }
                        }
                        i6 = 0;
                        this.val$listener.onGetNewMsgCount(i6);
                    }
                }
            });
        }
    }

    private boolean noSaveDB(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65557, this, i, i2)) == null) ? i == 7 || i == 4 || i2 == 27 : invokeII.booleanValue;
    }

    private void onDeliverMcastResponse(String str, JSONArray jSONArray, ILiveMsgReceiveListener iLiveMsgReceiveListener, List<Long> list) {
        JSONArray jSONArray2;
        JSONException e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65558, this, str, jSONArray, iLiveMsgReceiveListener, list) == null) {
            if (jSONArray == null) {
                LogUtils.e(TAG, "deliverMcastMessage msgObj is null");
                return;
            }
            String str2 = TAG;
            LogUtils.d(str2, "deliverMcastMessage_size is " + jSONArray.length());
            JSONArray jSONArray3 = new JSONArray();
            ArrayList arrayList = new ArrayList();
            for (int i = 1; i <= jSONArray.length(); i++) {
                try {
                    jSONArray3.put(jSONArray.getJSONObject(i - 1));
                } catch (JSONException e2) {
                    jSONArray2 = jSONArray3;
                    e = e2;
                }
                if (i % 10 == 0) {
                    onDeliverResponse(str, jSONArray3, iLiveMsgReceiveListener, arrayList);
                    jSONArray2 = new JSONArray();
                    try {
                        arrayList.clear();
                    } catch (JSONException e3) {
                        e = e3;
                        LogUtils.e(TAG, "Exception ", e);
                        new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
                        jSONArray3 = jSONArray2;
                    }
                    jSONArray3 = jSONArray2;
                }
            }
            if (jSONArray3.length() > 0) {
                onDeliverResponse(str, jSONArray3, iLiveMsgReceiveListener, arrayList);
            }
        }
    }

    private void onDeliverResponse(String str, JSONArray jSONArray, ILiveMsgReceiveListener iLiveMsgReceiveListener, List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65559, this, str, jSONArray, iLiveMsgReceiveListener, list) == null) {
            if (iLiveMsgReceiveListener != null) {
                iLiveMsgReceiveListener.onReceiveMessage(0, jSONArray);
                String str2 = TAG;
                LogUtils.d(str2, "listener != null and onDeliverResponse arr size :" + jSONArray.length());
                return;
            }
            LogUtils.d(TAG, "mReceiveStudioListener is null");
        }
    }

    private void onSendStudioMsgResult(int i, ChatMsg chatMsg, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, this, new Object[]{Integer.valueOf(i), chatMsg, Long.valueOf(j), str}) == null) {
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
                String str2 = TAG;
                LogUtils.d(str2, "onSendStudioMsgResult----errorCode: " + i);
            }
            if (chatMsg != null) {
                ListenerManager.getInstance().removeListener(chatMsg.mListenerKey);
            }
        }
    }

    private void registerListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
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
            AccountManagerImpl.getInstance(mContext).registerToDoAfterLoginListener(new TodoAfterLogin(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatMsgManagerImpl this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // com.baidu.android.imsdk.account.TodoAfterLogin
                public void todo(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
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
                        TaskManager.getInstance(ChatMsgManagerImpl.mContext).submitForNetWork(new Runnable(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).deleteExpiredDupMsgs();
                                }
                            }
                        });
                    }
                }
            });
            AccountManagerImpl.getInstance(mContext).registerToDoBeforeLogoutListener(new TodoBeforeLogout(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatMsgManagerImpl this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // com.baidu.android.imsdk.account.TodoBeforeLogout
                public void todo() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.unRegisterNotify(null);
                    }
                }
            });
        }
    }

    private String replaceInterActiveBottomBarStatus(String str, int i, int i2) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65562, this, str, i, i2)) == null) {
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
                return jSONObject.toString();
            } catch (JSONException e) {
                LogUtils.e(TAG, e.getMessage());
                new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
                return str;
            }
        }
        return (String) invokeLII.objValue;
    }

    private int saveGroupMessage(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, this, chatMsg)) == null) {
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
        return invokeL.intValue;
    }

    private int saveSingleMsg(ChatMsg chatMsg, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65564, this, chatMsg, i)) == null) {
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
        return invokeLI.intValue;
    }

    private void sendHiddenMsg(@NonNull ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Intent creatMethodIntent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, this, chatMsg, iSendMessageListener) == null) {
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
                if (j60.e && chatMsg.getCategory() == 4) {
                    creatMethodIntent = Utility.createMcastMethodIntent(mContext, 55);
                } else {
                    creatMethodIntent = Utility.creatMethodIntent(mContext, 55);
                }
                creatMethodIntent.putExtra(Constants.EXTRA_SEND_MSG, chatMsg);
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                try {
                    j60.g(mContext).f(mContext, creatMethodIntent);
                    return;
                } catch (Exception e) {
                    onSendMessageResult(6, chatMsg, -1L, addListener);
                    LogUtils.e(TAG, "Exception ", e);
                    return;
                }
            }
            onSendMessageResult(1000, chatMsg, -1L, addListener);
        }
    }

    private void sendMeidaPaChatMsg(int i, int i2, long j, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), chatMsg, iSendMessageListener}) == null) {
            mediaSendChatMsg(j, Utility.getBusinessType(i, i2), j, PaManagerImpl.getInstance(mContext).getPaThirdId(j), chatMsg, new IMediaSendChatMsgListener(this, iSendMessageListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatMsgManagerImpl this$0;
                public final /* synthetic */ ISendMessageListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iSendMessageListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$listener = iSendMessageListener;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                public void onMediaSendChatMsgResult(int i3, ChatMsg chatMsg2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, chatMsg2) == null) {
                        if (i3 == 0) {
                            chatMsg2.setStatus(0);
                        } else {
                            chatMsg2.setStatus(2);
                        }
                        chatMsg2.setRowId(System.currentTimeMillis());
                        String str = ChatMsgManagerImpl.TAG;
                        LogUtils.d(str, "b sendmsg = " + chatMsg2.toJsonString());
                        this.val$listener.onSendMessageResult(i3, chatMsg2);
                    }
                }
            });
        }
    }

    private void sendMessageBroadcast(Context context, ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65567, this, context, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNoticeBroadcast(Context context, ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65568, this, context, chatMsg) == null) {
            Intent intent = new Intent(IMConstants.CUSTOMER_CHANGE);
            intent.setPackage(context.getApplicationContext().getPackageName());
            intent.putExtra(IMConstants.MESSAGE, chatMsg);
            context.sendBroadcast(intent);
        }
    }

    private void setMaxNotifyMsgid(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65569, this, chatMsg) == null) && chatMsg != null && chatMsg.getStatus() == 0) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUploadTask(int i, String str, String str2, String str3, String str4, String str5, String str6, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65570, this, new Object[]{Integer.valueOf(i), str, str2, str3, str4, str5, str6, iUploadTransferListener}) == null) {
            new AsyncUploadTask(mContext, i, str, str2, str3, str4, str5, str6, iUploadTransferListener).execute(new Void[0]);
        }
    }

    private void updateChatMsgStatus(ChatMsg chatMsg, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65571, this, chatMsg, i) == null) {
            chatMsg.setStatus(i == 0 ? 0 : 2);
            ChatMessageDBManager.getInstance(mContext).updateMsgStatus(chatMsg);
        }
    }

    private boolean useRequestSendMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, this)) == null) {
            long appId = Utility.getAppId(mContext);
            return appId == Constants.APPID_HAOKAN || appId == Constants.APPID_HAOKAN_JISU || appId == Constants.APPID_QUANMIN || appId == Constants.APPID_TIEBA;
        }
        return invokeV.booleanValue;
    }

    public void asyncUploadImgToBos(String str, String str2, int i, int i2, int i3, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iUploadTransferListener}) == null) {
            if (AccountManager.isLogin(mContext)) {
                genBosObjectUrl(str, "image/jpeg", str2, i, i2, i3, new IGenBosObjectUrlListener(this, str, iUploadTransferListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ChatMsgManagerImpl this$0;
                    public final /* synthetic */ String val$filePath;
                    public final /* synthetic */ IUploadTransferListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, iUploadTransferListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$filePath = str;
                        this.val$listener = iUploadTransferListener;
                    }

                    @Override // com.baidu.android.imsdk.chatmessage.IGenBosObjectUrlListener
                    public void onGenBosObjectUrlListener(int i4, String str3, String str4, String str5, Map<String, String> map) {
                        String str6;
                        String str7;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i4), str3, str4, str5, map}) == null) {
                            if (i4 == 0) {
                                if (map != null) {
                                    str6 = map.get(AsyncChatTask.PUT_URL);
                                    str7 = map.get(AsyncChatTask.GET_URL);
                                } else {
                                    str6 = "";
                                    str7 = str6;
                                }
                                this.this$0.startUploadTask(1, str6, str7, this.val$filePath, "image/jpeg", str4, str5, this.val$listener);
                                return;
                            }
                            this.val$listener.onFailed(i4, 1, this.val$filePath);
                        }
                    }
                });
            } else {
                iUploadTransferListener.onFailed(1000, 1, str);
            }
        }
    }

    public void audioTrans(String str, String str2, String str3, int i, BIMValueCallBack bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, Integer.valueOf(i), bIMValueCallBack}) == null) {
            String str4 = TAG;
            LogUtils.d(str4, "audioTrans filePath=" + str);
            new IMAudioTransRequest(mContext, str, str2, str3, i, ListenerManager.getInstance().addListener(bIMValueCallBack)).execute();
        }
    }

    public void broadDeleteGroupMsg(Context context, ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, arrayList) == null) {
            sendMessageBroadcast(context, arrayList);
        }
    }

    public void broadcastMessage(ArrayList<ChatMsg> arrayList, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, arrayList, z) == null) {
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
                                i = 0;
                                if (!it.hasNext()) {
                                    break;
                                }
                                IMessageReceiveListener next = it.next();
                                if (next != null) {
                                    next.onReceiveMessage(0, 0, new ArrayList<>(filtMsgs));
                                }
                            }
                            int size = filtMsgs.size();
                            int i2 = size / 20;
                            int i3 = size % 20;
                            while (i < i2) {
                                int i4 = 20 * i;
                                i++;
                                sendMessageBroadcast(mContext, new ArrayList<>(filtMsgs.subList(i4, 20 * i)));
                            }
                            if (i3 > 0) {
                                sendMessageBroadcast(mContext, new ArrayList<>(filtMsgs.subList(size - i3, size)));
                            }
                        }
                    }
                }
            }
        }
    }

    public void clearKillOutListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mKickOutListener = null;
        }
    }

    public void configMsgsFilter(ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            ArrayList<Long> cachedConfigMsgIds = getInstance(mContext).getCachedConfigMsgIds();
            int size = cachedConfigMsgIds.size();
            LogUtils.d(TAG, "configMsgsFilter oldCachedIdsSize=" + size);
            if (size <= 0 || arrayList.isEmpty()) {
                return;
            }
            long j = 0;
            int i = 0;
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

    public long deleteAllMsgs(int i, long j, boolean z) {
        InterceptResult invokeCommon;
        ChatSession chatRecord;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            int i2 = 0;
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
                ChatObject chatObject = getChatObject(i, j, getPaid());
                if (i == 1 && (chatRecord = ChatMessageDBManager.getInstance(mContext).getChatRecord(chatObject)) != null) {
                    i2 = chatRecord.getChatType();
                }
                long deleteAllMsg = ChatMessageDBManager.getInstance(mContext).deleteAllMsg(chatObject);
                if (deleteAllMsg < 0) {
                    return -1009L;
                }
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 57);
                creatMethodIntent.putExtra("category", i);
                creatMethodIntent.putExtra("contacter", j);
                creatMethodIntent.putExtra(Constants.EXTRA_CLIENT_MAX_MSGID, deleteAllMsg);
                creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, z);
                if (i2 > 0) {
                    creatMethodIntent.putExtra("chat_type", i2);
                }
                tryPutPaid(creatMethodIntent);
                try {
                    j60.g(mContext).f(mContext, creatMethodIntent);
                } catch (Exception e) {
                    LogUtils.e(TAG, "Exception ", e);
                }
                return 0L;
            }
            return -1000L;
        }
        return invokeCommon.longValue;
    }

    public long deleteAllSmartMsgs(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            ArrayList<Long> queryPaIdByPaType = PaInfoDBManager.getInstance(mContext).queryPaIdByPaType(i);
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
                        j60.g(mContext).f(mContext, creatMethodIntent);
                    } catch (Exception e) {
                        LogUtils.e(TAG, "Exception ", e);
                    }
                    j = 0;
                }
            }
            return j;
        }
        return invokeI.longValue;
    }

    public int deleteDraftMsg(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) ? getPaid() == -2 ? DlnaManager.DLNA_ERROR_CREATE_SSDP_THREAD_FIAL : ChatMessageDBManager.getInstance(mContext).deleteDraftMsg(getChatObject(i, j, getPaid())) : invokeCommon.intValue;
    }

    public int deleteMsgs(int i, long j, long[] jArr, boolean z) {
        InterceptResult invokeCommon;
        ChatSession chatRecord;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), jArr, Boolean.valueOf(z)})) == null) {
            if (i < 0 || j < 0 || jArr == null || jArr.length <= 0) {
                return -1005;
            }
            if (getPaid() == -2) {
                return DlnaManager.DLNA_ERROR_CREATE_SSDP_THREAD_FIAL;
            }
            if (AccountManager.isLogin(mContext)) {
                ChatObject chatObject = getChatObject(i, j, getPaid());
                int i2 = 0;
                if (i == 1 && (chatRecord = ChatMessageDBManager.getInstance(mContext).getChatRecord(chatObject)) != null) {
                    i2 = chatRecord.getChatType();
                }
                int deleteMsgBatch = ChatMessageDBManager.getInstance(mContext).deleteMsgBatch(getChatObject(i, j, getPaid()), jArr);
                if (deleteMsgBatch >= 0) {
                    Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 57);
                    creatMethodIntent.putExtra("category", i);
                    creatMethodIntent.putExtra("contacter", j);
                    creatMethodIntent.putExtra(Constants.EXTRA_DEL_MSG_IDS, jArr);
                    creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, z);
                    if (i2 > 0) {
                        creatMethodIntent.putExtra("chat_type", i2);
                    }
                    tryPutPaid(creatMethodIntent);
                    try {
                        j60.g(mContext).f(mContext, creatMethodIntent);
                    } catch (Exception e) {
                        LogUtils.e(TAG, "Exception ", e);
                    }
                }
                return deleteMsgBatch;
            }
            return -1000;
        }
        return invokeCommon.intValue;
    }

    public void deliverConfigMessage(ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, arrayList) == null) {
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
    }

    public void deliverFetchedConfigMessage(ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, arrayList) == null) {
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, arrayList) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatMsgManagerImpl this$0;
                public final /* synthetic */ ArrayList val$msgs;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, arrayList};
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
                    this.val$msgs = arrayList;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        LogUtils.d(ChatMsgManagerImpl.TAG, "deliverFetchedConfigMessage ..... ");
                        this.this$0.deliverConfigMessage(this.val$msgs);
                    }
                }
            });
        }
    }

    public void deliverReliableMcastMessage(String str, JSONArray jSONArray, List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, jSONArray, list) == null) {
            onDeliverMcastResponse(str, jSONArray, this.mReceiveStudioListeners.get(str), list);
            deliverMcastMessage(jSONArray);
        }
    }

    public void deliverStudioUsePaMessage(ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, arrayList) == null) {
            JSONArray jSONArray = new JSONArray();
            try {
                Iterator<ChatMsg> it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(new JSONObject(it.next().getMsgContent()));
                }
            } catch (JSONException e) {
                LogUtils.e(TAG, "deliverStudioUsePaMessage Exception ", e);
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
                    TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, arrayList) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.21
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ChatMsgManagerImpl this$0;
                        public final /* synthetic */ ArrayList val$studioMsgs;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, arrayList};
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
                            this.val$studioMsgs = arrayList;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                Iterator it2 = this.val$studioMsgs.iterator();
                                while (it2.hasNext()) {
                                    ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).setStudioMsgRead(((ChatMsg) it2.next()).getMsgId());
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    public void delverFetchedRetrieveMessage(ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, arrayList) == null) {
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, arrayList) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatMsgManagerImpl this$0;
                public final /* synthetic */ ArrayList val$msgs;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, arrayList};
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
                    this.val$msgs = arrayList;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        LogUtils.d(ChatMsgManagerImpl.TAG, "retrieve-->delverFetchedRetrieveMessage ..... ");
                        this.this$0.deliverRetrieveMessage(this.val$msgs);
                    }
                }
            });
        }
    }

    public void fetchConfigMsg(Context context, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            String str = TAG;
            LogUtils.i(str, " limit: " + j2 + " cursor: " + j);
            Intent creatMethodIntent = Utility.creatMethodIntent(context, 193);
            creatMethodIntent.putExtra(Constants.EXTRA_CONFIG_CURSOR, j);
            creatMethodIntent.putExtra(Constants.EXTRA_CONFIG_LIMIT, j2);
            try {
                j60.g(mContext).f(mContext, creatMethodIntent);
            } catch (Exception e) {
                LogUtils.e(TAG, "Exception ", e);
            }
        }
    }

    public ArrayList<ChatMsg> fetchGroupNotifyMsgsSync(int i, long j, int i2, boolean z, ChatMsg chatMsg) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Boolean.valueOf(z), chatMsg})) == null) {
            if (1 == i) {
                return GroupMessageDAOImpl.fetchGroupSystemMsg(mContext, String.valueOf(j), chatMsg, i2, z);
            }
            return ChatMessageDBManager.getInstance(mContext).fetchSpecifyMsgsSync(getChatObject(i, j, getPaid()), 101, chatMsg == null ? 0L : chatMsg.getMsgId(), i2, chatMsg == null ? -1L : chatMsg.getRowId(), z);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    @Deprecated
    public ArrayList<ChatMsg> fetchMessageSync(int i, long j, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            if (getPaid() == -2) {
                return null;
            }
            return ChatMessageDBManager.getInstance(mContext).fetchMsg(getChatObject(i, j, getPaid()), j2, i2, -1L);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<ChatMsg> fetchMessageSyncExceptSystemMsg(int i, long j, int i2, boolean z, ChatMsg chatMsg) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Boolean.valueOf(z), chatMsg})) == null) {
            if (getPaid() == -2) {
                return null;
            }
            if (1 == i) {
                return GroupMessageDAOImpl.fetchChatMsgExceptGroupSystem(mContext, String.valueOf(j), chatMsg, i2, z);
            }
            return ChatMessageDBManager.getInstance(mContext).fetchMsgsExceptGroupSystemMsgSync(getChatObject(i, j, getPaid()), chatMsg == null ? 0L : chatMsg.getMsgId(), i2, chatMsg == null ? -1L : chatMsg.getRowId(), z);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public void fetchMsgByHostRequst(long j, int i, long j2, long j3, long j4, int i2, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2), iFetchMsgByIdListener, Boolean.valueOf(z)}) == null) {
            String str = TAG;
            LogUtils.d(str, "fetchMsgByHostRequst ---> begin :" + j3 + ", end :" + j4);
            IMFetchMsgByHostRequest iMFetchMsgByHostRequest = new IMFetchMsgByHostRequest(mContext, ListenerManager.getInstance().addListener(iFetchMsgByIdListener), j, j2, i, i2, j3, j4, z);
            HttpHelper.executor(mContext, iMFetchMsgByHostRequest, iMFetchMsgByHostRequest);
        }
    }

    public void fetchMsgRequst(long j, long j2, int i, long j3, long j4, long j5, int i2, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i2), iFetchMsgByIdListener, Boolean.valueOf(z)}) == null) {
            String str = TAG;
            LogUtils.d(str, "fetchMsgRequst ---> begin :" + j4 + ", end :" + j5);
            IMFetchMsgRequest iMFetchMsgRequest = new IMFetchMsgRequest(mContext, ListenerManager.getInstance().addListener(iFetchMsgByIdListener), j, j2, j3, i, i2, j4, j5, z);
            HttpHelper.executor(mContext, iMFetchMsgRequest, iMFetchMsgRequest);
        }
    }

    public void fetchMsgidByMsgid(Context context, int i, long j, long j2, long j3, int i2, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener, int i5) {
        Intent creatMethodIntent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iFetchMsgByIdListener, Integer.valueOf(i5)}) == null) {
            String addListener = ListenerManager.getInstance().addListener(iFetchMsgByIdListener);
            String str = TAG;
            LogUtils.i(str, " category: " + i + " contacter: " + j + " beginMsgid: " + j2 + " endMsgid: " + j3 + " count: " + i2 + " triggerReason: " + i3 + " jumpToRecentMsg: " + i4 + " key: " + addListener);
            if (j2 >= 0 && j3 >= 0) {
                if (AccountManager.isLogin(context)) {
                    if (j60.e && i == 4) {
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
                        j60.g(mContext).f(mContext, creatMethodIntent);
                        return;
                    } catch (Exception e) {
                        onFetchMsgByIdResult(context, 6, "start service exception", i, j, j2, j3, i2, -1, 0L, null, null, addListener);
                        LogUtils.e(TAG, "Exception ", e);
                        return;
                    }
                }
                LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                onFetchMsgByIdResult(context, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, i, j, j2, j3, i2, -1, 0L, null, null, addListener);
                return;
            }
            onFetchMsgByIdResult(context, 1005, Constants.ERROR_MSG_PARAMETER_ERROR, i, j, j2, j3, i2, -1, 0L, null, null, addListener);
        }
    }

    public void fetchPaChatMsgs(int i, int i2, long j, long j2, long j3, int i3, IFetchMessageListener iFetchMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), iFetchMessageListener}) == null) {
            if (AccountManager.isLogin(mContext)) {
                if (AccountManager.getMediaRole(mContext)) {
                    mediaFetchChatMsgs(mContext, j, Utility.getBusinessType(i, i2), j, PaManagerImpl.getInstance(mContext).getPaThirdId(j), 0L, j3 - 1, i3, new IMediaFetchChatMsgsListener(this, iFetchMessageListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.16
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ChatMsgManagerImpl this$0;
                        public final /* synthetic */ IFetchMessageListener val$listener;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, iFetchMessageListener};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$listener = iFetchMessageListener;
                        }

                        @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                        public void onMediaFetchChatMsgsResult(int i4, String str, boolean z, List<ChatMsg> list) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i4), str, Boolean.valueOf(z), list}) == null) {
                                if (i4 == 0 && list != null && list.size() > 0) {
                                    Iterator<ChatMsg> it = list.iterator();
                                    while (it.hasNext()) {
                                        String str2 = ChatMsgManagerImpl.TAG;
                                        LogUtils.d(str2, "b fetchPaChatMsgs msg = " + it.next().toJsonString());
                                    }
                                }
                                this.val$listener.onFetchMessageResult(i4, new ArrayList<>(list));
                            }
                        }
                    });
                    return;
                } else {
                    TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, j, j2, i3, iFetchMessageListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.17
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ChatMsgManagerImpl this$0;
                        public final /* synthetic */ int val$count;
                        public final /* synthetic */ IFetchMessageListener val$listener;
                        public final /* synthetic */ long val$msgid;
                        public final /* synthetic */ long val$paid;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3), iFetchMessageListener};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$paid = j;
                            this.val$msgid = j2;
                            this.val$count = i3;
                            this.val$listener = iFetchMessageListener;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(Long.valueOf(this.val$paid));
                                ArrayList<ChatMsg> fetchPaMsgByPaids = ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).fetchPaMsgByPaids(arrayList, this.val$msgid, this.val$count);
                                if (fetchPaMsgByPaids != null && fetchPaMsgByPaids.size() > 0) {
                                    Iterator<ChatMsg> it = fetchPaMsgByPaids.iterator();
                                    while (it.hasNext()) {
                                        String str = ChatMsgManagerImpl.TAG;
                                        LogUtils.d(str, "c fetchPaChatMsgs msg = " + it.next().toJsonString());
                                    }
                                }
                                this.val$listener.onFetchMessageResult(0, fetchPaMsgByPaids);
                            }
                        }
                    });
                    return;
                }
            }
            LogUtils.d(TAG, "not login error");
            iFetchMessageListener.onFetchMessageResult(1000, null);
        }
    }

    public void genBosObjectUrl(String str, String str2, String str3, int i, int i2, int i3, IGenBosObjectUrlListener iGenBosObjectUrlListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iGenBosObjectUrlListener}) == null) {
            String str4 = TAG;
            LogUtils.d(str4, "filePath=" + str);
            IMGenBosObjectUrlRequest iMGenBosObjectUrlRequest = new IMGenBosObjectUrlRequest(mContext, str, str2, str3, i, i2, i3, ListenerManager.getInstance().addListener(iGenBosObjectUrlListener));
            HttpHelper.executor(mContext, iMGenBosObjectUrlRequest, iMGenBosObjectUrlRequest);
        }
    }

    public ArrayList<Long> getCachedConfigMsgIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
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
                } catch (Exception e) {
                    LogUtils.e(TAG, e.getMessage());
                    new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
                }
            }
            LogUtils.d(TAG, "getCachedConfigMsgIds back arr size = " + arrayList.size());
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ChatObject getChatObject(int i, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)})) == null) ? new ChatObject(mContext, i, j, j2, -1) : (ChatObject) invokeCommon.objValue;
    }

    public ChatMsg getDraftMsg(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) ? ChatMessageDBManager.getInstance(mContext).getDraftMsg(i, j) : (ChatMsg) invokeCommon.objValue;
    }

    public long getMaxReliableMsgId(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048609, this, j)) == null) ? ChatMessageDBManager.getInstance(mContext).getMaxReliableMsgId(j) : invokeJ.longValue;
    }

    public ChatMsg getMsgByMsgId(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048610, this, j)) == null) ? ChatMessageDBManager.getInstance(mContext).getMsgByMsgId(j) : (ChatMsg) invokeJ.objValue;
    }

    public int getNewMsgCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? getPaid() == -2 ? DlnaManager.DLNA_ERROR_CREATE_SSDP_THREAD_FIAL : ChatMessageDBManager.getInstance(mContext).getNewMsgCount(getPaid()) : invokeV.intValue;
    }

    public int getNewMsgCountByPaid(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048612, this, j)) == null) ? ChatMessageDBManager.getInstance(mContext).getUnReadMsgCount(getChatObject(0, j, j)) : invokeJ.intValue;
    }

    public long getNewMsgNum(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (AccountManager.isLogin(mContext)) {
                if (getPaid() == -2) {
                    return -1017L;
                }
                return ChatMessageDBManager.getInstance(mContext).getNewMsgNum(getChatObject(i, j, getPaid()));
            }
            return -1L;
        }
        return invokeCommon.longValue;
    }

    public void getNotificationMsgDataList(SparseArray<List<Integer>> sparseArray, long j, int i, IFetchNotificationDataListener iFetchNotificationDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{sparseArray, Long.valueOf(j), Integer.valueOf(i), iFetchNotificationDataListener}) == null) {
            if (AccountManager.isLogin(mContext) && iFetchNotificationDataListener != null) {
                TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, sparseArray, j, Math.abs(i) > 20 ? 20 : i, iFetchNotificationDataListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ChatMsgManagerImpl this$0;
                    public final /* synthetic */ IFetchNotificationDataListener val$listener;
                    public final /* synthetic */ SparseArray val$map;
                    public final /* synthetic */ long val$msgid;
                    public final /* synthetic */ int val$realCount;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, sparseArray, Long.valueOf(j), Integer.valueOf(r10), iFetchNotificationDataListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$map = sparseArray;
                        this.val$msgid = j;
                        this.val$realCount = r10;
                        this.val$listener = iFetchNotificationDataListener;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.callBackNotificationMsgData(ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).getNotificationMsgDataList(this.val$map, this.val$msgid, this.val$realCount), this.val$realCount, this.val$listener);
                        }
                    }
                });
            } else if (iFetchNotificationDataListener != null) {
                iFetchNotificationDataListener.onFetchResult(null, false);
            }
        }
    }

    public List<ChatMsg> getPaMsgByChatType(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048615, this, i, i2)) == null) {
            if (AccountManager.isLogin(mContext)) {
                return ChatMessageDBManager.getInstance(mContext).fetchPaMsgByChatType(i, i2);
            }
            return null;
        }
        return (List) invokeII.objValue;
    }

    public void getPaMsgByChatTypeAndPaidList(List<Integer> list, List<Long> list2, long j, int i, IFetchNotificationDataListener iFetchNotificationDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{list, list2, Long.valueOf(j), Integer.valueOf(i), iFetchNotificationDataListener}) == null) {
            if (AccountManager.isLogin(mContext) && iFetchNotificationDataListener != null) {
                TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, list, list2, j, Math.abs(i) > 20 ? 20 : i, iFetchNotificationDataListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ChatMsgManagerImpl this$0;
                    public final /* synthetic */ List val$chatTypes;
                    public final /* synthetic */ IFetchNotificationDataListener val$listener;
                    public final /* synthetic */ long val$msgid;
                    public final /* synthetic */ List val$paids;
                    public final /* synthetic */ int val$realCount;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, list, list2, Long.valueOf(j), Integer.valueOf(r11), iFetchNotificationDataListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$chatTypes = list;
                        this.val$paids = list2;
                        this.val$msgid = j;
                        this.val$realCount = r11;
                        this.val$listener = iFetchNotificationDataListener;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.callBackNotificationMsgData(ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).getPaMsgByChatTypeAndPaidList(this.val$chatTypes, this.val$paids, this.val$msgid, this.val$realCount), this.val$realCount, this.val$listener);
                        }
                    }
                });
            } else if (iFetchNotificationDataListener != null) {
                iFetchNotificationDataListener.onFetchResult(null, false);
            }
        }
    }

    public void getPaNewMsgCount(int i, int i2, long j, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), iGetNewMsgCountListener}) == null) {
            if (AccountManager.isLogin(mContext)) {
                if (AccountManager.getMediaRole(mContext)) {
                    mediaGetChatSessions(i, i2, j, iGetNewMsgCountListener);
                    return;
                }
                LogUtils.d(TAG, "c getPaNewMsgCount");
                TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, iGetNewMsgCountListener, j) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.19
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ChatMsgManagerImpl this$0;
                    public final /* synthetic */ IGetNewMsgCountListener val$listener;
                    public final /* synthetic */ long val$paid;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iGetNewMsgCountListener, Long.valueOf(j)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$listener = iGetNewMsgCountListener;
                        this.val$paid = j;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$listener.onGetNewMsgCount(this.this$0.getNewMsgCountByPaid(this.val$paid));
                        }
                    }
                });
                return;
            }
            LogUtils.d(TAG, "login error");
            iGetNewMsgCountListener.onGetNewMsgCount(0);
        }
    }

    public long getPaid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (IMConfigInternal.getInstance().getIMConfig(mContext).isNeedPaid()) {
                long paid = Utility.getPaid(mContext);
                if (paid == -1) {
                    return -2L;
                }
                return paid;
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public void handleMediaNotifyMessage(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, jSONObject) == null) {
            try {
                if (!AccountManager.getMediaRole(mContext) || jSONObject == null || this.mMediaMsgChangedListeners == null || this.mMediaMsgChangedListeners.isEmpty()) {
                    return;
                }
                String str = TAG;
                LogUtils.i(str, "BC> handleMediaNotifyMessage msgobj=" + jSONObject.toString());
                TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, jSONObject) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ChatMsgManagerImpl this$0;
                    public final /* synthetic */ JSONObject val$notifyMsg;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, jSONObject};
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
                        this.val$notifyMsg = jSONObject;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            int optInt = this.val$notifyMsg.optInt("type", -1);
                            JSONObject optJSONObject = this.val$notifyMsg.optJSONObject("content");
                            long optLong = optJSONObject.optLong("contacter_bduid", -1L);
                            int optInt2 = optJSONObject.optInt("contacter_type", -1);
                            long optLong2 = optJSONObject.optLong("contacter_pauid", -1L);
                            String optString = optJSONObject.optString("contacter_third_id", "");
                            long optLong3 = optJSONObject.optLong("msgid", -1L);
                            for (Integer num : this.this$0.mMediaMsgChangedListeners.keySet()) {
                                ((IMediaChatMsgChangedListener) this.this$0.mMediaMsgChangedListeners.get(Integer.valueOf(num.intValue()))).onMediaChatMsgChangedResult(optInt, optLong, optInt2, optLong2, optString, optLong3);
                            }
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int markMessageClicked(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, chatMsg)) == null) {
            chatMsg.setIsClicked(true);
            return ChatMessageDBManager.getInstance(mContext).markMsgClicked(chatMsg);
        }
        return invokeL.intValue;
    }

    public void mediaDeleteChatMsg(long j, long j2, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), list, iMediaDeleteChatMsgListener}) == null) {
            String str = TAG;
            LogUtils.d(str, "BC> contactor=" + j + ", listener=" + iMediaDeleteChatMsgListener + ", needDeleteMsgIds=" + list + ", maxDeleteMsgId=" + j2);
            if (!AccountManager.getMediaRole(mContext)) {
                iMediaDeleteChatMsgListener.onMediaDeleteChatMsgResult(2000, null);
                return;
            }
            IMMediaDeleteMsgHttpRequest iMMediaDeleteMsgHttpRequest = new IMMediaDeleteMsgHttpRequest(mContext, j, j2, list, ListenerManager.getInstance().addListener(iMediaDeleteChatMsgListener));
            HttpHelper.executor(mContext, iMMediaDeleteMsgHttpRequest, iMMediaDeleteMsgHttpRequest);
        }
    }

    public void mediaFetchChatMsgs(Context context, long j, long j2, long j3, int i, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), iMediaFetchChatMsgsListener}) == null) {
            String str = TAG;
            LogUtils.d(str, "BC> contactor=" + j + ", beginMsgTime=" + j2 + ", endMsgTime=" + j3 + ", count=" + i + ", listener=" + iMediaFetchChatMsgsListener);
            if (!AccountManager.getMediaRole(context)) {
                iMediaFetchChatMsgsListener.onMediaFetchChatMsgsResult(2000, null, false, null);
                return;
            }
            IMMediaFetchMsgHttpRequest iMMediaFetchMsgHttpRequest = new IMMediaFetchMsgHttpRequest(mContext, j, j2, j3, i, ListenerManager.getInstance().addListener(iMediaFetchChatMsgsListener));
            HttpHelper.executor(context, iMMediaFetchMsgHttpRequest, iMMediaFetchMsgHttpRequest);
        }
    }

    public void mediaRegisterChatMsgChangedListener(IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, iMediaChatMsgChangedListener) == null) || iMediaChatMsgChangedListener == null) {
            return;
        }
        this.mMediaMsgChangedListeners.put(Integer.valueOf(iMediaChatMsgChangedListener.hashCode()), iMediaChatMsgChangedListener);
    }

    public void mediaSendChatMsg(long j, int i, long j2, String str, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, chatMsg, iMediaSendChatMsgListener}) == null) {
            String str2 = TAG;
            LogUtils.d(str2, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", listener=" + iMediaSendChatMsgListener + ", sendMsg=" + chatMsg);
            if (!AccountManager.getMediaRole(mContext)) {
                iMediaSendChatMsgListener.onMediaSendChatMsgResult(2000, chatMsg);
                return;
            }
            IMMediaSendMsgHttpRequest iMMediaSendMsgHttpRequest = new IMMediaSendMsgHttpRequest(mContext, j, i, j2, str, chatMsg, ListenerManager.getInstance().addListener(iMediaSendChatMsgListener));
            HttpHelper.executor(mContext, iMMediaSendMsgHttpRequest, iMMediaSendMsgHttpRequest);
        }
    }

    public void mediaUnRegisterChatMsgChangedListener(IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, iMediaChatMsgChangedListener) == null) || iMediaChatMsgChangedListener == null) {
            return;
        }
        this.mMediaMsgChangedListeners.remove(Integer.valueOf(iMediaChatMsgChangedListener.hashCode()));
    }

    public void onAudioTransCallBack(String str, int i, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048630, this, str, i, str2, str3) == null) {
            String str4 = TAG;
            LogUtils.d(str4, "onAudioTransCallBack----errorCode: " + i + " msg: " + str2);
            BIMValueCallBack bIMValueCallBack = (BIMValueCallBack) ListenerManager.getInstance().removeListener(str);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(i, str2, str3);
            } else {
                LogUtils.d(TAG, "onAudioTransCallBack listener is null");
            }
        }
    }

    public void onFetchMsgByIdResult(Context context, int i, String str, int i2, long j, long j2, long j3, int i3, int i4, long j4, String str2, ArrayList<ChatMsg> arrayList, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{context, Integer.valueOf(i), str, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j4), str2, arrayList, str3}) == null) {
            if (arrayList != null) {
                String str4 = TAG;
                LogUtils.d(str4, "onFetchMsgByIdResult----errorCode: " + i + " msg:" + str + ", contacter:" + j + ",fetchedMsgs size " + arrayList.size());
            } else {
                String str5 = TAG;
                LogUtils.d(str5, "onFetchMsgByIdResult----errorCode: " + i + " msg:" + str + ", contacter:" + j + ",fetchedMsgs is null.");
            }
            if (arrayList != null && arrayList.size() == 1) {
                try {
                    Long.parseLong(str3.substring(1, 14));
                    System.currentTimeMillis();
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
    }

    public void onGenBosObjectUrl(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{str, Integer.valueOf(i), str2, str3, str4, map}) == null) {
            String str5 = TAG;
            LogUtils.d(str5, "onGenBosObjectUrl----errorCode: " + i + " msg: " + str2);
            IGenBosObjectUrlListener iGenBosObjectUrlListener = (IGenBosObjectUrlListener) ListenerManager.getInstance().removeListener(str);
            if (iGenBosObjectUrlListener != null) {
                iGenBosObjectUrlListener.onGenBosObjectUrlListener(i, str2, str3, str4, map);
            } else {
                LogUtils.d(TAG, "onGenBosObjectUrl is null");
            }
        }
    }

    public void onMediaDeleteChatMsgResult(String str, int i, String str2) {
        IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048633, this, str, i, str2) == null) || (iMediaDeleteChatMsgListener = (IMediaDeleteChatMsgListener) ListenerManager.getInstance().removeListener(str)) == null) {
            return;
        }
        String str3 = TAG;
        LogUtils.d(str3, "BC> responseCode=" + i + ", msg=" + str2);
        iMediaDeleteChatMsgListener.onMediaDeleteChatMsgResult(i, str2);
    }

    public void onMediaFetchChatMsgsResult(String str, int i, String str2, boolean z, List<ChatMsg> list) {
        IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z), list}) == null) || (iMediaFetchChatMsgsListener = (IMediaFetchChatMsgsListener) ListenerManager.getInstance().removeListener(str)) == null) {
            return;
        }
        String str3 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("BC> responseCode=");
        sb.append(i);
        sb.append(", strMsg=");
        sb.append(str2);
        sb.append(", hasMore=");
        sb.append(z);
        sb.append(", msgs=");
        sb.append(list != null ? list.toString() : "");
        LogUtils.d(str3, sb.toString());
        iMediaFetchChatMsgsListener.onMediaFetchChatMsgsResult(i, str2, z, list);
    }

    public void onMediaSendChatMsgResult(String str, int i, ChatMsg chatMsg) {
        IMediaSendChatMsgListener iMediaSendChatMsgListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048635, this, str, i, chatMsg) == null) || (iMediaSendChatMsgListener = (IMediaSendChatMsgListener) ListenerManager.getInstance().removeListener(str)) == null) {
            return;
        }
        String str2 = TAG;
        LogUtils.d(str2, "BC> responseCode=" + i + ", msg=" + chatMsg);
        iMediaSendChatMsgListener.onMediaSendChatMsgResult(i, chatMsg);
    }

    public void onSendMessageResult(int i, ChatMsg chatMsg, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{Integer.valueOf(i), chatMsg, Long.valueOf(j), str}) == null) {
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
                    String str2 = TAG;
                    LogUtils.d(str2, "onSendMessageResult----errorCode: " + i);
                    try {
                        Long.parseLong(str.substring(1, 14));
                        System.currentTimeMillis();
                    } catch (Exception e) {
                        LogUtils.e(TAG, "get message receive time error", e);
                        new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
                    }
                    if (j != -1) {
                        chatMsg.setMsgTime(j);
                    }
                    DBManager.getInstance(mContext).deleteCmdMsg(getMsgUUid(chatMsg));
                    updateChatMsgStatus(chatMsg, i);
                    setMaxNotifyMsgid(chatMsg);
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
                String str3 = TAG;
                LogUtils.e(str3, "onSendMessageResult exception " + e2.getMessage());
            }
        }
    }

    public void onUnRegisterNotifyResult(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048637, this, str, i, str2) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "onUnRegisterNotifyResult----errorCode: " + i + " msg: " + str2);
            if (i == 0) {
                BindStateManager.setunBindPush(mContext);
            }
            IOnRegisterNotifyListener iOnRegisterNotifyListener = (IOnRegisterNotifyListener) ListenerManager.getInstance().removeListener(str);
            if (iOnRegisterNotifyListener != null) {
                iOnRegisterNotifyListener.onUnRegisterNotifyResult(i, str2);
            }
        }
    }

    public void persisConfigMsgIds(ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048638, this, arrayList) == null) || arrayList == null || arrayList.isEmpty()) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, iMessageReceiveListener) == null) {
            String str = TAG;
            LogUtils.e(str, "retrieve-->registerInternalMessageReceiveListener : " + iMessageReceiveListener);
            if (iMessageReceiveListener == null || this.mInternalReceiveListeners.contains(iMessageReceiveListener)) {
                return;
            }
            this.mInternalReceiveListeners.add(iMessageReceiveListener);
        }
    }

    public void registerKillOutListener(IKickOutListener iKickOutListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, iKickOutListener) == null) {
            this.mKickOutListener = iKickOutListener;
        }
    }

    public void registerLiveMsgReceiveListener(ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, iLiveMsgReceiveListener) == null) {
            String str = TAG;
            LogUtils.d(str, "registerLiveMsgReceiveListener : " + iLiveMsgReceiveListener);
            if (iLiveMsgReceiveListener != null) {
                this.mReceiveStudioListener = iLiveMsgReceiveListener;
            }
        }
    }

    public void registerMessageReceiveListener(IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, iMessageReceiveListener) == null) {
            String str = TAG;
            LogUtils.e(str, "registerMessageReceiveListener : " + iMessageReceiveListener);
            if (iMessageReceiveListener == null || this.mReceiveListeners.contains(iMessageReceiveListener)) {
                return;
            }
            this.mReceiveListeners.add(iMessageReceiveListener);
        }
    }

    public void registerMessageSyncListener(Context context, IMessageSyncListener iMessageSyncListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048644, this, context, iMessageSyncListener) == null) || iMessageSyncListener == null || this.mMessageSyncListener.contains(iMessageSyncListener)) {
            return;
        }
        this.mMessageSyncListener.add(iMessageSyncListener);
    }

    public boolean registerNotify(String str, String str2, String str3, IOnRegisterNotifyListener iOnRegisterNotifyListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048645, this, str, str2, str3, iOnRegisterNotifyListener)) == null) ? BindStateManager.startBindPush(mContext, str, str2, str3, iOnRegisterNotifyListener) : invokeLLLL.booleanValue;
    }

    public void registerStudioUsePaReceivePaMsg(ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, iLiveMsgReceiveListener) == null) {
            synchronized (this.mStudioUsePaListeners) {
                if (iLiveMsgReceiveListener != null) {
                    if (!this.mStudioUsePaListeners.contains(iLiveMsgReceiveListener)) {
                        this.mStudioUsePaListeners.add(iLiveMsgReceiveListener);
                    }
                }
            }
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatMsgManagerImpl this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        LogUtils.d(ChatMsgManagerImpl.TAG, "registerStudioUsePaReceivePaMsg and deliverStudioUsePaMessage");
                        this.this$0.deliverStudioUsePaMessage(ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).getStudioUsePaUnReadMsg());
                    }
                }
            });
        }
    }

    public void resendMsg(String str, String str2, int i, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048647, this, str, str2, i, iSendMessageListener) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "resendMsg " + str + " " + str2 + " ---->");
            if (i == 0) {
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
    }

    public int saveAsDraftMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, chatMsg)) == null) {
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
        return invokeL.intValue;
    }

    public int saveMessage(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, chatMsg)) == null) {
            if (chatMsg != null && AccountManager.isLogin(mContext)) {
                if (1 == chatMsg.getCategory()) {
                    return saveGroupMessage(chatMsg);
                }
                return saveSingleMsg(chatMsg, -1);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void sendMessage(ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048650, this, chatMsg, iSendMessageListener) == null) {
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
                            j60.g(mContext).f(mContext, creatMethodIntent);
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
    }

    public void sendMessageRequest(ChatMsg chatMsg, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048651, this, chatMsg, str) == null) {
            String str2 = TAG;
            LogUtils.d(str2, "sendMessageRequest ---> msg :" + chatMsg.toString());
            this.mUseRequestSendMsg = true;
            IMSendMsgRequest iMSendMsgRequest = new IMSendMsgRequest(mContext, chatMsg, str);
            HttpHelper.executor(mContext, iMSendMsgRequest, iMSendMsgRequest);
        }
    }

    public void sendPaChatMsg(int i, int i2, long j, int i3, String str, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048652, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), str, iSendMessageListener}) == null) {
            if (AccountManager.isLogin(mContext)) {
                ChatMsg buildChatMsg = buildChatMsg(i, 0, j, i3, str);
                if (buildChatMsg == null) {
                    iSendMessageListener.onSendMessageResult(1005, null);
                    return;
                }
                String str2 = TAG;
                LogUtils.d(str2, "buildChatMsg = " + buildChatMsg.toString());
                if (AccountManager.getMediaRole(mContext)) {
                    sendMeidaPaChatMsg(i, i2, j, buildChatMsg, iSendMessageListener);
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
    }

    public boolean setAllMsgRead(int i, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048653, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            if (i != 17 && i != 26) {
                return setBeforeMsgRead(i, j, ChatMessageDBManager.getInstance(mContext).getMaxMsgid(getChatObject(i, j, getPaid())), z);
            }
            boolean z2 = false;
            ArrayList<Long> queryPaIdByPaType = PaInfoDBManager.getInstance(mContext).queryPaIdByPaType(i);
            if (queryPaIdByPaType != null && !queryPaIdByPaType.isEmpty()) {
                Iterator<Long> it = queryPaIdByPaType.iterator();
                while (it.hasNext()) {
                    long longValue = it.next().longValue();
                    z2 = setBeforeMsgRead(0, longValue, ChatMessageDBManager.getInstance(mContext).getMaxMsgid(getChatObject(0, longValue, longValue)), z);
                }
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    public boolean setBeforeMsgRead(int i, long j, long j2, boolean z) {
        InterceptResult invokeCommon;
        ChatObject chatObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048654, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            if (getPaid() != -2 && AccountManager.isLogin(mContext)) {
                if ((Constants.PAFLAG & j) != 0) {
                    chatObject = getChatObject(i, j, j);
                } else {
                    chatObject = getChatObject(i, j, getPaid());
                }
                ChatSession chatRecord = ChatMessageDBManager.getInstance(mContext).getChatRecord(chatObject);
                if (chatRecord != null) {
                    int i2 = (chatRecord.getNewMsgSum() > 0L ? 1 : (chatRecord.getNewMsgSum() == 0L ? 0 : -1));
                    if (i2 < 0) {
                        return false;
                    }
                    if (i2 == 0) {
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
                        j60.g(mContext).f(mContext, creatMethodIntent);
                    } catch (Exception e) {
                        LogUtils.e(TAG, "Exception ", e);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void setInterActiveMsgStatus(long j, long j2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048655, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
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
                    ChatUserManagerImpl.getInstance(mContext).updateUserIdentity(arrayList, new IGetUserIdentityListener(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.13
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ChatMsgManagerImpl this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
                        public void onGetUserIdentityResult(int i3, List<ChatUser> list) {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, list) == null) && i3 == 0) {
                                ChatUserDBManager.getInstance(ChatMsgManagerImpl.mContext).updateUserIdentity(list);
                            }
                        }
                    });
                }
            }
        }
    }

    public boolean setMsgRead(int i, long j, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048656, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            if (getPaid() != -2 && AccountManager.isLogin(mContext) && ChatMessageDBManager.getInstance(mContext).setMsgRead(getChatObject(i, j, getPaid()), j2) >= 0) {
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 67);
                creatMethodIntent.putExtra("category", i);
                creatMethodIntent.putExtra("contacter", j);
                creatMethodIntent.putExtra("msgid", j2);
                creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, z);
                tryPutPaid(creatMethodIntent);
                try {
                    j60.g(mContext).f(mContext, creatMethodIntent);
                    return true;
                } catch (Exception e) {
                    LogUtils.e(TAG, "Exception ", e);
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean setMsgReadByChatTpyes(List<Integer> list, long j) {
        InterceptResult invokeLJ;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048657, this, list, j)) == null) {
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
                        j60.g(mContext).f(mContext, creatMethodIntent);
                    } catch (Exception e) {
                        LogUtils.e(TAG, "Exception ", e);
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public boolean setMsgReadByChatTypeAndSubType(SparseArray<List<Integer>> sparseArray, long j, ISetMessageReadListener iSetMessageReadListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048658, this, new Object[]{sparseArray, Long.valueOf(j), iSetMessageReadListener})) == null) {
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
                        j60.g(mContext).f(mContext, creatMethodIntent);
                    } catch (Exception e) {
                        LogUtils.e(TAG, "Exception ", e);
                    }
                }
                return true;
            }
            iSetMessageReadListener.onFinish();
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void setPaMsgsRead(int i, int i2, long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048659, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) && AccountManager.isLogin(mContext)) {
            if (AccountManager.getMediaRole(mContext)) {
                ChatSessionManagerImpl.getInstance(mContext).mediaSetSessionRead(j, Utility.getBusinessType(i, i2), j, PaManagerImpl.getInstance(mContext).getPaThirdId(j), j3, null);
            } else {
                setBeforeMsgRead(0, j, j2, false);
            }
        }
    }

    public void tryPutPaid(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048660, this, intent) == null) && IMConfigInternal.getInstance().getIMConfig(mContext).isNeedPaid()) {
            intent.putExtra(Constants.EXTRA_PA_ID, getPaid());
        }
    }

    public void unRegisterNotify(IOnRegisterNotifyListener iOnRegisterNotifyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, iOnRegisterNotifyListener) == null) {
            String addListener = ListenerManager.getInstance().addListener(iOnRegisterNotifyListener);
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                try {
                    BindStateManager.saveUnBindInfo(mContext, AccountManager.getToken(mContext), Utility.getIMDeviceId(mContext), Long.valueOf(AccountManager.getUK(mContext)));
                    Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 92);
                    creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                    j60.g(mContext).f(mContext, creatMethodIntent);
                    return;
                } catch (Exception e) {
                    onUnRegisterNotifyResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR);
                    LogUtils.e(TAG, "Exception ", e);
                    return;
                }
            }
            onUnRegisterNotifyResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
        }
    }

    public void unregisterLiveMsgReceiveListener(ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, iLiveMsgReceiveListener) == null) {
            String str = TAG;
            LogUtils.d(str, "unregisterLiveMsgReceiveListener : " + iLiveMsgReceiveListener);
            this.mReceiveStudioListener = null;
        }
    }

    public void unregisterMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048664, this, context, iMessageReceiveListener) == null) {
            String str = TAG;
            LogUtils.e(str, "unregisterMessageReceiveListener : " + iMessageReceiveListener);
            if (iMessageReceiveListener == null || !this.mReceiveListeners.contains(iMessageReceiveListener)) {
                return;
            }
            this.mReceiveListeners.remove(iMessageReceiveListener);
        }
    }

    public void unregisterMessageSyncListener(Context context, IMessageSyncListener iMessageSyncListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048665, this, context, iMessageSyncListener) == null) && iMessageSyncListener != null && this.mMessageSyncListener.contains(iMessageSyncListener)) {
            this.mMessageSyncListener.remove(iMessageSyncListener);
        }
    }

    public void unregisterStudioUsePaReceivePaMsg(ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, iLiveMsgReceiveListener) == null) {
            synchronized (this.mStudioUsePaListeners) {
                if (iLiveMsgReceiveListener != null) {
                    this.mStudioUsePaListeners.remove(iLiveMsgReceiveListener);
                }
            }
        }
    }

    public int updateChatSeesionName(ChatSession chatSession) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048667, this, chatSession)) == null) ? ChatMessageDBManager.getInstance(mContext).updateChatSessionName(chatSession) : invokeL.intValue;
    }

    public boolean updateMsgContent(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, chatMsg)) == null) ? ChatMessageDBManager.getInstance(mContext).updateChatMsgContent(chatMsg) > 0 : invokeL.booleanValue;
    }

    public void deliverMcastMessage(String str, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, jSONArray) == null) {
            onDeliverMcastResponse(str, jSONArray, this.mReceiveStudioListeners.get(str), null);
            deliverMcastMessage(jSONArray);
        }
    }

    public void registerLiveMsgReceiveListener(String str, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048642, this, str, iLiveMsgReceiveListener) == null) {
            String str2 = TAG;
            LogUtils.d(str2, "registerLiveMsgReceiveListener : " + iLiveMsgReceiveListener + ", mcastid = " + str);
            if (iLiveMsgReceiveListener != null) {
                this.mReceiveStudioListeners.put(str, iLiveMsgReceiveListener);
            }
        }
    }

    public void unregisterLiveMsgReceiveListener(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, str) == null) {
            String str2 = TAG;
            LogUtils.d(str2, "do unregisterLiveMsgReceiveListener, mcastid = " + str);
            if (TextUtils.isEmpty(str) || this.mReceiveStudioListeners.remove(str) == null) {
                return;
            }
            LogUtils.d(TAG, " do unregisterLiveMsgReceiveListener done!!! ");
        }
    }

    public ArrayList<ChatMsg> fetchMessageSync(int i, long j, int i2, ChatMsg chatMsg) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), chatMsg})) == null) {
            if (getPaid() == -2) {
                return null;
            }
            boolean z = true;
            if (1 == i) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(String.valueOf(j));
                ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList);
                if ((groupInfo == null || groupInfo.size() <= 0 || groupInfo.get(0).getType() != 2) ? false : false) {
                    return GroupMessageDAOImpl.fetchLastChatMsg(mContext, String.valueOf(j), chatMsg, i2, true);
                }
                return GroupMessageDAOImpl.fetchAllChatMsg(mContext, String.valueOf(j), chatMsg, i2, true);
            }
            return ChatMessageDBManager.getInstance(mContext).fetchMsg(getChatObject(i, j, getPaid()), chatMsg == null ? 0L : chatMsg.getMsgId(), i2, chatMsg == null ? -1L : chatMsg.getRowId());
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public List<ChatMsg> getPaMsgByChatType(List<Integer> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048616, this, list, i)) == null) {
            if (AccountManager.isLogin(mContext)) {
                return ChatMessageDBManager.getInstance(mContext).getPaMsgByChatTypeAndPaidList(list, null, 0L, i);
            }
            return null;
        }
        return (List) invokeLI.objValue;
    }

    public void mediaDeleteChatMsg(long j, int i, long j2, String str, long j3, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), list, iMediaDeleteChatMsgListener}) == null) {
            String str2 = TAG;
            LogUtils.d(str2, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", listener=" + iMediaDeleteChatMsgListener + ", needDeleteMsgIds=" + list + ", maxDeleteMsgId=" + j3);
            if (!AccountManager.getMediaRole(mContext)) {
                iMediaDeleteChatMsgListener.onMediaDeleteChatMsgResult(2000, null);
                return;
            }
            IMMediaDeleteMsgHttpRequest iMMediaDeleteMsgHttpRequest = new IMMediaDeleteMsgHttpRequest(mContext, j, i, j2, str, j3, list, ListenerManager.getInstance().addListener(iMediaDeleteChatMsgListener));
            HttpHelper.executor(mContext, iMMediaDeleteMsgHttpRequest, iMMediaDeleteMsgHttpRequest);
        }
    }

    public void mediaFetchChatMsgs(Context context, long j, int i, long j2, String str, long j3, long j4, int i2, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2), iMediaFetchChatMsgsListener}) == null) {
            String str2 = TAG;
            LogUtils.d(str2, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", beginMsgTime=" + j3 + ", endMsgTime=" + j4 + ", count=" + i2 + ", listener=" + iMediaFetchChatMsgsListener);
            if (!AccountManager.getMediaRole(context)) {
                iMediaFetchChatMsgsListener.onMediaFetchChatMsgsResult(2000, null, false, null);
                return;
            }
            IMMediaFetchMsgHttpRequest iMMediaFetchMsgHttpRequest = new IMMediaFetchMsgHttpRequest(mContext, j, i, j2, str, j3, j4, i2, ListenerManager.getInstance().addListener(iMediaFetchChatMsgsListener));
            HttpHelper.executor(context, iMMediaFetchMsgHttpRequest, iMMediaFetchMsgHttpRequest);
        }
    }

    public void mediaSendChatMsg(long j, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Long.valueOf(j), chatMsg, iMediaSendChatMsgListener}) == null) {
            String str = TAG;
            LogUtils.d(str, "BC> contactor=" + j + ", listener=" + iMediaSendChatMsgListener + ", sendMsg=" + chatMsg);
            if (!AccountManager.getMediaRole(mContext)) {
                iMediaSendChatMsgListener.onMediaSendChatMsgResult(2000, chatMsg);
                return;
            }
            IMMediaSendMsgHttpRequest iMMediaSendMsgHttpRequest = new IMMediaSendMsgHttpRequest(mContext, j, chatMsg, ListenerManager.getInstance().addListener(iMediaSendChatMsgListener));
            HttpHelper.executor(mContext, iMMediaSendMsgHttpRequest, iMMediaSendMsgHttpRequest);
        }
    }

    public int deleteMsgs(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, chatMsg)) == null) {
            if (chatMsg.getStatus() != 0) {
                if (ChatMessageDBManager.getInstance(mContext).deleteChatMsg(chatMsg) < 0) {
                    return DlnaManager.DLNA_ERROR_GET_POSITION_INFO_ACTION_NOT_FOUND;
                }
                return 0;
            }
            deleteMsgs(chatMsg.getCategory(), chatMsg.getContacter(), new long[]{chatMsg.getMsgId()}, chatMsg.isZhida());
            return 0;
        }
        return invokeL.intValue;
    }

    public ArrayList<ChatMsg> fetchMessageSync(int i, long j, int i2, ChatMsg chatMsg, long[] jArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), chatMsg, jArr})) == null) {
            if (getPaid() == -2) {
                return null;
            }
            return GroupMessageDAOImpl.fetchAllChatMsg(mContext, String.valueOf(j), chatMsg, i2, true, jArr);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public void fetchMsgidByMsgid(Context context, int i, long j, long j2, long j3, int i2, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iFetchMsgByIdListener}) == null) {
            fetchMsgidByMsgid(context, i, j, j2, j3, i2, i3, i4, iFetchMsgByIdListener, 0);
        }
    }

    public ArrayList<ChatMsg> fetchMessageSync(int i, long j, int i2, boolean z, ChatMsg chatMsg) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Boolean.valueOf(z), chatMsg})) == null) {
            if (getPaid() == -2) {
                return null;
            }
            if (1 == i) {
                return GroupMessageDAOImpl.fetchAllChatMsg(mContext, String.valueOf(j), chatMsg, i2, z);
            }
            return ChatMessageDBManager.getInstance(mContext).fetchMsg(getChatObject(i, j, getPaid()), chatMsg, i2, z);
        }
        return (ArrayList) invokeCommon.objValue;
    }
}
