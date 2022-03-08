package c.a.r0.d1.p1.g;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.q0.r.r.e2;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b extends c.a.r0.d1.p1.g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A0;
    public e2 B0;
    public CommonUserLikeButton.a C0;
    public View.OnClickListener D0;
    public TbPageContext w0;
    public TextView x0;
    public EntelechyUserLikeButton y0;
    public c.a.q0.r.l0.t.c z0;

    /* loaded from: classes2.dex */
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
                this.a.g0(i2);
            }
        }
    }

    /* renamed from: c.a.r0.d1.p1.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1025b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16034e;

        public View$OnClickListenerC1025b(b bVar) {
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
            this.f16034e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16034e.B0 == null || this.f16034e.B0.J() == null || StringUtils.isNull(this.f16034e.B0.J().getName_show()) || StringUtils.isNull(this.f16034e.B0.J().getUserId()) || this.f16034e.B0.b0() == null) {
                return;
            }
            PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.f16034e.w0.getPageActivity(), this.f16034e.B0.J().getUserId(), this.f16034e.B0.J().getName_show(), this.f16034e.B0.b0(), AddFriendActivityConfig.TYPE_FRS_HEAD);
            personInfoActivityConfig.setIsVideoThread(this.f16034e.B0.u1() != null);
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
        this.A0 = 3;
        this.C0 = new a(this);
        this.D0 = new View$OnClickListenerC1025b(this);
        this.w0 = tbPageContext;
        TextView textView = new TextView(tbPageContext.getPageActivity());
        this.x0 = textView;
        textView.setIncludeFontPadding(false);
        this.x0.setTextSize(0, n.f(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = n.f(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.x0.setLayoutParams(layoutParams);
        this.x0.setOnClickListener(this.D0);
        this.u.addView(this.x0, 1);
        EntelechyUserLikeButton entelechyUserLikeButton = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.y0 = entelechyUserLikeButton;
        entelechyUserLikeButton.setFanNumCallBack(this.C0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, n.f(this.w0.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = n.f(this.w0.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = n.f(this.w0.getPageActivity(), R.dimen.ds24);
        this.y0.setLayoutParams(layoutParams2);
        ((ViewGroup) j()).addView(this.y0);
        c.a.q0.r.l0.t.c cVar = new c.a.q0.r.l0.t.c(tbPageContext, this.y0);
        this.z0 = cVar;
        cVar.m("1");
        this.z0.l(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.d1.p1.g.a, c.a.r0.f0.b
    /* renamed from: R */
    public void k(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, e2Var) == null) {
            super.k(e2Var);
            if (e2Var == null) {
                return;
            }
            this.B0 = e2Var;
            if (e2Var.J() != null) {
                this.z0.n(e2Var.J());
                g0(e2Var.J().getFansNum());
                if (!this.B0.d2()) {
                    this.y0.setVisibility(8);
                } else if (this.B0.J().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.B0.J().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.y0.setVisibility(8);
                    return;
                } else if (this.B0.J().getGodUserData() != null && this.B0.J().getGodUserData().getIsLike()) {
                    if (this.B0.J().getGodUserData().getIsFromNetWork()) {
                        this.y0.setVisibility(8);
                    } else {
                        this.y0.setVisibility(0);
                        this.y0.updateLikeStatus(true, 1);
                    }
                } else {
                    this.y0.setVisibility(0);
                }
            }
            int i2 = ((RelativeLayout.LayoutParams) this.v.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.y0.getLayoutParams();
            if (e2Var.g1() != null) {
                layoutParams.topMargin = n.f(this.w0.getPageActivity(), R.dimen.ds4) + i2;
            } else {
                layoutParams.topMargin = n.f(this.w0.getPageActivity(), R.dimen.ds24);
            }
        }
    }

    @Override // c.a.r0.d1.p1.g.a
    public void T(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            super.T(bdUniqueId);
        }
    }

    public final void g0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.x0 == null) {
            return;
        }
        String string = this.w0.getResources().getString(R.string.fans_default_name_god_user);
        e2 e2Var = this.B0;
        if (e2Var != null && !StringUtils.isNull(e2Var.b0()) && this.B0.b0().equals(this.f0)) {
            if (this.B0.d2()) {
                String format = String.format(string, StringHelper.numberUniformFormat(i2));
                this.x0.setVisibility(0);
                this.x0.setText(format);
                return;
            }
            this.x0.setVisibility(8);
            return;
        }
        this.x0.setText(this.w0.getResources().getString(R.string.default_personalized_name));
    }

    @Override // c.a.r0.d1.p1.g.a, c.a.r0.f0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) {
            super.l(tbPageContext, i2);
            if (this.A0 != i2) {
                SkinManager.setViewTextColor(this.x0, (int) R.color.CAM_X0109);
                this.y0.onChangeSkinType(i2);
            }
            this.A0 = i2;
        }
    }
}
