package com.baidu.searchbox.ui.animview.praise.element.eruption.strategy;

import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class EruptionStrategyGroup implements IEruptionStrategyGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "EruptionStrategyGroup";
    public transient /* synthetic */ FieldHolder $fh;
    public IEruptionStrategy mCurrentStrategy;
    public HashMap<String, IEruptionStrategy> mStrategyGrp;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(121246306, "Lcom/baidu/searchbox/ui/animview/praise/element/eruption/strategy/EruptionStrategyGroup;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(121246306, "Lcom/baidu/searchbox/ui/animview/praise/element/eruption/strategy/EruptionStrategyGroup;");
                return;
            }
        }
        DEBUG = DebugUtil.isApkInDebug();
    }

    public EruptionStrategyGroup() {
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
        this.mStrategyGrp = new HashMap<>();
        initStrategy();
    }

    private void initStrategy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            PraiseEnvironment.Performance performanceLevel = PraiseEnvironment.getPerformanceLevel();
            if (performanceLevel != PraiseEnvironment.Performance.LEVEL_1 && performanceLevel != PraiseEnvironment.Performance.LEVEL_2) {
                if (performanceLevel == PraiseEnvironment.Performance.LEVEL_3) {
                    this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_LEFT_N, new NLeftNStrategy());
                    this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_LEFT_M, new NLeftMStrategy());
                    this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_LEFT_H, new NLeftHStrategy());
                    this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_N, new NMiddleNStrategy());
                    this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_M, new NMiddleMStrategy());
                    this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_H, new NMiddleHStrategy());
                    this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_RIGHT_N, new NRightNStrategy());
                    this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_RIGHT_M, new NRightMStrategy());
                    this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_RIGHT_H, new NRightHStrategy());
                    return;
                }
                boolean z = DEBUG;
                return;
            }
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_LEFT_N, new MLeftNStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_LEFT_M, new MLeftMStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_LEFT_H, new MLeftHStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_N, new MMiddleNStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_M, new MMiddleMStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_MIDDLE_H, new MMiddleHStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_RIGHT_N, new MRightNStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_RIGHT_M, new MRightMStrategy());
            this.mStrategyGrp.put(IEruptionStrategyGroup.STRATEGY_RIGHT_H, new MRightHStrategy());
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy
    public List<BaseAnimatedElement> generateEruptionElementList(IResourceProvider iResourceProvider, IEruptionStrategy.IHostCallback iHostCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, iResourceProvider, iHostCallback)) == null) {
            IEruptionStrategy iEruptionStrategy = this.mCurrentStrategy;
            if (iEruptionStrategy == null) {
                return null;
            }
            return iEruptionStrategy.generateEruptionElementList(iResourceProvider, iHostCallback);
        }
        return (List) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy
    public List<Float> generateEruptionRotateAngleList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            IEruptionStrategy iEruptionStrategy = this.mCurrentStrategy;
            if (iEruptionStrategy == null) {
                return null;
            }
            return iEruptionStrategy.generateEruptionRotateAngleList();
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup
    public void setCurrentStrategy(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && !this.mStrategyGrp.isEmpty() && this.mStrategyGrp.containsKey(str)) {
            this.mCurrentStrategy = this.mStrategyGrp.get(str);
        }
    }
}
