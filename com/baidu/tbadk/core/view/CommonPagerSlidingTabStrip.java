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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private int ajA;
    private float ajB;
    private Paint ajC;
    private boolean ajD;
    private int ajE;
    private int ajF;
    private int ajG;
    private int ajH;
    private int ajI;
    private int ajJ;
    private int ajK;
    private int ajL;
    private int ajM;
    private int ajN;
    private Typeface ajO;
    private int ajP;
    private int ajQ;
    private int ajR;
    private LinearLayout.LayoutParams aju;
    private LinearLayout.LayoutParams ajv;
    private final b ajw;
    public ViewPager.OnPageChangeListener ajx;
    private LinearLayout ajy;
    private ViewPager ajz;
    private int currentPosition;

    /* loaded from: classes.dex */
    public interface a {
        int db(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajw = new b();
        this.currentPosition = 0;
        this.ajB = 0.0f;
        this.ajD = false;
        this.ajE = aj.getColor(d.C0080d.cp_cont_b);
        this.ajF = aj.getColor(d.C0080d.cp_cont_j);
        this.ajG = 52;
        this.ajH = 4;
        this.ajI = 24;
        this.ajJ = 24;
        this.ajK = 24;
        this.ajL = 24;
        this.ajM = 40;
        this.ajN = 12;
        this.ajO = null;
        this.ajP = 0;
        this.ajQ = 0;
        this.ajR = d.f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.ajy = new LinearLayout(getContext());
        this.ajy.setOrientation(0);
        this.ajy.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.ajy);
        this.ajC = new Paint();
        this.ajC.setAntiAlias(true);
        this.ajC.setStyle(Paint.Style.FILL);
        this.aju = new LinearLayout.LayoutParams(-2, -1);
        this.ajv = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.ajN = i;
        this.ajI = i2;
        this.ajJ = i3;
        this.ajK = i4;
        this.ajL = i5;
        this.ajH = i6;
        this.ajM = i7;
        this.ajF = i8;
        this.ajE = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ajz = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.ajw);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ajx = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.ajz != null && this.ajz.getAdapter() != null && this.ajz.getAdapter().getCount() != 0) {
            this.ajy.removeAllViews();
            this.ajA = this.ajz.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ajA) {
                    if (this.ajz.getAdapter() instanceof a) {
                        w(i2, ((a) this.ajz.getAdapter()).db(i2));
                    } else {
                        i(i2, this.ajz.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.currentPosition = CommonPagerSlidingTabStrip.this.ajz.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.x(CommonPagerSlidingTabStrip.this.currentPosition, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void i(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        a(i, textView);
    }

    private void w(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        a(i, imageButton);
    }

    private void a(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.ajz.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.ajI, this.ajJ, this.ajK, this.ajL);
        this.ajy.addView(view, i, this.ajD ? this.ajv : this.aju);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.ajA; i++) {
            View childAt = this.ajy.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.ajR);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.ajN);
                    textView.setTypeface(this.ajO, this.ajP);
                    if (i == this.ajz.getCurrentItem()) {
                        textView.setTextColor(this.ajE);
                    } else {
                        textView.setTextColor(this.ajF);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i, int i2) {
        if (this.ajA != 0) {
            int left = this.ajy.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.ajG;
            }
            if (left != this.ajQ) {
                this.ajQ = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.ajA != 0 && this.ajy.getChildCount() > 1) {
            int height = getHeight();
            this.ajC.setColor(this.ajE);
            View childAt = this.ajy.getChildAt(this.currentPosition);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.ajB > 0.0f && this.currentPosition < this.ajA - 1) {
                View childAt2 = this.ajy.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.ajB)) + (childAt2.getLeft() * this.ajB);
                right = (right * (1.0f - this.ajB)) + (childAt2.getRight() * this.ajB);
            }
            if (right - left < this.ajM) {
                canvas.drawRect(left, height - this.ajH, right, height, this.ajC);
            } else {
                canvas.drawRect(left + (((right - left) - this.ajM) / 2.0f), height - this.ajH, right - (((right - left) - this.ajM) / 2.0f), height, this.ajC);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.ajE = aj.getColor(i, this.ajE);
        this.ajF = aj.getColor(i, this.ajF);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.ajy.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.currentPosition = i;
                CommonPagerSlidingTabStrip.this.ajB = f;
                CommonPagerSlidingTabStrip.this.x(i, (int) (CommonPagerSlidingTabStrip.this.ajy.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.ajx != null) {
                    CommonPagerSlidingTabStrip.this.ajx.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.ajy.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.x(CommonPagerSlidingTabStrip.this.ajz.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.ajx != null) {
                    CommonPagerSlidingTabStrip.this.ajx.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.ajx != null) {
                CommonPagerSlidingTabStrip.this.ajx.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.currentPosition = savedState.currentPosition;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.currentPosition = this.currentPosition;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: e */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: dc */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int currentPosition;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.currentPosition = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.currentPosition);
        }
    }
}
