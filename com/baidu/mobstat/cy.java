package com.baidu.mobstat;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class cy implements cu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f42100a;

    /* renamed from: b  reason: collision with root package name */
    public TreeMap<String, String> f42101b;

    public cy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42101b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    @Override // com.baidu.mobstat.cu
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.f42101b.put(str, str2);
        }
    }

    @Override // com.baidu.mobstat.cx
    public Iterator<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Collections.unmodifiableSet(this.f42101b.keySet()).iterator() : (Iterator) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.cx
    public byte[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f42100a : (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.cx
    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            String str2 = this.f42101b.get(str);
            return str2 == null ? "" : str2;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.cx
    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.f42101b.containsKey(str) : invokeL.booleanValue;
    }
}
