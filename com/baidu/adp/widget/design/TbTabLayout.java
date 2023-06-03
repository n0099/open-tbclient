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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.m0a;
import com.baidu.tieba.vi;
import com.baidu.tieba.xi;
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
/* loaded from: classes.dex */
public class TbTabLayout extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] I;
    public static final Interpolator J;
    public static final Pools.Pool<f> K;
    public transient /* synthetic */ FieldHolder $fh;
    public PagerAdapter A;
    public DataSetObserver B;
    public TbTabLayoutOnPageChangeListener C;
    public b D;
    public boolean E;
    public boolean F;
    public final Pools.Pool<g> G;
    public int H;
    public final ArrayList<f> a;
    public f b;
    public final e c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public ColorStateList i;
    public float j;
    public float k;
    public float l;
    public boolean m;
    public final int n;
    public int o;
    public final int p;
    public final int q;
    public final int r;
    public int s;
    public int t;
    public int u;
    public c v;
    public final ArrayList<c> w;
    public c x;
    public ValueAnimator y;
    public ViewPager z;

    /* loaded from: classes.dex */
    public interface c {
        void a(f fVar);

        void c(f fVar);

        void e(f fVar);
    }

    /* loaded from: classes.dex */
    public class e extends LinearLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public final Paint d;
        public int e;
        public float f;
        public int g;
        public int h;
        public int i;
        public ValueAnimator j;
        public final /* synthetic */ TbTabLayout k;

        /* loaded from: classes.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ int c;
            public final /* synthetic */ int d;
            public final /* synthetic */ e e;

            public a(e eVar, int i, int i2, int i3, int i4) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = eVar;
                this.a = i;
                this.b = i2;
                this.c = i3;
                this.d = i4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    this.e.d(TbTabLayout.y(this.a, this.b, animatedFraction), TbTabLayout.y(this.c, this.d, animatedFraction));
                }
            }
        }

        /* loaded from: classes.dex */
        public class b extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ e b;

            public b(e eVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = i;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    e eVar = this.b;
                    eVar.e = this.a;
                    eVar.f = 0.0f;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = tbTabLayout;
            this.e = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            setWillNotDraw(false);
            Paint paint = new Paint();
            this.d = paint;
            paint.setStrokeCap(Paint.Cap.ROUND);
            this.d.setAntiAlias(true);
        }

        public void a(int i, int i2) {
            boolean z;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                ValueAnimator valueAnimator = this.j;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.j.cancel();
                }
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                View childAt = getChildAt(i);
                if (childAt == null) {
                    j();
                    return;
                }
                int left = childAt.getLeft();
                int right = childAt.getRight();
                if (Math.abs(i - this.e) <= 1) {
                    i3 = this.h;
                    i4 = this.i;
                } else {
                    int u = this.k.u(24);
                    if (i >= this.e ? z : !z) {
                        i3 = u + right;
                    } else {
                        i3 = left - u;
                    }
                    i4 = i3;
                }
                if (i3 != left || i4 != right) {
                    ValueAnimator valueAnimator2 = new ValueAnimator();
                    this.j = valueAnimator2;
                    valueAnimator2.setInterpolator(TbTabLayout.J);
                    valueAnimator2.setDuration(i2);
                    valueAnimator2.setFloatValues(0.0f, 1.0f);
                    valueAnimator2.addUpdateListener(new a(this, i3, left, i4, right));
                    valueAnimator2.addListener(new b(this, i));
                    valueAnimator2.start();
                }
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (getChildAt(i).getWidth() <= 0) {
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
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.e + this.f;
            }
            return invokeV.floatValue;
        }

        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
                if (i != this.h || i2 != this.i) {
                    this.h = i;
                    this.i = i2;
                    ViewCompat.postInvalidateOnAnimation(this);
                }
            }
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int intrinsicHeight;
            Rect rect;
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
                super.draw(canvas);
                int i3 = this.h;
                if (i3 >= 0 && (i = this.i) > i3) {
                    int i4 = this.c;
                    if (i4 > 0 && i - i3 > i4) {
                        i2 = ((i - i3) - i4) / 2;
                    } else {
                        i2 = 0;
                    }
                    canvas.drawLine(this.h + i2, (getHeight() - (this.a / 2)) - this.b, this.i - i2, (getHeight() - (this.a / 2)) - this.b, this.d);
                }
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    if (getChildAt(childCount) instanceof g) {
                        g gVar = (g) getChildAt(childCount);
                        if (gVar.g != null) {
                            TextView textView = null;
                            if (gVar.b != null) {
                                textView = gVar.b;
                            } else if (gVar.e != null) {
                                textView = gVar.e;
                            }
                            if (textView != null) {
                                int right = (gVar.getRight() - (gVar.getWidth() - textView.getRight())) - vi.g(getContext(), R.dimen.tbds3);
                                int top = (textView.getTop() - (gVar.g.getIntrinsicHeight() / 2)) + vi.g(getContext(), R.dimen.tbds10);
                                gVar.g.setBounds(right, top, gVar.g.getIntrinsicWidth() + right, gVar.g.getIntrinsicHeight() + top);
                                gVar.g.draw(canvas);
                                if (!TextUtils.isEmpty(gVar.h)) {
                                    if (gVar.h.equals("...")) {
                                        Drawable drawable = SkinManager.getDrawable(R.drawable.icon_news_white_dot);
                                        int intrinsicWidth = right + (gVar.g.getIntrinsicWidth() / 2);
                                        int intrinsicHeight2 = top + (gVar.g.getIntrinsicHeight() / 2);
                                        int g = vi.g(getContext(), R.dimen.tbds6);
                                        int g2 = vi.g(getContext(), R.dimen.tbds7);
                                        int i5 = g / 2;
                                        int i6 = intrinsicWidth - i5;
                                        int i7 = intrinsicHeight2 - i5;
                                        int i8 = intrinsicWidth + i5;
                                        int i9 = intrinsicHeight2 + i5;
                                        drawable.setBounds(i6, i7, i8, i9);
                                        drawable.draw(canvas);
                                        int i10 = i6 - g2;
                                        drawable.setBounds(i10 - g, i7, i10, i9);
                                        drawable.draw(canvas);
                                        int i11 = i8 + g2;
                                        drawable.setBounds(i11, i7, g + i11, i9);
                                        drawable.draw(canvas);
                                    } else {
                                        Paint paint = new Paint(1);
                                        paint.setColor(SkinManager.getColor(R.color.CAM_X0101));
                                        paint.setTextSize(vi.g(getContext(), R.dimen.tbfontsize26));
                                        paint.setTextAlign(Paint.Align.CENTER);
                                        paint.setTypeface(Typeface.MONOSPACE);
                                        paint.getTextBounds(gVar.h, 0, gVar.h.length(), new Rect());
                                        canvas.drawText(gVar.h, right + (gVar.g.getIntrinsicWidth() / 2), (intrinsicHeight - ((gVar.g.getIntrinsicHeight() - rect.height()) / 2)) - this.k.H, paint);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        public void e(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
                ValueAnimator valueAnimator = this.j;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.j.cancel();
                }
                this.e = i;
                this.f = f;
                j();
            }
        }

        public void f(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && this.b != i) {
                this.b = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        public void g(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && this.d.getColor() != i) {
                this.d.setColor(i);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        public void h(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && this.a != i) {
                this.a = i;
                this.d.setStrokeWidth(i);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        public void i(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && this.c != i) {
                this.c = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
                super.onRtlPropertiesChanged(i);
                if (Build.VERSION.SDK_INT < 23 && this.g != i) {
                    requestLayout();
                    this.g = i;
                }
            }
        }

        public final void j() {
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                View childAt = getChildAt(this.e);
                if (childAt != null && childAt.getWidth() > 0) {
                    i = childAt.getLeft();
                    i2 = childAt.getRight();
                    if (this.f > 0.0f && this.e < getChildCount() - 1) {
                        View childAt2 = getChildAt(this.e + 1);
                        float left = this.f * childAt2.getLeft();
                        float f = this.f;
                        i = (int) (left + ((1.0f - f) * i));
                        i2 = (int) ((f * childAt2.getRight()) + ((1.0f - this.f) * i2));
                    }
                } else {
                    i = -1;
                    i2 = -1;
                }
                d(i, i2);
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                super.onLayout(z, i, i2, i3, i4);
                ValueAnimator valueAnimator = this.j;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.j.cancel();
                    a(this.e, Math.round((1.0f - this.j.getAnimatedFraction()) * ((float) this.j.getDuration())));
                    return;
                }
                j();
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
                super.onMeasure(i, i2);
                if (View.MeasureSpec.getMode(i) != 1073741824) {
                    return;
                }
                TbTabLayout tbTabLayout = this.k;
                boolean z = true;
                if (tbTabLayout.u == 1 && tbTabLayout.t == 1) {
                    int childCount = getChildCount();
                    int i3 = 0;
                    for (int i4 = 0; i4 < childCount; i4++) {
                        View childAt = getChildAt(i4);
                        if (childAt.getVisibility() == 0) {
                            i3 = Math.max(i3, childAt.getMeasuredWidth());
                        }
                    }
                    if (i3 <= 0) {
                        return;
                    }
                    if (i3 * childCount <= getMeasuredWidth() - (this.k.u(16) * 2)) {
                        boolean z2 = false;
                        for (int i5 = 0; i5 < childCount; i5++) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                            if (layoutParams.width != i3 || layoutParams.weight != 0.0f) {
                                layoutParams.width = i3;
                                layoutParams.weight = 0.0f;
                                z2 = true;
                            }
                        }
                        z = z2;
                    } else {
                        TbTabLayout tbTabLayout2 = this.k;
                        tbTabLayout2.t = 0;
                        tbTabLayout2.L(false);
                    }
                    if (z) {
                        super.onMeasure(i, i2);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class TbTabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<TbTabLayout> a;
        public int b;
        public int c;

        public TbTabLayoutOnPageChangeListener(TbTabLayout tbTabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbTabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(tbTabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            TbTabLayout tbTabLayout;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (tbTabLayout = this.a.get()) != null && tbTabLayout.getSelectedTabPosition() != i && i < tbTabLayout.getTabCount()) {
                int i2 = this.c;
                if (i2 != 0 && (i2 != 2 || this.b != 0)) {
                    z = false;
                } else {
                    z = true;
                }
                tbTabLayout.F(tbTabLayout.w(i), z);
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c = 0;
                this.b = 0;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.b = this.c;
                this.c = i;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            TbTabLayout tbTabLayout;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) && (tbTabLayout = this.a.get()) != null) {
                boolean z2 = false;
                if (this.c == 2 && this.b != 1) {
                    z = false;
                } else {
                    z = true;
                }
                tbTabLayout.H(i, f, z, (this.c == 2 && this.b == 0) ? true : true);
            }
        }
    }

    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbTabLayout a;

        public a(TbTabLayout tbTabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbTabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbTabLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ViewPager.OnAdapterChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ TbTabLayout b;

        public b(TbTabLayout tbTabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbTabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tbTabLayout;
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a = z;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewPager, pagerAdapter, pagerAdapter2) == null) {
                TbTabLayout tbTabLayout = this.b;
                if (tbTabLayout.z == viewPager) {
                    tbTabLayout.G(pagerAdapter2, this.a);
                }
            }
        }
    }

    /* loaded from: classes.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.A();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.A();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Drawable a;
        public CharSequence b;
        public CharSequence c;
        public int d;
        public View e;
        public int f;
        public int g;
        public boolean h;
        public TbTabLayout i;
        public g j;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = -1;
            this.g = 0;
            this.h = false;
        }

        @Nullable
        public CharSequence a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.c;
            }
            return (CharSequence) invokeV.objValue;
        }

        @Nullable
        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.e;
            }
            return (View) invokeV.objValue;
        }

        @Nullable
        public Drawable c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a;
            }
            return (Drawable) invokeV.objValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.f;
            }
            return invokeV.intValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.d;
            }
            return invokeV.intValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.g;
            }
            return invokeV.intValue;
        }

        @Nullable
        public CharSequence g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.b;
            }
            return (CharSequence) invokeV.objValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                TbTabLayout tbTabLayout = this.i;
                if (tbTabLayout != null) {
                    if (tbTabLayout.getSelectedTabPosition() == this.d) {
                        return true;
                    }
                    return false;
                }
                throw new IllegalArgumentException("Tab not attached to a TbTabLayout");
            }
            return invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.h;
            }
            return invokeV.booleanValue;
        }

        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.i = null;
                this.j = null;
                this.a = null;
                this.b = null;
                this.c = null;
                this.d = -1;
                this.e = null;
            }
        }

        public void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                TbTabLayout tbTabLayout = this.i;
                if (tbTabLayout != null) {
                    tbTabLayout.E(this);
                    return;
                }
                throw new IllegalArgumentException("Tab not attached to a TbTabLayout");
            }
        }

        public void t() {
            g gVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (gVar = this.j) != null) {
                gVar.update();
            }
        }

        public f j(int i, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
                this.g = i;
                this.h = z;
                t();
                return this;
            }
            return (f) invokeCommon.objValue;
        }

        @NonNull
        public f m(@Nullable CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, charSequence)) == null) {
                this.c = charSequence;
                t();
                return this;
            }
            return (f) invokeL.objValue;
        }

        @NonNull
        public f n(@LayoutRes int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
                o(LayoutInflater.from(this.j.getContext()).inflate(i, (ViewGroup) this.j, false));
                return this;
            }
            return (f) invokeI.objValue;
        }

        @NonNull
        public f o(@Nullable View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, view2)) == null) {
                this.e = view2;
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

        public f q(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
                this.f = i;
                return this;
            }
            return (f) invokeI.objValue;
        }

        public void r(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
                this.d = i;
            }
        }

        @NonNull
        public f s(@Nullable CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, charSequence)) == null) {
                this.b = charSequence;
                t();
                return this;
            }
            return (f) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class g extends LinearLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public f a;
        public TextView b;
        public ImageView c;
        public View d;
        public TextView e;
        public ImageView f;
        public Drawable g;
        public String h;
        public int i;
        public final /* synthetic */ TbTabLayout j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(TbTabLayout tbTabLayout, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbTabLayout, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = tbTabLayout;
            this.i = 2;
            int i3 = tbTabLayout.n;
            if (i3 != 0) {
                ViewCompat.setBackground(this, AppCompatResources.getDrawable(context, i3));
            }
            ViewCompat.setPaddingRelative(this, tbTabLayout.d, tbTabLayout.e, tbTabLayout.f, tbTabLayout.g);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        public void g(@Nullable f fVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) && fVar != this.a) {
                this.a = fVar;
                update();
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

        public final float e(Layout layout, int i, float f) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{layout, Integer.valueOf(i), Float.valueOf(f)})) == null) {
                return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
            }
            return invokeCommon.floatValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                g(null);
                setSelected(false);
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                boolean performClick = super.performClick();
                if (this.j.F) {
                    return false;
                }
                if (this.a != null) {
                    if (!performClick) {
                        playSoundEffect(0);
                    }
                    this.a.l();
                    return true;
                }
                return performClick;
            }
            return invokeV.booleanValue;
        }

        public final void h(boolean z) {
            TextView textView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (textView = this.b) != null) {
                if (z) {
                    float f = this.j.l;
                    if (f > 0.0f) {
                        textView.setTextSize(0, f);
                        if (!z && this.j.m) {
                            this.b.setTypeface(Typeface.defaultFromStyle(1));
                            return;
                        } else {
                            this.b.setTypeface(Typeface.defaultFromStyle(0));
                        }
                    }
                }
                this.b.setTextSize(0, this.j.j);
                if (!z) {
                }
                this.b.setTypeface(Typeface.defaultFromStyle(0));
            }
        }

        public final void i(@Nullable TextView textView, @Nullable ImageView imageView) {
            Drawable drawable;
            CharSequence charSequence;
            CharSequence charSequence2;
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, textView, imageView) == null) {
                f fVar = this.a;
                if (fVar != null) {
                    drawable = fVar.c();
                } else {
                    drawable = null;
                }
                f fVar2 = this.a;
                if (fVar2 != null) {
                    charSequence = fVar2.g();
                } else {
                    charSequence = null;
                }
                f fVar3 = this.a;
                if (fVar3 != null) {
                    charSequence2 = fVar3.a();
                } else {
                    charSequence2 = null;
                }
                f fVar4 = this.a;
                int i2 = 0;
                if (fVar4 != null) {
                    i = fVar4.f();
                } else {
                    i = 0;
                }
                f fVar5 = this.a;
                if (fVar5 != null) {
                    z = fVar5.i();
                } else {
                    z = false;
                }
                if (imageView != null) {
                    if (drawable != null) {
                        imageView.setImageDrawable(drawable);
                        imageView.setVisibility(0);
                        setVisibility(0);
                    } else {
                        imageView.setVisibility(8);
                        imageView.setImageDrawable(null);
                    }
                    imageView.setContentDescription(charSequence2);
                }
                boolean z2 = !TextUtils.isEmpty(charSequence);
                if (textView != null) {
                    if (z2) {
                        textView.setText(charSequence);
                        textView.setVisibility(0);
                        setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                        textView.setText((CharSequence) null);
                    }
                    textView.setContentDescription(charSequence2);
                }
                if (textView != null && z2) {
                    if (z) {
                        if (i <= 0) {
                            this.g = SkinManager.getDrawable(R.drawable.icon_news_red_dot);
                            this.h = null;
                        } else if (i < 10) {
                            this.g = SkinManager.getDrawable(R.drawable.icon_news_red_dot_one_number);
                            this.h = String.valueOf(i);
                        } else if (i < 100) {
                            this.g = SkinManager.getDrawable(R.drawable.icon_news_red_dot_two_number);
                            this.h = String.valueOf(i);
                        } else {
                            this.g = SkinManager.getDrawable(R.drawable.icon_news_red_dot_two_number);
                            this.h = "...";
                        }
                        if (this.g == null) {
                            this.g = SkinManager.getDrawable(R.drawable.icon_news_red_dot);
                        }
                    } else {
                        this.g = null;
                    }
                }
                if (imageView != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                    if (z2 && imageView.getVisibility() == 0) {
                        i2 = this.j.u(8);
                    }
                    if (i2 != marginLayoutParams.bottomMargin) {
                        marginLayoutParams.bottomMargin = i2;
                        imageView.requestLayout();
                    }
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Layout layout;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
                int size = View.MeasureSpec.getSize(i);
                int mode = View.MeasureSpec.getMode(i);
                int tabMaxWidth = this.j.getTabMaxWidth();
                if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                    i = View.MeasureSpec.makeMeasureSpec(this.j.o, Integer.MIN_VALUE);
                }
                super.onMeasure(i, i2);
                if (this.b != null) {
                    getResources();
                    float f = this.j.j;
                    int i3 = this.i;
                    ImageView imageView = this.c;
                    boolean z = true;
                    if (imageView != null && imageView.getVisibility() == 0) {
                        i3 = 1;
                    } else {
                        TextView textView = this.b;
                        if (textView != null && textView.getLineCount() > 1) {
                            f = this.j.k;
                        }
                    }
                    float textSize = this.b.getTextSize();
                    int lineCount = this.b.getLineCount();
                    int maxLines = TextViewCompat.getMaxLines(this.b);
                    int i4 = (f > textSize ? 1 : (f == textSize ? 0 : -1));
                    if (i4 != 0 || (maxLines >= 0 && i3 != maxLines)) {
                        if (this.j.u == 1 && i4 > 0 && lineCount == 1 && ((layout = this.b.getLayout()) == null || e(layout, 0, f) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                            z = false;
                        }
                        if (z) {
                            this.b.setMaxLines(i3);
                            super.onMeasure(i, i2);
                        }
                    }
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
                if (isSelected() != z) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                super.setSelected(z);
                if (z2 && z && Build.VERSION.SDK_INT < 16) {
                    sendAccessibilityEvent(4);
                }
                TextView textView = this.b;
                if (textView != null) {
                    textView.setSelected(z);
                }
                ImageView imageView = this.c;
                if (imageView != null) {
                    imageView.setSelected(z);
                }
                View view2 = this.d;
                if (view2 != null) {
                    view2.setSelected(z);
                }
                h(z);
            }
        }

        public final void update() {
            View view2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                f fVar = this.a;
                if (fVar != null) {
                    view2 = fVar.b();
                } else {
                    view2 = null;
                }
                if (view2 != null) {
                    ViewParent parent = view2.getParent();
                    if (parent != this) {
                        if (parent != null) {
                            ((ViewGroup) parent).removeView(view2);
                        }
                        addView(view2);
                    }
                    this.d = view2;
                    TextView textView = this.b;
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                    ImageView imageView = this.c;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                        this.c.setImageDrawable(null);
                    }
                    TextView textView2 = (TextView) view2.findViewById(16908308);
                    this.e = textView2;
                    if (textView2 != null) {
                        this.i = TextViewCompat.getMaxLines(textView2);
                    }
                    this.f = (ImageView) view2.findViewById(16908294);
                } else {
                    View view3 = this.d;
                    if (view3 != null) {
                        removeView(view3);
                        this.d = null;
                    }
                    this.e = null;
                    this.f = null;
                }
                boolean z = false;
                if (this.d == null) {
                    if (this.c == null) {
                        ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d024a, (ViewGroup) this, false);
                        addView(imageView2, 0);
                        this.c = imageView2;
                    }
                    if (this.b == null) {
                        TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d024b, (ViewGroup) this, false);
                        addView(textView3);
                        this.b = textView3;
                        this.i = TextViewCompat.getMaxLines(textView3);
                    }
                    TextViewCompat.setTextAppearance(this.b, this.j.h);
                    ColorStateList colorStateList = this.j.i;
                    if (colorStateList != null) {
                        this.b.setTextColor(colorStateList);
                    }
                    i(this.b, this.c);
                } else if (this.e != null || this.f != null) {
                    i(this.e, this.f);
                }
                if (fVar != null && fVar.h()) {
                    z = true;
                }
                setSelected(z);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ViewPager a;

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

        public h(ViewPager viewPager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewPager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewPager;
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.c
        public void e(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
                this.a.setCurrentItem(fVar.e());
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
        I = new int[]{R.attr.obfuscated_res_0x7f04018a};
        J = new FastOutSlowInInterpolator();
        K = new Pools.SynchronizedPool(16);
    }

    private int getDefaultHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            int size = this.a.size();
            boolean z = false;
            int i = 0;
            while (true) {
                if (i < size) {
                    f fVar = this.a.get(i);
                    if (fVar != null && fVar.c() != null && !TextUtils.isEmpty(fVar.g())) {
                        z = true;
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
            if (z) {
                return 72;
            }
            return 48;
        }
        return invokeV.intValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int childCount = this.c.getChildCount() - 1; childCount >= 0; childCount--) {
                D(childCount);
            }
            Iterator<f> it = this.a.iterator();
            while (it.hasNext()) {
                f next = it.next();
                it.remove();
                next.k();
                K.release(next);
            }
            this.b = null;
        }
    }

    public final void k() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (this.u == 0) {
                i = Math.max(0, this.s - this.d);
            } else {
                i = 0;
            }
            ViewCompat.setPaddingRelative(this.c, i, 0, 0, 0);
            int i2 = this.u;
            if (i2 != 0) {
                if (i2 == 1) {
                    this.c.setGravity(1);
                }
            } else {
                this.c.setGravity(GravityCompat.START);
            }
            L(true);
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            for (int i = 0; i < this.c.getChildCount(); i++) {
                View childAt = this.c.getChildAt(i);
                childAt.setMinimumWidth(getTabMinWidth());
                K((LinearLayout.LayoutParams) childAt.getLayoutParams());
                if (z) {
                    childAt.requestLayout();
                }
            }
        }
    }

    public final void g(@NonNull TbTabItem tbTabItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, tbTabItem) == null) {
            f z = z();
            CharSequence charSequence = tbTabItem.a;
            if (charSequence != null) {
                z.s(charSequence);
            }
            Drawable drawable = tbTabItem.b;
            if (drawable != null) {
                z.p(drawable);
            }
            int i = tbTabItem.c;
            if (i != 0) {
                z.n(i);
            }
            if (!TextUtils.isEmpty(tbTabItem.getContentDescription())) {
                z.m(tbTabItem.getContentDescription());
            }
            d(z);
        }
    }

    public final g q(@NonNull f fVar) {
        InterceptResult invokeL;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, fVar)) == null) {
            Pools.Pool<g> pool = this.G;
            if (pool != null) {
                gVar = pool.acquire();
            } else {
                gVar = null;
            }
            if (gVar == null) {
                gVar = new g(this, getContext());
            }
            gVar.g(fVar);
            gVar.setFocusable(true);
            gVar.setMinimumWidth(getTabMinWidth());
            return gVar;
        }
        return (g) invokeL.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public void F(f fVar, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, fVar, z) == null) {
            f fVar2 = this.b;
            if (fVar2 == fVar) {
                if (fVar2 != null) {
                    r(fVar);
                    j(fVar.e());
                    return;
                }
                return;
            }
            if (fVar != null) {
                i = fVar.e();
            } else {
                i = -1;
            }
            if (z) {
                if ((fVar2 == null || fVar2.e() == -1) && i != -1) {
                    setScrollPosition(i, 0.0f, true);
                } else {
                    j(i);
                }
                if (i != -1) {
                    setSelectedTabView(i);
                }
            }
            if (fVar2 != null) {
                t(fVar2);
            }
            this.b = fVar;
            if (fVar != null) {
                s(fVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
        this.o = Integer.MAX_VALUE;
        this.w = new ArrayList<>();
        this.F = false;
        this.G = new Pools.SimplePool(12);
        m(context);
        setHorizontalScrollBarEnabled(false);
        e eVar = new e(this, context);
        this.c = eVar;
        super.addView(eVar, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.TabLayout, i, R.style.obfuscated_res_0x7f10034c);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, m0a.TbTabLayout);
        this.c.h(obtainStyledAttributes.getDimensionPixelSize(12, 0));
        this.c.i(obtainStyledAttributes2.getDimensionPixelSize(0, 0));
        this.c.g(obtainStyledAttributes.getColor(9, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(18, 0);
        this.g = dimensionPixelSize;
        this.f = dimensionPixelSize;
        this.e = dimensionPixelSize;
        this.d = dimensionPixelSize;
        this.d = obtainStyledAttributes.getDimensionPixelSize(21, dimensionPixelSize);
        this.e = obtainStyledAttributes.getDimensionPixelSize(22, this.e);
        this.f = obtainStyledAttributes.getDimensionPixelSize(20, this.f);
        this.g = obtainStyledAttributes.getDimensionPixelSize(19, this.g);
        int resourceId = obtainStyledAttributes.getResourceId(25, R.style.obfuscated_res_0x7f100218);
        this.h = resourceId;
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(resourceId, androidx.appcompat.R.styleable.TextAppearance);
        try {
            this.j = obtainStyledAttributes3.getDimensionPixelSize(0, 0);
            this.i = obtainStyledAttributes3.getColorStateList(3);
            obtainStyledAttributes3.recycle();
            if (obtainStyledAttributes.hasValue(26)) {
                this.i = obtainStyledAttributes.getColorStateList(26);
            }
            if (obtainStyledAttributes.hasValue(24)) {
                this.i = o(this.i.getDefaultColor(), obtainStyledAttributes.getColor(24, 0));
            }
            this.p = obtainStyledAttributes.getDimensionPixelSize(16, -1);
            this.q = obtainStyledAttributes.getDimensionPixelSize(15, -1);
            this.n = obtainStyledAttributes.getResourceId(1, 0);
            this.s = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            this.u = obtainStyledAttributes.getInt(17, 1);
            this.t = obtainStyledAttributes.getInt(4, 0);
            obtainStyledAttributes.recycle();
            obtainStyledAttributes2.recycle();
            Resources resources = getResources();
            this.k = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702cf);
            this.r = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702cd);
            k();
            x();
        } catch (Throwable th) {
            obtainStyledAttributes3.recycle();
            throw th;
        }
    }

    public static void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(I);
            boolean z = !obtainStyledAttributes.hasValue(0);
            obtainStyledAttributes.recycle();
            if (!z) {
                return;
            }
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }

    private void setSelectedTabView(int i) {
        int childCount;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65548, this, i) == null) && i < (childCount = this.c.getChildCount())) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.c.getChildAt(i2);
                if (i2 == i) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
        }
    }

    public void C(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.w.remove(cVar);
        }
    }

    public final void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            g gVar = (g) this.c.getChildAt(i);
            this.c.removeViewAt(i);
            if (gVar != null) {
                gVar.f();
                this.G.release(gVar);
            }
            requestLayout();
        }
    }

    public void E(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            F(fVar, true);
        }
    }

    public final void K(LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, layoutParams) == null) {
            if (this.u == 1 && this.t == 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                return;
            }
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            i(view2);
        }
    }

    public void c(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) && !this.w.contains(cVar)) {
            this.w.add(cVar);
        }
    }

    public void d(@NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, fVar) == null) {
            f(fVar, this.a.isEmpty());
        }
    }

    public final void h(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, fVar) == null) {
            this.c.addView(fVar.j, fVar.e(), p());
        }
    }

    public final void i(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view2) == null) {
            if (view2 instanceof TbTabItem) {
                g((TbTabItem) view2);
                return;
            }
            throw new IllegalArgumentException("Only FcTabItem instances can be added to TbTabLayout");
        }
    }

    public final void r(@NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, fVar) == null) {
            for (int size = this.w.size() - 1; size >= 0; size--) {
                this.w.get(size).a(fVar);
            }
        }
    }

    public final void s(@NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, fVar) == null) {
            for (int size = this.w.size() - 1; size >= 0; size--) {
                this.w.get(size).e(fVar);
            }
        }
    }

    public void setDisableTabSelect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.F = z;
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, cVar) == null) {
            c cVar2 = this.v;
            if (cVar2 != null) {
                C(cVar2);
            }
            this.v = cVar;
            if (cVar != null) {
                c(cVar);
            }
        }
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, animatorListener) == null) {
            v();
            this.y.addListener(animatorListener);
        }
    }

    public void setSelectedIndicatorBottomMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            this.c.f(i);
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.c.g(i);
        }
    }

    public void setSelectedTabIndicatorHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
            this.c.h(i);
        }
    }

    public void setSelectedTabIndicatorWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.c.i(i);
        }
    }

    public void setSelectedTabTextBlod(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.m = z;
        }
    }

    public void setSelectedTabTextSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i) == null) {
            this.l = i;
        }
    }

    public void setTabGravity(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048628, this, i) == null) && this.t != i) {
            this.t = i;
            k();
        }
    }

    public void setTabMode(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048629, this, i) == null) && i != this.u) {
            this.u = i;
            k();
        }
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048631, this, colorStateList) == null) && this.i != colorStateList) {
            this.i = colorStateList;
            J();
        }
    }

    public void setTabTextSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i) == null) {
            this.j = i;
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, pagerAdapter) == null) {
            G(pagerAdapter, false);
        }
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, viewPager) == null) {
            setupWithViewPager(viewPager, true);
        }
    }

    public final void t(@NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, fVar) == null) {
            for (int size = this.w.size() - 1; size >= 0; size--) {
                this.w.get(size).c(fVar);
            }
        }
    }

    public int u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048638, this, i)) == null) {
            return Math.round(getResources().getDisplayMetrics().density * i);
        }
        return invokeI.intValue;
    }

    @Nullable
    public f w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048640, this, i)) == null) {
            if (i >= 0 && i < getTabCount()) {
                return this.a.get(i);
            }
            return null;
        }
        return (f) invokeI.objValue;
    }

    private float getScrollPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            return this.c.c();
        }
        return invokeV.floatValue;
    }

    private int getTabMinWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            int i = this.p;
            if (i != -1) {
                return i;
            }
            if (this.u == 0) {
                return this.r;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getTabScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            return Math.max(0, ((this.c.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
        }
        return invokeV.intValue;
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                this.a.get(i).t();
            }
        }
    }

    public int getSelectedTabPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            f fVar = this.b;
            if (fVar != null) {
                return fVar.e();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int getTabCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.a.size();
        }
        return invokeV.intValue;
    }

    public int getTabGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.t;
        }
        return invokeV.intValue;
    }

    public int getTabMaxWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.o;
        }
        return invokeV.intValue;
    }

    public int getTabMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.u;
        }
        return invokeV.intValue;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.i;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onAttachedToWindow();
            if (this.z == null) {
                ViewParent parent = getParent();
                if (parent instanceof ViewPager) {
                    I((ViewPager) parent, true, true);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onDetachedFromWindow();
            if (this.E) {
                setupWithViewPager(null);
                this.E = false;
            }
        }
    }

    public final LinearLayout.LayoutParams p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            K(layoutParams);
            return layoutParams;
        }
        return (LinearLayout.LayoutParams) invokeV.objValue;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (getTabScrollRange() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048639, this) == null) && this.y == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.y = valueAnimator;
            valueAnimator.setInterpolator(J);
            this.y.setDuration(300L);
            this.y.addUpdateListener(new a(this));
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            String g2 = xi.g();
            if (g2.contains("vivo") && g2.contains("X20")) {
                this.H = vi.g(getContext(), R.dimen.tbds2);
            }
        }
    }

    @NonNull
    public f z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            f acquire = K.acquire();
            if (acquire == null) {
                acquire = new f();
            }
            acquire.i = this;
            acquire.j = q(acquire);
            return acquire;
        }
        return (f) invokeV.objValue;
    }

    public static ColorStateList o(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65547, null, i, i2)) == null) {
            return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i2, i});
        }
        return (ColorStateList) invokeII.objValue;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, view2, i) == null) {
            i(view2);
        }
    }

    public void f(@NonNull f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048595, this, fVar, z) == null) {
            e(fVar, this.a.size(), z);
        }
    }

    public final void n(f fVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048610, this, fVar, i) == null) {
            fVar.r(i);
            this.a.add(i, fVar);
            int size = this.a.size();
            while (true) {
                i++;
                if (i < size) {
                    this.a.get(i).r(i);
                } else {
                    return;
                }
            }
        }
    }

    public void setTabTextColors(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048630, this, i, i2) == null) {
            setTabTextColors(o(i, i2));
        }
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048635, this, viewPager, z) == null) {
            I(viewPager, z, false);
        }
    }

    public static int y(int i, int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            return i + Math.round(f2 * (i2 - i));
        }
        return invokeCommon.intValue;
    }

    public void e(@NonNull f fVar, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{fVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (fVar.i == this) {
                n(fVar, i);
                h(fVar);
                if (z) {
                    fVar.l();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Tab belongs to a different TbTabLayout.");
        }
    }

    public void A() {
        int currentItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            B();
            PagerAdapter pagerAdapter = this.A;
            if (pagerAdapter != null) {
                int count = pagerAdapter.getCount();
                for (int i = 0; i < count; i++) {
                    f z = z();
                    z.s(this.A.getPageTitle(i));
                    f(z, false);
                }
                ViewPager viewPager = this.z;
                if (viewPager != null && count > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                    E(w(currentItem));
                }
            }
        }
    }

    public void G(@Nullable PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, pagerAdapter, z) == null) {
            PagerAdapter pagerAdapter2 = this.A;
            if (pagerAdapter2 != null && (dataSetObserver = this.B) != null) {
                pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
            this.A = pagerAdapter;
            if (z && pagerAdapter != null) {
                if (this.B == null) {
                    this.B = new d(this);
                }
                pagerAdapter.registerDataSetObserver(this.B);
            }
            A();
        }
    }

    public void H(int i, float f2, boolean z, boolean z2) {
        int round;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (round = Math.round(i + f2)) >= 0 && round < this.c.getChildCount()) {
            if (z2) {
                this.c.e(i, f2);
            }
            ValueAnimator valueAnimator = this.y;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.y.cancel();
            }
            scrollTo(l(i, f2), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    public final void I(@Nullable ViewPager viewPager, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{viewPager, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ViewPager viewPager2 = this.z;
            if (viewPager2 != null) {
                TbTabLayoutOnPageChangeListener tbTabLayoutOnPageChangeListener = this.C;
                if (tbTabLayoutOnPageChangeListener != null) {
                    viewPager2.removeOnPageChangeListener(tbTabLayoutOnPageChangeListener);
                }
                b bVar = this.D;
                if (bVar != null) {
                    this.z.removeOnAdapterChangeListener(bVar);
                }
            }
            c cVar = this.x;
            if (cVar != null) {
                C(cVar);
                this.x = null;
            }
            if (viewPager != null) {
                this.z = viewPager;
                if (this.C == null) {
                    this.C = new TbTabLayoutOnPageChangeListener(this);
                }
                this.C.a();
                viewPager.addOnPageChangeListener(this.C);
                h hVar = new h(viewPager);
                this.x = hVar;
                c(hVar);
                PagerAdapter adapter = viewPager.getAdapter();
                if (adapter != null) {
                    G(adapter, z);
                }
                if (this.D == null) {
                    this.D = new b(this);
                }
                this.D.a(z);
                viewPager.addOnAdapterChangeListener(this.D);
                setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
            } else {
                this.z = null;
                G(null, false);
            }
            this.E = z2;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048590, this, view2, i, layoutParams) == null) {
            i(view2);
        }
    }

    public void setScrollPosition(int i, float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            H(i, f2, z, true);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, view2, layoutParams) == null) {
            i(view2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, attributeSet)) == null) {
            return generateDefaultLayoutParams();
        }
        return (FrameLayout.LayoutParams) invokeL.objValue;
    }

    public final void j(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048607, this, i) != null) || i == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.c.b()) {
            int scrollX = getScrollX();
            int l = l(i, 0.0f);
            if (scrollX != l) {
                v();
                this.y.setIntValues(scrollX, l);
                this.y.start();
            }
            this.c.a(i, 300);
            return;
        }
        setScrollPosition(i, 0.0f, true);
    }

    public final int l(int i, float f2) {
        InterceptResult invokeCommon;
        View view2;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)})) == null) {
            int i4 = 0;
            if (this.u != 0) {
                return 0;
            }
            View childAt = this.c.getChildAt(i);
            int i5 = i + 1;
            if (i5 < this.c.getChildCount()) {
                view2 = this.c.getChildAt(i5);
            } else {
                view2 = null;
            }
            if (childAt != null) {
                i2 = childAt.getWidth();
            } else {
                i2 = 0;
            }
            if (view2 != null) {
                i3 = view2.getWidth();
            } else {
                i3 = 0;
            }
            if (childAt != null) {
                i4 = childAt.getLeft();
            }
            int width = (i4 + (i2 / 2)) - (getWidth() / 2);
            int i6 = (int) ((i2 + i3) * 0.5f * f2);
            if (ViewCompat.getLayoutDirection(this) == 0) {
                return width + i6;
            }
            return width - i6;
        }
        return invokeCommon.intValue;
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
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048613, this, i, i2) == null) {
            int u = u(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
            int mode = View.MeasureSpec.getMode(i2);
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    i2 = View.MeasureSpec.makeMeasureSpec(u, 1073741824);
                }
            } else {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.min(u, View.MeasureSpec.getSize(i2)), 1073741824);
            }
            int size = View.MeasureSpec.getSize(i);
            if (View.MeasureSpec.getMode(i) != 0) {
                int i3 = this.q;
                if (i3 <= 0) {
                    i3 = size - u(56);
                }
                this.o = i3;
            }
            super.onMeasure(i, i2);
            boolean z = true;
            if (getChildCount() == 1) {
                boolean z2 = false;
                View childAt = getChildAt(0);
                int i4 = this.u;
                if (i4 != 0) {
                    if (i4 == 1) {
                    }
                }
                if (z2) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), HorizontalScrollView.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
                }
            }
        }
    }
}
