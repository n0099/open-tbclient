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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private int Yz;
    private int edx;
    private LinearLayout.LayoutParams efA;
    private LinearLayout.LayoutParams efB;
    private final b efC;
    public ViewPager.OnPageChangeListener efD;
    private LinearLayout efE;
    private ViewPager efF;
    private int efG;
    private float efH;
    private Paint efI;
    private boolean efJ;
    private int efK;
    private int efL;
    private int efM;
    private int efN;
    private int efO;
    private Typeface efP;
    private int efQ;
    private int efR;
    private int efS;
    private int indicatorHeight;
    private int indicatorWidth;
    private int scrollOffset;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int mu(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.efC = new b();
        this.Yz = 0;
        this.efH = 0.0f;
        this.efJ = false;
        this.efK = ao.getColor(R.color.cp_cont_b);
        this.edx = ao.getColor(R.color.cp_cont_j);
        this.scrollOffset = 52;
        this.indicatorHeight = 4;
        this.efL = 24;
        this.efM = 24;
        this.efN = 24;
        this.efO = 24;
        this.indicatorWidth = 40;
        this.tabTextSize = 12;
        this.efP = null;
        this.efQ = 0;
        this.efR = 0;
        this.efS = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.efE = new LinearLayout(getContext());
        this.efE.setOrientation(0);
        this.efE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.efE);
        this.efI = new Paint();
        this.efI.setAntiAlias(true);
        this.efI.setStyle(Paint.Style.FILL);
        this.efA = new LinearLayout.LayoutParams(-2, -1);
        this.efB = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.tabTextSize = i;
        this.efL = i2;
        this.efM = i3;
        this.efN = i4;
        this.efO = i5;
        this.indicatorHeight = i6;
        this.indicatorWidth = i7;
        this.edx = i8;
        this.efK = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.efF = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.efC);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.efD = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.efF != null && this.efF.getAdapter() != null && this.efF.getAdapter().getCount() != 0) {
            this.efE.removeAllViews();
            this.efG = this.efF.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.efG) {
                    if (this.efF.getAdapter() instanceof a) {
                        aK(i2, ((a) this.efF.getAdapter()).mu(i2));
                    } else {
                        ap(i2, this.efF.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.Yz = CommonPagerSlidingTabStrip.this.efF.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.Yz, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void ap(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        d(i, textView);
    }

    private void aK(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.efF.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.efL, this.efM, this.efN, this.efO);
        this.efE.addView(view, i, this.efJ ? this.efB : this.efA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.efG; i++) {
            View childAt = this.efE.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.efS);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.efP, this.efQ);
                    if (i == this.efF.getCurrentItem()) {
                        textView.setTextColor(this.efK);
                    } else {
                        textView.setTextColor(this.edx);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.efG != 0) {
            int left = this.efE.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.scrollOffset;
            }
            if (left != this.efR) {
                this.efR = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.efG != 0 && this.efE.getChildCount() > 1) {
            int height = getHeight();
            this.efI.setColor(this.efK);
            View childAt = this.efE.getChildAt(this.Yz);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.efH > 0.0f && this.Yz < this.efG - 1) {
                View childAt2 = this.efE.getChildAt(this.Yz + 1);
                left = (left * (1.0f - this.efH)) + (childAt2.getLeft() * this.efH);
                right = (right * (1.0f - this.efH)) + (childAt2.getRight() * this.efH);
            }
            if (right - left < this.indicatorWidth) {
                canvas.drawRect(left, height - this.indicatorHeight, right, height, this.efI);
            } else {
                canvas.drawRect(left + (((right - left) - this.indicatorWidth) / 2.0f), height - this.indicatorHeight, right - (((right - left) - this.indicatorWidth) / 2.0f), height, this.efI);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.efK = ao.getColor(i, this.efK);
        this.edx = ao.getColor(i, this.edx);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.efE.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.Yz = i;
                CommonPagerSlidingTabStrip.this.efH = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.efE.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.efD != null) {
                    CommonPagerSlidingTabStrip.this.efD.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.efE.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.efF.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.efD != null) {
                    CommonPagerSlidingTabStrip.this.efD.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.efD != null) {
                CommonPagerSlidingTabStrip.this.efD.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Yz = savedState.Yz;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Yz = this.Yz;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: N */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: mv */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Yz;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Yz = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Yz);
        }
    }
}
