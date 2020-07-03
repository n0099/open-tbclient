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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private int YJ;
    private int dXd;
    private int dZA;
    private int dZB;
    private int dZC;
    private int dZD;
    private Typeface dZE;
    private int dZF;
    private int dZG;
    private int dZH;
    private LinearLayout.LayoutParams dZn;
    private LinearLayout.LayoutParams dZo;
    private final b dZp;
    public ViewPager.OnPageChangeListener dZq;
    private LinearLayout dZr;
    private ViewPager dZs;
    private int dZt;
    private float dZu;
    private Paint dZv;
    private boolean dZw;
    private int dZx;
    private int dZy;
    private int dZz;
    private int indicatorHeight;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int mb(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dZp = new b();
        this.YJ = 0;
        this.dZu = 0.0f;
        this.dZw = false;
        this.dZx = an.getColor(R.color.cp_cont_b);
        this.dXd = an.getColor(R.color.cp_cont_j);
        this.dZy = 52;
        this.indicatorHeight = 4;
        this.dZz = 24;
        this.dZA = 24;
        this.dZB = 24;
        this.dZC = 24;
        this.dZD = 40;
        this.tabTextSize = 12;
        this.dZE = null;
        this.dZF = 0;
        this.dZG = 0;
        this.dZH = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dZr = new LinearLayout(getContext());
        this.dZr.setOrientation(0);
        this.dZr.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dZr);
        this.dZv = new Paint();
        this.dZv.setAntiAlias(true);
        this.dZv.setStyle(Paint.Style.FILL);
        this.dZn = new LinearLayout.LayoutParams(-2, -1);
        this.dZo = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.tabTextSize = i;
        this.dZz = i2;
        this.dZA = i3;
        this.dZB = i4;
        this.dZC = i5;
        this.indicatorHeight = i6;
        this.dZD = i7;
        this.dXd = i8;
        this.dZx = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dZs = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dZp);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dZq = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dZs != null && this.dZs.getAdapter() != null && this.dZs.getAdapter().getCount() != 0) {
            this.dZr.removeAllViews();
            this.dZt = this.dZs.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.dZt) {
                    if (this.dZs.getAdapter() instanceof a) {
                        aJ(i2, ((a) this.dZs.getAdapter()).mb(i2));
                    } else {
                        ao(i2, this.dZs.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.YJ = CommonPagerSlidingTabStrip.this.dZs.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.YJ, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void ao(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        d(i, textView);
    }

    private void aJ(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.dZs.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.dZz, this.dZA, this.dZB, this.dZC);
        this.dZr.addView(view, i, this.dZw ? this.dZo : this.dZn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.dZt; i++) {
            View childAt = this.dZr.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dZH);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.dZE, this.dZF);
                    if (i == this.dZs.getCurrentItem()) {
                        textView.setTextColor(this.dZx);
                    } else {
                        textView.setTextColor(this.dXd);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dZt != 0) {
            int left = this.dZr.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dZy;
            }
            if (left != this.dZG) {
                this.dZG = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.dZt != 0 && this.dZr.getChildCount() > 1) {
            int height = getHeight();
            this.dZv.setColor(this.dZx);
            View childAt = this.dZr.getChildAt(this.YJ);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.dZu > 0.0f && this.YJ < this.dZt - 1) {
                View childAt2 = this.dZr.getChildAt(this.YJ + 1);
                left = (left * (1.0f - this.dZu)) + (childAt2.getLeft() * this.dZu);
                right = (right * (1.0f - this.dZu)) + (childAt2.getRight() * this.dZu);
            }
            if (right - left < this.dZD) {
                canvas.drawRect(left, height - this.indicatorHeight, right, height, this.dZv);
            } else {
                canvas.drawRect(left + (((right - left) - this.dZD) / 2.0f), height - this.indicatorHeight, right - (((right - left) - this.dZD) / 2.0f), height, this.dZv);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.dZx = an.getColor(i, this.dZx);
        this.dXd = an.getColor(i, this.dXd);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.dZr.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.YJ = i;
                CommonPagerSlidingTabStrip.this.dZu = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.dZr.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.dZq != null) {
                    CommonPagerSlidingTabStrip.this.dZq.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.dZr.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.dZs.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.dZq != null) {
                    CommonPagerSlidingTabStrip.this.dZq.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.dZq != null) {
                CommonPagerSlidingTabStrip.this.dZq.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.YJ = savedState.YJ;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.YJ = this.YJ;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: L */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: mc */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int YJ;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.YJ = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.YJ);
        }
    }
}
