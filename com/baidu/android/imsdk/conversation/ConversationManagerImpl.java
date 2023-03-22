package com.baidu.android.imsdk.conversation;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.BIMConversationMsg;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.IGetUserListener;
import com.baidu.android.imsdk.chatuser.db.IMUserManager;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.media.listener.IChatSessionUpdateListener;
import com.baidu.android.imsdk.media.update.ChatSessionUpdateManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ConversationManagerImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ConversationManagerImpl";
    public static Context mContext;
    public static volatile ConversationManagerImpl sInstance;
    public static Object syncObject;
    public transient /* synthetic */ FieldHolder $fh;
    public IChatSessionUpdateListener listener;
    public ArrayList<IConversationChangeListener> mAllConversationChangeListener;
    public ArrayList<BIMConversation> mAllConversations;
    public HashMap<BIMManager.CATEGORY, ArrayList<BIMConversation>> mConversationsListMaps;
    public HashMap<String, BIMConversation> mConversationsMaps;
    public String mUid;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(932028054, "Lcom/baidu/android/imsdk/conversation/ConversationManagerImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(932028054, "Lcom/baidu/android/imsdk/conversation/ConversationManagerImpl;");
                return;
            }
        }
        syncObject = new Object();
    }

    public void notifyConversationChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Iterator<IConversationChangeListener> it = this.mAllConversationChangeListener.iterator();
            while (it.hasNext()) {
                it.next().onConversationChange();
            }
        }
    }

    public ConversationManagerImpl(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUid = null;
        this.mAllConversationChangeListener = null;
        this.mConversationsListMaps = new HashMap<>();
        this.mConversationsMaps = new HashMap<>();
        this.listener = new IChatSessionUpdateListener(this) { // from class: com.baidu.android.imsdk.conversation.ConversationManagerImpl.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ConversationManagerImpl this$0;

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

            @Override // com.baidu.android.imsdk.media.listener.IChatSessionUpdateListener
            public void onChatSessionUpdate(int i3, List<ChatSession> list) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, list) == null) && list != null && list.size() != 0) {
                    for (ChatSession chatSession : list) {
                        if (i3 != 2) {
                            if (chatSession != null) {
                                synchronized (ConversationManagerImpl.syncObject) {
                                    String str = chatSession.getCategory() + "_" + chatSession.getContacter();
                                    if (this.this$0.mConversationsMaps.containsKey(str)) {
                                        ((BIMConversation) this.this$0.mConversationsMaps.get(str)).updateConversation(chatSession);
                                    } else {
                                        this.this$0.putConversationInternal(new BIMConversationMsg(ConversationManagerImpl.mContext, ConversationManagerImpl.getCategoryByProtocolCategory(chatSession.getCategory(), chatSession.getChatType()), String.valueOf(chatSession.getContacterId()), chatSession));
                                    }
                                }
                                this.this$0.notifyConversationChange();
                            } else {
                                LogUtils.e(ConversationManagerImpl.TAG, "session is null ");
                            }
                        } else {
                            this.this$0.deleteConversationInternal(chatSession.getCategory(), chatSession.getContacter());
                            this.this$0.notifyConversationChange();
                        }
                    }
                }
            }
        };
        mContext = context.getApplicationContext();
        this.mAllConversationChangeListener = new ArrayList<>();
        ArrayList<BIMConversation> arrayList = new ArrayList<>();
        this.mAllConversations = arrayList;
        this.mConversationsListMaps.put(BIMManager.CATEGORY.ALL, arrayList);
    }

    public ArrayList<BIMConversation> getAllConversation(BIMManager.CATEGORY category) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, category)) == null) {
            synchronized (syncObject) {
                if (BIMManager.CATEGORY.ALL == category) {
                    return this.mAllConversations;
                }
                return this.mConversationsListMaps.get(category);
            }
        }
        return (ArrayList) invokeL.objValue;
    }

    public void registerConversationListener(IConversationChangeListener iConversationChangeListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, iConversationChangeListener) == null) && iConversationChangeListener != null && !this.mAllConversationChangeListener.contains(iConversationChangeListener)) {
            this.mAllConversationChangeListener.add(iConversationChangeListener);
        }
    }

    public void unregisterConversationListener(IConversationChangeListener iConversationChangeListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iConversationChangeListener) == null) && iConversationChangeListener != null && this.mAllConversationChangeListener.contains(iConversationChangeListener)) {
            this.mAllConversationChangeListener.remove(iConversationChangeListener);
        }
    }

    public static BIMManager.CATEGORY getCategoryByProtocolCategory(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65542, null, i, i2)) == null) {
            if (1 == i) {
                return BIMManager.CATEGORY.GROUP;
            }
            if (i == 0) {
                if (1 == i2) {
                    return BIMManager.CATEGORY.PA;
                }
                if (i2 == 0) {
                    return BIMManager.CATEGORY.SINGLEPERSON;
                }
            } else if (2 == i) {
                return BIMManager.CATEGORY.SYSTEM;
            }
            return BIMManager.CATEGORY.UNKOWN;
        }
        return (BIMManager.CATEGORY) invokeII.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteConversationInternal(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            String str = i + "_" + j;
            BIMConversation bIMConversation = this.mConversationsMaps.get(str);
            if (bIMConversation != null) {
                this.mConversationsMaps.remove(str);
                this.mAllConversations.remove(bIMConversation);
                this.mConversationsListMaps.get(bIMConversation.getCategory()).remove(bIMConversation);
            }
        }
    }

    public static ConversationManagerImpl getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (sInstance == null) {
                synchronized (ConversationManagerImpl.class) {
                    if (sInstance == null) {
                        if (context != null) {
                            sInstance = new ConversationManagerImpl(context);
                        } else {
                            LogUtils.e(TAG, "Context should be not null!");
                        }
                    }
                }
            }
            return sInstance;
        }
        return (ConversationManagerImpl) invokeL.objValue;
    }

    private void initConversation(ArrayList<ChatSession> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, this, arrayList) == null) && arrayList != null) {
            Iterator<ChatSession> it = arrayList.iterator();
            while (it.hasNext()) {
                ChatSession next = it.next();
                putConversationInternal(new BIMConversationMsg(mContext, getCategoryByProtocolCategory(next.getCategory(), next.getChatType()), String.valueOf(next.getContacterId()), next));
            }
        }
    }

    public boolean deleteConversation(BIMConversation bIMConversation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bIMConversation)) == null) {
            if (bIMConversation == null) {
                return false;
            }
            ChatMsgManagerImpl.getInstance(mContext).deleteAllMsgs(bIMConversation.getCategory().getValue(), bIMConversation.getChatSession().getContacter(), false, 1);
            return ChatSessionManagerImpl.getInstance(mContext).deleteChatSession(bIMConversation.getChatSession());
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putConversationInternal(BIMConversation bIMConversation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, bIMConversation) == null) {
            String str = bIMConversation.getCategory().getValue() + "_" + bIMConversation.getId();
            try {
                if (this.mConversationsMaps.containsKey(str)) {
                    BIMConversation bIMConversation2 = this.mConversationsMaps.get(str);
                    if (bIMConversation != bIMConversation2) {
                        this.mConversationsMaps.remove(str);
                        this.mConversationsMaps.put(str, bIMConversation);
                        this.mAllConversations.remove(bIMConversation2);
                        this.mAllConversations.add(bIMConversation);
                        this.mConversationsListMaps.get(bIMConversation.getCategory()).remove(bIMConversation2);
                        this.mConversationsListMaps.get(bIMConversation.getCategory()).add(bIMConversation);
                        return;
                    }
                    return;
                }
                this.mConversationsMaps.put(str, bIMConversation);
                if (!this.mConversationsListMaps.containsKey(bIMConversation.getCategory())) {
                    this.mConversationsListMaps.put(bIMConversation.getCategory(), new ArrayList<>());
                }
                this.mAllConversations.add(bIMConversation);
                this.mConversationsListMaps.get(bIMConversation.getCategory()).add(bIMConversation);
            } catch (Exception e) {
                LogUtils.e(TAG, "putConversationInternal exception :", e);
            }
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (syncObject) {
                this.mUid = null;
                this.mAllConversations.clear();
                this.mConversationsMaps.clear();
                for (BIMManager.CATEGORY category : this.mConversationsListMaps.keySet()) {
                    this.mConversationsListMaps.get(category).clear();
                }
            }
        }
    }

    public boolean deleteConversation(int i, String str) {
        InterceptResult invokeIL;
        boolean deleteConversation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str)) == null) {
            synchronized (syncObject) {
                deleteConversation = deleteConversation(this.mConversationsMaps.get(i + "_" + str));
            }
            return deleteConversation;
        }
        return invokeIL.booleanValue;
    }

    public BIMConversation getConversation(BIMManager.CATEGORY category, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, category, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                LogUtils.e(TAG, "id should not be empty");
                return null;
            }
            synchronized (syncObject) {
                String str2 = category.getValue() + "_" + str;
                if (this.mConversationsMaps.containsKey(str2)) {
                    return this.mConversationsMaps.get(str2);
                }
                try {
                    long longValue = Long.valueOf(str).longValue();
                    int value = category.getValue();
                    if (BIMManager.CATEGORY.SINGLEPERSON == category) {
                        long uKbyBuid = IMUserManager.getInstance(mContext).getUKbyBuid(longValue);
                        if (uKbyBuid >= 0) {
                            ChatSession chatRecord = ChatSessionManagerImpl.getInstance(mContext).getChatRecord(value, uKbyBuid);
                            if (chatRecord == null) {
                                chatRecord = new ChatSession(value, uKbyBuid, longValue, null);
                            }
                            BIMConversationMsg bIMConversationMsg = new BIMConversationMsg(mContext, BIMManager.CATEGORY.SINGLEPERSON, str, chatRecord);
                            putConversationInternal(bIMConversationMsg);
                            return bIMConversationMsg;
                        }
                        ChatSession chatSession = new ChatSession(value, uKbyBuid, longValue, null);
                        ChatUserManagerImpl.getInstance(mContext).getUserByBuid(longValue, 0, new IGetUserListener(this, category, str) { // from class: com.baidu.android.imsdk.conversation.ConversationManagerImpl.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ConversationManagerImpl this$0;
                            public final /* synthetic */ BIMManager.CATEGORY val$categoryenum;
                            public final /* synthetic */ String val$id;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, category, str};
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
                                this.val$categoryenum = category;
                                this.val$id = str;
                            }

                            @Override // com.baidu.android.imsdk.chatuser.IGetUserListener
                            public void onGetUserResult(int i, long j, ChatUser chatUser) {
                                BIMConversation conversation;
                                ChatSession chatSession2;
                                Interceptable interceptable2 = $ic;
                                if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), chatUser}) == null) && i == 0 && chatUser != null && (conversation = this.this$0.getConversation(this.val$categoryenum, this.val$id)) != null && (chatSession2 = conversation.getChatSession()) != null) {
                                    chatSession2.setName(chatUser.getUserName());
                                    chatSession2.setContacter(chatUser.getUk());
                                    chatSession2.setIconUrl(chatUser.getIconUrl());
                                    this.this$0.updateConversationName(chatUser.getUserName(), 0, this.val$id);
                                }
                            }
                        });
                        BIMConversationMsg bIMConversationMsg2 = new BIMConversationMsg(mContext, category, str, chatSession);
                        putConversationInternal(bIMConversationMsg2);
                        return bIMConversationMsg2;
                    } else if (BIMManager.CATEGORY.GROUP == category) {
                        ChatSession chatRecord2 = ChatSessionManagerImpl.getInstance(mContext).getChatRecord(value, longValue);
                        if (chatRecord2 == null) {
                            chatRecord2 = new ChatSession(value, longValue, longValue, null);
                            if (value == 1) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(String.valueOf(longValue));
                                ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList);
                                if (groupInfo != null && groupInfo.size() > 0 && groupInfo.get(0).getType() == 2) {
                                    chatRecord2.setChatType(4);
                                }
                            }
                        }
                        BIMConversationMsg bIMConversationMsg3 = new BIMConversationMsg(mContext, category, str, chatRecord2);
                        putConversationInternal(bIMConversationMsg3);
                        return bIMConversationMsg3;
                    } else if (BIMManager.CATEGORY.PA == category) {
                        ChatSession chatRecord3 = ChatSessionManagerImpl.getInstance(mContext).getChatRecord(0, longValue);
                        if (chatRecord3 == null) {
                            chatRecord3 = new ChatSession(value, longValue, longValue, null);
                        }
                        BIMConversationMsg bIMConversationMsg4 = new BIMConversationMsg(mContext, category, str, chatRecord3);
                        putConversationInternal(bIMConversationMsg4);
                        return bIMConversationMsg4;
                    } else if (BIMManager.CATEGORY.STUDIO != category) {
                        return null;
                    } else {
                        BIMConversationMsg bIMConversationMsg5 = new BIMConversationMsg(mContext, category, str, new ChatSession(value, longValue, longValue, null));
                        putConversationInternal(bIMConversationMsg5);
                        return bIMConversationMsg5;
                    }
                } catch (ClassCastException e) {
                    LogUtils.e(TAG, "Id is not long value", e);
                    return null;
                }
            }
        }
        return (BIMConversation) invokeLL.objValue;
    }

    public void init(String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            LogUtils.d(TAG, "uid: " + str + " , mUid : " + this.mUid);
            String str2 = this.mUid;
            if (str2 != null && str2.equals(str)) {
                return;
            }
            ArrayList<ChatSession> chatRecords = ChatSessionManagerImpl.getInstance(mContext).getChatRecords(0L, 0L);
            ChatSessionUpdateManager.getInstance(mContext).registerRecordChangeListener(this.listener);
            clear();
            synchronized (syncObject) {
                this.mUid = str;
                initConversation(chatRecords);
                notifyConversationChange();
                StringBuilder sb = new StringBuilder();
                sb.append("---Conversation init done -- sessions.size : ");
                if (chatRecords != null) {
                    i = chatRecords.size();
                } else {
                    i = 0;
                }
                sb.append(i);
                LogUtils.d(TAG, sb.toString());
            }
        }
    }

    public void updateConversationName(String str, int i, String str2) {
        ChatSession chatSession;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, str, i, str2) == null) {
            BIMConversation bIMConversation = this.mConversationsMaps.get(i + "_" + str2);
            if (bIMConversation != null && (chatSession = bIMConversation.getChatSession()) != null) {
                chatSession.setName(str);
                ChatMsgManagerImpl.getInstance(mContext).updateChatSeesionName(bIMConversation.getChatSession());
                notifyConversationChange();
            }
        }
    }
}
