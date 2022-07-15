package com.baidu.swan.game.ad.downloader.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SwanAdDownloadButtonView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;
    public int b;
    public int c;
    public boolean d;
    public int e;
    public boolean f;
    public Paint g;
    public int h;
    public float i;
    public String j;
    public int k;
    public State l;
    public float m;

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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1726203572, "Lcom/baidu/swan/game/ad/downloader/view/SwanAdDownloadButtonView$State;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1726203572, "Lcom/baidu/swan/game/ad/downloader/view/SwanAdDownloadButtonView$State;");
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
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1975815260, "Lcom/baidu/swan/game/ad/downloader/view/SwanAdDownloadButtonView$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1975815260, "Lcom/baidu/swan/game/ad/downloader/view/SwanAdDownloadButtonView$a;");
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
    public SwanAdDownloadButtonView(Context context) {
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
        this.g = new Paint();
        this.h = -1;
        this.k = 100;
        this.l = State.PREPARE;
        this.m = -1.0f;
        this.a.setAntiAlias(true);
        this.g.setAntiAlias(true);
        this.i = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070661);
        this.b = context.getResources().getColor(R.color.obfuscated_res_0x7f060a5c);
        this.c = context.getResources().getColor(R.color.obfuscated_res_0x7f060a5d);
    }

    public final void a(Canvas canvas, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, canvas, rectF) == null) {
            this.a.setColor(this.b);
            this.a.setStyle(Paint.Style.FILL);
            float f = this.m;
            if (f <= 0.0f) {
                f = this.d ? rectF.height() / 2.0f : 0.0f;
            }
            canvas.drawRoundRect(rectF, f, f, this.a);
        }
    }

    public final void b(Canvas canvas, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, rectF) == null) {
            int i = a.a[this.l.ordinal()];
            float f = 0.0f;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                this.a.setColor(this.c);
                this.a.setStyle(Paint.Style.FILL);
                float f2 = this.m;
                if (f2 > 0.0f) {
                    f = f2;
                } else if (this.d) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, this.a);
                return;
            }
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            float f3 = this.e / this.k;
            paint.setShader(new LinearGradient(0.0f, 0.0f, rectF.width(), 0.0f, new int[]{this.c, 0}, new float[]{f3, f3 + 1.0E-4f}, Shader.TileMode.CLAMP));
            float f4 = this.m;
            if (f4 > 0.0f) {
                f = f4;
            } else if (this.d) {
                f = rectF.height() / 2.0f;
            }
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            this.g.setTextSize(this.i);
            float height = (canvas.getHeight() / 2) - ((this.g.descent() / 2.0f) + (this.g.ascent() / 2.0f));
            float measureText = this.g.measureText(this.j);
            this.g.setColor(this.h);
            canvas.drawText(this.j, (getMeasuredWidth() - measureText) / 2.0f, height, this.g);
        }
    }

    public final void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            float f = 0;
            RectF rectF = new RectF(f, f, getWidth(), getHeight());
            a(canvas, rectF);
            b(canvas, rectF);
            c(canvas);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.draw(canvas);
            if (getWidth() == 0 || getHeight() == 0 || TextUtils.isEmpty(this.j)) {
                return;
            }
            if (!this.f) {
                e(canvas);
            } else {
                d(canvas);
            }
        }
    }

    public final void e(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            float f = 0;
            RectF rectF = new RectF(f, f, getWidth() + 0, getHeight() + 0);
            this.a.setColor(this.b);
            this.a.setStyle(Paint.Style.FILL);
            float f2 = this.m;
            if (f2 <= 0.0f) {
                f2 = this.d ? rectF.height() / 2.0f : 0.0f;
            }
            canvas.drawRoundRect(rectF, f2, f2, this.a);
            this.g.setColor(this.h);
            this.g.setTextSize(this.i);
            Paint.FontMetrics fontMetrics = this.g.getFontMetrics();
            float f3 = fontMetrics.descent;
            canvas.drawText(this.j, (getMeasuredWidth() - this.g.measureText(this.j)) / 2.0f, ((getHeight() / 2) - f3) + ((f3 - fontMetrics.ascent) / 2.0f), this.g);
        }
    }

    public SwanAdDownloadButtonView f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.d = z;
            return this;
        }
        return (SwanAdDownloadButtonView) invokeZ.objValue;
    }

    public SwanAdDownloadButtonView g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.f = z;
            return this;
        }
        return (SwanAdDownloadButtonView) invokeZ.objValue;
    }

    public int getMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : invokeV.intValue;
    }

    public SwanAdDownloadButtonView h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            this.b = i;
            return this;
        }
        return (SwanAdDownloadButtonView) invokeI.objValue;
    }

    public SwanAdDownloadButtonView i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            this.h = i;
            return this;
        }
        return (SwanAdDownloadButtonView) invokeI.objValue;
    }

    public SwanAdDownloadButtonView j(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048587, this, f)) == null) {
            this.i = f;
            return this;
        }
        return (SwanAdDownloadButtonView) invokeF.objValue;
    }

    public void setMax(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.k = i;
        }
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            if (i < 0) {
                i = 0;
            }
            int i2 = this.k;
            if (i > i2) {
                i = i2;
            }
            this.e = i;
            if (i == 0) {
                this.l = State.PREPARE;
            } else if (i == this.k) {
                this.l = State.FINISH;
            } else {
                this.l = State.DOWNLOADING;
            }
        }
    }

    public void setRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f) == null) {
            this.m = f;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.j = str;
        }
    }
}
