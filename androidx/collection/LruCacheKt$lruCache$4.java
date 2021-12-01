package androidx.collection;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0003\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J1\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00012\b\u0010\b\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001H\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/collection/LruCacheKt$lruCache$4", "Landroidx/collection/LruCache;", "key", "create", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "evicted", "oldValue", "newValue", "", "entryRemoved", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "value", "", "sizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "collection-ktx"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class LruCacheKt$lruCache$4 extends LruCache<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ Function1 $create;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int $maxSize;
    public final /* synthetic */ Function4 $onEntryRemoved;
    public final /* synthetic */ Function2 $sizeOf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(Function2 function2, Function1 function1, Function4 function4, int i2, int i3) {
        super(i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {function2, function1, function4, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.$sizeOf = function2;
        this.$create = function1;
        this.$onEntryRemoved = function4;
        this.$maxSize = i2;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [V, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [V, java.lang.Object] */
    @Override // androidx.collection.LruCache
    public V create(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k2)) == null) ? this.$create.invoke(k2) : invokeL.objValue;
    }

    @Override // androidx.collection.LruCache
    public void entryRemoved(boolean z, K k2, V v, V v2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), k2, v, v2}) == null) {
            this.$onEntryRemoved.invoke(Boolean.valueOf(z), k2, v, v2);
        }
    }

    @Override // androidx.collection.LruCache
    public int sizeOf(K k2, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, k2, v)) == null) ? ((Number) this.$sizeOf.invoke(k2, v)).intValue() : invokeLL.intValue;
    }
}
