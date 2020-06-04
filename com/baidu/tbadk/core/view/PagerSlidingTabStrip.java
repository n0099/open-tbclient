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
    private int Yf;
    private int dQl;
    private ViewPager dSA;
    private int dSB;
    private float dSC;
    private Paint dSD;
    private boolean dSE;
    private int dSF;
    private int dSG;
    private Typeface dSM;
    private int dSN;
    private int dSO;
    private int dSP;
    private LinearLayout.LayoutParams dSv;
    private LinearLayout.LayoutParams dSw;
    public ViewPager.OnPageChangeListener dSy;
    private LinearLayout dSz;
    private final b dUB;
    private int dUC;
    private int dUD;
    private int dUE;
    private int dividerPadding;
    private int indicatorHeight;
    private Locale locale;
    private int tabPadding;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int lK(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dUB = new b();
        this.Yf = 0;
        this.dSC = 0.0f;
        this.dSE = false;
        this.dSF = am.getColor(R.color.cp_cont_b);
        this.dQl = am.getColor(R.color.cp_cont_j);
        this.dUC = am.getColor(R.color.cp_bg_line_c);
        this.dSG = 52;
        this.indicatorHeight = 4;
        this.dUD = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dUE = 1;
        this.tabTextSize = 12;
        this.dSM = null;
        this.dSN = 0;
        this.dSO = 0;
        this.dSP = R.drawable.pager_sliding_view;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dSz = new LinearLayout(getContext());
        this.dSz.setOrientation(0);
        this.dSz.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dSz);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.dSG = (int) TypedValue.applyDimension(1, this.dSG, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dUE = (int) TypedValue.applyDimension(1, this.dUE, displayMetrics);
        this.tabTextSize = i;
        this.indicatorHeight = i3;
        this.dUD = i2;
        this.dSE = z;
        this.dSD = new Paint();
        this.dSD.setAntiAlias(true);
        this.dSD.setStyle(Paint.Style.FILL);
        this.dSv = new LinearLayout.LayoutParams(-2, -1);
        this.dSw = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.dSA = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dUB);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dSy = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dSA != null && this.dSA.getAdapter() != null && this.dSA.getAdapter().getCount() != 0) {
            this.dSz.removeAllViews();
            this.dSB = this.dSA.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.dSB) {
                    if (this.dSA.getAdapter() instanceof a) {
                        aG(i2, ((a) this.dSA.getAdapter()).lK(i2));
                    } else {
                        an(i2, this.dSA.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.Yf = PagerSlidingTabStrip.this.dSA.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.Yf, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void an(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        d(i, textView);
    }

    private void aG(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.dSA.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.dSz.addView(view, i, this.dSE ? this.dSw : this.dSv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.dSB; i++) {
            View childAt = this.dSz.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dSP);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.dSM, this.dSN);
                    if (i == this.dSA.getCurrentItem()) {
                        textView.setTextColor(this.dSF);
                    } else {
                        textView.setTextColor(this.dQl);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dSB != 0) {
            int left = this.dSz.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dSG;
            }
            if (left != this.dSO) {
                this.dSO = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.dSB != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            this.dSD.setColor(this.dSF);
            View childAt = this.dSz.getChildAt(this.Yf);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.indicatorHeight, dimensionPixelSize + width, height), 10.0f, 10.0f, this.dSD);
        }
    }

    public void onChangeSkinType() {
        this.dSF = am.getColor(R.color.cp_cont_b);
        this.dQl = am.getColor(R.color.cp_cont_j);
        this.dUC = am.getColor(R.color.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.dSz.getChildCount() != 0) {
                PagerSlidingTabStrip.this.Yf = i;
                PagerSlidingTabStrip.this.dSC = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.dSz.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.dSy != null) {
                    PagerSlidingTabStrip.this.dSy.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.dSz.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.dSA.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.dSy != null) {
                    PagerSlidingTabStrip.this.dSy.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.dSy != null) {
                PagerSlidingTabStrip.this.dSy.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Yf = savedState.Yf;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Yf = this.Yf;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: M */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: lX */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Yf;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Yf = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Yf);
        }
    }
}
