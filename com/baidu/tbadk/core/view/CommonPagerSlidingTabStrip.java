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
    private int aaR;
    private LinearLayout.LayoutParams eXY;
    private LinearLayout.LayoutParams eXZ;
    private final b eYa;
    public ViewPager.OnPageChangeListener eYb;
    private LinearLayout eYc;
    private ViewPager eYd;
    private int eYe;
    private float eYf;
    private Paint eYg;
    private boolean eYh;
    private int eYi;
    private int eYj;
    private int eYk;
    private int eYl;
    private int eYm;
    private int eYn;
    private int eYo;
    private int eYp;
    private Typeface eYq;
    private int eYr;
    private int eYs;
    private int eYt;
    private int indicatorHeight;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int qE(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eYa = new b();
        this.aaR = 0;
        this.eYf = 0.0f;
        this.eYh = false;
        this.eYi = ap.getColor(R.color.CAM_X0105);
        this.eYj = ap.getColor(R.color.CAM_X0107);
        this.eYk = 52;
        this.indicatorHeight = 4;
        this.eYl = 24;
        this.eYm = 24;
        this.eYn = 24;
        this.eYo = 24;
        this.eYp = 40;
        this.tabTextSize = 12;
        this.eYq = null;
        this.eYr = 0;
        this.eYs = 0;
        this.eYt = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.eYc = new LinearLayout(getContext());
        this.eYc.setOrientation(0);
        this.eYc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.eYc);
        this.eYg = new Paint();
        this.eYg.setAntiAlias(true);
        this.eYg.setStyle(Paint.Style.FILL);
        this.eXY = new LinearLayout.LayoutParams(-2, -1);
        this.eXZ = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.tabTextSize = i;
        this.eYl = i2;
        this.eYm = i3;
        this.eYn = i4;
        this.eYo = i5;
        this.indicatorHeight = i6;
        this.eYp = i7;
        this.eYj = i8;
        this.eYi = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eYd = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.eYa);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eYb = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.eYd != null && this.eYd.getAdapter() != null && this.eYd.getAdapter().getCount() != 0) {
            this.eYc.removeAllViews();
            this.eYe = this.eYd.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eYe) {
                    if (this.eYd.getAdapter() instanceof a) {
                        aU(i2, ((a) this.eYd.getAdapter()).qE(i2));
                    } else {
                        aD(i2, this.eYd.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.aaR = CommonPagerSlidingTabStrip.this.eYd.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.aaR, 0);
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

    private void aU(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.eYd.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.eYl, this.eYm, this.eYn, this.eYo);
        this.eYc.addView(view, i, this.eYh ? this.eXZ : this.eXY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.eYe; i++) {
            View childAt = this.eYc.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eYt);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.eYq, this.eYr);
                    if (i == this.eYd.getCurrentItem()) {
                        textView.setTextColor(this.eYi);
                    } else {
                        textView.setTextColor(this.eYj);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eYe != 0) {
            int left = this.eYc.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.eYk;
            }
            if (left != this.eYs) {
                this.eYs = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.eYe != 0 && this.eYc.getChildCount() > 1) {
            int height = getHeight();
            this.eYg.setColor(this.eYi);
            View childAt = this.eYc.getChildAt(this.aaR);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.eYf > 0.0f && this.aaR < this.eYe - 1) {
                View childAt2 = this.eYc.getChildAt(this.aaR + 1);
                left = (left * (1.0f - this.eYf)) + (childAt2.getLeft() * this.eYf);
                right = (right * (1.0f - this.eYf)) + (childAt2.getRight() * this.eYf);
            }
            if (right - left < this.eYp) {
                canvas.drawRect(left, height - this.indicatorHeight, right, height, this.eYg);
            } else {
                canvas.drawRect(left + (((right - left) - this.eYp) / 2.0f), height - this.indicatorHeight, right - (((right - left) - this.eYp) / 2.0f), height, this.eYg);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.eYi = ap.getColor(i, this.eYi);
        this.eYj = ap.getColor(i, this.eYj);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.eYc.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.aaR = i;
                CommonPagerSlidingTabStrip.this.eYf = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.eYc.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.eYb != null) {
                    CommonPagerSlidingTabStrip.this.eYb.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.eYc.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.eYd.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.eYb != null) {
                    CommonPagerSlidingTabStrip.this.eYb.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.eYb != null) {
                CommonPagerSlidingTabStrip.this.eYb.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aaR = savedState.aaR;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aaR = this.aaR;
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
            /* renamed from: qF */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int aaR;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aaR = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aaR);
        }
    }
}
