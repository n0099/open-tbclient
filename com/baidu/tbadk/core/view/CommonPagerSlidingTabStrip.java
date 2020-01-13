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
    private int Ec;
    private LinearLayout.LayoutParams daa;
    private LinearLayout.LayoutParams dab;
    private final b dac;
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
    private int dan;
    private int dao;
    private int dap;
    private int daq;
    private int dar;
    private Typeface das;
    private int dat;
    private int dau;
    private int dav;
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
        this.dac = new b();
        this.Ec = 0;
        this.dah = 0.0f;
        this.daj = false;
        this.dak = am.getColor(R.color.cp_cont_b);
        this.dal = am.getColor(R.color.cp_cont_j);
        this.dam = 52;
        this.indicatorHeight = 4;
        this.dan = 24;
        this.dao = 24;
        this.dap = 24;
        this.daq = 24;
        this.dar = 40;
        this.tabTextSize = 12;
        this.das = null;
        this.dat = 0;
        this.dau = 0;
        this.dav = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dae = new LinearLayout(getContext());
        this.dae.setOrientation(0);
        this.dae.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dae);
        this.dai = new Paint();
        this.dai.setAntiAlias(true);
        this.dai.setStyle(Paint.Style.FILL);
        this.daa = new LinearLayout.LayoutParams(-2, -1);
        this.dab = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.tabTextSize = i;
        this.dan = i2;
        this.dao = i3;
        this.dap = i4;
        this.daq = i5;
        this.indicatorHeight = i6;
        this.dar = i7;
        this.dal = i8;
        this.dak = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.daf = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dac);
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
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.Ec = CommonPagerSlidingTabStrip.this.daf.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.Ec, 0);
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
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.daf.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.dan, this.dao, this.dap, this.daq);
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
        if (!isInEditMode() && this.dag != 0 && this.dae.getChildCount() > 1) {
            int height = getHeight();
            this.dai.setColor(this.dak);
            View childAt = this.dae.getChildAt(this.Ec);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.dah > 0.0f && this.Ec < this.dag - 1) {
                View childAt2 = this.dae.getChildAt(this.Ec + 1);
                left = (left * (1.0f - this.dah)) + (childAt2.getLeft() * this.dah);
                right = (right * (1.0f - this.dah)) + (childAt2.getRight() * this.dah);
            }
            if (right - left < this.dar) {
                canvas.drawRect(left, height - this.indicatorHeight, right, height, this.dai);
            } else {
                canvas.drawRect(left + (((right - left) - this.dar) / 2.0f), height - this.indicatorHeight, right - (((right - left) - this.dar) / 2.0f), height, this.dai);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.dak = am.getColor(i, this.dak);
        this.dal = am.getColor(i, this.dal);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.dae.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.Ec = i;
                CommonPagerSlidingTabStrip.this.dah = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.dae.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.dad != null) {
                    CommonPagerSlidingTabStrip.this.dad.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.dae.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.daf.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.dad != null) {
                    CommonPagerSlidingTabStrip.this.dad.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.dad != null) {
                CommonPagerSlidingTabStrip.this.dad.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
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
