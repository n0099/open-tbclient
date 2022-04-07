package com.baidu.searchbox.crius.ui;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.crius.CriusNode;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import view.CriusTextView;
/* loaded from: classes2.dex */
public class CriusUITextView extends CriusUI<CriusTextView> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CriusUITextView";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CriusUITextView(Context context, CriusData criusData) {
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

    private int getLabelTop(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65537, this, i, i2)) == null) {
            float f = i;
            CriusData criusData = this.renderObject;
            if (criusData != null && !TextUtils.isEmpty(criusData.text) && getView() != null) {
                Paint paint = new Paint();
                paint.setTextSize(DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), (float) this.renderObject.fontSize()));
                paint.measureText(this.renderObject.text);
                Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                float f2 = fontMetrics.ascent;
                f += getView().getBaseline() + f2 + (((fontMetrics.descent - f2) - i2) / 2.0f);
            }
            return (int) f;
        }
        return invokeII.intValue;
    }

    @Override // com.baidu.searchbox.crius.ui.CriusUI, com.baidu.searchbox.crius.ui.RenderImplInterface
    public void layout(float f, float f2) {
        CriusData prefixLabel;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            super.layout(f, f2);
            CriusData criusData = this.renderObject;
            if (criusData == null || (prefixLabel = criusData.getPrefixLabel()) == null || prefixLabel.getUI() == null || (view2 = prefixLabel.getUI().getView()) == null || view2.getMeasuredWidth() <= 0 || view2.getMeasuredHeight() <= 0) {
                return;
            }
            CriusNode criusNode = this.renderObject.criusNode;
            int round = Math.round(f + criusNode.getLayoutX());
            int labelTop = getLabelTop(Math.round(f2 + criusNode.getLayoutY()), view2.getMeasuredHeight());
            view2.layout(round, labelTop, view2.getMeasuredWidth() + round, view2.getMeasuredHeight() + labelTop);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.crius.ui.CriusUI
    public CriusTextView createView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            new CriusTextView(context).setIncludeFontPadding(true);
            return new CriusTextView(context);
        }
        return (CriusTextView) invokeL.objValue;
    }
}
