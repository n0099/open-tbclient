package c.a.t0.g0;

import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.e1.t0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.card.view.TbLiveContainer;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes7.dex */
public class k extends c.a.t0.g0.a<c.a.t0.g0.f0.j> implements c.a.t0.t.e {
    public static /* synthetic */ Interceptable $ic;
    public static final int c0;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public CardUserInfoLayout B;
    public TextView C;
    public RelativeLayout D;
    public TbImageView E;
    public TextView F;
    public TBLottieAnimationView G;
    public TextView H;
    public LinearLayout I;
    public View J;
    public FrameLayout K;
    public TBLottieAnimationView L;
    public View M;
    public TextView N;
    public TextView O;
    public LinearLayout P;
    public TextView Q;
    public ImageView R;
    public TbLiveContainer S;
    public ViewGroup T;
    public ImageView U;
    public TextView V;
    public TextView W;
    public TbImageView X;
    public boolean Y;
    public int Z;
    public View.OnClickListener a0;
    public CustomMessageListener b0;
    public FrameLayout z;

    /* loaded from: classes7.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f17823e;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17823e = kVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17823e.L.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f17823e.L.cancelAnimation();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f17824e;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17824e = kVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17824e.G.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f17824e.G.cancelAnimation();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f17825e;

        public c(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17825e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17825e.g() == null) {
                return;
            }
            this.f17825e.g().a(view, this.f17825e.o);
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(k kVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            T t;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || (t = this.a.o) == 0 || ((c.a.t0.g0.f0.j) t).f17778e == null || ((c.a.t0.g0.f0.j) t).f17778e.v1() == null || this.a.C == null || !((String) customResponsedMessage.getData()).equals(((c.a.t0.g0.f0.j) this.a.o).f17778e.v1())) {
                return;
            }
            k kVar = this.a;
            TextView textView = kVar.C;
            String g0 = ((c.a.t0.g0.f0.j) kVar.o).f17778e.g0();
            int i2 = R.color.CAM_X0109;
            m.l(textView, g0, i2, i2);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(975383593, "Lc/a/t0/g0/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(975383593, "Lc/a/t0/g0/k;");
                return;
            }
        }
        c0 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.Y = false;
        this.Z = 0;
        this.a0 = new c(this);
        this.b0 = new d(this, 2001390);
        this.m = tbPageContext;
        this.n = bdUniqueId;
        P(j());
    }

    public View K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            CardUserInfoLayout cardUserInfoLayout = this.B;
            if (cardUserInfoLayout != null) {
                return cardUserInfoLayout.getAvatar();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public TbLiveContainer L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.S : (TbLiveContainer) invokeV.objValue;
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.Y) {
                CardUserInfoLayout cardUserInfoLayout = this.B;
                if (cardUserInfoLayout != null) {
                    return cardUserInfoLayout.getUserName();
                }
                return null;
            }
            return this.C;
        }
        return (View) invokeV.objValue;
    }

    public void N() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (c.a.s0.s.k.c().g() && (t = this.o) != 0 && ((c.a.t0.g0.f0.j) t).getThreadData() != null && ((c.a.t0.g0.f0.j) this.o).getThreadData().o1() != null) {
                this.E.setPlaceHolder(3);
                this.E.startLoad(((c.a.t0.g0.f0.j) this.o).getThreadData().o1().cover, 10, false);
                this.D.setVisibility(0);
                return;
            }
            this.D.setVisibility(8);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            T t = this.o;
            if (t != 0 && ((c.a.t0.g0.f0.j) t).getThreadData() != null && ((c.a.t0.g0.f0.j) this.o).getThreadData().o1() != null && ((c.a.t0.g0.f0.j) this.o).getThreadData().o1().mYyExtData != null) {
                String str = ((c.a.t0.g0.f0.j) this.o).getThreadData().o1().mYyExtData.mRankShow;
                if (TextUtils.isEmpty(str)) {
                    this.T.setVisibility(8);
                    return;
                } else if (!Q()) {
                    this.T.setVisibility(8);
                    return;
                } else if (!c.a.s0.b.d.x()) {
                    this.T.setVisibility(8);
                    return;
                } else {
                    try {
                        String substring = str.substring(0, 3);
                        String substring2 = str.substring(3);
                        this.V.setText(substring);
                        this.W.setText(substring2);
                        this.T.setVisibility(0);
                        return;
                    } catch (Exception e2) {
                        this.T.setVisibility(8);
                        e2.printStackTrace();
                        return;
                    }
                }
            }
            this.T.setVisibility(8);
        }
    }

    public final void P(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.z = (FrameLayout) view.findViewById(R.id.layout_root);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content_layout);
            this.A = linearLayout;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
            layoutParams.bottomMargin = 0;
            CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
            this.B = cardUserInfoLayout;
            cardUserInfoLayout.setPageContext(this.m);
            this.B.setPageUniqueId(this.n);
            this.C = (TextView) view.findViewById(R.id.text_title);
            this.D = (RelativeLayout) view.findViewById(R.id.frame_video);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image_video);
            this.E = tbImageView;
            tbImageView.setDrawCorner(true);
            this.E.setPlaceHolder(3);
            this.E.setDefaultResource(0);
            this.E.setRadiusById(R.string.J_X05);
            this.E.setConrers(15);
            this.E.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.E.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.E.setBorderSurroundContent(true);
            this.E.setDrawBorder(true);
            this.K = (FrameLayout) view.findViewById(R.id.ala_live_lottie_bg_new);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie_new);
            this.L = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            SkinManager.setLottieAnimation(this.L, R.raw.lottie_ala_live);
            this.L.addOnAttachStateChangeListener(new a(this));
            this.M = view.findViewById(R.id.ala_live_page_bg_new);
            this.N = (TextView) view.findViewById(R.id.ala_live_state);
            this.O = (TextView) view.findViewById(R.id.play_count_new);
            this.I = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
            TBLottieAnimationView tBLottieAnimationView2 = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
            this.G = tBLottieAnimationView2;
            tBLottieAnimationView2.loop(true);
            SkinManager.setLottieAnimation(this.G, R.raw.ala_live2);
            this.G.addOnAttachStateChangeListener(new b(this));
            this.T = (ViewGroup) view.findViewById(R.id.ala_live_rank_show_layout);
            this.U = (ImageView) view.findViewById(R.id.ala_live_rank_show_icon);
            this.V = (TextView) view.findViewById(R.id.ala_live_rank_show_title);
            this.W = (TextView) view.findViewById(R.id.ala_live_rank_show_number);
            this.X = (TbImageView) view.findViewById(R.id.live_game_show_icon);
            this.H = (TextView) view.findViewById(R.id.play_count);
            this.J = view.findViewById(R.id.play_count_line);
            this.F = (TextView) view.findViewById(R.id.ala_live_recom_reason);
            this.u = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
            this.p = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
            this.q = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
            s(this.p);
            s(this.q);
            this.A.setOnClickListener(this);
            this.P = (LinearLayout) view.findViewById(R.id.forum_friends_now_looking);
            this.Q = (TextView) view.findViewById(R.id.tv_forum_friends_now_looking);
            this.R = (ImageView) view.findViewById(R.id.image_forum_friends_now_looking);
            this.S = (TbLiveContainer) view.findViewById(R.id.tb_live_container);
            this.P.setOnClickListener(this);
            this.y = view.findViewById(R.id.card_bottom_margin);
            c.a.s0.b.g.b.h(view.findViewById(R.id.imageMask), R.color.transparent);
        }
    }

    public final boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            T t = this.o;
            if (t == 0 || ((c.a.t0.g0.f0.j) t).getThreadData() == null) {
                return false;
            }
            return ((c.a.t0.g0.f0.j) this.o).getThreadData().a2;
        }
        return invokeV.booleanValue;
    }

    public final void R(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.f17767f;
            urlManager.dealOneLink(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void S(View view) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            if (g() != null) {
                g().a(view, this.o);
            }
            T t = this.o;
            if (t == 0 || ((c.a.t0.g0.f0.j) t).getThreadData() == null || ((c.a.t0.g0.f0.j) this.o).getThreadData().o1() == null) {
                return;
            }
            AlaInfoData o1 = ((c.a.t0.g0.f0.j) this.o).getThreadData().o1();
            m.a(((c.a.t0.g0.f0.j) this.o).f17778e.g0());
            m.l(this.C, ((c.a.t0.g0.f0.j) this.o).f17778e.g0(), R.color.CAM_X0105, R.color.CAM_X0109);
            if (o1.isLegalYYLiveData()) {
                if (((c.a.t0.g0.f0.j) this.o).getThreadData().a2) {
                    str = t0.d(this.S.getContext()) ? YYLiveUtil.SOURCE_HOME_RECOMMEND_AUTO_PLAY : YYLiveUtil.SOURCE_HOME_RECOMMEND_PLAY;
                } else {
                    str = ((c.a.t0.g0.f0.j) this.o).getThreadData().b2 ? YYLiveUtil.SOURCE_HOME_FOLLOW_TAB_CARD : YYLiveUtil.SOURCE_NOT_DEFINE;
                }
                String str2 = str;
                TbPageContext<?> tbPageContext = this.m;
                YyExtData yyExtData = o1.mYyExtData;
                String str3 = yyExtData.mSid;
                String str4 = yyExtData.mSsid;
                String str5 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str3, str4, str5, "" + o1.roomId, o1.mYyExtData.streamInfo, str2);
                U(((c.a.t0.g0.f0.j) this.o).getThreadData().v1(), String.valueOf(((c.a.t0.g0.f0.j) this.o).getThreadData().U()), String.valueOf(o1.roomId), String.valueOf(o1.live_id), o1.mYyExtData.mSid);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.g0.b
    /* renamed from: T */
    public void k(c.a.t0.g0.f0.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jVar) == null) {
            this.o = jVar;
            if (Q()) {
                x(true);
            }
            V();
        }
    }

    public final void U(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048586, this, str, str2, str3, str4, str5) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            T t = this.o;
            if (t != 0 && ((c.a.t0.g0.f0.j) t).getThreadData() != null) {
                this.z.setVisibility(0);
                int k = c.a.d.f.p.n.k(this.m.getPageActivity());
                if (k != this.Z) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.D.getLayoutParams();
                    int dimenPixelSize = k - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    layoutParams.width = dimenPixelSize;
                    layoutParams.height = (dimenPixelSize * 9) / 16;
                    this.D.setLayoutParams(layoutParams);
                    this.Z = k;
                }
                if (((c.a.t0.g0.f0.j) this.o).getThreadData().o1() != null && ((c.a.t0.g0.f0.j) this.o).getThreadData().o1().isChushou) {
                    this.p.setShowFlag(10);
                    this.p.hideShareContainer();
                } else {
                    this.p.setShowFlag(11);
                    this.p.resetShareContainer();
                }
                this.B.setVisibility(0);
                this.B.setData(((c.a.t0.g0.f0.j) this.o).getThreadData());
                this.B.setUserAfterClickListener(this.a0);
                ((c.a.t0.g0.f0.j) this.o).getThreadData().g3();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(((c.a.t0.g0.f0.j) this.o).getThreadData().i1());
                if (TextUtils.isEmpty(spannableStringBuilder)) {
                    this.C.setVisibility(8);
                } else {
                    this.C.setText(spannableStringBuilder);
                    this.C.setVisibility(0);
                    ThreadCardUtils.setTitleStyleAb(this.C, ((c.a.t0.g0.f0.j) this.o).getThreadData());
                }
                if (Q()) {
                    this.K.setVisibility(0);
                    this.I.setVisibility(8);
                    ((RelativeLayout.LayoutParams) this.T.getLayoutParams()).addRule(1, R.id.ala_live_lottie_bg_new);
                    ((RelativeLayout.LayoutParams) this.T.getLayoutParams()).addRule(6, R.id.ala_live_lottie_bg_new);
                    if (((c.a.t0.g0.f0.j) this.o).f17778e.o1().audience_count > 0) {
                        this.O.setVisibility(0);
                        this.O.setText(String.format(this.m.getResources().getString(R.string.ala_audience_count_prefix_new), StringHelper.numFormatOverWan(((c.a.t0.g0.f0.j) this.o).f17778e.o1().audience_count)));
                    } else {
                        this.O.setVisibility(8);
                    }
                } else {
                    this.K.setVisibility(8);
                    this.I.setVisibility(0);
                    ((RelativeLayout.LayoutParams) this.T.getLayoutParams()).addRule(1, R.id.ala_live_lottie_bg);
                    ((RelativeLayout.LayoutParams) this.T.getLayoutParams()).addRule(6, R.id.ala_live_lottie_bg);
                    if (((c.a.t0.g0.f0.j) this.o).f17778e.o1().audience_count > 0) {
                        this.J.setVisibility(0);
                        this.H.setVisibility(0);
                        this.H.setText(String.format(this.m.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(((c.a.t0.g0.f0.j) this.o).f17778e.o1().audience_count)));
                    } else {
                        this.J.setVisibility(8);
                        this.H.setVisibility(8);
                    }
                }
                this.T.setVisibility(8);
                this.F.setVisibility(8);
                if (((c.a.t0.g0.f0.j) this.o).f17778e.o1().openRecomReason == 1) {
                    String str = ((c.a.t0.g0.f0.j) this.o).f17778e.o1().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.F.setVisibility(0);
                        this.F.setText(str);
                    } else {
                        String x0 = ((c.a.t0.g0.f0.j) this.o).f17778e.x0();
                        String D0 = ((c.a.t0.g0.f0.j) this.o).f17778e.D0();
                        if (UtilHelper.isDecimal(x0) && UtilHelper.isDecimal(D0) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo c2 = c.a.t0.j3.j0.a.e().c();
                            String str2 = c2.latitude;
                            String str3 = c2.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && c.a.d.f.p.n.g(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(x0), Double.parseDouble(D0)) <= 50.0d) {
                                this.F.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                                this.F.setVisibility(0);
                            }
                        }
                    }
                }
                if (((c.a.t0.g0.f0.j) this.o).f17778e.o1() != null && !StringUtils.isNull(((c.a.t0.g0.f0.j) this.o).f17778e.o1().forumUserLiveMsg)) {
                    this.P.setVisibility(0);
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(((c.a.t0.g0.f0.j) this.o).f17778e.o1().forumUserLiveMsg, 10, "...");
                    this.Q.setText(cutChineseAndEnglishWithSuffix + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_forum_live_suffix));
                } else {
                    this.P.setVisibility(8);
                }
                y(true);
                C(this.z);
                l(this.m, TbadkCoreApplication.getInst().getSkinType());
                if (m.k(((c.a.t0.g0.f0.j) this.o).f17778e.g0())) {
                    SkinManager.setViewTextColor(this.C, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.C, R.color.CAM_X0105, 1);
                }
                N();
                if (Q()) {
                    this.L.playAnimation();
                } else {
                    this.G.playAnimation();
                }
                this.S.bindData(((c.a.t0.g0.f0.j) this.o).f17778e);
                this.S.setStaticsLocationPage("1");
                Y();
                return;
            }
            this.z.setVisibility(8);
        }
    }

    public void W(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bdUniqueId) == null) || bdUniqueId == null || this.p == null || this.b0 == null) {
            return;
        }
        n(bdUniqueId);
        w(bdUniqueId);
        CardUserInfoLayout cardUserInfoLayout = this.B;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        this.b0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.b0);
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.Y = z;
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            T t = this.o;
            if (t != 0 && ((c.a.t0.g0.f0.j) t).getThreadData() != null && ((c.a.t0.g0.f0.j) this.o).getThreadData().o1() != null && ((c.a.t0.g0.f0.j) this.o).getThreadData().o1().mYyExtData != null) {
                if (!Q()) {
                    this.X.setVisibility(8);
                    return;
                } else if (!c.a.s0.b.d.H()) {
                    this.X.setVisibility(8);
                    return;
                } else {
                    String str = ((c.a.t0.g0.f0.j) this.o).getThreadData().o1().mYyExtData.mIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        this.X.setVisibility(8);
                        return;
                    }
                    this.X.setVisibility(0);
                    this.X.setPlaceHolder(0);
                    this.X.startLoad(str, 10, false);
                    return;
                }
            }
            this.X.setVisibility(8);
        }
    }

    public void Z(int i2) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (threadCommentAndPraiseInfoLayout = this.p) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.statFloor = String.valueOf(i2);
    }

    @Override // c.a.t0.t.e
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
        }
    }

    @Override // c.a.t0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? R.layout.card_home_page_ala_live_item_new : invokeV.intValue;
    }

    @Override // c.a.t0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048595, this, tbPageContext, i2) == null) || this.f17766e == i2) {
            return;
        }
        v(tbPageContext, i2);
        c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.A);
        d2.n(R.string.J_X06);
        d2.i(R.color.CAM_X0205, R.color.CAM_X0206);
        float f2 = c.a.d.f.p.n.f(getContext(), R.dimen.tbds31);
        float[] fArr = {f2, f2, f2, f2, f2, f2, f2, f2};
        SkinManager.setViewTextColor(this.C, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.F, R.color.CAM_X0101);
        TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(c.a.d.f.p.n.f(getContext(), R.dimen.tbds31)).defaultStrokeColor(R.color.CAM_X0304).strokeWidth(c0).into(this.P);
        SkinManager.setViewTextColor(this.Q, R.color.CAM_X0304);
        WebPManager.setPureDrawable(this.R, R.drawable.icon_ala_watching, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.B.onChangeSkinType(i(), TbadkCoreApplication.getInst().getSkinType());
        this.S.onChangeSkin(i2);
        this.E.setPlaceHolder(3);
        TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0310).into(this.M);
        c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(this.K);
        d3.n(R.string.J_X01);
        d3.f(R.color.CAM_X0605);
        c.a.s0.s.u.c d4 = c.a.s0.s.u.c.d(this.N);
        d4.v(R.color.CAM_X0101);
        d4.z(R.dimen.T_X09);
        c.a.s0.s.u.c d5 = c.a.s0.s.u.c.d(this.O);
        d5.z(R.dimen.T_X09);
        d5.v(R.color.CAM_X0101);
        SkinManager.setBackgroundEndColorToAutoColor(this.I, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, fArr);
        SkinManager.setBackgroundColor(this.J, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.H, R.color.CAM_X0101);
        c.a.s0.s.u.c d6 = c.a.s0.s.u.c.d(this.T);
        d6.n(R.string.J_X01);
        d6.f(R.color.CAM_X0605);
        this.U.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_ala_live_rank_top, WebPManager.ResourceStateType.NORMAL_DISABLE));
        c.a.s0.s.u.c.d(this.V).v(R.color.CAM_X0314);
        c.a.s0.s.u.c.d(this.W).v(R.color.CAM_X0101);
        this.f17766e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view) == null) {
            if (view == this.A || view == this.p.getCommentContainer() || view == this.q.getCommentContainer() || view == this.P) {
                if (((c.a.t0.g0.f0.j) this.o).getThreadData().o1() != null && ((c.a.t0.g0.f0.j) this.o).getThreadData().o1().isChushou) {
                    R(((c.a.t0.g0.f0.j) this.o).getThreadData().o1().thirdRoomId, ((c.a.t0.g0.f0.j) this.o).getThreadData().o1().thirdLiveType);
                } else {
                    S(view);
                }
            }
        }
    }
}
