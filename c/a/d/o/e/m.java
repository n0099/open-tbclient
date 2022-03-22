package c.a.d.o.e;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.o0.r.r.n0;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
/* loaded from: classes.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public j f2629b;

    /* renamed from: c  reason: collision with root package name */
    public int f2630c;

    /* renamed from: d  reason: collision with root package name */
    public SparseIntArray f2631d;

    /* renamed from: e  reason: collision with root package name */
    public int f2632e;

    /* renamed from: f  reason: collision with root package name */
    public float f2633f;

    /* renamed from: g  reason: collision with root package name */
    public float f2634g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2635h;
    public SparseArray<ValueAnimator> i;
    public SparseIntArray j;
    public LinearLayoutManager k;
    public HashSet<Integer> l;
    public HashSet<Integer> m;

    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f2636b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m f2637c;

        public a(m mVar, View view, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, view, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2637c = mVar;
            this.a = view;
            this.f2636b = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f2637c.r(this.a, this.f2636b, ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f2638b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f2639c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ m f2640d;

        public b(m mVar, int i, View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, Integer.valueOf(i), view, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2640d = mVar;
            this.a = i;
            this.f2638b = view;
            this.f2639c = i2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f2640d.i.delete(this.a);
                this.f2640d.j.delete(this.a);
                this.f2640d.r(this.f2638b, this.f2639c, 0.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f2640d.i.delete(this.a);
                this.f2640d.j.delete(this.a);
                this.f2640d.f2631d.delete(this.a);
                this.f2640d.r(this.f2638b, this.f2639c, 0.0f);
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
            }
        }
    }

    public m(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2635h = false;
        this.l = new HashSet<>();
        this.m = new HashSet<>();
        this.f2629b = jVar;
        this.f2631d = new SparseIntArray();
        this.i = new SparseArray<>();
        this.j = new SparseIntArray();
    }

    public void e(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, bdTypeRecyclerView, i) == null) {
            this.a = bdTypeRecyclerView;
            this.f2630c = i;
            if (bdTypeRecyclerView == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
                return;
            }
            this.k = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public final float f(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return i(this.a.getChildAt(g(i + 1, i2, true)));
            }
            return i(this.a.getChildAt(g(i - 1, i2, false)));
        }
        return invokeCommon.floatValue;
    }

    public final int g(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int i3 = 1;
            if (!z) {
                while (i3 < i2) {
                    int i4 = i2 - i3;
                    if (i == h(i4)) {
                        return i4;
                    }
                    i3++;
                }
                return -1;
            }
            int count = this.a.getCount() - i2;
            while (i3 < count) {
                int i5 = i2 + i3;
                if (i == h(i5)) {
                    return i5;
                }
                i3++;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public final int h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i > 0) {
                n C = this.a.C(i - this.a.getHeaderViewsCount());
                if (C instanceof BaseCardInfo) {
                    return ((BaseCardInfo) C).position;
                }
                if (C instanceof n0) {
                    return ((n0) C).h();
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final float i(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            if (view == null) {
                return 0.0f;
            }
            return this.f2630c == 2 ? view.getTranslationY() : view.getTranslationX();
        }
        return invokeL.floatValue;
    }

    public final boolean j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i > 0) {
                return c.a.o0.c1.f.p(this.a.C(i - this.a.getHeaderViewsCount()));
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void k(View view) {
        BdTypeRecyclerView bdTypeRecyclerView;
        int childAdapterPosition;
        int h2;
        BdTypeRecyclerView bdTypeRecyclerView2;
        float f2;
        BdTypeRecyclerView bdTypeRecyclerView3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view) == null) || (bdTypeRecyclerView = this.a) == null || this.k == null || this.f2632e == 0 || (h2 = h((childAdapterPosition = bdTypeRecyclerView.getChildAdapterPosition(view)))) < 0) {
            return;
        }
        if (childAdapterPosition <= this.k.findFirstVisibleItemPosition()) {
            float i = this.a.getChildAt(1) != null ? i(this.a.getChildAt(1)) : 0.0f;
            int h3 = h(childAdapterPosition + 1);
            if (h3 < 0) {
                return;
            }
            if (h3 == h2) {
                if (!j(childAdapterPosition)) {
                    s(view, i);
                }
            } else {
                float f3 = -this.f2631d.get(h2, 0);
                if (f3 != 0.0f) {
                    this.f2633f = f3;
                } else {
                    f3 = this.f2633f;
                }
                if (!j(childAdapterPosition)) {
                    s(view, f3 + i);
                }
            }
        } else {
            if (this.a.getChildAt(bdTypeRecyclerView2.getChildCount() - 2) != null) {
                f2 = i(this.a.getChildAt(bdTypeRecyclerView3.getChildCount() - 2));
            } else {
                f2 = 0.0f;
            }
            int h4 = h(childAdapterPosition - 1);
            if (h4 < 0) {
                return;
            }
            if (h4 == h2) {
                if (!j(childAdapterPosition)) {
                    s(view, f2);
                }
            } else {
                float f4 = -this.f2631d.get(h2, 0);
                if (f4 != 0.0f) {
                    this.f2634g = f4;
                } else {
                    f4 = this.f2634g;
                }
                if (!j(childAdapterPosition)) {
                    s(view, f4 + f2);
                }
            }
        }
        n(view, childAdapterPosition);
    }

    public void l(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || this.a == null) {
            return;
        }
        s(view, 0.0f);
        int h2 = h(this.a.getChildAdapterPosition(view));
        if (h2 >= 0 && g(h2, 0, true) == -1) {
            this.f2631d.delete(h2);
            if (this.i.get(h2) != null) {
                this.i.get(h2).cancel();
            }
            this.i.delete(h2);
            this.j.delete(h2);
        }
    }

    public final void m(View view, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || view == null) {
            return;
        }
        if (i < 0) {
            if (i2 < i3) {
                float i5 = i(view) + (i * this.f2629b.l());
                if (i5 > (-this.f2631d.get(i4)) + f(i4, i2, true)) {
                    r(view, i2, i5);
                } else {
                    n(view, i2);
                }
            } else if (i2 > i3) {
                float i6 = i(view) + (i * this.f2629b.e());
                if (i6 > (-this.f2631d.get(i4)) + f(i4, i2, false)) {
                    r(view, i2, i6);
                } else {
                    n(view, i2);
                }
            }
        } else if (i2 > i3) {
            float i7 = i(view) + (i * this.f2629b.l());
            if (i7 < (-this.f2631d.get(i4)) + f(i4, i2, false)) {
                r(view, i2, i7);
            } else {
                n(view, i2);
            }
        } else if (i2 < i3) {
            float i8 = i(view) + (i * this.f2629b.e());
            if (i8 < (-this.f2631d.get(i4)) + f(i4, i2, true)) {
                r(view, i2, i8);
            } else {
                n(view, i2);
            }
        }
    }

    public final void n(View view, int i) {
        int h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048585, this, view, i) == null) || view == null || (h2 = h(i)) < 0) {
            return;
        }
        ValueAnimator valueAnimator = this.i.get(h2);
        if (valueAnimator == null) {
            if (Math.abs(i(view)) < 0.1f) {
                r(view, i, 0.0f);
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i(view), 0.0f);
            ofFloat.setInterpolator(new k(1.0f));
            ofFloat.setDuration(this.f2629b.a());
            ofFloat.addUpdateListener(new a(this, view, i));
            ofFloat.addListener(new b(this, h2, view, i));
            this.i.append(h2, ofFloat);
            this.j.append(h2, (int) i(view));
            ofFloat.start();
            return;
        }
        if (!valueAnimator.isRunning()) {
            valueAnimator.start();
        }
        float i2 = i(view);
        if (Math.abs(i2) > Math.abs(this.j.get(h2)) + this.f2629b.b()) {
            this.j.append(h2, (int) i2);
            valueAnimator.setFloatValues(i2, 0.0f);
            valueAnimator.cancel();
            valueAnimator.start();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int childCount = this.a.getChildCount();
            this.m.clear();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.a.getChildAt(i);
                int childAdapterPosition = this.a.getChildAdapterPosition(childAt);
                int h2 = h(childAdapterPosition);
                if (h2 >= 0 && !this.m.contains(Integer.valueOf(h2))) {
                    this.m.add(Integer.valueOf(h2));
                    n(childAt, childAdapterPosition);
                }
            }
        }
    }

    public void p(int i, int i2, int i3) {
        LinearLayoutManager linearLayoutManager;
        int h2;
        int h3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048587, this, i, i2, i3) == null) || this.a == null || (linearLayoutManager = this.k) == null || this.f2632e != 1 || this.f2635h) {
            return;
        }
        int findFirstVisibleItemPosition = i3 - linearLayoutManager.findFirstVisibleItemPosition();
        int h4 = h(i3);
        if (h4 < 0) {
            return;
        }
        this.l.add(Integer.valueOf(h4));
        if (this.f2630c == 2) {
            i = i2;
        }
        int childCount = this.a.getChildCount();
        for (int i4 = findFirstVisibleItemPosition - 1; i4 >= 0; i4--) {
            View childAt = this.a.getChildAt(i4);
            int childAdapterPosition = this.a.getChildAdapterPosition(childAt);
            if (childAdapterPosition != -1 && (h3 = h(childAdapterPosition)) >= 0 && !this.l.contains(Integer.valueOf(h3))) {
                this.l.add(Integer.valueOf(h3));
                m(childAt, i, childAdapterPosition, i3, h3);
            }
        }
        for (int i5 = findFirstVisibleItemPosition + 1; i5 <= childCount - 1; i5++) {
            View childAt2 = this.a.getChildAt(i5);
            int childAdapterPosition2 = this.a.getChildAdapterPosition(childAt2);
            if (childAdapterPosition2 != -1 && (h2 = h(childAdapterPosition2)) >= 0 && !this.l.contains(Integer.valueOf(h2))) {
                this.l.add(Integer.valueOf(h2));
                m(childAt2, i, childAdapterPosition2, i3, h2);
            }
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || this.a == null) {
            return;
        }
        this.f2632e = i;
        if (i == 0) {
            this.f2631d.clear();
            o();
        } else if (i == 2) {
            o();
        } else if (i == 1) {
            this.f2631d.clear();
            o();
        }
    }

    public final void r(View view, int i, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{view, Integer.valueOf(i), Float.valueOf(f2)}) == null) || view == null) {
            return;
        }
        if (this.f2630c == 2) {
            CardLinkageManager.INSTANCE.translationY(this.a, i, f2);
        } else {
            view.setTranslationX(f2);
        }
    }

    public final void s(View view, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048590, this, view, f2) == null) || view == null) {
            return;
        }
        if (this.f2630c == 2) {
            view.setTranslationY(f2);
        } else {
            view.setTranslationX(f2);
        }
    }

    public void t(float f2, float f3, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i)}) == null) || this.a == null) {
            return;
        }
        if (this.f2630c == 2) {
            f2 = f3;
        }
        int i2 = 1;
        if (Math.abs(f2) < this.f2629b.i()) {
            this.f2635h = true;
            o();
            return;
        }
        this.f2635h = false;
        if (Math.abs(f2) > this.f2629b.h()) {
            f2 = f2 > 0.0f ? this.f2629b.h() : -this.f2629b.h();
        }
        this.f2631d.clear();
        float f4 = this.f2629b.f() * f2;
        int h2 = h(i);
        if (h2 < 0) {
            return;
        }
        if (f2 < 0.0f) {
            float g2 = this.f2629b.g();
            int i3 = 1;
            while (true) {
                int i4 = h2 - i3;
                float f5 = (i3 * g2) + f4;
                g2 *= 1.2f;
                if (f5 > 0.0f) {
                    break;
                }
                float c2 = (f5 / this.f2629b.c()) + this.f2631d.get(i4);
                if (Math.abs(c2) > this.f2629b.d()) {
                    c2 = -this.f2629b.d();
                }
                this.f2631d.append(i4, (int) c2);
                i3++;
            }
            float g3 = this.f2629b.g();
            while (true) {
                int i5 = h2 + i2;
                float f6 = (i2 * g3) + f4;
                g3 *= 1.2f;
                if (f6 > 0.0f) {
                    return;
                }
                float j = (f6 / this.f2629b.j()) + this.f2631d.get(i5);
                if (Math.abs(j) > this.f2629b.k()) {
                    j = -this.f2629b.k();
                }
                this.f2631d.append(i5, (int) j);
                i2++;
            }
        } else {
            float g4 = this.f2629b.g();
            int i6 = 1;
            while (true) {
                int i7 = h2 - i6;
                float f7 = f4 - (i6 * g4);
                g4 *= 1.2f;
                if (f7 < 0.0f) {
                    break;
                }
                float j2 = (f7 / this.f2629b.j()) + this.f2631d.get(i7);
                if (Math.abs(j2) > this.f2629b.k()) {
                    j2 = this.f2629b.k();
                }
                this.f2631d.append(i7, (int) j2);
                i6++;
            }
            float g5 = this.f2629b.g();
            while (true) {
                int i8 = h2 + i2;
                float f8 = f4 - (i2 * g5);
                g5 *= 1.2f;
                if (f8 < 0.0f) {
                    return;
                }
                float c3 = (f8 / this.f2629b.c()) + this.f2631d.get(i8);
                if (Math.abs(c3) > this.f2629b.d()) {
                    c3 = this.f2629b.d();
                }
                this.f2631d.append(i8, (int) c3);
                i2++;
            }
        }
    }
}
