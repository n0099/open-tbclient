package c.a.r0.f1.q.a.f;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f12532e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f12533f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f12534g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f12535h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.f1.q.a.c.a f12536i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.f1.q.a.d.c f12537j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f12538k;
    public Animation l;
    public Animation m;
    public boolean n;
    public int o;
    public Dialog p;
    public View q;
    public boolean r;
    public View.OnKeyListener s;
    public final View.OnTouchListener t;

    /* renamed from: c.a.r0.f1.q.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0811a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f12539e;

        public View$OnClickListenerC0811a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12539e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f12539e.f();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.h();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f12540e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12540e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f12540e;
                aVar.f12536i.y.removeView(aVar.f12534g);
                this.f12540e.n = false;
                this.f12540e.f12538k = false;
                if (this.f12540e.f12537j != null) {
                    this.f12540e.f12537j.a(this.f12540e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f12541e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12541e = aVar;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i2, keyEvent)) == null) {
                if (i2 == 4 && keyEvent.getAction() == 0 && this.f12541e.p()) {
                    this.f12541e.f();
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f12542e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12542e = aVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    this.f12542e.f();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f12543e;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12543e = aVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || this.f12543e.f12537j == null) {
                return;
            }
            this.f12543e.f12537j.a(this.f12543e);
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 80;
        this.r = true;
        this.s = new d(this);
        this.t = new e(this);
        this.f12532e = context;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f12535h == null) {
            return;
        }
        Dialog dialog = new Dialog(this.f12532e, R.style.custom_dialog2);
        this.p = dialog;
        dialog.setCancelable(this.f12536i.S);
        this.p.setContentView(this.f12535h);
        Window window = this.p.getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.picker_view_scale_anim);
            window.setGravity(17);
        }
        this.p.setOnDismissListener(new f(this));
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (o()) {
                g();
            } else if (this.f12538k) {
            } else {
                if (this.r) {
                    this.l.setAnimationListener(new b(this));
                    this.f12533f.startAnimation(this.l);
                } else {
                    h();
                }
                this.f12538k = true;
            }
        }
    }

    public final void g() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (dialog = this.p) == null) {
            return;
        }
        dialog.dismiss();
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f12536i.y.post(new c(this));
        }
    }

    public View i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f12533f.findViewById(i2) : (View) invokeI.objValue;
    }

    public Dialog j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.p : (Dialog) invokeV.objValue;
    }

    public final Animation k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? AnimationUtils.loadAnimation(this.f12532e, c.a.r0.f1.q.a.e.c.a(this.o, true)) : (Animation) invokeV.objValue;
    }

    public final Animation l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? AnimationUtils.loadAnimation(this.f12532e, c.a.r0.f1.q.a.e.c.a(this.o, false)) : (Animation) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m = k();
            this.l = l();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
            LayoutInflater from = LayoutInflater.from(this.f12532e);
            if (o()) {
                ViewGroup viewGroup = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
                this.f12535h = viewGroup;
                viewGroup.setBackgroundColor(0);
                ViewGroup viewGroup2 = (ViewGroup) this.f12535h.findViewById(R.id.content_container);
                this.f12533f = viewGroup2;
                layoutParams.leftMargin = 30;
                layoutParams.rightMargin = 30;
                viewGroup2.setLayoutParams(layoutParams);
                e();
                this.f12535h.setOnClickListener(new View$OnClickListenerC0811a(this));
            } else {
                c.a.r0.f1.q.a.c.a aVar = this.f12536i;
                if (aVar.y == null) {
                    aVar.y = (ViewGroup) ((Activity) this.f12532e).getWindow().getDecorView();
                }
                ViewGroup viewGroup3 = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.f12536i.y, false);
                this.f12534g = viewGroup3;
                viewGroup3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                int i2 = this.f12536i.P;
                if (i2 != -1) {
                    this.f12534g.setBackgroundColor(i2);
                }
                ViewGroup viewGroup4 = (ViewGroup) this.f12534g.findViewById(R.id.content_container);
                this.f12533f = viewGroup4;
                viewGroup4.setLayoutParams(layoutParams);
            }
            s(true);
        }
    }

    public abstract boolean o();

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (o()) {
                return false;
            }
            return this.f12534g.getParent() != null || this.n;
        }
        return invokeV.booleanValue;
    }

    public final void q(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            this.f12536i.y.addView(view);
            if (this.r) {
                this.f12533f.startAnimation(this.m);
            }
        }
    }

    public void r() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (dialog = this.p) == null) {
            return;
        }
        dialog.setCancelable(this.f12536i.S);
    }

    public void s(boolean z) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (o()) {
                viewGroup = this.f12535h;
            } else {
                viewGroup = this.f12534g;
            }
            viewGroup.setFocusable(z);
            viewGroup.setFocusableInTouchMode(z);
            if (z) {
                viewGroup.setOnKeyListener(this.s);
            } else {
                viewGroup.setOnKeyListener(null);
            }
        }
    }

    public a t(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            ViewGroup viewGroup = this.f12534g;
            if (viewGroup != null) {
                View findViewById = viewGroup.findViewById(R.id.outmost_container);
                if (z) {
                    findViewById.setOnTouchListener(this.t);
                } else {
                    findViewById.setOnTouchListener(null);
                }
            }
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (o()) {
                v();
            } else if (p()) {
            } else {
                this.n = true;
                q(this.f12534g);
                this.f12534g.requestFocus();
            }
        }
    }

    public final void v() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (dialog = this.p) == null) {
            return;
        }
        dialog.show();
    }
}
