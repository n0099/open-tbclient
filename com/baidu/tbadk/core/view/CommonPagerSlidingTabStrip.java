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
    private int ZP;
    private int eDA;
    private float eDB;
    private Paint eDC;
    private boolean eDD;
    private int eDE;
    private int eDF;
    private int eDG;
    private int eDH;
    private int eDI;
    private int eDJ;
    private Typeface eDK;
    private int eDL;
    private int eDM;
    private int eDN;
    private LinearLayout.LayoutParams eDu;
    private LinearLayout.LayoutParams eDv;
    private final b eDw;
    public ViewPager.OnPageChangeListener eDx;
    private LinearLayout eDy;
    private ViewPager eDz;
    private int indicatorHeight;
    private int indicatorWidth;
    private int scrollOffset;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int pj(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eDw = new b();
        this.ZP = 0;
        this.eDB = 0.0f;
        this.eDD = false;
        this.eDE = ap.getColor(R.color.cp_cont_b);
        this.eDF = ap.getColor(R.color.cp_cont_j);
        this.scrollOffset = 52;
        this.indicatorHeight = 4;
        this.eDG = 24;
        this.eDH = 24;
        this.eDI = 24;
        this.eDJ = 24;
        this.indicatorWidth = 40;
        this.tabTextSize = 12;
        this.eDK = null;
        this.eDL = 0;
        this.eDM = 0;
        this.eDN = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.eDy = new LinearLayout(getContext());
        this.eDy.setOrientation(0);
        this.eDy.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.eDy);
        this.eDC = new Paint();
        this.eDC.setAntiAlias(true);
        this.eDC.setStyle(Paint.Style.FILL);
        this.eDu = new LinearLayout.LayoutParams(-2, -1);
        this.eDv = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.tabTextSize = i;
        this.eDG = i2;
        this.eDH = i3;
        this.eDI = i4;
        this.eDJ = i5;
        this.indicatorHeight = i6;
        this.indicatorWidth = i7;
        this.eDF = i8;
        this.eDE = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eDz = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.eDw);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eDx = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.eDz != null && this.eDz.getAdapter() != null && this.eDz.getAdapter().getCount() != 0) {
            this.eDy.removeAllViews();
            this.eDA = this.eDz.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eDA) {
                    if (this.eDz.getAdapter() instanceof a) {
                        aR(i2, ((a) this.eDz.getAdapter()).pj(i2));
                    } else {
                        az(i2, this.eDz.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.ZP = CommonPagerSlidingTabStrip.this.eDz.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.ZP, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void az(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        d(i, textView);
    }

    private void aR(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.eDz.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.eDG, this.eDH, this.eDI, this.eDJ);
        this.eDy.addView(view, i, this.eDD ? this.eDv : this.eDu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.eDA; i++) {
            View childAt = this.eDy.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eDN);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.eDK, this.eDL);
                    if (i == this.eDz.getCurrentItem()) {
                        textView.setTextColor(this.eDE);
                    } else {
                        textView.setTextColor(this.eDF);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eDA != 0) {
            int left = this.eDy.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.scrollOffset;
            }
            if (left != this.eDM) {
                this.eDM = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.eDA != 0 && this.eDy.getChildCount() > 1) {
            int height = getHeight();
            this.eDC.setColor(this.eDE);
            View childAt = this.eDy.getChildAt(this.ZP);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.eDB > 0.0f && this.ZP < this.eDA - 1) {
                View childAt2 = this.eDy.getChildAt(this.ZP + 1);
                left = (left * (1.0f - this.eDB)) + (childAt2.getLeft() * this.eDB);
                right = (right * (1.0f - this.eDB)) + (childAt2.getRight() * this.eDB);
            }
            if (right - left < this.indicatorWidth) {
                canvas.drawRect(left, height - this.indicatorHeight, right, height, this.eDC);
            } else {
                canvas.drawRect(left + (((right - left) - this.indicatorWidth) / 2.0f), height - this.indicatorHeight, right - (((right - left) - this.indicatorWidth) / 2.0f), height, this.eDC);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.eDE = ap.getColor(i, this.eDE);
        this.eDF = ap.getColor(i, this.eDF);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.eDy.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.ZP = i;
                CommonPagerSlidingTabStrip.this.eDB = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.eDy.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.eDx != null) {
                    CommonPagerSlidingTabStrip.this.eDx.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.eDy.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.eDz.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.eDx != null) {
                    CommonPagerSlidingTabStrip.this.eDx.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.eDx != null) {
                CommonPagerSlidingTabStrip.this.eDx.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.ZP = savedState.ZP;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.ZP = this.ZP;
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
            /* renamed from: pk */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int ZP;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ZP = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ZP);
        }
    }
}
