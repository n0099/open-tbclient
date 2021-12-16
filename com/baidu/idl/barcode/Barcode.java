package com.baidu.idl.barcode;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class Barcode {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int B_CODE128 = 16;
    public static final int B_CODE39 = 4;
    public static final int B_EAN = 1;
    public static final int B_EAN8 = 64;
    public static final int B_I25 = 8;
    public static final int B_PDF417 = 32;
    public static final int B_QRCODE = 2;
    public static final int B_UPCE = 128;
    public static final int CONF_BARCODE = 0;
    public static final int CONF_QRCODE = 2;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1603389494, "Lcom/baidu/idl/barcode/Barcode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1603389494, "Lcom/baidu/idl/barcode/Barcode;");
                return;
            }
        }
        System.loadLibrary("rabjni_V2_4_0");
    }

    public Barcode() {
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

    public static native BarcodeResult decodeByte(byte[] bArr, int i2, int i3, int i4);

    public static native BarcodeResult[] readBarcode(byte[] bArr, int i2, int i3, int i4, int i5);
}
