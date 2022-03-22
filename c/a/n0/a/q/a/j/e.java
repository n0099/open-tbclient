package c.a.n0.a.q.a.j;

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
    public float f5906b;

    /* renamed from: c  reason: collision with root package name */
    public float f5907c;

    /* renamed from: d  reason: collision with root package name */
    public float f5908d;

    /* renamed from: e  reason: collision with root package name */
    public float f5909e;

    /* renamed from: f  reason: collision with root package name */
    public float f5910f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5911g;

    public e() {
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
        this.f5911g = false;
    }

    @Override // c.a.n0.a.q.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) && this.f5911g) {
            bVar.f5900f.cubicTo(this.a, this.f5906b, this.f5907c, this.f5908d, this.f5909e, this.f5910f);
        }
    }

    @Override // c.a.n0.a.q.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 5) {
            return;
        }
        this.a = c.a.n0.a.p2.n0.g((float) jSONArray.optDouble(0));
        this.f5906b = c.a.n0.a.p2.n0.g((float) jSONArray.optDouble(1));
        this.f5907c = c.a.n0.a.p2.n0.g((float) jSONArray.optDouble(2));
        this.f5908d = c.a.n0.a.p2.n0.g((float) jSONArray.optDouble(3));
        this.f5909e = c.a.n0.a.p2.n0.g((float) jSONArray.optDouble(4));
        this.f5910f = c.a.n0.a.p2.n0.g((float) jSONArray.optDouble(5));
        this.f5911g = true;
    }
}
