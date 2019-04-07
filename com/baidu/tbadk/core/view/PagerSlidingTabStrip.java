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
    private LinearLayout.LayoutParams bOI;
    private LinearLayout.LayoutParams bOJ;
    public ViewPager.OnPageChangeListener bOL;
    private LinearLayout bOM;
    private ViewPager bON;
    private int bOO;
    private float bOP;
    private Paint bOQ;
    private boolean bOR;
    private int bOS;
    private int bOT;
    private int bOU;
    private int bOV;
    private int bPb;
    private Typeface bPc;
    private int bPd;
    private int bPe;
    private int bPf;
    private final b bRg;
    private int bRh;
    private int bRi;
    private int bRj;
    private int dividerPadding;
    private Locale locale;
    private int tabPadding;

    /* loaded from: classes.dex */
    public interface a {
        int hG(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bRg = new b();
        this.Us = 0;
        this.bOP = 0.0f;
        this.bOR = false;
        this.bOS = al.getColor(d.C0277d.cp_cont_b);
        this.bOT = al.getColor(d.C0277d.cp_cont_j);
        this.bRh = al.getColor(d.C0277d.cp_bg_line_c);
        this.bOU = 52;
        this.bOV = 4;
        this.bRi = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.bRj = 1;
        this.bPb = 12;
        this.bPc = null;
        this.bPd = 0;
        this.bPe = 0;
        this.bPf = d.f.pager_sliding_view;
    }

    public void d(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bOM = new LinearLayout(getContext());
        this.bOM.setOrientation(0);
        this.bOM.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bOM);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.bOU = (int) TypedValue.applyDimension(1, this.bOU, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.bRj = (int) TypedValue.applyDimension(1, this.bRj, displayMetrics);
        this.bPb = i;
        this.bOV = i3;
        this.bRi = i2;
        this.bOR = z;
        this.bOQ = new Paint();
        this.bOQ.setAntiAlias(true);
        this.bOQ.setStyle(Paint.Style.FILL);
        this.bOI = new LinearLayout.LayoutParams(-2, -1);
        this.bOJ = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.bON = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.bRg);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bOL = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bON != null && this.bON.getAdapter() != null && this.bON.getAdapter().getCount() != 0) {
            this.bOM.removeAllViews();
            this.bOO = this.bON.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bOO) {
                    if (this.bON.getAdapter() instanceof a) {
                        X(i2, ((a) this.bON.getAdapter()).hG(i2));
                    } else {
                        A(i2, this.bON.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.Us = PagerSlidingTabStrip.this.bON.getCurrentItem();
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
                PagerSlidingTabStrip.this.bON.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.bOM.addView(view, i, this.bOR ? this.bOJ : this.bOI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.bOO; i++) {
            View childAt = this.bOM.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bPf);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.bPb);
                    textView.setTypeface(this.bPc, this.bPd);
                    if (i == this.bON.getCurrentItem()) {
                        textView.setTextColor(this.bOS);
                    } else {
                        textView.setTextColor(this.bOT);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bOO != 0) {
            int left = this.bOM.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.bOU;
            }
            if (left != this.bPe) {
                this.bPe = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.bOO != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
            this.bOQ.setColor(this.bOS);
            View childAt = this.bOM.getChildAt(this.Us);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.bOV, dimensionPixelSize + width, height), 10.0f, 10.0f, this.bOQ);
        }
    }

    public void onChangeSkinType() {
        this.bOS = al.getColor(d.C0277d.cp_cont_b);
        this.bOT = al.getColor(d.C0277d.cp_cont_j);
        this.bRh = al.getColor(d.C0277d.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.bOM.getChildCount() != 0) {
                PagerSlidingTabStrip.this.Us = i;
                PagerSlidingTabStrip.this.bOP = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.bOM.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.bOL != null) {
                    PagerSlidingTabStrip.this.bOL.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.bOM.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.bON.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.bOL != null) {
                    PagerSlidingTabStrip.this.bOL.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.bOL != null) {
                PagerSlidingTabStrip.this.bOL.onPageSelected(i);
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
            /* renamed from: hV */
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
