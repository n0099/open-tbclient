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
    private LinearLayout.LayoutParams aZQ;
    private LinearLayout.LayoutParams aZR;
    public ViewPager.OnPageChangeListener aZT;
    private LinearLayout aZU;
    private ViewPager aZV;
    private int aZW;
    private float aZX;
    private Paint aZY;
    private boolean aZZ;
    private int baa;
    private int bab;
    private int bac;
    private int bad;
    private int baj;
    private Typeface bak;
    private int bal;
    private int bam;
    private int ban;
    private final b bcv;
    private int bcw;
    private int bcx;
    private int bcy;
    private int currentPosition;
    private int dividerPadding;
    private Locale locale;
    private int tabPadding;

    /* loaded from: classes.dex */
    public interface a {
        int gb(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bcv = new b();
        this.currentPosition = 0;
        this.aZX = 0.0f;
        this.aZZ = false;
        this.baa = aj.getColor(d.C0140d.cp_cont_b);
        this.bab = aj.getColor(d.C0140d.cp_cont_j);
        this.bcw = aj.getColor(d.C0140d.cp_bg_line_c);
        this.bac = 52;
        this.bad = 4;
        this.bcx = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.bcy = 1;
        this.baj = 12;
        this.bak = null;
        this.bal = 0;
        this.bam = 0;
        this.ban = d.f.pager_sliding_view;
    }

    public void init(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aZU = new LinearLayout(getContext());
        this.aZU.setOrientation(0);
        this.aZU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aZU);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.bac = (int) TypedValue.applyDimension(1, this.bac, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.bcy = (int) TypedValue.applyDimension(1, this.bcy, displayMetrics);
        this.baj = i;
        this.bad = i3;
        this.bcx = i2;
        this.aZZ = z;
        this.aZY = new Paint();
        this.aZY.setAntiAlias(true);
        this.aZY.setStyle(Paint.Style.FILL);
        this.aZQ = new LinearLayout.LayoutParams(-2, -1);
        this.aZR = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.aZV = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.bcv);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aZT = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aZV != null && this.aZV.getAdapter() != null && this.aZV.getAdapter().getCount() != 0) {
            this.aZU.removeAllViews();
            this.aZW = this.aZV.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aZW) {
                    if (this.aZV.getAdapter() instanceof a) {
                        aw(i2, ((a) this.aZV.getAdapter()).gb(i2));
                    } else {
                        h(i2, this.aZV.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.aZV.getCurrentItem();
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

    private void aw(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        b(i, imageButton);
    }

    private void b(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.aZV.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aZU.addView(view, i, this.aZZ ? this.aZR : this.aZQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aZW; i++) {
            View childAt = this.aZU.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.ban);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.baj);
                    textView.setTypeface(this.bak, this.bal);
                    if (i == this.aZV.getCurrentItem()) {
                        textView.setTextColor(this.baa);
                    } else {
                        textView.setTextColor(this.bab);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aZW != 0) {
            int left = this.aZU.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.bac;
            }
            if (left != this.bam) {
                this.bam = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aZW != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
            this.aZY.setColor(this.baa);
            View childAt = this.aZU.getChildAt(this.currentPosition);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.bad, dimensionPixelSize + width, height), 10.0f, 10.0f, this.aZY);
        }
    }

    public void onChangeSkinType() {
        this.baa = aj.getColor(d.C0140d.cp_cont_b);
        this.bab = aj.getColor(d.C0140d.cp_cont_j);
        this.bcw = aj.getColor(d.C0140d.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aZU.getChildCount() != 0) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.aZX = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aZU.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.aZT != null) {
                    PagerSlidingTabStrip.this.aZT.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aZU.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aZV.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.aZT != null) {
                    PagerSlidingTabStrip.this.aZT.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aZT != null) {
                PagerSlidingTabStrip.this.aZT.onPageSelected(i);
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
            /* renamed from: v */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: gr */
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
