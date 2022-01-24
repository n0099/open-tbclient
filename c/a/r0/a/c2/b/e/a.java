package c.a.r0.a.c2.b.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import c.a.r0.a.c2.b.e.b;
import c.a.r0.a.i;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View a;

    /* renamed from: b  reason: collision with root package name */
    public Context f5575b;

    /* renamed from: c  reason: collision with root package name */
    public Resources f5576c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.r0.a.c2.b.e.b> f5577d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.a.c2.b.e.c f5578e;

    /* renamed from: f  reason: collision with root package name */
    public b.a f5579f;

    /* renamed from: g  reason: collision with root package name */
    public PopupWindow f5580g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnKeyListener f5581h;

    /* renamed from: i  reason: collision with root package name */
    public int f5582i;

    /* renamed from: j  reason: collision with root package name */
    public View f5583j;
    public boolean k;
    public f l;
    public boolean m;
    public float n;
    public boolean o;
    public int p;
    public boolean q;
    public Runnable r;

    /* renamed from: c.a.r0.a.c2.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0296a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0296a(a aVar) {
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

        @Override // c.a.r0.a.c2.b.e.b.a
        public void a(c.a.r0.a.c2.b.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (bVar.f()) {
                    this.a.k(bVar.a());
                }
                b.a aVar = this.a.f5579f;
                if (aVar != null) {
                    aVar.a(bVar);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5584e;

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
            this.f5584e = aVar;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i2, keyEvent)) == null) {
                if (keyEvent.getAction() == 1) {
                    if (i2 == 4 || i2 == 82) {
                        this.f5584e.j();
                        View.OnKeyListener onKeyListener = this.f5584e.f5581h;
                        if (onKeyListener != null) {
                            onKeyListener.onKey(view, i2, keyEvent);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5585e;

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
            this.f5585e = aVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f5585e.m) {
                    this.f5585e.h();
                }
                c.a.r0.a.c2.b.e.c cVar = this.f5585e.f5578e;
                if (cVar != null) {
                    cVar.onDismissMenu();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5586e;

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
            this.f5586e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f5586e.m) {
                        this.f5586e.i(this.f5586e.n);
                    }
                    this.f5586e.u(this.f5586e.f5580g);
                } catch (Exception unused) {
                    boolean z = k.a;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5587e;

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
            this.f5587e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5587e.j();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(List<c.a.r0.a.c2.b.e.b> list);
    }

    /* loaded from: classes.dex */
    public interface g {
    }

    public a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = true;
        this.m = false;
        this.n = 0.5f;
        this.o = false;
        this.p = i.swan_app_pop_window_anim;
        this.r = new e(this);
        this.a = view;
        this.f5575b = view.getContext();
        this.f5576c = this.a.getResources();
        this.f5577d = new ArrayList();
        this.f5582i = -2;
        this.q = c.a.r0.a.c1.a.M().a();
        o(this.f5575b);
    }

    public c.a.r0.a.c2.b.e.b e(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) ? f(i2, this.f5576c.getString(i3), null) : (c.a.r0.a.c2.b.e.b) invokeII.objValue;
    }

    public c.a.r0.a.c2.b.e.b f(int i2, CharSequence charSequence, Drawable drawable) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, charSequence, drawable)) == null) {
            c.a.r0.a.c2.b.e.b bVar = new c.a.r0.a.c2.b.e.b(this.f5575b, i2, charSequence, drawable);
            g(bVar);
            return bVar;
        }
        return (c.a.r0.a.c2.b.e.b) invokeILL.objValue;
    }

    public c.a.r0.a.c2.b.e.b g(c.a.r0.a.c2.b.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            bVar.h(this);
            if (this.k) {
                bVar.i(new C0296a(this));
            } else {
                bVar.i(this.f5579f);
            }
            this.f5577d.add(bVar);
            return bVar;
        }
        return (c.a.r0.a.c2.b.e.b) invokeL.objValue;
    }

    public final void h() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (view = this.a) == null) {
            return;
        }
        ((ViewGroup) view.getRootView()).getOverlay().clear();
    }

    public final void i(float f2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048580, this, f2) == null) || (view = this.a) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view.getRootView();
        ColorDrawable colorDrawable = new ColorDrawable(-16777216);
        colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        colorDrawable.setAlpha((int) (f2 * 255.0f));
        viewGroup.getOverlay().add(colorDrawable);
    }

    public void j() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (popupWindow = this.f5580g) == null) {
            return;
        }
        try {
            popupWindow.dismiss();
        } catch (Exception unused) {
            boolean z = k.a;
        }
    }

    public void k(long j2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) || (view = this.a) == null) {
            return;
        }
        view.removeCallbacks(this.r);
        if (j2 > 0) {
            this.a.postDelayed(this.r, j2);
        } else {
            j();
        }
    }

    public abstract void l(View view, List<c.a.r0.a.c2.b.e.b> list);

    public abstract View m(Context context);

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PopupWindow popupWindow = this.f5580g;
            return popupWindow != null && popupWindow.isShowing();
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            View m = m(context);
            this.f5583j = m;
            m.setFocusable(true);
            this.f5583j.setFocusableInTouchMode(true);
            if (!(this.f5583j instanceof g) && k.a) {
                throw new IllegalArgumentException("The view returned by getMenuView() MUST implement OnMenuSetChangedListener!");
            }
            this.f5583j.setOnKeyListener(new b(this));
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.m = z;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.o = z;
        }
    }

    public void r(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.f5579f = aVar;
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f5582i = i2;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (c.a.r0.a.c1.a.M().a() != this.q) {
                o(this.f5575b);
                this.f5580g = null;
            }
            v(true);
            this.q = c.a.r0.a.c1.a.M().a();
        }
    }

    public abstract void u(PopupWindow popupWindow);

    public final void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            c.a.r0.a.c2.b.e.c cVar = this.f5578e;
            if (cVar != null) {
                cVar.onShowMenu();
            }
            w(this.f5577d);
            l(this.f5583j, this.f5577d);
            j();
            if (this.f5580g == null) {
                PopupWindow popupWindow = new PopupWindow(this.f5583j, this.f5582i, -2, true);
                this.f5580g = popupWindow;
                if (this.o) {
                    popupWindow.setAnimationStyle(this.p);
                }
                if (z) {
                    this.f5580g.setBackgroundDrawable(this.f5576c.getDrawable(c.a.r0.a.e.aiapps_pop_transparent_bg));
                    this.f5580g.setTouchable(true);
                } else {
                    this.f5580g.setTouchable(false);
                }
                this.f5580g.setOnDismissListener(new c(this));
            }
            View view = this.a;
            if (view == null) {
                c.a.r0.a.c2.b.e.c cVar2 = this.f5578e;
                if (cVar2 != null) {
                    cVar2.onDismissMenu();
                    return;
                }
                return;
            }
            view.post(new d(this));
            this.f5583j.postInvalidate();
        }
    }

    public void w(List<c.a.r0.a.c2.b.e.b> list) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, list) == null) || (fVar = this.l) == null) {
            return;
        }
        fVar.a(list);
    }
}
