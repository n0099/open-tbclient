package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private int abv;
    private int ffA;
    private int ffB;
    private LinearLayout.LayoutParams fff;
    private LinearLayout.LayoutParams ffg;
    private final b ffh;
    public ViewPager.OnPageChangeListener ffi;
    private LinearLayout ffj;
    private ViewPager ffk;
    private int ffl;
    private float ffm;
    private Paint ffn;
    private boolean ffo;
    private int ffp;
    private int ffq;
    private int ffr;
    private int ffs;
    private int fft;
    private int ffu;
    private int ffv;
    private int ffw;
    private int ffx;
    private int ffy;
    private Typeface ffz;
    private int tabBackgroundResId;

    /* loaded from: classes.dex */
    public interface a {
        int po(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ffh = new b();
        this.abv = 0;
        this.ffm = 0.0f;
        this.ffo = false;
        this.ffp = ap.getColor(R.color.CAM_X0105);
        this.ffq = ap.getColor(R.color.CAM_X0107);
        this.ffr = 52;
        this.ffs = 4;
        this.fft = 24;
        this.ffu = 24;
        this.ffv = 24;
        this.ffw = 24;
        this.ffx = 40;
        this.ffy = 12;
        this.ffz = null;
        this.ffA = 0;
        this.ffB = 0;
        this.tabBackgroundResId = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.ffj = new LinearLayout(getContext());
        this.ffj.setOrientation(0);
        this.ffj.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.ffj);
        this.ffn = new Paint();
        this.ffn.setAntiAlias(true);
        this.ffn.setStyle(Paint.Style.FILL);
        this.fff = new LinearLayout.LayoutParams(-2, -1);
        this.ffg = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.ffy = i;
        this.fft = i2;
        this.ffu = i3;
        this.ffv = i4;
        this.ffw = i5;
        this.ffs = i6;
        this.ffx = i7;
        this.ffq = i8;
        this.ffp = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ffk = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.ffh);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ffi = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.ffk != null && this.ffk.getAdapter() != null && this.ffk.getAdapter().getCount() != 0) {
            this.ffj.removeAllViews();
            this.ffl = this.ffk.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ffl) {
                    if (this.ffk.getAdapter() instanceof a) {
                        aP(i2, ((a) this.ffk.getAdapter()).po(i2));
                    } else {
                        aK(i2, this.ffk.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.abv = CommonPagerSlidingTabStrip.this.ffk.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.abv, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void aK(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        d(i, textView);
    }

    private void aP(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.ffk.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.fft, this.ffu, this.ffv, this.ffw);
        this.ffj.addView(view, i, this.ffo ? this.ffg : this.fff);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.ffl; i++) {
            View childAt = this.ffj.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.tabBackgroundResId);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.ffy);
                    textView.setTypeface(this.ffz, this.ffA);
                    if (i == this.ffk.getCurrentItem()) {
                        textView.setTextColor(this.ffp);
                    } else {
                        textView.setTextColor(this.ffq);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.ffl != 0) {
            int left = this.ffj.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.ffr;
            }
            if (left != this.ffB) {
                this.ffB = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.ffl != 0 && this.ffj.getChildCount() > 1) {
            int height = getHeight();
            this.ffn.setColor(this.ffp);
            View childAt = this.ffj.getChildAt(this.abv);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.ffm > 0.0f && this.abv < this.ffl - 1) {
                View childAt2 = this.ffj.getChildAt(this.abv + 1);
                left = (left * (1.0f - this.ffm)) + (childAt2.getLeft() * this.ffm);
                right = (right * (1.0f - this.ffm)) + (childAt2.getRight() * this.ffm);
            }
            if (right - left < this.ffx) {
                canvas.drawRect(left, height - this.ffs, right, height, this.ffn);
            } else {
                canvas.drawRect(left + (((right - left) - this.ffx) / 2.0f), height - this.ffs, right - (((right - left) - this.ffx) / 2.0f), height, this.ffn);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.ffp = ap.getColor(i, this.ffp);
        this.ffq = ap.getColor(i, this.ffq);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.ffj.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.abv = i;
                CommonPagerSlidingTabStrip.this.ffm = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.ffj.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.ffi != null) {
                    CommonPagerSlidingTabStrip.this.ffi.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.ffj.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.ffk.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.ffi != null) {
                    CommonPagerSlidingTabStrip.this.ffi.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.ffi != null) {
                CommonPagerSlidingTabStrip.this.ffi.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.abv = savedState.abv;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.abv = this.abv;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: P */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: pp */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int abv;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.abv = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.abv);
        }
    }
}
