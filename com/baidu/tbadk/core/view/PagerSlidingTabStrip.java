package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
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
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private int abv;
    private int dividerPadding;
    private int dividerWidth;
    private int ffA;
    private int ffB;
    private LinearLayout.LayoutParams fff;
    private LinearLayout.LayoutParams ffg;
    public ViewPager.OnPageChangeListener ffi;
    private LinearLayout ffj;
    private ViewPager ffk;
    private int ffl;
    private float ffm;
    private Paint ffn;
    private boolean ffo;
    private int ffp;
    private int ffq;
    private int ffr;
    private int ffs;
    private int ffy;
    private Typeface ffz;
    private final b fil;
    private int fim;
    private int fin;
    private Locale locale;
    private int tabBackgroundResId;
    private int tabPadding;

    /* loaded from: classes.dex */
    public interface a {
        int po(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fil = new b();
        this.abv = 0;
        this.ffm = 0.0f;
        this.ffo = false;
        this.ffp = ap.getColor(R.color.CAM_X0105);
        this.ffq = ap.getColor(R.color.CAM_X0107);
        this.fim = ap.getColor(R.color.CAM_X0204);
        this.ffr = 52;
        this.ffs = 4;
        this.fin = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dividerWidth = 1;
        this.ffy = 12;
        this.ffz = null;
        this.ffA = 0;
        this.ffB = 0;
        this.tabBackgroundResId = R.drawable.pager_sliding_view;
    }

    public void c(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.ffj = new LinearLayout(getContext());
        this.ffj.setOrientation(0);
        this.ffj.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.ffj);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.ffr = (int) TypedValue.applyDimension(1, this.ffr, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.ffy = i;
        this.ffs = i3;
        this.fin = i2;
        this.ffo = z;
        this.ffn = new Paint();
        this.ffn.setAntiAlias(true);
        this.ffn.setStyle(Paint.Style.FILL);
        this.fff = new LinearLayout.LayoutParams(-2, -1);
        this.ffg = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.ffk = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fil);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ffi = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.ffk != null && this.ffk.getAdapter() != null && this.ffk.getAdapter().getCount() != 0) {
            this.ffj.removeAllViews();
            this.ffl = this.ffk.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ffl) {
                    if (this.ffk.getAdapter() instanceof a) {
                        aP(i2, ((a) this.ffk.getAdapter()).po(i2));
                    } else {
                        aK(i2, this.ffk.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.abv = PagerSlidingTabStrip.this.ffk.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.abv, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void aK(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        d(i, textView);
    }

    private void aP(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.ffk.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.ffj.addView(view, i, this.ffo ? this.ffg : this.fff);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.ffl; i++) {
            View childAt = this.ffj.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.tabBackgroundResId);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.ffy);
                    textView.setTypeface(this.ffz, this.ffA);
                    if (i == this.ffk.getCurrentItem()) {
                        textView.setTextColor(this.ffp);
                    } else {
                        textView.setTextColor(this.ffq);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.ffl != 0) {
            int left = this.ffj.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.ffr;
            }
            if (left != this.ffB) {
                this.ffB = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.ffl != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            this.ffn.setColor(this.ffp);
            View childAt = this.ffj.getChildAt(this.abv);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.ffs, dimensionPixelSize + width, height), 10.0f, 10.0f, this.ffn);
        }
    }

    public void onChangeSkinType() {
        this.ffp = ap.getColor(R.color.CAM_X0105);
        this.ffq = ap.getColor(R.color.CAM_X0107);
        this.fim = ap.getColor(R.color.CAM_X0204);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.ffj.getChildCount() != 0) {
                PagerSlidingTabStrip.this.abv = i;
                PagerSlidingTabStrip.this.ffm = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.ffj.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.ffi != null) {
                    PagerSlidingTabStrip.this.ffi.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.ffj.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.ffk.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.ffi != null) {
                    PagerSlidingTabStrip.this.ffi.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.ffi != null) {
                PagerSlidingTabStrip.this.ffi.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.abv = savedState.abv;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.abv = this.abv;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Q */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: pB */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int abv;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.abv = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.abv);
        }
    }
}
