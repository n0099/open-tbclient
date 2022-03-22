package c.a.p0.f1.g1.a;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.t.l;
import c.a.p0.f1.g1.a.e;
import c.a.p0.f1.r2.s;
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
    public AcceleratorNetModel f13959b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.r4.b f13960c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.r4.a f13961d;

    /* renamed from: e  reason: collision with root package name */
    public AcceleratorNetModel.b f13962e;

    /* renamed from: f  reason: collision with root package name */
    public f f13963f;

    /* renamed from: g  reason: collision with root package name */
    public l.e f13964g;

    /* renamed from: h  reason: collision with root package name */
    public AcceleratorData f13965h;
    public int i;
    public int j;
    public boolean k;

    /* loaded from: classes2.dex */
    public class a implements c.a.p0.r4.a {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.p0.r4.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (1 == this.a.j || 3 == this.a.j) {
                    this.a.y();
                } else if (2 == this.a.j) {
                    this.a.v();
                }
            }
        }

        @Override // c.a.p0.r4.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                s.h(this.a.a.getActivity(), new View.OnClickListener() { // from class: c.a.p0.f1.g1.a.b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            e.a.this.c(view);
                        }
                    }
                }, new View.OnClickListener() { // from class: c.a.p0.f1.g1.a.a
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
            this.a.f13960c.b(this.a.f13961d);
        }

        public /* synthetic */ void d(View view) {
            if (this.a.f13963f != null) {
                this.a.f13963f.b();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    BdToast.c(this.a.a.getContext(), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0061)).q();
                }
            }
        }

        @Override // com.baidu.tieba.frs.accelerator.model.AcceleratorNetModel.b
        public void b(AcceleratorData acceleratorData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, acceleratorData) == null) {
                this.a.o();
                this.a.f13965h = acceleratorData;
                if (this.a.a == null || this.a.f13965h == null || this.a.f13965h.getTokenInfo() == null || !StringUtils.isNull(this.a.f13965h.getTokenInfo().getToken())) {
                    if (2 != this.a.j || this.a.a == null || this.a.f13965h == null || ListUtils.isEmpty(this.a.f13965h.getAvailableTornadoNodeInfoList())) {
                        if (3 == this.a.j || 1 == this.a.j) {
                            this.a.v();
                            return;
                        }
                        return;
                    }
                    this.a.t();
                    e eVar = this.a;
                    eVar.f13963f = f.c(eVar.a.getPageContext());
                    String[] b2 = c.a.p0.f1.g1.d.a.b(this.a.f13965h.getAvailableTornadoNodeInfoList(), this.a.f13965h.getAvailableNodesNum());
                    String str = b2[0];
                    if (this.a.f13965h.getItemData() != null) {
                        String acceleratorServer = TbSingleton.getInstance().getAcceleratorServer(String.valueOf(this.a.f13965h.getItemData().itemId));
                        if (!StringUtils.isNull(acceleratorServer)) {
                            str = acceleratorServer;
                        }
                    }
                    this.a.f13963f.d(str);
                    f fVar = this.a.f13963f;
                    fVar.e(this.a.f13964g);
                    fVar.f(b2);
                    fVar.g(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0062));
                    fVar.h();
                    return;
                }
                BdToast.c(this.a.a.getContext(), this.a.f13965h.getTokenInfo().getFailContent()).q();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 0;
        this.a = frsFragment;
        this.f13959b = new AcceleratorNetModel();
        this.f13960c = c.a.p0.r4.b.c(this.a);
        s();
        u();
    }

    public final void A() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (frsFragment = this.a) != null && (frsFragment.getActivity() instanceof FrsActivity)) {
            ((FrsActivity) this.a.getActivity()).showLoadingDialog(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0060));
        }
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.j = i;
            FrsFragment frsFragment = this.a;
            if (frsFragment == null || frsFragment.f0() == null || this.a.f0().itemInfo == null) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                BdToast.c(this.a.getContext(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0063)).q();
            } else if (TbSingleton.getInstance().acceleratorItemId != this.a.f0().itemInfo.id.intValue() && TbSingleton.getInstance().acceleratorItemId != -1) {
                s.e(this.a.getActivity(), new View.OnClickListener() { // from class: c.a.p0.f1.g1.a.d
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
            } else if (TbSingleton.getInstance().acceleratorItemId == this.a.f0().itemInfo.id.intValue()) {
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
            int i = this.j;
            if (i == 2 || i == 1) {
                return 1;
            }
            return i == 3 ? 2 : 0;
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
            AcceleratorNetModel acceleratorNetModel = this.f13959b;
            if (acceleratorNetModel != null) {
                acceleratorNetModel.destroy();
            }
            f fVar = this.f13963f;
            if (fVar != null) {
                fVar.b();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i = this.j;
            if (1 == i || 3 == i) {
                z();
            } else if (2 == i) {
                y();
            }
        }
    }

    public c.a.p0.r4.b r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f13960c : (c.a.p0.r4.b) invokeV.objValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b bVar = new b(this);
            this.f13962e = bVar;
            this.f13959b.C(bVar);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f13964g = new l.e() { // from class: c.a.p0.f1.g1.a.c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // c.a.o0.r.t.l.e
                public final void onItemClick(l lVar, int i, View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, lVar, i, view) == null) {
                        e.this.w(lVar, i, view);
                    }
                }
            };
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f13961d = new a(this);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            f fVar = this.f13963f;
            if (fVar != null) {
                fVar.b();
            }
            PkgNameAndNodeInfoData pkgNameAndNodeInfoData = c.a.p0.f1.g1.d.a.a(this.f13965h.getAvailableTornadoNodeInfoList()).get(Integer.valueOf(this.i));
            if (this.j == 2 && pkgNameAndNodeInfoData != null && !pkgNameAndNodeInfoData.compare(TbSingleton.getInstance().acceleratorData)) {
                this.k = true;
            }
            if (!this.k) {
                pkgNameAndNodeInfoData = TbSingleton.getInstance().acceleratorData;
            }
            AcceleratorActivityConfig acceleratorActivityConfig = new AcceleratorActivityConfig(this.a.getContext());
            acceleratorActivityConfig.setAcceleratorData(this.f13965h).setCurrentNodeInfo(pkgNameAndNodeInfoData).setFid(this.a.l).setSource(n()).setIsNewItem(this.k);
            acceleratorActivityConfig.start();
        }
    }

    public /* synthetic */ void w(l lVar, int i, View view) {
        this.i = i;
        z();
    }

    public /* synthetic */ void x(View view) {
        this.k = true;
        q();
    }

    public final void y() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (frsFragment = this.a) == null || frsFragment.f0() == null || this.a.f0().itemInfo == null) {
            return;
        }
        A();
        this.f13959b.A(this.a.f0().itemInfo.id.intValue());
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f13960c.b(this.f13961d);
        }
    }
}
