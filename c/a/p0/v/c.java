package c.a.p0.v;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.t0.a.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubs.analytics.SampleResult;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f19018b;

    public c() {
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
        this.f19018b = false;
        i();
    }

    public final int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i == 1) {
                return d(i);
            }
            int i2 = this.a;
            if (i2 == 1) {
                return c(i);
            }
            if (i2 == 0) {
                return d(i);
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public void b(ArrayList<Integer> arrayList, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, bVar) == null) || arrayList == null || bVar == null) {
            return;
        }
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            bVar.b(intValue, a(intValue));
        }
    }

    public final int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            String e2 = e(i);
            if (m.isEmpty(e2)) {
                return 0;
            }
            SampleResult a = c.a.t0.a.a.a(e2);
            return (a == SampleResult.T1 || a == SampleResult.T2 || a == SampleResult.T3 || a == SampleResult.T4 || a == SampleResult.T5) ? 1 : 0;
        }
        return invokeI.intValue;
    }

    public final int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            String f2 = f(i);
            return (!m.isEmpty(f2) && c.a.o0.r.j0.b.k().l(f2, 0) == 1) ? 1 : 0;
        }
        return invokeI.intValue;
    }

    public final String e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i == 2) {
                return "46";
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public final String f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i == 1) {
                return "key_card_show_type";
            }
            if (i == 2) {
                return "key_card_abstract_switch";
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f19018b : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                try {
                    b.a aVar = new b.a();
                    aVar.e(TbadkCoreApplication.getInst());
                    aVar.j(false);
                    aVar.n(30L);
                    aVar.m(1);
                    aVar.l(false);
                    aVar.o(15L);
                    aVar.k(1000);
                    c.a.t0.a.a.b(aVar.c());
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a = c.a.o0.r.j0.b.k().l("key_abtest_channel", 0);
            j();
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && !this.f19018b && this.a == 1) {
            boolean h2 = h();
            this.f19018b = h2;
            if (h2) {
                return;
            }
            this.a = 0;
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            if (i == 1 || i == 0) {
                this.a = i;
                c.a.o0.r.j0.b.k().w("key_abtest_channel", this.a);
                j();
            }
        }
    }
}
