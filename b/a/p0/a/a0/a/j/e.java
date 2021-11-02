package b.a.p0.a.a0.a.j;

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
    public float f3810a;

    /* renamed from: b  reason: collision with root package name */
    public float f3811b;

    /* renamed from: c  reason: collision with root package name */
    public float f3812c;

    /* renamed from: d  reason: collision with root package name */
    public float f3813d;

    /* renamed from: e  reason: collision with root package name */
    public float f3814e;

    /* renamed from: f  reason: collision with root package name */
    public float f3815f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3816g;

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
        this.f3816g = false;
    }

    @Override // b.a.p0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) && this.f3816g) {
            bVar.j.cubicTo(this.f3810a, this.f3811b, this.f3812c, this.f3813d, this.f3814e, this.f3815f);
        }
    }

    @Override // b.a.p0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 5) {
            return;
        }
        this.f3810a = b.a.p0.a.v2.n0.g((float) jSONArray.optDouble(0));
        this.f3811b = b.a.p0.a.v2.n0.g((float) jSONArray.optDouble(1));
        this.f3812c = b.a.p0.a.v2.n0.g((float) jSONArray.optDouble(2));
        this.f3813d = b.a.p0.a.v2.n0.g((float) jSONArray.optDouble(3));
        this.f3814e = b.a.p0.a.v2.n0.g((float) jSONArray.optDouble(4));
        this.f3815f = b.a.p0.a.v2.n0.g((float) jSONArray.optDouble(5));
        this.f3816g = true;
    }
}
