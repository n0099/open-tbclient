package c.a.p0.c0.k.e;

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
import c.a.d.f.p.n;
import c.a.o0.r.l;
import c.a.o0.r.r.f;
import c.a.p0.h0.m;
import c.a.p0.h0.z;
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
import com.baidu.tbadk.core.data.ThreadData;
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
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes2.dex */
public class e extends c.a.p0.h0.a<ThreadData> implements z, c.a.p0.v.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout A;
    public TextView B;
    public TbImageView C;
    public RelativeLayout D;
    public TbImageView E;
    public TBLottieAnimationView F;
    public TextView G;
    public TextView H;
    public LinearLayout I;
    public View J;
    public FrameLayout K;
    public LinearLayout L;
    public TextView M;
    public ImageView N;
    public TbLiveContainer O;
    public String P;
    public boolean Q;
    public String R;
    public View S;
    public boolean T;
    public int U;
    public c.a.p0.c0.k.d.a V;
    public final View.OnClickListener W;
    public CardUserInfoLayout v;
    public ThreadSourceShareAndPraiseLayout w;
    public View x;
    public LinearLayout y;
    public ThreadSkinView z;

    /* loaded from: classes2.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.F.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.a.F.cancelAnimation();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
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
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.Q = false;
        this.U = 0;
        this.W = new b(this);
        o(bdUniqueId);
        this.i = tbPageContext;
        View k = k();
        RelativeLayout relativeLayout = (RelativeLayout) k.findViewById(R.id.obfuscated_res_0x7f0911f5);
        this.A = relativeLayout;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        layoutParams.bottomMargin = 0;
        this.y = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f092317);
        this.A.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f092319);
        this.C = tbImageView;
        tbImageView.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.C.setDefaultBgResource(R.color.transparent);
        CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) k.findViewById(R.id.obfuscated_res_0x7f0904c5);
        this.v = cardUserInfoLayout;
        cardUserInfoLayout.setUserAfterClickListener(this.W);
        this.B = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091f51);
        this.D = (RelativeLayout) k.findViewById(R.id.obfuscated_res_0x7f090aaf);
        TbImageView tbImageView2 = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f090e86);
        this.E = tbImageView2;
        tbImageView2.setDrawCorner(true);
        this.E.setPlaceHolder(3);
        this.E.setDefaultResource(0);
        this.E.setRadiusById(R.string.J_X05);
        this.E.setConrers(15);
        this.E.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.E.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.E.setBorderSurroundContent(true);
        this.E.setDrawBorder(true);
        this.I = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f0901e9);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) k.findViewById(R.id.obfuscated_res_0x7f0901e8);
        this.F = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        SkinManager.setLottieAnimation(this.F, R.raw.ala_live2);
        this.F.addOnAttachStateChangeListener(new a(this));
        this.G = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091856);
        this.H = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0901f2);
        this.J = k.findViewById(R.id.obfuscated_res_0x7f091857);
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
        this.w = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.f30173b.setOnClickListener(this);
        this.w.f30173b.getCommentContainer().setOnClickListener(this);
        this.w.setFrom(2);
        this.w.setShareReportFrom(1);
        this.w.setSourceFromForPb(3);
        this.w.setStType("frs_page");
        this.w.setHideBarName(true);
        this.x = k.findViewById(R.id.obfuscated_res_0x7f0907e8);
        this.z = (ThreadSkinView) k.findViewById(R.id.obfuscated_res_0x7f090be6);
        View findViewById = k.findViewById(R.id.obfuscated_res_0x7f091fba);
        this.S = findViewById;
        findViewById.setClickable(true);
        c.a.p0.c0.k.d.a aVar = new c.a.p0.c0.k.d.a(tbPageContext, this.v.getSuffixContainer());
        this.V = aVar;
        aVar.d(i());
        this.K = (FrameLayout) k.findViewById(R.id.obfuscated_res_0x7f091f2c);
        this.L = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f090a40);
        this.M = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0921b9);
        this.N = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f090e71);
        this.O = (TbLiveContainer) k.findViewById(R.id.obfuscated_res_0x7f091f01);
    }

    public final void L(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, threadData, str) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", threadData.getId()).param("obj_locate", this.Q ? 2 : 1).param("obj_id", threadData.getThreadAlaInfo().live_id).param("obj_type", 2));
            if (threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().user_info != null && threadData.getThreadAlaInfo().user_info.is_official == 2) {
                TiebaStatic.log(new StatisticItem("c12801").param("tid", threadData.getId()));
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (threadData.getForum_name().equals(this.P)) {
                    TiebaStatic.log(new StatisticItem("c11843").param("uid", currentAccount).param("fid", threadData.getFid()));
                } else {
                    TiebaStatic.log(new StatisticItem("c11845").param("uid", currentAccount).param("fid", threadData.getFid()));
                }
            }
        }
    }

    public final void M(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) || threadData == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12125").param("tid", threadData.getId()).param("obj_locate", this.Q ? 2 : 1).param("obj_id", threadData.getThreadAlaInfo().live_id).param("obj_type", 2));
        if (threadData.getThreadAlaInfo() == null || threadData.getThreadAlaInfo().user_info == null || threadData.getThreadAlaInfo().user_info.is_official != 2) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12800").param("tid", threadData.getId()));
    }

    public int N(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? c.a.p0.v.d.c().b(this.R, i) : invokeI.intValue;
    }

    public TbLiveContainer O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.O : (TbLiveContainer) invokeV.objValue;
    }

    public void P() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (l.c().g() && (t = this.k) != 0 && ((ThreadData) t).getThreadData() != null && ((ThreadData) this.k).getThreadData().getThreadAlaInfo() != null) {
                this.E.setPlaceHolder(3);
                this.E.J(((ThreadData) this.k).getThreadData().getThreadAlaInfo().cover, 10, false);
                this.D.setVisibility(0);
                return;
            }
            this.D.setVisibility(8);
        }
    }

    public void Q(Context context, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, context, threadData) == null) || context == null || threadData == null || threadData.getThreadAlaInfo() == null) {
            return;
        }
        if (!c.a.d.f.p.l.z()) {
            n.M(context, R.string.obfuscated_res_0x7f0f0c4c);
            return;
        }
        String str = this.T ? AlaLiveRoomActivityConfig.FREM_TYPE_LIVE_FRS_STAGE_LIVE : AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
        if (threadData.getFromType() != null) {
            str = threadData.getFromType();
        }
        int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
        if (frsCurTabType == 14) {
            str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + threadData.getFid();
        } else if (frsCurTabType == 13) {
            str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + threadData.getFid();
        }
        L(threadData, str);
        AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
        if (threadAlaInfo.isLegalYYLiveData()) {
            TbPageContext<?> tbPageContext = this.i;
            YyExtData yyExtData = threadAlaInfo.mYyExtData;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "" + threadAlaInfo.roomId, threadAlaInfo.mYyExtData.streamInfo, YYLiveUtil.SOURCE_FRS_LIVE_CARD_TAB);
            S(((ThreadData) this.k).getTid(), String.valueOf(((ThreadData) this.k).getFid()), String.valueOf(threadAlaInfo.roomId), String.valueOf(threadAlaInfo.live_id), threadAlaInfo.mYyExtData.mSid);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: R */
    public void l(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) {
            this.k = threadData;
            T();
        }
    }

    public final void S(String str, String str2, String str3, String str4, String str5) {
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

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            T t = this.k;
            int i = 8;
            if (t != 0 && ((ThreadData) t).getAuthor() != null) {
                this.A.setVisibility(0);
                int k = n.k(this.i.getPageActivity());
                if (k != this.U) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.D.getLayoutParams();
                    int k2 = n.k(getContext()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    layoutParams.width = k2;
                    layoutParams.height = (k2 * 9) / 16;
                    this.D.setLayoutParams(layoutParams);
                    this.U = k;
                }
                SparseArray<String> sparseArray = null;
                if (((ThreadData) this.k).getThreadAlaInfo() != null && ((ThreadData) this.k).getThreadAlaInfo().user_info != null && ((ThreadData) this.k).getThreadAlaInfo().user_info.is_official == 2) {
                    this.T = true;
                    sparseArray = ((ThreadData) this.k).getThreadAlaInfo().dislikeInfo;
                    this.C.setVisibility(0);
                    int[] p = n.p(getContext());
                    ViewGroup.LayoutParams layoutParams2 = this.C.getLayoutParams();
                    layoutParams2.width = p[0];
                    layoutParams2.height = (p[0] * Cea708Decoder.COMMAND_DS4) / 1080;
                    this.C.setLayoutParams(layoutParams2);
                    if (!TextUtils.isEmpty(((ThreadData) this.k).getThreadAlaInfo().liveStagePicUrl)) {
                        this.C.J(((ThreadData) this.k).getThreadAlaInfo().liveStagePicUrl, 10, false);
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
                    marginLayoutParams.topMargin = this.i.getResources().getDimensionPixelSize(R.dimen.tbds24);
                    this.v.setLayoutParams(marginLayoutParams);
                } else {
                    this.T = false;
                    this.C.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
                    marginLayoutParams2.topMargin = this.i.getResources().getDimensionPixelSize(R.dimen.tbds44);
                    this.v.setLayoutParams(marginLayoutParams2);
                }
                if (this.T && sparseArray != null && sparseArray.size() > 0) {
                    this.V.b((ThreadData) this.k, "ala_frs_demo_hell_live_feed_back_type");
                } else if (this.V.a() != null) {
                    this.V.a().setVisibility(8);
                }
                ((ThreadData) this.k).parserSpecTitleForFrsAndPb(false, true);
                this.v.setData((ThreadData) this.k);
                SpannableStringBuilder span_str = ((ThreadData) this.k).getSpan_str();
                if (span_str != null && !StringUtils.isNull(span_str.toString())) {
                    this.B.setText(((ThreadData) this.k).getSpan_str());
                    this.B.setVisibility(0);
                } else {
                    this.B.setVisibility(8);
                }
                if (((ThreadData) this.k).getThreadAlaInfo().audience_count > 0) {
                    this.J.setVisibility(0);
                    this.G.setVisibility(0);
                    this.G.setText(String.format(this.i.getResources().getString(R.string.obfuscated_res_0x7f0f01f7), StringHelper.numFormatOverWan(((ThreadData) this.k).getThreadAlaInfo().audience_count)));
                } else {
                    this.J.setVisibility(8);
                    this.G.setVisibility(8);
                }
                this.H.setVisibility(8);
                if (((ThreadData) this.k).getThreadAlaInfo().openRecomReason == 1) {
                    String str = ((ThreadData) this.k).getThreadAlaInfo().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.H.setVisibility(0);
                        this.H.setText(str);
                    } else {
                        String latitude = ((ThreadData) this.k).getLatitude();
                        String longtitude = ((ThreadData) this.k).getLongtitude();
                        if (UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(longtitude) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo c2 = c.a.p0.l3.k0.a.e().c();
                            String str2 = c2.latitude;
                            String str3 = c2.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && n.g(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(latitude), Double.parseDouble(longtitude)) <= 50.0d) {
                                this.H.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f023d));
                                this.H.setVisibility(0);
                            }
                        }
                    }
                }
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.K.getLayoutParams();
                if (((ThreadData) this.k).getThreadAlaInfo() != null && !StringUtils.isNull(((ThreadData) this.k).getThreadAlaInfo().forumUserLiveMsg)) {
                    this.L.setVisibility(0);
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(((ThreadData) this.k).getThreadAlaInfo().forumUserLiveMsg, 10, StringHelper.STRING_MORE);
                    this.M.setText(cutChineseAndEnglishWithSuffix + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0214));
                    layoutParams3.addRule(3, R.id.obfuscated_res_0x7f090a40);
                } else {
                    this.L.setVisibility(8);
                    layoutParams3.addRule(3, R.id.obfuscated_res_0x7f092317);
                }
                this.K.setLayoutParams(layoutParams3);
                W(N(1));
                M((ThreadData) this.k);
                this.S.setVisibility((c.a.p0.f1.b.f().i() || c.a.p0.f1.a.h().j()) ? 0 : 0);
                m(this.i, TbadkCoreApplication.getInst().getSkinType());
                P();
                this.F.playAnimation();
                D(this.A);
                this.O.b((ThreadData) this.k);
                this.O.setStaticsLocationPage("2");
                return;
            }
            this.A.setVisibility(8);
        }
    }

    public void U(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) || bdUniqueId == null || this.l == null) {
            return;
        }
        CardUserInfoLayout cardUserInfoLayout = this.v;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        o(bdUniqueId);
        x(bdUniqueId);
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.Q = z;
        }
    }

    public void W(int i) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || (t = this.k) == 0) {
            return;
        }
        if (i == 1) {
            this.l.setVisibility(8);
            this.w.g((ThreadData) this.k);
            return;
        }
        this.x.setVisibility(this.l.setData((ThreadData) t) ? 8 : 0);
        this.w.setVisibility(8);
    }

    @Override // c.a.p0.h0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.P = str;
        }
    }

    @Override // c.a.p0.v.e
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.R = str;
        }
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? R.layout.obfuscated_res_0x7f0d0304 : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    @SuppressLint({"ResourceAsColor"})
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, tbPageContext, i) == null) {
            if (this.a != i) {
                w(tbPageContext, i);
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.A);
                d2.n(R.string.J_X06);
                d2.i(R.color.CAM_X0205, R.color.CAM_X0206);
                c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.D);
                d3.l(R.dimen.L_X01);
                d3.k(R.color.CAM_X0401);
                d3.n(R.string.J_X05);
                d3.f(R.color.CAM_X0611);
                float f2 = n.f(getContext(), R.dimen.tbds31);
                SkinManager.setBackgroundEndColorToAutoColor(this.I, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
                SkinManager.setBackgroundColor(this.J, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.G, (int) R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.H, (int) R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(n.f(getContext(), R.dimen.tbds31)).defaultStrokeColor(R.color.CAM_X0304).strokeWidth(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds2)).into(this.L);
                SkinManager.setViewTextColor(this.M, (int) R.color.CAM_X0304);
                WebPManager.setPureDrawable(this.N, R.drawable.obfuscated_res_0x7f080671, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
                this.v.onChangeSkinType(j(), TbadkCoreApplication.getInst().getSkinType());
                this.E.setPlaceHolder(3);
                this.l.onChangeSkinType();
                this.a = i;
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.w;
                if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                    this.w.f();
                }
            }
            T t = this.k;
            if (t != 0 && m.k(((ThreadData) t).getId())) {
                SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0105);
            }
            SkinManager.setBackgroundColor(this.S, R.color.CAM_X0201);
            this.V.c();
            this.O.d(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, view) == null) || c.a.p0.f1.b.f().i() || c.a.p0.f1.a.h().j()) {
            return;
        }
        if (view != this.A && view != this.l.getCommentContainer() && view != this.y && view != this.w.f30173b.getCommentContainer() && view != this.m.getCommentContainer() && view != this.L) {
            if (view.getId() == R.id.obfuscated_res_0x7f09231b) {
                if (h() != null) {
                    h().a(view, this.k);
                }
                Q(getContext(), (ThreadData) this.k);
                return;
            }
            return;
        }
        T t = this.k;
        if (t != 0) {
            m.a(((ThreadData) t).getId());
        }
        if (h() != null) {
            h().a(this.A, this.k);
        }
        Q(getContext(), (ThreadData) this.k);
        if (this.k != 0) {
            if (view == this.l.getCommentContainer() || view == this.w.f30173b.getCommentContainer()) {
                StatisticItem statisticItem = new StatisticItem("c12942");
                statisticItem.param("obj_locate", 2);
                statisticItem.param("obj_type", 5);
                statisticItem.param("tid", ((ThreadData) this.k).getTid());
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
    }

    @Override // c.a.p0.h0.z
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
        }
    }
}
