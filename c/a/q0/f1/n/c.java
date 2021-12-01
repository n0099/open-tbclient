package c.a.q0.f1.n;

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
/* loaded from: classes5.dex */
public class c extends ReplacementSpan {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f12149e;

    /* renamed from: f  reason: collision with root package name */
    public int f12150f;

    /* renamed from: g  reason: collision with root package name */
    public int f12151g;

    /* renamed from: h  reason: collision with root package name */
    public int f12152h;

    /* renamed from: i  reason: collision with root package name */
    public int f12153i;

    /* renamed from: j  reason: collision with root package name */
    public int f12154j;

    /* renamed from: k  reason: collision with root package name */
    public int f12155k;
    public int l;
    public int m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(771509299, "Lc/a/q0/f1/n/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(771509299, "Lc/a/q0/f1/n/c;");
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
        this.f12149e = TbadkCoreApplication.getInst().getResources().getColor(R.color.white_alpha100);
        this.f12150f = R.color.CAM_X0305;
        this.f12151g = n;
        this.f12152h = o;
        this.f12153i = q;
        this.f12154j = 0;
        this.f12155k = p;
        this.l = 0;
        if (bVar != null) {
            this.f12149e = bVar.a;
            this.f12150f = bVar.f12140b;
            this.f12151g = bVar.f12141c;
            this.f12153i = bVar.f12142d;
            this.f12152h = bVar.f12143e;
            this.f12154j = bVar.f12144f;
            this.f12155k = bVar.f12145g;
            this.l = bVar.f12146h;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), paint}) == null) {
            canvas.save();
            canvas.translate(0.0f, this.l);
            paint.setColor(SkinManager.getColor(this.f12150f));
            paint.setAntiAlias(true);
            float descent = this.f12153i - (paint.descent() - paint.ascent());
            float f3 = i5;
            RectF rectF = new RectF(this.f12154j + f2, (paint.ascent() + f3) - descent, this.f12154j + f2 + this.m + (this.f12152h * 2), paint.descent() + f3);
            int i7 = this.f12151g;
            canvas.drawRoundRect(rectF, i7, i7, paint);
            paint.setColor(this.f12149e);
            canvas.drawText(charSequence, i2, i3, this.f12152h + f2 + this.f12154j, f3 - (descent / 2.0f), paint);
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
            return measureText + (this.f12152h * 2) + this.f12154j + this.f12155k;
        }
        return invokeCommon.intValue;
    }
}
