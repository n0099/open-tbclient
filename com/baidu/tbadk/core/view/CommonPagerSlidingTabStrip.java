package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private int auA;
    private LinearLayout.LayoutParams aud;
    private LinearLayout.LayoutParams aue;
    private final b auf;
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
    private int aur;
    private int aus;
    private int aut;
    private int auu;
    private int auv;
    private int auw;
    private Typeface aux;
    private int auy;
    private int auz;
    private int currentPosition;

    /* loaded from: classes.dex */
    public interface a {
        int de(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auf = new b();
        this.currentPosition = 0;
        this.auk = 0.0f;
        this.aum = false;
        this.aun = am.getColor(d.C0142d.cp_cont_b);
        this.auo = am.getColor(d.C0142d.cp_cont_j);
        this.aup = 52;
        this.auq = 4;
        this.aur = 24;
        this.aus = 24;
        this.aut = 24;
        this.auu = 24;
        this.auv = 40;
        this.auw = 12;
        this.aux = null;
        this.auy = 0;
        this.auz = 0;
        this.auA = d.f.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.auh = new LinearLayout(getContext());
        this.auh.setOrientation(0);
        this.auh.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.auh);
        this.aul = new Paint();
        this.aul.setAntiAlias(true);
        this.aul.setStyle(Paint.Style.FILL);
        this.aud = new LinearLayout.LayoutParams(-2, -1);
        this.aue = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.auw = i;
        this.aur = i2;
        this.aus = i3;
        this.aut = i4;
        this.auu = i5;
        this.auq = i6;
        this.auv = i7;
        this.auo = i8;
        this.aun = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aui = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.auf);
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
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.currentPosition = CommonPagerSlidingTabStrip.this.aui.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.currentPosition, 0);
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
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.aui.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.aur, this.aus, this.aut, this.auu);
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
        if (!isInEditMode() && this.auj != 0 && this.auh.getChildCount() > 1) {
            int height = getHeight();
            this.aul.setColor(this.aun);
            View childAt = this.auh.getChildAt(this.currentPosition);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.auk > 0.0f && this.currentPosition < this.auj - 1) {
                View childAt2 = this.auh.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.auk)) + (childAt2.getLeft() * this.auk);
                right = (right * (1.0f - this.auk)) + (childAt2.getRight() * this.auk);
            }
            if (right - left < this.auv) {
                canvas.drawRect(left, height - this.auq, right, height, this.aul);
            } else {
                canvas.drawRect(left + (((right - left) - this.auv) / 2.0f), height - this.auq, right - (((right - left) - this.auv) / 2.0f), height, this.aul);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aun = am.getColor(i, this.aun);
        this.auo = am.getColor(i, this.auo);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.auh.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.currentPosition = i;
                CommonPagerSlidingTabStrip.this.auk = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.auh.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.aug != null) {
                    CommonPagerSlidingTabStrip.this.aug.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.auh.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.aui.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.aug != null) {
                    CommonPagerSlidingTabStrip.this.aug.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.aug != null) {
                CommonPagerSlidingTabStrip.this.aug.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
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
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: h */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: df */
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
