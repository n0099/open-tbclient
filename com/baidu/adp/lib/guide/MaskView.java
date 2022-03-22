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
/* loaded from: classes3.dex */
public class MaskView extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RectF a;

    /* renamed from: b  reason: collision with root package name */
    public final RectF f23826b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f23827c;

    /* renamed from: d  reason: collision with root package name */
    public final Paint f23828d;

    /* renamed from: e  reason: collision with root package name */
    public final Path f23829e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23830f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23831g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f23832h;
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

    public final void b(View view, RectF rectF, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, rectF, i) == null) {
            if (i == 16) {
                float f2 = this.a.left;
                rectF.left = f2;
                rectF.right = f2 + view.getMeasuredWidth();
            } else if (i == 32) {
                rectF.left = (this.a.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.a.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.a.left, 0.0f);
            } else if (i != 48) {
            } else {
                float f3 = this.a.right;
                rectF.right = f3;
                rectF.left = f3 - view.getMeasuredWidth();
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f23829e.reset();
            this.f23829e.addRect(this.a, Path.Direction.CW);
            this.f23829e.addRect(this.f23826b, Path.Direction.CW);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f23828d.setAlpha(i);
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            long drawingTime = getDrawingTime();
            canvas.save();
            canvas.drawRect(this.f23826b, this.f23828d);
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
            this.f23828d.setColor(i);
            invalidate();
        }
    }

    public void f(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rect) == null) {
            this.f23826b.set(rect);
            c();
            this.f23830f = true;
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
            this.f23831g = z;
        }
    }

    public final void j(View view, RectF rectF, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048587, this, view, rectF, i) == null) {
            if (i == 16) {
                float f2 = this.a.top;
                rectF.top = f2;
                rectF.bottom = f2 + view.getMeasuredHeight();
            } else if (i == 32) {
                rectF.top = (this.a.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.a.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.a.top);
            } else if (i != 48) {
            } else {
                RectF rectF2 = this.a;
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
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int childCount = getChildCount();
            float f2 = getResources().getDisplayMetrics().density;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != null && (layoutParams = (LayoutParams) childAt.getLayoutParams()) != null) {
                    int i6 = layoutParams.a;
                    if (i6 == 1) {
                        RectF rectF = this.f23827c;
                        float f3 = this.a.left;
                        rectF.right = f3;
                        rectF.left = f3 - childAt.getMeasuredWidth();
                        j(childAt, this.f23827c, layoutParams.f23833b);
                    } else if (i6 == 2) {
                        RectF rectF2 = this.f23827c;
                        float f4 = this.a.top;
                        rectF2.bottom = f4;
                        rectF2.top = f4 - childAt.getMeasuredHeight();
                        b(childAt, this.f23827c, layoutParams.f23833b);
                    } else if (i6 == 3) {
                        RectF rectF3 = this.f23827c;
                        float f5 = this.a.right;
                        rectF3.left = f5;
                        rectF3.right = f5 + childAt.getMeasuredWidth();
                        j(childAt, this.f23827c, layoutParams.f23833b);
                    } else if (i6 == 4) {
                        RectF rectF4 = this.f23827c;
                        float f6 = this.a.bottom;
                        rectF4.top = f6;
                        rectF4.bottom = f6 + childAt.getMeasuredHeight();
                        b(childAt, this.f23827c, layoutParams.f23833b);
                    } else if (i6 == 5) {
                        this.f23827c.left = (((int) this.a.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.f23827c.top = (((int) this.a.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.f23827c.right = (((int) this.a.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.f23827c.bottom = (((int) this.a.height()) + childAt.getMeasuredHeight()) >> 1;
                        RectF rectF5 = this.f23827c;
                        RectF rectF6 = this.a;
                        rectF5.offset(rectF6.left, rectF6.top);
                    }
                    if (this.f23831g) {
                        this.f23827c.offset(layoutParams.f23834c, layoutParams.f23835d);
                    } else {
                        this.f23827c.offset((int) ((layoutParams.f23834c * f2) + 0.5f), (int) ((layoutParams.f23835d * f2) + 0.5f));
                    }
                    RectF rectF7 = this.f23827c;
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
            if (!this.f23830f) {
                this.f23826b.set(0.0f, 0.0f, i3, i4);
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
        this.f23826b = new RectF();
        this.f23827c = new RectF();
        this.f23828d = new Paint();
        this.f23829e = new Path();
        this.f23831g = false;
        this.f23832h = new Paint();
        Paint paint = new Paint();
        this.i = paint;
        paint.setAntiAlias(true);
        this.f23832h.setColor(SupportMenu.CATEGORY_MASK);
        this.f23832h.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f23829e.setFillType(Path.FillType.EVEN_ODD);
        c();
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f23833b;

        /* renamed from: c  reason: collision with root package name */
        public int f23834c;

        /* renamed from: d  reason: collision with root package name */
        public int f23835d;

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
            this.f23833b = 32;
            this.f23834c = 0;
            this.f23835d = 0;
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
            this.f23833b = 32;
            this.f23834c = 0;
            this.f23835d = 0;
        }
    }
}
