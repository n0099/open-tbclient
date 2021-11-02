package com.baidu.searchbox.ui.animview.praise.layout;

import android.graphics.Rect;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class RightLayoutStrategy extends BaseLayoutStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float PRAISELEVEL_FACTOR_POS_X_BASED_PRAISELEVEL = 0.75f;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RightLayoutStrategy(Rect rect, int i2, int i3, IResourceProvider iResourceProvider) {
        super(rect, i2, i3, iResourceProvider);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rect, Integer.valueOf(i2), Integer.valueOf(i3), iResourceProvider};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Rect) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (IResourceProvider) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.layout.BaseLayoutStrategy
    public float getPraiseLevelFactorPosX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0.75f;
        }
        return invokeV.floatValue;
    }
}
