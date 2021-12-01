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
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i extends c.a.r0.q2.u.f.e1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f21975f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.s.q.a f21976g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f21977h;

    /* renamed from: i  reason: collision with root package name */
    public s0 f21978i;

    /* renamed from: j  reason: collision with root package name */
    public d2 f21979j;

    /* renamed from: k  reason: collision with root package name */
    public VoteView f21980k;

    /* loaded from: classes6.dex */
    public class a extends c.a.q0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f21981e;

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
            this.f21981e = iVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21981e.f21979j : (d2) invokeV.objValue;
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
        public final /* synthetic */ i f21982e;

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
            this.f21982e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar;
            a.InterfaceC0129a interfaceC0129a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0129a = (iVar = this.f21982e).f21931c) == null) {
                return;
            }
            interfaceC0129a.a(iVar.f21976g);
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

    @Override // c.a.r0.q2.u.f.e1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f21975f == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageActivity());
                this.f21975f = linearLayout;
                SkinManager.setBackgroundColor(linearLayout, c.a.r0.q2.f.CAM_X0206);
                this.f21975f.setOrientation(1);
                this.f21975f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f21975f.removeAllViews();
            if (this.f21977h == null) {
                g0 g0Var = new g0(this.a);
                this.f21977h = g0Var;
                g0Var.m(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_H_X005);
            layoutParams.leftMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_W_X007);
            layoutParams.rightMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_W_X007);
            this.f21975f.addView(this.f21977h.f(), layoutParams);
            if (this.f21978i == null) {
                s0 s0Var = new s0(this.a.getPageActivity());
                this.f21978i = s0Var;
                s0Var.v("pb");
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_H_X004);
            this.f21975f.addView(this.f21978i.f(), layoutParams2);
            if (this.f21980k == null) {
                this.f21980k = new VoteView(this.a.getPageActivity());
            }
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.bottomMargin = this.a.getResources().getDimensionPixelOffset(c.a.r0.q2.g.M_H_X005);
            this.f21975f.addView(this.f21980k, layoutParams3);
            return this.f21975f;
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
        SkinManager.setBackgroundColor(this.f21975f, c.a.r0.q2.f.CAM_X0206);
        g0 g0Var = this.f21977h;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        s0 s0Var = this.f21978i;
        if (s0Var != null) {
            s0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // c.a.r0.q2.u.f.e1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f21932d = originalThreadInfo;
            this.f21979j = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f21976g = aVar;
            s0 s0Var = this.f21978i;
            if (s0Var != null) {
                s0Var.onBindDataToView(aVar);
            }
            g0 g0Var = this.f21977h;
            if (g0Var != null) {
                g0Var.onBindDataToView(this.f21976g);
            }
            PollData pollData = this.f21932d.F;
            if (pollData != null && pollData.getOptions() != null && this.f21932d.F.getOptions().size() > 0) {
                this.f21980k.setIsTransmit(true);
                VoteView voteView = this.f21980k;
                OriginalThreadInfo originalThreadInfo2 = this.f21932d;
                voteView.setData(originalThreadInfo2.F, originalThreadInfo2.f40904f, originalThreadInfo2.f40903e);
                this.f21980k.setVisibility(0);
                return;
            }
            this.f21975f.removeView(this.f21980k);
        }
    }

    @Override // c.a.r0.q2.u.f.e1.a
    public void d(a.InterfaceC0129a interfaceC0129a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0129a) == null) {
            super.d(interfaceC0129a);
            s0 s0Var = this.f21978i;
            if (s0Var != null) {
                s0Var.w(interfaceC0129a);
            }
            g0 g0Var = this.f21977h;
            if (g0Var != null) {
                g0Var.v(interfaceC0129a);
            }
            LinearLayout linearLayout = this.f21975f;
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
            s0 s0Var = this.f21978i;
            if (s0Var != null) {
                s0Var.k(this.f21930b);
            }
        }
    }
}
