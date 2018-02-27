package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.design.R;
import android.support.design.widget.s;
import android.support.v4.util.Pools;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBar;
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
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
@ViewPager.DecorView
/* loaded from: classes2.dex */
public class TabLayout extends HorizontalScrollView {
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    private static final Pools.Pool<Tab> qz = new Pools.SynchronizedPool(16);
    int mMode;
    private final ArrayList<Tab> mTabs;
    private Tab qA;
    private final c qB;
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
    private OnTabSelectedListener qR;
    private final ArrayList<OnTabSelectedListener> qS;
    private OnTabSelectedListener qT;
    private s qU;
    ViewPager qV;
    private PagerAdapter qW;
    private DataSetObserver qX;
    private TabLayoutOnPageChangeListener qY;
    private a qZ;
    private boolean ra;
    private final Pools.Pool<d> rb;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes2.dex */
    public @interface Mode {
    }

    /* loaded from: classes2.dex */
    public interface OnTabSelectedListener {
        void onTabReselected(Tab tab);

        void onTabSelected(Tab tab);

        void onTabUnselected(Tab tab);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes2.dex */
    public @interface TabGravity {
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTabs = new ArrayList<>();
        this.qL = Integer.MAX_VALUE;
        this.qS = new ArrayList<>();
        this.rb = new Pools.SimplePool(12);
        r.R(context);
        setHorizontalScrollBarEnabled(false);
        this.qB = new c(context);
        super.addView(this.qB, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TabLayout, i, R.style.Widget_Design_TabLayout);
        this.qB.O(obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, 0));
        this.qB.N(obtainStyledAttributes.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.qF = dimensionPixelSize;
        this.qE = dimensionPixelSize;
        this.qD = dimensionPixelSize;
        this.qC = dimensionPixelSize;
        this.qC = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, this.qC);
        this.qD = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.qD);
        this.qE = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.qE);
        this.qF = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.qF);
        this.qG = obtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(this.qG, android.support.v7.appcompat.R.styleable.TextAppearance);
        try {
            this.qI = obtainStyledAttributes2.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.TextAppearance_android_textSize, 0);
            this.qH = obtainStyledAttributes2.getColorStateList(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor);
            obtainStyledAttributes2.recycle();
            if (obtainStyledAttributes.hasValue(R.styleable.TabLayout_tabTextColor)) {
                this.qH = obtainStyledAttributes.getColorStateList(R.styleable.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(R.styleable.TabLayout_tabSelectedTextColor)) {
                this.qH = createColorStateList(this.qH.getDefaultColor(), obtainStyledAttributes.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.qM = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
            this.qN = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
            this.qK = obtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabBackground, 0);
            this.qP = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
            this.mMode = obtainStyledAttributes.getInt(R.styleable.TabLayout_tabMode, 1);
            this.qQ = obtainStyledAttributes.getInt(R.styleable.TabLayout_tabGravity, 0);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.qJ = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.qO = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            cm();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.qB.N(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.qB.O(i);
    }

    public void setScrollPosition(int i, float f, boolean z) {
        a(i, f, z, true);
    }

    void a(int i, float f, boolean z, boolean z2) {
        int round = Math.round(i + f);
        if (round >= 0 && round < this.qB.getChildCount()) {
            if (z2) {
                this.qB.c(i, f);
            }
            if (this.qU != null && this.qU.isRunning()) {
                this.qU.cancel();
            }
            scrollTo(b(i, f), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    private float getScrollPosition() {
        return this.qB.co();
    }

    public void addTab(Tab tab) {
        addTab(tab, this.mTabs.isEmpty());
    }

    public void addTab(Tab tab, int i) {
        addTab(tab, i, this.mTabs.isEmpty());
    }

    public void addTab(Tab tab, boolean z) {
        addTab(tab, this.mTabs.size(), z);
    }

    public void addTab(Tab tab, int i, boolean z) {
        if (tab.rt != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        a(tab, i);
        b(tab);
        if (z) {
            tab.select();
        }
    }

    private void a(TabItem tabItem) {
        Tab newTab = newTab();
        if (tabItem.mText != null) {
            newTab.setText(tabItem.mText);
        }
        if (tabItem.mIcon != null) {
            newTab.setIcon(tabItem.mIcon);
        }
        if (tabItem.qy != 0) {
            newTab.setCustomView(tabItem.qy);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            newTab.setContentDescription(tabItem.getContentDescription());
        }
        addTab(newTab);
    }

    @Deprecated
    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        if (this.qR != null) {
            removeOnTabSelectedListener(this.qR);
        }
        this.qR = onTabSelectedListener;
        if (onTabSelectedListener != null) {
            addOnTabSelectedListener(onTabSelectedListener);
        }
    }

    public void addOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        if (!this.qS.contains(onTabSelectedListener)) {
            this.qS.add(onTabSelectedListener);
        }
    }

    public void removeOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.qS.remove(onTabSelectedListener);
    }

    public void clearOnTabSelectedListeners() {
        this.qS.clear();
    }

    public Tab newTab() {
        Tab acquire = qz.acquire();
        if (acquire == null) {
            acquire = new Tab();
        }
        acquire.rt = this;
        acquire.ru = a(acquire);
        return acquire;
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public Tab getTabAt(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return this.mTabs.get(i);
    }

    public int getSelectedTabPosition() {
        if (this.qA != null) {
            return this.qA.getPosition();
        }
        return -1;
    }

    public void removeTab(Tab tab) {
        if (tab.rt != this) {
            throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
        }
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int i) {
        int position = this.qA != null ? this.qA.getPosition() : 0;
        M(i);
        Tab remove = this.mTabs.remove(i);
        if (remove != null) {
            remove.reset();
            qz.release(remove);
        }
        int size = this.mTabs.size();
        for (int i2 = i; i2 < size; i2++) {
            this.mTabs.get(i2).setPosition(i2);
        }
        if (position == i) {
            c(this.mTabs.isEmpty() ? null : this.mTabs.get(Math.max(0, i - 1)));
        }
    }

    public void removeAllTabs() {
        for (int childCount = this.qB.getChildCount() - 1; childCount >= 0; childCount--) {
            M(childCount);
        }
        Iterator<Tab> it = this.mTabs.iterator();
        while (it.hasNext()) {
            Tab next = it.next();
            it.remove();
            next.reset();
            qz.release(next);
        }
        this.qA = null;
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
            if (this.qY != null) {
                this.qV.removeOnPageChangeListener(this.qY);
            }
            if (this.qZ != null) {
                this.qV.removeOnAdapterChangeListener(this.qZ);
            }
        }
        if (this.qT != null) {
            removeOnTabSelectedListener(this.qT);
            this.qT = null;
        }
        if (viewPager != null) {
            this.qV = viewPager;
            if (this.qY == null) {
                this.qY = new TabLayoutOnPageChangeListener(this);
            }
            this.qY.reset();
            viewPager.addOnPageChangeListener(this.qY);
            this.qT = new ViewPagerOnTabSelectedListener(viewPager);
            addOnTabSelectedListener(this.qT);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                a(adapter, z);
            }
            if (this.qZ == null) {
                this.qZ = new a();
            }
            this.qZ.o(z);
            viewPager.addOnAdapterChangeListener(this.qZ);
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
        return Math.max(0, ((this.qB.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    void a(PagerAdapter pagerAdapter, boolean z) {
        if (this.qW != null && this.qX != null) {
            this.qW.unregisterDataSetObserver(this.qX);
        }
        this.qW = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.qX == null) {
                this.qX = new b();
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
                addTab(newTab().setText(this.qW.getPageTitle(i)), false);
            }
            if (this.qV != null && count > 0 && (currentItem = this.qV.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                c(getTabAt(currentItem));
            }
        }
    }

    private void ck() {
        int size = this.mTabs.size();
        for (int i = 0; i < size; i++) {
            this.mTabs.get(i).cq();
        }
    }

    private d a(Tab tab) {
        d acquire = this.rb != null ? this.rb.acquire() : null;
        if (acquire == null) {
            acquire = new d(getContext());
        }
        acquire.g(tab);
        acquire.setFocusable(true);
        acquire.setMinimumWidth(getTabMinWidth());
        return acquire;
    }

    private void a(Tab tab, int i) {
        tab.setPosition(i);
        this.mTabs.add(i, tab);
        int size = this.mTabs.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            this.mTabs.get(i2).setPosition(i2);
        }
    }

    private void b(Tab tab) {
        this.qB.addView(tab.ru, tab.getPosition(), cl());
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
        if (view instanceof TabItem) {
            a((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
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
        d dVar = (d) this.qB.getChildAt(i);
        this.qB.removeViewAt(i);
        if (dVar != null) {
            dVar.reset();
            this.rb.release(dVar);
        }
        requestLayout();
    }

    private void animateToTab(int i) {
        if (i != -1) {
            if (getWindowToken() == null || !ViewCompat.isLaidOut(this) || this.qB.cn()) {
                setScrollPosition(i, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int b2 = b(i, 0.0f);
            if (scrollX != b2) {
                if (this.qU == null) {
                    this.qU = z.cE();
                    this.qU.setInterpolator(android.support.design.widget.a.kB);
                    this.qU.setDuration(300L);
                    this.qU.a(new s.c() { // from class: android.support.design.widget.TabLayout.1
                        @Override // android.support.design.widget.s.c
                        public void a(s sVar) {
                            TabLayout.this.scrollTo(sVar.cA(), 0);
                        }
                    });
                }
                this.qU.q(scrollX, b2);
                this.qU.start();
            }
            this.qB.p(i, 300);
        }
    }

    private void setSelectedTabView(int i) {
        int childCount = this.qB.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                this.qB.getChildAt(i2).setSelected(i2 == i);
                i2++;
            }
        }
    }

    void c(Tab tab) {
        a(tab, true);
    }

    void a(Tab tab, boolean z) {
        Tab tab2 = this.qA;
        if (tab2 == tab) {
            if (tab2 != null) {
                f(tab);
                animateToTab(tab.getPosition());
                return;
            }
            return;
        }
        int position = tab != null ? tab.getPosition() : -1;
        if (z) {
            if ((tab2 == null || tab2.getPosition() == -1) && position != -1) {
                setScrollPosition(position, 0.0f, true);
            } else {
                animateToTab(position);
            }
            if (position != -1) {
                setSelectedTabView(position);
            }
        }
        if (tab2 != null) {
            e(tab2);
        }
        this.qA = tab;
        if (tab != null) {
            d(tab);
        }
    }

    private void d(Tab tab) {
        for (int size = this.qS.size() - 1; size >= 0; size--) {
            this.qS.get(size).onTabSelected(tab);
        }
    }

    private void e(Tab tab) {
        for (int size = this.qS.size() - 1; size >= 0; size--) {
            this.qS.get(size).onTabUnselected(tab);
        }
    }

    private void f(Tab tab) {
        for (int size = this.qS.size() - 1; size >= 0; size--) {
            this.qS.get(size).onTabReselected(tab);
        }
    }

    private int b(int i, float f) {
        if (this.mMode == 0) {
            View childAt = this.qB.getChildAt(i);
            View childAt2 = i + 1 < this.qB.getChildCount() ? this.qB.getChildAt(i + 1) : null;
            return ((((int) ((((childAt2 != null ? childAt2.getWidth() : 0) + (childAt != null ? childAt.getWidth() : 0)) * f) * 0.5f)) + childAt.getLeft()) + (childAt.getWidth() / 2)) - (getWidth() / 2);
        }
        return 0;
    }

    private void cm() {
        ViewCompat.setPaddingRelative(this.qB, this.mMode == 0 ? Math.max(0, this.qP - this.qC) : 0, 0, 0, 0);
        switch (this.mMode) {
            case 0:
                this.qB.setGravity(GravityCompat.START);
                break;
            case 1:
                this.qB.setGravity(1);
                break;
        }
        n(true);
    }

    void n(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.qB.getChildCount()) {
                View childAt = this.qB.getChildAt(i2);
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

    /* loaded from: classes2.dex */
    public static final class Tab {
        public static final int INVALID_POSITION = -1;
        private View mCustomView;
        private Drawable mIcon;
        private int mPosition = -1;
        private CharSequence mText;
        private Object rr;
        private CharSequence rs;
        TabLayout rt;
        d ru;

        Tab() {
        }

        public Object getTag() {
            return this.rr;
        }

        public Tab setTag(Object obj) {
            this.rr = obj;
            return this;
        }

        public View getCustomView() {
            return this.mCustomView;
        }

        public Tab setCustomView(View view) {
            this.mCustomView = view;
            cq();
            return this;
        }

        public Tab setCustomView(int i) {
            return setCustomView(LayoutInflater.from(this.ru.getContext()).inflate(i, (ViewGroup) this.ru, false));
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

        public Tab setIcon(Drawable drawable) {
            this.mIcon = drawable;
            cq();
            return this;
        }

        public Tab setIcon(int i) {
            if (this.rt == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return setIcon(AppCompatResources.getDrawable(this.rt.getContext(), i));
        }

        public Tab setText(CharSequence charSequence) {
            this.mText = charSequence;
            cq();
            return this;
        }

        public Tab setText(int i) {
            if (this.rt == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return setText(this.rt.getResources().getText(i));
        }

        public void select() {
            if (this.rt == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.rt.c(this);
        }

        public boolean isSelected() {
            if (this.rt == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return this.rt.getSelectedTabPosition() == this.mPosition;
        }

        public Tab setContentDescription(int i) {
            if (this.rt == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return setContentDescription(this.rt.getResources().getText(i));
        }

        public Tab setContentDescription(CharSequence charSequence) {
            this.rs = charSequence;
            cq();
            return this;
        }

        public CharSequence getContentDescription() {
            return this.rs;
        }

        void cq() {
            if (this.ru != null) {
                this.ru.update();
            }
        }

        void reset() {
            this.rt = null;
            this.ru = null;
            this.rr = null;
            this.mIcon = null;
            this.mText = null;
            this.rs = null;
            this.mPosition = -1;
            this.mCustomView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d extends LinearLayout implements View.OnLongClickListener {
        private View mCustomView;
        private ImageView mIconView;
        private ImageView rA;
        private int rB;
        private Tab rx;
        private TextView ry;
        private TextView rz;

        public d(Context context) {
            super(context);
            this.rB = 2;
            if (TabLayout.this.qK != 0) {
                ViewCompat.setBackground(this, AppCompatResources.getDrawable(context, TabLayout.this.qK));
            }
            ViewCompat.setPaddingRelative(this, TabLayout.this.qC, TabLayout.this.qD, TabLayout.this.qE, TabLayout.this.qF);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.rx != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.rx.select();
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
        @TargetApi(14)
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        @TargetApi(14)
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
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.qL, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.ry != null) {
                getResources();
                float f = TabLayout.this.qI;
                int i3 = this.rB;
                if (this.mIconView != null && this.mIconView.getVisibility() == 0) {
                    i3 = 1;
                } else if (this.ry != null && this.ry.getLineCount() > 1) {
                    f = TabLayout.this.qJ;
                }
                float textSize = this.ry.getTextSize();
                int lineCount = this.ry.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.ry);
                if (f != textSize || (maxLines >= 0 && i3 != maxLines)) {
                    if (TabLayout.this.mMode == 1 && f > textSize && lineCount == 1 && ((layout = this.ry.getLayout()) == null || a(layout, 0, f) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
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

        void g(Tab tab) {
            if (tab != this.rx) {
                this.rx = tab;
                update();
            }
        }

        void reset() {
            g(null);
            setSelected(false);
        }

        final void update() {
            Tab tab = this.rx;
            View customView = tab != null ? tab.getCustomView() : null;
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
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                    addView(imageView, 0);
                    this.mIconView = imageView;
                }
                if (this.ry == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) this, false);
                    addView(textView);
                    this.ry = textView;
                    this.rB = TextViewCompat.getMaxLines(this.ry);
                }
                TextViewCompat.setTextAppearance(this.ry, TabLayout.this.qG);
                if (TabLayout.this.qH != null) {
                    this.ry.setTextColor(TabLayout.this.qH);
                }
                b(this.ry, this.mIconView);
            } else if (this.rz != null || this.rA != null) {
                b(this.rz, this.rA);
            }
            setSelected(tab != null && tab.isSelected());
        }

        private void b(TextView textView, ImageView imageView) {
            Drawable icon = this.rx != null ? this.rx.getIcon() : null;
            CharSequence text = this.rx != null ? this.rx.getText() : null;
            CharSequence contentDescription = this.rx != null ? this.rx.getContentDescription() : null;
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
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int L = (z && imageView.getVisibility() == 0) ? TabLayout.this.L(8) : 0;
                if (L != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = L;
                    imageView.requestLayout();
                }
            }
            if (!z && !TextUtils.isEmpty(contentDescription)) {
                setOnLongClickListener(this);
                return;
            }
            setOnLongClickListener(null);
            setLongClickable(false);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            Rect rect = new Rect();
            getLocationOnScreen(iArr);
            getWindowVisibleDisplayFrame(rect);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = iArr[1] + (height / 2);
            int i2 = (width / 2) + iArr[0];
            if (ViewCompat.getLayoutDirection(view) == 0) {
                i2 = context.getResources().getDisplayMetrics().widthPixels - i2;
            }
            Toast makeText = Toast.makeText(context, this.rx.getContentDescription(), 0);
            if (i < rect.height()) {
                makeText.setGravity(8388661, i2, (iArr[1] + height) - rect.top);
            } else {
                makeText.setGravity(81, 0, height);
            }
            makeText.show();
            return true;
        }

        private float a(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends LinearLayout {
        int mSelectedPosition;
        private int re;
        private final Paint rf;
        float rg;
        private int rh;
        private int ri;
        private s rj;

        c(Context context) {
            super(context);
            this.mSelectedPosition = -1;
            this.rh = -1;
            this.ri = -1;
            setWillNotDraw(false);
            this.rf = new Paint();
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
            if (this.rj != null && this.rj.isRunning()) {
                this.rj.cancel();
            }
            this.mSelectedPosition = i;
            this.rg = f;
            cp();
        }

        float co() {
            return this.mSelectedPosition + this.rg;
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            boolean z;
            boolean z2 = false;
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) == 1073741824 && TabLayout.this.mMode == 1 && TabLayout.this.qQ == 1) {
                int childCount = getChildCount();
                int i3 = 0;
                int i4 = 0;
                while (i3 < childCount) {
                    View childAt = getChildAt(i3);
                    i3++;
                    i4 = childAt.getVisibility() == 0 ? Math.max(i4, childAt.getMeasuredWidth()) : i4;
                }
                if (i4 > 0) {
                    if (i4 * childCount <= getMeasuredWidth() - (TabLayout.this.L(16) * 2)) {
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
                        TabLayout.this.qQ = 0;
                        TabLayout.this.n(false);
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
            if (this.rj != null && this.rj.isRunning()) {
                this.rj.cancel();
                p(this.mSelectedPosition, Math.round(((float) this.rj.getDuration()) * (1.0f - this.rj.getAnimatedFraction())));
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
            if (this.rj != null && this.rj.isRunning()) {
                this.rj.cancel();
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
                int L = TabLayout.this.L(24);
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
                s cE = z.cE();
                this.rj = cE;
                cE.setInterpolator(android.support.design.widget.a.kB);
                cE.setDuration(i2);
                cE.e(0.0f, 1.0f);
                cE.a(new s.c() { // from class: android.support.design.widget.TabLayout.c.1
                    @Override // android.support.design.widget.s.c
                    public void a(s sVar) {
                        float animatedFraction = sVar.getAnimatedFraction();
                        c.this.o(android.support.design.widget.a.b(i4, left, animatedFraction), android.support.design.widget.a.b(i3, right, animatedFraction));
                    }
                });
                cE.a(new s.b() { // from class: android.support.design.widget.TabLayout.c.2
                    @Override // android.support.design.widget.s.b, android.support.design.widget.s.a
                    public void b(s sVar) {
                        c.this.mSelectedPosition = i;
                        c.this.rg = 0.0f;
                    }
                });
                cE.start();
            }
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            super.draw(canvas);
            if (this.rh >= 0 && this.ri > this.rh) {
                canvas.drawRect(this.rh, getHeight() - this.re, this.ri, getHeight(), this.rf);
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
                Tab tab = this.mTabs.get(i);
                if (tab == null || tab.getIcon() == null || TextUtils.isEmpty(tab.getText())) {
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

    /* loaded from: classes2.dex */
    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private int mScrollState;
        private final WeakReference<TabLayout> rv;
        private int rw;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.rv = new WeakReference<>(tabLayout);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.rw = this.mScrollState;
            this.mScrollState = i;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            boolean z = false;
            TabLayout tabLayout = this.rv.get();
            if (tabLayout != null) {
                boolean z2 = this.mScrollState != 2 || this.rw == 1;
                if (this.mScrollState != 2 || this.rw != 0) {
                    z = true;
                }
                tabLayout.a(i, f, z2, z);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            TabLayout tabLayout = this.rv.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                tabLayout.a(tabLayout.getTabAt(i), this.mScrollState == 0 || (this.mScrollState == 2 && this.rw == 0));
            }
        }

        void reset() {
            this.mScrollState = 0;
            this.rw = 0;
        }
    }

    /* loaded from: classes2.dex */
    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager qV;

        public ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            this.qV = viewPager;
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabSelected(Tab tab) {
            this.qV.setCurrentItem(tab.getPosition());
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabUnselected(Tab tab) {
        }

        @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
        public void onTabReselected(Tab tab) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.cj();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.cj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements ViewPager.OnAdapterChangeListener {
        private boolean rd;

        a() {
        }

        @Override // android.support.v4.view.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            if (TabLayout.this.qV == viewPager) {
                TabLayout.this.a(pagerAdapter2, this.rd);
            }
        }

        void o(boolean z) {
            this.rd = z;
        }
    }
}
