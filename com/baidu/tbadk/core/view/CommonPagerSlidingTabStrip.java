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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class CommonPagerSlidingTabStrip extends HorizontalScrollView {
    public int A;
    public int B;
    public int C;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout.LayoutParams f12944e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout.LayoutParams f12945f;

    /* renamed from: g  reason: collision with root package name */
    public final d f12946g;

    /* renamed from: h  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f12947h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f12948i;
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
    public int x;
    public int y;
    public Typeface z;

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public int f12949e;

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
            parcel.writeInt(this.f12949e);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f12949e = parcel.readInt();
        }
    }

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            CommonPagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = CommonPagerSlidingTabStrip.this;
            commonPagerSlidingTabStrip.l = commonPagerSlidingTabStrip.j.getCurrentItem();
            CommonPagerSlidingTabStrip commonPagerSlidingTabStrip2 = CommonPagerSlidingTabStrip.this;
            commonPagerSlidingTabStrip2.o(commonPagerSlidingTabStrip2.l, 0);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f12951e;

        public b(int i2) {
            this.f12951e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonPagerSlidingTabStrip.this.j.setCurrentItem(this.f12951e);
            CommonPagerSlidingTabStrip.this.p();
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
            if (CommonPagerSlidingTabStrip.this.f12948i.getChildCount() == 0) {
                return;
            }
            if (i2 == 0) {
                CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = CommonPagerSlidingTabStrip.this;
                commonPagerSlidingTabStrip.o(commonPagerSlidingTabStrip.j.getCurrentItem(), 0);
            }
            ViewPager.OnPageChangeListener onPageChangeListener = CommonPagerSlidingTabStrip.this.f12947h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            if (CommonPagerSlidingTabStrip.this.f12948i.getChildCount() == 0) {
                return;
            }
            CommonPagerSlidingTabStrip.this.l = i2;
            CommonPagerSlidingTabStrip.this.m = f2;
            CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = CommonPagerSlidingTabStrip.this;
            commonPagerSlidingTabStrip.o(i2, (int) (commonPagerSlidingTabStrip.f12948i.getChildAt(i2).getWidth() * f2));
            CommonPagerSlidingTabStrip.this.invalidate();
            ViewPager.OnPageChangeListener onPageChangeListener = CommonPagerSlidingTabStrip.this.f12947h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            ViewPager.OnPageChangeListener onPageChangeListener = CommonPagerSlidingTabStrip.this.f12947h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i2);
            }
            CommonPagerSlidingTabStrip.this.p();
        }

        public /* synthetic */ d(CommonPagerSlidingTabStrip commonPagerSlidingTabStrip, a aVar) {
            this();
        }
    }

    public CommonPagerSlidingTabStrip(Context context) {
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
        view.setPadding(this.t, this.u, this.v, this.w);
        this.f12948i.addView(view, i2, this.o ? this.f12945f : this.f12944e);
    }

    public final void j(int i2, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        i(i2, textView);
    }

    public void k(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.y = i2;
        this.t = i3;
        this.u = i4;
        this.v = i5;
        this.w = i6;
        this.s = i7;
        this.x = i8;
        this.q = i9;
        this.p = i10;
    }

    public final void l() {
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f12948i = linearLayout;
        linearLayout.setOrientation(0);
        this.f12948i.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.f12948i);
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
        this.n.setStyle(Paint.Style.FILL);
        this.f12944e = new LinearLayout.LayoutParams(-2, -1);
        this.f12945f = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void m() {
        ViewPager viewPager = this.j;
        if (viewPager == null || viewPager.getAdapter() == null || this.j.getAdapter().getCount() == 0) {
            return;
        }
        this.f12948i.removeAllViews();
        this.k = this.j.getAdapter().getCount();
        for (int i2 = 0; i2 < this.k; i2++) {
            if (this.j.getAdapter() instanceof c) {
                h(i2, ((c) this.j.getAdapter()).a(i2));
            } else {
                j(i2, this.j.getAdapter().getPageTitle(i2).toString());
            }
        }
        p();
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public void n(int i2) {
        this.p = SkinManager.getColor(i2, this.p);
        this.q = SkinManager.getColor(i2, this.q);
        p();
    }

    public final void o(int i2, int i3) {
        if (this.k == 0) {
            return;
        }
        int left = this.f12948i.getChildAt(i2).getLeft() + i3;
        if (i2 > 0 || i3 > 0) {
            left -= this.r;
        }
        if (left != this.B) {
            this.B = left;
            scrollTo(left, 0);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        if (isInEditMode() || this.k == 0 || this.f12948i.getChildCount() <= 1) {
            return;
        }
        int height = getHeight();
        this.n.setColor(this.p);
        View childAt = this.f12948i.getChildAt(this.l);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.m > 0.0f && (i2 = this.l) < this.k - 1) {
            View childAt2 = this.f12948i.getChildAt(i2 + 1);
            float f2 = this.m;
            left = (childAt2.getLeft() * f2) + ((1.0f - f2) * left);
            right = (childAt2.getRight() * f2) + ((1.0f - f2) * right);
        }
        float f3 = right;
        float f4 = left;
        float f5 = f3 - f4;
        int i3 = this.x;
        if (f5 < i3) {
            canvas.drawRect(f4, height - this.s, f3, height, this.n);
        } else {
            canvas.drawRect(f4 + ((f5 - i3) / 2.0f), height - this.s, f3 - ((f5 - i3) / 2.0f), height, this.n);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.l = savedState.f12949e;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f12949e = this.l;
        return savedState;
    }

    public final void p() {
        for (int i2 = 0; i2 < this.k; i2++) {
            View childAt = this.f12948i.getChildAt(i2);
            if (childAt != null) {
                childAt.setBackgroundResource(this.C);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.y);
                    textView.setTypeface(this.z, this.A);
                    if (i2 == this.j.getCurrentItem()) {
                        textView.setTextColor(this.p);
                    } else {
                        textView.setTextColor(this.q);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f12947h = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.j = viewPager;
        if (viewPager.getAdapter() == null) {
            return;
        }
        viewPager.setOnPageChangeListener(this.f12946g);
        m();
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12946g = new d(this, null);
        this.l = 0;
        this.m = 0.0f;
        this.o = false;
        this.p = SkinManager.getColor(R.color.CAM_X0105);
        this.q = SkinManager.getColor(R.color.CAM_X0107);
        this.r = 52;
        this.s = 4;
        this.t = 24;
        this.u = 24;
        this.v = 24;
        this.w = 24;
        this.x = 40;
        this.y = 12;
        this.z = null;
        this.A = 0;
        this.B = 0;
        this.C = R.drawable.pager_sliding_view;
        l();
    }
}
