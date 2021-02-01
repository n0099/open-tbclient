package com.baidu.android.imrtc.msg;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.BIMRtcManager;
import com.baidu.android.imrtc.send.BIMAnswerRtcInfo;
import com.baidu.android.imrtc.send.BIMCloseRoomRtcInfo;
import com.baidu.android.imrtc.send.BIMFetchSignalRtcInfo;
import com.baidu.android.imrtc.send.BIMFetchStateRtcInfo;
import com.baidu.android.imrtc.send.BIMInviteRtcInfo;
import com.baidu.android.imrtc.upload.BIMRtcTrack;
import com.baidu.android.imrtc.utils.IMJni;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imrtc.utils.RtcUtility;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.sapi2.SapiContext;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BIMRtcSendMsg extends Message {
    private static final String TAG = "IMRtcSendMsg";
    private int mAction;
    private Context mContext;
    private long mImUk;
    private String mRoomId;
    private long mRtcAppID;
    private String mRtcInfo;
    private int mSdkVersion;
    private IStatusListener mStatusListener;

    public BIMRtcSendMsg(Context context, int i, String str, String str2) {
        this.mContext = context;
        this.mRtcInfo = str2;
        this.mAction = i;
        this.mRoomId = str;
    }

    public BIMRtcSendMsg(Context context, int i, String str, String str2, String str3) {
        this(context, i, str, str2);
        initCommonParameter(context);
        this.mListenerKey = str3;
        setNeedReplay(true);
        setType(RtcConstants.METHOD_IM_RTC_MSG);
        this.mRtcAppID = this.mAppid;
        this.mSdkVersion = IMConfigInternal.getInstance().getSDKVersionValue(this.mContext);
        this.mImUk = Utility.getUK(this.mContext);
    }

    public static BIMRtcSendMsg newInstance(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(Constants.EXTRA_LISTENER_ID);
        return new BIMRtcSendMsg(context, intent.getIntExtra(RtcConstants.EXTRA_RTC_ACTION_ID, -1), intent.getStringExtra("rtc_room_id"), intent.getStringExtra(RtcConstants.EXTRA_RTC_INFO), stringExtra);
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        this.mBody = generateBody().toString();
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        LogUtils.w(TAG, "error :" + i + ", msg :" + str + ", objStr :" + (jSONObject != null ? jSONObject.toString() : "null"));
        if (this.mAction != 100) {
            new BIMRtcTrack.RequestBuilder(this.mContext).method("230").requestId("" + this.mAction).requestTime(System.currentTimeMillis()).responseTime(System.nanoTime()).errorCode(i).aliasId(501210L).ext(trackRequestExt()).build();
        }
        String str2 = null;
        if (i == 0 && jSONObject != null) {
            str2 = jSONObject.optString("err_msg");
            if (jSONObject.has(RtcConstants.EXTRA_RTC_INFO)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString(RtcConstants.EXTRA_RTC_INFO));
                    if (this.mAction == 100 || this.mAction == 92 || this.mAction == 84) {
                        long optLong = jSONObject2.optLong("heartbeat_duration");
                        if (optLong > 0) {
                            RtcConstants.RTC_HEART_BEAT_TIME = optLong * 1000;
                        }
                        int optInt = jSONObject2.optInt("heartbeat_retry_times");
                        if (optInt > 0) {
                            RtcConstants.RTC_HEART_BEAT_RETRY_TIME = optInt;
                        }
                        RtcConstants.RTC_HEART_BEAT_STATUS = jSONObject2.optInt("user_status", 0);
                        long optLong2 = jSONObject2.optLong("ftrace_upload_duration");
                        if (optLong2 > 0) {
                            RtcConstants.RTC_TRACK_UPLOAD_DURATION = optLong2 * 1000;
                        }
                    }
                    long optLong3 = jSONObject2.optLong("server_seqid");
                    if (optLong3 > 0) {
                        RtcConstants.IM_RTC_SERVER_SEQ_ID = optLong3;
                    }
                } catch (Exception e) {
                    LogUtils.e(TAG, "rtc_info Exception");
                }
            }
        }
        super.handleMessageResult(context, jSONObject, i, str);
        onResult(i, str2);
    }

    public JSONObject generateBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", RtcConstants.METHOD_IM_RTC_MSG);
            jSONObject.put("appid", this.mRtcAppID);
            jSONObject.put("msg_key", "");
            jSONObject.put("app_version", RtcUtility.getAppVersionName(this.mContext));
            jSONObject.put(SapiContext.KEY_SDK_VERSION, this.mSdkVersion);
            jSONObject.put("signal_sdk_version", RtcConstants.RTC_VERSION);
            jSONObject.put("uk", this.mImUk);
            jSONObject.put("third_userid", IMJni.transBDUID("" + Utility.getBuid(this.mContext)));
            jSONObject.put("action", this.mAction);
            jSONObject.put("rtc_room_id", this.mRoomId);
            jSONObject.put(RtcConstants.EXTRA_RTC_INFO, this.mRtcInfo);
            LogUtils.i(TAG, "IMRtcSendMsg body :" + jSONObject.toString());
        } catch (JSONException e) {
            LogUtils.e(TAG, "IMRtcSendMsg Exception ", e);
        }
        return jSONObject;
    }

    public void setListener(IStatusListener iStatusListener) {
        this.mStatusListener = iStatusListener;
    }

    public void onResult(int i, String str) {
        BIMRtcInfo bIMFetchSignalRtcInfo;
        switch (this.mAction) {
            case 80:
                bIMFetchSignalRtcInfo = new BIMInviteRtcInfo(this.mContext);
                break;
            case 84:
                bIMFetchSignalRtcInfo = new BIMAnswerRtcInfo();
                break;
            case 88:
                bIMFetchSignalRtcInfo = new BIMCloseRoomRtcInfo();
                break;
            case 90:
                bIMFetchSignalRtcInfo = new BIMFetchStateRtcInfo(str);
                break;
            case 91:
                bIMFetchSignalRtcInfo = new BIMFetchSignalRtcInfo();
                break;
            default:
                bIMFetchSignalRtcInfo = new BIMRtcInfo();
                break;
        }
        BIMRtcManager.getInstance(this.mContext).onRtcRequestResult(this.mAction, bIMFetchSignalRtcInfo.toRtcInfo(this.mAction, this.mRoomId, this.mRtcInfo), i, str, this.mListenerKey);
    }

    private String trackRequestExt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", RtcUtility.getAppId(this.mContext));
            jSONObject.put("rtc_room_id", this.mRoomId);
            jSONObject.put("my_uk", Utility.getUK(this.mContext));
            jSONObject.put("other_uks", "");
            jSONObject.put("cseq_id", RtcConstants.IM_RTC_SDK_SEQ_ID.get());
            jSONObject.put("sseq_id", RtcConstants.IM_RTC_SERVER_SEQ_ID);
            jSONObject.put("step", "c_send_response");
            jSONObject.put("ext", "-1");
            return jSONObject.toString();
        } catch (Exception e) {
            return "c_send_response trackRequestExt Exception";
        }
    }
}
