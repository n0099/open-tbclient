package com.baidu.ar.imu;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.representation.Matrix;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Quaternion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
/* loaded from: classes3.dex */
public abstract class j extends Observable implements SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public final Matrixf4x4 sA;
    public final Quaternion sB;
    public SensorManager sC;
    public boolean sD;
    public final Matrixf4x4 sE;
    public final Matrixf4x4 sF;
    public final Matrixf4x4 sG;
    public float[] se;
    public Object sw;
    public Boolean sx;
    public final Object sy;
    public List<Sensor> sz;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-531414945, "Lcom/baidu/ar/imu/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-531414945, "Lcom/baidu/ar/imu/j;");
                return;
            }
        }
        TAG = j.class.getSimpleName();
    }

    public j(SensorManager sensorManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sensorManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.sw = new Object();
        this.sx = Boolean.TRUE;
        this.sy = new Object();
        this.sz = new ArrayList();
        this.sD = false;
        this.sC = sensorManager;
        this.sA = new Matrixf4x4();
        this.sB = new Quaternion();
        this.sE = new Matrixf4x4();
        this.sF = new Matrixf4x4();
        this.sG = new Matrixf4x4();
        String str = TAG;
        com.baidu.ar.h.b.c(str, "sensorList size " + String.valueOf(this.sz.size()));
        if (this.sz.size() > 120) {
            this.sz.clear();
        }
    }

    public static void a(float[] fArr, float[] fArr2, float[] fArr3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, fArr, fArr2, fArr3) == null) {
            float[] fArr4 = new float[16];
            Matrix.setIdentityM(fArr4, 0);
            Matrix.invertM(fArr4, 0, fArr3, 0);
            Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr4, 0);
        }
    }

    public static boolean a(float[] fArr, float[] fArr2) {
        InterceptResult invokeLL;
        float f2;
        float atan;
        float atan2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, fArr, fArr2)) == null) {
            float[] fArr3 = new float[4];
            float[] fArr4 = {1.0f, 0.0f, 0.0f, 0.0f};
            Matrix.multiplyMV(fArr3, fArr2, fArr4);
            if (Float.compare(fArr3[0], fArr4[0]) == 0 && Float.compare(fArr3[1], fArr4[1]) == 0 && Float.compare(fArr3[2], fArr4[2]) == 0) {
                return false;
            }
            int compare = Float.compare(fArr3[0], 0.0f);
            int compare2 = Float.compare(fArr3[1], 0.0f);
            if (compare != 0) {
                double d2 = fArr3[1] / fArr3[0];
                if (compare > 0 && compare2 >= 0) {
                    atan = (float) ((Math.atan(d2) * 180.0d) / 3.141592653589793d);
                } else if (compare <= 0 || compare2 >= 0) {
                    atan = ((float) ((Math.atan(d2) * 180.0d) / 3.141592653589793d)) + 180.0f;
                } else {
                    atan2 = ((float) ((Math.atan(d2) * 180.0d) / 3.141592653589793d)) + 360.0f;
                    f2 = atan2;
                }
                atan2 = atan;
                f2 = atan2;
            } else {
                f2 = (Float.compare(fArr3[1], 1.0f) != 0 && Float.compare(fArr3[1], -1.0f) == 0) ? 180.0f : 0.0f;
            }
            com.baidu.ar.h.b.c(TAG, "orientation: outputV[0] = " + fArr3[0] + ", outputV[1] = " + fArr3[1] + ", angleZ = " + f2);
            Matrix.setIdentityM(fArr, 0);
            Matrix.rotateM(fArr, 0, f2, 0.0f, 0.0f, 1.0f);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void b(float[] fArr, float[] fArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, fArr, fArr2) == null) {
            System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
        }
    }

    public boolean fc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            for (Sensor sensor : this.sz) {
                if (sensor == null) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public Matrixf4x4 fd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.sG : (Matrixf4x4) invokeV.objValue;
    }

    public float[] fe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.se : (float[]) invokeV.objValue;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, sensor, i) == null) {
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            deleteObservers();
            for (Sensor sensor : this.sz) {
                this.sC.unregisterListener(this, sensor);
            }
            this.sz.clear();
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (Sensor sensor : this.sz) {
                this.sC.registerListener(this, sensor, 1);
            }
        }
    }
}
