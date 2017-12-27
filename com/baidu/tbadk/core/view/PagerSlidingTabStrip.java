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
    private LinearLayout.LayoutParams aXZ;
    private LinearLayout.LayoutParams aYa;
    public ViewPager.OnPageChangeListener aYc;
    private LinearLayout aYd;
    private ViewPager aYe;
    private int aYf;
    private float aYg;
    private Paint aYh;
    private boolean aYi;
    private int aYj;
    private int aYk;
    private int aYl;
    private int aYm;
    private int aYs;
    private Typeface aYt;
    private int aYu;
    private int aYv;
    private int aYw;
    private final b baw;
    private int bax;
    private int bay;
    private int baz;
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
        this.baw = new b();
        this.currentPosition = 0;
        this.aYg = 0.0f;
        this.aYi = false;
        this.aYj = aj.getColor(d.C0108d.cp_cont_b);
        this.aYk = aj.getColor(d.C0108d.cp_cont_j);
        this.bax = aj.getColor(d.C0108d.cp_bg_line_c);
        this.aYl = 52;
        this.aYm = 4;
        this.bay = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.baz = 1;
        this.aYs = 12;
        this.aYt = null;
        this.aYu = 0;
        this.aYv = 0;
        this.aYw = d.f.pager_sliding_view;
    }

    public void init(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aYd = new LinearLayout(getContext());
        this.aYd.setOrientation(0);
        this.aYd.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aYd);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aYl = (int) TypedValue.applyDimension(1, this.aYl, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.baz = (int) TypedValue.applyDimension(1, this.baz, displayMetrics);
        this.aYs = i;
        this.aYm = i3;
        this.bay = i2;
        this.aYi = z;
        this.aYh = new Paint();
        this.aYh.setAntiAlias(true);
        this.aYh.setStyle(Paint.Style.FILL);
        this.aXZ = new LinearLayout.LayoutParams(-2, -1);
        this.aYa = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.aYe = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.baw);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aYc = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aYe != null && this.aYe.getAdapter() != null && this.aYe.getAdapter().getCount() != 0) {
            this.aYd.removeAllViews();
            this.aYf = this.aYe.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aYf) {
                    if (this.aYe.getAdapter() instanceof a) {
                        aw(i2, ((a) this.aYe.getAdapter()).gb(i2));
                    } else {
                        h(i2, this.aYe.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.aYe.getCurrentItem();
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
                PagerSlidingTabStrip.this.aYe.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aYd.addView(view, i, this.aYi ? this.aYa : this.aXZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aYf; i++) {
            View childAt = this.aYd.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aYw);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aYs);
                    textView.setTypeface(this.aYt, this.aYu);
                    if (i == this.aYe.getCurrentItem()) {
                        textView.setTextColor(this.aYj);
                    } else {
                        textView.setTextColor(this.aYk);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aYf != 0) {
            int left = this.aYd.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aYl;
            }
            if (left != this.aYv) {
                this.aYv = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aYf != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds64);
            this.aYh.setColor(this.aYj);
            View childAt = this.aYd.getChildAt(this.currentPosition);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.aYm, dimensionPixelSize + width, height), 10.0f, 10.0f, this.aYh);
        }
    }

    public void onChangeSkinType() {
        this.aYj = aj.getColor(d.C0108d.cp_cont_b);
        this.aYk = aj.getColor(d.C0108d.cp_cont_j);
        this.bax = aj.getColor(d.C0108d.cp_bg_line_c);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aYd.getChildCount() != 0) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.aYg = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aYd.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.aYc != null) {
                    PagerSlidingTabStrip.this.aYc.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aYd.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aYe.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.aYc != null) {
                    PagerSlidingTabStrip.this.aYc.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aYc != null) {
                PagerSlidingTabStrip.this.aYc.onPageSelected(i);
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
            /* renamed from: gs */
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
