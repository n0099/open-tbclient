package com.baidu.adp.framework;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.la;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import org.apache.http.HttpVersion;
/* loaded from: classes.dex */
public class FrameHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) ? i >= 2000000 && i < 3000000 : invokeI.booleanValue;
    }

    public static boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? i >= 1000000 && i < 2000000 : invokeI.booleanValue;
    }

    public static boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i >= 0 && i < 1000000 : invokeI.booleanValue;
    }

    public static void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, null, i) == null) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
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

        public TYPE(String str, int i) {
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

        public static TYPE valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (TYPE) Enum.valueOf(TYPE.class, str);
            }
            return (TYPE) invokeL.objValue;
        }

        public static TYPE[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (TYPE[]) $VALUES.clone();
            }
            return (TYPE[]) invokeV.objValue;
        }
    }

    public static <T extends la> int d(LinkedList<T> linkedList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, linkedList, i)) == null) {
            int size = linkedList.size();
            int i2 = 0;
            while (i2 < size && linkedList.get(i2).getPriority() <= i) {
                i2++;
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    public static <T extends la> void insert(LinkedList<T> linkedList, T t) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, linkedList, t) != null) || t == null || linkedList.contains(t)) {
            return;
        }
        linkedList.add(d(linkedList, t.getPriority()), t);
    }

    public static TYPE e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            if (i >= 0 && i < 1000000) {
                return TYPE.SOCKET;
            }
            if (i >= 1000000 && i < 2000000) {
                return TYPE.HTTP;
            }
            if (i >= 2000000 && i < 3000000) {
                return TYPE.CUSTOM;
            }
            BdLog.e("cmd invalid:cmd=" + i);
            return null;
        }
        return (TYPE) invokeI.objValue;
    }
}
