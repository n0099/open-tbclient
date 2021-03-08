package com.baidu.android.imrtc;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imrtc.msg.BIMRtcListener;
import com.baidu.android.imrtc.msg.BIMRtcNotifyMsg;
import com.baidu.android.imrtc.msg.BIMRtcSendMsg;
import com.baidu.android.imrtc.notify.BIMInviteSyncRtcInfo;
import com.baidu.android.imrtc.notify.BIMKickReqSyncRtcInfo;
import com.baidu.android.imrtc.notify.BIMKickResSyncRtcInfo;
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
import com.baidu.android.imrtc.send.BIMKickRequestRtcInfo;
import com.baidu.android.imrtc.send.BIMKickResponseRtcInfo;
import com.baidu.android.imrtc.send.BIMUser;
import com.baidu.android.imrtc.upload.BIMRtcTrack;
import com.baidu.android.imrtc.upload.BIMRtcTrackManager;
import com.baidu.android.imrtc.utils.BIMRtcEvent;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imrtc.utils.RtcUtility;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageFactory;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.g.a;
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
/* loaded from: classes3.dex */
public class BIMRtcManager {
    private static final String TAG = "BIMRtcManager";
    private static Context mContext;
    private static volatile BIMRtcManager mInstance;
    private Handler mRtcHandler;
    public static int BIM_RTC_ACTION_SYNC_SEQID_MAX = 100;
    public static int BIM_RTC_CALL_TIMEOUT_INTERNAL = 35000;
    public static int BIM_RTC_ANSWER_TIMEOUT_INTERNAL = 30000;
    private static List<BIMRtcListener> mRtcListeners = Collections.synchronizedList(new ArrayList());
    private static volatile Map<Long, BIMRtcSendMsg> msgList = new LinkedHashMap();
    private static Timer mCallTimeoutTimer = new Timer();
    private static volatile Map<String, Integer> mActionSyncSeqIdMap = new ConcurrentHashMap();
    private static volatile AtomicInteger RTC_HEART_BEAT_FAILED_COUNT = new AtomicInteger(0);
    public static volatile BIMRtcEvent mBIMRtcEvent = new BIMRtcEvent();
    private Runnable trackRequestRunnable = new Runnable() { // from class: com.baidu.android.imrtc.BIMRtcManager.2
        @Override // java.lang.Runnable
        public void run() {
            BIMRtcManager.this.mRtcHandler.removeCallbacks(BIMRtcManager.this.trackRequestRunnable);
            BIMRtcTrackManager.uploadRtcActionData(BIMRtcManager.mContext);
            BIMRtcManager.this.mRtcHandler.postDelayed(BIMRtcManager.this.trackRequestRunnable, RtcConstants.RTC_TRACK_UPLOAD_DURATION);
        }
    };
    private Runnable heartBeatRunnable = new Runnable() { // from class: com.baidu.android.imrtc.BIMRtcManager.3
        @Override // java.lang.Runnable
        public void run() {
            if (RtcConstants.IM_RTC_SDK_SEQ_ID.get() > 0) {
                BIMRtcManager.this.heartBeat(new IStatusListener() { // from class: com.baidu.android.imrtc.BIMRtcManager.3.1
                    @Override // com.baidu.android.imrtc.utils.IStatusListener
                    public void onResult(int i, String str) {
                        LogUtils.d(BIMRtcManager.TAG, "heartBeat responseCode :" + i + ", msg :" + str);
                    }
                });
            }
        }
    };

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
        RtcUtility.setIMUK(context, Utility.getUK(mContext));
        RtcUtility.setCuid(context, Utility.getDeviceId(mContext));
        RtcUtility.setAppId(context, AccountManager.getAppid(mContext));
        RtcUtility.setBduid(context, AccountManager.getUid(mContext));
    }

    public void createRoom(String str, @NonNull BIMRtcTokenListener bIMRtcTokenListener) {
        trackRequest("room/create", "c_client_request", -1, "");
        mBIMRtcEvent.requestAction = -10;
        mBIMRtcEvent.requestRoomId = "room/create";
        BIMRtcCreateRoomRequest bIMRtcCreateRoomRequest = new BIMRtcCreateRoomRequest(mContext, str, bIMRtcTokenListener);
        HttpExecutor.getInstance().execute(bIMRtcCreateRoomRequest, bIMRtcCreateRoomRequest);
    }

    public void generateToken(String str, String str2, long j, @NonNull BIMRtcTokenListener bIMRtcTokenListener) {
        trackRequest("room/get_rtc_token", "c_client_request", -1, "");
        BIMRtcGetTokenRequest bIMRtcGetTokenRequest = new BIMRtcGetTokenRequest(mContext, str, str2, j, bIMRtcTokenListener);
        HttpExecutor.getInstance().execute(bIMRtcGetTokenRequest, bIMRtcGetTokenRequest);
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

    public void kickoff(@NonNull BIMKickRequestRtcInfo bIMKickRequestRtcInfo, IStatusListener iStatusListener) {
        BIMUser bIMUser = new BIMUser();
        bIMUser.thirdUserId = RtcUtility.getBduid(mContext);
        bIMUser.cuid = RtcUtility.getCuid(mContext);
        bIMUser.appId = RtcUtility.getAppId(mContext);
        bIMUser.uk = RtcUtility.getIMUK(mContext);
        bIMKickRequestRtcInfo.setBIMKickUser(bIMUser);
        rtcSendEvent(bIMKickRequestRtcInfo, 104, iStatusListener);
    }

    private void kickoffResponse(@NonNull BIMKickResponseRtcInfo bIMKickResponseRtcInfo, IStatusListener iStatusListener) {
        rtcSendEvent(bIMKickResponseRtcInfo, 106, iStatusListener);
    }

    private void rtcSendEvent(@NonNull BIMRtcInfo bIMRtcInfo, int i, IStatusListener iStatusListener) {
        LogUtils.d(TAG, "rtcSendEvent action :" + i);
        if (i != 100 && i != 102) {
            trackRequest(bIMRtcInfo, RtcConstants.METHOD_IM_RTC_MSG, i, "c_client_request", -1);
        }
        bIMRtcInfo.setAction(i);
        bIMRtcInfo.setRtcDeviceId(RtcUtility.getCuid(mContext));
        if (i != 100 && i != 102) {
            mBIMRtcEvent.requestAction = i;
            mBIMRtcEvent.requestRoomId = bIMRtcInfo.getRtcRoomId();
        }
        if (TextUtils.isEmpty(bIMRtcInfo.getRtcRoomId())) {
            bIMRtcInfo.setRtcRoomId(RtcUtility.getRtcRoomId(mContext));
        }
        try {
            String addListener = ListenerManager.getInstance().addListener(iStatusListener);
            Intent creatMethodIntent = Utility.creatMethodIntent(mContext, RtcConstants.METHOD_IM_RTC_MSG);
            creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            creatMethodIntent.putExtra(RtcConstants.EXTRA_RTC_INFO, bIMRtcInfo.toRtcInfoString());
            creatMethodIntent.putExtra(RtcConstants.EXTRA_RTC_ACTION_ID, i);
            creatMethodIntent.putExtra("rtc_room_id", bIMRtcInfo.getRtcRoomId());
            a.an(mContext).e(mContext, creatMethodIntent);
            trackRequest(bIMRtcInfo, RtcConstants.METHOD_IM_RTC_MSG, i, "c_send_request", -1);
            mBIMRtcEvent.sdkAction = i;
            mBIMRtcEvent.sdkSeqId = RtcConstants.IM_RTC_SDK_SEQ_ID.get();
            mBIMRtcEvent.sdkRoomId = RtcUtility.getRtcRoomId(mContext);
        } catch (Exception e) {
            if (iStatusListener != null) {
                iStatusListener.onResult(-1, "rtcSendEvent exception");
                trackRequest(bIMRtcInfo, RtcConstants.METHOD_IM_RTC_MSG, i, "c_send_response exception", -1, e.getMessage());
            }
        }
    }

    public void onRtcRequestResult(int i, BIMRtcInfo bIMRtcInfo, int i2, String str, String str2) {
        IMListener removeListener = ListenerManager.getInstance().removeListener(str2);
        if (removeListener instanceof IStatusListener) {
            ((IStatusListener) removeListener).onResult(i2, str);
            trackRequest(bIMRtcInfo, RtcConstants.METHOD_IM_RTC_MSG, i, "c_client_response", i2);
        }
        handleRtcResult(i, bIMRtcInfo, i2);
        mBIMRtcEvent.sdkAction = i;
        mBIMRtcEvent.sdkSeqId = RtcConstants.IM_RTC_SDK_SEQ_ID.get();
        mBIMRtcEvent.sdkRoomId = RtcUtility.getRtcRoomId(mContext);
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
                        RtcConstants.RTC_TRACK_UPLOAD_DURATION = 0L;
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
                    mActionSyncSeqIdMap.clear();
                    this.mRtcHandler.removeCallbacks(this.heartBeatRunnable);
                    break;
                case 92:
                    this.mRtcHandler.removeCallbacks(this.heartBeatRunnable);
                    this.mRtcHandler.postDelayed(this.heartBeatRunnable, RtcConstants.RTC_HEART_BEAT_TIME);
                    break;
            }
            notifyRtcActionAndInfo(false, i, bIMRtcInfo);
        }
    }

    private static void trackRequest(BIMRtcInfo bIMRtcInfo, int i, int i2, String str, int i3, String str2) {
        if (i2 != 100) {
            new BIMRtcTrack.RequestBuilder(mContext).method("" + i).requestId("" + i2).requestTime(System.currentTimeMillis()).responseTime(System.nanoTime()).aliasId(501210L).errorCode(i3).ext(trackExt(bIMRtcInfo, str, str2)).build();
        }
    }

    private static void trackRequest(String str, String str2, int i, String str3) {
        new BIMRtcTrack.RequestBuilder(mContext).method(str).requestId("-1").requestTime(System.currentTimeMillis()).responseTime(System.nanoTime()).aliasId(501210L).errorCode(i).ext(trackExt(null, str2, str3)).build();
    }

    private static void trackRequest(BIMRtcInfo bIMRtcInfo, int i, int i2, String str, int i3) {
        if (i2 != 100) {
            trackRequest(bIMRtcInfo, i, i2, str, i3, "");
        }
    }

    private static String trackExt(BIMRtcInfo bIMRtcInfo, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", RtcUtility.getAppId(mContext));
            jSONObject.put("rtc_room_id", bIMRtcInfo == null ? "-1" : bIMRtcInfo.getRtcRoomId());
            jSONObject.put("my_uk", Utility.getUK(mContext));
            StringBuilder sb = new StringBuilder();
            if (bIMRtcInfo instanceof BIMInviteRtcInfo) {
                for (BIMInviteRtcInfo.BIMInviteUser bIMInviteUser : ((BIMInviteRtcInfo) bIMRtcInfo).getBIMInviteUsers()) {
                    if (bIMInviteUser != null) {
                        sb.append(bIMInviteUser.uk).append(",");
                    }
                }
            }
            jSONObject.put("other_uks", sb.toString());
            jSONObject.put("cseq_id", RtcConstants.IM_RTC_SDK_SEQ_ID.get());
            long j = RtcConstants.IM_RTC_SERVER_SEQ_ID;
            if (bIMRtcInfo != null) {
                j = bIMRtcInfo instanceof BIMAckRtcInfo ? ((BIMAckRtcInfo) bIMRtcInfo).getAckSeqId() : bIMRtcInfo.getSeq();
            }
            jSONObject.put("sseq_id", j);
            jSONObject.put("step", str);
            if (TextUtils.isEmpty(str2)) {
                str2 = bIMRtcInfo instanceof BIMAckRtcInfo ? "" + ((BIMAckRtcInfo) bIMRtcInfo).getSyncAction() : "-1";
            }
            jSONObject.put("ext", str2);
            return jSONObject.toString();
        } catch (Exception e) {
            return "trackExt :" + str;
        }
    }

    public static void imRtcReport(String str, String str2) {
        trackRequest("231", str, -1, str2);
    }

    public static void notifyParse(@NonNull JSONObject jSONObject) {
        trackRequest(null, 231, -1, "c_get_sync info begin", -1, jSONObject.toString());
        BIMRtcInfo parseJson = BIMRtcNotifyMsg.parseJson(mContext, jSONObject);
        if (parseJson == null) {
            LogUtils.i(TAG, "notifyParse info == null ");
            mBIMRtcEvent.serverAction = -2;
            mBIMRtcEvent.serverSedId = -2L;
            mBIMRtcEvent.serverRoomId = "-2";
            trackRequest(parseJson, 231, -2, "c_get_sync info is null", -2, jSONObject.toString());
            BIMRtcTrackManager.uploadRtcActionData(mContext);
            return;
        }
        trackRequest(parseJson, 231, parseJson.getAction(), "c_get_sync", -1);
        checkServerSeqId(parseJson);
        getInstance(mContext).ackEvent(parseJson);
        if (parseJson.getAction() == 81) {
            BIMRtcTrackManager.uploadRtcActionData(mContext);
        }
        mBIMRtcEvent.serverAction = parseJson.getAction();
        mBIMRtcEvent.serverSedId = RtcConstants.IM_RTC_SERVER_SEQ_ID;
        mBIMRtcEvent.serverRoomId = parseJson.getRtcRoomId();
        String str = parseJson.getRtcRoomId() + parseJson.getSeq();
        String str2 = "mActionSyncSeqIdMap.size :" + mActionSyncSeqIdMap.size() + ", key :" + str + ", value :" + parseJson.getAction();
        if (mActionSyncSeqIdMap.containsKey(str)) {
            LogUtils.d(TAG, "contain, " + str2);
            mBIMRtcEvent.notifyAction = -3;
            mBIMRtcEvent.notifySeqId = -3L;
            trackRequest(parseJson, 231, parseJson.getAction(), "c_client_sync fail contain " + str, -3);
            return;
        }
        notifyRtcActionAndInfo(true, parseJson.getAction(), parseJson);
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
            mBIMRtcEvent.notifyAction = -4;
            mBIMRtcEvent.notifySeqId = -4L;
        }
    }

    private void ackEvent(BIMRtcInfo bIMRtcInfo) {
        LogUtils.i(TAG, "ackEvent :" + bIMRtcInfo.toString());
        BIMAckRtcInfo bIMAckRtcInfo = new BIMAckRtcInfo();
        bIMAckRtcInfo.setAckSeqId(bIMRtcInfo.getSeq());
        bIMAckRtcInfo.setSyncAction(bIMRtcInfo.getAction());
        bIMAckRtcInfo.setImUK(Utility.getUK(mContext));
        rtcSendEvent(bIMAckRtcInfo, 102, null);
    }

    private static boolean isOthers(BIMRtcInfo bIMRtcInfo) {
        long initiatorUk;
        long uk = Utility.getUK(mContext);
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
        if (this.mRtcHandler != null) {
            this.mRtcHandler.removeCallbacks(this.trackRequestRunnable);
            this.mRtcHandler.postDelayed(this.trackRequestRunnable, RtcConstants.RTC_TRACK_UPLOAD_DURATION);
        }
    }

    public void unRegisterRtcListener(@NonNull BIMRtcListener bIMRtcListener) {
        mRtcListeners.remove(bIMRtcListener);
        if (this.mRtcHandler != null) {
            this.mRtcHandler.removeCallbacks(this.trackRequestRunnable);
            BIMRtcTrackManager.uploadRtcActionData(mContext);
        }
    }

    private static void notifyRtcActionAndInfo(boolean z, int i, BIMRtcInfo bIMRtcInfo) {
        for (BIMRtcListener bIMRtcListener : mRtcListeners) {
            if (bIMRtcListener != null) {
                bIMRtcListener.onRtcResult(i, bIMRtcInfo);
                notifyEvent(bIMRtcInfo, bIMRtcListener);
                if (z) {
                    trackRequest(bIMRtcInfo, 231, i, "c_client_sync", -1);
                }
                if (isOthers(bIMRtcInfo)) {
                    mBIMRtcEvent.notifyAction = i;
                    mBIMRtcEvent.notifySeqId = RtcConstants.IM_RTC_SERVER_SEQ_ID;
                    mBIMRtcEvent.notifyRoomId = bIMRtcInfo.getRtcRoomId();
                }
            }
        }
    }

    private static void notifyEvent(@NonNull BIMRtcInfo bIMRtcInfo, @NonNull BIMRtcListener bIMRtcListener) {
        LogUtils.e(TAG, "notifyEvent info :" + bIMRtcInfo.getAction());
        switch (bIMRtcInfo.getAction()) {
            case 81:
                if (isOthers(bIMRtcInfo)) {
                    bIMRtcListener.roomCalleeInviteFromCaller(bIMRtcInfo);
                    getInstance(mContext).ring(bIMRtcInfo.getRtcRoomId(), new IStatusListener() { // from class: com.baidu.android.imrtc.BIMRtcManager.4
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i, String str) {
                            LogUtils.d(BIMRtcManager.TAG, "rtcRing responseCode :" + i + ", msg :" + str);
                        }
                    });
                    return;
                }
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
                    if (answerType == 1 && !RtcUtility.getCuid(mContext).equals(str)) {
                        bIMRtcListener.roomCalleeAnswerByFromOtherCallee(answerType, bIMRtcInfo);
                        return;
                    } else if (answerType == 3 && RtcUtility.getCuid(mContext).equals(str)) {
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
            case 105:
                int roomKickedUserFromKickerSync = bIMRtcListener.roomKickedUserFromKickerSync((BIMKickReqSyncRtcInfo) bIMRtcInfo);
                if (roomKickedUserFromKickerSync != 0) {
                    BIMKickResponseRtcInfo bIMKickResponseRtcInfo = new BIMKickResponseRtcInfo();
                    bIMKickResponseRtcInfo.setBIMKickedStatus(roomKickedUserFromKickerSync);
                    bIMKickResponseRtcInfo.setBIMKickUser(((BIMKickReqSyncRtcInfo) bIMRtcInfo).getBIMKickUsers());
                    bIMKickResponseRtcInfo.setBIMKickedUser(((BIMKickReqSyncRtcInfo) bIMRtcInfo).getBIMKickedUsers());
                    getInstance(mContext).kickoffResponse(bIMKickResponseRtcInfo, null);
                    return;
                }
                return;
            case 107:
                bIMRtcListener.roomEventKickedStatusByKickedUser((BIMKickResSyncRtcInfo) bIMRtcInfo);
                return;
            default:
                return;
        }
    }

    public void setRtcDebugEnv(Context context, boolean z) {
        RtcUtility.setRtcDebug(context, z);
    }

    public String report() {
        if (mBIMRtcEvent == null) {
            mBIMRtcEvent = new BIMRtcEvent();
            return "event is null.";
        }
        return mBIMRtcEvent.toString();
    }
}
