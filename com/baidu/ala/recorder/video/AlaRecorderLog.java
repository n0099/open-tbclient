package com.baidu.ala.recorder.video;

import android.hardware.Camera;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.ala.adp.lib.safe.SafeHandler;
import com.baidu.ala.adp.lib.util.BdNetTypeUtil;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.recorder.RecorderCallback;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.sapi2.activity.BindWidgetActivity;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AlaRecorderLog {
    public static final String BEAUTY_INFO_LOG_ID = "2449";
    public static final String BEAUTY_PERFORMANCE_LOG_ID = "2448";
    public static final String CAMERA_START_TYPE = "0";
    public static final String KEY_AUDIO = "audio";
    public static final String KEY_AUDIO_BITRATE = "audio_bitrate";
    public static final String KEY_AUDIO_CHANNEL = "audio_channel";
    public static final String KEY_AUDIO_FPS = "audio_fps";
    public static final String KEY_AUDIO_SAMPLE = "audio_sample";
    public static final String KEY_CAMERA_COUNT = "camera_count";
    public static final String KEY_CAMERA_FACING = "camera_facing";
    public static final String KEY_CAMERA_FORMAT = "camera_format";
    public static final String KEY_CAMERA_HEIGHT = "camera_height";
    public static final String KEY_CAMERA_ID = "camera_id";
    public static final String KEY_CAMERA_WIDTH = "camera_width";
    public static final String KEY_CANERA_START_FPS = "fps";
    public static final String KEY_CANERA_START_REQ_API = "req_api";
    public static final String KEY_CHAT_STATUS = "chat_status";
    public static final String KEY_CONTENT_EXT_PROTOCOL = "protocol";
    public static final String KEY_CONTENT_EXT_RES_ID = "res_id";
    public static final String KEY_CONTENT_PAGE = "page";
    public static final String KEY_CONTENT_TYPE = "type";
    public static final String KEY_CONTENT_VALUE = "value";
    public static final String KEY_COST_TIME = "cost_time";
    public static final String KEY_CURRENT_STAGE = "current_stage";
    public static final String KEY_DEBUG_INFO = "debug_info";
    public static final String KEY_ENCODE_TYPE = "encode_type";
    public static final String KEY_ERROR_CODE = "error_code";
    public static final String KEY_ERROR_MSG = "error_msg";
    public static final String KEY_EXPECT_VIDEO_BITRATE_MAX = "expect_video_bitrate_max";
    public static final String KEY_EXPECT_VIDEO_BITRATE_MIN = "expect_video_bitrate_min";
    public static final String KEY_EXPECT_VIDEO_FPS_MAX = "expect_video_fps_max";
    public static final String KEY_EXPECT_VIDEO_FPS_MIN = "expect_video_fps_min";
    public static final String KEY_ID_2425 = "2425";
    public static final String KEY_ID_2427 = "2427";
    public static final String KEY_ID_2429 = "2429";
    public static final String KEY_MSG = "msg";
    public static final String KEY_NETWORK_AVAILABLE = "network_available";
    public static final String KEY_PUSH_STREAM_FLUENT_SCORE = "push_stream_fluent_score";
    public static final String KEY_PUSH_STREAM_INFO = "push_stream_info";
    public static final String KEY_PUSH_STREAM_IP = "push_stream_ip";
    public static final String KEY_PUSH_STREAM_TYPE = "push_stream_type";
    public static final String KEY_PUSH_STREAM_URL = "push_stream_url";
    public static final String KEY_RES_TYPE = "res_type";
    public static final String KEY_RETRY_TIMES = "retry_times";
    public static final String KEY_RTC_ROOM_ID = "rtc_room_id";
    public static final String KEY_RTC_SOURCE = "rtc_source";
    public static final String KEY_STREAM_SUSPEND_TIME = "stream_suspend_time";
    public static final String KEY_VIDEO = "video";
    public static final String KEY_VIDEO_BITRATE = "video_bitrate";
    public static final String KEY_VIDEO_FPS = "video_fps";
    public static final String KEY_VIDEO_RESOLUTION = "video_resolution";
    public static final String NAME_BEAUTY_PERFORMANCE = "beauty_ performance";
    public static final String NAME_CAMERA_ERROR_TYPE = "camera_error";
    public static final String NAME_CAMERA_START = "camera_start";
    public static final String PAGE_AUTHOR_LIVEROOM = "author_liveroom";
    public static final String PAGE_AUTHOR_LIVE_ROOM = "author_liveroom";
    private static final String TAG = "DuAr_Report";
    public static final String TYPE_ADKLIVECORE = "adklivecore";
    public static final String TYPE_CLICK = "click";
    public static final String TYPE_NOTICE = "notice";
    public static final String VALUE_PUSH_STREAM = "push_stream";
    private int mAudioChannel;
    private int mAudioFps;
    private int mAudioSample;
    private int mExpectVideoBitrateMax;
    private int mExpectVideoBitrateMin;
    private int mExpectVideoFpsMax;
    private int mExpectVideoFpsMin;
    private long mLastNetBreakTimeMillis;
    private int mLastRtmpNetState;
    private int mNetRetryTimes;
    private String mPushResId;
    private String mPushStreamIp;
    private int mPushStreamType;
    private String mPushStreamUrl;
    private JSONObject mPushStremInfoJson;
    RecorderCallback mRecorderCallback;
    private AlaLiveVideoConfig mVideoConfig;
    private String mVideoResolution;
    private String mCurProtocal = null;
    private int mChatStatus = 0;
    private Runnable mStreamBreakTimeoutRunnalbe = new Runnable() { // from class: com.baidu.ala.recorder.video.AlaRecorderLog.1
        @Override // java.lang.Runnable
        public void run() {
            AlaRecorderLog.this.onStreamBreak(1, "rtmp stream interupt 10s");
        }
    };

    /* loaded from: classes5.dex */
    public static class ErrCodeSeg {
        public static final int ERROR_BASE_RECORDER = 300000;
        public static final int ERROR_BASE_RTC = 110000;
        public static final int ERROR_BASE_RTMP = 200000;
    }

    /* loaded from: classes5.dex */
    public static class ErrorCode {
        public static final int ERROR_RECORDER_NOT_DEFINE_ERROR = 9999;
        public static final int ERROR_STREAM_INTERRUPT = 1;
    }

    /* loaded from: classes5.dex */
    public static class Protocol {
        public static final String RTC = "rtc";
        public static final String RTMP = "rtmp";
    }

    /* loaded from: classes5.dex */
    public static class RtcSource {
        public static final String AUDIO_CHAT_1V1 = "1v1";
        public static final String VIDEO_CHAT_1V1 = "1v1";
        public static final String VIDEO_CHAT_1V2 = "1v2";
    }

    /* loaded from: classes5.dex */
    public static class Stage {
        public static final int CONN_SUCC = 20;
        public static final int ENTER_BACKGROUND = 50;
        public static final int ENTER_FOREGROUND = 60;
        public static final int PUSH_REPORT = 40;
        public static final int PUSH_START = 10;
        public static final int PUSH_SUCC = 30;
        public static final int STREAM_BREAK = 70;
        public static final int STREAM_END = 90;
        public static final int STREAM_ERROR = 80;
    }

    /* loaded from: classes5.dex */
    public static class Value {
        public static final String CLOSE_ROOM_CLK = "close_room_clk";
        public static final String HANGOFF_CLK = "hangoff_clk";
        public static final String HANGOFF_REMOTE = "hangoff_remote";
        public static final String INVITE_CANCEL_CLK = "invite_cancel_clk";
        public static final String INVITE_TIMEOUT_REMOTE = "invite_timeout_remote";
        public static final String INVITE_USER_CLK = "invite_user_clk";
        public static final String JOIN_CLK = "join_clk";
        public static final String JOIN_ROOM_REMOTE = "join_room_remote";
        public static final String KICKOFF_CLK = "kickoff_clk";
        public static final String USER_REJECT_REMOTE = "user_reject_remote";
    }

    /* loaded from: classes5.dex */
    public static class CameraInfo {
        public int cameraApi = 1;
        public int cameraCount;
        public int curCameraPosition;
        public Object displayRotate;
        public int errorCode;
        public Camera.CameraInfo info;
        public StringBuilder msgSb;
        public Camera.Parameters params;
        public int previewHeight;
        public int previewWidth;

        public void print(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (this.msgSb == null) {
                    this.msgSb = new StringBuilder();
                }
                this.msgSb.append(str).append('\n');
            }
        }
    }

    public AlaRecorderLog(RecorderCallback recorderCallback) {
        this.mRecorderCallback = recorderCallback;
    }

    public void onNetStateReport(int i, int i2) {
        long j;
        if (i == 2) {
            if (this.mLastRtmpNetState != 2) {
                startRtmpPush();
            } else {
                return;
            }
        } else if (i == 1) {
            if (this.mLastNetBreakTimeMillis != 0) {
                j = System.currentTimeMillis() - this.mLastNetBreakTimeMillis;
                this.mLastNetBreakTimeMillis = 0L;
            } else {
                j = 0;
            }
            SafeHandler.getInst().removeCallbacks(this.mStreamBreakTimeoutRunnalbe);
            pushRtmpSuccess(i2, (int) j);
        } else if (i == 0) {
            this.mLastNetBreakTimeMillis = System.currentTimeMillis();
            SafeHandler.getInst().removeCallbacks(this.mStreamBreakTimeoutRunnalbe);
            SafeHandler.getInst().postDelayed(this.mStreamBreakTimeoutRunnalbe, 10000L);
            pushRtmpStreamError();
        }
        this.mLastRtmpNetState = i;
    }

    public void logCameraStart(CameraInfo cameraInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_CONTENT_EXT_RES_ID, this.mPushResId);
            JSONObject jSONObject2 = new JSONObject();
            if (cameraInfo.params != null) {
                int[] iArr = new int[2];
                cameraInfo.params.getPreviewFpsRange(iArr);
                jSONObject2.put(KEY_CANERA_START_FPS, iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SERVER + iArr[1]);
            }
            jSONObject2.put(KEY_CANERA_START_REQ_API, cameraInfo.cameraApi);
            if (cameraInfo.params != null) {
                jSONObject2.put(KEY_CAMERA_FORMAT, cameraInfo.params.getPreviewFormat());
            }
            jSONObject2.put(KEY_CAMERA_WIDTH, cameraInfo.previewWidth);
            jSONObject2.put(KEY_CAMERA_HEIGHT, cameraInfo.previewHeight);
            jSONObject2.put(KEY_CAMERA_COUNT, cameraInfo.cameraCount);
            jSONObject2.put(KEY_CAMERA_ID, cameraInfo.curCameraPosition);
            if (cameraInfo.info != null) {
                jSONObject2.put(KEY_CAMERA_FACING, cameraInfo.info.facing == 1);
            }
            if (cameraInfo.msgSb != null) {
                jSONObject2.put("msg", cameraInfo.msgSb.toString());
            }
            jSONObject.put(KEY_DEBUG_INFO, jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogReport.logEvent(BEAUTY_INFO_LOG_ID, "0", "author_liveroom", NAME_CAMERA_START, jSONObject);
    }

    public void logCameraError(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_CONTENT_EXT_RES_ID, this.mPushResId);
            jSONObject.put("error_code", i);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("error_msg", str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogReport.logEvent(BEAUTY_INFO_LOG_ID, "0", "author_liveroom", NAME_CAMERA_ERROR_TYPE, jSONObject);
    }

    public void onRecorderError(int i, String str) {
        if (Protocol.RTMP.equals(this.mCurProtocal)) {
            if (i > 9999) {
                onErrorEvent(309999, "not define err = " + i + "   " + str);
                return;
            }
            switch (i) {
                case 4:
                case 10:
                case 12:
                    onStreamBreak(300000 + i, str);
                    return;
                default:
                    onErrorEvent(300000 + i, str);
                    return;
            }
        }
    }

    public void onErrorEvent(int i, String str) {
        if (Protocol.RTMP.equals(this.mCurProtocal)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(KEY_CURRENT_STAGE, 80);
                jSONObject.put("error_code", i);
                jSONObject.put("error_msg", str);
                fillExtCommonData(jSONObject);
                logEvent(KEY_ID_2425, TYPE_ADKLIVECORE, "author_liveroom", VALUE_PUSH_STREAM, jSONObject);
            } catch (JSONException e) {
            }
        }
    }

    public void onStreamBreak(int i, String str) {
        if (Protocol.RTMP.equals(this.mCurProtocal)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(KEY_CURRENT_STAGE, 70);
                jSONObject.put("error_code", i);
                jSONObject.put("error_msg", str);
                jSONObject.put(KEY_NETWORK_AVAILABLE, BdNetTypeUtil.isNetworkAvailableForImmediately());
                fillExtCommonData(jSONObject);
                logEvent(KEY_ID_2425, TYPE_ADKLIVECORE, "author_liveroom", VALUE_PUSH_STREAM, jSONObject);
            } catch (JSONException e) {
            }
        }
    }

    public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
        if (Protocol.RTMP.equals(this.mCurProtocal) && alaLiveDebugInfo != null && alaLiveDebugInfo.elapsedMilli > 0) {
            long j = alaLiveDebugInfo.elapsedMilli / 1000;
            long j2 = (alaLiveDebugInfo.sendVideoCount - alaLiveDebugInfo.sendVideoFailure) / j;
            long j3 = (alaLiveDebugInfo.sendAudioCount - alaLiveDebugInfo.sendAudioFailure) / j;
            long j4 = ((alaLiveDebugInfo.sendVideoBitrate / 1024) * 8) / j;
            long j5 = ((alaLiveDebugInfo.sendAudioBitrate / 1024) * 8) / j;
            long j6 = 0;
            if (this.mExpectVideoFpsMax > 0) {
                j6 = (100 * j2) / this.mExpectVideoFpsMax;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(KEY_VIDEO_FPS, j2);
                jSONObject.put(KEY_VIDEO_BITRATE, j4);
                jSONObject.put(KEY_AUDIO_FPS, j3);
                jSONObject.put(KEY_AUDIO_BITRATE, j5);
                jSONObject.put(KEY_PUSH_STREAM_FLUENT_SCORE, j6);
                fillExtCommonData(jSONObject);
                logEvent(KEY_ID_2429, TYPE_ADKLIVECORE, "author_liveroom", VALUE_PUSH_STREAM, jSONObject);
            } catch (JSONException e) {
            }
        }
    }

    private void startRtmpPush() {
        if (Protocol.RTMP.equals(this.mCurProtocal)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(KEY_CURRENT_STAGE, 10);
                jSONObject.put(KEY_RETRY_TIMES, this.mNetRetryTimes);
                jSONObject.put(KEY_CHAT_STATUS, this.mChatStatus);
                fillExtCommonData(jSONObject);
                logEvent(KEY_ID_2425, TYPE_ADKLIVECORE, "author_liveroom", VALUE_PUSH_STREAM, jSONObject);
            } catch (JSONException e) {
            }
            this.mNetRetryTimes++;
        }
    }

    public void pushRtmpStreamError() {
        if (Protocol.RTMP.equals(this.mCurProtocal)) {
            onErrorEvent(BindWidgetActivity.REQUEST_CODE_LOGIN, "rtmp conn fail msg");
        }
    }

    public void pushRtmpSuccess(int i, int i2) {
        if (Protocol.RTMP.equals(this.mCurProtocal)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(KEY_CURRENT_STAGE, 30);
                jSONObject.put(KEY_RETRY_TIMES, this.mNetRetryTimes - 1);
                jSONObject.put(KEY_CHAT_STATUS, this.mChatStatus);
                jSONObject.put(KEY_COST_TIME, i);
                jSONObject.put(KEY_STREAM_SUSPEND_TIME, i2);
                fillExtCommonData(jSONObject);
                logEvent(KEY_ID_2425, TYPE_ADKLIVECORE, "author_liveroom", VALUE_PUSH_STREAM, jSONObject);
            } catch (JSONException e) {
            }
        }
    }

    public void markEnterForeground() {
        if (Protocol.RTMP.equals(this.mCurProtocal)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(KEY_CURRENT_STAGE, 60);
                fillExtCommonData(jSONObject);
                logEvent(KEY_ID_2425, TYPE_ADKLIVECORE, "author_liveroom", VALUE_PUSH_STREAM, jSONObject);
            } catch (JSONException e) {
            }
        }
    }

    public void markEnterBackground() {
        if (Protocol.RTMP.equals(this.mCurProtocal)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(KEY_CURRENT_STAGE, 50);
                fillExtCommonData(jSONObject);
                logEvent(KEY_ID_2425, TYPE_ADKLIVECORE, "author_liveroom", VALUE_PUSH_STREAM, jSONObject);
            } catch (JSONException e) {
            }
        }
    }

    public void pushEnd() {
        SafeHandler.getInst().removeCallbacks(this.mStreamBreakTimeoutRunnalbe);
        if (Protocol.RTMP.equals(this.mCurProtocal)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(KEY_CURRENT_STAGE, 90);
                fillExtCommonData(jSONObject);
                logEvent(KEY_ID_2425, TYPE_ADKLIVECORE, "author_liveroom", VALUE_PUSH_STREAM, jSONObject);
            } catch (JSONException e) {
            }
        }
        this.mCurProtocal = null;
        this.mPushStremInfoJson = null;
        this.mPushStreamType = 0;
    }

    private void fillExtCommonData(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            jSONObject.put(KEY_CONTENT_EXT_RES_ID, this.mPushResId);
            jSONObject.put(KEY_CONTENT_EXT_PROTOCOL, this.mCurProtocal);
            jSONObject.put(KEY_PUSH_STREAM_IP, this.mPushStreamIp);
            jSONObject.put(KEY_PUSH_STREAM_TYPE, this.mPushStreamType);
            if (this.mPushStremInfoJson == null) {
                this.mPushStremInfoJson = new JSONObject();
                this.mPushStremInfoJson.put(KEY_PUSH_STREAM_URL, this.mPushStreamUrl);
                this.mPushStremInfoJson.put(KEY_EXPECT_VIDEO_FPS_MAX, this.mExpectVideoFpsMax);
                this.mPushStremInfoJson.put(KEY_EXPECT_VIDEO_FPS_MIN, this.mExpectVideoFpsMin);
                this.mPushStremInfoJson.put(KEY_EXPECT_VIDEO_BITRATE_MAX, this.mExpectVideoBitrateMax);
                this.mPushStremInfoJson.put(KEY_EXPECT_VIDEO_BITRATE_MIN, this.mExpectVideoBitrateMin);
                this.mPushStremInfoJson.put(KEY_VIDEO_RESOLUTION, this.mVideoResolution);
                this.mPushStremInfoJson.put(KEY_AUDIO_SAMPLE, this.mAudioSample);
                this.mPushStremInfoJson.put(KEY_AUDIO_CHANNEL, this.mAudioChannel);
                this.mPushStremInfoJson.put(KEY_AUDIO_FPS, this.mAudioFps);
            }
            jSONObject.put(KEY_PUSH_STREAM_INFO, this.mPushStremInfoJson);
        }
    }

    public void setPushConfig(String str, String str2) {
        this.mCurProtocal = str;
        this.mNetRetryTimes = 0;
        this.mLastRtmpNetState = -1;
        this.mLastNetBreakTimeMillis = 0L;
        this.mPushStreamIp = null;
        if (this.mPushStreamUrl == null || !this.mPushStreamUrl.equals(str2)) {
            this.mPushStreamUrl = str2;
            this.mPushResId = getResId(str2);
        }
        SafeHandler.getInst().removeCallbacks(this.mStreamBreakTimeoutRunnalbe);
    }

    public String getResId() {
        return this.mPushResId;
    }

    public void setPushStreamIp(String str) {
        this.mPushStreamIp = str;
    }

    public void setPushStreamType(int i) {
        this.mPushStreamType = i;
    }

    public void setPushCommonData(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.mExpectVideoFpsMax = i;
        this.mExpectVideoFpsMin = i2;
        this.mExpectVideoBitrateMax = i3;
        this.mExpectVideoBitrateMin = i4;
        this.mVideoResolution = "" + i5 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i6;
        this.mAudioSample = i7;
        this.mAudioChannel = i8;
        this.mAudioFps = i9;
    }

    public void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig) {
        this.mVideoConfig = alaLiveVideoConfig;
        if (alaLiveVideoConfig != null) {
            setPushCommonData(alaLiveVideoConfig.getMaxFps(), alaLiveVideoConfig.getMinFps(), alaLiveVideoConfig.getMaxBitRate() / 1024, alaLiveVideoConfig.getMinBitRate() / 1024, alaLiveVideoConfig.getVideoWidth(), alaLiveVideoConfig.getVideoHeight(), 44100, 1, 43);
        }
    }

    private String getResId(String str) {
        List<String> pathSegments;
        if (TextUtils.isEmpty(str) || (pathSegments = Uri.parse(str).getPathSegments()) == null || pathSegments.size() <= 0) {
            return null;
        }
        return pathSegments.get(pathSegments.size() - 1);
    }

    public void logEventInMainThread(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        if (this.mRecorderCallback != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("type", str2);
                jSONObject2.put("page", str3);
                jSONObject2.put("value", str4);
            } catch (JSONException e) {
            }
            this.mRecorderCallback.onLogReport(str, jSONObject2, jSONObject);
        }
    }

    public void logEvent(final String str, final String str2, final String str3, final String str4, final JSONObject jSONObject) {
        if (isMainThread()) {
            logEventInMainThread(str, str2, str3, str4, jSONObject);
        } else {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.ala.recorder.video.AlaRecorderLog.2
                @Override // java.lang.Runnable
                public void run() {
                    AlaRecorderLog.this.logEventInMainThread(str, str2, str3, str4, jSONObject);
                }
            });
        }
    }

    public boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper() && Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
