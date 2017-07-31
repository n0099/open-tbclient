package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams ana;
    private LinearLayout.LayoutParams anb;
    private final b anc;
    public ViewPager.OnPageChangeListener and;
    private LinearLayout ane;
    private ViewPager anf;
    private int ang;
    private float anh;
    private Paint ani;
    private boolean anj;
    private int ank;
    private int anl;
    private int anm;
    private int ann;
    private int ano;
    private int anp;
    private int anq;
    private int anr;
    private int ans;
    private Typeface ant;
    private int anu;
    private int anv;
    private int anw;
    private int currentPosition;
    private int dividerPadding;
    private Locale locale;

    /* loaded from: classes.dex */
    public interface a {
        int dl(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anc = new b();
        this.currentPosition = 0;
        this.anh = 0.0f;
        this.anj = false;
        this.ank = ai.getColor(d.e.cp_link_tip_a);
        this.anl = ai.getColor(d.e.cp_cont_f);
        this.anm = ai.getColor(d.e.cp_bg_line_c);
        this.ann = 52;
        this.ano = 4;
        this.anp = 2;
        this.dividerPadding = 12;
        this.anq = 24;
        this.anr = 1;
        this.ans = 12;
        this.ant = null;
        this.anu = 0;
        this.anv = 0;
        this.anw = d.g.pager_sliding_view;
    }

    public void init(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.ane = new LinearLayout(getContext());
        this.ane.setOrientation(0);
        this.ane.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.ane);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.ann = (int) TypedValue.applyDimension(1, this.ann, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.anq = (int) TypedValue.applyDimension(1, this.anq, displayMetrics);
        this.anr = (int) TypedValue.applyDimension(1, this.anr, displayMetrics);
        this.ans = i;
        this.ano = i3;
        this.anp = i2;
        this.anj = z;
        this.ani = new Paint();
        this.ani.setAntiAlias(true);
        this.ani.setStyle(Paint.Style.FILL);
        this.ana = new LinearLayout.LayoutParams(-2, -1);
        this.anb = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.anf = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.anc);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.and = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.anf != null && this.anf.getAdapter() != null && this.anf.getAdapter().getCount() != 0) {
            this.ane.removeAllViews();
            this.ang = this.anf.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ang) {
                    if (this.anf.getAdapter() instanceof a) {
                        D(i2, ((a) this.anf.getAdapter()).dl(i2));
                    } else {
                        i(i2, this.anf.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    wR();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.anf.getCurrentItem();
                            PagerSlidingTabStrip.this.E(PagerSlidingTabStrip.this.currentPosition, 0);
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
        a(i, textView);
    }

    private void D(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        a(i, imageButton);
    }

    private void a(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.anf.setCurrentItem(i);
                PagerSlidingTabStrip.this.wR();
            }
        });
        view.setPadding(this.anq, 0, this.anq, 0);
        this.ane.addView(view, i, this.anj ? this.anb : this.ana);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wR() {
        for (int i = 0; i < this.ang; i++) {
            View childAt = this.ane.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.anw);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.ans);
                    textView.setTypeface(this.ant, this.anu);
                    if (i == this.anf.getCurrentItem()) {
                        textView.setTextColor(this.ank);
                    } else {
                        textView.setTextColor(this.anl);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i, int i2) {
        if (this.ang != 0) {
            int left = this.ane.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.ann;
            }
            if (left != this.anv) {
                this.anv = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.ang != 0) {
            int height = getHeight();
            this.ani.setColor(this.ank);
            View childAt = this.ane.getChildAt(this.currentPosition);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.anh > 0.0f && this.currentPosition < this.ang - 1) {
                View childAt2 = this.ane.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.anh)) + (childAt2.getLeft() * this.anh);
                right = (childAt2.getRight() * this.anh) + ((1.0f - this.anh) * right);
            }
            canvas.drawRect(left, height - this.ano, right, height, this.ani);
            this.ani.setColor(this.anm);
            canvas.drawRect(0.0f, height - this.anp, this.ane.getWidth(), height, this.ani);
        }
    }

    public void onChangeSkinType() {
        this.ank = ai.getColor(d.e.cp_link_tip_a);
        this.anl = ai.getColor(d.e.cp_cont_f);
        this.anm = ai.getColor(d.e.cp_bg_line_c);
        wR();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.ane.getChildCount() != 0) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.anh = f;
                PagerSlidingTabStrip.this.E(i, (int) (PagerSlidingTabStrip.this.ane.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.and != null) {
                    PagerSlidingTabStrip.this.and.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.ane.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.E(PagerSlidingTabStrip.this.anf.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.and != null) {
                    PagerSlidingTabStrip.this.and.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.and != null) {
                PagerSlidingTabStrip.this.and.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.wR();
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
            /* renamed from: g */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: dm */
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
