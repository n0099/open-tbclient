package c.a.n0.a.a0.a.j;

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

    /* renamed from: a  reason: collision with root package name */
    public float f4130a;

    /* renamed from: b  reason: collision with root package name */
    public float f4131b;

    /* renamed from: c  reason: collision with root package name */
    public float f4132c;

    /* renamed from: d  reason: collision with root package name */
    public float f4133d;

    /* renamed from: e  reason: collision with root package name */
    public float f4134e;

    /* renamed from: f  reason: collision with root package name */
    public float f4135f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4136g;

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
        this.f4136g = false;
    }

    @Override // c.a.n0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) && this.f4136g) {
            bVar.f4122j.cubicTo(this.f4130a, this.f4131b, this.f4132c, this.f4133d, this.f4134e, this.f4135f);
        }
    }

    @Override // c.a.n0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 5) {
            return;
        }
        this.f4130a = c.a.n0.a.v2.n0.g((float) jSONArray.optDouble(0));
        this.f4131b = c.a.n0.a.v2.n0.g((float) jSONArray.optDouble(1));
        this.f4132c = c.a.n0.a.v2.n0.g((float) jSONArray.optDouble(2));
        this.f4133d = c.a.n0.a.v2.n0.g((float) jSONArray.optDouble(3));
        this.f4134e = c.a.n0.a.v2.n0.g((float) jSONArray.optDouble(4));
        this.f4135f = c.a.n0.a.v2.n0.g((float) jSONArray.optDouble(5));
        this.f4136g = true;
    }
}
