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
import com.baidu.tieba.d;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private int Ur;
    private LinearLayout.LayoutParams bOF;
    private LinearLayout.LayoutParams bOG;
    public ViewPager.OnPageChangeListener bOI;
    private LinearLayout bOJ;
    private ViewPager bOK;
    private int bOL;
    private float bOM;
    private Paint bON;
    private boolean bOO;
    private int bOP;
    private int bOQ;
    private int bOR;
    private int bOS;
    private int bOY;
    private Typeface bOZ;
    private int bPa;
    private int bPb;
    private int bPc;
    private final b bRd;
    private int bRe;
    private int bRf;
    private int bRg;
    private int dividerPadding;
    private Locale locale;
    private int tabPadding;

    /* loaded from: classes.dex */
    public interface a {
        int hH(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bRd = new b();
        this.Ur = 0;
        this.bOM = 0.0f;
        this.bOO = false;
        this.bOP = al.getColor(d.C0236d.cp_cont_b);
        this.bOQ = al.getColor(d.C0236d.cp_cont_j);
        this.bRe = al.getColor(d.C0236d.cp_bg_line_c);
        this.bOR = 52;
        this.bOS = 4;
        this.bRf = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.bRg = 1;
        this.bOY = 12;
        this.bOZ = null;
        this.bPa = 0;
        this.bPb = 0;
        this.bPc = d.f.pager_sliding_view;
    }

    public void d(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bOJ = new LinearLayout(getContext());
        this.bOJ.setOrientation(0);
        this.bOJ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bOJ);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.bOR = (int) TypedValue.applyDimension(1, this.bOR, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.bRg = (int) TypedValue.applyDimension(1, this.bRg, displayMetrics);
        this.bOY = i;
        this.bOS = i3;
        this.bRf = i2;
        this.bOO = z;
        this.bON = new Paint();
        this.bON.setAntiAlias(true);
        this.bON.setStyle(Paint.Style.FILL);
        this.bOF = new LinearLayout.LayoutParams(-2, -1);
        this.bOG = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.bOK = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.bRd);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bOI = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bOK != null && this.bOK.getAdapter() != null && this.bOK.getAdapter().getCount() != 0) {
            this.bOJ.removeAllViews();
            this.bOL = this.bOK.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bOL) {
                    if (this.bOK.getAdapter() instanceof a) {
                        X(i2, ((a) this.bOK.getAdapter()).hH(i2));
                    } else {
                        A(i2, this.bOK.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.Ur = PagerSlidingTabStrip.this.bOK.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.Ur, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void A(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        e(i, textView);
    }

    private void X(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        e(i, imageButton);
    }

    private void e(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.bOK.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.bOJ.addView(view, i, this.bOO ? this.bOG : this.bOF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.bOL; i++) {
            View childAt = this.bOJ.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bPc);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.bOY);
                    textView.setTypeface(this.bOZ, this.bPa);
                    if (i == this.bOK.getCurrentItem()) {
                        textView.setTextColor(this.bOP);
                    } else {
                        textView.setTextColor(this.bOQ);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bOL != 0) {
            int left = this.bOJ.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.bOR;
            }
            if (left != this.bPb) {
                this.bPb = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.bOL != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
            this.bON.setColor(this.bOP);
            View childAt = this.bOJ.getChildAt(this.Ur);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.bOS, dimensionPixelSize + width, height), 10.0f, 10.0f, this.bON);
        }
    }

    public void onChangeSkinType() {
        this.bOP = al.getColor(d.C0236d.cp_cont_b);
        this.bOQ = al.getColor(d.C0236d.cp_cont_j);
        this.bRe = al.getColor(d.C0236d.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.bOJ.getChildCount() != 0) {
                PagerSlidingTabStrip.this.Ur = i;
                PagerSlidingTabStrip.this.bOM = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.bOJ.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.bOI != null) {
                    PagerSlidingTabStrip.this.bOI.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.bOJ.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.bOK.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.bOI != null) {
                    PagerSlidingTabStrip.this.bOI.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.bOI != null) {
                PagerSlidingTabStrip.this.bOI.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Ur = savedState.Ur;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Ur = this.Ur;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: y */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: hW */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Ur;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Ur = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ur);
        }
    }
}
