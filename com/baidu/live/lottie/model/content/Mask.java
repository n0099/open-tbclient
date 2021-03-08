package com.baidu.live.lottie.model.content;
/* loaded from: classes9.dex */
public class Mask {
    private final com.baidu.live.lottie.model.a.d bva;
    private final MaskMode bvo;
    private final com.baidu.live.lottie.model.a.h bvp;

    /* loaded from: classes9.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.baidu.live.lottie.model.a.h hVar, com.baidu.live.lottie.model.a.d dVar) {
        this.bvo = maskMode;
        this.bvp = hVar;
        this.bva = dVar;
    }

    public MaskMode NO() {
        return this.bvo;
    }

    public com.baidu.live.lottie.model.a.h NP() {
        return this.bvp;
    }

    public com.baidu.live.lottie.model.a.d NB() {
        return this.bva;
    }
}
