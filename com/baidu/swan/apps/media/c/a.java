package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.ubc.UBC;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int aAP;
    public String aAQ;
    public int aAR;
    public int aAS;
    public int aAT;
    public String aAU;

    public static a a(JSONObject jSONObject, a aVar) {
        if (jSONObject != null) {
            aVar = new a();
            aVar.aAP = jSONObject.optInt(UBC.CONTENT_KEY_DURATION, 60000);
            aVar.aAQ = jSONObject.optString(IjkMediaMeta.IJKM_KEY_FORMAT);
            if (TextUtils.isEmpty(aVar.aAQ)) {
                aVar.aAQ = "aac";
            }
            aVar.aAR = jSONObject.optInt("numberOfChannels", 1);
            aVar.aAS = jSONObject.optInt("sampleRate", 8000);
            aVar.aAT = jSONObject.optInt("encodeBitRate");
            if (aVar.aAT == 0) {
                switch (aVar.aAS) {
                    case 8000:
                        aVar.aAT = 16000;
                        break;
                    case 16000:
                        aVar.aAT = 24000;
                        break;
                    case 44100:
                        aVar.aAT = 64000;
                        break;
                }
            }
            aVar.aAU = jSONObject.optString("cb");
        }
        return aVar;
    }

    public JSONObject EB() {
        if (this.aAP > 600000 || this.aAP <= 0) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error duration");
        }
        if (this.aAR != 1 && this.aAR != 2) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error channels");
        }
        if (!TextUtils.equals(this.aAQ, "aac") && !TextUtils.equals(this.aAQ, "pcm")) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error format");
        }
        if (this.aAS != 8000 && this.aAS != 16000 && this.aAS != 44100) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error sampleRate");
        }
        if (!TextUtils.equals(this.aAQ, "pcm")) {
            boolean z = false;
            switch (this.aAS) {
                case 8000:
                    if (this.aAT > 48000 || this.aAT < 16000) {
                        z = true;
                        break;
                    }
                    break;
                case 16000:
                    if (this.aAT > 96000 || this.aAT < 24000) {
                        z = true;
                        break;
                    }
                    break;
                case 44100:
                    if (this.aAT > 320000 || this.aAT < 64000) {
                        z = true;
                        break;
                    }
                    break;
            }
            if (z) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error bitRate");
            }
        }
        if (TextUtils.isEmpty(this.aAU)) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "none cb");
        }
        return null;
    }

    public String toString() {
        return "recordTime : " + this.aAP + "; channel : " + this.aAR + "; audioFormat : " + this.aAQ + "; sampleRate : " + this.aAS + "; bitRate : " + this.aAT + "; callbacks : " + this.aAU;
    }
}
