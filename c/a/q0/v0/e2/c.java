package c.a.q0.v0.e2;

import androidx.core.view.InputDeviceCompat;
import c.a.q0.v0.q;
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
    public final FrsFragment f25935a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsLoadMoreModel f25936b;

    /* renamed from: c  reason: collision with root package name */
    public final FrsSmartLoadMoreModel f25937c;

    /* renamed from: d  reason: collision with root package name */
    public final FrsModelController f25938d;

    /* renamed from: e  reason: collision with root package name */
    public final q f25939e;

    /* renamed from: f  reason: collision with root package name */
    public final b f25940f;

    /* loaded from: classes4.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f25941a;

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
            this.f25941a = cVar;
        }

        @Override // c.a.q0.v0.e2.c.b
        public void removeItem(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f25941a.f25939e == null || this.f25941a.f25939e.b0() == null) {
                return;
            }
            List<c.a.e.l.e.n> data = this.f25941a.f25939e.b0().getData();
            if (ListUtils.isEmpty(data) || this.f25941a.f25939e.b0().getAdapter() == null || ((c.a.e.l.e.n) ListUtils.remove(data, i2)) == null) {
                return;
            }
            this.f25941a.f25939e.b0().getAdapter().notifyItemRemoved(i2);
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
        this.f25940f = new a(this);
        if (frsFragment != null) {
            this.f25935a = frsFragment;
            this.f25936b = new FrsLoadMoreModel(frsFragment, kVar);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, kVar);
            this.f25937c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.L(this.f25940f);
            this.f25936b.Q(this.f25940f);
            this.f25939e = frsFragment.getFrsView();
            FrsModelController modelController = frsFragment.getModelController();
            this.f25938d = modelController;
            this.f25937c.setSortType(modelController.a0());
            this.f25936b.setSortType(this.f25938d.a0());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            FrsModelController frsModelController = this.f25938d;
            if (frsModelController == null || frsModelController.u0()) {
                return false;
            }
            return this.f25936b.A(list);
        }
        return invokeL.booleanValue;
    }

    public ArrayList<c.a.e.l.e.n> c(boolean z, boolean z2, ArrayList<c.a.e.l.e.n> arrayList, c.a.q0.i3.i0.f fVar, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, fVar, Boolean.valueOf(z3)})) == null) ? d(z, z2, arrayList, fVar, false, z3) : (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<c.a.e.l.e.n> d(boolean z, boolean z2, ArrayList<c.a.e.l.e.n> arrayList, c.a.q0.i3.i0.f fVar, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, fVar, Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            if (this.f25938d == null) {
                return arrayList;
            }
            boolean t0 = this.f25935a.getModelController().t0();
            if (this.f25938d.u0()) {
                return this.f25937c.y(z, t0, arrayList, z3, z4);
            }
            return this.f25936b.C(z, t0, z2, arrayList, fVar);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<c.a.e.l.e.n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f25938d.u0()) {
                return this.f25937c.z();
            }
            return this.f25938d.W();
        }
        return (ArrayList) invokeV.objValue;
    }

    public FrsSmartLoadMoreModel f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f25937c : (FrsSmartLoadMoreModel) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsModelController frsModelController = this.f25938d;
            if (frsModelController == null) {
                return 1;
            }
            if (frsModelController.u0()) {
                return this.f25937c.getPn();
            }
            return this.f25936b.getPn();
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsModelController frsModelController = this.f25938d;
            if (frsModelController == null) {
                return -1;
            }
            if (frsModelController.u0()) {
                return this.f25937c.A();
            }
            return this.f25936b.E();
        }
        return invokeV.intValue;
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, frsViewData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (this.f25938d == null || this.f25939e == null || frsViewData == null) {
                return;
            }
            this.f25935a.pullBeginTime = System.currentTimeMillis();
            if (this.f25938d.u0()) {
                if (this.f25937c.A() != 1 || this.f25938d.s0()) {
                    return;
                }
                this.f25937c.setSortType(this.f25938d.a0());
                this.f25937c.x();
                int pn = this.f25937c.getPn();
                this.f25937c.setPn(pn);
                this.f25938d.x0(pn + 1);
            } else if (this.f25938d.b0() == 1) {
                if (this.f25936b.isLoading || this.f25938d.s0()) {
                    return;
                }
                int pn2 = this.f25936b.getPn();
                if (this.f25936b.A(frsViewData.getThreadListIds())) {
                    this.f25936b.B();
                    this.f25936b.setSortType(this.f25938d.a0());
                    this.f25936b.M(c.a.e.e.m.b.f(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, this.f25938d.d0() != null ? c.a.q0.x2.a.e(this.f25938d.d0().getThreadList(), false) : "");
                } else if (this.f25936b.E() == 1) {
                    this.f25936b.B();
                    this.f25936b.setPn(pn2);
                    this.f25938d.x0(pn2 + 1);
                    FrsLoadMoreModel frsLoadMoreModel = this.f25936b;
                    frsLoadMoreModel.loadingDone = false;
                    frsLoadMoreModel.loadIndex = 0;
                }
            } else if (this.f25938d.v0()) {
            } else {
                this.f25938d.w0();
            }
        }
    }

    public void j(c.a.e.l.e.n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar) == null) || nVar == null) {
            return;
        }
        if (this.f25938d.u0()) {
            this.f25937c.G(nVar);
        } else {
            this.f25936b.K(nVar);
        }
    }

    public void k() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (frsModelController = this.f25938d) == null) {
            return;
        }
        if (frsModelController.u0()) {
            this.f25937c.H();
        } else {
            this.f25936b.N();
        }
    }

    public void l(c.a.q0.x0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.f25936b.O(aVar);
            this.f25937c.K(aVar);
        }
    }

    public void m(int i2) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (frsModelController = this.f25938d) == null) {
            return;
        }
        if (frsModelController.u0()) {
            this.f25937c.setHasMore(i2);
        } else {
            this.f25936b.setHasMore(i2);
        }
    }

    public void n(int i2) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (frsModelController = this.f25938d) == null) {
            return;
        }
        if (frsModelController.u0()) {
            this.f25937c.setPn(i2);
        } else {
            this.f25936b.setPn(i2);
        }
    }
}
