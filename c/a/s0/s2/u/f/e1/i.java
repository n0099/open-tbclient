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
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class i extends c.a.s0.s2.u.f.e1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f22981f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.s.r.a f22982g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f22983h;

    /* renamed from: i  reason: collision with root package name */
    public s0 f22984i;

    /* renamed from: j  reason: collision with root package name */
    public d2 f22985j;

    /* renamed from: k  reason: collision with root package name */
    public VoteView f22986k;

    /* loaded from: classes8.dex */
    public class a extends c.a.r0.s.r.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f22987e;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22987e = iVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22987e.f22985j : (d2) invokeV.objValue;
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
        public final /* synthetic */ i f22988e;

        public b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22988e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar;
            a.InterfaceC0163a interfaceC0163a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0163a = (iVar = this.f22988e).f22937c) == null) {
                return;
            }
            interfaceC0163a.a(iVar.f22982g);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext tbPageContext, int i2) {
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

    @Override // c.a.s0.s2.u.f.e1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f22981f == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageActivity());
                this.f22981f = linearLayout;
                SkinManager.setBackgroundColor(linearLayout, c.a.s0.s2.f.CAM_X0206);
                this.f22981f.setOrientation(1);
                this.f22981f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f22981f.removeAllViews();
            if (this.f22983h == null) {
                g0 g0Var = new g0(this.a);
                this.f22983h = g0Var;
                g0Var.m(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.s0.s2.g.M_H_X005);
            layoutParams.leftMargin = this.a.getResources().getDimensionPixelOffset(c.a.s0.s2.g.M_W_X007);
            layoutParams.rightMargin = this.a.getResources().getDimensionPixelOffset(c.a.s0.s2.g.M_W_X007);
            this.f22981f.addView(this.f22983h.f(), layoutParams);
            if (this.f22984i == null) {
                s0 s0Var = new s0(this.a.getPageActivity());
                this.f22984i = s0Var;
                s0Var.v("pb");
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.s0.s2.g.M_H_X004);
            this.f22981f.addView(this.f22984i.f(), layoutParams2);
            if (this.f22986k == null) {
                this.f22986k = new VoteView(this.a.getPageActivity());
            }
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.bottomMargin = this.a.getResources().getDimensionPixelOffset(c.a.s0.s2.g.M_H_X005);
            this.f22981f.addView(this.f22986k, layoutParams3);
            return this.f22981f;
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
        SkinManager.setBackgroundColor(this.f22981f, c.a.s0.s2.f.CAM_X0206);
        g0 g0Var = this.f22983h;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        s0 s0Var = this.f22984i;
        if (s0Var != null) {
            s0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // c.a.s0.s2.u.f.e1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f22938d = originalThreadInfo;
            this.f22985j = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f22982g = aVar;
            s0 s0Var = this.f22984i;
            if (s0Var != null) {
                s0Var.onBindDataToView(aVar);
            }
            g0 g0Var = this.f22983h;
            if (g0Var != null) {
                g0Var.onBindDataToView(this.f22982g);
            }
            PollData pollData = this.f22938d.G;
            if (pollData != null && pollData.getOptions() != null && this.f22938d.G.getOptions().size() > 0) {
                this.f22986k.setIsTransmit(true);
                VoteView voteView = this.f22986k;
                OriginalThreadInfo originalThreadInfo2 = this.f22938d;
                voteView.setData(originalThreadInfo2.G, originalThreadInfo2.f41395f, originalThreadInfo2.f41394e);
                this.f22986k.setVisibility(0);
                return;
            }
            this.f22981f.removeView(this.f22986k);
        }
    }

    @Override // c.a.s0.s2.u.f.e1.a
    public void d(a.InterfaceC0163a interfaceC0163a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0163a) == null) {
            super.d(interfaceC0163a);
            s0 s0Var = this.f22984i;
            if (s0Var != null) {
                s0Var.w(interfaceC0163a);
            }
            g0 g0Var = this.f22983h;
            if (g0Var != null) {
                g0Var.v(interfaceC0163a);
            }
            LinearLayout linearLayout = this.f22981f;
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
            s0 s0Var = this.f22984i;
            if (s0Var != null) {
                s0Var.k(this.f22936b);
            }
        }
    }
}
