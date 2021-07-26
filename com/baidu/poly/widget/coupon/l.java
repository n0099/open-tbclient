package com.baidu.poly.widget.coupon;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyFrameLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.e0.k.j.a;
import d.a.e0.p.a.a;
import d.a.e0.p.c;
import java.util.List;
/* loaded from: classes2.dex */
public class l extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f9504e;

    /* renamed from: f  reason: collision with root package name */
    public ListView f9505f;

    /* renamed from: g  reason: collision with root package name */
    public PolyFrameLayout f9506g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f9507h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f9508i;
    public h j;
    public d.a.e0.p.a.b k;
    public List<a.C0594a> l;
    public a.C0594a m;
    public com.baidu.poly.a.l.c n;
    public boolean o;
    public Runnable p;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f9509e;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9509e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                l lVar = this.f9509e;
                lVar.n = d.a.e0.k.k.a.a(lVar.f9506g, layoutParams, "加载中", -1L);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f9510e;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9510e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f9510e.j == null) {
                return;
            }
            this.f9510e.j.d();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f9511e;

        public c(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9511e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9511e.j.d();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f9512e;

        public d(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9512e = lVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || ((a.C0594a) this.f9512e.l.get(i2)).f42693g == 1) {
                return;
            }
            l lVar = this.f9512e;
            lVar.e((a.C0594a) lVar.l.get(i2));
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.a.e0.k.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C0594a f9513a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f9514b;

        /* loaded from: classes2.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.e0.p.c f9515e;

            public a(e eVar, d.a.e0.p.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9515e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f9515e.q();
                }
            }
        }

        /* loaded from: classes2.dex */
        public class b implements c.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f9516a;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9516a = eVar;
            }

            @Override // d.a.e0.p.c.b
            public void onDismiss() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f9516a.f9514b.j.b();
                }
            }
        }

        public e(l lVar, a.C0594a c0594a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, c0594a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9514b = lVar;
            this.f9513a = c0594a;
        }

        @Override // d.a.e0.k.j.a
        public void a(a.C0591a c0591a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c0591a) == null) {
                this.f9514b.f9506g.a(false);
                l lVar = this.f9514b;
                lVar.removeCallbacks(lVar.p);
                d.a.e0.k.k.a.c(this.f9514b.n);
                this.f9514b.n = null;
                if (c0591a == null) {
                    return;
                }
                int i2 = c0591a.f42667a;
                if (i2 == 0) {
                    for (a.C0594a c0594a : this.f9514b.l) {
                        if (c0594a == this.f9513a) {
                            this.f9514b.m = c0594a;
                            c0594a.f42693g = 1;
                        } else {
                            c0594a.f42693g = 0;
                        }
                    }
                    this.f9514b.k.notifyDataSetChanged();
                    this.f9514b.j.d();
                } else if (i2 == 1) {
                    View inflate = View.inflate(this.f9514b.getContext(), d.a.e0.g.default_pop_window, null);
                    d.a.e0.p.c cVar = new d.a.e0.p.c(inflate, -1, -1, true);
                    ((TextView) inflate.findViewById(d.a.e0.f.pop_tips)).setText(c0591a.f42668b);
                    ((TextView) inflate.findViewById(d.a.e0.f.pop_button)).setOnClickListener(new a(this, cVar));
                    cVar.h(new b(this));
                    cVar.E(this.f9514b, 0, 0, 0);
                } else {
                    Toast.makeText(this.f9514b.getContext(), this.f9514b.getResources().getString(d.a.e0.h.coupon_calculate_error), 0).show();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f9517e;

        public f(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9517e = lVar;
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
                this.f9517e.o = false;
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

    /* loaded from: classes2.dex */
    public class g implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f9518e;

        public g(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9518e = lVar;
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
                this.f9518e.o = false;
                this.f9518e.o();
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

    /* loaded from: classes2.dex */
    public interface h {
        void a(a.C0594a c0594a, d.a.e0.k.j.a aVar);

        void b();

        void d();

        void onDetach();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(Context context) {
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

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f9506g.getLayoutParams().height = i2;
            s();
        }
    }

    public void d(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null || this.o || !this.f9508i) {
            return;
        }
        this.o = true;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, view.getMeasuredWidth() * (-1));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f9507h, "translationX", view.getMeasuredWidth(), 0.0f);
        animatorSet.setDuration(160L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new f(this));
    }

    public final void e(a.C0594a c0594a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c0594a) == null) || this.j == null) {
            return;
        }
        this.f9506g.a(true);
        postDelayed(this.p, 500L);
        this.j.a(c0594a, new e(this, c0594a));
    }

    public void g(List<a.C0594a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.l = list;
            if (this.k == null) {
                this.k = new d.a.e0.p.a.b(getContext());
            }
            this.f9505f.setAdapter((ListAdapter) this.k);
            this.k.a(this.l);
            List<a.C0594a> list2 = this.l;
            if (list2 != null && list2.size() > 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.l.size()) {
                        break;
                    } else if (this.l.get(i2).f42693g == 1) {
                        this.l.get(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
                this.f9505f.setOnItemClickListener(new d(this));
            } else if (this.j == null || !this.f9508i) {
            } else {
                postDelayed(new c(this), 100L);
            }
        }
    }

    public void k(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || view == null || this.o || !this.f9508i) {
            return;
        }
        this.o = true;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", view.getMeasuredWidth() * (-1), 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f9507h, "translationX", 0.0f, view.getMeasuredWidth());
        animatorSet.setDuration(160L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new g(this));
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            LayoutInflater.from(context).inflate(d.a.e0.g.coupon_list, (ViewGroup) this, true);
            this.f9506g = (PolyFrameLayout) findViewById(d.a.e0.f.root_layout);
            this.f9507h = (ViewGroup) findViewById(d.a.e0.f.coupon_layout);
            this.f9505f = (ListView) findViewById(d.a.e0.f.coupon_list_layout);
            View findViewById = findViewById(d.a.e0.f.back);
            this.f9504e = findViewById;
            findViewById.setOnClickListener(new b(this));
            setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f9508i) {
            this.f9508i = false;
            if (getParent() instanceof ViewGroup) {
                ((ViewGroup) getParent()).removeView(this);
            }
            h hVar = this.j;
            if (hVar != null) {
                hVar.onDetach();
            }
            d.a.e0.n.d.e("CouponListView->detach()");
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f9508i) {
            return;
        }
        this.f9508i = true;
        if (getContext() instanceof Activity) {
            View decorView = ((Activity) getContext()).getWindow().getDecorView();
            if (decorView instanceof ViewGroup) {
                ((ViewGroup) decorView).addView(this);
            }
            d.a.e0.n.d.e("CouponListView->attach()");
            return;
        }
        throw new IllegalStateException("can not attach to context " + getContext());
    }

    public void setListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
            this.j = hVar;
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.o && this.f9508i && (hVar = this.j) != null) {
                hVar.d();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(Context context, AttributeSet attributeSet) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f9508i = false;
        this.o = false;
        this.p = new a(this);
        m(context);
    }
}
