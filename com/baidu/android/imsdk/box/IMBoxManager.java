package com.baidu.android.imsdk.box;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.android.imsdk.IMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.account.IGetMsgSettingSwitchListener;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.account.ISetMsgSettingSwitchListener;
import com.baidu.android.imsdk.account.ISetNotificationPrivacyListener;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener;
import com.baidu.android.imsdk.chatmessage.IFetchMessageListener;
import com.baidu.android.imsdk.chatmessage.IGetNewMsgCountListener;
import com.baidu.android.imsdk.chatmessage.IGetSessionListener;
import com.baidu.android.imsdk.chatmessage.IGetSmartChatSessionListener;
import com.baidu.android.imsdk.chatmessage.IMessageReceiveListener;
import com.baidu.android.imsdk.chatmessage.IOnRegisterNotifyListener;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.ISetMessageReadListener;
import com.baidu.android.imsdk.chatmessage.SessionClass;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManager;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.IGetUnconcernedMsgListener;
import com.baidu.android.imsdk.chatuser.IGetUserIdentityListener;
import com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener;
import com.baidu.android.imsdk.chatuser.IStatusListener;
import com.baidu.android.imsdk.chatuser.IUserPrivacyListener;
import com.baidu.android.imsdk.chatuser.db.ChatUserDBManager;
import com.baidu.android.imsdk.chatuser.db.IMUserManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.notification.IFetchNotificationDataListener;
import com.baidu.android.imsdk.pubaccount.IAcceptPaPushListener;
import com.baidu.android.imsdk.pubaccount.IClickPaQuickReplyListener;
import com.baidu.android.imsdk.pubaccount.IGetPaInfoListener;
import com.baidu.android.imsdk.pubaccount.IGetPaInfosListener;
import com.baidu.android.imsdk.pubaccount.IGetQuickReplyListener;
import com.baidu.android.imsdk.pubaccount.IIsSubscribedListener;
import com.baidu.android.imsdk.pubaccount.IPaSubscriptionChangeListener;
import com.baidu.android.imsdk.pubaccount.IQuerySubscribedPaListListener;
import com.baidu.android.imsdk.pubaccount.ISubscribePaListener;
import com.baidu.android.imsdk.pubaccount.ISubscriptionChangeListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.PaManager;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.shield.IGetDisturbListListener;
import com.baidu.android.imsdk.shield.IGetServiceNotifyMenuListener;
import com.baidu.android.imsdk.shield.IGetShieldAndTopListener;
import com.baidu.android.imsdk.shield.IGetSubscriptionListener;
import com.baidu.android.imsdk.shield.IGetUserShieldListener;
import com.baidu.android.imsdk.shield.ISetSubscriptionListener;
import com.baidu.android.imsdk.shield.ShieldAndTopManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class IMBoxManager {
    private static final String TAG = IMBoxManager.class.getSimpleName();

    public static boolean enableDebugMode(Context context, boolean z) {
        return IMManager.enableDebugMode(context, z);
    }

    public static void init(Context context) {
        IMManager.init(context, 3);
    }

    @Deprecated
    public static void setEnv(Context context, int i) {
        AccountManager.setEnv(context, i);
    }

    public static void login(Context context, String str, ILoginListener iLoginListener) {
        AccountManager.login(context, str, iLoginListener);
    }

    public static boolean setUid(Context context, String str) {
        return AccountManager.setUid(context, str);
    }

    public static String getUid(Context context) {
        return AccountManager.getUid(context);
    }

    public static boolean setAppid(Context context, long j) {
        return AccountManager.setAppid(context, j);
    }

    public static synchronized void logout(final Context context, final ILoginListener iLoginListener) {
        synchronized (IMBoxManager.class) {
            ILoginListener iLoginListener2 = new ILoginListener() { // from class: com.baidu.android.imsdk.box.IMBoxManager.1
                @Override // com.baidu.android.imsdk.account.ILoginListener
                public void onLoginResult(int i, String str) {
                }

                @Override // com.baidu.android.imsdk.account.ILoginListener
                public void onLogoutResult(int i, String str, int i2) {
                    if (i == 0) {
                        AccountManager.clearToken(context, null);
                        AccountManager.clearUid(context);
                        AccountManager.disconnect(context);
                        try {
                            Thread.sleep(200L);
                        } catch (InterruptedException e) {
                            LogUtils.e(IMBoxManager.TAG, "Exception ", e);
                            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
                        }
                    }
                    if (iLoginListener != null) {
                        iLoginListener.onLogoutResult(i, str, i2);
                    }
                }
            };
            unRegisterNotify(context, null);
            AccountManager.logout(context, iLoginListener2);
        }
    }

    public static void subscribePa(Context context, long j, ISubscribePaListener iSubscribePaListener) {
        PaManager.subscribePa(context, j, iSubscribePaListener);
    }

    public static void unSubscribePa(Context context, long j, ISubscribePaListener iSubscribePaListener) {
        PaManager.unSubscribePa(context, j, iSubscribePaListener);
    }

    public static void querySubscribedPaList(Context context, IQuerySubscribedPaListListener iQuerySubscribedPaListListener) {
        PaManager.querySubscribedPaList(context, iQuerySubscribedPaListListener);
    }

    public static void isSubscribed(Context context, long j, IIsSubscribedListener iIsSubscribedListener) {
        PaManager.isSubscribed(context, j, iIsSubscribedListener);
    }

    public static void acceptPaPush(Context context, long j, boolean z, IAcceptPaPushListener iAcceptPaPushListener) {
        PaManager.acceptPaPush(context, j, z, iAcceptPaPushListener);
    }

    @Deprecated
    public static int getNewMsgCount(Context context, long j) {
        return (int) ChatMsgManager.getUnReadMsgCount(context, 0, j);
    }

    public static void getNewMsgCount(final Context context, final long j, final IGetNewMsgCountListener iGetNewMsgCountListener) {
        if (iGetNewMsgCountListener != null) {
            if (context == null || j == -1) {
                iGetNewMsgCountListener.onGetNewMsgCount(0);
                return;
            }
            TaskManager.getInstance(context).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.box.IMBoxManager.2
                @Override // java.lang.Runnable
                public void run() {
                    IGetNewMsgCountListener.this.onGetNewMsgCount((int) ChatMsgManager.getUnReadMsgCount(context, 0, j));
                }
            });
            AccountManagerImpl.getInstance(context);
            AccountManagerImpl.tryConnection(context);
        }
    }

    @Deprecated
    public static boolean setAllMsgRead(Context context, long j) {
        return ChatMsgManager.setAllMsgRead(context, 0, j, false);
    }

    public static boolean setAllMsgRead(Context context, int i, long j, boolean z) {
        return ChatMsgManager.setAllMsgRead(context, i, j, z);
    }

    @Deprecated
    public static boolean setMsgRead(Context context, long j, long j2) {
        return ChatMsgManager.setMsgRead(context, 0, j, j2, false);
    }

    public static boolean setMsgRead(Context context, long j, long j2, boolean z) {
        return ChatMsgManager.setMsgRead(context, 0, j, j2, z);
    }

    @Deprecated
    public static long deleteMsgs(Context context, long j) {
        if (IMManager.isNullContext(context)) {
            return -1L;
        }
        return ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(0, j, false);
    }

    public static long deleteMsgs(Context context, int i, long j, boolean z) {
        if (IMManager.isNullContext(context)) {
            return -1L;
        }
        return ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(i, j, z);
    }

    @Deprecated
    public static int deleteMsgs(Context context, long j, long[] jArr) {
        if (IMManager.isNullContext(context)) {
            return -1;
        }
        return ChatMsgManagerImpl.getInstance(context).deleteMsgs(0, j, jArr, false);
    }

    public static int deleteMsgs(Context context, long j, long[] jArr, boolean z) {
        if (IMManager.isNullContext(context)) {
            return -1;
        }
        return ChatMsgManagerImpl.getInstance(context).deleteMsgs(0, j, jArr, z);
    }

    public static void registerMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        ChatMsgManager.registerMessageReceiveListener(context, iMessageReceiveListener);
    }

    public static void unregisterMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        ChatMsgManager.unregisterMessageReceiveListener(context, iMessageReceiveListener);
    }

    public static void getPaInfos(Context context, ArrayList<Long> arrayList, IGetPaInfosListener iGetPaInfosListener) {
        PaManager.getPaInfos(context, arrayList, iGetPaInfosListener);
    }

    public static void getPaInfo(Context context, long j, IGetPaInfoListener iGetPaInfoListener) {
        PaManager.getPaInfo(context, j, iGetPaInfoListener);
    }

    public static PaInfo getPaInfoSync(Context context, long j) {
        return PaManager.getPaInfo(context, j);
    }

    public static void setDisturb(Context context, long j, int i, IStatusListener iStatusListener) {
        setShield(context, j, 1, i, iStatusListener);
    }

    public static void setMarkTop(Context context, long j, int i, IStatusListener iStatusListener) {
        ShieldAndTopManager.getInstance(context).setMarkTop(j, 1, i, iStatusListener);
    }

    public static void setGroupDisturb(Context context, String str, int i, BIMValueCallBack<String> bIMValueCallBack) {
        GroupManagerImpl.getInstance(context).setGroupDisturb(str, i, bIMValueCallBack);
    }

    public static void registerPaSubscriptionChangeListener(Context context, IPaSubscriptionChangeListener iPaSubscriptionChangeListener) {
        PaManager.registerPaSubscriptionChangeListener(context, iPaSubscriptionChangeListener);
    }

    public static void unregisterPaSubscriptionChangeListener(Context context, IPaSubscriptionChangeListener iPaSubscriptionChangeListener) {
        PaManager.unregisterPaSubscriptionChangeListener(context, iPaSubscriptionChangeListener);
    }

    public static boolean registerNotify(Context context, String str, String str2, String str3, IOnRegisterNotifyListener iOnRegisterNotifyListener) {
        LogUtils.d("IMBoxManager", "channelId=" + str + ";userId=" + str2 + ";appId=" + str3);
        if (IMManager.isNullContext(context)) {
            if (iOnRegisterNotifyListener != null) {
                iOnRegisterNotifyListener.onRegisterNotifyResult(1005, "Context is NULL!");
                return false;
            }
            return false;
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            if (iOnRegisterNotifyListener != null) {
                iOnRegisterNotifyListener.onRegisterNotifyResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR);
                return false;
            }
            return false;
        } else {
            return ChatMsgManagerImpl.getInstance(context).registerNotify(str, str2, str3, iOnRegisterNotifyListener);
        }
    }

    public static void unRegisterNotify(Context context, IOnRegisterNotifyListener iOnRegisterNotifyListener) {
        if (IMManager.isNullContext(context)) {
            if (iOnRegisterNotifyListener != null) {
                iOnRegisterNotifyListener.onUnRegisterNotifyResult(1005, "Context is NULL!");
                return;
            }
            return;
        }
        ChatMsgManagerImpl.getInstance(context).unRegisterNotify(iOnRegisterNotifyListener);
    }

    public static void clearToken(Context context) {
        AccountManager.clearToken(context, null);
    }

    public static void clearUid(Context context) {
        AccountManager.clearUid(context);
    }

    public static ArrayList<ChatMsg> fetchMessageSync(Context context, long j, long j2, int i) {
        return ChatMsgManager.fetchMessageSync(context, 0, j, j2, i);
    }

    public static List<PaInfo> querySubscribedPaListSync(Context context) {
        return PaManager.querySubscribedPaListSync(context);
    }

    public static void disconnect(Context context) {
        AccountManager.disconnect(context);
    }

    public static boolean receiveRemoteNotification(Context context, String str, IFetchMessageListener iFetchMessageListener) {
        if (IMManager.isNullContext(context)) {
            LogUtils.e(TAG, " Context is NULL!");
            return false;
        }
        LogUtils.d(TAG, "receive custom msg:" + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long j = -1;
        long j2 = -1;
        long j3 = -1;
        long j4 = -1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("bd_transformer")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("bd_transformer");
                j = optJSONObject.optLong("to", -1L);
                j2 = optJSONObject.optLong("from", -1L);
                j3 = optJSONObject.optLong("msgid", -1L);
                j4 = optJSONObject.optLong("appid", -1L);
            }
        } catch (JSONException e) {
            LogUtils.e(TAG, str, e);
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
        }
        if (j != Utility.getUK(context) || j2 < 0 || j3 < 0) {
            LogUtils.d(TAG, "touser:" + j + "  uk:" + Utility.getUK(context) + "  appId:" + j4 + "  realAppid" + AccountManager.getAppid(context));
            return false;
        }
        IMManager.init(context, IMConfigInternal.getInstance().getProductLine(context));
        login(context, AccountManager.getToken(context), null);
        return true;
    }

    public static List<ChatSession> getChatSession(Context context) {
        return ChatMsgManager.getChatRecords(context);
    }

    public static void getChatSession(final Context context, final IGetSessionListener iGetSessionListener) {
        if (iGetSessionListener != null) {
            if (context == null) {
                iGetSessionListener.onGetSessionResult(null);
            } else {
                TaskManager.getInstance(context).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.box.IMBoxManager.3
                    @Override // java.lang.Runnable
                    public void run() {
                        IGetSessionListener.this.onGetSessionResult(ChatMsgManager.getChatRecords(context));
                    }
                });
            }
        }
    }

    @Deprecated
    public static List<ChatSession> getChatSession(Context context, List<Integer> list) {
        LogUtils.d(TAG, "HBBH im in getChatSession!!!");
        return ChatMsgManager.getChatRecords(context, list);
    }

    public static void getSmartChatSession(final Context context, final List<Integer> list, final IGetSmartChatSessionListener iGetSmartChatSessionListener) {
        LogUtils.d(TAG, "getSmartChatSession by callback ~ ");
        if (iGetSmartChatSessionListener != null) {
            if (list == null || list.isEmpty()) {
                LogUtils.d(TAG, "getSmartChatSession by callback ~ returned null ~");
                iGetSmartChatSessionListener.onGetSessionResult(-4, null);
                return;
            }
            TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.box.IMBoxManager.4
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<ChatSession> chatRecords = ChatMsgManager.getChatRecords(context, list);
                    int i = 0;
                    if (chatRecords == null) {
                        if (!AccountManager.isLogin(context)) {
                            i = -1;
                        } else if (LoginManager.getInstance(context).getCurrentState().equals(LoginManager.LoginState.LOGINING)) {
                            i = -2;
                        } else {
                            i = -3;
                        }
                    }
                    iGetSmartChatSessionListener.onGetSessionResult(i, chatRecords);
                }
            });
        }
    }

    public static void getChatSession(final Context context, final List<Integer> list, final IGetSessionListener iGetSessionListener) {
        LogUtils.d(TAG, "getChatSession by callback ~ ");
        if (iGetSessionListener != null) {
            if (list == null || list.isEmpty()) {
                LogUtils.d(TAG, "getChatSession by callback ~ returned null ~");
                iGetSessionListener.onGetSessionResult(null);
                return;
            }
            TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.box.IMBoxManager.5
                @Override // java.lang.Runnable
                public void run() {
                    LogUtils.d(IMBoxManager.TAG, "getChatSession by callback ~ start run ~");
                    IGetSessionListener.this.onGetSessionResult(ChatMsgManager.getChatRecords(context, list));
                }
            });
        }
    }

    public static void registerChatSessionChangeListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        ChatMsgManager.registerChatSessionListener(context, iChatSessionChangeListener);
    }

    public static void unregisterChatSessionChangeListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        ChatMsgManager.unregisterChatSessionListener(context, iChatSessionChangeListener);
    }

    @Deprecated
    public static int getNewMsgCount(Context context) {
        return ChatMsgManager.getNewMsgCount(context);
    }

    public static void getNewMsgCount(final Context context, final IGetNewMsgCountListener iGetNewMsgCountListener) {
        if (iGetNewMsgCountListener == null) {
            LogUtils.d(TAG, "getNewMsgCount all, listener is null! ");
        } else if (context == null) {
            LogUtils.d(TAG, "getNewMsgCount all, context is null, return 0! ");
            iGetNewMsgCountListener.onGetNewMsgCount(0);
        } else {
            TaskManager.getInstance(context).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.box.IMBoxManager.6
                @Override // java.lang.Runnable
                public void run() {
                    IGetNewMsgCountListener.this.onGetNewMsgCount(ChatMsgManager.getNewMsgCount(context));
                }
            });
            AccountManagerImpl.getInstance(context);
            AccountManagerImpl.tryConnection(context);
        }
    }

    @Deprecated
    public static int getNewMsgCount(Context context, List<Integer> list) {
        return ChatMessageDBManager.getInstance(context).getNewMsgCount(list);
    }

    public static void getNewMsgCount(final Context context, final List<Integer> list, final IGetNewMsgCountListener iGetNewMsgCountListener) {
        if (iGetNewMsgCountListener == null) {
            LogUtils.d(TAG, "getNewMsgCount type, listener is null! ");
        } else if (list == null || list.isEmpty()) {
            LogUtils.d(TAG, "getNewMsgCount type, chattypes == null || chattypes.isEmpty() is true! return 0! ");
            iGetNewMsgCountListener.onGetNewMsgCount(0);
        } else {
            TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.box.IMBoxManager.7
                @Override // java.lang.Runnable
                public void run() {
                    IGetNewMsgCountListener.this.onGetNewMsgCount(ChatMessageDBManager.getInstance(context).getNewMsgCount(list));
                }
            });
        }
    }

    @Deprecated
    public static int getNewCountOfClass(Context context, int i) {
        return ChatMessageDBManager.getInstance(context).getNewMsgCountOfClass(i);
    }

    public static void getNewCountOfClass(final Context context, final int i, final IGetNewMsgCountListener iGetNewMsgCountListener) {
        if (iGetNewMsgCountListener == null) {
            LogUtils.d(TAG, "getNewCountOfClass, listener is null! ");
        } else if (context == null) {
            LogUtils.d(TAG, "getNewCountOfClass, context is null! return 0! ");
            iGetNewMsgCountListener.onGetNewMsgCount(0);
        } else {
            TaskManager.getInstance(context).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.box.IMBoxManager.8
                @Override // java.lang.Runnable
                public void run() {
                    IGetNewMsgCountListener.this.onGetNewMsgCount(ChatMessageDBManager.getInstance(context).getNewMsgCountOfClass(i));
                }
            });
            AccountManagerImpl.getInstance(context);
            AccountManagerImpl.tryConnection(context);
        }
    }

    public static void registerSubscriptionChangeListener(Context context, ISubscriptionChangeListener iSubscriptionChangeListener) {
        PaManager.registerSubscriptionChangeListener(context, iSubscriptionChangeListener);
    }

    public static void unregisterSubscriptionChangeListener(Context context, ISubscriptionChangeListener iSubscriptionChangeListener) {
        PaManager.unregisterSubscriptionChangeListener(context, iSubscriptionChangeListener);
    }

    public static boolean stopService(Context context) {
        if (context == null) {
            return false;
        }
        return AccountManagerImpl.getInstance(context.getApplicationContext()).stopService();
    }

    public static void getUsersProfiles(Context context, ArrayList<Long> arrayList, boolean z, IGetUsersProfileBatchListener iGetUsersProfileBatchListener) {
        ChatUserManager.getUsersProfiles(context, arrayList, z, iGetUsersProfileBatchListener);
    }

    public static void setUserDisturb(Context context, long j, int i, IUserPrivacyListener iUserPrivacyListener) {
        ChatUserManager.setUserDisturb(context, j, i, iUserPrivacyListener);
    }

    public static void setNotificationPrivacy(Context context, int i, ISetNotificationPrivacyListener iSetNotificationPrivacyListener) {
        AccountManager.setNotificationPrivacy(context, i, iSetNotificationPrivacyListener);
    }

    public static int getNotificationPrivacy(Context context) {
        return AccountManager.getNotificationPrivacy(context);
    }

    public static ChatUser getChatUserSync(Context context, long j) {
        return ChatUserManager.getChatUserSync(context, j);
    }

    public static void forwardMessage(Context context, String str, int i, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        ChatMsgManager.forwardMessage(context, str, i, chatMsg, iSendMessageListener);
    }

    public static ArrayList<SessionClass> getAllClassType(Context context) {
        return ChatMsgManager.getAllClassType(context);
    }

    @Deprecated
    public static ArrayList<ChatSession> getChatRecordsByClass(Context context, List<Integer> list) {
        return ChatMsgManager.getChatRecordsByClass(context, list);
    }

    public static void getChatRecordsByClass(final Context context, final List<Integer> list, final IGetSessionListener iGetSessionListener) {
        if (iGetSessionListener == null) {
            LogUtils.d(TAG, "in getChatRecordsByClass type, listener is null!");
        } else if (context == null || list == null || list.isEmpty()) {
            LogUtils.d(TAG, "in getChatRecordsByClass type, context == null || classtypes == null || classtypes.isEmpty() is true!");
            iGetSessionListener.onGetSessionResult(null);
        } else {
            TaskManager.getInstance(context).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.box.IMBoxManager.9
                @Override // java.lang.Runnable
                public void run() {
                    IGetSessionListener.this.onGetSessionResult(ChatMsgManager.getChatRecordsByClass(context, list));
                }
            });
        }
    }

    public static void removeSessionByClasstype(Context context, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(i));
        ArrayList<ChatSession> chatRecordsByClass = getChatRecordsByClass(context, arrayList);
        if (chatRecordsByClass != null) {
            Iterator<ChatSession> it = chatRecordsByClass.iterator();
            while (it.hasNext()) {
                ChatSession next = it.next();
                ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(next.getCategory(), next.getContacter(), false);
            }
        }
    }

    public void syncPa(Context context) {
        PaManager.syncAllPainfo(context);
    }

    public static void getPaQuickReplies(Context context, long j, IGetQuickReplyListener iGetQuickReplyListener) {
        PaManager.getPaQuickReplies(context, j, iGetQuickReplyListener);
    }

    public static void clickPaQuickReply(Context context, long j, String str, long j2, IClickPaQuickReplyListener iClickPaQuickReplyListener) {
        PaManager.clickPaQuickReply(context, j, str, j2, iClickPaQuickReplyListener);
    }

    public static List<ChatMsg> getPaMsgByChatType(Context context, int i, int i2) {
        return ChatMsgManager.getPaMsgByChatType(context, i, i2);
    }

    public static List<ChatMsg> getPaMsgByChatType(Context context, List<Integer> list, int i) {
        return ChatMsgManager.getPaMsgByChatType(context, list, i);
    }

    public static void getPaMsgByChatTypeAndPaidList(Context context, List<Integer> list, List<Long> list2, long j, int i, IFetchNotificationDataListener iFetchNotificationDataListener) {
        ChatMsgManager.getPaMsgByChatTypeAndPaidList(context, list, list2, j, i, iFetchNotificationDataListener);
    }

    public static void getNotificationMsgDataList(Context context, SparseArray<List<Integer>> sparseArray, long j, int i, IFetchNotificationDataListener iFetchNotificationDataListener) {
        ChatMsgManager.getNotificationMsgDataList(context, sparseArray, j, i, iFetchNotificationDataListener);
    }

    public static void setMsgReadByChatTypes(final Context context, final List<Integer> list, final long j) {
        TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.box.IMBoxManager.10
            @Override // java.lang.Runnable
            public void run() {
                ChatMsgManager.setMsgReadByChatTpyes(context, list, j);
            }
        });
    }

    public static void setMsgReadByChatTypeAndSubType(final Context context, final SparseArray<List<Integer>> sparseArray, final long j, final ISetMessageReadListener iSetMessageReadListener) {
        TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.box.IMBoxManager.11
            @Override // java.lang.Runnable
            public void run() {
                ChatMsgManager.setMsgReadByChatTypeAndSubType(context, sparseArray, j, iSetMessageReadListener);
            }
        });
    }

    public static void getUnconcernedUserDisturb(Context context, IGetUnconcernedMsgListener iGetUnconcernedMsgListener) {
        ChatUserManager.getUnconcernedUserDisturb(context, iGetUnconcernedMsgListener);
    }

    public static void setShield(Context context, long j, int i, int i2, IStatusListener iStatusListener) {
        ShieldAndTopManager.getInstance(context).setShield(j, i, i2, iStatusListener);
    }

    public static void getUserShieldList(Context context, int i, IGetUserShieldListener iGetUserShieldListener) {
        ShieldAndTopManager.getInstance(context).getUserShieldListToShow(i, iGetUserShieldListener);
    }

    public static void setInterActiveMsgStatus(Context context, long j, long j2, int i, int i2) {
        ChatMsgManager.setInterActiveMsgStatus(context, j, j2, i, i2);
    }

    public static void updateMsgUsersFromMsgCenter(@NonNull final Context context) {
        if (Utility.isNeedSync(context, Constants.KEY_SYNC_MSG_TAB_TIME) && AccountManager.isLogin(context)) {
            try {
                List<ChatSession> chatSession = getChatSession(context);
                if (chatSession != null && chatSession.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<Long> arrayList3 = new ArrayList<>();
                    for (ChatSession chatSession2 : chatSession) {
                        if (chatSession2.getChatType() == 0) {
                            ChatUser chatUser = ChatUserDBManager.getInstance(context).getChatUser(chatSession2.getContacter());
                            if (chatUser != null) {
                                arrayList.add(Long.valueOf(chatUser.getBuid()));
                            } else {
                                arrayList2.add(Long.valueOf(chatSession2.getContacter()));
                            }
                        } else if (chatSession2.getChatType() == 7) {
                            arrayList3.add(Long.valueOf(chatSession2.getContacter()));
                        }
                    }
                    if (arrayList.size() > 0) {
                        ChatUserManagerImpl.getInstance(context).updateUserIdentity(arrayList, new IGetUserIdentityListener() { // from class: com.baidu.android.imsdk.box.IMBoxManager.12
                            @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
                            public void onGetUserIdentityResult(int i, List<ChatUser> list) {
                                for (ChatUser chatUser2 : list) {
                                    IMUserManager.getInstance(context).updateUser(chatUser2);
                                    ChatMessageDBManager.getInstance(context).updateSessionClass(chatUser2);
                                }
                            }
                        });
                    }
                    if (arrayList2.size() > 0) {
                        long[] jArr = new long[arrayList2.size()];
                        for (int i = 0; i < arrayList2.size(); i++) {
                            if (arrayList2.get(i) != null) {
                                jArr[i] = ((Long) arrayList2.get(i)).longValue();
                            }
                        }
                        LogUtils.d(TAG, "updateMsgUsersFromMsgCenter noBduidUks :" + arrayList2.toString());
                        ChatUserManagerImpl.getInstance(context).updateUserProfileByUks(jArr, false, "");
                    }
                    if (arrayList3.size() > 0) {
                        LogUtils.d(TAG, "updateMsgUsersFromMsgCenter paIds :" + arrayList3.toString());
                        PaManagerImpl.getInstance(context).getPaInfos(arrayList3, new IGetPaInfosListener() { // from class: com.baidu.android.imsdk.box.IMBoxManager.13
                            @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfosListener
                            public void onResult(int i2, String str, ArrayList<PaInfo> arrayList4) {
                                if (i2 == 0) {
                                    Iterator<PaInfo> it = arrayList4.iterator();
                                    while (it.hasNext()) {
                                        PaInfo next = it.next();
                                        PaInfoDBManager.getInstance(context).subscribePa(next);
                                        ChatMessageDBManager.getInstance(context).updateSessionClass(next);
                                    }
                                }
                            }
                        });
                    }
                    ShieldAndTopManager.getInstance(context).requestSubbusinessContacterList(0, 1, "");
                    ShieldAndTopManager.getInstance(context).requestMsgMarkTopList();
                    Utility.writeLongData(context, Constants.KEY_SYNC_MSG_TAB_TIME, System.currentTimeMillis() + Constants.SYNC_MSG_DELAY_TIME);
                }
            } catch (Exception e) {
                LogUtils.e(TAG, "updateMsgUsersFromMsgCenter :", e);
            }
        }
    }

    public static void updateSubscribedUsers(Context context, @NonNull List<Long> list, @NonNull List<Long> list2) {
        HashMap hashMap = new HashMap();
        for (Long l : list) {
            hashMap.put(l, 1);
        }
        for (Long l2 : list2) {
            hashMap.put(l2, 0);
        }
        ChatUserDBManager.getInstance(context).updateSubscribedUsers(hashMap);
    }

    public static void updateSubscribedPaList(Context context, @NonNull List<Long> list, @NonNull List<Long> list2) {
        HashMap hashMap = new HashMap();
        for (Long l : list) {
            hashMap.put(l, 1);
        }
        for (Long l2 : list2) {
            hashMap.put(l2, 0);
        }
        PaInfoDBManager.getInstance(context).updateSubscribedPaList(hashMap);
    }

    public static void updateSubscribe(Context context, long j, int i, int i2) {
        if (i == 0) {
            ChatUserDBManager.getInstance(context).updateSubscribedUser(j, i2);
        } else if (i == 7) {
            PaInfoDBManager.getInstance(context).updateSubscribedUser(j, i2);
        }
    }

    public static boolean setMsgReadByMsgId(Context context, long j, int i) {
        LogUtils.d(TAG, "setMsgReadByMsgId...msgid=" + j + "， setType=" + i);
        return ChatMsgManager.setMsgReadByMsgId(context, j, i);
    }

    public static void getSubscription(Context context, long j, List<Long> list, List<String> list2, String str, IGetSubscriptionListener iGetSubscriptionListener) {
        ShieldAndTopManager.getInstance(context).getSubscription(j, list, list2, str, iGetSubscriptionListener);
    }

    public static void setSubscription(Context context, long j, List<Long> list, List<String> list2, int i, String str, ISetSubscriptionListener iSetSubscriptionListener) {
        ShieldAndTopManager.getInstance(context).setSubscription(j, list, list2, i, str, iSetSubscriptionListener);
    }

    public static void getServiceNotifyMenuStatus(Context context, long j, List<Long> list, List<String> list2, int i, String str, IGetServiceNotifyMenuListener iGetServiceNotifyMenuListener) {
        ShieldAndTopManager.getInstance(context).getServiceNotifyMenuStatus(j, list, list2, str, i, iGetServiceNotifyMenuListener);
    }

    public static void getShield(Context context, long j, IGetShieldAndTopListener iGetShieldAndTopListener) {
        ShieldAndTopManager.getInstance(context).getOneShieldAndTopRequest(j, iGetShieldAndTopListener);
    }

    public static void setGroupAndStrangerDisturb(Context context, long j, int i, int i2, IStatusListener iStatusListener) {
        ShieldAndTopManager.getInstance(context).requestDisturbAndRemind(j, 3, i, i2, iStatusListener);
    }

    public static void getGroupAndStrangerDisturbList(Context context, IGetDisturbListListener iGetDisturbListListener) {
        ShieldAndTopManager.getInstance(context).getGroupAndStrangerDisturbList(iGetDisturbListListener);
    }

    public static void getSingleContacterSetting(Context context, long j, int i, IGetShieldAndTopListener iGetShieldAndTopListener) {
        ShieldAndTopManager.getInstance(context).getSingleContacterSetting(j, i, iGetShieldAndTopListener);
    }

    public static void getMsgSettingSwitchStatus(Context context, IGetMsgSettingSwitchListener iGetMsgSettingSwitchListener) {
        AccountManager.getMsgSettingSwitchStatus(context, iGetMsgSettingSwitchListener);
    }

    public static void setMsgSettingSwitchStatus(Context context, int i, int i2, ISetMsgSettingSwitchListener iSetMsgSettingSwitchListener) {
        AccountManager.setMsgSettingSwitchStatus(context, i, i2, iSetMsgSettingSwitchListener);
    }
}
