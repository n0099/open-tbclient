package c.a.p0.a.a0.a.j;

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

    /* renamed from: a  reason: collision with root package name */
    public float f4484a;

    /* renamed from: b  reason: collision with root package name */
    public float f4485b;

    /* renamed from: c  reason: collision with root package name */
    public float f4486c;

    /* renamed from: d  reason: collision with root package name */
    public float f4487d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4488e;

    public r() {
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
        this.f4488e = false;
    }

    @Override // c.a.p0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) && this.f4488e) {
            bVar.f4404j.quadTo(this.f4484a, this.f4485b, this.f4486c, this.f4487d);
        }
    }

    @Override // c.a.p0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 3) {
            return;
        }
        this.f4484a = c.a.p0.a.v2.n0.g((float) jSONArray.optDouble(0));
        this.f4485b = c.a.p0.a.v2.n0.g((float) jSONArray.optDouble(1));
        this.f4486c = c.a.p0.a.v2.n0.g((float) jSONArray.optDouble(2));
        this.f4487d = c.a.p0.a.v2.n0.g((float) jSONArray.optDouble(3));
        this.f4488e = true;
    }
}
