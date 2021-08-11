package com.baidu.adp.framework;

import androidx.core.view.InputDeviceCompat;
import c.a.e.c.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import org.apache.http.HttpVersion;
/* loaded from: classes4.dex */
public class FrameHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class TYPE {
        public static final /* synthetic */ TYPE[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TYPE CUSTOM;
        public static final TYPE HTTP;
        public static final TYPE SOCKET;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1678047415, "Lcom/baidu/adp/framework/FrameHelper$TYPE;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1678047415, "Lcom/baidu/adp/framework/FrameHelper$TYPE;");
                    return;
                }
            }
            HTTP = new TYPE(HttpVersion.HTTP, 0);
            SOCKET = new TYPE("SOCKET", 1);
            TYPE type = new TYPE("CUSTOM", 2);
            CUSTOM = type;
            $VALUES = new TYPE[]{HTTP, SOCKET, type};
        }

        public TYPE(String str, int i2) {
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

        public static TYPE valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TYPE) Enum.valueOf(TYPE.class, str) : (TYPE) invokeL.objValue;
        }

        public static TYPE[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TYPE[]) $VALUES.clone() : (TYPE[]) invokeV.objValue;
        }
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) ? i2 >= 2000000 && i2 < 3000000 : invokeI.booleanValue;
    }

    public static boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? i2 >= 1000000 && i2 < 2000000 : invokeI.booleanValue;
    }

    public static boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 >= 0 && i2 < 1000000 : invokeI.booleanValue;
    }

    public static <T extends d> int d(LinkedList<T> linkedList, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, linkedList, i2)) == null) {
            int size = linkedList.size();
            int i3 = 0;
            while (i3 < size && linkedList.get(i3).getPriority() <= i2) {
                i3++;
            }
            return i3;
        }
        return invokeLI.intValue;
    }

    public static TYPE e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            if (i2 < 0 || i2 >= 1000000) {
                if (i2 < 1000000 || i2 >= 2000000) {
                    if (i2 >= 2000000 && i2 < 3000000) {
                        return TYPE.CUSTOM;
                    }
                    BdLog.e("cmd invalid:cmd=" + i2);
                    return null;
                }
                return TYPE.HTTP;
            }
            return TYPE.SOCKET;
        }
        return (TYPE) invokeI.objValue;
    }

    public static <T extends d> void f(LinkedList<T> linkedList, T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, linkedList, t) == null) || t == null || linkedList.contains(t)) {
            return;
        }
        linkedList.add(d(linkedList, t.getPriority()), t);
    }

    public static void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2) == null) {
        }
    }
}
