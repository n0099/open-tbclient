package c.a.o0.a.a0.a.j;

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
    public float f4376a;

    /* renamed from: b  reason: collision with root package name */
    public float f4377b;

    /* renamed from: c  reason: collision with root package name */
    public float f4378c;

    /* renamed from: d  reason: collision with root package name */
    public float f4379d;

    /* renamed from: e  reason: collision with root package name */
    public float f4380e;

    /* renamed from: f  reason: collision with root package name */
    public float f4381f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4382g;

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
        this.f4382g = false;
    }

    @Override // c.a.o0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) && this.f4382g) {
            bVar.f4368j.cubicTo(this.f4376a, this.f4377b, this.f4378c, this.f4379d, this.f4380e, this.f4381f);
        }
    }

    @Override // c.a.o0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 5) {
            return;
        }
        this.f4376a = c.a.o0.a.v2.n0.g((float) jSONArray.optDouble(0));
        this.f4377b = c.a.o0.a.v2.n0.g((float) jSONArray.optDouble(1));
        this.f4378c = c.a.o0.a.v2.n0.g((float) jSONArray.optDouble(2));
        this.f4379d = c.a.o0.a.v2.n0.g((float) jSONArray.optDouble(3));
        this.f4380e = c.a.o0.a.v2.n0.g((float) jSONArray.optDouble(4));
        this.f4381f = c.a.o0.a.v2.n0.g((float) jSONArray.optDouble(5));
        this.f4382g = true;
    }
}
