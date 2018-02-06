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
    private b awA;
    private b awB;
    private ValueAnimator awC;
    private g awD;
    private a awE;
    private e awy;
    private final d awz;
    int mMode;
    private final ArrayList<e> mTabs;
    int qD;
    int qE;
    int qF;
    int qG;
    int qH;
    ColorStateList qI;
    float qJ;
    float qK;
    final int qL;
    int qM;
    private final int qN;
    private final int qO;
    private final int qP;
    private int qQ;
    int qR;
    private final ArrayList<b> qT;
    ViewPager qW;
    private PagerAdapter qX;
    private DataSetObserver qY;
    private boolean rb;
    private final Pools.Pool<f> rc;
    private static final int[] sr = {R.attr.colorPrimary};
    public static final Interpolator kB = new FastOutSlowInInterpolator();
    private static final Pools.Pool<e> qA = new Pools.SynchronizedPool(16);

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
        this.qM = Integer.MAX_VALUE;
        this.qT = new ArrayList<>();
        this.rc = new Pools.SimplePool(12);
        R(context);
        setHorizontalScrollBarEnabled(false);
        this.awz = new d(context);
        super.addView(this.awz, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.R.styleable.TabLayout, i, android.support.design.R.style.Widget_Design_TabLayout);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, d.l.TbTabLayout);
        this.awz.O(obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabIndicatorHeight, 0));
        this.awz.dN(obtainStyledAttributes2.getDimensionPixelSize(d.l.TbTabLayout_tabIndicatorWidth, 0));
        this.awz.N(obtainStyledAttributes.getColor(android.support.design.R.styleable.TabLayout_tabIndicatorColor, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPadding, 0);
        this.qG = dimensionPixelSize;
        this.qF = dimensionPixelSize;
        this.qE = dimensionPixelSize;
        this.qD = dimensionPixelSize;
        this.qD = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingStart, this.qD);
        this.qE = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingTop, this.qE);
        this.qF = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingEnd, this.qF);
        this.qG = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingBottom, this.qG);
        this.qH = obtainStyledAttributes.getResourceId(android.support.design.R.styleable.TabLayout_tabTextAppearance, android.support.design.R.style.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(this.qH, R.styleable.TextAppearance);
        try {
            this.qJ = obtainStyledAttributes3.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
            this.qI = obtainStyledAttributes3.getColorStateList(R.styleable.TextAppearance_android_textColor);
            obtainStyledAttributes3.recycle();
            if (obtainStyledAttributes.hasValue(android.support.design.R.styleable.TabLayout_tabTextColor)) {
                this.qI = obtainStyledAttributes.getColorStateList(android.support.design.R.styleable.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(android.support.design.R.styleable.TabLayout_tabSelectedTextColor)) {
                this.qI = createColorStateList(this.qI.getDefaultColor(), obtainStyledAttributes.getColor(android.support.design.R.styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.qN = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabMinWidth, -1);
            this.qO = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabMaxWidth, -1);
            this.qL = obtainStyledAttributes.getResourceId(android.support.design.R.styleable.TabLayout_tabBackground, 0);
            this.qQ = obtainStyledAttributes.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabContentStart, 0);
            this.mMode = obtainStyledAttributes.getInt(android.support.design.R.styleable.TabLayout_tabMode, 1);
            this.qR = obtainStyledAttributes.getInt(android.support.design.R.styleable.TabLayout_tabGravity, 0);
            obtainStyledAttributes.recycle();
            obtainStyledAttributes2.recycle();
            Resources resources = getResources();
            this.qK = resources.getDimensionPixelSize(android.support.design.R.dimen.design_tab_text_size_2line);
            this.qP = resources.getDimensionPixelSize(android.support.design.R.dimen.design_tab_scrollable_min_width);
            cm();
        } catch (Throwable th) {
            obtainStyledAttributes3.recycle();
            throw th;
        }
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.awz.N(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.awz.O(i);
    }

    public void setSelectedTabIndicatorWidth(int i) {
        this.awz.dN(i);
    }

    public void setScrollPosition(int i, float f2, boolean z) {
        a(i, f2, z, true);
    }

    void a(int i, float f2, boolean z, boolean z2) {
        int round = Math.round(i + f2);
        if (round >= 0 && round < this.awz.getChildCount()) {
            if (z2) {
                this.awz.c(i, f2);
            }
            if (this.awC != null && this.awC.isRunning()) {
                this.awC.cancel();
            }
            scrollTo(b(i, f2), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    private float getScrollPosition() {
        return this.awz.co();
    }

    public void a(e eVar) {
        a(eVar, this.mTabs.isEmpty());
    }

    public void a(e eVar, boolean z) {
        a(eVar, this.mTabs.size(), z);
    }

    public void a(e eVar, int i, boolean z) {
        if (eVar.awL != this) {
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
        if (aVar.qz != 0) {
            sR.dP(aVar.qz);
        }
        if (!TextUtils.isEmpty(aVar.getContentDescription())) {
            sR.o(aVar.getContentDescription());
        }
        a(sR);
    }

    @Deprecated
    public void setOnTabSelectedListener(b bVar) {
        if (this.awA != null) {
            b(this.awA);
        }
        this.awA = bVar;
        if (bVar != null) {
            a(bVar);
        }
    }

    public void a(b bVar) {
        if (!this.qT.contains(bVar)) {
            this.qT.add(bVar);
        }
    }

    public void b(b bVar) {
        this.qT.remove(bVar);
    }

    public e sR() {
        e acquire = qA.acquire();
        if (acquire == null) {
            acquire = new e();
        }
        acquire.awL = this;
        acquire.awM = b(acquire);
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
        if (this.awy != null) {
            return this.awy.getPosition();
        }
        return -1;
    }

    public void removeAllTabs() {
        for (int childCount = this.awz.getChildCount() - 1; childCount >= 0; childCount--) {
            M(childCount);
        }
        Iterator<e> it = this.mTabs.iterator();
        while (it.hasNext()) {
            e next = it.next();
            it.remove();
            next.reset();
            qA.release(next);
        }
        this.awy = null;
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
        if (this.qR != i) {
            this.qR = i;
            cm();
        }
    }

    public int getTabGravity() {
        return this.qR;
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.qI != colorStateList) {
            this.qI = colorStateList;
            ck();
        }
    }

    public ColorStateList getTabTextColors() {
        return this.qI;
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
        if (this.qW != null) {
            if (this.awD != null) {
                this.qW.removeOnPageChangeListener(this.awD);
            }
            if (this.awE != null) {
                this.qW.removeOnAdapterChangeListener(this.awE);
            }
        }
        if (this.awB != null) {
            b(this.awB);
            this.awB = null;
        }
        if (viewPager != null) {
            this.qW = viewPager;
            if (this.awD == null) {
                this.awD = new g(this);
            }
            this.awD.reset();
            viewPager.addOnPageChangeListener(this.awD);
            this.awB = new h(viewPager);
            a(this.awB);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                a(adapter, z);
            }
            if (this.awE == null) {
                this.awE = new a();
            }
            this.awE.o(z);
            viewPager.addOnAdapterChangeListener(this.awE);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.qW = null;
            a((PagerAdapter) null, false);
        }
        this.rb = z2;
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
        if (this.qW == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                a((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.rb) {
            setupWithViewPager(null);
            this.rb = false;
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.awz.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    void a(PagerAdapter pagerAdapter, boolean z) {
        if (this.qX != null && this.qY != null) {
            this.qX.unregisterDataSetObserver(this.qY);
        }
        this.qX = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.qY == null) {
                this.qY = new c();
            }
            pagerAdapter.registerDataSetObserver(this.qY);
        }
        cj();
    }

    void cj() {
        int currentItem;
        removeAllTabs();
        if (this.qX != null) {
            int count = this.qX.getCount();
            for (int i = 0; i < count; i++) {
                a(sR().n(this.qX.getPageTitle(i)), false);
            }
            if (this.qW != null && count > 0 && (currentItem = this.qW.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
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
        f acquire = this.rc != null ? this.rc.acquire() : null;
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
        this.awz.addView(eVar.awM, eVar.getPosition(), cl());
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
        if (this.mMode == 1 && this.qR == 0) {
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
            this.qM = this.qO > 0 ? this.qO : size - L(56);
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
        f fVar = (f) this.awz.getChildAt(i);
        this.awz.removeViewAt(i);
        if (fVar != null) {
            fVar.reset();
            this.rc.release(fVar);
        }
        requestLayout();
    }

    private void animateToTab(int i) {
        if (i != -1) {
            if (getWindowToken() == null || !ViewCompat.isLaidOut(this) || this.awz.cn()) {
                setScrollPosition(i, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int b2 = b(i, 0.0f);
            if (scrollX != b2) {
                sS();
                this.awC.setIntValues(scrollX, b2);
                this.awC.start();
            }
            this.awz.p(i, 300);
        }
    }

    private void sS() {
        if (this.awC == null) {
            this.awC = new ValueAnimator();
            this.awC.setInterpolator(kB);
            this.awC.setDuration(300L);
            this.awC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.adp.widget.design.TbTabLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TbTabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        sS();
        this.awC.addListener(animatorListener);
    }

    private void setSelectedTabView(int i) {
        int childCount = this.awz.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                this.awz.getChildAt(i2).setSelected(i2 == i);
                i2++;
            }
        }
    }

    void d(e eVar) {
        b(eVar, true);
    }

    void b(e eVar, boolean z) {
        e eVar2 = this.awy;
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
        this.awy = eVar;
        if (eVar != null) {
            e(eVar);
        }
    }

    private void e(e eVar) {
        for (int size = this.qT.size() - 1; size >= 0; size--) {
            this.qT.get(size).h(eVar);
        }
    }

    private void f(e eVar) {
        for (int size = this.qT.size() - 1; size >= 0; size--) {
            this.qT.get(size).i(eVar);
        }
    }

    private void g(e eVar) {
        for (int size = this.qT.size() - 1; size >= 0; size--) {
            this.qT.get(size).j(eVar);
        }
    }

    private int b(int i, float f2) {
        if (this.mMode == 0) {
            View childAt = this.awz.getChildAt(i);
            View childAt2 = i + 1 < this.awz.getChildCount() ? this.awz.getChildAt(i + 1) : null;
            int width = childAt != null ? childAt.getWidth() : 0;
            int width2 = childAt2 != null ? childAt2.getWidth() : 0;
            int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
            int i2 = (int) ((width2 + width) * 0.5f * f2);
            return ViewCompat.getLayoutDirection(this) == 0 ? i2 + left : left - i2;
        }
        return 0;
    }

    private void cm() {
        ViewCompat.setPaddingRelative(this.awz, this.mMode == 0 ? Math.max(0, this.qQ - this.qD) : 0, 0, 0, 0);
        switch (this.mMode) {
            case 0:
                this.awz.setGravity(GravityCompat.START);
                break;
            case 1:
                this.awz.setGravity(1);
                break;
        }
        n(true);
    }

    void n(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.awz.getChildCount()) {
                View childAt = this.awz.getChildAt(i2);
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
        TbTabLayout awL;
        f awM;
        private View mCustomView;
        private Drawable mIcon;
        private int mId;
        private CharSequence mText;
        private Object rs;
        private CharSequence rt;
        private int mPosition = -1;
        private int awJ = 0;
        private boolean awK = false;

        e() {
        }

        public int sT() {
            return this.awJ;
        }

        public e r(int i, boolean z) {
            this.awJ = i;
            this.awK = z;
            cq();
            return this;
        }

        public boolean isShowRedDot() {
            return this.awK;
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
            return aK(LayoutInflater.from(this.awM.getContext()).inflate(i, (ViewGroup) this.awM, false));
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
            if (this.awL == null) {
                throw new IllegalArgumentException("Tab not attached to a TbTabLayout");
            }
            this.awL.d(this);
        }

        public boolean isSelected() {
            if (this.awL == null) {
                throw new IllegalArgumentException("Tab not attached to a TbTabLayout");
            }
            return this.awL.getSelectedTabPosition() == this.mPosition;
        }

        public e o(CharSequence charSequence) {
            this.rt = charSequence;
            cq();
            return this;
        }

        public CharSequence getContentDescription() {
            return this.rt;
        }

        void cq() {
            if (this.awM != null) {
                this.awM.update();
            }
        }

        void reset() {
            this.awL = null;
            this.awM = null;
            this.rs = null;
            this.mIcon = null;
            this.mText = null;
            this.rt = null;
            this.mPosition = -1;
            this.mCustomView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends LinearLayout {
        private e awN;
        private Drawable awO;
        private String awP;
        private View mCustomView;
        private ImageView mIconView;
        private TextView rA;
        private ImageView rB;
        private int rC;
        private TextView rz;

        public f(Context context) {
            super(context);
            this.rC = 2;
            if (TbTabLayout.this.qL != 0) {
                ViewCompat.setBackground(this, AppCompatResources.getDrawable(context, TbTabLayout.this.qL));
            }
            ViewCompat.setPaddingRelative(this, TbTabLayout.this.qD, TbTabLayout.this.qE, TbTabLayout.this.qF, TbTabLayout.this.qG);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.awN != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.awN.select();
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
            if (this.rz != null) {
                this.rz.setSelected(z);
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
                i = View.MeasureSpec.makeMeasureSpec(TbTabLayout.this.qM, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.rz != null) {
                getResources();
                float f = TbTabLayout.this.qJ;
                int i3 = this.rC;
                if (this.mIconView != null && this.mIconView.getVisibility() == 0) {
                    i3 = 1;
                } else if (this.rz != null && this.rz.getLineCount() > 1) {
                    f = TbTabLayout.this.qK;
                }
                float textSize = this.rz.getTextSize();
                int lineCount = this.rz.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.rz);
                if (f != textSize || (maxLines >= 0 && i3 != maxLines)) {
                    if (TbTabLayout.this.mMode == 1 && f > textSize && lineCount == 1 && ((layout = this.rz.getLayout()) == null || a(layout, 0, f) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.rz.setTextSize(0, f);
                        this.rz.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        void k(e eVar) {
            if (eVar != this.awN) {
                this.awN = eVar;
                update();
            }
        }

        void reset() {
            k(null);
            setSelected(false);
        }

        final void update() {
            e eVar = this.awN;
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
                if (this.rz != null) {
                    this.rz.setVisibility(8);
                }
                if (this.mIconView != null) {
                    this.mIconView.setVisibility(8);
                    this.mIconView.setImageDrawable(null);
                }
                this.rA = (TextView) customView.findViewById(16908308);
                if (this.rA != null) {
                    this.rC = TextViewCompat.getMaxLines(this.rA);
                }
                this.rB = (ImageView) customView.findViewById(16908294);
            } else {
                if (this.mCustomView != null) {
                    removeView(this.mCustomView);
                    this.mCustomView = null;
                }
                this.rA = null;
                this.rB = null;
            }
            if (this.mCustomView == null) {
                if (this.mIconView == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(android.support.design.R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                    addView(imageView, 0);
                    this.mIconView = imageView;
                }
                if (this.rz == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(android.support.design.R.layout.design_layout_tab_text, (ViewGroup) this, false);
                    addView(textView);
                    this.rz = textView;
                    this.rC = TextViewCompat.getMaxLines(this.rz);
                }
                TextViewCompat.setTextAppearance(this.rz, TbTabLayout.this.qH);
                if (TbTabLayout.this.qI != null) {
                    this.rz.setTextColor(TbTabLayout.this.qI);
                }
                b(this.rz, this.mIconView);
            } else if (this.rA != null || this.rB != null) {
                b(this.rA, this.rB);
            }
            setSelected(eVar != null && eVar.isSelected());
        }

        private void b(TextView textView, ImageView imageView) {
            int i = 0;
            Drawable icon = this.awN != null ? this.awN.getIcon() : null;
            CharSequence text = this.awN != null ? this.awN.getText() : null;
            CharSequence contentDescription = this.awN != null ? this.awN.getContentDescription() : null;
            int sT = this.awN != null ? this.awN.sT() : 0;
            boolean isShowRedDot = this.awN != null ? this.awN.isShowRedDot() : false;
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
                    TbTabLayout.this.awz.setPadding(t, TbTabLayout.this.awz.getPaddingTop(), t, TbTabLayout.this.awz.getPaddingBottom());
                    if (sT <= 0) {
                        this.awO = aj.getDrawable(d.f.icon_news_red_dot);
                        this.awP = null;
                    } else if (sT < 10) {
                        this.awO = aj.getDrawable(d.f.icon_news_red_dot_one_number);
                        this.awP = String.valueOf(sT);
                    } else if (sT < 100) {
                        this.awO = aj.getDrawable(d.f.icon_news_red_dot_two_number);
                        this.awP = String.valueOf(sT);
                    } else {
                        this.awO = aj.getDrawable(d.f.icon_news_red_dot_two_number);
                        this.awP = "...";
                    }
                    if (this.awO == null) {
                        this.awO = aj.getDrawable(d.f.icon_news_red_dot);
                    }
                } else {
                    this.awO = null;
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
        private int Pq;
        private int awG;
        private ValueAnimator awH;
        int mSelectedPosition;
        private int rf;
        private final Paint rg;
        float rh;
        private int ri;
        private int rj;

        d(Context context) {
            super(context);
            this.mSelectedPosition = -1;
            this.Pq = -1;
            this.ri = -1;
            this.rj = -1;
            setWillNotDraw(false);
            this.rg = new Paint();
            this.rg.setStrokeCap(Paint.Cap.ROUND);
            this.rg.setAntiAlias(true);
        }

        void N(int i) {
            if (this.rg.getColor() != i) {
                this.rg.setColor(i);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void O(int i) {
            if (this.rf != i) {
                this.rf = i;
                this.rg.setStrokeWidth(this.rf);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void dN(int i) {
            if (this.awG != i) {
                this.awG = i;
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
            if (this.awH != null && this.awH.isRunning()) {
                this.awH.cancel();
            }
            this.mSelectedPosition = i;
            this.rh = f;
            cp();
        }

        float co() {
            return this.mSelectedPosition + this.rh;
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT < 23 && this.Pq != i) {
                requestLayout();
                this.Pq = i;
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            boolean z;
            boolean z2 = false;
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) == 1073741824 && TbTabLayout.this.mMode == 1 && TbTabLayout.this.qR == 1) {
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
                        TbTabLayout.this.qR = 0;
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
            if (this.awH != null && this.awH.isRunning()) {
                this.awH.cancel();
                p(this.mSelectedPosition, Math.round(((float) this.awH.getDuration()) * (1.0f - this.awH.getAnimatedFraction())));
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
                if (this.rh > 0.0f && this.mSelectedPosition < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.mSelectedPosition + 1);
                    i2 = (int) ((i2 * (1.0f - this.rh)) + (this.rh * childAt2.getLeft()));
                    i = (int) ((i * (1.0f - this.rh)) + (childAt2.getRight() * this.rh));
                }
            } else {
                i = -1;
                i2 = -1;
            }
            o(i2, i);
        }

        void o(int i, int i2) {
            if (i != this.ri || i2 != this.rj) {
                this.ri = i;
                this.rj = i2;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void p(final int i, int i2) {
            final int i3;
            final int i4;
            if (this.awH != null && this.awH.isRunning()) {
                this.awH.cancel();
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
                i4 = this.ri;
                i3 = this.rj;
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
                this.awH = valueAnimator;
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
                        d.this.rh = 0.0f;
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
            if (this.ri >= 0 && this.rj > this.ri) {
                int i = (this.awG <= 0 || this.rj - this.ri <= this.awG) ? 0 : ((this.rj - this.ri) - this.awG) / 2;
                canvas.drawLine(this.ri + i, getHeight() - (this.rf / 2), this.rj - i, getHeight() - (this.rf / 2), this.rg);
            }
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (getChildAt(childCount) instanceof f) {
                    f fVar = (f) getChildAt(childCount);
                    if (fVar.awO != null) {
                        TextView textView = null;
                        if (fVar.rz != null) {
                            textView = fVar.rz;
                        } else if (fVar.rA != null) {
                            textView = fVar.rA;
                        }
                        if (textView != null) {
                            int right = (fVar.getRight() - (fVar.getWidth() - textView.getRight())) - l.t(getContext(), d.e.tbds3);
                            int top = (textView.getTop() - (fVar.awO.getIntrinsicHeight() / 2)) + l.t(getContext(), d.e.tbds10);
                            fVar.awO.setBounds(right, top, fVar.awO.getIntrinsicWidth() + right, fVar.awO.getIntrinsicHeight() + top);
                            fVar.awO.draw(canvas);
                            if (!TextUtils.isEmpty(fVar.awP)) {
                                if (fVar.awP.equals("...")) {
                                    Drawable drawable = aj.getDrawable(d.f.icon_news_white_dot);
                                    int intrinsicWidth = right + (fVar.awO.getIntrinsicWidth() / 2);
                                    int intrinsicHeight2 = (fVar.awO.getIntrinsicHeight() / 2) + top;
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
                                    paint.setColor(aj.getColor(d.C0140d.cp_cont_i));
                                    paint.setTextSize(l.t(getContext(), d.e.tbfontsize26));
                                    paint.setTextAlign(Paint.Align.CENTER);
                                    paint.setTypeface(Typeface.MONOSPACE);
                                    paint.getTextBounds(fVar.awP, 0, fVar.awP.length(), new Rect());
                                    canvas.drawText(fVar.awP, right + (fVar.awO.getIntrinsicWidth() / 2), intrinsicHeight - ((fVar.awO.getIntrinsicHeight() - rect.height()) / 2), paint);
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
        if (this.qN != -1) {
            return this.qN;
        }
        if (this.mMode == 0) {
            return this.qP;
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    int getTabMaxWidth() {
        return this.qM;
    }

    /* loaded from: classes.dex */
    public static class g implements ViewPager.OnPageChangeListener {
        private final WeakReference<TbTabLayout> awQ;
        private int mScrollState;
        private int rx;

        public g(TbTabLayout tbTabLayout) {
            this.awQ = new WeakReference<>(tbTabLayout);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.rx = this.mScrollState;
            this.mScrollState = i;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            boolean z = false;
            TbTabLayout tbTabLayout = this.awQ.get();
            if (tbTabLayout != null) {
                boolean z2 = this.mScrollState != 2 || this.rx == 1;
                if (this.mScrollState != 2 || this.rx != 0) {
                    z = true;
                }
                tbTabLayout.a(i, f, z2, z);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            TbTabLayout tbTabLayout = this.awQ.get();
            if (tbTabLayout != null && tbTabLayout.getSelectedTabPosition() != i && i < tbTabLayout.getTabCount()) {
                tbTabLayout.b(tbTabLayout.dM(i), this.mScrollState == 0 || (this.mScrollState == 2 && this.rx == 0));
            }
        }

        void reset() {
            this.mScrollState = 0;
            this.rx = 0;
        }
    }

    /* loaded from: classes.dex */
    public static class h implements b {
        private final ViewPager qW;

        public h(ViewPager viewPager) {
            this.qW = viewPager;
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.b
        public void h(e eVar) {
            this.qW.setCurrentItem(eVar.getPosition());
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
        private boolean re;

        a() {
        }

        @Override // android.support.v4.view.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            if (TbTabLayout.this.qW == viewPager) {
                TbTabLayout.this.a(pagerAdapter2, this.re);
            }
        }

        void o(boolean z) {
            this.re = z;
        }
    }

    public static void R(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(sr);
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
