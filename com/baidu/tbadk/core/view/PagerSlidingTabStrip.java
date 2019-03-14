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
    private int Us;
    private LinearLayout.LayoutParams bOG;
    private LinearLayout.LayoutParams bOH;
    public ViewPager.OnPageChangeListener bOJ;
    private LinearLayout bOK;
    private ViewPager bOL;
    private int bOM;
    private float bON;
    private Paint bOO;
    private boolean bOP;
    private int bOQ;
    private int bOR;
    private int bOS;
    private int bOT;
    private int bOZ;
    private Typeface bPa;
    private int bPb;
    private int bPc;
    private int bPd;
    private final b bRe;
    private int bRf;
    private int bRg;
    private int bRh;
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
        this.bRe = new b();
        this.Us = 0;
        this.bON = 0.0f;
        this.bOP = false;
        this.bOQ = al.getColor(d.C0277d.cp_cont_b);
        this.bOR = al.getColor(d.C0277d.cp_cont_j);
        this.bRf = al.getColor(d.C0277d.cp_bg_line_c);
        this.bOS = 52;
        this.bOT = 4;
        this.bRg = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.bRh = 1;
        this.bOZ = 12;
        this.bPa = null;
        this.bPb = 0;
        this.bPc = 0;
        this.bPd = d.f.pager_sliding_view;
    }

    public void d(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bOK = new LinearLayout(getContext());
        this.bOK.setOrientation(0);
        this.bOK.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bOK);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.bOS = (int) TypedValue.applyDimension(1, this.bOS, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.bRh = (int) TypedValue.applyDimension(1, this.bRh, displayMetrics);
        this.bOZ = i;
        this.bOT = i3;
        this.bRg = i2;
        this.bOP = z;
        this.bOO = new Paint();
        this.bOO.setAntiAlias(true);
        this.bOO.setStyle(Paint.Style.FILL);
        this.bOG = new LinearLayout.LayoutParams(-2, -1);
        this.bOH = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.bOL = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.bRe);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bOJ = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bOL != null && this.bOL.getAdapter() != null && this.bOL.getAdapter().getCount() != 0) {
            this.bOK.removeAllViews();
            this.bOM = this.bOL.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bOM) {
                    if (this.bOL.getAdapter() instanceof a) {
                        X(i2, ((a) this.bOL.getAdapter()).hH(i2));
                    } else {
                        A(i2, this.bOL.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.Us = PagerSlidingTabStrip.this.bOL.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.Us, 0);
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
                PagerSlidingTabStrip.this.bOL.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.bOK.addView(view, i, this.bOP ? this.bOH : this.bOG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.bOM; i++) {
            View childAt = this.bOK.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bPd);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.bOZ);
                    textView.setTypeface(this.bPa, this.bPb);
                    if (i == this.bOL.getCurrentItem()) {
                        textView.setTextColor(this.bOQ);
                    } else {
                        textView.setTextColor(this.bOR);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bOM != 0) {
            int left = this.bOK.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.bOS;
            }
            if (left != this.bPc) {
                this.bPc = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.bOM != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
            this.bOO.setColor(this.bOQ);
            View childAt = this.bOK.getChildAt(this.Us);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.bOT, dimensionPixelSize + width, height), 10.0f, 10.0f, this.bOO);
        }
    }

    public void onChangeSkinType() {
        this.bOQ = al.getColor(d.C0277d.cp_cont_b);
        this.bOR = al.getColor(d.C0277d.cp_cont_j);
        this.bRf = al.getColor(d.C0277d.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.bOK.getChildCount() != 0) {
                PagerSlidingTabStrip.this.Us = i;
                PagerSlidingTabStrip.this.bON = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.bOK.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.bOJ != null) {
                    PagerSlidingTabStrip.this.bOJ.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.bOK.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.bOL.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.bOJ != null) {
                    PagerSlidingTabStrip.this.bOJ.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.bOJ != null) {
                PagerSlidingTabStrip.this.bOJ.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Us = savedState.Us;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Us = this.Us;
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
        int Us;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Us = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Us);
        }
    }
}
