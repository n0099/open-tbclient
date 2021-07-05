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
/* loaded from: classes4.dex */
public abstract class BaseSlideLoadingLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f12697e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12698f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12699g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<View, f> f12700h;

    /* renamed from: i  reason: collision with root package name */
    public int f12701i;
    public int j;
    public int k;
    public float l;
    public int m;
    public List<d.a.r0.r.f0.p.c> n;
    public FrameLayout o;
    public FrameLayout.LayoutParams p;
    public boolean q;
    public List<d.a.r0.r.f0.p.b> r;
    public ValueAnimator s;
    public int t;
    public ValueAnimator u;
    public int v;
    public List<d.a.r0.r.f0.p.a> w;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f12702e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f12703f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BaseSlideLoadingLayout f12704g;

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
            this.f12704g = baseSlideLoadingLayout;
            this.f12702e = fVar;
            this.f12703f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f12702e;
                if (fVar.f12715c <= 0) {
                    fVar.f12715c = this.f12703f.getHeight();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f12705e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f12706f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BaseSlideLoadingLayout f12707g;

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
            this.f12707g = baseSlideLoadingLayout;
            this.f12705e = i2;
            this.f12706f = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i2 = this.f12705e - ((int) (this.f12706f * floatValue));
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.f12707g;
                FrameLayout.LayoutParams layoutParams = baseSlideLoadingLayout.p;
                layoutParams.topMargin = i2;
                baseSlideLoadingLayout.o.setLayoutParams(layoutParams);
                BaseSlideLoadingLayout baseSlideLoadingLayout2 = this.f12707g;
                baseSlideLoadingLayout2.l = baseSlideLoadingLayout2.q(i2);
                BaseSlideLoadingLayout baseSlideLoadingLayout3 = this.f12707g;
                baseSlideLoadingLayout3.m = baseSlideLoadingLayout3.p(baseSlideLoadingLayout3.l);
                BaseSlideLoadingLayout baseSlideLoadingLayout4 = this.f12707g;
                baseSlideLoadingLayout4.D(baseSlideLoadingLayout4.m, this.f12707g.l, floatValue);
                BaseSlideLoadingLayout baseSlideLoadingLayout5 = this.f12707g;
                baseSlideLoadingLayout5.G(baseSlideLoadingLayout5.m, this.f12707g.l);
                for (d.a.r0.r.f0.p.c cVar : this.f12707g.n) {
                    cVar.a(this.f12707g.m, this.f12707g.l);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseSlideLoadingLayout f12708e;

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
            this.f12708e = baseSlideLoadingLayout;
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
                for (d.a.r0.r.f0.p.a aVar : this.f12708e.w) {
                    aVar.d(this.f12708e.m, this.f12708e.l);
                }
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.f12708e;
                baseSlideLoadingLayout.B(baseSlideLoadingLayout.m, this.f12708e.l);
                this.f12708e.q = false;
                for (d.a.r0.r.f0.p.b bVar : this.f12708e.r) {
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
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.f12708e;
                baseSlideLoadingLayout.C(baseSlideLoadingLayout.m, this.f12708e.l);
                for (d.a.r0.r.f0.p.a aVar : this.f12708e.w) {
                    aVar.c(this.f12708e.m, this.f12708e.l);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f12709e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f12710f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BaseSlideLoadingLayout f12711g;

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
            this.f12711g = baseSlideLoadingLayout;
            this.f12709e = i2;
            this.f12710f = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i2 = this.f12709e - ((int) (this.f12710f * floatValue));
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.f12711g;
                FrameLayout.LayoutParams layoutParams = baseSlideLoadingLayout.p;
                layoutParams.topMargin = i2;
                baseSlideLoadingLayout.o.setLayoutParams(layoutParams);
                BaseSlideLoadingLayout baseSlideLoadingLayout2 = this.f12711g;
                baseSlideLoadingLayout2.l = baseSlideLoadingLayout2.q(i2);
                BaseSlideLoadingLayout baseSlideLoadingLayout3 = this.f12711g;
                baseSlideLoadingLayout3.m = baseSlideLoadingLayout3.p(baseSlideLoadingLayout3.l);
                BaseSlideLoadingLayout baseSlideLoadingLayout4 = this.f12711g;
                baseSlideLoadingLayout4.A(baseSlideLoadingLayout4.m, this.f12711g.l, floatValue);
                BaseSlideLoadingLayout baseSlideLoadingLayout5 = this.f12711g;
                baseSlideLoadingLayout5.G(baseSlideLoadingLayout5.m, this.f12711g.l);
                for (d.a.r0.r.f0.p.c cVar : this.f12711g.n) {
                    cVar.a(this.f12711g.m, this.f12711g.l);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseSlideLoadingLayout f12712e;

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
            this.f12712e = baseSlideLoadingLayout;
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
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.f12712e;
                baseSlideLoadingLayout.y(baseSlideLoadingLayout.m, this.f12712e.l);
                for (d.a.r0.r.f0.p.a aVar : this.f12712e.w) {
                    aVar.a(this.f12712e.m, this.f12712e.l);
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
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.f12712e;
                baseSlideLoadingLayout.z(baseSlideLoadingLayout.m, this.f12712e.l);
                for (d.a.r0.r.f0.p.a aVar : this.f12712e.w) {
                    aVar.b(this.f12712e.m, this.f12712e.l);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f12713a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f12714b;

        /* renamed from: c  reason: collision with root package name */
        public int f12715c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f12716d;

        /* renamed from: e  reason: collision with root package name */
        public float f12717e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f12718f;

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
            this.f12715c = -1;
            this.f12717e = 1.0f;
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

    public abstract void A(int i2, float f2, float f3);

    public abstract void B(int i2, float f2);

    public abstract void C(int i2, float f2);

    public abstract void D(int i2, float f2, float f3);

    public abstract void E(int i2, float f2);

    public abstract void F(int i2, float f2);

    public void G(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            I(i2, f2);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && !this.q && this.f12698f) {
            w();
        }
    }

    public final void I(int i2, float f2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || this.f12700h.isEmpty()) {
            return;
        }
        for (f fVar : this.f12700h.values()) {
            if (fVar != null && (view = fVar.f12713a) != null) {
                if (fVar.f12714b && fVar.f12715c >= 0) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    layoutParams.height = fVar.f12715c + i2;
                    view.setLayoutParams(layoutParams);
                }
                if (fVar.f12716d) {
                    float f3 = fVar.f12717e;
                    if (f3 >= 0.0f) {
                        if (fVar.f12718f) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? ((this.f12697e + getLoadingPointDistance()) * 1.0f) / getMaxFingerSlideDistance() : invokeV.floatValue;
    }

    public abstract int getLoadingPointToBottomDistance();

    public abstract int getLoadingVewMaxHeight();

    public int getMaxFingerSlideDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f12697e + getLoadingPointDistance() + getLoadingPointToBottomDistance() : invokeV.intValue;
    }

    public void i(d.a.r0.r.f0.p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            if (aVar != null) {
                this.w.add(aVar);
                return;
            }
            throw new IllegalArgumentException("Can not add null animationListener");
        }
    }

    public void j(d.a.r0.r.f0.p.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            if (bVar != null) {
                this.r.add(bVar);
                return;
            }
            throw new IllegalArgumentException("Can not add null loadingListener");
        }
    }

    public void k(d.a.r0.r.f0.p.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            if (cVar != null) {
                this.n.add(cVar);
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

    public f m(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, view, i2)) == null) {
            if (view != null) {
                f fVar = this.f12700h.get(view);
                if (fVar == null) {
                    fVar = new f();
                    fVar.f12713a = view;
                    this.f12700h.put(view, fVar);
                }
                fVar.f12714b = true;
                if (i2 >= 0) {
                    fVar.f12715c = i2;
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
            this.o.bringToFront();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.q) {
            x();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, motionEvent)) == null) {
            if (this.q || !this.f12698f) {
                return false;
            }
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 2) {
                    return false;
                }
                int i2 = rawY - this.j;
                return this.f12699g && i2 > 20 && Math.abs(i2) > Math.abs(rawX - this.f12701i);
            }
            this.f12701i = rawX;
            this.j = rawY;
            this.k = rawY;
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
                    r(rawY - this.k);
                }
                this.k = rawY;
                return true;
            }
            s();
            this.k = rawY;
            return true;
        }
        return invokeL.booleanValue;
    }

    public int p(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048599, this, f2)) == null) ? (int) (f2 * getMaxFingerSlideDistance()) : invokeF.intValue;
    }

    public float q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) ? ((i2 + this.f12697e) * 1.0f) / getMaxFingerSlideDistance() : invokeI.floatValue;
    }

    public final void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            int i3 = this.p.topMargin + i2;
            if (i3 > getLoadingPointDistance() + getLoadingPointToBottomDistance()) {
                this.p.topMargin = getLoadingPointDistance() + getLoadingPointToBottomDistance();
            } else {
                int i4 = this.f12697e;
                if (i3 < (-i4)) {
                    this.p.topMargin = -i4;
                } else {
                    this.p.topMargin = i3;
                }
            }
            this.o.setLayoutParams(this.p);
            float q = q(i3);
            this.l = q;
            int p = p(q);
            this.m = p;
            E(p, this.l);
            G(this.m, this.l);
            for (d.a.r0.r.f0.p.c cVar : this.n) {
                cVar.a(this.m, this.l);
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
            F(p(this.l), this.l);
        }
    }

    public void setEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.f12698f = z;
        }
    }

    public void setEnableSlideLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.f12699g = z;
        }
    }

    public abstract void t(FrameLayout frameLayout);

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f12698f : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.q = true;
            for (d.a.r0.r.f0.p.b bVar : this.r) {
                bVar.onLoadingStart();
            }
            int i2 = this.p.topMargin;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.u = ofFloat;
            ofFloat.setDuration(this.v);
            this.u.addUpdateListener(new d(this, i2, i2 - getLoadingPointDistance()));
            this.u.addListener(new e(this));
            this.u.start();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            int i2 = this.p.topMargin;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.s = ofFloat;
            ofFloat.setDuration(this.t);
            this.s.addUpdateListener(new b(this, i2, this.f12697e + i2));
            this.s.addListener(new c(this));
            this.s.start();
        }
    }

    public abstract void y(int i2, float f2);

    public abstract void z(int i2, float f2);

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
        this.f12698f = true;
        this.f12699g = true;
        this.f12700h = new HashMap<>();
        this.n = new LinkedList();
        this.r = new LinkedList();
        this.t = 300;
        this.v = 150;
        this.w = new LinkedList();
        this.o = new FrameLayout(context);
        this.p = new FrameLayout.LayoutParams(-2, -2);
        int loadingVewMaxHeight = getLoadingVewMaxHeight();
        this.f12697e = loadingVewMaxHeight;
        FrameLayout.LayoutParams layoutParams = this.p;
        layoutParams.topMargin = -loadingVewMaxHeight;
        layoutParams.gravity = 49;
        addView(this.o, layoutParams);
        t(this.o);
    }
}
