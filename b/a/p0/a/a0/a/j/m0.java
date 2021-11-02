package b.a.p0.a.a0.a.j;

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
public class m0 extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Path f3855a;

    public m0() {
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

    @Override // b.a.p0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) || this.f3855a == null) {
            return;
        }
        int alpha = bVar.f3800g.getAlpha();
        bVar.c(bVar.f3800g);
        canvas.drawPath(this.f3855a, bVar.f3800g);
        bVar.f3800g.setAlpha(alpha);
    }

    @Override // b.a.p0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g2 = b.a.p0.a.v2.n0.g((float) jSONArray.optDouble(0));
                    int g3 = b.a.p0.a.v2.n0.g((float) jSONArray.optDouble(1));
                    int g4 = b.a.p0.a.v2.n0.g((float) jSONArray.optDouble(2));
                    int g5 = b.a.p0.a.v2.n0.g((float) jSONArray.optDouble(3));
                    Path path = new Path();
                    this.f3855a = path;
                    path.addRect(new RectF(g2, g3, g2 + g4, g3 + g5), Path.Direction.CW);
                }
            } catch (Exception e2) {
                if (b.a.p0.a.k.f6397a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
