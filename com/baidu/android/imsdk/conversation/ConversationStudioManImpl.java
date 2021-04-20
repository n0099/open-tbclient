package com.baidu.android.imsdk.conversation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
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
import d.b.q.a;
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
/* loaded from: classes.dex */
public class ConversationStudioManImpl {
    public static final int ACK_INTERVAL_TIME = 3000;
    public static final int ACK_MAX_COUNT = 1;
    public static long BEGIN_JOIN = 1;
    public static long DEFAULT = -1;
    public static final int RELIABLE_MAX_COUNT = 2;
    public static final int SHORT_ACK_COUNT = 15;
    public static final int SHORT_ACK_INTERVAL_TIME = 10000;
    public static final String TAG = "ConversationStudioManImpl";
    public static int mCastHeartBeatTime = 3000;
    public static Context mContext;
    public static BroadcastReceiver mNetChangedReceiver;
    public static Random mRandom;
    public static McastHeartbeat mcastHeartbeat;
    public static volatile ConversationStudioManImpl sInstance;
    public final ArrayList<ChatMsg> mAckChatMsgList;
    public final List<Long> mAckMcastList;
    public Runnable mAckRunnable;
    public AtomicBoolean mAcking;
    public long mBeginMsgCastId;
    public long mBeginReliableCastId;
    public Map<Long, FetchConversationStudio> mFetchRunnables;
    public Runnable mHttpAckRunnable;
    public long mJoinMsgCastId;
    public long mJoinReliableCastId;
    public long mJoinStatus;
    public final List<Long> mReliableMcastList;
    public long mRelieableJoinStatus;
    public static Object syncObject = new Object();
    public static volatile AtomicBoolean mOpenPingRequest = new AtomicBoolean(false);
    public static volatile Runnable mPingRunnable = new Runnable() { // from class: com.baidu.android.imsdk.conversation.ConversationStudioManImpl.4
        @Override // java.lang.Runnable
        public void run() {
            a.f65244c.removeCallbacks(ConversationStudioManImpl.mPingRunnable);
            LogUtils.d(ConversationStudioManImpl.TAG, "pingRequest customPingIntervalMs :" + ConversationStudioManImpl.mCastHeartBeatTime);
            if (RequsetNetworkUtils.isNetworkAvailable(ConversationStudioManImpl.mContext)) {
                BIMManager.pingRequest();
            }
            a.f65244c.postDelayed(ConversationStudioManImpl.mPingRunnable, ConversationStudioManImpl.mCastHeartBeatTime);
        }
    };
    public boolean isRegisterNetReceiver = false;
    public long mMaxMsgId = 0;
    public long mReliableMsgCount = 0;
    public long mReliableMaxMsgId = 0;

    /* loaded from: classes.dex */
    public interface HeartbeatOperation {
        void cancelHearbeat();

        void startHeartbeat();
    }

    /* loaded from: classes.dex */
    public class McastHeartbeat implements HeartbeatOperation {
        public Runnable startHeartBeatTask = new Runnable() { // from class: com.baidu.android.imsdk.conversation.ConversationStudioManImpl.McastHeartbeat.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (a.f65246e) {
                        return;
                    }
                    Intent intent = new Intent(ConversationStudioManImpl.mContext, a.class);
                    intent.putExtra(Constants.EXTRA_ALARM_ALERT, "OK");
                    intent.setPackage(ConversationStudioManImpl.mContext.getPackageName());
                    a.e(ConversationStudioManImpl.mContext).d(ConversationStudioManImpl.mContext, intent);
                } catch (Exception e2) {
                    if (e2 instanceof SecurityException) {
                        LogUtils.e(ConversationStudioManImpl.TAG, "box SecurityException!!", e2);
                    } else {
                        LogUtils.e(ConversationStudioManImpl.TAG, "box heartbeat error!!", e2);
                    }
                }
            }
        };

        public McastHeartbeat() {
        }

        @Override // com.baidu.android.imsdk.conversation.ConversationStudioManImpl.HeartbeatOperation
        public void cancelHearbeat() {
            try {
                a.f65244c.removeCallbacks(this.startHeartBeatTask);
            } catch (Exception e2) {
                LogUtils.e(ConversationStudioManImpl.TAG, e2.getMessage());
            }
        }

        @Override // com.baidu.android.imsdk.conversation.ConversationStudioManImpl.HeartbeatOperation
        public void startHeartbeat() {
            try {
                a.f65244c.removeCallbacks(this.startHeartBeatTask);
                a.f65244c.postDelayed(this.startHeartBeatTask, ConversationStudioManImpl.mCastHeartBeatTime);
            } catch (Exception e2) {
                LogUtils.e(ConversationStudioManImpl.TAG, e2.getMessage());
            }
        }
    }

    /* loaded from: classes.dex */
    public class McastTodoAfterLogin implements TodoAfterLogin {
        public McastTodoAfterLogin() {
        }

        @Override // com.baidu.android.imsdk.account.TodoAfterLogin
        public void todo(boolean z) {
            ChatMessageDBManager.getInstance(ConversationStudioManImpl.mContext).deleteExpiredReliableMsgs();
            ChatMessageDBManager.getInstance(ConversationStudioManImpl.mContext).deleteStudioUsePaMsgs();
        }
    }

    public ConversationStudioManImpl() {
        long j = DEFAULT;
        this.mRelieableJoinStatus = j;
        this.mJoinStatus = j;
        this.mReliableMcastList = new ArrayList();
        this.mAckMcastList = new ArrayList();
        this.mAckChatMsgList = new ArrayList<>();
        this.mAcking = new AtomicBoolean(false);
        this.mFetchRunnables = new ConcurrentHashMap();
        this.mAckRunnable = new Runnable() { // from class: com.baidu.android.imsdk.conversation.ConversationStudioManImpl.2
            @Override // java.lang.Runnable
            public void run() {
                if (ConversationStudioManImpl.this.mAckChatMsgList.size() > 0 && ConversationStudioManImpl.this.getConnectState()) {
                    synchronized (ConversationStudioManImpl.this.mAckChatMsgList) {
                        try {
                            LogUtils.d(ConversationStudioManImpl.TAG, "mAckRunnable ~~~");
                            LogUtils.e(ConversationStudioManImpl.TAG, "ack mAckChatMsgList.size :" + ConversationStudioManImpl.this.mAckChatMsgList.size());
                            ArrayList arrayList = new ArrayList(ConversationStudioManImpl.this.mAckChatMsgList);
                            a.f65244c.removeCallbacks(ConversationStudioManImpl.this.mAckRunnable);
                            MessageParser.handleAck(ConversationStudioManImpl.mContext, arrayList, false);
                            ConversationStudioManImpl.this.mAckChatMsgList.clear();
                            a.f65244c.postDelayed(ConversationStudioManImpl.this.mAckRunnable, 3000L);
                        } catch (Exception e2) {
                            LogUtils.e(ConversationStudioManImpl.TAG, "ackRunnable Exception :", e2);
                            a.f65244c.removeCallbacks(ConversationStudioManImpl.this.mAckRunnable);
                            ConversationStudioManImpl.this.mAckChatMsgList.clear();
                            a.f65244c.postDelayed(ConversationStudioManImpl.this.mAckRunnable, 3000L);
                        }
                    }
                    return;
                }
                LogUtils.d(ConversationStudioManImpl.TAG, "mAcking reset false");
                ConversationStudioManImpl.this.mAcking.set(false);
            }
        };
        this.mHttpAckRunnable = new Runnable() { // from class: com.baidu.android.imsdk.conversation.ConversationStudioManImpl.3
            @Override // java.lang.Runnable
            public void run() {
                if (ConversationStudioManImpl.this.mAckChatMsgList.size() <= 0 || ConversationStudioManImpl.this.getConnectState() || !RequsetNetworkUtils.isNetworkAvailable(ConversationStudioManImpl.mContext)) {
                    a.f65244c.removeCallbacks(ConversationStudioManImpl.this.mHttpAckRunnable);
                    a.f65244c.postDelayed(ConversationStudioManImpl.this.mHttpAckRunnable, 10000L);
                    return;
                }
                synchronized (ConversationStudioManImpl.this.mAckChatMsgList) {
                    LogUtils.d(ConversationStudioManImpl.TAG, "mHttpAckRunnable");
                    LogUtils.e(ConversationStudioManImpl.TAG, "ack mAckChatMsgList.size :" + ConversationStudioManImpl.this.mAckChatMsgList.size());
                    a.f65244c.removeCallbacks(ConversationStudioManImpl.this.mHttpAckRunnable);
                    for (List list : Utils.splitList(new ArrayList(ConversationStudioManImpl.this.mAckChatMsgList), 15)) {
                        final ArrayList arrayList = (ArrayList) list;
                        final long contacter = ((ChatMsg) arrayList.get(0)).getContacter();
                        final int category = ((ChatMsg) arrayList.get(0)).getCategory();
                        LogUtils.d(ConversationStudioManImpl.TAG, "contacter:" + contacter + ",category:" + category);
                        StringBuilder sb = new StringBuilder();
                        sb.append("onePage.size:");
                        sb.append(arrayList.size());
                        LogUtils.d(ConversationStudioManImpl.TAG, sb.toString());
                        TaskManager.getInstance(ConversationStudioManImpl.mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.conversation.ConversationStudioManImpl.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                IMAckRequest iMAckRequest = new IMAckRequest(ConversationStudioManImpl.mContext, "", Utility.getUK(ConversationStudioManImpl.mContext), contacter, category, 0, 0L, 0L, false, arrayList);
                                HttpHelper.executor(ConversationStudioManImpl.mContext, iMAckRequest, iMAckRequest);
                            }
                        });
                    }
                    ConversationStudioManImpl.this.mAckChatMsgList.clear();
                    a.f65244c.postDelayed(ConversationStudioManImpl.this.mHttpAckRunnable, 10000L);
                }
            }
        };
        initStudio();
        a.f65244c.removeCallbacks(this.mHttpAckRunnable);
        a.f65244c.postDelayed(this.mHttpAckRunnable, 10000L);
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

    private void initStudio() {
        clear();
        mRandom = new Random();
        Class<?>[] clsArr = {IMJoinCastMsg.class, IMQuitCastMsg.class, IMSendQuizOptMsg.class};
        int[] iArr = {201, 202, Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST};
        for (int i = 0; i < 3; i++) {
            MessageFactory.getInstance().addType(iArr[i], clsArr[i]);
        }
        AccountManager.registerToDoAfterLoginListener(mContext, new McastTodoAfterLogin());
    }

    private void registerNetChangedReceiver() {
        if (a.f65246e) {
            return;
        }
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
        } catch (Exception e2) {
            LogUtils.e(TAG, "Exception ", e2);
        }
    }

    public static void resetHeartBeat(int i) {
        if (a.f65246e) {
            return;
        }
        Heartbeat.ALARM_TIMEOUT = i;
        LogUtils.d(TAG, "reset heartbeat time to = " + Heartbeat.ALARM_TIMEOUT);
        IMSDK.getInstance(mContext).mHeartbeatOperator.cancelHearbeat();
        IMSDK.getInstance(mContext).mHeartbeatOperator.startHeartbeat();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Long] */
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
        if (this.mAcking.get()) {
            return;
        }
        LogUtils.d(TAG, "begin ack");
        this.mAcking.set(true);
        a.f65244c.removeCallbacks(this.mAckRunnable);
        a.f65244c.postDelayed(this.mAckRunnable, 3000L);
    }

    private void unRegisterNetChangedReceiver() {
        if (a.f65246e) {
            return;
        }
        try {
            if (this.isRegisterNetReceiver && mContext != null) {
                mContext.unregisterReceiver(mNetChangedReceiver);
                this.isRegisterNetReceiver = false;
                LogUtils.d(TAG, " unRegisterNetChangedReceiver ok !");
            }
        } catch (Exception e2) {
            LogUtils.e(TAG, "Exception ", e2);
        }
    }

    public void addAckCastId(long j) {
        if (j <= 0) {
            return;
        }
        synchronized (this.mAckMcastList) {
            if (!this.mAckMcastList.contains(Long.valueOf(j))) {
                this.mAckMcastList.add(Long.valueOf(j));
            }
        }
    }

    public void addFetchCastId(long j, FetchConversationStudio fetchConversationStudio) {
        if (j > 0 && !this.mFetchRunnables.containsKey(Long.valueOf(j))) {
            this.mFetchRunnables.put(Long.valueOf(j), fetchConversationStudio);
        }
    }

    public void addReliableCastId(long j) {
        if (j <= 0) {
            return;
        }
        synchronized (this.mReliableMcastList) {
            if (!this.mReliableMcastList.contains(Long.valueOf(j))) {
                this.mReliableMcastList.add(Long.valueOf(j));
            }
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
                a.e(mContext).d(mContext, createMcastMethodIntent);
                IMTrack.RequestBuilder requestBuilder = new IMTrack.RequestBuilder(mContext);
                requestBuilder.requestId("" + j).requestTime(System.currentTimeMillis()).ext("service enqueue join").aliasId(501112L).build();
                return;
            } catch (Exception e2) {
                ListenerManager.getInstance().removeListener(addListener);
                onJoinCastResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, j);
                LogUtils.e(TAG, "Exception ", e2);
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

    public void cancelMcastQuickHeartBeat() {
        if (a.f65246e && mOpenPingRequest.get()) {
            mOpenPingRequest.set(false);
            pingRequest(false, 0L);
            return;
        }
        McastHeartbeat mcastHeartbeat2 = mcastHeartbeat;
        if (mcastHeartbeat2 != null) {
            mcastHeartbeat2.cancelHearbeat();
            mcastHeartbeat = null;
            LogUtils.d(TAG, "mcast quick heart beat canceled! ");
        }
        resetHeartBeat(60000);
    }

    public void clear() {
        clearReliableCastList();
        clearFetchRunnable();
        Handler handler = a.f65244c;
        if (handler != null) {
            handler.removeCallbacks(mPingRunnable);
        }
    }

    public void clearAckCastList() {
        synchronized (this.mAckMcastList) {
            this.mAckMcastList.clear();
        }
    }

    public void clearFetchRunnable() {
        this.mFetchRunnables.clear();
    }

    public void clearReliableCastList() {
        LogUtils.d(TAG, "clearReliableCastList delete List");
        synchronized (this.mReliableMcastList) {
            this.mReliableMcastList.clear();
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
        } catch (JSONException e2) {
            LogUtils.e(TAG, "Exception ", e2);
        }
        if (jSONArray.length() <= 0) {
            return;
        }
        this.mReliableMsgCount += arrayList2.size();
        LogUtils.d(TAG, "reliableMsgCount :" + this.mReliableMsgCount + ", DeliverCastReliableMsg :" + arrayList2.toString());
        MessageExt.getInstance().setLastCallbackMsgId((Long) Collections.max(arrayList2));
        ChatMsgManagerImpl.getInstance(mContext).deliverReliableMcastMessage(j + "", jSONArray, arrayList2);
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
                a.e(mContext).d(mContext, createMcastMethodIntent);
                return;
            } catch (Exception e2) {
                ListenerManager.getInstance().removeListener(addListener);
                onQuitCastResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, j);
                LogUtils.e(TAG, "Exception ", e2);
                return;
            }
        }
        onQuitCastResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, j);
    }

    public String getAllCastIdList() {
        StringBuilder sb = new StringBuilder();
        sb.append("begin:");
        sb.append(this.mBeginMsgCastId);
        sb.append(",");
        sb.append(this.mBeginReliableCastId);
        sb.append(",joined:");
        sb.append(this.mJoinMsgCastId);
        sb.append(",");
        sb.append(this.mJoinReliableCastId);
        sb.append(",JoinStatus:");
        sb.append(this.mJoinStatus);
        sb.append(",reliableJoinStatus:");
        sb.append(this.mRelieableJoinStatus);
        sb.append(",reliableMaxMsgId:");
        sb.append(Utility.getReliableMaxMsgId(mContext, this.mJoinReliableCastId));
        sb.append(",imLoginStatus:");
        sb.append(LoginManager.getInstance(mContext).isIMLogined());
        sb.append(",lcpStatus:");
        sb.append(getConnectState());
        LogUtils.d(TAG, "getAllCastIdList:" + sb.toString());
        return sb.toString();
    }

    public boolean getConnectState() {
        if (a.f65246e) {
            return d.b.r.a.b.a.b() == 0;
        }
        return IMConnection.getInstance(mContext).isConnected();
    }

    public BIMConversation getConversation(BIMManager.CATEGORY category, String str, boolean z, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            LogUtils.e(TAG, "id should not be empty");
            return null;
        }
        synchronized (syncObject) {
            try {
                try {
                    long longValue = Long.valueOf(str).longValue();
                    int value = category.getValue();
                    if (BIMManager.CATEGORY.STUDIO == category) {
                        return new BIMConversationStudio(mContext, category, str, z, new ChatSession(value, longValue, longValue, null), str2, i);
                    }
                    return null;
                } catch (Exception e2) {
                    LogUtils.e(TAG, "Id is not long value", e2);
                    new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
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

    public void handleMessage(JSONObject jSONObject) {
        boolean z = a.f65246e;
        JSONArray jSONArray = new JSONArray();
        try {
            long optLong = jSONObject.optLong("mcast_id");
            boolean isReliable = isReliable(optLong);
            JSONArray jSONArray2 = jSONObject.getJSONArray(NotificationCompat.CarExtender.KEY_MESSAGES);
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
                ChatMsgManagerImpl chatMsgManagerImpl = ChatMsgManagerImpl.getInstance(mContext);
                chatMsgManagerImpl.deliverMcastMessage(optLong + "", jSONArray);
                if (isAck(optLong)) {
                    LogUtils.d(TAG, "toAck");
                    toAck(jSONArray);
                }
            }
        } catch (JSONException unused) {
            LogUtils.e(TAG, "McastmanagerImpl handleMessage parse json error");
        }
    }

    public boolean isAck(long j) {
        if (j <= 0) {
            return false;
        }
        return this.mAckMcastList.contains(Long.valueOf(j));
    }

    public boolean isReliable(long j) {
        if (j <= 0) {
            return false;
        }
        return this.mReliableMcastList.contains(Long.valueOf(j));
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
            } else if (isReliable(j)) {
                this.mJoinReliableCastId = -1000L;
                this.mRelieableJoinStatus = i;
            } else {
                this.mJoinMsgCastId = -1000L;
                this.mJoinStatus = i;
            }
            str3 = "join callback ok";
        } else {
            LogUtils.d(TAG, "IMcastSetistener is null");
            str3 = "join callback fail";
        }
        IMTrack.RequestBuilder requestBuilder = new IMTrack.RequestBuilder(mContext);
        requestBuilder.requestId("" + j).requestTime(System.currentTimeMillis()).ext(str3).errorCode(i).aliasId(501113L).build();
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

    public void onSendQuizOptsResult(String str, int i, String str2, long j, long j2) {
        LogUtils.d(TAG, "sendQuizOpts----errorCode: " + i + " msg: " + str2);
        IMcastSetListener iMcastSetListener = (IMcastSetListener) ListenerManager.getInstance().removeListener(str);
        if (iMcastSetListener != null) {
            iMcastSetListener.onResult(i, j, j2);
        } else {
            LogUtils.d(TAG, "IMcastSetistener is null");
        }
    }

    public void pingRequest(boolean z, long j) {
        if (z) {
            a.f65244c.removeCallbacks(mPingRunnable);
            a.f65244c.postDelayed(mPingRunnable, j);
        } else {
            a.f65244c.removeCallbacks(mPingRunnable);
        }
        LogUtils.d(TAG, "pingRequest show :" + z + ", customPingIntervalMs :" + j);
    }

    public void removeAckCastId(long j) {
        if (j <= 0) {
            return;
        }
        synchronized (this.mAckMcastList) {
            this.mAckMcastList.remove(Long.valueOf(j));
        }
    }

    public void removeFetchCastId(long j) {
        if (j <= 0) {
            return;
        }
        this.mFetchRunnables.remove(Long.valueOf(j));
    }

    public void removeReliableCastId(long j) {
        if (j <= 0) {
            return;
        }
        synchronized (this.mReliableMcastList) {
            this.mReliableMcastList.remove(Long.valueOf(j));
        }
    }

    public void sendQuizOpts(long j, long j2, int i, String str, IMcastSetListener iMcastSetListener) {
        String addListener = ListenerManager.getInstance().addListener(iMcastSetListener);
        if (AccountManager.isLogin(mContext)) {
            Intent createMcastMethodIntent = Utility.createMcastMethodIntent(mContext, Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST);
            createMcastMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            createMcastMethodIntent.putExtra("mcast_id", j2);
            createMcastMethodIntent.putExtra("room_id", j);
            createMcastMethodIntent.putExtra(Constants.EXTRA_OPT_CODE, i);
            createMcastMethodIntent.putExtra(Constants.EXTRA_OPT_EXT, str);
            try {
                a.e(mContext).d(mContext, createMcastMethodIntent);
                return;
            } catch (Exception e2) {
                ListenerManager.getInstance().removeListener(addListener);
                onSendQuizOptsResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, j2, j);
                LogUtils.e(TAG, "Exception ", e2);
                return;
            }
        }
        onSendQuizOptsResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, j2, j);
    }

    public void setMcastQuickHeartBeat() {
        if (a.f65246e && !mOpenPingRequest.get()) {
            mOpenPingRequest.set(true);
            pingRequest(true, mCastHeartBeatTime);
            return;
        }
        mCastHeartBeatTime = mRandom.nextInt(3000) + 3000;
        LogUtils.d(TAG, "mcast now quick heart beat = " + mCastHeartBeatTime);
        if (mcastHeartbeat == null) {
            McastHeartbeat mcastHeartbeat2 = new McastHeartbeat();
            mcastHeartbeat = mcastHeartbeat2;
            mcastHeartbeat2.startHeartbeat();
        }
    }
}
