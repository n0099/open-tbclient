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
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams atI;
    private LinearLayout.LayoutParams atJ;
    private final b atK;
    public ViewPager.OnPageChangeListener atL;
    private LinearLayout atM;
    private ViewPager atN;
    private int atO;
    private int atP;
    private float atQ;
    private Paint atR;
    private boolean atS;
    private int atT;
    private int atU;
    private int atV;
    private int atW;
    private int atX;
    private int atY;
    private int atZ;
    private int aua;
    private int aub;
    private int auc;
    private Typeface aud;
    private int aue;
    private int auf;
    private int aug;

    /* loaded from: classes.dex */
    public interface a {
        int dg(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.atK = new b();
        this.atP = 0;
        this.atQ = 0.0f;
        this.atS = false;
        this.atT = am.getColor(f.d.cp_cont_b);
        this.atU = am.getColor(f.d.cp_cont_j);
        this.atV = 52;
        this.atW = 4;
        this.atX = 24;
        this.atY = 24;
        this.atZ = 24;
        this.aua = 24;
        this.aub = 40;
        this.auc = 12;
        this.aud = null;
        this.aue = 0;
        this.auf = 0;
        this.aug = f.C0146f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.atM = new LinearLayout(getContext());
        this.atM.setOrientation(0);
        this.atM.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.atM);
        this.atR = new Paint();
        this.atR.setAntiAlias(true);
        this.atR.setStyle(Paint.Style.FILL);
        this.atI = new LinearLayout.LayoutParams(-2, -1);
        this.atJ = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.auc = i;
        this.atX = i2;
        this.atY = i3;
        this.atZ = i4;
        this.aua = i5;
        this.atW = i6;
        this.aub = i7;
        this.atU = i8;
        this.atT = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.atN = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.atK);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.atL = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.atN != null && this.atN.getAdapter() != null && this.atN.getAdapter().getCount() != 0) {
            this.atM.removeAllViews();
            this.atO = this.atN.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.atO) {
                    if (this.atN.getAdapter() instanceof a) {
                        y(i2, ((a) this.atN.getAdapter()).dg(i2));
                    } else {
                        j(i2, this.atN.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.atP = CommonPagerSlidingTabStrip.this.atN.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.atP, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void j(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        b(i, textView);
    }

    private void y(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        b(i, imageButton);
    }

    private void b(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.atN.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.atX, this.atY, this.atZ, this.aua);
        this.atM.addView(view, i, this.atS ? this.atJ : this.atI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.atO; i++) {
            View childAt = this.atM.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aug);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.auc);
                    textView.setTypeface(this.aud, this.aue);
                    if (i == this.atN.getCurrentItem()) {
                        textView.setTextColor(this.atT);
                    } else {
                        textView.setTextColor(this.atU);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.atO != 0) {
            int left = this.atM.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.atV;
            }
            if (left != this.auf) {
                this.auf = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.atO != 0 && this.atM.getChildCount() > 1) {
            int height = getHeight();
            this.atR.setColor(this.atT);
            View childAt = this.atM.getChildAt(this.atP);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.atQ > 0.0f && this.atP < this.atO - 1) {
                View childAt2 = this.atM.getChildAt(this.atP + 1);
                left = (left * (1.0f - this.atQ)) + (childAt2.getLeft() * this.atQ);
                right = (right * (1.0f - this.atQ)) + (childAt2.getRight() * this.atQ);
            }
            if (right - left < this.aub) {
                canvas.drawRect(left, height - this.atW, right, height, this.atR);
            } else {
                canvas.drawRect(left + (((right - left) - this.aub) / 2.0f), height - this.atW, right - (((right - left) - this.aub) / 2.0f), height, this.atR);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.atT = am.getColor(i, this.atT);
        this.atU = am.getColor(i, this.atU);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.atM.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.atP = i;
                CommonPagerSlidingTabStrip.this.atQ = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.atM.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.atL != null) {
                    CommonPagerSlidingTabStrip.this.atL.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.atM.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.atN.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.atL != null) {
                    CommonPagerSlidingTabStrip.this.atL.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.atL != null) {
                CommonPagerSlidingTabStrip.this.atL.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.atP = savedState.atP;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.atP = this.atP;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: h */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: dh */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int atP;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.atP = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.atP);
        }
    }
}
