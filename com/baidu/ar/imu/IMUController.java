package com.baidu.ar.imu;

import android.content.Context;
import android.hardware.SensorManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public class IMUController implements c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMUController";
    public transient /* synthetic */ FieldHolder $fh;
    public SensorManager rH;
    public HashMap rI;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1927660028, "Lcom/baidu/ar/imu/IMUController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1927660028, "Lcom/baidu/ar/imu/IMUController;");
        }
    }

    public IMUController() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.ar.imu.c
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            HashMap hashMap = this.rI;
            if (hashMap != null) {
                for (h hVar : hashMap.values()) {
                    hVar.stop();
                }
                this.rI.clear();
                this.rI = null;
            }
            this.rH = null;
        }
    }

    @Override // com.baidu.ar.imu.c
    public void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) || context == null) {
            return;
        }
        this.rH = (SensorManager) context.getSystemService("sensor");
    }

    @Override // com.baidu.ar.imu.c
    public boolean start(i iVar, g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, iVar, gVar)) == null) {
            if (this.rH == null || iVar == null || gVar == null) {
                return false;
            }
            if (this.rI == null) {
                this.rI = new HashMap();
            }
            h hVar = (h) this.rI.get(gVar);
            if (hVar == null) {
                hVar = new h();
                this.rI.put(gVar, hVar);
            }
            return hVar.a(this.rH, iVar, gVar);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.ar.imu.c
    public void stop(g gVar) {
        HashMap hashMap;
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) || gVar == null || (hashMap = this.rI) == null || (hVar = (h) hashMap.remove(gVar)) == null) {
            return;
        }
        hVar.stop();
    }
}
