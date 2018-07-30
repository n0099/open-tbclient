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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams atH;
    private LinearLayout.LayoutParams atI;
    private final b atJ;
    public ViewPager.OnPageChangeListener atK;
    private LinearLayout atL;
    private ViewPager atM;
    private int atN;
    private int atO;
    private float atP;
    private Paint atQ;
    private boolean atR;
    private int atS;
    private int atT;
    private int atU;
    private int atV;
    private int atW;
    private int atX;
    private int atY;
    private int atZ;
    private int aua;
    private int aub;
    private Typeface auc;
    private int aud;
    private int aue;
    private int auf;

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
        this.atJ = new b();
        this.atO = 0;
        this.atP = 0.0f;
        this.atR = false;
        this.atS = am.getColor(d.C0140d.cp_cont_b);
        this.atT = am.getColor(d.C0140d.cp_cont_j);
        this.atU = 52;
        this.atV = 4;
        this.atW = 24;
        this.atX = 24;
        this.atY = 24;
        this.atZ = 24;
        this.aua = 40;
        this.aub = 12;
        this.auc = null;
        this.aud = 0;
        this.aue = 0;
        this.auf = d.f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.atL = new LinearLayout(getContext());
        this.atL.setOrientation(0);
        this.atL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.atL);
        this.atQ = new Paint();
        this.atQ.setAntiAlias(true);
        this.atQ.setStyle(Paint.Style.FILL);
        this.atH = new LinearLayout.LayoutParams(-2, -1);
        this.atI = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.aub = i;
        this.atW = i2;
        this.atX = i3;
        this.atY = i4;
        this.atZ = i5;
        this.atV = i6;
        this.aua = i7;
        this.atT = i8;
        this.atS = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.atM = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.atJ);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.atK = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.atM != null && this.atM.getAdapter() != null && this.atM.getAdapter().getCount() != 0) {
            this.atL.removeAllViews();
            this.atN = this.atM.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.atN) {
                    if (this.atM.getAdapter() instanceof a) {
                        y(i2, ((a) this.atM.getAdapter()).dg(i2));
                    } else {
                        j(i2, this.atM.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.atO = CommonPagerSlidingTabStrip.this.atM.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.atO, 0);
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
        a(i, textView);
    }

    private void y(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        a(i, imageButton);
    }

    private void a(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.atM.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.atW, this.atX, this.atY, this.atZ);
        this.atL.addView(view, i, this.atR ? this.atI : this.atH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.atN; i++) {
            View childAt = this.atL.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.auf);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aub);
                    textView.setTypeface(this.auc, this.aud);
                    if (i == this.atM.getCurrentItem()) {
                        textView.setTextColor(this.atS);
                    } else {
                        textView.setTextColor(this.atT);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.atN != 0) {
            int left = this.atL.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.atU;
            }
            if (left != this.aue) {
                this.aue = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.atN != 0 && this.atL.getChildCount() > 1) {
            int height = getHeight();
            this.atQ.setColor(this.atS);
            View childAt = this.atL.getChildAt(this.atO);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.atP > 0.0f && this.atO < this.atN - 1) {
                View childAt2 = this.atL.getChildAt(this.atO + 1);
                left = (left * (1.0f - this.atP)) + (childAt2.getLeft() * this.atP);
                right = (right * (1.0f - this.atP)) + (childAt2.getRight() * this.atP);
            }
            if (right - left < this.aua) {
                canvas.drawRect(left, height - this.atV, right, height, this.atQ);
            } else {
                canvas.drawRect(left + (((right - left) - this.aua) / 2.0f), height - this.atV, right - (((right - left) - this.aua) / 2.0f), height, this.atQ);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.atS = am.getColor(i, this.atS);
        this.atT = am.getColor(i, this.atT);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.atL.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.atO = i;
                CommonPagerSlidingTabStrip.this.atP = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.atL.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.atK != null) {
                    CommonPagerSlidingTabStrip.this.atK.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.atL.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.atM.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.atK != null) {
                    CommonPagerSlidingTabStrip.this.atK.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.atK != null) {
                CommonPagerSlidingTabStrip.this.atK.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.atO = savedState.atO;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.atO = this.atO;
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
        int atO;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.atO = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.atO);
        }
    }
}
