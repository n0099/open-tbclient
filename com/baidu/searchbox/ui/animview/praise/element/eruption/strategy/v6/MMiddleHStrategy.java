package com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v6;

import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy;
/* loaded from: classes11.dex */
public class MMiddleHStrategy extends BaseEruptionStrategy {
    private static final int ELEMENT_STRATEGY_COUNTS = 14;
    private final int[] mSectionCount = {3, 4, 3, 4};

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    protected int getElementStrategyCounts() {
        return 14;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    protected int[] getSectionCntArray() {
        return this.mSectionCount;
    }
}
