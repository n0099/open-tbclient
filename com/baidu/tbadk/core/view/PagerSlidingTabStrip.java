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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private Typeface aYA;
    private int aYB;
    private int aYC;
    private int aYD;
    private LinearLayout.LayoutParams aYg;
    private LinearLayout.LayoutParams aYh;
    public ViewPager.OnPageChangeListener aYj;
    private LinearLayout aYk;
    private ViewPager aYl;
    private int aYm;
    private float aYn;
    private Paint aYo;
    private boolean aYp;
    private int aYq;
    private int aYr;
    private int aYs;
    private int aYt;
    private int aYz;
    private final b baD;
    private int baE;
    private int baF;
    private int baG;
    private int currentPosition;
    private int dividerPadding;
    private Locale locale;
    private int tabPadding;

    /* loaded from: classes.dex */
    public interface a {
        int fZ(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baD = new b();
        this.currentPosition = 0;
        this.aYn = 0.0f;
        this.aYp = false;
        this.aYq = aj.getColor(d.C0108d.cp_cont_b);
        this.aYr = aj.getColor(d.C0108d.cp_cont_j);
        this.baE = aj.getColor(d.C0108d.cp_bg_line_c);
        this.aYs = 52;
        this.aYt = 4;
        this.baF = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.baG = 1;
        this.aYz = 12;
        this.aYA = null;
        this.aYB = 0;
        this.aYC = 0;
        this.aYD = d.f.pager_sliding_view;
    }

    public void init(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aYk = new LinearLayout(getContext());
        this.aYk.setOrientation(0);
        this.aYk.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aYk);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aYs = (int) TypedValue.applyDimension(1, this.aYs, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.baG = (int) TypedValue.applyDimension(1, this.baG, displayMetrics);
        this.aYz = i;
        this.aYt = i3;
        this.baF = i2;
        this.aYp = z;
        this.aYo = new Paint();
        this.aYo.setAntiAlias(true);
        this.aYo.setStyle(Paint.Style.FILL);
        this.aYg = new LinearLayout.LayoutParams(-2, -1);
        this.aYh = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.aYl = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.baD);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aYj = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aYl != null && this.aYl.getAdapter() != null && this.aYl.getAdapter().getCount() != 0) {
            this.aYk.removeAllViews();
            this.aYm = this.aYl.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aYm) {
                    if (this.aYl.getAdapter() instanceof a) {
                        aw(i2, ((a) this.aYl.getAdapter()).fZ(i2));
                    } else {
                        h(i2, this.aYl.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.aYl.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.currentPosition, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void h(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        b(i, textView);
    }

    private void aw(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        b(i, imageButton);
    }

    private void b(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.aYl.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aYk.addView(view, i, this.aYp ? this.aYh : this.aYg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aYm; i++) {
            View childAt = this.aYk.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aYD);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aYz);
                    textView.setTypeface(this.aYA, this.aYB);
                    if (i == this.aYl.getCurrentItem()) {
                        textView.setTextColor(this.aYq);
                    } else {
                        textView.setTextColor(this.aYr);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aYm != 0) {
            int left = this.aYk.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aYs;
            }
            if (left != this.aYC) {
                this.aYC = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aYm != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
            this.aYo.setColor(this.aYq);
            View childAt = this.aYk.getChildAt(this.currentPosition);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.aYt, dimensionPixelSize + width, height), 10.0f, 10.0f, this.aYo);
        }
    }

    public void onChangeSkinType() {
        this.aYq = aj.getColor(d.C0108d.cp_cont_b);
        this.aYr = aj.getColor(d.C0108d.cp_cont_j);
        this.baE = aj.getColor(d.C0108d.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aYk.getChildCount() != 0) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.aYn = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aYk.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.aYj != null) {
                    PagerSlidingTabStrip.this.aYj.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aYk.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aYl.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.aYj != null) {
                    PagerSlidingTabStrip.this.aYj.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aYj != null) {
                PagerSlidingTabStrip.this.aYj.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
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
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: v */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: gp */
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
