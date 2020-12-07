package com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v7;

import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy;
/* loaded from: classes6.dex */
public class NMiddleNStrategy extends BaseEruptionStrategy {
    private static final int ELEMENT_STRATEGY_COUNTS = 6;
    private final int[] mSectionCount = {2, 2, 2, 0};

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    protected int getElementStrategyCounts() {
        return 6;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    protected int[] getSectionCntArray() {
        return this.mSectionCount;
    }
}
