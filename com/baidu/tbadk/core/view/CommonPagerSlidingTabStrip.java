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
    private LinearLayout.LayoutParams aXY;
    private LinearLayout.LayoutParams aXZ;
    private final b aYa;
    public ViewPager.OnPageChangeListener aYb;
    private LinearLayout aYc;
    private ViewPager aYd;
    private int aYe;
    private float aYf;
    private Paint aYg;
    private boolean aYh;
    private int aYi;
    private int aYj;
    private int aYk;
    private int aYl;
    private int aYm;
    private int aYn;
    private int aYo;
    private int aYp;
    private int aYq;
    private int aYr;
    private Typeface aYs;
    private int aYt;
    private int aYu;
    private int aYv;
    private int currentPosition;

    /* loaded from: classes.dex */
    public interface a {
        int fZ(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aYa = new b();
        this.currentPosition = 0;
        this.aYf = 0.0f;
        this.aYh = false;
        this.aYi = aj.getColor(d.C0107d.cp_cont_b);
        this.aYj = aj.getColor(d.C0107d.cp_cont_j);
        this.aYk = 52;
        this.aYl = 4;
        this.aYm = 24;
        this.aYn = 24;
        this.aYo = 24;
        this.aYp = 24;
        this.aYq = 40;
        this.aYr = 12;
        this.aYs = null;
        this.aYt = 0;
        this.aYu = 0;
        this.aYv = d.f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aYc = new LinearLayout(getContext());
        this.aYc.setOrientation(0);
        this.aYc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aYc);
        this.aYg = new Paint();
        this.aYg.setAntiAlias(true);
        this.aYg.setStyle(Paint.Style.FILL);
        this.aXY = new LinearLayout.LayoutParams(-2, -1);
        this.aXZ = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.aYr = i;
        this.aYm = i2;
        this.aYn = i3;
        this.aYo = i4;
        this.aYp = i5;
        this.aYl = i6;
        this.aYq = i7;
        this.aYj = i8;
        this.aYi = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aYd = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.aYa);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aYb = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aYd != null && this.aYd.getAdapter() != null && this.aYd.getAdapter().getCount() != 0) {
            this.aYc.removeAllViews();
            this.aYe = this.aYd.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aYe) {
                    if (this.aYd.getAdapter() instanceof a) {
                        aw(i2, ((a) this.aYd.getAdapter()).fZ(i2));
                    } else {
                        h(i2, this.aYd.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.currentPosition = CommonPagerSlidingTabStrip.this.aYd.getCurrentItem();
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
                CommonPagerSlidingTabStrip.this.aYd.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.aYm, this.aYn, this.aYo, this.aYp);
        this.aYc.addView(view, i, this.aYh ? this.aXZ : this.aXY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aYe; i++) {
            View childAt = this.aYc.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aYv);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aYr);
                    textView.setTypeface(this.aYs, this.aYt);
                    if (i == this.aYd.getCurrentItem()) {
                        textView.setTextColor(this.aYi);
                    } else {
                        textView.setTextColor(this.aYj);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aYe != 0) {
            int left = this.aYc.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aYk;
            }
            if (left != this.aYu) {
                this.aYu = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aYe != 0 && this.aYc.getChildCount() > 1) {
            int height = getHeight();
            this.aYg.setColor(this.aYi);
            View childAt = this.aYc.getChildAt(this.currentPosition);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.aYf > 0.0f && this.currentPosition < this.aYe - 1) {
                View childAt2 = this.aYc.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.aYf)) + (childAt2.getLeft() * this.aYf);
                right = (right * (1.0f - this.aYf)) + (childAt2.getRight() * this.aYf);
            }
            if (right - left < this.aYq) {
                canvas.drawRect(left, height - this.aYl, right, height, this.aYg);
            } else {
                canvas.drawRect(left + (((right - left) - this.aYq) / 2.0f), height - this.aYl, right - (((right - left) - this.aYq) / 2.0f), height, this.aYg);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aYi = aj.getColor(i, this.aYi);
        this.aYj = aj.getColor(i, this.aYj);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.aYc.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.currentPosition = i;
                CommonPagerSlidingTabStrip.this.aYf = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.aYc.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.aYb != null) {
                    CommonPagerSlidingTabStrip.this.aYb.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.aYc.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.aYd.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.aYb != null) {
                    CommonPagerSlidingTabStrip.this.aYb.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.aYb != null) {
                CommonPagerSlidingTabStrip.this.aYb.onPageSelected(i);
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
            /* renamed from: ga */
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
