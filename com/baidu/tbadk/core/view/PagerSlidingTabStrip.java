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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private int abC;
    private int dividerPadding;
    private int dividerWidth;
    public ViewPager.OnPageChangeListener fhB;
    private LinearLayout fhC;
    private ViewPager fhD;
    private int fhE;
    private float fhF;
    private Paint fhG;
    private boolean fhH;
    private int fhI;
    private int fhJ;
    private int fhK;
    private int fhL;
    private int fhR;
    private Typeface fhS;
    private int fhT;
    private int fhU;
    private LinearLayout.LayoutParams fhy;
    private LinearLayout.LayoutParams fhz;
    private final b fkF;
    private int fkG;
    private int fkH;
    private Locale locale;
    private int tabBackgroundResId;
    private int tabPadding;

    /* loaded from: classes.dex */
    public interface a {
        int qP(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fkF = new b();
        this.abC = 0;
        this.fhF = 0.0f;
        this.fhH = false;
        this.fhI = ao.getColor(R.color.CAM_X0105);
        this.fhJ = ao.getColor(R.color.CAM_X0107);
        this.fkG = ao.getColor(R.color.CAM_X0204);
        this.fhK = 52;
        this.fhL = 4;
        this.fkH = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dividerWidth = 1;
        this.fhR = 12;
        this.fhS = null;
        this.fhT = 0;
        this.fhU = 0;
        this.tabBackgroundResId = R.drawable.pager_sliding_view;
    }

    public void c(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.fhC = new LinearLayout(getContext());
        this.fhC.setOrientation(0);
        this.fhC.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.fhC);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fhK = (int) TypedValue.applyDimension(1, this.fhK, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fhR = i;
        this.fhL = i3;
        this.fkH = i2;
        this.fhH = z;
        this.fhG = new Paint();
        this.fhG.setAntiAlias(true);
        this.fhG.setStyle(Paint.Style.FILL);
        this.fhy = new LinearLayout.LayoutParams(-2, -1);
        this.fhz = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.fhD = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fkF);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fhB = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.fhD != null && this.fhD.getAdapter() != null && this.fhD.getAdapter().getCount() != 0) {
            this.fhC.removeAllViews();
            this.fhE = this.fhD.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fhE) {
                    if (this.fhD.getAdapter() instanceof a) {
                        aS(i2, ((a) this.fhD.getAdapter()).qP(i2));
                    } else {
                        aF(i2, this.fhD.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.abC = PagerSlidingTabStrip.this.fhD.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.abC, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void aF(int i, String str) {
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
                PagerSlidingTabStrip.this.fhD.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.fhC.addView(view, i, this.fhH ? this.fhz : this.fhy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.fhE; i++) {
            View childAt = this.fhC.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.tabBackgroundResId);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.fhR);
                    textView.setTypeface(this.fhS, this.fhT);
                    if (i == this.fhD.getCurrentItem()) {
                        textView.setTextColor(this.fhI);
                    } else {
                        textView.setTextColor(this.fhJ);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.fhE != 0) {
            int left = this.fhC.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fhK;
            }
            if (left != this.fhU) {
                this.fhU = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.fhE != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            this.fhG.setColor(this.fhI);
            View childAt = this.fhC.getChildAt(this.abC);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.fhL, dimensionPixelSize + width, height), 10.0f, 10.0f, this.fhG);
        }
    }

    public void onChangeSkinType() {
        this.fhI = ao.getColor(R.color.CAM_X0105);
        this.fhJ = ao.getColor(R.color.CAM_X0107);
        this.fkG = ao.getColor(R.color.CAM_X0204);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.fhC.getChildCount() != 0) {
                PagerSlidingTabStrip.this.abC = i;
                PagerSlidingTabStrip.this.fhF = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.fhC.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.fhB != null) {
                    PagerSlidingTabStrip.this.fhB.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.fhC.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.fhD.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.fhB != null) {
                    PagerSlidingTabStrip.this.fhB.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.fhB != null) {
                PagerSlidingTabStrip.this.fhB.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.abC = savedState.abC;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.abC = this.abC;
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
            /* renamed from: rc */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int abC;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.abC = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.abC);
        }
    }
}
