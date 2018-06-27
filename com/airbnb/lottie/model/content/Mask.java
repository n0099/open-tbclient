package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.a.d;
import com.airbnb.lottie.model.a.h;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Mask {
    private final com.airbnb.lottie.model.a.d nN;
    private final MaskMode oi;
    private final com.airbnb.lottie.model.a.h oj;

    /* loaded from: classes2.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect,
        MaskModeUnknown
    }

    private Mask(MaskMode maskMode, com.airbnb.lottie.model.a.h hVar, com.airbnb.lottie.model.a.d dVar) {
        this.oi = maskMode;
        this.oj = hVar;
        this.nN = dVar;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static Mask r(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            MaskMode maskMode;
            String optString = jSONObject.optString("mode");
            char c = 65535;
            switch (optString.hashCode()) {
                case 97:
                    if (optString.equals("a")) {
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
                    if (optString.equals(NotifyType.SOUND)) {
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
            return new Mask(maskMode, h.a.k(jSONObject.optJSONObject("pt"), eVar), d.a.g(jSONObject.optJSONObject("o"), eVar));
        }
    }

    public MaskMode cR() {
        return this.oi;
    }

    public com.airbnb.lottie.model.a.h cS() {
        return this.oj;
    }

    public com.airbnb.lottie.model.a.d cz() {
        return this.nN;
    }
}
