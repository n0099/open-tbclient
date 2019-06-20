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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private int Se;
    public ViewPager.OnPageChangeListener bWB;
    private LinearLayout bWC;
    private ViewPager bWD;
    private int bWE;
    private float bWF;
    private Paint bWG;
    private boolean bWH;
    private int bWI;
    private int bWJ;
    private int bWK;
    private int bWL;
    private int bWR;
    private Typeface bWS;
    private int bWT;
    private int bWU;
    private int bWV;
    private LinearLayout.LayoutParams bWy;
    private LinearLayout.LayoutParams bWz;
    private final b bYZ;
    private int bZa;
    private int bZb;
    private int bZc;
    private int dividerPadding;
    private Locale locale;
    private int tabPadding;

    /* loaded from: classes.dex */
    public interface a {
        int iu(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bYZ = new b();
        this.Se = 0;
        this.bWF = 0.0f;
        this.bWH = false;
        this.bWI = al.getColor(R.color.cp_cont_b);
        this.bWJ = al.getColor(R.color.cp_cont_j);
        this.bZa = al.getColor(R.color.cp_bg_line_c);
        this.bWK = 52;
        this.bWL = 4;
        this.bZb = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.bZc = 1;
        this.bWR = 12;
        this.bWS = null;
        this.bWT = 0;
        this.bWU = 0;
        this.bWV = R.drawable.pager_sliding_view;
    }

    public void d(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bWC = new LinearLayout(getContext());
        this.bWC.setOrientation(0);
        this.bWC.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bWC);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.bWK = (int) TypedValue.applyDimension(1, this.bWK, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.bZc = (int) TypedValue.applyDimension(1, this.bZc, displayMetrics);
        this.bWR = i;
        this.bWL = i3;
        this.bZb = i2;
        this.bWH = z;
        this.bWG = new Paint();
        this.bWG.setAntiAlias(true);
        this.bWG.setStyle(Paint.Style.FILL);
        this.bWy = new LinearLayout.LayoutParams(-2, -1);
        this.bWz = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.bWD = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.bYZ);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bWB = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bWD != null && this.bWD.getAdapter() != null && this.bWD.getAdapter().getCount() != 0) {
            this.bWC.removeAllViews();
            this.bWE = this.bWD.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bWE) {
                    if (this.bWD.getAdapter() instanceof a) {
                        X(i2, ((a) this.bWD.getAdapter()).iu(i2));
                    } else {
                        D(i2, this.bWD.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.Se = PagerSlidingTabStrip.this.bWD.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.Se, 0);
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

    private void X(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        e(i, imageButton);
    }

    private void e(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.bWD.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.bWC.addView(view, i, this.bWH ? this.bWz : this.bWy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.bWE; i++) {
            View childAt = this.bWC.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bWV);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.bWR);
                    textView.setTypeface(this.bWS, this.bWT);
                    if (i == this.bWD.getCurrentItem()) {
                        textView.setTextColor(this.bWI);
                    } else {
                        textView.setTextColor(this.bWJ);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bWE != 0) {
            int left = this.bWC.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.bWK;
            }
            if (left != this.bWU) {
                this.bWU = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.bWE != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            this.bWG.setColor(this.bWI);
            View childAt = this.bWC.getChildAt(this.Se);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.bWL, dimensionPixelSize + width, height), 10.0f, 10.0f, this.bWG);
        }
    }

    public void onChangeSkinType() {
        this.bWI = al.getColor(R.color.cp_cont_b);
        this.bWJ = al.getColor(R.color.cp_cont_j);
        this.bZa = al.getColor(R.color.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.bWC.getChildCount() != 0) {
                PagerSlidingTabStrip.this.Se = i;
                PagerSlidingTabStrip.this.bWF = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.bWC.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.bWB != null) {
                    PagerSlidingTabStrip.this.bWB.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.bWC.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.bWD.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.bWB != null) {
                    PagerSlidingTabStrip.this.bWB.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.bWB != null) {
                PagerSlidingTabStrip.this.bWB.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Se = savedState.Se;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Se = this.Se;
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
            /* renamed from: iJ */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Se;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Se = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Se);
        }
    }
}
