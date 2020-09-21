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
    private int Zz;
    private int dividerPadding;
    private int dividerWidth;
    private int erA;
    private int erB;
    private int erC;
    private LinearLayout.LayoutParams eri;
    private LinearLayout.LayoutParams erj;
    public ViewPager.OnPageChangeListener erl;
    private LinearLayout erm;
    private ViewPager ern;
    private int ero;
    private float erp;
    private Paint erq;
    private boolean ers;
    private int ert;
    private int eru;
    private Typeface erz;
    private final b euc;
    private int eud;
    private int indicatorHeight;
    private Locale locale;
    private int scrollOffset;
    private int tabPadding;
    private int tabTextSize;
    private int underlineHeight;

    /* loaded from: classes.dex */
    public interface a {
        int oL(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.euc = new b();
        this.Zz = 0;
        this.erp = 0.0f;
        this.ers = false;
        this.ert = ap.getColor(R.color.cp_cont_b);
        this.eru = ap.getColor(R.color.cp_cont_j);
        this.eud = ap.getColor(R.color.cp_bg_line_c);
        this.scrollOffset = 52;
        this.indicatorHeight = 4;
        this.underlineHeight = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dividerWidth = 1;
        this.tabTextSize = 12;
        this.erz = null;
        this.erA = 0;
        this.erB = 0;
        this.erC = R.drawable.pager_sliding_view;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.erm = new LinearLayout(getContext());
        this.erm.setOrientation(0);
        this.erm.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.erm);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.scrollOffset = (int) TypedValue.applyDimension(1, this.scrollOffset, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.tabTextSize = i;
        this.indicatorHeight = i3;
        this.underlineHeight = i2;
        this.ers = z;
        this.erq = new Paint();
        this.erq.setAntiAlias(true);
        this.erq.setStyle(Paint.Style.FILL);
        this.eri = new LinearLayout.LayoutParams(-2, -1);
        this.erj = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.ern = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.euc);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.erl = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.ern != null && this.ern.getAdapter() != null && this.ern.getAdapter().getCount() != 0) {
            this.erm.removeAllViews();
            this.ero = this.ern.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ero) {
                    if (this.ern.getAdapter() instanceof a) {
                        aS(i2, ((a) this.ern.getAdapter()).oL(i2));
                    } else {
                        ao(i2, this.ern.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.Zz = PagerSlidingTabStrip.this.ern.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.Zz, 0);
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
                PagerSlidingTabStrip.this.ern.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.erm.addView(view, i, this.ers ? this.erj : this.eri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.ero; i++) {
            View childAt = this.erm.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.erC);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.erz, this.erA);
                    if (i == this.ern.getCurrentItem()) {
                        textView.setTextColor(this.ert);
                    } else {
                        textView.setTextColor(this.eru);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.ero != 0) {
            int left = this.erm.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.scrollOffset;
            }
            if (left != this.erB) {
                this.erB = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.ero != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            this.erq.setColor(this.ert);
            View childAt = this.erm.getChildAt(this.Zz);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.indicatorHeight, dimensionPixelSize + width, height), 10.0f, 10.0f, this.erq);
        }
    }

    public void onChangeSkinType() {
        this.ert = ap.getColor(R.color.cp_cont_b);
        this.eru = ap.getColor(R.color.cp_cont_j);
        this.eud = ap.getColor(R.color.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.erm.getChildCount() != 0) {
                PagerSlidingTabStrip.this.Zz = i;
                PagerSlidingTabStrip.this.erp = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.erm.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.erl != null) {
                    PagerSlidingTabStrip.this.erl.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.erm.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.ern.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.erl != null) {
                    PagerSlidingTabStrip.this.erl.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.erl != null) {
                PagerSlidingTabStrip.this.erl.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Zz = savedState.Zz;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Zz = this.Zz;
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
            /* renamed from: oY */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Zz;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Zz = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Zz);
        }
    }
}
