package c.a.t0.t2.u.f.f1;

import android.view.View;
import c.a.l.a;
import c.a.l.o;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.x0;
import c.a.t0.g0.d0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class h extends c.a.t0.t2.u.f.f1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public e2 f23137f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.s0.s.q.a f23138g;

    /* renamed from: h  reason: collision with root package name */
    public o f23139h;

    /* renamed from: i  reason: collision with root package name */
    public View f23140i;

    /* loaded from: classes8.dex */
    public class a extends c.a.s0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f23141e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23141e = hVar;
        }

        @Override // c.a.s0.s.q.a
        public x0 getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (x0) invokeV.objValue;
        }

        @Override // c.a.s0.s.q.a
        public e2 getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23141e.f23137f : (e2) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.n.e.n
        public BdUniqueId getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (BdUniqueId) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f23142e;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23142e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar;
            a.InterfaceC0202a interfaceC0202a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0202a = (hVar = this.f23142e).f23100c) == null) {
                return;
            }
            interfaceC0202a.a(hVar.f23138g);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.t0.t2.u.f.f1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f23139h == null) {
                o oVar = new o(this.a.getPageActivity());
                this.f23139h = oVar;
                oVar.m(Boolean.TRUE);
                this.f23139h.w("pb");
                this.f23139h.y(0);
                this.f23139h.D(this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_W_X007), this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_H_X005), this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_W_X007), this.a.getResources().getDimensionPixelSize(c.a.t0.t2.g.M_H_X005));
                this.f23139h.E(false);
                this.f23139h.C(true);
            }
            View f2 = this.f23139h.f();
            this.f23140i = f2;
            return f2;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.t0.t2.u.f.f1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f23102e == i2) {
            return;
        }
        this.f23102e = i2;
        SkinManager.setBackgroundColor(this.f23140i, c.a.t0.t2.f.CAM_X0204);
        o oVar = this.f23139h;
        if (oVar != null) {
            oVar.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // c.a.t0.t2.u.f.f1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f23101d = originalThreadInfo;
            this.f23137f = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f23138g = aVar;
            o oVar = this.f23139h;
            if (oVar != null) {
                oVar.onBindDataToView(aVar);
            }
        }
    }

    @Override // c.a.t0.t2.u.f.f1.a
    public void d(a.InterfaceC0202a interfaceC0202a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0202a) == null) {
            super.d(interfaceC0202a);
            o oVar = this.f23139h;
            if (oVar != null) {
                oVar.z(interfaceC0202a);
            }
            View view = this.f23140i;
            if (view != null) {
                view.setOnClickListener(new b(this));
            }
        }
    }

    @Override // c.a.t0.t2.u.f.f1.a
    public void e(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d0Var) == null) {
            super.e(d0Var);
            o oVar = this.f23139h;
            if (oVar != null) {
                oVar.k(this.f23099b);
            }
        }
    }
}
