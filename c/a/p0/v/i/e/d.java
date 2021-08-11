package c.a.p0.v.i.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.o0.s.q.c2;
import c.a.p0.a0.z;
import c.a.p0.i3.h;
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
/* loaded from: classes3.dex */
public class d extends c.a.p0.a0.b<h> implements z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public ViewPager.OnPageChangeListener C;
    public c.a.p0.v.i.d.c D;
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
    public c.a.p0.v.i.d.a w;
    public c.a.p0.v.i.d.b x;
    public boolean y;
    public int z;

    /* loaded from: classes3.dex */
    public class a implements SwipeBackLayout.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f25283e;

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
            this.f25283e = dVar;
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void disableSwipeBack() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f25283e.u == null || ListUtils.isEmpty(this.f25283e.u.f19926e) || this.f25283e.u.f19926e.size() <= 1) {
                return;
            }
            if (this.f25283e.f14946f.getOrignalPage() instanceof BaseActivity) {
                ((BaseActivity) this.f25283e.f14946f.getOrignalPage()).setSwipeBackEnabled(false);
            } else if (this.f25283e.f14946f.getOrignalPage() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.f25283e.f14946f.getOrignalPage()).setSwipeBackEnabled(false);
            }
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void enableSwipeBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f25283e.f14946f.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.f25283e.f14946f.getOrignalPage()).setSwipeBackEnabled(this.f25283e.A);
                } else if (this.f25283e.f14946f.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) this.f25283e.f14946f.getOrignalPage()).setSwipeBackEnabled(this.f25283e.A);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f25284e;

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
            this.f25284e = dVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            int count;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || i2 == 1 || i2 != 0 || (count = this.f25284e.o.getCount()) < 2) {
                return;
            }
            int currentItem = this.f25284e.n.getCurrentItem();
            int i3 = count - 2;
            if (currentItem < 1) {
                this.f25284e.n.setCurrentItem(i3, false);
            } else if (currentItem > i3) {
                this.f25284e.n.setCurrentItem(1, false);
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
                this.f25284e.v = i2;
                if (this.f25284e.x == null) {
                    return;
                }
                int a2 = this.f25284e.x.a(i2 + 1);
                this.f25284e.v = a2;
                if (this.f25284e.q != null) {
                    this.f25284e.q.setPosition(this.f25284e.x.c(a2));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements c.a.p0.v.i.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f25285a;

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
            this.f25285a = dVar;
        }

        @Override // c.a.p0.v.i.d.c
        public void a(View view, c2 c2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, c2Var) == null) {
                this.f25285a.B(view, c2Var);
                this.f25285a.z(c2Var);
                d dVar = this.f25285a;
                dVar.D(dVar.f14946f, c2Var);
            }
        }

        @Override // c.a.p0.v.i.d.c
        public void b(View view, c2 c2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, c2Var) == null) {
                this.f25285a.B(view, c2Var);
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
        c.a.p0.v.i.d.a aVar = new c.a.p0.v.i.d.a(tbPageContext, this.m);
        this.w = aVar;
        aVar.d(h());
        this.n.setBackgroundResource(R.drawable.transparent_bg);
        this.n.setOnPageChangeListener(this.C);
        FrsAlaStageLiveViewItemAdapter frsAlaStageLiveViewItemAdapter = new FrsAlaStageLiveViewItemAdapter(this.f14946f, h());
        this.o = frsAlaStageLiveViewItemAdapter;
        this.n.setAdapter(frsAlaStageLiveViewItemAdapter);
        if (this.f14946f.getOrignalPage() instanceof BaseActivity) {
            this.A = ((BaseActivity) this.f14946f.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.f14946f.getOrignalPage() instanceof BaseFragmentActivity) {
            this.A = ((BaseFragmentActivity) this.f14946f.getOrignalPage()).isSwipeBackEnabled();
        }
        this.m.setSwipeControlInterface(new a(this));
    }

    public final void A() {
        h hVar;
        int c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hVar = this.u) == null || !ListUtils.isEmpty(hVar.f19926e) || (c2 = this.x.c(this.v)) >= this.u.f19926e.size() || c2 < 0) {
            return;
        }
        CustomMessage customMessage = new CustomMessage(2921017);
        List<c2> list = this.u.f19926e;
        if (list != null && list.get(c2) != null) {
            this.u.f19926e.get(c2).Q1 = this.B;
        }
        customMessage.setData(this.u.f19926e.get(c2));
        MessageManager.getInstance().sendMessage(customMessage);
        if (this.u.f19926e.get(c2) != null) {
            TiebaStatic.log(new StatisticItem("c12804").param("tid", this.u.f19926e.get(c2).f0()));
        }
    }

    public final void B(View view, c2 c2Var) {
        CustomMessage customMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, c2Var) == null) {
            if (view.getId() == R.id.layout_root) {
                customMessage = new CustomMessage(2921018);
            } else if (view.getId() != R.id.card_home_page_normal_thread_user_name && view.getId() != R.id.card_home_page_normal_thread_user_header) {
                customMessage = view.getId() == R.id.video_container ? new CustomMessage(2921019) : null;
            } else {
                customMessage = new CustomMessage(2921016);
            }
            if (customMessage == null || this.f14946f == null) {
                return;
            }
            customMessage.setData(c2Var);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void D(TbPageContext<?> tbPageContext, c2 c2Var) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, c2Var) == null) || tbPageContext == null || c2Var == null || c2Var.J() == null || c2Var.j1() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = c2Var.J().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(c2Var.j1());
        if (c2Var.j1() != null && c2Var.j1().user_info != null) {
            alaLiveInfoCoreData.userName = c2Var.j1().user_info.user_name;
        }
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        h hVar = this.u;
        if (hVar != null && !ListUtils.isEmpty(hVar.f19926e)) {
            for (c2 c2Var2 : this.u.f19926e) {
                alaLiveInfoListCoreData.mLiveInfoList.add(K(c2Var2));
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_INSERT_LIVE, str, z, null, null, this.t)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a0.b
    /* renamed from: J */
    public void k(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, hVar) == null) || hVar == null || hVar.f19926e == null) {
            return;
        }
        this.u = hVar;
        o(0);
        if (this.x == null) {
            c.a.p0.v.i.d.b bVar = new c.a.p0.v.i.d.b(hVar.f19926e, this.y, this.z);
            this.x = bVar;
            bVar.i(2);
            this.x.h(6);
            this.x.g(1);
        }
        this.x.j(hVar.f19926e);
        this.o.setForumName(this.t);
        this.o.setData(this.x.e(), this.D);
        this.n.setCurrentItem(this.x.d(), false);
        if (hVar.f19926e.size() >= 2) {
            this.p.setVisibility(0);
            if (this.q.getCount() != this.x.b()) {
                this.q.setCount(this.x.b());
                this.v = this.x.d();
            }
            this.q.setPosition(this.x.c(this.v));
        } else {
            this.p.setVisibility(8);
        }
        if (hVar.f19926e.size() > 0) {
            this.w.b(hVar.f19926e.get(0), "ala_frs_stage_live_feed_back_type");
        }
        A();
        l(i(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final AlaLiveInfoCoreData K(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, c2Var)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(c2Var.j1());
            alaLiveInfoCoreData.userName = c2Var.J().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    @Override // c.a.p0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.t = str;
        }
    }

    @Override // c.a.p0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? R.layout.frs_ala_stage_live_layout : invokeV.intValue;
    }

    @Override // c.a.p0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, i2) == null) {
            if (this.f14945e != i2) {
                SkinManager.setBackgroundResource(this.m, R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
                this.f14945e = i2;
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

    @Override // c.a.p0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
        }
    }

    public final void z(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, c2Var) == null) || c2Var.j1() == null || c2Var.j1().user_info == null || c2Var.j1().user_info.is_official != 2) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12805").param("tid", c2Var.f0()));
    }
}
