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
    private int BQ;
    public ViewPager.OnPageChangeListener cnA;
    private LinearLayout cnB;
    private ViewPager cnC;
    private int cnD;
    private float cnE;
    private Paint cnF;
    private boolean cnG;
    private int cnH;
    private int cnI;
    private int cnJ;
    private int cnK;
    private int cnQ;
    private Typeface cnR;
    private int cnS;
    private int cnT;
    private int cnU;
    private LinearLayout.LayoutParams cnx;
    private LinearLayout.LayoutParams cny;
    private final b cpC;
    private int cpD;
    private int cpE;
    private int cpF;
    private int dividerPadding;
    private Locale locale;
    private int tabPadding;

    /* loaded from: classes.dex */
    public interface a {
        int iA(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cpC = new b();
        this.BQ = 0;
        this.cnE = 0.0f;
        this.cnG = false;
        this.cnH = am.getColor(R.color.cp_cont_b);
        this.cnI = am.getColor(R.color.cp_cont_j);
        this.cpD = am.getColor(R.color.cp_bg_line_c);
        this.cnJ = 52;
        this.cnK = 4;
        this.cpE = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.cpF = 1;
        this.cnQ = 12;
        this.cnR = null;
        this.cnS = 0;
        this.cnT = 0;
        this.cnU = R.drawable.pager_sliding_view;
    }

    public void d(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.cnB = new LinearLayout(getContext());
        this.cnB.setOrientation(0);
        this.cnB.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.cnB);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.cnJ = (int) TypedValue.applyDimension(1, this.cnJ, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.cpF = (int) TypedValue.applyDimension(1, this.cpF, displayMetrics);
        this.cnQ = i;
        this.cnK = i3;
        this.cpE = i2;
        this.cnG = z;
        this.cnF = new Paint();
        this.cnF.setAntiAlias(true);
        this.cnF.setStyle(Paint.Style.FILL);
        this.cnx = new LinearLayout.LayoutParams(-2, -1);
        this.cny = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.cnC = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.cpC);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cnA = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.cnC != null && this.cnC.getAdapter() != null && this.cnC.getAdapter().getCount() != 0) {
            this.cnB.removeAllViews();
            this.cnD = this.cnC.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cnD) {
                    if (this.cnC.getAdapter() instanceof a) {
                        ae(i2, ((a) this.cnC.getAdapter()).iA(i2));
                    } else {
                        G(i2, this.cnC.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.BQ = PagerSlidingTabStrip.this.cnC.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.BQ, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void G(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        f(i, textView);
    }

    private void ae(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        f(i, imageButton);
    }

    private void f(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.cnC.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.cnB.addView(view, i, this.cnG ? this.cny : this.cnx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.cnD; i++) {
            View childAt = this.cnB.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.cnU);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.cnQ);
                    textView.setTypeface(this.cnR, this.cnS);
                    if (i == this.cnC.getCurrentItem()) {
                        textView.setTextColor(this.cnH);
                    } else {
                        textView.setTextColor(this.cnI);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.cnD != 0) {
            int left = this.cnB.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.cnJ;
            }
            if (left != this.cnT) {
                this.cnT = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.cnD != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            this.cnF.setColor(this.cnH);
            View childAt = this.cnB.getChildAt(this.BQ);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.cnK, dimensionPixelSize + width, height), 10.0f, 10.0f, this.cnF);
        }
    }

    public void onChangeSkinType() {
        this.cnH = am.getColor(R.color.cp_cont_b);
        this.cnI = am.getColor(R.color.cp_cont_j);
        this.cpD = am.getColor(R.color.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.cnB.getChildCount() != 0) {
                PagerSlidingTabStrip.this.BQ = i;
                PagerSlidingTabStrip.this.cnE = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.cnB.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.cnA != null) {
                    PagerSlidingTabStrip.this.cnA.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.cnB.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.cnC.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.cnA != null) {
                    PagerSlidingTabStrip.this.cnA.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.cnA != null) {
                PagerSlidingTabStrip.this.cnA.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.BQ = savedState.BQ;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.BQ = this.BQ;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: J */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: iN */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int BQ;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.BQ = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.BQ);
        }
    }
}
