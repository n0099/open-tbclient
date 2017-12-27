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
    private LinearLayout.LayoutParams aXZ;
    private LinearLayout.LayoutParams aYa;
    private final b aYb;
    public ViewPager.OnPageChangeListener aYc;
    private LinearLayout aYd;
    private ViewPager aYe;
    private int aYf;
    private float aYg;
    private Paint aYh;
    private boolean aYi;
    private int aYj;
    private int aYk;
    private int aYl;
    private int aYm;
    private int aYn;
    private int aYo;
    private int aYp;
    private int aYq;
    private int aYr;
    private int aYs;
    private Typeface aYt;
    private int aYu;
    private int aYv;
    private int aYw;
    private int currentPosition;

    /* loaded from: classes.dex */
    public interface a {
        int gb(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aYb = new b();
        this.currentPosition = 0;
        this.aYg = 0.0f;
        this.aYi = false;
        this.aYj = aj.getColor(d.C0108d.cp_cont_b);
        this.aYk = aj.getColor(d.C0108d.cp_cont_j);
        this.aYl = 52;
        this.aYm = 4;
        this.aYn = 24;
        this.aYo = 24;
        this.aYp = 24;
        this.aYq = 24;
        this.aYr = 40;
        this.aYs = 12;
        this.aYt = null;
        this.aYu = 0;
        this.aYv = 0;
        this.aYw = d.f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aYd = new LinearLayout(getContext());
        this.aYd.setOrientation(0);
        this.aYd.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aYd);
        this.aYh = new Paint();
        this.aYh.setAntiAlias(true);
        this.aYh.setStyle(Paint.Style.FILL);
        this.aXZ = new LinearLayout.LayoutParams(-2, -1);
        this.aYa = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.aYs = i;
        this.aYn = i2;
        this.aYo = i3;
        this.aYp = i4;
        this.aYq = i5;
        this.aYm = i6;
        this.aYr = i7;
        this.aYk = i8;
        this.aYj = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aYe = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.aYb);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aYc = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aYe != null && this.aYe.getAdapter() != null && this.aYe.getAdapter().getCount() != 0) {
            this.aYd.removeAllViews();
            this.aYf = this.aYe.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aYf) {
                    if (this.aYe.getAdapter() instanceof a) {
                        aw(i2, ((a) this.aYe.getAdapter()).gb(i2));
                    } else {
                        h(i2, this.aYe.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.currentPosition = CommonPagerSlidingTabStrip.this.aYe.getCurrentItem();
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
                CommonPagerSlidingTabStrip.this.aYe.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.aYn, this.aYo, this.aYp, this.aYq);
        this.aYd.addView(view, i, this.aYi ? this.aYa : this.aXZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aYf; i++) {
            View childAt = this.aYd.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aYw);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aYs);
                    textView.setTypeface(this.aYt, this.aYu);
                    if (i == this.aYe.getCurrentItem()) {
                        textView.setTextColor(this.aYj);
                    } else {
                        textView.setTextColor(this.aYk);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aYf != 0) {
            int left = this.aYd.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aYl;
            }
            if (left != this.aYv) {
                this.aYv = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aYf != 0 && this.aYd.getChildCount() > 1) {
            int height = getHeight();
            this.aYh.setColor(this.aYj);
            View childAt = this.aYd.getChildAt(this.currentPosition);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.aYg > 0.0f && this.currentPosition < this.aYf - 1) {
                View childAt2 = this.aYd.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.aYg)) + (childAt2.getLeft() * this.aYg);
                right = (right * (1.0f - this.aYg)) + (childAt2.getRight() * this.aYg);
            }
            if (right - left < this.aYr) {
                canvas.drawRect(left, height - this.aYm, right, height, this.aYh);
            } else {
                canvas.drawRect(left + (((right - left) - this.aYr) / 2.0f), height - this.aYm, right - (((right - left) - this.aYr) / 2.0f), height, this.aYh);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aYj = aj.getColor(i, this.aYj);
        this.aYk = aj.getColor(i, this.aYk);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.aYd.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.currentPosition = i;
                CommonPagerSlidingTabStrip.this.aYg = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.aYd.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.aYc != null) {
                    CommonPagerSlidingTabStrip.this.aYc.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.aYd.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.aYe.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.aYc != null) {
                    CommonPagerSlidingTabStrip.this.aYc.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.aYc != null) {
                CommonPagerSlidingTabStrip.this.aYc.onPageSelected(i);
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
            /* renamed from: gc */
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
