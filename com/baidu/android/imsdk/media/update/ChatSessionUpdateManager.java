package com.baidu.android.imsdk.media.update;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.box.IMBoxManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener;
import com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.consult.listener.IBusiSessionChangeListener;
import com.baidu.android.imsdk.db.DBBase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.media.MediaSessionManager;
import com.baidu.android.imsdk.media.bean.SessionParam;
import com.baidu.android.imsdk.media.db.MediaMessageDBManager;
import com.baidu.android.imsdk.media.listener.IBaseSessionUpdateListener;
import com.baidu.android.imsdk.media.listener.IChatSessionUpdateListener;
import com.baidu.android.imsdk.media.listener.ISessionUpdateManager;
import com.baidu.android.imsdk.pubaccount.IGetPaInfoListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class ChatSessionUpdateManager implements DBBase.ChatSessionChangeOberser, IBusiSessionChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ChatSessionUpdateManager";
    public static volatile ChatSessionUpdateManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public CopyOnWriteArrayList<IBaseSessionUpdateListener> mSessionChangeListener;
    public ISessionUpdateManager mUpdateManager;

    public IBusiSessionChangeListener getBusiSessionChangeListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (IBusiSessionChangeListener) invokeV.objValue;
    }

    public DBBase.ChatSessionChangeOberser getSessionDbOberser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (DBBase.ChatSessionChangeOberser) invokeV.objValue;
    }

    public ChatSessionUpdateManager(Context context) {
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
        this.mSessionChangeListener = new CopyOnWriteArrayList<>();
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mUpdateManager = new DefaultUpdateManager(applicationContext);
    }

    private boolean containsAggSession(List<ChatSession> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, list)) == null) {
            if (list != null && list.size() != 0) {
                for (ChatSession chatSession : list) {
                    if (chatSession.getSessionFrom() == 2) {
                        LogUtils.d(TAG, "containsAggSession = true");
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static ChatSessionUpdateManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (mInstance == null) {
                synchronized (ChatSessionUpdateManager.class) {
                    if (mInstance == null) {
                        mInstance = new ChatSessionUpdateManager(context);
                    }
                }
            }
            return mInstance;
        }
        return (ChatSessionUpdateManager) invokeL.objValue;
    }

    public void registerRecordChangeListener(IBaseSessionUpdateListener iBaseSessionUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iBaseSessionUpdateListener) == null) {
            LogUtils.d(TAG, "registerRecordChangeListener");
            if (iBaseSessionUpdateListener != null && !this.mSessionChangeListener.contains(iBaseSessionUpdateListener)) {
                this.mSessionChangeListener.add(iBaseSessionUpdateListener);
            }
        }
    }

    public void setSessionUpdateManager(ISessionUpdateManager iSessionUpdateManager) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, iSessionUpdateManager) == null) && iSessionUpdateManager != null) {
            this.mUpdateManager = iSessionUpdateManager;
        }
    }

    public void unregisterRecordChangeListener(IBaseSessionUpdateListener iBaseSessionUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, iBaseSessionUpdateListener) == null) {
            LogUtils.d(TAG, "unregisterMessageReceiveListener");
            if (iBaseSessionUpdateListener == null) {
                return;
            }
            this.mSessionChangeListener.remove(iBaseSessionUpdateListener);
        }
    }

    private ChatSession buildMediaStrangerFolder(ChatSession chatSession, ChatSession chatSession2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, chatSession, chatSession2)) == null) {
            if (chatSession2 == null) {
                return null;
            }
            if (chatSession == null) {
                chatSession = new ChatSession(0, 0L, 0L, "");
            }
            chatSession.setIsStranger(1);
            chatSession.setClassType(12);
            chatSession.setSessionFrom(2);
            chatSession.setLastMsg(chatSession2.getLastMsg());
            chatSession.setLastMsgTime(chatSession2.getLastMsgTime());
            chatSession.setNewMsgSum(MediaSessionManager.getInstance(this.mContext).getStrangerUnread());
            chatSession.setChatType(0);
            chatSession.setLastMsgId(chatSession2.getLastMsgId());
            chatSession.setBusinessType(3);
            chatSession.setSortTime(chatSession2.getSortTime());
            chatSession.setIsClicked(chatSession2.getIsClicked());
            chatSession.setState(chatSession2.getState());
            return chatSession;
        }
        return (ChatSession) invokeLL.objValue;
    }

    private void doNotifyMediaStrangerFolder(int i, List<ChatSession> list) {
        ChatSession buildMediaStrangerFolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65543, this, i, list) == null) && list != null && list.size() != 0) {
            List<ChatSession> mediaSessionList = MediaMessageDBManager.getInstance(this.mContext).getMediaSessionList(0L, Long.MAX_VALUE, 1, 2, 0);
            if (mediaSessionList != null && mediaSessionList.size() != 0) {
                updateMediaStrangerCount(i, list);
                ChatSession mediaStrangerFolderSession = MediaMessageDBManager.getInstance(this.mContext).getMediaStrangerFolderSession();
                if (mediaStrangerFolderSession != null) {
                    buildMediaStrangerFolder = buildMediaStrangerFolder(mediaStrangerFolderSession, mediaSessionList.get(0));
                    if (i == 2) {
                        i = 1;
                    }
                } else {
                    buildMediaStrangerFolder = buildMediaStrangerFolder(null, mediaSessionList.get(0));
                    i = 0;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(buildMediaStrangerFolder);
                MediaMessageDBManager.getInstance(this.mContext).updateSessionListWithNotify(arrayList, 1, i);
                return;
            }
            MediaMessageDBManager.getInstance(this.mContext).delAllStrangerSession();
        }
    }

    private void updateMediaChatSession(int i, List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65554, this, i, list) == null) && list != null && list.size() != 0) {
            for (ChatSession chatSession : list) {
                long maxMsgid = ChatMessageDBManager.getInstance(this.mContext).getMaxMsgid(new ChatObject(this.mContext, chatSession.getCategory(), chatSession.getContacter()));
                if (chatSession.getLastMsgId() <= 0) {
                    chatSession.setLastMsgId(maxMsgid);
                }
                if (chatSession.getSortTime() <= 0) {
                    chatSession.setSortTime(maxMsgid);
                }
                if (chatSession.getChatType() == 57) {
                    chatSession.setBusinessType(2);
                }
            }
            MediaMessageDBManager.getInstance(this.mContext).updateSessionListWithNotify(list, 1, i);
        }
    }

    private void completeSessionBusinessType(List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, list) == null) && list != null && list.size() != 0) {
            for (ChatSession chatSession : list) {
                if (chatSession.getBusinessType() <= 0) {
                    if (chatSession.getCategory() == 0) {
                        if (chatSession.getChatType() == 0) {
                            chatSession.setBusinessType(1);
                        } else {
                            PaInfo queryPaInfo = PaInfoDBManager.getInstance(this.mContext).queryPaInfo(chatSession.getPaid());
                            if (queryPaInfo != null) {
                                int businessType = queryPaInfo.getBusinessType();
                                if (businessType <= 0) {
                                    businessType = Utility.getBusinessType(queryPaInfo.getSubtype(), queryPaInfo.getSubsetType());
                                }
                                chatSession.setBusinessType(businessType);
                            }
                        }
                    } else if (chatSession.getCategory() == 1) {
                        chatSession.setBusinessType(2);
                    } else if (chatSession.getCategory() == 9) {
                        chatSession.setBusinessType(27);
                    }
                }
            }
        }
    }

    private boolean insertFansGroupDraftSession(List<ChatSession> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, list)) == null) {
            if (list == null || list.size() == 0) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (ChatSession chatSession : list) {
                if (chatSession.getState() == 3) {
                    long maxMsgid = ChatMessageDBManager.getInstance(this.mContext).getMaxMsgid();
                    if (chatSession.getLastMsgId() <= 0) {
                        chatSession.setLastMsgId(maxMsgid);
                    }
                    if (chatSession.getSortTime() <= 0) {
                        chatSession.setSortTime(maxMsgid);
                    }
                    if (chatSession.getChatType() == 57) {
                        chatSession.setBusinessType(2);
                    }
                    arrayList.add(chatSession);
                }
            }
            MediaMessageDBManager.getInstance(this.mContext).updateSessionListWithNotify(arrayList, 1, 4);
            if (arrayList.size() != list.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private void doMediaSessionChange(int i, int i2, List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65542, this, i, i2, list) == null) {
            LogUtils.d(TAG, "doMediaSessionChange onChatSessionUpdate type = " + i2);
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (ChatSession chatSession : list) {
                    if (SessionParam.MEDIA_LCOAL_CHAT_TYPES.contains(Integer.valueOf(chatSession.getChatType())) || Utility.isValidAggSession(chatSession.getClassType(), chatSession.getClassShow())) {
                        arrayList.add(chatSession);
                    }
                }
            }
            if (arrayList.size() <= 0) {
                return;
            }
            ChatSession chatSession2 = arrayList.get(0);
            switch (i2) {
                case 0:
                    if (!updateMeidaSessionNewSum(arrayList) && !insertFansGroupDraftSession(arrayList)) {
                        MediaSessionManager.getInstance(this.mContext).getChatSessionFromServer(SessionParam.getNotifyRequestParam(this.mContext), null);
                        return;
                    }
                    return;
                case 1:
                case 3:
                case 4:
                case 9:
                    if (Utility.isValidAggSession(chatSession2.getClassType(), chatSession2.getClassShow())) {
                        updateSessionByClassAndNotify(chatSession2.getClassType(), 1);
                        return;
                    } else {
                        updateMediaChatSession(i2, arrayList);
                        return;
                    }
                case 2:
                    if (Utility.isValidAggSession(chatSession2.getClassType(), chatSession2.getClassShow())) {
                        updateSessionByClassAndNotify(chatSession2.getClassType(), 1);
                        return;
                    }
                    for (ChatSession chatSession3 : arrayList) {
                        MediaMessageDBManager.getInstance(this.mContext).delChatRecord(chatSession3.getCategory(), chatSession3.getContacter());
                    }
                    return;
                case 5:
                    for (ChatSession chatSession4 : arrayList) {
                        MediaMessageDBManager.getInstance(this.mContext).updateChatSessionMarkTop(chatSession4.getCategory(), chatSession4.getContacter(), chatSession4.getMarkTop(), chatSession4.getMarkTopTime());
                    }
                    return;
                case 6:
                    for (ChatSession chatSession5 : arrayList) {
                        MediaMessageDBManager.getInstance(this.mContext).updateChatSessionShield(chatSession5.getCategory(), chatSession5.getContacter(), chatSession5.getShield(), chatSession5.getShieldTime());
                    }
                    return;
                case 7:
                    for (ChatSession chatSession6 : arrayList) {
                        MediaMessageDBManager.getInstance(this.mContext).updateChatSessionDisturb(chatSession6.getCategory(), chatSession6.getContacter(), chatSession6.getDisturb());
                    }
                    return;
                case 8:
                default:
                    return;
            }
        }
    }

    private void doNotifyUserClassTypeAgg(int i, List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65544, this, i, list) == null) && list != null && list.size() != 0) {
            ArrayList<Integer> arrayList = new ArrayList();
            for (ChatSession chatSession : list) {
                int classType = chatSession.getClassType();
                if (Utility.isValidAggSession(classType, chatSession.getClassShow()) && !arrayList.contains(Integer.valueOf(classType))) {
                    arrayList.add(Integer.valueOf(classType));
                }
            }
            if (arrayList.size() > 0) {
                for (Integer num : arrayList) {
                    int intValue = num.intValue();
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(Integer.valueOf(intValue));
                    List<ChatSession> chatRecordsByClass = ChatMessageDBManager.getInstance(this.mContext).getChatRecordsByClass(2L, arrayList2);
                    if (chatRecordsByClass != null && chatRecordsByClass.size() != 0) {
                        chatRecordsByClass.get(0).setSessionFrom(2);
                        chatRecordsByClass.get(0).setNewMsgSum(ChatMessageDBManager.getInstance(this.mContext).getNewMsgCountOfClass(intValue));
                        if (i == 2 || (i == 0 && chatRecordsByClass.size() > 1)) {
                            i = 1;
                        }
                        if (chatRecordsByClass.size() > 1) {
                            chatRecordsByClass = chatRecordsByClass.subList(0, 1);
                        }
                    } else {
                        ChatSession chatSession2 = null;
                        try {
                            chatSession2 = list.get(0).m28clone();
                        } catch (CloneNotSupportedException unused) {
                            LogUtils.d(TAG, "doAggSessionChangeNotify classtype exception");
                        }
                        if (chatSession2 != null) {
                            chatSession2.setSessionFrom(2);
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(chatSession2);
                            chatRecordsByClass = arrayList3;
                        }
                        i = 2;
                    }
                    notifySessionChange(i, chatRecordsByClass, this.mSessionChangeListener);
                }
            }
        }
    }

    private void doNotifyUserStrangerFolder(int i, List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65545, this, i, list) == null) && list != null && list.size() != 0) {
            List<ChatSession> strangerSessionList = ChatMessageDBManager.getInstance(this.mContext).getStrangerSessionList(0L, Long.MAX_VALUE, 2);
            int i2 = 2;
            if (strangerSessionList != null && strangerSessionList.size() != 0) {
                strangerSessionList.get(0).setSessionFrom(2);
                strangerSessionList.get(0).setIsStranger(1);
                strangerSessionList.get(0).setNewMsgSum(ChatMessageDBManager.getInstance(this.mContext).getStrangerUnReadCount(0L));
                if (i == 2 || (i == 0 && strangerSessionList.size() > 1)) {
                    i = 1;
                }
                if (strangerSessionList.size() > 1) {
                    strangerSessionList = strangerSessionList.subList(0, 1);
                }
                i2 = i;
            } else {
                ChatSession chatSession = null;
                try {
                    chatSession = list.get(0).m28clone();
                } catch (CloneNotSupportedException unused) {
                    LogUtils.d(TAG, "doAggSessionChangeNotify stanger exception");
                }
                if (chatSession != null) {
                    chatSession.setSessionFrom(2);
                    chatSession.setIsStranger(1);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(chatSession);
                    strangerSessionList = arrayList;
                }
            }
            notifySessionChange(i2, strangerSessionList, this.mSessionChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleBusinessAndGfhSessionChange(int i, int i2, List<ChatSession> list, List<ChatSession> list2, int i3) {
        ChatSession chatSession;
        boolean z;
        ChatSession businessAggSession;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), list, list2, Integer.valueOf(i3)}) == null) {
            if (list != null && list.size() > 0) {
                chatSession = list.get(0);
            } else {
                chatSession = null;
            }
            if (i == 27 && list2 != null && list2.size() > 0) {
                ChatSession chatSession2 = list2.get(0);
                if (chatSession == null || chatSession2.getLastMsgTime() > chatSession.getLastMsgTime()) {
                    chatSession = chatSession2;
                    z = true;
                    if (chatSession != null) {
                        LogUtils.d(TAG, "notifyBusiSessionChange newSession = " + chatSession.toString());
                        int busiSessionTotalUnread = ChatSessionManagerImpl.getInstance(this.mContext).getBusiSessionTotalUnread(i);
                        if (i == 27) {
                            busiSessionTotalUnread += i3;
                        }
                        chatSession.setNewMsgSum(busiSessionTotalUnread);
                        if (!z) {
                            chatSession.setLastMsg(ChatSessionManagerImpl.getInstance(this.mContext).getBusinessSessionLastMsg(chatSession));
                        } else {
                            chatSession.setClassShow(1);
                            chatSession.setCategory(9);
                            chatSession.setChatType(58);
                        }
                        chatSession.setSessionFrom(2);
                        chatSession.setClassType(10);
                    }
                    if (!AccountManager.getMediaRole(this.mContext)) {
                        businessAggSession = MediaMessageDBManager.getInstance(this.mContext).getMediaChatSessionByClassType(10);
                    } else {
                        businessAggSession = ChatMessageDBManager.getInstance(this.mContext).getBusinessAggSession(i);
                    }
                    if (!AccountManager.getMediaRole(this.mContext) && ((chatSession != null && businessAggSession == null) || (chatSession != null && chatSession.getLastMsgTime() > businessAggSession.getLastMsgTime()))) {
                        LogUtils.d(TAG, "notifyBusiSessionChange start to request server");
                        MediaSessionManager.getInstance(this.mContext).getChatSessionFromServer(SessionParam.getNotifyRequestParam(this.mContext), null);
                        return;
                    }
                    if (businessAggSession == null && chatSession == null) {
                        i2 = 2;
                    } else if (businessAggSession != null && chatSession != null) {
                        i2 = 0;
                    } else if ((i2 == 2 && chatSession != null) || (i2 == 0 && businessAggSession != null)) {
                        i2 = 1;
                    }
                    LogUtils.d(TAG, "notifyBusiSessionChange final notifyType = " + i2);
                    if (AccountManager.getMediaRole(this.mContext)) {
                        if (i2 != 2 && chatSession != null) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(chatSession);
                            MediaMessageDBManager.getInstance(this.mContext).updateSessionListWithNotify(arrayList, 1, i2);
                            return;
                        }
                        MediaMessageDBManager.getInstance(this.mContext).delChatRecordByClassType(10);
                        return;
                    }
                    ChatMessageDBManager.getInstance(this.mContext).updateConsultSession(i2, businessAggSession, chatSession);
                    return;
                }
            }
            z = false;
            if (chatSession != null) {
            }
            if (!AccountManager.getMediaRole(this.mContext)) {
            }
            if (!AccountManager.getMediaRole(this.mContext)) {
            }
            if (businessAggSession == null) {
            }
            if (businessAggSession != null) {
            }
            if (i2 == 2) {
                i2 = 1;
                LogUtils.d(TAG, "notifyBusiSessionChange final notifyType = " + i2);
                if (AccountManager.getMediaRole(this.mContext)) {
                }
            }
            i2 = 1;
            LogUtils.d(TAG, "notifyBusiSessionChange final notifyType = " + i2);
            if (AccountManager.getMediaRole(this.mContext)) {
            }
        }
    }

    private void notifyMediaSessionChange(int i, int i2, List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(65549, this, i, i2, list) == null) && list != null && list.size() != 0) {
            notifySessionChange(i2, list, this.mSessionChangeListener);
            doNotifyMediaStrangerFolder(i2, this.mUpdateManager.filterNotifyStrangerFolder(i, i2, list));
        }
    }

    private void notifySessionFromUser(int i, int i2, List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(65551, this, i, i2, list) == null) && list != null && list.size() != 0) {
            doMediaSessionChange(i, i2, list);
        }
    }

    private void notifyUserSessionChange(int i, int i2, List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(65552, this, i, i2, list) == null) && list != null && list.size() != 0) {
            notifySessionChange(i2, list, this.mSessionChangeListener);
            doNotifyUserClassTypeAgg(i2, this.mUpdateManager.filterNotifyAggVirtualSession(i, i2, list));
            doNotifyUserStrangerFolder(i2, this.mUpdateManager.filterNotifyStrangerFolder(i, i2, list));
        }
    }

    private void notifySessionChange(int i, List<ChatSession> list, List<IBaseSessionUpdateListener> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65550, this, i, list, list2) == null) {
            ArrayList<IBaseSessionUpdateListener> arrayList = new ArrayList<>(list2);
            if (arrayList.size() == 0) {
                return;
            }
            completeSessionBusinessType(list);
            ChatSessionManagerImpl.getInstance(this.mContext).completeSessionInfo(list);
            LogUtils.d(TAG, "notifySessionChange type = " + i + " session size = " + list.size());
            doSessionChangeListenerNotify(i, list, arrayList);
        }
    }

    private void redirectToBusiSessionHandler(int i, int i2, List<ChatSession> list) {
        ChatSession next;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(65553, this, i, i2, list) == null) && i == 0) {
            Iterator<ChatSession> it = list.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                if (next.getBusinessType() == 27) {
                    PaInfo paInfoSync = IMBoxManager.getPaInfoSync(this.mContext, next.getPaid());
                    if (paInfoSync != null) {
                        if (paInfoSync.getBusinessType() == 27) {
                            notifyBusiSessionChange(27, i2);
                        }
                    } else {
                        IMBoxManager.getPaInfo(this.mContext, next.getPaid(), new IGetPaInfoListener(this, i2) { // from class: com.baidu.android.imsdk.media.update.ChatSessionUpdateManager.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ChatSessionUpdateManager this$0;
                            public final /* synthetic */ int val$operation;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i2)};
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
                                this.val$operation = i2;
                            }

                            @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfoListener
                            public void onGetPaInfoResult(int i3, String str, PaInfo paInfo) {
                                Interceptable interceptable2 = $ic;
                                if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i3, str, paInfo) == null) && paInfo != null && paInfo.getBusinessType() == 27) {
                                    this.this$0.notifyBusiSessionChange(27, this.val$operation);
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    private void updateMediaStrangerCount(int i, List<ChatSession> list) {
        long newMsgSum;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65555, this, i, list) == null) && list != null && list.size() != 0 && i == 8) {
            int i2 = 0;
            for (ChatSession chatSession : list) {
                if (chatSession.getIsStranger() == 0) {
                    newMsgSum = i2 - chatSession.getNewMsgSum();
                } else {
                    newMsgSum = i2 + chatSession.getNewMsgSum();
                }
                i2 = (int) newMsgSum;
            }
            MediaSessionManager.getInstance(this.mContext).updateStrangerFolderCount(i2);
        }
    }

    private void updateSessionByClassAndNotify(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(65557, this, i, i2) != null) || MediaMessageDBManager.getInstance(this.mContext).getMediaChatSessionByClassType(i) == null) {
            return;
        }
        ArrayList<ChatSession> chatRecordsByClass = ChatMessageDBManager.getInstance(this.mContext).getChatRecordsByClass(1L, Collections.singletonList(Integer.valueOf(i)));
        if (chatRecordsByClass != null && chatRecordsByClass.size() != 0) {
            MediaMessageDBManager.getInstance(this.mContext).updateSessionByClassAndNotify(i, i2);
            return;
        }
        MediaSessionManager.getInstance(this.mContext).deleteSession(SessionParam.getBjhReadOrDelParam(0, 0L, i, 1), null);
    }

    private boolean updateMeidaSessionNewSum(List<ChatSession> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, list)) == null) {
            if (list == null || list.size() == 0) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (ChatSession chatSession : list) {
                if (chatSession.getState() == 0) {
                    ChatSession chatSession2 = null;
                    if (Utility.isValidAggSession(chatSession.getClassType(), chatSession.getClassShow())) {
                        chatSession2 = MediaMessageDBManager.getInstance(this.mContext).getMediaChatSessionByClassType(chatSession.getClassType());
                        if (chatSession2 != null && chatSession2.getLastMsgTime() >= chatSession.getLastMsgTime()) {
                            chatSession2.setNewMsgSum(ChatMessageDBManager.getInstance(this.mContext).getNewMsgCountOfClass(chatSession.getClassType()));
                        }
                    } else if (chatSession.getChatType() == 57 && (chatSession2 = MediaMessageDBManager.getInstance(this.mContext).getChatRecord(chatSession.getCategory(), chatSession.getContacter())) != null && chatSession2.getLastMsgTime() >= chatSession.getLastMsgTime()) {
                        chatSession2.setNewMsgSum(chatSession.getNewMsgSum());
                    }
                    if (chatSession2 != null) {
                        arrayList.add(chatSession2);
                    }
                }
            }
            if (arrayList.size() > 0) {
                updateMediaChatSession(3, arrayList);
            }
            if (arrayList.size() != list.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void doSessionChangeListenerNotify(int i, List<ChatSession> list, ArrayList<IBaseSessionUpdateListener> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, list, arrayList) == null) {
            ArrayList<ChatSession> arrayList2 = new ArrayList();
            for (ChatSession chatSession : list) {
                if (IMConfigInternal.getInstance().getProductLine(this.mContext) != 4 || chatSession.getCategory() == 1) {
                    try {
                        arrayList2.add(chatSession.m28clone());
                    } catch (CloneNotSupportedException e) {
                        LogUtils.e(TAG, "ChatSessionChangerCallBack throw RuntimeException", e);
                    }
                }
            }
            if (arrayList2.size() == 0) {
                return;
            }
            Iterator<IBaseSessionUpdateListener> it = arrayList.iterator();
            while (it.hasNext()) {
                IBaseSessionUpdateListener next = it.next();
                if (next == null) {
                    it.remove();
                } else if (next instanceof IChatSessionUpdateListener) {
                    ((IChatSessionUpdateListener) next).onChatSessionUpdate(i, arrayList2);
                } else if (next instanceof IChatSessionChangeListener) {
                    for (ChatSession chatSession2 : arrayList2) {
                        if (i == 2) {
                            ((IChatSessionChangeListener) next).onChatRecordDelete(chatSession2.getCategory(), chatSession2.getContacter());
                        } else {
                            ((IChatSessionChangeListener) next).onChatSessionUpdate(chatSession2, false);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.android.imsdk.consult.listener.IBusiSessionChangeListener
    public void notifyBusiSessionChange(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            LogUtils.d(TAG, "notifyBusiSessionChange operation = " + i2);
            ChatSessionManagerImpl.getInstance(this.mContext).getSessionByGfhPA(new IMediaGetChatSessionListener(this, i, i2) { // from class: com.baidu.android.imsdk.media.update.ChatSessionUpdateManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatSessionUpdateManager this$0;
                public final /* synthetic */ int val$businessType;
                public final /* synthetic */ int val$operation;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i), Integer.valueOf(i2)};
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
                    this.val$businessType = i;
                    this.val$operation = i2;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener
                public void onMediaGetChatSessionResult(int i3, int i4, int i5, boolean z, List<ChatSession> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), list}) == null) {
                        List<ChatSession> busiChatSessionsFromDb = ChatSessionManagerImpl.getInstance(this.this$0.mContext).getBusiChatSessionsFromDb(this.val$businessType, -1, 0L, 0L, Long.MAX_VALUE, -1, 2);
                        if (list != null && list.size() > 1) {
                            Collections.sort(list, new Comparator<ChatSession>(this) { // from class: com.baidu.android.imsdk.media.update.ChatSessionUpdateManager.2.1
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
                                        int i6 = newInitContext.flag;
                                        if ((i6 & 1) != 0) {
                                            int i7 = i6 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // java.util.Comparator
                                public int compare(ChatSession chatSession, ChatSession chatSession2) {
                                    InterceptResult invokeLL;
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || (invokeLL = interceptable3.invokeLL(1048576, this, chatSession, chatSession2)) == null) {
                                        if (chatSession.getLastMsgTime() > chatSession2.getLastMsgTime()) {
                                            return -1;
                                        }
                                        if (chatSession.getLastMsgTime() < chatSession2.getLastMsgTime()) {
                                            return 1;
                                        }
                                        return 0;
                                    }
                                    return invokeLL.intValue;
                                }
                            });
                        }
                        this.this$0.handleBusinessAndGfhSessionChange(this.val$businessType, this.val$operation, busiChatSessionsFromDb, list, i4);
                    }
                }
            }, 27);
        }
    }

    @Override // com.baidu.android.imsdk.db.DBBase.ChatSessionChangeOberser
    public void notifyDbChange(int i, int i2, List<ChatSession> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), list, Boolean.valueOf(z)}) == null) && list != null && list.size() != 0) {
            if (z && !containsAggSession(list)) {
                notifyUserSessionChange(i, i2, this.mUpdateManager.filterUserSessionUpdate(i, i2, list));
                redirectToBusiSessionHandler(i, i2, list);
                notifyMediaSessionChange(i, i2, this.mUpdateManager.filterMediaSessionUpdate(i, i2, list));
                notifySessionFromUser(i, i2, this.mUpdateManager.filterSendToMediaSession(i, i2, list));
                return;
            }
            notifySessionChange(i2, list, this.mSessionChangeListener);
        }
    }
}
