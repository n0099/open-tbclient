package b.a.r0.w.k.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.j;
import b.a.e.f.p.l;
import b.a.q0.s.k;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.f;
import b.a.r0.b0.b0;
import b.a.r0.b0.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.card.view.TbLiveContainer;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes5.dex */
public class e extends b.a.r0.b0.a<d2> implements b0, b.a.r0.p.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadSourceShareAndPraiseLayout A;
    public View B;
    public LinearLayout C;
    public ThreadSkinView D;
    public RelativeLayout E;
    public TextView F;
    public TbImageView G;
    public RelativeLayout H;
    public TbImageView I;
    public TBLottieAnimationView J;
    public TextView K;
    public TextView L;
    public LinearLayout M;
    public View N;
    public FrameLayout O;
    public LinearLayout P;
    public TextView Q;
    public ImageView R;
    public TbLiveContainer S;
    public String T;
    public boolean U;
    public String V;
    public View W;
    public boolean X;
    public int Y;
    public b.a.r0.w.k.d.a Z;
    public final View.OnClickListener a0;
    public CardUserInfoLayout z;

    /* loaded from: classes5.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f26647e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26647e = eVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26647e.J.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f26647e.J.cancelAnimation();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f26648e;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26648e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26648e.f() == null) {
                return;
            }
            this.f26648e.f().a(view, this.f26648e.o);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.U = false;
        this.Y = 0;
        this.a0 = new b(this);
        m(bdUniqueId);
        this.m = tbPageContext;
        View i4 = i();
        RelativeLayout relativeLayout = (RelativeLayout) i4.findViewById(R.id.layout_root);
        this.E = relativeLayout;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        layoutParams.bottomMargin = 0;
        this.C = (LinearLayout) i4.findViewById(R.id.video_card_content_layout);
        this.E.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) i4.findViewById(R.id.video_card_stage_view);
        this.G = tbImageView;
        tbImageView.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.G.setDefaultBgResource(R.color.transparent);
        CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) i4.findViewById(R.id.card_ala_video_user_info_layout);
        this.z = cardUserInfoLayout;
        cardUserInfoLayout.setUserAfterClickListener(this.a0);
        this.F = (TextView) i4.findViewById(R.id.text_title);
        this.H = (RelativeLayout) i4.findViewById(R.id.frame_video);
        TbImageView tbImageView2 = (TbImageView) i4.findViewById(R.id.image_video);
        this.I = tbImageView2;
        tbImageView2.setDrawCorner(true);
        this.I.setPlaceHolder(3);
        this.I.setDefaultResource(0);
        this.I.setRadiusById(R.string.J_X05);
        this.I.setConrers(15);
        this.I.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.I.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.I.setBorderSurroundContent(true);
        this.I.setDrawBorder(true);
        this.M = (LinearLayout) i4.findViewById(R.id.ala_live_lottie_bg);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) i4.findViewById(R.id.ala_live_lottie);
        this.J = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        SkinManager.setLottieAnimation(this.J, R.raw.ala_live2);
        this.J.addOnAttachStateChangeListener(new a(this));
        this.K = (TextView) i4.findViewById(R.id.play_count);
        this.L = (TextView) i4.findViewById(R.id.ala_live_recom_reason);
        this.N = i4.findViewById(R.id.play_count_line);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) i4.findViewById(R.id.text_bottom);
        this.p = threadCommentAndPraiseInfoLayout;
        q(threadCommentAndPraiseInfoLayout);
        this.p.setSelectVisible(false);
        this.p.setIsBarViewVisible(false);
        this.p.setCommentNumEnable(true);
        this.p.setLiveShareEnable(false);
        this.p.setFrom(2);
        this.p.getCommentContainer().setOnClickListener(this);
        this.p.hideDisagree();
        f fVar = new f();
        fVar.f14080b = 2;
        fVar.f14086h = 2;
        this.p.setAgreeStatisticData(fVar);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = (ThreadCommentAndPraiseInfoLayout) i4.findViewById(R.id.card_bottom_op_weight_layout);
        this.q = threadCommentAndPraiseInfoLayout2;
        q(threadCommentAndPraiseInfoLayout2);
        this.q.setFrom(2);
        this.q.setShareReportFrom(1);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) i4.findViewById(R.id.text_bottom_2);
        this.A = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.mSharePraiseView.setOnClickListener(this);
        this.A.mSharePraiseView.getCommentContainer().setOnClickListener(this);
        this.A.setFrom(2);
        this.A.setShareReportFrom(1);
        this.A.setSourceFromForPb(3);
        this.A.setStType(FrsFragment.STAR_FRS);
        this.A.setHideBarName(true);
        this.B = i4.findViewById(R.id.divider_below_reply_number_layout);
        this.D = (ThreadSkinView) i4.findViewById(R.id.frs_thread_skin);
        View findViewById = i4.findViewById(R.id.thread_multi_del_mask_view);
        this.W = findViewById;
        findViewById.setClickable(true);
        b.a.r0.w.k.d.a aVar = new b.a.r0.w.k.d.a(tbPageContext, this.z.getSuffixContainer());
        this.Z = aVar;
        aVar.d(g());
        this.O = (FrameLayout) i4.findViewById(R.id.text_bottom_layout);
        this.P = (LinearLayout) i4.findViewById(R.id.forum_friends_now_looking);
        this.Q = (TextView) i4.findViewById(R.id.tv_forum_friends_now_looking);
        this.R = (ImageView) i4.findViewById(R.id.image_forum_friends_now_looking);
        this.S = (TbLiveContainer) i4.findViewById(R.id.tb_live_container);
    }

    public final void Q(d2 d2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, d2Var, str) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", d2Var.f0()).param("obj_locate", this.U ? 2 : 1).param("obj_id", d2Var.m1().live_id).param("obj_type", 2));
            if (d2Var.m1() != null && d2Var.m1().user_info != null && d2Var.m1().user_info.is_official == 2) {
                TiebaStatic.log(new StatisticItem("c12801").param("tid", d2Var.f0()));
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (d2Var.Z().equals(this.T)) {
                    TiebaStatic.log(new StatisticItem("c11843").param("uid", currentAccount).param("fid", d2Var.T()));
                } else {
                    TiebaStatic.log(new StatisticItem("c11845").param("uid", currentAccount).param("fid", d2Var.T()));
                }
            }
        }
    }

    public final void R(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) || d2Var == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12125").param("tid", d2Var.f0()).param("obj_locate", this.U ? 2 : 1).param("obj_id", d2Var.m1().live_id).param("obj_type", 2));
        if (d2Var.m1() == null || d2Var.m1().user_info == null || d2Var.m1().user_info.is_official != 2) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12800").param("tid", d2Var.f0()));
    }

    public int S(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? b.a.r0.p.d.c().b(this.V, i2) : invokeI.intValue;
    }

    public TbLiveContainer T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.S : (TbLiveContainer) invokeV.objValue;
    }

    public void U() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (k.c().g() && (t = this.o) != 0 && ((d2) t).getThreadData() != null && ((d2) this.o).getThreadData().m1() != null) {
                this.I.setPlaceHolder(3);
                this.I.startLoad(((d2) this.o).getThreadData().m1().cover, 10, false);
                this.H.setVisibility(0);
                return;
            }
            this.H.setVisibility(8);
        }
    }

    public void V(Context context, d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, context, d2Var) == null) || context == null || d2Var == null || d2Var.m1() == null) {
            return;
        }
        if (!j.z()) {
            l.L(context, R.string.no_network_guide);
            return;
        }
        String str = this.X ? AlaLiveRoomActivityConfig.FREM_TYPE_LIVE_FRS_STAGE_LIVE : AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
        if (d2Var.a0() != null) {
            str = d2Var.a0();
        }
        int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
        if (frsCurTabType == 14) {
            str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + d2Var.T();
        } else if (frsCurTabType == 13) {
            str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + d2Var.T();
        }
        Q(d2Var, str);
        AlaInfoData m1 = d2Var.m1();
        if (m1.isLegalYYLiveData()) {
            TbPageContext<?> tbPageContext = this.m;
            YyExtData yyExtData = m1.mYyExtData;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "" + m1.roomId, m1.mYyExtData.streamInfo, YYLiveUtil.SOURCE_FRS_LIVE_CARD_TAB);
            X(((d2) this.o).t1(), String.valueOf(((d2) this.o).T()), String.valueOf(m1.roomId), String.valueOf(m1.live_id), m1.mYyExtData.mSid);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: W */
    public void j(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, d2Var) == null) {
            this.o = d2Var;
            Y();
        }
    }

    public final void X(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, str2, str3, str4, str5) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tid", str);
                jSONObject.put("fid", str2);
                if (TextUtils.equals("0", str3)) {
                    str3 = null;
                }
                jSONObject.put(ILiveNPSPlugin.PARAMS_ROOM_ID, str3);
                if (TextUtils.equals("0", str4)) {
                    str4 = null;
                }
                jSONObject.put("liveId", str4);
                jSONObject.put("sid", str5);
                jSONObject.put("roomInfo", "roomInfo");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921547, jSONObject));
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            T t = this.o;
            int i2 = 8;
            if (t != 0 && ((d2) t).J() != null) {
                this.E.setVisibility(0);
                int k = l.k(this.m.getPageActivity());
                if (k != this.Y) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.H.getLayoutParams();
                    int k2 = l.k(getContext()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    layoutParams.width = k2;
                    layoutParams.height = (k2 * 9) / 16;
                    this.H.setLayoutParams(layoutParams);
                    this.Y = k;
                }
                SparseArray<String> sparseArray = null;
                if (((d2) this.o).m1() != null && ((d2) this.o).m1().user_info != null && ((d2) this.o).m1().user_info.is_official == 2) {
                    this.X = true;
                    sparseArray = ((d2) this.o).m1().dislikeInfo;
                    this.G.setVisibility(0);
                    int[] p = l.p(getContext());
                    ViewGroup.LayoutParams layoutParams2 = this.G.getLayoutParams();
                    layoutParams2.width = p[0];
                    layoutParams2.height = (p[0] * 156) / 1080;
                    this.G.setLayoutParams(layoutParams2);
                    if (!TextUtils.isEmpty(((d2) this.o).m1().liveStagePicUrl)) {
                        this.G.startLoad(((d2) this.o).m1().liveStagePicUrl, 10, false);
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.z.getLayoutParams();
                    marginLayoutParams.topMargin = this.m.getResources().getDimensionPixelSize(R.dimen.tbds24);
                    this.z.setLayoutParams(marginLayoutParams);
                } else {
                    this.X = false;
                    this.G.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.z.getLayoutParams();
                    marginLayoutParams2.topMargin = this.m.getResources().getDimensionPixelSize(R.dimen.tbds44);
                    this.z.setLayoutParams(marginLayoutParams2);
                }
                if (this.X && sparseArray != null && sparseArray.size() > 0) {
                    this.Z.b((d2) this.o, "ala_frs_demo_hell_live_feed_back_type");
                } else if (this.Z.a() != null) {
                    this.Z.a().setVisibility(8);
                }
                ((d2) this.o).b3(false, true);
                this.z.setData((d2) this.o);
                SpannableStringBuilder h1 = ((d2) this.o).h1();
                if (h1 != null && !StringUtils.isNull(h1.toString())) {
                    this.F.setText(((d2) this.o).h1());
                    this.F.setVisibility(0);
                } else {
                    this.F.setVisibility(8);
                }
                if (((d2) this.o).m1().audience_count > 0) {
                    this.N.setVisibility(0);
                    this.K.setVisibility(0);
                    this.K.setText(String.format(this.m.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(((d2) this.o).m1().audience_count)));
                } else {
                    this.N.setVisibility(8);
                    this.K.setVisibility(8);
                }
                this.L.setVisibility(8);
                if (((d2) this.o).m1().openRecomReason == 1) {
                    String str = ((d2) this.o).m1().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.L.setVisibility(0);
                        this.L.setText(str);
                    } else {
                        String w0 = ((d2) this.o).w0();
                        String C0 = ((d2) this.o).C0();
                        if (UtilHelper.isDecimal(w0) && UtilHelper.isDecimal(C0) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo c2 = b.a.r0.a3.j0.a.e().c();
                            String str2 = c2.latitude;
                            String str3 = c2.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.a(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(w0), Double.parseDouble(C0)) <= 50.0d) {
                                this.L.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                                this.L.setVisibility(0);
                            }
                        }
                    }
                }
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.O.getLayoutParams();
                if (((d2) this.o).m1() != null && !StringUtils.isNull(((d2) this.o).m1().forumUserLiveMsg)) {
                    this.P.setVisibility(0);
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(((d2) this.o).m1().forumUserLiveMsg, 10, "...");
                    this.Q.setText(cutChineseAndEnglishWithSuffix + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_forum_live_suffix));
                    layoutParams3.addRule(3, R.id.forum_friends_now_looking);
                } else {
                    this.P.setVisibility(8);
                    layoutParams3.addRule(3, R.id.video_card_content_layout);
                }
                this.O.setLayoutParams(layoutParams3);
                b0(S(1));
                R((d2) this.o);
                this.W.setVisibility((b.a.r0.x0.b.f().i() || b.a.r0.x0.a.h().j()) ? 0 : 0);
                k(this.m, TbadkCoreApplication.getInst().getSkinType());
                U();
                this.J.playAnimation();
                B(this.E);
                this.S.bindData((d2) this.o);
                this.S.setStaticsLocationPage("2");
                return;
            }
            this.E.setVisibility(8);
        }
    }

    public void Z(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) || bdUniqueId == null || this.p == null) {
            return;
        }
        CardUserInfoLayout cardUserInfoLayout = this.z;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        m(bdUniqueId);
        v(bdUniqueId);
    }

    @Override // b.a.r0.b0.b0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.T = str;
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.U = z;
        }
    }

    public void b0(int i2) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (t = this.o) == 0) {
            return;
        }
        if (i2 == 1) {
            this.p.setVisibility(8);
            this.A.setData((d2) this.o);
            return;
        }
        this.B.setVisibility(this.p.setData((d2) t) ? 8 : 0);
        this.A.setVisibility(8);
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? R.layout.frs_ala_video_layout_new : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    @SuppressLint({"ResourceAsColor"})
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, tbPageContext, i2) == null) {
            if (this.f16223e != i2) {
                u(tbPageContext, i2);
                b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.E);
                d2.n(R.string.J_X06);
                d2.i(R.color.CAM_X0205, R.color.CAM_X0206);
                b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(this.H);
                d3.l(R.dimen.L_X01);
                d3.k(R.color.CAM_X0401);
                d3.n(R.string.J_X05);
                d3.f(R.color.CAM_X0611);
                float g2 = l.g(getContext(), R.dimen.tbds31);
                SkinManager.setBackgroundEndColorToAutoColor(this.M, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{g2, g2, g2, g2, g2, g2, g2, g2});
                SkinManager.setBackgroundColor(this.N, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.K, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.L, R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(l.g(getContext(), R.dimen.tbds31)).defaultStrokeColor(R.color.CAM_X0304).strokeWidth(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2)).into(this.P);
                SkinManager.setViewTextColor(this.Q, R.color.CAM_X0304);
                WebPManager.setPureDrawable(this.R, R.drawable.icon_ala_watching, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
                this.z.onChangeSkinType(h(), TbadkCoreApplication.getInst().getSkinType());
                this.I.setPlaceHolder(3);
                this.p.onChangeSkinType();
                this.f16223e = i2;
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.A;
                if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                    this.A.onChangeSkinType();
                }
            }
            T t = this.o;
            if (t != 0 && m.k(((d2) t).f0())) {
                SkinManager.setViewTextColor(this.F, R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.F, R.color.CAM_X0105);
            }
            SkinManager.setBackgroundColor(this.W, R.color.CAM_X0201);
            this.Z.c();
            this.S.onChangeSkin(i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, view) == null) || b.a.r0.x0.b.f().i() || b.a.r0.x0.a.h().j()) {
            return;
        }
        if (view != this.E && view != this.p.getCommentContainer() && view != this.C && view != this.A.mSharePraiseView.getCommentContainer() && view != this.q.getCommentContainer() && view != this.P) {
            if (view.getId() == R.id.video_container) {
                if (f() != null) {
                    f().a(view, this.o);
                }
                V(getContext(), (d2) this.o);
                return;
            }
            return;
        }
        T t = this.o;
        if (t != 0) {
            m.a(((d2) t).f0());
        }
        if (f() != null) {
            f().a(this.E, this.o);
        }
        V(getContext(), (d2) this.o);
        if (this.o != 0) {
            if (view == this.p.getCommentContainer() || view == this.A.mSharePraiseView.getCommentContainer()) {
                StatisticItem statisticItem = new StatisticItem("c12942");
                statisticItem.param("obj_locate", 2);
                statisticItem.param("obj_type", 5);
                statisticItem.param("tid", ((d2) this.o).t1());
                statisticItem.param("nid", ((d2) this.o).F0());
                b.a.q0.m0.c f2 = TbPageExtraHelper.f(view);
                if (f2 != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
                }
                if (TbPageExtraHelper.m() != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    @Override // b.a.r0.b0.b0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
        }
    }

    @Override // b.a.r0.p.e
    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.V = str;
        }
    }
}
