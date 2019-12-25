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
    private int DX;
    private LinearLayout.LayoutParams cZQ;
    private LinearLayout.LayoutParams cZR;
    public ViewPager.OnPageChangeListener cZT;
    private LinearLayout cZU;
    private ViewPager cZV;
    private int cZW;
    private float cZX;
    private Paint cZY;
    private boolean cZZ;
    private int daa;
    private int dab;
    private int dac;
    private Typeface dai;
    private int daj;
    private int dak;
    private int dal;
    private final b dbY;
    private int dbZ;
    private int dca;
    private int dcb;
    private int dividerPadding;
    private int indicatorHeight;
    private Locale locale;
    private int tabPadding;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int kF(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dbY = new b();
        this.DX = 0;
        this.cZX = 0.0f;
        this.cZZ = false;
        this.daa = am.getColor(R.color.cp_cont_b);
        this.dab = am.getColor(R.color.cp_cont_j);
        this.dbZ = am.getColor(R.color.cp_bg_line_c);
        this.dac = 52;
        this.indicatorHeight = 4;
        this.dca = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dcb = 1;
        this.tabTextSize = 12;
        this.dai = null;
        this.daj = 0;
        this.dak = 0;
        this.dal = R.drawable.pager_sliding_view;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.cZU = new LinearLayout(getContext());
        this.cZU.setOrientation(0);
        this.cZU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.cZU);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.dac = (int) TypedValue.applyDimension(1, this.dac, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dcb = (int) TypedValue.applyDimension(1, this.dcb, displayMetrics);
        this.tabTextSize = i;
        this.indicatorHeight = i3;
        this.dca = i2;
        this.cZZ = z;
        this.cZY = new Paint();
        this.cZY.setAntiAlias(true);
        this.cZY.setStyle(Paint.Style.FILL);
        this.cZQ = new LinearLayout.LayoutParams(-2, -1);
        this.cZR = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.cZV = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dbY);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cZT = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.cZV != null && this.cZV.getAdapter() != null && this.cZV.getAdapter().getCount() != 0) {
            this.cZU.removeAllViews();
            this.cZW = this.cZV.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cZW) {
                    if (this.cZV.getAdapter() instanceof a) {
                        av(i2, ((a) this.cZV.getAdapter()).kF(i2));
                    } else {
                        N(i2, this.cZV.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.DX = PagerSlidingTabStrip.this.cZV.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.DX, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void N(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        d(i, textView);
    }

    private void av(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.cZV.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.cZU.addView(view, i, this.cZZ ? this.cZR : this.cZQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.cZW; i++) {
            View childAt = this.cZU.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dal);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.dai, this.daj);
                    if (i == this.cZV.getCurrentItem()) {
                        textView.setTextColor(this.daa);
                    } else {
                        textView.setTextColor(this.dab);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.cZW != 0) {
            int left = this.cZU.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dac;
            }
            if (left != this.dak) {
                this.dak = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.cZW != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            this.cZY.setColor(this.daa);
            View childAt = this.cZU.getChildAt(this.DX);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.indicatorHeight, dimensionPixelSize + width, height), 10.0f, 10.0f, this.cZY);
        }
    }

    public void onChangeSkinType() {
        this.daa = am.getColor(R.color.cp_cont_b);
        this.dab = am.getColor(R.color.cp_cont_j);
        this.dbZ = am.getColor(R.color.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.cZU.getChildCount() != 0) {
                PagerSlidingTabStrip.this.DX = i;
                PagerSlidingTabStrip.this.cZX = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.cZU.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.cZT != null) {
                    PagerSlidingTabStrip.this.cZT.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.cZU.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.cZV.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.cZT != null) {
                    PagerSlidingTabStrip.this.cZT.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.cZT != null) {
                PagerSlidingTabStrip.this.cZT.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.DX = savedState.DX;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.DX = this.DX;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: T */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: kS */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int DX;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.DX = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.DX);
        }
    }
}
