package c.a.t0.e1.z1;

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
import c.a.d.n.e.n;
import c.a.s0.s.q.b0;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.l;
import c.a.s0.s.s.a;
import c.a.t0.e1.b1;
import c.a.t0.e1.c1;
import c.a.t0.e1.d1;
import c.a.t0.e1.e1;
import c.a.t0.e1.f1;
import c.a.t0.e1.g1;
import c.a.t0.e1.i1;
import c.a.t0.e1.y0;
import c.a.t0.e1.z2.k;
import c.a.t0.e1.z2.q;
import c.a.t0.x3.c0;
import c.a.t0.x3.d0;
import c.a.t0.x3.i;
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
/* loaded from: classes7.dex */
public class b extends c.a.t0.e1.d3.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A0;
    public View B0;
    public View C0;
    public TextView D0;
    public final View E0;
    public final HeadImageView F0;
    public final TextView G0;
    public final View H0;
    public final ImageView I0;
    public final TextView J0;
    public HotRankEntryView K0;
    public List<n> L0;
    public c.a.t0.k0.g M0;
    public int N0;
    public long O0;
    public ScheduledExecutorService P0;
    public boolean Q0;
    public boolean R0;
    public boolean S0;
    public CountDownTimer T0;
    public boolean U0;
    public RelativeLayout p0;
    public TextView q0;
    public TextView r0;
    public String s0;
    public ArrayList<TbImageView> t0;
    public y0 u0;
    public boolean v0;
    public View w0;
    public boolean x0;
    public LinearLayout y0;
    public View z0;

    /* loaded from: classes7.dex */
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

        @Override // c.a.t0.e1.y0
        public void a(e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, e2Var) == null) {
                q.d(this.a.f16313b, this.a.W, e2Var);
            }
        }
    }

    /* renamed from: c.a.t0.e1.z1.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1085b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b0 f17233e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsViewData f17234f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f17235g;

        public View$OnClickListenerC1085b(b bVar, b0 b0Var, FrsViewData frsViewData) {
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
            this.f17235g = bVar;
            this.f17233e = b0Var;
            this.f17234f = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17235g.a == null || c.a.s0.f1.l.b.a(this.f17235g.a.getPageActivity(), this.f17233e.f()) || TextUtils.isEmpty(this.f17233e.e())) {
                return;
            }
            FrsViewData frsViewData = this.f17234f;
            if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(this.f17234f.getForum().getId()) && this.f17234f.getActivityHeadData() != null && !TextUtils.isEmpty(this.f17234f.getActivityHeadData().c())) {
                String id = this.f17234f.getForum().getId();
                String c2 = this.f17234f.getActivityHeadData().c();
                StatisticItem statisticItem = new StatisticItem("c13330");
                statisticItem.param("fid", id);
                statisticItem.param("obj_id", c2);
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem("common_click");
                statisticItem2.param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param("fid", id).param("obj_id", c2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.FIRST_DIR, this.f17234f.getForum().getFirst_class()).param(TiebaStatic.Params.SECOND_DIR, this.f17234f.getForum().getSecond_class());
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().q);
                }
                c.a.t0.w3.c.g().c(this.f17235g.f16313b.getUniqueId(), statisticItem2);
            }
            k.b(this.f17235g.a, this.f17233e.h(), this.f17233e.e(), this.f17233e.g());
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.f17233e.k(), 1));
        }
    }

    /* loaded from: classes7.dex */
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

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17236e;

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
            this.f17236e = bVar;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f17236e.a == null || this.f17236e.a.getPageActivity() == null) {
                return;
            }
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f17236e.a.getPageActivity(), this.f17236e.e0, "exp_acce", 2);
            memberPayActivityConfig.setSceneId("4004001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            aVar.dismiss();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17237e;

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
            this.f17237e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17237e.a == null || this.f17237e.a.getPageActivity() == null) {
                return;
            }
            c.a.d.f.m.g.d(this.f17237e.M, this.f17237e.a.getPageActivity());
            this.f17237e.f16313b.mSpeedUpTipShowing = false;
            c.a.s0.m.a.q(this.f17237e.a.getPageActivity(), this.f17237e.a.getResources().getString(i1.experion_speed), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17238e;

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
            this.f17238e = bVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 4) {
                    c.a.d.f.m.g.c(this.f17238e.M);
                    this.f17238e.f16313b.mSpeedUpTipShowing = false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f17239b;

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
            this.f17239b = bVar;
            this.a = str;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17239b.F = false;
                if (this.f17239b.E != null) {
                    this.f17239b.E.setVisibility(8);
                }
                if (this.f17239b.Q == null || this.f17239b.h()) {
                    return;
                }
                this.f17239b.Q.q(this.f17239b.F);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || this.f17239b.E == null) {
                return;
            }
            this.f17239b.E.setVisibility(0);
            EMTextView eMTextView = this.f17239b.E;
            eMTextView.setText(this.a + (j2 / 1000) + "s");
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17240e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f17241f;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f17242e;

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
                this.f17242e = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17242e.f17241f.E == null) {
                    return;
                }
                if (this.f17242e.f17241f.E.getVisibility() == 8) {
                    this.f17242e.f17241f.E.setVisibility(0);
                    this.f17242e.f17241f.E.setText(this.f17242e.f17240e);
                    if (this.f17242e.f17241f.G != null) {
                        b bVar = this.f17242e.f17241f;
                        bVar.S0(bVar.G.activity_msg, this.f17242e.f17241f.G.countdown_time.intValue());
                    }
                } else if (this.f17242e.f17241f.E.getVisibility() == 0) {
                    this.f17242e.f17241f.I0();
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
            this.f17241f = bVar;
            this.f17240e = str;
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
        this.x0 = false;
        this.N0 = -1;
        this.O0 = 1000L;
        this.U0 = false;
        this.t0 = new ArrayList<>();
        this.e0 = i2;
        this.f16314c = new Handler();
        this.f16313b = frsFragment;
        this.a = frsFragment.getPageContext();
        c.a.d.f.p.n.f(frsFragment.getPageContext().getPageActivity(), d1.ds20);
        c.a.d.f.p.n.f(frsFragment.getPageContext().getPageActivity(), d1.ds72);
        c.a.d.f.p.n.f(frsFragment.getPageContext().getPageActivity(), d1.ds150);
        this.S = str;
        this.T = str2;
        View K0 = K0();
        this.f16315d = K0;
        this.p0 = (RelativeLayout) K0.findViewById(f1.container);
        this.u = (RelativeLayout) this.f16315d.findViewById(f1.head_top_bg_container);
        this.v = (LinearGradientView) this.f16315d.findViewById(f1.head_top_gradient_bg);
        TbImageView tbImageView = (TbImageView) this.f16315d.findViewById(f1.head_top_bg_mask);
        this.w = tbImageView;
        tbImageView.setPageId(this.f16313b.getUniqueId());
        this.w.setDefaultBgResource(c1.transparent);
        this.w.setDefaultResource(e1.pic_frs_head_default);
        View findViewById = this.f16315d.findViewById(f1.header_top_cover);
        this.w0 = findViewById;
        c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(findViewById);
        d2.n(i1.J_X11);
        d2.s(b1.Mask_X005);
        TextView textView = (TextView) this.f16315d.findViewById(f1.head_ad_lable_icon_layout);
        this.D0 = textView;
        c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(textView);
        d3.n(i1.J_X01);
        d3.f(c1.CAM_X0602);
        c.a.s0.s.u.c.d(this.D0).v(c1.CAM_X0617);
        this.D0.bringToFront();
        this.y0 = (LinearLayout) this.f16315d.findViewById(f1.layout_banner_container);
        this.z0 = this.f16315d.findViewById(f1.header_round_corner_layout);
        this.A0 = this.f16315d.findViewById(f1.service_and_top_view_layout);
        this.B0 = this.f16315d.findViewById(f1.banner_and_bottom_view_layout);
        this.x = (ServiceAreaView) this.f16315d.findViewById(f1.service_area_view);
        this.y = (FrameLayout) this.f16315d.findViewById(f1.frs_ad_banner);
        this.D = (FrsVoiceRoomListLayout) this.f16315d.findViewById(f1.voice_room_list_layout);
        this.A = (FrsTopView) this.f16315d.findViewById(f1.frs_topview);
        this.C0 = this.f16315d.findViewById(f1.frs_top_divider_layout);
        this.B = this.f16315d.findViewById(f1.frs_top_divider_line);
        this.C = this.f16315d.findViewById(f1.service_topview_space);
        this.L = (ImageView) this.f16315d.findViewById(f1.speed_icon);
        this.q0 = (TextView) this.f16315d.findViewById(f1.member_image);
        this.r0 = (TextView) this.f16315d.findViewById(f1.post_image);
        this.f16321j = (TextView) this.f16315d.findViewById(f1.level_name);
        this.s = (TextView) this.f16315d.findViewById(f1.level);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f16315d.findViewById(f1.tv_love);
        this.f16319h = tBSpecificationBtn;
        tBSpecificationBtn.setText(frsFragment.getResources().getString(i1.attention));
        this.f16319h.setTextSize(d1.T_X08);
        c.a.s0.s.k0.n.b bVar = new c.a.s0.s.k0.n.b();
        bVar.p(c1.CAM_X0901, c1.CAM_X0105);
        this.f16319h.setConfig(bVar);
        TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.f16315d.findViewById(f1.tv_sign);
        this.f16320i = tBSpecificationBtn2;
        tBSpecificationBtn2.setTextSize(d1.T_X08);
        c.a.s0.s.k0.n.b bVar2 = new c.a.s0.s.k0.n.b();
        bVar2.t(c1.CAM_X0105);
        bVar2.g(UtilHelper.getDimenPixelSize(d1.tbds39));
        bVar2.i(e1.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f16320i.setConfig(bVar2);
        this.f16320i.setText(frsFragment.getResources().getString(i1.sign));
        this.k = (ImageView) this.f16315d.findViewById(f1.love_level_top);
        this.l = (ImageView) this.f16315d.findViewById(f1.love_level_bg);
        this.f16316e = (TextView) this.f16315d.findViewById(f1.member_num_text);
        this.f16317f = (TextView) this.f16315d.findViewById(f1.post_num_text);
        this.n = (TextView) this.f16315d.findViewById(f1.forum_name);
        this.o = (TextView) this.f16315d.findViewById(f1.brand_label);
        BarImageView barImageView = (BarImageView) this.f16315d.findViewById(f1.frs_image);
        this.N = barImageView;
        barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.N.setPageId(this.f16313b.getUniqueId());
        this.N.setContentDescription(frsFragment.getResources().getString(i1.bar_header));
        this.N.setStrokeWith(c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), d1.tbds4));
        this.N.setShowOval(true);
        this.N.setPlaceHolder(1);
        this.r = this.f16315d.findViewById(f1.level_container);
        this.q = (RelativeLayout) this.f16315d.findViewById(f1.has_focused_container);
        this.p = (RelativeLayout) this.f16315d.findViewById(f1.not_focused_container);
        this.t = (RelativeLayout) this.f16315d.findViewById(f1.head_content_container);
        this.E0 = this.f16315d.findViewById(f1.frs_manager_info_layout);
        this.G0 = (TextView) this.f16315d.findViewById(f1.frs_manager_name);
        HeadImageView headImageView = (HeadImageView) this.f16315d.findViewById(f1.frs_manager_portrait);
        this.F0 = headImageView;
        headImageView.setIsRound(true);
        this.F0.setDrawBorder(true);
        this.F0.setDefaultResource(e1.icon_default_avatar100);
        this.F0.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.H0 = this.f16315d.findViewById(f1.frs_manager_application_layout);
        this.I0 = (ImageView) this.f16315d.findViewById(f1.frs_manager_application_icon);
        this.J0 = (TextView) this.f16315d.findViewById(f1.frs_manager_application_desc);
        WebPManager.setPureDrawable(this.I0, e1.icon_mask_frs_apply14, c1.CAM_X0101, null);
        this.I = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(g1.frs_show_experience, (ViewGroup) null);
        this.m = LayoutInflater.from(this.f16313b.getPageContext().getPageActivity()).inflate(g1.frs_header_extra_entelechy, (ViewGroup) null);
        this.K0 = (HotRankEntryView) this.f16315d.findViewById(f1.frs_hot_rank_entry);
        this.m.setVisibility(8);
        new c.a.t0.e1.z2.e(this.a);
        this.E = (EMTextView) this.f16315d.findViewById(f1.count_down);
    }

    @Override // c.a.t0.e1.d3.b
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.N.setOnClickListener(onClickListener);
            this.n.setOnClickListener(onClickListener);
            this.f16320i.setOnClickListener(onClickListener);
            this.f16319h.setOnClickListener(onClickListener);
            this.r.setOnClickListener(onClickListener);
            HotRankEntryView hotRankEntryView = this.K0;
            if (hotRankEntryView != null) {
                hotRankEntryView.setOnClickListener(onClickListener);
            }
            View view = this.E0;
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
            View view2 = this.H0;
            if (view2 != null) {
                view2.setOnClickListener(onClickListener);
            }
        }
    }

    @Override // c.a.t0.e1.d3.b
    public void B(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumData, frsViewData) == null) || forumData == null) {
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
            this.f16315d.setVisibility(0);
        } else {
            this.f16315d.setVisibility(8);
        }
        FrsViewData frsViewData2 = this.W;
        if (frsViewData2 != null && frsViewData2.getHotUserRankData() != null && this.W.getHotUserRankData().hot_user != null && this.W.getHotUserRankData().hot_user.size() >= 3) {
            this.x.setHasHotRankList(true);
        } else {
            this.x.setHasHotRankList(false);
        }
        FrsViewData frsViewData3 = this.W;
        if ((frsViewData3 != null && frsViewData3.serviceAreaData != null && !c.a.s0.g1.b.c.d()) || this.x.isHasHotRankList()) {
            this.x.setVisibility(0);
            this.A0.setVisibility(0);
            ServiceAreaView serviceAreaView = this.x;
            FrsViewData frsViewData4 = this.W;
            serviceAreaView.setData(frsViewData4.serviceAreaData, frsViewData4);
        } else {
            this.x.setVisibility(8);
            this.A0.setVisibility(8);
        }
        this.X = new e2();
        X0();
        R0();
        if (this.W.getActivityHeadData() != null && this.W.getActivityHeadData().a() != null) {
            if (a1() && this.W.getActivityHeadData().a().f13525h) {
                this.D0.setVisibility(0);
            } else {
                this.D0.setVisibility(8);
            }
        }
        Y0(forumData);
        if (frsViewData != null) {
            this.G = frsViewData.mSignActivityInfo;
            I0();
        }
    }

    public final void F0(boolean z, boolean z2) {
        RelativeLayout relativeLayout;
        int f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (relativeLayout = this.u) == null || relativeLayout.getLayoutParams() == null) {
            return;
        }
        if (this.K0.getVisibility() == 0) {
            f2 = c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds704);
            ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds384);
            ((RelativeLayout.LayoutParams) this.K0.getLayoutParams()).topMargin = (c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds226) + c.a.d.f.p.n.r(this.a.getPageActivity())) - c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds72);
        } else {
            f2 = c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds600);
        }
        if (!z && !z2 && !this.v0) {
            f2 -= c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds80);
        } else if (this.v0) {
            int f3 = c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds782);
            int N0 = N0(z, z2);
            f2 = f3 + N0;
            ((RelativeLayout.LayoutParams) this.w.getLayoutParams()).bottomMargin = N0;
            ((RelativeLayout.LayoutParams) this.w0.getLayoutParams()).bottomMargin = N0;
            if (N0 != 0) {
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

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean O0 = O0();
            boolean P0 = P0();
            if (!TextUtils.isEmpty(this.S)) {
                c.a.t0.e1.y2.e c2 = c.a.t0.e1.y2.d.d().c(this.S);
                if (c2 == null) {
                    c2 = new c.a.t0.e1.y2.e(this.x0, O0);
                } else {
                    c2.d(this.x0);
                    c2.e(O0);
                }
                c.a.t0.e1.y2.d.d().e(this.S, c2);
            }
            H0(O0, P0);
            F0(O0, P0);
        }
    }

    public final void H0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f16313b.getTabController() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.y0.getLayoutParams();
        if (!z && !z2) {
            this.y0.setVisibility(0);
            this.A0.setVisibility(8);
            this.B0.setVisibility(8);
            layoutParams.topMargin = c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds50);
        } else {
            this.y0.setVisibility(0);
            this.A0.setVisibility(0);
            layoutParams.topMargin = c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds55);
        }
        this.f16313b.getTabController().u(z, z2);
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.G == null) {
            return;
        }
        CountDownTimer countDownTimer = this.T0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.T0.onFinish();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        this.Q0 = ((long) (this.G.activity_time.intValue() + this.G.activity_duration.intValue())) - currentTimeMillis < 0;
        this.R0 = ((long) this.G.activity_time.intValue()) - currentTimeMillis <= 0;
        this.S0 = ((long) (this.G.activity_time.intValue() - this.G.countdown_time.intValue())) - currentTimeMillis <= 0;
        boolean z = this.Q0;
        if (z) {
            this.E.setVisibility(8);
            return;
        }
        if (this.R0 && !z) {
            b1(this.G.activity_msg, 1000 * ((this.G.activity_time.intValue() + this.G.activity_duration.intValue()) - currentTimeMillis), this.O0);
        }
        if (!this.R0 && this.S0) {
            this.E.setVisibility(0);
            this.E.setText(this.G.countdown_msg);
            SignActivityInfo signActivityInfo = this.G;
            S0(signActivityInfo.activity_msg, signActivityInfo.activity_time.intValue() - currentTimeMillis);
        }
        if (this.S0) {
            return;
        }
        SignActivityInfo signActivityInfo2 = this.G;
        S0(signActivityInfo2.countdown_msg, (signActivityInfo2.activity_time.intValue() - this.G.countdown_time.intValue()) - currentTimeMillis);
    }

    public final void J0(i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, iVar) == null) || iVar == null || this.W == null || this.U0) {
            return;
        }
        this.U0 = true;
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

    public View K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? LayoutInflater.from(this.f16313b.getPageContext().getPageActivity()).inflate(g1.frs_normal_header, (ViewGroup) null) : (View) invokeV.objValue;
    }

    public final int[] L0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? i2 <= 3 ? new int[]{-8331843, -10499102} : i2 <= 9 ? new int[]{-10499102, -154262} : i2 <= 15 ? new int[]{-154262, -148180} : new int[]{-148180, -100818} : (int[]) invokeI.objValue;
    }

    @Override // c.a.t0.e1.d3.b
    @SuppressLint({"ResourceAsColor"})
    public void M(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, view, z) == null) {
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
                c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.a.getPageActivity());
                aVar.setContentView(inflate);
                C(textView, textView2);
                if (!TextUtils.isEmpty(this.V) && !TextUtils.isEmpty(this.V.trim())) {
                    textView3.setVisibility(0);
                    textView3.setText(this.V);
                } else {
                    textView3.setVisibility(8);
                }
                aVar.setButtonTextColor(c1.CAM_X0305);
                U0(aVar);
                V0(aVar);
                aVar.create(this.a);
                aVar.show();
                return;
            }
            this.f16314c.removeCallbacks(this.m0);
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
            C(this.J, this.K);
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
            c.a.d.f.m.g.m(popupWindow2, this.f16315d, 0, iArr[0], iArr[1] - popupWindow2.getHeight());
            this.H.update();
            this.f16314c.postDelayed(this.m0, 2000L);
        }
    }

    public final LinearGradientView M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            FrsFragment frsFragment = this.f16313b;
            if (frsFragment != null && frsFragment.getTabController() != null) {
                View C = this.f16313b.getTabController().C();
                if (C instanceof LinearGradientView) {
                    return (LinearGradientView) C;
                }
            }
            return null;
        }
        return (LinearGradientView) invokeV.objValue;
    }

    @Override // c.a.t0.e1.d3.b
    public void N() {
        FrsViewData frsViewData;
        String string;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.N0 == -1 || (frsViewData = this.W) == null || frsViewData.forumRule == null || frsViewData.getUserData() == null || this.A == null) {
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
            if (this.N0 < adapterLinearLayout.getChildCount()) {
                view = adapterLinearLayout.getChildAt(this.N0);
            }
        }
        if (this.M0 != null || view == null) {
            return;
        }
        c.a.t0.k0.g gVar = new c.a.t0.k0.g(this.a, view);
        this.M0 = gVar;
        gVar.g0(e1.bg_tip_blue_up_left);
        this.M0.O(16);
        this.M0.U(true);
        this.M0.j0(UtilHelper.getDimenPixelSize(d1.tbds128));
        this.M0.k0(UtilHelper.getDimenPixelSize(d1.tbds_10));
        this.M0.h0(true);
        this.M0.N(4000);
        if (this.M0.J() || this.f16313b.getIsRefresh()) {
            return;
        }
        this.M0.m0(string, str);
    }

    public final int N0(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        List<n> list;
        List<d0> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i2 = 0;
            if (z2) {
                c0 c0Var = this.W.serviceAreaData;
                if (c0Var != null && (list2 = c0Var.f25037b) != null && list2.size() == 1) {
                    i2 = 0 + c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds83);
                } else {
                    i2 = 0 + c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds84);
                }
            }
            if (z && (list = this.L0) != null) {
                i2 += Math.min(list.size(), 2) * c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds83);
            }
            if (this.y.getVisibility() == 0) {
                i2 += c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds231);
            }
            return (z2 || z || this.y.getVisibility() == 0) ? i2 + c.a.d.f.p.n.f(this.a.getPageActivity(), d1.tbds45) : i2;
        }
        return invokeCommon.intValue;
    }

    @Override // c.a.t0.e1.d3.b
    public void O() {
        View contentView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
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
            c.a.d.f.m.g.m(popupWindow2, this.f16315d, 0, (iArr[0] - (popupWindow2.getWidth() / 2)) + (this.L.getWidth() / 2), iArr[1] + this.L.getWidth());
            this.M.update();
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

    @Override // c.a.t0.e1.d3.b
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
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (frsViewData = this.W) == null || (forum = frsViewData.getForum()) == null || (themeColorInfo = forum.getThemeColorInfo()) == null || (themeElement = themeColorInfo.day) == null || (themeElement2 = themeColorInfo.night) == null || (themeElement3 = themeColorInfo.dark) == null) {
            return;
        }
        if (i2 == 4) {
            themeElement = themeElement3;
        } else if (i2 == 1) {
            themeElement = themeElement2;
        }
        if (!this.v0) {
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
            serviceAreaView.setThemeFontColor(c.a.t0.y1.o.k.b.b(themeElement.common_color));
        }
        if (this.A != null) {
            this.A.setUrlAndColor(forum.getTopIcon(), c.a.t0.y1.o.k.b.b(themeElement.common_color));
        }
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TextView textView = this.f16316e;
            if (textView != null) {
                textView.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.Z));
            }
            TextView textView2 = this.f16317f;
            if (textView2 != null) {
                textView2.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.a0));
            }
            ArrayList<l> arrayList = this.P;
            if (arrayList != null && arrayList.size() > 0) {
                this.S = UtilHelper.getFixedText(this.S, 7);
            } else if (this.j0) {
                this.S = UtilHelper.getFixedText(this.S, 6);
            }
            String str = this.S + this.a.getString(i1.forum);
            TextView textView3 = this.f16318g;
            if (textView3 != null) {
                textView3.setText(str);
            }
            TextView textView4 = this.n;
            if (textView4 != null) {
                textView4.setText(str);
            }
            T0();
            boolean a1 = a1();
            this.v0 = a1;
            if (a1) {
                this.v.setVisibility(8);
                this.w0.setVisibility(0);
            } else {
                this.w0.setVisibility(8);
                this.v.setVisibility(0);
                this.w.setOnClickListener(null);
            }
            x();
            Q0(TbadkCoreApplication.getInst().getSkinType());
            G0();
        }
    }

    @Override // c.a.t0.e1.d3.b
    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.e0 != 0) {
                SkinManager.setImageResource(this.L, e1.icon_sml_speed_orange);
            } else {
                SkinManager.setImageResource(this.L, e1.icon_sml_speed_gray);
            }
        }
    }

    public final void S0(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048596, this, str, j2) == null) {
            this.F = false;
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.P0 = newScheduledThreadPool;
            newScheduledThreadPool.schedule(new h(this, str), j2, TimeUnit.SECONDS);
        }
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.N.startLoad(this.s0, 10, false);
        }
    }

    public void U0(c.a.s0.s.s.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) {
            aVar.setNegativeButton(i1.cancel, new c(this));
        }
    }

    public void V0(c.a.s0.s.s.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) {
            aVar.setPositiveButton(i1.open_now, new d(this));
        }
    }

    public void W0() {
        c.a.t0.e1.a3.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (fVar = this.R) == null) {
            return;
        }
        fVar.m();
    }

    public void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.s0);
            this.X.G0().add(mediaData);
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
                    this.G0.setText(str);
                    this.F0.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                    this.E0.setVisibility(0);
                } else {
                    this.E0.setVisibility(8);
                }
                if (this.H0.getVisibility() == 0) {
                    this.H0.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.E0.getVisibility() == 0) {
                this.E0.setVisibility(8);
            }
            if (this.H0.getVisibility() == 8) {
                this.H0.setVisibility(0);
            }
        }
    }

    public final void Z0(List<n> list, i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048603, this, list, iVar) == null) || this.A == null) {
            return;
        }
        this.L0 = list;
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
            this.z = new c.a.t0.e1.s1.g(this.a.getPageActivity());
            this.y.setVisibility(0);
            this.y.addView(this.z.e());
            FrsViewData frsViewData2 = this.W;
            this.z.d(frsViewData2 != null ? frsViewData2.getForum() : null, iVar);
            J0(iVar);
        } else {
            this.y.setVisibility(8);
        }
        FrsVoiceRoomListLayout frsVoiceRoomListLayout2 = this.D;
        if (frsVoiceRoomListLayout2 != null && frsVoiceRoomListLayout2.getVisibility() == 0) {
            this.C0.setVisibility(8);
        } else {
            this.C0.setVisibility(0);
        }
        FrsFragment frsFragment = this.f16313b;
        if (frsFragment != null && frsFragment.isTopThreadListShow()) {
            this.A.setVisibility(0);
            this.A.setFragmentUniqueId(this.f16313b.getUniqueId());
            FrsViewData frsViewData3 = this.W;
            ForumData forum = frsViewData3 != null ? frsViewData3.getForum() : null;
            FrsViewData frsViewData4 = this.W;
            this.A.setForum(this.T, this.S, forum, frsViewData4 != null ? frsViewData4.getUserData() : null, this.f16313b.getFrom());
            if (list.size() > 0 && (list.get(0) instanceof c.a.t0.x3.q)) {
                this.N0 = 0;
            } else if (list.size() > 1 && (list.get(1) instanceof c.a.t0.x3.q)) {
                this.N0 = 1;
            } else {
                this.N0 = -1;
            }
            this.A.setDatas(list, iVar);
            if (this.u0 == null) {
                this.u0 = new a(this);
            }
            this.A.setStatListener(this.u0);
            return;
        }
        this.A.setVisibility(8);
    }

    public final boolean a1() {
        InterceptResult invokeV;
        b0 b0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
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
                        c.a.t0.w3.c.g().d(this.f16313b.getUniqueId(), c.a.t0.w3.a.c("", frsViewData.getActivityHeadData().c(), "", null), statisticItem2);
                    }
                    this.w.startLoad(b0Var.d(), 10, false);
                    this.w.setOnClickListener(new View$OnClickListenerC1085b(this, b0Var, frsViewData));
                }
                ThirdStatisticHelper.sendReq((String) ListUtils.getItem(b0Var.k(), 0));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.e1.d3.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.o.setVisibility(0);
        }
    }

    public final void b1(String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.F = true;
            this.T0 = new g(this, j2, j3, str).start();
            if (this.Q == null || h()) {
                return;
            }
            this.Q.q(this.F);
        }
    }

    @Override // c.a.t0.e1.d3.b
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f16315d);
            this.a.getLayoutMode().j(this.I);
            this.a.getLayoutMode().j(this.m);
            SkinManager.setBackgroundResource(this.k, e1.frs_exp_progress);
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.z0);
            d2.m(1);
            d2.n(i1.J_X14);
            d2.f(c1.CAM_X0204);
            SkinManager.setBackgroundColor(this.A0, c1.CAM_X0204);
            SkinManager.setBackgroundColor(this.B0, c1.CAM_X0204);
            SkinManager.setBackgroundColor(this.A, c1.CAM_X0204);
            SkinManager.setBackgroundColor(this.B, c1.CAM_X0624);
            SkinManager.setBackgroundColor(this.C0, c1.CAM_X0201);
            SkinManager.setBackgroundColor(this.l, c1.CAM_X0101);
            SkinManager.setBackgroundColor(this.t, c1.black_alpha0);
            SkinManager.setBackgroundColor(this.p0, c1.CAM_X0204);
            SkinManager.setViewTextColor(this.n, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.s, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.f16321j, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.q0, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.f16316e, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.r0, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.f16317f, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.G0, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.J0, c1.CAM_X0101);
            SkinManager.setViewTextColor(this.f16317f, c1.CAM_X0101);
            c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(this.E);
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
            HeadImageView headImageView = this.F0;
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
            S();
            F(this.h0 ? 1 : 0);
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
            c.a.t0.e1.s1.g gVar = this.z;
            if (gVar != null) {
                gVar.g(i2);
            }
            HotRankEntryView hotRankEntryView = this.K0;
            if (hotRankEntryView != null) {
                hotRankEntryView.onChangeSkinType(i2);
            }
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.D;
            if (frsVoiceRoomListLayout != null) {
                frsVoiceRoomListLayout.onChangeSkinType(this.a, i2);
            }
        }
    }

    @Override // c.a.t0.e1.d3.b
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            SignActivityInfo signActivityInfo = this.G;
            if (signActivityInfo != null) {
                return String.valueOf(signActivityInfo.activity_id);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.t0.e1.d3.b
    public SignActivityInfo j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.G : (SignActivityInfo) invokeV.objValue;
    }

    @Override // c.a.t0.e1.d3.b
    public void m() {
        c.a.t0.k0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (gVar = this.M0) == null) {
            return;
        }
        gVar.I();
        this.N0 = -1;
    }

    @Override // c.a.t0.e1.d3.b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.F : invokeV.booleanValue;
    }

    @Override // c.a.t0.e1.d3.b
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.r();
            Handler handler = this.f16314c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            PopupWindow popupWindow = this.M;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.M.dismiss();
            }
            m();
            c.a.t0.e1.s1.g gVar = this.z;
            if (gVar != null) {
                gVar.h();
            }
            CountDownTimer countDownTimer = this.T0;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.T0 = null;
            }
        }
    }

    @Override // c.a.t0.e1.d3.b
    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            super.s(z);
            c.a.t0.e1.s1.g gVar = this.z;
            if (gVar != null) {
                gVar.i(z);
            }
        }
    }

    @Override // c.a.t0.e1.d3.b
    public void v(boolean z, float f2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) {
            this.i0 = z;
            Bitmap cashBitmap = BitmapHelper.getCashBitmap(e1.bg_frs_signin_bar_down);
            if (cashBitmap == null || this.f16321j == null || this.k == null || this.s == null || cashBitmap.getWidth() <= 0) {
                return;
            }
            if (this.i0) {
                this.f16321j.setText(i1.level_up);
                if (f2 >= 1.0f) {
                    i2 = this.Y;
                } else {
                    i2 = this.Y + 1;
                }
                FrsViewData frsViewData = this.f16313b.getFrsViewData();
                if (frsViewData != null && frsViewData.getForum() != null) {
                    frsViewData.getForum().setUser_level(i2);
                }
                this.s.setText(this.a.getResources().getString(i1.lv_num, Integer.valueOf(i2)));
            } else {
                this.f16321j.setText(this.U);
                this.s.setText(this.a.getResources().getString(i1.lv_num, Integer.valueOf(this.Y)));
            }
            this.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, L0(this.Y)));
            if (!this.i0) {
                R(this.k, this.k0, f2);
            } else if (f2 >= 1.0f) {
                R(this.k, this.k0, f2);
            } else {
                P(this.k, this.k0, f2);
            }
            this.k0 = f2;
        }
    }

    @Override // c.a.t0.e1.d3.b
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.A.refrshRuleStatus(this.N0);
        }
    }

    @Override // c.a.t0.e1.d3.b
    public void x() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || this.f16313b == null || (frsViewData = this.W) == null) {
            return;
        }
        List<n> showTopThreadList = frsViewData.getShowTopThreadList();
        this.x0 = showTopThreadList.size() > 2;
        Z0(showTopThreadList, this.W.getBusinessPromot());
    }

    @Override // c.a.t0.e1.d3.b
    public void y() {
        c.a.t0.e1.a3.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (gVar = this.Q) == null) {
            return;
        }
        gVar.o(this.b0);
    }

    @Override // c.a.t0.e1.d3.b
    public void z() {
        c.a.t0.e1.a3.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || (gVar = this.Q) == null) {
            return;
        }
        gVar.q(this.F);
    }
}
