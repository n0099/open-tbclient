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
    public WindowManager f4187b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f4188c;

    /* renamed from: d  reason: collision with root package name */
    public View f4189d;

    /* renamed from: e  reason: collision with root package name */
    public View f4190e;

    /* renamed from: f  reason: collision with root package name */
    public WindowManager.LayoutParams f4191f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f4192g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f4193h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f4194i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4195j;
    public View k;
    public View l;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f4196e;

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
            this.f4196e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f4196e.f4189d != null) {
                    if (this.f4196e.f4189d.getParent() != null) {
                        this.f4196e.f4187b.removeView(this.f4196e.f4189d);
                    }
                    this.f4196e.f4189d = null;
                }
                if (this.f4196e.k != null) {
                    if (this.f4196e.k.getParent() != null) {
                        this.f4196e.f4187b.removeView(this.f4196e.k);
                    }
                    this.f4196e.k = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f4197e;

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
            this.f4197e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f4197e.f4195j) {
                        if (this.f4197e.k != null && (this.f4197e.k.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) this.f4197e.k.getParent()).removeView(this.f4197e.k);
                        }
                        WindowManager.LayoutParams m = this.f4197e.m();
                        this.f4197e.l = new FrameLayout(this.f4197e.a);
                        this.f4197e.l.setClickable(true);
                        this.f4197e.f4187b.addView(this.f4197e.l, m);
                        this.f4197e.k = this.f4197e.l;
                    }
                    if (this.f4197e.f4190e != null && (this.f4197e.f4190e.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.f4197e.f4190e.getParent()).removeView(this.f4197e.f4190e);
                    }
                    this.f4197e.f4187b.addView(this.f4197e.f4190e, this.f4197e.f4191f);
                    this.f4197e.f4189d = this.f4197e.f4190e;
                    this.f4197e.f4192g.postDelayed(this.f4197e.f4194i, this.f4197e.f4188c * 1000);
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
        public final /* synthetic */ e f4198e;

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
            this.f4198e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f4198e.f4189d != null) {
                        if (this.f4198e.f4189d.getParent() != null) {
                            this.f4198e.f4187b.removeViewImmediate(this.f4198e.f4189d);
                        }
                        this.f4198e.f4189d = null;
                    }
                    if (this.f4198e.k != null) {
                        if (this.f4198e.k.getParent() != null) {
                            this.f4198e.f4187b.removeViewImmediate(this.f4198e.k);
                        }
                        this.f4198e.k = null;
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
        this.f4187b = (WindowManager) context.getSystemService("window");
        this.f4192g = new Handler(Looper.getMainLooper());
        this.f4194i = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f4191f = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = g.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f4191f;
        layoutParams2.flags = w0.d0;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f4188c = 2;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Runnable runnable = this.f4193h;
            if (runnable != null) {
                this.f4192g.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.f4193h = bVar;
            this.f4192g.post(bVar);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 <= 0) {
                i2 = 2;
            }
            this.f4188c = i2;
        }
    }

    public void e(int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4) == null) || (layoutParams = this.f4191f) == null) {
            return;
        }
        layoutParams.gravity = i2;
        layoutParams.x = i3;
        layoutParams.y = i4;
    }

    public void f(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f4190e = view;
            view.setClickable(true);
        }
    }

    public void i() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (handler = this.f4192g) == null) {
            return;
        }
        handler.post(new c(this));
        this.f4192g.removeCallbacks(this.f4194i);
    }

    public void j(int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (layoutParams = this.f4191f) == null) {
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
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (layoutParams = this.f4191f) == null) {
            return;
        }
        layoutParams.type = i2;
    }
}
