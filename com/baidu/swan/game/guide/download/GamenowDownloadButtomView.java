package com.baidu.swan.game.guide.download;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class GamenowDownloadButtomView extends View {
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
    public DownloadState l;
    public float m;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1704114621, "Lcom/baidu/swan/game/guide/download/GamenowDownloadButtomView$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1704114621, "Lcom/baidu/swan/game/guide/download/GamenowDownloadButtomView$a;");
                    return;
                }
            }
            int[] iArr = new int[DownloadState.values().length];
            a = iArr;
            try {
                iArr[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DownloadState.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DownloadState.DOWNLOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GamenowDownloadButtomView(Context context) {
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
        this.l = DownloadState.NOT_START;
        this.m = -1.0f;
        this.a.setAntiAlias(true);
        this.g.setAntiAlias(true);
        this.i = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070144);
        this.b = context.getResources().getColor(R.color.obfuscated_res_0x7f060396);
        this.c = context.getResources().getColor(R.color.obfuscated_res_0x7f060397);
    }

    public final void a(Canvas canvas, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, canvas, rectF) == null) {
            int i = a.a[this.l.ordinal()];
            float f = 0.0f;
            if (i != 1 && i != 2) {
                this.a.setColor(this.b);
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
            this.a.setColor(this.b);
            this.a.setStyle(Paint.Style.STROKE);
            this.a.setStrokeWidth(1.0f);
            float f3 = this.m;
            if (f3 > 0.0f) {
                f = f3;
            } else if (this.d) {
                f = rectF.height() / 2.0f;
            }
            canvas.drawRoundRect(rectF, f, f, this.a);
        }
    }

    public final void b(Canvas canvas, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, rectF) == null) {
            int i = a.a[this.l.ordinal()];
            float f = 0.0f;
            if (i == 1 || i == 2) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                float f2 = 1;
                RectF rectF2 = new RectF(f2, f2, getWidth() - 2, getHeight() - 2);
                float f3 = this.e / this.k;
                paint.setShader(new LinearGradient(0.0f, 0.0f, rectF2.width(), 0.0f, new int[]{this.c, 0}, new float[]{f3, f3 + 1.0E-4f}, Shader.TileMode.CLAMP));
                float f4 = this.m;
                if (f4 > 0.0f) {
                    f = f4;
                } else if (this.d) {
                    f = rectF2.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF2, f, f, paint);
            } else if (i != 3) {
                this.a.setColor(this.b);
                this.a.setStyle(Paint.Style.FILL);
                float f5 = this.m;
                if (f5 > 0.0f) {
                    f = f5;
                } else if (this.d) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, this.a);
            } else {
                this.a.setColor(this.c);
                this.a.setStyle(Paint.Style.FILL);
                float f6 = this.m;
                if (f6 > 0.0f) {
                    f = f6;
                } else if (this.d) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, this.a);
            }
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

    public GamenowDownloadButtomView f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.d = z;
            return this;
        }
        return (GamenowDownloadButtomView) invokeZ.objValue;
    }

    public GamenowDownloadButtomView g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.f = z;
            return this;
        }
        return (GamenowDownloadButtomView) invokeZ.objValue;
    }

    public int getMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : invokeV.intValue;
    }

    public GamenowDownloadButtomView h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            this.b = i;
            return this;
        }
        return (GamenowDownloadButtomView) invokeI.objValue;
    }

    public GamenowDownloadButtomView i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            this.c = i;
            return this;
        }
        return (GamenowDownloadButtomView) invokeI.objValue;
    }

    public GamenowDownloadButtomView j(@ColorInt int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            this.h = i;
            return this;
        }
        return (GamenowDownloadButtomView) invokeI.objValue;
    }

    public GamenowDownloadButtomView k(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048588, this, f)) == null) {
            this.i = f;
            return this;
        }
        return (GamenowDownloadButtomView) invokeF.objValue;
    }

    public void setMax(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.k = i;
        }
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            if (i < 0) {
                i = 0;
            }
            int i2 = this.k;
            if (i > i2) {
                i = i2;
            }
            this.e = i;
        }
    }

    public void setRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f) == null) {
            this.m = f;
        }
    }

    public void setState(DownloadState downloadState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, downloadState) == null) {
            this.l = downloadState;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.j = str;
        }
    }
}
