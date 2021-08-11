package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class PointPageIndicator extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f46992e;

    /* renamed from: f  reason: collision with root package name */
    public int f46993f;

    /* renamed from: g  reason: collision with root package name */
    public int f46994g;
    public Drawable mNormalDrawable;
    public Rect mNormalPointRect;
    public Drawable mSelectDrawable;
    public Rect mSelectPointRect;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointPageIndicator(Context context) {
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
        this.mNormalDrawable = null;
        this.mSelectDrawable = null;
        this.mNormalPointRect = new Rect();
        this.mSelectPointRect = new Rect();
        this.f46992e = 0;
        this.f46993f = 0;
        this.f46994g = 0;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.onDraw(canvas);
            int i2 = this.f46994g;
            if (i2 <= 0) {
                return;
            }
            int i3 = this.f46992e;
            int height = getHeight();
            int width2 = getWidth();
            int i4 = this.f46993f;
            Rect rect = this.mNormalPointRect;
            Rect rect2 = this.mSelectPointRect;
            Drawable drawable = this.mNormalDrawable;
            Drawable drawable2 = this.mSelectDrawable;
            int i5 = i2 - 1;
            int width3 = (width2 - (((i3 * i5) + (rect.width() * i5)) + rect2.width())) / 2;
            for (int i6 = 0; i6 < i2; i6++) {
                if (i6 == i4) {
                    if (drawable2 != null) {
                        rect2.offsetTo(width3, (height - rect2.height()) / 2);
                        drawable2.setBounds(rect2);
                        drawable2.draw(canvas);
                    }
                    width = rect2.width();
                } else {
                    if (drawable != null) {
                        rect.offsetTo(width3, (height - rect.height()) / 2);
                        drawable.setBounds(rect);
                        drawable.draw(canvas);
                    }
                    width = rect.width();
                }
                width3 += width + i3;
            }
        }
    }

    public PointPageIndicator setCurrentPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.f46993f = i2;
            invalidate();
            return this;
        }
        return (PointPageIndicator) invokeI.objValue;
    }

    public PointPageIndicator setPointCount(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (this.f46994g != i2) {
                this.f46994g = i2;
                invalidate();
            }
            return this;
        }
        return (PointPageIndicator) invokeI.objValue;
    }

    public PointPageIndicator setPointDrawable(Drawable drawable, Drawable drawable2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, drawable, drawable2)) == null) {
            this.mNormalDrawable = drawable;
            this.mSelectDrawable = drawable2;
            if (drawable instanceof BitmapDrawable) {
                this.mNormalPointRect.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            if (drawable2 instanceof BitmapDrawable) {
                this.mSelectPointRect.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            }
            return this;
        }
        return (PointPageIndicator) invokeLL.objValue;
    }

    public PointPageIndicator setPointDrawableResId(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) {
            Resources resources = getResources();
            return setPointDrawable(resources.getDrawable(i2), resources.getDrawable(i3));
        }
        return (PointPageIndicator) invokeII.objValue;
    }

    public PointPageIndicator setPointMargin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.f46992e = i2;
            return this;
        }
        return (PointPageIndicator) invokeI.objValue;
    }

    public PointPageIndicator setPointSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            this.mNormalPointRect.set(0, 0, i2, i2);
            this.mSelectPointRect.set(0, 0, i2, i2);
            return this;
        }
        return (PointPageIndicator) invokeI.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointPageIndicator(Context context, AttributeSet attributeSet) {
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
        this.mNormalDrawable = null;
        this.mSelectDrawable = null;
        this.mNormalPointRect = new Rect();
        this.mSelectPointRect = new Rect();
        this.f46992e = 0;
        this.f46993f = 0;
        this.f46994g = 0;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointPageIndicator(Context context, AttributeSet attributeSet, int i2) {
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
        this.mNormalDrawable = null;
        this.mSelectDrawable = null;
        this.mNormalPointRect = new Rect();
        this.mSelectPointRect = new Rect();
        this.f46992e = 0;
        this.f46993f = 0;
        this.f46994g = 0;
        a(context);
    }
}
