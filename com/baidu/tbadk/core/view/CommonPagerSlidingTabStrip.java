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
    private LinearLayout.LayoutParams aZG;
    private LinearLayout.LayoutParams aZH;
    private final b aZI;
    public ViewPager.OnPageChangeListener aZJ;
    private LinearLayout aZK;
    private ViewPager aZL;
    private int aZM;
    private float aZN;
    private Paint aZO;
    private boolean aZP;
    private int aZQ;
    private int aZR;
    private int aZS;
    private int aZT;
    private int aZU;
    private int aZV;
    private int aZW;
    private int aZX;
    private int aZY;
    private int aZZ;
    private Typeface baa;
    private int bab;
    private int bac;
    private int bad;
    private int currentPosition;

    /* loaded from: classes.dex */
    public interface a {
        int gb(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aZI = new b();
        this.currentPosition = 0;
        this.aZN = 0.0f;
        this.aZP = false;
        this.aZQ = aj.getColor(d.C0141d.cp_cont_b);
        this.aZR = aj.getColor(d.C0141d.cp_cont_j);
        this.aZS = 52;
        this.aZT = 4;
        this.aZU = 24;
        this.aZV = 24;
        this.aZW = 24;
        this.aZX = 24;
        this.aZY = 40;
        this.aZZ = 12;
        this.baa = null;
        this.bab = 0;
        this.bac = 0;
        this.bad = d.f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aZK = new LinearLayout(getContext());
        this.aZK.setOrientation(0);
        this.aZK.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aZK);
        this.aZO = new Paint();
        this.aZO.setAntiAlias(true);
        this.aZO.setStyle(Paint.Style.FILL);
        this.aZG = new LinearLayout.LayoutParams(-2, -1);
        this.aZH = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.aZZ = i;
        this.aZU = i2;
        this.aZV = i3;
        this.aZW = i4;
        this.aZX = i5;
        this.aZT = i6;
        this.aZY = i7;
        this.aZR = i8;
        this.aZQ = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aZL = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.aZI);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aZJ = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aZL != null && this.aZL.getAdapter() != null && this.aZL.getAdapter().getCount() != 0) {
            this.aZK.removeAllViews();
            this.aZM = this.aZL.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aZM) {
                    if (this.aZL.getAdapter() instanceof a) {
                        aw(i2, ((a) this.aZL.getAdapter()).gb(i2));
                    } else {
                        h(i2, this.aZL.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.currentPosition = CommonPagerSlidingTabStrip.this.aZL.getCurrentItem();
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

    private void aw(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        b(i, imageButton);
    }

    private void b(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.aZL.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.aZU, this.aZV, this.aZW, this.aZX);
        this.aZK.addView(view, i, this.aZP ? this.aZH : this.aZG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aZM; i++) {
            View childAt = this.aZK.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bad);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aZZ);
                    textView.setTypeface(this.baa, this.bab);
                    if (i == this.aZL.getCurrentItem()) {
                        textView.setTextColor(this.aZQ);
                    } else {
                        textView.setTextColor(this.aZR);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aZM != 0) {
            int left = this.aZK.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aZS;
            }
            if (left != this.bac) {
                this.bac = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aZM != 0 && this.aZK.getChildCount() > 1) {
            int height = getHeight();
            this.aZO.setColor(this.aZQ);
            View childAt = this.aZK.getChildAt(this.currentPosition);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.aZN > 0.0f && this.currentPosition < this.aZM - 1) {
                View childAt2 = this.aZK.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.aZN)) + (childAt2.getLeft() * this.aZN);
                right = (right * (1.0f - this.aZN)) + (childAt2.getRight() * this.aZN);
            }
            if (right - left < this.aZY) {
                canvas.drawRect(left, height - this.aZT, right, height, this.aZO);
            } else {
                canvas.drawRect(left + (((right - left) - this.aZY) / 2.0f), height - this.aZT, right - (((right - left) - this.aZY) / 2.0f), height, this.aZO);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aZQ = aj.getColor(i, this.aZQ);
        this.aZR = aj.getColor(i, this.aZR);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.aZK.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.currentPosition = i;
                CommonPagerSlidingTabStrip.this.aZN = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.aZK.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.aZJ != null) {
                    CommonPagerSlidingTabStrip.this.aZJ.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.aZK.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.aZL.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.aZJ != null) {
                    CommonPagerSlidingTabStrip.this.aZJ.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.aZJ != null) {
                CommonPagerSlidingTabStrip.this.aZJ.onPageSelected(i);
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
            /* renamed from: u */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: gc */
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
