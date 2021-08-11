package c.i.d.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class u0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Object a(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, obj, i2)) == null) {
            if (obj != null) {
                return obj;
            }
            throw new NullPointerException("at index " + i2);
        }
        return invokeLI.objValue;
    }

    public static Object[] b(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, objArr)) == null) {
            c(objArr, objArr.length);
            return objArr;
        }
        return (Object[]) invokeL.objValue;
    }

    public static Object[] c(Object[] objArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, objArr, i2)) == null) {
            for (int i3 = 0; i3 < i2; i3++) {
                a(objArr[i3], i3);
            }
            return objArr;
        }
        return (Object[]) invokeLI.objValue;
    }

    public static <T> T[] d(T[] tArr, T[] tArr2, Class<T> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, tArr, tArr2, cls)) == null) {
            T[] tArr3 = (T[]) f(cls, tArr.length + tArr2.length);
            System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
            System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
            return tArr3;
        }
        return (T[]) ((Object[]) invokeLLL.objValue);
    }

    public static Object[] e(Iterable<?> iterable, Object[] objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, iterable, objArr)) == null) {
            Iterator<?> it = iterable.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                objArr[i2] = it.next();
                i2++;
            }
            return objArr;
        }
        return (Object[]) invokeLL.objValue;
    }

    public static <T> T[] f(Class<T> cls, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, cls, i2)) == null) ? (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i2)) : (T[]) ((Object[]) invokeLI.objValue);
    }

    public static <T> T[] g(T[] tArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, tArr, i2)) == null) ? (T[]) y0.b(tArr, i2) : (T[]) ((Object[]) invokeLI.objValue);
    }

    public static Object[] h(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, collection)) == null) {
            Object[] objArr = new Object[collection.size()];
            e(collection, objArr);
            return objArr;
        }
        return (Object[]) invokeL.objValue;
    }

    public static <T> T[] i(Collection<?> collection, T[] tArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, collection, tArr)) == null) {
            int size = collection.size();
            if (tArr.length < size) {
                tArr = (T[]) g(tArr, size);
            }
            e(collection, tArr);
            if (tArr.length > size) {
                tArr[size] = null;
            }
            return tArr;
        }
        return (T[]) ((Object[]) invokeLL.objValue);
    }

    public static <T> T[] j(Object[] objArr, int i2, int i3, T[] tArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{objArr, Integer.valueOf(i2), Integer.valueOf(i3), tArr})) == null) {
            c.i.d.a.n.v(i2, i2 + i3, objArr.length);
            if (tArr.length < i3) {
                tArr = (T[]) g(tArr, i3);
            } else if (tArr.length > i3) {
                tArr[i3] = null;
            }
            System.arraycopy(objArr, i2, tArr, 0, i3);
            return tArr;
        }
        return (T[]) ((Object[]) invokeCommon.objValue);
    }
}
