package c.a.q0.s.f0.r;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a extends ReplacementSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f13886e;

    /* renamed from: f  reason: collision with root package name */
    public int f13887f;

    /* renamed from: g  reason: collision with root package name */
    public int f13888g;

    /* renamed from: h  reason: collision with root package name */
    public int f13889h;

    /* renamed from: i  reason: collision with root package name */
    public int f13890i;

    /* renamed from: j  reason: collision with root package name */
    public int f13891j;
    public int k;
    public int l;
    public int m;

    public a(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
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
        this.m = 0;
        this.f13887f = i2;
        this.f13888g = i3;
        this.f13889h = i4;
        this.f13890i = i5;
        this.f13891j = i6;
        this.k = i7;
        this.l = i8;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), paint}) == null) {
            float textSize = paint.getTextSize();
            int color = paint.getColor();
            float f3 = f2 + this.l;
            paint.setTextSize(this.f13889h);
            paint.setColor(SkinManager.getColor(this.f13887f));
            paint.setAntiAlias(true);
            int i7 = i4 + i6;
            int i8 = this.f13889h;
            int i9 = this.f13888g;
            int i10 = this.k;
            RectF rectF = new RectF(f3, (((i7 - i8) - i9) - i10) / 2, (this.f13886e + f3) - this.m, (((i7 + i8) + i9) + i10) / 2);
            int i11 = this.f13888g;
            canvas.drawRoundRect(rectF, i11, i11, paint);
            paint.setColor(SkinManager.getColor(this.f13890i));
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            canvas.drawText(charSequence, i2, i3, f3 + this.f13888g + this.f13891j, (int) ((rectF.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), paint);
            paint.setTextSize(textSize);
            paint.setColor(color);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{paint, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), fontMetricsInt})) == null) {
            float textSize = paint.getTextSize();
            paint.setTextSize(this.f13889h);
            this.f13886e = (int) (paint.measureText(charSequence, i2, i3) + (this.f13888g * 2) + (this.f13891j * 2) + this.m);
            paint.setTextSize(textSize);
            return this.f13886e;
        }
        return invokeCommon.intValue;
    }
}
