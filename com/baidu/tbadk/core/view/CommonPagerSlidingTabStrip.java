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
    private int Se;
    private final b bWA;
    public ViewPager.OnPageChangeListener bWB;
    private LinearLayout bWC;
    private ViewPager bWD;
    private int bWE;
    private float bWF;
    private Paint bWG;
    private boolean bWH;
    private int bWI;
    private int bWJ;
    private int bWK;
    private int bWL;
    private int bWM;
    private int bWN;
    private int bWO;
    private int bWP;
    private int bWQ;
    private int bWR;
    private Typeface bWS;
    private int bWT;
    private int bWU;
    private int bWV;
    private LinearLayout.LayoutParams bWy;
    private LinearLayout.LayoutParams bWz;

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
        this.bWA = new b();
        this.Se = 0;
        this.bWF = 0.0f;
        this.bWH = false;
        this.bWI = al.getColor(R.color.cp_cont_b);
        this.bWJ = al.getColor(R.color.cp_cont_j);
        this.bWK = 52;
        this.bWL = 4;
        this.bWM = 24;
        this.bWN = 24;
        this.bWO = 24;
        this.bWP = 24;
        this.bWQ = 40;
        this.bWR = 12;
        this.bWS = null;
        this.bWT = 0;
        this.bWU = 0;
        this.bWV = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bWC = new LinearLayout(getContext());
        this.bWC.setOrientation(0);
        this.bWC.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bWC);
        this.bWG = new Paint();
        this.bWG.setAntiAlias(true);
        this.bWG.setStyle(Paint.Style.FILL);
        this.bWy = new LinearLayout.LayoutParams(-2, -1);
        this.bWz = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.bWR = i;
        this.bWM = i2;
        this.bWN = i3;
        this.bWO = i4;
        this.bWP = i5;
        this.bWL = i6;
        this.bWQ = i7;
        this.bWJ = i8;
        this.bWI = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.bWD = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.bWA);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bWB = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bWD != null && this.bWD.getAdapter() != null && this.bWD.getAdapter().getCount() != 0) {
            this.bWC.removeAllViews();
            this.bWE = this.bWD.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bWE) {
                    if (this.bWD.getAdapter() instanceof a) {
                        X(i2, ((a) this.bWD.getAdapter()).iu(i2));
                    } else {
                        D(i2, this.bWD.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.Se = CommonPagerSlidingTabStrip.this.bWD.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.Se, 0);
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
                CommonPagerSlidingTabStrip.this.bWD.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.bWM, this.bWN, this.bWO, this.bWP);
        this.bWC.addView(view, i, this.bWH ? this.bWz : this.bWy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.bWE; i++) {
            View childAt = this.bWC.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bWV);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.bWR);
                    textView.setTypeface(this.bWS, this.bWT);
                    if (i == this.bWD.getCurrentItem()) {
                        textView.setTextColor(this.bWI);
                    } else {
                        textView.setTextColor(this.bWJ);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bWE != 0) {
            int left = this.bWC.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.bWK;
            }
            if (left != this.bWU) {
                this.bWU = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.bWE != 0 && this.bWC.getChildCount() > 1) {
            int height = getHeight();
            this.bWG.setColor(this.bWI);
            View childAt = this.bWC.getChildAt(this.Se);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.bWF > 0.0f && this.Se < this.bWE - 1) {
                View childAt2 = this.bWC.getChildAt(this.Se + 1);
                left = (left * (1.0f - this.bWF)) + (childAt2.getLeft() * this.bWF);
                right = (right * (1.0f - this.bWF)) + (childAt2.getRight() * this.bWF);
            }
            if (right - left < this.bWQ) {
                canvas.drawRect(left, height - this.bWL, right, height, this.bWG);
            } else {
                canvas.drawRect(left + (((right - left) - this.bWQ) / 2.0f), height - this.bWL, right - (((right - left) - this.bWQ) / 2.0f), height, this.bWG);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.bWI = al.getColor(i, this.bWI);
        this.bWJ = al.getColor(i, this.bWJ);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.bWC.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.Se = i;
                CommonPagerSlidingTabStrip.this.bWF = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.bWC.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.bWB != null) {
                    CommonPagerSlidingTabStrip.this.bWB.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.bWC.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.bWD.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.bWB != null) {
                    CommonPagerSlidingTabStrip.this.bWB.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.bWB != null) {
                CommonPagerSlidingTabStrip.this.bWB.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Se = savedState.Se;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Se = this.Se;
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
        int Se;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Se = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Se);
        }
    }
}
