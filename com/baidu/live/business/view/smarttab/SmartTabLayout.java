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
import com.baidu.mobstat.Config;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a90;
import com.repackage.b90;
import com.repackage.c90;
import com.repackage.s80;
import com.repackage.za0;
/* loaded from: classes2.dex */
public class SmartTabLayout extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public int C;
    public int D;
    public int E;
    public boolean F;
    public boolean G;
    public boolean H;
    public String I;
    public String J;
    public boolean K;
    public boolean L;
    public int a;
    public final b90 b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public ColorStateList g;
    public float h;
    public float i;
    public int j;
    public int k;
    public ViewPager l;
    public ViewPager.OnPageChangeListener m;
    public d n;
    public h o;
    public b p;
    public e q;
    public boolean r;
    public int s;
    public int t;
    public float u;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.F) {
                SmartTabLayout smartTabLayout = this.a;
                if (view2 != smartTabLayout.b.getChildAt(smartTabLayout.s)) {
                    this.a.z = false;
                }
                for (int i = 0; i < this.a.b.getChildCount(); i++) {
                    if (view2 == this.a.b.getChildAt(i)) {
                        if (this.a.q != null) {
                            this.a.q.a(i);
                        }
                        try {
                            this.a.l.setCurrentItem(i);
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
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.b.A) {
                this.a = i;
                if (i == 0) {
                    this.b.z = false;
                }
                if (i == 1) {
                    this.b.z = true;
                }
                if (this.b.m != null) {
                    this.b.m.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            int childCount;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) || !this.b.A || (childCount = this.b.b.getChildCount()) == 0 || i < 0 || i >= childCount) {
                return;
            }
            this.b.b.j(i, f);
            SmartTabLayout smartTabLayout = this.b;
            smartTabLayout.c = smartTabLayout.d;
            this.b.D(i, f);
            if (this.b.m != null) {
                this.b.m.onPageScrolled(i, f, i2);
            }
            if (this.b.v) {
                if (this.b.A(f)) {
                    f = 0.0f;
                }
                View childAt = this.b.b.getChildAt(i);
                View childAt2 = this.b.b.getChildAt(i + 1);
                if (childAt == null || childAt2 == null || f == 0.0f || !this.b.z) {
                    return;
                }
                this.b.t(childAt, (this.b.u + 1.0f) - (this.b.u * f));
                this.b.t(childAt2, (this.b.u * f) + 1.0f);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            View findViewById;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.b.A) {
                if (this.a == 0) {
                    this.b.b.j(i, 0.0f);
                    SmartTabLayout smartTabLayout = this.b;
                    smartTabLayout.c = smartTabLayout.d;
                    this.b.D(i, 0.0f);
                }
                this.b.s = i;
                if (this.b.v && !this.b.z) {
                    SmartTabLayout smartTabLayout2 = this.b;
                    View childAt = smartTabLayout2.b.getChildAt(smartTabLayout2.t);
                    View childAt2 = this.b.b.getChildAt(i);
                    this.b.t(childAt, 1.0f);
                    SmartTabLayout smartTabLayout3 = this.b;
                    smartTabLayout3.t(childAt2, smartTabLayout3.u + 1.0f);
                }
                SmartTabLayout smartTabLayout4 = this.b;
                smartTabLayout4.t = smartTabLayout4.s;
                int childCount = this.b.b.getChildCount();
                int i2 = 0;
                while (i2 < childCount) {
                    View childAt3 = this.b.b.getChildAt(i2);
                    childAt3.setSelected(i == i2);
                    if ((childAt3 instanceof ViewGroup) && this.b.E != -1 && (findViewById = childAt3.findViewById(this.b.E)) != null) {
                        findViewById.setVisibility(8);
                    }
                    i2++;
                }
                if (this.b.m != null) {
                    this.b.m.onPageSelected(i);
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
        public final int a;
        public final int b;
        public LinearLayout.LayoutParams c;

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
                if (this.a != -1) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(this.a, (ViewGroup) null);
                    view2.setLayoutParams(this.c);
                } else {
                    view2 = null;
                }
                int i2 = this.b;
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
            int i5 = this.b;
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
            this.a = i;
            this.b = i2;
            this.c = layoutParams;
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

    public final boolean A(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? ((double) Math.abs(f2)) < 1.0E-4d : invokeF.booleanValue;
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            setCustomTextsColorWithoutSelectedPos(za0.e().a(getContext(), this.K, this.J));
            setCustomTextsColorSelectedPos(za0.e().a(getContext(), this.K, this.I));
        }
    }

    public final void C() {
        View a2;
        int i;
        View findViewById;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            PagerAdapter adapter = this.l.getAdapter();
            for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                h hVar2 = this.o;
                if (hVar2 == null) {
                    a2 = u(adapter.getPageTitle(i2));
                } else {
                    a2 = hVar2.a(this.b, i2, adapter);
                }
                if (a2 == null) {
                    return;
                }
                if (this.H && i2 == 0 && (hVar = this.o) != null) {
                    hVar.b(a2, s80.a(getContext(), 16.0f), 0, 0, 0);
                }
                if (this.r) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a2.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                }
                b bVar = this.p;
                if (bVar != null) {
                    a2.setOnClickListener(bVar);
                }
                this.b.addView(a2);
                int i3 = this.B;
                if (i3 != -1) {
                    TextView textView = (TextView) a2.findViewById(i3);
                    if (textView instanceof TabTextView) {
                        TabTextView tabTextView = (TabTextView) textView;
                        if (this.w) {
                            tabTextView.setGradientColorEnable(true);
                        } else {
                            tabTextView.setGradientColorEnable(false);
                            tabTextView.f();
                        }
                        tabTextView.setSelectedColorEnable(this.x);
                        if (this.y) {
                            tabTextView.setSelectedBold(true);
                            tabTextView.setUnselectedBold(true);
                            tabTextView.setTypeface(Typeface.DEFAULT_BOLD);
                        }
                        if (!this.v) {
                            tabTextView.setSelectedTextSize(this.i);
                            tabTextView.setDefaultTextSize(this.h);
                        }
                    }
                    if (textView != null) {
                        textView.setTextSize(0, this.h);
                    }
                }
                int i4 = this.C;
                View findViewById2 = i4 != -1 ? a2.findViewById(i4) : null;
                if (i2 == this.l.getCurrentItem()) {
                    a2.setSelected(true);
                    if ((a2 instanceof ViewGroup) && (i = this.E) != -1 && (findViewById = a2.findViewById(i)) != null) {
                        findViewById.setVisibility(8);
                    }
                    if (findViewById2 != null) {
                        findViewById2.setVisibility(this.L ? 0 : 8);
                    }
                } else if (findViewById2 != null) {
                    findViewById2.setVisibility(8);
                }
            }
            if (this.v) {
                t(this.b.getChildAt(this.l.getCurrentItem()), this.u + 1.0f);
            }
        }
    }

    public final void D(int i, float f2) {
        int childCount;
        int i2;
        int j;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) || (childCount = this.b.getChildCount()) == 0 || i < 0 || i >= childCount) {
            return;
        }
        boolean n = c90.n(this);
        View childAt = this.b.getChildAt(i);
        int l = (int) ((c90.l(childAt) + c90.d(childAt)) * f2);
        if (this.b.h()) {
            if (0.0f < f2 && f2 < 1.0f) {
                View childAt2 = this.b.getChildAt(i + 1);
                l = Math.round(f2 * ((c90.l(childAt) / 2) + c90.c(childAt) + (c90.l(childAt2) / 2) + c90.e(childAt2)));
            }
            View childAt3 = this.b.getChildAt(0);
            if (n) {
                int l2 = c90.l(childAt3) + c90.c(childAt3);
                int l3 = c90.l(childAt) + c90.c(childAt);
                j = (c90.a(childAt) - c90.c(childAt)) - l;
                i3 = (l2 - l3) / 2;
            } else {
                int l4 = c90.l(childAt3) + c90.e(childAt3);
                int l5 = c90.l(childAt) + c90.e(childAt);
                j = (c90.j(childAt) - c90.e(childAt)) + l;
                i3 = (l4 - l5) / 2;
            }
            scrollTo(j - i3, 0);
        } else if (this.b.i()) {
            scrollTo(((c90.j(childAt) - c90.e(childAt)) - (s80.c(getContext()) / 2)) + (c90.l(childAt) / 2) + c90.c(childAt), 0);
        } else {
            if (this.c == -1) {
                if (0.0f < f2 && f2 < 1.0f) {
                    View childAt4 = this.b.getChildAt(i + 1);
                    l = Math.round(f2 * ((c90.l(childAt) / 2) + c90.c(childAt) + (c90.l(childAt4) / 2) + c90.e(childAt4)));
                }
                if (n) {
                    i2 = (((-c90.m(childAt)) / 2) + (getWidth() / 2)) - c90.i(this);
                } else {
                    i2 = ((c90.m(childAt) / 2) - (getWidth() / 2)) + c90.i(this);
                }
            } else if (n) {
                if (i > 0 || f2 > 0.0f) {
                    i2 = this.c;
                }
                i2 = 0;
            } else {
                if (i > 0 || f2 > 0.0f) {
                    i2 = -this.c;
                }
                i2 = 0;
            }
            int j2 = c90.j(childAt);
            int e2 = c90.e(childAt);
            scrollTo(i2 + (n ? (((j2 + e2) - l) - getWidth()) + c90.h(this) : (j2 - e2) + l), 0);
        }
    }

    public final void E(int i, int i2) {
        View y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) || (y = y(i)) == null) {
            return;
        }
        y.setVisibility(i2);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public float getLeftFadingEdgeStrength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.G) {
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
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (!z || (viewPager = this.l) == null) {
                return;
            }
            D(viewPager.getCurrentItem(), 0.0f);
            this.s = this.l.getCurrentItem();
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i, i2, i3, i4) == null) {
            super.onScrollChanged(i, i2, i3, i4);
            d dVar = this.n;
            if (dVar != null) {
                dVar.a(i, i3);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (!this.b.h() || this.b.getChildCount() <= 0) {
                return;
            }
            View childAt = this.b.getChildAt(0);
            b90 b90Var = this.b;
            View childAt2 = b90Var.getChildAt(b90Var.getChildCount() - 1);
            int f2 = ((i - c90.f(childAt)) / 2) - c90.e(childAt);
            int f3 = ((i - c90.f(childAt2)) / 2) - c90.c(childAt2);
            b90 b90Var2 = this.b;
            b90Var2.setMinimumWidth(b90Var2.getMeasuredWidth());
            ViewCompat.setPaddingRelative(this, f2, getPaddingTop(), f3, getPaddingBottom());
            setClipToPadding(false);
        }
    }

    public void setAllTabIsBold(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.y = z;
        }
    }

    public void setCustomTabColorizer(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.b.l(gVar);
        }
    }

    public void setCustomTabView(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            setCustomTabView(i, i2, new LinearLayout.LayoutParams(-2, this.a));
        }
    }

    public void setCustomTextColor(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i, i2) == null) {
            View x = x(i);
            if (x instanceof TextView) {
                ((TextView) x).setTextColor(i2);
            }
        }
    }

    public void setCustomTextDrawable(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) {
            View x = x(i);
            if (x instanceof TextView) {
                if (i2 != -1) {
                    Drawable drawable = getResources().getDrawable(i2);
                    drawable.setBounds(0, 0, s80.a(getContext(), 11.0f), s80.a(getContext(), 11.0f));
                    TextView textView = (TextView) x;
                    textView.setCompoundDrawables(null, null, drawable, null);
                    textView.setCompoundDrawablePadding(s80.a(getContext(), 5.0f));
                    return;
                }
                ((TextView) x).setCompoundDrawables(null, null, null, null);
            }
        }
    }

    public void setCustomTextSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) {
            View x = x(i);
            if (x instanceof TextView) {
                TextView textView = (TextView) x;
                textView.setTextSize(0, TypedValue.applyDimension(2, i2, getResources().getDisplayMetrics()));
            }
        }
    }

    public void setCustomTextsColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
                setCustomTextColor(i2, i);
            }
        }
    }

    public void setCustomTextsColorSelectedPos(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
                if (i2 == this.l.getCurrentItem()) {
                    setCustomTextColor(i2, i);
                    return;
                }
            }
        }
    }

    public void setCustomTextsColorWithoutSelectedAndNextPos(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i, i2) == null) {
            for (int i3 = 0; i3 < this.b.getChildCount(); i3++) {
                if (i3 != this.l.getCurrentItem() && i3 != i2) {
                    setCustomTextColor(i3, i);
                }
            }
        }
    }

    public void setCustomTextsColorWithoutSelectedPos(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
                if (i2 != this.l.getCurrentItem()) {
                    setCustomTextColor(i2, i);
                }
            }
        }
    }

    public void setCustomTextsSelectedColorEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            for (int i = 0; i < this.b.getChildCount(); i++) {
                View x = x(i);
                if (x instanceof TabTextView) {
                    ((TabTextView) x).setSelectedColorEnable(z);
                }
            }
        }
    }

    public void setCustomTextsShadow(float f2, float f3, float f4, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i)}) == null) {
            for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
                View x = x(i2);
                if (x instanceof TextView) {
                    ((TextView) x).setShadowLayer(f2, f3, f4, i);
                }
            }
        }
    }

    public void setCustomTextsSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
                setCustomTextSize(i2, i);
            }
        }
    }

    public void setDarkModeCompatColor(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, str, str2) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.I = str;
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.J = str2;
        }
    }

    public void setDefaultTabTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.g = ColorStateList.valueOf(i);
        }
    }

    public void setDistributeEvenly(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.r = z;
        }
    }

    public void setDividerColors(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, iArr) == null) {
            this.b.m(iArr);
        }
    }

    public void setIndexTopTab(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.H = z;
        }
    }

    public void setIndicationInterpolator(a90 a90Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, a90Var) == null) {
            this.b.n(a90Var);
        }
    }

    public void setIsImmersion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.K = z;
        }
    }

    public void setLeftFadingEdgeEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.G = z;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onPageChangeListener) == null) {
            this.m = onPageChangeListener;
        }
    }

    public void setOnScrollChangeListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, dVar) == null) {
            this.n = dVar;
        }
    }

    public void setOnTabClickListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, eVar) == null) {
            this.q = eVar;
        }
    }

    public void setScrollLineVisibility(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048612, this, i) == null) && this.L) {
            int i2 = 0;
            while (i2 < this.b.getChildCount()) {
                E(i2, i2 == i ? 0 : 8);
                i2++;
            }
        }
    }

    public void setSelectedIndicatorColors(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, iArr) == null) {
            this.b.q(iArr);
        }
    }

    public void setShowBottomLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.L = z;
        }
    }

    public void setTabCanClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.F = z;
        }
    }

    public void setTabChangeEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.A = z;
        }
    }

    public void setTabGradientEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.w = z;
        }
    }

    public void setTabRedDotVisibility(int i, int i2) {
        View w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048618, this, i, i2) == null) || (w = w(i)) == null) {
            return;
        }
        w.setVisibility(i2);
    }

    public void setTabScaleEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.v = z;
        }
    }

    public void setTabSelectedColorEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.x = z;
            for (int i = 0; i < this.b.getChildCount(); i++) {
                View x = x(i);
                if (x instanceof TabTextView) {
                    ((TabTextView) x).setSelectedColorEnable(z);
                }
            }
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, viewPager) == null) {
            this.b.removeAllViews();
            this.l = viewPager;
            if (viewPager == null || viewPager.getAdapter() == null) {
                return;
            }
            viewPager.clearOnPageChangeListeners();
            viewPager.addOnPageChangeListener(new c(this, null));
            C();
            B(Config.TRACE_VISIT_RECENT_DAY);
        }
    }

    public void setindicatorMarginBottom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            this.b.o(i);
        }
    }

    public void setindicatorWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.b.p(i);
        }
    }

    public final void t(View view2, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048624, this, view2, f2) == null) || view2 == null) {
            return;
        }
        int[] z = z(view2);
        view2.setPivotX(z[0] * 0.5f);
        view2.setPivotY(z[1] * 0.5f);
        view2.setScaleX(f2);
        view2.setScaleY(f2);
    }

    public TextView u(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, charSequence)) == null) {
            TextView textView = new TextView(getContext());
            textView.setGravity(17);
            textView.setText(charSequence);
            textView.setTextColor(this.g);
            textView.setTextSize(0, this.h);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            int i = this.e;
            if (i != -1) {
                textView.setBackgroundResource(i);
            } else {
                TypedValue typedValue = new TypedValue();
                getContext().getTheme().resolveAttribute(16843534, typedValue, true);
                textView.setBackgroundResource(typedValue.resourceId);
            }
            textView.setAllCaps(this.f);
            int i2 = this.j;
            textView.setPadding(i2, 0, i2, 0);
            int i3 = this.k;
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i)) == null) ? this.b.getChildAt(i) : (View) invokeI.objValue;
    }

    public View w(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048627, this, i)) == null) {
            View v = v(i);
            if (!(v instanceof ViewGroup) || (i2 = this.D) == -1) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i)) == null) {
            View v = v(i);
            if (!(v instanceof ViewGroup) || (i2 = this.B) == -1) {
                return null;
            }
            return v.findViewById(i2);
        }
        return (View) invokeI.objValue;
    }

    public View y(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048629, this, i)) == null) {
            View v = v(i);
            if (!(v instanceof ViewGroup) || (i2 = this.C) == -1) {
                return null;
            }
            return v.findViewById(i2);
        }
        return (View) invokeI.objValue;
    }

    public final int[] z(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, view2)) == null) {
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

    public void setCustomTabView(int i, int i2, LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048588, this, i, i2, layoutParams) == null) {
            this.o = new f(getContext(), i, i2, layoutParams, null);
        }
    }

    public void setDefaultTabTextColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, colorStateList) == null) {
            this.g = colorStateList;
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
        this.a = 40;
        this.z = false;
        this.A = true;
        this.D = -1;
        this.E = -1;
        this.F = true;
        this.G = true;
        this.H = false;
        this.I = "color_FF33551";
        this.J = "color_1F1F1F";
        this.K = false;
        this.L = false;
        setClipChildren(false);
        setClipToPadding(false);
        setHorizontalScrollBarEnabled(false);
        this.a = s80.a(getContext(), 40.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f2 = displayMetrics.density;
        float applyDimension = TypedValue.applyDimension(2, 17.0f, displayMetrics);
        float applyDimension2 = TypedValue.applyDimension(2, 17.0f, displayMetrics);
        int a2 = s80.a(context, 40.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0403fb, R.attr.obfuscated_res_0x7f040402, R.attr.obfuscated_res_0x7f040403, R.attr.obfuscated_res_0x7f040404, R.attr.obfuscated_res_0x7f040405, R.attr.obfuscated_res_0x7f040406, R.attr.obfuscated_res_0x7f040407, R.attr.obfuscated_res_0x7f040408, R.attr.obfuscated_res_0x7f040409, R.attr.obfuscated_res_0x7f04040a, R.attr.obfuscated_res_0x7f04040b, R.attr.obfuscated_res_0x7f04040c, R.attr.obfuscated_res_0x7f04040d, R.attr.obfuscated_res_0x7f04040e, R.attr.obfuscated_res_0x7f040410, R.attr.obfuscated_res_0x7f040411, R.attr.obfuscated_res_0x7f040412, R.attr.obfuscated_res_0x7f040413, R.attr.obfuscated_res_0x7f040414, R.attr.obfuscated_res_0x7f040416, R.attr.obfuscated_res_0x7f040417, R.attr.obfuscated_res_0x7f040418, R.attr.obfuscated_res_0x7f040419, R.attr.obfuscated_res_0x7f04041a, R.attr.obfuscated_res_0x7f04041b, R.attr.obfuscated_res_0x7f04041c, R.attr.obfuscated_res_0x7f04041d, R.attr.obfuscated_res_0x7f04041e, R.attr.obfuscated_res_0x7f04041f, R.attr.obfuscated_res_0x7f040420, R.attr.obfuscated_res_0x7f040421, R.attr.obfuscated_res_0x7f040423, R.attr.obfuscated_res_0x7f040424, R.attr.obfuscated_res_0x7f040426, R.attr.obfuscated_res_0x7f04042c, R.attr.obfuscated_res_0x7f04042d, R.attr.obfuscated_res_0x7f04042f, R.attr.obfuscated_res_0x7f040430, R.attr.obfuscated_res_0x7f040431, R.attr.obfuscated_res_0x7f040432}, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(8, -1);
        boolean z = obtainStyledAttributes.getBoolean(9, true);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(10);
        float dimension = obtainStyledAttributes.getDimension(13, applyDimension);
        float dimension2 = obtainStyledAttributes.getDimension(33, applyDimension2);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(11, (int) (16.0f * f2));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(12, (int) (0.0f * f2));
        int resourceId2 = obtainStyledAttributes.getResourceId(2, -1);
        int resourceId3 = obtainStyledAttributes.getResourceId(7, -1);
        int resourceId4 = obtainStyledAttributes.getResourceId(6, -1);
        boolean z2 = obtainStyledAttributes.getBoolean(14, false);
        boolean z3 = obtainStyledAttributes.getBoolean(0, true);
        this.d = obtainStyledAttributes.getLayoutDimension(37, (int) (f2 * 24.0f));
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(1, a2);
        int layoutDimension2 = obtainStyledAttributes.getLayoutDimension(3, -2);
        this.D = obtainStyledAttributes.getResourceId(4, -1);
        this.E = obtainStyledAttributes.getResourceId(5, -1);
        this.u = obtainStyledAttributes.getFloat(35, 0.2f);
        this.v = obtainStyledAttributes.getBoolean(36, false);
        this.w = obtainStyledAttributes.getBoolean(34, false);
        obtainStyledAttributes.recycle();
        this.c = this.d;
        this.e = resourceId;
        this.f = z;
        this.g = colorStateList == null ? ColorStateList.valueOf(-67108864) : colorStateList;
        this.h = dimension;
        this.i = dimension2;
        this.j = dimensionPixelSize;
        this.k = dimensionPixelSize2;
        this.p = z3 ? new b(this, null) : null;
        this.r = z2;
        this.B = resourceId3;
        this.C = resourceId4;
        if (resourceId2 != -1) {
            setCustomTabView(resourceId2, resourceId3, new LinearLayout.LayoutParams(layoutDimension2, layoutDimension));
        }
        b90 b90Var = new b90(context, attributeSet);
        this.b = b90Var;
        if (z2 && b90Var.h()) {
            return;
        }
        setFillViewport(!this.b.h());
        addView(this.b, -1, -1);
    }

    public void setCustomTabView(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, hVar) == null) {
            this.o = hVar;
        }
    }
}
