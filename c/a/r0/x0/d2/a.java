package c.a.r0.x0.d2;

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
import c.a.r0.x0.c1;
import c.a.r0.x0.d2.c;
import c.a.r0.x0.q;
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
    public FrameLayout f26743a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f26744b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f26745c;

    /* renamed from: d  reason: collision with root package name */
    public c1 f26746d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26747e;

    /* renamed from: f  reason: collision with root package name */
    public int f26748f;

    /* renamed from: g  reason: collision with root package name */
    public FrsFragment f26749g;

    /* renamed from: h  reason: collision with root package name */
    public int f26750h;

    /* renamed from: i  reason: collision with root package name */
    public String f26751i;

    /* renamed from: j  reason: collision with root package name */
    public AlaLiveInfoCoreData f26752j;
    public AlaLiveInfoListCoreData k;
    public c.a.r0.x0.d2.c l;
    public int m;
    public c.b n;
    public Runnable o;

    /* renamed from: c.a.r0.x0.d2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1256a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26753a;

        public C1256a(a aVar) {
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
            this.f26753a = aVar;
        }

        @Override // c.a.r0.x0.d2.c.b
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, frsLiveTipResponseMessage) == null) || frsLiveTipResponseMessage == null) {
                return;
            }
            this.f26753a.f26750h = frsLiveTipResponseMessage.remindType;
            this.f26753a.f26751i = frsLiveTipResponseMessage.remindText;
            this.f26753a.f26752j = frsLiveTipResponseMessage.infoCoreData;
            this.f26753a.k = frsLiveTipResponseMessage.listCoreData;
            if (this.f26753a.f26746d != null) {
                this.f26753a.f26746d.f();
            }
            if (this.f26753a.f26750h == 0) {
                return;
            }
            this.f26753a.y();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26754e;

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
            this.f26754e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26754e.l == null) {
                return;
            }
            this.f26754e.l.b(this.f26754e.m);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26755e;

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
            this.f26755e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26755e.u();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26756e;

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
            this.f26756e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26756e.t();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26757e;

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
            this.f26757e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26757e.l();
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
        this.f26747e = true;
        this.n = new C1256a(this);
        this.o = new b(this);
        this.f26749g = frsFragment;
        this.m = i2;
        this.f26748f = n();
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f26748f++;
            c.a.q0.s.d0.b.j().v("FRS_HOT_LIVE_TIP_CLOSE_NUM" + p(), this.f26748f);
        }
    }

    public void l() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frsFragment = this.f26749g) == null) {
            return;
        }
        frsFragment.getTabController().b(49);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26748f = 0;
            c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
            j2.v("FRS_HOT_LIVE_TIP_CLOSE_NUM" + p(), this.f26748f);
        }
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
            return j2.k("FRS_HOT_LIVE_TIP_CLOSE_NUM" + p(), 0);
        }
        return invokeV.intValue;
    }

    public final long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
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
        if ((interceptable == null || interceptable.invokeL(1048582, this, context) == null) && context != null && this.f26743a == null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.f26743a = frameLayout;
            frameLayout.setOnClickListener(new c(this));
            this.f26744b = (TextView) this.f26743a.findViewById(R.id.frs_hot_live_tip_content);
            ImageView imageView = (ImageView) this.f26743a.findViewById(R.id.frs_hot_live_tip_close);
            this.f26745c = imageView;
            imageView.setOnClickListener(new d(this));
            s();
        }
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f26747e : invokeV.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SkinManager.setBackgroundResource(this.f26743a, R.drawable.bg_frs_hot_live_tip_selector);
            SkinManager.setViewTextColor(this.f26744b, R.color.CAM_X0101);
            SkinManager.setImageResource(this.f26745c, R.drawable.icon_home_card_close_white);
            this.f26744b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f26750h == 2) {
                k();
            }
            c1 c1Var = this.f26746d;
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
            if (this.f26752j == null || (frsFragment = this.f26749g) == null || !frsFragment.isAdded()) {
                return;
            }
            boolean equals = TextUtils.equals(p(), String.valueOf(this.f26752j.userID));
            int i2 = this.f26750h;
            if (i2 == 1) {
                TiebaStatic.log(new StatisticItem("c12540"));
                c1 c1Var = this.f26746d;
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f26749g.getPageContext().getPageActivity(), this.f26752j, this.k, str, p(), equals, null, null)));
            if (this.f26749g.getFrsViewData().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.f26749g.getBaseFragmentActivity().getUniqueId());
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
            c1 c1Var = this.f26746d;
            if (c1Var != null) {
                c1Var.f();
            }
            c.a.e.e.m.e.a().removeCallbacks(this.o);
            c.a.r0.x0.d2.c cVar = this.l;
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    public void w() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (frsFragment = this.f26749g) != null && frsFragment.isAdded()) {
            if (System.currentTimeMillis() - o() < 1800000) {
                return;
            }
            if (this.f26749g.isStartToLiveTab() && r()) {
                this.f26747e = false;
                return;
            }
            if (this.l == null) {
                this.l = new c.a.r0.x0.d2.c(this.n);
            }
            c.a.e.e.m.e.a().removeCallbacks(this.o);
            c.a.e.e.m.e.a().postDelayed(this.o, 5000L);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
            j2.w("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + p(), currentTimeMillis);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || StringUtils.isNull(this.f26751i) || this.f26752j == null) {
            return;
        }
        if (this.f26750h != 2 || n() < 3) {
            q(this.f26749g.getPageContext().getPageActivity());
            TextView textView = this.f26744b;
            if (textView != null) {
                textView.setText(this.f26751i);
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
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (frsFragment = this.f26749g) == null || (frsView = frsFragment.getFrsView()) == null || frsView.b0() == null || (frameLayout = (FrameLayout) frsView.U()) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.f26746d == null) {
            this.f26746d = new c1();
        }
        int i2 = this.f26750h;
        if (i2 == 2) {
            this.f26746d.h(this.f26743a, frameLayout, layoutParams, 5000);
        } else if (i2 == 1) {
            this.f26746d.g(this.f26743a, frameLayout, layoutParams);
            TiebaStatic.log(new StatisticItem("c12539"));
        }
    }
}
