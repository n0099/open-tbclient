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
import com.repackage.hk0;
import com.repackage.m11;
import com.repackage.rj0;
/* loaded from: classes2.dex */
public class AdDownloadViewLP extends View implements hk0<AdDownloadViewLP> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Paint a;
    public int b;
    public int c;
    public ValueAnimator d;
    public int e;
    public boolean f;
    public int g;
    public boolean h;
    public final Paint i;
    public int j;
    public float k;
    public String l;
    public int m;
    public State n;
    public float o;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
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
                this.a.b = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes2.dex */
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
        this.b = -2210218;
        this.c = -1;
        this.e = 1073741824;
        this.i = new Paint();
        this.j = -1;
        this.m = 100;
        this.n = State.PREPARE;
        this.o = -1.0f;
        i();
    }

    @Override // com.repackage.hk0
    public void b(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) && (viewGroup instanceof RelativeLayout)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.width = (int) (m11.c.e(getContext()) * m11.c.h(R.dimen.obfuscated_res_0x7f0704ca));
            layoutParams.height = (int) (m11.c.c(getContext()) * m11.c.h(R.dimen.obfuscated_res_0x7f0704c8));
            layoutParams.addRule(13, -1);
            viewGroup.addView(this, layoutParams);
            viewGroup.setVisibility(0);
            viewGroup.bringToFront();
        }
    }

    public final void d(Canvas canvas, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, rectF) == null) {
            this.a.setColor(this.b);
            this.a.setStyle(Paint.Style.FILL);
            float f = this.o;
            if (f <= 0.0f) {
                f = this.f ? rectF.height() / 2.0f : 0.0f;
            }
            canvas.drawRoundRect(rectF, f, f, this.a);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.draw(canvas);
            if (getWidth() == 0 || getHeight() == 0 || TextUtils.isEmpty(this.l)) {
                return;
            }
            if (this.c != -1) {
                j();
            }
            if (!this.h) {
                h(canvas);
            } else {
                g(canvas);
            }
        }
    }

    public final void e(Canvas canvas, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, canvas, rectF) == null) {
            int i = b.a[this.n.ordinal()];
            float f = 0.0f;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                this.a.setColor(this.e);
                this.a.setStyle(Paint.Style.FILL);
                float f2 = this.o;
                if (f2 > 0.0f) {
                    f = f2;
                } else if (this.f) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, this.a);
                return;
            }
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            float f3 = this.g / this.m;
            paint.setShader(new LinearGradient(0.0f, 0.0f, rectF.width(), 0.0f, new int[]{this.e, 0}, new float[]{f3, f3 + 1.0E-4f}, Shader.TileMode.CLAMP));
            float f4 = this.o;
            if (f4 > 0.0f) {
                f = f4;
            } else if (this.f) {
                f = rectF.height() / 2.0f;
            }
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    public final void f(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            this.i.setTextSize(this.k);
            float height = (canvas.getHeight() / 2.0f) - ((this.i.descent() / 2.0f) + (this.i.ascent() / 2.0f));
            float measureText = this.i.measureText(this.l);
            this.i.setColor(this.j);
            canvas.drawText(this.l, (getMeasuredWidth() - measureText) / 2.0f, height, this.i);
        }
    }

    public final void g(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            d(canvas, rectF);
            e(canvas, rectF);
            f(canvas);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.hk0
    @NonNull
    public AdDownloadViewLP getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (AdDownloadViewLP) invokeV.objValue;
    }

    public final void h(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            float f = 0;
            RectF rectF = new RectF(f, f, getWidth() + 0, getHeight() + 0);
            this.a.setColor(this.b);
            this.a.setStyle(Paint.Style.FILL);
            float f2 = this.o;
            if (f2 <= 0.0f) {
                f2 = this.f ? rectF.height() / 2.0f : 0.0f;
            }
            canvas.drawRoundRect(rectF, f2, f2, this.a);
            this.i.setColor(this.j);
            this.i.setTextSize(this.k);
            Paint.FontMetrics fontMetrics = this.i.getFontMetrics();
            float f3 = fontMetrics.descent;
            canvas.drawText(this.l, (getMeasuredWidth() - this.i.measureText(this.l)) / 2.0f, ((getHeight() / 2.0f) - f3) + ((f3 - fontMetrics.ascent) / 2.0f), this.i);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            o(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704fc));
            m(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060816));
            n(-1);
            l(true);
            k(true);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.d == null) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.b), Integer.valueOf(this.c));
            this.d = ofObject;
            ofObject.setDuration(500L);
            this.d.addUpdateListener(new a(this));
            this.d.start();
        }
    }

    public AdDownloadViewLP k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.f = z;
            return this;
        }
        return (AdDownloadViewLP) invokeZ.objValue;
    }

    public AdDownloadViewLP l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            this.h = z;
            return this;
        }
        return (AdDownloadViewLP) invokeZ.objValue;
    }

    public AdDownloadViewLP m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            this.b = i;
            return this;
        }
        return (AdDownloadViewLP) invokeI.objValue;
    }

    public AdDownloadViewLP n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            this.j = i;
            return this;
        }
        return (AdDownloadViewLP) invokeI.objValue;
    }

    public AdDownloadViewLP o(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048591, this, f)) == null) {
            this.k = f;
            return this;
        }
        return (AdDownloadViewLP) invokeF.objValue;
    }

    public void setAbsorbColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.c = i;
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
            this.g = i;
            if (i == 0) {
                this.n = State.PREPARE;
            } else if (i == this.m) {
                this.n = State.FINISH;
            } else {
                this.n = State.DOWNLOADING;
            }
        }
    }

    @Override // com.repackage.hk0
    public void update(String str, @NonNull rj0 rj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, rj0Var) == null) {
            this.l = str;
            if (rj0Var.c == AdDownloadStatus.DOWNLOADING) {
                this.l = "已下载 : " + this.l;
            }
            setProgress((int) rj0Var.i);
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
        this.b = -2210218;
        this.c = -1;
        this.e = 1073741824;
        this.i = new Paint();
        this.j = -1;
        this.m = 100;
        this.n = State.PREPARE;
        this.o = -1.0f;
        i();
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
        this.b = -2210218;
        this.c = -1;
        this.e = 1073741824;
        this.i = new Paint();
        this.j = -1;
        this.m = 100;
        this.n = State.PREPARE;
        this.o = -1.0f;
        i();
    }
}
