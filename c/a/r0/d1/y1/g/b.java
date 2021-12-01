package c.a.r0.d1.y1.g;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.q0.s.q.d2;
import c.a.r0.d1.c1;
import c.a.r0.d1.d1;
import c.a.r0.d1.f1;
import c.a.r0.d1.i1;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b extends c.a.r0.d1.y1.g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A0;
    public EntelechyUserLikeButton B0;
    public c.a.q0.s.g0.t.c C0;
    public int D0;
    public d2 E0;
    public CommonUserLikeButton.a F0;
    public View.OnClickListener G0;
    public TbPageContext z0;

    /* loaded from: classes5.dex */
    public class a implements CommonUserLikeButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.n0(i2);
            }
        }
    }

    /* renamed from: c.a.r0.d1.y1.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC0985b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16370e;

        public View$OnClickListenerC0985b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16370e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16370e.E0 == null || this.f16370e.E0.J() == null || StringUtils.isNull(this.f16370e.E0.J().getName_show()) || StringUtils.isNull(this.f16370e.E0.J().getUserId()) || this.f16370e.E0.a0() == null) {
                return;
            }
            PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.f16370e.z0.getPageActivity(), this.f16370e.E0.J().getUserId(), this.f16370e.E0.J().getName_show(), this.f16370e.E0.a0(), AddFriendActivityConfig.TYPE_FRS_HEAD);
            personInfoActivityConfig.setIsVideoThread(this.f16370e.E0.t1() != null);
            personInfoActivityConfig.setVideoPersonFrom("frs");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.D0 = 3;
        this.F0 = new a(this);
        this.G0 = new View$OnClickListenerC0985b(this);
        this.z0 = tbPageContext;
        TextView textView = new TextView(tbPageContext.getPageActivity());
        this.A0 = textView;
        textView.setIncludeFontPadding(false);
        this.A0.setTextSize(0, l.f(tbPageContext.getPageActivity(), d1.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.f(tbPageContext.getPageActivity(), d1.ds6);
        this.A0.setLayoutParams(layoutParams);
        this.A0.setOnClickListener(this.G0);
        this.u.addView(this.A0, 1);
        EntelechyUserLikeButton entelechyUserLikeButton = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.B0 = entelechyUserLikeButton;
        entelechyUserLikeButton.setFanNumCallBack(this.F0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.f(this.z0.getPageActivity(), d1.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, f1.header_divider);
        layoutParams2.rightMargin = l.f(this.z0.getPageActivity(), d1.ds32);
        layoutParams2.topMargin = l.f(this.z0.getPageActivity(), d1.ds24);
        this.B0.setLayoutParams(layoutParams2);
        ((ViewGroup) j()).addView(this.B0);
        c.a.q0.s.g0.t.c cVar = new c.a.q0.s.g0.t.c(tbPageContext, this.B0);
        this.C0 = cVar;
        cVar.m("1");
        this.C0.l(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.d1.y1.g.a, c.a.r0.g0.b
    /* renamed from: Y */
    public void k(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) {
            super.k(d2Var);
            if (d2Var == null) {
                return;
            }
            this.E0 = d2Var;
            if (d2Var.J() != null) {
                this.C0.n(d2Var.J());
                n0(d2Var.J().getFansNum());
                if (!this.E0.c2()) {
                    this.B0.setVisibility(8);
                } else if (this.E0.J().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.E0.J().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.B0.setVisibility(8);
                    return;
                } else if (this.E0.J().getGodUserData() != null && this.E0.J().getGodUserData().getIsLike()) {
                    if (this.E0.J().getGodUserData().getIsFromNetWork()) {
                        this.B0.setVisibility(8);
                    } else {
                        this.B0.setVisibility(0);
                        this.B0.updateLikeStatus(true, 1);
                    }
                } else {
                    this.B0.setVisibility(0);
                }
            }
            int i2 = ((RelativeLayout.LayoutParams) this.v.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.B0.getLayoutParams();
            if (d2Var.f1() != null) {
                layoutParams.topMargin = l.f(this.z0.getPageActivity(), d1.ds4) + i2;
            } else {
                layoutParams.topMargin = l.f(this.z0.getPageActivity(), d1.ds24);
            }
        }
    }

    @Override // c.a.r0.d1.y1.g.a
    public void a0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            super.a0(bdUniqueId);
        }
    }

    @Override // c.a.r0.d1.y1.g.a, c.a.r0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            super.l(tbPageContext, i2);
            if (this.D0 != i2) {
                SkinManager.setViewTextColor(this.A0, c1.CAM_X0109);
                this.B0.onChangeSkinType(i2);
            }
            this.D0 = i2;
        }
    }

    public final void n0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || this.A0 == null) {
            return;
        }
        String string = this.z0.getResources().getString(i1.fans_default_name_god_user);
        d2 d2Var = this.E0;
        if (d2Var != null && !StringUtils.isNull(d2Var.a0()) && this.E0.a0().equals(this.i0)) {
            if (this.E0.c2()) {
                String format = String.format(string, StringHelper.numberUniformFormat(i2));
                this.A0.setVisibility(0);
                this.A0.setText(format);
                return;
            }
            this.A0.setVisibility(8);
            return;
        }
        this.A0.setText(this.z0.getResources().getString(i1.default_personalized_name));
    }
}
