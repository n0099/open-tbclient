package b.a.r0.k2.u.f.e1;

import android.view.View;
import android.widget.LinearLayout;
import b.a.l.a;
import b.a.l.g0;
import b.a.l.s0;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.x0;
import b.a.r0.b0.d0;
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
/* loaded from: classes5.dex */
public class g extends b.a.r0.k2.u.f.e1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f20774f;

    /* renamed from: g  reason: collision with root package name */
    public g0 f20775g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f20776h;

    /* renamed from: i  reason: collision with root package name */
    public d2 f20777i;
    public b.a.q0.s.q.a j;
    public s0 k;

    /* loaded from: classes5.dex */
    public class a extends b.a.q0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f20778e;

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
            this.f20778e = gVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20778e.f20777i : (d2) invokeV.objValue;
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

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f20779e;

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
            this.f20779e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar;
            a.InterfaceC0090a interfaceC0090a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0090a = (gVar = this.f20779e).f20746c) == null) {
                return;
            }
            interfaceC0090a.a(gVar.j);
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

    @Override // b.a.r0.k2.u.f.e1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f20774f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f20744a.getPageActivity());
                this.f20774f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f20774f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f20774f, b.a.r0.k2.f.CAM_X0206);
                this.f20774f.setOrientation(1);
                this.f20774f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f20774f.removeAllViews();
            if (this.f20775g == null) {
                g0 g0Var = new g0(this.f20744a);
                this.f20775g = g0Var;
                g0Var.m(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_H_X005);
            layoutParams.leftMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_W_X007);
            layoutParams.rightMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_W_X007);
            this.f20774f.addView(this.f20775g.f(), layoutParams);
            if (this.k == null) {
                s0 s0Var = new s0(this.f20744a.getPageActivity());
                this.k = s0Var;
                s0Var.v("pb");
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_H_X004);
            layoutParams2.bottomMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.tbds_30);
            this.f20774f.addView(this.k.f(), layoutParams2);
            if (this.f20776h == null) {
                this.f20776h = new ItemCardView(this.f20744a.getPageActivity());
            }
            this.f20776h.setBackGroundColor(b.a.r0.k2.f.CAM_X0205);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_H_X004);
            layoutParams3.leftMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_W_X007);
            layoutParams3.rightMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_W_X007);
            layoutParams3.bottomMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_H_X005);
            this.f20774f.addView(this.f20776h, layoutParams3);
            return this.f20774f;
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
        SkinManager.setBackgroundColor(this.f20774f, b.a.r0.k2.f.CAM_X0206);
        g0 g0Var = this.f20775g;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        ItemCardView itemCardView = this.f20776h;
        if (itemCardView != null) {
            itemCardView.onChangeSkinType();
        }
        s0 s0Var = this.k;
        if (s0Var != null) {
            s0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // b.a.r0.k2.u.f.e1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f20747d = originalThreadInfo;
            this.f20777i = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.j = aVar;
            s0 s0Var = this.k;
            if (s0Var != null) {
                s0Var.onBindDataToView(aVar);
            }
            ItemCardView itemCardView = this.f20776h;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.C, 17, originalThreadInfo.f45889f);
            }
            g0 g0Var = this.f20775g;
            if (g0Var != null) {
                g0Var.onBindDataToView(this.j);
            }
        }
    }

    @Override // b.a.r0.k2.u.f.e1.a
    public void d(a.InterfaceC0090a interfaceC0090a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0090a) == null) {
            super.d(interfaceC0090a);
            s0 s0Var = this.k;
            if (s0Var != null) {
                s0Var.w(interfaceC0090a);
            }
            g0 g0Var = this.f20775g;
            if (g0Var != null) {
                g0Var.v(interfaceC0090a);
            }
            LinearLayout linearLayout = this.f20774f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // b.a.r0.k2.u.f.e1.a
    public void e(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d0Var) == null) {
            super.e(d0Var);
            s0 s0Var = this.k;
            if (s0Var != null) {
                s0Var.k(this.f20745b);
            }
        }
    }
}
