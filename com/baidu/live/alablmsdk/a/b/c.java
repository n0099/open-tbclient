package com.baidu.live.alablmsdk.a.b;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    private static final c ayj = new c();
    private String ayp;
    private String ayq;
    private String ayr;
    private d ayv;
    private int mAudioChannel;
    private int mAudioFps;
    private int mAudioSample;
    private int mExpectVideoBitrateMax;
    private int mExpectVideoBitrateMin;
    private int mExpectVideoFpsMax;
    private int mExpectVideoFpsMin;
    private long mLastNetBreakTimeMillis;
    private String mPushResId;
    private String mPushStreamIp;
    private int mPushStreamType;
    private String mPushStreamUrl;
    private JSONObject mPushStremInfoJson;
    private String mRtcRoomId;
    private String mVideoResolution;
    private String mCurProtocal = null;
    private int mChatStatus = 0;
    private int ayo = 0;
    private String ays = null;
    private boolean ayt = false;
    private boolean ayu = false;
    private Runnable ayw = new Runnable() { // from class: com.baidu.live.alablmsdk.a.b.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.onStreamBreak(1, "rtc stream interupt 10s");
        }
    };
    private a ayk = new a();
    private a ayl = new a();
    private a aym = new a();
    private a ayn = new a();

    private c() {
    }

    public static c xx() {
        return ayj;
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

    public void xy() {
        this.ayk.ayA = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 10);
            jSONObject.put(AlaRecorderLog.KEY_RETRY_TIMES, this.ayk.ayy);
            jSONObject.put("success_times", this.ayk.ayz);
            jSONObject.put(AlaRecorderLog.KEY_CHAT_STATUS, this.mChatStatus);
            fillExtCommonData(jSONObject);
            logEvent(AlaRecorderLog.KEY_ID_2425, AlaRecorderLog.TYPE_ADKLIVECORE, "author_liveroom", AlaRecorderLog.VALUE_PUSH_STREAM, jSONObject);
        } catch (JSONException e) {
        }
        a.c(this.ayk);
    }

    public void xz() {
        if (this.ayk.ayA != 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 20);
                jSONObject.put(AlaRecorderLog.KEY_RETRY_TIMES, this.ayk.ayy - 1);
                jSONObject.put("success_times", this.ayk.ayz);
                jSONObject.put(AlaRecorderLog.KEY_CHAT_STATUS, this.mChatStatus);
                jSONObject.put(AlaRecorderLog.KEY_COST_TIME, (int) (System.currentTimeMillis() - this.ayk.ayA));
                fillExtCommonData(jSONObject);
                logEvent(AlaRecorderLog.KEY_ID_2425, AlaRecorderLog.TYPE_ADKLIVECORE, "author_liveroom", AlaRecorderLog.VALUE_PUSH_STREAM, jSONObject);
            } catch (JSONException e) {
            }
            this.ayk.ayA = 0L;
            a.e(this.ayk);
        }
    }

    public void xA() {
        this.ayl.ayA = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 11);
            jSONObject.put(AlaRecorderLog.KEY_RETRY_TIMES, this.ayl.ayy);
            jSONObject.put("success_times", this.ayl.ayz);
            jSONObject.put(AlaRecorderLog.KEY_CHAT_STATUS, this.mChatStatus);
            fillExtCommonData(jSONObject);
            logEvent(AlaRecorderLog.KEY_ID_2425, AlaRecorderLog.TYPE_ADKLIVECORE, "author_liveroom", AlaRecorderLog.VALUE_PUSH_STREAM, jSONObject);
        } catch (JSONException e) {
        }
        a.c(this.ayl);
    }

    public void xB() {
        if (this.ayl.ayA != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.ayl.ayA;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 30);
                jSONObject.put(AlaRecorderLog.KEY_RETRY_TIMES, this.ayl.ayy - 1);
                jSONObject.put("success_times", this.ayl.ayz);
                jSONObject.put(AlaRecorderLog.KEY_CHAT_STATUS, this.mChatStatus);
                jSONObject.put(AlaRecorderLog.KEY_COST_TIME, (int) currentTimeMillis);
                fillExtCommonData(jSONObject);
                logEvent(AlaRecorderLog.KEY_ID_2425, AlaRecorderLog.TYPE_ADKLIVECORE, "author_liveroom", AlaRecorderLog.VALUE_PUSH_STREAM, jSONObject);
            } catch (JSONException e) {
            }
            a.e(this.ayl);
            this.ayl.ayA = 0L;
            this.mLastNetBreakTimeMillis = 0L;
        }
        com.baidu.live.alablmsdk.a.c.xr().removeCallbacks(this.ayw);
    }

    public void xC() {
        if (this.ayl.ayA != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.ayl.ayA;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 12);
                jSONObject.put(AlaRecorderLog.KEY_RETRY_TIMES, this.ayl.ayy - 1);
                jSONObject.put("success_times", this.ayl.ayz);
                jSONObject.put(AlaRecorderLog.KEY_CHAT_STATUS, this.mChatStatus);
                jSONObject.put(AlaRecorderLog.KEY_COST_TIME, (int) currentTimeMillis);
                fillExtCommonData(jSONObject);
                logEvent(AlaRecorderLog.KEY_ID_2425, AlaRecorderLog.TYPE_ADKLIVECORE, "author_liveroom", AlaRecorderLog.VALUE_PUSH_STREAM, jSONObject);
            } catch (JSONException e) {
            }
        }
        com.baidu.live.alablmsdk.a.c.xr().removeCallbacks(this.ayw);
    }

    public void eH(String str) {
        a aVar;
        if (UbcStatConstant.KEY_CONTENT_ROOM.equals(str)) {
            aVar = this.ayn;
        } else {
            aVar = this.aym;
        }
        aVar.ayA = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 13);
            jSONObject.put("trans_type", str);
            jSONObject.put(AlaRecorderLog.KEY_RETRY_TIMES, aVar.ayy);
            jSONObject.put("success_times", aVar.ayz);
            jSONObject.put(AlaRecorderLog.KEY_CHAT_STATUS, this.mChatStatus);
            fillExtCommonData(jSONObject);
            logEvent(AlaRecorderLog.KEY_ID_2425, AlaRecorderLog.TYPE_ADKLIVECORE, "author_liveroom", AlaRecorderLog.VALUE_PUSH_STREAM, jSONObject);
        } catch (JSONException e) {
        }
        a.c(aVar);
    }

    public void eI(String str) {
        a aVar;
        if (UbcStatConstant.KEY_CONTENT_ROOM.equals(str)) {
            aVar = this.ayn;
        } else {
            aVar = this.aym;
        }
        if (aVar.ayA != 0) {
            long currentTimeMillis = System.currentTimeMillis() - aVar.ayA;
            long currentTimeMillis2 = this.mLastNetBreakTimeMillis > 0 ? System.currentTimeMillis() - this.mLastNetBreakTimeMillis : 0L;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 31);
                jSONObject.put("trans_type", str);
                jSONObject.put(AlaRecorderLog.KEY_RETRY_TIMES, aVar.ayy - 1);
                jSONObject.put("success_times", aVar.ayz);
                jSONObject.put(AlaRecorderLog.KEY_CHAT_STATUS, this.mChatStatus);
                jSONObject.put(AlaRecorderLog.KEY_COST_TIME, (int) currentTimeMillis);
                jSONObject.put(AlaRecorderLog.KEY_STREAM_SUSPEND_TIME, (int) currentTimeMillis2);
                fillExtCommonData(jSONObject);
                logEvent(AlaRecorderLog.KEY_ID_2425, AlaRecorderLog.TYPE_ADKLIVECORE, "author_liveroom", AlaRecorderLog.VALUE_PUSH_STREAM, jSONObject);
            } catch (JSONException e) {
            }
            aVar.ayA = 0L;
            a.e(aVar);
            this.mLastNetBreakTimeMillis = 0L;
        }
        com.baidu.live.alablmsdk.a.c.xr().removeCallbacks(this.ayw);
    }

    public void eJ(String str) {
        a aVar;
        if (UbcStatConstant.KEY_CONTENT_ROOM.equals(str)) {
            aVar = this.ayn;
        } else {
            aVar = this.aym;
        }
        if (aVar.ayA != 0) {
            long currentTimeMillis = System.currentTimeMillis() - aVar.ayA;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 14);
                jSONObject.put("trans_type", str);
                jSONObject.put(AlaRecorderLog.KEY_RETRY_TIMES, aVar.ayy - 1);
                jSONObject.put("success_times", aVar.ayz);
                jSONObject.put(AlaRecorderLog.KEY_CHAT_STATUS, this.mChatStatus);
                jSONObject.put(AlaRecorderLog.KEY_COST_TIME, (int) currentTimeMillis);
                fillExtCommonData(jSONObject);
                logEvent(AlaRecorderLog.KEY_ID_2425, AlaRecorderLog.TYPE_ADKLIVECORE, "author_liveroom", AlaRecorderLog.VALUE_PUSH_STREAM, jSONObject);
            } catch (JSONException e) {
            }
        }
        com.baidu.live.alablmsdk.a.c.xr().removeCallbacks(this.ayw);
    }

    public void cc(int i) {
        this.mLastNetBreakTimeMillis = System.currentTimeMillis();
        com.baidu.live.alablmsdk.a.c.xr().removeCallbacks(this.ayw);
        com.baidu.live.alablmsdk.a.c.xr().postDelayed(this.ayw, 10000L);
        onErrorEvent(110000 + i, "rtcerror " + i);
    }

    public void xD() {
        com.baidu.live.alablmsdk.a.c.xr().removeCallbacks(this.ayw);
    }

    public void pushEnd() {
        com.baidu.live.alablmsdk.a.c.xr().removeCallbacks(this.ayw);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaRecorderLog.KEY_CURRENT_STAGE, 90);
            fillExtCommonData(jSONObject);
            logEvent(AlaRecorderLog.KEY_ID_2425, AlaRecorderLog.TYPE_ADKLIVECORE, "author_liveroom", AlaRecorderLog.VALUE_PUSH_STREAM, jSONObject);
        } catch (JSONException e) {
        }
        this.ayk.reset();
        this.ayl.reset();
        this.aym.reset();
        this.ayn.reset();
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
            jSONObject.put("rtc_sdk_type", this.ayq);
            jSONObject.put("rtc_sdk_version", this.ayr);
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
        this.mLastNetBreakTimeMillis = 0L;
        this.mPushStreamIp = null;
        if (this.mPushStreamUrl == null || !this.mPushStreamUrl.equals(str2)) {
            this.mPushStreamUrl = str2;
            if (TextUtils.isEmpty(this.mPushResId)) {
                this.mPushResId = getResId(str2);
            }
        }
        com.baidu.live.alablmsdk.a.c.xr().removeCallbacks(this.ayw);
    }

    public void eK(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mPushResId = str;
        }
    }

    public void bb(boolean z) {
        this.ayt = z;
    }

    public void e(int i, int i2, int i3, int i4, int i5, int i6) {
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

    public void eL(String str) {
        this.ayp = str;
    }

    public void eM(String str) {
        this.ayq = str;
    }

    public void eN(String str) {
        this.ayr = str;
    }

    public void setRtcRoomId(String str) {
        this.mRtcRoomId = str;
    }

    public void bc(boolean z) {
        this.mChatStatus = z ? 1 : 0;
    }

    public void cd(int i) {
        this.ayo = i;
    }

    public boolean xE() {
        return this.ayu;
    }

    public void bd(boolean z) {
        this.ayu = z;
    }

    public void b(d dVar) {
        this.ayv = dVar;
    }

    private void ah(String str, String str2) {
        this.ays = str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rtc_room_id", this.mRtcRoomId);
            jSONObject.put(AlaRecorderLog.KEY_RTC_SOURCE, this.ayp);
            if (str2 == AlaRecorderLog.Value.CLOSE_ROOM_CLK || str2 == AlaRecorderLog.Value.HANGOFF_CLK) {
                jSONObject.put(AlaRecorderLog.KEY_CHAT_STATUS, this.mChatStatus);
            }
            if (str2 == AlaRecorderLog.Value.JOIN_ROOM_REMOTE) {
                jSONObject.put("is_invite", this.ayo);
            }
            fillExtCommonData(jSONObject);
            logEvent(AlaRecorderLog.KEY_ID_2427, str, "author_liveroom", str2, jSONObject);
        } catch (JSONException e) {
        }
    }

    public void xF() {
        ah("click", AlaRecorderLog.Value.JOIN_CLK);
    }

    public void xG() {
        ah("click", AlaRecorderLog.Value.INVITE_USER_CLK);
    }

    public void xH() {
        ah("click", AlaRecorderLog.Value.INVITE_CANCEL_CLK);
    }

    public void xI() {
        ah("notice", AlaRecorderLog.Value.USER_REJECT_REMOTE);
    }

    public void xJ() {
        ah("notice", AlaRecorderLog.Value.INVITE_TIMEOUT_REMOTE);
    }

    public void xK() {
        ah("notice", AlaRecorderLog.Value.JOIN_ROOM_REMOTE);
    }

    public void xL() {
        ah("click", AlaRecorderLog.Value.HANGOFF_CLK);
    }

    public void xM() {
        ah("click", AlaRecorderLog.Value.CLOSE_ROOM_CLK);
    }

    public void xN() {
        ah("click", AlaRecorderLog.Value.KICKOFF_CLK);
    }

    public void logEvent(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (this.ayv != null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("type", str2);
                jSONObject3.put("page", str3);
                jSONObject3.put("value", str4);
                jSONObject2 = jSONObject == null ? new JSONObject() : jSONObject;
                try {
                    jSONObject2.put("long_conn", xx().xE());
                } catch (JSONException e) {
                }
            } catch (JSONException e2) {
                jSONObject2 = jSONObject;
            }
            if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                com.baidu.live.alablmsdk.a.b.a.d("StructuredLog", " 结构化日志  id=" + str + " content=" + jSONObject3.toString() + " ext=" + jSONObject2.toString());
            }
            this.ayv.onLogReport(str, jSONObject3, jSONObject2);
        }
    }

    private String getResId(String str) {
        List<String> pathSegments;
        if (TextUtils.isEmpty(str) || (pathSegments = Uri.parse(str).getPathSegments()) == null || pathSegments.size() <= 0) {
            return null;
        }
        return pathSegments.get(pathSegments.size() - 1);
    }

    /* loaded from: classes10.dex */
    class a {
        private int ayy = 0;
        private int ayz = 0;
        private long ayA = 0;

        a() {
        }

        static /* synthetic */ int c(a aVar) {
            int i = aVar.ayy;
            aVar.ayy = i + 1;
            return i;
        }

        static /* synthetic */ int e(a aVar) {
            int i = aVar.ayz;
            aVar.ayz = i + 1;
            return i;
        }

        public void reset() {
            this.ayy = 0;
            this.ayz = 0;
            this.ayA = 0L;
        }
    }

    public void release() {
        this.ayv = null;
    }
}
