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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private LinearLayout aGA;
    private ViewPager aGB;
    private int aGC;
    private int aGD;
    private float aGE;
    private Paint aGF;
    private boolean aGG;
    private int aGH;
    private int aGI;
    private int aGJ;
    private int aGK;
    private int aGQ;
    private Typeface aGR;
    private int aGS;
    private int aGT;
    private int aGU;
    private LinearLayout.LayoutParams aGw;
    private LinearLayout.LayoutParams aGx;
    public ViewPager.OnPageChangeListener aGz;
    private final b aIL;
    private int aIM;
    private int aIN;
    private int dividerPadding;
    private int dividerWidth;
    private Locale locale;
    private int tabPadding;

    /* loaded from: classes.dex */
    public interface a {
        int ed(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aIL = new b();
        this.aGD = 0;
        this.aGE = 0.0f;
        this.aGG = false;
        this.aGH = al.getColor(e.d.cp_cont_b);
        this.aGI = al.getColor(e.d.cp_cont_j);
        this.aIM = al.getColor(e.d.cp_bg_line_c);
        this.aGJ = 52;
        this.aGK = 4;
        this.aIN = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dividerWidth = 1;
        this.aGQ = 12;
        this.aGR = null;
        this.aGS = 0;
        this.aGT = 0;
        this.aGU = e.f.pager_sliding_view;
    }

    public void a(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aGA = new LinearLayout(getContext());
        this.aGA.setOrientation(0);
        this.aGA.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aGA);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aGJ = (int) TypedValue.applyDimension(1, this.aGJ, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.aGQ = i;
        this.aGK = i3;
        this.aIN = i2;
        this.aGG = z;
        this.aGF = new Paint();
        this.aGF.setAntiAlias(true);
        this.aGF.setStyle(Paint.Style.FILL);
        this.aGw = new LinearLayout.LayoutParams(-2, -1);
        this.aGx = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.aGB = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.aIL);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aGz = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aGB != null && this.aGB.getAdapter() != null && this.aGB.getAdapter().getCount() != 0) {
            this.aGA.removeAllViews();
            this.aGC = this.aGB.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aGC) {
                    if (this.aGB.getAdapter() instanceof a) {
                        B(i2, ((a) this.aGB.getAdapter()).ed(i2));
                    } else {
                        k(i2, this.aGB.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.aGD = PagerSlidingTabStrip.this.aGB.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aGD, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void k(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        b(i, textView);
    }

    private void B(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        b(i, imageButton);
    }

    private void b(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.aGB.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aGA.addView(view, i, this.aGG ? this.aGx : this.aGw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aGC; i++) {
            View childAt = this.aGA.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aGU);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aGQ);
                    textView.setTypeface(this.aGR, this.aGS);
                    if (i == this.aGB.getCurrentItem()) {
                        textView.setTextColor(this.aGH);
                    } else {
                        textView.setTextColor(this.aGI);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aGC != 0) {
            int left = this.aGA.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aGJ;
            }
            if (left != this.aGT) {
                this.aGT = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aGC != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds64);
            this.aGF.setColor(this.aGH);
            View childAt = this.aGA.getChildAt(this.aGD);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.aGK, dimensionPixelSize + width, height), 10.0f, 10.0f, this.aGF);
        }
    }

    public void onChangeSkinType() {
        this.aGH = al.getColor(e.d.cp_cont_b);
        this.aGI = al.getColor(e.d.cp_cont_j);
        this.aIM = al.getColor(e.d.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aGA.getChildCount() != 0) {
                PagerSlidingTabStrip.this.aGD = i;
                PagerSlidingTabStrip.this.aGE = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aGA.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.aGz != null) {
                    PagerSlidingTabStrip.this.aGz.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aGA.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aGB.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.aGz != null) {
                    PagerSlidingTabStrip.this.aGz.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aGz != null) {
                PagerSlidingTabStrip.this.aGz.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aGD = savedState.aGD;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aGD = this.aGD;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: i */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: es */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int aGD;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aGD = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aGD);
        }
    }
}
