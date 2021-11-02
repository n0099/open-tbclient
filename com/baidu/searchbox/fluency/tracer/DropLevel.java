package com.baidu.searchbox.fluency.tracer;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/fluency/tracer/DropLevel;", "Ljava/lang/Enum;", "", "index", "I", "getIndex", "()I", "<init>", "(Ljava/lang/String;II)V", "DROPPED_BEST", "DROPPED_NORMAL", "DROPPED_MIDDLE", "DROPPED_HIGH", "DROPPED_FROZEN", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class DropLevel {
    public static final /* synthetic */ DropLevel[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final DropLevel DROPPED_BEST;
    public static final DropLevel DROPPED_FROZEN;
    public static final DropLevel DROPPED_HIGH;
    public static final DropLevel DROPPED_MIDDLE;
    public static final DropLevel DROPPED_NORMAL;
    public transient /* synthetic */ FieldHolder $fh;
    public final int index;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1911859475, "Lcom/baidu/searchbox/fluency/tracer/DropLevel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1911859475, "Lcom/baidu/searchbox/fluency/tracer/DropLevel;");
                return;
            }
        }
        DropLevel dropLevel = new DropLevel("DROPPED_BEST", 0, 0);
        DROPPED_BEST = dropLevel;
        DropLevel dropLevel2 = new DropLevel("DROPPED_NORMAL", 1, 1);
        DROPPED_NORMAL = dropLevel2;
        DropLevel dropLevel3 = new DropLevel("DROPPED_MIDDLE", 2, 2);
        DROPPED_MIDDLE = dropLevel3;
        DropLevel dropLevel4 = new DropLevel("DROPPED_HIGH", 3, 3);
        DROPPED_HIGH = dropLevel4;
        DropLevel dropLevel5 = new DropLevel("DROPPED_FROZEN", 4, 4);
        DROPPED_FROZEN = dropLevel5;
        $VALUES = new DropLevel[]{dropLevel, dropLevel2, dropLevel3, dropLevel4, dropLevel5};
    }

    public DropLevel(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.index = i3;
    }

    public static DropLevel valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DropLevel) Enum.valueOf(DropLevel.class, str) : (DropLevel) invokeL.objValue;
    }

    public static DropLevel[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DropLevel[]) $VALUES.clone() : (DropLevel[]) invokeV.objValue;
    }

    public final int getIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.index : invokeV.intValue;
    }
}
