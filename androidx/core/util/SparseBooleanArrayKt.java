package androidx.core.util;

import android.util.SparseBooleanArray;
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
import kotlin.collections.BooleanIterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001c\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\b¢\u0006\u0004\b\b\u0010\t\u001aL\u0010\u000f\u001a\u00020\r*\u00020\u000026\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\r0\nH\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a$\u0010\u0012\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0003H\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a*\u0010\u0015\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014H\u0086\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0014\u0010\u0017\u001a\u00020\u0003*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0014\u0010\u0019\u001a\u00020\u0003*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0019\u0010\u0018\u001a\u0011\u0010\u001b\u001a\u00020\u001a*\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001c\u0010\u001e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0019\u0010 \u001a\u00020\r*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000¢\u0006\u0004\b \u0010!\u001a!\u0010\"\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\"\u0010\u0013\u001a$\u0010#\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\n¢\u0006\u0004\b#\u0010$\u001a\u0011\u0010&\u001a\u00020%*\u00020\u0000¢\u0006\u0004\b&\u0010'\"\u0018\u0010*\u001a\u00020\u0001*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Landroid/util/SparseBooleanArray;", "", "key", "", "contains", "(Landroid/util/SparseBooleanArray;I)Z", "containsKey", "value", "containsValue", "(Landroid/util/SparseBooleanArray;Z)Z", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "action", "forEach", "(Landroid/util/SparseBooleanArray;Lkotlin/Function2;)V", "defaultValue", "getOrDefault", "(Landroid/util/SparseBooleanArray;IZ)Z", "Lkotlin/Function0;", "getOrElse", "(Landroid/util/SparseBooleanArray;ILkotlin/Function0;)Z", "isEmpty", "(Landroid/util/SparseBooleanArray;)Z", "isNotEmpty", "Lkotlin/collections/IntIterator;", "keyIterator", "(Landroid/util/SparseBooleanArray;)Lkotlin/collections/IntIterator;", ImageViewerConfig.FROM_OTHER, "plus", "(Landroid/util/SparseBooleanArray;Landroid/util/SparseBooleanArray;)Landroid/util/SparseBooleanArray;", "putAll", "(Landroid/util/SparseBooleanArray;Landroid/util/SparseBooleanArray;)V", "remove", "set", "(Landroid/util/SparseBooleanArray;IZ)V", "Lkotlin/collections/BooleanIterator;", "valueIterator", "(Landroid/util/SparseBooleanArray;)Lkotlin/collections/BooleanIterator;", "getSize", "(Landroid/util/SparseBooleanArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class SparseBooleanArrayKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean contains(SparseBooleanArray sparseBooleanArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, sparseBooleanArray, i)) == null) {
            if (sparseBooleanArray.indexOfKey(i) >= 0) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static final boolean containsKey(SparseBooleanArray sparseBooleanArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, sparseBooleanArray, i)) == null) {
            if (sparseBooleanArray.indexOfKey(i) >= 0) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static final boolean containsValue(SparseBooleanArray sparseBooleanArray, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, sparseBooleanArray, z)) == null) {
            if (sparseBooleanArray.indexOfValue(z) >= 0) {
                return true;
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public static final void forEach(SparseBooleanArray sparseBooleanArray, Function2<? super Integer, ? super Boolean, Unit> function2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, sparseBooleanArray, function2) == null) {
            int size = sparseBooleanArray.size();
            for (int i = 0; i < size; i++) {
                function2.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i)), Boolean.valueOf(sparseBooleanArray.valueAt(i)));
            }
        }
    }

    public static final SparseBooleanArray plus(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, sparseBooleanArray, sparseBooleanArray2)) == null) {
            SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray.size() + sparseBooleanArray2.size());
            putAll(sparseBooleanArray3, sparseBooleanArray);
            putAll(sparseBooleanArray3, sparseBooleanArray2);
            return sparseBooleanArray3;
        }
        return (SparseBooleanArray) invokeLL.objValue;
    }

    public static final void putAll(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, sparseBooleanArray, sparseBooleanArray2) == null) {
            int size = sparseBooleanArray2.size();
            for (int i = 0; i < size; i++) {
                sparseBooleanArray.put(sparseBooleanArray2.keyAt(i), sparseBooleanArray2.valueAt(i));
            }
        }
    }

    public static final boolean getOrDefault(SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{sparseBooleanArray, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            return sparseBooleanArray.get(i, z);
        }
        return invokeCommon.booleanValue;
    }

    public static final boolean getOrElse(SparseBooleanArray sparseBooleanArray, int i, Function0<Boolean> function0) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65541, null, sparseBooleanArray, i, function0)) == null) {
            int indexOfKey = sparseBooleanArray.indexOfKey(i);
            if (indexOfKey >= 0) {
                return sparseBooleanArray.valueAt(indexOfKey);
            }
            return function0.invoke().booleanValue();
        }
        return invokeLIL.booleanValue;
    }

    public static final void set(SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{sparseBooleanArray, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            sparseBooleanArray.put(i, z);
        }
    }

    public static final int getSize(SparseBooleanArray sparseBooleanArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, sparseBooleanArray)) == null) {
            return sparseBooleanArray.size();
        }
        return invokeL.intValue;
    }

    public static final boolean isEmpty(SparseBooleanArray sparseBooleanArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, sparseBooleanArray)) == null) {
            if (sparseBooleanArray.size() == 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final boolean isNotEmpty(SparseBooleanArray sparseBooleanArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, sparseBooleanArray)) == null) {
            if (sparseBooleanArray.size() != 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final IntIterator keyIterator(final SparseBooleanArray sparseBooleanArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, sparseBooleanArray)) == null) {
            return new IntIterator(sparseBooleanArray) { // from class: androidx.core.util.SparseBooleanArrayKt$keyIterator$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SparseBooleanArray $this_keyIterator;
                public int index;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {sparseBooleanArray};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$this_keyIterator = sparseBooleanArray;
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
                        SparseBooleanArray sparseBooleanArray2 = this.$this_keyIterator;
                        int i = this.index;
                        this.index = i + 1;
                        return sparseBooleanArray2.keyAt(i);
                    }
                    return invokeV.intValue;
                }
            };
        }
        return (IntIterator) invokeL.objValue;
    }

    public static final BooleanIterator valueIterator(final SparseBooleanArray sparseBooleanArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, sparseBooleanArray)) == null) {
            return new BooleanIterator(sparseBooleanArray) { // from class: androidx.core.util.SparseBooleanArrayKt$valueIterator$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SparseBooleanArray $this_valueIterator;
                public int index;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {sparseBooleanArray};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$this_valueIterator = sparseBooleanArray;
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

                @Override // kotlin.collections.BooleanIterator
                public boolean nextBoolean() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        SparseBooleanArray sparseBooleanArray2 = this.$this_valueIterator;
                        int i = this.index;
                        this.index = i + 1;
                        return sparseBooleanArray2.valueAt(i);
                    }
                    return invokeV.booleanValue;
                }
            };
        }
        return (BooleanIterator) invokeL.objValue;
    }

    public static final boolean remove(SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{sparseBooleanArray, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            int indexOfKey = sparseBooleanArray.indexOfKey(i);
            if (indexOfKey >= 0 && z == sparseBooleanArray.valueAt(indexOfKey)) {
                sparseBooleanArray.delete(i);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
