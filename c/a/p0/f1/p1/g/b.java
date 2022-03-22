package c.a.p0.f1.p1.g;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
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
public class b extends c.a.p0.f1.p1.g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext s0;
    public TextView t0;
    public EntelechyUserLikeButton u0;
    public c.a.o0.r.l0.t.c v0;
    public int w0;
    public ThreadData x0;
    public CommonUserLikeButton.a y0;
    public View.OnClickListener z0;

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.h0(i);
            }
        }
    }

    /* renamed from: c.a.p0.f1.p1.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1084b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public View$OnClickListenerC1084b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.x0 == null || this.a.x0.getAuthor() == null || StringUtils.isNull(this.a.x0.getAuthor().getName_show()) || StringUtils.isNull(this.a.x0.getAuthor().getUserId()) || this.a.x0.getForum_name() == null) {
                return;
            }
            PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.a.s0.getPageActivity(), this.a.x0.getAuthor().getUserId(), this.a.x0.getAuthor().getName_show(), this.a.x0.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD);
            personInfoActivityConfig.setIsVideoThread(this.a.x0.getThreadVideoInfo() != null);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w0 = 3;
        this.y0 = new a(this);
        this.z0 = new View$OnClickListenerC1084b(this);
        this.s0 = tbPageContext;
        TextView textView = new TextView(tbPageContext.getPageActivity());
        this.t0 = textView;
        textView.setIncludeFontPadding(false);
        this.t0.setTextSize(0, n.f(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = n.f(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f0702df);
        this.t0.setLayoutParams(layoutParams);
        this.t0.setOnClickListener(this.z0);
        this.q.addView(this.t0, 1);
        EntelechyUserLikeButton entelechyUserLikeButton = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.u0 = entelechyUserLikeButton;
        entelechyUserLikeButton.setFanNumCallBack(this.y0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, n.f(this.s0.getPageActivity(), R.dimen.obfuscated_res_0x7f0702d6));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.obfuscated_res_0x7f090d37);
        layoutParams2.rightMargin = n.f(this.s0.getPageActivity(), R.dimen.obfuscated_res_0x7f070207);
        layoutParams2.topMargin = n.f(this.s0.getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8);
        this.u0.setLayoutParams(layoutParams2);
        ((ViewGroup) k()).addView(this.u0);
        c.a.o0.r.l0.t.c cVar = new c.a.o0.r.l0.t.c(tbPageContext, this.u0);
        this.v0 = cVar;
        cVar.m("1");
        this.v0.l(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.f1.p1.g.a, c.a.p0.h0.b
    /* renamed from: S */
    public void l(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            super.l(threadData);
            if (threadData == null) {
                return;
            }
            this.x0 = threadData;
            if (threadData.getAuthor() != null) {
                this.v0.n(threadData.getAuthor());
                h0(threadData.getAuthor().getFansNum());
                if (!this.x0.isGodThread()) {
                    this.u0.setVisibility(8);
                } else if (this.x0.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.x0.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.u0.setVisibility(8);
                    return;
                } else if (this.x0.getAuthor().getGodUserData() != null && this.x0.getAuthor().getGodUserData().getIsLike()) {
                    if (this.x0.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.u0.setVisibility(8);
                    } else {
                        this.u0.setVisibility(0);
                        this.u0.e(true, 1);
                    }
                } else {
                    this.u0.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.r.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.u0.getLayoutParams();
            if (threadData.getSkinInfoData() != null) {
                layoutParams.topMargin = n.f(this.s0.getPageActivity(), R.dimen.obfuscated_res_0x7f070224) + i;
            } else {
                layoutParams.topMargin = n.f(this.s0.getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8);
            }
        }
    }

    @Override // c.a.p0.f1.p1.g.a
    public void U(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            super.U(bdUniqueId);
        }
    }

    public final void h0(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.t0 == null) {
            return;
        }
        String string = this.s0.getResources().getString(R.string.obfuscated_res_0x7f0f05e8);
        ThreadData threadData = this.x0;
        if (threadData != null && !StringUtils.isNull(threadData.getForum_name()) && this.x0.getForum_name().equals(this.h0)) {
            if (this.x0.isGodThread()) {
                String format = String.format(string, StringHelper.numberUniformFormat(i));
                this.t0.setVisibility(0);
                this.t0.setText(format);
                return;
            }
            this.t0.setVisibility(8);
            return;
        }
        this.t0.setText(this.s0.getResources().getString(R.string.obfuscated_res_0x7f0f0479));
    }

    @Override // c.a.p0.f1.p1.g.a, c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            super.m(tbPageContext, i);
            if (this.w0 != i) {
                SkinManager.setViewTextColor(this.t0, (int) R.color.CAM_X0109);
                this.u0.g(i);
            }
            this.w0 = i;
        }
    }
}
