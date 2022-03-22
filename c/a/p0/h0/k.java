package c.a.p0.h0;

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
import c.a.o0.c1.t0;
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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
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
/* loaded from: classes2.dex */
public class k extends c.a.p0.h0.a<c.a.p0.h0.e0.j> implements c.a.p0.v.e {
    public static /* synthetic */ Interceptable $ic;
    public static final int Y;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView A;
    public TextView B;
    public TBLottieAnimationView C;
    public TextView D;
    public LinearLayout E;
    public View F;
    public FrameLayout G;
    public TBLottieAnimationView H;
    public View I;
    public TextView J;
    public TextView K;
    public LinearLayout L;
    public TextView M;
    public ImageView N;
    public TbLiveContainer O;
    public ViewGroup P;
    public ImageView Q;
    public TextView R;
    public TextView S;
    public TbImageView T;
    public boolean U;
    public int V;
    public View.OnClickListener W;
    public CustomMessageListener X;
    public FrameLayout v;
    public LinearLayout w;
    public CardUserInfoLayout x;
    public TextView y;
    public RelativeLayout z;

    /* loaded from: classes2.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.H.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.a.H.cancelAnimation();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.C.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.a.C.cancelAnimation();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        public c(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
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

    /* loaded from: classes2.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(k kVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || (t = this.a.k) == 0 || ((c.a.p0.h0.e0.j) t).a == null || ((c.a.p0.h0.e0.j) t).a.getTid() == null || this.a.y == null || !((String) customResponsedMessage.getData()).equals(((c.a.p0.h0.e0.j) this.a.k).a.getTid())) {
                return;
            }
            k kVar = this.a;
            m.l(kVar.y, ((c.a.p0.h0.e0.j) kVar.k).a.getId(), R.color.CAM_X0109, R.color.CAM_X0109);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1699966930, "Lc/a/p0/h0/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1699966930, "Lc/a/p0/h0/k;");
                return;
            }
        }
        Y = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds2);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.U = false;
        this.V = 0;
        this.W = new c(this);
        this.X = new d(this, 2001390);
        this.i = tbPageContext;
        this.j = bdUniqueId;
        Q(k());
    }

    public View L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            CardUserInfoLayout cardUserInfoLayout = this.x;
            if (cardUserInfoLayout != null) {
                return cardUserInfoLayout.getAvatar();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public TbLiveContainer M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.O : (TbLiveContainer) invokeV.objValue;
    }

    public View N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.U) {
                CardUserInfoLayout cardUserInfoLayout = this.x;
                if (cardUserInfoLayout != null) {
                    return cardUserInfoLayout.getUserName();
                }
                return null;
            }
            return this.y;
        }
        return (View) invokeV.objValue;
    }

    public void O() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (c.a.o0.r.l.c().g() && (t = this.k) != 0 && ((c.a.p0.h0.e0.j) t).getThreadData() != null && ((c.a.p0.h0.e0.j) this.k).getThreadData().getThreadAlaInfo() != null) {
                this.A.setPlaceHolder(3);
                this.A.J(((c.a.p0.h0.e0.j) this.k).getThreadData().getThreadAlaInfo().cover, 10, false);
                this.z.setVisibility(0);
                return;
            }
            this.z.setVisibility(8);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            T t = this.k;
            if (t != 0 && ((c.a.p0.h0.e0.j) t).getThreadData() != null && ((c.a.p0.h0.e0.j) this.k).getThreadData().getThreadAlaInfo() != null && ((c.a.p0.h0.e0.j) this.k).getThreadData().getThreadAlaInfo().mYyExtData != null) {
                String str = ((c.a.p0.h0.e0.j) this.k).getThreadData().getThreadAlaInfo().mYyExtData.mRankShow;
                if (TextUtils.isEmpty(str)) {
                    this.P.setVisibility(8);
                    return;
                } else if (!R()) {
                    this.P.setVisibility(8);
                    return;
                } else if (!UbsABTestHelper.isHotRankShowABTest()) {
                    this.P.setVisibility(8);
                    return;
                } else {
                    try {
                        String substring = str.substring(0, 3);
                        String substring2 = str.substring(3);
                        this.R.setText(substring);
                        this.S.setText(substring2);
                        this.P.setVisibility(0);
                        return;
                    } catch (Exception e2) {
                        this.P.setVisibility(8);
                        e2.printStackTrace();
                        return;
                    }
                }
            }
            this.P.setVisibility(8);
        }
    }

    public final void Q(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.v = (FrameLayout) view.findViewById(R.id.obfuscated_res_0x7f0911f5);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0906e2);
            this.w = linearLayout;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
            layoutParams.bottomMargin = 0;
            CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) view.findViewById(R.id.obfuscated_res_0x7f09052e);
            this.x = cardUserInfoLayout;
            cardUserInfoLayout.setPageContext(this.i);
            this.x.setPageUniqueId(this.j);
            this.y = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091f51);
            this.z = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f090aaf);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090e86);
            this.A = tbImageView;
            tbImageView.setDrawCorner(true);
            this.A.setPlaceHolder(3);
            this.A.setDefaultResource(0);
            this.A.setRadiusById(R.string.J_X05);
            this.A.setConrers(15);
            this.A.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.A.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.A.setBorderSurroundContent(true);
            this.A.setDrawBorder(true);
            this.G = (FrameLayout) view.findViewById(R.id.obfuscated_res_0x7f0901ea);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view.findViewById(R.id.obfuscated_res_0x7f0901eb);
            this.H = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            SkinManager.setLottieAnimation(this.H, R.raw.obfuscated_res_0x7f11001d);
            this.H.addOnAttachStateChangeListener(new a(this));
            this.I = view.findViewById(R.id.obfuscated_res_0x7f0901ec);
            this.J = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0901f4);
            this.K = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091858);
            this.E = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0901e9);
            TBLottieAnimationView tBLottieAnimationView2 = (TBLottieAnimationView) view.findViewById(R.id.obfuscated_res_0x7f0901e8);
            this.C = tBLottieAnimationView2;
            tBLottieAnimationView2.loop(true);
            SkinManager.setLottieAnimation(this.C, R.raw.ala_live2);
            this.C.addOnAttachStateChangeListener(new b(this));
            this.P = (ViewGroup) view.findViewById(R.id.obfuscated_res_0x7f0901ef);
            this.Q = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0901ee);
            this.R = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0901f1);
            this.S = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0901f0);
            this.T = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f0912b6);
            this.D = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091856);
            this.F = view.findViewById(R.id.obfuscated_res_0x7f091857);
            this.B = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0901f2);
            this.q = (ForumEnterLayout) view.findViewById(R.id.obfuscated_res_0x7f0904fb);
            this.l = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.obfuscated_res_0x7f0904ca);
            this.m = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.obfuscated_res_0x7f0904cb);
            t(this.l);
            t(this.m);
            this.w.setOnClickListener(this);
            this.L = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090a40);
            this.M = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921b9);
            this.N = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090e71);
            this.O = (TbLiveContainer) view.findViewById(R.id.obfuscated_res_0x7f091f01);
            this.L.setOnClickListener(this);
            this.u = view.findViewById(R.id.obfuscated_res_0x7f0904c9);
            HomeGroupUbsUIHelper.handleImgMask(view.findViewById(R.id.obfuscated_res_0x7f090e6a), R.color.transparent);
        }
    }

    public final boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            T t = this.k;
            if (t == 0 || ((c.a.p0.h0.e0.j) t).getThreadData() == null) {
                return false;
            }
            return ((c.a.p0.h0.e0.j) this.k).getThreadData().isFromHomPage;
        }
        return invokeV.booleanValue;
    }

    public final void S(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.f15304b;
            urlManager.dealOneLink(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void T(View view) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            if (h() != null) {
                h().a(view, this.k);
            }
            T t = this.k;
            if (t == 0 || ((c.a.p0.h0.e0.j) t).getThreadData() == null || ((c.a.p0.h0.e0.j) this.k).getThreadData().getThreadAlaInfo() == null) {
                return;
            }
            AlaInfoData threadAlaInfo = ((c.a.p0.h0.e0.j) this.k).getThreadData().getThreadAlaInfo();
            m.a(((c.a.p0.h0.e0.j) this.k).a.getId());
            m.l(this.y, ((c.a.p0.h0.e0.j) this.k).a.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            if (threadAlaInfo.isLegalYYLiveData()) {
                if (((c.a.p0.h0.e0.j) this.k).getThreadData().isFromHomPage) {
                    str = t0.d(this.O.getContext()) ? YYLiveUtil.SOURCE_HOME_RECOMMEND_AUTO_PLAY : YYLiveUtil.SOURCE_HOME_RECOMMEND_PLAY;
                } else {
                    str = ((c.a.p0.h0.e0.j) this.k).getThreadData().isFromConcern ? YYLiveUtil.SOURCE_HOME_FOLLOW_TAB_CARD : YYLiveUtil.SOURCE_NOT_DEFINE;
                }
                String str2 = str;
                TbPageContext<?> tbPageContext = this.i;
                YyExtData yyExtData = threadAlaInfo.mYyExtData;
                String str3 = yyExtData.mSid;
                String str4 = yyExtData.mSsid;
                String str5 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str3, str4, str5, "" + threadAlaInfo.roomId, threadAlaInfo.mYyExtData.streamInfo, str2);
                V(((c.a.p0.h0.e0.j) this.k).getThreadData().getTid(), String.valueOf(((c.a.p0.h0.e0.j) this.k).getThreadData().getFid()), String.valueOf(threadAlaInfo.roomId), String.valueOf(threadAlaInfo.live_id), threadAlaInfo.mYyExtData.mSid);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: U */
    public void l(c.a.p0.h0.e0.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jVar) == null) {
            this.k = jVar;
            if (R()) {
                y(true);
            }
            W();
        }
    }

    public final void V(String str, String str2, String str3, String str4, String str5) {
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

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            T t = this.k;
            if (t != 0 && ((c.a.p0.h0.e0.j) t).getThreadData() != null) {
                this.v.setVisibility(0);
                int k = c.a.d.f.p.n.k(this.i.getPageActivity());
                if (k != this.V) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z.getLayoutParams();
                    int dimenPixelSize = k - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    layoutParams.width = dimenPixelSize;
                    layoutParams.height = (dimenPixelSize * 9) / 16;
                    this.z.setLayoutParams(layoutParams);
                    this.V = k;
                }
                if (((c.a.p0.h0.e0.j) this.k).getThreadData().getThreadAlaInfo() != null && ((c.a.p0.h0.e0.j) this.k).getThreadData().getThreadAlaInfo().isChushou) {
                    this.l.setShowFlag(10);
                    this.l.hideShareContainer();
                } else {
                    this.l.setShowFlag(11);
                    this.l.resetShareContainer();
                }
                this.x.setVisibility(0);
                this.x.setData(((c.a.p0.h0.e0.j) this.k).getThreadData());
                this.x.setUserAfterClickListener(this.W);
                ((c.a.p0.h0.e0.j) this.k).getThreadData().parser_title();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(((c.a.p0.h0.e0.j) this.k).getThreadData().getSpan_str());
                if (TextUtils.isEmpty(spannableStringBuilder)) {
                    this.y.setVisibility(8);
                } else {
                    this.y.setText(spannableStringBuilder);
                    this.y.setVisibility(0);
                    ThreadCardUtils.setTitleStyleAb(this.y, ((c.a.p0.h0.e0.j) this.k).getThreadData());
                }
                if (R()) {
                    this.G.setVisibility(0);
                    this.E.setVisibility(8);
                    ((RelativeLayout.LayoutParams) this.P.getLayoutParams()).addRule(1, R.id.obfuscated_res_0x7f0901ea);
                    ((RelativeLayout.LayoutParams) this.P.getLayoutParams()).addRule(6, R.id.obfuscated_res_0x7f0901ea);
                    if (((c.a.p0.h0.e0.j) this.k).a.getThreadAlaInfo().audience_count > 0) {
                        this.K.setVisibility(0);
                        this.K.setText(String.format(this.i.getResources().getString(R.string.obfuscated_res_0x7f0f01f8), StringHelper.numFormatOverWan(((c.a.p0.h0.e0.j) this.k).a.getThreadAlaInfo().audience_count)));
                    } else {
                        this.K.setVisibility(8);
                    }
                } else {
                    this.G.setVisibility(8);
                    this.E.setVisibility(0);
                    ((RelativeLayout.LayoutParams) this.P.getLayoutParams()).addRule(1, R.id.obfuscated_res_0x7f0901e9);
                    ((RelativeLayout.LayoutParams) this.P.getLayoutParams()).addRule(6, R.id.obfuscated_res_0x7f0901e9);
                    if (((c.a.p0.h0.e0.j) this.k).a.getThreadAlaInfo().audience_count > 0) {
                        this.F.setVisibility(0);
                        this.D.setVisibility(0);
                        this.D.setText(String.format(this.i.getResources().getString(R.string.obfuscated_res_0x7f0f01f7), StringHelper.numFormatOverWan(((c.a.p0.h0.e0.j) this.k).a.getThreadAlaInfo().audience_count)));
                    } else {
                        this.F.setVisibility(8);
                        this.D.setVisibility(8);
                    }
                }
                this.P.setVisibility(8);
                this.B.setVisibility(8);
                if (((c.a.p0.h0.e0.j) this.k).a.getThreadAlaInfo().openRecomReason == 1) {
                    String str = ((c.a.p0.h0.e0.j) this.k).a.getThreadAlaInfo().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.B.setVisibility(0);
                        this.B.setText(str);
                    } else {
                        String latitude = ((c.a.p0.h0.e0.j) this.k).a.getLatitude();
                        String longtitude = ((c.a.p0.h0.e0.j) this.k).a.getLongtitude();
                        if (UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(longtitude) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo c2 = c.a.p0.l3.k0.a.e().c();
                            String str2 = c2.latitude;
                            String str3 = c2.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && c.a.d.f.p.n.g(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(latitude), Double.parseDouble(longtitude)) <= 50.0d) {
                                this.B.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f023d));
                                this.B.setVisibility(0);
                            }
                        }
                    }
                }
                if (((c.a.p0.h0.e0.j) this.k).a.getThreadAlaInfo() != null && !StringUtils.isNull(((c.a.p0.h0.e0.j) this.k).a.getThreadAlaInfo().forumUserLiveMsg)) {
                    this.L.setVisibility(0);
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(((c.a.p0.h0.e0.j) this.k).a.getThreadAlaInfo().forumUserLiveMsg, 10, StringHelper.STRING_MORE);
                    this.M.setText(cutChineseAndEnglishWithSuffix + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0214));
                } else {
                    this.L.setVisibility(8);
                }
                z(true);
                D(this.v);
                m(this.i, TbadkCoreApplication.getInst().getSkinType());
                if (m.k(((c.a.p0.h0.e0.j) this.k).a.getId())) {
                    SkinManager.setViewTextColor(this.y, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.y, R.color.CAM_X0105, 1);
                }
                O();
                if (R()) {
                    this.H.playAnimation();
                } else {
                    this.C.playAnimation();
                }
                this.O.b(((c.a.p0.h0.e0.j) this.k).a);
                this.O.setStaticsLocationPage("1");
                Z();
                return;
            }
            this.v.setVisibility(8);
        }
    }

    public void X(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bdUniqueId) == null) || bdUniqueId == null || this.l == null || this.X == null) {
            return;
        }
        o(bdUniqueId);
        x(bdUniqueId);
        CardUserInfoLayout cardUserInfoLayout = this.x;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        this.X.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.X);
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.U = z;
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            T t = this.k;
            if (t != 0 && ((c.a.p0.h0.e0.j) t).getThreadData() != null && ((c.a.p0.h0.e0.j) this.k).getThreadData().getThreadAlaInfo() != null && ((c.a.p0.h0.e0.j) this.k).getThreadData().getThreadAlaInfo().mYyExtData != null) {
                if (!R()) {
                    this.T.setVisibility(8);
                    return;
                } else if (!UbsABTestHelper.isLiveCardGameShow()) {
                    this.T.setVisibility(8);
                    return;
                } else {
                    String str = ((c.a.p0.h0.e0.j) this.k).getThreadData().getThreadAlaInfo().mYyExtData.mIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        this.T.setVisibility(8);
                        return;
                    }
                    this.T.setVisibility(0);
                    this.T.setPlaceHolder(0);
                    this.T.J(str, 10, false);
                    return;
                }
            }
            this.T.setVisibility(8);
        }
    }

    public void a0(int i) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || (threadCommentAndPraiseInfoLayout = this.l) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.O = String.valueOf(i);
    }

    @Override // c.a.p0.v.e
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
        }
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? R.layout.obfuscated_res_0x7f0d0198 : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048595, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        w(tbPageContext, i);
        c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.w);
        d2.n(R.string.J_X06);
        d2.i(R.color.CAM_X0205, R.color.CAM_X0206);
        float f2 = c.a.d.f.p.n.f(getContext(), R.dimen.tbds31);
        float[] fArr = {f2, f2, f2, f2, f2, f2, f2, f2};
        SkinManager.setViewTextColor(this.y, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0101);
        TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(c.a.d.f.p.n.f(getContext(), R.dimen.tbds31)).defaultStrokeColor(R.color.CAM_X0304).strokeWidth(Y).into(this.L);
        SkinManager.setViewTextColor(this.M, (int) R.color.CAM_X0304);
        WebPManager.setPureDrawable(this.N, R.drawable.obfuscated_res_0x7f080671, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.x.onChangeSkinType(j(), TbadkCoreApplication.getInst().getSkinType());
        this.O.d(i);
        this.A.setPlaceHolder(3);
        TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0310).into(this.I);
        c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.G);
        d3.n(R.string.J_X01);
        d3.f(R.color.CAM_X0605);
        c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(this.J);
        d4.v(R.color.CAM_X0101);
        d4.z(R.dimen.T_X09);
        c.a.o0.r.v.c d5 = c.a.o0.r.v.c.d(this.K);
        d5.z(R.dimen.T_X09);
        d5.v(R.color.CAM_X0101);
        SkinManager.setBackgroundEndColorToAutoColor(this.E, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, fArr);
        SkinManager.setBackgroundColor(this.F, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.D, (int) R.color.CAM_X0101);
        c.a.o0.r.v.c d6 = c.a.o0.r.v.c.d(this.P);
        d6.n(R.string.J_X01);
        d6.f(R.color.CAM_X0605);
        this.Q.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0807bf, WebPManager.ResourceStateType.NORMAL_DISABLE));
        c.a.o0.r.v.c.d(this.R).v(R.color.CAM_X0314);
        c.a.o0.r.v.c.d(this.S).v(R.color.CAM_X0101);
        this.a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view) == null) {
            if (view == this.w || view == this.l.getCommentContainer() || view == this.m.getCommentContainer() || view == this.L) {
                if (((c.a.p0.h0.e0.j) this.k).getThreadData().getThreadAlaInfo() != null && ((c.a.p0.h0.e0.j) this.k).getThreadData().getThreadAlaInfo().isChushou) {
                    S(((c.a.p0.h0.e0.j) this.k).getThreadData().getThreadAlaInfo().thirdRoomId, ((c.a.p0.h0.e0.j) this.k).getThreadData().getThreadAlaInfo().thirdLiveType);
                } else {
                    T(view);
                }
            }
        }
    }
}
