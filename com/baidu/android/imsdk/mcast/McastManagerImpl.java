package com.baidu.android.imsdk.mcast;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomExitListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomFetchListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomListener;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.request.IMChatRoomEnterRequest;
import com.baidu.android.imsdk.chatmessage.request.IMChatRoomExitRequest;
import com.baidu.android.imsdk.chatmessage.request.IMChatRoomFetchRequest;
import com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyDetailListener;
import com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyDetailRequest;
import com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyListListener;
import com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyListRequest;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.mcast.IMEmojiReplyListener;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tieba.v20;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class McastManagerImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "McastManagerImpl";
    public static volatile McastManagerImpl mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final IConnectListener connectListener;
    public final ConcurrentHashMap<Long, BIMConversation> conversationHashMap;
    public Context mContext;
    public final ConcurrentHashMap<Integer, JoinChatRoomGroup> roomGroupHashMap;

    public void sendQuizOpts(long j, long j2, int i, String str, IMcastSetListener iMcastSetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), str, iMcastSetListener}) == null) {
        }
    }

    /* loaded from: classes.dex */
    public static class JoinChatRoomGroup {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int batchType;
        public long chatRoomGroupId;
        public long roomType;

        public JoinChatRoomGroup() {
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
    }

    public McastManagerImpl(Context context) {
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
        this.conversationHashMap = new ConcurrentHashMap<>();
        this.roomGroupHashMap = new ConcurrentHashMap<>();
        this.connectListener = new IConnectListener(this) { // from class: com.baidu.android.imsdk.mcast.McastManagerImpl.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ McastManagerImpl this$0;

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

            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                    LogUtils.d("connectListener:", "长连接状态发生变化，当前状态是：" + i3 + ", 聊天室 size = " + this.this$0.conversationHashMap.size());
                    if (i3 == 0) {
                        if (this.this$0.conversationHashMap.size() > 0) {
                            for (BIMConversation bIMConversation : this.this$0.conversationHashMap.values()) {
                                bIMConversation.beginWithCompletion(null);
                            }
                        }
                        if (this.this$0.roomGroupHashMap.size() > 0) {
                            for (JoinChatRoomGroup joinChatRoomGroup : this.this$0.roomGroupHashMap.values()) {
                                ConversationStudioManImpl.getInstance(this.this$0.mContext).joinChatRoomGroup(joinChatRoomGroup.roomType, joinChatRoomGroup.batchType, joinChatRoomGroup.chatRoomGroupId, null);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = context.getApplicationContext();
    }

    public static McastManagerImpl getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (mInstance == null) {
                synchronized (McastManagerImpl.class) {
                    if (mInstance == null) {
                        mInstance = new McastManagerImpl(context);
                    }
                }
            }
            return mInstance;
        }
        return (McastManagerImpl) invokeL.objValue;
    }

    public long getMaxReliableMsgId(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
            return ConversationStudioManImpl.getInstance(this.mContext).getMaxReliableMsgId(j);
        }
        return invokeJ.longValue;
    }

    public long getReliableMsgCount(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            return ConversationStudioManImpl.getInstance(this.mContext).getReliableMsgCount(j);
        }
        return invokeJ.longValue;
    }

    public void emojiReplyForChatRoom(IMEmojiReplyListener.IMEmojiReplyRequestInfo iMEmojiReplyRequestInfo, IMEmojiReplyListener iMEmojiReplyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, iMEmojiReplyRequestInfo, iMEmojiReplyListener) == null) {
            if (LoginManager.getInstance(this.mContext).isIMLogined()) {
                String addListener = ListenerManager.getInstance().addListener(iMEmojiReplyListener);
                Intent createMcastMethodIntent = Utility.createMcastMethodIntent(this.mContext, 214);
                createMcastMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                createMcastMethodIntent.putExtra(Constants.EXTRA_SEND_MSG, iMEmojiReplyRequestInfo.msg);
                createMcastMethodIntent.putExtra("op_type", iMEmojiReplyRequestInfo.opType);
                createMcastMethodIntent.putExtra(Constants.EXTRA_EMOJI_PACKAGE_ID, iMEmojiReplyRequestInfo.emojiPackageId);
                createMcastMethodIntent.putExtra("emoji_content", iMEmojiReplyRequestInfo.emojiContent);
                try {
                    v20.e(this.mContext).d(this.mContext, createMcastMethodIntent);
                    return;
                } catch (Exception unused) {
                    if (iMEmojiReplyListener != null) {
                        iMEmojiReplyListener.onResult(1003, "");
                    }
                    ListenerManager.getInstance().removeListener(addListener);
                    return;
                }
            }
            LoginManager.getInstance(this.mContext).triggleLogoutListener(4001, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (iMEmojiReplyListener != null) {
                iMEmojiReplyListener.onResult(1001, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            }
        }
    }

    public void enterChatRoom(Context context, long j, IChatRoomEnterListener iChatRoomEnterListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j), iChatRoomEnterListener}) == null) {
            BIMManager.registerConnectListenerToList(this.connectListener);
            IMChatRoomEnterRequest iMChatRoomEnterRequest = new IMChatRoomEnterRequest(context, j, new IChatRoomEnterListener(this, context, j, iChatRoomEnterListener) { // from class: com.baidu.android.imsdk.mcast.McastManagerImpl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ McastManagerImpl this$0;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ IChatRoomEnterListener val$listener;
                public final /* synthetic */ long val$roomId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, Long.valueOf(j), iChatRoomEnterListener};
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
                    this.val$context = context;
                    this.val$roomId = j;
                    this.val$listener = iChatRoomEnterListener;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener
                public void onResult(int i, String str, IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, chatRoomInfo) == null) {
                        if (i == 0) {
                            Context context2 = this.val$context;
                            BIMConversation conversation = BIMManager.getConversation(context2, "" + this.val$roomId, false, BIMManager.CATEGORY.STUDIO, "", 2);
                            if (conversation != null) {
                                this.this$0.conversationHashMap.put(Long.valueOf(this.val$roomId), conversation);
                                conversation.beginWithCompletion(new IMcastSetListener(this, chatRoomInfo) { // from class: com.baidu.android.imsdk.mcast.McastManagerImpl.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 this$1;
                                    public final /* synthetic */ IChatRoomEnterListener.ChatRoomInfo val$chatRoomInfo;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, chatRoomInfo};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                        this.val$chatRoomInfo = chatRoomInfo;
                                    }

                                    @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                                    public void onResult(int i2, long j2, long j3) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                                            LogUtils.e(McastManagerImpl.TAG, "join onResult " + j2 + " responseCode = " + i2);
                                            IChatRoomEnterListener iChatRoomEnterListener2 = this.this$1.val$listener;
                                            if (iChatRoomEnterListener2 != null) {
                                                iChatRoomEnterListener2.onResult(i2, DnsModel.MSG_OK, this.val$chatRoomInfo);
                                            }
                                        }
                                    }
                                });
                                return;
                            }
                            IChatRoomEnterListener iChatRoomEnterListener2 = this.val$listener;
                            if (iChatRoomEnterListener2 != null) {
                                iChatRoomEnterListener2.onResult(1027, "conversation is null", chatRoomInfo);
                                return;
                            }
                            return;
                        }
                        IChatRoomEnterListener iChatRoomEnterListener3 = this.val$listener;
                        if (iChatRoomEnterListener3 != null) {
                            iChatRoomEnterListener3.onResult(i, str, chatRoomInfo);
                        }
                    }
                }
            });
            HttpHelper.executor(context, iMChatRoomEnterRequest, iMChatRoomEnterRequest);
        }
    }

    public void enterChatRoomGroup(long j, int i, long j2, IChatRoomListener iChatRoomListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), iChatRoomListener}) == null) {
            BIMManager.registerConnectListenerToList(this.connectListener);
            JoinChatRoomGroup joinChatRoomGroup = new JoinChatRoomGroup();
            joinChatRoomGroup.roomType = j;
            joinChatRoomGroup.batchType = i;
            joinChatRoomGroup.chatRoomGroupId = j2;
            this.roomGroupHashMap.put(Integer.valueOf((j + "" + i + "" + j2).hashCode()), joinChatRoomGroup);
            ConversationStudioManImpl.getInstance(this.mContext).joinChatRoomGroup(j, i, j2, iChatRoomListener);
        }
    }

    public void exitChatRoomGroup(long j, int i, long j2, IChatRoomListener iChatRoomListener) {
        JoinChatRoomGroup joinChatRoomGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), iChatRoomListener}) == null) {
            int hashCode = (j + "" + i + "" + j2).hashCode();
            if (this.roomGroupHashMap.containsKey(Integer.valueOf(hashCode))) {
                joinChatRoomGroup = this.roomGroupHashMap.remove(Integer.valueOf(hashCode));
            } else {
                joinChatRoomGroup = null;
            }
            if (joinChatRoomGroup == null) {
                return;
            }
            ConversationStudioManImpl.getInstance(this.mContext).exitChatRoomGroup(j, joinChatRoomGroup.batchType, joinChatRoomGroup.chatRoomGroupId, iChatRoomListener);
        }
    }

    public void exitChatRoom(Context context, long j, IChatRoomExitListener iChatRoomExitListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j), iChatRoomExitListener}) == null) {
            IMChatRoomExitRequest iMChatRoomExitRequest = new IMChatRoomExitRequest(context, j, new IChatRoomExitListener(this, j, iChatRoomExitListener) { // from class: com.baidu.android.imsdk.mcast.McastManagerImpl.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ McastManagerImpl this$0;
                public final /* synthetic */ IChatRoomExitListener val$listener;
                public final /* synthetic */ long val$roomId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j), iChatRoomExitListener};
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
                    this.val$roomId = j;
                    this.val$listener = iChatRoomExitListener;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IChatRoomExitListener
                public void onResult(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str) == null) {
                        if (i == 0) {
                            BIMConversation bIMConversation = (BIMConversation) this.this$0.conversationHashMap.get(Long.valueOf(this.val$roomId));
                            if (bIMConversation != null) {
                                bIMConversation.endWithCompletion(new IMcastSetListener(this) { // from class: com.baidu.android.imsdk.mcast.McastManagerImpl.2.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass2 this$1;

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
                                        this.this$1 = this;
                                    }

                                    @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                                    public void onResult(int i2, long j2, long j3) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                                            LogUtils.e(McastManagerImpl.TAG, "join onResult " + j2 + " responseCode = " + i2);
                                            IChatRoomExitListener iChatRoomExitListener2 = this.this$1.val$listener;
                                            if (iChatRoomExitListener2 != null) {
                                                iChatRoomExitListener2.onResult(i2, DnsModel.MSG_OK);
                                            }
                                            if (i2 == 0) {
                                                BIMManager.unregisterConnectListenerFromList(this.this$1.this$0.connectListener);
                                                this.this$1.this$0.conversationHashMap.remove(Long.valueOf(j3));
                                            }
                                        }
                                    }
                                });
                                return;
                            }
                            IChatRoomExitListener iChatRoomExitListener2 = this.val$listener;
                            if (iChatRoomExitListener2 != null) {
                                iChatRoomExitListener2.onResult(1027, "conversation is null");
                                return;
                            }
                            return;
                        }
                        IChatRoomExitListener iChatRoomExitListener3 = this.val$listener;
                        if (iChatRoomExitListener3 != null) {
                            iChatRoomExitListener3.onResult(i, str);
                        }
                    }
                }
            });
            HttpHelper.executor(context, iMChatRoomExitRequest, iMChatRoomExitRequest);
        }
    }

    public void fetchEmojiReplyDetail(@NonNull IMEmojiReplyDetailListener.IMEmojiReplyDetailRequestInfo iMEmojiReplyDetailRequestInfo, @NonNull IMEmojiReplyDetailListener iMEmojiReplyDetailListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, iMEmojiReplyDetailRequestInfo, iMEmojiReplyDetailListener) == null) {
            IMEmojiReplyDetailRequest iMEmojiReplyDetailRequest = new IMEmojiReplyDetailRequest(this.mContext, iMEmojiReplyDetailRequestInfo, iMEmojiReplyDetailListener);
            HttpHelper.executor(this.mContext, iMEmojiReplyDetailRequest, iMEmojiReplyDetailRequest);
        }
    }

    public void fetchEmojiReplyList(@NonNull IMEmojiReplyListListener.IMEmojiReplyListRequestInfo iMEmojiReplyListRequestInfo, @NonNull IMEmojiReplyListListener iMEmojiReplyListListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, iMEmojiReplyListRequestInfo, iMEmojiReplyListListener) == null) {
            IMEmojiReplyListRequest iMEmojiReplyListRequest = new IMEmojiReplyListRequest(this.mContext, iMEmojiReplyListRequestInfo.roomId, iMEmojiReplyListRequestInfo.emojiPackageId, iMEmojiReplyListRequestInfo.msgs, iMEmojiReplyListListener);
            HttpHelper.executor(this.mContext, iMEmojiReplyListRequest, iMEmojiReplyListRequest);
        }
    }

    public String getAllCastIdList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return ConversationStudioManImpl.getInstance(this.mContext).getAllCastIdList();
        }
        return (String) invokeV.objValue;
    }

    public long getJoinedCastId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return ConversationStudioManImpl.getInstance(this.mContext).getJoinedCastId();
        }
        return invokeV.longValue;
    }

    public void getChatRoomLastMsg(Context context, List<Long> list, long j, IChatRoomFetchListener iChatRoomFetchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, list, Long.valueOf(j), iChatRoomFetchListener}) == null) {
            IMChatRoomFetchRequest iMChatRoomFetchRequest = new IMChatRoomFetchRequest(context, list, j, iChatRoomFetchListener);
            HttpHelper.executor(context, iMChatRoomFetchRequest, iMChatRoomFetchRequest);
        }
    }

    public void getUsedEmoji(int i, int i2, boolean z, int i3, BIMValueCallBack<List<String>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), bIMValueCallBack}) == null) {
            TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable(this, i, i2, z, i3, bIMValueCallBack) { // from class: com.baidu.android.imsdk.mcast.McastManagerImpl.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ McastManagerImpl this$0;
                public final /* synthetic */ BIMValueCallBack val$callBack;
                public final /* synthetic */ int val$category;
                public final /* synthetic */ int val$count;
                public final /* synthetic */ int val$packageId;
                public final /* synthetic */ boolean val$sortWithTime;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), bIMValueCallBack};
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
                    this.val$packageId = i;
                    this.val$category = i2;
                    this.val$sortWithTime = z;
                    this.val$count = i3;
                    this.val$callBack = bIMValueCallBack;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ChatMessageDBManager.getInstance(this.this$0.mContext).getUsedEmojiContent(this.val$packageId, this.val$category, this.val$sortWithTime, this.val$count, this.val$callBack);
                    }
                }
            });
        }
    }
}
