package com.baidu.swan.pms.utils;

import android.annotation.SuppressLint;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class AbiType {
    public static final /* synthetic */ AbiType[] $VALUES;
    public static /* synthetic */ Interceptable $ic = null;
    public static final AbiType ARM64_V8A;
    public static final AbiType ARMEABI;
    public static final AbiType ARMEABI_V7A;
    public static final boolean DEBUG = false;
    public static final String TAG = "AbiType";
    public static final AbiType X86;
    public static final AbiType X86_64;
    public static AbiType sCurrent;
    public static Map<String, AbiType> sIndex;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<AbiType> compatible;
    public final String id;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1995991040, "Lcom/baidu/swan/pms/utils/AbiType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1995991040, "Lcom/baidu/swan/pms/utils/AbiType;");
                return;
            }
        }
        AbiType abiType = new AbiType("ARMEABI", 0, "armeabi", new AbiType[0]);
        ARMEABI = abiType;
        AbiType abiType2 = new AbiType("ARMEABI_V7A", 1, PassBiometricUtil.CPU_TYPE_ARMEABI_V7A, abiType);
        ARMEABI_V7A = abiType2;
        ARM64_V8A = new AbiType("ARM64_V8A", 2, "arm64-v8a", abiType2, ARMEABI);
        AbiType abiType3 = new AbiType("X86", 3, "x86", ARMEABI_V7A, ARMEABI);
        X86 = abiType3;
        AbiType abiType4 = new AbiType("X86_64", 4, "x86_64", abiType3, ARMEABI_V7A, ARMEABI);
        X86_64 = abiType4;
        $VALUES = new AbiType[]{ARMEABI, ARMEABI_V7A, ARM64_V8A, X86, abiType4};
        sIndex = new HashMap();
    }

    public AbiType(String str, int i, String str2, AbiType... abiTypeArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2, abiTypeArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.compatible = arrayList;
        this.id = str2;
        arrayList.add(this);
        this.compatible.addAll(Arrays.asList(abiTypeArr));
    }

    @NonNull
    public static AbiType currentAbi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sCurrent == null) {
                sCurrent = findById(getRuntimeAbiTypeStr(), ARMEABI);
            }
            return sCurrent;
        }
        return (AbiType) invokeV.objValue;
    }

    public static AbiType findById(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? findById(str, null) : (AbiType) invokeL.objValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static String getRuntimeAbiTypeStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                return Build.CPU_ABI;
            }
            ApplicationInfo applicationInfo = AppRuntime.getAppContext().getApplicationInfo();
            try {
                Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
                declaredField.setAccessible(true);
                return (String) declaredField.get(applicationInfo);
            } catch (IllegalAccessException | NoSuchFieldException unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static AbiType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? (AbiType) Enum.valueOf(AbiType.class, str) : (AbiType) invokeL.objValue;
    }

    public static AbiType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? (AbiType[]) $VALUES.clone() : (AbiType[]) invokeV.objValue;
    }

    public boolean compat(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? compat(findById(str)) : invokeL.booleanValue;
    }

    public boolean compatBy(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            AbiType findById = findById(str);
            return findById != null && compatBy(findById);
        }
        return invokeL.booleanValue;
    }

    public List<AbiType> getCompatible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new ArrayList(this.compatible) : (List) invokeV.objValue;
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (AbiType abiType : this.compatible) {
                if (!z) {
                    sb.append(" ,");
                }
                sb.append(abiType.id);
                z = false;
            }
            return String.format("%s[%s]", super.toString(), this.id, sb);
        }
        return (String) invokeV.objValue;
    }

    public static AbiType findById(String str, @Nullable AbiType abiType) {
        InterceptResult invokeLL;
        AbiType[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, abiType)) == null) {
            if (sIndex.isEmpty()) {
                for (AbiType abiType2 : values()) {
                    if (abiType2 != null && !TextUtils.isEmpty(abiType2.id)) {
                        sIndex.put(abiType2.id, abiType2);
                    }
                }
            }
            AbiType abiType3 = sIndex.get(str);
            return abiType3 == null ? abiType : abiType3;
        }
        return (AbiType) invokeLL.objValue;
    }

    public boolean compat(AbiType abiType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, abiType)) == null) ? this.compatible.contains(abiType) : invokeL.booleanValue;
    }

    public boolean compatBy(AbiType abiType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, abiType)) == null) ? abiType.compat(this) : invokeL.booleanValue;
    }
}
