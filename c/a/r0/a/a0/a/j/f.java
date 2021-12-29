package c.a.r0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class f extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f5194b;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuffXfermode f5195c;

    public f() {
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
        this.f5194b = new Paint();
        this.f5195c = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    }

    @Override // c.a.r0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) || this.a == null) {
            return;
        }
        this.f5194b.setXfermode(this.f5195c);
        canvas.drawRect(this.a, this.f5194b);
    }

    @Override // c.a.r0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g2 = c.a.r0.a.z2.n0.g((float) jSONArray.optDouble(0));
                    int g3 = c.a.r0.a.z2.n0.g((float) jSONArray.optDouble(1));
                    this.a = new Rect(g2, g3, c.a.r0.a.z2.n0.g((float) jSONArray.optDouble(2)) + g2, c.a.r0.a.z2.n0.g((float) jSONArray.optDouble(3)) + g3);
                }
            } catch (Exception e2) {
                if (c.a.r0.a.k.a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
