package b.a.p0.a.a0.a.j;

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
    public Rect f3912a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f3913b;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuffXfermode f3914c;

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
        this.f3913b = new Paint();
        this.f3914c = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    }

    @Override // b.a.p0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) || this.f3912a == null) {
            return;
        }
        this.f3913b.setXfermode(this.f3914c);
        canvas.drawRect(this.f3912a, this.f3913b);
    }

    @Override // b.a.p0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g2 = b.a.p0.a.z2.n0.g((float) jSONArray.optDouble(0));
                    int g3 = b.a.p0.a.z2.n0.g((float) jSONArray.optDouble(1));
                    this.f3912a = new Rect(g2, g3, b.a.p0.a.z2.n0.g((float) jSONArray.optDouble(2)) + g2, b.a.p0.a.z2.n0.g((float) jSONArray.optDouble(3)) + g3);
                }
            } catch (Exception e2) {
                if (b.a.p0.a.k.f6863a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
