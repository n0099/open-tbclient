package com.baidu.android.imsdk.chatmessage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.DialogSyncMsg;
import com.baidu.android.imsdk.chatmessage.messages.HtmlMsg;
import com.baidu.android.imsdk.chatmessage.messages.UnSupportedMsg;
import com.baidu.android.imsdk.chatmessage.request.IMMediaContactorSettingRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMediaDeleteSessionRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMediaGetChatSessionRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMediaGetContactorPauidRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMediaGetContactorSettingRequest;
import com.baidu.android.imsdk.chatmessage.request.IMMediaSetSessionReadRequest;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecord;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecordDBManager;
import com.baidu.android.imsdk.chatmessage.sync.SyncGroupMessageService;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.IGetUserIdentityListener;
import com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener;
import com.baidu.android.imsdk.chatuser.db.ChatUserDBManager;
import com.baidu.android.imsdk.consult.db.BusinessMessageDBManager;
import com.baidu.android.imsdk.consult.request.IMUpdateCollectSessionTagRequest;
import com.baidu.android.imsdk.db.DBBase;
import com.baidu.android.imsdk.group.BIMGroupManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.Dispatcher;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.media.MediaSessionManager;
import com.baidu.android.imsdk.media.bean.GetSessionResult;
import com.baidu.android.imsdk.media.bean.SessionParam;
import com.baidu.android.imsdk.media.listener.BIMValuesCallBack;
import com.baidu.android.imsdk.media.update.ChatSessionUpdateManager;
import com.baidu.android.imsdk.pubaccount.IGetPaInfosListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.PaManager;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.ubc.CaseUbc;
import com.baidu.android.imsdk.ubc.ScreenUbc;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.TimeUtil;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.x80;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ChatSessionManagerImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ADVISORY_FETCH_BUSINESS_COUNT_FOR_LOGIN = -20;
    public static final long BUSINESS_EXPIRED_SESSION_TIME = 259200000;
    public static final String KEY_BUSINESS_CREDIBLE_MSGID = "busi_session_credible_msgid";
    public static final String KEY_BUSINESS_TOTAL_UNREAD = "busi_session_total_unread";
    public static final String KEY_DELETE_EXPIRED_SESSION_TIME = "business_expired_time";
    public static final String TAG = "SessionManagerImpl";
    public static Context mContext;
    public static volatile ChatSessionManagerImpl mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Dispatcher.MsgListener dialogSyncListener;
    public volatile int mBusinessTotalUnread;
    public List<IDialogSyncListener> mDialogSyncListeners;
    public volatile int mMediaTotalUnread;
    public ISyncDialogListener syncDialogListener;

    public ChatSessionManagerImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDialogSyncListeners = new LinkedList();
        this.mBusinessTotalUnread = -1;
        this.mMediaTotalUnread = 0;
        this.syncDialogListener = new ISyncDialogListener(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatSessionManagerImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
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

            @Override // com.baidu.android.imsdk.chatmessage.ISyncDialogListener
            public void onSyncDialogResult(int i3, String str, long j, List<DialogRecord> list) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), str, Long.valueOf(j), list}) == null) && i3 == 0 && list != null) {
                    LinkedList linkedList = new LinkedList();
                    for (DialogRecord dialogRecord : list) {
                        if (dialogRecord.getCategory() == 1) {
                            DialogRecord dialogRecord2 = DialogRecordDBManager.getInstance(ChatSessionManagerImpl.mContext).getDialogRecord(dialogRecord.getCategory(), dialogRecord.getContacter());
                            LogUtils.i(ChatSessionManagerImpl.TAG, " onSyncDialogResult " + dialogRecord.getContacter() + " mmd: " + dialogRecord2);
                            if (dialogRecord2 == null) {
                                dialogRecord2 = new DialogRecord();
                                dialogRecord2.setCategory(dialogRecord.getCategory()).setContacter(dialogRecord.getContacter()).setJumpToRecent(1).setMaxMsgid(0L);
                            }
                            dialogRecord2.setState(0).setUpdateTime(System.currentTimeMillis()).setDialogueMsgid(dialogRecord.getDialogueMsgid());
                            linkedList.add(dialogRecord2);
                        }
                    }
                    LogUtils.i(ChatSessionManagerImpl.TAG, "add DialogRecord mmds : " + linkedList);
                    if (DialogRecordDBManager.getInstance(ChatSessionManagerImpl.mContext).addBatch(linkedList) > 0) {
                        Context context = ChatSessionManagerImpl.mContext;
                        Utility.writeLongData(context, "sync_max_msgid_" + Utility.getUK(ChatSessionManagerImpl.mContext), j);
                        Utility.writeIntData(ChatSessionManagerImpl.mContext, Constants.KEY_SYNC_FIRST_TIME, 0);
                        for (DialogRecord dialogRecord3 : DialogRecordDBManager.getInstance(ChatSessionManagerImpl.mContext).getDialogRecord(-1)) {
                            SyncGroupMessageService.getInstance().execute(ChatSessionManagerImpl.mContext, dialogRecord3, 0, -1L, -1L, "");
                        }
                    }
                }
            }
        };
        this.dialogSyncListener = new Dispatcher.MsgListener(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatSessionManagerImpl this$0;

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
                    Object[] objArr = {this};
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
                int i4;
                int i5;
                int i6;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, chatMsg) == null) && (chatMsg instanceof DialogSyncMsg)) {
                    DialogSyncMsg dialogSyncMsg = (DialogSyncMsg) chatMsg;
                    int syncCategory = dialogSyncMsg.getSyncCategory();
                    long syncFromUid = dialogSyncMsg.getSyncFromUid();
                    long operatedMaxMsgid = dialogSyncMsg.getOperatedMaxMsgid();
                    int syncStatus = dialogSyncMsg.getSyncStatus();
                    long paid = dialogSyncMsg.getPaid();
                    int remainEmptySession = dialogSyncMsg.getRemainEmptySession();
                    int i7 = -1;
                    if (syncStatus == 0) {
                        i5 = 1;
                        i7 = ChatMessageDBManager.getInstance(ChatSessionManagerImpl.mContext).deleteAllMsgWithMsgid(new ChatObject(ChatSessionManagerImpl.mContext, syncCategory, syncFromUid, paid, -1), operatedMaxMsgid, remainEmptySession);
                        if (i7 > 0 && this.this$0.mDialogSyncListeners != null && this.this$0.mDialogSyncListeners.size() != 0) {
                            for (IDialogSyncListener iDialogSyncListener : this.this$0.mDialogSyncListeners) {
                                iDialogSyncListener.onDialogDel(syncCategory, syncFromUid);
                            }
                        }
                        i4 = syncStatus;
                    } else {
                        i4 = syncStatus;
                        i5 = 1;
                        if (i4 == 1) {
                            if (operatedMaxMsgid <= 0) {
                                return;
                            }
                            boolean allMsgReadWithMsgid = ChatMessageDBManager.getInstance(ChatSessionManagerImpl.mContext).setAllMsgReadWithMsgid(new ChatObject(ChatSessionManagerImpl.mContext, syncCategory, syncFromUid), operatedMaxMsgid);
                            if (allMsgReadWithMsgid) {
                                i6 = 1;
                            } else {
                                i6 = -1;
                            }
                            if (allMsgReadWithMsgid && this.this$0.mDialogSyncListeners != null && this.this$0.mDialogSyncListeners.size() != 0) {
                                for (IDialogSyncListener iDialogSyncListener2 : this.this$0.mDialogSyncListeners) {
                                    iDialogSyncListener2.onDialogReaded(syncCategory, syncFromUid);
                                }
                            }
                            i7 = i6;
                        }
                    }
                    if (i7 > 0) {
                        Intent intent = new Intent(IMConstants.SYNC_ACTION);
                        intent.setPackage(ChatSessionManagerImpl.mContext.getApplicationContext().getPackageName());
                        intent.putExtra("category", syncCategory);
                        intent.putExtra("contacter", syncFromUid);
                        intent.putExtra(IMConstants.SYNC_MSGID, operatedMaxMsgid);
                        intent.putExtra(IMConstants.SYNC_STATUS, i4);
                        intent.putExtra(IMConstants.SYNC_TYPE, i5);
                        ChatSessionManagerImpl.mContext.sendBroadcast(intent);
                    }
                }
            }
        };
        Dispatcher.Event event = new Dispatcher.Event();
        event.setCategory(2);
        event.setType(22);
        Dispatcher.registerListener(event, this.dialogSyncListener);
        DBBase.registerObserver(ChatSessionUpdateManager.getInstance(mContext).getSessionDbOberser());
        BusinessMessageDBManager.getInstance(mContext).registerSessionChangeListener(ChatSessionUpdateManager.getInstance(mContext).getBusiSessionChangeListener());
    }

    public ArrayList<SessionClass> getAllClassType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList<SessionClass> allClassType = ChatMessageDBManager.getInstance(mContext).getAllClassType();
            if (allClassType != null && allClassType.size() > 0) {
                Iterator<SessionClass> it = allClassType.iterator();
                while (it.hasNext()) {
                    SessionClass next = it.next();
                    next.setUnread(ChatMessageDBManager.getInstance(mContext).getNewMsgCountOfClass(next.getType()));
                    LogUtils.d(TAG, " class session is " + next.getType() + " " + next.getTitle() + " " + next.getUnread());
                }
            }
            return allClassType;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void syncDialog() {
        ISyncDialogListener iSyncDialogListener;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048627, this) != null) || (iSyncDialogListener = this.syncDialogListener) == null) {
            return;
        }
        String addListener = ListenerManager.getInstance().addListener(iSyncDialogListener);
        long maxMsgid = getMaxMsgid();
        if (maxMsgid < 0) {
            iSyncDialogListener.onSyncDialogResult(1009, Constants.ERROR_MSG_INTERNAL_DB_ERROR, maxMsgid, null);
        } else if (!LoginManager.getInstance(mContext).isIMLogined()) {
            iSyncDialogListener.onSyncDialogResult(5, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, -1L, null);
            LogUtils.d(TAG, "syncDialog methodId :94 by intercept because unlogin ");
        } else {
            Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 94);
            creatMethodIntent.putExtra(Constants.EXTRA_CLIENT_MAX_MSGID, maxMsgid);
            creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            try {
                x80.e(mContext).d(mContext, creatMethodIntent);
            } catch (Exception e) {
                onSyncDialogResult(1003, Constants.ERROR_MSG_SERVICE_ERROR, addListener, maxMsgid, null);
                LogUtils.e(TAG, "Exception ", e);
            }
        }
    }

    public List<ChatSession> getGroupSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return ChatMessageDBManager.getInstance(mContext).getGroupSession();
        }
        return (List) invokeV.objValue;
    }

    public List<Integer> getUnreadChatTypesByAllClassType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return ChatMessageDBManager.getInstance(mContext).getUnreadChatTypesByAllClassType();
        }
        return (List) invokeV.objValue;
    }

    public int readServerUnreadNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.mMediaTotalUnread;
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getBusiSessionCredibleMsgid(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i)) == null) {
            return Utility.readLongData(mContext, getBusiSessionCredibleMsgidKey(i), Long.MAX_VALUE);
        }
        return invokeI.longValue;
    }

    private String getBusiSessionCredibleMsgidKey(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, this, i)) == null) {
            return AccountManager.getUK(mContext) + KEY_BUSINESS_CREDIBLE_MSGID + i;
        }
        return (String) invokeI.objValue;
    }

    private String getBusiSessionTotalUnreadKey(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, this, i)) == null) {
            return AccountManager.getUK(mContext) + KEY_BUSINESS_TOTAL_UNREAD + i;
        }
        return (String) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBusinessUnread(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, this, i) == null) {
            TaskManager.getInstance(mContext).submitForLocalOperation(new Runnable(this, i) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatSessionManagerImpl this$0;
                public final /* synthetic */ int val$business;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
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
                    this.val$business = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BusinessMessageDBManager.getInstance(ChatSessionManagerImpl.mContext).notifyUnreadSessionChange(this.val$business);
                    }
                }
            });
        }
    }

    public boolean deleteChatSession(ChatSession chatSession) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, chatSession)) == null) {
            if (ChatMessageDBManager.getInstance(mContext).delChatRecord(new ChatObject(mContext, chatSession.getCategory(), chatSession.getContacter())) >= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int getBusiSessionTotalUnread(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (this.mBusinessTotalUnread != -1) {
                return this.mBusinessTotalUnread;
            }
            return Utility.readIntData(mContext, getBusiSessionTotalUnreadKey(i), 0);
        }
        return invokeI.intValue;
    }

    public void setAllBusinessSessionRead(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            setBusiSessionTotalUnread(i, 0);
            BusinessMessageDBManager.getInstance(mContext).setAllBusinessSessionRead(i);
        }
    }

    public void deleteSession(@NonNull SessionParam sessionParam, BIMValueCallBack<Object> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, sessionParam, bIMValueCallBack) == null) {
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, sessionParam, bIMValueCallBack) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatSessionManagerImpl this$0;
                public final /* synthetic */ BIMValueCallBack val$listener;
                public final /* synthetic */ SessionParam val$param;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sessionParam, bIMValueCallBack};
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
                    this.val$param = sessionParam;
                    this.val$listener = bIMValueCallBack;
                }

                @Override // java.lang.Runnable
                public void run() {
                    List<ChatSession> strangerSessionList;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SessionParam sessionParam2 = this.val$param;
                        if (sessionParam2.classType <= 0 && sessionParam2.isStranger != 1) {
                            ChatMsgManagerImpl chatMsgManagerImpl = ChatMsgManagerImpl.getInstance(ChatSessionManagerImpl.mContext);
                            SessionParam sessionParam3 = this.val$param;
                            chatMsgManagerImpl.deleteAllMsgs(sessionParam3.category, sessionParam3.contacterId, false, sessionParam3.deleteMode);
                        } else {
                            if (this.val$param.classType > 0) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(Integer.valueOf(this.val$param.classType));
                                strangerSessionList = ChatMsgManager.getChatRecordsByClass(ChatSessionManagerImpl.mContext, arrayList);
                            } else {
                                strangerSessionList = ChatMessageDBManager.getInstance(ChatSessionManagerImpl.mContext).getStrangerSessionList(0L, Long.MAX_VALUE, 0);
                            }
                            if (strangerSessionList != null && strangerSessionList.size() > 0) {
                                for (ChatSession chatSession : strangerSessionList) {
                                    ChatMsgManagerImpl.getInstance(ChatSessionManagerImpl.mContext).deleteAllMsgs(chatSession.getCategory(), chatSession.getContacter(), false, this.val$param.deleteMode);
                                }
                            }
                        }
                        BIMValueCallBack bIMValueCallBack2 = this.val$listener;
                        if (bIMValueCallBack2 != null) {
                            bIMValueCallBack2.onResult(0, Constants.ERROR_MSG_SUCCESS, null);
                        }
                    }
                }
            });
        }
    }

    public ArrayList<ChatSession> getChatRecordsByClass(long j, List<Integer> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048592, this, j, list)) == null) {
            if (AccountManager.isLogin(mContext)) {
                return ChatMessageDBManager.getInstance(mContext).getChatRecordsByClass(j, list);
            }
            return null;
        }
        return (ArrayList) invokeJL.objValue;
    }

    public void registerDialogSyncListener(Context context, IDialogSyncListener iDialogSyncListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048620, this, context, iDialogSyncListener) == null) && iDialogSyncListener != null && !this.mDialogSyncListeners.contains(iDialogSyncListener)) {
            this.mDialogSyncListeners.add(iDialogSyncListener);
        }
    }

    public void setBusiSessionTotalUnread(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048622, this, i, i2) == null) {
            this.mBusinessTotalUnread = i2;
            Utility.writeIntData(mContext, getBusiSessionTotalUnreadKey(i), i2);
        }
    }

    public void setSessionRead(@NonNull SessionParam sessionParam, BIMValueCallBack<Object> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, sessionParam, bIMValueCallBack) == null) {
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, sessionParam, bIMValueCallBack) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatSessionManagerImpl this$0;
                public final /* synthetic */ BIMValueCallBack val$listener;
                public final /* synthetic */ SessionParam val$param;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sessionParam, bIMValueCallBack};
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
                    this.val$param = sessionParam;
                    this.val$listener = bIMValueCallBack;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SessionParam sessionParam2 = this.val$param;
                        if (sessionParam2.classType > 0 || sessionParam2.isStranger != 0 || sessionParam2.type != 1) {
                            SessionParam sessionParam3 = this.val$param;
                            if (sessionParam3.businessType == 27) {
                                MediaSessionManager.getInstance(ChatSessionManagerImpl.mContext).setSessionRead(this.val$param, new BIMValueCallBack<Object>(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.14.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass14 this$1;

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

                                    @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                                    public void onResult(int i, String str, Object obj) {
                                        BIMValueCallBack bIMValueCallBack2;
                                        Interceptable interceptable3 = $ic;
                                        if ((interceptable3 == null || interceptable3.invokeILL(1048576, this, i, str, obj) == null) && (bIMValueCallBack2 = this.this$1.val$listener) != null) {
                                            bIMValueCallBack2.onResult(0, Constants.ERROR_MSG_SUCCESS, null);
                                        }
                                    }
                                });
                                return;
                            } else {
                                this.this$0.setUserSessionRead(sessionParam3, this.val$listener);
                                return;
                            }
                        }
                        this.this$0.setUserAllSessionRead(sessionParam2, this.val$listener);
                    }
                }
            });
        }
    }

    public void unregisterDialogSyncListener(Context context, IDialogSyncListener iDialogSyncListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048628, this, context, iDialogSyncListener) == null) && iDialogSyncListener != null && this.mDialogSyncListeners.contains(iDialogSyncListener)) {
            this.mDialogSyncListeners.remove(iDialogSyncListener);
        }
    }

    public void updateUserSessionExtAndNotify(int i, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), str}) == null) {
            ChatMessageDBManager.getInstance(mContext).updateChatRecordExtAndNotify(i, j, str);
        }
    }

    private void fetchSessionListByClass(int i, BIMValuesCallBack<GetSessionResult, SessionParam> bIMValuesCallBack, ScreenUbc.MethodInfo methodInfo, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65546, this, new Object[]{Integer.valueOf(i), bIMValuesCallBack, methodInfo, str}) != null) || i <= 0) {
            return;
        }
        TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, i, methodInfo, bIMValuesCallBack, str) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatSessionManagerImpl this$0;
            public final /* synthetic */ BIMValuesCallBack val$callBack;
            public final /* synthetic */ int val$classType;
            public final /* synthetic */ ScreenUbc.MethodInfo val$info;
            public final /* synthetic */ String val$screenKey;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i), methodInfo, bIMValuesCallBack, str};
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
                this.val$classType = i;
                this.val$info = methodInfo;
                this.val$callBack = bIMValuesCallBack;
                this.val$screenKey = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf(this.val$classType));
                    Utility.addEventList(this.val$info.eventList, "! getChatRecordsByClass");
                    ArrayList<ChatSession> chatRecordsByClass = this.this$0.getChatRecordsByClass(0L, arrayList);
                    GetSessionResult getSessionResult = new GetSessionResult();
                    getSessionResult.hasMore = false;
                    getSessionResult.sessionList = chatRecordsByClass;
                    BIMValuesCallBack bIMValuesCallBack2 = this.val$callBack;
                    if (bIMValuesCallBack2 != null) {
                        bIMValuesCallBack2.onResult(0, Constants.ERROR_MSG_SUCCESS, getSessionResult, null);
                        ScreenUbc.MethodInfo methodInfo2 = this.val$info;
                        methodInfo2.errCode = 0;
                        methodInfo2.errMsg = "fetchSessionListByClass_Sucess!";
                        methodInfo2.endTime = System.currentTimeMillis();
                        ScreenUbc.onEvent(ChatSessionManagerImpl.mContext, this.val$screenKey, this.val$info);
                    }
                }
            }
        });
    }

    public int delDbBusiChatSession(int i, int i2, int i3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)})) == null) {
            if (i == 9) {
                return BusinessMessageDBManager.getInstance(mContext).delBusiChatSession(i2, i3, j);
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static ChatSessionManagerImpl getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (mInstance == null) {
                synchronized (ChatSessionManagerImpl.class) {
                    if (mInstance == null) {
                        if (mContext == null) {
                            mContext = context.getApplicationContext();
                        }
                        mInstance = new ChatSessionManagerImpl();
                    }
                }
            }
            return mInstance;
        }
        return (ChatSessionManagerImpl) invokeL.objValue;
    }

    private long getMaxMsgid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            Context context = mContext;
            return Math.max(Utility.readLongData(context, "sync_max_msgid_" + Utility.getUK(mContext), 0L), DialogRecordDBManager.getInstance(mContext).getMaxMsgid());
        }
        return invokeV.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMediaGetSessionResult(@NonNull IMediaGetChatSessionListener iMediaGetChatSessionListener, int i, int i2, int i3, boolean z, List<ChatSession> list, long j) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{iMediaGetChatSessionListener, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), list, Long.valueOf(j)}) == null) {
            iMediaGetChatSessionListener.onMediaGetChatSessionResult(i, i2, i3, z, list);
            CaseUbc.DebugInfo debugInfo = new CaseUbc.DebugInfo();
            debugInfo.curClassName = "onMediaGetSessionResult";
            debugInfo.extInfo = "totalUnReadMsgNum = " + i2;
            debugInfo.extInfo += ", contacterImUk = " + j;
            StringBuilder sb = new StringBuilder();
            sb.append(debugInfo.extInfo);
            sb.append(",session = ");
            if (list != null && list.size() > 0) {
                str = list.get(0).getLastResourceId();
            } else {
                str = StringUtil.NULL_STRING;
            }
            sb.append(str);
            debugInfo.extInfo = sb.toString();
            CaseUbc.debugUbc(mContext, "Business", i, "", debugInfo);
        }
    }

    public boolean delBusinessChatSession(long j, int i, int i2, int i3, long j2, long j3, IDelBusinessChatSessionListener iDelBusinessChatSessionListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3), iDelBusinessChatSessionListener})) == null) {
            LogUtils.d(TAG, "sendDelBusinessSessionMsg start");
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                String addListener = ListenerManager.getInstance().addListener(iDelBusinessChatSessionListener);
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, Constants.METHOD_IM_DEL_BUSINESS_SESSION_MSG);
                creatMethodIntent.putExtra("contacter", j);
                creatMethodIntent.putExtra(Constants.EXTRA_BUSINESS_TYPE, i2);
                creatMethodIntent.putExtra("session_type", i);
                creatMethodIntent.putExtra("category", i3);
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                creatMethodIntent.putExtra(Constants.EXTRA_CLIENT_MAX_MSGID, j3);
                try {
                    x80.e(mContext).d(mContext, creatMethodIntent);
                    return true;
                } catch (Exception e) {
                    LogUtils.e(TAG, "sendCustomNotifyMsg Exception ", e);
                    return false;
                }
            }
            LogUtils.d(TAG, "sendDelBusinessSessionMsg not login");
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public List<ChatSession> getBusiChatSessionsFromDb(int i, int i2, long j, long j2, long j3, int i3, int i4) {
        InterceptResult invokeCommon;
        long j4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (BIMManager.isIMLogined(mContext)) {
                long busiSessionCredibleMsgid = getBusiSessionCredibleMsgid(i);
                if (busiSessionCredibleMsgid > j3) {
                    return null;
                }
                if (j2 < busiSessionCredibleMsgid) {
                    j4 = busiSessionCredibleMsgid;
                    LogUtils.d(TAG, "getBusiChatSessionsFromDb beginMsgid = " + j4 + " endMsgid = " + j3);
                    return BusinessMessageDBManager.getInstance(mContext).getBusiChatSessions(i, i2, j, j4, j3, i3, i4);
                }
            }
            j4 = j2;
            LogUtils.d(TAG, "getBusiChatSessionsFromDb beginMsgid = " + j4 + " endMsgid = " + j3);
            return BusinessMessageDBManager.getInstance(mContext).getBusiChatSessions(i, i2, j, j4, j3, i3, i4);
        }
        return (List) invokeCommon.objValue;
    }

    public void setChatSessionReadByBusiness(int i, int i2, int i3, long j, long j2, long j3, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), iMediaSetSessionReadListener}) == null) {
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                LogUtils.e(TAG, "setChatSessionReadByBusiness start");
                MediaSessionManager.getInstance(mContext).setSessionRead(SessionParam.getAdvisoryReadOrDelParam(j, j2, j3, i2, 0), new BIMValueCallBack<Object>(this, i, i2, i3, j, j2, ListenerManager.getInstance().addListener(iMediaSetSessionReadListener)) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ChatSessionManagerImpl this$0;
                    public final /* synthetic */ int val$businessType;
                    public final /* synthetic */ int val$category;
                    public final /* synthetic */ long val$contacterImUk;
                    public final /* synthetic */ String val$key;
                    public final /* synthetic */ long val$maxMsgId;
                    public final /* synthetic */ int val$sessionType;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), r14};
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
                        this.val$businessType = i;
                        this.val$sessionType = i2;
                        this.val$category = i3;
                        this.val$contacterImUk = j;
                        this.val$maxMsgId = j2;
                        this.val$key = r14;
                    }

                    @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                    public void onResult(int i4, String str, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i4, str, obj) == null) {
                            this.this$0.onMarkBusinessSessionReadResult(i4, str, this.val$businessType, this.val$sessionType, this.val$category, this.val$contacterImUk, this.val$maxMsgId, this.val$key);
                        }
                    }
                });
            } else if (iMediaSetSessionReadListener != null) {
                iMediaSetSessionReadListener.onMediaSetSessionReadResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBusiSessionCredibleMsgid(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            LogUtils.d(TAG, "setBusiSessionCredibleMsgid busiType = " + i + " msgid = " + j);
            Utility.writeLongData(mContext, getBusiSessionCredibleMsgidKey(i), j);
        }
    }

    public void mediaGetContactorPauid(long j, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048609, this, j, iMediaGetContactorPauidListener) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", listener=" + iMediaGetContactorPauidListener);
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                IMMediaGetContactorPauidRequest iMMediaGetContactorPauidRequest = new IMMediaGetContactorPauidRequest(mContext, j, ListenerManager.getInstance().addListener(iMediaGetContactorPauidListener));
                HttpHelper.executor(mContext, iMMediaGetContactorPauidRequest, iMMediaGetContactorPauidRequest);
            } else if (iMediaGetContactorPauidListener != null) {
                iMediaGetContactorPauidListener.onMediaGetContactorPauidResult(1000, "", -1L, -1, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserAllSessionRead(@NonNull SessionParam sessionParam, BIMValueCallBack<Object> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, this, sessionParam, bIMValueCallBack) == null) {
            ChatMsgManager.setMsgReadByChatTpyes(mContext, sessionParam.allChatTypes, 0L);
            MediaSessionManager.getInstance(mContext).setSessionRead(SessionParam.getAdvisoryReadOrDelParam(0L, 0L, 0L, 0, 1), new BIMValueCallBack<Object>(this, bIMValueCallBack) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatSessionManagerImpl this$0;
                public final /* synthetic */ BIMValueCallBack val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bIMValueCallBack};
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
                    this.val$listener = bIMValueCallBack;
                }

                @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                public void onResult(int i, String str, Object obj) {
                    BIMValueCallBack bIMValueCallBack2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, obj) == null) && (bIMValueCallBack2 = this.val$listener) != null) {
                        bIMValueCallBack2.onResult(0, Constants.ERROR_MSG_SUCCESS, null);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChatSession updateChatSessionByChatUser(ChatSession chatSession, ChatUser chatUser) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, this, chatSession, chatUser)) == null) {
            if (chatSession != null && chatUser != null) {
                chatSession.setName(chatUser.getUserName());
                chatSession.setChatType(58);
                chatSession.setBusinessType(27);
                chatSession.setIconUrl(chatUser.getIconUrl());
                chatSession.setContacter(chatUser.getUk());
                chatSession.setVPortrait(chatUser.getVPortrait());
                return chatSession;
            }
            return null;
        }
        return (ChatSession) invokeLL.objValue;
    }

    public ArrayList<ChatSession> getChatRecords(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            LogUtils.enter();
            if (AccountManager.isLogin(mContext)) {
                return ChatMessageDBManager.getInstance(mContext).getChatRecords(j, j2, null);
            }
            return null;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public void getUnReadChatSession(SessionParam sessionParam, BIMValuesCallBack<GetSessionResult, SessionParam> bIMValuesCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, sessionParam, bIMValuesCallBack) == null) {
            if (sessionParam == null) {
                if (bIMValuesCallBack != null) {
                    bIMValuesCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, GetSessionResult.getFailResult(), null);
                    return;
                }
                return;
            }
            sessionParam.sortUpdateTimeEnd = Long.MAX_VALUE;
            if (sessionParam.count <= 0) {
                sessionParam.count = 3;
            }
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, sessionParam, bIMValuesCallBack) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatSessionManagerImpl this$0;
                public final /* synthetic */ BIMValuesCallBack val$callBack;
                public final /* synthetic */ SessionParam val$param;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sessionParam, bIMValuesCallBack};
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
                    this.val$param = sessionParam;
                    this.val$callBack = bIMValuesCallBack;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ChatMessageDBManager chatMessageDBManager = ChatMessageDBManager.getInstance(ChatSessionManagerImpl.mContext);
                        SessionParam sessionParam2 = this.val$param;
                        List<ChatSession> newUnReadSessionList = chatMessageDBManager.getNewUnReadSessionList(sessionParam2.sortUpdateTimeBegin, sessionParam2.sortUpdateTimeEnd, sessionParam2.count, sessionParam2.asyncUnReadChatTypes);
                        GetSessionResult getSessionResult = new GetSessionResult();
                        getSessionResult.sessionList = this.this$0.completeSessionInfo(newUnReadSessionList);
                        getSessionResult.totalUnread = ChatMessageDBManager.getInstance(ChatSessionManagerImpl.mContext).getAllNewMsgCount(this.val$param.userNumChatTypes);
                        BIMValuesCallBack bIMValuesCallBack2 = this.val$callBack;
                        if (bIMValuesCallBack2 != null) {
                            bIMValuesCallBack2.onResult(0, Constants.ERROR_MSG_SUCCESS, getSessionResult, null);
                        }
                    }
                }
            });
        }
    }

    public void writeServerUnreadnum(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (!z) {
                this.mMediaTotalUnread = i;
            } else {
                mediaGetChatSessions(-1L, -1, -1L, "", 0L, 1, -1, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserSessionRead(@NonNull SessionParam sessionParam, BIMValueCallBack<Object> bIMValueCallBack) {
        List<ChatSession> strangerSessionList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, this, sessionParam, bIMValueCallBack) == null) {
            if (sessionParam.type == 1 && (sessionParam.classType > 0 || sessionParam.isStranger == 1)) {
                if (sessionParam.classType > 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf(sessionParam.classType));
                    strangerSessionList = ChatMsgManager.getChatRecordsByClass(mContext, arrayList);
                } else {
                    strangerSessionList = ChatMessageDBManager.getInstance(mContext).getStrangerSessionList(0L, Long.MAX_VALUE, 0);
                }
                if (strangerSessionList != null && strangerSessionList.size() > 0) {
                    for (ChatSession chatSession : strangerSessionList) {
                        ChatMsgManagerImpl.getInstance(mContext).setAllMsgRead(chatSession.getCategory(), chatSession.getContacter(), false);
                    }
                }
            } else {
                ChatMsgManagerImpl.getInstance(mContext).setAllMsgRead(sessionParam.category, sessionParam.contacterId, false);
            }
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(0, Constants.ERROR_MSG_SUCCESS, null);
            }
        }
    }

    private void updateUnsupportDesc(ChatSession chatSession, String str) {
        ChatMsg latestMsg;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65560, this, chatSession, str) == null) && IMConstants.IS_UPDATE_VERSION && !TextUtils.isEmpty(str) && str.equals(UnSupportedMsg.unSupportedMsgDesc) && (latestMsg = ChatMessageDBManager.getInstance(mContext).getLatestMsg(chatSession.getCategory(), chatSession.getContacter())) != null && BIMManager.isSupportMsgType(latestMsg.getMsgType())) {
            String recommendDescription = latestMsg.getRecommendDescription();
            if (latestMsg instanceof HtmlMsg) {
                recommendDescription = ((HtmlMsg) latestMsg).getLocalUrl();
            }
            if (!TextUtils.isEmpty(recommendDescription) && !str.equals(recommendDescription)) {
                chatSession.setLastMsg(recommendDescription);
                ChatMessageDBManager.getInstance(mContext).updateChatSession(4, chatSession);
            }
        }
    }

    public ChatSession getChatRecord(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            LogUtils.enter();
            ChatSession chatRecord = ChatMessageDBManager.getInstance(mContext).getChatRecord(new ChatObject(mContext, i, j));
            if (i == 1) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(String.valueOf(j));
                ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList);
                if (groupInfo != null && groupInfo.size() > 0 && groupInfo.get(0).getType() == 2 && chatRecord != null) {
                    chatRecord.setChatType(4);
                }
            }
            return chatRecord;
        }
        return (ChatSession) invokeCommon.objValue;
    }

    private void updateGroupChatSession(ChatSession chatSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, chatSession) == null) {
            if (chatSession.getChatType() == 3 || chatSession.getChatType() == 4 || chatSession.getChatType() == 57) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(String.valueOf(chatSession.getContacter()));
                ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList);
                if (groupInfo != null && groupInfo.size() > 0) {
                    LogUtils.d(TAG, "set session name as " + groupInfo.get(0).getGroupName());
                    GroupInfo groupInfo2 = groupInfo.get(0);
                    if (groupInfo2.getType() == 2) {
                        chatSession.setChatType(4);
                        if (TextUtils.isEmpty(chatSession.getName())) {
                            chatSession.setName(groupInfo2.getGroupName());
                        }
                        String headUrl = groupInfo2.getHeadUrl();
                        if (!TextUtils.isEmpty(headUrl)) {
                            headUrl = headUrl.trim();
                        }
                        chatSession.setIconUrl(headUrl);
                    } else if (groupInfo2.getType() == 3) {
                        chatSession.setChatType(57);
                    }
                }
            }
        }
    }

    public String getBusinessSessionLastMsg(ChatSession chatSession) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, chatSession)) == null) {
            if (chatSession == null || chatSession.getBusinessType() != 27) {
                return "";
            }
            String nickName = chatSession.getNickName();
            if (TextUtils.isEmpty(nickName)) {
                nickName = chatSession.getName();
            }
            if (chatSession.getSessionType() == 1) {
                if (chatSession.getLastAskUk() == AccountManager.getUK(mContext)) {
                    nickName = nickName + "(匿名)";
                } else {
                    String transBDUID = Utility.transBDUID(String.valueOf(chatSession.getContacterId()));
                    if (TextUtils.isEmpty(transBDUID) || transBDUID.length() < 5) {
                        nickName = "匿名用户";
                    } else {
                        nickName = "匿名用户" + transBDUID.substring(transBDUID.length() - 5);
                    }
                }
            }
            if (chatSession.getLastDialogueStatus() == 1) {
                return String.format(IMConstants.ADVISORY_AGG_DOING_DESC, nickName);
            }
            if (chatSession.getLastDialogueStatus() != 2) {
                return "";
            }
            return String.format(IMConstants.ADVISORY_AGG_DONE_DESC, nickName);
        }
        return (String) invokeL.objValue;
    }

    private void updatePADesc(ChatSession chatSession, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, this, chatSession, str) == null) {
            int chatType = chatSession.getChatType();
            if (chatType == 7 || chatType == 16 || chatType == 17 || chatType == 27 || chatType == 23 || chatType == 25 || chatType == 26 || chatType == 5 || chatType == 32) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("msg")) {
                        JSONObject jSONObject2 = new JSONObject(jSONObject.optString("msg"));
                        if (jSONObject2.has("template_version") && jSONObject2.optInt("template_version") > 0) {
                            str = jSONObject2.optString("card_title");
                            if (TextUtils.isEmpty(str)) {
                                str = jSONObject2.optString("title");
                            }
                        } else if (!TextUtils.isEmpty(jSONObject2.optString("ext"))) {
                            str = jSONObject2.optString("title");
                        }
                        if (!TextUtils.isEmpty(str)) {
                            chatSession.setLastMsg(str);
                            if (chatSession.getBusinessType() == 27) {
                                chatSession.setLastMsgId(jSONObject.optLong("id", -1L));
                                return;
                            }
                            return;
                        }
                        chatSession.setLastMsg("你收到了一条消息");
                    } else if (chatSession.getBusinessType() == 27) {
                        chatSession.setLastMsg(jSONObject.optString("title", str));
                    }
                } catch (Exception e) {
                    LogUtils.e(TAG, "it doesn't matter>" + e.getMessage());
                }
            }
        }
    }

    public List<ChatSession> completeSessionInfo(List<ChatSession> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() != 0) {
                LogUtils.d(TAG, "completeSessionInfo :" + list.size());
                for (ChatSession chatSession : list) {
                    updateGroupChatSession(chatSession);
                    String lastMsg = chatSession.getLastMsg();
                    updateUnsupportDesc(chatSession, lastMsg);
                    updatePADesc(chatSession, lastMsg);
                }
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public void fetchBusinessSessionForLogin(int i) {
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048583, this, i) != null) || AccountManager.isCuidLogin(mContext)) {
            return;
        }
        if (i <= 0) {
            notifyBusinessUnread(27);
            return;
        }
        if (i != 5) {
            j = getBusiSessionCredibleMsgid(27) - 1;
        } else {
            j = Long.MAX_VALUE;
        }
        updateBusiSessionAndGet(27, 0, 0L, 0L, j, -20, 0, 1, new IMediaGetChatSessionListener(this, i) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatSessionManagerImpl this$0;
            public final /* synthetic */ int val$count;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i)};
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
                this.val$count = i;
            }

            @Override // com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener
            public void onMediaGetChatSessionResult(int i2, int i3, int i4, boolean z, List<ChatSession> list) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), list}) == null) {
                    if (i2 == 0 && z) {
                        this.this$0.fetchBusinessSessionForLogin(this.val$count - 1);
                    } else {
                        this.this$0.notifyBusinessUnread(27);
                    }
                }
            }
        });
    }

    public void createChatSession(ChatObject chatObject, String str, int i, String str2, int i2, String str3, String str4, int i3, int i4, long j, int i5, long j2, String str5, String str6, String str7, String str8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{chatObject, str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, str4, Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j), Integer.valueOf(i5), Long.valueOf(j2), str5, str6, str7, str8}) == null) {
            long createChatSession = ChatMessageDBManager.getInstance(mContext).createChatSession(chatObject, str, i, str2, i2, str3, str4, i3, i4, j, i5, j2, str5, str6, str7, str8);
            LogUtils.i(TAG, "createChatSession result : " + createChatSession + " chatType: " + i + "  name:" + str);
            if (createChatSession > 0) {
                ArrayList<ChatMsg> fetchMessageSync = ChatMsgManagerImpl.getInstance(mContext).fetchMessageSync(chatObject.getCategory(), chatObject.getContacter(), 50, (ChatMsg) null);
                if (fetchMessageSync != null && fetchMessageSync.size() != 0) {
                    for (int i6 = 0; i6 < fetchMessageSync.size(); i6++) {
                        fetchMessageSync.get(i6).setChatType(i);
                    }
                    ChatMsgManagerImpl.getInstance(mContext).broadcastMessage(fetchMessageSync, true);
                    return;
                }
                LogUtils.i(TAG, "createChatSession:  fetch msgs is null : ");
            }
        }
    }

    public void deleteExpiredBusinessSession() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || AccountManager.isCuidLogin(mContext)) {
            return;
        }
        String str = KEY_DELETE_EXPIRED_SESSION_TIME + AccountManager.getUK(mContext);
        long readLongData = Utility.readLongData(mContext, str, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - readLongData > 259200000) {
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, currentTimeMillis, str) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatSessionManagerImpl this$0;
                public final /* synthetic */ long val$curTime;
                public final /* synthetic */ String val$key;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(currentTimeMillis), str};
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
                    this.val$curTime = currentTimeMillis;
                    this.val$key = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BusinessMessageDBManager.getInstance(ChatSessionManagerImpl.mContext).deleteExpiredBusinessSession(27, (this.val$curTime - 259200000) / 1000);
                        Utility.writeLongData(ChatSessionManagerImpl.mContext, this.val$key, this.val$curTime);
                    }
                }
            });
        }
    }

    public void getBusiSessionFromServer(int i, int i2, long j, long j2, long j3, int i3, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), iMediaGetChatSessionListener}) == null) {
            boolean isShieldSession = BIMManager.isShieldSession(9, i);
            LogUtils.d(TAG, "问一问拉会话屏蔽状态：" + isShieldSession);
            if (isShieldSession) {
                if (iMediaGetChatSessionListener != null) {
                    iMediaGetChatSessionListener.onMediaGetChatSessionResult(0, 0, 0, false, null);
                }
            } else if (!BIMManager.isIMLogined(mContext)) {
                LogUtils.d(TAG, "getBusiSessionFromServer im not login, triggle im relogin");
                LoginManager.getInstance(mContext).triggleLogoutListener(1000, Constants.ERROR_LOGIN_STATE_ERROR);
                getChatSessionsByBusiness(i, i2, j, j2, j3, i3, 3, 1, iMediaGetChatSessionListener);
            } else if (AccountManager.isCuidLogin(mContext)) {
                if (iMediaGetChatSessionListener != null) {
                    iMediaGetChatSessionListener.onMediaGetChatSessionResult(0, 0, 0, false, null);
                }
            } else {
                Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 206);
                String addListener = ListenerManager.getInstance().addListener(iMediaGetChatSessionListener);
                creatMethodIntent.putExtra("count", i3);
                creatMethodIntent.putExtra("contacter", j);
                creatMethodIntent.putExtra(Constants.EXTRA_BEGIN_MSGID, j2);
                creatMethodIntent.putExtra(Constants.EXTRA_END_MSGID, j3);
                creatMethodIntent.putExtra(Constants.EXTRA_BUSINESS_TYPE, i);
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                creatMethodIntent.putExtra("session_type", i2);
                try {
                    x80.e(mContext).d(mContext, creatMethodIntent);
                } catch (Exception e) {
                    LogUtils.e(TAG, "getBusiSessionFromServer Exception ", e);
                    ListenerManager.getInstance().removeListener(addListener);
                    if (iMediaGetChatSessionListener != null) {
                        iMediaGetChatSessionListener.onMediaGetChatSessionResult(1003, 0, 0, false, null);
                    }
                }
            }
        }
    }

    public ArrayList<ChatSession> getChatRecords(long j, long j2, List<Integer> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), list})) == null) {
            ArrayList<ChatSession> chatRecords = ChatMessageDBManager.getInstance(mContext).getChatRecords(j, j2, list);
            completeSessionInfo(chatRecords);
            return chatRecords;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public int setSessionSubscribeStatusByBusiness(int i, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            if (AccountManager.isCuidLogin(mContext)) {
                return 0;
            }
            return BusinessMessageDBManager.getInstance(mContext).setSessionSubscribeStatusByBusiness(i, j, i2);
        }
        return invokeCommon.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getChatSession(SessionParam sessionParam, BIMValuesCallBack<GetSessionResult, SessionParam> bIMValuesCallBack, ScreenUbc.MethodInfo methodInfo) {
        int i;
        long j;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int newMsgCountWithStrangerAndNoDisturb;
        List<ChatSession> strangerSessionList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, sessionParam, bIMValuesCallBack, methodInfo) == null) {
            if (sessionParam == null) {
                if (bIMValuesCallBack != null) {
                    bIMValuesCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, GetSessionResult.getFailResult(), null);
                    return;
                }
                return;
            }
            int i8 = sessionParam.classType;
            if (i8 > 0) {
                fetchSessionListByClass(i8, bIMValuesCallBack, methodInfo, sessionParam.screenKey);
                return;
            }
            int i9 = sessionParam.count;
            if (i9 >= 0) {
                i = i9 + 1;
            } else {
                i = i9 - 1;
            }
            List<ChatSession> sessionList = ChatMessageDBManager.getInstance(mContext).getSessionList(sessionParam.sortUpdateTimeBegin, sessionParam.sortUpdateTimeEnd, i, sessionParam.mode, sessionParam.needTop, sessionParam.allChatTypes, sessionParam);
            Utility.addEventList(methodInfo.eventList, "getSessionList");
            GetSessionResult getSessionResult = new GetSessionResult();
            getSessionResult.hasMore = false;
            if (sessionList != null && sessionList.size() > Math.abs(sessionParam.count)) {
                sessionList = sessionList.subList(0, Math.abs(sessionParam.count));
                getSessionResult.hasMore = true;
            }
            getSessionResult.sessionList = completeSessionInfo(sessionList);
            Utility.addEventList(methodInfo.eventList, "completeSessionInfo_end");
            if (sessionList != null && sessionList.size() > 0) {
                j = sessionList.get(sessionList.size() - 1).getLastMsgTime();
                for (int size = sessionList.size() - 1; size >= 0; size--) {
                    ChatSession chatSession = sessionList.get(size);
                    if (chatSession.getClassType() <= 1 && chatSession.getIsStranger() == 0) {
                        i2 = chatSession.getMarkTop();
                        break;
                    }
                }
            } else {
                j = 0;
            }
            i2 = 0;
            Utility.addEventList(methodInfo.eventList, "markTop_end");
            if (TextUtils.isEmpty(sessionParam.screenKey)) {
                int busiSessionTotalUnread = getInstance(mContext).getBusiSessionTotalUnread(27);
                int totalUnReadMsgCountByAdvisory = ChatMsgManager.getTotalUnReadMsgCountByAdvisory(mContext, 0L);
                if (busiSessionTotalUnread > 0 || totalUnReadMsgCountByAdvisory > 0) {
                    List<ChatSession> sessionByGfhPA = getInstance(mContext).getSessionByGfhPA(27, sessionParam.timeInterval);
                    if (sessionByGfhPA != null && !sessionByGfhPA.isEmpty()) {
                        if (busiSessionTotalUnread > 0) {
                            i4 = busiSessionTotalUnread;
                        } else {
                            i4 = -1;
                        }
                        getSessionResult.weakConsultUnread = i4;
                        i5 = 0;
                        for (ChatSession chatSession2 : sessionByGfhPA) {
                            i5 = (int) (i5 + chatSession2.getNewMsgSum());
                        }
                        LogUtils.d(TAG, "时间区间 : " + sessionParam.timeInterval + " 秒 , 咨询订单未读 : " + busiSessionTotalUnread + ", 问一问官方号未读（未弱化） : " + totalUnReadMsgCountByAdvisory + ", 问一问官方号未读（弱化后） : " + i5);
                        if (busiSessionTotalUnread <= 0) {
                            getSessionResult.consultUnread = busiSessionTotalUnread;
                        } else {
                            if (totalUnReadMsgCountByAdvisory > 0) {
                                i6 = -1;
                            } else {
                                i6 = 0;
                            }
                            getSessionResult.consultUnread = i6;
                        }
                        int strangerUnReadCount = ChatMessageDBManager.getInstance(mContext).getStrangerUnReadCount(0L);
                        getSessionResult.dotUnread = strangerUnReadCount;
                        if (sessionParam.timeInterval <= 0 && strangerUnReadCount > 0 && ((strangerSessionList = ChatMessageDBManager.getInstance(mContext).getStrangerSessionList(TimeUtil.getTimeSecondByInterval(sessionParam.timeInterval), Long.MAX_VALUE, 1)) == null || strangerSessionList.size() == 0)) {
                            i7 = 0;
                            getSessionResult.dotUnread = 0;
                        } else {
                            i7 = 0;
                        }
                        int newMsgCountWithStranger = ChatMessageDBManager.getInstance(mContext).getNewMsgCountWithStranger(sessionParam.userNumChatTypes, i7, sessionParam.timeInterval);
                        newMsgCountWithStrangerAndNoDisturb = ChatMessageDBManager.getInstance(mContext).getNewMsgCountWithStrangerAndNoDisturb(sessionParam.userNumChatTypes, i7, sessionParam.timeInterval);
                        getSessionResult.privateChatNoDisturbNumber = newMsgCountWithStrangerAndNoDisturb;
                        if (newMsgCountWithStrangerAndNoDisturb < 0) {
                            getSessionResult.privateChatNoDisturbNumber = i7;
                        }
                        getSessionResult.totalUnread = (newMsgCountWithStranger - Math.max(i5, i7)) - getSessionResult.privateChatNoDisturbNumber;
                        LogUtils.d(TAG, "最终返回结果 ===> 陌生人未读 : " + getSessionResult.dotUnread + " 咨询的总未读数: " + getSessionResult.consultUnread + " 包含官方号的总未读 : " + newMsgCountWithStranger + " 去除官方号的总未读: " + getSessionResult.totalUnread + " 私信免打扰未读数：" + getSessionResult.privateChatNoDisturbNumber);
                    } else {
                        List<ChatSession> businessChatSessions = BusinessMessageDBManager.getInstance(mContext).getBusinessChatSessions(27, 1, sessionParam.timeInterval, System.currentTimeMillis() / 1000, false, false);
                        if (businessChatSessions != null && !businessChatSessions.isEmpty()) {
                            if (busiSessionTotalUnread > 0) {
                                i3 = busiSessionTotalUnread;
                            } else {
                                i3 = -1;
                            }
                            getSessionResult.weakConsultUnread = i3;
                        }
                    }
                }
                i5 = 0;
                LogUtils.d(TAG, "时间区间 : " + sessionParam.timeInterval + " 秒 , 咨询订单未读 : " + busiSessionTotalUnread + ", 问一问官方号未读（未弱化） : " + totalUnReadMsgCountByAdvisory + ", 问一问官方号未读（弱化后） : " + i5);
                if (busiSessionTotalUnread <= 0) {
                }
                int strangerUnReadCount2 = ChatMessageDBManager.getInstance(mContext).getStrangerUnReadCount(0L);
                getSessionResult.dotUnread = strangerUnReadCount2;
                if (sessionParam.timeInterval <= 0) {
                }
                i7 = 0;
                int newMsgCountWithStranger2 = ChatMessageDBManager.getInstance(mContext).getNewMsgCountWithStranger(sessionParam.userNumChatTypes, i7, sessionParam.timeInterval);
                newMsgCountWithStrangerAndNoDisturb = ChatMessageDBManager.getInstance(mContext).getNewMsgCountWithStrangerAndNoDisturb(sessionParam.userNumChatTypes, i7, sessionParam.timeInterval);
                getSessionResult.privateChatNoDisturbNumber = newMsgCountWithStrangerAndNoDisturb;
                if (newMsgCountWithStrangerAndNoDisturb < 0) {
                }
                getSessionResult.totalUnread = (newMsgCountWithStranger2 - Math.max(i5, i7)) - getSessionResult.privateChatNoDisturbNumber;
                LogUtils.d(TAG, "最终返回结果 ===> 陌生人未读 : " + getSessionResult.dotUnread + " 咨询的总未读数: " + getSessionResult.consultUnread + " 包含官方号的总未读 : " + newMsgCountWithStranger2 + " 去除官方号的总未读: " + getSessionResult.totalUnread + " 私信免打扰未读数：" + getSessionResult.privateChatNoDisturbNumber);
            }
            Utility.addEventList(methodInfo.eventList, "session_onResult");
            if (bIMValuesCallBack != null) {
                bIMValuesCallBack.onResult(0, Constants.ERROR_MSG_SUCCESS, getSessionResult, SessionParam.getListNextParam(sessionParam.businessType, sessionParam.mode, j, i2));
                methodInfo.errCode = 0;
                methodInfo.errMsg = "getChatSession_Sucess!";
                methodInfo.endTime = System.currentTimeMillis();
                ScreenUbc.onEvent(mContext, sessionParam.screenKey, methodInfo);
            }
        }
    }

    public void getChatSessionsByBusiness(int i, int i2, long j, long j2, long j3, int i3, int i4, int i5, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iMediaGetChatSessionListener}) == null) {
            if (AccountManager.isCuidLogin(mContext)) {
                if (iMediaGetChatSessionListener != null) {
                    iMediaGetChatSessionListener.onMediaGetChatSessionResult(0, 0, 0, false, null);
                    return;
                }
                return;
            }
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, i, j, j2, j3, i2, i3, i5, iMediaGetChatSessionListener, i4) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatSessionManagerImpl this$0;
                public final /* synthetic */ long val$beginMsgid;
                public final /* synthetic */ int val$businessType;
                public final /* synthetic */ long val$contacterImUk;
                public final /* synthetic */ int val$count;
                public final /* synthetic */ long val$endMsgid;
                public final /* synthetic */ int val$fetchType;
                public final /* synthetic */ IMediaGetChatSessionListener val$listener;
                public final /* synthetic */ int val$reason;
                public final /* synthetic */ int val$sessionType;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r3;
                        Object[] objArr = {this, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i5), iMediaGetChatSessionListener, Integer.valueOf(i4)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i6 = newInitContext.flag;
                        if ((i6 & 1) != 0) {
                            int i7 = i6 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$businessType = i;
                    this.val$contacterImUk = j;
                    this.val$beginMsgid = j2;
                    this.val$endMsgid = j3;
                    this.val$sessionType = i2;
                    this.val$count = i3;
                    this.val$fetchType = i5;
                    this.val$listener = iMediaGetChatSessionListener;
                    this.val$reason = i4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    long j4;
                    boolean z;
                    boolean z2;
                    int i6;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        LogUtils.d(ChatSessionManagerImpl.TAG, "getChatSessionsByBusiness businessType = " + this.val$businessType + " contacterImUk = " + this.val$contacterImUk + " beginMsgid = " + this.val$beginMsgid + " endMsgid = " + this.val$endMsgid + " sessionType = " + this.val$sessionType + " count = " + this.val$count + " sessionType = " + this.val$sessionType);
                        List<ChatSession> busiChatSessionsFromDb = this.this$0.getBusiChatSessionsFromDb(this.val$businessType, this.val$sessionType, this.val$contacterImUk, this.val$beginMsgid, this.val$endMsgid, this.val$count, this.val$fetchType);
                        if (!BIMManager.isIMLogined(ChatSessionManagerImpl.mContext)) {
                            j4 = -1;
                        } else {
                            j4 = this.this$0.getBusiSessionCredibleMsgid(this.val$businessType);
                        }
                        if (this.val$fetchType != 2 && j4 > this.val$beginMsgid && (busiChatSessionsFromDb == null || busiChatSessionsFromDb.size() != Math.abs(this.val$count))) {
                            if (BIMManager.isIMLogined(ChatSessionManagerImpl.mContext)) {
                                this.this$0.updateBusiSessionAndGet(this.val$businessType, this.val$sessionType, this.val$contacterImUk, this.val$beginMsgid, this.val$endMsgid, this.val$count, this.val$reason, this.val$fetchType, this.val$listener);
                            } else if (this.val$listener != null) {
                                if (busiChatSessionsFromDb != null && busiChatSessionsFromDb.size() == Math.abs(this.val$count)) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                ChatSessionManagerImpl chatSessionManagerImpl = this.this$0;
                                IMediaGetChatSessionListener iMediaGetChatSessionListener2 = this.val$listener;
                                if (busiChatSessionsFromDb != null && busiChatSessionsFromDb.size() > 0) {
                                    i6 = 0;
                                } else {
                                    i6 = 1030;
                                }
                                chatSessionManagerImpl.onMediaGetSessionResult(iMediaGetChatSessionListener2, i6, this.this$0.getBusiSessionTotalUnread(this.val$businessType), 0, z2, busiChatSessionsFromDb, this.val$contacterImUk);
                            }
                        } else if (this.val$listener != null) {
                            if (busiChatSessionsFromDb != null && busiChatSessionsFromDb.size() == Math.abs(this.val$count)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            ChatSessionManagerImpl chatSessionManagerImpl2 = this.this$0;
                            chatSessionManagerImpl2.onMediaGetSessionResult(this.val$listener, 0, chatSessionManagerImpl2.getBusiSessionTotalUnread(this.val$businessType), 0, z, busiChatSessionsFromDb, this.val$contacterImUk);
                        }
                    }
                }
            });
        }
    }

    public void updateBusiSessionAndGet(int i, int i2, long j, long j2, long j3, int i3, int i4, int i5, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        long j4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iMediaGetChatSessionListener}) == null) {
            if (i4 == 3 && j == 0) {
                j4 = Math.min(j3, getBusiSessionCredibleMsgid(i) - 1);
            } else {
                j4 = j3;
            }
            getBusiSessionFromServer(i, i2, j, j2, j4, i3, new IMediaGetChatSessionListener(this, i, i4, iMediaGetChatSessionListener, i2, j, j2, j3, i3, i5) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatSessionManagerImpl this$0;
                public final /* synthetic */ long val$beginMsgid;
                public final /* synthetic */ int val$businessType;
                public final /* synthetic */ long val$contacterImUk;
                public final /* synthetic */ int val$count;
                public final /* synthetic */ long val$endMsgid;
                public final /* synthetic */ int val$fetchType;
                public final /* synthetic */ IMediaGetChatSessionListener val$listener;
                public final /* synthetic */ int val$reason;
                public final /* synthetic */ int val$sessionType;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r4;
                        Object[] objArr = {this, Integer.valueOf(i), Integer.valueOf(i4), iMediaGetChatSessionListener, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i5)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i6 = newInitContext.flag;
                        if ((i6 & 1) != 0) {
                            int i7 = i6 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$businessType = i;
                    this.val$reason = i4;
                    this.val$listener = iMediaGetChatSessionListener;
                    this.val$sessionType = i2;
                    this.val$contacterImUk = j;
                    this.val$beginMsgid = j2;
                    this.val$endMsgid = j3;
                    this.val$count = i3;
                    this.val$fetchType = i5;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener
                public void onMediaGetChatSessionResult(int i6, int i7, int i8, boolean z, List<ChatSession> list) {
                    boolean z2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z), list}) == null) {
                        if (i6 == 0 && list != null && list.size() > 0) {
                            this.this$0.setBusiSessionTotalUnread(this.val$businessType, i7);
                            long j5 = Long.MAX_VALUE;
                            for (ChatSession chatSession : list) {
                                if (j5 > chatSession.getLastMsgId()) {
                                    j5 = chatSession.getLastMsgId();
                                }
                            }
                            if (this.val$reason != 0) {
                                if (j5 < this.this$0.getBusiSessionCredibleMsgid(this.val$businessType)) {
                                    this.this$0.setBusiSessionCredibleMsgid(this.val$businessType, j5);
                                }
                            } else {
                                this.this$0.setBusiSessionCredibleMsgid(this.val$businessType, j5);
                            }
                            BusinessMessageDBManager.getInstance(ChatSessionManagerImpl.mContext).replaceBusinessSession(list);
                        }
                        IMediaGetChatSessionListener iMediaGetChatSessionListener2 = this.val$listener;
                        if (iMediaGetChatSessionListener2 != null) {
                            if (this.val$reason == 2) {
                                iMediaGetChatSessionListener2.onMediaGetChatSessionResult(i6, i7, 0, z, list);
                                return;
                            }
                            List<ChatSession> busiChatSessionsFromDb = this.this$0.getBusiChatSessionsFromDb(this.val$businessType, this.val$sessionType, this.val$contacterImUk, this.val$beginMsgid, this.val$endMsgid, this.val$count, this.val$fetchType);
                            IMediaGetChatSessionListener iMediaGetChatSessionListener3 = this.val$listener;
                            int busiSessionTotalUnread = this.this$0.getBusiSessionTotalUnread(this.val$businessType);
                            if (busiChatSessionsFromDb != null && busiChatSessionsFromDb.size() > 0 && z) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            iMediaGetChatSessionListener3.onMediaGetChatSessionResult(0, busiSessionTotalUnread, 0, z2, busiChatSessionsFromDb);
                        }
                    }
                }
            });
        }
    }

    public void getFilterSessionsByBusiness(int i, long j, long j2, int i2, Map<String, Integer> map, List<Integer> list, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), map, list, iMediaGetChatSessionListener}) == null) {
            if (AccountManager.isCuidLogin(mContext)) {
                if (iMediaGetChatSessionListener != null) {
                    iMediaGetChatSessionListener.onMediaGetChatSessionResult(0, 0, 0, false, null);
                    return;
                }
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                try {
                    if (!map.isEmpty()) {
                        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (Integer num : list) {
                    jSONArray.put(num.intValue());
                }
                jSONObject.put("consult_follow_state", jSONArray);
            }
            Intent creatMethodIntent = Utility.creatMethodIntent(mContext, Constants.METHOD_IM_CONSULT_IM_FILTER_SESSION_MSG);
            String addListener = ListenerManager.getInstance().addListener(iMediaGetChatSessionListener);
            creatMethodIntent.putExtra("count", i2);
            creatMethodIntent.putExtra(Constants.EXTRA_BEGIN_MSGID, j);
            creatMethodIntent.putExtra(Constants.EXTRA_END_MSGID, j2);
            creatMethodIntent.putExtra(Constants.EXTRA_BUSINESS_TYPE, i);
            creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            creatMethodIntent.putExtra(Constants.EXTRA_BUSINESS_FILTER_INFO, jSONObject.toString());
            try {
                x80.e(mContext).d(mContext, creatMethodIntent);
            } catch (Exception e) {
                LogUtils.e(TAG, "getFilterSessionsByBusiness Exception ", e);
                ListenerManager.getInstance().removeListener(addListener);
                if (iMediaGetChatSessionListener != null) {
                    iMediaGetChatSessionListener.onMediaGetChatSessionResult(1003, 0, 0, false, null);
                }
            }
        }
    }

    public void mediaDeleteChatSession(long j, int i, long j2, String str, long j3, int i2, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), Integer.valueOf(i2), iMediaDeleteChatSessionListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", lastTime=" + j3 + ", listener=" + iMediaDeleteChatSessionListener);
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                if (AccountManager.getMediaRole(mContext)) {
                    IMMediaDeleteSessionRequest iMMediaDeleteSessionRequest = new IMMediaDeleteSessionRequest(mContext, j, i, j2, str, i2, j3, ListenerManager.getInstance().addListener(iMediaDeleteChatSessionListener));
                    HttpHelper.executor(mContext, iMMediaDeleteSessionRequest, iMMediaDeleteSessionRequest);
                } else if (iMediaDeleteChatSessionListener != null) {
                    iMediaDeleteChatSessionListener.onMediaDeleteChatSessionResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR);
                }
            } else if (iMediaDeleteChatSessionListener != null) {
                iMediaDeleteChatSessionListener.onMediaDeleteChatSessionResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            }
        }
    }

    public void onDelBusinessSessionResult(int i, String str, int i2, int i3, int i4, long j, String str2) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j), str2}) == null) {
            if (i == 0) {
                List<ChatSession> busiChatSessions = BusinessMessageDBManager.getInstance(mContext).getBusiChatSessions(i2, i3, j, 0L, Long.MAX_VALUE, -1, 1);
                int i5 = 0;
                if (busiChatSessions != null && busiChatSessions.size() > 0) {
                    j2 = busiChatSessions.get(0).getNewMsgSum();
                } else {
                    j2 = 0;
                }
                LogUtils.d(TAG, "lastUnreadCount : " + j2);
                int busiSessionTotalUnread = getBusiSessionTotalUnread(i2);
                if (busiSessionTotalUnread > 99) {
                    getBusiSessionFromServer(i2, i3, j, 0L, Long.MAX_VALUE, 1, new IMediaGetChatSessionListener(this, busiSessionTotalUnread, i2) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.11
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ChatSessionManagerImpl this$0;
                        public final /* synthetic */ int val$businessType;
                        public final /* synthetic */ int val$totalUnread;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(busiSessionTotalUnread), Integer.valueOf(i2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i6 = newInitContext.flag;
                                if ((i6 & 1) != 0) {
                                    int i7 = i6 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$totalUnread = busiSessionTotalUnread;
                            this.val$businessType = i2;
                        }

                        @Override // com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener
                        public void onMediaGetChatSessionResult(int i6, int i7, int i8, boolean z, List<ChatSession> list) {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 != null && interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z), list}) != null) || this.val$totalUnread == i7) {
                                return;
                            }
                            this.this$0.setBusiSessionTotalUnread(this.val$businessType, i7);
                            BusinessMessageDBManager.getInstance(ChatSessionManagerImpl.mContext).notifySessionChange(3);
                        }
                    });
                } else {
                    long j3 = busiSessionTotalUnread - j2;
                    if (j3 >= 0) {
                        i5 = (int) j3;
                    }
                    setBusiSessionTotalUnread(i2, i5);
                }
                LogUtils.d(TAG, "delMsgCount : " + ChatMsgManagerImpl.getInstance(mContext).deleteDBBusiMsgs(i4, j, i2, i3) + " -- delSessionCount: " + getInstance(mContext).delDbBusiChatSession(i4, i2, i3, j));
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(str2);
            if (removeListener instanceof IDelBusinessChatSessionListener) {
                ((IDelBusinessChatSessionListener) removeListener).onResult(i, str);
            } else if (removeListener instanceof BIMValueCallBack) {
                ((BIMValueCallBack) removeListener).onResult(i, str, null);
            }
        }
    }

    public void getMediaMixedChatSessions(long j, int i, long j2, String str, long j3, int i2, int i3, IGetMediaMixedChatSessionListener iGetMediaMixedChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), iGetMediaMixedChatSessionListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", startSessionTime=" + j3 + ", count=" + i2 + ", needTop=" + i3 + ", listener=" + iGetMediaMixedChatSessionListener);
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                if (AccountManager.getMediaRole(mContext)) {
                    IMMediaGetChatSessionRequest iMMediaGetChatSessionRequest = new IMMediaGetChatSessionRequest(mContext, j, i, j2, str, i2, j3, i3, ListenerManager.getInstance().addListener(iGetMediaMixedChatSessionListener));
                    HttpHelper.executor(mContext, iMMediaGetChatSessionRequest, iMMediaGetChatSessionRequest);
                } else if (iGetMediaMixedChatSessionListener != null) {
                    iGetMediaMixedChatSessionListener.onMediaGetChatSessionResult(2000, 0, 0, 0, false, null);
                }
            } else if (iGetMediaMixedChatSessionListener != null) {
                iGetMediaMixedChatSessionListener.onMediaGetChatSessionResult(1000, 0, 0, 0, false, null);
            }
        }
    }

    public void mediaGetChatSessions(long j, int i, long j2, String str, long j3, int i2, int i3, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), iMediaGetChatSessionListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", startSessionTime=" + j3 + ", count=" + i2 + ", needTop=" + i3 + ", listener=" + iMediaGetChatSessionListener);
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                if (AccountManager.getMediaRole(mContext)) {
                    IMMediaGetChatSessionRequest iMMediaGetChatSessionRequest = new IMMediaGetChatSessionRequest(mContext, j, i, j2, str, i2, j3, i3, ListenerManager.getInstance().addListener(iMediaGetChatSessionListener));
                    HttpHelper.executor(mContext, iMMediaGetChatSessionRequest, iMMediaGetChatSessionRequest);
                } else if (iMediaGetChatSessionListener != null) {
                    iMediaGetChatSessionListener.onMediaGetChatSessionResult(2000, 0, 0, false, null);
                }
            } else if (iMediaGetChatSessionListener != null) {
                iMediaGetChatSessionListener.onMediaGetChatSessionResult(1000, 0, 0, false, null);
            }
        }
    }

    public void onMarkBusinessSessionReadResult(int i, String str, int i2, int i3, int i4, long j, long j2, String str2) {
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j), Long.valueOf(j2), str2}) == null) {
            if (i == 0) {
                BusinessMessageDBManager.getInstance(mContext).setBusinessChatMsgRead(i2, i3, j, j2);
                List<ChatSession> busiChatSessions = BusinessMessageDBManager.getInstance(mContext).getBusiChatSessions(i2, i3, j, 0L, Long.MAX_VALUE, -1, 1);
                int i5 = 0;
                if (busiChatSessions != null && busiChatSessions.size() > 0) {
                    j3 = busiChatSessions.get(0).getNewMsgSum();
                } else {
                    j3 = 0;
                }
                int busiSessionTotalUnread = getBusiSessionTotalUnread(i2);
                if (busiSessionTotalUnread > 99) {
                    getBusiSessionFromServer(i2, i3, j, 0L, Long.MAX_VALUE, 1, new IMediaGetChatSessionListener(this, busiSessionTotalUnread, i2) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.10
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ChatSessionManagerImpl this$0;
                        public final /* synthetic */ int val$businessType;
                        public final /* synthetic */ int val$totalUnread;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(busiSessionTotalUnread), Integer.valueOf(i2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i6 = newInitContext.flag;
                                if ((i6 & 1) != 0) {
                                    int i7 = i6 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$totalUnread = busiSessionTotalUnread;
                            this.val$businessType = i2;
                        }

                        @Override // com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener
                        public void onMediaGetChatSessionResult(int i6, int i7, int i8, boolean z, List<ChatSession> list) {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 != null && interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z), list}) != null) || this.val$totalUnread == i7) {
                                return;
                            }
                            this.this$0.setBusiSessionTotalUnread(this.val$businessType, i7);
                            BusinessMessageDBManager.getInstance(ChatSessionManagerImpl.mContext).notifySessionChange(3);
                        }
                    });
                } else {
                    long j4 = busiSessionTotalUnread - j3;
                    if (j4 >= 0) {
                        i5 = (int) j4;
                    }
                    setBusiSessionTotalUnread(i2, i5);
                }
                BusinessMessageDBManager.getInstance(mContext).setBusinessSessionRead(i2, i3, j, 0);
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(str2);
            if (removeListener instanceof IMediaSetSessionReadListener) {
                ((IMediaSetSessionReadListener) removeListener).onMediaSetSessionReadResult(i, str);
            } else if (removeListener instanceof BIMValueCallBack) {
                ((BIMValueCallBack) removeListener).onResult(i, str, null);
            }
        }
    }

    public List<ChatSession> getSessionByGfhPA(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            ArrayList arrayList = new ArrayList();
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                List<PaInfo> queryPaInfoByExt = PaInfoDBManager.getInstance(mContext).queryPaInfoByExt(String.valueOf(i));
                if (queryPaInfoByExt != null && !queryPaInfoByExt.isEmpty()) {
                    for (PaInfo paInfo : queryPaInfoByExt) {
                        if (paInfo != null) {
                            if (paInfo.getPaId() > 0) {
                                ChatSession chatRecord = ChatMessageDBManager.getInstance(mContext).getChatRecord(new ChatObject(mContext, 0, paInfo.getPaId(), j));
                                if (chatRecord != null) {
                                    chatRecord.setBusinessType(i);
                                    updatePADesc(chatRecord, chatRecord.getLastMsg());
                                    arrayList.add(chatRecord);
                                }
                            }
                        }
                    }
                } else {
                    return arrayList;
                }
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public void getSessionByGfhPA(IMediaGetChatSessionListener iMediaGetChatSessionListener, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, iMediaGetChatSessionListener, i) == null) {
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                List<PaInfo> queryPaInfoByExt = PaInfoDBManager.getInstance(mContext).queryPaInfoByExt(String.valueOf(i));
                if (queryPaInfoByExt != null && !queryPaInfoByExt.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (PaInfo paInfo : queryPaInfoByExt) {
                        if (paInfo != null && paInfo.getPaId() > 0) {
                            ChatSession chatRecord = ChatMessageDBManager.getInstance(mContext).getChatRecord(new ChatObject(mContext, 0, paInfo.getPaId()));
                            if (chatRecord != null) {
                                chatRecord.setBusinessType(i);
                                updatePADesc(chatRecord, chatRecord.getLastMsg());
                                arrayList.add(chatRecord);
                            }
                        }
                    }
                    if (iMediaGetChatSessionListener != null) {
                        iMediaGetChatSessionListener.onMediaGetChatSessionResult(0, ChatMsgManager.getTotalUnReadMsgCountByAdvisory(mContext, 0L), 0, false, arrayList);
                    }
                } else if (iMediaGetChatSessionListener != null) {
                    iMediaGetChatSessionListener.onMediaGetChatSessionResult(0, 0, 0, false, null);
                }
            } else if (iMediaGetChatSessionListener != null) {
                iMediaGetChatSessionListener.onMediaGetChatSessionResult(1000, 0, 0, false, null);
            }
        }
    }

    public void mediaContactorSetting(long j, int i, long j2, String str, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Integer.valueOf(i2), iMediaContactorSettingListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", operation" + i2 + ", listener=" + iMediaContactorSettingListener);
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                if (AccountManager.getMediaRole(mContext)) {
                    IMMediaContactorSettingRequest iMMediaContactorSettingRequest = new IMMediaContactorSettingRequest(mContext, j, i, j2, str, i2, ListenerManager.getInstance().addListener(iMediaContactorSettingListener));
                    HttpHelper.executor(mContext, iMMediaContactorSettingRequest, iMMediaContactorSettingRequest);
                } else if (iMediaContactorSettingListener != null) {
                    iMediaContactorSettingListener.onMediaContactorSettingResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR, -1);
                }
            } else if (iMediaContactorSettingListener != null) {
                iMediaContactorSettingListener.onMediaContactorSettingResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, -1);
            }
        }
    }

    public void mediaGetContactorSetting(long j, int i, long j2, String str, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Integer.valueOf(i2), iMediaContactorSettingListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", setting=" + i2 + ", listener=" + iMediaContactorSettingListener);
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                if (AccountManager.getMediaRole(mContext)) {
                    IMMediaGetContactorSettingRequest iMMediaGetContactorSettingRequest = new IMMediaGetContactorSettingRequest(mContext, j, i, j2, str, i2, ListenerManager.getInstance().addListener(iMediaContactorSettingListener));
                    HttpHelper.executor(mContext, iMMediaGetContactorSettingRequest, iMMediaGetContactorSettingRequest);
                } else if (iMediaContactorSettingListener != null) {
                    iMediaContactorSettingListener.onMediaContactorSettingResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR, -1);
                }
            } else if (iMediaContactorSettingListener != null) {
                iMediaContactorSettingListener.onMediaContactorSettingResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, -1);
            }
        }
    }

    public void mediaSetSessionRead(long j, int i, long j2, String str, long j3, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), iMediaSetSessionReadListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", lastTime=" + j3 + ", listener=" + iMediaSetSessionReadListener);
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                if (!AccountManager.getMediaRole(mContext) && i != -1) {
                    if (iMediaSetSessionReadListener != null) {
                        iMediaSetSessionReadListener.onMediaSetSessionReadResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR);
                        return;
                    }
                    return;
                }
                IMMediaSetSessionReadRequest iMMediaSetSessionReadRequest = new IMMediaSetSessionReadRequest(mContext, j, i, j2, str, j3, ListenerManager.getInstance().addListener(iMediaSetSessionReadListener));
                HttpHelper.executor(mContext, iMMediaSetSessionReadRequest, iMMediaSetSessionReadRequest);
            } else if (iMediaSetSessionReadListener != null) {
                iMediaSetSessionReadListener.onMediaSetSessionReadResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            }
        }
    }

    public void mediaContactorSetting(long j, int i, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), iMediaContactorSettingListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", operation" + i + ", listener=" + iMediaContactorSettingListener);
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                if (AccountManager.getMediaRole(mContext)) {
                    IMMediaContactorSettingRequest iMMediaContactorSettingRequest = new IMMediaContactorSettingRequest(mContext, j, i, ListenerManager.getInstance().addListener(iMediaContactorSettingListener));
                    HttpHelper.executor(mContext, iMMediaContactorSettingRequest, iMMediaContactorSettingRequest);
                } else if (iMediaContactorSettingListener != null) {
                    iMediaContactorSettingListener.onMediaContactorSettingResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR, -1);
                }
            } else if (iMediaContactorSettingListener != null) {
                iMediaContactorSettingListener.onMediaContactorSettingResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, -1);
            }
        }
    }

    public void mediaDeleteChatSession(long j, long j2, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), iMediaDeleteChatSessionListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", lastTime=" + j2 + ", listener=" + iMediaDeleteChatSessionListener);
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                if (AccountManager.getMediaRole(mContext)) {
                    IMMediaDeleteSessionRequest iMMediaDeleteSessionRequest = new IMMediaDeleteSessionRequest(mContext, j, j2, ListenerManager.getInstance().addListener(iMediaDeleteChatSessionListener));
                    HttpHelper.executor(mContext, iMMediaDeleteSessionRequest, iMMediaDeleteSessionRequest);
                } else if (iMediaDeleteChatSessionListener != null) {
                    iMediaDeleteChatSessionListener.onMediaDeleteChatSessionResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR);
                }
            } else if (iMediaDeleteChatSessionListener != null) {
                iMediaDeleteChatSessionListener.onMediaDeleteChatSessionResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            }
        }
    }

    public void mediaGetContactorSetting(long j, int i, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), iMediaContactorSettingListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", setting=" + i + ", listener=" + iMediaContactorSettingListener);
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                IMMediaGetContactorSettingRequest iMMediaGetContactorSettingRequest = new IMMediaGetContactorSettingRequest(mContext, j, i, ListenerManager.getInstance().addListener(iMediaContactorSettingListener));
                HttpHelper.executor(mContext, iMMediaGetContactorSettingRequest, iMMediaGetContactorSettingRequest);
            } else if (iMediaContactorSettingListener != null) {
                iMediaContactorSettingListener.onMediaContactorSettingResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, -1);
            }
        }
    }

    public void mediaSetSessionRead(long j, long j2, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), iMediaSetSessionReadListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", lastTime" + j2 + ", listener=" + iMediaSetSessionReadListener);
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                if (AccountManager.getMediaRole(mContext)) {
                    IMMediaSetSessionReadRequest iMMediaSetSessionReadRequest = new IMMediaSetSessionReadRequest(mContext, j, j2, ListenerManager.getInstance().addListener(iMediaSetSessionReadListener));
                    HttpHelper.executor(mContext, iMMediaSetSessionReadRequest, iMMediaSetSessionReadRequest);
                } else if (iMediaSetSessionReadListener != null) {
                    iMediaSetSessionReadListener.onMediaSetSessionReadResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR);
                }
            } else if (iMediaSetSessionReadListener != null) {
                iMediaSetSessionReadListener.onMediaSetSessionReadResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            }
        }
    }

    public void mediaGetChatSessions(long j, long j2, int i, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), iMediaGetChatSessionListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", startSessionTime=" + j2 + ", count=" + i + ", listener=" + iMediaGetChatSessionListener);
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                if (AccountManager.getMediaRole(mContext)) {
                    IMMediaGetChatSessionRequest iMMediaGetChatSessionRequest = new IMMediaGetChatSessionRequest(mContext, j, i, j2, ListenerManager.getInstance().addListener(iMediaGetChatSessionListener));
                    HttpHelper.executor(mContext, iMMediaGetChatSessionRequest, iMMediaGetChatSessionRequest);
                } else if (iMediaGetChatSessionListener != null) {
                    iMediaGetChatSessionListener.onMediaGetChatSessionResult(2000, 0, 0, false, null);
                }
            } else if (iMediaGetChatSessionListener != null) {
                iMediaGetChatSessionListener.onMediaGetChatSessionResult(1000, 0, 0, false, null);
            }
        }
    }

    public void mediaGetContactorPauid(long j, int i, long j2, String str, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, iMediaGetContactorPauidListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", listener=" + iMediaGetContactorPauidListener);
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                IMMediaGetContactorPauidRequest iMMediaGetContactorPauidRequest = new IMMediaGetContactorPauidRequest(mContext, j, i, j2, str, ListenerManager.getInstance().addListener(iMediaGetContactorPauidListener));
                HttpHelper.executor(mContext, iMMediaGetContactorPauidRequest, iMMediaGetContactorPauidRequest);
            } else if (iMediaGetContactorPauidListener != null) {
                iMediaGetContactorPauidListener.onMediaGetContactorPauidResult(1000, "", -1L, -1, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            }
        }
    }

    public void onFetchBusiChatSessionResult(int i, boolean z, int i2, List<ChatSession> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), list, str}) == null) {
            IMediaGetChatSessionListener iMediaGetChatSessionListener = (IMediaGetChatSessionListener) ListenerManager.getInstance().removeListener(str);
            if (i == 0) {
                if (list != null && list.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (ChatSession chatSession : list) {
                        if (chatSession != null) {
                            arrayList.add(Long.valueOf(chatSession.getContacterId()));
                        }
                    }
                    LongSparseArray<ChatUser> chatUserByBduids = ChatUserDBManager.getInstance(mContext).getChatUserByBduids(arrayList);
                    ArrayList arrayList2 = new ArrayList();
                    if (chatUserByBduids != null) {
                        for (int i3 = 0; i3 < chatUserByBduids.size(); i3++) {
                            for (int i4 = 0; i4 < list.size(); i4++) {
                                if (chatUserByBduids.valueAt(i3).getBuid() == list.get(i4).getContacterId()) {
                                    ChatSession updateChatSessionByChatUser = updateChatSessionByChatUser(list.get(i4), chatUserByBduids.valueAt(i3));
                                    if (updateChatSessionByChatUser != null) {
                                        arrayList2.add(updateChatSessionByChatUser);
                                    }
                                    arrayList.remove(Long.valueOf(chatUserByBduids.keyAt(i3)));
                                }
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        ChatUserManagerImpl.getInstance(mContext).updateUserIdentity(arrayList, new IGetUserIdentityListener(this, list, arrayList2, iMediaGetChatSessionListener, i, i2, z) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.8
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ChatSessionManagerImpl this$0;
                            public final /* synthetic */ List val$chatSessions;
                            public final /* synthetic */ boolean val$hasMore;
                            public final /* synthetic */ IMediaGetChatSessionListener val$listener;
                            public final /* synthetic */ List val$result;
                            public final /* synthetic */ int val$resultCode;
                            public final /* synthetic */ int val$totalUnread;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, list, arrayList2, iMediaGetChatSessionListener, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i5 = newInitContext.flag;
                                    if ((i5 & 1) != 0) {
                                        int i6 = i5 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$chatSessions = list;
                                this.val$result = arrayList2;
                                this.val$listener = iMediaGetChatSessionListener;
                                this.val$resultCode = i;
                                this.val$totalUnread = i2;
                                this.val$hasMore = z;
                            }

                            @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
                            public void onGetUserIdentityResult(int i5, List<ChatUser> list2) {
                                ChatSession updateChatSessionByChatUser2;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i5, list2) == null) {
                                    if (i5 == 0 && list2.size() > 0) {
                                        ChatUserDBManager.getInstance(ChatSessionManagerImpl.mContext).updateUserIdentity(list2);
                                        for (ChatUser chatUser : list2) {
                                            for (int i6 = 0; i6 < this.val$chatSessions.size(); i6++) {
                                                if (chatUser.getBuid() == ((ChatSession) this.val$chatSessions.get(i6)).getContacterId() && (updateChatSessionByChatUser2 = this.this$0.updateChatSessionByChatUser((ChatSession) this.val$chatSessions.get(i6), chatUser)) != null) {
                                                    this.val$result.add(updateChatSessionByChatUser2);
                                                }
                                            }
                                        }
                                    }
                                    IMediaGetChatSessionListener iMediaGetChatSessionListener2 = this.val$listener;
                                    if (iMediaGetChatSessionListener2 != null) {
                                        iMediaGetChatSessionListener2.onMediaGetChatSessionResult(this.val$resultCode, this.val$totalUnread, 0, this.val$hasMore, this.val$result);
                                    }
                                }
                            }
                        });
                    } else if (iMediaGetChatSessionListener != null) {
                        iMediaGetChatSessionListener.onMediaGetChatSessionResult(i, i2, 0, z, arrayList2);
                    }
                } else if (iMediaGetChatSessionListener != null) {
                    iMediaGetChatSessionListener.onMediaGetChatSessionResult(i, i2, 0, z, null);
                }
            } else if (iMediaGetChatSessionListener != null) {
                iMediaGetChatSessionListener.onMediaGetChatSessionResult(i, i2, 0, z, null);
            }
        }
    }

    public void onMediaGetChatSessionRequest(int i, boolean z, int i2, int i3, int i4, Map<Long, ChatSession> map, Map<Long, ChatSession> map2, Map<String, ChatSession> map3, String str) {
        IMListener removeListener;
        IGetUsersProfileBatchListener iGetUsersProfileBatchListener;
        ArrayList<Long> arrayList;
        IGetPaInfosListener iGetPaInfosListener;
        ArrayList arrayList2;
        BIMValueCallBack<ArrayList<GroupInfo>> bIMValueCallBack;
        ArrayList arrayList3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048617, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), map, map2, map3, str}) != null) || (removeListener = ListenerManager.getInstance().removeListener(str)) == null) {
            return;
        }
        IMMediaBuildSessionListener iMMediaBuildSessionListener = new IMMediaBuildSessionListener(mContext, i2, i3, i4, z, removeListener);
        if (i == 0) {
            if (map2 != null && map2.size() > 0) {
                arrayList = new ArrayList<>(map2.keySet());
                iGetUsersProfileBatchListener = iMMediaBuildSessionListener.getUserIdentityListener(map2);
            } else {
                iGetUsersProfileBatchListener = null;
                arrayList = null;
            }
            if (map != null && map.size() > 0) {
                arrayList2 = new ArrayList(map.keySet());
                iGetPaInfosListener = iMMediaBuildSessionListener.getPaInfosListener(map);
            } else {
                iGetPaInfosListener = null;
                arrayList2 = null;
            }
            if (map3 != null && map3.size() > 0) {
                arrayList3 = new ArrayList(map3.keySet());
                bIMValueCallBack = iMMediaBuildSessionListener.getGroupInfoListener(map3);
            } else {
                bIMValueCallBack = null;
                arrayList3 = null;
            }
            if (iGetUsersProfileBatchListener != null) {
                ChatUserManagerImpl.getInstance(mContext).getUsersProfileBatchByBuid(arrayList, false, iGetUsersProfileBatchListener);
            }
            if (iGetPaInfosListener != null) {
                PaManager.getPaInfos(mContext, arrayList2, false, iGetPaInfosListener);
            }
            if (bIMValueCallBack != null) {
                BIMGroupManager.getFansGroupInfo(mContext, arrayList3, false, bIMValueCallBack);
            }
            if (arrayList == null && arrayList2 == null && arrayList3 == null) {
                iMMediaBuildSessionListener.onResult(i, null, removeListener);
                return;
            }
            return;
        }
        iMMediaBuildSessionListener.onResult(i, null, removeListener);
    }

    public void onSyncDialogResult(int i, String str, String str2, long j, List<DialogRecord> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i), str, str2, Long.valueOf(j), list}) == null) {
            IMListener removeListener = ListenerManager.getInstance().removeListener(str2);
            if (removeListener instanceof ISyncDialogListener) {
                ((ISyncDialogListener) removeListener).onSyncDialogResult(i, str, j, list);
            }
        }
    }

    public void setSessionCollectStatusByBusiness(int i, long j, int i2, int i3, BIMValueCallBack<Void> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), bIMValueCallBack}) == null) {
            if (AccountManager.isCuidLogin(mContext)) {
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                    return;
                }
                return;
            }
            IMUpdateCollectSessionTagRequest iMUpdateCollectSessionTagRequest = new IMUpdateCollectSessionTagRequest(mContext, i, j, i2, i3, bIMValueCallBack);
            HttpHelper.executor(mContext, iMUpdateCollectSessionTagRequest, iMUpdateCollectSessionTagRequest);
        }
    }
}
