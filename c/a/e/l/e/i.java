package c.a.e.l.e;

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

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f3005a;

    /* renamed from: b  reason: collision with root package name */
    public j f3006b;

    /* renamed from: c  reason: collision with root package name */
    public int f3007c;

    /* renamed from: d  reason: collision with root package name */
    public SparseIntArray f3008d;

    /* renamed from: e  reason: collision with root package name */
    public int f3009e;

    /* renamed from: f  reason: collision with root package name */
    public float f3010f;

    /* renamed from: g  reason: collision with root package name */
    public float f3011g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3012h;

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<ValueAnimator> f3013i;

    /* renamed from: j  reason: collision with root package name */
    public SparseIntArray f3014j;

    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f3015e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f3016f;

        public a(i iVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3016f = iVar;
            this.f3015e = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f3016f.n(this.f3015e, ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f3017e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f3018f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f3019g;

        public b(i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2), view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3019g = iVar;
            this.f3017e = i2;
            this.f3018f = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f3019g.f3013i.delete(this.f3017e);
                this.f3019g.f3014j.delete(this.f3017e);
                this.f3019g.n(this.f3018f, 0.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f3019g.f3013i.delete(this.f3017e);
                this.f3019g.f3014j.delete(this.f3017e);
                this.f3019g.f3008d.delete(this.f3017e);
                this.f3019g.n(this.f3018f, 0.0f);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3012h = false;
        this.f3006b = jVar;
        this.f3008d = new SparseIntArray();
        this.f3013i = new SparseArray<>();
        this.f3014j = new SparseIntArray();
    }

    public void e(RecyclerView recyclerView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
            this.f3005a = recyclerView;
            this.f3007c = i2;
        }
    }

    public final float f(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            if (view == null) {
                return 0.0f;
            }
            return this.f3007c == 2 ? view.getTranslationY() : view.getTranslationX();
        }
        return invokeL.floatValue;
    }

    public void g(View view) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || (recyclerView = this.f3005a) == null || this.f3009e == 0) {
            return;
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.LayoutManager layoutManager = this.f3005a.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            if (childAdapterPosition <= ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) {
                float f2 = -this.f3008d.get(childAdapterPosition, 0);
                if (f2 != 0.0f) {
                    this.f3010f = f2;
                } else {
                    f2 = this.f3010f;
                }
                n(view, f2 + (this.f3005a.getChildAt(1) != null ? f(this.f3005a.getChildAt(1)) : 0.0f));
            } else {
                float f3 = -this.f3008d.get(childAdapterPosition, 0);
                if (f3 != 0.0f) {
                    this.f3011g = f3;
                } else {
                    f3 = this.f3011g;
                }
                if (this.f3005a.getChildAt(recyclerView2.getChildCount() - 2) != null) {
                    r3 = f(this.f3005a.getChildAt(recyclerView3.getChildCount() - 2));
                }
                n(view, f3 + r3);
            }
            j(view, childAdapterPosition);
        }
    }

    public void h(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || this.f3005a == null) {
            return;
        }
        n(view, 0.0f);
        int childAdapterPosition = this.f3005a.getChildAdapterPosition(view);
        this.f3008d.delete(childAdapterPosition);
        if (this.f3013i.get(childAdapterPosition) != null) {
            this.f3013i.get(childAdapterPosition).cancel();
        }
        this.f3013i.delete(childAdapterPosition);
        this.f3014j.delete(childAdapterPosition);
    }

    public final void i(View view, float f2, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{view, Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || view == null) {
            return;
        }
        if (f2 < 0.0f) {
            if (i2 < i3) {
                float f3 = f(view) + (f2 * this.f3006b.l());
                if (f3 > (-this.f3008d.get(i2)) + f(this.f3005a.getChildAt(i4 + 1))) {
                    n(view, f3);
                } else {
                    j(view, i2);
                }
            } else if (i2 > i3) {
                float f4 = f(view) + (f2 * this.f3006b.e());
                if (f4 > (-this.f3008d.get(i2)) + f(this.f3005a.getChildAt(i4 - 1))) {
                    n(view, f4);
                } else {
                    j(view, i2);
                }
            }
        } else if (i2 > i3) {
            float f5 = f(view) + (f2 * this.f3006b.l());
            if (f5 < (-this.f3008d.get(i2)) + f(this.f3005a.getChildAt(i4 - 1))) {
                n(view, f5);
            } else {
                j(view, i2);
            }
        } else if (i2 < i3) {
            float f6 = f(view) + (f2 * this.f3006b.e());
            if (f6 < (-this.f3008d.get(i2)) + f(this.f3005a.getChildAt(i4 + 1))) {
                n(view, f6);
            } else {
                j(view, i2);
            }
        }
    }

    public final void j(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, view, i2) == null) || view == null) {
            return;
        }
        ValueAnimator valueAnimator = this.f3013i.get(i2);
        if (valueAnimator == null) {
            if (Math.abs(f(view)) < 0.1f) {
                n(view, 0.0f);
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f(view), 0.0f);
            ofFloat.setInterpolator(new k(1.0f));
            ofFloat.setDuration(this.f3006b.a());
            ofFloat.addUpdateListener(new a(this, view));
            ofFloat.addListener(new b(this, i2, view));
            this.f3013i.append(i2, ofFloat);
            this.f3014j.append(i2, (int) f(view));
            ofFloat.start();
            return;
        }
        if (!valueAnimator.isRunning()) {
            valueAnimator.start();
        }
        float f2 = f(view);
        if (Math.abs(f2) > Math.abs(this.f3014j.get(i2)) + this.f3006b.b()) {
            this.f3014j.append(i2, (int) f2);
            valueAnimator.setFloatValues(f2, 0.0f);
            valueAnimator.cancel();
            valueAnimator.start();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int childCount = this.f3005a.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f3005a.getChildAt(i2);
                j(childAt, this.f3005a.getChildAdapterPosition(childAt));
            }
        }
    }

    public void l(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048583, this, i2, i3, i4) == null) || this.f3005a == null || this.f3009e != 1 || this.f3012h) {
            return;
        }
        if (this.f3007c == 2) {
            i2 = i3;
        }
        int childCount = this.f3005a.getChildCount();
        if (this.f3005a.getLayoutManager() instanceof LinearLayoutManager) {
            int findFirstVisibleItemPosition = i4 - ((LinearLayoutManager) this.f3005a.getLayoutManager()).findFirstVisibleItemPosition();
            for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                View childAt = this.f3005a.getChildAt(i5);
                int childAdapterPosition = this.f3005a.getChildAdapterPosition(childAt);
                if (childAdapterPosition != -1) {
                    i(childAt, i2, childAdapterPosition, i4, i5);
                }
            }
            for (int i6 = findFirstVisibleItemPosition + 1; i6 <= childCount - 1; i6++) {
                View childAt2 = this.f3005a.getChildAt(i6);
                int childAdapterPosition2 = this.f3005a.getChildAdapterPosition(childAt2);
                if (childAdapterPosition2 != -1) {
                    i(childAt2, i2, childAdapterPosition2, i4, i6);
                }
            }
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.f3005a == null) {
            return;
        }
        this.f3009e = i2;
        if (i2 == 0) {
            this.f3008d.clear();
            k();
        } else if (i2 == 2) {
            k();
        } else if (i2 == 1) {
            this.f3008d.clear();
            k();
        }
    }

    public final void n(View view, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048585, this, view, f2) == null) || view == null) {
            return;
        }
        if (this.f3007c == 2) {
            view.setTranslationY(f2);
        } else {
            view.setTranslationX(f2);
        }
    }

    public void o(float f2, float f3, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2)}) == null) || this.f3005a == null) {
            return;
        }
        if (this.f3007c == 2) {
            f2 = f3;
        }
        int i3 = 1;
        if (Math.abs(f2) < this.f3006b.i()) {
            this.f3012h = true;
            k();
            return;
        }
        this.f3012h = false;
        if (Math.abs(f2) > this.f3006b.h()) {
            f2 = f2 > 0.0f ? this.f3006b.h() : -this.f3006b.h();
        }
        this.f3008d.clear();
        float f4 = this.f3006b.f() * f2;
        if (f2 < 0.0f) {
            float g2 = this.f3006b.g();
            int i4 = 1;
            while (true) {
                int i5 = i2 - i4;
                float f5 = (i4 * g2) + f4;
                g2 *= 1.4f;
                if (f5 > 0.0f) {
                    break;
                }
                float c2 = (f5 / this.f3006b.c()) + this.f3008d.get(i5);
                if (Math.abs(c2) > this.f3006b.d()) {
                    c2 = -this.f3006b.d();
                }
                this.f3008d.append(i5, (int) c2);
                i4++;
            }
            float g3 = this.f3006b.g();
            while (true) {
                int i6 = i2 + i3;
                float f6 = (i3 * g3) + f4;
                g3 *= 1.4f;
                if (f6 > 0.0f) {
                    return;
                }
                float j2 = (f6 / this.f3006b.j()) + this.f3008d.get(i6);
                if (Math.abs(j2) > this.f3006b.k()) {
                    j2 = -this.f3006b.k();
                }
                this.f3008d.append(i6, (int) j2);
                i3++;
            }
        } else {
            float g4 = this.f3006b.g();
            int i7 = 1;
            while (true) {
                int i8 = i2 - i7;
                float f7 = f4 - (i7 * g4);
                g4 *= 1.4f;
                if (f7 < 0.0f) {
                    break;
                }
                float j3 = (f7 / this.f3006b.j()) + this.f3008d.get(i8);
                if (Math.abs(j3) > this.f3006b.k()) {
                    j3 = this.f3006b.k();
                }
                this.f3008d.append(i8, (int) j3);
                i7++;
            }
            float g5 = this.f3006b.g();
            while (true) {
                int i9 = i2 + i3;
                float f8 = f4 - (i3 * g5);
                g5 *= 1.4f;
                if (f8 < 0.0f) {
                    return;
                }
                float c3 = (f8 / this.f3006b.c()) + this.f3008d.get(i9);
                if (Math.abs(c3) > this.f3006b.d()) {
                    c3 = this.f3006b.d();
                }
                this.f3008d.append(i9, (int) c3);
                i3++;
            }
        }
    }
}
