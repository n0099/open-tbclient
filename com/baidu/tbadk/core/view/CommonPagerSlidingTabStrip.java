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
    private LinearLayout.LayoutParams aFT;
    private LinearLayout.LayoutParams aFU;
    private final b aFV;
    public ViewPager.OnPageChangeListener aFW;
    private LinearLayout aFX;
    private ViewPager aFY;
    private int aFZ;
    private int aGa;
    private float aGb;
    private Paint aGc;
    private boolean aGd;
    private int aGe;
    private int aGf;
    private int aGg;
    private int aGh;
    private int aGi;
    private int aGj;
    private int aGk;
    private int aGl;
    private int aGm;
    private int aGn;
    private Typeface aGo;
    private int aGp;
    private int aGq;
    private int aGr;

    /* loaded from: classes.dex */
    public interface a {
        int ed(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFV = new b();
        this.aGa = 0;
        this.aGb = 0.0f;
        this.aGd = false;
        this.aGe = al.getColor(e.d.cp_cont_b);
        this.aGf = al.getColor(e.d.cp_cont_j);
        this.aGg = 52;
        this.aGh = 4;
        this.aGi = 24;
        this.aGj = 24;
        this.aGk = 24;
        this.aGl = 24;
        this.aGm = 40;
        this.aGn = 12;
        this.aGo = null;
        this.aGp = 0;
        this.aGq = 0;
        this.aGr = e.f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aFX = new LinearLayout(getContext());
        this.aFX.setOrientation(0);
        this.aFX.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aFX);
        this.aGc = new Paint();
        this.aGc.setAntiAlias(true);
        this.aGc.setStyle(Paint.Style.FILL);
        this.aFT = new LinearLayout.LayoutParams(-2, -1);
        this.aFU = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.aGn = i;
        this.aGi = i2;
        this.aGj = i3;
        this.aGk = i4;
        this.aGl = i5;
        this.aGh = i6;
        this.aGm = i7;
        this.aGf = i8;
        this.aGe = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aFY = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.aFV);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aFW = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aFY != null && this.aFY.getAdapter() != null && this.aFY.getAdapter().getCount() != 0) {
            this.aFX.removeAllViews();
            this.aFZ = this.aFY.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aFZ) {
                    if (this.aFY.getAdapter() instanceof a) {
                        B(i2, ((a) this.aFY.getAdapter()).ed(i2));
                    } else {
                        i(i2, this.aFY.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.aGa = CommonPagerSlidingTabStrip.this.aFY.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.aGa, 0);
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

    private void B(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        b(i, imageButton);
    }

    private void b(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.aFY.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.aGi, this.aGj, this.aGk, this.aGl);
        this.aFX.addView(view, i, this.aGd ? this.aFU : this.aFT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aFZ; i++) {
            View childAt = this.aFX.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aGr);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aGn);
                    textView.setTypeface(this.aGo, this.aGp);
                    if (i == this.aFY.getCurrentItem()) {
                        textView.setTextColor(this.aGe);
                    } else {
                        textView.setTextColor(this.aGf);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aFZ != 0) {
            int left = this.aFX.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aGg;
            }
            if (left != this.aGq) {
                this.aGq = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aFZ != 0 && this.aFX.getChildCount() > 1) {
            int height = getHeight();
            this.aGc.setColor(this.aGe);
            View childAt = this.aFX.getChildAt(this.aGa);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.aGb > 0.0f && this.aGa < this.aFZ - 1) {
                View childAt2 = this.aFX.getChildAt(this.aGa + 1);
                left = (left * (1.0f - this.aGb)) + (childAt2.getLeft() * this.aGb);
                right = (right * (1.0f - this.aGb)) + (childAt2.getRight() * this.aGb);
            }
            if (right - left < this.aGm) {
                canvas.drawRect(left, height - this.aGh, right, height, this.aGc);
            } else {
                canvas.drawRect(left + (((right - left) - this.aGm) / 2.0f), height - this.aGh, right - (((right - left) - this.aGm) / 2.0f), height, this.aGc);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aGe = al.getColor(i, this.aGe);
        this.aGf = al.getColor(i, this.aGf);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.aFX.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.aGa = i;
                CommonPagerSlidingTabStrip.this.aGb = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.aFX.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.aFW != null) {
                    CommonPagerSlidingTabStrip.this.aFW.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.aFX.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.aFY.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.aFW != null) {
                    CommonPagerSlidingTabStrip.this.aFW.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.aFW != null) {
                CommonPagerSlidingTabStrip.this.aFW.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aGa = savedState.aGa;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aGa = this.aGa;
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
            /* renamed from: ee */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int aGa;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aGa = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aGa);
        }
    }
}
