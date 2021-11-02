package b.a.r0.b0;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.AppPosInfo;
/* loaded from: classes4.dex */
public class j extends b.a.r0.b0.a<b.a.r0.b0.e0.j> implements b.a.r0.p.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public CardUserInfoLayout B;
    public TextView C;
    public RelativeLayout D;
    public TbImageView E;
    public TBLottieAnimationView F;
    public TextView G;
    public TextView H;
    public LinearLayout I;
    public View J;
    public boolean K;
    public int L;
    public View.OnClickListener M;
    public CustomMessageListener N;
    public FrameLayout z;

    /* loaded from: classes4.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f14793e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14793e = jVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14793e.F.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f14793e.F.cancelAnimation();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f14794e;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14794e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14794e.f() == null) {
                return;
            }
            this.f14794e.f().a(view, this.f14794e.o);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f14795a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(j jVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
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
            this.f14795a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            T t;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || (t = this.f14795a.o) == 0 || ((b.a.r0.b0.e0.j) t).f14748e == null || ((b.a.r0.b0.e0.j) t).f14748e.s1() == null || this.f14795a.C == null || !((String) customResponsedMessage.getData()).equals(((b.a.r0.b0.e0.j) this.f14795a.o).f14748e.s1())) {
                return;
            }
            j jVar = this.f14795a;
            TextView textView = jVar.C;
            String f0 = ((b.a.r0.b0.e0.j) jVar.o).f14748e.f0();
            int i2 = R.color.CAM_X0109;
            m.l(textView, f0, i2, i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.K = false;
        this.L = 0;
        this.M = new b(this);
        this.N = new c(this, 2001390);
        this.m = tbPageContext;
        this.n = bdUniqueId;
        S(i());
    }

    public View P() {
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

    public View Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.K) {
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

    public void R() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (b.a.q0.s.k.c().g() && (t = this.o) != 0 && ((b.a.r0.b0.e0.j) t).getThreadData() != null && ((b.a.r0.b0.e0.j) this.o).getThreadData().l1() != null) {
                this.E.setPlaceHolder(3);
                this.E.startLoad(((b.a.r0.b0.e0.j) this.o).getThreadData().l1().cover, 10, false);
                this.D.setVisibility(0);
                return;
            }
            this.D.setVisibility(8);
        }
    }

    public final void S(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
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
            this.I = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
            this.F = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            SkinManager.setLottieAnimation(this.F, R.raw.ala_live2);
            this.F.addOnAttachStateChangeListener(new a(this));
            this.G = (TextView) view.findViewById(R.id.play_count);
            this.H = (TextView) view.findViewById(R.id.ala_live_recom_reason);
            this.J = view.findViewById(R.id.play_count_line);
            this.u = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
            this.p = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
            this.q = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
            q(this.p);
            q(this.q);
            this.A.setOnClickListener(this);
            b.a.q0.b.g.b.h(view.findViewById(R.id.imageMask), R.color.transparent);
        }
    }

    public final void T(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.f14737f;
            urlManager.dealOneLink(tbPageContext, new String[]{"bdtiebalive://video/live?room_id=" + j2 + "&live_id=" + j + "&enterroom_type=1&from" + str});
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: U */
    public void j(b.a.r0.b0.e0.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.o = jVar;
            V();
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            T t = this.o;
            if (t != 0 && ((b.a.r0.b0.e0.j) t).getThreadData() != null) {
                this.z.setVisibility(0);
                int k = b.a.e.e.p.l.k(this.m.getPageActivity());
                if (k != this.L) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.D.getLayoutParams();
                    int dimenPixelSize = k - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    layoutParams.width = dimenPixelSize;
                    layoutParams.height = (dimenPixelSize * 9) / 16;
                    this.D.setLayoutParams(layoutParams);
                    this.L = k;
                }
                this.p.setShowFlag(11);
                this.p.resetShareContainer();
                this.B.setVisibility(0);
                this.B.setData(((b.a.r0.b0.e0.j) this.o).getThreadData());
                this.B.setUserAfterClickListener(this.M);
                if (((b.a.r0.b0.e0.j) this.o).getThreadData().l1() != null) {
                    this.C.setText(((b.a.r0.b0.e0.j) this.o).getThreadData().l1().friendRoomName);
                }
                if (((b.a.r0.b0.e0.j) this.o).f14748e.l1().audience_count > 0) {
                    this.J.setVisibility(0);
                    this.G.setVisibility(0);
                    this.G.setText(String.format(this.m.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(((b.a.r0.b0.e0.j) this.o).f14748e.l1().audience_count)));
                } else {
                    this.J.setVisibility(8);
                    this.G.setVisibility(8);
                }
                this.H.setVisibility(8);
                if (((b.a.r0.b0.e0.j) this.o).f14748e.l1().openRecomReason == 1) {
                    String str = ((b.a.r0.b0.e0.j) this.o).f14748e.l1().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.H.setVisibility(0);
                        this.H.setText(str);
                    } else {
                        String w0 = ((b.a.r0.b0.e0.j) this.o).f14748e.w0();
                        String C0 = ((b.a.r0.b0.e0.j) this.o).f14748e.C0();
                        if (UtilHelper.isDecimal(w0) && UtilHelper.isDecimal(C0) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo c2 = b.a.r0.z2.j0.a.e().c();
                            String str2 = c2.latitude;
                            String str3 = c2.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && b.a.e.e.p.l.a(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(w0), Double.parseDouble(C0)) <= 50.0d) {
                                this.H.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                                this.H.setVisibility(0);
                            }
                        }
                    }
                }
                B(this.z);
                k(this.m, TbadkCoreApplication.getInst().getSkinType());
                if (m.k(((b.a.r0.b0.e0.j) this.o).f14748e.f0())) {
                    SkinManager.setViewTextColor(this.C, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.C, R.color.CAM_X0105, 1);
                }
                R();
                this.F.playAnimation();
                return;
            }
            this.z.setVisibility(8);
        }
    }

    public void W(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) || bdUniqueId == null || this.p == null || this.N == null) {
            return;
        }
        m(bdUniqueId);
        v(bdUniqueId);
        CardUserInfoLayout cardUserInfoLayout = this.B;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        this.N.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.N);
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.K = z;
        }
    }

    public void Y(int i2) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (threadCommentAndPraiseInfoLayout = this.p) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.statFloor = String.valueOf(i2);
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? R.layout.card_home_page_ala_live_item_new : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048588, this, tbPageContext, i2) == null) || this.f14736e == i2) {
            return;
        }
        u(tbPageContext, i2);
        b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.A);
        d2.n(R.string.J_X06);
        d2.i(R.color.CAM_X0205, R.color.CAM_X0206);
        b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(this.D);
        d3.l(R.dimen.L_X01);
        d3.k(R.color.CAM_X0401);
        d3.n(R.string.J_X05);
        d3.f(R.color.CAM_X0611);
        float g2 = b.a.e.e.p.l.g(getContext(), R.dimen.tbds31);
        SkinManager.setBackgroundEndColorToAutoColor(this.I, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{g2, g2, g2, g2, g2, g2, g2, g2});
        SkinManager.setBackgroundColor(this.J, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.C, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.G, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.H, R.color.CAM_X0101);
        this.B.onChangeSkinType(h(), TbadkCoreApplication.getInst().getSkinType());
        this.E.setPlaceHolder(3);
        this.f14736e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            if (view == this.A || view == this.p.getCommentContainer() || view == this.q.getCommentContainer()) {
                T(((b.a.r0.b0.e0.j) this.o).getThreadData().l1().live_id, ((b.a.r0.b0.e0.j) this.o).getThreadData().l1().roomId, this.K ? AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB : AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY);
                m.l(this.C, ((b.a.r0.b0.e0.j) this.o).f14748e.f0(), R.color.CAM_X0105, R.color.CAM_X0109);
                if (((b.a.r0.b0.e0.j) this.o).getThreadData() == null || ((b.a.r0.b0.e0.j) this.o).getThreadData().l1() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_CLICK);
                statisticItem.param("obj_locate", this.K ? 2 : 1);
                statisticItem.param("obj_param1", ((b.a.r0.b0.e0.j) this.o).getThreadData().l1().live_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    @Override // b.a.r0.p.e
    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
        }
    }
}
