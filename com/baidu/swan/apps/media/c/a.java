package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.ubc.UBC;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int aAM;
    public String aAN;
    public int aAO;
    public int aAP;
    public int aAQ;
    public String aAR;

    public static a a(JSONObject jSONObject, a aVar) {
        if (jSONObject != null) {
            aVar = new a();
            aVar.aAM = jSONObject.optInt(UBC.CONTENT_KEY_DURATION, 60000);
            aVar.aAN = jSONObject.optString(IjkMediaMeta.IJKM_KEY_FORMAT);
            if (TextUtils.isEmpty(aVar.aAN)) {
                aVar.aAN = "aac";
            }
            aVar.aAO = jSONObject.optInt("numberOfChannels", 1);
            aVar.aAP = jSONObject.optInt("sampleRate", 8000);
            aVar.aAQ = jSONObject.optInt("encodeBitRate");
            if (aVar.aAQ == 0) {
                switch (aVar.aAP) {
                    case 8000:
                        aVar.aAQ = 16000;
                        break;
                    case 16000:
                        aVar.aAQ = 24000;
                        break;
                    case 44100:
                        aVar.aAQ = 64000;
                        break;
                }
            }
            aVar.aAR = jSONObject.optString("cb");
        }
        return aVar;
    }

    public JSONObject ED() {
        if (this.aAM > 600000 || this.aAM <= 0) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error duration");
        }
        if (this.aAO != 1 && this.aAO != 2) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error channels");
        }
        if (!TextUtils.equals(this.aAN, "aac") && !TextUtils.equals(this.aAN, "pcm")) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error format");
        }
        if (this.aAP != 8000 && this.aAP != 16000 && this.aAP != 44100) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error sampleRate");
        }
        if (!TextUtils.equals(this.aAN, "pcm")) {
            boolean z = false;
            switch (this.aAP) {
                case 8000:
                    if (this.aAQ > 48000 || this.aAQ < 16000) {
                        z = true;
                        break;
                    }
                    break;
                case 16000:
                    if (this.aAQ > 96000 || this.aAQ < 24000) {
                        z = true;
                        break;
                    }
                    break;
                case 44100:
                    if (this.aAQ > 320000 || this.aAQ < 64000) {
                        z = true;
                        break;
                    }
                    break;
            }
            if (z) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error bitRate");
            }
        }
        if (TextUtils.isEmpty(this.aAR)) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "none cb");
        }
        return null;
    }

    public String toString() {
        return "recordTime : " + this.aAM + "; channel : " + this.aAO + "; audioFormat : " + this.aAN + "; sampleRate : " + this.aAP + "; bitRate : " + this.aAQ + "; callbacks : " + this.aAR;
    }
}
