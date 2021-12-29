package c.a.r0.a.a0.a.j;

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
    public int f5226b;

    /* renamed from: c  reason: collision with root package name */
    public int f5227c;

    /* renamed from: d  reason: collision with root package name */
    public float f5228d;

    /* renamed from: e  reason: collision with root package name */
    public float f5229e;

    /* renamed from: f  reason: collision with root package name */
    public float f5230f;

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
        this.f5228d = -1.0f;
        this.f5229e = 0.0f;
        this.f5230f = 1.0f;
    }

    @Override // c.a.r0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) || TextUtils.isEmpty(this.a)) {
            return;
        }
        TextPaint textPaint = bVar.f5182i;
        int i2 = bVar.o;
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f2 = fontMetrics.top;
        int i3 = this.f5227c;
        float f3 = i3 + f2;
        float f4 = fontMetrics.ascent + i3;
        float f5 = fontMetrics.bottom;
        float f6 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i3 : i3 - (f4 - f3) : (i3 + ((f5 - f2) / 2.0f)) - f5 : i3 + (((i3 + f5) - f3) / 2.0f) + (f4 - f3);
        if (this.f5229e == 0.0d) {
            Rect rect = new Rect();
            String str = this.a;
            textPaint.getTextBounds(str, 0, str.length(), rect);
            if (this.f5228d != -1.0f) {
                float f7 = this.f5228d;
                if (rect.width() > f7) {
                    this.f5229e = f7 / rect.width();
                }
            }
            this.f5229e = 1.0f;
        }
        canvas.save();
        int alpha = textPaint.getAlpha();
        int color = textPaint.getColor();
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setStrokeWidth(this.f5230f);
        textPaint.setColor(bVar.q);
        bVar.c(textPaint);
        canvas.scale(this.f5229e, 1.0f);
        canvas.drawText(this.a, this.f5226b, f6, textPaint);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAlpha(alpha);
        textPaint.setColor(color);
        canvas.restore();
    }

    @Override // c.a.r0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 2) {
                    this.a = jSONArray.optString(0);
                    this.f5226b = c.a.r0.a.z2.n0.g((float) jSONArray.optDouble(1));
                    this.f5227c = c.a.r0.a.z2.n0.g((float) jSONArray.optDouble(2));
                    if (jSONArray.length() > 3) {
                        this.f5228d = c.a.r0.a.z2.n0.g((float) jSONArray.optDouble(3));
                    }
                    this.f5230f = c.a.r0.a.z2.n0.g(1.0f);
                }
            } catch (Exception e2) {
                if (c.a.r0.a.k.a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
