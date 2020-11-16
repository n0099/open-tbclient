package com.baidu.searchbox.ui.animview.praise.element.eruption;

import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.EruptionStrategyGroup;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
/* loaded from: classes14.dex */
public class EruptionElementBuilder implements IPraiseElementBuilder<BuildResult> {
    private static final float ERUPTION_RANDOM_DURATION_FACTOR = 0.6f;
    private static final int ERUPTION_STRATEGY_CNTS = 8;
    private static Random sRandom = new Random();
    private static Map<String, String> sTagMap = new HashMap();
    private static Map<String, String> sTagNightMap = new HashMap();
    private EruptionStrategyGroup mEruptionStrategyGroup;
    private IEruptionStrategy.IHostCallback mHostCallback;
    private IPraiseElementBuilder.PreBuildConfig mPreBuildConfig;
    private Map<String, List<BuildResult>> mResultMap = new HashMap();

    /* loaded from: classes14.dex */
    public static class BuildResult {
        public List<BaseAnimatedElement> eruptionElementList;
        public List<Float> eruptionRotateAngleList;
        public List<Float> transformedFactorList;
    }

    static {
        sTagMap.put(IEruptionStrategyGroup.STRATEGY_LEFT_N, "day_l");
        sTagMap.put(IEruptionStrategyGroup.STRATEGY_LEFT_M, "day_l");
        sTagMap.put(IEruptionStrategyGroup.STRATEGY_LEFT_H, "day_l");
        sTagMap.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_N, "day_m");
        sTagMap.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_M, "day_m");
        sTagMap.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_H, "day_m");
        sTagMap.put(IEruptionStrategyGroup.STRATEGY_RIGHT_N, "day_r");
        sTagMap.put(IEruptionStrategyGroup.STRATEGY_RIGHT_M, "day_r");
        sTagMap.put(IEruptionStrategyGroup.STRATEGY_RIGHT_H, "day_r");
        sTagNightMap.put(IEruptionStrategyGroup.STRATEGY_LEFT_N, "night_l");
        sTagNightMap.put(IEruptionStrategyGroup.STRATEGY_LEFT_M, "night_l");
        sTagNightMap.put(IEruptionStrategyGroup.STRATEGY_LEFT_H, "night_l");
        sTagNightMap.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_N, "night_m");
        sTagNightMap.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_M, "night_m");
        sTagNightMap.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_H, "night_m");
        sTagNightMap.put(IEruptionStrategyGroup.STRATEGY_RIGHT_N, "night_r");
        sTagNightMap.put(IEruptionStrategyGroup.STRATEGY_RIGHT_M, "night_r");
        sTagNightMap.put(IEruptionStrategyGroup.STRATEGY_RIGHT_H, "night_r");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static final class Holder {
        private static final EruptionElementBuilder sINSTANCE = new EruptionElementBuilder();

        private Holder() {
        }
    }

    public static final EruptionElementBuilder getInstance() {
        return Holder.sINSTANCE;
    }

    private static List<Float> getTransformedFactorList(int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(Float.valueOf(1.0f / ((float) ((0.3999999761581421d * Math.random()) + 0.6000000238418579d))));
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

    @Override // com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder
    public void preBuild(IPraiseElementBuilder.PreBuildConfig preBuildConfig) {
        init(preBuildConfig);
        if (this.mPreBuildConfig != null && this.mEruptionStrategyGroup != null) {
            Set<Map.Entry<String, String>> entrySet = NightModeHelper.getNightModeSwitcherState() ? sTagNightMap.entrySet() : sTagMap.entrySet();
            this.mResultMap.clear();
            for (Map.Entry<String, String> entry : entrySet) {
                ArrayList arrayList = new ArrayList();
                this.mEruptionStrategyGroup.setCurrentStrategy(entry.getKey());
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < 8) {
                        arrayList.add(generatedElements(entry.getValue()));
                        i = i2 + 1;
                    }
                }
                this.mResultMap.put(entry.getKey(), arrayList);
            }
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder
    public IPraiseElementBuilder.PreBuildConfig getPreBuildConfig() {
        return this.mPreBuildConfig;
    }

    private BuildResult generatedElements(String str) {
        List<Float> transformedFactorList;
        if (this.mPreBuildConfig == null || this.mEruptionStrategyGroup == null || this.mPreBuildConfig.getResourceProvider() == null) {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder
    public BuildResult getResult(IPraiseElementBuilder.FetchConfig fetchConfig) {
        if (fetchConfig == null) {
            return null;
        }
        BuildResult result = getResult(fetchConfig.getStrategyTag());
        if (result != null && result.eruptionElementList != null) {
            for (BaseAnimatedElement baseAnimatedElement : result.eruptionElementList) {
                baseAnimatedElement.init(fetchConfig.getLeft(), fetchConfig.getTop(), fetchConfig.getWidth(), fetchConfig.getHeight(), null, fetchConfig.getDrawableCallback());
            }
        }
        return result;
    }

    private BuildResult getResult(String str) {
        if (this.mResultMap == null || this.mResultMap.isEmpty()) {
            return null;
        }
        List<BuildResult> list = this.mResultMap.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(random(0, list.size() - 1));
    }

    private static int random(int i, int i2) {
        return (sRandom.nextInt(i2 + 1) % ((i2 - i) + 1)) + i;
    }
}
