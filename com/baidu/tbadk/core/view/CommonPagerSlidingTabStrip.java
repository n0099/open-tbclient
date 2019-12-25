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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private int DX;
    private LinearLayout.LayoutParams cZQ;
    private LinearLayout.LayoutParams cZR;
    private final b cZS;
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
    private int dad;
    private int dae;
    private int daf;
    private int dag;
    private int dah;
    private Typeface dai;
    private int daj;
    private int dak;
    private int dal;
    private int indicatorHeight;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int kF(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cZS = new b();
        this.DX = 0;
        this.cZX = 0.0f;
        this.cZZ = false;
        this.daa = am.getColor(R.color.cp_cont_b);
        this.dab = am.getColor(R.color.cp_cont_j);
        this.dac = 52;
        this.indicatorHeight = 4;
        this.dad = 24;
        this.dae = 24;
        this.daf = 24;
        this.dag = 24;
        this.dah = 40;
        this.tabTextSize = 12;
        this.dai = null;
        this.daj = 0;
        this.dak = 0;
        this.dal = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.cZU = new LinearLayout(getContext());
        this.cZU.setOrientation(0);
        this.cZU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.cZU);
        this.cZY = new Paint();
        this.cZY.setAntiAlias(true);
        this.cZY.setStyle(Paint.Style.FILL);
        this.cZQ = new LinearLayout.LayoutParams(-2, -1);
        this.cZR = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.tabTextSize = i;
        this.dad = i2;
        this.dae = i3;
        this.daf = i4;
        this.dag = i5;
        this.indicatorHeight = i6;
        this.dah = i7;
        this.dab = i8;
        this.daa = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.cZV = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.cZS);
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
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.DX = CommonPagerSlidingTabStrip.this.cZV.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.DX, 0);
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
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.cZV.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.dad, this.dae, this.daf, this.dag);
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
        if (!isInEditMode() && this.cZW != 0 && this.cZU.getChildCount() > 1) {
            int height = getHeight();
            this.cZY.setColor(this.daa);
            View childAt = this.cZU.getChildAt(this.DX);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.cZX > 0.0f && this.DX < this.cZW - 1) {
                View childAt2 = this.cZU.getChildAt(this.DX + 1);
                left = (left * (1.0f - this.cZX)) + (childAt2.getLeft() * this.cZX);
                right = (right * (1.0f - this.cZX)) + (childAt2.getRight() * this.cZX);
            }
            if (right - left < this.dah) {
                canvas.drawRect(left, height - this.indicatorHeight, right, height, this.cZY);
            } else {
                canvas.drawRect(left + (((right - left) - this.dah) / 2.0f), height - this.indicatorHeight, right - (((right - left) - this.dah) / 2.0f), height, this.cZY);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.daa = am.getColor(i, this.daa);
        this.dab = am.getColor(i, this.dab);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.cZU.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.DX = i;
                CommonPagerSlidingTabStrip.this.cZX = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.cZU.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.cZT != null) {
                    CommonPagerSlidingTabStrip.this.cZT.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.cZU.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.cZV.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.cZT != null) {
                    CommonPagerSlidingTabStrip.this.cZT.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.cZT != null) {
                CommonPagerSlidingTabStrip.this.cZT.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
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
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: S */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: kG */
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
