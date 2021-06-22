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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes3.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    public int A;
    public Locale B;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout.LayoutParams f12443e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout.LayoutParams f12444f;

    /* renamed from: g  reason: collision with root package name */
    public final d f12445g;

    /* renamed from: h  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f12446h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f12447i;
    public ViewPager j;
    public int k;
    public int l;
    public float m;
    public Paint n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public Typeface x;
    public int y;
    public int z;

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public int f12448e;

        /* loaded from: classes3.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f12448e);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f12448e = parcel.readInt();
        }
    }

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
            pagerSlidingTabStrip.l = pagerSlidingTabStrip.j.getCurrentItem();
            PagerSlidingTabStrip pagerSlidingTabStrip2 = PagerSlidingTabStrip.this;
            pagerSlidingTabStrip2.n(pagerSlidingTabStrip2.l, 0);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f12450e;

        public b(int i2) {
            this.f12450e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PagerSlidingTabStrip.this.j.setCurrentItem(this.f12450e);
            PagerSlidingTabStrip.this.o();
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        int a(int i2);
    }

    /* loaded from: classes3.dex */
    public class d implements ViewPager.OnPageChangeListener {
        public d() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            if (PagerSlidingTabStrip.this.f12447i.getChildCount() == 0) {
                return;
            }
            if (i2 == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.n(pagerSlidingTabStrip.j.getCurrentItem(), 0);
            }
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.f12446h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            if (PagerSlidingTabStrip.this.f12447i.getChildCount() == 0) {
                return;
            }
            PagerSlidingTabStrip.this.l = i2;
            PagerSlidingTabStrip.this.m = f2;
            PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
            pagerSlidingTabStrip.n(i2, (int) (pagerSlidingTabStrip.f12447i.getChildAt(i2).getWidth() * f2));
            PagerSlidingTabStrip.this.invalidate();
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.f12446h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.f12446h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i2);
            }
            PagerSlidingTabStrip.this.o();
        }

        public /* synthetic */ d(PagerSlidingTabStrip pagerSlidingTabStrip, a aVar) {
            this();
        }
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public final void h(int i2, int i3) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i3);
        i(i2, imageButton);
    }

    public final void i(int i2, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new b(i2));
        int i3 = this.u;
        view.setPadding(i3, 0, i3, 0);
        this.f12447i.addView(view, i2, this.o ? this.f12444f : this.f12443e);
    }

    public final void j(int i2, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        i(i2, textView);
    }

    public void k(int i2, int i3, int i4, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f12447i = linearLayout;
        linearLayout.setOrientation(0);
        this.f12447i.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.f12447i);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.r = (int) TypedValue.applyDimension(1, this.r, displayMetrics);
        this.t = (int) TypedValue.applyDimension(1, this.t, displayMetrics);
        this.u = (int) TypedValue.applyDimension(1, this.u, displayMetrics);
        this.v = (int) TypedValue.applyDimension(1, this.v, displayMetrics);
        this.w = i2;
        this.s = i4;
        this.o = z;
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
        this.n.setStyle(Paint.Style.FILL);
        this.f12443e = new LinearLayout.LayoutParams(-2, -1);
        this.f12444f = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.B == null) {
            this.B = getResources().getConfiguration().locale;
        }
    }

    public void l() {
        ViewPager viewPager = this.j;
        if (viewPager == null || viewPager.getAdapter() == null || this.j.getAdapter().getCount() == 0) {
            return;
        }
        this.f12447i.removeAllViews();
        this.k = this.j.getAdapter().getCount();
        for (int i2 = 0; i2 < this.k; i2++) {
            if (this.j.getAdapter() instanceof c) {
                h(i2, ((c) this.j.getAdapter()).a(i2));
            } else {
                j(i2, this.j.getAdapter().getPageTitle(i2).toString());
            }
        }
        o();
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public void m() {
        this.p = SkinManager.getColor(R.color.CAM_X0105);
        this.q = SkinManager.getColor(R.color.CAM_X0107);
        SkinManager.getColor(R.color.CAM_X0204);
        o();
    }

    public final void n(int i2, int i3) {
        if (this.k == 0) {
            return;
        }
        int left = this.f12447i.getChildAt(i2).getLeft() + i3;
        if (i2 > 0 || i3 > 0) {
            left -= this.r;
        }
        if (left != this.z) {
            this.z = left;
            scrollTo(left, 0);
        }
    }

    public final void o() {
        for (int i2 = 0; i2 < this.k; i2++) {
            View childAt = this.f12447i.getChildAt(i2);
            if (childAt != null) {
                childAt.setBackgroundResource(this.A);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.w);
                    textView.setTypeface(this.x, this.y);
                    if (i2 == this.j.getCurrentItem()) {
                        textView.setTextColor(this.p);
                    } else {
                        textView.setTextColor(this.q);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode() || this.k == 0) {
            return;
        }
        int height = getHeight();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
        this.n.setColor(this.p);
        View childAt = this.f12447i.getChildAt(this.l);
        float left = childAt.getLeft() + ((childAt.getWidth() - dimensionPixelSize) / 2);
        canvas.drawRoundRect(new RectF(left, height - this.s, dimensionPixelSize + left, height), 10.0f, 10.0f, this.n);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.l = savedState.f12448e;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f12448e = this.l;
        return savedState;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f12446h = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.j = viewPager;
        if (viewPager.getAdapter() == null) {
            return;
        }
        viewPager.setOnPageChangeListener(this.f12445g);
        l();
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12445g = new d(this, null);
        this.l = 0;
        this.o = false;
        this.p = SkinManager.getColor(R.color.CAM_X0105);
        this.q = SkinManager.getColor(R.color.CAM_X0107);
        SkinManager.getColor(R.color.CAM_X0204);
        this.r = 52;
        this.s = 4;
        this.t = 12;
        this.u = 24;
        this.v = 1;
        this.w = 12;
        this.x = null;
        this.y = 0;
        this.z = 0;
        this.A = R.drawable.pager_sliding_view;
    }
}
