package androidx.coordinatorlayout.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class DirectedAcyclicGraph<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SimpleArrayMap<T, ArrayList<T>> mGraph;
    public final Pools.Pool<ArrayList<T>> mListPool;
    public final ArrayList<T> mSortResult;
    public final HashSet<T> mSortTmpMarked;

    public DirectedAcyclicGraph() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mListPool = new Pools.SimplePool(10);
        this.mGraph = new SimpleArrayMap<>();
        this.mSortResult = new ArrayList<>();
        this.mSortTmpMarked = new HashSet<>();
    }

    private void dfs(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, this, t, arrayList, hashSet) == null) || arrayList.contains(t)) {
            return;
        }
        if (!hashSet.contains(t)) {
            hashSet.add(t);
            ArrayList<T> arrayList2 = this.mGraph.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    dfs(arrayList2.get(i2), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    @NonNull
    private ArrayList<T> getEmptyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList<T> acquire = this.mListPool.acquire();
            return acquire == null ? new ArrayList<>() : acquire;
        }
        return (ArrayList) invokeV.objValue;
    }

    private void poolList(@NonNull ArrayList<T> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, arrayList) == null) {
            arrayList.clear();
            this.mListPool.release(arrayList);
        }
    }

    public void addEdge(@NonNull T t, @NonNull T t2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, t, t2) == null) {
            if (this.mGraph.containsKey(t) && this.mGraph.containsKey(t2)) {
                ArrayList<T> arrayList = this.mGraph.get(t);
                if (arrayList == null) {
                    arrayList = getEmptyList();
                    this.mGraph.put(t, arrayList);
                }
                arrayList.add(t2);
                return;
            }
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
    }

    public void addNode(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || this.mGraph.containsKey(t)) {
            return;
        }
        this.mGraph.put(t, null);
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int size = this.mGraph.size();
            for (int i2 = 0; i2 < size; i2++) {
                ArrayList<T> valueAt = this.mGraph.valueAt(i2);
                if (valueAt != null) {
                    poolList(valueAt);
                }
            }
            this.mGraph.clear();
        }
    }

    public boolean contains(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t)) == null) ? this.mGraph.containsKey(t) : invokeL.booleanValue;
    }

    @Nullable
    public List getIncomingEdges(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, t)) == null) ? this.mGraph.get(t) : (List) invokeL.objValue;
    }

    @Nullable
    public List<T> getOutgoingEdges(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t)) == null) {
            int size = this.mGraph.size();
            ArrayList arrayList = null;
            for (int i2 = 0; i2 < size; i2++) {
                ArrayList<T> valueAt = this.mGraph.valueAt(i2);
                if (valueAt != null && valueAt.contains(t)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(this.mGraph.keyAt(i2));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @NonNull
    public ArrayList<T> getSortedList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.mSortResult.clear();
            this.mSortTmpMarked.clear();
            int size = this.mGraph.size();
            for (int i2 = 0; i2 < size; i2++) {
                dfs(this.mGraph.keyAt(i2), this.mSortResult, this.mSortTmpMarked);
            }
            return this.mSortResult;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean hasOutgoingEdges(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, t)) == null) {
            int size = this.mGraph.size();
            for (int i2 = 0; i2 < size; i2++) {
                ArrayList<T> valueAt = this.mGraph.valueAt(i2);
                if (valueAt != null && valueAt.contains(t)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mGraph.size() : invokeV.intValue;
    }
}
