package c.a.r0.a0;

import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.d1.t0;
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
/* loaded from: classes3.dex */
public class k extends c.a.r0.a0.a<c.a.r0.a0.d0.j> implements c.a.r0.o.e {
    public static /* synthetic */ Interceptable $ic;
    public static final int W;
    public transient /* synthetic */ FieldHolder $fh;
    public CardUserInfoLayout A;
    public TextView B;
    public RelativeLayout C;
    public TbImageView D;
    public TextView E;
    public TBLottieAnimationView F;
    public TextView G;
    public LinearLayout H;
    public View I;
    public FrameLayout J;
    public TBLottieAnimationView K;
    public View L;
    public TextView M;
    public TextView N;
    public LinearLayout O;
    public TextView P;
    public ImageView Q;
    public TbLiveContainer R;
    public boolean S;
    public int T;
    public View.OnClickListener U;
    public CustomMessageListener V;
    public FrameLayout y;
    public LinearLayout z;

    /* loaded from: classes3.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f15622e;

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
            this.f15622e = kVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15622e.K.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f15622e.K.cancelAnimation();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f15623e;

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
            this.f15623e = kVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15623e.F.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f15623e.F.cancelAnimation();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f15624e;

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
            this.f15624e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15624e.g() == null) {
                return;
            }
            this.f15624e.g().a(view, this.f15624e.o);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f15625a;

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
            this.f15625a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            T t;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || (t = this.f15625a.o) == 0 || ((c.a.r0.a0.d0.j) t).f15571e == null || ((c.a.r0.a0.d0.j) t).f15571e.s1() == null || this.f15625a.B == null || !((String) customResponsedMessage.getData()).equals(((c.a.r0.a0.d0.j) this.f15625a.o).f15571e.s1())) {
                return;
            }
            k kVar = this.f15625a;
            TextView textView = kVar.B;
            String f0 = ((c.a.r0.a0.d0.j) kVar.o).f15571e.f0();
            int i2 = R.color.CAM_X0109;
            m.l(textView, f0, i2, i2);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1779189093, "Lc/a/r0/a0/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1779189093, "Lc/a/r0/a0/k;");
                return;
            }
        }
        W = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
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
        this.S = false;
        this.T = 0;
        this.U = new c(this);
        this.V = new d(this, 2001390);
        this.m = tbPageContext;
        this.n = bdUniqueId;
        U(j());
    }

    public View Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            CardUserInfoLayout cardUserInfoLayout = this.A;
            if (cardUserInfoLayout != null) {
                return cardUserInfoLayout.getAvatar();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public TbLiveContainer R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.R : (TbLiveContainer) invokeV.objValue;
    }

    public View S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.S) {
                CardUserInfoLayout cardUserInfoLayout = this.A;
                if (cardUserInfoLayout != null) {
                    return cardUserInfoLayout.getUserName();
                }
                return null;
            }
            return this.B;
        }
        return (View) invokeV.objValue;
    }

    public void T() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (c.a.q0.s.k.c().g() && (t = this.o) != 0 && ((c.a.r0.a0.d0.j) t).getThreadData() != null && ((c.a.r0.a0.d0.j) this.o).getThreadData().l1() != null) {
                this.D.setPlaceHolder(3);
                this.D.startLoad(((c.a.r0.a0.d0.j) this.o).getThreadData().l1().cover, 10, false);
                this.C.setVisibility(0);
                return;
            }
            this.C.setVisibility(8);
        }
    }

    public final void U(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.y = (FrameLayout) view.findViewById(R.id.layout_root);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content_layout);
            this.z = linearLayout;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
            layoutParams.bottomMargin = 0;
            CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
            this.A = cardUserInfoLayout;
            cardUserInfoLayout.setPageContext(this.m);
            this.A.setPageUniqueId(this.n);
            this.B = (TextView) view.findViewById(R.id.text_title);
            this.C = (RelativeLayout) view.findViewById(R.id.frame_video);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image_video);
            this.D = tbImageView;
            tbImageView.setDrawCorner(true);
            this.D.setPlaceHolder(3);
            this.D.setDefaultResource(0);
            this.D.setRadiusById(R.string.J_X05);
            this.D.setConrers(15);
            this.D.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.D.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.D.setBorderSurroundContent(true);
            this.D.setDrawBorder(true);
            this.J = (FrameLayout) view.findViewById(R.id.ala_live_lottie_bg_new);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie_new);
            this.K = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            SkinManager.setLottieAnimation(this.K, R.raw.lottie_ala_live);
            this.K.addOnAttachStateChangeListener(new a(this));
            this.L = view.findViewById(R.id.ala_live_page_bg_new);
            this.M = (TextView) view.findViewById(R.id.ala_live_state);
            this.N = (TextView) view.findViewById(R.id.play_count_new);
            this.H = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
            TBLottieAnimationView tBLottieAnimationView2 = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
            this.F = tBLottieAnimationView2;
            tBLottieAnimationView2.loop(true);
            SkinManager.setLottieAnimation(this.F, R.raw.ala_live2);
            this.F.addOnAttachStateChangeListener(new b(this));
            this.G = (TextView) view.findViewById(R.id.play_count);
            this.I = view.findViewById(R.id.play_count_line);
            this.E = (TextView) view.findViewById(R.id.ala_live_recom_reason);
            this.u = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
            this.p = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
            this.q = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
            s(this.p);
            s(this.q);
            this.z.setOnClickListener(this);
            this.O = (LinearLayout) view.findViewById(R.id.forum_friends_now_looking);
            this.P = (TextView) view.findViewById(R.id.tv_forum_friends_now_looking);
            this.Q = (ImageView) view.findViewById(R.id.image_forum_friends_now_looking);
            this.R = (TbLiveContainer) view.findViewById(R.id.tb_live_container);
            this.O.setOnClickListener(this);
            this.x = view.findViewById(R.id.card_bottom_margin);
            c.a.q0.b.g.b.h(view.findViewById(R.id.imageMask), R.color.transparent);
        }
    }

    public final boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            T t = this.o;
            return t != 0 && ((c.a.r0.a0.d0.j) t).getThreadData() != null && ((c.a.r0.a0.d0.j) this.o).getThreadData().a2 && c.a.q0.b.d.M();
        }
        return invokeV.booleanValue;
    }

    public final boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            T t = this.o;
            return t != 0 && ((c.a.r0.a0.d0.j) t).getThreadData() != null && ((c.a.r0.a0.d0.j) this.o).getThreadData().a2 && c.a.q0.b.d.N();
        }
        return invokeV.booleanValue;
    }

    public final void X(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.f15558f;
            urlManager.dealOneLink(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void Y(View view) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            if (g() != null) {
                g().a(view, this.o);
            }
            T t = this.o;
            if (t == 0 || ((c.a.r0.a0.d0.j) t).getThreadData() == null || ((c.a.r0.a0.d0.j) this.o).getThreadData().l1() == null) {
                return;
            }
            AlaInfoData l1 = ((c.a.r0.a0.d0.j) this.o).getThreadData().l1();
            m.a(((c.a.r0.a0.d0.j) this.o).f15571e.f0());
            m.l(this.B, ((c.a.r0.a0.d0.j) this.o).f15571e.f0(), R.color.CAM_X0105, R.color.CAM_X0109);
            if (l1.isLegalYYLiveData()) {
                if (((c.a.r0.a0.d0.j) this.o).getThreadData().a2) {
                    str = t0.d(this.R.getContext()) ? YYLiveUtil.SOURCE_HOME_RECOMMEND_AUTO_PLAY : YYLiveUtil.SOURCE_HOME_RECOMMEND_PLAY;
                } else {
                    str = ((c.a.r0.a0.d0.j) this.o).getThreadData().b2 ? YYLiveUtil.SOURCE_HOME_FOLLOW_TAB_CARD : YYLiveUtil.SOURCE_NOT_DEFINE;
                }
                String str2 = str;
                TbPageContext<?> tbPageContext = this.m;
                YyExtData yyExtData = l1.mYyExtData;
                String str3 = yyExtData.mSid;
                String str4 = yyExtData.mSsid;
                String str5 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str3, str4, str5, "" + l1.roomId, str2);
                a0(((c.a.r0.a0.d0.j) this.o).getThreadData().s1(), String.valueOf(((c.a.r0.a0.d0.j) this.o).getThreadData().T()), String.valueOf(l1.roomId), String.valueOf(l1.live_id), l1.mYyExtData.mSid);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a0.b
    /* renamed from: Z */
    public void k(c.a.r0.a0.d0.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jVar) == null) {
            this.o = jVar;
            if (W()) {
                x(true);
            }
            b0();
        }
    }

    public final void a0(String str, String str2, String str3, String str4, String str5) {
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

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            T t = this.o;
            if (t != 0 && ((c.a.r0.a0.d0.j) t).getThreadData() != null) {
                this.y.setVisibility(0);
                int k = c.a.e.e.p.l.k(this.m.getPageActivity());
                if (k != this.T) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.C.getLayoutParams();
                    int dimenPixelSize = k - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    layoutParams.width = dimenPixelSize;
                    layoutParams.height = (dimenPixelSize * 9) / 16;
                    this.C.setLayoutParams(layoutParams);
                    this.T = k;
                }
                if (((c.a.r0.a0.d0.j) this.o).getThreadData().l1() != null && ((c.a.r0.a0.d0.j) this.o).getThreadData().l1().isChushou) {
                    this.p.setShowFlag(10);
                    this.p.hideShareContainer();
                } else {
                    this.p.setShowFlag(11);
                    this.p.resetShareContainer();
                }
                this.A.setVisibility(0);
                this.A.setData(((c.a.r0.a0.d0.j) this.o).getThreadData());
                this.A.setUserAfterClickListener(this.U);
                ((c.a.r0.a0.d0.j) this.o).getThreadData().c3();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(((c.a.r0.a0.d0.j) this.o).getThreadData().g1());
                if (TextUtils.isEmpty(spannableStringBuilder)) {
                    this.B.setVisibility(8);
                } else {
                    this.B.setText(spannableStringBuilder);
                    this.B.setVisibility(0);
                    ThreadCardUtils.setTitleStyleAb(this.B, ((c.a.r0.a0.d0.j) this.o).getThreadData());
                }
                if (V()) {
                    this.J.setVisibility(0);
                    this.H.setVisibility(8);
                    if (((c.a.r0.a0.d0.j) this.o).f15571e.l1().audience_count > 0) {
                        this.N.setVisibility(0);
                        this.N.setText(String.format(this.m.getResources().getString(R.string.ala_audience_count_prefix_new), StringHelper.numFormatOverWan(((c.a.r0.a0.d0.j) this.o).f15571e.l1().audience_count)));
                    } else {
                        this.N.setVisibility(8);
                    }
                } else {
                    this.J.setVisibility(8);
                    this.H.setVisibility(0);
                    if (((c.a.r0.a0.d0.j) this.o).f15571e.l1().audience_count > 0) {
                        this.I.setVisibility(0);
                        this.G.setVisibility(0);
                        this.G.setText(String.format(this.m.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(((c.a.r0.a0.d0.j) this.o).f15571e.l1().audience_count)));
                    } else {
                        this.I.setVisibility(8);
                        this.G.setVisibility(8);
                    }
                }
                this.E.setVisibility(8);
                if (((c.a.r0.a0.d0.j) this.o).f15571e.l1().openRecomReason == 1) {
                    String str = ((c.a.r0.a0.d0.j) this.o).f15571e.l1().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.E.setVisibility(0);
                        this.E.setText(str);
                    } else {
                        String w0 = ((c.a.r0.a0.d0.j) this.o).f15571e.w0();
                        String C0 = ((c.a.r0.a0.d0.j) this.o).f15571e.C0();
                        if (UtilHelper.isDecimal(w0) && UtilHelper.isDecimal(C0) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo c2 = c.a.r0.y2.j0.a.e().c();
                            String str2 = c2.latitude;
                            String str3 = c2.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && c.a.e.e.p.l.a(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(w0), Double.parseDouble(C0)) <= 50.0d) {
                                this.E.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                                this.E.setVisibility(0);
                            }
                        }
                    }
                }
                if (((c.a.r0.a0.d0.j) this.o).f15571e.l1() != null && !StringUtils.isNull(((c.a.r0.a0.d0.j) this.o).f15571e.l1().forumUserLiveMsg)) {
                    this.O.setVisibility(0);
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(((c.a.r0.a0.d0.j) this.o).f15571e.l1().forumUserLiveMsg, 10, "...");
                    this.P.setText(cutChineseAndEnglishWithSuffix + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_forum_live_suffix));
                } else {
                    this.O.setVisibility(8);
                }
                B(this.y);
                l(this.m, TbadkCoreApplication.getInst().getSkinType());
                if (m.k(((c.a.r0.a0.d0.j) this.o).f15571e.f0())) {
                    SkinManager.setViewTextColor(this.B, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.B, R.color.CAM_X0105, 1);
                }
                T();
                if (V()) {
                    this.K.playAnimation();
                } else {
                    this.F.playAnimation();
                }
                this.R.bindData(((c.a.r0.a0.d0.j) this.o).f15571e);
                this.R.setStaticsLocationPage("1");
                return;
            }
            this.y.setVisibility(8);
        }
    }

    public void c0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bdUniqueId) == null) || bdUniqueId == null || this.p == null || this.V == null) {
            return;
        }
        n(bdUniqueId);
        w(bdUniqueId);
        CardUserInfoLayout cardUserInfoLayout = this.A;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        this.V.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.V);
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.S = z;
        }
    }

    public void e0(int i2) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (threadCommentAndPraiseInfoLayout = this.p) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.statFloor = String.valueOf(i2);
    }

    @Override // c.a.r0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? R.layout.card_home_page_ala_live_item_new : invokeV.intValue;
    }

    @Override // c.a.r0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048593, this, tbPageContext, i2) == null) || this.f15557e == i2) {
            return;
        }
        v(tbPageContext, i2);
        c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.z);
        d2.o(R.string.J_X06);
        d2.j(R.color.CAM_X0205, R.color.CAM_X0206);
        c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(this.C);
        d3.m(R.dimen.L_X01);
        d3.l(R.color.CAM_X0401);
        d3.o(R.string.J_X05);
        d3.f(R.color.CAM_X0611);
        float g2 = c.a.e.e.p.l.g(d(), R.dimen.tbds31);
        float[] fArr = {g2, g2, g2, g2, g2, g2, g2, g2};
        SkinManager.setViewTextColor(this.B, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.E, R.color.CAM_X0101);
        TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(c.a.e.e.p.l.g(d(), R.dimen.tbds31)).defaultStrokeColor(R.color.CAM_X0304).strokeWidth(W).into(this.O);
        SkinManager.setViewTextColor(this.P, R.color.CAM_X0304);
        WebPManager.setPureDrawable(this.Q, R.drawable.icon_ala_watching, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.A.onChangeSkinType(i(), TbadkCoreApplication.getInst().getSkinType());
        this.R.onChangeSkin(i2);
        this.D.setPlaceHolder(3);
        TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0310).into(this.L);
        c.a.q0.s.u.c d4 = c.a.q0.s.u.c.d(this.J);
        d4.o(R.string.J_X01);
        d4.f(R.color.CAM_X0605);
        c.a.q0.s.u.c d5 = c.a.q0.s.u.c.d(this.M);
        d5.w(R.color.CAM_X0101);
        d5.A(R.dimen.T_X09);
        c.a.q0.s.u.c d6 = c.a.q0.s.u.c.d(this.N);
        d6.A(R.dimen.T_X09);
        d6.w(R.color.CAM_X0101);
        SkinManager.setBackgroundEndColorToAutoColor(this.H, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, fArr);
        SkinManager.setBackgroundColor(this.I, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.G, R.color.CAM_X0101);
        this.f15557e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view) == null) {
            if (view == this.z || view == this.p.getCommentContainer() || view == this.q.getCommentContainer() || view == this.O) {
                if (((c.a.r0.a0.d0.j) this.o).getThreadData().l1() != null && ((c.a.r0.a0.d0.j) this.o).getThreadData().l1().isChushou) {
                    X(((c.a.r0.a0.d0.j) this.o).getThreadData().l1().thirdRoomId, ((c.a.r0.a0.d0.j) this.o).getThreadData().l1().thirdLiveType);
                } else {
                    Y(view);
                }
            }
        }
    }

    @Override // c.a.r0.o.e
    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
        }
    }
}
