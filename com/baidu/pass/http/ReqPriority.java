package com.baidu.pass.http;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class ReqPriority implements com.baidu.pass.a {
    public static /* synthetic */ Interceptable $ic;
    public static final ReqPriority HIGH;
    public static final ReqPriority IMMEDIATE;
    public static final ReqPriority LOW;
    public static final ReqPriority NORMAL;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ ReqPriority[] f42803a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1660872592, "Lcom/baidu/pass/http/ReqPriority;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1660872592, "Lcom/baidu/pass/http/ReqPriority;");
                return;
            }
        }
        LOW = new ReqPriority("LOW", 0);
        NORMAL = new ReqPriority("NORMAL", 1);
        HIGH = new ReqPriority("HIGH", 2);
        ReqPriority reqPriority = new ReqPriority("IMMEDIATE", 3);
        IMMEDIATE = reqPriority;
        f42803a = new ReqPriority[]{LOW, NORMAL, HIGH, reqPriority};
    }

    public ReqPriority(String str, int i2) {
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

    public static ReqPriority valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ReqPriority) Enum.valueOf(ReqPriority.class, str) : (ReqPriority) invokeL.objValue;
    }

    public static ReqPriority[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ReqPriority[]) f42803a.clone() : (ReqPriority[]) invokeV.objValue;
    }
}
