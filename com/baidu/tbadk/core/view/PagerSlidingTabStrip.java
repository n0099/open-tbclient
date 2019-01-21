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
    public ViewPager.OnPageChangeListener aGA;
    private LinearLayout aGB;
    private ViewPager aGC;
    private int aGD;
    private int aGE;
    private float aGF;
    private Paint aGG;
    private boolean aGH;
    private int aGI;
    private int aGJ;
    private int aGK;
    private int aGL;
    private int aGR;
    private Typeface aGS;
    private int aGT;
    private int aGU;
    private int aGV;
    private LinearLayout.LayoutParams aGx;
    private LinearLayout.LayoutParams aGy;
    private final b aIM;
    private int aIN;
    private int aIO;
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
        this.aIM = new b();
        this.aGE = 0;
        this.aGF = 0.0f;
        this.aGH = false;
        this.aGI = al.getColor(e.d.cp_cont_b);
        this.aGJ = al.getColor(e.d.cp_cont_j);
        this.aIN = al.getColor(e.d.cp_bg_line_c);
        this.aGK = 52;
        this.aGL = 4;
        this.aIO = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dividerWidth = 1;
        this.aGR = 12;
        this.aGS = null;
        this.aGT = 0;
        this.aGU = 0;
        this.aGV = e.f.pager_sliding_view;
    }

    public void a(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aGB = new LinearLayout(getContext());
        this.aGB.setOrientation(0);
        this.aGB.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aGB);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aGK = (int) TypedValue.applyDimension(1, this.aGK, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.aGR = i;
        this.aGL = i3;
        this.aIO = i2;
        this.aGH = z;
        this.aGG = new Paint();
        this.aGG.setAntiAlias(true);
        this.aGG.setStyle(Paint.Style.FILL);
        this.aGx = new LinearLayout.LayoutParams(-2, -1);
        this.aGy = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.aGC = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.aIM);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aGA = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aGC != null && this.aGC.getAdapter() != null && this.aGC.getAdapter().getCount() != 0) {
            this.aGB.removeAllViews();
            this.aGD = this.aGC.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aGD) {
                    if (this.aGC.getAdapter() instanceof a) {
                        B(i2, ((a) this.aGC.getAdapter()).ed(i2));
                    } else {
                        k(i2, this.aGC.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.aGE = PagerSlidingTabStrip.this.aGC.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aGE, 0);
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
                PagerSlidingTabStrip.this.aGC.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aGB.addView(view, i, this.aGH ? this.aGy : this.aGx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aGD; i++) {
            View childAt = this.aGB.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aGV);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aGR);
                    textView.setTypeface(this.aGS, this.aGT);
                    if (i == this.aGC.getCurrentItem()) {
                        textView.setTextColor(this.aGI);
                    } else {
                        textView.setTextColor(this.aGJ);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aGD != 0) {
            int left = this.aGB.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aGK;
            }
            if (left != this.aGU) {
                this.aGU = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aGD != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds64);
            this.aGG.setColor(this.aGI);
            View childAt = this.aGB.getChildAt(this.aGE);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.aGL, dimensionPixelSize + width, height), 10.0f, 10.0f, this.aGG);
        }
    }

    public void onChangeSkinType() {
        this.aGI = al.getColor(e.d.cp_cont_b);
        this.aGJ = al.getColor(e.d.cp_cont_j);
        this.aIN = al.getColor(e.d.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aGB.getChildCount() != 0) {
                PagerSlidingTabStrip.this.aGE = i;
                PagerSlidingTabStrip.this.aGF = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aGB.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.aGA != null) {
                    PagerSlidingTabStrip.this.aGA.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aGB.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aGC.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.aGA != null) {
                    PagerSlidingTabStrip.this.aGA.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aGA != null) {
                PagerSlidingTabStrip.this.aGA.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aGE = savedState.aGE;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aGE = this.aGE;
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
        int aGE;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aGE = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aGE);
        }
    }
}
