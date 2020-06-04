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
    private int Yf;
    private int dQl;
    private ViewPager dSA;
    private int dSB;
    private float dSC;
    private Paint dSD;
    private boolean dSE;
    private int dSF;
    private int dSG;
    private int dSH;
    private int dSI;
    private int dSJ;
    private int dSK;
    private int dSL;
    private Typeface dSM;
    private int dSN;
    private int dSO;
    private int dSP;
    private LinearLayout.LayoutParams dSv;
    private LinearLayout.LayoutParams dSw;
    private final b dSx;
    public ViewPager.OnPageChangeListener dSy;
    private LinearLayout dSz;
    private int indicatorHeight;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int lK(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dSx = new b();
        this.Yf = 0;
        this.dSC = 0.0f;
        this.dSE = false;
        this.dSF = am.getColor(R.color.cp_cont_b);
        this.dQl = am.getColor(R.color.cp_cont_j);
        this.dSG = 52;
        this.indicatorHeight = 4;
        this.dSH = 24;
        this.dSI = 24;
        this.dSJ = 24;
        this.dSK = 24;
        this.dSL = 40;
        this.tabTextSize = 12;
        this.dSM = null;
        this.dSN = 0;
        this.dSO = 0;
        this.dSP = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dSz = new LinearLayout(getContext());
        this.dSz.setOrientation(0);
        this.dSz.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dSz);
        this.dSD = new Paint();
        this.dSD.setAntiAlias(true);
        this.dSD.setStyle(Paint.Style.FILL);
        this.dSv = new LinearLayout.LayoutParams(-2, -1);
        this.dSw = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.tabTextSize = i;
        this.dSH = i2;
        this.dSI = i3;
        this.dSJ = i4;
        this.dSK = i5;
        this.indicatorHeight = i6;
        this.dSL = i7;
        this.dQl = i8;
        this.dSF = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dSA = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dSx);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dSy = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dSA != null && this.dSA.getAdapter() != null && this.dSA.getAdapter().getCount() != 0) {
            this.dSz.removeAllViews();
            this.dSB = this.dSA.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.dSB) {
                    if (this.dSA.getAdapter() instanceof a) {
                        aG(i2, ((a) this.dSA.getAdapter()).lK(i2));
                    } else {
                        an(i2, this.dSA.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.Yf = CommonPagerSlidingTabStrip.this.dSA.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.Yf, 0);
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

    private void aG(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.dSA.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.dSH, this.dSI, this.dSJ, this.dSK);
        this.dSz.addView(view, i, this.dSE ? this.dSw : this.dSv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.dSB; i++) {
            View childAt = this.dSz.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dSP);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.dSM, this.dSN);
                    if (i == this.dSA.getCurrentItem()) {
                        textView.setTextColor(this.dSF);
                    } else {
                        textView.setTextColor(this.dQl);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dSB != 0) {
            int left = this.dSz.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dSG;
            }
            if (left != this.dSO) {
                this.dSO = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.dSB != 0 && this.dSz.getChildCount() > 1) {
            int height = getHeight();
            this.dSD.setColor(this.dSF);
            View childAt = this.dSz.getChildAt(this.Yf);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.dSC > 0.0f && this.Yf < this.dSB - 1) {
                View childAt2 = this.dSz.getChildAt(this.Yf + 1);
                left = (left * (1.0f - this.dSC)) + (childAt2.getLeft() * this.dSC);
                right = (right * (1.0f - this.dSC)) + (childAt2.getRight() * this.dSC);
            }
            if (right - left < this.dSL) {
                canvas.drawRect(left, height - this.indicatorHeight, right, height, this.dSD);
            } else {
                canvas.drawRect(left + (((right - left) - this.dSL) / 2.0f), height - this.indicatorHeight, right - (((right - left) - this.dSL) / 2.0f), height, this.dSD);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.dSF = am.getColor(i, this.dSF);
        this.dQl = am.getColor(i, this.dQl);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.dSz.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.Yf = i;
                CommonPagerSlidingTabStrip.this.dSC = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.dSz.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.dSy != null) {
                    CommonPagerSlidingTabStrip.this.dSy.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.dSz.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.dSA.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.dSy != null) {
                    CommonPagerSlidingTabStrip.this.dSy.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.dSy != null) {
                CommonPagerSlidingTabStrip.this.dSy.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Yf = savedState.Yf;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Yf = this.Yf;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: L */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: lL */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Yf;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Yf = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Yf);
        }
    }
}
