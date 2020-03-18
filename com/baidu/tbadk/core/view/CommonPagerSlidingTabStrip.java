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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private int Ev;
    private LinearLayout.LayoutParams deH;
    private LinearLayout.LayoutParams deI;
    private final b deJ;
    public ViewPager.OnPageChangeListener deK;
    private LinearLayout deL;
    private ViewPager deM;
    private int deN;
    private float deO;
    private Paint deP;
    private boolean deQ;
    private int deR;
    private int deS;
    private int deT;
    private int deU;
    private int deV;
    private int deW;
    private int deX;
    private int deY;
    private Typeface deZ;
    private int dfa;
    private int dfb;
    private int dfc;
    private int indicatorHeight;
    private int tabTextSize;

    /* loaded from: classes.dex */
    public interface a {
        int kW(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.deJ = new b();
        this.Ev = 0;
        this.deO = 0.0f;
        this.deQ = false;
        this.deR = am.getColor(R.color.cp_cont_b);
        this.deS = am.getColor(R.color.cp_cont_j);
        this.deT = 52;
        this.indicatorHeight = 4;
        this.deU = 24;
        this.deV = 24;
        this.deW = 24;
        this.deX = 24;
        this.deY = 40;
        this.tabTextSize = 12;
        this.deZ = null;
        this.dfa = 0;
        this.dfb = 0;
        this.dfc = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.deL = new LinearLayout(getContext());
        this.deL.setOrientation(0);
        this.deL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.deL);
        this.deP = new Paint();
        this.deP.setAntiAlias(true);
        this.deP.setStyle(Paint.Style.FILL);
        this.deH = new LinearLayout.LayoutParams(-2, -1);
        this.deI = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.tabTextSize = i;
        this.deU = i2;
        this.deV = i3;
        this.deW = i4;
        this.deX = i5;
        this.indicatorHeight = i6;
        this.deY = i7;
        this.deS = i8;
        this.deR = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.deM = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.deJ);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.deK = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.deM != null && this.deM.getAdapter() != null && this.deM.getAdapter().getCount() != 0) {
            this.deL.removeAllViews();
            this.deN = this.deM.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.deN) {
                    if (this.deM.getAdapter() instanceof a) {
                        az(i2, ((a) this.deM.getAdapter()).kW(i2));
                    } else {
                        R(i2, this.deM.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.Ev = CommonPagerSlidingTabStrip.this.deM.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.Ev, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void R(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        d(i, textView);
    }

    private void az(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.deM.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.deU, this.deV, this.deW, this.deX);
        this.deL.addView(view, i, this.deQ ? this.deI : this.deH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.deN; i++) {
            View childAt = this.deL.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dfc);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.tabTextSize);
                    textView.setTypeface(this.deZ, this.dfa);
                    if (i == this.deM.getCurrentItem()) {
                        textView.setTextColor(this.deR);
                    } else {
                        textView.setTextColor(this.deS);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.deN != 0) {
            int left = this.deL.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.deT;
            }
            if (left != this.dfb) {
                this.dfb = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.deN != 0 && this.deL.getChildCount() > 1) {
            int height = getHeight();
            this.deP.setColor(this.deR);
            View childAt = this.deL.getChildAt(this.Ev);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.deO > 0.0f && this.Ev < this.deN - 1) {
                View childAt2 = this.deL.getChildAt(this.Ev + 1);
                left = (left * (1.0f - this.deO)) + (childAt2.getLeft() * this.deO);
                right = (right * (1.0f - this.deO)) + (childAt2.getRight() * this.deO);
            }
            if (right - left < this.deY) {
                canvas.drawRect(left, height - this.indicatorHeight, right, height, this.deP);
            } else {
                canvas.drawRect(left + (((right - left) - this.deY) / 2.0f), height - this.indicatorHeight, right - (((right - left) - this.deY) / 2.0f), height, this.deP);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.deR = am.getColor(i, this.deR);
        this.deS = am.getColor(i, this.deS);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.deL.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.Ev = i;
                CommonPagerSlidingTabStrip.this.deO = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.deL.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.deK != null) {
                    CommonPagerSlidingTabStrip.this.deK.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.deL.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.deM.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.deK != null) {
                    CommonPagerSlidingTabStrip.this.deK.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.deK != null) {
                CommonPagerSlidingTabStrip.this.deK.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Ev = savedState.Ev;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Ev = this.Ev;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: S */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: kX */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Ev;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Ev = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ev);
        }
    }
}
