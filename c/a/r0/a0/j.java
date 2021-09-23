package c.a.r0.a0;

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
/* loaded from: classes3.dex */
public class j extends c.a.r0.a0.a<c.a.r0.a0.d0.j> implements c.a.r0.o.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CardUserInfoLayout A;
    public TextView B;
    public RelativeLayout C;
    public TbImageView D;
    public TBLottieAnimationView E;
    public TextView F;
    public TextView G;
    public LinearLayout H;
    public View I;
    public boolean J;
    public int K;
    public View.OnClickListener L;
    public CustomMessageListener M;
    public FrameLayout y;
    public LinearLayout z;

    /* loaded from: classes3.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f15619e;

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
            this.f15619e = jVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15619e.E.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f15619e.E.cancelAnimation();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f15620e;

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
            this.f15620e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15620e.g() == null) {
                return;
            }
            this.f15620e.g().a(view, this.f15620e.o);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f15621a;

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
            this.f15621a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            T t;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || (t = this.f15621a.o) == 0 || ((c.a.r0.a0.d0.j) t).f15571e == null || ((c.a.r0.a0.d0.j) t).f15571e.s1() == null || this.f15621a.B == null || !((String) customResponsedMessage.getData()).equals(((c.a.r0.a0.d0.j) this.f15621a.o).f15571e.s1())) {
                return;
            }
            j jVar = this.f15621a;
            TextView textView = jVar.B;
            String f0 = ((c.a.r0.a0.d0.j) jVar.o).f15571e.f0();
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
        this.J = false;
        this.K = 0;
        this.L = new b(this);
        this.M = new c(this, 2001390);
        this.m = tbPageContext;
        this.n = bdUniqueId;
        S(j());
    }

    public View P() {
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

    public View Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.J) {
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

    public void R() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (c.a.q0.s.k.c().g() && (t = this.o) != 0 && ((c.a.r0.a0.d0.j) t).getThreadData() != null && ((c.a.r0.a0.d0.j) this.o).getThreadData().l1() != null) {
                this.D.setPlaceHolder(3);
                this.D.startLoad(((c.a.r0.a0.d0.j) this.o).getThreadData().l1().cover, 10, false);
                this.C.setVisibility(0);
                return;
            }
            this.C.setVisibility(8);
        }
    }

    public final void S(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
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
            this.H = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
            this.E = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            SkinManager.setLottieAnimation(this.E, R.raw.ala_live2);
            this.E.addOnAttachStateChangeListener(new a(this));
            this.F = (TextView) view.findViewById(R.id.play_count);
            this.G = (TextView) view.findViewById(R.id.ala_live_recom_reason);
            this.I = view.findViewById(R.id.play_count_line);
            this.u = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
            this.p = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
            this.q = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
            s(this.p);
            s(this.q);
            this.z.setOnClickListener(this);
            c.a.q0.b.g.b.h(view.findViewById(R.id.imageMask), R.color.transparent);
        }
    }

    public final void T(long j2, long j3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str}) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.f15558f;
            urlManager.dealOneLink(tbPageContext, new String[]{"bdtiebalive://video/live?room_id=" + j3 + "&live_id=" + j2 + "&enterroom_type=1&from" + str});
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a0.b
    /* renamed from: U */
    public void k(c.a.r0.a0.d0.j jVar) {
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
            if (t != 0 && ((c.a.r0.a0.d0.j) t).getThreadData() != null) {
                this.y.setVisibility(0);
                int k = c.a.e.e.p.l.k(this.m.getPageActivity());
                if (k != this.K) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.C.getLayoutParams();
                    int dimenPixelSize = k - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    layoutParams.width = dimenPixelSize;
                    layoutParams.height = (dimenPixelSize * 9) / 16;
                    this.C.setLayoutParams(layoutParams);
                    this.K = k;
                }
                this.p.setShowFlag(11);
                this.p.resetShareContainer();
                this.A.setVisibility(0);
                this.A.setData(((c.a.r0.a0.d0.j) this.o).getThreadData());
                this.A.setUserAfterClickListener(this.L);
                if (((c.a.r0.a0.d0.j) this.o).getThreadData().l1() != null) {
                    this.B.setText(((c.a.r0.a0.d0.j) this.o).getThreadData().l1().friendRoomName);
                }
                if (((c.a.r0.a0.d0.j) this.o).f15571e.l1().audience_count > 0) {
                    this.I.setVisibility(0);
                    this.F.setVisibility(0);
                    this.F.setText(String.format(this.m.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(((c.a.r0.a0.d0.j) this.o).f15571e.l1().audience_count)));
                } else {
                    this.I.setVisibility(8);
                    this.F.setVisibility(8);
                }
                this.G.setVisibility(8);
                if (((c.a.r0.a0.d0.j) this.o).f15571e.l1().openRecomReason == 1) {
                    String str = ((c.a.r0.a0.d0.j) this.o).f15571e.l1().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.G.setVisibility(0);
                        this.G.setText(str);
                    } else {
                        String w0 = ((c.a.r0.a0.d0.j) this.o).f15571e.w0();
                        String C0 = ((c.a.r0.a0.d0.j) this.o).f15571e.C0();
                        if (UtilHelper.isDecimal(w0) && UtilHelper.isDecimal(C0) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo c2 = c.a.r0.y2.j0.a.e().c();
                            String str2 = c2.latitude;
                            String str3 = c2.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && c.a.e.e.p.l.a(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(w0), Double.parseDouble(C0)) <= 50.0d) {
                                this.G.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                                this.G.setVisibility(0);
                            }
                        }
                    }
                }
                B(this.y);
                l(this.m, TbadkCoreApplication.getInst().getSkinType());
                if (m.k(((c.a.r0.a0.d0.j) this.o).f15571e.f0())) {
                    SkinManager.setViewTextColor(this.B, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.B, R.color.CAM_X0105, 1);
                }
                R();
                this.E.playAnimation();
                return;
            }
            this.y.setVisibility(8);
        }
    }

    public void W(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) || bdUniqueId == null || this.p == null || this.M == null) {
            return;
        }
        n(bdUniqueId);
        w(bdUniqueId);
        CardUserInfoLayout cardUserInfoLayout = this.A;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        this.M.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.M);
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.J = z;
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

    @Override // c.a.r0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? R.layout.card_home_page_ala_live_item_new : invokeV.intValue;
    }

    @Override // c.a.r0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048588, this, tbPageContext, i2) == null) || this.f15557e == i2) {
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
        SkinManager.setBackgroundEndColorToAutoColor(this.H, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{g2, g2, g2, g2, g2, g2, g2, g2});
        SkinManager.setBackgroundColor(this.I, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.B, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.F, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.G, R.color.CAM_X0101);
        this.A.onChangeSkinType(i(), TbadkCoreApplication.getInst().getSkinType());
        this.D.setPlaceHolder(3);
        this.f15557e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            if (view == this.z || view == this.p.getCommentContainer() || view == this.q.getCommentContainer()) {
                T(((c.a.r0.a0.d0.j) this.o).getThreadData().l1().live_id, ((c.a.r0.a0.d0.j) this.o).getThreadData().l1().roomId, this.J ? AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB : AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY);
                m.l(this.B, ((c.a.r0.a0.d0.j) this.o).f15571e.f0(), R.color.CAM_X0105, R.color.CAM_X0109);
                if (((c.a.r0.a0.d0.j) this.o).getThreadData() == null || ((c.a.r0.a0.d0.j) this.o).getThreadData().l1() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_CLICK);
                statisticItem.param("obj_locate", this.J ? 2 : 1);
                statisticItem.param("obj_param1", ((c.a.r0.a0.d0.j) this.o).getThreadData().l1().live_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    @Override // c.a.r0.o.e
    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
        }
    }
}
