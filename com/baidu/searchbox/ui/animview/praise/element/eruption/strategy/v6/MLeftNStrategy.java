package com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v6;

import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy;
/* loaded from: classes4.dex */
public class MLeftNStrategy extends BaseEruptionStrategy {
    public static final int ELEMENT_STRATEGY_COUNTS = 3;
    public final int[] mSectionCount = {0, 1, 2, 0};

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    public int getElementStrategyCounts() {
        return 3;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    public int[] getSectionCntArray() {
        return this.mSectionCount;
    }
}
