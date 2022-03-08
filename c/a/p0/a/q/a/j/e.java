package c.a.p0.a.q.a.j;

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
    public float f7054b;

    /* renamed from: c  reason: collision with root package name */
    public float f7055c;

    /* renamed from: d  reason: collision with root package name */
    public float f7056d;

    /* renamed from: e  reason: collision with root package name */
    public float f7057e;

    /* renamed from: f  reason: collision with root package name */
    public float f7058f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7059g;

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
        this.f7059g = false;
    }

    @Override // c.a.p0.a.q.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) && this.f7059g) {
            bVar.f7050j.cubicTo(this.a, this.f7054b, this.f7055c, this.f7056d, this.f7057e, this.f7058f);
        }
    }

    @Override // c.a.p0.a.q.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 5) {
            return;
        }
        this.a = c.a.p0.a.p2.n0.g((float) jSONArray.optDouble(0));
        this.f7054b = c.a.p0.a.p2.n0.g((float) jSONArray.optDouble(1));
        this.f7055c = c.a.p0.a.p2.n0.g((float) jSONArray.optDouble(2));
        this.f7056d = c.a.p0.a.p2.n0.g((float) jSONArray.optDouble(3));
        this.f7057e = c.a.p0.a.p2.n0.g((float) jSONArray.optDouble(4));
        this.f7058f = c.a.p0.a.p2.n0.g((float) jSONArray.optDouble(5));
        this.f7059g = true;
    }
}
