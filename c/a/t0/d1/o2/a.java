package c.a.t0.d1.o2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.e1;
import c.a.t0.d1.f1;
import c.a.t0.d1.g1;
import c.a.t0.d1.n1;
import c.a.t0.d1.o2.c;
import c.a.t0.d1.q;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.live.FrsLiveTipResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.FlushManager;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16644b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f16645c;

    /* renamed from: d  reason: collision with root package name */
    public n1 f16646d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16647e;

    /* renamed from: f  reason: collision with root package name */
    public int f16648f;

    /* renamed from: g  reason: collision with root package name */
    public FrsFragment f16649g;

    /* renamed from: h  reason: collision with root package name */
    public int f16650h;

    /* renamed from: i  reason: collision with root package name */
    public String f16651i;

    /* renamed from: j  reason: collision with root package name */
    public AlaLiveInfoCoreData f16652j;

    /* renamed from: k  reason: collision with root package name */
    public AlaLiveInfoListCoreData f16653k;
    public c.a.t0.d1.o2.c l;
    public int m;
    public c.b n;
    public Runnable o;

    /* renamed from: c.a.t0.d1.o2.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1023a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1023a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.t0.d1.o2.c.b
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, frsLiveTipResponseMessage) == null) || frsLiveTipResponseMessage == null) {
                return;
            }
            this.a.f16650h = frsLiveTipResponseMessage.remindType;
            this.a.f16651i = frsLiveTipResponseMessage.remindText;
            this.a.f16652j = frsLiveTipResponseMessage.infoCoreData;
            this.a.f16653k = frsLiveTipResponseMessage.listCoreData;
            if (this.a.f16646d != null) {
                this.a.f16646d.f();
            }
            if (this.a.f16650h == 0) {
                return;
            }
            this.a.y();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16654e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16654e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16654e.l == null) {
                return;
            }
            this.f16654e.l.b(this.f16654e.m);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16655e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16655e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16655e.u();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16656e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16656e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16656e.t();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16657e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16657e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16657e.l();
            }
        }
    }

    public a(FrsFragment frsFragment, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16647e = true;
        this.n = new C1023a(this);
        this.o = new b(this);
        this.f16649g = frsFragment;
        this.m = i2;
        this.f16648f = n();
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f16648f++;
            c.a.s0.s.g0.b.j().v("FRS_HOT_LIVE_TIP_CLOSE_NUM" + p(), this.f16648f);
        }
    }

    public void l() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frsFragment = this.f16649g) == null) {
            return;
        }
        frsFragment.getTabController().b(49);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16648f = 0;
            c.a.s0.s.g0.b j2 = c.a.s0.s.g0.b.j();
            j2.v("FRS_HOT_LIVE_TIP_CLOSE_NUM" + p(), this.f16648f);
        }
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.s0.s.g0.b j2 = c.a.s0.s.g0.b.j();
            return j2.k("FRS_HOT_LIVE_TIP_CLOSE_NUM" + p(), 0);
        }
        return invokeV.intValue;
    }

    public final long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.s0.s.g0.b j2 = c.a.s0.s.g0.b.j();
            return j2.l("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + p(), 0L);
        }
        return invokeV.longValue;
    }

    public final String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                String id = currentAccountInfo.getID();
                return !TextUtils.isEmpty(id) ? id : "";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, context) == null) && context != null && this.a == null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(g1.frs_hot_live_tip, (ViewGroup) null);
            this.a = frameLayout;
            frameLayout.setOnClickListener(new c(this));
            this.f16644b = (TextView) this.a.findViewById(f1.frs_hot_live_tip_content);
            ImageView imageView = (ImageView) this.a.findViewById(f1.frs_hot_live_tip_close);
            this.f16645c = imageView;
            imageView.setOnClickListener(new d(this));
            s();
        }
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f16647e : invokeV.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SkinManager.setBackgroundResource(this.a, e1.bg_frs_hot_live_tip_selector);
            SkinManager.setViewTextColor(this.f16644b, c1.CAM_X0101);
            SkinManager.setImageResource(this.f16645c, e1.icon_home_card_close_white);
            this.f16644b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(e1.icon_arrow_more_white), (Drawable) null);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f16650h == 2) {
                k();
            }
            n1 n1Var = this.f16646d;
            if (n1Var != null) {
                n1Var.d();
            }
        }
    }

    public final void u() {
        FrsFragment frsFragment;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            m();
            if (this.f16652j == null || (frsFragment = this.f16649g) == null || !frsFragment.isAdded()) {
                return;
            }
            boolean equals = TextUtils.equals(p(), String.valueOf(this.f16652j.userID));
            int i2 = this.f16650h;
            if (i2 == 1) {
                TiebaStatic.log(new StatisticItem("c12540"));
                n1 n1Var = this.f16646d;
                if (n1Var != null) {
                    n1Var.d();
                }
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
            } else if (i2 == 2) {
                TiebaStatic.log(new StatisticItem("c12331"));
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
            } else {
                str = "";
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f16649g.getPageContext().getPageActivity(), this.f16652j, this.f16653k, str, p(), equals, null, null)));
            if (this.f16649g.getFrsViewData().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.f16649g.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            c.a.d.f.m.e.a().post(new e(this));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            n1 n1Var = this.f16646d;
            if (n1Var != null) {
                n1Var.f();
            }
            c.a.d.f.m.e.a().removeCallbacks(this.o);
            c.a.t0.d1.o2.c cVar = this.l;
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    public void w() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (frsFragment = this.f16649g) != null && frsFragment.isAdded()) {
            if (System.currentTimeMillis() - o() < FlushManager.ReportTimer.DEFAULT_INTERVAL) {
                return;
            }
            if (this.f16649g.isStartToLiveTab() && r()) {
                this.f16647e = false;
                return;
            }
            if (this.l == null) {
                this.l = new c.a.t0.d1.o2.c(this.n);
            }
            c.a.d.f.m.e.a().removeCallbacks(this.o);
            c.a.d.f.m.e.a().postDelayed(this.o, 5000L);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            c.a.s0.s.g0.b j2 = c.a.s0.s.g0.b.j();
            j2.w("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + p(), currentTimeMillis);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || StringUtils.isNull(this.f16651i) || this.f16652j == null) {
            return;
        }
        if (this.f16650h != 2 || n() < 3) {
            q(this.f16649g.getPageContext().getPageActivity());
            TextView textView = this.f16644b;
            if (textView != null) {
                textView.setText(this.f16651i);
            }
            s();
            z();
            x();
        }
    }

    public final void z() {
        FrsFragment frsFragment;
        q frsView;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (frsFragment = this.f16649g) == null || (frsView = frsFragment.getFrsView()) == null || frsView.a0() == null || (frameLayout = (FrameLayout) frsView.U()) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, n.f(TbadkCoreApplication.getInst(), d1.ds56));
        if (this.f16646d == null) {
            this.f16646d = new n1();
        }
        int i2 = this.f16650h;
        if (i2 == 2) {
            this.f16646d.h(this.a, frameLayout, layoutParams, 5000);
        } else if (i2 == 1) {
            this.f16646d.g(this.a, frameLayout, layoutParams);
            TiebaStatic.log(new StatisticItem("c12539"));
        }
    }
}
