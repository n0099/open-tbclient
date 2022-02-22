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
/* loaded from: classes10.dex */
public class PlayDrawable extends Drawable {
    public static /* synthetic */ Interceptable $ic;
    public static final float[] k;
    public transient /* synthetic */ FieldHolder $fh;
    public final ValueAnimator a;

    /* renamed from: b  reason: collision with root package name */
    public float f37445b;

    /* renamed from: c  reason: collision with root package name */
    public float[] f37446c;

    /* renamed from: d  reason: collision with root package name */
    public float[] f37447d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f37448e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f37449f;

    /* renamed from: g  reason: collision with root package name */
    public final Path f37450g;

    /* renamed from: h  reason: collision with root package name */
    public final Path f37451h;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f37452i;

    /* renamed from: j  reason: collision with root package name */
    public IconState f37453j;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
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

        public IconState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (IconState) Enum.valueOf(IconState.class, str) : (IconState) invokeL.objValue;
        }

        public static IconState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (IconState[]) $VALUES.clone() : (IconState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PlayDrawable f37454e;

        public a(PlayDrawable playDrawable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playDrawable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37454e = playDrawable;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f37454e.s(valueAnimator.getAnimatedFraction());
            }
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

    public PlayDrawable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f37450g = new Path();
        this.f37451h = new Path();
        Paint paint = new Paint(1);
        this.f37452i = paint;
        this.f37453j = IconState.PLAY_STATE;
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

    public final float c(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? f2 + ((f3 - f2) * f4) : invokeCommon.floatValue;
    }

    public final void d(Canvas canvas, float[] fArr, float[] fArr2, float f2, Path path, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{canvas, fArr, fArr2, Float.valueOf(f2), path, paint}) == null) {
            f(k, fArr, fArr2, f2);
            g(path, k);
            canvas.drawPath(path, paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            d(canvas, this.f37446c, this.f37448e, this.f37445b, this.f37450g, this.f37452i);
            d(canvas, this.f37447d, this.f37449f, this.f37445b, this.f37451h, this.f37452i);
        }
    }

    public final Rect e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float m = m();
            float j2 = j();
            float l = l();
            float k2 = k();
            Rect rect = new Rect();
            int i2 = (int) ((m - l) / 2.0f);
            rect.left = i2;
            int i3 = (int) ((j2 - k2) / 2.0f);
            rect.top = i3;
            rect.right = (int) (i2 + l);
            rect.bottom = (int) (i3 + k2);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public final void f(float[] fArr, float[] fArr2, float[] fArr3, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{fArr, fArr2, fArr3, Float.valueOf(f2)}) == null) || fArr == null || fArr2 == null || fArr3 == null || fArr.length != fArr2.length) {
            return;
        }
        int length = fArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            fArr[i2] = c(fArr2[i2], fArr3[i2], f2);
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

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return -2;
        }
        return invokeV.intValue;
    }

    public final float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? getBounds().exactCenterX() : invokeV.floatValue;
    }

    public final float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getBounds().exactCenterY() : invokeV.floatValue;
    }

    public final float j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? getBounds().height() : invokeV.floatValue;
    }

    public final float k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? j() * 0.38f : invokeV.floatValue;
    }

    public final float l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? m() * 0.33f : invokeV.floatValue;
    }

    public final float m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? getBounds().width() : invokeV.floatValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Rect e2 = e();
            int m = (int) (m() * 0.074f);
            this.f37446c = new float[]{e2.left + m, e2.top, ((int) h()) + m, (e2.height() * 0.25f) + e2.top, ((int) h()) + m, (e2.height() * 0.75f) + e2.top, e2.left + m, e2.height() + e2.top};
            int i2 = e2.top;
            this.f37447d = new float[]{((int) h()) + m, (e2.height() * 0.25f) + e2.top, e2.left + e2.width() + m, i(), e2.left + e2.width() + m, i(), ((int) h()) + m, (e2.height() * 0.75f) + i2};
            int i3 = e2.left;
            this.f37448e = new float[]{i3, i2, i3 + (e2.width() * 0.285f), e2.top, e2.left + (e2.width() * 0.285f), e2.top + e2.height(), e2.left, e2.top + e2.height()};
            this.f37449f = new float[]{e2.left + (e2.width() * 0.715f), e2.top, e2.left + e2.width(), e2.top, e2.left + e2.width(), e2.top + e2.height(), e2.left + (e2.width() * 0.715f), e2.top + e2.height()};
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.a.isRunning() : invokeV.booleanValue;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, iconState) == null) {
            if (o()) {
                this.a.cancel();
            }
            this.f37445b = iconState == IconState.PLAY_STATE ? 0.0f : 1.0f;
            t(iconState);
            invalidateSelf();
        }
    }

    public void q(IconState iconState) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, iconState) == null) || o()) {
            return;
        }
        this.f37445b = iconState == IconState.PLAY_STATE ? 0.0f : 1.0f;
        t(iconState);
        invalidateSelf();
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            IconState iconState = this.f37453j;
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

    public final void s(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048596, this, f2) == null) {
            this.f37445b = f2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.f37452i.setAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, colorFilter) == null) {
            this.f37452i.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    public final void t(IconState iconState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iconState) == null) {
            this.f37453j = iconState;
        }
    }
}
