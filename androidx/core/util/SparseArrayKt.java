package androidx.core.util;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010(\n\u0002\b\u0006\u001a(\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b\u0005\u0010\u0006\u001a(\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0007\u0010\u0006\u001a(\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\t\u0010\n\u001aX\u0010\u0010\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000126\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0086\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a0\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a6\u0010\u0016\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a \u0010\u0018\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a \u0010\u001a\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b¢\u0006\u0004\b\u001a\u0010\u0019\u001a\u001d\u0010\u001c\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a4\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\b\u001f\u0010 \u001a+\u0010!\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b!\u0010\"\u001a-\u0010#\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b#\u0010$\u001a0\u0010%\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00028\u0000H\u0086\n¢\u0006\u0004\b%\u0010&\u001a#\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b(\u0010)\"$\u0010,\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00018Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"T", "Landroid/util/SparseArray;", "", "key", "", "contains", "(Landroid/util/SparseArray;I)Z", "containsKey", "value", "containsValue", "(Landroid/util/SparseArray;Ljava/lang/Object;)Z", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "action", "forEach", "(Landroid/util/SparseArray;Lkotlin/Function2;)V", "defaultValue", "getOrDefault", "(Landroid/util/SparseArray;ILjava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "getOrElse", "(Landroid/util/SparseArray;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "(Landroid/util/SparseArray;)Z", "isNotEmpty", "Lkotlin/collections/IntIterator;", "keyIterator", "(Landroid/util/SparseArray;)Lkotlin/collections/IntIterator;", "other", "plus", "(Landroid/util/SparseArray;Landroid/util/SparseArray;)Landroid/util/SparseArray;", "putAll", "(Landroid/util/SparseArray;Landroid/util/SparseArray;)V", "remove", "(Landroid/util/SparseArray;ILjava/lang/Object;)Z", "set", "(Landroid/util/SparseArray;ILjava/lang/Object;)V", "", "valueIterator", "(Landroid/util/SparseArray;)Ljava/util/Iterator;", "getSize", "(Landroid/util/SparseArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class SparseArrayKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T> boolean contains(SparseArray<T> sparseArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, sparseArray, i2)) == null) ? sparseArray.indexOfKey(i2) >= 0 : invokeLI.booleanValue;
    }

    public static final <T> boolean containsKey(SparseArray<T> sparseArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, sparseArray, i2)) == null) ? sparseArray.indexOfKey(i2) >= 0 : invokeLI.booleanValue;
    }

    public static final <T> boolean containsValue(SparseArray<T> sparseArray, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, sparseArray, t)) == null) ? sparseArray.indexOfValue(t) >= 0 : invokeLL.booleanValue;
    }

    public static final <T> void forEach(SparseArray<T> sparseArray, Function2<? super Integer, ? super T, Unit> function2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, sparseArray, function2) == null) {
            int size = sparseArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                function2.invoke(Integer.valueOf(sparseArray.keyAt(i2)), sparseArray.valueAt(i2));
            }
        }
    }

    public static final <T> T getOrDefault(SparseArray<T> sparseArray, int i2, T t) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, sparseArray, i2, t)) == null) {
            T t2 = sparseArray.get(i2);
            return t2 != null ? t2 : t;
        }
        return (T) invokeLIL.objValue;
    }

    public static final <T> T getOrElse(SparseArray<T> sparseArray, int i2, Function0<? extends T> function0) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(AdIconUtil.AD_TEXT_ID, null, sparseArray, i2, function0)) == null) {
            T t = sparseArray.get(i2);
            return t != null ? t : function0.invoke();
        }
        return (T) invokeLIL.objValue;
    }

    public static final <T> int getSize(SparseArray<T> sparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, sparseArray)) == null) ? sparseArray.size() : invokeL.intValue;
    }

    public static final <T> boolean isEmpty(SparseArray<T> sparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, sparseArray)) == null) ? sparseArray.size() == 0 : invokeL.booleanValue;
    }

    public static final <T> boolean isNotEmpty(SparseArray<T> sparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, sparseArray)) == null) ? sparseArray.size() != 0 : invokeL.booleanValue;
    }

    public static final <T> IntIterator keyIterator(final SparseArray<T> sparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, sparseArray)) == null) ? new IntIterator(sparseArray) { // from class: androidx.core.util.SparseArrayKt$keyIterator$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SparseArray $this_keyIterator;
            public int index;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sparseArray};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.$this_keyIterator = sparseArray;
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
                    SparseArray sparseArray2 = this.$this_keyIterator;
                    int i2 = this.index;
                    this.index = i2 + 1;
                    return sparseArray2.keyAt(i2);
                }
                return invokeV.intValue;
            }

            public final void setIndex(int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048579, this, i2) == null) {
                    this.index = i2;
                }
            }
        } : (IntIterator) invokeL.objValue;
    }

    public static final <T> SparseArray<T> plus(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, sparseArray, sparseArray2)) == null) {
            SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray.size() + sparseArray2.size());
            putAll(sparseArray3, sparseArray);
            putAll(sparseArray3, sparseArray2);
            return sparseArray3;
        }
        return (SparseArray) invokeLL.objValue;
    }

    public static final <T> void putAll(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, sparseArray, sparseArray2) == null) {
            int size = sparseArray2.size();
            for (int i2 = 0; i2 < size; i2++) {
                sparseArray.put(sparseArray2.keyAt(i2), sparseArray2.valueAt(i2));
            }
        }
    }

    public static final <T> boolean remove(SparseArray<T> sparseArray, int i2, T t) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65548, null, sparseArray, i2, t)) == null) {
            int indexOfKey = sparseArray.indexOfKey(i2);
            if (indexOfKey < 0 || !Intrinsics.areEqual(t, sparseArray.valueAt(indexOfKey))) {
                return false;
            }
            sparseArray.removeAt(indexOfKey);
            return true;
        }
        return invokeLIL.booleanValue;
    }

    public static final <T> void set(SparseArray<T> sparseArray, int i2, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65549, null, sparseArray, i2, t) == null) {
            sparseArray.put(i2, t);
        }
    }

    public static final <T> Iterator<T> valueIterator(SparseArray<T> sparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, sparseArray)) == null) ? new SparseArrayKt$valueIterator$1(sparseArray) : (Iterator) invokeL.objValue;
    }
}
