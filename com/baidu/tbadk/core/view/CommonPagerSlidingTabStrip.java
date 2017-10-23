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
    private LinearLayout.LayoutParams aiY;
    private LinearLayout.LayoutParams aiZ;
    private final b aja;
    public ViewPager.OnPageChangeListener ajb;
    private LinearLayout ajc;
    private ViewPager ajd;
    private int aje;
    private float ajf;
    private Paint ajg;
    private boolean ajh;
    private int aji;
    private int ajj;
    private int ajk;
    private int ajl;
    private int ajm;
    private int ajn;
    private int ajo;
    private int ajp;
    private int ajq;
    private int ajr;
    private Typeface ajs;
    private int ajt;
    private int aju;
    private int ajv;
    private int currentPosition;

    /* loaded from: classes.dex */
    public interface a {
        int db(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aja = new b();
        this.currentPosition = 0;
        this.ajf = 0.0f;
        this.ajh = false;
        this.aji = aj.getColor(d.e.cp_cont_b);
        this.ajj = aj.getColor(d.e.cp_cont_j);
        this.ajk = 52;
        this.ajl = 4;
        this.ajm = 24;
        this.ajn = 24;
        this.ajo = 24;
        this.ajp = 24;
        this.ajq = 40;
        this.ajr = 12;
        this.ajs = null;
        this.ajt = 0;
        this.aju = 0;
        this.ajv = d.g.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.ajc = new LinearLayout(getContext());
        this.ajc.setOrientation(0);
        this.ajc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.ajc);
        this.ajg = new Paint();
        this.ajg.setAntiAlias(true);
        this.ajg.setStyle(Paint.Style.FILL);
        this.aiY = new LinearLayout.LayoutParams(-2, -1);
        this.aiZ = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.ajr = i;
        this.ajm = i2;
        this.ajn = i3;
        this.ajo = i4;
        this.ajp = i5;
        this.ajl = i6;
        this.ajq = i7;
        this.ajj = i8;
        this.aji = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ajd = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.aja);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ajb = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.ajd != null && this.ajd.getAdapter() != null && this.ajd.getAdapter().getCount() != 0) {
            this.ajc.removeAllViews();
            this.aje = this.ajd.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aje) {
                    if (this.ajd.getAdapter() instanceof a) {
                        w(i2, ((a) this.ajd.getAdapter()).db(i2));
                    } else {
                        i(i2, this.ajd.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    vU();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.currentPosition = CommonPagerSlidingTabStrip.this.ajd.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.x(CommonPagerSlidingTabStrip.this.currentPosition, 0);
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
        a(i, textView);
    }

    private void w(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        a(i, imageButton);
    }

    private void a(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.ajd.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.vU();
            }
        });
        view.setPadding(this.ajm, this.ajn, this.ajo, this.ajp);
        this.ajc.addView(view, i, this.ajh ? this.aiZ : this.aiY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vU() {
        for (int i = 0; i < this.aje; i++) {
            View childAt = this.ajc.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.ajv);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.ajr);
                    textView.setTypeface(this.ajs, this.ajt);
                    if (i == this.ajd.getCurrentItem()) {
                        textView.setTextColor(this.aji);
                    } else {
                        textView.setTextColor(this.ajj);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i, int i2) {
        if (this.aje != 0) {
            int left = this.ajc.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.ajk;
            }
            if (left != this.aju) {
                this.aju = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aje != 0 && this.ajc.getChildCount() > 1) {
            int height = getHeight();
            this.ajg.setColor(this.aji);
            View childAt = this.ajc.getChildAt(this.currentPosition);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.ajf > 0.0f && this.currentPosition < this.aje - 1) {
                View childAt2 = this.ajc.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.ajf)) + (childAt2.getLeft() * this.ajf);
                right = (right * (1.0f - this.ajf)) + (childAt2.getRight() * this.ajf);
            }
            if (right - left < this.ajq) {
                canvas.drawRect(left, height - this.ajl, right, height, this.ajg);
            } else {
                canvas.drawRect(left + (((right - left) - this.ajq) / 2.0f), height - this.ajl, right - (((right - left) - this.ajq) / 2.0f), height, this.ajg);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aji = aj.getColor(i, this.aji);
        this.ajj = aj.getColor(i, this.ajj);
        vU();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.ajc.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.currentPosition = i;
                CommonPagerSlidingTabStrip.this.ajf = f;
                CommonPagerSlidingTabStrip.this.x(i, (int) (CommonPagerSlidingTabStrip.this.ajc.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.ajb != null) {
                    CommonPagerSlidingTabStrip.this.ajb.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.ajc.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.x(CommonPagerSlidingTabStrip.this.ajd.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.ajb != null) {
                    CommonPagerSlidingTabStrip.this.ajb.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.ajb != null) {
                CommonPagerSlidingTabStrip.this.ajb.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.vU();
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
            /* renamed from: e */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: dc */
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
