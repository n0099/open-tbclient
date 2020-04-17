package com.airbnb.lottie.model.content;
/* loaded from: classes6.dex */
public class Mask {
    private final MaskMode DR;
    private final com.airbnb.lottie.model.a.h DS;
    private final com.airbnb.lottie.model.a.d Du;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.airbnb.lottie.model.a.h hVar, com.airbnb.lottie.model.a.d dVar) {
        this.DR = maskMode;
        this.DS = hVar;
        this.Du = dVar;
    }

    public MaskMode ii() {
        return this.DR;
    }

    public com.airbnb.lottie.model.a.h ij() {
        return this.DS;
    }

    public com.airbnb.lottie.model.a.d hQ() {
        return this.Du;
    }
}
