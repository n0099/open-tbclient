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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private LinearLayout aGA;
    private ViewPager aGB;
    private int aGC;
    private int aGD;
    private float aGE;
    private Paint aGF;
    private boolean aGG;
    private int aGH;
    private int aGI;
    private int aGJ;
    private int aGK;
    private int aGL;
    private int aGM;
    private int aGN;
    private int aGO;
    private int aGP;
    private int aGQ;
    private Typeface aGR;
    private int aGS;
    private int aGT;
    private int aGU;
    private LinearLayout.LayoutParams aGw;
    private LinearLayout.LayoutParams aGx;
    private final b aGy;
    public ViewPager.OnPageChangeListener aGz;

    /* loaded from: classes.dex */
    public interface a {
        int ed(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGy = new b();
        this.aGD = 0;
        this.aGE = 0.0f;
        this.aGG = false;
        this.aGH = al.getColor(e.d.cp_cont_b);
        this.aGI = al.getColor(e.d.cp_cont_j);
        this.aGJ = 52;
        this.aGK = 4;
        this.aGL = 24;
        this.aGM = 24;
        this.aGN = 24;
        this.aGO = 24;
        this.aGP = 40;
        this.aGQ = 12;
        this.aGR = null;
        this.aGS = 0;
        this.aGT = 0;
        this.aGU = e.f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aGA = new LinearLayout(getContext());
        this.aGA.setOrientation(0);
        this.aGA.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aGA);
        this.aGF = new Paint();
        this.aGF.setAntiAlias(true);
        this.aGF.setStyle(Paint.Style.FILL);
        this.aGw = new LinearLayout.LayoutParams(-2, -1);
        this.aGx = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.aGQ = i;
        this.aGL = i2;
        this.aGM = i3;
        this.aGN = i4;
        this.aGO = i5;
        this.aGK = i6;
        this.aGP = i7;
        this.aGI = i8;
        this.aGH = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aGB = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.aGy);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aGz = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aGB != null && this.aGB.getAdapter() != null && this.aGB.getAdapter().getCount() != 0) {
            this.aGA.removeAllViews();
            this.aGC = this.aGB.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aGC) {
                    if (this.aGB.getAdapter() instanceof a) {
                        B(i2, ((a) this.aGB.getAdapter()).ed(i2));
                    } else {
                        k(i2, this.aGB.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.aGD = CommonPagerSlidingTabStrip.this.aGB.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.aGD, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void k(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        b(i, textView);
    }

    private void B(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        b(i, imageButton);
    }

    private void b(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.aGB.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.aGL, this.aGM, this.aGN, this.aGO);
        this.aGA.addView(view, i, this.aGG ? this.aGx : this.aGw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aGC; i++) {
            View childAt = this.aGA.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aGU);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aGQ);
                    textView.setTypeface(this.aGR, this.aGS);
                    if (i == this.aGB.getCurrentItem()) {
                        textView.setTextColor(this.aGH);
                    } else {
                        textView.setTextColor(this.aGI);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aGC != 0) {
            int left = this.aGA.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aGJ;
            }
            if (left != this.aGT) {
                this.aGT = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aGC != 0 && this.aGA.getChildCount() > 1) {
            int height = getHeight();
            this.aGF.setColor(this.aGH);
            View childAt = this.aGA.getChildAt(this.aGD);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.aGE > 0.0f && this.aGD < this.aGC - 1) {
                View childAt2 = this.aGA.getChildAt(this.aGD + 1);
                left = (left * (1.0f - this.aGE)) + (childAt2.getLeft() * this.aGE);
                right = (right * (1.0f - this.aGE)) + (childAt2.getRight() * this.aGE);
            }
            if (right - left < this.aGP) {
                canvas.drawRect(left, height - this.aGK, right, height, this.aGF);
            } else {
                canvas.drawRect(left + (((right - left) - this.aGP) / 2.0f), height - this.aGK, right - (((right - left) - this.aGP) / 2.0f), height, this.aGF);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aGH = al.getColor(i, this.aGH);
        this.aGI = al.getColor(i, this.aGI);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.aGA.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.aGD = i;
                CommonPagerSlidingTabStrip.this.aGE = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.aGA.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.aGz != null) {
                    CommonPagerSlidingTabStrip.this.aGz.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.aGA.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.aGB.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.aGz != null) {
                    CommonPagerSlidingTabStrip.this.aGz.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.aGz != null) {
                CommonPagerSlidingTabStrip.this.aGz.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aGD = savedState.aGD;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aGD = this.aGD;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: h */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ee */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int aGD;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aGD = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aGD);
        }
    }
}
