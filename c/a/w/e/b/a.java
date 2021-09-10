package c.a.w.e.b;

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
/* loaded from: classes4.dex */
public final class a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Pools.Pool<ArrayList<T>> f30497a;

    /* renamed from: b  reason: collision with root package name */
    public final SimpleArrayMap<T, ArrayList<T>> f30498b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<T> f30499c;

    /* renamed from: d  reason: collision with root package name */
    public final HashSet<T> f30500d;

    public a() {
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
        this.f30497a = new Pools.SimplePool(10);
        this.f30498b = new SimpleArrayMap<>();
        this.f30499c = new ArrayList<>();
        this.f30500d = new HashSet<>();
    }

    public void a(@NonNull T t, @NonNull T t2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, t, t2) == null) {
            if (this.f30498b.containsKey(t) && this.f30498b.containsKey(t2)) {
                ArrayList<T> arrayList = this.f30498b.get(t);
                if (arrayList == null) {
                    arrayList = f();
                    this.f30498b.put(t, arrayList);
                }
                arrayList.add(t2);
                return;
            }
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
    }

    public void b(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || this.f30498b.containsKey(t)) {
            return;
        }
        this.f30498b.put(t, null);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int size = this.f30498b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ArrayList<T> valueAt = this.f30498b.valueAt(i2);
                if (valueAt != null) {
                    k(valueAt);
                }
            }
            this.f30498b.clear();
        }
    }

    public boolean d(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t)) == null) ? this.f30498b.containsKey(t) : invokeL.booleanValue;
    }

    public final void e(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, t, arrayList, hashSet) == null) || arrayList.contains(t)) {
            return;
        }
        if (!hashSet.contains(t)) {
            hashSet.add(t);
            ArrayList<T> arrayList2 = this.f30498b.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    e(arrayList2.get(i2), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    @NonNull
    public final ArrayList<T> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<T> acquire = this.f30497a.acquire();
            return acquire == null ? new ArrayList<>() : acquire;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Nullable
    public List g(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, t)) == null) ? this.f30498b.get(t) : (List) invokeL.objValue;
    }

    @Nullable
    public List<T> h(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, t)) == null) {
            int size = this.f30498b.size();
            ArrayList arrayList = null;
            for (int i2 = 0; i2 < size; i2++) {
                ArrayList<T> valueAt = this.f30498b.valueAt(i2);
                if (valueAt != null && valueAt.contains(t)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(this.f30498b.keyAt(i2));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @NonNull
    public ArrayList<T> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            this.f30499c.clear();
            this.f30500d.clear();
            int size = this.f30498b.size();
            for (int i2 = 0; i2 < size; i2++) {
                e(this.f30498b.keyAt(i2), this.f30499c, this.f30500d);
            }
            return this.f30499c;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean j(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, t)) == null) {
            int size = this.f30498b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ArrayList<T> valueAt = this.f30498b.valueAt(i2);
                if (valueAt != null && valueAt.contains(t)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void k(@NonNull ArrayList<T> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) {
            arrayList.clear();
            this.f30497a.release(arrayList);
        }
    }
}
