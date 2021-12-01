package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public MapCollections<K, V> mCollections;

    public ArrayMap() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private MapCollections<K, V> getCollection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.mCollections == null) {
                this.mCollections = new MapCollections<K, V>(this) { // from class: androidx.collection.ArrayMap.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ArrayMap this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // androidx.collection.MapCollections
                    public void colClear() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.clear();
                        }
                    }

                    @Override // androidx.collection.MapCollections
                    public Object colGetEntry(int i2, int i3) {
                        InterceptResult invokeII;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeII = interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) ? this.this$0.mArray[(i2 << 1) + i3] : invokeII.objValue;
                    }

                    @Override // androidx.collection.MapCollections
                    public Map<K, V> colGetMap() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0 : (Map) invokeV2.objValue;
                    }

                    @Override // androidx.collection.MapCollections
                    public int colGetSize() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048579, this)) == null) ? this.this$0.mSize : invokeV2.intValue;
                    }

                    @Override // androidx.collection.MapCollections
                    public int colIndexOfKey(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048580, this, obj)) == null) ? this.this$0.indexOfKey(obj) : invokeL.intValue;
                    }

                    @Override // androidx.collection.MapCollections
                    public int colIndexOfValue(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048581, this, obj)) == null) ? this.this$0.indexOfValue(obj) : invokeL.intValue;
                    }

                    @Override // androidx.collection.MapCollections
                    public void colPut(K k2, V v) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048582, this, k2, v) == null) {
                            this.this$0.put(k2, v);
                        }
                    }

                    @Override // androidx.collection.MapCollections
                    public void colRemoveAt(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048583, this, i2) == null) {
                            this.this$0.removeAt(i2);
                        }
                    }

                    @Override // androidx.collection.MapCollections
                    public V colSetValue(int i2, V v) {
                        InterceptResult invokeIL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeIL = interceptable2.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, v)) == null) ? this.this$0.setValueAt(i2, v) : (V) invokeIL.objValue;
                    }
                };
            }
            return this.mCollections;
        }
        return (MapCollections) invokeV.objValue;
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, collection)) == null) ? MapCollections.containsAllHelper(this, collection) : invokeL.booleanValue;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getCollection().getEntrySet() : (Set) invokeV.objValue;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getCollection().getKeySet() : (Set) invokeV.objValue;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, map) == null) {
            ensureCapacity(this.mSize + map.size());
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, collection)) == null) ? MapCollections.removeAllHelper(this, collection) : invokeL.booleanValue;
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, collection)) == null) ? MapCollections.retainAllHelper(this, collection) : invokeL.booleanValue;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getCollection().getValues() : (Collection) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArrayMap(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {simpleArrayMap};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((SimpleArrayMap) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }
}
