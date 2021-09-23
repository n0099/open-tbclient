package c.a.r0.v.k.e;

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
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.q0.s.k;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.f;
import c.a.r0.a0.m;
import c.a.r0.a0.z;
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
/* loaded from: classes4.dex */
public class e extends c.a.r0.a0.a<d2> implements z, c.a.r0.o.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public LinearLayout B;
    public ThreadSkinView C;
    public RelativeLayout D;
    public TextView E;
    public TbImageView F;
    public RelativeLayout G;
    public TbImageView H;
    public TBLottieAnimationView I;
    public TextView J;
    public TextView K;
    public LinearLayout L;
    public View M;
    public FrameLayout N;
    public LinearLayout O;
    public TextView P;
    public ImageView Q;
    public TbLiveContainer R;
    public String S;
    public boolean T;
    public String U;
    public View V;
    public boolean W;
    public int X;
    public c.a.r0.v.k.d.a Y;
    public final View.OnClickListener Z;
    public CardUserInfoLayout y;
    public ThreadSourceShareAndPraiseLayout z;

    /* loaded from: classes4.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f26120e;

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
            this.f26120e = eVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26120e.I.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f26120e.I.cancelAnimation();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f26121e;

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
            this.f26121e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26121e.g() == null) {
                return;
            }
            this.f26121e.g().a(view, this.f26121e.o);
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
        this.T = false;
        this.X = 0;
        this.Z = new b(this);
        n(bdUniqueId);
        this.m = tbPageContext;
        View j2 = j();
        RelativeLayout relativeLayout = (RelativeLayout) j2.findViewById(R.id.layout_root);
        this.D = relativeLayout;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        layoutParams.bottomMargin = 0;
        this.B = (LinearLayout) j2.findViewById(R.id.video_card_content_layout);
        this.D.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) j2.findViewById(R.id.video_card_stage_view);
        this.F = tbImageView;
        tbImageView.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.F.setDefaultBgResource(R.color.transparent);
        CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) j2.findViewById(R.id.card_ala_video_user_info_layout);
        this.y = cardUserInfoLayout;
        cardUserInfoLayout.setUserAfterClickListener(this.Z);
        this.E = (TextView) j2.findViewById(R.id.text_title);
        this.G = (RelativeLayout) j2.findViewById(R.id.frame_video);
        TbImageView tbImageView2 = (TbImageView) j2.findViewById(R.id.image_video);
        this.H = tbImageView2;
        tbImageView2.setDrawCorner(true);
        this.H.setPlaceHolder(3);
        this.H.setDefaultResource(0);
        this.H.setRadiusById(R.string.J_X05);
        this.H.setConrers(15);
        this.H.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.H.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.H.setBorderSurroundContent(true);
        this.H.setDrawBorder(true);
        this.L = (LinearLayout) j2.findViewById(R.id.ala_live_lottie_bg);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) j2.findViewById(R.id.ala_live_lottie);
        this.I = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        SkinManager.setLottieAnimation(this.I, R.raw.ala_live2);
        this.I.addOnAttachStateChangeListener(new a(this));
        this.J = (TextView) j2.findViewById(R.id.play_count);
        this.K = (TextView) j2.findViewById(R.id.ala_live_recom_reason);
        this.M = j2.findViewById(R.id.play_count_line);
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
        this.z = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.mSharePraiseView.setOnClickListener(this);
        this.z.mSharePraiseView.getCommentContainer().setOnClickListener(this);
        this.z.setFrom(2);
        this.z.setShareReportFrom(1);
        this.z.setSourceFromForPb(3);
        this.z.setStType(FrsFragment.STAR_FRS);
        this.z.setHideBarName(true);
        this.A = j2.findViewById(R.id.divider_below_reply_number_layout);
        this.C = (ThreadSkinView) j2.findViewById(R.id.frs_thread_skin);
        View findViewById = j2.findViewById(R.id.thread_multi_del_mask_view);
        this.V = findViewById;
        findViewById.setClickable(true);
        c.a.r0.v.k.d.a aVar = new c.a.r0.v.k.d.a(tbPageContext, this.y.getSuffixContainer());
        this.Y = aVar;
        aVar.d(h());
        this.N = (FrameLayout) j2.findViewById(R.id.text_bottom_layout);
        this.O = (LinearLayout) j2.findViewById(R.id.forum_friends_now_looking);
        this.P = (TextView) j2.findViewById(R.id.tv_forum_friends_now_looking);
        this.Q = (ImageView) j2.findViewById(R.id.image_forum_friends_now_looking);
        this.R = (TbLiveContainer) j2.findViewById(R.id.tb_live_container);
    }

    public final void Q(d2 d2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, d2Var, str) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", d2Var.f0()).param("obj_locate", this.T ? 2 : 1).param("obj_id", d2Var.l1().live_id).param("obj_type", 2));
            if (d2Var.l1() != null && d2Var.l1().user_info != null && d2Var.l1().user_info.is_official == 2) {
                TiebaStatic.log(new StatisticItem("c12801").param("tid", d2Var.f0()));
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (d2Var.Z().equals(this.S)) {
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
        TiebaStatic.log(new StatisticItem("c12125").param("tid", d2Var.f0()).param("obj_locate", this.T ? 2 : 1).param("obj_id", d2Var.l1().live_id).param("obj_type", 2));
        if (d2Var.l1() == null || d2Var.l1().user_info == null || d2Var.l1().user_info.is_official != 2) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12800").param("tid", d2Var.f0()));
    }

    public int S(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? c.a.r0.o.d.c().b(this.U, i2) : invokeI.intValue;
    }

    public TbLiveContainer T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.R : (TbLiveContainer) invokeV.objValue;
    }

    public void U() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (k.c().g() && (t = this.o) != 0) {
                d2 d2Var = (d2) t;
                d2Var.getThreadData();
                if (d2Var != null) {
                    d2 d2Var2 = (d2) this.o;
                    d2Var2.getThreadData();
                    if (d2Var2.l1() != null) {
                        this.H.setPlaceHolder(3);
                        TbImageView tbImageView = this.H;
                        d2 d2Var3 = (d2) this.o;
                        d2Var3.getThreadData();
                        tbImageView.startLoad(d2Var3.l1().cover, 10, false);
                        this.G.setVisibility(0);
                        return;
                    }
                }
            }
            this.G.setVisibility(8);
        }
    }

    public void V(Context context, d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, context, d2Var) == null) || context == null || d2Var == null || d2Var.l1() == null) {
            return;
        }
        if (!j.z()) {
            l.L(context, R.string.no_network_guide);
            return;
        }
        String str = this.W ? AlaLiveRoomActivityConfig.FREM_TYPE_LIVE_FRS_STAGE_LIVE : AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
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
        AlaInfoData l1 = d2Var.l1();
        if (l1.isLegalYYLiveData()) {
            TbPageContext<?> tbPageContext = this.m;
            YyExtData yyExtData = l1.mYyExtData;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "" + l1.roomId, YYLiveUtil.SOURCE_FRS_LIVE_CARD_TAB);
            X(((d2) this.o).s1(), String.valueOf(((d2) this.o).T()), String.valueOf(l1.roomId), String.valueOf(l1.live_id), l1.mYyExtData.mSid);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a0.b
    /* renamed from: W */
    public void k(d2 d2Var) {
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
                this.D.setVisibility(0);
                int k = l.k(this.m.getPageActivity());
                if (k != this.X) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.G.getLayoutParams();
                    int k2 = l.k(d()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    layoutParams.width = k2;
                    layoutParams.height = (k2 * 9) / 16;
                    this.G.setLayoutParams(layoutParams);
                    this.X = k;
                }
                SparseArray<String> sparseArray = null;
                if (((d2) this.o).l1() != null && ((d2) this.o).l1().user_info != null && ((d2) this.o).l1().user_info.is_official == 2) {
                    this.W = true;
                    sparseArray = ((d2) this.o).l1().dislikeInfo;
                    this.F.setVisibility(0);
                    int[] p = l.p(d());
                    ViewGroup.LayoutParams layoutParams2 = this.F.getLayoutParams();
                    layoutParams2.width = p[0];
                    layoutParams2.height = (p[0] * 156) / 1080;
                    this.F.setLayoutParams(layoutParams2);
                    if (!TextUtils.isEmpty(((d2) this.o).l1().liveStagePicUrl)) {
                        this.F.startLoad(((d2) this.o).l1().liveStagePicUrl, 10, false);
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.y.getLayoutParams();
                    marginLayoutParams.topMargin = this.m.getResources().getDimensionPixelSize(R.dimen.tbds24);
                    this.y.setLayoutParams(marginLayoutParams);
                } else {
                    this.W = false;
                    this.F.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.y.getLayoutParams();
                    marginLayoutParams2.topMargin = this.m.getResources().getDimensionPixelSize(R.dimen.tbds44);
                    this.y.setLayoutParams(marginLayoutParams2);
                }
                if (this.W && sparseArray != null && sparseArray.size() > 0) {
                    this.Y.b((d2) this.o, "ala_frs_demo_hell_live_feed_back_type");
                } else if (this.Y.a() != null) {
                    this.Y.a().setVisibility(8);
                }
                ((d2) this.o).Z2(false, true);
                this.y.setData((d2) this.o);
                SpannableStringBuilder g1 = ((d2) this.o).g1();
                if (g1 != null && !StringUtils.isNull(g1.toString())) {
                    this.E.setText(((d2) this.o).g1());
                    this.E.setVisibility(0);
                } else {
                    this.E.setVisibility(8);
                }
                if (((d2) this.o).l1().audience_count > 0) {
                    this.M.setVisibility(0);
                    this.J.setVisibility(0);
                    this.J.setText(String.format(this.m.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(((d2) this.o).l1().audience_count)));
                } else {
                    this.M.setVisibility(8);
                    this.J.setVisibility(8);
                }
                this.K.setVisibility(8);
                if (((d2) this.o).l1().openRecomReason == 1) {
                    String str = ((d2) this.o).l1().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.K.setVisibility(0);
                        this.K.setText(str);
                    } else {
                        String w0 = ((d2) this.o).w0();
                        String C0 = ((d2) this.o).C0();
                        if (UtilHelper.isDecimal(w0) && UtilHelper.isDecimal(C0) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo c2 = c.a.r0.y2.j0.a.e().c();
                            String str2 = c2.latitude;
                            String str3 = c2.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.a(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(w0), Double.parseDouble(C0)) <= 50.0d) {
                                this.K.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                                this.K.setVisibility(0);
                            }
                        }
                    }
                }
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
                if (((d2) this.o).l1() != null && !StringUtils.isNull(((d2) this.o).l1().forumUserLiveMsg)) {
                    this.O.setVisibility(0);
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(((d2) this.o).l1().forumUserLiveMsg, 10, "...");
                    this.P.setText(cutChineseAndEnglishWithSuffix + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_forum_live_suffix));
                    layoutParams3.addRule(3, R.id.forum_friends_now_looking);
                } else {
                    this.O.setVisibility(8);
                    layoutParams3.addRule(3, R.id.video_card_content_layout);
                }
                this.N.setLayoutParams(layoutParams3);
                b0(S(1));
                R((d2) this.o);
                this.V.setVisibility((c.a.r0.w0.b.f().i() || c.a.r0.w0.a.h().j()) ? 0 : 0);
                l(this.m, TbadkCoreApplication.getInst().getSkinType());
                U();
                this.I.playAnimation();
                B(this.D);
                this.R.bindData((d2) this.o);
                this.R.setStaticsLocationPage("2");
                return;
            }
            this.D.setVisibility(8);
        }
    }

    public void Z(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) || bdUniqueId == null || this.p == null) {
            return;
        }
        CardUserInfoLayout cardUserInfoLayout = this.y;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        n(bdUniqueId);
        w(bdUniqueId);
    }

    @Override // c.a.r0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.S = str;
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.T = z;
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
            this.z.setData((d2) this.o);
            return;
        }
        this.A.setVisibility(this.p.setData((d2) t) ? 8 : 0);
        this.z.setVisibility(8);
    }

    @Override // c.a.r0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? R.layout.frs_ala_video_layout_new : invokeV.intValue;
    }

    @Override // c.a.r0.a0.b
    @SuppressLint({"ResourceAsColor"})
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, tbPageContext, i2) == null) {
            if (this.f15557e != i2) {
                v(tbPageContext, i2);
                c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.D);
                d2.o(R.string.J_X06);
                d2.j(R.color.CAM_X0205, R.color.CAM_X0206);
                c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(this.G);
                d3.m(R.dimen.L_X01);
                d3.l(R.color.CAM_X0401);
                d3.o(R.string.J_X05);
                d3.f(R.color.CAM_X0611);
                float g2 = l.g(d(), R.dimen.tbds31);
                SkinManager.setBackgroundEndColorToAutoColor(this.L, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{g2, g2, g2, g2, g2, g2, g2, g2});
                SkinManager.setBackgroundColor(this.M, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.J, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.K, R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(l.g(d(), R.dimen.tbds31)).defaultStrokeColor(R.color.CAM_X0304).strokeWidth(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2)).into(this.O);
                SkinManager.setViewTextColor(this.P, R.color.CAM_X0304);
                WebPManager.setPureDrawable(this.Q, R.drawable.icon_ala_watching, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
                this.y.onChangeSkinType(i(), TbadkCoreApplication.getInst().getSkinType());
                this.H.setPlaceHolder(3);
                this.p.onChangeSkinType();
                this.f15557e = i2;
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.z;
                if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                    this.z.onChangeSkinType();
                }
            }
            T t = this.o;
            if (t != 0 && m.k(((d2) t).f0())) {
                SkinManager.setViewTextColor(this.E, R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.E, R.color.CAM_X0105);
            }
            SkinManager.setBackgroundColor(this.V, R.color.CAM_X0201);
            this.Y.c();
            this.R.onChangeSkin(i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, view) == null) || c.a.r0.w0.b.f().i() || c.a.r0.w0.a.h().j()) {
            return;
        }
        if (view != this.D && view != this.p.getCommentContainer() && view != this.B && view != this.z.mSharePraiseView.getCommentContainer() && view != this.q.getCommentContainer() && view != this.O) {
            if (view.getId() == R.id.video_container) {
                if (g() != null) {
                    g().a(view, this.o);
                }
                V(d(), (d2) this.o);
                return;
            }
            return;
        }
        T t = this.o;
        if (t != 0) {
            m.a(((d2) t).f0());
        }
        if (g() != null) {
            g().a(this.D, this.o);
        }
        V(d(), (d2) this.o);
        if (this.o != 0) {
            if (view == this.p.getCommentContainer() || view == this.z.mSharePraiseView.getCommentContainer()) {
                StatisticItem statisticItem = new StatisticItem("c12942");
                statisticItem.param("obj_locate", 2);
                statisticItem.param("obj_type", 5);
                statisticItem.param("tid", ((d2) this.o).s1());
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
    }

    @Override // c.a.r0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
        }
    }

    @Override // c.a.r0.o.e
    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.U = str;
        }
    }
}
