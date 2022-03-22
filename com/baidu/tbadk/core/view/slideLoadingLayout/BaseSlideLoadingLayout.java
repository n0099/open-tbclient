package com.baidu.tbadk.core.view.slideLoadingLayout;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
/* loaded from: classes5.dex */
public abstract class BaseSlideLoadingLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30270b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30271c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<View, f> f30272d;

    /* renamed from: e  reason: collision with root package name */
    public int f30273e;

    /* renamed from: f  reason: collision with root package name */
    public int f30274f;

    /* renamed from: g  reason: collision with root package name */
    public int f30275g;

    /* renamed from: h  reason: collision with root package name */
    public float f30276h;
    public int i;
    public List<c.a.o0.r.l0.q.c> j;
    public FrameLayout k;
    public FrameLayout.LayoutParams l;
    public boolean m;
    public List<c.a.o0.r.l0.q.b> n;
    public ValueAnimator o;
    public int p;
    public ValueAnimator q;
    public int r;
    public List<c.a.o0.r.l0.q.a> s;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f30277b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BaseSlideLoadingLayout f30278c;

        public a(BaseSlideLoadingLayout baseSlideLoadingLayout, f fVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSlideLoadingLayout, fVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30278c = baseSlideLoadingLayout;
            this.a = fVar;
            this.f30277b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.a;
                if (fVar.f30284c <= 0) {
                    fVar.f30284c = this.f30277b.getHeight();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f30279b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BaseSlideLoadingLayout f30280c;

        public b(BaseSlideLoadingLayout baseSlideLoadingLayout, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSlideLoadingLayout, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30280c = baseSlideLoadingLayout;
            this.a = i;
            this.f30279b = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i = this.a - ((int) (this.f30279b * floatValue));
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.f30280c;
                FrameLayout.LayoutParams layoutParams = baseSlideLoadingLayout.l;
                layoutParams.topMargin = i;
                baseSlideLoadingLayout.k.setLayoutParams(layoutParams);
                BaseSlideLoadingLayout baseSlideLoadingLayout2 = this.f30280c;
                baseSlideLoadingLayout2.f30276h = baseSlideLoadingLayout2.q(i);
                BaseSlideLoadingLayout baseSlideLoadingLayout3 = this.f30280c;
                baseSlideLoadingLayout3.i = baseSlideLoadingLayout3.p(baseSlideLoadingLayout3.f30276h);
                BaseSlideLoadingLayout baseSlideLoadingLayout4 = this.f30280c;
                baseSlideLoadingLayout4.D(baseSlideLoadingLayout4.i, this.f30280c.f30276h, floatValue);
                BaseSlideLoadingLayout baseSlideLoadingLayout5 = this.f30280c;
                baseSlideLoadingLayout5.G(baseSlideLoadingLayout5.i, this.f30280c.f30276h);
                for (c.a.o0.r.l0.q.c cVar : this.f30280c.j) {
                    cVar.a(this.f30280c.i, this.f30280c.f30276h);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseSlideLoadingLayout a;

        public c(BaseSlideLoadingLayout baseSlideLoadingLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSlideLoadingLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseSlideLoadingLayout;
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
                for (c.a.o0.r.l0.q.a aVar : this.a.s) {
                    aVar.d(this.a.i, this.a.f30276h);
                }
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.a;
                baseSlideLoadingLayout.B(baseSlideLoadingLayout.i, this.a.f30276h);
                this.a.m = false;
                for (c.a.o0.r.l0.q.b bVar : this.a.n) {
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
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.a;
                baseSlideLoadingLayout.C(baseSlideLoadingLayout.i, this.a.f30276h);
                for (c.a.o0.r.l0.q.a aVar : this.a.s) {
                    aVar.c(this.a.i, this.a.f30276h);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f30281b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BaseSlideLoadingLayout f30282c;

        public d(BaseSlideLoadingLayout baseSlideLoadingLayout, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSlideLoadingLayout, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30282c = baseSlideLoadingLayout;
            this.a = i;
            this.f30281b = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i = this.a - ((int) (this.f30281b * floatValue));
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.f30282c;
                FrameLayout.LayoutParams layoutParams = baseSlideLoadingLayout.l;
                layoutParams.topMargin = i;
                baseSlideLoadingLayout.k.setLayoutParams(layoutParams);
                BaseSlideLoadingLayout baseSlideLoadingLayout2 = this.f30282c;
                baseSlideLoadingLayout2.f30276h = baseSlideLoadingLayout2.q(i);
                BaseSlideLoadingLayout baseSlideLoadingLayout3 = this.f30282c;
                baseSlideLoadingLayout3.i = baseSlideLoadingLayout3.p(baseSlideLoadingLayout3.f30276h);
                BaseSlideLoadingLayout baseSlideLoadingLayout4 = this.f30282c;
                baseSlideLoadingLayout4.A(baseSlideLoadingLayout4.i, this.f30282c.f30276h, floatValue);
                BaseSlideLoadingLayout baseSlideLoadingLayout5 = this.f30282c;
                baseSlideLoadingLayout5.G(baseSlideLoadingLayout5.i, this.f30282c.f30276h);
                for (c.a.o0.r.l0.q.c cVar : this.f30282c.j) {
                    cVar.a(this.f30282c.i, this.f30282c.f30276h);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseSlideLoadingLayout a;

        public e(BaseSlideLoadingLayout baseSlideLoadingLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSlideLoadingLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseSlideLoadingLayout;
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
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.a;
                baseSlideLoadingLayout.y(baseSlideLoadingLayout.i, this.a.f30276h);
                for (c.a.o0.r.l0.q.a aVar : this.a.s) {
                    aVar.a(this.a.i, this.a.f30276h);
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
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.a;
                baseSlideLoadingLayout.z(baseSlideLoadingLayout.i, this.a.f30276h);
                for (c.a.o0.r.l0.q.a aVar : this.a.s) {
                    aVar.b(this.a.i, this.a.f30276h);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f30283b;

        /* renamed from: c  reason: collision with root package name */
        public int f30284c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f30285d;

        /* renamed from: e  reason: collision with root package name */
        public float f30286e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f30287f;

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
            this.f30284c = -1;
            this.f30286e = 1.0f;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public abstract void A(int i, float f2, float f3);

    public abstract void B(int i, float f2);

    public abstract void C(int i, float f2);

    public abstract void D(int i, float f2, float f3);

    public abstract void E(int i, float f2);

    public abstract void F(int i, float f2);

    public void G(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            I(i, f2);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && !this.m && this.f30270b) {
            w();
        }
    }

    public final void I(int i, float f2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) || this.f30272d.isEmpty()) {
            return;
        }
        for (f fVar : this.f30272d.values()) {
            if (fVar != null && (view = fVar.a) != null) {
                if (fVar.f30283b && fVar.f30284c >= 0) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    layoutParams.height = fVar.f30284c + i;
                    view.setLayoutParams(layoutParams);
                }
                if (fVar.f30285d) {
                    float f3 = fVar.f30286e;
                    if (f3 >= 0.0f) {
                        if (fVar.f30287f) {
                            view.setAlpha(f3 + ((1.0f - f3) * f2));
                        } else {
                            view.setAlpha(f3 * (1.0f - f2));
                        }
                    }
                }
            }
        }
    }

    public abstract int getLoadingPointDistance();

    public float getLoadingPointRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? ((this.a + getLoadingPointDistance()) * 1.0f) / getMaxFingerSlideDistance() : invokeV.floatValue;
    }

    public abstract int getLoadingPointToBottomDistance();

    public abstract int getLoadingVewMaxHeight();

    public int getMaxFingerSlideDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a + getLoadingPointDistance() + getLoadingPointToBottomDistance() : invokeV.intValue;
    }

    public void i(c.a.o0.r.l0.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            if (aVar != null) {
                this.s.add(aVar);
                return;
            }
            throw new IllegalArgumentException("Can not add null animationListener");
        }
    }

    public void j(c.a.o0.r.l0.q.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            if (bVar != null) {
                this.n.add(bVar);
                return;
            }
            throw new IllegalArgumentException("Can not add null loadingListener");
        }
    }

    public void k(c.a.o0.r.l0.q.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            if (cVar != null) {
                this.j.add(cVar);
                return;
            }
            throw new IllegalArgumentException("Can not add null scrollListener");
        }
    }

    public f l(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, view)) == null) ? m(view, -1) : (f) invokeL.objValue;
    }

    public f m(View view, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, view, i)) == null) {
            if (view != null) {
                f fVar = this.f30272d.get(view);
                if (fVar == null) {
                    fVar = new f();
                    fVar.a = view;
                    this.f30272d.put(view, fVar);
                }
                fVar.f30283b = true;
                if (i >= 0) {
                    fVar.f30284c = i;
                } else {
                    view.post(new a(this, fVar, view));
                }
                return fVar;
            }
            throw new IllegalArgumentException("Can not add null view as sync view");
        }
        return (f) invokeLI.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.k.bringToFront();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.m) {
            x();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, motionEvent)) == null) {
            if (this.m || !this.f30270b) {
                return false;
            }
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 2) {
                    return false;
                }
                int i = rawY - this.f30274f;
                return this.f30271c && i > 20 && Math.abs(i) > Math.abs(rawX - this.f30273e);
            }
            this.f30273e = rawX;
            this.f30274f = rawY;
            this.f30275g = rawY;
            return false;
        }
        return invokeL.booleanValue;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, motionEvent)) == null) {
            motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2) {
                    r(rawY - this.f30275g);
                }
                this.f30275g = rawY;
                return true;
            }
            s();
            this.f30275g = rawY;
            return true;
        }
        return invokeL.booleanValue;
    }

    public int p(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048599, this, f2)) == null) ? (int) (f2 * getMaxFingerSlideDistance()) : invokeF.intValue;
    }

    public float q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) ? ((i + this.a) * 1.0f) / getMaxFingerSlideDistance() : invokeI.floatValue;
    }

    public final void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            int i2 = this.l.topMargin + i;
            if (i2 > getLoadingPointDistance() + getLoadingPointToBottomDistance()) {
                this.l.topMargin = getLoadingPointDistance() + getLoadingPointToBottomDistance();
            } else {
                int i3 = this.a;
                if (i2 < (-i3)) {
                    this.l.topMargin = -i3;
                } else {
                    this.l.topMargin = i2;
                }
            }
            this.k.setLayoutParams(this.l);
            float q = q(i2);
            this.f30276h = q;
            int p = p(q);
            this.i = p;
            E(p, this.f30276h);
            G(this.i, this.f30276h);
            for (c.a.o0.r.l0.q.c cVar : this.j) {
                cVar.a(this.i, this.f30276h);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || getParent() == null) {
            return;
        }
        getParent().requestDisallowInterceptTouchEvent(z);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            F(p(this.f30276h), this.f30276h);
        }
    }

    public void setEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.f30270b = z;
        }
    }

    public void setEnableSlideLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.f30271c = z;
        }
    }

    public abstract void t(FrameLayout frameLayout);

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f30270b : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.m = true;
            for (c.a.o0.r.l0.q.b bVar : this.n) {
                bVar.onLoadingStart();
            }
            int i = this.l.topMargin;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.q = ofFloat;
            ofFloat.setDuration(this.r);
            this.q.addUpdateListener(new d(this, i, i - getLoadingPointDistance()));
            this.q.addListener(new e(this));
            this.q.start();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            int i = this.l.topMargin;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.o = ofFloat;
            ofFloat.setDuration(this.p);
            this.o.addUpdateListener(new b(this, i, this.a + i));
            this.o.addListener(new c(this));
            this.o.start();
        }
    }

    public abstract void y(int i, float f2);

    public abstract void z(int i, float f2);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseSlideLoadingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseSlideLoadingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseSlideLoadingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f30270b = true;
        this.f30271c = true;
        this.f30272d = new HashMap<>();
        this.j = new LinkedList();
        this.n = new LinkedList();
        this.p = 300;
        this.r = 150;
        this.s = new LinkedList();
        this.k = new FrameLayout(context);
        this.l = new FrameLayout.LayoutParams(-2, -2);
        int loadingVewMaxHeight = getLoadingVewMaxHeight();
        this.a = loadingVewMaxHeight;
        FrameLayout.LayoutParams layoutParams = this.l;
        layoutParams.topMargin = -loadingVewMaxHeight;
        layoutParams.gravity = 49;
        addView(this.k, layoutParams);
        t(this.k);
    }
}
