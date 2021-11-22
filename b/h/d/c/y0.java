package b.h.d.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactHashSet;
import com.google.common.collect.CompactLinkedHashMap;
import com.google.common.collect.CompactLinkedHashSet;
import com.google.common.collect.MapMaker;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public final class y0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> T[] a(Object[] objArr, int i2, int i3, T[] tArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{objArr, Integer.valueOf(i2), Integer.valueOf(i3), tArr})) == null) ? (T[]) Arrays.copyOfRange(objArr, i2, i3, tArr.getClass()) : (T[]) ((Object[]) invokeCommon.objValue);
    }

    public static <T> T[] b(T[] tArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, tArr, i2)) == null) ? (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2)) : (T[]) ((Object[]) invokeLI.objValue);
    }

    public static <K, V> Map<K, V> c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? CompactHashMap.createWithExpectedSize(i2) : (Map) invokeI.objValue;
    }

    public static <E> Set<E> d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? CompactHashSet.createWithExpectedSize(i2) : (Set) invokeI.objValue;
    }

    public static <K, V> Map<K, V> e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? CompactLinkedHashMap.createWithExpectedSize(i2) : (Map) invokeI.objValue;
    }

    public static <E> Set<E> f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) ? CompactLinkedHashSet.createWithExpectedSize(i2) : (Set) invokeI.objValue;
    }

    public static <E> Set<E> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? CompactHashSet.create() : (Set) invokeV.objValue;
    }

    public static <K, V> Map<K, V> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? CompactHashMap.create() : (Map) invokeV.objValue;
    }

    public static MapMaker i(MapMaker mapMaker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, mapMaker)) == null) {
            mapMaker.l();
            return mapMaker;
        }
        return (MapMaker) invokeL.objValue;
    }
}
