package c.a.p0.a.a0.a.j;

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

    /* renamed from: a  reason: collision with root package name */
    public String f4466a;

    /* renamed from: b  reason: collision with root package name */
    public int f4467b;

    /* renamed from: c  reason: collision with root package name */
    public int f4468c;

    /* renamed from: d  reason: collision with root package name */
    public float f4469d;

    /* renamed from: e  reason: collision with root package name */
    public float f4470e;

    /* renamed from: f  reason: collision with root package name */
    public float f4471f;

    public o0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4469d = -1.0f;
        this.f4470e = 0.0f;
        this.f4471f = 1.0f;
    }

    @Override // c.a.p0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) || TextUtils.isEmpty(this.f4466a)) {
            return;
        }
        TextPaint textPaint = bVar.f4403i;
        int i2 = bVar.o;
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f2 = fontMetrics.top;
        int i3 = this.f4468c;
        float f3 = i3 + f2;
        float f4 = fontMetrics.ascent + i3;
        float f5 = fontMetrics.bottom;
        float f6 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i3 : i3 - (f4 - f3) : (i3 + ((f5 - f2) / 2.0f)) - f5 : i3 + (((i3 + f5) - f3) / 2.0f) + (f4 - f3);
        if (this.f4470e == 0.0d) {
            Rect rect = new Rect();
            String str = this.f4466a;
            textPaint.getTextBounds(str, 0, str.length(), rect);
            if (this.f4469d != -1.0f) {
                float f7 = this.f4469d;
                if (rect.width() > f7) {
                    this.f4470e = f7 / rect.width();
                }
            }
            this.f4470e = 1.0f;
        }
        canvas.save();
        int alpha = textPaint.getAlpha();
        int color = textPaint.getColor();
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setStrokeWidth(this.f4471f);
        textPaint.setColor(bVar.q);
        bVar.f(textPaint);
        canvas.scale(this.f4470e, 1.0f);
        canvas.drawText(this.f4466a, this.f4467b, f6, textPaint);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAlpha(alpha);
        textPaint.setColor(color);
        canvas.restore();
    }

    @Override // c.a.p0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 2) {
                    this.f4466a = jSONArray.optString(0);
                    this.f4467b = c.a.p0.a.v2.n0.g((float) jSONArray.optDouble(1));
                    this.f4468c = c.a.p0.a.v2.n0.g((float) jSONArray.optDouble(2));
                    if (jSONArray.length() > 3) {
                        this.f4469d = c.a.p0.a.v2.n0.g((float) jSONArray.optDouble(3));
                    }
                    this.f4471f = c.a.p0.a.v2.n0.g(1.0f);
                }
            } catch (Exception e2) {
                if (c.a.p0.a.k.f7085a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
