package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.fj;
import com.baidu.tieba.p95;
import com.baidu.tieba.vx4;
import com.baidu.tieba.zp8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FragmentTabHost extends RelativeLayout implements FragmentTabWidget.b, ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public FragmentTabWidget b;
    public vx4 c;
    public FragmentTabSwellingView d;
    public int e;
    public b f;
    public FragmentManager g;
    public final List h;
    public ViewPager.OnPageChangeListener i;
    public CustomViewPager j;
    public a k;
    public FragmentAdapter l;
    public LinearLayout m;
    public View n;
    public View o;
    public int p;
    public String q;
    public boolean r;
    public int s;

    /* loaded from: classes3.dex */
    public interface a {
        boolean onPreTabSelectionChange(int i, boolean z);

        void onTabSelectionChanged(int i, boolean z);
    }

    public void setNeedShowThemeStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class FragmentAdapter extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public List b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FragmentAdapter(FragmentManager fragmentManager, List list) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentManager, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = -1;
            this.b = list;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                try {
                    super.finishUpdate(viewGroup);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return ((b) this.b.get(i)).c;
            }
            return (Fragment) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                return ((b) this.b.get(i)).c.hashCode();
            }
            return invokeI.longValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                return super.getItemPosition(obj);
            }
            return invokeL.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048581, this, viewGroup, i, obj) == null) {
                super.setPrimaryItem(viewGroup, i, obj);
                int i2 = this.a;
                if (i2 != i) {
                    if (i2 != -1 && i2 < this.b.size()) {
                        Fragment item = getItem(this.a);
                        if (item instanceof BaseFragment) {
                            ((BaseFragment) item).setPrimary(false);
                        }
                    }
                    this.a = i;
                    if (obj instanceof BaseFragment) {
                        ((BaseFragment) obj).setPrimary(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public TbFragmentTabIndicator b;
        public Fragment c;
        public p95 d;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
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
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new ArrayList();
        this.i = null;
        this.p = 0;
        this.r = false;
        i(context);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            ViewPager.OnPageChangeListener onPageChangeListener = this.i;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i);
            }
            this.e = i;
            this.f = (b) this.h.get(i);
            this.b.setCurrentTab(this.e, false, true);
            ViewGroup viewGroup = (ViewGroup) this.f.c.getView();
            if (viewGroup != null && viewGroup.getChildCount() > 0) {
                View childAt = viewGroup.getChildAt(0);
                if (childAt instanceof FragmentTabRootView) {
                    ((FragmentTabRootView) childAt).b(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = new ArrayList();
        this.i = null;
        this.p = 0;
        this.r = false;
        i(context);
    }

    public void b(b bVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, i) == null) {
            if (bVar.b != null) {
                if (bVar.c != null) {
                    if (this.h.contains(bVar)) {
                        return;
                    }
                    p95 p95Var = bVar.d;
                    if (p95Var != null) {
                        p95Var.e();
                    }
                    this.b.addView(bVar.b, i);
                    if (i == -1) {
                        this.h.add(bVar);
                    } else {
                        this.h.add(i, bVar);
                    }
                    int i2 = this.e;
                    if (i2 != -1 && i <= i2) {
                        this.e = i2 + 1;
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("you must create the tab content");
            }
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
    }

    public static String m(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return "android:switcher:" + i + ":" + j;
        }
        return (String) invokeCommon.objValue;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
    public void onTabSelectionChanged(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.f = (b) this.h.get(i);
            a aVar = this.k;
            if (aVar != null && !aVar.onPreTabSelectionChange(i, z)) {
                return;
            }
            t(i, z);
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            b(bVar, -1);
        }
    }

    public final void e(int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, iArr) == null) && iArr != null && iArr.length > 0) {
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = 0;
            }
        }
    }

    public b f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i >= 0 && i < this.h.size()) {
                return (b) this.h.get(i);
            }
            return null;
        }
        return (b) invokeI.objValue;
    }

    public b g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            for (b bVar : this.h) {
                if (i == bVar.a) {
                    return bVar;
                }
            }
            return null;
        }
        return (b) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048596, this, i) == null) && (onPageChangeListener = this.i) != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    public void setAbsoluteWeight(boolean z) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048604, this, z) == null) && (fragmentTabWidget = this.b) != null) {
            fragmentTabWidget.setAbsoluteWeight(z);
        }
    }

    public void setBackGroundStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.s = i;
            FragmentTabWidget fragmentTabWidget = this.b;
            if (fragmentTabWidget != null) {
                fragmentTabWidget.setBackGroundStyle(i);
            }
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.q = str;
            FragmentTabWidget fragmentTabWidget = this.b;
            if (fragmentTabWidget != null) {
                fragmentTabWidget.setForumId(str);
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onPageChangeListener) == null) {
            this.i = onPageChangeListener;
        }
    }

    public void setOnTabSelectionListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, aVar) == null) {
            this.k = aVar;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048612, this, z) == null) && (fragmentTabWidget = this.b) != null) {
            fragmentTabWidget.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048613, this, z) == null) && (fragmentTabWidget = this.b) != null) {
            fragmentTabWidget.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048614, this, z) == null) && (fragmentTabWidget = this.b) != null) {
            fragmentTabWidget.setShouldDrawTopLine(z);
        }
    }

    public void setTabContainerShadowShow(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            View view2 = this.o;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.b.setBackgroundColor(i);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, pair) == null) {
            if (this.c == null) {
                this.c = new vx4(this, R.color.common_color_10274);
            }
            setShouldDrawIndicatorLine(false);
            setShouldDrawTopLine(false);
            o(false);
            this.c.e(pair);
        }
    }

    public void setUIType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048621, this, i) != null) || this.p == i) {
            return;
        }
        this.p = i;
        if (i == 1) {
            setShouldDrawTopLine(false);
            o(false);
        } else if (i == 0) {
            setShouldDrawTopLine(true);
            o(true);
        }
    }

    public void setViewPagerScrollable(boolean z) {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048622, this, z) == null) && (customViewPager = this.j) != null) {
            customViewPager.setScrollable(z);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, fragmentManager) == null) {
            this.g = fragmentManager;
            this.b = (FragmentTabWidget) findViewById(R.id.obfuscated_res_0x7f092029);
            this.d = (FragmentTabSwellingView) findViewById(R.id.obfuscated_res_0x7f092021);
            this.b.setTabSelectionListener(this);
        }
    }

    public void c(b bVar, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (bVar.b != null) {
                if (bVar.c != null) {
                    if (this.h.contains(bVar)) {
                        return;
                    }
                    p95 p95Var = bVar.d;
                    if (p95Var != null) {
                        p95Var.e();
                    }
                    this.b.c(bVar.b, i, z);
                    if (i == -1) {
                        this.h.add(bVar);
                    } else {
                        this.h.add(i, bVar);
                    }
                    int i2 = this.e;
                    if (i2 != -1 && i <= i2) {
                        this.e = i2 + 1;
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("you must create the tab content");
            }
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            } else {
                layoutParams2.height = -2;
            }
            e(layoutParams.getRules());
            e(layoutParams2.getRules());
            if (i == 1) {
                layoutParams2.addRule(12, -1);
                layoutParams.addRule(12, -1);
                layoutParams.bottomMargin = 0;
                this.m.setVisibility(0);
            } else if (i == 0) {
                layoutParams2.addRule(10, -1);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f09202b);
                layoutParams.bottomMargin = 0;
                this.m.setVisibility(0);
            } else if (i == 2) {
                layoutParams2.addRule(12, -1);
                layoutParams.addRule(10, -1);
                layoutParams.bottomMargin = 0;
                this.m.setVisibility(0);
            } else if (i == 3) {
                layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + fj.f(this.a, R.dimen.obfuscated_res_0x7f070306);
                this.m.setVisibility(0);
            } else if (i == 4) {
                layoutParams.addRule(10, -1);
                layoutParams.bottomMargin = 0;
                this.m.setVisibility(8);
            }
            this.j.setLayoutParams(layoutParams);
            this.m.setLayoutParams(layoutParams2);
        }
    }

    public Fragment getCurrentFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b bVar = this.f;
            if (bVar != null) {
                return bVar.c;
            }
            return null;
        }
        return (Fragment) invokeV.objValue;
    }

    public int getCurrentTabIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i = this.e;
            if (i >= 0 && i < this.h.size()) {
                return ((b) this.h.get(this.e)).a;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.b;
        }
        return (FragmentTabWidget) invokeV.objValue;
    }

    public CustomViewPager getFragmentViewPager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.j;
        }
        return (CustomViewPager) invokeV.objValue;
    }

    public ViewGroup getTabWrapper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.m;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public void h() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (linearLayout = this.m) != null && linearLayout.getVisibility() != 8) {
            this.m.setVisibility(8);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            k(0);
        }
    }

    public void r() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (linearLayout = this.m) != null && linearLayout.getVisibility() != 0) {
            this.m.setVisibility(0);
        }
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            this.a = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02e7, (ViewGroup) this, true);
            this.m = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09202b);
            this.o = findViewById(R.id.obfuscated_res_0x7f09202a);
            this.e = -1;
            this.f = null;
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048603, this, i) != null) || this.q == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FRS_BOTTOM_BAR_TAB_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.q).param("obj_param1", i));
    }

    public void setCurrentTab(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048606, this, i) != null) || i < 0 || i >= this.h.size() || i == this.e) {
            return;
        }
        this.e = i;
        this.f = (b) this.h.get(i);
        this.b.setCurrentTab(this.e, true, false);
        CustomViewPager customViewPager = this.j;
        if (customViewPager != null) {
            customViewPager.setCurrentItem(this.e, false);
        }
    }

    public void setCurrentTabByType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            int size = this.h.size();
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    if (i == ((b) this.h.get(i2)).a) {
                        break;
                    }
                    i2++;
                } else {
                    i2 = -1;
                    break;
                }
            }
            if (i2 != -1) {
                t(i2, false);
            } else if (this.e == -1) {
                t(0, false);
            }
        }
    }

    public void setTabWidgetViewHeight(int i) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048619, this, i) != null) || (fragmentTabWidget = this.b) == null) {
            return;
        }
        fragmentTabWidget.getLayoutParams().height = i;
        this.b.requestLayout();
        this.m.getLayoutParams().height = i;
        this.m.requestLayout();
        if (this.s == 1) {
            this.d.getLayoutParams().height = i;
            this.d.requestLayout();
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            CustomViewPager customViewPager = this.j;
            if (customViewPager != null) {
                removeView(customViewPager);
            }
            CustomViewPager customViewPager2 = new CustomViewPager(this.a);
            this.j = customViewPager2;
            customViewPager2.setId(R.id.obfuscated_res_0x7f09200e);
            zp8.c(this.j, 2);
            d(i);
            addView(this.j);
            removeView(this.m);
            addView(this.m);
            removeView(this.o);
            addView(this.o);
            this.j.setOffscreenPageLimit(this.h.size() - 1);
            this.j.setOnPageChangeListener(this);
            FragmentAdapter fragmentAdapter = new FragmentAdapter(this.g, this.h);
            this.l = fragmentAdapter;
            this.j.setAdapter(fragmentAdapter);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048594, this, z) != null) || this.r == z) {
            return;
        }
        this.r = z;
        if (z) {
            for (b bVar : this.h) {
                TbFragmentTabIndicator tbFragmentTabIndicator = bVar.b;
                if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                    MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
                    maintabBottomIndicator.r(true);
                    maintabBottomIndicator.setSelected(bVar.b.isSelected());
                }
            }
            return;
        }
        for (b bVar2 : this.h) {
            TbFragmentTabIndicator tbFragmentTabIndicator2 = bVar2.b;
            if (tbFragmentTabIndicator2 instanceof MaintabBottomIndicator) {
                MaintabBottomIndicator maintabBottomIndicator2 = (MaintabBottomIndicator) tbFragmentTabIndicator2;
                maintabBottomIndicator2.r(false);
                maintabBottomIndicator2.setSelected(bVar2.b.isSelected());
            }
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            if (this.n == null) {
                this.n = findViewById(R.id.obfuscated_res_0x7f092273);
            }
            if (!z) {
                this.n.setVisibility(8);
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.b;
            if (fragmentTabWidget != null) {
                fragmentTabWidget.setShouldDrawTopLine(false);
                ((FrameLayout.LayoutParams) this.b.getLayoutParams()).gravity = 80;
            }
            int d = fj.d(getContext(), 1.0f);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.gravity = 48;
            layoutParams.height = d;
            this.n.setLayoutParams(layoutParams);
            this.n.setVisibility(0);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0204);
        }
    }

    public void p(int i) {
        TbFragmentTabIndicator tbFragmentTabIndicator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.b.i(i);
            this.d.b(i);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.o, R.drawable.bottom_view_shadow);
            for (b bVar : this.h) {
                if (bVar != null && (tbFragmentTabIndicator = bVar.b) != null) {
                    tbFragmentTabIndicator.e(i);
                    TbFragmentTabIndicator tbFragmentTabIndicator2 = bVar.b;
                    tbFragmentTabIndicator2.setSelected(tbFragmentTabIndicator2.isSelected());
                }
            }
            FragmentAdapter fragmentAdapter = this.l;
            if (fragmentAdapter != null) {
                int count = fragmentAdapter.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    Fragment item = this.l.getItem(i2);
                    if (item instanceof BaseFragment) {
                        ((BaseFragment) item).changeSkinType(i);
                    }
                }
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            CustomViewPager customViewPager = this.j;
            if (customViewPager != null) {
                removeView(customViewPager);
            }
            CustomViewPager customViewPager2 = new CustomViewPager(this.a);
            this.j = customViewPager2;
            customViewPager2.setId(R.id.obfuscated_res_0x7f09200e);
            addView(this.j);
            removeView(this.m);
            addView(this.m);
            this.j.setOffscreenPageLimit(this.h.size() - 1);
            this.j.setOnPageChangeListener(this);
            FragmentAdapter fragmentAdapter = new FragmentAdapter(this.g, this.h);
            this.l = fragmentAdapter;
            this.j.setAdapter(fragmentAdapter);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            this.b.d(i, f);
            ViewPager.OnPageChangeListener onPageChangeListener = this.i;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f, i2);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.j != null && this.l != null) {
            try {
                FragmentTransaction beginTransaction = this.g.beginTransaction();
                int size = this.h.size();
                for (int i = 0; i < size; i++) {
                    Fragment findFragmentByTag = this.g.findFragmentByTag(m(this.j.getId(), this.l.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commit();
                this.g.executePendingTransactions();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
            for (b bVar : this.h) {
                p95 p95Var = bVar.d;
                if (p95Var != null) {
                    p95Var.f();
                }
            }
            this.h.clear();
            this.f = null;
            this.e = -1;
            this.b.j();
        }
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (fragmentTabWidget = this.b) != null) {
            fragmentTabWidget.setShouldDrawTopLine(z);
        }
    }

    public void t(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            a aVar = this.k;
            if (aVar != null) {
                aVar.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048620, this, i, i2, i3, i4) == null) {
            this.b.setPadding(i, i2, i3, i4);
        }
    }
}
