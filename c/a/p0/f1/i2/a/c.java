package c.a.p0.f1.i2.a;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.t.a;
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
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public FrsProfessionPermissionModel f14099b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.f1.i2.a.a f14100c;

    /* renamed from: d  reason: collision with root package name */
    public d f14101d;

    /* renamed from: e  reason: collision with root package name */
    public int f14102e;

    /* loaded from: classes2.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.r.t.a f14103b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f14104c;

        public a(c cVar, String str, c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14104c = cVar;
            this.a = str;
            this.f14103b = aVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.f14104c.a.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.f14103b.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.a a;

        public b(c cVar, c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.dismiss();
            }
        }
    }

    /* renamed from: c.a.p0.f1.i2.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1064c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.a a;

        public C1064c(c cVar, c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(boolean z, int i);

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        c.a.p0.f1.i2.a.a aVar = new c.a.p0.f1.i2.a.a();
        this.f14100c = aVar;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, aVar);
        this.f14099b = frsProfessionPermissionModel;
        frsProfessionPermissionModel.a0(this);
    }

    public final void b(c.a.p0.f1.i2.a.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) && bVar != null && bVar.f14095b == 0) {
            if (!bVar.a && bVar.f14097d == 2) {
                l(bVar.f14098e);
            }
            d dVar = this.f14101d;
            if (dVar != null) {
                dVar.c(bVar.a);
            }
        }
    }

    public final void c(c.a.p0.f1.i2.a.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str) == null) || bVar == null) {
            return;
        }
        if (bVar.f14095b != 0) {
            if (StringUtils.isNull(bVar.f14096c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c15);
                return;
            } else {
                this.a.showToast(bVar.f14096c);
                return;
            }
        }
        if (!bVar.a) {
            int i = bVar.f14097d;
            if (i == 1) {
                k(bVar.f14098e, str);
            } else if (i == 3) {
                l(bVar.f14098e);
            }
        }
        d dVar = this.f14101d;
        if (dVar != null) {
            dVar.b(bVar.a);
        }
    }

    public final void d(c.a.p0.f1.i2.a.b bVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bVar, i) == null) || bVar == null) {
            return;
        }
        if (bVar.f14095b != 0) {
            if (StringUtils.isNull(bVar.f14096c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c15);
                return;
            } else {
                this.a.showToast(bVar.f14096c);
                return;
            }
        }
        d dVar = this.f14101d;
        if (dVar != null) {
            dVar.a(bVar.a, i);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f14099b.S()) {
            return;
        }
        this.f14099b.loadData();
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            c.a.p0.f1.i2.a.a aVar = this.f14100c;
            aVar.f14093d = 1;
            aVar.f14092c = str;
            e();
        }
    }

    public void g(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, str, j) == null) {
            c.a.p0.f1.i2.a.a aVar = this.f14100c;
            aVar.f14092c = str;
            aVar.f14091b = j;
            aVar.f14093d = 3;
            e();
        }
    }

    public void h(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
            c.a.p0.f1.i2.a.a aVar = this.f14100c;
            aVar.a = i;
            aVar.f14092c = str;
            aVar.f14093d = 2;
            e();
        }
    }

    public void i(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.f14101d = dVar;
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f14102e = i;
            this.f14100c.f14094e = i;
        }
    }

    public final void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getPageActivity());
            aVar.setCanceledOnTouchOutside(false);
            aVar.setCancelable(false);
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f03f3, new a(this, str2, aVar));
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f03f2, new b(this, aVar));
            aVar.create(this.a);
            aVar.show();
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getPageActivity());
            aVar.setCanceledOnTouchOutside(false);
            aVar.setCancelable(false);
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f0984, new C1064c(this, aVar));
            aVar.create(this.a);
            aVar.show();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void m(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048587, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof c.a.p0.f1.i2.a.a) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof c.a.p0.f1.i2.a.b)) {
            c.a.p0.f1.i2.a.a aVar = (c.a.p0.f1.i2.a.a) mvcNetMessage.getRequestData();
            c.a.p0.f1.i2.a.b bVar = (c.a.p0.f1.i2.a.b) mvcSocketResponsedMessage.getData();
            if (aVar.f14094e != this.f14102e) {
                return;
            }
            int i = aVar.f14093d;
            if (i == 1) {
                b(bVar);
            } else if (i == 2) {
                d(bVar, aVar.a);
            } else if (i != 3) {
            } else {
                c(bVar, aVar.f14092c);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void r(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof c.a.p0.f1.i2.a.a) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof c.a.p0.f1.i2.a.b)) {
            c.a.p0.f1.i2.a.a aVar = (c.a.p0.f1.i2.a.a) mvcNetMessage.getRequestData();
            c.a.p0.f1.i2.a.b bVar = (c.a.p0.f1.i2.a.b) mvcHttpResponsedMessage.getData();
            if (aVar.f14094e != this.f14102e) {
                return;
            }
            int i = aVar.f14093d;
            if (i == 1) {
                b(bVar);
            } else if (i == 2) {
                d(bVar, aVar.a);
            } else if (i != 3) {
            } else {
                c(bVar, aVar.f14092c);
            }
        }
    }
}
