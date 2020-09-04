package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private int Zh;
    private LinearLayout.LayoutParams epe;
    private LinearLayout.LayoutParams epf;
    private final b epg;
    public ViewPager.OnPageChangeListener eph;
    private LinearLayout epi;
    private ViewPager epj;
    private int epk;
    private float epl;
    private Paint epm;
    private boolean epn;
    private int epo;
    private int epp;
    private int epq;
    private int epr;
    private int eps;
    private int ept;
    private Typeface epu;
    private int epv;
    private int epw;
    private int epx;
    private int indicatorHeight;
    private int indicatorWidth;
    private int scrollOffset;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int oz(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.epg = new b();
        this.Zh = 0;
        this.epl = 0.0f;
        this.epn = false;
        this.epo = ap.getColor(R.color.cp_cont_b);
        this.epp = ap.getColor(R.color.cp_cont_j);
        this.scrollOffset = 52;
        this.indicatorHeight = 4;
        this.epq = 24;
        this.epr = 24;
        this.eps = 24;
        this.ept = 24;
        this.indicatorWidth = 40;
        this.tabTextSize = 12;
        this.epu = null;
        this.epv = 0;
        this.epw = 0;
        this.epx = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.epi = new LinearLayout(getContext());
        this.epi.setOrientation(0);
        this.epi.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.epi);
        this.epm = new Paint();
        this.epm.setAntiAlias(true);
        this.epm.setStyle(Paint.Style.FILL);
        this.epe = new LinearLayout.LayoutParams(-2, -1);
        this.epf = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.tabTextSize = i;
        this.epq = i2;
        this.epr = i3;
        this.eps = i4;
        this.ept = i5;
        this.indicatorHeight = i6;
        this.indicatorWidth = i7;
        this.epp = i8;
        this.epo = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.epj = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.epg);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eph = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.epj != null && this.epj.getAdapter() != null && this.epj.getAdapter().getCount() != 0) {
            this.epi.removeAllViews();
            this.epk = this.epj.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.epk) {
                    if (this.epj.getAdapter() instanceof a) {
                        aS(i2, ((a) this.epj.getAdapter()).oz(i2));
                    } else {
                        an(i2, this.epj.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.Zh = CommonPagerSlidingTabStrip.this.epj.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.Zh, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void an(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        d(i, textView);
    }

    private void aS(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.epj.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.epq, this.epr, this.eps, this.ept);
        this.epi.addView(view, i, this.epn ? this.epf : this.epe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.epk; i++) {
            View childAt = this.epi.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.epx);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.epu, this.epv);
                    if (i == this.epj.getCurrentItem()) {
                        textView.setTextColor(this.epo);
                    } else {
                        textView.setTextColor(this.epp);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.epk != 0) {
            int left = this.epi.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.scrollOffset;
            }
            if (left != this.epw) {
                this.epw = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.epk != 0 && this.epi.getChildCount() > 1) {
            int height = getHeight();
            this.epm.setColor(this.epo);
            View childAt = this.epi.getChildAt(this.Zh);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.epl > 0.0f && this.Zh < this.epk - 1) {
                View childAt2 = this.epi.getChildAt(this.Zh + 1);
                left = (left * (1.0f - this.epl)) + (childAt2.getLeft() * this.epl);
                right = (right * (1.0f - this.epl)) + (childAt2.getRight() * this.epl);
            }
            if (right - left < this.indicatorWidth) {
                canvas.drawRect(left, height - this.indicatorHeight, right, height, this.epm);
            } else {
                canvas.drawRect(left + (((right - left) - this.indicatorWidth) / 2.0f), height - this.indicatorHeight, right - (((right - left) - this.indicatorWidth) / 2.0f), height, this.epm);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.epo = ap.getColor(i, this.epo);
        this.epp = ap.getColor(i, this.epp);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.epi.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.Zh = i;
                CommonPagerSlidingTabStrip.this.epl = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.epi.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.eph != null) {
                    CommonPagerSlidingTabStrip.this.eph.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.epi.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.epj.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.eph != null) {
                    CommonPagerSlidingTabStrip.this.eph.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.eph != null) {
                CommonPagerSlidingTabStrip.this.eph.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Zh = savedState.Zh;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Zh = this.Zh;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: O */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: oA */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Zh;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Zh = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Zh);
        }
    }
}
