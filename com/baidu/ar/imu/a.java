package com.baidu.ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import com.baidu.ar.arplay.representation.Quaternion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a extends j {
    public static /* synthetic */ Interceptable $ic;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public final Quaternion rA;
    public int rB;
    public double rC;
    public long timestamp;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-531415224, "Lcom/baidu/ar/imu/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-531415224, "Lcom/baidu/ar/imu/a;");
                return;
            }
        }
        TAG = a.class.getSimpleName();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SensorManager sensorManager) {
        super(sensorManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sensorManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((SensorManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.rA = new Quaternion();
        this.rB = 0;
        this.rC = 0.0d;
        String str = TAG;
        com.baidu.ar.h.b.c(str, "sensorList size " + String.valueOf(this.sz.size()));
        if (this.sz.size() > 120) {
            this.sz.clear();
        }
        this.sz.add(sensorManager.getDefaultSensor(4));
    }

    private void eQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (this.sD) {
                j.a(this.sG.matrix, this.sA.matrix, this.sE.matrix);
                return;
            }
            float[] fArr = this.sA.matrix;
            float[] fArr2 = this.sE.matrix;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            Matrix.setIdentityM(this.sG.matrix, 0);
            this.sD = true;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, sensorEvent) == null) && sensorEvent.sensor.getType() == 4) {
            long j2 = this.timestamp;
            if (j2 != 0) {
                float f2 = ((float) (sensorEvent.timestamp - j2)) * 1.0E-9f;
                float[] fArr = sensorEvent.values;
                float f3 = fArr[0];
                float f4 = fArr[1];
                float f5 = fArr[2];
                double sqrt = Math.sqrt((f3 * f3) + (f4 * f4) + (f5 * f5));
                this.rC = sqrt;
                if (sqrt > 0.10000000149011612d) {
                    f3 = (float) (f3 / sqrt);
                    f4 = (float) (f4 / sqrt);
                    f5 = (float) (f5 / sqrt);
                }
                double d2 = (this.rC * f2) / 2.0d;
                double sin = Math.sin(d2);
                double cos = Math.cos(d2);
                this.rA.setX((float) (f3 * sin));
                this.rA.setY((float) (f4 * sin));
                this.rA.setZ((float) (sin * f5));
                this.rA.setW(-((float) cos));
                synchronized (this.sy) {
                    this.rA.multiplyByQuat(this.sB, this.sB);
                }
                Quaternion m33clone = this.sB.m33clone();
                m33clone.w(-m33clone.w());
                synchronized (this.sy) {
                    SensorManager.getRotationMatrixFromVector(this.sA.matrix, m33clone.toArray());
                }
            }
            this.timestamp = sensorEvent.timestamp;
            int i2 = this.rB + 1;
            this.rB = i2;
            if (i2 > 20) {
                eQ();
                setChanged();
                notifyObservers();
            }
        }
    }
}
