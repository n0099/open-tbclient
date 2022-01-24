package c.a.l;

import android.view.View;
import android.widget.RelativeLayout;
import c.a.s0.s.q.e2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class k0 extends c implements p<e2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext f4315i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f4316j;
    public boolean k;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThemeCardInUserData f4317e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k0 f4318f;

        public a(k0 k0Var, ThemeCardInUserData themeCardInUserData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0Var, themeCardInUserData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4318f = k0Var;
            this.f4317e = themeCardInUserData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(this.f4318f.f4315i.getPageActivity(), this.f4317e.getCardId())));
            }
        }
    }

    public k0(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = true;
        this.f4315i = tbPageContext;
        g(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c.a.d.f.p.n.f(tbPageContext.getPageActivity(), R.dimen.ds180), c.a.d.f.p.n.f(tbPageContext.getPageActivity(), R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.topMargin = c.a.d.f.p.n.f(tbPageContext.getPageActivity(), R.dimen.tbds30);
        layoutParams.rightMargin = c.a.d.f.p.n.f(tbPageContext.getPageActivity(), R.dimen.tbds30);
        h(layoutParams);
        TbImageView tbImageView = new TbImageView(tbPageContext.getPageActivity());
        this.f4316j = tbImageView;
        f(tbImageView);
    }

    public void k(e2 e2Var) {
        MetaData J;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, e2Var) == null) || e2Var == null || this.f4316j == null || (J = e2Var.J()) == null) {
            return;
        }
        ThemeCardInUserData themeCard = J.getThemeCard();
        if (themeCard != null && !StringUtils.isNull(themeCard.getCardImageUrlAndroid()) && !e2Var.W1) {
            if (this.k && (this.f4316j.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4316j.getLayoutParams();
                layoutParams.rightMargin = c.a.d.f.p.n.f(this.f4315i.getPageActivity(), R.dimen.tbds106);
                this.f4316j.setLayoutParams(layoutParams);
            }
            this.f4316j.setVisibility(0);
            this.f4316j.setImageDrawable(null);
            this.f4316j.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.f4316j.setOnClickListener(new a(this, themeCard));
            return;
        }
        this.f4316j.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: l */
    public void onBindDataToView(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var) == null) {
            k(e2Var);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.k = z;
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.f4316j.setPageId(bdUniqueId);
        }
    }
}
