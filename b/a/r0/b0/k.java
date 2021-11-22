package b.a.r0.b0;

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
import b.a.q0.c1.r0;
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
/* loaded from: classes4.dex */
public class k extends b.a.r0.b0.a<b.a.r0.b0.f0.j> implements b.a.r0.p.e {
    public static /* synthetic */ Interceptable $ic;
    public static final int b0;
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
    public boolean X;
    public int Y;
    public View.OnClickListener Z;
    public CustomMessageListener a0;
    public FrameLayout z;

    /* loaded from: classes4.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f16283e;

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
            this.f16283e = kVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16283e.L.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f16283e.L.cancelAnimation();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f16284e;

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
            this.f16284e = kVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16284e.G.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f16284e.G.cancelAnimation();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f16285e;

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
            this.f16285e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16285e.f() == null) {
                return;
            }
            this.f16285e.f().a(view, this.f16285e.o);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f16286a;

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
            this.f16286a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            T t;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || (t = this.f16286a.o) == 0 || ((b.a.r0.b0.f0.j) t).f16235e == null || ((b.a.r0.b0.f0.j) t).f16235e.t1() == null || this.f16286a.C == null || !((String) customResponsedMessage.getData()).equals(((b.a.r0.b0.f0.j) this.f16286a.o).f16235e.t1())) {
                return;
            }
            k kVar = this.f16286a;
            TextView textView = kVar.C;
            String f0 = ((b.a.r0.b0.f0.j) kVar.o).f16235e.f0();
            int i2 = R.color.CAM_X0109;
            m.l(textView, f0, i2, i2);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1651029895, "Lb/a/r0/b0/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1651029895, "Lb/a/r0/b0/k;");
                return;
            }
        }
        b0 = b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
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
        this.X = false;
        this.Y = 0;
        this.Z = new c(this);
        this.a0 = new d(this, 2001390);
        this.m = tbPageContext;
        this.n = bdUniqueId;
        V(i());
    }

    public View Q() {
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

    public TbLiveContainer R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.S : (TbLiveContainer) invokeV.objValue;
    }

    public View S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.X) {
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

    public void T() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (b.a.q0.s.k.c().g() && (t = this.o) != 0 && ((b.a.r0.b0.f0.j) t).getThreadData() != null && ((b.a.r0.b0.f0.j) this.o).getThreadData().m1() != null) {
                this.E.setPlaceHolder(3);
                this.E.startLoad(((b.a.r0.b0.f0.j) this.o).getThreadData().m1().cover, 10, false);
                this.D.setVisibility(0);
                return;
            }
            this.D.setVisibility(8);
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            T t = this.o;
            if (t != 0 && ((b.a.r0.b0.f0.j) t).getThreadData() != null && ((b.a.r0.b0.f0.j) this.o).getThreadData().m1() != null && ((b.a.r0.b0.f0.j) this.o).getThreadData().m1().mYyExtData != null) {
                String str = ((b.a.r0.b0.f0.j) this.o).getThreadData().m1().mYyExtData.mRankShow;
                if (TextUtils.isEmpty(str)) {
                    this.T.setVisibility(8);
                    return;
                } else if (!W()) {
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

    public final void V(View view) {
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
            this.H = (TextView) view.findViewById(R.id.play_count);
            this.J = view.findViewById(R.id.play_count_line);
            this.F = (TextView) view.findViewById(R.id.ala_live_recom_reason);
            this.u = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
            this.p = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
            this.q = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
            q(this.p);
            q(this.q);
            this.A.setOnClickListener(this);
            this.P = (LinearLayout) view.findViewById(R.id.forum_friends_now_looking);
            this.Q = (TextView) view.findViewById(R.id.tv_forum_friends_now_looking);
            this.R = (ImageView) view.findViewById(R.id.image_forum_friends_now_looking);
            this.S = (TbLiveContainer) view.findViewById(R.id.tb_live_container);
            this.P.setOnClickListener(this);
            this.y = view.findViewById(R.id.card_bottom_margin);
            b.a.q0.b.g.b.h(view.findViewById(R.id.imageMask), R.color.transparent);
        }
    }

    public final boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            T t = this.o;
            return t != 0 && ((b.a.r0.b0.f0.j) t).getThreadData() != null && ((b.a.r0.b0.f0.j) this.o).getThreadData().a2 && b.a.q0.b.d.S();
        }
        return invokeV.booleanValue;
    }

    public final boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            T t = this.o;
            return t != 0 && ((b.a.r0.b0.f0.j) t).getThreadData() != null && ((b.a.r0.b0.f0.j) this.o).getThreadData().a2 && b.a.q0.b.d.T();
        }
        return invokeV.booleanValue;
    }

    public final boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            T t = this.o;
            return t != 0 && ((b.a.r0.b0.f0.j) t).getThreadData() != null && ((b.a.r0.b0.f0.j) this.o).getThreadData().a2 && b.a.q0.b.d.U();
        }
        return invokeV.booleanValue;
    }

    public final void Z(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.f16224f;
            urlManager.dealOneLink(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void a0(View view) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            if (f() != null) {
                f().a(view, this.o);
            }
            T t = this.o;
            if (t == 0 || ((b.a.r0.b0.f0.j) t).getThreadData() == null || ((b.a.r0.b0.f0.j) this.o).getThreadData().m1() == null) {
                return;
            }
            AlaInfoData m1 = ((b.a.r0.b0.f0.j) this.o).getThreadData().m1();
            m.a(((b.a.r0.b0.f0.j) this.o).f16235e.f0());
            m.l(this.C, ((b.a.r0.b0.f0.j) this.o).f16235e.f0(), R.color.CAM_X0105, R.color.CAM_X0109);
            if (m1.isLegalYYLiveData()) {
                if (((b.a.r0.b0.f0.j) this.o).getThreadData().a2) {
                    str = r0.d(this.S.getContext()) ? YYLiveUtil.SOURCE_HOME_RECOMMEND_AUTO_PLAY : YYLiveUtil.SOURCE_HOME_RECOMMEND_PLAY;
                } else {
                    str = ((b.a.r0.b0.f0.j) this.o).getThreadData().b2 ? YYLiveUtil.SOURCE_HOME_FOLLOW_TAB_CARD : YYLiveUtil.SOURCE_NOT_DEFINE;
                }
                String str2 = str;
                TbPageContext<?> tbPageContext = this.m;
                YyExtData yyExtData = m1.mYyExtData;
                String str3 = yyExtData.mSid;
                String str4 = yyExtData.mSsid;
                String str5 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str3, str4, str5, "" + m1.roomId, m1.mYyExtData.streamInfo, str2);
                c0(((b.a.r0.b0.f0.j) this.o).getThreadData().t1(), String.valueOf(((b.a.r0.b0.f0.j) this.o).getThreadData().T()), String.valueOf(m1.roomId), String.valueOf(m1.live_id), m1.mYyExtData.mSid);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: b0 */
    public void j(b.a.r0.b0.f0.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jVar) == null) {
            this.o = jVar;
            if (X() || Y()) {
                w(true);
            }
            d0();
        }
    }

    public final void c0(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048588, this, str, str2, str3, str4, str5) == null) {
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

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            T t = this.o;
            if (t != 0 && ((b.a.r0.b0.f0.j) t).getThreadData() != null) {
                this.z.setVisibility(0);
                int k = b.a.e.f.p.l.k(this.m.getPageActivity());
                if (k != this.Y) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.D.getLayoutParams();
                    int dimenPixelSize = k - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    layoutParams.width = dimenPixelSize;
                    layoutParams.height = (dimenPixelSize * 9) / 16;
                    this.D.setLayoutParams(layoutParams);
                    this.Y = k;
                }
                if (((b.a.r0.b0.f0.j) this.o).getThreadData().m1() != null && ((b.a.r0.b0.f0.j) this.o).getThreadData().m1().isChushou) {
                    this.p.setShowFlag(10);
                    this.p.hideShareContainer();
                } else {
                    this.p.setShowFlag(11);
                    this.p.resetShareContainer();
                }
                this.B.setVisibility(0);
                this.B.setData(((b.a.r0.b0.f0.j) this.o).getThreadData());
                this.B.setUserAfterClickListener(this.Z);
                ((b.a.r0.b0.f0.j) this.o).getThreadData().e3();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(((b.a.r0.b0.f0.j) this.o).getThreadData().h1());
                if (TextUtils.isEmpty(spannableStringBuilder)) {
                    this.C.setVisibility(8);
                } else {
                    this.C.setText(spannableStringBuilder);
                    this.C.setVisibility(0);
                    ThreadCardUtils.setTitleStyleAb(this.C, ((b.a.r0.b0.f0.j) this.o).getThreadData());
                }
                if (!W() && !X()) {
                    this.K.setVisibility(8);
                    this.I.setVisibility(0);
                    ((RelativeLayout.LayoutParams) this.T.getLayoutParams()).addRule(1, R.id.ala_live_lottie_bg);
                    ((RelativeLayout.LayoutParams) this.T.getLayoutParams()).addRule(6, R.id.ala_live_lottie_bg);
                    if (((b.a.r0.b0.f0.j) this.o).f16235e.m1().audience_count > 0) {
                        this.J.setVisibility(0);
                        this.H.setVisibility(0);
                        this.H.setText(String.format(this.m.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(((b.a.r0.b0.f0.j) this.o).f16235e.m1().audience_count)));
                    } else {
                        this.J.setVisibility(8);
                        this.H.setVisibility(8);
                    }
                } else {
                    this.K.setVisibility(0);
                    this.I.setVisibility(8);
                    ((RelativeLayout.LayoutParams) this.T.getLayoutParams()).addRule(1, R.id.ala_live_lottie_bg_new);
                    ((RelativeLayout.LayoutParams) this.T.getLayoutParams()).addRule(6, R.id.ala_live_lottie_bg_new);
                    if (((b.a.r0.b0.f0.j) this.o).f16235e.m1().audience_count > 0) {
                        this.O.setVisibility(0);
                        this.O.setText(String.format(this.m.getResources().getString(R.string.ala_audience_count_prefix_new), StringHelper.numFormatOverWan(((b.a.r0.b0.f0.j) this.o).f16235e.m1().audience_count)));
                    } else {
                        this.O.setVisibility(8);
                    }
                }
                this.T.setVisibility(8);
                this.F.setVisibility(8);
                if (((b.a.r0.b0.f0.j) this.o).f16235e.m1().openRecomReason == 1) {
                    String str = ((b.a.r0.b0.f0.j) this.o).f16235e.m1().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.F.setVisibility(0);
                        this.F.setText(str);
                    } else {
                        String w0 = ((b.a.r0.b0.f0.j) this.o).f16235e.w0();
                        String C0 = ((b.a.r0.b0.f0.j) this.o).f16235e.C0();
                        if (UtilHelper.isDecimal(w0) && UtilHelper.isDecimal(C0) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo c2 = b.a.r0.a3.j0.a.e().c();
                            String str2 = c2.latitude;
                            String str3 = c2.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && b.a.e.f.p.l.a(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(w0), Double.parseDouble(C0)) <= 50.0d) {
                                this.F.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                                this.F.setVisibility(0);
                            }
                        }
                    }
                }
                if (((b.a.r0.b0.f0.j) this.o).f16235e.m1() != null && !StringUtils.isNull(((b.a.r0.b0.f0.j) this.o).f16235e.m1().forumUserLiveMsg)) {
                    this.P.setVisibility(0);
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(((b.a.r0.b0.f0.j) this.o).f16235e.m1().forumUserLiveMsg, 10, "...");
                    this.Q.setText(cutChineseAndEnglishWithSuffix + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_forum_live_suffix));
                } else {
                    this.P.setVisibility(8);
                }
                x(true);
                B(this.z);
                k(this.m, TbadkCoreApplication.getInst().getSkinType());
                if (m.k(((b.a.r0.b0.f0.j) this.o).f16235e.f0())) {
                    SkinManager.setViewTextColor(this.C, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.C, R.color.CAM_X0105, 1);
                }
                T();
                if (!W() && !X()) {
                    this.G.playAnimation();
                } else {
                    this.L.playAnimation();
                }
                this.S.bindData(((b.a.r0.b0.f0.j) this.o).f16235e);
                this.S.setStaticsLocationPage("1");
                return;
            }
            this.z.setVisibility(8);
        }
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? R.layout.card_home_page_ala_live_item_new : invokeV.intValue;
    }

    public void e0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, bdUniqueId) == null) || bdUniqueId == null || this.p == null || this.a0 == null) {
            return;
        }
        m(bdUniqueId);
        v(bdUniqueId);
        CardUserInfoLayout cardUserInfoLayout = this.B;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        this.a0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.a0);
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.X = z;
        }
    }

    public void g0(int i2) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (threadCommentAndPraiseInfoLayout = this.p) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.statFloor = String.valueOf(i2);
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048595, this, tbPageContext, i2) == null) || this.f16223e == i2) {
            return;
        }
        u(tbPageContext, i2);
        b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.A);
        d2.n(R.string.J_X06);
        d2.i(R.color.CAM_X0205, R.color.CAM_X0206);
        float g2 = b.a.e.f.p.l.g(getContext(), R.dimen.tbds31);
        float[] fArr = {g2, g2, g2, g2, g2, g2, g2, g2};
        SkinManager.setViewTextColor(this.C, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.F, R.color.CAM_X0101);
        TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(b.a.e.f.p.l.g(getContext(), R.dimen.tbds31)).defaultStrokeColor(R.color.CAM_X0304).strokeWidth(b0).into(this.P);
        SkinManager.setViewTextColor(this.Q, R.color.CAM_X0304);
        WebPManager.setPureDrawable(this.R, R.drawable.icon_ala_watching, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.B.onChangeSkinType(h(), TbadkCoreApplication.getInst().getSkinType());
        this.S.onChangeSkin(i2);
        this.E.setPlaceHolder(3);
        TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0310).into(this.M);
        b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(this.K);
        d3.n(R.string.J_X01);
        d3.f(R.color.CAM_X0605);
        b.a.q0.s.u.c d4 = b.a.q0.s.u.c.d(this.N);
        d4.v(R.color.CAM_X0101);
        d4.z(R.dimen.T_X09);
        b.a.q0.s.u.c d5 = b.a.q0.s.u.c.d(this.O);
        d5.z(R.dimen.T_X09);
        d5.v(R.color.CAM_X0101);
        SkinManager.setBackgroundEndColorToAutoColor(this.I, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, fArr);
        SkinManager.setBackgroundColor(this.J, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.H, R.color.CAM_X0101);
        b.a.q0.s.u.c d6 = b.a.q0.s.u.c.d(this.T);
        d6.n(R.string.J_X01);
        d6.f(R.color.CAM_X0605);
        this.U.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_ala_live_rank_top, WebPManager.ResourceStateType.NORMAL_DISABLE));
        b.a.q0.s.u.c.d(this.V).v(R.color.CAM_X0314);
        b.a.q0.s.u.c.d(this.W).v(R.color.CAM_X0101);
        this.f16223e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view) == null) {
            if (view == this.A || view == this.p.getCommentContainer() || view == this.q.getCommentContainer() || view == this.P) {
                if (((b.a.r0.b0.f0.j) this.o).getThreadData().m1() != null && ((b.a.r0.b0.f0.j) this.o).getThreadData().m1().isChushou) {
                    Z(((b.a.r0.b0.f0.j) this.o).getThreadData().m1().thirdRoomId, ((b.a.r0.b0.f0.j) this.o).getThreadData().m1().thirdLiveType);
                } else {
                    a0(view);
                }
            }
        }
    }

    @Override // b.a.r0.p.e
    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
        }
    }
}
