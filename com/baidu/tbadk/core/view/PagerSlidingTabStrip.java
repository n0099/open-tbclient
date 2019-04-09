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
    private int Ut;
    private LinearLayout.LayoutParams bOJ;
    private LinearLayout.LayoutParams bOK;
    public ViewPager.OnPageChangeListener bOM;
    private LinearLayout bON;
    private ViewPager bOO;
    private int bOP;
    private float bOQ;
    private Paint bOR;
    private boolean bOS;
    private int bOT;
    private int bOU;
    private int bOV;
    private int bOW;
    private int bPc;
    private Typeface bPd;
    private int bPe;
    private int bPf;
    private int bPg;
    private final b bRh;
    private int bRi;
    private int bRj;
    private int bRk;
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
        this.bRh = new b();
        this.Ut = 0;
        this.bOQ = 0.0f;
        this.bOS = false;
        this.bOT = al.getColor(d.C0277d.cp_cont_b);
        this.bOU = al.getColor(d.C0277d.cp_cont_j);
        this.bRi = al.getColor(d.C0277d.cp_bg_line_c);
        this.bOV = 52;
        this.bOW = 4;
        this.bRj = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.bRk = 1;
        this.bPc = 12;
        this.bPd = null;
        this.bPe = 0;
        this.bPf = 0;
        this.bPg = d.f.pager_sliding_view;
    }

    public void d(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bON = new LinearLayout(getContext());
        this.bON.setOrientation(0);
        this.bON.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bON);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.bOV = (int) TypedValue.applyDimension(1, this.bOV, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.bRk = (int) TypedValue.applyDimension(1, this.bRk, displayMetrics);
        this.bPc = i;
        this.bOW = i3;
        this.bRj = i2;
        this.bOS = z;
        this.bOR = new Paint();
        this.bOR.setAntiAlias(true);
        this.bOR.setStyle(Paint.Style.FILL);
        this.bOJ = new LinearLayout.LayoutParams(-2, -1);
        this.bOK = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.bOO = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.bRh);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bOM = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bOO != null && this.bOO.getAdapter() != null && this.bOO.getAdapter().getCount() != 0) {
            this.bON.removeAllViews();
            this.bOP = this.bOO.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bOP) {
                    if (this.bOO.getAdapter() instanceof a) {
                        X(i2, ((a) this.bOO.getAdapter()).hG(i2));
                    } else {
                        A(i2, this.bOO.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.Ut = PagerSlidingTabStrip.this.bOO.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.Ut, 0);
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
                PagerSlidingTabStrip.this.bOO.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.bON.addView(view, i, this.bOS ? this.bOK : this.bOJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.bOP; i++) {
            View childAt = this.bON.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bPg);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.bPc);
                    textView.setTypeface(this.bPd, this.bPe);
                    if (i == this.bOO.getCurrentItem()) {
                        textView.setTextColor(this.bOT);
                    } else {
                        textView.setTextColor(this.bOU);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bOP != 0) {
            int left = this.bON.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.bOV;
            }
            if (left != this.bPf) {
                this.bPf = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.bOP != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
            this.bOR.setColor(this.bOT);
            View childAt = this.bON.getChildAt(this.Ut);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.bOW, dimensionPixelSize + width, height), 10.0f, 10.0f, this.bOR);
        }
    }

    public void onChangeSkinType() {
        this.bOT = al.getColor(d.C0277d.cp_cont_b);
        this.bOU = al.getColor(d.C0277d.cp_cont_j);
        this.bRi = al.getColor(d.C0277d.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.bON.getChildCount() != 0) {
                PagerSlidingTabStrip.this.Ut = i;
                PagerSlidingTabStrip.this.bOQ = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.bON.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.bOM != null) {
                    PagerSlidingTabStrip.this.bOM.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.bON.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.bOO.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.bOM != null) {
                    PagerSlidingTabStrip.this.bOM.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.bOM != null) {
                PagerSlidingTabStrip.this.bOM.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Ut = savedState.Ut;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Ut = this.Ut;
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
        int Ut;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Ut = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ut);
        }
    }
}
