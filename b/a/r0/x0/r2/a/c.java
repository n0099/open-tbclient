package b.a.r0.x0.r2.a;

import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.s.a;
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
/* loaded from: classes6.dex */
public class c implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f27823e;

    /* renamed from: f  reason: collision with root package name */
    public FrsProfessionPermissionModel f27824f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.x0.r2.a.a f27825g;

    /* renamed from: h  reason: collision with root package name */
    public d f27826h;

    /* renamed from: i  reason: collision with root package name */
    public int f27827i;

    /* loaded from: classes6.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f27828e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f27829f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f27830g;

        public a(c cVar, String str, b.a.q0.s.s.a aVar) {
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
            this.f27830g = cVar;
            this.f27828e = str;
            this.f27829f = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.f27830g.f27823e.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.f27828e);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.f27829f.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f27831e;

        public b(c cVar, b.a.q0.s.s.a aVar) {
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
            this.f27831e = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f27831e.dismiss();
            }
        }
    }

    /* renamed from: b.a.r0.x0.r2.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1360c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f27832e;

        public C1360c(c cVar, b.a.q0.s.s.a aVar) {
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
            this.f27832e = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f27832e.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
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
        this.f27823e = tbPageContext;
        b.a.r0.x0.r2.a.a aVar = new b.a.r0.x0.r2.a.a();
        this.f27825g = aVar;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, aVar);
        this.f27824f = frsProfessionPermissionModel;
        frsProfessionPermissionModel.Y(this);
    }

    public final void b(b.a.r0.x0.r2.a.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) && bVar != null && bVar.f27819f == 0) {
            if (!bVar.f27818e && bVar.f27821h == 2) {
                m(bVar.f27822i);
            }
            d dVar = this.f27826h;
            if (dVar != null) {
                dVar.c(bVar.f27818e);
            }
        }
    }

    public final void c(b.a.r0.x0.r2.a.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str) == null) || bVar == null) {
            return;
        }
        if (bVar.f27819f != 0) {
            if (StringUtils.isNull(bVar.f27820g)) {
                this.f27823e.showToast(R.string.neterror);
                return;
            } else {
                this.f27823e.showToast(bVar.f27820g);
                return;
            }
        }
        if (!bVar.f27818e) {
            int i2 = bVar.f27821h;
            if (i2 == 1) {
                l(bVar.f27822i, str);
            } else if (i2 == 3) {
                m(bVar.f27822i);
            }
        }
        d dVar = this.f27826h;
        if (dVar != null) {
            dVar.b(bVar.f27818e);
        }
    }

    public final void d(b.a.r0.x0.r2.a.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bVar, i2) == null) || bVar == null) {
            return;
        }
        if (bVar.f27819f != 0) {
            if (StringUtils.isNull(bVar.f27820g)) {
                this.f27823e.showToast(R.string.neterror);
                return;
            } else {
                this.f27823e.showToast(bVar.f27820g);
                return;
            }
        }
        d dVar = this.f27826h;
        if (dVar != null) {
            dVar.a(bVar.f27818e, i2);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f27824f.Q()) {
            return;
        }
        this.f27824f.loadData();
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            b.a.r0.x0.r2.a.a aVar = this.f27825g;
            aVar.f27816h = 1;
            aVar.f27815g = str;
            e();
        }
    }

    public void g(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, str, j) == null) {
            b.a.r0.x0.r2.a.a aVar = this.f27825g;
            aVar.f27815g = str;
            aVar.f27814f = j;
            aVar.f27816h = 3;
            e();
        }
    }

    public void h(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
            b.a.r0.x0.r2.a.a aVar = this.f27825g;
            aVar.f27813e = i2;
            aVar.f27815g = str;
            aVar.f27816h = 2;
            e();
        }
    }

    public void i(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.f27826h = dVar;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f27827i = i2;
            this.f27825g.f27817i = i2;
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048585, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof b.a.r0.x0.r2.a.a) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof b.a.r0.x0.r2.a.b)) {
            b.a.r0.x0.r2.a.a aVar = (b.a.r0.x0.r2.a.a) mvcNetMessage.getRequestData();
            b.a.r0.x0.r2.a.b bVar = (b.a.r0.x0.r2.a.b) mvcSocketResponsedMessage.getData();
            if (aVar.f27817i != this.f27827i) {
                return;
            }
            int i2 = aVar.f27816h;
            if (i2 == 1) {
                b(bVar);
            } else if (i2 == 2) {
                d(bVar, aVar.f27813e);
            } else if (i2 != 3) {
            } else {
                c(bVar, aVar.f27815g);
            }
        }
    }

    public final void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f27823e.getPageActivity());
            aVar.setCanceledOnTouchOutside(false);
            aVar.setCancelable(false);
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.comfirm_imediate, new a(this, str2, aVar));
            aVar.setNegativeButton(R.string.comfirm_cancel, new b(this, aVar));
            aVar.create(this.f27823e);
            aVar.show();
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f27823e.getPageActivity());
            aVar.setCanceledOnTouchOutside(false);
            aVar.setCancelable(false);
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new C1360c(this, aVar));
            aVar.create(this.f27823e);
            aVar.show();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof b.a.r0.x0.r2.a.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof b.a.r0.x0.r2.a.b)) {
            b.a.r0.x0.r2.a.a aVar = (b.a.r0.x0.r2.a.a) mvcNetMessage.getRequestData();
            b.a.r0.x0.r2.a.b bVar = (b.a.r0.x0.r2.a.b) mvcHttpResponsedMessage.getData();
            if (aVar.f27817i != this.f27827i) {
                return;
            }
            int i2 = aVar.f27816h;
            if (i2 == 1) {
                b(bVar);
            } else if (i2 == 2) {
                d(bVar, aVar.f27813e);
            } else if (i2 != 3) {
            } else {
                c(bVar, aVar.f27815g);
            }
        }
    }
}
