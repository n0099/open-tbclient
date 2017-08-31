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
    private ViewPager amA;
    private int amB;
    private float amC;
    private Paint amD;
    private boolean amE;
    private int amF;
    private int amG;
    private int amH;
    private int amI;
    private int amJ;
    private int amK;
    private int amL;
    private int amM;
    private int amN;
    private Typeface amO;
    private int amP;
    private int amQ;
    private int amR;
    private LinearLayout.LayoutParams amv;
    private LinearLayout.LayoutParams amw;
    private final b amx;
    public ViewPager.OnPageChangeListener amy;
    private LinearLayout amz;
    private int currentPosition;
    private int dividerPadding;
    private Locale locale;

    /* loaded from: classes.dex */
    public interface a {
        int dm(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amx = new b();
        this.currentPosition = 0;
        this.amC = 0.0f;
        this.amE = false;
        this.amF = aj.getColor(d.e.cp_link_tip_a);
        this.amG = aj.getColor(d.e.cp_cont_f);
        this.amH = aj.getColor(d.e.cp_bg_line_c);
        this.amI = 52;
        this.amJ = 4;
        this.amK = 2;
        this.dividerPadding = 12;
        this.amL = 24;
        this.amM = 1;
        this.amN = 12;
        this.amO = null;
        this.amP = 0;
        this.amQ = 0;
        this.amR = d.g.pager_sliding_view;
    }

    public void init(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.amz = new LinearLayout(getContext());
        this.amz.setOrientation(0);
        this.amz.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.amz);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.amI = (int) TypedValue.applyDimension(1, this.amI, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.amL = (int) TypedValue.applyDimension(1, this.amL, displayMetrics);
        this.amM = (int) TypedValue.applyDimension(1, this.amM, displayMetrics);
        this.amN = i;
        this.amJ = i3;
        this.amK = i2;
        this.amE = z;
        this.amD = new Paint();
        this.amD.setAntiAlias(true);
        this.amD.setStyle(Paint.Style.FILL);
        this.amv = new LinearLayout.LayoutParams(-2, -1);
        this.amw = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.amA = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.amx);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.amy = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.amA != null && this.amA.getAdapter() != null && this.amA.getAdapter().getCount() != 0) {
            this.amz.removeAllViews();
            this.amB = this.amA.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.amB) {
                    if (this.amA.getAdapter() instanceof a) {
                        C(i2, ((a) this.amA.getAdapter()).dm(i2));
                    } else {
                        i(i2, this.amA.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    wQ();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.amA.getCurrentItem();
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
                PagerSlidingTabStrip.this.amA.setCurrentItem(i);
                PagerSlidingTabStrip.this.wQ();
            }
        });
        view.setPadding(this.amL, 0, this.amL, 0);
        this.amz.addView(view, i, this.amE ? this.amw : this.amv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wQ() {
        for (int i = 0; i < this.amB; i++) {
            View childAt = this.amz.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.amR);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.amN);
                    textView.setTypeface(this.amO, this.amP);
                    if (i == this.amA.getCurrentItem()) {
                        textView.setTextColor(this.amF);
                    } else {
                        textView.setTextColor(this.amG);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i, int i2) {
        if (this.amB != 0) {
            int left = this.amz.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.amI;
            }
            if (left != this.amQ) {
                this.amQ = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.amB != 0) {
            int height = getHeight();
            this.amD.setColor(this.amF);
            View childAt = this.amz.getChildAt(this.currentPosition);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.amC > 0.0f && this.currentPosition < this.amB - 1) {
                View childAt2 = this.amz.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.amC)) + (childAt2.getLeft() * this.amC);
                right = (childAt2.getRight() * this.amC) + ((1.0f - this.amC) * right);
            }
            canvas.drawRect(left, height - this.amJ, right, height, this.amD);
            this.amD.setColor(this.amH);
            canvas.drawRect(0.0f, height - this.amK, this.amz.getWidth(), height, this.amD);
        }
    }

    public void onChangeSkinType() {
        this.amF = aj.getColor(d.e.cp_link_tip_a);
        this.amG = aj.getColor(d.e.cp_cont_f);
        this.amH = aj.getColor(d.e.cp_bg_line_c);
        wQ();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.amz.getChildCount() != 0) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.amC = f;
                PagerSlidingTabStrip.this.D(i, (int) (PagerSlidingTabStrip.this.amz.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.amy != null) {
                    PagerSlidingTabStrip.this.amy.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.amz.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.D(PagerSlidingTabStrip.this.amA.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.amy != null) {
                    PagerSlidingTabStrip.this.amy.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.amy != null) {
                PagerSlidingTabStrip.this.amy.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.wQ();
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
            /* renamed from: e */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: dn */
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
