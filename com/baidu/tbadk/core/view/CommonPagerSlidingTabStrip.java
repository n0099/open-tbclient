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
    private int Ev;
    private int deA;
    private float deB;
    private Paint deC;
    private boolean deD;
    private int deE;
    private int deF;
    private int deG;
    private int deH;
    private int deI;
    private int deJ;
    private int deK;
    private int deL;
    private Typeface deM;
    private int deN;
    private int deO;
    private int deP;
    private LinearLayout.LayoutParams deu;
    private LinearLayout.LayoutParams dev;
    private final b dew;
    public ViewPager.OnPageChangeListener dex;
    private LinearLayout dey;
    private ViewPager dez;
    private int indicatorHeight;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int kW(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dew = new b();
        this.Ev = 0;
        this.deB = 0.0f;
        this.deD = false;
        this.deE = am.getColor(R.color.cp_cont_b);
        this.deF = am.getColor(R.color.cp_cont_j);
        this.deG = 52;
        this.indicatorHeight = 4;
        this.deH = 24;
        this.deI = 24;
        this.deJ = 24;
        this.deK = 24;
        this.deL = 40;
        this.tabTextSize = 12;
        this.deM = null;
        this.deN = 0;
        this.deO = 0;
        this.deP = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dey = new LinearLayout(getContext());
        this.dey.setOrientation(0);
        this.dey.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dey);
        this.deC = new Paint();
        this.deC.setAntiAlias(true);
        this.deC.setStyle(Paint.Style.FILL);
        this.deu = new LinearLayout.LayoutParams(-2, -1);
        this.dev = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.tabTextSize = i;
        this.deH = i2;
        this.deI = i3;
        this.deJ = i4;
        this.deK = i5;
        this.indicatorHeight = i6;
        this.deL = i7;
        this.deF = i8;
        this.deE = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dez = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dew);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dex = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dez != null && this.dez.getAdapter() != null && this.dez.getAdapter().getCount() != 0) {
            this.dey.removeAllViews();
            this.deA = this.dez.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.deA) {
                    if (this.dez.getAdapter() instanceof a) {
                        az(i2, ((a) this.dez.getAdapter()).kW(i2));
                    } else {
                        R(i2, this.dez.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.Ev = CommonPagerSlidingTabStrip.this.dez.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.Ev, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void R(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        d(i, textView);
    }

    private void az(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.dez.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.deH, this.deI, this.deJ, this.deK);
        this.dey.addView(view, i, this.deD ? this.dev : this.deu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.deA; i++) {
            View childAt = this.dey.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.deP);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.deM, this.deN);
                    if (i == this.dez.getCurrentItem()) {
                        textView.setTextColor(this.deE);
                    } else {
                        textView.setTextColor(this.deF);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.deA != 0) {
            int left = this.dey.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.deG;
            }
            if (left != this.deO) {
                this.deO = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.deA != 0 && this.dey.getChildCount() > 1) {
            int height = getHeight();
            this.deC.setColor(this.deE);
            View childAt = this.dey.getChildAt(this.Ev);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.deB > 0.0f && this.Ev < this.deA - 1) {
                View childAt2 = this.dey.getChildAt(this.Ev + 1);
                left = (left * (1.0f - this.deB)) + (childAt2.getLeft() * this.deB);
                right = (right * (1.0f - this.deB)) + (childAt2.getRight() * this.deB);
            }
            if (right - left < this.deL) {
                canvas.drawRect(left, height - this.indicatorHeight, right, height, this.deC);
            } else {
                canvas.drawRect(left + (((right - left) - this.deL) / 2.0f), height - this.indicatorHeight, right - (((right - left) - this.deL) / 2.0f), height, this.deC);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.deE = am.getColor(i, this.deE);
        this.deF = am.getColor(i, this.deF);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.dey.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.Ev = i;
                CommonPagerSlidingTabStrip.this.deB = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.dey.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.dex != null) {
                    CommonPagerSlidingTabStrip.this.dex.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.dey.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.dez.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.dex != null) {
                    CommonPagerSlidingTabStrip.this.dex.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.dex != null) {
                CommonPagerSlidingTabStrip.this.dex.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Ev = savedState.Ev;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Ev = this.Ev;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: S */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: kX */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Ev;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Ev = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ev);
        }
    }
}
