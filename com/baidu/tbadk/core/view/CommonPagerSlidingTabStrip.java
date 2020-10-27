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
    private int ZQ;
    private LinearLayout.LayoutParams eLQ;
    private LinearLayout.LayoutParams eLR;
    private final b eLS;
    public ViewPager.OnPageChangeListener eLT;
    private LinearLayout eLU;
    private ViewPager eLV;
    private int eLW;
    private float eLX;
    private Paint eLY;
    private boolean eLZ;
    private int eMa;
    private int eMb;
    private int eMc;
    private int eMd;
    private int eMe;
    private int eMf;
    private Typeface eMg;
    private int eMh;
    private int eMi;
    private int eMj;
    private int indicatorHeight;
    private int indicatorWidth;
    private int scrollOffset;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int pv(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eLS = new b();
        this.ZQ = 0;
        this.eLX = 0.0f;
        this.eLZ = false;
        this.eMa = ap.getColor(R.color.cp_cont_b);
        this.eMb = ap.getColor(R.color.cp_cont_j);
        this.scrollOffset = 52;
        this.indicatorHeight = 4;
        this.eMc = 24;
        this.eMd = 24;
        this.eMe = 24;
        this.eMf = 24;
        this.indicatorWidth = 40;
        this.tabTextSize = 12;
        this.eMg = null;
        this.eMh = 0;
        this.eMi = 0;
        this.eMj = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.eLU = new LinearLayout(getContext());
        this.eLU.setOrientation(0);
        this.eLU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.eLU);
        this.eLY = new Paint();
        this.eLY.setAntiAlias(true);
        this.eLY.setStyle(Paint.Style.FILL);
        this.eLQ = new LinearLayout.LayoutParams(-2, -1);
        this.eLR = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.tabTextSize = i;
        this.eMc = i2;
        this.eMd = i3;
        this.eMe = i4;
        this.eMf = i5;
        this.indicatorHeight = i6;
        this.indicatorWidth = i7;
        this.eMb = i8;
        this.eMa = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eLV = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.eLS);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eLT = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.eLV != null && this.eLV.getAdapter() != null && this.eLV.getAdapter().getCount() != 0) {
            this.eLU.removeAllViews();
            this.eLW = this.eLV.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eLW) {
                    if (this.eLV.getAdapter() instanceof a) {
                        aS(i2, ((a) this.eLV.getAdapter()).pv(i2));
                    } else {
                        aB(i2, this.eLV.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.ZQ = CommonPagerSlidingTabStrip.this.eLV.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.ZQ, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void aB(int i, String str) {
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
                CommonPagerSlidingTabStrip.this.eLV.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.eMc, this.eMd, this.eMe, this.eMf);
        this.eLU.addView(view, i, this.eLZ ? this.eLR : this.eLQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.eLW; i++) {
            View childAt = this.eLU.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eMj);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.eMg, this.eMh);
                    if (i == this.eLV.getCurrentItem()) {
                        textView.setTextColor(this.eMa);
                    } else {
                        textView.setTextColor(this.eMb);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eLW != 0) {
            int left = this.eLU.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.scrollOffset;
            }
            if (left != this.eMi) {
                this.eMi = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.eLW != 0 && this.eLU.getChildCount() > 1) {
            int height = getHeight();
            this.eLY.setColor(this.eMa);
            View childAt = this.eLU.getChildAt(this.ZQ);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.eLX > 0.0f && this.ZQ < this.eLW - 1) {
                View childAt2 = this.eLU.getChildAt(this.ZQ + 1);
                left = (left * (1.0f - this.eLX)) + (childAt2.getLeft() * this.eLX);
                right = (right * (1.0f - this.eLX)) + (childAt2.getRight() * this.eLX);
            }
            if (right - left < this.indicatorWidth) {
                canvas.drawRect(left, height - this.indicatorHeight, right, height, this.eLY);
            } else {
                canvas.drawRect(left + (((right - left) - this.indicatorWidth) / 2.0f), height - this.indicatorHeight, right - (((right - left) - this.indicatorWidth) / 2.0f), height, this.eLY);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.eMa = ap.getColor(i, this.eMa);
        this.eMb = ap.getColor(i, this.eMb);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.eLU.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.ZQ = i;
                CommonPagerSlidingTabStrip.this.eLX = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.eLU.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.eLT != null) {
                    CommonPagerSlidingTabStrip.this.eLT.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.eLU.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.eLV.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.eLT != null) {
                    CommonPagerSlidingTabStrip.this.eLT.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.eLT != null) {
                CommonPagerSlidingTabStrip.this.eLT.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.ZQ = savedState.ZQ;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.ZQ = this.ZQ;
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
            /* renamed from: pw */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int ZQ;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ZQ = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ZQ);
        }
    }
}
