package c.a.o0.e1.n;

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
/* loaded from: classes2.dex */
public class c extends ReplacementSpan {
    public static /* synthetic */ Interceptable $ic;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f10160b;

    /* renamed from: c  reason: collision with root package name */
    public int f10161c;

    /* renamed from: d  reason: collision with root package name */
    public int f10162d;

    /* renamed from: e  reason: collision with root package name */
    public int f10163e;

    /* renamed from: f  reason: collision with root package name */
    public int f10164f;

    /* renamed from: g  reason: collision with root package name */
    public int f10165g;

    /* renamed from: h  reason: collision with root package name */
    public int f10166h;
    public int i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(277032628, "Lc/a/o0/e1/n/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(277032628, "Lc/a/o0/e1/n/c;");
                return;
            }
        }
        j = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds5);
        k = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds11);
        l = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
        m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
    }

    public c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = TbadkCoreApplication.getInst().getResources().getColor(R.color.white_alpha100);
        this.f10160b = R.color.CAM_X0305;
        this.f10161c = j;
        this.f10162d = k;
        this.f10163e = m;
        this.f10164f = 0;
        this.f10165g = l;
        this.f10166h = 0;
        if (bVar != null) {
            this.a = bVar.a;
            this.f10160b = bVar.f10153b;
            this.f10161c = bVar.f10154c;
            this.f10163e = bVar.f10155d;
            this.f10162d = bVar.f10156e;
            this.f10164f = bVar.f10157f;
            this.f10165g = bVar.f10158g;
            this.f10166h = bVar.f10159h;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) {
            canvas.save();
            canvas.translate(0.0f, this.f10166h);
            paint.setColor(SkinManager.getColor(this.f10160b));
            paint.setAntiAlias(true);
            float descent = this.f10163e - (paint.descent() - paint.ascent());
            float f3 = i4;
            RectF rectF = new RectF(this.f10164f + f2, (paint.ascent() + f3) - descent, this.f10164f + f2 + this.i + (this.f10162d * 2), paint.descent() + f3);
            int i6 = this.f10161c;
            canvas.drawRoundRect(rectF, i6, i6, paint);
            paint.setColor(this.a);
            canvas.drawText(charSequence, i, i2, this.f10162d + f2 + this.f10164f, f3 - (descent / 2.0f), paint);
            canvas.restore();
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})) == null) {
            int measureText = (int) paint.measureText(charSequence, i, i2);
            this.i = measureText;
            return measureText + (this.f10162d * 2) + this.f10164f + this.f10165g;
        }
        return invokeCommon.intValue;
    }
}
