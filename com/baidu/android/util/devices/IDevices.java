package com.baidu.android.util.devices;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
/* loaded from: classes9.dex */
public interface IDevices {
    public static final String ABI_MIPS = "mips";
    public static final String ABI_X86 = "x86";
    public static final int EM_386 = 3;
    public static final int EM_AARCH64 = 183;
    public static final int EM_ARM = 40;
    public static final int EM_MIPS = 8;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class ARCH {
        public static final /* synthetic */ ARCH[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ARCH ARM;
        public static final ARCH ARM64;
        public static final ARCH MIPS;
        public static final ARCH Unknown;
        public static final ARCH X86;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(706035974, "Lcom/baidu/android/util/devices/IDevices$ARCH;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(706035974, "Lcom/baidu/android/util/devices/IDevices$ARCH;");
                    return;
                }
            }
            Unknown = new ARCH("Unknown", 0);
            ARM = new ARCH(w0.j1, 1);
            X86 = new ARCH("X86", 2);
            MIPS = new ARCH("MIPS", 3);
            ARCH arch = new ARCH("ARM64", 4);
            ARM64 = arch;
            $VALUES = new ARCH[]{Unknown, ARM, X86, MIPS, arch};
        }

        public ARCH(String str, int i2) {
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

        public static ARCH valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ARCH) Enum.valueOf(ARCH.class, str) : (ARCH) invokeL.objValue;
        }

        public static ARCH[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ARCH[]) $VALUES.clone() : (ARCH[]) invokeV.objValue;
        }
    }
}
