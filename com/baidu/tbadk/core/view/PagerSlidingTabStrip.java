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
    private LinearLayout.LayoutParams aFT;
    private LinearLayout.LayoutParams aFU;
    public ViewPager.OnPageChangeListener aFW;
    private LinearLayout aFX;
    private ViewPager aFY;
    private int aFZ;
    private int aGa;
    private float aGb;
    private Paint aGc;
    private boolean aGd;
    private int aGe;
    private int aGf;
    private int aGg;
    private int aGh;
    private int aGn;
    private Typeface aGo;
    private int aGp;
    private int aGq;
    private int aGr;
    private final b aIi;
    private int aIj;
    private int aIk;
    private int dividerPadding;
    private int dividerWidth;
    private Locale locale;
    private int tabPadding;

    /* loaded from: classes.dex */
    public interface a {
        int ed(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aIi = new b();
        this.aGa = 0;
        this.aGb = 0.0f;
        this.aGd = false;
        this.aGe = al.getColor(e.d.cp_cont_b);
        this.aGf = al.getColor(e.d.cp_cont_j);
        this.aIj = al.getColor(e.d.cp_bg_line_c);
        this.aGg = 52;
        this.aGh = 4;
        this.aIk = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dividerWidth = 1;
        this.aGn = 12;
        this.aGo = null;
        this.aGp = 0;
        this.aGq = 0;
        this.aGr = e.f.pager_sliding_view;
    }

    public void a(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aFX = new LinearLayout(getContext());
        this.aFX.setOrientation(0);
        this.aFX.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aFX);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aGg = (int) TypedValue.applyDimension(1, this.aGg, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.aGn = i;
        this.aGh = i3;
        this.aIk = i2;
        this.aGd = z;
        this.aGc = new Paint();
        this.aGc.setAntiAlias(true);
        this.aGc.setStyle(Paint.Style.FILL);
        this.aFT = new LinearLayout.LayoutParams(-2, -1);
        this.aFU = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.aFY = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.aIi);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aFW = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aFY != null && this.aFY.getAdapter() != null && this.aFY.getAdapter().getCount() != 0) {
            this.aFX.removeAllViews();
            this.aFZ = this.aFY.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aFZ) {
                    if (this.aFY.getAdapter() instanceof a) {
                        B(i2, ((a) this.aFY.getAdapter()).ed(i2));
                    } else {
                        i(i2, this.aFY.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.aGa = PagerSlidingTabStrip.this.aFY.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aGa, 0);
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
        b(i, textView);
    }

    private void B(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        b(i, imageButton);
    }

    private void b(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.aFY.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aFX.addView(view, i, this.aGd ? this.aFU : this.aFT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aFZ; i++) {
            View childAt = this.aFX.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aGr);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aGn);
                    textView.setTypeface(this.aGo, this.aGp);
                    if (i == this.aFY.getCurrentItem()) {
                        textView.setTextColor(this.aGe);
                    } else {
                        textView.setTextColor(this.aGf);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aFZ != 0) {
            int left = this.aFX.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aGg;
            }
            if (left != this.aGq) {
                this.aGq = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aFZ != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds64);
            this.aGc.setColor(this.aGe);
            View childAt = this.aFX.getChildAt(this.aGa);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.aGh, dimensionPixelSize + width, height), 10.0f, 10.0f, this.aGc);
        }
    }

    public void onChangeSkinType() {
        this.aGe = al.getColor(e.d.cp_cont_b);
        this.aGf = al.getColor(e.d.cp_cont_j);
        this.aIj = al.getColor(e.d.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aFX.getChildCount() != 0) {
                PagerSlidingTabStrip.this.aGa = i;
                PagerSlidingTabStrip.this.aGb = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aFX.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.aFW != null) {
                    PagerSlidingTabStrip.this.aFW.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aFX.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aFY.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.aFW != null) {
                    PagerSlidingTabStrip.this.aFW.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aFW != null) {
                PagerSlidingTabStrip.this.aFW.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aGa = savedState.aGa;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aGa = this.aGa;
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
            /* renamed from: es */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int aGa;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aGa = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aGa);
        }
    }
}
