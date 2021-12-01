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
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f4144b;

    /* renamed from: c  reason: collision with root package name */
    public float f4145c;

    /* renamed from: d  reason: collision with root package name */
    public float f4146d;

    /* renamed from: e  reason: collision with root package name */
    public float f4147e;

    /* renamed from: f  reason: collision with root package name */
    public float f4148f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4149g;

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
        this.f4149g = false;
    }

    @Override // c.a.p0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) && this.f4149g) {
            bVar.f4139j.cubicTo(this.a, this.f4144b, this.f4145c, this.f4146d, this.f4147e, this.f4148f);
        }
    }

    @Override // c.a.p0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 5) {
            return;
        }
        this.a = c.a.p0.a.z2.n0.g((float) jSONArray.optDouble(0));
        this.f4144b = c.a.p0.a.z2.n0.g((float) jSONArray.optDouble(1));
        this.f4145c = c.a.p0.a.z2.n0.g((float) jSONArray.optDouble(2));
        this.f4146d = c.a.p0.a.z2.n0.g((float) jSONArray.optDouble(3));
        this.f4147e = c.a.p0.a.z2.n0.g((float) jSONArray.optDouble(4));
        this.f4148f = c.a.p0.a.z2.n0.g((float) jSONArray.optDouble(5));
        this.f4149g = true;
    }
}
