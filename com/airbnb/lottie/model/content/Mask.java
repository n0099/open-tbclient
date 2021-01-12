package com.airbnb.lottie.model.content;
/* loaded from: classes3.dex */
public class Mask {
    private final MaskMode FU;
    private final com.airbnb.lottie.model.a.h FV;
    private final com.airbnb.lottie.model.a.d Fz;

    /* loaded from: classes3.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.airbnb.lottie.model.a.h hVar, com.airbnb.lottie.model.a.d dVar) {
        this.FU = maskMode;
        this.FV = hVar;
        this.Fz = dVar;
    }

    public MaskMode jz() {
        return this.FU;
    }

    public com.airbnb.lottie.model.a.h jA() {
        return this.FV;
    }

    public com.airbnb.lottie.model.a.d ji() {
        return this.Fz;
    }
}
