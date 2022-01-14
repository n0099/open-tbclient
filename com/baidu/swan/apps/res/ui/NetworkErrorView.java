package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.c;
import c.a.r0.a.e;
import c.a.r0.a.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class NetworkErrorView extends CommonEmptyView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int THEME_CLASIC = 0;
    public static final int THEME_NIGHT = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f39094e;

    /* loaded from: classes11.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object a;

        public a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkErrorView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b();
    }

    public static void postErrorViewShowEvent(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, view) == null) {
            a aVar = new a(1);
            aVar.a = view;
            BdEventBus.Companion.getDefault().post(aVar);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mRefreshTextBtn.setVisibility(0);
            setTitle(getContext().getString(h.swanapp_tip_net_unavailable));
            setIcon(e.swanapp_error_page_network_error);
        }
    }

    public boolean isNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f39094e == 2 : invokeV.booleanValue;
    }

    public void setBottomLayout(View.OnClickListener onClickListener, View view, RelativeLayout.LayoutParams layoutParams) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, onClickListener, view, layoutParams) == null) || (frameLayout = this.mBottomLayout) == null || view == null) {
            return;
        }
        frameLayout.setVisibility(0);
        this.mBottomLayout.addView(view);
        if (layoutParams != null) {
            this.mBottomLayout.setLayoutParams(layoutParams);
        }
        this.mBottomLayout.setOnClickListener(onClickListener);
    }

    public void setEmptyButtonVisiblity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.mRefreshTextBtn.setVisibility(i2);
        }
    }

    public void setEmptyViewVisiblity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.mIcon.setVisibility(i2);
        }
    }

    public void setNetworkButtonShow(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (textView = this.mLinkText) == null) {
            return;
        }
        textView.setVisibility(z ? 0 : 4);
    }

    public void setReloadClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            setTextButtonClickListener(onClickListener);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            if (i2 == 0) {
                postErrorViewShowEvent(this);
            }
            super.setVisibility(i2);
        }
    }

    public void updateUI(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f39094e = i2;
            if (i2 == 2) {
                setBackgroundColor(-16777216);
                this.mIcon.setAlpha(0.5f);
                this.mTitle.setTextColor(getResources().getColor(c.aiapps_emptyview_title_text_color_night));
                this.mSubTitle.setTextColor(getResources().getColor(c.aiapps_emptyview_subtitle_text_color_night));
                this.mRefreshTextBtn.setTextColor(AppCompatResources.getColorStateList(getContext(), c.swan_app_emptyview_btn_text_color_night));
            } else {
                setBackgroundColor(-1);
                this.mIcon.setAlpha(1.0f);
                this.mTitle.setTextColor(getResources().getColor(c.aiapps_emptyview_title_text_color));
                this.mSubTitle.setTextColor(getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
                this.mRefreshTextBtn.setTextColor(AppCompatResources.getColorStateList(getContext(), c.swan_app_emptyview_btn_text_color));
            }
            this.mIcon.setImageDrawable(getContext().getResources().getDrawable(e.swanapp_error_page_network_error));
            this.mRefreshTextBtn.setBackground(getContext().getResources().getDrawable(e.aiapps_emptyview_btn_bg));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkErrorView(Context context, AttributeSet attributeSet) {
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
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkErrorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        b();
    }
}
