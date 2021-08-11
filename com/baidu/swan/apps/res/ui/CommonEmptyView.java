package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.c;
import c.a.n0.a.d;
import c.a.n0.a.e;
import c.a.n0.a.f;
import c.a.n0.a.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class CommonEmptyView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout mBottomLayout;
    public TextView mFeedbackBtn;
    public ImageView mIcon;
    public TextView mLinkText;
    public TextView mRefreshTextBtn;
    public TextView mSubTitle;
    public TextView mTitle;

    /* loaded from: classes6.dex */
    public class a implements c.a.n0.a.g2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonEmptyView f46037a;

        public a(CommonEmptyView commonEmptyView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmptyView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46037a = commonEmptyView;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonEmptyView(Context context) {
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

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(g.aiapps_common_empty_view, (ViewGroup) this, true);
            setBackground(context.getResources().getDrawable(c.aiapps_empty_layout_backgroud));
            this.mIcon = (ImageView) findViewById(f.emptyview_image);
            this.mTitle = (TextView) findViewById(f.emptyview_title);
            this.mSubTitle = (TextView) findViewById(f.emptyview_subtitle);
            this.mLinkText = (TextView) findViewById(f.emptyview_link);
            this.mRefreshTextBtn = (TextView) findViewById(f.emptyview_btn);
            this.mBottomLayout = (FrameLayout) findViewById(f.emptyview_bottom_layout);
            this.mFeedbackBtn = (TextView) findViewById(f.emptyview_problem_feedback);
            setPageResources();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAttachedToWindow();
            c.a.n0.a.c1.a.H().f(this, new a(this));
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            FrameLayout frameLayout = this.mBottomLayout;
            if (frameLayout == null || frameLayout.getLayoutParams() == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mBottomLayout.getLayoutParams();
            int i2 = configuration.orientation;
            if (i2 == 1) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(d.aiapps_empty_view_bottom_margin_portrait);
            } else if (i2 == 2) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(d.aiapps_empty_view_bottom_margin_landscape);
            }
            this.mBottomLayout.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            c.a.n0.a.c1.a.H().g(this);
        }
    }

    public void resetIconWidthAndHeight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mIcon.getLayoutParams();
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.aiapps_empty_view_icon_size) / 2;
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = dimensionPixelSize;
            this.mIcon.setLayoutParams(layoutParams);
        }
    }

    public void setButtonText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.mRefreshTextBtn.setText(str);
        }
    }

    public void setButtonTextColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, colorStateList) == null) {
            this.mRefreshTextBtn.setTextColor(colorStateList);
        }
    }

    public void setIcon(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, drawable) == null) {
            this.mIcon.setImageDrawable(drawable);
        }
    }

    public void setLinkClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.mLinkText.setVisibility(0);
            this.mLinkText.setOnClickListener(onClickListener);
        }
    }

    public void setPageResources() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            setBackgroundColor(-1);
            TextView textView = this.mTitle;
            if (textView != null) {
                textView.setTextColor(getResources().getColor(c.aiapps_emptyview_title_text_color));
            }
            TextView textView2 = this.mLinkText;
            if (textView2 != null) {
                textView2.setTextColor(getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
            }
            TextView textView3 = this.mRefreshTextBtn;
            if (textView3 != null) {
                textView3.setBackground(getResources().getDrawable(e.aiapps_emptyview_btn_bg));
                this.mRefreshTextBtn.setTextColor(getResources().getColorStateList(c.swan_app_emptyview_btn_text_color));
            }
            TextView textView4 = this.mSubTitle;
            if (textView4 != null) {
                textView4.setTextColor(getContext().getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
            }
        }
    }

    public void setSubTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mSubTitle.setVisibility(0);
            this.mSubTitle.setText(str);
            this.mSubTitle.setTextColor(getContext().getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
        }
    }

    public void setTextButtonClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            this.mRefreshTextBtn.setVisibility(0);
            this.mRefreshTextBtn.setOnClickListener(onClickListener);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.mTitle.setText(str);
        }
    }

    public void setTitleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.mTitle.setTextColor(i2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonEmptyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void setButtonText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.mRefreshTextBtn.setText(i2);
        }
    }

    public void setIcon(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.mIcon.setImageDrawable(getResources().getDrawable(i2));
        }
    }

    public void setTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mTitle.setText(i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonEmptyView(Context context, AttributeSet attributeSet, int i2) {
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
        a(context);
    }

    public void setSubTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.mSubTitle.setVisibility(0);
            this.mSubTitle.setText(i2);
            this.mSubTitle.setTextColor(getContext().getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
        }
    }
}
