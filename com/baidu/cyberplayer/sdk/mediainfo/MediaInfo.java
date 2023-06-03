package com.baidu.cyberplayer.sdk.mediainfo;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.utils.c;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MediaInfo {
    public String a;
    public int b = -1;
    public int c = -1;
    public int d = -1;
    public int e = -1;
    public String f = "";
    public String g = "";

    @Keep
    public int getAudioBitRate() {
        return this.d;
    }

    @Keep
    public String getAudioCodecName() {
        return this.g;
    }

    @Keep
    public int getBitRate() {
        return this.b;
    }

    @Keep
    public int getVideoBitRate() {
        return this.c;
    }

    @Keep
    public String getVideoCodecName() {
        return this.f;
    }

    @Keep
    public int getVideoFrameRate() {
        return this.e;
    }

    public void a(String str) {
        this.a = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.a);
            this.b = c.a(jSONObject.optString("bitrate"), -1);
            this.c = c.a(jSONObject.optString("video_bitrate"), -1);
            this.d = c.a(jSONObject.optString("audio_bitrate"), -1);
            this.e = c.a(jSONObject.optString("avg_fps"), -1);
            this.f = jSONObject.optString("video_codec_name");
            this.g = jSONObject.optString("audio_codec_name");
        } catch (Exception unused) {
        }
    }
}
