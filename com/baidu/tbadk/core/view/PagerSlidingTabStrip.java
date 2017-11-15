package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
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
    private int ajA;
    private float ajB;
    private Paint ajC;
    private boolean ajD;
    private int ajE;
    private int ajF;
    private int ajG;
    private int ajH;
    private int ajN;
    private Typeface ajO;
    private int ajP;
    private int ajQ;
    private int ajR;
    private LinearLayout.LayoutParams aju;
    private LinearLayout.LayoutParams ajv;
    public ViewPager.OnPageChangeListener ajx;
    private LinearLayout ajy;
    private ViewPager ajz;
    private final b ama;
    private int amb;
    private int amc;
    private int amd;
    private int ame;
    private int currentPosition;
    private int dividerPadding;
    private Locale locale;

    /* loaded from: classes.dex */
    public interface a {
        int db(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ama = new b();
        this.currentPosition = 0;
        this.ajB = 0.0f;
        this.ajD = false;
        this.ajE = aj.getColor(d.C0080d.cp_cont_b);
        this.ajF = aj.getColor(d.C0080d.cp_cont_j);
        this.amb = aj.getColor(d.C0080d.cp_bg_line_c);
        this.ajG = 52;
        this.ajH = 4;
        this.amc = 2;
        this.dividerPadding = 12;
        this.amd = 24;
        this.ame = 1;
        this.ajN = 12;
        this.ajO = null;
        this.ajP = 0;
        this.ajQ = 0;
        this.ajR = d.f.pager_sliding_view;
    }

    public void init(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.ajy = new LinearLayout(getContext());
        this.ajy.setOrientation(0);
        this.ajy.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.ajy);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.ajG = (int) TypedValue.applyDimension(1, this.ajG, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.amd = (int) TypedValue.applyDimension(1, this.amd, displayMetrics);
        this.ame = (int) TypedValue.applyDimension(1, this.ame, displayMetrics);
        this.ajN = i;
        this.ajH = i3;
        this.amc = i2;
        this.ajD = z;
        this.ajC = new Paint();
        this.ajC.setAntiAlias(true);
        this.ajC.setStyle(Paint.Style.FILL);
        this.aju = new LinearLayout.LayoutParams(-2, -1);
        this.ajv = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.ajz = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.ama);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ajx = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.ajz != null && this.ajz.getAdapter() != null && this.ajz.getAdapter().getCount() != 0) {
            this.ajy.removeAllViews();
            this.ajA = this.ajz.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ajA) {
                    if (this.ajz.getAdapter() instanceof a) {
                        w(i2, ((a) this.ajz.getAdapter()).db(i2));
                    } else {
                        i(i2, this.ajz.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.ajz.getCurrentItem();
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
                PagerSlidingTabStrip.this.ajz.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.amd, 0, this.amd, 0);
        this.ajy.addView(view, i, this.ajD ? this.ajv : this.aju);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.ajA; i++) {
            View childAt = this.ajy.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.ajR);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.ajN);
                    textView.setTypeface(this.ajO, this.ajP);
                    if (i == this.ajz.getCurrentItem()) {
                        textView.setTextColor(this.ajE);
                    } else {
                        textView.setTextColor(this.ajF);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i, int i2) {
        if (this.ajA != 0) {
            int left = this.ajy.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.ajG;
            }
            if (left != this.ajQ) {
                this.ajQ = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.ajA != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds130);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds64);
            this.ajC.setColor(this.ajE);
            float left = dimensionPixelSize + this.ajy.getChildAt(this.currentPosition).getLeft();
            canvas.drawRoundRect(new RectF(left, height - this.ajH, dimensionPixelSize2 + left, height), 10.0f, 10.0f, this.ajC);
        }
    }

    public void onChangeSkinType() {
        this.ajE = aj.getColor(d.C0080d.cp_cont_b);
        this.ajF = aj.getColor(d.C0080d.cp_cont_j);
        this.amb = aj.getColor(d.C0080d.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.ajy.getChildCount() != 0) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.ajB = f;
                PagerSlidingTabStrip.this.x(i, (int) (PagerSlidingTabStrip.this.ajy.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.ajx != null) {
                    PagerSlidingTabStrip.this.ajx.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.ajy.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.x(PagerSlidingTabStrip.this.ajz.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.ajx != null) {
                    PagerSlidingTabStrip.this.ajx.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.ajx != null) {
                PagerSlidingTabStrip.this.ajx.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
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
            /* renamed from: ds */
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
