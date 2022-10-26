package androidx.core.util;

import android.util.SparseLongArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001c\u0010\t\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0087\b¢\u0006\u0004\b\t\u0010\n\u001aL\u0010\u0010\u001a\u00020\u000e*\u00020\u000026\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0087\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a$\u0010\u0013\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0007H\u0087\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0016\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H\u0087\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0014\u0010\u001a\u001a\u00020\u0003*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u001a\u0010\u0019\u001a\u0013\u0010\u001c\u001a\u00020\u001b*\u00020\u0000H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001f\u0010 \u001a\u001b\u0010!\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\u0007¢\u0006\u0004\b!\u0010\"\u001a#\u0010#\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b#\u0010$\u001a$\u0010%\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\b%\u0010&\u001a\u0013\u0010(\u001a\u00020'*\u00020\u0000H\u0007¢\u0006\u0004\b(\u0010)\"\u0018\u0010,\u001a\u00020\u0001*\u00020\u00008Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Landroid/util/SparseLongArray;", "", "key", "", "contains", "(Landroid/util/SparseLongArray;I)Z", "containsKey", "", "value", "containsValue", "(Landroid/util/SparseLongArray;J)Z", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "action", "forEach", "(Landroid/util/SparseLongArray;Lkotlin/Function2;)V", "defaultValue", "getOrDefault", "(Landroid/util/SparseLongArray;IJ)J", "Lkotlin/Function0;", "getOrElse", "(Landroid/util/SparseLongArray;ILkotlin/Function0;)J", "isEmpty", "(Landroid/util/SparseLongArray;)Z", "isNotEmpty", "Lkotlin/collections/IntIterator;", "keyIterator", "(Landroid/util/SparseLongArray;)Lkotlin/collections/IntIterator;", ImageViewerConfig.FROM_OTHER, "plus", "(Landroid/util/SparseLongArray;Landroid/util/SparseLongArray;)Landroid/util/SparseLongArray;", "putAll", "(Landroid/util/SparseLongArray;Landroid/util/SparseLongArray;)V", "remove", "(Landroid/util/SparseLongArray;IJ)Z", "set", "(Landroid/util/SparseLongArray;IJ)V", "Lkotlin/collections/LongIterator;", "valueIterator", "(Landroid/util/SparseLongArray;)Lkotlin/collections/LongIterator;", "getSize", "(Landroid/util/SparseLongArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class SparseLongArrayKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean contains(SparseLongArray sparseLongArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, sparseLongArray, i)) == null) {
            if (sparseLongArray.indexOfKey(i) >= 0) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static final boolean containsKey(SparseLongArray sparseLongArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, sparseLongArray, i)) == null) {
            if (sparseLongArray.indexOfKey(i) >= 0) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static final boolean containsValue(SparseLongArray sparseLongArray, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, sparseLongArray, j)) == null) {
            if (sparseLongArray.indexOfValue(j) >= 0) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final void forEach(SparseLongArray sparseLongArray, Function2<? super Integer, ? super Long, Unit> function2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, sparseLongArray, function2) == null) {
            int size = sparseLongArray.size();
            for (int i = 0; i < size; i++) {
                function2.invoke(Integer.valueOf(sparseLongArray.keyAt(i)), Long.valueOf(sparseLongArray.valueAt(i)));
            }
        }
    }

    public static final SparseLongArray plus(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, sparseLongArray, sparseLongArray2)) == null) {
            SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray.size() + sparseLongArray2.size());
            putAll(sparseLongArray3, sparseLongArray);
            putAll(sparseLongArray3, sparseLongArray2);
            return sparseLongArray3;
        }
        return (SparseLongArray) invokeLL.objValue;
    }

    public static final void putAll(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, sparseLongArray, sparseLongArray2) == null) {
            int size = sparseLongArray2.size();
            for (int i = 0; i < size; i++) {
                sparseLongArray.put(sparseLongArray2.keyAt(i), sparseLongArray2.valueAt(i));
            }
        }
    }

    public static final long getOrDefault(SparseLongArray sparseLongArray, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{sparseLongArray, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return sparseLongArray.get(i, j);
        }
        return invokeCommon.longValue;
    }

    public static final long getOrElse(SparseLongArray sparseLongArray, int i, Function0<Long> function0) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65541, null, sparseLongArray, i, function0)) == null) {
            int indexOfKey = sparseLongArray.indexOfKey(i);
            if (indexOfKey >= 0) {
                return sparseLongArray.valueAt(indexOfKey);
            }
            return ((Number) function0.invoke()).longValue();
        }
        return invokeLIL.longValue;
    }

    public static final void set(SparseLongArray sparseLongArray, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{sparseLongArray, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            sparseLongArray.put(i, j);
        }
    }

    public static final int getSize(SparseLongArray sparseLongArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, sparseLongArray)) == null) {
            return sparseLongArray.size();
        }
        return invokeL.intValue;
    }

    public static final boolean isEmpty(SparseLongArray sparseLongArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, sparseLongArray)) == null) {
            if (sparseLongArray.size() == 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final boolean isNotEmpty(SparseLongArray sparseLongArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, sparseLongArray)) == null) {
            if (sparseLongArray.size() != 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final IntIterator keyIterator(final SparseLongArray sparseLongArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, sparseLongArray)) == null) {
            return new IntIterator(sparseLongArray) { // from class: androidx.core.util.SparseLongArrayKt$keyIterator$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SparseLongArray $this_keyIterator;
                public int index;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {sparseLongArray};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$this_keyIterator = sparseLongArray;
                }

                public final void setIndex(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048579, this, i) == null) {
                        this.index = i;
                    }
                }

                public final int getIndex() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return this.index;
                    }
                    return invokeV.intValue;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        if (this.index < this.$this_keyIterator.size()) {
                            return true;
                        }
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // kotlin.collections.IntIterator
                public int nextInt() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        SparseLongArray sparseLongArray2 = this.$this_keyIterator;
                        int i = this.index;
                        this.index = i + 1;
                        return sparseLongArray2.keyAt(i);
                    }
                    return invokeV.intValue;
                }
            };
        }
        return (IntIterator) invokeL.objValue;
    }

    public static final LongIterator valueIterator(final SparseLongArray sparseLongArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, sparseLongArray)) == null) {
            return new LongIterator(sparseLongArray) { // from class: androidx.core.util.SparseLongArrayKt$valueIterator$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SparseLongArray $this_valueIterator;
                public int index;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {sparseLongArray};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$this_valueIterator = sparseLongArray;
                }

                public final void setIndex(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048579, this, i) == null) {
                        this.index = i;
                    }
                }

                public final int getIndex() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return this.index;
                    }
                    return invokeV.intValue;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        if (this.index < this.$this_valueIterator.size()) {
                            return true;
                        }
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // kotlin.collections.LongIterator
                public long nextLong() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        SparseLongArray sparseLongArray2 = this.$this_valueIterator;
                        int i = this.index;
                        this.index = i + 1;
                        return sparseLongArray2.valueAt(i);
                    }
                    return invokeV.longValue;
                }
            };
        }
        return (LongIterator) invokeL.objValue;
    }

    public static final boolean remove(SparseLongArray sparseLongArray, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{sparseLongArray, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            int indexOfKey = sparseLongArray.indexOfKey(i);
            if (indexOfKey >= 0 && j == sparseLongArray.valueAt(indexOfKey)) {
                sparseLongArray.removeAt(indexOfKey);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
