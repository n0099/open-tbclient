package c.a.s0.s2.u.f.e1;

import android.view.View;
import android.widget.LinearLayout;
import c.a.l.a;
import c.a.l.g0;
import c.a.l.s0;
import c.a.r0.s.r.d2;
import c.a.r0.s.r.x0;
import c.a.s0.g0.d0;
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
/* loaded from: classes8.dex */
public class g extends c.a.s0.s2.u.f.e1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f22967f;

    /* renamed from: g  reason: collision with root package name */
    public g0 f22968g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f22969h;

    /* renamed from: i  reason: collision with root package name */
    public d2 f22970i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.s.r.a f22971j;

    /* renamed from: k  reason: collision with root package name */
    public s0 f22972k;

    /* loaded from: classes8.dex */
    public class a extends c.a.r0.s.r.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f22973e;

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
            this.f22973e = gVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22973e.f22970i : (d2) invokeV.objValue;
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
        public final /* synthetic */ g f22974e;

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
            this.f22974e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar;
            a.InterfaceC0163a interfaceC0163a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0163a = (gVar = this.f22974e).f22937c) == null) {
                return;
            }
            interfaceC0163a.a(gVar.f22971j);
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

    @Override // c.a.s0.s2.u.f.e1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f22967f == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageActivity());
                this.f22967f = linearLayout;
                linearLayout.setClipChildren(false);
                this.f22967f.setClipToPadding(false);
                SkinManager.setBackgroundColor(this.f22967f, c.a.s0.s2.f.CAM_X0206);
                this.f22967f.setOrientation(1);
                this.f22967f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f22967f.removeAllViews();
            if (this.f22968g == null) {
                g0 g0Var = new g0(this.a);
                this.f22968g = g0Var;
                g0Var.m(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.s0.s2.g.M_H_X005);
            layoutParams.leftMargin = this.a.getResources().getDimensionPixelOffset(c.a.s0.s2.g.M_W_X007);
            layoutParams.rightMargin = this.a.getResources().getDimensionPixelOffset(c.a.s0.s2.g.M_W_X007);
            this.f22967f.addView(this.f22968g.f(), layoutParams);
            if (this.f22972k == null) {
                s0 s0Var = new s0(this.a.getPageActivity());
                this.f22972k = s0Var;
                s0Var.v("pb");
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.s0.s2.g.M_H_X004);
            layoutParams2.bottomMargin = this.a.getResources().getDimensionPixelOffset(c.a.s0.s2.g.tbds_30);
            this.f22967f.addView(this.f22972k.f(), layoutParams2);
            if (this.f22969h == null) {
                this.f22969h = new ItemCardView(this.a.getPageActivity());
            }
            this.f22969h.setBackGroundColor(c.a.s0.s2.f.CAM_X0205);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.s0.s2.g.M_H_X004);
            layoutParams3.leftMargin = this.a.getResources().getDimensionPixelOffset(c.a.s0.s2.g.M_W_X007);
            layoutParams3.rightMargin = this.a.getResources().getDimensionPixelOffset(c.a.s0.s2.g.M_W_X007);
            layoutParams3.bottomMargin = this.a.getResources().getDimensionPixelOffset(c.a.s0.s2.g.M_H_X005);
            this.f22967f.addView(this.f22969h, layoutParams3);
            return this.f22967f;
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
        SkinManager.setBackgroundColor(this.f22967f, c.a.s0.s2.f.CAM_X0206);
        g0 g0Var = this.f22968g;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        ItemCardView itemCardView = this.f22969h;
        if (itemCardView != null) {
            itemCardView.onChangeSkinType();
        }
        s0 s0Var = this.f22972k;
        if (s0Var != null) {
            s0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // c.a.s0.s2.u.f.e1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f22938d = originalThreadInfo;
            this.f22970i = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f22971j = aVar;
            s0 s0Var = this.f22972k;
            if (s0Var != null) {
                s0Var.onBindDataToView(aVar);
            }
            ItemCardView itemCardView = this.f22969h;
            if (itemCardView != null && originalThreadInfo != null) {
                itemCardView.setData(originalThreadInfo.D, 17, originalThreadInfo.f41395f);
            }
            g0 g0Var = this.f22968g;
            if (g0Var != null) {
                g0Var.onBindDataToView(this.f22971j);
            }
        }
    }

    @Override // c.a.s0.s2.u.f.e1.a
    public void d(a.InterfaceC0163a interfaceC0163a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0163a) == null) {
            super.d(interfaceC0163a);
            s0 s0Var = this.f22972k;
            if (s0Var != null) {
                s0Var.w(interfaceC0163a);
            }
            g0 g0Var = this.f22968g;
            if (g0Var != null) {
                g0Var.v(interfaceC0163a);
            }
            LinearLayout linearLayout = this.f22967f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // c.a.s0.s2.u.f.e1.a
    public void e(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d0Var) == null) {
            super.e(d0Var);
            s0 s0Var = this.f22972k;
            if (s0Var != null) {
                s0Var.k(this.f22936b);
            }
        }
    }
}
