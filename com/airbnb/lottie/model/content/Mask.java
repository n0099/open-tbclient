package com.airbnb.lottie.model.content;
/* loaded from: classes5.dex */
public class Mask {
    private final com.airbnb.lottie.model.a.d hO;
    private final MaskMode ik;
    private final com.airbnb.lottie.model.a.h il;

    /* loaded from: classes5.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.airbnb.lottie.model.a.h hVar, com.airbnb.lottie.model.a.d dVar) {
        this.ik = maskMode;
        this.il = hVar;
        this.hO = dVar;
    }

    public MaskMode cJ() {
        return this.ik;
    }

    public com.airbnb.lottie.model.a.h cK() {
        return this.il;
    }

    public com.airbnb.lottie.model.a.d cs() {
        return this.hO;
    }
}
