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
/* loaded from: classes3.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static native long createHandle();

    public static native int destroyHandle(long j);

    public static native boolean getHandleEnableSync(long j);

    public static native long getHandleFaceHandle(long j);

    public static native byte[] getHandleImageData(long j);

    public static native int getHandleImageHeight(long j);

    public static native int getHandleImageWidth(long j);

    public static native boolean getHandleIsFront(long j);

    public static native float getHandleMaskBottom(long j);

    public static native byte[] getHandleMaskData(long j);

    public static native int getHandleMaskFormat(long j);

    public static native int getHandleMaskHeight(long j);

    public static native float getHandleMaskThreshold(long j);

    public static native float getHandleMaskTop(long j);

    public static native int getHandleMaskWidth(long j);

    public static native int getHandleOrientation(long j);

    public static native int getHandleReferenceCount(long j);

    public static native int getHandleReserveData(long j, ReserveHandleData reserveHandleData);

    public static native float[] getHandleResult(long j);

    public static native int getHandleResultLength(long j);

    public static native long getHandleTimeStamp(long j);

    public static native int getHandleType(long j);

    public static native int getVersion();

    public static native int increaseHandleReference(long j);

    public static native int setHandleFaceHandle(long j, long j2);

    public static native int setHandleInput(long j, int i, long j2, int i2, int i3, int i4, boolean z, int i5, boolean z2, ByteBuffer byteBuffer);

    public static native int setHandleMaskData(long j, int i, int i2, int i3, byte[] bArr);

    public static native int setHandleMaskThreshold(long j, float f2);

    public static native int setHandleReserveData(long j, ReserveHandleData reserveHandleData);

    public static native int setHandleResult(long j, int i, float[] fArr);
}
