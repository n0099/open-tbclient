package com.baidu.searchbox.crius.ui.swiper;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.crius.CriusNode;
import com.baidu.searchbox.crius.CriusRuntime;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.ui.CriusUI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class CriusUISwiperView extends CriusUI<CriusSwiperView> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CriusUISwiperView";
    public transient /* synthetic */ FieldHolder $fh;
    public CriusSwiperAdapter mAdapter;
    public CriusSwiperView mCriusSwiperView;
    public SwiperItemHelper mItemHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CriusUISwiperView(Context context, CriusData criusData) {
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

    @Override // com.baidu.searchbox.crius.ui.CriusUI, com.baidu.searchbox.crius.ui.RenderImplInterface
    public void insertChild(CriusData criusData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, criusData, i) == null) {
            this.mAdapter.appendChildAt(criusData, i);
            this.mCriusSwiperView.resetCurrentIndex();
        }
    }

    @Override // com.baidu.searchbox.crius.ui.CriusUI, com.baidu.searchbox.crius.ui.RenderImplInterface
    public void layout(float f, float f2) {
        CriusData criusData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            CriusData criusData2 = this.renderObject;
            if (criusData2 != null && (criusData = criusData2.parent) != null) {
                if (criusData.isAlignItems("center") && this.renderObject.criusNode.getLayoutWidth() == 0.0f) {
                    if (CriusRuntime.DEBUG) {
                        Log.d(TAG, "#CriusUISwiperView#, AlignItems Center, modify default layout!");
                    }
                    CriusNode criusNode = this.renderObject.criusNode;
                    View view2 = (View) criusNode.getData();
                    int round = Math.round(f);
                    int round2 = Math.round(f2 + this.renderObject.criusNode.getLayoutY());
                    view2.measure(View.MeasureSpec.makeMeasureSpec(Math.round(criusNode.getLayoutWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(criusNode.getLayoutHeight()), 1073741824));
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
    public CriusSwiperView createView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            SwiperItemHelper swiperItemHelper = new SwiperItemHelper();
            this.mItemHelper = swiperItemHelper;
            this.mAdapter = new CriusSwiperAdapter(context, swiperItemHelper);
            CriusSwiperView criusSwiperView = new CriusSwiperView(context);
            this.mCriusSwiperView = criusSwiperView;
            criusSwiperView.init(this.renderObject.swiperAttrs);
            this.mCriusSwiperView.setAdapter(this.mAdapter);
            return this.mCriusSwiperView;
        }
        return (CriusSwiperView) invokeL.objValue;
    }
}
