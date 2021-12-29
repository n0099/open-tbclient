package c.a.t0.d1.r2.a;

import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.s.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.profession.permission.FrsProfessionPermissionModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f16837e;

    /* renamed from: f  reason: collision with root package name */
    public FrsProfessionPermissionModel f16838f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.d1.r2.a.a f16839g;

    /* renamed from: h  reason: collision with root package name */
    public d f16840h;

    /* renamed from: i  reason: collision with root package name */
    public int f16841i;

    /* loaded from: classes7.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f16842e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.s.s.a f16843f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f16844g;

        public a(c cVar, String str, c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16844g = cVar;
            this.f16842e = str;
            this.f16843f = aVar;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.f16844g.f16837e.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.f16842e);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.f16843f.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.s.s.a f16845e;

        public b(c cVar, c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16845e = aVar;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f16845e.dismiss();
            }
        }
    }

    /* renamed from: c.a.t0.d1.r2.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1030c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.s.s.a f16846e;

        public C1030c(c cVar, c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16846e = aVar;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f16846e.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a(boolean z, int i2);

        void b(boolean z);

        void c(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16837e = tbPageContext;
        c.a.t0.d1.r2.a.a aVar = new c.a.t0.d1.r2.a.a();
        this.f16839g = aVar;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, aVar);
        this.f16838f = frsProfessionPermissionModel;
        frsProfessionPermissionModel.Y(this);
    }

    public final void b(c.a.t0.d1.r2.a.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) && bVar != null && bVar.f16833f == 0) {
            if (!bVar.f16832e && bVar.f16835h == 2) {
                m(bVar.f16836i);
            }
            d dVar = this.f16840h;
            if (dVar != null) {
                dVar.c(bVar.f16832e);
            }
        }
    }

    public final void c(c.a.t0.d1.r2.a.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str) == null) || bVar == null) {
            return;
        }
        if (bVar.f16833f != 0) {
            if (StringUtils.isNull(bVar.f16834g)) {
                this.f16837e.showToast(R.string.neterror);
                return;
            } else {
                this.f16837e.showToast(bVar.f16834g);
                return;
            }
        }
        if (!bVar.f16832e) {
            int i2 = bVar.f16835h;
            if (i2 == 1) {
                l(bVar.f16836i, str);
            } else if (i2 == 3) {
                m(bVar.f16836i);
            }
        }
        d dVar = this.f16840h;
        if (dVar != null) {
            dVar.b(bVar.f16832e);
        }
    }

    public final void d(c.a.t0.d1.r2.a.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bVar, i2) == null) || bVar == null) {
            return;
        }
        if (bVar.f16833f != 0) {
            if (StringUtils.isNull(bVar.f16834g)) {
                this.f16837e.showToast(R.string.neterror);
                return;
            } else {
                this.f16837e.showToast(bVar.f16834g);
                return;
            }
        }
        d dVar = this.f16840h;
        if (dVar != null) {
            dVar.a(bVar.f16832e, i2);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f16838f.Q()) {
            return;
        }
        this.f16838f.loadData();
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            c.a.t0.d1.r2.a.a aVar = this.f16839g;
            aVar.f16830h = 1;
            aVar.f16829g = str;
            e();
        }
    }

    public void g(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, str, j2) == null) {
            c.a.t0.d1.r2.a.a aVar = this.f16839g;
            aVar.f16829g = str;
            aVar.f16828f = j2;
            aVar.f16830h = 3;
            e();
        }
    }

    public void h(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
            c.a.t0.d1.r2.a.a aVar = this.f16839g;
            aVar.f16827e = i2;
            aVar.f16829g = str;
            aVar.f16830h = 2;
            e();
        }
    }

    public void i(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.f16840h = dVar;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f16841i = i2;
            this.f16839g.f16831i = i2;
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048585, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof c.a.t0.d1.r2.a.a) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof c.a.t0.d1.r2.a.b)) {
            c.a.t0.d1.r2.a.a aVar = (c.a.t0.d1.r2.a.a) mvcNetMessage.getRequestData();
            c.a.t0.d1.r2.a.b bVar = (c.a.t0.d1.r2.a.b) mvcSocketResponsedMessage.getData();
            if (aVar.f16831i != this.f16841i) {
                return;
            }
            int i2 = aVar.f16830h;
            if (i2 == 1) {
                b(bVar);
            } else if (i2 == 2) {
                d(bVar, aVar.f16827e);
            } else if (i2 != 3) {
            } else {
                c(bVar, aVar.f16829g);
            }
        }
    }

    public final void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.f16837e.getPageActivity());
            aVar.setCanceledOnTouchOutside(false);
            aVar.setCancelable(false);
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.comfirm_imediate, new a(this, str2, aVar));
            aVar.setNegativeButton(R.string.comfirm_cancel, new b(this, aVar));
            aVar.create(this.f16837e);
            aVar.show();
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.f16837e.getPageActivity());
            aVar.setCanceledOnTouchOutside(false);
            aVar.setCancelable(false);
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new C1030c(this, aVar));
            aVar.create(this.f16837e);
            aVar.show();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof c.a.t0.d1.r2.a.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof c.a.t0.d1.r2.a.b)) {
            c.a.t0.d1.r2.a.a aVar = (c.a.t0.d1.r2.a.a) mvcNetMessage.getRequestData();
            c.a.t0.d1.r2.a.b bVar = (c.a.t0.d1.r2.a.b) mvcHttpResponsedMessage.getData();
            if (aVar.f16831i != this.f16841i) {
                return;
            }
            int i2 = aVar.f16830h;
            if (i2 == 1) {
                b(bVar);
            } else if (i2 == 2) {
                d(bVar, aVar.f16827e);
            } else if (i2 != 3) {
            } else {
                c(bVar, aVar.f16829g);
            }
        }
    }
}
