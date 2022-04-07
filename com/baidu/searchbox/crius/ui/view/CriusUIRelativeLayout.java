package com.baidu.searchbox.crius.ui.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.ui.CriusUI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class CriusUIRelativeLayout extends CriusUI<RelativeLayout> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CriusUIRelativeLayout(Context context, CriusData criusData) {
        super(context, criusData);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, criusData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (CriusData) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private boolean hasRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.renderObject.convertedBorderRadius() > 0.0f || this.renderObject.convertedBorderRadiusLT() > 0.0f || this.renderObject.convertedBorderRadiusRT() > 0.0f || this.renderObject.convertedBorderRadiusRB() > 0.0f || this.renderObject.convertedBorderRadiusLB() > 0.0f : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.crius.ui.CriusUI, com.baidu.searchbox.crius.ui.RenderImplInterface
    public void insertChild(CriusData criusData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, criusData, i) == null) {
            View view2 = criusData.getUI().getView();
            if (view2.getParent() != null) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            ((RelativeLayout) this.mView).addView(view2, i);
        }
    }

    @Override // com.baidu.searchbox.crius.ui.CriusUI, com.baidu.searchbox.crius.ui.RenderImplInterface
    public void removeChild(CriusData criusData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, criusData) == null) && criusData.hasUI()) {
            ((RelativeLayout) this.mView).removeView(criusData.getUI().getView());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.searchbox.crius.ui.view.RoundCornerRelativeLayout' to match base method */
    @Override // com.baidu.searchbox.crius.ui.CriusUI
    public RelativeLayout createView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            RoundCornerRelativeLayout roundCornerRelativeLayout = new RoundCornerRelativeLayout(context);
            if (hasRadius()) {
                roundCornerRelativeLayout.setCornerRadius(this.renderObject.convertedBorderRadius());
                roundCornerRelativeLayout.setCornerRadius(this.renderObject.convertedBorderRadiusLT(), this.renderObject.convertedBorderRadiusRT(), this.renderObject.convertedBorderRadiusRB(), this.renderObject.convertedBorderRadiusLB());
            }
            return roundCornerRelativeLayout;
        }
        return (RoundCornerRelativeLayout) invokeL.objValue;
    }
}
