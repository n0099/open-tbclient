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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private int abA;
    private int dividerPadding;
    private int dividerWidth;
    private LinearLayout.LayoutParams fcQ;
    private LinearLayout.LayoutParams fcR;
    public ViewPager.OnPageChangeListener fcT;
    private LinearLayout fcU;
    private ViewPager fcV;
    private int fcW;
    private float fcX;
    private Paint fcY;
    private boolean fcZ;
    private int fda;
    private int fdb;
    private int fdc;
    private int fdd;
    private int fdj;
    private Typeface fdk;
    private int fdl;
    private int fdm;
    private final b ffU;
    private int ffV;
    private int ffW;
    private Locale locale;
    private int tabBackgroundResId;
    private int tabPadding;

    /* loaded from: classes.dex */
    public interface a {
        int pi(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ffU = new b();
        this.abA = 0;
        this.fcX = 0.0f;
        this.fcZ = false;
        this.fda = ao.getColor(R.color.CAM_X0105);
        this.fdb = ao.getColor(R.color.CAM_X0107);
        this.ffV = ao.getColor(R.color.CAM_X0204);
        this.fdc = 52;
        this.fdd = 4;
        this.ffW = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dividerWidth = 1;
        this.fdj = 12;
        this.fdk = null;
        this.fdl = 0;
        this.fdm = 0;
        this.tabBackgroundResId = R.drawable.pager_sliding_view;
    }

    public void c(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.fcU = new LinearLayout(getContext());
        this.fcU.setOrientation(0);
        this.fcU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.fcU);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fdc = (int) TypedValue.applyDimension(1, this.fdc, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fdj = i;
        this.fdd = i3;
        this.ffW = i2;
        this.fcZ = z;
        this.fcY = new Paint();
        this.fcY.setAntiAlias(true);
        this.fcY.setStyle(Paint.Style.FILL);
        this.fcQ = new LinearLayout.LayoutParams(-2, -1);
        this.fcR = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.fcV = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.ffU);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fcT = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.fcV != null && this.fcV.getAdapter() != null && this.fcV.getAdapter().getCount() != 0) {
            this.fcU.removeAllViews();
            this.fcW = this.fcV.getAdapter().getCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fcW) {
                    if (this.fcV.getAdapter() instanceof a) {
                        aS(i2, ((a) this.fcV.getAdapter()).pi(i2));
                    } else {
                        aG(i2, this.fcV.getAdapter().getPageTitle(i2).toString());
                    }
                    i = i2 + 1;
                } else {
                    updateTabStyles();
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            PagerSlidingTabStrip.this.abA = PagerSlidingTabStrip.this.fcV.getCurrentItem();
                            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.abA, 0);
                        }
                    });
                    return;
                }
            }
        }
    }

    private void aG(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        d(i, textView);
    }

    private void aS(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        d(i, imageButton);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PagerSlidingTabStrip.this.fcV.setCurrentItem(i);
                PagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.fcU.addView(view, i, this.fcZ ? this.fcR : this.fcQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.fcW; i++) {
            View childAt = this.fcU.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.tabBackgroundResId);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.fdj);
                    textView.setTypeface(this.fdk, this.fdl);
                    if (i == this.fcV.getCurrentItem()) {
                        textView.setTextColor(this.fda);
                    } else {
                        textView.setTextColor(this.fdb);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.fcW != 0) {
            int left = this.fcU.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fdc;
            }
            if (left != this.fdm) {
                this.fdm = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.fcW != 0) {
            int height = getHeight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            this.fcY.setColor(this.fda);
            View childAt = this.fcU.getChildAt(this.abA);
            float width = ((childAt.getWidth() - dimensionPixelSize) / 2) + childAt.getLeft();
            canvas.drawRoundRect(new RectF(width, height - this.fdd, dimensionPixelSize + width, height), 10.0f, 10.0f, this.fcY);
        }
    }

    public void onChangeSkinType() {
        this.fda = ao.getColor(R.color.CAM_X0105);
        this.fdb = ao.getColor(R.color.CAM_X0107);
        this.ffV = ao.getColor(R.color.CAM_X0204);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.fcU.getChildCount() != 0) {
                PagerSlidingTabStrip.this.abA = i;
                PagerSlidingTabStrip.this.fcX = f;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.fcU.getChildAt(i).getWidth() * f));
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.fcT != null) {
                    PagerSlidingTabStrip.this.fcT.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.fcU.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.fcV.getCurrentItem(), 0);
                }
                if (PagerSlidingTabStrip.this.fcT != null) {
                    PagerSlidingTabStrip.this.fcT.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.fcT != null) {
                PagerSlidingTabStrip.this.fcT.onPageSelected(i);
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.abA = savedState.abA;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.abA = this.abA;
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
            /* renamed from: pw */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int abA;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.abA = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.abA);
        }
    }
}
