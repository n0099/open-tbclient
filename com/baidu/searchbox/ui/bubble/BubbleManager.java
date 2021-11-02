package com.baidu.searchbox.ui.bubble;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.bubble.builder.BubbleJumpArrowBuilder;
import com.baidu.searchbox.ui.bubble.builder.BubbleTextBuilder;
import com.baidu.searchbox.ui.bubble.manager.BubbleButtonManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BubbleManager extends BubbleButtonManager implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "BubbleManager";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class BubbleStyle {
        public static final /* synthetic */ BubbleStyle[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BubbleStyle TextOnly;
        public static final BubbleStyle TextWithJumpArrow;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-689722501, "Lcom/baidu/searchbox/ui/bubble/BubbleManager$BubbleStyle;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-689722501, "Lcom/baidu/searchbox/ui/bubble/BubbleManager$BubbleStyle;");
                    return;
                }
            }
            TextOnly = new BubbleStyle("TextOnly", 0);
            BubbleStyle bubbleStyle = new BubbleStyle("TextWithJumpArrow", 1);
            TextWithJumpArrow = bubbleStyle;
            $VALUES = new BubbleStyle[]{TextOnly, bubbleStyle};
        }

        public BubbleStyle(String str, int i2) {
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

        public static BubbleStyle valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BubbleStyle) Enum.valueOf(BubbleStyle.class, str) : (BubbleStyle) invokeL.objValue;
        }

        public static BubbleStyle[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BubbleStyle[]) $VALUES.clone() : (BubbleStyle[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BubbleManager mBubbleManager;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder() {
            this(new BubbleManager());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this((BubbleManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public BubbleManager build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBubbleManager : (BubbleManager) invokeV.objValue;
        }

        public Builder enableAnchorClk(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.mBubbleManager.enableAnchorClk(z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder enableAnimation(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.mBubbleManager.enableAnimation(z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder enableBgClk(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.mBubbleManager.enableBgClk(z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder enableClkDismiss(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.mBubbleManager.enableClkDismiss(z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder isAutoDetectShowPosition(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.mBubbleManager.mLocation.mIsAutoDetectShowPosition = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setAnchor(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) {
                this.mBubbleManager.mViews.setAnchor(view);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAnchorAndRootView(View view, ViewGroup viewGroup) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, view, viewGroup)) == null) {
                this.mBubbleManager.mViews.setAnchorAndRootView(view, viewGroup);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setAutoDismiss(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.mBubbleManager.setAutoDismiss(z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setAutoDismissInterval(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                this.mBubbleManager.setAutoDismissInterval(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @Deprecated
        public Builder setBackground(@ColorInt int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                this.mBubbleManager.mViews.setDayModeBackground(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setBtnFontSize(int i2, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
                this.mBubbleManager.mButtonViews.setBtnFontSizew(i2, f2);
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder setBtnText(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, charSequence)) == null) {
                this.mBubbleManager.setBtnText(charSequence);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDayModeBackgroundColor(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    str = "#CC000000";
                }
                try {
                    this.mBubbleManager.mViews.setDayModeBackground(Color.parseColor(str));
                    return this;
                } catch (Exception unused) {
                    this.mBubbleManager.mViews.setDayModeBackground(Color.parseColor("#CC000000"));
                    return this;
                }
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setFontSize(int i2, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
                this.mBubbleManager.setFontSizew(i2, f2);
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder setForceShowLeftEndPoint() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                this.mBubbleManager.mLocation.isShowLeftEndPoint = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public Builder setForceShowPosition(BubblePosition bubblePosition) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, bubblePosition)) == null) {
                this.mBubbleManager.mLocation.mIsAutoDetectShowPosition = false;
                this.mBubbleManager.mLocation.mBubbleForceShowPosition = bubblePosition;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setNightBackgroundColor(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    str = "#CC000000";
                }
                try {
                    this.mBubbleManager.mViews.setNightModeBackground(Color.parseColor(str));
                    return this;
                } catch (Exception unused) {
                    this.mBubbleManager.mViews.setNightModeBackground(Color.parseColor("#CC000000"));
                    return this;
                }
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setOffsetOfArrow(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048594, this, f2)) == null) {
                this.mBubbleManager.setOffsetOfArrow(f2);
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder setOnAnchorClickListener(OnAnchorClickListener onAnchorClickListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, onAnchorClickListener)) == null) {
                this.mBubbleManager.setOnAnchorEventListener(onAnchorClickListener);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setOnBtnClickListener(OnBtnClickListener onBtnClickListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, onBtnClickListener)) == null) {
                this.mBubbleManager.setOnBtnClickListener(onBtnClickListener);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setOnBubbleEventListener(OnBubbleEventListener onBubbleEventListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, onBubbleEventListener)) == null) {
                this.mBubbleManager.setOnBubbleEventListener(onBubbleEventListener);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setPaddingBetweenAnchor(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048598, this, f2)) == null) {
                this.mBubbleManager.mLocation.setPaddingBetweenAnchor(f2);
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder setText(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, charSequence)) == null) {
                this.mBubbleManager.setText(charSequence);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTextColor(@ColorInt int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
                this.mBubbleManager.setTextColor(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder(BubbleManager bubbleManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleManager};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mBubbleManager = bubbleManager;
        }
    }

    /* loaded from: classes7.dex */
    public interface OnAnchorClickListener {
        void onAnchorClick();
    }

    /* loaded from: classes7.dex */
    public interface OnBtnClickListener {
        void onBtnClick();
    }

    /* loaded from: classes7.dex */
    public interface OnBubbleEventListener {
        void onBubbleClick();

        void onBubbleDismiss();

        void onBubbleShow();
    }

    public BubbleManager() {
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

    public static Builder getBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
    }

    public static <T> T newBuilder(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, cls)) == null) {
            if (cls == BubbleTextBuilder.class || cls == BubbleJumpArrowBuilder.class) {
                try {
                    return cls.newInstance();
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public void dismissBubble() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.dismissBubble();
        }
    }

    public View getBubbleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mViews.mBubbleView : (View) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public OnBubbleEventListener getOnBubbleEventListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.getOnBubbleEventListener() : (OnBubbleEventListener) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public boolean isDismissed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? super.isDismissed() : invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            onClickCore(view);
        }
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleTextManager
    public void onNightModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            updateBubble(z ? this.mViews.getBgColorNight() : this.mViews.getBgColorDay());
        }
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public void setOnBubbleEventListener(OnBubbleEventListener onBubbleEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onBubbleEventListener) == null) {
            super.setOnBubbleEventListener(onBubbleEventListener);
        }
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleTextManager, com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public void showBubble() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.showBubble();
        }
    }
}
