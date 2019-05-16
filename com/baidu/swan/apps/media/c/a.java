package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.ubc.UBC;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int aBM;
    public String aBN;
    public int aBO;
    public int aBP;
    public int aBQ;
    public String aBR;

    public static a a(JSONObject jSONObject, a aVar) {
        if (jSONObject != null) {
            aVar = new a();
            aVar.aBM = jSONObject.optInt(UBC.CONTENT_KEY_DURATION, 60000);
            aVar.aBN = jSONObject.optString(IjkMediaMeta.IJKM_KEY_FORMAT);
            if (TextUtils.isEmpty(aVar.aBN)) {
                aVar.aBN = "aac";
            }
            aVar.aBO = jSONObject.optInt("numberOfChannels", 1);
            aVar.aBP = jSONObject.optInt("sampleRate", 8000);
            aVar.aBQ = jSONObject.optInt("encodeBitRate");
            if (aVar.aBQ == 0) {
                switch (aVar.aBP) {
                    case 8000:
                        aVar.aBQ = 16000;
                        break;
                    case 16000:
                        aVar.aBQ = 24000;
                        break;
                    case 44100:
                        aVar.aBQ = 64000;
                        break;
                }
            }
            aVar.aBR = jSONObject.optString("cb");
        }
        return aVar;
    }

    public JSONObject Gx() {
        if (this.aBM > 600000 || this.aBM <= 0) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error duration");
        }
        if (this.aBO != 1 && this.aBO != 2) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error channels");
        }
        if (!TextUtils.equals(this.aBN, "aac") && !TextUtils.equals(this.aBN, "pcm")) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error format");
        }
        if (this.aBP != 8000 && this.aBP != 16000 && this.aBP != 44100) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error sampleRate");
        }
        if (!TextUtils.equals(this.aBN, "pcm")) {
            boolean z = false;
            switch (this.aBP) {
                case 8000:
                    if (this.aBQ > 48000 || this.aBQ < 16000) {
                        z = true;
                        break;
                    }
                    break;
                case 16000:
                    if (this.aBQ > 96000 || this.aBQ < 24000) {
                        z = true;
                        break;
                    }
                    break;
                case 44100:
                    if (this.aBQ > 320000 || this.aBQ < 64000) {
                        z = true;
                        break;
                    }
                    break;
            }
            if (z) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error bitRate");
            }
        }
        if (TextUtils.isEmpty(this.aBR)) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "none cb");
        }
        return null;
    }

    public String toString() {
        return "recordTime : " + this.aBM + "; channel : " + this.aBO + "; audioFormat : " + this.aBN + "; sampleRate : " + this.aBP + "; bitRate : " + this.aBQ + "; callbacks : " + this.aBR;
    }
}
