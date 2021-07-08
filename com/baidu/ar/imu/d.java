package com.baidu.ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.representation.Quaternion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d extends j {
    public static /* synthetic */ Interceptable $ic;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public final Quaternion rA;
    public int rB;
    public double rC;
    public Quaternion rJ;
    public Quaternion rK;
    public boolean rL;
    public int rM;
    public long timestamp;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-531415131, "Lcom/baidu/ar/imu/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-531415131, "Lcom/baidu/ar/imu/d;");
                return;
            }
        }
        TAG = d.class.getSimpleName();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(SensorManager sensorManager) {
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
        this.rJ = new Quaternion();
        this.rK = new Quaternion();
        this.rC = 0.0d;
        this.rL = false;
        this.rB = 0;
        this.sz.add(sensorManager.getDefaultSensor(4));
        this.sz.add(sensorManager.getDefaultSensor(11));
    }

    private void a(Quaternion quaternion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, quaternion) == null) {
            Quaternion m13clone = quaternion.m13clone();
            m13clone.w(-m13clone.w());
            synchronized (this.sy) {
                this.sB.copyVec4(quaternion);
                SensorManager.getRotationMatrixFromVector(this.sA.matrix, m13clone.toArray());
                eQ();
                int i2 = this.rB + 1;
                this.rB = i2;
                if (i2 > 100) {
                    setChanged();
                } else if (!eR()) {
                    setChanged();
                }
                notifyObservers();
            }
        }
    }

    private boolean eR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return ((double) Math.abs(1.0f - this.sG.matrix[0])) < 0.001d && ((double) Math.abs(1.0f - this.sG.matrix[5])) < 0.001d && ((double) Math.abs(1.0f - this.sG.matrix[10])) < 0.001d && ((double) Math.abs(1.0f - this.sG.matrix[15])) < 0.001d;
        }
        return invokeV.booleanValue;
    }

    public static void getQuaternionFromVector(float[] fArr, float[] fArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, fArr, fArr2) == null) {
            if (fArr2.length >= 4) {
                fArr[0] = fArr2[3];
            } else {
                fArr[0] = ((1.0f - (fArr2[0] * fArr2[0])) - (fArr2[1] * fArr2[1])) - (fArr2[2] * fArr2[2]);
                fArr[0] = fArr[0] > 0.0f ? (float) Math.sqrt(fArr[0]) : 0.0f;
            }
            fArr[1] = fArr2[0];
            fArr[2] = fArr2[1];
            fArr[3] = fArr2[2];
        }
    }

    public void eQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.sD) {
                j.a(this.sF.matrix, this.sA.matrix, this.sE.matrix);
                j.b(this.sG.matrix, this.sF.matrix);
            } else if (j.a(this.sE.matrix, this.sA.matrix)) {
                this.sD = true;
                j.a(this.sF.matrix, this.sA.matrix, this.sE.matrix);
                j.b(this.sG.matrix, this.sF.matrix);
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) {
            if (sensorEvent.sensor.getType() == 11) {
                synchronized (this.sw) {
                    for (int i2 = 0; i2 < sensorEvent.values.length; i2++) {
                        if (Float.isNaN(sensorEvent.values[i2])) {
                            this.sx = Boolean.FALSE;
                            return;
                        }
                    }
                    float[] fArr = new float[4];
                    try {
                        SensorManager.getQuaternionFromVector(fArr, sensorEvent.values);
                    } catch (Exception unused) {
                        getQuaternionFromVector(fArr, sensorEvent.values);
                    }
                    this.rK.setXYZW(fArr[1], fArr[2], fArr[3], -fArr[0]);
                    if (this.rL) {
                        return;
                    }
                    this.rJ.set(this.rK);
                    this.rL = true;
                }
            } else if (sensorEvent.sensor.getType() == 4) {
                synchronized (this.sw) {
                    if (this.sx.booleanValue()) {
                        long j = this.timestamp;
                        if (j != 0) {
                            float f2 = ((float) (sensorEvent.timestamp - j)) * 1.0E-9f;
                            float[] fArr2 = sensorEvent.values;
                            float f3 = fArr2[0];
                            float f4 = fArr2[1];
                            float f5 = fArr2[2];
                            double sqrt = Math.sqrt((f3 * f3) + (f4 * f4) + (f5 * f5));
                            this.rC = sqrt;
                            if (sqrt > 0.10000000149011612d) {
                                f3 = (float) (f3 / sqrt);
                                f4 = (float) (f4 / sqrt);
                                f5 = (float) (f5 / sqrt);
                            } else {
                                this.rC = 0.0d;
                            }
                            double d2 = (this.rC * f2) / 2.0d;
                            double sin = Math.sin(d2);
                            double cos = Math.cos(d2);
                            this.rA.setX((float) (f3 * sin));
                            this.rA.setY((float) (f4 * sin));
                            this.rA.setZ((float) (sin * f5));
                            this.rA.setW(-((float) cos));
                            Quaternion quaternion = this.rA;
                            Quaternion quaternion2 = this.rJ;
                            quaternion.multiplyByQuat(quaternion2, quaternion2);
                            float dotProduct = this.rJ.dotProduct(this.rK);
                            if (Math.abs(dotProduct) < 0.0f) {
                                if (Math.abs(dotProduct) < 0.0f) {
                                    this.rM++;
                                }
                                a(this.rJ);
                            } else {
                                Quaternion quaternion3 = new Quaternion();
                                this.rJ.slerp(this.rK, quaternion3, (float) (this.rC * 0.009999999776482582d));
                                a(quaternion3);
                                this.rJ.copyVec4(quaternion3);
                                this.rM = 0;
                            }
                            if (this.rM > 60) {
                                com.baidu.ar.h.b.c(TAG, "Rotation VectorPanic counter is bigger than threshold; this indicates a Gyroscope failure. Panic reset is imminent.");
                                double d3 = this.rC;
                                if (d3 < 3.0d) {
                                    com.baidu.ar.h.b.c(TAG, "Rotation VectorPerforming Panic-reset. Resetting orientation to rotation-vector value.");
                                    a(this.rK);
                                    this.rJ.copyVec4(this.rK);
                                    this.rM = 0;
                                } else {
                                    String format = String.format("Panic reset delayed due to ongoing motion (user is still shaking the device). Gyroscope Velocity: %.2f > 3", Double.valueOf(d3));
                                    com.baidu.ar.h.b.c(TAG, "Rotation Vector" + format);
                                }
                            }
                        }
                        this.timestamp = sensorEvent.timestamp;
                    }
                }
            }
        }
    }
}
