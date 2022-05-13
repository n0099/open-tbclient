package com.baidu.live.framework.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class LiveFeedPageRoundRect extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;
    public Path b;
    public RectF c;
    public float[] d;
    public boolean e;
    public boolean f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveFeedPageRoundRect(@NonNull Context context) {
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

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            canvas.save();
            canvas.clipPath(e());
            super.dispatchDraw(canvas);
            canvas.restore();
        }
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            canvas.saveLayer(this.c, null, 31);
            super.dispatchDraw(canvas);
            canvas.drawPath(e(), this.a);
            canvas.restore();
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            canvas.save();
            canvas.clipPath(e());
            super.draw(canvas);
            canvas.restore();
        }
    }

    public final void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            canvas.saveLayer(this.c, null, 31);
            super.draw(canvas);
            canvas.drawPath(e(), this.a);
            canvas.restore();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            if (this.f) {
                a(canvas);
            } else {
                b(canvas);
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            if (this.e) {
                if (this.f) {
                    c(canvas);
                    return;
                } else {
                    d(canvas);
                    return;
                }
            }
            super.draw(canvas);
        }
    }

    public final Path e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.b.reset();
            this.b.addRoundRect(this.c, this.d, Path.Direction.CW);
            return this.b;
        }
        return (Path) invokeV.objValue;
    }

    public final void f(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, attributeSet) == null) {
            h();
            g(attributeSet);
        }
    }

    public final void g(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, attributeSet) == null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0403fc, R.attr.obfuscated_res_0x7f0403fd, R.attr.obfuscated_res_0x7f0403fe, R.attr.obfuscated_res_0x7f0403ff, R.attr.obfuscated_res_0x7f040400, R.attr.obfuscated_res_0x7f040401});
        this.e = obtainStyledAttributes.getBoolean(0, true);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(4, dimensionPixelOffset);
        int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(5, dimensionPixelOffset);
        int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(2, dimensionPixelOffset);
        int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(3, dimensionPixelOffset);
        obtainStyledAttributes.recycle();
        float[] fArr = this.d;
        float f = dimensionPixelOffset2;
        fArr[0] = f;
        fArr[1] = f;
        float f2 = dimensionPixelOffset3;
        fArr[2] = f2;
        fArr[3] = f2;
        float f3 = dimensionPixelOffset5;
        fArr[4] = f3;
        fArr[5] = f3;
        float f4 = dimensionPixelOffset4;
        fArr[6] = f4;
        fArr[7] = f4;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Paint paint = new Paint(1);
            this.a = paint;
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.b = new Path();
            this.c = new RectF();
            this.d = new float[8];
            this.f = Build.VERSION.SDK_INT >= 28;
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048586, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.c.set(0.0f, 0.0f, i, i2);
        }
    }

    public void setCornerRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f) == null) {
            if (this.d == null) {
                this.d = new float[8];
            }
            Arrays.fill(this.d, f);
            postInvalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveFeedPageRoundRect(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        f(attributeSet);
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            if (this.d == null) {
                this.d = new float[8];
            }
            float[] fArr = this.d;
            fArr[0] = f;
            fArr[1] = f;
            fArr[2] = f2;
            fArr[3] = f2;
            fArr[4] = f3;
            fArr[5] = f3;
            fArr[6] = f4;
            fArr[7] = f4;
            postInvalidate();
        }
    }
}
