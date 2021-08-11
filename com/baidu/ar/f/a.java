package com.baidu.ar.f;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class a implements SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public SensorManager rH;
    public Sensor vS;
    public InterfaceC1625a vT;
    public boolean vU;
    public LinkedList<Double> vV;
    public LinkedList<Float> vW;
    public LinkedList<Float> vX;
    public LinkedList<Float> vY;
    public int vZ;
    public double wa;
    public boolean wb;
    public boolean wc;

    /* renamed from: com.baidu.ar.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1625a {
        void b(float f2, float f3, float f4, float f5);

        void destroy();
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.vU = true;
        this.vV = new LinkedList<>();
        this.vW = new LinkedList<>();
        this.vX = new LinkedList<>();
        this.vY = new LinkedList<>();
        this.vZ = 10;
        this.wa = 0.0d;
        this.wb = true;
        this.wc = false;
        this.mContext = context;
    }

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.vU = z;
        }
    }

    public void a(InterfaceC1625a interfaceC1625a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1625a) == null) {
            this.vT = interfaceC1625a;
        }
    }

    public void a(LinkedList linkedList, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{linkedList, Double.valueOf(d2)}) == null) {
            if (linkedList.size() >= this.vZ) {
                linkedList.poll();
            }
            linkedList.offer(Double.valueOf(d2));
        }
    }

    public void a(LinkedList linkedList, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048579, this, linkedList, f2) == null) {
            if (linkedList.size() >= this.vZ) {
                linkedList.poll();
            }
            linkedList.offer(Float.valueOf(f2));
        }
    }

    public void b(float f2, float f3, float f4) {
        InterfaceC1625a interfaceC1625a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            double sqrt = Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
            if (sqrt > this.wa) {
                this.wa = sqrt;
            }
            com.baidu.ar.h.b.aQ("max acc is : " + this.wa);
            a(this.vV, sqrt);
            a((LinkedList) this.vW, Math.abs(f2));
            a((LinkedList) this.vX, Math.abs(f3));
            a((LinkedList) this.vY, Math.abs(f4));
            if (this.vV.size() == this.vZ) {
                float f5 = 0.0f;
                double d2 = 0.0d;
                float f6 = 0.0f;
                float f7 = 0.0f;
                for (int i2 = 0; i2 < this.vV.size(); i2++) {
                    d2 += this.vV.get(i2).doubleValue();
                    f5 += this.vW.get(i2).floatValue();
                    f6 += this.vX.get(i2).floatValue();
                    f7 += this.vY.get(i2).floatValue();
                }
                int i3 = this.vZ;
                double d3 = d2 / i3;
                float f8 = f5 / i3;
                float f9 = f6 / i3;
                float f10 = f7 / i3;
                if (this.wc) {
                    if (this.wb) {
                        if (d3 <= 10.0d) {
                            return;
                        }
                        this.wb = false;
                    } else if (d3 < 10.0d) {
                        this.wb = true;
                        interfaceC1625a = this.vT;
                        if (interfaceC1625a == null) {
                            return;
                        }
                        interfaceC1625a.b(f8, f9, f10, (float) this.wa);
                        this.wa = 0.0d;
                    }
                } else if (this.wb) {
                    if (d3 <= 5.0d) {
                        return;
                    }
                    this.wb = false;
                } else if (d3 < 5.0d) {
                    this.wb = true;
                    interfaceC1625a = this.vT;
                    if (interfaceC1625a == null) {
                        return;
                    }
                    interfaceC1625a.b(f8, f9, f10, (float) this.wa);
                    this.wa = 0.0d;
                }
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, sensor, i2) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, sensorEvent) == null) && this.vU) {
            float[] fArr = sensorEvent.values;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            b(f2, f3, f4);
            com.baidu.ar.h.b.aQ("acc  x : " + f2 + " , y : " + f3 + ", z : " + f4);
        }
    }

    public void start() {
        SensorManager sensorManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SensorManager sensorManager2 = (SensorManager) this.mContext.getSystemService("sensor");
            this.rH = sensorManager2;
            if (sensorManager2 != null) {
                Sensor defaultSensor = sensorManager2.getDefaultSensor(10);
                this.vS = defaultSensor;
                if (defaultSensor == null) {
                    this.vS = this.rH.getDefaultSensor(1);
                    this.wc = true;
                }
            }
            Sensor sensor = this.vS;
            if (sensor == null || (sensorManager = this.rH) == null) {
                return;
            }
            sensorManager.registerListener(this, sensor, 1);
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            InterfaceC1625a interfaceC1625a = this.vT;
            if (interfaceC1625a != null) {
                interfaceC1625a.destroy();
                this.vT = null;
            }
            SensorManager sensorManager = this.rH;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
                this.rH = null;
            }
            this.wc = false;
        }
    }
}
