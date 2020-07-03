package com.airbnb.lottie.model.content;
/* loaded from: classes6.dex */
public class Mask {
    private final com.airbnb.lottie.model.a.d Eb;
    private final MaskMode Eu;
    private final com.airbnb.lottie.model.a.h Ev;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.airbnb.lottie.model.a.h hVar, com.airbnb.lottie.model.a.d dVar) {
        this.Eu = maskMode;
        this.Ev = hVar;
        this.Eb = dVar;
    }

    public MaskMode iz() {
        return this.Eu;
    }

    public com.airbnb.lottie.model.a.h iA() {
        return this.Ev;
    }

    public com.airbnb.lottie.model.a.d ih() {
        return this.Eb;
    }
}
