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
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private int aCA;
    private float aCB;
    private Paint aCC;
    private boolean aCD;
    private int aCE;
    private int aCF;
    private int aCG;
    private int aCH;
    private int aCI;
    private int aCJ;
    private int aCK;
    private int aCL;
    private int aCM;
    private int aCN;
    private Typeface aCO;
    private int aCP;
    private int aCQ;
    private int aCR;
    private LinearLayout.LayoutParams aCt;
    private LinearLayout.LayoutParams aCu;
    private final b aCv;
    public ViewPager.OnPageChangeListener aCw;
    private LinearLayout aCx;
    private ViewPager aCy;
    private int aCz;

    /* loaded from: classes.dex */
    public interface a {
        int dP(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCv = new b();
        this.aCA = 0;
        this.aCB = 0.0f;
        this.aCD = false;
        this.aCE = al.getColor(e.d.cp_cont_b);
        this.aCF = al.getColor(e.d.cp_cont_j);
        this.aCG = 52;
        this.aCH = 4;
        this.aCI = 24;
        this.aCJ = 24;
        this.aCK = 24;
        this.aCL = 24;
        this.aCM = 40;
        this.aCN = 12;
        this.aCO = null;
        this.aCP = 0;
        this.aCQ = 0;
        this.aCR = e.f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aCx = new LinearLayout(getContext());
        this.aCx.setOrientation(0);
        this.aCx.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aCx);
        this.aCC = new Paint();
        this.aCC.setAntiAlias(true);
        this.aCC.setStyle(Paint.Style.FILL);
        this.aCt = new LinearLayout.LayoutParams(-2, -1);
        this.aCu = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.aCN = i;
        this.aCI = i2;
        this.aCJ = i3;
        this.aCK = i4;
        this.aCL = i5;
        this.aCH = i6;
        this.aCM = i7;
        this.aCF = i8;
        this.aCE = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aCy = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.aCv);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aCw = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aCy != null && this.aCy.getAdapter() != null && this.aCy.getAdapter().getCount() != 0) {
            this.aCx.removeAllViews();
            this.aCz = this.aCy.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aCz) {
                    if (this.aCy.getAdapter() instanceof a) {
                        A(i2, ((a) this.aCy.getAdapter()).dP(i2));
                    } else {
                        i(i2, this.aCy.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.aCA = CommonPagerSlidingTabStrip.this.aCy.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.aCA, 0);
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
        b(i, textView);
    }

    private void A(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        b(i, imageButton);
    }

    private void b(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.aCy.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.aCI, this.aCJ, this.aCK, this.aCL);
        this.aCx.addView(view, i, this.aCD ? this.aCu : this.aCt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aCz; i++) {
            View childAt = this.aCx.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aCR);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aCN);
                    textView.setTypeface(this.aCO, this.aCP);
                    if (i == this.aCy.getCurrentItem()) {
                        textView.setTextColor(this.aCE);
                    } else {
                        textView.setTextColor(this.aCF);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aCz != 0) {
            int left = this.aCx.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aCG;
            }
            if (left != this.aCQ) {
                this.aCQ = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aCz != 0 && this.aCx.getChildCount() > 1) {
            int height = getHeight();
            this.aCC.setColor(this.aCE);
            View childAt = this.aCx.getChildAt(this.aCA);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.aCB > 0.0f && this.aCA < this.aCz - 1) {
                View childAt2 = this.aCx.getChildAt(this.aCA + 1);
                left = (left * (1.0f - this.aCB)) + (childAt2.getLeft() * this.aCB);
                right = (right * (1.0f - this.aCB)) + (childAt2.getRight() * this.aCB);
            }
            if (right - left < this.aCM) {
                canvas.drawRect(left, height - this.aCH, right, height, this.aCC);
            } else {
                canvas.drawRect(left + (((right - left) - this.aCM) / 2.0f), height - this.aCH, right - (((right - left) - this.aCM) / 2.0f), height, this.aCC);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aCE = al.getColor(i, this.aCE);
        this.aCF = al.getColor(i, this.aCF);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.aCx.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.aCA = i;
                CommonPagerSlidingTabStrip.this.aCB = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.aCx.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.aCw != null) {
                    CommonPagerSlidingTabStrip.this.aCw.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.aCx.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.aCy.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.aCw != null) {
                    CommonPagerSlidingTabStrip.this.aCw.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.aCw != null) {
                CommonPagerSlidingTabStrip.this.aCw.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aCA = savedState.aCA;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aCA = this.aCA;
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
            /* renamed from: dQ */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int aCA;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aCA = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aCA);
        }
    }
}
