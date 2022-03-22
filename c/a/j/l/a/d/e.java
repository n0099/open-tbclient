package c.a.j.l.a.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
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
    public WindowManager f3281b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f3282c;

    /* renamed from: d  reason: collision with root package name */
    public View f3283d;

    /* renamed from: e  reason: collision with root package name */
    public View f3284e;

    /* renamed from: f  reason: collision with root package name */
    public WindowManager.LayoutParams f3285f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f3286g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f3287h;
    public Runnable i;
    public boolean j;
    public View k;
    public View l;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f3283d != null) {
                    if (this.a.f3283d.getParent() != null) {
                        this.a.f3281b.removeView(this.a.f3283d);
                    }
                    this.a.f3283d = null;
                }
                if (this.a.k != null) {
                    if (this.a.k.getParent() != null) {
                        this.a.f3281b.removeView(this.a.k);
                    }
                    this.a.k = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a.j) {
                        if (this.a.k != null && (this.a.k.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) this.a.k.getParent()).removeView(this.a.k);
                        }
                        WindowManager.LayoutParams m = this.a.m();
                        this.a.l = new FrameLayout(this.a.a);
                        this.a.l.setClickable(true);
                        this.a.f3281b.addView(this.a.l, m);
                        this.a.k = this.a.l;
                    }
                    if (this.a.f3284e != null && (this.a.f3284e.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.a.f3284e.getParent()).removeView(this.a.f3284e);
                    }
                    this.a.f3281b.addView(this.a.f3284e, this.a.f3285f);
                    this.a.f3283d = this.a.f3284e;
                    this.a.f3286g.postDelayed(this.a.i, this.a.f3282c * 1000);
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
        public final /* synthetic */ e a;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a.f3283d != null) {
                        if (this.a.f3283d.getParent() != null) {
                            this.a.f3281b.removeViewImmediate(this.a.f3283d);
                        }
                        this.a.f3283d = null;
                    }
                    if (this.a.k != null) {
                        if (this.a.k.getParent() != null) {
                            this.a.f3281b.removeViewImmediate(this.a.k);
                        }
                        this.a.k = null;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.f3281b = (WindowManager) context.getSystemService("window");
        this.f3286g = new Handler(Looper.getMainLooper());
        this.i = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f3285f = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.obfuscated_res_0x7f10040f;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f3285f;
        layoutParams2.flags = w0.d0;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f3282c = 2;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Runnable runnable = this.f3287h;
            if (runnable != null) {
                this.f3286g.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.f3287h = bVar;
            this.f3286g.post(bVar);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (i <= 0) {
                i = 2;
            }
            this.f3282c = i;
        }
    }

    public void e(int i, int i2, int i3) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3) == null) || (layoutParams = this.f3285f) == null) {
            return;
        }
        layoutParams.gravity = i;
        layoutParams.x = i2;
        layoutParams.y = i3;
    }

    public void f(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f3284e = view;
            view.setClickable(true);
        }
    }

    public void i() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (handler = this.f3286g) == null) {
            return;
        }
        handler.post(new c(this));
        this.f3286g.removeCallbacks(this.i);
    }

    public void j(int i) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (layoutParams = this.f3285f) == null) {
            return;
        }
        layoutParams.windowAnimations = i;
    }

    public final WindowManager.LayoutParams m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.verticalMargin = c.a.j.l.a.d.b.m(this.a);
            layoutParams.flags = 2176;
            layoutParams.type = 2005;
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeV.objValue;
    }

    public void n(int i) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (layoutParams = this.f3285f) == null) {
            return;
        }
        layoutParams.type = i;
    }
}
