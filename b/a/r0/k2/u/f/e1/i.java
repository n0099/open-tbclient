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
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class i extends b.a.r0.k2.u.f.e1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f20786f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.s.q.a f20787g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f20788h;

    /* renamed from: i  reason: collision with root package name */
    public s0 f20789i;
    public d2 j;
    public VoteView k;

    /* loaded from: classes5.dex */
    public class a extends b.a.q0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f20790e;

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
            this.f20790e = iVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20790e.j : (d2) invokeV.objValue;
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
        public final /* synthetic */ i f20791e;

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
            this.f20791e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar;
            a.InterfaceC0090a interfaceC0090a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0090a = (iVar = this.f20791e).f20746c) == null) {
                return;
            }
            interfaceC0090a.a(iVar.f20787g);
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

    @Override // b.a.r0.k2.u.f.e1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f20786f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f20744a.getPageActivity());
                this.f20786f = linearLayout;
                SkinManager.setBackgroundColor(linearLayout, b.a.r0.k2.f.CAM_X0206);
                this.f20786f.setOrientation(1);
                this.f20786f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f20786f.removeAllViews();
            if (this.f20788h == null) {
                g0 g0Var = new g0(this.f20744a);
                this.f20788h = g0Var;
                g0Var.m(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_H_X005);
            layoutParams.leftMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_W_X007);
            layoutParams.rightMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_W_X007);
            this.f20786f.addView(this.f20788h.f(), layoutParams);
            if (this.f20789i == null) {
                s0 s0Var = new s0(this.f20744a.getPageActivity());
                this.f20789i = s0Var;
                s0Var.v("pb");
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_H_X004);
            this.f20786f.addView(this.f20789i.f(), layoutParams2);
            if (this.k == null) {
                this.k = new VoteView(this.f20744a.getPageActivity());
            }
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.bottomMargin = this.f20744a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_H_X005);
            this.f20786f.addView(this.k, layoutParams3);
            return this.f20786f;
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
        SkinManager.setBackgroundColor(this.f20786f, b.a.r0.k2.f.CAM_X0206);
        g0 g0Var = this.f20788h;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        s0 s0Var = this.f20789i;
        if (s0Var != null) {
            s0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // b.a.r0.k2.u.f.e1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f20747d = originalThreadInfo;
            this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f20787g = aVar;
            s0 s0Var = this.f20789i;
            if (s0Var != null) {
                s0Var.onBindDataToView(aVar);
            }
            g0 g0Var = this.f20788h;
            if (g0Var != null) {
                g0Var.onBindDataToView(this.f20787g);
            }
            PollData pollData = this.f20747d.F;
            if (pollData != null && pollData.getOptions() != null && this.f20747d.F.getOptions().size() > 0) {
                this.k.setIsTransmit(true);
                VoteView voteView = this.k;
                OriginalThreadInfo originalThreadInfo2 = this.f20747d;
                voteView.setData(originalThreadInfo2.F, originalThreadInfo2.f45889f, originalThreadInfo2.f45888e);
                this.k.setVisibility(0);
                return;
            }
            this.f20786f.removeView(this.k);
        }
    }

    @Override // b.a.r0.k2.u.f.e1.a
    public void d(a.InterfaceC0090a interfaceC0090a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0090a) == null) {
            super.d(interfaceC0090a);
            s0 s0Var = this.f20789i;
            if (s0Var != null) {
                s0Var.w(interfaceC0090a);
            }
            g0 g0Var = this.f20788h;
            if (g0Var != null) {
                g0Var.v(interfaceC0090a);
            }
            LinearLayout linearLayout = this.f20786f;
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
            s0 s0Var = this.f20789i;
            if (s0Var != null) {
                s0Var.k(this.f20745b);
            }
        }
    }
}
