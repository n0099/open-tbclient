package b.a.p0.a.a0.a.j;

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
    public float f3976a;

    /* renamed from: b  reason: collision with root package name */
    public float f3977b;

    /* renamed from: c  reason: collision with root package name */
    public float f3978c;

    /* renamed from: d  reason: collision with root package name */
    public float f3979d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3980e;

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
        this.f3980e = false;
    }

    @Override // b.a.p0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) && this.f3980e) {
            bVar.j.quadTo(this.f3976a, this.f3977b, this.f3978c, this.f3979d);
        }
    }

    @Override // b.a.p0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 3) {
            return;
        }
        this.f3976a = b.a.p0.a.z2.n0.g((float) jSONArray.optDouble(0));
        this.f3977b = b.a.p0.a.z2.n0.g((float) jSONArray.optDouble(1));
        this.f3978c = b.a.p0.a.z2.n0.g((float) jSONArray.optDouble(2));
        this.f3979d = b.a.p0.a.z2.n0.g((float) jSONArray.optDouble(3));
        this.f3980e = true;
    }
}
