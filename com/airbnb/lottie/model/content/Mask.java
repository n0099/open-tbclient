package com.airbnb.lottie.model.content;
/* loaded from: classes7.dex */
public class Mask {
    private final com.airbnb.lottie.model.a.d FO;
    private final MaskMode Gj;
    private final com.airbnb.lottie.model.a.h Gk;

    /* loaded from: classes7.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.airbnb.lottie.model.a.h hVar, com.airbnb.lottie.model.a.d dVar) {
        this.Gj = maskMode;
        this.Gk = hVar;
        this.FO = dVar;
    }

    public MaskMode ka() {
        return this.Gj;
    }

    public com.airbnb.lottie.model.a.h kb() {
        return this.Gk;
    }

    public com.airbnb.lottie.model.a.d jJ() {
        return this.FO;
    }
}
