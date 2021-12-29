package c.a.t0.a0.k.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.s0.s.q.d2;
import c.a.t0.g0.b0;
import c.a.t0.w3.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.ala.view.ForbidParentSwipeBackRelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.adapters.FrsAlaStageLiveViewItemAdapter;
import com.baidu.tieba.ala.livecard.vc.FrsAlaStageLiveViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d extends c.a.t0.g0.b<h> implements b0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public ViewPager.OnPageChangeListener C;
    public c.a.t0.a0.k.d.c D;
    public ForbidParentSwipeBackRelativeLayout m;
    public FrsAlaStageLiveViewPager n;
    public FrsAlaStageLiveViewItemAdapter o;
    public LinearLayout p;
    public IndicatorView q;
    public View r;
    public View s;
    public String t;
    public h u;
    public int v;
    public c.a.t0.a0.k.d.a w;
    public c.a.t0.a0.k.d.b x;
    public boolean y;
    public int z;

    /* loaded from: classes6.dex */
    public class a implements SwipeBackLayout.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15262e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15262e = dVar;
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void disableSwipeBack() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15262e.u == null || ListUtils.isEmpty(this.f15262e.u.f25518e) || this.f15262e.u.f25518e.size() <= 1) {
                return;
            }
            if (this.f15262e.f18210f.getOrignalPage() instanceof BaseActivity) {
                ((BaseActivity) this.f15262e.f18210f.getOrignalPage()).setSwipeBackEnabled(false);
            } else if (this.f15262e.f18210f.getOrignalPage() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.f15262e.f18210f.getOrignalPage()).setSwipeBackEnabled(false);
            }
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void enableSwipeBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f15262e.f18210f.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.f15262e.f18210f.getOrignalPage()).setSwipeBackEnabled(this.f15262e.A);
                } else if (this.f15262e.f18210f.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) this.f15262e.f18210f.getOrignalPage()).setSwipeBackEnabled(this.f15262e.A);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15263e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15263e = dVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            int count;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || i2 == 1 || i2 != 0 || (count = this.f15263e.o.getCount()) < 2) {
                return;
            }
            int currentItem = this.f15263e.n.getCurrentItem();
            int i3 = count - 2;
            if (currentItem < 1) {
                this.f15263e.n.setCurrentItem(i3, false);
            } else if (currentItem > i3) {
                this.f15263e.n.setCurrentItem(1, false);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f15263e.v = i2;
                if (this.f15263e.x == null) {
                    return;
                }
                int a = this.f15263e.x.a(i2 + 1);
                this.f15263e.v = a;
                if (this.f15263e.q != null) {
                    this.f15263e.q.setPosition(this.f15263e.x.c(a));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements c.a.t0.a0.k.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.t0.a0.k.d.c
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, d2Var) == null) {
                this.a.B(view, d2Var);
                this.a.z(d2Var);
                d dVar = this.a;
                dVar.C(dVar.f18210f, d2Var);
            }
        }

        @Override // c.a.t0.a0.k.d.c
        public void b(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) {
                this.a.B(view, d2Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext<?> tbPageContext) {
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
        this.v = 1;
        this.y = false;
        this.z = 5;
        this.A = true;
        this.C = new b(this);
        this.D = new c(this);
        this.m = (ForbidParentSwipeBackRelativeLayout) j().findViewById(R.id.layout_root);
        this.r = j().findViewById(R.id.divider_line);
        this.s = j().findViewById(R.id.divider_pager_and_indicator);
        this.n = (FrsAlaStageLiveViewPager) j().findViewById(R.id.frs_stage_live_listview);
        this.p = (LinearLayout) j().findViewById(R.id.frs_stage_indicator_parent);
        this.q = (IndicatorView) j().findViewById(R.id.frs_stage_indicator);
        c.a.t0.a0.k.d.a aVar = new c.a.t0.a0.k.d.a(tbPageContext, this.m);
        this.w = aVar;
        aVar.d(h());
        this.n.setBackgroundResource(R.drawable.transparent_bg);
        this.n.setOnPageChangeListener(this.C);
        FrsAlaStageLiveViewItemAdapter frsAlaStageLiveViewItemAdapter = new FrsAlaStageLiveViewItemAdapter(this.f18210f, h());
        this.o = frsAlaStageLiveViewItemAdapter;
        this.n.setAdapter(frsAlaStageLiveViewItemAdapter);
        if (this.f18210f.getOrignalPage() instanceof BaseActivity) {
            this.A = ((BaseActivity) this.f18210f.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.f18210f.getOrignalPage() instanceof BaseFragmentActivity) {
            this.A = ((BaseFragmentActivity) this.f18210f.getOrignalPage()).isSwipeBackEnabled();
        }
        this.m.setSwipeControlInterface(new a(this));
    }

    public final void A() {
        h hVar;
        int c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hVar = this.u) == null || !ListUtils.isEmpty(hVar.f25518e) || (c2 = this.x.c(this.v)) >= this.u.f25518e.size() || c2 < 0) {
            return;
        }
        CustomMessage customMessage = new CustomMessage(2921017);
        List<d2> list = this.u.f25518e;
        if (list != null && list.get(c2) != null) {
            this.u.f25518e.get(c2).U1 = this.B;
        }
        customMessage.setData(this.u.f25518e.get(c2));
        MessageManager.getInstance().sendMessage(customMessage);
        if (this.u.f25518e.get(c2) != null) {
            TiebaStatic.log(new StatisticItem("c12804").param("tid", this.u.f25518e.get(c2).g0()));
        }
    }

    public final void B(View view, d2 d2Var) {
        CustomMessage customMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) {
            if (view.getId() == R.id.layout_root) {
                customMessage = new CustomMessage(2921018);
            } else if (view.getId() != R.id.card_home_page_normal_thread_user_name && view.getId() != R.id.card_home_page_normal_thread_user_header) {
                customMessage = view.getId() == R.id.video_container ? new CustomMessage(2921019) : null;
            } else {
                customMessage = new CustomMessage(2921016);
            }
            if (customMessage == null || this.f18210f == null) {
                return;
            }
            customMessage.setData(d2Var);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void C(TbPageContext<?> tbPageContext, d2 d2Var) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, d2Var) == null) || tbPageContext == null || d2Var == null || d2Var.J() == null || d2Var.o1() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = d2Var.J().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(d2Var.o1());
        if (d2Var.o1() != null && d2Var.o1().user_info != null) {
            alaLiveInfoCoreData.userName = d2Var.o1().user_info.user_name;
        }
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        h hVar = this.u;
        if (hVar != null && !ListUtils.isEmpty(hVar.f25518e)) {
            for (d2 d2Var2 : this.u.f25518e) {
                alaLiveInfoListCoreData.mLiveInfoList.add(E(d2Var2));
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_INSERT_LIVE, str, z, null, null, this.t)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.g0.b
    /* renamed from: D */
    public void k(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, hVar) == null) || hVar == null || hVar.f25518e == null) {
            return;
        }
        this.u = hVar;
        o(0);
        if (this.x == null) {
            c.a.t0.a0.k.d.b bVar = new c.a.t0.a0.k.d.b(hVar.f25518e, this.y, this.z);
            this.x = bVar;
            bVar.i(2);
            this.x.h(6);
            this.x.g(1);
        }
        this.x.j(hVar.f25518e);
        this.o.setForumName(this.t);
        this.o.setData(this.x.e(), this.D);
        this.n.setCurrentItem(this.x.d(), false);
        if (hVar.f25518e.size() >= 2) {
            this.p.setVisibility(0);
            if (this.q.getCount() != this.x.b()) {
                this.q.setCount(this.x.b());
                this.v = this.x.d();
            }
            this.q.setPosition(this.x.c(this.v));
        } else {
            this.p.setVisibility(8);
        }
        if (hVar.f25518e.size() > 0) {
            this.w.b(hVar.f25518e.get(0), "ala_frs_stage_live_feed_back_type");
        }
        A();
        l(i(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final AlaLiveInfoCoreData E(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, d2Var)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(d2Var.o1());
            alaLiveInfoCoreData.userName = d2Var.J().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    @Override // c.a.t0.g0.b0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.t = str;
        }
    }

    @Override // c.a.t0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? R.layout.frs_ala_stage_live_layout : invokeV.intValue;
    }

    @Override // c.a.t0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, i2) == null) {
            if (this.f18209e != i2) {
                SkinManager.setBackgroundResource(this.m, R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
                this.f18209e = i2;
            }
            this.w.c();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
        }
    }

    @Override // c.a.t0.g0.b0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
        }
    }

    public final void z(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, d2Var) == null) || d2Var.o1() == null || d2Var.o1().user_info == null || d2Var.o1().user_info.is_official != 2) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12805").param("tid", d2Var.g0()));
    }
}
