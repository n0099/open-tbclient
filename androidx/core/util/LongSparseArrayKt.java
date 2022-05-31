package androidx.core.util;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a(\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\n¢\u0006\u0004\b\u0005\u0010\u0006\u001a(\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b\u0007\u0010\u0006\u001a(\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\b\t\u0010\n\u001aX\u0010\u0010\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000126\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0087\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a0\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a6\u0010\u0016\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0087\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a \u0010\u0018\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a \u0010\u001a\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\b¢\u0006\u0004\b\u001a\u0010\u0019\u001a\u001f\u0010\u001c\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a4\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\u0002¢\u0006\u0004\b\u001f\u0010 \u001a-\u0010!\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b!\u0010\"\u001a/\u0010#\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00028\u0000H\u0007¢\u0006\u0004\b#\u0010$\u001a0\u0010%\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\b%\u0010&\u001a%\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b(\u0010)\"$\u0010-\u001a\u00020*\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00018Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006."}, d2 = {"T", "Landroid/util/LongSparseArray;", "", "key", "", "contains", "(Landroid/util/LongSparseArray;J)Z", "containsKey", "value", "containsValue", "(Landroid/util/LongSparseArray;Ljava/lang/Object;)Z", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "action", "forEach", "(Landroid/util/LongSparseArray;Lkotlin/Function2;)V", "defaultValue", "getOrDefault", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "getOrElse", "(Landroid/util/LongSparseArray;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "(Landroid/util/LongSparseArray;)Z", "isNotEmpty", "Lkotlin/collections/LongIterator;", "keyIterator", "(Landroid/util/LongSparseArray;)Lkotlin/collections/LongIterator;", ImageViewerConfig.FROM_OTHER, "plus", "(Landroid/util/LongSparseArray;Landroid/util/LongSparseArray;)Landroid/util/LongSparseArray;", "putAll", "(Landroid/util/LongSparseArray;Landroid/util/LongSparseArray;)V", "remove", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Z", "set", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)V", "", "valueIterator", "(Landroid/util/LongSparseArray;)Ljava/util/Iterator;", "", "getSize", "(Landroid/util/LongSparseArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class LongSparseArrayKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @RequiresApi(16)
    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65536, null, longSparseArray, j)) == null) ? longSparseArray.indexOfKey(j) >= 0 : invokeLJ.booleanValue;
    }

    @RequiresApi(16)
    public static final <T> boolean containsKey(LongSparseArray<T> longSparseArray, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, longSparseArray, j)) == null) ? longSparseArray.indexOfKey(j) >= 0 : invokeLJ.booleanValue;
    }

    @RequiresApi(16)
    public static final <T> boolean containsValue(LongSparseArray<T> longSparseArray, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, longSparseArray, t)) == null) ? longSparseArray.indexOfValue(t) >= 0 : invokeLL.booleanValue;
    }

    @RequiresApi(16)
    public static final <T> void forEach(LongSparseArray<T> longSparseArray, Function2<? super Long, ? super T, Unit> function2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, longSparseArray, function2) == null) {
            int size = longSparseArray.size();
            for (int i = 0; i < size; i++) {
                function2.invoke(Long.valueOf(longSparseArray.keyAt(i)), longSparseArray.valueAt(i));
            }
        }
    }

    @RequiresApi(16)
    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j, T t) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{longSparseArray, Long.valueOf(j), t})) == null) {
            T t2 = longSparseArray.get(j);
            return t2 != null ? t2 : t;
        }
        return (T) invokeCommon.objValue;
    }

    @RequiresApi(16)
    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j, Function0<? extends T> function0) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{longSparseArray, Long.valueOf(j), function0})) == null) {
            T t = longSparseArray.get(j);
            return t != null ? t : function0.invoke();
        }
        return (T) invokeCommon.objValue;
    }

    @RequiresApi(16)
    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, longSparseArray)) == null) ? longSparseArray.size() : invokeL.intValue;
    }

    @RequiresApi(16)
    public static final <T> boolean isEmpty(LongSparseArray<T> longSparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, longSparseArray)) == null) ? longSparseArray.size() == 0 : invokeL.booleanValue;
    }

    @RequiresApi(16)
    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, longSparseArray)) == null) ? longSparseArray.size() != 0 : invokeL.booleanValue;
    }

    @RequiresApi(16)
    public static final <T> LongIterator keyIterator(final LongSparseArray<T> longSparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, longSparseArray)) == null) ? new LongIterator(longSparseArray) { // from class: androidx.core.util.LongSparseArrayKt$keyIterator$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LongSparseArray $this_keyIterator;
            public int index;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {longSparseArray};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.$this_keyIterator = longSparseArray;
            }

            public final int getIndex() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.index : invokeV.intValue;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.index < this.$this_keyIterator.size() : invokeV.booleanValue;
            }

            @Override // kotlin.collections.LongIterator
            public long nextLong() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    LongSparseArray longSparseArray2 = this.$this_keyIterator;
                    int i = this.index;
                    this.index = i + 1;
                    return longSparseArray2.keyAt(i);
                }
                return invokeV.longValue;
            }

            public final void setIndex(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048579, this, i) == null) {
                    this.index = i;
                }
            }
        } : (LongIterator) invokeL.objValue;
    }

    @RequiresApi(16)
    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, longSparseArray, longSparseArray2)) == null) {
            LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray.size() + longSparseArray2.size());
            putAll(longSparseArray3, longSparseArray);
            putAll(longSparseArray3, longSparseArray2);
            return longSparseArray3;
        }
        return (LongSparseArray) invokeLL.objValue;
    }

    @RequiresApi(16)
    public static final <T> void putAll(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, longSparseArray, longSparseArray2) == null) {
            int size = longSparseArray2.size();
            for (int i = 0; i < size; i++) {
                longSparseArray.put(longSparseArray2.keyAt(i), longSparseArray2.valueAt(i));
            }
        }
    }

    @RequiresApi(16)
    public static final <T> boolean remove(LongSparseArray<T> longSparseArray, long j, T t) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{longSparseArray, Long.valueOf(j), t})) == null) {
            int indexOfKey = longSparseArray.indexOfKey(j);
            if (indexOfKey < 0 || !Intrinsics.areEqual(t, longSparseArray.valueAt(indexOfKey))) {
                return false;
            }
            longSparseArray.removeAt(indexOfKey);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @RequiresApi(16)
    public static final <T> void set(LongSparseArray<T> longSparseArray, long j, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{longSparseArray, Long.valueOf(j), t}) == null) {
            longSparseArray.put(j, t);
        }
    }

    @RequiresApi(16)
    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, longSparseArray)) == null) ? new LongSparseArrayKt$valueIterator$1(longSparseArray) : (Iterator) invokeL.objValue;
    }
}
