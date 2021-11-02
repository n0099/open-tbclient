package b.a.r0.x0.x1;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.l.e.n;
import b.a.q0.s.q.b0;
import b.a.q0.s.q.d2;
import b.a.q0.s.s.a;
import b.a.r0.l3.c0;
import b.a.r0.l3.d0;
import b.a.r0.l3.i;
import b.a.r0.l3.q;
import b.a.r0.x0.a1;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.h1;
import b.a.r0.x0.x0;
import b.a.r0.x0.x2.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.servicearea.ServiceAreaView;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.frs.view.HotRankEntryView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.AdapterLinearLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import tbclient.SignActivityInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class b extends b.a.r0.x0.b3.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A0;
    public View B0;
    public TextView C0;
    public final View D0;
    public final HeadImageView E0;
    public final TextView F0;
    public final View G0;
    public final ImageView H0;
    public final TextView I0;
    public HotRankEntryView J0;
    public List<n> K0;
    public b.a.r0.f0.g L0;
    public int M0;
    public long N0;
    public ScheduledExecutorService O0;
    public boolean P0;
    public boolean Q0;
    public boolean R0;
    public CountDownTimer S0;
    public boolean T0;
    public RelativeLayout o0;
    public TextView p0;
    public TextView q0;
    public String r0;
    public ArrayList<TbImageView> s0;
    public x0 t0;
    public boolean u0;
    public View v0;
    public boolean w0;
    public LinearLayout x0;
    public View y0;
    public View z0;

    /* loaded from: classes5.dex */
    public class a implements x0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26591a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26591a = bVar;
        }

        @Override // b.a.r0.x0.x0
        public void a(d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) {
                l.d(this.f26591a.f25578b, this.f26591a.V, d2Var);
            }
        }
    }

    /* renamed from: b.a.r0.x0.x1.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1304b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b0 f26592e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsViewData f26593f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f26594g;

        public View$OnClickListenerC1304b(b bVar, b0 b0Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, b0Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26594g = bVar;
            this.f26592e = b0Var;
            this.f26593f = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26594g.f25577a == null || b.a.q0.f1.l.b.a(this.f26594g.f25577a.getPageActivity(), this.f26592e.f()) || TextUtils.isEmpty(this.f26592e.e())) {
                return;
            }
            FrsViewData frsViewData = this.f26593f;
            if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(this.f26593f.getForum().getId()) && this.f26593f.getActivityHeadData() != null && !TextUtils.isEmpty(this.f26593f.getActivityHeadData().c())) {
                String id = this.f26593f.getForum().getId();
                String c2 = this.f26593f.getActivityHeadData().c();
                StatisticItem statisticItem = new StatisticItem("c13330");
                statisticItem.param("fid", id);
                statisticItem.param("obj_id", c2);
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem("common_click");
                statisticItem2.param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param("fid", id).param("obj_id", c2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.FIRST_DIR, this.f26593f.getForum().getFirst_class()).param(TiebaStatic.Params.SECOND_DIR, this.f26593f.getForum().getSecond_class());
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().q);
                }
                b.a.r0.k3.c.g().c(this.f26594g.f25578b.getUniqueId(), statisticItem2);
            }
            b.a.r0.x0.x2.h.b(this.f26594g.f25577a, this.f26592e.h(), this.f26592e.e(), this.f26592e.g());
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.f26592e.k(), 1));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26595e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26595e = bVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f26595e.f25577a == null || this.f26595e.f25577a.getPageActivity() == null) {
                return;
            }
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f26595e.f25577a.getPageActivity(), this.f26595e.d0, "exp_acce", 2);
            memberPayActivityConfig.setSceneId("4004001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26596e;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26596e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26596e.f25577a == null || this.f26596e.f25577a.getPageActivity() == null) {
                return;
            }
            b.a.e.e.m.g.d(this.f26596e.L, this.f26596e.f25577a.getPageActivity());
            this.f26596e.f25578b.mSpeedUpTipShowing = false;
            b.a.q0.m.a.p(this.f26596e.f25577a.getPageActivity(), this.f26596e.f25577a.getResources().getString(h1.experion_speed), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26597e;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26597e = bVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 4) {
                    b.a.e.e.m.g.c(this.f26597e.L);
                    this.f26597e.f25578b.mSpeedUpTipShowing = false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f26598a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f26599b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(b bVar, long j, long j2, String str) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Long.valueOf(j), Long.valueOf(j2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26599b = bVar;
            this.f26598a = str;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26599b.E = false;
                if (this.f26599b.D != null) {
                    this.f26599b.D.setVisibility(8);
                }
                if (this.f26599b.P == null || this.f26599b.h()) {
                    return;
                }
                this.f26599b.P.q(this.f26599b.E);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.f26599b.D == null) {
                return;
            }
            this.f26599b.D.setVisibility(0);
            EMTextView eMTextView = this.f26599b.D;
            eMTextView.setText(this.f26598a + (j / 1000) + "s");
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f26600e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f26601f;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f26602e;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26602e = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26602e.f26601f.D == null) {
                    return;
                }
                if (this.f26602e.f26601f.D.getVisibility() == 8) {
                    this.f26602e.f26601f.D.setVisibility(0);
                    this.f26602e.f26601f.D.setText(this.f26602e.f26600e);
                    if (this.f26602e.f26601f.F != null) {
                        b bVar = this.f26602e.f26601f;
                        bVar.S0(bVar.F.activity_msg, this.f26602e.f26601f.F.countdown_time.intValue());
                    }
                } else if (this.f26602e.f26601f.D.getVisibility() == 0) {
                    this.f26602e.f26601f.I0();
                }
            }
        }

        public h(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26601f = bVar;
            this.f26600e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.e.e.m.e.a().post(new a(this));
            }
        }
    }

    public b(FrsFragment frsFragment, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, str, str2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w0 = false;
        this.M0 = -1;
        this.N0 = 1000L;
        this.T0 = false;
        this.s0 = new ArrayList<>();
        this.d0 = i2;
        this.f25579c = new Handler();
        this.f25578b = frsFragment;
        this.f25577a = frsFragment.getPageContext();
        b.a.e.e.p.l.g(frsFragment.getPageContext().getPageActivity(), c1.ds20);
        b.a.e.e.p.l.g(frsFragment.getPageContext().getPageActivity(), c1.ds72);
        b.a.e.e.p.l.g(frsFragment.getPageContext().getPageActivity(), c1.ds150);
        this.R = str;
        this.S = str2;
        View K0 = K0();
        this.f25580d = K0;
        this.o0 = (RelativeLayout) K0.findViewById(e1.container);
        this.u = (RelativeLayout) this.f25580d.findViewById(e1.head_top_bg_container);
        this.v = (LinearGradientView) this.f25580d.findViewById(e1.head_top_gradient_bg);
        TbImageView tbImageView = (TbImageView) this.f25580d.findViewById(e1.head_top_bg_mask);
        this.w = tbImageView;
        tbImageView.setPageId(this.f25578b.getUniqueId());
        this.w.setDefaultBgResource(b1.transparent);
        this.w.setDefaultResource(d1.pic_frs_head_default);
        View findViewById = this.f25580d.findViewById(e1.header_top_cover);
        this.v0 = findViewById;
        b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(findViewById);
        d2.n(h1.J_X11);
        d2.s(a1.Mask_X005);
        TextView textView = (TextView) this.f25580d.findViewById(e1.head_ad_lable_icon_layout);
        this.C0 = textView;
        b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(textView);
        d3.n(h1.J_X01);
        d3.f(b1.CAM_X0602);
        b.a.q0.s.u.c.d(this.C0).v(b1.CAM_X0617);
        this.C0.bringToFront();
        this.x0 = (LinearLayout) this.f25580d.findViewById(e1.layout_banner_container);
        this.y0 = this.f25580d.findViewById(e1.header_round_corner_layout);
        this.z0 = this.f25580d.findViewById(e1.service_and_top_view_layout);
        this.A0 = this.f25580d.findViewById(e1.banner_and_bottom_view_layout);
        this.x = (ServiceAreaView) this.f25580d.findViewById(e1.service_area_view);
        this.y = (FrameLayout) this.f25580d.findViewById(e1.frs_ad_banner);
        this.A = (FrsTopView) this.f25580d.findViewById(e1.frs_topview);
        this.B0 = this.f25580d.findViewById(e1.frs_top_divider_layout);
        this.B = this.f25580d.findViewById(e1.frs_top_divider_line);
        this.C = this.f25580d.findViewById(e1.service_topview_space);
        this.K = (ImageView) this.f25580d.findViewById(e1.speed_icon);
        this.p0 = (TextView) this.f25580d.findViewById(e1.member_image);
        this.q0 = (TextView) this.f25580d.findViewById(e1.post_image);
        this.j = (TextView) this.f25580d.findViewById(e1.level_name);
        this.s = (TextView) this.f25580d.findViewById(e1.level);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f25580d.findViewById(e1.tv_love);
        this.f25584h = tBSpecificationBtn;
        tBSpecificationBtn.setText(frsFragment.getResources().getString(h1.attention));
        this.f25584h.setTextSize(c1.T_X08);
        b.a.q0.s.g0.n.b bVar = new b.a.q0.s.g0.n.b();
        bVar.p(b1.CAM_X0901, b1.CAM_X0105);
        this.f25584h.setConfig(bVar);
        TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.f25580d.findViewById(e1.tv_sign);
        this.f25585i = tBSpecificationBtn2;
        tBSpecificationBtn2.setTextSize(c1.T_X08);
        b.a.q0.s.g0.n.b bVar2 = new b.a.q0.s.g0.n.b();
        bVar2.t(b1.CAM_X0105);
        bVar2.g(UtilHelper.getDimenPixelSize(c1.tbds39));
        bVar2.i(d1.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f25585i.setConfig(bVar2);
        this.f25585i.setText(frsFragment.getResources().getString(h1.sign));
        this.k = (ImageView) this.f25580d.findViewById(e1.love_level_top);
        this.l = (ImageView) this.f25580d.findViewById(e1.love_level_bg);
        this.f25581e = (TextView) this.f25580d.findViewById(e1.member_num_text);
        this.f25582f = (TextView) this.f25580d.findViewById(e1.post_num_text);
        this.n = (TextView) this.f25580d.findViewById(e1.forum_name);
        this.o = (TextView) this.f25580d.findViewById(e1.brand_label);
        BarImageView barImageView = (BarImageView) this.f25580d.findViewById(e1.frs_image);
        this.M = barImageView;
        barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.M.setPageId(this.f25578b.getUniqueId());
        this.M.setContentDescription(frsFragment.getResources().getString(h1.bar_header));
        this.M.setStrokeWith(b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), c1.tbds4));
        this.M.setShowOval(true);
        this.M.setPlaceHolder(1);
        this.r = this.f25580d.findViewById(e1.level_container);
        this.q = (RelativeLayout) this.f25580d.findViewById(e1.has_focused_container);
        this.p = (RelativeLayout) this.f25580d.findViewById(e1.not_focused_container);
        this.t = (RelativeLayout) this.f25580d.findViewById(e1.head_content_container);
        this.D0 = this.f25580d.findViewById(e1.frs_manager_info_layout);
        this.F0 = (TextView) this.f25580d.findViewById(e1.frs_manager_name);
        HeadImageView headImageView = (HeadImageView) this.f25580d.findViewById(e1.frs_manager_portrait);
        this.E0 = headImageView;
        headImageView.setIsRound(true);
        this.E0.setDrawBorder(true);
        this.E0.setDefaultResource(d1.icon_default_avatar100);
        this.E0.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.G0 = this.f25580d.findViewById(e1.frs_manager_application_layout);
        this.H0 = (ImageView) this.f25580d.findViewById(e1.frs_manager_application_icon);
        this.I0 = (TextView) this.f25580d.findViewById(e1.frs_manager_application_desc);
        WebPManager.setPureDrawable(this.H0, d1.icon_mask_frs_apply14, b1.CAM_X0101, null);
        this.H = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(f1.frs_show_experience, (ViewGroup) null);
        this.m = LayoutInflater.from(this.f25578b.getPageContext().getPageActivity()).inflate(f1.frs_header_extra_entelechy, (ViewGroup) null);
        this.J0 = (HotRankEntryView) this.f25580d.findViewById(e1.frs_hot_rank_entry);
        this.m.setVisibility(8);
        new b.a.r0.x0.x2.b(this.f25577a);
        this.D = (EMTextView) this.f25580d.findViewById(e1.count_down);
    }

    @Override // b.a.r0.x0.b3.b
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.M.setOnClickListener(onClickListener);
            this.n.setOnClickListener(onClickListener);
            this.f25585i.setOnClickListener(onClickListener);
            this.f25584h.setOnClickListener(onClickListener);
            this.r.setOnClickListener(onClickListener);
            HotRankEntryView hotRankEntryView = this.J0;
            if (hotRankEntryView != null) {
                hotRankEntryView.setOnClickListener(onClickListener);
            }
            View view = this.D0;
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
            View view2 = this.G0;
            if (view2 != null) {
                view2.setOnClickListener(onClickListener);
            }
        }
    }

    @Override // b.a.r0.x0.b3.b
    public void B(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumData, frsViewData) == null) || forumData == null) {
            return;
        }
        this.R = forumData.getName();
        this.S = forumData.getId();
        this.Y = forumData.getMember_num();
        this.Z = forumData.getPost_num();
        forumData.getTag_color();
        this.r0 = forumData.getImage_url();
        this.T = forumData.getLevelName();
        this.X = forumData.getUser_level();
        if (forumData.getSignData() != null) {
            int i2 = forumData.getSignData().count_sign_num;
            this.a0 = forumData.getSignData().miss_sign_num;
        }
        this.b0 = forumData.getCurScore();
        this.c0 = forumData.getLevelupScore();
        this.O = forumData.getBadgeData();
        this.U = forumData.getAccelerateContent();
        this.i0 = forumData.isBrandForum;
        this.V = frsViewData;
        if (!StringUtils.isNull(this.S) && !StringUtils.isNull(this.R)) {
            this.f25580d.setVisibility(0);
        } else {
            this.f25580d.setVisibility(8);
        }
        FrsViewData frsViewData2 = this.V;
        if (frsViewData2 != null && frsViewData2.getHotUserRankData() != null && this.V.getHotUserRankData().hot_user != null && this.V.getHotUserRankData().hot_user.size() >= 3) {
            this.x.setHasHotRankList(true);
        } else {
            this.x.setHasHotRankList(false);
        }
        FrsViewData frsViewData3 = this.V;
        if ((frsViewData3 != null && frsViewData3.serviceAreaData != null && !b.a.q0.g1.b.c.d()) || this.x.isHasHotRankList()) {
            this.x.setVisibility(0);
            this.z0.setVisibility(0);
            ServiceAreaView serviceAreaView = this.x;
            FrsViewData frsViewData4 = this.V;
            serviceAreaView.setData(frsViewData4.serviceAreaData, frsViewData4);
        } else {
            this.x.setVisibility(8);
            this.z0.setVisibility(8);
        }
        this.W = new d2();
        X0();
        R0();
        if (this.V.getActivityHeadData() != null && this.V.getActivityHeadData().a() != null) {
            if (a1() && this.V.getActivityHeadData().a().f13266h) {
                this.C0.setVisibility(0);
            } else {
                this.C0.setVisibility(8);
            }
        }
        Y0(forumData);
        if (frsViewData != null) {
            this.F = frsViewData.mSignActivityInfo;
            I0();
        }
    }

    public final void F0(boolean z, boolean z2) {
        RelativeLayout relativeLayout;
        int g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (relativeLayout = this.u) == null || relativeLayout.getLayoutParams() == null) {
            return;
        }
        if (this.J0.getVisibility() == 0) {
            g2 = b.a.e.e.p.l.g(this.f25577a.getPageActivity(), c1.tbds704);
            ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = b.a.e.e.p.l.g(this.f25577a.getPageActivity(), c1.tbds384);
            ((RelativeLayout.LayoutParams) this.J0.getLayoutParams()).topMargin = (b.a.e.e.p.l.g(this.f25577a.getPageActivity(), c1.tbds226) + b.a.e.e.p.l.r(this.f25577a.getPageActivity())) - b.a.e.e.p.l.g(this.f25577a.getPageActivity(), c1.tbds72);
        } else {
            g2 = b.a.e.e.p.l.g(this.f25577a.getPageActivity(), c1.tbds600);
        }
        if (!z && !z2 && !this.u0) {
            g2 -= b.a.e.e.p.l.g(this.f25577a.getPageActivity(), c1.tbds80);
        } else if (this.u0) {
            int g3 = b.a.e.e.p.l.g(this.f25577a.getPageActivity(), c1.tbds782);
            int N0 = N0(z, z2);
            g2 = g3 + N0;
            ((RelativeLayout.LayoutParams) this.w.getLayoutParams()).bottomMargin = N0;
            ((RelativeLayout.LayoutParams) this.v0.getLayoutParams()).bottomMargin = N0;
            if (N0 != 0) {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = b.a.e.e.p.l.g(this.f25577a.getPageActivity(), c1.tbds782) - b.a.e.e.p.l.g(this.f25577a.getPageActivity(), c1.tbds282);
            } else {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = b.a.e.e.p.l.g(this.f25577a.getPageActivity(), c1.tbds493);
            }
        }
        ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
        if (layoutParams.height != g2) {
            layoutParams.height = g2;
            this.u.setLayoutParams(layoutParams);
        }
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean O0 = O0();
            boolean P0 = P0();
            if (!TextUtils.isEmpty(this.R)) {
                b.a.r0.x0.w2.e c2 = b.a.r0.x0.w2.d.d().c(this.R);
                if (c2 == null) {
                    c2 = new b.a.r0.x0.w2.e(this.w0, O0);
                } else {
                    c2.d(this.w0);
                    c2.e(O0);
                }
                b.a.r0.x0.w2.d.d().e(this.R, c2);
            }
            H0(O0, P0);
            F0(O0, P0);
        }
    }

    public final void H0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f25578b.getTabController() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.x0.getLayoutParams();
        if (!z && !z2) {
            this.x0.setVisibility(0);
            this.z0.setVisibility(8);
            this.A0.setVisibility(8);
            layoutParams.topMargin = b.a.e.e.p.l.g(this.f25577a.getPageActivity(), c1.tbds50);
        } else {
            this.x0.setVisibility(0);
            this.z0.setVisibility(0);
            layoutParams.topMargin = b.a.e.e.p.l.g(this.f25577a.getPageActivity(), c1.tbds55);
        }
        this.f25578b.getTabController().t(z, z2);
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.F == null) {
            return;
        }
        CountDownTimer countDownTimer = this.S0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.S0.onFinish();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        this.P0 = ((long) (this.F.activity_time.intValue() + this.F.activity_duration.intValue())) - currentTimeMillis < 0;
        this.Q0 = ((long) this.F.activity_time.intValue()) - currentTimeMillis <= 0;
        this.R0 = ((long) (this.F.activity_time.intValue() - this.F.countdown_time.intValue())) - currentTimeMillis <= 0;
        boolean z = this.P0;
        if (z) {
            this.D.setVisibility(8);
            return;
        }
        if (this.Q0 && !z) {
            b1(this.F.activity_msg, 1000 * ((this.F.activity_time.intValue() + this.F.activity_duration.intValue()) - currentTimeMillis), this.N0);
        }
        if (!this.Q0 && this.R0) {
            this.D.setVisibility(0);
            this.D.setText(this.F.countdown_msg);
            SignActivityInfo signActivityInfo = this.F;
            S0(signActivityInfo.activity_msg, signActivityInfo.activity_time.intValue() - currentTimeMillis);
        }
        if (this.R0) {
            return;
        }
        SignActivityInfo signActivityInfo2 = this.F;
        S0(signActivityInfo2.countdown_msg, (signActivityInfo2.activity_time.intValue() - this.F.countdown_time.intValue()) - currentTimeMillis);
    }

    public final void J0(i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, iVar) == null) || iVar == null || this.V == null || this.T0) {
            return;
        }
        this.T0 = true;
        StatisticItem statisticItem = new StatisticItem("common_exp");
        statisticItem.param("page_type", "a006");
        statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
        int i2 = 6;
        if (iVar.getType() != 1) {
            if (iVar.getType() == 2) {
                i2 = 7;
            } else if (iVar.getType() == 3) {
                i2 = 8;
            }
        }
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
        statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
        statisticItem.param("obj_id", iVar.b());
        ForumData forum = this.V.getForum();
        if (forum != null) {
            statisticItem.param("fid", forum.getId());
            statisticItem.param(TiebaStatic.Params.FIRST_DIR, forum.getFirst_class());
            statisticItem.param(TiebaStatic.Params.SECOND_DIR, forum.getSecond_class());
        }
        if (iVar.getType() == 1) {
            statisticItem.param("tid", iVar.k());
            statisticItem.param("thread_type", iVar.l());
        }
        TiebaStatic.log(statisticItem);
    }

    public View K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? LayoutInflater.from(this.f25578b.getPageContext().getPageActivity()).inflate(f1.frs_normal_header, (ViewGroup) null) : (View) invokeV.objValue;
    }

    public final int[] L0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? i2 <= 3 ? new int[]{-8331843, -10499102} : i2 <= 9 ? new int[]{-10499102, -154262} : i2 <= 15 ? new int[]{-154262, -148180} : new int[]{-148180, -100818} : (int[]) invokeI.objValue;
    }

    @Override // b.a.r0.x0.b3.b
    @SuppressLint({"ResourceAsColor"})
    public void M(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, view, z) == null) {
            if (this.d0 == 0 && TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
                if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) == null || z) {
                    return;
                }
                View inflate = LayoutInflater.from(this.f25577a.getContext()).inflate(f1.no_mem_dialog, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(e1.cur_experience_mem);
                TextView textView2 = (TextView) inflate.findViewById(e1.levelup_experience_mem);
                TextView textView3 = (TextView) inflate.findViewById(e1.speed_tip);
                SkinManager.setViewTextColor((TextView) inflate.findViewById(e1.experience_txt), b1.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView, b1.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView2, b1.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView3, b1.CAM_X0105, 1);
                b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f25577a.getPageActivity());
                aVar.setContentView(inflate);
                C(textView, textView2);
                if (!TextUtils.isEmpty(this.U) && !TextUtils.isEmpty(this.U.trim())) {
                    textView3.setVisibility(0);
                    textView3.setText(this.U);
                } else {
                    textView3.setVisibility(8);
                }
                aVar.setButtonTextColor(b1.CAM_X0305);
                U0(aVar);
                V0(aVar);
                aVar.create(this.f25577a);
                aVar.show();
                return;
            }
            this.f25579c.removeCallbacks(this.l0);
            if (this.G == null) {
                PopupWindow popupWindow = new PopupWindow(this.f25577a.getPageActivity());
                this.G = popupWindow;
                popupWindow.setContentView(this.H);
                this.G.setBackgroundDrawable(new BitmapDrawable());
                this.G.setOutsideTouchable(true);
                this.G.setFocusable(true);
                this.G.setWidth(this.f25577a.getResources().getDimensionPixelSize(c1.ds228));
                this.G.setHeight(this.f25577a.getResources().getDimensionPixelSize(c1.ds100));
            }
            this.I = (TextView) this.H.findViewById(e1.cur_experience);
            this.J = (TextView) this.H.findViewById(e1.levelup_experience);
            SkinManager.setBackgroundResource(this.H.findViewById(e1.experience_container), d1.icon_frs_experience_number);
            SkinManager.setViewTextColor((TextView) this.H.findViewById(e1.experience), b1.CAM_X0111, 1);
            SkinManager.setViewTextColor(this.I, b1.common_color_10047, 1);
            SkinManager.setViewTextColor(this.J, b1.CAM_X0111, 1);
            C(this.I, this.J);
            if (this.G.isShowing()) {
                b.a.e.e.m.g.d(this.G, this.f25577a.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.G.getHeight() <= 50) {
                b.a.e.e.m.g.d(this.G, this.f25577a.getPageActivity());
                return;
            }
            PopupWindow popupWindow2 = this.G;
            b.a.e.e.m.g.m(popupWindow2, this.f25580d, 0, iArr[0], iArr[1] - popupWindow2.getHeight());
            this.G.update();
            this.f25579c.postDelayed(this.l0, 2000L);
        }
    }

    public final LinearGradientView M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            FrsFragment frsFragment = this.f25578b;
            if (frsFragment != null && frsFragment.getTabController() != null) {
                View B = this.f25578b.getTabController().B();
                if (B instanceof LinearGradientView) {
                    return (LinearGradientView) B;
                }
            }
            return null;
        }
        return (LinearGradientView) invokeV.objValue;
    }

    @Override // b.a.r0.x0.b3.b
    public void N() {
        FrsViewData frsViewData;
        String string;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.M0 == -1 || (frsViewData = this.V) == null || frsViewData.forumRule == null || frsViewData.getUserData() == null || this.A == null) {
            return;
        }
        if (this.V.getUserData().getIs_manager() == 1) {
            if (this.V.forumRule.has_forum_rule.intValue() == 1 || this.V.forumRule.audit_status.intValue() != 0) {
                return;
            }
            string = this.f25577a.getString(h1.frs_top_forum_rules_setting);
            str = "key_forum_rule_first_show_frs_manager";
        } else {
            string = this.f25577a.getString(h1.frs_top_forum_rules_setting_has_pass);
            str = "key_forum_rule_first_show_frs";
        }
        View view = null;
        if (this.A.getmTopViews() != null && this.A.getmTopViews().size() > 0 && (this.A.getmTopViews().get(0) instanceof AdapterLinearLayout)) {
            AdapterLinearLayout adapterLinearLayout = (AdapterLinearLayout) this.A.getmTopViews().get(0);
            if (this.M0 < adapterLinearLayout.getChildCount()) {
                view = adapterLinearLayout.getChildAt(this.M0);
            }
        }
        if (this.L0 != null || view == null) {
            return;
        }
        b.a.r0.f0.g gVar = new b.a.r0.f0.g(this.f25577a, view);
        this.L0 = gVar;
        gVar.g0(d1.bg_tip_blue_up_left);
        this.L0.O(16);
        this.L0.U(true);
        this.L0.j0(UtilHelper.getDimenPixelSize(c1.tbds128));
        this.L0.k0(UtilHelper.getDimenPixelSize(c1.tbds_10));
        this.L0.h0(true);
        this.L0.N(4000);
        if (this.L0.J() || this.f25578b.getIsRefresh()) {
            return;
        }
        this.L0.m0(string, str);
    }

    public final int N0(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        List<n> list;
        List<d0> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i2 = 0;
            if (z2) {
                c0 c0Var = this.V.serviceAreaData;
                if (c0Var != null && (list2 = c0Var.f20528b) != null && list2.size() == 1) {
                    i2 = 0 + b.a.e.e.p.l.g(this.f25577a.getPageActivity(), c1.tbds83);
                } else {
                    i2 = 0 + b.a.e.e.p.l.g(this.f25577a.getPageActivity(), c1.tbds84);
                }
            }
            if (z && (list = this.K0) != null) {
                i2 += Math.min(list.size(), 2) * b.a.e.e.p.l.g(this.f25577a.getPageActivity(), c1.tbds83);
            }
            if (this.y.getVisibility() == 0) {
                i2 += b.a.e.e.p.l.g(this.f25577a.getPageActivity(), c1.tbds231);
            }
            return (z2 || z || this.y.getVisibility() == 0) ? i2 + b.a.e.e.p.l.g(this.f25577a.getPageActivity(), c1.tbds45) : i2;
        }
        return invokeCommon.intValue;
    }

    @Override // b.a.r0.x0.b3.b
    public void O() {
        View contentView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            PopupWindow popupWindow = this.L;
            if (popupWindow == null) {
                this.L = new PopupWindow(this.f25577a.getPageActivity());
                contentView = LayoutInflater.from(this.f25577a.getContext()).inflate(f1.speed_tip, (ViewGroup) null);
                this.L.setContentView(contentView);
                contentView.setOnClickListener(new e(this));
                this.L.setWidth(this.f25577a.getResources().getDimensionPixelSize(c1.ds300));
                this.L.setHeight(this.f25577a.getResources().getDimensionPixelSize(c1.ds88));
                this.L.setBackgroundDrawable(new BitmapDrawable());
                this.L.setOutsideTouchable(true);
                this.L.setTouchInterceptor(new f(this));
            } else {
                contentView = popupWindow.getContentView();
            }
            SkinManager.setViewTextColor((TextView) contentView.findViewById(e1.mem), b1.CAM_X0101, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(e1.speed), b1.CAM_X0305, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(e1.tequan), b1.CAM_X0101, 1);
            int[] iArr = new int[2];
            this.K.getLocationOnScreen(iArr);
            PopupWindow popupWindow2 = this.L;
            b.a.e.e.m.g.m(popupWindow2, this.f25580d, 0, (iArr[0] - (popupWindow2.getWidth() / 2)) + (this.K.getWidth() / 2), iArr[1] + this.K.getWidth());
            this.L.update();
        }
    }

    public final boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            FrsTopView frsTopView = this.A;
            return frsTopView != null && frsTopView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ServiceAreaView serviceAreaView = this.x;
            return serviceAreaView != null && serviceAreaView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.x0.b3.b
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    public final void Q0(int i2) {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        ThemeElement themeElement2;
        ThemeElement themeElement3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (frsViewData = this.V) == null || (forum = frsViewData.getForum()) == null || (themeColorInfo = forum.getThemeColorInfo()) == null || (themeElement = themeColorInfo.day) == null || (themeElement2 = themeColorInfo.night) == null || (themeElement3 = themeColorInfo.dark) == null) {
            return;
        }
        if (i2 == 4) {
            themeElement = themeElement3;
        } else if (i2 == 1) {
            themeElement = themeElement2;
        }
        if (!this.u0) {
            LinearGradientView M0 = M0();
            LinearGradientView linearGradientView = this.v;
            if (linearGradientView != null && M0 != null) {
                ThemeElement themeElement4 = themeColorInfo.day;
                String str = themeElement4.light_color;
                String str2 = themeElement4.dark_color;
                ThemeElement themeElement5 = themeColorInfo.night;
                String str3 = themeElement5.light_color;
                String str4 = themeElement5.dark_color;
                ThemeElement themeElement6 = themeColorInfo.dark;
                linearGradientView.setGradientColor(str, str2, str3, str4, themeElement6.light_color, themeElement6.dark_color);
            }
            TbImageView tbImageView = this.w;
            if (tbImageView != null) {
                tbImageView.startLoad(themeElement.pattern_image, 10, false);
            }
        }
        ServiceAreaView serviceAreaView = this.x;
        if (serviceAreaView != null) {
            serviceAreaView.setThemeFontColor(b.a.r0.q1.o.k.b.b(themeElement.common_color));
        }
        if (this.A != null) {
            this.A.setUrlAndColor(forum.getTopIcon(), b.a.r0.q1.o.k.b.b(themeElement.common_color));
        }
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TextView textView = this.f25581e;
            if (textView != null) {
                textView.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.Y));
            }
            TextView textView2 = this.f25582f;
            if (textView2 != null) {
                textView2.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.Z));
            }
            ArrayList<b.a.q0.s.q.l> arrayList = this.O;
            if (arrayList != null && arrayList.size() > 0) {
                this.R = UtilHelper.getFixedText(this.R, 7);
            } else if (this.i0) {
                this.R = UtilHelper.getFixedText(this.R, 6);
            }
            String str = this.R + this.f25577a.getString(h1.forum);
            TextView textView3 = this.f25583g;
            if (textView3 != null) {
                textView3.setText(str);
            }
            TextView textView4 = this.n;
            if (textView4 != null) {
                textView4.setText(str);
            }
            T0();
            boolean a1 = a1();
            this.u0 = a1;
            if (a1) {
                this.v.setVisibility(8);
                this.v0.setVisibility(0);
            } else {
                this.v0.setVisibility(8);
                this.v.setVisibility(0);
                this.w.setOnClickListener(null);
            }
            x();
            Q0(TbadkCoreApplication.getInst().getSkinType());
            G0();
        }
    }

    @Override // b.a.r0.x0.b3.b
    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.d0 != 0) {
                SkinManager.setImageResource(this.K, d1.icon_sml_speed_orange);
            } else {
                SkinManager.setImageResource(this.K, d1.icon_sml_speed_gray);
            }
        }
    }

    public final void S0(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048596, this, str, j) == null) {
            this.E = false;
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.O0 = newScheduledThreadPool;
            newScheduledThreadPool.schedule(new h(this, str), j, TimeUnit.SECONDS);
        }
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.M.startLoad(this.r0, 10, false);
        }
    }

    public void U0(b.a.q0.s.s.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) {
            aVar.setNegativeButton(h1.cancel, new c(this));
        }
    }

    public void V0(b.a.q0.s.s.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) {
            aVar.setPositiveButton(h1.open_now, new d(this));
        }
    }

    public void W0() {
        b.a.r0.x0.y2.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (fVar = this.Q) == null) {
            return;
        }
        fVar.m();
    }

    public void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.r0);
            this.W.E0().add(mediaData);
        }
    }

    public final void Y0(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, forumData) == null) {
            if (forumData.getManagers() != null && forumData.getManagers().size() > 0) {
                String str = forumData.getManagers().get(0).show_name;
                if (TextUtils.isEmpty(str)) {
                    str = forumData.getManagers().get(0).name;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.F0.setText(str);
                    this.E0.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                    this.D0.setVisibility(0);
                } else {
                    this.D0.setVisibility(8);
                }
                if (this.G0.getVisibility() == 0) {
                    this.G0.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.D0.getVisibility() == 0) {
                this.D0.setVisibility(8);
            }
            if (this.G0.getVisibility() == 8) {
                this.G0.setVisibility(0);
            }
        }
    }

    public final void Z0(List<n> list, i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048603, this, list, iVar) == null) || this.A == null) {
            return;
        }
        this.K0 = list;
        if (iVar != null) {
            this.z = new b.a.r0.x0.q1.g(this.f25577a.getPageActivity());
            this.y.setVisibility(0);
            this.y.addView(this.z.e());
            FrsViewData frsViewData = this.V;
            this.z.d(frsViewData != null ? frsViewData.getForum() : null, iVar);
            J0(iVar);
        } else {
            this.y.setVisibility(8);
        }
        FrsFragment frsFragment = this.f25578b;
        if (frsFragment != null && frsFragment.isTopThreadListShow()) {
            this.A.setVisibility(0);
            this.A.setFragmentUniqueId(this.f25578b.getUniqueId());
            FrsViewData frsViewData2 = this.V;
            ForumData forum = frsViewData2 != null ? frsViewData2.getForum() : null;
            FrsViewData frsViewData3 = this.V;
            this.A.setForum(this.S, this.R, forum, frsViewData3 != null ? frsViewData3.getUserData() : null, this.f25578b.getFrom());
            if (list.size() > 0 && (list.get(0) instanceof q)) {
                this.M0 = 0;
            } else if (list.size() > 1 && (list.get(1) instanceof q)) {
                this.M0 = 1;
            } else {
                this.M0 = -1;
            }
            this.A.setDatas(list, iVar);
            if (this.t0 == null) {
                this.t0 = new a(this);
            }
            this.A.setStatListener(this.t0);
            return;
        }
        this.A.setVisibility(8);
    }

    public final boolean a1() {
        InterceptResult invokeV;
        b0 b0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            FrsViewData frsViewData = this.V;
            if (frsViewData == null) {
                return false;
            }
            if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().a())) {
                b0Var = new b0();
                b0Var.o("");
                b0Var.n(frsViewData.getStar().a());
            } else {
                b0Var = (frsViewData.getActivityHeadData() == null || ListUtils.getCount(frsViewData.getActivityHeadData().b()) < 1) ? null : frsViewData.getActivityHeadData().b().get(0);
            }
            if (b0Var != null) {
                if (this.w != null) {
                    if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().c())) {
                        StatisticItem statisticItem = new StatisticItem("c13326");
                        statisticItem.param("fid", frsViewData.getForum().getId());
                        statisticItem.param("obj_id", frsViewData.getActivityHeadData().c());
                        TiebaStatic.log(statisticItem);
                        StatisticItem statisticItem2 = new StatisticItem("common_exp");
                        statisticItem2.param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("fid", frsViewData.getForum().getId()).param("obj_id", frsViewData.getActivityHeadData().c()).param(TiebaStatic.Params.OBJ_AD_LOCATE, 1).param(TiebaStatic.Params.FIRST_DIR, frsViewData.getForum().getFirst_class()).param(TiebaStatic.Params.SECOND_DIR, frsViewData.getForum().getSecond_class());
                        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                            statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().q);
                        }
                        b.a.r0.k3.c.g().d(this.f25578b.getUniqueId(), b.a.r0.k3.a.c("", frsViewData.getActivityHeadData().c(), "", null), statisticItem2);
                    }
                    this.w.startLoad(b0Var.d(), 10, false);
                    this.w.setOnClickListener(new View$OnClickListenerC1304b(this, b0Var, frsViewData));
                }
                ThirdStatisticHelper.sendReq((String) ListUtils.getItem(b0Var.k(), 0));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.x0.b3.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.o.setVisibility(0);
        }
    }

    public final void b1(String str, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.E = true;
            this.S0 = new g(this, j, j2, str).start();
            if (this.P == null || h()) {
                return;
            }
            this.P.q(this.E);
        }
    }

    @Override // b.a.r0.x0.b3.b
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.f25577a.getLayoutMode().k(i2 == 1);
            this.f25577a.getLayoutMode().j(this.f25580d);
            this.f25577a.getLayoutMode().j(this.H);
            this.f25577a.getLayoutMode().j(this.m);
            SkinManager.setBackgroundResource(this.k, d1.frs_exp_progress);
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.y0);
            d2.m(1);
            d2.n(h1.J_X14);
            d2.f(b1.CAM_X0204);
            SkinManager.setBackgroundColor(this.z0, b1.CAM_X0204);
            SkinManager.setBackgroundColor(this.A0, b1.CAM_X0204);
            SkinManager.setBackgroundColor(this.A, b1.CAM_X0204);
            SkinManager.setBackgroundColor(this.B, b1.CAM_X0624);
            SkinManager.setBackgroundColor(this.B0, b1.CAM_X0201);
            SkinManager.setBackgroundColor(this.l, b1.CAM_X0101);
            SkinManager.setBackgroundColor(this.t, b1.black_alpha0);
            SkinManager.setBackgroundColor(this.o0, b1.CAM_X0204);
            SkinManager.setViewTextColor(this.n, b1.CAM_X0101);
            SkinManager.setViewTextColor(this.s, b1.CAM_X0101);
            SkinManager.setViewTextColor(this.j, b1.CAM_X0101);
            SkinManager.setViewTextColor(this.p0, b1.CAM_X0101);
            SkinManager.setViewTextColor(this.f25581e, b1.CAM_X0101);
            SkinManager.setViewTextColor(this.q0, b1.CAM_X0101);
            SkinManager.setViewTextColor(this.f25582f, b1.CAM_X0101);
            SkinManager.setViewTextColor(this.F0, b1.CAM_X0101);
            SkinManager.setViewTextColor(this.I0, b1.CAM_X0101);
            SkinManager.setViewTextColor(this.f25582f, b1.CAM_X0101);
            b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(this.D);
            d3.A(h1.F_X01);
            d3.v(b1.CAM_X0101);
            BarImageView barImageView = this.M;
            if (barImageView != null) {
                barImageView.setBorderWidth(b.a.e.e.p.l.g(this.f25577a.getPageActivity(), c1.tbds1));
                this.M.setBorderColor(SkinManager.getColor(b1.CAM_X0603));
                this.M.setStrokeColorResId(b1.CAM_X0201);
                this.M.setPlaceHolder(1);
                this.M.invalidate();
            }
            HeadImageView headImageView = this.E0;
            if (headImageView != null) {
                headImageView.invalidate();
            }
            UserIconBox userIconBox = this.N;
            if (userIconBox != null) {
                userIconBox.onChangeSkin(i2);
            }
            LinearGradientView linearGradientView = this.v;
            if (linearGradientView != null) {
                linearGradientView.changeSkinType(i2);
            }
            Iterator<TbImageView> it = this.s0.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
            S();
            F(this.g0 ? 1 : 0);
            W0();
            Q0(i2);
            F0(O0(), P0());
            ServiceAreaView serviceAreaView = this.x;
            if (serviceAreaView != null) {
                serviceAreaView.onChangeSkinType(i2);
            }
            FrsTopView frsTopView = this.A;
            if (frsTopView != null) {
                frsTopView.onChangeSkinType(i2);
            }
            b.a.r0.x0.q1.g gVar = this.z;
            if (gVar != null) {
                gVar.g(i2);
            }
            HotRankEntryView hotRankEntryView = this.J0;
            if (hotRankEntryView != null) {
                hotRankEntryView.onChangeSkinType(i2);
            }
        }
    }

    @Override // b.a.r0.x0.b3.b
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            SignActivityInfo signActivityInfo = this.F;
            if (signActivityInfo != null) {
                return String.valueOf(signActivityInfo.activity_id);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.r0.x0.b3.b
    public SignActivityInfo j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.F : (SignActivityInfo) invokeV.objValue;
    }

    @Override // b.a.r0.x0.b3.b
    public void m() {
        b.a.r0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (gVar = this.L0) == null) {
            return;
        }
        gVar.I();
        this.M0 = -1;
    }

    @Override // b.a.r0.x0.b3.b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.E : invokeV.booleanValue;
    }

    @Override // b.a.r0.x0.b3.b
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.r();
            Handler handler = this.f25579c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            PopupWindow popupWindow = this.L;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.L.dismiss();
            }
            m();
            b.a.r0.x0.q1.g gVar = this.z;
            if (gVar != null) {
                gVar.h();
            }
            CountDownTimer countDownTimer = this.S0;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.S0 = null;
            }
        }
    }

    @Override // b.a.r0.x0.b3.b
    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            super.s(z);
            b.a.r0.x0.q1.g gVar = this.z;
            if (gVar != null) {
                gVar.i(z);
            }
        }
    }

    @Override // b.a.r0.x0.b3.b
    public void v(boolean z, float f2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) {
            this.h0 = z;
            Bitmap cashBitmap = BitmapHelper.getCashBitmap(d1.bg_frs_signin_bar_down);
            if (cashBitmap == null || this.j == null || this.k == null || this.s == null || cashBitmap.getWidth() <= 0) {
                return;
            }
            if (this.h0) {
                this.j.setText(h1.level_up);
                if (f2 >= 1.0f) {
                    i2 = this.X;
                } else {
                    i2 = this.X + 1;
                }
                FrsViewData frsViewData = this.f25578b.getFrsViewData();
                if (frsViewData != null && frsViewData.getForum() != null) {
                    frsViewData.getForum().setUser_level(i2);
                }
                this.s.setText(this.f25577a.getResources().getString(h1.lv_num, Integer.valueOf(i2)));
            } else {
                this.j.setText(this.T);
                this.s.setText(this.f25577a.getResources().getString(h1.lv_num, Integer.valueOf(this.X)));
            }
            this.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, L0(this.X)));
            if (!this.h0) {
                R(this.k, this.j0, f2);
            } else if (f2 >= 1.0f) {
                R(this.k, this.j0, f2);
            } else {
                P(this.k, this.j0, f2);
            }
            this.j0 = f2;
        }
    }

    @Override // b.a.r0.x0.b3.b
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.A.refrshRuleStatus(this.M0);
        }
    }

    @Override // b.a.r0.x0.b3.b
    public void x() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || this.f25578b == null || (frsViewData = this.V) == null) {
            return;
        }
        List<n> showTopThreadList = frsViewData.getShowTopThreadList();
        this.w0 = showTopThreadList.size() > 2;
        Z0(showTopThreadList, this.V.getBusinessPromot());
    }

    @Override // b.a.r0.x0.b3.b
    public void y() {
        b.a.r0.x0.y2.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (gVar = this.P) == null) {
            return;
        }
        gVar.o(this.a0);
    }

    @Override // b.a.r0.x0.b3.b
    public void z() {
        b.a.r0.x0.y2.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || (gVar = this.P) == null) {
            return;
        }
        gVar.q(this.E);
    }
}
