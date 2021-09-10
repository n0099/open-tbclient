package c.a.q0.s.f0;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.style.ReplacementSpan;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class b extends ReplacementSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float[] f13810e;

    /* renamed from: f  reason: collision with root package name */
    public int f13811f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f13812g;

    /* renamed from: h  reason: collision with root package name */
    public int f13813h;

    /* renamed from: i  reason: collision with root package name */
    public int f13814i;

    /* renamed from: j  reason: collision with root package name */
    public int f13815j;
    public int k;
    public int l;
    public Paint m;
    public String n;
    public int o;
    public int p;
    public boolean q;
    public int r;
    public boolean s;
    public int t;

    public b(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i9 = newInitContext.flag;
            if ((i9 & 1) != 0) {
                int i10 = i9 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13810e = new float[8];
        this.f13812g = new RectF();
        this.r = 255;
        this.s = false;
        this.t = 0;
        if (i3 > 0) {
            c(i3);
        }
        this.f13811f = i4;
        this.f13813h = i5;
        this.f13814i = i6;
        this.f13815j = i7;
        this.l = i8;
        Paint paint = new Paint();
        this.m = paint;
        paint.setAntiAlias(true);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setTextSize(this.f13813h);
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            this.r = (int) (f2 * 255.0f);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            Arrays.fill(this.f13810e, i2);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            float[] A = c.a.q0.s.u.a.A(i2);
            if (Arrays.equals(this.f13810e, A)) {
                return;
            }
            this.f13810e = A;
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.t = i2;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
        int i7;
        int color;
        int color2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{canvas, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), paint}) == null) {
            this.m.setColor(SkinManager.getColor(this.f13811f));
            this.m.setAlpha(this.r);
            if (this.q) {
                this.m.setStyle(Paint.Style.FILL);
            } else {
                this.m.setStyle(Paint.Style.STROKE);
            }
            if (this.s) {
                RectF rectF = this.f13812g;
                int i8 = this.o;
                rectF.left = f2 + i8;
                int i9 = this.t;
                rectF.top = (i5 - this.l) + i9;
                rectF.right = f2 + this.k + i8;
                rectF.bottom = i5 + i9;
            } else {
                Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                if (c.a.q0.s.u.e.a.b(charSequence)) {
                    c.a.q0.s.u.e.a.a(fontMetricsInt, (int) paint.getTextSize());
                    i7 = 0 - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
                } else {
                    i7 = (((fontMetricsInt.descent - fontMetricsInt.ascent) - this.l) / 2) + 0;
                }
                int i10 = i7 + i5 + fontMetricsInt.ascent;
                RectF rectF2 = this.f13812g;
                rectF2.left = f2 + this.o;
                rectF2.top = Math.max(i10, i5 + fontMetricsInt.top);
                RectF rectF3 = this.f13812g;
                rectF3.right = f2 + this.k + this.o;
                rectF3.bottom = Math.min(i10 + this.l, i5 + fontMetricsInt.bottom);
            }
            String str = this.n;
            if (str != null) {
                if (" 吧主".equals(str)) {
                    color = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                    color2 = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                } else if (" 小吧主".equals(this.n)) {
                    color = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                    color2 = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                } else if (" 楼主".equals(this.n)) {
                    color = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                    color2 = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                } else {
                    color = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                    color2 = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                }
                int i11 = color;
                int i12 = color2;
                RectF rectF4 = this.f13812g;
                this.m.setShader(new LinearGradient(rectF4.left, rectF4.top, rectF4.right, rectF4.bottom, i11, i12, Shader.TileMode.CLAMP));
            }
            Path path = new Path();
            path.addRoundRect(this.f13812g, this.f13810e, Path.Direction.CW);
            canvas.drawPath(path, this.m);
            this.m.setShader(null);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if ((skinType == 1 || skinType == 4) && this.n != null) {
                this.m.setColor(SelectorHelper.getResources().getColor(R.color.mask));
                if (this.q) {
                    this.m.setStyle(Paint.Style.FILL);
                } else {
                    this.m.setStyle(Paint.Style.STROKE);
                }
                Path path2 = new Path();
                path2.addRoundRect(this.f13812g, this.f13810e, Path.Direction.CW);
                canvas.drawPath(path2, this.m);
            }
            Paint.FontMetricsInt fontMetricsInt2 = this.m.getFontMetricsInt();
            int i13 = this.f13814i;
            if (i13 != 0) {
                this.m.setColor(SkinManager.getColor(i13));
            } else {
                this.m.setColor(SelectorHelper.getResources().getColor(R.color.CAM_X0201));
            }
            this.m.setStyle(Paint.Style.FILL);
            float centerY = this.f13812g.centerY();
            int i14 = fontMetricsInt2.bottom;
            canvas.drawText(charSequence, i2, i3, f2 + this.f13815j + this.o, (int) ((centerY + ((i14 - fontMetricsInt2.top) / 2)) - i14), this.m);
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.n = str;
        }
    }

    public void f(boolean z) {
        Paint paint;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (paint = this.m) == null) {
            return;
        }
        this.q = z;
        if (z) {
            paint.setStyle(Paint.Style.FILL);
        } else {
            paint.setStyle(Paint.Style.STROKE);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.s = z;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i2, int i3, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{paint, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), fontMetricsInt})) == null) {
            int measureText = ((int) this.m.measureText(charSequence, i2, i3)) + (this.f13815j * 2);
            this.k = measureText;
            return measureText + this.o + this.p;
        }
        return invokeCommon.intValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.o = i2;
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.p = i2;
        }
    }
}
