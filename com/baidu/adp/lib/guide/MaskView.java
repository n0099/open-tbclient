package com.baidu.adp.lib.guide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes.dex */
public class MaskView extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RectF a;
    public final RectF b;
    public final RectF c;
    public final Paint d;
    public final Path e;
    public boolean f;
    public boolean g;
    public final Paint h;
    public final Paint i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaskView(Context context) {
        this(context, null, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new LayoutParams(-2, -2) : (LayoutParams) invokeV.objValue;
    }

    public final void b(View view2, RectF rectF, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, rectF, i) == null) {
            if (i == 16) {
                float f = this.a.left;
                rectF.left = f;
                rectF.right = f + view2.getMeasuredWidth();
            } else if (i == 32) {
                rectF.left = (this.a.width() - view2.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.a.width() + view2.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.a.left, 0.0f);
            } else if (i != 48) {
            } else {
                float f2 = this.a.right;
                rectF.right = f2;
                rectF.left = f2 - view2.getMeasuredWidth();
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.reset();
            this.e.addRect(this.a, Path.Direction.CW);
            this.e.addRect(this.b, Path.Direction.CW);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.d.setAlpha(i);
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            long drawingTime = getDrawingTime();
            canvas.save();
            canvas.drawRect(this.b, this.d);
            canvas.restore();
            for (int i = 0; i < getChildCount(); i++) {
                try {
                    drawChild(canvas, getChildAt(i), drawingTime);
                } catch (NullPointerException unused) {
                    return;
                }
            }
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.d.setColor(i);
            invalidate();
        }
    }

    public void f(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rect) == null) {
            this.b.set(rect);
            c();
            this.f = true;
            invalidate();
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    public void h(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, rect) == null) {
            this.a.set(rect);
            c();
            invalidate();
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.g = z;
        }
    }

    public final void j(View view2, RectF rectF, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048587, this, view2, rectF, i) == null) {
            if (i == 16) {
                float f = this.a.top;
                rectF.top = f;
                rectF.bottom = f + view2.getMeasuredHeight();
            } else if (i == 32) {
                rectF.top = (this.a.width() - view2.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.a.width() + view2.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.a.top);
            } else if (i != 48) {
            } else {
                RectF rectF2 = this.a;
                rectF.bottom = rectF2.bottom;
                rectF.top = rectF2.bottom - view2.getMeasuredHeight();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDetachedFromWindow();
            try {
                clearFocus();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int childCount = getChildCount();
            float f = getResources().getDisplayMetrics().density;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != null && (layoutParams = (LayoutParams) childAt.getLayoutParams()) != null) {
                    int i6 = layoutParams.a;
                    if (i6 == 1) {
                        RectF rectF = this.c;
                        float f2 = this.a.left;
                        rectF.right = f2;
                        rectF.left = f2 - childAt.getMeasuredWidth();
                        j(childAt, this.c, layoutParams.b);
                    } else if (i6 == 2) {
                        RectF rectF2 = this.c;
                        float f3 = this.a.top;
                        rectF2.bottom = f3;
                        rectF2.top = f3 - childAt.getMeasuredHeight();
                        b(childAt, this.c, layoutParams.b);
                    } else if (i6 == 3) {
                        RectF rectF3 = this.c;
                        float f4 = this.a.right;
                        rectF3.left = f4;
                        rectF3.right = f4 + childAt.getMeasuredWidth();
                        j(childAt, this.c, layoutParams.b);
                    } else if (i6 == 4) {
                        RectF rectF4 = this.c;
                        float f5 = this.a.bottom;
                        rectF4.top = f5;
                        rectF4.bottom = f5 + childAt.getMeasuredHeight();
                        b(childAt, this.c, layoutParams.b);
                    } else if (i6 == 5) {
                        this.c.left = (((int) this.a.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.c.top = (((int) this.a.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.c.right = (((int) this.a.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.c.bottom = (((int) this.a.height()) + childAt.getMeasuredHeight()) >> 1;
                        RectF rectF5 = this.c;
                        RectF rectF6 = this.a;
                        rectF5.offset(rectF6.left, rectF6.top);
                    }
                    if (this.g) {
                        this.c.offset(layoutParams.c, layoutParams.d);
                    } else {
                        this.c.offset((int) ((layoutParams.c * f) + 0.5f), (int) ((layoutParams.d * f) + 0.5f));
                    }
                    RectF rectF7 = this.c;
                    childAt.layout((int) rectF7.left, (int) rectF7.top, (int) rectF7.right, (int) rectF7.bottom);
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i, i2) == null) {
            int i3 = i & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            setMeasuredDimension(i3, i4);
            if (!this.f) {
                this.b.set(0.0f, 0.0f, i3, i4);
                c();
            }
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != null) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams == null) {
                        childAt.setLayoutParams(layoutParams);
                    }
                    measureChild(childAt, i3 - 2147483648, Integer.MIN_VALUE + i4);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaskView(Context context, AttributeSet attributeSet) {
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
    public MaskView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = new RectF();
        this.b = new RectF();
        this.c = new RectF();
        this.d = new Paint();
        this.e = new Path();
        this.g = false;
        this.h = new Paint();
        Paint paint = new Paint();
        this.i = paint;
        paint.setAntiAlias(true);
        this.h.setColor(SupportMenu.CATEGORY_MASK);
        this.h.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.e.setFillType(Path.FillType.EVEN_ODD);
        c();
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
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
            this.a = 4;
            this.b = 32;
            this.c = 0;
            this.d = 0;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 4;
            this.b = 32;
            this.c = 0;
            this.d = 0;
        }
    }
}
