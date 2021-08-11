package com.baidu.android.ddmlib.tools.perflib.vmtrace;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class TraceAction {
    public static final /* synthetic */ TraceAction[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final TraceAction METHOD_ENTER;
    public static final TraceAction METHOD_EXIT;
    public static final TraceAction METHOD_EXIT_UNROLL;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-998153903, "Lcom/baidu/android/ddmlib/tools/perflib/vmtrace/TraceAction;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-998153903, "Lcom/baidu/android/ddmlib/tools/perflib/vmtrace/TraceAction;");
                return;
            }
        }
        METHOD_ENTER = new TraceAction("METHOD_ENTER", 0);
        METHOD_EXIT = new TraceAction("METHOD_EXIT", 1);
        TraceAction traceAction = new TraceAction("METHOD_EXIT_UNROLL", 2);
        METHOD_EXIT_UNROLL = traceAction;
        $VALUES = new TraceAction[]{METHOD_ENTER, METHOD_EXIT, traceAction};
    }

    public TraceAction(String str, int i2) {
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

    public static TraceAction valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TraceAction) Enum.valueOf(TraceAction.class, str) : (TraceAction) invokeL.objValue;
    }

    public static TraceAction[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TraceAction[]) $VALUES.clone() : (TraceAction[]) invokeV.objValue;
    }
}
