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
import android.support.annotation.ColorInt;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import android.support.v7.widget.ActivityChooserView;
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
import com.baidu.android.util.devices.RomUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.am;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbTabLayout extends HorizontalScrollView {
    private static final int[] APPCOMPAT_CHECK_ATTRS = {R.attr.colorPrimary};
    public static final Interpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
    private static final Pools.Pool<e> sTabPool = new Pools.SynchronizedPool(16);
    private e VV;
    private final d VW;
    float VX;
    boolean VY;
    private b VZ;
    private b Wa;
    private TbTabLayoutOnPageChangeListener Wb;
    private a Wc;
    private boolean We;
    private int Wf;
    private int mContentInsetStart;
    int mMode;
    private PagerAdapter mPagerAdapter;
    private DataSetObserver mPagerAdapterObserver;
    private final int mRequestedTabMaxWidth;
    private final int mRequestedTabMinWidth;
    private ValueAnimator mScrollAnimator;
    private final int mScrollableTabMinWidth;
    private final ArrayList<b> mSelectedListeners;
    private boolean mSetupViewPagerImplicitly;
    final int mTabBackgroundResId;
    int mTabGravity;
    int mTabMaxWidth;
    int mTabPaddingBottom;
    int mTabPaddingEnd;
    int mTabPaddingStart;
    int mTabPaddingTop;
    int mTabTextAppearance;
    ColorStateList mTabTextColors;
    float mTabTextMultiLineSize;
    float mTabTextSize;
    private final Pools.Pool<f> mTabViewPool;
    private final ArrayList<e> mTabs;
    ViewPager mViewPager;

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
        this.mTabMaxWidth = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mSelectedListeners = new ArrayList<>();
        this.We = false;
        this.mTabViewPool = new Pools.SimplePool(12);
        checkAppCompatTheme(context);
        setHorizontalScrollBarEnabled(false);
        this.VW = new d(context);
        super.addView(this.VW, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.R.styleable.TabLayout, i, android.support.design.R.style.Widget_Design_TabLayout);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.R.styleable.TbTabLayout);
        this.VW.setSelectedIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabIndicatorHeight, 0));
        this.VW.aG(obtainStyledAttributes2.getDimensionPixelSize(0, 0));
        this.VW.setSelectedIndicatorColor(obtainStyledAttributes.getColor(android.support.design.R.styleable.TabLayout_tabIndicatorColor, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPadding, 0);
        this.mTabPaddingBottom = dimensionPixelSize;
        this.mTabPaddingEnd = dimensionPixelSize;
        this.mTabPaddingTop = dimensionPixelSize;
        this.mTabPaddingStart = dimensionPixelSize;
        this.mTabPaddingStart = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingStart, this.mTabPaddingStart);
        this.mTabPaddingTop = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingTop, this.mTabPaddingTop);
        this.mTabPaddingEnd = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingEnd, this.mTabPaddingEnd);
        this.mTabPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingBottom, this.mTabPaddingBottom);
        this.mTabTextAppearance = obtainStyledAttributes.getResourceId(android.support.design.R.styleable.TabLayout_tabTextAppearance, android.support.design.R.style.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(this.mTabTextAppearance, R.styleable.TextAppearance);
        try {
            this.mTabTextSize = obtainStyledAttributes3.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
            this.mTabTextColors = obtainStyledAttributes3.getColorStateList(R.styleable.TextAppearance_android_textColor);
            obtainStyledAttributes3.recycle();
            if (obtainStyledAttributes.hasValue(android.support.design.R.styleable.TabLayout_tabTextColor)) {
                this.mTabTextColors = obtainStyledAttributes.getColorStateList(android.support.design.R.styleable.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(android.support.design.R.styleable.TabLayout_tabSelectedTextColor)) {
                this.mTabTextColors = createColorStateList(this.mTabTextColors.getDefaultColor(), obtainStyledAttributes.getColor(android.support.design.R.styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.mRequestedTabMinWidth = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabMinWidth, -1);
            this.mRequestedTabMaxWidth = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabMaxWidth, -1);
            this.mTabBackgroundResId = obtainStyledAttributes.getResourceId(android.support.design.R.styleable.TabLayout_tabBackground, 0);
            this.mContentInsetStart = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabContentStart, 0);
            this.mMode = obtainStyledAttributes.getInt(android.support.design.R.styleable.TabLayout_tabMode, 1);
            this.mTabGravity = obtainStyledAttributes.getInt(android.support.design.R.styleable.TabLayout_tabGravity, 0);
            obtainStyledAttributes.recycle();
            obtainStyledAttributes2.recycle();
            Resources resources = getResources();
            this.mTabTextMultiLineSize = resources.getDimensionPixelSize(android.support.design.R.dimen.design_tab_text_size_2line);
            this.mScrollableTabMinWidth = resources.getDimensionPixelSize(android.support.design.R.dimen.design_tab_scrollable_min_width);
            applyModeAndGravity();
            pm();
        } catch (Throwable th) {
            obtainStyledAttributes3.recycle();
            throw th;
        }
    }

    public void setDisableTabSelect(boolean z) {
        this.We = z;
    }

    private void pm() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            this.Wf = l.getDimens(getContext(), com.baidu.tieba.R.dimen.tbds2);
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i) {
        this.VW.setSelectedIndicatorColor(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.VW.setSelectedIndicatorHeight(i);
    }

    public void setSelectedTabIndicatorWidth(int i) {
        this.VW.aG(i);
    }

    public void setScrollPosition(int i, float f2, boolean z) {
        setScrollPosition(i, f2, z, true);
    }

    void setScrollPosition(int i, float f2, boolean z, boolean z2) {
        int round = Math.round(i + f2);
        if (round >= 0 && round < this.VW.getChildCount()) {
            if (z2) {
                this.VW.setIndicatorPositionFromTabPosition(i, f2);
            }
            if (this.mScrollAnimator != null && this.mScrollAnimator.isRunning()) {
                this.mScrollAnimator.cancel();
            }
            scrollTo(calculateScrollXForTab(i, f2), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    private float getScrollPosition() {
        return this.VW.getIndicatorPosition();
    }

    public void a(@NonNull e eVar) {
        a(eVar, this.mTabs.isEmpty());
    }

    public void a(@NonNull e eVar, boolean z) {
        a(eVar, this.mTabs.size(), z);
    }

    public void a(@NonNull e eVar, int i, boolean z) {
        if (eVar.Wl != this) {
            throw new IllegalArgumentException("Tab belongs to a different TbTabLayout.");
        }
        a(eVar, i);
        c(eVar);
        if (z) {
            eVar.select();
        }
    }

    private void a(@NonNull TbTabItem tbTabItem) {
        e pn = pn();
        if (tbTabItem.mText != null) {
            pn.b(tbTabItem.mText);
        }
        if (tbTabItem.mIcon != null) {
            pn.b(tbTabItem.mIcon);
        }
        if (tbTabItem.mCustomLayout != 0) {
            pn.aI(tbTabItem.mCustomLayout);
        }
        if (!TextUtils.isEmpty(tbTabItem.getContentDescription())) {
            pn.c(tbTabItem.getContentDescription());
        }
        a(pn);
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable b bVar) {
        if (this.VZ != null) {
            b(this.VZ);
        }
        this.VZ = bVar;
        if (bVar != null) {
            a(bVar);
        }
    }

    public void a(@NonNull b bVar) {
        if (!this.mSelectedListeners.contains(bVar)) {
            this.mSelectedListeners.add(bVar);
        }
    }

    public void b(@NonNull b bVar) {
        this.mSelectedListeners.remove(bVar);
    }

    @NonNull
    public e pn() {
        e acquire = sTabPool.acquire();
        if (acquire == null) {
            acquire = new e();
        }
        acquire.Wl = this;
        acquire.Wm = b(acquire);
        return acquire;
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    @Nullable
    public e aF(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return this.mTabs.get(i);
    }

    public int getSelectedTabPosition() {
        if (this.VV != null) {
            return this.VV.getPosition();
        }
        return -1;
    }

    public void removeAllTabs() {
        for (int childCount = this.VW.getChildCount() - 1; childCount >= 0; childCount--) {
            removeTabViewAt(childCount);
        }
        Iterator<e> it = this.mTabs.iterator();
        while (it.hasNext()) {
            e next = it.next();
            it.remove();
            next.reset();
            sTabPool.release(next);
        }
        this.VV = null;
    }

    public void setTabMode(int i) {
        if (i != this.mMode) {
            this.mMode = i;
            applyModeAndGravity();
        }
    }

    public int getTabMode() {
        return this.mMode;
    }

    public void setTabGravity(int i) {
        if (this.mTabGravity != i) {
            this.mTabGravity = i;
            applyModeAndGravity();
        }
    }

    public int getTabGravity() {
        return this.mTabGravity;
    }

    public void setTabTextSize(int i) {
        this.mTabTextSize = i;
    }

    public void setSelectedTabTextSize(int i) {
        this.VX = i;
    }

    public void setSelectedTabTextBlod(boolean z) {
        this.VY = z;
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.mTabTextColors != colorStateList) {
            this.mTabTextColors = colorStateList;
            updateAllTabs();
        }
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.mTabTextColors;
    }

    public void setTabTextColors(int i, int i2) {
        setTabTextColors(createColorStateList(i, i2));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager, boolean z) {
        setupWithViewPager(viewPager, z, false);
    }

    private void setupWithViewPager(@Nullable ViewPager viewPager, boolean z, boolean z2) {
        if (this.mViewPager != null) {
            if (this.Wb != null) {
                this.mViewPager.removeOnPageChangeListener(this.Wb);
            }
            if (this.Wc != null) {
                this.mViewPager.removeOnAdapterChangeListener(this.Wc);
            }
        }
        if (this.Wa != null) {
            b(this.Wa);
            this.Wa = null;
        }
        if (viewPager != null) {
            this.mViewPager = viewPager;
            if (this.Wb == null) {
                this.Wb = new TbTabLayoutOnPageChangeListener(this);
            }
            this.Wb.reset();
            viewPager.addOnPageChangeListener(this.Wb);
            this.Wa = new g(viewPager);
            a(this.Wa);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, z);
            }
            if (this.Wc == null) {
                this.Wc = new a();
            }
            this.Wc.setAutoRefresh(z);
            viewPager.addOnAdapterChangeListener(this.Wc);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.mViewPager = null;
            setPagerAdapter(null, false);
        }
        this.mSetupViewPagerImplicitly = z2;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        setPagerAdapter(pagerAdapter, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                setupWithViewPager((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mSetupViewPagerImplicitly) {
            setupWithViewPager(null);
            this.mSetupViewPagerImplicitly = false;
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.VW.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    void setPagerAdapter(@Nullable PagerAdapter pagerAdapter, boolean z) {
        if (this.mPagerAdapter != null && this.mPagerAdapterObserver != null) {
            this.mPagerAdapter.unregisterDataSetObserver(this.mPagerAdapterObserver);
        }
        this.mPagerAdapter = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.mPagerAdapterObserver == null) {
                this.mPagerAdapterObserver = new c();
            }
            pagerAdapter.registerDataSetObserver(this.mPagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    void populateFromPagerAdapter() {
        int currentItem;
        removeAllTabs();
        if (this.mPagerAdapter != null) {
            int count = this.mPagerAdapter.getCount();
            for (int i = 0; i < count; i++) {
                a(pn().b(this.mPagerAdapter.getPageTitle(i)), false);
            }
            if (this.mViewPager != null && count > 0 && (currentItem = this.mViewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                d(aF(currentItem));
            }
        }
    }

    private void updateAllTabs() {
        int size = this.mTabs.size();
        for (int i = 0; i < size; i++) {
            this.mTabs.get(i).updateView();
        }
    }

    private f b(@NonNull e eVar) {
        f acquire = this.mTabViewPool != null ? this.mTabViewPool.acquire() : null;
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
        this.VW.addView(eVar.Wm, eVar.getPosition(), createLayoutParamsForTabs());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        addViewInternal(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i) {
        addViewInternal(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    private void addViewInternal(View view) {
        if (view instanceof TbTabItem) {
            a((TbTabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only FcTabItem instances can be added to TbTabLayout");
    }

    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(layoutParams);
        return layoutParams;
    }

    private void updateTabViewLayoutParams(LinearLayout.LayoutParams layoutParams) {
        if (this.mMode == 1 && this.mTabGravity == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    int dpToPx(int i) {
        return Math.round(getResources().getDisplayMetrics().density * i);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z;
        int dpToPx = dpToPx(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
        switch (View.MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                i2 = View.MeasureSpec.makeMeasureSpec(Math.min(dpToPx, View.MeasureSpec.getSize(i2)), 1073741824);
                break;
            case 0:
                i2 = View.MeasureSpec.makeMeasureSpec(dpToPx, 1073741824);
                break;
        }
        int size = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i) != 0) {
            this.mTabMaxWidth = this.mRequestedTabMaxWidth > 0 ? this.mRequestedTabMaxWidth : size - dpToPx(56);
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

    private void removeTabViewAt(int i) {
        f fVar = (f) this.VW.getChildAt(i);
        this.VW.removeViewAt(i);
        if (fVar != null) {
            fVar.reset();
            this.mTabViewPool.release(fVar);
        }
        requestLayout();
    }

    private void animateToTab(int i) {
        if (i != -1) {
            if (getWindowToken() == null || !ViewCompat.isLaidOut(this) || this.VW.childrenNeedLayout()) {
                setScrollPosition(i, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int calculateScrollXForTab = calculateScrollXForTab(i, 0.0f);
            if (scrollX != calculateScrollXForTab) {
                ensureScrollAnimator();
                this.mScrollAnimator.setIntValues(scrollX, calculateScrollXForTab);
                this.mScrollAnimator.start();
            }
            this.VW.animateIndicatorToPosition(i, 300);
        }
    }

    private void ensureScrollAnimator() {
        if (this.mScrollAnimator == null) {
            this.mScrollAnimator = new ValueAnimator();
            this.mScrollAnimator.setInterpolator(FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.mScrollAnimator.setDuration(300L);
            this.mScrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.adp.widget.design.TbTabLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TbTabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        ensureScrollAnimator();
        this.mScrollAnimator.addListener(animatorListener);
    }

    private void setSelectedTabView(int i) {
        int childCount = this.VW.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                this.VW.getChildAt(i2).setSelected(i2 == i);
                i2++;
            }
        }
    }

    void d(e eVar) {
        b(eVar, true);
    }

    void b(e eVar, boolean z) {
        e eVar2 = this.VV;
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
        this.VV = eVar;
        if (eVar != null) {
            e(eVar);
        }
    }

    private void e(@NonNull e eVar) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            this.mSelectedListeners.get(size).h(eVar);
        }
    }

    private void f(@NonNull e eVar) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            this.mSelectedListeners.get(size).i(eVar);
        }
    }

    private void g(@NonNull e eVar) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            this.mSelectedListeners.get(size).j(eVar);
        }
    }

    private int calculateScrollXForTab(int i, float f2) {
        if (this.mMode == 0) {
            View childAt = this.VW.getChildAt(i);
            View childAt2 = i + 1 < this.VW.getChildCount() ? this.VW.getChildAt(i + 1) : null;
            int width = childAt != null ? childAt.getWidth() : 0;
            int width2 = childAt2 != null ? childAt2.getWidth() : 0;
            int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
            int i2 = (int) ((width2 + width) * 0.5f * f2);
            return ViewCompat.getLayoutDirection(this) == 0 ? i2 + left : left - i2;
        }
        return 0;
    }

    private void applyModeAndGravity() {
        ViewCompat.setPaddingRelative(this.VW, this.mMode == 0 ? Math.max(0, this.mContentInsetStart - this.mTabPaddingStart) : 0, 0, 0, 0);
        switch (this.mMode) {
            case 0:
                this.VW.setGravity(GravityCompat.START);
                break;
            case 1:
                this.VW.setGravity(1);
                break;
        }
        updateTabViews(true);
    }

    void updateTabViews(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.VW.getChildCount()) {
                View childAt = this.VW.getChildAt(i2);
                childAt.setMinimumWidth(getTabMinWidth());
                updateTabViewLayoutParams((LinearLayout.LayoutParams) childAt.getLayoutParams());
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
        TbTabLayout Wl;
        f Wm;
        private CharSequence mContentDesc;
        private View mCustomView;
        private Drawable mIcon;
        private int mId;
        private Object mTag;
        private CharSequence mText;
        private int mPosition = -1;
        private int Wj = 0;
        private boolean Wk = false;

        e() {
        }

        public int po() {
            return this.Wj;
        }

        public e j(int i, boolean z) {
            this.Wj = i;
            this.Wk = z;
            updateView();
            return this;
        }

        public boolean isShowRedDot() {
            return this.Wk;
        }

        public int getId() {
            return this.mId;
        }

        public e aH(int i) {
            this.mId = i;
            return this;
        }

        @Nullable
        public View getCustomView() {
            return this.mCustomView;
        }

        @NonNull
        public e E(@Nullable View view) {
            this.mCustomView = view;
            updateView();
            return this;
        }

        @NonNull
        public e aI(@LayoutRes int i) {
            return E(LayoutInflater.from(this.Wm.getContext()).inflate(i, (ViewGroup) this.Wm, false));
        }

        @Nullable
        public Drawable getIcon() {
            return this.mIcon;
        }

        public int getPosition() {
            return this.mPosition;
        }

        void setPosition(int i) {
            this.mPosition = i;
        }

        @Nullable
        public CharSequence getText() {
            return this.mText;
        }

        @NonNull
        public e b(@Nullable Drawable drawable) {
            this.mIcon = drawable;
            updateView();
            return this;
        }

        @NonNull
        public e b(@Nullable CharSequence charSequence) {
            this.mText = charSequence;
            updateView();
            return this;
        }

        public void select() {
            if (this.Wl == null) {
                throw new IllegalArgumentException("Tab not attached to a TbTabLayout");
            }
            this.Wl.d(this);
        }

        public boolean isSelected() {
            if (this.Wl == null) {
                throw new IllegalArgumentException("Tab not attached to a TbTabLayout");
            }
            return this.Wl.getSelectedTabPosition() == this.mPosition;
        }

        @NonNull
        public e c(@Nullable CharSequence charSequence) {
            this.mContentDesc = charSequence;
            updateView();
            return this;
        }

        @Nullable
        public CharSequence getContentDescription() {
            return this.mContentDesc;
        }

        void updateView() {
            if (this.Wm != null) {
                this.Wm.update();
            }
        }

        void reset() {
            this.Wl = null;
            this.Wm = null;
            this.mTag = null;
            this.mIcon = null;
            this.mText = null;
            this.mContentDesc = null;
            this.mPosition = -1;
            this.mCustomView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends LinearLayout {
        private e Wn;
        private Drawable Wo;
        private String Wp;
        private ImageView mCustomIconView;
        private TextView mCustomTextView;
        private View mCustomView;
        private int mDefaultMaxLines;
        private ImageView mIconView;
        private TextView mTextView;

        public f(Context context) {
            super(context);
            this.mDefaultMaxLines = 2;
            if (TbTabLayout.this.mTabBackgroundResId != 0) {
                ViewCompat.setBackground(this, AppCompatResources.getDrawable(context, TbTabLayout.this.mTabBackgroundResId));
            }
            ViewCompat.setPaddingRelative(this, TbTabLayout.this.mTabPaddingStart, TbTabLayout.this.mTabPaddingTop, TbTabLayout.this.mTabPaddingEnd, TbTabLayout.this.mTabPaddingBottom);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (TbTabLayout.this.We) {
                return false;
            }
            if (this.Wn != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.Wn.select();
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
            if (this.mTextView != null) {
                this.mTextView.setSelected(z);
            }
            if (this.mIconView != null) {
                this.mIconView.setSelected(z);
            }
            if (this.mCustomView != null) {
                this.mCustomView.setSelected(z);
            }
            ay(z);
        }

        private void ay(boolean z) {
            if (this.mTextView != null) {
                if (z && TbTabLayout.this.VX > 0.0f) {
                    this.mTextView.setTextSize(0, TbTabLayout.this.VX);
                } else {
                    this.mTextView.setTextSize(0, TbTabLayout.this.mTabTextSize);
                }
                if (z && TbTabLayout.this.VY) {
                    this.mTextView.setTypeface(Typeface.defaultFromStyle(1));
                } else {
                    this.mTextView.setTypeface(Typeface.defaultFromStyle(0));
                }
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
                i = View.MeasureSpec.makeMeasureSpec(TbTabLayout.this.mTabMaxWidth, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.mTextView != null) {
                getResources();
                float f = TbTabLayout.this.mTabTextSize;
                int i3 = this.mDefaultMaxLines;
                if (this.mIconView != null && this.mIconView.getVisibility() == 0) {
                    i3 = 1;
                } else if (this.mTextView != null && this.mTextView.getLineCount() > 1) {
                    f = TbTabLayout.this.mTabTextMultiLineSize;
                }
                float textSize = this.mTextView.getTextSize();
                int lineCount = this.mTextView.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.mTextView);
                if (f != textSize || (maxLines >= 0 && i3 != maxLines)) {
                    if (TbTabLayout.this.mMode == 1 && f > textSize && lineCount == 1 && ((layout = this.mTextView.getLayout()) == null || approximateLineWidth(layout, 0, f) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.mTextView.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        void k(@Nullable e eVar) {
            if (eVar != this.Wn) {
                this.Wn = eVar;
                update();
            }
        }

        void reset() {
            k(null);
            setSelected(false);
        }

        final void update() {
            e eVar = this.Wn;
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
                if (this.mTextView != null) {
                    this.mTextView.setVisibility(8);
                }
                if (this.mIconView != null) {
                    this.mIconView.setVisibility(8);
                    this.mIconView.setImageDrawable(null);
                }
                this.mCustomTextView = (TextView) customView.findViewById(16908308);
                if (this.mCustomTextView != null) {
                    this.mDefaultMaxLines = TextViewCompat.getMaxLines(this.mCustomTextView);
                }
                this.mCustomIconView = (ImageView) customView.findViewById(16908294);
            } else {
                if (this.mCustomView != null) {
                    removeView(this.mCustomView);
                    this.mCustomView = null;
                }
                this.mCustomTextView = null;
                this.mCustomIconView = null;
            }
            if (this.mCustomView == null) {
                if (this.mIconView == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(android.support.design.R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                    addView(imageView, 0);
                    this.mIconView = imageView;
                }
                if (this.mTextView == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(android.support.design.R.layout.design_layout_tab_text, (ViewGroup) this, false);
                    addView(textView);
                    this.mTextView = textView;
                    this.mDefaultMaxLines = TextViewCompat.getMaxLines(this.mTextView);
                }
                TextViewCompat.setTextAppearance(this.mTextView, TbTabLayout.this.mTabTextAppearance);
                if (TbTabLayout.this.mTabTextColors != null) {
                    this.mTextView.setTextColor(TbTabLayout.this.mTabTextColors);
                }
                updateTextAndIcon(this.mTextView, this.mIconView);
            } else if (this.mCustomTextView != null || this.mCustomIconView != null) {
                updateTextAndIcon(this.mCustomTextView, this.mCustomIconView);
            }
            setSelected(eVar != null && eVar.isSelected());
        }

        private void updateTextAndIcon(@Nullable TextView textView, @Nullable ImageView imageView) {
            int i = 0;
            Drawable icon = this.Wn != null ? this.Wn.getIcon() : null;
            CharSequence text = this.Wn != null ? this.Wn.getText() : null;
            CharSequence contentDescription = this.Wn != null ? this.Wn.getContentDescription() : null;
            int po = this.Wn != null ? this.Wn.po() : 0;
            boolean isShowRedDot = this.Wn != null ? this.Wn.isShowRedDot() : false;
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
                    if (po <= 0) {
                        this.Wo = am.getDrawable(com.baidu.tieba.R.drawable.icon_news_red_dot);
                        this.Wp = null;
                    } else if (po < 10) {
                        this.Wo = am.getDrawable(com.baidu.tieba.R.drawable.icon_news_red_dot_one_number);
                        this.Wp = String.valueOf(po);
                    } else if (po < 100) {
                        this.Wo = am.getDrawable(com.baidu.tieba.R.drawable.icon_news_red_dot_two_number);
                        this.Wp = String.valueOf(po);
                    } else {
                        this.Wo = am.getDrawable(com.baidu.tieba.R.drawable.icon_news_red_dot_two_number);
                        this.Wp = StringHelper.STRING_MORE;
                    }
                    if (this.Wo == null) {
                        this.Wo = am.getDrawable(com.baidu.tieba.R.drawable.icon_news_red_dot);
                    }
                } else {
                    this.Wo = null;
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (z && imageView.getVisibility() == 0) {
                    i = TbTabLayout.this.dpToPx(8);
                }
                if (i != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i;
                    imageView.requestLayout();
                }
            }
        }

        private float approximateLineWidth(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends LinearLayout {
        private int Wh;
        private ValueAnimator mIndicatorAnimator;
        private int mIndicatorLeft;
        private int mIndicatorRight;
        private int mLayoutDirection;
        private int mSelectedIndicatorHeight;
        private final Paint mSelectedIndicatorPaint;
        int mSelectedPosition;
        float mSelectionOffset;

        d(Context context) {
            super(context);
            this.mSelectedPosition = -1;
            this.mLayoutDirection = -1;
            this.mIndicatorLeft = -1;
            this.mIndicatorRight = -1;
            setWillNotDraw(false);
            this.mSelectedIndicatorPaint = new Paint();
            this.mSelectedIndicatorPaint.setStrokeCap(Paint.Cap.ROUND);
            this.mSelectedIndicatorPaint.setAntiAlias(true);
        }

        void setSelectedIndicatorColor(int i) {
            if (this.mSelectedIndicatorPaint.getColor() != i) {
                this.mSelectedIndicatorPaint.setColor(i);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void setSelectedIndicatorHeight(int i) {
            if (this.mSelectedIndicatorHeight != i) {
                this.mSelectedIndicatorHeight = i;
                this.mSelectedIndicatorPaint.setStrokeWidth(this.mSelectedIndicatorHeight);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void aG(int i) {
            if (this.Wh != i) {
                this.Wh = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        boolean childrenNeedLayout() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        void setIndicatorPositionFromTabPosition(int i, float f) {
            if (this.mIndicatorAnimator != null && this.mIndicatorAnimator.isRunning()) {
                this.mIndicatorAnimator.cancel();
            }
            this.mSelectedPosition = i;
            this.mSelectionOffset = f;
            updateIndicatorPosition();
        }

        float getIndicatorPosition() {
            return this.mSelectedPosition + this.mSelectionOffset;
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT < 23 && this.mLayoutDirection != i) {
                requestLayout();
                this.mLayoutDirection = i;
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            boolean z;
            boolean z2 = false;
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) == 1073741824 && TbTabLayout.this.mMode == 1 && TbTabLayout.this.mTabGravity == 1) {
                int childCount = getChildCount();
                int i3 = 0;
                int i4 = 0;
                while (i3 < childCount) {
                    View childAt = getChildAt(i3);
                    i3++;
                    i4 = childAt.getVisibility() == 0 ? Math.max(i4, childAt.getMeasuredWidth()) : i4;
                }
                if (i4 > 0) {
                    if (i4 * childCount <= getMeasuredWidth() - (TbTabLayout.this.dpToPx(16) * 2)) {
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
                        TbTabLayout.this.mTabGravity = 0;
                        TbTabLayout.this.updateTabViews(false);
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
            if (this.mIndicatorAnimator != null && this.mIndicatorAnimator.isRunning()) {
                this.mIndicatorAnimator.cancel();
                animateIndicatorToPosition(this.mSelectedPosition, Math.round(((float) this.mIndicatorAnimator.getDuration()) * (1.0f - this.mIndicatorAnimator.getAnimatedFraction())));
                return;
            }
            updateIndicatorPosition();
        }

        private void updateIndicatorPosition() {
            int i;
            int i2;
            View childAt = getChildAt(this.mSelectedPosition);
            if (childAt != null && childAt.getWidth() > 0) {
                i2 = childAt.getLeft();
                i = childAt.getRight();
                if (this.mSelectionOffset > 0.0f && this.mSelectedPosition < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.mSelectedPosition + 1);
                    i2 = (int) ((i2 * (1.0f - this.mSelectionOffset)) + (this.mSelectionOffset * childAt2.getLeft()));
                    i = (int) ((i * (1.0f - this.mSelectionOffset)) + (childAt2.getRight() * this.mSelectionOffset));
                }
            } else {
                i = -1;
                i2 = -1;
            }
            setIndicatorPosition(i2, i);
        }

        void setIndicatorPosition(int i, int i2) {
            if (i != this.mIndicatorLeft || i2 != this.mIndicatorRight) {
                this.mIndicatorLeft = i;
                this.mIndicatorRight = i2;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void animateIndicatorToPosition(final int i, int i2) {
            final int i3;
            final int i4;
            if (this.mIndicatorAnimator != null && this.mIndicatorAnimator.isRunning()) {
                this.mIndicatorAnimator.cancel();
            }
            boolean z = ViewCompat.getLayoutDirection(this) == 1;
            View childAt = getChildAt(i);
            if (childAt == null) {
                updateIndicatorPosition();
                return;
            }
            final int left = childAt.getLeft();
            final int right = childAt.getRight();
            if (Math.abs(i - this.mSelectedPosition) <= 1) {
                i4 = this.mIndicatorLeft;
                i3 = this.mIndicatorRight;
            } else {
                int dpToPx = TbTabLayout.this.dpToPx(24);
                if (i < this.mSelectedPosition) {
                    if (z) {
                        i3 = left - dpToPx;
                        i4 = i3;
                    } else {
                        i3 = right + dpToPx;
                        i4 = i3;
                    }
                } else if (z) {
                    i3 = right + dpToPx;
                    i4 = i3;
                } else {
                    i3 = left - dpToPx;
                    i4 = i3;
                }
            }
            if (i4 != left || i3 != right) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.mIndicatorAnimator = valueAnimator;
                valueAnimator.setInterpolator(TbTabLayout.FAST_OUT_SLOW_IN_INTERPOLATOR);
                valueAnimator.setDuration(i2);
                valueAnimator.setFloatValues(0.0f, 1.0f);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.adp.widget.design.TbTabLayout.d.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        float animatedFraction = valueAnimator2.getAnimatedFraction();
                        d.this.setIndicatorPosition(TbTabLayout.lerp(i4, left, animatedFraction), TbTabLayout.lerp(i3, right, animatedFraction));
                    }
                });
                valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.adp.widget.design.TbTabLayout.d.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        d.this.mSelectedPosition = i;
                        d.this.mSelectionOffset = 0.0f;
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
            if (this.mIndicatorLeft >= 0 && this.mIndicatorRight > this.mIndicatorLeft) {
                int i = (this.Wh <= 0 || this.mIndicatorRight - this.mIndicatorLeft <= this.Wh) ? 0 : ((this.mIndicatorRight - this.mIndicatorLeft) - this.Wh) / 2;
                canvas.drawLine(this.mIndicatorLeft + i, getHeight() - (this.mSelectedIndicatorHeight / 2), this.mIndicatorRight - i, getHeight() - (this.mSelectedIndicatorHeight / 2), this.mSelectedIndicatorPaint);
            }
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (getChildAt(childCount) instanceof f) {
                    f fVar = (f) getChildAt(childCount);
                    if (fVar.Wo != null) {
                        TextView textView = null;
                        if (fVar.mTextView != null) {
                            textView = fVar.mTextView;
                        } else if (fVar.mCustomTextView != null) {
                            textView = fVar.mCustomTextView;
                        }
                        if (textView != null) {
                            int right = (fVar.getRight() - (fVar.getWidth() - textView.getRight())) - l.getDimens(getContext(), com.baidu.tieba.R.dimen.tbds3);
                            int top2 = (textView.getTop() - (fVar.Wo.getIntrinsicHeight() / 2)) + l.getDimens(getContext(), com.baidu.tieba.R.dimen.tbds10);
                            fVar.Wo.setBounds(right, top2, fVar.Wo.getIntrinsicWidth() + right, fVar.Wo.getIntrinsicHeight() + top2);
                            fVar.Wo.draw(canvas);
                            if (!TextUtils.isEmpty(fVar.Wp)) {
                                if (fVar.Wp.equals(StringHelper.STRING_MORE)) {
                                    Drawable drawable = am.getDrawable(com.baidu.tieba.R.drawable.icon_news_white_dot);
                                    int intrinsicWidth = right + (fVar.Wo.getIntrinsicWidth() / 2);
                                    int intrinsicHeight2 = (fVar.Wo.getIntrinsicHeight() / 2) + top2;
                                    int dimens = l.getDimens(getContext(), com.baidu.tieba.R.dimen.tbds6);
                                    int dimens2 = l.getDimens(getContext(), com.baidu.tieba.R.dimen.tbds7);
                                    int i2 = intrinsicWidth - (dimens / 2);
                                    int i3 = intrinsicHeight2 - (dimens / 2);
                                    int i4 = intrinsicWidth + (dimens / 2);
                                    int i5 = intrinsicHeight2 + (dimens / 2);
                                    drawable.setBounds(i2, i3, i4, i5);
                                    drawable.draw(canvas);
                                    drawable.setBounds((i2 - dimens2) - dimens, i3, i2 - dimens2, i5);
                                    drawable.draw(canvas);
                                    drawable.setBounds(i4 + dimens2, i3, dimens + i4 + dimens2, i5);
                                    drawable.draw(canvas);
                                } else {
                                    Paint paint = new Paint(1);
                                    paint.setColor(am.getColor(com.baidu.tieba.R.color.cp_cont_a));
                                    paint.setTextSize(l.getDimens(getContext(), com.baidu.tieba.R.dimen.tbfontsize26));
                                    paint.setTextAlign(Paint.Align.CENTER);
                                    paint.setTypeface(Typeface.MONOSPACE);
                                    paint.getTextBounds(fVar.Wp, 0, fVar.Wp.length(), new Rect());
                                    canvas.drawText(fVar.Wp, right + (fVar.Wo.getIntrinsicWidth() / 2), (intrinsicHeight - ((fVar.Wo.getIntrinsicHeight() - rect.height()) / 2)) - TbTabLayout.this.Wf, paint);
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
        if (this.mRequestedTabMinWidth != -1) {
            return this.mRequestedTabMinWidth;
        }
        if (this.mMode == 0) {
            return this.mScrollableTabMinWidth;
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    int getTabMaxWidth() {
        return this.mTabMaxWidth;
    }

    /* loaded from: classes.dex */
    public static class TbTabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private final WeakReference<TbTabLayout> Wq;
        private int mPreviousScrollState;
        private int mScrollState;

        public TbTabLayoutOnPageChangeListener(TbTabLayout tbTabLayout) {
            this.Wq = new WeakReference<>(tbTabLayout);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mPreviousScrollState = this.mScrollState;
            this.mScrollState = i;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            boolean z = false;
            TbTabLayout tbTabLayout = this.Wq.get();
            if (tbTabLayout != null) {
                boolean z2 = this.mScrollState != 2 || this.mPreviousScrollState == 1;
                if (this.mScrollState != 2 || this.mPreviousScrollState != 0) {
                    z = true;
                }
                tbTabLayout.setScrollPosition(i, f, z2, z);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            TbTabLayout tbTabLayout = this.Wq.get();
            if (tbTabLayout != null && tbTabLayout.getSelectedTabPosition() != i && i < tbTabLayout.getTabCount()) {
                tbTabLayout.b(tbTabLayout.aF(i), this.mScrollState == 0 || (this.mScrollState == 2 && this.mPreviousScrollState == 0));
            }
        }

        void reset() {
            this.mScrollState = 0;
            this.mPreviousScrollState = 0;
        }
    }

    /* loaded from: classes.dex */
    public static class g implements b {
        private final ViewPager mViewPager;

        public g(ViewPager viewPager) {
            this.mViewPager = viewPager;
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(e eVar) {
            this.mViewPager.setCurrentItem(eVar.getPosition());
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
            TbTabLayout.this.populateFromPagerAdapter();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TbTabLayout.this.populateFromPagerAdapter();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements ViewPager.OnAdapterChangeListener {
        private boolean mAutoRefresh;

        a() {
        }

        @Override // android.support.v4.view.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            if (TbTabLayout.this.mViewPager == viewPager) {
                TbTabLayout.this.setPagerAdapter(pagerAdapter2, this.mAutoRefresh);
            }
        }

        void setAutoRefresh(boolean z) {
            this.mAutoRefresh = z;
        }
    }

    public static void checkAppCompatTheme(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(APPCOMPAT_CHECK_ATTRS);
        boolean z = obtainStyledAttributes.hasValue(0) ? false : true;
        obtainStyledAttributes.recycle();
        if (z) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }

    public static int lerp(int i, int i2, float f2) {
        return Math.round((i2 - i) * f2) + i;
    }
}
