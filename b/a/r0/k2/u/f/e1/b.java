package b.a.r0.k2.u.f.e1;

import android.view.View;
import android.widget.LinearLayout;
import b.a.l.a;
import b.a.l.g0;
import b.a.l.o0;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.x0;
import b.a.r0.b0.d0;
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
public class b extends b.a.r0.k2.u.f.e1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f20749f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.s.q.a f20750g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f20751h;

    /* renamed from: i  reason: collision with root package name */
    public o0 f20752i;
    public d2 j;

    /* loaded from: classes5.dex */
    public class a extends b.a.q0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20753e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20753e = bVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20753e.j : (d2) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, b.a.e.m.e.n
        public BdUniqueId getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (BdUniqueId) invokeV.objValue;
        }
    }

    /* renamed from: b.a.r0.k2.u.f.e1.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1035b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20754e;

        public View$OnClickListenerC1035b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20754e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar;
            a.InterfaceC0090a interfaceC0090a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0090a = (bVar = this.f20754e).f20746c) == null) {
                return;
            }
            interfaceC0090a.a(bVar.f20750g);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext, int i2) {
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

    @Override // b.a.r0.k2.u.f.e1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f20749f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f20744a.getPageActivity());
                this.f20749f = linearLayout;
                SkinManager.setBackgroundColor(linearLayout, b.a.r0.k2.f.CAM_X0206);
                this.f20749f.setOrientation(1);
                this.f20749f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f20749f.removeAllViews();
            if (this.f20751h == null) {
                g0 g0Var = new g0(this.f20744a);
                this.f20751h = g0Var;
                g0Var.m(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_H_X005);
            layoutParams.leftMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_W_X007);
            layoutParams.rightMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_W_X007);
            this.f20749f.addView(this.f20751h.f(), layoutParams);
            if (this.f20752i == null) {
                this.f20752i = new o0(this.f20744a.getPageActivity());
            }
            this.f20749f.addView(this.f20752i.f());
            return this.f20749f;
        }
        return (View) invokeV.objValue;
    }

    @Override // b.a.r0.k2.u.f.e1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f20748e == i2) {
            return;
        }
        this.f20748e = i2;
        SkinManager.setBackgroundColor(this.f20749f, b.a.r0.k2.f.CAM_X0206);
        g0 g0Var = this.f20751h;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        o0 o0Var = this.f20752i;
        if (o0Var != null) {
            o0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // b.a.r0.k2.u.f.e1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f20747d = originalThreadInfo;
            this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f20750g = aVar;
            o0 o0Var = this.f20752i;
            if (o0Var != null) {
                o0Var.onBindDataToView(aVar);
            }
            g0 g0Var = this.f20751h;
            if (g0Var != null) {
                g0Var.onBindDataToView(this.f20750g);
            }
        }
    }

    @Override // b.a.r0.k2.u.f.e1.a
    public void d(a.InterfaceC0090a interfaceC0090a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0090a) == null) {
            super.d(interfaceC0090a);
            o0 o0Var = this.f20752i;
            if (o0Var != null) {
                o0Var.t(interfaceC0090a);
            }
            g0 g0Var = this.f20751h;
            if (g0Var != null) {
                g0Var.v(interfaceC0090a);
            }
            LinearLayout linearLayout = this.f20749f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new View$OnClickListenerC1035b(this));
            }
        }
    }

    @Override // b.a.r0.k2.u.f.e1.a
    public void e(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d0Var) == null) {
            super.e(d0Var);
            o0 o0Var = this.f20752i;
            if (o0Var != null) {
                o0Var.k(this.f20745b);
            }
        }
    }
}
