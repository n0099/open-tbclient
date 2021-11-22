package b.a.r0;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.SelectForumActivity;
import com.baidu.tieba.SelectForumPagerAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class m implements b.a.q0.w0.a, View.OnClickListener, TbTabLayout.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<SelectForumActivity> f22052e;

    /* renamed from: f  reason: collision with root package name */
    public String f22053f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f22054g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f22055h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f22056i;
    public TbTabLayout j;
    public BdBaseViewPager k;
    public SelectForumPagerAdapter l;
    public Intent m;
    public boolean n;

    /* loaded from: classes5.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f22057e;

        public a(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22057e = mVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f22057e.n = i2 == 0;
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
            }
        }
    }

    public m(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout, navigationBar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22052e = tbPageContext;
        this.f22056i = linearLayout;
        this.f22054g = navigationBar;
        this.f22053f = "key_select_forum_tab_index";
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            this.f22053f += currentAccount;
        }
        f();
        d();
        g();
        h();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void a(TbTabLayout.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void c(TbTabLayout.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(this.f22052e.getPageActivity()).inflate(R.layout.activity_select_forum_layout, (ViewGroup) this.f22056i, true);
            this.j = (TbTabLayout) this.f22056i.findViewById(R.id.activity_select_forum_tab_layout);
            this.k = (BdBaseViewPager) this.f22056i.findViewById(R.id.activity_select_forum_viewpager);
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void e(TbTabLayout.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            TiebaStatic.log(new StatisticItem("c13994").param("obj_type", fVar.e() + 1));
            b.a.q0.s.e0.b.j().v(this.f22053f, fVar.e());
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f22054g.setCenterTextTitle(this.f22052e.getResources().getString(R.string.activity_select_forum_title));
            ImageView imageView = (ImageView) this.f22054g.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.f22055h = imageView;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.setMargins(0, 0, b.a.e.f.p.l.g(this.f22052e.getPageActivity(), R.dimen.ds10), 0);
            this.f22055h.setLayoutParams(layoutParams);
            this.f22055h.setOnClickListener(this);
            this.f22055h.setVisibility(8);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.j.setSelectedTabTextBlod(true);
            this.j.setSelectedTabIndicatorColor(0);
            TbTabLayout.f newTab = this.j.newTab();
            newTab.s(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_recently));
            TbTabLayout.f newTab2 = this.j.newTab();
            newTab2.s(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_attention));
            this.j.addTab(newTab, false);
            this.j.addTab(newTab2, false);
        }
    }

    @Override // b.a.q0.w0.a
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.m : (Intent) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SelectForumPagerAdapter selectForumPagerAdapter = new SelectForumPagerAdapter(this.f22052e);
            this.l = selectForumPagerAdapter;
            this.k.setAdapter(selectForumPagerAdapter);
            this.j.setupWithViewPager(this.k);
            j(b.a.q0.s.e0.b.j().k(this.f22053f, 0));
            this.j.setOnTabSelectedListener(this);
            this.k.addOnPageChangeListener(new a(this));
        }
    }

    public void i() {
        SelectForumPagerAdapter selectForumPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (selectForumPagerAdapter = this.l) == null) {
            return;
        }
        selectForumPagerAdapter.onDestroy();
    }

    @Override // b.a.q0.w0.a
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.q0.w0.a
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            if (i2 < 0 || i2 > 1) {
                return false;
            }
            TbTabLayout.f tabAt = this.j.getTabAt(i2);
            if (tabAt != null && !tabAt.h()) {
                tabAt.l();
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
        }
    }

    @Override // b.a.q0.w0.a
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f22055h, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.j.setTabTextColors(SkinManager.getColor(R.color.CAM_X0108), SkinManager.getColor(R.color.CAM_X0105));
            this.l.onViewChangeSkinType();
        }
    }
}
