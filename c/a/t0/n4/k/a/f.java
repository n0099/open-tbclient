package c.a.t0.n4.k.a;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCharacteristics;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Matrix a;

    /* renamed from: b  reason: collision with root package name */
    public RectF f19927b;

    public f(CameraCharacteristics cameraCharacteristics, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cameraCharacteristics, rectF};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (a(rectF)) {
            Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
            int intValue = num == null ? 90 : num.intValue();
            this.f19927b = new RectF(rect);
            Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
            this.a = b(num2 != null && num2.intValue() == 0, intValue, rectF);
            return;
        }
        throw new IllegalArgumentException("previewRect");
    }

    public final boolean a(RectF rectF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rectF)) == null) ? (rectF.width() == 0.0f || rectF.height() == 0.0f) ? false : true : invokeL.booleanValue;
    }

    public final Matrix b(boolean z, int i2, RectF rectF) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), rectF})) == null) {
            Matrix matrix = new Matrix();
            matrix.setScale(z ? -1.0f : 1.0f, 1.0f);
            matrix.postRotate(-i2);
            matrix.mapRect(rectF);
            Matrix matrix2 = new Matrix();
            matrix2.setRectToRect(rectF, this.f19927b, Matrix.ScaleToFit.FILL);
            matrix.setConcat(matrix2, matrix);
            return matrix;
        }
        return (Matrix) invokeCommon.objValue;
    }

    public RectF c(RectF rectF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rectF)) == null) {
            RectF rectF2 = new RectF();
            this.a.mapRect(rectF2, rectF);
            return rectF2;
        }
        return (RectF) invokeL.objValue;
    }
}
