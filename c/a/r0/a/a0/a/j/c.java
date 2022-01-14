package c.a.r0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RectF a;

    /* renamed from: b  reason: collision with root package name */
    public float f5076b;

    /* renamed from: c  reason: collision with root package name */
    public float f5077c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5078d;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.r0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) || this.a == null) {
            return;
        }
        if (!this.f5078d && Math.abs(this.f5077c) >= 360.0f) {
            Path path = bVar.f5075j;
            RectF rectF = this.a;
            float f2 = rectF.bottom;
            float f3 = rectF.top;
            path.addCircle((rectF.right + rectF.left) / 2.0f, (f2 + f3) / 2.0f, (f2 - f3) / 2.0f, Path.Direction.CW);
            bVar.f5075j.arcTo(this.a, 0.0f, this.f5076b);
            return;
        }
        float f4 = this.f5077c % 360.0f;
        if (f4 < 0.0f && !this.f5078d) {
            f4 += 360.0f;
        } else if (f4 > 0.0f && this.f5078d) {
            f4 -= 360.0f;
        }
        bVar.f5075j.arcTo(this.a, this.f5076b, f4);
    }

    @Override // c.a.r0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            if (jSONArray.length() > 4) {
                int g2 = c.a.r0.a.z2.n0.g((float) jSONArray.optDouble(0));
                int g3 = c.a.r0.a.z2.n0.g((float) jSONArray.optDouble(1));
                int g4 = c.a.r0.a.z2.n0.g((float) jSONArray.optDouble(2));
                float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
                float degrees2 = (float) Math.toDegrees((float) jSONArray.optDouble(4));
                this.a = new RectF(g2 - g4, g3 - g4, g2 + g4, g3 + g4);
                this.f5076b = degrees;
                this.f5077c = degrees2 - degrees;
            }
            if (jSONArray.length() > 5) {
                this.f5078d = jSONArray.optBoolean(5);
            }
        }
    }
}
