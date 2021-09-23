package c.a.r0.w0.f2;

import androidx.core.view.InputDeviceCompat;
import c.a.r0.w0.q;
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
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final FrsFragment f26645a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsLoadMoreModel f26646b;

    /* renamed from: c  reason: collision with root package name */
    public final FrsSmartLoadMoreModel f26647c;

    /* renamed from: d  reason: collision with root package name */
    public final FrsModelController f26648d;

    /* renamed from: e  reason: collision with root package name */
    public final q f26649e;

    /* renamed from: f  reason: collision with root package name */
    public final b f26650f;

    /* loaded from: classes4.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f26651a;

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
            this.f26651a = cVar;
        }

        @Override // c.a.r0.w0.f2.c.b
        public void removeItem(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f26651a.f26649e == null || this.f26651a.f26649e.b0() == null) {
                return;
            }
            List<c.a.e.l.e.n> data = this.f26651a.f26649e.b0().getData();
            if (ListUtils.isEmpty(data) || this.f26651a.f26649e.b0().getAdapter() == null || ((c.a.e.l.e.n) ListUtils.remove(data, i2)) == null) {
                return;
            }
            this.f26651a.f26649e.b0().getAdapter().notifyItemRemoved(i2);
        }
    }

    /* loaded from: classes4.dex */
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
        this.f26650f = new a(this);
        if (frsFragment != null) {
            this.f26645a = frsFragment;
            this.f26646b = new FrsLoadMoreModel(frsFragment, kVar);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, kVar);
            this.f26647c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.L(this.f26650f);
            this.f26646b.Q(this.f26650f);
            this.f26649e = frsFragment.getFrsView();
            FrsModelController modelController = frsFragment.getModelController();
            this.f26648d = modelController;
            this.f26647c.setSortType(modelController.a0());
            this.f26646b.setSortType(this.f26648d.a0());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            FrsModelController frsModelController = this.f26648d;
            if (frsModelController == null || frsModelController.u0()) {
                return false;
            }
            return this.f26646b.A(list);
        }
        return invokeL.booleanValue;
    }

    public ArrayList<c.a.e.l.e.n> c(boolean z, boolean z2, ArrayList<c.a.e.l.e.n> arrayList, c.a.r0.j3.i0.f fVar, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, fVar, Boolean.valueOf(z3)})) == null) ? d(z, z2, arrayList, fVar, false, z3) : (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<c.a.e.l.e.n> d(boolean z, boolean z2, ArrayList<c.a.e.l.e.n> arrayList, c.a.r0.j3.i0.f fVar, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, fVar, Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            if (this.f26648d == null) {
                return arrayList;
            }
            boolean t0 = this.f26645a.getModelController().t0();
            if (this.f26648d.u0()) {
                return this.f26647c.y(z, t0, arrayList, z3, z4);
            }
            return this.f26646b.C(z, t0, z2, arrayList, fVar);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<c.a.e.l.e.n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f26648d.u0()) {
                return this.f26647c.z();
            }
            return this.f26648d.W();
        }
        return (ArrayList) invokeV.objValue;
    }

    public FrsSmartLoadMoreModel f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26647c : (FrsSmartLoadMoreModel) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsModelController frsModelController = this.f26648d;
            if (frsModelController == null) {
                return 1;
            }
            if (frsModelController.u0()) {
                return this.f26647c.getPn();
            }
            return this.f26646b.getPn();
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsModelController frsModelController = this.f26648d;
            if (frsModelController == null) {
                return -1;
            }
            if (frsModelController.u0()) {
                return this.f26647c.A();
            }
            return this.f26646b.E();
        }
        return invokeV.intValue;
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, frsViewData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (this.f26648d == null || this.f26649e == null || frsViewData == null) {
                return;
            }
            this.f26645a.pullBeginTime = System.currentTimeMillis();
            if (this.f26648d.u0()) {
                if (this.f26647c.A() != 1 || this.f26648d.s0()) {
                    return;
                }
                this.f26647c.setSortType(this.f26648d.a0());
                this.f26647c.x();
                int pn = this.f26647c.getPn();
                this.f26647c.setPn(pn);
                this.f26648d.x0(pn + 1);
            } else if (this.f26648d.b0() == 1) {
                if (this.f26646b.isLoading || this.f26648d.s0()) {
                    return;
                }
                int pn2 = this.f26646b.getPn();
                if (this.f26646b.A(frsViewData.getThreadListIds())) {
                    this.f26646b.B();
                    this.f26646b.setSortType(this.f26648d.a0());
                    this.f26646b.M(c.a.e.e.m.b.g(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, this.f26648d.d0() != null ? c.a.r0.y2.a.e(this.f26648d.d0().getThreadList(), false) : "");
                } else if (this.f26646b.E() == 1) {
                    this.f26646b.B();
                    this.f26646b.setPn(pn2);
                    this.f26648d.x0(pn2 + 1);
                    FrsLoadMoreModel frsLoadMoreModel = this.f26646b;
                    frsLoadMoreModel.loadingDone = false;
                    frsLoadMoreModel.loadIndex = 0;
                }
            } else if (this.f26648d.v0()) {
            } else {
                this.f26648d.w0();
            }
        }
    }

    public void j(c.a.e.l.e.n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar) == null) || nVar == null) {
            return;
        }
        if (this.f26648d.u0()) {
            this.f26647c.G(nVar);
        } else {
            this.f26646b.K(nVar);
        }
    }

    public void k() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (frsModelController = this.f26648d) == null) {
            return;
        }
        if (frsModelController.u0()) {
            this.f26647c.H();
        } else {
            this.f26646b.N();
        }
    }

    public void l(c.a.r0.y0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.f26646b.O(aVar);
            this.f26647c.K(aVar);
        }
    }

    public void m(int i2) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (frsModelController = this.f26648d) == null) {
            return;
        }
        if (frsModelController.u0()) {
            this.f26647c.setHasMore(i2);
        } else {
            this.f26646b.setHasMore(i2);
        }
    }

    public void n(int i2) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (frsModelController = this.f26648d) == null) {
            return;
        }
        if (frsModelController.u0()) {
            this.f26647c.setPn(i2);
        } else {
            this.f26646b.setPn(i2);
        }
    }
}
