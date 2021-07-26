package com.baidu.adp.lib.voice;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.h;
import d.a.d.e.p.i;
/* loaded from: classes.dex */
public class Amrnb {
    public static /* synthetic */ Interceptable $ic;
    public static boolean bLoadLibrary;
    public static Amrnb instance;
    public transient /* synthetic */ FieldHolder $fh;
    public int mDecoderContext;
    public int mEncoderContext;

    /* loaded from: classes.dex */
    public static class a extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.d.e.p.i
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                Amrnb.bLoadLibrary = z;
                if (z) {
                    try {
                        Amrnb.native_init();
                        Amrnb.bLoadLibrary = true;
                    } catch (Throwable th) {
                        Amrnb.bLoadLibrary = false;
                        BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                        bdStatisticsManager.error("so", "initAmrnb", "", -9104, th.getClass().getName() + " " + th.getMessage(), new Object[0]);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1499249048, "Lcom/baidu/adp/lib/voice/Amrnb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1499249048, "Lcom/baidu/adp/lib/voice/Amrnb;");
                return;
            }
        }
        boolean k = h.f().k("amrnb", 2, new a());
        bLoadLibrary = k;
        if (k) {
            try {
                native_init();
                bLoadLibrary = true;
            } catch (Throwable th) {
                bLoadLibrary = false;
                BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                bdStatisticsManager.error("so", "initAmrnb", "", -9104, th.getClass().getName() + " " + th.getMessage(), new Object[0]);
            }
        }
    }

    public Amrnb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mEncoderContext = 0;
        this.mDecoderContext = 0;
    }

    private native void _decoderDecode(byte[] bArr, short[] sArr);

    private native void _decoderDeinit();

    private native void _decoderInit();

    private native void _encoderDeinit();

    private native int _encoderEncode(int i2, short[] sArr, byte[] bArr);

    private native void _encoderInit();

    public static Amrnb getInstance() {
        InterceptResult invokeV;
        Amrnb amrnb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            Amrnb amrnb2 = instance;
            if (amrnb2 == null) {
                synchronized (Amrnb.class) {
                    if (instance == null) {
                        instance = new Amrnb();
                    }
                    amrnb = instance;
                }
                return amrnb;
            }
            return amrnb2;
        }
        return (Amrnb) invokeV.objValue;
    }

    private final native void native_finalize();

    public static final native void native_init();

    public void decoderDecode(byte[] bArr, short[] sArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, bArr, sArr) == null) && bLoadLibrary) {
            _decoderDecode(bArr, sArr);
        }
    }

    public void decoderDeinit() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && bLoadLibrary) {
            _decoderDeinit();
        }
    }

    public void decoderInit() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && bLoadLibrary) {
            _decoderInit();
        }
    }

    public void encoderDeinit() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && bLoadLibrary) {
            _encoderDeinit();
        }
    }

    public int encoderEncode(int i2, short[] sArr, byte[] bArr) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, sArr, bArr)) == null) {
            if (bLoadLibrary) {
                return _encoderEncode(i2, sArr, bArr);
            }
            return 0;
        }
        return invokeILL.intValue;
    }

    public void encoderInit() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && bLoadLibrary) {
            _encoderInit();
        }
    }

    public void finalize() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && bLoadLibrary) {
            native_finalize();
        }
    }
}
