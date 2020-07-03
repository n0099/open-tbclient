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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private int YJ;
    private int dXd;
    private Typeface dZE;
    private int dZF;
    private int dZG;
    private int dZH;
    private LinearLayout.LayoutParams dZn;
    private LinearLayout.LayoutParams dZo;
    public ViewPager.OnPageChangeListener dZq;
    private LinearLayout dZr;
    private ViewPager dZs;
    private int dZt;
    private float dZu;
    private Paint dZv;
    private boolean dZw;
    private int dZx;
    private int dZy;
    private int dividerPadding;
    private final b ebQ;
    private int ebR;
    private int ebS;
    private int ebT;
    private int indicatorHeight;
    private Locale locale;
    private int tabPadding;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int mb(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ebQ = new b();
        this.YJ = 0;
        this.dZu = 0.0f;
        this.dZw = false;
        this.dZx = an.getColor(R.color.cp_cont_b);
        this.dXd = an.getColor(R.color.cp_cont_j);
        this.ebR = an.getColor(R.color.cp_bg_line_c);
        this.dZy = 52;
        this.indicatorHeight = 4;
        this.ebS = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.ebT = 1;
        this.tabTextSize = 12;
        this.dZE = null;
        this.dZF = 0;
        this.dZG = 0;
        this.dZH = R.drawable.pager_sliding_view;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dZr = new LinearLayout(getContext());
        this.dZr.setOrientation(0);
        this.dZr.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dZr);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.dZy = (int) TypedValue.applyDimension(1, this.dZy, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.ebT = (int) TypedValue.applyDimension(1, this.ebT, displayMetrics);
        this.tabTextSize = i;
        this.indicatorHeight = i3;
        this.ebS = i2;
        this.dZw = z;
        this.dZv = new Paint();
        this.dZv.setAntiAlias(true);
        this.dZv.setStyle(Paint.Style.FILL);
        this.dZn = new LinearLayout.LayoutParams(-2, -1);
        this.dZo = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.dZs = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.ebQ);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dZq = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dZs != null && this.dZs.getAdapter() != null && this.dZs.getAdapter().getCount() != 0) {
            this.dZr.removeAllViews();
            this.dZt = this.dZs.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.dZt) {
                    if (this.dZs.getAdapter() instanceof a) {
                        aJ(i2, ((a) this.dZs.getAdapter()).mb(i2));
                    } else {
                        ao(i2, this.dZs.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.YJ = PagerSlidingTabStrip.this.dZs.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.YJ, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void ao(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        d(i, textView);
    }

    private void aJ(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.dZs.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.dZr.addView(view, i, this.dZw ? this.dZo : this.dZn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.dZt; i++) {
            View childAt = this.dZr.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dZH);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.dZE, this.dZF);
                    if (i == this.dZs.getCurrentItem()) {
                        textView.setTextColor(this.dZx);
                    } else {
                        textView.setTextColor(this.dXd);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dZt != 0) {
            int left = this.dZr.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dZy;
            }
            if (left != this.dZG) {
                this.dZG = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.dZt != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            this.dZv.setColor(this.dZx);
            View childAt = this.dZr.getChildAt(this.YJ);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.indicatorHeight, dimensionPixelSize + width, height), 10.0f, 10.0f, this.dZv);
        }
    }

    public void onChangeSkinType() {
        this.dZx = an.getColor(R.color.cp_cont_b);
        this.dXd = an.getColor(R.color.cp_cont_j);
        this.ebR = an.getColor(R.color.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.dZr.getChildCount() != 0) {
                PagerSlidingTabStrip.this.YJ = i;
                PagerSlidingTabStrip.this.dZu = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.dZr.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.dZq != null) {
                    PagerSlidingTabStrip.this.dZq.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.dZr.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.dZs.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.dZq != null) {
                    PagerSlidingTabStrip.this.dZq.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.dZq != null) {
                PagerSlidingTabStrip.this.dZq.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.YJ = savedState.YJ;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.YJ = this.YJ;
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
            /* renamed from: mo */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int YJ;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.YJ = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.YJ);
        }
    }
}
