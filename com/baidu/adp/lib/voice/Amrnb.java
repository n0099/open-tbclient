package com.baidu.adp.lib.voice;

import c.a.d.f.p.j;
import c.a.d.f.p.k;
import com.baidu.adp.lib.voice.AmrEncoder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class Amrnb {
    public static /* synthetic */ Interceptable $ic;
    public static boolean bLoadLibrary;
    public static Amrnb instance;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends k {
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

        @Override // c.a.d.f.p.k
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
        bLoadLibrary = j.d().i("amr-codec", 2, new a());
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

    public void decoderDecode(long j2, byte[] bArr, short[] sArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), bArr, sArr}) == null) && bLoadLibrary) {
            AmrDecoder.decode(j2, bArr, sArr);
        }
    }

    public void decoderDeinit(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) && bLoadLibrary) {
            AmrDecoder.exit(j2);
        }
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

    public int encoderEncode(int i2, short[] sArr, byte[] bArr) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, sArr, bArr)) == null) {
            if (bLoadLibrary) {
                return AmrEncoder.encode(AmrEncoder.Mode.MR59.ordinal(), sArr, bArr);
            }
            return 0;
        }
        return invokeILL.intValue;
    }

    public void encoderInit() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && bLoadLibrary) {
            AmrEncoder.init(0);
        }
    }
}
