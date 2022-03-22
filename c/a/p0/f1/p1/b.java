package c.a.p0.f1.p1;

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
import c.a.o0.r.r.b0;
import c.a.o0.r.r.l;
import c.a.o0.r.t.a;
import c.a.p0.a4.d0;
import c.a.p0.a4.e0;
import c.a.p0.a4.i;
import c.a.p0.a4.r;
import c.a.p0.f1.r2.k;
import c.a.p0.f1.r2.q;
import c.a.p0.f1.y0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.recommend.FrsLikeRecommendLayout;
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
/* loaded from: classes2.dex */
public class b extends c.a.p0.f1.v2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A0;
    public View B0;
    public View C0;
    public View D0;
    public View E0;
    public TextView F0;
    public final View G0;
    public final HeadImageView H0;
    public final TextView I0;
    public final View J0;
    public final ImageView K0;
    public final TextView L0;
    public HotRankEntryView M0;
    public List<n> N0;
    public c.a.p0.l0.g O0;
    public int P0;
    public long Q0;
    public ScheduledExecutorService R0;
    public boolean S0;
    public boolean T0;
    public boolean U0;
    public CountDownTimer V0;
    public boolean W0;
    @NonNull
    public final c.a.p0.f1.l2.b.c X0;
    @NonNull
    public final c.a.p0.f1.l2.c.c Y0;
    @Nullable
    public BdTypeRecyclerView Z0;
    public RelativeLayout q0;
    public TextView r0;
    public TextView s0;
    public String t0;
    public ArrayList<TbImageView> u0;
    public y0 v0;
    public boolean w0;
    public View x0;
    public View y0;
    public boolean z0;

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.f1.y0
        public void a(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
                q.d(this.a.f14769b, this.a.X, threadData);
            }
        }
    }

    /* renamed from: c.a.p0.f1.p1.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1077b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b0 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsViewData f14314b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f14315c;

        public View$OnClickListenerC1077b(b bVar, b0 b0Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, b0Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14315c = bVar;
            this.a = b0Var;
            this.f14314b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14315c.a == null || c.a.o0.e1.l.b.a(this.f14315c.a.getPageActivity(), this.a.f()) || TextUtils.isEmpty(this.a.e())) {
                return;
            }
            FrsViewData frsViewData = this.f14314b;
            if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(this.f14314b.getForum().getId()) && this.f14314b.getActivityHeadData() != null && !TextUtils.isEmpty(this.f14314b.getActivityHeadData().c())) {
                String id = this.f14314b.getForum().getId();
                String c2 = this.f14314b.getActivityHeadData().c();
                StatisticItem statisticItem = new StatisticItem("c13330");
                statisticItem.param("fid", id);
                statisticItem.param("obj_id", c2);
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem("common_click");
                statisticItem2.param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param("fid", id).param("obj_id", c2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.FIRST_DIR, this.f14314b.getForum().getFirst_class()).param(TiebaStatic.Params.SECOND_DIR, this.f14314b.getForum().getSecond_class());
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().q);
                }
                c.a.p0.z3.c.g().c(this.f14315c.f14769b.getUniqueId(), statisticItem2);
            }
            k.b(this.f14315c.a, this.a.h(), this.a.e(), this.a.g());
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.a.k(), 1));
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.a.a == null || this.a.a.getPageActivity() == null) {
                return;
            }
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.a.a.getPageActivity(), this.a.f0, "exp_acce", 2);
            memberPayActivityConfig.setSceneId("4004001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            aVar.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.a == null || this.a.a.getPageActivity() == null) {
                return;
            }
            c.a.d.f.m.g.d(this.a.M, this.a.a.getPageActivity());
            this.a.f14769b.f32261c = false;
            c.a.o0.l.a.q(this.a.a.getPageActivity(), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f05c3), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
        }
    }

    /* loaded from: classes2.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 4) {
                    c.a.d.f.m.g.c(this.a.M);
                    this.a.f14769b.f32261c = false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class g extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f14316b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(b bVar, long j, long j2, String str) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Long.valueOf(j), Long.valueOf(j2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14316b = bVar;
            this.a = str;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14316b.F = false;
                if (this.f14316b.E != null) {
                    this.f14316b.E.setVisibility(8);
                }
                if (this.f14316b.Q == null || this.f14316b.j()) {
                    return;
                }
                this.f14316b.Q.q(this.f14316b.F);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.f14316b.E == null) {
                return;
            }
            this.f14316b.E.setVisibility(0);
            EMTextView eMTextView = this.f14316b.E;
            eMTextView.setText(this.a + (j / 1000) + "s");
        }
    }

    /* loaded from: classes2.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f14317b;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f14317b.E == null) {
                    return;
                }
                if (this.a.f14317b.E.getVisibility() == 8) {
                    this.a.f14317b.E.setVisibility(0);
                    this.a.f14317b.E.setText(this.a.a);
                    if (this.a.f14317b.G != null) {
                        b bVar = this.a.f14317b;
                        bVar.b1(bVar.G.activity_msg, this.a.f14317b.G.countdown_time.intValue());
                    }
                } else if (this.a.f14317b.E.getVisibility() == 0) {
                    this.a.f14317b.Q0();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14317b = bVar;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.d.f.m.e.a().post(new a(this));
            }
        }
    }

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, str, str2, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.z0 = false;
        this.P0 = -1;
        this.Q0 = 1000L;
        this.W0 = false;
        this.X0 = c.a.p0.f1.l2.b.b.a();
        this.u0 = new ArrayList<>();
        this.f0 = i;
        this.f14770c = new Handler();
        this.f14769b = frsFragment;
        this.a = frsFragment.getPageContext();
        c.a.d.f.p.n.f(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d5);
        c.a.d.f.p.n.f(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07026a);
        c.a.d.f.p.n.f(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070246);
        this.T = str;
        this.U = str2;
        View T0 = T0();
        this.f14771d = T0;
        this.X0.f(frsFragment, T0);
        this.Y0 = this.X0.h();
        this.q0 = (RelativeLayout) this.f14771d.findViewById(R.id.obfuscated_res_0x7f0906c9);
        this.u = (RelativeLayout) this.f14771d.findViewById(R.id.obfuscated_res_0x7f090d28);
        this.v = (LinearGradientView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f090d2b);
        TbImageView tbImageView = (TbImageView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f090d29);
        this.w = tbImageView;
        tbImageView.setPageId(this.f14769b.getUniqueId());
        this.w.setDefaultBgResource(R.color.transparent);
        this.w.setDefaultResource(R.drawable.obfuscated_res_0x7f080efd);
        this.x0 = this.f14771d.findViewById(R.id.obfuscated_res_0x7f090d44);
        this.y0 = this.f14771d.findViewById(R.id.obfuscated_res_0x7f090bcd);
        this.S = (FrsLikeRecommendLayout) this.f14771d.findViewById(R.id.obfuscated_res_0x7f090b59);
        c.a.p0.f1.l2.b.b.d(this.x0, this.y0);
        this.F0 = c.a.p0.f1.l2.b.b.c(this.f14771d);
        this.A0 = (LinearLayout) this.f14771d.findViewById(R.id.obfuscated_res_0x7f0911c1);
        int n = this.X0.n(LogicField.ROUND_CORNER_STYLE);
        View findViewById = this.f14771d.findViewById(R.id.obfuscated_res_0x7f090d3f);
        this.B0 = findViewById;
        findViewById.setVisibility(n);
        this.C0 = this.f14771d.findViewById(R.id.obfuscated_res_0x7f091c9e);
        this.D0 = this.f14771d.findViewById(R.id.obfuscated_res_0x7f0902fa);
        this.x = (ServiceAreaView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f091c9f);
        this.y = (FrameLayout) this.f14771d.findViewById(R.id.obfuscated_res_0x7f090abc);
        this.D = (FrsVoiceRoomListLayout) this.f14771d.findViewById(R.id.obfuscated_res_0x7f092405);
        this.A = (FrsTopView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f090bf3);
        this.E0 = this.f14771d.findViewById(R.id.obfuscated_res_0x7f090beb);
        this.B = this.f14771d.findViewById(R.id.obfuscated_res_0x7f090bec);
        this.C = this.f14771d.findViewById(R.id.obfuscated_res_0x7f091ca2);
        this.Z0 = c.a.p0.f1.l2.e.a.g(this.A, this.f14769b.E2());
        this.f14775h = (List) this.X0.a(LogicField.LIKE_BTN);
        this.i = (List) this.X0.a(LogicField.SIGN_BTN);
        this.L = (ImageView) S0().a(LogicField.SPEED_ICON);
        this.r0 = (TextView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f0913d7);
        this.s0 = (TextView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f0918b1);
        this.j = (TextView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f091239);
        this.s = (TextView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f091231);
        this.k = (ImageView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f091353);
        this.l = (ImageView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f091352);
        this.f14772e = (TextView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f0913dc);
        this.f14773f = (TextView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f0918b7);
        this.n = (TextView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f090a67);
        this.o = (TextView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f0903e8);
        BarImageView barImageView = (BarImageView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f090b37);
        this.N = barImageView;
        barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.N.setPageId(this.f14769b.getUniqueId());
        this.N.setContentDescription(frsFragment.getResources().getString(R.string.obfuscated_res_0x7f0f02d1));
        this.N.setStrokeWith(c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.N.setShowOval(true);
        this.N.setPlaceHolder(1);
        this.r = this.f14771d.findViewById(R.id.obfuscated_res_0x7f091232);
        this.q = (RelativeLayout) this.f14771d.findViewById(R.id.obfuscated_res_0x7f090d16);
        this.p = (RelativeLayout) this.f14771d.findViewById(R.id.obfuscated_res_0x7f0915ba);
        this.t = (RelativeLayout) this.f14771d.findViewById(R.id.obfuscated_res_0x7f090d1e);
        this.G0 = this.f14771d.findViewById(R.id.obfuscated_res_0x7f090b83);
        this.I0 = (TextView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f090b84);
        HeadImageView headImageView = (HeadImageView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f090b85);
        this.H0 = headImageView;
        headImageView.setIsRound(true);
        this.H0.setDrawBorder(true);
        this.H0.setDefaultResource(R.drawable.icon_default_avatar100);
        this.H0.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.J0 = this.f14771d.findViewById(R.id.obfuscated_res_0x7f090b82);
        this.K0 = (ImageView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f090b81);
        this.L0 = (TextView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f090b80);
        WebPManager.setPureDrawable(this.K0, R.drawable.obfuscated_res_0x7f0807db, R.color.CAM_X0101, null);
        this.I = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0352, (ViewGroup) null);
        this.m = LayoutInflater.from(this.f14769b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0321, (ViewGroup) null);
        this.M0 = (HotRankEntryView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f090b35);
        this.m.setVisibility(8);
        new c.a.p0.f1.r2.e(this.a);
        this.E = (EMTextView) this.f14771d.findViewById(R.id.obfuscated_res_0x7f0906f8);
    }

    @Override // c.a.p0.f1.v2.d
    public void C(boolean z, float f2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) {
            this.j0 = z;
            Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
            if (cashBitmap == null || this.j == null || this.k == null || this.s == null || cashBitmap.getWidth() <= 0) {
                return;
            }
            if (this.j0) {
                this.j.setText(R.string.obfuscated_res_0x7f0f09d6);
                if (f2 >= 1.0f) {
                    i = this.Z;
                } else {
                    i = this.Z + 1;
                }
                FrsViewData f0 = this.f14769b.f0();
                if (f0 != null && f0.getForum() != null) {
                    f0.getForum().setUser_level(i);
                }
                this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a6b, Integer.valueOf(i)));
            } else {
                this.X0.g(this.Z, this.V);
                this.j.setText(this.V);
                this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a6b, Integer.valueOf(this.Z)));
            }
            this.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, U0(this.Z)));
            if (!this.j0) {
                Z(this.k, this.l0, f2);
            } else if (f2 >= 1.0f) {
                Z(this.k, this.l0, f2);
            } else {
                X(this.k, this.l0, f2);
            }
            this.l0 = f2;
        }
    }

    @Override // c.a.p0.f1.v2.d
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.A.i(this.P0);
        }
    }

    @Override // c.a.p0.f1.v2.d
    public void E() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f14769b == null || (frsViewData = this.X) == null) {
            return;
        }
        List<n> showTopThreadList = frsViewData.getShowTopThreadList();
        this.z0 = showTopThreadList.size() > 2;
        i1(showTopThreadList, this.X.getBusinessPromot());
    }

    @Override // c.a.p0.f1.v2.d
    public void F() {
        c.a.p0.f1.s2.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gVar = this.Q) == null) {
            return;
        }
        gVar.o(this.c0);
    }

    @Override // c.a.p0.f1.v2.d
    public void G() {
        c.a.p0.f1.s2.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gVar = this.Q) == null) {
            return;
        }
        gVar.q(this.F);
    }

    @Override // c.a.p0.f1.v2.d
    public void H(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.N.setOnClickListener(onClickListener);
            this.n.setOnClickListener(onClickListener);
            this.r.setOnClickListener(onClickListener);
            HotRankEntryView hotRankEntryView = this.M0;
            if (hotRankEntryView != null) {
                hotRankEntryView.setOnClickListener(onClickListener);
            }
            View view = this.G0;
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
            View view2 = this.J0;
            if (view2 != null) {
                view2.setOnClickListener(onClickListener);
            }
            this.X0.d(onClickListener);
        }
    }

    @Override // c.a.p0.f1.v2.d
    public void I(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, forumData, frsViewData) == null) || forumData == null) {
            return;
        }
        this.T = forumData.getName();
        this.U = forumData.getId();
        this.a0 = forumData.getMember_num();
        this.b0 = forumData.getPost_num();
        forumData.getTag_color();
        this.t0 = forumData.getImage_url();
        this.V = forumData.getLevelName();
        this.Z = forumData.getUser_level();
        if (forumData.getSignData() != null) {
            int i = forumData.getSignData().count_sign_num;
            this.c0 = forumData.getSignData().miss_sign_num;
        }
        this.d0 = forumData.getCurScore();
        this.e0 = forumData.getLevelupScore();
        this.P = forumData.getBadgeData();
        this.W = forumData.getAccelerateContent();
        this.k0 = forumData.isBrandForum;
        this.X = frsViewData;
        if (!StringUtils.isNull(this.U) && !StringUtils.isNull(this.T)) {
            this.f14771d.setVisibility(0);
        } else {
            this.f14771d.setVisibility(8);
        }
        FrsViewData frsViewData2 = this.X;
        boolean z = true;
        if (frsViewData2 != null && frsViewData2.getHotUserRankData() != null && this.X.getHotUserRankData().hot_user != null && this.X.getHotUserRankData().hot_user.size() >= 3) {
            this.x.setHasHotRankList(true);
        } else {
            this.x.setHasHotRankList(false);
        }
        int n = this.X0.n(LogicField.SERVICE_AREA);
        FrsViewData frsViewData3 = this.X;
        if ((frsViewData3 == null || frsViewData3.serviceAreaData == null) && !this.x.a()) {
            z = false;
        }
        if (n == 0 && z) {
            this.x.setVisibility(0);
            this.C0.setVisibility(0);
            ServiceAreaView serviceAreaView = this.x;
            FrsViewData frsViewData4 = this.X;
            serviceAreaView.setData(frsViewData4.serviceAreaData, frsViewData4);
        } else {
            this.x.setVisibility(8);
            this.C0.setVisibility(8);
        }
        this.Y = new ThreadData();
        g1();
        a1();
        if (this.X.getActivityHeadData() != null && this.X.getActivityHeadData().a() != null) {
            if (this.w0 && this.X.getActivityHeadData().a().f10836h) {
                this.F0.setVisibility(0);
            } else {
                this.F0.setVisibility(8);
            }
        }
        h1(forumData);
        if (frsViewData != null) {
            this.G = frsViewData.mSignActivityInfo;
            Q0();
        }
    }

    public final void N0(boolean z, boolean z2) {
        int f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (c.a.p0.f1.l2.b.b.b()) {
                a();
                return;
            }
            RelativeLayout relativeLayout = this.u;
            if (relativeLayout == null || relativeLayout.getLayoutParams() == null) {
                return;
            }
            if (this.M0.getVisibility() == 0) {
                f2 = c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds384);
                ((RelativeLayout.LayoutParams) this.M0.getLayoutParams()).topMargin = (c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds226) + c.a.d.f.p.n.r(this.a.getPageActivity())) - c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds72);
            } else {
                f2 = c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.w0) {
                f2 -= c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds80);
            } else if (this.w0) {
                int f3 = c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds782);
                int W0 = W0(z, z2);
                f2 = f3 + W0;
                ((RelativeLayout.LayoutParams) this.w.getLayoutParams()).bottomMargin = W0;
                ((RelativeLayout.LayoutParams) this.x0.getLayoutParams()).bottomMargin = W0;
                if (W0 != 0) {
                    ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds782) - c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds282);
                } else {
                    ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds493);
                }
            }
            ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
            if (layoutParams.height != f2) {
                layoutParams.height = f2;
                this.u.setLayoutParams(layoutParams);
            }
        }
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean X0 = X0();
            boolean Y0 = Y0();
            if (!TextUtils.isEmpty(this.T)) {
                c.a.p0.f1.q2.e c2 = c.a.p0.f1.q2.d.d().c(this.T);
                if (c2 == null) {
                    c2 = new c.a.p0.f1.q2.e(this.z0, X0);
                } else {
                    c2.d(this.z0);
                    c2.e(X0);
                }
                c.a.p0.f1.q2.d.d().e(this.T, c2);
            }
            P0(X0, Y0);
            N0(X0, Y0);
        }
    }

    public final void P0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f14769b.I2() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0.getLayoutParams();
        if (!z && !z2) {
            this.A0.setVisibility(0);
            this.C0.setVisibility(8);
            this.D0.setVisibility(this.X0.n(LogicField.BANNER_AND_BOTTOM_VIEW));
            layoutParams.topMargin = c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds50);
        } else {
            this.A0.setVisibility(0);
            this.C0.setVisibility(this.X0.n(LogicField.SERVICE_AREA));
            layoutParams.topMargin = c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds55);
        }
        this.f14769b.I2().u(z, z2);
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.G == null) {
            return;
        }
        CountDownTimer countDownTimer = this.V0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.V0.onFinish();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        this.S0 = ((long) (this.G.activity_time.intValue() + this.G.activity_duration.intValue())) - currentTimeMillis < 0;
        this.T0 = ((long) this.G.activity_time.intValue()) - currentTimeMillis <= 0;
        this.U0 = ((long) (this.G.activity_time.intValue() - this.G.countdown_time.intValue())) - currentTimeMillis <= 0;
        boolean z = this.S0;
        if (z) {
            this.E.setVisibility(8);
            return;
        }
        if (this.T0 && !z) {
            k1(this.G.activity_msg, 1000 * ((this.G.activity_time.intValue() + this.G.activity_duration.intValue()) - currentTimeMillis), this.Q0);
        }
        if (!this.T0 && this.U0) {
            this.E.setVisibility(0);
            this.E.setText(this.G.countdown_msg);
            SignActivityInfo signActivityInfo = this.G;
            b1(signActivityInfo.activity_msg, signActivityInfo.activity_time.intValue() - currentTimeMillis);
        }
        if (this.U0) {
            return;
        }
        SignActivityInfo signActivityInfo2 = this.G;
        b1(signActivityInfo2.countdown_msg, (signActivityInfo2.activity_time.intValue() - this.G.countdown_time.intValue()) - currentTimeMillis);
    }

    public final void R0(i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, iVar) == null) || iVar == null || this.X == null || this.W0) {
            return;
        }
        this.W0 = true;
        StatisticItem statisticItem = new StatisticItem("common_exp");
        statisticItem.param("page_type", "a006");
        statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
        int i = 6;
        if (iVar.getType() != 1) {
            if (iVar.getType() == 2) {
                i = 7;
            } else if (iVar.getType() == 3) {
                i = 8;
            } else if (iVar.getType() == 4) {
                i = 21;
            }
        }
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
        statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i);
        statisticItem.param("obj_id", iVar.b());
        ForumData forum = this.X.getForum();
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
    public c.a.p0.f1.l2.b.c S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.X0 : (c.a.p0.f1.l2.b.c) invokeV.objValue;
    }

    @Override // c.a.p0.f1.v2.d
    @SuppressLint({"ResourceAsColor"})
    public void T(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, view, z) == null) {
            if (this.f0 == 0 && TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
                if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) == null || z) {
                    return;
                }
                View inflate = LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d061f, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09072d);
                TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091240);
                TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091d5a);
                SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090941), R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView3, R.color.CAM_X0105, 1);
                c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getPageActivity());
                aVar.setContentView(inflate);
                J(textView, textView2);
                if (!TextUtils.isEmpty(this.W) && !TextUtils.isEmpty(this.W.trim())) {
                    textView3.setVisibility(0);
                    textView3.setText(this.W);
                } else {
                    textView3.setVisibility(8);
                }
                aVar.setButtonTextColor(R.color.CAM_X0305);
                d1(aVar);
                e1(aVar);
                aVar.create(this.a);
                aVar.show();
                return;
            }
            this.f14770c.removeCallbacks(this.n0);
            if (this.H == null) {
                PopupWindow popupWindow = new PopupWindow(this.a.getPageActivity());
                this.H = popupWindow;
                popupWindow.setContentView(this.I);
                this.H.setBackgroundDrawable(new BitmapDrawable());
                this.H.setOutsideTouchable(true);
                this.H.setFocusable(true);
                this.H.setWidth(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070274));
                this.H.setHeight(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07019a));
            }
            this.J = (TextView) this.I.findViewById(R.id.obfuscated_res_0x7f09072c);
            this.K = (TextView) this.I.findViewById(R.id.obfuscated_res_0x7f09123f);
            SkinManager.setBackgroundResource(this.I.findViewById(R.id.obfuscated_res_0x7f09093c), R.drawable.icon_frs_experience_number);
            SkinManager.setViewTextColor((TextView) this.I.findViewById(R.id.obfuscated_res_0x7f09093b), R.color.CAM_X0111, 1);
            SkinManager.setViewTextColor(this.J, R.color.common_color_10047, 1);
            SkinManager.setViewTextColor(this.K, R.color.CAM_X0111, 1);
            J(this.J, this.K);
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
            c.a.d.f.m.g.m(popupWindow2, this.f14771d, 0, iArr[0], iArr[1] - popupWindow2.getHeight());
            this.H.update();
            this.f14770c.postDelayed(this.n0, 2000L);
        }
    }

    public View T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? LayoutInflater.from(this.f14769b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0346, (ViewGroup) null) : (View) invokeV.objValue;
    }

    @Override // c.a.p0.f1.v2.d
    public void U() {
        FrsViewData frsViewData;
        String string;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.P0 == -1 || (frsViewData = this.X) == null || frsViewData.forumRule == null || frsViewData.getUserData() == null || this.A == null) {
            return;
        }
        if (this.X.getUserData().getIs_manager() == 1) {
            if (this.X.forumRule.has_forum_rule.intValue() == 1 || this.X.forumRule.audit_status.intValue() != 0) {
                return;
            }
            string = this.a.getString(R.string.obfuscated_res_0x7f0f0740);
            str = "key_forum_rule_first_show_frs_manager";
        } else {
            string = this.a.getString(R.string.obfuscated_res_0x7f0f0741);
            str = "key_forum_rule_first_show_frs";
        }
        View view = null;
        if (this.A.getmTopViews() != null && this.A.getmTopViews().size() > 0 && (this.A.getmTopViews().get(0) instanceof AdapterLinearLayout)) {
            AdapterLinearLayout adapterLinearLayout = (AdapterLinearLayout) this.A.getmTopViews().get(0);
            if (this.P0 < adapterLinearLayout.getChildCount()) {
                view = adapterLinearLayout.getChildAt(this.P0);
            }
        }
        if (this.O0 != null || view == null) {
            return;
        }
        c.a.p0.l0.g gVar = new c.a.p0.l0.g(this.a, view);
        this.O0 = gVar;
        gVar.g0(R.drawable.obfuscated_res_0x7f0802f4);
        this.O0.O(16);
        this.O0.U(true);
        this.O0.j0(UtilHelper.getDimenPixelSize(R.dimen.tbds128));
        this.O0.k0(UtilHelper.getDimenPixelSize(R.dimen.tbds_10));
        this.O0.h0(true);
        this.O0.N(4000);
        if (this.O0.J() || this.f14769b.D2()) {
            return;
        }
        this.O0.m0(string, str);
    }

    public final int[] U0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) ? i <= 3 ? new int[]{-8331843, -10499102} : i <= 9 ? new int[]{-10499102, -154262} : i <= 15 ? new int[]{-154262, -148180} : new int[]{-148180, -100818} : (int[]) invokeI.objValue;
    }

    public final LinearGradientView V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            FrsFragment frsFragment = this.f14769b;
            if (frsFragment != null && frsFragment.I2() != null) {
                View C = this.f14769b.I2().C();
                if (C instanceof LinearGradientView) {
                    return (LinearGradientView) C;
                }
            }
            return null;
        }
        return (LinearGradientView) invokeV.objValue;
    }

    @Override // c.a.p0.f1.v2.d
    public void W() {
        View contentView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            PopupWindow popupWindow = this.M;
            if (popupWindow == null) {
                this.M = new PopupWindow(this.a.getPageActivity());
                contentView = LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0795, (ViewGroup) null);
                this.M.setContentView(contentView);
                contentView.setOnClickListener(new e(this));
                this.M.setWidth(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070292));
                this.M.setHeight(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702ff));
                this.M.setBackgroundDrawable(new BitmapDrawable());
                this.M.setOutsideTouchable(true);
                this.M.setTouchInterceptor(new f(this));
            } else {
                contentView = popupWindow.getContentView();
            }
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f0913c8), R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f091d52), R.color.CAM_X0305, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f091f0e), R.color.CAM_X0101, 1);
            int[] iArr = new int[2];
            this.L.getLocationOnScreen(iArr);
            PopupWindow popupWindow2 = this.M;
            c.a.d.f.m.g.m(popupWindow2, this.f14771d, 0, (iArr[0] - (popupWindow2.getWidth() / 2)) + (this.L.getWidth() / 2), iArr[1] + this.L.getWidth());
            this.M.update();
        }
    }

    public final int W0(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        List<n> list;
        List<e0> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i = 0;
            if (z2) {
                d0 d0Var = this.X.serviceAreaData;
                if (d0Var != null && (list2 = d0Var.f12177b) != null && list2.size() == 1) {
                    i = 0 + c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds83);
                } else {
                    i = 0 + c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds84);
                }
            }
            if (z && (list = this.N0) != null) {
                i += Math.min(list.size(), 2) * c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds83);
            }
            if (this.y.getVisibility() == 0) {
                i += c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds231);
            }
            return (z2 || z || this.y.getVisibility() == 0) ? i + c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds45) : i;
        }
        return invokeCommon.intValue;
    }

    public final boolean X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            FrsTopView frsTopView = this.A;
            return frsTopView != null && frsTopView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.f1.v2.d
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    public final boolean Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            ServiceAreaView serviceAreaView = this.x;
            return serviceAreaView != null && serviceAreaView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void Z0(int i) {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        ThemeElement themeElement2;
        ThemeElement themeElement3;
        int b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i) == null) || (frsViewData = this.X) == null || (forum = frsViewData.getForum()) == null || (themeColorInfo = forum.getThemeColorInfo()) == null || (themeElement = themeColorInfo.day) == null || (themeElement2 = themeColorInfo.night) == null || (themeElement3 = themeColorInfo.dark) == null) {
            return;
        }
        if (i == 4) {
            themeElement = themeElement3;
        } else if (i == 1) {
            themeElement = themeElement2;
        }
        this.Y0.e(themeElement);
        this.X0.e(themeElement);
        if (!this.w0) {
            LinearGradientView V0 = V0();
            LinearGradientView linearGradientView = this.v;
            if (linearGradientView != null && V0 != null) {
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
                if (UbsABTestHelper.isFrsModifyABTestA()) {
                    this.w.setDefaultResource(R.color.transparent);
                } else {
                    this.w.J(themeElement.pattern_image, 10, false);
                }
            }
        }
        ServiceAreaView serviceAreaView = this.x;
        if (serviceAreaView != null) {
            serviceAreaView.setThemeFontColor(c.a.p0.b2.o.k.b.b(themeElement.common_color));
        }
        if (this.A != null) {
            if (UtilHelper.isNightOrDarkMode()) {
                b2 = SkinManager.getColor(R.color.CAM_X0105);
            } else {
                b2 = c.a.p0.b2.o.k.b.b(themeElement.common_color);
            }
            this.A.setUrlAndColor(forum.getTopIcon(), b2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    @Override // c.a.p0.f1.v2.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() {
        int i;
        int i2;
        int i3;
        FrsLikeRecommendLayout frsLikeRecommendLayout;
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048600, this) != null) {
            return;
        }
        int i4 = 0;
        ViewCommonUtil.setViewMargin(this.A0, -1, 0, -1, -1);
        boolean z = true;
        boolean z2 = this.y.getVisibility() == 0;
        boolean z3 = this.D.getVisibility() == 0;
        View m = this.X0.m();
        z = (m == null || m.getVisibility() != 0) ? false : false;
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds15);
        if (z) {
            ViewCommonUtil.setViewMargin(m, -1, -1, -1, z2 ? dimenPixelSize2 : dimenPixelSize);
        } else if (z2) {
            i = dimenPixelSize2;
            ViewCommonUtil.setViewPadding(this.A0, -1, i, -1, -1);
            int o0 = this.f14769b.x0().o0();
            if (this.w0) {
                i3 = o0 + c.a.p0.f1.l2.c.e.o;
                if (z2 || z3 || z) {
                    ViewCommonUtil.setViewMargin(this.A0, -1, UtilHelper.getDimenPixelSize(R.dimen.tbds55), -1, -1);
                }
            } else {
                int i5 = o0 + c.a.p0.f1.l2.c.e.p;
                if (z2) {
                    i4 = UtilHelper.getDimenPixelSize(R.dimen.tbds231) + 0;
                    i2 = 0 + dimenPixelSize2;
                } else {
                    i2 = 0;
                }
                if (z3) {
                    i4 += UtilHelper.getDimenPixelSize(R.dimen.tbds282);
                    if (i2 == 0) {
                        i2 += dimenPixelSize;
                    }
                }
                int i6 = i4 + (i2 * 2);
                ViewCommonUtil.setViewMargin(this.w, -1, -1, -1, i6);
                ViewCommonUtil.setViewMargin(this.x0, -1, -1, -1, i6);
                ViewCommonUtil.setViewMargin(this.t, -1, i5, -1, -1);
                i3 = i5 + i6;
            }
            frsLikeRecommendLayout = this.S;
            if (frsLikeRecommendLayout != null && frsLikeRecommendLayout.getVisibility() == 0) {
                i3 += this.S.getCurrentHeight();
            }
            layoutParams = this.u.getLayoutParams();
            if (layoutParams.height == i3) {
                layoutParams.height = i3;
                this.u.setLayoutParams(layoutParams);
                FrsFragment frsFragment = this.f14769b;
                if (frsFragment != null) {
                    frsFragment.j3();
                    return;
                }
                return;
            }
            return;
        }
        i = dimenPixelSize;
        ViewCommonUtil.setViewPadding(this.A0, -1, i, -1, -1);
        int o02 = this.f14769b.x0().o0();
        if (this.w0) {
        }
        frsLikeRecommendLayout = this.S;
        if (frsLikeRecommendLayout != null) {
            i3 += this.S.getCurrentHeight();
        }
        layoutParams = this.u.getLayoutParams();
        if (layoutParams.height == i3) {
        }
    }

    @Override // c.a.p0.f1.v2.d
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.f0 != 0) {
                SkinManager.setImageResource(this.L, R.drawable.icon_sml_speed_orange);
            } else {
                SkinManager.setImageResource(this.L, R.drawable.icon_sml_speed_gray);
            }
        }
    }

    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            boolean j1 = j1();
            this.w0 = j1;
            this.X0.b(j1);
            if (this.w0) {
                this.v.setVisibility(8);
                this.x0.setVisibility(0);
                this.y0.setVisibility(0);
            } else {
                this.x0.setVisibility(8);
                this.y0.setVisibility(8);
                this.v.setVisibility(0);
                this.w.setOnClickListener(null);
            }
            TextView textView = this.f14772e;
            if (textView != null) {
                textView.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.a0));
            }
            TextView textView2 = this.f14773f;
            if (textView2 != null) {
                textView2.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.b0));
            }
            this.X0.j(this.a0, this.b0);
            this.X0.g(this.Z, this.V);
            ArrayList<l> arrayList = this.P;
            if (arrayList != null && arrayList.size() > 0) {
                this.T = UtilHelper.getFixedText(this.T, 7);
            } else if (this.k0) {
                this.T = UtilHelper.getFixedText(this.T, 6);
            }
            String b0 = c.a.p0.f1.q.b0(this.T);
            TextView textView3 = this.f14774g;
            if (textView3 != null) {
                textView3.setText(b0);
            }
            TextView textView4 = this.n;
            if (textView4 != null) {
                textView4.setText(b0);
            }
            this.X0.k(this.t0, b0);
            c1();
            E();
            Z0(TbadkCoreApplication.getInst().getSkinType());
            O0();
        }
    }

    public final void b1(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048603, this, str, j) == null) {
            this.F = false;
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.R0 = newScheduledThreadPool;
            newScheduledThreadPool.schedule(new h(this, str), j, TimeUnit.SECONDS);
        }
    }

    @Override // c.a.p0.f1.v2.d
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.X0.l(LogicField.BRAND_LABEL, 0);
            this.o.setVisibility(0);
        }
    }

    public void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.N.J(this.t0, 10, false);
        }
    }

    @Override // c.a.p0.f1.v2.d
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.X0.onChangeSkinType(i);
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.f14771d);
            this.a.getLayoutMode().j(this.I);
            this.a.getLayoutMode().j(this.m);
            SkinManager.setBackgroundResource(this.k, R.drawable.obfuscated_res_0x7f08058c);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.B0);
            d2.m(1);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.C0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.D0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.B, R.color.CAM_X0624);
            SkinManager.setBackgroundColor(this.E0, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.t, R.color.black_alpha0);
            SkinManager.setBackgroundColor(this.q0, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.r0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f14772e, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.s0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f14773f, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.I0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.L0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f14773f, (int) R.color.CAM_X0101);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.E);
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0101);
            BarImageView barImageView = this.N;
            if (barImageView != null) {
                barImageView.setBorderWidth(c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds1));
                this.N.setBorderColor(SkinManager.getColor(R.color.CAM_X0603));
                this.N.setStrokeColorResId(R.color.CAM_X0201);
                this.N.setPlaceHolder(1);
                this.N.invalidate();
            }
            HeadImageView headImageView = this.H0;
            if (headImageView != null) {
                headImageView.invalidate();
            }
            UserIconBox userIconBox = this.O;
            if (userIconBox != null) {
                userIconBox.i(i);
            }
            LinearGradientView linearGradientView = this.v;
            if (linearGradientView != null) {
                linearGradientView.a(i);
            }
            FrsLikeRecommendLayout frsLikeRecommendLayout = this.S;
            if (frsLikeRecommendLayout != null) {
                frsLikeRecommendLayout.onChangeSkinType(this.a, i);
            }
            Iterator<TbImageView> it = this.u0.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
            a0();
            M(this.i0 ? 1 : 0);
            f1();
            Z0(i);
            N0(X0(), Y0());
            ServiceAreaView serviceAreaView = this.x;
            if (serviceAreaView != null) {
                serviceAreaView.b(i);
            }
            FrsTopView frsTopView = this.A;
            if (frsTopView != null) {
                frsTopView.h(i);
            }
            c.a.p0.f1.i1.g gVar = this.z;
            if (gVar != null) {
                gVar.g(i);
            }
            HotRankEntryView hotRankEntryView = this.M0;
            if (hotRankEntryView != null) {
                hotRankEntryView.b(i);
            }
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.D;
            if (frsVoiceRoomListLayout != null) {
                frsVoiceRoomListLayout.onChangeSkinType(this.a, i);
            }
        }
    }

    public void d1(c.a.o0.r.t.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, aVar) == null) {
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new c(this));
        }
    }

    public void e1(c.a.o0.r.t.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, aVar) == null) {
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f0cc9, new d(this));
        }
    }

    @Override // c.a.p0.f1.v2.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            SignActivityInfo signActivityInfo = this.G;
            if (signActivityInfo != null) {
                return String.valueOf(signActivityInfo.activity_id);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void f1() {
        c.a.p0.f1.s2.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (fVar = this.R) == null) {
            return;
        }
        fVar.n();
    }

    public void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.t0);
            this.Y.getMedias().add(mediaData);
        }
    }

    public final void h1(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, forumData) == null) {
            if (forumData.getManagers() != null && forumData.getManagers().size() > 0) {
                String str = forumData.getManagers().get(0).show_name;
                if (TextUtils.isEmpty(str)) {
                    str = forumData.getManagers().get(0).name;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.I0.setText(str);
                    this.H0.J(forumData.getManagers().get(0).portrait, 12, false);
                    this.G0.setVisibility(0);
                } else {
                    this.G0.setVisibility(8);
                }
                if (this.J0.getVisibility() == 0) {
                    this.J0.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.G0.getVisibility() == 0) {
                this.G0.setVisibility(8);
            }
            if (this.J0.getVisibility() == 8) {
                this.J0.setVisibility(0);
            }
        }
    }

    public final void i1(List<n> list, i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048613, this, list, iVar) == null) || this.A == null) {
            return;
        }
        this.N0 = list;
        FrsViewData frsViewData = this.X;
        if (frsViewData != null && frsViewData.getVoiceRoomData() != null && this.X.getVoiceRoomData().a().size() > 0) {
            this.D.setVisibility(0);
            this.D.setPageContext(this.a);
            if (!ListUtils.isEmpty(this.X.getVoiceRoomData().a())) {
                if (this.X.getVoiceRoomData().a().size() > 5) {
                    this.D.setShowMore(true);
                } else {
                    this.D.setShowMore(false);
                }
            }
            this.D.a(this.X.getVoiceRoomData());
        } else {
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.D;
            if (frsVoiceRoomListLayout != null && frsVoiceRoomListLayout.getVisibility() == 0) {
                this.D.setVisibility(8);
            }
        }
        if (iVar != null) {
            this.z = new c.a.p0.f1.i1.g(this.a.getPageActivity());
            this.y.setVisibility(0);
            this.y.addView(this.z.e());
            FrsViewData frsViewData2 = this.X;
            this.z.d(frsViewData2 != null ? frsViewData2.getForum() : null, iVar);
            R0(iVar);
        } else {
            this.y.setVisibility(8);
        }
        FrsVoiceRoomListLayout frsVoiceRoomListLayout2 = this.D;
        if (frsVoiceRoomListLayout2 != null && frsVoiceRoomListLayout2.getVisibility() == 0) {
            this.E0.setVisibility(8);
        } else {
            this.E0.setVisibility(this.X0.n(LogicField.TOP_DIVIDER));
        }
        FrsFragment frsFragment = this.f14769b;
        if (frsFragment != null && frsFragment.Y2()) {
            this.A.setVisibility(0);
            this.A.setFragmentUniqueId(this.f14769b.getUniqueId());
            FrsViewData frsViewData3 = this.X;
            ForumData forum = frsViewData3 != null ? frsViewData3.getForum() : null;
            FrsViewData frsViewData4 = this.X;
            this.A.setForum(this.U, this.T, forum, frsViewData4 != null ? frsViewData4.getUserData() : null, this.f14769b.y2());
            if (list.size() > 0 && (list.get(0) instanceof r)) {
                this.P0 = 0;
            } else if (list.size() > 1 && (list.get(1) instanceof r)) {
                this.P0 = 1;
            } else {
                this.P0 = -1;
            }
            this.A.setDatas(list, iVar);
            if (this.v0 == null) {
                this.v0 = new a(this);
            }
            this.A.setStatListener(this.v0);
            return;
        }
        this.A.setVisibility(8);
        BdTypeRecyclerView bdTypeRecyclerView = this.Z0;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.removeHeaderView(this.A);
        }
    }

    public final boolean j1() {
        InterceptResult invokeV;
        b0 b0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            FrsViewData frsViewData = this.X;
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
                        c.a.p0.z3.c.g().d(this.f14769b.getUniqueId(), c.a.p0.z3.a.c("", frsViewData.getActivityHeadData().c(), "", null), statisticItem2);
                    }
                    this.w.J(b0Var.d(), 10, false);
                    this.w.setOnClickListener(new View$OnClickListenerC1077b(this, b0Var, frsViewData));
                }
                ThirdStatisticHelper.sendReq((String) ListUtils.getItem(b0Var.k(), 0));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void k1(String str, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.F = true;
            this.V0 = new g(this, j, j2, str).start();
            if (this.Q == null || j()) {
                return;
            }
            this.Q.q(this.F);
        }
    }

    @Override // c.a.p0.f1.v2.d
    public SignActivityInfo l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.G : (SignActivityInfo) invokeV.objValue;
    }

    @Override // c.a.p0.f1.v2.d
    public void o() {
        c.a.p0.l0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (gVar = this.O0) == null) {
            return;
        }
        gVar.I();
        this.P0 = -1;
    }

    @Override // c.a.p0.f1.v2.d
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.w0 : invokeV.booleanValue;
    }

    @Override // c.a.p0.f1.v2.d
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.F : invokeV.booleanValue;
    }

    @Override // c.a.p0.f1.v2.d
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.x();
            Handler handler = this.f14770c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            PopupWindow popupWindow = this.M;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.M.dismiss();
            }
            o();
            c.a.p0.f1.i1.g gVar = this.z;
            if (gVar != null) {
                gVar.h();
            }
            CountDownTimer countDownTimer = this.V0;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.V0 = null;
            }
        }
    }

    @Override // c.a.p0.f1.v2.d
    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.X0.c(z);
        }
    }

    @Override // c.a.p0.f1.v2.d
    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            super.z(z);
            c.a.p0.f1.i1.g gVar = this.z;
            if (gVar != null) {
                gVar.i(z);
            }
        }
    }
}
