package com.baidu.nadcore.widget.bubble;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import c.a.a0.l0.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ArrowView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;

    /* renamed from: b  reason: collision with root package name */
    public Path f27768b;

    /* renamed from: c  reason: collision with root package name */
    public int f27769c;

    /* renamed from: d  reason: collision with root package name */
    public int f27770d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f27771e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ArrowView(Context context) {
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

    public float a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? getResources().getDisplayMetrics().density * f2 : invokeF.floatValue;
    }

    public final Path b(Path path, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, path, i)) == null) {
            if (path == null) {
                return new Path();
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            path.reset();
            if (i == 1) {
                float f2 = paddingTop;
                path.moveTo(paddingLeft, (((measuredHeight - paddingTop) - paddingBottom) / 2.0f) + f2);
                float f3 = measuredWidth - paddingRight;
                path.lineTo(f3, f2);
                path.lineTo(f3, measuredHeight - paddingBottom);
                path.close();
            } else if (i == 2) {
                float f4 = paddingLeft;
                float f5 = measuredHeight - paddingBottom;
                path.moveTo(f4, f5);
                path.lineTo(measuredWidth - paddingRight, f5);
                path.lineTo((((measuredWidth - paddingLeft) - paddingRight) / 2.0f) + f4, paddingTop);
                path.close();
            } else if (i == 3) {
                float f6 = paddingLeft;
                float f7 = paddingTop;
                path.moveTo(f6, f7);
                path.lineTo(measuredWidth - paddingRight, ((i2 - paddingTop) / 2.0f) + f7);
                path.lineTo(f6, measuredHeight - paddingBottom);
                path.close();
            } else if (i == 4) {
                float f8 = paddingLeft;
                float f9 = paddingTop;
                path.moveTo(f8, f9);
                path.lineTo(measuredWidth - paddingRight, f9);
                path.lineTo((((measuredWidth - paddingLeft) - paddingRight) / 2.0f) + f8, measuredHeight - paddingBottom);
                path.close();
            }
            return path;
        }
        return (Path) invokeLI.objValue;
    }

    public final Path c(Path path, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, path, i)) == null) {
            if (path == null) {
                return new Path();
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f2 = ((measuredWidth - paddingLeft) - paddingRight) / 2.0f;
            float f3 = ((measuredHeight - paddingTop) - paddingBottom) / 2.0f;
            float a = a(2.0f);
            path.reset();
            if (i == 1) {
                float f4 = paddingLeft + a;
                float f5 = paddingTop;
                float f6 = f3 + f5;
                path.moveTo(f4, f6 - a);
                float f7 = measuredWidth - paddingRight;
                path.lineTo(f7, f5);
                path.lineTo(f7, measuredHeight - paddingBottom);
                path.lineTo(f4, f6 + a);
                path.close();
                path.addCircle(f4 + (a / 2.0f), f6, a, Path.Direction.CW);
            } else if (i == 2) {
                float f8 = paddingLeft;
                float f9 = measuredHeight - paddingBottom;
                path.moveTo(f8, f9);
                path.lineTo(measuredWidth - paddingRight, f9);
                float f10 = f2 + f8;
                float f11 = paddingTop + a;
                path.lineTo(f10 + a, f11);
                path.lineTo(f10 - a, f11);
                path.close();
                path.addCircle(f10, f11 + (a / 2.0f), a, Path.Direction.CCW);
            } else if (i == 3) {
                float f12 = paddingLeft;
                float f13 = paddingTop;
                path.moveTo(f12, f13);
                float f14 = (measuredWidth - paddingRight) - a;
                float f15 = f3 + f13;
                path.lineTo(f14, f15 - a);
                path.lineTo(f14, f15 + a);
                path.lineTo(f12, measuredHeight - paddingBottom);
                path.close();
                path.addCircle(f14 - (a / 2.0f), f15, a, Path.Direction.CW);
            } else if (i == 4) {
                float f16 = paddingLeft;
                float f17 = paddingTop;
                path.moveTo(f16, f17);
                path.lineTo(measuredWidth - paddingRight, f17);
                float f18 = f2 + f16;
                float f19 = (measuredHeight - paddingBottom) - a;
                path.lineTo(f18 + a, f19);
                path.lineTo(f18 - a, f19);
                path.close();
                path.addCircle(f18, f19 - (a / 2.0f), a, Path.Direction.CW);
            }
            return path;
        }
        return (Path) invokeLI.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f27770d = b.a().getResources().getColor(R.color.obfuscated_res_0x7f060318);
            this.f27768b = new Path();
            Paint paint = new Paint();
            this.a = paint;
            paint.setAntiAlias(true);
            this.a.setStyle(Paint.Style.FILL_AND_STROKE);
            this.a.setColor(this.f27770d);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f27771e) {
                this.f27768b = c(this.f27768b, this.f27769c);
            } else {
                this.f27768b = b(this.f27768b, this.f27769c);
            }
            canvas.drawPath(this.f27768b, this.a);
        }
    }

    public void setArrowViewColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f27770d = i;
            this.a.setColor(i);
            invalidate();
        }
    }

    public void setDirection(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f27769c = i;
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ArrowView(Context context, @Nullable AttributeSet attributeSet) {
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
    public ArrowView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.f27769c = 4;
        this.f27770d = Color.argb(204, 0, 0, 0);
        this.f27771e = true;
        d();
    }
}
