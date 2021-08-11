package com.baidu.ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class k extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] sH;
    public float[] sI;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(SensorManager sensorManager) {
        super(sensorManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sensorManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((SensorManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sH = new float[3];
        this.sI = new float[3];
        this.sz.add(sensorManager.getDefaultSensor(9));
        this.sz.add(sensorManager.getDefaultSensor(2));
        this.sz.add(sensorManager.getDefaultSensor(4));
        this.sz.add(sensorManager.getDefaultSensor(11));
    }

    @Override // com.baidu.ar.imu.d, android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sensorEvent) == null) {
            if (sensorEvent.sensor.getType() == 11 || sensorEvent.sensor.getType() == 4) {
                super.onSensorChanged(sensorEvent);
            } else if (sensorEvent.sensor.getType() == 2) {
                this.sH = (float[]) sensorEvent.values.clone();
            } else if (sensorEvent.sensor.getType() == 9) {
                float[] fArr2 = (float[]) sensorEvent.values.clone();
                this.sI = fArr2;
                this.se = fArr2;
            }
            float[] fArr3 = this.sH;
            if (fArr3 == null || (fArr = this.sI) == null) {
                return;
            }
            SensorManager.getRotationMatrix(this.sA.matrix, new float[16], fArr, fArr3);
            this.sB.setRowMajor(this.sA.matrix);
        }
    }
}
