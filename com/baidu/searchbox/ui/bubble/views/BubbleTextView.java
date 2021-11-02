package com.baidu.searchbox.ui.bubble.views;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.ui.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.bubble.ArrowView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BubbleTextView extends BubbleBaseView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float BUBBLE_MINI_ARROW_DOWN_HEIGHT = 6.0f;
    public static final float BUBBLE_MINI_ARROW_DOWN_WIDTH = 11.0f;
    public static final float BUBBLE_MINI_BOTTOM_PADDING = 2.0f;
    public static final float BUBBLE_MINI_LEFT_PADDING = 10.0f;
    public static final float BUBBLE_MINI_RIGHT_PADDING = 7.0f;
    public static final float BUBBLE_MINI_TOP_PADDING = 2.0f;
    public static final String TAG = "BubbleTextManager";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsMiniBubble;
    public CharSequence mShowText;
    public float mSize;
    @ColorInt
    public int mTextDayColor;
    @ColorInt
    public int mTextNightColor;
    public int mUnit;

    public BubbleTextView() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTextDayColor = -1;
        this.mTextNightColor = -1;
        this.mUnit = -1;
        this.mSize = -1.0f;
        this.mIsMiniBubble = false;
    }

    private void adjustBubbleSize() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            ViewGroup viewGroup = this.mBubbleContent;
            if (viewGroup != null && (layoutParams = viewGroup.getLayoutParams()) != null) {
                layoutParams.width = -2;
                Context context = this.mBubbleContent.getContext();
                layoutParams.height = -2;
                this.mBubbleContent.setPadding(DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 10.0f), DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 2.0f), DeviceUtils.ScreenInfo.dp2px(context, 7.0f), DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 2.0f));
                this.mBubbleContent.setLayoutParams(layoutParams);
                this.mBubbleText.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.bubble_mini_text_size));
            }
            ArrowView arrowView = this.mArrowDown;
            if (arrowView != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) arrowView.getLayoutParams();
                layoutParams2.height = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 6.0f);
                layoutParams2.width = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 11.0f);
                this.mArrowDown.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public int getBubbleViewResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.bubble_tip_d20 : invokeV.intValue;
    }

    public int getTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (NightModeHelper.getNightModeSwitcherState()) {
                int i2 = this.mTextNightColor;
                if (i2 != -1) {
                    return i2;
                }
            } else {
                int i3 = this.mTextDayColor;
                if (i3 != -1) {
                    return i3;
                }
            }
            return AppRuntime.getAppContext().getResources().getColor(R.color.UC28);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public boolean initViewIfNeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (super.initViewIfNeed()) {
                int textColor = getTextColor();
                TextView textView = (TextView) this.mBubbleView.findViewById(R.id.bubble_text);
                this.mBubbleText = textView;
                textView.setTextColor(textColor);
                this.mBubbleText.setVisibility(0);
                if (this.mIsMiniBubble) {
                    adjustBubbleSize();
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void isMiniBubble(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.mIsMiniBubble = z;
        }
    }

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public boolean isValidate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? !TextUtils.isEmpty(this.mShowText) && super.isValidate() : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public void resetAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.resetAll();
            this.mShowText = null;
        }
    }

    public void setBubbleText(CharSequence charSequence, int i2, int i3, float f2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)}) == null) || (textView = this.mBubbleText) == null) {
            return;
        }
        if (charSequence != null) {
            textView.setText(charSequence);
        }
        this.mBubbleText.setTextColor(i2);
        if (i3 < 0 || f2 <= 0.0f) {
            return;
        }
        this.mBubbleText.setTextSize(i3, f2);
    }

    public void setText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, charSequence) == null) {
            TextUtils.isEmpty(charSequence);
            this.mShowText = charSequence;
        }
    }

    public void setTextColor(@ColorInt int i2, @ColorInt int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            this.mTextDayColor = i2;
            this.mTextNightColor = i3;
        }
    }
}
