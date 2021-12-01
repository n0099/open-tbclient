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
import c.a.f0.i;
import c.a.f0.s.e.a;
import c.a.f0.t.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyFrameLayout;
import com.baidu.poly.widget.PopupWindow;
import com.baidu.poly.widget.toast.ToastLoadingView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.List;
/* loaded from: classes9.dex */
public class CouponListView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f38490e;

    /* renamed from: f  reason: collision with root package name */
    public ListView f38491f;

    /* renamed from: g  reason: collision with root package name */
    public PolyFrameLayout f38492g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f38493h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f38494i;

    /* renamed from: j  reason: collision with root package name */
    public h f38495j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.f0.t.c.b f38496k;
    public List<a.C0119a> l;
    public a.C0119a m;
    public ToastLoadingView n;
    public boolean o;
    public Runnable p;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CouponListView f38497e;

        public a(CouponListView couponListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {couponListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38497e = couponListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                CouponListView couponListView = this.f38497e;
                couponListView.n = c.a.f0.t.e.a.c(couponListView.f38492g, layoutParams, "加载中", -1L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CouponListView f38498e;

        public b(CouponListView couponListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {couponListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38498e = couponListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f38498e.f38495j == null) {
                return;
            }
            this.f38498e.f38495j.c(false, this.f38498e.m);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CouponListView f38499e;

        public c(CouponListView couponListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {couponListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38499e = couponListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f38499e.f38495j.c(false, this.f38499e.m);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CouponListView f38500e;

        public d(CouponListView couponListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {couponListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38500e = couponListView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || ((a.C0119a) this.f38500e.l.get(i2)).f3266h == 1) {
                return;
            }
            CouponListView couponListView = this.f38500e;
            couponListView.p((a.C0119a) couponListView.l.get(i2));
        }
    }

    /* loaded from: classes9.dex */
    public class e implements c.a.f0.s.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.C0119a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CouponListView f38501b;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PopupWindow f38502e;

            public a(e eVar, PopupWindow popupWindow) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, popupWindow};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38502e = popupWindow;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f38502e.n();
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements PopupWindow.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

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
                this.a = eVar;
            }

            @Override // com.baidu.poly.widget.PopupWindow.b
            public void onDismiss() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.f38501b.f38495j.a();
                }
            }
        }

        public e(CouponListView couponListView, a.C0119a c0119a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {couponListView, c0119a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38501b = couponListView;
            this.a = c0119a;
        }

        @Override // c.a.f0.s.e.a
        public void a(a.C0116a c0116a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c0116a) == null) {
                this.f38501b.f38492g.interceptTouchEvent(false);
                CouponListView couponListView = this.f38501b;
                couponListView.removeCallbacks(couponListView.p);
                c.a.f0.t.e.a.b(this.f38501b.n);
                this.f38501b.n = null;
                if (c0116a == null) {
                    return;
                }
                int i2 = c0116a.a;
                if (i2 == 0) {
                    for (a.C0119a c0119a : this.f38501b.l) {
                        if (c0119a == this.a) {
                            this.f38501b.m = c0119a;
                            c0119a.f3266h = 1;
                        } else {
                            c0119a.f3266h = 0;
                        }
                    }
                    this.f38501b.f38496k.notifyDataSetChanged();
                    this.f38501b.f38495j.c(true, this.a);
                } else if (i2 == 1) {
                    View inflate = View.inflate(this.f38501b.getContext(), c.a.f0.h.default_pop_window, null);
                    PopupWindow popupWindow = new PopupWindow(inflate, -1, -1, true);
                    ((TextView) inflate.findViewById(c.a.f0.g.pop_tips)).setText(c0116a.f3246b);
                    ((TextView) inflate.findViewById(c.a.f0.g.pop_button)).setOnClickListener(new a(this, popupWindow));
                    popupWindow.A(new b(this));
                    popupWindow.D(this.f38501b, 0, 0, 0);
                } else {
                    Toast.makeText(this.f38501b.getContext(), this.f38501b.getResources().getString(i.coupon_calculate_error), 0).show();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CouponListView f38503e;

        public f(CouponListView couponListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {couponListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38503e = couponListView;
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
                this.f38503e.o = false;
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

    /* loaded from: classes9.dex */
    public class g implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CouponListView f38504e;

        public g(CouponListView couponListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {couponListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38504e = couponListView;
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
                this.f38504e.o = false;
                this.f38504e.n();
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

    /* loaded from: classes9.dex */
    public interface h {
        void a();

        void b(a.C0119a c0119a, c.a.f0.s.e.a aVar);

        void c(boolean z, a.C0119a c0119a);

        void onDetach();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CouponListView(Context context) {
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

    public void attach(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f38492g.getLayoutParams().height = i2;
            m();
        }
    }

    public void enter(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null || this.o || !this.f38494i) {
            return;
        }
        this.o = true;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_X, 0.0f, view.getMeasuredWidth() * (-1));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f38493h, AnimationProperty.TRANSLATE_X, view.getMeasuredWidth(), 0.0f);
        animatorSet.setDuration(160L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new f(this));
    }

    public a.C0119a getSelectedItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m : (a.C0119a) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f38494i) {
            return;
        }
        this.f38494i = true;
        if (getContext() instanceof Activity) {
            View findViewById = ((Activity) getContext()).findViewById(16908290);
            if (findViewById instanceof ViewGroup) {
                ((ViewGroup) findViewById).addView(this);
            }
            c.a.f0.r.h.g("CouponListView->attach()");
            return;
        }
        throw new IllegalStateException("can not attach to context " + getContext());
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f38494i) {
            this.f38494i = false;
            if (getParent() instanceof ViewGroup) {
                ((ViewGroup) getParent()).removeView(this);
            }
            h hVar = this.f38495j;
            if (hVar != null) {
                hVar.onDetach();
            }
            c.a.f0.r.h.g("CouponListView->detach()");
        }
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            LayoutInflater.from(context).inflate(c.a.f0.h.coupon_list, (ViewGroup) this, true);
            this.f38492g = (PolyFrameLayout) findViewById(c.a.f0.g.root_layout);
            this.f38493h = (ViewGroup) findViewById(c.a.f0.g.coupon_layout);
            this.f38491f = (ListView) findViewById(c.a.f0.g.coupon_list_layout);
            View findViewById = findViewById(c.a.f0.g.back);
            this.f38490e = findViewById;
            findViewById.setOnClickListener(new b(this));
            setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public boolean onBackPressed() {
        InterceptResult invokeV;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.o && this.f38494i && (hVar = this.f38495j) != null) {
                hVar.c(false, this.m);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void p(a.C0119a c0119a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, c0119a) == null) || this.f38495j == null) {
            return;
        }
        this.f38492g.interceptTouchEvent(true);
        postDelayed(this.p, 500L);
        this.f38495j.b(c0119a, new e(this, c0119a));
    }

    public void quit(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) || view == null || this.o || !this.f38494i) {
            return;
        }
        this.o = true;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_X, view.getMeasuredWidth() * (-1), 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f38493h, AnimationProperty.TRANSLATE_X, 0.0f, view.getMeasuredWidth());
        animatorSet.setDuration(160L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new g(this));
    }

    public void setListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, hVar) == null) {
            this.f38495j = hVar;
        }
    }

    public void update(List<a.C0119a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.l = list;
            if (this.f38496k == null) {
                this.f38496k = new c.a.f0.t.c.b(getContext());
            }
            this.f38491f.setAdapter((ListAdapter) this.f38496k);
            this.f38496k.c(this.l);
            List<a.C0119a> list2 = this.l;
            if (list2 != null && list2.size() > 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.l.size()) {
                        break;
                    } else if (this.l.get(i2).f3266h == 1) {
                        this.m = this.l.get(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
                this.f38491f.setOnItemClickListener(new d(this));
            } else if (this.f38495j == null || !this.f38494i) {
            } else {
                postDelayed(new c(this), 100L);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CouponListView(Context context, AttributeSet attributeSet) {
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
    public CouponListView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f38494i = false;
        this.o = false;
        this.p = new a(this);
        o(context);
    }
}
