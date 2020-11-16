package com.airbnb.lottie.model.content;
/* loaded from: classes16.dex */
public class Mask {
    private final com.airbnb.lottie.model.a.d EY;
    private final MaskMode Fr;
    private final com.airbnb.lottie.model.a.h Fs;

    /* loaded from: classes16.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.airbnb.lottie.model.a.h hVar, com.airbnb.lottie.model.a.d dVar) {
        this.Fr = maskMode;
        this.Fs = hVar;
        this.EY = dVar;
    }

    public MaskMode ka() {
        return this.Fr;
    }

    public com.airbnb.lottie.model.a.h kb() {
        return this.Fs;
    }

    public com.airbnb.lottie.model.a.d jJ() {
        return this.EY;
    }
}
