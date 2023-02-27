package com.baidu.android.pushservice.ach.g;

import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    @Override // com.baidu.android.pushservice.ach.g.a
    public int a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-15939, this, str, Integer.valueOf(i)) : invokeLI.intValue;
    }

    @Override // com.baidu.android.pushservice.ach.g.a
    public Map a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? (Map) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15966, this, str) : (Map) invokeL.objValue;
    }

    @Override // com.baidu.android.pushservice.ach.g.a
    public boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15965, this, Integer.valueOf(i)) : invokeI.booleanValue;
    }

    @Override // com.baidu.android.pushservice.ach.g.a
    public boolean a(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15968, this, bVar) : invokeL.booleanValue;
    }

    @Override // com.baidu.android.pushservice.ach.g.a
    public boolean a(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, str, i, i2)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15967, this, str, Integer.valueOf(i), Integer.valueOf(i2)) : invokeLII.booleanValue;
    }

    @Override // com.baidu.android.pushservice.ach.g.a
    public boolean a(String str, String str2, List list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, list)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15962, this, str, str2, list) : invokeLLL.booleanValue;
    }

    @Override // com.baidu.android.pushservice.ach.g.a
    public boolean a(String str, boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15961, this, str, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)) : invokeCommon.booleanValue;
    }

    @Override // com.baidu.android.pushservice.ach.g.a
    public boolean a(String str, boolean z, String str2, int i, long j, String str3) throws RemoteException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), str2, Integer.valueOf(i), Long.valueOf(j), str3})) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15964, this, str, Boolean.valueOf(z), str2, Integer.valueOf(i), Long.valueOf(j), str3) : invokeCommon.booleanValue;
    }

    @Override // com.baidu.android.pushservice.ach.g.a
    public boolean a(String str, boolean z, String str2, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Boolean.valueOf(z), str2, Long.valueOf(j), Long.valueOf(j2)})) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15963, this, str, Boolean.valueOf(z), str2, Long.valueOf(j), Long.valueOf(j2)) : invokeCommon.booleanValue;
    }

    @Override // com.baidu.android.pushservice.ach.g.a
    public int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-15958, this, str) : invokeL.intValue;
    }

    @Override // com.baidu.android.pushservice.ach.g.a
    public boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15957, this, Integer.valueOf(i)) : invokeI.booleanValue;
    }

    @Override // com.baidu.android.pushservice.ach.g.a
    public boolean b(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bVar)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15960, this, bVar) : invokeL.booleanValue;
    }

    @Override // com.baidu.android.pushservice.ach.g.a
    public float c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.f(-15959, this, str) : invokeL.floatValue;
    }

    @Override // com.baidu.android.pushservice.ach.g.a
    public String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? (String) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15954, this, str) : (String) invokeL.objValue;
    }

    @Override // com.baidu.android.pushservice.ach.g.a
    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-15953, this, str) : invokeL.intValue;
    }

    @Override // com.baidu.android.pushservice.ach.g.a
    public int f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-15956, this, str) : invokeL.intValue;
    }

    @Override // com.baidu.android.pushservice.ach.g.a
    public boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15955, this, str) : invokeL.booleanValue;
    }
}
