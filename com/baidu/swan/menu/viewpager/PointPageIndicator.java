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
/* loaded from: classes4.dex */
public class PointPageIndicator extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Drawable a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f29681b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f29682c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f29683d;

    /* renamed from: e  reason: collision with root package name */
    public int f29684e;

    /* renamed from: f  reason: collision with root package name */
    public int f29685f;

    /* renamed from: g  reason: collision with root package name */
    public int f29686g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointPageIndicator(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f29681b = null;
        this.f29682c = new Rect();
        this.f29683d = new Rect();
        this.f29684e = 0;
        this.f29685f = 0;
        this.f29686g = 0;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
        }
    }

    public PointPageIndicator b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            this.f29685f = i;
            invalidate();
            return this;
        }
        return (PointPageIndicator) invokeI.objValue;
    }

    public PointPageIndicator c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (this.f29686g != i) {
                this.f29686g = i;
                invalidate();
            }
            return this;
        }
        return (PointPageIndicator) invokeI.objValue;
    }

    public PointPageIndicator d(Drawable drawable, Drawable drawable2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, drawable, drawable2)) == null) {
            this.a = drawable;
            this.f29681b = drawable2;
            if (drawable instanceof BitmapDrawable) {
                this.f29682c.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            if (drawable2 instanceof BitmapDrawable) {
                this.f29683d.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            }
            return this;
        }
        return (PointPageIndicator) invokeLL.objValue;
    }

    public PointPageIndicator e(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i, i2)) == null) {
            Resources resources = getResources();
            return d(resources.getDrawable(i), resources.getDrawable(i2));
        }
        return (PointPageIndicator) invokeII.objValue;
    }

    public PointPageIndicator f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.f29684e = i;
            return this;
        }
        return (PointPageIndicator) invokeI.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            super.onDraw(canvas);
            int i = this.f29686g;
            if (i <= 0) {
                return;
            }
            int i2 = this.f29684e;
            int height = getHeight();
            int width2 = getWidth();
            int i3 = this.f29685f;
            Rect rect = this.f29682c;
            Rect rect2 = this.f29683d;
            Drawable drawable = this.a;
            Drawable drawable2 = this.f29681b;
            int i4 = i - 1;
            int width3 = (width2 - (((i2 * i4) + (rect.width() * i4)) + rect2.width())) / 2;
            for (int i5 = 0; i5 < i; i5++) {
                if (i5 == i3) {
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
                width3 += width + i2;
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f29681b = null;
        this.f29682c = new Rect();
        this.f29683d = new Rect();
        this.f29684e = 0;
        this.f29685f = 0;
        this.f29686g = 0;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointPageIndicator(Context context, AttributeSet attributeSet, int i) {
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
        this.a = null;
        this.f29681b = null;
        this.f29682c = new Rect();
        this.f29683d = new Rect();
        this.f29684e = 0;
        this.f29685f = 0;
        this.f29686g = 0;
        a(context);
    }
}
