package c.a.p0.c0.k.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.o0.c1.o0;
import c.a.o0.r.r.f;
import c.a.p0.h0.m;
import c.a.p0.h0.z;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c extends c.a.p0.h0.a<ThreadData> implements z, c.a.p0.v.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView A;
    public TextView B;
    public AlaVideoContainer C;
    public RelativeLayout D;
    public LinearLayout E;
    public ThreadSourceShareAndPraiseLayout F;
    public View G;
    public String H;
    public String I;
    public View J;
    public final View.OnClickListener K;
    public LinearLayout v;
    public RelativeLayout w;
    public CardUserInfoLayout x;
    public TextView y;
    public TextView z;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.h() == null) {
                return;
            }
            this.a.h().a(view, this.a.k);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.K = new a(this);
        o(bdUniqueId);
        this.i = tbPageContext;
        View k = k();
        RelativeLayout relativeLayout = (RelativeLayout) k.findViewById(R.id.obfuscated_res_0x7f0911f5);
        this.w = relativeLayout;
        relativeLayout.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f092317);
        this.v = linearLayout;
        linearLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) k.findViewById(R.id.obfuscated_res_0x7f090223);
        this.D = relativeLayout2;
        this.E = (LinearLayout) relativeLayout2.findViewById(R.id.obfuscated_res_0x7f0905de);
        CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) k.findViewById(R.id.obfuscated_res_0x7f0904c5);
        this.x = cardUserInfoLayout;
        cardUserInfoLayout.setShowFlag(6141);
        HeadImageView headImageView = (HeadImageView) k.findViewById(R.id.obfuscated_res_0x7f090224);
        this.A = headImageView;
        headImageView.setIsRound(true);
        this.A.setDrawBorder(false);
        this.A.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.A.setAutoChangeStyle(false);
        this.B = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090225);
        this.y = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091f51);
        this.z = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0901f3);
        AlaVideoContainer alaVideoContainer = (AlaVideoContainer) k.findViewById(R.id.obfuscated_res_0x7f090227);
        this.C = alaVideoContainer;
        alaVideoContainer.setOnVideoClickListener(this);
        View findViewById = k.findViewById(R.id.obfuscated_res_0x7f091fba);
        this.J = findViewById;
        findViewById.setClickable(true);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) k.findViewById(R.id.obfuscated_res_0x7f091f2a);
        this.l = threadCommentAndPraiseInfoLayout;
        t(threadCommentAndPraiseInfoLayout);
        this.l.setSelectVisible(false);
        this.l.setIsBarViewVisible(false);
        this.l.setCommentNumEnable(true);
        this.l.setLiveShareEnable(false);
        this.l.setFrom(2);
        this.l.getCommentContainer().setOnClickListener(this);
        this.l.hideDisagree();
        this.l.setShareReportFrom(1);
        f fVar = new f();
        fVar.f10852b = 2;
        fVar.f10858h = 2;
        this.l.setAgreeStatisticData(fVar);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = (ThreadCommentAndPraiseInfoLayout) k.findViewById(R.id.obfuscated_res_0x7f0904cb);
        this.m = threadCommentAndPraiseInfoLayout2;
        t(threadCommentAndPraiseInfoLayout2);
        this.m.setFrom(2);
        this.m.setShareReportFrom(1);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) k.findViewById(R.id.obfuscated_res_0x7f091f2b);
        this.F = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.f30173b.setOnClickListener(this);
        this.F.f30173b.getCommentContainer().setOnClickListener(this);
        this.F.setFrom(2);
        this.F.setShareReportFrom(1);
        this.F.setSourceFromForPb(3);
        this.F.setStType("frs_page");
        this.F.setHideBarName(true);
        this.G = k.findViewById(R.id.obfuscated_res_0x7f0907e8);
        this.C.setLigvingLogLayoutVisible(8);
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.D.getLayoutParams();
            if (this.y.getVisibility() == 0) {
                layoutParams.topMargin = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            } else {
                layoutParams.topMargin = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            }
            this.D.setLayoutParams(layoutParams);
        }
    }

    public ThreadCommentAndPraiseInfoLayout L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (ThreadCommentAndPraiseInfoLayout) invokeV.objValue;
    }

    public int M(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? c.a.p0.v.d.c().b(this.I, i) : invokeI.intValue;
    }

    public ThreadCommentAndPraiseInfoLayout N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.F;
            if (threadSourceShareAndPraiseLayout != null) {
                return threadSourceShareAndPraiseLayout.f30173b;
            }
            return null;
        }
        return (ThreadCommentAndPraiseInfoLayout) invokeV.objValue;
    }

    public void O(TbPageContext<?> tbPageContext) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || tbPageContext == null || (t = this.k) == 0 || ((ThreadData) t).getThreadAlaInfo() == null) {
            return;
        }
        if (!l.z()) {
            n.M(tbPageContext.getPageActivity(), R.string.obfuscated_res_0x7f0f0c4c);
            return;
        }
        AlaInfoData threadAlaInfo = ((ThreadData) this.k).getThreadAlaInfo();
        if (threadAlaInfo.isLegalYYLiveData()) {
            TbPageContext<?> tbPageContext2 = this.i;
            YyExtData yyExtData = threadAlaInfo.mYyExtData;
            String str = yyExtData.mSid;
            String str2 = yyExtData.mSsid;
            String str3 = yyExtData.mTemplateId;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext2, str, str2, str3, "" + threadAlaInfo.roomId, YYLiveUtil.SOURCE_FRS_LIVE_CARD_TAB);
        }
    }

    public final void P(TbPageContext<?> tbPageContext) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) || (t = this.k) == 0 || ((ThreadData) t).getThreadAlaInfo() == null || ((ThreadData) this.k).getThreadAlaInfo().share_info == null) {
            return;
        }
        if (((ThreadData) this.k).getThreadAlaInfo().share_info.record_tid <= 0) {
            O(this.f15304b);
            return;
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(((ThreadData) this.k).getThreadAlaInfo().share_info.record_tid), null, "frs_page");
        createNormalCfg.setVideo_source(((ThreadData) this.k).isFloor5Video() ? "floor5" : "frs");
        createNormalCfg.setFromSmartFrs(((ThreadData) this.k).isSmartFrsThread());
        createNormalCfg.setSmartFrsPosition(((ThreadData) this.k).getSmartFrsPosition());
        createNormalCfg.setStartFrom(3);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: Q */
    public void l(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) {
            this.k = threadData;
            R();
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            T t = this.k;
            int i = 8;
            if (t != 0 && ((ThreadData) t).getAuthor() != null) {
                this.w.setVisibility(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.w.getLayoutParams();
                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
                layoutParams.bottomMargin = 0;
                this.x.setData((ThreadData) this.k);
                this.x.setUserAfterClickListener(this.K);
                this.C.getController().d((ThreadData) this.k, this.H, "", false);
                this.C.getController().c();
                if (((ThreadData) this.k).getThreadAlaInfo() != null && ((ThreadData) this.k).getThreadAlaInfo().share_info != null && !StringUtils.isNull(((ThreadData) this.k).getThreadAlaInfo().share_info.content)) {
                    this.y.setVisibility(0);
                    this.y.setText(((ThreadData) this.k).getThreadAlaInfo().share_info.content);
                } else {
                    this.y.setVisibility(8);
                }
                if (((ThreadData) this.k).getThreadAlaInfo() != null && ((ThreadData) this.k).getThreadAlaInfo().user_info != null) {
                    String str = ((ThreadData) this.k).getThreadAlaInfo().user_info.user_name;
                    if (o0.d(str) > 14) {
                        str = o0.n(str, 14) + StringHelper.STRING_MORE;
                    }
                    this.B.setText(str + ":");
                    if (TextUtils.isEmpty(((ThreadData) this.k).getThreadAlaInfo().user_info.portrait)) {
                        this.A.setPlaceHolder(1);
                    } else {
                        this.A.K(((ThreadData) this.k).getThreadAlaInfo().user_info.portrait, 10, false, false);
                    }
                }
                String title = ((ThreadData) this.k).getTitle();
                if (!StringUtils.isNull(title)) {
                    this.z.setText(title);
                    this.z.setVisibility(0);
                } else {
                    this.z.setVisibility(8);
                }
                T(M(1));
                if (((ThreadData) this.k).getThreadAlaInfo().mChallengeInfoData != null && ((ThreadData) this.k).getThreadAlaInfo().mChallengeInfoData.challenge_id > 0) {
                    this.E.setVisibility(0);
                } else {
                    this.E.setVisibility(8);
                }
                this.J.setVisibility((c.a.p0.f1.b.f().i() || c.a.p0.f1.a.h().j()) ? 0 : 0);
                D(this.w);
                m(j(), TbadkCoreApplication.getInst().getSkinType());
                K();
                return;
            }
            this.w.setVisibility(8);
        }
    }

    public void S(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) || bdUniqueId == null || this.l == null) {
            return;
        }
        CardUserInfoLayout cardUserInfoLayout = this.x;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        o(bdUniqueId);
        x(bdUniqueId);
    }

    public void T(int i) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (t = this.k) == 0) {
            return;
        }
        if (i == 1) {
            this.l.setVisibility(8);
            this.F.g((ThreadData) this.k);
            return;
        }
        this.l.setData((ThreadData) t);
        this.F.setVisibility(8);
    }

    @Override // c.a.p0.h0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.H = str;
        }
    }

    @Override // c.a.p0.v.e
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.I = str;
        }
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? R.layout.obfuscated_res_0x7f0d0300 : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, tbPageContext, i) == null) {
            if (this.a != i) {
                w(tbPageContext, i);
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.w);
                d2.n(R.string.J_X06);
                d2.i(R.color.CAM_X0205, R.color.CAM_X0206);
                SkinManager.setBackgroundColor(this.D, R.color.CAM_X0204);
                AlaVideoContainer alaVideoContainer = this.C;
                if (alaVideoContainer != null) {
                    alaVideoContainer.o(i);
                }
                this.x.onChangeSkinType(j(), TbadkCoreApplication.getInst().getSkinType());
                this.l.onChangeSkinType();
                this.a = i;
                HeadImageView headImageView = this.A;
                if (headImageView != null) {
                    headImageView.setPlaceHolder(1);
                }
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.F;
                if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                    this.F.f();
                }
            }
            T t = this.k;
            if (t != 0 && m.k(((ThreadData) t).getId())) {
                SkinManager.setViewTextColor(this.y, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.y, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0105);
            }
            SkinManager.setBackgroundColor(this.J, R.color.CAM_X0201);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, view) == null) || c.a.p0.f1.b.f().i() || c.a.p0.f1.a.h().j()) {
            return;
        }
        int i = 1;
        if (view != this.w && view != this.l.getCommentContainer() && this.v != view && view != this.F.f30173b.getCommentContainer() && view != this.m.getCommentContainer()) {
            if (view.getId() == R.id.obfuscated_res_0x7f09231b) {
                if (h() != null) {
                    h().a(view, this.k);
                }
                TiebaStatic.log(new StatisticItem("c12323"));
                if (((ThreadData) this.k).getThreadAlaInfo().live_status == 1) {
                    O(this.f15304b);
                    return;
                } else {
                    P(this.f15304b);
                    return;
                }
            }
            return;
        }
        T t = this.k;
        if (t != 0) {
            m.a(((ThreadData) t).getId());
        }
        if (h() != null) {
            h().a(this.w, this.k);
        }
        TiebaStatic.log(new StatisticItem("c12323"));
        if (((ThreadData) this.k).getThreadAlaInfo().live_status == 1) {
            O(this.f15304b);
            i = 5;
        } else {
            P(this.f15304b);
        }
        if (view == this.l.getCommentContainer() || view == this.F.f30173b.getCommentContainer()) {
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", 2);
            statisticItem.param("tid", ((ThreadData) this.k).getTid());
            statisticItem.param("obj_type", i);
            statisticItem.param("nid", ((ThreadData) this.k).getNid());
            c.a.o0.n0.c findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view);
            if (findPageExtraByView != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // c.a.p0.h0.z
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
        }
    }
}
