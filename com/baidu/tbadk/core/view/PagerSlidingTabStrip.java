package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
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
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private int acR;
    private int dividerPadding;
    private int dividerWidth;
    private LinearLayout.LayoutParams fgE;
    private LinearLayout.LayoutParams fgF;
    public ViewPager.OnPageChangeListener fgH;
    private LinearLayout fgI;
    private ViewPager fgJ;
    private int fgK;
    private float fgL;
    private Paint fgM;
    private boolean fgN;
    private int fgO;
    private int fgP;
    private int fgQ;
    private int fgR;
    private int fgX;
    private Typeface fgY;
    private int fgZ;
    private int fha;
    private final b fjM;
    private int fjN;
    private int fjO;
    private Locale locale;
    private int tabBackgroundResId;
    private int tabPadding;

    /* loaded from: classes.dex */
    public interface a {
        int pp(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fjM = new b();
        this.acR = 0;
        this.fgL = 0.0f;
        this.fgN = false;
        this.fgO = ap.getColor(R.color.CAM_X0105);
        this.fgP = ap.getColor(R.color.CAM_X0107);
        this.fjN = ap.getColor(R.color.CAM_X0204);
        this.fgQ = 52;
        this.fgR = 4;
        this.fjO = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dividerWidth = 1;
        this.fgX = 12;
        this.fgY = null;
        this.fgZ = 0;
        this.fha = 0;
        this.tabBackgroundResId = R.drawable.pager_sliding_view;
    }

    public void c(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.fgI = new LinearLayout(getContext());
        this.fgI.setOrientation(0);
        this.fgI.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.fgI);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fgQ = (int) TypedValue.applyDimension(1, this.fgQ, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fgX = i;
        this.fgR = i3;
        this.fjO = i2;
        this.fgN = z;
        this.fgM = new Paint();
        this.fgM.setAntiAlias(true);
        this.fgM.setStyle(Paint.Style.FILL);
        this.fgE = new LinearLayout.LayoutParams(-2, -1);
        this.fgF = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.fgJ = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fjM);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fgH = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.fgJ != null && this.fgJ.getAdapter() != null && this.fgJ.getAdapter().getCount() != 0) {
            this.fgI.removeAllViews();
            this.fgK = this.fgJ.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fgK) {
                    if (this.fgJ.getAdapter() instanceof a) {
                        aP(i2, ((a) this.fgJ.getAdapter()).pp(i2));
                    } else {
                        aK(i2, this.fgJ.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.acR = PagerSlidingTabStrip.this.fgJ.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.acR, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void aK(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        d(i, textView);
    }

    private void aP(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.fgJ.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.fgI.addView(view, i, this.fgN ? this.fgF : this.fgE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.fgK; i++) {
            View childAt = this.fgI.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.tabBackgroundResId);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.fgX);
                    textView.setTypeface(this.fgY, this.fgZ);
                    if (i == this.fgJ.getCurrentItem()) {
                        textView.setTextColor(this.fgO);
                    } else {
                        textView.setTextColor(this.fgP);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.fgK != 0) {
            int left = this.fgI.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fgQ;
            }
            if (left != this.fha) {
                this.fha = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.fgK != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            this.fgM.setColor(this.fgO);
            View childAt = this.fgI.getChildAt(this.acR);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.fgR, dimensionPixelSize + width, height), 10.0f, 10.0f, this.fgM);
        }
    }

    public void onChangeSkinType() {
        this.fgO = ap.getColor(R.color.CAM_X0105);
        this.fgP = ap.getColor(R.color.CAM_X0107);
        this.fjN = ap.getColor(R.color.CAM_X0204);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.fgI.getChildCount() != 0) {
                PagerSlidingTabStrip.this.acR = i;
                PagerSlidingTabStrip.this.fgL = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.fgI.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.fgH != null) {
                    PagerSlidingTabStrip.this.fgH.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.fgI.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.fgJ.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.fgH != null) {
                    PagerSlidingTabStrip.this.fgH.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.fgH != null) {
                PagerSlidingTabStrip.this.fgH.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.acR = savedState.acR;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.acR = this.acR;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Q */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: pC */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int acR;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.acR = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.acR);
        }
    }
}
