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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private int Ur;
    private LinearLayout.LayoutParams bOF;
    private LinearLayout.LayoutParams bOG;
    private final b bOH;
    public ViewPager.OnPageChangeListener bOI;
    private LinearLayout bOJ;
    private ViewPager bOK;
    private int bOL;
    private float bOM;
    private Paint bON;
    private boolean bOO;
    private int bOP;
    private int bOQ;
    private int bOR;
    private int bOS;
    private int bOT;
    private int bOU;
    private int bOV;
    private int bOW;
    private int bOX;
    private int bOY;
    private Typeface bOZ;
    private int bPa;
    private int bPb;
    private int bPc;

    /* loaded from: classes.dex */
    public interface a {
        int hH(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bOH = new b();
        this.Ur = 0;
        this.bOM = 0.0f;
        this.bOO = false;
        this.bOP = al.getColor(d.C0236d.cp_cont_b);
        this.bOQ = al.getColor(d.C0236d.cp_cont_j);
        this.bOR = 52;
        this.bOS = 4;
        this.bOT = 24;
        this.bOU = 24;
        this.bOV = 24;
        this.bOW = 24;
        this.bOX = 40;
        this.bOY = 12;
        this.bOZ = null;
        this.bPa = 0;
        this.bPb = 0;
        this.bPc = d.f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bOJ = new LinearLayout(getContext());
        this.bOJ.setOrientation(0);
        this.bOJ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bOJ);
        this.bON = new Paint();
        this.bON.setAntiAlias(true);
        this.bON.setStyle(Paint.Style.FILL);
        this.bOF = new LinearLayout.LayoutParams(-2, -1);
        this.bOG = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.bOY = i;
        this.bOT = i2;
        this.bOU = i3;
        this.bOV = i4;
        this.bOW = i5;
        this.bOS = i6;
        this.bOX = i7;
        this.bOQ = i8;
        this.bOP = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.bOK = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.bOH);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bOI = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bOK != null && this.bOK.getAdapter() != null && this.bOK.getAdapter().getCount() != 0) {
            this.bOJ.removeAllViews();
            this.bOL = this.bOK.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bOL) {
                    if (this.bOK.getAdapter() instanceof a) {
                        X(i2, ((a) this.bOK.getAdapter()).hH(i2));
                    } else {
                        A(i2, this.bOK.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.Ur = CommonPagerSlidingTabStrip.this.bOK.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.Ur, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void A(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        e(i, textView);
    }

    private void X(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        e(i, imageButton);
    }

    private void e(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.bOK.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.bOT, this.bOU, this.bOV, this.bOW);
        this.bOJ.addView(view, i, this.bOO ? this.bOG : this.bOF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.bOL; i++) {
            View childAt = this.bOJ.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bPc);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.bOY);
                    textView.setTypeface(this.bOZ, this.bPa);
                    if (i == this.bOK.getCurrentItem()) {
                        textView.setTextColor(this.bOP);
                    } else {
                        textView.setTextColor(this.bOQ);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bOL != 0) {
            int left = this.bOJ.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.bOR;
            }
            if (left != this.bPb) {
                this.bPb = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.bOL != 0 && this.bOJ.getChildCount() > 1) {
            int height = getHeight();
            this.bON.setColor(this.bOP);
            View childAt = this.bOJ.getChildAt(this.Ur);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.bOM > 0.0f && this.Ur < this.bOL - 1) {
                View childAt2 = this.bOJ.getChildAt(this.Ur + 1);
                left = (left * (1.0f - this.bOM)) + (childAt2.getLeft() * this.bOM);
                right = (right * (1.0f - this.bOM)) + (childAt2.getRight() * this.bOM);
            }
            if (right - left < this.bOX) {
                canvas.drawRect(left, height - this.bOS, right, height, this.bON);
            } else {
                canvas.drawRect(left + (((right - left) - this.bOX) / 2.0f), height - this.bOS, right - (((right - left) - this.bOX) / 2.0f), height, this.bON);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.bOP = al.getColor(i, this.bOP);
        this.bOQ = al.getColor(i, this.bOQ);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.bOJ.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.Ur = i;
                CommonPagerSlidingTabStrip.this.bOM = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.bOJ.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.bOI != null) {
                    CommonPagerSlidingTabStrip.this.bOI.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.bOJ.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.bOK.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.bOI != null) {
                    CommonPagerSlidingTabStrip.this.bOI.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.bOI != null) {
                CommonPagerSlidingTabStrip.this.bOI.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Ur = savedState.Ur;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Ur = this.Ur;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: x */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: hI */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Ur;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Ur = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ur);
        }
    }
}
