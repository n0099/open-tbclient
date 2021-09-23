package c.a.p0.a.a0.a.j;

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
    public float f4412a;

    /* renamed from: b  reason: collision with root package name */
    public float f4413b;

    /* renamed from: c  reason: collision with root package name */
    public float f4414c;

    /* renamed from: d  reason: collision with root package name */
    public float f4415d;

    /* renamed from: e  reason: collision with root package name */
    public float f4416e;

    /* renamed from: f  reason: collision with root package name */
    public float f4417f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4418g;

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
        this.f4418g = false;
    }

    @Override // c.a.p0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) && this.f4418g) {
            bVar.f4404j.cubicTo(this.f4412a, this.f4413b, this.f4414c, this.f4415d, this.f4416e, this.f4417f);
        }
    }

    @Override // c.a.p0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 5) {
            return;
        }
        this.f4412a = c.a.p0.a.v2.n0.g((float) jSONArray.optDouble(0));
        this.f4413b = c.a.p0.a.v2.n0.g((float) jSONArray.optDouble(1));
        this.f4414c = c.a.p0.a.v2.n0.g((float) jSONArray.optDouble(2));
        this.f4415d = c.a.p0.a.v2.n0.g((float) jSONArray.optDouble(3));
        this.f4416e = c.a.p0.a.v2.n0.g((float) jSONArray.optDouble(4));
        this.f4417f = c.a.p0.a.v2.n0.g((float) jSONArray.optDouble(5));
        this.f4418g = true;
    }
}
