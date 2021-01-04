package com.airbnb.lottie.model.content;
/* loaded from: classes3.dex */
public class Mask {
    private final com.airbnb.lottie.model.a.d FB;
    private final MaskMode FW;
    private final com.airbnb.lottie.model.a.h FX;

    /* loaded from: classes3.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.airbnb.lottie.model.a.h hVar, com.airbnb.lottie.model.a.d dVar) {
        this.FW = maskMode;
        this.FX = hVar;
        this.FB = dVar;
    }

    public MaskMode jz() {
        return this.FW;
    }

    public com.airbnb.lottie.model.a.h jA() {
        return this.FX;
    }

    public com.airbnb.lottie.model.a.d ji() {
        return this.FB;
    }
}
