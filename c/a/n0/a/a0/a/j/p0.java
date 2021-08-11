package c.a.n0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class p0 extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f4192a;

    /* renamed from: b  reason: collision with root package name */
    public float f4193b;

    /* renamed from: c  reason: collision with root package name */
    public float f4194c;

    /* renamed from: d  reason: collision with root package name */
    public float f4195d;

    /* renamed from: e  reason: collision with root package name */
    public int f4196e;

    /* renamed from: f  reason: collision with root package name */
    public int f4197f;

    public p0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.n0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) {
            if (bVar.d() == 0) {
                bVar.e(canvas.save());
            }
            Matrix matrix = new Matrix();
            matrix.setValues(new float[]{this.f4192a, this.f4194c, this.f4196e, this.f4193b, this.f4195d, this.f4197f, 0.0f, 0.0f, 1.0f});
            canvas.concat(matrix);
        }
    }

    @Override // c.a.n0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 6) {
                    this.f4192a = (float) jSONArray.optDouble(0);
                    this.f4193b = (float) jSONArray.optDouble(1);
                    this.f4194c = (float) jSONArray.optDouble(2);
                    this.f4195d = (float) jSONArray.optDouble(3);
                    this.f4196e = c.a.n0.a.v2.n0.g((float) jSONArray.optDouble(4));
                    this.f4197f = c.a.n0.a.v2.n0.g((float) jSONArray.optDouble(5));
                }
            } catch (Exception e2) {
                if (c.a.n0.a.k.f6803a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
