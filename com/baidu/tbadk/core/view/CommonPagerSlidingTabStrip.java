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
    private LinearLayout.LayoutParams aBE;
    private LinearLayout.LayoutParams aBF;
    private final b aBG;
    public ViewPager.OnPageChangeListener aBH;
    private LinearLayout aBI;
    private ViewPager aBJ;
    private int aBK;
    private int aBL;
    private float aBM;
    private Paint aBN;
    private boolean aBO;
    private int aBP;
    private int aBQ;
    private int aBR;
    private int aBS;
    private int aBT;
    private int aBU;
    private int aBV;
    private int aBW;
    private int aBX;
    private int aBY;
    private Typeface aBZ;
    private int aCa;
    private int aCb;
    private int aCc;

    /* loaded from: classes.dex */
    public interface a {
        int dB(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBG = new b();
        this.aBL = 0;
        this.aBM = 0.0f;
        this.aBO = false;
        this.aBP = al.getColor(e.d.cp_cont_b);
        this.aBQ = al.getColor(e.d.cp_cont_j);
        this.aBR = 52;
        this.aBS = 4;
        this.aBT = 24;
        this.aBU = 24;
        this.aBV = 24;
        this.aBW = 24;
        this.aBX = 40;
        this.aBY = 12;
        this.aBZ = null;
        this.aCa = 0;
        this.aCb = 0;
        this.aCc = e.f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aBI = new LinearLayout(getContext());
        this.aBI.setOrientation(0);
        this.aBI.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aBI);
        this.aBN = new Paint();
        this.aBN.setAntiAlias(true);
        this.aBN.setStyle(Paint.Style.FILL);
        this.aBE = new LinearLayout.LayoutParams(-2, -1);
        this.aBF = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.aBY = i;
        this.aBT = i2;
        this.aBU = i3;
        this.aBV = i4;
        this.aBW = i5;
        this.aBS = i6;
        this.aBX = i7;
        this.aBQ = i8;
        this.aBP = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aBJ = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.aBG);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aBH = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aBJ != null && this.aBJ.getAdapter() != null && this.aBJ.getAdapter().getCount() != 0) {
            this.aBI.removeAllViews();
            this.aBK = this.aBJ.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aBK) {
                    if (this.aBJ.getAdapter() instanceof a) {
                        A(i2, ((a) this.aBJ.getAdapter()).dB(i2));
                    } else {
                        j(i2, this.aBJ.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.aBL = CommonPagerSlidingTabStrip.this.aBJ.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.aBL, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void j(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        b(i, textView);
    }

    private void A(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        b(i, imageButton);
    }

    private void b(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.aBJ.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.aBT, this.aBU, this.aBV, this.aBW);
        this.aBI.addView(view, i, this.aBO ? this.aBF : this.aBE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aBK; i++) {
            View childAt = this.aBI.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aCc);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aBY);
                    textView.setTypeface(this.aBZ, this.aCa);
                    if (i == this.aBJ.getCurrentItem()) {
                        textView.setTextColor(this.aBP);
                    } else {
                        textView.setTextColor(this.aBQ);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aBK != 0) {
            int left = this.aBI.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aBR;
            }
            if (left != this.aCb) {
                this.aCb = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aBK != 0 && this.aBI.getChildCount() > 1) {
            int height = getHeight();
            this.aBN.setColor(this.aBP);
            View childAt = this.aBI.getChildAt(this.aBL);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.aBM > 0.0f && this.aBL < this.aBK - 1) {
                View childAt2 = this.aBI.getChildAt(this.aBL + 1);
                left = (left * (1.0f - this.aBM)) + (childAt2.getLeft() * this.aBM);
                right = (right * (1.0f - this.aBM)) + (childAt2.getRight() * this.aBM);
            }
            if (right - left < this.aBX) {
                canvas.drawRect(left, height - this.aBS, right, height, this.aBN);
            } else {
                canvas.drawRect(left + (((right - left) - this.aBX) / 2.0f), height - this.aBS, right - (((right - left) - this.aBX) / 2.0f), height, this.aBN);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aBP = al.getColor(i, this.aBP);
        this.aBQ = al.getColor(i, this.aBQ);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.aBI.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.aBL = i;
                CommonPagerSlidingTabStrip.this.aBM = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.aBI.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.aBH != null) {
                    CommonPagerSlidingTabStrip.this.aBH.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.aBI.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.aBJ.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.aBH != null) {
                    CommonPagerSlidingTabStrip.this.aBH.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.aBH != null) {
                CommonPagerSlidingTabStrip.this.aBH.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aBL = savedState.aBL;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aBL = this.aBL;
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
            /* renamed from: dC */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int aBL;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aBL = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aBL);
        }
    }
}
