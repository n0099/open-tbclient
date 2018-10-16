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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams aBE;
    private LinearLayout.LayoutParams aBF;
    public ViewPager.OnPageChangeListener aBH;
    private LinearLayout aBI;
    private ViewPager aBJ;
    private int aBK;
    private int aBL;
    private float aBM;
    private Paint aBN;
    private boolean aBO;
    private int aBP;
    private int aBQ;
    private int aBR;
    private int aBS;
    private int aBY;
    private Typeface aBZ;
    private int aCa;
    private int aCb;
    private int aCc;
    private final b aDS;
    private int aDT;
    private int aDU;
    private int dividerPadding;
    private int dividerWidth;
    private Locale locale;
    private int tabPadding;

    /* loaded from: classes.dex */
    public interface a {
        int dB(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDS = new b();
        this.aBL = 0;
        this.aBM = 0.0f;
        this.aBO = false;
        this.aBP = al.getColor(e.d.cp_cont_b);
        this.aBQ = al.getColor(e.d.cp_cont_j);
        this.aDT = al.getColor(e.d.cp_bg_line_c);
        this.aBR = 52;
        this.aBS = 4;
        this.aDU = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dividerWidth = 1;
        this.aBY = 12;
        this.aBZ = null;
        this.aCa = 0;
        this.aCb = 0;
        this.aCc = e.f.pager_sliding_view;
    }

    public void a(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aBI = new LinearLayout(getContext());
        this.aBI.setOrientation(0);
        this.aBI.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aBI);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aBR = (int) TypedValue.applyDimension(1, this.aBR, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.aBY = i;
        this.aBS = i3;
        this.aDU = i2;
        this.aBO = z;
        this.aBN = new Paint();
        this.aBN.setAntiAlias(true);
        this.aBN.setStyle(Paint.Style.FILL);
        this.aBE = new LinearLayout.LayoutParams(-2, -1);
        this.aBF = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.aBJ = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.aDS);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aBH = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aBJ != null && this.aBJ.getAdapter() != null && this.aBJ.getAdapter().getCount() != 0) {
            this.aBI.removeAllViews();
            this.aBK = this.aBJ.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aBK) {
                    if (this.aBJ.getAdapter() instanceof a) {
                        A(i2, ((a) this.aBJ.getAdapter()).dB(i2));
                    } else {
                        j(i2, this.aBJ.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.aBL = PagerSlidingTabStrip.this.aBJ.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aBL, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void j(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        b(i, textView);
    }

    private void A(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        b(i, imageButton);
    }

    private void b(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.aBJ.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aBI.addView(view, i, this.aBO ? this.aBF : this.aBE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aBK; i++) {
            View childAt = this.aBI.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aCc);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aBY);
                    textView.setTypeface(this.aBZ, this.aCa);
                    if (i == this.aBJ.getCurrentItem()) {
                        textView.setTextColor(this.aBP);
                    } else {
                        textView.setTextColor(this.aBQ);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aBK != 0) {
            int left = this.aBI.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aBR;
            }
            if (left != this.aCb) {
                this.aCb = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aBK != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0175e.ds64);
            this.aBN.setColor(this.aBP);
            View childAt = this.aBI.getChildAt(this.aBL);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.aBS, dimensionPixelSize + width, height), 10.0f, 10.0f, this.aBN);
        }
    }

    public void onChangeSkinType() {
        this.aBP = al.getColor(e.d.cp_cont_b);
        this.aBQ = al.getColor(e.d.cp_cont_j);
        this.aDT = al.getColor(e.d.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aBI.getChildCount() != 0) {
                PagerSlidingTabStrip.this.aBL = i;
                PagerSlidingTabStrip.this.aBM = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aBI.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.aBH != null) {
                    PagerSlidingTabStrip.this.aBH.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aBI.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aBJ.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.aBH != null) {
                    PagerSlidingTabStrip.this.aBH.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aBH != null) {
                PagerSlidingTabStrip.this.aBH.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aBL = savedState.aBL;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aBL = this.aBL;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: i */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: dQ */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int aBL;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aBL = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aBL);
        }
    }
}
