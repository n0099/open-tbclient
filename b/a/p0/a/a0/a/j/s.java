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
public class s extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RectF f3887a;

    public s() {
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
        RectF rectF;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) || (rectF = this.f3887a) == null) {
            return;
        }
        bVar.j.addRect(rectF, Path.Direction.CW);
    }

    @Override // b.a.p0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g2 = b.a.p0.a.v2.n0.g((float) jSONArray.optDouble(0));
                    int g3 = b.a.p0.a.v2.n0.g((float) jSONArray.optDouble(1));
                    this.f3887a = new RectF(g2, g3, g2 + b.a.p0.a.v2.n0.g((float) jSONArray.optDouble(2)), g3 + b.a.p0.a.v2.n0.g((float) jSONArray.optDouble(3)));
                }
            } catch (Exception e2) {
                if (b.a.p0.a.k.f6397a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
