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
    public LinearLayout.LayoutParams f13445e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout.LayoutParams f13446f;

    /* renamed from: g  reason: collision with root package name */
    public final d f13447g;

    /* renamed from: h  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f13448h;
    public LinearLayout i;
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
        public int f13449e;

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
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f13449e);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f13449e = parcel.readInt();
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
        public final /* synthetic */ int f13451e;

        public b(int i) {
            this.f13451e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PagerSlidingTabStrip.this.j.setCurrentItem(this.f13451e);
            PagerSlidingTabStrip.this.o();
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        int a(int i);
    }

    /* loaded from: classes3.dex */
    public class d implements ViewPager.OnPageChangeListener {
        public d() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.i.getChildCount() == 0) {
                return;
            }
            if (i == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.n(pagerSlidingTabStrip.j.getCurrentItem(), 0);
            }
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.f13448h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            if (PagerSlidingTabStrip.this.i.getChildCount() == 0) {
                return;
            }
            PagerSlidingTabStrip.this.l = i;
            PagerSlidingTabStrip.this.m = f2;
            PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
            pagerSlidingTabStrip.n(i, (int) (pagerSlidingTabStrip.i.getChildAt(i).getWidth() * f2));
            PagerSlidingTabStrip.this.invalidate();
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.f13448h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f2, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.f13448h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i);
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

    public final void h(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        i(i, imageButton);
    }

    public final void i(int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new b(i));
        int i2 = this.u;
        view.setPadding(i2, 0, i2, 0);
        this.i.addView(view, i, this.o ? this.f13446f : this.f13445e);
    }

    public final void j(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        i(i, textView);
    }

    public void k(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.i = linearLayout;
        linearLayout.setOrientation(0);
        this.i.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.i);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.r = (int) TypedValue.applyDimension(1, this.r, displayMetrics);
        this.t = (int) TypedValue.applyDimension(1, this.t, displayMetrics);
        this.u = (int) TypedValue.applyDimension(1, this.u, displayMetrics);
        this.v = (int) TypedValue.applyDimension(1, this.v, displayMetrics);
        this.w = i;
        this.s = i3;
        this.o = z;
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
        this.n.setStyle(Paint.Style.FILL);
        this.f13445e = new LinearLayout.LayoutParams(-2, -1);
        this.f13446f = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.B == null) {
            this.B = getResources().getConfiguration().locale;
        }
    }

    public void l() {
        ViewPager viewPager = this.j;
        if (viewPager == null || viewPager.getAdapter() == null || this.j.getAdapter().getCount() == 0) {
            return;
        }
        this.i.removeAllViews();
        this.k = this.j.getAdapter().getCount();
        for (int i = 0; i < this.k; i++) {
            if (this.j.getAdapter() instanceof c) {
                h(i, ((c) this.j.getAdapter()).a(i));
            } else {
                j(i, this.j.getAdapter().getPageTitle(i).toString());
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

    public final void n(int i, int i2) {
        if (this.k == 0) {
            return;
        }
        int left = this.i.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.r;
        }
        if (left != this.z) {
            this.z = left;
            scrollTo(left, 0);
        }
    }

    public final void o() {
        for (int i = 0; i < this.k; i++) {
            View childAt = this.i.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.A);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.w);
                    textView.setTypeface(this.x, this.y);
                    if (i == this.j.getCurrentItem()) {
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
        View childAt = this.i.getChildAt(this.l);
        float left = childAt.getLeft() + ((childAt.getWidth() - dimensionPixelSize) / 2);
        canvas.drawRoundRect(new RectF(left, height - this.s, dimensionPixelSize + left, height), 10.0f, 10.0f, this.n);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.l = savedState.f13449e;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f13449e = this.l;
        return savedState;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f13448h = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.j = viewPager;
        if (viewPager.getAdapter() == null) {
            return;
        }
        viewPager.setOnPageChangeListener(this.f13447g);
        l();
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13447g = new d(this, null);
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
