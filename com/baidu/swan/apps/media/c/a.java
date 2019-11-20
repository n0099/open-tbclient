package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.ala.livePlayer.StreamConfig;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int aVP;
    public String aVQ;
    public int aVR;
    public int aVS;
    public int aVT;
    public String aVU;

    public static a a(JSONObject jSONObject, a aVar) {
        if (jSONObject != null) {
            aVar = new a();
            aVar.aVP = jSONObject.optInt("duration", 60000);
            aVar.aVQ = jSONObject.optString(IjkMediaMeta.IJKM_KEY_FORMAT);
            if (TextUtils.isEmpty(aVar.aVQ)) {
                aVar.aVQ = "aac";
            }
            aVar.aVR = jSONObject.optInt("numberOfChannels", 1);
            aVar.aVS = jSONObject.optInt("sampleRate", 8000);
            aVar.aVT = jSONObject.optInt("encodeBitRate");
            if (aVar.aVT == 0) {
                switch (aVar.aVS) {
                    case 8000:
                        aVar.aVT = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_16K;
                        break;
                    case StreamConfig.Audio.AUDIO_RTC_FREQUENCY_16K /* 16000 */:
                        aVar.aVT = 24000;
                        break;
                    case StreamConfig.Audio.AUDIO_FREQUENCY /* 44100 */:
                        aVar.aVT = 64000;
                        break;
                }
            }
            aVar.aVU = jSONObject.optString("cb");
        }
        return aVar;
    }

    public JSONObject Mg() {
        if (this.aVP > 600000 || this.aVP <= 0) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error duration");
        }
        if (this.aVR != 1 && this.aVR != 2) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error channels");
        }
        if (!TextUtils.equals(this.aVQ, "aac") && !TextUtils.equals(this.aVQ, "pcm")) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error format");
        }
        if (this.aVS != 8000 && this.aVS != 16000 && this.aVS != 44100) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error sampleRate");
        }
        if (!TextUtils.equals(this.aVQ, "pcm")) {
            boolean z = false;
            switch (this.aVS) {
                case 8000:
                    if (this.aVT > 48000 || this.aVT < 16000) {
                        z = true;
                        break;
                    }
                    break;
                case StreamConfig.Audio.AUDIO_RTC_FREQUENCY_16K /* 16000 */:
                    if (this.aVT > 96000 || this.aVT < 24000) {
                        z = true;
                        break;
                    }
                    break;
                case StreamConfig.Audio.AUDIO_FREQUENCY /* 44100 */:
                    if (this.aVT > 320000 || this.aVT < 64000) {
                        z = true;
                        break;
                    }
                    break;
            }
            if (z) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error bitRate");
            }
        }
        if (TextUtils.isEmpty(this.aVU)) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "none cb");
        }
        return null;
    }

    public String toString() {
        return "recordTime : " + this.aVP + "; channel : " + this.aVR + "; audioFormat : " + this.aVQ + "; sampleRate : " + this.aVS + "; bitRate : " + this.aVT + "; callbacks : " + this.aVU;
    }
}
