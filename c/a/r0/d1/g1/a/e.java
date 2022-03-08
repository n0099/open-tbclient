package c.a.r0.d1.g1.a;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.r.t.j;
import c.a.r0.d1.g1.a.e;
import c.a.r0.d1.r2.s;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AcceleratorActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.accelerator.AcceleratorData;
import com.baidu.tieba.frs.accelerator.PkgNameAndNodeInfoData;
import com.baidu.tieba.frs.accelerator.model.AcceleratorNetModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public AcceleratorNetModel f15498b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.p4.b f15499c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.p4.a f15500d;

    /* renamed from: e  reason: collision with root package name */
    public AcceleratorNetModel.b f15501e;

    /* renamed from: f  reason: collision with root package name */
    public f f15502f;

    /* renamed from: g  reason: collision with root package name */
    public j.e f15503g;

    /* renamed from: h  reason: collision with root package name */
    public AcceleratorData f15504h;

    /* renamed from: i  reason: collision with root package name */
    public int f15505i;

    /* renamed from: j  reason: collision with root package name */
    public int f15506j;
    public boolean k;

    /* loaded from: classes2.dex */
    public class a implements c.a.r0.p4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.r0.p4.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (1 == this.a.f15506j || 3 == this.a.f15506j) {
                    this.a.y();
                } else if (2 == this.a.f15506j) {
                    this.a.v();
                }
            }
        }

        @Override // c.a.r0.p4.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                s.h(this.a.a.getActivity(), new View.OnClickListener() { // from class: c.a.r0.d1.g1.a.a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            e.a.this.c(view);
                        }
                    }
                }, new View.OnClickListener() { // from class: c.a.r0.d1.g1.a.b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            e.a.this.d(view);
                        }
                    }
                });
            }
        }

        public /* synthetic */ void c(View view) {
            this.a.f15499c.b(this.a.f15500d);
        }

        public /* synthetic */ void d(View view) {
            if (this.a.f15502f != null) {
                this.a.f15502f.b();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements AcceleratorNetModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // com.baidu.tieba.frs.accelerator.model.AcceleratorNetModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.o();
                if (this.a.a != null) {
                    BdToast.c(this.a.a.getContext(), this.a.a.getResources().getString(R.string.accelerator_net_error)).q();
                }
            }
        }

        @Override // com.baidu.tieba.frs.accelerator.model.AcceleratorNetModel.b
        public void b(AcceleratorData acceleratorData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, acceleratorData) == null) {
                this.a.o();
                this.a.f15504h = acceleratorData;
                if (this.a.a == null || this.a.f15504h == null || this.a.f15504h.getTokenInfo() == null || !StringUtils.isNull(this.a.f15504h.getTokenInfo().getToken())) {
                    if (2 != this.a.f15506j || this.a.a == null || this.a.f15504h == null || ListUtils.isEmpty(this.a.f15504h.getAvailableTornadoNodeInfoList())) {
                        if (3 == this.a.f15506j || 1 == this.a.f15506j) {
                            this.a.v();
                            return;
                        }
                        return;
                    }
                    this.a.t();
                    e eVar = this.a;
                    eVar.f15502f = f.c(eVar.a.getPageContext());
                    String[] b2 = c.a.r0.d1.g1.d.a.b(this.a.f15504h.getAvailableTornadoNodeInfoList(), this.a.f15504h.getAvailableNodesNum());
                    String str = b2[0];
                    if (this.a.f15504h.getItemData() != null) {
                        String acceleratorServer = TbSingleton.getInstance().getAcceleratorServer(String.valueOf(this.a.f15504h.getItemData().itemId));
                        if (!StringUtils.isNull(acceleratorServer)) {
                            str = acceleratorServer;
                        }
                    }
                    this.a.f15502f.d(str);
                    f fVar = this.a.f15502f;
                    fVar.e(this.a.f15503g);
                    fVar.f(b2);
                    fVar.g(this.a.a.getResources().getString(R.string.accelerator_net_node_title));
                    fVar.h();
                    return;
                }
                BdToast.c(this.a.a.getContext(), this.a.f15504h.getTokenInfo().getFailContent()).q();
            }
        }
    }

    public e(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15505i = 0;
        this.a = frsFragment;
        this.f15498b = new AcceleratorNetModel();
        this.f15499c = c.a.r0.p4.b.c(this.a);
        s();
        u();
    }

    public final void A() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (frsFragment = this.a) != null && (frsFragment.getActivity() instanceof FrsActivity)) {
            ((FrsActivity) this.a.getActivity()).showLoadingDialog(this.a.getResources().getString(R.string.accelerator_loading));
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f15506j = i2;
            FrsFragment frsFragment = this.a;
            if (frsFragment == null || frsFragment.getFrsViewData() == null || this.a.getFrsViewData().itemInfo == null) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                BdToast.c(this.a.getContext(), this.a.getResources().getString(R.string.accelerator_not_login)).q();
            } else if (TbSingleton.getInstance().acceleratorItemId != this.a.getFrsViewData().itemInfo.id.intValue() && TbSingleton.getInstance().acceleratorItemId != -1) {
                s.e(this.a.getActivity(), new View.OnClickListener() { // from class: c.a.r0.d1.g1.a.d
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            e.this.x(view);
                        }
                    }
                });
            } else if (TbSingleton.getInstance().acceleratorItemId == this.a.getFrsViewData().itemInfo.id.intValue()) {
                this.k = false;
                q();
            } else if (TbSingleton.getInstance().acceleratorItemId == -1) {
                this.k = true;
                q();
            }
        }
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.f15506j;
            if (i2 == 2 || i2 == 1) {
                return 1;
            }
            return i2 == 3 ? 2 : 0;
        }
        return invokeV.intValue;
    }

    public final void o() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (frsFragment = this.a) != null && (frsFragment.getActivity() instanceof FrsActivity)) {
            ((FrsActivity) this.a.getActivity()).closeLoadingDialog();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            AcceleratorNetModel acceleratorNetModel = this.f15498b;
            if (acceleratorNetModel != null) {
                acceleratorNetModel.destroy();
            }
            f fVar = this.f15502f;
            if (fVar != null) {
                fVar.b();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i2 = this.f15506j;
            if (1 == i2 || 3 == i2) {
                z();
            } else if (2 == i2) {
                y();
            }
        }
    }

    public c.a.r0.p4.b r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f15499c : (c.a.r0.p4.b) invokeV.objValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b bVar = new b(this);
            this.f15501e = bVar;
            this.f15498b.A(bVar);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f15503g = new j.e() { // from class: c.a.r0.d1.g1.a.c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // c.a.q0.r.t.j.e
                public final void onItemClick(j jVar, int i2, View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, jVar, i2, view) == null) {
                        e.this.w(jVar, i2, view);
                    }
                }
            };
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f15500d = new a(this);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            f fVar = this.f15502f;
            if (fVar != null) {
                fVar.b();
            }
            PkgNameAndNodeInfoData pkgNameAndNodeInfoData = c.a.r0.d1.g1.d.a.a(this.f15504h.getAvailableTornadoNodeInfoList()).get(Integer.valueOf(this.f15505i));
            if (this.f15506j == 2 && pkgNameAndNodeInfoData != null && !pkgNameAndNodeInfoData.compare(TbSingleton.getInstance().acceleratorData)) {
                this.k = true;
            }
            if (!this.k) {
                pkgNameAndNodeInfoData = TbSingleton.getInstance().acceleratorData;
            }
            AcceleratorActivityConfig acceleratorActivityConfig = new AcceleratorActivityConfig(this.a.getContext());
            acceleratorActivityConfig.setAcceleratorData(this.f15504h).setCurrentNodeInfo(pkgNameAndNodeInfoData).setFid(this.a.forumId).setSource(n()).setIsNewItem(this.k);
            acceleratorActivityConfig.start();
        }
    }

    public /* synthetic */ void w(j jVar, int i2, View view) {
        this.f15505i = i2;
        z();
    }

    public /* synthetic */ void x(View view) {
        this.k = true;
        q();
    }

    public final void y() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (frsFragment = this.a) == null || frsFragment.getFrsViewData() == null || this.a.getFrsViewData().itemInfo == null) {
            return;
        }
        A();
        this.f15498b.y(this.a.getFrsViewData().itemInfo.id.intValue());
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f15499c.b(this.f15500d);
        }
    }
}
