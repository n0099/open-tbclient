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
/* loaded from: classes9.dex */
public class b implements Iterable<a>, Comparator<a>, Comparable<b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f27417e;

    /* renamed from: f  reason: collision with root package name */
    public final c.b.b.q.a<a> f27418f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27419g;

    public b() {
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
        this.f27418f = new c.b.b.q.a<>();
        this.f27419g = true;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            j();
            int i2 = this.f27418f.f27595f;
            long j2 = this.f27417e + 71;
            int i3 = 1;
            for (int i4 = 0; i4 < i2; i4++) {
                i3 = (i3 * 7) & 65535;
                j2 += this.f27417e * this.f27418f.get(i4).hashCode() * i3;
            }
            return (int) (j2 ^ (j2 >> 32));
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: c */
    public final int compare(a aVar, a aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, aVar2)) == null) ? (int) (aVar.f27415e - aVar2.f27415e) : invokeLL.intValue;
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
        long j2 = this.f27417e;
        long j3 = bVar.f27417e;
        if (j2 != j3) {
            return j2 < j3 ? -1 : 1;
        }
        j();
        bVar.j();
        int i2 = 0;
        while (true) {
            c.b.b.q.a<a> aVar = this.f27418f;
            if (i2 >= aVar.f27595f) {
                return 0;
            }
            int compareTo = aVar.get(i2).compareTo(bVar.f27418f.get(i2));
            if (compareTo != 0) {
                if (compareTo < 0) {
                    return -1;
                }
                return compareTo > 0 ? 1 : 0;
            }
            i2++;
        }
    }

    public final void e(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.f27417e = j2 | this.f27417e;
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

    public final boolean f(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) ? j2 != 0 && (this.f27417e & j2) == j2 : invokeJ.booleanValue;
    }

    public int g(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) != null) {
            return invokeJ.intValue;
        }
        if (!f(j2)) {
            return -1;
        }
        int i2 = 0;
        while (true) {
            c.b.b.q.a<a> aVar = this.f27418f;
            if (i2 >= aVar.f27595f) {
                return -1;
            }
            if (aVar.get(i2).f27415e == j2) {
                return i2;
            }
            i2++;
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
        if (bVar == null || this.f27417e != bVar.f27417e) {
            return false;
        }
        if (!z) {
            return true;
        }
        j();
        bVar.j();
        int i2 = 0;
        while (true) {
            c.b.b.q.a<a> aVar = this.f27418f;
            if (i2 >= aVar.f27595f) {
                return true;
            }
            if (!aVar.get(i2).a(bVar.f27418f.get(i2))) {
                return false;
            }
            i2++;
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
            int g2 = g(aVar.f27415e);
            if (g2 < 0) {
                e(aVar.f27415e);
                this.f27418f.a(aVar);
                this.f27419g = false;
            } else {
                this.f27418f.k(g2, aVar);
            }
            j();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<a> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f27418f.iterator() : (Iterator) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.f27419g) {
            return;
        }
        this.f27418f.sort(this);
        this.f27419g = true;
    }
}
