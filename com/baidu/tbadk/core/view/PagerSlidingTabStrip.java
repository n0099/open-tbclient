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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams atH;
    private LinearLayout.LayoutParams atI;
    public ViewPager.OnPageChangeListener atK;
    private LinearLayout atL;
    private ViewPager atM;
    private int atN;
    private int atO;
    private float atP;
    private Paint atQ;
    private boolean atR;
    private int atS;
    private int atT;
    private int atU;
    private int atV;
    private int aub;
    private Typeface auc;
    private int aud;
    private int aue;
    private int auf;
    private final b awb;
    private int awc;
    private int awd;
    private int awe;
    private int dividerPadding;
    private Locale locale;
    private int tabPadding;

    /* loaded from: classes.dex */
    public interface a {
        int dg(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.awb = new b();
        this.atO = 0;
        this.atP = 0.0f;
        this.atR = false;
        this.atS = am.getColor(d.C0140d.cp_cont_b);
        this.atT = am.getColor(d.C0140d.cp_cont_j);
        this.awc = am.getColor(d.C0140d.cp_bg_line_c);
        this.atU = 52;
        this.atV = 4;
        this.awd = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.awe = 1;
        this.aub = 12;
        this.auc = null;
        this.aud = 0;
        this.aue = 0;
        this.auf = d.f.pager_sliding_view;
    }

    public void a(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.atL = new LinearLayout(getContext());
        this.atL.setOrientation(0);
        this.atL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.atL);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.atU = (int) TypedValue.applyDimension(1, this.atU, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.awe = (int) TypedValue.applyDimension(1, this.awe, displayMetrics);
        this.aub = i;
        this.atV = i3;
        this.awd = i2;
        this.atR = z;
        this.atQ = new Paint();
        this.atQ.setAntiAlias(true);
        this.atQ.setStyle(Paint.Style.FILL);
        this.atH = new LinearLayout.LayoutParams(-2, -1);
        this.atI = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.atM = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.awb);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.atK = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.atM != null && this.atM.getAdapter() != null && this.atM.getAdapter().getCount() != 0) {
            this.atL.removeAllViews();
            this.atN = this.atM.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.atN) {
                    if (this.atM.getAdapter() instanceof a) {
                        y(i2, ((a) this.atM.getAdapter()).dg(i2));
                    } else {
                        j(i2, this.atM.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.atO = PagerSlidingTabStrip.this.atM.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.atO, 0);
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
        a(i, textView);
    }

    private void y(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        a(i, imageButton);
    }

    private void a(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.atM.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.atL.addView(view, i, this.atR ? this.atI : this.atH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.atN; i++) {
            View childAt = this.atL.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.auf);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aub);
                    textView.setTypeface(this.auc, this.aud);
                    if (i == this.atM.getCurrentItem()) {
                        textView.setTextColor(this.atS);
                    } else {
                        textView.setTextColor(this.atT);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.atN != 0) {
            int left = this.atL.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.atU;
            }
            if (left != this.aue) {
                this.aue = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.atN != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
            this.atQ.setColor(this.atS);
            View childAt = this.atL.getChildAt(this.atO);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.atV, dimensionPixelSize + width, height), 10.0f, 10.0f, this.atQ);
        }
    }

    public void onChangeSkinType() {
        this.atS = am.getColor(d.C0140d.cp_cont_b);
        this.atT = am.getColor(d.C0140d.cp_cont_j);
        this.awc = am.getColor(d.C0140d.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.atL.getChildCount() != 0) {
                PagerSlidingTabStrip.this.atO = i;
                PagerSlidingTabStrip.this.atP = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.atL.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.atK != null) {
                    PagerSlidingTabStrip.this.atK.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.atL.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.atM.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.atK != null) {
                    PagerSlidingTabStrip.this.atK.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.atK != null) {
                PagerSlidingTabStrip.this.atK.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.atO = savedState.atO;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.atO = this.atO;
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
            /* renamed from: dw */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int atO;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.atO = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.atO);
        }
    }
}
