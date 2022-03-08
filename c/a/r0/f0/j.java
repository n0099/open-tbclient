package c.a.r0.f0;

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
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
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
/* loaded from: classes2.dex */
public class j extends c.a.r0.f0.a<c.a.r0.f0.d0.j> implements c.a.r0.t.e {
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

    /* loaded from: classes2.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f17315e;

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
            this.f17315e = jVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17315e.F.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f17315e.F.cancelAnimation();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f17316e;

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
            this.f17316e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17316e.g() == null) {
                return;
            }
            this.f17316e.g().a(view, this.f17316e.o);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

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
            this.a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            T t;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || (t = this.a.o) == 0 || ((c.a.r0.f0.d0.j) t).f17272e == null || ((c.a.r0.f0.d0.j) t).f17272e.w1() == null || this.a.C == null || !((String) customResponsedMessage.getData()).equals(((c.a.r0.f0.d0.j) this.a.o).f17272e.w1())) {
                return;
            }
            j jVar = this.a;
            m.l(jVar.C, ((c.a.r0.f0.d0.j) jVar.o).f17272e.h0(), R.color.CAM_X0109, R.color.CAM_X0109);
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
        M(j());
    }

    public View J() {
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

    public View K() {
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

    public void L() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (c.a.q0.r.l.c().g() && (t = this.o) != 0 && ((c.a.r0.f0.d0.j) t).getThreadData() != null && ((c.a.r0.f0.d0.j) this.o).getThreadData().p1() != null) {
                this.E.setPlaceHolder(3);
                this.E.startLoad(((c.a.r0.f0.d0.j) this.o).getThreadData().p1().cover, 10, false);
                this.D.setVisibility(0);
                return;
            }
            this.D.setVisibility(8);
        }
    }

    public final void M(View view) {
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
            s(this.p);
            s(this.q);
            this.A.setOnClickListener(this);
            HomeGroupUbsUIHelper.handleImgMask(view.findViewById(R.id.imageMask), R.color.transparent);
        }
    }

    public final void N(long j2, long j3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str}) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.f17261f;
            urlManager.dealOneLink(tbPageContext, new String[]{"bdtiebalive://video/live?room_id=" + j3 + "&live_id=" + j2 + "&enterroom_type=1&from" + str});
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.f0.b
    /* renamed from: O */
    public void k(c.a.r0.f0.d0.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.o = jVar;
            P();
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            T t = this.o;
            if (t != 0 && ((c.a.r0.f0.d0.j) t).getThreadData() != null) {
                this.z.setVisibility(0);
                int k = c.a.d.f.p.n.k(this.m.getPageActivity());
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
                this.B.setData(((c.a.r0.f0.d0.j) this.o).getThreadData());
                this.B.setUserAfterClickListener(this.M);
                if (((c.a.r0.f0.d0.j) this.o).getThreadData().p1() != null) {
                    this.C.setText(((c.a.r0.f0.d0.j) this.o).getThreadData().p1().friendRoomName);
                }
                if (((c.a.r0.f0.d0.j) this.o).f17272e.p1().audience_count > 0) {
                    this.J.setVisibility(0);
                    this.G.setVisibility(0);
                    this.G.setText(String.format(this.m.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(((c.a.r0.f0.d0.j) this.o).f17272e.p1().audience_count)));
                } else {
                    this.J.setVisibility(8);
                    this.G.setVisibility(8);
                }
                this.H.setVisibility(8);
                if (((c.a.r0.f0.d0.j) this.o).f17272e.p1().openRecomReason == 1) {
                    String str = ((c.a.r0.f0.d0.j) this.o).f17272e.p1().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.H.setVisibility(0);
                        this.H.setText(str);
                    } else {
                        String y0 = ((c.a.r0.f0.d0.j) this.o).f17272e.y0();
                        String E0 = ((c.a.r0.f0.d0.j) this.o).f17272e.E0();
                        if (UtilHelper.isDecimal(y0) && UtilHelper.isDecimal(E0) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo c2 = c.a.r0.j3.k0.a.e().c();
                            String str2 = c2.latitude;
                            String str3 = c2.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && c.a.d.f.p.n.g(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(y0), Double.parseDouble(E0)) <= 50.0d) {
                                this.H.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                                this.H.setVisibility(0);
                            }
                        }
                    }
                }
                C(this.z);
                l(this.m, TbadkCoreApplication.getInst().getSkinType());
                if (m.k(((c.a.r0.f0.d0.j) this.o).f17272e.h0())) {
                    SkinManager.setViewTextColor(this.C, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.C, R.color.CAM_X0105, 1);
                }
                L();
                this.F.playAnimation();
                return;
            }
            this.z.setVisibility(8);
        }
    }

    public void Q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) || bdUniqueId == null || this.p == null || this.N == null) {
            return;
        }
        n(bdUniqueId);
        w(bdUniqueId);
        CardUserInfoLayout cardUserInfoLayout = this.B;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        this.N.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.N);
    }

    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.K = z;
        }
    }

    public void S(int i2) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (threadCommentAndPraiseInfoLayout = this.p) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.statFloor = String.valueOf(i2);
    }

    @Override // c.a.r0.t.e
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
        }
    }

    @Override // c.a.r0.f0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? R.layout.card_home_page_ala_live_item_new : invokeV.intValue;
    }

    @Override // c.a.r0.f0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048589, this, tbPageContext, i2) == null) || this.f17260e == i2) {
            return;
        }
        v(tbPageContext, i2);
        c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(this.A);
        d2.n(R.string.J_X06);
        d2.i(R.color.CAM_X0205, R.color.CAM_X0206);
        c.a.q0.r.v.c d3 = c.a.q0.r.v.c.d(this.D);
        d3.l(R.dimen.L_X01);
        d3.k(R.color.CAM_X0401);
        d3.n(R.string.J_X05);
        d3.f(R.color.CAM_X0611);
        float f2 = c.a.d.f.p.n.f(getContext(), R.dimen.tbds31);
        SkinManager.setBackgroundEndColorToAutoColor(this.I, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
        SkinManager.setBackgroundColor(this.J, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.C, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.G, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.H, (int) R.color.CAM_X0101);
        this.B.onChangeSkinType(i(), TbadkCoreApplication.getInst().getSkinType());
        this.E.setPlaceHolder(3);
        this.f17260e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
            if (view == this.A || view == this.p.getCommentContainer() || view == this.q.getCommentContainer()) {
                N(((c.a.r0.f0.d0.j) this.o).getThreadData().p1().live_id, ((c.a.r0.f0.d0.j) this.o).getThreadData().p1().roomId, this.K ? AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB : AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY);
                m.l(this.C, ((c.a.r0.f0.d0.j) this.o).f17272e.h0(), R.color.CAM_X0105, R.color.CAM_X0109);
                if (((c.a.r0.f0.d0.j) this.o).getThreadData() == null || ((c.a.r0.f0.d0.j) this.o).getThreadData().p1() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_CLICK);
                statisticItem.param("obj_locate", this.K ? 2 : 1);
                statisticItem.param("obj_param1", ((c.a.r0.f0.d0.j) this.o).getThreadData().p1().live_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
            }
        }
    }
}
