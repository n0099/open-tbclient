package c.a.r0.q2.u.f.e1;

import android.view.View;
import android.widget.LinearLayout;
import c.a.k.a;
import c.a.k.g0;
import c.a.k.s0;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x0;
import c.a.r0.g0.d0;
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
/* loaded from: classes6.dex */
public class g extends c.a.r0.q2.u.f.e1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f21961f;

    /* renamed from: g  reason: collision with root package name */
    public g0 f21962g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f21963h;

    /* renamed from: i  reason: collision with root package name */
    public d2 f21964i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.s.q.a f21965j;

    /* renamed from: k  reason: collision with root package name */
    public s0 f21966k;

    /* loaded from: classes6.dex */
    public class a extends c.a.q0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f21967e;

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
            this.f21967e = gVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21967e.f21964i : (d2) invokeV.objValue;
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

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f21968e;

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
            this.f21968e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar;
            a.InterfaceC0129a interfaceC0129a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0129a = (gVar = this.f21968e).f21931c) == null) {
                return;
            }
            interfaceC0129a.a(gVar.f21965j);
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

    @Override // c.a.r0.q2.u.f.e1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f21961f == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageActivity());
                this.f21961f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f21961f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f21961f, c.a.r0.q2.f.CAM_X0206);
                this.f21961f.setOrientation(1);
                this.f21961f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f21961f.removeAllViews();
            if (this.f21962g == null) {
                g0 g0Var = new g0(this.a);
                this.f21962g = g0Var;
                g0Var.m(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_H_X005);
            layoutParams.leftMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_W_X007);
            layoutParams.rightMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_W_X007);
            this.f21961f.addView(this.f21962g.f(), layoutParams);
            if (this.f21966k == null) {
                s0 s0Var = new s0(this.a.getPageActivity());
                this.f21966k = s0Var;
                s0Var.v("pb");
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_H_X004);
            layoutParams2.bottomMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.tbds_30);
            this.f21961f.addView(this.f21966k.f(), layoutParams2);
            if (this.f21963h == null) {
                this.f21963h = new ItemCardView(this.a.getPageActivity());
            }
            this.f21963h.setBackGroundColor(c.a.r0.q2.f.CAM_X0205);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_H_X004);
            layoutParams3.leftMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_W_X007);
            layoutParams3.rightMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_W_X007);
            layoutParams3.bottomMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_H_X005);
            this.f21961f.addView(this.f21963h, layoutParams3);
            return this.f21961f;
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
        SkinManager.setBackgroundColor(this.f21961f, c.a.r0.q2.f.CAM_X0206);
        g0 g0Var = this.f21962g;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        ItemCardView itemCardView = this.f21963h;
        if (itemCardView != null) {
            itemCardView.onChangeSkinType();
        }
        s0 s0Var = this.f21966k;
        if (s0Var != null) {
            s0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // c.a.r0.q2.u.f.e1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f21932d = originalThreadInfo;
            this.f21964i = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f21965j = aVar;
            s0 s0Var = this.f21966k;
            if (s0Var != null) {
                s0Var.onBindDataToView(aVar);
            }
            ItemCardView itemCardView = this.f21963h;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.C, 17, originalThreadInfo.f40904f);
            }
            g0 g0Var = this.f21962g;
            if (g0Var != null) {
                g0Var.onBindDataToView(this.f21965j);
            }
        }
    }

    @Override // c.a.r0.q2.u.f.e1.a
    public void d(a.InterfaceC0129a interfaceC0129a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0129a) == null) {
            super.d(interfaceC0129a);
            s0 s0Var = this.f21966k;
            if (s0Var != null) {
                s0Var.w(interfaceC0129a);
            }
            g0 g0Var = this.f21962g;
            if (g0Var != null) {
                g0Var.v(interfaceC0129a);
            }
            LinearLayout linearLayout = this.f21961f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // c.a.r0.q2.u.f.e1.a
    public void e(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d0Var) == null) {
            super.e(d0Var);
            s0 s0Var = this.f21966k;
            if (s0Var != null) {
                s0Var.k(this.f21930b);
            }
        }
    }
}
