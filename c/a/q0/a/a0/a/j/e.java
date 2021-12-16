package c.a.q0.a.a0.a.j;

import android.graphics.Canvas;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class e extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f4453b;

    /* renamed from: c  reason: collision with root package name */
    public float f4454c;

    /* renamed from: d  reason: collision with root package name */
    public float f4455d;

    /* renamed from: e  reason: collision with root package name */
    public float f4456e;

    /* renamed from: f  reason: collision with root package name */
    public float f4457f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4458g;

    public e() {
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
        this.f4458g = false;
    }

    @Override // c.a.q0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) && this.f4458g) {
            bVar.f4448j.cubicTo(this.a, this.f4453b, this.f4454c, this.f4455d, this.f4456e, this.f4457f);
        }
    }

    @Override // c.a.q0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 5) {
            return;
        }
        this.a = c.a.q0.a.z2.n0.g((float) jSONArray.optDouble(0));
        this.f4453b = c.a.q0.a.z2.n0.g((float) jSONArray.optDouble(1));
        this.f4454c = c.a.q0.a.z2.n0.g((float) jSONArray.optDouble(2));
        this.f4455d = c.a.q0.a.z2.n0.g((float) jSONArray.optDouble(3));
        this.f4456e = c.a.q0.a.z2.n0.g((float) jSONArray.optDouble(4));
        this.f4457f = c.a.q0.a.z2.n0.g((float) jSONArray.optDouble(5));
        this.f4458g = true;
    }
}
