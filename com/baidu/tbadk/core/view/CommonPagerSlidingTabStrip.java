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
    private LinearLayout.LayoutParams awU;
    private LinearLayout.LayoutParams awV;
    private final b awW;
    public ViewPager.OnPageChangeListener awX;
    private LinearLayout awY;
    private ViewPager awZ;
    private int axa;
    private int axb;
    private float axc;
    private Paint axd;
    private boolean axe;
    private int axf;
    private int axg;
    private int axh;
    private int axi;
    private int axj;
    private int axk;
    private int axl;
    private int axm;
    private int axn;
    private int axo;
    private Typeface axp;
    private int axq;
    private int axr;
    private int axs;

    /* loaded from: classes.dex */
    public interface a {
        int dr(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.awW = new b();
        this.axb = 0;
        this.axc = 0.0f;
        this.axe = false;
        this.axf = al.getColor(e.d.cp_cont_b);
        this.axg = al.getColor(e.d.cp_cont_j);
        this.axh = 52;
        this.axi = 4;
        this.axj = 24;
        this.axk = 24;
        this.axl = 24;
        this.axm = 24;
        this.axn = 40;
        this.axo = 12;
        this.axp = null;
        this.axq = 0;
        this.axr = 0;
        this.axs = e.f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.awY = new LinearLayout(getContext());
        this.awY.setOrientation(0);
        this.awY.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.awY);
        this.axd = new Paint();
        this.axd.setAntiAlias(true);
        this.axd.setStyle(Paint.Style.FILL);
        this.awU = new LinearLayout.LayoutParams(-2, -1);
        this.awV = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.axo = i;
        this.axj = i2;
        this.axk = i3;
        this.axl = i4;
        this.axm = i5;
        this.axi = i6;
        this.axn = i7;
        this.axg = i8;
        this.axf = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.awZ = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.awW);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.awX = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.awZ != null && this.awZ.getAdapter() != null && this.awZ.getAdapter().getCount() != 0) {
            this.awY.removeAllViews();
            this.axa = this.awZ.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.axa) {
                    if (this.awZ.getAdapter() instanceof a) {
                        A(i2, ((a) this.awZ.getAdapter()).dr(i2));
                    } else {
                        j(i2, this.awZ.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.axb = CommonPagerSlidingTabStrip.this.awZ.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.axb, 0);
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
                CommonPagerSlidingTabStrip.this.awZ.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.axj, this.axk, this.axl, this.axm);
        this.awY.addView(view, i, this.axe ? this.awV : this.awU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.axa; i++) {
            View childAt = this.awY.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.axs);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.axo);
                    textView.setTypeface(this.axp, this.axq);
                    if (i == this.awZ.getCurrentItem()) {
                        textView.setTextColor(this.axf);
                    } else {
                        textView.setTextColor(this.axg);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.axa != 0) {
            int left = this.awY.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.axh;
            }
            if (left != this.axr) {
                this.axr = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.axa != 0 && this.awY.getChildCount() > 1) {
            int height = getHeight();
            this.axd.setColor(this.axf);
            View childAt = this.awY.getChildAt(this.axb);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.axc > 0.0f && this.axb < this.axa - 1) {
                View childAt2 = this.awY.getChildAt(this.axb + 1);
                left = (left * (1.0f - this.axc)) + (childAt2.getLeft() * this.axc);
                right = (right * (1.0f - this.axc)) + (childAt2.getRight() * this.axc);
            }
            if (right - left < this.axn) {
                canvas.drawRect(left, height - this.axi, right, height, this.axd);
            } else {
                canvas.drawRect(left + (((right - left) - this.axn) / 2.0f), height - this.axi, right - (((right - left) - this.axn) / 2.0f), height, this.axd);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.axf = al.getColor(i, this.axf);
        this.axg = al.getColor(i, this.axg);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.awY.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.axb = i;
                CommonPagerSlidingTabStrip.this.axc = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.awY.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.awX != null) {
                    CommonPagerSlidingTabStrip.this.awX.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.awY.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.awZ.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.awX != null) {
                    CommonPagerSlidingTabStrip.this.awX.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.awX != null) {
                CommonPagerSlidingTabStrip.this.awX.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.axb = savedState.axb;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.axb = this.axb;
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
            /* renamed from: ds */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int axb;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.axb = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.axb);
        }
    }
}
