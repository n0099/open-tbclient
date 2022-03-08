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
/* loaded from: classes5.dex */
public class GamenowDownloadButtomView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f38371e;

    /* renamed from: f  reason: collision with root package name */
    public int f38372f;

    /* renamed from: g  reason: collision with root package name */
    public int f38373g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f38374h;

    /* renamed from: i  reason: collision with root package name */
    public int f38375i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f38376j;
    public Paint k;
    public int l;
    public float m;
    public String n;
    public int o;
    public DownloadState p;
    public float q;

    /* loaded from: classes5.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38371e = new Paint();
        this.k = new Paint();
        this.l = -1;
        this.o = 100;
        this.p = DownloadState.NOT_START;
        this.q = -1.0f;
        this.f38371e.setAntiAlias(true);
        this.k.setAntiAlias(true);
        this.m = getResources().getDimensionPixelOffset(R.dimen.aiapps_game_dimens_14dp);
        this.f38372f = context.getResources().getColor(R.color.aiapps_download_button_default_bg_color);
        this.f38373g = context.getResources().getColor(R.color.aiapps_download_button_default_fg_color);
    }

    public final void a(Canvas canvas, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, canvas, rectF) == null) {
            int i2 = a.a[this.p.ordinal()];
            float f2 = 0.0f;
            if (i2 != 1 && i2 != 2) {
                this.f38371e.setColor(this.f38372f);
                this.f38371e.setStyle(Paint.Style.FILL);
                float f3 = this.q;
                if (f3 > 0.0f) {
                    f2 = f3;
                } else if (this.f38374h) {
                    f2 = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f2, f2, this.f38371e);
                return;
            }
            this.f38371e.setColor(this.f38372f);
            this.f38371e.setStyle(Paint.Style.STROKE);
            this.f38371e.setStrokeWidth(1.0f);
            float f4 = this.q;
            if (f4 > 0.0f) {
                f2 = f4;
            } else if (this.f38374h) {
                f2 = rectF.height() / 2.0f;
            }
            canvas.drawRoundRect(rectF, f2, f2, this.f38371e);
        }
    }

    public final void b(Canvas canvas, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, rectF) == null) {
            int i2 = a.a[this.p.ordinal()];
            float f2 = 0.0f;
            if (i2 == 1 || i2 == 2) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                float f3 = 1;
                RectF rectF2 = new RectF(f3, f3, getWidth() - 2, getHeight() - 2);
                float f4 = this.f38375i / this.o;
                paint.setShader(new LinearGradient(0.0f, 0.0f, rectF2.width(), 0.0f, new int[]{this.f38373g, 0}, new float[]{f4, f4 + 1.0E-4f}, Shader.TileMode.CLAMP));
                float f5 = this.q;
                if (f5 > 0.0f) {
                    f2 = f5;
                } else if (this.f38374h) {
                    f2 = rectF2.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF2, f2, f2, paint);
            } else if (i2 != 3) {
                this.f38371e.setColor(this.f38372f);
                this.f38371e.setStyle(Paint.Style.FILL);
                float f6 = this.q;
                if (f6 > 0.0f) {
                    f2 = f6;
                } else if (this.f38374h) {
                    f2 = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f2, f2, this.f38371e);
            } else {
                this.f38371e.setColor(this.f38373g);
                this.f38371e.setStyle(Paint.Style.FILL);
                float f7 = this.q;
                if (f7 > 0.0f) {
                    f2 = f7;
                } else if (this.f38374h) {
                    f2 = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f2, f2, this.f38371e);
            }
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
            if (!this.f38376j) {
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
            this.f38371e.setColor(this.f38372f);
            this.f38371e.setStyle(Paint.Style.FILL);
            float f3 = this.q;
            if (f3 <= 0.0f) {
                f3 = this.f38374h ? rectF.height() / 2.0f : 0.0f;
            }
            canvas.drawRoundRect(rectF, f3, f3, this.f38371e);
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

    public GamenowDownloadButtomView isCornerRadius(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.f38374h = z;
            return this;
        }
        return (GamenowDownloadButtomView) invokeZ.objValue;
    }

    public GamenowDownloadButtomView isShowProgress(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            this.f38376j = z;
            return this;
        }
        return (GamenowDownloadButtomView) invokeZ.objValue;
    }

    public GamenowDownloadButtomView setBgColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            this.f38372f = i2;
            return this;
        }
        return (GamenowDownloadButtomView) invokeI.objValue;
    }

    public GamenowDownloadButtomView setFgColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            this.f38373g = i2;
            return this;
        }
        return (GamenowDownloadButtomView) invokeI.objValue;
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
            this.f38375i = i2;
        }
    }

    public void setRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            this.q = f2;
        }
    }

    public void setState(DownloadState downloadState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, downloadState) == null) {
            this.p = downloadState;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.n = str;
        }
    }

    public GamenowDownloadButtomView setTextColor(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            this.l = i2;
            return this;
        }
        return (GamenowDownloadButtomView) invokeI.objValue;
    }

    public GamenowDownloadButtomView setTextSize(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048593, this, f2)) == null) {
            this.m = f2;
            return this;
        }
        return (GamenowDownloadButtomView) invokeF.objValue;
    }
}
