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
/* loaded from: classes2.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private int Zf;
    private LinearLayout.LayoutParams epa;
    private LinearLayout.LayoutParams epb;
    private final b epc;
    public ViewPager.OnPageChangeListener epd;
    private LinearLayout epe;
    private ViewPager epf;
    private int epg;
    private float eph;
    private Paint epi;
    private boolean epj;
    private int epk;
    private int epl;
    private int epm;
    private int epn;
    private int epo;
    private int epp;
    private Typeface epq;
    private int epr;
    private int eps;
    private int ept;
    private int indicatorHeight;
    private int indicatorWidth;
    private int scrollOffset;
    private int tabTextSize;

    /* loaded from: classes2.dex */
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
        this.epc = new b();
        this.Zf = 0;
        this.eph = 0.0f;
        this.epj = false;
        this.epk = ap.getColor(R.color.cp_cont_b);
        this.epl = ap.getColor(R.color.cp_cont_j);
        this.scrollOffset = 52;
        this.indicatorHeight = 4;
        this.epm = 24;
        this.epn = 24;
        this.epo = 24;
        this.epp = 24;
        this.indicatorWidth = 40;
        this.tabTextSize = 12;
        this.epq = null;
        this.epr = 0;
        this.eps = 0;
        this.ept = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.epe = new LinearLayout(getContext());
        this.epe.setOrientation(0);
        this.epe.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.epe);
        this.epi = new Paint();
        this.epi.setAntiAlias(true);
        this.epi.setStyle(Paint.Style.FILL);
        this.epa = new LinearLayout.LayoutParams(-2, -1);
        this.epb = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.tabTextSize = i;
        this.epm = i2;
        this.epn = i3;
        this.epo = i4;
        this.epp = i5;
        this.indicatorHeight = i6;
        this.indicatorWidth = i7;
        this.epl = i8;
        this.epk = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.epf = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.epc);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.epd = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.epf != null && this.epf.getAdapter() != null && this.epf.getAdapter().getCount() != 0) {
            this.epe.removeAllViews();
            this.epg = this.epf.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.epg) {
                    if (this.epf.getAdapter() instanceof a) {
                        aS(i2, ((a) this.epf.getAdapter()).oz(i2));
                    } else {
                        an(i2, this.epf.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.Zf = CommonPagerSlidingTabStrip.this.epf.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.Zf, 0);
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
                CommonPagerSlidingTabStrip.this.epf.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.epm, this.epn, this.epo, this.epp);
        this.epe.addView(view, i, this.epj ? this.epb : this.epa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.epg; i++) {
            View childAt = this.epe.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.ept);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.epq, this.epr);
                    if (i == this.epf.getCurrentItem()) {
                        textView.setTextColor(this.epk);
                    } else {
                        textView.setTextColor(this.epl);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.epg != 0) {
            int left = this.epe.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.scrollOffset;
            }
            if (left != this.eps) {
                this.eps = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.epg != 0 && this.epe.getChildCount() > 1) {
            int height = getHeight();
            this.epi.setColor(this.epk);
            View childAt = this.epe.getChildAt(this.Zf);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.eph > 0.0f && this.Zf < this.epg - 1) {
                View childAt2 = this.epe.getChildAt(this.Zf + 1);
                left = (left * (1.0f - this.eph)) + (childAt2.getLeft() * this.eph);
                right = (right * (1.0f - this.eph)) + (childAt2.getRight() * this.eph);
            }
            if (right - left < this.indicatorWidth) {
                canvas.drawRect(left, height - this.indicatorHeight, right, height, this.epi);
            } else {
                canvas.drawRect(left + (((right - left) - this.indicatorWidth) / 2.0f), height - this.indicatorHeight, right - (((right - left) - this.indicatorWidth) / 2.0f), height, this.epi);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.epk = ap.getColor(i, this.epk);
        this.epl = ap.getColor(i, this.epl);
        updateTabStyles();
    }

    /* loaded from: classes2.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.epe.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.Zf = i;
                CommonPagerSlidingTabStrip.this.eph = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.epe.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.epd != null) {
                    CommonPagerSlidingTabStrip.this.epd.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.epe.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.epf.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.epd != null) {
                    CommonPagerSlidingTabStrip.this.epd.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.epd != null) {
                CommonPagerSlidingTabStrip.this.epd.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Zf = savedState.Zf;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Zf = this.Zf;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
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
        int Zf;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Zf = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Zf);
        }
    }
}
