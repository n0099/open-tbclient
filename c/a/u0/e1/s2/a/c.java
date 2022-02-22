package c.a.u0.e1.s2.a;

import androidx.core.view.InputDeviceCompat;
import c.a.t0.s.t.a;
import c.a.u0.a4.j;
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
import com.baidu.tieba.frs.profession.permission.FrsProfessionPermissionModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f17083e;

    /* renamed from: f  reason: collision with root package name */
    public FrsProfessionPermissionModel f17084f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.u0.e1.s2.a.a f17085g;

    /* renamed from: h  reason: collision with root package name */
    public d f17086h;

    /* renamed from: i  reason: collision with root package name */
    public int f17087i;

    /* loaded from: classes8.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17088e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.s.t.a f17089f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f17090g;

        public a(c cVar, String str, c.a.t0.s.t.a aVar) {
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
            this.f17090g = cVar;
            this.f17088e = str;
            this.f17089f = aVar;
        }

        @Override // c.a.t0.s.t.a.e
        public void onClick(c.a.t0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.f17090g.f17083e.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.f17088e);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.f17089f.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.s.t.a f17091e;

        public b(c cVar, c.a.t0.s.t.a aVar) {
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
            this.f17091e = aVar;
        }

        @Override // c.a.t0.s.t.a.e
        public void onClick(c.a.t0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f17091e.dismiss();
            }
        }
    }

    /* renamed from: c.a.u0.e1.s2.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1074c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.s.t.a f17092e;

        public C1074c(c cVar, c.a.t0.s.t.a aVar) {
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
            this.f17092e = aVar;
        }

        @Override // c.a.t0.s.t.a.e
        public void onClick(c.a.t0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f17092e.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
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
        this.f17083e = tbPageContext;
        c.a.u0.e1.s2.a.a aVar = new c.a.u0.e1.s2.a.a();
        this.f17085g = aVar;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, aVar);
        this.f17084f = frsProfessionPermissionModel;
        frsProfessionPermissionModel.Y(this);
    }

    public final void b(c.a.u0.e1.s2.a.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) && bVar != null && bVar.f17079f == 0) {
            if (!bVar.f17078e && bVar.f17081h == 2) {
                m(bVar.f17082i);
            }
            d dVar = this.f17086h;
            if (dVar != null) {
                dVar.c(bVar.f17078e);
            }
        }
    }

    public final void c(c.a.u0.e1.s2.a.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str) == null) || bVar == null) {
            return;
        }
        if (bVar.f17079f != 0) {
            if (StringUtils.isNull(bVar.f17080g)) {
                this.f17083e.showToast(j.neterror);
                return;
            } else {
                this.f17083e.showToast(bVar.f17080g);
                return;
            }
        }
        if (!bVar.f17078e) {
            int i2 = bVar.f17081h;
            if (i2 == 1) {
                l(bVar.f17082i, str);
            } else if (i2 == 3) {
                m(bVar.f17082i);
            }
        }
        d dVar = this.f17086h;
        if (dVar != null) {
            dVar.b(bVar.f17078e);
        }
    }

    public final void d(c.a.u0.e1.s2.a.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bVar, i2) == null) || bVar == null) {
            return;
        }
        if (bVar.f17079f != 0) {
            if (StringUtils.isNull(bVar.f17080g)) {
                this.f17083e.showToast(j.neterror);
                return;
            } else {
                this.f17083e.showToast(bVar.f17080g);
                return;
            }
        }
        d dVar = this.f17086h;
        if (dVar != null) {
            dVar.a(bVar.f17078e, i2);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f17084f.Q()) {
            return;
        }
        this.f17084f.loadData();
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            c.a.u0.e1.s2.a.a aVar = this.f17085g;
            aVar.f17076h = 1;
            aVar.f17075g = str;
            e();
        }
    }

    public void g(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, str, j2) == null) {
            c.a.u0.e1.s2.a.a aVar = this.f17085g;
            aVar.f17075g = str;
            aVar.f17074f = j2;
            aVar.f17076h = 3;
            e();
        }
    }

    public void h(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
            c.a.u0.e1.s2.a.a aVar = this.f17085g;
            aVar.f17073e = i2;
            aVar.f17075g = str;
            aVar.f17076h = 2;
            e();
        }
    }

    public void i(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.f17086h = dVar;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f17087i = i2;
            this.f17085g.f17077i = i2;
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048585, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof c.a.u0.e1.s2.a.a) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof c.a.u0.e1.s2.a.b)) {
            c.a.u0.e1.s2.a.a aVar = (c.a.u0.e1.s2.a.a) mvcNetMessage.getRequestData();
            c.a.u0.e1.s2.a.b bVar = (c.a.u0.e1.s2.a.b) mvcSocketResponsedMessage.getData();
            if (aVar.f17077i != this.f17087i) {
                return;
            }
            int i2 = aVar.f17076h;
            if (i2 == 1) {
                b(bVar);
            } else if (i2 == 2) {
                d(bVar, aVar.f17073e);
            } else if (i2 != 3) {
            } else {
                c(bVar, aVar.f17075g);
            }
        }
    }

    public final void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            c.a.t0.s.t.a aVar = new c.a.t0.s.t.a(this.f17083e.getPageActivity());
            aVar.setCanceledOnTouchOutside(false);
            aVar.setCancelable(false);
            aVar.setMessage(str);
            aVar.setPositiveButton(j.comfirm_imediate, new a(this, str2, aVar));
            aVar.setNegativeButton(j.comfirm_cancel, new b(this, aVar));
            aVar.create(this.f17083e);
            aVar.show();
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            c.a.t0.s.t.a aVar = new c.a.t0.s.t.a(this.f17083e.getPageActivity());
            aVar.setCanceledOnTouchOutside(false);
            aVar.setCancelable(false);
            aVar.setMessage(str);
            aVar.setNegativeButton(j.know, new C1074c(this, aVar));
            aVar.create(this.f17083e);
            aVar.show();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof c.a.u0.e1.s2.a.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof c.a.u0.e1.s2.a.b)) {
            c.a.u0.e1.s2.a.a aVar = (c.a.u0.e1.s2.a.a) mvcNetMessage.getRequestData();
            c.a.u0.e1.s2.a.b bVar = (c.a.u0.e1.s2.a.b) mvcHttpResponsedMessage.getData();
            if (aVar.f17077i != this.f17087i) {
                return;
            }
            int i2 = aVar.f17076h;
            if (i2 == 1) {
                b(bVar);
            } else if (i2 == 2) {
                d(bVar, aVar.f17073e);
            } else if (i2 != 3) {
            } else {
                c(bVar, aVar.f17075g);
            }
        }
    }
}
