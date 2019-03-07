package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.c;
import com.baidu.ubc.UBC;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = c.DEBUG;
    public int aAL;
    public String aAM;
    public int aAN;
    public int aAO;
    public int aAP;
    public String aAQ;

    public static a a(JSONObject jSONObject, a aVar) {
        if (jSONObject != null) {
            aVar = new a();
            aVar.aAL = jSONObject.optInt(UBC.CONTENT_KEY_DURATION, 60000);
            aVar.aAM = jSONObject.optString(IjkMediaMeta.IJKM_KEY_FORMAT);
            if (TextUtils.isEmpty(aVar.aAM)) {
                aVar.aAM = "aac";
            }
            aVar.aAN = jSONObject.optInt("numberOfChannels", 1);
            aVar.aAO = jSONObject.optInt("sampleRate", 8000);
            aVar.aAP = jSONObject.optInt("encodeBitRate");
            if (aVar.aAP == 0) {
                switch (aVar.aAO) {
                    case 8000:
                        aVar.aAP = 16000;
                        break;
                    case 16000:
                        aVar.aAP = 24000;
                        break;
                    case 44100:
                        aVar.aAP = 64000;
                        break;
                }
            }
            aVar.aAQ = jSONObject.optString("cb");
        }
        return aVar;
    }

    public JSONObject ED() {
        if (this.aAL > 600000 || this.aAL <= 0) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error duration");
        }
        if (this.aAN != 1 && this.aAN != 2) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error channels");
        }
        if (!TextUtils.equals(this.aAM, "aac") && !TextUtils.equals(this.aAM, "pcm")) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error format");
        }
        if (this.aAO != 8000 && this.aAO != 16000 && this.aAO != 44100) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error sampleRate");
        }
        if (!TextUtils.equals(this.aAM, "pcm")) {
            boolean z = false;
            switch (this.aAO) {
                case 8000:
                    if (this.aAP > 48000 || this.aAP < 16000) {
                        z = true;
                        break;
                    }
                    break;
                case 16000:
                    if (this.aAP > 96000 || this.aAP < 24000) {
                        z = true;
                        break;
                    }
                    break;
                case 44100:
                    if (this.aAP > 320000 || this.aAP < 64000) {
                        z = true;
                        break;
                    }
                    break;
            }
            if (z) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error bitRate");
            }
        }
        if (TextUtils.isEmpty(this.aAQ)) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "none cb");
        }
        return null;
    }

    public String toString() {
        return "recordTime : " + this.aAL + "; channel : " + this.aAN + "; audioFormat : " + this.aAM + "; sampleRate : " + this.aAO + "; bitRate : " + this.aAP + "; callbacks : " + this.aAQ;
    }
}
