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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private int Sf;
    public ViewPager.OnPageChangeListener bWA;
    private LinearLayout bWB;
    private ViewPager bWC;
    private int bWD;
    private float bWE;
    private Paint bWF;
    private boolean bWG;
    private int bWH;
    private int bWI;
    private int bWJ;
    private int bWK;
    private int bWL;
    private int bWM;
    private int bWN;
    private int bWO;
    private int bWP;
    private int bWQ;
    private Typeface bWR;
    private int bWS;
    private int bWT;
    private int bWU;
    private LinearLayout.LayoutParams bWx;
    private LinearLayout.LayoutParams bWy;
    private final b bWz;

    /* loaded from: classes.dex */
    public interface a {
        int iu(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bWz = new b();
        this.Sf = 0;
        this.bWE = 0.0f;
        this.bWG = false;
        this.bWH = al.getColor(R.color.cp_cont_b);
        this.bWI = al.getColor(R.color.cp_cont_j);
        this.bWJ = 52;
        this.bWK = 4;
        this.bWL = 24;
        this.bWM = 24;
        this.bWN = 24;
        this.bWO = 24;
        this.bWP = 40;
        this.bWQ = 12;
        this.bWR = null;
        this.bWS = 0;
        this.bWT = 0;
        this.bWU = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bWB = new LinearLayout(getContext());
        this.bWB.setOrientation(0);
        this.bWB.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bWB);
        this.bWF = new Paint();
        this.bWF.setAntiAlias(true);
        this.bWF.setStyle(Paint.Style.FILL);
        this.bWx = new LinearLayout.LayoutParams(-2, -1);
        this.bWy = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.bWQ = i;
        this.bWL = i2;
        this.bWM = i3;
        this.bWN = i4;
        this.bWO = i5;
        this.bWK = i6;
        this.bWP = i7;
        this.bWI = i8;
        this.bWH = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.bWC = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.bWz);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bWA = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bWC != null && this.bWC.getAdapter() != null && this.bWC.getAdapter().getCount() != 0) {
            this.bWB.removeAllViews();
            this.bWD = this.bWC.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bWD) {
                    if (this.bWC.getAdapter() instanceof a) {
                        X(i2, ((a) this.bWC.getAdapter()).iu(i2));
                    } else {
                        D(i2, this.bWC.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.Sf = CommonPagerSlidingTabStrip.this.bWC.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.Sf, 0);
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

    private void X(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        e(i, imageButton);
    }

    private void e(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.bWC.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.bWL, this.bWM, this.bWN, this.bWO);
        this.bWB.addView(view, i, this.bWG ? this.bWy : this.bWx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.bWD; i++) {
            View childAt = this.bWB.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bWU);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.bWQ);
                    textView.setTypeface(this.bWR, this.bWS);
                    if (i == this.bWC.getCurrentItem()) {
                        textView.setTextColor(this.bWH);
                    } else {
                        textView.setTextColor(this.bWI);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bWD != 0) {
            int left = this.bWB.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.bWJ;
            }
            if (left != this.bWT) {
                this.bWT = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.bWD != 0 && this.bWB.getChildCount() > 1) {
            int height = getHeight();
            this.bWF.setColor(this.bWH);
            View childAt = this.bWB.getChildAt(this.Sf);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.bWE > 0.0f && this.Sf < this.bWD - 1) {
                View childAt2 = this.bWB.getChildAt(this.Sf + 1);
                left = (left * (1.0f - this.bWE)) + (childAt2.getLeft() * this.bWE);
                right = (right * (1.0f - this.bWE)) + (childAt2.getRight() * this.bWE);
            }
            if (right - left < this.bWP) {
                canvas.drawRect(left, height - this.bWK, right, height, this.bWF);
            } else {
                canvas.drawRect(left + (((right - left) - this.bWP) / 2.0f), height - this.bWK, right - (((right - left) - this.bWP) / 2.0f), height, this.bWF);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.bWH = al.getColor(i, this.bWH);
        this.bWI = al.getColor(i, this.bWI);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.bWB.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.Sf = i;
                CommonPagerSlidingTabStrip.this.bWE = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.bWB.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.bWA != null) {
                    CommonPagerSlidingTabStrip.this.bWA.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.bWB.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.bWC.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.bWA != null) {
                    CommonPagerSlidingTabStrip.this.bWA.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.bWA != null) {
                CommonPagerSlidingTabStrip.this.bWA.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Sf = savedState.Sf;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Sf = this.Sf;
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
            /* renamed from: iv */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Sf;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Sf = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Sf);
        }
    }
}
