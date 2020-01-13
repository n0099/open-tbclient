package com.baidu.swan.apps.media.b;

import android.text.TextUtils;
import com.baidu.ala.player.StreamConfig;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes10.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bzr;
    public int bzn = 60000;
    public String bzo = "aac";
    public int bzp = 1;
    public int sampleRate = 8000;
    public int bitRate = 16000;
    public int bzq = 1;

    public static a a(JSONObject jSONObject, a aVar) {
        if (jSONObject != null && jSONObject.length() > 0) {
            aVar = new a();
            aVar.bzn = jSONObject.optInt("duration", 60000);
            aVar.bzo = jSONObject.optString(IjkMediaMeta.IJKM_KEY_FORMAT);
            if (TextUtils.isEmpty(aVar.bzo)) {
                aVar.bzo = "aac";
            }
            aVar.bzp = jSONObject.optInt("numberOfChannels", 1);
            aVar.sampleRate = jSONObject.optInt("sampleRate", 8000);
            aVar.bitRate = jSONObject.optInt("encodeBitRate");
            if (aVar.bitRate == 0) {
                switch (aVar.sampleRate) {
                    case 8000:
                        aVar.bitRate = 16000;
                        break;
                    case 16000:
                        aVar.bitRate = 24000;
                        break;
                    case StreamConfig.Audio.AUDIO_FREQUENCY /* 44100 */:
                        aVar.bitRate = 64000;
                        break;
                }
            }
            aVar.bzq = iZ(jSONObject.optString("audioSource", "auto"));
            aVar.bzr = jSONObject.optString("cb");
        }
        return aVar;
    }

    public JSONObject VC() {
        if (this.bzn > 600000 || this.bzn < 0) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error duration");
        }
        if (this.bzp != 1 && this.bzp != 2) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error channels");
        }
        if (!TextUtils.equals(this.bzo, "aac") && !TextUtils.equals(this.bzo, "pcm")) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error format");
        }
        if (this.sampleRate != 8000 && this.sampleRate != 16000 && this.sampleRate != 44100) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error sampleRate");
        }
        if (!TextUtils.equals(this.bzo, "pcm")) {
            boolean z = false;
            switch (this.sampleRate) {
                case 8000:
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
                case StreamConfig.Audio.AUDIO_FREQUENCY /* 44100 */:
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
        if (this.bzq < 0) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error audioSource");
        }
        return null;
    }

    public String toString() {
        return "recordTime : " + this.bzn + "; channel : " + this.bzp + "; audioFormat : " + this.bzo + "; sampleRate : " + this.sampleRate + "; bitRate : " + this.bitRate + "; callbacks : " + this.bzr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int iZ(String str) {
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
