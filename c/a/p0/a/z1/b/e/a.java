package c.a.p0.a.z1.b.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import c.a.p0.a.i;
import c.a.p0.a.k;
import c.a.p0.a.z1.b.e.b;
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

    /* renamed from: a  reason: collision with root package name */
    public final View f10003a;

    /* renamed from: b  reason: collision with root package name */
    public Context f10004b;

    /* renamed from: c  reason: collision with root package name */
    public Resources f10005c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.p0.a.z1.b.e.b> f10006d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.a.z1.b.e.c f10007e;

    /* renamed from: f  reason: collision with root package name */
    public b.a f10008f;

    /* renamed from: g  reason: collision with root package name */
    public PopupWindow f10009g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnKeyListener f10010h;

    /* renamed from: i  reason: collision with root package name */
    public int f10011i;

    /* renamed from: j  reason: collision with root package name */
    public View f10012j;
    public boolean k;
    public f l;
    public boolean m;
    public float n;
    public boolean o;
    public int p;
    public boolean q;
    public Runnable r;

    /* renamed from: c.a.p0.a.z1.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0484a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10013a;

        public C0484a(a aVar) {
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
            this.f10013a = aVar;
        }

        @Override // c.a.p0.a.z1.b.e.b.a
        public void a(c.a.p0.a.z1.b.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (bVar.f()) {
                    this.f10013a.k(bVar.a());
                }
                b.a aVar = this.f10013a.f10008f;
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
        public final /* synthetic */ a f10014e;

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
            this.f10014e = aVar;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i2, keyEvent)) == null) {
                if (keyEvent.getAction() == 1) {
                    if (i2 == 4 || i2 == 82) {
                        this.f10014e.j();
                        View.OnKeyListener onKeyListener = this.f10014e.f10010h;
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
        public final /* synthetic */ a f10015e;

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
            this.f10015e = aVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10015e.m) {
                    this.f10015e.h();
                }
                c.a.p0.a.z1.b.e.c cVar = this.f10015e.f10007e;
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
        public final /* synthetic */ a f10016e;

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
            this.f10016e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f10016e.m) {
                        this.f10016e.i(this.f10016e.n);
                    }
                    this.f10016e.u(this.f10016e.f10009g);
                } catch (Exception unused) {
                    boolean z = k.f7077a;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10017e;

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
            this.f10017e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10017e.j();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(List<c.a.p0.a.z1.b.e.b> list);
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
        this.f10003a = view;
        this.f10004b = view.getContext();
        this.f10005c = this.f10003a.getResources();
        this.f10006d = new ArrayList();
        this.f10011i = -2;
        this.q = c.a.p0.a.c1.a.H().a();
        o(this.f10004b);
    }

    public c.a.p0.a.z1.b.e.b e(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) ? f(i2, this.f10005c.getString(i3), null) : (c.a.p0.a.z1.b.e.b) invokeII.objValue;
    }

    public c.a.p0.a.z1.b.e.b f(int i2, CharSequence charSequence, Drawable drawable) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, charSequence, drawable)) == null) {
            c.a.p0.a.z1.b.e.b bVar = new c.a.p0.a.z1.b.e.b(this.f10004b, i2, charSequence, drawable);
            g(bVar);
            return bVar;
        }
        return (c.a.p0.a.z1.b.e.b) invokeILL.objValue;
    }

    public c.a.p0.a.z1.b.e.b g(c.a.p0.a.z1.b.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            bVar.h(this);
            if (this.k) {
                bVar.i(new C0484a(this));
            } else {
                bVar.i(this.f10008f);
            }
            this.f10006d.add(bVar);
            return bVar;
        }
        return (c.a.p0.a.z1.b.e.b) invokeL.objValue;
    }

    public final void h() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (view = this.f10003a) == null) {
            return;
        }
        ((ViewGroup) view.getRootView()).getOverlay().clear();
    }

    public final void i(float f2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048580, this, f2) == null) || (view = this.f10003a) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (popupWindow = this.f10009g) == null) {
            return;
        }
        try {
            popupWindow.dismiss();
        } catch (Exception unused) {
            boolean z = k.f7077a;
        }
    }

    public void k(long j2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) || (view = this.f10003a) == null) {
            return;
        }
        view.removeCallbacks(this.r);
        if (j2 > 0) {
            this.f10003a.postDelayed(this.r, j2);
        } else {
            j();
        }
    }

    public abstract void l(View view, List<c.a.p0.a.z1.b.e.b> list);

    public abstract View m(Context context);

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PopupWindow popupWindow = this.f10009g;
            return popupWindow != null && popupWindow.isShowing();
        }
        return invokeV.booleanValue;
    }

    public void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            View m = m(context);
            this.f10012j = m;
            m.setFocusable(true);
            this.f10012j.setFocusableInTouchMode(true);
            if (!(this.f10012j instanceof g) && k.f7077a) {
                throw new IllegalArgumentException("The view returned by getMenuView() MUST implement OnMenuSetChangedListener!");
            }
            this.f10012j.setOnKeyListener(new b(this));
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
            this.f10008f = aVar;
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f10011i = i2;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (c.a.p0.a.c1.a.H().a() != this.q) {
                o(this.f10004b);
                this.f10009g = null;
            }
            v(true);
            this.q = c.a.p0.a.c1.a.H().a();
        }
    }

    public abstract void u(PopupWindow popupWindow);

    public final void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            c.a.p0.a.z1.b.e.c cVar = this.f10007e;
            if (cVar != null) {
                cVar.onShowMenu();
            }
            w(this.f10006d);
            l(this.f10012j, this.f10006d);
            j();
            if (this.f10009g == null) {
                PopupWindow popupWindow = new PopupWindow(this.f10012j, this.f10011i, -2, true);
                this.f10009g = popupWindow;
                if (this.o) {
                    popupWindow.setAnimationStyle(this.p);
                }
                if (z) {
                    this.f10009g.setBackgroundDrawable(this.f10005c.getDrawable(c.a.p0.a.e.aiapps_pop_transparent_bg));
                    this.f10009g.setTouchable(true);
                } else {
                    this.f10009g.setTouchable(false);
                }
                this.f10009g.setOnDismissListener(new c(this));
            }
            View view = this.f10003a;
            if (view == null) {
                c.a.p0.a.z1.b.e.c cVar2 = this.f10007e;
                if (cVar2 != null) {
                    cVar2.onDismissMenu();
                    return;
                }
                return;
            }
            view.post(new d(this));
            this.f10012j.postInvalidate();
        }
    }

    public void w(List<c.a.p0.a.z1.b.e.b> list) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, list) == null) || (fVar = this.l) == null) {
            return;
        }
        fVar.a(list);
    }
}
