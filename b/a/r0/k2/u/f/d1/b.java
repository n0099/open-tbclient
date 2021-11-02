package b.a.r0.k2.u.f.d1;

import android.view.View;
import android.widget.LinearLayout;
import b.a.l.a;
import b.a.l.g0;
import b.a.l.o0;
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
public class b extends b.a.r0.k2.u.f.d1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f19183f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.s.q.a f19184g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f19185h;

    /* renamed from: i  reason: collision with root package name */
    public o0 f19186i;
    public d2 j;

    /* loaded from: classes5.dex */
    public class a extends b.a.q0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19187e;

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
            this.f19187e = bVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19187e.j : (d2) invokeV.objValue;
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

    /* renamed from: b.a.r0.k2.u.f.d1.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC0963b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19188e;

        public View$OnClickListenerC0963b(b bVar) {
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
            this.f19188e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar;
            a.InterfaceC0088a interfaceC0088a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0088a = (bVar = this.f19188e).f19180c) == null) {
                return;
            }
            interfaceC0088a.a(bVar.f19184g);
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

    @Override // b.a.r0.k2.u.f.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f19183f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f19178a.getPageActivity());
                this.f19183f = linearLayout;
                SkinManager.setBackgroundColor(linearLayout, b.a.r0.k2.f.CAM_X0206);
                this.f19183f.setOrientation(1);
                this.f19183f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f19183f.removeAllViews();
            if (this.f19185h == null) {
                g0 g0Var = new g0(this.f19178a);
                this.f19185h = g0Var;
                g0Var.m(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f19178a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_H_X005);
            layoutParams.leftMargin = this.f19178a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_W_X007);
            layoutParams.rightMargin = this.f19178a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_W_X007);
            this.f19183f.addView(this.f19185h.f(), layoutParams);
            if (this.f19186i == null) {
                this.f19186i = new o0(this.f19178a.getPageActivity());
            }
            this.f19183f.addView(this.f19186i.f());
            return this.f19183f;
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
        SkinManager.setBackgroundColor(this.f19183f, b.a.r0.k2.f.CAM_X0206);
        g0 g0Var = this.f19185h;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        o0 o0Var = this.f19186i;
        if (o0Var != null) {
            o0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // b.a.r0.k2.u.f.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f19181d = originalThreadInfo;
            this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f19184g = aVar;
            o0 o0Var = this.f19186i;
            if (o0Var != null) {
                o0Var.onBindDataToView(aVar);
            }
            g0 g0Var = this.f19185h;
            if (g0Var != null) {
                g0Var.onBindDataToView(this.f19184g);
            }
        }
    }

    @Override // b.a.r0.k2.u.f.d1.a
    public void d(a.InterfaceC0088a interfaceC0088a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0088a) == null) {
            super.d(interfaceC0088a);
            o0 o0Var = this.f19186i;
            if (o0Var != null) {
                o0Var.t(interfaceC0088a);
            }
            g0 g0Var = this.f19185h;
            if (g0Var != null) {
                g0Var.v(interfaceC0088a);
            }
            LinearLayout linearLayout = this.f19183f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new View$OnClickListenerC0963b(this));
            }
        }
    }

    @Override // b.a.r0.k2.u.f.d1.a
    public void e(c0 c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, c0Var) == null) {
            super.e(c0Var);
            o0 o0Var = this.f19186i;
            if (o0Var != null) {
                o0Var.k(this.f19179b);
            }
        }
    }
}
