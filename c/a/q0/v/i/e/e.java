package c.a.q0.v.i.e;

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
import c.a.p0.s.k;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.f;
import c.a.q0.a0.m;
import c.a.q0.a0.z;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardUserInfoLayout;
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
public class e extends c.a.q0.a0.a<c2> implements z, c.a.q0.o.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadSkinView A;
    public RelativeLayout B;
    public TextView C;
    public TbImageView D;
    public RelativeLayout E;
    public TbImageView F;
    public TBLottieAnimationView G;
    public TextView H;
    public TextView I;
    public LinearLayout J;
    public View K;
    public FrameLayout L;
    public LinearLayout M;
    public TextView N;
    public ImageView O;
    public String P;
    public boolean Q;
    public String R;
    public View S;
    public boolean T;
    public int U;
    public c.a.q0.v.i.d.a V;
    public final View.OnClickListener W;
    public CardUserInfoLayout w;
    public ThreadSourceShareAndPraiseLayout x;
    public View y;
    public LinearLayout z;

    /* loaded from: classes4.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f25619e;

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
            this.f25619e = eVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25619e.G.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f25619e.G.cancelAnimation();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f25620e;

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
            this.f25620e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25620e.g() == null) {
                return;
            }
            this.f25620e.g().a(view, this.f25620e.o);
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
        this.Q = false;
        this.U = 0;
        this.W = new b(this);
        n(bdUniqueId);
        this.m = tbPageContext;
        View j2 = j();
        RelativeLayout relativeLayout = (RelativeLayout) j2.findViewById(R.id.layout_root);
        this.B = relativeLayout;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        layoutParams.bottomMargin = 0;
        this.z = (LinearLayout) j2.findViewById(R.id.video_card_content_layout);
        this.B.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) j2.findViewById(R.id.video_card_stage_view);
        this.D = tbImageView;
        tbImageView.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.D.setDefaultBgResource(R.color.transparent);
        CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) j2.findViewById(R.id.card_ala_video_user_info_layout);
        this.w = cardUserInfoLayout;
        cardUserInfoLayout.setUserAfterClickListener(this.W);
        this.C = (TextView) j2.findViewById(R.id.text_title);
        this.E = (RelativeLayout) j2.findViewById(R.id.frame_video);
        TbImageView tbImageView2 = (TbImageView) j2.findViewById(R.id.image_video);
        this.F = tbImageView2;
        tbImageView2.setDrawCorner(true);
        this.F.setPlaceHolder(3);
        this.F.setDefaultResource(0);
        this.F.setRadiusById(R.string.J_X05);
        this.F.setConrers(15);
        this.F.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.F.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.F.setBorderSurroundContent(true);
        this.F.setDrawBorder(true);
        this.J = (LinearLayout) j2.findViewById(R.id.ala_live_lottie_bg);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) j2.findViewById(R.id.ala_live_lottie);
        this.G = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        SkinManager.setLottieAnimation(this.G, R.raw.ala_live2);
        this.G.addOnAttachStateChangeListener(new a(this));
        this.H = (TextView) j2.findViewById(R.id.play_count);
        this.I = (TextView) j2.findViewById(R.id.ala_live_recom_reason);
        this.K = j2.findViewById(R.id.play_count_line);
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
        fVar.f14219b = 2;
        fVar.f14225h = 2;
        this.p.setAgreeStatisticData(fVar);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = (ThreadCommentAndPraiseInfoLayout) j2.findViewById(R.id.card_bottom_op_weight_layout);
        this.q = threadCommentAndPraiseInfoLayout2;
        s(threadCommentAndPraiseInfoLayout2);
        this.q.setFrom(2);
        this.q.setShareReportFrom(1);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) j2.findViewById(R.id.text_bottom_2);
        this.x = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.mSharePraiseView.setOnClickListener(this);
        this.x.mSharePraiseView.getCommentContainer().setOnClickListener(this);
        this.x.setFrom(2);
        this.x.setShareReportFrom(1);
        this.x.setSourceFromForPb(3);
        this.x.setStType(FrsFragment.STAR_FRS);
        this.x.setHideBarName(true);
        this.y = j2.findViewById(R.id.divider_below_reply_number_layout);
        this.A = (ThreadSkinView) j2.findViewById(R.id.frs_thread_skin);
        View findViewById = j2.findViewById(R.id.thread_multi_del_mask_view);
        this.S = findViewById;
        findViewById.setClickable(true);
        c.a.q0.v.i.d.a aVar = new c.a.q0.v.i.d.a(tbPageContext, this.w.getSuffixContainer());
        this.V = aVar;
        aVar.d(h());
        this.L = (FrameLayout) j2.findViewById(R.id.text_bottom_layout);
        this.M = (LinearLayout) j2.findViewById(R.id.forum_friends_now_looking);
        this.N = (TextView) j2.findViewById(R.id.tv_forum_friends_now_looking);
        this.O = (ImageView) j2.findViewById(R.id.image_forum_friends_now_looking);
    }

    public final void O(c2 c2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, c2Var, str) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", c2Var.f0()).param("obj_locate", this.Q ? 2 : 1).param("obj_id", c2Var.j1().live_id).param("obj_type", 2));
            if (c2Var.j1() != null && c2Var.j1().user_info != null && c2Var.j1().user_info.is_official == 2) {
                TiebaStatic.log(new StatisticItem("c12801").param("tid", c2Var.f0()));
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (c2Var.Z().equals(this.P)) {
                    TiebaStatic.log(new StatisticItem("c11843").param("uid", currentAccount).param("fid", c2Var.T()));
                } else {
                    TiebaStatic.log(new StatisticItem("c11845").param("uid", currentAccount).param("fid", c2Var.T()));
                }
            }
        }
    }

    public final void P(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2Var) == null) || c2Var == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12125").param("tid", c2Var.f0()).param("obj_locate", this.Q ? 2 : 1).param("obj_id", c2Var.j1().live_id).param("obj_type", 2));
        if (c2Var.j1() == null || c2Var.j1().user_info == null || c2Var.j1().user_info.is_official != 2) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12800").param("tid", c2Var.f0()));
    }

    public int Q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? c.a.q0.o.d.c().b(this.R, i2) : invokeI.intValue;
    }

    public void R() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (k.c().g() && (t = this.o) != 0) {
                c2 c2Var = (c2) t;
                c2Var.getThreadData();
                if (c2Var != null) {
                    c2 c2Var2 = (c2) this.o;
                    c2Var2.getThreadData();
                    if (c2Var2.j1() != null) {
                        this.F.setPlaceHolder(3);
                        TbImageView tbImageView = this.F;
                        c2 c2Var3 = (c2) this.o;
                        c2Var3.getThreadData();
                        tbImageView.startLoad(c2Var3.j1().cover, 10, false);
                        this.E.setVisibility(0);
                        return;
                    }
                }
            }
            this.E.setVisibility(8);
        }
    }

    public void S(Context context, c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, context, c2Var) == null) || context == null || c2Var == null || c2Var.j1() == null) {
            return;
        }
        if (!j.z()) {
            l.L(context, R.string.no_network_guide);
            return;
        }
        String str = this.T ? AlaLiveRoomActivityConfig.FREM_TYPE_LIVE_FRS_STAGE_LIVE : AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
        if (c2Var.a0() != null) {
            str = c2Var.a0();
        }
        int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
        if (frsCurTabType == 14) {
            str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + c2Var.T();
        } else if (frsCurTabType == 13) {
            str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + c2Var.T();
        }
        O(c2Var, str);
        AlaInfoData j1 = c2Var.j1();
        if (j1.isLegalYYLiveData()) {
            TbPageContext<?> tbPageContext = this.m;
            YyExtData yyExtData = j1.mYyExtData;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "" + j1.roomId, YYLiveUtil.SOURCE_FRS_LIVE_CARD_TAB);
            U(((c2) this.o).q1(), String.valueOf(((c2) this.o).T()), String.valueOf(j1.roomId), String.valueOf(j1.live_id), j1.mYyExtData.mSid);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.a0.b
    /* renamed from: T */
    public void k(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, c2Var) == null) {
            this.o = c2Var;
            V();
        }
    }

    public final void U(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, str, str2, str3, str4, str5) == null) {
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

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            T t = this.o;
            int i2 = 8;
            if (t != 0 && ((c2) t).J() != null) {
                this.B.setVisibility(0);
                int k = l.k(this.m.getPageActivity());
                if (k != this.U) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.E.getLayoutParams();
                    int k2 = l.k(d()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    layoutParams.width = k2;
                    layoutParams.height = (k2 * 9) / 16;
                    this.E.setLayoutParams(layoutParams);
                    this.U = k;
                }
                SparseArray<String> sparseArray = null;
                if (((c2) this.o).j1() != null && ((c2) this.o).j1().user_info != null && ((c2) this.o).j1().user_info.is_official == 2) {
                    this.T = true;
                    sparseArray = ((c2) this.o).j1().dislikeInfo;
                    this.D.setVisibility(0);
                    int[] p = l.p(d());
                    ViewGroup.LayoutParams layoutParams2 = this.D.getLayoutParams();
                    layoutParams2.width = p[0];
                    layoutParams2.height = (p[0] * 156) / 1080;
                    this.D.setLayoutParams(layoutParams2);
                    if (!TextUtils.isEmpty(((c2) this.o).j1().liveStagePicUrl)) {
                        this.D.startLoad(((c2) this.o).j1().liveStagePicUrl, 10, false);
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.w.getLayoutParams();
                    marginLayoutParams.topMargin = this.m.getResources().getDimensionPixelSize(R.dimen.tbds24);
                    this.w.setLayoutParams(marginLayoutParams);
                } else {
                    this.T = false;
                    this.D.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.w.getLayoutParams();
                    marginLayoutParams2.topMargin = this.m.getResources().getDimensionPixelSize(R.dimen.tbds44);
                    this.w.setLayoutParams(marginLayoutParams2);
                }
                if (this.T && sparseArray != null && sparseArray.size() > 0) {
                    this.V.b((c2) this.o, "ala_frs_demo_hell_live_feed_back_type");
                } else if (this.V.a() != null) {
                    this.V.a().setVisibility(8);
                }
                ((c2) this.o).T2(false, true);
                this.w.setData((c2) this.o);
                SpannableStringBuilder e1 = ((c2) this.o).e1();
                if (e1 != null && !StringUtils.isNull(e1.toString())) {
                    this.C.setText(((c2) this.o).e1());
                    this.C.setVisibility(0);
                } else {
                    this.C.setVisibility(8);
                }
                if (((c2) this.o).j1().audience_count > 0) {
                    this.K.setVisibility(0);
                    this.H.setVisibility(0);
                    this.H.setText(String.format(this.m.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(((c2) this.o).j1().audience_count)));
                } else {
                    this.K.setVisibility(8);
                    this.H.setVisibility(8);
                }
                this.I.setVisibility(8);
                if (((c2) this.o).j1().openRecomReason == 1) {
                    String str = ((c2) this.o).j1().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.I.setVisibility(0);
                        this.I.setText(str);
                    } else {
                        String u0 = ((c2) this.o).u0();
                        String A0 = ((c2) this.o).A0();
                        if (UtilHelper.isDecimal(u0) && UtilHelper.isDecimal(A0) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo c2 = c.a.q0.x2.j0.a.e().c();
                            String str2 = c2.latitude;
                            String str3 = c2.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.a(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(u0), Double.parseDouble(A0)) <= 50.0d) {
                                this.I.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                                this.I.setVisibility(0);
                            }
                        }
                    }
                }
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.L.getLayoutParams();
                if (((c2) this.o).j1() != null && !StringUtils.isNull(((c2) this.o).j1().forumUserLiveMsg)) {
                    this.M.setVisibility(0);
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(((c2) this.o).j1().forumUserLiveMsg, 10, "...");
                    this.N.setText(cutChineseAndEnglishWithSuffix + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_forum_live_suffix));
                    layoutParams3.addRule(3, R.id.forum_friends_now_looking);
                } else {
                    this.M.setVisibility(8);
                    layoutParams3.addRule(3, R.id.video_card_content_layout);
                }
                this.L.setLayoutParams(layoutParams3);
                Y(Q(1));
                P((c2) this.o);
                this.S.setVisibility((c.a.q0.v0.b.f().i() || c.a.q0.v0.a.h().j()) ? 0 : 0);
                l(this.m, TbadkCoreApplication.getInst().getSkinType());
                R();
                this.G.playAnimation();
                z(this.B);
                return;
            }
            this.B.setVisibility(8);
        }
    }

    public void W(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) || bdUniqueId == null || this.p == null) {
            return;
        }
        CardUserInfoLayout cardUserInfoLayout = this.w;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        n(bdUniqueId);
        v(bdUniqueId);
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.Q = z;
        }
    }

    public void Y(int i2) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (t = this.o) == 0) {
            return;
        }
        if (i2 == 1) {
            this.p.setVisibility(8);
            this.x.setData((c2) this.o);
            return;
        }
        this.y.setVisibility(this.p.setData((c2) t) ? 8 : 0);
        this.x.setVisibility(8);
    }

    @Override // c.a.q0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.P = str;
        }
    }

    @Override // c.a.q0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? R.layout.frs_ala_video_layout_new : invokeV.intValue;
    }

    @Override // c.a.q0.a0.b
    @SuppressLint({"ResourceAsColor"})
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, tbPageContext, i2) == null) {
            if (this.f15231e != i2) {
                u(tbPageContext, i2);
                c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(this.B);
                d2.n(R.string.J_X06);
                d2.i(R.color.CAM_X0205, R.color.CAM_X0206);
                c.a.p0.s.u.c d3 = c.a.p0.s.u.c.d(this.E);
                d3.l(R.dimen.L_X01);
                d3.k(R.color.CAM_X0401);
                d3.n(R.string.J_X05);
                d3.f(R.color.CAM_X0611);
                float g2 = l.g(d(), R.dimen.tbds31);
                SkinManager.setBackgroundEndColorToAutoColor(this.J, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{g2, g2, g2, g2, g2, g2, g2, g2});
                SkinManager.setBackgroundColor(this.K, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.H, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.I, R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(l.g(d(), R.dimen.tbds31)).defaultStrokeColor(R.color.CAM_X0304).strokeWidth(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2)).into(this.M);
                SkinManager.setViewTextColor(this.N, R.color.CAM_X0304);
                WebPManager.setPureDrawable(this.O, R.drawable.icon_ala_watching, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
                this.w.onChangeSkinType(i(), TbadkCoreApplication.getInst().getSkinType());
                this.F.setPlaceHolder(3);
                this.p.onChangeSkinType();
                this.f15231e = i2;
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.x;
                if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                    this.x.onChangeSkinType();
                }
            }
            T t = this.o;
            if (t != 0 && m.k(((c2) t).f0())) {
                SkinManager.setViewTextColor(this.C, R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.C, R.color.CAM_X0105);
            }
            SkinManager.setBackgroundColor(this.S, R.color.CAM_X0201);
            this.V.c();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, view) == null) || c.a.q0.v0.b.f().i() || c.a.q0.v0.a.h().j()) {
            return;
        }
        if (view != this.B && view != this.p.getCommentContainer() && view != this.z && view != this.x.mSharePraiseView.getCommentContainer() && view != this.q.getCommentContainer() && view != this.M) {
            if (view.getId() == R.id.video_container) {
                if (g() != null) {
                    g().a(view, this.o);
                }
                S(d(), (c2) this.o);
                return;
            }
            return;
        }
        T t = this.o;
        if (t != 0) {
            m.a(((c2) t).f0());
        }
        if (g() != null) {
            g().a(this.B, this.o);
        }
        S(d(), (c2) this.o);
        if (this.o != 0) {
            if (view == this.p.getCommentContainer() || view == this.x.mSharePraiseView.getCommentContainer()) {
                StatisticItem statisticItem = new StatisticItem("c12942");
                statisticItem.param("obj_locate", 2);
                statisticItem.param("obj_type", 5);
                statisticItem.param("tid", ((c2) this.o).q1());
                statisticItem.param("nid", ((c2) this.o).D0());
                c.a.p0.k0.c f2 = TbPageExtraHelper.f(view);
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

    @Override // c.a.q0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
        }
    }

    @Override // c.a.q0.o.e
    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.R = str;
        }
    }
}
