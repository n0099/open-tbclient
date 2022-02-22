package c.a.u0.u2.u.f.f1;

import android.view.View;
import android.widget.LinearLayout;
import c.a.l.a;
import c.a.l.g0;
import c.a.l.s0;
import c.a.t0.s.r.e2;
import c.a.t0.s.r.x0;
import c.a.u0.g0.b0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class g extends c.a.u0.u2.u.f.f1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f23628f;

    /* renamed from: g  reason: collision with root package name */
    public g0 f23629g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f23630h;

    /* renamed from: i  reason: collision with root package name */
    public e2 f23631i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.t0.s.r.a f23632j;
    public s0 k;

    /* loaded from: classes9.dex */
    public class a extends c.a.t0.s.r.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f23633e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23633e = gVar;
        }

        @Override // c.a.t0.s.r.a
        public x0 getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (x0) invokeV.objValue;
        }

        @Override // c.a.t0.s.r.a
        public e2 getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23633e.f23631i : (e2) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.o.e.n
        public BdUniqueId getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (BdUniqueId) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f23634e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23634e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar;
            a.InterfaceC0208a interfaceC0208a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0208a = (gVar = this.f23634e).f23598c) == null) {
                return;
            }
            interfaceC0208a.a(gVar.f23632j);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.u0.u2.u.f.f1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f23628f == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageActivity());
                this.f23628f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f23628f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f23628f, c.a.u0.u2.f.CAM_X0206);
                this.f23628f.setOrientation(1);
                this.f23628f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f23628f.removeAllViews();
            if (this.f23629g == null) {
                g0 g0Var = new g0(this.a);
                this.f23629g = g0Var;
                g0Var.m(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.u0.u2.g.M_H_X005);
            layoutParams.leftMargin = this.a.getResources().getDimensionPixelOffset(c.a.u0.u2.g.M_W_X007);
            layoutParams.rightMargin = this.a.getResources().getDimensionPixelOffset(c.a.u0.u2.g.M_W_X007);
            this.f23628f.addView(this.f23629g.f(), layoutParams);
            if (this.k == null) {
                s0 s0Var = new s0(this.a.getPageActivity());
                this.k = s0Var;
                s0Var.v("pb");
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.u0.u2.g.M_H_X004);
            layoutParams2.bottomMargin = this.a.getResources().getDimensionPixelOffset(c.a.u0.u2.g.tbds_30);
            this.f23628f.addView(this.k.f(), layoutParams2);
            if (this.f23630h == null) {
                this.f23630h = new ItemCardView(this.a.getPageActivity());
            }
            this.f23630h.setBackGroundColor(c.a.u0.u2.f.CAM_X0205);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.u0.u2.g.M_H_X004);
            layoutParams3.leftMargin = this.a.getResources().getDimensionPixelOffset(c.a.u0.u2.g.M_W_X007);
            layoutParams3.rightMargin = this.a.getResources().getDimensionPixelOffset(c.a.u0.u2.g.M_W_X007);
            layoutParams3.bottomMargin = this.a.getResources().getDimensionPixelOffset(c.a.u0.u2.g.M_H_X005);
            this.f23628f.addView(this.f23630h, layoutParams3);
            return this.f23628f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.u0.u2.u.f.f1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f23600e == i2) {
            return;
        }
        this.f23600e = i2;
        SkinManager.setBackgroundColor(this.f23628f, c.a.u0.u2.f.CAM_X0206);
        g0 g0Var = this.f23629g;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        ItemCardView itemCardView = this.f23630h;
        if (itemCardView != null) {
            itemCardView.onChangeSkinType();
        }
        s0 s0Var = this.k;
        if (s0Var != null) {
            s0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // c.a.u0.u2.u.f.f1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f23599d = originalThreadInfo;
            this.f23631i = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f23632j = aVar;
            s0 s0Var = this.k;
            if (s0Var != null) {
                s0Var.onBindDataToView(aVar);
            }
            ItemCardView itemCardView = this.f23630h;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.D, 17, originalThreadInfo.f40389f);
            }
            g0 g0Var = this.f23629g;
            if (g0Var != null) {
                g0Var.onBindDataToView(this.f23632j);
            }
        }
    }

    @Override // c.a.u0.u2.u.f.f1.a
    public void d(a.InterfaceC0208a interfaceC0208a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0208a) == null) {
            super.d(interfaceC0208a);
            s0 s0Var = this.k;
            if (s0Var != null) {
                s0Var.w(interfaceC0208a);
            }
            g0 g0Var = this.f23629g;
            if (g0Var != null) {
                g0Var.v(interfaceC0208a);
            }
            LinearLayout linearLayout = this.f23628f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // c.a.u0.u2.u.f.f1.a
    public void e(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b0Var) == null) {
            super.e(b0Var);
            s0 s0Var = this.k;
            if (s0Var != null) {
                s0Var.k(this.f23597b);
            }
        }
    }
}
