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
    private LinearLayout.LayoutParams ajQ;
    private LinearLayout.LayoutParams ajR;
    public ViewPager.OnPageChangeListener ajT;
    private LinearLayout ajU;
    private ViewPager ajV;
    private int ajW;
    private float ajX;
    private Paint ajY;
    private boolean ajZ;
    private int aka;
    private int akb;
    private int akc;
    private int akd;
    private int akj;
    private Typeface akk;
    private int akl;
    private int akm;
    private int akn;
    private int amA;
    private final b amw;
    private int amx;
    private int amy;
    private int amz;
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
        this.amw = new b();
        this.currentPosition = 0;
        this.ajX = 0.0f;
        this.ajZ = false;
        this.aka = aj.getColor(d.C0082d.cp_cont_b);
        this.akb = aj.getColor(d.C0082d.cp_cont_j);
        this.amx = aj.getColor(d.C0082d.cp_bg_line_c);
        this.akc = 52;
        this.akd = 4;
        this.amy = 2;
        this.dividerPadding = 12;
        this.amz = 24;
        this.amA = 1;
        this.akj = 12;
        this.akk = null;
        this.akl = 0;
        this.akm = 0;
        this.akn = d.f.pager_sliding_view;
    }

    public void init(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.ajU = new LinearLayout(getContext());
        this.ajU.setOrientation(0);
        this.ajU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.ajU);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.akc = (int) TypedValue.applyDimension(1, this.akc, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.amz = (int) TypedValue.applyDimension(1, this.amz, displayMetrics);
        this.amA = (int) TypedValue.applyDimension(1, this.amA, displayMetrics);
        this.akj = i;
        this.akd = i3;
        this.amy = i2;
        this.ajZ = z;
        this.ajY = new Paint();
        this.ajY.setAntiAlias(true);
        this.ajY.setStyle(Paint.Style.FILL);
        this.ajQ = new LinearLayout.LayoutParams(-2, -1);
        this.ajR = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.ajV = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.amw);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ajT = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.ajV != null && this.ajV.getAdapter() != null && this.ajV.getAdapter().getCount() != 0) {
            this.ajU.removeAllViews();
            this.ajW = this.ajV.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ajW) {
                    if (this.ajV.getAdapter() instanceof a) {
                        w(i2, ((a) this.ajV.getAdapter()).dc(i2));
                    } else {
                        i(i2, this.ajV.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.ajV.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.currentPosition, 0);
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
                PagerSlidingTabStrip.this.ajV.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.amz, 0, this.amz, 0);
        this.ajU.addView(view, i, this.ajZ ? this.ajR : this.ajQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.ajW; i++) {
            View childAt = this.ajU.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.akn);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.akj);
                    textView.setTypeface(this.akk, this.akl);
                    if (i == this.ajV.getCurrentItem()) {
                        textView.setTextColor(this.aka);
                    } else {
                        textView.setTextColor(this.akb);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.ajW != 0) {
            int left = this.ajU.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.akc;
            }
            if (left != this.akm) {
                this.akm = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.ajW != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
            this.ajY.setColor(this.aka);
            View childAt = this.ajU.getChildAt(this.currentPosition);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.akd, dimensionPixelSize + width, height), 10.0f, 10.0f, this.ajY);
        }
    }

    public void onChangeSkinType() {
        this.aka = aj.getColor(d.C0082d.cp_cont_b);
        this.akb = aj.getColor(d.C0082d.cp_cont_j);
        this.amx = aj.getColor(d.C0082d.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.ajU.getChildCount() != 0) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.ajX = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.ajU.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.ajT != null) {
                    PagerSlidingTabStrip.this.ajT.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.ajU.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.ajV.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.ajT != null) {
                    PagerSlidingTabStrip.this.ajT.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.ajT != null) {
                PagerSlidingTabStrip.this.ajT.onPageSelected(i);
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
