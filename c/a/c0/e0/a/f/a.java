package c.a.c0.e0.a.f;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
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
/* loaded from: classes.dex */
public class a extends Drawable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final int[] f1915j;
    public transient /* synthetic */ FieldHolder $fh;
    public final Paint a;

    /* renamed from: b  reason: collision with root package name */
    public final Bitmap f1916b;

    /* renamed from: c  reason: collision with root package name */
    public final Bitmap f1917c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f1918d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f1919e;

    /* renamed from: f  reason: collision with root package name */
    public final Rect f1920f;

    /* renamed from: g  reason: collision with root package name */
    public int f1921g;

    /* renamed from: h  reason: collision with root package name */
    public final ValueAnimator f1922h;

    /* renamed from: i  reason: collision with root package name */
    public int f1923i;

    /* renamed from: c.a.c0.e0.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0050a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1924e;

        public C0050a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1924e = aVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f1924e.k(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(571449433, "Lc/a/c0/e0/a/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(571449433, "Lc/a/c0/e0/a/f/a;");
                return;
            }
        }
        f1915j = new int[]{0, 18, 9};
    }

    public a(Bitmap bitmap, Bitmap bitmap2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, bitmap2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1921g = 2000;
        this.f1923i = 0;
        this.a = new Paint(1);
        this.f1916b = bitmap;
        this.f1917c = bitmap2;
        this.f1918d = new Rect();
        this.f1919e = new Rect();
        this.f1920f = new Rect();
        ValueAnimator ofInt = ValueAnimator.ofInt(f1915j);
        this.f1922h = ofInt;
        ofInt.setDuration(300L);
        this.f1922h.addUpdateListener(new C0050a(this));
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f1921g == 2000) {
                this.f1921g = 1000;
                this.f1922h.start();
                return;
            }
            this.f1921g = 2000;
            this.f1922h.reverse();
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            canvas.drawBitmap(this.f1917c, (Rect) null, this.f1920f, this.a);
        }
    }

    public final void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            canvas.drawBitmap(this.f1916b, this.f1918d, this.f1919e, this.a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            d(canvas);
            c(canvas);
        }
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getBounds().height() : invokeV.intValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1917c.getHeight() : invokeV.intValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1917c.getWidth() : invokeV.intValue;
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

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f1916b.getHeight() : invokeV.intValue;
    }

    public final int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f1916b.getWidth() : invokeV.intValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? getBounds().width() : invokeV.intValue;
    }

    public final void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            int i3 = i2 - this.f1923i;
            this.f1919e.top += i3;
            this.f1918d.bottom -= i3;
            this.f1923i = i2;
            invalidateSelf();
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f1921g = i2;
            if (i2 == 1000) {
                k(f1915j[2]);
            } else {
                k(f1915j[0]);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, rect) == null) {
            Rect rect2 = this.f1918d;
            rect2.top = 0;
            rect2.left = 0;
            rect2.right = i();
            this.f1918d.bottom = h();
            this.f1919e.top = (e() - ((h() + f()) + 10)) / 2;
            this.f1919e.left = (j() - i()) / 2;
            Rect rect3 = this.f1919e;
            rect3.right = rect3.left + i();
            Rect rect4 = this.f1919e;
            rect4.bottom = rect4.top + h();
            this.f1920f.top = ((e() - ((h() + f()) + 10)) / 2) + h();
            this.f1920f.left = (j() - g()) / 2;
            Rect rect5 = this.f1920f;
            rect5.right = rect5.left + g();
            Rect rect6 = this.f1920f;
            rect6.bottom = rect6.top + f();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.a.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, colorFilter) == null) {
            this.a.setColorFilter(colorFilter);
        }
    }
}
