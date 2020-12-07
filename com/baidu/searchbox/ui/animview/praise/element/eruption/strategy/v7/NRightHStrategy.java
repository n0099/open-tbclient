package com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v7;

import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy;
/* loaded from: classes6.dex */
public class NRightHStrategy extends BaseEruptionStrategy {
    private static final int ELEMENT_STRATEGY_COUNTS = 14;
    private final int[] mSectionCount = {4, 3, 3, 4};

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    protected int getElementStrategyCounts() {
        return 14;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    protected int[] getSectionCntArray() {
        return this.mSectionCount;
    }
}
