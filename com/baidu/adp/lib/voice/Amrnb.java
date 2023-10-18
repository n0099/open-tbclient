package com.baidu.adp.lib.voice;

import com.baidu.adp.lib.voice.AmrEncoder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.yc;
import com.baidu.tieba.zc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class Amrnb {
    public static /* synthetic */ Interceptable $ic;
    public static boolean bLoadLibrary;
    public static Amrnb instance;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends zc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zc
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                Amrnb.bLoadLibrary = z;
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
        bLoadLibrary = yc.d().i("amr-codec", 2, new a());
    }

    public Amrnb() {
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

    public static Amrnb getInstance() {
        InterceptResult invokeV;
        Amrnb amrnb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
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

    public long decoderInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (bLoadLibrary) {
                return AmrDecoder.init();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public void encoderDeinit() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && bLoadLibrary) {
            AmrEncoder.exit();
        }
    }

    public void encoderInit() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && bLoadLibrary) {
            AmrEncoder.init(0);
        }
    }

    public void decoderDecode(long j, byte[] bArr, short[] sArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), bArr, sArr}) == null) && bLoadLibrary) {
            AmrDecoder.decode(j, bArr, sArr);
        }
    }

    public int encoderEncode(int i, short[] sArr, byte[] bArr) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, sArr, bArr)) == null) {
            if (bLoadLibrary) {
                return AmrEncoder.encode(AmrEncoder.Mode.MR59.ordinal(), sArr, bArr);
            }
            return 0;
        }
        return invokeILL.intValue;
    }

    public void decoderDeinit(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && bLoadLibrary) {
            AmrDecoder.exit(j);
        }
    }
}
