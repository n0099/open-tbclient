package c.a.t0.d1.r2;

import androidx.annotation.NonNull;
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
    public final FrsLoadMoreModel f16457b;

    /* renamed from: c  reason: collision with root package name */
    public final FrsSmartLoadMoreModel f16458c;

    /* renamed from: d  reason: collision with root package name */
    public final FrsModelController f16459d;

    /* renamed from: e  reason: collision with root package name */
    public final q f16460e;

    /* renamed from: f  reason: collision with root package name */
    public final b f16461f;

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

        @Override // c.a.t0.d1.r2.c.b
        public void removeItem(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.a.f16460e == null || this.a.f16460e.a0() == null) {
                return;
            }
            List<c.a.d.n.e.n> data = this.a.f16460e.a0().getData();
            if (ListUtils.isEmpty(data) || this.a.f16460e.a0().getAdapter() == null || ((c.a.d.n.e.n) ListUtils.remove(data, i2)) == null) {
                return;
            }
            this.a.f16460e.a0().getAdapter().notifyItemRemoved(i2);
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
        this.f16461f = new a(this);
        if (frsFragment != null) {
            this.a = frsFragment;
            this.f16457b = new FrsLoadMoreModel(frsFragment, kVar);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, kVar);
            this.f16458c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.M(this.f16461f);
            this.f16457b.S(this.f16461f);
            this.f16460e = frsFragment.getFrsView();
            FrsModelController modelController = frsFragment.getModelController();
            this.f16459d = modelController;
            this.f16458c.setSortType(modelController.a0());
            this.f16457b.setSortType(this.f16459d.a0());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            FrsModelController frsModelController = this.f16459d;
            if (frsModelController == null || frsModelController.t0()) {
                return false;
            }
            return this.f16457b.A(list);
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
            if (this.f16459d == null) {
                return arrayList;
            }
            boolean s0 = this.a.getModelController().s0();
            if (this.f16459d.t0()) {
                return this.f16458c.y(z, s0, arrayList, z3, z4);
            }
            return this.f16457b.D(z, s0, z2, arrayList, fVar);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<c.a.d.n.e.n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f16459d.t0()) {
                return this.f16458c.z();
            }
            return this.f16459d.W();
        }
        return (ArrayList) invokeV.objValue;
    }

    public FrsSmartLoadMoreModel f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16458c : (FrsSmartLoadMoreModel) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsModelController frsModelController = this.f16459d;
            if (frsModelController == null) {
                return 1;
            }
            if (frsModelController.t0()) {
                return this.f16458c.getPn();
            }
            return this.f16457b.getPn();
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsModelController frsModelController = this.f16459d;
            if (frsModelController == null) {
                return -1;
            }
            if (frsModelController.t0()) {
                return this.f16458c.A();
            }
            return this.f16457b.F();
        }
        return invokeV.intValue;
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, frsViewData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (this.f16459d == null || this.f16460e == null || frsViewData == null) {
                return;
            }
            this.a.pullBeginTime = System.currentTimeMillis();
            if (this.f16459d.t0()) {
                if (this.f16458c.A() != 1 || this.f16459d.r0()) {
                    return;
                }
                this.f16458c.setSortType(this.f16459d.a0());
                this.f16458c.x();
                int pn = this.f16458c.getPn();
                this.f16458c.setPn(pn);
                this.f16459d.w0(pn + 1);
            } else if (this.f16459d.b0() == 1) {
                if (this.f16457b.isLoading || this.f16459d.r0()) {
                    return;
                }
                int pn2 = this.f16457b.getPn();
                if (this.f16457b.A(frsViewData.getThreadListIds())) {
                    this.f16457b.B();
                    this.f16457b.setSortType(this.f16459d.a0());
                    this.f16457b.O(c.a.d.f.m.b.g(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, this.f16459d.d0() != null ? c.a.t0.j3.a.e(this.f16459d.d0().getThreadList(), false) : "");
                } else if (this.f16457b.F() == 1) {
                    this.f16457b.B();
                    this.f16457b.setPn(pn2);
                    this.f16459d.w0(pn2 + 1);
                    FrsLoadMoreModel frsLoadMoreModel = this.f16457b;
                    frsLoadMoreModel.loadingDone = false;
                    frsLoadMoreModel.loadIndex = 0;
                }
            } else if (this.f16459d.u0()) {
            } else {
                this.f16459d.v0();
            }
        }
    }

    public void j(c.a.d.n.e.n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar) == null) || nVar == null) {
            return;
        }
        if (this.f16459d.t0()) {
            this.f16458c.G(nVar);
        } else {
            this.f16457b.L(nVar);
        }
    }

    public void k(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (this.f16459d.t0()) {
                this.f16458c.H(str);
            } else {
                this.f16457b.M(str);
            }
        }
    }

    public void l() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (frsModelController = this.f16459d) == null) {
            return;
        }
        if (frsModelController.t0()) {
            this.f16458c.I();
        } else {
            this.f16457b.P();
        }
    }

    public void m(c.a.t0.f1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.f16457b.Q(aVar);
            this.f16458c.L(aVar);
        }
    }

    public void n(int i2) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (frsModelController = this.f16459d) == null) {
            return;
        }
        if (frsModelController.t0()) {
            this.f16458c.setHasMore(i2);
        } else {
            this.f16457b.setHasMore(i2);
        }
    }

    public void o(int i2) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (frsModelController = this.f16459d) == null) {
            return;
        }
        if (frsModelController.t0()) {
            this.f16458c.setPn(i2);
        } else {
            this.f16457b.setPn(i2);
        }
    }
}
