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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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
import com.repackage.pi;
import com.repackage.q55;
import com.repackage.vk8;
import com.repackage.zt4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FragmentTabHost extends RelativeLayout implements FragmentTabWidget.b, ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int s = -1;
    public static Fragment t;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Context b;
    public FragmentTabWidget c;
    public zt4 d;
    public FragmentTabSwellingView e;
    public int f;
    public b g;
    public FragmentManager h;
    public final List<b> i;
    public ViewPager.OnPageChangeListener j;
    public CustomViewPager k;
    public a l;
    public FragmentAdapter m;
    public LinearLayout n;
    public View o;
    public View p;
    public int q;
    public int r;

    /* loaded from: classes3.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public List<b> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
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

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b.size() : invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? this.b.get(i).c : (Fragment) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? this.b.get(i).c.hashCode() : invokeI.longValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(@NonNull Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (obj != null && obj.equals(FragmentTabHost.t)) {
                    Fragment unused = FragmentTabHost.t = null;
                    return -2;
                }
                return super.getItemPosition(obj);
            }
            return invokeL.intValue;
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
    public interface a {
        boolean onPreTabSelectionChange(int i, boolean z);

        void onTabSelectionChanged(int i, boolean z);
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public TbFragmentTabIndicator b;
        public Fragment c;
        public q55 d;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.i = new ArrayList();
        this.j = null;
        this.q = 0;
        l(context);
    }

    public static String p(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return "android:switcher:" + i + ":" + j;
        }
        return (String) invokeCommon.objValue;
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            d(bVar, -1);
        }
    }

    public void d(b bVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, i) == null) {
            if (bVar.b != null) {
                if (bVar.c != null) {
                    if (this.i.contains(bVar)) {
                        return;
                    }
                    q55 q55Var = bVar.d;
                    if (q55Var != null) {
                        q55Var.e();
                    }
                    this.c.addView(bVar.b, i);
                    if (i == -1) {
                        this.i.add(bVar);
                    } else {
                        this.i.add(i, bVar);
                    }
                    int i2 = this.f;
                    if (i2 == -1 || i > i2) {
                        return;
                    }
                    this.f = i2 + 1;
                    return;
                }
                throw new IllegalArgumentException("you must create the tab content");
            }
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
    }

    public void e(b bVar, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (bVar.b != null) {
                if (bVar.c != null) {
                    if (this.i.contains(bVar)) {
                        return;
                    }
                    q55 q55Var = bVar.d;
                    if (q55Var != null) {
                        q55Var.e();
                    }
                    this.c.b(bVar.b, i, z);
                    if (i == -1) {
                        this.i.add(bVar);
                    } else {
                        this.i.add(i, bVar);
                    }
                    int i2 = this.f;
                    if (i2 == -1 || i > i2) {
                        return;
                    }
                    this.f = i2 + 1;
                    return;
                }
                throw new IllegalArgumentException("you must create the tab content");
            }
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            } else {
                layoutParams2.height = -2;
            }
            g(layoutParams.getRules());
            g(layoutParams2.getRules());
            if (i == 1) {
                layoutParams2.addRule(12, -1);
                layoutParams.addRule(12, -1);
                layoutParams.bottomMargin = 0;
                this.n.setVisibility(0);
            } else if (i == 0) {
                layoutParams2.addRule(10, -1);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f091ee0);
                layoutParams.bottomMargin = 0;
                this.n.setVisibility(0);
            } else if (i == 2) {
                layoutParams2.addRule(12, -1);
                layoutParams.addRule(10, -1);
                layoutParams.bottomMargin = 0;
                this.n.setVisibility(0);
            } else if (i == 3) {
                layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + pi.f(this.b, R.dimen.obfuscated_res_0x7f070306);
                this.n.setVisibility(0);
            } else if (i == 4) {
                layoutParams.addRule(10, -1);
                layoutParams.bottomMargin = 0;
                this.n.setVisibility(8);
            }
            this.k.setLayoutParams(layoutParams);
            this.n.setLayoutParams(layoutParams2);
        }
    }

    public final void g(int[] iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, iArr) == null) || iArr == null || iArr.length <= 0) {
            return;
        }
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = 0;
        }
    }

    public Fragment getCurrentFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b bVar = this.g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : invokeV.intValue;
    }

    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i = this.f;
            if (i < 0 || i >= this.i.size()) {
                return -1;
            }
            return this.i.get(this.f).a;
        }
        return invokeV.intValue;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.c : (FragmentTabWidget) invokeV.objValue;
    }

    public CustomViewPager getFragmentViewPager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : (CustomViewPager) invokeV.objValue;
    }

    public ViewGroup getTabWrapper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.n : (ViewGroup) invokeV.objValue;
    }

    public int h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                if (i == this.i.get(i2).a) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public b i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            if (i < 0 || i >= this.i.size()) {
                return null;
            }
            return this.i.get(i);
        }
        return (b) invokeI.objValue;
    }

    public b j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            for (b bVar : this.i) {
                if (i == bVar.a) {
                    return bVar;
                }
            }
            return null;
        }
        return (b) invokeI.objValue;
    }

    public void k() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (linearLayout = this.n) == null || linearLayout.getVisibility() == 8) {
            return;
        }
        this.n.setVisibility(8);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            this.b = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02e0, (ViewGroup) this, true);
            this.n = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091ee0);
            this.p = findViewById(R.id.obfuscated_res_0x7f091edf);
            this.f = -1;
            this.g = null;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            n(0);
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            CustomViewPager customViewPager = this.k;
            if (customViewPager != null) {
                removeView(customViewPager);
            }
            CustomViewPager customViewPager2 = new CustomViewPager(this.b);
            this.k = customViewPager2;
            customViewPager2.setId(R.id.obfuscated_res_0x7f091ec3);
            vk8.c(this.k, 2);
            f(i);
            addView(this.k);
            removeView(this.n);
            addView(this.n);
            removeView(this.p);
            addView(this.p);
            this.k.setOffscreenPageLimit(this.i.size() - 1);
            this.k.setOnPageChangeListener(this);
            FragmentAdapter fragmentAdapter = new FragmentAdapter(this.h, this.i);
            this.m = fragmentAdapter;
            this.k.setAdapter(fragmentAdapter);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            CustomViewPager customViewPager = this.k;
            if (customViewPager != null) {
                removeView(customViewPager);
            }
            CustomViewPager customViewPager2 = new CustomViewPager(this.b);
            this.k = customViewPager2;
            customViewPager2.setId(R.id.obfuscated_res_0x7f091ec3);
            addView(this.k);
            removeView(this.n);
            addView(this.n);
            this.k.setOffscreenPageLimit(this.i.size() - 1);
            this.k.setOnPageChangeListener(this);
            FragmentAdapter fragmentAdapter = new FragmentAdapter(this.h, this.i);
            this.m = fragmentAdapter;
            this.k.setAdapter(fragmentAdapter);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i) == null) || (onPageChangeListener = this.j) == null) {
            return;
        }
        onPageChangeListener.onPageScrollStateChanged(i);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            this.c.c(i, f);
            ViewPager.OnPageChangeListener onPageChangeListener = this.j;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f, i2);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            ViewPager.OnPageChangeListener onPageChangeListener = this.j;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i);
            }
            if (TbSingleton.getInstance().isFromFeedVideoClick() && i == this.a) {
                i = s;
            }
            this.f = i;
            this.g = this.i.get(i);
            FragmentTabWidget fragmentTabWidget = this.c;
            int i2 = this.f;
            if (i2 == s) {
                i2 = this.a;
            }
            fragmentTabWidget.setCurrentTab(i2, false, true);
            ViewGroup viewGroup = (ViewGroup) this.g.c.getView();
            if (viewGroup == null || viewGroup.getChildCount() <= 0) {
                return;
            }
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).b(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
    public void onTabSelectionChanged(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.g = this.i.get(i);
            a aVar = this.l;
            if (aVar == null || aVar.onPreTabSelectionChange(i, z)) {
                w(i, z);
            }
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            if (z) {
                for (b bVar : this.i) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = bVar.b;
                    if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                        MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
                        maintabBottomIndicator.r(true);
                        maintabBottomIndicator.setSelected(bVar.b.isSelected());
                    }
                }
                return;
            }
            for (b bVar2 : this.i) {
                TbFragmentTabIndicator tbFragmentTabIndicator2 = bVar2.b;
                if (tbFragmentTabIndicator2 instanceof MaintabBottomIndicator) {
                    MaintabBottomIndicator maintabBottomIndicator2 = (MaintabBottomIndicator) tbFragmentTabIndicator2;
                    maintabBottomIndicator2.r(false);
                    maintabBottomIndicator2.setSelected(bVar2.b.isSelected());
                }
            }
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            if (this.o == null) {
                this.o = findViewById(R.id.obfuscated_res_0x7f09212a);
            }
            if (!z) {
                this.o.setVisibility(8);
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.c;
            if (fragmentTabWidget != null) {
                fragmentTabWidget.setShouldDrawTopLine(false);
                ((FrameLayout.LayoutParams) this.c.getLayoutParams()).gravity = 80;
            }
            int d = pi.d(getContext(), 1.0f);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams.gravity = 48;
            layoutParams.height = d;
            this.o.setLayoutParams(layoutParams);
            this.o.setVisibility(0);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
        }
    }

    public void s(int i) {
        TbFragmentTabIndicator tbFragmentTabIndicator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.c.h(i);
            this.e.b(i);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.p, R.drawable.bottom_view_shadow);
            for (b bVar : this.i) {
                if (bVar != null && (tbFragmentTabIndicator = bVar.b) != null) {
                    tbFragmentTabIndicator.e(i);
                    TbFragmentTabIndicator tbFragmentTabIndicator2 = bVar.b;
                    tbFragmentTabIndicator2.setSelected(tbFragmentTabIndicator2.isSelected());
                }
            }
            FragmentAdapter fragmentAdapter = this.m;
            if (fragmentAdapter != null) {
                int count = fragmentAdapter.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    Fragment item = this.m.getItem(i2);
                    if (item instanceof BaseFragment) {
                        ((BaseFragment) item).changeSkinType(i);
                    }
                }
            }
        }
    }

    public void setAbsoluteWeight(boolean z) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || (fragmentTabWidget = this.c) == null) {
            return;
        }
        fragmentTabWidget.setAbsoluteWeight(z);
    }

    public void setBackGroundStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.r = i;
            FragmentTabWidget fragmentTabWidget = this.c;
            if (fragmentTabWidget != null) {
                fragmentTabWidget.setBackGroundStyle(i);
            }
        }
    }

    public void setCurrentTab(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048604, this, i) == null) || i < 0 || i >= this.i.size()) {
            return;
        }
        if (TbSingleton.getInstance().isFromFeedVideoClick() && i == this.a) {
            i = s;
        }
        if (i == this.f) {
            return;
        }
        this.f = i;
        this.g = this.i.get(i);
        FragmentTabWidget fragmentTabWidget = this.c;
        int i2 = this.f;
        if (i2 == s) {
            i2 = this.a;
        }
        fragmentTabWidget.setCurrentTab(i2, true, false);
        CustomViewPager customViewPager = this.k;
        if (customViewPager != null) {
            customViewPager.setCurrentItem(this.f, false);
        }
    }

    public void setCurrentTabByType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            int size = this.i.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (i == this.i.get(i2).a) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                w(i2, false);
            } else if (this.f == -1) {
                w(0, false);
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onPageChangeListener) == null) {
            this.j = onPageChangeListener;
        }
    }

    public void setOnTabSelectionListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, aVar) == null) {
            this.l = aVar;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048609, this, z) == null) || (fragmentTabWidget = this.c) == null) {
            return;
        }
        fragmentTabWidget.setShouldDrawDividerLine(z);
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048610, this, z) == null) || (fragmentTabWidget = this.c) == null) {
            return;
        }
        fragmentTabWidget.setShouldDrawIndicatorLine(z);
    }

    public void setShouldDrawTopLine(boolean z) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048611, this, z) == null) || (fragmentTabWidget = this.c) == null) {
            return;
        }
        fragmentTabWidget.setShouldDrawTopLine(z);
    }

    public void setTabContainerShadowShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.p.setVisibility(z ? 0 : 8);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.c.setBackgroundColor(i);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, pair) == null) {
            if (this.d == null) {
                this.d = new zt4(this, R.color.common_color_10274);
            }
            setShouldDrawIndicatorLine(false);
            setShouldDrawTopLine(false);
            r(false);
            this.d.e(pair);
        }
    }

    public void setTabWidgetViewHeight(int i) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048616, this, i) == null) || (fragmentTabWidget = this.c) == null) {
            return;
        }
        fragmentTabWidget.getLayoutParams().height = i;
        this.c.requestLayout();
        this.n.getLayoutParams().height = i;
        this.n.requestLayout();
        if (this.r == 1) {
            this.e.getLayoutParams().height = i;
            this.e.requestLayout();
        }
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048617, this, i, i2, i3, i4) == null) {
            this.c.setPadding(i, i2, i3, i4);
        }
    }

    public void setUIType(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048618, this, i) == null) || this.q == i) {
            return;
        }
        this.q = i;
        if (i == 1) {
            setShouldDrawTopLine(false);
            r(false);
        } else if (i == 0) {
            setShouldDrawTopLine(true);
            r(true);
        }
    }

    public void setViewPagerScrollable(boolean z) {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048619, this, z) == null) || (customViewPager = this.k) == null) {
            return;
        }
        customViewPager.setScrollable(z);
    }

    public void setup(FragmentManager fragmentManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, fragmentManager) == null) {
            this.h = fragmentManager;
            this.c = (FragmentTabWidget) findViewById(R.id.obfuscated_res_0x7f091ede);
            this.e = (FragmentTabSwellingView) findViewById(R.id.obfuscated_res_0x7f091ed6);
            this.c.setTabSelectionListener(this);
        }
    }

    public void t(boolean z, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048621, this, z, fragment) == null) {
            if (fragment != null) {
                t = fragment;
            }
            if (s == -1) {
                s = this.i.size();
            }
            if (this.a == -1) {
                this.a = h(22);
            }
            try {
                if (z) {
                    b bVar = new b();
                    bVar.c = fragment;
                    bVar.a = 23;
                    if (this.i.size() == s) {
                        this.i.add(bVar);
                    } else {
                        for (int i = s; i < this.i.size(); i++) {
                            this.i.remove(i);
                        }
                        this.i.add(bVar);
                    }
                    this.m.notifyDataSetChanged();
                    return;
                }
                FragmentTransaction beginTransaction = this.h.beginTransaction();
                Fragment findFragmentByTag = this.h.findFragmentByTag(p(this.k.getId(), this.m.getItemId(s)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                    beginTransaction.commit();
                    this.h.executePendingTransactions();
                    this.i.remove(s);
                    this.m.notifyDataSetChanged();
                }
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || this.k == null || this.m == null) {
            return;
        }
        try {
            FragmentTransaction beginTransaction = this.h.beginTransaction();
            int size = this.i.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.h.findFragmentByTag(p(this.k.getId(), this.m.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commit();
            this.h.executePendingTransactions();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
        for (b bVar : this.i) {
            q55 q55Var = bVar.d;
            if (q55Var != null) {
                q55Var.f();
            }
        }
        this.i.clear();
        this.g = null;
        this.f = -1;
        this.c.i();
        t = null;
    }

    public void v() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (linearLayout = this.n) == null || linearLayout.getVisibility() == 0) {
            return;
        }
        this.n.setVisibility(0);
    }

    public void w(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            a aVar = this.l;
            if (aVar != null) {
                aVar.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        FragmentTabWidget fragmentTabWidget;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (fragmentTabWidget = this.c) == null) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.i = new ArrayList();
        this.j = null;
        this.q = 0;
        l(context);
    }
}
