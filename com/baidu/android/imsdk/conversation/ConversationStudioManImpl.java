package com.baidu.android.imsdk.conversation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.BIMConversationStudio;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.IMReceiver;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.account.TodoAfterLogin;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.chatmessage.request.IMAckRequest;
import com.baidu.android.imsdk.chatmessage.request.Type;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.Heartbeat;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageFactory;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.mcast.IMJoinCastMsg;
import com.baidu.android.imsdk.mcast.IMQuitCastMsg;
import com.baidu.android.imsdk.mcast.IMSendQuizOptMsg;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.android.imsdk.request.MessageExt;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.Utils;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.g.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ConversationStudioManImpl {
    private static final int ACK_INTERVAL_TIME = 3000;
    private static final int ACK_MAX_COUNT = 1;
    private static final int RELIABLE_MAX_COUNT = 2;
    private static final int SHORT_ACK_COUNT = 15;
    private static final int SHORT_ACK_INTERVAL_TIME = 10000;
    private static final String TAG = "ConversationStudioManImpl";
    private static Context mContext;
    private static BroadcastReceiver mNetChangedReceiver;
    private static Random mRandom;
    private static McastHeartbeat mcastHeartbeat;
    private long mBeginMsgCastId;
    private long mBeginReliableCastId;
    private long mJoinMsgCastId;
    private long mJoinReliableCastId;
    public static int mCastHeartBeatTime = 3000;
    private static long DEFAULT = -1;
    private static long BEGIN_JOIN = 1;
    private static volatile ConversationStudioManImpl sInstance = null;
    private static Object syncObject = new Object();
    private static volatile AtomicBoolean mOpenPingRequest = new AtomicBoolean(false);
    private static volatile Runnable mPingRunnable = new Runnable() { // from class: com.baidu.android.imsdk.conversation.ConversationStudioManImpl.4
        @Override // java.lang.Runnable
        public void run() {
            a.mHandler.removeCallbacks(ConversationStudioManImpl.mPingRunnable);
            LogUtils.d(ConversationStudioManImpl.TAG, "pingRequest customPingIntervalMs :" + ConversationStudioManImpl.mCastHeartBeatTime);
            if (RequsetNetworkUtils.isNetworkAvailable(ConversationStudioManImpl.mContext)) {
                BIMManager.pingRequest();
            }
            a.mHandler.postDelayed(ConversationStudioManImpl.mPingRunnable, ConversationStudioManImpl.mCastHeartBeatTime);
        }
    };
    private boolean isRegisterNetReceiver = false;
    private long mMaxMsgId = 0;
    private long mReliableMsgCount = 0;
    private long mReliableMaxMsgId = 0;
    private long mRelieableJoinStatus = DEFAULT;
    private long mJoinStatus = DEFAULT;
    private final List<Long> mReliableMcastList = new ArrayList();
    private final List<Long> mAckMcastList = new ArrayList();
    private final ArrayList<ChatMsg> mAckChatMsgList = new ArrayList<>();
    private AtomicBoolean mAcking = new AtomicBoolean(false);
    private Map<Long, FetchConversationStudio> mFetchRunnables = new ConcurrentHashMap();
    private Runnable mAckRunnable = new Runnable() { // from class: com.baidu.android.imsdk.conversation.ConversationStudioManImpl.2
        @Override // java.lang.Runnable
        public void run() {
            if (ConversationStudioManImpl.this.mAckChatMsgList.size() > 0 && ConversationStudioManImpl.this.getConnectState()) {
                synchronized (ConversationStudioManImpl.this.mAckChatMsgList) {
                    try {
                        LogUtils.d(ConversationStudioManImpl.TAG, "mAckRunnable ~~~");
                        LogUtils.e(ConversationStudioManImpl.TAG, "ack mAckChatMsgList.size :" + ConversationStudioManImpl.this.mAckChatMsgList.size());
                        ArrayList arrayList = new ArrayList(ConversationStudioManImpl.this.mAckChatMsgList);
                        a.mHandler.removeCallbacks(ConversationStudioManImpl.this.mAckRunnable);
                        MessageParser.handleAck(ConversationStudioManImpl.mContext, arrayList, false);
                        ConversationStudioManImpl.this.mAckChatMsgList.clear();
                        a.mHandler.postDelayed(ConversationStudioManImpl.this.mAckRunnable, IMConnection.RETRY_DELAY_TIMES);
                    } catch (Exception e) {
                        LogUtils.e(ConversationStudioManImpl.TAG, "ackRunnable Exception :", e);
                        a.mHandler.removeCallbacks(ConversationStudioManImpl.this.mAckRunnable);
                        ConversationStudioManImpl.this.mAckChatMsgList.clear();
                        a.mHandler.postDelayed(ConversationStudioManImpl.this.mAckRunnable, IMConnection.RETRY_DELAY_TIMES);
                    }
                }
                return;
            }
            LogUtils.d(ConversationStudioManImpl.TAG, "mAcking reset false");
            ConversationStudioManImpl.this.mAcking.set(false);
        }
    };
    private Runnable mHttpAckRunnable = new Runnable() { // from class: com.baidu.android.imsdk.conversation.ConversationStudioManImpl.3
        @Override // java.lang.Runnable
        public void run() {
            if (ConversationStudioManImpl.this.mAckChatMsgList.size() <= 0 || ConversationStudioManImpl.this.getConnectState() || !RequsetNetworkUtils.isNetworkAvailable(ConversationStudioManImpl.mContext)) {
                a.mHandler.removeCallbacks(ConversationStudioManImpl.this.mHttpAckRunnable);
                a.mHandler.postDelayed(ConversationStudioManImpl.this.mHttpAckRunnable, 10000L);
                return;
            }
            synchronized (ConversationStudioManImpl.this.mAckChatMsgList) {
                LogUtils.d(ConversationStudioManImpl.TAG, "mHttpAckRunnable");
                LogUtils.e(ConversationStudioManImpl.TAG, "ack mAckChatMsgList.size :" + ConversationStudioManImpl.this.mAckChatMsgList.size());
                a.mHandler.removeCallbacks(ConversationStudioManImpl.this.mHttpAckRunnable);
                for (List list : Utils.splitList(new ArrayList(ConversationStudioManImpl.this.mAckChatMsgList), 15)) {
                    final ArrayList arrayList = (ArrayList) list;
                    final long contacter = ((ChatMsg) arrayList.get(0)).getContacter();
                    final int category = ((ChatMsg) arrayList.get(0)).getCategory();
                    LogUtils.d(ConversationStudioManImpl.TAG, "contacter:" + contacter + ",category:" + category);
                    LogUtils.d(ConversationStudioManImpl.TAG, "onePage.size:" + arrayList.size());
                    TaskManager.getInstance(ConversationStudioManImpl.mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.conversation.ConversationStudioManImpl.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            IMAckRequest iMAckRequest = new IMAckRequest(ConversationStudioManImpl.mContext, "", Utility.getUK(ConversationStudioManImpl.mContext), contacter, category, 0, 0L, 0L, false, arrayList);
                            HttpHelper.executor(ConversationStudioManImpl.mContext, iMAckRequest, iMAckRequest);
                        }
                    });
                }
                ConversationStudioManImpl.this.mAckChatMsgList.clear();
                a.mHandler.postDelayed(ConversationStudioManImpl.this.mHttpAckRunnable, 10000L);
            }
        }
    };

    /* loaded from: classes3.dex */
    interface HeartbeatOperation {
        void cancelHearbeat();

        void startHeartbeat();
    }

    public static ConversationStudioManImpl getInstance(Context context) {
        if (sInstance == null) {
            synchronized (ConversationStudioManImpl.class) {
                if (sInstance == null) {
                    mContext = context.getApplicationContext();
                    sInstance = new ConversationStudioManImpl();
                }
            }
        }
        return sInstance;
    }

    private ConversationStudioManImpl() {
        initStudio();
        a.mHandler.removeCallbacks(this.mHttpAckRunnable);
        a.mHandler.postDelayed(this.mHttpAckRunnable, 10000L);
    }

    public BIMConversation getConversation(BIMManager.CATEGORY category, String str, boolean z, String str2, int i) {
        BIMConversationStudio bIMConversationStudio;
        if (TextUtils.isEmpty(str)) {
            LogUtils.e(TAG, "id should not be empty");
            return null;
        }
        synchronized (syncObject) {
            try {
                long longValue = Long.valueOf(str).longValue();
                int value = category.getValue();
                if (BIMManager.CATEGORY.STUDIO == category) {
                    bIMConversationStudio = new BIMConversationStudio(mContext, category, str, z, new ChatSession(value, longValue, longValue, null), str2, i);
                } else {
                    bIMConversationStudio = null;
                }
            } catch (Exception e) {
                LogUtils.e(TAG, "Id is not long value", e);
                new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
                bIMConversationStudio = null;
            }
        }
        return bIMConversationStudio;
    }

    private void initStudio() {
        clear();
        mRandom = new Random();
        Class<?>[] clsArr = {IMJoinCastMsg.class, IMQuitCastMsg.class, IMSendQuizOptMsg.class};
        int[] iArr = {201, 202, 210};
        for (int i = 0; i < clsArr.length; i++) {
            MessageFactory.getInstance().addType(iArr[i], clsArr[i]);
        }
        AccountManager.registerToDoAfterLoginListener(mContext, new McastTodoAfterLogin());
    }

    public void clear() {
        clearReliableCastList();
        clearFetchRunnable();
        if (a.mHandler != null) {
            a.mHandler.removeCallbacks(mPingRunnable);
        }
    }

    public boolean isReliable(long j) {
        if (j <= 0) {
            return false;
        }
        return this.mReliableMcastList.contains(Long.valueOf(j));
    }

    public void clearReliableCastList() {
        LogUtils.d(TAG, "clearReliableCastList delete List");
        synchronized (this.mReliableMcastList) {
            this.mReliableMcastList.clear();
        }
    }

    public void addReliableCastId(long j) {
        if (j > 0) {
            synchronized (this.mReliableMcastList) {
                if (!this.mReliableMcastList.contains(Long.valueOf(j))) {
                    this.mReliableMcastList.add(Long.valueOf(j));
                }
            }
        }
    }

    public void removeReliableCastId(long j) {
        if (j > 0) {
            synchronized (this.mReliableMcastList) {
                this.mReliableMcastList.remove(Long.valueOf(j));
            }
        }
    }

    public void clearFetchRunnable() {
        this.mFetchRunnables.clear();
    }

    public void addFetchCastId(long j, FetchConversationStudio fetchConversationStudio) {
        if (j > 0 && !this.mFetchRunnables.containsKey(Long.valueOf(j))) {
            this.mFetchRunnables.put(Long.valueOf(j), fetchConversationStudio);
        }
    }

    public void removeFetchCastId(long j) {
        if (j > 0) {
            this.mFetchRunnables.remove(Long.valueOf(j));
        }
    }

    public void beginWithCompletion(long j, boolean z, IMcastSetListener iMcastSetListener) {
        if (z) {
            addReliableCastId(j);
            this.mBeginReliableCastId = j;
            this.mReliableMaxMsgId = 0L;
            this.mReliableMsgCount = 0L;
            this.mRelieableJoinStatus = BEGIN_JOIN;
        } else {
            this.mBeginMsgCastId = j;
            this.mJoinStatus = BEGIN_JOIN;
        }
        this.mJoinReliableCastId = 0L;
        this.mJoinMsgCastId = 0L;
        String addListener = ListenerManager.getInstance().addListener(iMcastSetListener);
        if (LoginManager.getInstance(mContext).isIMLogined()) {
            Intent createMcastMethodIntent = Utility.createMcastMethodIntent(mContext, 201);
            createMcastMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            createMcastMethodIntent.putExtra("mcast_id", j);
            createMcastMethodIntent.putExtra(Constants.EXTRA_OPT_EXT, z);
            try {
                a.an(mContext).e(mContext, createMcastMethodIntent);
                new IMTrack.RequestBuilder(mContext).requestId("" + j).requestTime(System.currentTimeMillis()).ext("service enqueue join").aliasId(501112L).build();
                return;
            } catch (Exception e) {
                ListenerManager.getInstance().removeListener(addListener);
                onJoinCastResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, j);
                LogUtils.e(TAG, "Exception ", e);
                return;
            }
        }
        if (LoginManager.getInstance(mContext).getCurrentState() == LoginManager.LoginState.NOT_LOGIN) {
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.conversation.ConversationStudioManImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    LoginManager.getInstance(ConversationStudioManImpl.mContext).triggleLogoutListener(4001, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                }
            });
        }
        onJoinCastResult(addListener, 1001, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, j);
    }

    public void onJoinCastResult(String str, int i, String str2, long j) {
        String str3;
        IMcastSetListener iMcastSetListener = (IMcastSetListener) ListenerManager.getInstance().removeListener(str);
        LogUtils.d(TAG, "onJoinCastResult----errorCode: " + i + " msg: " + str2 + ", castId :" + j + ", listener :" + iMcastSetListener);
        if (iMcastSetListener != null) {
            mOpenPingRequest.set(false);
            setMcastQuickHeartBeat();
            iMcastSetListener.onResult(i, j, -1L);
            if (i == 0) {
                if (isReliable(j)) {
                    this.mJoinReliableCastId = j;
                    this.mRelieableJoinStatus = i;
                    FetchConversationStudio fetchConversationStudio = this.mFetchRunnables.get(Long.valueOf(j));
                    if (fetchConversationStudio == null) {
                        fetchConversationStudio = new FetchConversationStudio(mContext, j);
                        addFetchCastId(j, fetchConversationStudio);
                    }
                    fetchConversationStudio.fetchCastMsgByMsgId();
                } else {
                    this.mJoinMsgCastId = j;
                    this.mJoinStatus = i;
                }
                registerNetChangedReceiver();
                str3 = "join callback ok";
            } else if (isReliable(j)) {
                this.mJoinReliableCastId = -1000L;
                this.mRelieableJoinStatus = i;
                str3 = "join callback ok";
            } else {
                this.mJoinMsgCastId = -1000L;
                this.mJoinStatus = i;
                str3 = "join callback ok";
            }
        } else {
            str3 = "join callback fail";
            LogUtils.d(TAG, "IMcastSetistener is null");
        }
        new IMTrack.RequestBuilder(mContext).requestId("" + j).requestTime(System.currentTimeMillis()).ext(str3).errorCode(i).aliasId(501113L).build();
    }

    public void onQuitCastResult(String str, int i, String str2, long j) {
        LogUtils.d(TAG, "onQuitCastResult----errorCode: " + i + " msg: " + str2);
        IMcastSetListener iMcastSetListener = (IMcastSetListener) ListenerManager.getInstance().removeListener(str);
        if (iMcastSetListener != null) {
            iMcastSetListener.onResult(i, j, -1L);
        } else {
            LogUtils.d(TAG, "IMcastSetistener is null");
        }
        unRegisterNetChangedReceiver();
        cancelMcastQuickHeartBeat();
    }

    public void endWithCompletion(long j, IMcastSetListener iMcastSetListener) {
        String addListener = ListenerManager.getInstance().addListener(iMcastSetListener);
        if (isReliable(j)) {
            this.mBeginReliableCastId = 0L;
            this.mReliableMsgCount = 0L;
            this.mReliableMaxMsgId = 0L;
        } else {
            this.mBeginMsgCastId = 0L;
        }
        if (AccountManager.isLogin(mContext)) {
            Intent createMcastMethodIntent = Utility.createMcastMethodIntent(mContext, 202);
            createMcastMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            createMcastMethodIntent.putExtra("mcast_id", j);
            try {
                a.an(mContext).e(mContext, createMcastMethodIntent);
                return;
            } catch (Exception e) {
                ListenerManager.getInstance().removeListener(addListener);
                onQuitCastResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, j);
                LogUtils.e(TAG, "Exception ", e);
                return;
            }
        }
        onQuitCastResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, j);
    }

    public void sendQuizOpts(long j, long j2, int i, String str, IMcastSetListener iMcastSetListener) {
        String addListener = ListenerManager.getInstance().addListener(iMcastSetListener);
        if (AccountManager.isLogin(mContext)) {
            Intent createMcastMethodIntent = Utility.createMcastMethodIntent(mContext, 210);
            createMcastMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            createMcastMethodIntent.putExtra("mcast_id", j2);
            createMcastMethodIntent.putExtra("room_id", j);
            createMcastMethodIntent.putExtra(Constants.EXTRA_OPT_CODE, i);
            createMcastMethodIntent.putExtra(Constants.EXTRA_OPT_EXT, str);
            try {
                a.an(mContext).e(mContext, createMcastMethodIntent);
                return;
            } catch (Exception e) {
                ListenerManager.getInstance().removeListener(addListener);
                onSendQuizOptsResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, j2, j);
                LogUtils.e(TAG, "Exception ", e);
                return;
            }
        }
        onSendQuizOptsResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, j2, j);
    }

    public void onSendQuizOptsResult(String str, int i, String str2, long j, long j2) {
        LogUtils.d(TAG, "sendQuizOpts----errorCode: " + i + " msg: " + str2);
        IMcastSetListener iMcastSetListener = (IMcastSetListener) ListenerManager.getInstance().removeListener(str);
        if (iMcastSetListener != null) {
            iMcastSetListener.onResult(i, j, j2);
        } else {
            LogUtils.d(TAG, "IMcastSetistener is null");
        }
    }

    public void handleMessage(JSONObject jSONObject) {
        if (!a.avG || jSONObject != null) {
        }
        JSONArray jSONArray = new JSONArray();
        try {
            long optLong = jSONObject.optLong("mcast_id");
            boolean isReliable = isReliable(optLong);
            JSONArray jSONArray2 = jSONObject.getJSONArray("messages");
            if (isReliable && jSONArray2.length() > 0) {
                this.mMaxMsgId = ((Long) jSONArray2.getJSONObject(0).get("msgid")).longValue();
            }
            MessageExt.getInstance().setCastId(Long.valueOf(optLong));
            MessageExt.getInstance().setLocalTimestamp(Long.valueOf(System.currentTimeMillis()));
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray2.length(); i++) {
                JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                if (jSONObject2.optLong("origin_id") != Utility.getTriggerId(mContext)) {
                    jSONArray.put(jSONObject2);
                } else {
                    LogUtils.d(TAG, "filter self message");
                }
                if (isReliable) {
                    long longValue = ((Long) jSONObject2.get("msgid")).longValue();
                    if (this.mMaxMsgId < longValue) {
                        this.mMaxMsgId = longValue;
                    }
                }
                arrayList.add(Long.valueOf(((Long) jSONObject2.get("msgid")).longValue()));
            }
            if (isReliable) {
                LogUtils.e(TAG, "handleMessage push reliable castId :" + optLong + ", max :" + this.mMaxMsgId);
                FetchConversationStudio fetchConversationStudio = this.mFetchRunnables.get(Long.valueOf(optLong));
                if (fetchConversationStudio == null) {
                    fetchConversationStudio = new FetchConversationStudio(mContext, optLong);
                    addFetchCastId(optLong, fetchConversationStudio);
                }
                fetchConversationStudio.toFetch(this.mMaxMsgId);
            } else if (jSONArray.length() != 0) {
                MessageExt.getInstance().setLastCallbackMsgId((Long) Collections.max(arrayList));
                ChatMsgManagerImpl.getInstance(mContext).deliverMcastMessage(optLong + "", jSONArray);
                if (isAck(optLong)) {
                    LogUtils.d(TAG, "toAck");
                    toAck(jSONArray);
                }
            }
        } catch (JSONException e) {
            LogUtils.e(TAG, "McastmanagerImpl handleMessage parse json error");
        }
    }

    public void deliverCastReliableMsg(long j, @NonNull ArrayList<ChatMsg> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<ChatMsg> it = arrayList.iterator();
            while (it.hasNext()) {
                ChatMsg next = it.next();
                if (j == ((TextMsg) next).getCastId()) {
                    jSONArray.put(new JSONObject(next.getMsgContent()));
                    arrayList2.add(Long.valueOf(next.getMsgId()));
                }
            }
        } catch (JSONException e) {
            LogUtils.e(TAG, "Exception ", e);
        }
        if (jSONArray.length() > 0) {
            this.mReliableMsgCount += arrayList2.size();
            LogUtils.d(TAG, "reliableMsgCount :" + this.mReliableMsgCount + ", DeliverCastReliableMsg :" + arrayList2.toString());
            MessageExt.getInstance().setLastCallbackMsgId((Long) Collections.max(arrayList2));
            ChatMsgManagerImpl.getInstance(mContext).deliverReliableMcastMessage(j + "", jSONArray, arrayList2);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Long] */
    private void toAck(JSONArray jSONArray) {
        Type type = new Type();
        type.t = 0L;
        ArrayList<ChatMsg> parserMessage = MessageParser.parserMessage(mContext, jSONArray, type, false, false);
        synchronized (this.mAckChatMsgList) {
            Iterator<ChatMsg> it = parserMessage.iterator();
            while (it.hasNext()) {
                this.mAckChatMsgList.add(it.next());
            }
        }
        LogUtils.d(TAG, "mAckChatMsgList size:" + this.mAckChatMsgList.size());
        if (!this.mAcking.get()) {
            LogUtils.d(TAG, "begin ack");
            this.mAcking.set(true);
            a.mHandler.removeCallbacks(this.mAckRunnable);
            a.mHandler.postDelayed(this.mAckRunnable, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public boolean getConnectState() {
        if (a.avG) {
            if (com.baidu.lcp.sdk.client.a.vC() != 0) {
                return false;
            }
            return true;
        }
        return IMConnection.getInstance(mContext).isConnected();
    }

    public boolean isAck(long j) {
        if (j <= 0) {
            return false;
        }
        return this.mAckMcastList.contains(Long.valueOf(j));
    }

    public void addAckCastId(long j) {
        if (j > 0) {
            synchronized (this.mAckMcastList) {
                if (!this.mAckMcastList.contains(Long.valueOf(j))) {
                    this.mAckMcastList.add(Long.valueOf(j));
                }
            }
        }
    }

    public void removeAckCastId(long j) {
        if (j > 0) {
            synchronized (this.mAckMcastList) {
                this.mAckMcastList.remove(Long.valueOf(j));
            }
        }
    }

    public void clearAckCastList() {
        synchronized (this.mAckMcastList) {
            this.mAckMcastList.clear();
        }
    }

    public static void resetHeartBeat(int i) {
        if (!a.avG) {
            Heartbeat.ALARM_TIMEOUT = i;
            LogUtils.d(TAG, "reset heartbeat time to = " + Heartbeat.ALARM_TIMEOUT);
            IMSDK.getInstance(mContext).mHeartbeatOperator.cancelHearbeat();
            IMSDK.getInstance(mContext).mHeartbeatOperator.startHeartbeat();
        }
    }

    public void setMcastQuickHeartBeat() {
        if (a.avG && !mOpenPingRequest.get()) {
            mOpenPingRequest.set(true);
            pingRequest(true, mCastHeartBeatTime);
            return;
        }
        mCastHeartBeatTime = mRandom.nextInt(3000) + 3000;
        LogUtils.d(TAG, "mcast now quick heart beat = " + mCastHeartBeatTime);
        if (mcastHeartbeat == null) {
            mcastHeartbeat = new McastHeartbeat();
            mcastHeartbeat.startHeartbeat();
        }
    }

    public void cancelMcastQuickHeartBeat() {
        if (a.avG && mOpenPingRequest.get()) {
            mOpenPingRequest.set(false);
            pingRequest(false, 0L);
            return;
        }
        if (mcastHeartbeat != null) {
            mcastHeartbeat.cancelHearbeat();
            mcastHeartbeat = null;
            LogUtils.d(TAG, "mcast quick heart beat canceled! ");
        }
        resetHeartBeat(60000);
    }

    /* loaded from: classes3.dex */
    public class McastHeartbeat implements HeartbeatOperation {
        private Runnable startHeartBeatTask = new Runnable() { // from class: com.baidu.android.imsdk.conversation.ConversationStudioManImpl.McastHeartbeat.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!a.avG) {
                        Intent intent = new Intent(ConversationStudioManImpl.mContext, a.class);
                        intent.putExtra(Constants.EXTRA_ALARM_ALERT, "OK");
                        intent.setPackage(ConversationStudioManImpl.mContext.getPackageName());
                        a.an(ConversationStudioManImpl.mContext).e(ConversationStudioManImpl.mContext, intent);
                    }
                } catch (Exception e) {
                    if (e instanceof SecurityException) {
                        LogUtils.e(ConversationStudioManImpl.TAG, "box SecurityException!!", e);
                    } else {
                        LogUtils.e(ConversationStudioManImpl.TAG, "box heartbeat error!!", e);
                    }
                }
            }
        };

        public McastHeartbeat() {
        }

        @Override // com.baidu.android.imsdk.conversation.ConversationStudioManImpl.HeartbeatOperation
        public void startHeartbeat() {
            try {
                a.mHandler.removeCallbacks(this.startHeartBeatTask);
                a.mHandler.postDelayed(this.startHeartBeatTask, ConversationStudioManImpl.mCastHeartBeatTime);
            } catch (Exception e) {
                LogUtils.e(ConversationStudioManImpl.TAG, e.getMessage());
            }
        }

        @Override // com.baidu.android.imsdk.conversation.ConversationStudioManImpl.HeartbeatOperation
        public void cancelHearbeat() {
            try {
                a.mHandler.removeCallbacks(this.startHeartBeatTask);
            } catch (Exception e) {
                LogUtils.e(ConversationStudioManImpl.TAG, e.getMessage());
            }
        }
    }

    public void pingRequest(boolean z, long j) {
        if (z) {
            a.mHandler.removeCallbacks(mPingRunnable);
            a.mHandler.postDelayed(mPingRunnable, j);
        } else {
            a.mHandler.removeCallbacks(mPingRunnable);
        }
        LogUtils.d(TAG, "pingRequest show :" + z + ", customPingIntervalMs :" + j);
    }

    public String getAllCastIdList() {
        StringBuilder sb = new StringBuilder();
        sb.append("begin:").append(this.mBeginMsgCastId);
        sb.append(",").append(this.mBeginReliableCastId);
        sb.append(",joined:").append(this.mJoinMsgCastId);
        sb.append(",").append(this.mJoinReliableCastId);
        sb.append(",JoinStatus:").append(this.mJoinStatus);
        sb.append(",reliableJoinStatus:").append(this.mRelieableJoinStatus);
        sb.append(",reliableMaxMsgId:").append(Utility.getReliableMaxMsgId(mContext, this.mJoinReliableCastId));
        sb.append(",imLoginStatus:").append(LoginManager.getInstance(mContext).isIMLogined());
        sb.append(",lcpStatus:").append(getConnectState());
        LogUtils.d(TAG, "getAllCastIdList:" + sb.toString());
        return sb.toString();
    }

    public long getJoinedCastId() {
        return this.mJoinReliableCastId;
    }

    public long getMaxReliableMsgId(long j) {
        return !isReliable(j) ? j : this.mReliableMaxMsgId;
    }

    public long getReliableMsgCount(long j) {
        return !isReliable(j) ? j : this.mReliableMsgCount;
    }

    private void registerNetChangedReceiver() {
        if (!a.avG) {
            try {
                if (mNetChangedReceiver == null && mContext != null) {
                    mNetChangedReceiver = new IMReceiver();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    intentFilter.addAction(McastConfig.ACTION_NETWORK_STATE_CHANGED);
                    intentFilter.addAction(McastConfig.ACTION_WIFI_STATE_CHANGED);
                    mContext.registerReceiver(mNetChangedReceiver, intentFilter);
                    this.isRegisterNetReceiver = true;
                    LogUtils.d(TAG, " registerNetChangedReceiver ok !");
                }
            } catch (Exception e) {
                LogUtils.e(TAG, "Exception ", e);
            }
        }
    }

    private void unRegisterNetChangedReceiver() {
        if (!a.avG) {
            try {
                if (this.isRegisterNetReceiver && mContext != null) {
                    mContext.unregisterReceiver(mNetChangedReceiver);
                    this.isRegisterNetReceiver = false;
                    LogUtils.d(TAG, " unRegisterNetChangedReceiver ok !");
                }
            } catch (Exception e) {
                LogUtils.e(TAG, "Exception ", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class McastTodoAfterLogin implements TodoAfterLogin {
        McastTodoAfterLogin() {
        }

        @Override // com.baidu.android.imsdk.account.TodoAfterLogin
        public void todo(boolean z) {
            ChatMessageDBManager.getInstance(ConversationStudioManImpl.mContext).deleteExpiredReliableMsgs();
            ChatMessageDBManager.getInstance(ConversationStudioManImpl.mContext).deleteStudioUsePaMsgs();
        }
    }
}
