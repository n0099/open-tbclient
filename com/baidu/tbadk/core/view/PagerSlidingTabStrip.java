package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private int ajD;
    private Typeface ajE;
    private int ajF;
    private int ajG;
    private int ajH;
    private LinearLayout.LayoutParams ajk;
    private LinearLayout.LayoutParams ajl;
    public ViewPager.OnPageChangeListener ajn;
    private LinearLayout ajo;
    private ViewPager ajp;
    private int ajq;
    private float ajr;
    private Paint ajs;
    private boolean ajt;
    private int aju;
    private int ajv;
    private int ajw;
    private int ajx;
    private final b alR;
    private int alS;
    private int alT;
    private int alU;
    private int alV;
    private int currentPosition;
    private int dividerPadding;
    private Locale locale;

    /* loaded from: classes.dex */
    public interface a {
        int dc(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alR = new b();
        this.currentPosition = 0;
        this.ajr = 0.0f;
        this.ajt = false;
        this.aju = aj.getColor(d.e.cp_link_tip_a);
        this.ajv = aj.getColor(d.e.cp_cont_f);
        this.alS = aj.getColor(d.e.cp_bg_line_c);
        this.ajw = 52;
        this.ajx = 4;
        this.alT = 2;
        this.dividerPadding = 12;
        this.alU = 24;
        this.alV = 1;
        this.ajD = 12;
        this.ajE = null;
        this.ajF = 0;
        this.ajG = 0;
        this.ajH = d.g.pager_sliding_view;
    }

    public void init(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.ajo = new LinearLayout(getContext());
        this.ajo.setOrientation(0);
        this.ajo.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.ajo);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.ajw = (int) TypedValue.applyDimension(1, this.ajw, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.alU = (int) TypedValue.applyDimension(1, this.alU, displayMetrics);
        this.alV = (int) TypedValue.applyDimension(1, this.alV, displayMetrics);
        this.ajD = i;
        this.ajx = i3;
        this.alT = i2;
        this.ajt = z;
        this.ajs = new Paint();
        this.ajs.setAntiAlias(true);
        this.ajs.setStyle(Paint.Style.FILL);
        this.ajk = new LinearLayout.LayoutParams(-2, -1);
        this.ajl = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.ajp = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.alR);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ajn = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.ajp != null && this.ajp.getAdapter() != null && this.ajp.getAdapter().getCount() != 0) {
            this.ajo.removeAllViews();
            this.ajq = this.ajp.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ajq) {
                    if (this.ajp.getAdapter() instanceof a) {
                        w(i2, ((a) this.ajp.getAdapter()).dc(i2));
                    } else {
                        i(i2, this.ajp.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    wb();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.ajp.getCurrentItem();
                            PagerSlidingTabStrip.this.x(PagerSlidingTabStrip.this.currentPosition, 0);
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
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.ajp.setCurrentItem(i);
                PagerSlidingTabStrip.this.wb();
            }
        });
        view.setPadding(this.alU, 0, this.alU, 0);
        this.ajo.addView(view, i, this.ajt ? this.ajl : this.ajk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wb() {
        for (int i = 0; i < this.ajq; i++) {
            View childAt = this.ajo.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.ajH);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.ajD);
                    textView.setTypeface(this.ajE, this.ajF);
                    if (i == this.ajp.getCurrentItem()) {
                        textView.setTextColor(this.aju);
                    } else {
                        textView.setTextColor(this.ajv);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i, int i2) {
        if (this.ajq != 0) {
            int left = this.ajo.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.ajw;
            }
            if (left != this.ajG) {
                this.ajG = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.ajq != 0) {
            int height = getHeight();
            this.ajs.setColor(this.aju);
            View childAt = this.ajo.getChildAt(this.currentPosition);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.ajr > 0.0f && this.currentPosition < this.ajq - 1) {
                View childAt2 = this.ajo.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.ajr)) + (childAt2.getLeft() * this.ajr);
                right = (childAt2.getRight() * this.ajr) + ((1.0f - this.ajr) * right);
            }
            canvas.drawRect(left, height - this.ajx, right, height, this.ajs);
            this.ajs.setColor(this.alS);
            canvas.drawRect(0.0f, height - this.alT, this.ajo.getWidth(), height, this.ajs);
        }
    }

    public void onChangeSkinType() {
        this.aju = aj.getColor(d.e.cp_link_tip_a);
        this.ajv = aj.getColor(d.e.cp_cont_f);
        this.alS = aj.getColor(d.e.cp_bg_line_c);
        wb();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.ajo.getChildCount() != 0) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.ajr = f;
                PagerSlidingTabStrip.this.x(i, (int) (PagerSlidingTabStrip.this.ajo.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.ajn != null) {
                    PagerSlidingTabStrip.this.ajn.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.ajo.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.x(PagerSlidingTabStrip.this.ajp.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.ajn != null) {
                    PagerSlidingTabStrip.this.ajn.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.ajn != null) {
                PagerSlidingTabStrip.this.ajn.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.wb();
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
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: f */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: dt */
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
