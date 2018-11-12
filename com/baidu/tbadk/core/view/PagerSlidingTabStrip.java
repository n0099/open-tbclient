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
    private int aCA;
    private float aCB;
    private Paint aCC;
    private boolean aCD;
    private int aCE;
    private int aCF;
    private int aCG;
    private int aCH;
    private int aCN;
    private Typeface aCO;
    private int aCP;
    private int aCQ;
    private int aCR;
    private LinearLayout.LayoutParams aCt;
    private LinearLayout.LayoutParams aCu;
    public ViewPager.OnPageChangeListener aCw;
    private LinearLayout aCx;
    private ViewPager aCy;
    private int aCz;
    private final b aEI;
    private int aEJ;
    private int aEK;
    private int dividerPadding;
    private int dividerWidth;
    private Locale locale;
    private int tabPadding;

    /* loaded from: classes.dex */
    public interface a {
        int dP(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEI = new b();
        this.aCA = 0;
        this.aCB = 0.0f;
        this.aCD = false;
        this.aCE = al.getColor(e.d.cp_cont_b);
        this.aCF = al.getColor(e.d.cp_cont_j);
        this.aEJ = al.getColor(e.d.cp_bg_line_c);
        this.aCG = 52;
        this.aCH = 4;
        this.aEK = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dividerWidth = 1;
        this.aCN = 12;
        this.aCO = null;
        this.aCP = 0;
        this.aCQ = 0;
        this.aCR = e.f.pager_sliding_view;
    }

    public void a(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aCx = new LinearLayout(getContext());
        this.aCx.setOrientation(0);
        this.aCx.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aCx);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aCG = (int) TypedValue.applyDimension(1, this.aCG, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.aCN = i;
        this.aCH = i3;
        this.aEK = i2;
        this.aCD = z;
        this.aCC = new Paint();
        this.aCC.setAntiAlias(true);
        this.aCC.setStyle(Paint.Style.FILL);
        this.aCt = new LinearLayout.LayoutParams(-2, -1);
        this.aCu = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.aCy = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.aEI);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aCw = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aCy != null && this.aCy.getAdapter() != null && this.aCy.getAdapter().getCount() != 0) {
            this.aCx.removeAllViews();
            this.aCz = this.aCy.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aCz) {
                    if (this.aCy.getAdapter() instanceof a) {
                        A(i2, ((a) this.aCy.getAdapter()).dP(i2));
                    } else {
                        i(i2, this.aCy.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.aCA = PagerSlidingTabStrip.this.aCy.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aCA, 0);
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
        b(i, textView);
    }

    private void A(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        b(i, imageButton);
    }

    private void b(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.aCy.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aCx.addView(view, i, this.aCD ? this.aCu : this.aCt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aCz; i++) {
            View childAt = this.aCx.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aCR);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aCN);
                    textView.setTypeface(this.aCO, this.aCP);
                    if (i == this.aCy.getCurrentItem()) {
                        textView.setTextColor(this.aCE);
                    } else {
                        textView.setTextColor(this.aCF);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aCz != 0) {
            int left = this.aCx.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aCG;
            }
            if (left != this.aCQ) {
                this.aCQ = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aCz != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0200e.ds64);
            this.aCC.setColor(this.aCE);
            View childAt = this.aCx.getChildAt(this.aCA);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.aCH, dimensionPixelSize + width, height), 10.0f, 10.0f, this.aCC);
        }
    }

    public void onChangeSkinType() {
        this.aCE = al.getColor(e.d.cp_cont_b);
        this.aCF = al.getColor(e.d.cp_cont_j);
        this.aEJ = al.getColor(e.d.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aCx.getChildCount() != 0) {
                PagerSlidingTabStrip.this.aCA = i;
                PagerSlidingTabStrip.this.aCB = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aCx.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.aCw != null) {
                    PagerSlidingTabStrip.this.aCw.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aCx.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aCy.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.aCw != null) {
                    PagerSlidingTabStrip.this.aCw.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aCw != null) {
                PagerSlidingTabStrip.this.aCw.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aCA = savedState.aCA;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aCA = this.aCA;
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
            /* renamed from: ee */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int aCA;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aCA = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aCA);
        }
    }
}
