package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class PathInterpolatorApi14 implements Interpolator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float PRECISION = 0.002f;
    public transient /* synthetic */ FieldHolder $fh;
    public final float[] mX;
    public final float[] mY;

    public PathInterpolatorApi14(Path path) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {path};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i3 = ((int) (length / 0.002f)) + 1;
        this.mX = new float[i3];
        this.mY = new float[i3];
        float[] fArr = new float[2];
        for (int i4 = 0; i4 < i3; i4++) {
            pathMeasure.getPosTan((i4 * length) / (i3 - 1), fArr, null);
            this.mX[i4] = fArr[0];
            this.mY[i4] = fArr[1];
        }
    }

    public static Path createCubic(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            Path path = new Path();
            path.moveTo(0.0f, 0.0f);
            path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
            return path;
        }
        return (Path) invokeCommon.objValue;
    }

    public static Path createQuad(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            Path path = new Path();
            path.moveTo(0.0f, 0.0f);
            path.quadTo(f, f2, 1.0f, 1.0f);
            return path;
        }
        return (Path) invokeCommon.objValue;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
            if (f <= 0.0f) {
                return 0.0f;
            }
            if (f >= 1.0f) {
                return 1.0f;
            }
            int i = 0;
            int length = this.mX.length - 1;
            while (length - i > 1) {
                int i2 = (i + length) / 2;
                if (f < this.mX[i2]) {
                    length = i2;
                } else {
                    i = i2;
                }
            }
            float[] fArr = this.mX;
            float f2 = fArr[length] - fArr[i];
            if (f2 == 0.0f) {
                return this.mY[i];
            }
            float[] fArr2 = this.mY;
            float f3 = fArr2[i];
            return f3 + (((f - fArr[i]) / f2) * (fArr2[length] - f3));
        }
        return invokeF.floatValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PathInterpolatorApi14(float f, float f2) {
        this(createQuad(f, f2));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((Path) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PathInterpolatorApi14(float f, float f2, float f3, float f4) {
        this(createCubic(f, f2, f3, f4));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((Path) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
