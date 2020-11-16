package com.baidu.swan.apps.media.a;

import android.text.TextUtils;
import com.baidu.ala.recorder.video.hardware.AudioEncoderCore;
import com.baidu.searchbox.ugc.transcoder.TranscoderPlugin;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String dct;
    public int dcr = 60000;
    public String dcs = TranscoderPlugin.AUDIO_CODEC;
    public int channel = 1;
    public int sampleRate = CoolPraiseGuideLottieView.ANIM_DURATION;
    public int bitRate = 16000;
    public int audioSource = 1;

    public static a a(JSONObject jSONObject, a aVar) {
        if (jSONObject != null && jSONObject.length() > 0) {
            aVar = new a();
            aVar.dcr = jSONObject.optInt("duration", 60000);
            aVar.dcs = jSONObject.optString("format");
            if (TextUtils.isEmpty(aVar.dcs)) {
                aVar.dcs = TranscoderPlugin.AUDIO_CODEC;
            }
            aVar.channel = jSONObject.optInt("numberOfChannels", 1);
            aVar.sampleRate = jSONObject.optInt("sampleRate", CoolPraiseGuideLottieView.ANIM_DURATION);
            aVar.bitRate = jSONObject.optInt("encodeBitRate");
            if (aVar.bitRate == 0) {
                switch (aVar.sampleRate) {
                    case CoolPraiseGuideLottieView.ANIM_DURATION /* 8000 */:
                        aVar.bitRate = 16000;
                        break;
                    case 16000:
                        aVar.bitRate = 24000;
                        break;
                    case 44100:
                        aVar.bitRate = AudioEncoderCore.EncodeConfig.BIT_RATE;
                        break;
                }
            }
            aVar.audioSource = qc(jSONObject.optString("audioSource", "auto"));
            aVar.dct = jSONObject.optString("cb");
        }
        return aVar;
    }

    public JSONObject aAD() {
        if (this.dcr > 600000 || this.dcr < 0) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error duration");
        }
        if (this.channel != 1 && this.channel != 2) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error channels");
        }
        if (!TextUtils.equals(this.dcs, TranscoderPlugin.AUDIO_CODEC) && !TextUtils.equals(this.dcs, "pcm")) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error format");
        }
        if (this.sampleRate != 8000 && this.sampleRate != 16000 && this.sampleRate != 44100) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error sampleRate");
        }
        if (!TextUtils.equals(this.dcs, "pcm")) {
            boolean z = false;
            switch (this.sampleRate) {
                case CoolPraiseGuideLottieView.ANIM_DURATION /* 8000 */:
                    if (this.bitRate > 48000 || this.bitRate < 16000) {
                        z = true;
                        break;
                    }
                    break;
                case 16000:
                    if (this.bitRate > 96000 || this.bitRate < 24000) {
                        z = true;
                        break;
                    }
                    break;
                case 44100:
                    if (this.bitRate > 320000 || this.bitRate < 64000) {
                        z = true;
                        break;
                    }
                    break;
            }
            if (z) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error bitRate");
            }
        }
        if (this.audioSource < 0) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error audioSource");
        }
        return null;
    }

    public String toString() {
        return "recordTime : " + this.dcr + "; channel : " + this.channel + "; audioFormat : " + this.dcs + "; sampleRate : " + this.sampleRate + "; bitRate : " + this.bitRate + "; callbacks : " + this.dct;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int qc(String str) {
        char c;
        switch (str.hashCode()) {
            case -401509030:
                if (str.equals("camcorder")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 108103:
                if (str.equals("mic")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1059882026:
                if (str.equals("voice_recognition")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1611170697:
                if (str.equals("voice_communication")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
                return 1;
            case 2:
                return 5;
            case 3:
                return 7;
            case 4:
                return 6;
            default:
                return -1;
        }
    }
}
