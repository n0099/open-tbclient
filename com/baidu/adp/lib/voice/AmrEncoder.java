package com.baidu.adp.lib.voice;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class AmrEncoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class Mode {
        public static final /* synthetic */ Mode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Mode MR102;
        public static final Mode MR122;
        public static final Mode MR475;
        public static final Mode MR515;
        public static final Mode MR59;
        public static final Mode MR67;
        public static final Mode MR74;
        public static final Mode MR795;
        public static final Mode MRDTX;
        public static final Mode N_MODES;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(322388097, "Lcom/baidu/adp/lib/voice/AmrEncoder$Mode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(322388097, "Lcom/baidu/adp/lib/voice/AmrEncoder$Mode;");
                    return;
                }
            }
            MR475 = new Mode("MR475", 0);
            MR515 = new Mode("MR515", 1);
            MR59 = new Mode("MR59", 2);
            MR67 = new Mode("MR67", 3);
            MR74 = new Mode("MR74", 4);
            MR795 = new Mode("MR795", 5);
            MR102 = new Mode("MR102", 6);
            MR122 = new Mode("MR122", 7);
            MRDTX = new Mode("MRDTX", 8);
            Mode mode = new Mode("N_MODES", 9);
            N_MODES = mode;
            $VALUES = new Mode[]{MR475, MR515, MR59, MR67, MR74, MR795, MR102, MR122, MRDTX, mode};
        }

        public Mode(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Mode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Mode) Enum.valueOf(Mode.class, str) : (Mode) invokeL.objValue;
        }

        public static Mode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Mode[]) $VALUES.clone() : (Mode[]) invokeV.objValue;
        }
    }

    public AmrEncoder() {
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

    public static native int encode(int i2, short[] sArr, byte[] bArr);

    public static native void exit();

    public static native void init(int i2);

    public static native void reset();
}
