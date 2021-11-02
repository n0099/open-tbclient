package b.a.p0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class j0 extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f3832a;

    /* renamed from: b  reason: collision with root package name */
    public float f3833b;

    /* renamed from: c  reason: collision with root package name */
    public float f3834c;

    /* renamed from: d  reason: collision with root package name */
    public float f3835d;

    /* renamed from: e  reason: collision with root package name */
    public int f3836e;

    /* renamed from: f  reason: collision with root package name */
    public int f3837f;

    public j0() {
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

    @Override // b.a.p0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) {
            if (bVar.a() == 0) {
                bVar.b(canvas.save());
            } else {
                canvas.restoreToCount(bVar.a());
                bVar.b(canvas.save());
            }
            Matrix matrix = new Matrix();
            matrix.setValues(new float[]{this.f3832a, this.f3834c, this.f3836e, this.f3833b, this.f3835d, this.f3837f, 0.0f, 0.0f, 1.0f});
            canvas.concat(matrix);
        }
    }

    @Override // b.a.p0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 6) {
                    this.f3832a = (float) jSONArray.optDouble(0);
                    this.f3833b = (float) jSONArray.optDouble(1);
                    this.f3834c = (float) jSONArray.optDouble(2);
                    this.f3835d = (float) jSONArray.optDouble(3);
                    this.f3836e = b.a.p0.a.v2.n0.g((float) jSONArray.optDouble(4));
                    this.f3837f = b.a.p0.a.v2.n0.g((float) jSONArray.optDouble(5));
                }
            } catch (Exception e2) {
                if (b.a.p0.a.k.f6397a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
