package c.a.l;

import android.view.View;
import android.widget.RelativeLayout;
import c.a.p0.s.q.c2;
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
public class k0 extends c implements p<c2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext f3821i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f3822j;
    public boolean k;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThemeCardInUserData f3823e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k0 f3824f;

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
            this.f3824f = k0Var;
            this.f3823e = themeCardInUserData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(this.f3824f.f3821i.getPageActivity(), this.f3823e.getCardId())));
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
        this.f3821i = tbPageContext;
        g(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c.a.e.e.p.l.g(tbPageContext.getPageActivity(), R.dimen.ds180), c.a.e.e.p.l.g(tbPageContext.getPageActivity(), R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.topMargin = c.a.e.e.p.l.g(tbPageContext.getPageActivity(), R.dimen.tbds30);
        layoutParams.rightMargin = c.a.e.e.p.l.g(tbPageContext.getPageActivity(), R.dimen.tbds30);
        h(layoutParams);
        TbImageView tbImageView = new TbImageView(tbPageContext.getPageActivity());
        this.f3822j = tbImageView;
        f(tbImageView);
    }

    public void k(c2 c2Var) {
        MetaData J;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, c2Var) == null) || c2Var == null || this.f3822j == null || (J = c2Var.J()) == null) {
            return;
        }
        ThemeCardInUserData themeCard = J.getThemeCard();
        if (themeCard != null && !StringUtils.isNull(themeCard.getCardImageUrlAndroid()) && !c2Var.T1) {
            if (this.k && (this.f3822j.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3822j.getLayoutParams();
                layoutParams.rightMargin = c.a.e.e.p.l.g(this.f3821i.getPageActivity(), R.dimen.tbds106);
                this.f3822j.setLayoutParams(layoutParams);
            }
            this.f3822j.setVisibility(0);
            this.f3822j.setImageDrawable(null);
            this.f3822j.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.f3822j.setOnClickListener(new a(this, themeCard));
            return;
        }
        this.f3822j.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: l */
    public void onBindDataToView(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2Var) == null) {
            k(c2Var);
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
            this.f3822j.setPageId(bdUniqueId);
        }
    }
}
