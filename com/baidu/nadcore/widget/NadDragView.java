package com.baidu.nadcore.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.j11;
import com.repackage.ki0;
import com.repackage.m11;
/* loaded from: classes2.dex */
public class NadDragView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int p;
    public transient /* synthetic */ FieldHolder $fh;
    public final Matrix a;
    public View b;
    public Bitmap c;
    public Rect d;
    public Rect e;
    public Rect f;
    public float g;
    public float h;
    public boolean i;
    public boolean j;
    public boolean k;
    public float l;
    public float m;
    public a n;
    public RectF o;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1148420399, "Lcom/baidu/nadcore/widget/NadDragView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1148420399, "Lcom/baidu/nadcore/widget/NadDragView;");
                return;
            }
        }
        p = m11.c.c(ki0.b()) / 5;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadDragView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Matrix();
        this.k = false;
        this.l = 0.0f;
        this.m = 1.0f;
        this.o = new RectF();
    }

    public final boolean a(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            View view2 = this.b;
            if (view2 != null && view2.getVisibility() == 0) {
                if (this.c != null && getScrollY() == 0) {
                    if ((f2 < -15.0f && !this.k) || (f2 > 15.0f && !this.k)) {
                        this.k = true;
                        this.l = 0.0f;
                        this.m = 1.0f;
                        a aVar = this.n;
                        if (aVar != null) {
                            aVar.a();
                        }
                    }
                }
                if (this.k && this.c != null) {
                    this.l -= f2;
                    float measuredHeight = getMeasuredHeight();
                    if (this.l > measuredHeight) {
                        this.l = measuredHeight;
                    }
                    float f3 = f2 / measuredHeight;
                    Matrix matrix = this.a;
                    float f4 = this.m;
                    matrix.postTranslate((-f) * 1.5f * f4, f2 * (-1.5f) * f4);
                    if (this.m * (f3 + 1.0f) > 1.0f || this.l < 0.0f) {
                        f3 = -f3;
                    }
                    float f5 = f3 + 1.0f;
                    this.a.preScale(f5, f5, (this.m * this.c.getWidth()) / 2.0f, this.m * (this.c.getHeight() / 2));
                    this.m *= f5;
                    invalidate();
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final RectF b(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            float f5 = f3 / 2.0f;
            float f6 = f4 / 2.0f;
            return new RectF(f - f5, f2 - f6, f + f5, f2 + f6);
        }
        return (RectF) invokeCommon.objValue;
    }

    public final void c() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.n) == null) {
            return;
        }
        aVar.b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            if (this.i && (bitmap2 = this.c) != null && !bitmap2.isRecycled() && this.k) {
                canvas.drawColor(Color.argb((int) (this.m * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.o == null) {
                    this.o = new RectF();
                }
                this.a.mapRect(this.o, new RectF(this.d));
                canvas.drawBitmap(this.c, this.f, this.o, (Paint) null);
            } else if (this.j && (bitmap = this.c) != null && !bitmap.isRecycled()) {
                canvas.drawColor(Color.argb((int) (this.m * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                canvas.drawBitmap(this.c, this.f, this.o, (Paint) null);
            } else {
                super.dispatchDraw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        a aVar;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (this.b == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (!this.i && motionEvent.getPointerCount() >= 2) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (this.i || this.j) {
                requestDisallowInterceptTouchEvent(true);
            }
            int action = motionEvent.getAction();
            float y = motionEvent.getY();
            float x = motionEvent.getX();
            int i = action & 255;
            if (i == 0) {
                if (this.c == null) {
                    this.c = j11.a(this.b);
                }
                if (this.d == null && this.c != null) {
                    int measuredWidth = getMeasuredWidth();
                    float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.c.getWidth()) * this.c.getHeight();
                    if (measuredWidth2 > getMeasuredHeight()) {
                        measuredWidth2 = getMeasuredHeight();
                    }
                    RectF b = b(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                    this.d = new Rect((int) b.left, (int) b.top, (int) b.right, (int) b.bottom);
                }
                if (this.e == null && (bitmap = this.c) != null) {
                    int height = bitmap.getHeight();
                    int width = bitmap.getWidth();
                    float b2 = m11.c.b(getContext());
                    int i2 = (int) (height * b2);
                    int i3 = (int) (width * b2);
                    if (i3 > this.c.getWidth() && this.c.getWidth() != 0) {
                        i2 = (int) (i2 / ((i3 * 1.0f) / this.c.getWidth()));
                        i3 = this.c.getWidth();
                    }
                    if (i2 > this.c.getHeight() && this.c.getHeight() != 0) {
                        i3 = (int) (i3 / ((i2 * 1.0f) / this.c.getHeight()));
                        i2 = this.c.getHeight();
                    }
                    int c = (m11.c.c(getContext()) - i2) / 2;
                    int e = (m11.c.e(getContext()) - i3) / 2;
                    this.e = new Rect(e, c, i3 + e, i2 + c);
                    this.f = new Rect(0, 0, this.c.getWidth(), this.c.getHeight());
                }
                this.g = x;
                this.h = y;
            }
            if (i == 2) {
                this.i = a(this.g - x, this.h - y);
                this.g = x;
                this.h = y;
            }
            boolean dispatchTouchEvent = (this.i || this.j) ? true : super.dispatchTouchEvent(motionEvent);
            if (i == 1 || i == 3) {
                this.g = 0.0f;
                this.h = 0.0f;
                boolean z = (-this.l) > ((float) (p * 2));
                boolean z2 = this.l > ((float) p);
                if (!z && !z2) {
                    if (this.i && (aVar = this.n) != null) {
                        aVar.c();
                    }
                    this.m = 1.0f;
                    invalidate();
                } else {
                    this.j = true;
                    c();
                }
                this.k = false;
                this.a.reset();
                this.i = false;
            }
            return dispatchTouchEvent;
        }
        return invokeL.booleanValue;
    }

    public void setDragToExitListener(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.n = aVar;
        }
    }

    public void setDragView(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            View view3 = this.b;
            if (view3 != null) {
                removeView(view3);
            }
            this.b = view2;
            addView(view2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadDragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new Matrix();
        this.k = false;
        this.l = 0.0f;
        this.m = 1.0f;
        this.o = new RectF();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = new Matrix();
        this.k = false;
        this.l = 0.0f;
        this.m = 1.0f;
        this.o = new RectF();
    }
}
