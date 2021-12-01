package com.baidu.nadcore.download.view;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import c.a.b0.c0.c;
import c.a.b0.d0.f;
import c.a.b0.g.f.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AdDownloadViewLP extends View implements i<AdDownloadViewLP> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f37540e;

    /* renamed from: f  reason: collision with root package name */
    public int f37541f;

    /* renamed from: g  reason: collision with root package name */
    public int f37542g;

    /* renamed from: h  reason: collision with root package name */
    public ValueAnimator f37543h;

    /* renamed from: i  reason: collision with root package name */
    public int f37544i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f37545j;

    /* renamed from: k  reason: collision with root package name */
    public int f37546k;
    public boolean l;
    public final Paint m;
    public int n;
    public float o;
    public String p;
    public int q;
    public State r;
    public float s;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class State {
        public static final /* synthetic */ State[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final State DOWNLOADING;
        public static final State FINISH;
        public static final State PREPARE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-630576214, "Lcom/baidu/nadcore/download/view/AdDownloadViewLP$State;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-630576214, "Lcom/baidu/nadcore/download/view/AdDownloadViewLP$State;");
                    return;
                }
            }
            PREPARE = new State("PREPARE", 0);
            DOWNLOADING = new State("DOWNLOADING", 1);
            State state = new State("FINISH", 2);
            FINISH = state;
            $VALUES = new State[]{PREPARE, DOWNLOADING, state};
        }

        public State(String str, int i2) {
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

        public static State valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (State) Enum.valueOf(State.class, str) : (State) invokeL.objValue;
        }

        public static State[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (State[]) $VALUES.clone() : (State[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdDownloadViewLP f37547e;

        public a(AdDownloadViewLP adDownloadViewLP) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adDownloadViewLP};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37547e = adDownloadViewLP;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f37547e.f37541f = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.f37547e.invalidate();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1362517465, "Lcom/baidu/nadcore/download/view/AdDownloadViewLP$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1362517465, "Lcom/baidu/nadcore/download/view/AdDownloadViewLP$b;");
                    return;
                }
            }
            int[] iArr = new int[State.values().length];
            a = iArr;
            try {
                iArr[State.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[State.FINISH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdDownloadViewLP(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37540e = new Paint();
        this.f37541f = -2210218;
        this.f37542g = -1;
        this.f37544i = 1073741824;
        this.m = new Paint();
        this.n = -1;
        this.q = 100;
        this.r = State.PREPARE;
        this.s = -1.0f;
        g();
    }

    public final void b(Canvas canvas, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, canvas, rectF) == null) {
            this.f37540e.setColor(this.f37541f);
            this.f37540e.setStyle(Paint.Style.FILL);
            float f2 = this.s;
            if (f2 <= 0.0f) {
                f2 = this.f37545j ? rectF.height() / 2.0f : 0.0f;
            }
            canvas.drawRoundRect(rectF, f2, f2, this.f37540e);
        }
    }

    @Override // c.a.b0.g.f.i
    public void bind(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) && (viewGroup instanceof RelativeLayout)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.width = (int) (f.c.e(getContext()) * f.c.h(c.nad_default_round_width_size));
            layoutParams.height = (int) (f.c.c(getContext()) * f.c.h(c.nad_default_round_height_size));
            layoutParams.addRule(13, -1);
            viewGroup.addView(this, layoutParams);
            viewGroup.setVisibility(0);
            viewGroup.bringToFront();
        }
    }

    public final void c(Canvas canvas, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, canvas, rectF) == null) {
            int i2 = b.a[this.r.ordinal()];
            float f2 = 0.0f;
            if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                this.f37540e.setColor(this.f37544i);
                this.f37540e.setStyle(Paint.Style.FILL);
                float f3 = this.s;
                if (f3 > 0.0f) {
                    f2 = f3;
                } else if (this.f37545j) {
                    f2 = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f2, f2, this.f37540e);
                return;
            }
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            float f4 = this.f37546k / this.q;
            paint.setShader(new LinearGradient(0.0f, 0.0f, rectF.width(), 0.0f, new int[]{this.f37544i, 0}, new float[]{f4, f4 + 1.0E-4f}, Shader.TileMode.CLAMP));
            float f5 = this.s;
            if (f5 > 0.0f) {
                f2 = f5;
            } else if (this.f37545j) {
                f2 = rectF.height() / 2.0f;
            }
            canvas.drawRoundRect(rectF, f2, f2, paint);
        }
    }

    public final void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            this.m.setTextSize(this.o);
            float height = (canvas.getHeight() / 2.0f) - ((this.m.descent() / 2.0f) + (this.m.ascent() / 2.0f));
            float measureText = this.m.measureText(this.p);
            this.m.setColor(this.n);
            canvas.drawText(this.p, (getMeasuredWidth() - measureText) / 2.0f, height, this.m);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.draw(canvas);
            if (getWidth() == 0 || getHeight() == 0 || TextUtils.isEmpty(this.p)) {
                return;
            }
            if (this.f37542g != -1) {
                h();
            }
            if (!this.l) {
                f(canvas);
            } else {
                e(canvas);
            }
        }
    }

    public final void e(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            b(canvas, rectF);
            c(canvas, rectF);
            d(canvas);
        }
    }

    public final void f(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            float f2 = 0;
            RectF rectF = new RectF(f2, f2, getWidth() + 0, getHeight() + 0);
            this.f37540e.setColor(this.f37541f);
            this.f37540e.setStyle(Paint.Style.FILL);
            float f3 = this.s;
            if (f3 <= 0.0f) {
                f3 = this.f37545j ? rectF.height() / 2.0f : 0.0f;
            }
            canvas.drawRoundRect(rectF, f3, f3, this.f37540e);
            this.m.setColor(this.n);
            this.m.setTextSize(this.o);
            Paint.FontMetrics fontMetrics = this.m.getFontMetrics();
            float f4 = fontMetrics.descent;
            canvas.drawText(this.p, (getMeasuredWidth() - this.m.measureText(this.p)) / 2.0f, ((getHeight() / 2.0f) - f4) + ((f4 - fontMetrics.ascent) / 2.0f), this.m);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setTextSize(getContext().getResources().getDimensionPixelSize(c.nad_dimens_16dp));
            setBgColor(getContext().getResources().getColor(c.a.b0.c0.b.nad_download_button_color));
            setTextColor(-1);
            isShowProgress(true);
            isCornerRadius(true);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.b0.g.f.i
    @NonNull
    public AdDownloadViewLP getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : (AdDownloadViewLP) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.f37543h == null) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.f37541f), Integer.valueOf(this.f37542g));
            this.f37543h = ofObject;
            ofObject.setDuration(500L);
            this.f37543h.addUpdateListener(new a(this));
            this.f37543h.start();
        }
    }

    public AdDownloadViewLP isCornerRadius(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.f37545j = z;
            return this;
        }
        return (AdDownloadViewLP) invokeZ.objValue;
    }

    public AdDownloadViewLP isShowProgress(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            this.l = z;
            return this;
        }
        return (AdDownloadViewLP) invokeZ.objValue;
    }

    public void setAbsorbColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f37542g = i2;
        }
    }

    public AdDownloadViewLP setBgColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            this.f37541f = i2;
            return this;
        }
        return (AdDownloadViewLP) invokeI.objValue;
    }

    public AdDownloadViewLP setFgColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            this.f37544i = i2;
            return this;
        }
        return (AdDownloadViewLP) invokeI.objValue;
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            int i3 = this.q;
            if (i2 > i3) {
                i2 = i3;
            }
            this.f37546k = i2;
            if (i2 == 0) {
                this.r = State.PREPARE;
            } else if (i2 == this.q) {
                this.r = State.FINISH;
            } else {
                this.r = State.DOWNLOADING;
            }
        }
    }

    public AdDownloadViewLP setRadius(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048593, this, f2)) == null) {
            this.s = f2;
            return this;
        }
        return (AdDownloadViewLP) invokeF.objValue;
    }

    public AdDownloadViewLP setTextColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            this.n = i2;
            return this;
        }
        return (AdDownloadViewLP) invokeI.objValue;
    }

    public AdDownloadViewLP setTextSize(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048595, this, f2)) == null) {
            this.o = f2;
            return this;
        }
        return (AdDownloadViewLP) invokeF.objValue;
    }

    @Override // c.a.b0.g.f.i
    public void update(String str, @NonNull c.a.b0.g.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, aVar) == null) {
            this.p = str;
            if (aVar.f1495c == AdDownloadStatus.DOWNLOADING) {
                this.p = "已下载 : " + this.p;
            }
            setProgress((int) aVar.f1501i);
            postInvalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdDownloadViewLP(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f37540e = new Paint();
        this.f37541f = -2210218;
        this.f37542g = -1;
        this.f37544i = 1073741824;
        this.m = new Paint();
        this.n = -1;
        this.q = 100;
        this.r = State.PREPARE;
        this.s = -1.0f;
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdDownloadViewLP(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f37540e = new Paint();
        this.f37541f = -2210218;
        this.f37542g = -1;
        this.f37544i = 1073741824;
        this.m = new Paint();
        this.n = -1;
        this.q = 100;
        this.r = State.PREPARE;
        this.s = -1.0f;
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(api = 21)
    public AdDownloadViewLP(Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f37540e = new Paint();
        this.f37541f = -2210218;
        this.f37542g = -1;
        this.f37544i = 1073741824;
        this.m = new Paint();
        this.n = -1;
        this.q = 100;
        this.r = State.PREPARE;
        this.s = -1.0f;
    }
}
