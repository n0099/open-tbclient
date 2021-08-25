package c.a.p0.s.f0.r;

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
/* loaded from: classes3.dex */
public class c extends ReplacementSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f13939e;

    /* renamed from: f  reason: collision with root package name */
    public int f13940f;

    /* renamed from: g  reason: collision with root package name */
    public int f13941g;

    /* renamed from: h  reason: collision with root package name */
    public int f13942h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f13943i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f13944j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public boolean s;

    public c(int i2, int i3, int i4, int i5, int i6, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13939e = R.drawable.icon_pure_evaluation_star24_n;
        this.f13940f = R.color.CAM_X0112;
        this.f13941g = R.drawable.icon_pure_evaluation_star24_n;
        this.f13942h = R.color.CAM_X0305;
        this.q = 5;
        this.r = i2;
        this.k = i3;
        this.l = i4;
        this.m = i5;
        this.o = i6;
        this.s = z;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f13943i = SvgManager.getInstance().getPureDrawable(this.f13939e, this.f13940f, null);
            this.f13944j = SvgManager.getInstance().getPureDrawable(this.f13941g, this.f13942h, null);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
        int dimenPixelSize;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), paint}) == null) {
            a();
            this.n = (int) paint.getTextSize();
            int i8 = ((int) f2) + this.o;
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i9 = 0;
            if (c.a.p0.s.u.e.a.b(charSequence)) {
                c.a.p0.s.u.e.a.a(fontMetricsInt, (int) paint.getTextSize());
                dimenPixelSize = 0 - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
            } else {
                dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds3) + 0;
            }
            int max = dimenPixelSize + fontMetricsInt.ascent + i5 + Math.max(0, ((this.n - this.l) / 2) + (this.s ? (i6 - i5) / 2 : 0));
            while (true) {
                i7 = this.r;
                if (i9 >= i7) {
                    break;
                }
                Drawable drawable = this.f13944j;
                if (drawable != null) {
                    int i10 = this.l;
                    drawable.setBounds(i8, max, i8 + i10, i10 + max);
                    this.f13944j.draw(canvas);
                    i8 += this.k + this.l;
                }
                i9++;
            }
            while (i7 < this.q) {
                Drawable drawable2 = this.f13943i;
                if (drawable2 != null) {
                    int i11 = this.l;
                    drawable2.setBounds(i8, max, i8 + i11, i11 + max);
                    this.f13943i.draw(canvas);
                    i8 += this.k + this.l;
                }
                i7++;
            }
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i2, int i3, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{paint, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), fontMetricsInt})) == null) {
            int i4 = this.q;
            int i5 = (this.l * i4) + (this.k * (i4 - 1)) + this.m + this.o;
            this.p = i5;
            return i5;
        }
        return invokeCommon.intValue;
    }
}
