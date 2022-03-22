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
import androidx.core.view.InputDeviceCompat;
import c.a.a0.h0.f;
import c.a.a0.j.f.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class AdDownloadViewLP extends View implements i<AdDownloadViewLP> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Paint a;

    /* renamed from: b  reason: collision with root package name */
    public int f27508b;

    /* renamed from: c  reason: collision with root package name */
    public int f27509c;

    /* renamed from: d  reason: collision with root package name */
    public ValueAnimator f27510d;

    /* renamed from: e  reason: collision with root package name */
    public int f27511e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27512f;

    /* renamed from: g  reason: collision with root package name */
    public int f27513g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27514h;
    public final Paint i;
    public int j;
    public float k;
    public String l;
    public int m;
    public State n;
    public float o;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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

        public State(String str, int i) {
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

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdDownloadViewLP a;

        public a(AdDownloadViewLP adDownloadViewLP) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adDownloadViewLP};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adDownloadViewLP;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.f27508b = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Paint();
        this.f27508b = -2210218;
        this.f27509c = -1;
        this.f27511e = 1073741824;
        this.i = new Paint();
        this.j = -1;
        this.m = 100;
        this.n = State.PREPARE;
        this.o = -1.0f;
        h();
    }

    public final void b(Canvas canvas, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, canvas, rectF) == null) {
            this.a.setColor(this.f27508b);
            this.a.setStyle(Paint.Style.FILL);
            float f2 = this.o;
            if (f2 <= 0.0f) {
                f2 = this.f27512f ? rectF.height() / 2.0f : 0.0f;
            }
            canvas.drawRoundRect(rectF, f2, f2, this.a);
        }
    }

    @Override // c.a.a0.j.f.i
    public void c(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) && (viewGroup instanceof RelativeLayout)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.width = (int) (f.c.e(getContext()) * f.c.h(R.dimen.obfuscated_res_0x7f0704c0));
            layoutParams.height = (int) (f.c.c(getContext()) * f.c.h(R.dimen.obfuscated_res_0x7f0704bd));
            layoutParams.addRule(13, -1);
            viewGroup.addView(this, layoutParams);
            viewGroup.setVisibility(0);
            viewGroup.bringToFront();
        }
    }

    public final void d(Canvas canvas, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, canvas, rectF) == null) {
            int i = b.a[this.n.ordinal()];
            float f2 = 0.0f;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                this.a.setColor(this.f27511e);
                this.a.setStyle(Paint.Style.FILL);
                float f3 = this.o;
                if (f3 > 0.0f) {
                    f2 = f3;
                } else if (this.f27512f) {
                    f2 = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f2, f2, this.a);
                return;
            }
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            float f4 = this.f27513g / this.m;
            paint.setShader(new LinearGradient(0.0f, 0.0f, rectF.width(), 0.0f, new int[]{this.f27511e, 0}, new float[]{f4, f4 + 1.0E-4f}, Shader.TileMode.CLAMP));
            float f5 = this.o;
            if (f5 > 0.0f) {
                f2 = f5;
            } else if (this.f27512f) {
                f2 = rectF.height() / 2.0f;
            }
            canvas.drawRoundRect(rectF, f2, f2, paint);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.draw(canvas);
            if (getWidth() == 0 || getHeight() == 0 || TextUtils.isEmpty(this.l)) {
                return;
            }
            if (this.f27509c != -1) {
                i();
            }
            if (!this.f27514h) {
                g(canvas);
            } else {
                f(canvas);
            }
        }
    }

    public final void e(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            this.i.setTextSize(this.k);
            float height = (canvas.getHeight() / 2.0f) - ((this.i.descent() / 2.0f) + (this.i.ascent() / 2.0f));
            float measureText = this.i.measureText(this.l);
            this.i.setColor(this.j);
            canvas.drawText(this.l, (getMeasuredWidth() - measureText) / 2.0f, height, this.i);
        }
    }

    public final void f(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            b(canvas, rectF);
            d(canvas, rectF);
            e(canvas);
        }
    }

    public final void g(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            float f2 = 0;
            RectF rectF = new RectF(f2, f2, getWidth() + 0, getHeight() + 0);
            this.a.setColor(this.f27508b);
            this.a.setStyle(Paint.Style.FILL);
            float f3 = this.o;
            if (f3 <= 0.0f) {
                f3 = this.f27512f ? rectF.height() / 2.0f : 0.0f;
            }
            canvas.drawRoundRect(rectF, f3, f3, this.a);
            this.i.setColor(this.j);
            this.i.setTextSize(this.k);
            Paint.FontMetrics fontMetrics = this.i.getFontMetrics();
            float f4 = fontMetrics.descent;
            canvas.drawText(this.l, (getMeasuredWidth() - this.i.measureText(this.l)) / 2.0f, ((getHeight() / 2.0f) - f4) + ((f4 - fontMetrics.ascent) / 2.0f), this.i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.a0.j.f.i
    @NonNull
    public AdDownloadViewLP getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : (AdDownloadViewLP) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            n(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704f0));
            l(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060803));
            m(-1);
            k(true);
            j(true);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.f27510d == null) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.f27508b), Integer.valueOf(this.f27509c));
            this.f27510d = ofObject;
            ofObject.setDuration(500L);
            this.f27510d.addUpdateListener(new a(this));
            this.f27510d.start();
        }
    }

    public AdDownloadViewLP j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.f27512f = z;
            return this;
        }
        return (AdDownloadViewLP) invokeZ.objValue;
    }

    public AdDownloadViewLP k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            this.f27514h = z;
            return this;
        }
        return (AdDownloadViewLP) invokeZ.objValue;
    }

    public AdDownloadViewLP l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            this.f27508b = i;
            return this;
        }
        return (AdDownloadViewLP) invokeI.objValue;
    }

    public AdDownloadViewLP m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            this.j = i;
            return this;
        }
        return (AdDownloadViewLP) invokeI.objValue;
    }

    public AdDownloadViewLP n(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048591, this, f2)) == null) {
            this.k = f2;
            return this;
        }
        return (AdDownloadViewLP) invokeF.objValue;
    }

    public void setAbsorbColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.f27509c = i;
        }
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            if (i < 0) {
                i = 0;
            }
            int i2 = this.m;
            if (i > i2) {
                i = i2;
            }
            this.f27513g = i;
            if (i == 0) {
                this.n = State.PREPARE;
            } else if (i == this.m) {
                this.n = State.FINISH;
            } else {
                this.n = State.DOWNLOADING;
            }
        }
    }

    @Override // c.a.a0.j.f.i
    public void update(String str, @NonNull c.a.a0.j.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, aVar) == null) {
            this.l = str;
            if (aVar.f1246c == AdDownloadStatus.DOWNLOADING) {
                this.l = "已下载 : " + this.l;
            }
            setProgress((int) aVar.i);
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
        this.a = new Paint();
        this.f27508b = -2210218;
        this.f27509c = -1;
        this.f27511e = 1073741824;
        this.i = new Paint();
        this.j = -1;
        this.m = 100;
        this.n = State.PREPARE;
        this.o = -1.0f;
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdDownloadViewLP(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = new Paint();
        this.f27508b = -2210218;
        this.f27509c = -1;
        this.f27511e = 1073741824;
        this.i = new Paint();
        this.j = -1;
        this.m = 100;
        this.n = State.PREPARE;
        this.o = -1.0f;
        h();
    }
}
