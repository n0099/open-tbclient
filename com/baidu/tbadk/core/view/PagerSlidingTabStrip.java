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
    private int Ec;
    private LinearLayout.LayoutParams daa;
    private LinearLayout.LayoutParams dab;
    public ViewPager.OnPageChangeListener dad;
    private LinearLayout dae;
    private ViewPager daf;
    private int dag;
    private float dah;
    private Paint dai;
    private boolean daj;
    private int dak;
    private int dal;
    private int dam;
    private Typeface das;
    private int dat;
    private int dau;
    private int dav;
    private final b dci;
    private int dcj;
    private int dck;
    private int dcl;
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
        this.dci = new b();
        this.Ec = 0;
        this.dah = 0.0f;
        this.daj = false;
        this.dak = am.getColor(R.color.cp_cont_b);
        this.dal = am.getColor(R.color.cp_cont_j);
        this.dcj = am.getColor(R.color.cp_bg_line_c);
        this.dam = 52;
        this.indicatorHeight = 4;
        this.dck = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dcl = 1;
        this.tabTextSize = 12;
        this.das = null;
        this.dat = 0;
        this.dau = 0;
        this.dav = R.drawable.pager_sliding_view;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dae = new LinearLayout(getContext());
        this.dae.setOrientation(0);
        this.dae.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dae);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.dam = (int) TypedValue.applyDimension(1, this.dam, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dcl = (int) TypedValue.applyDimension(1, this.dcl, displayMetrics);
        this.tabTextSize = i;
        this.indicatorHeight = i3;
        this.dck = i2;
        this.daj = z;
        this.dai = new Paint();
        this.dai.setAntiAlias(true);
        this.dai.setStyle(Paint.Style.FILL);
        this.daa = new LinearLayout.LayoutParams(-2, -1);
        this.dab = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.daf = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dci);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dad = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.daf != null && this.daf.getAdapter() != null && this.daf.getAdapter().getCount() != 0) {
            this.dae.removeAllViews();
            this.dag = this.daf.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.dag) {
                    if (this.daf.getAdapter() instanceof a) {
                        az(i2, ((a) this.daf.getAdapter()).kF(i2));
                    } else {
                        P(i2, this.daf.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.Ec = PagerSlidingTabStrip.this.daf.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.Ec, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void P(int i, String str) {
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
                PagerSlidingTabStrip.this.daf.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.dae.addView(view, i, this.daj ? this.dab : this.daa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.dag; i++) {
            View childAt = this.dae.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dav);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.das, this.dat);
                    if (i == this.daf.getCurrentItem()) {
                        textView.setTextColor(this.dak);
                    } else {
                        textView.setTextColor(this.dal);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dag != 0) {
            int left = this.dae.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dam;
            }
            if (left != this.dau) {
                this.dau = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.dag != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            this.dai.setColor(this.dak);
            View childAt = this.dae.getChildAt(this.Ec);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.indicatorHeight, dimensionPixelSize + width, height), 10.0f, 10.0f, this.dai);
        }
    }

    public void onChangeSkinType() {
        this.dak = am.getColor(R.color.cp_cont_b);
        this.dal = am.getColor(R.color.cp_cont_j);
        this.dcj = am.getColor(R.color.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.dae.getChildCount() != 0) {
                PagerSlidingTabStrip.this.Ec = i;
                PagerSlidingTabStrip.this.dah = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.dae.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.dad != null) {
                    PagerSlidingTabStrip.this.dad.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.dae.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.daf.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.dad != null) {
                    PagerSlidingTabStrip.this.dad.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.dad != null) {
                PagerSlidingTabStrip.this.dad.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Ec = savedState.Ec;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Ec = this.Ec;
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
        int Ec;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Ec = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ec);
        }
    }
}
