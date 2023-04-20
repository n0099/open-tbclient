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
import com.baidu.tieba.b65;
import com.baidu.tieba.c65;
import com.baidu.tieba.d65;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class BaseSlideLoadingLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public boolean c;
    public HashMap<View, f> d;
    public int e;
    public int f;
    public int g;
    public float h;
    public int i;
    public List<d65> j;
    public FrameLayout k;
    public FrameLayout.LayoutParams l;
    public boolean m;
    public List<c65> n;
    public ValueAnimator o;
    public int p;
    public ValueAnimator q;
    public int r;
    public List<b65> s;

    public abstract void A(int i, float f2, float f3);

    public abstract void B(int i, float f2);

    public abstract void C(int i, float f2);

    public abstract void D(int i, float f2, float f3);

    public abstract void E(int i, float f2);

    public abstract void F(int i, float f2);

    public abstract int getLoadingPointDistance();

    public abstract int getLoadingPointToBottomDistance();

    public abstract int getLoadingVewMaxHeight();

    public abstract void t(FrameLayout frameLayout);

    public abstract void y(int i, float f2);

    public abstract void z(int i, float f2);

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;
        public final /* synthetic */ View b;
        public final /* synthetic */ BaseSlideLoadingLayout c;

        public a(BaseSlideLoadingLayout baseSlideLoadingLayout, f fVar, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseSlideLoadingLayout, fVar, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = baseSlideLoadingLayout;
            this.a = fVar;
            this.b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c <= 0) {
                int height = this.b.getHeight();
                if (height <= 0 && this.b.getLayoutParams() != null) {
                    height = this.b.getLayoutParams().height;
                }
                this.a.c = height;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ BaseSlideLoadingLayout c;

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
            this.c = baseSlideLoadingLayout;
            this.a = i;
            this.b = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i = this.a - ((int) (this.b * floatValue));
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.c;
                FrameLayout.LayoutParams layoutParams = baseSlideLoadingLayout.l;
                layoutParams.topMargin = i;
                baseSlideLoadingLayout.k.setLayoutParams(layoutParams);
                BaseSlideLoadingLayout baseSlideLoadingLayout2 = this.c;
                baseSlideLoadingLayout2.h = baseSlideLoadingLayout2.q(i);
                BaseSlideLoadingLayout baseSlideLoadingLayout3 = this.c;
                baseSlideLoadingLayout3.i = baseSlideLoadingLayout3.p(baseSlideLoadingLayout3.h);
                BaseSlideLoadingLayout baseSlideLoadingLayout4 = this.c;
                baseSlideLoadingLayout4.D(baseSlideLoadingLayout4.i, this.c.h, floatValue);
                BaseSlideLoadingLayout baseSlideLoadingLayout5 = this.c;
                baseSlideLoadingLayout5.G(baseSlideLoadingLayout5.i, this.c.h);
                for (d65 d65Var : this.c.j) {
                    d65Var.a(this.c.i, this.c.h);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseSlideLoadingLayout a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

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
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                for (b65 b65Var : this.a.s) {
                    b65Var.d(this.a.i, this.a.h);
                }
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.a;
                baseSlideLoadingLayout.B(baseSlideLoadingLayout.i, this.a.h);
                this.a.m = false;
                for (c65 c65Var : this.a.n) {
                    c65Var.a();
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.a;
                baseSlideLoadingLayout.C(baseSlideLoadingLayout.i, this.a.h);
                for (b65 b65Var : this.a.s) {
                    b65Var.c(this.a.i, this.a.h);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ BaseSlideLoadingLayout c;

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
            this.c = baseSlideLoadingLayout;
            this.a = i;
            this.b = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i = this.a - ((int) (this.b * floatValue));
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.c;
                FrameLayout.LayoutParams layoutParams = baseSlideLoadingLayout.l;
                layoutParams.topMargin = i;
                baseSlideLoadingLayout.k.setLayoutParams(layoutParams);
                BaseSlideLoadingLayout baseSlideLoadingLayout2 = this.c;
                baseSlideLoadingLayout2.h = baseSlideLoadingLayout2.q(i);
                BaseSlideLoadingLayout baseSlideLoadingLayout3 = this.c;
                baseSlideLoadingLayout3.i = baseSlideLoadingLayout3.p(baseSlideLoadingLayout3.h);
                BaseSlideLoadingLayout baseSlideLoadingLayout4 = this.c;
                baseSlideLoadingLayout4.A(baseSlideLoadingLayout4.i, this.c.h, floatValue);
                BaseSlideLoadingLayout baseSlideLoadingLayout5 = this.c;
                baseSlideLoadingLayout5.G(baseSlideLoadingLayout5.i, this.c.h);
                for (d65 d65Var : this.c.j) {
                    d65Var.a(this.c.i, this.c.h);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseSlideLoadingLayout a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

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
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.a;
                baseSlideLoadingLayout.y(baseSlideLoadingLayout.i, this.a.h);
                for (b65 b65Var : this.a.s) {
                    b65Var.a(this.a.i, this.a.h);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                BaseSlideLoadingLayout baseSlideLoadingLayout = this.a;
                baseSlideLoadingLayout.z(baseSlideLoadingLayout.i, this.a.h);
                for (b65 b65Var : this.a.s) {
                    b65Var.b(this.a.i, this.a.h);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public boolean b;
        public int c;
        public boolean d;
        public float e;
        public boolean f;

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
            this.c = -1;
            this.e = 1.0f;
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
                    r(rawY - this.g);
                }
                this.g = rawY;
                return true;
            }
            s();
            this.g = rawY;
            return true;
        }
        return invokeL.booleanValue;
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
        this.b = true;
        this.c = true;
        this.d = new HashMap<>();
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

    public void i(b65 b65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, b65Var) == null) {
            if (b65Var != null) {
                this.s.add(b65Var);
                return;
            }
            throw new IllegalArgumentException("Can not add null animationListener");
        }
    }

    public void j(c65 c65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, c65Var) == null) {
            if (c65Var != null) {
                this.n.add(c65Var);
                return;
            }
            throw new IllegalArgumentException("Can not add null loadingListener");
        }
    }

    public void k(d65 d65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, d65Var) == null) {
            if (d65Var != null) {
                this.j.add(d65Var);
                return;
            }
            throw new IllegalArgumentException("Can not add null scrollListener");
        }
    }

    public f l(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, view2)) == null) {
            return m(view2, -1);
        }
        return (f) invokeL.objValue;
    }

    public int p(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048599, this, f2)) == null) {
            return (int) (f2 * getMaxFingerSlideDistance());
        }
        return invokeF.intValue;
    }

    public float q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            return ((i + this.a) * 1.0f) / getMaxFingerSlideDistance();
        }
        return invokeI.floatValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048602, this, z) == null) && getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.b = z;
        }
    }

    public void setEnableSlideLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.c = z;
        }
    }

    public void G(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            I(i, f2);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && !this.m && this.b) {
            w();
        }
    }

    public float getLoadingPointRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return ((this.a + getLoadingPointDistance()) * 1.0f) / getMaxFingerSlideDistance();
        }
        return invokeV.floatValue;
    }

    public int getMaxFingerSlideDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.a + getLoadingPointDistance() + getLoadingPointToBottomDistance();
        }
        return invokeV.intValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.k.bringToFront();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || !this.m) {
            return;
        }
        x();
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            F(p(this.h), this.h);
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public final void I(int i, float f2) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) && !this.d.isEmpty()) {
            for (f fVar : this.d.values()) {
                if (fVar != null && (view2 = fVar.a) != null) {
                    if (fVar.b && fVar.c >= 0) {
                        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                        layoutParams.height = fVar.c + i;
                        view2.setLayoutParams(layoutParams);
                    }
                    if (fVar.d) {
                        float f3 = fVar.e;
                        if (f3 >= 0.0f) {
                            if (fVar.f) {
                                view2.setAlpha(f3 + ((1.0f - f3) * f2));
                            } else {
                                view2.setAlpha(f3 * (1.0f - f2));
                            }
                        }
                    }
                }
            }
        }
    }

    public f m(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, view2, i)) == null) {
            if (view2 != null) {
                f fVar = this.d.get(view2);
                if (fVar == null) {
                    fVar = new f();
                    fVar.a = view2;
                    this.d.put(view2, fVar);
                }
                fVar.b = true;
                if (i >= 0) {
                    fVar.c = i;
                } else {
                    view2.post(new a(this, fVar, view2));
                }
                return fVar;
            }
            throw new IllegalArgumentException("Can not add null view as sync view");
        }
        return (f) invokeLI.objValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, motionEvent)) == null) {
            if (this.m || !this.b) {
                return false;
            }
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 2) {
                    return false;
                }
                int i = rawY - this.f;
                int i2 = rawX - this.e;
                if (!this.c || i <= 20 || Math.abs(i) <= Math.abs(i2)) {
                    return false;
                }
                return true;
            }
            this.e = rawX;
            this.f = rawY;
            this.g = rawY;
            return false;
        }
        return invokeL.booleanValue;
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
            this.h = q;
            int p = p(q);
            this.i = p;
            E(p, this.h);
            G(this.i, this.h);
            for (d65 d65Var : this.j) {
                d65Var.a(this.i, this.h);
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.m = true;
            for (c65 c65Var : this.n) {
                c65Var.onLoadingStart();
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
}
