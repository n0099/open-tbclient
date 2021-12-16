package com.baidu.ar.face.attributes;

import android.content.res.AssetManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class FaceAttributesJni {
    public static /* synthetic */ Interceptable $ic;
    public static boolean nX;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(96265952, "Lcom/baidu/ar/face/attributes/FaceAttributesJni;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(96265952, "Lcom/baidu/ar/face/attributes/FaceAttributesJni;");
                return;
            }
        }
        try {
            com.baidu.ar.libloader.a.require("FaceAttributes");
            nX = true;
        } catch (Throwable th) {
            nX = false;
            th.printStackTrace();
        }
    }

    public FaceAttributesJni() {
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

    public static native int getVersion();

    public static native synchronized int initGenderDetect(String str);

    public static native synchronized int initGenderDetectFromAssets(String str);

    public static native synchronized int predictGenderDetect(ByteBuffer byteBuffer, int i2, int i3, float[] fArr, float[] fArr2);

    public static native synchronized int releaseGenderDetect();

    public static native int setAssetManager(AssetManager assetManager);
}
