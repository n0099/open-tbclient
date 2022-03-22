package c.a.d.o.e;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public j f2605b;

    /* renamed from: c  reason: collision with root package name */
    public int f2606c;

    /* renamed from: d  reason: collision with root package name */
    public SparseIntArray f2607d;

    /* renamed from: e  reason: collision with root package name */
    public int f2608e;

    /* renamed from: f  reason: collision with root package name */
    public float f2609f;

    /* renamed from: g  reason: collision with root package name */
    public float f2610g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2611h;
    public SparseArray<ValueAnimator> i;
    public SparseIntArray j;

    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f2612b;

        public a(i iVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2612b = iVar;
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f2612b.n(this.a, ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f2613b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f2614c;

        public b(i iVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i), view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2614c = iVar;
            this.a = i;
            this.f2613b = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f2614c.i.delete(this.a);
                this.f2614c.j.delete(this.a);
                this.f2614c.n(this.f2613b, 0.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f2614c.i.delete(this.a);
                this.f2614c.j.delete(this.a);
                this.f2614c.f2607d.delete(this.a);
                this.f2614c.n(this.f2613b, 0.0f);
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

    public i(j jVar) {
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
        this.f2611h = false;
        this.f2605b = jVar;
        this.f2607d = new SparseIntArray();
        this.i = new SparseArray<>();
        this.j = new SparseIntArray();
    }

    public void e(RecyclerView recyclerView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
            this.a = recyclerView;
            this.f2606c = i;
        }
    }

    public final float f(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            if (view == null) {
                return 0.0f;
            }
            return this.f2606c == 2 ? view.getTranslationY() : view.getTranslationX();
        }
        return invokeL.floatValue;
    }

    public void g(View view) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || (recyclerView = this.a) == null || this.f2608e == 0) {
            return;
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.LayoutManager layoutManager = this.a.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            if (childAdapterPosition <= ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) {
                float f2 = -this.f2607d.get(childAdapterPosition, 0);
                if (f2 != 0.0f) {
                    this.f2609f = f2;
                } else {
                    f2 = this.f2609f;
                }
                n(view, f2 + (this.a.getChildAt(1) != null ? f(this.a.getChildAt(1)) : 0.0f));
            } else {
                float f3 = -this.f2607d.get(childAdapterPosition, 0);
                if (f3 != 0.0f) {
                    this.f2610g = f3;
                } else {
                    f3 = this.f2610g;
                }
                if (this.a.getChildAt(recyclerView2.getChildCount() - 2) != null) {
                    r3 = f(this.a.getChildAt(recyclerView3.getChildCount() - 2));
                }
                n(view, f3 + r3);
            }
            j(view, childAdapterPosition);
        }
    }

    public void h(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || this.a == null) {
            return;
        }
        n(view, 0.0f);
        int childAdapterPosition = this.a.getChildAdapterPosition(view);
        this.f2607d.delete(childAdapterPosition);
        if (this.i.get(childAdapterPosition) != null) {
            this.i.get(childAdapterPosition).cancel();
        }
        this.i.delete(childAdapterPosition);
        this.j.delete(childAdapterPosition);
    }

    public final void i(View view, float f2, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{view, Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || view == null) {
            return;
        }
        if (f2 < 0.0f) {
            if (i < i2) {
                float f3 = f(view) + (f2 * this.f2605b.l());
                if (f3 > (-this.f2607d.get(i)) + f(this.a.getChildAt(i3 + 1))) {
                    n(view, f3);
                } else {
                    j(view, i);
                }
            } else if (i > i2) {
                float f4 = f(view) + (f2 * this.f2605b.e());
                if (f4 > (-this.f2607d.get(i)) + f(this.a.getChildAt(i3 - 1))) {
                    n(view, f4);
                } else {
                    j(view, i);
                }
            }
        } else if (i > i2) {
            float f5 = f(view) + (f2 * this.f2605b.l());
            if (f5 < (-this.f2607d.get(i)) + f(this.a.getChildAt(i3 - 1))) {
                n(view, f5);
            } else {
                j(view, i);
            }
        } else if (i < i2) {
            float f6 = f(view) + (f2 * this.f2605b.e());
            if (f6 < (-this.f2607d.get(i)) + f(this.a.getChildAt(i3 + 1))) {
                n(view, f6);
            } else {
                j(view, i);
            }
        }
    }

    public final void j(View view, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, view, i) == null) || view == null) {
            return;
        }
        ValueAnimator valueAnimator = this.i.get(i);
        if (valueAnimator == null) {
            if (Math.abs(f(view)) < 0.1f) {
                n(view, 0.0f);
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f(view), 0.0f);
            ofFloat.setInterpolator(new k(1.0f));
            ofFloat.setDuration(this.f2605b.a());
            ofFloat.addUpdateListener(new a(this, view));
            ofFloat.addListener(new b(this, i, view));
            this.i.append(i, ofFloat);
            this.j.append(i, (int) f(view));
            ofFloat.start();
            return;
        }
        if (!valueAnimator.isRunning()) {
            valueAnimator.start();
        }
        float f2 = f(view);
        if (Math.abs(f2) > Math.abs(this.j.get(i)) + this.f2605b.b()) {
            this.j.append(i, (int) f2);
            valueAnimator.setFloatValues(f2, 0.0f);
            valueAnimator.cancel();
            valueAnimator.start();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int childCount = this.a.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.a.getChildAt(i);
                j(childAt, this.a.getChildAdapterPosition(childAt));
            }
        }
    }

    public void l(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048583, this, i, i2, i3) == null) || this.a == null || this.f2608e != 1 || this.f2611h) {
            return;
        }
        if (this.f2606c == 2) {
            i = i2;
        }
        int childCount = this.a.getChildCount();
        if (this.a.getLayoutManager() instanceof LinearLayoutManager) {
            int findFirstVisibleItemPosition = i3 - ((LinearLayoutManager) this.a.getLayoutManager()).findFirstVisibleItemPosition();
            for (int i4 = findFirstVisibleItemPosition - 1; i4 >= 0; i4--) {
                View childAt = this.a.getChildAt(i4);
                int childAdapterPosition = this.a.getChildAdapterPosition(childAt);
                if (childAdapterPosition != -1) {
                    i(childAt, i, childAdapterPosition, i3, i4);
                }
            }
            for (int i5 = findFirstVisibleItemPosition + 1; i5 <= childCount - 1; i5++) {
                View childAt2 = this.a.getChildAt(i5);
                int childAdapterPosition2 = this.a.getChildAdapterPosition(childAt2);
                if (childAdapterPosition2 != -1) {
                    i(childAt2, i, childAdapterPosition2, i3, i5);
                }
            }
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || this.a == null) {
            return;
        }
        this.f2608e = i;
        if (i == 0) {
            this.f2607d.clear();
            k();
        } else if (i == 2) {
            k();
        } else if (i == 1) {
            this.f2607d.clear();
            k();
        }
    }

    public final void n(View view, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048585, this, view, f2) == null) || view == null) {
            return;
        }
        if (this.f2606c == 2) {
            view.setTranslationY(f2);
        } else {
            view.setTranslationX(f2);
        }
    }

    public void o(float f2, float f3, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i)}) == null) || this.a == null) {
            return;
        }
        if (this.f2606c == 2) {
            f2 = f3;
        }
        int i2 = 1;
        if (Math.abs(f2) < this.f2605b.i()) {
            this.f2611h = true;
            k();
            return;
        }
        this.f2611h = false;
        if (Math.abs(f2) > this.f2605b.h()) {
            f2 = f2 > 0.0f ? this.f2605b.h() : -this.f2605b.h();
        }
        this.f2607d.clear();
        float f4 = this.f2605b.f() * f2;
        if (f2 < 0.0f) {
            float g2 = this.f2605b.g();
            int i3 = 1;
            while (true) {
                int i4 = i - i3;
                float f5 = (i3 * g2) + f4;
                g2 *= 1.4f;
                if (f5 > 0.0f) {
                    break;
                }
                float c2 = (f5 / this.f2605b.c()) + this.f2607d.get(i4);
                if (Math.abs(c2) > this.f2605b.d()) {
                    c2 = -this.f2605b.d();
                }
                this.f2607d.append(i4, (int) c2);
                i3++;
            }
            float g3 = this.f2605b.g();
            while (true) {
                int i5 = i + i2;
                float f6 = (i2 * g3) + f4;
                g3 *= 1.4f;
                if (f6 > 0.0f) {
                    return;
                }
                float j = (f6 / this.f2605b.j()) + this.f2607d.get(i5);
                if (Math.abs(j) > this.f2605b.k()) {
                    j = -this.f2605b.k();
                }
                this.f2607d.append(i5, (int) j);
                i2++;
            }
        } else {
            float g4 = this.f2605b.g();
            int i6 = 1;
            while (true) {
                int i7 = i - i6;
                float f7 = f4 - (i6 * g4);
                g4 *= 1.4f;
                if (f7 < 0.0f) {
                    break;
                }
                float j2 = (f7 / this.f2605b.j()) + this.f2607d.get(i7);
                if (Math.abs(j2) > this.f2605b.k()) {
                    j2 = this.f2605b.k();
                }
                this.f2607d.append(i7, (int) j2);
                i6++;
            }
            float g5 = this.f2605b.g();
            while (true) {
                int i8 = i + i2;
                float f8 = f4 - (i2 * g5);
                g5 *= 1.4f;
                if (f8 < 0.0f) {
                    return;
                }
                float c3 = (f8 / this.f2605b.c()) + this.f2607d.get(i8);
                if (Math.abs(c3) > this.f2605b.d()) {
                    c3 = this.f2605b.d();
                }
                this.f2607d.append(i8, (int) c3);
                i2++;
            }
        }
    }
}
