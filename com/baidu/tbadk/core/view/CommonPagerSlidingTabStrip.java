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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private int alA;
    private int alB;
    private int alC;
    private int alD;
    private Typeface alE;
    private int alF;
    private int alG;
    private int alH;
    private LinearLayout.LayoutParams alj;
    private LinearLayout.LayoutParams alk;
    private final b alm;
    public ViewPager.OnPageChangeListener aln;
    private LinearLayout alo;
    private ViewPager alp;
    private int alq;
    private float alr;
    private Paint als;
    private boolean alt;
    private int alu;
    private int alv;
    private int alw;
    private int alx;
    private int aly;
    private int alz;
    private int currentPosition;

    /* loaded from: classes.dex */
    public interface a {
        int db(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alm = new b();
        this.currentPosition = 0;
        this.alr = 0.0f;
        this.alt = false;
        this.alu = ak.getColor(d.C0126d.cp_cont_b);
        this.alv = ak.getColor(d.C0126d.cp_cont_j);
        this.alw = 52;
        this.alx = 4;
        this.aly = 24;
        this.alz = 24;
        this.alA = 24;
        this.alB = 24;
        this.alC = 40;
        this.alD = 12;
        this.alE = null;
        this.alF = 0;
        this.alG = 0;
        this.alH = d.f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.alo = new LinearLayout(getContext());
        this.alo.setOrientation(0);
        this.alo.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.alo);
        this.als = new Paint();
        this.als.setAntiAlias(true);
        this.als.setStyle(Paint.Style.FILL);
        this.alj = new LinearLayout.LayoutParams(-2, -1);
        this.alk = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.alD = i;
        this.aly = i2;
        this.alz = i3;
        this.alA = i4;
        this.alB = i5;
        this.alx = i6;
        this.alC = i7;
        this.alv = i8;
        this.alu = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.alp = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.alm);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aln = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.alp != null && this.alp.getAdapter() != null && this.alp.getAdapter().getCount() != 0) {
            this.alo.removeAllViews();
            this.alq = this.alp.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.alq) {
                    if (this.alp.getAdapter() instanceof a) {
                        w(i2, ((a) this.alp.getAdapter()).db(i2));
                    } else {
                        h(i2, this.alp.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.currentPosition = CommonPagerSlidingTabStrip.this.alp.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.currentPosition, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void h(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        b(i, textView);
    }

    private void w(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        b(i, imageButton);
    }

    private void b(final int i, View view2) {
        view2.setFocusable(true);
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                CommonPagerSlidingTabStrip.this.alp.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view2.setPadding(this.aly, this.alz, this.alA, this.alB);
        this.alo.addView(view2, i, this.alt ? this.alk : this.alj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.alq; i++) {
            View childAt = this.alo.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.alH);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.alD);
                    textView.setTypeface(this.alE, this.alF);
                    if (i == this.alp.getCurrentItem()) {
                        textView.setTextColor(this.alu);
                    } else {
                        textView.setTextColor(this.alv);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.alq != 0) {
            int left = this.alo.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.alw;
            }
            if (left != this.alG) {
                this.alG = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.alq != 0 && this.alo.getChildCount() > 1) {
            int height = getHeight();
            this.als.setColor(this.alu);
            View childAt = this.alo.getChildAt(this.currentPosition);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.alr > 0.0f && this.currentPosition < this.alq - 1) {
                View childAt2 = this.alo.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.alr)) + (childAt2.getLeft() * this.alr);
                right = (right * (1.0f - this.alr)) + (childAt2.getRight() * this.alr);
            }
            if (right - left < this.alC) {
                canvas.drawRect(left, height - this.alx, right, height, this.als);
            } else {
                canvas.drawRect(left + (((right - left) - this.alC) / 2.0f), height - this.alx, right - (((right - left) - this.alC) / 2.0f), height, this.als);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.alu = ak.getColor(i, this.alu);
        this.alv = ak.getColor(i, this.alv);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.alo.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.currentPosition = i;
                CommonPagerSlidingTabStrip.this.alr = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.alo.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.aln != null) {
                    CommonPagerSlidingTabStrip.this.aln.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.alo.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.alp.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.aln != null) {
                    CommonPagerSlidingTabStrip.this.aln.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.aln != null) {
                CommonPagerSlidingTabStrip.this.aln.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.currentPosition = savedState.currentPosition;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.currentPosition = this.currentPosition;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: f */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: dc */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int currentPosition;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.currentPosition = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.currentPosition);
        }
    }
}
