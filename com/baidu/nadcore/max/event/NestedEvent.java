package com.baidu.nadcore.max.event;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/baidu/nadcore/max/event/NestedEvent;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "MOVE_VIEW", "SCROLL_UP", "UP_SHOW_VIDEO", "UP_SHOW_WEB", "SCROLL_FINISH", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NestedEvent {
    public static final /* synthetic */ NestedEvent[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final NestedEvent MOVE_VIEW;
    public static final NestedEvent SCROLL_FINISH;
    public static final NestedEvent SCROLL_UP;
    public static final NestedEvent UP_SHOW_VIDEO;
    public static final NestedEvent UP_SHOW_WEB;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1337269253, "Lcom/baidu/nadcore/max/event/NestedEvent;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1337269253, "Lcom/baidu/nadcore/max/event/NestedEvent;");
                return;
            }
        }
        NestedEvent nestedEvent = new NestedEvent("MOVE_VIEW", 0);
        MOVE_VIEW = nestedEvent;
        NestedEvent nestedEvent2 = new NestedEvent("SCROLL_UP", 1);
        SCROLL_UP = nestedEvent2;
        NestedEvent nestedEvent3 = new NestedEvent("UP_SHOW_VIDEO", 2);
        UP_SHOW_VIDEO = nestedEvent3;
        NestedEvent nestedEvent4 = new NestedEvent("UP_SHOW_WEB", 3);
        UP_SHOW_WEB = nestedEvent4;
        NestedEvent nestedEvent5 = new NestedEvent("SCROLL_FINISH", 4);
        SCROLL_FINISH = nestedEvent5;
        $VALUES = new NestedEvent[]{nestedEvent, nestedEvent2, nestedEvent3, nestedEvent4, nestedEvent5};
    }

    public static NestedEvent valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NestedEvent) Enum.valueOf(NestedEvent.class, str) : (NestedEvent) invokeL.objValue;
    }

    public static NestedEvent[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NestedEvent[]) $VALUES.clone() : (NestedEvent[]) invokeV.objValue;
    }

    public NestedEvent(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
