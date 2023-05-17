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
import com.baidu.android.common.ui.style.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IconFontImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mIconFontColor = -16777216;
        this.mPressedIconFontColor = 0;
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, this, context, attributeSet, i) == null) {
            this.mContext = context;
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IconFontImageView, i, 0);
                String string = obtainStyledAttributes.getString(0);
                this.mIconFont = obtainStyledAttributes.getString(1);
                this.mPressedIconFont = obtainStyledAttributes.getString(3);
                this.mIconFontColor = obtainStyledAttributes.getColor(2, -16777216);
                this.mPressedIconFontColor = obtainStyledAttributes.getColor(4, 0);
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
        if ((interceptable != null && interceptable.invokeL(65541, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mIconFont = str;
        initIconFontDrawable(this.mContext);
        this.mDrawable.setIconFont(this.mIconFont);
    }

    private void setPressedIconFont(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mPressedIconFont = str;
    }

    public void setFontPath(@StringRes int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || i < 0) {
            return;
        }
        setFontPath(getContext().getResources().getString(i));
    }

    public void setIconFontColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048580, this, i) != null) || i == 0) {
            return;
        }
        this.mIconFontColor = i;
        initIconFontDrawable(this.mContext);
        this.mDrawable.setIconFontColor(this.mIconFontColor);
    }

    public void setIconFontColorId(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || i < 0) {
            return;
        }
        setIconFontColor(getContext().getResources().getColor(i));
    }

    public void setPressedIconFontColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048583, this, i) != null) || i == 0) {
            return;
        }
        this.mPressedIconFontColor = i;
    }

    public void setPressedIconFontColorId(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) != null) || i < 0) {
            return;
        }
        setPressedIconFontColor(getContext().getResources().getColor(i));
    }

    private void updateDrawableState(String str, int i) {
        IconFontDrawable iconFontDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65543, this, str, i) == null) && (iconFontDrawable = this.mDrawable) != null) {
            iconFontDrawable.setIconFont(str);
            this.mDrawable.setIconFontColor(i);
        }
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

    public void setIconFont(@StringRes int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || i < 0) {
            return;
        }
        setIconFont(getContext().getResources().getString(i));
    }

    public void setPressedIconFont(@StringRes int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || i < 0) {
            return;
        }
        setPressedIconFont(getContext().getResources().getString(i));
    }
}
