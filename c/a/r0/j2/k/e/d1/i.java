package c.a.r0.j2.k.e.d1;

import android.view.View;
import android.widget.LinearLayout;
import c.a.l.a;
import c.a.l.g0;
import c.a.l.s0;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x0;
import c.a.r0.a0.b0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class i extends c.a.r0.j2.k.e.d1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f20029f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.s.q.a f20030g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f20031h;

    /* renamed from: i  reason: collision with root package name */
    public s0 f20032i;

    /* renamed from: j  reason: collision with root package name */
    public d2 f20033j;
    public VoteView k;

    /* loaded from: classes3.dex */
    public class a extends c.a.q0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f20034e;

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
            this.f20034e = iVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20034e.f20033j : (d2) invokeV.objValue;
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

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f20035e;

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
            this.f20035e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar;
            a.InterfaceC0093a interfaceC0093a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0093a = (iVar = this.f20035e).f19985c) == null) {
                return;
            }
            interfaceC0093a.a(iVar.f20030g);
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

    @Override // c.a.r0.j2.k.e.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f20029f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f19983a.getPageActivity());
                this.f20029f = linearLayout;
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
                this.f20029f.setOrientation(1);
                this.f20029f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f20029f.removeAllViews();
            if (this.f20031h == null) {
                g0 g0Var = new g0(this.f19983a);
                this.f20031h = g0Var;
                g0Var.m(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f19983a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            layoutParams.leftMargin = this.f19983a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.f19983a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            this.f20029f.addView(this.f20031h.f(), layoutParams);
            if (this.f20032i == null) {
                s0 s0Var = new s0(this.f19983a.getPageActivity());
                this.f20032i = s0Var;
                s0Var.v("pb");
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.f19983a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            this.f20029f.addView(this.f20032i.f(), layoutParams2);
            if (this.k == null) {
                this.k = new VoteView(this.f19983a.getPageActivity());
            }
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.bottomMargin = this.f19983a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
            this.f20029f.addView(this.k, layoutParams3);
            return this.f20029f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.r0.j2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f19987e == i2) {
            return;
        }
        this.f19987e = i2;
        SkinManager.setBackgroundColor(this.f20029f, R.color.CAM_X0206);
        g0 g0Var = this.f20031h;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        s0 s0Var = this.f20032i;
        if (s0Var != null) {
            s0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // c.a.r0.j2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f19986d = originalThreadInfo;
            this.f20033j = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f20030g = aVar;
            s0 s0Var = this.f20032i;
            if (s0Var != null) {
                s0Var.onBindDataToView(aVar);
            }
            g0 g0Var = this.f20031h;
            if (g0Var != null) {
                g0Var.onBindDataToView(this.f20030g);
            }
            PollData pollData = this.f19986d.F;
            if (pollData != null && pollData.getOptions() != null && this.f19986d.F.getOptions().size() > 0) {
                this.k.setIsTransmit(true);
                VoteView voteView = this.k;
                OriginalThreadInfo originalThreadInfo2 = this.f19986d;
                voteView.setData(originalThreadInfo2.F, originalThreadInfo2.f47422f, originalThreadInfo2.f47421e);
                this.k.setVisibility(0);
                return;
            }
            this.f20029f.removeView(this.k);
        }
    }

    @Override // c.a.r0.j2.k.e.d1.a
    public void d(a.InterfaceC0093a interfaceC0093a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0093a) == null) {
            super.d(interfaceC0093a);
            s0 s0Var = this.f20032i;
            if (s0Var != null) {
                s0Var.w(interfaceC0093a);
            }
            g0 g0Var = this.f20031h;
            if (g0Var != null) {
                g0Var.v(interfaceC0093a);
            }
            LinearLayout linearLayout = this.f20029f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // c.a.r0.j2.k.e.d1.a
    public void e(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b0Var) == null) {
            super.e(b0Var);
            s0 s0Var = this.f20032i;
            if (s0Var != null) {
                s0Var.k(this.f19984b);
            }
        }
    }
}
