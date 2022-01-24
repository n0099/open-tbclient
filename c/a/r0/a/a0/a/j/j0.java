package c.a.r0.a.a0.a.j;

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
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f5234b;

    /* renamed from: c  reason: collision with root package name */
    public float f5235c;

    /* renamed from: d  reason: collision with root package name */
    public float f5236d;

    /* renamed from: e  reason: collision with root package name */
    public int f5237e;

    /* renamed from: f  reason: collision with root package name */
    public int f5238f;

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

    @Override // c.a.r0.a.a0.a.j.a
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
            matrix.setValues(new float[]{this.a, this.f5235c, this.f5237e, this.f5234b, this.f5236d, this.f5238f, 0.0f, 0.0f, 1.0f});
            canvas.concat(matrix);
        }
    }

    @Override // c.a.r0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 6) {
                    this.a = (float) jSONArray.optDouble(0);
                    this.f5234b = (float) jSONArray.optDouble(1);
                    this.f5235c = (float) jSONArray.optDouble(2);
                    this.f5236d = (float) jSONArray.optDouble(3);
                    this.f5237e = c.a.r0.a.z2.n0.g((float) jSONArray.optDouble(4));
                    this.f5238f = c.a.r0.a.z2.n0.g((float) jSONArray.optDouble(5));
                }
            } catch (Exception e2) {
                if (c.a.r0.a.k.a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
