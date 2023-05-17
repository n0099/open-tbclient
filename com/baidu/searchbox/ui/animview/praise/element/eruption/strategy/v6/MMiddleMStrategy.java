package com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v6;

import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy;
/* loaded from: classes4.dex */
public class MMiddleMStrategy extends BaseEruptionStrategy {
    public static final int ELEMENT_STRATEGY_COUNTS = 6;
    public final int[] mSectionCount = {1, 4, 1, 0};

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    public int getElementStrategyCounts() {
        return 6;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    public int[] getSectionCntArray() {
        return this.mSectionCount;
    }
}
