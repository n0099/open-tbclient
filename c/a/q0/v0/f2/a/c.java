package c.a.q0.v0.f2.a;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.s.a;
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
/* loaded from: classes4.dex */
public class c implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f26071e;

    /* renamed from: f  reason: collision with root package name */
    public FrsProfessionPermissionModel f26072f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.v0.f2.a.a f26073g;

    /* renamed from: h  reason: collision with root package name */
    public d f26074h;

    /* renamed from: i  reason: collision with root package name */
    public int f26075i;

    /* loaded from: classes4.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f26076e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.s.s.a f26077f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f26078g;

        public a(c cVar, String str, c.a.p0.s.s.a aVar) {
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
            this.f26078g = cVar;
            this.f26076e = str;
            this.f26077f = aVar;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.f26078g.f26071e.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.f26076e);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.f26077f.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.s.s.a f26079e;

        public b(c cVar, c.a.p0.s.s.a aVar) {
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
            this.f26079e = aVar;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f26079e.dismiss();
            }
        }
    }

    /* renamed from: c.a.q0.v0.f2.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1218c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.s.s.a f26080e;

        public C1218c(c cVar, c.a.p0.s.s.a aVar) {
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
            this.f26080e = aVar;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f26080e.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
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
        this.f26071e = tbPageContext;
        c.a.q0.v0.f2.a.a aVar = new c.a.q0.v0.f2.a.a();
        this.f26073g = aVar;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, aVar);
        this.f26072f = frsProfessionPermissionModel;
        frsProfessionPermissionModel.Z(this);
    }

    public final void b(c.a.q0.v0.f2.a.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) && bVar != null && bVar.f26067f == 0) {
            if (!bVar.f26066e && bVar.f26069h == 2) {
                m(bVar.f26070i);
            }
            d dVar = this.f26074h;
            if (dVar != null) {
                dVar.c(bVar.f26066e);
            }
        }
    }

    public final void c(c.a.q0.v0.f2.a.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str) == null) || bVar == null) {
            return;
        }
        if (bVar.f26067f != 0) {
            if (StringUtils.isNull(bVar.f26068g)) {
                this.f26071e.showToast(R.string.neterror);
                return;
            } else {
                this.f26071e.showToast(bVar.f26068g);
                return;
            }
        }
        if (!bVar.f26066e) {
            int i2 = bVar.f26069h;
            if (i2 == 1) {
                l(bVar.f26070i, str);
            } else if (i2 == 3) {
                m(bVar.f26070i);
            }
        }
        d dVar = this.f26074h;
        if (dVar != null) {
            dVar.b(bVar.f26066e);
        }
    }

    public final void d(c.a.q0.v0.f2.a.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bVar, i2) == null) || bVar == null) {
            return;
        }
        if (bVar.f26067f != 0) {
            if (StringUtils.isNull(bVar.f26068g)) {
                this.f26071e.showToast(R.string.neterror);
                return;
            } else {
                this.f26071e.showToast(bVar.f26068g);
                return;
            }
        }
        d dVar = this.f26074h;
        if (dVar != null) {
            dVar.a(bVar.f26066e, i2);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f26072f.Q()) {
            return;
        }
        this.f26072f.R();
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            c.a.q0.v0.f2.a.a aVar = this.f26073g;
            aVar.f26064h = 1;
            aVar.f26063g = str;
            e();
        }
    }

    public void g(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, str, j2) == null) {
            c.a.q0.v0.f2.a.a aVar = this.f26073g;
            aVar.f26063g = str;
            aVar.f26062f = j2;
            aVar.f26064h = 3;
            e();
        }
    }

    public void h(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
            c.a.q0.v0.f2.a.a aVar = this.f26073g;
            aVar.f26061e = i2;
            aVar.f26063g = str;
            aVar.f26064h = 2;
            e();
        }
    }

    public void i(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.f26074h = dVar;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f26075i = i2;
            this.f26073g.f26065i = i2;
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048585, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof c.a.q0.v0.f2.a.a) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof c.a.q0.v0.f2.a.b)) {
            c.a.q0.v0.f2.a.a aVar = (c.a.q0.v0.f2.a.a) mvcNetMessage.getRequestData();
            c.a.q0.v0.f2.a.b bVar = (c.a.q0.v0.f2.a.b) mvcSocketResponsedMessage.getData();
            if (aVar.f26065i != this.f26075i) {
                return;
            }
            int i2 = aVar.f26064h;
            if (i2 == 1) {
                b(bVar);
            } else if (i2 == 2) {
                d(bVar, aVar.f26061e);
            } else if (i2 != 3) {
            } else {
                c(bVar, aVar.f26063g);
            }
        }
    }

    public final void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f26071e.getPageActivity());
            aVar.setCanceledOnTouchOutside(false);
            aVar.setCancelable(false);
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.comfirm_imediate, new a(this, str2, aVar));
            aVar.setNegativeButton(R.string.comfirm_cancel, new b(this, aVar));
            aVar.create(this.f26071e);
            aVar.show();
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f26071e.getPageActivity());
            aVar.setCanceledOnTouchOutside(false);
            aVar.setCancelable(false);
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new C1218c(this, aVar));
            aVar.create(this.f26071e);
            aVar.show();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof c.a.q0.v0.f2.a.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof c.a.q0.v0.f2.a.b)) {
            c.a.q0.v0.f2.a.a aVar = (c.a.q0.v0.f2.a.a) mvcNetMessage.getRequestData();
            c.a.q0.v0.f2.a.b bVar = (c.a.q0.v0.f2.a.b) mvcHttpResponsedMessage.getData();
            if (aVar.f26065i != this.f26075i) {
                return;
            }
            int i2 = aVar.f26064h;
            if (i2 == 1) {
                b(bVar);
            } else if (i2 == 2) {
                d(bVar, aVar.f26061e);
            } else if (i2 != 3) {
            } else {
                c(bVar, aVar.f26063g);
            }
        }
    }
}
