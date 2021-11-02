package com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.v6;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class MMiddleNStrategy extends BaseEruptionStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ELEMENT_STRATEGY_COUNTS = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] mSectionCount;

    public MMiddleNStrategy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSectionCount = new int[]{1, 1, 1, 0};
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    public int getElementStrategyCounts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.BaseEruptionStrategy
    public int[] getSectionCntArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mSectionCount : (int[]) invokeV.objValue;
    }
}
