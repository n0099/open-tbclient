package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.ubc.UBC;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int aAQ;
    public String aAR;
    public int aAS;
    public int aAT;
    public int aAU;
    public String aAV;

    public static a a(JSONObject jSONObject, a aVar) {
        if (jSONObject != null) {
            aVar = new a();
            aVar.aAQ = jSONObject.optInt(UBC.CONTENT_KEY_DURATION, 60000);
            aVar.aAR = jSONObject.optString(IjkMediaMeta.IJKM_KEY_FORMAT);
            if (TextUtils.isEmpty(aVar.aAR)) {
                aVar.aAR = "aac";
            }
            aVar.aAS = jSONObject.optInt("numberOfChannels", 1);
            aVar.aAT = jSONObject.optInt("sampleRate", 8000);
            aVar.aAU = jSONObject.optInt("encodeBitRate");
            if (aVar.aAU == 0) {
                switch (aVar.aAT) {
                    case 8000:
                        aVar.aAU = 16000;
                        break;
                    case 16000:
                        aVar.aAU = 24000;
                        break;
                    case 44100:
                        aVar.aAU = 64000;
                        break;
                }
            }
            aVar.aAV = jSONObject.optString("cb");
        }
        return aVar;
    }

    public JSONObject EB() {
        if (this.aAQ > 600000 || this.aAQ <= 0) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error duration");
        }
        if (this.aAS != 1 && this.aAS != 2) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error channels");
        }
        if (!TextUtils.equals(this.aAR, "aac") && !TextUtils.equals(this.aAR, "pcm")) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error format");
        }
        if (this.aAT != 8000 && this.aAT != 16000 && this.aAT != 44100) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error sampleRate");
        }
        if (!TextUtils.equals(this.aAR, "pcm")) {
            boolean z = false;
            switch (this.aAT) {
                case 8000:
                    if (this.aAU > 48000 || this.aAU < 16000) {
                        z = true;
                        break;
                    }
                    break;
                case 16000:
                    if (this.aAU > 96000 || this.aAU < 24000) {
                        z = true;
                        break;
                    }
                    break;
                case 44100:
                    if (this.aAU > 320000 || this.aAU < 64000) {
                        z = true;
                        break;
                    }
                    break;
            }
            if (z) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error bitRate");
            }
        }
        if (TextUtils.isEmpty(this.aAV)) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "none cb");
        }
        return null;
    }

    public String toString() {
        return "recordTime : " + this.aAQ + "; channel : " + this.aAS + "; audioFormat : " + this.aAR + "; sampleRate : " + this.aAT + "; bitRate : " + this.aAU + "; callbacks : " + this.aAV;
    }
}
