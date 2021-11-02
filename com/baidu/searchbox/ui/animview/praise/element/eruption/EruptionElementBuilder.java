package com.baidu.searchbox.ui.animview.praise.element.eruption;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.EruptionStrategyGroup;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
/* loaded from: classes7.dex */
public class EruptionElementBuilder implements IPraiseElementBuilder<BuildResult> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float ERUPTION_RANDOM_DURATION_FACTOR = 0.6f;
    public static final int ERUPTION_STRATEGY_CNTS = 8;
    public static Random sRandom;
    public static Map<String, String> sTagMap;
    public static Map<String, String> sTagNightMap;
    public transient /* synthetic */ FieldHolder $fh;
    public EruptionStrategyGroup mEruptionStrategyGroup;
    public IEruptionStrategy.IHostCallback mHostCallback;
    public IPraiseElementBuilder.PreBuildConfig mPreBuildConfig;
    public Map<String, List<BuildResult>> mResultMap;

    /* loaded from: classes7.dex */
    public static class BuildResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<BaseAnimatedElement> eruptionElementList;
        public List<Float> eruptionRotateAngleList;
        public List<Float> transformedFactorList;

        public BuildResult() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final EruptionElementBuilder sINSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1651074379, "Lcom/baidu/searchbox/ui/animview/praise/element/eruption/EruptionElementBuilder$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1651074379, "Lcom/baidu/searchbox/ui/animview/praise/element/eruption/EruptionElementBuilder$Holder;");
                    return;
                }
            }
            sINSTANCE = new EruptionElementBuilder();
        }

        public Holder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-892786117, "Lcom/baidu/searchbox/ui/animview/praise/element/eruption/EruptionElementBuilder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-892786117, "Lcom/baidu/searchbox/ui/animview/praise/element/eruption/EruptionElementBuilder;");
                return;
            }
        }
        sRandom = new Random();
        sTagMap = new HashMap();
        sTagNightMap = new HashMap();
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

    public EruptionElementBuilder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mResultMap = new HashMap();
    }

    private BuildResult generatedElements(String str) {
        InterceptResult invokeL;
        List<Float> transformedFactorList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
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
        return (BuildResult) invokeL.objValue;
    }

    public static final EruptionElementBuilder getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Holder.sINSTANCE : (EruptionElementBuilder) invokeV.objValue;
    }

    public static List<Float> getTransformedFactorList(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList.add(Float.valueOf(1.0f / ((float) ((Math.random() * 0.3999999761581421d) + 0.6000000238418579d))));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    private void init(IPraiseElementBuilder.PreBuildConfig preBuildConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, preBuildConfig) == null) {
            this.mPreBuildConfig = preBuildConfig;
            this.mEruptionStrategyGroup = new EruptionStrategyGroup();
            this.mHostCallback = new IEruptionStrategy.IHostCallback(this) { // from class: com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionElementBuilder.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EruptionElementBuilder this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy.IHostCallback
                public BaseAnimatedElement createAndInitEruption(int i2, int i3, IResourceProvider iResourceProvider) {
                    InterceptResult invokeIIL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i2, i3, iResourceProvider)) == null) ? new EruptionAnimElementEx(i3, BaseAnimatedElement.ScaleType.FIT_XY, iResourceProvider) : (BaseAnimatedElement) invokeIIL.objValue;
                }
            };
        }
    }

    public static int random(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65543, null, i2, i3)) == null) ? (sRandom.nextInt(i3 + 1) % ((i3 - i2) + 1)) + i2 : invokeII.intValue;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder
    public IPraiseElementBuilder.PreBuildConfig getPreBuildConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mPreBuildConfig : (IPraiseElementBuilder.PreBuildConfig) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder
    public void preBuild(IPraiseElementBuilder.PreBuildConfig preBuildConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, preBuildConfig) == null) {
            init(preBuildConfig);
            if (this.mPreBuildConfig == null || this.mEruptionStrategyGroup == null) {
                return;
            }
            Set<Map.Entry<String, String>> entrySet = (NightModeHelper.getNightModeSwitcherState() ? sTagNightMap : sTagMap).entrySet();
            this.mResultMap.clear();
            for (Map.Entry<String, String> entry : entrySet) {
                ArrayList arrayList = new ArrayList();
                this.mEruptionStrategyGroup.setCurrentStrategy(entry.getKey());
                for (int i2 = 0; i2 < 8; i2++) {
                    arrayList.add(generatedElements(entry.getValue()));
                }
                this.mResultMap.put(entry.getKey(), arrayList);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder
    public BuildResult getResult(IPraiseElementBuilder.FetchConfig fetchConfig) {
        InterceptResult invokeL;
        List<BaseAnimatedElement> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fetchConfig)) == null) {
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
        return (BuildResult) invokeL.objValue;
    }

    private BuildResult getResult(String str) {
        InterceptResult invokeL;
        List<BuildResult> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            Map<String, List<BuildResult>> map = this.mResultMap;
            if (map == null || map.isEmpty() || (list = this.mResultMap.get(str)) == null || list.isEmpty()) {
                return null;
            }
            return list.get(random(0, list.size() - 1));
        }
        return (BuildResult) invokeL.objValue;
    }
}
