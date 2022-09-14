package com.baidu.live.business.view.smarttab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
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
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveFeedConfig;
import com.baidu.tieba.aa0;
import com.baidu.tieba.ba0;
import com.baidu.tieba.ca0;
import com.baidu.tieba.dc0;
import com.baidu.tieba.hc0;
import com.baidu.tieba.q90;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SmartTabLayout extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public boolean D;
    public boolean E;
    public boolean F;
    public String G;
    public String H;
    public String I;
    public boolean J;
    public boolean K;
    public float[] L;
    public final aa0 a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public ColorStateList f;
    public float g;
    public float h;
    public int i;
    public int j;
    public ViewPager k;
    public ViewPager.OnPageChangeListener l;
    public d m;
    public h n;
    public b o;
    public e p;
    public boolean q;
    public int r;
    public int s;
    public float t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmartTabLayout a;

        public b(SmartTabLayout smartTabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartTabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smartTabLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.D) {
                SmartTabLayout smartTabLayout = this.a;
                if (view2 != smartTabLayout.a.getChildAt(smartTabLayout.r)) {
                    this.a.y = false;
                }
                for (int i = 0; i < this.a.a.getChildCount(); i++) {
                    if (view2 == this.a.a.getChildAt(i)) {
                        if (this.a.p != null) {
                            this.a.p.a(i);
                        }
                        try {
                            this.a.k.setCurrentItem(i);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
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

    /* loaded from: classes2.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ SmartTabLayout b;

        public c(SmartTabLayout smartTabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartTabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = smartTabLayout;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.b.z) {
                this.a = i;
                if (i == 0) {
                    this.b.y = false;
                }
                if (i == 1) {
                    this.b.y = true;
                }
                if (this.b.l != null) {
                    this.b.l.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            int childCount;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) || !this.b.z || (childCount = this.b.a.getChildCount()) == 0 || i < 0 || i >= childCount) {
                return;
            }
            this.b.a.j(i, f);
            SmartTabLayout smartTabLayout = this.b;
            smartTabLayout.b = smartTabLayout.c;
            this.b.F(i, f);
            if (this.b.l != null) {
                this.b.l.onPageScrolled(i, f, i2);
            }
            if (this.b.u) {
                if (this.b.z(f)) {
                    f = 0.0f;
                }
                View childAt = this.b.a.getChildAt(i);
                View childAt2 = this.b.a.getChildAt(i + 1);
                if (childAt == null || childAt2 == null || f == 0.0f || !this.b.y) {
                    return;
                }
                this.b.t(childAt, (this.b.t + 1.0f) - (this.b.t * f));
                this.b.t(childAt2, (this.b.t * f) + 1.0f);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            View findViewById;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.b.z) {
                if (this.a == 0) {
                    this.b.a.j(i, 0.0f);
                    SmartTabLayout smartTabLayout = this.b;
                    smartTabLayout.b = smartTabLayout.c;
                    this.b.F(i, 0.0f);
                }
                this.b.r = i;
                if (this.b.u && !this.b.y) {
                    SmartTabLayout smartTabLayout2 = this.b;
                    View childAt = smartTabLayout2.a.getChildAt(smartTabLayout2.s);
                    View childAt2 = this.b.a.getChildAt(i);
                    this.b.t(childAt, 1.0f);
                    SmartTabLayout smartTabLayout3 = this.b;
                    smartTabLayout3.t(childAt2, smartTabLayout3.t + 1.0f);
                }
                SmartTabLayout smartTabLayout4 = this.b;
                smartTabLayout4.s = smartTabLayout4.r;
                int childCount = this.b.a.getChildCount();
                int i2 = 0;
                while (i2 < childCount) {
                    View childAt3 = this.b.a.getChildAt(i2);
                    childAt3.setSelected(i == i2);
                    if ((childAt3 instanceof ViewGroup) && this.b.C != -1 && (findViewById = childAt3.findViewById(this.b.C)) != null) {
                        findViewById.setVisibility(8);
                    }
                    i2++;
                }
                if (this.b.l != null) {
                    this.b.l.onPageSelected(i);
                }
            }
        }

        public /* synthetic */ c(SmartTabLayout smartTabLayout, a aVar) {
            this(smartTabLayout);
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(int i);
    }

    /* loaded from: classes2.dex */
    public static class f implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;
        public final int b;
        public final int c;
        public LinearLayout.LayoutParams d;

        public /* synthetic */ f(Context context, int i, int i2, LinearLayout.LayoutParams layoutParams, a aVar) {
            this(context, i, i2, layoutParams);
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.h
        public View a(ViewGroup viewGroup, int i, PagerAdapter pagerAdapter) {
            InterceptResult invokeLIL;
            View view2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, viewGroup, i, pagerAdapter)) == null) {
                TextView textView = null;
                if (this.b != -1) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(this.b, (ViewGroup) null);
                    LinearLayout.LayoutParams layoutParams = this.d;
                    layoutParams.gravity = 16;
                    view2.setLayoutParams(layoutParams);
                } else {
                    view2 = null;
                }
                int i2 = this.c;
                if (i2 != -1 && view2 != null) {
                    textView = (TextView) view2.findViewById(i2);
                }
                if (textView != null) {
                    textView.setText(pagerAdapter.getPageTitle(i));
                }
                return view2;
            }
            return (View) invokeLIL.objValue;
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.h
        public void b(View view2, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || view2 == null) {
                return;
            }
            int i5 = this.c;
            TextView textView = i5 != -1 ? (TextView) view2.findViewById(i5) : null;
            if (textView != null && (textView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
                layoutParams.leftMargin = i;
                layoutParams.topMargin = i2;
                layoutParams.rightMargin = i3;
                layoutParams.bottomMargin = i4;
            }
        }

        public f(Context context, int i, int i2, @NonNull LinearLayout.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            LayoutInflater.from(context);
            this.a = context;
            this.b = i;
            this.c = i2;
            this.d = layoutParams;
        }
    }

    /* loaded from: classes2.dex */
    public interface g {
        int a(int i);

        int b(int i);
    }

    /* loaded from: classes2.dex */
    public interface h {
        View a(ViewGroup viewGroup, int i, PagerAdapter pagerAdapter);

        void b(View view2, int i, int i2, int i3, int i4);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setBackgroundWithoutSelectedPos(hc0.f().a(getContext(), this.I, "color_F5F5F53"));
            setBackgroundSelectedPos(hc0.f().a(getContext(), this.I, "color_FF33552"));
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            setCustomTextsColorWithoutSelectedPos(hc0.f().a(getContext(), this.I, this.H));
            setCustomTextsColorSelectedPos(hc0.f().a(getContext(), this.I, this.G));
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a == null) {
            return;
        }
        for (int i = 0; i < this.a.getChildCount(); i++) {
            View w = w(i);
            if (w instanceof TextView) {
                dc0.h((TextView) w, 0, this.g);
            }
        }
    }

    public final void D() {
        View a2;
        int i;
        View findViewById;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PagerAdapter adapter = this.k.getAdapter();
            for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                h hVar2 = this.n;
                if (hVar2 == null) {
                    a2 = u(adapter.getPageTitle(i2));
                } else {
                    a2 = hVar2.a(this.a, i2, adapter);
                }
                if (a2 == null) {
                    return;
                }
                if (this.F && i2 == 0 && (hVar = this.n) != null) {
                    hVar.b(a2, q90.b(getContext(), 16.0f), 0, 0, 0);
                }
                if (this.q) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a2.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) a2.getLayoutParams();
                if (this.K && LiveFeedPageSdk.HOST_LIVE_TAB.equals(this.I)) {
                    layoutParams2.height = q90.b(getContext(), 26.0f);
                    layoutParams2.setMargins(q90.b(getContext(), 4.0f), q90.b(getContext(), 10.0f), q90.b(getContext(), 3.0f), q90.b(getContext(), 10.0f));
                } else {
                    layoutParams2.height = q90.b(getContext(), 40.0f);
                    layoutParams2.setMargins(q90.b(getContext(), 9.0f), q90.b(getContext(), 10.0f), q90.b(getContext(), 9.0f), q90.b(getContext(), 10.0f));
                }
                a2.setLayoutParams(layoutParams2);
                b bVar = this.o;
                if (bVar != null) {
                    a2.setOnClickListener(bVar);
                }
                this.a.addView(a2);
                int i3 = this.A;
                if (i3 != -1) {
                    TextView textView = (TextView) a2.findViewById(i3);
                    if (textView instanceof TabTextView) {
                        TabTextView tabTextView = (TabTextView) textView;
                        if (this.v) {
                            tabTextView.setGradientColorEnable(true);
                        } else {
                            tabTextView.setGradientColorEnable(false);
                            tabTextView.f();
                        }
                        tabTextView.setSelectedColorEnable(this.w);
                        if (this.x) {
                            tabTextView.setSelectedBold(true);
                            tabTextView.setUnselectedBold(true);
                            tabTextView.setTypeface(Typeface.DEFAULT_BOLD);
                        }
                        if (!this.u) {
                            tabTextView.setSelectedTextSize(this.h);
                            tabTextView.setDefaultTextSize(this.g);
                        }
                    }
                    if (textView != null) {
                        dc0.h(textView, 0, this.g);
                    }
                }
                int i4 = this.B;
                View findViewById2 = i4 != -1 ? a2.findViewById(i4) : null;
                if (i2 == this.k.getCurrentItem()) {
                    a2.setSelected(true);
                    if ((a2 instanceof ViewGroup) && (i = this.C) != -1 && (findViewById = a2.findViewById(i)) != null) {
                        findViewById.setVisibility(8);
                    }
                    if (findViewById2 != null) {
                        findViewById2.setVisibility(this.J ? 0 : 8);
                    }
                } else if (findViewById2 != null) {
                    findViewById2.setVisibility(8);
                }
            }
            if (this.u) {
                t(this.a.getChildAt(this.k.getCurrentItem()), this.t + 1.0f);
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.removeAllViews();
        }
    }

    public final void F(int i, float f2) {
        int childCount;
        int i2;
        int j;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) || (childCount = this.a.getChildCount()) == 0 || i < 0 || i >= childCount) {
            return;
        }
        boolean n = ba0.n(this);
        View childAt = this.a.getChildAt(i);
        int l = (int) ((ba0.l(childAt) + ba0.d(childAt)) * f2);
        if (this.a.h()) {
            if (0.0f < f2 && f2 < 1.0f) {
                View childAt2 = this.a.getChildAt(i + 1);
                l = Math.round(f2 * ((ba0.l(childAt) / 2) + ba0.c(childAt) + (ba0.l(childAt2) / 2) + ba0.e(childAt2)));
            }
            View childAt3 = this.a.getChildAt(0);
            if (n) {
                int l2 = ba0.l(childAt3) + ba0.c(childAt3);
                int l3 = ba0.l(childAt) + ba0.c(childAt);
                j = (ba0.a(childAt) - ba0.c(childAt)) - l;
                i3 = (l2 - l3) / 2;
            } else {
                int l4 = ba0.l(childAt3) + ba0.e(childAt3);
                int l5 = ba0.l(childAt) + ba0.e(childAt);
                j = (ba0.j(childAt) - ba0.e(childAt)) + l;
                i3 = (l4 - l5) / 2;
            }
            scrollTo(j - i3, 0);
        } else if (this.a.i()) {
            scrollTo(((ba0.j(childAt) - ba0.e(childAt)) - (q90.e(getContext()) / 2)) + (ba0.l(childAt) / 2) + ba0.c(childAt), 0);
        } else {
            if (this.b == -1) {
                if (0.0f < f2 && f2 < 1.0f) {
                    View childAt4 = this.a.getChildAt(i + 1);
                    l = Math.round(f2 * ((ba0.l(childAt) / 2) + ba0.c(childAt) + (ba0.l(childAt4) / 2) + ba0.e(childAt4)));
                }
                if (n) {
                    i2 = (((-ba0.m(childAt)) / 2) + (getWidth() / 2)) - ba0.i(this);
                } else {
                    i2 = ((ba0.m(childAt) / 2) - (getWidth() / 2)) + ba0.i(this);
                }
            } else if (n) {
                if (i > 0 || f2 > 0.0f) {
                    i2 = this.b;
                }
                i2 = 0;
            } else {
                if (i > 0 || f2 > 0.0f) {
                    i2 = -this.b;
                }
                i2 = 0;
            }
            int j2 = ba0.j(childAt);
            int e2 = ba0.e(childAt);
            scrollTo(i2 + (n ? (((j2 + e2) - l) - getWidth()) + ba0.h(this) : (j2 - e2) + l), 0);
        }
    }

    public final void G(int i, int i2) {
        View x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) || (x = x(i)) == null) {
            return;
        }
        x.setVisibility(i2);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public float getLeftFadingEdgeStrength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.E) {
                return super.getLeftFadingEdgeStrength();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (!z || (viewPager = this.k) == null) {
                return;
            }
            F(viewPager.getCurrentItem(), 0.0f);
            this.r = this.k.getCurrentItem();
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048585, this, i, i2, i3, i4) == null) {
            super.onScrollChanged(i, i2, i3, i4);
            d dVar = this.m;
            if (dVar != null) {
                dVar.a(i, i3);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048586, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (!this.a.h() || this.a.getChildCount() <= 0) {
                return;
            }
            View childAt = this.a.getChildAt(0);
            aa0 aa0Var = this.a;
            View childAt2 = aa0Var.getChildAt(aa0Var.getChildCount() - 1);
            int f2 = ((i - ba0.f(childAt)) / 2) - ba0.e(childAt);
            int f3 = ((i - ba0.f(childAt2)) / 2) - ba0.c(childAt2);
            aa0 aa0Var2 = this.a;
            aa0Var2.setMinimumWidth(aa0Var2.getMeasuredWidth());
            ViewCompat.setPaddingRelative(this, f2, getPaddingTop(), f3, getPaddingBottom());
            setClipToPadding(false);
        }
    }

    public void setAllTabIsBold(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.x = z;
        }
    }

    public void setBackgroundSelectedPos(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
                if (i2 == this.k.getCurrentItem()) {
                    setCustomTextBackground(i2, i);
                    return;
                }
            }
        }
    }

    public void setBackgroundWithoutSelectedPos(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
                setCustomTextBackground(i2, i);
            }
        }
    }

    public void setCustomTabView(int i, int i2, LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048590, this, i, i2, layoutParams) == null) {
            this.n = new f(getContext(), i, i2, layoutParams, null);
        }
    }

    public void setCustomTextBackground(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) {
            View w = w(i);
            if (w instanceof TextView) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setSize(q90.b(getContext(), 50.0f), q90.b(getContext(), 26.0f));
                gradientDrawable.setCornerRadii(this.L);
                gradientDrawable.setColors(new int[]{i2, i2});
                if (this.K) {
                    ((TextView) w).setBackgroundDrawable(gradientDrawable);
                }
            }
        }
    }

    public void setCustomTextColor(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) {
            View w = w(i);
            if (w instanceof TextView) {
                ((TextView) w).setTextColor(i2);
            }
        }
    }

    public void setCustomTextSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
            View w = w(i);
            if (w instanceof TextView) {
                dc0.h((TextView) w, 0, i2);
            }
        }
    }

    public void setCustomTextsColorSelectedPos(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
                if (i2 == this.k.getCurrentItem()) {
                    setCustomTextColor(i2, i);
                    return;
                }
            }
        }
    }

    public void setCustomTextsColorWithoutSelectedPos(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
                if (i2 != this.k.getCurrentItem()) {
                    setCustomTextColor(i2, i);
                }
            }
        }
    }

    public void setCustomTextsSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.g = i;
            for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
                setCustomTextSize(i2, i);
            }
        }
    }

    public void setDarkModeCompatColor(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.G = str;
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.H = str2;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onPageChangeListener) == null) {
            this.l = onPageChangeListener;
        }
    }

    public void setOnScrollChangeListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, dVar) == null) {
            this.m = dVar;
        }
    }

    public void setOnTabClickListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, eVar) == null) {
            this.p = eVar;
        }
    }

    public void setScene(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.I = str;
        }
    }

    public void setScrollLineVisibility(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048602, this, i) == null) && this.J) {
            int i2 = 0;
            while (i2 < this.a.getChildCount()) {
                G(i2, i2 == i ? 0 : 8);
                i2++;
            }
        }
    }

    public void setSelectedIndicatorColors(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, iArr) == null) {
            this.a.l(iArr);
        }
    }

    public void setShowBottomLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.J = z;
        }
    }

    public void setTabSelectedColorEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.w = z;
            for (int i = 0; i < this.a.getChildCount(); i++) {
                View w = w(i);
                if (w instanceof TabTextView) {
                    ((TabTextView) w).setSelectedColorEnable(z);
                }
            }
        }
    }

    public void setViewPager(ViewPager viewPager, LiveFeedConfig liveFeedConfig) {
        LiveFeedConfig.AbSwitchConfig abSwitchConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, viewPager, liveFeedConfig) == null) {
            this.a.removeAllViews();
            this.k = viewPager;
            if (viewPager == null || viewPager.getAdapter() == null) {
                return;
            }
            viewPager.clearOnPageChangeListeners();
            viewPager.addOnPageChangeListener(new c(this, null));
            if (liveFeedConfig != null && (abSwitchConfig = liveFeedConfig.abSwitchConfig) != null && abSwitchConfig.newTab) {
                this.K = true;
            }
            D();
            B("day");
            if (this.K && LiveFeedPageSdk.HOST_LIVE_TAB.equals(this.I)) {
                A();
            }
        }
    }

    public final void t(View view2, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048607, this, view2, f2) == null) || view2 == null) {
            return;
        }
        int[] y = y(view2);
        view2.setPivotX(y[0] * 0.5f);
        view2.setPivotY(y[1] * 0.5f);
        view2.setScaleX(f2);
        view2.setScaleY(f2);
    }

    public TextView u(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, charSequence)) == null) {
            TextView textView = new TextView(getContext());
            textView.setGravity(17);
            textView.setText(charSequence);
            textView.setTextColor(this.f);
            dc0.h(textView, 0, this.g);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            int i = this.d;
            if (i != -1) {
                textView.setBackgroundResource(i);
            } else {
                TypedValue typedValue = new TypedValue();
                getContext().getTheme().resolveAttribute(16843534, typedValue, true);
                textView.setBackgroundResource(typedValue.resourceId);
            }
            textView.setAllCaps(this.e);
            int i2 = this.i;
            textView.setPadding(i2, 0, i2, 0);
            int i3 = this.j;
            if (i3 > 0) {
                textView.setMinWidth(i3);
            }
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    public View v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i)) == null) ? this.a.getChildAt(i) : (View) invokeI.objValue;
    }

    public View w(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) {
            View v = v(i);
            if (!(v instanceof ViewGroup) || (i2 = this.A) == -1) {
                return null;
            }
            return v.findViewById(i2);
        }
        return (View) invokeI.objValue;
    }

    public View x(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) {
            View v = v(i);
            if (!(v instanceof ViewGroup) || (i2 = this.B) == -1) {
                return null;
            }
            return v.findViewById(i2);
        }
        return (View) invokeI.objValue;
    }

    public final int[] y(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, view2)) == null) {
            int[] iArr = {0, 0};
            if (view2 != null) {
                if (view2.getMeasuredWidth() == 0) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    measure(makeMeasureSpec, makeMeasureSpec);
                }
                iArr[0] = view2.getMeasuredWidth();
                iArr[1] = view2.getMeasuredHeight();
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public final boolean z(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048613, this, f2)) == null) ? ((double) Math.abs(f2)) < 1.0E-4d : invokeF.booleanValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.y = false;
        this.z = true;
        this.C = -1;
        this.D = true;
        this.E = true;
        this.F = false;
        this.G = "color_FF33551";
        this.H = "color_1F1F1F";
        this.J = false;
        this.K = false;
        setClipChildren(false);
        setClipToPadding(false);
        setHorizontalScrollBarEnabled(false);
        q90.b(getContext(), 40.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f2 = displayMetrics.density;
        float b2 = q90.b(context, 7.0f);
        this.L = new float[]{b2, b2, b2, b2, b2, b2, b2, b2};
        float applyDimension = TypedValue.applyDimension(2, 17.0f, displayMetrics);
        float applyDimension2 = TypedValue.applyDimension(2, 17.0f, displayMetrics);
        int b3 = q90.b(context, 40.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ca0.LiveFeedPage_live_feed_page_SmartTabLayout, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(8, -1);
        boolean z = obtainStyledAttributes.getBoolean(9, true);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(10);
        float dimension = obtainStyledAttributes.getDimension(13, applyDimension);
        float dimension2 = obtainStyledAttributes.getDimension(33, applyDimension2);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(11, (int) (16.0f * f2));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(12, (int) (f2 * 0.0f));
        int resourceId2 = obtainStyledAttributes.getResourceId(2, -1);
        int resourceId3 = obtainStyledAttributes.getResourceId(7, -1);
        int resourceId4 = obtainStyledAttributes.getResourceId(6, -1);
        boolean z2 = obtainStyledAttributes.getBoolean(14, false);
        boolean z3 = obtainStyledAttributes.getBoolean(0, true);
        this.c = obtainStyledAttributes.getLayoutDimension(37, (int) (f2 * 50.0f));
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(1, b3);
        int layoutDimension2 = obtainStyledAttributes.getLayoutDimension(3, -2);
        obtainStyledAttributes.getResourceId(4, -1);
        this.C = obtainStyledAttributes.getResourceId(5, -1);
        this.t = obtainStyledAttributes.getFloat(35, 0.2f);
        this.u = obtainStyledAttributes.getBoolean(36, false);
        this.v = obtainStyledAttributes.getBoolean(34, false);
        obtainStyledAttributes.recycle();
        this.b = this.c;
        this.d = resourceId;
        this.e = z;
        this.f = colorStateList == null ? ColorStateList.valueOf(-67108864) : colorStateList;
        this.g = dimension;
        this.h = dimension2;
        this.i = dimensionPixelSize;
        this.j = dimensionPixelSize2;
        this.o = z3 ? new b(this, null) : null;
        this.q = z2;
        this.A = resourceId3;
        this.B = resourceId4;
        if (resourceId2 != -1) {
            setCustomTabView(resourceId2, resourceId3, new LinearLayout.LayoutParams(layoutDimension2, layoutDimension));
        }
        aa0 aa0Var = new aa0(context, attributeSet);
        this.a = aa0Var;
        if (z2 && aa0Var.h()) {
            return;
        }
        setFillViewport(!this.a.h());
        addView(this.a, -1, -1);
    }
}
