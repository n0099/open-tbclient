package com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v7;

import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy;
/* loaded from: classes4.dex */
public class NLeftHStrategy extends BaseEruptionStrategy {
    public static final int ELEMENT_STRATEGY_COUNTS = 14;
    public final int[] mSectionCount = {3, 3, 4, 4};

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    public int getElementStrategyCounts() {
        return 14;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    public int[] getSectionCntArray() {
        return this.mSectionCount;
    }
}
