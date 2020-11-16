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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private int ZV;
    private LinearLayout.LayoutParams eQH;
    private LinearLayout.LayoutParams eQI;
    private final b eQJ;
    public ViewPager.OnPageChangeListener eQK;
    private LinearLayout eQL;
    private ViewPager eQM;
    private int eQN;
    private float eQO;
    private Paint eQP;
    private boolean eQQ;
    private int eQR;
    private int eQS;
    private int eQT;
    private int eQU;
    private int eQV;
    private int eQW;
    private Typeface eQX;
    private int eQY;
    private int eQZ;
    private int eRa;
    private int indicatorHeight;
    private int indicatorWidth;
    private int scrollOffset;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int qd(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eQJ = new b();
        this.ZV = 0;
        this.eQO = 0.0f;
        this.eQQ = false;
        this.eQR = ap.getColor(R.color.CAM_X0105);
        this.eQS = ap.getColor(R.color.CAM_X0107);
        this.scrollOffset = 52;
        this.indicatorHeight = 4;
        this.eQT = 24;
        this.eQU = 24;
        this.eQV = 24;
        this.eQW = 24;
        this.indicatorWidth = 40;
        this.tabTextSize = 12;
        this.eQX = null;
        this.eQY = 0;
        this.eQZ = 0;
        this.eRa = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.eQL = new LinearLayout(getContext());
        this.eQL.setOrientation(0);
        this.eQL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.eQL);
        this.eQP = new Paint();
        this.eQP.setAntiAlias(true);
        this.eQP.setStyle(Paint.Style.FILL);
        this.eQH = new LinearLayout.LayoutParams(-2, -1);
        this.eQI = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.tabTextSize = i;
        this.eQT = i2;
        this.eQU = i3;
        this.eQV = i4;
        this.eQW = i5;
        this.indicatorHeight = i6;
        this.indicatorWidth = i7;
        this.eQS = i8;
        this.eQR = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eQM = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.eQJ);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eQK = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.eQM != null && this.eQM.getAdapter() != null && this.eQM.getAdapter().getCount() != 0) {
            this.eQL.removeAllViews();
            this.eQN = this.eQM.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eQN) {
                    if (this.eQM.getAdapter() instanceof a) {
                        aS(i2, ((a) this.eQM.getAdapter()).qd(i2));
                    } else {
                        aD(i2, this.eQM.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.ZV = CommonPagerSlidingTabStrip.this.eQM.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.ZV, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void aD(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        d(i, textView);
    }

    private void aS(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.eQM.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.eQT, this.eQU, this.eQV, this.eQW);
        this.eQL.addView(view, i, this.eQQ ? this.eQI : this.eQH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.eQN; i++) {
            View childAt = this.eQL.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eRa);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.eQX, this.eQY);
                    if (i == this.eQM.getCurrentItem()) {
                        textView.setTextColor(this.eQR);
                    } else {
                        textView.setTextColor(this.eQS);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eQN != 0) {
            int left = this.eQL.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.scrollOffset;
            }
            if (left != this.eQZ) {
                this.eQZ = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.eQN != 0 && this.eQL.getChildCount() > 1) {
            int height = getHeight();
            this.eQP.setColor(this.eQR);
            View childAt = this.eQL.getChildAt(this.ZV);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.eQO > 0.0f && this.ZV < this.eQN - 1) {
                View childAt2 = this.eQL.getChildAt(this.ZV + 1);
                left = (left * (1.0f - this.eQO)) + (childAt2.getLeft() * this.eQO);
                right = (right * (1.0f - this.eQO)) + (childAt2.getRight() * this.eQO);
            }
            if (right - left < this.indicatorWidth) {
                canvas.drawRect(left, height - this.indicatorHeight, right, height, this.eQP);
            } else {
                canvas.drawRect(left + (((right - left) - this.indicatorWidth) / 2.0f), height - this.indicatorHeight, right - (((right - left) - this.indicatorWidth) / 2.0f), height, this.eQP);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.eQR = ap.getColor(i, this.eQR);
        this.eQS = ap.getColor(i, this.eQS);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.eQL.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.ZV = i;
                CommonPagerSlidingTabStrip.this.eQO = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.eQL.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.eQK != null) {
                    CommonPagerSlidingTabStrip.this.eQK.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.eQL.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.eQM.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.eQK != null) {
                    CommonPagerSlidingTabStrip.this.eQK.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.eQK != null) {
                CommonPagerSlidingTabStrip.this.eQK.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.ZV = savedState.ZV;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.ZV = this.ZV;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: O */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: qe */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int ZV;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ZV = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ZV);
        }
    }
}
