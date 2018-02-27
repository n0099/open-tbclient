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
    private LinearLayout.LayoutParams aZE;
    private LinearLayout.LayoutParams aZF;
    private final b aZG;
    public ViewPager.OnPageChangeListener aZH;
    private LinearLayout aZI;
    private ViewPager aZJ;
    private int aZK;
    private float aZL;
    private Paint aZM;
    private boolean aZN;
    private int aZO;
    private int aZP;
    private int aZQ;
    private int aZR;
    private int aZS;
    private int aZT;
    private int aZU;
    private int aZV;
    private int aZW;
    private int aZX;
    private Typeface aZY;
    private int aZZ;
    private int baa;
    private int bab;
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
        this.aZG = new b();
        this.currentPosition = 0;
        this.aZL = 0.0f;
        this.aZN = false;
        this.aZO = aj.getColor(d.C0141d.cp_cont_b);
        this.aZP = aj.getColor(d.C0141d.cp_cont_j);
        this.aZQ = 52;
        this.aZR = 4;
        this.aZS = 24;
        this.aZT = 24;
        this.aZU = 24;
        this.aZV = 24;
        this.aZW = 40;
        this.aZX = 12;
        this.aZY = null;
        this.aZZ = 0;
        this.baa = 0;
        this.bab = d.f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aZI = new LinearLayout(getContext());
        this.aZI.setOrientation(0);
        this.aZI.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aZI);
        this.aZM = new Paint();
        this.aZM.setAntiAlias(true);
        this.aZM.setStyle(Paint.Style.FILL);
        this.aZE = new LinearLayout.LayoutParams(-2, -1);
        this.aZF = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.aZX = i;
        this.aZS = i2;
        this.aZT = i3;
        this.aZU = i4;
        this.aZV = i5;
        this.aZR = i6;
        this.aZW = i7;
        this.aZP = i8;
        this.aZO = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aZJ = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.aZG);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aZH = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aZJ != null && this.aZJ.getAdapter() != null && this.aZJ.getAdapter().getCount() != 0) {
            this.aZI.removeAllViews();
            this.aZK = this.aZJ.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aZK) {
                    if (this.aZJ.getAdapter() instanceof a) {
                        aw(i2, ((a) this.aZJ.getAdapter()).gb(i2));
                    } else {
                        h(i2, this.aZJ.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.currentPosition = CommonPagerSlidingTabStrip.this.aZJ.getCurrentItem();
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
                CommonPagerSlidingTabStrip.this.aZJ.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.aZS, this.aZT, this.aZU, this.aZV);
        this.aZI.addView(view, i, this.aZN ? this.aZF : this.aZE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aZK; i++) {
            View childAt = this.aZI.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bab);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aZX);
                    textView.setTypeface(this.aZY, this.aZZ);
                    if (i == this.aZJ.getCurrentItem()) {
                        textView.setTextColor(this.aZO);
                    } else {
                        textView.setTextColor(this.aZP);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aZK != 0) {
            int left = this.aZI.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aZQ;
            }
            if (left != this.baa) {
                this.baa = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aZK != 0 && this.aZI.getChildCount() > 1) {
            int height = getHeight();
            this.aZM.setColor(this.aZO);
            View childAt = this.aZI.getChildAt(this.currentPosition);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.aZL > 0.0f && this.currentPosition < this.aZK - 1) {
                View childAt2 = this.aZI.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.aZL)) + (childAt2.getLeft() * this.aZL);
                right = (right * (1.0f - this.aZL)) + (childAt2.getRight() * this.aZL);
            }
            if (right - left < this.aZW) {
                canvas.drawRect(left, height - this.aZR, right, height, this.aZM);
            } else {
                canvas.drawRect(left + (((right - left) - this.aZW) / 2.0f), height - this.aZR, right - (((right - left) - this.aZW) / 2.0f), height, this.aZM);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aZO = aj.getColor(i, this.aZO);
        this.aZP = aj.getColor(i, this.aZP);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.aZI.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.currentPosition = i;
                CommonPagerSlidingTabStrip.this.aZL = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.aZI.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.aZH != null) {
                    CommonPagerSlidingTabStrip.this.aZH.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.aZI.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.aZJ.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.aZH != null) {
                    CommonPagerSlidingTabStrip.this.aZH.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.aZH != null) {
                CommonPagerSlidingTabStrip.this.aZH.onPageSelected(i);
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
