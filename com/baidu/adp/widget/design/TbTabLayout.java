package com.baidu.adp.widget.design;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R$styleable;
import d.a.c.e.p.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbTabLayout extends HorizontalScrollView {
    public static final int[] M = {R.attr.colorPrimary};
    public static final Interpolator N = new FastOutSlowInInterpolator();
    public static final Pools.Pool<f> O = new Pools.SynchronizedPool(16);
    public final ArrayList<c> A;
    public c B;
    public ValueAnimator C;
    public ViewPager D;
    public PagerAdapter E;
    public DataSetObserver F;
    public TbTabLayoutOnPageChangeListener G;
    public b H;
    public boolean I;
    public boolean J;
    public final Pools.Pool<g> K;
    public int L;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<f> f2421e;

    /* renamed from: f  reason: collision with root package name */
    public f f2422f;

    /* renamed from: g  reason: collision with root package name */
    public final e f2423g;

    /* renamed from: h  reason: collision with root package name */
    public int f2424h;

    /* renamed from: i  reason: collision with root package name */
    public int f2425i;
    public int j;
    public int k;
    public int l;
    public ColorStateList m;
    public float n;
    public float o;
    public float p;
    public boolean q;
    public final int r;
    public int s;
    public final int t;
    public final int u;
    public final int v;
    public int w;
    public int x;
    public int y;
    public c z;

    /* loaded from: classes.dex */
    public static class TbTabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<TbTabLayout> f2426e;

        /* renamed from: f  reason: collision with root package name */
        public int f2427f;

        /* renamed from: g  reason: collision with root package name */
        public int f2428g;

        public TbTabLayoutOnPageChangeListener(TbTabLayout tbTabLayout) {
            this.f2426e = new WeakReference<>(tbTabLayout);
        }

        public void a() {
            this.f2428g = 0;
            this.f2427f = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            this.f2427f = this.f2428g;
            this.f2428g = i2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            TbTabLayout tbTabLayout = this.f2426e.get();
            if (tbTabLayout != null) {
                boolean z = false;
                tbTabLayout.H(i2, f2, this.f2428g != 2 || this.f2427f == 1, (this.f2428g == 2 && this.f2427f == 0) ? true : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            TbTabLayout tbTabLayout = this.f2426e.get();
            if (tbTabLayout == null || tbTabLayout.getSelectedTabPosition() == i2 || i2 >= tbTabLayout.getTabCount()) {
                return;
            }
            int i3 = this.f2428g;
            tbTabLayout.F(tbTabLayout.w(i2), i3 == 0 || (i3 == 2 && this.f2427f == 0));
        }
    }

    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TbTabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* loaded from: classes.dex */
    public class b implements ViewPager.OnAdapterChangeListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f2430e;

        public b() {
        }

        public void a(boolean z) {
            this.f2430e = z;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TbTabLayout tbTabLayout = TbTabLayout.this;
            if (tbTabLayout.D == viewPager) {
                tbTabLayout.G(pagerAdapter2, this.f2430e);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(f fVar);

        void c(f fVar);

        void e(f fVar);
    }

    /* loaded from: classes.dex */
    public class d extends DataSetObserver {
        public d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TbTabLayout.this.A();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TbTabLayout.this.A();
        }
    }

    /* loaded from: classes.dex */
    public class e extends LinearLayout {

        /* renamed from: e  reason: collision with root package name */
        public int f2433e;

        /* renamed from: f  reason: collision with root package name */
        public int f2434f;

        /* renamed from: g  reason: collision with root package name */
        public int f2435g;

        /* renamed from: h  reason: collision with root package name */
        public final Paint f2436h;

        /* renamed from: i  reason: collision with root package name */
        public int f2437i;
        public float j;
        public int k;
        public int l;
        public int m;
        public ValueAnimator n;

        /* loaded from: classes.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f2438e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f2439f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f2440g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ int f2441h;

            public a(int i2, int i3, int i4, int i5) {
                this.f2438e = i2;
                this.f2439f = i3;
                this.f2440g = i4;
                this.f2441h = i5;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                e.this.d(TbTabLayout.y(this.f2438e, this.f2439f, animatedFraction), TbTabLayout.y(this.f2440g, this.f2441h, animatedFraction));
            }
        }

        /* loaded from: classes.dex */
        public class b extends AnimatorListenerAdapter {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f2443e;

            public b(int i2) {
                this.f2443e = i2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e eVar = e.this;
                eVar.f2437i = this.f2443e;
                eVar.j = 0.0f;
            }
        }

        public e(Context context) {
            super(context);
            this.f2437i = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            setWillNotDraw(false);
            Paint paint = new Paint();
            this.f2436h = paint;
            paint.setStrokeCap(Paint.Cap.ROUND);
            this.f2436h.setAntiAlias(true);
        }

        public void a(int i2, int i3) {
            int i4;
            int i5;
            ValueAnimator valueAnimator = this.n;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.n.cancel();
            }
            boolean z = ViewCompat.getLayoutDirection(this) == 1;
            View childAt = getChildAt(i2);
            if (childAt == null) {
                j();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (Math.abs(i2 - this.f2437i) <= 1) {
                i4 = this.l;
                i5 = this.m;
            } else {
                int u = TbTabLayout.this.u(24);
                i4 = (i2 >= this.f2437i ? !z : z) ? left - u : u + right;
                i5 = i4;
            }
            if (i4 == left && i5 == right) {
                return;
            }
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.n = valueAnimator2;
            valueAnimator2.setInterpolator(TbTabLayout.N);
            valueAnimator2.setDuration(i3);
            valueAnimator2.setFloatValues(0.0f, 1.0f);
            valueAnimator2.addUpdateListener(new a(i4, left, i5, right));
            valueAnimator2.addListener(new b(i2));
            valueAnimator2.start();
        }

        public boolean b() {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (getChildAt(i2).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        public float c() {
            return this.f2437i + this.j;
        }

        public void d(int i2, int i3) {
            if (i2 == this.l && i3 == this.m) {
                return;
            }
            this.l = i2;
            this.m = i3;
            ViewCompat.postInvalidateOnAnimation(this);
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int intrinsicHeight;
            Rect rect;
            int i2;
            super.draw(canvas);
            int i3 = this.l;
            if (i3 >= 0 && (i2 = this.m) > i3) {
                int i4 = this.f2435g;
                int i5 = (i4 <= 0 || i2 - i3 <= i4) ? 0 : ((i2 - i3) - i4) / 2;
                canvas.drawLine(this.l + i5, (getHeight() - (this.f2433e / 2)) - this.f2434f, this.m - i5, (getHeight() - (this.f2433e / 2)) - this.f2434f, this.f2436h);
            }
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (getChildAt(childCount) instanceof g) {
                    g gVar = (g) getChildAt(childCount);
                    if (gVar.k != null) {
                        TextView textView = null;
                        if (gVar.f2455f != null) {
                            textView = gVar.f2455f;
                        } else if (gVar.f2458i != null) {
                            textView = gVar.f2458i;
                        }
                        if (textView != null) {
                            int right = (gVar.getRight() - (gVar.getWidth() - textView.getRight())) - l.g(getContext(), com.baidu.tieba.R.dimen.tbds3);
                            int top = (textView.getTop() - (gVar.k.getIntrinsicHeight() / 2)) + l.g(getContext(), com.baidu.tieba.R.dimen.tbds10);
                            gVar.k.setBounds(right, top, gVar.k.getIntrinsicWidth() + right, gVar.k.getIntrinsicHeight() + top);
                            gVar.k.draw(canvas);
                            if (!TextUtils.isEmpty(gVar.l)) {
                                if (gVar.l.equals(StringHelper.STRING_MORE)) {
                                    Drawable drawable = SkinManager.getDrawable(com.baidu.tieba.R.drawable.icon_news_white_dot);
                                    int intrinsicWidth = right + (gVar.k.getIntrinsicWidth() / 2);
                                    int intrinsicHeight2 = top + (gVar.k.getIntrinsicHeight() / 2);
                                    int g2 = l.g(getContext(), com.baidu.tieba.R.dimen.tbds6);
                                    int g3 = l.g(getContext(), com.baidu.tieba.R.dimen.tbds7);
                                    int i6 = g2 / 2;
                                    int i7 = intrinsicWidth - i6;
                                    int i8 = intrinsicHeight2 - i6;
                                    int i9 = intrinsicWidth + i6;
                                    int i10 = intrinsicHeight2 + i6;
                                    drawable.setBounds(i7, i8, i9, i10);
                                    drawable.draw(canvas);
                                    int i11 = i7 - g3;
                                    drawable.setBounds(i11 - g2, i8, i11, i10);
                                    drawable.draw(canvas);
                                    int i12 = i9 + g3;
                                    drawable.setBounds(i12, i8, g2 + i12, i10);
                                    drawable.draw(canvas);
                                } else {
                                    Paint paint = new Paint(1);
                                    paint.setColor(SkinManager.getColor(com.baidu.tieba.R.color.CAM_X0101));
                                    paint.setTextSize(l.g(getContext(), com.baidu.tieba.R.dimen.tbfontsize26));
                                    paint.setTextAlign(Paint.Align.CENTER);
                                    paint.setTypeface(Typeface.MONOSPACE);
                                    paint.getTextBounds(gVar.l, 0, gVar.l.length(), new Rect());
                                    canvas.drawText(gVar.l, right + (gVar.k.getIntrinsicWidth() / 2), (intrinsicHeight - ((gVar.k.getIntrinsicHeight() - rect.height()) / 2)) - TbTabLayout.this.L, paint);
                                }
                            }
                        }
                    }
                }
            }
        }

        public void e(int i2, float f2) {
            ValueAnimator valueAnimator = this.n;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.n.cancel();
            }
            this.f2437i = i2;
            this.j = f2;
            j();
        }

        public void f(int i2) {
            if (this.f2434f != i2) {
                this.f2434f = i2;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        public void g(int i2) {
            if (this.f2436h.getColor() != i2) {
                this.f2436h.setColor(i2);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        public void h(int i2) {
            if (this.f2433e != i2) {
                this.f2433e = i2;
                this.f2436h.setStrokeWidth(i2);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        public void i(int i2) {
            if (this.f2435g != i2) {
                this.f2435g = i2;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        public final void j() {
            int i2;
            int i3;
            View childAt = getChildAt(this.f2437i);
            if (childAt == null || childAt.getWidth() <= 0) {
                i2 = -1;
                i3 = -1;
            } else {
                i2 = childAt.getLeft();
                i3 = childAt.getRight();
                if (this.j > 0.0f && this.f2437i < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f2437i + 1);
                    float left = this.j * childAt2.getLeft();
                    float f2 = this.j;
                    i2 = (int) (left + ((1.0f - f2) * i2));
                    i3 = (int) ((f2 * childAt2.getRight()) + ((1.0f - this.j) * i3));
                }
            }
            d(i2, i3);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            ValueAnimator valueAnimator = this.n;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.n.cancel();
                a(this.f2437i, Math.round((1.0f - this.n.getAnimatedFraction()) * ((float) this.n.getDuration())));
                return;
            }
            j();
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) != 1073741824) {
                return;
            }
            TbTabLayout tbTabLayout = TbTabLayout.this;
            boolean z = true;
            if (tbTabLayout.y == 1 && tbTabLayout.x == 1) {
                int childCount = getChildCount();
                int i4 = 0;
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = getChildAt(i5);
                    if (childAt.getVisibility() == 0) {
                        i4 = Math.max(i4, childAt.getMeasuredWidth());
                    }
                }
                if (i4 <= 0) {
                    return;
                }
                if (i4 * childCount <= getMeasuredWidth() - (TbTabLayout.this.u(16) * 2)) {
                    boolean z2 = false;
                    for (int i6 = 0; i6 < childCount; i6++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i6).getLayoutParams();
                        if (layoutParams.width != i4 || layoutParams.weight != 0.0f) {
                            layoutParams.width = i4;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    TbTabLayout tbTabLayout2 = TbTabLayout.this;
                    tbTabLayout2.x = 0;
                    tbTabLayout2.L(false);
                }
                if (z) {
                    super.onMeasure(i2, i3);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i2) {
            super.onRtlPropertiesChanged(i2);
            if (Build.VERSION.SDK_INT >= 23 || this.k == i2) {
                return;
            }
            requestLayout();
            this.k = i2;
        }
    }

    /* loaded from: classes.dex */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        public Drawable f2445a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f2446b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f2447c;

        /* renamed from: e  reason: collision with root package name */
        public View f2449e;

        /* renamed from: f  reason: collision with root package name */
        public int f2450f;

        /* renamed from: i  reason: collision with root package name */
        public TbTabLayout f2453i;
        public g j;

        /* renamed from: d  reason: collision with root package name */
        public int f2448d = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f2451g = 0;

        /* renamed from: h  reason: collision with root package name */
        public boolean f2452h = false;

        @Nullable
        public CharSequence a() {
            return this.f2447c;
        }

        @Nullable
        public View b() {
            return this.f2449e;
        }

        @Nullable
        public Drawable c() {
            return this.f2445a;
        }

        public int d() {
            return this.f2450f;
        }

        public int e() {
            return this.f2448d;
        }

        public int f() {
            return this.f2451g;
        }

        @Nullable
        public CharSequence g() {
            return this.f2446b;
        }

        public boolean h() {
            TbTabLayout tbTabLayout = this.f2453i;
            if (tbTabLayout != null) {
                return tbTabLayout.getSelectedTabPosition() == this.f2448d;
            }
            throw new IllegalArgumentException("Tab not attached to a TbTabLayout");
        }

        public boolean i() {
            return this.f2452h;
        }

        public f j(int i2, boolean z) {
            this.f2451g = i2;
            this.f2452h = z;
            t();
            return this;
        }

        public void k() {
            this.f2453i = null;
            this.j = null;
            this.f2445a = null;
            this.f2446b = null;
            this.f2447c = null;
            this.f2448d = -1;
            this.f2449e = null;
        }

        public void l() {
            TbTabLayout tbTabLayout = this.f2453i;
            if (tbTabLayout != null) {
                tbTabLayout.E(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TbTabLayout");
        }

        @NonNull
        public f m(@Nullable CharSequence charSequence) {
            this.f2447c = charSequence;
            t();
            return this;
        }

        @NonNull
        public f n(@LayoutRes int i2) {
            o(LayoutInflater.from(this.j.getContext()).inflate(i2, (ViewGroup) this.j, false));
            return this;
        }

        @NonNull
        public f o(@Nullable View view) {
            this.f2449e = view;
            t();
            return this;
        }

        @NonNull
        public f p(@Nullable Drawable drawable) {
            this.f2445a = drawable;
            t();
            return this;
        }

        public f q(int i2) {
            this.f2450f = i2;
            return this;
        }

        public void r(int i2) {
            this.f2448d = i2;
        }

        @NonNull
        public f s(@Nullable CharSequence charSequence) {
            this.f2446b = charSequence;
            t();
            return this;
        }

        public void t() {
            g gVar = this.j;
            if (gVar != null) {
                gVar.i();
            }
        }
    }

    /* loaded from: classes.dex */
    public class g extends LinearLayout {

        /* renamed from: e  reason: collision with root package name */
        public f f2454e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f2455f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f2456g;

        /* renamed from: h  reason: collision with root package name */
        public View f2457h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f2458i;
        public ImageView j;
        public Drawable k;
        public String l;
        public int m;

        public g(Context context) {
            super(context);
            this.m = 2;
            int i2 = TbTabLayout.this.r;
            if (i2 != 0) {
                ViewCompat.setBackground(this, AppCompatResources.getDrawable(context, i2));
            }
            ViewCompat.setPaddingRelative(this, TbTabLayout.this.f2424h, TbTabLayout.this.f2425i, TbTabLayout.this.j, TbTabLayout.this.k);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        public final float e(Layout layout, int i2, float f2) {
            return layout.getLineWidth(i2) * (f2 / layout.getPaint().getTextSize());
        }

        public void f() {
            g(null);
            setSelected(false);
        }

        public void g(@Nullable f fVar) {
            if (fVar != this.f2454e) {
                this.f2454e = fVar;
                i();
            }
        }

        public final void h(boolean z) {
            TextView textView = this.f2455f;
            if (textView != null) {
                if (z) {
                    float f2 = TbTabLayout.this.p;
                    if (f2 > 0.0f) {
                        textView.setTextSize(0, f2);
                        if (!z && TbTabLayout.this.q) {
                            this.f2455f.setTypeface(Typeface.defaultFromStyle(1));
                            return;
                        } else {
                            this.f2455f.setTypeface(Typeface.defaultFromStyle(0));
                        }
                    }
                }
                this.f2455f.setTextSize(0, TbTabLayout.this.n);
                if (!z) {
                }
                this.f2455f.setTypeface(Typeface.defaultFromStyle(0));
            }
        }

        public final void i() {
            f fVar = this.f2454e;
            View b2 = fVar != null ? fVar.b() : null;
            if (b2 != null) {
                ViewParent parent = b2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b2);
                    }
                    addView(b2);
                }
                this.f2457h = b2;
                TextView textView = this.f2455f;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f2456g;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f2456g.setImageDrawable(null);
                }
                TextView textView2 = (TextView) b2.findViewById(16908308);
                this.f2458i = textView2;
                if (textView2 != null) {
                    this.m = TextViewCompat.getMaxLines(textView2);
                }
                this.j = (ImageView) b2.findViewById(16908294);
            } else {
                View view = this.f2457h;
                if (view != null) {
                    removeView(view);
                    this.f2457h = null;
                }
                this.f2458i = null;
                this.j = null;
            }
            boolean z = false;
            if (this.f2457h == null) {
                if (this.f2456g == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(com.google.android.material.R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                    addView(imageView2, 0);
                    this.f2456g = imageView2;
                }
                if (this.f2455f == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(com.google.android.material.R.layout.design_layout_tab_text, (ViewGroup) this, false);
                    addView(textView3);
                    this.f2455f = textView3;
                    this.m = TextViewCompat.getMaxLines(textView3);
                }
                TextViewCompat.setTextAppearance(this.f2455f, TbTabLayout.this.l);
                ColorStateList colorStateList = TbTabLayout.this.m;
                if (colorStateList != null) {
                    this.f2455f.setTextColor(colorStateList);
                }
                j(this.f2455f, this.f2456g);
            } else if (this.f2458i != null || this.j != null) {
                j(this.f2458i, this.j);
            }
            if (fVar != null && fVar.h()) {
                z = true;
            }
            setSelected(z);
        }

        public final void j(@Nullable TextView textView, @Nullable ImageView imageView) {
            f fVar = this.f2454e;
            Drawable c2 = fVar != null ? fVar.c() : null;
            f fVar2 = this.f2454e;
            CharSequence g2 = fVar2 != null ? fVar2.g() : null;
            f fVar3 = this.f2454e;
            CharSequence a2 = fVar3 != null ? fVar3.a() : null;
            f fVar4 = this.f2454e;
            int i2 = 0;
            int f2 = fVar4 != null ? fVar4.f() : 0;
            f fVar5 = this.f2454e;
            boolean i3 = fVar5 != null ? fVar5.i() : false;
            if (imageView != null) {
                if (c2 != null) {
                    imageView.setImageDrawable(c2);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(a2);
            }
            boolean z = !TextUtils.isEmpty(g2);
            if (textView != null) {
                if (z) {
                    textView.setText(g2);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
                textView.setContentDescription(a2);
            }
            if (textView != null && z) {
                if (i3) {
                    if (f2 <= 0) {
                        this.k = SkinManager.getDrawable(com.baidu.tieba.R.drawable.icon_news_red_dot);
                        this.l = null;
                    } else if (f2 < 10) {
                        this.k = SkinManager.getDrawable(com.baidu.tieba.R.drawable.icon_news_red_dot_one_number);
                        this.l = String.valueOf(f2);
                    } else if (f2 < 100) {
                        this.k = SkinManager.getDrawable(com.baidu.tieba.R.drawable.icon_news_red_dot_two_number);
                        this.l = String.valueOf(f2);
                    } else {
                        this.k = SkinManager.getDrawable(com.baidu.tieba.R.drawable.icon_news_red_dot_two_number);
                        this.l = StringHelper.STRING_MORE;
                    }
                    if (this.k == null) {
                        this.k = SkinManager.getDrawable(com.baidu.tieba.R.drawable.icon_news_red_dot);
                    }
                } else {
                    this.k = null;
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (z && imageView.getVisibility() == 0) {
                    i2 = TbTabLayout.this.u(8);
                }
                if (i2 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i2;
                    imageView.requestLayout();
                }
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int tabMaxWidth = TbTabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i2 = View.MeasureSpec.makeMeasureSpec(TbTabLayout.this.s, Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
            if (this.f2455f != null) {
                getResources();
                float f2 = TbTabLayout.this.n;
                int i4 = this.m;
                ImageView imageView = this.f2456g;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f2455f;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = TbTabLayout.this.o;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.f2455f.getTextSize();
                int lineCount = this.f2455f.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.f2455f);
                int i5 = (f2 > textSize ? 1 : (f2 == textSize ? 0 : -1));
                if (i5 != 0 || (maxLines >= 0 && i4 != maxLines)) {
                    if (TbTabLayout.this.y == 1 && i5 > 0 && lineCount == 1 && ((layout = this.f2455f.getLayout()) == null || e(layout, 0, f2) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.f2455f.setMaxLines(i4);
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (TbTabLayout.this.J) {
                return false;
            }
            if (this.f2454e != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.f2454e.l();
                return true;
            }
            return performClick;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.f2455f;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.f2456g;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.f2457h;
            if (view != null) {
                view.setSelected(z);
            }
            h(z);
        }
    }

    /* loaded from: classes.dex */
    public static class h implements c {

        /* renamed from: e  reason: collision with root package name */
        public final ViewPager f2459e;

        public h(ViewPager viewPager) {
            this.f2459e = viewPager;
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.c
        public void a(f fVar) {
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.c
        public void c(f fVar) {
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.c
        public void e(f fVar) {
            this.f2459e.setCurrentItem(fVar.e());
        }
    }

    public TbTabLayout(Context context) {
        this(context, null);
    }

    private int getDefaultHeight() {
        int size = this.f2421e.size();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                f fVar = this.f2421e.get(i2);
                if (fVar != null && fVar.c() != null && !TextUtils.isEmpty(fVar.g())) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return z ? 72 : 48;
    }

    private float getScrollPosition() {
        return this.f2423g.c();
    }

    private int getTabMinWidth() {
        int i2 = this.t;
        if (i2 != -1) {
            return i2;
        }
        if (this.y == 0) {
            return this.v;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f2423g.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    public static void m(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(M);
        boolean z = !obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        if (z) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }

    public static ColorStateList o(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.f2423g.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                this.f2423g.getChildAt(i3).setSelected(i3 == i2);
                i3++;
            }
        }
    }

    public static int y(int i2, int i3, float f2) {
        return i2 + Math.round(f2 * (i3 - i2));
    }

    public void A() {
        int currentItem;
        B();
        PagerAdapter pagerAdapter = this.E;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                f z = z();
                z.s(this.E.getPageTitle(i2));
                f(z, false);
            }
            ViewPager viewPager = this.D;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            E(w(currentItem));
        }
    }

    public void B() {
        for (int childCount = this.f2423g.getChildCount() - 1; childCount >= 0; childCount--) {
            D(childCount);
        }
        Iterator<f> it = this.f2421e.iterator();
        while (it.hasNext()) {
            f next = it.next();
            it.remove();
            next.k();
            O.release(next);
        }
        this.f2422f = null;
    }

    public void C(@NonNull c cVar) {
        this.A.remove(cVar);
    }

    public final void D(int i2) {
        g gVar = (g) this.f2423g.getChildAt(i2);
        this.f2423g.removeViewAt(i2);
        if (gVar != null) {
            gVar.f();
            this.K.release(gVar);
        }
        requestLayout();
    }

    public void E(f fVar) {
        F(fVar, true);
    }

    public void F(f fVar, boolean z) {
        f fVar2 = this.f2422f;
        if (fVar2 == fVar) {
            if (fVar2 != null) {
                r(fVar);
                j(fVar.e());
                return;
            }
            return;
        }
        int e2 = fVar != null ? fVar.e() : -1;
        if (z) {
            if ((fVar2 == null || fVar2.e() == -1) && e2 != -1) {
                setScrollPosition(e2, 0.0f, true);
            } else {
                j(e2);
            }
            if (e2 != -1) {
                setSelectedTabView(e2);
            }
        }
        if (fVar2 != null) {
            t(fVar2);
        }
        this.f2422f = fVar;
        if (fVar != null) {
            s(fVar);
        }
    }

    public void G(@Nullable PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.E;
        if (pagerAdapter2 != null && (dataSetObserver = this.F) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.E = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.F == null) {
                this.F = new d();
            }
            pagerAdapter.registerDataSetObserver(this.F);
        }
        A();
    }

    public void H(int i2, float f2, boolean z, boolean z2) {
        int round = Math.round(i2 + f2);
        if (round < 0 || round >= this.f2423g.getChildCount()) {
            return;
        }
        if (z2) {
            this.f2423g.e(i2, f2);
        }
        ValueAnimator valueAnimator = this.C;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.C.cancel();
        }
        scrollTo(l(i2, f2), 0);
        if (z) {
            setSelectedTabView(round);
        }
    }

    public final void I(@Nullable ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.D;
        if (viewPager2 != null) {
            TbTabLayoutOnPageChangeListener tbTabLayoutOnPageChangeListener = this.G;
            if (tbTabLayoutOnPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(tbTabLayoutOnPageChangeListener);
            }
            b bVar = this.H;
            if (bVar != null) {
                this.D.removeOnAdapterChangeListener(bVar);
            }
        }
        c cVar = this.B;
        if (cVar != null) {
            C(cVar);
            this.B = null;
        }
        if (viewPager != null) {
            this.D = viewPager;
            if (this.G == null) {
                this.G = new TbTabLayoutOnPageChangeListener(this);
            }
            this.G.a();
            viewPager.addOnPageChangeListener(this.G);
            h hVar = new h(viewPager);
            this.B = hVar;
            c(hVar);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                G(adapter, z);
            }
            if (this.H == null) {
                this.H = new b();
            }
            this.H.a(z);
            viewPager.addOnAdapterChangeListener(this.H);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.D = null;
            G(null, false);
        }
        this.I = z2;
    }

    public final void J() {
        int size = this.f2421e.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f2421e.get(i2).t();
        }
    }

    public final void K(LinearLayout.LayoutParams layoutParams) {
        if (this.y == 1 && this.x == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    public void L(boolean z) {
        for (int i2 = 0; i2 < this.f2423g.getChildCount(); i2++) {
            View childAt = this.f2423g.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            K((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        i(view);
    }

    public void c(@NonNull c cVar) {
        if (this.A.contains(cVar)) {
            return;
        }
        this.A.add(cVar);
    }

    public void d(@NonNull f fVar) {
        f(fVar, this.f2421e.isEmpty());
    }

    public void e(@NonNull f fVar, int i2, boolean z) {
        if (fVar.f2453i == this) {
            n(fVar, i2);
            h(fVar);
            if (z) {
                fVar.l();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TbTabLayout.");
    }

    public void f(@NonNull f fVar, boolean z) {
        e(fVar, this.f2421e.size(), z);
    }

    public final void g(@NonNull TbTabItem tbTabItem) {
        f z = z();
        CharSequence charSequence = tbTabItem.f2418e;
        if (charSequence != null) {
            z.s(charSequence);
        }
        Drawable drawable = tbTabItem.f2419f;
        if (drawable != null) {
            z.p(drawable);
        }
        int i2 = tbTabItem.f2420g;
        if (i2 != 0) {
            z.n(i2);
        }
        if (!TextUtils.isEmpty(tbTabItem.getContentDescription())) {
            z.m(tbTabItem.getContentDescription());
        }
        d(z);
    }

    public int getSelectedTabPosition() {
        f fVar = this.f2422f;
        if (fVar != null) {
            return fVar.e();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f2421e.size();
    }

    public int getTabGravity() {
        return this.x;
    }

    public int getTabMaxWidth() {
        return this.s;
    }

    public int getTabMode() {
        return this.y;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.m;
    }

    public final void h(f fVar) {
        this.f2423g.addView(fVar.j, fVar.e(), p());
    }

    public final void i(View view) {
        if (view instanceof TbTabItem) {
            g((TbTabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only FcTabItem instances can be added to TbTabLayout");
    }

    public final void j(int i2) {
        if (i2 == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.f2423g.b()) {
            int scrollX = getScrollX();
            int l = l(i2, 0.0f);
            if (scrollX != l) {
                v();
                this.C.setIntValues(scrollX, l);
                this.C.start();
            }
            this.f2423g.a(i2, 300);
            return;
        }
        setScrollPosition(i2, 0.0f, true);
    }

    public final void k() {
        ViewCompat.setPaddingRelative(this.f2423g, this.y == 0 ? Math.max(0, this.w - this.f2424h) : 0, 0, 0, 0);
        int i2 = this.y;
        if (i2 == 0) {
            this.f2423g.setGravity(GravityCompat.START);
        } else if (i2 == 1) {
            this.f2423g.setGravity(1);
        }
        L(true);
    }

    public final int l(int i2, float f2) {
        if (this.y == 0) {
            View childAt = this.f2423g.getChildAt(i2);
            int i3 = i2 + 1;
            View childAt2 = i3 < this.f2423g.getChildCount() ? this.f2423g.getChildAt(i3) : null;
            int width = childAt != null ? childAt.getWidth() : 0;
            int width2 = childAt2 != null ? childAt2.getWidth() : 0;
            int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
            int i4 = (int) ((width + width2) * 0.5f * f2);
            return ViewCompat.getLayoutDirection(this) == 0 ? left + i4 : left - i4;
        }
        return 0;
    }

    public final void n(f fVar, int i2) {
        fVar.r(i2);
        this.f2421e.add(i2, fVar);
        int size = this.f2421e.size();
        while (true) {
            i2++;
            if (i2 >= size) {
                return;
            }
            this.f2421e.get(i2).r(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.D == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                I((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.I) {
            setupWithViewPager(null);
            this.I = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
        if (r1.getMeasuredWidth() != getMeasuredWidth()) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
        if (r1.getMeasuredWidth() < getMeasuredWidth()) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0075, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0076, code lost:
        r6 = r0;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i2, int i3) {
        int u = u(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(u, View.MeasureSpec.getSize(i3)), 1073741824);
        } else if (mode == 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(u, 1073741824);
        }
        int size = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i2) != 0) {
            int i4 = this.u;
            if (i4 <= 0) {
                i4 = size - u(56);
            }
            this.s = i4;
        }
        super.onMeasure(i2, i3);
        boolean z = true;
        if (getChildCount() == 1) {
            boolean z2 = false;
            View childAt = getChildAt(0);
            int i5 = this.y;
            if (i5 != 0) {
                if (i5 == 1) {
                }
            }
            if (z2) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), HorizontalScrollView.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    public final LinearLayout.LayoutParams p() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        K(layoutParams);
        return layoutParams;
    }

    public final g q(@NonNull f fVar) {
        Pools.Pool<g> pool = this.K;
        g acquire = pool != null ? pool.acquire() : null;
        if (acquire == null) {
            acquire = new g(getContext());
        }
        acquire.g(fVar);
        acquire.setFocusable(true);
        acquire.setMinimumWidth(getTabMinWidth());
        return acquire;
    }

    public final void r(@NonNull f fVar) {
        for (int size = this.A.size() - 1; size >= 0; size--) {
            this.A.get(size).a(fVar);
        }
    }

    public final void s(@NonNull f fVar) {
        for (int size = this.A.size() - 1; size >= 0; size--) {
            this.A.get(size).e(fVar);
        }
    }

    public void setDisableTabSelect(boolean z) {
        this.J = z;
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable c cVar) {
        c cVar2 = this.z;
        if (cVar2 != null) {
            C(cVar2);
        }
        this.z = cVar;
        if (cVar != null) {
            c(cVar);
        }
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        v();
        this.C.addListener(animatorListener);
    }

    public void setScrollPosition(int i2, float f2, boolean z) {
        H(i2, f2, z, true);
    }

    public void setSelectedIndicatorBottomMargin(int i2) {
        this.f2423g.f(i2);
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i2) {
        this.f2423g.g(i2);
    }

    public void setSelectedTabIndicatorHeight(int i2) {
        this.f2423g.h(i2);
    }

    public void setSelectedTabIndicatorWidth(int i2) {
        this.f2423g.i(i2);
    }

    public void setSelectedTabTextBlod(boolean z) {
        this.q = z;
    }

    public void setSelectedTabTextSize(int i2) {
        this.p = i2;
    }

    public void setTabGravity(int i2) {
        if (this.x != i2) {
            this.x = i2;
            k();
        }
    }

    public void setTabMode(int i2) {
        if (i2 != this.y) {
            this.y = i2;
            k();
        }
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            J();
        }
    }

    public void setTabTextSize(int i2) {
        this.n = i2;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        G(pagerAdapter, false);
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public final void t(@NonNull f fVar) {
        for (int size = this.A.size() - 1; size >= 0; size--) {
            this.A.get(size).c(fVar);
        }
    }

    public int u(int i2) {
        return Math.round(getResources().getDisplayMetrics().density * i2);
    }

    public final void v() {
        if (this.C == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.C = valueAnimator;
            valueAnimator.setInterpolator(N);
            this.C.setDuration(300L);
            this.C.addUpdateListener(new a());
        }
    }

    @Nullable
    public f w(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.f2421e.get(i2);
    }

    public final void x() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            this.L = l.g(getContext(), com.baidu.tieba.R.dimen.tbds2);
        }
    }

    @NonNull
    public f z() {
        f acquire = O.acquire();
        if (acquire == null) {
            acquire = new f();
        }
        acquire.f2453i = this;
        acquire.j = q(acquire);
        return acquire;
    }

    public TbTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        i(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager, boolean z) {
        I(viewPager, z, false);
    }

    public TbTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2421e = new ArrayList<>();
        this.s = Integer.MAX_VALUE;
        this.A = new ArrayList<>();
        this.J = false;
        this.K = new Pools.SimplePool(12);
        m(context);
        setHorizontalScrollBarEnabled(false);
        e eVar = new e(context);
        this.f2423g = eVar;
        super.addView(eVar, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.TabLayout, i2, com.google.android.material.R.style.Widget_Design_TabLayout);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.TbTabLayout);
        this.f2423g.h(obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabIndicatorHeight, 0));
        this.f2423g.i(obtainStyledAttributes2.getDimensionPixelSize(R$styleable.TbTabLayout_tabIndicatorWidth, 0));
        this.f2423g.g(obtainStyledAttributes.getColor(com.google.android.material.R.styleable.TabLayout_tabIndicatorColor, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPadding, 0);
        this.k = dimensionPixelSize;
        this.j = dimensionPixelSize;
        this.f2425i = dimensionPixelSize;
        this.f2424h = dimensionPixelSize;
        this.f2424h = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.f2425i = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPaddingTop, this.f2425i);
        this.j = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPaddingEnd, this.j);
        this.k = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPaddingBottom, this.k);
        int resourceId = obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.TabLayout_tabTextAppearance, com.google.android.material.R.style.TextAppearance_Design_Tab);
        this.l = resourceId;
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(resourceId, R.styleable.TextAppearance);
        try {
            this.n = obtainStyledAttributes3.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
            this.m = obtainStyledAttributes3.getColorStateList(R.styleable.TextAppearance_android_textColor);
            obtainStyledAttributes3.recycle();
            if (obtainStyledAttributes.hasValue(com.google.android.material.R.styleable.TabLayout_tabTextColor)) {
                this.m = obtainStyledAttributes.getColorStateList(com.google.android.material.R.styleable.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(com.google.android.material.R.styleable.TabLayout_tabSelectedTextColor)) {
                this.m = o(this.m.getDefaultColor(), obtainStyledAttributes.getColor(com.google.android.material.R.styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.t = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabMinWidth, -1);
            this.u = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabMaxWidth, -1);
            this.r = obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.TabLayout_tabBackground, 0);
            this.w = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabContentStart, 0);
            this.y = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.TabLayout_tabMode, 1);
            this.x = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.TabLayout_tabGravity, 0);
            obtainStyledAttributes.recycle();
            obtainStyledAttributes2.recycle();
            Resources resources = getResources();
            this.o = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_tab_text_size_2line);
            this.v = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_tab_scrollable_min_width);
            k();
            x();
        } catch (Throwable th) {
            obtainStyledAttributes3.recycle();
            throw th;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        i(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        i(view);
    }

    public void setTabTextColors(int i2, int i3) {
        setTabTextColors(o(i2, i3));
    }
}
