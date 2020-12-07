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
    private int aaR;
    private int dividerPadding;
    private int dividerWidth;
    private LinearLayout.LayoutParams eXY;
    private LinearLayout.LayoutParams eXZ;
    public ViewPager.OnPageChangeListener eYb;
    private LinearLayout eYc;
    private ViewPager eYd;
    private int eYe;
    private float eYf;
    private Paint eYg;
    private boolean eYh;
    private int eYi;
    private int eYj;
    private int eYk;
    private Typeface eYq;
    private int eYr;
    private int eYs;
    private int eYt;
    private final b fbb;
    private int fbc;
    private int fbd;
    private int indicatorHeight;
    private Locale locale;
    private int tabPadding;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int qE(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fbb = new b();
        this.aaR = 0;
        this.eYf = 0.0f;
        this.eYh = false;
        this.eYi = ap.getColor(R.color.CAM_X0105);
        this.eYj = ap.getColor(R.color.CAM_X0107);
        this.fbc = ap.getColor(R.color.CAM_X0204);
        this.eYk = 52;
        this.indicatorHeight = 4;
        this.fbd = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dividerWidth = 1;
        this.tabTextSize = 12;
        this.eYq = null;
        this.eYr = 0;
        this.eYs = 0;
        this.eYt = R.drawable.pager_sliding_view;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.eYc = new LinearLayout(getContext());
        this.eYc.setOrientation(0);
        this.eYc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.eYc);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.eYk = (int) TypedValue.applyDimension(1, this.eYk, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.tabTextSize = i;
        this.indicatorHeight = i3;
        this.fbd = i2;
        this.eYh = z;
        this.eYg = new Paint();
        this.eYg.setAntiAlias(true);
        this.eYg.setStyle(Paint.Style.FILL);
        this.eXY = new LinearLayout.LayoutParams(-2, -1);
        this.eXZ = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.eYd = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fbb);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eYb = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.eYd != null && this.eYd.getAdapter() != null && this.eYd.getAdapter().getCount() != 0) {
            this.eYc.removeAllViews();
            this.eYe = this.eYd.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eYe) {
                    if (this.eYd.getAdapter() instanceof a) {
                        aU(i2, ((a) this.eYd.getAdapter()).qE(i2));
                    } else {
                        aD(i2, this.eYd.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.aaR = PagerSlidingTabStrip.this.eYd.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aaR, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void aD(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        d(i, textView);
    }

    private void aU(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.eYd.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.eYc.addView(view, i, this.eYh ? this.eXZ : this.eXY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.eYe; i++) {
            View childAt = this.eYc.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eYt);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.eYq, this.eYr);
                    if (i == this.eYd.getCurrentItem()) {
                        textView.setTextColor(this.eYi);
                    } else {
                        textView.setTextColor(this.eYj);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eYe != 0) {
            int left = this.eYc.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.eYk;
            }
            if (left != this.eYs) {
                this.eYs = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.eYe != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            this.eYg.setColor(this.eYi);
            View childAt = this.eYc.getChildAt(this.aaR);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.indicatorHeight, dimensionPixelSize + width, height), 10.0f, 10.0f, this.eYg);
        }
    }

    public void onChangeSkinType() {
        this.eYi = ap.getColor(R.color.CAM_X0105);
        this.eYj = ap.getColor(R.color.CAM_X0107);
        this.fbc = ap.getColor(R.color.CAM_X0204);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.eYc.getChildCount() != 0) {
                PagerSlidingTabStrip.this.aaR = i;
                PagerSlidingTabStrip.this.eYf = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.eYc.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.eYb != null) {
                    PagerSlidingTabStrip.this.eYb.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.eYc.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.eYd.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.eYb != null) {
                    PagerSlidingTabStrip.this.eYb.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.eYb != null) {
                PagerSlidingTabStrip.this.eYb.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aaR = savedState.aaR;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aaR = this.aaR;
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
            /* renamed from: qR */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int aaR;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aaR = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aaR);
        }
    }
}
