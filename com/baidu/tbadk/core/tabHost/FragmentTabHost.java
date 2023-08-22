package com.baidu.tbadk.core.tabHost;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mainTab.FragmentDelegate;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.kia;
import com.baidu.tieba.kn5;
import com.baidu.tieba.lia;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FragmentTabHost extends RelativeLayout implements FragmentTabWidget.a, ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public FragmentTabWidget b;
    public TbImageView c;
    public int d;
    public c e;
    public FragmentManager f;
    public final List<c> g;
    public ViewPager.OnPageChangeListener h;
    public CustomViewPager i;
    public b j;
    public FragmentAdapter k;
    public LinearLayout l;
    public View m;
    public View n;
    public int o;
    public String p;
    public boolean q;
    public int r;
    public kn5 s;
    public CustomMessageListener t;

    /* loaded from: classes4.dex */
    public interface b {
        boolean onPreTabSelectionChange(int i, boolean z);

        void onTabSelectionChanged(int i, boolean z);
    }

    /* loaded from: classes4.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public List<c> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FragmentAdapter(FragmentManager fragmentManager, List<c> list) {
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
                return this.b.get(i).c;
            }
            return (Fragment) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                return this.b.get(i).c.hashCode();
            }
            return invokeI.longValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(@NonNull Object obj) {
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

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FragmentTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FragmentTabHost fragmentTabHost, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentTabHost, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fragmentTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.r != 0 && customResponsedMessage.getCmd() == 2921338) {
                this.a.t();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public TbFragmentTabIndicator b;
        public Fragment c;
        public FragmentDelegate d;

        public c() {
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
        this.g = new ArrayList();
        this.h = null;
        this.o = 0;
        this.q = false;
        this.t = new a(this, 2921338);
        i(context);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            this.a = context;
            LayoutInflater.from(context).inflate(R.layout.fragment_tabhost, (ViewGroup) this, true);
            this.l = (LinearLayout) findViewById(R.id.tabcontainer_wrapper);
            this.n = findViewById(R.id.tabcontainer_shadow);
            this.d = -1;
            this.e = null;
            TbPageContext currentPageContext = TbadkApplication.getInst().getCurrentPageContext(context);
            if (currentPageContext != null) {
                this.t.setTag(currentPageContext.getUniqueId());
            }
            MessageManager.getInstance().registerListener(this.t);
        }
    }

    public void m(kn5 kn5Var) {
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, kn5Var) == null) {
            this.s = kn5Var;
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                b2 = kn5Var.a();
            } else {
                b2 = kn5Var.b();
            }
            if (this.c != null && StringUtils.isNotNull(b2)) {
                this.c.setVisibility(0);
                this.c.setUseNightOrDarkMask(false);
                this.c.startLoad(b2, 45, false);
                FragmentTabWidget fragmentTabWidget = this.b;
                if (fragmentTabWidget != null) {
                    fragmentTabWidget.setDynamicStyleData(kn5Var);
                    this.b.i(false, R.color.transparent);
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            ViewPager.OnPageChangeListener onPageChangeListener = this.h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i);
            }
            this.d = i;
            this.e = (c) ListUtils.getItem(this.g, i);
            this.b.setCurrentTab(this.d, false, true);
            c cVar = this.e;
            if (cVar != null && (viewGroup = (ViewGroup) cVar.c.getView()) != null && viewGroup.getChildCount() > 0) {
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
        this.g = new ArrayList();
        this.h = null;
        this.o = 0;
        this.q = false;
        this.t = new a(this, 2921338);
        i(context);
    }

    public void c(c cVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, i) == null) {
            if (cVar.b != null) {
                if (cVar.c != null) {
                    if (this.g.contains(cVar)) {
                        return;
                    }
                    FragmentDelegate fragmentDelegate = cVar.d;
                    if (fragmentDelegate != null) {
                        fragmentDelegate.onAdd();
                    }
                    this.b.addView(cVar.b, i);
                    if (i == -1) {
                        this.g.add(cVar);
                    } else {
                        this.g.add(i, cVar);
                    }
                    int i2 = this.d;
                    if (i2 != -1 && i <= i2) {
                        this.d = i2 + 1;
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("you must create the tab content");
            }
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
    }

    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            c(cVar, -1);
        }
    }

    public final void f(int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, iArr) == null) && iArr != null && iArr.length > 0) {
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = 0;
            }
        }
    }

    public c g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i >= 0 && i < this.g.size()) {
                return this.g.get(i);
            }
            return null;
        }
        return (c) invokeI.objValue;
    }

    public c h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            for (c cVar : this.g) {
                if (i == cVar.a) {
                    return cVar;
                }
            }
            return null;
        }
        return (c) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048596, this, i) == null) && (onPageChangeListener = this.h) != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048600, this, z) != null) || this.q == z) {
            return;
        }
        this.q = z;
        o();
    }

    public void setAbsoluteWeight(boolean z) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048604, this, z) == null) && (fragmentTabWidget = this.b) != null) {
            fragmentTabWidget.setAbsoluteWeight(z);
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.p = str;
            FragmentTabWidget fragmentTabWidget = this.b;
            if (fragmentTabWidget != null) {
                fragmentTabWidget.setForumId(str);
            }
        }
    }

    public void setFrsBottomBarCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.r = i;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onPageChangeListener) == null) {
            this.h = onPageChangeListener;
        }
    }

    public void setOnTabSelectionListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bVar) == null) {
            this.j = bVar;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048611, this, z) == null) && (fragmentTabWidget = this.b) != null) {
            fragmentTabWidget.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048612, this, z) == null) && (fragmentTabWidget = this.b) != null) {
            fragmentTabWidget.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048613, this, z) == null) && (fragmentTabWidget = this.b) != null) {
            fragmentTabWidget.setShouldDrawTopLine(z);
        }
    }

    public void setTabContainerShadowShow(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            View view2 = this.n;
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
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.b.setBackgroundColor(i);
        }
    }

    public void setUIType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048617, this, i) != null) || this.o == i) {
            return;
        }
        this.o = i;
        if (i == 1) {
            setShouldDrawTopLine(false);
            q(false);
        } else if (i == 0) {
            setShouldDrawTopLine(true);
            q(true);
        }
    }

    public void setViewPagerScrollable(boolean z) {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048618, this, z) == null) && (customViewPager = this.i) != null) {
            customViewPager.setScrollable(z);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, fragmentManager) == null) {
            this.f = fragmentManager;
            this.b = (FragmentTabWidget) findViewById(R.id.obfuscated_res_0x7f092391);
            this.c = (TbImageView) findViewById(R.id.tabcontainer_dynamic_bg_img);
            this.b.setTabSelectionListener(this);
        }
    }

    public static String n(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return "android:switcher:" + i + ":" + j;
        }
        return (String) invokeCommon.objValue;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void onTabSelectionChanged(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.e = (c) ListUtils.getItem(this.g, i);
            b bVar = this.j;
            if (bVar != null && !bVar.onPreTabSelectionChange(i, z)) {
                return;
            }
            u(i, z);
        }
    }

    public void d(c cVar, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{cVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (cVar.b != null) {
                if (cVar.c != null) {
                    if (this.g.contains(cVar)) {
                        return;
                    }
                    FragmentDelegate fragmentDelegate = cVar.d;
                    if (fragmentDelegate != null) {
                        fragmentDelegate.onAdd();
                    }
                    this.b.c(cVar.b, i, z);
                    if (i == -1) {
                        this.g.add(cVar);
                    } else {
                        this.g.add(i, cVar);
                    }
                    int i2 = this.d;
                    if (i2 != -1 && i <= i2) {
                        this.d = i2 + 1;
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("you must create the tab content");
            }
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            } else {
                layoutParams2.height = -2;
            }
            f(layoutParams.getRules());
            f(layoutParams2.getRules());
            if (i == 1) {
                layoutParams2.addRule(12, -1);
                layoutParams.addRule(12, -1);
                layoutParams.bottomMargin = 0;
                this.l.setVisibility(0);
            } else if (i == 0) {
                layoutParams2.addRule(10, -1);
                layoutParams.addRule(3, R.id.tabcontainer_wrapper);
                layoutParams.bottomMargin = 0;
                this.l.setVisibility(0);
            } else if (i == 2) {
                layoutParams2.addRule(12, -1);
                layoutParams.addRule(10, -1);
                layoutParams.bottomMargin = 0;
                this.l.setVisibility(0);
            } else if (i == 3) {
                layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + BdUtilHelper.getDimens(this.a, R.dimen.obfuscated_res_0x7f070420);
                this.l.setVisibility(0);
            } else if (i == 4) {
                layoutParams.addRule(10, -1);
                layoutParams.bottomMargin = 0;
                this.l.setVisibility(8);
            }
            this.i.setLayoutParams(layoutParams);
            this.l.setLayoutParams(layoutParams2);
        }
    }

    public Fragment getCurrentFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c cVar = this.e;
            if (cVar != null) {
                return cVar.c;
            }
            return null;
        }
        return (Fragment) invokeV.objValue;
    }

    public int getCurrentTabIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i = this.d;
            if (i >= 0 && i < this.g.size()) {
                return this.g.get(this.d).a;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.b;
        }
        return (FragmentTabWidget) invokeV.objValue;
    }

    public CustomViewPager getFragmentViewPager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.i;
        }
        return (CustomViewPager) invokeV.objValue;
    }

    public ViewGroup getTabWrapper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public TbImageView getTabcontainerDynamicBgImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.c;
        }
        return (TbImageView) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.s = null;
            TbImageView tbImageView = this.c;
            if (tbImageView != null) {
                tbImageView.setVisibility(8);
            }
            FragmentTabWidget fragmentTabWidget = this.b;
            if (fragmentTabWidget != null) {
                fragmentTabWidget.setDynamicStyleData(null);
                this.b.i(false, R.color.CAM_X0207);
            }
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            kia.a("FragmentTabHost initViewPager");
            CustomViewPager customViewPager = this.i;
            if (customViewPager != null) {
                customViewPager.setOnPageChangeListener(null);
                this.i.setAdapter(null);
                removeView(this.i);
            }
            CustomViewPager customViewPager2 = new CustomViewPager(this.a);
            this.i = customViewPager2;
            customViewPager2.setId(R.id.tab_content);
            lia.c(this.i, 2);
            e(i);
            addView(this.i);
            removeView(this.l);
            addView(this.l);
            removeView(this.n);
            addView(this.n);
            this.i.setOffscreenPageLimit(this.g.size() - 1);
            this.i.setOnPageChangeListener(this);
            FragmentAdapter fragmentAdapter = new FragmentAdapter(this.f, this.g);
            this.k = fragmentAdapter;
            this.i.setAdapter(fragmentAdapter);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            if (this.m == null) {
                this.m = findViewById(R.id.obfuscated_res_0x7f09260a);
            }
            if (!z) {
                this.m.setVisibility(8);
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.b;
            if (fragmentTabWidget != null) {
                fragmentTabWidget.setShouldDrawTopLine(false);
                ((FrameLayout.LayoutParams) this.b.getLayoutParams()).gravity = 80;
            }
            int dip2px = BdUtilHelper.dip2px(getContext(), 1.0f);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.gravity = 48;
            layoutParams.height = dip2px;
            this.m.setLayoutParams(layoutParams);
            this.m.setVisibility(0);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
        }
    }

    public void r(int i) {
        TbFragmentTabIndicator tbFragmentTabIndicator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.b.j(i);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.n, R.drawable.bottom_view_shadow);
            for (c cVar : this.g) {
                if (cVar != null && (tbFragmentTabIndicator = cVar.b) != null) {
                    tbFragmentTabIndicator.onChangeSkin(i);
                    TbFragmentTabIndicator tbFragmentTabIndicator2 = cVar.b;
                    tbFragmentTabIndicator2.setSelected(tbFragmentTabIndicator2.isSelected());
                }
            }
            FragmentAdapter fragmentAdapter = this.k;
            if (fragmentAdapter != null) {
                int count = fragmentAdapter.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    Fragment item = this.k.getItem(i2);
                    if (item instanceof BaseFragment) {
                        ((BaseFragment) item).changeSkinType(i);
                    }
                }
            }
            kn5 kn5Var = this.s;
            if (kn5Var != null) {
                m(kn5Var);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            kia.a("FragmentTabHost initViewPagerWithNoType");
            CustomViewPager customViewPager = this.i;
            if (customViewPager != null) {
                removeView(customViewPager);
            }
            CustomViewPager customViewPager2 = new CustomViewPager(this.a);
            this.i = customViewPager2;
            customViewPager2.setId(R.id.tab_content);
            addView(this.i);
            removeView(this.l);
            addView(this.l);
            this.i.setOffscreenPageLimit(this.g.size() - 1);
            this.i.setOnPageChangeListener(this);
            FragmentAdapter fragmentAdapter = new FragmentAdapter(this.f, this.g);
            this.k = fragmentAdapter;
            this.i.setAdapter(fragmentAdapter);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            for (c cVar : this.g) {
                TbFragmentTabIndicator tbFragmentTabIndicator = cVar.b;
                if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                    MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
                    maintabBottomIndicator.k(this.q, this.s);
                    maintabBottomIndicator.setSelected(cVar.b.isSelected());
                }
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && this.p != null && this.r != 0) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FRS_BOTTOM_BAR_TAB_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.p).param("obj_param1", this.r));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            this.b.e(i, f);
            ViewPager.OnPageChangeListener onPageChangeListener = this.h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f, i2);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.i != null && this.k != null) {
            try {
                FragmentTransaction beginTransaction = this.f.beginTransaction();
                int size = this.g.size();
                for (int i = 0; i < size; i++) {
                    Fragment findFragmentByTag = this.f.findFragmentByTag(n(this.i.getId(), this.k.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commit();
                this.f.executePendingTransactions();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
            for (c cVar : this.g) {
                FragmentDelegate fragmentDelegate = cVar.d;
                if (fragmentDelegate != null) {
                    fragmentDelegate.onRemove();
                }
            }
            this.g.clear();
            this.e = null;
            this.d = -1;
            this.b.l();
        }
    }

    public void setCurrentTab(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048605, this, i) != null) || i < 0 || i >= this.g.size() || i == this.d) {
            return;
        }
        this.d = i;
        this.e = (c) ListUtils.getItem(this.g, i);
        this.b.setCurrentTab(this.d, true, false);
        CustomViewPager customViewPager = this.i;
        if (customViewPager != null) {
            customViewPager.setCurrentItem(this.d, false);
        }
    }

    public void setCurrentTabByType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            int size = this.g.size();
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    if (i == this.g.get(i2).a) {
                        break;
                    }
                    i2++;
                } else {
                    i2 = -1;
                    break;
                }
            }
            if (i2 != -1) {
                u(i2, false);
            } else if (this.d == -1) {
                u(0, false);
            }
        }
    }

    public void setTabWidgetViewHeight(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048616, this, i) != null) || this.b == null) {
            return;
        }
        kia.a("FragmentTabHost setTabWidgetViewHeight height:" + i);
        this.b.getLayoutParams().height = i;
        this.b.requestLayout();
        this.l.getLayoutParams().height = i;
        this.l.requestLayout();
    }

    public void u(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            b bVar = this.j;
            if (bVar != null) {
                bVar.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }
}
