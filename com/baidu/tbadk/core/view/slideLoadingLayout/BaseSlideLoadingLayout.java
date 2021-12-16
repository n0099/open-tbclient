package com.baidu.tbadk.core.view.slideLoadingLayout;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes11.dex */
public abstract class BaseSlideLoadingLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f41958e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41959f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f41960g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<View, f> f41961h;

    /* renamed from: i  reason: collision with root package name */
    public int f41962i;

    /* renamed from: j  reason: collision with root package name */
    public int f41963j;

    /* renamed from: k  reason: collision with root package name */
    public int f41964k;
    public float l;
    public int m;
    public FrameLayout mLoadingLayout;
    public FrameLayout.LayoutParams mLoadingLayoutParams;
    public List<c.a.r0.s.i0.q.c> n;
    public boolean o;
    public List<c.a.r0.s.i0.q.b> p;
    public ValueAnimator q;
    public int r;
    public ValueAnimator s;
    public int t;
    public List<c.a.r0.s.i0.q.a> u;

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f41965e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f41966f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BaseSlideLoadingLayout f41967g;

        public a(BaseSlideLoadingLayout baseSlideLoadingLayout, f fVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSlideLoadingLayout, fVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41967g = baseSlideLoadingLayout;
            this.f41965e = fVar;
            this.f41966f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f41965e;
                if (fVar.f41977c <= 0) {
                    fVar.f41977c = this.f41966f.getHeight();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f41968e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f41969f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BaseSlideLoadingLayout f41970g;

        public b(BaseSlideLoadingLayout baseSlideLoadingLayout, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSlideLoadingLayout, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41970g = baseSlideLoadingLayout;
            this.f41968e = i2;
            this.f41969f = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i2 = this.f41968e - ((int) (this.f41969f * floatValue));
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.f41970g;
                FrameLayout.LayoutParams layoutParams = baseSlideLoadingLayout.mLoadingLayoutParams;
                layoutParams.topMargin = i2;
                baseSlideLoadingLayout.mLoadingLayout.setLayoutParams(layoutParams);
                BaseSlideLoadingLayout baseSlideLoadingLayout2 = this.f41970g;
                baseSlideLoadingLayout2.l = baseSlideLoadingLayout2.getCurScrollRatioByTopMargin(i2);
                BaseSlideLoadingLayout baseSlideLoadingLayout3 = this.f41970g;
                baseSlideLoadingLayout3.m = baseSlideLoadingLayout3.getCurOffsetYByRatio(baseSlideLoadingLayout3.l);
                BaseSlideLoadingLayout baseSlideLoadingLayout4 = this.f41970g;
                baseSlideLoadingLayout4.onAnimToTopUpdate(baseSlideLoadingLayout4.m, this.f41970g.l, floatValue);
                BaseSlideLoadingLayout baseSlideLoadingLayout5 = this.f41970g;
                baseSlideLoadingLayout5.onScroll(baseSlideLoadingLayout5.m, this.f41970g.l);
                for (c.a.r0.s.i0.q.c cVar : this.f41970g.n) {
                    cVar.a(this.f41970g.m, this.f41970g.l);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseSlideLoadingLayout f41971e;

        public c(BaseSlideLoadingLayout baseSlideLoadingLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSlideLoadingLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41971e = baseSlideLoadingLayout;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                for (c.a.r0.s.i0.q.a aVar : this.f41971e.u) {
                    aVar.d(this.f41971e.m, this.f41971e.l);
                }
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.f41971e;
                baseSlideLoadingLayout.onAnimToTopEnd(baseSlideLoadingLayout.m, this.f41971e.l);
                this.f41971e.o = false;
                for (c.a.r0.s.i0.q.b bVar : this.f41971e.p) {
                    bVar.a();
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.f41971e;
                baseSlideLoadingLayout.onAnimToTopStart(baseSlideLoadingLayout.m, this.f41971e.l);
                for (c.a.r0.s.i0.q.a aVar : this.f41971e.u) {
                    aVar.c(this.f41971e.m, this.f41971e.l);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f41972e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f41973f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BaseSlideLoadingLayout f41974g;

        public d(BaseSlideLoadingLayout baseSlideLoadingLayout, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSlideLoadingLayout, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41974g = baseSlideLoadingLayout;
            this.f41972e = i2;
            this.f41973f = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i2 = this.f41972e - ((int) (this.f41973f * floatValue));
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.f41974g;
                FrameLayout.LayoutParams layoutParams = baseSlideLoadingLayout.mLoadingLayoutParams;
                layoutParams.topMargin = i2;
                baseSlideLoadingLayout.mLoadingLayout.setLayoutParams(layoutParams);
                BaseSlideLoadingLayout baseSlideLoadingLayout2 = this.f41974g;
                baseSlideLoadingLayout2.l = baseSlideLoadingLayout2.getCurScrollRatioByTopMargin(i2);
                BaseSlideLoadingLayout baseSlideLoadingLayout3 = this.f41974g;
                baseSlideLoadingLayout3.m = baseSlideLoadingLayout3.getCurOffsetYByRatio(baseSlideLoadingLayout3.l);
                BaseSlideLoadingLayout baseSlideLoadingLayout4 = this.f41974g;
                baseSlideLoadingLayout4.onAnimToLoadingPointUpdate(baseSlideLoadingLayout4.m, this.f41974g.l, floatValue);
                BaseSlideLoadingLayout baseSlideLoadingLayout5 = this.f41974g;
                baseSlideLoadingLayout5.onScroll(baseSlideLoadingLayout5.m, this.f41974g.l);
                for (c.a.r0.s.i0.q.c cVar : this.f41974g.n) {
                    cVar.a(this.f41974g.m, this.f41974g.l);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseSlideLoadingLayout f41975e;

        public e(BaseSlideLoadingLayout baseSlideLoadingLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSlideLoadingLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41975e = baseSlideLoadingLayout;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.f41975e;
                baseSlideLoadingLayout.onAnimToLoadingPointEnd(baseSlideLoadingLayout.m, this.f41975e.l);
                for (c.a.r0.s.i0.q.a aVar : this.f41975e.u) {
                    aVar.a(this.f41975e.m, this.f41975e.l);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.f41975e;
                baseSlideLoadingLayout.onAnimToLoadingPointStart(baseSlideLoadingLayout.m, this.f41975e.l);
                for (c.a.r0.s.i0.q.a aVar : this.f41975e.u) {
                    aVar.b(this.f41975e.m, this.f41975e.l);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f41976b;

        /* renamed from: c  reason: collision with root package name */
        public int f41977c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f41978d;

        /* renamed from: e  reason: collision with root package name */
        public float f41979e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f41980f;

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
            this.f41977c = -1;
            this.f41979e = 1.0f;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseSlideLoadingLayout(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void addAnimationListener(c.a.r0.s.i0.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (aVar != null) {
                this.u.add(aVar);
                return;
            }
            throw new IllegalArgumentException("Can not add null animationListener");
        }
    }

    public void addLoadingListener(c.a.r0.s.i0.q.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            if (bVar != null) {
                this.p.add(bVar);
                return;
            }
            throw new IllegalArgumentException("Can not add null loadingListener");
        }
    }

    public void addScrollListener(c.a.r0.s.i0.q.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            if (cVar != null) {
                this.n.add(cVar);
                return;
            }
            throw new IllegalArgumentException("Can not add null scrollListener");
        }
    }

    public f addSyncAlphaView(View view, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, view, z)) == null) ? addSyncAlphaView(view, view.getAlpha(), z) : (f) invokeLZ.objValue;
    }

    public f addSyncHeightView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view)) == null) ? addSyncHeightView(view, -1) : (f) invokeL.objValue;
    }

    public void bringLoadViewToFront() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mLoadingLayout.bringToFront();
        }
    }

    public void endLoading() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.o) {
            loadingViewScrollToTop();
        }
    }

    public int getCurOffsetYByRatio(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048585, this, f2)) == null) ? (int) (f2 * getMaxFingerSlideDistance()) : invokeF.intValue;
    }

    public float getCurScrollRatioByTopMargin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? ((i2 + this.f41958e) * 1.0f) / getMaxFingerSlideDistance() : invokeI.floatValue;
    }

    public abstract int getLoadingPointDistance();

    public float getLoadingPointRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? ((this.f41958e + getLoadingPointDistance()) * 1.0f) / getMaxFingerSlideDistance() : invokeV.floatValue;
    }

    public abstract int getLoadingPointToBottomDistance();

    public abstract int getLoadingVewMaxHeight();

    public int getMaxFingerSlideDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f41958e + getLoadingPointDistance() + getLoadingPointToBottomDistance() : invokeV.intValue;
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            int i3 = this.mLoadingLayoutParams.topMargin + i2;
            if (i3 > getLoadingPointDistance() + getLoadingPointToBottomDistance()) {
                this.mLoadingLayoutParams.topMargin = getLoadingPointDistance() + getLoadingPointToBottomDistance();
            } else {
                int i4 = this.f41958e;
                if (i3 < (-i4)) {
                    this.mLoadingLayoutParams.topMargin = -i4;
                } else {
                    this.mLoadingLayoutParams.topMargin = i3;
                }
            }
            this.mLoadingLayout.setLayoutParams(this.mLoadingLayoutParams);
            float curScrollRatioByTopMargin = getCurScrollRatioByTopMargin(i3);
            this.l = curScrollRatioByTopMargin;
            int curOffsetYByRatio = getCurOffsetYByRatio(curScrollRatioByTopMargin);
            this.m = curOffsetYByRatio;
            onFingerDrag(curOffsetYByRatio, this.l);
            onScroll(this.m, this.l);
            for (c.a.r0.s.i0.q.c cVar : this.n) {
                cVar.a(this.m, this.l);
            }
        }
    }

    public abstract void initLoadingView(FrameLayout frameLayout);

    public boolean isEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f41959f : invokeV.booleanValue;
    }

    public boolean isLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            onFingerDragEnd(getCurOffsetYByRatio(this.l), this.l);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.o = true;
            for (c.a.r0.s.i0.q.b bVar : this.p) {
                bVar.onLoadingStart();
            }
            int i2 = this.mLoadingLayoutParams.topMargin;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.s = ofFloat;
            ofFloat.setDuration(this.t);
            this.s.addUpdateListener(new d(this, i2, i2 - getLoadingPointDistance()));
            this.s.addListener(new e(this));
            this.s.start();
        }
    }

    public final void l(int i2, float f2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || this.f41961h.isEmpty()) {
            return;
        }
        for (f fVar : this.f41961h.values()) {
            if (fVar != null && (view = fVar.a) != null) {
                if (fVar.f41976b && fVar.f41977c >= 0) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    layoutParams.height = fVar.f41977c + i2;
                    view.setLayoutParams(layoutParams);
                }
                if (fVar.f41978d) {
                    float f3 = fVar.f41979e;
                    if (f3 >= 0.0f) {
                        if (fVar.f41980f) {
                            view.setAlpha(f3 + ((1.0f - f3) * f2));
                        } else {
                            view.setAlpha(f3 * (1.0f - f2));
                        }
                    }
                }
            }
        }
    }

    public void loadingViewScrollToTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            int i2 = this.mLoadingLayoutParams.topMargin;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.q = ofFloat;
            ofFloat.setDuration(this.r);
            this.q.addUpdateListener(new b(this, i2, this.f41958e + i2));
            this.q.addListener(new c(this));
            this.q.start();
        }
    }

    public abstract void onAnimToLoadingPointEnd(int i2, float f2);

    public abstract void onAnimToLoadingPointStart(int i2, float f2);

    public abstract void onAnimToLoadingPointUpdate(int i2, float f2, float f3);

    public abstract void onAnimToTopEnd(int i2, float f2);

    public abstract void onAnimToTopStart(int i2, float f2);

    public abstract void onAnimToTopUpdate(int i2, float f2, float f3);

    public abstract void onFingerDrag(int i2, float f2);

    public abstract void onFingerDragEnd(int i2, float f2);

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, motionEvent)) == null) {
            if (this.o || !this.f41959f) {
                return false;
            }
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 2) {
                    return false;
                }
                int i2 = rawY - this.f41963j;
                return this.f41960g && i2 > 20 && Math.abs(i2) > Math.abs(rawX - this.f41962i);
            }
            this.f41962i = rawX;
            this.f41963j = rawY;
            this.f41964k = rawY;
            return false;
        }
        return invokeL.booleanValue;
    }

    public void onScroll(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            l(i2, f2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        if (r5 != 3) goto L9;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, motionEvent)) == null) {
            motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2) {
                    i(rawY - this.f41964k);
                }
                this.f41964k = rawY;
                return true;
            }
            j();
            this.f41964k = rawY;
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048611, this, z) == null) || getParent() == null) {
            return;
        }
        getParent().requestDisallowInterceptTouchEvent(z);
    }

    public void setEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.f41959f = z;
        }
    }

    public void setEnableSlideLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.f41960g = z;
        }
    }

    public void startLoading() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && !this.o && this.f41959f) {
            k();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseSlideLoadingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public f addSyncAlphaView(View view, @FloatRange(from = 0.0d, to = 1.0d) float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            if (view != null) {
                f fVar = this.f41961h.get(view);
                if (fVar == null) {
                    fVar = new f();
                    fVar.a = view;
                    this.f41961h.put(view, fVar);
                }
                fVar.f41978d = true;
                fVar.f41979e = f2;
                return fVar;
            }
            throw new IllegalArgumentException("Can not add null view as sync view");
        }
        return (f) invokeCommon.objValue;
    }

    public f addSyncHeightView(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, view, i2)) == null) {
            if (view != null) {
                f fVar = this.f41961h.get(view);
                if (fVar == null) {
                    fVar = new f();
                    fVar.a = view;
                    this.f41961h.put(view, fVar);
                }
                fVar.f41976b = true;
                if (i2 >= 0) {
                    fVar.f41977c = i2;
                } else {
                    view.post(new a(this, fVar, view));
                }
                return fVar;
            }
            throw new IllegalArgumentException("Can not add null view as sync view");
        }
        return (f) invokeLI.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseSlideLoadingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseSlideLoadingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f41959f = true;
        this.f41960g = true;
        this.f41961h = new HashMap<>();
        this.n = new LinkedList();
        this.p = new LinkedList();
        this.r = 300;
        this.t = 150;
        this.u = new LinkedList();
        this.mLoadingLayout = new FrameLayout(context);
        this.mLoadingLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        int loadingVewMaxHeight = getLoadingVewMaxHeight();
        this.f41958e = loadingVewMaxHeight;
        FrameLayout.LayoutParams layoutParams = this.mLoadingLayoutParams;
        layoutParams.topMargin = -loadingVewMaxHeight;
        layoutParams.gravity = 49;
        addView(this.mLoadingLayout, layoutParams);
        initLoadingView(this.mLoadingLayout);
    }
}
