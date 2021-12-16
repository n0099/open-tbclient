package c.a.q0.a.a0.a.j;

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
    public float f4504b;

    /* renamed from: c  reason: collision with root package name */
    public float f4505c;

    /* renamed from: d  reason: collision with root package name */
    public float f4506d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4507e;

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
        this.f4507e = false;
    }

    @Override // c.a.q0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) && this.f4507e) {
            bVar.f4448j.quadTo(this.a, this.f4504b, this.f4505c, this.f4506d);
        }
    }

    @Override // c.a.q0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 3) {
            return;
        }
        this.a = c.a.q0.a.z2.n0.g((float) jSONArray.optDouble(0));
        this.f4504b = c.a.q0.a.z2.n0.g((float) jSONArray.optDouble(1));
        this.f4505c = c.a.q0.a.z2.n0.g((float) jSONArray.optDouble(2));
        this.f4506d = c.a.q0.a.z2.n0.g((float) jSONArray.optDouble(3));
        this.f4507e = true;
    }
}
