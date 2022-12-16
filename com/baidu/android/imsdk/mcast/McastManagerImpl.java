package com.baidu.android.imsdk.mcast;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomExitListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomFetchListener;
import com.baidu.android.imsdk.chatmessage.request.IMChatRoomEnterRequest;
import com.baidu.android.imsdk.chatmessage.request.IMChatRoomExitRequest;
import com.baidu.android.imsdk.chatmessage.request.IMChatRoomFetchRequest;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
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

    public void sendQuizOpts(long j, long j2, int i, String str, IMcastSetListener iMcastSetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), str, iMcastSetListener}) == null) {
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
                    if (i3 == 0 && this.this$0.conversationHashMap.size() > 0) {
                        for (BIMConversation bIMConversation : this.this$0.conversationHashMap.values()) {
                            bIMConversation.beginWithCompletion(null);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
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
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            return ConversationStudioManImpl.getInstance(this.mContext).getMaxReliableMsgId(j);
        }
        return invokeJ.longValue;
    }

    public long getReliableMsgCount(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            return ConversationStudioManImpl.getInstance(this.mContext).getReliableMsgCount(j);
        }
        return invokeJ.longValue;
    }

    public void enterChatRoom(Context context, long j, IChatRoomEnterListener iChatRoomEnterListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, Long.valueOf(j), iChatRoomEnterListener}) == null) {
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

    public void exitChatRoom(Context context, long j, IChatRoomExitListener iChatRoomExitListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j), iChatRoomExitListener}) == null) {
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

    public String getAllCastIdList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ConversationStudioManImpl.getInstance(this.mContext).getAllCastIdList();
        }
        return (String) invokeV.objValue;
    }

    public long getJoinedCastId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ConversationStudioManImpl.getInstance(this.mContext).getJoinedCastId();
        }
        return invokeV.longValue;
    }

    public void getChatRoomLastMsg(Context context, List<Long> list, long j, IChatRoomFetchListener iChatRoomFetchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, list, Long.valueOf(j), iChatRoomFetchListener}) == null) {
            IMChatRoomFetchRequest iMChatRoomFetchRequest = new IMChatRoomFetchRequest(context, list, j, iChatRoomFetchListener);
            HttpHelper.executor(context, iMChatRoomFetchRequest, iMChatRoomFetchRequest);
        }
    }
}
