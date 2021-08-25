package c.a.p0.d1.p.a.f;

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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f13275e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f13276f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f13277g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f13278h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.d1.p.a.c.a f13279i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.d1.p.a.d.c f13280j;
    public boolean k;
    public Animation l;
    public Animation m;
    public boolean n;
    public int o;
    public Dialog p;
    public View q;
    public boolean r;
    public View.OnKeyListener s;
    public final View.OnTouchListener t;

    /* renamed from: c.a.p0.d1.p.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0660a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f13281e;

        public View$OnClickListenerC0660a(a aVar) {
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
            this.f13281e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f13281e.f();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f13282a;

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
            this.f13282a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f13282a.h();
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

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f13283e;

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
            this.f13283e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f13283e;
                aVar.f13279i.y.removeView(aVar.f13277g);
                this.f13283e.n = false;
                this.f13283e.k = false;
                if (this.f13283e.f13280j != null) {
                    this.f13283e.f13280j.a(this.f13283e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f13284e;

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
            this.f13284e = aVar;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i2, keyEvent)) == null) {
                if (i2 == 4 && keyEvent.getAction() == 0 && this.f13284e.p()) {
                    this.f13284e.f();
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f13285e;

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
            this.f13285e = aVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    this.f13285e.f();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f13286e;

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
            this.f13286e = aVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || this.f13286e.f13280j == null) {
                return;
            }
            this.f13286e.f13280j.a(this.f13286e);
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
        this.f13275e = context;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13278h == null) {
            return;
        }
        Dialog dialog = new Dialog(this.f13275e, R.style.custom_dialog2);
        this.p = dialog;
        dialog.setCancelable(this.f13279i.S);
        this.p.setContentView(this.f13278h);
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
            } else if (this.k) {
            } else {
                if (this.r) {
                    this.l.setAnimationListener(new b(this));
                    this.f13276f.startAnimation(this.l);
                } else {
                    h();
                }
                this.k = true;
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
            this.f13279i.y.post(new c(this));
        }
    }

    public View i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f13276f.findViewById(i2) : (View) invokeI.objValue;
    }

    public Dialog j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.p : (Dialog) invokeV.objValue;
    }

    public final Animation k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? AnimationUtils.loadAnimation(this.f13275e, c.a.p0.d1.p.a.e.c.a(this.o, true)) : (Animation) invokeV.objValue;
    }

    public final Animation l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? AnimationUtils.loadAnimation(this.f13275e, c.a.p0.d1.p.a.e.c.a(this.o, false)) : (Animation) invokeV.objValue;
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
            LayoutInflater from = LayoutInflater.from(this.f13275e);
            if (o()) {
                ViewGroup viewGroup = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
                this.f13278h = viewGroup;
                viewGroup.setBackgroundColor(0);
                ViewGroup viewGroup2 = (ViewGroup) this.f13278h.findViewById(R.id.content_container);
                this.f13276f = viewGroup2;
                layoutParams.leftMargin = 30;
                layoutParams.rightMargin = 30;
                viewGroup2.setLayoutParams(layoutParams);
                e();
                this.f13278h.setOnClickListener(new View$OnClickListenerC0660a(this));
            } else {
                c.a.p0.d1.p.a.c.a aVar = this.f13279i;
                if (aVar.y == null) {
                    aVar.y = (ViewGroup) ((Activity) this.f13275e).getWindow().getDecorView();
                }
                ViewGroup viewGroup3 = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.f13279i.y, false);
                this.f13277g = viewGroup3;
                viewGroup3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                int i2 = this.f13279i.P;
                if (i2 != -1) {
                    this.f13277g.setBackgroundColor(i2);
                }
                ViewGroup viewGroup4 = (ViewGroup) this.f13277g.findViewById(R.id.content_container);
                this.f13276f = viewGroup4;
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
            return this.f13277g.getParent() != null || this.n;
        }
        return invokeV.booleanValue;
    }

    public final void q(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            this.f13279i.y.addView(view);
            if (this.r) {
                this.f13276f.startAnimation(this.m);
            }
        }
    }

    public void r() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (dialog = this.p) == null) {
            return;
        }
        dialog.setCancelable(this.f13279i.S);
    }

    public void s(boolean z) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (o()) {
                viewGroup = this.f13278h;
            } else {
                viewGroup = this.f13277g;
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
            ViewGroup viewGroup = this.f13277g;
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
                q(this.f13277g);
                this.f13277g.requestFocus();
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
