package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private int acR;
    private LinearLayout.LayoutParams fgE;
    private LinearLayout.LayoutParams fgF;
    private final b fgG;
    public ViewPager.OnPageChangeListener fgH;
    private LinearLayout fgI;
    private ViewPager fgJ;
    private int fgK;
    private float fgL;
    private Paint fgM;
    private boolean fgN;
    private int fgO;
    private int fgP;
    private int fgQ;
    private int fgR;
    private int fgS;
    private int fgT;
    private int fgU;
    private int fgV;
    private int fgW;
    private int fgX;
    private Typeface fgY;
    private int fgZ;
    private int fha;
    private int tabBackgroundResId;

    /* loaded from: classes.dex */
    public interface a {
        int pp(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fgG = new b();
        this.acR = 0;
        this.fgL = 0.0f;
        this.fgN = false;
        this.fgO = ap.getColor(R.color.CAM_X0105);
        this.fgP = ap.getColor(R.color.CAM_X0107);
        this.fgQ = 52;
        this.fgR = 4;
        this.fgS = 24;
        this.fgT = 24;
        this.fgU = 24;
        this.fgV = 24;
        this.fgW = 40;
        this.fgX = 12;
        this.fgY = null;
        this.fgZ = 0;
        this.fha = 0;
        this.tabBackgroundResId = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.fgI = new LinearLayout(getContext());
        this.fgI.setOrientation(0);
        this.fgI.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.fgI);
        this.fgM = new Paint();
        this.fgM.setAntiAlias(true);
        this.fgM.setStyle(Paint.Style.FILL);
        this.fgE = new LinearLayout.LayoutParams(-2, -1);
        this.fgF = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.fgX = i;
        this.fgS = i2;
        this.fgT = i3;
        this.fgU = i4;
        this.fgV = i5;
        this.fgR = i6;
        this.fgW = i7;
        this.fgP = i8;
        this.fgO = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.fgJ = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fgG);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fgH = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.fgJ != null && this.fgJ.getAdapter() != null && this.fgJ.getAdapter().getCount() != 0) {
            this.fgI.removeAllViews();
            this.fgK = this.fgJ.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fgK) {
                    if (this.fgJ.getAdapter() instanceof a) {
                        aP(i2, ((a) this.fgJ.getAdapter()).pp(i2));
                    } else {
                        aK(i2, this.fgJ.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.acR = CommonPagerSlidingTabStrip.this.fgJ.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.acR, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void aK(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        d(i, textView);
    }

    private void aP(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.fgJ.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.fgS, this.fgT, this.fgU, this.fgV);
        this.fgI.addView(view, i, this.fgN ? this.fgF : this.fgE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.fgK; i++) {
            View childAt = this.fgI.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.tabBackgroundResId);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.fgX);
                    textView.setTypeface(this.fgY, this.fgZ);
                    if (i == this.fgJ.getCurrentItem()) {
                        textView.setTextColor(this.fgO);
                    } else {
                        textView.setTextColor(this.fgP);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.fgK != 0) {
            int left = this.fgI.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fgQ;
            }
            if (left != this.fha) {
                this.fha = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.fgK != 0 && this.fgI.getChildCount() > 1) {
            int height = getHeight();
            this.fgM.setColor(this.fgO);
            View childAt = this.fgI.getChildAt(this.acR);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.fgL > 0.0f && this.acR < this.fgK - 1) {
                View childAt2 = this.fgI.getChildAt(this.acR + 1);
                left = (left * (1.0f - this.fgL)) + (childAt2.getLeft() * this.fgL);
                right = (right * (1.0f - this.fgL)) + (childAt2.getRight() * this.fgL);
            }
            if (right - left < this.fgW) {
                canvas.drawRect(left, height - this.fgR, right, height, this.fgM);
            } else {
                canvas.drawRect(left + (((right - left) - this.fgW) / 2.0f), height - this.fgR, right - (((right - left) - this.fgW) / 2.0f), height, this.fgM);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.fgO = ap.getColor(i, this.fgO);
        this.fgP = ap.getColor(i, this.fgP);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.fgI.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.acR = i;
                CommonPagerSlidingTabStrip.this.fgL = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.fgI.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.fgH != null) {
                    CommonPagerSlidingTabStrip.this.fgH.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.fgI.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.fgJ.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.fgH != null) {
                    CommonPagerSlidingTabStrip.this.fgH.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.fgH != null) {
                CommonPagerSlidingTabStrip.this.fgH.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.acR = savedState.acR;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.acR = this.acR;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: P */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: pq */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int acR;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.acR = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.acR);
        }
    }
}
