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
/* loaded from: classes4.dex */
public class LiveFeedPageRoundRect extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;

    /* renamed from: b  reason: collision with root package name */
    public Path f25848b;

    /* renamed from: c  reason: collision with root package name */
    public RectF f25849c;

    /* renamed from: d  reason: collision with root package name */
    public float[] f25850d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25851e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f25852f;

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
            canvas.saveLayer(this.f25849c, null, 31);
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
            canvas.saveLayer(this.f25849c, null, 31);
            super.draw(canvas);
            canvas.drawPath(e(), this.a);
            canvas.restore();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            if (this.f25852f) {
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
            if (this.f25851e) {
                if (this.f25852f) {
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
            this.f25848b.reset();
            this.f25848b.addRoundRect(this.f25849c, this.f25850d, Path.Direction.CW);
            return this.f25848b;
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
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0403ba, R.attr.obfuscated_res_0x7f0403bb, R.attr.obfuscated_res_0x7f0403bc, R.attr.obfuscated_res_0x7f0403bd, R.attr.obfuscated_res_0x7f0403be, R.attr.obfuscated_res_0x7f0403bf});
        this.f25851e = obtainStyledAttributes.getBoolean(0, true);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(4, dimensionPixelOffset);
        int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(5, dimensionPixelOffset);
        int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(2, dimensionPixelOffset);
        int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(3, dimensionPixelOffset);
        obtainStyledAttributes.recycle();
        float[] fArr = this.f25850d;
        float f2 = dimensionPixelOffset2;
        fArr[0] = f2;
        fArr[1] = f2;
        float f3 = dimensionPixelOffset3;
        fArr[2] = f3;
        fArr[3] = f3;
        float f4 = dimensionPixelOffset5;
        fArr[4] = f4;
        fArr[5] = f4;
        float f5 = dimensionPixelOffset4;
        fArr[6] = f5;
        fArr[7] = f5;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Paint paint = new Paint(1);
            this.a = paint;
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.f25848b = new Path();
            this.f25849c = new RectF();
            this.f25850d = new float[8];
            this.f25852f = Build.VERSION.SDK_INT >= 28;
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048586, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.f25849c.set(0.0f, 0.0f, i, i2);
        }
    }

    public void setCornerRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f2) == null) {
            if (this.f25850d == null) {
                this.f25850d = new float[8];
            }
            Arrays.fill(this.f25850d, f2);
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

    public void setCornerRadius(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            if (this.f25850d == null) {
                this.f25850d = new float[8];
            }
            float[] fArr = this.f25850d;
            fArr[0] = f2;
            fArr[1] = f2;
            fArr[2] = f3;
            fArr[3] = f3;
            fArr[4] = f4;
            fArr[5] = f4;
            fArr[6] = f5;
            fArr[7] = f5;
            postInvalidate();
        }
    }
}
