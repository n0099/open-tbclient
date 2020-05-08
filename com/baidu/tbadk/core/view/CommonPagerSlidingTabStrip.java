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
    private int XP;
    private int dCe;
    private Typeface dEA;
    private int dEB;
    private int dEC;
    private int dED;
    private LinearLayout.LayoutParams dEj;
    private LinearLayout.LayoutParams dEk;
    private final b dEl;
    public ViewPager.OnPageChangeListener dEm;
    private LinearLayout dEn;
    private ViewPager dEo;
    private int dEp;
    private float dEq;
    private Paint dEr;
    private boolean dEs;
    private int dEt;
    private int dEu;
    private int dEv;
    private int dEw;
    private int dEx;
    private int dEy;
    private int dEz;
    private int indicatorHeight;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int lg(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dEl = new b();
        this.XP = 0;
        this.dEq = 0.0f;
        this.dEs = false;
        this.dEt = am.getColor(R.color.cp_cont_b);
        this.dCe = am.getColor(R.color.cp_cont_j);
        this.dEu = 52;
        this.indicatorHeight = 4;
        this.dEv = 24;
        this.dEw = 24;
        this.dEx = 24;
        this.dEy = 24;
        this.dEz = 40;
        this.tabTextSize = 12;
        this.dEA = null;
        this.dEB = 0;
        this.dEC = 0;
        this.dED = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dEn = new LinearLayout(getContext());
        this.dEn.setOrientation(0);
        this.dEn.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dEn);
        this.dEr = new Paint();
        this.dEr.setAntiAlias(true);
        this.dEr.setStyle(Paint.Style.FILL);
        this.dEj = new LinearLayout.LayoutParams(-2, -1);
        this.dEk = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.tabTextSize = i;
        this.dEv = i2;
        this.dEw = i3;
        this.dEx = i4;
        this.dEy = i5;
        this.indicatorHeight = i6;
        this.dEz = i7;
        this.dCe = i8;
        this.dEt = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dEo = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dEl);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dEm = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dEo != null && this.dEo.getAdapter() != null && this.dEo.getAdapter().getCount() != 0) {
            this.dEn.removeAllViews();
            this.dEp = this.dEo.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.dEp) {
                    if (this.dEo.getAdapter() instanceof a) {
                        aD(i2, ((a) this.dEo.getAdapter()).lg(i2));
                    } else {
                        ai(i2, this.dEo.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.XP = CommonPagerSlidingTabStrip.this.dEo.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.XP, 0);
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
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.dEo.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.dEv, this.dEw, this.dEx, this.dEy);
        this.dEn.addView(view, i, this.dEs ? this.dEk : this.dEj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.dEp; i++) {
            View childAt = this.dEn.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dED);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.dEA, this.dEB);
                    if (i == this.dEo.getCurrentItem()) {
                        textView.setTextColor(this.dEt);
                    } else {
                        textView.setTextColor(this.dCe);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dEp != 0) {
            int left = this.dEn.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dEu;
            }
            if (left != this.dEC) {
                this.dEC = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.dEp != 0 && this.dEn.getChildCount() > 1) {
            int height = getHeight();
            this.dEr.setColor(this.dEt);
            View childAt = this.dEn.getChildAt(this.XP);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.dEq > 0.0f && this.XP < this.dEp - 1) {
                View childAt2 = this.dEn.getChildAt(this.XP + 1);
                left = (left * (1.0f - this.dEq)) + (childAt2.getLeft() * this.dEq);
                right = (right * (1.0f - this.dEq)) + (childAt2.getRight() * this.dEq);
            }
            if (right - left < this.dEz) {
                canvas.drawRect(left, height - this.indicatorHeight, right, height, this.dEr);
            } else {
                canvas.drawRect(left + (((right - left) - this.dEz) / 2.0f), height - this.indicatorHeight, right - (((right - left) - this.dEz) / 2.0f), height, this.dEr);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.dEt = am.getColor(i, this.dEt);
        this.dCe = am.getColor(i, this.dCe);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.dEn.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.XP = i;
                CommonPagerSlidingTabStrip.this.dEq = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.dEn.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.dEm != null) {
                    CommonPagerSlidingTabStrip.this.dEm.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.dEn.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.dEo.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.dEm != null) {
                    CommonPagerSlidingTabStrip.this.dEm.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.dEm != null) {
                CommonPagerSlidingTabStrip.this.dEm.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.XP = savedState.XP;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.XP = this.XP;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: L */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: lh */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int XP;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.XP = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.XP);
        }
    }
}
