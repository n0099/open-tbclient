package b.a.p0.n.o;

import androidx.core.view.InputDeviceCompat;
import b.a.p0.n.h.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Set<a> f11249a;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.p0.n.h.e f11250a;

        /* renamed from: b  reason: collision with root package name */
        public PMSPkgStatus f11251b;

        public a(b.a.p0.n.h.e eVar, PMSPkgStatus pMSPkgStatus) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, pMSPkgStatus};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11250a = eVar;
            this.f11251b = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (super.equals(obj)) {
                    return true;
                }
                if (obj != null && (obj instanceof a)) {
                    return this.f11250a.equals(((a) obj).f11250a);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Objects.hash(this.f11250a) : invokeV.intValue;
        }
    }

    public f() {
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
        this.f11249a = Collections.synchronizedSet(new HashSet());
    }

    public void a(b.a.p0.n.h.e eVar, PMSPkgStatus pMSPkgStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, eVar, pMSPkgStatus) == null) {
            this.f11249a.add(new a(eVar, pMSPkgStatus));
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (a aVar : this.f11249a) {
                if (aVar != null && (aVar.f11250a instanceof b.a.p0.n.h.b)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            for (a aVar : this.f11249a) {
                if (aVar != null && (aVar.f11250a instanceof b.a.p0.n.h.d)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            for (a aVar : this.f11249a) {
                if (aVar != null && (aVar.f11250a instanceof b.a.p0.n.h.f)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            for (a aVar : this.f11249a) {
                if (aVar != null && (aVar.f11250a instanceof i)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            for (a aVar : this.f11249a) {
                if (aVar != null && (aVar.f11250a instanceof b.a.p0.n.h.g)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                for (a aVar : this.f11249a) {
                    if (aVar != null && (aVar.f11250a instanceof b.a.p0.n.h.g) && aVar.f11251b == PMSPkgStatus.WAIT) {
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized Set<b.a.p0.n.h.e> h() {
        InterceptResult invokeV;
        HashSet hashSet;
        a[] aVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                hashSet = new HashSet();
                for (a aVar : (a[]) this.f11249a.toArray(new a[0])) {
                    if (aVar != null && aVar.f11250a != null) {
                        hashSet.add(aVar.f11250a);
                    }
                }
            }
            return hashSet;
        }
        return (Set) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f11249a.isEmpty() : invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
        r1.f11251b = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void j(b.a.p0.n.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            synchronized (this) {
                if (eVar == null) {
                    return;
                }
                Iterator<a> it = this.f11249a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next != null && next.f11250a.equals(eVar)) {
                        break;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
        r1.f11251b = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void k(b.a.p0.n.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            synchronized (this) {
                if (eVar == null) {
                    return;
                }
                Iterator<a> it = this.f11249a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next != null && next.f11250a.equals(eVar)) {
                        break;
                    }
                }
            }
        }
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f11249a.size() : invokeV.intValue;
    }
}
