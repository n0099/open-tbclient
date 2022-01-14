package c.a.d.n.e;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
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
    public j f3332b;

    /* renamed from: c  reason: collision with root package name */
    public int f3333c;

    /* renamed from: d  reason: collision with root package name */
    public SparseIntArray f3334d;

    /* renamed from: e  reason: collision with root package name */
    public int f3335e;

    /* renamed from: f  reason: collision with root package name */
    public float f3336f;

    /* renamed from: g  reason: collision with root package name */
    public float f3337g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3338h;

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<ValueAnimator> f3339i;

    /* renamed from: j  reason: collision with root package name */
    public SparseIntArray f3340j;
    public LinearLayoutManager k;
    public HashSet<Integer> l;
    public HashSet<Integer> m;

    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f3341e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3342f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ m f3343g;

        public a(m mVar, View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, view, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3343g = mVar;
            this.f3341e = view;
            this.f3342f = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f3343g.q(this.f3341e, this.f3342f, ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f3344e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f3345f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3346g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ m f3347h;

        public b(m mVar, int i2, View view, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, Integer.valueOf(i2), view, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3347h = mVar;
            this.f3344e = i2;
            this.f3345f = view;
            this.f3346g = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f3347h.f3339i.delete(this.f3344e);
                this.f3347h.f3340j.delete(this.f3344e);
                this.f3347h.q(this.f3345f, this.f3346g, 0.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f3347h.f3339i.delete(this.f3344e);
                this.f3347h.f3340j.delete(this.f3344e);
                this.f3347h.f3334d.delete(this.f3344e);
                this.f3347h.q(this.f3345f, this.f3346g, 0.0f);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3338h = false;
        this.l = new HashSet<>();
        this.m = new HashSet<>();
        this.f3332b = jVar;
        this.f3334d = new SparseIntArray();
        this.f3339i = new SparseArray<>();
        this.f3340j = new SparseIntArray();
    }

    public void e(BdTypeRecyclerView bdTypeRecyclerView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, bdTypeRecyclerView, i2) == null) {
            this.a = bdTypeRecyclerView;
            this.f3333c = i2;
            if (bdTypeRecyclerView == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
                return;
            }
            this.k = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
        }
    }

    public final float f(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (z) {
                return i(this.a.getChildAt(g(i2 + 1, i3, true)));
            }
            return i(this.a.getChildAt(g(i2 - 1, i3, false)));
        }
        return invokeCommon.floatValue;
    }

    public final int g(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            int i4 = 1;
            if (!z) {
                while (i4 < i3) {
                    int i5 = i3 - i4;
                    if (i2 == h(i5)) {
                        return i5;
                    }
                    i4++;
                }
                return -1;
            }
            int count = this.a.getCount() - i3;
            while (i4 < count) {
                int i6 = i3 + i4;
                if (i2 == h(i6)) {
                    return i6;
                }
                i4++;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public final int h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 > 0) {
                n item = this.a.getItem(i2 - this.a.getHeaderViewsCount());
                if (item instanceof BaseCardInfo) {
                    return ((BaseCardInfo) item).position;
                }
                return -1;
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
            return this.f3333c == 2 ? view.getTranslationY() : view.getTranslationX();
        }
        return invokeL.floatValue;
    }

    public void j(View view) {
        BdTypeRecyclerView bdTypeRecyclerView;
        int childAdapterPosition;
        int h2;
        BdTypeRecyclerView bdTypeRecyclerView2;
        float f2;
        BdTypeRecyclerView bdTypeRecyclerView3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || (bdTypeRecyclerView = this.a) == null || this.k == null || this.f3335e == 0 || (h2 = h((childAdapterPosition = bdTypeRecyclerView.getChildAdapterPosition(view)))) < 0) {
            return;
        }
        if (childAdapterPosition <= this.k.findFirstVisibleItemPosition()) {
            float i2 = this.a.getChildAt(1) != null ? i(this.a.getChildAt(1)) : 0.0f;
            int h3 = h(childAdapterPosition + 1);
            if (h3 < 0) {
                return;
            }
            if (h3 == h2) {
                r(view, i2);
            } else {
                float f3 = -this.f3334d.get(h2, 0);
                if (f3 != 0.0f) {
                    this.f3336f = f3;
                } else {
                    f3 = this.f3336f;
                }
                r(view, f3 + i2);
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
                r(view, f2);
            } else {
                float f4 = -this.f3334d.get(h2, 0);
                if (f4 != 0.0f) {
                    this.f3337g = f4;
                } else {
                    f4 = this.f3337g;
                }
                r(view, f4 + f2);
            }
        }
        m(view, childAdapterPosition);
    }

    public void k(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view) == null) || this.a == null) {
            return;
        }
        r(view, 0.0f);
        int h2 = h(this.a.getChildAdapterPosition(view));
        if (h2 >= 0 && g(h2, 0, true) == -1) {
            this.f3334d.delete(h2);
            if (this.f3339i.get(h2) != null) {
                this.f3339i.get(h2).cancel();
            }
            this.f3339i.delete(h2);
            this.f3340j.delete(h2);
        }
    }

    public final void l(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || view == null) {
            return;
        }
        if (i2 < 0) {
            if (i3 < i4) {
                float i6 = i(view) + (i2 * this.f3332b.l());
                if (i6 > (-this.f3334d.get(i5)) + f(i5, i3, true)) {
                    q(view, i3, i6);
                } else {
                    m(view, i3);
                }
            } else if (i3 > i4) {
                float i7 = i(view) + (i2 * this.f3332b.e());
                if (i7 > (-this.f3334d.get(i5)) + f(i5, i3, false)) {
                    q(view, i3, i7);
                } else {
                    m(view, i3);
                }
            }
        } else if (i3 > i4) {
            float i8 = i(view) + (i2 * this.f3332b.l());
            if (i8 < (-this.f3334d.get(i5)) + f(i5, i3, false)) {
                q(view, i3, i8);
            } else {
                m(view, i3);
            }
        } else if (i3 < i4) {
            float i9 = i(view) + (i2 * this.f3332b.e());
            if (i9 < (-this.f3334d.get(i5)) + f(i5, i3, true)) {
                q(view, i3, i9);
            } else {
                m(view, i3);
            }
        }
    }

    public final void m(View view, int i2) {
        int h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, i2) == null) || view == null || (h2 = h(i2)) < 0) {
            return;
        }
        ValueAnimator valueAnimator = this.f3339i.get(h2);
        if (valueAnimator == null) {
            if (Math.abs(i(view)) < 0.1f) {
                q(view, i2, 0.0f);
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i(view), 0.0f);
            ofFloat.setInterpolator(new k(1.0f));
            ofFloat.setDuration(this.f3332b.a());
            ofFloat.addUpdateListener(new a(this, view, i2));
            ofFloat.addListener(new b(this, h2, view, i2));
            this.f3339i.append(h2, ofFloat);
            this.f3340j.append(h2, (int) i(view));
            ofFloat.start();
            return;
        }
        if (!valueAnimator.isRunning()) {
            valueAnimator.start();
        }
        float i3 = i(view);
        if (Math.abs(i3) > Math.abs(this.f3340j.get(h2)) + this.f3332b.b()) {
            this.f3340j.append(h2, (int) i3);
            valueAnimator.setFloatValues(i3, 0.0f);
            valueAnimator.cancel();
            valueAnimator.start();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            int childCount = this.a.getChildCount();
            this.m.clear();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.a.getChildAt(i2);
                int childAdapterPosition = this.a.getChildAdapterPosition(childAt);
                int h2 = h(childAdapterPosition);
                if (h2 >= 0 && !this.m.contains(Integer.valueOf(h2))) {
                    this.m.add(Integer.valueOf(h2));
                    m(childAt, childAdapterPosition);
                }
            }
        }
    }

    public void o(int i2, int i3, int i4) {
        LinearLayoutManager linearLayoutManager;
        int h2;
        int h3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048586, this, i2, i3, i4) == null) || this.a == null || (linearLayoutManager = this.k) == null || this.f3335e != 1 || this.f3338h) {
            return;
        }
        int findFirstVisibleItemPosition = i4 - linearLayoutManager.findFirstVisibleItemPosition();
        int h4 = h(i4);
        if (h4 < 0) {
            return;
        }
        this.l.add(Integer.valueOf(h4));
        if (this.f3333c == 2) {
            i2 = i3;
        }
        int childCount = this.a.getChildCount();
        for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
            View childAt = this.a.getChildAt(i5);
            int childAdapterPosition = this.a.getChildAdapterPosition(childAt);
            if (childAdapterPosition != -1 && (h3 = h(childAdapterPosition)) >= 0 && !this.l.contains(Integer.valueOf(h3))) {
                this.l.add(Integer.valueOf(h3));
                l(childAt, i2, childAdapterPosition, i4, h3);
            }
        }
        for (int i6 = findFirstVisibleItemPosition + 1; i6 <= childCount - 1; i6++) {
            View childAt2 = this.a.getChildAt(i6);
            int childAdapterPosition2 = this.a.getChildAdapterPosition(childAt2);
            if (childAdapterPosition2 != -1 && (h2 = h(childAdapterPosition2)) >= 0 && !this.l.contains(Integer.valueOf(h2))) {
                this.l.add(Integer.valueOf(h2));
                l(childAt2, i2, childAdapterPosition2, i4, h2);
            }
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || this.a == null) {
            return;
        }
        this.f3335e = i2;
        if (i2 == 0) {
            this.f3334d.clear();
            n();
        } else if (i2 == 2) {
            n();
        } else if (i2 == 1) {
            this.f3334d.clear();
            n();
        }
    }

    public final void q(View view, int i2, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{view, Integer.valueOf(i2), Float.valueOf(f2)}) == null) || view == null) {
            return;
        }
        if (this.f3333c == 2) {
            CardLinkageManager.INSTANCE.translationY(this.a, i2, f2);
        } else {
            view.setTranslationX(f2);
        }
    }

    public final void r(View view, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048589, this, view, f2) == null) || view == null) {
            return;
        }
        if (this.f3333c == 2) {
            view.setTranslationY(f2);
        } else {
            view.setTranslationX(f2);
        }
    }

    public void s(float f2, float f3, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2)}) == null) || this.a == null) {
            return;
        }
        if (this.f3333c == 2) {
            f2 = f3;
        }
        int i3 = 1;
        if (Math.abs(f2) < this.f3332b.i()) {
            this.f3338h = true;
            n();
            return;
        }
        this.f3338h = false;
        if (Math.abs(f2) > this.f3332b.h()) {
            f2 = f2 > 0.0f ? this.f3332b.h() : -this.f3332b.h();
        }
        this.f3334d.clear();
        float f4 = this.f3332b.f() * f2;
        int h2 = h(i2);
        if (h2 < 0) {
            return;
        }
        if (f2 < 0.0f) {
            float g2 = this.f3332b.g();
            int i4 = 1;
            while (true) {
                int i5 = h2 - i4;
                float f5 = (i4 * g2) + f4;
                g2 *= 1.2f;
                if (f5 > 0.0f) {
                    break;
                }
                float c2 = (f5 / this.f3332b.c()) + this.f3334d.get(i5);
                if (Math.abs(c2) > this.f3332b.d()) {
                    c2 = -this.f3332b.d();
                }
                this.f3334d.append(i5, (int) c2);
                i4++;
            }
            float g3 = this.f3332b.g();
            while (true) {
                int i6 = h2 + i3;
                float f6 = (i3 * g3) + f4;
                g3 *= 1.2f;
                if (f6 > 0.0f) {
                    return;
                }
                float j2 = (f6 / this.f3332b.j()) + this.f3334d.get(i6);
                if (Math.abs(j2) > this.f3332b.k()) {
                    j2 = -this.f3332b.k();
                }
                this.f3334d.append(i6, (int) j2);
                i3++;
            }
        } else {
            float g4 = this.f3332b.g();
            int i7 = 1;
            while (true) {
                int i8 = h2 - i7;
                float f7 = f4 - (i7 * g4);
                g4 *= 1.2f;
                if (f7 < 0.0f) {
                    break;
                }
                float j3 = (f7 / this.f3332b.j()) + this.f3334d.get(i8);
                if (Math.abs(j3) > this.f3332b.k()) {
                    j3 = this.f3332b.k();
                }
                this.f3334d.append(i8, (int) j3);
                i7++;
            }
            float g5 = this.f3332b.g();
            while (true) {
                int i9 = h2 + i3;
                float f8 = f4 - (i3 * g5);
                g5 *= 1.2f;
                if (f8 < 0.0f) {
                    return;
                }
                float c3 = (f8 / this.f3332b.c()) + this.f3334d.get(i9);
                if (Math.abs(c3) > this.f3332b.d()) {
                    c3 = this.f3332b.d();
                }
                this.f3334d.append(i9, (int) c3);
                i3++;
            }
        }
    }
}
