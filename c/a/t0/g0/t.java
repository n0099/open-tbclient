package c.a.t0.g0;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.e1.o0;
import c.a.s0.s.q.d2;
import c.a.t0.g0.s;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class t extends c.a.t0.g0.b<CardPersonDynamicThreadData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public ConstrainImageGroup C;
    public boolean D;
    public View E;
    public TbImageView F;
    public ImageView G;
    public LinearLayout H;
    public TextView I;
    public LinearLayout J;
    public LinearLayout K;
    public TextView L;
    public TextView M;
    public TextView N;
    public TBLottieAnimationView O;
    public TextView P;
    public TextView Q;
    public OriginalThreadCardView R;
    public View S;
    public View T;
    public ThreadCardBottomOpSegmentLayout U;
    public boolean V;
    public boolean W;
    public EMTextView X;
    public View.OnClickListener Y;
    public s.j Z;
    public final View.OnClickListener a0;
    public final View.OnClickListener b0;
    public TbImageView.g c0;
    public PlayVoiceBntNew m;
    public ThreadViewAndCommentInfoLayout n;
    public View o;
    public int p;
    public CardPersonDynamicThreadData q;
    public TbPageContext<?> r;
    public TextView s;
    public LinearLayout t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public ImageView y;
    public s z;

    /* loaded from: classes7.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;

        public a(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.a.F != null) {
                this.a.F.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t f18325e;

        public b(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18325e = tVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18325e.g() == null) {
                return;
            }
            this.f18325e.g().a(view, this.f18325e.q);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardPersonDynamicThreadData f18326e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ t f18327f;

        public c(t tVar, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, cardPersonDynamicThreadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18327f = tVar;
            this.f18326e = cardPersonDynamicThreadData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18327f.r == null) {
                return;
            }
            if (this.f18327f.z == null) {
                t tVar = this.f18327f;
                tVar.z = new s(tVar.r);
                this.f18327f.z.o();
                this.f18327f.z.s(this.f18327f.Z);
            }
            this.f18327f.z.n(this.f18327f.q, this.f18326e.L == 1);
            this.f18327f.z.u();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements c.a.s0.g1.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedList a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d2 f18328b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ t f18329c;

        public d(t tVar, LinkedList linkedList, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, linkedList, d2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18329c = tVar;
            this.a = linkedList;
            this.f18328b = d2Var;
        }

        @Override // c.a.s0.g1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                if (z) {
                    this.f18329c.I();
                } else {
                    this.f18329c.Q(view, this.a, i2, this.f18328b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends c.a.t0.n4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ t f18330f;

        public e(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18330f = tVar;
        }

        @Override // c.a.t0.n4.f
        public void a(TextPaint textPaint, boolean z) {
            int color;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, textPaint, z) == null) {
                if (z) {
                    color = this.f18330f.f18211g.getResources().getColor(c.a.t0.y2.a.CAM_X0304);
                } else {
                    color = this.f18330f.f18211g.getResources().getColor(c.a.t0.y2.a.CAM_X0302);
                }
                textPaint.setColor(color);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f18330f.q == null || StringUtils.isNull(this.f18330f.q.l)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f18330f.f18211g).createNormalCfg(this.f18330f.q.l, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t f18331e;

        public f(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18331e = tVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f18331e.g() != null) {
                    this.f18331e.g().a(view, this.f18331e.q);
                }
                if (this.f18331e.q.o != 60) {
                    if ((this.f18331e.q.o != 40 || this.f18331e.q.r != 2) && !this.f18331e.W) {
                        this.f18331e.I();
                        return;
                    } else {
                        BdToast.i(this.f18331e.getContext(), this.f18331e.getContext().getString(c.a.t0.y2.g.video_check_click_msg), c.a.t0.y2.c.icon_pure_toast_mistake40_svg, true).q();
                        return;
                    }
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (this.f18331e.q.t.o1().live_status != 1) {
                    this.f18331e.J();
                } else {
                    this.f18331e.G();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(t tVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, Integer.valueOf(i2)};
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
            this.a = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || this.a.q == null || this.a.q.f43965f == null || this.a.A == null || this.a.B == null || !((String) customResponsedMessage.getData()).equals(this.a.q.f43965f) || this.a.F()) {
                return;
            }
            m.l(this.a.A, this.a.q.f43965f, c.a.t0.y2.a.CAM_X0105, c.a.t0.y2.a.CAM_X0109);
            m.l(this.a.B, this.a.q.f43965f, c.a.t0.y2.a.CAM_X0107, c.a.t0.y2.a.CAM_X0109);
        }
    }

    /* loaded from: classes7.dex */
    public class h implements s.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;

        public h(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tVar;
        }

        @Override // c.a.t0.g0.s.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.O(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t f18332e;

        public i(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18332e = tVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d0<CardPersonDynamicThreadData> g2 = this.f18332e.g();
                if (g2 != null) {
                    view.setTag("1");
                    g2.a(view, this.f18332e.q);
                }
                this.f18332e.I();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t f18333e;

        public j(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18333e = tVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d0<CardPersonDynamicThreadData> g2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (g2 = this.f18333e.g()) == null) {
                return;
            }
            view.setTag("2");
            g2.a(view, this.f18333e.q);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.p = 3;
        this.D = true;
        new e(this);
        this.Y = new f(this);
        new g(this, 2001390);
        this.Z = new h(this);
        this.a0 = new i(this);
        this.b0 = new j(this);
        this.c0 = new a(this);
        View j2 = j();
        this.o = j2;
        this.r = tbPageContext;
        this.s = (TextView) j2.findViewById(c.a.t0.y2.d.year_num);
        this.t = (LinearLayout) this.o.findViewById(c.a.t0.y2.d.left_time_view);
        this.u = (TextView) this.o.findViewById(c.a.t0.y2.d.month_num);
        this.v = (TextView) this.o.findViewById(c.a.t0.y2.d.day_num);
        this.w = (TextView) this.o.findViewById(c.a.t0.y2.d.source_bar);
        this.Q = (TextView) this.o.findViewById(c.a.t0.y2.d.video_under_review);
        this.x = (TextView) this.o.findViewById(c.a.t0.y2.d.tv_privacy_status);
        this.y = (ImageView) this.o.findViewById(c.a.t0.y2.d.iv_more);
        this.A = (TextView) this.o.findViewById(c.a.t0.y2.d.thread_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) this.o.findViewById(c.a.t0.y2.d.card_dynamic_thread_abstract_voice);
        this.m = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(this.b0);
        TextView textView = (TextView) this.o.findViewById(c.a.t0.y2.d.thread_content);
        this.B = textView;
        textView.setVisibility(8);
        this.C = (ConstrainImageGroup) this.o.findViewById(c.a.t0.y2.d.card_dynamic_thread_img_layout);
        this.C.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.t0.y2.b.tbds20));
        this.C.setChildClickListener(this.a0);
        c.a.s0.g1.j.a aVar = new c.a.s0.g1.j.a(3);
        aVar.d(1.0d);
        this.C.setImageProcessor(aVar);
        this.E = this.o.findViewById(c.a.t0.y2.d.thread_view_img_container);
        this.F = (TbImageView) this.o.findViewById(c.a.t0.y2.d.thread_video_thumbnail);
        this.G = (ImageView) this.o.findViewById(c.a.t0.y2.d.thread_img_pause_play);
        this.n = (ThreadViewAndCommentInfoLayout) this.o.findViewById(c.a.t0.y2.d.card_dynamic_thread_info_layout);
        this.K = (LinearLayout) this.o.findViewById(c.a.t0.y2.d.duration_container);
        this.L = (TextView) this.o.findViewById(c.a.t0.y2.d.video_duration);
        this.M = (TextView) this.o.findViewById(c.a.t0.y2.d.video_play_count);
        this.N = (TextView) this.o.findViewById(c.a.t0.y2.d.audience_count);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.o.findViewById(c.a.t0.y2.d.ala_play);
        this.O = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        SkinManager.setLottieAnimation(this.O, c.a.t0.y2.f.ala_play);
        this.P = (TextView) this.o.findViewById(c.a.t0.y2.d.fake_video_state);
        this.H = (LinearLayout) this.o.findViewById(c.a.t0.y2.d.shared_ala_live_layout);
        this.I = (TextView) this.o.findViewById(c.a.t0.y2.d.shared_ala_live_room_title);
        LinearLayout linearLayout = (LinearLayout) this.o.findViewById(c.a.t0.y2.d.llAlaLivingLogLayout);
        this.J = linearLayout;
        linearLayout.setVisibility(8);
        this.R = (OriginalThreadCardView) this.o.findViewById(c.a.t0.y2.d.original_thread_info);
        this.S = this.o.findViewById(c.a.t0.y2.d.divider_line_thick);
        this.T = this.o.findViewById(c.a.t0.y2.d.divider_line_thin);
        ThreadCardBottomOpSegmentLayout threadCardBottomOpSegmentLayout = (ThreadCardBottomOpSegmentLayout) this.o.findViewById(c.a.t0.y2.d.card_thread_info_layout);
        this.U = threadCardBottomOpSegmentLayout;
        threadCardBottomOpSegmentLayout.hideDisagree();
        if (this.U.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.U.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.U.setLayoutParams(layoutParams);
        }
        this.U.setOnClickListener(this.Y);
        this.U.setReplyTimeVisible(false);
        this.U.setShowPraiseNum(true);
        this.U.setNeedAddPraiseIcon(true);
        this.U.setNeedAddReplyIcon(true);
        this.U.setShareVisible(true);
        this.U.setIsBarViewVisible(false);
        this.U.setFrom(13);
        c.a.s0.s.q.f fVar = new c.a.s0.s.q.f();
        fVar.f13685b = 8;
        fVar.f13691h = 3;
        this.U.setAgreeStatisticData(fVar);
        this.U.setShareReportFrom(6);
        this.U.setStType("person_page");
        this.U.setForumAfterClickListener(new b(this));
        this.X = (EMTextView) this.o.findViewById(c.a.t0.y2.d.tv_ueg_view);
    }

    public final void E(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cardPersonDynamicThreadData) == null) || cardPersonDynamicThreadData == null) {
            return;
        }
        if (!this.V && !this.W) {
            this.U.setCommentClickable(true);
            this.U.setAgreeClickable(true);
            this.U.setShareClickable(true);
            this.R.setClickable(true);
            this.y.setClickable(true);
        } else {
            this.U.setCommentClickable(false);
            this.U.setAgreeClickable(false);
            this.U.setShareClickable(false);
            this.R.setClickable(false);
            this.y.setClickable(false);
        }
        this.U.setCommentNumEnable(true);
        if (cardPersonDynamicThreadData.o == 60) {
            this.U.setCommentNumEnable(false);
        }
        CardPersonDynamicThreadData.MultipleForum[] multipleForumArr = cardPersonDynamicThreadData.F;
        if (multipleForumArr != null) {
            this.U.setMultiForumCount(multipleForumArr.length);
        }
        d2 d2Var = cardPersonDynamicThreadData.t;
        if (d2Var != null) {
            this.U.setForumId(String.valueOf(d2Var.U()));
        }
        this.U.setData(cardPersonDynamicThreadData.t);
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.q.J : invokeV.booleanValue;
    }

    public void G() {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cardPersonDynamicThreadData = this.q) == null || (d2Var = cardPersonDynamicThreadData.t) == null || d2Var.o1() == null) {
            return;
        }
        if (!c.a.d.f.p.l.z()) {
            c.a.d.f.p.n.L(this.r.getPageActivity(), c.a.t0.y2.g.no_network_guide);
            return;
        }
        if (!F()) {
            m.a(this.q.f43965f);
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(this.q.t.o1());
        if (this.q.t.o1().user_info != null) {
            alaLiveInfoCoreData.userName = this.q.t.o1().user_info.user_name;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.r.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
    }

    public final void H() {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        d2 d2Var;
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cardPersonDynamicThreadData = this.q) == null || (d2Var = cardPersonDynamicThreadData.t) == null || (originalThreadInfo = d2Var.A1) == null) {
            return;
        }
        PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.r.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.f41554f, null, "person_page", 18005);
        createCfgForPersonCenter.setStartFrom(this.l);
        createCfgForPersonCenter.setBjhData(originalThreadInfo.p);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        TiebaStatic.log(new StatisticItem("c12943").param("obj_type", "3").param("tid", this.q.f43965f).param("obj_param1", this.q.J ? 1 : 2));
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.q == null) {
            return;
        }
        if (!F()) {
            m.a(this.q.f43965f);
            m.l(this.A, this.q.f43965f, c.a.t0.y2.a.CAM_X0105, c.a.t0.y2.a.CAM_X0109);
            m.l(this.B, this.q.f43965f, c.a.t0.y2.a.CAM_X0107, c.a.t0.y2.a.CAM_X0109);
        }
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.r.getPageActivity());
        if (this.q.o == 40) {
            pbActivityConfig.setVideo_source("profile");
        }
        pbActivityConfig.createFromThreadCfg(this.q.t, null, "person_page", 18005, true, false, false);
        pbActivityConfig.setForumId(String.valueOf(this.q.t.U()));
        pbActivityConfig.setForumName(this.q.t.a0());
        pbActivityConfig.setStartFrom(this.l);
        pbActivityConfig.setIsShareThread(this.q.t.B1);
        pbActivityConfig.setThreadData(this.q.t);
        pbActivityConfig.setIsPrivacy(this.q.s);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        d2 d2Var = this.q.t;
        if (d2Var == null || !d2Var.B1) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12943").param("obj_type", "2").param("tid", this.q.f43965f).param("obj_param1", this.q.J ? 1 : 2));
    }

    public final void J() {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (cardPersonDynamicThreadData = this.q) == null || (d2Var = cardPersonDynamicThreadData.t) == null || d2Var.o1() == null || this.q.t.o1().share_info == null) {
            return;
        }
        if (!F()) {
            m.a(this.q.f43965f);
        }
        if (this.q.t.o1().share_info.record_tid <= 0) {
            G();
            return;
        }
        String valueOf = String.valueOf(this.q.t.o1().share_info.record_tid);
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.r.getPageActivity());
        pbActivityConfig.setVideo_source("profile");
        pbActivityConfig.setStartFrom(this.l);
        pbActivityConfig.setThreadData(this.q.t);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02eb  */
    @Override // c.a.t0.g0.b
    /* renamed from: K */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cardPersonDynamicThreadData) == null) {
            if (cardPersonDynamicThreadData == null) {
                if (j() != null) {
                    j().setVisibility(8);
                    return;
                }
                return;
            }
            this.q = cardPersonDynamicThreadData;
            if (j() != null) {
                j().setVisibility(0);
                j().setOnClickListener(this.Y);
            }
            this.s.setVisibility(cardPersonDynamicThreadData.H ? 0 : 8);
            this.t.setVisibility(cardPersonDynamicThreadData.G ? 0 : 4);
            this.S.setVisibility(cardPersonDynamicThreadData.G ? 0 : 8);
            this.T.setVisibility(cardPersonDynamicThreadData.G ? 8 : 0);
            if (cardPersonDynamicThreadData.I) {
                this.S.setVisibility(8);
                this.T.setVisibility(8);
            }
            this.V = cardPersonDynamicThreadData.o == 40 && cardPersonDynamicThreadData.r == 2;
            P(cardPersonDynamicThreadData);
            d2 d2Var = cardPersonDynamicThreadData.t;
            if (d2Var != null) {
                this.W = d2Var.B1 && cardPersonDynamicThreadData.r == 2;
            }
            this.s.setText(cardPersonDynamicThreadData.v);
            this.u.setText(cardPersonDynamicThreadData.w);
            this.v.setText(cardPersonDynamicThreadData.x);
            CardPersonDynamicThreadData.MultipleForum[] multipleForumArr = cardPersonDynamicThreadData.F;
            if (multipleForumArr != null && multipleForumArr.length > 0) {
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                while (true) {
                    CardPersonDynamicThreadData.MultipleForum[] multipleForumArr2 = cardPersonDynamicThreadData.F;
                    if (i2 >= multipleForumArr2.length) {
                        break;
                    }
                    sb.append(StringHelper.cutChineseAndEnglishWithSuffix(multipleForumArr2[i2].forum_name, 14, "..."));
                    if (i2 < cardPersonDynamicThreadData.F.length - 1) {
                        sb.append("吧、");
                    } else if (sb.lastIndexOf(this.f18211g.getString(c.a.t0.y2.g.forum)) != sb.length() - 1) {
                        sb.append(this.f18211g.getString(c.a.t0.y2.g.forum));
                    }
                    i2++;
                }
                String sb2 = sb.toString();
                if (sb2.trim().length() > 0) {
                    this.w.setText(sb2);
                    this.w.setVisibility(0);
                } else {
                    this.w.setText(c.a.t0.y2.g.person_homepage);
                }
            } else {
                this.w.setText(c.a.t0.y2.g.person_homepage);
            }
            this.X.setVisibility(8);
            if (cardPersonDynamicThreadData.J) {
                int i3 = cardPersonDynamicThreadData.u;
                if (i3 == 3) {
                    this.x.setVisibility(8);
                } else if (i3 == 1) {
                    this.x.setVisibility(0);
                }
                O(cardPersonDynamicThreadData.s);
                if (cardPersonDynamicThreadData.L == 1) {
                    this.x.setVisibility(8);
                    this.X.setVisibility(0);
                }
                this.y.setVisibility(0);
                this.y.setOnClickListener(new c(this, cardPersonDynamicThreadData));
            } else {
                this.x.setVisibility(8);
                this.y.setVisibility(8);
            }
            VoiceData$VoiceModel[] voiceData$VoiceModelArr = cardPersonDynamicThreadData.D;
            if (voiceData$VoiceModelArr != null && voiceData$VoiceModelArr.length > 0) {
                this.m.setVisibility(0);
                R(true);
                VoiceData$VoiceModel voiceData$VoiceModel = voiceData$VoiceModelArr[0];
                this.m.setVoiceModel(voiceData$VoiceModel);
                this.m.setTag(voiceData$VoiceModel);
                this.m.changeSkin();
                if (voiceData$VoiceModel != null) {
                    this.m.refreshViewState(voiceData$VoiceModel.voice_status.intValue());
                }
                this.m.resetLayoutParams();
            } else {
                this.m.setVisibility(8);
                R(false);
            }
            MediaData[] mediaDataArr = cardPersonDynamicThreadData.B;
            SkinManager.setBackgroundResource(this.H, c.a.t0.y2.a.transparent);
            this.I.setVisibility(8);
            this.J.setVisibility(8);
            this.H.setVisibility(0);
            this.E.setVisibility(8);
            this.P.setVisibility(8);
            this.K.setVisibility(8);
            this.N.setVisibility(8);
            this.O.cancelAnimation();
            this.O.setVisibility(8);
            long j2 = cardPersonDynamicThreadData.o;
            if (j2 == 36) {
                this.C.setVisibility(8);
            } else {
                if (j2 != 40) {
                    long j3 = this.q.o;
                    if (j3 != 50) {
                        if (j3 != 60 && j3 != 49) {
                            if (c.a.s0.s.k.c().g() && mediaDataArr.length > 0) {
                                LinkedList linkedList = new LinkedList();
                                d2 d2Var2 = cardPersonDynamicThreadData.t;
                                for (MediaData mediaData : mediaDataArr) {
                                    if (mediaData != null && mediaData.getType() == 3) {
                                        linkedList.add(mediaData);
                                    }
                                }
                                if (ListUtils.getCount(linkedList) > 0) {
                                    this.C.setVisibility(0);
                                    this.C.setFromCDN(this.D);
                                    this.C.setSingleImageRatio(0.67d);
                                    this.C.setImageClickListener(new d(this, linkedList, d2Var2));
                                    this.C.setImageMediaList(linkedList);
                                } else {
                                    this.C.setVisibility(8);
                                }
                            } else {
                                this.C.setVisibility(8);
                            }
                            this.H.setVisibility(8);
                        } else {
                            this.C.setVisibility(8);
                            if (this.q.t.o1() != null && this.q.t.o1().user_info != null) {
                                CardPersonDynamicThreadData cardPersonDynamicThreadData2 = this.q;
                                if (cardPersonDynamicThreadData2.o == 60) {
                                    String str = cardPersonDynamicThreadData2.t.o1().user_info.user_name;
                                    if (o0.d(str) > 14) {
                                        str = o0.m(str, 14) + "...";
                                    }
                                    this.I.setText(m.d(str + ":", this.q.t.getTitle()));
                                    this.I.setVisibility(0);
                                    if (c.a.s0.s.k.c().g()) {
                                        this.E.setVisibility(0);
                                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.E.getLayoutParams();
                                        int width = this.E.getWidth();
                                        if (width == 0 || width > c.a.d.f.p.n.k(this.f18211g)) {
                                            width = (int) getContext().getResources().getDimension(c.a.t0.y2.b.ds560);
                                        }
                                        layoutParams.height = (width * 9) / 16;
                                        this.E.setLayoutParams(layoutParams);
                                        if (this.q.t.o1() != null) {
                                            this.F.setPlaceHolder(3);
                                            this.F.setEvent(this.c0);
                                            this.F.startLoad(cardPersonDynamicThreadData.t.o1().cover, 10, false);
                                            this.G.setVisibility(8);
                                            this.O.setVisibility(0);
                                            this.O.playAnimation();
                                            SkinManager.setBackgroundResource(this.H, c.a.t0.y2.a.CAM_X0205);
                                            this.N.setVisibility(0);
                                            this.N.setText(String.format(this.f18211g.getResources().getString(c.a.t0.y2.g.ala_audience_count_prefix), StringHelper.numFormatOverWan(this.q.t.o1().audience_count)));
                                            this.U.getCommentContainer().setOnClickListener(this.Y);
                                        } else {
                                            this.U.getCommentContainer().setOnClickListener(this.U);
                                        }
                                    }
                                }
                            }
                            this.I.setVisibility(8);
                            if (c.a.s0.s.k.c().g()) {
                            }
                        }
                    }
                }
                this.C.setVisibility(8);
                if (c.a.s0.s.k.c().g()) {
                    this.E.setVisibility(0);
                    this.G.setVisibility(0);
                    this.G.setImageResource(c.a.t0.y2.c.icon_play_video);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.E.getLayoutParams();
                    int width2 = this.E.getWidth();
                    if (width2 == 0 || width2 > c.a.d.f.p.n.k(this.f18211g)) {
                        width2 = (int) getContext().getResources().getDimension(c.a.t0.y2.b.ds672);
                    }
                    layoutParams2.height = (int) (width2 * 0.5625d);
                    this.E.setLayoutParams(layoutParams2);
                    if (this.q.C != null) {
                        this.F.setPlaceHolder(3);
                        this.F.setEvent(this.c0);
                        this.F.startLoad(this.q.C.thumbnail_url, 17, false);
                        if (this.V) {
                            this.P.setVisibility(0);
                            this.P.setText(String.format(this.f18211g.getResources().getString(c.a.t0.y2.g.video_review_state), new Object[0]));
                        } else {
                            this.K.setVisibility(0);
                            this.L.setText(StringHelper.stringForVideoTime(this.q.C.video_duration.intValue() * 1000));
                            this.M.setText(String.format(this.f18211g.getResources().getString(c.a.t0.y2.g.play_count), StringHelper.numFormatOverWan(this.q.C.play_count.intValue())));
                        }
                    }
                }
            }
            d2 d2Var3 = cardPersonDynamicThreadData.t;
            if (d2Var3 != null && d2Var3.A1 != null) {
                this.R.setVisibility(0);
                this.R.fillData(cardPersonDynamicThreadData.t.A1);
                this.R.setOnClickListener(this);
                this.m.setVisibility(8);
                this.C.setVisibility(8);
                this.H.setVisibility(8);
                if (this.W) {
                    this.Q.setVisibility(0);
                } else {
                    this.Q.setVisibility(8);
                }
            } else {
                this.R.setVisibility(8);
                this.Q.setVisibility(8);
            }
            N();
            E(cardPersonDynamicThreadData);
        }
    }

    public void L(c.a.d.f.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || (constrainImageGroup = this.C) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(bVar);
    }

    public void M(c.a.d.f.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || (constrainImageGroup = this.C) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(bVar);
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.m.setClickable(true);
            int childCount = this.C.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.C.getChildAt(i2);
                if (childAt != null) {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public final void O(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (textView = this.x) == null) {
            return;
        }
        if (z) {
            textView.setText(c.a.t0.y2.g.privacy);
            Drawable drawable = SkinManager.getDrawable(c.a.t0.y2.c.icon_card_privacy);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.x.setCompoundDrawables(drawable, null, null, null);
            return;
        }
        textView.setText(c.a.t0.y2.g.public_open);
        Drawable drawable2 = SkinManager.getDrawable(c.a.t0.y2.c.icon_card_open);
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        this.x.setCompoundDrawables(drawable2, null, null, null);
    }

    public final boolean P(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        InterceptResult invokeL;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, cardPersonDynamicThreadData)) == null) {
            if (cardPersonDynamicThreadData == null || (d2Var = cardPersonDynamicThreadData.t) == null) {
                return false;
            }
            SpannableStringBuilder Y2 = d2Var.Y2(false, true, this.V);
            if (Y2 != null && !StringUtils.isNull(Y2.toString())) {
                this.A.setVisibility(0);
                this.A.setOnTouchListener(new c.a.t0.n4.h(Y2));
                this.A.setText(Y2);
                if (!F()) {
                    m.l(this.A, cardPersonDynamicThreadData.f43965f, c.a.t0.y2.a.CAM_X0105, c.a.t0.y2.a.CAM_X0109);
                }
            } else {
                this.A.setVisibility(8);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void Q(View view, List<MediaData> list, int i2, d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048588, this, view, list, i2, d2Var) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                c.a.d.f.p.n.L(this.r.getPageActivity(), c.a.t0.y2.g.plugin_image_viewer_install_error_tips);
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
            for (MediaData mediaData : list) {
                if (mediaData != null && !StringUtils.isNull(mediaData.getPicUrl())) {
                    arrayList.add(mediaData.getPicUrl());
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.D ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = c.a.d.f.m.b.g(d2Var.v1(), -1L);
                    imageUrlData.postId = mediaData.getPostId();
                    concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
                }
            }
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
            bVar.x(arrayList);
            bVar.B(i2);
            bVar.z(d2Var.a0());
            bVar.y(String.valueOf(d2Var.U()));
            bVar.O(d2Var.v1());
            bVar.C(this.D);
            bVar.J(arrayList.size() > 0 ? arrayList.get(0) : "");
            bVar.F(true);
            bVar.w(concurrentHashMap);
            bVar.H(true);
            bVar.N(d2Var);
            bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig v = bVar.v(this.r.getPageActivity());
            v.getIntent().putExtra("from", "other");
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
        }
    }

    public final void R(boolean z) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (constrainImageGroup = this.C) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) constrainImageGroup.getLayoutParams();
        if (z) {
            layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.t0.y2.b.tbds37);
        } else {
            layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.t0.y2.b.tbds20);
        }
        this.C.setLayoutParams(layoutParams);
    }

    @Override // c.a.t0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? c.a.t0.y2.e.card_person_dynamic_thread : invokeV.intValue;
    }

    @Override // c.a.t0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, tbPageContext, i2) == null) {
            if (this.p != i2) {
                SkinManager.setLottieAnimation(this.O, c.a.t0.y2.f.ala_play);
                SkinManager.setBackgroundColor(j(), c.a.t0.y2.a.CAM_X0201);
                SkinManager.setViewTextColor(this.s, c.a.t0.y2.a.CAM_X0105);
                SkinManager.setViewTextColor(this.u, c.a.t0.y2.a.CAM_X0107);
                SkinManager.setViewTextColor(this.v, c.a.t0.y2.a.CAM_X0105);
                SkinManager.setViewTextColor(this.w, c.a.t0.y2.a.CAM_X0109);
                SkinManager.setViewTextColor(this.Q, c.a.t0.y2.a.CAM_X0109);
                SkinManager.setViewTextColor(this.x, c.a.t0.y2.a.CAM_X0109);
                if (this.y != null) {
                    this.y.setImageDrawable(SvgManager.getInstance().getPureDrawable(c.a.t0.y2.c.icon_pure_personalba_more24_svg, c.a.t0.y2.a.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS));
                }
                SkinManager.setViewTextColor(this.A, c.a.t0.y2.a.CAM_X0105);
                SkinManager.setViewTextColor(this.B, c.a.t0.y2.a.CAM_X0106);
                SkinManager.setViewTextColor(this.I, c.a.t0.y2.a.CAM_X0106);
                s sVar = this.z;
                if (sVar != null) {
                    sVar.r();
                }
                this.n.onChangeSkinType();
                this.U.onChangeSkinType();
                SkinManager.setBackgroundColor(this.S, c.a.t0.y2.a.CAM_X0204);
                SkinManager.setBackgroundColor(this.T, c.a.t0.y2.a.CAM_X0205);
                SkinManager.setBackgroundColor(this.I, c.a.t0.y2.a.CAM_X0205);
                OriginalThreadCardView originalThreadCardView = this.R;
                if (originalThreadCardView != null) {
                    originalThreadCardView.onChangeSkinType();
                }
                c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.X);
                d2.v(c.a.t0.y2.a.CAM_X0109);
                d2.A(c.a.t0.y2.g.F_X01);
            }
            this.p = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, view) == null) && view == this.R) {
            H();
        }
    }
}
