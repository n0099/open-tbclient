package com.airbnb.lottie.model.content;
/* loaded from: classes6.dex */
public class Mask {
    private final com.airbnb.lottie.model.a.d EG;
    private final MaskMode Fa;
    private final com.airbnb.lottie.model.a.h Fb;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.airbnb.lottie.model.a.h hVar, com.airbnb.lottie.model.a.d dVar) {
        this.Fa = maskMode;
        this.Fb = hVar;
        this.EG = dVar;
    }

    public MaskMode jZ() {
        return this.Fa;
    }

    public com.airbnb.lottie.model.a.h ka() {
        return this.Fb;
    }

    public com.airbnb.lottie.model.a.d jI() {
        return this.EG;
    }
}
