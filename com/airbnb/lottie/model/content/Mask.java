package com.airbnb.lottie.model.content;
/* loaded from: classes5.dex */
public class Mask {
    private final com.airbnb.lottie.model.a.d GW;
    private final MaskMode Hq;
    private final com.airbnb.lottie.model.a.h Hr;

    /* loaded from: classes5.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.airbnb.lottie.model.a.h hVar, com.airbnb.lottie.model.a.d dVar) {
        this.Hq = maskMode;
        this.Hr = hVar;
        this.GW = dVar;
    }

    public MaskMode jy() {
        return this.Hq;
    }

    public com.airbnb.lottie.model.a.h jz() {
        return this.Hr;
    }

    public com.airbnb.lottie.model.a.d jh() {
        return this.GW;
    }
}
