package com.baidu.ar.child;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class CropAlgo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-983103499, "Lcom/baidu/ar/child/CropAlgo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-983103499, "Lcom/baidu/ar/child/CropAlgo;");
                return;
            }
        }
        com.baidu.ar.libloader.a.require("cropface");
        com.baidu.ar.libloader.a.require("childCropFace");
    }

    public CropAlgo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public native int nativeClear();

    public native byte[] nativeCorpFace(c cVar);

    public native float[] nativeGetFaceBoxList(long j);

    public native float[] nativeTrackingPoints(long j);

    public native long nativeWriteCameraDataToHandel(long j, byte[] bArr, int i2, int i3, float f2);

    public native long nativeWriteFaceDataToHandel(long j, byte[] bArr);

    public native void nativeWriteTypeToHandle(long j);
}
