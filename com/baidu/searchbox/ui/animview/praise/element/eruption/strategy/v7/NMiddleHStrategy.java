package com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v7;

import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy;
/* loaded from: classes12.dex */
public class NMiddleHStrategy extends BaseEruptionStrategy {
    private static final int ELEMENT_STRATEGY_COUNTS = 18;
    private final int[] mSectionCount = {4, 5, 4, 5};

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    protected int getElementStrategyCounts() {
        return 18;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    protected int[] getSectionCntArray() {
        return this.mSectionCount;
    }
}
