package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.ubc.UBC;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int aCu;
    public String aCv;
    public int aCw;
    public int aCx;
    public int aCy;
    public String aCz;

    public static a a(JSONObject jSONObject, a aVar) {
        if (jSONObject != null) {
            aVar = new a();
            aVar.aCu = jSONObject.optInt(UBC.CONTENT_KEY_DURATION, 60000);
            aVar.aCv = jSONObject.optString(IjkMediaMeta.IJKM_KEY_FORMAT);
            if (TextUtils.isEmpty(aVar.aCv)) {
                aVar.aCv = "aac";
            }
            aVar.aCw = jSONObject.optInt("numberOfChannels", 1);
            aVar.aCx = jSONObject.optInt("sampleRate", 8000);
            aVar.aCy = jSONObject.optInt("encodeBitRate");
            if (aVar.aCy == 0) {
                switch (aVar.aCx) {
                    case 8000:
                        aVar.aCy = 16000;
                        break;
                    case 16000:
                        aVar.aCy = 24000;
                        break;
                    case 44100:
                        aVar.aCy = 64000;
                        break;
                }
            }
            aVar.aCz = jSONObject.optString("cb");
        }
        return aVar;
    }

    public JSONObject Hh() {
        if (this.aCu > 600000 || this.aCu <= 0) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error duration");
        }
        if (this.aCw != 1 && this.aCw != 2) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error channels");
        }
        if (!TextUtils.equals(this.aCv, "aac") && !TextUtils.equals(this.aCv, "pcm")) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error format");
        }
        if (this.aCx != 8000 && this.aCx != 16000 && this.aCx != 44100) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "error sampleRate");
        }
        if (!TextUtils.equals(this.aCv, "pcm")) {
            boolean z = false;
            switch (this.aCx) {
                case 8000:
                    if (this.aCy > 48000 || this.aCy < 16000) {
                        z = true;
                        break;
                    }
                    break;
                case 16000:
                    if (this.aCy > 96000 || this.aCy < 24000) {
                        z = true;
                        break;
                    }
                    break;
                case 44100:
                    if (this.aCy > 320000 || this.aCy < 64000) {
                        z = true;
                        break;
                    }
                    break;
            }
            if (z) {
                return UnitedSchemeUtility.wrapCallbackParams(202, "error bitRate");
            }
        }
        if (TextUtils.isEmpty(this.aCz)) {
            return UnitedSchemeUtility.wrapCallbackParams(202, "none cb");
        }
        return null;
    }

    public String toString() {
        return "recordTime : " + this.aCu + "; channel : " + this.aCw + "; audioFormat : " + this.aCv + "; sampleRate : " + this.aCx + "; bitRate : " + this.aCy + "; callbacks : " + this.aCz;
    }
}
