package com.baidu.ar.databasic;

import com.baidu.ar.libloader.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class AlgoHandleAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1186117602, "Lcom/baidu/ar/databasic/AlgoHandleAdapter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1186117602, "Lcom/baidu/ar/databasic/AlgoHandleAdapter;");
                return;
            }
        }
        a.require("ardatabasic");
    }

    public AlgoHandleAdapter() {
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

    public static native long createHandle();

    public static native int destroyHandle(long j2);

    public static native boolean getHandleEnableSync(long j2);

    public static native long getHandleFaceHandle(long j2);

    public static native byte[] getHandleImageData(long j2);

    public static native int getHandleImageHeight(long j2);

    public static native int getHandleImageWidth(long j2);

    public static native boolean getHandleIsFront(long j2);

    public static native float getHandleMaskBottom(long j2);

    public static native byte[] getHandleMaskData(long j2);

    public static native int getHandleMaskFormat(long j2);

    public static native int getHandleMaskHeight(long j2);

    public static native float getHandleMaskThreshold(long j2);

    public static native float getHandleMaskTop(long j2);

    public static native int getHandleMaskWidth(long j2);

    public static native int getHandleOrientation(long j2);

    public static native int getHandleReferenceCount(long j2);

    public static native int getHandleReserveData(long j2, ReserveHandleData reserveHandleData);

    public static native float[] getHandleResult(long j2);

    public static native int getHandleResultLength(long j2);

    public static native long getHandleTimeStamp(long j2);

    public static native int getHandleType(long j2);

    public static native int getVersion();

    public static native int increaseHandleReference(long j2);

    public static native int setHandleFaceHandle(long j2, long j3);

    public static native int setHandleInput(long j2, int i2, long j3, int i3, int i4, int i5, boolean z, int i6, boolean z2, ByteBuffer byteBuffer);

    public static native int setHandleMaskData(long j2, int i2, int i3, int i4, byte[] bArr);

    public static native int setHandleMaskThreshold(long j2, float f2);

    public static native int setHandleReserveData(long j2, ReserveHandleData reserveHandleData);

    public static native int setHandleResult(long j2, int i2, float[] fArr);
}
