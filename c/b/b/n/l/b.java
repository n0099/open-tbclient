package c.b.b.n.l;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b implements Iterable<a>, Comparator<a>, Comparable<b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public final c.b.b.q.a<a> f22550b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22551c;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22550b = new c.b.b.q.a<>();
        this.f22551c = true;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            j();
            int i = this.f22550b.f22717b;
            long j = this.a + 71;
            int i2 = 1;
            for (int i3 = 0; i3 < i; i3++) {
                i2 = (i2 * 7) & 65535;
                j += this.a * this.f22550b.get(i3).hashCode() * i2;
            }
            return (int) (j ^ (j >> 32));
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: c */
    public final int compare(a aVar, a aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, aVar2)) == null) ? (int) (aVar.a - aVar2.a) : invokeLL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: d */
    public int compareTo(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, bVar)) != null) {
            return invokeL.intValue;
        }
        if (bVar == this) {
            return 0;
        }
        long j = this.a;
        long j2 = bVar.a;
        if (j != j2) {
            return j < j2 ? -1 : 1;
        }
        j();
        bVar.j();
        int i = 0;
        while (true) {
            c.b.b.q.a<a> aVar = this.f22550b;
            if (i >= aVar.f22717b) {
                return 0;
            }
            int compareTo = aVar.get(i).compareTo(bVar.f22550b.get(i));
            if (compareTo != 0) {
                if (compareTo < 0) {
                    return -1;
                }
                return compareTo > 0 ? 1 : 0;
            }
            i++;
        }
    }

    public final void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.a = j | this.a;
        }
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj instanceof b) {
                if (obj == this) {
                    return true;
                }
                return h((b) obj, true);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean f(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) ? j != 0 && (this.a & j) == j : invokeJ.booleanValue;
    }

    public int g(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) != null) {
            return invokeJ.intValue;
        }
        if (!f(j)) {
            return -1;
        }
        int i = 0;
        while (true) {
            c.b.b.q.a<a> aVar = this.f22550b;
            if (i >= aVar.f22717b) {
                return -1;
            }
            if (aVar.get(i).a == j) {
                return i;
            }
            i++;
        }
    }

    public final boolean h(b bVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLZ = interceptable.invokeLZ(1048585, this, bVar, z)) != null) {
            return invokeLZ.booleanValue;
        }
        if (bVar == this) {
            return true;
        }
        if (bVar == null || this.a != bVar.a) {
            return false;
        }
        if (!z) {
            return true;
        }
        j();
        bVar.j();
        int i = 0;
        while (true) {
            c.b.b.q.a<a> aVar = this.f22550b;
            if (i >= aVar.f22717b) {
                return true;
            }
            if (!aVar.get(i).a(bVar.f22550b.get(i))) {
                return false;
            }
            i++;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? b() : invokeV.intValue;
    }

    public final void i(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            int g2 = g(aVar.a);
            if (g2 < 0) {
                e(aVar.a);
                this.f22550b.a(aVar);
                this.f22551c = false;
            } else {
                this.f22550b.l(g2, aVar);
            }
            j();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<a> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f22550b.iterator() : (Iterator) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.f22551c) {
            return;
        }
        this.f22550b.sort(this);
        this.f22551c = true;
    }
}
