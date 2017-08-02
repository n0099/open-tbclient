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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams alH;
    private LinearLayout.LayoutParams alI;
    private final b alJ;
    public ViewPager.OnPageChangeListener alK;
    private LinearLayout alL;
    private ViewPager alM;
    private int alN;
    private float alO;
    private Paint alP;
    private boolean alQ;
    private int alR;
    private int alS;
    private int alT;
    private int alU;
    private int alV;
    private int alW;
    private int alX;
    private int alY;
    private int alZ;
    private Typeface ama;
    private int amb;
    private int amc;
    private int amd;
    private int currentPosition;
    private int dividerPadding;
    private Locale locale;

    /* loaded from: classes.dex */
    public interface a {
        int dj(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alJ = new b();
        this.currentPosition = 0;
        this.alO = 0.0f;
        this.alQ = false;
        this.alR = ai.getColor(d.e.cp_link_tip_a);
        this.alS = ai.getColor(d.e.cp_cont_f);
        this.alT = ai.getColor(d.e.cp_bg_line_c);
        this.alU = 52;
        this.alV = 4;
        this.alW = 2;
        this.dividerPadding = 12;
        this.alX = 24;
        this.alY = 1;
        this.alZ = 12;
        this.ama = null;
        this.amb = 0;
        this.amc = 0;
        this.amd = d.g.pager_sliding_view;
    }

    public void init(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.alL = new LinearLayout(getContext());
        this.alL.setOrientation(0);
        this.alL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.alL);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.alU = (int) TypedValue.applyDimension(1, this.alU, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.alX = (int) TypedValue.applyDimension(1, this.alX, displayMetrics);
        this.alY = (int) TypedValue.applyDimension(1, this.alY, displayMetrics);
        this.alZ = i;
        this.alV = i3;
        this.alW = i2;
        this.alQ = z;
        this.alP = new Paint();
        this.alP.setAntiAlias(true);
        this.alP.setStyle(Paint.Style.FILL);
        this.alH = new LinearLayout.LayoutParams(-2, -1);
        this.alI = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.alM = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.alJ);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.alK = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.alM != null && this.alM.getAdapter() != null && this.alM.getAdapter().getCount() != 0) {
            this.alL.removeAllViews();
            this.alN = this.alM.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.alN) {
                    if (this.alM.getAdapter() instanceof a) {
                        C(i2, ((a) this.alM.getAdapter()).dj(i2));
                    } else {
                        i(i2, this.alM.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    wI();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.alM.getCurrentItem();
                            PagerSlidingTabStrip.this.D(PagerSlidingTabStrip.this.currentPosition, 0);
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

    private void C(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        a(i, imageButton);
    }

    private void a(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.alM.setCurrentItem(i);
                PagerSlidingTabStrip.this.wI();
            }
        });
        view.setPadding(this.alX, 0, this.alX, 0);
        this.alL.addView(view, i, this.alQ ? this.alI : this.alH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wI() {
        for (int i = 0; i < this.alN; i++) {
            View childAt = this.alL.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.amd);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.alZ);
                    textView.setTypeface(this.ama, this.amb);
                    if (i == this.alM.getCurrentItem()) {
                        textView.setTextColor(this.alR);
                    } else {
                        textView.setTextColor(this.alS);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i, int i2) {
        if (this.alN != 0) {
            int left = this.alL.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.alU;
            }
            if (left != this.amc) {
                this.amc = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.alN != 0) {
            int height = getHeight();
            this.alP.setColor(this.alR);
            View childAt = this.alL.getChildAt(this.currentPosition);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.alO > 0.0f && this.currentPosition < this.alN - 1) {
                View childAt2 = this.alL.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.alO)) + (childAt2.getLeft() * this.alO);
                right = (childAt2.getRight() * this.alO) + ((1.0f - this.alO) * right);
            }
            canvas.drawRect(left, height - this.alV, right, height, this.alP);
            this.alP.setColor(this.alT);
            canvas.drawRect(0.0f, height - this.alW, this.alL.getWidth(), height, this.alP);
        }
    }

    public void onChangeSkinType() {
        this.alR = ai.getColor(d.e.cp_link_tip_a);
        this.alS = ai.getColor(d.e.cp_cont_f);
        this.alT = ai.getColor(d.e.cp_bg_line_c);
        wI();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.alL.getChildCount() != 0) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.alO = f;
                PagerSlidingTabStrip.this.D(i, (int) (PagerSlidingTabStrip.this.alL.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.alK != null) {
                    PagerSlidingTabStrip.this.alK.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.alL.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.D(PagerSlidingTabStrip.this.alM.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.alK != null) {
                    PagerSlidingTabStrip.this.alK.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.alK != null) {
                PagerSlidingTabStrip.this.alK.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.wI();
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
            /* renamed from: g */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: dk */
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
