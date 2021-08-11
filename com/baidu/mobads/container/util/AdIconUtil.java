package com.baidu.mobads.container.util;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.filedownloader.MaterialLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AdIconUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AD_TEXT_ID = 65541;
    public static final int BAIDU_LOGO_ID = 65542;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBottom;
    public int mRight;
    public Context mViewContext;

    /* loaded from: classes5.dex */
    public static class AdLogoParameter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mBottom;
        public int mRight;
        public Context mViewContext;

        public AdLogoParameter() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public AdIconUtil build(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? new AdIconUtil(context, this) : (AdIconUtil) invokeL.objValue;
        }

        public AdLogoParameter setMarginBottom(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.mBottom = i2;
                return this;
            }
            return (AdLogoParameter) invokeI.objValue;
        }

        public AdLogoParameter setMarginRight(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.mRight = i2;
                return this;
            }
            return (AdLogoParameter) invokeI.objValue;
        }
    }

    public AdIconUtil(Context context, AdLogoParameter adLogoParameter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adLogoParameter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mViewContext = context;
        this.mRight = adLogoParameter.mRight;
        this.mBottom = adLogoParameter.mBottom;
    }

    public RelativeLayout addAdLogo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            RelativeLayout relativeLayout = new RelativeLayout(this.mViewContext);
            ImageView imageView = new ImageView(this.mViewContext);
            imageView.setId(AD_TEXT_ID);
            MaterialLoader.getInstance(this.mViewContext).loadImageForURLString(imageView, "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png");
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(CommonUtils.dip2px(this.mViewContext, 25.0f), CommonUtils.dip2px(this.mViewContext, 13.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, this.mRight, 0, this.mBottom);
            relativeLayout.addView(imageView, layoutParams);
            ImageView imageView2 = new ImageView(this.mViewContext);
            imageView2.setId(BAIDU_LOGO_ID);
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            MaterialLoader.getInstance(this.mViewContext).loadImageForURLString(imageView2, "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png");
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(CommonUtils.dip2px(this.mViewContext, 13.0f), CommonUtils.dip2px(this.mViewContext, 13.0f));
            layoutParams2.addRule(12);
            layoutParams2.addRule(0, AD_TEXT_ID);
            relativeLayout.addView(imageView2, layoutParams2);
            return relativeLayout;
        }
        return (RelativeLayout) invokeV.objValue;
    }
}
