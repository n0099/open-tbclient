package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private int Ev;
    private int deA;
    private int deB;
    private LinearLayout.LayoutParams def;
    private LinearLayout.LayoutParams deg;
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
    private Typeface dey;
    private int dez;
    private final b dgn;
    private int dgo;
    private int dgp;
    private int dgq;
    private int dividerPadding;
    private int indicatorHeight;
    private Locale locale;
    private int tabPadding;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int kW(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dgn = new b();
        this.Ev = 0;
        this.dem = 0.0f;
        this.deo = false;
        this.dep = am.getColor(R.color.cp_cont_b);
        this.deq = am.getColor(R.color.cp_cont_j);
        this.dgo = am.getColor(R.color.cp_bg_line_c);
        this.der = 52;
        this.indicatorHeight = 4;
        this.dgp = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dgq = 1;
        this.tabTextSize = 12;
        this.dey = null;
        this.dez = 0;
        this.deA = 0;
        this.deB = R.drawable.pager_sliding_view;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dej = new LinearLayout(getContext());
        this.dej.setOrientation(0);
        this.dej.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dej);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.der = (int) TypedValue.applyDimension(1, this.der, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dgq = (int) TypedValue.applyDimension(1, this.dgq, displayMetrics);
        this.tabTextSize = i;
        this.indicatorHeight = i3;
        this.dgp = i2;
        this.deo = z;
        this.den = new Paint();
        this.den.setAntiAlias(true);
        this.den.setStyle(Paint.Style.FILL);
        this.def = new LinearLayout.LayoutParams(-2, -1);
        this.deg = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.dek = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dgn);
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
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.Ev = PagerSlidingTabStrip.this.dek.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.Ev, 0);
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
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.dek.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
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
        if (!isInEditMode() && this.del != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            this.den.setColor(this.dep);
            View childAt = this.dej.getChildAt(this.Ev);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.indicatorHeight, dimensionPixelSize + width, height), 10.0f, 10.0f, this.den);
        }
    }

    public void onChangeSkinType() {
        this.dep = am.getColor(R.color.cp_cont_b);
        this.deq = am.getColor(R.color.cp_cont_j);
        this.dgo = am.getColor(R.color.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.dej.getChildCount() != 0) {
                PagerSlidingTabStrip.this.Ev = i;
                PagerSlidingTabStrip.this.dem = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.dej.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.dei != null) {
                    PagerSlidingTabStrip.this.dei.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.dej.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.dek.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.dei != null) {
                    PagerSlidingTabStrip.this.dei.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.dei != null) {
                PagerSlidingTabStrip.this.dei.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
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
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: T */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: lj */
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
