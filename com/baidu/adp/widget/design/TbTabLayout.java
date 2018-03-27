package com.baidu.adp.widget.design;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.util.Pools;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbTabLayout extends HorizontalScrollView {
    private e awq;
    private final d awr;
    private b aws;
    private b awt;
    private ValueAnimator awu;
    private g awv;
    private a aww;
    int mMode;
    private final ArrayList<e> mTabs;
    int qC;
    int qD;
    int qE;
    int qF;
    int qG;
    ColorStateList qH;
    float qI;
    float qJ;
    final int qK;
    int qL;
    private final int qM;
    private final int qN;
    private final int qO;
    private int qP;
    int qQ;
    private final ArrayList<b> qS;
    ViewPager qV;
    private PagerAdapter qW;
    private DataSetObserver qX;
    private boolean ra;
    private final Pools.Pool<f> rb;
    private static final int[] sq = {R.attr.colorPrimary};
    public static final Interpolator kB = new FastOutSlowInInterpolator();
    private static final Pools.Pool<e> qz = new Pools.SynchronizedPool(16);

    /* loaded from: classes.dex */
    public interface b {
        void h(e eVar);

        void i(e eVar);

        void j(e eVar);
    }

    public TbTabLayout(Context context) {
        this(context, null);
    }

    public TbTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TbTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTabs = new ArrayList<>();
        this.qL = Integer.MAX_VALUE;
        this.qS = new ArrayList<>();
        this.rb = new Pools.SimplePool(12);
        R(context);
        setHorizontalScrollBarEnabled(false);
        this.awr = new d(context);
        super.addView(this.awr, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.R.styleable.TabLayout, i, android.support.design.R.style.Widget_Design_TabLayout);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, d.l.TbTabLayout);
        this.awr.O(obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabIndicatorHeight, 0));
        this.awr.dN(obtainStyledAttributes2.getDimensionPixelSize(d.l.TbTabLayout_tabIndicatorWidth, 0));
        this.awr.N(obtainStyledAttributes.getColor(android.support.design.R.styleable.TabLayout_tabIndicatorColor, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPadding, 0);
        this.qF = dimensionPixelSize;
        this.qE = dimensionPixelSize;
        this.qD = dimensionPixelSize;
        this.qC = dimensionPixelSize;
        this.qC = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingStart, this.qC);
        this.qD = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingTop, this.qD);
        this.qE = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingEnd, this.qE);
        this.qF = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingBottom, this.qF);
        this.qG = obtainStyledAttributes.getResourceId(android.support.design.R.styleable.TabLayout_tabTextAppearance, android.support.design.R.style.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(this.qG, R.styleable.TextAppearance);
        try {
            this.qI = obtainStyledAttributes3.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
            this.qH = obtainStyledAttributes3.getColorStateList(R.styleable.TextAppearance_android_textColor);
            obtainStyledAttributes3.recycle();
            if (obtainStyledAttributes.hasValue(android.support.design.R.styleable.TabLayout_tabTextColor)) {
                this.qH = obtainStyledAttributes.getColorStateList(android.support.design.R.styleable.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(android.support.design.R.styleable.TabLayout_tabSelectedTextColor)) {
                this.qH = createColorStateList(this.qH.getDefaultColor(), obtainStyledAttributes.getColor(android.support.design.R.styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.qM = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabMinWidth, -1);
            this.qN = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabMaxWidth, -1);
            this.qK = obtainStyledAttributes.getResourceId(android.support.design.R.styleable.TabLayout_tabBackground, 0);
            this.qP = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabContentStart, 0);
            this.mMode = obtainStyledAttributes.getInt(android.support.design.R.styleable.TabLayout_tabMode, 1);
            this.qQ = obtainStyledAttributes.getInt(android.support.design.R.styleable.TabLayout_tabGravity, 0);
            obtainStyledAttributes.recycle();
            obtainStyledAttributes2.recycle();
            Resources resources = getResources();
            this.qJ = resources.getDimensionPixelSize(android.support.design.R.dimen.design_tab_text_size_2line);
            this.qO = resources.getDimensionPixelSize(android.support.design.R.dimen.design_tab_scrollable_min_width);
            cm();
        } catch (Throwable th) {
            obtainStyledAttributes3.recycle();
            throw th;
        }
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.awr.N(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.awr.O(i);
    }

    public void setSelectedTabIndicatorWidth(int i) {
        this.awr.dN(i);
    }

    public void setScrollPosition(int i, float f2, boolean z) {
        a(i, f2, z, true);
    }

    void a(int i, float f2, boolean z, boolean z2) {
        int round = Math.round(i + f2);
        if (round >= 0 && round < this.awr.getChildCount()) {
            if (z2) {
                this.awr.c(i, f2);
            }
            if (this.awu != null && this.awu.isRunning()) {
                this.awu.cancel();
            }
            scrollTo(b(i, f2), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    private float getScrollPosition() {
        return this.awr.co();
    }

    public void a(e eVar) {
        a(eVar, this.mTabs.isEmpty());
    }

    public void a(e eVar, boolean z) {
        a(eVar, this.mTabs.size(), z);
    }

    public void a(e eVar, int i, boolean z) {
        if (eVar.awD != this) {
            throw new IllegalArgumentException("Tab belongs to a different TbTabLayout.");
        }
        a(eVar, i);
        c(eVar);
        if (z) {
            eVar.select();
        }
    }

    private void a(com.baidu.adp.widget.design.a aVar) {
        e sR = sR();
        if (aVar.mText != null) {
            sR.n(aVar.mText);
        }
        if (aVar.mIcon != null) {
            sR.i(aVar.mIcon);
        }
        if (aVar.qy != 0) {
            sR.dP(aVar.qy);
        }
        if (!TextUtils.isEmpty(aVar.getContentDescription())) {
            sR.o(aVar.getContentDescription());
        }
        a(sR);
    }

    @Deprecated
    public void setOnTabSelectedListener(b bVar) {
        if (this.aws != null) {
            b(this.aws);
        }
        this.aws = bVar;
        if (bVar != null) {
            a(bVar);
        }
    }

    public void a(b bVar) {
        if (!this.qS.contains(bVar)) {
            this.qS.add(bVar);
        }
    }

    public void b(b bVar) {
        this.qS.remove(bVar);
    }

    public e sR() {
        e acquire = qz.acquire();
        if (acquire == null) {
            acquire = new e();
        }
        acquire.awD = this;
        acquire.awE = b(acquire);
        return acquire;
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public e dM(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return this.mTabs.get(i);
    }

    public int getSelectedTabPosition() {
        if (this.awq != null) {
            return this.awq.getPosition();
        }
        return -1;
    }

    public void removeAllTabs() {
        for (int childCount = this.awr.getChildCount() - 1; childCount >= 0; childCount--) {
            M(childCount);
        }
        Iterator<e> it = this.mTabs.iterator();
        while (it.hasNext()) {
            e next = it.next();
            it.remove();
            next.reset();
            qz.release(next);
        }
        this.awq = null;
    }

    public void setTabMode(int i) {
        if (i != this.mMode) {
            this.mMode = i;
            cm();
        }
    }

    public int getTabMode() {
        return this.mMode;
    }

    public void setTabGravity(int i) {
        if (this.qQ != i) {
            this.qQ = i;
            cm();
        }
    }

    public int getTabGravity() {
        return this.qQ;
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.qH != colorStateList) {
            this.qH = colorStateList;
            ck();
        }
    }

    public ColorStateList getTabTextColors() {
        return this.qH;
    }

    public void setTabTextColors(int i, int i2) {
        setTabTextColors(createColorStateList(i, i2));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    public void setupWithViewPager(ViewPager viewPager, boolean z) {
        a(viewPager, z, false);
    }

    private void a(ViewPager viewPager, boolean z, boolean z2) {
        if (this.qV != null) {
            if (this.awv != null) {
                this.qV.removeOnPageChangeListener(this.awv);
            }
            if (this.aww != null) {
                this.qV.removeOnAdapterChangeListener(this.aww);
            }
        }
        if (this.awt != null) {
            b(this.awt);
            this.awt = null;
        }
        if (viewPager != null) {
            this.qV = viewPager;
            if (this.awv == null) {
                this.awv = new g(this);
            }
            this.awv.reset();
            viewPager.addOnPageChangeListener(this.awv);
            this.awt = new h(viewPager);
            a(this.awt);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                a(adapter, z);
            }
            if (this.aww == null) {
                this.aww = new a();
            }
            this.aww.o(z);
            viewPager.addOnAdapterChangeListener(this.aww);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.qV = null;
            a((PagerAdapter) null, false);
        }
        this.ra = z2;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(PagerAdapter pagerAdapter) {
        a(pagerAdapter, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.qV == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                a((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ra) {
            setupWithViewPager(null);
            this.ra = false;
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.awr.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    void a(PagerAdapter pagerAdapter, boolean z) {
        if (this.qW != null && this.qX != null) {
            this.qW.unregisterDataSetObserver(this.qX);
        }
        this.qW = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.qX == null) {
                this.qX = new c();
            }
            pagerAdapter.registerDataSetObserver(this.qX);
        }
        cj();
    }

    void cj() {
        int currentItem;
        removeAllTabs();
        if (this.qW != null) {
            int count = this.qW.getCount();
            for (int i = 0; i < count; i++) {
                a(sR().n(this.qW.getPageTitle(i)), false);
            }
            if (this.qV != null && count > 0 && (currentItem = this.qV.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                d(dM(currentItem));
            }
        }
    }

    private void ck() {
        int size = this.mTabs.size();
        for (int i = 0; i < size; i++) {
            this.mTabs.get(i).cq();
        }
    }

    private f b(e eVar) {
        f acquire = this.rb != null ? this.rb.acquire() : null;
        if (acquire == null) {
            acquire = new f(getContext());
        }
        acquire.k(eVar);
        acquire.setFocusable(true);
        acquire.setMinimumWidth(getTabMinWidth());
        return acquire;
    }

    private void a(e eVar, int i) {
        eVar.setPosition(i);
        this.mTabs.add(i, eVar);
        int size = this.mTabs.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            this.mTabs.get(i2).setPosition(i2);
        }
    }

    private void c(e eVar) {
        this.awr.addView(eVar.awE, eVar.getPosition(), cl());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        E(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i) {
        E(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        E(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        E(view);
    }

    private void E(View view) {
        if (view instanceof com.baidu.adp.widget.design.a) {
            a((com.baidu.adp.widget.design.a) view);
            return;
        }
        throw new IllegalArgumentException("Only FcTabItem instances can be added to TbTabLayout");
    }

    private LinearLayout.LayoutParams cl() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        return layoutParams;
    }

    private void a(LinearLayout.LayoutParams layoutParams) {
        if (this.mMode == 1 && this.qQ == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    int L(int i) {
        return Math.round(getResources().getDisplayMetrics().density * i);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z;
        int L = L(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
        switch (View.MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                i2 = View.MeasureSpec.makeMeasureSpec(Math.min(L, View.MeasureSpec.getSize(i2)), 1073741824);
                break;
            case 0:
                i2 = View.MeasureSpec.makeMeasureSpec(L, 1073741824);
                break;
        }
        int size = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i) != 0) {
            this.qL = this.qN > 0 ? this.qN : size - L(56);
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.mMode) {
                case 0:
                    if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 1:
                    z = childAt.getMeasuredWidth() != getMeasuredWidth();
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    private void M(int i) {
        f fVar = (f) this.awr.getChildAt(i);
        this.awr.removeViewAt(i);
        if (fVar != null) {
            fVar.reset();
            this.rb.release(fVar);
        }
        requestLayout();
    }

    private void animateToTab(int i) {
        if (i != -1) {
            if (getWindowToken() == null || !ViewCompat.isLaidOut(this) || this.awr.cn()) {
                setScrollPosition(i, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int b2 = b(i, 0.0f);
            if (scrollX != b2) {
                sS();
                this.awu.setIntValues(scrollX, b2);
                this.awu.start();
            }
            this.awr.p(i, 300);
        }
    }

    private void sS() {
        if (this.awu == null) {
            this.awu = new ValueAnimator();
            this.awu.setInterpolator(kB);
            this.awu.setDuration(300L);
            this.awu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.adp.widget.design.TbTabLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TbTabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        sS();
        this.awu.addListener(animatorListener);
    }

    private void setSelectedTabView(int i) {
        int childCount = this.awr.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                this.awr.getChildAt(i2).setSelected(i2 == i);
                i2++;
            }
        }
    }

    void d(e eVar) {
        b(eVar, true);
    }

    void b(e eVar, boolean z) {
        e eVar2 = this.awq;
        if (eVar2 == eVar) {
            if (eVar2 != null) {
                g(eVar);
                animateToTab(eVar.getPosition());
                return;
            }
            return;
        }
        int position = eVar != null ? eVar.getPosition() : -1;
        if (z) {
            if ((eVar2 == null || eVar2.getPosition() == -1) && position != -1) {
                setScrollPosition(position, 0.0f, true);
            } else {
                animateToTab(position);
            }
            if (position != -1) {
                setSelectedTabView(position);
            }
        }
        if (eVar2 != null) {
            f(eVar2);
        }
        this.awq = eVar;
        if (eVar != null) {
            e(eVar);
        }
    }

    private void e(e eVar) {
        for (int size = this.qS.size() - 1; size >= 0; size--) {
            this.qS.get(size).h(eVar);
        }
    }

    private void f(e eVar) {
        for (int size = this.qS.size() - 1; size >= 0; size--) {
            this.qS.get(size).i(eVar);
        }
    }

    private void g(e eVar) {
        for (int size = this.qS.size() - 1; size >= 0; size--) {
            this.qS.get(size).j(eVar);
        }
    }

    private int b(int i, float f2) {
        if (this.mMode == 0) {
            View childAt = this.awr.getChildAt(i);
            View childAt2 = i + 1 < this.awr.getChildCount() ? this.awr.getChildAt(i + 1) : null;
            int width = childAt != null ? childAt.getWidth() : 0;
            int width2 = childAt2 != null ? childAt2.getWidth() : 0;
            int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
            int i2 = (int) ((width2 + width) * 0.5f * f2);
            return ViewCompat.getLayoutDirection(this) == 0 ? i2 + left : left - i2;
        }
        return 0;
    }

    private void cm() {
        ViewCompat.setPaddingRelative(this.awr, this.mMode == 0 ? Math.max(0, this.qP - this.qC) : 0, 0, 0, 0);
        switch (this.mMode) {
            case 0:
                this.awr.setGravity(GravityCompat.START);
                break;
            case 1:
                this.awr.setGravity(1);
                break;
        }
        n(true);
    }

    void n(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.awr.getChildCount()) {
                View childAt = this.awr.getChildAt(i2);
                childAt.setMinimumWidth(getTabMinWidth());
                a((LinearLayout.LayoutParams) childAt.getLayoutParams());
                if (z) {
                    childAt.requestLayout();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class e {
        TbTabLayout awD;
        f awE;
        private View mCustomView;
        private Drawable mIcon;
        private int mId;
        private CharSequence mText;
        private Object rr;
        private CharSequence rs;
        private int mPosition = -1;
        private int awB = 0;
        private boolean awC = false;

        e() {
        }

        public int sT() {
            return this.awB;
        }

        public e r(int i, boolean z) {
            this.awB = i;
            this.awC = z;
            cq();
            return this;
        }

        public boolean isShowRedDot() {
            return this.awC;
        }

        public int getId() {
            return this.mId;
        }

        public e dO(int i) {
            this.mId = i;
            return this;
        }

        public View getCustomView() {
            return this.mCustomView;
        }

        public e aK(View view) {
            this.mCustomView = view;
            cq();
            return this;
        }

        public e dP(int i) {
            return aK(LayoutInflater.from(this.awE.getContext()).inflate(i, (ViewGroup) this.awE, false));
        }

        public Drawable getIcon() {
            return this.mIcon;
        }

        public int getPosition() {
            return this.mPosition;
        }

        void setPosition(int i) {
            this.mPosition = i;
        }

        public CharSequence getText() {
            return this.mText;
        }

        public e i(Drawable drawable) {
            this.mIcon = drawable;
            cq();
            return this;
        }

        public e n(CharSequence charSequence) {
            this.mText = charSequence;
            cq();
            return this;
        }

        public void select() {
            if (this.awD == null) {
                throw new IllegalArgumentException("Tab not attached to a TbTabLayout");
            }
            this.awD.d(this);
        }

        public boolean isSelected() {
            if (this.awD == null) {
                throw new IllegalArgumentException("Tab not attached to a TbTabLayout");
            }
            return this.awD.getSelectedTabPosition() == this.mPosition;
        }

        public e o(CharSequence charSequence) {
            this.rs = charSequence;
            cq();
            return this;
        }

        public CharSequence getContentDescription() {
            return this.rs;
        }

        void cq() {
            if (this.awE != null) {
                this.awE.update();
            }
        }

        void reset() {
            this.awD = null;
            this.awE = null;
            this.rr = null;
            this.mIcon = null;
            this.mText = null;
            this.rs = null;
            this.mPosition = -1;
            this.mCustomView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends LinearLayout {
        private e awF;
        private Drawable awG;
        private String awH;
        private View mCustomView;
        private ImageView mIconView;
        private ImageView rA;
        private int rB;
        private TextView ry;
        private TextView rz;

        public f(Context context) {
            super(context);
            this.rB = 2;
            if (TbTabLayout.this.qK != 0) {
                ViewCompat.setBackground(this, AppCompatResources.getDrawable(context, TbTabLayout.this.qK));
            }
            ViewCompat.setPaddingRelative(this, TbTabLayout.this.qC, TbTabLayout.this.qD, TbTabLayout.this.qE, TbTabLayout.this.qF);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.awF != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.awF.select();
                return true;
            }
            return performClick;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            if (this.ry != null) {
                this.ry.setSelected(z);
            }
            if (this.mIconView != null) {
                this.mIconView.setSelected(z);
            }
            if (this.mCustomView != null) {
                this.mCustomView.setSelected(z);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Layout layout;
            boolean z = true;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = TbTabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TbTabLayout.this.qL, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.ry != null) {
                getResources();
                float f = TbTabLayout.this.qI;
                int i3 = this.rB;
                if (this.mIconView != null && this.mIconView.getVisibility() == 0) {
                    i3 = 1;
                } else if (this.ry != null && this.ry.getLineCount() > 1) {
                    f = TbTabLayout.this.qJ;
                }
                float textSize = this.ry.getTextSize();
                int lineCount = this.ry.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.ry);
                if (f != textSize || (maxLines >= 0 && i3 != maxLines)) {
                    if (TbTabLayout.this.mMode == 1 && f > textSize && lineCount == 1 && ((layout = this.ry.getLayout()) == null || a(layout, 0, f) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.ry.setTextSize(0, f);
                        this.ry.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        void k(e eVar) {
            if (eVar != this.awF) {
                this.awF = eVar;
                update();
            }
        }

        void reset() {
            k(null);
            setSelected(false);
        }

        final void update() {
            e eVar = this.awF;
            View customView = eVar != null ? eVar.getCustomView() : null;
            if (customView != null) {
                ViewParent parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(customView);
                    }
                    addView(customView);
                }
                this.mCustomView = customView;
                if (this.ry != null) {
                    this.ry.setVisibility(8);
                }
                if (this.mIconView != null) {
                    this.mIconView.setVisibility(8);
                    this.mIconView.setImageDrawable(null);
                }
                this.rz = (TextView) customView.findViewById(16908308);
                if (this.rz != null) {
                    this.rB = TextViewCompat.getMaxLines(this.rz);
                }
                this.rA = (ImageView) customView.findViewById(16908294);
            } else {
                if (this.mCustomView != null) {
                    removeView(this.mCustomView);
                    this.mCustomView = null;
                }
                this.rz = null;
                this.rA = null;
            }
            if (this.mCustomView == null) {
                if (this.mIconView == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(android.support.design.R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                    addView(imageView, 0);
                    this.mIconView = imageView;
                }
                if (this.ry == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(android.support.design.R.layout.design_layout_tab_text, (ViewGroup) this, false);
                    addView(textView);
                    this.ry = textView;
                    this.rB = TextViewCompat.getMaxLines(this.ry);
                }
                TextViewCompat.setTextAppearance(this.ry, TbTabLayout.this.qG);
                if (TbTabLayout.this.qH != null) {
                    this.ry.setTextColor(TbTabLayout.this.qH);
                }
                b(this.ry, this.mIconView);
            } else if (this.rz != null || this.rA != null) {
                b(this.rz, this.rA);
            }
            setSelected(eVar != null && eVar.isSelected());
        }

        private void b(TextView textView, ImageView imageView) {
            int i = 0;
            Drawable icon = this.awF != null ? this.awF.getIcon() : null;
            CharSequence text = this.awF != null ? this.awF.getText() : null;
            CharSequence contentDescription = this.awF != null ? this.awF.getContentDescription() : null;
            int sT = this.awF != null ? this.awF.sT() : 0;
            boolean isShowRedDot = this.awF != null ? this.awF.isShowRedDot() : false;
            if (imageView != null) {
                if (icon != null) {
                    imageView.setImageDrawable(icon);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(contentDescription);
            }
            boolean z = !TextUtils.isEmpty(text);
            if (textView != null) {
                if (z) {
                    textView.setText(text);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
                textView.setContentDescription(contentDescription);
            }
            if (textView != null && z) {
                if (isShowRedDot) {
                    int t = l.t(getContext(), d.e.tbds50);
                    TbTabLayout.this.awr.setPadding(t, TbTabLayout.this.awr.getPaddingTop(), t, TbTabLayout.this.awr.getPaddingBottom());
                    if (sT <= 0) {
                        this.awG = aj.getDrawable(d.f.icon_news_red_dot);
                        this.awH = null;
                    } else if (sT < 10) {
                        this.awG = aj.getDrawable(d.f.icon_news_red_dot_one_number);
                        this.awH = String.valueOf(sT);
                    } else if (sT < 100) {
                        this.awG = aj.getDrawable(d.f.icon_news_red_dot_two_number);
                        this.awH = String.valueOf(sT);
                    } else {
                        this.awG = aj.getDrawable(d.f.icon_news_red_dot_two_number);
                        this.awH = "...";
                    }
                    if (this.awG == null) {
                        this.awG = aj.getDrawable(d.f.icon_news_red_dot);
                    }
                } else {
                    this.awG = null;
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (z && imageView.getVisibility() == 0) {
                    i = TbTabLayout.this.L(8);
                }
                if (i != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i;
                    imageView.requestLayout();
                }
            }
        }

        private float a(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends LinearLayout {
        private int Pl;
        private int awy;
        private ValueAnimator awz;
        int mSelectedPosition;
        private int re;
        private final Paint rf;
        float rg;
        private int rh;
        private int ri;

        d(Context context) {
            super(context);
            this.mSelectedPosition = -1;
            this.Pl = -1;
            this.rh = -1;
            this.ri = -1;
            setWillNotDraw(false);
            this.rf = new Paint();
            this.rf.setStrokeCap(Paint.Cap.ROUND);
            this.rf.setAntiAlias(true);
        }

        void N(int i) {
            if (this.rf.getColor() != i) {
                this.rf.setColor(i);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void O(int i) {
            if (this.re != i) {
                this.re = i;
                this.rf.setStrokeWidth(this.re);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void dN(int i) {
            if (this.awy != i) {
                this.awy = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        boolean cn() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        void c(int i, float f) {
            if (this.awz != null && this.awz.isRunning()) {
                this.awz.cancel();
            }
            this.mSelectedPosition = i;
            this.rg = f;
            cp();
        }

        float co() {
            return this.mSelectedPosition + this.rg;
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT < 23 && this.Pl != i) {
                requestLayout();
                this.Pl = i;
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            boolean z;
            boolean z2 = false;
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) == 1073741824 && TbTabLayout.this.mMode == 1 && TbTabLayout.this.qQ == 1) {
                int childCount = getChildCount();
                int i3 = 0;
                int i4 = 0;
                while (i3 < childCount) {
                    View childAt = getChildAt(i3);
                    i3++;
                    i4 = childAt.getVisibility() == 0 ? Math.max(i4, childAt.getMeasuredWidth()) : i4;
                }
                if (i4 > 0) {
                    if (i4 * childCount <= getMeasuredWidth() - (TbTabLayout.this.L(16) * 2)) {
                        int i5 = 0;
                        while (i5 < childCount) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                            if (layoutParams.width == i4 && layoutParams.weight == 0.0f) {
                                z = z2;
                            } else {
                                layoutParams.width = i4;
                                layoutParams.weight = 0.0f;
                                z = true;
                            }
                            i5++;
                            z2 = z;
                        }
                    } else {
                        TbTabLayout.this.qQ = 0;
                        TbTabLayout.this.n(false);
                        z2 = true;
                    }
                    if (z2) {
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.awz != null && this.awz.isRunning()) {
                this.awz.cancel();
                p(this.mSelectedPosition, Math.round(((float) this.awz.getDuration()) * (1.0f - this.awz.getAnimatedFraction())));
                return;
            }
            cp();
        }

        private void cp() {
            int i;
            int i2;
            View childAt = getChildAt(this.mSelectedPosition);
            if (childAt != null && childAt.getWidth() > 0) {
                i2 = childAt.getLeft();
                i = childAt.getRight();
                if (this.rg > 0.0f && this.mSelectedPosition < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.mSelectedPosition + 1);
                    i2 = (int) ((i2 * (1.0f - this.rg)) + (this.rg * childAt2.getLeft()));
                    i = (int) ((i * (1.0f - this.rg)) + (childAt2.getRight() * this.rg));
                }
            } else {
                i = -1;
                i2 = -1;
            }
            o(i2, i);
        }

        void o(int i, int i2) {
            if (i != this.rh || i2 != this.ri) {
                this.rh = i;
                this.ri = i2;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void p(final int i, int i2) {
            final int i3;
            final int i4;
            if (this.awz != null && this.awz.isRunning()) {
                this.awz.cancel();
            }
            boolean z = ViewCompat.getLayoutDirection(this) == 1;
            View childAt = getChildAt(i);
            if (childAt == null) {
                cp();
                return;
            }
            final int left = childAt.getLeft();
            final int right = childAt.getRight();
            if (Math.abs(i - this.mSelectedPosition) <= 1) {
                i4 = this.rh;
                i3 = this.ri;
            } else {
                int L = TbTabLayout.this.L(24);
                if (i < this.mSelectedPosition) {
                    if (z) {
                        i3 = left - L;
                        i4 = i3;
                    } else {
                        i3 = right + L;
                        i4 = i3;
                    }
                } else if (z) {
                    i3 = right + L;
                    i4 = i3;
                } else {
                    i3 = left - L;
                    i4 = i3;
                }
            }
            if (i4 != left || i3 != right) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.awz = valueAnimator;
                valueAnimator.setInterpolator(TbTabLayout.kB);
                valueAnimator.setDuration(i2);
                valueAnimator.setFloatValues(0.0f, 1.0f);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.adp.widget.design.TbTabLayout.d.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        float animatedFraction = valueAnimator2.getAnimatedFraction();
                        d.this.o(TbTabLayout.b(i4, left, animatedFraction), TbTabLayout.b(i3, right, animatedFraction));
                    }
                });
                valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.adp.widget.design.TbTabLayout.d.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        d.this.mSelectedPosition = i;
                        d.this.rg = 0.0f;
                    }
                });
                valueAnimator.start();
            }
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int intrinsicHeight;
            Rect rect;
            super.draw(canvas);
            if (this.rh >= 0 && this.ri > this.rh) {
                int i = (this.awy <= 0 || this.ri - this.rh <= this.awy) ? 0 : ((this.ri - this.rh) - this.awy) / 2;
                canvas.drawLine(this.rh + i, getHeight() - (this.re / 2), this.ri - i, getHeight() - (this.re / 2), this.rf);
            }
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (getChildAt(childCount) instanceof f) {
                    f fVar = (f) getChildAt(childCount);
                    if (fVar.awG != null) {
                        TextView textView = null;
                        if (fVar.ry != null) {
                            textView = fVar.ry;
                        } else if (fVar.rz != null) {
                            textView = fVar.rz;
                        }
                        if (textView != null) {
                            int right = (fVar.getRight() - (fVar.getWidth() - textView.getRight())) - l.t(getContext(), d.e.tbds3);
                            int top = (textView.getTop() - (fVar.awG.getIntrinsicHeight() / 2)) + l.t(getContext(), d.e.tbds10);
                            fVar.awG.setBounds(right, top, fVar.awG.getIntrinsicWidth() + right, fVar.awG.getIntrinsicHeight() + top);
                            fVar.awG.draw(canvas);
                            if (!TextUtils.isEmpty(fVar.awH)) {
                                if (fVar.awH.equals("...")) {
                                    Drawable drawable = aj.getDrawable(d.f.icon_news_white_dot);
                                    int intrinsicWidth = right + (fVar.awG.getIntrinsicWidth() / 2);
                                    int intrinsicHeight2 = (fVar.awG.getIntrinsicHeight() / 2) + top;
                                    int t = l.t(getContext(), d.e.tbds6);
                                    int t2 = l.t(getContext(), d.e.tbds7);
                                    int i2 = intrinsicWidth - (t / 2);
                                    int i3 = intrinsicHeight2 - (t / 2);
                                    int i4 = intrinsicWidth + (t / 2);
                                    int i5 = intrinsicHeight2 + (t / 2);
                                    drawable.setBounds(i2, i3, i4, i5);
                                    drawable.draw(canvas);
                                    drawable.setBounds((i2 - t2) - t, i3, i2 - t2, i5);
                                    drawable.draw(canvas);
                                    drawable.setBounds(i4 + t2, i3, t + i4 + t2, i5);
                                    drawable.draw(canvas);
                                } else {
                                    Paint paint = new Paint(1);
                                    paint.setColor(aj.getColor(d.C0141d.cp_cont_i));
                                    paint.setTextSize(l.t(getContext(), d.e.tbfontsize26));
                                    paint.setTextAlign(Paint.Align.CENTER);
                                    paint.setTypeface(Typeface.MONOSPACE);
                                    paint.getTextBounds(fVar.awH, 0, fVar.awH.length(), new Rect());
                                    canvas.drawText(fVar.awH, right + (fVar.awG.getIntrinsicWidth() / 2), intrinsicHeight - ((fVar.awG.getIntrinsicHeight() - rect.height()) / 2), paint);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static ColorStateList createColorStateList(int i, int i2) {
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{i2, i});
    }

    private int getDefaultHeight() {
        boolean z;
        int size = this.mTabs.size();
        int i = 0;
        while (true) {
            if (i < size) {
                e eVar = this.mTabs.get(i);
                if (eVar == null || eVar.getIcon() == null || TextUtils.isEmpty(eVar.getText())) {
                    i++;
                } else {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        return z ? 72 : 48;
    }

    private int getTabMinWidth() {
        if (this.qM != -1) {
            return this.qM;
        }
        if (this.mMode == 0) {
            return this.qO;
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    int getTabMaxWidth() {
        return this.qL;
    }

    /* loaded from: classes.dex */
    public static class g implements ViewPager.OnPageChangeListener {
        private final WeakReference<TbTabLayout> awI;
        private int mScrollState;
        private int rw;

        public g(TbTabLayout tbTabLayout) {
            this.awI = new WeakReference<>(tbTabLayout);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.rw = this.mScrollState;
            this.mScrollState = i;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            boolean z = false;
            TbTabLayout tbTabLayout = this.awI.get();
            if (tbTabLayout != null) {
                boolean z2 = this.mScrollState != 2 || this.rw == 1;
                if (this.mScrollState != 2 || this.rw != 0) {
                    z = true;
                }
                tbTabLayout.a(i, f, z2, z);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            TbTabLayout tbTabLayout = this.awI.get();
            if (tbTabLayout != null && tbTabLayout.getSelectedTabPosition() != i && i < tbTabLayout.getTabCount()) {
                tbTabLayout.b(tbTabLayout.dM(i), this.mScrollState == 0 || (this.mScrollState == 2 && this.rw == 0));
            }
        }

        void reset() {
            this.mScrollState = 0;
            this.rw = 0;
        }
    }

    /* loaded from: classes.dex */
    public static class h implements b {
        private final ViewPager qV;

        public h(ViewPager viewPager) {
            this.qV = viewPager;
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(e eVar) {
            this.qV.setCurrentItem(eVar.getPosition());
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void i(e eVar) {
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void j(e eVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends DataSetObserver {
        c() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TbTabLayout.this.cj();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TbTabLayout.this.cj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements ViewPager.OnAdapterChangeListener {
        private boolean rd;

        a() {
        }

        @Override // android.support.v4.view.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            if (TbTabLayout.this.qV == viewPager) {
                TbTabLayout.this.a(pagerAdapter2, this.rd);
            }
        }

        void o(boolean z) {
            this.rd = z;
        }
    }

    public static void R(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(sq);
        boolean z = obtainStyledAttributes.hasValue(0) ? false : true;
        obtainStyledAttributes.recycle();
        if (z) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }

    public static int b(int i, int i2, float f2) {
        return Math.round((i2 - i) * f2) + i;
    }
}
