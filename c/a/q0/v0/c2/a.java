package c.a.q0.v0.c2;

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
import c.a.e.e.p.l;
import c.a.q0.v0.c1;
import c.a.q0.v0.c2.c;
import c.a.q0.v0.q;
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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.live.FrsLiveTipResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f25887a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f25888b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f25889c;

    /* renamed from: d  reason: collision with root package name */
    public c1 f25890d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25891e;

    /* renamed from: f  reason: collision with root package name */
    public int f25892f;

    /* renamed from: g  reason: collision with root package name */
    public FrsFragment f25893g;

    /* renamed from: h  reason: collision with root package name */
    public int f25894h;

    /* renamed from: i  reason: collision with root package name */
    public String f25895i;

    /* renamed from: j  reason: collision with root package name */
    public AlaLiveInfoCoreData f25896j;
    public AlaLiveInfoListCoreData k;
    public c.a.q0.v0.c2.c l;
    public int m;
    public c.b n;
    public Runnable o;

    /* renamed from: c.a.q0.v0.c2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1211a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25897a;

        public C1211a(a aVar) {
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
            this.f25897a = aVar;
        }

        @Override // c.a.q0.v0.c2.c.b
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, frsLiveTipResponseMessage) == null) || frsLiveTipResponseMessage == null) {
                return;
            }
            this.f25897a.f25894h = frsLiveTipResponseMessage.remindType;
            this.f25897a.f25895i = frsLiveTipResponseMessage.remindText;
            this.f25897a.f25896j = frsLiveTipResponseMessage.infoCoreData;
            this.f25897a.k = frsLiveTipResponseMessage.listCoreData;
            if (this.f25897a.f25890d != null) {
                this.f25897a.f25890d.f();
            }
            if (this.f25897a.f25894h == 0) {
                return;
            }
            this.f25897a.y();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25898e;

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
            this.f25898e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f25898e.l == null) {
                return;
            }
            this.f25898e.l.b(this.f25898e.m);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25899e;

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
            this.f25899e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25899e.u();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25900e;

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
            this.f25900e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25900e.t();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25901e;

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
            this.f25901e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25901e.l();
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
        this.f25891e = true;
        this.n = new C1211a(this);
        this.o = new b(this);
        this.f25893g = frsFragment;
        this.m = i2;
        this.f25892f = n();
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25892f++;
            c.a.p0.s.d0.b.j().v("FRS_HOT_LIVE_TIP_CLOSE_NUM" + p(), this.f25892f);
        }
    }

    public void l() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frsFragment = this.f25893g) == null) {
            return;
        }
        frsFragment.getTabController().b(49);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f25892f = 0;
            c.a.p0.s.d0.b j2 = c.a.p0.s.d0.b.j();
            j2.v("FRS_HOT_LIVE_TIP_CLOSE_NUM" + p(), this.f25892f);
        }
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.p0.s.d0.b j2 = c.a.p0.s.d0.b.j();
            return j2.k("FRS_HOT_LIVE_TIP_CLOSE_NUM" + p(), 0);
        }
        return invokeV.intValue;
    }

    public final long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.p0.s.d0.b j2 = c.a.p0.s.d0.b.j();
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
        if ((interceptable == null || interceptable.invokeL(1048582, this, context) == null) && context != null && this.f25887a == null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.f25887a = frameLayout;
            frameLayout.setOnClickListener(new c(this));
            this.f25888b = (TextView) this.f25887a.findViewById(R.id.frs_hot_live_tip_content);
            ImageView imageView = (ImageView) this.f25887a.findViewById(R.id.frs_hot_live_tip_close);
            this.f25889c = imageView;
            imageView.setOnClickListener(new d(this));
            s();
        }
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f25891e : invokeV.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SkinManager.setBackgroundResource(this.f25887a, R.drawable.bg_frs_hot_live_tip_selector);
            SkinManager.setViewTextColor(this.f25888b, R.color.CAM_X0101);
            SkinManager.setImageResource(this.f25889c, R.drawable.icon_home_card_close_white);
            this.f25888b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f25894h == 2) {
                k();
            }
            c1 c1Var = this.f25890d;
            if (c1Var != null) {
                c1Var.d();
            }
        }
    }

    public final void u() {
        FrsFragment frsFragment;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            m();
            if (this.f25896j == null || (frsFragment = this.f25893g) == null || !frsFragment.isAdded()) {
                return;
            }
            boolean equals = TextUtils.equals(p(), String.valueOf(this.f25896j.userID));
            int i2 = this.f25894h;
            if (i2 == 1) {
                TiebaStatic.log(new StatisticItem("c12540"));
                c1 c1Var = this.f25890d;
                if (c1Var != null) {
                    c1Var.d();
                }
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
            } else if (i2 == 2) {
                TiebaStatic.log(new StatisticItem("c12331"));
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
            } else {
                str = "";
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f25893g.getPageContext().getPageActivity(), this.f25896j, this.k, str, p(), equals, null, null)));
            if (this.f25893g.getFrsViewData().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.f25893g.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            c.a.e.e.m.e.a().post(new e(this));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c1 c1Var = this.f25890d;
            if (c1Var != null) {
                c1Var.f();
            }
            c.a.e.e.m.e.a().removeCallbacks(this.o);
            c.a.q0.v0.c2.c cVar = this.l;
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    public void w() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (frsFragment = this.f25893g) != null && frsFragment.isAdded()) {
            if (System.currentTimeMillis() - o() < 1800000) {
                return;
            }
            if (this.f25893g.isStartToLiveTab() && r()) {
                this.f25891e = false;
                return;
            }
            if (this.l == null) {
                this.l = new c.a.q0.v0.c2.c(this.n);
            }
            c.a.e.e.m.e.a().removeCallbacks(this.o);
            c.a.e.e.m.e.a().postDelayed(this.o, 5000L);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            c.a.p0.s.d0.b j2 = c.a.p0.s.d0.b.j();
            j2.w("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + p(), currentTimeMillis);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || StringUtils.isNull(this.f25895i) || this.f25896j == null) {
            return;
        }
        if (this.f25894h != 2 || n() < 3) {
            q(this.f25893g.getPageContext().getPageActivity());
            TextView textView = this.f25888b;
            if (textView != null) {
                textView.setText(this.f25895i);
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
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (frsFragment = this.f25893g) == null || (frsView = frsFragment.getFrsView()) == null || frsView.b0() == null || (frameLayout = (FrameLayout) frsView.U()) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.f25890d == null) {
            this.f25890d = new c1();
        }
        int i2 = this.f25894h;
        if (i2 == 2) {
            this.f25890d.h(this.f25887a, frameLayout, layoutParams, 5000);
        } else if (i2 == 1) {
            this.f25890d.g(this.f25887a, frameLayout, layoutParams);
            TiebaStatic.log(new StatisticItem("c12539"));
        }
    }
}
