package com.baidu.searchbox.ui.animview.praise.element.eruption;

import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.EruptionStrategyGroup;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
/* loaded from: classes4.dex */
public class EruptionElementBuilder implements IPraiseElementBuilder<BuildResult> {
    public static final float ERUPTION_RANDOM_DURATION_FACTOR = 0.6f;
    public static final int ERUPTION_STRATEGY_CNTS = 8;
    public static Random sRandom = new Random();
    public static Map<String, String> sTagMap = new HashMap();
    public static Map<String, String> sTagNightMap = new HashMap();
    public EruptionStrategyGroup mEruptionStrategyGroup;
    public IEruptionStrategy.IHostCallback mHostCallback;
    public IPraiseElementBuilder.PreBuildConfig mPreBuildConfig;
    public Map<String, List<BuildResult>> mResultMap = new HashMap();

    /* loaded from: classes4.dex */
    public static class BuildResult {
        public List<BaseAnimatedElement> eruptionElementList;
        public List<Float> eruptionRotateAngleList;
        public List<Float> transformedFactorList;
    }

    /* loaded from: classes4.dex */
    public static final class Holder {
        public static final EruptionElementBuilder INSTANCE = new EruptionElementBuilder();
    }

    static {
        sTagMap.put(IEruptionStrategyGroup.STRATEGY_LEFT_N, ComboPraiseView.PKG_TAG_DAY_L);
        sTagMap.put(IEruptionStrategyGroup.STRATEGY_LEFT_M, ComboPraiseView.PKG_TAG_DAY_L);
        sTagMap.put(IEruptionStrategyGroup.STRATEGY_LEFT_H, ComboPraiseView.PKG_TAG_DAY_L);
        sTagMap.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_N, ComboPraiseView.PKG_TAG_DAY_M);
        sTagMap.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_M, ComboPraiseView.PKG_TAG_DAY_M);
        sTagMap.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_H, ComboPraiseView.PKG_TAG_DAY_M);
        sTagMap.put(IEruptionStrategyGroup.STRATEGY_RIGHT_N, ComboPraiseView.PKG_TAG_DAY_R);
        sTagMap.put(IEruptionStrategyGroup.STRATEGY_RIGHT_M, ComboPraiseView.PKG_TAG_DAY_R);
        sTagMap.put(IEruptionStrategyGroup.STRATEGY_RIGHT_H, ComboPraiseView.PKG_TAG_DAY_R);
        sTagNightMap.put(IEruptionStrategyGroup.STRATEGY_LEFT_N, ComboPraiseView.PKG_TAG_NIGHT_L);
        sTagNightMap.put(IEruptionStrategyGroup.STRATEGY_LEFT_M, ComboPraiseView.PKG_TAG_NIGHT_L);
        sTagNightMap.put(IEruptionStrategyGroup.STRATEGY_LEFT_H, ComboPraiseView.PKG_TAG_NIGHT_L);
        sTagNightMap.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_N, ComboPraiseView.PKG_TAG_NIGHT_M);
        sTagNightMap.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_M, ComboPraiseView.PKG_TAG_NIGHT_M);
        sTagNightMap.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_H, ComboPraiseView.PKG_TAG_NIGHT_M);
        sTagNightMap.put(IEruptionStrategyGroup.STRATEGY_RIGHT_N, ComboPraiseView.PKG_TAG_NIGHT_R);
        sTagNightMap.put(IEruptionStrategyGroup.STRATEGY_RIGHT_M, ComboPraiseView.PKG_TAG_NIGHT_R);
        sTagNightMap.put(IEruptionStrategyGroup.STRATEGY_RIGHT_H, ComboPraiseView.PKG_TAG_NIGHT_R);
    }

    public static final EruptionElementBuilder getInstance() {
        return Holder.INSTANCE;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder
    public IPraiseElementBuilder.PreBuildConfig getPreBuildConfig() {
        return this.mPreBuildConfig;
    }

    private BuildResult generatedElements(String str) {
        List<Float> transformedFactorList;
        IPraiseElementBuilder.PreBuildConfig preBuildConfig = this.mPreBuildConfig;
        if (preBuildConfig == null || this.mEruptionStrategyGroup == null || preBuildConfig.getResourceProvider() == null) {
            return null;
        }
        this.mPreBuildConfig.getResourceProvider().setCurrentPackage(str);
        List<BaseAnimatedElement> generateEruptionElementList = this.mEruptionStrategyGroup.generateEruptionElementList(this.mPreBuildConfig.getResourceProvider(), this.mHostCallback);
        List<Float> generateEruptionRotateAngleList = this.mEruptionStrategyGroup.generateEruptionRotateAngleList();
        if (generateEruptionElementList == null || generateEruptionElementList.isEmpty() || generateEruptionRotateAngleList == null || generateEruptionRotateAngleList.isEmpty() || (transformedFactorList = getTransformedFactorList(generateEruptionElementList.size())) == null || transformedFactorList.isEmpty()) {
            return null;
        }
        BuildResult buildResult = new BuildResult();
        buildResult.eruptionElementList = generateEruptionElementList;
        buildResult.eruptionRotateAngleList = generateEruptionRotateAngleList;
        buildResult.transformedFactorList = transformedFactorList;
        return buildResult;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder
    public void preBuild(IPraiseElementBuilder.PreBuildConfig preBuildConfig) {
        Map<String, String> map;
        init(preBuildConfig);
        if (this.mPreBuildConfig != null && this.mEruptionStrategyGroup != null) {
            if (NightModeHelper.getNightModeSwitcherState()) {
                map = sTagNightMap;
            } else {
                map = sTagMap;
            }
            Set<Map.Entry<String, String>> entrySet = map.entrySet();
            this.mResultMap.clear();
            for (Map.Entry<String, String> entry : entrySet) {
                ArrayList arrayList = new ArrayList();
                this.mEruptionStrategyGroup.setCurrentStrategy(entry.getKey());
                for (int i = 0; i < 8; i++) {
                    arrayList.add(generatedElements(entry.getValue()));
                }
                this.mResultMap.put(entry.getKey(), arrayList);
            }
        }
    }

    private BuildResult getResult(String str) {
        List<BuildResult> list;
        Map<String, List<BuildResult>> map = this.mResultMap;
        if (map == null || map.isEmpty() || (list = this.mResultMap.get(str)) == null || list.isEmpty()) {
            return null;
        }
        return list.get(random(0, list.size() - 1));
    }

    public static List<Float> getTransformedFactorList(int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(Float.valueOf(1.0f / ((float) ((Math.random() * 0.3999999761581421d) + 0.6000000238418579d))));
        }
        return arrayList;
    }

    private void init(IPraiseElementBuilder.PreBuildConfig preBuildConfig) {
        this.mPreBuildConfig = preBuildConfig;
        this.mEruptionStrategyGroup = new EruptionStrategyGroup();
        this.mHostCallback = new IEruptionStrategy.IHostCallback() { // from class: com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionElementBuilder.1
            @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy.IHostCallback
            public BaseAnimatedElement createAndInitEruption(int i, int i2, IResourceProvider iResourceProvider) {
                return new EruptionAnimElementEx(i2, BaseAnimatedElement.ScaleType.FIT_XY, iResourceProvider);
            }
        };
    }

    public static int random(int i, int i2) {
        return (sRandom.nextInt(i2 + 1) % ((i2 - i) + 1)) + i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder
    public BuildResult getResult(IPraiseElementBuilder.FetchConfig fetchConfig) {
        List<BaseAnimatedElement> list;
        if (fetchConfig == null) {
            return null;
        }
        BuildResult result = getResult(fetchConfig.getStrategyTag());
        if (result != null && (list = result.eruptionElementList) != null) {
            for (BaseAnimatedElement baseAnimatedElement : list) {
                baseAnimatedElement.init(fetchConfig.getLeft(), fetchConfig.getTop(), fetchConfig.getWidth(), fetchConfig.getHeight(), null, fetchConfig.getDrawableCallback());
            }
        }
        return result;
    }
}
