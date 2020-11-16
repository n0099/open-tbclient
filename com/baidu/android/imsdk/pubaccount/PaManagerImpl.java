package com.baidu.android.imsdk.pubaccount;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.CallBack;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordManager;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.UserSettingPaCmdMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.Dispatcher;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageFactory;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.pubaccount.request.IMGetPaTypeRequest;
import com.baidu.android.imsdk.pubaccount.request.IMPaAcceptPushMsg;
import com.baidu.android.imsdk.pubaccount.request.IMPaClickQuickReply;
import com.baidu.android.imsdk.pubaccount.request.IMPaGetInfoListRequest;
import com.baidu.android.imsdk.pubaccount.request.IMPaGetInfoRequest;
import com.baidu.android.imsdk.pubaccount.request.IMPaGetOneInfoRequest;
import com.baidu.android.imsdk.pubaccount.request.IMPaGetQuickReplies;
import com.baidu.android.imsdk.pubaccount.request.IMPaSearchListMsg;
import com.baidu.android.imsdk.pubaccount.request.IMPaSubscribeMsg;
import com.baidu.android.imsdk.pubaccount.request.IMPaSubscribedListMsg;
import com.baidu.android.imsdk.pubaccount.request.IMPaSubscribedMsg;
import com.baidu.android.imsdk.pubaccount.request.IMPaUnsubscribeMsg;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.imsdk.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class PaManagerImpl {
    private static Context mContext;
    private static volatile PaManagerImpl mInstance;
    private Dispatcher.MsgListener listener;
    private Timer mTimer = null;
    private Dispatcher.MsgListener userSettingPaListener = new Dispatcher.MsgListener() { // from class: com.baidu.android.imsdk.pubaccount.PaManagerImpl.2
        @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
        public void dealMessage(int i, ChatMsg chatMsg) {
            LogUtils.d(PaManagerImpl.TAG, "dealpa setting chnge Message " + (chatMsg == null ? null : " msgs size is" + chatMsg.toString()));
            if (chatMsg == null) {
                LogUtils.d(PaManagerImpl.TAG, "dealpa setting chnge Message is null!");
            } else if (!(chatMsg instanceof UserSettingPaCmdMsg)) {
                LogUtils.d(PaManagerImpl.TAG, "msg is not UserSettingPaCmdMsg!");
            } else {
                UserSettingPaCmdMsg userSettingPaCmdMsg = (UserSettingPaCmdMsg) chatMsg;
                final long paId = userSettingPaCmdMsg.getPaId();
                final boolean z = userSettingPaCmdMsg.getSyncStatus() == 1;
                GetChatObjectInfoForRecordHandler getChatObjectInfoForRecordHandler = (GetChatObjectInfoForRecordHandler) GetChatObjectInfoForRecordManager.newInstance(PaManagerImpl.mContext, 0, paId, 1);
                if (getChatObjectInfoForRecordHandler != null) {
                    getChatObjectInfoForRecordHandler.getChatObjectInfo(paId, new CallBack() { // from class: com.baidu.android.imsdk.pubaccount.PaManagerImpl.2.1
                        @Override // com.baidu.android.imsdk.CallBack
                        public void onSuccess(int i2, int i3, Object obj) {
                            if (i2 == 1) {
                                PaInfoDBManager.getInstance(PaManagerImpl.mContext).acceptPaPush(paId, z);
                            }
                            sendPaSettingChangeBoradCast(i2, paId, z);
                            synchronized (PaManagerImpl.mAcceptMsgChangeListeners) {
                                Iterator it = PaManagerImpl.mAcceptMsgChangeListeners.iterator();
                                while (it.hasNext()) {
                                    ((IAcceptMsgChangeListener) it.next()).onAcceptMsgChange(i2, paId, z);
                                }
                            }
                        }

                        @Override // com.baidu.android.imsdk.CallBack
                        public void onError(int i2, int i3, long j) {
                        }
                    });
                }
            }
        }

        @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
        public void dealMessage(int i, ArrayList<ChatMsg> arrayList) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendPaSettingChangeBoradCast(int i, long j, boolean z) {
            Intent intent = new Intent(IMConstants.PA_SETTING_CHANGE_ACTION);
            intent.setPackage(PaManagerImpl.mContext.getPackageName());
            intent.putExtra("type", i);
            intent.putExtra("paId", j);
            intent.putExtra("status", z);
            PaManagerImpl.mContext.sendBroadcast(intent);
        }
    };
    private static final String TAG = PaManagerImpl.class.getSimpleName();
    private static ArrayList<IPaSubscriptionChangeListener> mPaSubscriptionChangeListeners = new ArrayList<>();
    private static ArrayList<ISubscriptionChangeListener> mSubscriptionChangeListeners = new ArrayList<>();
    private static ArrayList<IAcceptMsgChangeListener> mAcceptMsgChangeListeners = new ArrayList<>();

    private PaManagerImpl() {
        Class<?>[] clsArr = {IMPaAcceptPushMsg.class, IMPaSearchListMsg.class, IMPaSubscribedListMsg.class, IMPaSubscribedMsg.class, IMPaSubscribeMsg.class, IMPaUnsubscribeMsg.class};
        int[] iArr = {105, 103, 104, 109, 100, 101};
        for (int i = 0; i < clsArr.length; i++) {
            MessageFactory.getInstance().addType(iArr[i], clsArr[i]);
        }
        this.listener = new Dispatcher.MsgListener() { // from class: com.baidu.android.imsdk.pubaccount.PaManagerImpl.1
            @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
            public void dealMessage(int i2, ChatMsg chatMsg) {
                LogUtils.d(PaManagerImpl.TAG, "dealMessage " + (chatMsg == null ? null : " msgs size is" + chatMsg.toString()));
                if (chatMsg != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(chatMsg.getMsgContent());
                        final long optLong = jSONObject.optLong("pa_uid");
                        final boolean optBoolean = jSONObject.optBoolean(IMConstants.SERVICE_TYPE_SUBSCRIPTION);
                        if (optBoolean) {
                            LogUtils.d(PaManagerImpl.TAG, "dealmessage subscription " + chatMsg.toString());
                            GetChatObjectInfoForRecordHandler getChatObjectInfoForRecordHandler = (GetChatObjectInfoForRecordHandler) GetChatObjectInfoForRecordManager.newInstance(PaManagerImpl.mContext, 0, optLong, 1);
                            if (getChatObjectInfoForRecordHandler != null) {
                                getChatObjectInfoForRecordHandler.getChatObjectInfo(optLong, new CallBack() { // from class: com.baidu.android.imsdk.pubaccount.PaManagerImpl.1.1
                                    @Override // com.baidu.android.imsdk.CallBack
                                    public void onSuccess(int i3, int i4, Object obj) {
                                        if (PaManagerImpl.mPaSubscriptionChangeListeners != null) {
                                            Iterator it = PaManagerImpl.mPaSubscriptionChangeListeners.iterator();
                                            while (it.hasNext()) {
                                                IPaSubscriptionChangeListener iPaSubscriptionChangeListener = (IPaSubscriptionChangeListener) it.next();
                                                if (iPaSubscriptionChangeListener != null) {
                                                    iPaSubscriptionChangeListener.onPaSubscriptionChangeResult(optLong, optBoolean);
                                                }
                                            }
                                            synchronized (PaManagerImpl.mPaSubscriptionChangeListeners) {
                                                Iterator it2 = PaManagerImpl.mSubscriptionChangeListeners.iterator();
                                                while (it2.hasNext()) {
                                                    ISubscriptionChangeListener iSubscriptionChangeListener = (ISubscriptionChangeListener) it2.next();
                                                    if (iSubscriptionChangeListener != null) {
                                                        iSubscriptionChangeListener.onSubscriptionResult(i3, optLong, obj);
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    @Override // com.baidu.android.imsdk.CallBack
                                    public void onError(int i3, int i4, long j) {
                                    }
                                });
                                PaManagerImpl.this.getPaInfo(optLong, null);
                                return;
                            }
                            return;
                        }
                        PaInfoDBManager.getInstance(PaManagerImpl.mContext).unSubscribePa(optLong);
                        if (PaManagerImpl.mPaSubscriptionChangeListeners != null) {
                            Iterator it = PaManagerImpl.mPaSubscriptionChangeListeners.iterator();
                            while (it.hasNext()) {
                                ((IPaSubscriptionChangeListener) it.next()).onPaSubscriptionChangeResult(optLong, optBoolean);
                            }
                            synchronized (PaManagerImpl.mPaSubscriptionChangeListeners) {
                                Iterator it2 = PaManagerImpl.mSubscriptionChangeListeners.iterator();
                                while (it2.hasNext()) {
                                    ISubscriptionChangeListener iSubscriptionChangeListener = (ISubscriptionChangeListener) it2.next();
                                    if (iSubscriptionChangeListener != null) {
                                        iSubscriptionChangeListener.onUnSubscriptionResult(optLong);
                                    }
                                }
                            }
                        }
                    } catch (JSONException e) {
                        LogUtils.e(LogUtils.TAG, "json error dealMessage:", e);
                        new IMTrack.CrashBuilder(PaManagerImpl.mContext).exception(Log.getStackTraceString(e)).build();
                    }
                }
            }

            @Override // com.baidu.android.imsdk.internal.Dispatcher.MsgListener
            public void dealMessage(int i2, ArrayList<ChatMsg> arrayList) {
            }
        };
        Dispatcher.Event event = new Dispatcher.Event();
        event.setCategory(2);
        event.setType(20);
        Dispatcher.registerListener(event, this.listener);
        Dispatcher.Event event2 = new Dispatcher.Event();
        event2.setCategory(2);
        event2.setType(23);
        Dispatcher.registerListener(event2, this.userSettingPaListener);
    }

    public void delPaLocalInfosByPaType(final int i) {
        TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.pubaccount.PaManagerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                LogUtils.d(PaManagerImpl.TAG, "---delPaLocalInfosByPaType---paType = " + i);
                ChatMessageDBManager.getInstance(PaManagerImpl.mContext).delPaLocalInfosByPaType(i);
            }
        });
    }

    public void syncAndQueryAllPaInfo() {
        LogUtils.d(TAG, "syncAndQueryAllPaInfo begin");
        String str = Constants.KEY_PA_SUBSCRIBE_SYNC_TIME + AccountManager.getAppid(mContext) + AccountManager.getUid(mContext);
        if (Utility.readBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_PA, true) && Utility.isNeedSync(mContext, str)) {
            Utility.writeLongData(mContext, str, System.currentTimeMillis() + Utility.getPaSyncDelay());
            syncAllPainfo(mContext);
        }
    }

    public static synchronized PaManagerImpl getInstance(Context context) {
        PaManagerImpl paManagerImpl;
        synchronized (PaManagerImpl.class) {
            if (mInstance == null && mInstance == null) {
                mContext = context.getApplicationContext();
                mInstance = new PaManagerImpl();
            }
            paManagerImpl = mInstance;
        }
        return paManagerImpl;
    }

    public void registerPaSubscriptionChangeListener(Context context, IPaSubscriptionChangeListener iPaSubscriptionChangeListener) {
        if (iPaSubscriptionChangeListener != null && !mPaSubscriptionChangeListeners.contains(iPaSubscriptionChangeListener)) {
            mPaSubscriptionChangeListeners.add(iPaSubscriptionChangeListener);
        }
    }

    public void unregisterPaSubscriptionChangeListener(Context context, IPaSubscriptionChangeListener iPaSubscriptionChangeListener) {
        if (iPaSubscriptionChangeListener != null && mPaSubscriptionChangeListeners.contains(iPaSubscriptionChangeListener)) {
            mPaSubscriptionChangeListeners.remove(iPaSubscriptionChangeListener);
        }
    }

    public List<PaInfo> querySubscribedPaListSync(Context context) {
        List<PaInfo> querySubscribedPaList = PaInfoDBManager.getInstance(mContext).querySubscribedPaList();
        ArrayList arrayList = new ArrayList();
        if (querySubscribedPaList != null) {
            for (PaInfo paInfo : querySubscribedPaList) {
                if (paInfo.getTPL() == AccountManagerImpl.getInstance(mContext).getAppid()) {
                    arrayList.add(paInfo);
                }
            }
        }
        return arrayList;
    }

    public PaInfo getPaInfo(long j) {
        return PaInfoDBManager.getInstance(mContext).queryPaInfo(j);
    }

    public int setPaQuickRelies(long j, String str, long j2) {
        return PaInfoDBManager.getInstance(mContext).setPaQuickRelies(j, str, j2);
    }

    public void subscribePa(final long j, ISubscribePaListener iSubscribePaListener) {
        final String addListener = ListenerManager.getInstance().addListener(iSubscribePaListener);
        if (AccountManager.isLogin(mContext)) {
            getPaInfo(j, new IGetPaInfoListener() { // from class: com.baidu.android.imsdk.pubaccount.PaManagerImpl.4
                @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfoListener
                public void onGetPaInfoResult(int i, String str, PaInfo paInfo) {
                    if (i == 0) {
                        Intent creatMethodIntent = Utility.creatMethodIntent(PaManagerImpl.mContext, 100);
                        creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                        creatMethodIntent.putExtra(Constants.EXTRA_PA_ID, j);
                        creatMethodIntent.putExtra(Constants.EXTRA_PA_INFO, paInfo);
                        try {
                            a.ao(PaManagerImpl.mContext).e(PaManagerImpl.mContext, creatMethodIntent);
                            return;
                        } catch (Exception e) {
                            ListenerManager.getInstance().removeListener(addListener);
                            PaManagerImpl.this.onSubscribePaResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, j);
                            LogUtils.e(PaManagerImpl.TAG, "Exception ", e);
                            return;
                        }
                    }
                    PaManagerImpl.this.onSubscribePaResult(addListener, i, str, j);
                }
            });
        } else {
            onSubscribePaResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, j);
        }
    }

    public void unsubscribePa(long j, ISubscribePaListener iSubscribePaListener) {
        String addListener = ListenerManager.getInstance().addListener(iSubscribePaListener);
        if (AccountManager.isLogin(mContext)) {
            Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 101);
            creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            creatMethodIntent.putExtra(Constants.EXTRA_PA_ID, j);
            try {
                a.ao(mContext).e(mContext, creatMethodIntent);
                return;
            } catch (Exception e) {
                ListenerManager.getInstance().removeListener(addListener);
                onUnsubscribePaResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, j);
                LogUtils.e(TAG, "Exception ", e);
                return;
            }
        }
        onUnsubscribePaResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, j);
    }

    public void getPaInfo(long j, IGetPaInfoListener iGetPaInfoListener) {
        if (AccountManager.isLogin(mContext)) {
            String addListener = ListenerManager.getInstance().addListener(iGetPaInfoListener);
            long appid = AccountManager.getAppid(mContext);
            long uk = IMSDK.getInstance(mContext).getUk();
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j));
            IMPaGetOneInfoRequest iMPaGetOneInfoRequest = new IMPaGetOneInfoRequest(mContext, addListener, arrayList, appid, uk);
            HttpHelper.executor(mContext, iMPaGetOneInfoRequest, iMPaGetOneInfoRequest);
        } else if (iGetPaInfoListener != null) {
            iGetPaInfoListener.onGetPaInfoResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }

    public void getPaQuickReplies(long j, IGetQuickReplyListener iGetQuickReplyListener) {
        if (AccountManager.isLogin(mContext)) {
            PaInfo paInfo = getPaInfo(j);
            QuickReply createQuickReply = QuickReply.createQuickReply(paInfo.getRepliesStr());
            if (createQuickReply != null && System.currentTimeMillis() < (createQuickReply.getRefreshTime() * 1000) + paInfo.getLastRefreshTime()) {
                if (createQuickReply.getStatus() == 0) {
                    iGetQuickReplyListener.onGetQuickReply(createQuickReply, true);
                    return;
                } else {
                    iGetQuickReplyListener.onGetQuickReply(null, true);
                    return;
                }
            }
            setPaQuickRelies(j, "", System.currentTimeMillis());
            IMPaGetQuickReplies iMPaGetQuickReplies = new IMPaGetQuickReplies(mContext, j, ListenerManager.getInstance().addListener(iGetQuickReplyListener));
            HttpHelper.executor(mContext, iMPaGetQuickReplies, iMPaGetQuickReplies);
        } else if (iGetQuickReplyListener != null) {
            iGetQuickReplyListener.onGetQuickReply(null, true);
        }
    }

    public void clickPaQuickReply(long j, String str, long j2, IClickPaQuickReplyListener iClickPaQuickReplyListener) {
        if (AccountManager.isLogin(mContext)) {
            IMPaClickQuickReply iMPaClickQuickReply = new IMPaClickQuickReply(mContext, j, str, j2, ListenerManager.getInstance().addListener(iClickPaQuickReplyListener));
            HttpHelper.executor(mContext, iMPaClickQuickReply, iMPaClickQuickReply);
        } else if (iClickPaQuickReplyListener != null) {
            iClickPaQuickReplyListener.onClickQuickReply(1000);
        }
    }

    public void getPaInfos(ArrayList<Long> arrayList, IGetPaInfosListener iGetPaInfosListener) {
        if (AccountManager.isLogin(mContext)) {
            if (arrayList == null || arrayList.size() == 0) {
                iGetPaInfosListener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
                return;
            }
            long appid = AccountManager.getAppid(mContext);
            long uk = IMSDK.getInstance(mContext).getUk();
            int size = arrayList.size() / 20;
            int i = arrayList.size() % 20 > 0 ? size + 1 : size;
            GetPaInfoSliceListener getPaInfoSliceListener = new GetPaInfoSliceListener(iGetPaInfosListener, i);
            for (int i2 = 0; i2 < i; i2++) {
                requestPaInfos(arrayList.subList(i2 * 20, (i2 + 1) * 20 > arrayList.size() ? arrayList.size() : (i2 + 1) * 20), appid, uk, getPaInfoSliceListener);
            }
        } else if (iGetPaInfosListener != null) {
            iGetPaInfosListener.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }

    private void requestPaInfos(List<Long> list, long j, long j2, GetPaInfoSliceListener getPaInfoSliceListener) {
        IMPaGetInfoListRequest iMPaGetInfoListRequest = new IMPaGetInfoListRequest(mContext, list, j, j2, getPaInfoSliceListener);
        HttpHelper.executor(mContext, iMPaGetInfoListRequest, iMPaGetInfoListRequest);
    }

    public void queryPaInfoList(IQuerySubscribedPaListListener iQuerySubscribedPaListListener) {
        if (!AccountManager.isCuidLogin(mContext)) {
            String addListener = ListenerManager.getInstance().addListener(iQuerySubscribedPaListListener);
            AccountManager.getAppid(mContext);
            IMPaGetInfoRequest iMPaGetInfoRequest = new IMPaGetInfoRequest(mContext, addListener, AccountManager.getAppid(mContext), IMSDK.getInstance(mContext).getUk());
            HttpHelper.executor(mContext, iMPaGetInfoRequest, iMPaGetInfoRequest);
        }
    }

    public void searchPaList(String str, ISearchPaListListener iSearchPaListListener) {
        String addListener = ListenerManager.getInstance().addListener(iSearchPaListListener);
        if (AccountManager.isLogin(mContext)) {
            Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 103);
            creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            creatMethodIntent.putExtra(Constants.EXTRA_PA_SEARCH_CONTENT, str);
            try {
                a.ao(mContext).e(mContext, creatMethodIntent);
                return;
            } catch (Exception e) {
                ListenerManager.getInstance().removeListener(addListener);
                onSearchPaListResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, null);
                LogUtils.e(TAG, "Exception ", e);
                return;
            }
        }
        onSearchPaListResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
    }

    public void querySubscribedPaList(IQuerySubscribedPaListListener iQuerySubscribedPaListListener) {
        String addListener = ListenerManager.getInstance().addListener(iQuerySubscribedPaListListener);
        if (AccountManager.isLogin(mContext)) {
            Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 104);
            creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            try {
                a.ao(mContext).e(mContext, creatMethodIntent);
                return;
            } catch (Exception e) {
                ListenerManager.getInstance().removeListener(addListener);
                onQueryScribedPaListResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, null);
                LogUtils.e(TAG, "Exception ", e);
                return;
            }
        }
        onQueryScribedPaListResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
    }

    public void acceptPaPush(long j, boolean z, IAcceptPaPushListener iAcceptPaPushListener) {
        String addListener = ListenerManager.getInstance().addListener(iAcceptPaPushListener);
        if (AccountManager.isLogin(mContext)) {
            Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 105);
            creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            creatMethodIntent.putExtra(Constants.EXTRA_PA_ID, j);
            creatMethodIntent.putExtra(Constants.EXTRA_PA_ACCEPT_PUSH, z);
            try {
                a.ao(mContext).e(mContext, creatMethodIntent);
                return;
            } catch (Exception e) {
                ListenerManager.getInstance().removeListener(addListener);
                onAcceptPaPushResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, j);
                LogUtils.e(TAG, "Exception ", e);
                return;
            }
        }
        onAcceptPaPushResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, j);
    }

    public void isSubscribed(long j, IIsSubscribedListener iIsSubscribedListener) {
        String addListener = ListenerManager.getInstance().addListener(iIsSubscribedListener);
        if (AccountManager.isLogin(mContext)) {
            Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 109);
            creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            creatMethodIntent.putExtra(Constants.EXTRA_PA_ID, j);
            try {
                a.ao(mContext).e(mContext, creatMethodIntent);
                return;
            } catch (Exception e) {
                ListenerManager.getInstance().removeListener(addListener);
                onIsSubscribedResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, j, false);
                LogUtils.e(TAG, "Exception ", e);
                return;
            }
        }
        onIsSubscribedResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, j, false);
    }

    public void onSubscribePaResult(String str, int i, String str2, long j) {
        LogUtils.d(TAG, "onSubscribePaResult----errorCode: " + i + " msg: " + str2);
        ISubscribePaListener iSubscribePaListener = (ISubscribePaListener) ListenerManager.getInstance().removeListener(str);
        if (iSubscribePaListener != null) {
            iSubscribePaListener.onSubsribePaResult(i, str2, j);
        } else {
            LogUtils.d(TAG, "ISubscribePaListener is null");
        }
    }

    public void onUnsubscribePaResult(String str, int i, String str2, long j) {
        LogUtils.d(TAG, "onUnscribePaResult----errorCode: " + i + " msg: " + str2);
        ISubscribePaListener iSubscribePaListener = (ISubscribePaListener) ListenerManager.getInstance().removeListener(str);
        if (iSubscribePaListener != null) {
            iSubscribePaListener.onUnsubsribePaResult(i, str2, j);
        } else {
            LogUtils.d(TAG, "ISubscribePaListener is null");
        }
    }

    public void onGetPaInfoResult(String str, int i, String str2, PaInfo paInfo) {
        LogUtils.d(TAG, "onGetPaInfoResult----errorCode: " + i + " msg: " + str2);
        IGetPaInfoListener iGetPaInfoListener = (IGetPaInfoListener) ListenerManager.getInstance().removeListener(str);
        if (iGetPaInfoListener != null) {
            iGetPaInfoListener.onGetPaInfoResult(i, str2, paInfo);
        } else {
            LogUtils.d(TAG, "IGetPaInfoListener is null");
        }
    }

    public void onSearchPaListResult(String str, int i, String str2, List<PaInfo> list) {
        LogUtils.d(TAG, "onSearchPaResult----errorCode: " + i + " msg: " + str2);
        ISearchPaListListener iSearchPaListListener = (ISearchPaListListener) ListenerManager.getInstance().removeListener(str);
        if (iSearchPaListListener != null) {
            iSearchPaListListener.onSearchPaListResult(i, str2, list);
        } else {
            LogUtils.d(TAG, "ISearchPaListListener is null");
        }
    }

    public void onQueryScribedPaListResult(String str, int i, String str2, List<PaInfo> list) {
        LogUtils.d(TAG, "onQueryScribedPaListResult----errorCode: " + i + " msg: " + str2);
        IQuerySubscribedPaListListener iQuerySubscribedPaListListener = (IQuerySubscribedPaListListener) ListenerManager.getInstance().removeListener(str);
        if (iQuerySubscribedPaListListener != null) {
            iQuerySubscribedPaListListener.onQuerySubscribedPaResult(i, str2, list);
        } else {
            LogUtils.d(TAG, "IQuerySubscribePaListListener is null");
        }
    }

    public void onAcceptPaPushResult(String str, int i, String str2, long j) {
        LogUtils.d(TAG, "onAcceptPaPushResult----errorCode: " + i + " msg: " + str2);
        IAcceptPaPushListener iAcceptPaPushListener = (IAcceptPaPushListener) ListenerManager.getInstance().removeListener(str);
        if (iAcceptPaPushListener != null) {
            iAcceptPaPushListener.onAcceptPaPushResult(i, str2, j);
        } else {
            LogUtils.d(TAG, "IAcceptPaPushListener is null");
        }
    }

    public void onIsSubscribedResult(String str, int i, String str2, long j, boolean z) {
        LogUtils.d(TAG, "onIsSubscribedResult----errorCode: " + i + " msg: " + str2);
        IIsSubscribedListener iIsSubscribedListener = (IIsSubscribedListener) ListenerManager.getInstance().removeListener(str);
        if (iIsSubscribedListener != null) {
            iIsSubscribedListener.onIsSubscribedResult(i, str2, j, z);
        } else {
            LogUtils.d(TAG, "IIsSubscribedListener is null");
        }
    }

    public void registerSubscriptionChangeListener(ISubscriptionChangeListener iSubscriptionChangeListener) {
        synchronized (mSubscriptionChangeListeners) {
            mSubscriptionChangeListeners.add(iSubscriptionChangeListener);
        }
    }

    public void unregisterPaSubscriptionChangeListener(ISubscriptionChangeListener iSubscriptionChangeListener) {
        synchronized (mSubscriptionChangeListeners) {
            mSubscriptionChangeListeners.remove(iSubscriptionChangeListener);
        }
    }

    public void registerAcceptChangeListener(IAcceptMsgChangeListener iAcceptMsgChangeListener) {
        if (iAcceptMsgChangeListener != null) {
            synchronized (mAcceptMsgChangeListeners) {
                if (!mAcceptMsgChangeListeners.contains(iAcceptMsgChangeListener)) {
                    mAcceptMsgChangeListeners.add(iAcceptMsgChangeListener);
                }
            }
        }
    }

    public void unRegisterAcceptChangeListener(IAcceptMsgChangeListener iAcceptMsgChangeListener) {
        if (iAcceptMsgChangeListener != null) {
            synchronized (mAcceptMsgChangeListeners) {
                mAcceptMsgChangeListeners.remove(iAcceptMsgChangeListener);
            }
        }
    }

    public void getPaType(long j, IGetPaTypeListener iGetPaTypeListener) {
        LogUtils.d(TAG, "getPaType listener =" + iGetPaTypeListener);
        IMGetPaTypeRequest iMGetPaTypeRequest = new IMGetPaTypeRequest(mContext, ListenerManager.getInstance().addListener(iGetPaTypeListener), j);
        HttpHelper.executor(mContext, iMGetPaTypeRequest, iMGetPaTypeRequest);
    }

    public void onGetPaTypeResult(String str, int i, String str2, long j, int i2) {
        LogUtils.d(TAG, "onGETPaTypeResult----errorCode: " + i + " msg: " + str2);
        IGetPaTypeListener iGetPaTypeListener = (IGetPaTypeListener) ListenerManager.getInstance().removeListener(str);
        if (iGetPaTypeListener != null) {
            iGetPaTypeListener.onGetPaType(i, str2, j, i2);
        } else {
            LogUtils.d(TAG, "IGetPaTypeListener is null!");
        }
    }

    public void syncAllPainfo(Context context) {
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.android.imsdk.pubaccount.PaManagerImpl.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                int sDKVersionValue = IMConfigInternal.getInstance().getSDKVersionValue(PaManagerImpl.mContext);
                LogUtils.d(PaManagerImpl.TAG, "syncpa sdkversion =  " + sDKVersionValue);
                if (sDKVersionValue >= 2900036) {
                    ArrayList<Long> queryPaidList = PaInfoDBManager.getInstance(PaManagerImpl.mContext).queryPaidList();
                    if (queryPaidList == null || queryPaidList.size() == 0) {
                        LogUtils.e(PaManagerImpl.TAG, "syncpa syncAllPainfo paidlist is null");
                        return;
                    }
                    LogUtils.d(PaManagerImpl.TAG, "syncAllPainfo> paidlist = " + queryPaidList.toString());
                    PaManagerImpl.this.getPaInfos(queryPaidList, new IGetPaInfosListener() { // from class: com.baidu.android.imsdk.pubaccount.PaManagerImpl.5.1
                        @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfosListener
                        public void onResult(int i, String str, ArrayList<PaInfo> arrayList) {
                            if (i == 0) {
                                Iterator<PaInfo> it = arrayList.iterator();
                                while (it.hasNext()) {
                                    PaInfo next = it.next();
                                    LogUtils.d(PaManagerImpl.TAG, "syncAllPainfo> paid=" + next.getPaId() + ", classtype=" + next.getClassType() + ", classtitle=" + next.getClassTitle() + ", classshow=" + next.getClassshow() + ", marktop=" + next.getMarkTop() + ", markTopTime=" + next.getMarkTopTime());
                                    PaInfoDBManager.getInstance(PaManagerImpl.mContext).subscribePa(next);
                                    ChatMessageDBManager.getInstance(PaManagerImpl.mContext).updateSessionClass(next);
                                }
                            }
                        }
                    });
                }
            }
        }, 60000L);
    }

    public String getPaThirdId(long j) {
        PaInfo paInfo = PaManager.getPaInfo(mContext, j);
        if (paInfo == null) {
            return "";
        }
        return paInfo.getThirdId();
    }
}
