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
    private LinearLayout.LayoutParams def;
    private LinearLayout.LayoutParams deg;
    private final b deh;
    public ViewPager.OnPageChangeListener dei;
    private LinearLayout dej;
    private ViewPager dek;
    private int del;
    private float dem;
    private Paint den;
    private boolean deo;
    private int dep;
    private int deq;
    private int der;
    private int det;
    private int deu;
    private int dev;
    private int dew;
    private int dex;
    private Typeface dey;
    private int dez;
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
        this.deh = new b();
        this.Ev = 0;
        this.dem = 0.0f;
        this.deo = false;
        this.dep = am.getColor(R.color.cp_cont_b);
        this.deq = am.getColor(R.color.cp_cont_j);
        this.der = 52;
        this.indicatorHeight = 4;
        this.det = 24;
        this.deu = 24;
        this.dev = 24;
        this.dew = 24;
        this.dex = 40;
        this.tabTextSize = 12;
        this.dey = null;
        this.dez = 0;
        this.deA = 0;
        this.deB = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dej = new LinearLayout(getContext());
        this.dej.setOrientation(0);
        this.dej.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dej);
        this.den = new Paint();
        this.den.setAntiAlias(true);
        this.den.setStyle(Paint.Style.FILL);
        this.def = new LinearLayout.LayoutParams(-2, -1);
        this.deg = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.tabTextSize = i;
        this.det = i2;
        this.deu = i3;
        this.dev = i4;
        this.dew = i5;
        this.indicatorHeight = i6;
        this.dex = i7;
        this.deq = i8;
        this.dep = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dek = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.deh);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dei = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dek != null && this.dek.getAdapter() != null && this.dek.getAdapter().getCount() != 0) {
            this.dej.removeAllViews();
            this.del = this.dek.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.del) {
                    if (this.dek.getAdapter() instanceof a) {
                        az(i2, ((a) this.dek.getAdapter()).kW(i2));
                    } else {
                        R(i2, this.dek.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.Ev = CommonPagerSlidingTabStrip.this.dek.getCurrentItem();
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
                CommonPagerSlidingTabStrip.this.dek.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.det, this.deu, this.dev, this.dew);
        this.dej.addView(view, i, this.deo ? this.deg : this.def);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.del; i++) {
            View childAt = this.dej.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.deB);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.dey, this.dez);
                    if (i == this.dek.getCurrentItem()) {
                        textView.setTextColor(this.dep);
                    } else {
                        textView.setTextColor(this.deq);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.del != 0) {
            int left = this.dej.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.der;
            }
            if (left != this.deA) {
                this.deA = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.del != 0 && this.dej.getChildCount() > 1) {
            int height = getHeight();
            this.den.setColor(this.dep);
            View childAt = this.dej.getChildAt(this.Ev);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.dem > 0.0f && this.Ev < this.del - 1) {
                View childAt2 = this.dej.getChildAt(this.Ev + 1);
                left = (left * (1.0f - this.dem)) + (childAt2.getLeft() * this.dem);
                right = (right * (1.0f - this.dem)) + (childAt2.getRight() * this.dem);
            }
            if (right - left < this.dex) {
                canvas.drawRect(left, height - this.indicatorHeight, right, height, this.den);
            } else {
                canvas.drawRect(left + (((right - left) - this.dex) / 2.0f), height - this.indicatorHeight, right - (((right - left) - this.dex) / 2.0f), height, this.den);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.dep = am.getColor(i, this.dep);
        this.deq = am.getColor(i, this.deq);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.dej.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.Ev = i;
                CommonPagerSlidingTabStrip.this.dem = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.dej.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.dei != null) {
                    CommonPagerSlidingTabStrip.this.dei.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.dej.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.dek.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.dei != null) {
                    CommonPagerSlidingTabStrip.this.dei.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.dei != null) {
                CommonPagerSlidingTabStrip.this.dei.onPageSelected(i);
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
