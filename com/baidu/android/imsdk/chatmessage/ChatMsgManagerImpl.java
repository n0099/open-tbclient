package com.baidu.android.imsdk.chatmessage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.account.TodoAfterLogin;
import com.baidu.android.imsdk.account.TodoBeforeLogout;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.BrandMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupMessageDeleteMsg;
import com.baidu.android.imsdk.chatmessage.messages.HtmlMsg;
import com.baidu.android.imsdk.chatmessage.messages.ImageMsg;
import com.baidu.android.imsdk.chatmessage.messages.InterActiveMsg;
import com.baidu.android.imsdk.chatmessage.messages.LiveCardMsg;
import com.baidu.android.imsdk.chatmessage.messages.MessageClueUpateMsg;
import com.baidu.android.imsdk.chatmessage.messages.MessageSyncMsg;
import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import com.baidu.android.imsdk.chatmessage.messages.NotifyCustomerMsg;
import com.baidu.android.imsdk.chatmessage.messages.NotifyReplyUpdateMsg;
import com.baidu.android.imsdk.chatmessage.messages.PassMsg;
import com.baidu.android.imsdk.chatmessage.messages.PassSaveMsg;
import com.baidu.android.imsdk.chatmessage.messages.QuickProductCardMsg;
import com.baidu.android.imsdk.chatmessage.messages.SignleGraphicTextMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.chatmessage.request.IMBindPushMsg;
import com.baidu.android.imsdk.chatmessage.request.IMDelMsg;
import com.baidu.android.imsdk.chatmessage.request.IMFetchConfigMsg;
import com.baidu.android.imsdk.chatmessage.request.IMFetchMsgByIdMsg;
import com.baidu.android.imsdk.chatmessage.request.IMGenBosObjectUrlRequest;
import com.baidu.android.imsdk.chatmessage.request.IMGetBottomMenuRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMarkMsgReadedMsg;
import com.baidu.android.imsdk.chatmessage.request.IMMediaDeleteMsgHttpRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMediaFetchMsgHttpRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMediaSendMsgHttpRequest;
import com.baidu.android.imsdk.chatmessage.request.IMNewFetchMsgRequest;
import com.baidu.android.imsdk.chatmessage.request.IMSendImNotifyMsg;
import com.baidu.android.imsdk.chatmessage.request.IMSendMsg;
import com.baidu.android.imsdk.chatmessage.request.IMSendMsgRequest;
import com.baidu.android.imsdk.chatmessage.request.IMShowSendMsgPVRequest;
import com.baidu.android.imsdk.chatmessage.request.IMSyncDialog;
import com.baidu.android.imsdk.chatmessage.request.IMSyncPushMsg;
import com.baidu.android.imsdk.chatmessage.request.IMUnBindPushMsg;
import com.baidu.android.imsdk.chatmessage.request.IMUploadBottomMenuEventRequest;
import com.baidu.android.imsdk.chatmessage.request.Type;
import com.baidu.android.imsdk.chatmessage.request.params.SendMsgParam;
import com.baidu.android.imsdk.chatmessage.response.SendMsgResponse;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecord;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecordDBManager;
import com.baidu.android.imsdk.chatmessage.sync.Generator;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.IGetUserIdentityListener;
import com.baidu.android.imsdk.chatuser.db.ChatUserDBManager;
import com.baidu.android.imsdk.consult.db.BusinessMessageDBManager;
import com.baidu.android.imsdk.consult.listener.IChatMsgChangedListener;
import com.baidu.android.imsdk.consult.listener.IChatMsgNotifyChangedListener;
import com.baidu.android.imsdk.consult.listener.ICustomizeNotifyListener;
import com.baidu.android.imsdk.consult.msg.IMFetchBusinessFilterSessionMsg;
import com.baidu.android.imsdk.consult.request.IMConsultGetDialogueIdRequest;
import com.baidu.android.imsdk.consult.request.IMFetchBusinessMsgRequest;
import com.baidu.android.imsdk.consult.request.IMSendChatMsgRequest;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.GroupInfoSyncManagerImpl;
import com.baidu.android.imsdk.group.GroupManagerImpl;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.group.db.GroupMessageDAOImpl;
import com.baidu.android.imsdk.group.request.IMQueryMemberPauidRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.Dispatcher;
import com.baidu.android.imsdk.internal.IMCmdQueueHelper;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageFactory;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.internal.NotifyMessageHandler;
import com.baidu.android.imsdk.mcast.IChatRoomMsgReceiveListener;
import com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener;
import com.baidu.android.imsdk.mcast.IRoomLiveMsgReceiveListener;
import com.baidu.android.imsdk.media.MediaSessionManager;
import com.baidu.android.imsdk.media.db.MediaMessageDBManager;
import com.baidu.android.imsdk.media.request.IMBCSessionDelMsg;
import com.baidu.android.imsdk.media.request.IMFetchBusinessSessionMsg;
import com.baidu.android.imsdk.media.request.IMMarkBCSessionReadedMsg;
import com.baidu.android.imsdk.notification.IFetchNotificationDataListener;
import com.baidu.android.imsdk.notification.NotificationMsgData;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.PaManager;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.request.AckHandlerThread;
import com.baidu.android.imsdk.request.AckMessage;
import com.baidu.android.imsdk.request.NewAckMessage;
import com.baidu.android.imsdk.shield.IShowingToastListener;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.ubc.CaseUbc;
import com.baidu.android.imsdk.ubc.MessageUbc;
import com.baidu.android.imsdk.ubc.ScreenUbc;
import com.baidu.android.imsdk.ubc.UBCConstants;
import com.baidu.android.imsdk.upload.AsyncChatTask;
import com.baidu.android.imsdk.upload.AsyncUploadTask;
import com.baidu.android.imsdk.upload.IUploadTransferListener;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.MsgUtility;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.immessagecenter.mention.FeedData;
import com.baidu.tieba.x80;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ChatMsgManagerImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ChatMsgManagerImpl";
    public static final int USER_IDENTITY_UPDATE_TIME = 600000;
    @SuppressLint({"StaticFieldLeak"})
    public static Context mContext;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile ChatMsgManagerImpl mInstance;
    public static String safeParam;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Integer, IChatMsgChangedListener> mConsultMsgNotifyListeners;
    public Map<Integer, ICustomizeNotifyListener> mCustomNotifyListeners;
    public Dispatcher.MsgListener mInitCustomerListener;
    public ArrayList<IMessageReceiveListener> mInternalReceiveListeners;
    public boolean mIsChatRoom;
    public AtomicBoolean mIsFetchRetry;
    public HashMap<Long, IChatRoomMsgReceiveListener> mLiveChatGroupMsgReceiveListeners;
    public HashMap<Long, IChatRoomMsgReceiveListener> mLiveChatMsgReceiveListeners;
    public Map<Integer, IMediaChatMsgChangedListener> mMediaMsgChangedListeners;
    public List<IMessageSyncListener> mMessageSyncListener;
    public ArrayList<IMessageReceiveListener> mReceiveListeners;
    public ILiveMsgReceiveListener mReceiveStudioListener;
    public HashMap<String, ILiveMsgReceiveListener> mReceiveStudioListeners;
    public final List<ILiveMsgReceiveListener> mStudioUsePaListeners;
    public Dispatcher.MsgListener mSwithcCustomerListener;
    public boolean mUseRequestSendMsg;
    public Dispatcher.MsgListener messageSyncListener;
    public IRoomLiveMsgReceiveListener msgReceiveListener;
    public Dispatcher.MsgListener notifyMessageListener;
    public Dispatcher.MsgListener notifyReplyMsgListener;
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

    private boolean hitMcastSendMsgErrorCode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65566, this, i)) == null) ? i == 22 || i == 1 || i == 24 || i == 1000 || i == 1203 || i == 1204 || i == 1207 || i == 1306 || i == 1316 || i == 1314 : invokeI.booleanValue;
    }

    private boolean needRetrySendMsgByHost(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65571, this, i)) == null) ? i == 1000 || i == 4001 || i == 1 || i == 1004 || i == -1 || i == 8010 || i == 8004 : invokeI.booleanValue;
    }

    private boolean noSaveDB(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65572, this, i, i2)) == null) ? i == 7 || i == 4 || i2 == 27 : invokeII.booleanValue;
    }

    /* renamed from: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl$24  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass24 implements ISendMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsgManagerImpl this$0;
        public final /* synthetic */ ChatMsg val$chatMsg;
        public final /* synthetic */ int val$code;
        public final /* synthetic */ String val$listenerKey;

        public AnonymousClass24(ChatMsgManagerImpl chatMsgManagerImpl, int i, ChatMsg chatMsg, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMsgManagerImpl, Integer.valueOf(i), chatMsg, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = chatMsgManagerImpl;
            this.val$code = i;
            this.val$chatMsg = chatMsg;
            this.val$listenerKey = str;
        }

        @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
        public void onSendMessageResult(int i, ChatMsg chatMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, chatMsg) == null) {
                if (i != 0) {
                    CaseUbc.DebugInfo debugInfo = new CaseUbc.DebugInfo();
                    debugInfo.curClassName = IMSendChatMsgRequest.TAG;
                    debugInfo.extInfo = "long connection code = " + this.val$code;
                    debugInfo.extInfo += ",send_msg_client code = " + i;
                    debugInfo.extInfo += ",chatmsg = " + this.val$chatMsg.toString();
                    CaseUbc.debugUbc(ChatMsgManagerImpl.mContext, "imcase_bcp_send_http", i, "", debugInfo);
                } else {
                    x80.c.postDelayed(new Runnable(this, chatMsg) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.24.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass24 this$1;
                        public final /* synthetic */ ChatMsg val$msg;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, chatMsg};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$msg = chatMsg;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$1.this$0.getChatMsgsByBCPByHostRequest(this.val$msg.getCategory(), this.val$msg.getContacter(), this.val$msg.getMsgId(), Long.MAX_VALUE, 20, "", new IMediaFetchChatMsgsListener(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.24.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 this$2;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$2 = this;
                                    }

                                    @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                                    public void onMediaFetchChatMsgsResult(int i2, String str, boolean z, List<ChatMsg> list) {
                                        String str2;
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z), list}) == null) {
                                            String str3 = ChatMsgManagerImpl.TAG;
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("onMediaFetchChatMsgsResult responseCode :");
                                            sb.append(i2);
                                            sb.append("， msg ：");
                                            if (list != null) {
                                                str2 = list.get(0).toString();
                                            } else {
                                                str2 = "";
                                            }
                                            sb.append(str2);
                                            LogUtils.d(str3, sb.toString());
                                            if (i2 == 0 && list != null && list.size() > 0) {
                                                Iterator it = this.this$2.this$1.this$0.mReceiveListeners.iterator();
                                                while (it.hasNext()) {
                                                    ((IMessageReceiveListener) it.next()).onReceiveMessage(i2, 1, new ArrayList<>(list));
                                                }
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }, 3000L);
                }
                if (AccountManager.getMediaRole(ChatMsgManagerImpl.mContext)) {
                    SendMsgResponse sendMsgResponse = new SendMsgResponse();
                    sendMsgResponse.msg = chatMsg;
                    sendMsgResponse.listenerKey = this.val$listenerKey;
                    MediaChatMessageManager.getInstance(ChatMsgManagerImpl.mContext).onSendMessageResult(i, "", sendMsgResponse);
                    return;
                }
                ChatMsgManagerImpl.getInstance(ChatMsgManagerImpl.mContext).onSendMessageResult(i, chatMsg, -1L, this.val$listenerKey);
            }
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
        this.mLiveChatMsgReceiveListeners = new HashMap<>();
        this.mLiveChatGroupMsgReceiveListeners = new HashMap<>();
        this.mIsChatRoom = false;
        this.mMediaMsgChangedListeners = new ConcurrentHashMap();
        this.mCustomNotifyListeners = new ConcurrentHashMap();
        this.mConsultMsgNotifyListeners = new ConcurrentHashMap();
        this.mUseRequestSendMsg = false;
        this.mIsFetchRetry = new AtomicBoolean(true);
        this.onReceiveListener = new Dispatcher.MsgListener(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatMsgManagerImpl this$0;

            @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
            public void dealMessage(int i3, ChatMsg chatMsg) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, chatMsg) == null) {
                }
            }

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

            @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
            public void dealMessage(int i3, ArrayList<ChatMsg> arrayList) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, arrayList) == null) {
                }
            }

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
                long fromUser;
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
                    if (chatMsgByMsgId.getFromUser() == AccountManager.getUK(ChatMsgManagerImpl.mContext)) {
                        fromUser = chatMsgByMsgId.getContacter();
                    } else {
                        fromUser = chatMsgByMsgId.getFromUser();
                    }
                    if (changedStatus == 0) {
                        msgRead = ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).deleteMsgBatch(this.this$0.getChatObject(category, fromUser), new long[]{changedMsgid});
                        if (msgRead > 0 && this.this$0.mMessageSyncListener != null && this.this$0.mMessageSyncListener.size() != 0) {
                            for (IMessageSyncListener iMessageSyncListener : this.this$0.mMessageSyncListener) {
                                if (iMessageSyncListener != null) {
                                    iMessageSyncListener.onMsgDel(changedMsgid);
                                }
                            }
                        }
                    } else {
                        msgRead = ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).setMsgRead(this.this$0.getChatObject(category, fromUser), changedMsgid);
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
        };
        this.notifyMessageListener = new Dispatcher.MsgListener(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatMsgManagerImpl this$0;

            @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
            public void dealMessage(int i3, ArrayList<ChatMsg> arrayList) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, arrayList) == null) {
                }
            }

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
                if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, chatMsg) == null) && (chatMsg instanceof MessageClueUpateMsg)) {
                    MessageClueUpateMsg messageClueUpateMsg = (MessageClueUpateMsg) chatMsg;
                    TaskManager.getInstance(ChatMsgManagerImpl.mContext).submitForNetWork(new Runnable(this, messageClueUpateMsg.getChangedMsgCategory(), messageClueUpateMsg.getChangedMsgid()) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.5.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass5 this$1;
                        public final /* synthetic */ long val$beginId;
                        public final /* synthetic */ int val$needCategory;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr2 = {this, Integer.valueOf(r7), Long.valueOf(r8)};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i4 = newInitContext2.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$needCategory = r7;
                            this.val$beginId = r8;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                Context context = ChatMsgManagerImpl.mContext;
                                int i4 = this.val$needCategory;
                                long j = this.val$beginId;
                                ChatMsgManager.fetchMsgidByMsgid(context, i4, -1L, j, j, 1, 1, null);
                            }
                        }
                    });
                }
            }
        };
        this.notifyReplyMsgListener = new Dispatcher.MsgListener(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatMsgManagerImpl this$0;

            @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
            public void dealMessage(int i3, ArrayList<ChatMsg> arrayList) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, arrayList) == null) {
                }
            }

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
                if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, chatMsg) == null) && (chatMsg instanceof NotifyReplyUpdateMsg)) {
                    NotifyReplyUpdateMsg notifyReplyUpdateMsg = (NotifyReplyUpdateMsg) chatMsg;
                    ChatMsg updateReplyChatMsgQuoteData = this.this$0.updateReplyChatMsgQuoteData(notifyReplyUpdateMsg.getMsgId(), notifyReplyUpdateMsg.getStatus(), notifyReplyUpdateMsg.getMsgRepliedStatusDisplayText());
                    if (updateReplyChatMsgQuoteData != null) {
                        this.this$0.sendMsgUpdatedBroadcast(ChatMsgManagerImpl.mContext, updateReplyChatMsgQuoteData);
                    }
                }
            }
        };
        this.mInitCustomerListener = new Dispatcher.MsgListener(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatMsgManagerImpl this$0;

            @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
            public void dealMessage(int i3, ArrayList<ChatMsg> arrayList) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, arrayList) == null) {
                }
            }

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
        };
        this.mSwithcCustomerListener = new Dispatcher.MsgListener(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatMsgManagerImpl this$0;

            @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
            public void dealMessage(int i3, ArrayList<ChatMsg> arrayList) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, arrayList) == null) {
                }
            }

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
        };
        this.msgReceiveListener = new IRoomLiveMsgReceiveListener(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatMsgManagerImpl this$0;

            @Override // com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener
            public void onReceiveMessage(int i3, JSONArray jSONArray) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, jSONArray) == null) {
                }
            }

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

            /* JADX WARN: Type inference failed for: r6v7, types: [T, java.lang.Long] */
            @Override // com.baidu.android.imsdk.mcast.IRoomLiveMsgReceiveListener
            public void onReceiveMessage(String str, int i3, JSONArray jSONArray) {
                long j;
                ChatMsgManagerImpl chatMsgManagerImpl;
                boolean z2;
                int i4;
                ArrayList<ChatMsg> arrayList;
                long optLong;
                ArrayList<ChatMsg> parseChatRoomMsg;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i3, jSONArray) == null) {
                    String str2 = ChatMsgManagerImpl.TAG;
                    LogUtils.e(str2, "IRoomLiveMsgReceiveListener id :" + str + ", arr :" + jSONArray.toString());
                    long j2 = 0;
                    try {
                        j = Long.parseLong(str);
                    } catch (Error unused) {
                        String str3 = ChatMsgManagerImpl.TAG;
                        LogUtils.e(str3, "parseLong exception :" + str);
                        j = 0L;
                    }
                    ArrayList<ChatMsg> arrayList2 = new ArrayList<>();
                    try {
                        try {
                            JSONObject jSONObject = (JSONObject) jSONArray.opt(0);
                            String str4 = ChatMsgManagerImpl.TAG;
                            LogUtils.w(str4, "chatRoomListener :" + jSONObject.toString());
                            optLong = jSONObject.optLong("contacter", 0L);
                        } catch (Exception e) {
                            e = e;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        Type type = new Type();
                        type.t = 0L;
                        parseChatRoomMsg = MessageParser.parseChatRoomMsg(ChatMsgManagerImpl.mContext, MessageParser.parserMessage(ChatMsgManagerImpl.mContext, jSONArray, type, true, false));
                    } catch (Exception e2) {
                        e = e2;
                        j2 = optLong;
                        LogUtils.e(ChatMsgManagerImpl.TAG, "onReceiveMessage ", e);
                        if (j2 == j) {
                            String str5 = ChatMsgManagerImpl.TAG;
                            LogUtils.d(str5, "mcast notify :" + j2 + ", msgs.size :" + arrayList2.size());
                            this.this$0.notifyLiveChatMsg(1026, j2, arrayList2, false);
                            return;
                        }
                        String str6 = ChatMsgManagerImpl.TAG;
                        LogUtils.d(str6, "roomType notify :" + j + ", msgs.size :" + arrayList2.size());
                        chatMsgManagerImpl = this.this$0;
                        z2 = true;
                        i4 = 1026;
                        arrayList = arrayList2;
                        chatMsgManagerImpl.notifyLiveChatMsg(i4, j, arrayList, z2);
                    } catch (Throwable th2) {
                        th = th2;
                        j2 = optLong;
                        if (j2 == j) {
                            String str7 = ChatMsgManagerImpl.TAG;
                            LogUtils.d(str7, "mcast notify :" + j2 + ", msgs.size :" + arrayList2.size());
                            this.this$0.notifyLiveChatMsg(i3, j2, arrayList2, false);
                        } else {
                            String str8 = ChatMsgManagerImpl.TAG;
                            LogUtils.d(str8, "roomType notify :" + j + ", msgs.size :" + arrayList2.size());
                            this.this$0.notifyLiveChatMsg(i3, j, arrayList2, true);
                        }
                        throw th;
                    }
                    if (optLong == j) {
                        String str9 = ChatMsgManagerImpl.TAG;
                        LogUtils.d(str9, "mcast notify :" + optLong + ", msgs.size :" + parseChatRoomMsg.size());
                        this.this$0.notifyLiveChatMsg(0, optLong, parseChatRoomMsg, false);
                        return;
                    }
                    String str10 = ChatMsgManagerImpl.TAG;
                    LogUtils.d(str10, "roomType notify :" + j + ", msgs.size :" + parseChatRoomMsg.size());
                    chatMsgManagerImpl = this.this$0;
                    z2 = true;
                    i4 = 0;
                    arrayList = parseChatRoomMsg;
                    chatMsgManagerImpl.notifyLiveChatMsg(i4, j, arrayList, z2);
                }
            }
        };
        addMessageTypes();
        registerListeners();
    }

    public void configMsgsFilter(ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            ArrayList<Long> cachedConfigMsgIds = getInstance(mContext).getCachedConfigMsgIds();
            int size = cachedConfigMsgIds.size();
            LogUtils.d(TAG, "configMsgsFilter oldCachedIdsSize=" + size);
            if (size > 0 && !arrayList.isEmpty()) {
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
    }

    public void deliverStudioUsePaMessage(ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
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
                    TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, arrayList) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.30
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

    public int saveGroupMessage(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048680, this, chatMsg)) == null) {
            chatMsg.setMsgId(Math.max(GroupMessageDAOImpl.getMaxLocalMsgId(mContext, String.valueOf(chatMsg.getContacter())), GroupMessageDAOImpl.getMaxMsgid(mContext, String.valueOf(chatMsg.getContacter()))) + 1);
            chatMsg.setIsClicked(true);
            chatMsg.setMsgReaded(1);
            chatMsg.setDeviceFlag(1);
            long rowId = chatMsg.getRowId();
            if (rowId == -1) {
                if (TextUtils.isEmpty(chatMsg.getMsgKey())) {
                    chatMsg.createMsgKey(mContext);
                }
                rowId = ChatMessageDBManager.getInstance(mContext).addMsg(chatMsg, true);
            } else {
                GroupMessageDAOImpl.updateMsgStatus(mContext, chatMsg);
            }
            if (rowId >= 0) {
                chatMsg.setRowId(rowId);
                String str = "" + chatMsg.getRowId();
                String msgUUid = MsgUtility.getMsgUUid(chatMsg);
                String chatObject = getChatObject(chatMsg.getCategory(), chatMsg.getContacter()).toString();
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

    public long deleteAllMsgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return ChatMessageDBManager.getInstance(mContext).delAllMsgAndSession();
        }
        return invokeV.longValue;
    }

    public int getNewMsgCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return ChatMessageDBManager.getInstance(mContext).getAllNewMsgCount();
        }
        return invokeV.intValue;
    }

    public String getSendMsgSafeParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return safeParam;
        }
        return (String) invokeV.objValue;
    }

    public boolean registerNotify(String str, String str2, String str3, IOnRegisterNotifyListener iOnRegisterNotifyListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048673, this, str, str2, str3, iOnRegisterNotifyListener)) == null) {
            return BindStateManager.startBindPush(mContext, str, str2, str3, iOnRegisterNotifyListener);
        }
        return invokeLLLL.booleanValue;
    }

    private void deliverMcastMessage(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, jSONArray) == null) {
            LogUtils.d(TAG, "old deliverMcastMessage deliver");
            onDeliverMcastResponse("", jSONArray, this.mReceiveStudioListener, null);
        }
    }

    public void deliverFetchedConfigMessage(ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, arrayList) == null) {
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, arrayList) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.18
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

    public void delverFetchedRetrieveMessage(ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, arrayList) == null) {
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, arrayList) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.19
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

    public long getMaxReliableMsgId(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048623, this, j)) == null) {
            return ChatMessageDBManager.getInstance(mContext).getMaxReliableMsgId(j);
        }
        return invokeJ.longValue;
    }

    public ChatMsg getMsgByMsgId(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048624, this, j)) == null) {
            return ChatMessageDBManager.getInstance(mContext).getMsgByMsgId(j);
        }
        return (ChatMsg) invokeJ.objValue;
    }

    public void handleMediaNotifyMessage(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, jSONObject) == null) {
            doMediaNoify(jSONObject);
            MediaSessionManager.getInstance(mContext).handleMediaNotify(jSONObject);
        }
    }

    public void mediaRegisterChatMsgChangedListener(IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048645, this, iMediaChatMsgChangedListener) == null) && iMediaChatMsgChangedListener != null) {
            this.mMediaMsgChangedListeners.put(Integer.valueOf(iMediaChatMsgChangedListener.hashCode()), iMediaChatMsgChangedListener);
        }
    }

    public void mediaUnRegisterChatMsgChangedListener(IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048648, this, iMediaChatMsgChangedListener) == null) && iMediaChatMsgChangedListener != null) {
            this.mMediaMsgChangedListeners.remove(Integer.valueOf(iMediaChatMsgChangedListener.hashCode()));
        }
    }

    public void registerConsultMsgNotifyListener(IChatMsgChangedListener iChatMsgChangedListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048665, this, iChatMsgChangedListener) == null) && iChatMsgChangedListener != null) {
            this.mConsultMsgNotifyListeners.put(Integer.valueOf(iChatMsgChangedListener.hashCode()), iChatMsgChangedListener);
        }
    }

    public void registerCustomNotifyListener(ICustomizeNotifyListener iCustomizeNotifyListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048667, this, iCustomizeNotifyListener) == null) && iCustomizeNotifyListener != null) {
            this.mCustomNotifyListeners.put(Integer.valueOf(iCustomizeNotifyListener.hashCode()), iCustomizeNotifyListener);
        }
    }

    public void registerLiveMsgReceiveListener(ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, iLiveMsgReceiveListener) == null) {
            String str = TAG;
            LogUtils.d(str, "registerLiveMsgReceiveListener : " + iLiveMsgReceiveListener);
            if (iLiveMsgReceiveListener != null) {
                this.mReceiveStudioListener = iLiveMsgReceiveListener;
            }
        }
    }

    public int saveAdvisoryDraftMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048677, this, chatMsg)) == null) {
            return BusinessMessageDBManager.getInstance(mContext).saveDraft(chatMsg.getBusinessType(), chatMsg);
        }
        return invokeL.intValue;
    }

    public void setSendMsgSafeParam(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048703, this, str) == null) {
            safeParam = str;
        }
    }

    public void unRegisterConsultMsgNotifyListener(IChatMsgChangedListener iChatMsgChangedListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048707, this, iChatMsgChangedListener) == null) && iChatMsgChangedListener != null) {
            this.mConsultMsgNotifyListeners.remove(Integer.valueOf(iChatMsgChangedListener.hashCode()));
        }
    }

    public void unRegisterCustomNotifyListener(ICustomizeNotifyListener iCustomizeNotifyListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048709, this, iCustomizeNotifyListener) == null) && iCustomizeNotifyListener != null) {
            this.mCustomNotifyListeners.remove(Integer.valueOf(iCustomizeNotifyListener.hashCode()));
        }
    }

    public void unregisterLiveMsgReceiveListener(ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, iLiveMsgReceiveListener) == null) {
            String str = TAG;
            LogUtils.d(str, "unregisterLiveMsgReceiveListener : " + iLiveMsgReceiveListener);
            this.mReceiveStudioListener = null;
        }
    }

    public void unregisterStudioUsePaReceivePaMsg(ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, iLiveMsgReceiveListener) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048718, this, chatSession)) == null) {
            return ChatMessageDBManager.getInstance(mContext).updateChatSessionName(chatSession);
        }
        return invokeL.intValue;
    }

    private void getConsultDialogueIdRequest(int i, String str, BIMValueCallBack<Long> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65563, this, i, str, bIMValueCallBack) == null) {
            if (AccountManager.isLogin(mContext)) {
                IMConsultGetDialogueIdRequest iMConsultGetDialogueIdRequest = new IMConsultGetDialogueIdRequest(mContext, i, str, bIMValueCallBack);
                HttpHelper.executor(mContext, iMConsultGetDialogueIdRequest, iMConsultGetDialogueIdRequest);
            } else if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        }
    }

    public void deliverReliableMcastMessage(String str, JSONArray jSONArray, List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, str, jSONArray, list) == null) {
            onDeliverMcastResponse(str, jSONArray, this.mReceiveStudioListeners.get(str), list);
            deliverMcastMessage(jSONArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realSendChatMsgByHostRequest(ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65576, this, chatMsg, iSendMessageListener) == null) {
            IMSendChatMsgRequest iMSendChatMsgRequest = new IMSendChatMsgRequest(mContext, chatMsg, iSendMessageListener);
            HttpHelper.executor(mContext, iMSendChatMsgRequest, iMSendChatMsgRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNoticeBroadcast(Context context, ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65581, this, context, chatMsg) == null) {
            Intent intent = new Intent(IMConstants.CUSTOMER_CHANGE);
            intent.setPackage(context.getApplicationContext().getPackageName());
            intent.putExtra(IMConstants.MESSAGE, chatMsg);
            context.sendBroadcast(intent);
        }
    }

    public void broadDeleteGroupMsg(Context context, ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, arrayList) == null) {
            sendMessageBroadcast(context, arrayList);
        }
    }

    public void broadDeleteMsg(Context context, ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, chatMsg) == null) {
            sendMessageBroadcast(context, chatMsg);
        }
    }

    public int deleteAdvisoryDraft(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return BusinessMessageDBManager.getInstance(mContext).deleteDraft(i, j);
        }
        return invokeCommon.intValue;
    }

    public void getBusiAdvCustomMsgByMsgId(long j, IAdvisoryCustomMsgGetListener iAdvisoryCustomMsgGetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048614, this, j, iAdvisoryCustomMsgGetListener) == null) {
            ChatAdvCustomMsg busiAdvCustomMsgByMsgId = BusinessMessageDBManager.getInstance(mContext).getBusiAdvCustomMsgByMsgId(j);
            if (iAdvisoryCustomMsgGetListener != null) {
                iAdvisoryCustomMsgGetListener.getBusiAdvCustomMsgByMsg(busiAdvCustomMsgByMsgId);
            }
        }
    }

    public void getBusinessAdvAdShowInfoByUK(String str, IAdvisoryAdBtnShowGetListener iAdvisoryAdBtnShowGetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, str, iAdvisoryAdBtnShowGetListener) == null) {
            AdvAdBtnShowInfo businessAdvAdShowInfoByUK = BusinessMessageDBManager.getInstance(mContext).getBusinessAdvAdShowInfoByUK(str);
            if (iAdvisoryAdBtnShowGetListener != null) {
                iAdvisoryAdBtnShowGetListener.onGetAdBtnInfo(businessAdvAdShowInfoByUK);
            }
        }
    }

    public ChatObject getChatObject(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048620, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return new ChatObject(mContext, i, j);
        }
        return (ChatObject) invokeCommon.objValue;
    }

    public ChatMsg getDraftMsg(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return ChatMessageDBManager.getInstance(mContext).getDraftMsg(i, j);
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    public List<ChatMsg> getPaMsgByChatType(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048630, this, i, i2)) == null) {
            if (AccountManager.isLogin(mContext)) {
                return ChatMessageDBManager.getInstance(mContext).fetchPaMsgByChatType(i, i2);
            }
            return null;
        }
        return (List) invokeII.objValue;
    }

    public void getToastShowing(String str, IShowingToastListener iShowingToastListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048635, this, str, iShowingToastListener) == null) {
            boolean isToastShowing = ChatMessageDBManager.getInstance(mContext).isToastShowing(str);
            if (iShowingToastListener != null) {
                iShowingToastListener.onResult(isToastShowing);
            }
        }
    }

    public void handleCustomNotifyMessage(int i, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048638, this, i, jSONObject) == null) {
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, jSONObject, i) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.32
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatMsgManagerImpl this$0;
                public final /* synthetic */ int val$method;
                public final /* synthetic */ JSONObject val$notifyMsg;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, jSONObject, Integer.valueOf(i)};
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
                    this.val$notifyMsg = jSONObject;
                    this.val$method = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    synchronized (this.this$0.mCustomNotifyListeners) {
                        int optInt = this.val$notifyMsg.optInt("im_notify_type");
                        long optLong = this.val$notifyMsg.optLong("contacter_uk");
                        long optLong2 = this.val$notifyMsg.optLong("msgid");
                        String optString = this.val$notifyMsg.optString(Constants.EXTRA_BUSINESS_MSG_EXT);
                        String optString2 = this.val$notifyMsg.optString("business_ext");
                        int optInt2 = this.val$notifyMsg.optInt("business_type");
                        int optInt3 = this.val$notifyMsg.optInt("session_type");
                        int optInt4 = this.val$notifyMsg.optInt("category");
                        boolean isShieldSession = BIMManager.isShieldSession(optInt4, optInt2);
                        String str = ChatMsgManagerImpl.TAG;
                        LogUtils.d(str, "236 238 通知拉取，category:" + optInt4 + ", businessType:" + optInt2 + ", 屏蔽状态：" + isShieldSession);
                        if (!isShieldSession && !this.this$0.interceptBusiNotify(this.val$method, optInt, optInt2, optInt3, optLong, optLong2, optString, optString2, this.val$notifyMsg, optInt4) && this.val$notifyMsg != null && this.this$0.mCustomNotifyListeners != null && !this.this$0.mCustomNotifyListeners.isEmpty()) {
                            for (Integer num : this.this$0.mCustomNotifyListeners.keySet()) {
                                ((ICustomizeNotifyListener) this.this$0.mCustomNotifyListeners.get(Integer.valueOf(num.intValue()))).onReceiveNotify(this.val$method, optInt, optInt2, optInt3, optLong, optLong2, optString, optString2);
                            }
                        }
                    }
                }
            });
        }
    }

    public void registerMessageSyncListener(Context context, IMessageSyncListener iMessageSyncListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048672, this, context, iMessageSyncListener) == null) && iMessageSyncListener != null && !this.mMessageSyncListener.contains(iMessageSyncListener)) {
            this.mMessageSyncListener.add(iMessageSyncListener);
        }
    }

    public void replaceBusinessAdvCustomMsg(ChatAdvCustomMsg chatAdvCustomMsg, IAdvisoryCustomMsgSaveListener iAdvisoryCustomMsgSaveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048675, this, chatAdvCustomMsg, iAdvisoryCustomMsgSaveListener) == null) {
            long replaceBusinessAdvCustomMsg = BusinessMessageDBManager.getInstance(mContext).replaceBusinessAdvCustomMsg(chatAdvCustomMsg);
            if (iAdvisoryCustomMsgSaveListener != null) {
                iAdvisoryCustomMsgSaveListener.saveBusinessAdvCustomMsg(replaceBusinessAdvCustomMsg);
            }
        }
    }

    public void saveBusinessAdvAdShowInfo(AdvAdBtnShowInfo advAdBtnShowInfo, IAdvisoryAdBtnShowSaveListener iAdvisoryAdBtnShowSaveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048679, this, advAdBtnShowInfo, iAdvisoryAdBtnShowSaveListener) == null) {
            long saveBusinessAdvAdShowInfo = BusinessMessageDBManager.getInstance(mContext).saveBusinessAdvAdShowInfo(advAdBtnShowInfo);
            if (iAdvisoryAdBtnShowSaveListener != null) {
                iAdvisoryAdBtnShowSaveListener.saveBusinessAdvAdBtnShow(saveBusinessAdvAdShowInfo);
            }
        }
    }

    public void sendMsgUpdatedBroadcast(Context context, ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048692, this, context, chatMsg) == null) {
            Intent intent = new Intent(IMConstants.ACTION_MESSAGE_CHANGE);
            intent.setPackage(context.getApplicationContext().getPackageName());
            intent.putExtra(IMConstants.MESSAGE, chatMsg);
            context.sendBroadcast(intent);
        }
    }

    public void unregisterChatRoomGroupMsgReceiveListener(long j, IChatRoomMsgReceiveListener iChatRoomMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048711, this, j, iChatRoomMsgReceiveListener) == null) {
            this.mIsChatRoom = false;
            if (iChatRoomMsgReceiveListener != null) {
                this.mLiveChatGroupMsgReceiveListeners.remove(Long.valueOf(j));
            }
        }
    }

    public void unregisterChatRoomMsgReceiveListener(long j, IChatRoomMsgReceiveListener iChatRoomMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048712, this, j, iChatRoomMsgReceiveListener) == null) {
            this.mIsChatRoom = false;
            if (iChatRoomMsgReceiveListener != null) {
                this.mLiveChatMsgReceiveListeners.remove(Long.valueOf(j));
            }
        }
    }

    public void unregisterMessageSyncListener(Context context, IMessageSyncListener iMessageSyncListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048716, this, context, iMessageSyncListener) == null) && iMessageSyncListener != null && this.mMessageSyncListener.contains(iMessageSyncListener)) {
            this.mMessageSyncListener.remove(iMessageSyncListener);
        }
    }

    public long updateLocalChatMsgByBusiness(int i, List<ChatMsg> list) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048719, this, i, list)) == null) {
            return BusinessMessageDBManager.getInstance(mContext).insertBusinessChatMsg(i, list);
        }
        return invokeIL.longValue;
    }

    private void addMessageTypes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            MessageFactory.getInstance().addType(57, IMDelMsg.class);
            MessageFactory.getInstance().addType(67, IMMarkMsgReadedMsg.class);
            MessageFactory.getInstance().addType(55, IMSendMsg.class);
            MessageFactory.getInstance().addType(93, IMFetchMsgByIdMsg.class);
            MessageFactory.getInstance().addType(94, IMSyncDialog.class);
            MessageFactory.getInstance().addType(90, IMBindPushMsg.class);
            MessageFactory.getInstance().addType(190, IMSyncPushMsg.class);
            MessageFactory.getInstance().addType(92, IMUnBindPushMsg.class);
            MessageFactory.getInstance().addType(193, IMFetchConfigMsg.class);
            MessageFactory.getInstance().addType(Constants.METHOD_IM_CONSULT_IM_UPDATE_MSG, IMSendImNotifyMsg.class);
            MessageFactory.getInstance().addType(206, IMFetchBusinessSessionMsg.class);
            MessageFactory.getInstance().addType(Constants.METHOD_IM_DEL_BUSINESS_SESSION_MSG, IMBCSessionDelMsg.class);
            MessageFactory.getInstance().addType(207, IMMarkBCSessionReadedMsg.class);
            MessageFactory.getInstance().addType(Constants.METHOD_IM_CONSULT_IM_FILTER_SESSION_MSG, IMFetchBusinessFilterSessionMsg.class);
        }
    }

    private void registerListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
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
            Dispatcher.Event event5 = new Dispatcher.Event();
            event5.setCategory(2);
            event5.setType(24);
            Dispatcher.registerListener(event5, this.notifyMessageListener);
            Dispatcher.Event event6 = new Dispatcher.Event();
            event6.setCategory(2);
            event6.setType(26);
            Dispatcher.registerListener(event6, this.notifyReplyMsgListener);
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
                        boolean isShieldSession = BIMManager.isShieldSession(9, 27);
                        String str = ChatMsgManagerImpl.TAG;
                        LogUtils.d(str, "是否屏蔽问一问会话：" + isShieldSession);
                        if (!isShieldSession) {
                            ChatSessionManagerImpl.getInstance(ChatMsgManagerImpl.mContext).fetchBusinessSessionForLogin(5);
                            ChatSessionManagerImpl.getInstance(ChatMsgManagerImpl.mContext).deleteExpiredBusinessSession();
                        }
                        TaskManager.getInstance(ChatMsgManagerImpl.mContext).submitForNetWork(new Runnable(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.1.2
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
                                    LogUtils.w(ChatMsgManagerImpl.TAG, "begin  getAckCmdQueueMsgs");
                                    List<NewAckMessage> ackCmdQueueMsgs = IMCmdQueueHelper.getAckCmdQueueMsgs(ChatMsgManagerImpl.mContext);
                                    if (ackCmdQueueMsgs != null && ackCmdQueueMsgs.size() > 0) {
                                        String str2 = ChatMsgManagerImpl.TAG;
                                        LogUtils.d(str2, "Login, ack.size :" + ackCmdQueueMsgs.size());
                                        for (NewAckMessage newAckMessage : ackCmdQueueMsgs) {
                                            if (newAckMessage.getJsonArray() == null || newAckMessage.getJsonArray().length() <= 0) {
                                                String str3 = ChatMsgManagerImpl.TAG;
                                                LogUtils.w(str3, "JsonArray null, and delete uuid :" + newAckMessage.getUUID());
                                                DBManager.getInstance(ChatMsgManagerImpl.mContext).deleteCmdMsg(newAckMessage.getUUID());
                                                return;
                                            }
                                            AckHandlerThread.getInstance(ChatMsgManagerImpl.mContext).getAckHandler().sendMessageDelayed(AckMessage.getSendMessage(1, newAckMessage), 1000L);
                                        }
                                    }
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

    private ChatMsg buildChatMsg(int i, int i2, long j, int i3, String str) {
        InterceptResult invokeCommon;
        ChatMsg textMsg;
        String uid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), str})) == null) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 27) {
                        if (i3 != 28) {
                            textMsg = null;
                        } else {
                            textMsg = new PassSaveMsg();
                        }
                    } else {
                        textMsg = new PassMsg();
                    }
                } else {
                    textMsg = new ImageMsg();
                }
            } else {
                textMsg = new TextMsg();
            }
            if (textMsg != null) {
                textMsg.setMsgContent(str);
                textMsg.setContacter(j);
                textMsg.setFromUser(AccountManager.getUK(mContext));
                textMsg.setStatus(1);
                textMsg.setPaid(j);
                if (TextUtils.isEmpty(AccountManager.getUid(mContext))) {
                    uid = "0";
                } else {
                    uid = AccountManager.getUid(mContext);
                }
                textMsg.setSenderUid(uid);
                textMsg.setCategory(i2);
                textMsg.setChatType(i);
                textMsg.setMsgTime(System.currentTimeMillis() / 1000);
            }
            return textMsg;
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    public void forwardMessage(long j, long j2, int i, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        int i2;
        GroupInfo groupInfo;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), chatMsg, iSendMessageListener}) == null) {
            if (i == 0) {
                if (j2 > 0) {
                    PaInfo paInfo = PaManager.getPaInfo(mContext, j2);
                    if (paInfo != null) {
                        i3 = paInfo.getSubtype();
                    } else {
                        i3 = 7;
                    }
                    sendMessage(getForwardChatMsg(chatMsg, i, i3, j2, j), iSendMessageListener);
                } else if (j > 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.valueOf(j));
                    GroupManagerImpl.getInstance(mContext).getPaidAndUkByBduid(arrayList, new BIMValueCallBack<List<IMQueryMemberPauidRequest.UserId>>(this, chatMsg, i, iSendMessageListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.38
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ChatMsgManagerImpl this$0;
                        public final /* synthetic */ int val$category;
                        public final /* synthetic */ ISendMessageListener val$listener;
                        public final /* synthetic */ ChatMsg val$msg;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, chatMsg, Integer.valueOf(i), iSendMessageListener};
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
                            this.val$msg = chatMsg;
                            this.val$category = i;
                            this.val$listener = iSendMessageListener;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                        public void onResult(int i4, String str, List<IMQueryMemberPauidRequest.UserId> list) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str, list) == null) {
                                if (i4 == 0 && list != null && list.size() > 0) {
                                    IMQueryMemberPauidRequest.UserId userId = list.get(0);
                                    this.this$0.sendMessage(userId.getPauid() > 0 ? this.this$0.getForwardChatMsg(this.val$msg, this.val$category, 7, userId.getPauid(), userId.getBduid()) : this.this$0.getForwardChatMsg(this.val$msg, this.val$category, 0, userId.getUk(), userId.getBduid()), this.val$listener);
                                    return;
                                }
                                ISendMessageListener iSendMessageListener2 = this.val$listener;
                                if (iSendMessageListener2 != null) {
                                    iSendMessageListener2.onSendMessageResult(i4, this.val$msg);
                                }
                            }
                        }
                    });
                }
            } else if (i == 1) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(String.valueOf(j));
                ArrayList<GroupInfo> groupInfo2 = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList2);
                if (groupInfo2 != null && groupInfo2.size() > 0 && (groupInfo = groupInfo2.get(0)) != null && groupInfo.getType() == 3) {
                    i2 = 57;
                } else {
                    i2 = 3;
                }
                sendMessage(getForwardChatMsg(chatMsg, i, i2, j, 0L), iSendMessageListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackNotificationMsgData(ArrayList<ChatMsg> arrayList, int i, IFetchNotificationDataListener iFetchNotificationDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65557, this, arrayList, i, iFetchNotificationDataListener) == null) {
            ArrayList arrayList2 = new ArrayList();
            boolean z = false;
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
                    ChatUserManagerImpl.getInstance(mContext).updateUserIdentity(arrayList4, new IGetUserIdentityListener(this, arrayList3, arrayList2, iFetchNotificationDataListener, i) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.14
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
                            boolean z2;
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
                                if (arrayList5.size() >= this.val$count) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                iFetchNotificationDataListener2.onFetchResult(arrayList5, z2);
                            }
                        }
                    });
                    return;
                }
                if (arrayList2.size() >= i) {
                    z = true;
                }
                iFetchNotificationDataListener.onFetchResult(arrayList2, z);
                return;
            }
            iFetchNotificationDataListener.onFetchResult(arrayList2, false);
        }
    }

    private void configMsgIdsPersiser(ArrayList<Long> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65558, this, arrayList) != null) || arrayList == null) {
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

    private void doMediaNoify(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, jSONObject) == null) {
            try {
                if (AccountManager.getMediaRole(mContext) && jSONObject != null && this.mMediaMsgChangedListeners != null && !this.mMediaMsgChangedListeners.isEmpty()) {
                    String str = TAG;
                    LogUtils.i(str, "BC> handleMediaNotifyMessage msgobj=" + jSONObject.toString());
                    TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, jSONObject) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.21
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
                }
            } catch (Exception unused) {
            }
        }
    }

    private ArrayList<ChatMsg> filtMsgs(ArrayList<ChatMsg> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, this, arrayList)) == null) {
            if (arrayList == null) {
                return null;
            }
            ArrayList<ChatMsg> arrayList2 = new ArrayList<>();
            Iterator<ChatMsg> it = arrayList.iterator();
            while (it.hasNext()) {
                ChatMsg next = it.next();
                if (next.isSameDevice()) {
                    String str = TAG;
                    LogUtils.d(str, "msg is same device." + next.getMsgId());
                } else {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public int deleteMsgs(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, chatMsg)) == null) {
            if (chatMsg.getStatus() != 0) {
                if (ChatMessageDBManager.getInstance(mContext).deleteChatMsg(chatMsg) >= 0) {
                    return 0;
                }
                return -1009;
            }
            deleteMsgs(chatMsg.getCategory(), chatMsg.getContacter(), new long[]{chatMsg.getMsgId()}, chatMsg.isZhida());
            return 0;
        }
        return invokeL.intValue;
    }

    public int saveAsDraftMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048678, this, chatMsg)) == null) {
            if (chatMsg == null) {
                return -1;
            }
            deleteDraftMsg(chatMsg.getCategory(), chatMsg.getContacter());
            if (DraftManager.isDraftMsgInvalid(chatMsg)) {
                return -1;
            }
            chatMsg.setMsgId(IMConstants.DRAFT_MSGID);
            chatMsg.setStatus(3);
            chatMsg.setMsgReaded(1);
            if (ChatMessageDBManager.getInstance(mContext).addMsg(chatMsg, true) < 0) {
                return -1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deliverRetrieveMessage(ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, arrayList) == null) {
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

    public static ChatMsgManagerImpl getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
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

    public void deliverConfigMessage(ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, arrayList) == null) {
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

    public int getUnreadMsgCountForSingle(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048636, this, j)) == null) {
            if (AccountManager.getMediaRole(mContext)) {
                return MediaMessageDBManager.getInstance(mContext).getChatRecordUnReadNum(getChatObject(0, j));
            }
            return ChatMessageDBManager.getInstance(mContext).getChatRecordUnReadNum(getChatObject(0, j));
        }
        return invokeJ.intValue;
    }

    public void persisConfigMsgIds(ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048662, this, arrayList) == null) && arrayList != null && !arrayList.isEmpty()) {
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

    public void registerInternalMessageReceiveListener(IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, iMessageReceiveListener) == null) {
            String str = TAG;
            LogUtils.e(str, "retrieve-->registerInternalMessageReceiveListener : " + iMessageReceiveListener);
            if (iMessageReceiveListener != null && !this.mInternalReceiveListeners.contains(iMessageReceiveListener)) {
                this.mInternalReceiveListeners.add(iMessageReceiveListener);
            }
        }
    }

    public void registerMessageReceiveListener(IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, iMessageReceiveListener) == null) {
            String str = TAG;
            LogUtils.e(str, "registerMessageReceiveListener : " + iMessageReceiveListener);
            if (iMessageReceiveListener != null && !this.mReceiveListeners.contains(iMessageReceiveListener)) {
                this.mReceiveListeners.add(iMessageReceiveListener);
            }
        }
    }

    public void registerStudioUsePaReceivePaMsg(ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, iLiveMsgReceiveListener) == null) {
            synchronized (this.mStudioUsePaListeners) {
                if (iLiveMsgReceiveListener != null) {
                    if (!this.mStudioUsePaListeners.contains(iLiveMsgReceiveListener)) {
                        this.mStudioUsePaListeners.add(iLiveMsgReceiveListener);
                    }
                }
            }
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.27
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

    public int saveMessage(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048681, this, chatMsg)) == null) {
            if (chatMsg == null || !AccountManager.isLogin(mContext)) {
                return -1;
            }
            if (1 == chatMsg.getCategory()) {
                return saveGroupMessage(chatMsg);
            }
            if (9 == chatMsg.getCategory()) {
                return -1;
            }
            return saveSingleMsg(chatMsg, -1);
        }
        return invokeL.intValue;
    }

    public void unregisterLiveMsgReceiveListener(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, str) == null) {
            String str2 = TAG;
            LogUtils.d(str2, "do unregisterLiveMsgReceiveListener, mcastid = " + str);
            if (!TextUtils.isEmpty(str) && this.mReceiveStudioListeners.remove(str) != null) {
                LogUtils.d(TAG, " do unregisterLiveMsgReceiveListener done!!! ");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: com.baidu.android.imsdk.chatmessage.messages.HtmlMsg */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatMsg getForwardChatMsg(ChatMsg chatMsg, int i, int i2, long j, long j2) {
        InterceptResult invokeCommon;
        ChatMsg textMsg;
        ImageMsg imageMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65564, this, new Object[]{chatMsg, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            String msgContent = chatMsg.getMsgContent();
            int msgType = chatMsg.getMsgType();
            if (msgType != 0) {
                if (msgType != 1) {
                    if (msgType != 8) {
                        if (msgType != 18) {
                            if (msgType != 38) {
                                if (msgType != 40) {
                                    if (msgType != 51) {
                                        if (msgType != 55) {
                                            if (msgType != 61) {
                                                textMsg = null;
                                            } else {
                                                textMsg = new QuickProductCardMsg();
                                                textMsg.setMsgContent(msgContent);
                                            }
                                        } else {
                                            textMsg = new NetDiskFileMsg();
                                            textMsg.setMsgContent(msgContent);
                                        }
                                    } else {
                                        textMsg = new LiveCardMsg();
                                        textMsg.setMsgContent(msgContent);
                                    }
                                }
                            } else {
                                textMsg = new BrandMsg();
                                textMsg.setMsgContent(msgContent);
                            }
                        } else {
                            HtmlMsg htmlMsg = new HtmlMsg();
                            htmlMsg.setMsgContent(msgContent);
                            htmlMsg.setDesc(((HtmlMsg) chatMsg).getDesc());
                            imageMsg = htmlMsg;
                        }
                    } else {
                        textMsg = new SignleGraphicTextMsg();
                        textMsg.setMsgContent(msgContent);
                    }
                    if (textMsg == null) {
                        return null;
                    }
                    textMsg.setRowId(-1L);
                    textMsg.setMsgKey("");
                    textMsg.setCategory(i);
                    textMsg.setFromUser(AccountManager.getUK(mContext));
                    textMsg.setStatus(1);
                    textMsg.setSenderUid(AccountManager.getUid(mContext));
                    textMsg.setIsZhida(false);
                    textMsg.setContacterBduid(String.valueOf(j2));
                    textMsg.setContacter(j);
                    textMsg.setChatType(i2);
                    textMsg.setMsgTime(System.currentTimeMillis() / 1000);
                    textMsg.parseForwardmessage(i);
                    return textMsg;
                }
                ImageMsg imageMsg2 = new ImageMsg();
                imageMsg2.setMsgContent(msgContent);
                imageMsg2.setLocalUrl(chatMsg.getLocalUrl());
                imageMsg = imageMsg2;
                textMsg = imageMsg;
                if (textMsg == null) {
                }
            }
            textMsg = new TextMsg();
            textMsg.setMsgContent(msgContent);
            if (textMsg == null) {
            }
        } else {
            return (ChatMsg) invokeCommon.objValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean interceptBusiNotify(int i, int i2, int i3, int i4, long j, long j2, String str, String str2, JSONObject jSONObject, int i5) {
        InterceptResult invokeCommon;
        long j3;
        long j4;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65567, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j), Long.valueOf(j2), str, str2, jSONObject, Integer.valueOf(i5)})) == null) {
            if (i == 238) {
                if (i5 == 9 && i3 == 27) {
                    if (i2 == 2) {
                        try {
                            jSONObject2 = new JSONObject(str);
                            j3 = jSONObject2.optLong("max_msgid");
                        } catch (Exception e) {
                            e = e;
                            j3 = 0;
                        }
                        try {
                            j4 = jSONObject2.optLong("dialogue_id");
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            j4 = 0;
                            BIMManager.setBusinessChatMsgContacterRead(mContext, i3, i4, j, j3, j4);
                            return false;
                        }
                        BIMManager.setBusinessChatMsgContacterRead(mContext, i3, i4, j, j3, j4);
                        return false;
                    } else if (i2 == 3) {
                        try {
                            JSONArray optJSONArray = new JSONObject(str).optJSONArray("msgid");
                            if (optJSONArray != null) {
                                long[] jArr = new long[optJSONArray.length()];
                                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                                    jArr[i6] = optJSONArray.optLong(i6);
                                }
                                deleteDBBusiMsgsByMsgId(9, j, i3, i4, jArr);
                            }
                            NotifyMessageHandler.handleBusinessMsgNotify(mContext, i3, i4, j, 3, -1L, -1L, "");
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        return false;
                    } else if (i2 == 4) {
                        ChatSessionManagerImpl.getInstance(mContext).onDelBusinessSessionResult(0, "", i3, i4, 9, j, null);
                        BIMManager.deleteDbBusiChatSession(mContext, j, i4, i3, 9);
                        return false;
                    } else if (i2 == 5) {
                        NotifyMessageHandler.handleBusinessMsgNotify(mContext, i3, i4, j, 3, -1L, -1L, "");
                        return false;
                    } else if (i2 == 6) {
                        NotifyMessageHandler.handleBusinessMsgNotify(mContext, i3, i4, j, 2, -1L, -1L, "");
                        return false;
                    }
                } else if (i5 == 0) {
                    NotifyMessageHandler.handleClueMsgNotify(mContext, i, i3, j, i5, jSONObject);
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private void mediaForwardPa(long j, long j2, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65568, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), chatMsg, iSendMessageListener}) == null) {
            PaInfo paInfo = PaManager.getPaInfo(mContext, j2);
            if (paInfo != null) {
                i = paInfo.getSubtype();
            } else {
                i = 7;
            }
            SendMsgParam.newInstanceByPa(mContext, getForwardChatMsg(chatMsg, 0, i, j2, j), j2, new BIMValueCallBack<SendMsgResponse>(this, iSendMessageListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.35
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$listener = iSendMessageListener;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                public void onResult(int i2, String str, SendMsgResponse sendMsgResponse) {
                    ChatMsg chatMsg2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, sendMsgResponse) == null) && this.val$listener != null) {
                        if (sendMsgResponse == null) {
                            chatMsg2 = null;
                        } else {
                            chatMsg2 = sendMsgResponse.msg;
                        }
                        this.val$listener.onSendMessageResult(i2, chatMsg2);
                    }
                }
            }, new SendMsgParam.SendMsgParamConstruct(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.36
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.android.imsdk.chatmessage.request.params.SendMsgParam.SendMsgParamConstruct
                public void construct(SendMsgParam sendMsgParam) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, sendMsgParam) == null) {
                        BIMManager.sendChatMsg(ChatMsgManagerImpl.mContext, sendMsgParam);
                    }
                }
            });
        }
    }

    private void mediaGetChatSessions(int i, int i2, long j, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65570, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), iGetNewMsgCountListener}) == null) {
            ChatSessionManagerImpl.getInstance(mContext).mediaGetChatSessions(j, Utility.getBusinessType(i, i2), j, PaManagerImpl.getInstance(mContext).getPaThirdId(j), 0L, 1, 0, new IMediaGetChatSessionListener(this, j, iGetNewMsgCountListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.29
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

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyLiveChatMsg(int i, long j, List<ChatMsg> list, boolean z) {
        IChatRoomMsgReceiveListener iChatRoomMsgReceiveListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), list, Boolean.valueOf(z)}) == null) {
            if (z) {
                iChatRoomMsgReceiveListener = this.mLiveChatGroupMsgReceiveListeners.get(Long.valueOf(j));
            } else {
                iChatRoomMsgReceiveListener = this.mLiveChatMsgReceiveListeners.get(Long.valueOf(j));
            }
            if (iChatRoomMsgReceiveListener != null) {
                iChatRoomMsgReceiveListener.onReceiveMessage(i, j, list);
            }
        }
    }

    @Deprecated
    public ArrayList<ChatMsg> fetchMessageSync(int i, long j, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            return ChatMessageDBManager.getInstance(mContext).fetchMsg(getChatObject(i, j), j2, i2, -1L);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public void getNotificationMsgDataList(SparseArray<List<Integer>> sparseArray, long j, int i, IFetchNotificationDataListener iFetchNotificationDataListener) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{sparseArray, Long.valueOf(j), Integer.valueOf(i), iFetchNotificationDataListener}) == null) {
            if (AccountManager.isLogin(mContext) && iFetchNotificationDataListener != null) {
                if (Math.abs(i) > 20) {
                    i2 = 20;
                } else {
                    i2 = i;
                }
                TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, sparseArray, j, i2, iFetchNotificationDataListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.12
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
                            Object[] objArr = {this, sparseArray, Long.valueOf(j), Integer.valueOf(i2), iFetchNotificationDataListener};
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
                        this.val$map = sparseArray;
                        this.val$msgid = j;
                        this.val$realCount = i2;
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

    public void getNotificationMsgsByTopicSource(long j, boolean z, String str, IFetchNotificationDataListener iFetchNotificationDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), str, iFetchNotificationDataListener}) == null) {
            if (AccountManager.isLogin(mContext) && iFetchNotificationDataListener != null) {
                TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, j, z, str, iFetchNotificationDataListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ChatMsgManagerImpl this$0;
                    public final /* synthetic */ boolean val$hasRead;
                    public final /* synthetic */ IFetchNotificationDataListener val$listener;
                    public final /* synthetic */ long val$timestamp;
                    public final /* synthetic */ String val$topic;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Long.valueOf(j), Boolean.valueOf(z), str, iFetchNotificationDataListener};
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
                        this.val$timestamp = j;
                        this.val$hasRead = z;
                        this.val$topic = str;
                        this.val$listener = iFetchNotificationDataListener;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ArrayList<ChatMsg> fetchMsgsByTopicSourceTag = ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).fetchMsgsByTopicSourceTag(this.val$timestamp, this.val$hasRead, this.val$topic);
                            this.this$0.callBackNotificationMsgData(fetchMsgsByTopicSourceTag, fetchMsgsByTopicSourceTag.size() + 1, this.val$listener);
                        }
                    }
                });
            } else if (iFetchNotificationDataListener != null) {
                iFetchNotificationDataListener.onFetchResult(null, false);
            }
        }
    }

    private void mediaForwardUser(long j, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65569, this, new Object[]{Long.valueOf(j), chatMsg, iSendMessageListener}) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j));
            GroupManagerImpl.getInstance(mContext).getPaidAndUkByBduid(arrayList, new BIMValueCallBack<List<IMQueryMemberPauidRequest.UserId>>(this, chatMsg, j, iSendMessageListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.37
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatMsgManagerImpl this$0;
                public final /* synthetic */ long val$bduid;
                public final /* synthetic */ ChatMsg val$chatMsg;
                public final /* synthetic */ ISendMessageListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, chatMsg, Long.valueOf(j), iSendMessageListener};
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
                    this.val$chatMsg = chatMsg;
                    this.val$bduid = j;
                    this.val$listener = iSendMessageListener;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                public void onResult(int i, String str, List<IMQueryMemberPauidRequest.UserId> list) {
                    int i2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, list) == null) {
                        if (i == 0 && list != null) {
                            for (IMQueryMemberPauidRequest.UserId userId : list) {
                                long pauid = userId.getPauid();
                                int i3 = (pauid > 0L ? 1 : (pauid == 0L ? 0 : -1));
                                if (i3 == 0) {
                                    i2 = 0;
                                } else {
                                    i2 = 7;
                                }
                                if (i3 == 0) {
                                    pauid = userId.getUk();
                                }
                                ChatMsg forwardChatMsg = this.this$0.getForwardChatMsg(this.val$chatMsg, 0, i2, pauid, this.val$bduid);
                                BIMValueCallBack<SendMsgResponse> bIMValueCallBack = new BIMValueCallBack<SendMsgResponse>(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.37.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass37 this$1;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i4 = newInitContext.flag;
                                            if ((i4 & 1) != 0) {
                                                int i5 = i4 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                    }

                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                                    public void onResult(int i4, String str2, SendMsgResponse sendMsgResponse) {
                                        Interceptable interceptable3 = $ic;
                                        if ((interceptable3 == null || interceptable3.invokeILL(1048576, this, i4, str2, sendMsgResponse) == null) && this.this$1.val$listener != null) {
                                            ChatMsg chatMsg2 = null;
                                            if (sendMsgResponse != null) {
                                                chatMsg2 = sendMsgResponse.msg;
                                            }
                                            this.this$1.val$listener.onSendMessageResult(i4, chatMsg2);
                                        }
                                    }
                                };
                                SendMsgParam.SendMsgParamConstruct sendMsgParamConstruct = new SendMsgParam.SendMsgParamConstruct(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.37.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass37 this$1;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i4 = newInitContext.flag;
                                            if ((i4 & 1) != 0) {
                                                int i5 = i4 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                    }

                                    @Override // com.baidu.android.imsdk.chatmessage.request.params.SendMsgParam.SendMsgParamConstruct
                                    public void construct(SendMsgParam sendMsgParam) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeL(1048576, this, sendMsgParam) == null) {
                                            BIMManager.sendChatMsg(ChatMsgManagerImpl.mContext, sendMsgParam);
                                        }
                                    }
                                };
                                if (i3 == 0) {
                                    SendMsgParam.newInstanceByUk(ChatMsgManagerImpl.mContext, forwardChatMsg, userId.getUk(), bIMValueCallBack, sendMsgParamConstruct);
                                } else {
                                    SendMsgParam.newInstanceByPa(ChatMsgManagerImpl.mContext, forwardChatMsg, userId.getPauid(), bIMValueCallBack, sendMsgParamConstruct);
                                }
                            }
                            return;
                        }
                        ISendMessageListener iSendMessageListener2 = this.val$listener;
                        if (iSendMessageListener2 != null) {
                            iSendMessageListener2.onSendMessageResult(i, this.val$chatMsg);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPaChatMsgByHostRequest(int i, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65582, this, i, chatMsg, iSendMessageListener) == null) {
            if (chatMsg == null) {
                if (iSendMessageListener != null) {
                    iSendMessageListener.onSendMessageResult(1005, null);
                }
            } else if (!needRetrySendMsgByHost(i)) {
                if (iSendMessageListener != null) {
                    iSendMessageListener.onSendMessageResult(i, chatMsg);
                }
            } else {
                realSendChatMsgByHostRequest(chatMsg, new AnonymousClass24(this, i, chatMsg, ListenerManager.getInstance().addListener(iSendMessageListener)));
            }
        }
    }

    public ChatObject buildChatObject(int i, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return new ChatObject(mContext, i, j, j2);
        }
        return (ChatObject) invokeCommon.objValue;
    }

    public String getAdvisoryDraftStr(int i, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            return BusinessMessageDBManager.getInstance(mContext).getDraftMsg(i, j, i2);
        }
        return (String) invokeCommon.objValue;
    }

    public void onMediaDeleteChatMsgResult(String str, int i, String str2) {
        IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048655, this, str, i, str2) == null) && (iMediaDeleteChatMsgListener = (IMediaDeleteChatMsgListener) ListenerManager.getInstance().removeListener(str)) != null) {
            String str3 = TAG;
            LogUtils.d(str3, "BC> responseCode=" + i + ", msg=" + str2);
            iMediaDeleteChatMsgListener.onMediaDeleteChatMsgResult(i, str2);
        }
    }

    public void onMediaSendChatMsgResult(String str, int i, ChatMsg chatMsg) {
        IMediaSendChatMsgListener iMediaSendChatMsgListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048657, this, str, i, chatMsg) == null) && (iMediaSendChatMsgListener = (IMediaSendChatMsgListener) ListenerManager.getInstance().removeListener(str)) != null) {
            String str2 = TAG;
            LogUtils.d(str2, "BC> responseCode=" + i + ", msg=" + chatMsg);
            iMediaSendChatMsgListener.onMediaSendChatMsgResult(i, chatMsg);
        }
    }

    public void onUnRegisterNotifyResult(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048661, this, str, i, str2) == null) {
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

    public boolean setAllMsgRead(int i, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048694, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            return setBeforeMsgRead(i, j, ChatMessageDBManager.getInstance(mContext).getMaxMsgid(getChatObject(i, j)), z);
        }
        return invokeCommon.booleanValue;
    }

    public void setBusinessAdvAdShowClickedInfoByUK(String str, boolean z, IAdvisoryAdBtnShowSaveListener iAdvisoryAdBtnShowSaveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048696, this, new Object[]{str, Boolean.valueOf(z), iAdvisoryAdBtnShowSaveListener}) == null) {
            long businessAdvAdShowClickedInfoByUK = BusinessMessageDBManager.getInstance(mContext).setBusinessAdvAdShowClickedInfoByUK(str, z);
            if (iAdvisoryAdBtnShowSaveListener != null) {
                iAdvisoryAdBtnShowSaveListener.saveBusinessAdvAdBtnShow(businessAdvAdShowClickedInfoByUK);
            }
        }
    }

    public void showSendMsgPV(long j, long j2, IShowSendMsgPVListener iShowSendMsgPVListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048706, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), iShowSendMsgPVListener}) == null) {
            IMShowSendMsgPVRequest iMShowSendMsgPVRequest = new IMShowSendMsgPVRequest(mContext, j, j2, new IShowSendMsgPVListener(this, j, j2, iShowSendMsgPVListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.39
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatMsgManagerImpl this$0;
                public final /* synthetic */ long val$beginTime;
                public final /* synthetic */ long val$endTime;
                public final /* synthetic */ IShowSendMsgPVListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j), Long.valueOf(j2), iShowSendMsgPVListener};
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
                    this.val$beginTime = j;
                    this.val$endTime = j2;
                    this.val$listener = iShowSendMsgPVListener;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IShowSendMsgPVListener
                public void onResult(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        if (!AccountManager.getMediaRole(ChatMsgManagerImpl.mContext)) {
                            i += ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).showSendMsgPV(this.val$beginTime, this.val$endTime);
                        }
                        int showSendMsgPV = i + GroupMessageDAOImpl.showSendMsgPV(ChatMsgManagerImpl.mContext, this.val$beginTime, this.val$endTime);
                        String str = ChatMsgManagerImpl.TAG;
                        LogUtils.d(str, "showSendMsgPV msgPV：" + showSendMsgPV);
                        IShowSendMsgPVListener iShowSendMsgPVListener2 = this.val$listener;
                        if (iShowSendMsgPVListener2 != null) {
                            iShowSendMsgPVListener2.onResult(showSendMsgPV);
                        }
                    }
                }
            });
            HttpHelper.executor(mContext, iMShowSendMsgPVRequest, iMShowSendMsgPVRequest);
        }
    }

    private void onDeliverMcastResponse(String str, JSONArray jSONArray, ILiveMsgReceiveListener iLiveMsgReceiveListener, List<Long> list) {
        JSONArray jSONArray2;
        JSONException e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65574, this, str, jSONArray, iLiveMsgReceiveListener, list) == null) {
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

    public int deleteDBBusiMsgs(int i, long j, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            if (i >= 0 && j >= 0 && j2 >= 0 && i2 >= 0) {
                if (AccountManager.isLogin(mContext)) {
                    if (i == 9) {
                        return BusinessMessageDBManager.getInstance(mContext).deleteLogicBusiMsgBatch(j, j2, i2);
                    }
                    return 1003;
                }
                return -1000;
            }
            return -1005;
        }
        return invokeCommon.intValue;
    }

    public void getPaNewMsgCount(int i, int i2, long j, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), iGetNewMsgCountListener}) == null) {
            if (AccountManager.isLogin(mContext)) {
                if (AccountManager.getMediaRole(mContext)) {
                    mediaGetChatSessions(i, i2, j, iGetNewMsgCountListener);
                    return;
                }
                LogUtils.d(TAG, "c getPaNewMsgCount");
                TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, iGetNewMsgCountListener, j) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.28
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
                            this.val$listener.onGetNewMsgCount(this.this$0.getNewMsgCountByPaid(this.val$paid, 0L));
                        }
                    }
                });
                return;
            }
            LogUtils.d(TAG, "login error");
            iGetNewMsgCountListener.onGetNewMsgCount(0);
        }
    }

    public void mediaDeleteChatMsg(long j, long j2, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048642, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), list, iMediaDeleteChatMsgListener}) == null) {
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

    public void resendMsg(String str, String str2, int i, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048676, this, str, str2, i, iSendMessageListener) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "resendMsg " + str + " " + str2 + " ---->");
            if (i == 0) {
                ChatMsg fetchMsg = ChatMessageDBManager.getInstance(mContext).fetchMsg(str2, str);
                if (fetchMsg == null) {
                    LogUtils.d(TAG, "resendMsg get msg by rowid is null");
                    if (iSendMessageListener != null) {
                        iSendMessageListener.onSendMessageResult(1005, null);
                        return;
                    }
                    return;
                }
                String str4 = TAG;
                LogUtils.d(str4, "resendMsg " + fetchMsg.getRowId() + GlideException.IndentedAppendable.INDENT + str);
                fetchMsg.setStatus(1);
                fetchMsg.setReSend();
                sendMessage(fetchMsg, iSendMessageListener);
            }
        }
    }

    public void sendDelBusinessSessionMsg(long j, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048685, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            LogUtils.d(TAG, "sendDelBusinessSessionMsg start");
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, Constants.METHOD_IM_DEL_BUSINESS_SESSION_MSG);
                creatMethodIntent.putExtra("contacter", j);
                creatMethodIntent.putExtra(Constants.EXTRA_BUSINESS_TYPE, i2);
                creatMethodIntent.putExtra("session_type", i);
                creatMethodIntent.putExtra("category", i3);
                try {
                    x80.e(mContext).d(mContext, creatMethodIntent);
                    return;
                } catch (Exception e) {
                    LogUtils.e(TAG, "sendCustomNotifyMsg Exception ", e);
                    return;
                }
            }
            LogUtils.d(TAG, "sendDelBusinessSessionMsg not login");
        }
    }

    public boolean setBeforeMsgRead(int i, long j, long j2, boolean z) {
        InterceptResult invokeCommon;
        ChatObject chatObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048695, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            if (AccountManager.isLogin(mContext)) {
                if ((j & 17592186044416L) != 0) {
                    chatObject = getChatObject(i, j);
                } else {
                    chatObject = getChatObject(i, j);
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
                    setServerMsgRead(0, -1, i, j, j2, z, null);
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void setInterActiveMsgStatus(long j, long j2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048698, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            ChatMsg chatMsgByMsgId = ChatMessageDBManager.getInstance(mContext).getChatMsgByMsgId(j);
            if (chatMsgByMsgId instanceof InterActiveMsg) {
                String jsonContent = ((InterActiveMsg) chatMsgByMsgId).getJsonContent();
                if (i != 0 && i != 1) {
                    if (i == 2) {
                        ChatUser chatUserByBuid = ChatUserDBManager.getInstance(mContext).getChatUserByBuid(j2);
                        if (chatUserByBuid != null) {
                            chatUserByBuid.setSubscribe(i2);
                            ChatUserDBManager.getInstance(mContext).updateUserByBduid(chatUserByBuid);
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(Long.valueOf(j2));
                        ChatUserManagerImpl.getInstance(mContext).updateUserIdentity(arrayList, new IGetUserIdentityListener(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.20
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
                        return;
                    }
                    return;
                }
                chatMsgByMsgId.setMsgContent(replaceInterActiveBottomBarStatus(jsonContent, i, i2));
                ChatMessageDBManager.getInstance(mContext).updateMsgStatus(chatMsgByMsgId);
            }
        }
    }

    public boolean setMsgRead(int i, long j, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048700, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            if (!AccountManager.isLogin(mContext) || ChatMessageDBManager.getInstance(mContext).setMsgRead(getChatObject(i, j), j2) < 0) {
                return false;
            }
            Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 67);
            creatMethodIntent.putExtra("category", i);
            creatMethodIntent.putExtra("contacter", j);
            creatMethodIntent.putExtra("msgid", j2);
            creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, z);
            try {
                x80.e(mContext).d(mContext, creatMethodIntent);
                return true;
            } catch (Exception e) {
                LogUtils.e(TAG, "Exception ", e);
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    private void onDeliverResponse(String str, JSONArray jSONArray, ILiveMsgReceiveListener iLiveMsgReceiveListener, List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65575, this, str, jSONArray, iLiveMsgReceiveListener, list) == null) {
            if (iLiveMsgReceiveListener != null) {
                if (iLiveMsgReceiveListener instanceof IRoomLiveMsgReceiveListener) {
                    ((IRoomLiveMsgReceiveListener) iLiveMsgReceiveListener).onReceiveMessage(str, 0, jSONArray);
                } else {
                    iLiveMsgReceiveListener.onReceiveMessage(0, jSONArray);
                }
                String str2 = TAG;
                LogUtils.d(str2, "listener != null and onDeliverResponse arr size :" + jSONArray.length());
                return;
            }
            LogUtils.d(TAG, "mReceiveStudioListener is null");
        }
    }

    public void onAudioTransCallBack(String str, int i, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048650, this, str, i, str2, str3) == null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void realToSendMsg(ChatMsg chatMsg, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65577, this, chatMsg, str) == null) {
            Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 55);
            creatMethodIntent.putExtra(Constants.EXTRA_SEND_MSG, chatMsg);
            creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, str);
            try {
                x80.e(mContext).d(mContext, creatMethodIntent);
            } catch (Exception e) {
                onSendMessageResult(6, chatMsg, -1L, str);
                LogUtils.e(TAG, "Exception ", e);
            }
        }
    }

    public int deleteDraftMsg(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return ChatMessageDBManager.getInstance(mContext).deleteDraftMsg(getChatObject(i, j));
        }
        return invokeCommon.intValue;
    }

    public int getNewMsgCountByPaid(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048626, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return ChatMessageDBManager.getInstance(mContext).getUnReadMsgCount(buildChatObject(0, j, j2));
        }
        return invokeCommon.intValue;
    }

    public long getNewMsgNum(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048627, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (AccountManager.isLogin(mContext)) {
                return ChatMessageDBManager.getInstance(mContext).getNewMsgNum(getChatObject(i, j));
            }
            return -1L;
        }
        return invokeCommon.longValue;
    }

    public void registerLiveMsgReceiveListener(String str, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048670, this, str, iLiveMsgReceiveListener) == null) {
            String str2 = TAG;
            LogUtils.d(str2, "registerLiveMsgReceiveListener : " + iLiveMsgReceiveListener + ", mcastid = " + str);
            if (iLiveMsgReceiveListener != null) {
                this.mReceiveStudioListeners.put(str, iLiveMsgReceiveListener);
            }
        }
    }

    public void sendMessageBroadcast(Context context, ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048690, this, context, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            try {
                Intent intent = new Intent(IMConstants.MESSAGE_ACTION);
                intent.setPackage(context.getApplicationContext().getPackageName());
                intent.putParcelableArrayListExtra(IMConstants.MESSAGE, arrayList);
                mContext.sendBroadcast(intent);
            } catch (Exception unused) {
                LogUtils.e(TAG, " sendMessageBoradcast exception ");
            }
        }
    }

    public void sendMessageRequest(ChatMsg chatMsg, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048691, this, chatMsg, str) == null) {
            String str2 = TAG;
            LogUtils.d(str2, "sendMessageRequest ---> msg :" + chatMsg.toString());
            this.mUseRequestSendMsg = true;
            IMSendMsgRequest iMSendMsgRequest = new IMSendMsgRequest(mContext, chatMsg, str);
            HttpHelper.executor(mContext, iMSendMsgRequest, iMSendMsgRequest);
        }
    }

    public void unregisterMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048715, this, context, iMessageReceiveListener) == null) {
            String str = TAG;
            LogUtils.e(str, "unregisterMessageReceiveListener : " + iMessageReceiveListener);
            if (iMessageReceiveListener != null && this.mReceiveListeners.contains(iMessageReceiveListener)) {
                this.mReceiveListeners.remove(iMessageReceiveListener);
            }
        }
    }

    private String replaceInterActiveBottomBarStatus(String str, int i, int i2) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65579, this, str, i, i2)) == null) {
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
                return str;
            }
        }
        return (String) invokeLII.objValue;
    }

    public void deliverMcastMessage(String str, String str2, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, str, str2, jSONArray) == null) {
            String str3 = TAG;
            LogUtils.e(str3, "deliverMcastMessage notify :" + this.mReceiveStudioListeners.keySet());
            if (this.mReceiveStudioListeners.containsKey(str2)) {
                onDeliverMcastResponse(str2, jSONArray, this.mReceiveStudioListeners.get(str2), null);
            }
            if (this.mReceiveStudioListeners.containsKey(str)) {
                onDeliverMcastResponse(str, jSONArray, this.mReceiveStudioListeners.get(str), null);
            }
            deliverMcastMessage(jSONArray);
        }
    }

    public void getChatPageBottomMenuRequest(long j, int i, IMGetBottomMenuListener iMGetBottomMenuListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), iMGetBottomMenuListener}) == null) {
            LogUtils.d(TAG, "getChatPageBottomMenuRequest start");
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                IMGetBottomMenuRequest iMGetBottomMenuRequest = new IMGetBottomMenuRequest(mContext, ListenerManager.getInstance().addListener(iMGetBottomMenuListener), j, i);
                HttpHelper.executor(mContext, iMGetBottomMenuRequest, iMGetBottomMenuRequest);
                return;
            }
            LogUtils.d(TAG, "uid not login, getChatPageBottomMenuRequest return");
        }
    }

    public ChatMsg updateReplyChatMsgQuoteData(long j, int i, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048720, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str})) == null) {
            if (j <= 0) {
                String str2 = TAG;
                LogUtils.d(str2, "updateReplyChatMsgQuoteData failed, msgid invalid:" + j);
                return null;
            }
            return ChatMessageDBManager.getInstance(mContext).updateReplyChatMsgQuoteData(j, i, str);
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    private int saveSingleMsg(ChatMsg chatMsg, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65580, this, chatMsg, i)) == null) {
            long maxMsgid = ChatMessageDBManager.getInstance(mContext).getMaxMsgid() + 1;
            LogUtils.d(TAG, "saveSingleMsg msgid = " + maxMsgid);
            chatMsg.setMsgId(maxMsgid);
            chatMsg.setIsClicked(true);
            chatMsg.setMsgReaded(1);
            chatMsg.setDeviceFlag(1);
            long rowId = chatMsg.getRowId();
            if (rowId == -1) {
                if (TextUtils.isEmpty(chatMsg.getMsgKey())) {
                    chatMsg.createMsgKey(mContext);
                }
                LogUtils.d("FFF saveSingleMsg msgkey ", " " + chatMsg.getMsgKey());
                rowId = ChatMessageDBManager.getInstance(mContext).addMsg(chatMsg, true);
            } else {
                ChatMessageDBManager.getInstance(mContext).updateMsgStatus(chatMsg);
            }
            if (rowId >= 0) {
                chatMsg.setRowId(rowId);
                String str = "" + chatMsg.getRowId();
                String msgUUid = MsgUtility.getMsgUUid(chatMsg);
                String chatObject = getChatObject(chatMsg.getCategory(), chatMsg.getContacter()).toString();
                if (!TextUtils.isEmpty(msgUUid) && DBManager.getInstance(mContext).getCmdQueueMsg(msgUUid, Constants.METHOD_SEND_USER_MSG) == null) {
                    DBManager.getInstance(mContext).saveCmdMsg(msgUUid, Constants.METHOD_SEND_USER_MSG, str, chatObject, 15, 2);
                }
                return 1;
            }
            return i;
        }
        return invokeLI.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUploadTask(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65583, this, new Object[]{Integer.valueOf(i), str, str2, str3, str4, str5, str6, str7, iUploadTransferListener}) == null) {
            new AsyncUploadTask(mContext, i, str, str2, str3, str4, str5, str6, str7, iUploadTransferListener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    private void updateChatMsgStatus(ChatMsg chatMsg, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65584, this, chatMsg, i) == null) {
            if (i == 0) {
                i2 = 0;
            } else {
                if (chatMsg.getCategory() != 4) {
                    MessageUbc.DebugInfo debugInfo = new MessageUbc.DebugInfo();
                    debugInfo.clientSource = ChatMsgManagerImpl.class.getSimpleName() + "_updateChatMsgStatus";
                    debugInfo.msgId = chatMsg.getMsgId();
                    MessageUbc.uploadUbc(mContext, i, UBCConstants.SEND_FAIL_RECORD_UBC, debugInfo, chatMsg);
                }
                i2 = 2;
            }
            chatMsg.setStatus(i2);
            ChatMessageDBManager.getInstance(mContext).updateMsgStatus(chatMsg);
        }
    }

    public void registerChatRoomGroupMsgReceiveListener(long j, IChatRoomMsgReceiveListener iChatRoomMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048663, this, j, iChatRoomMsgReceiveListener) == null) {
            this.mIsChatRoom = true;
            if (iChatRoomMsgReceiveListener != null) {
                this.mLiveChatGroupMsgReceiveListeners.put(Long.valueOf(j), iChatRoomMsgReceiveListener);
            }
            String str = TAG;
            LogUtils.d(str, "registerChatRoomGroupMsgReceiveListener : " + iChatRoomMsgReceiveListener);
            registerLiveMsgReceiveListener("" + j, this.msgReceiveListener);
        }
    }

    public void registerChatRoomMsgReceiveListener(long j, IChatRoomMsgReceiveListener iChatRoomMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048664, this, j, iChatRoomMsgReceiveListener) == null) {
            this.mIsChatRoom = true;
            if (iChatRoomMsgReceiveListener != null) {
                this.mLiveChatMsgReceiveListeners.put(Long.valueOf(j), iChatRoomMsgReceiveListener);
            }
            String str = TAG;
            LogUtils.d(str, "registerLiveChatMsgReceiveListener : " + iChatRoomMsgReceiveListener);
            registerLiveMsgReceiveListener("" + j, this.msgReceiveListener);
        }
    }

    public void sendChatMsgByHostRequest(ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048683, this, chatMsg, iSendMessageListener) == null) {
            if (TextUtils.isEmpty(chatMsg.getMsgKey())) {
                chatMsg.createMsgKey(mContext);
            }
            chatMsg.setRowId(System.currentTimeMillis());
            long queryBusinessDialogueId = BusinessMessageDBManager.getInstance(mContext).queryBusinessDialogueId(chatMsg.getBusinessType(), chatMsg.getResourceId());
            if (queryBusinessDialogueId != 0) {
                chatMsg.setDialogueId(queryBusinessDialogueId);
                realSendChatMsgByHostRequest(chatMsg, iSendMessageListener);
                return;
            }
            getConsultDialogueIdRequest(chatMsg.getBusinessType(), chatMsg.getResourceId(), new BIMValueCallBack<Long>(this, chatMsg, iSendMessageListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatMsgManagerImpl this$0;
                public final /* synthetic */ ISendMessageListener val$listener;
                public final /* synthetic */ ChatMsg val$msg;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, chatMsg, iSendMessageListener};
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
                    this.val$msg = chatMsg;
                    this.val$listener = iSendMessageListener;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                public void onResult(int i, String str, Long l) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, l) == null) {
                        if (i == 0 && l != null) {
                            this.val$msg.setDialogueId(l.longValue());
                            this.this$0.realSendChatMsgByHostRequest(this.val$msg, this.val$listener);
                            return;
                        }
                        ISendMessageListener iSendMessageListener2 = this.val$listener;
                        if (iSendMessageListener2 != null) {
                            iSendMessageListener2.onSendMessageResult(6, this.val$msg);
                        }
                    }
                }
            });
        }
    }

    public void sendConsultMsg(ChatMsg chatMsg, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048684, this, chatMsg, str) == null) {
            chatMsg.setIsClicked(true);
            chatMsg.setMsgReaded(1);
            chatMsg.setDeviceFlag(1);
            if (TextUtils.isEmpty(chatMsg.getMsgKey())) {
                chatMsg.createMsgKey(mContext);
            }
            chatMsg.setRowId(System.currentTimeMillis());
            long queryBusinessDialogueId = BusinessMessageDBManager.getInstance(mContext).queryBusinessDialogueId(chatMsg.getBusinessType(), chatMsg.getResourceId());
            if (queryBusinessDialogueId != 0) {
                chatMsg.setDialogueId(queryBusinessDialogueId);
                realToSendMsg(chatMsg, str);
                return;
            }
            getConsultDialogueIdRequest(chatMsg.getBusinessType(), chatMsg.getResourceId(), new BIMValueCallBack<Long>(this, chatMsg, str) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.31
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatMsgManagerImpl this$0;
                public final /* synthetic */ String val$key;
                public final /* synthetic */ ChatMsg val$msg;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, chatMsg, str};
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
                    this.val$msg = chatMsg;
                    this.val$key = str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                public void onResult(int i, String str2, Long l) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str2, l) == null) {
                        if (i == 0 && l != null) {
                            this.val$msg.setDialogueId(l.longValue());
                            this.this$0.realToSendMsg(this.val$msg, this.val$key);
                            return;
                        }
                        this.this$0.onSendMessageResult(6, this.val$msg, -1L, this.val$key);
                    }
                }
            });
        }
    }

    public void asyncUploadImgToBos(String str, String str2, int i, int i2, int i3, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iUploadTransferListener}) == null) {
            if (AccountManager.isLogin(mContext)) {
                genBosObjectUrl(str, "image/jpeg", str2, i, i2, i3, new IGenBosObjectUrlListener(this, str, iUploadTransferListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.17
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
                        String str8;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i4), str3, str4, str5, map}) == null) {
                            if (i4 == 0) {
                                if (map == null) {
                                    str6 = "";
                                    str7 = str6;
                                    str8 = str7;
                                } else {
                                    str6 = map.get(AsyncChatTask.PUT_URL);
                                    str7 = map.get(AsyncChatTask.GET_URL);
                                    str8 = map.get("thumb_url");
                                }
                                this.this$0.startUploadTask(1, str6, str7, str8, this.val$filePath, "image/jpeg", str4, str5, this.val$listener);
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

    public int setBusinessChatMsgContacterRead(int i, int i2, long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048697, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            return BusinessMessageDBManager.getInstance(mContext).setBusinessChatMsgContacterRead(i, i2, j, j2, j3);
        }
        return invokeCommon.intValue;
    }

    public void uploadBottomMenuEventRequest(long j, int i, String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048721, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, Long.valueOf(j2), str2}) == null) {
            LogUtils.d(TAG, "uploadBottomMenuEvent start");
            IMUploadBottomMenuEventRequest iMUploadBottomMenuEventRequest = new IMUploadBottomMenuEventRequest(mContext, j, i, str, j2, str2);
            HttpHelper.executor(mContext, iMUploadBottomMenuEventRequest, iMUploadBottomMenuEventRequest);
        }
    }

    public void broadcastMessage(ArrayList<ChatMsg> arrayList, boolean z) {
        ArrayList<ChatMsg> arrayList2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, arrayList, z) == null) {
            synchronized (this.mReceiveListeners) {
                if (arrayList != null) {
                    if (arrayList.size() != 0) {
                        String str = TAG;
                        LogUtils.d(str, " recive message before filter! " + arrayList.size());
                        if (z) {
                            arrayList2 = filtMsgs(arrayList);
                        } else {
                            arrayList2 = arrayList;
                        }
                        if (arrayList2 != null && arrayList2.size() != 0) {
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
                                    next.onReceiveMessage(0, 0, new ArrayList<>(arrayList2));
                                }
                            }
                            int size = arrayList2.size();
                            int i2 = size / 20;
                            int i3 = size % 20;
                            while (i < i2) {
                                int i4 = 20 * i;
                                i++;
                                sendMessageBroadcast(mContext, new ArrayList<>(arrayList2.subList(i4, 20 * i)));
                            }
                            if (i3 > 0) {
                                sendMessageBroadcast(mContext, new ArrayList<>(arrayList2.subList(size - i3, size)));
                            }
                        }
                    }
                }
            }
        }
    }

    public void sendMessage(ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048688, this, chatMsg, iSendMessageListener) == null) {
            this.mUseRequestSendMsg = false;
            if (chatMsg == null) {
                if (iSendMessageListener != null) {
                    iSendMessageListener.onSendMessageResult(1005, null);
                }
            } else if (noSaveDB(chatMsg.getCategory(), chatMsg.getMsgType())) {
                sendHiddenMsg(chatMsg, iSendMessageListener);
            } else if ((chatMsg.getCategory() != 0 && chatMsg.getCategory() != 1 && chatMsg.getCategory() != 9) || chatMsg.getContacter() <= 0) {
                if (iSendMessageListener != null) {
                    iSendMessageListener.onSendMessageResult(1005, null);
                }
            } else {
                String addListener = ListenerManager.getInstance().addListener(iSendMessageListener);
                if (3 == IMConfigInternal.getInstance().getProductLine(mContext) && chatMsg.getCategory() == 1) {
                    if (chatMsg.getChatType() == 57) {
                        chatMsg.setMinSdkVersion(7300000L);
                    } else {
                        chatMsg.setMinSdkVersion(2300000L);
                    }
                }
                if (LoginManager.getInstance(mContext).isIMLogined()) {
                    if (chatMsg.getCategory() == 9) {
                        sendConsultMsg(chatMsg, addListener);
                        return;
                    } else if (saveMessage(chatMsg) == 1) {
                        realToSendMsg(chatMsg, addListener);
                        return;
                    } else {
                        onSendMessageResult(6, chatMsg, -1L, addListener);
                        return;
                    }
                }
                LoginManager.getInstance(mContext).triggleLogoutListener(1000, Constants.ERROR_LOGIN_STATE_ERROR);
                onSendMessageResult(1000, chatMsg, -1L, addListener);
            }
        }
    }

    public long deleteAllMsgs(int i, long j, boolean z, int i2) {
        InterceptResult invokeCommon;
        ChatSession chatRecord;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            int i3 = 0;
            LogUtils.d(TAG, String.format("delete all msg category=%d, contacter=%d", Integer.valueOf(i), Long.valueOf(j)));
            if (i >= 0 && j >= 0) {
                if (AccountManager.isLogin(mContext)) {
                    ChatObject chatObject = getChatObject(i, j);
                    if (i == 1 && (chatRecord = ChatMessageDBManager.getInstance(mContext).getChatRecord(chatObject)) != null) {
                        i3 = chatRecord.getChatType();
                    }
                    long deleteAllMsg = ChatMessageDBManager.getInstance(mContext).deleteAllMsg(chatObject, i2);
                    if (deleteAllMsg < 0) {
                        return -1009L;
                    }
                    Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 57);
                    creatMethodIntent.putExtra("category", i);
                    creatMethodIntent.putExtra("contacter", j);
                    creatMethodIntent.putExtra(Constants.EXTRA_CLIENT_MAX_MSGID, deleteAllMsg);
                    creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, z);
                    creatMethodIntent.putExtra(Constants.EXTRA_REMAIN_EMPTY_SESSION, i2);
                    if (i3 > 0) {
                        creatMethodIntent.putExtra("chat_type", i3);
                    }
                    try {
                        x80.e(mContext).d(mContext, creatMethodIntent);
                    } catch (Exception e) {
                        LogUtils.e(TAG, "Exception ", e);
                    }
                    return 0L;
                }
                return -1000L;
            }
            return -1005L;
        }
        return invokeCommon.longValue;
    }

    public int deleteMsgs(int i, long j, long[] jArr, boolean z) {
        InterceptResult invokeCommon;
        ChatSession chatRecord;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), jArr, Boolean.valueOf(z)})) == null) {
            if (i >= 0 && j >= 0 && jArr != null && jArr.length > 0) {
                if (AccountManager.isLogin(mContext)) {
                    ChatObject chatObject = getChatObject(i, j);
                    int i2 = 0;
                    if (i == 1 && (chatRecord = ChatMessageDBManager.getInstance(mContext).getChatRecord(chatObject)) != null) {
                        i2 = chatRecord.getChatType();
                    }
                    int deleteMsgBatch = ChatMessageDBManager.getInstance(mContext).deleteMsgBatch(getChatObject(i, j), jArr);
                    if (deleteMsgBatch >= 0 && i != 1) {
                        ArrayList<ChatMsg> fetchMsg = ChatMessageDBManager.getInstance(mContext).fetchMsg(chatObject, 0L, 1L, -1L, false);
                        Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 57);
                        creatMethodIntent.putExtra("category", i);
                        creatMethodIntent.putExtra("contacter", j);
                        creatMethodIntent.putExtra(Constants.EXTRA_DEL_MSG_IDS, jArr);
                        creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, z);
                        if (fetchMsg != null && fetchMsg.isEmpty()) {
                            creatMethodIntent.putExtra(Constants.EXTRA_REMAIN_EMPTY_SESSION, 1);
                        }
                        if (i2 > 0) {
                            creatMethodIntent.putExtra("chat_type", i2);
                        }
                        try {
                            x80.e(mContext).d(mContext, creatMethodIntent);
                        } catch (Exception e) {
                            LogUtils.e(TAG, "Exception ", e);
                        }
                    }
                    return deleteMsgBatch;
                }
                return -1000;
            }
            return -1005;
        }
        return invokeCommon.intValue;
    }

    public void onSendMessageResult(int i, ChatMsg chatMsg, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048659, this, new Object[]{Integer.valueOf(i), chatMsg, Long.valueOf(j), str}) == null) {
            try {
                if (chatMsg == null) {
                    LogUtils.d(TAG, "onSendMessageResult----chatMsg is null");
                    IMListener removeListener = ListenerManager.getInstance().removeListener(str);
                    if (removeListener instanceof ISendMessageListener) {
                        ((ISendMessageListener) removeListener).onSendMessageResult(i, null);
                    } else {
                        LogUtils.d(TAG, "ISendMessageListener is null");
                    }
                } else if (chatMsg.getCategory() == 4) {
                    onSendStudioMsgResult(i, chatMsg, j, str);
                } else if (chatMsg.getCategory() == 9) {
                    onSendConsultMsgResult(i, chatMsg, j, str);
                } else {
                    String str2 = TAG;
                    LogUtils.d(str2, "onSendMessageResult----errorCode: " + i);
                    if (j != -1) {
                        chatMsg.setMsgTime(j);
                    }
                    DBManager.getInstance(mContext).deleteCmdMsg(MsgUtility.getMsgUUid(chatMsg));
                    updateChatMsgStatus(chatMsg, i);
                    setMaxNotifyMsgid(chatMsg);
                    IMListener removeListener2 = ListenerManager.getInstance().removeListener(str);
                    if (removeListener2 instanceof ISendMessageListener) {
                        ((ISendMessageListener) removeListener2).onSendMessageResult(i, chatMsg);
                    }
                    if (chatMsg != null) {
                        ListenerManager.getInstance().removeListener(chatMsg.mListenerKey);
                    }
                }
            } catch (Exception e) {
                String str3 = TAG;
                LogUtils.e(str3, "onSendMessageResult exception " + e.getMessage());
            }
        }
    }

    public void onSendStudioMsgResult(int i, ChatMsg chatMsg, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048660, this, new Object[]{Integer.valueOf(i), chatMsg, Long.valueOf(j), str}) == null) {
            if (i != 0 && !hitMcastSendMsgErrorCode(i) && !this.mUseRequestSendMsg) {
                sendMessageRequest(chatMsg, str);
                return;
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(str);
            if (removeListener != null) {
                String str2 = TAG;
                LogUtils.w(str2, "onSendStudioMsgResult mIsChatRoom :" + this.mIsChatRoom + ", msg :" + chatMsg.toString());
                if (this.mIsChatRoom) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(chatMsg);
                    chatMsg = MessageParser.parseChatRoomMsg(mContext, arrayList).get(0);
                }
                if (removeListener instanceof ISendMessageListener) {
                    ((ISendMessageListener) removeListener).onSendMessageResult(i, chatMsg);
                } else if (removeListener instanceof BIMValueCallBack) {
                    SendMsgResponse sendMsgResponse = new SendMsgResponse();
                    sendMsgResponse.msg = chatMsg;
                    ((BIMValueCallBack) removeListener).onResult(i, "", sendMsgResponse);
                }
            } else {
                LogUtils.d(TAG, "ISendMessageListener is null");
            }
            updateChatMsgStatus(chatMsg, i);
            if (i != 0) {
                String str3 = TAG;
                LogUtils.d(str3, "onSendStudioMsgResult----errorCode: " + i);
            }
            if (chatMsg != null) {
                ListenerManager.getInstance().removeListener(chatMsg.mListenerKey);
            }
        }
    }

    public int deleteDBBusiMsgsByMsgId(int i, long j, long j2, int i2, long[] jArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), jArr})) == null) {
            if (i >= 0 && j >= 0 && j2 >= 0 && i2 >= 0) {
                if (AccountManager.isLogin(mContext)) {
                    if (i == 9 && BusinessMessageDBManager.getInstance(mContext).deleteLogicBusiMsgBatch(j, j2, i2, jArr) > 0) {
                        ChatMsgManager.getBusinessSessionFromServer(mContext.getApplicationContext(), (int) j2, i2, j, 0L, Long.MAX_VALUE, 1, new IMediaGetChatSessionListener(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.9
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ChatMsgManagerImpl this$0;

                            @Override // com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener
                            public void onMediaGetChatSessionResult(int i3, int i4, int i5, boolean z, List<ChatSession> list) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), list}) == null) {
                                }
                            }

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
                        });
                        return 1003;
                    }
                    return 1003;
                }
                return -1000;
            }
            return -1005;
        }
        return invokeCommon.intValue;
    }

    public ArrayList<ChatMsg> fetchGroupNotifyMsgsSync(int i, long j, int i2, boolean z, ChatMsg chatMsg) {
        InterceptResult invokeCommon;
        long msgId;
        long rowId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Boolean.valueOf(z), chatMsg})) == null) {
            if (1 == i) {
                return GroupMessageDAOImpl.fetchGroupSystemMsg(mContext, String.valueOf(j), chatMsg, i2, z);
            }
            ChatMessageDBManager chatMessageDBManager = ChatMessageDBManager.getInstance(mContext);
            ChatObject chatObject = getChatObject(i, j);
            if (chatMsg == null) {
                msgId = 0;
            } else {
                msgId = chatMsg.getMsgId();
            }
            long j2 = i2;
            if (chatMsg == null) {
                rowId = -1;
            } else {
                rowId = chatMsg.getRowId();
            }
            return chatMessageDBManager.fetchSpecifyMsgsSync(chatObject, 101, msgId, j2, rowId, z);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<ChatMsg> fetchMessageSync(int i, long j, int i2, boolean z, ChatMsg chatMsg) {
        InterceptResult invokeCommon;
        long msgId;
        long rowId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Boolean.valueOf(z), chatMsg})) == null) {
            if (1 == i) {
                return GroupMessageDAOImpl.fetchAllChatMsg(mContext, String.valueOf(j), chatMsg, i2, z);
            }
            if (AccountManager.getMediaRole(mContext)) {
                MediaMessageDBManager mediaMessageDBManager = MediaMessageDBManager.getInstance(mContext);
                ChatObject chatObject = getChatObject(i, j);
                if (chatMsg == null) {
                    msgId = 0;
                } else {
                    msgId = chatMsg.getMsgId();
                }
                long j2 = i2;
                if (chatMsg == null) {
                    rowId = -1;
                } else {
                    rowId = chatMsg.getRowId();
                }
                return mediaMessageDBManager.fetchMsg(chatObject, msgId, j2, rowId, z);
            }
            return ChatMessageDBManager.getInstance(mContext).fetchMsg(getChatObject(i, j), chatMsg, i2, z);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<ChatMsg> fetchMessageSyncExceptSystemMsg(int i, long j, int i2, boolean z, ChatMsg chatMsg) {
        InterceptResult invokeCommon;
        long msgId;
        long rowId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Boolean.valueOf(z), chatMsg})) == null) {
            if (1 == i) {
                return GroupMessageDAOImpl.fetchChatMsgExceptGroupSystem(mContext, String.valueOf(j), chatMsg, i2, z);
            }
            ChatMessageDBManager chatMessageDBManager = ChatMessageDBManager.getInstance(mContext);
            ChatObject chatObject = getChatObject(i, j);
            if (chatMsg == null) {
                msgId = 0;
            } else {
                msgId = chatMsg.getMsgId();
            }
            long j2 = i2;
            if (chatMsg == null) {
                rowId = -1;
            } else {
                rowId = chatMsg.getRowId();
            }
            return chatMessageDBManager.fetchMsgsExceptGroupSystemMsgSync(chatObject, msgId, j2, rowId, z);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public void getPaMsgByChatTypeAndPaidList(List<Integer> list, List<Long> list2, long j, int i, IFetchNotificationDataListener iFetchNotificationDataListener) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{list, list2, Long.valueOf(j), Integer.valueOf(i), iFetchNotificationDataListener}) == null) {
            if (AccountManager.isLogin(mContext) && iFetchNotificationDataListener != null) {
                if (Math.abs(i) > 20) {
                    i2 = 20;
                } else {
                    i2 = i;
                }
                TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, list, list2, j, i2, iFetchNotificationDataListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.11
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
                            Object[] objArr = {this, list, list2, Long.valueOf(j), Integer.valueOf(i2), iFetchNotificationDataListener};
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
                        this.val$chatTypes = list;
                        this.val$paids = list2;
                        this.val$msgid = j;
                        this.val$realCount = i2;
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

    public void meidaForwardMessage(long j, long j2, int i, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048649, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), chatMsg, iSendMessageListener}) == null) {
            if (i == 0) {
                if (j2 > 0) {
                    mediaForwardPa(j, j2, chatMsg, iSendMessageListener);
                } else if (j > 0) {
                    mediaForwardUser(j, chatMsg, iSendMessageListener);
                }
            } else if (i == 1) {
                forwardMessage(j, j2, i, chatMsg, new ISendMessageListener(this, iSendMessageListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.34
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$listener = iSendMessageListener;
                    }

                    @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
                    public void onSendMessageResult(int i2, ChatMsg chatMsg2) {
                        ISendMessageListener iSendMessageListener2;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, chatMsg2) == null) && (iSendMessageListener2 = this.val$listener) != null) {
                            iSendMessageListener2.onSendMessageResult(i2, chatMsg2);
                        }
                    }
                });
            }
        }
    }

    public void onMediaFetchChatMsgsResult(String str, int i, String str2, boolean z, List<ChatMsg> list) {
        IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048656, this, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z), list}) == null) && (iMediaFetchChatMsgsListener = (IMediaFetchChatMsgsListener) ListenerManager.getInstance().removeListener(str)) != null) {
            String str4 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("BC> responseCode=");
            sb.append(i);
            sb.append(", strMsg=");
            sb.append(str2);
            sb.append(", hasMore=");
            sb.append(z);
            sb.append(", msgs=");
            if (list != null) {
                str3 = list.toString();
            } else {
                str3 = "";
            }
            sb.append(str3);
            LogUtils.d(str4, sb.toString());
            iMediaFetchChatMsgsListener.onMediaFetchChatMsgsResult(i, str2, z, list);
        }
    }

    public void fetchConfigMsg(Context context, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            String str = TAG;
            LogUtils.i(str, " limit: " + j2 + " cursor: " + j);
            Intent creatMethodIntent = Utility.creatMethodIntent(context, 193);
            creatMethodIntent.putExtra(Constants.EXTRA_CONFIG_CURSOR, j);
            creatMethodIntent.putExtra(Constants.EXTRA_CONFIG_LIMIT, j2);
            try {
                x80.e(mContext).d(mContext, creatMethodIntent);
            } catch (Exception e) {
                LogUtils.e(TAG, "Exception ", e);
            }
        }
    }

    public void mediaSendChatMsg(long j, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{Long.valueOf(j), chatMsg, iMediaSendChatMsgListener}) == null) {
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

    public void fetchHistoryMessage(Context context, long j, ChatMsg chatMsg, int i, IFetchHistoryMsgListener iFetchHistoryMsgListener) {
        long msgId;
        Object obj;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{context, Long.valueOf(j), chatMsg, Integer.valueOf(i), iFetchHistoryMsgListener}) == null) {
            if (!AccountManager.isLogin(context)) {
                LogUtils.d(TAG, "fetchHistoryMessage Not login.");
                if (iFetchHistoryMsgListener != null) {
                    iFetchHistoryMsgListener.onFetchMsgResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, false, null);
                    return;
                }
                return;
            }
            if (chatMsg == null) {
                msgId = Long.MAX_VALUE;
            } else {
                msgId = chatMsg.getMsgId();
            }
            long j2 = msgId;
            boolean z2 = true;
            Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState = ChatMsgManager.fetchMessageSyncWithState(context, 1, j, i, chatMsg);
            if (fetchMessageSyncWithState != null && (obj = fetchMessageSyncWithState.second) != null && ((ArrayList) obj).size() > 0) {
                String str = TAG;
                LogUtils.d(str, "fetchHistoryMessage DB data count:" + ((ArrayList) fetchMessageSyncWithState.second).size());
                boolean isConnected = RequsetNetworkUtils.isConnected(mContext) ^ true;
                if (((ArrayList) fetchMessageSyncWithState.second).size() >= Math.abs(i) || isConnected) {
                    if (((ArrayList) fetchMessageSyncWithState.second).size() >= Math.abs(i)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z || !isConnected) {
                        z2 = z;
                    }
                    if (Constants.isDebugMode()) {
                        for (int i2 = 0; i2 < ((ArrayList) fetchMessageSyncWithState.second).size(); i2++) {
                            ChatMsg chatMsg2 = (ChatMsg) ((ArrayList) fetchMessageSyncWithState.second).get(i2);
                            if (chatMsg2 != null) {
                                String str2 = TAG;
                                LogUtils.d(str2, "DB data[" + i2 + PreferencesUtil.RIGHT_MOUNT + chatMsg2.toJsonString());
                            }
                        }
                    }
                    LogUtils.d(TAG, "fetchHistoryMessage load history from DB end.");
                    if (iFetchHistoryMsgListener != null) {
                        iFetchHistoryMsgListener.onFetchMsgResult(0, Constants.ERROR_MSG_SUCCESS, z2, (List) fetchMessageSyncWithState.second);
                        return;
                    }
                    return;
                }
            }
            String addListener = ListenerManager.getInstance().addListener(new IFetchHistoryMsgListener(this, iFetchHistoryMsgListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatMsgManagerImpl this$0;
                public final /* synthetic */ IFetchHistoryMsgListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iFetchHistoryMsgListener};
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
                    this.val$listener = iFetchHistoryMsgListener;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IFetchHistoryMsgListener
                public void onFetchMsgResult(int i3, String str3, boolean z3, List<ChatMsg> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), str3, Boolean.valueOf(z3), list}) == null) {
                        String str4 = ChatMsgManagerImpl.TAG;
                        LogUtils.d(str4, "fetchHistoryMessage Net code=" + i3 + ",msg=" + str3 + ",hasMore=" + z3);
                        if (Constants.isDebugMode() && list != null) {
                            String str5 = ChatMsgManagerImpl.TAG;
                            LogUtils.d(str5, "Net data count:" + list.size());
                            for (int i4 = 0; i4 < list.size(); i4++) {
                                ChatMsg chatMsg3 = list.get(i4);
                                if (chatMsg3 != null) {
                                    String str6 = ChatMsgManagerImpl.TAG;
                                    LogUtils.d(str6, "Net data[" + i4 + PreferencesUtil.RIGHT_MOUNT + chatMsg3.toJsonString());
                                }
                            }
                        }
                        LogUtils.d(ChatMsgManagerImpl.TAG, "fetchHistoryMessage from Net end.");
                        IFetchHistoryMsgListener iFetchHistoryMsgListener2 = this.val$listener;
                        if (iFetchHistoryMsgListener2 != null) {
                            iFetchHistoryMsgListener2.onFetchMsgResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, z3, list);
                        }
                    }
                }
            });
            String str3 = TAG;
            LogUtils.d(str3, "fetchHistoryMessage contacter: " + j + " endMsgid: " + j2 + " count: " + i + " key: " + addListener);
            Intent creatMethodIntent = Utility.creatMethodIntent(context, 93);
            creatMethodIntent.putExtra("category", 1);
            creatMethodIntent.putExtra("contacter", j);
            creatMethodIntent.putExtra(Constants.EXTRA_BEGIN_MSGID, 0L);
            creatMethodIntent.putExtra(Constants.EXTRA_END_MSGID, j2);
            creatMethodIntent.putExtra("count", i);
            creatMethodIntent.putExtra(Constants.EXTRA_TRIGGER_REASON, 1);
            creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            creatMethodIntent.putExtra(Constants.EXTRA_JUMP_MSG, 0);
            creatMethodIntent.putExtra(Constants.EXTRA_RETRY_TIME, 0);
            try {
                x80.e(mContext).d(mContext, creatMethodIntent);
            } catch (Exception e) {
                onFetchMsgByIdResult(6, "start service exception", 1, j, 0L, j2, i, -1, 0L, null, null, addListener);
                LogUtils.e(TAG, "fetchHistoryMessage Exception ", e);
            }
        }
    }

    public ArrayList<ChatMsg> fetchMessageSync(int i, long j, int i2, ChatMsg chatMsg) {
        InterceptResult invokeCommon;
        long msgId;
        long rowId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), chatMsg})) == null) {
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
            ChatMessageDBManager chatMessageDBManager = ChatMessageDBManager.getInstance(mContext);
            ChatObject chatObject = getChatObject(i, j);
            if (chatMsg == null) {
                msgId = 0;
            } else {
                msgId = chatMsg.getMsgId();
            }
            long j2 = msgId;
            long j3 = i2;
            if (chatMsg == null) {
                rowId = -1;
            } else {
                rowId = chatMsg.getRowId();
            }
            return chatMessageDBManager.fetchMsg(chatObject, j2, j3, rowId);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public void onSendConsultMsgResult(int i, ChatMsg chatMsg, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048658, this, new Object[]{Integer.valueOf(i), chatMsg, Long.valueOf(j), str}) == null) {
            if (j != -1) {
                chatMsg.setMsgTime(j);
            }
            if (i == 0) {
                chatMsg.setStatus(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(chatMsg);
                if (BusinessMessageDBManager.getInstance(mContext).insertBusinessChatMsg(chatMsg.getBusinessType(), arrayList) >= 0) {
                    BusinessMessageDBManager.getInstance(mContext).updateBusiChatSession(chatMsg.getBusinessType(), chatMsg);
                }
            } else {
                chatMsg.setStatus(2);
                MessageUbc.DebugInfo debugInfo = new MessageUbc.DebugInfo();
                debugInfo.clientSource = ChatMsgManagerImpl.class.getSimpleName() + "_onSendConsultMsgResult";
                debugInfo.msgId = chatMsg.getMsgId();
                MessageUbc.uploadUbc(mContext, i, UBCConstants.SEND_FAIL_RECORD_UBC, debugInfo, chatMsg);
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(str);
            if (removeListener instanceof ISendMessageListener) {
                ((ISendMessageListener) removeListener).onSendMessageResult(i, chatMsg);
            }
        }
    }

    public ArrayList<ChatMsg> fetchMessageSync(int i, long j, int i2, ChatMsg chatMsg, long[] jArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), chatMsg, jArr})) == null) {
            return GroupMessageDAOImpl.fetchAllChatMsg(mContext, String.valueOf(j), chatMsg, i2, true, jArr);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public void fetchMsgByHostRequst(long j, int i, long j2, long j3, long j4, int i2, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2), iFetchMsgByIdListener, Boolean.valueOf(z)}) == null) {
            String str = TAG;
            LogUtils.d(str, "fetchMsgByHostRequst ---> begin :" + j3 + ", end :" + j4);
            String addListener = ListenerManager.getInstance().addListener(iFetchMsgByIdListener);
            Context context = mContext;
            IMNewFetchMsgRequest iMNewFetchMsgRequest = new IMNewFetchMsgRequest(context, addListener, Utility.getAppId(context), j, j2, i, i2, j3, j4, z);
            HttpHelper.executor(mContext, iMNewFetchMsgRequest, iMNewFetchMsgRequest);
        }
    }

    public boolean setServerMsgRead(int i, int i2, int i3, long j, long j2, long j3, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048704, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), str})) == null) {
            Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 67);
            creatMethodIntent.putExtra("category", i3);
            creatMethodIntent.putExtra("contacter", j);
            creatMethodIntent.putExtra(Constants.EXTRA_BEGIN_MSGID, j2);
            creatMethodIntent.putExtra(Constants.EXTRA_CLIENT_MAX_MSGID, j3);
            creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, z);
            if (!TextUtils.isEmpty(str)) {
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, str);
            }
            if (i != 0) {
                creatMethodIntent.putExtra(Constants.EXTRA_BUSINESS_TYPE, i);
            }
            if (i2 >= 0) {
                creatMethodIntent.putExtra("session_type", i2);
            }
            try {
                x80.e(mContext).d(mContext, creatMethodIntent);
                return true;
            } catch (Exception e) {
                LogUtils.e(TAG, "setServerMsgRead Exception ", e);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public void fetchMsgRequst(long j, long j2, int i, long j3, long j4, long j5, int i2, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z, boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i2), iFetchMsgByIdListener, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            String str = TAG;
            LogUtils.d(str, "fetchMsgRequst ---> begin :" + j4 + ", end :" + j5);
            IMNewFetchMsgRequest iMNewFetchMsgRequest = new IMNewFetchMsgRequest(mContext, ListenerManager.getInstance().addListener(iFetchMsgByIdListener), j, j2, j3, i, i2, j4, j5, z);
            iMNewFetchMsgRequest.setIsChatRoom(z2, i3);
            HttpHelper.executor(mContext, iMNewFetchMsgRequest, iMNewFetchMsgRequest);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFetchBusinessMsgResult(int i, String str, long j, long j2, int i2, long j3, boolean z, int i3, int i4, ArrayList<ChatMsg> arrayList, String str2) {
        int i5;
        IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048651, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), arrayList, str2}) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (i == 0) {
                BusinessMessageDBManager.getInstance(mContext).insertBusinessChatMsg(i3, arrayList);
                if (arrayList != null && arrayList.size() > 0) {
                    arrayList2.addAll(arrayList);
                }
            } else {
                List<ChatMsg> businessChatMsgs = BusinessMessageDBManager.getInstance(mContext).getBusinessChatMsgs(i3, i4, j3, j, j2, i2);
                if (businessChatMsgs != null && businessChatMsgs.size() > 0) {
                    arrayList2.addAll(businessChatMsgs);
                    i5 = 0;
                    iMediaFetchChatMsgsListener = (IMediaFetchChatMsgsListener) ListenerManager.getInstance().removeListener(str2);
                    if (iMediaFetchChatMsgsListener == null) {
                        iMediaFetchChatMsgsListener.onMediaFetchChatMsgsResult(i5, str, z, arrayList2);
                        return;
                    }
                    return;
                }
            }
            i5 = i;
            iMediaFetchChatMsgsListener = (IMediaFetchChatMsgsListener) ListenerManager.getInstance().removeListener(str2);
            if (iMediaFetchChatMsgsListener == null) {
            }
        }
    }

    public void fetchMsgidByMsgid(Context context, int i, long j, long j2, long j3, int i2, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iFetchMsgByIdListener}) == null) {
            fetchMsgidByMsgid(context, i, j, j2, j3, -1L, -1L, "", i2, i3, i4, iFetchMsgByIdListener, 0);
        }
    }

    public void getChatMsgsByBusinessByHostRequest(int i, int i2, int i3, long j, long j2, long j3, int i4, String str, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i4), str, iMediaFetchChatMsgsListener}) == null) {
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                IMFetchBusinessMsgRequest iMFetchBusinessMsgRequest = new IMFetchBusinessMsgRequest(mContext, i, i3, i2, j, j2, j3, i4, str, iMediaFetchChatMsgsListener);
                HttpHelper.executor(mContext, iMFetchBusinessMsgRequest, iMFetchBusinessMsgRequest);
            } else if (iMediaFetchChatMsgsListener != null) {
                iMediaFetchChatMsgsListener.onMediaFetchChatMsgsResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, false, null);
            }
        }
    }

    public void fetchMsgidByMsgid(Context context, int i, long j, long j2, long j3, long j4, long j5, String str, int i2, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iFetchMsgByIdListener}) == null) {
            fetchMsgidByMsgid(context, i, j, j2, j3, j4, j5, str, i2, i3, i4, iFetchMsgByIdListener, 0);
        }
    }

    public void onFetchMsgByIdResult(int i, String str, int i2, long j, long j2, long j3, int i3, int i4, long j4, String str2, ArrayList<ChatMsg> arrayList, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048652, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j4), str2, arrayList, str3}) == null) {
            onFetchMsgByIdResult(i, str, i2, j, j2, j3, i3, i4, j4, str2, arrayList, str3, "");
        }
    }

    public void fetchMsgidByMsgid(Context context, int i, long j, long j2, long j3, long j4, long j5, String str, int i2, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener, int i5) {
        Intent creatMethodIntent;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iFetchMsgByIdListener, Integer.valueOf(i5)}) == null) {
            String addListener = ListenerManager.getInstance().addListener(iFetchMsgByIdListener);
            String str4 = TAG;
            LogUtils.i(str4, " category: " + i + " contacter: " + j + " beginMsgid: " + j2 + " endMsgid: " + j3 + " count: " + i2 + " notifyMsgId: " + j4 + " notifyId: " + j5 + " triggerReason: " + i3 + " jumpToRecentMsg: " + i4 + " key: " + addListener);
            if (j2 >= 0 && j3 >= 0) {
                if (AccountManager.isLogin(context)) {
                    if (i == 4) {
                        creatMethodIntent = Utility.createMcastMethodIntent(context, 93);
                    } else {
                        creatMethodIntent = Utility.creatMethodIntent(context, 93);
                    }
                    if (j5 > 0 && !AccountManager.getMediaRole(context) && i == 0) {
                        str2 = addListener;
                        str3 = Utility.appendEventList(str, "CIMEnqueueFetch");
                    } else {
                        str2 = addListener;
                        str3 = str;
                    }
                    creatMethodIntent.putExtra("category", i);
                    creatMethodIntent.putExtra("contacter", j);
                    creatMethodIntent.putExtra(Constants.EXTRA_BEGIN_MSGID, j2);
                    creatMethodIntent.putExtra(Constants.EXTRA_END_MSGID, j3);
                    creatMethodIntent.putExtra(Constants.EXTRA_NOTIFY_MSGID, j4);
                    creatMethodIntent.putExtra(Constants.EXTRA_NOTIFY_ID, j5);
                    creatMethodIntent.putExtra("event_list", str3);
                    creatMethodIntent.putExtra("count", i2);
                    creatMethodIntent.putExtra(Constants.EXTRA_TRIGGER_REASON, i3);
                    creatMethodIntent.putExtra(Constants.EXTRA_BC_FETCH_TRIGGER_REASON, i3);
                    String str5 = str2;
                    creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, str5);
                    creatMethodIntent.putExtra(Constants.EXTRA_JUMP_MSG, i4);
                    creatMethodIntent.putExtra(Constants.EXTRA_RETRY_TIME, i5);
                    try {
                        x80.e(mContext).d(mContext, creatMethodIntent);
                        return;
                    } catch (Exception e) {
                        onFetchMsgByIdResult(6, "start service exception", i, j, j2, j3, i2, -1, 0L, null, null, str5);
                        LogUtils.e(TAG, "Exception ", e);
                        return;
                    }
                }
                LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                onFetchMsgByIdResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, i, j, j2, j3, i2, -1, 0L, null, null, addListener);
                return;
            }
            onFetchMsgByIdResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, i, j, j2, j3, i2, -1, 0L, null, null, addListener);
        }
    }

    public void fetchPaChatMsgs(int i, int i2, long j, long j2, long j3, int i3, IFetchMessageListener iFetchMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), iFetchMessageListener}) == null) {
            if (AccountManager.isLogin(mContext)) {
                if (AccountManager.getMediaRole(mContext)) {
                    mediaFetchChatMsgs(mContext, j, Utility.getBusinessType(i, i2), j, PaManagerImpl.getInstance(mContext).getPaThirdId(j), 0L, j3 - 1, i3, new IMediaFetchChatMsgsListener(this, iFetchMessageListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.25
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
                    TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, j, j2, i3, iFetchMessageListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.26
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
                                ArrayList<ChatMsg> fetchMsgByContacterIdOrderByMsgid = ChatMessageDBManager.getInstance(ChatMsgManagerImpl.mContext).fetchMsgByContacterIdOrderByMsgid(arrayList, this.val$msgid, this.val$count);
                                if (fetchMsgByContacterIdOrderByMsgid != null && fetchMsgByContacterIdOrderByMsgid.size() > 0) {
                                    Iterator<ChatMsg> it = fetchMsgByContacterIdOrderByMsgid.iterator();
                                    while (it.hasNext()) {
                                        String str = ChatMsgManagerImpl.TAG;
                                        LogUtils.d(str, "c fetchPaChatMsgs msg = " + it.next().toJsonString());
                                    }
                                }
                                this.val$listener.onFetchMessageResult(0, fetchMsgByContacterIdOrderByMsgid);
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

    public void handleConsultMsgNotify(int i, int i2, long j, int i3, long j2, long j3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048637, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3), str}) == null) {
            String str2 = TAG;
            LogUtils.i(str2, "handleConsultMsgNotify businessType=" + i + " imUk = " + j + " type = " + i3 + " msgid = " + j2 + ", notifyId :" + j3 + ", eventList :" + str);
            synchronized (this.mConsultMsgNotifyListeners) {
                if (this.mConsultMsgNotifyListeners != null && !this.mConsultMsgNotifyListeners.isEmpty()) {
                    TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, i3, j, i, i2, j2, j3, str) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.33
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ChatMsgManagerImpl this$0;
                        public final /* synthetic */ int val$businessType;
                        public final /* synthetic */ String val$eventList;
                        public final /* synthetic */ long val$imUk;
                        public final /* synthetic */ long val$msgid;
                        public final /* synthetic */ long val$notifyId;
                        public final /* synthetic */ int val$sessionType;
                        public final /* synthetic */ int val$type;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r3;
                                Object[] objArr = {this, Integer.valueOf(i3), Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), str};
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
                            this.val$type = i3;
                            this.val$imUk = j;
                            this.val$businessType = i;
                            this.val$sessionType = i2;
                            this.val$msgid = j2;
                            this.val$notifyId = j3;
                            this.val$eventList = str;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                for (Integer num : this.this$0.mConsultMsgNotifyListeners.keySet()) {
                                    int intValue = num.intValue();
                                    if (this.this$0.mConsultMsgNotifyListeners.get(Integer.valueOf(intValue)) instanceof IChatMsgNotifyChangedListener) {
                                        IChatMsgNotifyChangedListener iChatMsgNotifyChangedListener = (IChatMsgNotifyChangedListener) this.this$0.mConsultMsgNotifyListeners.get(Integer.valueOf(intValue));
                                        if (iChatMsgNotifyChangedListener != null) {
                                            iChatMsgNotifyChangedListener.onChatMsgChangedResult(this.val$type, this.val$imUk, this.val$businessType, this.val$sessionType, this.val$msgid, this.val$notifyId, this.val$eventList);
                                        }
                                    } else {
                                        IChatMsgChangedListener iChatMsgChangedListener = (IChatMsgChangedListener) this.this$0.mConsultMsgNotifyListeners.get(Integer.valueOf(intValue));
                                        if (iChatMsgChangedListener != null) {
                                            iChatMsgChangedListener.onChatMsgChangedResult(this.val$type, this.val$imUk, this.val$businessType, this.val$sessionType, this.val$msgid);
                                        }
                                    }
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    public void mediaDeleteChatMsg(long j, int i, long j2, String str, long j3, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048641, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), list, iMediaDeleteChatMsgListener}) == null) {
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

    public void sendBusinessImNotifyMsg(int i, long j, int i2, int i3, int i4, String str, IStatusNotifyListener iStatusNotifyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048682, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, iStatusNotifyListener}) == null) {
            LogUtils.d(TAG, "sendCustomNotifyMsg start");
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, Constants.METHOD_IM_CONSULT_IM_UPDATE_MSG);
                String addListener = ListenerManager.getInstance().addListener(iStatusNotifyListener);
                creatMethodIntent.putExtra("contacter", j);
                creatMethodIntent.putExtra(Constants.EXTRA_BUSINESS_TYPE, i2);
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                creatMethodIntent.putExtra("session_type", i4);
                creatMethodIntent.putExtra("notify_type", i);
                creatMethodIntent.putExtra("category", i3);
                creatMethodIntent.putExtra(Constants.EXTRA_BUSINESS_MSG_EXT, str);
                try {
                    x80.e(mContext).d(mContext, creatMethodIntent);
                    return;
                } catch (Exception e) {
                    LogUtils.e(TAG, "sendCustomNotifyMsg Exception ", e);
                    ListenerManager.getInstance().removeListener(addListener);
                    if (iStatusNotifyListener != null) {
                        iStatusNotifyListener.onResult(1003, Constants.ERROR_MSG_SERVER_INTERNAL_ERROR);
                        return;
                    }
                    return;
                }
            }
            if (iStatusNotifyListener != null) {
                iStatusNotifyListener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            }
            LogUtils.d(TAG, "sendCustomNotifyMsg not login");
        }
    }

    public void genBosObjectUrl(String str, String str2, String str3, int i, int i2, int i3, IGenBosObjectUrlListener iGenBosObjectUrlListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iGenBosObjectUrlListener}) == null) {
            String str4 = TAG;
            LogUtils.d(str4, "filePath=" + str);
            IMGenBosObjectUrlRequest iMGenBosObjectUrlRequest = new IMGenBosObjectUrlRequest(mContext, str, str2, str3, i, i2, i3, ListenerManager.getInstance().addListener(iGenBosObjectUrlListener));
            HttpHelper.executor(mContext, iMGenBosObjectUrlRequest, iMGenBosObjectUrlRequest);
        }
    }

    public boolean setServerMsgRead(int i, int i2, int i3, long j, long j2, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048705, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), str})) == null) {
            Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 67);
            creatMethodIntent.putExtra("category", i3);
            creatMethodIntent.putExtra("contacter", j);
            creatMethodIntent.putExtra(Constants.EXTRA_CLIENT_MAX_MSGID, j2);
            creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, z);
            if (!TextUtils.isEmpty(str)) {
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, str);
            }
            if (i != 0) {
                creatMethodIntent.putExtra(Constants.EXTRA_BUSINESS_TYPE, i);
            }
            if (i2 >= 0) {
                creatMethodIntent.putExtra("session_type", i2);
            }
            try {
                x80.e(mContext).d(mContext, creatMethodIntent);
                return true;
            } catch (Exception e) {
                LogUtils.e(TAG, "setServerMsgRead Exception ", e);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public ArrayList<Long> getCachedConfigMsgIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
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
                }
            }
            LogUtils.d(TAG, "getCachedConfigMsgIds back arr size = " + arrayList.size());
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void getChatMsgsByBCPByHostRequest(int i, long j, long j2, long j3, int i2, String str, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), str, iMediaFetchChatMsgsListener}) == null) {
            IMFetchBusinessMsgRequest iMFetchBusinessMsgRequest = new IMFetchBusinessMsgRequest(mContext, 4, i, 0, j, j2, j3, i2, str, iMediaFetchChatMsgsListener);
            HttpHelper.executor(mContext, iMFetchBusinessMsgRequest, iMFetchBusinessMsgRequest);
        }
    }

    public void getChatMsgsByBusiness(int i, int i2, int i3, long j, long j2, long j3, int i4, long j4, long j5, String str, String str2, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i4), Long.valueOf(j4), Long.valueOf(j5), str, str2, iMediaFetchChatMsgsListener}) == null) {
            int i5 = 1000;
            if (!BIMManager.isIMLogined(mContext)) {
                LogUtils.d(TAG, "getChatMsgsByBusiness im not login, triggle im relogin");
                LoginManager.getInstance(mContext).triggleLogoutListener(1000, Constants.ERROR_LOGIN_STATE_ERROR);
                List<ChatMsg> businessChatMsgs = BusinessMessageDBManager.getInstance(mContext).getBusinessChatMsgs(i, i2, j, j2, j3, i4);
                if (businessChatMsgs != null && businessChatMsgs.size() > 0) {
                    i5 = 0;
                }
                if (iMediaFetchChatMsgsListener != null) {
                    iMediaFetchChatMsgsListener.onMediaFetchChatMsgsResult(i5, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, false, businessChatMsgs);
                    CaseUbc.DebugInfo debugInfo = new CaseUbc.DebugInfo();
                    debugInfo.curClassName = "getChatMsgsByBusiness";
                    debugInfo.extInfo = ", contacterImUk = " + j;
                    StringBuilder sb = new StringBuilder();
                    sb.append(debugInfo.extInfo);
                    sb.append(",chatmsg = ");
                    if (businessChatMsgs != null && businessChatMsgs.size() > 0) {
                        obj = Long.valueOf(businessChatMsgs.get(0).getMsgId());
                    } else {
                        obj = StringUtil.NULL_STRING;
                    }
                    sb.append(obj);
                    debugInfo.extInfo = sb.toString();
                    CaseUbc.debugUbc(mContext, "Business", i5, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, debugInfo);
                }
            } else if (AccountManager.isCuidLogin(mContext)) {
                if (iMediaFetchChatMsgsListener != null) {
                    iMediaFetchChatMsgsListener.onMediaFetchChatMsgsResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, false, null);
                }
            } else {
                String str3 = TAG;
                LogUtils.e(str3, "getChatMsgsByBusiness start notifyId :" + j5 + ", eventList :" + str);
                String addListener = ListenerManager.getInstance().addListener(iMediaFetchChatMsgsListener);
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 93);
                creatMethodIntent.putExtra("contacter", j);
                creatMethodIntent.putExtra("count", i4);
                creatMethodIntent.putExtra(Constants.EXTRA_BUSINESS_TYPE, i);
                creatMethodIntent.putExtra(Constants.EXTRA_BEGIN_MSGID, j2);
                creatMethodIntent.putExtra(Constants.EXTRA_END_MSGID, j3);
                creatMethodIntent.putExtra(Constants.EXTRA_NOTIFY_MSGID, j4);
                creatMethodIntent.putExtra(Constants.EXTRA_NOTIFY_ID, j5);
                creatMethodIntent.putExtra("event_list", str);
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                creatMethodIntent.putExtra("category", i3);
                creatMethodIntent.putExtra(Constants.EXTRA_TRIGGER_REASON, 3);
                creatMethodIntent.putExtra("session_type", i2);
                creatMethodIntent.putExtra("source", str2);
                try {
                    x80.e(mContext).d(mContext, creatMethodIntent);
                } catch (Exception e) {
                    LogUtils.e(TAG, "getChatMsgsByBusiness Exception ", e);
                    onFetchBusinessMsgResult(1003, "", j2, j3, i4, j, false, i, i2, null, addListener);
                }
            }
        }
    }

    public List<ChatMsg> getPaMsgByChatType(List<Integer> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048631, this, list, i)) == null) {
            if (AccountManager.isLogin(mContext)) {
                return ChatMessageDBManager.getInstance(mContext).getPaMsgByChatTypeAndPaidList(list, null, 0L, i);
            }
            return null;
        }
        return (List) invokeLI.objValue;
    }

    public int markMessageClicked(ChatMsg chatMsg) {
        InterceptResult invokeL;
        boolean z;
        PaInfo queryPaInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, chatMsg)) == null) {
            boolean z2 = true;
            chatMsg.setIsClicked(true);
            if (AccountManager.getMediaRole(mContext) && chatMsg.getCategory() != 1) {
                z = false;
            } else {
                z = true;
            }
            if (z || (chatMsg.getContacter() & 17592186044416L) == 0 || (queryPaInfo = PaInfoDBManager.getInstance(mContext).queryPaInfo(chatMsg.getContacter())) == null || queryPaInfo.getClassType() <= 0 || queryPaInfo.getClassshow() <= 0) {
                z2 = z;
            }
            if (z2) {
                return ChatMessageDBManager.getInstance(mContext).markMsgClicked(chatMsg);
            }
            return MediaMessageDBManager.getInstance(mContext).markMsgClicked(chatMsg);
        }
        return invokeL.intValue;
    }

    public void setMaxNotifyMsgid(ChatMsg chatMsg) {
        DialogRecord dialogRecord;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048699, this, chatMsg) == null) && chatMsg != null && chatMsg.getStatus() == 0) {
            int category = chatMsg.getCategory();
            long contacter = chatMsg.getContacter();
            long msgId = chatMsg.getMsgId();
            String str = TAG;
            LogUtils.d(str, "setMaxNotifyMsgid msgid = " + msgId + " category = " + category + " contacter = " + contacter);
            if (category == 1 && (dialogRecord = DialogRecordDBManager.getInstance(mContext).getDialogRecord(category, contacter)) != null && dialogRecord.getMaxMsgid() < msgId) {
                dialogRecord.setMaxMsgid(msgId);
                DialogRecordDBManager.getInstance(mContext).add(dialogRecord);
            }
        }
    }

    public void unRegisterNotify(IOnRegisterNotifyListener iOnRegisterNotifyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, iOnRegisterNotifyListener) == null) {
            String addListener = ListenerManager.getInstance().addListener(iOnRegisterNotifyListener);
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                try {
                    BindStateManager.saveUnBindInfo(mContext, AccountManager.getToken(mContext), Utility.getIMDeviceId(mContext), Long.valueOf(AccountManager.getUK(mContext)));
                    Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 92);
                    creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                    x80.e(mContext).d(mContext, creatMethodIntent);
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

    public void mediaFetchChatMsgs(Context context, long j, int i, long j2, String str, long j3, long j4, int i2, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2), iMediaFetchChatMsgsListener}) == null) {
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

    public void mediaFetchChatMsgs(Context context, long j, long j2, long j3, int i, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048644, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), iMediaFetchChatMsgsListener}) == null) {
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

    public void mediaSendChatMsg(long j, int i, long j2, String str, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, chatMsg, iMediaSendChatMsgListener}) == null) {
            String str2 = TAG;
            LogUtils.d(str2, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", listener=" + iMediaSendChatMsgListener + ", sendMsg=" + chatMsg);
            if (iMediaSendChatMsgListener != null && !AccountManager.getMediaRole(mContext)) {
                iMediaSendChatMsgListener.onMediaSendChatMsgResult(2000, chatMsg);
                return;
            }
            IMMediaSendMsgHttpRequest iMMediaSendMsgHttpRequest = new IMMediaSendMsgHttpRequest(mContext, j, i, j2, str, chatMsg, ListenerManager.getInstance().addListener(iMediaSendChatMsgListener));
            HttpHelper.executor(mContext, iMMediaSendMsgHttpRequest, iMMediaSendMsgHttpRequest);
        }
    }

    public int sendDelMsgs(int i, int i2, int i3, long j, long[] jArr, IDelBusinessMsgListener iDelBusinessMsgListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048686, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), jArr, iDelBusinessMsgListener})) == null) {
            if (i >= 0 && j >= 0 && jArr != null && jArr.length > 0) {
                if (AccountManager.isLogin(mContext)) {
                    if (i == 9) {
                        String addListener = ListenerManager.getInstance().addListener(iDelBusinessMsgListener);
                        Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 57);
                        creatMethodIntent.putExtra("category", i);
                        creatMethodIntent.putExtra("contacter", j);
                        creatMethodIntent.putExtra(Constants.EXTRA_BUSINESS_TYPE, i2);
                        creatMethodIntent.putExtra("session_type", i3);
                        creatMethodIntent.putExtra(Constants.EXTRA_DEL_MSG_IDS, jArr);
                        creatMethodIntent.putExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, false);
                        creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                        try {
                            x80.e(mContext).d(mContext, creatMethodIntent);
                        } catch (Exception e) {
                            LogUtils.e(TAG, "Exception ", e);
                        }
                        return 0;
                    }
                    return 1003;
                }
                return -1000;
            }
            return -1005;
        }
        return invokeCommon.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFetchMsgByIdResult(int i, String str, int i2, long j, long j2, long j3, int i3, int i4, long j4, String str2, ArrayList<ChatMsg> arrayList, String str3, String str4) {
        int size;
        int i5;
        boolean z;
        ScreenUbc.MethodInfo screenMethodInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048653, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j4), str2, arrayList, str3, str4}) == null) {
            if (arrayList != null) {
                String str5 = TAG;
                LogUtils.d(str5, "onFetchMsgByIdResult----errorCode: " + i + " msg:" + str + ", contacter:" + j + ",fetchedMsgs size " + arrayList.size());
            } else {
                String str6 = TAG;
                LogUtils.d(str6, "onFetchMsgByIdResult----errorCode: " + i + " msg:" + str + ", contacter:" + j + ",fetchedMsgs is null.");
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(str3);
            if (removeListener instanceof IFetchMsgByIdListener) {
                ((IFetchMsgByIdListener) removeListener).onFetchMsgByIdResult(i, str, str2, i2, j, j2, j3, i3, i4, j4, arrayList);
            } else {
                if (removeListener instanceof IFetchHistoryMsgListener) {
                    IFetchHistoryMsgListener iFetchHistoryMsgListener = (IFetchHistoryMsgListener) removeListener;
                    if (iFetchHistoryMsgListener != null) {
                        if (arrayList == null) {
                            i5 = i4;
                            size = 0;
                        } else {
                            size = arrayList.size();
                            i5 = i4;
                        }
                        if (i5 >= size) {
                            z = true;
                        } else {
                            z = false;
                        }
                        iFetchHistoryMsgListener.onFetchMsgResult(i, str, z, arrayList);
                    }
                } else {
                    LogUtils.i(TAG, "onFetchMsgByIdResult listener is null or error!!");
                }
                if (!TextUtils.isEmpty("screenKey") && (screenMethodInfo = Utility.getScreenMethodInfo(str4)) != null) {
                    screenMethodInfo.errCode = i;
                    screenMethodInfo.errMsg = str;
                    screenMethodInfo.endTime = System.currentTimeMillis();
                    ScreenUbc.onEvent(mContext, str4, screenMethodInfo);
                }
                if (i != 0) {
                    this.mIsFetchRetry.set(true);
                } else if (i == 8004 && this.mIsFetchRetry.get()) {
                    LogUtils.i(TAG, "fetch 8004, retry");
                    fetchMsgidByMsgid(mContext, i2, j, j2, j3, -1L, -1L, "", i3, 0, 0, null, i4);
                    this.mIsFetchRetry.set(false);
                    return;
                }
            }
            if (!TextUtils.isEmpty("screenKey")) {
                screenMethodInfo.errCode = i;
                screenMethodInfo.errMsg = str;
                screenMethodInfo.endTime = System.currentTimeMillis();
                ScreenUbc.onEvent(mContext, str4, screenMethodInfo);
            }
            if (i != 0) {
            }
        }
    }

    public void onGenBosObjectUrl(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048654, this, new Object[]{str, Integer.valueOf(i), str2, str3, str4, map}) == null) {
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

    public void registerConsultMsgNotifyListener(IChatMsgNotifyChangedListener iChatMsgNotifyChangedListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048666, this, iChatMsgNotifyChangedListener) == null) && iChatMsgNotifyChangedListener != null) {
            this.mConsultMsgNotifyListeners.put(Integer.valueOf(iChatMsgNotifyChangedListener.hashCode()), iChatMsgNotifyChangedListener);
        }
    }

    public void unRegisterConsultMsgNotifyListener(IChatMsgNotifyChangedListener iChatMsgNotifyChangedListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048708, this, iChatMsgNotifyChangedListener) == null) && iChatMsgNotifyChangedListener != null) {
            this.mConsultMsgNotifyListeners.remove(Integer.valueOf(iChatMsgNotifyChangedListener.hashCode()));
        }
    }

    public void sendHiddenMsg(@NonNull ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Intent creatMethodIntent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048687, this, chatMsg, iSendMessageListener) == null) {
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
                if (chatMsg.getCategory() == 4) {
                    creatMethodIntent = Utility.createMcastMethodIntent(mContext, 55);
                } else {
                    creatMethodIntent = Utility.creatMethodIntent(mContext, 55);
                }
                creatMethodIntent.putExtra(Constants.EXTRA_SEND_MSG, chatMsg);
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                try {
                    x80.e(mContext).d(mContext, creatMethodIntent);
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

    public void sendMessageBroadcast(Context context, ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048689, this, context, chatMsg) != null) || chatMsg == null) {
            return;
        }
        try {
            String str = TAG;
            LogUtils.d(str, "删除【1016】消息====> msg:" + chatMsg);
            if (chatMsg instanceof GroupMessageDeleteMsg) {
                GroupMessageDeleteMsg groupMessageDeleteMsg = (GroupMessageDeleteMsg) chatMsg;
                String uid = AccountManager.getUid(context);
                if (!TextUtils.isEmpty(uid) && uid.equals(groupMessageDeleteMsg.getOperator())) {
                    return;
                }
                getInstance(mContext).deleteMsgs(chatMsg.getCategory(), chatMsg.getContacter(), new long[]{groupMessageDeleteMsg.getDelMsgId()}, false);
                Intent intent = new Intent(IMConstants.MESSAGE_DELETE_ACTION);
                intent.setPackage(context.getApplicationContext().getPackageName());
                intent.putExtra(IMConstants.MESSAGE, chatMsg);
                mContext.sendBroadcast(intent);
            }
        } catch (Exception unused) {
            LogUtils.e(TAG, " sendMessageBoradcast exception ");
        }
    }

    public void sendPaChatMsg(int i, int i2, long j, int i3, String str, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048693, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), str, iSendMessageListener}) == null) {
            ChatMsg buildChatMsg = buildChatMsg(i, 0, j, i3, str);
            if (buildChatMsg == null) {
                if (iSendMessageListener != null) {
                    iSendMessageListener.onSendMessageResult(1005, null);
                    return;
                }
                return;
            }
            buildChatMsg.setBusinessType(Utility.getBusinessType(i, i2));
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(Constants.EXTRA_BUSINESS_MSG_EXT)) {
                    buildChatMsg.setSendMsgTime(new JSONObject(jSONObject.optString(Constants.EXTRA_BUSINESS_MSG_EXT)).optLong("sn_send_begin"));
                }
            } catch (JSONException unused) {
                LogUtils.e(TAG, "sendPaChatMsg msg_ext exception");
            }
            String str2 = TAG;
            LogUtils.d(str2, "sendPaChatMsg buildChatMsg = " + buildChatMsg.toString());
            if (BIMManager.isIMLogined(mContext)) {
                SendMsgParam.newInstanceByPa(mContext, buildChatMsg, j, new BIMValueCallBack<SendMsgResponse>(this, buildChatMsg, iSendMessageListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.22
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ChatMsgManagerImpl this$0;
                    public final /* synthetic */ ISendMessageListener val$listener;
                    public final /* synthetic */ ChatMsg val$msg;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, buildChatMsg, iSendMessageListener};
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
                        this.val$msg = buildChatMsg;
                        this.val$listener = iSendMessageListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                    public void onResult(int i4, String str3, SendMsgResponse sendMsgResponse) {
                        ChatMsg chatMsg;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i4, str3, sendMsgResponse) == null) {
                            if (sendMsgResponse == null) {
                                chatMsg = null;
                            } else {
                                chatMsg = sendMsgResponse.msg;
                            }
                            if (i4 == 0) {
                                ISendMessageListener iSendMessageListener2 = this.val$listener;
                                if (iSendMessageListener2 != null) {
                                    iSendMessageListener2.onSendMessageResult(i4, chatMsg);
                                    return;
                                }
                                return;
                            }
                            this.this$0.sendPaChatMsgByHostRequest(i4, this.val$msg, this.val$listener);
                        }
                    }
                }, new SendMsgParam.SendMsgParamConstruct(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl.23
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
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.android.imsdk.chatmessage.request.params.SendMsgParam.SendMsgParamConstruct
                    public void construct(SendMsgParam sendMsgParam) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, sendMsgParam) == null) {
                            BIMManager.sendChatMsg(ChatMsgManagerImpl.mContext, sendMsgParam);
                        }
                    }
                });
                return;
            }
            LogUtils.d(TAG, "not login error");
            sendPaChatMsgByHostRequest(1000, buildChatMsg, iSendMessageListener);
            LoginManager.getInstance(mContext).triggleLogoutListener(1000, Constants.ERROR_LOGIN_STATE_ERROR);
        }
    }

    public boolean setMsgReadByChatTpyes(List<Integer> list, long j) {
        InterceptResult invokeLJ;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048701, this, list, j)) == null) {
            if (AccountManager.isLogin(mContext)) {
                LogUtils.e(TAG, "setMsgReadByChatTpyes start");
                if (list != null && list.size() != 0) {
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
                    ArrayList<ChatSession> arrayList3 = null;
                    if (arrayList.size() > 0) {
                        arrayList3 = ChatSessionManagerImpl.getInstance(mContext).getChatRecords(0L, 0L, arrayList);
                    }
                    if (arrayList3 != null) {
                        Iterator<ChatSession> it = arrayList3.iterator();
                        while (it.hasNext()) {
                            ChatSession next = it.next();
                            if (next.getNewMsgSum() > 0) {
                                ChatObject chatObject = getChatObject(1, next.getContacter());
                                if (j <= 0) {
                                    j3 = ChatMessageDBManager.getInstance(mContext).getMaxMsgid(chatObject);
                                } else {
                                    j3 = j;
                                }
                                setBeforeMsgRead(1, next.getContacter(), j3, false);
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
                        setServerMsgRead(0, -1, 0, l.longValue(), j2, false, null);
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public boolean setMsgReadByChatTypeAndSubType(SparseArray<List<Integer>> sparseArray, long j, ISetMessageReadListener iSetMessageReadListener) {
        InterceptResult invokeCommon;
        long j2;
        long j3;
        long j4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048702, this, new Object[]{sparseArray, Long.valueOf(j), iSetMessageReadListener})) == null) {
            if (AccountManager.isLogin(mContext)) {
                LogUtils.e(TAG, "setMsgReadByChatTypeAndSubType start");
                if (j <= 0) {
                    ArrayList<ChatMsg> notificationMsgDataList = ChatMessageDBManager.getInstance(mContext).getNotificationMsgDataList(sparseArray, 0L, 1);
                    if (notificationMsgDataList == null || notificationMsgDataList.size() <= 0) {
                        return false;
                    }
                    j2 = notificationMsgDataList.get(0).getMsgId();
                } else {
                    j2 = j;
                }
                String str = TAG;
                LogUtils.d(str, "setMsgReadByChatTypeAndSubType msgid = " + j2);
                ArrayList<ChatMsg> unreadMinNotificationMsg = ChatMessageDBManager.getInstance(mContext).getUnreadMinNotificationMsg(sparseArray, 1);
                if (unreadMinNotificationMsg != null && unreadMinNotificationMsg.size() > 0) {
                    j3 = unreadMinNotificationMsg.get(0).getMsgId();
                } else {
                    j3 = j2;
                }
                if (j3 > j2) {
                    j4 = j2;
                } else {
                    j4 = j3;
                }
                List<Long> paMsgReadByChatTypeAndSubType = ChatMessageDBManager.getInstance(mContext).setPaMsgReadByChatTypeAndSubType(sparseArray, j2);
                iSetMessageReadListener.onFinish();
                if (paMsgReadByChatTypeAndSubType == null || paMsgReadByChatTypeAndSubType.size() <= 0) {
                    return false;
                }
                String str2 = TAG;
                LogUtils.e(str2, "setMsgReadByChatTpyes paids size = " + paMsgReadByChatTypeAndSubType.size());
                for (Long l : paMsgReadByChatTypeAndSubType) {
                    setServerMsgRead(0, -1, 0, l.longValue(), j4, j2, false, null);
                }
                return true;
            }
            iSetMessageReadListener.onFinish();
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
