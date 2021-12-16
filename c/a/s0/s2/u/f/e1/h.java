package c.a.s0.s2.u.f.e1;

import android.view.View;
import c.a.l.a;
import c.a.l.o;
import c.a.r0.s.r.d2;
import c.a.r0.s.r.x0;
import c.a.s0.g0.d0;
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
public class h extends c.a.s0.s2.u.f.e1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public d2 f22975f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.s.r.a f22976g;

    /* renamed from: h  reason: collision with root package name */
    public o f22977h;

    /* renamed from: i  reason: collision with root package name */
    public View f22978i;

    /* loaded from: classes8.dex */
    public class a extends c.a.r0.s.r.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f22979e;

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
            this.f22979e = hVar;
        }

        @Override // c.a.r0.s.r.a
        public x0 getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (x0) invokeV.objValue;
        }

        @Override // c.a.r0.s.r.a
        public d2 getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22979e.f22975f : (d2) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.m.e.n
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
        public final /* synthetic */ h f22980e;

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
            this.f22980e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar;
            a.InterfaceC0163a interfaceC0163a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0163a = (hVar = this.f22980e).f22937c) == null) {
                return;
            }
            interfaceC0163a.a(hVar.f22976g);
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

    @Override // c.a.s0.s2.u.f.e1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f22977h == null) {
                o oVar = new o(this.a.getPageActivity());
                this.f22977h = oVar;
                oVar.m(Boolean.TRUE);
                this.f22977h.w("pb");
                this.f22977h.y(0);
                this.f22977h.D(this.a.getResources().getDimensionPixelOffset(c.a.s0.s2.g.M_W_X007), this.a.getResources().getDimensionPixelOffset(c.a.s0.s2.g.M_H_X005), this.a.getResources().getDimensionPixelOffset(c.a.s0.s2.g.M_W_X007), this.a.getResources().getDimensionPixelSize(c.a.s0.s2.g.M_H_X005));
                this.f22977h.E(false);
                this.f22977h.C(true);
            }
            View f2 = this.f22977h.f();
            this.f22978i = f2;
            return f2;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.s0.s2.u.f.e1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f22939e == i2) {
            return;
        }
        this.f22939e = i2;
        SkinManager.setBackgroundColor(this.f22978i, c.a.s0.s2.f.CAM_X0204);
        o oVar = this.f22977h;
        if (oVar != null) {
            oVar.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // c.a.s0.s2.u.f.e1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f22938d = originalThreadInfo;
            this.f22975f = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f22976g = aVar;
            o oVar = this.f22977h;
            if (oVar != null) {
                oVar.onBindDataToView(aVar);
            }
        }
    }

    @Override // c.a.s0.s2.u.f.e1.a
    public void d(a.InterfaceC0163a interfaceC0163a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0163a) == null) {
            super.d(interfaceC0163a);
            o oVar = this.f22977h;
            if (oVar != null) {
                oVar.z(interfaceC0163a);
            }
            View view = this.f22978i;
            if (view != null) {
                view.setOnClickListener(new b(this));
            }
        }
    }

    @Override // c.a.s0.s2.u.f.e1.a
    public void e(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d0Var) == null) {
            super.e(d0Var);
            o oVar = this.f22977h;
            if (oVar != null) {
                oVar.k(this.f22936b);
            }
        }
    }
}
