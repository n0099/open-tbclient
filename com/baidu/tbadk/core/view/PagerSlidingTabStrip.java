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
    private LinearLayout.LayoutParams anb;
    private LinearLayout.LayoutParams anc;
    private final b and;
    public ViewPager.OnPageChangeListener ane;
    private LinearLayout anf;
    private ViewPager ang;
    private int anh;
    private float ani;
    private Paint anj;
    private boolean ank;
    private int anl;
    private int anm;
    private int ann;
    private int ano;
    private int anp;
    private int anq;
    private int anr;
    private int ans;
    private int ant;
    private Typeface anu;
    private int anv;
    private int anw;
    private int anx;
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
        this.and = new b();
        this.currentPosition = 0;
        this.ani = 0.0f;
        this.ank = false;
        this.anl = ai.getColor(d.e.cp_link_tip_a);
        this.anm = ai.getColor(d.e.cp_cont_f);
        this.ann = ai.getColor(d.e.cp_bg_line_c);
        this.ano = 52;
        this.anp = 4;
        this.anq = 2;
        this.dividerPadding = 12;
        this.anr = 24;
        this.ans = 1;
        this.ant = 12;
        this.anu = null;
        this.anv = 0;
        this.anw = 0;
        this.anx = d.g.pager_sliding_view;
    }

    public void init(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.anf = new LinearLayout(getContext());
        this.anf.setOrientation(0);
        this.anf.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.anf);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.ano = (int) TypedValue.applyDimension(1, this.ano, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.anr = (int) TypedValue.applyDimension(1, this.anr, displayMetrics);
        this.ans = (int) TypedValue.applyDimension(1, this.ans, displayMetrics);
        this.ant = i;
        this.anp = i3;
        this.anq = i2;
        this.ank = z;
        this.anj = new Paint();
        this.anj.setAntiAlias(true);
        this.anj.setStyle(Paint.Style.FILL);
        this.anb = new LinearLayout.LayoutParams(-2, -1);
        this.anc = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.ang = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.and);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ane = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.ang != null && this.ang.getAdapter() != null && this.ang.getAdapter().getCount() != 0) {
            this.anf.removeAllViews();
            this.anh = this.ang.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.anh) {
                    if (this.ang.getAdapter() instanceof a) {
                        D(i2, ((a) this.ang.getAdapter()).dl(i2));
                    } else {
                        i(i2, this.ang.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    wR();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.ang.getCurrentItem();
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
                PagerSlidingTabStrip.this.ang.setCurrentItem(i);
                PagerSlidingTabStrip.this.wR();
            }
        });
        view.setPadding(this.anr, 0, this.anr, 0);
        this.anf.addView(view, i, this.ank ? this.anc : this.anb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wR() {
        for (int i = 0; i < this.anh; i++) {
            View childAt = this.anf.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.anx);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.ant);
                    textView.setTypeface(this.anu, this.anv);
                    if (i == this.ang.getCurrentItem()) {
                        textView.setTextColor(this.anl);
                    } else {
                        textView.setTextColor(this.anm);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i, int i2) {
        if (this.anh != 0) {
            int left = this.anf.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.ano;
            }
            if (left != this.anw) {
                this.anw = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.anh != 0) {
            int height = getHeight();
            this.anj.setColor(this.anl);
            View childAt = this.anf.getChildAt(this.currentPosition);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.ani > 0.0f && this.currentPosition < this.anh - 1) {
                View childAt2 = this.anf.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.ani)) + (childAt2.getLeft() * this.ani);
                right = (childAt2.getRight() * this.ani) + ((1.0f - this.ani) * right);
            }
            canvas.drawRect(left, height - this.anp, right, height, this.anj);
            this.anj.setColor(this.ann);
            canvas.drawRect(0.0f, height - this.anq, this.anf.getWidth(), height, this.anj);
        }
    }

    public void onChangeSkinType() {
        this.anl = ai.getColor(d.e.cp_link_tip_a);
        this.anm = ai.getColor(d.e.cp_cont_f);
        this.ann = ai.getColor(d.e.cp_bg_line_c);
        wR();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.anf.getChildCount() != 0) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.ani = f;
                PagerSlidingTabStrip.this.E(i, (int) (PagerSlidingTabStrip.this.anf.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.ane != null) {
                    PagerSlidingTabStrip.this.ane.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.anf.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.E(PagerSlidingTabStrip.this.ang.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.ane != null) {
                    PagerSlidingTabStrip.this.ane.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.ane != null) {
                PagerSlidingTabStrip.this.ane.onPageSelected(i);
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
