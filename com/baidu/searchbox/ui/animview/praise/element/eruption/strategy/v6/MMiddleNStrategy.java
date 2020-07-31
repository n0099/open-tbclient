package com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v6;

import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy;
/* loaded from: classes7.dex */
public class MMiddleNStrategy extends BaseEruptionStrategy {
    private static final int ELEMENT_STRATEGY_COUNTS = 3;
    private final int[] mSectionCount = {1, 1, 1, 0};

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    protected int getElementStrategyCounts() {
        return 3;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    protected int[] getSectionCntArray() {
        return this.mSectionCount;
    }
}
