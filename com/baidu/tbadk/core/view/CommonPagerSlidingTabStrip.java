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
    private LinearLayout.LayoutParams ajN;
    private LinearLayout.LayoutParams ajO;
    private final b ajP;
    public ViewPager.OnPageChangeListener ajQ;
    private LinearLayout ajR;
    private ViewPager ajS;
    private int ajT;
    private float ajU;
    private Paint ajV;
    private boolean ajW;
    private int ajX;
    private int ajY;
    private int ajZ;
    private int aka;
    private int akb;
    private int akc;
    private int akd;
    private int ake;
    private int akf;
    private int akg;
    private Typeface akh;
    private int aki;
    private int akj;
    private int akk;
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
        this.ajP = new b();
        this.currentPosition = 0;
        this.ajU = 0.0f;
        this.ajW = false;
        this.ajX = aj.getColor(d.C0096d.cp_cont_b);
        this.ajY = aj.getColor(d.C0096d.cp_cont_j);
        this.ajZ = 52;
        this.aka = 4;
        this.akb = 24;
        this.akc = 24;
        this.akd = 24;
        this.ake = 24;
        this.akf = 40;
        this.akg = 12;
        this.akh = null;
        this.aki = 0;
        this.akj = 0;
        this.akk = d.f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.ajR = new LinearLayout(getContext());
        this.ajR.setOrientation(0);
        this.ajR.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.ajR);
        this.ajV = new Paint();
        this.ajV.setAntiAlias(true);
        this.ajV.setStyle(Paint.Style.FILL);
        this.ajN = new LinearLayout.LayoutParams(-2, -1);
        this.ajO = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.akg = i;
        this.akb = i2;
        this.akc = i3;
        this.akd = i4;
        this.ake = i5;
        this.aka = i6;
        this.akf = i7;
        this.ajY = i8;
        this.ajX = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ajS = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.ajP);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ajQ = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.ajS != null && this.ajS.getAdapter() != null && this.ajS.getAdapter().getCount() != 0) {
            this.ajR.removeAllViews();
            this.ajT = this.ajS.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ajT) {
                    if (this.ajS.getAdapter() instanceof a) {
                        x(i2, ((a) this.ajS.getAdapter()).dc(i2));
                    } else {
                        i(i2, this.ajS.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.currentPosition = CommonPagerSlidingTabStrip.this.ajS.getCurrentItem();
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

    private void x(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        a(i, imageButton);
    }

    private void a(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.ajS.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.akb, this.akc, this.akd, this.ake);
        this.ajR.addView(view, i, this.ajW ? this.ajO : this.ajN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.ajT; i++) {
            View childAt = this.ajR.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.akk);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.akg);
                    textView.setTypeface(this.akh, this.aki);
                    if (i == this.ajS.getCurrentItem()) {
                        textView.setTextColor(this.ajX);
                    } else {
                        textView.setTextColor(this.ajY);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.ajT != 0) {
            int left = this.ajR.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.ajZ;
            }
            if (left != this.akj) {
                this.akj = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.ajT != 0 && this.ajR.getChildCount() > 1) {
            int height = getHeight();
            this.ajV.setColor(this.ajX);
            View childAt = this.ajR.getChildAt(this.currentPosition);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.ajU > 0.0f && this.currentPosition < this.ajT - 1) {
                View childAt2 = this.ajR.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.ajU)) + (childAt2.getLeft() * this.ajU);
                right = (right * (1.0f - this.ajU)) + (childAt2.getRight() * this.ajU);
            }
            if (right - left < this.akf) {
                canvas.drawRect(left, height - this.aka, right, height, this.ajV);
            } else {
                canvas.drawRect(left + (((right - left) - this.akf) / 2.0f), height - this.aka, right - (((right - left) - this.akf) / 2.0f), height, this.ajV);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.ajX = aj.getColor(i, this.ajX);
        this.ajY = aj.getColor(i, this.ajY);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.ajR.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.currentPosition = i;
                CommonPagerSlidingTabStrip.this.ajU = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.ajR.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.ajQ != null) {
                    CommonPagerSlidingTabStrip.this.ajQ.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.ajR.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.ajS.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.ajQ != null) {
                    CommonPagerSlidingTabStrip.this.ajQ.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.ajQ != null) {
                CommonPagerSlidingTabStrip.this.ajQ.onPageSelected(i);
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
