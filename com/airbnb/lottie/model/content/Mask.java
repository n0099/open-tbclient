package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.a.d;
import com.airbnb.lottie.model.a.h;
import com.baidu.mobstat.Config;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Mask {
    private final com.airbnb.lottie.model.a.d qP;
    private final MaskMode rk;
    private final com.airbnb.lottie.model.a.h rl;

    /* loaded from: classes2.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect,
        MaskModeUnknown
    }

    private Mask(MaskMode maskMode, com.airbnb.lottie.model.a.h hVar, com.airbnb.lottie.model.a.d dVar) {
        this.rk = maskMode;
        this.rl = hVar;
        this.qP = dVar;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static Mask r(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            MaskMode maskMode;
            String optString = jSONObject.optString("mode");
            char c = 65535;
            switch (optString.hashCode()) {
                case 97:
                    if (optString.equals(Config.APP_VERSION_CODE)) {
                        c = 0;
                        break;
                    }
                    break;
                case 105:
                    if (optString.equals("i")) {
                        c = 2;
                        break;
                    }
                    break;
                case 115:
                    if (optString.equals("s")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    maskMode = MaskMode.MaskModeAdd;
                    break;
                case 1:
                    maskMode = MaskMode.MaskModeSubtract;
                    break;
                case 2:
                    maskMode = MaskMode.MaskModeIntersect;
                    break;
                default:
                    maskMode = MaskMode.MaskModeUnknown;
                    break;
            }
            return new Mask(maskMode, h.a.k(jSONObject.optJSONObject(Config.PLATFORM_TYPE), eVar), d.a.g(jSONObject.optJSONObject(Config.OS), eVar));
        }
    }

    public MaskMode em() {
        return this.rk;
    }

    public com.airbnb.lottie.model.a.h en() {
        return this.rl;
    }

    public com.airbnb.lottie.model.a.d dU() {
        return this.qP;
    }
}
