package b.a.r0.x0.q2;

import androidx.core.view.InputDeviceCompat;
import b.a.r0.x0.q;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final FrsFragment f27689a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsLoadMoreModel f27690b;

    /* renamed from: c  reason: collision with root package name */
    public final FrsSmartLoadMoreModel f27691c;

    /* renamed from: d  reason: collision with root package name */
    public final FrsModelController f27692d;

    /* renamed from: e  reason: collision with root package name */
    public final q f27693e;

    /* renamed from: f  reason: collision with root package name */
    public final b f27694f;

    /* loaded from: classes6.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f27695a;

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
            this.f27695a = cVar;
        }

        @Override // b.a.r0.x0.q2.c.b
        public void removeItem(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f27695a.f27693e == null || this.f27695a.f27693e.a0() == null) {
                return;
            }
            List<b.a.e.m.e.n> data = this.f27695a.f27693e.a0().getData();
            if (ListUtils.isEmpty(data) || this.f27695a.f27693e.a0().getAdapter() == null || ((b.a.e.m.e.n) ListUtils.remove(data, i2)) == null) {
                return;
            }
            this.f27695a.f27693e.a0().getAdapter().notifyItemRemoved(i2);
        }
    }

    /* loaded from: classes6.dex */
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
        this.f27694f = new a(this);
        if (frsFragment != null) {
            this.f27689a = frsFragment;
            this.f27690b = new FrsLoadMoreModel(frsFragment, kVar);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, kVar);
            this.f27691c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.L(this.f27694f);
            this.f27690b.Q(this.f27694f);
            this.f27693e = frsFragment.getFrsView();
            FrsModelController modelController = frsFragment.getModelController();
            this.f27692d = modelController;
            this.f27691c.setSortType(modelController.a0());
            this.f27690b.setSortType(this.f27692d.a0());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            FrsModelController frsModelController = this.f27692d;
            if (frsModelController == null || frsModelController.u0()) {
                return false;
            }
            return this.f27690b.A(list);
        }
        return invokeL.booleanValue;
    }

    public ArrayList<b.a.e.m.e.n> c(boolean z, boolean z2, ArrayList<b.a.e.m.e.n> arrayList, b.a.r0.m3.j0.f fVar, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, fVar, Boolean.valueOf(z3)})) == null) ? d(z, z2, arrayList, fVar, false, z3) : (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<b.a.e.m.e.n> d(boolean z, boolean z2, ArrayList<b.a.e.m.e.n> arrayList, b.a.r0.m3.j0.f fVar, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, fVar, Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            if (this.f27692d == null) {
                return arrayList;
            }
            boolean t0 = this.f27689a.getModelController().t0();
            if (this.f27692d.u0()) {
                return this.f27691c.y(z, t0, arrayList, z3, z4);
            }
            return this.f27690b.C(z, t0, z2, arrayList, fVar);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<b.a.e.m.e.n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f27692d.u0()) {
                return this.f27691c.z();
            }
            return this.f27692d.W();
        }
        return (ArrayList) invokeV.objValue;
    }

    public FrsSmartLoadMoreModel f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27691c : (FrsSmartLoadMoreModel) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsModelController frsModelController = this.f27692d;
            if (frsModelController == null) {
                return 1;
            }
            if (frsModelController.u0()) {
                return this.f27691c.getPn();
            }
            return this.f27690b.getPn();
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsModelController frsModelController = this.f27692d;
            if (frsModelController == null) {
                return -1;
            }
            if (frsModelController.u0()) {
                return this.f27691c.A();
            }
            return this.f27690b.E();
        }
        return invokeV.intValue;
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, frsViewData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (this.f27692d == null || this.f27693e == null || frsViewData == null) {
                return;
            }
            this.f27689a.pullBeginTime = System.currentTimeMillis();
            if (this.f27692d.u0()) {
                if (this.f27691c.A() != 1 || this.f27692d.s0()) {
                    return;
                }
                this.f27691c.setSortType(this.f27692d.a0());
                this.f27691c.x();
                int pn = this.f27691c.getPn();
                this.f27691c.setPn(pn);
                this.f27692d.x0(pn + 1);
            } else if (this.f27692d.b0() == 1) {
                if (this.f27690b.isLoading || this.f27692d.s0()) {
                    return;
                }
                int pn2 = this.f27690b.getPn();
                if (this.f27690b.A(frsViewData.getThreadListIds())) {
                    this.f27690b.B();
                    this.f27690b.setSortType(this.f27692d.a0());
                    this.f27690b.M(b.a.e.f.m.b.g(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, this.f27692d.d0() != null ? b.a.r0.a3.a.e(this.f27692d.d0().getThreadList(), false) : "");
                } else if (this.f27690b.E() == 1) {
                    this.f27690b.B();
                    this.f27690b.setPn(pn2);
                    this.f27692d.x0(pn2 + 1);
                    FrsLoadMoreModel frsLoadMoreModel = this.f27690b;
                    frsLoadMoreModel.loadingDone = false;
                    frsLoadMoreModel.loadIndex = 0;
                }
            } else if (this.f27692d.v0()) {
            } else {
                this.f27692d.w0();
            }
        }
    }

    public void j(b.a.e.m.e.n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar) == null) || nVar == null) {
            return;
        }
        if (this.f27692d.u0()) {
            this.f27691c.G(nVar);
        } else {
            this.f27690b.K(nVar);
        }
    }

    public void k() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (frsModelController = this.f27692d) == null) {
            return;
        }
        if (frsModelController.u0()) {
            this.f27691c.H();
        } else {
            this.f27690b.N();
        }
    }

    public void l(b.a.r0.z0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.f27690b.O(aVar);
            this.f27691c.K(aVar);
        }
    }

    public void m(int i2) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (frsModelController = this.f27692d) == null) {
            return;
        }
        if (frsModelController.u0()) {
            this.f27691c.setHasMore(i2);
        } else {
            this.f27690b.setHasMore(i2);
        }
    }

    public void n(int i2) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (frsModelController = this.f27692d) == null) {
            return;
        }
        if (frsModelController.u0()) {
            this.f27691c.setPn(i2);
        } else {
            this.f27690b.setPn(i2);
        }
    }
}
