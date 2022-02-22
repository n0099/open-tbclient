package c.a.u0.e1.r2;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.u0.e1.q;
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
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsLoadMoreModel f16974b;

    /* renamed from: c  reason: collision with root package name */
    public final FrsSmartLoadMoreModel f16975c;

    /* renamed from: d  reason: collision with root package name */
    public final FrsModelController f16976d;

    /* renamed from: e  reason: collision with root package name */
    public final q f16977e;

    /* renamed from: f  reason: collision with root package name */
    public final b f16978f;

    /* loaded from: classes8.dex */
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

        @Override // c.a.u0.e1.r2.c.b
        public void removeItem(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.a.f16977e == null || this.a.f16977e.c0() == null) {
                return;
            }
            List<c.a.d.o.e.n> data = this.a.f16977e.c0().getData();
            if (ListUtils.isEmpty(data) || this.a.f16977e.c0().getAdapter() == null || ((c.a.d.o.e.n) ListUtils.remove(data, i2)) == null) {
                return;
            }
            this.a.f16977e.c0().getAdapter().notifyItemRemoved(i2);
        }
    }

    /* loaded from: classes8.dex */
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
        this.f16978f = new a(this);
        if (frsFragment != null) {
            this.a = frsFragment;
            this.f16974b = new FrsLoadMoreModel(frsFragment, kVar);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, kVar);
            this.f16975c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.M(this.f16978f);
            this.f16974b.S(this.f16978f);
            this.f16977e = frsFragment.getFrsView();
            FrsModelController modelController = frsFragment.getModelController();
            this.f16976d = modelController;
            this.f16975c.setSortType(modelController.a0());
            this.f16974b.setSortType(this.f16976d.a0());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            FrsModelController frsModelController = this.f16976d;
            if (frsModelController == null || frsModelController.t0()) {
                return false;
            }
            return this.f16974b.A(list);
        }
        return invokeL.booleanValue;
    }

    public ArrayList<c.a.d.o.e.n> c(boolean z, boolean z2, ArrayList<c.a.d.o.e.n> arrayList, c.a.u0.z3.k0.f fVar, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, fVar, Boolean.valueOf(z3)})) == null) ? d(z, z2, arrayList, fVar, false, z3) : (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<c.a.d.o.e.n> d(boolean z, boolean z2, ArrayList<c.a.d.o.e.n> arrayList, c.a.u0.z3.k0.f fVar, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, fVar, Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            if (this.f16976d == null) {
                return arrayList;
            }
            boolean s0 = this.a.getModelController().s0();
            if (this.f16976d.t0()) {
                return this.f16975c.y(z, s0, arrayList, z3, z4);
            }
            return this.f16974b.D(z, s0, z2, arrayList, fVar);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<c.a.d.o.e.n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f16976d.t0()) {
                return this.f16975c.z();
            }
            return this.f16976d.W();
        }
        return (ArrayList) invokeV.objValue;
    }

    public FrsSmartLoadMoreModel f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16975c : (FrsSmartLoadMoreModel) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsModelController frsModelController = this.f16976d;
            if (frsModelController == null) {
                return 1;
            }
            if (frsModelController.t0()) {
                return this.f16975c.getPn();
            }
            return this.f16974b.getPn();
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsModelController frsModelController = this.f16976d;
            if (frsModelController == null) {
                return -1;
            }
            if (frsModelController.t0()) {
                return this.f16975c.A();
            }
            return this.f16974b.F();
        }
        return invokeV.intValue;
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, frsViewData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (this.f16976d == null || this.f16977e == null || frsViewData == null) {
                return;
            }
            this.a.pullBeginTime = System.currentTimeMillis();
            if (this.f16976d.t0()) {
                if (this.f16975c.A() != 1 || this.f16976d.r0()) {
                    return;
                }
                this.f16975c.setSortType(this.f16976d.a0());
                this.f16975c.x();
                int pn = this.f16975c.getPn();
                this.f16975c.setPn(pn);
                this.f16976d.w0(pn + 1);
            } else if (this.f16976d.b0() == 1) {
                if (this.f16974b.isLoading || this.f16976d.r0()) {
                    return;
                }
                int pn2 = this.f16974b.getPn();
                if (this.f16974b.A(frsViewData.getThreadListIds())) {
                    this.f16974b.B();
                    this.f16974b.setSortType(this.f16976d.a0());
                    this.f16974b.O(c.a.d.f.m.b.g(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, this.f16976d.d0() != null ? c.a.u0.l3.a.e(this.f16976d.d0().getThreadList(), false) : "");
                } else if (this.f16974b.F() == 1) {
                    this.f16974b.B();
                    this.f16974b.setPn(pn2);
                    this.f16976d.w0(pn2 + 1);
                    FrsLoadMoreModel frsLoadMoreModel = this.f16974b;
                    frsLoadMoreModel.loadingDone = false;
                    frsLoadMoreModel.loadIndex = 0;
                }
            } else if (this.f16976d.u0()) {
            } else {
                this.f16976d.v0();
            }
        }
    }

    public void j(c.a.d.o.e.n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar) == null) || nVar == null) {
            return;
        }
        if (this.f16976d.t0()) {
            this.f16975c.G(nVar);
        } else {
            this.f16974b.L(nVar);
        }
    }

    public void k(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (this.f16976d.t0()) {
                this.f16975c.H(str);
            } else {
                this.f16974b.M(str);
            }
        }
    }

    public void l() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (frsModelController = this.f16976d) == null) {
            return;
        }
        if (frsModelController.t0()) {
            this.f16975c.I();
        } else {
            this.f16974b.P();
        }
    }

    public void m(c.a.u0.g1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.f16974b.Q(aVar);
            this.f16975c.L(aVar);
        }
    }

    public void n(int i2) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (frsModelController = this.f16976d) == null) {
            return;
        }
        if (frsModelController.t0()) {
            this.f16975c.setHasMore(i2);
        } else {
            this.f16974b.setHasMore(i2);
        }
    }

    public void o(int i2) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (frsModelController = this.f16976d) == null) {
            return;
        }
        if (frsModelController.t0()) {
            this.f16975c.setPn(i2);
        } else {
            this.f16974b.setPn(i2);
        }
    }
}
