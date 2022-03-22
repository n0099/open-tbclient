package c.a.p0.f1.h2;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.f1.q;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdMixFloor;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsLoadMoreModel f14004b;

    /* renamed from: c  reason: collision with root package name */
    public final FrsSmartLoadMoreModel f14005c;

    /* renamed from: d  reason: collision with root package name */
    public final FrsModelController f14006d;

    /* renamed from: e  reason: collision with root package name */
    public final q f14007e;

    /* renamed from: f  reason: collision with root package name */
    public final b f14008f;

    /* loaded from: classes2.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.p0.f1.h2.c.b
        public void removeItem(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.f14007e == null || this.a.f14007e.c0() == null) {
                return;
            }
            List<c.a.d.o.e.n> data = this.a.f14007e.c0().getData();
            if (ListUtils.isEmpty(data) || this.a.f14007e.c0().getAdapter() == null || ((c.a.d.o.e.n) ListUtils.remove(data, i)) == null) {
                return;
            }
            this.a.f14007e.c0().getAdapter().notifyItemRemoved(i);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14008f = new a(this);
        if (frsFragment != null) {
            this.a = frsFragment;
            this.f14004b = new FrsLoadMoreModel(frsFragment, kVar);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, kVar);
            this.f14005c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.O(this.f14008f);
            this.f14004b.U(this.f14008f);
            this.f14007e = frsFragment.x0();
            FrsModelController b0 = frsFragment.b0();
            this.f14006d = b0;
            this.f14005c.setSortType(b0.c0());
            this.f14004b.setSortType(this.f14006d.c0());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            FrsModelController frsModelController = this.f14006d;
            if (frsModelController == null || frsModelController.v0()) {
                return false;
            }
            return this.f14004b.C(list);
        }
        return invokeL.booleanValue;
    }

    public ArrayList<c.a.d.o.e.n> c(boolean z, boolean z2, ArrayList<c.a.d.o.e.n> arrayList, c.a.p0.a4.k0.f fVar, boolean z3, int i, List<AdMixFloor> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, fVar, Boolean.valueOf(z3), Integer.valueOf(i), list})) == null) ? d(z, z2, arrayList, fVar, false, z3, i, list) : (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<c.a.d.o.e.n> d(boolean z, boolean z2, ArrayList<c.a.d.o.e.n> arrayList, c.a.p0.a4.k0.f fVar, boolean z3, boolean z4, int i, List<AdMixFloor> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, fVar, Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i), list})) == null) {
            if (this.f14006d == null) {
                return arrayList;
            }
            boolean u0 = this.a.b0().u0();
            if (this.f14006d.v0()) {
                return this.f14005c.A(z, u0, arrayList, z3, z4, i, list);
            }
            return this.f14004b.F(z, u0, z2, arrayList, fVar, list, i);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<c.a.d.o.e.n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f14006d.v0()) {
                return this.f14005c.B();
            }
            return this.f14006d.Y();
        }
        return (ArrayList) invokeV.objValue;
    }

    public FrsSmartLoadMoreModel f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14005c : (FrsSmartLoadMoreModel) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsModelController frsModelController = this.f14006d;
            if (frsModelController == null) {
                return 1;
            }
            if (frsModelController.v0()) {
                return this.f14005c.getPn();
            }
            return this.f14004b.getPn();
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsModelController frsModelController = this.f14006d;
            if (frsModelController == null) {
                return -1;
            }
            if (frsModelController.v0()) {
                return this.f14005c.C();
            }
            return this.f14004b.H();
        }
        return invokeV.intValue;
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, frsViewData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (this.f14006d == null || this.f14007e == null || frsViewData == null) {
                return;
            }
            this.a.I = System.currentTimeMillis();
            if (this.f14006d.v0()) {
                if (this.f14005c.C() != 1 || this.f14006d.t0()) {
                    return;
                }
                this.f14005c.setSortType(this.f14006d.c0());
                this.f14005c.z();
                int pn = this.f14005c.getPn();
                this.f14005c.setPn(pn);
                this.f14006d.y0(pn + 1);
            } else if (this.f14006d.d0() == 1) {
                if (this.f14004b.isLoading || this.f14006d.t0()) {
                    return;
                }
                int pn2 = this.f14004b.getPn();
                if (this.f14004b.C(frsViewData.getThreadListIds())) {
                    this.f14004b.D();
                    this.f14004b.setSortType(this.f14006d.c0());
                    this.f14004b.Q(c.a.d.f.m.b.g(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, this.f14006d.f0() != null ? c.a.p0.l3.a.e(this.f14006d.f0().getThreadList(), false) : "");
                } else if (this.f14004b.H() == 1) {
                    this.f14004b.D();
                    this.f14004b.setPn(pn2);
                    this.f14006d.y0(pn2 + 1);
                    FrsLoadMoreModel frsLoadMoreModel = this.f14004b;
                    frsLoadMoreModel.loadingDone = false;
                    frsLoadMoreModel.loadIndex = 0;
                }
            } else if (this.f14006d.w0()) {
            } else {
                this.f14006d.x0();
            }
        }
    }

    public void j(c.a.d.o.e.n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar) == null) || nVar == null) {
            return;
        }
        if (this.f14006d.v0()) {
            this.f14005c.I(nVar);
        } else {
            this.f14004b.N(nVar);
        }
    }

    public void k(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (this.f14006d.v0()) {
                this.f14005c.J(str);
            } else {
                this.f14004b.O(str);
            }
        }
    }

    public void l() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (frsModelController = this.f14006d) == null) {
            return;
        }
        if (frsModelController.v0()) {
            this.f14005c.K();
        } else {
            this.f14004b.R();
        }
    }

    public void m(c.a.p0.h1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.f14004b.S(aVar);
            this.f14005c.N(aVar);
        }
    }

    public void n(int i) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || (frsModelController = this.f14006d) == null) {
            return;
        }
        if (frsModelController.v0()) {
            this.f14005c.setHasMore(i);
        } else {
            this.f14004b.setHasMore(i);
        }
    }

    public void o(int i) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || (frsModelController = this.f14006d) == null) {
            return;
        }
        if (frsModelController.v0()) {
            this.f14005c.setPn(i);
        } else {
            this.f14004b.setPn(i);
        }
    }
}
