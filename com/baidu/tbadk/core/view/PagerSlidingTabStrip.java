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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private int ZQ;
    private int dividerPadding;
    private int dividerWidth;
    private LinearLayout.LayoutParams eRF;
    private LinearLayout.LayoutParams eRG;
    public ViewPager.OnPageChangeListener eRI;
    private LinearLayout eRJ;
    private ViewPager eRK;
    private int eRL;
    private float eRM;
    private Paint eRN;
    private boolean eRO;
    private int eRP;
    private int eRQ;
    private Typeface eRV;
    private int eRW;
    private int eRX;
    private int eRY;
    private final b eUx;
    private int eUy;
    private int indicatorHeight;
    private Locale locale;
    private int scrollOffset;
    private int tabPadding;
    private int tabTextSize;
    private int underlineHeight;

    /* loaded from: classes.dex */
    public interface a {
        int pF(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eUx = new b();
        this.ZQ = 0;
        this.eRM = 0.0f;
        this.eRO = false;
        this.eRP = ap.getColor(R.color.cp_cont_b);
        this.eRQ = ap.getColor(R.color.cp_cont_j);
        this.eUy = ap.getColor(R.color.cp_bg_line_c);
        this.scrollOffset = 52;
        this.indicatorHeight = 4;
        this.underlineHeight = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dividerWidth = 1;
        this.tabTextSize = 12;
        this.eRV = null;
        this.eRW = 0;
        this.eRX = 0;
        this.eRY = R.drawable.pager_sliding_view;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.eRJ = new LinearLayout(getContext());
        this.eRJ.setOrientation(0);
        this.eRJ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.eRJ);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.scrollOffset = (int) TypedValue.applyDimension(1, this.scrollOffset, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.tabTextSize = i;
        this.indicatorHeight = i3;
        this.underlineHeight = i2;
        this.eRO = z;
        this.eRN = new Paint();
        this.eRN.setAntiAlias(true);
        this.eRN.setStyle(Paint.Style.FILL);
        this.eRF = new LinearLayout.LayoutParams(-2, -1);
        this.eRG = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.eRK = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.eUx);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eRI = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.eRK != null && this.eRK.getAdapter() != null && this.eRK.getAdapter().getCount() != 0) {
            this.eRJ.removeAllViews();
            this.eRL = this.eRK.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eRL) {
                    if (this.eRK.getAdapter() instanceof a) {
                        aS(i2, ((a) this.eRK.getAdapter()).pF(i2));
                    } else {
                        aF(i2, this.eRK.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.ZQ = PagerSlidingTabStrip.this.eRK.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.ZQ, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void aF(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        d(i, textView);
    }

    private void aS(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.eRK.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.eRJ.addView(view, i, this.eRO ? this.eRG : this.eRF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.eRL; i++) {
            View childAt = this.eRJ.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eRY);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.eRV, this.eRW);
                    if (i == this.eRK.getCurrentItem()) {
                        textView.setTextColor(this.eRP);
                    } else {
                        textView.setTextColor(this.eRQ);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eRL != 0) {
            int left = this.eRJ.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.scrollOffset;
            }
            if (left != this.eRX) {
                this.eRX = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.eRL != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            this.eRN.setColor(this.eRP);
            View childAt = this.eRJ.getChildAt(this.ZQ);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.indicatorHeight, dimensionPixelSize + width, height), 10.0f, 10.0f, this.eRN);
        }
    }

    public void onChangeSkinType() {
        this.eRP = ap.getColor(R.color.cp_cont_b);
        this.eRQ = ap.getColor(R.color.cp_cont_j);
        this.eUy = ap.getColor(R.color.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.eRJ.getChildCount() != 0) {
                PagerSlidingTabStrip.this.ZQ = i;
                PagerSlidingTabStrip.this.eRM = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.eRJ.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.eRI != null) {
                    PagerSlidingTabStrip.this.eRI.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.eRJ.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.eRK.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.eRI != null) {
                    PagerSlidingTabStrip.this.eRI.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.eRI != null) {
                PagerSlidingTabStrip.this.eRI.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.ZQ = savedState.ZQ;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.ZQ = this.ZQ;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: P */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: pS */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int ZQ;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ZQ = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ZQ);
        }
    }
}
