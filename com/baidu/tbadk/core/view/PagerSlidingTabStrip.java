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
    private LinearLayout.LayoutParams aFU;
    private LinearLayout.LayoutParams aFV;
    public ViewPager.OnPageChangeListener aFX;
    private LinearLayout aFY;
    private ViewPager aFZ;
    private int aGa;
    private int aGb;
    private float aGc;
    private Paint aGd;
    private boolean aGe;
    private int aGf;
    private int aGg;
    private int aGh;
    private int aGi;
    private int aGo;
    private Typeface aGp;
    private int aGq;
    private int aGr;
    private int aGs;
    private final b aIj;
    private int aIk;
    private int aIl;
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
        this.aIj = new b();
        this.aGb = 0;
        this.aGc = 0.0f;
        this.aGe = false;
        this.aGf = al.getColor(e.d.cp_cont_b);
        this.aGg = al.getColor(e.d.cp_cont_j);
        this.aIk = al.getColor(e.d.cp_bg_line_c);
        this.aGh = 52;
        this.aGi = 4;
        this.aIl = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dividerWidth = 1;
        this.aGo = 12;
        this.aGp = null;
        this.aGq = 0;
        this.aGr = 0;
        this.aGs = e.f.pager_sliding_view;
    }

    public void a(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aFY = new LinearLayout(getContext());
        this.aFY.setOrientation(0);
        this.aFY.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aFY);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aGh = (int) TypedValue.applyDimension(1, this.aGh, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.aGo = i;
        this.aGi = i3;
        this.aIl = i2;
        this.aGe = z;
        this.aGd = new Paint();
        this.aGd.setAntiAlias(true);
        this.aGd.setStyle(Paint.Style.FILL);
        this.aFU = new LinearLayout.LayoutParams(-2, -1);
        this.aFV = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.aFZ = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.aIj);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aFX = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aFZ != null && this.aFZ.getAdapter() != null && this.aFZ.getAdapter().getCount() != 0) {
            this.aFY.removeAllViews();
            this.aGa = this.aFZ.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aGa) {
                    if (this.aFZ.getAdapter() instanceof a) {
                        B(i2, ((a) this.aFZ.getAdapter()).ed(i2));
                    } else {
                        i(i2, this.aFZ.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.aGb = PagerSlidingTabStrip.this.aFZ.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aGb, 0);
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
                PagerSlidingTabStrip.this.aFZ.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aFY.addView(view, i, this.aGe ? this.aFV : this.aFU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aGa; i++) {
            View childAt = this.aFY.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aGs);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aGo);
                    textView.setTypeface(this.aGp, this.aGq);
                    if (i == this.aFZ.getCurrentItem()) {
                        textView.setTextColor(this.aGf);
                    } else {
                        textView.setTextColor(this.aGg);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aGa != 0) {
            int left = this.aFY.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aGh;
            }
            if (left != this.aGr) {
                this.aGr = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aGa != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds64);
            this.aGd.setColor(this.aGf);
            View childAt = this.aFY.getChildAt(this.aGb);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.aGi, dimensionPixelSize + width, height), 10.0f, 10.0f, this.aGd);
        }
    }

    public void onChangeSkinType() {
        this.aGf = al.getColor(e.d.cp_cont_b);
        this.aGg = al.getColor(e.d.cp_cont_j);
        this.aIk = al.getColor(e.d.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aFY.getChildCount() != 0) {
                PagerSlidingTabStrip.this.aGb = i;
                PagerSlidingTabStrip.this.aGc = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aFY.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.aFX != null) {
                    PagerSlidingTabStrip.this.aFX.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aFY.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aFZ.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.aFX != null) {
                    PagerSlidingTabStrip.this.aFX.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aFX != null) {
                PagerSlidingTabStrip.this.aFX.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aGb = savedState.aGb;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aGb = this.aGb;
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
        int aGb;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aGb = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aGb);
        }
    }
}
