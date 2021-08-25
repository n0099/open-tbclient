package c.a.o0.n.o;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.n.h.i;
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
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Set<a> f12033a;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.o0.n.h.e f12034a;

        /* renamed from: b  reason: collision with root package name */
        public PMSPkgStatus f12035b;

        public a(c.a.o0.n.h.e eVar, PMSPkgStatus pMSPkgStatus) {
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
            this.f12034a = eVar;
            this.f12035b = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (super.equals(obj)) {
                    return true;
                }
                if (obj != null && (obj instanceof a)) {
                    return this.f12034a.equals(((a) obj).f12034a);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Objects.hash(this.f12034a) : invokeV.intValue;
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
        this.f12033a = Collections.synchronizedSet(new HashSet());
    }

    public void a(c.a.o0.n.h.e eVar, PMSPkgStatus pMSPkgStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, eVar, pMSPkgStatus) == null) {
            this.f12033a.add(new a(eVar, pMSPkgStatus));
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (a aVar : this.f12033a) {
                if (aVar != null && (aVar.f12034a instanceof c.a.o0.n.h.b)) {
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
            for (a aVar : this.f12033a) {
                if (aVar != null && (aVar.f12034a instanceof c.a.o0.n.h.d)) {
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
            for (a aVar : this.f12033a) {
                if (aVar != null && (aVar.f12034a instanceof c.a.o0.n.h.f)) {
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
            for (a aVar : this.f12033a) {
                if (aVar != null && (aVar.f12034a instanceof i)) {
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
            for (a aVar : this.f12033a) {
                if (aVar != null && (aVar.f12034a instanceof c.a.o0.n.h.g)) {
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
                for (a aVar : this.f12033a) {
                    if (aVar != null && (aVar.f12034a instanceof c.a.o0.n.h.g) && aVar.f12035b == PMSPkgStatus.WAIT) {
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized Set<c.a.o0.n.h.e> h() {
        InterceptResult invokeV;
        HashSet hashSet;
        a[] aVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                hashSet = new HashSet();
                for (a aVar : (a[]) this.f12033a.toArray(new a[0])) {
                    if (aVar != null && aVar.f12034a != null) {
                        hashSet.add(aVar.f12034a);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f12033a.isEmpty() : invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
        r1.f12035b = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void j(c.a.o0.n.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            synchronized (this) {
                if (eVar == null) {
                    return;
                }
                Iterator<a> it = this.f12033a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next != null && next.f12034a.equals(eVar)) {
                        break;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
        r1.f12035b = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void k(c.a.o0.n.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            synchronized (this) {
                if (eVar == null) {
                    return;
                }
                Iterator<a> it = this.f12033a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next != null && next.f12034a.equals(eVar)) {
                        break;
                    }
                }
            }
        }
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f12033a.size() : invokeV.intValue;
    }
}
