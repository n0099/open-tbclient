package com.airbnb.lottie.model.content;
/* loaded from: classes6.dex */
public class Mask {
    private final MaskMode DU;
    private final com.airbnb.lottie.model.a.h DV;
    private final com.airbnb.lottie.model.a.d Dx;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.airbnb.lottie.model.a.h hVar, com.airbnb.lottie.model.a.d dVar) {
        this.DU = maskMode;
        this.DV = hVar;
        this.Dx = dVar;
    }

    public MaskMode ii() {
        return this.DU;
    }

    public com.airbnb.lottie.model.a.h ij() {
        return this.DV;
    }

    public com.airbnb.lottie.model.a.d hQ() {
        return this.Dx;
    }
}
