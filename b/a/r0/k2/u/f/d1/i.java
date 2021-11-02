package b.a.r0.k2.u.f.d1;

import android.view.View;
import android.widget.LinearLayout;
import b.a.l.a;
import b.a.l.g0;
import b.a.l.s0;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.x0;
import b.a.r0.b0.c0;
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
public class i extends b.a.r0.k2.u.f.d1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f19220f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.s.q.a f19221g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f19222h;

    /* renamed from: i  reason: collision with root package name */
    public s0 f19223i;
    public d2 j;
    public VoteView k;

    /* loaded from: classes5.dex */
    public class a extends b.a.q0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f19224e;

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
            this.f19224e = iVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19224e.j : (d2) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, b.a.e.l.e.n
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
        public final /* synthetic */ i f19225e;

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
            this.f19225e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar;
            a.InterfaceC0088a interfaceC0088a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0088a = (iVar = this.f19225e).f19180c) == null) {
                return;
            }
            interfaceC0088a.a(iVar.f19221g);
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

    @Override // b.a.r0.k2.u.f.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f19220f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f19178a.getPageActivity());
                this.f19220f = linearLayout;
                SkinManager.setBackgroundColor(linearLayout, b.a.r0.k2.f.CAM_X0206);
                this.f19220f.setOrientation(1);
                this.f19220f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.f19220f.removeAllViews();
            if (this.f19222h == null) {
                g0 g0Var = new g0(this.f19178a);
                this.f19222h = g0Var;
                g0Var.m(Boolean.TRUE);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.f19178a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_H_X005);
            layoutParams.leftMargin = this.f19178a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_W_X007);
            layoutParams.rightMargin = this.f19178a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_W_X007);
            this.f19220f.addView(this.f19222h.f(), layoutParams);
            if (this.f19223i == null) {
                s0 s0Var = new s0(this.f19178a.getPageActivity());
                this.f19223i = s0Var;
                s0Var.v("pb");
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = this.f19178a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_H_X004);
            this.f19220f.addView(this.f19223i.f(), layoutParams2);
            if (this.k == null) {
                this.k = new VoteView(this.f19178a.getPageActivity());
            }
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.bottomMargin = this.f19178a.getResources().getDimensionPixelOffset(b.a.r0.k2.g.M_H_X005);
            this.f19220f.addView(this.k, layoutParams3);
            return this.f19220f;
        }
        return (View) invokeV.objValue;
    }

    @Override // b.a.r0.k2.u.f.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f19182e == i2) {
            return;
        }
        this.f19182e = i2;
        SkinManager.setBackgroundColor(this.f19220f, b.a.r0.k2.f.CAM_X0206);
        g0 g0Var = this.f19222h;
        if (g0Var != null) {
            g0Var.onChangeSkinType(tbPageContext, i2);
        }
        s0 s0Var = this.f19223i;
        if (s0Var != null) {
            s0Var.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // b.a.r0.k2.u.f.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f19181d = originalThreadInfo;
            this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f19221g = aVar;
            s0 s0Var = this.f19223i;
            if (s0Var != null) {
                s0Var.onBindDataToView(aVar);
            }
            g0 g0Var = this.f19222h;
            if (g0Var != null) {
                g0Var.onBindDataToView(this.f19221g);
            }
            PollData pollData = this.f19181d.F;
            if (pollData != null && pollData.getOptions() != null && this.f19181d.F.getOptions().size() > 0) {
                this.k.setIsTransmit(true);
                VoteView voteView = this.k;
                OriginalThreadInfo originalThreadInfo2 = this.f19181d;
                voteView.setData(originalThreadInfo2.F, originalThreadInfo2.f45040f, originalThreadInfo2.f45039e);
                this.k.setVisibility(0);
                return;
            }
            this.f19220f.removeView(this.k);
        }
    }

    @Override // b.a.r0.k2.u.f.d1.a
    public void d(a.InterfaceC0088a interfaceC0088a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0088a) == null) {
            super.d(interfaceC0088a);
            s0 s0Var = this.f19223i;
            if (s0Var != null) {
                s0Var.w(interfaceC0088a);
            }
            g0 g0Var = this.f19222h;
            if (g0Var != null) {
                g0Var.v(interfaceC0088a);
            }
            LinearLayout linearLayout = this.f19220f;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new b(this));
            }
        }
    }

    @Override // b.a.r0.k2.u.f.d1.a
    public void e(c0 c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, c0Var) == null) {
            super.e(c0Var);
            s0 s0Var = this.f19223i;
            if (s0Var != null) {
                s0Var.k(this.f19179b);
            }
        }
    }
}
