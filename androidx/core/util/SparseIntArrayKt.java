package androidx.core.util;

import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001c\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\b\u0010\u0005\u001aL\u0010\u000e\u001a\u00020\f*\u00020\u000026\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\f0\tH\u0086\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a$\u0010\u0011\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a*\u0010\u0014\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0014\u0010\u0016\u001a\u00020\u0003*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0018\u0010\u0017\u001a\u0011\u0010\u001a\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001c\u0010\u001d\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0019\u0010\u001f\u001a\u00020\f*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000¢\u0006\u0004\b\u001f\u0010 \u001a!\u0010!\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b!\u0010\"\u001a$\u0010#\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b#\u0010$\u001a\u0011\u0010%\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b%\u0010\u001b\"\u0018\u0010(\u001a\u00020\u0001*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Landroid/util/SparseIntArray;", "", "key", "", "contains", "(Landroid/util/SparseIntArray;I)Z", "containsKey", "value", "containsValue", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "action", "forEach", "(Landroid/util/SparseIntArray;Lkotlin/Function2;)V", "defaultValue", "getOrDefault", "(Landroid/util/SparseIntArray;II)I", "Lkotlin/Function0;", "getOrElse", "(Landroid/util/SparseIntArray;ILkotlin/Function0;)I", "isEmpty", "(Landroid/util/SparseIntArray;)Z", "isNotEmpty", "Lkotlin/collections/IntIterator;", "keyIterator", "(Landroid/util/SparseIntArray;)Lkotlin/collections/IntIterator;", "other", "plus", "(Landroid/util/SparseIntArray;Landroid/util/SparseIntArray;)Landroid/util/SparseIntArray;", "putAll", "(Landroid/util/SparseIntArray;Landroid/util/SparseIntArray;)V", "remove", "(Landroid/util/SparseIntArray;II)Z", "set", "(Landroid/util/SparseIntArray;II)V", "valueIterator", "getSize", "(Landroid/util/SparseIntArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class SparseIntArrayKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean contains(SparseIntArray sparseIntArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, sparseIntArray, i)) == null) ? sparseIntArray.indexOfKey(i) >= 0 : invokeLI.booleanValue;
    }

    public static final boolean containsKey(SparseIntArray sparseIntArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, sparseIntArray, i)) == null) ? sparseIntArray.indexOfKey(i) >= 0 : invokeLI.booleanValue;
    }

    public static final boolean containsValue(SparseIntArray sparseIntArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, sparseIntArray, i)) == null) ? sparseIntArray.indexOfValue(i) >= 0 : invokeLI.booleanValue;
    }

    public static final void forEach(SparseIntArray sparseIntArray, Function2<? super Integer, ? super Integer, Unit> function2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, sparseIntArray, function2) == null) {
            int size = sparseIntArray.size();
            for (int i = 0; i < size; i++) {
                function2.invoke(Integer.valueOf(sparseIntArray.keyAt(i)), Integer.valueOf(sparseIntArray.valueAt(i)));
            }
        }
    }

    public static final int getOrDefault(SparseIntArray sparseIntArray, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, sparseIntArray, i, i2)) == null) ? sparseIntArray.get(i, i2) : invokeLII.intValue;
    }

    public static final int getOrElse(SparseIntArray sparseIntArray, int i, Function0<Integer> function0) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65541, null, sparseIntArray, i, function0)) == null) {
            int indexOfKey = sparseIntArray.indexOfKey(i);
            return indexOfKey >= 0 ? sparseIntArray.valueAt(indexOfKey) : function0.invoke().intValue();
        }
        return invokeLIL.intValue;
    }

    public static final int getSize(SparseIntArray sparseIntArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, sparseIntArray)) == null) ? sparseIntArray.size() : invokeL.intValue;
    }

    public static final boolean isEmpty(SparseIntArray sparseIntArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, sparseIntArray)) == null) ? sparseIntArray.size() == 0 : invokeL.booleanValue;
    }

    public static final boolean isNotEmpty(SparseIntArray sparseIntArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, sparseIntArray)) == null) ? sparseIntArray.size() != 0 : invokeL.booleanValue;
    }

    public static final IntIterator keyIterator(final SparseIntArray sparseIntArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, sparseIntArray)) == null) ? new IntIterator(sparseIntArray) { // from class: androidx.core.util.SparseIntArrayKt$keyIterator$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SparseIntArray $this_keyIterator;
            public int index;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sparseIntArray};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.$this_keyIterator = sparseIntArray;
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

            @Override // kotlin.collections.IntIterator
            public int nextInt() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    SparseIntArray sparseIntArray2 = this.$this_keyIterator;
                    int i = this.index;
                    this.index = i + 1;
                    return sparseIntArray2.keyAt(i);
                }
                return invokeV.intValue;
            }

            public final void setIndex(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048579, this, i) == null) {
                    this.index = i;
                }
            }
        } : (IntIterator) invokeL.objValue;
    }

    public static final SparseIntArray plus(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, sparseIntArray, sparseIntArray2)) == null) {
            SparseIntArray sparseIntArray3 = new SparseIntArray(sparseIntArray.size() + sparseIntArray2.size());
            putAll(sparseIntArray3, sparseIntArray);
            putAll(sparseIntArray3, sparseIntArray2);
            return sparseIntArray3;
        }
        return (SparseIntArray) invokeLL.objValue;
    }

    public static final void putAll(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, sparseIntArray, sparseIntArray2) == null) {
            int size = sparseIntArray2.size();
            for (int i = 0; i < size; i++) {
                sparseIntArray.put(sparseIntArray2.keyAt(i), sparseIntArray2.valueAt(i));
            }
        }
    }

    public static final boolean remove(SparseIntArray sparseIntArray, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65548, null, sparseIntArray, i, i2)) == null) {
            int indexOfKey = sparseIntArray.indexOfKey(i);
            if (indexOfKey < 0 || i2 != sparseIntArray.valueAt(indexOfKey)) {
                return false;
            }
            sparseIntArray.removeAt(indexOfKey);
            return true;
        }
        return invokeLII.booleanValue;
    }

    public static final void set(SparseIntArray sparseIntArray, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65549, null, sparseIntArray, i, i2) == null) {
            sparseIntArray.put(i, i2);
        }
    }

    public static final IntIterator valueIterator(final SparseIntArray sparseIntArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, sparseIntArray)) == null) ? new IntIterator(sparseIntArray) { // from class: androidx.core.util.SparseIntArrayKt$valueIterator$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SparseIntArray $this_valueIterator;
            public int index;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sparseIntArray};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.$this_valueIterator = sparseIntArray;
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
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.index < this.$this_valueIterator.size() : invokeV.booleanValue;
            }

            @Override // kotlin.collections.IntIterator
            public int nextInt() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    SparseIntArray sparseIntArray2 = this.$this_valueIterator;
                    int i = this.index;
                    this.index = i + 1;
                    return sparseIntArray2.valueAt(i);
                }
                return invokeV.intValue;
            }

            public final void setIndex(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048579, this, i) == null) {
                    this.index = i;
                }
            }
        } : (IntIterator) invokeL.objValue;
    }
}
