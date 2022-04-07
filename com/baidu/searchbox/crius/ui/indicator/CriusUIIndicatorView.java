package com.baidu.searchbox.crius.ui.indicator;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.crius.CriusNode;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.ui.CriusUI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class CriusUIIndicatorView extends CriusUI<SwiperIndicatorView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwiperIndicatorView mIndicatorView;
    public ViewPager mRelatedVp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CriusUIIndicatorView(Context context, CriusData criusData) {
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

    private ViewPager getRelatedViewPager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            CriusData criusData = this.renderObject.parent;
            if (criusData != null && criusData.children != null) {
                for (int i = 0; i < criusData.children.size(); i++) {
                    CriusData criusData2 = criusData.children.get(i);
                    if (TextUtils.equals(NativeConstants.TYPE_SWIPER, criusData2.type) && TextUtils.equals(this.renderObject.indicatorAttrs.swiperId, criusData2.swiperAttrs.id)) {
                        return (ViewPager) criusData2.getUI().getView();
                    }
                }
            }
            return null;
        }
        return (ViewPager) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.crius.ui.CriusUI, com.baidu.searchbox.crius.ui.RenderImplInterface
    public void layout(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            CriusData criusData = this.renderObject;
            if (criusData != null && criusData.parent != null) {
                if (criusData.indicatorAttrs.isHorizontalCenter) {
                    if (getView().getVisibility() == 8) {
                        return;
                    }
                    CriusData criusData2 = this.renderObject;
                    CriusNode criusNode = criusData2.criusNode;
                    CriusData criusData3 = criusData2.parent;
                    View view2 = (View) criusNode.getData();
                    float layoutWidth = criusData3.criusNode.getLayoutWidth();
                    view2.measure(View.MeasureSpec.makeMeasureSpec(Math.round(criusNode.getLayoutWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(criusNode.getLayoutHeight()), 1073741824));
                    int round = Math.round(f + ((layoutWidth - view2.getMeasuredWidth()) / 2.0f));
                    int round2 = Math.round(f2 + criusNode.getLayoutY());
                    view2.layout(round, round2, view2.getMeasuredWidth() + round, view2.getMeasuredHeight() + round2);
                    return;
                }
                super.layout(f, f2);
                return;
            }
            super.layout(f, f2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.crius.ui.CriusUI
    public SwiperIndicatorView createView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            ViewPager relatedViewPager = getRelatedViewPager();
            this.mRelatedVp = relatedViewPager;
            if (relatedViewPager == null) {
                return null;
            }
            SwiperIndicatorView swiperIndicatorView = new SwiperIndicatorView(context);
            this.mIndicatorView = swiperIndicatorView;
            swiperIndicatorView.setRenderData(this.renderObject);
            this.mIndicatorView.attachViewPager(this.mRelatedVp);
            return this.mIndicatorView;
        }
        return (SwiperIndicatorView) invokeL.objValue;
    }
}
