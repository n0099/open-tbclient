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
    private int Us;
    private LinearLayout.LayoutParams bOG;
    private LinearLayout.LayoutParams bOH;
    private final b bOI;
    public ViewPager.OnPageChangeListener bOJ;
    private LinearLayout bOK;
    private ViewPager bOL;
    private int bOM;
    private float bON;
    private Paint bOO;
    private boolean bOP;
    private int bOQ;
    private int bOR;
    private int bOS;
    private int bOT;
    private int bOU;
    private int bOV;
    private int bOW;
    private int bOX;
    private int bOY;
    private int bOZ;
    private Typeface bPa;
    private int bPb;
    private int bPc;
    private int bPd;

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
        this.bOI = new b();
        this.Us = 0;
        this.bON = 0.0f;
        this.bOP = false;
        this.bOQ = al.getColor(d.C0277d.cp_cont_b);
        this.bOR = al.getColor(d.C0277d.cp_cont_j);
        this.bOS = 52;
        this.bOT = 4;
        this.bOU = 24;
        this.bOV = 24;
        this.bOW = 24;
        this.bOX = 24;
        this.bOY = 40;
        this.bOZ = 12;
        this.bPa = null;
        this.bPb = 0;
        this.bPc = 0;
        this.bPd = d.f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bOK = new LinearLayout(getContext());
        this.bOK.setOrientation(0);
        this.bOK.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bOK);
        this.bOO = new Paint();
        this.bOO.setAntiAlias(true);
        this.bOO.setStyle(Paint.Style.FILL);
        this.bOG = new LinearLayout.LayoutParams(-2, -1);
        this.bOH = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.bOZ = i;
        this.bOU = i2;
        this.bOV = i3;
        this.bOW = i4;
        this.bOX = i5;
        this.bOT = i6;
        this.bOY = i7;
        this.bOR = i8;
        this.bOQ = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.bOL = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.bOI);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bOJ = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bOL != null && this.bOL.getAdapter() != null && this.bOL.getAdapter().getCount() != 0) {
            this.bOK.removeAllViews();
            this.bOM = this.bOL.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bOM) {
                    if (this.bOL.getAdapter() instanceof a) {
                        X(i2, ((a) this.bOL.getAdapter()).hH(i2));
                    } else {
                        A(i2, this.bOL.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.Us = CommonPagerSlidingTabStrip.this.bOL.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.Us, 0);
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
                CommonPagerSlidingTabStrip.this.bOL.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.bOU, this.bOV, this.bOW, this.bOX);
        this.bOK.addView(view, i, this.bOP ? this.bOH : this.bOG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.bOM; i++) {
            View childAt = this.bOK.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bPd);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.bOZ);
                    textView.setTypeface(this.bPa, this.bPb);
                    if (i == this.bOL.getCurrentItem()) {
                        textView.setTextColor(this.bOQ);
                    } else {
                        textView.setTextColor(this.bOR);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bOM != 0) {
            int left = this.bOK.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.bOS;
            }
            if (left != this.bPc) {
                this.bPc = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.bOM != 0 && this.bOK.getChildCount() > 1) {
            int height = getHeight();
            this.bOO.setColor(this.bOQ);
            View childAt = this.bOK.getChildAt(this.Us);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.bON > 0.0f && this.Us < this.bOM - 1) {
                View childAt2 = this.bOK.getChildAt(this.Us + 1);
                left = (left * (1.0f - this.bON)) + (childAt2.getLeft() * this.bON);
                right = (right * (1.0f - this.bON)) + (childAt2.getRight() * this.bON);
            }
            if (right - left < this.bOY) {
                canvas.drawRect(left, height - this.bOT, right, height, this.bOO);
            } else {
                canvas.drawRect(left + (((right - left) - this.bOY) / 2.0f), height - this.bOT, right - (((right - left) - this.bOY) / 2.0f), height, this.bOO);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.bOQ = al.getColor(i, this.bOQ);
        this.bOR = al.getColor(i, this.bOR);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.bOK.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.Us = i;
                CommonPagerSlidingTabStrip.this.bON = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.bOK.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.bOJ != null) {
                    CommonPagerSlidingTabStrip.this.bOJ.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.bOK.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.bOL.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.bOJ != null) {
                    CommonPagerSlidingTabStrip.this.bOJ.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.bOJ != null) {
                CommonPagerSlidingTabStrip.this.bOJ.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Us = savedState.Us;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Us = this.Us;
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
        int Us;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Us = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Us);
        }
    }
}
