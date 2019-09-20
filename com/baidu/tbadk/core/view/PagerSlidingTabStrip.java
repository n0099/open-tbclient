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
    private int Sv;
    private LinearLayout.LayoutParams bYA;
    public ViewPager.OnPageChangeListener bYC;
    private LinearLayout bYD;
    private ViewPager bYE;
    private int bYF;
    private float bYG;
    private Paint bYH;
    private boolean bYI;
    private int bYJ;
    private int bYK;
    private int bYL;
    private int bYM;
    private int bYS;
    private Typeface bYT;
    private int bYU;
    private int bYV;
    private int bYW;
    private LinearLayout.LayoutParams bYz;
    private final b cba;
    private int cbb;
    private int cbc;
    private int cbd;
    private int dividerPadding;
    private Locale locale;
    private int tabPadding;

    /* loaded from: classes.dex */
    public interface a {
        int iD(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cba = new b();
        this.Sv = 0;
        this.bYG = 0.0f;
        this.bYI = false;
        this.bYJ = am.getColor(R.color.cp_cont_b);
        this.bYK = am.getColor(R.color.cp_cont_j);
        this.cbb = am.getColor(R.color.cp_bg_line_c);
        this.bYL = 52;
        this.bYM = 4;
        this.cbc = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.cbd = 1;
        this.bYS = 12;
        this.bYT = null;
        this.bYU = 0;
        this.bYV = 0;
        this.bYW = R.drawable.pager_sliding_view;
    }

    public void d(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bYD = new LinearLayout(getContext());
        this.bYD.setOrientation(0);
        this.bYD.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bYD);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.bYL = (int) TypedValue.applyDimension(1, this.bYL, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.cbd = (int) TypedValue.applyDimension(1, this.cbd, displayMetrics);
        this.bYS = i;
        this.bYM = i3;
        this.cbc = i2;
        this.bYI = z;
        this.bYH = new Paint();
        this.bYH.setAntiAlias(true);
        this.bYH.setStyle(Paint.Style.FILL);
        this.bYz = new LinearLayout.LayoutParams(-2, -1);
        this.bYA = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.bYE = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.cba);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bYC = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bYE != null && this.bYE.getAdapter() != null && this.bYE.getAdapter().getCount() != 0) {
            this.bYD.removeAllViews();
            this.bYF = this.bYE.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bYF) {
                    if (this.bYE.getAdapter() instanceof a) {
                        aa(i2, ((a) this.bYE.getAdapter()).iD(i2));
                    } else {
                        D(i2, this.bYE.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.Sv = PagerSlidingTabStrip.this.bYE.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.Sv, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void D(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        e(i, textView);
    }

    private void aa(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        e(i, imageButton);
    }

    private void e(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.bYE.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.bYD.addView(view, i, this.bYI ? this.bYA : this.bYz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.bYF; i++) {
            View childAt = this.bYD.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bYW);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.bYS);
                    textView.setTypeface(this.bYT, this.bYU);
                    if (i == this.bYE.getCurrentItem()) {
                        textView.setTextColor(this.bYJ);
                    } else {
                        textView.setTextColor(this.bYK);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bYF != 0) {
            int left = this.bYD.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.bYL;
            }
            if (left != this.bYV) {
                this.bYV = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.bYF != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            this.bYH.setColor(this.bYJ);
            View childAt = this.bYD.getChildAt(this.Sv);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.bYM, dimensionPixelSize + width, height), 10.0f, 10.0f, this.bYH);
        }
    }

    public void onChangeSkinType() {
        this.bYJ = am.getColor(R.color.cp_cont_b);
        this.bYK = am.getColor(R.color.cp_cont_j);
        this.cbb = am.getColor(R.color.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.bYD.getChildCount() != 0) {
                PagerSlidingTabStrip.this.Sv = i;
                PagerSlidingTabStrip.this.bYG = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.bYD.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.bYC != null) {
                    PagerSlidingTabStrip.this.bYC.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.bYD.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.bYE.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.bYC != null) {
                    PagerSlidingTabStrip.this.bYC.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.bYC != null) {
                PagerSlidingTabStrip.this.bYC.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Sv = savedState.Sv;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Sv = this.Sv;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: B */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: iS */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Sv;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Sv = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Sv);
        }
    }
}
