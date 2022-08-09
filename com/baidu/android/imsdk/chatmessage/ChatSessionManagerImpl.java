package com.baidu.android.imsdk.chatmessage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.android.imsdk.chatmessage.sync.SyncAllMessage;
import com.baidu.android.imsdk.chatmessage.sync.SyncGroupMessageService;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.group.BIMGroupManager;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.group.db.GroupMessageDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.Dispatcher;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.pubaccount.PaManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.cyberplayer.sdk.dlna.DlnaManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.l60;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ChatSessionManagerImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SessionManagerImpl";
    public static Context mContext;
    public static volatile ChatSessionManagerImpl mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Dispatcher.MsgListener dialogSyncListener;
    public ArrayList<IChatSessionChangeListener> mChatRecordChangeListener;
    public List<IDialogSyncListener> mDialogSyncListeners;
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
        this.mChatRecordChangeListener = new ArrayList<>();
        this.syncDialogListener = new ISyncDialogListener(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.4
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
                            SyncGroupMessageService.getInstance().execute(ChatSessionManagerImpl.mContext, dialogRecord3, 0);
                        }
                    }
                }
            }
        };
        this.dialogSyncListener = new Dispatcher.MsgListener(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.5
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

            @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
            public void dealMessage(int i3, ChatMsg chatMsg) {
                int i4;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, chatMsg) == null) && (chatMsg instanceof DialogSyncMsg)) {
                    DialogSyncMsg dialogSyncMsg = (DialogSyncMsg) chatMsg;
                    int syncCategory = dialogSyncMsg.getSyncCategory();
                    long syncFromUid = dialogSyncMsg.getSyncFromUid();
                    long operatedMaxMsgid = dialogSyncMsg.getOperatedMaxMsgid();
                    int syncStatus = dialogSyncMsg.getSyncStatus();
                    long paid = dialogSyncMsg.getPaid();
                    if (syncStatus == 0) {
                        i4 = syncStatus;
                        r16 = ChatMessageDBManager.getInstance(ChatSessionManagerImpl.mContext).deleteAllMsgWithMsgid(new ChatObject(ChatSessionManagerImpl.mContext, syncCategory, syncFromUid, paid, -1), operatedMaxMsgid);
                        if (r16 > 0 && this.this$0.mDialogSyncListeners != null && this.this$0.mDialogSyncListeners.size() != 0) {
                            for (IDialogSyncListener iDialogSyncListener : this.this$0.mDialogSyncListeners) {
                                iDialogSyncListener.onDialogDel(syncCategory, syncFromUid);
                            }
                        }
                    } else if (syncStatus != 1) {
                        i4 = syncStatus;
                    } else if (operatedMaxMsgid <= 0) {
                        return;
                    } else {
                        i4 = syncStatus;
                        boolean allMsgReadWithMsgid = ChatMessageDBManager.getInstance(ChatSessionManagerImpl.mContext).setAllMsgReadWithMsgid(new ChatObject(ChatSessionManagerImpl.mContext, syncCategory, syncFromUid, paid, -1), operatedMaxMsgid);
                        r16 = allMsgReadWithMsgid ? 1 : -1;
                        if (allMsgReadWithMsgid && this.this$0.mDialogSyncListeners != null && this.this$0.mDialogSyncListeners.size() != 0) {
                            for (IDialogSyncListener iDialogSyncListener2 : this.this$0.mDialogSyncListeners) {
                                iDialogSyncListener2.onDialogReaded(syncCategory, syncFromUid);
                            }
                        }
                    }
                    if (r16 > 0) {
                        Intent intent = new Intent(IMConstants.SYNC_ACTION);
                        intent.setPackage(ChatSessionManagerImpl.mContext.getApplicationContext().getPackageName());
                        intent.putExtra("category", syncCategory);
                        intent.putExtra("contacter", syncFromUid);
                        intent.putExtra(IMConstants.SYNC_MSGID, operatedMaxMsgid);
                        intent.putExtra(IMConstants.SYNC_STATUS, i4);
                        intent.putExtra(IMConstants.SYNC_TYPE, 1);
                        ChatSessionManagerImpl.mContext.sendBroadcast(intent);
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
        Dispatcher.Event event = new Dispatcher.Event();
        event.setCategory(2);
        event.setType(22);
        Dispatcher.registerListener(event, this.dialogSyncListener);
        ChatMessageDBManager.getInstance(mContext).registerObserver(new ChatMessageDBManager.ChatMessageDbOberser(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.1
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

            @Override // com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.ChatMessageDbOberser
            public void notifyDbChange(int i3, ChatSession chatSession) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, chatSession) == null) {
                    this.this$0.triggerChatSessionChangerCallBack(i3, chatSession);
                }
            }
        });
        registerRecordChangeListener(mContext, new IChatSessionChangeListener(this) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.2
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

            @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
            public void onChatRecordDelete(int i3, long j) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), Long.valueOf(j)}) == null) && i3 == 1) {
                    Utility.transformGroupMediaNotify(ChatSessionManagerImpl.mContext, 1, j, 3, 0L);
                }
            }

            @Override // com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener
            public void onChatSessionUpdate(ChatSession chatSession, boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatSession, z) == null) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSessionChangeListenerNotify(int i, ChatSession chatSession, ArrayList<IChatSessionChangeListener> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, this, i, chatSession, arrayList) == null) {
            Iterator<IChatSessionChangeListener> it = arrayList.iterator();
            while (it.hasNext()) {
                IChatSessionChangeListener next = it.next();
                if (next == null) {
                    it.remove();
                } else {
                    boolean z = true;
                    if (IMConfigInternal.getInstance().getProductLine(mContext) != 4 || chatSession.getCategory() == 1) {
                        if (i == 2) {
                            next.onChatRecordDelete(chatSession.getCategory(), chatSession.getContacter());
                        } else if (i == 1) {
                            LogUtils.d(TAG, "triggerChatSessionChange-> listener = " + next.getClass().getSimpleName());
                            try {
                                if (1 == chatSession.getCategory()) {
                                    int state = SyncGroupMessageService.getInstance().getState(mContext);
                                    if (state != 0) {
                                        z = false;
                                    }
                                    long contacter = chatSession.getContacter();
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(String.valueOf(contacter));
                                    ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList2);
                                    if (groupInfo != null && groupInfo.size() > 0 && groupInfo.get(0).getType() == 2) {
                                        chatSession.setChatType(4);
                                    }
                                    LogUtils.d(TAG, "FXF triggerChatSessionChange " + state + " " + z + " chattype: " + chatSession.getChatType() + " id is: " + chatSession.getContacter());
                                    String lastMsg = chatSession.getLastMsg();
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("FXF triggerChatSessionChange lastmsg is: ");
                                    sb.append(lastMsg);
                                    LogUtils.d(TAG, sb.toString());
                                    next.onChatSessionUpdate(chatSession.m27clone(), z);
                                } else {
                                    int state2 = SyncAllMessage.getInstance(mContext).getState();
                                    if (state2 != 0) {
                                        z = false;
                                    }
                                    next.onChatSessionUpdate(chatSession.m27clone(), z);
                                    LogUtils.d(TAG, "FXF triggerChatSessionChange " + state2 + " " + z + " chattype: " + chatSession.getChatType() + " id is: " + chatSession.getContacter());
                                }
                            } catch (CloneNotSupportedException e) {
                                LogUtils.e(TAG, "ChatSessionChangerCallBack throw RuntimeException", e);
                                new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
                                throw new RuntimeException("ChatSession Clone Error!");
                            }
                        }
                    }
                }
            }
        }
    }

    public static ChatSessionManagerImpl getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            Context context = mContext;
            return Math.max(Utility.readLongData(context, "sync_max_msgid_" + Utility.getUK(mContext), 0L), DialogRecordDBManager.getInstance(mContext).getMaxMsgid());
        }
        return invokeV.longValue;
    }

    private void notifySessionChange(int i, ChatSession chatSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65543, this, i, chatSession) == null) {
            ArrayList arrayList = new ArrayList(this.mChatRecordChangeListener);
            if (arrayList.size() == 0) {
                return;
            }
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, i, chatSession, arrayList) { // from class: com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatSessionManagerImpl this$0;
                public final /* synthetic */ ArrayList val$chatRecordChangeListener;
                public final /* synthetic */ int val$operation;
                public final /* synthetic */ ChatSession val$session;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i), chatSession, arrayList};
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
                    this.val$operation = i;
                    this.val$session = chatSession;
                    this.val$chatRecordChangeListener = arrayList;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.doSessionChangeListenerNotify(this.val$operation, this.val$session, this.val$chatRecordChangeListener);
                    }
                }
            });
        }
    }

    private void updateGroupChatSession(ChatSession chatSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, chatSession) == null) {
            if (chatSession.getChatType() == 3 || chatSession.getChatType() == 4 || chatSession.getChatType() == 57) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(String.valueOf(chatSession.getContacter()));
                ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList);
                if (groupInfo == null || groupInfo.size() <= 0) {
                    return;
                }
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
                    if (chatSession.getNewMsgSum() > 0) {
                        ArrayList<ChatMsg> fansGroupAtUnread = GroupMessageDAOImpl.getFansGroupAtUnread(mContext, groupInfo2.getGroupId(), AccountManager.getUid(mContext));
                        if (fansGroupAtUnread != null) {
                            chatSession.setNewFansAtMsgSum(fansGroupAtUnread.size());
                            return;
                        } else {
                            chatSession.setNewFansAtMsgSum(0);
                            return;
                        }
                    }
                    chatSession.setNewFansAtMsgSum(0);
                }
            }
        }
    }

    private void updatePADesc(ChatSession chatSession, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, chatSession, str) == null) {
            int chatType = chatSession.getChatType();
            if (chatType == 7 || chatType == 16 || chatType == 17 || chatType == 27 || chatType == 23 || chatType == 25 || chatType == 26) {
                try {
                    JSONObject jSONObject = new JSONObject(new JSONObject(str).optString("msg"));
                    String optString = jSONObject.optString("ext");
                    if (TextUtils.isEmpty(optString)) {
                        return;
                    }
                    int optInt = new JSONObject(optString).optInt("type", -1);
                    String optString2 = jSONObject.optString("description");
                    if (TextUtils.isEmpty(optString2) || optInt == -1) {
                        return;
                    }
                    chatSession.setLastMsg(optString2);
                } catch (Exception e) {
                    LogUtils.e(TAG, "it doesn't matter>" + e.getMessage());
                }
            }
        }
    }

    private void updateUnsupportDesc(ChatSession chatSession, String str) {
        ChatMsg latestMsg;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, this, chatSession, str) == null) && IMConstants.IS_UPDATE_VERSION && !TextUtils.isEmpty(str) && str.equals(UnSupportedMsg.unSupportedMsgDesc) && (latestMsg = ChatMessageDBManager.getInstance(mContext).getLatestMsg(chatSession.getCategory(), chatSession.getContacter())) != null && BIMManager.isSupportMsgType(latestMsg.getMsgType())) {
            String recommendDescription = latestMsg.getRecommendDescription();
            if (latestMsg instanceof HtmlMsg) {
                recommendDescription = ((HtmlMsg) latestMsg).getLocalUrl();
            }
            if (TextUtils.isEmpty(recommendDescription) || str.equals(recommendDescription)) {
                return;
            }
            chatSession.setLastMsg(recommendDescription);
            ChatMessageDBManager.getInstance(mContext).updateChatSession(1, chatSession);
        }
    }

    public void createChatSession(ChatObject chatObject, String str, int i, String str2, int i2, String str3, String str4, int i3, int i4, long j, int i5, long j2, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{chatObject, str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, str4, Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j), Integer.valueOf(i5), Long.valueOf(j2), str5, str6, str7}) == null) {
            long createChatSession = ChatMessageDBManager.getInstance(mContext).createChatSession(chatObject, str, i, str2, i2, str3, str4, i3, i4, j, i5, j2, str5, str6, str7);
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

    public boolean deleteChatSession(ChatSession chatSession) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatSession)) == null) {
            long paid = ChatMsgManagerImpl.getInstance(mContext).getPaid();
            return paid != -2 && ChatMessageDBManager.getInstance(mContext).delChatRecord(new ChatObject(mContext, chatSession.getCategory(), chatSession.getContacter(), paid, -1)) >= 0;
        }
        return invokeL.booleanValue;
    }

    public ArrayList<SessionClass> getAllClassType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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

    public ChatSession getChatRecord(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            LogUtils.enter();
            long paid = ChatMsgManagerImpl.getInstance(mContext).getPaid();
            if (paid == -2) {
                LogUtils.e(TAG, "getPaid() == Constants.CRM_ZHIDAID_NOT_SET");
                return null;
            }
            ChatSession chatRecord = ChatMessageDBManager.getInstance(mContext).getChatRecord(new ChatObject(mContext, i, j, paid, -1));
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

    public ArrayList<ChatSession> getChatRecords(long j, long j2, List<Integer> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), list})) == null) {
            long paid = ChatMsgManagerImpl.getInstance(mContext).getPaid();
            if (paid == -2) {
                LogUtils.d(TAG, "getChatRecords CRM_ZHIDAID_NOT_SET");
                return null;
            }
            ArrayList<ChatSession> chatRecords = ChatMessageDBManager.getInstance(mContext).getChatRecords(j, j2, paid, list);
            if (chatRecords != null && chatRecords.size() > 0) {
                LogUtils.d(TAG, "getChatRecords :" + chatRecords.size());
                Iterator<ChatSession> it = chatRecords.iterator();
                while (it.hasNext()) {
                    ChatSession next = it.next();
                    updateGroupChatSession(next);
                    String lastMsg = next.getLastMsg();
                    updateUnsupportDesc(next, lastMsg);
                    updatePADesc(next, lastMsg);
                }
            }
            return chatRecords;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<ChatSession> getChatRecordsByClass(long j, long j2, List<Integer> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), list})) == null) {
            if (AccountManager.isLogin(mContext)) {
                long paid = ChatMsgManagerImpl.getInstance(mContext).getPaid();
                if (paid == -2) {
                    return null;
                }
                return ChatMessageDBManager.getInstance(mContext).getChatRecordsByClass(j, j2, paid, list);
            }
            return null;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public List<ChatSession> getGroupSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? ChatMessageDBManager.getInstance(mContext).getGroupSession() : (List) invokeV.objValue;
    }

    public int hideAllChatSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long paid = ChatMsgManagerImpl.getInstance(mContext).getPaid();
            return paid == -2 ? DlnaManager.DLNA_ERROR_CREATE_SSDP_THREAD_FIAL : ChatMessageDBManager.getInstance(mContext).deleteChatSession(paid);
        }
        return invokeV.intValue;
    }

    public void mediaContactorSetting(long j, int i, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), iMediaContactorSettingListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", operation" + i + ", listener=" + iMediaContactorSettingListener);
            if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
                if (iMediaContactorSettingListener != null) {
                    iMediaContactorSettingListener.onMediaContactorSettingResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, -1);
                }
            } else if (AccountManager.getMediaRole(mContext)) {
                IMMediaContactorSettingRequest iMMediaContactorSettingRequest = new IMMediaContactorSettingRequest(mContext, j, i, ListenerManager.getInstance().addListener(iMediaContactorSettingListener));
                HttpHelper.executor(mContext, iMMediaContactorSettingRequest, iMMediaContactorSettingRequest);
            } else if (iMediaContactorSettingListener != null) {
                iMediaContactorSettingListener.onMediaContactorSettingResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR, -1);
            }
        }
    }

    public void mediaDeleteChatSession(long j, long j2, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), iMediaDeleteChatSessionListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", lastTime=" + j2 + ", listener=" + iMediaDeleteChatSessionListener);
            if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
                if (iMediaDeleteChatSessionListener != null) {
                    iMediaDeleteChatSessionListener.onMediaDeleteChatSessionResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                }
            } else if (AccountManager.getMediaRole(mContext)) {
                IMMediaDeleteSessionRequest iMMediaDeleteSessionRequest = new IMMediaDeleteSessionRequest(mContext, j, j2, ListenerManager.getInstance().addListener(iMediaDeleteChatSessionListener));
                HttpHelper.executor(mContext, iMMediaDeleteSessionRequest, iMMediaDeleteSessionRequest);
            } else if (iMediaDeleteChatSessionListener != null) {
                iMediaDeleteChatSessionListener.onMediaDeleteChatSessionResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR);
            }
        }
    }

    public void mediaGetChatSessions(long j, int i, long j2, String str, long j3, int i2, int i3, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), iMediaGetChatSessionListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", startSessionTime=" + j3 + ", count=" + i2 + ", needTop=" + i3 + ", listener=" + iMediaGetChatSessionListener);
            if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
                if (iMediaGetChatSessionListener != null) {
                    iMediaGetChatSessionListener.onMediaGetChatSessionResult(1000, 0, 0, false, null);
                }
            } else if (AccountManager.getMediaRole(mContext)) {
                IMMediaGetChatSessionRequest iMMediaGetChatSessionRequest = new IMMediaGetChatSessionRequest(mContext, j, i, j2, str, i2, j3, i3, ListenerManager.getInstance().addListener(iMediaGetChatSessionListener));
                HttpHelper.executor(mContext, iMMediaGetChatSessionRequest, iMMediaGetChatSessionRequest);
            } else if (iMediaGetChatSessionListener != null) {
                iMediaGetChatSessionListener.onMediaGetChatSessionResult(2000, 0, 0, false, null);
            }
        }
    }

    public void mediaGetContactorPauid(long j, int i, long j2, String str, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, iMediaGetContactorPauidListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", listener=" + iMediaGetContactorPauidListener);
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                IMMediaGetContactorPauidRequest iMMediaGetContactorPauidRequest = new IMMediaGetContactorPauidRequest(mContext, j, i, j2, str, ListenerManager.getInstance().addListener(iMediaGetContactorPauidListener));
                HttpHelper.executor(mContext, iMMediaGetContactorPauidRequest, iMMediaGetContactorPauidRequest);
            } else if (iMediaGetContactorPauidListener != null) {
                iMediaGetContactorPauidListener.onMediaGetContactorPauidResult(1000, -1L, -1, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            }
        }
    }

    public void mediaGetContactorSetting(long j, int i, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), iMediaContactorSettingListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", setting=" + i + ", listener=" + iMediaContactorSettingListener);
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                IMMediaGetContactorSettingRequest iMMediaGetContactorSettingRequest = new IMMediaGetContactorSettingRequest(mContext, j, i, ListenerManager.getInstance().addListener(iMediaContactorSettingListener));
                HttpHelper.executor(mContext, iMMediaGetContactorSettingRequest, iMMediaGetContactorSettingRequest);
            } else if (iMediaContactorSettingListener != null) {
                iMediaContactorSettingListener.onMediaContactorSettingResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, -1);
            }
        }
    }

    public void mediaSetSessionRead(long j, int i, long j2, String str, long j3, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), iMediaSetSessionReadListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", lastTime=" + j3 + ", listener=" + iMediaSetSessionReadListener);
            if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
                if (iMediaSetSessionReadListener != null) {
                    iMediaSetSessionReadListener.onMediaSetSessionReadResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                }
            } else if (AccountManager.getMediaRole(mContext)) {
                IMMediaSetSessionReadRequest iMMediaSetSessionReadRequest = new IMMediaSetSessionReadRequest(mContext, j, i, j2, str, j3, ListenerManager.getInstance().addListener(iMediaSetSessionReadListener));
                HttpHelper.executor(mContext, iMMediaSetSessionReadRequest, iMMediaSetSessionReadRequest);
            } else if (iMediaSetSessionReadListener != null) {
                iMediaSetSessionReadListener.onMediaSetSessionReadResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR);
            }
        }
    }

    public void onMediaGetChatSessionRequest(int i, boolean z, int i2, int i3, Map<Long, ChatSession> map, Map<Long, ChatSession> map2, Map<String, ChatSession> map3, String str) {
        IMediaGetChatSessionListener iMediaGetChatSessionListener;
        ArrayList arrayList;
        ArrayList arrayList2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), map, map2, map3, str}) == null) || (iMediaGetChatSessionListener = (IMediaGetChatSessionListener) ListenerManager.getInstance().removeListener(str)) == null) {
            return;
        }
        if (i == 0) {
            IMMediaBuildSessionListener iMMediaBuildSessionListener = new IMMediaBuildSessionListener(mContext, i2, i3, z, iMediaGetChatSessionListener);
            ArrayList arrayList3 = null;
            if (map2 == null || map2.size() <= 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(map2.keySet());
                ChatUserManagerImpl.getInstance(mContext).updateUserIdentity(arrayList, iMMediaBuildSessionListener.getUserIdentityListener(map2));
            }
            if (map == null || map.size() <= 0) {
                arrayList2 = null;
            } else {
                arrayList2 = new ArrayList(map.keySet());
                PaManager.getPaInfos(mContext, arrayList2, iMMediaBuildSessionListener.getPaInfosListener(map));
            }
            if (map3 != null && map3.size() > 0) {
                arrayList3 = new ArrayList(map3.keySet());
                BIMGroupManager.getFansGroupInfo(mContext, arrayList3, false, iMMediaBuildSessionListener.getGroupInfoListener(map3));
            }
            if (arrayList == null && arrayList2 == null && arrayList3 == null) {
                iMediaGetChatSessionListener.onMediaGetChatSessionResult(i, i2, i3, z, null);
                return;
            }
            return;
        }
        iMediaGetChatSessionListener.onMediaGetChatSessionResult(i, i2, i3, z, null);
    }

    public void onSyncComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            Iterator<IChatSessionChangeListener> it = this.mChatRecordChangeListener.iterator();
            while (it.hasNext()) {
                IChatSessionChangeListener next = it.next();
                if (next == null) {
                    it.remove();
                } else {
                    next.onChatSessionUpdate(null, false);
                }
            }
        }
    }

    public void onSyncDialogResult(int i, String str, String str2, long j, List<DialogRecord> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i), str, str2, Long.valueOf(j), list}) == null) {
            IMListener removeListener = ListenerManager.getInstance().removeListener(str2);
            if (removeListener instanceof ISyncDialogListener) {
                ((ISyncDialogListener) removeListener).onSyncDialogResult(i, str, j, list);
            }
        }
    }

    public void registerDialogSyncListener(Context context, IDialogSyncListener iDialogSyncListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048601, this, context, iDialogSyncListener) == null) || iDialogSyncListener == null || this.mDialogSyncListeners.contains(iDialogSyncListener)) {
            return;
        }
        this.mDialogSyncListeners.add(iDialogSyncListener);
    }

    public void registerRecordChangeListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048602, this, context, iChatSessionChangeListener) == null) || iChatSessionChangeListener == null || this.mChatRecordChangeListener.contains(iChatSessionChangeListener)) {
            return;
        }
        this.mChatRecordChangeListener.add(iChatSessionChangeListener);
    }

    public void syncDialog() {
        ISyncDialogListener iSyncDialogListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (iSyncDialogListener = this.syncDialogListener) == null) {
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
                l60.g(mContext).f(mContext, creatMethodIntent);
            } catch (Exception e) {
                onSyncDialogResult(1003, Constants.ERROR_MSG_SERVICE_ERROR, addListener, maxMsgid, null);
                LogUtils.e(TAG, "Exception ", e);
            }
        }
    }

    public void triggerChatSessionChangerCallBack(int i, ChatSession chatSession) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048604, this, i, chatSession) == null) || chatSession == null) {
            return;
        }
        if (IMConfigInternal.getInstance().getIMConfig(mContext).isNeedPaid()) {
            if (Utility.getPaid(mContext) == -1 || chatSession == null) {
                return;
            }
            if (Utility.getPaid(mContext) == chatSession.getPaid() || Utility.getNotifyPaid(mContext) == chatSession.getPaid()) {
                notifySessionChange(i, chatSession);
                return;
            }
            return;
        }
        notifySessionChange(i, chatSession);
    }

    public void unregisterDialogSyncListener(Context context, IDialogSyncListener iDialogSyncListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, context, iDialogSyncListener) == null) && iDialogSyncListener != null && this.mDialogSyncListeners.contains(iDialogSyncListener)) {
            this.mDialogSyncListeners.remove(iDialogSyncListener);
        }
    }

    public void unregisterMessageReceiveListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048606, this, context, iChatSessionChangeListener) == null) && iChatSessionChangeListener != null && this.mChatRecordChangeListener.contains(iChatSessionChangeListener)) {
            this.mChatRecordChangeListener.remove(iChatSessionChangeListener);
        }
    }

    public void mediaGetContactorPauid(long j, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048593, this, j, iMediaGetContactorPauidListener) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", listener=" + iMediaGetContactorPauidListener);
            if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
                if (iMediaGetContactorPauidListener != null) {
                    iMediaGetContactorPauidListener.onMediaGetContactorPauidResult(1000, -1L, -1, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                    return;
                }
                return;
            }
            IMMediaGetContactorPauidRequest iMMediaGetContactorPauidRequest = new IMMediaGetContactorPauidRequest(mContext, j, ListenerManager.getInstance().addListener(iMediaGetContactorPauidListener));
            HttpHelper.executor(mContext, iMMediaGetContactorPauidRequest, iMMediaGetContactorPauidRequest);
        }
    }

    public void mediaGetContactorSetting(long j, int i, long j2, String str, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Integer.valueOf(i2), iMediaContactorSettingListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", setting=" + i2 + ", listener=" + iMediaContactorSettingListener);
            if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
                if (iMediaContactorSettingListener != null) {
                    iMediaContactorSettingListener.onMediaContactorSettingResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, -1);
                }
            } else if (AccountManager.getMediaRole(mContext)) {
                IMMediaGetContactorSettingRequest iMMediaGetContactorSettingRequest = new IMMediaGetContactorSettingRequest(mContext, j, i, j2, str, i2, ListenerManager.getInstance().addListener(iMediaContactorSettingListener));
                HttpHelper.executor(mContext, iMMediaGetContactorSettingRequest, iMMediaGetContactorSettingRequest);
            } else if (iMediaContactorSettingListener != null) {
                iMediaContactorSettingListener.onMediaContactorSettingResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR, -1);
            }
        }
    }

    public void mediaContactorSetting(long j, int i, long j2, String str, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Integer.valueOf(i2), iMediaContactorSettingListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", operation" + i2 + ", listener=" + iMediaContactorSettingListener);
            if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
                if (iMediaContactorSettingListener != null) {
                    iMediaContactorSettingListener.onMediaContactorSettingResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, -1);
                }
            } else if (AccountManager.getMediaRole(mContext)) {
                IMMediaContactorSettingRequest iMMediaContactorSettingRequest = new IMMediaContactorSettingRequest(mContext, j, i, j2, str, i2, ListenerManager.getInstance().addListener(iMediaContactorSettingListener));
                HttpHelper.executor(mContext, iMMediaContactorSettingRequest, iMMediaContactorSettingRequest);
            } else if (iMediaContactorSettingListener != null) {
                iMediaContactorSettingListener.onMediaContactorSettingResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR, -1);
            }
        }
    }

    public void mediaDeleteChatSession(long j, int i, long j2, String str, long j3, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), iMediaDeleteChatSessionListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", contactorType" + i + ", contactorPauid" + j2 + ", contactorThirdid" + str + ", lastTime=" + j3 + ", listener=" + iMediaDeleteChatSessionListener);
            if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
                if (iMediaDeleteChatSessionListener != null) {
                    iMediaDeleteChatSessionListener.onMediaDeleteChatSessionResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                }
            } else if (AccountManager.getMediaRole(mContext)) {
                IMMediaDeleteSessionRequest iMMediaDeleteSessionRequest = new IMMediaDeleteSessionRequest(mContext, j, i, j2, str, j3, ListenerManager.getInstance().addListener(iMediaDeleteChatSessionListener));
                HttpHelper.executor(mContext, iMMediaDeleteSessionRequest, iMMediaDeleteSessionRequest);
            } else if (iMediaDeleteChatSessionListener != null) {
                iMediaDeleteChatSessionListener.onMediaDeleteChatSessionResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR);
            }
        }
    }

    public void mediaGetChatSessions(long j, long j2, int i, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), iMediaGetChatSessionListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", startSessionTime=" + j2 + ", count=" + i + ", listener=" + iMediaGetChatSessionListener);
            if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
                if (iMediaGetChatSessionListener != null) {
                    iMediaGetChatSessionListener.onMediaGetChatSessionResult(1000, 0, 0, false, null);
                }
            } else if (AccountManager.getMediaRole(mContext)) {
                IMMediaGetChatSessionRequest iMMediaGetChatSessionRequest = new IMMediaGetChatSessionRequest(mContext, j, i, j2, ListenerManager.getInstance().addListener(iMediaGetChatSessionListener));
                HttpHelper.executor(mContext, iMMediaGetChatSessionRequest, iMMediaGetChatSessionRequest);
            } else if (iMediaGetChatSessionListener != null) {
                iMediaGetChatSessionListener.onMediaGetChatSessionResult(2000, 0, 0, false, null);
            }
        }
    }

    public void mediaSetSessionRead(long j, long j2, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), iMediaSetSessionReadListener}) == null) {
            LogUtils.d(TAG, "BC> contactor=" + j + ", lastTime" + j2 + ", listener=" + iMediaSetSessionReadListener);
            if (!AccountManager.isLogin(mContext) || AccountManager.isCuidLogin(mContext)) {
                if (iMediaSetSessionReadListener != null) {
                    iMediaSetSessionReadListener.onMediaSetSessionReadResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                }
            } else if (AccountManager.getMediaRole(mContext)) {
                IMMediaSetSessionReadRequest iMMediaSetSessionReadRequest = new IMMediaSetSessionReadRequest(mContext, j, j2, ListenerManager.getInstance().addListener(iMediaSetSessionReadListener));
                HttpHelper.executor(mContext, iMMediaSetSessionReadRequest, iMMediaSetSessionReadRequest);
            } else if (iMediaSetSessionReadListener != null) {
                iMediaSetSessionReadListener.onMediaSetSessionReadResult(2000, Constants.ERROR_MSG_NOT_MEDIA_ROLE_ERROR);
            }
        }
    }

    public ChatSession getChatRecord(int i, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            LogUtils.enter();
            if (ChatMsgManagerImpl.getInstance(mContext).getPaid() == -2) {
                LogUtils.e(TAG, "getPaid() == Constants.CRM_ZHIDAID_NOT_SET");
                return null;
            }
            ChatSession chatRecord = ChatMessageDBManager.getInstance(mContext).getChatRecord(i, j, j2);
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

    public ArrayList<ChatSession> getChatRecords(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            LogUtils.enter();
            if (AccountManager.isLogin(mContext)) {
                long paid = ChatMsgManagerImpl.getInstance(mContext).getPaid();
                LogUtils.e(TAG, "AccountManager.isLogin(mContext)");
                if (paid == -2) {
                    LogUtils.e(TAG, "getPaid() == Constants.CRM_ZHIDAID_NOT_SET");
                    return null;
                }
                return ChatMessageDBManager.getInstance(mContext).getChatRecords(j, j2, paid);
            }
            return null;
        }
        return (ArrayList) invokeCommon.objValue;
    }
}
