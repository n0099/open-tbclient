package c.a.r0.v.i.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.q0.d1.m0;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.f;
import c.a.r0.a0.m;
import c.a.r0.a0.z;
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
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c extends c.a.r0.a0.a<d2> implements z, c.a.r0.o.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public HeadImageView B;
    public TextView C;
    public AlaVideoContainer D;
    public RelativeLayout E;
    public LinearLayout F;
    public ThreadSourceShareAndPraiseLayout G;
    public View H;
    public String I;
    public String J;
    public View K;
    public final View.OnClickListener L;
    public LinearLayout w;
    public RelativeLayout x;
    public CardUserInfoLayout y;
    public TextView z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f26093e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26093e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26093e.g() == null) {
                return;
            }
            this.f26093e.g().a(view, this.f26093e.o);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.L = new a(this);
        n(bdUniqueId);
        this.m = tbPageContext;
        View j2 = j();
        RelativeLayout relativeLayout = (RelativeLayout) j2.findViewById(R.id.layout_root);
        this.x = relativeLayout;
        relativeLayout.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) j2.findViewById(R.id.video_card_content_layout);
        this.w = linearLayout;
        linearLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) j2.findViewById(R.id.ala_share_container);
        this.E = relativeLayout2;
        this.F = (LinearLayout) relativeLayout2.findViewById(R.id.challenge_root);
        CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) j2.findViewById(R.id.card_ala_video_user_info_layout);
        this.y = cardUserInfoLayout;
        cardUserInfoLayout.setShowFlag(6141);
        HeadImageView headImageView = (HeadImageView) j2.findViewById(R.id.ala_share_live_user_pendant_header);
        this.B = headImageView;
        headImageView.setIsRound(true);
        this.B.setDrawBorder(false);
        this.B.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.B.setAutoChangeStyle(false);
        this.C = (TextView) j2.findViewById(R.id.ala_share_live_username_text);
        this.z = (TextView) j2.findViewById(R.id.text_title);
        this.A = (TextView) j2.findViewById(R.id.ala_live_room_title);
        AlaVideoContainer alaVideoContainer = (AlaVideoContainer) j2.findViewById(R.id.ala_video_container);
        this.D = alaVideoContainer;
        alaVideoContainer.setOnVideoClickListener(this);
        View findViewById = j2.findViewById(R.id.thread_multi_del_mask_view);
        this.K = findViewById;
        findViewById.setClickable(true);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) j2.findViewById(R.id.text_bottom);
        this.p = threadCommentAndPraiseInfoLayout;
        s(threadCommentAndPraiseInfoLayout);
        this.p.setSelectVisible(false);
        this.p.setIsBarViewVisible(false);
        this.p.setCommentNumEnable(true);
        this.p.setLiveShareEnable(false);
        this.p.setFrom(2);
        this.p.getCommentContainer().setOnClickListener(this);
        this.p.hideDisagree();
        this.p.setShareReportFrom(1);
        f fVar = new f();
        fVar.f14167b = 2;
        fVar.f14173h = 2;
        this.p.setAgreeStatisticData(fVar);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = (ThreadCommentAndPraiseInfoLayout) j2.findViewById(R.id.card_bottom_op_weight_layout);
        this.q = threadCommentAndPraiseInfoLayout2;
        s(threadCommentAndPraiseInfoLayout2);
        this.q.setFrom(2);
        this.q.setShareReportFrom(1);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) j2.findViewById(R.id.text_bottom_2);
        this.G = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.mSharePraiseView.setOnClickListener(this);
        this.G.mSharePraiseView.getCommentContainer().setOnClickListener(this);
        this.G.setFrom(2);
        this.G.setShareReportFrom(1);
        this.G.setSourceFromForPb(3);
        this.G.setStType(FrsFragment.STAR_FRS);
        this.G.setHideBarName(true);
        this.H = j2.findViewById(R.id.divider_below_reply_number_layout);
        this.D.setLigvingLogLayoutVisible(8);
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.E.getLayoutParams();
            if (this.z.getVisibility() == 0) {
                layoutParams.topMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            } else {
                layoutParams.topMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            }
            this.E.setLayoutParams(layoutParams);
        }
    }

    public ThreadCommentAndPraiseInfoLayout O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.p : (ThreadCommentAndPraiseInfoLayout) invokeV.objValue;
    }

    public int P(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? c.a.r0.o.d.c().b(this.J, i2) : invokeI.intValue;
    }

    public ThreadCommentAndPraiseInfoLayout Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.G;
            if (threadSourceShareAndPraiseLayout != null) {
                return threadSourceShareAndPraiseLayout.mSharePraiseView;
            }
            return null;
        }
        return (ThreadCommentAndPraiseInfoLayout) invokeV.objValue;
    }

    public void R(TbPageContext<?> tbPageContext) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || tbPageContext == null || (t = this.o) == 0 || ((d2) t).l1() == null) {
            return;
        }
        if (!j.z()) {
            l.L(tbPageContext.getPageActivity(), R.string.no_network_guide);
            return;
        }
        AlaInfoData l1 = ((d2) this.o).l1();
        if (l1.isLegalYYLiveData()) {
            TbPageContext<?> tbPageContext2 = this.m;
            YyExtData yyExtData = l1.mYyExtData;
            String str = yyExtData.mSid;
            String str2 = yyExtData.mSsid;
            String str3 = yyExtData.mTemplateId;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext2, str, str2, str3, "" + l1.roomId, YYLiveUtil.SOURCE_FRS_LIVE_CARD_TAB);
        }
    }

    public final void S(TbPageContext<?> tbPageContext) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) || (t = this.o) == 0 || ((d2) t).l1() == null || ((d2) this.o).l1().share_info == null) {
            return;
        }
        if (((d2) this.o).l1().share_info.record_tid <= 0) {
            R(this.f15549f);
            return;
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(((d2) this.o).l1().share_info.record_tid), null, FrsFragment.STAR_FRS);
        createNormalCfg.setVideo_source(((d2) this.o).W1() ? "floor5" : "frs");
        createNormalCfg.setFromSmartFrs(((d2) this.o).x2());
        createNormalCfg.setSmartFrsPosition(((d2) this.o).f1());
        createNormalCfg.setStartFrom(3);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a0.b
    /* renamed from: T */
    public void k(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, d2Var) == null) {
            this.o = d2Var;
            U();
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            T t = this.o;
            int i2 = 8;
            if (t != 0 && ((d2) t).J() != null) {
                this.x.setVisibility(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.x.getLayoutParams();
                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
                layoutParams.bottomMargin = 0;
                this.y.setData((d2) this.o);
                this.y.setUserAfterClickListener(this.L);
                this.D.getController().d((d2) this.o, this.I, "", false);
                this.D.getController().c();
                if (((d2) this.o).l1() != null && ((d2) this.o).l1().share_info != null && !StringUtils.isNull(((d2) this.o).l1().share_info.content)) {
                    this.z.setVisibility(0);
                    this.z.setText(((d2) this.o).l1().share_info.content);
                } else {
                    this.z.setVisibility(8);
                }
                if (((d2) this.o).l1() != null && ((d2) this.o).l1().user_info != null) {
                    String str = ((d2) this.o).l1().user_info.user_name;
                    if (m0.d(str) > 14) {
                        str = m0.m(str, 14) + "...";
                    }
                    this.C.setText(str + ":");
                    if (TextUtils.isEmpty(((d2) this.o).l1().user_info.portrait)) {
                        this.B.setPlaceHolder(1);
                    } else {
                        this.B.startLoad(((d2) this.o).l1().user_info.portrait, 10, false, false);
                    }
                }
                String title = ((d2) this.o).getTitle();
                if (!StringUtils.isNull(title)) {
                    this.A.setText(title);
                    this.A.setVisibility(0);
                } else {
                    this.A.setVisibility(8);
                }
                W(P(1));
                if (((d2) this.o).l1().mChallengeInfoData != null && ((d2) this.o).l1().mChallengeInfoData.challenge_id > 0) {
                    this.F.setVisibility(0);
                } else {
                    this.F.setVisibility(8);
                }
                this.K.setVisibility((c.a.r0.w0.b.f().i() || c.a.r0.w0.a.h().j()) ? 0 : 0);
                z(this.x);
                l(i(), TbadkCoreApplication.getInst().getSkinType());
                N();
                return;
            }
            this.x.setVisibility(8);
        }
    }

    public void V(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) || bdUniqueId == null || this.p == null) {
            return;
        }
        CardUserInfoLayout cardUserInfoLayout = this.y;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        n(bdUniqueId);
        v(bdUniqueId);
    }

    public void W(int i2) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (t = this.o) == 0) {
            return;
        }
        if (i2 == 1) {
            this.p.setVisibility(8);
            this.G.setData((d2) this.o);
            return;
        }
        this.p.setData((d2) t);
        this.G.setVisibility(8);
    }

    @Override // c.a.r0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.I = str;
        }
    }

    @Override // c.a.r0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? R.layout.frs_ala_share_live_layout : invokeV.intValue;
    }

    @Override // c.a.r0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, tbPageContext, i2) == null) {
            if (this.f15548e != i2) {
                u(tbPageContext, i2);
                c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.x);
                d2.o(R.string.J_X06);
                d2.j(R.color.CAM_X0205, R.color.CAM_X0206);
                SkinManager.setBackgroundColor(this.E, R.color.CAM_X0204);
                AlaVideoContainer alaVideoContainer = this.D;
                if (alaVideoContainer != null) {
                    alaVideoContainer.onChangeSkinType(i2);
                }
                this.y.onChangeSkinType(i(), TbadkCoreApplication.getInst().getSkinType());
                this.p.onChangeSkinType();
                this.f15548e = i2;
                HeadImageView headImageView = this.B;
                if (headImageView != null) {
                    headImageView.setPlaceHolder(1);
                }
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.G;
                if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                    this.G.onChangeSkinType();
                }
            }
            T t = this.o;
            if (t != 0 && m.k(((d2) t).f0())) {
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.A, R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.C, R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.A, R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.C, R.color.CAM_X0105);
            }
            SkinManager.setBackgroundColor(this.K, R.color.CAM_X0201);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, view) == null) || c.a.r0.w0.b.f().i() || c.a.r0.w0.a.h().j()) {
            return;
        }
        int i2 = 1;
        if (view != this.x && view != this.p.getCommentContainer() && this.w != view && view != this.G.mSharePraiseView.getCommentContainer() && view != this.q.getCommentContainer()) {
            if (view.getId() == R.id.video_container) {
                if (g() != null) {
                    g().a(view, this.o);
                }
                TiebaStatic.log(new StatisticItem("c12323"));
                if (((d2) this.o).l1().live_status == 1) {
                    R(this.f15549f);
                    return;
                } else {
                    S(this.f15549f);
                    return;
                }
            }
            return;
        }
        T t = this.o;
        if (t != 0) {
            m.a(((d2) t).f0());
        }
        if (g() != null) {
            g().a(this.x, this.o);
        }
        TiebaStatic.log(new StatisticItem("c12323"));
        if (((d2) this.o).l1().live_status == 1) {
            R(this.f15549f);
            i2 = 5;
        } else {
            S(this.f15549f);
        }
        if (view == this.p.getCommentContainer() || view == this.G.mSharePraiseView.getCommentContainer()) {
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", 2);
            statisticItem.param("tid", ((d2) this.o).s1());
            statisticItem.param("obj_type", i2);
            statisticItem.param("nid", ((d2) this.o).F0());
            c.a.q0.m0.c f2 = TbPageExtraHelper.f(view);
            if (f2 != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
            }
            if (TbPageExtraHelper.m() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // c.a.r0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
        }
    }

    @Override // c.a.r0.o.e
    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.J = str;
        }
    }
}
