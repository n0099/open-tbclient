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
    public LinearLayout.LayoutParams f13014e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout.LayoutParams f13015f;

    /* renamed from: g  reason: collision with root package name */
    public final d f13016g;

    /* renamed from: h  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f13017h;
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
    public int x;
    public int y;
    public Typeface z;

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public int f13018e;

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
            parcel.writeInt(this.f13018e);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f13018e = parcel.readInt();
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
        public final /* synthetic */ int f13020e;

        public b(int i) {
            this.f13020e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonPagerSlidingTabStrip.this.j.setCurrentItem(this.f13020e);
            CommonPagerSlidingTabStrip.this.p();
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
            if (CommonPagerSlidingTabStrip.this.i.getChildCount() == 0) {
                return;
            }
            if (i == 0) {
                CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = CommonPagerSlidingTabStrip.this;
                commonPagerSlidingTabStrip.o(commonPagerSlidingTabStrip.j.getCurrentItem(), 0);
            }
            ViewPager.OnPageChangeListener onPageChangeListener = CommonPagerSlidingTabStrip.this.f13017h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            if (CommonPagerSlidingTabStrip.this.i.getChildCount() == 0) {
                return;
            }
            CommonPagerSlidingTabStrip.this.l = i;
            CommonPagerSlidingTabStrip.this.m = f2;
            CommonPagerSlidingTabStrip commonPagerSlidingTabStrip = CommonPagerSlidingTabStrip.this;
            commonPagerSlidingTabStrip.o(i, (int) (commonPagerSlidingTabStrip.i.getChildAt(i).getWidth() * f2));
            CommonPagerSlidingTabStrip.this.invalidate();
            ViewPager.OnPageChangeListener onPageChangeListener = CommonPagerSlidingTabStrip.this.f13017h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f2, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            ViewPager.OnPageChangeListener onPageChangeListener = CommonPagerSlidingTabStrip.this.f13017h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i);
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

    public final void h(int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        i(i, imageButton);
    }

    public final void i(int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new b(i));
        view.setPadding(this.t, this.u, this.v, this.w);
        this.i.addView(view, i, this.o ? this.f13015f : this.f13014e);
    }

    public final void j(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        i(i, textView);
    }

    public void k(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.y = i;
        this.t = i2;
        this.u = i3;
        this.v = i4;
        this.w = i5;
        this.s = i6;
        this.x = i7;
        this.q = i8;
        this.p = i9;
    }

    public final void l() {
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.i = linearLayout;
        linearLayout.setOrientation(0);
        this.i.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.i);
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
        this.n.setStyle(Paint.Style.FILL);
        this.f13014e = new LinearLayout.LayoutParams(-2, -1);
        this.f13015f = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void m() {
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
        p();
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public void n(int i) {
        this.p = SkinManager.getColor(i, this.p);
        this.q = SkinManager.getColor(i, this.q);
        p();
    }

    public final void o(int i, int i2) {
        if (this.k == 0) {
            return;
        }
        int left = this.i.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.r;
        }
        if (left != this.B) {
            this.B = left;
            scrollTo(left, 0);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (isInEditMode() || this.k == 0 || this.i.getChildCount() <= 1) {
            return;
        }
        int height = getHeight();
        this.n.setColor(this.p);
        View childAt = this.i.getChildAt(this.l);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.m > 0.0f && (i = this.l) < this.k - 1) {
            View childAt2 = this.i.getChildAt(i + 1);
            float f2 = this.m;
            left = (childAt2.getLeft() * f2) + ((1.0f - f2) * left);
            right = (childAt2.getRight() * f2) + ((1.0f - f2) * right);
        }
        float f3 = right;
        float f4 = left;
        float f5 = f3 - f4;
        int i2 = this.x;
        if (f5 < i2) {
            canvas.drawRect(f4, height - this.s, f3, height, this.n);
        } else {
            canvas.drawRect(f4 + ((f5 - i2) / 2.0f), height - this.s, f3 - ((f5 - i2) / 2.0f), height, this.n);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.l = savedState.f13018e;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f13018e = this.l;
        return savedState;
    }

    public final void p() {
        for (int i = 0; i < this.k; i++) {
            View childAt = this.i.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.C);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.y);
                    textView.setTypeface(this.z, this.A);
                    if (i == this.j.getCurrentItem()) {
                        textView.setTextColor(this.p);
                    } else {
                        textView.setTextColor(this.q);
                    }
                }
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f13017h = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.j = viewPager;
        if (viewPager.getAdapter() == null) {
            return;
        }
        viewPager.setOnPageChangeListener(this.f13016g);
        m();
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonPagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13016g = new d(this, null);
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
