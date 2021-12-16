package c.a.j.l.h.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import c.a.j.l.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public WindowManager f3682b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f3683c;

    /* renamed from: d  reason: collision with root package name */
    public View f3684d;

    /* renamed from: e  reason: collision with root package name */
    public View f3685e;

    /* renamed from: f  reason: collision with root package name */
    public WindowManager.LayoutParams f3686f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f3687g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f3688h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f3689i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3690j;

    /* renamed from: k  reason: collision with root package name */
    public View f3691k;
    public View l;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f3692e;

        public a(e eVar) {
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
            this.f3692e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f3692e.f3684d != null) {
                    if (this.f3692e.f3684d.getParent() != null) {
                        this.f3692e.f3682b.removeView(this.f3692e.f3684d);
                    }
                    this.f3692e.f3684d = null;
                }
                if (this.f3692e.f3691k != null) {
                    if (this.f3692e.f3691k.getParent() != null) {
                        this.f3692e.f3682b.removeView(this.f3692e.f3691k);
                    }
                    this.f3692e.f3691k = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f3693e;

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
            this.f3693e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f3693e.f3690j) {
                        if (this.f3693e.f3691k != null && (this.f3693e.f3691k.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) this.f3693e.f3691k.getParent()).removeView(this.f3693e.f3691k);
                        }
                        WindowManager.LayoutParams m = this.f3693e.m();
                        this.f3693e.l = new FrameLayout(this.f3693e.a);
                        this.f3693e.l.setClickable(true);
                        this.f3693e.f3682b.addView(this.f3693e.l, m);
                        this.f3693e.f3691k = this.f3693e.l;
                    }
                    if (this.f3693e.f3685e != null && (this.f3693e.f3685e.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.f3693e.f3685e.getParent()).removeView(this.f3693e.f3685e);
                    }
                    this.f3693e.f3682b.addView(this.f3693e.f3685e, this.f3693e.f3686f);
                    this.f3693e.f3684d = this.f3693e.f3685e;
                    this.f3693e.f3687g.postDelayed(this.f3693e.f3689i, this.f3693e.f3683c * 1000);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f3694e;

        public c(e eVar) {
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
            this.f3694e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f3694e.f3684d != null) {
                        if (this.f3694e.f3684d.getParent() != null) {
                            this.f3694e.f3682b.removeViewImmediate(this.f3694e.f3684d);
                        }
                        this.f3694e.f3684d = null;
                    }
                    if (this.f3694e.f3691k != null) {
                        if (this.f3694e.f3691k.getParent() != null) {
                            this.f3694e.f3682b.removeViewImmediate(this.f3694e.f3691k);
                        }
                        this.f3694e.f3691k = null;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public e(Context context) {
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
        this.a = context;
        this.f3682b = (WindowManager) context.getSystemService("window");
        this.f3687g = new Handler(Looper.getMainLooper());
        this.f3689i = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f3686f = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = g.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f3686f;
        layoutParams2.flags = w0.d0;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f3683c = 2;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Runnable runnable = this.f3688h;
            if (runnable != null) {
                this.f3687g.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.f3688h = bVar;
            this.f3687g.post(bVar);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 <= 0) {
                i2 = 2;
            }
            this.f3683c = i2;
        }
    }

    public void e(int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4) == null) || (layoutParams = this.f3686f) == null) {
            return;
        }
        layoutParams.gravity = i2;
        layoutParams.x = i3;
        layoutParams.y = i4;
    }

    public void f(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f3685e = view;
            view.setClickable(true);
        }
    }

    public void i() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (handler = this.f3687g) == null) {
            return;
        }
        handler.post(new c(this));
        this.f3687g.removeCallbacks(this.f3689i);
    }

    public void j(int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (layoutParams = this.f3686f) == null) {
            return;
        }
        layoutParams.windowAnimations = i2;
    }

    public final WindowManager.LayoutParams m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.verticalMargin = c.a.j.l.h.d.b.m(this.a);
            layoutParams.flags = 2176;
            layoutParams.type = 2005;
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeV.objValue;
    }

    public void n(int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (layoutParams = this.f3686f) == null) {
            return;
        }
        layoutParams.type = i2;
    }
}
