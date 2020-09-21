package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private int Zz;
    private int erA;
    private int erB;
    private int erC;
    private LinearLayout.LayoutParams eri;
    private LinearLayout.LayoutParams erj;
    private final b erk;
    public ViewPager.OnPageChangeListener erl;
    private LinearLayout erm;
    private ViewPager ern;
    private int ero;
    private float erp;
    private Paint erq;
    private boolean ers;
    private int ert;
    private int eru;
    private int erv;
    private int erw;
    private int erx;
    private int ery;
    private Typeface erz;
    private int indicatorHeight;
    private int indicatorWidth;
    private int scrollOffset;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int oL(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.erk = new b();
        this.Zz = 0;
        this.erp = 0.0f;
        this.ers = false;
        this.ert = ap.getColor(R.color.cp_cont_b);
        this.eru = ap.getColor(R.color.cp_cont_j);
        this.scrollOffset = 52;
        this.indicatorHeight = 4;
        this.erv = 24;
        this.erw = 24;
        this.erx = 24;
        this.ery = 24;
        this.indicatorWidth = 40;
        this.tabTextSize = 12;
        this.erz = null;
        this.erA = 0;
        this.erB = 0;
        this.erC = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.erm = new LinearLayout(getContext());
        this.erm.setOrientation(0);
        this.erm.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.erm);
        this.erq = new Paint();
        this.erq.setAntiAlias(true);
        this.erq.setStyle(Paint.Style.FILL);
        this.eri = new LinearLayout.LayoutParams(-2, -1);
        this.erj = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.tabTextSize = i;
        this.erv = i2;
        this.erw = i3;
        this.erx = i4;
        this.ery = i5;
        this.indicatorHeight = i6;
        this.indicatorWidth = i7;
        this.eru = i8;
        this.ert = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ern = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.erk);
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
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.Zz = CommonPagerSlidingTabStrip.this.ern.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.Zz, 0);
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
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.ern.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.erv, this.erw, this.erx, this.ery);
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
        if (!isInEditMode() && this.ero != 0 && this.erm.getChildCount() > 1) {
            int height = getHeight();
            this.erq.setColor(this.ert);
            View childAt = this.erm.getChildAt(this.Zz);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.erp > 0.0f && this.Zz < this.ero - 1) {
                View childAt2 = this.erm.getChildAt(this.Zz + 1);
                left = (left * (1.0f - this.erp)) + (childAt2.getLeft() * this.erp);
                right = (right * (1.0f - this.erp)) + (childAt2.getRight() * this.erp);
            }
            if (right - left < this.indicatorWidth) {
                canvas.drawRect(left, height - this.indicatorHeight, right, height, this.erq);
            } else {
                canvas.drawRect(left + (((right - left) - this.indicatorWidth) / 2.0f), height - this.indicatorHeight, right - (((right - left) - this.indicatorWidth) / 2.0f), height, this.erq);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.ert = ap.getColor(i, this.ert);
        this.eru = ap.getColor(i, this.eru);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.erm.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.Zz = i;
                CommonPagerSlidingTabStrip.this.erp = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.erm.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.erl != null) {
                    CommonPagerSlidingTabStrip.this.erl.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.erm.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.ern.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.erl != null) {
                    CommonPagerSlidingTabStrip.this.erl.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.erl != null) {
                CommonPagerSlidingTabStrip.this.erl.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
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
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: O */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: oM */
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
