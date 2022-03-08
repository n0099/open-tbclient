package com.baidu.android.imsdk.chatmessage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.IKickOutListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.sync.SyncAllMessage;
import com.baidu.android.imsdk.chatmessage.sync.SyncGroupMessageService;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.GroupManagerImpl;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.group.request.IMQueryMemberPauidRequest;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener;
import com.baidu.android.imsdk.notification.IFetchNotificationDataListener;
import com.baidu.android.imsdk.upload.FileUploadTask;
import com.baidu.android.imsdk.upload.IFileUploadListener;
import com.baidu.android.imsdk.upload.IUploadTransferListener;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ChatMsgManager extends BaseManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ChatMsgManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void asyncUploadImgToBos(Context context, String str, String str2, int i2, int i3, int i4, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iUploadTransferListener}) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                ChatMsgManagerImpl.getInstance(context).asyncUploadImgToBos(str, str2, i2, i3, i4, iUploadTransferListener);
            } else if (iUploadTransferListener != null) {
                iUploadTransferListener.onFailed(1005, 1, str);
            }
        }
    }

    public static void audioTrans(Context context, String str, String str2, String str3, int i2, BIMValueCallBack bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, str3, Integer.valueOf(i2), bIMValueCallBack}) == null) {
            if (context != null && !TextUtils.isEmpty(str) && new File(str).exists()) {
                ChatMsgManagerImpl.getInstance(context).audioTrans(str, str2, str3, i2, bIMValueCallBack);
            } else if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        }
    }

    public static void clearKillOutListener(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, context) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManagerImpl.getInstance(context).clearKillOutListener();
    }

    public static void createChatSession(Context context, ChatObject chatObject, String str, int i2, String str2, int i3, String str3, String str4, int i4, int i5, long j2, int i6, long j3, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, chatObject, str, Integer.valueOf(i2), str2, Integer.valueOf(i3), str3, str4, Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j2), Integer.valueOf(i6), Long.valueOf(j3), str5, str6, str7}) == null) {
            ChatSessionManagerImpl.getInstance(context).createChatSession(chatObject, str, i2, str2, i3, str3, str4, i4, i5, j2, i6, j3, str5, str6, str7);
        }
    }

    public static boolean deleteAllMsgs(Context context, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2)})) == null) ? context != null && Utility.isCategoryCorrect(i2) && Utility.isContacterCorrect(j2) && ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(i2, j2, false) >= 0 : invokeCommon.booleanValue;
    }

    public static boolean deleteChatSession(Context context, ChatSession chatSession) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, chatSession)) == null) {
            if (context == null || chatSession == null) {
                return false;
            }
            return ChatSessionManagerImpl.getInstance(context).deleteChatSession(chatSession);
        }
        return invokeLL.booleanValue;
    }

    public static int deleteDraftMsg(Context context, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            if (context == null) {
                return -1005;
            }
            return ChatMsgManagerImpl.getInstance(context).deleteDraftMsg(i2, j2);
        }
        return invokeCommon.intValue;
    }

    public static int deleteMsg(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, chatMsg)) == null) {
            if (context == null || chatMsg == null) {
                return -1;
            }
            return ChatMsgManagerImpl.getInstance(context).deleteMsgs(chatMsg);
        }
        return invokeLL.intValue;
    }

    public static ArrayList<ChatMsg> fetchGroupNotifyMsgsSync(Context context, int i2, long j2, int i3, ChatMsg chatMsg) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), chatMsg})) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatMsgManagerImpl.getInstance(context.getApplicationContext()).fetchGroupNotifyMsgsSync(i2, j2, i3, false, chatMsg);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    @Deprecated
    public static ArrayList<ChatMsg> fetchMessageSync(Context context, int i2, long j2, long j3, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i2, j2, j3, i3);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    @Deprecated
    public static Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState(Context context, int i2, long j2, long j3, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            ArrayList<ChatMsg> fetchMessageSync = ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i2, j2, j3, i3);
            ArrayList arrayList = new ArrayList();
            if (fetchMessageSync != null) {
                Iterator<ChatMsg> it = fetchMessageSync.iterator();
                while (it.hasNext()) {
                    ChatMsg next = it.next();
                    if (next.getMsgType() != 1007) {
                        arrayList.add(next);
                    }
                }
            }
            return new Pair<>(Integer.valueOf(SyncAllMessage.getInstance(context).getState()), arrayList);
        }
        return (Pair) invokeCommon.objValue;
    }

    public static void fetchMsgByHostRequst(Context context, long j2, int i2, long j3, long j4, long j5, int i3, IFetchMsgByIdListener iFetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i3), iFetchMsgByIdListener}) == null) {
            fetchMsgByHostRequst(context, j2, i2, j3, j4, j5, i3, iFetchMsgByIdListener, false);
        }
    }

    public static void fetchMsgRequst(Context context, long j2, long j3, int i2, long j4, long j5, long j6, int i3, IFetchMsgByIdListener iFetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i3), iFetchMsgByIdListener}) == null) {
            fetchMsgRequst(context, j2, j3, i2, j4, j5, j6, i3, iFetchMsgByIdListener, false);
        }
    }

    public static void fetchMsgidByMsgid(Context context, int i2, long j2, long j3, long j4, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i3), Integer.valueOf(i4), iFetchMsgByIdListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).fetchMsgidByMsgid(context, i2, j2, j3, j4, i3, i4, 0, iFetchMsgByIdListener);
        }
    }

    public static void fetchPaChatMsgs(Context context, int i2, int i3, long j2, long j3, long j4, int i4, IFetchMessageListener iFetchMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i4), iFetchMessageListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).fetchPaChatMsgs(i2, i3, j2, j3, j4, i4, iFetchMessageListener);
        }
    }

    public static void forwardMessage(Context context, String str, int i2, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        long j2;
        GroupInfo groupInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{context, str, Integer.valueOf(i2), chatMsg, iSendMessageListener}) == null) {
            if (context == null) {
                if (iSendMessageListener != null) {
                    iSendMessageListener.onSendMessageResult(1005, chatMsg);
                }
            } else if (!TextUtils.isEmpty(str) && chatMsg != null) {
                try {
                    j2 = Long.parseLong(str);
                } catch (Exception e2) {
                    String str2 = BaseManager.TAG;
                    LogUtils.e(str2, "uid parse error " + e2.getMessage());
                    new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
                    j2 = 0L;
                }
                if (j2 == 0) {
                    if (iSendMessageListener != null) {
                        iSendMessageListener.onSendMessageResult(1005, chatMsg);
                    }
                } else if (i2 == 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.valueOf(j2));
                    GroupManagerImpl.getInstance(context).getPaidAndUkByBduid(arrayList, new BIMValueCallBack<List<IMQueryMemberPauidRequest.UserId>>(chatMsg, context, iSendMessageListener) { // from class: com.baidu.android.imsdk.chatmessage.ChatMsgManager.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Context val$context;
                        public final /* synthetic */ ISendMessageListener val$listener;
                        public final /* synthetic */ ChatMsg val$newMessage;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {chatMsg, context, iSendMessageListener};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$newMessage = chatMsg;
                            this.val$context = context;
                            this.val$listener = iSendMessageListener;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                        public void onResult(int i3, String str3, List<IMQueryMemberPauidRequest.UserId> list) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, str3, list) == null) || i3 != 0 || list == null || list.size() <= 0) {
                                return;
                            }
                            this.val$newMessage.setRowId(-1L);
                            this.val$newMessage.setCategory(0);
                            this.val$newMessage.setFromUser(AccountManager.getUK(this.val$context));
                            this.val$newMessage.setStatus(1);
                            this.val$newMessage.setSenderUid(AccountManager.getUid(this.val$context));
                            this.val$newMessage.setIsZhida(false);
                            this.val$newMessage.parseForwardmessage(0);
                            IMQueryMemberPauidRequest.UserId userId = list.get(0);
                            this.val$newMessage.setContacterBduid(String.valueOf(userId.getBduid()));
                            if (userId.getPauid() > 0) {
                                this.val$newMessage.setContacter(userId.getPauid());
                                this.val$newMessage.setChatType(7);
                            } else {
                                this.val$newMessage.setContacter(userId.getUk());
                                this.val$newMessage.setChatType(0);
                            }
                            this.val$newMessage.setMsgTime(System.currentTimeMillis());
                            ChatMsgManager.sendMessage(this.val$context, this.val$newMessage, this.val$listener);
                        }
                    });
                } else if (i2 == 1) {
                    long longByString = Utility.getLongByString(str, -1L);
                    chatMsg.setRowId(-1L);
                    chatMsg.setCategory(i2);
                    chatMsg.setContacter(longByString);
                    chatMsg.setFromUser(AccountManager.getUK(context));
                    chatMsg.setStatus(1);
                    chatMsg.setSenderUid(AccountManager.getUid(context));
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(str);
                    ArrayList<GroupInfo> groupInfo2 = GroupInfoDAOImpl.getGroupInfo(context, arrayList2);
                    int i3 = 3;
                    if (groupInfo2 != null && groupInfo2.size() > 0 && (groupInfo = groupInfo2.get(0)) != null && groupInfo.getType() == 3) {
                        i3 = 57;
                    }
                    chatMsg.setChatType(i3);
                    chatMsg.setMsgTime(System.currentTimeMillis());
                    chatMsg.parseForwardmessage(i2);
                    sendMessage(context, chatMsg, iSendMessageListener);
                }
            } else {
                LogUtils.e(BaseManager.TAG, "uid is null or msg is null");
                if (iSendMessageListener != null) {
                    iSendMessageListener.onSendMessageResult(1005, chatMsg);
                }
            }
        }
    }

    public static void genBosObjectUrl(Context context, String str, String str2, String str3, int i2, int i3, int i4, IGenBosObjectUrlListener iGenBosObjectUrlListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{context, str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iGenBosObjectUrlListener}) == null) {
            if (context != null && !TextUtils.isEmpty(str) && new File(str).exists()) {
                ChatMsgManagerImpl.getInstance(context).genBosObjectUrl(str, str2, str3, i2, i3, i4, iGenBosObjectUrlListener);
            } else if (iGenBosObjectUrlListener != null) {
                iGenBosObjectUrlListener.onGenBosObjectUrlListener(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null, null, null);
            }
        }
    }

    public static ArrayList<SessionClass> getAllClassType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) ? ChatSessionManagerImpl.getInstance(context.getApplicationContext()).getAllClassType() : (ArrayList) invokeL.objValue;
    }

    public static ArrayList<ChatSession> getChatRecords(Context context, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            LogUtils.enter();
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatSessionManagerImpl.getInstance(context).getChatRecords(j2, j3);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public static ArrayList<ChatSession> getChatRecordsByClass(Context context, List<Integer> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, context, list)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatSessionManagerImpl.getInstance(context).getChatRecordsByClass(0L, 0L, list);
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static ChatSession getChatSession(Context context, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2)})) == null) ? ChatSessionManagerImpl.getInstance(context).getChatRecord(i2, j2) : (ChatSession) invokeCommon.objValue;
    }

    public static ChatMsg getDraftMsg(Context context, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65565, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            if (context == null) {
                return null;
            }
            return ChatMsgManagerImpl.getInstance(context).getDraftMsg(i2, j2);
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    public static List<ChatSession> getGroupSession(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatSessionManagerImpl.getInstance(context.getApplicationContext()).getGroupSession();
        }
        return (List) invokeL.objValue;
    }

    public static ChatMsg getMsgByMsgId(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65567, null, context, j2)) == null) ? ChatMsgManagerImpl.getInstance(context).getMsgByMsgId(j2) : (ChatMsg) invokeLJ.objValue;
    }

    public static int getNewMsgCount(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            if (context != null && AccountManager.isLogin(context)) {
                return ChatMsgManagerImpl.getInstance(context).getNewMsgCount();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Deprecated
    public static long getNewMsgNum(Context context, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65569, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1L;
            }
            return ChatMsgManagerImpl.getInstance(context).getNewMsgNum(i2, j2);
        }
        return invokeCommon.longValue;
    }

    public static void getNotificationMsgDataList(Context context, SparseArray<List<Integer>> sparseArray, long j2, int i2, IFetchNotificationDataListener iFetchNotificationDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65570, null, new Object[]{context, sparseArray, Long.valueOf(j2), Integer.valueOf(i2), iFetchNotificationDataListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).getNotificationMsgDataList(sparseArray, j2, i2, iFetchNotificationDataListener);
        }
    }

    public static List<ChatMsg> getPaMsgByChatType(Context context, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65571, null, context, i2, i3)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatMsgManagerImpl.getInstance(context).getPaMsgByChatType(i2, i3);
        }
        return (List) invokeLII.objValue;
    }

    public static void getPaMsgByChatTypeAndPaidList(Context context, List<Integer> list, List<Long> list2, long j2, int i2, IFetchNotificationDataListener iFetchNotificationDataListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{context, list, list2, Long.valueOf(j2), Integer.valueOf(i2), iFetchNotificationDataListener}) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManagerImpl.getInstance(context).getPaMsgByChatTypeAndPaidList(list, list2, j2, i2, iFetchNotificationDataListener);
    }

    public static void getPaNewMsgCount(Context context, int i2, int i3, long j2, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65574, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), iGetNewMsgCountListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).getPaNewMsgCount(i2, i3, j2, iGetNewMsgCountListener);
        }
    }

    @Deprecated
    public static long getTotalNewMsgNum(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, context)) == null) {
            if (BaseManager.isNullContext(context)) {
                return 0L;
            }
            return ChatMsgManagerImpl.getInstance(context).getNewMsgCount();
        }
        return invokeL.longValue;
    }

    @Deprecated
    public static long getUnReadMsgCount(Context context, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65576, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1L;
            }
            return ChatMsgManagerImpl.getInstance(context).getNewMsgNum(i2, j2);
        }
        return invokeCommon.longValue;
    }

    public static int getUnReadMsgCountByPaid(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65577, null, context, j2)) == null) {
            if (BaseManager.isNullContext(context)) {
                return 0;
            }
            return ChatMsgManagerImpl.getInstance(context).getNewMsgCountByPaid(j2);
        }
        return invokeLJ.intValue;
    }

    public static int hideAllChatSession(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) ? ChatSessionManagerImpl.getInstance(context).hideAllChatSession() : invokeL.intValue;
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65579, null, context) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManagerImpl.getInstance(context);
        ChatSessionManagerImpl.getInstance(context);
    }

    public static int markMsgClicked(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65580, null, context, chatMsg)) == null) {
            if (context == null || chatMsg == null) {
                return -1;
            }
            return ChatMsgManagerImpl.getInstance(context).markMessageClicked(chatMsg);
        }
        return invokeLL.intValue;
    }

    public static void mediaContactorSetting(Context context, long j2, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65582, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), iMediaContactorSettingListener}) == null) {
            ChatSessionManagerImpl.getInstance(context).mediaContactorSetting(j2, i2, iMediaContactorSettingListener);
        }
    }

    public static void mediaDeleteChatMsg(Context context, long j2, long j3, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65584, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), list, iMediaDeleteChatMsgListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).mediaDeleteChatMsg(j2, j3, list, iMediaDeleteChatMsgListener);
        }
    }

    public static void mediaDeleteChatSession(Context context, long j2, long j3, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65586, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), iMediaDeleteChatSessionListener}) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).mediaDeleteChatSession(j2, j3, iMediaDeleteChatSessionListener);
    }

    public static void mediaFetchChatMsgs(Context context, long j2, long j3, long j4, int i2, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65588, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2), iMediaFetchChatMsgsListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).mediaFetchChatMsgs(context, j2, j3, j4, i2, iMediaFetchChatMsgsListener);
        }
    }

    public static void mediaGetChatSessions(Context context, long j2, int i2, long j3, String str, long j4, int i3, int i4, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65589, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, Long.valueOf(j4), Integer.valueOf(i3), Integer.valueOf(i4), iMediaGetChatSessionListener}) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).mediaGetChatSessions(j2, i2, j3, str, j4, i3, i4, iMediaGetChatSessionListener);
    }

    public static void mediaGetContactorPauid(Context context, long j2, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65592, null, new Object[]{context, Long.valueOf(j2), iMediaGetContactorPauidListener}) == null) {
            ChatSessionManagerImpl.getInstance(context).mediaGetContactorPauid(j2, iMediaGetContactorPauidListener);
        }
    }

    public static void mediaGetContactorSetting(Context context, long j2, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65594, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), iMediaContactorSettingListener}) == null) {
            ChatSessionManagerImpl.getInstance(context).mediaGetContactorSetting(j2, i2, iMediaContactorSettingListener);
        }
    }

    public static void mediaRegisterChatMsgChangedListener(Context context, IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65595, null, context, iMediaChatMsgChangedListener) == null) {
            ChatMsgManagerImpl.getInstance(context).mediaRegisterChatMsgChangedListener(iMediaChatMsgChangedListener);
        }
    }

    public static void mediaSendChatMsg(Context context, long j2, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65597, null, new Object[]{context, Long.valueOf(j2), chatMsg, iMediaSendChatMsgListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).mediaSendChatMsg(j2, chatMsg, iMediaSendChatMsgListener);
        }
    }

    public static void mediaSetSessionRead(Context context, long j2, long j3, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65599, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), iMediaSetSessionReadListener}) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).mediaSetSessionRead(j2, j3, iMediaSetSessionReadListener);
    }

    public static void mediaUnRegisterChatMsgChangedListener(Context context, IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65600, null, context, iMediaChatMsgChangedListener) == null) {
            ChatMsgManagerImpl.getInstance(context).mediaUnRegisterChatMsgChangedListener(iMediaChatMsgChangedListener);
        }
    }

    public static void registerChatSessionListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65601, null, context, iChatSessionChangeListener) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).registerRecordChangeListener(context, iChatSessionChangeListener);
    }

    public static void registerKillOutListener(Context context, IKickOutListener iKickOutListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65602, null, context, iKickOutListener) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManagerImpl.getInstance(context).registerKillOutListener(iKickOutListener);
    }

    public static void registerMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65603, null, context, iMessageReceiveListener) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManagerImpl.getInstance(context).registerMessageReceiveListener(iMessageReceiveListener);
    }

    public static void registerStudioUsePaReceivePaMsg(Context context, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65604, null, context, iLiveMsgReceiveListener) == null) {
            ChatMsgManagerImpl.getInstance(context).registerStudioUsePaReceivePaMsg(iLiveMsgReceiveListener);
        }
    }

    public static void resendMsg(Context context, String str, String str2, int i2, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65605, null, new Object[]{context, str, str2, Integer.valueOf(i2), iSendMessageListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).resendMsg(str, str2, i2, iSendMessageListener);
        }
    }

    public static int saveAsDraftMsg(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65606, null, context, chatMsg)) == null) {
            if (context == null) {
                return -1005;
            }
            return ChatMsgManagerImpl.getInstance(context).saveAsDraftMsg(chatMsg);
        }
        return invokeLL.intValue;
    }

    public static void saveMessage(Context context, ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65607, null, context, chatMsg) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManagerImpl.getInstance(context).saveMessage(chatMsg);
    }

    public static void sendMessage(Context context, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65608, null, context, chatMsg, iSendMessageListener) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        if (chatMsg != null) {
            ChatMsgManagerImpl.getInstance(context).sendMessage(chatMsg, iSendMessageListener);
        } else if (iSendMessageListener != null) {
            iSendMessageListener.onSendMessageResult(1005, chatMsg);
        }
    }

    public static void sendPaChatMsg(Context context, int i2, int i3, long j2, int i4, String str, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65609, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Integer.valueOf(i4), str, iSendMessageListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).sendPaChatMsg(i2, i3, j2, i4, str, iSendMessageListener);
        }
    }

    public static boolean setAllMsgRead(Context context, int i2, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65610, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return false;
            }
            return ChatMsgManagerImpl.getInstance(context).setAllMsgRead(i2, j2, z);
        }
        return invokeCommon.booleanValue;
    }

    public static void setInterActiveMsgStatus(Context context, long j2, long j3, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65611, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            ChatMsgManagerImpl.getInstance(context).setInterActiveMsgStatus(j2, j3, i2, i3);
        }
    }

    public static void setMediaAllSessionRead(Context context, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65612, null, context, iMediaSetSessionReadListener) == null) {
            mediaSetSessionRead(context, -1L, -1, -1L, "", System.currentTimeMillis(), iMediaSetSessionReadListener);
        }
    }

    public static boolean setMsgRead(Context context, int i2, long j2, long j3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65613, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return false;
            }
            return ChatMsgManagerImpl.getInstance(context).setMsgRead(i2, j2, j3, z);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean setMsgReadByChatTpyes(Context context, List<Integer> list, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65614, null, new Object[]{context, list, Long.valueOf(j2)})) == null) ? ChatMsgManagerImpl.getInstance(context).setMsgReadByChatTpyes(list, j2) : invokeCommon.booleanValue;
    }

    public static boolean setMsgReadByChatTypeAndSubType(Context context, SparseArray<List<Integer>> sparseArray, long j2, ISetMessageReadListener iSetMessageReadListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65615, null, new Object[]{context, sparseArray, Long.valueOf(j2), iSetMessageReadListener})) == null) ? ChatMsgManagerImpl.getInstance(context).setMsgReadByChatTypeAndSubType(sparseArray, j2, iSetMessageReadListener) : invokeCommon.booleanValue;
    }

    public static boolean setMsgReadByMsgId(Context context, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65616, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            if (i2 != 1 && i2 != 0) {
                String str = BaseManager.TAG;
                LogUtils.d(str, "return!!! for setMsgReadByMsgId...setType=" + i2);
                return false;
            }
            ChatMsg msgByMsgId = getMsgByMsgId(context, j2);
            if (msgByMsgId != null) {
                String str2 = BaseManager.TAG;
                LogUtils.d(str2, "setMsgReadByMsgId...msg=" + msgByMsgId.toString());
                int category = msgByMsgId.getCategory();
                if (category != 0) {
                    return false;
                }
                long contacter = msgByMsgId.getContacter();
                boolean isZhida = msgByMsgId.isZhida();
                if (i2 == 0) {
                    return setAllMsgRead(context, category, contacter, isZhida);
                }
                if (i2 == 1) {
                    return setMsgRead(context, category, contacter, j2, isZhida);
                }
            }
            LogUtils.d(BaseManager.TAG, "setMsgReadByMsgId...msg=NULL !!!");
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static void setPaMsgsRead(Context context, int i2, int i3, long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65617, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            ChatMsgManagerImpl.getInstance(context).setPaMsgsRead(i2, i3, j2, j3, j4);
        }
    }

    public static void unregisterChatSessionListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65618, null, context, iChatSessionChangeListener) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).unregisterMessageReceiveListener(context, iChatSessionChangeListener);
    }

    public static void unregisterMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65619, null, context, iMessageReceiveListener) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManagerImpl.getInstance(context).unregisterMessageReceiveListener(context, iMessageReceiveListener);
    }

    public static void unregisterStudioUsePaReceivePaMsg(Context context, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65620, null, context, iLiveMsgReceiveListener) == null) {
            ChatMsgManagerImpl.getInstance(context).unregisterStudioUsePaReceivePaMsg(iLiveMsgReceiveListener);
        }
    }

    public static boolean updateChatMsg(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65621, null, context, chatMsg)) == null) ? ChatMsgManagerImpl.getInstance(context).updateMsgContent(chatMsg) : invokeLL.booleanValue;
    }

    public static void uploadFile(Context context, String str, String str2, String str3, String str4, String str5, IFileUploadListener iFileUploadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65622, null, new Object[]{context, str, str2, str3, str4, str5, iFileUploadListener}) == null) {
            if (context != null && !TextUtils.isEmpty(str2) && new File(str2).exists()) {
                new FileUploadTask(context, str, str2, str3, str4, str5, iFileUploadListener).execute(new Void[0]);
            } else if (iFileUploadListener != null) {
                iFileUploadListener.onFailed(1005, Constants.ERROR_MSG_PARAMETER_ERROR);
            }
        }
    }

    public static void fetchMsgByHostRequst(Context context, long j2, int i2, long j3, long j4, long j5, int i3, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i3), iFetchMsgByIdListener, Boolean.valueOf(z)}) == null) {
            ChatMsgManagerImpl.getInstance(context).fetchMsgByHostRequst(j2, i2, j3, j4, j5, i3, iFetchMsgByIdListener, z);
        }
    }

    public static void fetchMsgRequst(Context context, long j2, long j3, int i2, long j4, long j5, long j6, int i3, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i3), iFetchMsgByIdListener, Boolean.valueOf(z)}) == null) {
            ChatMsgManagerImpl.getInstance(context).fetchMsgRequst(j2, j3, i2, j4, j5, j6, i3, iFetchMsgByIdListener, z);
        }
    }

    public static ChatSession getChatSession(Context context, int i2, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65564, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)})) == null) ? ChatSessionManagerImpl.getInstance(context).getChatRecord(i2, j2, j3) : (ChatSession) invokeCommon.objValue;
    }

    public static void mediaDeleteChatMsg(Context context, long j2, int i2, long j3, String str, long j4, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65583, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, Long.valueOf(j4), list, iMediaDeleteChatMsgListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).mediaDeleteChatMsg(j2, i2, j3, str, j4, list, iMediaDeleteChatMsgListener);
        }
    }

    public static void mediaFetchChatMsgs(Context context, long j2, int i2, long j3, String str, long j4, long j5, int i3, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65587, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i3), iMediaFetchChatMsgsListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).mediaFetchChatMsgs(context, j2, i2, j3, str, j4, j5, i3, iMediaFetchChatMsgsListener);
        }
    }

    public static void mediaSendChatMsg(Context context, long j2, int i2, long j3, String str, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65596, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, chatMsg, iMediaSendChatMsgListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).mediaSendChatMsg(j2, i2, j3, str, chatMsg, iMediaSendChatMsgListener);
        }
    }

    public static ArrayList<ChatMsg> fetchMessageSync(Context context, int i2, long j2, int i3, ChatMsg chatMsg) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), chatMsg})) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i2, j2, i3, chatMsg);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public static List<ChatMsg> getPaMsgByChatType(Context context, List<Integer> list, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65572, null, context, list, i2)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatMsgManagerImpl.getInstance(context).getPaMsgByChatType(list, i2);
        }
        return (List) invokeLLI.objValue;
    }

    public static void mediaContactorSetting(Context context, long j2, int i2, long j3, String str, int i3, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65581, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, Integer.valueOf(i3), iMediaContactorSettingListener}) == null) {
            ChatSessionManagerImpl.getInstance(context).mediaContactorSetting(j2, i2, j3, str, i3, iMediaContactorSettingListener);
        }
    }

    public static void mediaGetChatSessions(Context context, long j2, long j3, int i2, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65590, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), iMediaGetChatSessionListener}) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).mediaGetChatSessions(j2, j3, i2, iMediaGetChatSessionListener);
    }

    public static void mediaGetContactorPauid(Context context, long j2, int i2, long j3, String str, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65591, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, iMediaGetContactorPauidListener}) == null) {
            ChatSessionManagerImpl.getInstance(context).mediaGetContactorPauid(j2, i2, j3, str, iMediaGetContactorPauidListener);
        }
    }

    public static void mediaGetContactorSetting(Context context, long j2, int i2, long j3, String str, int i3, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65593, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, Integer.valueOf(i3), iMediaContactorSettingListener}) == null) {
            ChatSessionManagerImpl.getInstance(context).mediaGetContactorSetting(j2, i2, j3, str, i3, iMediaContactorSettingListener);
        }
    }

    public static void mediaSetSessionRead(Context context, long j2, int i2, long j3, String str, long j4, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65598, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, Long.valueOf(j4), iMediaSetSessionReadListener}) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).mediaSetSessionRead(j2, i2, j3, str, j4, iMediaSetSessionReadListener);
    }

    public static ArrayList<ChatSession> getChatRecords(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatSessionManagerImpl.getInstance(context).getChatRecords(0L, 0L);
        }
        return (ArrayList) invokeL.objValue;
    }

    public static void mediaDeleteChatSession(Context context, long j2, int i2, long j3, String str, long j4, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65585, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, Long.valueOf(j4), iMediaDeleteChatSessionListener}) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).mediaDeleteChatSession(j2, i2, j3, str, j4, iMediaDeleteChatSessionListener);
    }

    public static ArrayList<ChatSession> getChatRecords(Context context, List<Integer> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, context, list)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatSessionManagerImpl.getInstance(context).getChatRecords(0L, 0L, list);
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState(Context context, int i2, long j2, int i3, ChatMsg chatMsg) {
        InterceptResult invokeCommon;
        ArrayList<ChatMsg> fetchMessageSync;
        int state;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), chatMsg})) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            boolean z = true;
            if (i2 == 1) {
                long[] jArr = {1007, 1004};
                ArrayList arrayList = new ArrayList();
                arrayList.add(String.valueOf(j2));
                ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(context, arrayList);
                if ((groupInfo == null || groupInfo.size() <= 0 || groupInfo.get(0).getType() != 2) ? false : false) {
                    fetchMessageSync = ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i2, j2, i3, chatMsg, jArr);
                } else {
                    fetchMessageSync = ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i2, j2, i3, chatMsg);
                }
                state = SyncGroupMessageService.getInstance().getState(context, j2);
            } else {
                fetchMessageSync = ChatMsgManagerImpl.getInstance(context).fetchMessageSync(i2, j2, i3, chatMsg);
                state = SyncAllMessage.getInstance(context).getState();
            }
            if (fetchMessageSync != null) {
                String str = BaseManager.TAG;
                LogUtils.d(str, "FFF  fetchmessage size " + fetchMessageSync.size());
            }
            return new Pair<>(Integer.valueOf(state), fetchMessageSync);
        }
        return (Pair) invokeCommon.objValue;
    }
}
