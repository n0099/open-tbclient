package c.a.p0.a.a0.a.j;

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

    /* renamed from: a  reason: collision with root package name */
    public Rect f4420a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f4421b;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuffXfermode f4422c;

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
        this.f4421b = new Paint();
        this.f4422c = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    }

    @Override // c.a.p0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) || this.f4420a == null) {
            return;
        }
        this.f4421b.setXfermode(this.f4422c);
        canvas.drawRect(this.f4420a, this.f4421b);
    }

    @Override // c.a.p0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g2 = c.a.p0.a.v2.n0.g((float) jSONArray.optDouble(0));
                    int g3 = c.a.p0.a.v2.n0.g((float) jSONArray.optDouble(1));
                    this.f4420a = new Rect(g2, g3, c.a.p0.a.v2.n0.g((float) jSONArray.optDouble(2)) + g2, c.a.p0.a.v2.n0.g((float) jSONArray.optDouble(3)) + g3);
                }
            } catch (Exception e2) {
                if (c.a.p0.a.k.f7085a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
