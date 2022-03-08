package c.a.r0.d1.i2.a;

import androidx.core.view.InputDeviceCompat;
import c.a.q0.r.t.a;
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
/* loaded from: classes2.dex */
public class c implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f15674e;

    /* renamed from: f  reason: collision with root package name */
    public FrsProfessionPermissionModel f15675f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.d1.i2.a.a f15676g;

    /* renamed from: h  reason: collision with root package name */
    public d f15677h;

    /* renamed from: i  reason: collision with root package name */
    public int f15678i;

    /* loaded from: classes2.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f15679e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.r.t.a f15680f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f15681g;

        public a(c cVar, String str, c.a.q0.r.t.a aVar) {
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
            this.f15681g = cVar;
            this.f15679e = str;
            this.f15680f = aVar;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.f15681g.f15674e.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.f15679e);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.f15680f.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.r.t.a f15682e;

        public b(c cVar, c.a.q0.r.t.a aVar) {
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
            this.f15682e = aVar;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f15682e.dismiss();
            }
        }
    }

    /* renamed from: c.a.r0.d1.i2.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1005c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.r.t.a f15683e;

        public C1005c(c cVar, c.a.q0.r.t.a aVar) {
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
            this.f15683e = aVar;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f15683e.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
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
        this.f15674e = tbPageContext;
        c.a.r0.d1.i2.a.a aVar = new c.a.r0.d1.i2.a.a();
        this.f15676g = aVar;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, aVar);
        this.f15675f = frsProfessionPermissionModel;
        frsProfessionPermissionModel.Y(this);
    }

    public final void b(c.a.r0.d1.i2.a.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) && bVar != null && bVar.f15670f == 0) {
            if (!bVar.f15669e && bVar.f15672h == 2) {
                m(bVar.f15673i);
            }
            d dVar = this.f15677h;
            if (dVar != null) {
                dVar.c(bVar.f15669e);
            }
        }
    }

    public final void c(c.a.r0.d1.i2.a.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str) == null) || bVar == null) {
            return;
        }
        if (bVar.f15670f != 0) {
            if (StringUtils.isNull(bVar.f15671g)) {
                this.f15674e.showToast((int) R.string.neterror);
                return;
            } else {
                this.f15674e.showToast(bVar.f15671g);
                return;
            }
        }
        if (!bVar.f15669e) {
            int i2 = bVar.f15672h;
            if (i2 == 1) {
                l(bVar.f15673i, str);
            } else if (i2 == 3) {
                m(bVar.f15673i);
            }
        }
        d dVar = this.f15677h;
        if (dVar != null) {
            dVar.b(bVar.f15669e);
        }
    }

    public final void d(c.a.r0.d1.i2.a.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bVar, i2) == null) || bVar == null) {
            return;
        }
        if (bVar.f15670f != 0) {
            if (StringUtils.isNull(bVar.f15671g)) {
                this.f15674e.showToast((int) R.string.neterror);
                return;
            } else {
                this.f15674e.showToast(bVar.f15671g);
                return;
            }
        }
        d dVar = this.f15677h;
        if (dVar != null) {
            dVar.a(bVar.f15669e, i2);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f15675f.Q()) {
            return;
        }
        this.f15675f.loadData();
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            c.a.r0.d1.i2.a.a aVar = this.f15676g;
            aVar.f15667h = 1;
            aVar.f15666g = str;
            e();
        }
    }

    public void g(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, str, j2) == null) {
            c.a.r0.d1.i2.a.a aVar = this.f15676g;
            aVar.f15666g = str;
            aVar.f15665f = j2;
            aVar.f15667h = 3;
            e();
        }
    }

    public void h(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
            c.a.r0.d1.i2.a.a aVar = this.f15676g;
            aVar.f15664e = i2;
            aVar.f15666g = str;
            aVar.f15667h = 2;
            e();
        }
    }

    public void i(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.f15677h = dVar;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f15678i = i2;
            this.f15676g.f15668i = i2;
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048585, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof c.a.r0.d1.i2.a.a) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof c.a.r0.d1.i2.a.b)) {
            c.a.r0.d1.i2.a.a aVar = (c.a.r0.d1.i2.a.a) mvcNetMessage.getRequestData();
            c.a.r0.d1.i2.a.b bVar = (c.a.r0.d1.i2.a.b) mvcSocketResponsedMessage.getData();
            if (aVar.f15668i != this.f15678i) {
                return;
            }
            int i2 = aVar.f15667h;
            if (i2 == 1) {
                b(bVar);
            } else if (i2 == 2) {
                d(bVar, aVar.f15664e);
            } else if (i2 != 3) {
            } else {
                c(bVar, aVar.f15666g);
            }
        }
    }

    public final void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(this.f15674e.getPageActivity());
            aVar.setCanceledOnTouchOutside(false);
            aVar.setCancelable(false);
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.comfirm_imediate, new a(this, str2, aVar));
            aVar.setNegativeButton(R.string.comfirm_cancel, new b(this, aVar));
            aVar.create(this.f15674e);
            aVar.show();
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(this.f15674e.getPageActivity());
            aVar.setCanceledOnTouchOutside(false);
            aVar.setCancelable(false);
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new C1005c(this, aVar));
            aVar.create(this.f15674e);
            aVar.show();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof c.a.r0.d1.i2.a.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof c.a.r0.d1.i2.a.b)) {
            c.a.r0.d1.i2.a.a aVar = (c.a.r0.d1.i2.a.a) mvcNetMessage.getRequestData();
            c.a.r0.d1.i2.a.b bVar = (c.a.r0.d1.i2.a.b) mvcHttpResponsedMessage.getData();
            if (aVar.f15668i != this.f15678i) {
                return;
            }
            int i2 = aVar.f15667h;
            if (i2 == 1) {
                b(bVar);
            } else if (i2 == 2) {
                d(bVar, aVar.f15664e);
            } else if (i2 != 3) {
            } else {
                c(bVar, aVar.f15666g);
            }
        }
    }
}
