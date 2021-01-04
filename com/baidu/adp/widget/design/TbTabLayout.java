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
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.l;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ao;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbTabLayout extends HorizontalScrollView {
    private static final int[] APPCOMPAT_CHECK_ATTRS = {R.attr.colorPrimary};
    public static final Interpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
    private static final Pools.Pool<e> YL = new Pools.SynchronizedPool(16);
    private e YM;
    private final d YN;
    int YO;
    int YP;
    int YQ;
    int YR;
    int YS;
    ColorStateList YT;
    float YU;
    float YV;
    float YW;
    boolean YX;
    final int YY;
    int YZ;
    private final int Za;
    private final int Zb;
    private final int Zc;
    private int Ze;
    int Zf;
    private b Zg;
    private final ArrayList<b> Zh;
    private b Zi;
    private ValueAnimator Zj;
    ViewPager Zk;
    private PagerAdapter Zl;
    private DataSetObserver Zm;
    private TbTabLayoutOnPageChangeListener Zn;
    private a Zo;
    private boolean Zp;
    private boolean Zq;
    private final Pools.Pool<f> Zr;
    private int Zs;
    int mMode;
    private final ArrayList<e> mTabs;

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
        this.YZ = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.Zh = new ArrayList<>();
        this.Zq = false;
        this.Zr = new Pools.SimplePool(12);
        checkAppCompatTheme(context);
        setHorizontalScrollBarEnabled(false);
        this.YN = new d(context);
        super.addView(this.YN, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.TabLayout, i, com.google.android.material.R.style.Widget_Design_TabLayout);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.R.styleable.TbTabLayout);
        this.YN.setSelectedIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabIndicatorHeight, 0));
        this.YN.ba(obtainStyledAttributes2.getDimensionPixelSize(com.baidu.tieba.R.styleable.TbTabLayout_tabIndicatorWidth, 0));
        this.YN.setSelectedIndicatorColor(obtainStyledAttributes.getColor(com.google.android.material.R.styleable.TabLayout_tabIndicatorColor, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPadding, 0);
        this.YR = dimensionPixelSize;
        this.YQ = dimensionPixelSize;
        this.YP = dimensionPixelSize;
        this.YO = dimensionPixelSize;
        this.YO = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPaddingStart, this.YO);
        this.YP = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPaddingTop, this.YP);
        this.YQ = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPaddingEnd, this.YQ);
        this.YR = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPaddingBottom, this.YR);
        this.YS = obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.TabLayout_tabTextAppearance, com.google.android.material.R.style.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(this.YS, R.styleable.TextAppearance);
        try {
            this.YU = obtainStyledAttributes3.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
            this.YT = obtainStyledAttributes3.getColorStateList(R.styleable.TextAppearance_android_textColor);
            obtainStyledAttributes3.recycle();
            if (obtainStyledAttributes.hasValue(com.google.android.material.R.styleable.TabLayout_tabTextColor)) {
                this.YT = obtainStyledAttributes.getColorStateList(com.google.android.material.R.styleable.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(com.google.android.material.R.styleable.TabLayout_tabSelectedTextColor)) {
                this.YT = createColorStateList(this.YT.getDefaultColor(), obtainStyledAttributes.getColor(com.google.android.material.R.styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.Za = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabMinWidth, -1);
            this.Zb = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabMaxWidth, -1);
            this.YY = obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.TabLayout_tabBackground, 0);
            this.Ze = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabContentStart, 0);
            this.mMode = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.TabLayout_tabMode, 1);
            this.Zf = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.TabLayout_tabGravity, 0);
            obtainStyledAttributes.recycle();
            obtainStyledAttributes2.recycle();
            Resources resources = getResources();
            this.YV = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_tab_text_size_2line);
            this.Zc = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_tab_scrollable_min_width);
            applyModeAndGravity();
            qM();
        } catch (Throwable th) {
            obtainStyledAttributes3.recycle();
            throw th;
        }
    }

    public void setDisableTabSelect(boolean z) {
        this.Zq = z;
    }

    private void qM() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            this.Zs = l.getDimens(getContext(), com.baidu.tieba.R.dimen.tbds2);
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i) {
        this.YN.setSelectedIndicatorColor(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.YN.setSelectedIndicatorHeight(i);
    }

    public void setSelectedIndicatorBottomMargin(int i) {
        this.YN.setSelectedIndicatorBottomMargin(i);
    }

    public void setSelectedTabIndicatorWidth(int i) {
        this.YN.ba(i);
    }

    public void setScrollPosition(int i, float f2, boolean z) {
        setScrollPosition(i, f2, z, true);
    }

    void setScrollPosition(int i, float f2, boolean z, boolean z2) {
        int round = Math.round(i + f2);
        if (round >= 0 && round < this.YN.getChildCount()) {
            if (z2) {
                this.YN.setIndicatorPositionFromTabPosition(i, f2);
            }
            if (this.Zj != null && this.Zj.isRunning()) {
                this.Zj.cancel();
            }
            scrollTo(calculateScrollXForTab(i, f2), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    private float getScrollPosition() {
        return this.YN.getIndicatorPosition();
    }

    public void a(@NonNull e eVar) {
        a(eVar, this.mTabs.isEmpty());
    }

    public void a(@NonNull e eVar, boolean z) {
        a(eVar, this.mTabs.size(), z);
    }

    public void a(@NonNull e eVar, int i, boolean z) {
        if (eVar.ZI != this) {
            throw new IllegalArgumentException("Tab belongs to a different TbTabLayout.");
        }
        a(eVar, i);
        c(eVar);
        if (z) {
            eVar.select();
        }
    }

    private void a(@NonNull TbTabItem tbTabItem) {
        e qN = qN();
        if (tbTabItem.mText != null) {
            qN.b(tbTabItem.mText);
        }
        if (tbTabItem.mIcon != null) {
            qN.g(tbTabItem.mIcon);
        }
        if (tbTabItem.YK != 0) {
            qN.bc(tbTabItem.YK);
        }
        if (!TextUtils.isEmpty(tbTabItem.getContentDescription())) {
            qN.c(tbTabItem.getContentDescription());
        }
        a(qN);
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable b bVar) {
        if (this.Zg != null) {
            b(this.Zg);
        }
        this.Zg = bVar;
        if (bVar != null) {
            a(bVar);
        }
    }

    public void a(@NonNull b bVar) {
        if (!this.Zh.contains(bVar)) {
            this.Zh.add(bVar);
        }
    }

    public void b(@NonNull b bVar) {
        this.Zh.remove(bVar);
    }

    @NonNull
    public e qN() {
        e acquire = YL.acquire();
        if (acquire == null) {
            acquire = new e();
        }
        acquire.ZI = this;
        acquire.ZJ = b(acquire);
        return acquire;
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    @Nullable
    public e aZ(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return this.mTabs.get(i);
    }

    public int getSelectedTabPosition() {
        if (this.YM != null) {
            return this.YM.getPosition();
        }
        return -1;
    }

    public void removeAllTabs() {
        for (int childCount = this.YN.getChildCount() - 1; childCount >= 0; childCount--) {
            removeTabViewAt(childCount);
        }
        Iterator<e> it = this.mTabs.iterator();
        while (it.hasNext()) {
            e next = it.next();
            it.remove();
            next.reset();
            YL.release(next);
        }
        this.YM = null;
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
        if (this.Zf != i) {
            this.Zf = i;
            applyModeAndGravity();
        }
    }

    public int getTabGravity() {
        return this.Zf;
    }

    public void setTabTextSize(int i) {
        this.YU = i;
    }

    public void setSelectedTabTextSize(int i) {
        this.YW = i;
    }

    public void setSelectedTabTextBlod(boolean z) {
        this.YX = z;
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.YT != colorStateList) {
            this.YT = colorStateList;
            updateAllTabs();
        }
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.YT;
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
        if (this.Zk != null) {
            if (this.Zn != null) {
                this.Zk.removeOnPageChangeListener(this.Zn);
            }
            if (this.Zo != null) {
                this.Zk.removeOnAdapterChangeListener(this.Zo);
            }
        }
        if (this.Zi != null) {
            b(this.Zi);
            this.Zi = null;
        }
        if (viewPager != null) {
            this.Zk = viewPager;
            if (this.Zn == null) {
                this.Zn = new TbTabLayoutOnPageChangeListener(this);
            }
            this.Zn.reset();
            viewPager.addOnPageChangeListener(this.Zn);
            this.Zi = new g(viewPager);
            a(this.Zi);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, z);
            }
            if (this.Zo == null) {
                this.Zo = new a();
            }
            this.Zo.setAutoRefresh(z);
            viewPager.addOnAdapterChangeListener(this.Zo);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.Zk = null;
            setPagerAdapter(null, false);
        }
        this.Zp = z2;
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
        if (this.Zk == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                setupWithViewPager((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Zp) {
            setupWithViewPager(null);
            this.Zp = false;
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.YN.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    void setPagerAdapter(@Nullable PagerAdapter pagerAdapter, boolean z) {
        if (this.Zl != null && this.Zm != null) {
            this.Zl.unregisterDataSetObserver(this.Zm);
        }
        this.Zl = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.Zm == null) {
                this.Zm = new c();
            }
            pagerAdapter.registerDataSetObserver(this.Zm);
        }
        populateFromPagerAdapter();
    }

    void populateFromPagerAdapter() {
        int currentItem;
        removeAllTabs();
        if (this.Zl != null) {
            int count = this.Zl.getCount();
            for (int i = 0; i < count; i++) {
                a(qN().b(this.Zl.getPageTitle(i)), false);
            }
            if (this.Zk != null && count > 0 && (currentItem = this.Zk.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                d(aZ(currentItem));
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
        f acquire = this.Zr != null ? this.Zr.acquire() : null;
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
        this.YN.addView(eVar.ZJ, eVar.getPosition(), createLayoutParamsForTabs());
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
        if (this.mMode == 1 && this.Zf == 0) {
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
            this.YZ = this.Zb > 0 ? this.Zb : size - dpToPx(56);
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
        f fVar = (f) this.YN.getChildAt(i);
        this.YN.removeViewAt(i);
        if (fVar != null) {
            fVar.reset();
            this.Zr.release(fVar);
        }
        requestLayout();
    }

    private void animateToTab(int i) {
        if (i != -1) {
            if (getWindowToken() == null || !ViewCompat.isLaidOut(this) || this.YN.childrenNeedLayout()) {
                setScrollPosition(i, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int calculateScrollXForTab = calculateScrollXForTab(i, 0.0f);
            if (scrollX != calculateScrollXForTab) {
                ensureScrollAnimator();
                this.Zj.setIntValues(scrollX, calculateScrollXForTab);
                this.Zj.start();
            }
            this.YN.animateIndicatorToPosition(i, 300);
        }
    }

    private void ensureScrollAnimator() {
        if (this.Zj == null) {
            this.Zj = new ValueAnimator();
            this.Zj.setInterpolator(FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.Zj.setDuration(300L);
            this.Zj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.adp.widget.design.TbTabLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TbTabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        ensureScrollAnimator();
        this.Zj.addListener(animatorListener);
    }

    private void setSelectedTabView(int i) {
        int childCount = this.YN.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                this.YN.getChildAt(i2).setSelected(i2 == i);
                i2++;
            }
        }
    }

    void d(e eVar) {
        b(eVar, true);
    }

    void b(e eVar, boolean z) {
        e eVar2 = this.YM;
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
        this.YM = eVar;
        if (eVar != null) {
            e(eVar);
        }
    }

    private void e(@NonNull e eVar) {
        for (int size = this.Zh.size() - 1; size >= 0; size--) {
            this.Zh.get(size).h(eVar);
        }
    }

    private void f(@NonNull e eVar) {
        for (int size = this.Zh.size() - 1; size >= 0; size--) {
            this.Zh.get(size).i(eVar);
        }
    }

    private void g(@NonNull e eVar) {
        for (int size = this.Zh.size() - 1; size >= 0; size--) {
            this.Zh.get(size).j(eVar);
        }
    }

    private int calculateScrollXForTab(int i, float f2) {
        if (this.mMode == 0) {
            View childAt = this.YN.getChildAt(i);
            View childAt2 = i + 1 < this.YN.getChildCount() ? this.YN.getChildAt(i + 1) : null;
            int width = childAt != null ? childAt.getWidth() : 0;
            int width2 = childAt2 != null ? childAt2.getWidth() : 0;
            int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
            int i2 = (int) ((width2 + width) * 0.5f * f2);
            return ViewCompat.getLayoutDirection(this) == 0 ? i2 + left : left - i2;
        }
        return 0;
    }

    private void applyModeAndGravity() {
        ViewCompat.setPaddingRelative(this.YN, this.mMode == 0 ? Math.max(0, this.Ze - this.YO) : 0, 0, 0, 0);
        switch (this.mMode) {
            case 0:
                this.YN.setGravity(GravityCompat.START);
                break;
            case 1:
                this.YN.setGravity(1);
                break;
        }
        updateTabViews(true);
    }

    void updateTabViews(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.YN.getChildCount()) {
                View childAt = this.YN.getChildAt(i2);
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
        TbTabLayout ZI;
        f ZJ;
        private CharSequence mContentDesc;
        private View mCustomView;
        private Drawable mIcon;
        private int mId;
        private Object mTag;
        private CharSequence mText;
        private int mPosition = -1;
        private int ZG = 0;
        private boolean ZH = false;

        e() {
        }

        public int qO() {
            return this.ZG;
        }

        public e l(int i, boolean z) {
            this.ZG = i;
            this.ZH = z;
            updateView();
            return this;
        }

        public boolean isShowRedDot() {
            return this.ZH;
        }

        public int getId() {
            return this.mId;
        }

        public e bb(int i) {
            this.mId = i;
            return this;
        }

        @Nullable
        public View getCustomView() {
            return this.mCustomView;
        }

        @NonNull
        public e G(@Nullable View view) {
            this.mCustomView = view;
            updateView();
            return this;
        }

        @NonNull
        public e bc(@LayoutRes int i) {
            return G(LayoutInflater.from(this.ZJ.getContext()).inflate(i, (ViewGroup) this.ZJ, false));
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
        public e g(@Nullable Drawable drawable) {
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
            if (this.ZI == null) {
                throw new IllegalArgumentException("Tab not attached to a TbTabLayout");
            }
            this.ZI.d(this);
        }

        public boolean isSelected() {
            if (this.ZI == null) {
                throw new IllegalArgumentException("Tab not attached to a TbTabLayout");
            }
            return this.ZI.getSelectedTabPosition() == this.mPosition;
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
            if (this.ZJ != null) {
                this.ZJ.update();
            }
        }

        void reset() {
            this.ZI = null;
            this.ZJ = null;
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
        private e ZK;
        private TextView ZL;
        private ImageView ZM;
        private Drawable ZN;
        private String ZO;
        private int ZP;
        private View mCustomView;
        private ImageView mIconView;
        private TextView mTextView;

        public f(Context context) {
            super(context);
            this.ZP = 2;
            if (TbTabLayout.this.YY != 0) {
                ViewCompat.setBackground(this, AppCompatResources.getDrawable(context, TbTabLayout.this.YY));
            }
            ViewCompat.setPaddingRelative(this, TbTabLayout.this.YO, TbTabLayout.this.YP, TbTabLayout.this.YQ, TbTabLayout.this.YR);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (TbTabLayout.this.Zq) {
                return false;
            }
            if (this.ZK != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.ZK.select();
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
                if (z && TbTabLayout.this.YW > 0.0f) {
                    this.mTextView.setTextSize(0, TbTabLayout.this.YW);
                } else {
                    this.mTextView.setTextSize(0, TbTabLayout.this.YU);
                }
                if (z && TbTabLayout.this.YX) {
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
                i = View.MeasureSpec.makeMeasureSpec(TbTabLayout.this.YZ, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.mTextView != null) {
                getResources();
                float f = TbTabLayout.this.YU;
                int i3 = this.ZP;
                if (this.mIconView != null && this.mIconView.getVisibility() == 0) {
                    i3 = 1;
                } else if (this.mTextView != null && this.mTextView.getLineCount() > 1) {
                    f = TbTabLayout.this.YV;
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
            if (eVar != this.ZK) {
                this.ZK = eVar;
                update();
            }
        }

        void reset() {
            k(null);
            setSelected(false);
        }

        final void update() {
            e eVar = this.ZK;
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
                this.ZL = (TextView) customView.findViewById(16908308);
                if (this.ZL != null) {
                    this.ZP = TextViewCompat.getMaxLines(this.ZL);
                }
                this.ZM = (ImageView) customView.findViewById(16908294);
            } else {
                if (this.mCustomView != null) {
                    removeView(this.mCustomView);
                    this.mCustomView = null;
                }
                this.ZL = null;
                this.ZM = null;
            }
            if (this.mCustomView == null) {
                if (this.mIconView == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(com.google.android.material.R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                    addView(imageView, 0);
                    this.mIconView = imageView;
                }
                if (this.mTextView == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(com.google.android.material.R.layout.design_layout_tab_text, (ViewGroup) this, false);
                    addView(textView);
                    this.mTextView = textView;
                    this.ZP = TextViewCompat.getMaxLines(this.mTextView);
                }
                TextViewCompat.setTextAppearance(this.mTextView, TbTabLayout.this.YS);
                if (TbTabLayout.this.YT != null) {
                    this.mTextView.setTextColor(TbTabLayout.this.YT);
                }
                updateTextAndIcon(this.mTextView, this.mIconView);
            } else if (this.ZL != null || this.ZM != null) {
                updateTextAndIcon(this.ZL, this.ZM);
            }
            setSelected(eVar != null && eVar.isSelected());
        }

        private void updateTextAndIcon(@Nullable TextView textView, @Nullable ImageView imageView) {
            int i = 0;
            Drawable icon = this.ZK != null ? this.ZK.getIcon() : null;
            CharSequence text = this.ZK != null ? this.ZK.getText() : null;
            CharSequence contentDescription = this.ZK != null ? this.ZK.getContentDescription() : null;
            int qO = this.ZK != null ? this.ZK.qO() : 0;
            boolean isShowRedDot = this.ZK != null ? this.ZK.isShowRedDot() : false;
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
                    if (qO <= 0) {
                        this.ZN = ao.getDrawable(com.baidu.tieba.R.drawable.icon_news_red_dot);
                        this.ZO = null;
                    } else if (qO < 10) {
                        this.ZN = ao.getDrawable(com.baidu.tieba.R.drawable.icon_news_red_dot_one_number);
                        this.ZO = String.valueOf(qO);
                    } else if (qO < 100) {
                        this.ZN = ao.getDrawable(com.baidu.tieba.R.drawable.icon_news_red_dot_two_number);
                        this.ZO = String.valueOf(qO);
                    } else {
                        this.ZN = ao.getDrawable(com.baidu.tieba.R.drawable.icon_news_red_dot_two_number);
                        this.ZO = StringHelper.STRING_MORE;
                    }
                    if (this.ZN == null) {
                        this.ZN = ao.getDrawable(com.baidu.tieba.R.drawable.icon_news_red_dot);
                    }
                } else {
                    this.ZN = null;
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
        private int ZA;
        private int ZB;
        private ValueAnimator ZC;
        private int Zv;
        private int Zw;
        private int Zx;
        private final Paint Zy;
        float Zz;
        private int mLayoutDirection;
        int mSelectedPosition;

        d(Context context) {
            super(context);
            this.mSelectedPosition = -1;
            this.mLayoutDirection = -1;
            this.ZA = -1;
            this.ZB = -1;
            setWillNotDraw(false);
            this.Zy = new Paint();
            this.Zy.setStrokeCap(Paint.Cap.ROUND);
            this.Zy.setAntiAlias(true);
        }

        void setSelectedIndicatorColor(int i) {
            if (this.Zy.getColor() != i) {
                this.Zy.setColor(i);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void setSelectedIndicatorHeight(int i) {
            if (this.Zv != i) {
                this.Zv = i;
                this.Zy.setStrokeWidth(this.Zv);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void setSelectedIndicatorBottomMargin(int i) {
            if (this.Zw != i) {
                this.Zw = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void ba(int i) {
            if (this.Zx != i) {
                this.Zx = i;
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
            if (this.ZC != null && this.ZC.isRunning()) {
                this.ZC.cancel();
            }
            this.mSelectedPosition = i;
            this.Zz = f;
            updateIndicatorPosition();
        }

        float getIndicatorPosition() {
            return this.mSelectedPosition + this.Zz;
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
            boolean z2;
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) == 1073741824 && TbTabLayout.this.mMode == 1 && TbTabLayout.this.Zf == 1) {
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
                        z = false;
                        while (i5 < childCount) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                            if (layoutParams.width == i4 && layoutParams.weight == 0.0f) {
                                z2 = z;
                            } else {
                                layoutParams.width = i4;
                                layoutParams.weight = 0.0f;
                                z2 = true;
                            }
                            i5++;
                            z = z2;
                        }
                    } else {
                        TbTabLayout.this.Zf = 0;
                        TbTabLayout.this.updateTabViews(false);
                        z = true;
                    }
                    if (z) {
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.ZC != null && this.ZC.isRunning()) {
                this.ZC.cancel();
                animateIndicatorToPosition(this.mSelectedPosition, Math.round(((float) this.ZC.getDuration()) * (1.0f - this.ZC.getAnimatedFraction())));
                return;
            }
            updateIndicatorPosition();
        }

        private void updateIndicatorPosition() {
            int i;
            int i2;
            View childAt = getChildAt(this.mSelectedPosition);
            if (childAt != null && childAt.getWidth() > 0) {
                int left = childAt.getLeft();
                i = childAt.getRight();
                if (this.Zz <= 0.0f || this.mSelectedPosition >= getChildCount() - 1) {
                    i2 = left;
                } else {
                    View childAt2 = getChildAt(this.mSelectedPosition + 1);
                    i = (int) ((i * (1.0f - this.Zz)) + (childAt2.getRight() * this.Zz));
                    i2 = (int) ((left * (1.0f - this.Zz)) + (this.Zz * childAt2.getLeft()));
                }
            } else {
                i = -1;
                i2 = -1;
            }
            setIndicatorPosition(i2, i);
        }

        void setIndicatorPosition(int i, int i2) {
            if (i != this.ZA || i2 != this.ZB) {
                this.ZA = i;
                this.ZB = i2;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void animateIndicatorToPosition(final int i, int i2) {
            final int i3;
            final int i4;
            if (this.ZC != null && this.ZC.isRunning()) {
                this.ZC.cancel();
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
                int i5 = this.ZA;
                i3 = this.ZB;
                i4 = i5;
            } else {
                int dpToPx = TbTabLayout.this.dpToPx(24);
                if (i < this.mSelectedPosition) {
                    if (z) {
                        int i6 = left - dpToPx;
                        i3 = i6;
                        i4 = i6;
                    } else {
                        int i7 = right + dpToPx;
                        i3 = i7;
                        i4 = i7;
                    }
                } else if (z) {
                    int i8 = right + dpToPx;
                    i3 = i8;
                    i4 = i8;
                } else {
                    int i9 = left - dpToPx;
                    i3 = i9;
                    i4 = i9;
                }
            }
            if (i4 != left || i3 != right) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.ZC = valueAnimator;
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
                        d.this.Zz = 0.0f;
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
            if (this.ZA >= 0 && this.ZB > this.ZA) {
                int i = (this.Zx <= 0 || this.ZB - this.ZA <= this.Zx) ? 0 : ((this.ZB - this.ZA) - this.Zx) / 2;
                canvas.drawLine(this.ZA + i, (getHeight() - (this.Zv / 2)) - this.Zw, this.ZB - i, (getHeight() - (this.Zv / 2)) - this.Zw, this.Zy);
            }
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (getChildAt(childCount) instanceof f) {
                    f fVar = (f) getChildAt(childCount);
                    if (fVar.ZN != null) {
                        TextView textView = null;
                        if (fVar.mTextView != null) {
                            textView = fVar.mTextView;
                        } else if (fVar.ZL != null) {
                            textView = fVar.ZL;
                        }
                        if (textView != null) {
                            int right = (fVar.getRight() - (fVar.getWidth() - textView.getRight())) - l.getDimens(getContext(), com.baidu.tieba.R.dimen.tbds3);
                            int top = (textView.getTop() - (fVar.ZN.getIntrinsicHeight() / 2)) + l.getDimens(getContext(), com.baidu.tieba.R.dimen.tbds10);
                            fVar.ZN.setBounds(right, top, fVar.ZN.getIntrinsicWidth() + right, fVar.ZN.getIntrinsicHeight() + top);
                            fVar.ZN.draw(canvas);
                            if (!TextUtils.isEmpty(fVar.ZO)) {
                                if (fVar.ZO.equals(StringHelper.STRING_MORE)) {
                                    Drawable drawable = ao.getDrawable(com.baidu.tieba.R.drawable.icon_news_white_dot);
                                    int intrinsicWidth = right + (fVar.ZN.getIntrinsicWidth() / 2);
                                    int intrinsicHeight2 = (fVar.ZN.getIntrinsicHeight() / 2) + top;
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
                                    paint.setColor(ao.getColor(com.baidu.tieba.R.color.CAM_X0101));
                                    paint.setTextSize(l.getDimens(getContext(), com.baidu.tieba.R.dimen.tbfontsize26));
                                    paint.setTextAlign(Paint.Align.CENTER);
                                    paint.setTypeface(Typeface.MONOSPACE);
                                    paint.getTextBounds(fVar.ZO, 0, fVar.ZO.length(), new Rect());
                                    canvas.drawText(fVar.ZO, right + (fVar.ZN.getIntrinsicWidth() / 2), (intrinsicHeight - ((fVar.ZN.getIntrinsicHeight() - rect.height()) / 2)) - TbTabLayout.this.Zs, paint);
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
        if (this.Za != -1) {
            return this.Za;
        }
        if (this.mMode == 0) {
            return this.Zc;
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    int getTabMaxWidth() {
        return this.YZ;
    }

    /* loaded from: classes.dex */
    public static class TbTabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private final WeakReference<TbTabLayout> ZQ;
        private int ZR;
        private int mScrollState;

        public TbTabLayoutOnPageChangeListener(TbTabLayout tbTabLayout) {
            this.ZQ = new WeakReference<>(tbTabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.ZR = this.mScrollState;
            this.mScrollState = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            boolean z = false;
            TbTabLayout tbTabLayout = this.ZQ.get();
            if (tbTabLayout != null) {
                boolean z2 = this.mScrollState != 2 || this.ZR == 1;
                if (this.mScrollState != 2 || this.ZR != 0) {
                    z = true;
                }
                tbTabLayout.setScrollPosition(i, f, z2, z);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            TbTabLayout tbTabLayout = this.ZQ.get();
            if (tbTabLayout != null && tbTabLayout.getSelectedTabPosition() != i && i < tbTabLayout.getTabCount()) {
                tbTabLayout.b(tbTabLayout.aZ(i), this.mScrollState == 0 || (this.mScrollState == 2 && this.ZR == 0));
            }
        }

        void reset() {
            this.mScrollState = 0;
            this.ZR = 0;
        }
    }

    /* loaded from: classes.dex */
    public static class g implements b {
        private final ViewPager Zk;

        public g(ViewPager viewPager) {
            this.Zk = viewPager;
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(e eVar) {
            this.Zk.setCurrentItem(eVar.getPosition());
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
        private boolean Zu;

        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            if (TbTabLayout.this.Zk == viewPager) {
                TbTabLayout.this.setPagerAdapter(pagerAdapter2, this.Zu);
            }
        }

        void setAutoRefresh(boolean z) {
            this.Zu = z;
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
