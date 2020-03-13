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
    private int Ev;
    private int deA;
    private float deB;
    private Paint deC;
    private boolean deD;
    private int deE;
    private int deF;
    private int deG;
    private Typeface deM;
    private int deN;
    private int deO;
    private int deP;
    private LinearLayout.LayoutParams deu;
    private LinearLayout.LayoutParams dev;
    public ViewPager.OnPageChangeListener dex;
    private LinearLayout dey;
    private ViewPager dez;
    private final b dgB;
    private int dgC;
    private int dgD;
    private int dgE;
    private int dividerPadding;
    private int indicatorHeight;
    private Locale locale;
    private int tabPadding;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int kW(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dgB = new b();
        this.Ev = 0;
        this.deB = 0.0f;
        this.deD = false;
        this.deE = am.getColor(R.color.cp_cont_b);
        this.deF = am.getColor(R.color.cp_cont_j);
        this.dgC = am.getColor(R.color.cp_bg_line_c);
        this.deG = 52;
        this.indicatorHeight = 4;
        this.dgD = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dgE = 1;
        this.tabTextSize = 12;
        this.deM = null;
        this.deN = 0;
        this.deO = 0;
        this.deP = R.drawable.pager_sliding_view;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dey = new LinearLayout(getContext());
        this.dey.setOrientation(0);
        this.dey.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dey);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.deG = (int) TypedValue.applyDimension(1, this.deG, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dgE = (int) TypedValue.applyDimension(1, this.dgE, displayMetrics);
        this.tabTextSize = i;
        this.indicatorHeight = i3;
        this.dgD = i2;
        this.deD = z;
        this.deC = new Paint();
        this.deC.setAntiAlias(true);
        this.deC.setStyle(Paint.Style.FILL);
        this.deu = new LinearLayout.LayoutParams(-2, -1);
        this.dev = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.dez = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dgB);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dex = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dez != null && this.dez.getAdapter() != null && this.dez.getAdapter().getCount() != 0) {
            this.dey.removeAllViews();
            this.deA = this.dez.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.deA) {
                    if (this.dez.getAdapter() instanceof a) {
                        az(i2, ((a) this.dez.getAdapter()).kW(i2));
                    } else {
                        R(i2, this.dez.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.Ev = PagerSlidingTabStrip.this.dez.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.Ev, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void R(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        d(i, textView);
    }

    private void az(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.dez.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.dey.addView(view, i, this.deD ? this.dev : this.deu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.deA; i++) {
            View childAt = this.dey.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.deP);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.deM, this.deN);
                    if (i == this.dez.getCurrentItem()) {
                        textView.setTextColor(this.deE);
                    } else {
                        textView.setTextColor(this.deF);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.deA != 0) {
            int left = this.dey.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.deG;
            }
            if (left != this.deO) {
                this.deO = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.deA != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            this.deC.setColor(this.deE);
            View childAt = this.dey.getChildAt(this.Ev);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.indicatorHeight, dimensionPixelSize + width, height), 10.0f, 10.0f, this.deC);
        }
    }

    public void onChangeSkinType() {
        this.deE = am.getColor(R.color.cp_cont_b);
        this.deF = am.getColor(R.color.cp_cont_j);
        this.dgC = am.getColor(R.color.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.dey.getChildCount() != 0) {
                PagerSlidingTabStrip.this.Ev = i;
                PagerSlidingTabStrip.this.deB = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.dey.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.dex != null) {
                    PagerSlidingTabStrip.this.dex.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.dey.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.dez.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.dex != null) {
                    PagerSlidingTabStrip.this.dex.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.dex != null) {
                PagerSlidingTabStrip.this.dex.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Ev = savedState.Ev;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Ev = this.Ev;
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
            /* renamed from: lj */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Ev;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Ev = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ev);
        }
    }
}
