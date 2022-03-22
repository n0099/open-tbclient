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
/* loaded from: classes4.dex */
public class GamenowDownloadButtomView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;

    /* renamed from: b  reason: collision with root package name */
    public int f29506b;

    /* renamed from: c  reason: collision with root package name */
    public int f29507c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29508d;

    /* renamed from: e  reason: collision with root package name */
    public int f29509e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29510f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f29511g;

    /* renamed from: h  reason: collision with root package name */
    public int f29512h;
    public float i;
    public String j;
    public int k;
    public DownloadState l;
    public float m;

    /* loaded from: classes4.dex */
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
        this.f29511g = new Paint();
        this.f29512h = -1;
        this.k = 100;
        this.l = DownloadState.NOT_START;
        this.m = -1.0f;
        this.a.setAntiAlias(true);
        this.f29511g.setAntiAlias(true);
        this.i = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070144);
        this.f29506b = context.getResources().getColor(R.color.obfuscated_res_0x7f060393);
        this.f29507c = context.getResources().getColor(R.color.obfuscated_res_0x7f060394);
    }

    public final void a(Canvas canvas, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, canvas, rectF) == null) {
            int i = a.a[this.l.ordinal()];
            float f2 = 0.0f;
            if (i != 1 && i != 2) {
                this.a.setColor(this.f29506b);
                this.a.setStyle(Paint.Style.FILL);
                float f3 = this.m;
                if (f3 > 0.0f) {
                    f2 = f3;
                } else if (this.f29508d) {
                    f2 = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f2, f2, this.a);
                return;
            }
            this.a.setColor(this.f29506b);
            this.a.setStyle(Paint.Style.STROKE);
            this.a.setStrokeWidth(1.0f);
            float f4 = this.m;
            if (f4 > 0.0f) {
                f2 = f4;
            } else if (this.f29508d) {
                f2 = rectF.height() / 2.0f;
            }
            canvas.drawRoundRect(rectF, f2, f2, this.a);
        }
    }

    public final void b(Canvas canvas, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, rectF) == null) {
            int i = a.a[this.l.ordinal()];
            float f2 = 0.0f;
            if (i == 1 || i == 2) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                float f3 = 1;
                RectF rectF2 = new RectF(f3, f3, getWidth() - 2, getHeight() - 2);
                float f4 = this.f29509e / this.k;
                paint.setShader(new LinearGradient(0.0f, 0.0f, rectF2.width(), 0.0f, new int[]{this.f29507c, 0}, new float[]{f4, f4 + 1.0E-4f}, Shader.TileMode.CLAMP));
                float f5 = this.m;
                if (f5 > 0.0f) {
                    f2 = f5;
                } else if (this.f29508d) {
                    f2 = rectF2.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF2, f2, f2, paint);
            } else if (i != 3) {
                this.a.setColor(this.f29506b);
                this.a.setStyle(Paint.Style.FILL);
                float f6 = this.m;
                if (f6 > 0.0f) {
                    f2 = f6;
                } else if (this.f29508d) {
                    f2 = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f2, f2, this.a);
            } else {
                this.a.setColor(this.f29507c);
                this.a.setStyle(Paint.Style.FILL);
                float f7 = this.m;
                if (f7 > 0.0f) {
                    f2 = f7;
                } else if (this.f29508d) {
                    f2 = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f2, f2, this.a);
            }
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            this.f29511g.setTextSize(this.i);
            float height = (canvas.getHeight() / 2) - ((this.f29511g.descent() / 2.0f) + (this.f29511g.ascent() / 2.0f));
            float measureText = this.f29511g.measureText(this.j);
            this.f29511g.setColor(this.f29512h);
            canvas.drawText(this.j, (getMeasuredWidth() - measureText) / 2.0f, height, this.f29511g);
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
            if (!this.f29510f) {
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
            this.a.setColor(this.f29506b);
            this.a.setStyle(Paint.Style.FILL);
            float f3 = this.m;
            if (f3 <= 0.0f) {
                f3 = this.f29508d ? rectF.height() / 2.0f : 0.0f;
            }
            canvas.drawRoundRect(rectF, f3, f3, this.a);
            this.f29511g.setColor(this.f29512h);
            this.f29511g.setTextSize(this.i);
            Paint.FontMetrics fontMetrics = this.f29511g.getFontMetrics();
            float f4 = fontMetrics.descent;
            canvas.drawText(this.j, (getMeasuredWidth() - this.f29511g.measureText(this.j)) / 2.0f, ((getHeight() / 2) - f4) + ((f4 - fontMetrics.ascent) / 2.0f), this.f29511g);
        }
    }

    public GamenowDownloadButtomView f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.f29508d = z;
            return this;
        }
        return (GamenowDownloadButtomView) invokeZ.objValue;
    }

    public GamenowDownloadButtomView g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.f29510f = z;
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
            this.f29506b = i;
            return this;
        }
        return (GamenowDownloadButtomView) invokeI.objValue;
    }

    public GamenowDownloadButtomView i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            this.f29507c = i;
            return this;
        }
        return (GamenowDownloadButtomView) invokeI.objValue;
    }

    public GamenowDownloadButtomView j(@ColorInt int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            this.f29512h = i;
            return this;
        }
        return (GamenowDownloadButtomView) invokeI.objValue;
    }

    public GamenowDownloadButtomView k(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048588, this, f2)) == null) {
            this.i = f2;
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
            this.f29509e = i;
        }
    }

    public void setRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f2) == null) {
            this.m = f2;
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
