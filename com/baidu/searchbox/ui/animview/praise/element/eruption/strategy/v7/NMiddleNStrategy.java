package com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v7;

import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy;
/* loaded from: classes4.dex */
public class NMiddleNStrategy extends BaseEruptionStrategy {
    public static final int ELEMENT_STRATEGY_COUNTS = 6;
    public final int[] mSectionCount = {2, 2, 2, 0};

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    public int getElementStrategyCounts() {
        return 6;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    public int[] getSectionCntArray() {
        return this.mSectionCount;
    }
}
