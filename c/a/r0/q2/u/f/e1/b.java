package c.a.r0.q2.u.f.e1;

import android.view.View;
import android.widget.LinearLayout;
import c.a.k.a;
import c.a.k.g0;
import c.a.k.o0;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x0;
import c.a.r0.g0.d0;
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
/* loaded from: classes6.dex */
public class b extends c.a.r0.q2.u.f.e1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f21934f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.s.q.a f21935g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f21936h;

    /* renamed from: i  reason: collision with root package name */
    public o0 f21937i;

    /* renamed from: j  reason: collision with root package name */
    public d2 f21938j;

    /* loaded from: classes6.dex */
    public class a extends c.a.q0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21939e;

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
            this.f21939e = bVar;
        }

        @Override // c.a.q0.s.q.a
        public x0 getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (x0) invokeV.objValue;
        }

        @Override // c.a.q0.s.q.a
        public d2 getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21939e.f21938j : (d2) invokeV.objValue;
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

    /* renamed from: c.a.r0.q2.u.f.e1.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC1282b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21940e;

        public View$OnClickListenerC1282b(b bVar) {
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
            this.f21940e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar;
            a.InterfaceC0129a interfaceC0129a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0129a = (bVar = this.f21940e).f21931c) == null) {
                return;
            }
            interfaceC0129a.a(bVar.f21935g);
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

    @Override // c.a.r0.q2.u.f.e1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f21934f == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageActivity());
                this.f21934f = linearLayout;
                SkinManager.setBackgroundColor(linearLayout, c.a.r0.q2.f.CAM_X0206);
                this.f21934f.setOrientation(1);
                this.f21934f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f21934f.removeAllViews();
            if (this.f21936h == null) {
                g0 g0Var = new g0(this.a);
                this.f21936h = g0Var;
                g0Var.m(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_H_X005);
            layoutParams.leftMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_W_X007);
            layoutParams.rightMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_W_X007);
            this.f21934f.addView(this.f21936h.f(), layoutParams);
            if (this.f21937i == null) {
                this.f21937i = new o0(this.a.getPageActivity());
            }
            this.f21934f.addView(this.f21937i.f());
            return this.f21934f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.r0.q2.u.f.e1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f21933e == i2) {
            return;
        }
        this.f21933e = i2;
        SkinManager.setBackgroundColor(this.f21934f, c.a.r0.q2.f.CAM_X0206);
        g0 g0Var = this.f21936h;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        o0 o0Var = this.f21937i;
        if (o0Var != null) {
            o0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // c.a.r0.q2.u.f.e1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f21932d = originalThreadInfo;
            this.f21938j = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f21935g = aVar;
            o0 o0Var = this.f21937i;
            if (o0Var != null) {
                o0Var.onBindDataToView(aVar);
            }
            g0 g0Var = this.f21936h;
            if (g0Var != null) {
                g0Var.onBindDataToView(this.f21935g);
            }
        }
    }

    @Override // c.a.r0.q2.u.f.e1.a
    public void d(a.InterfaceC0129a interfaceC0129a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0129a) == null) {
            super.d(interfaceC0129a);
            o0 o0Var = this.f21937i;
            if (o0Var != null) {
                o0Var.t(interfaceC0129a);
            }
            g0 g0Var = this.f21936h;
            if (g0Var != null) {
                g0Var.v(interfaceC0129a);
            }
            LinearLayout linearLayout = this.f21934f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new View$OnClickListenerC1282b(this));
            }
        }
    }

    @Override // c.a.r0.q2.u.f.e1.a
    public void e(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d0Var) == null) {
            super.e(d0Var);
            o0 o0Var = this.f21937i;
            if (o0Var != null) {
                o0Var.k(this.f21930b);
            }
        }
    }
}
