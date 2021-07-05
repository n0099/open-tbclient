package com.baidu.mobads.container.splash;

import android.graphics.Color;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XBaseAdContainer;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.util.ScreenUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class XSplashSpecialAdContainer extends XBaseAdContainer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IXAdInstanceInfo mAdInstanceInfo;
    public TextView textView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XSplashSpecialAdContainer(XAdContainerContext xAdContainerContext) {
        super(xAdContainerContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xAdContainerContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((XAdContainerContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.textView = null;
        this.mAdInstanceInfo = this.mAdContainerCxt.getAdInstanceInfo();
    }

    public void addWifiHint() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || "bb3808eb".equals(this.mAdContainerCxt.getAppsid())) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = ScreenUtils.getPixel(this.mAppContext, 14);
        layoutParams.leftMargin = ScreenUtils.getPixel(this.mAppContext, 14);
        TextView textView = new TextView(this.mActivity);
        this.textView = textView;
        textView.setText("已于Wi-Fi环境预加载");
        this.textView.setTextColor(Color.parseColor("#999999"));
        this.textView.setTextSize(0, ScreenUtils.getPixel(this.mActivity, 11));
        this.mAdContainerCxt.getAdProdBase().addView(this.textView, layoutParams);
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.textView = null;
            super.destroy();
        }
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.load();
        }
    }
}
