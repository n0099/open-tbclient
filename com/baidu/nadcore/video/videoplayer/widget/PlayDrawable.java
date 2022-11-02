package com.baidu.nadcore.video.videoplayer.widget;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class PlayDrawable extends Drawable {
    public static /* synthetic */ Interceptable $ic;
    public static final float[] k;
    public transient /* synthetic */ FieldHolder $fh;
    public final ValueAnimator a;
    public float b;
    public float[] c;
    public float[] d;
    public float[] e;
    public float[] f;
    public final Path g;
    public final Path h;
    public final Paint i;
    public IconState j;

    public final float c(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) ? f + ((f2 - f) * f3) : invokeCommon.floatValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return -2;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class IconState {
        public static final /* synthetic */ IconState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final IconState PAUSE_STATE;
        public static final IconState PLAY_STATE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(445247806, "Lcom/baidu/nadcore/video/videoplayer/widget/PlayDrawable$IconState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(445247806, "Lcom/baidu/nadcore/video/videoplayer/widget/PlayDrawable$IconState;");
                    return;
                }
            }
            PLAY_STATE = new IconState("PLAY_STATE", 0);
            IconState iconState = new IconState("PAUSE_STATE", 1);
            PAUSE_STATE = iconState;
            $VALUES = new IconState[]{PLAY_STATE, iconState};
        }

        public IconState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static IconState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (IconState) Enum.valueOf(IconState.class, str);
            }
            return (IconState) invokeL.objValue;
        }

        public static IconState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (IconState[]) $VALUES.clone();
            }
            return (IconState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PlayDrawable a;

        public a(PlayDrawable playDrawable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playDrawable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = playDrawable;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, valueAnimator) != null) {
                return;
            }
            this.a.s(valueAnimator.getAnimatedFraction());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-721179822, "Lcom/baidu/nadcore/video/videoplayer/widget/PlayDrawable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-721179822, "Lcom/baidu/nadcore/video/videoplayer/widget/PlayDrawable;");
                return;
            }
        }
        k = new float[8];
    }

    public final float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return getBounds().exactCenterX();
        }
        return invokeV.floatValue;
    }

    public final float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return getBounds().exactCenterY();
        }
        return invokeV.floatValue;
    }

    public final float j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return getBounds().height();
        }
        return invokeV.floatValue;
    }

    public final float k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return j() * 0.38f;
        }
        return invokeV.floatValue;
    }

    public final float l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return m() * 0.33f;
        }
        return invokeV.floatValue;
    }

    public final float m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return getBounds().width();
        }
        return invokeV.floatValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.a.isRunning();
        }
        return invokeV.booleanValue;
    }

    public PlayDrawable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.g = new Path();
        this.h = new Path();
        Paint paint = new Paint(1);
        this.i = paint;
        this.j = IconState.PLAY_STATE;
        paint.setColor(-1);
        this.a.setDuration(150L);
        this.a.addUpdateListener(new a(this));
    }

    public final void b(IconState iconState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iconState) == null) {
            if (o()) {
                this.a.cancel();
            }
            if (iconState == IconState.PAUSE_STATE) {
                this.a.start();
            } else {
                this.a.reverse();
            }
            t(iconState);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            d(canvas, this.c, this.e, this.b, this.g, this.i);
            d(canvas, this.d, this.f, this.b, this.h, this.i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, rect) == null) {
            super.onBoundsChange(rect);
            n();
        }
    }

    public void p(IconState iconState) {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, iconState) == null) {
            if (o()) {
                this.a.cancel();
            }
            if (iconState == IconState.PLAY_STATE) {
                f = 0.0f;
            } else {
                f = 1.0f;
            }
            this.b = f;
            t(iconState);
            invalidateSelf();
        }
    }

    public void q(IconState iconState) {
        float f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, iconState) == null) && !o()) {
            if (iconState == IconState.PLAY_STATE) {
                f = 0.0f;
            } else {
                f = 1.0f;
            }
            this.b = f;
            t(iconState);
            invalidateSelf();
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            IconState iconState = this.j;
            IconState iconState2 = IconState.PLAY_STATE;
            if (iconState == iconState2) {
                iconState2 = IconState.PAUSE_STATE;
            }
            if (z) {
                b(iconState2);
            } else {
                p(iconState2);
            }
        }
    }

    public final void s(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048596, this, f) == null) {
            this.b = f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.i.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, colorFilter) == null) {
            this.i.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    public final void t(IconState iconState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iconState) == null) {
            this.j = iconState;
        }
    }

    public final void d(Canvas canvas, float[] fArr, float[] fArr2, float f, Path path, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{canvas, fArr, fArr2, Float.valueOf(f), path, paint}) == null) {
            f(k, fArr, fArr2, f);
            g(path, k);
            canvas.drawPath(path, paint);
        }
    }

    public final Rect e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float m = m();
            float j = j();
            float l = l();
            float k2 = k();
            Rect rect = new Rect();
            int i = (int) ((m - l) / 2.0f);
            rect.left = i;
            int i2 = (int) ((j - k2) / 2.0f);
            rect.top = i2;
            rect.right = (int) (i + l);
            rect.bottom = (int) (i2 + k2);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public final void f(float[] fArr, float[] fArr2, float[] fArr3, float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{fArr, fArr2, fArr3, Float.valueOf(f)}) == null) && fArr != null && fArr2 != null && fArr3 != null && fArr.length == fArr2.length) {
            int length = fArr2.length;
            for (int i = 0; i < length; i++) {
                fArr[i] = c(fArr2[i], fArr3[i], f);
            }
        }
    }

    public final void g(@NonNull Path path, @NonNull float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, path, fArr) == null) {
            if (!path.isEmpty()) {
                path.rewind();
            }
            path.moveTo(fArr[0], fArr[1]);
            path.lineTo(fArr[2], fArr[3]);
            path.lineTo(fArr[4], fArr[5]);
            path.lineTo(fArr[6], fArr[7]);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Rect e = e();
            int m = (int) (m() * 0.074f);
            this.c = new float[]{e.left + m, e.top, ((int) h()) + m, (e.height() * 0.25f) + e.top, ((int) h()) + m, (e.height() * 0.75f) + e.top, e.left + m, e.height() + e.top};
            int i = e.top;
            this.d = new float[]{((int) h()) + m, (e.height() * 0.25f) + e.top, e.left + e.width() + m, i(), e.left + e.width() + m, i(), ((int) h()) + m, (e.height() * 0.75f) + i};
            int i2 = e.left;
            this.e = new float[]{i2, i, i2 + (e.width() * 0.285f), e.top, e.left + (e.width() * 0.285f), e.top + e.height(), e.left, e.top + e.height()};
            this.f = new float[]{e.left + (e.width() * 0.715f), e.top, e.left + e.width(), e.top, e.left + e.width(), e.top + e.height(), e.left + (e.width() * 0.715f), e.top + e.height()};
        }
    }
}
