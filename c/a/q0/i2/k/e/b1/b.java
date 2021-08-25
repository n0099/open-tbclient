package c.a.q0.i2.k.e.b1;

import android.view.View;
import android.widget.LinearLayout;
import c.a.l.a;
import c.a.l.g0;
import c.a.l.o0;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.x0;
import c.a.q0.a0.b0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b extends c.a.q0.i2.k.e.b1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f19278f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.s.q.a f19279g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f19280h;

    /* renamed from: i  reason: collision with root package name */
    public o0 f19281i;

    /* renamed from: j  reason: collision with root package name */
    public c2 f19282j;

    /* loaded from: classes3.dex */
    public class a extends c.a.p0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19283e;

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
            this.f19283e = bVar;
        }

        @Override // c.a.p0.s.q.a
        public x0 getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (x0) invokeV.objValue;
        }

        @Override // c.a.p0.s.q.a
        public c2 getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19283e.f19282j : (c2) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.l.e.n
        public BdUniqueId getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (BdUniqueId) invokeV.objValue;
        }
    }

    /* renamed from: c.a.q0.i2.k.e.b1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0919b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19284e;

        public View$OnClickListenerC0919b(b bVar) {
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
            this.f19284e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar;
            a.InterfaceC0094a interfaceC0094a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0094a = (bVar = this.f19284e).f19275c) == null) {
                return;
            }
            interfaceC0094a.a(bVar.f19279g);
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

    @Override // c.a.q0.i2.k.e.b1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f19278f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f19273a.getPageActivity());
                this.f19278f = linearLayout;
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
                this.f19278f.setOrientation(1);
                this.f19278f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f19278f.removeAllViews();
            if (this.f19280h == null) {
                g0 g0Var = new g0(this.f19273a);
                this.f19280h = g0Var;
                g0Var.m(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f19273a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            layoutParams.leftMargin = this.f19273a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.f19273a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            this.f19278f.addView(this.f19280h.f(), layoutParams);
            if (this.f19281i == null) {
                this.f19281i = new o0(this.f19273a.getPageActivity());
            }
            this.f19278f.addView(this.f19281i.f());
            return this.f19278f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.q0.i2.k.e.b1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f19277e == i2) {
            return;
        }
        this.f19277e = i2;
        SkinManager.setBackgroundColor(this.f19278f, R.color.CAM_X0206);
        g0 g0Var = this.f19280h;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        o0 o0Var = this.f19281i;
        if (o0Var != null) {
            o0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // c.a.q0.i2.k.e.b1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f19276d = originalThreadInfo;
            this.f19282j = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f19279g = aVar;
            o0 o0Var = this.f19281i;
            if (o0Var != null) {
                o0Var.onBindDataToView(aVar);
            }
            g0 g0Var = this.f19280h;
            if (g0Var != null) {
                g0Var.onBindDataToView(this.f19279g);
            }
        }
    }

    @Override // c.a.q0.i2.k.e.b1.a
    public void d(a.InterfaceC0094a interfaceC0094a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0094a) == null) {
            super.d(interfaceC0094a);
            o0 o0Var = this.f19281i;
            if (o0Var != null) {
                o0Var.t(interfaceC0094a);
            }
            g0 g0Var = this.f19280h;
            if (g0Var != null) {
                g0Var.v(interfaceC0094a);
            }
            LinearLayout linearLayout = this.f19278f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new View$OnClickListenerC0919b(this));
            }
        }
    }

    @Override // c.a.q0.i2.k.e.b1.a
    public void e(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b0Var) == null) {
            super.e(b0Var);
            o0 o0Var = this.f19281i;
            if (o0Var != null) {
                o0Var.k(this.f19274b);
            }
        }
    }
}
