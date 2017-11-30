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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams ajQ;
    private LinearLayout.LayoutParams ajR;
    private final b ajS;
    public ViewPager.OnPageChangeListener ajT;
    private LinearLayout ajU;
    private ViewPager ajV;
    private int ajW;
    private float ajX;
    private Paint ajY;
    private boolean ajZ;
    private int aka;
    private int akb;
    private int akc;
    private int akd;
    private int ake;
    private int akf;
    private int akg;
    private int akh;
    private int aki;
    private int akj;
    private Typeface akk;
    private int akl;
    private int akm;
    private int akn;
    private int currentPosition;

    /* loaded from: classes.dex */
    public interface a {
        int dc(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajS = new b();
        this.currentPosition = 0;
        this.ajX = 0.0f;
        this.ajZ = false;
        this.aka = aj.getColor(d.C0082d.cp_cont_b);
        this.akb = aj.getColor(d.C0082d.cp_cont_j);
        this.akc = 52;
        this.akd = 4;
        this.ake = 24;
        this.akf = 24;
        this.akg = 24;
        this.akh = 24;
        this.aki = 40;
        this.akj = 12;
        this.akk = null;
        this.akl = 0;
        this.akm = 0;
        this.akn = d.f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.ajU = new LinearLayout(getContext());
        this.ajU.setOrientation(0);
        this.ajU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.ajU);
        this.ajY = new Paint();
        this.ajY.setAntiAlias(true);
        this.ajY.setStyle(Paint.Style.FILL);
        this.ajQ = new LinearLayout.LayoutParams(-2, -1);
        this.ajR = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.akj = i;
        this.ake = i2;
        this.akf = i3;
        this.akg = i4;
        this.akh = i5;
        this.akd = i6;
        this.aki = i7;
        this.akb = i8;
        this.aka = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ajV = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.ajS);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ajT = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.ajV != null && this.ajV.getAdapter() != null && this.ajV.getAdapter().getCount() != 0) {
            this.ajU.removeAllViews();
            this.ajW = this.ajV.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ajW) {
                    if (this.ajV.getAdapter() instanceof a) {
                        w(i2, ((a) this.ajV.getAdapter()).dc(i2));
                    } else {
                        i(i2, this.ajV.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.currentPosition = CommonPagerSlidingTabStrip.this.ajV.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.currentPosition, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void i(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        a(i, textView);
    }

    private void w(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        a(i, imageButton);
    }

    private void a(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.ajV.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.ake, this.akf, this.akg, this.akh);
        this.ajU.addView(view, i, this.ajZ ? this.ajR : this.ajQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.ajW; i++) {
            View childAt = this.ajU.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.akn);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.akj);
                    textView.setTypeface(this.akk, this.akl);
                    if (i == this.ajV.getCurrentItem()) {
                        textView.setTextColor(this.aka);
                    } else {
                        textView.setTextColor(this.akb);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.ajW != 0) {
            int left = this.ajU.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.akc;
            }
            if (left != this.akm) {
                this.akm = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.ajW != 0 && this.ajU.getChildCount() > 1) {
            int height = getHeight();
            this.ajY.setColor(this.aka);
            View childAt = this.ajU.getChildAt(this.currentPosition);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.ajX > 0.0f && this.currentPosition < this.ajW - 1) {
                View childAt2 = this.ajU.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.ajX)) + (childAt2.getLeft() * this.ajX);
                right = (right * (1.0f - this.ajX)) + (childAt2.getRight() * this.ajX);
            }
            if (right - left < this.aki) {
                canvas.drawRect(left, height - this.akd, right, height, this.ajY);
            } else {
                canvas.drawRect(left + (((right - left) - this.aki) / 2.0f), height - this.akd, right - (((right - left) - this.aki) / 2.0f), height, this.ajY);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aka = aj.getColor(i, this.aka);
        this.akb = aj.getColor(i, this.akb);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.ajU.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.currentPosition = i;
                CommonPagerSlidingTabStrip.this.ajX = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.ajU.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.ajT != null) {
                    CommonPagerSlidingTabStrip.this.ajT.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.ajU.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.ajV.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.ajT != null) {
                    CommonPagerSlidingTabStrip.this.ajT.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.ajT != null) {
                CommonPagerSlidingTabStrip.this.ajT.onPageSelected(i);
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
            /* renamed from: e */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: dd */
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
