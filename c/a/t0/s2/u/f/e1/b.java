package c.a.t0.s2.u.f.e1;

import android.view.View;
import android.widget.LinearLayout;
import c.a.l.a;
import c.a.l.g0;
import c.a.l.o0;
import c.a.s0.s.q.d2;
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
public class b extends c.a.t0.s2.u.f.e1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f23452f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.s0.s.q.a f23453g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f23454h;

    /* renamed from: i  reason: collision with root package name */
    public o0 f23455i;

    /* renamed from: j  reason: collision with root package name */
    public d2 f23456j;

    /* loaded from: classes8.dex */
    public class a extends c.a.s0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23457e;

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
            this.f23457e = bVar;
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
        public d2 getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23457e.f23456j : (d2) invokeV.objValue;
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

    /* renamed from: c.a.t0.s2.u.f.e1.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1391b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23458e;

        public View$OnClickListenerC1391b(b bVar) {
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
            this.f23458e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar;
            a.InterfaceC0184a interfaceC0184a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0184a = (bVar = this.f23458e).f23449c) == null) {
                return;
            }
            interfaceC0184a.a(bVar.f23453g);
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

    @Override // c.a.t0.s2.u.f.e1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f23452f == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageActivity());
                this.f23452f = linearLayout;
                SkinManager.setBackgroundColor(linearLayout, c.a.t0.s2.f.CAM_X0206);
                this.f23452f.setOrientation(1);
                this.f23452f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f23452f.removeAllViews();
            if (this.f23454h == null) {
                g0 g0Var = new g0(this.a);
                this.f23454h = g0Var;
                g0Var.m(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.t0.s2.g.M_H_X005);
            layoutParams.leftMargin = this.a.getResources().getDimensionPixelOffset(c.a.t0.s2.g.M_W_X007);
            layoutParams.rightMargin = this.a.getResources().getDimensionPixelOffset(c.a.t0.s2.g.M_W_X007);
            this.f23452f.addView(this.f23454h.f(), layoutParams);
            if (this.f23455i == null) {
                this.f23455i = new o0(this.a.getPageActivity());
            }
            this.f23452f.addView(this.f23455i.f());
            return this.f23452f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.t0.s2.u.f.e1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f23451e == i2) {
            return;
        }
        this.f23451e = i2;
        SkinManager.setBackgroundColor(this.f23452f, c.a.t0.s2.f.CAM_X0206);
        g0 g0Var = this.f23454h;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        o0 o0Var = this.f23455i;
        if (o0Var != null) {
            o0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // c.a.t0.s2.u.f.e1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f23450d = originalThreadInfo;
            this.f23456j = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f23453g = aVar;
            o0 o0Var = this.f23455i;
            if (o0Var != null) {
                o0Var.onBindDataToView(aVar);
            }
            g0 g0Var = this.f23454h;
            if (g0Var != null) {
                g0Var.onBindDataToView(this.f23453g);
            }
        }
    }

    @Override // c.a.t0.s2.u.f.e1.a
    public void d(a.InterfaceC0184a interfaceC0184a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0184a) == null) {
            super.d(interfaceC0184a);
            o0 o0Var = this.f23455i;
            if (o0Var != null) {
                o0Var.t(interfaceC0184a);
            }
            g0 g0Var = this.f23454h;
            if (g0Var != null) {
                g0Var.v(interfaceC0184a);
            }
            LinearLayout linearLayout = this.f23452f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new View$OnClickListenerC1391b(this));
            }
        }
    }

    @Override // c.a.t0.s2.u.f.e1.a
    public void e(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d0Var) == null) {
            super.e(d0Var);
            o0 o0Var = this.f23455i;
            if (o0Var != null) {
                o0Var.k(this.f23448b);
            }
        }
    }
}
