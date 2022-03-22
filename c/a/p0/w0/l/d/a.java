package c.a.p0.w0.l.d;

import c.a.d.a.e;
import c.a.d.f.p.n;
import c.a.p0.a4.i0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LikeModel a;

    /* renamed from: b  reason: collision with root package name */
    public i0 f19476b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f19477c;

    /* renamed from: d  reason: collision with root package name */
    public b f19478d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1471a f19479e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f19480f;

    /* renamed from: c.a.p0.w0.l.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC1471a {
        void a(String str, long j);

        void b(String str, long j);

        void c(Object obj);
    }

    /* loaded from: classes2.dex */
    public class b extends e implements i0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public InterfaceC1471a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f19481b;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19481b = aVar;
        }

        @Override // c.a.p0.a4.i0.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.f19481b.f19477c = false;
                n.N(this.f19481b.f19480f.getPageActivity(), this.f19481b.a.getErrorString());
                InterfaceC1471a interfaceC1471a = this.a;
                if (interfaceC1471a != null) {
                    interfaceC1471a.b(str, j);
                }
            }
        }

        @Override // c.a.p0.a4.i0.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.f19481b.f19477c = false;
                InterfaceC1471a interfaceC1471a = this.a;
                if (interfaceC1471a != null) {
                    interfaceC1471a.a(str, j);
                }
            }
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                this.f19481b.f19477c = false;
                if (this.f19481b.a.getErrorCode() == 22) {
                    n.N(this.f19481b.f19480f.getPageActivity(), this.f19481b.f19480f.getString(R.string.obfuscated_res_0x7f0f0802));
                } else if (obj == null) {
                } else {
                    if (this.f19481b.a.getErrorCode() != 0) {
                        n.N(this.f19481b.f19480f.getPageActivity(), this.f19481b.a.getErrorString());
                        return;
                    }
                    InterfaceC1471a interfaceC1471a = this.a;
                    if (interfaceC1471a != null) {
                        interfaceC1471a.c(obj);
                    }
                }
            }
        }

        public void d(InterfaceC1471a interfaceC1471a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC1471a) == null) {
                this.a = interfaceC1471a;
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final boolean d(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tbPageContext)) == null) {
            if (n.C()) {
                return ViewHelper.checkUpIsLogin(tbPageContext.getPageActivity());
            }
            UtilHelper.showToast(tbPageContext.getPageActivity(), tbPageContext.getString(R.string.obfuscated_res_0x7f0f0c15));
            return false;
        }
        return invokeL.booleanValue;
    }

    public void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && !this.f19477c && d(this.f19480f)) {
            if (this.f19478d == null) {
                b bVar = new b(this);
                this.f19478d = bVar;
                bVar.d(this.f19479e);
            }
            if (this.a == null) {
                LikeModel likeModel = new LikeModel(this.f19480f);
                this.a = likeModel;
                likeModel.setLoadDataCallBack(this.f19478d);
            }
            this.f19477c = true;
            this.a.P(str, str2);
        }
    }

    public void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && !this.f19477c && d(this.f19480f)) {
            if (this.f19478d == null) {
                b bVar = new b(this);
                this.f19478d = bVar;
                bVar.d(this.f19479e);
            }
            if (this.f19476b == null) {
                i0 i0Var = new i0();
                this.f19476b = i0Var;
                i0Var.b(this.f19478d);
            }
            long g2 = c.a.d.f.m.b.g(str2, -1L);
            if (g2 == -1) {
                return;
            }
            this.f19477c = true;
            this.f19476b.c(str, g2);
        }
    }

    public void g(InterfaceC1471a interfaceC1471a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC1471a) == null) {
            this.f19479e = interfaceC1471a;
        }
    }

    public void h(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
            this.f19480f = tbPageContext;
        }
    }
}
