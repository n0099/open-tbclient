package c.a.t0.m0.c;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
/* loaded from: classes7.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<a> f19455b;

    /* renamed from: c  reason: collision with root package name */
    public int f19456c;

    public c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i2;
        this.f19455b = new LinkedHashSet();
    }

    public final a a(int i2, int i3) {
        InterceptResult invokeII;
        a aVar;
        Object obj;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            synchronized (this) {
                Iterator<T> it = this.f19455b.iterator();
                while (true) {
                    aVar = null;
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    a aVar2 = (a) obj;
                    if (aVar2.l() < i2 || aVar2.j() < i3 || aVar2.l() - i2 >= 5 || aVar2.j() - i3 >= 5) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
                a aVar3 = (a) obj;
                if (aVar3 != null) {
                    this.f19455b.remove(aVar3);
                    this.f19456c -= aVar3.k();
                    aVar = aVar3;
                }
            }
            return aVar;
        }
        return (a) invokeII.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                for (a aVar : this.f19455b) {
                    aVar.e();
                }
                this.f19455b.clear();
                this.f19456c = 0;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final boolean c(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
            if ((aVar == null ? null : aVar.g()) == null) {
                return true;
            }
            if (this.f19455b.contains(aVar)) {
                return false;
            }
            if (aVar.k() + this.f19456c > this.a) {
                BdLog.v("DrawingCache [Release][+] OOM Pool");
                return false;
            }
            synchronized (this) {
                this.f19455b.add(aVar);
                aVar.f();
                this.f19456c += aVar.k();
                Unit unit = Unit.INSTANCE;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
