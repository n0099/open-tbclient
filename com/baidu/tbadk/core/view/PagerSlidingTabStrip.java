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
    private int auA;
    private LinearLayout.LayoutParams aud;
    private LinearLayout.LayoutParams aue;
    public ViewPager.OnPageChangeListener aug;
    private LinearLayout auh;
    private ViewPager aui;
    private int auj;
    private float auk;
    private Paint aul;
    private boolean aum;
    private int aun;
    private int auo;
    private int aup;
    private int auq;
    private int auw;
    private Typeface aux;
    private int auy;
    private int auz;
    private final b awv;
    private int aww;
    private int awx;
    private int awy;
    private int currentPosition;
    private int dividerPadding;
    private Locale locale;
    private int tabPadding;

    /* loaded from: classes.dex */
    public interface a {
        int de(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.awv = new b();
        this.currentPosition = 0;
        this.auk = 0.0f;
        this.aum = false;
        this.aun = am.getColor(d.C0142d.cp_cont_b);
        this.auo = am.getColor(d.C0142d.cp_cont_j);
        this.aww = am.getColor(d.C0142d.cp_bg_line_c);
        this.aup = 52;
        this.auq = 4;
        this.awx = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.awy = 1;
        this.auw = 12;
        this.aux = null;
        this.auy = 0;
        this.auz = 0;
        this.auA = d.f.pager_sliding_view;
    }

    public void init(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.auh = new LinearLayout(getContext());
        this.auh.setOrientation(0);
        this.auh.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.auh);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aup = (int) TypedValue.applyDimension(1, this.aup, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.awy = (int) TypedValue.applyDimension(1, this.awy, displayMetrics);
        this.auw = i;
        this.auq = i3;
        this.awx = i2;
        this.aum = z;
        this.aul = new Paint();
        this.aul.setAntiAlias(true);
        this.aul.setStyle(Paint.Style.FILL);
        this.aud = new LinearLayout.LayoutParams(-2, -1);
        this.aue = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.aui = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.awv);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aug = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aui != null && this.aui.getAdapter() != null && this.aui.getAdapter().getCount() != 0) {
            this.auh.removeAllViews();
            this.auj = this.aui.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.auj) {
                    if (this.aui.getAdapter() instanceof a) {
                        x(i2, ((a) this.aui.getAdapter()).de(i2));
                    } else {
                        h(i2, this.aui.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.aui.getCurrentItem();
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
                PagerSlidingTabStrip.this.aui.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.auh.addView(view, i, this.aum ? this.aue : this.aud);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.auj; i++) {
            View childAt = this.auh.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.auA);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.auw);
                    textView.setTypeface(this.aux, this.auy);
                    if (i == this.aui.getCurrentItem()) {
                        textView.setTextColor(this.aun);
                    } else {
                        textView.setTextColor(this.auo);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.auj != 0) {
            int left = this.auh.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aup;
            }
            if (left != this.auz) {
                this.auz = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.auj != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
            this.aul.setColor(this.aun);
            View childAt = this.auh.getChildAt(this.currentPosition);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.auq, dimensionPixelSize + width, height), 10.0f, 10.0f, this.aul);
        }
    }

    public void onChangeSkinType() {
        this.aun = am.getColor(d.C0142d.cp_cont_b);
        this.auo = am.getColor(d.C0142d.cp_cont_j);
        this.aww = am.getColor(d.C0142d.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.auh.getChildCount() != 0) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.auk = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.auh.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.aug != null) {
                    PagerSlidingTabStrip.this.aug.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.auh.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aui.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.aug != null) {
                    PagerSlidingTabStrip.this.aug.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aug != null) {
                PagerSlidingTabStrip.this.aug.onPageSelected(i);
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
            /* renamed from: du */
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
