package c.a.x.g.b;

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
/* loaded from: classes9.dex */
public final class a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Pools.Pool<ArrayList<T>> a;

    /* renamed from: b  reason: collision with root package name */
    public final SimpleArrayMap<T, ArrayList<T>> f27478b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<T> f27479c;

    /* renamed from: d  reason: collision with root package name */
    public final HashSet<T> f27480d;

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
        this.a = new Pools.SimplePool(10);
        this.f27478b = new SimpleArrayMap<>();
        this.f27479c = new ArrayList<>();
        this.f27480d = new HashSet<>();
    }

    public void a(@NonNull T t, @NonNull T t2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, t, t2) == null) && this.f27478b.containsKey(t) && this.f27478b.containsKey(t2)) {
            ArrayList<T> arrayList = this.f27478b.get(t);
            if (arrayList == null) {
                arrayList = f();
                this.f27478b.put(t, arrayList);
            }
            arrayList.add(t2);
        }
    }

    public void b(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || this.f27478b.containsKey(t)) {
            return;
        }
        this.f27478b.put(t, null);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int size = this.f27478b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ArrayList<T> valueAt = this.f27478b.valueAt(i2);
                if (valueAt != null) {
                    k(valueAt);
                }
            }
            this.f27478b.clear();
        }
    }

    public boolean d(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t)) == null) ? this.f27478b.containsKey(t) : invokeL.booleanValue;
    }

    public final void e(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, t, arrayList, hashSet) == null) || arrayList.contains(t) || hashSet.contains(t)) {
            return;
        }
        hashSet.add(t);
        ArrayList<T> arrayList2 = this.f27478b.get(t);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                e(arrayList2.get(i2), arrayList, hashSet);
            }
        }
        hashSet.remove(t);
        arrayList.add(t);
    }

    @NonNull
    public final ArrayList<T> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<T> acquire = this.a.acquire();
            return acquire == null ? new ArrayList<>() : acquire;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Nullable
    public List g(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, t)) == null) ? this.f27478b.get(t) : (List) invokeL.objValue;
    }

    @Nullable
    public List<T> h(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, t)) == null) {
            int size = this.f27478b.size();
            ArrayList arrayList = null;
            for (int i2 = 0; i2 < size; i2++) {
                ArrayList<T> valueAt = this.f27478b.valueAt(i2);
                if (valueAt != null && valueAt.contains(t)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(this.f27478b.keyAt(i2));
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
            this.f27479c.clear();
            this.f27480d.clear();
            int size = this.f27478b.size();
            for (int i2 = 0; i2 < size; i2++) {
                e(this.f27478b.keyAt(i2), this.f27479c, this.f27480d);
            }
            return this.f27479c;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean j(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, t)) == null) {
            int size = this.f27478b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ArrayList<T> valueAt = this.f27478b.valueAt(i2);
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
            this.a.release(arrayList);
        }
    }
}
