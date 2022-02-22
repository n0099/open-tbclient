package c.a.d0.i0.a.f;

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
    public static final int[] f2773j;
    public transient /* synthetic */ FieldHolder $fh;
    public final Paint a;

    /* renamed from: b  reason: collision with root package name */
    public final Bitmap f2774b;

    /* renamed from: c  reason: collision with root package name */
    public final Bitmap f2775c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f2776d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f2777e;

    /* renamed from: f  reason: collision with root package name */
    public final Rect f2778f;

    /* renamed from: g  reason: collision with root package name */
    public int f2779g;

    /* renamed from: h  reason: collision with root package name */
    public final ValueAnimator f2780h;

    /* renamed from: i  reason: collision with root package name */
    public int f2781i;

    /* renamed from: c.a.d0.i0.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0081a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f2782e;

        public C0081a(a aVar) {
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
            this.f2782e = aVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f2782e.k(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2060648892, "Lc/a/d0/i0/a/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2060648892, "Lc/a/d0/i0/a/f/a;");
                return;
            }
        }
        f2773j = new int[]{0, 18, 9};
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
        this.f2779g = 2000;
        this.f2781i = 0;
        this.a = new Paint(1);
        this.f2774b = bitmap;
        this.f2775c = bitmap2;
        this.f2776d = new Rect();
        this.f2777e = new Rect();
        this.f2778f = new Rect();
        ValueAnimator ofInt = ValueAnimator.ofInt(f2773j);
        this.f2780h = ofInt;
        ofInt.setDuration(300L);
        this.f2780h.addUpdateListener(new C0081a(this));
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f2779g == 2000) {
                this.f2779g = 1000;
                this.f2780h.start();
                return;
            }
            this.f2779g = 2000;
            this.f2780h.reverse();
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            canvas.drawBitmap(this.f2775c, (Rect) null, this.f2778f, this.a);
        }
    }

    public final void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            canvas.drawBitmap(this.f2774b, this.f2776d, this.f2777e, this.a);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2775c.getHeight() : invokeV.intValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f2775c.getWidth() : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f2774b.getHeight() : invokeV.intValue;
    }

    public final int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f2774b.getWidth() : invokeV.intValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? getBounds().width() : invokeV.intValue;
    }

    public final void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            int i3 = i2 - this.f2781i;
            this.f2777e.top += i3;
            this.f2776d.bottom -= i3;
            this.f2781i = i2;
            invalidateSelf();
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f2779g = i2;
            if (i2 == 1000) {
                k(f2773j[2]);
            } else {
                k(f2773j[0]);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, rect) == null) {
            Rect rect2 = this.f2776d;
            rect2.top = 0;
            rect2.left = 0;
            rect2.right = i();
            this.f2776d.bottom = h();
            this.f2777e.top = (e() - ((h() + f()) + 10)) / 2;
            this.f2777e.left = (j() - i()) / 2;
            Rect rect3 = this.f2777e;
            rect3.right = rect3.left + i();
            Rect rect4 = this.f2777e;
            rect4.bottom = rect4.top + h();
            this.f2778f.top = ((e() - ((h() + f()) + 10)) / 2) + h();
            this.f2778f.left = (j() - g()) / 2;
            Rect rect5 = this.f2778f;
            rect5.right = rect5.left + g();
            Rect rect6 = this.f2778f;
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
