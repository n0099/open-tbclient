package com.baidu.tbadk.core.util.svg;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SvgPureType extends AbsSvgType {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int tintColorId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SvgPureType(int i, int i2) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.tintColorId = i2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SvgPureType(int i, SvgManager.SvgResourceStateType svgResourceStateType, int i2) {
        super(i, svgResourceStateType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), svgResourceStateType, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (SvgManager.SvgResourceStateType) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.tintColorId = i2;
    }

    @Override // com.baidu.tbadk.core.util.svg.AbsSvgType
    public Drawable getDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return SvgManager.getInstance().getPureDrawable(this.drawableId, this.tintColorId, this.stateType);
        }
        return (Drawable) invokeV.objValue;
    }
}
