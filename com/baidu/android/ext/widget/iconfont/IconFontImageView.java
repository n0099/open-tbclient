package com.baidu.android.ext.widget.iconfont;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.ui.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class IconFontImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_ICON_FONT_COLOR = -16777216;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public IconFontDrawable mDrawable;
    public String mIconFont;
    public int mIconFontColor;
    public String mPressedIconFont;
    public int mPressedIconFontColor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IconFontImageView(Context context) {
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

    private void init(Context context, AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, this, context, attributeSet, i2) == null) {
            this.mContext = context;
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IconFontImageView, i2, 0);
                String string = obtainStyledAttributes.getString(R.styleable.IconFontImageView_fontPath);
                this.mIconFont = obtainStyledAttributes.getString(R.styleable.IconFontImageView_iconFont);
                this.mPressedIconFont = obtainStyledAttributes.getString(R.styleable.IconFontImageView_pressedIconFont);
                this.mIconFontColor = obtainStyledAttributes.getColor(R.styleable.IconFontImageView_iconFontColor, -16777216);
                this.mPressedIconFontColor = obtainStyledAttributes.getColor(R.styleable.IconFontImageView_pressedIconFontColor, 0);
                if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(this.mIconFont)) {
                    initIconFontDrawable(context);
                    this.mDrawable.setFontPath(string);
                    this.mDrawable.setIconFont(this.mIconFont);
                    this.mDrawable.setIconFontColor(this.mIconFontColor);
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void initIconFontDrawable(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) && this.mDrawable == null) {
            this.mDrawable = new IconFontDrawable(context);
            setScaleType(ImageView.ScaleType.CENTER);
            setImageDrawable(this.mDrawable);
        }
    }

    private void setIconFont(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mIconFont = str;
        initIconFontDrawable(this.mContext);
        this.mDrawable.setIconFont(this.mIconFont);
    }

    private void setPressedIconFont(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mPressedIconFont = str;
    }

    private void updateDrawableState(String str, int i2) {
        IconFontDrawable iconFontDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65543, this, str, i2) == null) || (iconFontDrawable = this.mDrawable) == null) {
            return;
        }
        iconFontDrawable.setIconFont(str);
        this.mDrawable.setIconFontColor(i2);
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.refreshDrawableState();
            if (isPressed()) {
                updateDrawableState(this.mPressedIconFont, this.mPressedIconFontColor);
            } else {
                updateDrawableState(this.mIconFont, this.mIconFontColor);
            }
        }
    }

    public void setFontPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            initIconFontDrawable(this.mContext);
            this.mDrawable.setFontPath(str);
        }
    }

    public void setIconFontColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || i2 == 0) {
            return;
        }
        this.mIconFontColor = i2;
        initIconFontDrawable(this.mContext);
        this.mDrawable.setIconFontColor(this.mIconFontColor);
    }

    public void setIconFontColorId(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || i2 < 0) {
            return;
        }
        setIconFontColor(getContext().getResources().getColor(i2));
    }

    public void setPressedIconFontColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || i2 == 0) {
            return;
        }
        this.mPressedIconFontColor = i2;
    }

    public void setPressedIconFontColorId(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || i2 < 0) {
            return;
        }
        setPressedIconFontColor(getContext().getResources().getColor(i2));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IconFontImageView(Context context, AttributeSet attributeSet) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IconFontImageView(Context context, AttributeSet attributeSet, int i2) {
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
        this.mIconFontColor = -16777216;
        this.mPressedIconFontColor = 0;
        init(context, attributeSet, i2);
    }

    public void setFontPath(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 < 0) {
            return;
        }
        setFontPath(getContext().getResources().getString(i2));
    }

    public void setPressedIconFont(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || i2 < 0) {
            return;
        }
        setPressedIconFont(getContext().getResources().getString(i2));
    }

    public void setIconFont(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || i2 < 0) {
            return;
        }
        setIconFont(getContext().getResources().getString(i2));
    }
}
