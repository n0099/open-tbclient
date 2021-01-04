package com.baidu.live.alablmsdk.a.b;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static final c aBH = new c();
    private long aBI;
    private String aBK;
    private d aBN;
    private int mAudioChannel;
    private int mAudioFps;
    private int mAudioSample;
    private int mExpectVideoBitrateMax;
    private int mExpectVideoBitrateMin;
    private int mExpectVideoFpsMax;
    private int mExpectVideoFpsMin;
    private long mLastNetBreakTimeMillis;
    private int mNetRetryTimes;
    private String mPushResId;
    private String mPushStreamIp;
    private int mPushStreamType;
    private String mPushStreamUrl;
    private JSONObject mPushStremInfoJson;
    private String mRtcRoomId;
    private String mVideoResolution;
    private String mCurProtocal = null;
    private int mChatStatus = 0;
    private int aBJ = 0;
    private String aBL = null;
    private boolean aBM = false;
    private Runnable aBO = new Runnable() { // from class: com.baidu.live.alablmsdk.a.b.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.onStreamBreak(1, "rtc stream interupt 10s");
        }
    };

    private c() {
    }

    public static c Bp() {
        return aBH;
    }

    public void onErrorEvent(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 80);
            jSONObject.put("error_code", i);
            jSONObject.put("error_msg", str);
            fillExtCommonData(jSONObject);
            logEvent(AlaRecorderLog.KEY_ID_2425, AlaRecorderLog.TYPE_ADKLIVECORE, "author_liveroom", AlaRecorderLog.VALUE_PUSH_STREAM, jSONObject);
        } catch (JSONException e) {
        }
    }

    public void onStreamBreak(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 70);
            jSONObject.put("error_code", i);
            jSONObject.put("error_msg", str);
            fillExtCommonData(jSONObject);
            logEvent(AlaRecorderLog.KEY_ID_2425, AlaRecorderLog.TYPE_ADKLIVECORE, "author_liveroom", AlaRecorderLog.VALUE_PUSH_STREAM, jSONObject);
        } catch (JSONException e) {
        }
    }

    public void Bq() {
        this.aBI = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 10);
            jSONObject.put(AlaRecorderLog.KEY_RETRY_TIMES, this.mNetRetryTimes);
            jSONObject.put(AlaRecorderLog.KEY_CHAT_STATUS, this.mChatStatus);
            fillExtCommonData(jSONObject);
            logEvent(AlaRecorderLog.KEY_ID_2425, AlaRecorderLog.TYPE_ADKLIVECORE, "author_liveroom", AlaRecorderLog.VALUE_PUSH_STREAM, jSONObject);
        } catch (JSONException e) {
        }
        this.mNetRetryTimes++;
    }

    public void Br() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 20);
            jSONObject.put(AlaRecorderLog.KEY_RETRY_TIMES, this.mNetRetryTimes - 1);
            jSONObject.put(AlaRecorderLog.KEY_CHAT_STATUS, this.mChatStatus);
            jSONObject.put(AlaRecorderLog.KEY_COST_TIME, (int) (System.currentTimeMillis() - this.aBI));
            fillExtCommonData(jSONObject);
            logEvent(AlaRecorderLog.KEY_ID_2425, AlaRecorderLog.TYPE_ADKLIVECORE, "author_liveroom", AlaRecorderLog.VALUE_PUSH_STREAM, jSONObject);
        } catch (JSONException e) {
        }
    }

    public void Bs() {
        if (this.aBI != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.aBI;
            long currentTimeMillis2 = this.mLastNetBreakTimeMillis > 0 ? System.currentTimeMillis() - this.mLastNetBreakTimeMillis : 0L;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 30);
                jSONObject.put(AlaRecorderLog.KEY_RETRY_TIMES, this.mNetRetryTimes - 1);
                jSONObject.put(AlaRecorderLog.KEY_CHAT_STATUS, this.mChatStatus);
                jSONObject.put(AlaRecorderLog.KEY_COST_TIME, (int) currentTimeMillis);
                jSONObject.put(AlaRecorderLog.KEY_STREAM_SUSPEND_TIME, (int) currentTimeMillis2);
                fillExtCommonData(jSONObject);
                logEvent(AlaRecorderLog.KEY_ID_2425, AlaRecorderLog.TYPE_ADKLIVECORE, "author_liveroom", AlaRecorderLog.VALUE_PUSH_STREAM, jSONObject);
            } catch (JSONException e) {
            }
            this.aBI = 0L;
            this.mLastNetBreakTimeMillis = 0L;
        }
        com.baidu.live.alablmsdk.a.c.Bj().removeCallbacks(this.aBO);
    }

    public void dH(int i) {
        this.mLastNetBreakTimeMillis = System.currentTimeMillis();
        com.baidu.live.alablmsdk.a.c.Bj().removeCallbacks(this.aBO);
        com.baidu.live.alablmsdk.a.c.Bj().postDelayed(this.aBO, 10000L);
        onErrorEvent(110000 + i, "rtcerror " + i);
    }

    public void pushEnd() {
        com.baidu.live.alablmsdk.a.c.Bj().removeCallbacks(this.aBO);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 90);
            fillExtCommonData(jSONObject);
            logEvent(AlaRecorderLog.KEY_ID_2425, AlaRecorderLog.TYPE_ADKLIVECORE, "author_liveroom", AlaRecorderLog.VALUE_PUSH_STREAM, jSONObject);
        } catch (JSONException e) {
        }
        this.mCurProtocal = null;
        this.mPushStremInfoJson = null;
        this.mVideoResolution = null;
        this.mPushStreamType = 0;
    }

    public void onRecorderError(int i, String str) {
        if (AlaRecorderLog.Protocol.RTC.equals(this.mCurProtocal)) {
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

    public void markEnterForeground() {
        if (AlaRecorderLog.Protocol.RTC.equals(this.mCurProtocal)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 60);
                fillExtCommonData(jSONObject);
                logEvent(AlaRecorderLog.KEY_ID_2425, AlaRecorderLog.TYPE_ADKLIVECORE, "author_liveroom", AlaRecorderLog.VALUE_PUSH_STREAM, jSONObject);
            } catch (JSONException e) {
            }
        }
    }

    public void markEnterBackground() {
        if (AlaRecorderLog.Protocol.RTC.equals(this.mCurProtocal)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 50);
                fillExtCommonData(jSONObject);
                logEvent(AlaRecorderLog.KEY_ID_2425, AlaRecorderLog.TYPE_ADKLIVECORE, "author_liveroom", AlaRecorderLog.VALUE_PUSH_STREAM, jSONObject);
            } catch (JSONException e) {
            }
        }
    }

    private void fillExtCommonData(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, this.mPushResId);
            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_PROTOCOL, this.mCurProtocal);
            jSONObject.put(AlaRecorderLog.KEY_PUSH_STREAM_IP, this.mPushStreamIp);
            jSONObject.put(AlaRecorderLog.KEY_PUSH_STREAM_TYPE, this.mPushStreamType);
            if (this.mPushStremInfoJson == null) {
                this.mPushStremInfoJson = new JSONObject();
                this.mPushStremInfoJson.put(AlaRecorderLog.KEY_PUSH_STREAM_URL, this.mPushStreamUrl);
                this.mPushStremInfoJson.put(AlaRecorderLog.KEY_EXPECT_VIDEO_FPS_MAX, this.mExpectVideoFpsMax);
                this.mPushStremInfoJson.put(AlaRecorderLog.KEY_EXPECT_VIDEO_FPS_MIN, this.mExpectVideoFpsMin);
                this.mPushStremInfoJson.put(AlaRecorderLog.KEY_EXPECT_VIDEO_BITRATE_MAX, this.mExpectVideoBitrateMax);
                this.mPushStremInfoJson.put(AlaRecorderLog.KEY_EXPECT_VIDEO_BITRATE_MIN, this.mExpectVideoBitrateMin);
                this.mPushStremInfoJson.put(AlaRecorderLog.KEY_VIDEO_RESOLUTION, this.mVideoResolution);
                this.mPushStremInfoJson.put(AlaRecorderLog.KEY_AUDIO_SAMPLE, this.mAudioSample);
                this.mPushStremInfoJson.put(AlaRecorderLog.KEY_AUDIO_CHANNEL, this.mAudioChannel);
                this.mPushStremInfoJson.put(AlaRecorderLog.KEY_AUDIO_FPS, this.mAudioFps);
            }
            jSONObject.put(AlaRecorderLog.KEY_PUSH_STREAM_INFO, this.mPushStremInfoJson);
        }
    }

    public void setPushConfig(String str, String str2) {
        this.mCurProtocal = str;
        this.mNetRetryTimes = 0;
        this.mLastNetBreakTimeMillis = 0L;
        this.mPushStreamIp = null;
        if (this.mPushStreamUrl == null || !this.mPushStreamUrl.equals(str2)) {
            this.mPushStreamUrl = str2;
            this.mPushResId = getResId(str2);
        }
        com.baidu.live.alablmsdk.a.c.Bj().removeCallbacks(this.aBO);
    }

    public void bf(boolean z) {
        this.aBM = z;
    }

    public void d(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mExpectVideoFpsMax = i;
        this.mExpectVideoFpsMin = i2;
        this.mExpectVideoBitrateMax = i3;
        this.mExpectVideoBitrateMin = i4;
        this.mAudioSample = i5;
        this.mAudioChannel = i6;
        if (this.mAudioChannel != 0) {
            this.mAudioFps = this.mAudioSample / (this.mAudioChannel * 1024);
        }
        try {
            this.mPushStremInfoJson = new JSONObject();
            this.mPushStremInfoJson.put(AlaRecorderLog.KEY_PUSH_STREAM_URL, this.mPushStreamUrl);
            this.mPushStremInfoJson.put(AlaRecorderLog.KEY_EXPECT_VIDEO_FPS_MAX, this.mExpectVideoFpsMax);
            this.mPushStremInfoJson.put(AlaRecorderLog.KEY_EXPECT_VIDEO_FPS_MIN, this.mExpectVideoFpsMin);
            this.mPushStremInfoJson.put(AlaRecorderLog.KEY_EXPECT_VIDEO_BITRATE_MAX, this.mExpectVideoBitrateMax);
            this.mPushStremInfoJson.put(AlaRecorderLog.KEY_EXPECT_VIDEO_BITRATE_MIN, this.mExpectVideoBitrateMin);
            this.mPushStremInfoJson.put(AlaRecorderLog.KEY_VIDEO_RESOLUTION, this.mVideoResolution);
            this.mPushStremInfoJson.put(AlaRecorderLog.KEY_AUDIO_SAMPLE, this.mAudioSample);
            this.mPushStremInfoJson.put(AlaRecorderLog.KEY_AUDIO_CHANNEL, this.mAudioChannel);
            this.mPushStremInfoJson.put(AlaRecorderLog.KEY_AUDIO_FPS, this.mAudioFps);
        } catch (JSONException e) {
        }
    }

    public void setVideoSize(int i, int i2) {
        if (TextUtils.isEmpty(this.mVideoResolution)) {
            this.mVideoResolution = "" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i2;
            try {
                this.mPushStremInfoJson = new JSONObject();
                this.mPushStremInfoJson.put(AlaRecorderLog.KEY_PUSH_STREAM_URL, this.mPushStreamUrl);
                this.mPushStremInfoJson.put(AlaRecorderLog.KEY_EXPECT_VIDEO_FPS_MAX, this.mExpectVideoFpsMax);
                this.mPushStremInfoJson.put(AlaRecorderLog.KEY_EXPECT_VIDEO_FPS_MIN, this.mExpectVideoFpsMin);
                this.mPushStremInfoJson.put(AlaRecorderLog.KEY_EXPECT_VIDEO_BITRATE_MAX, this.mExpectVideoBitrateMax);
                this.mPushStremInfoJson.put(AlaRecorderLog.KEY_EXPECT_VIDEO_BITRATE_MIN, this.mExpectVideoBitrateMin);
                this.mPushStremInfoJson.put(AlaRecorderLog.KEY_VIDEO_RESOLUTION, this.mVideoResolution);
                this.mPushStremInfoJson.put(AlaRecorderLog.KEY_AUDIO_SAMPLE, this.mAudioSample);
                this.mPushStremInfoJson.put(AlaRecorderLog.KEY_AUDIO_CHANNEL, this.mAudioChannel);
                this.mPushStremInfoJson.put(AlaRecorderLog.KEY_AUDIO_FPS, this.mAudioFps);
            } catch (JSONException e) {
            }
        }
    }

    public void fJ(String str) {
        this.aBK = str;
    }

    public void setRtcRoomId(String str) {
        this.mRtcRoomId = str;
    }

    public void bg(boolean z) {
        this.mChatStatus = z ? 1 : 0;
    }

    public void dI(int i) {
        this.aBJ = i;
    }

    public void b(d dVar) {
        this.aBN = dVar;
    }

    private void ak(String str, String str2) {
        this.aBL = str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rtc_room_id", this.mRtcRoomId);
            jSONObject.put(AlaRecorderLog.KEY_RTC_SOURCE, this.aBK);
            if (str2 == AlaRecorderLog.Value.CLOSE_ROOM_CLK || str2 == AlaRecorderLog.Value.HANGOFF_CLK) {
                jSONObject.put(AlaRecorderLog.KEY_CHAT_STATUS, this.mChatStatus);
            }
            if (str2 == AlaRecorderLog.Value.JOIN_ROOM_REMOTE) {
                jSONObject.put("is_invite", this.aBJ);
            }
            fillExtCommonData(jSONObject);
            logEvent(AlaRecorderLog.KEY_ID_2427, str, "author_liveroom", str2, jSONObject);
        } catch (JSONException e) {
        }
    }

    public void Bt() {
        ak("click", AlaRecorderLog.Value.JOIN_CLK);
    }

    public void Bu() {
        ak("click", AlaRecorderLog.Value.INVITE_USER_CLK);
    }

    public void Bv() {
        ak("click", AlaRecorderLog.Value.INVITE_CANCEL_CLK);
    }

    public void Bw() {
        ak("notice", AlaRecorderLog.Value.USER_REJECT_REMOTE);
    }

    public void Bx() {
        ak("notice", AlaRecorderLog.Value.INVITE_TIMEOUT_REMOTE);
    }

    public void By() {
        ak("notice", AlaRecorderLog.Value.JOIN_ROOM_REMOTE);
    }

    public void Bz() {
        ak("click", AlaRecorderLog.Value.HANGOFF_CLK);
    }

    public void BA() {
        ak("click", AlaRecorderLog.Value.CLOSE_ROOM_CLK);
    }

    public void BB() {
        ak("click", AlaRecorderLog.Value.KICKOFF_CLK);
    }

    public void logEvent(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        if (this.aBN != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("type", str2);
                jSONObject2.put("page", str3);
                jSONObject2.put("value", str4);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
            } catch (JSONException e) {
            }
            if (a.isDebug()) {
                a.d("StructuredLog", " 结构化日志  id=" + str + " content=" + jSONObject2.toString() + " ext=" + jSONObject.toString());
            }
            this.aBN.onLogReport(str, jSONObject2, jSONObject);
        }
    }

    private String getResId(String str) {
        List<String> pathSegments;
        if (TextUtils.isEmpty(str) || (pathSegments = Uri.parse(str).getPathSegments()) == null || pathSegments.size() <= 0) {
            return null;
        }
        return pathSegments.get(pathSegments.size() - 1);
    }

    public void release() {
        this.aBN = null;
    }
}
