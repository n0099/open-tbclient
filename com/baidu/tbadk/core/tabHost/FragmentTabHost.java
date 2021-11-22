package com.baidu.tbadk.core.tabHost;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import b.a.e.f.p.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class FragmentTabHost extends RelativeLayout implements FragmentTabWidget.b, ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BELOW_NAVIGATION = 3;
    public static int MAIN_TAB_TOTAL = -1;
    public static final int TABBAR_COVER_BOTTOM = 2;
    public static final int TAB_HIDE_TAB_BAR = 4;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_OVERSHOT = 1;
    public static final int VIEWPAGER_IN_BOTTOM = 0;
    public static final int VIEWPAGER_IN_TOP = 1;
    public static Fragment v;
    public transient /* synthetic */ FieldHolder $fh;
    public int MAIN_TAB_VIDEOCJHANNEL;

    /* renamed from: e  reason: collision with root package name */
    public Context f46026e;

    /* renamed from: f  reason: collision with root package name */
    public FragmentTabWidget f46027f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.s.f0.a f46028g;

    /* renamed from: h  reason: collision with root package name */
    public FragmentTabSwellingView f46029h;

    /* renamed from: i  reason: collision with root package name */
    public int f46030i;
    public b j;
    public FragmentManager k;
    public final List<b> l;
    public ViewPager.OnPageChangeListener m;
    public CustomViewPager n;
    public a o;
    public FragmentAdapter p;
    public LinearLayout q;
    public View r;
    public View s;
    public int t;
    public int u;

    /* loaded from: classes8.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f46031a;

        /* renamed from: b  reason: collision with root package name */
        public List<b> f46032b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentManager, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46031a = -1;
            this.f46032b = list;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                try {
                    super.finishUpdate(viewGroup);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f46032b.size() : invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f46032b.get(i2).f46035c : (Fragment) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.f46032b.get(i2).f46035c.hashCode() : invokeI.longValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(@NonNull Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (obj != null && obj.equals(FragmentTabHost.v)) {
                    Fragment unused = FragmentTabHost.v = null;
                    return -2;
                }
                return super.getItemPosition(obj);
            }
            return invokeL.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048581, this, viewGroup, i2, obj) == null) {
                super.setPrimaryItem(viewGroup, i2, obj);
                int i3 = this.f46031a;
                if (i3 != i2) {
                    if (i3 != -1 && i3 < this.f46032b.size()) {
                        Fragment item = getItem(this.f46031a);
                        if (item instanceof BaseFragment) {
                            ((BaseFragment) item).setPrimary(false);
                        }
                    }
                    this.f46031a = i2;
                    if (obj instanceof BaseFragment) {
                        ((BaseFragment) obj).setPrimary(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface a {
        boolean onPreTabSelectionChange(int i2, boolean z);

        void onTabSelectionChanged(int i2, boolean z);
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f46033a;

        /* renamed from: b  reason: collision with root package name */
        public TbFragmentTabIndicator f46034b;

        /* renamed from: c  reason: collision with root package name */
        public Fragment f46035c;

        /* renamed from: d  reason: collision with root package name */
        public b.a.q0.h0.b f46036d;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-478895283, "Lcom/baidu/tbadk/core/tabHost/FragmentTabHost;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-478895283, "Lcom/baidu/tbadk/core/tabHost/FragmentTabHost;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentTabHost(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.MAIN_TAB_VIDEOCJHANNEL = -1;
        this.l = new ArrayList();
        this.m = null;
        this.t = 0;
        d(context);
    }

    public static String e(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            return "android:switcher:" + i2 + ":" + j;
        }
        return (String) invokeCommon.objValue;
    }

    public void addTabSpec(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            addTabSpec(bVar, -1);
        }
    }

    public final void c(int[] iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, iArr) == null) || iArr == null || iArr.length <= 0) {
            return;
        }
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = 0;
        }
    }

    public void changeStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            } else {
                layoutParams2.height = -2;
            }
            c(layoutParams.getRules());
            c(layoutParams2.getRules());
            if (i2 == 1) {
                layoutParams2.addRule(12, -1);
                layoutParams.addRule(12, -1);
                layoutParams.bottomMargin = 0;
                this.q.setVisibility(0);
            } else if (i2 == 0) {
                layoutParams2.addRule(10, -1);
                layoutParams.addRule(3, R.id.tabcontainer_wrapper);
                layoutParams.bottomMargin = 0;
                this.q.setVisibility(0);
            } else if (i2 == 2) {
                layoutParams2.addRule(12, -1);
                layoutParams.addRule(10, -1);
                layoutParams.bottomMargin = 0;
                this.q.setVisibility(0);
            } else if (i2 == 3) {
                layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.g(this.f46026e, R.dimen.ds88);
                this.q.setVisibility(0);
            } else if (i2 == 4) {
                layoutParams.addRule(10, -1);
                layoutParams.bottomMargin = 0;
                this.q.setVisibility(8);
            }
            this.n.setLayoutParams(layoutParams);
            this.q.setLayoutParams(layoutParams2);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.f46026e = context;
            LayoutInflater.from(context).inflate(R.layout.fragment_tabhost, (ViewGroup) this, true);
            this.q = (LinearLayout) findViewById(R.id.tabcontainer_wrapper);
            this.s = findViewById(R.id.tabcontainer_shadow);
            this.f46030i = -1;
            this.j = null;
        }
    }

    public Fragment getCurrentFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b bVar = this.j;
            if (bVar != null) {
                return bVar.f46035c;
            }
            return null;
        }
        return (Fragment) invokeV.objValue;
    }

    public int getCurrentTabIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f46030i : invokeV.intValue;
    }

    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i2 = this.f46030i;
            if (i2 < 0 || i2 >= this.l.size()) {
                return -1;
            }
            return this.l.get(this.f46030i).f46033a;
        }
        return invokeV.intValue;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f46027f : (FragmentTabWidget) invokeV.objValue;
    }

    public CustomViewPager getFragmentViewPager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.n : (CustomViewPager) invokeV.objValue;
    }

    public int getTabIndexByType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            for (int i3 = 0; i3 < this.l.size(); i3++) {
                if (i2 == this.l.get(i3).f46033a) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public b getTabSpec(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            if (i2 < 0 || i2 >= this.l.size()) {
                return null;
            }
            return this.l.get(i2);
        }
        return (b) invokeI.objValue;
    }

    public b getTabSpecByType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            for (b bVar : this.l) {
                if (i2 == bVar.f46033a) {
                    return bVar;
                }
            }
            return null;
        }
        return (b) invokeI.objValue;
    }

    public ViewGroup getTabWrapper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.q : (ViewGroup) invokeV.objValue;
    }

    public void hideTabWidget() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (linearLayout = this.q) == null || linearLayout.getVisibility() == 8) {
            return;
        }
        this.q.setVisibility(8);
    }

    public void initViewPager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            initViewPager(0);
        }
    }

    public void initViewPagerWithNoType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            CustomViewPager customViewPager = this.n;
            if (customViewPager != null) {
                removeView(customViewPager);
            }
            CustomViewPager customViewPager2 = new CustomViewPager(this.f46026e);
            this.n = customViewPager2;
            customViewPager2.setId(R.id.tab_content);
            addView(this.n);
            removeView(this.q);
            addView(this.q);
            this.n.setOffscreenPageLimit(this.l.size() - 1);
            this.n.setOnPageChangeListener(this);
            FragmentAdapter fragmentAdapter = new FragmentAdapter(this.k, this.l);
            this.p = fragmentAdapter;
            this.n.setAdapter(fragmentAdapter);
        }
    }

    public void isTabItemNeedPadding(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f46027f.isTabItemNeedPadding(z);
        }
    }

    public void makeIndicatorDarkSkin(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            if (z) {
                for (b bVar : this.l) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = bVar.f46034b;
                    if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                        MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
                        maintabBottomIndicator.makeDarkSkin(true);
                        maintabBottomIndicator.setSelected(bVar.f46034b.isSelected());
                    }
                }
                return;
            }
            for (b bVar2 : this.l) {
                TbFragmentTabIndicator tbFragmentTabIndicator2 = bVar2.f46034b;
                if (tbFragmentTabIndicator2 instanceof MaintabBottomIndicator) {
                    MaintabBottomIndicator maintabBottomIndicator2 = (MaintabBottomIndicator) tbFragmentTabIndicator2;
                    maintabBottomIndicator2.makeDarkSkin(false);
                    maintabBottomIndicator2.setSelected(bVar2.f46034b.isSelected());
                }
            }
        }
    }

    public void needShowTopDiver(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (this.r == null) {
                this.r = findViewById(R.id.topDvider);
            }
            if (!z) {
                this.r.setVisibility(8);
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f46027f;
            if (fragmentTabWidget != null) {
                fragmentTabWidget.setShouldDrawTopLine(false);
                ((FrameLayout.LayoutParams) this.f46027f.getLayoutParams()).gravity = 80;
            }
            int e2 = l.e(getContext(), 1.0f);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.r.getLayoutParams();
            layoutParams.gravity = 48;
            layoutParams.height = e2;
            this.r.setLayoutParams(layoutParams);
            this.r.setVisibility(0);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
        }
    }

    public void onChangeSkinType(int i2) {
        TbFragmentTabIndicator tbFragmentTabIndicator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f46027f.onChangeSkinType(i2);
            this.f46029h.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.s, R.drawable.bottom_view_shadow);
            for (b bVar : this.l) {
                if (bVar != null && (tbFragmentTabIndicator = bVar.f46034b) != null) {
                    tbFragmentTabIndicator.onChangeSkin(i2);
                    TbFragmentTabIndicator tbFragmentTabIndicator2 = bVar.f46034b;
                    tbFragmentTabIndicator2.setSelected(tbFragmentTabIndicator2.isSelected());
                }
            }
            FragmentAdapter fragmentAdapter = this.p;
            if (fragmentAdapter != null) {
                int count = fragmentAdapter.getCount();
                for (int i3 = 0; i3 < count; i3++) {
                    Fragment item = this.p.getItem(i3);
                    if (item instanceof BaseFragment) {
                        ((BaseFragment) item).changeSkinType(i2);
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || (onPageChangeListener = this.m) == null) {
            return;
        }
        onPageChangeListener.onPageScrollStateChanged(i2);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            this.f46027f.changeLeft(i2, f2);
            ViewPager.OnPageChangeListener onPageChangeListener = this.m;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i2, f2, i3);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            ViewPager.OnPageChangeListener onPageChangeListener = this.m;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i2);
            }
            if (TbSingleton.getInstance().isFromFeedVideoClick() && i2 == this.MAIN_TAB_VIDEOCJHANNEL) {
                i2 = MAIN_TAB_TOTAL;
            }
            this.f46030i = i2;
            this.j = this.l.get(i2);
            FragmentTabWidget fragmentTabWidget = this.f46027f;
            int i3 = this.f46030i;
            if (i3 == MAIN_TAB_TOTAL) {
                i3 = this.MAIN_TAB_VIDEOCJHANNEL;
            }
            fragmentTabWidget.setCurrentTab(i3, false, true);
            ViewGroup viewGroup = (ViewGroup) this.j.f46035c.getView();
            if (viewGroup == null || viewGroup.getChildCount() <= 0) {
                return;
            }
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).refreshMatrix(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
    public void onTabSelectionChanged(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.j = this.l.get(i2);
            a aVar = this.o;
            if (aVar == null || aVar.onPreTabSelectionChange(i2, z)) {
                tbSelectionChanged(i2, z);
            }
        }
    }

    public void refreshVideoFragment(boolean z, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048603, this, z, fragment) == null) {
            if (fragment != null) {
                v = fragment;
            }
            if (MAIN_TAB_TOTAL == -1) {
                MAIN_TAB_TOTAL = this.l.size();
            }
            if (this.MAIN_TAB_VIDEOCJHANNEL == -1) {
                this.MAIN_TAB_VIDEOCJHANNEL = getTabIndexByType(22);
            }
            try {
                if (z) {
                    b bVar = new b();
                    bVar.f46035c = fragment;
                    bVar.f46033a = 23;
                    if (this.l.size() == MAIN_TAB_TOTAL) {
                        this.l.add(bVar);
                    } else {
                        for (int i2 = MAIN_TAB_TOTAL; i2 < this.l.size(); i2++) {
                            this.l.remove(i2);
                        }
                        this.l.add(bVar);
                    }
                    this.p.notifyDataSetChanged();
                    return;
                }
                FragmentTransaction beginTransaction = this.k.beginTransaction();
                Fragment findFragmentByTag = this.k.findFragmentByTag(e(this.n.getId(), this.p.getItemId(MAIN_TAB_TOTAL)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                    beginTransaction.commit();
                    this.k.executePendingTransactions();
                    this.l.remove(MAIN_TAB_TOTAL);
                    this.p.notifyDataSetChanged();
                }
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || this.n == null || this.p == null) {
            return;
        }
        try {
            FragmentTransaction beginTransaction = this.k.beginTransaction();
            int size = this.l.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment findFragmentByTag = this.k.findFragmentByTag(e(this.n.getId(), this.p.getItemId(i2)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commit();
            this.k.executePendingTransactions();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
        for (b bVar : this.l) {
            b.a.q0.h0.b bVar2 = bVar.f46036d;
            if (bVar2 != null) {
                bVar2.onRemove();
            }
        }
        this.l.clear();
        this.j = null;
        this.f46030i = -1;
        this.f46027f.reset();
        v = null;
    }

    public void setAbsoluteWeight(boolean z) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || (fragmentTabWidget = this.f46027f) == null) {
            return;
        }
        fragmentTabWidget.setAbsoluteWeight(z);
    }

    public void setBackGroundStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.u = i2;
            FragmentTabWidget fragmentTabWidget = this.f46027f;
            if (fragmentTabWidget != null) {
                fragmentTabWidget.setBackGroundStyle(i2);
            }
        }
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048607, this, i2) == null) || i2 < 0 || i2 >= this.l.size()) {
            return;
        }
        if (TbSingleton.getInstance().isFromFeedVideoClick() && i2 == this.MAIN_TAB_VIDEOCJHANNEL) {
            i2 = MAIN_TAB_TOTAL;
        }
        if (i2 == this.f46030i) {
            return;
        }
        this.f46030i = i2;
        this.j = this.l.get(i2);
        FragmentTabWidget fragmentTabWidget = this.f46027f;
        int i3 = this.f46030i;
        if (i3 == MAIN_TAB_TOTAL) {
            i3 = this.MAIN_TAB_VIDEOCJHANNEL;
        }
        fragmentTabWidget.setCurrentTab(i3, true, false);
        CustomViewPager customViewPager = this.n;
        if (customViewPager != null) {
            customViewPager.setCurrentItem(this.f46030i, false);
        }
    }

    public void setCurrentTabByType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            int size = this.l.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                } else if (i2 == this.l.get(i3).f46033a) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 != -1) {
                tbSelectionChanged(i3, false);
            } else if (this.f46030i == -1) {
                tbSelectionChanged(0, false);
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onPageChangeListener) == null) {
            this.m = onPageChangeListener;
        }
    }

    public void setOnTabSelectionListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, aVar) == null) {
            this.o = aVar;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048612, this, z) == null) || (fragmentTabWidget = this.f46027f) == null) {
            return;
        }
        fragmentTabWidget.setShouldDrawDividerLine(z);
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048613, this, z) == null) || (fragmentTabWidget = this.f46027f) == null) {
            return;
        }
        fragmentTabWidget.setShouldDrawIndicatorLine(z);
    }

    public void setShouldDrawTopLine(boolean z) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048614, this, z) == null) || (fragmentTabWidget = this.f46027f) == null) {
            return;
        }
        fragmentTabWidget.setShouldDrawTopLine(z);
    }

    public void setTabContainerShadowShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.s.setVisibility(z ? 0 : 8);
        }
    }

    public void setTabWidgetBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.f46027f.setBackgroundColor(i2);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, pair) == null) {
            if (this.f46028g == null) {
                this.f46028g = new b.a.q0.s.f0.a(this, R.color.common_color_10274);
            }
            setShouldDrawIndicatorLine(false);
            setShouldDrawTopLine(false);
            needShowTopDiver(false);
            this.f46028g.e(pair);
        }
    }

    public void setTabWidgetViewHeight(int i2) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048619, this, i2) == null) || (fragmentTabWidget = this.f46027f) == null) {
            return;
        }
        fragmentTabWidget.getLayoutParams().height = i2;
        this.f46027f.requestLayout();
        this.q.getLayoutParams().height = i2;
        this.q.requestLayout();
        if (this.u == 1) {
            this.f46029h.getLayoutParams().height = i2;
            this.f46029h.requestLayout();
        }
    }

    public void setTabWidgetViewPadding(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048620, this, i2, i3, i4, i5) == null) {
            this.f46027f.setPadding(i2, i3, i4, i5);
        }
    }

    public void setUIType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048621, this, i2) == null) || this.t == i2) {
            return;
        }
        this.t = i2;
        if (i2 == 1) {
            setShouldDrawTopLine(false);
            needShowTopDiver(false);
        } else if (i2 == 0) {
            setShouldDrawTopLine(true);
            needShowTopDiver(true);
        }
    }

    public void setViewPagerScrollable(boolean z) {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048622, this, z) == null) || (customViewPager = this.n) == null) {
            return;
        }
        customViewPager.setScrollable(z);
    }

    public void setup(FragmentManager fragmentManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, fragmentManager) == null) {
            this.k = fragmentManager;
            this.f46027f = (FragmentTabWidget) findViewById(R.id.tabcontainer);
            this.f46029h = (FragmentTabSwellingView) findViewById(R.id.tab_swelling_view);
            this.f46027f.setTabSelectionListener(this);
        }
    }

    public void showTabWidget() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || (linearLayout = this.q) == null || linearLayout.getVisibility() == 0) {
            return;
        }
        this.q.setVisibility(0);
    }

    public void tbSelectionChanged(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            a aVar = this.o;
            if (aVar != null) {
                aVar.onTabSelectionChanged(i2, z);
            }
            setCurrentTab(i2);
        }
    }

    public void addTabSpec(b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, i2) == null) {
            if (bVar.f46034b != null) {
                if (bVar.f46035c != null) {
                    if (this.l.contains(bVar)) {
                        return;
                    }
                    b.a.q0.h0.b bVar2 = bVar.f46036d;
                    if (bVar2 != null) {
                        bVar2.onAdd();
                    }
                    this.f46027f.addView(bVar.f46034b, i2);
                    if (i2 == -1) {
                        this.l.add(bVar);
                    } else {
                        this.l.add(i2, bVar);
                    }
                    int i3 = this.f46030i;
                    if (i3 == -1 || i2 > i3) {
                        return;
                    }
                    this.f46030i = i3 + 1;
                    return;
                }
                throw new IllegalArgumentException("you must create the tab content");
            }
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
    }

    public void initViewPager(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            CustomViewPager customViewPager = this.n;
            if (customViewPager != null) {
                removeView(customViewPager);
            }
            CustomViewPager customViewPager2 = new CustomViewPager(this.f46026e);
            this.n = customViewPager2;
            customViewPager2.setId(R.id.tab_content);
            changeStyle(i2);
            addView(this.n);
            removeView(this.q);
            addView(this.q);
            removeView(this.s);
            addView(this.s);
            this.n.setOffscreenPageLimit(this.l.size() - 1);
            this.n.setOnPageChangeListener(this);
            FragmentAdapter fragmentAdapter = new FragmentAdapter(this.k, this.l);
            this.p = fragmentAdapter;
            this.n.setAdapter(fragmentAdapter);
        }
    }

    public void setShouldDrawTopLine(boolean z, int i2) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (fragmentTabWidget = this.f46027f) == null) {
            return;
        }
        fragmentTabWidget.setShouldDrawTopLine(z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.MAIN_TAB_VIDEOCJHANNEL = -1;
        this.l = new ArrayList();
        this.m = null;
        this.t = 0;
        d(context);
    }

    public void addTabSpec(b bVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (bVar.f46034b != null) {
                if (bVar.f46035c != null) {
                    if (this.l.contains(bVar)) {
                        return;
                    }
                    b.a.q0.h0.b bVar2 = bVar.f46036d;
                    if (bVar2 != null) {
                        bVar2.onAdd();
                    }
                    this.f46027f.addView(bVar.f46034b, i2, z);
                    if (i2 == -1) {
                        this.l.add(bVar);
                    } else {
                        this.l.add(i2, bVar);
                    }
                    int i3 = this.f46030i;
                    if (i3 == -1 || i2 > i3) {
                        return;
                    }
                    this.f46030i = i3 + 1;
                    return;
                }
                throw new IllegalArgumentException("you must create the tab content");
            }
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
    }
}
