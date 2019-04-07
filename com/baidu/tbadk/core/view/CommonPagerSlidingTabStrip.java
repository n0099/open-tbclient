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
    private LinearLayout.LayoutParams bOI;
    private LinearLayout.LayoutParams bOJ;
    private final b bOK;
    public ViewPager.OnPageChangeListener bOL;
    private LinearLayout bOM;
    private ViewPager bON;
    private int bOO;
    private float bOP;
    private Paint bOQ;
    private boolean bOR;
    private int bOS;
    private int bOT;
    private int bOU;
    private int bOV;
    private int bOW;
    private int bOX;
    private int bOY;
    private int bOZ;
    private int bPa;
    private int bPb;
    private Typeface bPc;
    private int bPd;
    private int bPe;
    private int bPf;

    /* loaded from: classes.dex */
    public interface a {
        int hG(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bOK = new b();
        this.Us = 0;
        this.bOP = 0.0f;
        this.bOR = false;
        this.bOS = al.getColor(d.C0277d.cp_cont_b);
        this.bOT = al.getColor(d.C0277d.cp_cont_j);
        this.bOU = 52;
        this.bOV = 4;
        this.bOW = 24;
        this.bOX = 24;
        this.bOY = 24;
        this.bOZ = 24;
        this.bPa = 40;
        this.bPb = 12;
        this.bPc = null;
        this.bPd = 0;
        this.bPe = 0;
        this.bPf = d.f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bOM = new LinearLayout(getContext());
        this.bOM.setOrientation(0);
        this.bOM.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bOM);
        this.bOQ = new Paint();
        this.bOQ.setAntiAlias(true);
        this.bOQ.setStyle(Paint.Style.FILL);
        this.bOI = new LinearLayout.LayoutParams(-2, -1);
        this.bOJ = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.bPb = i;
        this.bOW = i2;
        this.bOX = i3;
        this.bOY = i4;
        this.bOZ = i5;
        this.bOV = i6;
        this.bPa = i7;
        this.bOT = i8;
        this.bOS = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.bON = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.bOK);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bOL = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bON != null && this.bON.getAdapter() != null && this.bON.getAdapter().getCount() != 0) {
            this.bOM.removeAllViews();
            this.bOO = this.bON.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bOO) {
                    if (this.bON.getAdapter() instanceof a) {
                        X(i2, ((a) this.bON.getAdapter()).hG(i2));
                    } else {
                        A(i2, this.bON.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.Us = CommonPagerSlidingTabStrip.this.bON.getCurrentItem();
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
                CommonPagerSlidingTabStrip.this.bON.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.bOW, this.bOX, this.bOY, this.bOZ);
        this.bOM.addView(view, i, this.bOR ? this.bOJ : this.bOI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.bOO; i++) {
            View childAt = this.bOM.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bPf);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.bPb);
                    textView.setTypeface(this.bPc, this.bPd);
                    if (i == this.bON.getCurrentItem()) {
                        textView.setTextColor(this.bOS);
                    } else {
                        textView.setTextColor(this.bOT);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bOO != 0) {
            int left = this.bOM.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.bOU;
            }
            if (left != this.bPe) {
                this.bPe = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.bOO != 0 && this.bOM.getChildCount() > 1) {
            int height = getHeight();
            this.bOQ.setColor(this.bOS);
            View childAt = this.bOM.getChildAt(this.Us);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.bOP > 0.0f && this.Us < this.bOO - 1) {
                View childAt2 = this.bOM.getChildAt(this.Us + 1);
                left = (left * (1.0f - this.bOP)) + (childAt2.getLeft() * this.bOP);
                right = (right * (1.0f - this.bOP)) + (childAt2.getRight() * this.bOP);
            }
            if (right - left < this.bPa) {
                canvas.drawRect(left, height - this.bOV, right, height, this.bOQ);
            } else {
                canvas.drawRect(left + (((right - left) - this.bPa) / 2.0f), height - this.bOV, right - (((right - left) - this.bPa) / 2.0f), height, this.bOQ);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.bOS = al.getColor(i, this.bOS);
        this.bOT = al.getColor(i, this.bOT);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.bOM.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.Us = i;
                CommonPagerSlidingTabStrip.this.bOP = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.bOM.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.bOL != null) {
                    CommonPagerSlidingTabStrip.this.bOL.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.bOM.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.bON.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.bOL != null) {
                    CommonPagerSlidingTabStrip.this.bOL.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.bOL != null) {
                CommonPagerSlidingTabStrip.this.bOL.onPageSelected(i);
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
            /* renamed from: hH */
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
