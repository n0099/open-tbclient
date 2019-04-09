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
    private int Ut;
    private LinearLayout.LayoutParams bOJ;
    private LinearLayout.LayoutParams bOK;
    private final b bOL;
    public ViewPager.OnPageChangeListener bOM;
    private LinearLayout bON;
    private ViewPager bOO;
    private int bOP;
    private float bOQ;
    private Paint bOR;
    private boolean bOS;
    private int bOT;
    private int bOU;
    private int bOV;
    private int bOW;
    private int bOX;
    private int bOY;
    private int bOZ;
    private int bPa;
    private int bPb;
    private int bPc;
    private Typeface bPd;
    private int bPe;
    private int bPf;
    private int bPg;

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
        this.bOL = new b();
        this.Ut = 0;
        this.bOQ = 0.0f;
        this.bOS = false;
        this.bOT = al.getColor(d.C0277d.cp_cont_b);
        this.bOU = al.getColor(d.C0277d.cp_cont_j);
        this.bOV = 52;
        this.bOW = 4;
        this.bOX = 24;
        this.bOY = 24;
        this.bOZ = 24;
        this.bPa = 24;
        this.bPb = 40;
        this.bPc = 12;
        this.bPd = null;
        this.bPe = 0;
        this.bPf = 0;
        this.bPg = d.f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bON = new LinearLayout(getContext());
        this.bON.setOrientation(0);
        this.bON.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bON);
        this.bOR = new Paint();
        this.bOR.setAntiAlias(true);
        this.bOR.setStyle(Paint.Style.FILL);
        this.bOJ = new LinearLayout.LayoutParams(-2, -1);
        this.bOK = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.bPc = i;
        this.bOX = i2;
        this.bOY = i3;
        this.bOZ = i4;
        this.bPa = i5;
        this.bOW = i6;
        this.bPb = i7;
        this.bOU = i8;
        this.bOT = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.bOO = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.bOL);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bOM = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bOO != null && this.bOO.getAdapter() != null && this.bOO.getAdapter().getCount() != 0) {
            this.bON.removeAllViews();
            this.bOP = this.bOO.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bOP) {
                    if (this.bOO.getAdapter() instanceof a) {
                        X(i2, ((a) this.bOO.getAdapter()).hG(i2));
                    } else {
                        A(i2, this.bOO.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.Ut = CommonPagerSlidingTabStrip.this.bOO.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.Ut, 0);
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
                CommonPagerSlidingTabStrip.this.bOO.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.bOX, this.bOY, this.bOZ, this.bPa);
        this.bON.addView(view, i, this.bOS ? this.bOK : this.bOJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.bOP; i++) {
            View childAt = this.bON.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bPg);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.bPc);
                    textView.setTypeface(this.bPd, this.bPe);
                    if (i == this.bOO.getCurrentItem()) {
                        textView.setTextColor(this.bOT);
                    } else {
                        textView.setTextColor(this.bOU);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bOP != 0) {
            int left = this.bON.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.bOV;
            }
            if (left != this.bPf) {
                this.bPf = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.bOP != 0 && this.bON.getChildCount() > 1) {
            int height = getHeight();
            this.bOR.setColor(this.bOT);
            View childAt = this.bON.getChildAt(this.Ut);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.bOQ > 0.0f && this.Ut < this.bOP - 1) {
                View childAt2 = this.bON.getChildAt(this.Ut + 1);
                left = (left * (1.0f - this.bOQ)) + (childAt2.getLeft() * this.bOQ);
                right = (right * (1.0f - this.bOQ)) + (childAt2.getRight() * this.bOQ);
            }
            if (right - left < this.bPb) {
                canvas.drawRect(left, height - this.bOW, right, height, this.bOR);
            } else {
                canvas.drawRect(left + (((right - left) - this.bPb) / 2.0f), height - this.bOW, right - (((right - left) - this.bPb) / 2.0f), height, this.bOR);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.bOT = al.getColor(i, this.bOT);
        this.bOU = al.getColor(i, this.bOU);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.bON.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.Ut = i;
                CommonPagerSlidingTabStrip.this.bOQ = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.bON.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.bOM != null) {
                    CommonPagerSlidingTabStrip.this.bOM.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.bON.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.bOO.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.bOM != null) {
                    CommonPagerSlidingTabStrip.this.bOM.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.bOM != null) {
                CommonPagerSlidingTabStrip.this.bOM.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Ut = savedState.Ut;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Ut = this.Ut;
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
        int Ut;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Ut = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ut);
        }
    }
}
