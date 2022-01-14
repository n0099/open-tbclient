package com.baidu.android.lbspay.view;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.statusbar.ImmersiveStatusBarManager;
import com.dxmpay.apollon.statusbar.StatusBarUtils;
import com.dxmpay.apollon.utils.ResUtils;
/* loaded from: classes10.dex */
public class TitleBar extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout leftBtn;
    public View mStatusBarTop;
    public ImageView rightBtn;
    public TextView titleTv;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TitleBar(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onFinishInflate();
            this.titleTv = (TextView) findViewById(ResUtils.id(getContext(), "title_tv"));
            this.leftBtn = (LinearLayout) findViewById(ResUtils.id(getContext(), "left_btn_container"));
            this.rightBtn = (ImageView) findViewById(ResUtils.id(getContext(), "title_right_btn"));
            this.mStatusBarTop = findViewById(ResUtils.id(getContext(), "titlebar_statusbar_top"));
            setTop();
        }
    }

    public void setLeftButton(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            if (onClickListener == null) {
                this.leftBtn.setVisibility(8);
                return;
            }
            this.leftBtn.setVisibility(0);
            this.leftBtn.setOnClickListener(onClickListener);
        }
    }

    public void setRightButton(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            if (onClickListener == null) {
                this.rightBtn.setVisibility(8);
                return;
            }
            this.rightBtn.setVisibility(0);
            this.rightBtn.setOnClickListener(onClickListener);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.titleTv.setText(str);
        }
    }

    public void setTop() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        Activity activity = getContext() instanceof Activity ? (Activity) getContext() : null;
        if (activity == null) {
            return;
        }
        this.mStatusBarTop.setLayoutParams(new LinearLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(activity)));
        ImmersiveStatusBarManager.setTopBar(activity, this.mStatusBarTop, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
