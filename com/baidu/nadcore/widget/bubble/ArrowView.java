package com.baidu.nadcore.widget.bubble;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.z61;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ArrowView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;
    public Path b;
    public int c;
    public int d;
    public boolean e;

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

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.e) {
                this.b = c(this.b, this.c);
            } else {
                this.b = b(this.b, this.c);
            }
            canvas.drawPath(this.b, this.a);
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
        this.c = 4;
        this.d = Color.argb(204, 0, 0, 0);
        this.e = true;
        d();
    }

    public float a(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
            return getResources().getDisplayMetrics().density * f;
        }
        return invokeF.floatValue;
    }

    public void setArrowViewColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.d = i;
            this.a.setColor(i);
            invalidate();
        }
    }

    public void setDirection(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.c = i;
            invalidate();
        }
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
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            float f = paddingLeft;
                            float f2 = paddingTop;
                            path.moveTo(f, f2);
                            path.lineTo(measuredWidth - paddingRight, f2);
                            path.lineTo((((measuredWidth - paddingLeft) - paddingRight) / 2.0f) + f, measuredHeight - paddingBottom);
                            path.close();
                        }
                    } else {
                        float f3 = paddingLeft;
                        float f4 = paddingTop;
                        path.moveTo(f3, f4);
                        path.lineTo(measuredWidth - paddingRight, ((i2 - paddingTop) / 2.0f) + f4);
                        path.lineTo(f3, measuredHeight - paddingBottom);
                        path.close();
                    }
                } else {
                    float f5 = paddingLeft;
                    float f6 = measuredHeight - paddingBottom;
                    path.moveTo(f5, f6);
                    path.lineTo(measuredWidth - paddingRight, f6);
                    path.lineTo((((measuredWidth - paddingLeft) - paddingRight) / 2.0f) + f5, paddingTop);
                    path.close();
                }
            } else {
                float f7 = paddingTop;
                path.moveTo(paddingLeft, (((measuredHeight - paddingTop) - paddingBottom) / 2.0f) + f7);
                float f8 = measuredWidth - paddingRight;
                path.lineTo(f8, f7);
                path.lineTo(f8, measuredHeight - paddingBottom);
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
            float f = ((measuredWidth - paddingLeft) - paddingRight) / 2.0f;
            float f2 = ((measuredHeight - paddingTop) - paddingBottom) / 2.0f;
            float a = a(2.0f);
            path.reset();
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            float f3 = paddingLeft;
                            float f4 = paddingTop;
                            path.moveTo(f3, f4);
                            path.lineTo(measuredWidth - paddingRight, f4);
                            float f5 = f + f3;
                            float f6 = (measuredHeight - paddingBottom) - a;
                            path.lineTo(f5 + a, f6);
                            path.lineTo(f5 - a, f6);
                            path.close();
                            path.addCircle(f5, f6 - (a / 2.0f), a, Path.Direction.CW);
                        }
                    } else {
                        float f7 = paddingLeft;
                        float f8 = paddingTop;
                        path.moveTo(f7, f8);
                        float f9 = (measuredWidth - paddingRight) - a;
                        float f10 = f2 + f8;
                        path.lineTo(f9, f10 - a);
                        path.lineTo(f9, f10 + a);
                        path.lineTo(f7, measuredHeight - paddingBottom);
                        path.close();
                        path.addCircle(f9 - (a / 2.0f), f10, a, Path.Direction.CW);
                    }
                } else {
                    float f11 = paddingLeft;
                    float f12 = measuredHeight - paddingBottom;
                    path.moveTo(f11, f12);
                    path.lineTo(measuredWidth - paddingRight, f12);
                    float f13 = f + f11;
                    float f14 = paddingTop + a;
                    path.lineTo(f13 + a, f14);
                    path.lineTo(f13 - a, f14);
                    path.close();
                    path.addCircle(f13, f14 + (a / 2.0f), a, Path.Direction.CCW);
                }
            } else {
                float f15 = paddingLeft + a;
                float f16 = paddingTop;
                float f17 = f2 + f16;
                path.moveTo(f15, f17 - a);
                float f18 = measuredWidth - paddingRight;
                path.lineTo(f18, f16);
                path.lineTo(f18, measuredHeight - paddingBottom);
                path.lineTo(f15, f17 + a);
                path.close();
                path.addCircle(f15 + (a / 2.0f), f17, a, Path.Direction.CW);
            }
            return path;
        }
        return (Path) invokeLI.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d = z61.a().getResources().getColor(R.color.obfuscated_res_0x7f060331);
            this.b = new Path();
            Paint paint = new Paint();
            this.a = paint;
            paint.setAntiAlias(true);
            this.a.setStyle(Paint.Style.FILL_AND_STROKE);
            this.a.setColor(this.d);
        }
    }
}
