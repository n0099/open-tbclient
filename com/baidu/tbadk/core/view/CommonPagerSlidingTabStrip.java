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
    private int ZQ;
    private LinearLayout.LayoutParams eRF;
    private LinearLayout.LayoutParams eRG;
    private final b eRH;
    public ViewPager.OnPageChangeListener eRI;
    private LinearLayout eRJ;
    private ViewPager eRK;
    private int eRL;
    private float eRM;
    private Paint eRN;
    private boolean eRO;
    private int eRP;
    private int eRQ;
    private int eRR;
    private int eRS;
    private int eRT;
    private int eRU;
    private Typeface eRV;
    private int eRW;
    private int eRX;
    private int eRY;
    private int indicatorHeight;
    private int indicatorWidth;
    private int scrollOffset;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int pF(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eRH = new b();
        this.ZQ = 0;
        this.eRM = 0.0f;
        this.eRO = false;
        this.eRP = ap.getColor(R.color.cp_cont_b);
        this.eRQ = ap.getColor(R.color.cp_cont_j);
        this.scrollOffset = 52;
        this.indicatorHeight = 4;
        this.eRR = 24;
        this.eRS = 24;
        this.eRT = 24;
        this.eRU = 24;
        this.indicatorWidth = 40;
        this.tabTextSize = 12;
        this.eRV = null;
        this.eRW = 0;
        this.eRX = 0;
        this.eRY = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.eRJ = new LinearLayout(getContext());
        this.eRJ.setOrientation(0);
        this.eRJ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.eRJ);
        this.eRN = new Paint();
        this.eRN.setAntiAlias(true);
        this.eRN.setStyle(Paint.Style.FILL);
        this.eRF = new LinearLayout.LayoutParams(-2, -1);
        this.eRG = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.tabTextSize = i;
        this.eRR = i2;
        this.eRS = i3;
        this.eRT = i4;
        this.eRU = i5;
        this.indicatorHeight = i6;
        this.indicatorWidth = i7;
        this.eRQ = i8;
        this.eRP = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eRK = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.eRH);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eRI = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.eRK != null && this.eRK.getAdapter() != null && this.eRK.getAdapter().getCount() != 0) {
            this.eRJ.removeAllViews();
            this.eRL = this.eRK.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eRL) {
                    if (this.eRK.getAdapter() instanceof a) {
                        aS(i2, ((a) this.eRK.getAdapter()).pF(i2));
                    } else {
                        aF(i2, this.eRK.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.ZQ = CommonPagerSlidingTabStrip.this.eRK.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.ZQ, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void aF(int i, String str) {
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
                CommonPagerSlidingTabStrip.this.eRK.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.eRR, this.eRS, this.eRT, this.eRU);
        this.eRJ.addView(view, i, this.eRO ? this.eRG : this.eRF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.eRL; i++) {
            View childAt = this.eRJ.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eRY);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.eRV, this.eRW);
                    if (i == this.eRK.getCurrentItem()) {
                        textView.setTextColor(this.eRP);
                    } else {
                        textView.setTextColor(this.eRQ);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eRL != 0) {
            int left = this.eRJ.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.scrollOffset;
            }
            if (left != this.eRX) {
                this.eRX = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.eRL != 0 && this.eRJ.getChildCount() > 1) {
            int height = getHeight();
            this.eRN.setColor(this.eRP);
            View childAt = this.eRJ.getChildAt(this.ZQ);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.eRM > 0.0f && this.ZQ < this.eRL - 1) {
                View childAt2 = this.eRJ.getChildAt(this.ZQ + 1);
                left = (left * (1.0f - this.eRM)) + (childAt2.getLeft() * this.eRM);
                right = (right * (1.0f - this.eRM)) + (childAt2.getRight() * this.eRM);
            }
            if (right - left < this.indicatorWidth) {
                canvas.drawRect(left, height - this.indicatorHeight, right, height, this.eRN);
            } else {
                canvas.drawRect(left + (((right - left) - this.indicatorWidth) / 2.0f), height - this.indicatorHeight, right - (((right - left) - this.indicatorWidth) / 2.0f), height, this.eRN);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.eRP = ap.getColor(i, this.eRP);
        this.eRQ = ap.getColor(i, this.eRQ);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.eRJ.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.ZQ = i;
                CommonPagerSlidingTabStrip.this.eRM = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.eRJ.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.eRI != null) {
                    CommonPagerSlidingTabStrip.this.eRI.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.eRJ.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.eRK.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.eRI != null) {
                    CommonPagerSlidingTabStrip.this.eRI.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.eRI != null) {
                CommonPagerSlidingTabStrip.this.eRI.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.ZQ = savedState.ZQ;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.ZQ = this.ZQ;
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
            /* renamed from: pG */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int ZQ;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ZQ = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ZQ);
        }
    }
}
