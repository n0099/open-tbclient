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
    private int deB;
    private int deC;
    private LinearLayout.LayoutParams deg;
    private LinearLayout.LayoutParams deh;
    private final b dei;
    public ViewPager.OnPageChangeListener dej;
    private LinearLayout dek;
    private ViewPager del;
    private int dem;
    private float den;
    private Paint deo;
    private boolean dep;
    private int deq;
    private int der;
    private int det;
    private int deu;
    private int dev;
    private int dew;
    private int dex;
    private int dey;
    private Typeface dez;
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
        this.dei = new b();
        this.Ev = 0;
        this.den = 0.0f;
        this.dep = false;
        this.deq = am.getColor(R.color.cp_cont_b);
        this.der = am.getColor(R.color.cp_cont_j);
        this.det = 52;
        this.indicatorHeight = 4;
        this.deu = 24;
        this.dev = 24;
        this.dew = 24;
        this.dex = 24;
        this.dey = 40;
        this.tabTextSize = 12;
        this.dez = null;
        this.deA = 0;
        this.deB = 0;
        this.deC = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dek = new LinearLayout(getContext());
        this.dek.setOrientation(0);
        this.dek.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dek);
        this.deo = new Paint();
        this.deo.setAntiAlias(true);
        this.deo.setStyle(Paint.Style.FILL);
        this.deg = new LinearLayout.LayoutParams(-2, -1);
        this.deh = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.tabTextSize = i;
        this.deu = i2;
        this.dev = i3;
        this.dew = i4;
        this.dex = i5;
        this.indicatorHeight = i6;
        this.dey = i7;
        this.der = i8;
        this.deq = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.del = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dei);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dej = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.del != null && this.del.getAdapter() != null && this.del.getAdapter().getCount() != 0) {
            this.dek.removeAllViews();
            this.dem = this.del.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.dem) {
                    if (this.del.getAdapter() instanceof a) {
                        az(i2, ((a) this.del.getAdapter()).kW(i2));
                    } else {
                        R(i2, this.del.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.Ev = CommonPagerSlidingTabStrip.this.del.getCurrentItem();
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
                CommonPagerSlidingTabStrip.this.del.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.deu, this.dev, this.dew, this.dex);
        this.dek.addView(view, i, this.dep ? this.deh : this.deg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.dem; i++) {
            View childAt = this.dek.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.deC);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.dez, this.deA);
                    if (i == this.del.getCurrentItem()) {
                        textView.setTextColor(this.deq);
                    } else {
                        textView.setTextColor(this.der);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dem != 0) {
            int left = this.dek.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.det;
            }
            if (left != this.deB) {
                this.deB = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.dem != 0 && this.dek.getChildCount() > 1) {
            int height = getHeight();
            this.deo.setColor(this.deq);
            View childAt = this.dek.getChildAt(this.Ev);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.den > 0.0f && this.Ev < this.dem - 1) {
                View childAt2 = this.dek.getChildAt(this.Ev + 1);
                left = (left * (1.0f - this.den)) + (childAt2.getLeft() * this.den);
                right = (right * (1.0f - this.den)) + (childAt2.getRight() * this.den);
            }
            if (right - left < this.dey) {
                canvas.drawRect(left, height - this.indicatorHeight, right, height, this.deo);
            } else {
                canvas.drawRect(left + (((right - left) - this.dey) / 2.0f), height - this.indicatorHeight, right - (((right - left) - this.dey) / 2.0f), height, this.deo);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.deq = am.getColor(i, this.deq);
        this.der = am.getColor(i, this.der);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.dek.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.Ev = i;
                CommonPagerSlidingTabStrip.this.den = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.dek.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.dej != null) {
                    CommonPagerSlidingTabStrip.this.dej.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.dek.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.del.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.dej != null) {
                    CommonPagerSlidingTabStrip.this.dej.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.dej != null) {
                CommonPagerSlidingTabStrip.this.dej.onPageSelected(i);
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
