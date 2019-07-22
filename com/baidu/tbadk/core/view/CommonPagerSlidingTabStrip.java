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
    private int Sw;
    private LinearLayout.LayoutParams bXA;
    private LinearLayout.LayoutParams bXB;
    private final b bXC;
    public ViewPager.OnPageChangeListener bXD;
    private LinearLayout bXE;
    private ViewPager bXF;
    private int bXG;
    private float bXH;
    private Paint bXI;
    private boolean bXJ;
    private int bXK;
    private int bXL;
    private int bXM;
    private int bXN;
    private int bXO;
    private int bXP;
    private int bXQ;
    private int bXR;
    private int bXS;
    private int bXT;
    private Typeface bXU;
    private int bXV;
    private int bXW;
    private int bXX;

    /* loaded from: classes.dex */
    public interface a {
        int iA(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bXC = new b();
        this.Sw = 0;
        this.bXH = 0.0f;
        this.bXJ = false;
        this.bXK = am.getColor(R.color.cp_cont_b);
        this.bXL = am.getColor(R.color.cp_cont_j);
        this.bXM = 52;
        this.bXN = 4;
        this.bXO = 24;
        this.bXP = 24;
        this.bXQ = 24;
        this.bXR = 24;
        this.bXS = 40;
        this.bXT = 12;
        this.bXU = null;
        this.bXV = 0;
        this.bXW = 0;
        this.bXX = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bXE = new LinearLayout(getContext());
        this.bXE.setOrientation(0);
        this.bXE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bXE);
        this.bXI = new Paint();
        this.bXI.setAntiAlias(true);
        this.bXI.setStyle(Paint.Style.FILL);
        this.bXA = new LinearLayout.LayoutParams(-2, -1);
        this.bXB = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.bXT = i;
        this.bXO = i2;
        this.bXP = i3;
        this.bXQ = i4;
        this.bXR = i5;
        this.bXN = i6;
        this.bXS = i7;
        this.bXL = i8;
        this.bXK = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.bXF = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.bXC);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bXD = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bXF != null && this.bXF.getAdapter() != null && this.bXF.getAdapter().getCount() != 0) {
            this.bXE.removeAllViews();
            this.bXG = this.bXF.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bXG) {
                    if (this.bXF.getAdapter() instanceof a) {
                        aa(i2, ((a) this.bXF.getAdapter()).iA(i2));
                    } else {
                        D(i2, this.bXF.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.Sw = CommonPagerSlidingTabStrip.this.bXF.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.Sw, 0);
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
                CommonPagerSlidingTabStrip.this.bXF.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.bXO, this.bXP, this.bXQ, this.bXR);
        this.bXE.addView(view, i, this.bXJ ? this.bXB : this.bXA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.bXG; i++) {
            View childAt = this.bXE.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bXX);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.bXT);
                    textView.setTypeface(this.bXU, this.bXV);
                    if (i == this.bXF.getCurrentItem()) {
                        textView.setTextColor(this.bXK);
                    } else {
                        textView.setTextColor(this.bXL);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bXG != 0) {
            int left = this.bXE.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.bXM;
            }
            if (left != this.bXW) {
                this.bXW = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.bXG != 0 && this.bXE.getChildCount() > 1) {
            int height = getHeight();
            this.bXI.setColor(this.bXK);
            View childAt = this.bXE.getChildAt(this.Sw);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.bXH > 0.0f && this.Sw < this.bXG - 1) {
                View childAt2 = this.bXE.getChildAt(this.Sw + 1);
                left = (left * (1.0f - this.bXH)) + (childAt2.getLeft() * this.bXH);
                right = (right * (1.0f - this.bXH)) + (childAt2.getRight() * this.bXH);
            }
            if (right - left < this.bXS) {
                canvas.drawRect(left, height - this.bXN, right, height, this.bXI);
            } else {
                canvas.drawRect(left + (((right - left) - this.bXS) / 2.0f), height - this.bXN, right - (((right - left) - this.bXS) / 2.0f), height, this.bXI);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.bXK = am.getColor(i, this.bXK);
        this.bXL = am.getColor(i, this.bXL);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.bXE.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.Sw = i;
                CommonPagerSlidingTabStrip.this.bXH = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.bXE.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.bXD != null) {
                    CommonPagerSlidingTabStrip.this.bXD.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.bXE.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.bXF.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.bXD != null) {
                    CommonPagerSlidingTabStrip.this.bXD.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.bXD != null) {
                CommonPagerSlidingTabStrip.this.bXD.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Sw = savedState.Sw;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Sw = this.Sw;
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
            /* renamed from: iB */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Sw;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Sw = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Sw);
        }
    }
}
