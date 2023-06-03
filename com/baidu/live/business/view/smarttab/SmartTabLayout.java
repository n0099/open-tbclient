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
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveFeedConfig;
import com.baidu.tieba.ce0;
import com.baidu.tieba.lb0;
import com.baidu.tieba.vb0;
import com.baidu.tieba.wb0;
import com.baidu.tieba.xb0;
import com.baidu.tieba.yd0;
/* loaded from: classes3.dex */
public class SmartTabLayout extends HorizontalScrollView {
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
    public final vb0 a;
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

    /* loaded from: classes3.dex */
    public interface d {
        void a(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(int i);
    }

    /* loaded from: classes3.dex */
    public interface g {
        int a(int i);

        int b(int i);
    }

    /* loaded from: classes3.dex */
    public interface h {
        View a(ViewGroup viewGroup, int i, PagerAdapter pagerAdapter);

        void b(View view2, int i, int i2, int i3, int i4);
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!SmartTabLayout.this.D) {
                return;
            }
            SmartTabLayout smartTabLayout = SmartTabLayout.this;
            if (view2 != smartTabLayout.a.getChildAt(smartTabLayout.r)) {
                SmartTabLayout.this.y = false;
            }
            for (int i = 0; i < SmartTabLayout.this.a.getChildCount(); i++) {
                if (view2 == SmartTabLayout.this.a.getChildAt(i)) {
                    if (SmartTabLayout.this.p != null) {
                        SmartTabLayout.this.p.a(i);
                    }
                    try {
                        SmartTabLayout.this.k.setCurrentItem(i);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public int a;

        public c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (SmartTabLayout.this.z) {
                this.a = i;
                if (i == 0) {
                    SmartTabLayout.this.y = false;
                }
                if (i == 1) {
                    SmartTabLayout.this.y = true;
                }
                if (SmartTabLayout.this.l != null) {
                    SmartTabLayout.this.l.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            int childCount;
            if (SmartTabLayout.this.z && (childCount = SmartTabLayout.this.a.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SmartTabLayout.this.a.j(i, f);
                SmartTabLayout smartTabLayout = SmartTabLayout.this;
                smartTabLayout.b = smartTabLayout.c;
                SmartTabLayout.this.F(i, f);
                if (SmartTabLayout.this.l != null) {
                    SmartTabLayout.this.l.onPageScrolled(i, f, i2);
                }
                if (SmartTabLayout.this.u) {
                    if (SmartTabLayout.this.z(f)) {
                        f = 0.0f;
                    }
                    View childAt = SmartTabLayout.this.a.getChildAt(i);
                    View childAt2 = SmartTabLayout.this.a.getChildAt(i + 1);
                    if (childAt == null || childAt2 == null || f == 0.0f || !SmartTabLayout.this.y) {
                        return;
                    }
                    SmartTabLayout.this.t(childAt, (SmartTabLayout.this.t + 1.0f) - (SmartTabLayout.this.t * f));
                    SmartTabLayout.this.t(childAt2, (SmartTabLayout.this.t * f) + 1.0f);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z;
            View findViewById;
            if (SmartTabLayout.this.z) {
                if (this.a == 0) {
                    SmartTabLayout.this.a.j(i, 0.0f);
                    SmartTabLayout smartTabLayout = SmartTabLayout.this;
                    smartTabLayout.b = smartTabLayout.c;
                    SmartTabLayout.this.F(i, 0.0f);
                }
                SmartTabLayout.this.r = i;
                if (SmartTabLayout.this.u && !SmartTabLayout.this.y) {
                    SmartTabLayout smartTabLayout2 = SmartTabLayout.this;
                    View childAt = smartTabLayout2.a.getChildAt(smartTabLayout2.s);
                    View childAt2 = SmartTabLayout.this.a.getChildAt(i);
                    SmartTabLayout.this.t(childAt, 1.0f);
                    SmartTabLayout smartTabLayout3 = SmartTabLayout.this;
                    smartTabLayout3.t(childAt2, smartTabLayout3.t + 1.0f);
                }
                SmartTabLayout smartTabLayout4 = SmartTabLayout.this;
                smartTabLayout4.s = smartTabLayout4.r;
                int childCount = SmartTabLayout.this.a.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt3 = SmartTabLayout.this.a.getChildAt(i2);
                    if (i == i2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    childAt3.setSelected(z);
                    if ((childAt3 instanceof ViewGroup) && SmartTabLayout.this.C != -1 && (findViewById = childAt3.findViewById(SmartTabLayout.this.C)) != null) {
                        findViewById.setVisibility(8);
                    }
                }
                if (SmartTabLayout.this.l != null) {
                    SmartTabLayout.this.l.onPageSelected(i);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements h {
        public final Context a;
        public final int b;
        public final int c;
        public LinearLayout.LayoutParams d;

        public f(Context context, int i, int i2, @NonNull LinearLayout.LayoutParams layoutParams) {
            LayoutInflater.from(context);
            this.a = context;
            this.b = i;
            this.c = i2;
            this.d = layoutParams;
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.h
        public void b(View view2, int i, int i2, int i3, int i4) {
            if (view2 == null) {
                return;
            }
            TextView textView = null;
            int i5 = this.c;
            if (i5 != -1) {
                textView = (TextView) view2.findViewById(i5);
            }
            if (textView != null && (textView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
                layoutParams.leftMargin = i;
                layoutParams.topMargin = i2;
                layoutParams.rightMargin = i3;
                layoutParams.bottomMargin = i4;
            }
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.h
        public View a(ViewGroup viewGroup, int i, PagerAdapter pagerAdapter) {
            View view2;
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
    }

    public SmartTabLayout(Context context) {
        this(context, null);
    }

    public void B(String str) {
        setCustomTextsColorWithoutSelectedPos(ce0.f().a(getContext(), this.I, this.H));
        setCustomTextsColorSelectedPos(ce0.f().a(getContext(), this.I, this.G));
    }

    public void setAllTabIsBold(boolean z) {
        this.x = z;
    }

    public void setBackgroundSelectedPos(int i) {
        for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
            if (i2 == this.k.getCurrentItem()) {
                setCustomTextBackground(i2, i);
                return;
            }
        }
    }

    public void setBackgroundWithoutSelectedPos(int i) {
        for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
            setCustomTextBackground(i2, i);
        }
    }

    public void setCustomTextsColorSelectedPos(int i) {
        for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
            if (i2 == this.k.getCurrentItem()) {
                setCustomTextColor(i2, i);
                return;
            }
        }
    }

    public void setCustomTextsColorWithoutSelectedPos(int i) {
        for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
            if (i2 != this.k.getCurrentItem()) {
                setCustomTextColor(i2, i);
            }
        }
    }

    public void setCustomTextsSize(int i) {
        this.g = i;
        for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
            setCustomTextSize(i2, i);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.l = onPageChangeListener;
    }

    public void setOnScrollChangeListener(d dVar) {
        this.m = dVar;
    }

    public void setOnTabClickListener(e eVar) {
        this.p = eVar;
    }

    public void setScene(String str) {
        this.I = str;
    }

    public void setScrollLineVisibility(int i) {
        int i2;
        if (!this.J) {
            return;
        }
        for (int i3 = 0; i3 < this.a.getChildCount(); i3++) {
            if (i3 == i) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            G(i3, i2);
        }
    }

    public void setSelectedIndicatorColors(int... iArr) {
        this.a.l(iArr);
    }

    public void setShowBottomLine(boolean z) {
        this.J = z;
    }

    public void setTabSelectedColorEnable(boolean z) {
        this.w = z;
        for (int i = 0; i < this.a.getChildCount(); i++) {
            View w = w(i);
            if (w instanceof TabTextView) {
                ((TabTextView) w).setSelectedColorEnable(z);
            }
        }
    }

    public View v(int i) {
        return this.a.getChildAt(i);
    }

    public View w(int i) {
        int i2;
        View v = v(i);
        if ((v instanceof ViewGroup) && (i2 = this.A) != -1) {
            return v.findViewById(i2);
        }
        return null;
    }

    public View x(int i) {
        int i2;
        View v = v(i);
        if ((v instanceof ViewGroup) && (i2 = this.B) != -1) {
            return v.findViewById(i2);
        }
        return null;
    }

    public final int[] y(View view2) {
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

    public final boolean z(float f2) {
        if (Math.abs(f2) < 1.0E-4d) {
            return true;
        }
        return false;
    }

    public SmartTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void G(int i, int i2) {
        View x = x(i);
        if (x != null) {
            x.setVisibility(i2);
        }
    }

    public void setCustomTextColor(int i, int i2) {
        View w = w(i);
        if (w instanceof TextView) {
            ((TextView) w).setTextColor(i2);
        }
    }

    public void setCustomTextSize(int i, int i2) {
        View w = w(i);
        if (w instanceof TextView) {
            yd0.h((TextView) w, 0, i2);
        }
    }

    public void setDarkModeCompatColor(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.G = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.H = str2;
        }
    }

    public final void t(View view2, float f2) {
        if (view2 != null) {
            int[] y = y(view2);
            view2.setPivotX(y[0] * 0.5f);
            view2.setPivotY(y[1] * 0.5f);
            view2.setScaleX(f2);
            view2.setScaleY(f2);
        }
    }

    public SmartTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
        lb0.b(getContext(), 40.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f2 = displayMetrics.density;
        float b2 = lb0.b(context, 7.0f);
        this.L = new float[]{b2, b2, b2, b2, b2, b2, b2, b2};
        float applyDimension = TypedValue.applyDimension(2, 17.0f, displayMetrics);
        float applyDimension2 = TypedValue.applyDimension(2, 17.0f, displayMetrics);
        int b3 = lb0.b(context, 40.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, xb0.LiveFeedPage_live_feed_page_SmartTabLayout, i, 0);
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
        this.o = z3 ? new b() : null;
        this.q = z2;
        this.A = resourceId3;
        this.B = resourceId4;
        if (resourceId2 != -1) {
            setCustomTabView(resourceId2, resourceId3, new LinearLayout.LayoutParams(layoutDimension2, layoutDimension));
        }
        vb0 vb0Var = new vb0(context, attributeSet);
        this.a = vb0Var;
        if (z2 && vb0Var.h()) {
            return;
        }
        setFillViewport(!this.a.h());
        addView(this.a, -1, -1);
    }

    public void setCustomTabView(int i, int i2, LinearLayout.LayoutParams layoutParams) {
        this.n = new f(getContext(), i, i2, layoutParams);
    }

    public void A() {
        setBackgroundWithoutSelectedPos(ce0.f().a(getContext(), this.I, "color_F5F5F53"));
        setBackgroundSelectedPos(ce0.f().a(getContext(), this.I, "color_FF33552"));
    }

    public void C() {
        if (this.a == null) {
            return;
        }
        for (int i = 0; i < this.a.getChildCount(); i++) {
            View w = w(i);
            if (w instanceof TextView) {
                yd0.h((TextView) w, 0, this.g);
            }
        }
    }

    public void E() {
        this.a.removeAllViews();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public float getLeftFadingEdgeStrength() {
        if (!this.E) {
            return 0.0f;
        }
        return super.getLeftFadingEdgeStrength();
    }

    public final void D() {
        View a2;
        int i;
        View findViewById;
        h hVar;
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
                hVar.b(a2, lb0.b(getContext(), 16.0f), 0, 0, 0);
            }
            if (this.q) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a2.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) a2.getLayoutParams();
            if (this.K && LiveFeedPageSdk.HOST_LIVE_TAB.equals(this.I)) {
                layoutParams2.height = lb0.b(getContext(), 26.0f);
                layoutParams2.setMargins(lb0.b(getContext(), 4.0f), lb0.b(getContext(), 10.0f), lb0.b(getContext(), 3.0f), lb0.b(getContext(), 10.0f));
            } else {
                layoutParams2.height = lb0.b(getContext(), 40.0f);
                layoutParams2.setMargins(lb0.b(getContext(), 9.0f), lb0.b(getContext(), 10.0f), lb0.b(getContext(), 9.0f), lb0.b(getContext(), 10.0f));
            }
            a2.setLayoutParams(layoutParams2);
            b bVar = this.o;
            if (bVar != null) {
                a2.setOnClickListener(bVar);
            }
            this.a.addView(a2);
            View view2 = null;
            int i3 = this.A;
            if (i3 != -1) {
                TextView textView = (TextView) a2.findViewById(i3);
                if (textView instanceof TabTextView) {
                    TabTextView tabTextView = (TabTextView) textView;
                    if (this.v) {
                        tabTextView.setGradientColorEnable(true);
                    } else {
                        tabTextView.setGradientColorEnable(false);
                        tabTextView.d();
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
                    yd0.h(textView, 0, this.g);
                }
            }
            int i4 = this.B;
            if (i4 != -1) {
                view2 = a2.findViewById(i4);
            }
            int i5 = 8;
            if (i2 == this.k.getCurrentItem()) {
                a2.setSelected(true);
                if ((a2 instanceof ViewGroup) && (i = this.C) != -1 && (findViewById = a2.findViewById(i)) != null) {
                    findViewById.setVisibility(8);
                }
                if (view2 != null) {
                    if (this.J) {
                        i5 = 0;
                    }
                    view2.setVisibility(i5);
                }
            } else if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        if (this.u) {
            t(this.a.getChildAt(this.k.getCurrentItem()), this.t + 1.0f);
        }
    }

    public final void F(int i, float f2) {
        int i2;
        int i3;
        int j;
        int i4;
        int childCount = this.a.getChildCount();
        if (childCount != 0 && i >= 0 && i < childCount) {
            boolean n = wb0.n(this);
            View childAt = this.a.getChildAt(i);
            int l = (int) ((wb0.l(childAt) + wb0.d(childAt)) * f2);
            if (this.a.h()) {
                if (0.0f < f2 && f2 < 1.0f) {
                    View childAt2 = this.a.getChildAt(i + 1);
                    l = Math.round(f2 * ((wb0.l(childAt) / 2) + wb0.c(childAt) + (wb0.l(childAt2) / 2) + wb0.e(childAt2)));
                }
                View childAt3 = this.a.getChildAt(0);
                if (n) {
                    int l2 = wb0.l(childAt3) + wb0.c(childAt3);
                    int l3 = wb0.l(childAt) + wb0.c(childAt);
                    j = (wb0.a(childAt) - wb0.c(childAt)) - l;
                    i4 = (l2 - l3) / 2;
                } else {
                    int l4 = wb0.l(childAt3) + wb0.e(childAt3);
                    int l5 = wb0.l(childAt) + wb0.e(childAt);
                    j = (wb0.j(childAt) - wb0.e(childAt)) + l;
                    i4 = (l4 - l5) / 2;
                }
                scrollTo(j - i4, 0);
            } else if (this.a.i()) {
                int e2 = lb0.e(getContext());
                scrollTo(((wb0.j(childAt) - wb0.e(childAt)) - (e2 / 2)) + (wb0.l(childAt) / 2) + wb0.c(childAt), 0);
            } else {
                if (this.b == -1) {
                    if (0.0f < f2 && f2 < 1.0f) {
                        View childAt4 = this.a.getChildAt(i + 1);
                        l = Math.round(f2 * ((wb0.l(childAt) / 2) + wb0.c(childAt) + (wb0.l(childAt4) / 2) + wb0.e(childAt4)));
                    }
                    if (n) {
                        i2 = (((-wb0.m(childAt)) / 2) + (getWidth() / 2)) - wb0.i(this);
                    } else {
                        i2 = ((wb0.m(childAt) / 2) - (getWidth() / 2)) + wb0.i(this);
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
                int j2 = wb0.j(childAt);
                int e3 = wb0.e(childAt);
                if (n) {
                    i3 = (((j2 + e3) - l) - getWidth()) + wb0.h(this);
                } else {
                    i3 = (j2 - e3) + l;
                }
                scrollTo(i2 + i3, 0);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ViewPager viewPager;
        super.onLayout(z, i, i2, i3, i4);
        if (z && (viewPager = this.k) != null) {
            F(viewPager.getCurrentItem(), 0.0f);
            this.r = this.k.getCurrentItem();
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        d dVar = this.m;
        if (dVar != null) {
            dVar.a(i, i3);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.a.h() && this.a.getChildCount() > 0) {
            View childAt = this.a.getChildAt(0);
            vb0 vb0Var = this.a;
            View childAt2 = vb0Var.getChildAt(vb0Var.getChildCount() - 1);
            int f2 = ((i - wb0.f(childAt)) / 2) - wb0.e(childAt);
            int f3 = ((i - wb0.f(childAt2)) / 2) - wb0.c(childAt2);
            vb0 vb0Var2 = this.a;
            vb0Var2.setMinimumWidth(vb0Var2.getMeasuredWidth());
            ViewCompat.setPaddingRelative(this, f2, getPaddingTop(), f3, getPaddingBottom());
            setClipToPadding(false);
        }
    }

    public void setCustomTextBackground(int i, int i2) {
        View w = w(i);
        if (w instanceof TextView) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setSize(lb0.b(getContext(), 50.0f), lb0.b(getContext(), 26.0f));
            gradientDrawable.setCornerRadii(this.L);
            gradientDrawable.setColors(new int[]{i2, i2});
            if (this.K) {
                ((TextView) w).setBackgroundDrawable(gradientDrawable);
            }
        }
    }

    public void setViewPager(ViewPager viewPager, LiveFeedConfig liveFeedConfig) {
        LiveFeedConfig.AbSwitchConfig abSwitchConfig;
        this.a.removeAllViews();
        this.k = viewPager;
        if (viewPager != null && viewPager.getAdapter() != null) {
            viewPager.clearOnPageChangeListeners();
            viewPager.addOnPageChangeListener(new c());
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

    public TextView u(CharSequence charSequence) {
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setText(charSequence);
        textView.setTextColor(this.f);
        yd0.h(textView, 0, this.g);
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
}
