package com.baidu.mobads.container.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.util.AdResource;
import com.baidu.mobads.container.util.ScreenUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class XAdUIMoreDetailTipView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context context;
    public ImageView mImageView;
    public int parentViewId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XAdUIMoreDetailTipView(XAdContainerContext xAdContainerContext, int i2, int i3) {
        super(xAdContainerContext.getAdProdBase().getContext());
        Bitmap lp;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xAdContainerContext, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.parentViewId = 10;
        this.parentViewId = i3;
        this.context = xAdContainerContext.getAdProdBase().getContext();
        setGravity(17);
        this.mImageView = new ImageView(this.context);
        if (i2 == 2) {
            lp = AdResource.getDL();
        } else {
            lp = AdResource.getLP();
        }
        try {
            ImageView.class.getMethod("setBackground", BitmapDrawable.class).invoke(this.mImageView, new BitmapDrawable(this.context.getResources(), lp));
        } catch (Exception unused) {
            this.mImageView.setBackgroundDrawable(new BitmapDrawable(this.context.getResources(), lp));
        }
        this.mImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.mImageView);
        initLayout(xAdContainerContext);
    }

    private void initLayout(XAdContainerContext xAdContainerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, xAdContainerContext) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenUtils.getPixel(xAdContainerContext.getActivity(), (int) Math.round(77.0d)), ScreenUtils.getPixel(xAdContainerContext.getActivity(), (int) Math.round(33.0d)));
            layoutParams.addRule(11, this.parentViewId);
            layoutParams.addRule(12, this.parentViewId);
            layoutParams.rightMargin = ScreenUtils.getPixel(xAdContainerContext.getActivity(), 30);
            layoutParams.bottomMargin = ScreenUtils.getPixel(xAdContainerContext.getActivity(), 10);
            setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onDetachedFromWindow();
        }
    }
}
