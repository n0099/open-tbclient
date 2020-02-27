package com.airbnb.lottie.model.content;
/* loaded from: classes6.dex */
public class Mask {
    private final com.airbnb.lottie.model.a.d hS;
    private final MaskMode iq;
    private final com.airbnb.lottie.model.a.h ir;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.airbnb.lottie.model.a.h hVar, com.airbnb.lottie.model.a.d dVar) {
        this.iq = maskMode;
        this.ir = hVar;
        this.hS = dVar;
    }

    public MaskMode cK() {
        return this.iq;
    }

    public com.airbnb.lottie.model.a.h cL() {
        return this.ir;
    }

    public com.airbnb.lottie.model.a.d ct() {
        return this.hS;
    }
}
