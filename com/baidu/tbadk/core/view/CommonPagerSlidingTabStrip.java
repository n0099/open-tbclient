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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private int Sv;
    private LinearLayout.LayoutParams bYA;
    private final b bYB;
    public ViewPager.OnPageChangeListener bYC;
    private LinearLayout bYD;
    private ViewPager bYE;
    private int bYF;
    private float bYG;
    private Paint bYH;
    private boolean bYI;
    private int bYJ;
    private int bYK;
    private int bYL;
    private int bYM;
    private int bYN;
    private int bYO;
    private int bYP;
    private int bYQ;
    private int bYR;
    private int bYS;
    private Typeface bYT;
    private int bYU;
    private int bYV;
    private int bYW;
    private LinearLayout.LayoutParams bYz;

    /* loaded from: classes.dex */
    public interface a {
        int iD(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bYB = new b();
        this.Sv = 0;
        this.bYG = 0.0f;
        this.bYI = false;
        this.bYJ = am.getColor(R.color.cp_cont_b);
        this.bYK = am.getColor(R.color.cp_cont_j);
        this.bYL = 52;
        this.bYM = 4;
        this.bYN = 24;
        this.bYO = 24;
        this.bYP = 24;
        this.bYQ = 24;
        this.bYR = 40;
        this.bYS = 12;
        this.bYT = null;
        this.bYU = 0;
        this.bYV = 0;
        this.bYW = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bYD = new LinearLayout(getContext());
        this.bYD.setOrientation(0);
        this.bYD.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bYD);
        this.bYH = new Paint();
        this.bYH.setAntiAlias(true);
        this.bYH.setStyle(Paint.Style.FILL);
        this.bYz = new LinearLayout.LayoutParams(-2, -1);
        this.bYA = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.bYS = i;
        this.bYN = i2;
        this.bYO = i3;
        this.bYP = i4;
        this.bYQ = i5;
        this.bYM = i6;
        this.bYR = i7;
        this.bYK = i8;
        this.bYJ = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.bYE = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.bYB);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bYC = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bYE != null && this.bYE.getAdapter() != null && this.bYE.getAdapter().getCount() != 0) {
            this.bYD.removeAllViews();
            this.bYF = this.bYE.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bYF) {
                    if (this.bYE.getAdapter() instanceof a) {
                        aa(i2, ((a) this.bYE.getAdapter()).iD(i2));
                    } else {
                        D(i2, this.bYE.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.Sv = CommonPagerSlidingTabStrip.this.bYE.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.Sv, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void D(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        e(i, textView);
    }

    private void aa(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        e(i, imageButton);
    }

    private void e(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.bYE.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.bYN, this.bYO, this.bYP, this.bYQ);
        this.bYD.addView(view, i, this.bYI ? this.bYA : this.bYz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.bYF; i++) {
            View childAt = this.bYD.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bYW);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.bYS);
                    textView.setTypeface(this.bYT, this.bYU);
                    if (i == this.bYE.getCurrentItem()) {
                        textView.setTextColor(this.bYJ);
                    } else {
                        textView.setTextColor(this.bYK);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bYF != 0) {
            int left = this.bYD.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.bYL;
            }
            if (left != this.bYV) {
                this.bYV = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.bYF != 0 && this.bYD.getChildCount() > 1) {
            int height = getHeight();
            this.bYH.setColor(this.bYJ);
            View childAt = this.bYD.getChildAt(this.Sv);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.bYG > 0.0f && this.Sv < this.bYF - 1) {
                View childAt2 = this.bYD.getChildAt(this.Sv + 1);
                left = (left * (1.0f - this.bYG)) + (childAt2.getLeft() * this.bYG);
                right = (right * (1.0f - this.bYG)) + (childAt2.getRight() * this.bYG);
            }
            if (right - left < this.bYR) {
                canvas.drawRect(left, height - this.bYM, right, height, this.bYH);
            } else {
                canvas.drawRect(left + (((right - left) - this.bYR) / 2.0f), height - this.bYM, right - (((right - left) - this.bYR) / 2.0f), height, this.bYH);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.bYJ = am.getColor(i, this.bYJ);
        this.bYK = am.getColor(i, this.bYK);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.bYD.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.Sv = i;
                CommonPagerSlidingTabStrip.this.bYG = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.bYD.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.bYC != null) {
                    CommonPagerSlidingTabStrip.this.bYC.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.bYD.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.bYE.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.bYC != null) {
                    CommonPagerSlidingTabStrip.this.bYC.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.bYC != null) {
                CommonPagerSlidingTabStrip.this.bYC.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Sv = savedState.Sv;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Sv = this.Sv;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: A */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: iE */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Sv;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Sv = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Sv);
        }
    }
}
