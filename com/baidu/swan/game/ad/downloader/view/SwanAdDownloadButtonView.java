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
import c.a.p0.f.i.b;
import c.a.p0.f.i.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class SwanAdDownloadButtonView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f46900e;

    /* renamed from: f  reason: collision with root package name */
    public int f46901f;

    /* renamed from: g  reason: collision with root package name */
    public int f46902g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f46903h;

    /* renamed from: i  reason: collision with root package name */
    public int f46904i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f46905j;
    public Paint k;
    public int l;
    public float m;
    public String n;
    public int o;
    public State p;
    public float q;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
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
            DOWNLOADING = new State(AdDownloadApkUtils.DL_STATUS_DOWNLOADING, 1);
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

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f46906a;
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
            f46906a = iArr;
            try {
                iArr[State.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46906a[State.FINISH.ordinal()] = 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46900e = new Paint();
        this.k = new Paint();
        this.l = -1;
        this.o = 100;
        this.p = State.PREPARE;
        this.q = -1.0f;
        this.f46900e.setAntiAlias(true);
        this.k.setAntiAlias(true);
        this.m = getResources().getDimensionPixelOffset(c.swan_ad_dimens_14dp);
        this.f46901f = context.getResources().getColor(b.swanapp_ad_download_button_default_bg_color);
        this.f46902g = context.getResources().getColor(b.swanapp_ad_download_button_default_fg_color);
    }

    public final void a(Canvas canvas, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, canvas, rectF) == null) {
            this.f46900e.setColor(this.f46901f);
            this.f46900e.setStyle(Paint.Style.FILL);
            float f2 = this.q;
            if (f2 <= 0.0f) {
                f2 = this.f46903h ? rectF.height() / 2.0f : 0.0f;
            }
            canvas.drawRoundRect(rectF, f2, f2, this.f46900e);
        }
    }

    public final void b(Canvas canvas, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, rectF) == null) {
            int i2 = a.f46906a[this.p.ordinal()];
            float f2 = 0.0f;
            if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                this.f46900e.setColor(this.f46902g);
                this.f46900e.setStyle(Paint.Style.FILL);
                float f3 = this.q;
                if (f3 > 0.0f) {
                    f2 = f3;
                } else if (this.f46903h) {
                    f2 = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f2, f2, this.f46900e);
                return;
            }
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            float f4 = this.f46904i / this.o;
            paint.setShader(new LinearGradient(0.0f, 0.0f, rectF.width(), 0.0f, new int[]{this.f46902g, 0}, new float[]{f4, f4 + 1.0E-4f}, Shader.TileMode.CLAMP));
            float f5 = this.q;
            if (f5 > 0.0f) {
                f2 = f5;
            } else if (this.f46903h) {
                f2 = rectF.height() / 2.0f;
            }
            canvas.drawRoundRect(rectF, f2, f2, paint);
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            this.k.setTextSize(this.m);
            float height = (canvas.getHeight() / 2) - ((this.k.descent() / 2.0f) + (this.k.ascent() / 2.0f));
            float measureText = this.k.measureText(this.n);
            this.k.setColor(this.l);
            canvas.drawText(this.n, (getMeasuredWidth() - measureText) / 2.0f, height, this.k);
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
            if (getWidth() == 0 || getHeight() == 0 || TextUtils.isEmpty(this.n)) {
                return;
            }
            if (!this.f46905j) {
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
            this.f46900e.setColor(this.f46901f);
            this.f46900e.setStyle(Paint.Style.FILL);
            float f3 = this.q;
            if (f3 <= 0.0f) {
                f3 = this.f46903h ? rectF.height() / 2.0f : 0.0f;
            }
            canvas.drawRoundRect(rectF, f3, f3, this.f46900e);
            this.k.setColor(this.l);
            this.k.setTextSize(this.m);
            Paint.FontMetrics fontMetrics = this.k.getFontMetrics();
            float f4 = fontMetrics.descent;
            canvas.drawText(this.n, (getMeasuredWidth() - this.k.measureText(this.n)) / 2.0f, ((getHeight() / 2) - f4) + ((f4 - fontMetrics.ascent) / 2.0f), this.k);
        }
    }

    public int getMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.o : invokeV.intValue;
    }

    public SwanAdDownloadButtonView isCornerRadius(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.f46903h = z;
            return this;
        }
        return (SwanAdDownloadButtonView) invokeZ.objValue;
    }

    public SwanAdDownloadButtonView isShowProgress(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            this.f46905j = z;
            return this;
        }
        return (SwanAdDownloadButtonView) invokeZ.objValue;
    }

    public SwanAdDownloadButtonView setBgColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            this.f46901f = i2;
            return this;
        }
        return (SwanAdDownloadButtonView) invokeI.objValue;
    }

    public SwanAdDownloadButtonView setFgColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            this.f46902g = i2;
            return this;
        }
        return (SwanAdDownloadButtonView) invokeI.objValue;
    }

    public void setMax(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.o = i2;
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            int i3 = this.o;
            if (i2 > i3) {
                i2 = i3;
            }
            this.f46904i = i2;
            if (i2 == 0) {
                this.p = State.PREPARE;
            } else if (i2 == this.o) {
                this.p = State.FINISH;
            } else {
                this.p = State.DOWNLOADING;
            }
        }
    }

    public void setRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            this.q = f2;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.n = str;
        }
    }

    public SwanAdDownloadButtonView setTextColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            this.l = i2;
            return this;
        }
        return (SwanAdDownloadButtonView) invokeI.objValue;
    }

    public SwanAdDownloadButtonView setTextSize(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048592, this, f2)) == null) {
            this.m = f2;
            return this;
        }
        return (SwanAdDownloadButtonView) invokeF.objValue;
    }
}
