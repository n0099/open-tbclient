package c.a.n0.a.q.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class o0 extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f5941b;

    /* renamed from: c  reason: collision with root package name */
    public int f5942c;

    /* renamed from: d  reason: collision with root package name */
    public float f5943d;

    /* renamed from: e  reason: collision with root package name */
    public float f5944e;

    /* renamed from: f  reason: collision with root package name */
    public float f5945f;

    public o0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5943d = -1.0f;
        this.f5944e = 0.0f;
        this.f5945f = 1.0f;
    }

    @Override // c.a.n0.a.q.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) || TextUtils.isEmpty(this.a)) {
            return;
        }
        TextPaint textPaint = bVar.f5899e;
        int i = bVar.k;
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f2 = fontMetrics.top;
        int i2 = this.f5942c;
        float f3 = i2 + f2;
        float f4 = fontMetrics.ascent + i2;
        float f5 = fontMetrics.bottom;
        float f6 = i != 1 ? i != 2 ? i != 3 ? i2 : i2 - (f4 - f3) : (i2 + ((f5 - f2) / 2.0f)) - f5 : i2 + (((i2 + f5) - f3) / 2.0f) + (f4 - f3);
        if (this.f5944e == 0.0d) {
            Rect rect = new Rect();
            String str = this.a;
            textPaint.getTextBounds(str, 0, str.length(), rect);
            if (this.f5943d != -1.0f) {
                float f7 = this.f5943d;
                if (rect.width() > f7) {
                    this.f5944e = f7 / rect.width();
                }
            }
            this.f5944e = 1.0f;
        }
        canvas.save();
        int alpha = textPaint.getAlpha();
        int color = textPaint.getColor();
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setStrokeWidth(this.f5945f);
        textPaint.setColor(bVar.m);
        bVar.c(textPaint);
        canvas.scale(this.f5944e, 1.0f);
        canvas.drawText(this.a, this.f5941b, f6, textPaint);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAlpha(alpha);
        textPaint.setColor(color);
        canvas.restore();
    }

    @Override // c.a.n0.a.q.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 2) {
                    this.a = jSONArray.optString(0);
                    this.f5941b = c.a.n0.a.p2.n0.g((float) jSONArray.optDouble(1));
                    this.f5942c = c.a.n0.a.p2.n0.g((float) jSONArray.optDouble(2));
                    if (jSONArray.length() > 3) {
                        this.f5943d = c.a.n0.a.p2.n0.g((float) jSONArray.optDouble(3));
                    }
                    this.f5945f = c.a.n0.a.p2.n0.g(1.0f);
                }
            } catch (Exception e2) {
                if (c.a.n0.a.a.a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
