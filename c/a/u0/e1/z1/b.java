package c.a.u0.e1.z1;

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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.t0.s.r.b0;
import c.a.t0.s.r.e2;
import c.a.t0.s.r.l;
import c.a.t0.s.t.a;
import c.a.u0.e1.b3.k;
import c.a.u0.e1.b3.q;
import c.a.u0.e1.c1;
import c.a.u0.e1.d1;
import c.a.u0.e1.e1;
import c.a.u0.e1.f1;
import c.a.u0.e1.g1;
import c.a.u0.e1.i1;
import c.a.u0.e1.y0;
import c.a.u0.z3.d0;
import c.a.u0.z3.e0;
import c.a.u0.z3.i;
import c.a.u0.z3.r;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
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
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.servicearea.ServiceAreaView;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.frs.view.HotRankEntryView;
import com.baidu.tieba.frs.voiceroom.view.FrsVoiceRoomListLayout;
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
/* loaded from: classes8.dex */
public class b extends c.a.u0.e1.f3.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A0;
    public View B0;
    public View C0;
    public View D0;
    public TextView E0;
    public final View F0;
    public final HeadImageView G0;
    public final TextView H0;
    public final View I0;
    public final ImageView J0;
    public final TextView K0;
    public HotRankEntryView L0;
    public List<n> M0;
    public c.a.u0.k0.g N0;
    public int O0;
    public long P0;
    public ScheduledExecutorService Q0;
    public boolean R0;
    public boolean S0;
    public boolean T0;
    public CountDownTimer U0;
    public boolean V0;
    @NonNull
    public final c.a.u0.e1.v2.b.c W0;
    @NonNull
    public final c.a.u0.e1.v2.c.c X0;
    @Nullable
    public BdTypeRecyclerView Y0;
    public RelativeLayout p0;
    public TextView q0;
    public TextView r0;
    public String s0;
    public ArrayList<TbImageView> t0;
    public y0 u0;
    public boolean v0;
    public View w0;
    public View x0;
    public boolean y0;
    public LinearLayout z0;

    /* loaded from: classes8.dex */
    public class a implements y0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        @Override // c.a.u0.e1.y0
        public void a(e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, e2Var) == null) {
                q.d(this.a.f16552b, this.a.W, e2Var);
            }
        }
    }

    /* renamed from: c.a.u0.e1.z1.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1086b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b0 f17361e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsViewData f17362f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f17363g;

        public View$OnClickListenerC1086b(b bVar, b0 b0Var, FrsViewData frsViewData) {
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
            this.f17363g = bVar;
            this.f17361e = b0Var;
            this.f17362f = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17363g.a == null || c.a.t0.f1.l.b.a(this.f17363g.a.getPageActivity(), this.f17361e.f()) || TextUtils.isEmpty(this.f17361e.e())) {
                return;
            }
            FrsViewData frsViewData = this.f17362f;
            if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(this.f17362f.getForum().getId()) && this.f17362f.getActivityHeadData() != null && !TextUtils.isEmpty(this.f17362f.getActivityHeadData().c())) {
                String id = this.f17362f.getForum().getId();
                String c2 = this.f17362f.getActivityHeadData().c();
                StatisticItem statisticItem = new StatisticItem("c13330");
                statisticItem.param("fid", id);
                statisticItem.param("obj_id", c2);
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem("common_click");
                statisticItem2.param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param("fid", id).param("obj_id", c2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.FIRST_DIR, this.f17362f.getForum().getFirst_class()).param(TiebaStatic.Params.SECOND_DIR, this.f17362f.getForum().getSecond_class());
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().q);
                }
                c.a.u0.y3.c.g().c(this.f17363g.f16552b.getUniqueId(), statisticItem2);
            }
            k.b(this.f17363g.a, this.f17361e.h(), this.f17361e.e(), this.f17361e.g());
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.f17361e.k(), 1));
        }
    }

    /* loaded from: classes8.dex */
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

        @Override // c.a.t0.s.t.a.e
        public void onClick(c.a.t0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17364e;

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
            this.f17364e = bVar;
        }

        @Override // c.a.t0.s.t.a.e
        public void onClick(c.a.t0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f17364e.a == null || this.f17364e.a.getPageActivity() == null) {
                return;
            }
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f17364e.a.getPageActivity(), this.f17364e.e0, "exp_acce", 2);
            memberPayActivityConfig.setSceneId("4004001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            aVar.dismiss();
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17365e;

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
            this.f17365e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17365e.a == null || this.f17365e.a.getPageActivity() == null) {
                return;
            }
            c.a.d.f.m.g.d(this.f17365e.M, this.f17365e.a.getPageActivity());
            this.f17365e.f16552b.mSpeedUpTipShowing = false;
            c.a.t0.m.a.q(this.f17365e.a.getPageActivity(), this.f17365e.a.getResources().getString(i1.experion_speed), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17366e;

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
            this.f17366e = bVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 4) {
                    c.a.d.f.m.g.c(this.f17366e.M);
                    this.f17366e.f16552b.mSpeedUpTipShowing = false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class g extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f17367b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(b bVar, long j2, long j3, String str) {
            super(j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Long.valueOf(j2), Long.valueOf(j3), str};
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
            this.f17367b = bVar;
            this.a = str;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17367b.F = false;
                if (this.f17367b.E != null) {
                    this.f17367b.E.setVisibility(8);
                }
                if (this.f17367b.Q == null || this.f17367b.i()) {
                    return;
                }
                this.f17367b.Q.q(this.f17367b.F);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || this.f17367b.E == null) {
                return;
            }
            this.f17367b.E.setVisibility(0);
            EMTextView eMTextView = this.f17367b.E;
            eMTextView.setText(this.a + (j2 / 1000) + "s");
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17368e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f17369f;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f17370e;

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
                this.f17370e = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17370e.f17369f.E == null) {
                    return;
                }
                if (this.f17370e.f17369f.E.getVisibility() == 8) {
                    this.f17370e.f17369f.E.setVisibility(0);
                    this.f17370e.f17369f.E.setText(this.f17370e.f17368e);
                    if (this.f17370e.f17369f.G != null) {
                        b bVar = this.f17370e.f17369f;
                        bVar.W0(bVar.G.activity_msg, this.f17370e.f17369f.G.countdown_time.intValue());
                    }
                } else if (this.f17370e.f17369f.E.getVisibility() == 0) {
                    this.f17370e.f17369f.L0();
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
            this.f17369f = bVar;
            this.f17368e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.d.f.m.e.a().post(new a(this));
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
        this.y0 = false;
        this.O0 = -1;
        this.P0 = 1000L;
        this.V0 = false;
        this.W0 = c.a.u0.e1.v2.b.b.a();
        this.t0 = new ArrayList<>();
        this.e0 = i2;
        this.f16553c = new Handler();
        this.f16552b = frsFragment;
        this.a = frsFragment.getPageContext();
        c.a.d.f.p.n.f(frsFragment.getPageContext().getPageActivity(), d1.ds20);
        c.a.d.f.p.n.f(frsFragment.getPageContext().getPageActivity(), d1.ds72);
        c.a.d.f.p.n.f(frsFragment.getPageContext().getPageActivity(), d1.ds150);
        this.S = str;
        this.T = str2;
        View O0 = O0();
        this.f16554d = O0;
        this.W0.f(frsFragment, O0);
        this.X0 = this.W0.h();
        this.p0 = (RelativeLayout) this.f16554d.findViewById(f1.container);
        this.u = (RelativeLayout) this.f16554d.findViewById(f1.head_top_bg_container);
        this.v = (LinearGradientView) this.f16554d.findViewById(f1.head_top_gradient_bg);
        TbImageView tbImageView = (TbImageView) this.f16554d.findViewById(f1.head_top_bg_mask);
        this.w = tbImageView;
        tbImageView.setPageId(this.f16552b.getUniqueId());
        this.w.setDefaultBgResource(c1.transparent);
        this.w.setDefaultResource(e1.pic_frs_head_default);
        this.w0 = this.f16554d.findViewById(f1.header_top_cover);
        View findViewById = this.f16554d.findViewById(f1.frs_shrink_header_mask);
        this.x0 = findViewById;
        c.a.u0.e1.v2.b.b.d(this.w0, findViewById);
        this.E0 = c.a.u0.e1.v2.b.b.c(this.f16554d);
        this.z0 = (LinearLayout) this.f16554d.findViewById(f1.layout_banner_container);
        int n = this.W0.n(LogicField.ROUND_CORNER_STYLE);
        View findViewById2 = this.f16554d.findViewById(f1.header_round_corner_layout);
        this.A0 = findViewById2;
        findViewById2.setVisibility(n);
        this.B0 = this.f16554d.findViewById(f1.service_and_top_view_layout);
        this.C0 = this.f16554d.findViewById(f1.banner_and_bottom_view_layout);
        this.x = (ServiceAreaView) this.f16554d.findViewById(f1.service_area_view);
        this.y = (FrameLayout) this.f16554d.findViewById(f1.frs_ad_banner);
        this.D = (FrsVoiceRoomListLayout) this.f16554d.findViewById(f1.voice_room_list_layout);
        this.A = (FrsTopView) this.f16554d.findViewById(f1.frs_topview);
        this.D0 = this.f16554d.findViewById(f1.frs_top_divider_layout);
        this.B = this.f16554d.findViewById(f1.frs_top_divider_line);
        this.C = this.f16554d.findViewById(f1.service_topview_space);
        this.Y0 = c.a.u0.e1.v2.e.a.g(this.A, this.f16552b.getListView());
        this.f16558h = (List) this.W0.a(LogicField.LIKE_BTN);
        this.f16559i = (List) this.W0.a(LogicField.SIGN_BTN);
        this.L = (ImageView) N0().a(LogicField.SPEED_ICON);
        this.q0 = (TextView) this.f16554d.findViewById(f1.member_image);
        this.r0 = (TextView) this.f16554d.findViewById(f1.post_image);
        this.f16560j = (TextView) this.f16554d.findViewById(f1.level_name);
        this.s = (TextView) this.f16554d.findViewById(f1.level);
        this.k = (ImageView) this.f16554d.findViewById(f1.love_level_top);
        this.l = (ImageView) this.f16554d.findViewById(f1.love_level_bg);
        this.f16555e = (TextView) this.f16554d.findViewById(f1.member_num_text);
        this.f16556f = (TextView) this.f16554d.findViewById(f1.post_num_text);
        this.n = (TextView) this.f16554d.findViewById(f1.forum_name);
        this.o = (TextView) this.f16554d.findViewById(f1.brand_label);
        BarImageView barImageView = (BarImageView) this.f16554d.findViewById(f1.frs_image);
        this.N = barImageView;
        barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.N.setPageId(this.f16552b.getUniqueId());
        this.N.setContentDescription(frsFragment.getResources().getString(i1.bar_header));
        this.N.setStrokeWith(c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), d1.tbds4));
        this.N.setShowOval(true);
        this.N.setPlaceHolder(1);
        this.r = this.f16554d.findViewById(f1.level_container);
        this.q = (RelativeLayout) this.f16554d.findViewById(f1.has_focused_container);
        this.p = (RelativeLayout) this.f16554d.findViewById(f1.not_focused_container);
        this.t = (RelativeLayout) this.f16554d.findViewById(f1.head_content_container);
        this.F0 = this.f16554d.findViewById(f1.frs_manager_info_layout);
        this.H0 = (TextView) this.f16554d.findViewById(f1.frs_manager_name);
        HeadImageView headImageView = (HeadImageView) this.f16554d.findViewById(f1.frs_manager_portrait);
        this.G0 = headImageView;
        headImageView.setIsRound(true);
        this.G0.setDrawBorder(true);
        this.G0.setDefaultResource(e1.icon_default_avatar100);
        this.G0.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.I0 = this.f16554d.findViewById(f1.frs_manager_application_layout);
        this.J0 = (ImageView) this.f16554d.findViewById(f1.frs_manager_application_icon);
        this.K0 = (TextView) this.f16554d.findViewById(f1.frs_manager_application_desc);
        WebPManager.setPureDrawable(this.J0, e1.icon_mask_frs_apply14, c1.CAM_X0101, null);
        this.I = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(g1.frs_show_experience, (ViewGroup) null);
        this.m = LayoutInflater.from(this.f16552b.getPageContext().getPageActivity()).inflate(g1.frs_header_extra_entelechy, (ViewGroup) null);
        this.L0 = (HotRankEntryView) this.f16554d.findViewById(f1.frs_hot_rank_entry);
        this.m.setVisibility(8);
        new c.a.u0.e1.b3.e(this.a);
        this.E = (EMTextView) this.f16554d.findViewById(f1.count_down);
    }

    @Override // c.a.u0.e1.f3.b
    public void A() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16552b == null || (frsViewData = this.W) == null) {
            return;
        }
        List<n> showTopThreadList = frsViewData.getShowTopThreadList();
        this.y0 = showTopThreadList.size() > 2;
        d1(showTopThreadList, this.W.getBusinessPromot());
    }

    @Override // c.a.u0.e1.f3.b
    public void B() {
        c.a.u0.e1.c3.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (gVar = this.Q) == null) {
            return;
        }
        gVar.o(this.b0);
    }

    @Override // c.a.u0.e1.f3.b
    public void C() {
        c.a.u0.e1.c3.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.Q) == null) {
            return;
        }
        gVar.q(this.F);
    }

    @Override // c.a.u0.e1.f3.b
    public void D(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.N.setOnClickListener(onClickListener);
            this.n.setOnClickListener(onClickListener);
            this.r.setOnClickListener(onClickListener);
            HotRankEntryView hotRankEntryView = this.L0;
            if (hotRankEntryView != null) {
                hotRankEntryView.setOnClickListener(onClickListener);
            }
            View view = this.F0;
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
            View view2 = this.I0;
            if (view2 != null) {
                view2.setOnClickListener(onClickListener);
            }
            this.W0.d(onClickListener);
        }
    }

    @Override // c.a.u0.e1.f3.b
    public void E(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, forumData, frsViewData) == null) || forumData == null) {
            return;
        }
        this.S = forumData.getName();
        this.T = forumData.getId();
        this.Z = forumData.getMember_num();
        this.a0 = forumData.getPost_num();
        forumData.getTag_color();
        this.s0 = forumData.getImage_url();
        this.U = forumData.getLevelName();
        this.Y = forumData.getUser_level();
        if (forumData.getSignData() != null) {
            int i2 = forumData.getSignData().count_sign_num;
            this.b0 = forumData.getSignData().miss_sign_num;
        }
        this.c0 = forumData.getCurScore();
        this.d0 = forumData.getLevelupScore();
        this.P = forumData.getBadgeData();
        this.V = forumData.getAccelerateContent();
        this.j0 = forumData.isBrandForum;
        this.W = frsViewData;
        if (!StringUtils.isNull(this.T) && !StringUtils.isNull(this.S)) {
            this.f16554d.setVisibility(0);
        } else {
            this.f16554d.setVisibility(8);
        }
        FrsViewData frsViewData2 = this.W;
        boolean z = true;
        if (frsViewData2 != null && frsViewData2.getHotUserRankData() != null && this.W.getHotUserRankData().hot_user != null && this.W.getHotUserRankData().hot_user.size() >= 3) {
            this.x.setHasHotRankList(true);
        } else {
            this.x.setHasHotRankList(false);
        }
        int n = this.W0.n(LogicField.SERVICE_AREA);
        FrsViewData frsViewData3 = this.W;
        if ((frsViewData3 == null || frsViewData3.serviceAreaData == null || c.a.t0.g1.b.c.d()) && !this.x.isHasHotRankList()) {
            z = false;
        }
        if (n == 0 && z) {
            this.x.setVisibility(0);
            this.B0.setVisibility(0);
            ServiceAreaView serviceAreaView = this.x;
            FrsViewData frsViewData4 = this.W;
            serviceAreaView.setData(frsViewData4.serviceAreaData, frsViewData4);
        } else {
            this.x.setVisibility(8);
            this.B0.setVisibility(8);
        }
        this.X = new e2();
        b1();
        V0();
        if (this.W.getActivityHeadData() != null && this.W.getActivityHeadData().a() != null) {
            if (this.v0 && this.W.getActivityHeadData().a().f13809h) {
                this.E0.setVisibility(0);
            } else {
                this.E0.setVisibility(8);
            }
        }
        c1(forumData);
        if (frsViewData != null) {
            this.G = frsViewData.mSignActivityInfo;
            L0();
        }
    }

    public final void I0(boolean z, boolean z2) {
        int f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (c.a.u0.e1.v2.b.b.b()) {
                a();
                return;
            }
            RelativeLayout relativeLayout = this.u;
            if (relativeLayout == null || relativeLayout.getLayoutParams() == null) {
                return;
            }
            if (this.L0.getVisibility() == 0) {
                f2 = c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds704);
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds384);
                ((RelativeLayout.LayoutParams) this.L0.getLayoutParams()).topMargin = (c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds226) + c.a.d.f.p.n.r(this.a.getPageActivity())) - c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds72);
            } else {
                f2 = c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds600);
            }
            if (!z && !z2 && !this.v0) {
                f2 -= c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds80);
            } else if (this.v0) {
                int f3 = c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds782);
                int R0 = R0(z, z2);
                f2 = f3 + R0;
                ((RelativeLayout.LayoutParams) this.w.getLayoutParams()).bottomMargin = R0;
                ((RelativeLayout.LayoutParams) this.w0.getLayoutParams()).bottomMargin = R0;
                if (R0 != 0) {
                    ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds782) - c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds282);
                } else {
                    ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds493);
                }
            }
            ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
            if (layoutParams.height != f2) {
                layoutParams.height = f2;
                this.u.setLayoutParams(layoutParams);
            }
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            boolean S0 = S0();
            boolean T0 = T0();
            if (!TextUtils.isEmpty(this.S)) {
                c.a.u0.e1.a3.e c2 = c.a.u0.e1.a3.d.d().c(this.S);
                if (c2 == null) {
                    c2 = new c.a.u0.e1.a3.e(this.y0, S0);
                } else {
                    c2.d(this.y0);
                    c2.e(S0);
                }
                c.a.u0.e1.a3.d.d().e(this.S, c2);
            }
            K0(S0, T0);
            I0(S0, T0);
        }
    }

    public final void K0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f16552b.getTabController() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.z0.getLayoutParams();
        if (!z && !z2) {
            this.z0.setVisibility(0);
            this.B0.setVisibility(8);
            this.C0.setVisibility(this.W0.n(LogicField.BANNER_AND_BOTTOM_VIEW));
            layoutParams.topMargin = c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds50);
        } else {
            this.z0.setVisibility(0);
            this.B0.setVisibility(this.W0.n(LogicField.SERVICE_AREA));
            layoutParams.topMargin = c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds55);
        }
        this.f16552b.getTabController().u(z, z2);
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.G == null) {
            return;
        }
        CountDownTimer countDownTimer = this.U0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.U0.onFinish();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        this.R0 = ((long) (this.G.activity_time.intValue() + this.G.activity_duration.intValue())) - currentTimeMillis < 0;
        this.S0 = ((long) this.G.activity_time.intValue()) - currentTimeMillis <= 0;
        this.T0 = ((long) (this.G.activity_time.intValue() - this.G.countdown_time.intValue())) - currentTimeMillis <= 0;
        boolean z = this.R0;
        if (z) {
            this.E.setVisibility(8);
            return;
        }
        if (this.S0 && !z) {
            f1(this.G.activity_msg, 1000 * ((this.G.activity_time.intValue() + this.G.activity_duration.intValue()) - currentTimeMillis), this.P0);
        }
        if (!this.S0 && this.T0) {
            this.E.setVisibility(0);
            this.E.setText(this.G.countdown_msg);
            SignActivityInfo signActivityInfo = this.G;
            W0(signActivityInfo.activity_msg, signActivityInfo.activity_time.intValue() - currentTimeMillis);
        }
        if (this.T0) {
            return;
        }
        SignActivityInfo signActivityInfo2 = this.G;
        W0(signActivityInfo2.countdown_msg, (signActivityInfo2.activity_time.intValue() - this.G.countdown_time.intValue()) - currentTimeMillis);
    }

    public final void M0(i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, iVar) == null) || iVar == null || this.W == null || this.V0) {
            return;
        }
        this.V0 = true;
        StatisticItem statisticItem = new StatisticItem("common_exp");
        statisticItem.param("page_type", "a006");
        statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
        int i2 = 6;
        if (iVar.getType() != 1) {
            if (iVar.getType() == 2) {
                i2 = 7;
            } else if (iVar.getType() == 3) {
                i2 = 8;
            } else if (iVar.getType() == 4) {
                i2 = 21;
            }
        }
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
        statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
        statisticItem.param("obj_id", iVar.b());
        ForumData forum = this.W.getForum();
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

    @NonNull
    public c.a.u0.e1.v2.b.c N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.W0 : (c.a.u0.e1.v2.b.c) invokeV.objValue;
    }

    public View O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? LayoutInflater.from(this.f16552b.getPageContext().getPageActivity()).inflate(g1.frs_normal_header, (ViewGroup) null) : (View) invokeV.objValue;
    }

    @Override // c.a.u0.e1.f3.b
    @SuppressLint({"ResourceAsColor"})
    public void P(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, view, z) == null) {
            if (this.e0 == 0 && TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
                if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) == null || z) {
                    return;
                }
                View inflate = LayoutInflater.from(this.a.getContext()).inflate(g1.no_mem_dialog, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(f1.cur_experience_mem);
                TextView textView2 = (TextView) inflate.findViewById(f1.levelup_experience_mem);
                TextView textView3 = (TextView) inflate.findViewById(f1.speed_tip);
                SkinManager.setViewTextColor((TextView) inflate.findViewById(f1.experience_txt), c1.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView, c1.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView2, c1.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView3, c1.CAM_X0105, 1);
                c.a.t0.s.t.a aVar = new c.a.t0.s.t.a(this.a.getPageActivity());
                aVar.setContentView(inflate);
                F(textView, textView2);
                if (!TextUtils.isEmpty(this.V) && !TextUtils.isEmpty(this.V.trim())) {
                    textView3.setVisibility(0);
                    textView3.setText(this.V);
                } else {
                    textView3.setVisibility(8);
                }
                aVar.setButtonTextColor(c1.CAM_X0305);
                Y0(aVar);
                Z0(aVar);
                aVar.create(this.a);
                aVar.show();
                return;
            }
            this.f16553c.removeCallbacks(this.m0);
            if (this.H == null) {
                PopupWindow popupWindow = new PopupWindow(this.a.getPageActivity());
                this.H = popupWindow;
                popupWindow.setContentView(this.I);
                this.H.setBackgroundDrawable(new BitmapDrawable());
                this.H.setOutsideTouchable(true);
                this.H.setFocusable(true);
                this.H.setWidth(this.a.getResources().getDimensionPixelSize(d1.ds228));
                this.H.setHeight(this.a.getResources().getDimensionPixelSize(d1.ds100));
            }
            this.J = (TextView) this.I.findViewById(f1.cur_experience);
            this.K = (TextView) this.I.findViewById(f1.levelup_experience);
            SkinManager.setBackgroundResource(this.I.findViewById(f1.experience_container), e1.icon_frs_experience_number);
            SkinManager.setViewTextColor((TextView) this.I.findViewById(f1.experience), c1.CAM_X0111, 1);
            SkinManager.setViewTextColor(this.J, c1.common_color_10047, 1);
            SkinManager.setViewTextColor(this.K, c1.CAM_X0111, 1);
            F(this.J, this.K);
            if (this.H.isShowing()) {
                c.a.d.f.m.g.d(this.H, this.a.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.H.getHeight() <= 50) {
                c.a.d.f.m.g.d(this.H, this.a.getPageActivity());
                return;
            }
            PopupWindow popupWindow2 = this.H;
            c.a.d.f.m.g.m(popupWindow2, this.f16554d, 0, iArr[0], iArr[1] - popupWindow2.getHeight());
            this.H.update();
            this.f16553c.postDelayed(this.m0, 2000L);
        }
    }

    public final int[] P0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) ? i2 <= 3 ? new int[]{-8331843, -10499102} : i2 <= 9 ? new int[]{-10499102, -154262} : i2 <= 15 ? new int[]{-154262, -148180} : new int[]{-148180, -100818} : (int[]) invokeI.objValue;
    }

    @Override // c.a.u0.e1.f3.b
    public void Q() {
        FrsViewData frsViewData;
        String string;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.O0 == -1 || (frsViewData = this.W) == null || frsViewData.forumRule == null || frsViewData.getUserData() == null || this.A == null) {
            return;
        }
        if (this.W.getUserData().getIs_manager() == 1) {
            if (this.W.forumRule.has_forum_rule.intValue() == 1 || this.W.forumRule.audit_status.intValue() != 0) {
                return;
            }
            string = this.a.getString(i1.frs_top_forum_rules_setting);
            str = "key_forum_rule_first_show_frs_manager";
        } else {
            string = this.a.getString(i1.frs_top_forum_rules_setting_has_pass);
            str = "key_forum_rule_first_show_frs";
        }
        View view = null;
        if (this.A.getmTopViews() != null && this.A.getmTopViews().size() > 0 && (this.A.getmTopViews().get(0) instanceof AdapterLinearLayout)) {
            AdapterLinearLayout adapterLinearLayout = (AdapterLinearLayout) this.A.getmTopViews().get(0);
            if (this.O0 < adapterLinearLayout.getChildCount()) {
                view = adapterLinearLayout.getChildAt(this.O0);
            }
        }
        if (this.N0 != null || view == null) {
            return;
        }
        c.a.u0.k0.g gVar = new c.a.u0.k0.g(this.a, view);
        this.N0 = gVar;
        gVar.g0(e1.bg_tip_blue_up_left);
        this.N0.O(16);
        this.N0.U(true);
        this.N0.j0(UtilHelper.getDimenPixelSize(d1.tbds128));
        this.N0.k0(UtilHelper.getDimenPixelSize(d1.tbds_10));
        this.N0.h0(true);
        this.N0.N(4000);
        if (this.N0.J() || this.f16552b.getIsRefresh()) {
            return;
        }
        this.N0.m0(string, str);
    }

    public final LinearGradientView Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            FrsFragment frsFragment = this.f16552b;
            if (frsFragment != null && frsFragment.getTabController() != null) {
                View C = this.f16552b.getTabController().C();
                if (C instanceof LinearGradientView) {
                    return (LinearGradientView) C;
                }
            }
            return null;
        }
        return (LinearGradientView) invokeV.objValue;
    }

    @Override // c.a.u0.e1.f3.b
    public void R() {
        View contentView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            PopupWindow popupWindow = this.M;
            if (popupWindow == null) {
                this.M = new PopupWindow(this.a.getPageActivity());
                contentView = LayoutInflater.from(this.a.getContext()).inflate(g1.speed_tip, (ViewGroup) null);
                this.M.setContentView(contentView);
                contentView.setOnClickListener(new e(this));
                this.M.setWidth(this.a.getResources().getDimensionPixelSize(d1.ds300));
                this.M.setHeight(this.a.getResources().getDimensionPixelSize(d1.ds88));
                this.M.setBackgroundDrawable(new BitmapDrawable());
                this.M.setOutsideTouchable(true);
                this.M.setTouchInterceptor(new f(this));
            } else {
                contentView = popupWindow.getContentView();
            }
            SkinManager.setViewTextColor((TextView) contentView.findViewById(f1.mem), c1.CAM_X0101, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(f1.speed), c1.CAM_X0305, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(f1.tequan), c1.CAM_X0101, 1);
            int[] iArr = new int[2];
            this.L.getLocationOnScreen(iArr);
            PopupWindow popupWindow2 = this.M;
            c.a.d.f.m.g.m(popupWindow2, this.f16554d, 0, (iArr[0] - (popupWindow2.getWidth() / 2)) + (this.L.getWidth() / 2), iArr[1] + this.L.getWidth());
            this.M.update();
        }
    }

    public final int R0(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        List<n> list;
        List<e0> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i2 = 0;
            if (z2) {
                d0 d0Var = this.W.serviceAreaData;
                if (d0Var != null && (list2 = d0Var.f26148b) != null && list2.size() == 1) {
                    i2 = 0 + c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds83);
                } else {
                    i2 = 0 + c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds84);
                }
            }
            if (z && (list = this.M0) != null) {
                i2 += Math.min(list.size(), 2) * c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds83);
            }
            if (this.y.getVisibility() == 0) {
                i2 += c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds231);
            }
            return (z2 || z || this.y.getVisibility() == 0) ? i2 + c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds45) : i2;
        }
        return invokeCommon.intValue;
    }

    public final boolean S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            FrsTopView frsTopView = this.A;
            return frsTopView != null && frsTopView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.u0.e1.f3.b
    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    public final boolean T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            ServiceAreaView serviceAreaView = this.x;
            return serviceAreaView != null && serviceAreaView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void U0(int i2) {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        ThemeElement themeElement2;
        ThemeElement themeElement3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || (frsViewData = this.W) == null || (forum = frsViewData.getForum()) == null || (themeColorInfo = forum.getThemeColorInfo()) == null || (themeElement = themeColorInfo.day) == null || (themeElement2 = themeColorInfo.night) == null || (themeElement3 = themeColorInfo.dark) == null) {
            return;
        }
        if (i2 == 4) {
            themeElement = themeElement3;
        } else if (i2 == 1) {
            themeElement = themeElement2;
        }
        this.X0.e(themeElement);
        this.W0.e(themeElement);
        if (!this.v0) {
            LinearGradientView Q0 = Q0();
            LinearGradientView linearGradientView = this.v;
            if (linearGradientView != null && Q0 != null) {
                ThemeElement themeElement4 = themeColorInfo.day;
                String str = themeElement4.light_color;
                String str2 = themeElement4.dark_color;
                ThemeElement themeElement5 = themeColorInfo.night;
                String str3 = themeElement5.light_color;
                String str4 = themeElement5.dark_color;
                ThemeElement themeElement6 = themeColorInfo.dark;
                linearGradientView.setGradientColor(str, str2, str3, str4, themeElement6.light_color, themeElement6.dark_color);
            }
            if (this.w != null) {
                if (c.a.t0.b.d.u()) {
                    this.w.setDefaultResource(c1.transparent);
                } else {
                    this.w.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
        ServiceAreaView serviceAreaView = this.x;
        if (serviceAreaView != null) {
            serviceAreaView.setThemeFontColor(c.a.u0.z1.o.k.b.b(themeElement.common_color));
        }
        if (this.A != null) {
            this.A.setUrlAndColor(forum.getTopIcon(), c.a.u0.z1.o.k.b.b(themeElement.common_color));
        }
    }

    @Override // c.a.u0.e1.f3.b
    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.e0 != 0) {
                SkinManager.setImageResource(this.L, e1.icon_sml_speed_orange);
            } else {
                SkinManager.setImageResource(this.L, e1.icon_sml_speed_gray);
            }
        }
    }

    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            boolean e1 = e1();
            this.v0 = e1;
            this.W0.b(e1);
            if (this.v0) {
                this.v.setVisibility(8);
                this.w0.setVisibility(0);
                this.x0.setVisibility(0);
            } else {
                this.w0.setVisibility(8);
                this.x0.setVisibility(8);
                this.v.setVisibility(0);
                this.w.setOnClickListener(null);
            }
            TextView textView = this.f16555e;
            if (textView != null) {
                textView.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.Z));
            }
            TextView textView2 = this.f16556f;
            if (textView2 != null) {
                textView2.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.a0));
            }
            this.W0.j(this.Z, this.a0);
            this.W0.g(this.Y, this.U);
            ArrayList<l> arrayList = this.P;
            if (arrayList != null && arrayList.size() > 0) {
                this.S = UtilHelper.getFixedText(this.S, 7);
            } else if (this.j0) {
                this.S = UtilHelper.getFixedText(this.S, 6);
            }
            String b0 = c.a.u0.e1.q.b0(this.S);
            TextView textView3 = this.f16557g;
            if (textView3 != null) {
                textView3.setText(b0);
            }
            TextView textView4 = this.n;
            if (textView4 != null) {
                textView4.setText(b0);
            }
            this.W0.k(this.s0, b0);
            X0();
            A();
            U0(TbadkCoreApplication.getInst().getSkinType());
            J0();
        }
    }

    public final void W0(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, str, j2) == null) {
            this.F = false;
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.Q0 = newScheduledThreadPool;
            newScheduledThreadPool.schedule(new h(this, str), j2, TimeUnit.SECONDS);
        }
    }

    public void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.N.startLoad(this.s0, 10, false);
        }
    }

    public void Y0(c.a.t0.s.t.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, aVar) == null) {
            aVar.setNegativeButton(i1.cancel, new c(this));
        }
    }

    public void Z0(c.a.t0.s.t.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, aVar) == null) {
            aVar.setPositiveButton(i1.open_now, new d(this));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @Override // c.a.u0.e1.f3.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() {
        int i2;
        int i3;
        int i4;
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048604, this) != null) {
            return;
        }
        int i5 = 0;
        ViewCommonUtil.setViewMargin(this.z0, -1, 0, -1, -1);
        boolean z = true;
        boolean z2 = this.y.getVisibility() == 0;
        boolean z3 = this.D.getVisibility() == 0;
        View m = this.W0.m();
        z = (m == null || m.getVisibility() != 0) ? false : false;
        int dimenPixelSize = UtilHelper.getDimenPixelSize(d1.tbds24);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(d1.tbds15);
        if (z) {
            ViewCommonUtil.setViewMargin(m, -1, -1, -1, z2 ? dimenPixelSize2 : dimenPixelSize);
        } else if (z2) {
            i2 = dimenPixelSize2;
            ViewCommonUtil.setViewPadding(this.z0, -1, i2, -1, -1);
            int o0 = this.f16552b.getFrsView().o0();
            if (this.v0) {
                i4 = o0 + c.a.u0.e1.v2.c.e.o;
                if (z2 || z3 || z) {
                    ViewCommonUtil.setViewMargin(this.z0, -1, UtilHelper.getDimenPixelSize(d1.tbds55), -1, -1);
                }
            } else {
                int i6 = o0 + c.a.u0.e1.v2.c.e.p;
                if (z2) {
                    i5 = UtilHelper.getDimenPixelSize(d1.tbds231) + 0;
                    i3 = 0 + dimenPixelSize2;
                } else {
                    i3 = 0;
                }
                if (z3) {
                    i5 += UtilHelper.getDimenPixelSize(d1.tbds282);
                    if (i3 == 0) {
                        i3 += dimenPixelSize;
                    }
                }
                int i7 = i5 + (i3 * 2);
                ViewCommonUtil.setViewMargin(this.w, -1, -1, -1, i7);
                ViewCommonUtil.setViewMargin(this.w0, -1, -1, -1, i7);
                ViewCommonUtil.setViewMargin(this.t, -1, i6, -1, -1);
                i4 = i6 + i7;
            }
            layoutParams = this.u.getLayoutParams();
            if (layoutParams.height == i4) {
                layoutParams.height = i4;
                this.u.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        i2 = dimenPixelSize;
        ViewCommonUtil.setViewPadding(this.z0, -1, i2, -1, -1);
        int o02 = this.f16552b.getFrsView().o0();
        if (this.v0) {
        }
        layoutParams = this.u.getLayoutParams();
        if (layoutParams.height == i4) {
        }
    }

    public void a1() {
        c.a.u0.e1.c3.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (fVar = this.R) == null) {
            return;
        }
        fVar.n();
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.s0);
            this.X.G0().add(mediaData);
        }
    }

    @Override // c.a.u0.e1.f3.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.W0.l(LogicField.BRAND_LABEL, 0);
            this.o.setVisibility(0);
        }
    }

    public final void c1(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, forumData) == null) {
            if (forumData.getManagers() != null && forumData.getManagers().size() > 0) {
                String str = forumData.getManagers().get(0).show_name;
                if (TextUtils.isEmpty(str)) {
                    str = forumData.getManagers().get(0).name;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.H0.setText(str);
                    this.G0.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                    this.F0.setVisibility(0);
                } else {
                    this.F0.setVisibility(8);
                }
                if (this.I0.getVisibility() == 0) {
                    this.I0.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.F0.getVisibility() == 0) {
                this.F0.setVisibility(8);
            }
            if (this.I0.getVisibility() == 8) {
                this.I0.setVisibility(0);
            }
        }
    }

    @Override // c.a.u0.e1.f3.b
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.W0.onChangeSkinType(i2);
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f16554d);
            this.a.getLayoutMode().j(this.I);
            this.a.getLayoutMode().j(this.m);
            SkinManager.setBackgroundResource(this.k, e1.frs_exp_progress);
            c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(this.A0);
            d2.m(1);
            d2.n(i1.J_X14);
            d2.f(c1.CAM_X0204);
            SkinManager.setBackgroundColor(this.B0, c1.CAM_X0204);
            SkinManager.setBackgroundColor(this.C0, c1.CAM_X0204);
            SkinManager.setBackgroundColor(this.B, c1.CAM_X0624);
            SkinManager.setBackgroundColor(this.D0, c1.CAM_X0201);
            SkinManager.setBackgroundColor(this.l, c1.CAM_X0101);
            SkinManager.setBackgroundColor(this.t, c1.black_alpha0);
            SkinManager.setBackgroundColor(this.p0, c1.CAM_X0204);
            SkinManager.setViewTextColor(this.n, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.s, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.f16560j, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.q0, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.f16555e, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.r0, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.f16556f, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.H0, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.K0, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.f16556f, c1.CAM_X0101);
            c.a.t0.s.v.c d3 = c.a.t0.s.v.c.d(this.E);
            d3.A(i1.F_X01);
            d3.v(c1.CAM_X0101);
            BarImageView barImageView = this.N;
            if (barImageView != null) {
                barImageView.setBorderWidth(c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds1));
                this.N.setBorderColor(SkinManager.getColor(c1.CAM_X0603));
                this.N.setStrokeColorResId(c1.CAM_X0201);
                this.N.setPlaceHolder(1);
                this.N.invalidate();
            }
            HeadImageView headImageView = this.G0;
            if (headImageView != null) {
                headImageView.invalidate();
            }
            UserIconBox userIconBox = this.O;
            if (userIconBox != null) {
                userIconBox.onChangeSkin(i2);
            }
            LinearGradientView linearGradientView = this.v;
            if (linearGradientView != null) {
                linearGradientView.changeSkinType(i2);
            }
            Iterator<TbImageView> it = this.t0.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
            V();
            I(this.h0 ? 1 : 0);
            a1();
            U0(i2);
            I0(S0(), T0());
            ServiceAreaView serviceAreaView = this.x;
            if (serviceAreaView != null) {
                serviceAreaView.onChangeSkinType(i2);
            }
            FrsTopView frsTopView = this.A;
            if (frsTopView != null) {
                frsTopView.onChangeSkinType(i2);
            }
            c.a.u0.e1.s1.g gVar = this.z;
            if (gVar != null) {
                gVar.g(i2);
            }
            HotRankEntryView hotRankEntryView = this.L0;
            if (hotRankEntryView != null) {
                hotRankEntryView.onChangeSkinType(i2);
            }
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.D;
            if (frsVoiceRoomListLayout != null) {
                frsVoiceRoomListLayout.onChangeSkinType(this.a, i2);
            }
        }
    }

    public final void d1(List<n> list, i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048610, this, list, iVar) == null) || this.A == null) {
            return;
        }
        this.M0 = list;
        FrsViewData frsViewData = this.W;
        if (frsViewData != null && frsViewData.getVoiceRoomData() != null && this.W.getVoiceRoomData().a().size() > 0) {
            this.D.setVisibility(0);
            this.D.setPageContext(this.a);
            if (!ListUtils.isEmpty(this.W.getVoiceRoomData().a())) {
                if (this.W.getVoiceRoomData().a().size() > 5) {
                    this.D.setShowMore(true);
                } else {
                    this.D.setShowMore(false);
                }
            }
            this.D.onBindDataToView(this.W.getVoiceRoomData());
        } else {
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.D;
            if (frsVoiceRoomListLayout != null && frsVoiceRoomListLayout.getVisibility() == 0) {
                this.D.setVisibility(8);
            }
        }
        if (iVar != null) {
            this.z = new c.a.u0.e1.s1.g(this.a.getPageActivity());
            this.y.setVisibility(0);
            this.y.addView(this.z.e());
            FrsViewData frsViewData2 = this.W;
            this.z.d(frsViewData2 != null ? frsViewData2.getForum() : null, iVar);
            M0(iVar);
        } else {
            this.y.setVisibility(8);
        }
        FrsVoiceRoomListLayout frsVoiceRoomListLayout2 = this.D;
        if (frsVoiceRoomListLayout2 != null && frsVoiceRoomListLayout2.getVisibility() == 0) {
            this.D0.setVisibility(8);
        } else {
            this.D0.setVisibility(this.W0.n(LogicField.TOP_DIVIDER));
        }
        FrsFragment frsFragment = this.f16552b;
        if (frsFragment != null && frsFragment.isTopThreadListShow()) {
            this.A.setVisibility(0);
            this.A.setFragmentUniqueId(this.f16552b.getUniqueId());
            FrsViewData frsViewData3 = this.W;
            ForumData forum = frsViewData3 != null ? frsViewData3.getForum() : null;
            FrsViewData frsViewData4 = this.W;
            this.A.setForum(this.T, this.S, forum, frsViewData4 != null ? frsViewData4.getUserData() : null, this.f16552b.getFrom());
            if (list.size() > 0 && (list.get(0) instanceof r)) {
                this.O0 = 0;
            } else if (list.size() > 1 && (list.get(1) instanceof r)) {
                this.O0 = 1;
            } else {
                this.O0 = -1;
            }
            this.A.setDatas(list, iVar);
            if (this.u0 == null) {
                this.u0 = new a(this);
            }
            this.A.setStatListener(this.u0);
            return;
        }
        this.A.setVisibility(8);
        BdTypeRecyclerView bdTypeRecyclerView = this.Y0;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.removeHeaderView(this.A);
        }
    }

    @Override // c.a.u0.e1.f3.b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            SignActivityInfo signActivityInfo = this.G;
            if (signActivityInfo != null) {
                return String.valueOf(signActivityInfo.activity_id);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final boolean e1() {
        InterceptResult invokeV;
        b0 b0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            FrsViewData frsViewData = this.W;
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
                        c.a.u0.y3.c.g().d(this.f16552b.getUniqueId(), c.a.u0.y3.a.c("", frsViewData.getActivityHeadData().c(), "", null), statisticItem2);
                    }
                    this.w.startLoad(b0Var.d(), 10, false);
                    this.w.setOnClickListener(new View$OnClickListenerC1086b(this, b0Var, frsViewData));
                }
                ThirdStatisticHelper.sendReq((String) ListUtils.getItem(b0Var.k(), 0));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f1(String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.F = true;
            this.U0 = new g(this, j2, j3, str).start();
            if (this.Q == null || i()) {
                return;
            }
            this.Q.q(this.F);
        }
    }

    @Override // c.a.u0.e1.f3.b
    public SignActivityInfo k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.G : (SignActivityInfo) invokeV.objValue;
    }

    @Override // c.a.u0.e1.f3.b
    public void n() {
        c.a.u0.k0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (gVar = this.N0) == null) {
            return;
        }
        gVar.I();
        this.O0 = -1;
    }

    @Override // c.a.u0.e1.f3.b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.v0 : invokeV.booleanValue;
    }

    @Override // c.a.u0.e1.f3.b
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.F : invokeV.booleanValue;
    }

    @Override // c.a.u0.e1.f3.b
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.t();
            Handler handler = this.f16553c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            PopupWindow popupWindow = this.M;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.M.dismiss();
            }
            n();
            c.a.u0.e1.s1.g gVar = this.z;
            if (gVar != null) {
                gVar.h();
            }
            CountDownTimer countDownTimer = this.U0;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.U0 = null;
            }
        }
    }

    @Override // c.a.u0.e1.f3.b
    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.W0.c(z);
        }
    }

    @Override // c.a.u0.e1.f3.b
    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            super.v(z);
            c.a.u0.e1.s1.g gVar = this.z;
            if (gVar != null) {
                gVar.i(z);
            }
        }
    }

    @Override // c.a.u0.e1.f3.b
    public void y(boolean z, float f2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) {
            this.i0 = z;
            Bitmap cashBitmap = BitmapHelper.getCashBitmap(e1.bg_frs_signin_bar_down);
            if (cashBitmap == null || this.f16560j == null || this.k == null || this.s == null || cashBitmap.getWidth() <= 0) {
                return;
            }
            if (this.i0) {
                this.f16560j.setText(i1.level_up);
                if (f2 >= 1.0f) {
                    i2 = this.Y;
                } else {
                    i2 = this.Y + 1;
                }
                FrsViewData frsViewData = this.f16552b.getFrsViewData();
                if (frsViewData != null && frsViewData.getForum() != null) {
                    frsViewData.getForum().setUser_level(i2);
                }
                this.s.setText(this.a.getResources().getString(i1.lv_num, Integer.valueOf(i2)));
            } else {
                this.W0.g(this.Y, this.U);
                this.f16560j.setText(this.U);
                this.s.setText(this.a.getResources().getString(i1.lv_num, Integer.valueOf(this.Y)));
            }
            this.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, P0(this.Y)));
            if (!this.i0) {
                U(this.k, this.k0, f2);
            } else if (f2 >= 1.0f) {
                U(this.k, this.k0, f2);
            } else {
                S(this.k, this.k0, f2);
            }
            this.k0 = f2;
        }
    }

    @Override // c.a.u0.e1.f3.b
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.A.refrshRuleStatus(this.O0);
        }
    }
}
