package b.a.r0.k2.u.f.d1;

import android.view.View;
import b.a.l.a;
import b.a.l.o;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.x0;
import b.a.r0.b0.c0;
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
/* loaded from: classes5.dex */
public class h extends b.a.r0.k2.u.f.d1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public d2 f19214f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.s.q.a f19215g;

    /* renamed from: h  reason: collision with root package name */
    public o f19216h;

    /* renamed from: i  reason: collision with root package name */
    public View f19217i;

    /* loaded from: classes5.dex */
    public class a extends b.a.q0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f19218e;

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
            this.f19218e = hVar;
        }

        @Override // b.a.q0.s.q.a
        public x0 getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (x0) invokeV.objValue;
        }

        @Override // b.a.q0.s.q.a
        public d2 getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19218e.f19214f : (d2) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, b.a.e.l.e.n
        public BdUniqueId getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (BdUniqueId) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f19219e;

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
            this.f19219e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar;
            a.InterfaceC0088a interfaceC0088a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0088a = (hVar = this.f19219e).f19180c) == null) {
                return;
            }
            interfaceC0088a.a(hVar.f19215g);
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

    @Override // b.a.r0.k2.u.f.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f19216h == null) {
                o oVar = new o(this.f19178a.getPageActivity());
                this.f19216h = oVar;
                oVar.m(Boolean.TRUE);
                this.f19216h.w("pb");
                this.f19216h.y(0);
                this.f19216h.D(this.f19178a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_W_X007), this.f19178a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_H_X005), this.f19178a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_W_X007), this.f19178a.getResources().getDimensionPixelSize(b.a.r0.k2.g.M_H_X005));
                this.f19216h.E(false);
                this.f19216h.C(true);
            }
            View f2 = this.f19216h.f();
            this.f19217i = f2;
            return f2;
        }
        return (View) invokeV.objValue;
    }

    @Override // b.a.r0.k2.u.f.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f19182e == i2) {
            return;
        }
        this.f19182e = i2;
        SkinManager.setBackgroundColor(this.f19217i, b.a.r0.k2.f.CAM_X0204);
        o oVar = this.f19216h;
        if (oVar != null) {
            oVar.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // b.a.r0.k2.u.f.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f19181d = originalThreadInfo;
            this.f19214f = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f19215g = aVar;
            o oVar = this.f19216h;
            if (oVar != null) {
                oVar.onBindDataToView(aVar);
            }
        }
    }

    @Override // b.a.r0.k2.u.f.d1.a
    public void d(a.InterfaceC0088a interfaceC0088a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0088a) == null) {
            super.d(interfaceC0088a);
            o oVar = this.f19216h;
            if (oVar != null) {
                oVar.z(interfaceC0088a);
            }
            View view = this.f19217i;
            if (view != null) {
                view.setOnClickListener(new b(this));
            }
        }
    }

    @Override // b.a.r0.k2.u.f.d1.a
    public void e(c0 c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, c0Var) == null) {
            super.e(c0Var);
            o oVar = this.f19216h;
            if (oVar != null) {
                oVar.k(this.f19179b);
            }
        }
    }
}
