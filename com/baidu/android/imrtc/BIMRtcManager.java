package com.baidu.android.imrtc;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.imrtc.msg.BIMRtcListener;
import com.baidu.android.imrtc.msg.BIMRtcNotifyMsg;
import com.baidu.android.imrtc.msg.BIMRtcSendMsg;
import com.baidu.android.imrtc.notify.BIMInviteSyncRtcInfo;
import com.baidu.android.imrtc.notify.BIMSyncRtcInfo;
import com.baidu.android.imrtc.request.BIMRtcCreateRoomRequest;
import com.baidu.android.imrtc.request.BIMRtcGetTokenRequest;
import com.baidu.android.imrtc.request.BIMRtcTokenListener;
import com.baidu.android.imrtc.request.HttpExecutor;
import com.baidu.android.imrtc.send.BIMAckRtcInfo;
import com.baidu.android.imrtc.send.BIMAnswerRtcInfo;
import com.baidu.android.imrtc.send.BIMCancelRtcInfo;
import com.baidu.android.imrtc.send.BIMCloseRoomRtcInfo;
import com.baidu.android.imrtc.send.BIMInviteRtcInfo;
import com.baidu.android.imrtc.utils.BIMRtcEvent;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imrtc.utils.Utility;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageFactory;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.imsdk.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class BIMRtcManager {
    private static final String TAG = "BIMRtcManager";
    private static Context mContext;
    private static volatile BIMRtcManager mInstance;
    private Runnable heartBeatRunnable = new Runnable() { // from class: com.baidu.android.imrtc.BIMRtcManager.2
        @Override // java.lang.Runnable
        public void run() {
            if (RtcConstants.IM_RTC_SDK_SEQ_ID.get() > 0) {
                BIMRtcManager.this.heartBeat(new IStatusListener() { // from class: com.baidu.android.imrtc.BIMRtcManager.2.1
                    @Override // com.baidu.android.imrtc.utils.IStatusListener
                    public void onResult(int i, String str) {
                        LogUtils.d(BIMRtcManager.TAG, "heartBeat responseCode :" + i + ", msg :" + str);
                    }
                });
            }
        }
    };
    private Handler mRtcHandler;
    public static int BIM_RTC_ACTION_SYNC_SEQID_MAX = 100;
    public static int BIM_RTC_CALL_TIMEOUT_INTERNAL = 35000;
    public static int BIM_RTC_ANSWER_TIMEOUT_INTERNAL = 30000;
    private static List<BIMRtcListener> mRtcListeners = Collections.synchronizedList(new ArrayList());
    private static volatile Map<Long, BIMRtcSendMsg> msgList = new LinkedHashMap();
    private static int mLastAction = 0;
    private static Timer mCallTimeoutTimer = new Timer();
    private static volatile Map<String, Integer> mActionSyncSeqIdMap = new ConcurrentHashMap();
    private static volatile AtomicInteger RTC_HEART_BEAT_FAILED_COUNT = new AtomicInteger(0);
    private static volatile BIMRtcEvent mBIMRtcEvent = new BIMRtcEvent();

    public static BIMRtcManager getInstance(@NonNull Context context) {
        if (mInstance == null) {
            synchronized (BIMRtcManager.class) {
                if (mInstance == null) {
                    mInstance = new BIMRtcManager(context);
                }
            }
        }
        return mInstance;
    }

    private BIMRtcManager(Context context) {
        mContext = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("RTC_HANDLER");
        handlerThread.start();
        this.mRtcHandler = new Handler(handlerThread.getLooper());
        mActionSyncSeqIdMap.clear();
        Class<?>[] clsArr = {BIMRtcSendMsg.class};
        int[] iArr = {RtcConstants.METHOD_IM_RTC_MSG};
        for (int i = 0; i < clsArr.length; i++) {
            MessageFactory.getInstance().addType(iArr[i], clsArr[i]);
        }
        Utility.setIMUK(context, com.baidu.android.imsdk.utils.Utility.getUK(mContext));
        Utility.setCuid(context, com.baidu.android.imsdk.utils.Utility.getDeviceId(mContext));
        Utility.setAppId(context, AccountManager.getAppid(mContext));
        Utility.setBduid(context, AccountManager.getUid(mContext));
    }

    public void createRoom(String str, @NonNull BIMRtcTokenListener bIMRtcTokenListener) {
        BIMRtcCreateRoomRequest bIMRtcCreateRoomRequest = new BIMRtcCreateRoomRequest(mContext, str, bIMRtcTokenListener);
        HttpExecutor.requestExecute(bIMRtcCreateRoomRequest, bIMRtcCreateRoomRequest);
    }

    public void generateToken(String str, String str2, long j, @NonNull BIMRtcTokenListener bIMRtcTokenListener) {
        BIMRtcGetTokenRequest bIMRtcGetTokenRequest = new BIMRtcGetTokenRequest(mContext, str, str2, j, bIMRtcTokenListener);
        HttpExecutor.requestExecute(bIMRtcGetTokenRequest, bIMRtcGetTokenRequest);
    }

    public void join(String str, IStatusListener iStatusListener) {
        rtcSendEvent(new BIMRtcInfo(str), 92, iStatusListener);
    }

    public void cancelCall(@NonNull BIMCancelRtcInfo bIMCancelRtcInfo, IStatusListener iStatusListener) {
        rtcSendEvent(bIMCancelRtcInfo, 94, iStatusListener);
    }

    public void invite(@NonNull final BIMInviteRtcInfo bIMInviteRtcInfo, IStatusListener iStatusListener) {
        if (mCallTimeoutTimer != null) {
            mCallTimeoutTimer.cancel();
            mCallTimeoutTimer = null;
        }
        mCallTimeoutTimer = new Timer();
        try {
            mCallTimeoutTimer.schedule(new TimerTask() { // from class: com.baidu.android.imrtc.BIMRtcManager.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Timer unused = BIMRtcManager.mCallTimeoutTimer = null;
                    for (BIMRtcListener bIMRtcListener : BIMRtcManager.mRtcListeners) {
                        if (bIMRtcListener != null) {
                            bIMRtcListener.roomCallerInviteTimeoutByCallee(bIMInviteRtcInfo);
                        }
                    }
                }
            }, BIM_RTC_CALL_TIMEOUT_INTERNAL);
        } catch (Exception e) {
            LogUtils.e(TAG, "invite timer exception", e);
        }
        rtcSendEvent(bIMInviteRtcInfo, 80, iStatusListener);
    }

    public void ring(String str, IStatusListener iStatusListener) {
        rtcSendEvent(new BIMRtcInfo(str), 82, iStatusListener);
    }

    public void answer(@NonNull BIMAnswerRtcInfo bIMAnswerRtcInfo, IStatusListener iStatusListener) {
        rtcSendEvent(bIMAnswerRtcInfo, 84, iStatusListener);
    }

    public void hangout(String str, IStatusListener iStatusListener) {
        rtcSendEvent(new BIMRtcInfo(str), 86, iStatusListener);
    }

    public void hangout(BIMRtcInfo bIMRtcInfo, IStatusListener iStatusListener) {
        rtcSendEvent(bIMRtcInfo, 86, iStatusListener);
    }

    public void closeRoom(@NonNull BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo, IStatusListener iStatusListener) {
        rtcSendEvent(bIMCloseRoomRtcInfo, 88, iStatusListener);
    }

    public void fetchRtcRoomState(String str, IStatusListener iStatusListener) {
        rtcSendEvent(new BIMRtcInfo(str), 90, iStatusListener);
    }

    public void fetchRtcRoomSignaling(String str, IStatusListener iStatusListener) {
        rtcSendEvent(new BIMRtcInfo(str), 91, iStatusListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void heartBeat(IStatusListener iStatusListener) {
        rtcSendEvent(new BIMRtcInfo(), 100, iStatusListener);
    }

    private void rtcSendEvent(@NonNull BIMRtcInfo bIMRtcInfo, int i, IStatusListener iStatusListener) {
        LogUtils.d(TAG, "rtcSendEvent action :" + i + ", last :" + mLastAction);
        bIMRtcInfo.setAction(i);
        bIMRtcInfo.setRtcDeviceId(Utility.getCuid(mContext));
        if (i != 100 && i != 102) {
            mBIMRtcEvent.requestAction = i;
            mBIMRtcEvent.requestRoomId = bIMRtcInfo.getRtcRoomId();
        }
        if (mLastAction != 0 && mLastAction != 90 && mLastAction != 91 && mLastAction != 92 && mLastAction != 94 && mLastAction != 100 && mLastAction != 102 && i < mLastAction) {
            if (iStatusListener != null) {
                iStatusListener.onResult(-2, "action order error");
                return;
            }
            return;
        }
        mLastAction = i;
        if (TextUtils.isEmpty(bIMRtcInfo.getRtcRoomId())) {
            bIMRtcInfo.setRtcRoomId(Utility.getRtcRoomId(mContext));
        }
        try {
            String addListener = ListenerManager.getInstance().addListener(iStatusListener);
            Intent creatMethodIntent = com.baidu.android.imsdk.utils.Utility.creatMethodIntent(mContext, RtcConstants.METHOD_IM_RTC_MSG);
            creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            creatMethodIntent.putExtra(RtcConstants.EXTRA_RTC_INFO, bIMRtcInfo.toRtcInfoString());
            creatMethodIntent.putExtra(RtcConstants.EXTRA_RTC_ACTION_ID, i);
            creatMethodIntent.putExtra(RtcConstants.EXTRA_RTC_ROOM_ID, bIMRtcInfo.getRtcRoomId());
            a.ao(mContext).e(mContext, creatMethodIntent);
            mBIMRtcEvent.sdkAction = i;
            mBIMRtcEvent.sdkSeqId = RtcConstants.IM_RTC_SDK_SEQ_ID.get();
            mBIMRtcEvent.sdkRoomId = Utility.getRtcRoomId(mContext);
        } catch (Exception e) {
            if (iStatusListener != null) {
                iStatusListener.onResult(-1, "rtcSendEvent exception");
            }
        }
    }

    public void onRtcRequestResult(int i, BIMRtcInfo bIMRtcInfo, int i2, String str, String str2) {
        IMListener removeListener = ListenerManager.getInstance().removeListener(str2);
        if (removeListener instanceof IStatusListener) {
            ((IStatusListener) removeListener).onResult(i2, str);
        }
        handleRtcResult(i, bIMRtcInfo, i2);
        mBIMRtcEvent.sdkAction = i;
        mBIMRtcEvent.sdkSeqId = RtcConstants.IM_RTC_SDK_SEQ_ID.get();
        mBIMRtcEvent.sdkRoomId = Utility.getRtcRoomId(mContext);
    }

    private void handleRtcResult(int i, BIMRtcInfo bIMRtcInfo, int i2) {
        if (i == 100) {
            checkServerSeqId(bIMRtcInfo);
            this.mRtcHandler.removeCallbacks(this.heartBeatRunnable);
            if (i2 == 0) {
                RTC_HEART_BEAT_FAILED_COUNT.set(0);
            } else {
                RTC_HEART_BEAT_FAILED_COUNT.getAndIncrement();
            }
            if (RtcConstants.RTC_HEART_BEAT_STATUS == 1 && RTC_HEART_BEAT_FAILED_COUNT.get() < RtcConstants.RTC_HEART_BEAT_RETRY_TIME) {
                this.mRtcHandler.postDelayed(this.heartBeatRunnable, RtcConstants.RTC_HEART_BEAT_TIME);
            }
        } else if (i2 == 0) {
            switch (i) {
                case 84:
                    if (((BIMAnswerRtcInfo) bIMRtcInfo).getAnswerType() != 1) {
                        RtcConstants.IM_RTC_SDK_SEQ_ID.set(-1L);
                        mLastAction = 0;
                        break;
                    } else {
                        this.mRtcHandler.removeCallbacks(this.heartBeatRunnable);
                        this.mRtcHandler.postDelayed(this.heartBeatRunnable, RtcConstants.RTC_HEART_BEAT_TIME);
                        break;
                    }
                case 86:
                case 88:
                case 94:
                    RtcConstants.IM_RTC_SDK_SEQ_ID.set(-1L);
                    mLastAction = 0;
                    mActionSyncSeqIdMap.clear();
                    this.mRtcHandler.removeCallbacks(this.heartBeatRunnable);
                    break;
                case 92:
                    this.mRtcHandler.removeCallbacks(this.heartBeatRunnable);
                    this.mRtcHandler.postDelayed(this.heartBeatRunnable, RtcConstants.RTC_HEART_BEAT_TIME);
                    break;
            }
            notifyRtcActionAndInfo(i, bIMRtcInfo);
        } else {
            mLastAction = 0;
        }
    }

    public static void notifyParse(@NonNull JSONObject jSONObject) {
        BIMRtcInfo parseJson = BIMRtcNotifyMsg.parseJson(mContext, jSONObject);
        if (parseJson == null) {
            LogUtils.i(TAG, "notifyParse info == null ");
            mBIMRtcEvent.serverAction = -2;
            mBIMRtcEvent.serverSedId = -2L;
            mBIMRtcEvent.serverRoomId = "-2";
            return;
        }
        checkServerSeqId(parseJson);
        getInstance(mContext).ackEvent(parseJson);
        mBIMRtcEvent.serverAction = parseJson.getAction();
        mBIMRtcEvent.serverSedId = RtcConstants.IM_RTC_SERVER_SEQ_ID;
        mBIMRtcEvent.serverRoomId = parseJson.getRtcRoomId();
        String str = parseJson.getRtcRoomId() + parseJson.getSeq();
        String str2 = "mActionSyncSeqIdMap.size :" + mActionSyncSeqIdMap.size() + ", key :" + str + ", value :" + parseJson.getAction();
        if (mActionSyncSeqIdMap.containsKey(str)) {
            LogUtils.d(TAG, "contain, " + str2);
            mBIMRtcEvent.notifyAction = -2;
            mBIMRtcEvent.notifySeqId = -2L;
            return;
        }
        notifyRtcActionAndInfo(parseJson.getAction(), parseJson);
        try {
            if (mActionSyncSeqIdMap.size() < BIM_RTC_ACTION_SYNC_SEQID_MAX) {
                mActionSyncSeqIdMap.put(str, Integer.valueOf(parseJson.getAction()));
                LogUtils.d(TAG, "<100 put, " + str2);
                return;
            }
            Iterator<Map.Entry<String, Integer>> it = mActionSyncSeqIdMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Integer> next = it.next();
                if (next.getValue().intValue() == parseJson.getAction() && mActionSyncSeqIdMap.containsKey(next.getKey())) {
                    mActionSyncSeqIdMap.remove(next.getKey());
                    break;
                }
            }
            mActionSyncSeqIdMap.put(str, Integer.valueOf(parseJson.getAction()));
            LogUtils.d(TAG, ">100 put, " + str2);
        } catch (Exception e) {
            LogUtils.e(TAG, "mActionSyncSeqIdMap exception ", e);
            mBIMRtcEvent.notifyAction = -3;
            mBIMRtcEvent.notifySeqId = -3L;
        }
    }

    private void ackEvent(BIMRtcInfo bIMRtcInfo) {
        LogUtils.i(TAG, "ackEvent ");
        BIMAckRtcInfo bIMAckRtcInfo = new BIMAckRtcInfo();
        bIMAckRtcInfo.setAckSeqId(bIMRtcInfo.getSeq());
        bIMAckRtcInfo.setSyncAction(bIMRtcInfo.getAction());
        bIMAckRtcInfo.setImUK(com.baidu.android.imsdk.utils.Utility.getUK(mContext));
        rtcSendEvent(bIMAckRtcInfo, 102, null);
    }

    private static boolean isOthers(BIMRtcInfo bIMRtcInfo) {
        long initiatorUk;
        long uk = com.baidu.android.imsdk.utils.Utility.getUK(mContext);
        if (bIMRtcInfo instanceof BIMInviteSyncRtcInfo) {
            initiatorUk = ((BIMInviteSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
        } else if (!(bIMRtcInfo instanceof BIMSyncRtcInfo)) {
            return false;
        } else {
            initiatorUk = ((BIMSyncRtcInfo) bIMRtcInfo).getInitiatorUk();
        }
        return uk != initiatorUk;
    }

    private static void checkServerSeqId(BIMRtcInfo bIMRtcInfo) {
        RtcConstants.IM_RTC_SERVER_SEQ_ID = bIMRtcInfo.getSeq();
    }

    public void registerRtcListener(@NonNull BIMRtcListener bIMRtcListener) {
        if (!mRtcListeners.contains(bIMRtcListener)) {
            mRtcListeners.add(bIMRtcListener);
        }
    }

    public void unRegisterRtcListener(@NonNull BIMRtcListener bIMRtcListener) {
        mRtcListeners.remove(bIMRtcListener);
    }

    private static void notifyRtcActionAndInfo(int i, BIMRtcInfo bIMRtcInfo) {
        for (BIMRtcListener bIMRtcListener : mRtcListeners) {
            if (bIMRtcListener != null) {
                bIMRtcListener.onRtcResult(i, bIMRtcInfo);
                notifyEvent(bIMRtcInfo, bIMRtcListener);
                if (isOthers(bIMRtcInfo)) {
                    mBIMRtcEvent.notifyAction = i;
                    mBIMRtcEvent.notifySeqId = RtcConstants.IM_RTC_SERVER_SEQ_ID;
                    mBIMRtcEvent.notifyRoomId = bIMRtcInfo.getRtcRoomId();
                }
            }
        }
    }

    private static void notifyEvent(@NonNull BIMRtcInfo bIMRtcInfo, @NonNull BIMRtcListener bIMRtcListener) {
        switch (bIMRtcInfo.getAction()) {
            case 81:
                if (isOthers(bIMRtcInfo)) {
                    bIMRtcListener.roomCalleeInviteFromCaller(bIMRtcInfo);
                    getInstance(mContext).ring(bIMRtcInfo.getRtcRoomId(), new IStatusListener() { // from class: com.baidu.android.imrtc.BIMRtcManager.3
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i, String str) {
                            LogUtils.d(BIMRtcManager.TAG, "rtcRing responseCode :" + i + ", msg :" + str);
                        }
                    });
                    return;
                }
                return;
            case 82:
            case 84:
            case 86:
            case 88:
            case 89:
            case 92:
            case 94:
            default:
                return;
            case 83:
                if (isOthers(bIMRtcInfo)) {
                    bIMRtcListener.roomEventSyncByOthers(RtcConstants.RoomEventType.CALLEE_RING, bIMRtcInfo);
                    return;
                }
                return;
            case 85:
                if (mCallTimeoutTimer != null) {
                    mCallTimeoutTimer.cancel();
                    mCallTimeoutTimer = null;
                }
                int answerType = ((BIMSyncRtcInfo) bIMRtcInfo).getAnswerType();
                if (isOthers(bIMRtcInfo)) {
                    bIMRtcListener.roomCallerGetAnswerSyncByCallee(answerType, bIMRtcInfo);
                    return;
                } else if (!TextUtils.isEmpty(bIMRtcInfo.getRtcDeviceId())) {
                    String str = bIMRtcInfo.getRtcDeviceId().split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR)[0];
                    if (answerType == 1 && !Utility.getCuid(mContext).equals(str)) {
                        bIMRtcListener.roomCalleeAnswerByFromOtherCallee(answerType, bIMRtcInfo);
                        return;
                    } else if (answerType == 3 && Utility.getCuid(mContext).equals(str)) {
                        bIMRtcListener.roomCalleeAnswerTimeOutFromMyself(bIMRtcInfo);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 87:
                if (isOthers(bIMRtcInfo)) {
                    bIMRtcListener.roomEventSyncByOthers(RtcConstants.RoomEventType.EXIT_ROOM, bIMRtcInfo);
                    return;
                } else {
                    bIMRtcListener.roomEventByMySelf(RtcConstants.RoomEventType.EXIT_ROOM, bIMRtcInfo);
                    return;
                }
            case 90:
                bIMRtcListener.fetchRoomState(isOthers(bIMRtcInfo), bIMRtcInfo);
                return;
            case 91:
                bIMRtcListener.fetchRoomSignal(isOthers(bIMRtcInfo), bIMRtcInfo);
                return;
            case 93:
                if (isOthers(bIMRtcInfo)) {
                    bIMRtcListener.roomEventSyncByOthers(RtcConstants.RoomEventType.JOIN_ROOM, bIMRtcInfo);
                    return;
                } else {
                    bIMRtcListener.roomEventByMySelf(RtcConstants.RoomEventType.JOIN_ROOM, bIMRtcInfo);
                    return;
                }
            case 95:
                if (mCallTimeoutTimer != null) {
                    mCallTimeoutTimer.cancel();
                    mCallTimeoutTimer = null;
                }
                if (isOthers(bIMRtcInfo)) {
                    bIMRtcListener.roomCalleeInviteCancelFromCaller(bIMRtcInfo);
                    return;
                }
                return;
        }
    }

    public void setRtcDebugEnv(Context context, boolean z) {
        Utility.setRtcDebug(context, z);
    }

    public String report() {
        if (mBIMRtcEvent == null) {
            mBIMRtcEvent = new BIMRtcEvent();
            return "event is null.";
        }
        return mBIMRtcEvent.toString();
    }
}
