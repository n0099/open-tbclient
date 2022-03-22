package c.a.n0.a.q.a.j;

import android.graphics.Canvas;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class r extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f5954b;

    /* renamed from: c  reason: collision with root package name */
    public float f5955c;

    /* renamed from: d  reason: collision with root package name */
    public float f5956d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5957e;

    public r() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5957e = false;
    }

    @Override // c.a.n0.a.q.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) && this.f5957e) {
            bVar.f5900f.quadTo(this.a, this.f5954b, this.f5955c, this.f5956d);
        }
    }

    @Override // c.a.n0.a.q.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 3) {
            return;
        }
        this.a = c.a.n0.a.p2.n0.g((float) jSONArray.optDouble(0));
        this.f5954b = c.a.n0.a.p2.n0.g((float) jSONArray.optDouble(1));
        this.f5955c = c.a.n0.a.p2.n0.g((float) jSONArray.optDouble(2));
        this.f5956d = c.a.n0.a.p2.n0.g((float) jSONArray.optDouble(3));
        this.f5957e = true;
    }
}
