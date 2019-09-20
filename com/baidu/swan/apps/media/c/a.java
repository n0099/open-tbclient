package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int aCS;
    public String aCT;
    public int aCU;
    public int aCV;
    public int aCW;
    public String aCX;

    public static a a(JSONObject jSONObject, a aVar) {
        if (jSONObject != null) {
            aVar = new a();
            aVar.aCS = jSONObject.optInt("duration", 60000);
            aVar.aCT = jSONObject.optString(IjkMediaMeta.IJKM_KEY_FORMAT);
            if (TextUtils.isEmpty(aVar.aCT)) {
                aVar.aCT = "aac";
            }
            aVar.aCU = jSONObject.optInt("numberOfChannels", 1);
            aVar.aCV = jSONObject.optInt("sampleRate", 8000);
            aVar.aCW = jSONObject.optInt("encodeBitRate");
            if (aVar.aCW == 0) {
                switch (aVar.aCV) {
                    case 8000:
                        aVar.aCW = 16000;
                        break;
                    case 16000:
                        aVar.aCW = 24000;
                        break;
                    case 44100:
                        aVar.aCW = 64000;
                        break;
                }
            }
            aVar.aCX = jSONObject.optString("cb");
        }
        return aVar;
    }

    public JSONObject Hl() {
        if (this.aCS > 600000 || this.aCS <= 0) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error duration");
        }
        if (this.aCU != 1 && this.aCU != 2) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error channels");
        }
        if (!TextUtils.equals(this.aCT, "aac") && !TextUtils.equals(this.aCT, "pcm")) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error format");
        }
        if (this.aCV != 8000 && this.aCV != 16000 && this.aCV != 44100) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error sampleRate");
        }
        if (!TextUtils.equals(this.aCT, "pcm")) {
            boolean z = false;
            switch (this.aCV) {
                case 8000:
                    if (this.aCW > 48000 || this.aCW < 16000) {
                        z = true;
                        break;
                    }
                    break;
                case 16000:
                    if (this.aCW > 96000 || this.aCW < 24000) {
                        z = true;
                        break;
                    }
                    break;
                case 44100:
                    if (this.aCW > 320000 || this.aCW < 64000) {
                        z = true;
                        break;
                    }
                    break;
            }
            if (z) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error bitRate");
            }
        }
        if (TextUtils.isEmpty(this.aCX)) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "none cb");
        }
        return null;
    }

    public String toString() {
        return "recordTime : " + this.aCS + "; channel : " + this.aCU + "; audioFormat : " + this.aCT + "; sampleRate : " + this.aCV + "; bitRate : " + this.aCW + "; callbacks : " + this.aCX;
    }
}
