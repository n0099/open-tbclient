package c.a.l;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class k0 extends c implements p<ThreadData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f3436e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f3437f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3438g;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThemeCardInUserData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k0 f3439b;

        public a(k0 k0Var, ThemeCardInUserData themeCardInUserData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0Var, themeCardInUserData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3439b = k0Var;
            this.a = themeCardInUserData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(this.f3439b.f3436e.getPageActivity(), this.a.getCardId())));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3438g = true;
        this.f3436e = tbPageContext;
        h(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c.a.d.f.p.n.f(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f070259), c.a.d.f.p.n.f(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f0702cb));
        layoutParams.addRule(11);
        layoutParams.topMargin = c.a.d.f.p.n.f(tbPageContext.getPageActivity(), R.dimen.tbds30);
        layoutParams.rightMargin = c.a.d.f.p.n.f(tbPageContext.getPageActivity(), R.dimen.tbds30);
        i(layoutParams);
        TbImageView tbImageView = new TbImageView(tbPageContext.getPageActivity());
        this.f3437f = tbImageView;
        g(tbImageView);
    }

    public void l(ThreadData threadData) {
        MetaData author;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) || threadData == null || this.f3437f == null || (author = threadData.getAuthor()) == null) {
            return;
        }
        ThemeCardInUserData themeCard = author.getThemeCard();
        if (themeCard != null && !StringUtils.isNull(themeCard.getCardImageUrlAndroid()) && !threadData.isHeadLinePost) {
            if (this.f3438g && (this.f3437f.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3437f.getLayoutParams();
                layoutParams.rightMargin = c.a.d.f.p.n.f(this.f3436e.getPageActivity(), R.dimen.tbds106);
                this.f3437f.setLayoutParams(layoutParams);
            }
            this.f3437f.setVisibility(0);
            this.f3437f.setImageDrawable(null);
            this.f3437f.J(themeCard.getCardImageUrlAndroid(), 10, false);
            this.f3437f.setOnClickListener(new a(this, themeCard));
            return;
        }
        this.f3437f.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: m */
    public void a(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            l(threadData);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f3438g = z;
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            this.f3437f.setPageId(bdUniqueId);
        }
    }
}
