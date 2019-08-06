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
    private int Sw;
    private LinearLayout.LayoutParams bXG;
    private LinearLayout.LayoutParams bXH;
    public ViewPager.OnPageChangeListener bXJ;
    private LinearLayout bXK;
    private ViewPager bXL;
    private int bXM;
    private float bXN;
    private Paint bXO;
    private boolean bXP;
    private int bXQ;
    private int bXR;
    private int bXS;
    private int bXT;
    private int bXZ;
    private Typeface bYa;
    private int bYb;
    private int bYc;
    private int bYd;
    private final b cah;
    private int cai;
    private int caj;
    private int cak;
    private int dividerPadding;
    private Locale locale;
    private int tabPadding;

    /* loaded from: classes.dex */
    public interface a {
        int iA(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cah = new b();
        this.Sw = 0;
        this.bXN = 0.0f;
        this.bXP = false;
        this.bXQ = am.getColor(R.color.cp_cont_b);
        this.bXR = am.getColor(R.color.cp_cont_j);
        this.cai = am.getColor(R.color.cp_bg_line_c);
        this.bXS = 52;
        this.bXT = 4;
        this.caj = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.cak = 1;
        this.bXZ = 12;
        this.bYa = null;
        this.bYb = 0;
        this.bYc = 0;
        this.bYd = R.drawable.pager_sliding_view;
    }

    public void d(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bXK = new LinearLayout(getContext());
        this.bXK.setOrientation(0);
        this.bXK.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bXK);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.bXS = (int) TypedValue.applyDimension(1, this.bXS, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.cak = (int) TypedValue.applyDimension(1, this.cak, displayMetrics);
        this.bXZ = i;
        this.bXT = i3;
        this.caj = i2;
        this.bXP = z;
        this.bXO = new Paint();
        this.bXO.setAntiAlias(true);
        this.bXO.setStyle(Paint.Style.FILL);
        this.bXG = new LinearLayout.LayoutParams(-2, -1);
        this.bXH = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.bXL = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.cah);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bXJ = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bXL != null && this.bXL.getAdapter() != null && this.bXL.getAdapter().getCount() != 0) {
            this.bXK.removeAllViews();
            this.bXM = this.bXL.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bXM) {
                    if (this.bXL.getAdapter() instanceof a) {
                        aa(i2, ((a) this.bXL.getAdapter()).iA(i2));
                    } else {
                        D(i2, this.bXL.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.Sw = PagerSlidingTabStrip.this.bXL.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.Sw, 0);
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
                PagerSlidingTabStrip.this.bXL.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.bXK.addView(view, i, this.bXP ? this.bXH : this.bXG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.bXM; i++) {
            View childAt = this.bXK.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bYd);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.bXZ);
                    textView.setTypeface(this.bYa, this.bYb);
                    if (i == this.bXL.getCurrentItem()) {
                        textView.setTextColor(this.bXQ);
                    } else {
                        textView.setTextColor(this.bXR);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bXM != 0) {
            int left = this.bXK.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.bXS;
            }
            if (left != this.bYc) {
                this.bYc = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.bXM != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            this.bXO.setColor(this.bXQ);
            View childAt = this.bXK.getChildAt(this.Sw);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.bXT, dimensionPixelSize + width, height), 10.0f, 10.0f, this.bXO);
        }
    }

    public void onChangeSkinType() {
        this.bXQ = am.getColor(R.color.cp_cont_b);
        this.bXR = am.getColor(R.color.cp_cont_j);
        this.cai = am.getColor(R.color.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.bXK.getChildCount() != 0) {
                PagerSlidingTabStrip.this.Sw = i;
                PagerSlidingTabStrip.this.bXN = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.bXK.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.bXJ != null) {
                    PagerSlidingTabStrip.this.bXJ.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.bXK.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.bXL.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.bXJ != null) {
                    PagerSlidingTabStrip.this.bXJ.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.bXJ != null) {
                PagerSlidingTabStrip.this.bXJ.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Sw = savedState.Sw;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Sw = this.Sw;
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
            /* renamed from: iP */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Sw;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Sw = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Sw);
        }
    }
}
