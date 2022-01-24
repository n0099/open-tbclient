package c.a.t0.e1.q1.a;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.s.j;
import c.a.t0.e1.i1;
import c.a.t0.e1.q1.a.e;
import c.a.t0.e1.z2.s;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AcceleratorActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ListUtils;
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
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public AcceleratorNetModel f16723b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.o4.b f16724c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.o4.a f16725d;

    /* renamed from: e  reason: collision with root package name */
    public AcceleratorNetModel.b f16726e;

    /* renamed from: f  reason: collision with root package name */
    public f f16727f;

    /* renamed from: g  reason: collision with root package name */
    public j.e f16728g;

    /* renamed from: h  reason: collision with root package name */
    public AcceleratorData f16729h;

    /* renamed from: i  reason: collision with root package name */
    public int f16730i;

    /* renamed from: j  reason: collision with root package name */
    public int f16731j;
    public boolean k;

    /* loaded from: classes7.dex */
    public class a implements c.a.t0.o4.a {
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

        @Override // c.a.t0.o4.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (1 == this.a.f16731j || 3 == this.a.f16731j) {
                    this.a.y();
                } else if (2 == this.a.f16731j) {
                    this.a.v();
                }
            }
        }

        @Override // c.a.t0.o4.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                s.h(this.a.a.getActivity(), new View.OnClickListener() { // from class: c.a.t0.e1.q1.a.a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            e.a.this.c(view);
                        }
                    }
                }, new View.OnClickListener() { // from class: c.a.t0.e1.q1.a.b
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
            this.a.f16724c.b(this.a.f16725d);
        }

        public /* synthetic */ void d(View view) {
            if (this.a.f16727f != null) {
                this.a.f16727f.b();
            }
        }
    }

    /* loaded from: classes7.dex */
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
        public void a(AcceleratorData acceleratorData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, acceleratorData) == null) {
                this.a.o();
                this.a.f16729h = acceleratorData;
                if (this.a.a == null || this.a.f16729h == null || this.a.f16729h.getTokenInfo() == null || !StringUtils.isNull(this.a.f16729h.getTokenInfo().getToken())) {
                    if (2 != this.a.f16731j || this.a.a == null || this.a.f16729h == null || ListUtils.isEmpty(this.a.f16729h.getAvailableTornadoNodeInfoList())) {
                        if (3 == this.a.f16731j || 1 == this.a.f16731j) {
                            this.a.v();
                            return;
                        }
                        return;
                    }
                    this.a.t();
                    e eVar = this.a;
                    eVar.f16727f = f.c(eVar.a.getPageContext());
                    f fVar = this.a.f16727f;
                    fVar.d(this.a.f16728g);
                    fVar.e(c.a.t0.e1.q1.d.a.b(this.a.f16729h.getAvailableTornadoNodeInfoList(), this.a.f16729h.getAvailableNodesNum()));
                    fVar.f(this.a.a.getResources().getString(i1.accelerator_net_node_title));
                    fVar.g();
                    return;
                }
                BdToast.c(this.a.a.getContext(), this.a.f16729h.getTokenInfo().getFailContent()).q();
            }
        }

        @Override // com.baidu.tieba.frs.accelerator.model.AcceleratorNetModel.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.o();
                if (this.a.a != null) {
                    BdToast.c(this.a.a.getContext(), this.a.a.getResources().getString(i1.accelerator_net_error)).q();
                }
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
        this.f16730i = 0;
        this.a = frsFragment;
        this.f16723b = new AcceleratorNetModel();
        this.f16724c = c.a.t0.o4.b.c(this.a);
        s();
        u();
    }

    public final void A() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (frsFragment = this.a) != null && (frsFragment.getActivity() instanceof FrsActivity)) {
            ((FrsActivity) this.a.getActivity()).showLoadingDialog(this.a.getResources().getString(i1.accelerator_loading));
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f16731j = i2;
            FrsFragment frsFragment = this.a;
            if (frsFragment == null || frsFragment.getFrsViewData() == null || this.a.getFrsViewData().itemInfo == null) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                BdToast.c(this.a.getContext(), this.a.getResources().getString(i1.accelerator_not_login)).q();
            } else if (TbSingleton.getInstance().acceleratorItemId != this.a.getFrsViewData().itemInfo.id.intValue() && TbSingleton.getInstance().acceleratorItemId != -1) {
                s.e(this.a.getActivity(), new View.OnClickListener() { // from class: c.a.t0.e1.q1.a.d
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
            int i2 = this.f16731j;
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
            AcceleratorNetModel acceleratorNetModel = this.f16723b;
            if (acceleratorNetModel != null) {
                acceleratorNetModel.destroy();
            }
            f fVar = this.f16727f;
            if (fVar != null) {
                fVar.b();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i2 = this.f16731j;
            if (1 == i2 || 3 == i2) {
                z();
            } else if (2 == i2) {
                y();
            }
        }
    }

    public c.a.t0.o4.b r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f16724c : (c.a.t0.o4.b) invokeV.objValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b bVar = new b(this);
            this.f16726e = bVar;
            this.f16723b.A(bVar);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f16728g = new j.e() { // from class: c.a.t0.e1.q1.a.c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // c.a.s0.s.s.j.e
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
            this.f16725d = new a(this);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            f fVar = this.f16727f;
            if (fVar != null) {
                fVar.b();
            }
            PkgNameAndNodeInfoData pkgNameAndNodeInfoData = c.a.t0.e1.q1.d.a.a(this.f16729h.getAvailableTornadoNodeInfoList()).get(Integer.valueOf(this.f16730i));
            if (this.f16731j == 2 && pkgNameAndNodeInfoData != null && !pkgNameAndNodeInfoData.compare(TbSingleton.getInstance().acceleratorData)) {
                this.k = true;
            }
            if (!this.k) {
                pkgNameAndNodeInfoData = TbSingleton.getInstance().acceleratorData;
            }
            AcceleratorActivityConfig acceleratorActivityConfig = new AcceleratorActivityConfig(this.a.getContext());
            acceleratorActivityConfig.setAcceleratorData(this.f16729h).setCurrentNodeInfo(pkgNameAndNodeInfoData).setFid(this.a.forumId).setSource(n()).setIsNewItem(this.k);
            acceleratorActivityConfig.start();
        }
    }

    public /* synthetic */ void w(j jVar, int i2, View view) {
        this.f16730i = i2;
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
        this.f16723b.y(this.a.getFrsViewData().itemInfo.id.intValue());
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f16724c.b(this.f16725d);
        }
    }
}
