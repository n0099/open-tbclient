package com.baidu.live.lottie.model.content;
/* loaded from: classes10.dex */
public class Mask {
    private final com.baidu.live.lottie.model.a.d buL;
    private final MaskMode buZ;
    private final com.baidu.live.lottie.model.a.h bva;

    /* loaded from: classes10.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.baidu.live.lottie.model.a.h hVar, com.baidu.live.lottie.model.a.d dVar) {
        this.buZ = maskMode;
        this.bva = hVar;
        this.buL = dVar;
    }

    public MaskMode Qi() {
        return this.buZ;
    }

    public com.baidu.live.lottie.model.a.h Qj() {
        return this.bva;
    }

    public com.baidu.live.lottie.model.a.d PV() {
        return this.buL;
    }
}
