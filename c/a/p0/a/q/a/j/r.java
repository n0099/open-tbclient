package c.a.p0.a.q.a.j;

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
    public float f7105b;

    /* renamed from: c  reason: collision with root package name */
    public float f7106c;

    /* renamed from: d  reason: collision with root package name */
    public float f7107d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7108e;

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
        this.f7108e = false;
    }

    @Override // c.a.p0.a.q.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) && this.f7108e) {
            bVar.f7050j.quadTo(this.a, this.f7105b, this.f7106c, this.f7107d);
        }
    }

    @Override // c.a.p0.a.q.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 3) {
            return;
        }
        this.a = c.a.p0.a.p2.n0.g((float) jSONArray.optDouble(0));
        this.f7105b = c.a.p0.a.p2.n0.g((float) jSONArray.optDouble(1));
        this.f7106c = c.a.p0.a.p2.n0.g((float) jSONArray.optDouble(2));
        this.f7107d = c.a.p0.a.p2.n0.g((float) jSONArray.optDouble(3));
        this.f7108e = true;
    }
}
