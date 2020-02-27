package com.baidu.android.imsdk.mcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.util.LongSparseArray;
import com.baidu.android.imsdk.IMReceiver;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.TodoAfterLogin;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.Heartbeat;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageFactory;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.imsdk.IMService;
import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class McastManagerImpl {
    private static final int FIRST_RETRY = 0;
    private static final long FIRST_RETRY_TIME = 1000;
    private static final int MAX_RETRY_NUM = 3;
    private static final int PULL_COUNT = 160;
    private static final long SECOND_RETRY_TIME = 5000;
    private static final long THIRD_RETRY_TIME = 10000;
    private static Context mContext;
    private static volatile McastManagerImpl mInstance;
    private static BroadcastReceiver mNetChangedReceiver;
    private static Random mRandom;
    private static McastHeartbeat mcastHeartbeat;
    private long mCastId;
    private boolean mIsPull;
    private static final String TAG = McastManagerImpl.class.getSimpleName();
    public static int mCastHeartBeatTime = 3000;
    private boolean isRegisterNetReceiver = false;
    private int mFetchNum = 0;
    private LongSparseArray<Boolean> mReliableCastList = new LongSparseArray<>();
    private long mMinMsgId = 0;
    private long mMaxMsgId = 0;
    private IFetchMsgByIdListener mFetchMsgListener = new IFetchMsgByIdListener() { // from class: com.baidu.android.imsdk.mcast.McastManagerImpl.1
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            boolean booleanValue = McastManagerImpl.this.isReliable(McastManagerImpl.this.mCastId).booleanValue();
            LogUtils.d(McastManagerImpl.TAG, "onFetchMsgByIdResult response :" + i + ", maxMsgid :" + j4 + ", fetch :" + arrayList.size() + ", real :" + i4 + ", count :" + i3 + "，  mcastId = " + McastManagerImpl.this.mCastId + "，isReliable" + booleanValue);
            if (booleanValue) {
                if (i != 0) {
                    if (McastManagerImpl.this.mFetchNum == 0) {
                        LogUtils.e(McastManagerImpl.TAG, "onFetchMsgByIdResult：fetch msg failed and first retry.");
                        IMService.mHandler.postDelayed(McastManagerImpl.this.mReliableRunnable, 1000L);
                    }
                } else if (i4 >= i3) {
                    McastManagerImpl.this.fetchCastMsgByMsgId();
                }
            }
        }
    };
    private Runnable mReliableRunnable = new Runnable() { // from class: com.baidu.android.imsdk.mcast.McastManagerImpl.2
        @Override // java.lang.Runnable
        public void run() {
            McastManagerImpl.access$308(McastManagerImpl.this);
            if (McastManagerImpl.this.mFetchNum <= 3) {
                McastManagerImpl.this.fetchCastMsgByMsgId();
                IMService.mHandler.removeCallbacks(this);
                IMService.mHandler.postDelayed(this, McastManagerImpl.this.mFetchNum != 3 ? 5000L : McastManagerImpl.THIRD_RETRY_TIME);
                return;
            }
            McastManagerImpl.this.mFetchNum = 0;
            IMService.mHandler.removeCallbacks(this);
        }
    };

    /* loaded from: classes3.dex */
    interface HeartbeatOperation {
        void cancelHearbeat();

        void startHeartbeat();
    }

    static /* synthetic */ int access$308(McastManagerImpl mcastManagerImpl) {
        int i = mcastManagerImpl.mFetchNum;
        mcastManagerImpl.mFetchNum = i + 1;
        return i;
    }

    private McastManagerImpl() {
        McastConfig.mLiveShowing = false;
        mRandom = new Random();
        Class<?>[] clsArr = {IMJoinCastMsg.class, IMQuitCastMsg.class, IMSendQuizOptMsg.class};
        int[] iArr = {201, 202, Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST};
        for (int i = 0; i < clsArr.length; i++) {
            MessageFactory.getInstance().addType(iArr[i], clsArr[i]);
        }
        AccountManager.registerToDoAfterLoginListener(mContext, new McastTodoAfterLogin());
    }

    public static McastManagerImpl getInstance(Context context) {
        if (mInstance == null) {
            synchronized (McastManagerImpl.class) {
                if (mInstance == null) {
                    mContext = context.getApplicationContext();
                    mInstance = new McastManagerImpl();
                }
            }
        }
        return mInstance;
    }

    public void setCastIdReliable(long j, boolean z) {
        if (this.mReliableCastList != null) {
            this.mReliableCastList.put(j, Boolean.valueOf(z));
        }
    }

    public Boolean isReliable(long j) {
        if (this.mReliableCastList == null || this.mReliableCastList.indexOfKey(j) == -1) {
            return false;
        }
        return Boolean.valueOf(this.mReliableCastList.get(j) != null ? this.mReliableCastList.get(j).booleanValue() : false);
    }

    public void clearReliableCastList() {
        if (this.mReliableCastList != null) {
            this.mReliableCastList.clear();
            this.mReliableCastList = null;
        }
    }

    public void beginWithCompletion(long j, IMcastSetListener iMcastSetListener) {
        this.mCastId = j;
        String addListener = ListenerManager.getInstance().addListener(iMcastSetListener);
        if (AccountManager.isLogin(mContext)) {
            Intent createMcastMethodIntent = Utility.createMcastMethodIntent(mContext, 201);
            createMcastMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            createMcastMethodIntent.putExtra("mcast_id", j);
            try {
                mContext.startService(createMcastMethodIntent);
                return;
            } catch (Exception e) {
                ListenerManager.getInstance().removeListener(addListener);
                LogUtils.e(TAG, "Exception ", e);
                return;
            }
        }
        onJoinCastResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, j);
    }

    public void onJoinCastResult(String str, int i, String str2, long j) {
        IMcastSetListener iMcastSetListener = (IMcastSetListener) ListenerManager.getInstance().removeListener(str);
        LogUtils.d(TAG, "onJoinCastResult----errorCode: " + i + " msg: " + str2 + ", castId :" + j + ", listener :" + iMcastSetListener);
        if (iMcastSetListener != null) {
            iMcastSetListener.onResult(i, j, -1L);
            if (i == 0) {
                if (isReliable(this.mCastId).booleanValue()) {
                    this.mIsPull = true;
                    fetchCastMsgByMsgId();
                }
                registerNetChangedReceiver();
                setMcastQuickHeartBeat();
                return;
            }
            return;
        }
        LogUtils.d(TAG, "IMcastSetistener is null");
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
        if (AccountManager.isLogin(mContext)) {
            Intent createMcastMethodIntent = Utility.createMcastMethodIntent(mContext, 202);
            createMcastMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            createMcastMethodIntent.putExtra("mcast_id", j);
            try {
                mContext.startService(createMcastMethodIntent);
                return;
            } catch (Exception e) {
                ListenerManager.getInstance().removeListener(addListener);
                LogUtils.e(TAG, "Exception ", e);
                return;
            }
        }
        onQuitCastResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, j);
    }

    public void handleMessage(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        try {
            long optLong = jSONObject.optLong("mcast_id");
            boolean booleanValue = isReliable(optLong).booleanValue();
            JSONArray jSONArray2 = jSONObject.getJSONArray("messages");
            if (booleanValue && jSONArray2.length() > 0) {
                this.mMinMsgId = ((Long) jSONArray2.getJSONObject(0).get("msgid")).longValue();
                this.mMaxMsgId = this.mMinMsgId;
            }
            for (int i = 0; i < jSONArray2.length(); i++) {
                JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                if (jSONObject2.optLong("origin_id") != Utility.getTriggerId(mContext)) {
                    jSONArray.put(jSONObject2);
                } else {
                    LogUtils.d(TAG, "filter self message");
                }
                if (booleanValue) {
                    long longValue = ((Long) jSONObject2.get("msgid")).longValue();
                    if (this.mMinMsgId > longValue) {
                        this.mMinMsgId = longValue;
                    }
                    if (this.mMaxMsgId < longValue) {
                        this.mMaxMsgId = longValue;
                    }
                }
            }
            if (booleanValue) {
                this.mIsPull = false;
                LogUtils.d(TAG, "handleMessage push reliable castId :" + optLong + ", min :" + this.mMinMsgId + ", max :" + this.mMaxMsgId);
                fetchCastMsgByMsgId();
            } else if (jSONArray.length() != 0) {
                ChatMsgManagerImpl.getInstance(mContext).deliverMcastMessage(optLong + "", jSONArray);
            }
        } catch (JSONException e) {
            LogUtils.e(TAG, "McastmanagerImpl handleMessage parse json error");
            LogUtils.e(TAG, "Exception ", e);
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
            LogUtils.d(TAG, "DeliverCastReliableMsg :" + jSONArray.toString());
            ChatMsgManagerImpl.getInstance(mContext).deliverReliableMcastMessage(j + "", jSONArray, arrayList2);
        }
    }

    private void fetchCastMsg(long j, long j2) {
        ChatMsgManagerImpl.getInstance(mContext).fetchMsgidByMsgid(mContext, 4, this.mCastId, j, j2, 160, 2, 0, this.mFetchMsgListener, this.mFetchNum);
        if (j == 0) {
            new IMTrack.RequestBuilder(mContext).requestId("" + this.mCastId).requestTime(System.currentTimeMillis()).ext("request endmsgid :" + j2).aliasId(501102L).build();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchCastMsgByMsgId() {
        if (McastConfig.mLiveShowing) {
            long maxReliableMsgId = ChatMsgManagerImpl.getInstance(mContext).getMaxReliableMsgId(this.mCastId);
            if (this.mIsPull) {
                fetchCastMsg(maxReliableMsgId > 0 ? maxReliableMsgId : 0L, Format.OFFSET_SAMPLE_RELATIVE);
            } else if (maxReliableMsgId <= 0) {
                fetchCastMsg(0L, this.mMaxMsgId);
            } else if (maxReliableMsgId < this.mMaxMsgId) {
                fetchCastMsg(maxReliableMsgId, this.mMaxMsgId);
            }
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
                mContext.startService(createMcastMethodIntent);
                return;
            } catch (Exception e) {
                ListenerManager.getInstance().removeListener(addListener);
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

    private void registerNetChangedReceiver() {
        if (!IMService.isSmallFlow) {
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
        if (!IMService.isSmallFlow) {
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

    public static void resetHeartBeat(int i) {
        if (!IMService.isSmallFlow) {
            Heartbeat.ALARM_TIMEOUT = i;
            LogUtils.d(TAG, "reset heartbeat time to = " + Heartbeat.ALARM_TIMEOUT);
            IMSDK.getInstance(mContext).mHeartbeatOperator.cancelHearbeat();
            IMSDK.getInstance(mContext).mHeartbeatOperator.startHeartbeat();
        }
    }

    public void setMcastQuickHeartBeat() {
        if (!IMService.isSmallFlow && McastConfig.mLiveShowing) {
            if (mcastHeartbeat == null) {
                mcastHeartbeat = new McastHeartbeat();
            }
            mCastHeartBeatTime = mRandom.nextInt(3000) + 3000;
            LogUtils.d(TAG, "mcast now quick heart beat = " + mCastHeartBeatTime);
            mcastHeartbeat.cancelHearbeat();
            mcastHeartbeat.startHeartbeat();
        }
    }

    public void cancelMcastQuickHeartBeat() {
        if (!IMService.isSmallFlow) {
            McastConfig.mLiveShowing = false;
            if (mcastHeartbeat != null) {
                mcastHeartbeat.cancelHearbeat();
                mcastHeartbeat = null;
                LogUtils.d(TAG, "mcast quick heart beat canceled! ");
            }
            resetHeartBeat(60000);
        }
    }

    /* loaded from: classes3.dex */
    public class McastHeartbeat implements HeartbeatOperation {
        private Runnable startHeartBeatTask = new Runnable() { // from class: com.baidu.android.imsdk.mcast.McastManagerImpl.McastHeartbeat.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!IMService.isSmallFlow) {
                        Intent intent = new Intent(McastManagerImpl.mContext, IMService.class);
                        intent.putExtra(Constants.EXTRA_ALARM_ALERT, "OK");
                        intent.setPackage(McastManagerImpl.mContext.getPackageName());
                        McastManagerImpl.mContext.startService(intent);
                        IMService.mHandler.postDelayed(McastHeartbeat.this.startHeartBeatTask, McastManagerImpl.mCastHeartBeatTime);
                    }
                } catch (Exception e) {
                    if (e instanceof SecurityException) {
                        LogUtils.e(McastManagerImpl.TAG, "box SecurityException!!", e);
                    } else {
                        LogUtils.e(McastManagerImpl.TAG, "box heartbeat error!!", e);
                    }
                }
            }
        };

        public McastHeartbeat() {
        }

        @Override // com.baidu.android.imsdk.mcast.McastManagerImpl.HeartbeatOperation
        public void startHeartbeat() {
            try {
                IMService.mHandler.removeCallbacks(this.startHeartBeatTask);
                IMService.mHandler.postDelayed(this.startHeartBeatTask, McastManagerImpl.mCastHeartBeatTime);
            } catch (Exception e) {
                LogUtils.e(McastManagerImpl.TAG, e.getMessage());
            }
        }

        @Override // com.baidu.android.imsdk.mcast.McastManagerImpl.HeartbeatOperation
        public void cancelHearbeat() {
            try {
                IMService.mHandler.removeCallbacks(this.startHeartBeatTask);
            } catch (Exception e) {
                LogUtils.e(McastManagerImpl.TAG, e.getMessage());
            }
        }
    }

    /* loaded from: classes3.dex */
    class McastTodoAfterLogin implements TodoAfterLogin {
        McastTodoAfterLogin() {
        }

        @Override // com.baidu.android.imsdk.account.TodoAfterLogin
        public void todo(boolean z) {
            ChatMessageDBManager.getInstance(McastManagerImpl.mContext).deleteExpiredReliableMsgs();
        }
    }
}
