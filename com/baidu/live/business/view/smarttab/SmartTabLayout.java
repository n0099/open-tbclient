package com.baidu.live.business.view.smarttab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class SmartTabLayout extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public int G;
    public int H;
    public boolean I;
    public boolean J;
    public boolean K;
    public String L;
    public String M;
    public boolean N;
    public boolean O;

    /* renamed from: e  reason: collision with root package name */
    public int f35358e;

    /* renamed from: f  reason: collision with root package name */
    public int f35359f;

    /* renamed from: g  reason: collision with root package name */
    public int f35360g;

    /* renamed from: h  reason: collision with root package name */
    public int f35361h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f35362i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f35363j;

    /* renamed from: k  reason: collision with root package name */
    public float f35364k;
    public float l;
    public int m;
    public int n;
    public ViewPager o;
    public ViewPager.OnPageChangeListener p;
    public d q;
    public h r;
    public b s;
    public e t;
    public final c.a.w.b.g.c.b tabStrip;
    public boolean u;
    public int v;
    public int w;
    public float x;
    public boolean y;
    public boolean z;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SmartTabLayout f35365e;

        public b(SmartTabLayout smartTabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartTabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35365e = smartTabLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f35365e.I) {
                SmartTabLayout smartTabLayout = this.f35365e;
                if (view != smartTabLayout.tabStrip.getChildAt(smartTabLayout.v)) {
                    this.f35365e.C = false;
                }
                for (int i2 = 0; i2 < this.f35365e.tabStrip.getChildCount(); i2++) {
                    if (view == this.f35365e.tabStrip.getChildAt(i2)) {
                        if (this.f35365e.t != null) {
                            this.f35365e.t.a(i2);
                        }
                        try {
                            this.f35365e.o.setCurrentItem(i2);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                }
            }
        }

        public /* synthetic */ b(SmartTabLayout smartTabLayout, a aVar) {
            this(smartTabLayout);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f35366e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SmartTabLayout f35367f;

        public c(SmartTabLayout smartTabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartTabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35367f = smartTabLayout;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && this.f35367f.D) {
                this.f35366e = i2;
                if (i2 == 0) {
                    this.f35367f.C = false;
                }
                if (i2 == 1) {
                    this.f35367f.C = true;
                }
                if (this.f35367f.p != null) {
                    this.f35367f.p.onPageScrollStateChanged(i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            int childCount;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || !this.f35367f.D || (childCount = this.f35367f.tabStrip.getChildCount()) == 0 || i2 < 0 || i2 >= childCount) {
                return;
            }
            this.f35367f.tabStrip.j(i2, f2);
            SmartTabLayout smartTabLayout = this.f35367f;
            smartTabLayout.f35359f = smartTabLayout.f35360g;
            this.f35367f.x(i2, f2);
            if (this.f35367f.p != null) {
                this.f35367f.p.onPageScrolled(i2, f2, i3);
            }
            if (this.f35367f.y) {
                if (this.f35367f.v(f2)) {
                    f2 = 0.0f;
                }
                View childAt = this.f35367f.tabStrip.getChildAt(i2);
                View childAt2 = this.f35367f.tabStrip.getChildAt(i2 + 1);
                if (childAt == null || childAt2 == null || f2 == 0.0f || !this.f35367f.C) {
                    return;
                }
                this.f35367f.t(childAt, (this.f35367f.x + 1.0f) - (this.f35367f.x * f2));
                this.f35367f.t(childAt2, (this.f35367f.x * f2) + 1.0f);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            View findViewById;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f35367f.D) {
                if (this.f35366e == 0) {
                    this.f35367f.tabStrip.j(i2, 0.0f);
                    SmartTabLayout smartTabLayout = this.f35367f;
                    smartTabLayout.f35359f = smartTabLayout.f35360g;
                    this.f35367f.x(i2, 0.0f);
                }
                this.f35367f.v = i2;
                if (this.f35367f.y && !this.f35367f.C) {
                    SmartTabLayout smartTabLayout2 = this.f35367f;
                    View childAt = smartTabLayout2.tabStrip.getChildAt(smartTabLayout2.w);
                    View childAt2 = this.f35367f.tabStrip.getChildAt(i2);
                    this.f35367f.t(childAt, 1.0f);
                    SmartTabLayout smartTabLayout3 = this.f35367f;
                    smartTabLayout3.t(childAt2, smartTabLayout3.x + 1.0f);
                }
                SmartTabLayout smartTabLayout4 = this.f35367f;
                smartTabLayout4.w = smartTabLayout4.v;
                int childCount = this.f35367f.tabStrip.getChildCount();
                int i3 = 0;
                while (i3 < childCount) {
                    View childAt3 = this.f35367f.tabStrip.getChildAt(i3);
                    childAt3.setSelected(i2 == i3);
                    if ((childAt3 instanceof ViewGroup) && this.f35367f.H != -1 && (findViewById = childAt3.findViewById(this.f35367f.H)) != null) {
                        findViewById.setVisibility(8);
                    }
                    i3++;
                }
                if (this.f35367f.p != null) {
                    this.f35367f.p.onPageSelected(i2);
                }
            }
        }

        public /* synthetic */ c(SmartTabLayout smartTabLayout, a aVar) {
            this(smartTabLayout);
        }
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a(int i2, int i3);
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(int i2);
    }

    /* loaded from: classes8.dex */
    public static class f implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f35368b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout.LayoutParams f35369c;

        public /* synthetic */ f(Context context, int i2, int i3, LinearLayout.LayoutParams layoutParams, a aVar) {
            this(context, i2, i3, layoutParams);
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.h
        public View a(ViewGroup viewGroup, int i2, PagerAdapter pagerAdapter) {
            InterceptResult invokeLIL;
            View view;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, viewGroup, i2, pagerAdapter)) == null) {
                TextView textView = null;
                if (this.a != -1) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(this.a, (ViewGroup) null);
                    view.setLayoutParams(this.f35369c);
                } else {
                    view = null;
                }
                int i3 = this.f35368b;
                if (i3 != -1 && view != null) {
                    textView = (TextView) view.findViewById(i3);
                }
                if (textView != null) {
                    textView.setText(pagerAdapter.getPageTitle(i2));
                }
                return view;
            }
            return (View) invokeLIL.objValue;
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.h
        public void b(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || view == null) {
                return;
            }
            int i6 = this.f35368b;
            TextView textView = i6 != -1 ? (TextView) view.findViewById(i6) : null;
            if (textView != null && (textView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
                layoutParams.leftMargin = i2;
                layoutParams.topMargin = i3;
                layoutParams.rightMargin = i4;
                layoutParams.bottomMargin = i5;
            }
        }

        public f(Context context, int i2, int i3, @NonNull LinearLayout.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            LayoutInflater.from(context);
            this.a = i2;
            this.f35368b = i3;
            this.f35369c = layoutParams;
        }
    }

    /* loaded from: classes8.dex */
    public interface g {
        int a(int i2);

        int b(int i2);
    }

    /* loaded from: classes8.dex */
    public interface h {
        View a(ViewGroup viewGroup, int i2, PagerAdapter pagerAdapter);

        void b(View view, int i2, int i3, int i4, int i5);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmartTabLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void cancelTabTextGradient(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            View tabTextAt = getTabTextAt(i2);
            if (tabTextAt instanceof TabTextView) {
                TabTextView tabTextView = (TabTextView) tabTextAt;
                tabTextView.setGradientColorEnable(false);
                tabTextView.clearGradientColor();
            }
        }
    }

    public void clearCustomTextsShadow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i2 = 0; i2 < this.tabStrip.getChildCount(); i2++) {
                View tabTextAt = getTabTextAt(i2);
                if (tabTextAt instanceof TextView) {
                    ((TextView) tabTextAt).setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                }
            }
        }
    }

    public TextView createDefaultTabView(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, charSequence)) == null) {
            TextView textView = new TextView(getContext());
            textView.setGravity(17);
            textView.setText(charSequence);
            textView.setTextColor(this.f35363j);
            textView.setTextSize(0, this.f35364k);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            int i2 = this.f35361h;
            if (i2 != -1) {
                textView.setBackgroundResource(i2);
            } else {
                TypedValue typedValue = new TypedValue();
                getContext().getTheme().resolveAttribute(16843534, typedValue, true);
                textView.setBackgroundResource(typedValue.resourceId);
            }
            textView.setAllCaps(this.f35362i);
            int i3 = this.m;
            textView.setPadding(i3, 0, i3, 0);
            int i4 = this.n;
            if (i4 > 0) {
                textView.setMinWidth(i4);
            }
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public float getLeftFadingEdgeStrength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.J) {
                return super.getLeftFadingEdgeStrength();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public View getTabAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.tabStrip.getChildAt(i2) : (View) invokeI.objValue;
    }

    public View getTabRedDotAt(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            View tabAt = getTabAt(i2);
            if (!(tabAt instanceof ViewGroup) || (i3 = this.G) == -1) {
                return null;
            }
            return tabAt.findViewById(i3);
        }
        return (View) invokeI.objValue;
    }

    public boolean getTabRedDotVisibility(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            View tabRedDotAt = getTabRedDotAt(i2);
            return tabRedDotAt != null && tabRedDotAt.getVisibility() == 0;
        }
        return invokeI.booleanValue;
    }

    public View getTabTextAt(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            View tabAt = getTabAt(i2);
            if (!(tabAt instanceof ViewGroup) || (i3 = this.E) == -1) {
                return null;
            }
            return tabAt.findViewById(i3);
        }
        return (View) invokeI.objValue;
    }

    public View getTabTextScrollAt(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            View tabAt = getTabAt(i2);
            if (!(tabAt instanceof ViewGroup) || (i3 = this.F) == -1) {
                return null;
            }
            return tabAt.findViewById(i3);
        }
        return (View) invokeI.objValue;
    }

    public void hideTab(int i2) {
        View tabAt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (tabAt = getTabAt(i2)) == null) {
            return;
        }
        tabAt.setVisibility(8);
    }

    public void onDarkModeChange(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            setCustomTextsColorWithoutSelectedPos(c.a.w.i.f.e().a(getContext(), this.N, this.M));
            setCustomTextsColorSelectedPos(c.a.w.i.f.e().a(getContext(), this.N, this.L));
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (!z || (viewPager = this.o) == null) {
                return;
            }
            x(viewPager.getCurrentItem(), 0.0f);
            this.v = this.o.getCurrentItem();
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
            d dVar = this.q;
            if (dVar != null) {
                dVar.a(i2, i4);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (!this.tabStrip.h() || this.tabStrip.getChildCount() <= 0) {
                return;
            }
            View childAt = this.tabStrip.getChildAt(0);
            c.a.w.b.g.c.b bVar = this.tabStrip;
            View childAt2 = bVar.getChildAt(bVar.getChildCount() - 1);
            int f2 = ((i2 - c.a.w.b.g.c.c.f(childAt)) / 2) - c.a.w.b.g.c.c.e(childAt);
            int f3 = ((i2 - c.a.w.b.g.c.c.f(childAt2)) / 2) - c.a.w.b.g.c.c.c(childAt2);
            c.a.w.b.g.c.b bVar2 = this.tabStrip;
            bVar2.setMinimumWidth(bVar2.getMeasuredWidth());
            ViewCompat.setPaddingRelative(this, f2, getPaddingTop(), f3, getPaddingBottom());
            setClipToPadding(false);
        }
    }

    public void openTabTextGradient(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            View tabTextAt = getTabTextAt(i2);
            if (tabTextAt instanceof TabTextView) {
                ((TabTextView) tabTextAt).setGradientColorEnable(true);
            }
        }
    }

    public void setAllTabIsBold(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.B = z;
        }
    }

    public void setCustomTabColorizer(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gVar) == null) {
            this.tabStrip.l(gVar);
        }
    }

    public void setCustomTabView(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) {
            setCustomTabView(i2, i3, new LinearLayout.LayoutParams(-2, this.f35358e));
        }
    }

    public void setCustomTextColor(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) {
            View tabTextAt = getTabTextAt(i2);
            if (tabTextAt instanceof TextView) {
                ((TextView) tabTextAt).setTextColor(i3);
            }
        }
    }

    public void setCustomTextDrawable(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048597, this, i2, i3) == null) {
            View tabTextAt = getTabTextAt(i2);
            if (tabTextAt instanceof TextView) {
                if (i3 != -1) {
                    Drawable drawable = getResources().getDrawable(i3);
                    drawable.setBounds(0, 0, c.a.w.b.f.a.a(getContext(), 11.0f), c.a.w.b.f.a.a(getContext(), 11.0f));
                    TextView textView = (TextView) tabTextAt;
                    textView.setCompoundDrawables(null, null, drawable, null);
                    textView.setCompoundDrawablePadding(c.a.w.b.f.a.a(getContext(), 5.0f));
                    return;
                }
                ((TextView) tabTextAt).setCompoundDrawables(null, null, null, null);
            }
        }
    }

    public void setCustomTextsColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            for (int i3 = 0; i3 < this.tabStrip.getChildCount(); i3++) {
                setCustomTextColor(i3, i2);
            }
        }
    }

    public void setCustomTextsColorSelectedPos(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            for (int i3 = 0; i3 < this.tabStrip.getChildCount(); i3++) {
                if (i3 == this.o.getCurrentItem()) {
                    setCustomTextColor(i3, i2);
                    return;
                }
            }
        }
    }

    public void setCustomTextsColorWithoutSelectedAndNextPos(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i2, i3) == null) {
            for (int i4 = 0; i4 < this.tabStrip.getChildCount(); i4++) {
                if (i4 != this.o.getCurrentItem() && i4 != i3) {
                    setCustomTextColor(i4, i2);
                }
            }
        }
    }

    public void setCustomTextsColorWithoutSelectedPos(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            for (int i3 = 0; i3 < this.tabStrip.getChildCount(); i3++) {
                if (i3 != this.o.getCurrentItem()) {
                    setCustomTextColor(i3, i2);
                }
            }
        }
    }

    public void setCustomTextsSelectedColorEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            for (int i2 = 0; i2 < this.tabStrip.getChildCount(); i2++) {
                View tabTextAt = getTabTextAt(i2);
                if (tabTextAt instanceof TabTextView) {
                    ((TabTextView) tabTextAt).setSelectedColorEnable(z);
                }
            }
        }
    }

    public void setCustomTextsShadow(float f2, float f3, float f4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i2)}) == null) {
            for (int i3 = 0; i3 < this.tabStrip.getChildCount(); i3++) {
                View tabTextAt = getTabTextAt(i3);
                if (tabTextAt instanceof TextView) {
                    ((TextView) tabTextAt).setShadowLayer(f2, f3, f4, i2);
                }
            }
        }
    }

    public void setDarkModeCompatColor(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, str2) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.L = str;
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.M = str2;
        }
    }

    public void setDefaultTabTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.f35363j = ColorStateList.valueOf(i2);
        }
    }

    public void setDistributeEvenly(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.u = z;
        }
    }

    public void setDividerColors(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, iArr) == null) {
            this.tabStrip.m(iArr);
        }
    }

    public void setIndexTopTab(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.K = z;
        }
    }

    public void setIndicationInterpolator(c.a.w.b.g.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, aVar) == null) {
            this.tabStrip.n(aVar);
        }
    }

    public void setIsImmersion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.N = z;
        }
    }

    public void setLeftFadingEdgeEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.J = z;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, onPageChangeListener) == null) {
            this.p = onPageChangeListener;
        }
    }

    public void setOnScrollChangeListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, dVar) == null) {
            this.q = dVar;
        }
    }

    public void setOnTabClickListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, eVar) == null) {
            this.t = eVar;
        }
    }

    public void setScrollLineVisibility(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048616, this, i2) == null) && this.O) {
            int i3 = 0;
            while (i3 < this.tabStrip.getChildCount()) {
                y(i3, i3 == i2 ? 0 : 8);
                i3++;
            }
        }
    }

    public void setSelectedIndicatorColors(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, iArr) == null) {
            this.tabStrip.q(iArr);
        }
    }

    public void setShowBottomLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.O = z;
        }
    }

    public void setTabCanClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.I = z;
        }
    }

    public void setTabChangeEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.D = z;
        }
    }

    public void setTabGradientEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.z = z;
        }
    }

    public void setTabRedDotVisibility(int i2, int i3) {
        View tabRedDotAt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048622, this, i2, i3) == null) || (tabRedDotAt = getTabRedDotAt(i2)) == null) {
            return;
        }
        tabRedDotAt.setVisibility(i3);
    }

    public void setTabScaleEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.y = z;
        }
    }

    public void setTabSelectedColorEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.A = z;
            for (int i2 = 0; i2 < this.tabStrip.getChildCount(); i2++) {
                View tabTextAt = getTabTextAt(i2);
                if (tabTextAt instanceof TabTextView) {
                    ((TabTextView) tabTextAt).setSelectedColorEnable(z);
                }
            }
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, viewPager) == null) {
            this.tabStrip.removeAllViews();
            this.o = viewPager;
            if (viewPager == null || viewPager.getAdapter() == null) {
                return;
            }
            viewPager.clearOnPageChangeListeners();
            viewPager.addOnPageChangeListener(new c(this, null));
            w();
            onDarkModeChange("day");
        }
    }

    public void setindicatorMarginBottom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            this.tabStrip.o(i2);
        }
    }

    public void setindicatorWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            this.tabStrip.p(i2);
        }
    }

    public final void t(View view, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048628, this, view, f2) == null) || view == null) {
            return;
        }
        int[] u = u(view);
        view.setPivotX(u[0] * 0.5f);
        view.setPivotY(u[1] * 0.5f);
        view.setScaleX(f2);
        view.setScaleY(f2);
    }

    public final int[] u(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, view)) == null) {
            int[] iArr = {0, 0};
            if (view != null) {
                if (view.getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                iArr[0] = view.getMeasuredWidth();
                iArr[1] = view.getMeasuredHeight();
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public final boolean v(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048630, this, f2)) == null) ? ((double) Math.abs(f2)) < 1.0E-4d : invokeF.booleanValue;
    }

    public final void w() {
        View a2;
        int i2;
        View findViewById;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            PagerAdapter adapter = this.o.getAdapter();
            for (int i3 = 0; i3 < adapter.getCount(); i3++) {
                h hVar2 = this.r;
                if (hVar2 == null) {
                    a2 = createDefaultTabView(adapter.getPageTitle(i3));
                } else {
                    a2 = hVar2.a(this.tabStrip, i3, adapter);
                }
                if (a2 != null) {
                    if (this.K && i3 == 0 && (hVar = this.r) != null) {
                        hVar.b(a2, c.a.w.b.f.a.a(getContext(), 16.0f), 0, 0, 0);
                    }
                    if (this.u) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a2.getLayoutParams();
                        layoutParams.width = 0;
                        layoutParams.weight = 1.0f;
                    }
                    b bVar = this.s;
                    if (bVar != null) {
                        a2.setOnClickListener(bVar);
                    }
                    this.tabStrip.addView(a2);
                    int i4 = this.E;
                    if (i4 != -1) {
                        TextView textView = (TextView) a2.findViewById(i4);
                        if (textView instanceof TabTextView) {
                            TabTextView tabTextView = (TabTextView) textView;
                            if (this.z) {
                                tabTextView.setGradientColorEnable(true);
                            } else {
                                tabTextView.setGradientColorEnable(false);
                                tabTextView.clearGradientColor();
                            }
                            tabTextView.setSelectedColorEnable(this.A);
                            if (this.B) {
                                tabTextView.setSelectedBold(true);
                                tabTextView.setUnselectedBold(true);
                                tabTextView.setTypeface(Typeface.DEFAULT_BOLD);
                            }
                            if (!this.y) {
                                tabTextView.setSelectedTextSize(this.l);
                                tabTextView.setDefaultTextSize(this.f35364k);
                            }
                        }
                        if (textView != null) {
                            textView.setTextSize(0, this.f35364k);
                        }
                    }
                    int i5 = this.F;
                    View findViewById2 = i5 != -1 ? a2.findViewById(i5) : null;
                    if (i3 == this.o.getCurrentItem()) {
                        a2.setSelected(true);
                        if ((a2 instanceof ViewGroup) && (i2 = this.H) != -1 && (findViewById = a2.findViewById(i2)) != null) {
                            findViewById.setVisibility(8);
                        }
                        if (findViewById2 != null) {
                            findViewById2.setVisibility(this.O ? 0 : 8);
                        }
                    } else if (findViewById2 != null) {
                        findViewById2.setVisibility(8);
                    }
                } else {
                    throw new IllegalStateException("tabView is null.");
                }
            }
            if (this.y) {
                t(this.tabStrip.getChildAt(this.o.getCurrentItem()), this.x + 1.0f);
            }
        }
    }

    public final void x(int i2, float f2) {
        int childCount;
        int i3;
        int j2;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || (childCount = this.tabStrip.getChildCount()) == 0 || i2 < 0 || i2 >= childCount) {
            return;
        }
        boolean n = c.a.w.b.g.c.c.n(this);
        View childAt = this.tabStrip.getChildAt(i2);
        int l = (int) ((c.a.w.b.g.c.c.l(childAt) + c.a.w.b.g.c.c.d(childAt)) * f2);
        if (this.tabStrip.h()) {
            if (0.0f < f2 && f2 < 1.0f) {
                View childAt2 = this.tabStrip.getChildAt(i2 + 1);
                l = Math.round(f2 * ((c.a.w.b.g.c.c.l(childAt) / 2) + c.a.w.b.g.c.c.c(childAt) + (c.a.w.b.g.c.c.l(childAt2) / 2) + c.a.w.b.g.c.c.e(childAt2)));
            }
            View childAt3 = this.tabStrip.getChildAt(0);
            if (n) {
                int l2 = c.a.w.b.g.c.c.l(childAt3) + c.a.w.b.g.c.c.c(childAt3);
                int l3 = c.a.w.b.g.c.c.l(childAt) + c.a.w.b.g.c.c.c(childAt);
                j2 = (c.a.w.b.g.c.c.a(childAt) - c.a.w.b.g.c.c.c(childAt)) - l;
                i4 = (l2 - l3) / 2;
            } else {
                int l4 = c.a.w.b.g.c.c.l(childAt3) + c.a.w.b.g.c.c.e(childAt3);
                int l5 = c.a.w.b.g.c.c.l(childAt) + c.a.w.b.g.c.c.e(childAt);
                j2 = (c.a.w.b.g.c.c.j(childAt) - c.a.w.b.g.c.c.e(childAt)) + l;
                i4 = (l4 - l5) / 2;
            }
            scrollTo(j2 - i4, 0);
        } else if (this.tabStrip.i()) {
            scrollTo(((c.a.w.b.g.c.c.j(childAt) - c.a.w.b.g.c.c.e(childAt)) - (c.a.w.b.f.a.c(getContext()) / 2)) + (c.a.w.b.g.c.c.l(childAt) / 2) + c.a.w.b.g.c.c.c(childAt), 0);
        } else {
            if (this.f35359f == -1) {
                if (0.0f < f2 && f2 < 1.0f) {
                    View childAt4 = this.tabStrip.getChildAt(i2 + 1);
                    l = Math.round(f2 * ((c.a.w.b.g.c.c.l(childAt) / 2) + c.a.w.b.g.c.c.c(childAt) + (c.a.w.b.g.c.c.l(childAt4) / 2) + c.a.w.b.g.c.c.e(childAt4)));
                }
                if (n) {
                    i3 = (((-c.a.w.b.g.c.c.m(childAt)) / 2) + (getWidth() / 2)) - c.a.w.b.g.c.c.i(this);
                } else {
                    i3 = ((c.a.w.b.g.c.c.m(childAt) / 2) - (getWidth() / 2)) + c.a.w.b.g.c.c.i(this);
                }
            } else if (n) {
                if (i2 > 0 || f2 > 0.0f) {
                    i3 = this.f35359f;
                }
                i3 = 0;
            } else {
                if (i2 > 0 || f2 > 0.0f) {
                    i3 = -this.f35359f;
                }
                i3 = 0;
            }
            int j3 = c.a.w.b.g.c.c.j(childAt);
            int e2 = c.a.w.b.g.c.c.e(childAt);
            scrollTo(i3 + (n ? (((j3 + e2) - l) - getWidth()) + c.a.w.b.g.c.c.h(this) : (j3 - e2) + l), 0);
        }
    }

    public final void y(int i2, int i3) {
        View tabTextScrollAt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048633, this, i2, i3) == null) || (tabTextScrollAt = getTabTextScrollAt(i2)) == null) {
            return;
        }
        tabTextScrollAt.setVisibility(i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmartTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void setCustomTabView(int i2, int i3, LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048594, this, i2, i3, layoutParams) == null) {
            this.r = new f(getContext(), i2, i3, layoutParams, null);
        }
    }

    public void setDefaultTabTextColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, colorStateList) == null) {
            this.f35363j = colorStateList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f35358e = 40;
        this.C = false;
        this.D = true;
        this.G = -1;
        this.H = -1;
        this.I = true;
        this.J = true;
        this.K = false;
        this.L = "color_FF33551";
        this.M = "color_1F1F1F";
        this.N = false;
        this.O = false;
        setClipChildren(false);
        setClipToPadding(false);
        setHorizontalScrollBarEnabled(false);
        this.f35358e = c.a.w.b.f.a.a(getContext(), 40.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f2 = displayMetrics.density;
        float applyDimension = TypedValue.applyDimension(2, 17.0f, displayMetrics);
        float applyDimension2 = TypedValue.applyDimension(2, 17.0f, displayMetrics);
        int a2 = c.a.w.b.f.a.a(context, 40.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout, i2, 0);
        int resourceId = obtainStyledAttributes.getResourceId(c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_defaultTabBackground, -1);
        boolean z = obtainStyledAttributes.getBoolean(c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_defaultTabTextAllCaps, true);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_defaultTabTextColor);
        float dimension = obtainStyledAttributes.getDimension(c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_defaultTabTextSize, applyDimension);
        float dimension2 = obtainStyledAttributes.getDimension(c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_selectedTabTextSize, applyDimension2);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_defaultTabTextHorizontalPadding, (int) (16.0f * f2));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_defaultTabTextMinWidth, (int) (0.0f * f2));
        int resourceId2 = obtainStyledAttributes.getResourceId(c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_customTabLayoutId, -1);
        int resourceId3 = obtainStyledAttributes.getResourceId(c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_customTabTextViewId, -1);
        int resourceId4 = obtainStyledAttributes.getResourceId(c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_customTabTextScrollViewId, -1);
        boolean z2 = obtainStyledAttributes.getBoolean(c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_distributeEvenly, false);
        boolean z3 = obtainStyledAttributes.getBoolean(c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_clickable, true);
        this.f35360g = obtainStyledAttributes.getLayoutDimension(c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_titleOffset, (int) (f2 * 24.0f));
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_customTabLayoutHeight, a2);
        int layoutDimension2 = obtainStyledAttributes.getLayoutDimension(c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_customTabLayoutWidth, -2);
        this.G = obtainStyledAttributes.getResourceId(c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_customTabReddotViewId, -1);
        this.H = obtainStyledAttributes.getResourceId(c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_customTabRednumViewId, -1);
        this.x = obtainStyledAttributes.getFloat(c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_tabMaxScale, 0.2f);
        this.y = obtainStyledAttributes.getBoolean(c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_tabScaleEnable, false);
        this.z = obtainStyledAttributes.getBoolean(c.a.w.c.a.f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_tabGradientEnable, false);
        obtainStyledAttributes.recycle();
        this.f35359f = this.f35360g;
        this.f35361h = resourceId;
        this.f35362i = z;
        this.f35363j = colorStateList == null ? ColorStateList.valueOf(-67108864) : colorStateList;
        this.f35364k = dimension;
        this.l = dimension2;
        this.m = dimensionPixelSize;
        this.n = dimensionPixelSize2;
        this.s = z3 ? new b(this, null) : null;
        this.u = z2;
        this.E = resourceId3;
        this.F = resourceId4;
        if (resourceId2 != -1) {
            setCustomTabView(resourceId2, resourceId3, new LinearLayout.LayoutParams(layoutDimension2, layoutDimension));
        }
        c.a.w.b.g.c.b bVar = new c.a.w.b.g.c.b(context, attributeSet);
        this.tabStrip = bVar;
        if (z2 && bVar.h()) {
            throw new UnsupportedOperationException("'distributeEvenly' and 'indicatorAlwaysInCenter' both use does not support");
        }
        setFillViewport(!this.tabStrip.h());
        addView(this.tabStrip, -1, -1);
    }

    public void setCustomTabView(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, hVar) == null) {
            this.r = hVar;
        }
    }
}
