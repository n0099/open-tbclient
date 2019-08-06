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
    private LinearLayout.LayoutParams bXG;
    private LinearLayout.LayoutParams bXH;
    private final b bXI;
    public ViewPager.OnPageChangeListener bXJ;
    private LinearLayout bXK;
    private ViewPager bXL;
    private int bXM;
    private float bXN;
    private Paint bXO;
    private boolean bXP;
    private int bXQ;
    private int bXR;
    private int bXS;
    private int bXT;
    private int bXU;
    private int bXV;
    private int bXW;
    private int bXX;
    private int bXY;
    private int bXZ;
    private Typeface bYa;
    private int bYb;
    private int bYc;
    private int bYd;

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
        this.bXI = new b();
        this.Sw = 0;
        this.bXN = 0.0f;
        this.bXP = false;
        this.bXQ = am.getColor(R.color.cp_cont_b);
        this.bXR = am.getColor(R.color.cp_cont_j);
        this.bXS = 52;
        this.bXT = 4;
        this.bXU = 24;
        this.bXV = 24;
        this.bXW = 24;
        this.bXX = 24;
        this.bXY = 40;
        this.bXZ = 12;
        this.bYa = null;
        this.bYb = 0;
        this.bYc = 0;
        this.bYd = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bXK = new LinearLayout(getContext());
        this.bXK.setOrientation(0);
        this.bXK.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bXK);
        this.bXO = new Paint();
        this.bXO.setAntiAlias(true);
        this.bXO.setStyle(Paint.Style.FILL);
        this.bXG = new LinearLayout.LayoutParams(-2, -1);
        this.bXH = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.bXZ = i;
        this.bXU = i2;
        this.bXV = i3;
        this.bXW = i4;
        this.bXX = i5;
        this.bXT = i6;
        this.bXY = i7;
        this.bXR = i8;
        this.bXQ = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.bXL = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.bXI);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bXJ = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bXL != null && this.bXL.getAdapter() != null && this.bXL.getAdapter().getCount() != 0) {
            this.bXK.removeAllViews();
            this.bXM = this.bXL.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bXM) {
                    if (this.bXL.getAdapter() instanceof a) {
                        aa(i2, ((a) this.bXL.getAdapter()).iA(i2));
                    } else {
                        D(i2, this.bXL.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.Sw = CommonPagerSlidingTabStrip.this.bXL.getCurrentItem();
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
                CommonPagerSlidingTabStrip.this.bXL.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.bXU, this.bXV, this.bXW, this.bXX);
        this.bXK.addView(view, i, this.bXP ? this.bXH : this.bXG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.bXM; i++) {
            View childAt = this.bXK.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bYd);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.bXZ);
                    textView.setTypeface(this.bYa, this.bYb);
                    if (i == this.bXL.getCurrentItem()) {
                        textView.setTextColor(this.bXQ);
                    } else {
                        textView.setTextColor(this.bXR);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bXM != 0) {
            int left = this.bXK.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.bXS;
            }
            if (left != this.bYc) {
                this.bYc = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.bXM != 0 && this.bXK.getChildCount() > 1) {
            int height = getHeight();
            this.bXO.setColor(this.bXQ);
            View childAt = this.bXK.getChildAt(this.Sw);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.bXN > 0.0f && this.Sw < this.bXM - 1) {
                View childAt2 = this.bXK.getChildAt(this.Sw + 1);
                left = (left * (1.0f - this.bXN)) + (childAt2.getLeft() * this.bXN);
                right = (right * (1.0f - this.bXN)) + (childAt2.getRight() * this.bXN);
            }
            if (right - left < this.bXY) {
                canvas.drawRect(left, height - this.bXT, right, height, this.bXO);
            } else {
                canvas.drawRect(left + (((right - left) - this.bXY) / 2.0f), height - this.bXT, right - (((right - left) - this.bXY) / 2.0f), height, this.bXO);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.bXQ = am.getColor(i, this.bXQ);
        this.bXR = am.getColor(i, this.bXR);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.bXK.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.Sw = i;
                CommonPagerSlidingTabStrip.this.bXN = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.bXK.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.bXJ != null) {
                    CommonPagerSlidingTabStrip.this.bXJ.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.bXK.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.bXL.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.bXJ != null) {
                    CommonPagerSlidingTabStrip.this.bXJ.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.bXJ != null) {
                CommonPagerSlidingTabStrip.this.bXJ.onPageSelected(i);
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
