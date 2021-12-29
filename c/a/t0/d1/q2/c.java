package c.a.t0.d1.q2;

import androidx.core.view.InputDeviceCompat;
import c.a.t0.d1.q;
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
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsLoadMoreModel f16726b;

    /* renamed from: c  reason: collision with root package name */
    public final FrsSmartLoadMoreModel f16727c;

    /* renamed from: d  reason: collision with root package name */
    public final FrsModelController f16728d;

    /* renamed from: e  reason: collision with root package name */
    public final q f16729e;

    /* renamed from: f  reason: collision with root package name */
    public final b f16730f;

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.t0.d1.q2.c.b
        public void removeItem(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.a.f16729e == null || this.a.f16729e.a0() == null) {
                return;
            }
            List<c.a.d.n.e.n> data = this.a.f16729e.a0().getData();
            if (ListUtils.isEmpty(data) || this.a.f16729e.a0().getAdapter() == null || ((c.a.d.n.e.n) ListUtils.remove(data, i2)) == null) {
                return;
            }
            this.a.f16729e.a0().getAdapter().notifyItemRemoved(i2);
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void removeItem(int i2);
    }

    public c(FrsFragment frsFragment, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16730f = new a(this);
        if (frsFragment != null) {
            this.a = frsFragment;
            this.f16726b = new FrsLoadMoreModel(frsFragment, kVar);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, kVar);
            this.f16727c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.L(this.f16730f);
            this.f16726b.Q(this.f16730f);
            this.f16729e = frsFragment.getFrsView();
            FrsModelController modelController = frsFragment.getModelController();
            this.f16728d = modelController;
            this.f16727c.setSortType(modelController.a0());
            this.f16726b.setSortType(this.f16728d.a0());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            FrsModelController frsModelController = this.f16728d;
            if (frsModelController == null || frsModelController.t0()) {
                return false;
            }
            return this.f16726b.A(list);
        }
        return invokeL.booleanValue;
    }

    public ArrayList<c.a.d.n.e.n> c(boolean z, boolean z2, ArrayList<c.a.d.n.e.n> arrayList, c.a.t0.w3.j0.f fVar, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, fVar, Boolean.valueOf(z3)})) == null) ? d(z, z2, arrayList, fVar, false, z3) : (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<c.a.d.n.e.n> d(boolean z, boolean z2, ArrayList<c.a.d.n.e.n> arrayList, c.a.t0.w3.j0.f fVar, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, fVar, Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            if (this.f16728d == null) {
                return arrayList;
            }
            boolean s0 = this.a.getModelController().s0();
            if (this.f16728d.t0()) {
                return this.f16727c.y(z, s0, arrayList, z3, z4);
            }
            return this.f16726b.C(z, s0, z2, arrayList, fVar);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<c.a.d.n.e.n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f16728d.t0()) {
                return this.f16727c.z();
            }
            return this.f16728d.W();
        }
        return (ArrayList) invokeV.objValue;
    }

    public FrsSmartLoadMoreModel f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16727c : (FrsSmartLoadMoreModel) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsModelController frsModelController = this.f16728d;
            if (frsModelController == null) {
                return 1;
            }
            if (frsModelController.t0()) {
                return this.f16727c.getPn();
            }
            return this.f16726b.getPn();
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsModelController frsModelController = this.f16728d;
            if (frsModelController == null) {
                return -1;
            }
            if (frsModelController.t0()) {
                return this.f16727c.A();
            }
            return this.f16726b.E();
        }
        return invokeV.intValue;
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, frsViewData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (this.f16728d == null || this.f16729e == null || frsViewData == null) {
                return;
            }
            this.a.pullBeginTime = System.currentTimeMillis();
            if (this.f16728d.t0()) {
                if (this.f16727c.A() != 1 || this.f16728d.r0()) {
                    return;
                }
                this.f16727c.setSortType(this.f16728d.a0());
                this.f16727c.x();
                int pn = this.f16727c.getPn();
                this.f16727c.setPn(pn);
                this.f16728d.w0(pn + 1);
            } else if (this.f16728d.b0() == 1) {
                if (this.f16726b.isLoading || this.f16728d.r0()) {
                    return;
                }
                int pn2 = this.f16726b.getPn();
                if (this.f16726b.A(frsViewData.getThreadListIds())) {
                    this.f16726b.B();
                    this.f16726b.setSortType(this.f16728d.a0());
                    this.f16726b.M(c.a.d.f.m.b.g(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, this.f16728d.d0() != null ? c.a.t0.j3.a.e(this.f16728d.d0().getThreadList(), false) : "");
                } else if (this.f16726b.E() == 1) {
                    this.f16726b.B();
                    this.f16726b.setPn(pn2);
                    this.f16728d.w0(pn2 + 1);
                    FrsLoadMoreModel frsLoadMoreModel = this.f16726b;
                    frsLoadMoreModel.loadingDone = false;
                    frsLoadMoreModel.loadIndex = 0;
                }
            } else if (this.f16728d.u0()) {
            } else {
                this.f16728d.v0();
            }
        }
    }

    public void j(c.a.d.n.e.n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar) == null) || nVar == null) {
            return;
        }
        if (this.f16728d.t0()) {
            this.f16727c.G(nVar);
        } else {
            this.f16726b.K(nVar);
        }
    }

    public void k() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (frsModelController = this.f16728d) == null) {
            return;
        }
        if (frsModelController.t0()) {
            this.f16727c.H();
        } else {
            this.f16726b.N();
        }
    }

    public void l(c.a.t0.f1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.f16726b.O(aVar);
            this.f16727c.K(aVar);
        }
    }

    public void m(int i2) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (frsModelController = this.f16728d) == null) {
            return;
        }
        if (frsModelController.t0()) {
            this.f16727c.setHasMore(i2);
        } else {
            this.f16726b.setHasMore(i2);
        }
    }

    public void n(int i2) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (frsModelController = this.f16728d) == null) {
            return;
        }
        if (frsModelController.t0()) {
            this.f16727c.setPn(i2);
        } else {
            this.f16726b.setPn(i2);
        }
    }
}
