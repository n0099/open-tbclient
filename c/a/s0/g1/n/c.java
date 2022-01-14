package c.a.s0.g1.n;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class c extends ReplacementSpan {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f12656e;

    /* renamed from: f  reason: collision with root package name */
    public int f12657f;

    /* renamed from: g  reason: collision with root package name */
    public int f12658g;

    /* renamed from: h  reason: collision with root package name */
    public int f12659h;

    /* renamed from: i  reason: collision with root package name */
    public int f12660i;

    /* renamed from: j  reason: collision with root package name */
    public int f12661j;
    public int k;
    public int l;
    public int m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1265985970, "Lc/a/s0/g1/n/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1265985970, "Lc/a/s0/g1/n/c;");
                return;
            }
        }
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds5);
        o = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds11);
        p = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
        q = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
    }

    public c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f12656e = TbadkCoreApplication.getInst().getResources().getColor(R.color.white_alpha100);
        this.f12657f = R.color.CAM_X0305;
        this.f12658g = n;
        this.f12659h = o;
        this.f12660i = q;
        this.f12661j = 0;
        this.k = p;
        this.l = 0;
        if (bVar != null) {
            this.f12656e = bVar.a;
            this.f12657f = bVar.f12647b;
            this.f12658g = bVar.f12648c;
            this.f12660i = bVar.f12649d;
            this.f12659h = bVar.f12650e;
            this.f12661j = bVar.f12651f;
            this.k = bVar.f12652g;
            this.l = bVar.f12653h;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), paint}) == null) {
            canvas.save();
            canvas.translate(0.0f, this.l);
            paint.setColor(SkinManager.getColor(this.f12657f));
            paint.setAntiAlias(true);
            float descent = this.f12660i - (paint.descent() - paint.ascent());
            float f3 = i5;
            RectF rectF = new RectF(this.f12661j + f2, (paint.ascent() + f3) - descent, this.f12661j + f2 + this.m + (this.f12659h * 2), paint.descent() + f3);
            int i7 = this.f12658g;
            canvas.drawRoundRect(rectF, i7, i7, paint);
            paint.setColor(this.f12656e);
            canvas.drawText(charSequence, i2, i3, this.f12659h + f2 + this.f12661j, f3 - (descent / 2.0f), paint);
            canvas.restore();
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{paint, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), fontMetricsInt})) == null) {
            int measureText = (int) paint.measureText(charSequence, i2, i3);
            this.m = measureText;
            return measureText + (this.f12659h * 2) + this.f12661j + this.k;
        }
        return invokeCommon.intValue;
    }
}
