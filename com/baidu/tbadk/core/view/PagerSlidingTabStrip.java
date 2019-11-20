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
    private int Bq;
    private LinearLayout.LayoutParams cmF;
    private LinearLayout.LayoutParams cmG;
    public ViewPager.OnPageChangeListener cmI;
    private LinearLayout cmJ;
    private ViewPager cmK;
    private int cmL;
    private float cmM;
    private Paint cmN;
    private boolean cmO;
    private int cmP;
    private int cmQ;
    private int cmR;
    private int cmS;
    private int cmY;
    private Typeface cmZ;
    private int cna;
    private int cnb;
    private int cnc;
    private final b coK;
    private int coL;
    private int coM;
    private int coN;
    private int dividerPadding;
    private Locale locale;
    private int tabPadding;

    /* loaded from: classes.dex */
    public interface a {
        int iz(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.coK = new b();
        this.Bq = 0;
        this.cmM = 0.0f;
        this.cmO = false;
        this.cmP = am.getColor(R.color.cp_cont_b);
        this.cmQ = am.getColor(R.color.cp_cont_j);
        this.coL = am.getColor(R.color.cp_bg_line_c);
        this.cmR = 52;
        this.cmS = 4;
        this.coM = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.coN = 1;
        this.cmY = 12;
        this.cmZ = null;
        this.cna = 0;
        this.cnb = 0;
        this.cnc = R.drawable.pager_sliding_view;
    }

    public void d(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.cmJ = new LinearLayout(getContext());
        this.cmJ.setOrientation(0);
        this.cmJ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.cmJ);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.cmR = (int) TypedValue.applyDimension(1, this.cmR, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.coN = (int) TypedValue.applyDimension(1, this.coN, displayMetrics);
        this.cmY = i;
        this.cmS = i3;
        this.coM = i2;
        this.cmO = z;
        this.cmN = new Paint();
        this.cmN.setAntiAlias(true);
        this.cmN.setStyle(Paint.Style.FILL);
        this.cmF = new LinearLayout.LayoutParams(-2, -1);
        this.cmG = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.cmK = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.coK);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cmI = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.cmK != null && this.cmK.getAdapter() != null && this.cmK.getAdapter().getCount() != 0) {
            this.cmJ.removeAllViews();
            this.cmL = this.cmK.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cmL) {
                    if (this.cmK.getAdapter() instanceof a) {
                        ac(i2, ((a) this.cmK.getAdapter()).iz(i2));
                    } else {
                        F(i2, this.cmK.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.Bq = PagerSlidingTabStrip.this.cmK.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.Bq, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void F(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        f(i, textView);
    }

    private void ac(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        f(i, imageButton);
    }

    private void f(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.cmK.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.cmJ.addView(view, i, this.cmO ? this.cmG : this.cmF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.cmL; i++) {
            View childAt = this.cmJ.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.cnc);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.cmY);
                    textView.setTypeface(this.cmZ, this.cna);
                    if (i == this.cmK.getCurrentItem()) {
                        textView.setTextColor(this.cmP);
                    } else {
                        textView.setTextColor(this.cmQ);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.cmL != 0) {
            int left = this.cmJ.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.cmR;
            }
            if (left != this.cnb) {
                this.cnb = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.cmL != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            this.cmN.setColor(this.cmP);
            View childAt = this.cmJ.getChildAt(this.Bq);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.cmS, dimensionPixelSize + width, height), 10.0f, 10.0f, this.cmN);
        }
    }

    public void onChangeSkinType() {
        this.cmP = am.getColor(R.color.cp_cont_b);
        this.cmQ = am.getColor(R.color.cp_cont_j);
        this.coL = am.getColor(R.color.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.cmJ.getChildCount() != 0) {
                PagerSlidingTabStrip.this.Bq = i;
                PagerSlidingTabStrip.this.cmM = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.cmJ.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.cmI != null) {
                    PagerSlidingTabStrip.this.cmI.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.cmJ.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.cmK.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.cmI != null) {
                    PagerSlidingTabStrip.this.cmI.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.cmI != null) {
                PagerSlidingTabStrip.this.cmI.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Bq = savedState.Bq;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Bq = this.Bq;
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
            /* renamed from: iM */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Bq;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Bq = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Bq);
        }
    }
}
