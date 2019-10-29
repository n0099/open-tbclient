package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.ala.livePlayer.StreamConfig;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int aWh;
    public String aWi;
    public int aWj;
    public int aWk;
    public int aWl;
    public String aWm;

    public static a a(JSONObject jSONObject, a aVar) {
        if (jSONObject != null) {
            aVar = new a();
            aVar.aWh = jSONObject.optInt("duration", 60000);
            aVar.aWi = jSONObject.optString(IjkMediaMeta.IJKM_KEY_FORMAT);
            if (TextUtils.isEmpty(aVar.aWi)) {
                aVar.aWi = "aac";
            }
            aVar.aWj = jSONObject.optInt("numberOfChannels", 1);
            aVar.aWk = jSONObject.optInt("sampleRate", 8000);
            aVar.aWl = jSONObject.optInt("encodeBitRate");
            if (aVar.aWl == 0) {
                switch (aVar.aWk) {
                    case 8000:
                        aVar.aWl = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_16K;
                        break;
                    case StreamConfig.Audio.AUDIO_RTC_FREQUENCY_16K /* 16000 */:
                        aVar.aWl = 24000;
                        break;
                    case StreamConfig.Audio.AUDIO_FREQUENCY /* 44100 */:
                        aVar.aWl = 64000;
                        break;
                }
            }
            aVar.aWm = jSONObject.optString("cb");
        }
        return aVar;
    }

    public JSONObject Mf() {
        if (this.aWh > 600000 || this.aWh <= 0) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error duration");
        }
        if (this.aWj != 1 && this.aWj != 2) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error channels");
        }
        if (!TextUtils.equals(this.aWi, "aac") && !TextUtils.equals(this.aWi, "pcm")) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error format");
        }
        if (this.aWk != 8000 && this.aWk != 16000 && this.aWk != 44100) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error sampleRate");
        }
        if (!TextUtils.equals(this.aWi, "pcm")) {
            boolean z = false;
            switch (this.aWk) {
                case 8000:
                    if (this.aWl > 48000 || this.aWl < 16000) {
                        z = true;
                        break;
                    }
                    break;
                case StreamConfig.Audio.AUDIO_RTC_FREQUENCY_16K /* 16000 */:
                    if (this.aWl > 96000 || this.aWl < 24000) {
                        z = true;
                        break;
                    }
                    break;
                case StreamConfig.Audio.AUDIO_FREQUENCY /* 44100 */:
                    if (this.aWl > 320000 || this.aWl < 64000) {
                        z = true;
                        break;
                    }
                    break;
            }
            if (z) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error bitRate");
            }
        }
        if (TextUtils.isEmpty(this.aWm)) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "none cb");
        }
        return null;
    }

    public String toString() {
        return "recordTime : " + this.aWh + "; channel : " + this.aWj + "; audioFormat : " + this.aWi + "; sampleRate : " + this.aWk + "; bitRate : " + this.aWl + "; callbacks : " + this.aWm;
    }
}
