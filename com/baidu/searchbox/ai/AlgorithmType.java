package com.baidu.searchbox.ai;
/* loaded from: classes2.dex */
public enum AlgorithmType {
    GBDT_REGRESSOR(1),
    GBDT_CLASSIFIER(2),
    GLM_REGRESSOR(3),
    GLM_CLASSIFIER(4);
    
    public final int value;

    AlgorithmType(int i) {
        this.value = i;
    }

    public int value() {
        return this.value;
    }
}
