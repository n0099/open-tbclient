package c.a.p0.a.q.a.j;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class b0 extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DashPathEffect a;

    public b0() {
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

    @Override // c.a.p0.a.q.a.j.a
    public void a(b bVar, Canvas canvas) {
        DashPathEffect dashPathEffect;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) || (dashPathEffect = this.a) == null) {
            return;
        }
        bVar.f7047g.setPathEffect(dashPathEffect);
    }

    @Override // c.a.p0.a.q.a.j.a
    public void b(JSONArray jSONArray) {
        float[] fArr;
        JSONArray optJSONArray;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            if (jSONArray.length() <= 0 || (optJSONArray = jSONArray.optJSONArray(0)) == null || (length = optJSONArray.length()) <= 0) {
                fArr = null;
            } else {
                fArr = new float[length];
                for (int i2 = 0; i2 < length; i2++) {
                    fArr[i2] = c.a.p0.a.p2.n0.g((float) optJSONArray.optDouble(i2));
                }
            }
            int g2 = jSONArray.length() > 1 ? c.a.p0.a.p2.n0.g((float) jSONArray.optDouble(1)) : 0;
            if (fArr == null || g2 < 0) {
                return;
            }
            this.a = new DashPathEffect(fArr, g2);
        }
    }
}
