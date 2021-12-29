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
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class TbTabLayout extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Interpolator FAST_OUT_SLOW_IN_INTERPOLATOR;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int[] M;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    public static final Pools.Pool<f> N;
    public transient /* synthetic */ FieldHolder $fh;
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
    public final ArrayList<f> f32440e;

    /* renamed from: f  reason: collision with root package name */
    public f f32441f;

    /* renamed from: g  reason: collision with root package name */
    public final e f32442g;

    /* renamed from: h  reason: collision with root package name */
    public int f32443h;

    /* renamed from: i  reason: collision with root package name */
    public int f32444i;

    /* renamed from: j  reason: collision with root package name */
    public int f32445j;

    /* renamed from: k  reason: collision with root package name */
    public int f32446k;
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

    /* loaded from: classes9.dex */
    public static class TbTabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<TbTabLayout> f32447e;

        /* renamed from: f  reason: collision with root package name */
        public int f32448f;

        /* renamed from: g  reason: collision with root package name */
        public int f32449g;

        public TbTabLayoutOnPageChangeListener(TbTabLayout tbTabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbTabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32447e = new WeakReference<>(tbTabLayout);
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f32449g = 0;
                this.f32448f = 0;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f32448f = this.f32449g;
                this.f32449g = i2;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            TbTabLayout tbTabLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || (tbTabLayout = this.f32447e.get()) == null) {
                return;
            }
            boolean z = false;
            tbTabLayout.x(i2, f2, this.f32449g != 2 || this.f32448f == 1, (this.f32449g == 2 && this.f32448f == 0) ? true : true);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            TbTabLayout tbTabLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (tbTabLayout = this.f32447e.get()) == null || tbTabLayout.getSelectedTabPosition() == i2 || i2 >= tbTabLayout.getTabCount()) {
                return;
            }
            int i3 = this.f32449g;
            tbTabLayout.v(tbTabLayout.getTabAt(i2), i3 == 0 || (i3 == 2 && this.f32448f == 0));
        }
    }

    /* loaded from: classes9.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbTabLayout f32450e;

        public a(TbTabLayout tbTabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbTabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32450e = tbTabLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f32450e.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements ViewPager.OnAdapterChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f32451e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbTabLayout f32452f;

        public b(TbTabLayout tbTabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbTabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32452f = tbTabLayout;
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f32451e = z;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewPager, pagerAdapter, pagerAdapter2) == null) {
                TbTabLayout tbTabLayout = this.f32452f;
                if (tbTabLayout.D == viewPager) {
                    tbTabLayout.w(pagerAdapter2, this.f32451e);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(f fVar);

        void c(f fVar);

        void e(f fVar);
    }

    /* loaded from: classes9.dex */
    public class d extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbTabLayout a;

        public d(TbTabLayout tbTabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbTabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbTabLayout;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.s();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.s();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends LinearLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f32453e;

        /* renamed from: f  reason: collision with root package name */
        public int f32454f;

        /* renamed from: g  reason: collision with root package name */
        public int f32455g;

        /* renamed from: h  reason: collision with root package name */
        public final Paint f32456h;

        /* renamed from: i  reason: collision with root package name */
        public int f32457i;

        /* renamed from: j  reason: collision with root package name */
        public float f32458j;

        /* renamed from: k  reason: collision with root package name */
        public int f32459k;
        public int l;
        public int m;
        public ValueAnimator n;
        public final /* synthetic */ TbTabLayout o;

        /* loaded from: classes9.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f32460e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f32461f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f32462g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ int f32463h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ e f32464i;

            public a(e eVar, int i2, int i3, int i4, int i5) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i6 = newInitContext.flag;
                    if ((i6 & 1) != 0) {
                        int i7 = i6 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f32464i = eVar;
                this.f32460e = i2;
                this.f32461f = i3;
                this.f32462g = i4;
                this.f32463h = i5;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    this.f32464i.d(TbTabLayout.lerp(this.f32460e, this.f32461f, animatedFraction), TbTabLayout.lerp(this.f32462g, this.f32463h, animatedFraction));
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f32465e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f32466f;

            public b(e eVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f32466f = eVar;
                this.f32465e = i2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    e eVar = this.f32466f;
                    eVar.f32457i = this.f32465e;
                    eVar.f32458j = 0.0f;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(TbTabLayout tbTabLayout, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbTabLayout, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.o = tbTabLayout;
            this.f32457i = -1;
            this.f32459k = -1;
            this.l = -1;
            this.m = -1;
            setWillNotDraw(false);
            Paint paint = new Paint();
            this.f32456h = paint;
            paint.setStrokeCap(Paint.Cap.ROUND);
            this.f32456h.setAntiAlias(true);
        }

        public void a(int i2, int i3) {
            int i4;
            int i5;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
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
                if (Math.abs(i2 - this.f32457i) <= 1) {
                    i4 = this.l;
                    i5 = this.m;
                } else {
                    int p = this.o.p(24);
                    i4 = (i2 >= this.f32457i ? !z : z) ? left - p : p + right;
                    i5 = i4;
                }
                if (i4 == left && i5 == right) {
                    return;
                }
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.n = valueAnimator2;
                valueAnimator2.setInterpolator(TbTabLayout.FAST_OUT_SLOW_IN_INTERPOLATOR);
                valueAnimator2.setDuration(i3);
                valueAnimator2.setFloatValues(0.0f, 1.0f);
                valueAnimator2.addUpdateListener(new a(this, i4, left, i5, right));
                valueAnimator2.addListener(new b(this, i2));
                valueAnimator2.start();
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (getChildAt(i2).getWidth() <= 0) {
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public float c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32457i + this.f32458j : invokeV.floatValue;
        }

        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
                if (i2 == this.l && i3 == this.m) {
                    return;
                }
                this.l = i2;
                this.m = i3;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int intrinsicHeight;
            Rect rect;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
                super.draw(canvas);
                int i3 = this.l;
                if (i3 >= 0 && (i2 = this.m) > i3) {
                    int i4 = this.f32455g;
                    int i5 = (i4 <= 0 || i2 - i3 <= i4) ? 0 : ((i2 - i3) - i4) / 2;
                    canvas.drawLine(this.l + i5, (getHeight() - (this.f32453e / 2)) - this.f32454f, this.m - i5, (getHeight() - (this.f32453e / 2)) - this.f32454f, this.f32456h);
                }
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    if (getChildAt(childCount) instanceof g) {
                        g gVar = (g) getChildAt(childCount);
                        if (gVar.f32482k != null) {
                            TextView textView = null;
                            if (gVar.f32477f != null) {
                                textView = gVar.f32477f;
                            } else if (gVar.f32480i != null) {
                                textView = gVar.f32480i;
                            }
                            if (textView != null) {
                                int right = (gVar.getRight() - (gVar.getWidth() - textView.getRight())) - n.f(getContext(), R.dimen.tbds3);
                                int top = (textView.getTop() - (gVar.f32482k.getIntrinsicHeight() / 2)) + n.f(getContext(), R.dimen.tbds10);
                                gVar.f32482k.setBounds(right, top, gVar.f32482k.getIntrinsicWidth() + right, gVar.f32482k.getIntrinsicHeight() + top);
                                gVar.f32482k.draw(canvas);
                                if (!TextUtils.isEmpty(gVar.l)) {
                                    if (gVar.l.equals("...")) {
                                        Drawable drawable = SkinManager.getDrawable(R.drawable.icon_news_white_dot);
                                        int intrinsicWidth = right + (gVar.f32482k.getIntrinsicWidth() / 2);
                                        int intrinsicHeight2 = top + (gVar.f32482k.getIntrinsicHeight() / 2);
                                        int f2 = n.f(getContext(), R.dimen.tbds6);
                                        int f3 = n.f(getContext(), R.dimen.tbds7);
                                        int i6 = f2 / 2;
                                        int i7 = intrinsicWidth - i6;
                                        int i8 = intrinsicHeight2 - i6;
                                        int i9 = intrinsicWidth + i6;
                                        int i10 = intrinsicHeight2 + i6;
                                        drawable.setBounds(i7, i8, i9, i10);
                                        drawable.draw(canvas);
                                        int i11 = i7 - f3;
                                        drawable.setBounds(i11 - f2, i8, i11, i10);
                                        drawable.draw(canvas);
                                        int i12 = i9 + f3;
                                        drawable.setBounds(i12, i8, f2 + i12, i10);
                                        drawable.draw(canvas);
                                    } else {
                                        Paint paint = new Paint(1);
                                        paint.setColor(SkinManager.getColor(R.color.CAM_X0101));
                                        paint.setTextSize(n.f(getContext(), R.dimen.tbfontsize26));
                                        paint.setTextAlign(Paint.Align.CENTER);
                                        paint.setTypeface(Typeface.MONOSPACE);
                                        paint.getTextBounds(gVar.l, 0, gVar.l.length(), new Rect());
                                        canvas.drawText(gVar.l, right + (gVar.f32482k.getIntrinsicWidth() / 2), (intrinsicHeight - ((gVar.f32482k.getIntrinsicHeight() - rect.height()) / 2)) - this.o.L, paint);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        public void e(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
                ValueAnimator valueAnimator = this.n;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.n.cancel();
                }
                this.f32457i = i2;
                this.f32458j = f2;
                j();
            }
        }

        public void f(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f32454f == i2) {
                return;
            }
            this.f32454f = i2;
            ViewCompat.postInvalidateOnAnimation(this);
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.f32456h.getColor() == i2) {
                return;
            }
            this.f32456h.setColor(i2);
            ViewCompat.postInvalidateOnAnimation(this);
        }

        public void h(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.f32453e == i2) {
                return;
            }
            this.f32453e = i2;
            this.f32456h.setStrokeWidth(i2);
            ViewCompat.postInvalidateOnAnimation(this);
        }

        public void i(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || this.f32455g == i2) {
                return;
            }
            this.f32455g = i2;
            ViewCompat.postInvalidateOnAnimation(this);
        }

        public final void j() {
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                View childAt = getChildAt(this.f32457i);
                if (childAt == null || childAt.getWidth() <= 0) {
                    i2 = -1;
                    i3 = -1;
                } else {
                    i2 = childAt.getLeft();
                    i3 = childAt.getRight();
                    if (this.f32458j > 0.0f && this.f32457i < getChildCount() - 1) {
                        View childAt2 = getChildAt(this.f32457i + 1);
                        float left = this.f32458j * childAt2.getLeft();
                        float f2 = this.f32458j;
                        i2 = (int) (left + ((1.0f - f2) * i2));
                        i3 = (int) ((f2 * childAt2.getRight()) + ((1.0f - this.f32458j) * i3));
                    }
                }
                d(i2, i3);
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                super.onLayout(z, i2, i3, i4, i5);
                ValueAnimator valueAnimator = this.n;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.n.cancel();
                    a(this.f32457i, Math.round((1.0f - this.n.getAnimatedFraction()) * ((float) this.n.getDuration())));
                    return;
                }
                j();
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
                super.onMeasure(i2, i3);
                if (View.MeasureSpec.getMode(i2) != 1073741824) {
                    return;
                }
                TbTabLayout tbTabLayout = this.o;
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
                    if (i4 * childCount <= getMeasuredWidth() - (this.o.p(16) * 2)) {
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
                        TbTabLayout tbTabLayout2 = this.o;
                        tbTabLayout2.x = 0;
                        tbTabLayout2.B(false);
                    }
                    if (z) {
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
                super.onRtlPropertiesChanged(i2);
                if (Build.VERSION.SDK_INT >= 23 || this.f32459k == i2) {
                    return;
                }
                requestLayout();
                this.f32459k = i2;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Drawable a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f32467b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f32468c;

        /* renamed from: d  reason: collision with root package name */
        public int f32469d;

        /* renamed from: e  reason: collision with root package name */
        public View f32470e;

        /* renamed from: f  reason: collision with root package name */
        public int f32471f;

        /* renamed from: g  reason: collision with root package name */
        public int f32472g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f32473h;

        /* renamed from: i  reason: collision with root package name */
        public TbTabLayout f32474i;

        /* renamed from: j  reason: collision with root package name */
        public g f32475j;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32469d = -1;
            this.f32472g = 0;
            this.f32473h = false;
        }

        @Nullable
        public CharSequence a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32468c : (CharSequence) invokeV.objValue;
        }

        @Nullable
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32470e : (View) invokeV.objValue;
        }

        @Nullable
        public Drawable c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (Drawable) invokeV.objValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f32471f : invokeV.intValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f32469d : invokeV.intValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f32472g : invokeV.intValue;
        }

        @Nullable
        public CharSequence g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f32467b : (CharSequence) invokeV.objValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                TbTabLayout tbTabLayout = this.f32474i;
                if (tbTabLayout != null) {
                    return tbTabLayout.getSelectedTabPosition() == this.f32469d;
                }
                throw new IllegalArgumentException("Tab not attached to a TbTabLayout");
            }
            return invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f32473h : invokeV.booleanValue;
        }

        public f j(int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                this.f32472g = i2;
                this.f32473h = z;
                t();
                return this;
            }
            return (f) invokeCommon.objValue;
        }

        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.f32474i = null;
                this.f32475j = null;
                this.a = null;
                this.f32467b = null;
                this.f32468c = null;
                this.f32469d = -1;
                this.f32470e = null;
            }
        }

        public void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                TbTabLayout tbTabLayout = this.f32474i;
                if (tbTabLayout != null) {
                    tbTabLayout.u(this);
                    return;
                }
                throw new IllegalArgumentException("Tab not attached to a TbTabLayout");
            }
        }

        @NonNull
        public f m(@Nullable CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, charSequence)) == null) {
                this.f32468c = charSequence;
                t();
                return this;
            }
            return (f) invokeL.objValue;
        }

        @NonNull
        public f n(@LayoutRes int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                o(LayoutInflater.from(this.f32475j.getContext()).inflate(i2, (ViewGroup) this.f32475j, false));
                return this;
            }
            return (f) invokeI.objValue;
        }

        @NonNull
        public f o(@Nullable View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, view)) == null) {
                this.f32470e = view;
                t();
                return this;
            }
            return (f) invokeL.objValue;
        }

        @NonNull
        public f p(@Nullable Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, drawable)) == null) {
                this.a = drawable;
                t();
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f q(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
                this.f32471f = i2;
                return this;
            }
            return (f) invokeI.objValue;
        }

        public void r(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
                this.f32469d = i2;
            }
        }

        @NonNull
        public f s(@Nullable CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, charSequence)) == null) {
                this.f32467b = charSequence;
                t();
                return this;
            }
            return (f) invokeL.objValue;
        }

        public void t() {
            g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (gVar = this.f32475j) == null) {
                return;
            }
            gVar.update();
        }
    }

    /* loaded from: classes9.dex */
    public class g extends LinearLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public f f32476e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f32477f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f32478g;

        /* renamed from: h  reason: collision with root package name */
        public View f32479h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f32480i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f32481j;

        /* renamed from: k  reason: collision with root package name */
        public Drawable f32482k;
        public String l;
        public int m;
        public final /* synthetic */ TbTabLayout n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(TbTabLayout tbTabLayout, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbTabLayout, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = tbTabLayout;
            this.m = 2;
            int i4 = tbTabLayout.r;
            if (i4 != 0) {
                ViewCompat.setBackground(this, AppCompatResources.getDrawable(context, i4));
            }
            ViewCompat.setPaddingRelative(this, tbTabLayout.f32443h, tbTabLayout.f32444i, tbTabLayout.f32445j, tbTabLayout.f32446k);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        public final float e(Layout layout, int i2, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{layout, Integer.valueOf(i2), Float.valueOf(f2)})) == null) ? layout.getLineWidth(i2) * (f2 / layout.getPaint().getTextSize()) : invokeCommon.floatValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                g(null);
                setSelected(false);
            }
        }

        public void g(@Nullable f fVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) || fVar == this.f32476e) {
                return;
            }
            this.f32476e = fVar;
            update();
        }

        public final void h(boolean z) {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (textView = this.f32477f) == null) {
                return;
            }
            if (z) {
                float f2 = this.n.p;
                if (f2 > 0.0f) {
                    textView.setTextSize(0, f2);
                    if (!z && this.n.q) {
                        this.f32477f.setTypeface(Typeface.defaultFromStyle(1));
                        return;
                    } else {
                        this.f32477f.setTypeface(Typeface.defaultFromStyle(0));
                    }
                }
            }
            this.f32477f.setTextSize(0, this.n.n);
            if (!z) {
            }
            this.f32477f.setTypeface(Typeface.defaultFromStyle(0));
        }

        public final void i(@Nullable TextView textView, @Nullable ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, textView, imageView) == null) {
                f fVar = this.f32476e;
                Drawable c2 = fVar != null ? fVar.c() : null;
                f fVar2 = this.f32476e;
                CharSequence g2 = fVar2 != null ? fVar2.g() : null;
                f fVar3 = this.f32476e;
                CharSequence a = fVar3 != null ? fVar3.a() : null;
                f fVar4 = this.f32476e;
                int i2 = 0;
                int f2 = fVar4 != null ? fVar4.f() : 0;
                f fVar5 = this.f32476e;
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
                    imageView.setContentDescription(a);
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
                    textView.setContentDescription(a);
                }
                if (textView != null && z) {
                    if (i3) {
                        if (f2 <= 0) {
                            this.f32482k = SkinManager.getDrawable(R.drawable.icon_news_red_dot);
                            this.l = null;
                        } else if (f2 < 10) {
                            this.f32482k = SkinManager.getDrawable(R.drawable.icon_news_red_dot_one_number);
                            this.l = String.valueOf(f2);
                        } else if (f2 < 100) {
                            this.f32482k = SkinManager.getDrawable(R.drawable.icon_news_red_dot_two_number);
                            this.l = String.valueOf(f2);
                        } else {
                            this.f32482k = SkinManager.getDrawable(R.drawable.icon_news_red_dot_two_number);
                            this.l = "...";
                        }
                        if (this.f32482k == null) {
                            this.f32482k = SkinManager.getDrawable(R.drawable.icon_news_red_dot);
                        }
                    } else {
                        this.f32482k = null;
                    }
                }
                if (imageView != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                    if (z && imageView.getVisibility() == 0) {
                        i2 = this.n.p(8);
                    }
                    if (i2 != marginLayoutParams.bottomMargin) {
                        marginLayoutParams.bottomMargin = i2;
                        imageView.requestLayout();
                    }
                }
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, accessibilityEvent) == null) {
                super.onInitializeAccessibilityEvent(accessibilityEvent);
                accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, accessibilityNodeInfo) == null) {
                super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
                accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            Layout layout;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
                int size = View.MeasureSpec.getSize(i2);
                int mode = View.MeasureSpec.getMode(i2);
                int tabMaxWidth = this.n.getTabMaxWidth();
                if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                    i2 = View.MeasureSpec.makeMeasureSpec(this.n.s, Integer.MIN_VALUE);
                }
                super.onMeasure(i2, i3);
                if (this.f32477f != null) {
                    getResources();
                    float f2 = this.n.n;
                    int i4 = this.m;
                    ImageView imageView = this.f32478g;
                    boolean z = true;
                    if (imageView == null || imageView.getVisibility() != 0) {
                        TextView textView = this.f32477f;
                        if (textView != null && textView.getLineCount() > 1) {
                            f2 = this.n.o;
                        }
                    } else {
                        i4 = 1;
                    }
                    float textSize = this.f32477f.getTextSize();
                    int lineCount = this.f32477f.getLineCount();
                    int maxLines = TextViewCompat.getMaxLines(this.f32477f);
                    int i5 = (f2 > textSize ? 1 : (f2 == textSize ? 0 : -1));
                    if (i5 != 0 || (maxLines >= 0 && i4 != maxLines)) {
                        if (this.n.y == 1 && i5 > 0 && lineCount == 1 && ((layout = this.f32477f.getLayout()) == null || e(layout, 0, f2) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                            z = false;
                        }
                        if (z) {
                            this.f32477f.setMaxLines(i4);
                            super.onMeasure(i2, i3);
                        }
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                boolean performClick = super.performClick();
                if (this.n.J) {
                    return false;
                }
                if (this.f32476e != null) {
                    if (!performClick) {
                        playSoundEffect(0);
                    }
                    this.f32476e.l();
                    return true;
                }
                return performClick;
            }
            return invokeV.booleanValue;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
                boolean z2 = isSelected() != z;
                super.setSelected(z);
                if (z2 && z && Build.VERSION.SDK_INT < 16) {
                    sendAccessibilityEvent(4);
                }
                TextView textView = this.f32477f;
                if (textView != null) {
                    textView.setSelected(z);
                }
                ImageView imageView = this.f32478g;
                if (imageView != null) {
                    imageView.setSelected(z);
                }
                View view = this.f32479h;
                if (view != null) {
                    view.setSelected(z);
                }
                h(z);
            }
        }

        public final void update() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                f fVar = this.f32476e;
                View b2 = fVar != null ? fVar.b() : null;
                if (b2 != null) {
                    ViewParent parent = b2.getParent();
                    if (parent != this) {
                        if (parent != null) {
                            ((ViewGroup) parent).removeView(b2);
                        }
                        addView(b2);
                    }
                    this.f32479h = b2;
                    TextView textView = this.f32477f;
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                    ImageView imageView = this.f32478g;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                        this.f32478g.setImageDrawable(null);
                    }
                    TextView textView2 = (TextView) b2.findViewById(16908308);
                    this.f32480i = textView2;
                    if (textView2 != null) {
                        this.m = TextViewCompat.getMaxLines(textView2);
                    }
                    this.f32481j = (ImageView) b2.findViewById(16908294);
                } else {
                    View view = this.f32479h;
                    if (view != null) {
                        removeView(view);
                        this.f32479h = null;
                    }
                    this.f32480i = null;
                    this.f32481j = null;
                }
                boolean z = false;
                if (this.f32479h == null) {
                    if (this.f32478g == null) {
                        ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(com.google.android.material.R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                        addView(imageView2, 0);
                        this.f32478g = imageView2;
                    }
                    if (this.f32477f == null) {
                        TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(com.google.android.material.R.layout.design_layout_tab_text, (ViewGroup) this, false);
                        addView(textView3);
                        this.f32477f = textView3;
                        this.m = TextViewCompat.getMaxLines(textView3);
                    }
                    TextViewCompat.setTextAppearance(this.f32477f, this.n.l);
                    ColorStateList colorStateList = this.n.m;
                    if (colorStateList != null) {
                        this.f32477f.setTextColor(colorStateList);
                    }
                    i(this.f32477f, this.f32478g);
                } else if (this.f32480i != null || this.f32481j != null) {
                    i(this.f32480i, this.f32481j);
                }
                if (fVar != null && fVar.h()) {
                    z = true;
                }
                setSelected(z);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class h implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final ViewPager f32483e;

        public h(ViewPager viewPager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewPager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32483e = viewPager;
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.c
        public void a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.c
        public void c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            }
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.c
        public void e(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
                this.f32483e.setCurrentItem(fVar.e());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(46726080, "Lcom/baidu/adp/widget/design/TbTabLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(46726080, "Lcom/baidu/adp/widget/design/TbTabLayout;");
                return;
            }
        }
        M = new int[]{androidx.appcompat.R.attr.colorPrimary};
        FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
        N = new Pools.SynchronizedPool(16);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbTabLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void checkAppCompatTheme(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(M);
            boolean z = !obtainStyledAttributes.hasValue(0);
            obtainStyledAttributes.recycle();
            if (z) {
                throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
            }
        }
    }

    private int getDefaultHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            int size = this.f32440e.size();
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    f fVar = this.f32440e.get(i2);
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
        return invokeV.intValue;
    }

    private float getScrollPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? this.f32442g.c() : invokeV.floatValue;
    }

    private int getTabMinWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            int i2 = this.t;
            if (i2 != -1) {
                return i2;
            }
            if (this.y == 0) {
                return this.v;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getTabScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? Math.max(0, ((this.f32442g.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight()) : invokeV.intValue;
    }

    public static ColorStateList j(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65547, null, i2, i3)) == null) ? new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2}) : (ColorStateList) invokeII.objValue;
    }

    public static float lerp(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? f2 + (f4 * (f3 - f2)) : invokeCommon.floatValue;
    }

    public static int lerp(int i2, int i3, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)})) == null) ? i2 + Math.round(f2 * (i3 - i2)) : invokeCommon.intValue;
    }

    private void setSelectedTabView(int i2) {
        int childCount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65550, this, i2) == null) || i2 >= (childCount = this.f32442g.getChildCount())) {
            return;
        }
        int i3 = 0;
        while (i3 < childCount) {
            this.f32442g.getChildAt(i3).setSelected(i3 == i2);
            i3++;
        }
    }

    public final void A(LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, layoutParams) == null) {
            if (this.y == 1 && this.x == 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                return;
            }
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (int i2 = 0; i2 < this.f32442g.getChildCount(); i2++) {
                View childAt = this.f32442g.getChildAt(i2);
                childAt.setMinimumWidth(getTabMinWidth());
                A((LinearLayout.LayoutParams) childAt.getLayoutParams());
                if (z) {
                    childAt.requestLayout();
                }
            }
        }
    }

    public void addOnTabSelectedListener(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || this.A.contains(cVar)) {
            return;
        }
        this.A.add(cVar);
    }

    public void addTab(@NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            addTab(fVar, this.f32440e.isEmpty());
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            e(view);
        }
    }

    public final void c(@NonNull TbTabItem tbTabItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tbTabItem) == null) {
            f newTab = newTab();
            CharSequence charSequence = tbTabItem.f32437e;
            if (charSequence != null) {
                newTab.s(charSequence);
            }
            Drawable drawable = tbTabItem.f32438f;
            if (drawable != null) {
                newTab.p(drawable);
            }
            int i2 = tbTabItem.f32439g;
            if (i2 != 0) {
                newTab.n(i2);
            }
            if (!TextUtils.isEmpty(tbTabItem.getContentDescription())) {
                newTab.m(tbTabItem.getContentDescription());
            }
            addTab(newTab);
        }
    }

    public void clearOnTabSelectedListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.A.clear();
        }
    }

    public final void d(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) {
            this.f32442g.addView(fVar.f32475j, fVar.e(), k());
        }
    }

    public final void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
            if (view instanceof TbTabItem) {
                c((TbTabItem) view);
                return;
            }
            throw new IllegalArgumentException("Only FcTabItem instances can be added to TbTabLayout");
        }
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || i2 == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.f32442g.b()) {
            int scrollX = getScrollX();
            int h2 = h(i2, 0.0f);
            if (scrollX != h2) {
                q();
                this.C.setIntValues(scrollX, h2);
                this.C.start();
            }
            this.f32442g.a(i2, 300);
            return;
        }
        setScrollPosition(i2, 0.0f, true);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ViewCompat.setPaddingRelative(this.f32442g, this.y == 0 ? Math.max(0, this.w - this.f32443h) : 0, 0, 0, 0);
            int i2 = this.y;
            if (i2 == 0) {
                this.f32442g.setGravity(GravityCompat.START);
            } else if (i2 == 1) {
                this.f32442g.setGravity(1);
            }
            B(true);
        }
    }

    public int getSelectedTabPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            f fVar = this.f32441f;
            if (fVar != null) {
                return fVar.e();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Nullable
    public f getTabAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            if (i2 < 0 || i2 >= getTabCount()) {
                return null;
            }
            return this.f32440e.get(i2);
        }
        return (f) invokeI.objValue;
    }

    public int getTabCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f32440e.size() : invokeV.intValue;
    }

    public int getTabGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.x : invokeV.intValue;
    }

    public int getTabMaxWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.s : invokeV.intValue;
    }

    public int getTabMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.y : invokeV.intValue;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.m : (ColorStateList) invokeV.objValue;
    }

    public final int h(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            if (this.y == 0) {
                View childAt = this.f32442g.getChildAt(i2);
                int i3 = i2 + 1;
                View childAt2 = i3 < this.f32442g.getChildCount() ? this.f32442g.getChildAt(i3) : null;
                int width = childAt != null ? childAt.getWidth() : 0;
                int width2 = childAt2 != null ? childAt2.getWidth() : 0;
                int left = ((childAt != null ? childAt.getLeft() : 0) + (width / 2)) - (getWidth() / 2);
                int i4 = (int) ((width + width2) * 0.5f * f2);
                return ViewCompat.getLayoutDirection(this) == 0 ? left + i4 : left - i4;
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public final void i(f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLI(1048603, this, fVar, i2) != null) {
            return;
        }
        fVar.r(i2);
        this.f32440e.add(i2, fVar);
        int size = this.f32440e.size();
        while (true) {
            i2++;
            if (i2 >= size) {
                return;
            }
            this.f32440e.get(i2).r(i2);
        }
    }

    public final LinearLayout.LayoutParams k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            A(layoutParams);
            return layoutParams;
        }
        return (LinearLayout.LayoutParams) invokeV.objValue;
    }

    public final g l(@NonNull f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, fVar)) == null) {
            Pools.Pool<g> pool = this.K;
            g acquire = pool != null ? pool.acquire() : null;
            if (acquire == null) {
                acquire = new g(this, getContext());
            }
            acquire.g(fVar);
            acquire.setFocusable(true);
            acquire.setMinimumWidth(getTabMinWidth());
            return acquire;
        }
        return (g) invokeL.objValue;
    }

    public final void m(@NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, fVar) == null) {
            for (int size = this.A.size() - 1; size >= 0; size--) {
                this.A.get(size).a(fVar);
            }
        }
    }

    public final void n(@NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, fVar) == null) {
            for (int size = this.A.size() - 1; size >= 0; size--) {
                this.A.get(size).e(fVar);
            }
        }
    }

    @NonNull
    public f newTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            f acquire = N.acquire();
            if (acquire == null) {
                acquire = new f();
            }
            acquire.f32474i = this;
            acquire.f32475j = l(acquire);
            return acquire;
        }
        return (f) invokeV.objValue;
    }

    public final void o(@NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, fVar) == null) {
            for (int size = this.A.size() - 1; size >= 0; size--) {
                this.A.get(size).c(fVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onAttachedToWindow();
            if (this.D == null) {
                ViewParent parent = getParent();
                if (parent instanceof ViewPager) {
                    y((ViewPager) parent, true, true);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onDetachedFromWindow();
            if (this.I) {
                setupWithViewPager(null);
                this.I = false;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006b, code lost:
        if (r1.getMeasuredWidth() != getMeasuredWidth()) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0076, code lost:
        if (r1.getMeasuredWidth() < getMeasuredWidth()) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0079, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007a, code lost:
        r6 = r0;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048612, this, i2, i3) == null) {
            int p = p(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
            int mode = View.MeasureSpec.getMode(i3);
            if (mode == Integer.MIN_VALUE) {
                i3 = View.MeasureSpec.makeMeasureSpec(Math.min(p, View.MeasureSpec.getSize(i3)), 1073741824);
            } else if (mode == 0) {
                i3 = View.MeasureSpec.makeMeasureSpec(p, 1073741824);
            }
            int size = View.MeasureSpec.getSize(i2);
            if (View.MeasureSpec.getMode(i2) != 0) {
                int i4 = this.u;
                if (i4 <= 0) {
                    i4 = size - p(56);
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
    }

    public int p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) ? Math.round(getResources().getDisplayMetrics().density * i2) : invokeI.intValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && this.C == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.C = valueAnimator;
            valueAnimator.setInterpolator(FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.C.setDuration(300L);
            this.C.addUpdateListener(new a(this));
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            String str = Build.MODEL;
            if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
                this.L = n.f(getContext(), R.dimen.tbds2);
            }
        }
    }

    public void removeAllTabs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            for (int childCount = this.f32442g.getChildCount() - 1; childCount >= 0; childCount--) {
                t(childCount);
            }
            Iterator<f> it = this.f32440e.iterator();
            while (it.hasNext()) {
                f next = it.next();
                it.remove();
                next.k();
                N.release(next);
            }
            this.f32441f = null;
        }
    }

    public void removeOnTabSelectedListener(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, cVar) == null) {
            this.A.remove(cVar);
        }
    }

    public void removeTab(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, fVar) == null) {
            if (fVar.f32474i == this) {
                removeTabAt(fVar.e());
                return;
            }
            throw new IllegalArgumentException("Tab does not belong to this TbTabLayout.");
        }
    }

    public void removeTabAt(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            f fVar = this.f32441f;
            int e2 = fVar != null ? fVar.e() : 0;
            t(i2);
            f remove = this.f32440e.remove(i2);
            if (remove != null) {
                remove.k();
                N.release(remove);
            }
            int size = this.f32440e.size();
            for (int i3 = i2; i3 < size; i3++) {
                this.f32440e.get(i3).r(i3);
            }
            if (e2 == i2) {
                u(this.f32440e.isEmpty() ? null : this.f32440e.get(Math.max(0, i2 - 1)));
            }
        }
    }

    public void s() {
        int currentItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            removeAllTabs();
            PagerAdapter pagerAdapter = this.E;
            if (pagerAdapter != null) {
                int count = pagerAdapter.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    f newTab = newTab();
                    newTab.s(this.E.getPageTitle(i2));
                    addTab(newTab, false);
                }
                ViewPager viewPager = this.D;
                if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                    return;
                }
                u(getTabAt(currentItem));
            }
        }
    }

    public void setDisableTabSelect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.J = z;
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, cVar) == null) {
            c cVar2 = this.z;
            if (cVar2 != null) {
                removeOnTabSelectedListener(cVar2);
            }
            this.z = cVar;
            if (cVar != null) {
                addOnTabSelectedListener(cVar);
            }
        }
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, animatorListener) == null) {
            q();
            this.C.addListener(animatorListener);
        }
    }

    public void setScrollPosition(int i2, float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            x(i2, f2, z, true);
        }
    }

    public void setSelectedIndicatorBottomMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.f32442g.f(i2);
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            this.f32442g.g(i2);
        }
    }

    public void setSelectedTabIndicatorHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            this.f32442g.h(i2);
        }
    }

    public void setSelectedTabIndicatorWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
            this.f32442g.i(i2);
        }
    }

    public void setSelectedTabTextBlod(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.q = z;
        }
    }

    public void setSelectedTabTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            this.p = i2;
        }
    }

    public void setTabGravity(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048631, this, i2) == null) || this.x == i2) {
            return;
        }
        this.x = i2;
        g();
    }

    public void setTabMode(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048632, this, i2) == null) || i2 == this.y) {
            return;
        }
        this.y = i2;
        g();
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, colorStateList) == null) || this.m == colorStateList) {
            return;
        }
        this.m = colorStateList;
        z();
    }

    public void setTabTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            this.n = i2;
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, pagerAdapter) == null) {
            w(pagerAdapter, false);
        }
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, viewPager) == null) {
            setupWithViewPager(viewPager, true);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? getTabScrollRange() > 0 : invokeV.booleanValue;
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
            g gVar = (g) this.f32442g.getChildAt(i2);
            this.f32442g.removeViewAt(i2);
            if (gVar != null) {
                gVar.f();
                this.K.release(gVar);
            }
            requestLayout();
        }
    }

    public void u(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, fVar) == null) {
            v(fVar, true);
        }
    }

    public void v(f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048642, this, fVar, z) == null) {
            f fVar2 = this.f32441f;
            if (fVar2 == fVar) {
                if (fVar2 != null) {
                    m(fVar);
                    f(fVar.e());
                    return;
                }
                return;
            }
            int e2 = fVar != null ? fVar.e() : -1;
            if (z) {
                if ((fVar2 == null || fVar2.e() == -1) && e2 != -1) {
                    setScrollPosition(e2, 0.0f, true);
                } else {
                    f(e2);
                }
                if (e2 != -1) {
                    setSelectedTabView(e2);
                }
            }
            if (fVar2 != null) {
                o(fVar2);
            }
            this.f32441f = fVar;
            if (fVar != null) {
                n(fVar);
            }
        }
    }

    public void w(@Nullable PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048643, this, pagerAdapter, z) == null) {
            PagerAdapter pagerAdapter2 = this.E;
            if (pagerAdapter2 != null && (dataSetObserver = this.F) != null) {
                pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
            this.E = pagerAdapter;
            if (z && pagerAdapter != null) {
                if (this.F == null) {
                    this.F = new d(this);
                }
                pagerAdapter.registerDataSetObserver(this.F);
            }
            s();
        }
    }

    public void x(int i2, float f2, boolean z, boolean z2) {
        int round;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048644, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (round = Math.round(i2 + f2)) < 0 || round >= this.f32442g.getChildCount()) {
            return;
        }
        if (z2) {
            this.f32442g.e(i2, f2);
        }
        ValueAnimator valueAnimator = this.C;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.C.cancel();
        }
        scrollTo(h(i2, f2), 0);
        if (z) {
            setSelectedTabView(round);
        }
    }

    public final void y(@Nullable ViewPager viewPager, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048645, this, new Object[]{viewPager, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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
                removeOnTabSelectedListener(cVar);
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
                addOnTabSelectedListener(hVar);
                PagerAdapter adapter = viewPager.getAdapter();
                if (adapter != null) {
                    w(adapter, z);
                }
                if (this.H == null) {
                    this.H = new b(this);
                }
                this.H.a(z);
                viewPager.addOnAdapterChangeListener(this.H);
                setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
            } else {
                this.D = null;
                w(null, false);
            }
            this.I = z2;
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            int size = this.f32440e.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f32440e.get(i2).t();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public void addTab(@NonNull f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, fVar, i2) == null) {
            addTab(fVar, i2, this.f32440e.isEmpty());
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, i2) == null) {
            e(view);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, attributeSet)) == null) ? generateDefaultLayoutParams() : (FrameLayout.LayoutParams) invokeL.objValue;
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048638, this, viewPager, z) == null) {
            y(viewPager, z, false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f32440e = new ArrayList<>();
        this.s = Integer.MAX_VALUE;
        this.A = new ArrayList<>();
        this.J = false;
        this.K = new Pools.SimplePool(12);
        checkAppCompatTheme(context);
        setHorizontalScrollBarEnabled(false);
        e eVar = new e(this, context);
        this.f32442g = eVar;
        super.addView(eVar, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.TabLayout, i2, com.google.android.material.R.style.Widget_Design_TabLayout);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.TbTabLayout);
        this.f32442g.h(obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabIndicatorHeight, 0));
        this.f32442g.i(obtainStyledAttributes2.getDimensionPixelSize(R$styleable.TbTabLayout_tabIndicatorWidth, 0));
        this.f32442g.g(obtainStyledAttributes.getColor(com.google.android.material.R.styleable.TabLayout_tabIndicatorColor, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPadding, 0);
        this.f32446k = dimensionPixelSize;
        this.f32445j = dimensionPixelSize;
        this.f32444i = dimensionPixelSize;
        this.f32443h = dimensionPixelSize;
        this.f32443h = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.f32444i = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPaddingTop, this.f32444i);
        this.f32445j = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPaddingEnd, this.f32445j);
        this.f32446k = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPaddingBottom, this.f32446k);
        int resourceId = obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.TabLayout_tabTextAppearance, com.google.android.material.R.style.TextAppearance_Design_Tab);
        this.l = resourceId;
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(resourceId, androidx.appcompat.R.styleable.TextAppearance);
        try {
            this.n = obtainStyledAttributes3.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
            this.m = obtainStyledAttributes3.getColorStateList(androidx.appcompat.R.styleable.TextAppearance_android_textColor);
            obtainStyledAttributes3.recycle();
            if (obtainStyledAttributes.hasValue(com.google.android.material.R.styleable.TabLayout_tabTextColor)) {
                this.m = obtainStyledAttributes.getColorStateList(com.google.android.material.R.styleable.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(com.google.android.material.R.styleable.TabLayout_tabSelectedTextColor)) {
                this.m = j(this.m.getDefaultColor(), obtainStyledAttributes.getColor(com.google.android.material.R.styleable.TabLayout_tabSelectedTextColor, 0));
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
            g();
            r();
        } catch (Throwable th) {
            obtainStyledAttributes3.recycle();
            throw th;
        }
    }

    public void addTab(@NonNull f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, fVar, z) == null) {
            addTab(fVar, this.f32440e.size(), z);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, view, layoutParams) == null) {
            e(view);
        }
    }

    public void addTab(@NonNull f fVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{fVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (fVar.f32474i == this) {
                i(fVar, i2);
                d(fVar);
                if (z) {
                    fVar.l();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Tab belongs to a different TbTabLayout.");
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, view, i2, layoutParams) == null) {
            e(view);
        }
    }

    public void setTabTextColors(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048633, this, i2, i3) == null) {
            setTabTextColors(j(i2, i3));
        }
    }
}
