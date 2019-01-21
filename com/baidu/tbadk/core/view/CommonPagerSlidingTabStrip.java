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
    public ViewPager.OnPageChangeListener aGA;
    private LinearLayout aGB;
    private ViewPager aGC;
    private int aGD;
    private int aGE;
    private float aGF;
    private Paint aGG;
    private boolean aGH;
    private int aGI;
    private int aGJ;
    private int aGK;
    private int aGL;
    private int aGM;
    private int aGN;
    private int aGO;
    private int aGP;
    private int aGQ;
    private int aGR;
    private Typeface aGS;
    private int aGT;
    private int aGU;
    private int aGV;
    private LinearLayout.LayoutParams aGx;
    private LinearLayout.LayoutParams aGy;
    private final b aGz;

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
        this.aGz = new b();
        this.aGE = 0;
        this.aGF = 0.0f;
        this.aGH = false;
        this.aGI = al.getColor(e.d.cp_cont_b);
        this.aGJ = al.getColor(e.d.cp_cont_j);
        this.aGK = 52;
        this.aGL = 4;
        this.aGM = 24;
        this.aGN = 24;
        this.aGO = 24;
        this.aGP = 24;
        this.aGQ = 40;
        this.aGR = 12;
        this.aGS = null;
        this.aGT = 0;
        this.aGU = 0;
        this.aGV = e.f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aGB = new LinearLayout(getContext());
        this.aGB.setOrientation(0);
        this.aGB.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aGB);
        this.aGG = new Paint();
        this.aGG.setAntiAlias(true);
        this.aGG.setStyle(Paint.Style.FILL);
        this.aGx = new LinearLayout.LayoutParams(-2, -1);
        this.aGy = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.aGR = i;
        this.aGM = i2;
        this.aGN = i3;
        this.aGO = i4;
        this.aGP = i5;
        this.aGL = i6;
        this.aGQ = i7;
        this.aGJ = i8;
        this.aGI = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aGC = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.aGz);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aGA = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aGC != null && this.aGC.getAdapter() != null && this.aGC.getAdapter().getCount() != 0) {
            this.aGB.removeAllViews();
            this.aGD = this.aGC.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aGD) {
                    if (this.aGC.getAdapter() instanceof a) {
                        B(i2, ((a) this.aGC.getAdapter()).ed(i2));
                    } else {
                        k(i2, this.aGC.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.aGE = CommonPagerSlidingTabStrip.this.aGC.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.aGE, 0);
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
                CommonPagerSlidingTabStrip.this.aGC.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.aGM, this.aGN, this.aGO, this.aGP);
        this.aGB.addView(view, i, this.aGH ? this.aGy : this.aGx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aGD; i++) {
            View childAt = this.aGB.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aGV);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aGR);
                    textView.setTypeface(this.aGS, this.aGT);
                    if (i == this.aGC.getCurrentItem()) {
                        textView.setTextColor(this.aGI);
                    } else {
                        textView.setTextColor(this.aGJ);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aGD != 0) {
            int left = this.aGB.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aGK;
            }
            if (left != this.aGU) {
                this.aGU = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aGD != 0 && this.aGB.getChildCount() > 1) {
            int height = getHeight();
            this.aGG.setColor(this.aGI);
            View childAt = this.aGB.getChildAt(this.aGE);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.aGF > 0.0f && this.aGE < this.aGD - 1) {
                View childAt2 = this.aGB.getChildAt(this.aGE + 1);
                left = (left * (1.0f - this.aGF)) + (childAt2.getLeft() * this.aGF);
                right = (right * (1.0f - this.aGF)) + (childAt2.getRight() * this.aGF);
            }
            if (right - left < this.aGQ) {
                canvas.drawRect(left, height - this.aGL, right, height, this.aGG);
            } else {
                canvas.drawRect(left + (((right - left) - this.aGQ) / 2.0f), height - this.aGL, right - (((right - left) - this.aGQ) / 2.0f), height, this.aGG);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aGI = al.getColor(i, this.aGI);
        this.aGJ = al.getColor(i, this.aGJ);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.aGB.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.aGE = i;
                CommonPagerSlidingTabStrip.this.aGF = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.aGB.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.aGA != null) {
                    CommonPagerSlidingTabStrip.this.aGA.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.aGB.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.aGC.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.aGA != null) {
                    CommonPagerSlidingTabStrip.this.aGA.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.aGA != null) {
                CommonPagerSlidingTabStrip.this.aGA.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aGE = savedState.aGE;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aGE = this.aGE;
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
        int aGE;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aGE = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aGE);
        }
    }
}
