package c.a.t0.t2.u.f.f1;

import android.view.View;
import android.widget.LinearLayout;
import c.a.l.a;
import c.a.l.g0;
import c.a.l.s0;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.x0;
import c.a.t0.g0.d0;
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
public class i extends c.a.t0.t2.u.f.f1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f23143f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.s0.s.q.a f23144g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f23145h;

    /* renamed from: i  reason: collision with root package name */
    public s0 f23146i;

    /* renamed from: j  reason: collision with root package name */
    public e2 f23147j;
    public VoteView k;

    /* loaded from: classes8.dex */
    public class a extends c.a.s0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f23148e;

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
            this.f23148e = iVar;
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
        public e2 getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23148e.f23147j : (e2) invokeV.objValue;
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

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f23149e;

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
            this.f23149e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar;
            a.InterfaceC0202a interfaceC0202a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0202a = (iVar = this.f23149e).f23100c) == null) {
                return;
            }
            interfaceC0202a.a(iVar.f23144g);
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

    @Override // c.a.t0.t2.u.f.f1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f23143f == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageActivity());
                this.f23143f = linearLayout;
                SkinManager.setBackgroundColor(linearLayout, c.a.t0.t2.f.CAM_X0206);
                this.f23143f.setOrientation(1);
                this.f23143f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f23143f.removeAllViews();
            if (this.f23145h == null) {
                g0 g0Var = new g0(this.a);
                this.f23145h = g0Var;
                g0Var.m(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_H_X005);
            layoutParams.leftMargin = this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_W_X007);
            layoutParams.rightMargin = this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_W_X007);
            this.f23143f.addView(this.f23145h.f(), layoutParams);
            if (this.f23146i == null) {
                s0 s0Var = new s0(this.a.getPageActivity());
                this.f23146i = s0Var;
                s0Var.v("pb");
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_H_X004);
            this.f23143f.addView(this.f23146i.f(), layoutParams2);
            if (this.k == null) {
                this.k = new VoteView(this.a.getPageActivity());
            }
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.bottomMargin = this.a.getResources().getDimensionPixelOffset(c.a.t0.t2.g.M_H_X005);
            this.f23143f.addView(this.k, layoutParams3);
            return this.f23143f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.t0.t2.u.f.f1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f23102e == i2) {
            return;
        }
        this.f23102e = i2;
        SkinManager.setBackgroundColor(this.f23143f, c.a.t0.t2.f.CAM_X0206);
        g0 g0Var = this.f23145h;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        s0 s0Var = this.f23146i;
        if (s0Var != null) {
            s0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // c.a.t0.t2.u.f.f1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f23101d = originalThreadInfo;
            this.f23147j = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f23144g = aVar;
            s0 s0Var = this.f23146i;
            if (s0Var != null) {
                s0Var.onBindDataToView(aVar);
            }
            g0 g0Var = this.f23145h;
            if (g0Var != null) {
                g0Var.onBindDataToView(this.f23144g);
            }
            PollData pollData = this.f23101d.G;
            if (pollData != null && pollData.getOptions() != null && this.f23101d.G.getOptions().size() > 0) {
                this.k.setIsTransmit(true);
                VoteView voteView = this.k;
                OriginalThreadInfo originalThreadInfo2 = this.f23101d;
                voteView.setData(originalThreadInfo2.G, originalThreadInfo2.f40160f, originalThreadInfo2.f40159e);
                this.k.setVisibility(0);
                return;
            }
            this.f23143f.removeView(this.k);
        }
    }

    @Override // c.a.t0.t2.u.f.f1.a
    public void d(a.InterfaceC0202a interfaceC0202a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0202a) == null) {
            super.d(interfaceC0202a);
            s0 s0Var = this.f23146i;
            if (s0Var != null) {
                s0Var.w(interfaceC0202a);
            }
            g0 g0Var = this.f23145h;
            if (g0Var != null) {
                g0Var.v(interfaceC0202a);
            }
            LinearLayout linearLayout = this.f23143f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // c.a.t0.t2.u.f.f1.a
    public void e(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d0Var) == null) {
            super.e(d0Var);
            s0 s0Var = this.f23146i;
            if (s0Var != null) {
                s0Var.k(this.f23099b);
            }
        }
    }
}
