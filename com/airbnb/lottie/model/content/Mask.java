package com.airbnb.lottie.model.content;
/* loaded from: classes4.dex */
public class Mask {
    private final com.airbnb.lottie.model.a.d hO;
    private final MaskMode il;
    private final com.airbnb.lottie.model.a.h im;

    /* loaded from: classes4.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.airbnb.lottie.model.a.h hVar, com.airbnb.lottie.model.a.d dVar) {
        this.il = maskMode;
        this.im = hVar;
        this.hO = dVar;
    }

    public MaskMode cJ() {
        return this.il;
    }

    public com.airbnb.lottie.model.a.h cK() {
        return this.im;
    }

    public com.airbnb.lottie.model.a.d cs() {
        return this.hO;
    }
}
