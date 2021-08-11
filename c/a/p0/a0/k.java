package c.a.p0.a0;

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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.card.view.ForumEnterLayout;
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
public class k extends c.a.p0.a0.a<c.a.p0.a0.d0.j> implements c.a.p0.o.e {
    public static /* synthetic */ Interceptable $ic;
    public static final int O;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout A;
    public TbImageView B;
    public TBLottieAnimationView C;
    public TextView D;
    public TextView E;
    public LinearLayout F;
    public View G;
    public LinearLayout H;
    public TextView I;
    public ImageView J;
    public boolean K;
    public int L;
    public View.OnClickListener M;
    public CustomMessageListener N;
    public FrameLayout w;
    public LinearLayout x;
    public CardUserInfoLayout y;
    public TextView z;

    /* loaded from: classes3.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f15010e;

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
            this.f15010e = kVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15010e.C.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f15010e.C.cancelAnimation();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f15011e;

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
            this.f15011e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15011e.g() == null) {
                return;
            }
            this.f15011e.g().a(view, this.f15011e.o);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f15012a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(k kVar, int i2) {
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
            this.f15012a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            T t;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || (t = this.f15012a.o) == 0 || ((c.a.p0.a0.d0.j) t).f14959e == null || ((c.a.p0.a0.d0.j) t).f14959e.q1() == null || this.f15012a.z == null || !((String) customResponsedMessage.getData()).equals(((c.a.p0.a0.d0.j) this.f15012a.o).f14959e.q1())) {
                return;
            }
            k kVar = this.f15012a;
            TextView textView = kVar.z;
            String f0 = ((c.a.p0.a0.d0.j) kVar.o).f14959e.f0();
            int i2 = R.color.CAM_X0109;
            m.l(textView, f0, i2, i2);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1706431577, "Lc/a/p0/a0/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1706431577, "Lc/a/p0/a0/k;");
                return;
            }
        }
        O = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
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
        this.K = false;
        this.L = 0;
        this.M = new b(this);
        this.N = new c(this, 2001390);
        this.m = tbPageContext;
        this.n = bdUniqueId;
        Q(j());
    }

    public View N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            CardUserInfoLayout cardUserInfoLayout = this.y;
            if (cardUserInfoLayout != null) {
                return cardUserInfoLayout.getAvatar();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public View O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.K) {
                CardUserInfoLayout cardUserInfoLayout = this.y;
                if (cardUserInfoLayout != null) {
                    return cardUserInfoLayout.getUserName();
                }
                return null;
            }
            return this.z;
        }
        return (View) invokeV.objValue;
    }

    public void P() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (c.a.o0.s.k.c().g() && (t = this.o) != 0 && ((c.a.p0.a0.d0.j) t).getThreadData() != null && ((c.a.p0.a0.d0.j) this.o).getThreadData().j1() != null) {
                this.B.setPlaceHolder(3);
                this.B.startLoad(((c.a.p0.a0.d0.j) this.o).getThreadData().j1().cover, 10, false);
                this.A.setVisibility(0);
                return;
            }
            this.A.setVisibility(8);
        }
    }

    public final void Q(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.w = (FrameLayout) view.findViewById(R.id.layout_root);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content_layout);
            this.x = linearLayout;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
            layoutParams.bottomMargin = 0;
            CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
            this.y = cardUserInfoLayout;
            cardUserInfoLayout.setPageContext(this.m);
            this.y.setPageUniqueId(this.n);
            this.z = (TextView) view.findViewById(R.id.text_title);
            this.A = (RelativeLayout) view.findViewById(R.id.frame_video);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image_video);
            this.B = tbImageView;
            tbImageView.setDrawCorner(true);
            this.B.setPlaceHolder(3);
            this.B.setDefaultResource(0);
            this.B.setRadiusById(R.string.J_X05);
            this.B.setConrers(15);
            this.B.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.B.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.B.setBorderSurroundContent(true);
            this.B.setDrawBorder(true);
            this.F = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
            this.C = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            SkinManager.setLottieAnimation(this.C, R.raw.ala_live2);
            this.C.addOnAttachStateChangeListener(new a(this));
            this.D = (TextView) view.findViewById(R.id.play_count);
            this.E = (TextView) view.findViewById(R.id.ala_live_recom_reason);
            this.G = view.findViewById(R.id.play_count_line);
            this.u = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
            this.p = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
            this.q = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
            s(this.p);
            s(this.q);
            this.x.setOnClickListener(this);
            this.H = (LinearLayout) view.findViewById(R.id.forum_friends_now_looking);
            this.I = (TextView) view.findViewById(R.id.tv_forum_friends_now_looking);
            this.J = (ImageView) view.findViewById(R.id.image_forum_friends_now_looking);
            this.H.setOnClickListener(this);
            c.a.o0.b.g.b.h(view.findViewById(R.id.imageMask), R.color.transparent);
        }
    }

    public final void R(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.f14946f;
            urlManager.dealOneLink(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void S(View view) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (g() != null) {
                g().a(view, this.o);
            }
            T t = this.o;
            if (t == 0 || ((c.a.p0.a0.d0.j) t).getThreadData() == null || ((c.a.p0.a0.d0.j) this.o).getThreadData().j1() == null) {
                return;
            }
            AlaInfoData j1 = ((c.a.p0.a0.d0.j) this.o).getThreadData().j1();
            m.a(((c.a.p0.a0.d0.j) this.o).f14959e.f0());
            m.l(this.z, ((c.a.p0.a0.d0.j) this.o).f14959e.f0(), R.color.CAM_X0105, R.color.CAM_X0109);
            if (j1.isLegalYYLiveData()) {
                if (((c.a.p0.a0.d0.j) this.o).getThreadData().X1) {
                    str = YYLiveUtil.SOURCE_HOME_RECOMMEND_PLAY;
                } else {
                    str = ((c.a.p0.a0.d0.j) this.o).getThreadData().Y1 ? YYLiveUtil.SOURCE_HOME_FOLLOW_TAB_CARD : YYLiveUtil.SOURCE_NOT_DEFINE;
                }
                String str2 = str;
                TbPageContext<?> tbPageContext = this.m;
                YyExtData yyExtData = j1.mYyExtData;
                String str3 = yyExtData.mSid;
                String str4 = yyExtData.mSsid;
                String str5 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str3, str4, str5, "" + j1.roomId, str2);
                U(((c.a.p0.a0.d0.j) this.o).getThreadData().q1(), String.valueOf(((c.a.p0.a0.d0.j) this.o).getThreadData().T()), String.valueOf(j1.roomId), String.valueOf(j1.live_id), j1.mYyExtData.mSid);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a0.b
    /* renamed from: T */
    public void k(c.a.p0.a0.d0.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jVar) == null) {
            this.o = jVar;
            V();
        }
    }

    public final void U(String str, String str2, String str3, String str4, String str5) {
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

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            T t = this.o;
            if (t != 0 && ((c.a.p0.a0.d0.j) t).getThreadData() != null) {
                this.w.setVisibility(0);
                int k = c.a.e.e.p.l.k(this.m.getPageActivity());
                if (k != this.L) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.A.getLayoutParams();
                    int dimenPixelSize = k - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    layoutParams.width = dimenPixelSize;
                    layoutParams.height = (dimenPixelSize * 9) / 16;
                    this.A.setLayoutParams(layoutParams);
                    this.L = k;
                }
                if (((c.a.p0.a0.d0.j) this.o).getThreadData().j1() != null && ((c.a.p0.a0.d0.j) this.o).getThreadData().j1().isChushou) {
                    this.p.setShowFlag(10);
                    this.p.hideShareContainer();
                } else {
                    this.p.setShowFlag(11);
                    this.p.resetShareContainer();
                }
                this.y.setVisibility(0);
                this.y.setData(((c.a.p0.a0.d0.j) this.o).getThreadData());
                this.y.setUserAfterClickListener(this.M);
                ((c.a.p0.a0.d0.j) this.o).getThreadData().W2();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(((c.a.p0.a0.d0.j) this.o).getThreadData().e1());
                if (TextUtils.isEmpty(spannableStringBuilder)) {
                    this.z.setVisibility(8);
                } else {
                    this.z.setText(spannableStringBuilder);
                    this.z.setVisibility(0);
                    ThreadCardUtils.setTitleStyleAb(this.z);
                }
                if (((c.a.p0.a0.d0.j) this.o).f14959e.j1().audience_count > 0) {
                    this.G.setVisibility(0);
                    this.D.setVisibility(0);
                    this.D.setText(String.format(this.m.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(((c.a.p0.a0.d0.j) this.o).f14959e.j1().audience_count)));
                } else {
                    this.G.setVisibility(8);
                    this.D.setVisibility(8);
                }
                this.E.setVisibility(8);
                if (((c.a.p0.a0.d0.j) this.o).f14959e.j1().openRecomReason == 1) {
                    String str = ((c.a.p0.a0.d0.j) this.o).f14959e.j1().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.E.setVisibility(0);
                        this.E.setText(str);
                    } else {
                        String u0 = ((c.a.p0.a0.d0.j) this.o).f14959e.u0();
                        String A0 = ((c.a.p0.a0.d0.j) this.o).f14959e.A0();
                        if (UtilHelper.isDecimal(u0) && UtilHelper.isDecimal(A0) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo c2 = c.a.p0.x2.j0.a.e().c();
                            String str2 = c2.latitude;
                            String str3 = c2.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && c.a.e.e.p.l.a(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(u0), Double.parseDouble(A0)) <= 50.0d) {
                                this.E.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                                this.E.setVisibility(0);
                            }
                        }
                    }
                }
                if (((c.a.p0.a0.d0.j) this.o).f14959e.j1() != null && !StringUtils.isNull(((c.a.p0.a0.d0.j) this.o).f14959e.j1().forumUserLiveMsg)) {
                    this.H.setVisibility(0);
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(((c.a.p0.a0.d0.j) this.o).f14959e.j1().forumUserLiveMsg, 10, "...");
                    this.I.setText(cutChineseAndEnglishWithSuffix + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_forum_live_suffix));
                } else {
                    this.H.setVisibility(8);
                }
                z(this.w);
                l(this.m, TbadkCoreApplication.getInst().getSkinType());
                if (m.k(((c.a.p0.a0.d0.j) this.o).f14959e.f0())) {
                    SkinManager.setViewTextColor(this.z, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.z, R.color.CAM_X0105, 1);
                }
                P();
                this.C.playAnimation();
                return;
            }
            this.w.setVisibility(8);
        }
    }

    public void W(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) || bdUniqueId == null || this.p == null || this.N == null) {
            return;
        }
        n(bdUniqueId);
        v(bdUniqueId);
        CardUserInfoLayout cardUserInfoLayout = this.y;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        this.N.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.N);
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.K = z;
        }
    }

    public void Y(int i2) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (threadCommentAndPraiseInfoLayout = this.p) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.statFloor = String.valueOf(i2);
    }

    @Override // c.a.p0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? R.layout.card_home_page_ala_live_item_new : invokeV.intValue;
    }

    @Override // c.a.p0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048590, this, tbPageContext, i2) == null) || this.f14945e == i2) {
            return;
        }
        u(tbPageContext, i2);
        c.a.o0.s.u.c d2 = c.a.o0.s.u.c.d(this.x);
        d2.n(R.string.J_X06);
        d2.i(R.color.CAM_X0205, R.color.CAM_X0206);
        c.a.o0.s.u.c d3 = c.a.o0.s.u.c.d(this.A);
        d3.l(R.dimen.L_X01);
        d3.k(R.color.CAM_X0401);
        d3.n(R.string.J_X05);
        d3.f(R.color.CAM_X0611);
        float g2 = c.a.e.e.p.l.g(d(), R.dimen.tbds31);
        SkinManager.setBackgroundEndColorToAutoColor(this.F, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{g2, g2, g2, g2, g2, g2, g2, g2});
        SkinManager.setBackgroundColor(this.G, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.z, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.D, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.E, R.color.CAM_X0101);
        TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(c.a.e.e.p.l.g(d(), R.dimen.tbds31)).defaultStrokeColor(R.color.CAM_X0304).strokeWidth(O).into(this.H);
        SkinManager.setViewTextColor(this.I, R.color.CAM_X0304);
        WebPManager.setPureDrawable(this.J, R.drawable.icon_ala_watching, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.y.onChangeSkinType(i(), TbadkCoreApplication.getInst().getSkinType());
        this.B.setPlaceHolder(3);
        this.f14945e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            if (view == this.x || view == this.p.getCommentContainer() || view == this.q.getCommentContainer() || view == this.H) {
                if (((c.a.p0.a0.d0.j) this.o).getThreadData().j1() != null && ((c.a.p0.a0.d0.j) this.o).getThreadData().j1().isChushou) {
                    R(((c.a.p0.a0.d0.j) this.o).getThreadData().j1().thirdRoomId, ((c.a.p0.a0.d0.j) this.o).getThreadData().j1().thirdLiveType);
                } else {
                    S(view);
                }
            }
        }
    }

    @Override // c.a.p0.o.e
    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
        }
    }
}
