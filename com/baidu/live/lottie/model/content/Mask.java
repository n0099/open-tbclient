package com.baidu.live.lottie.model.content;
/* loaded from: classes9.dex */
public class Mask {
    private final com.baidu.live.lottie.model.a.d bpX;
    private final MaskMode bql;
    private final com.baidu.live.lottie.model.a.h bqm;

    /* loaded from: classes9.dex */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.baidu.live.lottie.model.a.h hVar, com.baidu.live.lottie.model.a.d dVar) {
        this.bql = maskMode;
        this.bqm = hVar;
        this.bpX = dVar;
    }

    public MaskMode Mn() {
        return this.bql;
    }

    public com.baidu.live.lottie.model.a.h Mo() {
        return this.bqm;
    }

    public com.baidu.live.lottie.model.a.d Ma() {
        return this.bpX;
    }
}
