package com.baidu.searchbox.ui.animview.praise.element.eruption.strategy;

import android.util.Log;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.PraiseEnvironment;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v6.MLeftHStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v6.MLeftMStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v6.MLeftNStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v6.MMiddleHStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v6.MMiddleMStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v6.MMiddleNStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v6.MRightHStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v6.MRightMStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v6.MRightNStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v7.NLeftHStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v7.NLeftMStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v7.NLeftNStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v7.NMiddleHStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v7.NMiddleMStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v7.NMiddleNStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v7.NRightHStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v7.NRightMStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v7.NRightNStrategy;
import com.baidu.searchbox.ui.animview.util.DebugUtil;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class EruptionStrategyGroup implements IEruptionStrategyGroup {
    private static final boolean DEBUG = DebugUtil.isApkInDebug();
    private static final String TAG = "EruptionStrategyGroup";
    private IEruptionStrategy mCurrentStrategy;
    private HashMap<String, IEruptionStrategy> mStrategyGrp = new HashMap<>();

    public EruptionStrategyGroup() {
        initStrategy();
    }

    private void initStrategy() {
        PraiseEnvironment.Performance performanceLevel = PraiseEnvironment.getPerformanceLevel();
        if (performanceLevel == PraiseEnvironment.Performance.LEVEL_1 || performanceLevel == PraiseEnvironment.Performance.LEVEL_2) {
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_LEFT_N, new MLeftNStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_LEFT_M, new MLeftMStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_LEFT_H, new MLeftHStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_N, new MMiddleNStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_M, new MMiddleMStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_H, new MMiddleHStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_RIGHT_N, new MRightNStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_RIGHT_M, new MRightMStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_RIGHT_H, new MRightHStrategy());
        } else if (performanceLevel == PraiseEnvironment.Performance.LEVEL_3) {
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_LEFT_N, new NLeftNStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_LEFT_M, new NLeftMStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_LEFT_H, new NLeftHStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_N, new NMiddleNStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_M, new NMiddleMStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_H, new NMiddleHStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_RIGHT_N, new NRightNStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_RIGHT_M, new NRightMStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_RIGHT_H, new NRightHStrategy());
        } else if (DEBUG) {
            Log.d(TAG, "No Strategy matched");
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup
    public void setCurrentStrategy(String str) {
        if (!this.mStrategyGrp.isEmpty() && this.mStrategyGrp.containsKey(str)) {
            this.mCurrentStrategy = this.mStrategyGrp.get(str);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy
    public List<BaseAnimatedElement> generateEruptionElementList(IResourceProvider iResourceProvider, IEruptionStrategy.IHostCallback iHostCallback) {
        if (this.mCurrentStrategy == null) {
            return null;
        }
        return this.mCurrentStrategy.generateEruptionElementList(iResourceProvider, iHostCallback);
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy
    public List<Float> generateEruptionRotateAngleList() {
        if (this.mCurrentStrategy == null) {
            return null;
        }
        return this.mCurrentStrategy.generateEruptionRotateAngleList();
    }
}
