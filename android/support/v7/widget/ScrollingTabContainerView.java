package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
@RestrictTo
/* loaded from: classes2.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final Interpolator TV = new DecelerateInterpolator();
    Runnable TM;
    private b TO;
    LinearLayoutCompat TP;
    private Spinner TQ;
    private boolean TR;
    int TS;
    int TT;
    private int TU;
    private int mContentHeight;
    protected final VisibilityAnimListener mVisAnimListener;
    protected ViewPropertyAnimatorCompat mVisibilityAnim;

    public ScrollingTabContainerView(Context context) {
        super(context);
        this.mVisAnimListener = new VisibilityAnimListener();
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.TT = actionBarPolicy.getStackedTabMaxWidth();
        this.TP = hu();
        addView(this.TP, new ViewGroup.LayoutParams(-2, -1));
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        boolean z = true;
        int mode = View.MeasureSpec.getMode(i);
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.TP.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.TS = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.TS = View.MeasureSpec.getSize(i) / 2;
            }
            this.TS = Math.min(this.TS, this.TT);
        } else {
            this.TS = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
        if (z2 || !this.TR) {
            z = false;
        }
        if (z) {
            this.TP.measure(0, makeMeasureSpec);
            if (this.TP.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                hs();
            } else {
                ht();
            }
        } else {
            ht();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z2 && measuredWidth != measuredWidth2) {
            setTabSelected(this.TU);
        }
    }

    private boolean hr() {
        return this.TQ != null && this.TQ.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.TR = z;
    }

    private void hs() {
        if (!hr()) {
            if (this.TQ == null) {
                this.TQ = hv();
            }
            removeView(this.TP);
            addView(this.TQ, new ViewGroup.LayoutParams(-2, -1));
            if (this.TQ.getAdapter() == null) {
                this.TQ.setAdapter((SpinnerAdapter) new a());
            }
            if (this.TM != null) {
                removeCallbacks(this.TM);
                this.TM = null;
            }
            this.TQ.setSelection(this.TU);
        }
    }

    private boolean ht() {
        if (hr()) {
            removeView(this.TQ);
            addView(this.TP, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.TQ.getSelectedItemPosition());
        }
        return false;
    }

    public void setTabSelected(int i) {
        this.TU = i;
        int childCount = this.TP.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.TP.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                animateToTab(i);
            }
            i2++;
        }
        if (this.TQ != null && i >= 0) {
            this.TQ.setSelection(i);
        }
    }

    public void setContentHeight(int i) {
        this.mContentHeight = i;
        requestLayout();
    }

    private LinearLayoutCompat hu() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    private Spinner hv() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(getContext());
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.TT = actionBarPolicy.getStackedTabMaxWidth();
    }

    public void animateToVisibility(int i) {
        if (this.mVisibilityAnim != null) {
            this.mVisibilityAnim.cancel();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                ViewCompat.setAlpha(this, 0.0f);
            }
            ViewPropertyAnimatorCompat alpha = ViewCompat.animate(this).alpha(1.0f);
            alpha.setDuration(200L);
            alpha.setInterpolator(TV);
            alpha.setListener(this.mVisAnimListener.withFinalVisibility(alpha, i));
            alpha.start();
            return;
        }
        ViewPropertyAnimatorCompat alpha2 = ViewCompat.animate(this).alpha(0.0f);
        alpha2.setDuration(200L);
        alpha2.setInterpolator(TV);
        alpha2.setListener(this.mVisAnimListener.withFinalVisibility(alpha2, i));
        alpha2.start();
    }

    public void animateToTab(int i) {
        final View childAt = this.TP.getChildAt(i);
        if (this.TM != null) {
            removeCallbacks(this.TM);
        }
        this.TM = new Runnable() { // from class: android.support.v7.widget.ScrollingTabContainerView.1
            @Override // java.lang.Runnable
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                ScrollingTabContainerView.this.TM = null;
            }
        };
        post(this.TM);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.TM != null) {
            post(this.TM);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.TM != null) {
            removeCallbacks(this.TM);
        }
    }

    c a(ActionBar.Tab tab, boolean z) {
        c cVar = new c(getContext(), tab, z);
        if (z) {
            cVar.setBackgroundDrawable(null);
            cVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.mContentHeight));
        } else {
            cVar.setFocusable(true);
            if (this.TO == null) {
                this.TO = new b();
            }
            cVar.setOnClickListener(this.TO);
        }
        return cVar;
    }

    public void addTab(ActionBar.Tab tab, boolean z) {
        c a2 = a(tab, false);
        this.TP.addView(a2, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        if (this.TQ != null) {
            ((a) this.TQ.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            a2.setSelected(true);
        }
        if (this.TR) {
            requestLayout();
        }
    }

    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        c a2 = a(tab, false);
        this.TP.addView(a2, i, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        if (this.TQ != null) {
            ((a) this.TQ.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            a2.setSelected(true);
        }
        if (this.TR) {
            requestLayout();
        }
    }

    public void updateTab(int i) {
        ((c) this.TP.getChildAt(i)).update();
        if (this.TQ != null) {
            ((a) this.TQ.getAdapter()).notifyDataSetChanged();
        }
        if (this.TR) {
            requestLayout();
        }
    }

    public void removeTabAt(int i) {
        this.TP.removeViewAt(i);
        if (this.TQ != null) {
            ((a) this.TQ.getAdapter()).notifyDataSetChanged();
        }
        if (this.TR) {
            requestLayout();
        }
    }

    public void removeAllTabs() {
        this.TP.removeAllViews();
        if (this.TQ != null) {
            ((a) this.TQ.getAdapter()).notifyDataSetChanged();
        }
        if (this.TR) {
            requestLayout();
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((c) view).hw().select();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends LinearLayoutCompat implements View.OnLongClickListener {
        private final int[] TY;
        private ActionBar.Tab TZ;
        private View mCustomView;
        private ImageView mIconView;
        private TextView rz;

        public c(Context context, ActionBar.Tab tab, boolean z) {
            super(context, null, R.attr.actionBarTabStyle);
            this.TY = new int[]{16842964};
            this.TZ = tab;
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, null, this.TY, R.attr.actionBarTabStyle, 0);
            if (obtainStyledAttributes.hasValue(0)) {
                setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            }
            obtainStyledAttributes.recycle();
            if (z) {
                setGravity(8388627);
            }
            update();
        }

        public void a(ActionBar.Tab tab) {
            this.TZ = tab;
            update();
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        @Override // android.support.v7.widget.LinearLayoutCompat, android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.support.v7.widget.LinearLayoutCompat, android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (Build.VERSION.SDK_INT >= 14) {
                accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
            }
        }

        @Override // android.support.v7.widget.LinearLayoutCompat, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (ScrollingTabContainerView.this.TS > 0 && getMeasuredWidth() > ScrollingTabContainerView.this.TS) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(ScrollingTabContainerView.this.TS, 1073741824), i2);
            }
        }

        public void update() {
            ActionBar.Tab tab = this.TZ;
            View customView = tab.getCustomView();
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
                    return;
                }
                return;
            }
            if (this.mCustomView != null) {
                removeView(this.mCustomView);
                this.mCustomView = null;
            }
            Drawable icon = tab.getIcon();
            CharSequence text = tab.getText();
            if (icon != null) {
                if (this.mIconView == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.mIconView = appCompatImageView;
                }
                this.mIconView.setImageDrawable(icon);
                this.mIconView.setVisibility(0);
            } else if (this.mIconView != null) {
                this.mIconView.setVisibility(8);
                this.mIconView.setImageDrawable(null);
            }
            boolean z = !TextUtils.isEmpty(text);
            if (z) {
                if (this.rz == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayoutCompat.LayoutParams layoutParams2 = new LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.rz = appCompatTextView;
                }
                this.rz.setText(text);
                this.rz.setVisibility(0);
            } else if (this.rz != null) {
                this.rz.setVisibility(8);
                this.rz.setText((CharSequence) null);
            }
            if (this.mIconView != null) {
                this.mIconView.setContentDescription(tab.getContentDescription());
            }
            if (!z && !TextUtils.isEmpty(tab.getContentDescription())) {
                setOnLongClickListener(this);
                return;
            }
            setOnLongClickListener(null);
            setLongClickable(false);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.TZ.getContentDescription(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }

        public ActionBar.Tab hw() {
            return this.TZ;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScrollingTabContainerView.this.TP.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((c) ScrollingTabContainerView.this.TP.getChildAt(i)).hw();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.a((ActionBar.Tab) getItem(i), true);
            }
            ((c) view).a((ActionBar.Tab) getItem(i));
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((c) view).hw().select();
            int childCount = ScrollingTabContainerView.this.TP.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ScrollingTabContainerView.this.TP.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* loaded from: classes2.dex */
    protected class VisibilityAnimListener implements ViewPropertyAnimatorListener {
        private int JT;
        private boolean mCanceled = false;

        protected VisibilityAnimListener() {
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
            this.JT = i;
            ScrollingTabContainerView.this.mVisibilityAnim = viewPropertyAnimatorCompat;
            return this;
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.mCanceled = false;
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            if (!this.mCanceled) {
                ScrollingTabContainerView.this.mVisibilityAnim = null;
                ScrollingTabContainerView.this.setVisibility(this.JT);
            }
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view) {
            this.mCanceled = true;
        }
    }
}
