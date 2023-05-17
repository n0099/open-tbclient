package com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v7;

import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy;
/* loaded from: classes4.dex */
public class NLeftMStrategy extends BaseEruptionStrategy {
    public static final int ELEMENT_STRATEGY_COUNTS = 10;
    public final int[] mSectionCount = {3, 2, 5, 0};

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    public int getElementStrategyCounts() {
        return 10;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    public int[] getSectionCntArray() {
        return this.mSectionCount;
    }
}
