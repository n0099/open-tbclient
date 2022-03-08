package c.a.p0.a.q.a.j;

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
    public int f7092b;

    /* renamed from: c  reason: collision with root package name */
    public int f7093c;

    /* renamed from: d  reason: collision with root package name */
    public float f7094d;

    /* renamed from: e  reason: collision with root package name */
    public float f7095e;

    /* renamed from: f  reason: collision with root package name */
    public float f7096f;

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
        this.f7094d = -1.0f;
        this.f7095e = 0.0f;
        this.f7096f = 1.0f;
    }

    @Override // c.a.p0.a.q.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) || TextUtils.isEmpty(this.a)) {
            return;
        }
        TextPaint textPaint = bVar.f7049i;
        int i2 = bVar.o;
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f2 = fontMetrics.top;
        int i3 = this.f7093c;
        float f3 = i3 + f2;
        float f4 = fontMetrics.ascent + i3;
        float f5 = fontMetrics.bottom;
        float f6 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i3 : i3 - (f4 - f3) : (i3 + ((f5 - f2) / 2.0f)) - f5 : i3 + (((i3 + f5) - f3) / 2.0f) + (f4 - f3);
        if (this.f7095e == 0.0d) {
            Rect rect = new Rect();
            String str = this.a;
            textPaint.getTextBounds(str, 0, str.length(), rect);
            if (this.f7094d != -1.0f) {
                float f7 = this.f7094d;
                if (rect.width() > f7) {
                    this.f7095e = f7 / rect.width();
                }
            }
            this.f7095e = 1.0f;
        }
        canvas.save();
        int alpha = textPaint.getAlpha();
        int color = textPaint.getColor();
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setStrokeWidth(this.f7096f);
        textPaint.setColor(bVar.q);
        bVar.c(textPaint);
        canvas.scale(this.f7095e, 1.0f);
        canvas.drawText(this.a, this.f7092b, f6, textPaint);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAlpha(alpha);
        textPaint.setColor(color);
        canvas.restore();
    }

    @Override // c.a.p0.a.q.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 2) {
                    this.a = jSONArray.optString(0);
                    this.f7092b = c.a.p0.a.p2.n0.g((float) jSONArray.optDouble(1));
                    this.f7093c = c.a.p0.a.p2.n0.g((float) jSONArray.optDouble(2));
                    if (jSONArray.length() > 3) {
                        this.f7094d = c.a.p0.a.p2.n0.g((float) jSONArray.optDouble(3));
                    }
                    this.f7096f = c.a.p0.a.p2.n0.g(1.0f);
                }
            } catch (Exception e2) {
                if (c.a.p0.a.a.a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
