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
    private int XM;
    private int dCa;
    private LinearLayout.LayoutParams dEf;
    private LinearLayout.LayoutParams dEg;
    public ViewPager.OnPageChangeListener dEi;
    private LinearLayout dEj;
    private ViewPager dEk;
    private int dEl;
    private float dEm;
    private Paint dEn;
    private boolean dEo;
    private int dEp;
    private int dEq;
    private Typeface dEw;
    private int dEx;
    private int dEy;
    private int dEz;
    private final b dGl;
    private int dGm;
    private int dGn;
    private int dGo;
    private int dividerPadding;
    private int indicatorHeight;
    private Locale locale;
    private int tabPadding;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int lg(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dGl = new b();
        this.XM = 0;
        this.dEm = 0.0f;
        this.dEo = false;
        this.dEp = am.getColor(R.color.cp_cont_b);
        this.dCa = am.getColor(R.color.cp_cont_j);
        this.dGm = am.getColor(R.color.cp_bg_line_c);
        this.dEq = 52;
        this.indicatorHeight = 4;
        this.dGn = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dGo = 1;
        this.tabTextSize = 12;
        this.dEw = null;
        this.dEx = 0;
        this.dEy = 0;
        this.dEz = R.drawable.pager_sliding_view;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dEj = new LinearLayout(getContext());
        this.dEj.setOrientation(0);
        this.dEj.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dEj);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.dEq = (int) TypedValue.applyDimension(1, this.dEq, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dGo = (int) TypedValue.applyDimension(1, this.dGo, displayMetrics);
        this.tabTextSize = i;
        this.indicatorHeight = i3;
        this.dGn = i2;
        this.dEo = z;
        this.dEn = new Paint();
        this.dEn.setAntiAlias(true);
        this.dEn.setStyle(Paint.Style.FILL);
        this.dEf = new LinearLayout.LayoutParams(-2, -1);
        this.dEg = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.dEk = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dGl);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dEi = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dEk != null && this.dEk.getAdapter() != null && this.dEk.getAdapter().getCount() != 0) {
            this.dEj.removeAllViews();
            this.dEl = this.dEk.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.dEl) {
                    if (this.dEk.getAdapter() instanceof a) {
                        aD(i2, ((a) this.dEk.getAdapter()).lg(i2));
                    } else {
                        ai(i2, this.dEk.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.XM = PagerSlidingTabStrip.this.dEk.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.XM, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void ai(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        d(i, textView);
    }

    private void aD(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.dEk.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.dEj.addView(view, i, this.dEo ? this.dEg : this.dEf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.dEl; i++) {
            View childAt = this.dEj.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dEz);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.dEw, this.dEx);
                    if (i == this.dEk.getCurrentItem()) {
                        textView.setTextColor(this.dEp);
                    } else {
                        textView.setTextColor(this.dCa);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dEl != 0) {
            int left = this.dEj.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dEq;
            }
            if (left != this.dEy) {
                this.dEy = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.dEl != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            this.dEn.setColor(this.dEp);
            View childAt = this.dEj.getChildAt(this.XM);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.indicatorHeight, dimensionPixelSize + width, height), 10.0f, 10.0f, this.dEn);
        }
    }

    public void onChangeSkinType() {
        this.dEp = am.getColor(R.color.cp_cont_b);
        this.dCa = am.getColor(R.color.cp_cont_j);
        this.dGm = am.getColor(R.color.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.dEj.getChildCount() != 0) {
                PagerSlidingTabStrip.this.XM = i;
                PagerSlidingTabStrip.this.dEm = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.dEj.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.dEi != null) {
                    PagerSlidingTabStrip.this.dEi.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.dEj.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.dEk.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.dEi != null) {
                    PagerSlidingTabStrip.this.dEi.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.dEi != null) {
                PagerSlidingTabStrip.this.dEi.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.XM = savedState.XM;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.XM = this.XM;
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
            /* renamed from: lt */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int XM;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.XM = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.XM);
        }
    }
}
