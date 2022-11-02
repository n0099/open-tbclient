package com.baidu.searchbox.crius.ui.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.ui.CriusUI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class CriusUILayout extends CriusUI<CriusLayout> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CriusUILayout(Context context, CriusData criusData) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.renderObject.convertedBorderRadius() <= 0.0f && this.renderObject.convertedBorderRadiusLT() <= 0.0f && this.renderObject.convertedBorderRadiusRT() <= 0.0f && this.renderObject.convertedBorderRadiusRB() <= 0.0f && this.renderObject.convertedBorderRadiusLB() <= 0.0f) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.crius.ui.CriusUI
    public CriusLayout createView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (hasRadius()) {
                RoundCornerCirusLayout roundCornerCirusLayout = new RoundCornerCirusLayout(context, this.renderObject);
                roundCornerCirusLayout.setCornerRadius(this.renderObject.convertedBorderRadius());
                roundCornerCirusLayout.setCornerRadius(this.renderObject.convertedBorderRadiusLT(), this.renderObject.convertedBorderRadiusRT(), this.renderObject.convertedBorderRadiusRB(), this.renderObject.convertedBorderRadiusLB());
                return roundCornerCirusLayout;
            }
            return new CriusLayout(context, this.renderObject);
        }
        return (CriusLayout) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.crius.ui.CriusUI, com.baidu.searchbox.crius.ui.RenderImplInterface
    public void insertChild(CriusData criusData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, criusData, i) == null) {
            View view2 = criusData.getUI().getView();
            if (view2.getParent() != null) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            ((CriusLayout) this.mView).addView(view2, i, criusData);
        }
    }
}
