package c.a.o0.r.l0.r;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c extends ReplacementSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f10674b;

    /* renamed from: c  reason: collision with root package name */
    public int f10675c;

    /* renamed from: d  reason: collision with root package name */
    public int f10676d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f10677e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f10678f;

    /* renamed from: g  reason: collision with root package name */
    public int f10679g;

    /* renamed from: h  reason: collision with root package name */
    public int f10680h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;

    public c(int i, int i2, int i3, int i4, int i5, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = R.drawable.icon_pure_evaluation_star24_n;
        this.f10674b = R.color.CAM_X0112;
        this.f10675c = R.drawable.icon_pure_evaluation_star24_n;
        this.f10676d = R.color.CAM_X0305;
        this.m = 5;
        this.n = i;
        this.f10679g = i2;
        this.f10680h = i3;
        this.i = i4;
        this.k = i5;
        this.o = z;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f10677e = SvgManager.getInstance().getPureDrawable(this.a, this.f10674b, null);
            this.f10678f = SvgManager.getInstance().getPureDrawable(this.f10675c, this.f10676d, null);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, @NonNull Paint paint) {
        int dimenPixelSize;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) {
            a();
            this.j = (int) paint.getTextSize();
            int i7 = ((int) f2) + this.k;
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i8 = 0;
            if (c.a.o0.r.v.e.a.b(charSequence)) {
                c.a.o0.r.v.e.a.a(fontMetricsInt, (int) paint.getTextSize());
                dimenPixelSize = 0 - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
            } else {
                dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds3) + 0;
            }
            int max = dimenPixelSize + fontMetricsInt.ascent + i4 + Math.max(0, ((this.j - this.f10680h) / 2) + (this.o ? (i5 - i4) / 2 : 0));
            while (true) {
                i6 = this.n;
                if (i8 >= i6) {
                    break;
                }
                Drawable drawable = this.f10678f;
                if (drawable != null) {
                    int i9 = this.f10680h;
                    drawable.setBounds(i7, max, i7 + i9, i9 + max);
                    this.f10678f.draw(canvas);
                    i7 += this.f10679g + this.f10680h;
                }
                i8++;
            }
            while (i6 < this.m) {
                Drawable drawable2 = this.f10677e;
                if (drawable2 != null) {
                    int i10 = this.f10680h;
                    drawable2.setBounds(i7, max, i7 + i10, i10 + max);
                    this.f10677e.draw(canvas);
                    i7 += this.f10679g + this.f10680h;
                }
                i6++;
            }
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})) == null) {
            int i3 = this.m;
            int i4 = (this.f10680h * i3) + (this.f10679g * (i3 - 1)) + this.i + this.k;
            this.l = i4;
            return i4;
        }
        return invokeCommon.intValue;
    }
}
