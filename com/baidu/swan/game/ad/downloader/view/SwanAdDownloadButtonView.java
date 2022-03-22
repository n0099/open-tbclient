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
/* loaded from: classes4.dex */
public class SwanAdDownloadButtonView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;

    /* renamed from: b  reason: collision with root package name */
    public int f29466b;

    /* renamed from: c  reason: collision with root package name */
    public int f29467c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29468d;

    /* renamed from: e  reason: collision with root package name */
    public int f29469e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29470f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f29471g;

    /* renamed from: h  reason: collision with root package name */
    public int f29472h;
    public float i;
    public String j;
    public int k;
    public State l;
    public float m;

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

    /* loaded from: classes4.dex */
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
        this.f29471g = new Paint();
        this.f29472h = -1;
        this.k = 100;
        this.l = State.PREPARE;
        this.m = -1.0f;
        this.a.setAntiAlias(true);
        this.f29471g.setAntiAlias(true);
        this.i = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0705f8);
        this.f29466b = context.getResources().getColor(R.color.obfuscated_res_0x7f060a4f);
        this.f29467c = context.getResources().getColor(R.color.obfuscated_res_0x7f060a50);
    }

    public final void a(Canvas canvas, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, canvas, rectF) == null) {
            this.a.setColor(this.f29466b);
            this.a.setStyle(Paint.Style.FILL);
            float f2 = this.m;
            if (f2 <= 0.0f) {
                f2 = this.f29468d ? rectF.height() / 2.0f : 0.0f;
            }
            canvas.drawRoundRect(rectF, f2, f2, this.a);
        }
    }

    public final void b(Canvas canvas, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, rectF) == null) {
            int i = a.a[this.l.ordinal()];
            float f2 = 0.0f;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                this.a.setColor(this.f29467c);
                this.a.setStyle(Paint.Style.FILL);
                float f3 = this.m;
                if (f3 > 0.0f) {
                    f2 = f3;
                } else if (this.f29468d) {
                    f2 = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f2, f2, this.a);
                return;
            }
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            float f4 = this.f29469e / this.k;
            paint.setShader(new LinearGradient(0.0f, 0.0f, rectF.width(), 0.0f, new int[]{this.f29467c, 0}, new float[]{f4, f4 + 1.0E-4f}, Shader.TileMode.CLAMP));
            float f5 = this.m;
            if (f5 > 0.0f) {
                f2 = f5;
            } else if (this.f29468d) {
                f2 = rectF.height() / 2.0f;
            }
            canvas.drawRoundRect(rectF, f2, f2, paint);
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            this.f29471g.setTextSize(this.i);
            float height = (canvas.getHeight() / 2) - ((this.f29471g.descent() / 2.0f) + (this.f29471g.ascent() / 2.0f));
            float measureText = this.f29471g.measureText(this.j);
            this.f29471g.setColor(this.f29472h);
            canvas.drawText(this.j, (getMeasuredWidth() - measureText) / 2.0f, height, this.f29471g);
        }
    }

    public final void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            float f2 = 0;
            RectF rectF = new RectF(f2, f2, getWidth(), getHeight());
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
            if (!this.f29470f) {
                e(canvas);
            } else {
                d(canvas);
            }
        }
    }

    public final void e(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            float f2 = 0;
            RectF rectF = new RectF(f2, f2, getWidth() + 0, getHeight() + 0);
            this.a.setColor(this.f29466b);
            this.a.setStyle(Paint.Style.FILL);
            float f3 = this.m;
            if (f3 <= 0.0f) {
                f3 = this.f29468d ? rectF.height() / 2.0f : 0.0f;
            }
            canvas.drawRoundRect(rectF, f3, f3, this.a);
            this.f29471g.setColor(this.f29472h);
            this.f29471g.setTextSize(this.i);
            Paint.FontMetrics fontMetrics = this.f29471g.getFontMetrics();
            float f4 = fontMetrics.descent;
            canvas.drawText(this.j, (getMeasuredWidth() - this.f29471g.measureText(this.j)) / 2.0f, ((getHeight() / 2) - f4) + ((f4 - fontMetrics.ascent) / 2.0f), this.f29471g);
        }
    }

    public SwanAdDownloadButtonView f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.f29468d = z;
            return this;
        }
        return (SwanAdDownloadButtonView) invokeZ.objValue;
    }

    public SwanAdDownloadButtonView g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.f29470f = z;
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
            this.f29466b = i;
            return this;
        }
        return (SwanAdDownloadButtonView) invokeI.objValue;
    }

    public SwanAdDownloadButtonView i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            this.f29472h = i;
            return this;
        }
        return (SwanAdDownloadButtonView) invokeI.objValue;
    }

    public SwanAdDownloadButtonView j(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048587, this, f2)) == null) {
            this.i = f2;
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
            this.f29469e = i;
            if (i == 0) {
                this.l = State.PREPARE;
            } else if (i == this.k) {
                this.l = State.FINISH;
            } else {
                this.l = State.DOWNLOADING;
            }
        }
    }

    public void setRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f2) == null) {
            this.m = f2;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.j = str;
        }
    }
}
