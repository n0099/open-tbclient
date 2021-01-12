package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
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
/* loaded from: classes.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    private int abA;
    private LinearLayout.LayoutParams fcQ;
    private LinearLayout.LayoutParams fcR;
    private final b fcS;
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
    private int fde;
    private int fdf;
    private int fdg;
    private int fdh;
    private int fdi;
    private int fdj;
    private Typeface fdk;
    private int fdl;
    private int fdm;
    private int tabBackgroundResId;

    /* loaded from: classes.dex */
    public interface a {
        int pi(int i);
    }

    public CommonPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fcS = new b();
        this.abA = 0;
        this.fcX = 0.0f;
        this.fcZ = false;
        this.fda = ao.getColor(R.color.CAM_X0105);
        this.fdb = ao.getColor(R.color.CAM_X0107);
        this.fdc = 52;
        this.fdd = 4;
        this.fde = 24;
        this.fdf = 24;
        this.fdg = 24;
        this.fdh = 24;
        this.fdi = 40;
        this.fdj = 12;
        this.fdk = null;
        this.fdl = 0;
        this.fdm = 0;
        this.tabBackgroundResId = R.drawable.pager_sliding_view;
        init();
    }

    private void init() {
        setFillViewport(true);
        setWillNotDraw(false);
        this.fcU = new LinearLayout(getContext());
        this.fcU.setOrientation(0);
        this.fcU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.fcU);
        this.fcY = new Paint();
        this.fcY.setAntiAlias(true);
        this.fcY.setStyle(Paint.Style.FILL);
        this.fcQ = new LinearLayout.LayoutParams(-2, -1);
        this.fcR = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.fdj = i;
        this.fde = i2;
        this.fdf = i3;
        this.fdg = i4;
        this.fdh = i5;
        this.fdd = i6;
        this.fdi = i7;
        this.fdb = i8;
        this.fda = i9;
    }

    public void setViewPager(ViewPager viewPager) {
        this.fcV = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fcS);
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
                    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            CommonPagerSlidingTabStrip.this.abA = CommonPagerSlidingTabStrip.this.fcV.getCurrentItem();
                            CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.abA, 0);
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
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonPagerSlidingTabStrip.this.fcV.setCurrentItem(i);
                CommonPagerSlidingTabStrip.this.updateTabStyles();
            }
        });
        view.setPadding(this.fde, this.fdf, this.fdg, this.fdh);
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
        if (!isInEditMode() && this.fcW != 0 && this.fcU.getChildCount() > 1) {
            int height = getHeight();
            this.fcY.setColor(this.fda);
            View childAt = this.fcU.getChildAt(this.abA);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.fcX > 0.0f && this.abA < this.fcW - 1) {
                View childAt2 = this.fcU.getChildAt(this.abA + 1);
                left = (left * (1.0f - this.fcX)) + (childAt2.getLeft() * this.fcX);
                right = (right * (1.0f - this.fcX)) + (childAt2.getRight() * this.fcX);
            }
            if (right - left < this.fdi) {
                canvas.drawRect(left, height - this.fdd, right, height, this.fcY);
            } else {
                canvas.drawRect(left + (((right - left) - this.fdi) / 2.0f), height - this.fdd, right - (((right - left) - this.fdi) / 2.0f), height, this.fcY);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.fda = ao.getColor(i, this.fda);
        this.fdb = ao.getColor(i, this.fdb);
        updateTabStyles();
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CommonPagerSlidingTabStrip.this.fcU.getChildCount() != 0) {
                CommonPagerSlidingTabStrip.this.abA = i;
                CommonPagerSlidingTabStrip.this.fcX = f;
                CommonPagerSlidingTabStrip.this.scrollToChild(i, (int) (CommonPagerSlidingTabStrip.this.fcU.getChildAt(i).getWidth() * f));
                CommonPagerSlidingTabStrip.this.invalidate();
                if (CommonPagerSlidingTabStrip.this.fcT != null) {
                    CommonPagerSlidingTabStrip.this.fcT.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CommonPagerSlidingTabStrip.this.fcU.getChildCount() != 0) {
                if (i == 0) {
                    CommonPagerSlidingTabStrip.this.scrollToChild(CommonPagerSlidingTabStrip.this.fcV.getCurrentItem(), 0);
                }
                if (CommonPagerSlidingTabStrip.this.fcT != null) {
                    CommonPagerSlidingTabStrip.this.fcT.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CommonPagerSlidingTabStrip.this.fcT != null) {
                CommonPagerSlidingTabStrip.this.fcT.onPageSelected(i);
            }
            CommonPagerSlidingTabStrip.this.updateTabStyles();
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
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.core.view.CommonPagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: P */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: pj */
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
