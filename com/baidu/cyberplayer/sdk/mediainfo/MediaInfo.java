package com.baidu.cyberplayer.sdk.mediainfo;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.utils.NumberUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MediaInfo {
    public static final String DPM_KEY_AUDIO_CODEC_NAME = "audio_codec_name";
    public static final String DPM_KEY_AVG_FPS = "avg_fps";
    public static final String DPM_KEY_BITRATE = "bitrate";
    public static final String DPM_KEY_CODEC_AUDIO_BITRATE = "audio_bitrate";
    public static final String DPM_KEY_CODEC_VIDEO_BITRATE = "video_bitrate";
    public static final String DPM_KEY_VIDEO_CODEC_NAME = "video_codec_name";
    public static final int VALUE_UNKNOWN = -1;
    public String mMediaInfoJson;
    public int mBitRate = -1;
    public int mVideoBitRate = -1;
    public int mAudioBitRate = -1;
    public int mVideoFrameRate = -1;
    public String mVideoCodecName = "";
    public String mAudioCodecName = "";

    @Keep
    public int getAudioBitRate() {
        return this.mAudioBitRate;
    }

    @Keep
    public String getAudioCodecName() {
        return this.mAudioCodecName;
    }

    @Keep
    public int getBitRate() {
        return this.mBitRate;
    }

    @Keep
    public int getVideoBitRate() {
        return this.mVideoBitRate;
    }

    @Keep
    public String getVideoCodecName() {
        return this.mVideoCodecName;
    }

    @Keep
    public int getVideoFrameRate() {
        return this.mVideoFrameRate;
    }

    public void setMediaInfoJson(String str) {
        this.mMediaInfoJson = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mMediaInfoJson);
            this.mBitRate = NumberUtils.parseIntSafely(jSONObject.optString(DPM_KEY_BITRATE), -1);
            this.mVideoBitRate = NumberUtils.parseIntSafely(jSONObject.optString(DPM_KEY_CODEC_VIDEO_BITRATE), -1);
            this.mAudioBitRate = NumberUtils.parseIntSafely(jSONObject.optString(DPM_KEY_CODEC_AUDIO_BITRATE), -1);
            this.mVideoFrameRate = NumberUtils.parseIntSafely(jSONObject.optString(DPM_KEY_AVG_FPS), -1);
            this.mVideoCodecName = jSONObject.optString(DPM_KEY_VIDEO_CODEC_NAME);
            this.mAudioCodecName = jSONObject.optString(DPM_KEY_AUDIO_CODEC_NAME);
        } catch (Exception unused) {
        }
    }
}
