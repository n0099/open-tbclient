package com.airbnb.lottie.model.content;
/* loaded from: classes6.dex */
public class Mask {
    private final com.airbnb.lottie.model.a.d hR;

    /* renamed from: io  reason: collision with root package name */
    private final MaskMode f970io;
    private final com.airbnb.lottie.model.a.h iq;

    /* loaded from: classes6.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.airbnb.lottie.model.a.h hVar, com.airbnb.lottie.model.a.d dVar) {
        this.f970io = maskMode;
        this.iq = hVar;
        this.hR = dVar;
    }

    public MaskMode cK() {
        return this.f970io;
    }

    public com.airbnb.lottie.model.a.h cL() {
        return this.iq;
    }

    public com.airbnb.lottie.model.a.d ct() {
        return this.hR;
    }
}
