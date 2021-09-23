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
/* loaded from: classes4.dex */
public class MaskView extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final RectF f36315e;

    /* renamed from: f  reason: collision with root package name */
    public final RectF f36316f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f36317g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f36318h;

    /* renamed from: i  reason: collision with root package name */
    public final Path f36319i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f36320j;
    public boolean k;
    public final Paint l;
    public final Paint m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaskView(Context context) {
        this(context, null, 0);
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

    public final void b(View view, RectF rectF, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, rectF, i2) == null) {
            if (i2 == 16) {
                float f2 = this.f36315e.left;
                rectF.left = f2;
                rectF.right = f2 + view.getMeasuredWidth();
            } else if (i2 == 32) {
                rectF.left = (this.f36315e.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.f36315e.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.f36315e.left, 0.0f);
            } else if (i2 != 48) {
            } else {
                float f3 = this.f36315e.right;
                rectF.right = f3;
                rectF.left = f3 - view.getMeasuredWidth();
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f36319i.reset();
            this.f36319i.addRect(this.f36315e, Path.Direction.CW);
            this.f36319i.addRect(this.f36316f, Path.Direction.CW);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f36318h.setAlpha(i2);
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            long drawingTime = getDrawingTime();
            canvas.save();
            canvas.drawRect(this.f36316f, this.f36318h);
            canvas.restore();
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                try {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                } catch (NullPointerException unused) {
                    return;
                }
            }
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f36318h.setColor(i2);
            invalidate();
        }
    }

    public void f(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rect) == null) {
            this.f36316f.set(rect);
            c();
            this.f36320j = true;
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
            this.f36315e.set(rect);
            c();
            invalidate();
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.k = z;
        }
    }

    public final void j(View view, RectF rectF, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048587, this, view, rectF, i2) == null) {
            if (i2 == 16) {
                float f2 = this.f36315e.top;
                rectF.top = f2;
                rectF.bottom = f2 + view.getMeasuredHeight();
            } else if (i2 == 32) {
                rectF.top = (this.f36315e.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.f36315e.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.f36315e.top);
            } else if (i2 != 48) {
            } else {
                RectF rectF2 = this.f36315e;
                rectF.bottom = rectF2.bottom;
                rectF.top = rectF2.bottom - view.getMeasuredHeight();
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
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int childCount = getChildCount();
            float f2 = getResources().getDisplayMetrics().density;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt != null && (layoutParams = (LayoutParams) childAt.getLayoutParams()) != null) {
                    int i7 = layoutParams.f36321a;
                    if (i7 == 1) {
                        RectF rectF = this.f36317g;
                        float f3 = this.f36315e.left;
                        rectF.right = f3;
                        rectF.left = f3 - childAt.getMeasuredWidth();
                        j(childAt, this.f36317g, layoutParams.f36322b);
                    } else if (i7 == 2) {
                        RectF rectF2 = this.f36317g;
                        float f4 = this.f36315e.top;
                        rectF2.bottom = f4;
                        rectF2.top = f4 - childAt.getMeasuredHeight();
                        b(childAt, this.f36317g, layoutParams.f36322b);
                    } else if (i7 == 3) {
                        RectF rectF3 = this.f36317g;
                        float f5 = this.f36315e.right;
                        rectF3.left = f5;
                        rectF3.right = f5 + childAt.getMeasuredWidth();
                        j(childAt, this.f36317g, layoutParams.f36322b);
                    } else if (i7 == 4) {
                        RectF rectF4 = this.f36317g;
                        float f6 = this.f36315e.bottom;
                        rectF4.top = f6;
                        rectF4.bottom = f6 + childAt.getMeasuredHeight();
                        b(childAt, this.f36317g, layoutParams.f36322b);
                    } else if (i7 == 5) {
                        this.f36317g.left = (((int) this.f36315e.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.f36317g.top = (((int) this.f36315e.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.f36317g.right = (((int) this.f36315e.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.f36317g.bottom = (((int) this.f36315e.height()) + childAt.getMeasuredHeight()) >> 1;
                        RectF rectF5 = this.f36317g;
                        RectF rectF6 = this.f36315e;
                        rectF5.offset(rectF6.left, rectF6.top);
                    }
                    if (this.k) {
                        this.f36317g.offset(layoutParams.f36323c, layoutParams.f36324d);
                    } else {
                        this.f36317g.offset((int) ((layoutParams.f36323c * f2) + 0.5f), (int) ((layoutParams.f36324d * f2) + 0.5f));
                    }
                    RectF rectF7 = this.f36317g;
                    childAt.layout((int) rectF7.left, (int) rectF7.top, (int) rectF7.right, (int) rectF7.bottom);
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            int i5 = i3 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            setMeasuredDimension(i4, i5);
            if (!this.f36320j) {
                this.f36316f.set(0.0f, 0.0f, i4, i5);
                c();
            }
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt != null) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams == null) {
                        childAt.setLayoutParams(layoutParams);
                    }
                    measureChild(childAt, i4 - 2147483648, Integer.MIN_VALUE + i5);
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
    public MaskView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f36315e = new RectF();
        this.f36316f = new RectF();
        this.f36317g = new RectF();
        this.f36318h = new Paint();
        this.f36319i = new Path();
        this.k = false;
        this.l = new Paint();
        Paint paint = new Paint();
        this.m = paint;
        paint.setAntiAlias(true);
        this.l.setColor(SupportMenu.CATEGORY_MASK);
        this.l.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f36319i.setFillType(Path.FillType.EVEN_ODD);
        c();
    }

    /* loaded from: classes4.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f36321a;

        /* renamed from: b  reason: collision with root package name */
        public int f36322b;

        /* renamed from: c  reason: collision with root package name */
        public int f36323c;

        /* renamed from: d  reason: collision with root package name */
        public int f36324d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
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
            this.f36321a = 4;
            this.f36322b = 32;
            this.f36323c = 0;
            this.f36324d = 0;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36321a = 4;
            this.f36322b = 32;
            this.f36323c = 0;
            this.f36324d = 0;
        }
    }
}
