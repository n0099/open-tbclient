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
import c.a.y.c.a.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes10.dex */
public class LiveFeedPageRoundRect extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f35130e;

    /* renamed from: f  reason: collision with root package name */
    public Path f35131f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f35132g;

    /* renamed from: h  reason: collision with root package name */
    public float[] f35133h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f35134i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f35135j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveFeedPageRoundRect(@NonNull Context context) {
        this(context, null);
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
            canvas.saveLayer(this.f35132g, null, 31);
            super.dispatchDraw(canvas);
            canvas.drawPath(e(), this.f35130e);
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
            canvas.saveLayer(this.f35132g, null, 31);
            super.draw(canvas);
            canvas.drawPath(e(), this.f35130e);
            canvas.restore();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            if (this.f35135j) {
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
            if (this.f35134i) {
                if (this.f35135j) {
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
            this.f35131f.reset();
            this.f35131f.addRoundRect(this.f35132g, this.f35133h, Path.Direction.CW);
            return this.f35131f;
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
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.LiveFeedPageRoundRect);
        this.f35134i = obtainStyledAttributes.getBoolean(f.LiveFeedPageRoundRect_live_feed_page_clip_background, true);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(f.LiveFeedPageRoundRect_live_feed_page_corner_radius, 0);
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(f.LiveFeedPageRoundRect_live_feed_page_corner_radius_top_left, dimensionPixelOffset);
        int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(f.LiveFeedPageRoundRect_live_feed_page_corner_radius_top_right, dimensionPixelOffset);
        int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(f.LiveFeedPageRoundRect_live_feed_page_corner_radius_bottom_left, dimensionPixelOffset);
        int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(f.LiveFeedPageRoundRect_live_feed_page_corner_radius_bottom_right, dimensionPixelOffset);
        obtainStyledAttributes.recycle();
        float[] fArr = this.f35133h;
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
            this.f35130e = paint;
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.f35131f = new Path();
            this.f35132g = new RectF();
            this.f35133h = new float[8];
            this.f35135j = Build.VERSION.SDK_INT >= 28;
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048586, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.f35132g.set(0.0f, 0.0f, i2, i3);
        }
    }

    public void setCornerRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f2) == null) {
            if (this.f35133h == null) {
                this.f35133h = new float[8];
            }
            Arrays.fill(this.f35133h, f2);
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
        f(attributeSet);
    }

    public void setCornerRadius(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            if (this.f35133h == null) {
                this.f35133h = new float[8];
            }
            float[] fArr = this.f35133h;
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
