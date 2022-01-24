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
import c.a.h0.i;
import c.a.h0.s.e.a;
import c.a.h0.t.c.a;
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
/* loaded from: classes10.dex */
public class CouponListView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f37870e;

    /* renamed from: f  reason: collision with root package name */
    public ListView f37871f;

    /* renamed from: g  reason: collision with root package name */
    public PolyFrameLayout f37872g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f37873h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f37874i;

    /* renamed from: j  reason: collision with root package name */
    public h f37875j;
    public c.a.h0.t.c.b k;
    public List<a.C0161a> l;
    public a.C0161a m;
    public ToastLoadingView n;
    public boolean o;
    public Runnable p;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CouponListView f37876e;

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
            this.f37876e = couponListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                CouponListView couponListView = this.f37876e;
                couponListView.n = c.a.h0.t.e.a.c(couponListView.f37872g, layoutParams, "加载中", -1L);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CouponListView f37877e;

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
            this.f37877e = couponListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f37877e.f37875j == null) {
                return;
            }
            this.f37877e.f37875j.c(false, this.f37877e.m);
        }
    }

    /* loaded from: classes10.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CouponListView f37878e;

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
            this.f37878e = couponListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f37878e.f37875j.c(false, this.f37878e.m);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CouponListView f37879e;

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
            this.f37879e = couponListView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || ((a.C0161a) this.f37879e.l.get(i2)).f3829h == 1) {
                return;
            }
            CouponListView couponListView = this.f37879e;
            couponListView.p((a.C0161a) couponListView.l.get(i2));
        }
    }

    /* loaded from: classes10.dex */
    public class e implements c.a.h0.s.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.C0161a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CouponListView f37880b;

        /* loaded from: classes10.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PopupWindow f37881e;

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
                this.f37881e = popupWindow;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f37881e.n();
                }
            }
        }

        /* loaded from: classes10.dex */
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
                    this.a.f37880b.f37875j.a();
                }
            }
        }

        public e(CouponListView couponListView, a.C0161a c0161a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {couponListView, c0161a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37880b = couponListView;
            this.a = c0161a;
        }

        @Override // c.a.h0.s.e.a
        public void a(a.C0158a c0158a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c0158a) == null) {
                this.f37880b.f37872g.interceptTouchEvent(false);
                CouponListView couponListView = this.f37880b;
                couponListView.removeCallbacks(couponListView.p);
                c.a.h0.t.e.a.b(this.f37880b.n);
                this.f37880b.n = null;
                if (c0158a == null) {
                    return;
                }
                int i2 = c0158a.a;
                if (i2 == 0) {
                    for (a.C0161a c0161a : this.f37880b.l) {
                        if (c0161a == this.a) {
                            this.f37880b.m = c0161a;
                            c0161a.f3829h = 1;
                        } else {
                            c0161a.f3829h = 0;
                        }
                    }
                    this.f37880b.k.notifyDataSetChanged();
                    this.f37880b.f37875j.c(true, this.a);
                } else if (i2 == 1) {
                    View inflate = View.inflate(this.f37880b.getContext(), c.a.h0.h.default_pop_window, null);
                    PopupWindow popupWindow = new PopupWindow(inflate, -1, -1, true);
                    ((TextView) inflate.findViewById(c.a.h0.g.pop_tips)).setText(c0158a.f3809b);
                    ((TextView) inflate.findViewById(c.a.h0.g.pop_button)).setOnClickListener(new a(this, popupWindow));
                    popupWindow.A(new b(this));
                    popupWindow.D(this.f37880b, 0, 0, 0);
                } else {
                    Toast.makeText(this.f37880b.getContext(), this.f37880b.getResources().getString(i.coupon_calculate_error), 0).show();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class f implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CouponListView f37882e;

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
            this.f37882e = couponListView;
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
                this.f37882e.o = false;
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

    /* loaded from: classes10.dex */
    public class g implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CouponListView f37883e;

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
            this.f37883e = couponListView;
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
                this.f37883e.o = false;
                this.f37883e.n();
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

    /* loaded from: classes10.dex */
    public interface h {
        void a();

        void b(a.C0161a c0161a, c.a.h0.s.e.a aVar);

        void c(boolean z, a.C0161a c0161a);

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
            this.f37872g.getLayoutParams().height = i2;
            m();
        }
    }

    public void enter(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null || this.o || !this.f37874i) {
            return;
        }
        this.o = true;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_X, 0.0f, view.getMeasuredWidth() * (-1));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f37873h, AnimationProperty.TRANSLATE_X, view.getMeasuredWidth(), 0.0f);
        animatorSet.setDuration(160L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new f(this));
    }

    public a.C0161a getSelectedItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m : (a.C0161a) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f37874i) {
            return;
        }
        this.f37874i = true;
        if (getContext() instanceof Activity) {
            View findViewById = ((Activity) getContext()).findViewById(16908290);
            if (findViewById instanceof ViewGroup) {
                ((ViewGroup) findViewById).addView(this);
            }
            c.a.h0.r.h.g("CouponListView->attach()");
            return;
        }
        throw new IllegalStateException("can not attach to context " + getContext());
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f37874i) {
            this.f37874i = false;
            if (getParent() instanceof ViewGroup) {
                ((ViewGroup) getParent()).removeView(this);
            }
            h hVar = this.f37875j;
            if (hVar != null) {
                hVar.onDetach();
            }
            c.a.h0.r.h.g("CouponListView->detach()");
        }
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            LayoutInflater.from(context).inflate(c.a.h0.h.coupon_list, (ViewGroup) this, true);
            this.f37872g = (PolyFrameLayout) findViewById(c.a.h0.g.root_layout);
            this.f37873h = (ViewGroup) findViewById(c.a.h0.g.coupon_layout);
            this.f37871f = (ListView) findViewById(c.a.h0.g.coupon_list_layout);
            View findViewById = findViewById(c.a.h0.g.back);
            this.f37870e = findViewById;
            findViewById.setOnClickListener(new b(this));
            setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public boolean onBackPressed() {
        InterceptResult invokeV;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.o && this.f37874i && (hVar = this.f37875j) != null) {
                hVar.c(false, this.m);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void p(a.C0161a c0161a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, c0161a) == null) || this.f37875j == null) {
            return;
        }
        this.f37872g.interceptTouchEvent(true);
        postDelayed(this.p, 500L);
        this.f37875j.b(c0161a, new e(this, c0161a));
    }

    public void quit(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) || view == null || this.o || !this.f37874i) {
            return;
        }
        this.o = true;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_X, view.getMeasuredWidth() * (-1), 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f37873h, AnimationProperty.TRANSLATE_X, 0.0f, view.getMeasuredWidth());
        animatorSet.setDuration(160L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new g(this));
    }

    public void setListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, hVar) == null) {
            this.f37875j = hVar;
        }
    }

    public void update(List<a.C0161a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.l = list;
            if (this.k == null) {
                this.k = new c.a.h0.t.c.b(getContext());
            }
            this.f37871f.setAdapter((ListAdapter) this.k);
            this.k.c(this.l);
            List<a.C0161a> list2 = this.l;
            if (list2 != null && list2.size() > 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.l.size()) {
                        break;
                    } else if (this.l.get(i2).f3829h == 1) {
                        this.m = this.l.get(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
                this.f37871f.setOnItemClickListener(new d(this));
            } else if (this.f37875j == null || !this.f37874i) {
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
        this.f37874i = false;
        this.o = false;
        this.p = new a(this);
        o(context);
    }
}
