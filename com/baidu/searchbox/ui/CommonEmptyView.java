package com.baidu.searchbox.ui;

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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class CommonEmptyView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout mBottomLayout;
    public ButtonStyle mButtonStyle;
    public ImageView mIcon;
    public int mIconResId;
    public TextView mLinkText;
    public TextView mRefreshTextBtn;
    public TextView mSubTitle;
    public TextView mTitle;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class ButtonStyle {
        public static final /* synthetic */ ButtonStyle[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ButtonStyle BLUE;
        public static final ButtonStyle WHITE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(198988730, "Lcom/baidu/searchbox/ui/CommonEmptyView$ButtonStyle;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(198988730, "Lcom/baidu/searchbox/ui/CommonEmptyView$ButtonStyle;");
                    return;
                }
            }
            WHITE = new ButtonStyle("WHITE", 0);
            ButtonStyle buttonStyle = new ButtonStyle("BLUE", 1);
            BLUE = buttonStyle;
            $VALUES = new ButtonStyle[]{WHITE, buttonStyle};
        }

        public ButtonStyle(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ButtonStyle valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ButtonStyle) Enum.valueOf(ButtonStyle.class, str) : (ButtonStyle) invokeL.objValue;
        }

        public static ButtonStyle[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ButtonStyle[]) $VALUES.clone() : (ButtonStyle[]) invokeV.objValue;
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

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            LayoutInflater.from(context).inflate(com.baidu.android.common.ui.R.layout.common_empty_view, (ViewGroup) this, true);
            setBackground(context.getResources().getDrawable(com.baidu.android.common.ui.R.color.empty_layout_backgroud));
            this.mIcon = (ImageView) findViewById(com.baidu.android.common.ui.R.id.emptyview_image);
            this.mTitle = (TextView) findViewById(com.baidu.android.common.ui.R.id.emptyview_title);
            this.mSubTitle = (TextView) findViewById(com.baidu.android.common.ui.R.id.emptyview_subtitle);
            TextView textView = (TextView) findViewById(com.baidu.android.common.ui.R.id.emptyview_link);
            this.mLinkText = textView;
            textView.setOnTouchListener(new TouchStateListener(textView));
            TextView textView2 = (TextView) findViewById(com.baidu.android.common.ui.R.id.emptyview_btn);
            this.mRefreshTextBtn = textView2;
            textView2.setOnTouchListener(new TouchStateListener(textView2));
            this.mBottomLayout = (FrameLayout) findViewById(com.baidu.android.common.ui.R.id.emptyview_bottom_layout);
            setPageResources();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onAttachedToWindow();
            NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener(this) { // from class: com.baidu.searchbox.ui.CommonEmptyView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CommonEmptyView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
                public void onNightModeChanged(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        this.this$0.setPageResources();
                    }
                }
            });
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            FrameLayout frameLayout = this.mBottomLayout;
            if (frameLayout == null || frameLayout.getLayoutParams() == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mBottomLayout.getLayoutParams();
            int i2 = configuration.orientation;
            if (i2 == 1) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(com.baidu.android.common.ui.R.dimen.empty_view_bottom_margin_portrait);
            } else if (i2 == 2) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(com.baidu.android.common.ui.R.dimen.empty_view_bottom_margin_landscape);
            }
            this.mBottomLayout.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDetachedFromWindow();
            NightModeHelper.unsubscribeNightModeChangedEvent(this);
        }
    }

    @Deprecated
    public void resetIconWidthAndHeight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mIcon.getLayoutParams();
            int dimensionPixelSize = getResources().getDimensionPixelSize(com.baidu.android.common.ui.R.dimen.empty_view_icon_size) / 2;
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = dimensionPixelSize;
            this.mIcon.setLayoutParams(layoutParams);
        }
    }

    public void setButtonBackground(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, drawable) == null) {
            this.mRefreshTextBtn.setBackground(drawable);
        }
    }

    public void setButtonResources() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (textView = this.mRefreshTextBtn) == null) {
            return;
        }
        if (this.mButtonStyle == ButtonStyle.BLUE) {
            textView.setBackground(getResources().getDrawable(com.baidu.android.common.ui.R.drawable.emptyview_btn_blue_bg));
            this.mRefreshTextBtn.setTextColor(getResources().getColor(com.baidu.android.common.ui.R.color.UC61));
            return;
        }
        textView.setBackground(getResources().getDrawable(com.baidu.android.common.ui.R.drawable.emptyview_btn_bg_default));
        this.mRefreshTextBtn.setTextColor(getResources().getColor(com.baidu.android.common.ui.R.color.UC63));
    }

    public void setButtonStyle(ButtonStyle buttonStyle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, buttonStyle) == null) {
            this.mButtonStyle = buttonStyle;
            setButtonResources();
        }
    }

    public void setButtonText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mRefreshTextBtn.setText(str);
        }
    }

    public void setButtonTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mRefreshTextBtn.setTextColor(i2);
        }
    }

    @Deprecated
    public void setIcon(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, drawable) == null) {
            this.mIconResId = -1;
            this.mIcon.setImageDrawable(drawable);
        }
    }

    public void setLinkClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            this.mLinkText.setVisibility(0);
            this.mLinkText.setOnClickListener(onClickListener);
        }
    }

    public void setLinkText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.mLinkText.setText(i2);
        }
    }

    public void setPageResources() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            setBackgroundColor(getResources().getColor(com.baidu.android.common.ui.R.color.white));
            ImageView imageView = this.mIcon;
            if (imageView != null && this.mIconResId != -1) {
                imageView.setImageDrawable(getResources().getDrawable(this.mIconResId));
            }
            TextView textView = this.mTitle;
            if (textView != null) {
                textView.setTextColor(getResources().getColor(com.baidu.android.common.ui.R.color.UC58));
            }
            TextView textView2 = this.mSubTitle;
            if (textView2 != null) {
                textView2.setTextColor(getContext().getResources().getColor(com.baidu.android.common.ui.R.color.UC59));
            }
            TextView textView3 = this.mLinkText;
            if (textView3 != null) {
                textView3.setTextColor(getResources().getColor(com.baidu.android.common.ui.R.color.UC60));
            }
            setButtonResources();
        }
    }

    public void setSubTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.mSubTitle.setVisibility(0);
            this.mSubTitle.setText(str);
        }
    }

    public void setTextButtonClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            this.mRefreshTextBtn.setVisibility(0);
            this.mRefreshTextBtn.setOnClickListener(onClickListener);
        }
    }

    public void setTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.mTitle.setText(i2);
        }
    }

    @Deprecated
    public void setTitleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
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
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mRefreshTextBtn.setText(i2);
        }
    }

    @Deprecated
    public void setButtonTextColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, colorStateList) == null) {
            this.mRefreshTextBtn.setTextColor(colorStateList);
        }
    }

    public void setLinkText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.mLinkText.setText(str);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.mTitle.setText(str);
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
        this.mButtonStyle = ButtonStyle.WHITE;
        this.mIconResId = com.baidu.android.common.ui.R.drawable.empty_icon_network;
        init(context);
    }

    public void setIcon(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.mIconResId = i2;
            this.mIcon.setImageDrawable(getResources().getDrawable(i2));
        }
    }

    public void setSubTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.mSubTitle.setVisibility(0);
            this.mSubTitle.setText(i2);
        }
    }
}
