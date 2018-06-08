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
    private boolean atA;
    private int atB;
    private int atC;
    private int atD;
    private int atE;
    private int atK;
    private Typeface atL;
    private int atM;
    private int atN;
    private int atO;
    private LinearLayout.LayoutParams atr;
    private LinearLayout.LayoutParams ats;
    public ViewPager.OnPageChangeListener atu;
    private LinearLayout atv;
    private ViewPager atw;
    private int atx;
    private float aty;
    private Paint atz;
    private final b avM;
    private int avN;
    private int avO;
    private int avP;
    private int currentPosition;
    private int dividerPadding;
    private Locale locale;
    private int tabPadding;

    /* loaded from: classes.dex */
    public interface a {
        int dd(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.avM = new b();
        this.currentPosition = 0;
        this.aty = 0.0f;
        this.atA = false;
        this.atB = al.getColor(d.C0141d.cp_cont_b);
        this.atC = al.getColor(d.C0141d.cp_cont_j);
        this.avN = al.getColor(d.C0141d.cp_bg_line_c);
        this.atD = 52;
        this.atE = 4;
        this.avO = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.avP = 1;
        this.atK = 12;
        this.atL = null;
        this.atM = 0;
        this.atN = 0;
        this.atO = d.f.pager_sliding_view;
    }

    public void init(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.atv = new LinearLayout(getContext());
        this.atv.setOrientation(0);
        this.atv.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.atv);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.atD = (int) TypedValue.applyDimension(1, this.atD, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.avP = (int) TypedValue.applyDimension(1, this.avP, displayMetrics);
        this.atK = i;
        this.atE = i3;
        this.avO = i2;
        this.atA = z;
        this.atz = new Paint();
        this.atz.setAntiAlias(true);
        this.atz.setStyle(Paint.Style.FILL);
        this.atr = new LinearLayout.LayoutParams(-2, -1);
        this.ats = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.atw = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.avM);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.atu = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.atw != null && this.atw.getAdapter() != null && this.atw.getAdapter().getCount() != 0) {
            this.atv.removeAllViews();
            this.atx = this.atw.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.atx) {
                    if (this.atw.getAdapter() instanceof a) {
                        x(i2, ((a) this.atw.getAdapter()).dd(i2));
                    } else {
                        h(i2, this.atw.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.atw.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.currentPosition, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void h(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        b(i, textView);
    }

    private void x(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        b(i, imageButton);
    }

    private void b(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.atw.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.atv.addView(view, i, this.atA ? this.ats : this.atr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.atx; i++) {
            View childAt = this.atv.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.atO);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.atK);
                    textView.setTypeface(this.atL, this.atM);
                    if (i == this.atw.getCurrentItem()) {
                        textView.setTextColor(this.atB);
                    } else {
                        textView.setTextColor(this.atC);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.atx != 0) {
            int left = this.atv.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.atD;
            }
            if (left != this.atN) {
                this.atN = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.atx != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
            this.atz.setColor(this.atB);
            View childAt = this.atv.getChildAt(this.currentPosition);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.atE, dimensionPixelSize + width, height), 10.0f, 10.0f, this.atz);
        }
    }

    public void onChangeSkinType() {
        this.atB = al.getColor(d.C0141d.cp_cont_b);
        this.atC = al.getColor(d.C0141d.cp_cont_j);
        this.avN = al.getColor(d.C0141d.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.atv.getChildCount() != 0) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.aty = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.atv.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.atu != null) {
                    PagerSlidingTabStrip.this.atu.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.atv.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.atw.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.atu != null) {
                    PagerSlidingTabStrip.this.atu.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.atu != null) {
                PagerSlidingTabStrip.this.atu.onPageSelected(i);
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
            /* renamed from: i */
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
