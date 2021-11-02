package com.baidu.tbadk.core.util.tbselector.selector;

import android.graphics.drawable.Drawable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class AbsDrawableSelector {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_BACKGROUND = 1;
    public static final int TYPE_SRC = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasSetAlpha;
    public boolean hasSetDisabledDrawable;
    public boolean hasSetFocusedDrawable;
    public boolean hasSetPressedDrawable;
    public boolean hasSetSelectedDrawable;
    public int mAlpha;
    public Drawable mDisabledDrawable;
    public Drawable mFocusedDrawable;
    public Drawable mNormalDrawable;
    public Drawable mPressedDrawable;
    public Drawable mSelectedDrawable;
    public int mType;

    public AbsDrawableSelector() {
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
        this.mType = 1;
        this.hasSetDisabledDrawable = false;
        this.hasSetPressedDrawable = false;
        this.hasSetSelectedDrawable = false;
        this.hasSetFocusedDrawable = false;
        this.hasSetAlpha = false;
    }

    public abstract Drawable onItemDefaultDrawable();

    public abstract Drawable onItemDisabledDrawable();

    public abstract Drawable onItemFocusedDrawable();

    public abstract Drawable onItemPressedDrawable();

    public abstract Drawable onItemSelectedDrawable();

    public void updateDrawableAlpha(Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, drawable) == null) && this.hasSetAlpha && drawable != null) {
            drawable.mutate().setAlpha(this.mAlpha);
        }
    }
}
