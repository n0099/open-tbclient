package com.baidu.live.lottie.model.content;
/* loaded from: classes10.dex */
public class Mask {
    private final MaskMode btN;
    private final com.baidu.live.lottie.model.a.h btO;
    private final com.baidu.live.lottie.model.a.d btz;

    /* loaded from: classes10.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.baidu.live.lottie.model.a.h hVar, com.baidu.live.lottie.model.a.d dVar) {
        this.btN = maskMode;
        this.btO = hVar;
        this.btz = dVar;
    }

    public MaskMode NL() {
        return this.btN;
    }

    public com.baidu.live.lottie.model.a.h NM() {
        return this.btO;
    }

    public com.baidu.live.lottie.model.a.d Ny() {
        return this.btz;
    }
}
